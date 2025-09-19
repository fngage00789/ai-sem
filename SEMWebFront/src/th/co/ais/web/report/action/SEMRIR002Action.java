package th.co.ais.web.report.action;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
//import org.jboss.remoting.transport.web.WebUtil;

import th.co.ais.rpt.parameter.SEMRIR002ReportParameter;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.util.ELovType;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMRIR002Bean;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.SemUtils;

public class SEMRIR002Action extends AbstractReportAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1454394039398689806L;
	private SEMRIR002Bean semrir002Bean;
	private Logger log = Logger.getLogger(getClass());
	
	public SEMRIR002Bean getSemrir002Bean(){
		return (SEMRIR002Bean)FacesUtils.getInstance().getSessionMapValue("semrir002Bean");
	}
	
	public void setSemrir002Bean(SEMRIR002Bean semrir002Bean){
		FacesUtils.getInstance().setSessionMapValue("semrir002Bean", semrir002Bean);
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
		semrir002Bean = new SEMRIR002Bean();
		semrir002Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semrir002Bean.setPolicyYear(Calendar.getInstance(new Locale("th", "TH")).get(Calendar.YEAR)+"");
		semrir002Bean.setNetworkTypeList(getLovItemsByType(ELovType.T_IR_NETWORK_TYPES.name));
		semrir002Bean.setLossTypeList(getLovItemsByType(ELovType.T_IR_LOSS_TYPE.name));
		semrir002Bean.setPolicyTypeList(getLovItemsByType(ELovType.T_IR_POLICY_TYPE.name));
		
		setSemrir002Bean(semrir002Bean);
	}

	@Override
	public boolean validate() {
		boolean flgValid = true;

		if (StringUtils.isEmpty(getSemrir002Bean().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}

		if (StringUtils.isEmpty(getSemrir002Bean().getPolicyYear())) {
			addMessageError("W0001", msg("message.policyYear"));
			flgValid = false;
		}else if(!SemUtils.chkYearTH(getSemrir002Bean().getPolicyYear())){
			addMessageError("W0099",msg("message.policyYear"));
			flgValid = false;
		}
		
		return flgValid;
	}

	@Override
	public void clearReport() {
		super.clearSessionBean();
		getSemrir002Bean().clearReportSimple();
		
		getSemrir002Bean().setCompany(null);
		getSemrir002Bean().setPolicyYear(DateUtil.getCurrentYearTH());
		getSemrir002Bean().setNetworkType(null);
		getSemrir002Bean().setPolicyType(null);
		getSemrir002Bean().setRegions(null);
		getSemrir002Bean().setLossType(null);
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		super.enableBatchType("semrir002Bean");
	}

	@Override
	public void resetReportDate() {
		super.resetReportDate("semrir002Bean");
	}

	@Override
	public void runReport() {
		semrir002Bean = getSemrir002Bean();
		SEMRIR002ReportParameter param = null;
		List<SelectItem> s = null;
		if (validate()) {
			try {
				param = new SEMRIR002ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrir002Bean.getCompany()));
				param.setP_company(semrir002Bean.getCompany());
				param.setP_year(DateUtil.convertYearTH2YearEN(semrir002Bean.getPolicyYear()));
				param.setP_display_year(semrir002Bean.getPolicyYear());
				
				param.setP_network_type(semrir002Bean.getNetworkType());
				if (StringUtils.isNotEmpty(semrir002Bean.getNetworkType())) {
					s = th.co.ais.web.util.WebUtil.getSelectItemByValue(
							semrir002Bean.getNetworkType(), semrir002Bean.getNetworkTypeList());
					if (s != null) {
						param.setP_display_network_type(s.get(0).getLabel());
					}
				}
				
				param.setP_policy(semrir002Bean.getPolicyType());
				if (StringUtils.isNotEmpty(semrir002Bean.getPolicyType())) {
					s = th.co.ais.web.util.WebUtil.getSelectItemByValue(
							semrir002Bean.getPolicyType(), semrir002Bean.getPolicyTypeList());
					if (s != null) {
						param.setP_display_policy(s.get(0).getLabel());
					}
				}
				
				param.setP_loss_type(semrir002Bean.getLossType());
				if (StringUtils.isNotEmpty(semrir002Bean.getLossType())) {
					s = th.co.ais.web.util.WebUtil.getSelectItemByValue(
							semrir002Bean.getLossType(), semrir002Bean.getLossTypeList());
					if (s != null) {
						param.setP_display_loss_type(s.get(0).getLabel());
					}
				}
				
				param.setP_region(semrir002Bean.getRegions());
				param.setP_username(getUserLogIn());
				
//				WebUtil.getContentType(param);
				
				super.runReport("SEMRIR002", param, semrir002Bean
						.getReportType(), semrir002Bean.getRunType(),
						semrir002Bean.getBatchType(), semrir002Bean
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
		super.showReport("SEMRIR002", getSemrir002Bean().getReportType());
		
	}

}
