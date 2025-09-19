package th.co.ais.web.report.action;

import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
//import org.jboss.remoting.transport.web.WebUtil;

import th.co.ais.rpt.parameter.SEMRRT018ReportParameter;
import th.co.ais.util.ELovType;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMRRT018Bean;
import th.co.ais.web.util.SemUtils;

public class SEMRRT018Action extends AbstractReportAction{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 27942426829845098L;
	/**
	 * 
	 */
	private Logger log = Logger.getLogger(getClass());
	private SEMRRT018Bean semrrt018Bean;
	
	public SEMRRT018Bean getSemrrt018Bean() {
		return (SEMRRT018Bean) getFacesUtils().getSessionMapValue("semrrt018Bean");
	}

	public void setSemrrt018Bean(SEMRRT018Bean semrrt018Bean) {
		getFacesUtils().setSessionMapValue("semrrt018Bean", semrrt018Bean);
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
		semrrt018Bean = new SEMRRT018Bean();
		semrrt018Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semrrt018Bean.setContractStatusList(getLovItemsByType(ELovType.T_SI_SITE_STATUS.name));
		semrrt018Bean.setNetworkStatusList(getLovItemsByType(ELovType.T_CT_NETWORK_STATUS.name));
		semrrt018Bean.setAsOf(SEMDataUtility.getCurrentMonthYear());
		setSemrrt018Bean(semrrt018Bean);
	}
		
	@Override
	public boolean validate() {
		boolean flgValid = true;
		
		if (StringUtils.isEmpty(getSemrrt018Bean().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		
		if(StringUtils.isEmpty(getSemrrt018Bean().getAsOf())){
			addMessageError("W0001", msg("message.monthYearThLbl"));
			flgValid = false;
		}else{
			String msgError = SemUtils.chkMonthYearFormat(getSemrrt018Bean().getAsOf());
			if(msgError!=null){
				addMessageError("W0102", msg("message.monthYearThLbl")+" ("+msg(msgError)+") ");
				flgValid = false;
			}
		}
		
		
		return flgValid;
	}
	

	@Override
	public void clearReport() {
		// TODO Auto-generated method stub
		super.clearSessionBean();
		
		semrrt018Bean = new SEMRRT018Bean();
		semrrt018Bean.clearReportSimple();
		semrrt018Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semrrt018Bean.setContractStatusList(getLovItemsByType(ELovType.T_SI_SITE_STATUS.name));
		semrrt018Bean.setNetworkStatusList(getLovItemsByType(ELovType.T_CT_NETWORK_STATUS.name));
		setSemrrt018Bean(semrrt018Bean);
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		// TODO Auto-generated method stub
		super.enableBatchType("semrrt018Bean");
	}

	@Override
	public void resetReportDate() {
		// TODO Auto-generated method stub
		super.resetReportDate("semrrt018Bean");
	}

	@Override
	public void runReport() {
		// TODO Auto-generated method stub
		semrrt018Bean = getSemrrt018Bean();
		SEMRRT018ReportParameter param = null;
		List<SelectItem> s = null;
		if (validate()) {
			try {
				param = new SEMRRT018ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrrt018Bean.getCompany()));
				param.setP_company(semrrt018Bean.getCompany());
				param.setP_contract_no(semrrt018Bean.getMultiContractNo());
				param.setP_location_id(semrrt018Bean.getMultiLocationId());
				param.setP_region(semrrt018Bean.getMultiRegion());
				param.setP_vendor(semrrt018Bean.getMultiVendor());
				
				param.setP_contract_status(semrrt018Bean.getContractStatus());
				if(StringUtils.isNotEmpty(semrrt018Bean.getContractStatus())){
					s = th.co.ais.web.util.WebUtil.getSelectItemByValue(semrrt018Bean.getContractStatus(), semrrt018Bean.getContractStatusList());
					if(s != null){
						param.setP_display_contract_status(s.get(0).getLabel());
					}
				}
				param.setP_network_status(semrrt018Bean.getNetworkStatus());
				if(StringUtils.isNotEmpty(semrrt018Bean.getNetworkStatus())){
					s = th.co.ais.web.util.WebUtil.getSelectItemByValue(semrrt018Bean.getNetworkStatus(), semrrt018Bean.getNetworkStatusList());
					if(s != null){
						param.setP_display_network_status(s.get(0).getLabel());
					}
				}
				if(StringUtils.isNotEmpty(getSemrrt018Bean().getAsOf())){
					param.setP_asof(SemUtils.convertMonthYearTH2MonthYearEN(semrrt018Bean.getAsOf()));
				}
				param.setP_display_as_of(semrrt018Bean.getAsOf());
				param.setP_username(getUserLogIn());
//				WebUtil.getContentType(param);
				super.runReport("SEMRRT018", param, 
						semrrt018Bean.getReportType(), semrrt018Bean.getRunType(), 
						semrrt018Bean.getBatchType(), semrrt018Bean.getJobSchedule());
			
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
		super.showReport("SEMRRT018", getSemrrt018Bean().getReportType());
	}
	
}
