package th.co.ais.web.report.action;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
//import org.jboss.remoting.transport.web.WebUtil;


import th.co.ais.rpt.parameter.SEMRIR004ReportParameter;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.util.ELovType;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMRIR004Bean;
import th.co.ais.web.util.SemUtils;

public class SEMRIR004Action extends AbstractReportAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2524424552117504744L;
	private Logger log = Logger.getLogger(getClass());
	private SEMRIR004Bean semrir004Bean;
	
	public SEMRIR004Bean getSemrir004Bean() {
		return (SEMRIR004Bean) getFacesUtils().getSessionMapValue("semrir004Bean");
	}

	public void setSemrir004Bean(SEMRIR004Bean semrir004Bean) {
		getFacesUtils().setSessionMapValue("semrir004Bean", semrir004Bean);
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
		
		SEMRIR004Bean semrir004Bean = new SEMRIR004Bean();
		semrir004Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semrir004Bean.setInsuranceYear(Calendar.getInstance(new Locale("th", "TH")).get(Calendar.YEAR)+"");
		semrir004Bean.setNetworkTypeList(getLovItemsByType(ELovType.T_IR_NETWORK_TYPES.name));
		semrir004Bean.setTransferTypeList(getLovItemsByType(ELovType.T_IR_TRANSFER_TYPES.name));
		semrir004Bean.setInsuranceTypeList(getLovItemsByType(ELovType.T_IR_POLICY_TYPE.name));
		
		setSemrir004Bean(semrir004Bean);
	}
		
	@Override
	public boolean validate() {
		boolean flgValid = true;
		
		if (StringUtils.isEmpty(getSemrir004Bean().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		if (StringUtils.isEmpty(getSemrir004Bean().getInsuranceYear())) {
			addMessageError("W0001", msg("message.insuranceYear"));
			flgValid = false;
		}else if(!SemUtils.chkYearTH(getSemrir004Bean().getInsuranceYear())){
			addMessageError("W0099",msg("message.insuranceYear"));
			flgValid = false;
		}
		
		return flgValid;
	}
	

	@Override
	public void clearReport() {
		// TODO Auto-generated method stub
		super.clearSessionBean();
		getSemrir004Bean().clearReportSimple();
		
		getSemrir004Bean().setCompany(null);
		getSemrir004Bean().setInsuranceYear(DateUtil.getCurrentYearTH());
		getSemrir004Bean().setNetworkType(null);
		getSemrir004Bean().setInsuranceType(null);
		getSemrir004Bean().setTransferType(null);
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		// TODO Auto-generated method stub
		super.enableBatchType("semrir004Bean");
	}

	@Override
	public void resetReportDate() {
		// TODO Auto-generated method stub
		super.resetReportDate("semrir004Bean");
	}

	@Override
	public void runReport() {
		// TODO Auto-generated method stub
		semrir004Bean = getSemrir004Bean();
		SEMRIR004ReportParameter param = null;
		List<SelectItem> s = null;
		if (validate()) {
			try {
				param = new SEMRIR004ReportParameter();
				param.setP_username(getUserLogIn());
				param.setP_header_name(getCompanyHeaderName(semrir004Bean.getCompany()));
				param.setP_company(semrir004Bean.getCompany());
				param.setP_display_year(semrir004Bean.getInsuranceYear());
				param.setP_ir_year(DateUtil.convertYearTH2YearEN(semrir004Bean.getInsuranceYear()));
				param.setP_display_year(semrir004Bean.getInsuranceYear());
				param.setP_network_type(semrir004Bean.getNetworkType());
				
				if (StringUtils.isNotEmpty(semrir004Bean.getNetworkType())) {
					s = th.co.ais.web.util.WebUtil.getSelectItemByValue(
							semrir004Bean.getNetworkType(), semrir004Bean.getNetworkTypeList());
					if (s != null) {
						param.setP_display_type(s.get(0).getLabel());
					}
				}
				param.setP_transfer_type(semrir004Bean.getTransferType());
				if (StringUtils.isNotEmpty(semrir004Bean.getTransferType())) {
					s = th.co.ais.web.util.WebUtil.getSelectItemByValue(
							semrir004Bean.getTransferType(), semrir004Bean.getTransferTypeList());
					if (s != null) {
						param.setP_display_transfer_type(s.get(0).getLabel());
					}
				}
				
				param.setP_policy_type(semrir004Bean.getInsuranceType());
				if (StringUtils.isNotEmpty(semrir004Bean.getInsuranceType())) {
					s = th.co.ais.web.util.WebUtil.getSelectItemByValue(
							semrir004Bean.getInsuranceType(), semrir004Bean.getInsuranceTypeList());
					if (s != null) {
						param.setP_display_policy(s.get(0).getLabel());
					}
				}
				
//				WebUtil.getContentType(param);
				super.runReport("SEMRIR004", param, 
						semrir004Bean.getReportType(), semrir004Bean.getRunType(), 
						semrir004Bean.getBatchType(), semrir004Bean.getJobSchedule());
			
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
		super.showReport("SEMRIR004", getSemrir004Bean().getReportType());
	
	
	
	}

}
