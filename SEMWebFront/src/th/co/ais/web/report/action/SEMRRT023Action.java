package th.co.ais.web.report.action;


import java.util.Calendar;
import java.util.Locale;


import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
//import org.jboss.remoting.transport.web.WebUtil;
import th.co.ais.rpt.parameter.SEMRRT023ReportParameter;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.util.ELovType;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMRRT023Bean;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.SemUtils;

public class SEMRRT023Action extends AbstractReportAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8870800110674018948L;
	private Logger log = Logger.getLogger(getClass());
	private SEMRRT023Bean semrrt023Bean;
	
	public SEMRRT023Bean getSemrrt023Bean() {
		return (SEMRRT023Bean)FacesUtils.getInstance().getSessionMapValue("semrrt023Bean");
	}

	public void setSemrrt023Bean(SEMRRT023Bean semrrt023Bean) {
		FacesUtils.getInstance().setSessionMapValue("semrrt023Bean", semrrt023Bean);
	}

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		// TODO Auto-generated method stub
		boolean flag = false;

		if (methodWithNavi.equalsIgnoreCase("doRunReport")) {
			runReport();
		} else if (methodWithNavi.equalsIgnoreCase("doShowReport")) {
			showReport();
		} else if (methodWithNavi.equalsIgnoreCase("doClearReport")) {
			clearReport();
		} else if (methodWithNavi.equalsIgnoreCase("getDDLExpenseType")) {
			getDDLExpenseType();
		}
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		SEMRRT023Bean semrrtBean= new SEMRRT023Bean();
		
		semrrtBean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semrrtBean.setRegionList(getRegionItems());
		semrrtBean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semrrtBean.setModuleList(getLovItemsByType(ELovType.T_CT_MODULE.name, EX_IN, "PAYMENT", null, null));
		//semrrtBean.setModuleList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name));
		semrrtBean.setExpenseTypeList(getEmptyDropDown());
		semrrtBean.setPaymentTypeList(getLovItemsByType(ELovType.T_CT_PAYMENT_TYPE.name));
		semrrtBean.setYear(Calendar.getInstance(new Locale("th", "TH")).get(Calendar.YEAR)+ "");
		setSemrrt023Bean(semrrtBean);

	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		boolean flgValid = true;

		if (StringUtils.isEmpty(getSemrrt023Bean().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		if (StringUtils.isEmpty(getSemrrt023Bean().getRegion())) {
			addMessageError("W0001", msg("message.region"));
			flgValid = false;
		}
		
		if (StringUtils.isEmpty(getSemrrt023Bean().getYear())) {
			addMessageError("W0001", msg("message.year"));
			flgValid = false;
		}
		else if(!SemUtils.chkYearTH(getSemrrt023Bean().getYear())){
			addMessageError("W0099",msg("message.year"));
			flgValid = false;
		}
		if (StringUtils.isEmpty(getSemrrt023Bean().getModule())) {
			addMessageError("W0001", msg("message.module"));
			flgValid = false;
		}
		
		return flgValid;
	}

	@Override
	public void clearReport() {
//		// TODO Auto-generated method stub
//		SEMRRT023Bean semrrt023Bean= new SEMRRT023Bean();
//		
//		semrrt023Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
//		semrrt023Bean.setRegionList(getRegionItems());
//		semrrt023Bean.setExpenseTypeList(getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name));
//		semrrt023Bean.setModuleList(getLovItemsByType(ELovType.T_CT_MODULE.name));
//		//semrrtBean.setModuleList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name));
//		semrrt023Bean.setPaymentTypeList(getLovItemsByType(ELovType.T_CT_PAYMENT_TYPE.name));
//		semrrt023Bean.setYear(Calendar.getInstance(new Locale("th", "TH")).get(Calendar.YEAR)+ "");
//		setSemrrt023Bean(semrrt023Bean);
		
		super.clearSessionBean();
		getSemrrt023Bean().clearReportSimple();
		
		getSemrrt023Bean().setCompany(null);
		getSemrrt023Bean().setYear(DateUtil.getCurrentYearTH());
		getSemrrt023Bean().setRegion(null);
		getSemrrt023Bean().setPaymentType(null);
		getSemrrt023Bean().setModule(null);
		getSemrrt023Bean().setExpenseType(null);
		
		
		enableBatchType();

	}

	private boolean getDDLExpenseType(){
		boolean flag = false;
		semrrt023Bean = getSemrrt023Bean();
		try{
			flag = true;
			//semmrt007Bean.setExpenseTypeList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name, EX_IN, "", "CP,RT,EL,PT,IR", null));
			semrrt023Bean.setExpenseTypeList(getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name, EX_IN, "", semrrt023Bean.getModule(), null));
		}catch(Exception e){
			
		}
		setSemrrt023Bean(semrrt023Bean);
		return flag;
	}
	@Override
	public void enableBatchType() {
		// TODO Auto-generated method stub
		super.enableBatchType("semrrt023Bean");
	}

	@Override
	public void resetReportDate() {
		// TODO Auto-generated method stub
		super.resetReportDate("semrrt023Bean");
	}

	@Override
	public void runReport() {
		
		semrrt023Bean = getSemrrt023Bean();
		SEMRRT023ReportParameter param = null;
		if (validate()) {
			try {
				param = new SEMRRT023ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrrt023Bean.getCompany()));
				param.setP_username(semrrt023Bean.getUserLogin());
				
				if(StringUtils.isNotEmpty(semrrt023Bean.getCompany())){
					param.setP_company(semrrt023Bean.getCompany());
				}
				
				if(StringUtils.isNotEmpty(semrrt023Bean.getRegion())){
					param.setP_region(semrrt023Bean.getRegion());
				}
				param.setP_year((Integer.parseInt(semrrt023Bean.getYear())-543)+"");
				
				if(StringUtils.isNotEmpty(semrrt023Bean.getPaymentType())){
					param.setP_payment_type(semrrt023Bean.getPaymentType());
				}
				if(StringUtils.isNotEmpty(semrrt023Bean.getModule())){
					param.setP_module(semrrt023Bean.getModule());
				}
				if(StringUtils.isNotEmpty(semrrt023Bean.getExpenseType())){
					param.setP_expense_type(semrrt023Bean.getExpenseType());
				}
				
//				WebUtil.getContentType(param);
						
				super.runReport("SEMRRT023", param, 
						semrrt023Bean.getReportType(), semrrt023Bean.getRunType(), 
						semrrt023Bean.getBatchType(), semrrt023Bean.getJobSchedule());
			
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
		super.showReport("SEMRRT023", getSemrrt023Bean().getReportType());
	}

}
