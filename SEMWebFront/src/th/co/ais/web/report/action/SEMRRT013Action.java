package th.co.ais.web.report.action;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.rpt.parameter.SEMRRT013ReportParameter;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.util.ELovType;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMRRT013Bean;
import th.co.ais.web.report.util.ReportDateUtil;

public class SEMRRT013Action extends AbstractReportAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8857611329862166321L;
	private Logger log = Logger.getLogger(getClass());
	private SEMRRT013Bean semrrt013Bean;
	
	public SEMRRT013Bean getSemrrt013Bean() {
		return (SEMRRT013Bean) getFacesUtils().getSessionMapValue("semrrt013Bean");
	}

	public void setSemrrt013Bean(SEMRRT013Bean semrrt013Bean) {
		getFacesUtils().setSessionMapValue("semrrt013Bean", semrrt013Bean);
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
		super.clearSessionBean();
	}

	@Override
	public void init() {
		super.clearSessionBean();
		
		semrrt013Bean = new SEMRRT013Bean();
		semrrt013Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semrrt013Bean.setYearList(ReportDateUtil.getDDLYearTh());
		semrrt013Bean.setQuaterList(ReportDateUtil.getDDLQuater());
		semrrt013Bean.setYear(DateUtil.getCurrentYear() + "");
		setSemrrt013Bean(semrrt013Bean);
	}
		
	@Override
	public boolean validate() {
		boolean flgValid = true;
		
		if (StringUtils.isEmpty(getSemrrt013Bean().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		
		if (StringUtils.isEmpty(getSemrrt013Bean().getYear())) {
			addMessageError("W0001", msg("message.year"));
			flgValid = false;
		}
		
		return flgValid;
	}
	

	@Override
	public void clearReport() {
		// TODO Auto-generated method stub
		super.clearSessionBean();
		getSemrrt013Bean().clearReportSimple();
		
		getSemrrt013Bean().setCompany(null);
		getSemrrt013Bean().setYear(String.valueOf(DateUtil.getCurrentYear()));
		getSemrrt013Bean().setQuater(null);
		getSemrrt013Bean().setVendorCode(null);
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		// TODO Auto-generated method stub
		super.enableBatchType("semrrt013Bean");
	}

	@Override
	public void resetReportDate() {
		// TODO Auto-generated method stub
		super.resetReportDate("semrrt013Bean");
	}

	@Override
	public void runReport() {
		// TODO Auto-generated method stub
		semrrt013Bean = getSemrrt013Bean();
		SEMRRT013ReportParameter param = null;
		
		if (validate()) {
			try {
				param = new SEMRRT013ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrrt013Bean.getCompany()));
				param.setP_company(semrrt013Bean.getCompany());
				param.setP_year(semrrt013Bean.getYear());
				param.setP_quater(semrrt013Bean.getQuater());
				param.setP_vendor_code(semrrt013Bean.getVendorCode());
				param.setP_username(getUserLogIn());
				
				super.runReport("SEMRRT013", param, 
						semrrt013Bean.getReportType(), semrrt013Bean.getRunType(), 
						semrrt013Bean.getBatchType(), semrrt013Bean.getJobSchedule());
			
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
		// TODO Auto-generated method stub
		super.showReport("SEMRRT013", getSemrrt013Bean().getReportType());
	}
	
	
}
