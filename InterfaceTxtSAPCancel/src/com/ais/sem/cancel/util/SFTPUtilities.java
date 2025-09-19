package com.ais.sem.cancel.util;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.SftpException;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Vector;
import org.apache.commons.vfs.FileSystemException;
import org.apache.commons.vfs.FileSystemOptions;
import org.apache.commons.vfs.provider.sftp.SftpClientFactory;

public class SFTPUtilities {
  private static String host = Utilities.getResources("sftp_hostname");
  
  private static String username = Utilities.getResources("sftp_username");
  
  private static String password = Utilities.getResources("sftp_password");
  
  private static int port = Integer.parseInt(Utilities.getResources("sftp_port"));
  
  private static int timeout = Integer.parseInt(Utilities.getResources("sftp_timeout"));
  
  public static String sapPath = Utilities.getResources("sap_path");
  
  private ChannelSftp channelSftp;
  
  private FileSystemOptions opts;
  
  private Session session;
  
  private Channel channel;
  
  public ChannelSftp getChannelSftp() {
    return this.channelSftp;
  }
  
  public SFTPUtilities() {}
  
  public SFTPUtilities(boolean isConnect) {
    if (isConnect)
      connect(); 
  }
  
  public ChannelSftp connect() {
    try {
      createSession();
      this.channel = this.session.openChannel("sftp");
      this.channel.connect();
      System.out.println("SFTP channel is connecting...");
      this.channelSftp = (ChannelSftp)this.channel;
    } catch (Exception e) {
      e.printStackTrace();
    } 
    return this.channelSftp;
  }
  
  private void createSession() {
    try {
      System.out.println("\ncreateConnection...");
      this.session = SftpClientFactory.createConnection(
          host, 
          port, 
          username.toCharArray(), 
          !"".equals(password) ? password.toCharArray() : null, 
          this.opts);
      this.session.setTimeout(timeout);
      System.out.println("Sftp connect: " + username + "@" + this.session.getHost() + ":" + port);
      System.out.println("Server version: " + this.session.getServerVersion());
      System.out.println("ClientVersion: " + this.session.getClientVersion());
      System.out.println("Timeout: " + this.session.getTimeout());
    } catch (FileSystemException fex) {
      fex.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  public void disconnect() {
    try {
      if (this.channelSftp != null) {
        this.channelSftp.disconnect();
        System.out.println("ChannelSftp disconnected");
      } 
      if (this.channel != null) {
        this.channel.disconnect();
        System.out.println("Channel disconnected");
      } 
      if (this.session != null) {
        this.session.disconnect();
        System.out.println("Session disconnected");
      } 
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  public void get(String srcFile, String descPath) {
    try {
      System.out.println("-------------------");
      System.out.println("SFTPUtilities.get()");
      System.out.println("-------------------");
      Vector<ChannelSftp.LsEntry> vSap = this.channelSftp.ls(srcFile);
      if (vSap.isEmpty()) {
        System.out.println(srcFile.concat(" not found."));
      } else {
        String hostFile = this.session.getHost().concat("@").concat(srcFile);
        SftpATTRS fSapAttrs = ((ChannelSftp.LsEntry)vSap.firstElement()).getAttrs();
        System.out.println("SFTP geting...");
        System.out.println("  from: " + this.session.getHost().concat("@").concat(srcFile));
        System.out.println("  to: " + descPath);
        if ('r' != fSapAttrs.getPermissionsString().charAt(1)) {
          System.out.println("  msg: Can't read " + hostFile + " [Permissions is " + fSapAttrs.getPermissionsString() + "]");
        } else {
          this.channelSftp.get(srcFile, descPath);
          System.out.println("  msg: Success!");
        } 
      } 
    } catch (SftpException se) {
      se.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  public void put(String srcFile, String descPath) {
    try {
      System.out.println("-------------------");
      System.out.println("SFTPUtilities.put()");
      System.out.println("-------------------");
      File fSem = new File(srcFile);
      if (!fSem.exists()) {
        System.out.println(srcFile.concat(" not found."));
      } else {
        System.out.println("SFTP puting...");
        System.out.println("  from: " + srcFile);
        System.out.println("  to: " + this.session.getHost().concat("@").concat(descPath));
        if (!fSem.canRead()) {
          System.out.println("  msg: ".concat(srcFile).concat(" can't Read."));
        } else {
          this.channelSftp.put(srcFile, descPath);
          System.out.println("  msg: Success!");
        } 
      } 
    } catch (SftpException se) {
      se.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  public void ls(String path) {
    try {
      System.out.println("-------------------------");
      System.out.println("SFTPUtilities.ls()");
      System.out.println("-------------------------");
      System.out.println("ls -l " + path);
      Vector v = this.channelSftp.ls(path);
      if (v != null)
        for (int i = 0; i < v.size(); i++) {
          Object obj = v.elementAt(i);
          if (obj instanceof ChannelSftp.LsEntry) {
            ChannelSftp.LsEntry lsEntry = (ChannelSftp.LsEntry)obj;
            System.out.println(lsEntry.getLongname());
          } 
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  public Vector readLines(String path, String file) throws Exception {
    System.out.println("-------------------------");
    System.out.println("SFTPUtilities.readLines()");
    System.out.println("-------------------------");
    Vector<String> resultV = new Vector();
    try {
      if (path != null && file != null && 
        path.length() != 0 && file.length() != 0) {
        System.out.println("Read " + this.session.getHost().concat("@").concat(String.valueOf(path) + file));
        Vector lsFiles = this.channelSftp.ls(path.concat(file));
        if (lsFiles.size() > 0) {
          InputStream inputS = this.channelSftp.get(path.concat(file));
          LineNumberReader lineR = new LineNumberReader(new InputStreamReader(inputS, "UTF-8"));
          String c;
          while ((c = lineR.readLine()) != null && !c.equals("E")) {
            resultV.addElement(c.trim());
            System.out.println(c);
          } 
          System.out.println("resultV size = " + resultV.size());
          inputS.close();
        } 
      } 
      return resultV;
    } catch (Exception e) {
      System.out.println("==== Error readLines ==== ");
      e.printStackTrace();
      throw e;
    } 
  }
  
  public Vector getFileNameAll(String path, String formatFileName) throws Exception {
    System.out.println("-------------------------");
    System.out.println("SFTPUtilities.readAllFiles()");
    System.out.println("-------------------------");
    Vector<String> resultV = new Vector();
    Vector<String> vNameAll = new Vector();
    int orgmax = 0;
    try {
      System.out.println("ls -l " + path);
      Vector v = this.channelSftp.ls(path);
      if (v != null) {
        int i;
        for (i = 0; i < v.size(); i++) {
          Object obj = v.elementAt(i);
          if (obj instanceof ChannelSftp.LsEntry) {
            ChannelSftp.LsEntry lsEntry = (ChannelSftp.LsEntry)obj;
            if (!lsEntry.getFilename().equals(".") && !lsEntry.getFilename().equals("..") && 
              lsEntry.getFilename().indexOf("ZFAP109") != -1 && lsEntry.getFilename().indexOf(formatFileName) != -1)
              vNameAll.addElement(lsEntry.getFilename().trim()); 
          } 
        } 
        for (i = 0; vNameAll != null && i < vNameAll.size(); i++) {
          String filename = Utilities.cutExtension(vNameAll.get(i).toString().trim());
          String filedat = filename.concat(".dat");
          String filesyn = filename.concat(".syn");
          int numdat = 0;
          for (int j = 0; j < vNameAll.size(); j++) {
            if (vNameAll.get(j).toString().equals(filedat) || vNameAll.get(j).toString().equals(filesyn))
              numdat++; 
          } 
          if (numdat == 2) {
            resultV.addElement(filedat);
            vNameAll.remove(filedat);
            vNameAll.remove(filesyn);
            i = 0;
          } 
        } 
      } 
      System.out.println("-------------------------");
    } catch (Exception e) {
      e.printStackTrace();
    } 
    return resultV;
  }
}
