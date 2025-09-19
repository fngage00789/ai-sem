package th.co.ais.util;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
	
	private String host = SAPUtility.getMessage("sftp_hostname");
	private String username = SAPUtility.getMessage("sftp_username");
	private String password = SAPUtility.getMessage("sftp_password");
	private int port = Integer.parseInt(SAPUtility.getMessage("sftp_port"));
	private int timeout = Integer.parseInt(SAPUtility.getMessage("sftp_timeout"));
	
	/** Attributes **/	
	private ChannelSftp channelSftp;
	public ChannelSftp getChannelSftp() { return channelSftp;	}
	
	/** Global **/
	private FileSystemOptions opts;
	private Session session;
	private Channel channel;
	
	/** Constructors **/
	public SFTPUtilities(){}
	public SFTPUtilities(boolean isConnect)throws Exception{
		if(isConnect){
			connect();
		}
	}
	
	public boolean isSessionConnected() {
		if(session==null) return false;
		else return session.isConnected();		
	}
	

	public void connect() throws Exception{		

		session = SftpClientFactory.createConnection(
										host, 
										port, 
										username.toCharArray(), 
										password.toCharArray(), 
										opts);
		
		session.setTimeout(timeout);					
		
		/** Print session's attributes **/			
		System.out.println("Sftp connect: "+ username+"@"+session.getHost()+":"+port);
		System.out.println("Server version: "+session.getServerVersion());
		System.out.println("ClientVersion: "+session.getClientVersion());
		System.out.println("Timeout: "+session.getTimeout());
		
		System.out.println("SFTP channel is connecting...");
		channel = session.openChannel("sftp");
		channel.connect();
		channelSftp = (ChannelSftp)channel;
		//channelSftp.connect();
		System.out.println("channelSftp.isConnected() : "+channelSftp.isConnected());
	}
	public void disconnect() throws Exception{
		if (channelSftp != null) {
			if (!channelSftp.isConnected()) System.out.println("ChannelSftp not connected");
			else channelSftp.disconnect();
		}
		
		if(channel != null){
			if(!channel.isConnected()) System.out.println("Channel not connected");
			else channel.disconnect();
		}
		
		if(session != null){
			if(!session.isConnected()) System.out.println("Session not connected");
			else session.disconnect();
		}
	}
	
	/** Method: general **/
	public void get(String srcFile, String descPath) throws Exception{
		System.out.println("-------------------");
		System.out.println("SFTPUtilities.get()");
		System.out.println("-------------------");
		
		/** $scp srcFile to descPath **/
	    Vector vSap = channelSftp.ls(srcFile);
		if(vSap.isEmpty()){
			System.out.println(srcFile.concat(" not found."));
			throw new Exception(srcFile.concat(" not found."));
		}else{
			String hostFile = session.getHost().concat("@").concat(srcFile);
			SftpATTRS fSapAttrs = ((LsEntry)vSap.firstElement()).getAttrs();
			
			System.out.println("SFTP geting...");
	    	System.out.println("  from: "+session.getHost().concat("@").concat(srcFile));
	    	System.out.println("  to: "+descPath);
	    	
	    	//Owner can't read
			if('r'!=fSapAttrs.getPermissionsString().charAt(1)){ 
				System.out.println("  msg: Can't read "+hostFile+" [Permissions is "+fSapAttrs.getPermissionsString()+"]");
				throw new Exception("Can't read "+hostFile+" [Permissions is "+fSapAttrs.getPermissionsString()+"]");
		    }else{			    	
		    	channelSftp.get(srcFile, descPath);
			    System.out.println("  msg: Success!");
		    }
		}			
	}	
	public void put(String srcFile, String descPath)throws  Exception{
		System.out.println("-------------------");
		System.out.println("SFTPUtilities.put()");
		System.out.println("-------------------");
		
		/** $scp srcFile to descPath **/
		File fSem = new File(srcFile);
		if(!fSem.exists()){
			System.out.println(srcFile.concat(" not found."));
			throw new Exception(srcFile.concat(" not found."));
		}else{
			
			System.out.println("SFTP puting...");
	    	System.out.println("  from: "+srcFile);
	    	System.out.println("  to: "+session.getHost().concat("@").concat(descPath));
			if(!fSem.canRead()){
				System.out.println("  msg: ".concat(srcFile).concat(" can't Read."));
				throw new Exception(srcFile.concat(" can't Read."));
			}else{					
		    	channelSftp.put(srcFile, descPath);
			    System.out.println("  msg: Success!");
		    }
		}		
	}
	public void ls(String path) throws  Exception{
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
	}
	public List<String> listLsEntryFilename(String path) throws  Exception{
		List<String> list = new ArrayList<String>();
		System.out.println("-------------------------");
		System.out.println("SFTPUtilities.listLsEntryFilename()");
		System.out.println("-------------------------");
		
		/** $ls -l **/
	    System.out.println("ls -l "+path);
	    Vector v = channelSftp.ls(path);
	    if(v!=null){
	    	System.out.println("Keep in List<SelectItem>");
	    	for(int i=0; i<v.size(); i++){		    	
	    		Object obj=v.elementAt(i);
	    		if(obj instanceof LsEntry){
	    			LsEntry lsEntry = (LsEntry)obj;
	    			System.out.println(lsEntry.getLongname());
	    			if(!lsEntry.getAttrs().isDir()){
	    				list.add(lsEntry.getFilename());
	    			}		    			
	    		}
	    	}
	    }
		return list;
	}
	public List<String> listLsEntryLongname(String path) throws  Exception{
		List<String> list = new ArrayList<String>();
		System.out.println("-------------------------");
		System.out.println("SFTPUtilities.listLsEntryLongname()");
		System.out.println("-------------------------");
		
		/** $ls -l **/
	    System.out.println("ls -l "+path);
	    Vector v = channelSftp.ls(path);
	    if(v!=null){
	    	System.out.println("Keep in List<SelectItem>");
	    	for(int i=0; i<v.size(); i++){		    	
	    		Object obj=v.elementAt(i);
	    		if(obj instanceof LsEntry){
	    			LsEntry lsEntry = (LsEntry)obj;
	    			System.out.println(lsEntry.getLongname());
	    			if(!lsEntry.getAttrs().isDir()){
		    			list.add(lsEntry.getLongname());
	    			}		    			
	    		}
	    	}
	    }
		return list;
	}	
	public List<LsEntry> listEntry(String path) throws  Exception{
		List<LsEntry> list = new ArrayList<LsEntry>();
		System.out.println("-------------------------");
		System.out.println("SFTPUtilities.listEntry()");
		System.out.println("-------------------------");
		
		/** $ls -l **/
	    System.out.println("ls -l "+path);
	    Vector v = channelSftp.ls(path);
	    if(v!=null){
	    	System.out.println("Keep in List<SelectItem>");
	    	for(int i=0; i<v.size(); i++){		    	
	    		Object obj=v.elementAt(i);
	    		if(obj instanceof LsEntry){
	    			LsEntry lsEntry = (LsEntry)obj;
	    			System.out.println(""+lsEntry.getLongname());
	    			if(!lsEntry.getAttrs().isDir()){
		    			list.add(lsEntry);
	    			}		    			
	    		}
	    	}
	    }
		return list;
	}
	
	/**
	 * @param path : /SEM/Interface_SAP/Outbound/SEMPA_*_20101117_*.dat
	 * @return
	 * @throws Exception
	 */
	public int getNextRunning(String path) throws Exception{
		System.out.println("-------------------------");
		System.out.println("SFTPUtilities.getNextRunning(".concat(path).concat(")"));
		System.out.println("-------------------------");
		
		/** $ls -l **/
		int maxRunning = 0;	//Default
		List<Integer> runningList = new ArrayList<Integer>();
	    System.out.println("ls -l "+path);
	    Vector v = channelSftp.ls(path);
	    if(v!=null){
	    	System.out.println("Keep in List<SelectItem>");
	    	for(int i=0; i<v.size(); i++){		    	
	    		Object obj=v.elementAt(i);
	    		if(obj instanceof LsEntry){
	    			LsEntry lsEntry = (LsEntry)obj;
	    			System.out.println(""+lsEntry.getLongname());
	    			if(!lsEntry.getAttrs().isDir()){
	    				String[] fNames0 = lsEntry.getFilename().split("\\.");
	    				if(fNames0!=null && fNames0.length==2){
	    					String[] fNames1 = fNames0[0].split("\\_");
	    					try {
	    						Integer running = Integer.valueOf(fNames1[fNames1.length-1]);
	    						runningList.add(running);
							} catch (Exception e) {
								e.printStackTrace();
							}
	    				}	    				
	    			}		    			
	    		}
	    	}
	    	
	    	//кр Max Running
	    	if(runningList.size()>0){
	    		Integer[] runnings = runningList.toArray(new Integer[0]);
	    		System.out.println("Sorting running numbers(asc)...");
	    		Arrays.sort(runnings); //asc
	    		maxRunning = runnings[runnings.length-1];
	    		System.out.println("first runnings: "+runnings[0]);
	    		System.out.println("last runnings: "+maxRunning);	    		
	    	}
	    }		
		return (maxRunning+1);
	}
	public Vector readLines(String path, String file) throws  Exception {
		System.out.println("-------------------------");
		System.out.println("SFTPUtilities.readLines()");
		System.out.println("-------------------------");
		Vector resultV = new Vector();
		if(path!=null && file!=null){
			if(path.length()!=0 && file.length()!=0){
				System.out.println("Read "+session.getHost().concat("@").concat(path+file));
				Vector lsFiles = channelSftp.ls(path.concat(file));			
				if(lsFiles.size()>0)	{				
					InputStream inputS = channelSftp.get(path.concat(file));			
					LineNumberReader lineR= new LineNumberReader(new InputStreamReader( inputS ));								
					String c;        		
	        		while ((c=lineR.readLine())!=null) {
	        			resultV.addElement(c);
	          			System.out.println(c);
	          		}
	          		inputS.close();          		
				}					
			}
		}
		return resultV;
	}
	
}
