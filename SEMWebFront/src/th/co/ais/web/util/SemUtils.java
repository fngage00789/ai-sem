package th.co.ais.web.util;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;

import th.co.ais.web.action.AbstractBaseAction;
import th.co.ais.web.report.util.ReportDateUtil;

public class SemUtils implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6946799141292900688L;
	
	public static String getSelectManyMenuValue(List<SelectItem> o) {
		if (o != null && !o.isEmpty()) {
			String str = "";
			boolean flag = true;
			for (SelectItem selectItem : o) {
				if (flag) {
					str += selectItem.getValue();
					flag = false;
				} else {
					str += "," + selectItem.getValue();
				}
			}
			return str;
		} else {
			return "";
		}
	}
	
	public static long parseLong(String value) {
		if (StringUtils.isEmpty(value)) {
			return 0;
		} else {
			return new Long(value);
		}
	}
	
	public static Integer parseInteger(String value) {
		if (StringUtils.isEmpty(value)) {
			return 0;
		} else {
			return new Integer(value);
		}
	}
	
	public static Double parseDouble(String value) {
		if (StringUtils.isEmpty(value)) {
			return new Double(0);
		} else {
			return new Double(value);
		}
	}
	
	public static String chkNull(String str) {
		if (str == null) {
			return "";
		} else {
			return str;
		}
	}
	
	public static boolean equalsString(String str1, String str2) {
		return StringUtils.equals(chkNull(str1), chkNull(str2));
	}
	
	public static boolean chkYearTH(String yearTH){
		if(yearTH.length()==4 && StringUtils.isNumeric(yearTH) && Integer.parseInt(yearTH)>2500){
			return true;
		}
		return false;
	}
	
	public static String chkMonthYearFormat(String monthYear){
		String[] MYArr = monthYear.split("/");
		if(MYArr.length!=2){
			//throw new RuntimeException("String format Exception (MM/YYYY)");
			return "message.monthYear";
		}
		
		String month = MYArr[0];
		
		if((!StringUtils.isNumeric(month) || Integer.parseInt(month)>12 || Integer.parseInt(month)<0)&&(!chkYearTH(MYArr[1]))){
			return "message.monthYear";
		}
		
		if(!StringUtils.isNumeric(month) || Integer.parseInt(month)>12 || Integer.parseInt(month)<0){
			return "message.month";
		}
		if(!chkYearTH(MYArr[1])){
			return "message.year";
		}
		return null;
	}
	
	public static boolean checkDateFromMoreThanDateTo(String dateFrom,String dateTo){
		boolean result = false;
		
		if(!"".equals(dateFrom) && !"".equals(dateTo)){
			String[] dateFromArr = dateFrom.split("/");
			String[] dateToArr = dateTo.split("/");
			if(Integer.parseInt(dateFromArr[1]) > Integer.parseInt(dateToArr[1])){
				return true;
			}else if(Integer.parseInt(dateFromArr[0]) > Integer.parseInt(dateToArr[0])){
				return true;
			}
		}
		return result;
	}
	
	public static String mergSelectListByComma(List<SelectItem> selectList){
		
		if(selectList == null || selectList.size()==0){
			return "";
		}
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<selectList.size();i++){
			sb.append(selectList.get(i).getValue());
			if(i<selectList.size()-1){
				sb.append(",");
			}
		}
		
		return sb.toString();
	}	
	
	public static String convertMonthYearTH2MonthYearEN(String monthYear){
		if(StringUtils.isNotEmpty(monthYear)){
			String[] mySplt = monthYear.split("/");
			if(mySplt.length!=2)throw new RuntimeException("String format Exception (MM/YYYY)");
			
			return mySplt[0]+"/"+(Integer.parseInt(mySplt[1])-543);
		}else{
			return null;
		}
	}
	
	public static String convertMonthYearEN2MonthYearTH(String monthYear){
		if(StringUtils.isNotEmpty(monthYear)){
			String[] mySplt = monthYear.split("/");
			if(mySplt.length!=2)throw new RuntimeException("String format Exception (MM/YYYY)");
			
			return mySplt[0]+"/"+(Integer.parseInt(mySplt[1])+543);
		}else{
			return null;
		}
	}
	
	public static int calDiffDate(Date startDate,Date endDate){
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		Date dt = new Date();
		// Set the date for both of the calendar instance
		cal1.setTime(startDate);
		cal2.setTime(endDate);
		
		return ReportDateUtil.minus(cal1, cal2);
	}
	
	public static List<SelectItem> getYearSelect(){
		SelectItem selItem = null;
		Date dt = new Date();
		Calendar date = Calendar.getInstance();
		date.set(Calendar.YEAR, date.get(Calendar.YEAR)+5);
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy", Locale.ENGLISH);
        Integer tmpPTaxYear = Integer.parseInt(dateformatter.format(date.getTime()));
        Integer tmpPTaxYearThai = Integer.parseInt(dateformatter.format(date.getTime()));
        List<SelectItem> list = new LinkedList<SelectItem>();
        selItem = new SelectItem("" , msg("value.selectItem"));
		list.add(selItem);
        for(int i = 0; i<16; i++){
        	selItem = new SelectItem();
        	if(i!=0){
        	   tmpPTaxYear = tmpPTaxYear-1;
        	   tmpPTaxYearThai = tmpPTaxYear - 1;
        	}
        	tmpPTaxYearThai = tmpPTaxYear + 543;
        	selItem.setLabel(String.valueOf(tmpPTaxYearThai));
        	selItem.setValue(tmpPTaxYear);
        	list.add(selItem);
        }
        return list;
	}
	
	private static final String msg(String key) {
		FacesContext context = FacesContext.getCurrentInstance();
		String text = FrontMessagePropUtil.getMessageResourceString(
					  context.getApplication().getMessageBundle(), key, null, 
					  context.getViewRoot().getLocale());
		return text;
	}
	
	public static final Date plusDate(Date date,Integer day,Integer month,Integer year){
		Calendar cal = Calendar.getInstance();
		if(date != null){
			cal.setTime(date);
			if(day != null && day != 0){
				cal.set(Calendar.DATE,cal.get(Calendar.DATE)+day);
			}
			if(month != null && month != 0){
				cal.set(Calendar.MONTH,cal.get(Calendar.MONTH)+month);
			}
			if(year != null && year != 0){
				cal.set(Calendar.YEAR,cal.get(Calendar.YEAR)+year);
			}
			return cal.getTime();
		}else{
			return date;
		}
		
	}
	
	public static String emptyString(String value){
		return StringUtils.isNotEmpty(value)?value:"";
	}
}
