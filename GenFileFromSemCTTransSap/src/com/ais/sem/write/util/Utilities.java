package com.ais.sem.write.util;


import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;

public class Utilities {
	public static String getResources(String key){
		String value = "";
		try {
			ResourceBundle rb = ResourceBundle.getBundle("config-genfile");			
			value = rb.getString(key);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
		return value;  
	}
	
	public static Vector StringSpiltDelim(String str,String delim){	
		Vector v = new Vector();
		String[] arrStr = str.split(delim,str.length());
		
		for(int i=0;arrStr!=null&&i<arrStr.length;i++){
  	    	v.add(arrStr[i]);
  	    }
		return v;  		
	}	
	
	public static Date ConvertStringToDate(String dateStr) throws  Exception{
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.US); 
		 java.util.Date myDate = sdf.parse(dateStr);
		 return new java.sql.Date(myDate.getTime());
	}
	
	public static Date getCurrentDate(){
		return getCalendar().getTime();
	}
	
	public static String addZeroAfter(String str,int length){
		String result = "";

		int strSize = 0;
		if(str != null)
		{
			strSize = str.length();
			result = str;
			for(int i = 0;i < (length - strSize);i++)
			{
				result = "0" + result;
			}
		}
		return result;
	}
	
	public static String addZeroBefore(String str,int length){
		String result = "";
		
		int strSize = 0;
		if(str != null)
		{
			strSize = str.length();
			result = str;
			for(int i = 0;i < (length - strSize);i++)
			{
				result = result + "0";
			}
		}
		return result;
	}
	
	
	
	public static String formatDateYYYYMMDD(){ 
		Calendar cal = getCalendar();
        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR); 
       
        String strDay = addZeroAfter(String.valueOf(day),2);
        String strMonth = addZeroAfter(String.valueOf(month),2);
        String strYear = addZeroAfter(String.valueOf(year),4);
        
        /*System.out.println("Current Date: " + cal.getTime());
        System.out.println("formatDateYYYYMMDD: " + strYear+strMonth+strDay);*/
        return strYear+strMonth+strDay;
	}
	
	public static String formatTimeHHMMSS(){ 
		Calendar cal = getCalendar();
        int hh = cal.get(Calendar.HOUR);
        int mm = cal.get(Calendar.MINUTE);
        int ss = cal.get(Calendar.SECOND); 
       
        String strHH = addZeroAfter(String.valueOf(hh),2);
        String strMM = addZeroAfter(String.valueOf(mm),2);
        String strSS = addZeroAfter(String.valueOf(ss),2);
        
        /*System.out.println("Current Date: " + cal.getTime());
        System.out.println("formatTimeHHMMSS: " + strHH+strMM+strSS);*/
        return strHH+strMM+strSS;
	}
	
	public static String addDate(Date maxDate,int num){
		String DATE_FORMAT = "yyyyMMdd";
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT,Locale.US);	
		Calendar c1 = Utilities.getCalendar();
		c1.setTime(maxDate);
		c1.add(Calendar.DATE,num);
		//System.out.println("add Date : " + sdf.format(c1.getTime()));
		return sdf.format(c1.getTime());
	}
	
	public static Calendar getCalendar()
	{
		return Calendar.getInstance(Locale.US);
	}
	
	public static String cutExtension(String filename){
		 int last = filename.indexOf(".");
		return filename.substring(0,last);
	}
	
	public static String convertMS874ToTIS620(String str) throws UnsupportedEncodingException{
		return new String(str.getBytes("MS874"),"TIS620");
	}
	
	public static Date parseDate(String date_str,String format)
	{
		try
		{   
			String yy = date_str.substring(0,4);
			String mm = date_str.substring(4,6);
			String dd = date_str.substring(6,8);
			
			String strDate = dd +"/"+ mm +"/"+ yy;
			
			SimpleDateFormat sf = new SimpleDateFormat(format,Locale.US);
			Date date = sf.parse(strDate);
			Calendar cal = getCalendar();
			cal.setTime(date);
			return date;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public static String toDecimal(String num,int decimal) throws Exception{		
		 NumberFormat format = new DecimalFormat("#0.00");	
		 return format.format(new Double(num).doubleValue());
	}
	
/*	public static void main(String[] arg) throws Exception{		 
		 Utilities utilities = new Utilities();		 
		 System.out.println(utilities.toDecimal("20000.5",2));
		 System.out.println(addZeroBefore("1", 9));
	 }*/	 
	
  }
