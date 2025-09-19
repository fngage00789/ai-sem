package com.ais.sem.proc.run;

import com.ais.sem.proc.db.ConnectDb;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class ProceSemSpMac003File {
  public static void main(String[] args) {
  System.out.println("=================== Begin Process ProceSemSpMac003File  ==================="); 
    ProceSemSpMac003File proc = new ProceSemSpMac003File();
    try {
      proc.callProc();
    } catch (Exception e) {
      e.printStackTrace();
    } 
    System.out.println("=================== End Process ProceSemSpMac003File  ==================="); 
  }
  
  public void callProc() throws Exception {
	  String val = "";
	  ResultSet rs = null;
	  Connection con  = null;
	  CallableStatement cstmt = null;
	   try {
	     con = ConnectDb.dbConnectSEM();
	    try {
	      con.setAutoCommit(false);
	    } catch (SQLException e1) {
	      e1.printStackTrace();
	    } 
	    String call = "call SEM_SP_MAC003_FILE(?, ?)";
	    cstmt = con.prepareCall(call);
	    cstmt.setObject(1, null);	   
	    cstmt.setString(2, "");
	    cstmt.registerOutParameter(1, Types.OTHER);
	   // rs = cstmt.executeQuery();
	    cstmt.executeUpdate();
	    rs = (ResultSet)cstmt.getObject(1);
	    if (rs.next())
	      val = rs.getString("P_RESULT"); 
	    System.out.println("result call SEM_SP_MAC003_FILE = " + val);
	    con.commit();
	    con.setAutoCommit(true);
	   } catch (Exception e) {
		  con.rollback();
		  System.out.println("Error call SEM_SP_MAC003_FILE = " +e.getMessage());
	   } finally {
	      System.out.println("... finally SEM_SP_MAC003_FILE ...");
	      try {
	        if (rs != null)  rs.close(); 
	        if (cstmt != null)     	cstmt.close(); 
	        if (con != null) {
	          con.close();
	          System.out.println("... con.close ...");
	         } 
	      } catch (Exception e) {
	        System.out.println("error : " + e);
	      } 
	   }
  }
}
