package com.ais.sem.vendor.transfer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import oracle.jdbc.OracleTypes;

import com.ais.sem.vendor.db.ConnectDb;
import com.ais.sem.vendor.util.FileUtilities;
import com.ais.sem.vendor.util.SFTPUtilities;
import com.ais.sem.vendor.util.Utilities;
import com.ais.sem.vendor.model.VendorMaster;
import com.ais.sem.vendor.transfer.GenFileVendorMaster;

public class GenFileVendorMaster {
	private int totalRowHead = 0;
	private int totalRowDetail = 0;
	private String fileNameDat = "";
	private String fileNameSyn = "";
	private String createBy = "";
	
	private VendorMaster vMaster = null;
	
	private static String system = Utilities.getResources("system");
	 
	public static void main(String[] args){
		GenFileVendorMaster genText = new GenFileVendorMaster();
		
		String filename = "SEMAP_AIS_" + Utilities.formatDateYYYYMMDD() + "_test";
		VendorMaster vMaster = new VendorMaster();
		vMaster.setFileName(filename);
		
		genText.doProcess("", vMaster);
	}
	
	public void doProcess(String ref, VendorMaster vMaster){				
		try{	
			this.vMaster = vMaster;
			
			fileNameDat = vMaster.getFileName() + ".dat";
			fileNameSyn = vMaster.getFileName() + ".syn";
				
			System.out.println("fileNameSyn = " + fileNameSyn);
			System.out.println("fileNameSyn = " + fileNameSyn);
			System.out.println("system = " + system);	
			
			if(system.equalsIgnoreCase("window")){
				writeFileOnWindow();
			} else if(system.equalsIgnoreCase("linux")){
				writeFileOnLinux();
			}
			
		}catch(Exception e){
			e.printStackTrace(); 
		}
	}
	
	private void writeFileOnWindow(){
		
		Connection con = null;
		
		try {       
            
			con = ConnectDb.dbConnectSEM();
			
			String sapPath = FileUtilities.sapPath;
			writeFileDat(con, sapPath);
			writeFileSyn(con, sapPath);
			
		} catch (Exception e) {
			System.out.println("error : " + e);
			e.printStackTrace();
		} finally {
			System.out.println("... finally writeFileOnWindow ...");
			try {
				if (con != null){
					con.close();
					System.out.println("... con.close ...");
				}				
			} catch (Exception e) {
				System.out.println("error : " + e);
			} 
		}
	}
	
	private void writeFileOnLinux() {
		
		Connection con = null;
		
		try {
            
			con = ConnectDb.dbConnectSEM();
		    try {
		        con.setAutoCommit(false);
		      } catch (SQLException e1) {
		        e1.printStackTrace();
		      } 
			String tempPath = SFTPUtilities.temp_path;
			writeFileDat(con, tempPath);
			writeFileSyn(con, tempPath);
			
			// transfer to mqdev			
			SFTPUtilities sftp = new SFTPUtilities(true);
			sftp.put(SFTPUtilities.temp_path + fileNameDat, SFTPUtilities.sapPath);
			sftp.put(SFTPUtilities.temp_path + fileNameSyn, SFTPUtilities.sapPath);
			sftp.disconnect();
			try {  
				con.commit();
		        con.setAutoCommit(true);
		      } catch (SQLException e1) {
		        e1.printStackTrace();
		     } 
		} catch (Exception e) {
			System.out.println("error : " + e);
			e.printStackTrace();
		}finally {
			System.out.println("... finally writeFileOnWindow ...");
			try {
				if (con != null){
					con.close();
					System.out.println("... con.close ...");
				}			
			} catch (Exception e) {
				System.out.println("error : " + e);
			} 
		}
	}
	
	private void writeFileDat(Connection con,String sapPath) throws Exception{	 

		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		try {
		
			String sql = "";
			String dataValue = "";
			
			/** write file .dat */
			File fileDat = new File(sapPath, fileNameDat);
			FileOutputStream fos = new FileOutputStream(fileDat);
			OutputStreamWriter out = new OutputStreamWriter(fos,"Cp874"); 
			BufferedWriter bw = new BufferedWriter(out);
			
			sql = "call sem_sp_gen_vendor_sap (?)";
	    	cstmt = con.prepareCall(sql);
	    	cstmt.setObject(1, null); 
	    	//cstmt.registerOutParameter(1, OracleTypes.CURSOR);
	    	cstmt.registerOutParameter(1, Types.OTHER);
	    	
	    	cstmt.execute();
	    	 
	    	rs = (ResultSet) cstmt.getObject(1);
	    	
	    	
	    	
	    	//** write Detail **//
			while(rs.next()) {
				totalRowDetail++;
				StringBuffer sbDetail = new StringBuffer();
				
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					//if(i > 1){
						dataValue = nullToEmpty(rs.getString(rs.getMetaData().getColumnName(i)));
						sbDetail.append(dataValue);
						
						if (i != rs.getMetaData().getColumnCount()) {
							sbDetail.append("|");
						}
					//}
				}
				bw.write(sbDetail.toString());
				bw.newLine();							
			}
            bw.write("E");
			bw.newLine();
			
			bw.close();
			out.close();
			fos.close(); 
			
		} catch (Exception e) {
			con.rollback();
			System.out.println("error : " + e);
			e.printStackTrace();
			throw e;
		} finally {
			System.out.println("... finally writeFileDat ...");
			try {
				
				if (rs != null)	rs.close();
				if (cstmt != null)	cstmt.close();		
			} catch (Exception e) {
				System.out.println("error : " + e);
			} 
		}
	}
	
	private void writeFileSyn(Connection con, String sapPath) throws Exception{	
		
		int totalRecord = 0;
		
		File fileSyn = new File(sapPath, fileNameSyn);
	    FileOutputStream fos = new FileOutputStream(fileSyn);
	    OutputStreamWriter out = new OutputStreamWriter(fos, "Cp874");
	    BufferedWriter bw = new BufferedWriter(out);
	    
	    totalRecord = totalRowHead + totalRowDetail;

	    String totalAmount = Integer.toString(totalRowDetail);//String.valueOf(getToTalAmount(con));
	    
	    String strColumn = "Total record|Total amount|UserID|Email|Createdate|Time";	
	    bw.write(strColumn);
	    bw.newLine();
	    
	    strColumn = totalRecord+"|"+Utilities.toDecimal(totalAmount,2)+"|"+this.vMaster.getUserId()+"|"+this.vMaster.getEmail()+"|"+Utilities.formatDateYYYYMMDD()+"|"+Utilities.formatTimeHHMMSS();
	    bw.write(strColumn);	
	    bw.newLine();
	    
	    bw.write("E");
	    bw.newLine();
  
	    bw.close();
	    out.close();
	    fos.close();
	}
	
	private String nullToEmpty(String str){
		return str == null ? "" : str;
	}
}
