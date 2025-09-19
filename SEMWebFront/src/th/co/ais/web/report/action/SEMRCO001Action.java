package th.co.ais.web.report.action;

import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
//import org.jboss.remoting.transport.web.WebUtil;

import th.co.ais.rpt.parameter.SEMRCO001ReportParameter;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.util.ELovType;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMRCO001Bean;
import th.co.ais.web.report.util.ReportDateUtil;

public class SEMRCO001Action extends AbstractReportAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2349185671157648244L;
	private SEMRCO001Bean semrco001Bean;
	private Logger log = Logger.getLogger(getClass());
	public SEMRCO001Bean getSemrco001Bean() {
		return (SEMRCO001Bean) getFacesUtils().getSessionMapValue(
				"semrco001Bean");
	}

	public void setSemrco001Bean(SEMRCO001Bean semrco001Bean) {
		getFacesUtils().setSessionMapValue("semrco001Bean", semrco001Bean);
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
		
		SEMRCO001Bean semrco001Bean = new SEMRCO001Bean();

		semrco001Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semrco001Bean.setYear(DateUtil.getCurrentYearTH());
		semrco001Bean.setMonthList(ReportDateUtil.getDDLMonthTH());
		semrco001Bean.setRegionList(getRegionItems());

		setSemrco001Bean(semrco001Bean);

	}

	@Override
	public boolean validate() {
		boolean flgValid = true;

		if (StringUtils.isEmpty(getSemrco001Bean().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}

		if (StringUtils.isEmpty(getSemrco001Bean().getYear())) {
			addMessageError("W0001", msg("message.year"));
			flgValid = false;
		}

		return flgValid;
	}

	@Override
	public void clearReport() {
		super.clearSessionBean();
		getSemrco001Bean().clearReportSimple();
		
		getSemrco001Bean().setCompany(null);
		getSemrco001Bean().setYear(DateUtil.getCurrentYearTH());
		getSemrco001Bean().setRegion(null);
		getSemrco001Bean().setMonth(null);
		getSemrco001Bean().setPico(false);
		
		enableBatchType();
		
	}

	@Override
	public void enableBatchType() {
		// TODO Auto-generated method stub
		super.enableBatchType("semrco001Bean");
	}

	@Override
	public void resetReportDate() {
		// TODO Auto-generated method stub
		super.resetReportDate("semrco001Bean");
	}

	@Override
	public void runReport() {
		// TODO Auto-generated method stub
		semrco001Bean = getSemrco001Bean();
		SEMRCO001ReportParameter param = null;
		List<SelectItem> s = null;
		if (validate()) {
			try {
				param = new SEMRCO001ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrco001Bean.getCompany()));
				param.setP_company(semrco001Bean.getCompany());
				param.setP_year(DateUtil.convertYearTH2YearEN(semrco001Bean.getYear()));
				param.setP_display_year(semrco001Bean.getYear());
				param.setP_region_code(semrco001Bean.getRegion());
				param.setP_month(semrco001Bean.getMonth());
				if(StringUtils.isNotEmpty(semrco001Bean.getMonth())){
					s =  th.co.ais.web.util.WebUtil.getSelectItemByValue(semrco001Bean.getMonth(), semrco001Bean.getMonthList());
					if(s != null){
						param.setP_display_month(s.get(0).getLabel());
					}
				}
				param.setP_username(getUserLogIn());
				param.setP_pico(semrco001Bean.isPico()?"Y":"N");
//				WebUtil.getContentType(param);
				super.runReport("SEMRCO001", param, semrco001Bean
						.getReportType(), semrco001Bean.getRunType(),
						semrco001Bean.getBatchType(), semrco001Bean
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
		super.showReport("SEMRCO001", getSemrco001Bean().getReportType());
	}
}
