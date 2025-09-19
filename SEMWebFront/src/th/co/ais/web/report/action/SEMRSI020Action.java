package th.co.ais.web.report.action;

import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
//import org.jboss.remoting.transport.web.WebUtil;

import th.co.ais.rpt.parameter.SEMRSI020ReportParameter;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.util.ELovType;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMRSI020Bean;
import th.co.ais.web.report.util.ReportDateUtil;
import th.co.ais.web.util.SemUtils;

public class SEMRSI020Action extends AbstractReportAction {
	private static final long serialVersionUID = -7410440438777216616L;
	private Logger log = Logger.getLogger(getClass());
	private SEMRSI020Bean semrsi020Bean;

	public SEMRSI020Bean getSemrsi020Bean() {
		return (SEMRSI020Bean) getFacesUtils().getSessionMapValue(
				"semrsi020Bean");
	}

	public void setSemrsi020Bean(SEMRSI020Bean semrsi020Bean) {
		getFacesUtils().setSessionMapValue("semrsi020Bean", semrsi020Bean);
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

		semrsi020Bean = new SEMRSI020Bean();
		semrsi020Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semrsi020Bean.setRegionList(getRegionItems());
		semrsi020Bean.setMonthList(ReportDateUtil.getDDLMonthTH());
		semrsi020Bean.setYear(DateUtil.getCurrentYearTH());
		setSemrsi020Bean(semrsi020Bean);
	}

	@Override
	public boolean validate() {
		boolean flgValid = true;

		if (StringUtils.isEmpty(getSemrsi020Bean().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		if (StringUtils.isEmpty(getSemrsi020Bean().getYear())) {
			addMessageError("W0001", msg("message.year"));
			flgValid = false;
		}else if(!SemUtils.chkYearTH(getSemrsi020Bean().getYear())){
			addMessageError("W0099", msg("message.year"));
			flgValid = false;
		}

		return flgValid;
	}

	@Override
	public void clearReport() {
		// TODO Auto-generated method stub
		super.clearSessionBean();
		getSemrsi020Bean().clearReportSimple();
		
		getSemrsi020Bean().setCompany(null);
		getSemrsi020Bean().setYear(DateUtil.getCurrentYearTH());
		getSemrsi020Bean().setRegion(null);
		getSemrsi020Bean().setMonth(null);

		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		// TODO Auto-generated method stub
		super.enableBatchType("semrsi020Bean");
	}

	@Override
	public void resetReportDate() {
		// TODO Auto-generated method stub
		super.resetReportDate("semrsi020Bean");
	}

	@Override
	public void runReport() {
		// TODO Auto-generated method stub
		semrsi020Bean = getSemrsi020Bean();
		SEMRSI020ReportParameter param = null;
		List<SelectItem> s = null;
		if (validate()) {
			try {
				param = new SEMRSI020ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrsi020Bean.getCompany()));
				param.setP_company(semrsi020Bean.getCompany());
				param.setP_year(DateUtil.convertYearTH2YearEN(semrsi020Bean.getYear()));
				param.setP_display_year(semrsi020Bean.getYear());
				param.setP_region_code(semrsi020Bean.getRegion());
				if(StringUtils.isNotEmpty(semrsi020Bean.getMonth())){
					s =  th.co.ais.web.util.WebUtil.getSelectItemByValue(semrsi020Bean.getMonth(), semrsi020Bean.getMonthList());
					if(s != null){
						param.setP_display_month(s.get(0).getLabel());
					}
				}
				param.setP_username(getUserLogIn());
//				WebUtil.getContentType(param);
				super.runReport("SEMRSI020", param, semrsi020Bean
						.getReportType(), semrsi020Bean.getRunType(),
						semrsi020Bean.getBatchType(), semrsi020Bean
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
		super.showReport("SEMRSI020", getSemrsi020Bean().getReportType());
	}
}
