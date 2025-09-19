package th.co.ais.web.report.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.ir.PolicySP;
import th.co.ais.domain.rt.RentalPayNormalSearchSP;
import th.co.ais.rpt.parameter.SEMMRT003ReportParameter;
import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.ir.bean.SEMMIR010Bean;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMMIR010RPTBean;

/**
 * 
 * @author Warawit Kitmongkonsak
 *
 */
public class SEMMIR010RPTAction extends AbstractReportAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6332816276685124847L;

	private Logger log = Logger.getLogger(getClass());
	
	private SEMMIR010RPTBean semmir010RPTBean;
	private SEMMIR010Bean semmir010Bean;
	private StringBuilder rowsIdCC;
	public SEMMIR010RPTAction() {
		
	}
	
	public SEMMIR010RPTBean getSemmir010RPTBean() {
		semmir010RPTBean = (SEMMIR010RPTBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmir010RPTBean");
		if(semmir010RPTBean == null)
			semmir010RPTBean = new SEMMIR010RPTBean();
		return semmir010RPTBean;
	}

	public void setSemmir010RPTBean(SEMMIR010RPTBean semmir010RPTBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmir010RPTBean", semmir010RPTBean);
	}
	
	public SEMMIR010Bean getSemmir010Bean() {
		return (SEMMIR010Bean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmir010Bean");
	}

	public void setSemmir010Bean(SEMMIR010Bean semmir010Bean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmir010Bean", semmir010Bean);
	}
	
	@Override
	public void init() {
		super.clearSessionBean();
		
		semmir010RPTBean = new SEMMIR010RPTBean();
		setSemmir010RPTBean(semmir010RPTBean);
	}
	
	@Override
	public void clearReport() {
		super.clearSessionBean();
		
		semmir010RPTBean = getSemmir010RPTBean();
		semmir010RPTBean.clearReportSimple();
		setSemmir010RPTBean(semmir010RPTBean);
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		super.enableBatchType("semmir010RPTBean");
	}

	@Override
	public void resetReportDate() {
		super.resetReportDate("semmir010RPTBean");	
	}

	@Override
	public void runReport() {
		semmir010Bean = getSemmir010Bean();
		semmir010RPTBean = getSemmir010RPTBean();
		rowsIdCC = new StringBuilder();
		SEMMRT003ReportParameter param = null;
		
		for (WrapperBeanObject<PolicySP> temps : semmir010Bean.getPolicySPList()) {
			PolicySP temp = (PolicySP) temps.getDataObj();
			if (temp != null && temps.isCheckBox()) {
				rowsIdCC.append(temp.getRowId());
				rowsIdCC.append(',');
			} 
		}
		
		if (validate()) {
			try {
				param = new SEMMRT003ReportParameter();
				param.setPAYMENT_ID(rowsIdCC.toString());
				param.setReportEngine(ServiceConstants.REPORT_ENGINE_DOCMOSIS);
//				param.setUSER_NAME(getUserLogIn());
				param.setUSER_NAME(getEmployee().getThaiName()+" "+getEmployee().getThaiSurname());
				
				runReport("SEMMRT003", param, 
						semmir010RPTBean.getReportType(), semmir010RPTBean.getRunType(), 
						semmir010RPTBean.getBatchType(), semmir010RPTBean.getJobSchedule());
				log.debug("getSemmir010RPTBean().isDisplayShowReport() = "+getSemmir010RPTBean().isDisplayShowReport());
			} catch (Exception e) {
				log.error("RUN REPORT ERROR IN " + getClass() +  " : " + e);
				e.printStackTrace();
			} finally {
				param = null;
			}
		}
	}
	
	@Override
	public void showReport() {
		super.showReport("INSURANCE"+ new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()), getSemmir010RPTBean().getReportType());
	}

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		
		if(methodWithNavi.equalsIgnoreCase("doRunReport")){
			runReport();
		} else{ if (methodWithNavi.equalsIgnoreCase("doShowReport")) {
				showReport();
			}
		}
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {

	}

	@Override
	public boolean validate() {
		boolean flgValid = true;
		getSemmir010Bean().setRenderedMsgFormBottom(true);
		
		if (StringUtils.isEmpty(rowsIdCC.toString())) {
			addMessageError("W0001", msg("message.contractDoc"));
			flgValid = false;
		}
		
		return flgValid;
	}

	
}