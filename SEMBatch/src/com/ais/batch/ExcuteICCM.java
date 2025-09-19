package com.ais.batch;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ais.batch.db.ConnectDb;


public class ExcuteICCM {
	
	protected static final Log logger = LogFactory.getLog(ExcuteICCM.class);
	private static String url = "jdbc:oracle:thin:@10.208.152.170:1521:aacmtst";
	private static String username = "sem";
	private static String password = "sem123#";
	private static Connection conn = null;

	

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Date convertedDate = null;
		String errorMsg = null;
		String status = "ERROR";
		String[] tmp = {null,null};
		if (args.length == 0) {
//			args[0]= "TEST1";
//			args[1]="null";
			args = tmp;
		}	
		if (args.length==1){
			tmp[0] = args[0];
			args = tmp;
		}
		
		try {
			
			System.out.println("===== [Start Batch Excution] =====");
			System.out.println("Parameter 1 : " + args[0]);
			System.out.println("Parameter 2 : " + args[1]);
//			if (args.length == 1) {
//			if (args.length == 2) {
			if(args.length ==2){			
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
//				conn = DriverManager.getConnection(url, username, password);
				conn = ConnectDb.dbConnectSEM();
				
				System.out.println("Parameter 1 : " + args[0]);
				System.out.println("Parameter 2 : " + args[1]);
				
//				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
//			    convertedDate = (Date) dateFormat.parse(args[0]);
			    logger.debug(" conn  : "+conn);
			    CallableStatement stmt = conn.prepareCall("{call SEM_ICCM_CONTRACT.INF_ICCM_CONTRACT(?,?)}");
//			    stmt.setDate(1, new java.sql.Date(convertedDate.getTime()));
			    stmt.setString(1, args[0]);
				stmt.setString(2, args[1]);
				stmt.execute();
			    logger.debug(" conn  : "+conn);
				status = "SUCCESS";
			}
			
		}catch (Exception e) {
			errorMsg = e.getMessage();
			e.printStackTrace();
			logger.error(e);
		}finally {
			if (conn != null && !conn.isClosed()){
				conn.close();
			}
			System.out.println("Arg Length"+args.length );
			System.out.println("Status : " + status);
			System.out.println("Exception : " + errorMsg);
			System.out.println("===== [End Batch Excution] =====");
			
			System.exit(1);
		}
	System.out.println("FINISH");
	}
	

}
