package com.ais.sem.trans.vendor.util;

import java.io.UnsupportedEncodingException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;

public class Utilities {
  public static String nvl(String s) {
    return (s == null) ? "" : s.trim();
  }
  
  public static String getResources(String key) {
    String value = "";
    try {
      ResourceBundle rb = ResourceBundle.getBundle("config-transfer-vendor");
      value = rb.getString(key);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } 
    return value;
  }
  
  public static Vector StringSpiltDelim(String str, String delim) {
    Vector<String> v = new Vector();
    String[] arrStr = str.split(delim, str.length());
    for (int i = 0; arrStr != null && i < arrStr.length; i++) {
      v.add(arrStr[i]);
      System.out.println("v[" + i + "] = " + v.get(i));
    } 
    System.out.println("arrStr.length = " + arrStr.length);
    return v;
  }
  
  public static Date ConvertStringToDate(String dateStr) throws Exception {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.US);
    Date myDate = sdf.parse(dateStr);
    return new Date(myDate.getTime());
  }
  
  public static Date getCurrentJavaSqlDate() {
    Date today = new Date();
    return new Date(today.getTime());
  }
  
  public static String addZeroAfter(String str, int length) {
    String result = "";
    int strSize = 0;
    if (str != null) {
      strSize = str.length();
      result = str;
      for (int i = 0; i < length - strSize; i++)
        result = "0" + result; 
    } 
    return result;
  }
  
  public static String addZeroBefore(String str, int length) {
    String result = "";
    int strSize = 0;
    if (str != null) {
      strSize = str.length();
      result = str;
      for (int i = 0; i < length - strSize; i++)
        result = String.valueOf(result) + "0"; 
    } 
    return result;
  }
  
  public static String formatDateYYYYMMDD() {
    Calendar cal = Calendar.getInstance(Locale.US);
    int day = cal.get(5);
    int month = cal.get(2) + 1;
    int year = cal.get(1);
    String strDay = addZeroAfter(String.valueOf(day), 2);
    String strMonth = addZeroAfter(String.valueOf(month), 2);
    String strYear = addZeroAfter(String.valueOf(year), 4);
    System.out.println("Current Date: " + cal.getTime());
    System.out.println("formatDateYYYYMMDD: " + strYear + strMonth + strDay);
    return String.valueOf(strYear) + strMonth + strDay;
  }
  
  public static String cutExtension(String filename) {
    int indexNum = filename.length();
    int last = filename.indexOf(".");
    return filename.substring(0, last);
  }
  
  public static String convertMS874ToTIS620(String str) throws UnsupportedEncodingException {
    return new String(str.getBytes("MS874"), "TIS620");
  }
  
  public static String formatddmmyyy(String date_str) {
    try {
      Locale locale = Locale.US;
      String yy = addZeroAfter(date_str.substring(0, 4), 4);
      String mm = addZeroAfter(date_str.substring(4, 6), 2);
      String dd = addZeroAfter(date_str.substring(6, 8), 2);
      String strDate = String.valueOf(dd) + "/" + mm + "/" + yy;
      return strDate;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    } 
  }
  
  public static void main(String[] arga) {
    String str = "SEMAP_AIS_20101101_0001.dat";
    String index = String.valueOf(formatDateYYYYMMDD()) + "_";
    int indexNum = str.length();
    int last = str.indexOf(".");
    System.out.println(indexNum);
    System.out.println(last);
    System.out.println(cutExtension(str));
    System.out.println(str.substring(10, indexNum));
    String refdoc = "PBKK 258  /09 ";
    System.out.println("refdoc = " + refdoc.indexOf("/"));
  }
}
