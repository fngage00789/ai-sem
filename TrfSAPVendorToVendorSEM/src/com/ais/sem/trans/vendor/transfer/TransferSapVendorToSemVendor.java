package com.ais.sem.trans.vendor.transfer;

import com.ais.sem.trans.vendor.db.ConnectDb;
import com.ais.sem.trans.vendor.util.Utilities;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TransferSapVendorToSemVendor {
  private String vendorId;
  
  private String vendorCode;
  
  private String vendorName1;
  
  private String vendorName2;
  
  private String bnkacc2;
  
  private String vendorName3;
  
  private String vendorName4;
  
  private String vendorName;
  
  private String street1;
  
  private String street2;
  
  private String street3;
  
  private String street4;
  
  private String district;
  
  private String amphur;
  
  private String city;
  
  private String region;
  
  private String bnkacc1;
  
  private String acchod1;
  
  private String bnkkey1;
  
  private String userId;
  
  private String vendorMasterId = "";
  
  private String perId;
  
  private String taxId;
  
  private String posCode;
  
  private String telPhone1;
  
  private String mobileNo;
  
  private String faxNo;
  
  private String rectyp1;
  
  private String tax13;
  
  private String status;
  
  private String vendor_status;
  
  private String record_status;
  
  public static void main(String[] args) throws Exception {
	System.out.println("=================== Begin Process TransferSapVendorToSemVendor  ===================");
	//String pkVendorCodeId = getPkVendorBookBank();
	//System.out.println("pkVendorCodeId :" +pkVendorCodeId);	
	TransferSapVendorToSemVendor textToTable = new TransferSapVendorToSemVendor();
    textToTable.doProcess();
    System.out.println("=================== End Process TransferSapVendorToSemVendor  ===================");
  }
  
  public void doProcess() {
    Connection con = null;
    PreparedStatement pstmt = null;
    try {
      transferData();
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  private void transferData() throws Exception {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String strSet = "";
    String strSql = "";
    try {
      con = ConnectDb.dbConnectSEM();
      con.setAutoCommit(false);
      strSql = "select t.* from sap_vendor_master t where t.create_file in (select file_name from sap_vendor_master_log where coalesce(sem_status,'00') = '00' )";
      pstmt = con.prepareStatement(strSql);
      rs = pstmt.executeQuery();
      while (rs.next()) {
        this.vendorId = Utilities.nvl(rs.getString("PREACC"));
        this.vendorCode = Utilities.nvl(rs.getString("VENCOD"));
        this.bnkacc2 = Utilities.nvl(rs.getString("BNKACC2"));
        this.vendorName1 = Utilities.nvl(rs.getString("VENNAM1"));
        this.vendorName2 = Utilities.nvl(rs.getString("VENNAM2"));
        this.vendorName3 = Utilities.nvl(rs.getString("VENNAM3"));
        this.vendorName4 = Utilities.nvl(rs.getString("VENNAM4"));
        this.vendorName = String.valueOf(this.vendorName1) + this.vendorName2 + this.vendorName3 + this.vendorName4;
        this.street1 = Utilities.nvl(rs.getString("STREET1"));
        this.street2 = Utilities.nvl(rs.getString("STREET2"));
        this.street3 = Utilities.nvl(rs.getString("STREET3"));
        this.street4 = Utilities.nvl(rs.getString("STREET4"));
        this.district = Utilities.nvl(rs.getString("DISTRI"));
        this.amphur = Utilities.nvl(rs.getString("CITY01"));
        this.city = Utilities.nvl(rs.getString("REGION"));
        this.bnkkey1 = Utilities.nvl(rs.getString("BNKKEY1"));
        this.bnkacc1 = Utilities.nvl(rs.getString("BNKACC1"));
        this.acchod1 = Utilities.nvl(rs.getString("ACCHOD1"));
        this.userId = Utilities.nvl(rs.getString("USRSTA"));
        this.taxId = Utilities.nvl(rs.getString("TAXID"));
        this.posCode = Utilities.nvl(rs.getString("POSCOD"));
        this.telPhone1 = Utilities.nvl(rs.getString("TELPHO1"));
        this.mobileNo = Utilities.nvl(rs.getString("MOBILENO"));
        this.faxNo = Utilities.nvl(rs.getString("FAXNO"));
        this.rectyp1 = Utilities.nvl(rs.getString("RECTYPE1"));
        this.tax13 = Utilities.nvl(rs.getString("TAXID"));
        this.status = Utilities.nvl(rs.getString("STATUS"));
        if ("BLK".equals(this.status.toString())) {
          this.vendor_status = "06";
          this.record_status = "N";
        } else {
          this.vendor_status = "03";
          this.record_status = "Y";
        } 
        if (!this.vendorId.equals("")) {
          boolean foundCurrSEM = foundVendorMasterIdInSemCTVendorMasterTB(con, this.vendorId);
          if (!foundCurrSEM) {
            strSql = "insert  into SEM_CT_VENDOR_MASTER( VENDOR_MASTER_ID,VENDOR_CODE,VENDOR_NAME,VENDOR_NAME1,VENDOR_NAME2,VENDOR_NAME3,VENDOR_NAME4,VENDOR_TYPE,TAX_ID,  ADDRESS,ADDRESS1,ADDRESS2,ADDRESS3,ADDRESS4,DISTRICT,AMPHUR,POST_CODE,CITY,TELEPHONE,MOBILE_NO,FAX,VENDOR_STATUS,RECORD_STATUS,  VERSION,CREATE_DT,CREATE_BY,TAX13  ) values(?,?,?,?,?,?,?,?,?,? ,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,current_timestamp,?,?)";
            System.out.println("SEM missing vendorMasterId key: = " + this.vendorCode);
            pstmt = con.prepareStatement(strSql);
            pstmt.setString(1, this.vendorCode);
            pstmt.setString(2, this.vendorCode);
            pstmt.setString(3, this.vendorName);
            pstmt.setString(4, this.vendorName1);
            pstmt.setString(5, this.vendorName2);
            pstmt.setString(6, this.vendorName3);
            pstmt.setString(7, this.vendorName4);
            pstmt.setString(8, this.rectyp1.equals("03") ? "01" : "02");
            pstmt.setString(9, this.taxId);
            pstmt.setString(10, String.valueOf(this.street1) + this.street2 + this.street3 + this.street4 + this.district + this.city);
            pstmt.setString(11, this.street1);
            pstmt.setString(12, this.street2);
            pstmt.setString(13, this.street3);
            pstmt.setString(14, this.street4);
            pstmt.setString(15, this.district);
            pstmt.setString(16, this.amphur);
            pstmt.setString(17, this.posCode);
            pstmt.setString(18, this.city);
            pstmt.setString(19, this.telPhone1);
            pstmt.setString(20, this.mobileNo);
            pstmt.setString(21, this.faxNo);
            pstmt.setString(22, this.vendor_status);
            pstmt.setString(23, this.record_status);
            pstmt.setString(24, "0");
            pstmt.setString(25, this.userId);
            pstmt.setString(26, this.tax13);
            pstmt.executeUpdate();
          } else {
            pstmt = con.prepareStatement("update  SEM_CT_VENDOR_MASTER  set VENDOR_CODE = ?,  ADDRESS1 = ?,ADDRESS2 = ?,ADDRESS3 = ?,ADDRESS4 = ?,DISTRICT = ?,AMPHUR = ?,CITY_CODE = ?, VENDOR_STATUS = ?,UPDATE_BY = ?,UPDATE_DT = current_timestamp, TAX13 = ? ,RECORD_STATUS = ? where VENDOR_MASTER_ID = ?");
            pstmt.setString(1, this.vendorCode);
            pstmt.setString(2, this.street1);
            pstmt.setString(3, this.street2);
            pstmt.setString(4, this.street3);
            pstmt.setString(5, this.street4);
            pstmt.setString(6, this.district);
            pstmt.setString(7, this.amphur);
            pstmt.setString(8, this.city);
            pstmt.setString(9, this.vendor_status);
            pstmt.setString(10, this.userId);
            pstmt.setString(11, this.tax13);
            pstmt.setString(12, this.record_status);
            pstmt.setString(13, this.vendorId);
            pstmt.executeUpdate();
            if (!this.bnkacc1.equals(""))
              updateSemCTVendorBookBank(con, this.vendorId); 
          } 
          if (pstmt != null)
            pstmt.close(); 
          continue;
        } 
        boolean found = foundVendorCodeInSemCTVendorMasterTB(con, this.vendorCode);
        if (found) {
          pstmt = con.prepareStatement("update  SEM_CT_VENDOR_MASTER  set VENDOR_CODE = ?,  ADDRESS = ?,ADDRESS1 = ?,ADDRESS2 = ?,ADDRESS3 = ?,ADDRESS4 = ?, DISTRICT = ?,AMPHUR = ?,CITY_CODE = ?,VENDOR_STATUS = ?,UPDATE_BY = ?,UPDATE_DT = current_timestamp, TAX13 = ?,  RECORD_STATUS = ?  where VENDOR_CODE = ?");
          pstmt.setString(1, this.vendorCode);
          pstmt.setString(2, String.valueOf(this.street1) + this.street2 + this.street3 + this.street4 + this.district + this.city);
          pstmt.setString(3, this.street1);
          pstmt.setString(4, this.street2);
          pstmt.setString(5, this.street3);
          pstmt.setString(6, this.street4);
          pstmt.setString(7, this.district);
          pstmt.setString(8, this.amphur);
          pstmt.setString(9, this.city);
          pstmt.setString(10, this.vendor_status);
          pstmt.setString(11, this.userId);
          pstmt.setString(12, this.tax13);
          pstmt.setString(13, this.record_status);
          pstmt.setString(14, this.vendorCode);
          pstmt.executeUpdate();
          if (!this.bnkacc1.equals(""))
            updateSemCTVendorBookBank(con, this.vendorMasterId); 
          if (pstmt != null)
            pstmt.close(); 
          continue;
        } 
        strSql = "insert  into SEM_CT_VENDOR_MASTER( VENDOR_MASTER_ID,VENDOR_CODE,VENDOR_NAME,VENDOR_NAME1,VENDOR_NAME2,VENDOR_NAME3,VENDOR_NAME4,VENDOR_TYPE,TAX_ID,  ADDRESS,ADDRESS1,ADDRESS2,ADDRESS3,ADDRESS4,DISTRICT,AMPHUR,POST_CODE,CITY,TELEPHONE,MOBILE_NO,FAX,VENDOR_STATUS,RECORD_STATUS,  VERSION,CREATE_DT,CREATE_BY  ) values(?,?,?,?,?,?,?,?,?,? ,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,current_timestamp,?)";
        String pkVendorCodeId = getPkVendorIdMaster();
        System.out.println("pkVendorCodeId = " + pkVendorCodeId);
        pstmt = con.prepareStatement(strSql);
        pstmt.setString(1, pkVendorCodeId);
        pstmt.setString(2, this.vendorCode);
        pstmt.setString(3, this.vendorName);
        pstmt.setString(4, this.vendorName1);
        pstmt.setString(5, this.vendorName2);
        pstmt.setString(6, this.vendorName3);
        pstmt.setString(7, this.vendorName4);
        pstmt.setString(8, this.rectyp1.equals("03") ? "01" : "02");
        pstmt.setString(9, this.taxId);
        pstmt.setString(10, String.valueOf(this.street1) + this.street2 + this.street3 + this.street4 + this.district + this.city);
        pstmt.setString(11, this.street1);
        pstmt.setString(12, this.street2);
        pstmt.setString(13, this.street3);
        pstmt.setString(14, this.street4);
        pstmt.setString(15, this.district);
        pstmt.setString(16, this.amphur);
        pstmt.setString(17, this.posCode);
        pstmt.setString(18, this.city);
        pstmt.setString(19, this.telPhone1);
        pstmt.setString(20, this.mobileNo);
        pstmt.setString(21, this.faxNo);
        pstmt.setString(22, this.vendor_status);
        pstmt.setString(23, this.record_status);
        pstmt.setString(24, "0");
        pstmt.setString(25, this.userId);
        pstmt.executeUpdate();
        if (pstmt != null)
          pstmt.close(); 
        if (!this.bnkacc1.equals("")) {
          strSql = "insert  into SEM_CT_VENDOR_BOOKBANK( VENDOR_BOOKBANK_ID,VENDOR_MASTER_ID,BANK_ACC_NO,BANK_ACC_NAME,BANK_CODE,VENDOR_BOOKBANK_STATUS,RECORD_STATUS,VERSION,CREATE_DT,  CREATE_BY  ) values(?,?,?,?,?,?,?,?,current_timestamp ,?)";
          pstmt = con.prepareStatement(strSql);
          pstmt.setString(1, getPkVendorBookBank());
          pstmt.setString(2, pkVendorCodeId);
          pstmt.setString(3, this.bnkacc1);
          pstmt.setString(4, this.acchod1);
          pstmt.setString(5, this.bnkkey1);
          pstmt.setString(6, "06");
          pstmt.setString(7, "Y");
          pstmt.setString(8, "0");
          pstmt.setString(9, this.userId);
          pstmt.executeUpdate();
          if (pstmt != null)
            pstmt.close(); 
        } 
      } 
      String sql = "update sap_vendor_master_log set sem_status = '01', update_dt = current_timestamp where coalesce(sem_status,'00') = '00'";
      pstmt = con.prepareStatement(sql);
      pstmt.executeUpdate();
      System.out.println("Update Do");
    } catch (Exception e) {
      if (con != null) {
        con.rollback();
        con.close();
        System.out.println("Connection rollback...");
      } 
      System.out.println("error : " + e);
      e.printStackTrace();
      throw e;
    } finally {
      con.commit();
      System.out.println("... finally con.commit ...");
      System.out.println("... finally transferData TransferSapVendorToSemVendor ...");
      try {
        if (rs != null)
          rs.close(); 
        if (pstmt != null)
          pstmt.close(); 
        if (con != null)
          con.close(); 
      } catch (Exception e) {
        System.out.println("error : " + e);
      } 
    } 
  }
  
  private void updateSemCTVendorBookBank(Connection con, String vendorId) throws Exception {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      pstmt = con.prepareStatement("update  SEM_CT_VENDOR_BOOKBANK  set BANK_CODE = ?,BANK_ACC_NO = ?,BANK_ACC_NAME = ?, VENDOR_BOOKBANK_STATUS = ?,UPDATE_BY = ?,UPDATE_DT = current_timestamp  where VENDOR_MASTER_ID = ? and BANK_ACC_NO = ?");
      pstmt.setString(1, this.bnkkey1);
      pstmt.setString(2, this.bnkacc1);
      pstmt.setString(3, this.acchod1);
      pstmt.setString(4, "06");
      pstmt.setString(5, this.userId);
      pstmt.setString(6, vendorId);
      pstmt.setString(7, this.bnkacc1);
      pstmt.executeUpdate();
    } catch (Exception e) {
      System.out.println("error : " + e);
      e.printStackTrace();
      throw e;
    } finally {
      System.out.println("... finally updateSemCTVendorBookBank ...");
      try {
        if (rs != null)
          rs.close(); 
        if (pstmt != null)
          pstmt.close(); 
      } catch (Exception e) {
        System.out.println("error : " + e);
      } 
    } 
  }
  
  private boolean foundVendorCodeInSemCTVendorMasterTB(Connection con, String vendorCode) throws Exception {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    boolean result = false;
    try {
      pstmt = con.prepareStatement("select VENDOR_MASTER_ID from SEM_CT_VENDOR_MASTER where VENDOR_CODE = '" + vendorCode + "'");
      rs = pstmt.executeQuery();
      if (rs.next()) {
        result = true;
        this.vendorMasterId = Utilities.nvl(rs.getString("VENDOR_MASTER_ID"));
      } 
    } catch (Exception e) {
      System.out.println("error : " + e);
      e.printStackTrace();
      throw e;
    } finally {
      System.out.println("... finally foundVendorCodeInSemCTVendorMasterTB ...");
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
  
  public static boolean foundVendorMasterIdInSemCTVendorMasterTB(Connection con, String preAcc) throws Exception {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    boolean result = false;
    try {
      pstmt = con.prepareStatement("select VENDOR_MASTER_ID from SEM_CT_VENDOR_MASTER where VENDOR_MASTER_ID = '" + preAcc + "'");
      rs = pstmt.executeQuery();
      if (rs.next())
        result = true; 
    } catch (Exception e) {
      System.out.println("error : " + e);
      e.printStackTrace();
      throw e;
    } finally {
      System.out.println("... finally foundVendorIdInSemCTVendorMasterTB ...");
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
  
  private  String getPkVendorIdMaster() throws Exception {
    Connection con = ConnectDb.dbConnectSEM();
    String call = "{? = call SEM_FN_GET_RUNNING_NO('CT_VENDOR_MASTER')}";
    CallableStatement cstmt = con.prepareCall(call);
    cstmt.registerOutParameter(1, 12);
    cstmt.executeUpdate();
    String val = cstmt.getString(1);
    cstmt.close();
    con.close();
    return val;
  }
  
  private  String getPkVendorBookBank() throws Exception {
    Connection con = ConnectDb.dbConnectSEM();
    String call = "{? = call SEM_FN_GET_RUNNING_NO('CT_VENDOR_BOOKBANK')}";
    CallableStatement cstmt = con.prepareCall(call);
    cstmt.registerOutParameter(1, 12);
    cstmt.executeUpdate();
    String val = cstmt.getString(1);
    cstmt.close();
    con.close();
    return val;
  }
  
}
