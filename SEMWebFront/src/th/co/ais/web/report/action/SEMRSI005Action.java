package th.co.ais.web.report.action;

import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
//import org.jboss.remoting.transport.web.WebUtil;

import th.co.ais.rpt.parameter.SEMRSI005ReportParameter;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.util.ELovType;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMRSI005Bean;
import th.co.ais.web.report.util.ReportDateUtil;
import th.co.ais.web.util.SemUtils;

public class SEMRSI005Action extends AbstractReportAction {
	private static final long serialVersionUID = -7410440438777216616L;
	private Logger log = Logger.getLogger(getClass());
	private SEMRSI005Bean semrsi005Bean;
	
	public SEMRSI005Bean getSemrsi005Bean() {
		return (SEMRSI005Bean)getFacesUtils().getSessionMapValue("semrsi005Bean");
	}

	public void setSemrsi005Bean(SEMRSI005Bean semrsi005Bean) {
		getFacesUtils().setSessionMapValue("semrsi005Bean", semrsi005Bean);
	}

	@Override
	public void clearReport() {
		super.clearSessionBean();
		getSemrsi005Bean().clearReportSimple();
		
		getSemrsi005Bean().setCompany(null);
		getSemrsi005Bean().setYear(DateUtil.getCurrentYearTH());
		getSemrsi005Bean().setFromMonth(null);
		getSemrsi005Bean().setToMonth(null);
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		super.enableBatchType("semrsi005Bean");
	}

	@Override
	public void resetReportDate() {
		super.resetReportDate("semrsi005Bean");
	}

	@Override
	public void runReport() {
		semrsi005Bean = getSemrsi005Bean();
		SEMRSI005ReportParameter param = null;
		List<SelectItem> s = null;
		if (validate()) {
			try {
				param = new SEMRSI005ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrsi005Bean.getCompany()));
				param.setP_company(semrsi005Bean.getCompany());
				param.setP_year(DateUtil.convertYearTH2YearEN(semrsi005Bean.getYear()));
				param.setP_year_display(semrsi005Bean.getYear());
				param.setP_month_from(semrsi005Bean.getFromMonth());
				param.setP_month_to(semrsi005Bean.getToMonth());
				
				if(StringUtils.isNotEmpty(semrsi005Bean.getFromMonth())){
					s =  th.co.ais.web.util.WebUtil.getSelectItemByValue(semrsi005Bean.getFromMonth(), semrsi005Bean.getMonthList());
					if(s != null){
						param.setP_month_from_display(s.get(0).getLabel());
					}
				}
				if(StringUtils.isNotEmpty(semrsi005Bean.getToMonth())){
					s =  th.co.ais.web.util.WebUtil.getSelectItemByValue(semrsi005Bean.getToMonth(), semrsi005Bean.getMonthList());
					if(s != null){
						param.setP_month_to_display(s.get(0).getLabel());
					}
				}
				
				param.setP_username(getUserLogIn());
//				WebUtil.getContentType(param);
				super.runReport("SEMRSI005", param, semrsi005Bean.getReportType(), 
						semrsi005Bean.getRunType(), semrsi005Bean.getBatchType(), 
						semrsi005Bean.getJobSchedule());

			} catch (Exception e) {
				log.error("RUN REPORT ERROR IN " + getClass() + " : " + e);
				e.printStackTrace();
			} finally {
				param = null;
			}
		}
	}

	@Override
	public void showReport() {
		super.showReport("SEMRSI005", getSemrsi005Bean().getReportType());
	}

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		
		if (methodWithNavi.equalsIgnoreCase("doRunReport")) {
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		super.clearSessionBean();
		
		semrsi005Bean = new SEMRSI005Bean();
		semrsi005Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semrsi005Bean.setYear(DateUtil.getCurrentYearTH());
		semrsi005Bean.setMonthList(ReportDateUtil.getDDLMonthTH());
		semrsi005Bean.setFromMonth("01");
		semrsi005Bean.setToMonth("12");
		setSemrsi005Bean(semrsi005Bean);
	}

	@Override
	public boolean validate() {
		boolean flgValid = true;
		
		if (StringUtils.isEmpty(getSemrsi005Bean().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		
		if (StringUtils.isEmpty(getSemrsi005Bean().getYear())) {
			addMessageError("W0001", msg("message.year"));
			flgValid = false;
		}else if(!SemUtils.chkYearTH(getSemrsi005Bean().getYear())){
			addMessageError("W0099",msg("message.year"));
			flgValid = false;
		}
		
		if (StringUtils.isEmpty(getSemrsi005Bean().getFromMonth()) || 
				StringUtils.isEmpty(getSemrsi005Bean().getToMonth())) {
				addMessageError("W0001", msg("message.month"));
				flgValid = false;
		}
		
		return flgValid;
	}

	
}
