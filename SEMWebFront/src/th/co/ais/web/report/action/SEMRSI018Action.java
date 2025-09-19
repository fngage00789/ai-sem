package th.co.ais.web.report.action;

import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
//import org.jboss.remoting.transport.web.WebUtil;

import th.co.ais.rpt.parameter.SEMRSI018ReportParameter;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.util.ELovType;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMRSI018Bean;
import th.co.ais.web.util.SemUtils;

public class SEMRSI018Action extends AbstractReportAction {
	private static final long serialVersionUID = -7410440438777216616L;
	private Logger log = Logger.getLogger(getClass());
	private SEMRSI018Bean semrsi018Bean;

	public SEMRSI018Bean getSemrsi018Bean() {
		return (SEMRSI018Bean) getFacesUtils().getSessionMapValue(
				"semrsi018Bean");
	}

	public void setSemrsi018Bean(SEMRSI018Bean semrsi018Bean) {
		getFacesUtils().setSessionMapValue("semrsi018Bean", semrsi018Bean);
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

		semrsi018Bean = new SEMRSI018Bean();
		semrsi018Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semrsi018Bean.setRegionList(getRegionItems());
		semrsi018Bean.setYear(DateUtil.getCurrentYearTH());
		setSemrsi018Bean(semrsi018Bean);
	}

	@Override
	public boolean validate() {
		boolean flgValid = true;

		if (StringUtils.isEmpty(getSemrsi018Bean().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		if (StringUtils.isEmpty(getSemrsi018Bean().getYear())) {

		}else if(!SemUtils.chkYearTH(getSemrsi018Bean().getYear())){
			addMessageError("W0099",msg("message.year"));
			flgValid = false;
		}


		return flgValid;
	}

	@Override
	public void clearReport() {
		// TODO Auto-generated method stub
		super.clearSessionBean();
		getSemrsi018Bean().clearReportSimple();

		getSemrsi018Bean().setCompany(null);
		getSemrsi018Bean().setYear(DateUtil.getCurrentYearTH());
		getSemrsi018Bean().setRegion(null);

		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		// TODO Auto-generated method stub
		super.enableBatchType("semrsi018Bean");
	}

	@Override
	public void resetReportDate() {
		// TODO Auto-generated method stub
		super.resetReportDate("semrsi018Bean");
	}

	@Override
	public void runReport() {
		// TODO Auto-generated method stub
		semrsi018Bean = getSemrsi018Bean();
		SEMRSI018ReportParameter param = null;
		List<SelectItem> s = null;
		if (validate()) {
			try {
				param = new SEMRSI018ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrsi018Bean.getCompany()));
				param.setP_company(semrsi018Bean.getCompany());
				try {
					param.setP_year(DateUtil.convertYearTH2YearEN(semrsi018Bean.getYear()));
				} catch (NumberFormatException e) {
					param.setP_year(semrsi018Bean.getYear());
				}
				
				param.setP_year_display(semrsi018Bean.getYear());
				param.setP_region_code(semrsi018Bean.getRegion());
				param.setP_username(getUserLogIn());
//				WebUtil.getContentType(param);
				super.runReport("SEMRSI018", param, semrsi018Bean
						.getReportType(), semrsi018Bean.getRunType(),
						semrsi018Bean.getBatchType(), semrsi018Bean
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
		super.showReport("SEMRSI018", getSemrsi018Bean().getReportType());
	}
}
