package th.co.ais.web.report.action;


import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
//import org.jboss.remoting.transport.web.WebUtil;
import th.co.ais.rpt.parameter.SEMRPT003ReportParameter;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.util.ELovType;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMRPT003Bean;
import th.co.ais.web.util.SemUtils;

public class SEMRPT003Action extends AbstractReportAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7410440438777216616L;
	private Logger log = Logger.getLogger(getClass());
	private SEMRPT003Bean semrpt003Bean;
	
	public SEMRPT003Bean getSemrpt003Bean() {
		return (SEMRPT003Bean) getFacesUtils().getSessionMapValue("semrpt003Bean");
	}

	public void setSemrpt003Bean(SEMRPT003Bean semrpt003Bean) {
		getFacesUtils().setSessionMapValue("semrpt003Bean", semrpt003Bean);
	}

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

	@Override
	public void init() {
		super.clearSessionBean();
		
		semrpt003Bean = new SEMRPT003Bean();
		semrpt003Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semrpt003Bean.setYearTax(String.valueOf(DateUtil.getCurrentYearTH()));
		semrpt003Bean.setPico(false);
		setSemrpt003Bean(semrpt003Bean);
	}
		
	@Override
	public boolean validate() {
		boolean flgValid = true;
		
		if (StringUtils.isEmpty(getSemrpt003Bean().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		
		if (StringUtils.isEmpty(getSemrpt003Bean().getYearTax())) {
			addMessageError("W0001", msg("message.pTaxYear"));
			flgValid = false;
		}else if(!SemUtils.chkYearTH(getSemrpt003Bean().getYearTax())){
			addMessageError("W0099",msg("message.pTaxYear"));
			flgValid = false;
		}
		
		return flgValid;
	}
	

	@Override
	public void clearReport() {
		super.clearSessionBean();
		getSemrpt003Bean().clearReportSimple();
		
		getSemrpt003Bean().setCompany(null);
		getSemrpt003Bean().setYearTax(DateUtil.getCurrentYearTH());
		getSemrpt003Bean().setPico(false);
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		super.enableBatchType("semrpt003Bean");
	}

	@Override
	public void resetReportDate() {
		super.resetReportDate("semrpt003Bean");
	}

	@Override
	public void runReport() {
		semrpt003Bean = getSemrpt003Bean();
		SEMRPT003ReportParameter param = null;
		if (validate()) {
			try {
				param = new SEMRPT003ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrpt003Bean.getCompany()));
				param.setP_company(semrpt003Bean.getCompany());
				param.setP_ptax_year(DateUtil.convertYearTH2YearEN(semrpt003Bean.getYearTax()));
				param.setP_pico_flg(semrpt003Bean.isPico()? "Y": "N");
				param.setP_display_ptax_year(semrpt003Bean.getYearTax());
				param.setP_username(getUserLogIn());
				
//				WebUtil.getContentType(param);
				super.runReport("SEMRPT003", param, 
						semrpt003Bean.getReportType(), semrpt003Bean.getRunType(), 
						semrpt003Bean.getBatchType(), semrpt003Bean.getJobSchedule());
			
			} catch (Exception e) {
				log.error("RUN REPORT ERROR IN " + getClass() +  " : " + e);
				e.printStackTrace();
			} finally{
				param = null;
			}
		}
	}

	@Override
	public void showReport() {
		super.showReport("SEMRPT003", getSemrpt003Bean().getReportType());
	}
	
}
