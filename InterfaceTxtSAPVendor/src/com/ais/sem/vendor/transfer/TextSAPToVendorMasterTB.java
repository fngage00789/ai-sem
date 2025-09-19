package com.ais.sem.vendor.transfer;

import com.ais.sem.vendor.db.ConnectDb;
import com.ais.sem.vendor.util.FileUtilities;
import com.ais.sem.vendor.util.SFTPUtilities;
import com.ais.sem.vendor.util.Utilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;

public class TextSAPToVendorMasterTB {
  private static String system = Utilities.getResources("system");
  
  public static void main(String[] args) {
    TextSAPToVendorMasterTB textToTable = new TextSAPToVendorMasterTB();
    textToTable.doProcess();
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
      String maxDate = getLastDateSapVendorMasterLogTB();
      String strCurrentDate = Utilities.addDate(Utilities.getCurrentDate(), 0);
      System.out.println("=================");
      System.out.println("strCurrentDate = " + Integer.parseInt(strCurrentDate));
      System.out.println("maxDate = " + Integer.parseInt(maxDate));
      int c = 1;
      while (Integer.parseInt(maxDate) <= Integer.parseInt(strCurrentDate)) {
        System.out.println("===== while loop date (" + maxDate + ")======");
        System.out.println("===== loop file [" + c + "]");
        String formatFileName = maxDate;
        HashMap hp = getVendorMasterLogTB(formatFileName);
        Vector vtFileName = f.getFileNameAll(FileUtilities.sapPath, formatFileName);
        for (int i = 0; i < vtFileName.size(); i++) {
          String filename = vtFileName.get(i).toString();
          System.out.println("hp.get(" + filename + ") : " + hp.get(filename));
          if (hp.get(filename) == null) {
            readDatToVendorMasterTBWin(f, filename, "INSERT");
          } else if (!hp.get(filename).toString().equalsIgnoreCase("SUCCESS")) {
            readDatToVendorMasterTBWin(f, filename, "UPDATE");
          } 
          c++;
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
      String maxDate = getLastDateSapVendorMasterLogTB();
      String strCurrentDate = Utilities.addDate(Utilities.getCurrentDate(), 0);
      System.out.println("=================");
      System.out.println("strCurrentDate = " + Integer.parseInt(strCurrentDate));
      System.out.println("maxDate = " + Integer.parseInt(maxDate));
      while (Integer.parseInt(maxDate) <= Integer.parseInt(strCurrentDate)) {
        System.out.println("===== while loop date (" + maxDate + ")======");
        String formatFileName = maxDate;
        HashMap hp = getVendorMasterLogTB(formatFileName);
        Vector vtFileName = sft.getFileNameAll(SFTPUtilities.sapPath, formatFileName);
        for (int i = 0; i < vtFileName.size(); i++) {
          String filename = vtFileName.get(i).toString();
          System.out.println("hp.get(" + filename + ") : " + hp.get(filename));
          if (hp.get(filename) == null) {
            readDatToVendorMasterTB(sft, filename, "INSERT");
          } else if (!hp.get(filename).toString().equalsIgnoreCase("SUCCESS")) {
            readDatToVendorMasterTB(sft, filename, "UPDATE");
          } 
        } 
        maxDate = Utilities.addDate(Utilities.parseDate(maxDate, "dd/MM/yyyy"), 1);
      } 
      sft.disconnect();
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  private String getLastDateSapVendorMasterLogTB() throws Exception {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String max_date = Utilities.addDate(Utilities.getCurrentDate(), 0);
    try {
      con = ConnectDb.dbConnectSEM();
      pstmt = con.prepareStatement("select max(t.create_dt) as max_date  from SAP_VENDOR_MASTER_LOG t ");
      rs = pstmt.executeQuery();
      if (rs.next())
        max_date = (rs.getDate("max_date") == null) ? Utilities.addDate(Utilities.getCurrentDate(), 0) : Utilities.addDate(rs.getDate("max_date"), 0); 
    } catch (Exception e) {
      System.out.println("error : " + e);
      e.printStackTrace();
    } finally {
      System.out.println("... finally getLastDateSapVendorMasterLogTB ...");
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
  
  private boolean foundVendorCodeInVendorMasterTB(Connection con, String vendorCode, String comcode) throws Exception {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    boolean result = false;
    try {
      String sql = "select * from SAP_VENDOR_MASTER where VENCOD = '" + vendorCode + "' and COMCOD ='" + comcode + "'";
      pstmt = con.prepareStatement(sql);
      rs = pstmt.executeQuery();
      if (rs.next())
        result = true; 
    } catch (Exception e) {
      System.out.println("error : " + e);
      e.printStackTrace();
      throw e;
    } finally {
      System.out.println("... finally foundVendorCodeInVendorMasterTB ...");
      try {
        if (rs != null)
          rs.close(); 
        if (pstmt != null)
          pstmt.close(); 
      } catch (Exception e) {
        System.out.println("error : " + e);
      } 
    } 
    return result;
  }
  
  private HashMap getVendorMasterLogTB(String formatFileName) {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    HashMap<Object, Object> hMap = new HashMap<Object, Object>();
    String strSql = "";
    try {
      con = ConnectDb.dbConnectSEM();
      strSql = "select * from SAP_VENDOR_MASTER_LOG  where FILE_NAME like 'ZFAP106_%_" + formatFileName + "%'";
      pstmt = con.prepareStatement(strSql);
      rs = pstmt.executeQuery();
      while (rs.next())
        hMap.put(rs.getString("FILE_NAME").trim(), rs.getString("STATUS").trim()); 
    } catch (Exception e) {
      System.out.println("error : " + e);
      e.printStackTrace();
    } finally {
      System.out.println("... finally getVendorMasterLogTB ...");
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
  
  private void updateVendorMasterLogTB(Connection con, String filename, String status, String errorMsg) throws Exception {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    HashMap<Object, Object> hMap = new HashMap<Object, Object>();
    try {
      String query = "update  SAP_VENDOR_MASTER_LOG  set STATUS = '" + 
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
      System.out.println("... finally updateVendorMasterLogTB ...");
      if (rs != null)
        rs.close(); 
      if (pstmt != null)
        pstmt.close(); 
    } 
  }
  
  private void insertVendorMasterLogTB(Connection con, String filename, String status, String errorMsg) throws Exception {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    HashMap<Object, Object> hMap = new HashMap<Object, Object>();
    try {
    //  pstmt = con.prepareStatement("insert  into SAP_VENDOR_MASTER_LOG(ID,FILE_NAME,STATUS,ERROR,CREATE_DT) values((VENDOR_MASTER_LOG_SEQ.nextVal),?,?,?,current_timestamp)");
      pstmt = con.prepareStatement("insert  into SAP_VENDOR_MASTER_LOG(ID,FILE_NAME,STATUS,ERROR,CREATE_DT) values(nextVal('VENDOR_MASTER_LOG_SEQ'),?,?,?,current_timestamp)");	
    	
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
      System.out.println("... finally insertVendorMasterLogTB ...");
      if (rs != null)
        rs.close(); 
      if (pstmt != null)
        pstmt.close(); 
    } 
  }
  
  private void readDatToVendorMasterTBWin(FileUtilities f, String filename, String statusOfVendorLog) throws Exception {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    HashMap<Object, Object> hMap = new HashMap<Object, Object>();
    int record = 0;
    try {
      con = ConnectDb.dbConnectSEM();
      con.setAutoCommit(false);
      Vector vDat = f.readLines(FileUtilities.sapPath, filename);
      System.out.println("vDat size = " + vDat.size());
      Vector vSyn = f.readLines(FileUtilities.sapPath, Utilities.cutExtension(filename).concat(".syn").trim());
      if (vSyn != null && vSyn.size() > 0) {
        String vStr = vSyn.elementAt(1).toString();
        Vector v = Utilities.StringSpiltDelim(vStr, "\\|");
        record = Integer.parseInt(v.get(0).toString());
      } 
      System.out.println("Total record = " + record);
      if (vDat.size() == record) {
        for (int i = 0; vDat != null && i < vDat.size(); i++) {
          String vStr = vDat.elementAt(i).toString();
          Vector v = Utilities.StringSpiltDelim(vStr, "\\|");
          String vendorCode = v.elementAt(1).toString();
          String comcode = v.elementAt(4).toString();
          if (vDat.size() > 0 && 
            i == 0) {
            if (statusOfVendorLog.equalsIgnoreCase("INSERT")) {
              insertVendorMasterLogTB(con, filename, "SUCCESS", "");
            } else if (statusOfVendorLog.equalsIgnoreCase("UPDATE")) {
              updateVendorMasterLogTB(con, filename, "SUCCESS", "");
            } 
            con.commit();
          } 
          boolean found = foundVendorCodeInVendorMasterTB(con, vendorCode, comcode);
          if (found) {
            updateVendorMasterTB(con, pstmt, v, filename);
          } else {
            insertVendorMasterTB(con, pstmt, v, filename);
          } 
        } 
      } else if (statusOfVendorLog.equalsIgnoreCase("INSERT")) {
        insertVendorMasterLogTB(con, filename, "FAIL", "num record in dat not equal in syn.");
      } else if (statusOfVendorLog.equalsIgnoreCase("UPDATE")) {
        updateVendorMasterLogTB(con, filename, "FAIL", "num record in dat not equal in syn.");
      } 
    } catch (Exception e) {
      String errorMsg = getMsgError(e, getClass().getName(), e.getStackTrace()[0].getMethodName());
      Connection conLog = ConnectDb.dbConnectSEM();
      if (statusOfVendorLog.equalsIgnoreCase("INSERT")) {
        insertVendorMasterLogTB(conLog, filename, "ERROR", errorMsg);
      } else if (statusOfVendorLog.equalsIgnoreCase("UPDATE")) {
        updateVendorMasterLogTB(conLog, filename, "ERROR", errorMsg);
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
      System.out.println("... finally readDatToVendorMasterTBWin ...");
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
  
  private void readDatToVendorMasterTB(SFTPUtilities sftpUtil, String filename, String statusOfVendorLog) throws Exception {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    HashMap<Object, Object> hMap = new HashMap<Object, Object>();
    int record = 0;
    try {
      con = ConnectDb.dbConnectSEM();
      con.setAutoCommit(true);
      Vector vDat = sftpUtil.readLines(SFTPUtilities.sapPath, filename);
      System.out.println("vDat size = " + vDat.size());
      Vector vSyn = sftpUtil.readLines(SFTPUtilities.sapPath, Utilities.cutExtension(filename).concat(".syn").trim());
      if (vSyn != null && vSyn.size() > 0) {
        String vStr = vSyn.elementAt(1).toString();
        Vector v = Utilities.StringSpiltDelim(vStr, "\\|");
        record = Integer.parseInt(v.get(0).toString());
      } 
      System.out.println("Total record = " + record);
      if (vDat.size() == record) {
        for (int i = 0; vDat != null && i < vDat.size(); i++) {
          String vStr = vDat.elementAt(i).toString();
          Vector v = Utilities.StringSpiltDelim(vStr, "\\|");
          String vendorCode = v.elementAt(1).toString();
          String comcode = v.elementAt(4).toString();
          if (vDat.size() > 0 && 
            i == 0) {
            if (statusOfVendorLog.equalsIgnoreCase("INSERT")) {
              insertVendorMasterLogTB(con, filename, "SUCCESS", "");
            } else if (statusOfVendorLog.equalsIgnoreCase("UPDATE")) {
              updateVendorMasterLogTB(con, filename, "SUCCESS", "");
            } 
            con.commit();
          } 
          boolean found = foundVendorCodeInVendorMasterTB(con, vendorCode, comcode);
          if (found) {
            updateVendorMasterTB(con, pstmt, v, filename);
          } else {
            insertVendorMasterTB(con, pstmt, v, filename);
          } 
        } 
      } else if (statusOfVendorLog.equalsIgnoreCase("INSERT")) {
        insertVendorMasterLogTB(con, filename, "FAIL", "num record in dat not equal in syn.");
      } else if (statusOfVendorLog.equalsIgnoreCase("UPDATE")) {
        updateVendorMasterLogTB(con, filename, "FAIL", "num record in dat not equal in syn.");
      } 
    } catch (Exception e) {
      String errorMsg = getMsgError(e, getClass().getName(), e.getStackTrace()[0].getMethodName());
      Connection conLog = ConnectDb.dbConnectSEM();
      if (statusOfVendorLog.equalsIgnoreCase("INSERT")) {
        insertVendorMasterLogTB(conLog, filename, "ERROR", errorMsg);
      } else if (statusOfVendorLog.equalsIgnoreCase("UPDATE")) {
        updateVendorMasterLogTB(conLog, filename, "ERROR", errorMsg);
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
      System.out.println("... finally readDatToVendorMasterTB ...");
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
  
  private void updateVendorMasterTB(Connection con, PreparedStatement pstmt, Vector v, String filename) throws Exception {
    try {
      pstmt = con.prepareStatement("update  SAP_VENDOR_MASTER  set STATUS = ?,VENCOD = ?,DATSTA = ?,USRSTA = ?,COMCOD = ?,ONEFLG = ?,ACCGRO = ?,TITLE = ?,VENNAM1 = ?,VENNAM2 = ?,  VENNAM3 = ?,VENNAM4 = ?,SEATER = ?,STREET1 = ?,STREET2 = ?,STREET3 = ?,STREET4 = ?,DISTRI = ?,CITY01 = ?,POSCOD = ?,  KONZS = ?,COUNTR = ?,REGION = ?,TELPHO1 = ?,TELPHO2 = ?,MOBILENO = ?,FAXNO = ?,EMAIL = ?,DATCOM = ?,  TELBOX = ?,COMMEN = ?,CUSCOD = ?,TRAPAR = ?,TAXID = ?,BRSCH = ?,INDKEY = ?,BNKKEY1 = ?,BNKNAM1 = ?,BNKACC1 = ?,  ACCHOD1 = ?,PARBNK1 = ?,BNKKEY2 = ?,BNKNAM2 = ?,BNKACC2 = ?,ACCHOD2 = ?,PARBNK2 = ?,RECACC = ?,HEAACC = ?,PREACC = ?,  PAYTER = ?,PAYMET = ?,PAYBLK = ?,ACCCLK = ?,WITTYPE1 = ?,WITCODE1 = ?,RECTYPE1 = ?,WITTYPE2 = ?,WITCODE2 = ?,RECTYPE2 = ?, WITTYPE3 = ?,WITCODE3 = ?,RECTYPE3 = ?,UPDATE_FILE = ?,UPDATE_DT = current_timestamp  where trim(VENCOD) = ?  and trim(COMCOD) = ? ");
      int pstmtIndex = 1;
      pstmt.setString(pstmtIndex++, v.elementAt(0).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(1).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(2).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(3).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(4).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(5).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(6).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(7).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(8).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(9).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(10).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(11).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(12).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(13).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(14).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(15).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(16).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(17).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(18).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(19).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(20).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(21).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(22).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(23).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(24).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(25).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(26).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(27).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(28).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(29).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(30).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(31).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(32).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(33).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(34).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(35).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(36).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(37).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(38).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(39).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(40).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(41).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(42).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(43).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(44).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(45).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(46).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(47).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(48).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(49).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(50).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(51).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(52).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(53).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(54).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(55).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(56).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(57).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(58).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(59).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(60).toString());
      pstmt.setString(pstmtIndex++, v.elementAt(61).toString());
      pstmt.setString(pstmtIndex++, filename);
      pstmt.setString(pstmtIndex++, v.elementAt(1).toString().trim());
      pstmt.setString(pstmtIndex++, v.elementAt(4).toString().trim());
      int result = pstmt.executeUpdate();
      pstmt.close();
      System.out.println("result = " + result);
      System.out.println("Update updateVendorMasterTB Complete !!!");
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  private void insertVendorMasterTB(Connection con, PreparedStatement pstmt, Vector v, String filename) throws Exception {
    pstmt = con
      .prepareStatement("insert  into SAP_VENDOR_MASTER(STATUS,VENCOD,DATSTA,USRSTA,COMCOD,ONEFLG,ACCGRO,TITLE,VENNAM1,VENNAM2, VENNAM3,VENNAM4,SEATER,STREET1,STREET2,STREET3,STREET4,DISTRI,CITY01,POSCOD, KONZS,COUNTR,REGION,TELPHO1,TELPHO2,MOBILENO,FAXNO,EMAIL,DATCOM, TELBOX,COMMEN,CUSCOD,TRAPAR,TAXID,BRSCH,INDKEY,BNKKEY1,BNKNAM1,BNKACC1, ACCHOD1,PARBNK1,BNKKEY2,BNKNAM2,BNKACC2,ACCHOD2,PARBNK2,RECACC,HEAACC,PREACC, PAYTER,PAYMET,PAYBLK,ACCCLK,WITTYPE1,WITCODE1,RECTYPE1,WITTYPE2,WITCODE2,RECTYPE2, WITTYPE3,WITCODE3,RECTYPE3,CREATE_FILE,CREATE_DT ) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?,  ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,  ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,  ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,  ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,  ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,  ?, ?, ?, current_timestamp ) ");
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
    pstmt.setString(16, v.elementAt(15).toString());
    pstmt.setString(17, v.elementAt(16).toString());
    pstmt.setString(18, v.elementAt(17).toString());
    pstmt.setString(19, v.elementAt(18).toString());
    pstmt.setString(20, v.elementAt(19).toString());
    pstmt.setString(21, v.elementAt(20).toString());
    pstmt.setString(22, v.elementAt(21).toString());
    pstmt.setString(23, v.elementAt(22).toString());
    pstmt.setString(24, v.elementAt(23).toString());
    pstmt.setString(25, v.elementAt(24).toString());
    pstmt.setString(26, v.elementAt(25).toString());
    pstmt.setString(27, v.elementAt(26).toString());
    pstmt.setString(28, v.elementAt(27).toString());
    pstmt.setString(29, v.elementAt(28).toString());
    pstmt.setString(30, v.elementAt(29).toString());
    pstmt.setString(31, v.elementAt(30).toString());
    pstmt.setString(32, v.elementAt(31).toString());
    pstmt.setString(33, v.elementAt(32).toString());
    pstmt.setString(34, v.elementAt(33).toString());
    pstmt.setString(35, v.elementAt(34).toString());
    pstmt.setString(36, v.elementAt(35).toString());
    pstmt.setString(37, v.elementAt(36).toString());
    pstmt.setString(38, v.elementAt(37).toString());
    pstmt.setString(39, v.elementAt(38).toString());
    pstmt.setString(40, v.elementAt(39).toString());
    pstmt.setString(41, v.elementAt(40).toString());
    pstmt.setString(42, v.elementAt(41).toString());
    pstmt.setString(43, v.elementAt(42).toString());
    pstmt.setString(44, v.elementAt(43).toString());
    pstmt.setString(45, v.elementAt(44).toString());
    pstmt.setString(46, v.elementAt(45).toString());
    pstmt.setString(47, v.elementAt(46).toString());
    pstmt.setString(48, v.elementAt(47).toString());
    pstmt.setString(49, v.elementAt(48).toString());
    pstmt.setString(50, v.elementAt(49).toString());
    pstmt.setString(51, v.elementAt(50).toString());
    pstmt.setString(52, v.elementAt(51).toString());
    pstmt.setString(53, v.elementAt(52).toString());
    pstmt.setString(54, v.elementAt(53).toString());
    pstmt.setString(55, v.elementAt(54).toString());
    pstmt.setString(56, v.elementAt(55).toString());
    pstmt.setString(57, v.elementAt(56).toString());
    pstmt.setString(58, v.elementAt(57).toString());
    pstmt.setString(59, v.elementAt(58).toString());
    pstmt.setString(60, v.elementAt(59).toString());
    pstmt.setString(61, v.elementAt(60).toString());
    pstmt.setString(62, v.elementAt(61).toString());
    pstmt.setString(63, filename);
    pstmt.executeUpdate();
    pstmt.close();
    System.out.println("Insert insertVendorMasterTB Complete !!!");
  }
  
  private String getMsgError(Exception err, String className, String methodName) {
    String errorMsg = "[Exception : " + err.getClass().getName() + "] [Cause : " + err.getMessage() + "] [Class : " + className + "] [Method : " + methodName + "]";
    errorMsg = errorMsg.replace("\n", "");
    errorMsg = errorMsg.replace("\"", "\\\"");
    return errorMsg;
  }
}
