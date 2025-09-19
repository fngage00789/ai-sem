package th.co.ais.util;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LazyInitializationException;


public class AISDataValidateUtil {
	
	
	private static final Log LOG = LogFactory.getLog(AISDataValidateUtil.class);
	
	public static final String OCS_COUNTRY_CODE_PREFIX="66";
	public static final String MOBILE_NO_PREFIX ="08";
	public static int MOBILE_NO_LENGTH = 10;
	public static String mobileRegex = AISDataValidateUtil.MOBILE_NO_PREFIX+"[0-9]{"+(AISDataValidateUtil.MOBILE_NO_LENGTH-AISDataValidateUtil.MOBILE_NO_PREFIX.length())+"}";
	
	public static final String MOBILE_NO_PREFIX_TOT ="0";
	public static String mobileRegexTOT = AISDataValidateUtil.MOBILE_NO_PREFIX_TOT+"[0-9]{"+(AISDataValidateUtil.MOBILE_NO_LENGTH-AISDataValidateUtil.MOBILE_NO_PREFIX_TOT.length())+"}";
	
	public static final String HOME_NO_PREFIX ="0";
	public static int HOME_NO_LENGTH = 9;
	public static String homeRegex = AISDataValidateUtil.HOME_NO_PREFIX+"[0-9]{"+(AISDataValidateUtil.HOME_NO_LENGTH-AISDataValidateUtil.HOME_NO_PREFIX.length())+"}";
	
	public static String numberRegexNoDigit = "[0-9]{0,}";
	public static String numberRegexOneDigit = "[0-9]{0,}[.]{1}[0-9]{1}"; 
	public static String numberRegexTwoDigit = "[0-9]{0,}[.]{1}[0-9]{2}";

	public static boolean validateNumberDigit(String number, int precision, int scale){
		String format = "[0-9]{0," + String.valueOf(precision-scale) + "}[.]{1}[0-9]{0," + String.valueOf(scale) +"}"; 
		if (!number.trim().matches(format)){
			return false;	
		}	
		return true;
	}
	
	public static boolean validateNumberNoDigit(String number, int precision){
		String format = "[0-9]{0," + String.valueOf(precision) + "}";
		if (!number.trim().matches(format)){
			return false;	
		}	
		return true;
	}
	
	public static boolean validateNumberNoDigit(String number){
		if (!number.trim().matches(numberRegexNoDigit)){
			return false;	
		}	
		return true;
	}

	public static boolean validateMobileNo(String mobileNo) throws Exception{
		//String regex = "08"+"[0-9]{"+(8)+"}"; 
		//���¤������ ������鹴��� 08 ��е�����µ���ѡ�� 0-9 � 8 ���
		if (mobileNo.trim().length()>0){
			if (!mobileNo.trim().matches(mobileRegex)){
				return false;	
			}
		}	
		return true;
	}
	
	public static boolean validateMobileNoTOT(String mobileNo) throws Exception{
		//String regex = "0"+"[0-9]{"+(9)+"}"; 
		//���¤������ ������鹴��� 0 ��е�����µ���ѡ�� 0-9 � 9 ���
		if (mobileNo.trim().length()>0){
			if (!mobileNo.trim().matches(mobileRegexTOT)){
				return false;	
			}
		}	
		return true;
	}
	
	public static boolean validateHomeNo(String homeNo) throws Exception{
		//String regex = "0"+"[0-9]{"+(8)+"}"; 
		//���¤������ ������鹴��� 0 ��е�����µ���ѡ�� 0-9 � 8 ���
		if (homeNo.trim().length()>0){
			if (!homeNo.trim().matches(homeRegex)){
				return false;	
			}
		}	
		return true;
	}
	
	/**
	 * return false if collection has no data (size 0) or instance is null
	 * @param collection
	 * @return boolean
	 * @throws Exception
	 */
	public static boolean isCollectionEmpty(Collection collection) throws Exception {
		org.hibernate.collection.PersistentSet s = new org.hibernate.collection.PersistentSet();
	  try{
		if(collection == null || collection.isEmpty()) {
			return true;
		}
		} catch(LazyInitializationException lazyEx) {
			return true;
		}
		return false;
	}
	
	/**
	 * @param sEmail
	 * @return boolean
	 */
	public static boolean validateEmailFormat(String sEmail){
		if(sEmail == null || sEmail.length() < 1){
			return false;
		}
		String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
		CharSequence inputStr = sEmail;
		Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(inputStr);
		if(matcher.matches()){
			return true;
		}
		return false;
	}
	

	static String dtCh= "/";
	static int minYear = 1900;
	static int maxYear = 2100;

	public static boolean isInteger(String s){
	    for (int i = 0; i < s.length(); i++){   
	        // Check that current character is number.
	        char c = s.charAt(i);
	        if (((c < '0') || (c > '9'))) return false;
	    }
	    // All characters are numbers.
	    return true;
	}

	public static String stripCharsInBag(String s, String bag){
		int i;
	    String returnString = "";
	    // Search through string's characters one by one.
	    // If character is not in bag, append to returnString.
	    for (i = 0; i < s.length(); i++){   
	        char c = s.charAt(i);
	        if (bag.indexOf(c) == -1) returnString += c;
	    }
	    return returnString;
	}

	public static int daysInFebruary(int year){
		// February has 29 days in any year evenly divisible by four,
	    // EXCEPT for centurial years which are not also divisible by 400.
	    return (((year % 4 == 0) && ( (!(year % 100 == 0)) || (year % 400 == 0))) ? 29 : 28 );
	}
	
	public static int[] DaysArray(int n) {
		int[] day = new int[30];
		for (int i = 1; i <= n; i++) {
			day[i] = 31;
			if (i==4 || i==6 || i==9 || i==11) day[i] = 30;
			
			if (i==2) day[i] = 29;
	   } 
		return day;
	}

	public static boolean isDate(String dtStr){
		
		int[] daysInMonth = DaysArray(12);
		int pos1 = dtStr.indexOf(dtCh);
		int pos2 = dtStr.indexOf(dtCh, pos1+1);
		
		String strDay = dtStr.substring(0,pos1);
		String strMonth = dtStr.substring(pos1+1,pos2);
		String strYear = dtStr.substring(pos2+1);
		String strYr = strYear;
		
		if (strDay.charAt(0)=='0' && strDay.length()>1) strDay=strDay.substring(1);
		if (strMonth.charAt(0)=='0' && strMonth.length()>1) strMonth=strMonth.substring(1);
		for (int i = 1; i <= 3; i++) {
			if (strYr.charAt(0)== '0' && strYr.length()>1) 
				strYr=strYr.substring(1);
		}
		int month = Integer.parseInt(strMonth);
		int day = Integer.parseInt(strDay);
		int year = Integer.parseInt(strYr);
		if (pos1==-1 || pos2==-1){
			LOG.info("The date format should be : dd/MM/yyyy");
			//FrontMessageUtils.addMessageError("The date format should be : dd/MM/yyyy");
			return false;
		}
		if (strMonth.length() < 1 || month < 1 || month > 12){
			LOG.info("Please enter a valid month");
			//FrontMessageUtils.addMessageError("Please enter a valid month");
			return false;
		}
		if (strDay.length() < 1 || day < 1 || day > 31 || (month==2 && day > daysInFebruary(year)) || day > daysInMonth[month]){
			LOG.info("Please enter a valid day");
			//FrontMessageUtils.addMessageError("Please enter a valid day");
			return false;
		}
		if (strYear.length() != 4 || year == 0 || year < minYear || year > maxYear){
			LOG.info("Please enter a valid 4 digit year between " + minYear + " and " + maxYear);
			//FrontMessageUtils.addMessageError("Please enter a valid 4 digit year between " + minYear + " and " + maxYear);
			return false;
		}
		if (dtStr.indexOf(dtCh , pos2+1) !=-1 || isInteger(stripCharsInBag(dtStr, dtCh)) == false){
			LOG.info("Please enter a valid date");
			//FrontMessageUtils.addMessageError("Please enter a valid date");
			return false;
		}
		return true;
	}
}
