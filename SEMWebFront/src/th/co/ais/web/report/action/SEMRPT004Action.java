package th.co.ais.web.report.action;

import org.apache.commons.lang.StringUtils;
//import org.jboss.remoting.transport.web.WebUtil;
//import org.jboss.xnio.log.Logger;
import org.apache.log4j.Logger;

import th.co.ais.rpt.parameter.SEMRPT004ReportParameter;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.util.ELovType;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMRPT004Bean;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.SemUtils;

public class SEMRPT004Action extends AbstractReportAction {
	
	private static final long serialVersionUID = -6504291780104979676L;
	private Logger log = Logger.getLogger(getClass());
	
	private SEMRPT004Bean semrpt004Bean;
	

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if(methodWithNavi.equalsIgnoreCase("doRunReport")){
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
	
	public SEMRPT004Bean getSemrpt004Bean() {
		return (SEMRPT004Bean) FacesUtils.getInstance().getSessionMapValue("semrpt004Bean");
	}

	public void setSemrpt004Bean(SEMRPT004Bean semrpt004Bean) {
		FacesUtils.getInstance().setSessionMapValue("semrpt004Bean", semrpt004Bean);
	}

	@Override
	public void init() {
		super.clearSessionBean();
		
		semrpt004Bean = new SEMRPT004Bean();
		semrpt004Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semrpt004Bean.setYearTax(String.valueOf(DateUtil.getCurrentYearTH()));
		setSemrpt004Bean(semrpt004Bean);
	}

	@Override
	public boolean validate() {
		boolean flgValid = true;
		
		if (StringUtils.isEmpty(getSemrpt004Bean().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		
		if (StringUtils.isEmpty(getSemrpt004Bean().getYearTax())) {
			addMessageError("W0001", msg("message.message.pTaxYear"));
			flgValid = false;
		}else if(!SemUtils.chkYearTH(getSemrpt004Bean().getYearTax())){
			addMessageError("W0099",msg("message.pTaxYear"));
			flgValid = false;
		}
		
		return flgValid;
	}

	@Override
	public void clearReport() {
		super.clearSessionBean();
		getSemrpt004Bean().clearReportSimple();
		
		getSemrpt004Bean().setCompany(null);
		getSemrpt004Bean().setYearTax(DateUtil.getCurrentYearTH());
		getSemrpt004Bean().setPico(false);
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		super.enableBatchType("semrpt004Bean");
	}

	@Override
	public void resetReportDate() {
		super.resetReportDate("semrpt004Bean");
	}

	@Override
	public void runReport() {
		semrpt004Bean = getSemrpt004Bean();
		SEMRPT004ReportParameter param = null;
		if (validate()) {
			try {
				param = new SEMRPT004ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrpt004Bean.getCompany()));
				param.setP_company(semrpt004Bean.getCompany());
				param.setP_ptax_year(DateUtil.convertYearTH2YearEN(semrpt004Bean.getYearTax()));
				param.setP_pico_flg((semrpt004Bean.getPico())? "Y": "N");
				param.setP_display_year(semrpt004Bean.getYearTax());
				param.setP_username(getUserLogIn());
				
//				WebUtil.getContentType(param);
				super.runReport("SEMRPT004", param, 
						semrpt004Bean.getReportType(), semrpt004Bean.getRunType(), 
						semrpt004Bean.getBatchType(), semrpt004Bean.getJobSchedule());
				
			} catch (Exception e) {
				log.error("RUN REPORT ERROR IN " + getClass() +  " : " + e);
				e.printStackTrace();
			} finally {
				param = null;
			}
		}
	}

	@Override
	public void showReport() {
		super.showReport("SEMRPT004", getSemrpt004Bean().getReportType());
	}

}
