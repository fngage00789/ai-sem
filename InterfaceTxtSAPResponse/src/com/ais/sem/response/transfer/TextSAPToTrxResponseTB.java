package com.ais.sem.response.transfer;

import com.ais.sem.response.db.ConnectDb;
import com.ais.sem.response.util.FileUtilities;
import com.ais.sem.response.util.SFTPUtilities;
import com.ais.sem.response.util.Utilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;

public class TextSAPToTrxResponseTB {
  private static String system = Utilities.getResources("system");
  
  public static void main(String[] args) throws Exception {
	System.out.println("=================== Begin Process TextSAPToTrxResponseTB  ==================="); 
    TextSAPToTrxResponseTB textToTable = new TextSAPToTrxResponseTB();
    textToTable.doProcess();
    System.out.println("=================== End Process TextSAPToTrxResponseTB  ===================");
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
      String maxDate = getLastDateSapTrxResponseLogTB();
      String strCurrentDate = Utilities.addDate(Utilities.getCurrentDate(), 0);
      System.out.println("=================");
      System.out.println("strCurrentDate = " + Integer.parseInt(strCurrentDate));
      System.out.println("maxDate = " + Integer.parseInt(maxDate));
      while (Integer.parseInt(maxDate) <= Integer.parseInt(strCurrentDate)) {
        System.out.println("===== while loop date (" + maxDate + ")======");
        String formatFileName = maxDate;
        HashMap hp = getTrxResponseLogTB(formatFileName);
        Vector vtFileName = f.getFileNameAll(FileUtilities.sapPath, formatFileName);
        for (int i = 0; i < vtFileName.size(); i++) {
          String filename = vtFileName.get(i).toString();
          System.out.println("hp.get(" + filename + ") : " + hp.get(filename));
          if (hp.get(filename) == null) {
            readAckToTrxResponseTBWin(f, filename, "INSERT");
          } else if (!hp.get(filename).toString().equalsIgnoreCase("SUCCESS")) {
            readAckToTrxResponseTBWin(f, filename, "UPDATE");
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
      String maxDate = getLastDateSapTrxResponseLogTB();
      String strCurrentDate = Utilities.addDate(Utilities.getCurrentDate(), 0);
      System.out.println("=================");
      System.out.println("strCurrentDate = " + Integer.parseInt(strCurrentDate));
      System.out.println("maxDate = " + Integer.parseInt(maxDate));
      while (Integer.parseInt(maxDate) <= Integer.parseInt(strCurrentDate)) {
        System.out.println("===== while loop date (" + maxDate + ")======");
        String formatFileName = maxDate;
        HashMap hp = getTrxResponseLogTB(formatFileName);
        Vector vtFileName = sft.getFileNameAll(SFTPUtilities.sapPath, formatFileName);
        for (int i = 0; i < vtFileName.size(); i++) {
          String filename = vtFileName.get(i).toString();
          System.out.println("hp.get(" + filename + ") : " + hp.get(filename));
          if (hp.get(filename) == null) {
            readAckToTrxResponseTB(sft, filename, "INSERT");
          } else if (!hp.get(filename).toString().equalsIgnoreCase("SUCCESS")) {
            readAckToTrxResponseTB(sft, filename, "UPDATE");
          } 
        } 
        maxDate = Utilities.addDate(Utilities.parseDate(maxDate, "dd/MM/yyyy"), 1);
      } 
      sft.disconnect();
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  private HashMap getTrxResponseLogTB(String formatFileName) {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    HashMap<Object, Object> hMap = new HashMap<Object, Object>();
    String strSql = "";
    try {
      con = ConnectDb.dbConnectSEM();
      strSql = "select * from SAP_TRX_RESPONSE_LOG where FILE_NAME like 'ZFAP107_%_" + formatFileName + "%'";
      pstmt = con.prepareStatement(strSql);
      rs = pstmt.executeQuery();
      while (rs.next())
        hMap.put(rs.getString("FILE_NAME").trim(), rs.getString("STATUS").trim()); 
    } catch (Exception e) {
      System.out.println("error : " + e);
      e.printStackTrace();
    } finally {
      System.out.println("... finally getTrxResponseLogTB ...");
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
  
  private String getLastDateSapTrxResponseLogTB() throws Exception {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String max_date = Utilities.addDate(Utilities.getCurrentDate(), 0);
    try {
      con = ConnectDb.dbConnectSEM();
      pstmt = con.prepareStatement("select max(t.create_dt) as max_date  from sap_trx_response_log t ");
      rs = pstmt.executeQuery();
      if (rs.next())
        max_date = (rs.getDate("max_date") == null) ? Utilities.addDate(Utilities.getCurrentDate(), 0) : Utilities.addDate(rs.getDate("max_date"), 0); 
    } catch (Exception e) {
      System.out.println("error : " + e);
      e.printStackTrace();
    } finally {
      System.out.println("... finally getLastDateSapTrxResponseLogTB ...");
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
  
  private void updateTrxResponseLogTB(Connection con, String filename, String status, String errorMsg) throws Exception {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    HashMap<Object, Object> hMap = new HashMap<Object, Object>();
    try {
      String query = "update  SAP_TRX_RESPONSE_LOG  set STATUS = '" + 
        status.trim() + "',ERROR = '" + errorMsg + "',UPDATE_DT = current_timestamp where FILE_NAME = '" + filename.trim() + "'";
      pstmt = con.prepareStatement(query);
      int result = pstmt.executeUpdate();
    } catch (Exception ex) {
      if (rs != null)
        rs.close(); 
      if (pstmt != null)
        pstmt.close(); 
      System.out.println("error : " + ex);
      ex.printStackTrace();
      throw ex;
    } finally {
      System.out.println("... finally updateTrxResponseLogTB ...");
      if (rs != null)
        rs.close(); 
      if (pstmt != null)
        pstmt.close(); 
    } 
  }
  
  private void insertTrxResponseLogTB(Connection con, String filename, String status, String errorMsg) throws Exception {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    HashMap<Object, Object> hMap = new HashMap<Object, Object>();
    try {
      pstmt = con.prepareStatement("insert  into SAP_TRX_RESPONSE_LOG(ID,FILE_NAME,STATUS,ERROR,CREATE_DT) values(nextVal('VENDOR_MASTER_LOG_SEQ'),?,?,?,current_timestamp)");
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
      System.out.println("... finally insertTrxResponseLogTB ...");
      if (rs != null)
        rs.close(); 
      if (pstmt != null)
        pstmt.close(); 
    } 
  }
  
  private void readAckToTrxResponseTB(SFTPUtilities sftpUtil, String filename, String statusOfResponseLog) throws Exception {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    HashMap<Object, Object> hMap = new HashMap<Object, Object>();
    int record = 0;
    try {
      con = ConnectDb.dbConnectSEM();
      con.setAutoCommit(false);
      if (filename.toLowerCase().indexOf(".can") != -1) {
        if (statusOfResponseLog.equalsIgnoreCase("INSERT")) {
          insertTrxResponseLogTB(con, filename, "SUCCESS", "");
        } else if (statusOfResponseLog.equalsIgnoreCase("UPDATE")) {
          updateTrxResponseLogTB(con, filename, "SUCCESS", "");
        } 
      } else {
        Vector vAck = sftpUtil.readLines(SFTPUtilities.sapPath, filename);
        Vector vLog = sftpUtil.readLines(SFTPUtilities.sapPath, Utilities.cutExtension(filename).concat(".log").trim());
        if (vLog != null && vLog.size() > 0) {
          String vStr = vLog.elementAt(1).toString();
          Vector v = Utilities.StringSpiltDelim(vStr, "\\|");
          record = Integer.parseInt(v.get(0).toString());
        } 
        if (vAck.size() == record) {
          for (int i = 0; vAck != null && i < vAck.size(); i++) {
            String vStr = vAck.elementAt(i).toString();
            Vector v = Utilities.StringSpiltDelim(vStr, "\\|");
            insertTrxResponseTB(con, pstmt, v, filename);
          } 
          if (statusOfResponseLog.equalsIgnoreCase("INSERT")) {
            insertTrxResponseLogTB(con, filename, "SUCCESS", "");
          } else if (statusOfResponseLog.equalsIgnoreCase("UPDATE")) {
            updateTrxResponseLogTB(con, filename, "SUCCESS", "");
          } 
        } else if (statusOfResponseLog.equalsIgnoreCase("INSERT")) {
          insertTrxResponseLogTB(con, filename, "FAIL", "num record in ack not equal in log.");
        } else if (statusOfResponseLog.equalsIgnoreCase("UPDATE")) {
          updateTrxResponseLogTB(con, filename, "FAIL", "num record in ack not equal in log.");
        } 
      } 
    } catch (Exception e) {
      String errorMsg = getMsgError(e, getClass().getName(), e.getStackTrace()[0].getMethodName());
      Connection conLog = ConnectDb.dbConnectSEM();
      if (statusOfResponseLog.equalsIgnoreCase("INSERT")) {
        insertTrxResponseLogTB(conLog, filename, "ERROR", errorMsg);
      } else if (statusOfResponseLog.equalsIgnoreCase("UPDATE")) {
        updateTrxResponseLogTB(conLog, filename, "ERROR", errorMsg);
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
      System.out.println("... finally readAckToTrxResponseTB ...");
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
  
  private void readAckToTrxResponseTBWin(FileUtilities f, String filename, String statusOfResponseLog) throws Exception {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    HashMap<Object, Object> hMap = new HashMap<Object, Object>();
    int record = 0;
    try {
      con = ConnectDb.dbConnectSEM();
      con.setAutoCommit(false);
      if (filename.toLowerCase().indexOf(".can") != -1) {
        if (statusOfResponseLog.equalsIgnoreCase("INSERT")) {
          insertTrxResponseLogTB(con, filename, "SUCCESS", "");
        } else if (statusOfResponseLog.equalsIgnoreCase("UPDATE")) {
          updateTrxResponseLogTB(con, filename, "SUCCESS", "");
        } 
      } else {
        Vector vAck = f.readLines(FileUtilities.sapPath, filename);
        System.out.println("vAck size = " + vAck.size());
        Vector vLog = f.readLines(FileUtilities.sapPath, Utilities.cutExtension(filename).concat(".log").trim());
        if (vLog != null && vLog.size() > 0) {
          String vStr = vLog.elementAt(1).toString();
          Vector v = Utilities.StringSpiltDelim(vStr, "\\|");
          record = Integer.parseInt(v.get(0).toString());
        } 
        System.out.println("Total record = " + record);
        if (vAck.size() == record) {
          for (int i = 0; vAck != null && i < vAck.size(); i++) {
            String vStr = vAck.elementAt(i).toString();
            Vector v = Utilities.StringSpiltDelim(vStr, "\\|");
            insertTrxResponseTB(con, pstmt, v, filename);
          } 
          if (statusOfResponseLog.equalsIgnoreCase("INSERT")) {
            insertTrxResponseLogTB(con, filename, "SUCCESS", "");
          } else if (statusOfResponseLog.equalsIgnoreCase("UPDATE")) {
            updateTrxResponseLogTB(con, filename, "SUCCESS", "");
          } 
        } else if (statusOfResponseLog.equalsIgnoreCase("INSERT")) {
          insertTrxResponseLogTB(con, filename, "FAIL", "num record in ack not equal in log.");
        } else if (statusOfResponseLog.equalsIgnoreCase("UPDATE")) {
          updateTrxResponseLogTB(con, filename, "FAIL", "num record in ack not equal in log.");
        } 
      } 
    } catch (Exception e) {
      String errorMsg = getMsgError(e, getClass().getName(), e.getStackTrace()[0].getMethodName());
      Connection conLog = ConnectDb.dbConnectSEM();
      if (statusOfResponseLog.equalsIgnoreCase("INSERT")) {
        insertTrxResponseLogTB(conLog, filename, "ERROR", errorMsg);
      } else if (statusOfResponseLog.equalsIgnoreCase("UPDATE")) {
        updateTrxResponseLogTB(conLog, filename, "ERROR", errorMsg);
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
      System.out.println("... finally readAckToTrxResponseTB ...");
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
  
  private void insertTrxResponseTB(Connection con, PreparedStatement pstmt, Vector v, String filename) throws Exception {
    /*pstmt = con
      .prepareStatement("insert  into SAP_TRX_RESPONSE_UNIVERSAL(MESSAGE_TYPE,MESSAGE_ID,MESSAGE_NUMBER,MESSAGE,LOG_NO, LOG_MSG_NO,MESSAGE1,MESSAGE2,MESSAGE3,MESSAGE4, PARAMETER,MSGROW,FIELDS,SYSTEM,CREATE_FILE, CREATE_DT ) values(?, ?, ?, ?, ?,  ?, ?, ?, ?, ?,  ?, ?, ?, ?, ?,  current_timestamp )");
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
    pstmt.setString(15, filename);
    pstmt.executeUpdate();
    pstmt.close();
    */
    
    pstmt = con.prepareStatement("insert  into SAP_TRX_RESPONSE_UNIVERSAL(MESSAGE_TYPE,MESSAGE_ID,MESSAGE_NUMBER,MESSAGE,LOG_NO, LOG_MSG_NO,MESSAGE1,MESSAGE2,MESSAGE3,MESSAGE4, PARAMETER,MSGROW,FIELDS,SYSTEM,CREATE_FILE, CREATE_DT ) values(?, ?, ?, ?, ?,  ?, ?, ?, ?, ?,  ?, ?, ?, ?, ?,  CURRENT_TIMESTAMP )");
    pstmt.setString(1, v.elementAt(0).toString());
    pstmt.setString(2, v.elementAt(1).toString());
    pstmt.setDouble(3, new Double(v.elementAt(2).toString()));
    pstmt.setString(4, v.elementAt(3).toString());
    pstmt.setString(5, v.elementAt(4).toString());
    pstmt.setDouble(6,  new Double(v.elementAt(5).toString()));
    pstmt.setString(7, v.elementAt(6).toString());
    pstmt.setString(8, v.elementAt(7).toString());
    pstmt.setString(9, v.elementAt(8).toString());
    pstmt.setString(10, v.elementAt(9).toString());
    pstmt.setString(11, v.elementAt(10).toString());
    pstmt.setDouble(12,  new Double(v.elementAt(11).toString()));
    pstmt.setString(13, v.elementAt(12).toString());
    pstmt.setString(14, v.elementAt(13).toString());
    pstmt.setString(15, filename);
    pstmt.executeUpdate();
    pstmt.close();
    System.out.println("Insert insertTrxResponseTB Complete !!!");
  }
  
  private String getMsgError(Exception err, String className, String methodName) {
    String errorMsg = "[Exception : " + err.getClass().getName() + "] [Cause : " + err.getMessage() + "] [Class : " + className + "] [Method : " + methodName + "]";
    errorMsg = errorMsg.replace("\n", "");
    errorMsg = errorMsg.replace("\"", "\\\"");
    return errorMsg;
  }
}
