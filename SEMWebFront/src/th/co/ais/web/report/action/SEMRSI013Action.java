package th.co.ais.web.report.action;

import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
//import org.jboss.remoting.transport.web.WebUtil;

import th.co.ais.rpt.parameter.SEMRSI013ReportParameter;
import th.co.ais.rpt.parameter.SEMRSI014ReportParameter;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.util.ELovType;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMRSI013Bean;
import th.co.ais.web.report.util.ReportDateUtil;
import th.co.ais.web.util.SemUtils;

public class SEMRSI013Action extends AbstractReportAction {
	private static final long serialVersionUID = -7410440438777216616L;
	private Logger log = Logger.getLogger(getClass());
	private SEMRSI013Bean semrsi013Bean;

	public SEMRSI013Bean getSemrsi013Bean() {
		return (SEMRSI013Bean) getFacesUtils().getSessionMapValue(
				"semrsi013Bean");
	}

	public void setSemrsi013Bean(SEMRSI013Bean semrsi013Bean) {
		getFacesUtils().setSessionMapValue("semrsi013Bean", semrsi013Bean);
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

		semrsi013Bean = new SEMRSI013Bean();
		semrsi013Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semrsi013Bean.setRegionList(getRegionItems());
		semrsi013Bean.setYear(DateUtil.getCurrentYearTH());
		semrsi013Bean.setMonthList(ReportDateUtil.getDDLMonthTH());
		semrsi013Bean.setSiteTypeList(getLovItemsByType(ELovType.T_SI_SITE_TYPE.name));
		semrsi013Bean.setReportSummaryFlag(true);
		setSemrsi013Bean(semrsi013Bean);
	}

	@Override
	public boolean validate() {
		boolean flgValid = true;

		if (StringUtils.isEmpty(getSemrsi013Bean().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		if (StringUtils.isEmpty(getSemrsi013Bean().getYear())) {
			addMessageError("W0001", msg("message.year"));
			flgValid = false;
		}else if(!SemUtils.chkYearTH(getSemrsi013Bean().getYear())){
			addMessageError("W0099",msg("message.year"));
			flgValid = false;
		}

		return flgValid;
	}

	@Override
	public void clearReport() {
		// TODO Auto-generated method stub
		super.clearSessionBean();
		getSemrsi013Bean().clearReportSimple();
		
		getSemrsi013Bean().setCompany(null);
		getSemrsi013Bean().setReportSummaryFlag(true);
		getSemrsi013Bean().setYear(DateUtil.getCurrentYearTH());
		getSemrsi013Bean().setRegion(null);
		getSemrsi013Bean().setMonth(null);
		getSemrsi013Bean().setSiteType(null);

		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		// TODO Auto-generated method stub
		super.enableBatchType("semrsi013Bean");
	}

	@Override
	public void resetReportDate() {
		// TODO Auto-generated method stub
		super.resetReportDate("semrsi013Bean");
	}

	@Override
	public void runReport() {
		// TODO Auto-generated method stub
		semrsi013Bean = getSemrsi013Bean();
		
		
		List<SelectItem> s = null;
		List<SelectItem> st = null;
		if (validate()) {
			try {
				
				if(semrsi013Bean.isReportSummaryFlag()){
					
					SEMRSI013ReportParameter param = new SEMRSI013ReportParameter();
					param.setP_header_name(getCompanyHeaderName(semrsi013Bean.getCompany()));
					param.setP_company(semrsi013Bean.getCompany());
					param.setP_year(DateUtil.convertYearTH2YearEN(semrsi013Bean.getYear()));
					param.setP_year_display(semrsi013Bean.getYear());
					
					param.setP_username(getUserLogIn());
					param.setP_month(semrsi013Bean.getMonth());
					if(StringUtils.isNotEmpty(semrsi013Bean.getMonth())){
						s =  th.co.ais.web.util.WebUtil.getSelectItemByValue(semrsi013Bean.getMonth(), semrsi013Bean.getMonthList());
						if(s != null){
							param.setP_month_display(s.get(0).getLabel());
						}
					}
					param.setP_region_code(semrsi013Bean.getRegion());
					param.setP_site_type(semrsi013Bean.getSiteType());
					if(StringUtils.isNotEmpty(semrsi013Bean.getSiteType())){
						st =  th.co.ais.web.util.WebUtil.getSelectItemByValue(semrsi013Bean.getSiteType(), semrsi013Bean.getSiteTypeList());
						if(st != null){
							param.setP_display_site_type(st.get(0).getLabel());
						}
					}
//					WebUtil.getContentType(param);
					super.runReport("SEMRSI013", param, semrsi013Bean
							.getReportType(), semrsi013Bean.getRunType(),
							semrsi013Bean.getBatchType(), semrsi013Bean
									.getJobSchedule());
					
				}else{
					SEMRSI014ReportParameter param = new SEMRSI014ReportParameter();
					param.setP_header_name(getCompanyHeaderName(semrsi013Bean.getCompany()));
					param.setP_company(semrsi013Bean.getCompany());
					param.setP_year(DateUtil.convertYearTH2YearEN(semrsi013Bean.getYear()));
					param.setP_year_display(semrsi013Bean.getYear());
					param.setP_username(getUserLogIn());
					param.setP_month(semrsi013Bean.getMonth());
					if(StringUtils.isNotEmpty(semrsi013Bean.getMonth())){
						s =  th.co.ais.web.util.WebUtil.getSelectItemByValue(semrsi013Bean.getMonthList(), semrsi013Bean.getMonthList());
						if(s != null){
							param.setP_month_display(s.get(0).getLabel());
						}
					}
					param.setP_region_code(semrsi013Bean.getRegion());
					param.setP_site_type(semrsi013Bean.getSiteType());
					if(StringUtils.isNotEmpty(semrsi013Bean.getSiteType())){
						st =  th.co.ais.web.util.WebUtil.getSelectItemByValue(semrsi013Bean.getSiteType(), semrsi013Bean.getSiteTypeList());
						if(st != null){
							param.setP_display_site_type(st.get(0).getLabel());
						}
					}
					
//					WebUtil.getContentType(param);
					super.runReport("SEMRSI014", param, semrsi013Bean
							.getReportType(), semrsi013Bean.getRunType(),
							semrsi013Bean.getBatchType(), semrsi013Bean
									.getJobSchedule());
				}
				

			} catch (Exception e) {
				log.error("RUN REPORT ERROR IN " + getClass() + " : " + e);
				e.printStackTrace();
			} 
		}
	}

	@Override
	public void showReport() {
		// TODO Auto-generated method stub
		
		if(getSemrsi013Bean().isReportSummaryFlag()){
			super.showReport("SEMRSI013", getSemrsi013Bean().getReportType());
		}else{
			super.showReport("SEMRSI014", getSemrsi013Bean().getReportType());
		}
	}
}
