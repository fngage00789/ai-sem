package com.ais.sem.payment.transfer;

import com.ais.sem.model.SMSModel;
import com.ais.sem.payment.db.ConnectDb;
import com.ais.sem.payment.util.FileUtilities;
import com.ais.sem.payment.util.SFTPUtilities;
import com.ais.sem.payment.util.SmsClient;
import com.ais.sem.payment.util.Utilities;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class TextSAPToPaymentTB {
  private static String system = Utilities.getResources("system");
  
  public static void main(String[] args) {
    System.out.println("=================== Begin Process TextSAPToPaymentTB  ===================");  
    TextSAPToPaymentTB textToTable = new TextSAPToPaymentTB();
    textToTable.doProcess();
    System.out.println("=================== End Process TextSAPToPaymentTB  ===================");  
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
      String maxDate = getLastDateSapPayLogTB();
      String strCurrentDate = Utilities.addDate(Utilities.getCurrentDate(), 0);
      System.out.println("=================");
      System.out.println("strCurrentDate = " + Integer.parseInt(strCurrentDate));
      System.out.println("maxDate = " + Integer.parseInt(maxDate));
      while (Integer.parseInt(maxDate) <= Integer.parseInt(strCurrentDate)) {
        System.out.println("===== while loop date (" + maxDate + ")======");
        String formatFileName = maxDate;
        HashMap hp = getPayLogTB(formatFileName);
        Vector vtFileName = f.getFileNameAll(FileUtilities.sapPath, formatFileName);
        for (int i = 0; i < vtFileName.size(); i++) {
          String filename = vtFileName.get(i).toString();
          System.out.println("hp.get(" + filename + ") : " + hp.get(filename));
          if (hp.get(filename) == null) {
            readDatToPayTBWin(f, filename, "INSERT");
          } else if (!hp.get(filename).toString().equalsIgnoreCase("SUCCESS")) {
            readDatToPayTBWin(f, filename, "UPDATE");
          } 
        } 
        maxDate = Utilities.addDate(Utilities.parseDate(maxDate, "dd/MM/yyyy"), 1);
      } 
      doSendSMS();
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  private void tranferOnLinux() {
    try {
      SFTPUtilities sft = new SFTPUtilities(true);
      String maxDate = getLastDateSapPayLogTB();
      String strCurrentDate = Utilities.addDate(Utilities.getCurrentDate(), 0);
      System.out.println("=================");
      System.out.println("strCurrentDate = " + Integer.parseInt(strCurrentDate));
      System.out.println("maxDate = " + Integer.parseInt(maxDate));
      while (Integer.parseInt(maxDate) <= Integer.parseInt(strCurrentDate)) {
        System.out.println("===== while loop date (" + maxDate + ")======");
        String formatFileName = maxDate;
        HashMap hp = getPayLogTB(formatFileName);
        Vector vtFileName = sft.getFileNameAll(SFTPUtilities.sapPath, formatFileName);
        for (int i = 0; i < vtFileName.size(); i++) {
          String filename = vtFileName.get(i).toString();
          System.out.println("hp.get(" + filename + ") : " + hp.get(filename));
          if (hp.get(filename) == null) {
            readDatToPayTB(sft, filename, "INSERT");
          } else if (!hp.get(filename).toString().equalsIgnoreCase("SUCCESS")) {
            readDatToPayTB(sft, filename, "UPDATE");
          } 
        } 
        maxDate = Utilities.addDate(Utilities.parseDate(maxDate, "dd/MM/yyyy"), 1);
      } 
      doSendSMS();
      sft.disconnect();
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  private String getLastDateSapPayLogTB() throws Exception {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String max_date = Utilities.addDate(Utilities.getCurrentDate(), 0);
    try {
      con = ConnectDb.dbConnectSEM();
      pstmt = con.prepareStatement("select max(t.create_dt) as max_date  from SAP_PAY_LOG t ");
      rs = pstmt.executeQuery();
      if (rs.next())
        max_date = (rs.getDate("max_date") == null) ? Utilities.addDate(Utilities.getCurrentDate(), 0) : Utilities.addDate(rs.getDate("max_date"), 0); 
    } catch (Exception e) {
      System.out.println("error : " + e);
      e.printStackTrace();
    } finally {
      System.out.println("... finally getLastDateSapPayLogTB ...");
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
  
  private HashMap getPayLogTB(String formatFileName) {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    HashMap<Object, Object> hMap = new HashMap<Object, Object>();
    String strSql = "";
    try {
      con = ConnectDb.dbConnectSEM();
      strSql = "select * from SAP_PAY_LOG where FILE_NAME like 'ZFAP108_%_" + formatFileName + "%'";
      pstmt = con.prepareStatement(strSql);
      rs = pstmt.executeQuery();
      while (rs.next())
        hMap.put(rs.getString("FILE_NAME").trim(), rs.getString("STATUS").trim()); 
    } catch (Exception e) {
      System.out.println("error : " + e);
      e.printStackTrace();
    } finally {
      System.out.println("... finally getPayLogTB ...");
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
  
  private void updatePayLogTB(Connection con, String filename, String status, String errorMsg) throws Exception {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    HashMap<Object, Object> hMap = new HashMap<Object, Object>();
    try {
      String query = "update  SAP_PAY_LOG  set STATUS = '" + 
        status.trim() + "',ERROR = '" + errorMsg + "',UPDATE_DT = current_timestamp where FILE_NAME = '" + filename.trim() + "'";
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
      System.out.println("... finally updatePayLogTB ...");
      if (rs != null)
        rs.close(); 
      if (pstmt != null)
        pstmt.close(); 
    } 
  }
  
  private void insertPayLogTB(Connection con, String filename, String status, String errorMsg) throws Exception {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    HashMap<Object, Object> hMap = new HashMap<Object, Object>();
    try {
      pstmt = con.prepareStatement("insert  into SAP_PAY_LOG(ID,FILE_NAME,STATUS,ERROR,CREATE_DT) values(nextVal('PAY_LOG_SEQ'),?,?,?,current_timestamp)");
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
      System.out.println("... finally insertPayLogTB ...");
      if (rs != null)
        rs.close(); 
      if (pstmt != null)
        pstmt.close(); 
    } 
  }
  
  private void readDatToPayTB(SFTPUtilities sftpUtil, String filename, String statusOfPayLog) throws Exception {
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
          insertSapPayTB(con, pstmt, v, filename);
        } 
        if (statusOfPayLog.equalsIgnoreCase("INSERT")) {
          insertPayLogTB(con, filename, "SUCCESS", "");
        } else if (statusOfPayLog.equalsIgnoreCase("UPDATE")) {
          updatePayLogTB(con, filename, "SUCCESS", "");
        } 
      } else if (statusOfPayLog.equalsIgnoreCase("INSERT")) {
        insertPayLogTB(con, filename, "FAIL", "num record in ack not equal in log.");
      } else if (statusOfPayLog.equalsIgnoreCase("UPDATE")) {
        updatePayLogTB(con, filename, "FAIL", "num record in ack not equal in log.");
      } 
    } catch (Exception e) {
      String errorMsg = getMsgError(e, getClass().getName(), e.getStackTrace()[0].getMethodName());
      Connection conLog = ConnectDb.dbConnectSEM();
      if (statusOfPayLog.equalsIgnoreCase("INSERT")) {
        insertPayLogTB(conLog, filename, "ERROR", errorMsg);
      } else if (statusOfPayLog.equalsIgnoreCase("UPDATE")) {
        updatePayLogTB(conLog, filename, "ERROR", errorMsg);
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
      System.out.println("... finally readDatToPayTB ...");
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
  
  private void readDatToPayTBWin(FileUtilities f, String filename, String statusOfPayLog) throws Exception {
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
          insertSapPayTB(con, pstmt, v, filename);
        } 
        if (statusOfPayLog.equalsIgnoreCase("INSERT")) {
          insertPayLogTB(con, filename, "SUCCESS", "");
        } else if (statusOfPayLog.equalsIgnoreCase("UPDATE")) {
          updatePayLogTB(con, filename, "SUCCESS", "");
        } 
      } else if (statusOfPayLog.equalsIgnoreCase("INSERT")) {
        insertPayLogTB(con, filename, "FAIL", "num record in ack not equal in log.");
      } else if (statusOfPayLog.equalsIgnoreCase("UPDATE")) {
        updatePayLogTB(con, filename, "FAIL", "num record in ack not equal in log.");
      } 
    } catch (Exception e) {
      String errorMsg = getMsgError(e, getClass().getName(), e.getStackTrace()[0].getMethodName());
      Connection conLog = ConnectDb.dbConnectSEM();
      if (statusOfPayLog.equalsIgnoreCase("INSERT")) {
        insertPayLogTB(conLog, filename, "ERROR", errorMsg);
      } else if (statusOfPayLog.equalsIgnoreCase("UPDATE")) {
        updatePayLogTB(conLog, filename, "ERROR", errorMsg);
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
      System.out.println("... finally readDatToPayTBWin ...");
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
  
  private void insertSapPayTB(Connection con, PreparedStatement pstmt, Vector v, String filename) throws Exception {
    String statusData = v.get(0).toString();
    if (statusData.equals("H")) {
      pstmt = con.prepareStatement("insert  into SAP_PAY_HDR(HEARUN,COMCOD,DOCNO,DOCYEA,DOCTYP,REFDOC,DOCHEA,DOCDAT,POSDAT,ENTRYDAT,ENTRYTIME,BRACOD,CURCOD,EXCRAT,PAMTLOC,PAMTDOC,BNKNAM,BNKACC,PAYMET,CHENO,CHEDAT,PBNKKEY,PBNKNAM,PBNKACC,CREATE_FILE,CREATE_DT ) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, current_timestamp)");
      pstmt.setString(1, v.elementAt(1).toString());
      pstmt.setString(2, v.elementAt(2).toString());
      pstmt.setString(3, v.elementAt(3).toString());
      pstmt.setString(4, v.elementAt(4).toString());
      pstmt.setString(5, v.elementAt(5).toString());
      pstmt.setString(6, v.elementAt(6).toString());
      pstmt.setString(7, v.elementAt(7).toString());
      pstmt.setString(8, v.elementAt(8).toString());
      pstmt.setString(9, v.elementAt(9).toString());
      pstmt.setString(10, v.elementAt(10).toString());
      pstmt.setString(11, v.elementAt(11).toString());
      pstmt.setString(12, v.elementAt(12).toString());
      pstmt.setString(13, v.elementAt(13).toString());
      pstmt.setBigDecimal(14, !v.elementAt(14).toString().equals("") ? new BigDecimal(v.elementAt(14).toString()) : new BigDecimal(0));
      pstmt.setBigDecimal(15, !v.elementAt(15).toString().equals("") ? new BigDecimal(v.elementAt(15).toString()) : new BigDecimal(0));
      pstmt.setBigDecimal(16, !v.elementAt(16).toString().equals("") ? new BigDecimal(v.elementAt(16).toString()) : new BigDecimal(0));
      pstmt.setString(17, v.elementAt(17).toString());
      pstmt.setString(18, v.elementAt(18).toString());
      pstmt.setString(19, v.elementAt(19).toString());
      pstmt.setString(20, v.elementAt(20).toString());
      pstmt.setString(21, v.elementAt(21).toString());
      pstmt.setString(22, v.elementAt(22).toString());
      pstmt.setString(23, v.elementAt(23).toString());
      pstmt.setString(24, v.elementAt(24).toString());
      pstmt.setString(25, filename);
      pstmt.executeUpdate();
      pstmt.close();
      System.out.println("Inserted SAP_PAY_HDR !!!");
    } else if (statusData.equals("I")) {
      pstmt = con.prepareStatement("insert  into SAP_PAY_DTL_INVOICE(HEARUN,COMCOD,DOCNO,DOCYEA,LINITM,AMTTYP,ACCTYP,ACCNUM,SPEGLI,INVDOC, INVYEA,REFSEM,REFDOC,IAMTLOC,IAMTDOC,PAMTLOC,PAMTDOC,CREATE_FILE,CREATE_DT,UPDATE_FILE, UPDATE_DT ) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, current_timestamp, ?, ?)");
      pstmt.setString(1, v.elementAt(1).toString());
      pstmt.setString(2, v.elementAt(2).toString());
      pstmt.setString(3, v.elementAt(3).toString());
      pstmt.setString(4, v.elementAt(4).toString());
      pstmt.setString(5, v.elementAt(5).toString());
      pstmt.setString(6, v.elementAt(6).toString());
      pstmt.setString(7, v.elementAt(7).toString());
      pstmt.setString(8, v.elementAt(8).toString());
      pstmt.setString(9, v.elementAt(9).toString());
      pstmt.setBigDecimal(10, !v.elementAt(10).toString().equals("") ? new BigDecimal(v.elementAt(10).toString()) : new BigDecimal(0));
      pstmt.setString(11, v.elementAt(11).toString());
      pstmt.setString(12, v.elementAt(12).toString());
      pstmt.setString(13, v.elementAt(13).toString());
      pstmt.setBigDecimal(14, !v.elementAt(14).toString().equals("") ? new BigDecimal(v.elementAt(14).toString()) : new BigDecimal(0));
      pstmt.setBigDecimal(15, !v.elementAt(15).toString().equals("") ? new BigDecimal(v.elementAt(15).toString()) : new BigDecimal(0));
      pstmt.setBigDecimal(16, !v.elementAt(16).toString().equals("") ? new BigDecimal(v.elementAt(16).toString()) : new BigDecimal(0));
      pstmt.setBigDecimal(17, !v.elementAt(17).toString().equals("") ? new BigDecimal(v.elementAt(17).toString()) : new BigDecimal(0));
      pstmt.setString(18, filename);
      pstmt.setNull(19, 1);
      pstmt.setNull(20, 91);
      pstmt.executeUpdate();
      pstmt.close();
      System.out.println("Insert SAP_PAY_DTL_INVOICE !!!");
    } else if (statusData.equals("O")) {
      pstmt = con.prepareStatement("insert  into SAP_PAY_DTL_OTHER(HEARUN,COMCOD,DOCNO,DOCYEA,LINITM,AMTTYP,ACCTYP,ACCNUM,SPEGLI,OTHAMTLOC, OTHAMTDOC,CREATE_FILE,CREATE_DT ) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, current_timestamp)");
      pstmt.setString(1, v.elementAt(1).toString());
      pstmt.setString(2, v.elementAt(2).toString());
      pstmt.setString(3, v.elementAt(3).toString());
      pstmt.setString(4, v.elementAt(4).toString());
      pstmt.setString(5, v.elementAt(5).toString());
      pstmt.setString(6, v.elementAt(6).toString());
      pstmt.setString(7, v.elementAt(7).toString());
      pstmt.setString(8, v.elementAt(8).toString());
      pstmt.setString(9, v.elementAt(9).toString());
      pstmt.setBigDecimal(10, !v.elementAt(10).toString().equals("") ? new BigDecimal(v.elementAt(10).toString()) : new BigDecimal(0));
      pstmt.setBigDecimal(11, !v.elementAt(11).toString().equals("") ? new BigDecimal(v.elementAt(11).toString()) : new BigDecimal(0));
      pstmt.setString(12, filename);
      pstmt.executeUpdate();
      pstmt.close();
      System.out.println("Inserted SAP_PAY_DTL_OTHER !!!");
    } 
  }
  
  private String getMsgError(Exception err, String className, String methodName) {
    String errorMsg = "[Exception : " + err.getClass().getName() + "] [Cause : " + err.getMessage() + "] [Class : " + className + "] [Method : " + methodName + "]";
    errorMsg = errorMsg.replace("\n", "");
    errorMsg = errorMsg.replace("\"", "\\\"");
    return errorMsg;
  }
  
  private void doSendSMS() {
    System.out.println("===== Do Send SMS ======");
    List<SMSModel> smsList = getSmsList();
    if (smsList != null || smsList.size() > 0)
      for (SMSModel smsM : smsList)
        SmsClient.sendSMS(smsM);  
    System.out.println("========================");
  }
  
  private List<SMSModel> getSmsList() {
    Connection conn = null;
    ResultSet rs = null;
   // String strSql = "{call SEM.SEM_SP_MRT003_SMS(?,?,?)}";
    String strSql = "call SEM.SEM_SP_MRT003_SMS(?,?,?)";
    List<SMSModel> smsModelList = new ArrayList<SMSModel>();
    SMSModel smsM = new SMSModel();
    CallableStatement callableStatement = null;
    try {
      
      conn = ConnectDb.dbConnectSEM();
      try {
        conn.setAutoCommit(false);
      } catch (SQLException e1) {
        e1.printStackTrace();
      } 
      callableStatement = conn.prepareCall(strSql);
      //callableStatement.registerOutParameter(1, -10);
      callableStatement.setObject(1, null);         
      callableStatement.setString(2, "B");
      callableStatement.setString(3, "");
      callableStatement.registerOutParameter(1, Types.OTHER);   
      callableStatement.executeUpdate();
      rs = (ResultSet)callableStatement.getObject(1);
      System.out.println("... call SEM_SP_MRT003_SMS ... rs : "+rs);
      while (rs.next()) {
        smsM = new SMSModel();
        smsM.setMobileNo(rs.getString("MOBILE_NO"));
        smsM.setvHeader(rs.getString("V_HEADER"));
        smsM.setvMessage(rs.getString("V_MESSAGE"));
        smsModelList.add(smsM);
        
        System.out.println("... smsM : "+smsM);
      } 
      conn.commit();
      conn.setAutoCommit(true);
      
    } catch (Exception e) {
      try {
		conn.rollback();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
      System.out.println("error : " + e);
      e.printStackTrace();
    } finally {
      System.out.println("... finally getPayLogTB ...");
      try {
        if (rs != null)
          rs.close(); 
        if (callableStatement != null)
          callableStatement.close(); 
        if (conn != null) {
          conn.close();
          System.out.println("... con.close ...");
        } 
      } catch (Exception e) {
        System.out.println("error : " + e);
      } 
    } 
    return smsModelList;
  }
}
