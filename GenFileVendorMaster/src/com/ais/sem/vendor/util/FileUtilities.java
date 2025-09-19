package com.ais.sem.vendor.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Vector;

public class FileUtilities {
	public static String sapPath = Utilities.getResources("sap_path"); 
	
	public Vector getFileNameAll(String path,String formatFileName){
		
		
			System.out.println("-------------------------");
			System.out.println("FileUtilities.readAllFiles()");
			System.out.println("-------------------------");
			Vector resultV = new Vector();
			Vector vNameAll = new Vector();
			Vector vAck = new Vector();
			
		try {	
				File dir = new File(path);
				String[] children = dir.list();
				if (children == null) {		    
					System.out.println("Either dir does not exist or is not a directory ");
				} else {
				    for (int i=0; i<children.length; i++) {
				        // Get filename of file or directory
				        String filename = children[i];
				       // System.out.println("filename = "+filename);
				        if(filename.indexOf(formatFileName) != -1){
				        	vNameAll.addElement(filename.trim());
						}
				    }
				}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultV; 
	}
	
	public Vector readLines(String path, String filename) throws Exception{
		System.out.println("-------------------------");
		System.out.println("FileUtilities.readLines()");
		System.out.println("-------------------------");
		Vector vector = new Vector();
	    Vector vChild = new Vector();
	    File file = null;
	    LineNumberReader lnreader = null;
	    String line;
	    
	    try{
	      
	      file = new File(sapPath.concat(filename));
	      FileInputStream fos = new FileInputStream(file);
	      
	      lnreader= new LineNumberReader(new InputStreamReader(fos,"Cp874"));
	      while ((line = lnreader.readLine()) != null && !line.equals("E")){
	        System.out.println("Line:  " + lnreader.getLineNumber() + ": " + line);		 
			vector.addElement(line.trim());
	      }
	      
	      
	      lnreader.close();
	      fos.close();
	    }catch(Exception e){
			throw e;
		}
	    
		return vector;
	}
	
}
