package com.ais.sem.cancel.util;

import java.io.UnsupportedEncodingException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;

public class Utilities {
  public static String getResources(String key) {
    String value = "";
    try {
      ResourceBundle rb = ResourceBundle.getBundle("config-cancel");
      value = rb.getString(key);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } 
    return value;
  }
  
  public static Vector StringSpiltDelim(String str, String delim) {
    Vector<String> v = new Vector();
    String[] arrStr = str.split(delim, str.length());
    for (int i = 0; arrStr != null && i < arrStr.length; i++)
      v.add(arrStr[i]); 
    return v;
  }
  
  public static Date ConvertStringToDate(String dateStr) throws Exception {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.US);
    Date myDate = sdf.parse(dateStr);
    return new Date(myDate.getTime());
  }
  
  public static Date getCurrentDate() {
    return getCalendar().getTime();
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
    Calendar cal = getCalendar();
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
  
  public static String addDate(Date maxDate, int num) {
    String DATE_FORMAT = "yyyyMMdd";
    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT, Locale.US);
    Calendar c1 = getCalendar();
    c1.setTime(maxDate);
    c1.add(5, num);
    return sdf.format(c1.getTime());
  }
  
  public static Calendar getCalendar() {
    return Calendar.getInstance(Locale.US);
  }
  
  public static String cutExtension(String filename) {
    int last = filename.indexOf(".");
    return filename.substring(0, last);
  }
  
  public static String convertMS874ToTIS620(String str) throws UnsupportedEncodingException {
    return new String(str.getBytes("MS874"), "TIS620");
  }
  
  public static Date parseDate(String date_str, String format) {
    try {
      String yy = date_str.substring(0, 4);
      String mm = date_str.substring(4, 6);
      String dd = date_str.substring(6, 8);
      String strDate = String.valueOf(dd) + "/" + mm + "/" + yy;
      SimpleDateFormat sf = new SimpleDateFormat(format, Locale.US);
      Date date = sf.parse(strDate);
      Calendar cal = getCalendar();
      cal.setTime(date);
      return date;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    } 
  }
}
