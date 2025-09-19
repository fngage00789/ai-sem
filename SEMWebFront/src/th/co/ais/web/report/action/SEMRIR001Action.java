package th.co.ais.web.report.action;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
//import org.jboss.remoting.transport.web.WebUtil;


import th.co.ais.rpt.parameter.SEMRIR001ReportParameter;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.util.ELovType;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMRIR001Bean;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.SemUtils;

public class SEMRIR001Action extends AbstractReportAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1454394039398689806L;
	private Logger log = Logger.getLogger(getClass());
	private SEMRIR001Bean semrir001Bean;
	
	public SEMRIR001Bean getSemrir001Bean(){
		return (SEMRIR001Bean)FacesUtils.getInstance().getSessionMapValue("semrir001Bean");
	}
	
	public void setSemrir001Bean(SEMRIR001Bean semrir001Bean){
		FacesUtils.getInstance().setSessionMapValue("semrir001Bean", semrir001Bean);
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
		SEMRIR001Bean semrir001Bean = new SEMRIR001Bean();
		semrir001Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semrir001Bean.setInsuranceYear(Calendar.getInstance(new Locale("th", "TH")).get(Calendar.YEAR)+"");
		semrir001Bean.setNetworkTypeList(getLovItemsByType(ELovType.T_IR_NETWORK_TYPES.name));
		
		semrir001Bean.setInsuranceTypeList(getLovItemsByType(ELovType.T_IR_POLICY_TYPE.name));
		
		setSemrir001Bean(semrir001Bean);
	}

	@Override
	public boolean validate() {
		boolean flgValid = true;

		if (StringUtils.isEmpty(getSemrir001Bean().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}

		if (StringUtils.isEmpty(getSemrir001Bean().getInsuranceYear())) {
			addMessageError("W0001", msg("message.policyYear"));
			flgValid = false;
		}else if(!SemUtils.chkYearTH(getSemrir001Bean().getInsuranceYear())){
			addMessageError("W0099",msg("message.policyYear"));
			flgValid = false;
		}
		
		return flgValid;
	}

	@Override
	public void clearReport() {
		super.clearSessionBean();
		getSemrir001Bean().clearReportSimple();
		
		getSemrir001Bean().setCompany(null);
		getSemrir001Bean().setInsuranceYear(DateUtil.getCurrentYearTH());
		getSemrir001Bean().setNetworkType(null);
		getSemrir001Bean().setInsuranceType(null);
		getSemrir001Bean().setRegions(null);
		
		enableBatchType();
		
	}

	@Override
	public void enableBatchType() {
		// TODO Auto-generated method stub
		super.enableBatchType("semrir001Bean");
	}

	@Override
	public void resetReportDate() {
		// TODO Auto-generated method stub
		super.resetReportDate("semrir001Bean");
	}

	@Override
	public void runReport() {
		semrir001Bean = getSemrir001Bean();
		SEMRIR001ReportParameter param = null;
		List<SelectItem> s = null;
		if (validate()) {
			try {
				param = new SEMRIR001ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrir001Bean
						.getCompany()));
				param.setP_company(semrir001Bean.getCompany());
				
				param.setP_year(DateUtil.convertYearTH2YearEN(semrir001Bean.getInsuranceYear()));
				param.setP_display_year(semrir001Bean.getInsuranceYear());
				
				param.setP_type(semrir001Bean.getNetworkType());
				if (StringUtils.isNotEmpty(semrir001Bean.getNetworkType())) {
					s = th.co.ais.web.util.WebUtil.getSelectItemByValue(
							semrir001Bean.getNetworkType(), semrir001Bean.getNetworkTypeList());
					if (s != null) {
						param.setP_display_type(s.get(0).getLabel());
					}
				}
				
				param.setP_policy(semrir001Bean.getInsuranceType());
				if (StringUtils.isNotEmpty(semrir001Bean.getInsuranceType())) {
					s = th.co.ais.web.util.WebUtil.getSelectItemByValue(
							semrir001Bean.getInsuranceType(), semrir001Bean.getInsuranceTypeList());
					if (s != null) {
						param.setP_display_policy(s.get(0).getLabel());
					}
				}
				
				param.setP_region(semrir001Bean.getRegions());
				param.setP_create_by(getUserLogIn());
				
//				WebUtil.getContentType(param);
				super.runReport("SEMRIR001", param, semrir001Bean
						.getReportType(), semrir001Bean.getRunType(),
						semrir001Bean.getBatchType(), semrir001Bean
								.getJobSchedule());

			} catch (Exception e) {
				log.error("RUN REPORT ERROR IN " + getClass() + " : " + e);
				e.printStackTrace();
			} finally {
				param = null;
			}
		}
		
	}

	@Override
	public void showReport() {
		super.showReport("SEMRIR001", getSemrir001Bean().getReportType());
		
	}

}
