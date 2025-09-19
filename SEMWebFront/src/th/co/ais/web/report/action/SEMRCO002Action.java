package th.co.ais.web.report.action;

import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
//import org.jboss.remoting.transport.web.WebUtil;

import th.co.ais.rpt.parameter.SEMRCO002ReportParameter;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.util.ELovType;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMRCO002Bean;

public class SEMRCO002Action extends AbstractReportAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2349185671157648244L;
	private SEMRCO002Bean semrco002Bean;
	private Logger log = Logger.getLogger(getClass());
	public SEMRCO002Bean getSemrco002Bean() {
		return (SEMRCO002Bean) getFacesUtils().getSessionMapValue(
				"semrco002Bean");
	}

	public void setSemrco002Bean(SEMRCO002Bean semrco002Bean) {
		getFacesUtils().setSessionMapValue("semrco002Bean", semrco002Bean);
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
		
		SEMRCO002Bean semrco002Bean = new SEMRCO002Bean();

		semrco002Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semrco002Bean.setYear(DateUtil.getCurrentYearTH());
		semrco002Bean.setRegionList(getRegionItems());

		setSemrco002Bean(semrco002Bean);

	}

	@Override
	public boolean validate() {
		boolean flgValid = true;

		if (StringUtils.isEmpty(getSemrco002Bean().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}

		if (StringUtils.isEmpty(getSemrco002Bean().getYear())) {
			addMessageError("W0001", msg("message.year"));
			flgValid = false;
		}

		return flgValid;
	}

	@Override
	public void clearReport() {
		super.clearSessionBean();
		getSemrco002Bean().clearReportSimple();
		
		getSemrco002Bean().setCompany(null);
		getSemrco002Bean().setYear(DateUtil.getCurrentYearTH());
		getSemrco002Bean().setRegion(null);
		getSemrco002Bean().setPico(false);
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		// TODO Auto-generated method stub
		super.enableBatchType("semrco002Bean");
	}

	@Override
	public void resetReportDate() {
		// TODO Auto-generated method stub
		super.resetReportDate("semrco002Bean");
	}

	@Override
	public void runReport() {
		// TODO Auto-generated method stub
		semrco002Bean = getSemrco002Bean();
		SEMRCO002ReportParameter param = null;
		List<SelectItem> s = null;
		if (validate()) {
			try {
				param = new SEMRCO002ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrco002Bean.getCompany()));
				param.setP_company(semrco002Bean.getCompany());
				param.setP_year(DateUtil.convertYearTH2YearEN(semrco002Bean.getYear()));
				param.setP_display_year(semrco002Bean.getYear());
				param.setP_pico(semrco002Bean.isPico()?"Y":"N");
				param.setP_region_code(semrco002Bean.getRegion());
				param.setP_username(getUserLogIn());
//				WebUtil.getContentType(param);
				super.runReport("SEMRCO002", param, semrco002Bean
						.getReportType(), semrco002Bean.getRunType(),
						semrco002Bean.getBatchType(), semrco002Bean
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
		super.showReport("SEMRCO002", getSemrco002Bean().getReportType());
	}
}
