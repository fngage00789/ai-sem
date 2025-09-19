package th.co.ais.web.report.action;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.rpt.parameter.SEMRRT016ReportParameter;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.util.ELovType;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMRRT016Bean;
import th.co.ais.web.report.util.ReportDataUtil;
import th.co.ais.web.report.util.ReportDateUtil;
import th.co.ais.web.util.WebUtil;

public class SEMRRT016Action extends AbstractReportAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2524424552117504744L;
	private Logger log = Logger.getLogger(getClass());
	private SEMRRT016Bean semrrt016Bean;
	
	public SEMRRT016Bean getSemrrt016Bean() {
		return (SEMRRT016Bean) getFacesUtils().getSessionMapValue("semrrt016Bean");
	}

	public void setSemrrt016Bean(SEMRRT016Bean semrrt016Bean) {
		getFacesUtils().setSessionMapValue("semrrt016Bean", semrrt016Bean);
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
		
		semrrt016Bean = new SEMRRT016Bean();
		semrrt016Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semrrt016Bean.setYearList(ReportDateUtil.getDDLYearTh());
		semrrt016Bean.setMonthList(ReportDateUtil.getDDLMonthTH());
		semrrt016Bean.setYear(DateUtil.getCurrentYear() + "");
		setSemrrt016Bean(semrrt016Bean);
	}
		
	@Override
	public boolean validate() {
		boolean flgValid = true;
		
		if (StringUtils.isEmpty(getSemrrt016Bean().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		if (StringUtils.isEmpty(getSemrrt016Bean().getYear())) {
			addMessageError("W0001", msg("message.year"));
			flgValid = false;
		}
		
		return flgValid;
	}
	

	@Override
	public void clearReport() {
		// TODO Auto-generated method stub
		super.clearSessionBean();
		getSemrrt016Bean().clearReportSimple();
		
		getSemrrt016Bean().setCompany(null);
		getSemrrt016Bean().setYear(DateUtil.getCurrentYear() + "");
		getSemrrt016Bean().setMonth(null);
		getSemrrt016Bean().setRegion(null);
		getSemrrt016Bean().setCostCenter(null);
		getSemrrt016Bean().setGlCode(null);
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		// TODO Auto-generated method stub
		super.enableBatchType("semrrt016Bean");
	}

	@Override
	public void resetReportDate() {
		// TODO Auto-generated method stub
		super.resetReportDate("semrrt016Bean");
	}

	@Override
	public void runReport() {
		// TODO Auto-generated method stub
		semrrt016Bean = getSemrrt016Bean();
		SEMRRT016ReportParameter param = null;
		
		if (validate()) {
			try {
				param = new SEMRRT016ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrrt016Bean.getCompany()));
				param.setP_company(semrrt016Bean.getCompany());
				param.setP_month(semrrt016Bean.getMonth());
				param.setP_month_display(
						WebUtil.getSelectItemByValue(semrrt016Bean.getMonth(), ReportDateUtil.getDDLMonth()).get(0).getLabel());
				param.setP_region_display(ReportDataUtil.convertSelectItem2StringByLabel(
						semrrt016Bean.getPopupSiteMultiRegionBean().getSelectedList()));
				param.setP_region(ReportDataUtil.convertSelectItem2StringByValue(
						semrrt016Bean.getPopupSiteMultiRegionBean().getSelectedList()));
				param.setP_year(semrrt016Bean.getYear());
				param.setP_cost_center(semrrt016Bean.getCostCenter());
				param.setP_gl_code(semrrt016Bean.getGlCode());
				param.setP_username(getUserLogIn());
				
				super.runReport("SEMRRT016", param, 
						semrrt016Bean.getReportType(), semrrt016Bean.getRunType(), 
						semrrt016Bean.getBatchType(), semrrt016Bean.getJobSchedule());
			
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
		super.showReport("SEMRRT016", getSemrrt016Bean().getReportType());
	}

}
