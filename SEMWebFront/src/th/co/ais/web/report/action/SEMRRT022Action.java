package th.co.ais.web.report.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;


import th.co.ais.rpt.parameter.SEMRRT022ReportParameter;
import th.co.ais.util.ELovType;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMRRT022Bean;
import th.co.ais.web.util.SemUtils;

public class SEMRRT022Action extends AbstractReportAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2524424552117504744L;
	private Logger log = Logger.getLogger(getClass());
	private SEMRRT022Bean semrrt022Bean;
	
	public SEMRRT022Bean getSemrrt022Bean() {
		return (SEMRRT022Bean) getFacesUtils().getSessionMapValue("semrrt022Bean");
	}

	public void setSemrrt022Bean(SEMRRT022Bean semrrt022Bean) {
		getFacesUtils().setSessionMapValue("semrrt022Bean", semrrt022Bean);
	}

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		
		if(methodWithNavi.equalsIgnoreCase("doRunReport")){
			runReport();
		} else if (methodWithNavi.equalsIgnoreCase("doShowReport")) {
			showReport();
		} else if (methodWithNavi.equalsIgnoreCase("doClearReport")) {
			clearReport();
		}
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		super.clearSessionBean();
	}
	
	private List<SelectItem> getDdlExpenseTypeForRt022() {
		List<SelectItem> tmp = getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name);
		List<SelectItem> tmpUse = new ArrayList<SelectItem>();
		for (SelectItem tmpItem : tmp) {
			if (tmpItem.getValue().equals("01") || tmpItem.getValue().equals("02") || tmpItem.getValue().equals("06")) {
				tmpUse.add(tmpItem);
			}
		}
		return tmpUse;
	}

	@Override
	public void init() {
		super.clearSessionBean();
		
		semrrt022Bean = new SEMRRT022Bean();
		semrrt022Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
//		semrrt022Bean.setExpenseTypeList(getDdlExpenseTypeForRt022());
		semrrt022Bean.setExpenseTypeList(getLovItemsByType(ELovType.RT_RPT_SEMRRT022_EXPENSE_TYPE.name));
		List<SelectItem> diffList = new ArrayList<SelectItem>();
		
		String[] messageStr = {msg("message.moreThan"),msg("message.lessThan")};
		String[] valueStr = {"MT","LT"};
		SelectItem tmpSelectItem;
		for(int i=0;i<messageStr.length;i++){
			tmpSelectItem = new SelectItem();
			tmpSelectItem.setValue(valueStr[i]);
			tmpSelectItem.setLabel(messageStr[i]);
			diffList.add(tmpSelectItem);
		}
		
		semrrt022Bean.setDiffList(diffList);
		setSemrrt022Bean(semrrt022Bean);
	}
		
	@Override
	public boolean validate() {
		boolean flgValid = true;
		String msgError = null;
		if (StringUtils.isEmpty(getSemrrt022Bean().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		
		if (StringUtils.isEmpty(getSemrrt022Bean().getPreviousMonthFrom())) {
			addMessageError("W0001", msg("message.previousMonthFrom"));
			flgValid = false;
		}
		else {msgError = SemUtils.chkMonthYearFormat(getSemrrt022Bean().getPreviousMonthFrom());
			if (msgError!=null){
			addMessageError("W0102", msg("message.previousMonthFrom")+" ("+msg(msgError)+") ");
			flgValid = false;
			}
		}
		
		if (StringUtils.isEmpty(getSemrrt022Bean().getPreviousMonthTo())) {
			addMessageError("W0001", msg("message.previousMonthTo"));
			flgValid = false;
		}
		else {msgError = SemUtils.chkMonthYearFormat(getSemrrt022Bean().getPreviousMonthTo()); 
			if(msgError!=null){
			addMessageError("W0102", msg("message.previousMonthTo")+" ("+msg(msgError)+") ");
			flgValid = false;
			}
		}
		 
		if (StringUtils.isEmpty(getSemrrt022Bean().getCurrentMonthFrom())) {
			addMessageError("W0001", msg("message.currentMonthFrom"));
			flgValid = false;
		}
		else{msgError = SemUtils.chkMonthYearFormat(getSemrrt022Bean().getCurrentMonthFrom());
			if(msgError!=null){
			addMessageError("W0102", msg("message.currentMonthFrom")+" ("+msg(msgError)+") ");
			flgValid = false;
			}
		}
				
		if (StringUtils.isEmpty(getSemrrt022Bean().getCurrentMonthTo())) {
			addMessageError("W0001", msg("message.currentMonthTo"));
			flgValid = false;
		}
		else {msgError = SemUtils.chkMonthYearFormat(getSemrrt022Bean().getCurrentMonthTo());
			if(msgError!=null){
			addMessageError("W0102", msg("message.currentMonthTo")+" ("+msg(msgError)+") ");
			flgValid = false;
			}
		} 
		
		if (StringUtils.isEmpty(getSemrrt022Bean().getExpenseType())) {
			addMessageError("W0001", msg("message.expenseType"));
			flgValid = false;
		}
		
		if(StringUtils.isNotEmpty(getSemrrt022Bean().getPreviousMonthFrom()) && StringUtils.isNotEmpty(getSemrrt022Bean().getPreviousMonthTo())){
			if(SemUtils.checkDateFromMoreThanDateTo(getSemrrt022Bean().getPreviousMonthFrom(), getSemrrt022Bean().getPreviousMonthTo())){
				addMessageErrorWithArgument("W0006" ,msg("message.previousMonthFrom"), msg("message.previousMonthTo"));
				flgValid = false;
			}
		}
		if(StringUtils.isNotEmpty(getSemrrt022Bean().getCurrentMonthFrom()) && StringUtils.isNotEmpty(getSemrrt022Bean().getCurrentMonthTo())){
			if(SemUtils.checkDateFromMoreThanDateTo(getSemrrt022Bean().getCurrentMonthFrom(), getSemrrt022Bean().getCurrentMonthTo())){
				addMessageErrorWithArgument("W0006" ,msg("message.currentMonthFrom"), msg("message.currentMonthTo"));
				flgValid = false;
			}
		}
		
		return flgValid;
	}
	

	@Override
	public void clearReport() {
		super.clearSessionBean();
		getSemrrt022Bean().clearReportSimple();
//		semrrt022Bean = new SEMRRT022Bean();
//		semrrt022Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
//		semrrt022Bean.setExpenseTypeList(getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name));
//		List<SelectItem> diffList = new ArrayList<SelectItem>();
//		
//		String[] messageStr = {msg("message.moreThan"),msg("message.lessThan")};
//		SelectItem tmpSelectItem;
//		for(int i=0;i<messageStr.length;i++){
//			tmpSelectItem = new SelectItem();
//			tmpSelectItem.setValue(messageStr[i]);
//			tmpSelectItem.setLabel(messageStr[i]);
//			diffList.add(tmpSelectItem);
//		}
//		
//		semrrt022Bean.setDiffList(diffList);
//		setSemrrt022Bean(semrrt022Bean);
		getSemrrt022Bean().setCompany(null);
		getSemrrt022Bean().setPreviousMonthFrom(null);
		getSemrrt022Bean().setPreviousMonthTo(null);
		getSemrrt022Bean().setCurrentMonthFrom(null);
		getSemrrt022Bean().setCurrentMonthTo(null);
		getSemrrt022Bean().setExpenseType(null);
		getSemrrt022Bean().setContractNo(null);
		getSemrrt022Bean().setPercentDiffAmt(0d);
		getSemrrt022Bean().setPercentDiffType(null);
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		super.enableBatchType("semrrt022Bean");
	}

	@Override
	public void resetReportDate() {
		super.resetReportDate("semrrt022Bean");
	}

	@Override
	public void runReport() {
		semrrt022Bean = getSemrrt022Bean();
		SEMRRT022ReportParameter param = null;
		List<SelectItem> s = null;
		System.out.println("-------------- Run Report -----------------");
		System.out.println("company :"+semrrt022Bean.getCompany());
		
		if (validate()) {
			try {
				param = new SEMRRT022ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrrt022Bean.getCompany()));
				param.setP_username(semrrt022Bean.getUserLogin());
				param.setP_company(getSemrrt022Bean().getCompany());
				if(StringUtils.isNotEmpty(getSemrrt022Bean().getPreviousMonthFrom())){
					param.setP_previousMonthFrom(SemUtils.convertMonthYearTH2MonthYearEN(getSemrrt022Bean().getPreviousMonthFrom()));
				}
				if(StringUtils.isNotEmpty(getSemrrt022Bean().getPreviousMonthTo())){
					param.setP_previousMonthTo(SemUtils.convertMonthYearTH2MonthYearEN(getSemrrt022Bean().getPreviousMonthTo()));
				}
				if(StringUtils.isNotEmpty(getSemrrt022Bean().getCurrentMonthFrom())){
					param.setP_currentMonthFrom(SemUtils.convertMonthYearTH2MonthYearEN(getSemrrt022Bean().getCurrentMonthFrom()));
				}
				if(StringUtils.isNotEmpty(getSemrrt022Bean().getCurrentMonthTo())){
					param.setP_currentMonthTo(SemUtils.convertMonthYearTH2MonthYearEN(getSemrrt022Bean().getCurrentMonthTo()));
				}
				param.setP_display_previousMonthFrom(getSemrrt022Bean().getPreviousMonthFrom());
				param.setP_display_previousMonthTo(getSemrrt022Bean().getPreviousMonthTo());
				param.setP_display_currentMonthFrom(getSemrrt022Bean().getCurrentMonthFrom());
				param.setP_display_currentMonthTo(getSemrrt022Bean().getCurrentMonthTo());
				if(StringUtils.isNotEmpty(getSemrrt022Bean().getExpenseType())){
					s = th.co.ais.web.util.WebUtil.getSelectItemByValue(getSemrrt022Bean().getExpenseType(), getSemrrt022Bean().getExpenseTypeList());
					if(s != null){
						param.setP_display_expenseType(s.get(0).getLabel());
					}
				}
				param.setP_expenseType(getSemrrt022Bean().getExpenseType());
				param.setP_contractNo(getSemrrt022Bean().getContractNo());
				param.setP_percentDiffType(getSemrrt022Bean().getPercentDiffType());
				param.setP_percentDiffAmt(getSemrrt022Bean().getPercentDiffAmt()+"");
				
				log.debug("param.getP_previousMonthFrom() = "+param.getP_previousMonthFrom());
				log.debug("param.setP_percentDiffType = "+param.getP_percentDiffType());
				super.runReport("SEMRRT022", param, 
						semrrt022Bean.getReportType(), semrrt022Bean.getRunType(), 
						semrrt022Bean.getBatchType(), semrrt022Bean.getJobSchedule());
			
			} catch (Exception e) {
				log.error("RUN REPORT ERROR IN " + getClass() +  " : " + e);
				e.printStackTrace();
			} finally{
//				param = null;
			}
		}
	}

	@Override
	public void showReport() {
		super.showReport("SEMRRT022", getSemrrt022Bean().getReportType());
	}

	public String getStringDate(int day, int month, int year,int aday, int amonth, int ayear,int bday, int bmonth, int byear){
		Calendar c = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		StringBuilder sb = new StringBuilder();
		c.setTime(new Date());
		c.set(c.DATE, day);
		c.set(c.MONTH, month);
		c.set(c.YEAR, year);
		
		c.add(c.YEAR, ayear);
		c.add(c.MONTH, amonth);
		c.add(c.DATE, aday);
		sb.append(df.format(c.getTime()));
		
		
		c.setTime(new Date());
		c.set(c.MONTH, month);
		c.set(c.YEAR, year);
		c.set(c.DATE, c.getActualMaximum(Calendar.DATE));
			
		c.add(c.YEAR, byear);
		c.add(c.MONTH, bmonth);
		c.add(c.DATE, bday);
		
		
		sb.append(" - ");
		sb.append(df.format(c.getTime()));
		
		return sb.toString();
	}
}
