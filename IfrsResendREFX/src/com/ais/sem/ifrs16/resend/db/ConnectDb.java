package com.ais.sem.ifrs16.resend.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

import com.ais.sem.ifrs16.resend.util.Utilities;

public class ConnectDb {  
	private static String url = Utilities.getResources("db_url");
	private static String user = Utilities.getResources("db_user");
	private static String pass = Utilities.getResources("db_pass");
	
	 public static Connection dbConnectSEM() throws Exception {
        Connection conn = null;

        try {          	
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, user, pass);

        } catch (Exception e) {
            System.out.println("error : "+e);
            e.printStackTrace();
        }
        return conn;
    }
    
    public static boolean supportsTransactions(Connection conn) throws Exception {

        if (conn == null) {
            return false;
        }

        DatabaseMetaData dbMetaData = conn.getMetaData();
        if (dbMetaData == null) {
            // metadata is not supported
            return false;
        }

        return dbMetaData.supportsTransactions();
    }
    
    public static void main(String[] args)  throws Exception {
		new ConnectDb().dbConnectSEM();	
    }
    
}

