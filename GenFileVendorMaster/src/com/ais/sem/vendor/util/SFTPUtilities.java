package com.ais.sem.vendor.util;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Vector;

import org.apache.commons.vfs.FileSystemException;
import org.apache.commons.vfs.FileSystemOptions;
import org.apache.commons.vfs.provider.sftp.SftpClientFactory;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.SftpException;
import com.jcraft.jsch.ChannelSftp.LsEntry;

public class SFTPUtilities {
	
	/** Static **/
	private static String host = Utilities.getResources("sftp_hostname");
	private static String username = Utilities.getResources("sftp_username");
	private static String password = Utilities.getResources("sftp_password");
	private static int port = Integer.parseInt(Utilities.getResources("sftp_port"));
	private static int timeout = Integer.parseInt(Utilities.getResources("sftp_timeout"));
	public static String temp_path = Utilities.getResources("temp_path"); 
	public static String sapPath = Utilities.getResources("sap_path"); 
	
	/** Attributes **/
	private ChannelSftp channelSftp;
	public ChannelSftp getChannelSftp() { return channelSftp;	}
	
	/** Global **/
	private FileSystemOptions opts;
	private Session session;
	private Channel channel;
		
	/** Constructors **/
	public SFTPUtilities(){}
	public SFTPUtilities(boolean isConnect){
		if(isConnect){
			connect();
		}
	}
	
	/** Method: connect/disconnect **/
	public ChannelSftp connect(){
		try {			
			createSession();			
			channel = session.openChannel("sftp");			
			channel.connect();		
			System.out.println("SFTP channel is connecting...");	
			channelSftp = (ChannelSftp)channel;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return channelSftp;
	}
	private void createSession(){		
		try {

			/*FileSystemManager fsManager =  VFS.getManager();			                
			UserAuthenticator auth = new StaticUserAuthenticator(null, "login","passwd");	
			FileSystemOptions  opts = new FileSystemOptions();	
			try {
				DefaultFileSystemConfigBuilder.getInstance().setUserAuthenticator(opts,auth);
			} 
			catch (FileSystemException ex) { 
				throw new RuntimeException("setUserAuthenticator failed", ex); 
			}
			FileObject fss = fsManager.resolveFile("sftp://x.x.x.x/export/home/", opts);*/
			
			System.out.println("\ncreateConnection...");
			
			session = SftpClientFactory.createConnection(
			           host, 
			           port, 
			           username.toCharArray(), 
			           !"".equals(password)?password.toCharArray():null, 
			           opts);

			session.setTimeout(timeout);
			
			/** Print session's attributes **/			
			System.out.println("Sftp connect: "+ username+"@"+session.getHost()+":"+port);
			System.out.println("Server version: "+session.getServerVersion());
			System.out.println("ClientVersion: "+session.getClientVersion());
			System.out.println("Timeout: "+session.getTimeout());			
			
		} catch (FileSystemException fex) {
			fex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void disconnect() {
		try {
			if (channelSftp != null) {
					 channelSftp.disconnect();
					 System.out.println("ChannelSftp disconnected");
			}
			
			if(channel != null){
					 channel.disconnect();
					 System.out.println("Channel disconnected");
			}
			
			if(session != null){
					 session.disconnect();
					 System.out.println("Session disconnected");
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/** Method: general **/
	public void get(String srcFile, String descPath){
		try {
			System.out.println("-------------------");
			System.out.println("SFTPUtilities.get()");
			System.out.println("-------------------");
			
			/** $scp srcFile to descPath **/
		    Vector vSap = channelSftp.ls(srcFile);
			if(vSap.isEmpty()){
				System.out.println(srcFile.concat(" not found."));
			}else{
				String hostFile = session.getHost().concat("@").concat(srcFile);
				SftpATTRS fSapAttrs = ((LsEntry)vSap.firstElement()).getAttrs();
				
				System.out.println("SFTP geting...");
		    	System.out.println("  from: "+session.getHost().concat("@").concat(srcFile));
		    	System.out.println("  to: "+descPath);
		    	
		    	//Owner can't read
				if('r'!=fSapAttrs.getPermissionsString().charAt(1)){ 
					System.out.println("  msg: Can't read "+hostFile+" [Permissions is "+fSapAttrs.getPermissionsString()+"]");	
			    }else{			    	
			    	channelSftp.get(srcFile, descPath);
				    System.out.println("  msg: Success!");
			    }
			}			
		} catch (SftpException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}	
	public void put(String srcFile, String descPath){
		try {
			System.out.println("-------------------");
			System.out.println("SFTPUtilities.put()");
			System.out.println("-------------------");
			
			/** $scp srcFile to descPath **/
			File fSem = new File(srcFile);
			if(!fSem.exists()){
				System.out.println(srcFile.concat(" not found."));
			}else{
				
				System.out.println("SFTP puting...");
		    	System.out.println("  from: "+srcFile);
		    	System.out.println("  to: "+session.getHost().concat("@").concat(descPath));
				if(!fSem.canRead()){
					System.out.println("  msg: ".concat(srcFile).concat(" can't Read."));
				}else{					
			    	channelSftp.put(srcFile, descPath);
				    System.out.println("  msg: Success!");
			    }
			}
		} catch (SftpException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	public void ls(String path){
		try {
			System.out.println("-------------------------");
			System.out.println("SFTPUtilities.ls()");
			System.out.println("-------------------------");
			
			/** $ls -l **/
		    System.out.println("ls -l "+path);
		    Vector v = channelSftp.ls(path);
		    if(v!=null){
		    	for(int i=0; i<v.size(); i++){		    	
		    		Object obj=v.elementAt(i);
		    		if(obj instanceof LsEntry){
		    			LsEntry lsEntry = (LsEntry)obj;		    			
		    			System.out.println(lsEntry.getLongname());	 	    			
		    		}
		    	}
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	public Vector readLines(String path, String file) throws Exception{
		System.out.println("-------------------------");
		System.out.println("SFTPUtilities.readLines()");
		System.out.println("-------------------------");
		Vector resultV = new Vector();
		try{     		
			if(path!=null && file!=null){
				if(path.length()!=0 && file.length()!=0){
					System.out.println("Read "+session.getHost().concat("@").concat(path+file));
					Vector lsFiles = channelSftp.ls(path.concat(file));			
					if(lsFiles.size()>0)	{				
						InputStream inputS = channelSftp.get(path.concat(file));			
						LineNumberReader lineR= new LineNumberReader(new InputStreamReader(inputS,"Cp874"));								
						String c;        		
		        		while ((c=lineR.readLine())!=null && !c.equals("E")){
		        				resultV.addElement(c.trim());	
		        				System.out.println(c);
		          		}
		          		inputS.close();          		
					}					
				}
			}	
			return resultV;
		}catch(Exception e){
			throw e;
		}		
	}
	
	public Vector getFileNameAll(String path,String formatFileName){
		System.out.println("-------------------------");
		System.out.println("SFTPUtilities.readAllFiles()");
		System.out.println("-------------------------");
		Vector resultV = new Vector();
		Vector vSyn = new Vector();
		Vector vDat = new Vector();
		
		int orgmax = 0;
		
		try {				
			
		    System.out.println("ls -l "+path);
		    Vector v = channelSftp.ls(path);
		    if(v!=null){
		    	for(int i=0; i<v.size(); i++){		    	
		    		Object obj=v.elementAt(i);
		    		if(obj instanceof LsEntry){
		    			LsEntry lsEntry = (LsEntry)obj;			    			
		    			resultV.addElement(lsEntry.getFilename().trim());		    				
		    			}
		    			 	    			
		    		}	
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultV;
	}
	
	
	public int subStringToInteger(String fileName,int lengthNum){
		   int index = fileName.indexOf(".") - lengthNum;
		   int last = fileName.indexOf(".");
		   int num = (int) Integer.valueOf(fileName.substring(index,last)); 
		return num;
	}
	
}
