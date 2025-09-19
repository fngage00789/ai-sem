package com.ais.migrate.sem.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateUtility {
	
	public static Locale EN_LOCALE = new Locale("en", "US");
	
	public static Date convertStringToDate(String stringDate, String pattern, Locale locale) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat();
		format.setCalendar(new GregorianCalendar(locale));
		Date rtnDate = null;
		try {
			format.applyPattern(pattern);
			rtnDate = format.parse(stringDate);
		} catch (ParseException pe1) {
			pe1.printStackTrace();
		}
		return rtnDate;
	}
	
	public static String dateTime(){
		Date cdate =  Calendar.getInstance(Locale.US).getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.US);
		return sdf.format(cdate);
	}
}
