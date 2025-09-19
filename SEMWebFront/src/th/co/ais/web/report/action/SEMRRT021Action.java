package th.co.ais.web.report.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;


import th.co.ais.rpt.parameter.SEMRRT021ReportParameter;
import th.co.ais.util.ELovType;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMRRT021Bean;
import th.co.ais.web.util.SemUtils;

public class SEMRRT021Action extends AbstractReportAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2524424552117504744L;
	private Logger log = Logger.getLogger(getClass());
	private SEMRRT021Bean semrrt021Bean;
	
	public SEMRRT021Bean getSemrrt021Bean() {
		return (SEMRRT021Bean) getFacesUtils().getSessionMapValue("semrrt021Bean");
	}

	public void setSemrrt021Bean(SEMRRT021Bean semrrt021Bean) {
		getFacesUtils().setSessionMapValue("semrrt021Bean", semrrt021Bean);
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
		
		semrrt021Bean = new SEMRRT021Bean();
		semrrt021Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semrrt021Bean.setContractStatusList(getLovItemsByType(ELovType.T_SI_SITE_STATUS.name));
		setSemrrt021Bean(semrrt021Bean);
	}
		
	@Override
	public boolean validate() {
		boolean flgValid = true;
		String msgError = null;
		if (StringUtils.isEmpty(getSemrrt021Bean().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		if (StringUtils.isEmpty(getSemrrt021Bean().getMonthYear())) {
			addMessageError("W0001", msg("message.month"));
			flgValid = false;
		}
		msgError = SemUtils.chkMonthYearFormat(getSemrrt021Bean().getMonthYear());
		if(msgError!=null){
			addMessageError("W0102", msg("message.asof")+" ("+msg(msgError)+") ");
			flgValid = false;
		}
		
		
		return flgValid;
	}
	

	@Override
	public void clearReport() {
		super.clearSessionBean();
		getSemrrt021Bean().clearReportSimple();
		
		getSemrrt021Bean().setCompany(null);
		getSemrrt021Bean().setRegion(null);
		getSemrrt021Bean().setMonthYear(null);
		getSemrrt021Bean().setContractNo(null);
		getSemrrt021Bean().setContractStatus(null);
		getSemrrt021Bean().setCheckDiff1(false);
		getSemrrt021Bean().setCheckDiff2(false);
		getSemrrt021Bean().setDiff1(null);
		getSemrrt021Bean().setDiff2(null);
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		super.enableBatchType("semrrt021Bean");
	}

	@Override
	public void resetReportDate() {
		super.resetReportDate("semrrt021Bean");
	}

	@Override
	public void runReport() {
		semrrt021Bean = getSemrrt021Bean();
		SEMRRT021ReportParameter param = null;
		
		System.out.println("-------------- Run Report -----------------");
		System.out.println("company :"+semrrt021Bean.getCompany());
		
		if (validate()) {
			try {
				param = new SEMRRT021ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrrt021Bean.getCompany()));
				//param.setP_username(semrrt021Bean.getUserLogin());
				param.setP_company(semrrt021Bean.getCompany());
				if(StringUtils.isNotEmpty(getSemrrt021Bean().getMonthYear())){
					param.setP_month_year(SemUtils.convertMonthYearTH2MonthYearEN(semrrt021Bean.getMonthYear()));
				}
				param.setP_display_month_year(semrrt021Bean.getMonthYear());
				param.setP_region(semrrt021Bean.getRegion());
				param.setP_contractNo(semrrt021Bean.getContractNo());
				param.setP_contractStatus(semrrt021Bean.getContractStatus());
				param.setP_diffType1(semrrt021Bean.getDiff1());
				param.setP_diffType2(semrrt021Bean.getDiff2());
				param.setP_username(getUserLogIn());
				
				super.runReport("SEMRRT021", param, 
						semrrt021Bean.getReportType(), semrrt021Bean.getRunType(), 
						semrrt021Bean.getBatchType(), semrrt021Bean.getJobSchedule());
			
			} catch (Exception e) {
				log.error("RUN REPORT ERROR IN " + getClass() +  " : " + e);
				e.printStackTrace();
			} finally{
				param = null;
			}
		}
	}

	@Override
	public void showReport() {
		super.showReport("SEMRRT021", getSemrrt021Bean().getReportType());
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
