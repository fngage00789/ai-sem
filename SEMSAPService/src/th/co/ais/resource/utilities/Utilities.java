package th.co.ais.resource.utilities;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;

import org.apache.commons.lang.ObjectUtils;


public class Utilities {
	public static String nvl(String s)
	{
		return s == null? "":s.trim();
	}
	
	public static String getResources(String key){
		String value = "";
		try {
//			ResourceBundle rb = ResourceBundle.getBundle("th.co.ais.resource.utilities-config");
			ResourceBundle rb = ResourceBundle.getBundle("th.co.ais.resource.SEMConfig");
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
  	    	System.out.println("v["+i+"] = "+v.get(i));
  	    }
		System.out.println("arrStr.length = "+arrStr.length);
		return v;  		
	}	
	
	public static Date ConvertStringToDate(String dateStr) throws  Exception{
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.US); 
		 java.util.Date myDate = sdf.parse(dateStr);
		 return new java.sql.Date(myDate.getTime());
	}
	
	public static java.sql.Date getCurrentJavaSqlDate() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
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
		Calendar cal = Calendar.getInstance(Locale.US);
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
	
	public static String cutExtension(String filename){
		 int indexNum = filename.length();
		 int last = filename.indexOf(".");
		return filename.substring(0,last);
	}
	
	public static String convertMS874ToTIS620(String str) throws UnsupportedEncodingException{
		return new String(str.getBytes("MS874"),"TIS620");
	}
	
	public static String formatddmmyyy(String date_str)
	{
		try
		{   
			Locale locale = Locale.US;
			String yy = addZeroAfter(date_str.substring(0,4),4);
			String mm = addZeroAfter(date_str.substring(4,6),2);
			String dd = addZeroAfter(date_str.substring(6,8),2);
			
			String strDate = dd +"/"+ mm +"/"+ yy;
			return strDate;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList sortArrayListByColumn(ArrayList arResult, String sortColName, String sortFlag) {
        final String sortCol = sortColName;

        Collections.sort(arResult,
            new Comparator() {
                public int compare(Object o1, Object o2) {
                    HashMap hs1 = (HashMap) o1;
                    HashMap hs2 = (HashMap) o2;
                    String s1 = (String) ObjectUtils.defaultIfNull(hs1.get(
                                sortCol), "");
                    String s2 = (String) ObjectUtils.defaultIfNull(hs2.get(
                                sortCol), "");

                   try {
                        return new SimpleDateFormat("dd/MM/yyyy").parse(s1.trim())
                            .compareTo(
                                new SimpleDateFormat("dd/MM/yyyy")
                                    .parse(s2.trim()));
                      } catch (ParseException pE) {
                        return s1.trim().compareTo(s2.trim());
                      }
                }
            });

        if (sortFlag.equals(SEMSAPConstant.DECENDING)) {
            arResult = getDecendingSort(arResult);
        }
        return arResult;
    }
    
    private static ArrayList getDecendingSort(ArrayList arSource) {
        ArrayList arDesc = new ArrayList();
        
        for (int i = arSource.size() - 1; i >= 0; i--) {
            arDesc.add(arSource.get(i));
        }

        return arDesc;
    }
    
}
