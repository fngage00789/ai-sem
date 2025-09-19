package th.co.ais.web.report.action;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.rpt.parameter.SEMRIR003ReportParameter;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.util.ELovType;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMRIR003Bean;
import th.co.ais.web.report.util.ReportDataUtil;
import th.co.ais.web.util.FacesUtils;

public class SEMRIR003Action extends AbstractReportAction{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6317066137315603030L;
	private Logger log = Logger.getLogger(getClass());
	private SEMRIR003Bean semrir003Bean;
	
	public SEMRIR003Bean getSemrir003Bean(){
		return (SEMRIR003Bean)FacesUtils.getInstance().getSessionMapValue("semrir003Bean");
	}
	
	public void setSemrir003Bean(SEMRIR003Bean semrir003Bean){
		FacesUtils.getInstance().setSessionMapValue("semrir003Bean", semrir003Bean);
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
		
		SEMRIR003Bean semrir003Bean = new SEMRIR003Bean();
		semrir003Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semrir003Bean.setInsuranceYear(Calendar.getInstance(new Locale("th", "TH")).get(Calendar.YEAR)+"");
		semrir003Bean.setLostTypeList(getLovItemsByType(ELovType.T_IR_LOSS_TYPE.name));
		
		setSemrir003Bean(semrir003Bean);
	}

	@Override
	public boolean validate() {
		boolean flgValid = true;
		
		if (StringUtils.isEmpty(getSemrir003Bean().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		
		if (StringUtils.isEmpty(getSemrir003Bean().getInsuranceYear())) {
			addMessageError("W0001", msg("message.insuranceYear"));
			flgValid = false;
		}
		
		return flgValid;
	}

	@Override
	public void clearReport() {
		super.clearSessionBean();
		getSemrir003Bean().clearReportSimple();

		getSemrir003Bean().setCompany(null);
		getSemrir003Bean().setInsuranceYear(DateUtil.getCurrentYearTH());
		getSemrir003Bean().setRegions(null);
		getSemrir003Bean().setLostType(null);
		getSemrir003Bean().setZones(null);
		
		enableBatchType();
		
	}

	@Override
	public void enableBatchType() {
		super.enableBatchType("semrir003Bean");
	}

	@Override
	public void resetReportDate() {
		super.resetReportDate("semrir003Bean");
	}

	@Override
	public void runReport() {
		semrir003Bean = getSemrir003Bean();
		SEMRIR003ReportParameter param = null;
		
		if (validate()) {
			try {
				param = new SEMRIR003ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrir003Bean.getCompany()));
				param.setP_username(getUserLogIn());
				param.setP_company(semrir003Bean.getCompany());
				param.setP_ir_year(DateUtil.convertYearTH2YearEN(semrir003Bean.getInsuranceYear()));
				param.setP_display_ir_year(semrir003Bean.getInsuranceYear());
				param.setP_region(semrir003Bean.getPopupMultiZoneBean().getRegion());
				param.setP_zone(ReportDataUtil.convertSelectItem2StringByValue(semrir003Bean.getPopupMultiZoneBean().getSelectedList()));
				param.setP_display_zone(ReportDataUtil.convertSelectItem2StringByLabel(semrir003Bean.getPopupMultiZoneBean().getSelectedList()));
				param.setP_loss_type(semrir003Bean.getLostType());
				if (StringUtils.isNotEmpty(semrir003Bean.getLostType())) {
					List<SelectItem> s = th.co.ais.web.util.WebUtil.getSelectItemByValue(
							semrir003Bean.getLostType(), semrir003Bean.getLostTypeList());
					if (s != null) {
						param.setP_display_loss_type(s.get(0).getLabel());
					}
				}
				
				super.runReport("SEMRIR003", param, 
						semrir003Bean.getReportType(), semrir003Bean.getRunType(), 
						semrir003Bean.getBatchType(), semrir003Bean.getJobSchedule());
			
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
		super.showReport("SEMRIR003", getSemrir003Bean().getReportType());
	}
	
	@Override
	public void clearRenderedMsg(){
		semrir003Bean = getSemrir003Bean();
		semrir003Bean.setRenderedMsgFormSearch(false);
		semrir003Bean.setRenderedMsgFormTop(false);
		
	}
}
