package th.co.ais.web.report.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import th.co.ais.rpt.util.DateUtil;
import th.co.ais.rpt.util.DebugHelper;
import th.co.ais.web.action.AbstractBaseAction;


@SuppressWarnings("unchecked")
public class ReportDateUtil extends AbstractBaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2330922426818932720L;
	protected static Logger slog = Logger.getLogger(ReportDateUtil.class);
	
	/**
	 * 
	 * @param date
	 * @param pattern
	 * @return 13/12/2553 10:12:359
	 */
	public static String convertDateToString(Date date, String pattern) {
		String data = null;
		
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern,new Locale("th","th"));
			data = sdf.format(date.getTime());
		}

		return data;
	}
	
	public static Date getDateFromJSF(Date dateJSFComponent){
		if(dateJSFComponent!=null){
			Calendar cal = Calendar.getInstance();
			cal.setTime(dateJSFComponent);
			cal.add(Calendar.YEAR, 543);
			return cal.getTime();	
		}else{
			return null;
		}		
	}
	
	public static String convertDateTime2String(Date date, String pattern) {
		String data = null;
		
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.ENGLISH);
			data = sdf.format(date.getTime());
		}

		return data;
	}
	
	public static String convertDateTime2StringNoLocale(Date date, String pattern) {
		String data = null;
		
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			data = sdf.format(date.getTime());
		}

		return data;
	}
	
	public static Calendar getCurrentDateTime() {
		Calendar cal = new GregorianCalendar(Locale.ENGLISH);
		return cal;
	}
	
	public static int getCurrentDay() {
		return getCurrentDateTime().get(Calendar.DAY_OF_MONTH);
	}
	
	public static int getCurrentDayOfWeek() {
		return getCurrentDateTime().get(Calendar.DAY_OF_WEEK);
	}
	
	public static int getCurrentMonth() {
		return getCurrentDateTime().get(Calendar.MONTH);
	}
	
	public static int getCurrentYear() {
		return getCurrentDateTime().get(Calendar.YEAR);
	}
	
	public static int getCurrentHour() {
		return getCurrentDateTime().get(Calendar.HOUR_OF_DAY);
	}
		
	public static int getCurrentMinute() {
		return getCurrentDateTime().get(Calendar.MINUTE);
	}	
	
	public static int getCurrentSecond() {
		return getCurrentDateTime().get(Calendar.SECOND);
	}

	public static int getDay(Calendar cal) {
		return cal.get(Calendar.DAY_OF_MONTH);
	}
	
	public static int getDayOfWeek(Calendar cal) {
		return cal.get(Calendar.DAY_OF_WEEK);
	}
	
	public static int getMonth(Calendar cal) {
		return cal.get(Calendar.MONTH);
	}
	
	public static int getYear(Calendar cal) {
		return cal.get(Calendar.YEAR);
	}
	
	public static int getHour(Calendar cal) {
		return cal.get(Calendar.HOUR_OF_DAY);
	}
		
	public static int getMinute(Calendar cal) {
		return cal.get(Calendar.MINUTE);
	}
		
	public static int getCurrentMinute(Calendar cal) {
		return cal.get(Calendar.MINUTE);
	}	

	public static Calendar getCalendar(long time) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(new Date(time));
		
		return cal;
	}

	public static Calendar getCalendar(int day, int month, int year) {
		return getCalendar(day, month, year, 0, 0, 0);
	}

	public static Calendar getCalendar(int day, int month, int year, int hour, int minute) {
		return getCalendar(day, month, year, hour, minute, 0);
	}

	public static Calendar getCalendar(int day, int month, int year, int hour, int minute, int second) {
		Calendar cal = null;

		if (day >= 0 && month >= 0 && year >= 0 && hour >= 0 && minute >= 0) {
			cal = new GregorianCalendar(Locale.US);
			cal.set(Calendar.DAY_OF_MONTH, day);
			cal.set(Calendar.MONTH, month);
			cal.set(Calendar.YEAR, year);
			cal.set(Calendar.HOUR_OF_DAY, hour);
			cal.set(Calendar.MINUTE, minute);
			cal.set(Calendar.SECOND, second);
			cal.set(Calendar.MILLISECOND, 0);
		}
		
//		cal.add(Calendar.HOUR_OF_DAY, plus);
		
		return cal;
	}
	
	public static void addDay(Calendar cal, int i) {
		cal.add(Calendar.DAY_OF_MONTH, i);
	}

	public static void addHour(Calendar cal, int i) {
		cal.add(Calendar.HOUR_OF_DAY, i);
	}

	public static void addMinute(Calendar cal, int i) {
		cal.add(Calendar.MINUTE, i);
	}

	public synchronized static long getCurrentDateTimeinLong() {
		Calendar cal = new GregorianCalendar();
//		cal.add(Calendar.HOUR_OF_DAY, plus);
		
		return cal.getTime().getTime();
	}

	public static String convertDateTime2String(Calendar calendar, String pattern) {
		String data = null;
		
		if (calendar != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.US);
			data = sdf.format(calendar.getTime());
		}

		return data;
	}
	
	public static Collection getWeekend(Calendar beginCal, Calendar endCal) {
		Calendar begin = getCalendar(beginCal.get(Calendar.DAY_OF_MONTH), beginCal.get(Calendar.MONTH), beginCal.get(Calendar.YEAR), 0, 0, 0);
		Calendar end = getCalendar(endCal.get(Calendar.DAY_OF_MONTH), endCal.get(Calendar.MONTH), endCal.get(Calendar.YEAR), 0, 0, 0);
		
		int day = begin.get(Calendar.DAY_OF_WEEK);
		Collection weekendCol = new ArrayList();
		int nextSat = 6;
		
		if (day == Calendar.SUNDAY) {
			weekendCol.add(getCalendar(begin.get(Calendar.DAY_OF_MONTH), begin.get(Calendar.MONTH), begin.get(Calendar.YEAR)));
		}
		else if (day == Calendar.SATURDAY) {
			weekendCol.add(getCalendar(begin.get(Calendar.DAY_OF_MONTH), begin.get(Calendar.MONTH), begin.get(Calendar.YEAR)));
			
			begin.add(Calendar.DAY_OF_MONTH, 1);
			
			if (begin.before(end) || begin.equals(end)) {
				weekendCol.add(getCalendar(begin.get(Calendar.DAY_OF_MONTH), begin.get(Calendar.MONTH), begin.get(Calendar.YEAR)));
			}
		}
		else {
			nextSat = 7 - day;
		}
		
		begin.add(Calendar.DAY_OF_MONTH, nextSat);
		
		for (;begin.before(end) || begin.equals(end); begin.add(Calendar.DAY_OF_MONTH, 6)) {
			weekendCol.add(getCalendar(begin.get(Calendar.DAY_OF_MONTH), begin.get(Calendar.MONTH), begin.get(Calendar.YEAR)));
			
			begin.add(Calendar.DAY_OF_MONTH, 1);
			
			if (begin.before(end) || begin.equals(end)) {
				weekendCol.add(getCalendar(begin.get(Calendar.DAY_OF_MONTH), begin.get(Calendar.MONTH), begin.get(Calendar.YEAR)));
			}
		}
			
		return weekendCol;
	}
	
	public static void setDay(Calendar cal, int day) {
		cal.set(Calendar.DAY_OF_MONTH, day);
	}
	
	public static void setMonth(Calendar cal, int month) {
		cal.set(Calendar.MONTH, month);
	}

	public static void setYear(Calendar cal, int year) {
		cal.set(Calendar.YEAR, year);
	}

	public static void setHour(Calendar cal, int hour) {
		cal.set(Calendar.HOUR_OF_DAY, hour);
	}

	public static void setMinute(Calendar cal, int minute) {
		cal.set(Calendar.MINUTE, minute);
	}

	public static void setSecond(Calendar cal, int second) {
		cal.set(Calendar.SECOND, second);
	}

	public static void setMilli(Calendar cal, int milli) {
		cal.set(Calendar.MILLISECOND, milli);
	}
	
	public static boolean equal(Calendar cal1, Calendar cal2) {
		Calendar c1 = getCalendar(cal1.get(Calendar.DAY_OF_MONTH), cal1.get(Calendar.MONTH), cal1.get(Calendar.YEAR), cal1.get(Calendar.HOUR), cal1.get(Calendar.MINUTE), cal1.get(Calendar.SECOND));
		Calendar c2 = getCalendar(cal2.get(Calendar.DAY_OF_MONTH), cal2.get(Calendar.MONTH), cal2.get(Calendar.YEAR), cal2.get(Calendar.HOUR), cal2.get(Calendar.MINUTE), cal2.get(Calendar.SECOND));
		
		return c1.equals(c2);
	}
	
	public static int minus(Calendar first, Calendar last) {
		Calendar fCal = ReportDateUtil.getCalendar(ReportDateUtil.getDay(first), ReportDateUtil.getMonth(first), ReportDateUtil.getYear(first));
		Calendar lCal = ReportDateUtil.getCalendar(ReportDateUtil.getDay(last), ReportDateUtil.getMonth(last), ReportDateUtil.getYear(last));
		
		long lastLong = lCal.getTime().getTime();
		long firstLong = fCal.getTime().getTime();
		
		long diff = lastLong - firstLong;
	
		return (new Long(diff / (24*60*60*1000))).intValue();	
	}

		public static int minusMinutes(Calendar first, Calendar last) {
			Calendar fCal = ReportDateUtil.getCalendar(ReportDateUtil.getDay(first), ReportDateUtil.getMonth(first), ReportDateUtil.getYear(first),ReportDateUtil.getHour(first),ReportDateUtil.getMinute(first),0);
			Calendar lCal = ReportDateUtil.getCalendar(ReportDateUtil.getDay(last), ReportDateUtil.getMonth(last), ReportDateUtil.getYear(last),ReportDateUtil.getHour(last),ReportDateUtil.getMinute(last),0);
			
			long lastLong = lCal.getTime().getTime();
			long firstLong = fCal.getTime().getTime();
			
			long diff = lastLong - firstLong;
		
			return (new Long(diff / (60*1000))).intValue();	
		}
	public static long getDiffInDays(Calendar d1,Calendar d2) {
		Calendar c1 = getCalendar(d1.get(Calendar.DAY_OF_MONTH), d1.get(Calendar.MONTH), d1.get(Calendar.YEAR),0,0,0);
		Calendar c2 = getCalendar(d2.get(Calendar.DAY_OF_MONTH), d2.get(Calendar.MONTH), d2.get(Calendar.YEAR),0,0,0);
		long diffInMilliSeconds=c1.getTime().getTime()-c2.getTime().getTime();
		return diffInMilliSeconds/(1000*60*60*24);
	}	
	/*
	 * Format is DD/MM/YYYY:HH:MI 10/9/2005:08:00
	 */
	public static Calendar getCalendar(String calStr){
		
		StringTokenizer token = new StringTokenizer(calStr,"/");
		String dd = token.nextToken();
		String mm = token.nextToken();
		String yy = token.nextToken(":").replace('/',' ').trim();
		String hh = token.nextToken(":");
		String mi = token.nextToken(":");
		
		return getCalendar(Integer.parseInt(dd),Integer.parseInt(mm), Integer.parseInt(yy),Integer.parseInt(hh),Integer.parseInt(mi));
	}
	public static String getStringSystemDateTime(String pattern){
		Calendar currentCalendar = ReportDateUtil.getCurrentDateTime();
		String systemDateTime = ReportDateUtil.convertDateTime2String(currentCalendar,pattern);
		return systemDateTime;
	}
	
	/**
	 * @deprecated
	 * 
	 * @param theDateStr
	 * @return
	 * @throws Exception
	 */
	public static Date getDate(String theDateStr) throws Exception{
		return getDate(theDateStr, "yyyy-MM-dd");
	}

	public static Date getDate(String theDateStr, String pattern) throws Exception{
		DebugHelper.logInvoke(slog, "PRE", new Object[] {theDateStr});
		SimpleDateFormat simpleDate = null;
		Date convertedDate = null;
		
		if(theDateStr != null && !theDateStr.trim().equals("")){
			simpleDate = new SimpleDateFormat(pattern, Locale.ENGLISH);
			convertedDate = simpleDate.parse(theDateStr);
		}	
		DebugHelper.logInvoke(slog, "POST", new Object[] {convertedDate});
		return convertedDate;
	}
	
	private static Vector getStringByDelimeter(String source, String delimeter)throws java.lang.Exception {
		Vector temp = null;
		if (source != null) {
			StringTokenizer st = new StringTokenizer(source, delimeter);
			temp = new Vector();
			while (st.hasMoreTokens())
				temp.addElement(st.nextToken());
		}
		return temp;
	}
	
	public  static boolean isValidFormatDateMMYYYY(String dateStr) {
		try {
			@SuppressWarnings("unused")
			SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy", new Locale("th","TH"));
			sdf.setLenient(false);
			sdf.parse(dateStr);
			return true;
			} catch(Exception e) {
				return false;
			}
		
	}
	
	public static boolean isValidFormatYearly(String dateStr) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy", new Locale("th", "TH"));
			sdf.setLenient(false);
			sdf.parse(dateStr);
			if (dateStr.length() != 4)
				return false;
			else
				return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean checkDateSameMonthYear(Date dateFrom,Date dateTo){
		boolean flag = false;
		
		Calendar dateFromTmp = null;
		Calendar dateToTmp = null;
		
		Calendar calDateFrom = null;
		Calendar calDateTo = null;
		Long dayDiff = null;
		
		try {
			if(dateFrom != null && dateTo != null){
				dateFromTmp = Calendar.getInstance();
				dateToTmp =  Calendar.getInstance();
				
				dateFromTmp.setTime(dateFrom);
				dateToTmp.setTime(dateTo);
				
				calDateFrom = ReportDateUtil.getCalendar(dateFromTmp.get(Calendar.DATE), dateFromTmp.get(Calendar.MONTH), dateFromTmp.get(Calendar.YEAR), dateFromTmp.get(Calendar.HOUR), dateFromTmp.get(Calendar.MINUTE), dateFromTmp.get(Calendar.SECOND));
				calDateTo = ReportDateUtil.getCalendar(dateToTmp.get(Calendar.DATE), dateToTmp.get(Calendar.MONTH), dateToTmp.get(Calendar.YEAR), dateToTmp.get(Calendar.HOUR), dateToTmp.get(Calendar.MINUTE), dateToTmp.get(Calendar.SECOND));
				
				dayDiff = getDiffInDays(calDateTo, calDateFrom);
				if(dayDiff.compareTo(new Long(30))>0){
					flag = true;					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public static List<SelectItem> getDDLYearTh() {
		List<SelectItem> ss = new ArrayList<SelectItem>();
		SelectItem si = null;
		int enYear = DateUtil.getCurrentYear();
		
		try{
			for (int i = enYear + 10; i > (enYear - 10); i--) {
				int thYear = i + 543;
				
				si = new SelectItem();
				si.setValue(i);
				si.setLabel("" + thYear);
				ss.add(si);
			}
		} catch (Exception e) {
			slog.error("ERROR IN " + ReportDateUtil.class + " " + e);;
		}
		return ss;
	}
	
	public static List<SelectItem> getDDLMonth() {
		List<SelectItem> ssList = new ArrayList<SelectItem>();
		ssList.add(new SelectItem("" , "-- Select --"));
		ssList.add(new SelectItem("01","January"));
		ssList.add(new SelectItem("02","February"));
		ssList.add(new SelectItem("03","March"));
		ssList.add(new SelectItem("04","April"));
		ssList.add(new SelectItem("05","May"));
		ssList.add(new SelectItem("06","June"));
		ssList.add(new SelectItem("07","July"));
		ssList.add(new SelectItem("08","August"));
		ssList.add(new SelectItem("09","September"));
		ssList.add(new SelectItem("10","October"));
		ssList.add(new SelectItem("11","November"));
		ssList.add(new SelectItem("12","December"));
		
		return ssList;
	}
	
	public static List<SelectItem> getDDLMonthTH() {
		List<SelectItem> ssList = new ArrayList<SelectItem>();
		ssList.add(new SelectItem("" , "-- Select --"));
		ssList.add(new SelectItem("01","มกราคม"));
		ssList.add(new SelectItem("02","กุมภาพันธ์"));
		ssList.add(new SelectItem("03","มีนาคม"));
		ssList.add(new SelectItem("04","เมษายน"));
		ssList.add(new SelectItem("05","พฤษภาคม"));
		ssList.add(new SelectItem("06","มิถุนายน"));
		ssList.add(new SelectItem("07","กรกฎาคม"));
		ssList.add(new SelectItem("08","สิงหาคม"));
		ssList.add(new SelectItem("09","กันยายน"));
		ssList.add(new SelectItem("10","ตุลาคม"));
		ssList.add(new SelectItem("11","พฤศจิกายน "));
		ssList.add(new SelectItem("12","ธันวาคม"));
		
		return ssList;
	}
	public static List<SelectItem> getDDLQuater(){
		List<SelectItem> ssList = new ArrayList<SelectItem>();
		ssList.add(new SelectItem("1", "เดือน 1 - เดือน 3"));
		ssList.add(new SelectItem("2", "เดือน 4 - เดือน 6"));
		ssList.add(new SelectItem("3", "เดือน 7 - เดือน 9"));
		ssList.add(new SelectItem("4", "เดือน 10 - เดือน 12"));
	
		return ssList;
	}
}
