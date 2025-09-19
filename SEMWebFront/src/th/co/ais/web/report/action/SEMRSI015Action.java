package th.co.ais.web.report.action;

import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
//import org.jboss.remoting.transport.web.WebUtil;

import th.co.ais.rpt.parameter.SEMRSI015ReportParameter;
import th.co.ais.rpt.parameter.SEMRSI016ReportParameter;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.util.ELovType;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMRSI015Bean;
import th.co.ais.web.report.util.ReportDateUtil;
import th.co.ais.web.util.SemUtils;

public class SEMRSI015Action extends AbstractReportAction {
	private static final long serialVersionUID = -7410440438777216616L;
	private Logger log = Logger.getLogger(getClass());
	private SEMRSI015Bean semrsi015Bean;

	public SEMRSI015Bean getSemrsi015Bean() {
		return (SEMRSI015Bean) getFacesUtils().getSessionMapValue(
				"semrsi015Bean");
	}

	public void setSemrsi015Bean(SEMRSI015Bean semrsi015Bean) {
		getFacesUtils().setSessionMapValue("semrsi015Bean", semrsi015Bean);
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

		semrsi015Bean = new SEMRSI015Bean();
		semrsi015Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semrsi015Bean.setRegionList(getRegionItems());
		semrsi015Bean.setMonthList(ReportDateUtil.getDDLMonthTH());
		semrsi015Bean.setYear(DateUtil.getCurrentYearTH());
		semrsi015Bean.setSiteTypeList(getLovItemsByType(ELovType.T_SI_SITE_TYPE.name));
		semrsi015Bean.setReportSummaryFlag(true);
		setSemrsi015Bean(semrsi015Bean);
	}

	@Override
	public boolean validate() {
		boolean flgValid = true;

		if (StringUtils.isEmpty(getSemrsi015Bean().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		if (StringUtils.isEmpty(getSemrsi015Bean().getYear())) {
			addMessageError("W0001", msg("message.year"));
			flgValid = false;
		} else if (!SemUtils.chkYearTH(getSemrsi015Bean().getYear())) {
			addMessageError("W0099", msg("message.year"));
			flgValid = false;
		}

		return flgValid;
	}

	@Override
	public void clearReport() {
		// TODO Auto-generated method stub
		super.clearSessionBean();
		getSemrsi015Bean().clearReportSimple();
		
		getSemrsi015Bean().setCompany(null);
		getSemrsi015Bean().setYear(DateUtil.getCurrentYearTH());
		getSemrsi015Bean().setReportSummaryFlag(true);
		getSemrsi015Bean().setRegion(null);
		getSemrsi015Bean().setMonth(null);
		getSemrsi015Bean().setSiteType(null);

		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		// TODO Auto-generated method stub
		super.enableBatchType("semrsi015Bean");
	}

	@Override
	public void resetReportDate() {
		// TODO Auto-generated method stub
		super.resetReportDate("semrsi015Bean");
	}

	@Override
	public void runReport() {
		// TODO Auto-generated method stub
		semrsi015Bean = getSemrsi015Bean();
		List<SelectItem> s = null;
		List<SelectItem> st = null;
		if (validate()) {
			try {
				
					if(getSemrsi015Bean().isReportSummaryFlag()){
						SEMRSI015ReportParameter param = new SEMRSI015ReportParameter();
						param.setP_header_name(getCompanyHeaderName(semrsi015Bean
								.getCompany()));
						param.setP_company(semrsi015Bean.getCompany());
						param.setP_year(DateUtil.convertYearTH2YearEN(semrsi015Bean
								.getYear())
								);
						param.setP_display_year(semrsi015Bean.getYear());

						param.setP_month(semrsi015Bean.getMonth());
						if (StringUtils.isNotEmpty(semrsi015Bean.getMonth())) {
							s = th.co.ais.web.util.WebUtil.getSelectItemByValue(
									semrsi015Bean.getMonth(), semrsi015Bean
											.getMonthList());
							if (s != null) {
								param.setP_display_month(s.get(0).getLabel());
							}
						}
						param.setP_region_code(semrsi015Bean.getRegion());
						param.setP_site_type(semrsi015Bean.getSiteType());
						if(StringUtils.isNotEmpty(semrsi015Bean.getSiteType())){
							st =  th.co.ais.web.util.WebUtil.getSelectItemByValue(semrsi015Bean.getSiteType(), semrsi015Bean.getSiteTypeList());
							if(st != null){
								param.setP_display_site_type(st.get(0).getLabel());
							}
						}
						param.setP_username(getUserLogIn());
//						WebUtil.getContentType(param);
						super.runReport("SEMRSI015", param, semrsi015Bean
								.getReportType(), semrsi015Bean.getRunType(),
								semrsi015Bean.getBatchType(), semrsi015Bean
										.getJobSchedule());
					}else{
						SEMRSI016ReportParameter param = new SEMRSI016ReportParameter();
						param.setP_header_name(getCompanyHeaderName(semrsi015Bean
								.getCompany()));
						param.setP_company(semrsi015Bean.getCompany());
						param.setP_year(DateUtil.convertYearTH2YearEN(semrsi015Bean
								.getYear())
								);
						param.setP_display_year(semrsi015Bean.getYear());
						param.setP_username(getUserLogIn());
						param.setP_month(semrsi015Bean.getMonth());
						if (StringUtils.isNotEmpty(semrsi015Bean.getMonth())) {
							s = th.co.ais.web.util.WebUtil.getSelectItemByValue(
									semrsi015Bean.getMonth(), semrsi015Bean
											.getMonthList());
							if (s != null) {
								param.setP_display_month(s.get(0).getLabel());
							}
						}
						param.setP_region_code(semrsi015Bean.getRegion());
						param.setP_site_type(semrsi015Bean.getSiteType());
						if(StringUtils.isNotEmpty(semrsi015Bean.getSiteType())){
							st =  th.co.ais.web.util.WebUtil.getSelectItemByValue(semrsi015Bean.getSiteType(), semrsi015Bean.getSiteTypeList());
							if(st != null){
								param.setP_display_site_type(st.get(0).getLabel());
							}
						}
//						WebUtil.getContentType(param);
						super.runReport("SEMRSI016", param, semrsi015Bean
								.getReportType(), semrsi015Bean.getRunType(),
								semrsi015Bean.getBatchType(), semrsi015Bean
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
			
			if(getSemrsi015Bean().isReportSummaryFlag()){
				super.showReport("SEMRSI015", getSemrsi015Bean().getReportType());
			}else{
				super.showReport("SEMRSI016", getSemrsi015Bean().getReportType());
			}
	}
}
