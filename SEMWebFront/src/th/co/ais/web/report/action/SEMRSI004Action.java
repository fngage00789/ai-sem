package th.co.ais.web.report.action;

import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
//import org.jboss.remoting.transport.web.WebUtil;

import th.co.ais.rpt.parameter.SEMRSI004ReportParameter;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.util.ELovType;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMRSI004Bean;
import th.co.ais.web.report.util.ReportDateUtil;
import th.co.ais.web.util.SemUtils;

public class SEMRSI004Action extends AbstractReportAction {
	private static final long serialVersionUID = -7410440438777216616L;
	private Logger log = Logger.getLogger(getClass());
	private SEMRSI004Bean semrsi004Bean;

	public SEMRSI004Bean getSemrsi004Bean() {
		return (SEMRSI004Bean) getFacesUtils().getSessionMapValue(
				"semrsi004Bean");
	}

	public void setSemrsi004Bean(SEMRSI004Bean semrsi004Bean) {
		getFacesUtils().setSessionMapValue("semrsi004Bean", semrsi004Bean);
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

		semrsi004Bean = new SEMRSI004Bean();
		semrsi004Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semrsi004Bean.setYear(DateUtil.getCurrentYearTH());
		semrsi004Bean.setMonthList(ReportDateUtil.getDDLMonthTH());
		semrsi004Bean.setMonthFrom("01");
		semrsi004Bean.setMonthTo("12");
		setSemrsi004Bean(semrsi004Bean);
	}

	@Override
	public boolean validate() {
		boolean flgValid = true;

		if (StringUtils.isEmpty(getSemrsi004Bean().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		if (StringUtils.isEmpty(getSemrsi004Bean().getYear())) {
			addMessageError("W0001", msg("message.year"));
			flgValid = false;
		}else if(!SemUtils.chkYearTH(getSemrsi004Bean().getYear())){
			addMessageError("W0099",msg("message.year"));
			flgValid = false;
		}
		
		if (StringUtils.isEmpty(getSemrsi004Bean().getMonthFrom()) || 
			StringUtils.isEmpty(getSemrsi004Bean().getMonthTo())) {
			addMessageError("W0001", msg("message.month"));
			flgValid = false;
		}
		
		

		return flgValid;
	}

	@Override
	public void clearReport() {
		// TODO Auto-generated method stub
		super.clearSessionBean();
		getSemrsi004Bean().clearReportSimple();

		getSemrsi004Bean().setCompany(null);
		getSemrsi004Bean().setYear(DateUtil.getCurrentYearTH());
		getSemrsi004Bean().setMonthFrom(null);
		getSemrsi004Bean().setMonthTo(null);
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		// TODO Auto-generated method stub
		super.enableBatchType("semrsi001Bean");
	}

	@Override
	public void resetReportDate() {
		// TODO Auto-generated method stub
		super.resetReportDate("semrsi001Bean");
	}

	@Override
	public void runReport() {
		// TODO Auto-generated method stub
		semrsi004Bean = getSemrsi004Bean();
		SEMRSI004ReportParameter param = null;
		List<SelectItem> s = null;
		if (validate()) {
			try {
				param = new SEMRSI004ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrsi004Bean
						.getCompany()));
				param.setP_company(semrsi004Bean.getCompany());
				param.setP_year(DateUtil.convertYearTH2YearEN(semrsi004Bean.getYear()));
				param.setP_year_display(semrsi004Bean.getYear());
				param.setP_month_from(semrsi004Bean.getMonthFrom());
				param.setP_month_to(semrsi004Bean.getMonthTo());
				param.setP_username(getUserLogIn());
				
				
				if(StringUtils.isNotEmpty(semrsi004Bean.getMonthFrom())){
					s =  th.co.ais.web.util.WebUtil.getSelectItemByValue(semrsi004Bean.getMonthFrom(), semrsi004Bean.getMonthList());
					if(s != null){
						param.setP_month_from_display(s.get(0).getLabel());
					}
				}
				if(StringUtils.isNotEmpty(semrsi004Bean.getMonthTo())){
					s =  th.co.ais.web.util.WebUtil.getSelectItemByValue(semrsi004Bean.getMonthTo(), semrsi004Bean.getMonthList());
					if(s != null){
						param.setP_month_to_display(s.get(0).getLabel());
					}
				}
//				WebUtil.getContentType(param);
				super.runReport("SEMRSI004", param, semrsi004Bean
						.getReportType(), semrsi004Bean.getRunType(),
						semrsi004Bean.getBatchType(), semrsi004Bean
								.getJobSchedule());

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
		// TODO Auto-generated method stub
		super.showReport("SEMRSI004", getSemrsi004Bean().getReportType());
	}
}
