package th.co.ais.web.report.action;


import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.rpt.parameter.SEMRRT015ReportParameter;
import th.co.ais.util.ELovType;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMRRT015Bean;
import th.co.ais.web.report.util.ReportDataUtil;

public class SEMRRT015Action extends AbstractReportAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2524424552117504744L;
	private Logger log = Logger.getLogger(getClass());
	private SEMRRT015Bean semrrt015Bean;
	
	public SEMRRT015Bean getSemrrt015Bean() {
		return (SEMRRT015Bean) getFacesUtils().getSessionMapValue("semrrt015Bean");
	}

	public void setSemrrt015Bean(SEMRRT015Bean semrrt015Bean) {
		getFacesUtils().setSessionMapValue("semrrt015Bean", semrrt015Bean);
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
		
		semrrt015Bean = new SEMRRT015Bean();
		semrrt015Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		setSemrrt015Bean(semrrt015Bean);
	}
		
	@Override
	public boolean validate() {
		boolean flgValid = true;
		
		if (StringUtils.isEmpty(getSemrrt015Bean().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		
		return flgValid;
	}
	

	@Override
	public void clearReport() {
		// TODO Auto-generated method stub
		super.clearSessionBean();
		getSemrrt015Bean().clearReportSimple();
		
		getSemrrt015Bean().setCompany(null);
		getSemrrt015Bean().setContractNo(null);
		getSemrrt015Bean().setLocationId(null);
		getSemrrt015Bean().setRegion(null);
		getSemrrt015Bean().setAsOf(null);
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		// TODO Auto-generated method stub
		super.enableBatchType("semrrt015Bean");
	}

	@Override
	public void resetReportDate() {
		// TODO Auto-generated method stub
		super.resetReportDate("semrrt015Bean");
	}

	@Override
	public void runReport() {
		// TODO Auto-generated method stub
		semrrt015Bean = getSemrrt015Bean();
		SEMRRT015ReportParameter param = null;
		
		if (validate()) {
			try {
				param = new SEMRRT015ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrrt015Bean.getCompany()));
				param.setP_company(semrrt015Bean.getCompany());
				param.setP_contract_no(ReportDataUtil.convertSelectItem2StringByLabel(
						semrrt015Bean.getPopupSiteMultiContractBean().getSelectedList()));
				param.setP_location_id(ReportDataUtil.convertSelectItem2StringByValue(
						semrrt015Bean.getPopupSiteMultiLocationBean().getSelectedList()));
				param.setP_region(ReportDataUtil.convertSelectItem2StringByValue(
						semrrt015Bean.getPopupSiteMultiRegionBean().getSelectedList()));
				param.setP_as_of_mmyyyy(semrrt015Bean.getAsOf());
				param.setP_username(getUserLogIn());
				super.runReport("SEMRRT015", param, 
						semrrt015Bean.getReportType(), semrrt015Bean.getRunType(), 
						semrrt015Bean.getBatchType(), semrrt015Bean.getJobSchedule());
			
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
		super.showReport("SEMRRT015", getSemrrt015Bean().getReportType());
	}

}
