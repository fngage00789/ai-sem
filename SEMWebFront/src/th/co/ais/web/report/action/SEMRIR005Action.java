package th.co.ais.web.report.action;



import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
//import org.jboss.remoting.transport.web.WebUtil;


import th.co.ais.rpt.parameter.SEMRIR005ReportParameter;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.util.ELovType;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMRIR005Bean;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.SemUtils;

public class SEMRIR005Action extends AbstractReportAction{
 
	 

	/**
	 * 
	 */
	private static final long serialVersionUID = 5474989428212062174L;
	private Logger log = Logger.getLogger(getClass());
	private SEMRIR005Bean semrir005Bean;
	
	public SEMRIR005Bean getSemrir005Bean(){
		return (SEMRIR005Bean)FacesUtils.getInstance().getSessionMapValue("semrir005Bean");
	}
	
	public void setSemrir005Bean(SEMRIR005Bean semrir005Bean){
		FacesUtils.getInstance().setSessionMapValue("semrir005Bean", semrir005Bean);
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
		SEMRIR005Bean semrir005Bean = new SEMRIR005Bean();
		semrir005Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semrir005Bean.setInsuranceYear(Calendar.getInstance(new Locale("th", "TH")).get(Calendar.YEAR)+"");
		semrir005Bean.setNetworkTypeList(getLovItemsByType(ELovType.T_IR_NETWORK_TYPES.name));
		semrir005Bean.setInsuranceTypeList(getLovItemsByType(ELovType.T_IR_POLICY_TYPE.name));
		setSemrir005Bean(semrir005Bean);
	}

	@Override
	public boolean validate() {
		
		boolean flgValid = true;

		if (StringUtils.isEmpty(getSemrir005Bean().getCompany())) {
		addMessageError("W0001", msg("message.company"));
		flgValid = false;
		}

		if (StringUtils.isEmpty(getSemrir005Bean().getInsuranceYear())) {
		addMessageError("W0001", msg("message.policyYear"));
		flgValid = false;
		}else if(!SemUtils.chkYearTH(getSemrir005Bean().getInsuranceYear())){
		addMessageError("W0099",msg("message.policyYear"));
		flgValid = false;
		}
	
		return flgValid;
	}

	@Override
	public void clearReport() {
		super.clearSessionBean();
		getSemrir005Bean().clearReportSimple();

		getSemrir005Bean().setCompany(null);
		getSemrir005Bean().setInsuranceYear(DateUtil.getCurrentYearTH());
		getSemrir005Bean().setNetworkType(null);
		getSemrir005Bean().setInsuranceType(null);
		getSemrir005Bean().setRegions(null);
		
		enableBatchType();
		
	}

	@Override
	public void enableBatchType() {
		// TODO Auto-generated method stub
		super.enableBatchType("semrir005Bean");
	}

	@Override
	public void resetReportDate() {
		// TODO Auto-generated method stub
		super.resetReportDate("semrir005Bean");
	}

	@Override
	public void runReport() {
		semrir005Bean = getSemrir005Bean();
		SEMRIR005ReportParameter param = null;
		List<SelectItem> s = null;
		if (validate()) {
			try {
				param = new SEMRIR005ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrir005Bean.getCompany()));
				param.setP_company(semrir005Bean.getCompany());
				param.setP_ir_year(DateUtil.convertYearTH2YearEN(semrir005Bean.getInsuranceYear()));
				param.setP_display_year(semrir005Bean.getInsuranceYear());
				param.setP_ir_network_type(semrir005Bean.getNetworkType());
				if (StringUtils.isNotEmpty(semrir005Bean.getNetworkType())) {
					s = th.co.ais.web.util.WebUtil.getSelectItemByValue(
							semrir005Bean.getNetworkType(), semrir005Bean.getNetworkTypeList());
					if (s != null) {
						param.setP_display_type(s.get(0).getLabel());
					}
				}
				param.setP_policy_type(semrir005Bean.getInsuranceType());
				if (StringUtils.isNotEmpty(semrir005Bean.getInsuranceType())) {
					s = th.co.ais.web.util.WebUtil.getSelectItemByValue(
							semrir005Bean.getInsuranceType(), semrir005Bean.getInsuranceTypeList());
					if (s != null) {
						param.setP_display_policy(s.get(0).getLabel());
					}
				}
				param.setP_regions(semrir005Bean.getRegions());
				param.setP_username(getUserLogIn());
				
//				WebUtil.getContentType(param);
				super.runReport("SEMRIR005", param, semrir005Bean
						.getReportType(), semrir005Bean.getRunType(),
						semrir005Bean.getBatchType(), semrir005Bean
								.getJobSchedule());

			} catch (Exception e) {
				log.error("RUN REPORT ERROR IN " + getClass() + " : " + e);
				e.printStackTrace();
			} finally {
				param = null;
			}
		}
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showReport() {
		// TODO Auto-generated method stub
		super.showReport("SEMRIR005", getSemrir005Bean().getReportType());
	}

}
