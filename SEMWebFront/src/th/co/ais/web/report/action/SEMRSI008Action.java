package th.co.ais.web.report.action;

import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
//import org.jboss.remoting.transport.web.WebUtil;

import th.co.ais.rpt.parameter.SEMRSI008ReportParameter;
import th.co.ais.util.ELovType;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMRSI008Bean;

public class SEMRSI008Action extends AbstractReportAction {
	private static final long serialVersionUID = -7410440438777216616L;
	private Logger log = Logger.getLogger(getClass());
	private SEMRSI008Bean semrsi008Bean;

	public SEMRSI008Bean getSemrsi008Bean() {
		return (SEMRSI008Bean) getFacesUtils().getSessionMapValue(
				"semrsi008Bean");
	}

	public void setSemrsi008Bean(SEMRSI008Bean semrsi008Bean) {
		getFacesUtils().setSessionMapValue("semrsi008Bean", semrsi008Bean);
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

		semrsi008Bean = new SEMRSI008Bean();
		semrsi008Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semrsi008Bean.setRegionList(getRegionItems());
		setSemrsi008Bean(semrsi008Bean);
	}

	@Override
	public boolean validate() {
		boolean flgValid = true;

		if (StringUtils.isEmpty(getSemrsi008Bean().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		if (StringUtils.isEmpty(getSemrsi008Bean().getDelay())) {
			addMessageError("W0001", msg("message.delay"));
			flgValid = false;
		}else if(!StringUtils.isNumeric(getSemrsi008Bean().getDelay())){
			addMessageError("W0008", msg("message.delay"));
			flgValid = false;
		}

		return flgValid;
	}

	@Override
	public void clearReport() {
		// TODO Auto-generated method stub
		super.clearSessionBean();
		getSemrsi008Bean().clearReportSimple();
		
		getSemrsi008Bean().setCompany(null);
		getSemrsi008Bean().setDelay(null);
		getSemrsi008Bean().setRegion(null);
		getSemrsi008Bean().setContractNo(null);
		getSemrsi008Bean().setStationName(null);
		
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		// TODO Auto-generated method stub
		super.enableBatchType("semrsi008Bean");
	}

	@Override
	public void resetReportDate() {
		// TODO Auto-generated method stub
		super.resetReportDate("semrsi008Bean");
	}

	@Override
	public void runReport() {
		// TODO Auto-generated method stub
		semrsi008Bean = getSemrsi008Bean();
		SEMRSI008ReportParameter param = null;
		List<SelectItem> s = null;
		if (validate()) {
			try {
				param = new SEMRSI008ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrsi008Bean.getCompany()));
				param.setP_company(semrsi008Bean.getCompany());
				param.setP_delay_month(semrsi008Bean.getDelay());
				param.setP_contract_no(semrsi008Bean.getContractNo());
				param.setP_site_name(semrsi008Bean.getStationName());
				param.setP_region(semrsi008Bean.getRegion());
				param.setP_username(getUserLogIn());
//				WebUtil.getContentType(param);
				super.runReport("SEMRSI008", param, semrsi008Bean
						.getReportType(), semrsi008Bean.getRunType(),
						semrsi008Bean.getBatchType(), semrsi008Bean
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
		String reportName = "SEMRSI008_";
		try{
			reportName += SEMDataUtility.getCurrentDateByPatternYYMMDD();
		super.showReport(reportName, getSemrsi008Bean().getReportType());
	}catch (Exception e) {
		e.printStackTrace();		
	}
	}
}
