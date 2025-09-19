package com.ais.batch.util;


import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.swing.filechooser.FileSystemView;

public class Utilities {
	public static String getResources(String key){
		String value = "";
		try {
			File dir1 = new File (".");
		    File dir2 = new File ("..");
	        
//			String path = "D:\\Batch";
//			String path = "\\home\\tirayr45\\deploy\\batch";
	        String path = dir1.getCanonicalPath();
	        
			java.io.File fl = new java.io.File(path);

			URL[] resourceURL = {fl.toURI().toURL()};
//			URLClassLoader urlLoader = new URLClassLoader(new java.net.URL[]{resourceURL});
			ClassLoader loader = new URLClassLoader(resourceURL); 
			java.util.ResourceBundle rb = java.util.ResourceBundle.getBundle( "config-batch" , 
			                java.util.Locale.getDefault(), loader );
			
			
			
			
//			ResourceBundle rb = ResourceBundle.getBundle("D:\\Batch\\config-batch.properties");			
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
        
        System.out.println("Current Date: " + cal.getTime());
        System.out.println("formatDateYYYYMMDD: " + strYear+strMonth+strDay);
        return strYear+strMonth+strDay;
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
	
	// public static void main(String[] arga){
		 /*String str = "CHA|1111000017|20101012|IMTFI|AIS||DMTR|º¨¡.¨Ñ´ËÒ§Ò¹ àÍç¡à«ç¤¤ÔÇ·Õ¿ àÊÔÃìª|à«ÍÃìÇÔÊà«Ê|||DOMESTIC|191 ÍÒ¤ÒÃÊÕÅÁ¤ÍÁà¾Åç¡«ì ªÑé¹ 22|¶.ÊÕÅÁ á¢Ç§ÊÕÅÁ à¢µºÒ§ÃÑ¡|¡ÃØ§à·¾ÁËÒ¹¤Ã|10500|TH||0-2231-3940||022313662||||||||3011184202||||||||||||0001120001|||Z000|CDF|||J1|14|53||||||";
		 Utilities.StringSpiltDelim(str, "\\|");*/
		 //formatDateYYYYMMDD(); 
		  /* String str = "SEMAP_AIS_20101101_0001.dat,"; 
		   String index = formatDateYYYYMMDD()+"_";
		    
		  int indexNum = str.length();
		  int last = str.indexOf(".");
		 //  int num = Integer.valueOf(str.substring(indexNum,last)); 
		   System.out.println(str.substring(0,str.length()-1));
		   System.out.println(last);
		   System.out.println(Utilities.cutExtension(str));
		  System.out.println(str.substring(10,indexNum));*/
		 
		/* HashMap hashMap = new HashMap();
		 hashMap.put("aaa","value");
		 System.out.println(hashMap.get("aaa"));
		 if(hashMap.get("aaa") == null){
			 System.out.println("haha");
		 }*/
		/* String str1 = "SEMAP_AIS_20101101_0001.dat"; 
		 String str2 = "SEMAP_AIS_20101101_0001.syn"; 
		 System.out.println(str1.toLowerCase().endsWith("001"));*/
		   
		 /*String strDate = "20091110";
		 System.out.println(strDate.substring(0,4));
		 System.out.println(strDate.substring(4,6));
		 System.out.println(strDate.substring(6,8));
		 System.out.println(Utilities.parseDate(strDate, "dd/MM/yyyy",Locale.US));*/
		 
		/*    Vector vlog = new Vector();
			Vector vAck = new Vector();
		 
	    	vAck.add("SEMAP_COMP_20101118_ekarut_0001.ack"); 
		    vlog.add("SEMAP_COMP_20101118_ekarut_0001.log"); 
		    
		    String a = "SEMAP_COMP_20101118_ekarut_0001.LOG";
		    System.out.println(a.toUpperCase());*/

	    	/*for(int i=0;vAck!=null&& i<vAck.size(); i++){
	    		System.out.println("Filename = "+vAck.get(i).toString()+"|");
	    		System.out.println("Filename = "+vAck.get(i).toString()+"|");
	    		if(vlog.contains(Utilities.cutExtension(vAck.get(i).toString()).concat(".ack"))){ // check .log == .ack
					System.out.println("Filename = "+vAck.get(i).toString()+"|");	
					//resultV.addElement(vAck.get(i).toString().trim()); // value fileName
				}
	    	}*/
	// }
  }
