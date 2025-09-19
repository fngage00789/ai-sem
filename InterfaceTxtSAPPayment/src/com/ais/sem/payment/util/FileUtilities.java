package com.ais.sem.payment.util;

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
          if (filename.indexOf("ZFAP108") != -1 && filename.indexOf(formatFileName) != -1)
            vNameAll.addElement(filename.trim()); 
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
