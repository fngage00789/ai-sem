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


import th.co.ais.rpt.parameter.SEMRRT020ReportParameter;
import th.co.ais.util.ELovType;
import th.co.ais.util.EParamName;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMRRT020Bean;
import th.co.ais.web.util.ParameterCacheUtil;
import th.co.ais.web.util.SemUtils;

public class SEMRRT020Action extends AbstractReportAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2524424552117504744L;
	private Logger log = Logger.getLogger(getClass());
	private SEMRRT020Bean semrrt020Bean;
	
	public SEMRRT020Bean getSemrrt020Bean() {
		return (SEMRRT020Bean) getFacesUtils().getSessionMapValue("semrrt020Bean");
	}

	public void setSemrrt020Bean(SEMRRT020Bean semrrt020Bean) {
		getFacesUtils().setSessionMapValue("semrrt020Bean", semrrt020Bean);
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

	@Override
	public void init() {
		super.clearSessionBean();
		
		semrrt020Bean = new SEMRRT020Bean();
		semrrt020Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		
		List<SelectItem> tmpMasterGroup = ParameterCacheUtil.getInstance().getParamItemsByParamName(EParamName.P_REP_DUP_MASTER_DATA.name);
		for(int i=0;i<tmpMasterGroup.size();i++){
			SelectItem tmp = tmpMasterGroup.get(i);
			if(tmp !=null && StringUtils.isBlank(tmp.getValue().toString())){
				tmpMasterGroup.remove(i);
			}
		}
		
		semrrt020Bean.setMasterGroupList(tmpMasterGroup);
		
		setSemrrt020Bean(semrrt020Bean);
	}
		
	@Override
	public boolean validate() {
		boolean flgValid = true;
		String msgError = null;
		if (StringUtils.isEmpty(getSemrrt020Bean().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		
		if (StringUtils.isEmpty(getSemrrt020Bean().getMonthYear())) {
			addMessageError("W0001", msg("message.monthYearThLbl"));
			flgValid = false;
		}else {
			msgError = SemUtils.chkMonthYearFormat(getSemrrt020Bean().getMonthYear());
			if(msgError!=null){
				addMessageError("W0102", msg("message.monthYearThLbl")+" ("+msg(msgError)+") ");
				flgValid = false;
			}
		}
		if (null == getSemrrt020Bean().getMasterGroup() || getSemrrt020Bean().getMasterGroup().length == 0) {
			addMessageError("W0001", msg("message.masterGroup"));
			flgValid = false;
		}
		
		
		return flgValid;
	}
	

	@Override
	public void clearReport() {
		super.clearSessionBean();
		getSemrrt020Bean().clearReportSimple();
//		semrrt020Bean = new SEMRRT020Bean();
//		semrrt020Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
//		List<SelectItem> diffList = new ArrayList<SelectItem>();
//		String[] messageStr = {msg("message.moreThan"),msg("message.lessThan")};
//		SelectItem tmpSelectItem;
//		for(int i=0;i<messageStr.length;i++){
//			tmpSelectItem = new SelectItem();
//			tmpSelectItem.setValue(messageStr[i]);
//			tmpSelectItem.setLabel(messageStr[i]);
//			diffList.add(tmpSelectItem);
//		}
//		semrrt020Bean.setMasterGroupList(ParameterCacheUtil.getInstance().getParamItemsByParamName(EParamName.P_REP_DUP_MASTER_DATA.name));
//		
//		setSemrrt020Bean(semrrt020Bean);
		
		getSemrrt020Bean().setCompany(null);
		getSemrrt020Bean().setMonthYear(null);
		getSemrrt020Bean().setMasterGroup(null);
		
		
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		super.enableBatchType("semrrt020Bean");
	}

	@Override
	public void resetReportDate() {
		super.resetReportDate("semrrt020Bean");
	}

	@Override
	public void runReport() {
		semrrt020Bean = getSemrrt020Bean();
		SEMRRT020ReportParameter param = null;
		
		
		System.out.println("-------------- Run Report -----------------");
		System.out.println("company :"+semrrt020Bean.getCompany());
		
		if (validate()) {
			try {
				
				
				param = new SEMRRT020ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrrt020Bean.getCompany()));
				param.setP_company(getSemrrt020Bean().getCompany());
				param.setP_username(getUserLogIn());
				if(StringUtils.isNotEmpty(getSemrrt020Bean().getMonthYear())){
					param.setP_month_year(SemUtils.convertMonthYearTH2MonthYearEN(getSemrrt020Bean().getMonthYear()));
				}
				param.setP_display_month_year(getSemrrt020Bean().getMonthYear());
				param.setP_master_group(mergArrayByComma(getSemrrt020Bean().getMasterGroup()));
				
				//Set Sheet Name
				
				
				String[] tmp;
				String[] sheetName;
				if(!StringUtils.isEmpty(param.getP_master_group())){
					tmp = param.getP_master_group().split(",");
					log.debug("tmp = "+tmp);
					
					if(tmp.length>0){
						sheetName = new String[8];
					for (int i = 0; i<tmp.length;i++  ){
						if ("VEN_NAME".equals(tmp[i])){
						sheetName[i] = "Vendor Name";
						}
						if ("VEN_CODE".equals(tmp[i])){
							sheetName[i] = "Vendor Code";
							}
						if ("VEN_BOOK".equals(tmp[i])){
							sheetName[i] = "Vendor Book Bank";
							}
						if ("PAYEE".equals(tmp[i])){
							sheetName[i] = "Payee Name";
							}
						if ("PAYEE_BOOK".equals(tmp[i])){
							sheetName[i] = "Payee Book Bank";
							}
						if ("LOCATION".equals(tmp[i])){
							sheetName[i] = "Location ID";
							}
						if ("PAYMENT".equals(tmp[i])){
							sheetName[i] = "Payment";
							}
						if ("CONTRACT".equals(tmp[i])){
							sheetName[i] = "Contract";
							}						
					}
					param.setP_sheet_name(sheetName);
					}
					
				}
					
					
					
					
					
					
					
//					if(tmp.length>6){
//						sheetName = new String[7];
//						sheetName[0] = "BG";
//						sheetName[1] = "Cash";
//					}else{
//						sheetName = new String[tmp.length];
//						for (int i=0; <tmp.length;)
//						
//						
//						
//						if("VEN_CODE".equals(tmp[0]))
//							sheetName[0] = "Vendor Code";
//						else
//							sheetName[0] = "Cash";
//					}
					
//					
					
				
				
				
				
				
				super.runReport("SEMRRT020", param, 
						semrrt020Bean.getReportType(), semrrt020Bean.getRunType(), 
						semrrt020Bean.getBatchType(), semrrt020Bean.getJobSchedule());
			
			} catch (Exception e) {
				log.error("RUN REPORT ERROR IN " + getClass() +  " : " + e);
				e.printStackTrace();
			} finally{
//				param = null;
			}
		}
	}
	
	private String mergArrayByComma(String[] array){
		
		if(array == null || array.length==0){
			return "";
		}
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<array.length;i++){
			sb.append(array[i]);
			if(i<array.length-1){
				sb.append(",");
			}
		}
		
		return sb.toString();
		
	}

	@Override
	public void showReport() {
		super.showReport("SEMRRT020", getSemrrt020Bean().getReportType());
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
