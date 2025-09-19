package th.co.ais.web.report.action;


import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
//import org.jboss.remoting.transport.web.WebUtil;
import th.co.ais.rpt.parameter.SEMRPT001ReportParameter;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.util.ELovType;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMRPT001Bean;
import th.co.ais.web.util.SemUtils;

public class SEMRPT001Action extends AbstractReportAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7410440438777216616L;
	private Logger log = Logger.getLogger(getClass());
	private SEMRPT001Bean semrpt001Bean;
	
	public SEMRPT001Bean getSemrpt001Bean() {
		return (SEMRPT001Bean) getFacesUtils().getSessionMapValue("semrpt001Bean");
	}

	public void setSemrpt001Bean(SEMRPT001Bean semrpt001Bean) {
		getFacesUtils().setSessionMapValue("semrpt001Bean", semrpt001Bean);
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
		
		semrpt001Bean = new SEMRPT001Bean();
		semrpt001Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semrpt001Bean.setYearTax(String.valueOf(DateUtil.getCurrentYearTH()));
		semrpt001Bean.setPico(false);
		setSemrpt001Bean(semrpt001Bean);
	}
		
	@Override
	public boolean validate() {
		boolean flgValid = true;
		
		if (StringUtils.isEmpty(getSemrpt001Bean().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		
		if (StringUtils.isEmpty(getSemrpt001Bean().getYearTax())) {
			addMessageError("W0001", msg("message.year"));
			flgValid = false;
		}else if(!SemUtils.chkYearTH(getSemrpt001Bean().getYearTax())){
			addMessageError("W0099",msg("message.year"));
			flgValid = false;
		}
		
		return flgValid;
	}
	

	@Override
	public void clearReport() {
		super.clearSessionBean();
		getSemrpt001Bean().clearReportSimple();
		
		getSemrpt001Bean().setCompany(null);
		getSemrpt001Bean().setYearTax(DateUtil.getCurrentYearTH());
		getSemrpt001Bean().setPico(false);
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		super.enableBatchType("semrpt001Bean");
	}

	@Override
	public void resetReportDate() {
		super.resetReportDate("semrpt001Bean");
	}

	@Override
	public void runReport() {
		semrpt001Bean = getSemrpt001Bean();
		SEMRPT001ReportParameter param = null;
		if (validate()) {
			try {
				param = new SEMRPT001ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrpt001Bean.getCompany()));
				param.setP_company(semrpt001Bean.getCompany());
				param.setP_ptax_year(DateUtil.convertYearTH2YearEN(semrpt001Bean.getYearTax()));
				param.setP_pico_flg((semrpt001Bean.getPico())? "Y": "N");
				param.setP_display_year(semrpt001Bean.getYearTax());
				param.setP_username(getUserLogIn());
				
//				WebUtil.getContentType(param);
				super.runReport("SEMRPT001", param, 
						semrpt001Bean.getReportType(), semrpt001Bean.getRunType(), 
						semrpt001Bean.getBatchType(), semrpt001Bean.getJobSchedule());
			
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
		super.showReport("SEMRPT001", getSemrpt001Bean().getReportType());
	}
	
}
