package th.co.ais.web.report.action;
import java.util.List;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
//import org.jboss.remoting.transport.web.WebUtil;

import th.co.ais.rpt.parameter.SEMRSI010ReportParameter;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.util.ELovType;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMRSI010Bean;
import th.co.ais.web.util.SemUtils;

public class SEMRSI010Action extends AbstractReportAction {
	private static final long serialVersionUID = -7410440438777216616L;
	private Logger log = Logger.getLogger(getClass());
	private SEMRSI010Bean semrsi010Bean;

	public SEMRSI010Bean getSemrsi010Bean() {
		return (SEMRSI010Bean) getFacesUtils().getSessionMapValue(
				"semrsi010Bean");
	}

	public void setSemrsi010Bean(SEMRSI010Bean semrsi010Bean) {
		getFacesUtils().setSessionMapValue("semrsi010Bean", semrsi010Bean);
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

		semrsi010Bean = new SEMRSI010Bean();
		semrsi010Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semrsi010Bean.setSiteList(getLovItemsByType(ELovType.T_SI_SITE_TYPE.name));
		semrsi010Bean.setYear(DateUtil.getCurrentYearTH());
		semrsi010Bean.setCalType("01");
		setSemrsi010Bean(semrsi010Bean);
	}

	@Override
	public boolean validate() {
		boolean flgValid = true;

		if (StringUtils.isEmpty(getSemrsi010Bean().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		
		if (StringUtils.isEmpty(getSemrsi010Bean().getYear())) {
			addMessageError("W0001", msg("message.year"));
			flgValid = false;
		}else if(!SemUtils.chkYearTH(getSemrsi010Bean().getYear())){
			addMessageError("W0099",msg("message.year"));
			flgValid = false;
		}
		
		return flgValid;
	}

	@Override
	public void clearReport() {
		// TODO Auto-generated method stub
		super.clearSessionBean();
		getSemrsi010Bean().clearReportSimple();
		
		getSemrsi010Bean().setCompany(null);
		getSemrsi010Bean().setYear(DateUtil.getCurrentYearTH());
		getSemrsi010Bean().setCalType("T_STATION");
		getSemrsi010Bean().setSiteType(null);
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		// TODO Auto-generated method stub
		super.enableBatchType("semrsi010Bean");
	}

	@Override
	public void resetReportDate() {
		// TODO Auto-generated method stub
		super.resetReportDate("semrsi010Bean");
	}

	@Override
	public void runReport() {
		
		// TODO Auto-generated method stub
		semrsi010Bean = getSemrsi010Bean();
		SEMRSI010ReportParameter param = null;
		List<SelectItem> s = null;
	
		if (validate()) {
			try {
				param = new SEMRSI010ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrsi010Bean
						.getCompany()));
				param.setP_company(semrsi010Bean.getCompany());
				param.setP_cal_type(semrsi010Bean.getCalType());
								
				param.setP_site_type(semrsi010Bean.getSiteType());
				if (StringUtils.isNotEmpty(semrsi010Bean.getSiteType())) {
					s = th.co.ais.web.util.WebUtil.getSelectItemByValue(
							semrsi010Bean.getSiteType(), semrsi010Bean.getSiteList());
					if (s != null) {
						param.setP_display_site_type(s.get(0).getLabel());
					}
				}
				
				
				//Edit ddlYear to text box
				param.setP_year(DateUtil.convertYearTH2YearEN(semrsi010Bean.getYear()));
				param.setP_display_year(semrsi010Bean.getYear());
				param.setP_username(getUserLogIn());
				
//				WebUtil.getContentType(param);
				super.runReport("SEMRSI010", param, semrsi010Bean
						.getReportType(), semrsi010Bean.getRunType(),
						semrsi010Bean.getBatchType(), semrsi010Bean
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
		super.showReport("SEMRSI010", getSemrsi010Bean().getReportType());
	}
}
