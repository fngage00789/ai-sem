package com.ais.sem.response.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Vector;

public class FileUtilities {
  public static String sapPath = Utilities.getResources("sap_path");
  
  public Vector getFileNameAll(String path, String formatFileName) {
    System.out.println("-------------------------");
    System.out.println("FileUtilities.readAllFiles()");
    System.out.println("-------------------------");
    Vector<String> resultV = new Vector();
    Vector<String> vNameAll = new Vector();
    Vector vAck = new Vector();
    try {
      File dir = new File(path);
      String[] children = dir.list();
      if (children == null) {
        System.out.println("Either dir does not exist or is not a directory ");
      } else {
        int i;
        for (i = 0; i < children.length; i++) {
          String filename = children[i];
          if (filename.indexOf("ZFAP107_") != -1 && filename.indexOf(formatFileName) != -1)
            vNameAll.addElement(filename.trim()); 
        } 
        for (i = 0; vNameAll != null && i < vNameAll.size(); i++) {
          String filename = Utilities.cutExtension(vNameAll.get(i).toString().trim());
          String fileack = filename.concat(".ack");
          String filelog = filename.concat(".log");
          String filecan = filename.concat(".can");
          String filedes = filename.concat(".des");
          int numack = 0;
          int numcan = 0;
          for (int j = 0; j < vNameAll.size(); j++) {
            if (vNameAll.get(j).toString().equals(fileack) || vNameAll.get(j).toString().equals(filelog))
              numack++; 
            if (vNameAll.get(j).toString().equals(filecan) || vNameAll.get(j).toString().equals(filedes))
              numcan++; 
          } 
          if (numack == 2) {
            resultV.addElement(fileack);
            vNameAll.remove(fileack);
            vNameAll.remove(filelog);
            i = 0;
          } 
          if (numcan == 2) {
            resultV.addElement(filecan);
            vNameAll.remove(filecan);
            vNameAll.remove(filedes);
            i = 0;
          } 
        } 
      } 
    } catch (Exception e) {
      e.printStackTrace();
    } 
    return resultV;
  }
  
  public Vector readLines(String path, String filename) throws Exception {
    System.out.println("-------------------------");
    System.out.println("FileUtilities.readLines()");
    System.out.println("-------------------------");
    Vector<String> vector = new Vector();
    Vector vChild = new Vector();
    File file = null;
    LineNumberReader lnreader = null;
    try {
      file = new File(sapPath.concat(filename));
      FileInputStream fos = new FileInputStream(file);
      lnreader = new LineNumberReader(new InputStreamReader(fos, "UTF-8"));
      String line;
      while ((line = lnreader.readLine()) != null && !line.equals("E")) {
        System.out.println("Line:  " + lnreader.getLineNumber() + ": " + line);
        vector.addElement(line.trim());
      } 
      lnreader.close();
      fos.close();
    } catch (Exception e) {
      throw e;
    } 
    return vector;
  }
}
