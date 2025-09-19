package com.ais.sem.cancel.transfer;

import com.ais.sem.cancel.db.ConnectDb;
import com.ais.sem.cancel.util.FileUtilities;
import com.ais.sem.cancel.util.SFTPUtilities;
import com.ais.sem.cancel.util.Utilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;

public class TextSAPToCancelDocTB {
  private static String system = Utilities.getResources("system");
  
  public static void main(String[] args) throws Exception {
	System.out.println("=================== Begin Process TextSAPToCancelDocTB  ===================");   
    TextSAPToCancelDocTB textToTable = new TextSAPToCancelDocTB();
    textToTable.doProcess();
    System.out.println("=================== End Process TextSAPToCancelDocTB  ==================="); 
  }
  
  public void doProcess() {
    try {
      System.out.println("system = " + system);
      if (system.equalsIgnoreCase("window") || system.equalsIgnoreCase("production")) {
        tranferOnWindow();
      } else if (system.equalsIgnoreCase("linux")) {
        tranferOnLinux();
      } 
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  private void tranferOnWindow() {
    try {
      FileUtilities f = new FileUtilities();
      System.out.println("sap_path = " + FileUtilities.sapPath);
      String maxDate = getLastDateSapCancelDocLogTB();
      String strCurrentDate = Utilities.addDate(Utilities.getCurrentDate(), 0);
      System.out.println("=================");
      System.out.println("strCurrentDate = " + Integer.parseInt(strCurrentDate));
      System.out.println("maxDate = " + Integer.parseInt(maxDate));
      while (Integer.parseInt(maxDate) <= Integer.parseInt(strCurrentDate)) {
        System.out.println("===== while loop date (" + maxDate + ")======");
        String formatFileName = maxDate;
        HashMap hp = getCancelDocLogTB(formatFileName);
        Vector vtFileName = f.getFileNameAll(FileUtilities.sapPath, formatFileName);
        for (int i = 0; i < vtFileName.size(); i++) {
          String filename = vtFileName.get(i).toString();
          System.out.println("hp.get(" + filename + ") : " + hp.get(filename));
          if (hp.get(filename) == null) {
            readDatToCancelDocTBWin(f, filename, "INSERT");
          } else if (!hp.get(filename).toString().equalsIgnoreCase("SUCCESS")) {
            readDatToCancelDocTBWin(f, filename, "UPDATE");
          } 
        } 
        maxDate = Utilities.addDate(Utilities.parseDate(maxDate, "dd/MM/yyyy"), 1);
      } 
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  private void tranferOnLinux() {
    try {
      SFTPUtilities sft = new SFTPUtilities(true);
      String maxDate = getLastDateSapCancelDocLogTB();
      String strCurrentDate = Utilities.addDate(Utilities.getCurrentDate(), 0);
      System.out.println("=================");
      System.out.println("strCurrentDate = " + Integer.parseInt(strCurrentDate));
      System.out.println("maxDate = " + Integer.parseInt(maxDate));
      while (Integer.parseInt(maxDate) <= Integer.parseInt(strCurrentDate)) {
        System.out.println("===== while loop date (" + maxDate + ")======");
        String formatFileName = maxDate;
        HashMap hp = getCancelDocLogTB(formatFileName);
        Vector vtFileName = sft.getFileNameAll(SFTPUtilities.sapPath, formatFileName);
        for (int i = 0; i < vtFileName.size(); i++) {
          String filename = vtFileName.get(i).toString();
          System.out.println("hp.get(" + filename + ") : " + hp.get(filename));
          if (hp.get(filename) == null) {
            readDatToCancelDocTB(sft, filename, "INSERT");
          } else if (!hp.get(filename).toString().equalsIgnoreCase("SUCCESS")) {
            readDatToCancelDocTB(sft, filename, "UPDATE");
          } 
        } 
        maxDate = Utilities.addDate(Utilities.parseDate(maxDate, "dd/MM/yyyy"), 1);
      } 
      sft.disconnect();
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  private String getLastDateSapCancelDocLogTB() throws Exception {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String max_date = Utilities.addDate(Utilities.getCurrentDate(), 0);
    try {
      con = ConnectDb.dbConnectSEM();
      pstmt = con.prepareStatement("select max(t.create_dt) as max_date  from SAP_CANCEL_DOC_LOG t ");
      rs = pstmt.executeQuery();
      if (rs.next())
        max_date = (rs.getDate("max_date") == null) ? Utilities.addDate(Utilities.getCurrentDate(), 0) : Utilities.addDate(rs.getDate("max_date"), 0); 
    } catch (Exception e) {
      System.out.println("error : " + e);
      e.printStackTrace();
    } finally {
      System.out.println("... finally getLastDateSapCancelDocLogTB ...");
      try {
        if (rs != null)
          rs.close(); 
        if (pstmt != null)
          pstmt.close(); 
        if (con != null) {
          con.close();
          System.out.println("... con.close ...");
        } 
      } catch (Exception e) {
        System.out.println("error : " + e);
      } 
    } 
    return max_date;
  }
  
  private HashMap getCancelDocLogTB(String formatFileName) {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    HashMap<Object, Object> hMap = new HashMap<Object, Object>();
    String strSql = "";
    try {
      con = ConnectDb.dbConnectSEM();
      strSql = "select * from SAP_CANCEL_DOC_LOG where FILE_NAME like 'ZFAP109_%_" + formatFileName + "%'";
      pstmt = con.prepareStatement(strSql);
      rs = pstmt.executeQuery();
      while (rs.next())
        hMap.put(rs.getString("FILE_NAME").trim(), rs.getString("STATUS").trim()); 
    } catch (Exception e) {
      System.out.println("error : " + e);
      e.printStackTrace();
    } finally {
      System.out.println("... finally getCancelDocLogTB ...");
      try {
        if (rs != null)
          rs.close(); 
        if (pstmt != null)
          pstmt.close(); 
        if (con != null) {
          con.close();
          System.out.println("... con.close ...");
        } 
      } catch (Exception e) {
        System.out.println("error : " + e);
      } 
    } 
    return hMap;
  }
  
  private void updateCancelDocLogTB(Connection con, String filename, String status, String errorMsg) throws Exception {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    HashMap<Object, Object> hMap = new HashMap<Object, Object>();
    try {
      String query = "update  SAP_CANCEL_DOC_LOG  set STATUS = '" + 
        status.trim() + "',ERROR = '" + errorMsg + "',UPDATE_DT = current_timestamp where FILE_NAME = '" + filename.trim() + "'";
      System.out.println("query = " + query);
      pstmt = con.prepareStatement(query);
      int result = pstmt.executeUpdate();
      System.out.println("result = " + result);
    } catch (Exception ex) {
      if (rs != null)
        rs.close(); 
      if (pstmt != null)
        pstmt.close(); 
      System.out.println("error : " + ex);
      ex.printStackTrace();
      throw ex;
    } finally {
      System.out.println("... finally updateCancelDocLogTB ...");
      if (rs != null)
        rs.close(); 
      if (pstmt != null)
        pstmt.close(); 
    } 
  }
  
  private void insertCancelDocLogTB(Connection con, String filename, String status, String errorMsg) throws Exception {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    HashMap<Object, Object> hMap = new HashMap<Object, Object>();
    try {
      pstmt = con.prepareStatement("insert  into SAP_CANCEL_DOC_LOG(ID,FILE_NAME,STATUS,ERROR,CREATE_DT) values(nextVal('CANCEL_DOC_LOG_SEQ'),?,?,?,current_timestamp)");
      pstmt.setString(1, filename.trim());
      pstmt.setString(2, status.trim());
      pstmt.setString(3, errorMsg);
      pstmt.executeUpdate();
    } catch (Exception ex) {
      if (rs != null)
        rs.close(); 
      if (pstmt != null)
        pstmt.close(); 
      System.out.println("error : " + ex);
      ex.printStackTrace();
      throw ex;
    } finally {
      System.out.println("... finally insertCancelDocLogTB ...");
      if (rs != null)
        rs.close(); 
      if (pstmt != null)
        pstmt.close(); 
    } 
  }
  
  private void readDatToCancelDocTB(SFTPUtilities sftpUtil, String filename, String statusOfCancelLog) throws Exception {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    HashMap<Object, Object> hMap = new HashMap<Object, Object>();
    int record = 0;
    try {
      con = ConnectDb.dbConnectSEM();
      con.setAutoCommit(false);
      Vector vDat = sftpUtil.readLines(SFTPUtilities.sapPath, filename);
      Vector vSyn = sftpUtil.readLines(SFTPUtilities.sapPath, Utilities.cutExtension(filename).concat(".syn").trim());
      if (vSyn != null && vSyn.size() > 0) {
        String vStr = vSyn.elementAt(1).toString();
        Vector v = Utilities.StringSpiltDelim(vStr, "\\|");
        record = Integer.parseInt(v.get(0).toString());
      } 
      if (vDat.size() == record) {
        for (int i = 0; vDat != null && i < vDat.size(); i++) {
          String vStr = vDat.elementAt(i).toString();
          Vector v = Utilities.StringSpiltDelim(vStr, "\\|");
          insertCancelDocTB(con, pstmt, v, filename);
        } 
        if (statusOfCancelLog.equalsIgnoreCase("INSERT")) {
          insertCancelDocLogTB(con, filename, "SUCCESS", "");
        } else if (statusOfCancelLog.equalsIgnoreCase("UPDATE")) {
          updateCancelDocLogTB(con, filename, "SUCCESS", "");
        } 
      } else if (statusOfCancelLog.equalsIgnoreCase("INSERT")) {
        insertCancelDocLogTB(con, filename, "FAIL", "num record in ack not equal in log.");
      } else if (statusOfCancelLog.equalsIgnoreCase("UPDATE")) {
        updateCancelDocLogTB(con, filename, "FAIL", "num record in ack not equal in log.");
      } 
    } catch (Exception e) {
      String errorMsg = getMsgError(e, getClass().getName(), e.getStackTrace()[0].getMethodName());
      Connection conLog = ConnectDb.dbConnectSEM();
      if (statusOfCancelLog.equalsIgnoreCase("INSERT")) {
        insertCancelDocLogTB(conLog, filename, "ERROR", errorMsg);
      } else if (statusOfCancelLog.equalsIgnoreCase("UPDATE")) {
        updateCancelDocLogTB(conLog, filename, "ERROR", errorMsg);
      } 
      conLog.close();
      if (con != null) {
        con.rollback();
        con.close();
        System.out.println("... con.close ...");
        System.out.println("Connection rollback...");
      } 
      System.out.println("error : " + e);
      e.printStackTrace();
    } finally {
      con.commit();
      System.out.println("... finally con.commit ...");
      System.out.println("... finally ReadDatToCancelDocTB ...");
      if (rs != null)
        rs.close(); 
      if (pstmt != null)
        pstmt.close(); 
      if (con != null) {
        con.close();
        System.out.println("... con.close ...");
      } 
    } 
  }
  
  private void readDatToCancelDocTBWin(FileUtilities f, String filename, String statusOfCancelLog) throws Exception {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    HashMap<Object, Object> hMap = new HashMap<Object, Object>();
    int record = 0;
    try {
      con = ConnectDb.dbConnectSEM();
      con.setAutoCommit(false);
      Vector vDat = f.readLines(FileUtilities.sapPath, filename);
      Vector vSyn = f.readLines(FileUtilities.sapPath, Utilities.cutExtension(filename).concat(".syn").trim());
      if (vSyn != null && vSyn.size() > 0) {
        String vStr = vSyn.elementAt(1).toString();
        Vector v = Utilities.StringSpiltDelim(vStr, "\\|");
        record = Integer.parseInt(v.get(0).toString());
      } 
      if (vDat.size() == record) {
        for (int i = 0; vDat != null && i < vDat.size(); i++) {
          String vStr = vDat.elementAt(i).toString();
          Vector v = Utilities.StringSpiltDelim(vStr, "\\|");
          insertCancelDocTB(con, pstmt, v, filename);
        } 
        if (statusOfCancelLog.equalsIgnoreCase("INSERT")) {
          insertCancelDocLogTB(con, filename, "SUCCESS", "");
        } else if (statusOfCancelLog.equalsIgnoreCase("UPDATE")) {
          updateCancelDocLogTB(con, filename, "SUCCESS", "");
        } 
      } else if (statusOfCancelLog.equalsIgnoreCase("INSERT")) {
        insertCancelDocLogTB(con, filename, "FAIL", "num record in ack not equal in log.");
      } else if (statusOfCancelLog.equalsIgnoreCase("UPDATE")) {
        updateCancelDocLogTB(con, filename, "FAIL", "num record in ack not equal in log.");
      } 
    } catch (Exception e) {
      String errorMsg = getMsgError(e, getClass().getName(), e.getStackTrace()[0].getMethodName());
      Connection conLog = ConnectDb.dbConnectSEM();
      if (statusOfCancelLog.equalsIgnoreCase("INSERT")) {
        insertCancelDocLogTB(conLog, filename, "ERROR", errorMsg);
      } else if (statusOfCancelLog.equalsIgnoreCase("UPDATE")) {
        updateCancelDocLogTB(conLog, filename, "ERROR", errorMsg);
      } 
      conLog.close();
      if (con != null) {
        con.rollback();
        con.close();
        System.out.println("... con.close ...");
        System.out.println("Connection rollback...");
      } 
      System.out.println("error : " + e);
      e.printStackTrace();
    } finally {
      con.commit();
      System.out.println("... finally con.commit ...");
      System.out.println("... finally ReadDatToCancelDocTBWin ...");
      if (rs != null)
        rs.close(); 
      if (pstmt != null)
        pstmt.close(); 
      if (con != null) {
        con.close();
        System.out.println("... con.close ...");
      } 
    } 
  }
  
  private void insertCancelDocTB(Connection con, PreparedStatement pstmt, Vector v, String filename) throws Exception {
    pstmt = con
      .prepareStatement("insert  into SAP_CANCEL_DOC(LINENO,COMCOD,DOCNO,DOCYEA,DOCTYP,REFSEM,REFDOC,DOCREV,DOCHEA,DOCDAT, POSDAT,BRACOD,CURCOD,CNCDAT,CNCTIM,CNCBY,CREATE_FILE,CREATE_DT,UPDATE_FILE,UPDATE_DT ) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, current_timestamp, ?, ?)");
    pstmt.setString(1, v.elementAt(0).toString());
    pstmt.setString(2, v.elementAt(1).toString());
    pstmt.setString(3, v.elementAt(2).toString());
    pstmt.setString(4, v.elementAt(3).toString());
    pstmt.setString(5, v.elementAt(4).toString());
    pstmt.setString(6, v.elementAt(5).toString());
    pstmt.setString(7, v.elementAt(6).toString());
    pstmt.setString(8, v.elementAt(7).toString());
    pstmt.setString(9, v.elementAt(8).toString());
    pstmt.setString(10, v.elementAt(9).toString());
    pstmt.setString(11, v.elementAt(10).toString());
    pstmt.setString(12, v.elementAt(11).toString());
    pstmt.setString(13, v.elementAt(12).toString());
    pstmt.setString(14, v.elementAt(13).toString());
    pstmt.setString(15, v.elementAt(14).toString());
    pstmt.setString(16, v.elementAt(14).toString());
    pstmt.setString(17, filename.trim());
    pstmt.setNull(18, 1);
    pstmt.setNull(19, 91);
    pstmt.executeUpdate();
    pstmt.close();
    System.out.println("Insert insertCancelDocTB Complete !!!");
  }
  
  private String getMsgError(Exception err, String className, String methodName) {
    String errorMsg = "[Exception : " + err.getClass().getName() + "] [Cause : " + err.getMessage() + "] [Class : " + className + "] [Method : " + methodName + "]";
    errorMsg = errorMsg.replace("\n", "");
    errorMsg = errorMsg.replace("\"", "\\\"");
    return errorMsg;
  }
}
