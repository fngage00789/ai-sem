package th.co.ais.util;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Set;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.beanutils.WrapDynaBean;
import org.apache.commons.collections.comparators.ComparableComparator;
import org.apache.commons.collections.comparators.NullComparator;
import org.apache.commons.collections.comparators.ReverseComparator;
import org.apache.commons.lang.StringUtils;

import th.co.ais.rpt.util.DataUtil;
import th.co.ais.sso.ws.to.Parameter;
import th.co.ais.sso.ws.to.ParameterList;
import th.co.ais.sso.ws.to.SffResponse;

public class AISDataUtility {
	public static final Locale thLocale = new Locale("th", "TH");

	public static final Locale enLocale = new Locale("en", "US");

	//private static Calendar calendar = new GregorianCalendar(enLocale);

	public static final String DEFAULT_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

	public static final String SIMPLE_DATE_PATTERN = "dd/MM/yyyy";

	public static final String FULL_DATE_PATTERN = "dd MMMM yyyy";
	
	public static final String SIMPLE_DATETIME_PATTERN = "dd/MM/yyyy HH:mm:ss";

	public static final String PATTERN_yyMM = "yyMM";

	public static final long MILLISECS_PER_DAY = 86400000;

	private static final String SET_INJECT_TYPE_MOD = "modify";

	private static final String SET_INJECT_TYPE_CREATE = "create";

	private static final String SET_INJECT_TYPE_DYNAMIC = "dynamic";
	
	private static final String DEFAULT_NUMBER_PATTERN = "#,###.##";
	
	private static final String SIMPLE_NUMBER_PATTERN = "#,##";

	/**
	 * Utililty For Date Object
	 */
	public static Date getCurrentDate() throws Exception {
		return new GregorianCalendar(enLocale).getTime();
	}

	/**
	 * 
	 * @return Date By Specific Thai Locale
	 * @throws Exception
	 */
	public static Date getCurrentDateTh() throws Exception {
		return new GregorianCalendar(thLocale).getTime();
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public static Date getCurrentDateByPattern() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(SIMPLE_DATE_PATTERN);
		String curDate = sdf.format(new Date());
		return sdf.parse(curDate);
	}

	public static Date convertDateByPattern(Date date) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(SIMPLE_DATE_PATTERN);
		String curDate = sdf.format(date);
		return sdf.parse(curDate);
	}
	
	public static Locale getDefaultLocale() {
		return enLocale;
	}

	/*
	 * String Thai Date Format with pattern dd/MM/yyyy
	 * 
	 */
	public static String toStringThaiDateSimpleFormat(Date date) throws Exception {
		SimpleDateFormat thFormat = new SimpleDateFormat(SIMPLE_DATE_PATTERN, thLocale);
		return thFormat.format(date);
	}

	/*
	 * String Thai Date Format with pattern dd/MM/yyyy hh:mm:ss
	 */
	public static String toStringThaiDateTimeSimpleFormat(Date date) throws Exception {
		SimpleDateFormat thFormat = new SimpleDateFormat(SIMPLE_DATETIME_PATTERN, thLocale);
		return thFormat.format(date);
	}
	
	/*
	 * String Thai Date Format with pattern dd/MM/yyyy hh:mm:ss
	 */
	public static String toStringThaiDateFullFormat(Date date) throws Exception {
		if (date != null) {
			SimpleDateFormat thFormat = new SimpleDateFormat(FULL_DATE_PATTERN, thLocale);
			return thFormat.format(date);
		}
		return "";
	}

	/*
	 * String Eng Date Format with pattern dd/MM/yyyy
	 * 
	 */
	public static String toStringEngDateSimpleFormat(Date date) throws Exception {
		SimpleDateFormat engFormat = new SimpleDateFormat(SIMPLE_DATE_PATTERN, enLocale);
		return engFormat.format(date);
	}

	/*
	 * String Eng Date Format with pattern dd/MM/yyyy hh:mm:ss
	 */
	public static String toStringEngDateTimeSimpleFormat(Date date) {
		SimpleDateFormat engFormat = new SimpleDateFormat(SIMPLE_DATETIME_PATTERN, enLocale);
		return engFormat.format(date);
	}

	/*
	 * String Eng Date Format with pattern yyMM
	 */
	public static String toStringEngDateBySimpleFormat(Date date, String formatDate) {
		SimpleDateFormat engFormat = new SimpleDateFormat(formatDate, enLocale);
		return engFormat.format(date);
	}

	/*
	 * Thai Date Format with custom pattern and Locale
	 */
	public static String toStringCustomDateFormat(Date date, String pattern, Locale locale) {
		SimpleDateFormat strFormat = new SimpleDateFormat(pattern, locale);
		return strFormat.format(date);
	}

	/*
	 * convert Date String to Date Object . Apply for patterns, dd/MM/yyyy,
	 * dd/MM/yyyy HH:mm:ss, yyyy-MM-dd HH:mm:ss
	 */
	public static Date convertStringToDate(String stringDate) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat();
		format.setCalendar(new GregorianCalendar(enLocale));
		Date rtnDate = null;
		try {
			format.applyPattern(SIMPLE_DATE_PATTERN);
			rtnDate = format.parse(stringDate);
		} catch (ParseException pe1) {
			try {
				format.applyPattern(SIMPLE_DATETIME_PATTERN);
				rtnDate = format.parse(stringDate);
			} catch (ParseException pe2) {
				format.applyPattern(DEFAULT_DATETIME_PATTERN);
				rtnDate = format.parse(stringDate);
			}
		}
		return rtnDate;
	}

	/*
	 * convert Date String to Date Object . Apply for patterns, dd/MM/yyyy,
	 * dd/MM/yyyy HH:mm:ss, yyyy-MM-dd HH:mm:ss
	 */
	public static Date convertStringToDateByFormat(String stringDate, String pattern) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat(pattern, enLocale);
		Date rtnDate = format.parse(stringDate);
		return rtnDate;
	}

	/*
	 * calculate Diff Date return number of differ days
	 * 
	 */
	public static long diffDayCalculate(Date startDate, Date endDate) throws Exception {
		long endL = endDate.getTime();
		long startL = startDate.getTime();
		return ((endL - startL) / MILLISECS_PER_DAY);
	}

	public static long diffSecCalculate(Date startDate, Date endDate) throws Exception {
		long endL = endDate.getTime();
		long startL = startDate.getTime();
		return ((endL - startL) /1000);
	}
	/*
	 * calculate Diff Date return number of differ days
	 * 
	 */
	public static long diffDayCalculateIgnoreTime(Date startDate, Date endDate) throws Exception {
		/*
		 * Date startDateNoTime = setDateIgnoreTime(startDate); Date
		 * endDateNoTime = setDateIgnoreTime(endDate); long endL =
		 * endDateNoTime.getTime(); long startL = startDateNoTime.getTime();
		 * return ((endL - startL) / MILLISECS_PER_DAY);
		 */
		SimpleDateFormat sdf = new SimpleDateFormat(SIMPLE_DATE_PATTERN);
		String startDtString = sdf.format(startDate);
		Date startDateNoTime = sdf.parse(startDtString);
		String endDtString = sdf.format(endDate);
		Date endDateNoTime = sdf.parse(endDtString);

		long endL = endDateNoTime.getTime();
		long startL = startDateNoTime.getTime();
		return ((endL - startL) / MILLISECS_PER_DAY);
	}

	/*
	 * private static Date setDateIgnoreTime(Date date) throws Exception{
	 * Calendar calendar = new GregorianCalendar(); calendar.setTime(date);
	 * calendar.set(Calendar.HOUR, 0); calendar.set(Calendar.MINUTE, 0);
	 * calendar.set(Calendar.SECOND, 0); calendar.set(Calendar.MILLISECOND, 0);
	 * return calendar.getTime(); }
	 */

	/*
	 * calculate Diff Month return number of differ months
	 * 
	 */
	public static long diffMonthCalculate(Date startDate, Date endDate) throws Exception {
		long endL = endDate.getTime();
		long startL = startDate.getTime();
		return ((endL - startL) / (MILLISECS_PER_DAY * 30));
	}
	/*
	 * calculate Diff Month return number of differ months
	 * 
	 */
	public static long diffMonthCalculateIgnoreTime(Date startDate, Date endDate) throws Exception {
		/*
		 * Date startDateNoTime = setDateIgnoreTime(startDate); Date
		 * endDateNoTime = setDateIgnoreTime(endDate); long endL =
		 * endDateNoTime.getTime(); long startL = startDateNoTime.getTime();
		 * return ((endL - startL) / MILLISECS_PER_DAY);
		 */
		SimpleDateFormat sdf = new SimpleDateFormat(SIMPLE_DATE_PATTERN);
		String startDtString = sdf.format(startDate);
		Date startDateNoTime = sdf.parse(startDtString);
		String endDtString = sdf.format(endDate);
		Date endDateNoTime = sdf.parse(endDtString);

		long endL = endDateNoTime.getTime();
		long startL = startDateNoTime.getTime();
		return ((endL - startL) / (MILLISECS_PER_DAY * 30));
	}

	public static long diffYearCalculate(Date startDate, Date endDate) throws Exception {
		long endL = endDate.getTime();
		long startL = startDate.getTime();
		return ((endL - startL) / (MILLISECS_PER_DAY * 365));
	}
	/*
	 * calculate Diff Year return number of differ years
	 * 
	 */
	public static long diffYearCalculateIgnoreTime(Date startDate, Date endDate) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(SIMPLE_DATE_PATTERN);
		String startDtString = sdf.format(startDate);
		Date startDateNoTime = sdf.parse(startDtString);
		String endDtString = sdf.format(endDate);
		Date endDateNoTime = sdf.parse(endDtString);

		long endL = endDateNoTime.getTime();
		long startL = startDateNoTime.getTime();
		return ((endL - startL) / (MILLISECS_PER_DAY * 365));
	}
	
	/*
	 * shift min up 
	 * int mins = +,-
	 */
	//Add by Chayatorn 12/05/2010
	public static Date shiftMinute(Date inputDate, int mins) throws Exception {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(inputDate);
		calendar.add(Calendar.MINUTE, mins);
		return calendar.getTime();
	}
	
	/*
	 * shift date up
	 */
	public static Date shiftDateUp(Date inputDate, int days) throws Exception {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(inputDate);
		calendar.add(Calendar.DAY_OF_MONTH, days);
		return calendar.getTime();
	}

	/*
	 * shift date down
	 */
	public static Date shiftDateDown(Date inputDate, int days) throws Exception {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(inputDate);
		int dayDown = days * -1;
		calendar.add(Calendar.DAY_OF_MONTH, dayDown);
		return calendar.getTime();
	}

	/*
	 * shift month up
	 */
	public static Date shiftMonthUp(Date inputDate, int months) throws Exception {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(inputDate);
		calendar.add(Calendar.MONTH, months);
		return calendar.getTime();
	}

	/*
	 * shift month down
	 */
	public static Date shiftMonthDown(Date inputDate, int months) throws Exception {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(inputDate);
		int monthDown = months * -1;
		calendar.add(Calendar.MONTH, monthDown);
		return calendar.getTime();
	}

	/*
	 * convert double to String. Apply for patterns 1) #,### 2) #,##0.00 3) etc
	 */
	public static String convertNumberToStringByFormat(double inputDouble, String format) {
		DecimalFormat decimalFormat = new DecimalFormat(format);
		return decimalFormat.format(inputDouble);
	}

	public static String convertNumberToStringByDefaultFormat(BigDecimal inputDouble) {
		return convertNumberToStringByFormat(inputDouble, DEFAULT_NUMBER_PATTERN);
	}
	
	public static String convertNumberToStringBySimpleFormat(BigDecimal inputDouble) {
		return convertNumberToStringByFormat(inputDouble, SIMPLE_NUMBER_PATTERN);
	}
	
	public static String convertNumberToStringByFormat(BigDecimal inputDouble, String format) {
		DecimalFormat decimalFormat = new DecimalFormat(format);
		return (inputDouble != null ? decimalFormat.format((Object)inputDouble) : "");
	}

	/*
	 * convert long to String. Apply for patterns 1) #,### 2) etc
	 */
	public static String convertNumberToStringByFormat(long inputLong, String format) {
		DecimalFormat decimalFormat = new DecimalFormat(format);
		return decimalFormat.format(inputLong);
	}

	/**
	 * return List (ArrayList) is the input Set is not Null
	 * 
	 * @param Set
	 *            sets
	 * @return List
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static List convertSetToList(Set sets) throws Exception {
		if (sets == null) {
			return null;
		} else {
			return new ArrayList(sets);
		}
	}

	/**
	 * return Set (HashSet) is the input List is not Null
	 * 
	 * @param List
	 *            lists
	 * @return Set
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static Set convertListToSet(List lists) throws Exception {
		if (lists == null) {
			return null;
		} else {
			return new HashSet(lists);
		}
	}

	/**
	 * inject creator to createdBy at domain filed
	 * 
	 * @param obj
	 * @param creator
	 */

	public static void injectCreatorToDomain(Object domain, String creator) throws Exception {
		WrapDynaBean wrapBean = new WrapDynaBean(domain);
		setCreatorOrModifior(wrapBean, creator, SET_INJECT_TYPE_CREATE);
		findChild(wrapBean, creator, SET_INJECT_TYPE_CREATE);
	}

	/**
	 * inject creator to lastUpdBy at domain filed
	 * 
	 * @param obj
	 * @param creator
	 */
	public static void injectModifierToDomain(Object domain, String modifier) throws Exception {
		WrapDynaBean wrapBean = new WrapDynaBean(domain);
		setCreatorOrModifior(wrapBean, modifier, SET_INJECT_TYPE_MOD);
		findChild(wrapBean, modifier, SET_INJECT_TYPE_MOD);
	}

	/**
	 * inject DateTime to created at domain field
	 * 
	 * @param obj
	 * @param creator
	 */
	public static void injectCreatDateToDomain(Object domain) throws Exception {
		WrapDynaBean wrapBean = new WrapDynaBean(domain);
		setCreateDateOrModifyDate(wrapBean, SET_INJECT_TYPE_CREATE);
		findChild(wrapBean, SET_INJECT_TYPE_CREATE);
	}

	/**
	 * inject DateTime to lastUpd at domain field
	 * 
	 * @param obj
	 * @param creator
	 */
	public static void injectModifiedDateToDomain(Object domain) throws Exception {
		WrapDynaBean wrapBean = new WrapDynaBean(domain);
		setCreateDateOrModifyDate(wrapBean, SET_INJECT_TYPE_MOD);
		findChild(wrapBean, SET_INJECT_TYPE_MOD);
	}

	/**
	 * inject dynamic values to dynamic fields at domain field
	 * 
	 * @param obj
	 * @param creator
	 */
	public static void injectDynamicValuesToDomain(Object domain, Object value, String fieldName) throws Exception {
		WrapDynaBean wrapBean = new WrapDynaBean(domain);
		setDynamicValues(wrapBean, value, fieldName);
		findChild(wrapBean, value, SET_INJECT_TYPE_DYNAMIC, fieldName);
	}

	private static void findChild(WrapDynaBean wrapBean, String creator, String type) throws Exception {
		for (DynaProperty dp : wrapBean.getDynaClass().getDynaProperties()) {
			if (dp.getType() == java.util.Set.class) {
				Set bSet = (Set) wrapBean.get(dp.getName());
				if (!AISDataValidateUtil.isCollectionEmpty(bSet)) {
					Iterator iter = bSet.iterator();
					for (Object obj : bSet) {
						if (type.equals(SET_INJECT_TYPE_CREATE))
							injectCreatorToDomain(obj, creator);
						else if (type.equals(SET_INJECT_TYPE_MOD))
							injectModifierToDomain(obj, creator);
					}
				}
			} else {
				continue;
			}
		}
	}

	private static void findChild(WrapDynaBean wrapBean, String type) throws Exception {
		for (DynaProperty dp : wrapBean.getDynaClass().getDynaProperties()) {
			if (dp.getType() == java.util.Set.class) {
				Set bSet = (Set) wrapBean.get(dp.getName());
				if (!AISDataValidateUtil.isCollectionEmpty(bSet)) {
					Iterator iter = bSet.iterator();
					for (Object obj : bSet) {
						if (type.equals(SET_INJECT_TYPE_CREATE))
							injectCreatDateToDomain(obj);
						else if (type.equals(SET_INJECT_TYPE_MOD))
							injectModifiedDateToDomain(obj);
					}
				}
			} else {
				continue;
			}
		}
	}

	private static void findChild(WrapDynaBean wrapBean, Object creator, String type, String fieldName) throws Exception {
		for (DynaProperty dp : wrapBean.getDynaClass().getDynaProperties()) {
			if (dp.getType() == java.util.Set.class) {
				Set bSet = (Set) wrapBean.get(dp.getName());
				if (!AISDataValidateUtil.isCollectionEmpty(bSet)) {
					Iterator iter = bSet.iterator();
					for (Object obj : bSet) {
						if (type.equals(SET_INJECT_TYPE_DYNAMIC))
							injectDynamicValuesToDomain(obj, creator, fieldName);
					}
				}
			} else {
				continue;
			}
		}
	}

	private static void setCreatorOrModifior(WrapDynaBean wrapBean, String name, String type) throws Exception {
		if (type.equals(SET_INJECT_TYPE_CREATE)) {
			wrapBean.set("createdBy", name);
			wrapBean.set("lastUpdBy", name);
		} else if (type.equals(SET_INJECT_TYPE_MOD))
			wrapBean.set("lastUpdBy", name);
	}

	private static void setCreateDateOrModifyDate(WrapDynaBean wrapBean, String type) throws Exception {
		if (type.equals(SET_INJECT_TYPE_CREATE)) {
			wrapBean.set("created", new Timestamp(new Date().getTime()));
			wrapBean.set("lastUpd", new Timestamp(new Date().getTime()));
		} else if (type.equals(SET_INJECT_TYPE_MOD))
			wrapBean.set("lastUpd", new Timestamp(new Date().getTime()));
	}

	private static void setDynamicValues(WrapDynaBean wrapBean, Object value, String fieldName) throws Exception {
		try {
			wrapBean.set(fieldName, value);
		} catch (IllegalArgumentException iae) {
			// iae.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int calculateCustomerAge(Date custBirthDate) throws Exception {
		Date currentDate = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(currentDate);
		int currentYear = calendar.get(Calendar.YEAR);
		int currentMonth = calendar.get(Calendar.MONTH);
		int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.setTime(custBirthDate);
		int custBirthYear = calendar.get(Calendar.YEAR);
		int custBirthMonth = calendar.get(Calendar.MONTH);
		int custBirthDay = calendar.get(Calendar.DAY_OF_MONTH);
		int diffYear = currentYear - custBirthYear;

		if (custBirthMonth > currentMonth) {
			diffYear = diffYear - 1;
		} else if (custBirthMonth == currentMonth) {
			if (custBirthDay > currentDay)
				diffYear = diffYear - 1;
		}
		
		/*if (custBirthMonth < currentMonth) {
			diffYear = diffYear - 1;
		} else if (custBirthMonth == currentMonth) {
			if (custBirthDay < currentDay)
				diffYear = diffYear - 1;
		}*/
		return diffYear;
	}

	/**
	 * Domain Collection Sorting By specific property
	 * 
	 * @param orderBy
	 * @param listDomain
	 */
	public static List sortDomainListByField(List listDomain, String orderBy) throws Exception {
		BeanComparator orderBeanComparator = new BeanComparator(orderBy, new NullComparator(new ComparableComparator(), true));
		Collections.sort((List) listDomain, orderBeanComparator);
		return listDomain;
	}

	/**
	 * Domain Collection reverse Sorting By specific property
	 * 
	 * @param orderBy
	 * @param listDomain
	 */
	public static List sortReverseDomainListByField(List listDomain, String orderBy) throws Exception {
		BeanComparator reverseOrderBeanComparator = new BeanComparator(orderBy, new ReverseComparator(new NullComparator(new ComparableComparator(), false)));
		Collections.sort((List) listDomain, reverseOrderBeanComparator);
		return listDomain;
	}
	
	/**
	 * Sorting Column form Collection By specific property
	 * 
	 * @param orderBy
	 * @param listDomain
	 * @param orderBySortType
	 * 			HashMap<String, String> which key is fieldName and value is sortType such as "A" = asc, "D" = dsc and "U" = unsort
	 */
	public static List sortColumnListBySortTypeFieldName(List listDomain, String orderBy, HashMap<String, String> orderBySortType) throws Exception {
		String sortType = orderBySortType.get(orderBy);
		//Sort >> if Map value is "U" or "D", sort by asc
		//		  if Map value is "A", sort by dsc
		if ("U".equals(sortType) || "D".equals(sortType)) {
			listDomain = AISDataUtility.sortDomainListByField(listDomain, orderBy);
			orderBySortType.put(orderBy, "A");
		} else if ("A".equals(sortType))  {
			listDomain = AISDataUtility.sortReverseDomainListByField(listDomain, orderBy);
			orderBySortType.put(orderBy, "D");
		}
		//Reset other fields (Single sort)
		for (String key : orderBySortType.keySet()) {
			if (!orderBy.equals(key)) {
				orderBySortType.put(key, "U");
			}
		}
		
		return listDomain;
	}

	public static String buildMessage(String message, String... arguments) {
		// System.out.println("buildMessage");
		if (arguments != null && arguments.length > 0) {
			for (int i = 0; i < arguments.length; i++) {
				String postion = "%".concat(String.valueOf(i + 1));
				String argument = arguments[i];
				if (postion != null && argument != null) {
					message = message.replace(postion, argument);
				}
			}
		}
		return message;
	}

	// Override method
	public static String buildMessage(String message, List<String> arguments) {
		// System.out.println("buildMessage");
		if (arguments != null && arguments.size() > 0) {
			for (int i = 0; i < arguments.size(); i++) {
				String postion = "%".concat(String.valueOf(i + 1));
				String argument = arguments.get(i);
				if (postion != null && argument != null) {
					message = message.replace(postion, argument);
				}
			}
		}
		return message;
	}

	public static String getFileExtension(String fileName) {
		String[] fileNames = fileName.split("[.]");
		if (fileNames != null && fileNames.length > 1) {
			return fileNames[fileNames.length - 1];
		}
		return fileName;
	}

	/**
	 * Copy Java Bean Properties param1 accept Destination Java Bean Object
	 * param2 accept Input Java Bean Object
	 */
	public static void copyProperties(Object dest, Object input) throws Exception {
		WrapDynaBean inputBean = new WrapDynaBean(input);
		WrapDynaBean outputBean = new WrapDynaBean(dest);
		for (DynaProperty dp : outputBean.getDynaClass().getDynaProperties()) {
			try {
				if (inputBean.get(dp.getName()) != null && (dp.getType() != java.lang.Class.class)) {
					outputBean.set(dp.getName(), inputBean.get(dp.getName()));
				}
			} catch (IllegalArgumentException ie) {
				continue;
			}
		}
	}

	/**
	 * Convert Domain List To WrapperBeanObject param1 accept List Of Domain
	 * Object
	 * 
	 */
//	public static <T> List convertDomainToWrapBeanList(Collection<T> domainList) throws Exception {
//		List<WrapperBeanObject<T>> convertList = new ArrayList<WrapperBeanObject<T>>();
//		if (!AISDataValidateUtil.isCollectionEmpty(domainList)) {
//			for (T domainObj : domainList) {
//				WrapperBeanObject wrapBeanObj = new WrapperBeanObject();
//				wrapBeanObj.setDataObj(domainObj);
//				convertList.add(wrapBeanObj);
//			}
//		}
//		return convertList;
//	}
	
	/**
	 * Convert WrapperBean List To Domain Object List accept List Of WrapperBeanObject
	 * Object
	 * 
	 */
//	public static <T> List convertWrapBeanToObjectList(Collection<WrapperBeanObject<T>> wrapperDomainList) throws Exception {
//		List<T> convertList = new ArrayList<T>();
//		if (!AISDataValidateUtil.isCollectionEmpty(wrapperDomainList)) {
//			for (WrapperBeanObject<T> wrapperDomain : wrapperDomainList) {
//				T obj = (T) wrapperDomain.getDataObj();
//				convertList.add(obj);
//			}
//		}
//		
//		return convertList;
//	}

	public static Date getLastDayOfMonth(Date date) throws Exception {
		String dd = "01";
		String MM = toStringCustomDateFormat(date, "MM", Locale.US);
		String yyyy = toStringCustomDateFormat(date, "yyyy", Locale.US);

		Date lastDayOfMonth = shiftDateDown(shiftMonthUp(convertStringToDateByFormat(dd + "/" + MM + "/" + yyyy, "dd/MM/yyyy"), 1), 1);

		return lastDayOfMonth;
	}

	public static String convertCreditNoDisplay(String inputNo) {
		if (inputNo != null && !"".equals(inputNo)) {
			if (inputNo.length() > 4) {
				int endPoint = inputNo.length() - 4;
				String returnVal = "";
				for (int i = 0; i < endPoint; i++) {
					returnVal += "X";
				}
				returnVal += inputNo.substring(endPoint, inputNo.length());
				return returnVal;
			} else {
				return inputNo;
			}
		} else {
			return "";
		}
	}

	public static Date convertToEnYear(Date inputDate) throws Exception {
		try {
			// en Locale
			Date currentDate = AISDataUtility.getCurrentDate();
			SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
			SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
			SimpleDateFormat dayFormat = new SimpleDateFormat("dd");

			SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");

			String strCurrYear = yearFormat.format(currentDate);
			String strInputYear = yearFormat.format(inputDate);
			String strInputMonth = monthFormat.format(inputDate);
			String strInputDay = dayFormat.format(inputDate);
			String strInputTime = timeFormat.format(inputDate);

			if (StringUtils.isNumeric(strInputYear) && StringUtils.isNumeric(strCurrYear)) {
				int inputYear = Integer.parseInt(strInputYear);
				int currYear = Integer.parseInt(strCurrYear);

				if (inputYear > currYear) {
					inputYear -= 543;

					strInputYear = Integer.toString(inputYear);
					DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
					inputDate = (Date) formatter.parse(strInputDay + "/" + strInputMonth + "/" + strInputYear + " " + strInputTime);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inputDate;
	}

	public static void convertParameterListToObject(ParameterList parameterList, Object domain) throws Exception {
		try {
			WrapDynaBean wrapBean = new WrapDynaBean(domain);
			if ((wrapBean != null) && (parameterList != null)) {
				Parameter[] parameters = parameterList.getParameter();
				if ((parameters != null) && (parameters.length > 0)) {
					for (Parameter parameter : parameters) {
						setDynamicValues(wrapBean, parameter.getValue(), parameter.getName());
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void convertObjectToSffResponse(Object domain, SffResponse sffResponse, String errorMessage) throws Exception {
		try {
			sffResponse.setErrorMessage(errorMessage);
			WrapDynaBean wrapBean = new WrapDynaBean(domain);
			if (wrapBean != null) {
				ParameterList parameterList = new ParameterList();
				convertObjectToParameterList(wrapBean, parameterList);
				sffResponse.setParameterList(parameterList);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	public static HashMap<String,String> convertParameterListToHashMap(ParameterList parameterList) throws Exception {
		HashMap<String,String> hm = new HashMap<String,String>();
		try {
			if (parameterList != null) {
				Parameter[] parameters = parameterList.getParameter();
				if ((parameters != null) && (parameters.length > 0)) {
					for (Parameter parameter : parameters) {
						hm.put(parameter.getName(), parameter.getValue());
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return hm;
	}
	
	private static void convertObjectToParameterList(WrapDynaBean wrapBean, ParameterList parameterList) throws Exception {
		try {
			ParameterList[] parameterLists = null;
			Parameter[] parameters = null;
			HashMap<String, String> hashMap = new HashMap<String, String>();
			for (DynaProperty dp : wrapBean.getDynaClass().getDynaProperties()) {
				if (dp.getType() == java.lang.String.class) {
					hashMap.put(dp.getName(), (String) wrapBean.get(dp.getName()));
				} else if (dp.getType() == java.util.Date.class) {
					Date dateValue = (Date) wrapBean.get(dp.getName());
					if (dateValue != null) {
						hashMap.put(dp.getName(), toStringThaiDateTimeSimpleFormat((Date) wrapBean.get(dp.getName())));
					} else {
						hashMap.put(dp.getName(), "");
					}
				} else if (dp.getType() == java.util.List.class) {
					List bList = (List) wrapBean.get(dp.getName());
					if (!AISDataValidateUtil.isCollectionEmpty(bList)) {
						int i = 0;
						parameterLists = new ParameterList[bList.size()];
						for (Object obj : bList) {
							WrapDynaBean childWrapBean = new WrapDynaBean(obj);
							ParameterList childParameterList = new ParameterList();
							convertObjectToParameterList(childWrapBean, childParameterList);
							parameterLists[i] = childParameterList;
							i++;
						}
					}
				} else if (dp.getType() == java.util.Set.class) {
					Set bSet = (Set) wrapBean.get(dp.getName());
					if (!AISDataValidateUtil.isCollectionEmpty(bSet)) {
						int i = 0;
						parameterLists = new ParameterList[bSet.size()];
						for (Object obj : bSet) {
							WrapDynaBean childWrapBean = new WrapDynaBean(obj);
							ParameterList childParameterList = new ParameterList();
							convertObjectToParameterList(childWrapBean, childParameterList);
							parameterLists[i] = childParameterList;
							i++;
						}
					}
				} else {
					continue;
				}
			}
			int i = 0;
			parameters = new Parameter[hashMap.size()];
			Set set = hashMap.entrySet();
			Iterator iter = set.iterator();
			while(iter.hasNext()) {
				Map.Entry me = (Map.Entry)iter.next();
				Parameter parameter = new Parameter();
				parameter.setName((String) me.getKey());
				parameter.setValue((String) me.getValue());
				parameters[i] = parameter;
				i++;
			}
			parameterList.setParameter(parameters);
			parameterList.setParameterList(parameterLists);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int randomNumber() {		
		return new Random().nextInt(10);
	}
	
	public static String formatNumber4FixComma(String num)throws Exception{
		
		String resultData = "";
		if (num!=null && num.trim().length()>0) {
			if (num.contains(",")) {
				num = num.replaceAll(",", "");
			}

			try {
				String[] numIsSplit = num.split("\\.");
				int fixComma = 1;
				String valueIndex = "";
				for (int i = numIsSplit[0].length(); i > 0; i--) {

					valueIndex = numIsSplit[0].substring(i - 1, i);
					resultData = valueIndex + resultData;
					if (fixComma == 3) {
						resultData = "," + resultData;
						fixComma = 0;
					}
					fixComma++;
				}
				if (fixComma == 1) {
					resultData = resultData.substring(1, resultData.length());
				}
				if (numIsSplit.length != 1) {
					resultData += "." + numIsSplit[1];
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
		return resultData;
	}
	
	public static Date adjustTimeToStartOfDate (Date inputDate)
    {
        Calendar calendar = Calendar.getInstance ();
        calendar.setTime(inputDate);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        
        return calendar.getTime ();
    }
    
    public static Date adjustTimeToEndOfDate (Date inputDate)
    {
        Calendar calendar = Calendar.getInstance ();
        calendar.setTime(inputDate);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        
        return calendar.getTime ();
    }
    
	/********************************************************************************
	  * Methods setLineSeparator convert String List to String separated by newline *
	  *******************************************************************************/
	public static String setLineSeparator(List<String> sErrMsgList){
		String eol = System.getProperty("line.separator");
		StringBuilder sErrMsg = new StringBuilder();
		if(null != sErrMsgList && sErrMsgList.size() > 0){
			for(int i = 0 ; i < sErrMsgList.size(); i++) {
				if (i == 0) {
					sErrMsg.append(sErrMsgList.get(i)); 
				}else{
					sErrMsg.append(eol+sErrMsgList.get(i)); 
				}
			}
		}
		return sErrMsg.toString();
	}

	/******************************************************************************
	  * Methods setLineSeparator convert String List to String separated by comma *
	  *****************************************************************************/
	public static String setCommaSeparator(List<String> sErrorParam){
		StringBuilder sAppendErr = new StringBuilder();
		int sErrSize = sErrorParam.size();
		if(sErrSize > 1){
			for(int i = 0; i < sErrSize ; i++){
				if(i < sErrSize-1){
					sAppendErr.append(sErrorParam.get(i));
					sAppendErr.append(", ");
				}else{
					sAppendErr.append(sErrorParam.get(i));
				}
			}
		}else if (sErrSize == 1){
			sAppendErr.append(sErrorParam.get(0));
		}else{
			return null;
		}
		return sAppendErr.toString();
	}
	
	
}