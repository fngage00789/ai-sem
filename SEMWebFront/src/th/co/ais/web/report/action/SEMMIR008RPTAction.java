package th.co.ais.web.report.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.ir.Policy;
import th.co.ais.domain.ir.PolicySP;
import th.co.ais.domain.rt.RentalPayNormalSearchSP;
import th.co.ais.rpt.parameter.SEMMIR008ReportParameter;
//import th.co.ais.rpt.parameter.SEMMRT003ReportParameter;
import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.service.gm.ILovMasterService;
import th.co.ais.service.ir.IInsuredService;
import th.co.ais.util.EQueryName;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMMIR008RPTBean;
import th.co.ais.web.ir.bean.SEMMIR008Bean;

/**
 * 
 * @author Warawit Kitmongkonsak
 *
 */
public class SEMMIR008RPTAction extends AbstractReportAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6332816276685124847L;

	private Logger log = Logger.getLogger(getClass());
	
	private SEMMIR008RPTBean semmir008RPTBean;
	private SEMMIR008Bean semmir008Bean;
//	private StringBuilder dataCol;
	public SEMMIR008RPTAction() {
		
	}
	
	public SEMMIR008RPTBean getSemmir008RPTBean() {
		semmir008RPTBean =  (SEMMIR008RPTBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmir008RPTBean");
		if(semmir008RPTBean == null)
			semmir008RPTBean = new SEMMIR008RPTBean();
		return semmir008RPTBean;
	}

	public void setSemmir008RPTBean(SEMMIR008RPTBean semmir008RPTBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmir008RPTBean", semmir008RPTBean);
	}
	
	public SEMMIR008Bean getSemmir008Bean() {
		return (SEMMIR008Bean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmir008Bean");
	}

	public void setSemmir008Bean(SEMMIR008Bean semmir008Bean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmir008Bean", semmir008Bean);
	}
	
	@Override
	public void init() {
		super.clearSessionBean();
		
		semmir008RPTBean = new SEMMIR008RPTBean();
		setSemmir008RPTBean(semmir008RPTBean);
	}
	
	@Override
	public void clearReport() {
		super.clearSessionBean();
		
		semmir008RPTBean = getSemmir008RPTBean();
		semmir008RPTBean.clearReportSimple();
		setSemmir008RPTBean(semmir008RPTBean);
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		super.enableBatchType("semmir008RPTBean");
	}

	@Override
	public void resetReportDate() {
		super.resetReportDate("semmir008RPTBean");	
	}

	@Override
	public void runReport() {
		semmir008Bean = getSemmir008Bean();
		semmir008RPTBean = getSemmir008RPTBean();
		IInsuredService service = (IInsuredService)getBean("insuredService");
		String dfNumber = null;
		SEMMIR008ReportParameter param = null;
		
		dfNumber = semmir008Bean.getPolicyInfo().getDraftNo();
		
		try {
			param = new SEMMIR008ReportParameter();
			param.setDraftNo(dfNumber);
			param.setReportEngine(ServiceConstants.REPORT_ENGINE_DOCMOSIS);
			// param.setUserName(getUserLogIn());
			// param.setUserName(getEmployee().getThaiName()+" "+getEmployee().getThaiSurname());

			runReport("SEMMIR008", param, semmir008RPTBean.getReportType(),
					semmir008RPTBean.getRunType(), semmir008RPTBean
							.getBatchType(), semmir008RPTBean.getJobSchedule());
//			getSemmir008RPTBean().setDisplayShowReport(true);
		
			log.debug("show report = "+getSemmir008RPTBean().isDisplayShowReport());
		} catch (Exception e) {
			log.error("RUN REPORT ERROR IN " + getClass() +  " : " + e);
			e.printStackTrace();
		} finally {
			param = null;
			}
			
		}
	
	
	@Override
	public void showReport() {
		log.debug("show report!!!!!");
		super.showReport("SEMMIR008"+ new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()), getSemmir008RPTBean().getReportType());
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
//		getSemmir008Bean().setRenderedMsgFormBottom(true);
//		
//		if (StringUtils.isEmpty(dfNumber)) {
//			addMessageError("W0001", msg("message.contractDoc"));
//			flgValid = false;
//		}
		
		return flgValid;
	}

	
}