package com.ais.batch.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
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
				        if(filename.indexOf("SAPCA_") != -1 && filename.indexOf(formatFileName) != -1){
				        	vNameAll.addElement(filename.trim());
						}
				    }
				    
				    for(int i=0;vNameAll!=null&&i<vNameAll.size();i++){
				    	String filename = Utilities.cutExtension(vNameAll.get(i).toString().trim());
				    	String filedat = filename.concat(".dat");
				    	String filesyn = filename.concat(".syn");
				    	
				    	int numdat = 0;
				    	
				    	for(int j=0;j<vNameAll.size();j++){
				    		if(vNameAll.get(j).toString().equals(filedat) || vNameAll.get(j).toString().equals(filesyn)){				    				
				    			numdat = numdat + 1;
					    	}
				    	}
				    	
				    	if(numdat == 2){
				    		resultV.addElement(filedat);
				    		vNameAll.remove(filedat);
				    		vNameAll.remove(filesyn);
				    		i = 0;
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
	
	/*public static void main(String arg[]) throws Exception{
		   FileUtilities f = new FileUtilities();
		   String formatFileName = Utilities.addDate(Utilities.getCurrentDate(),0);
		   f.getFileNameAll(f.sapPath, formatFileName);
		   Vector v = f.readLines(f.sapPath, "SEMAP_COMP_20110106_ekarut_0001.log");
		   System.out.println(v.get(0));
		
	}*/
}
