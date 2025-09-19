package th.co.ais.web.report.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.el.Payment;
import th.co.ais.domain.el.PaymentWrapper;
import th.co.ais.domain.rt.RentalPayNormalSearchSP;
import th.co.ais.rpt.parameter.SEMMEL008ReportParameter;
import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.el.bean.SEMMEL008Bean;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMMEL008RPTBean;

/**
 * 
 * @author Jakrapan Paopisut
 *
 */
public class SEMMEL008RPTAction extends AbstractReportAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6838872561127483183L;

	/**
	 * 
	 */

	private Logger log = Logger.getLogger(getClass());
	
	private SEMMEL008RPTBean semmel008RPTBean;
	private SEMMEL008Bean semmel008Bean;
	private StringBuilder rowsIdCC;
	public SEMMEL008RPTAction() {
		
	}
	
	public SEMMEL008RPTBean getSemmel008RPTBean() {
		return (SEMMEL008RPTBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmel008RPTBean");
	}

	public void setSemmel008RPTBean(SEMMEL008RPTBean semmel008RPTBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmel008RPTBean", semmel008RPTBean);
	}
	
	public SEMMEL008Bean getSemmel008Bean() {
		return (SEMMEL008Bean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmel008Bean");
	}

	public void setSemmel008Bean(SEMMEL008Bean semmel008Bean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmel008Bean", semmel008Bean);
	}
	
	@Override
	public void init() {
		super.clearSessionBean();
		
		semmel008RPTBean = new SEMMEL008RPTBean();
		setSemmel008RPTBean(semmel008RPTBean);
	}
	
	@Override
	public void clearReport() {
		super.clearSessionBean();
		
		semmel008RPTBean = getSemmel008RPTBean();
		semmel008RPTBean.clearReportSimple();
		setSemmel008RPTBean(semmel008RPTBean);
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		super.enableBatchType("semmel008RPTBean");
	}

	@Override
	public void resetReportDate() {
		super.resetReportDate("semmel008RPTBean");	
	}

	@Override
	public void runReport() {
		semmel008Bean = getSemmel008Bean();
		semmel008RPTBean = getSemmel008RPTBean();
		if(semmel008RPTBean==null){
			semmel008RPTBean = new SEMMEL008RPTBean();
		}
		rowsIdCC = new StringBuilder();
		SEMMEL008ReportParameter param = null;
		
		for (PaymentWrapper temps : semmel008Bean.getPaymentWrapperList()) {
			if (temps.isSelected()){
				for(Payment payment:temps.getPaymentList()){
				rowsIdCC.append(payment.getRowId());
				rowsIdCC.append(',');
				}
			}
		} 
		
		if (validate()) {
			try {
				param = new SEMMEL008ReportParameter();
				param.setPAYMENT_ID(rowsIdCC.toString());
//				param.setPAYMENT_ID("RT1107000097730");
				param.setReportEngine(ServiceConstants.REPORT_ENGINE_DOCMOSIS);
				param.setUSER_NAME(getEmployee().getThaiName()+" "+getEmployee().getThaiSurname());
				
				runReport("SEMMEL008", param, 
						semmel008RPTBean.getReportType(), semmel008RPTBean.getRunType(), 
						semmel008RPTBean.getBatchType(), semmel008RPTBean.getJobSchedule());
			} catch (Exception e) {
				log.error("RUN REPORT ERROR IN " + getClass() +  " : " + e);
				e.printStackTrace();
			} finally {
				param = null;
			}
		}
	}
	
	public void runReportTest() {
		semmel008Bean = getSemmel008Bean();
		semmel008RPTBean = getSemmel008RPTBean();
		if(semmel008RPTBean==null){
			semmel008RPTBean = new SEMMEL008RPTBean();
		}
		rowsIdCC = new StringBuilder();
		SEMMEL008ReportParameter param = null;
		
		for (PaymentWrapper temps : semmel008Bean.getPaymentWrapperList()) {
			if (temps.isSelected()){
				for(Payment payment:temps.getPaymentList()){
				rowsIdCC.append(payment.getRowId());
				rowsIdCC.append(',');
				}
			}
		} 
		
		if (validate()) {
			try {
				param = new SEMMEL008ReportParameter();
				param.setPAYMENT_ID(rowsIdCC.toString());
//				param.setPAYMENT_ID("RT1107000097730");
				param.setReportEngine(ServiceConstants.REPORT_ENGINE_DOCMOSIS);
				param.setUSER_NAME(getEmployee().getThaiName()+" "+getEmployee().getThaiSurname());
				
				runReport("SEMMEL009", param, 
						semmel008RPTBean.getReportType(), semmel008RPTBean.getRunType(), 
						semmel008RPTBean.getBatchType(), semmel008RPTBean.getJobSchedule());
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
		super.showReport("SEMMEL008"+ new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()), getSemmel008RPTBean().getReportType());
	}

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		
		if(methodWithNavi.equalsIgnoreCase("doRunReport")){
			runReport();
		} else if(methodWithNavi.equalsIgnoreCase("doShowReport")) {
				showReport();
			
		}else if(methodWithNavi.equalsIgnoreCase("doRunReportTest")){
			runReportTest();
		}
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {

	}

	@Override
	public boolean validate() {
		boolean flgValid = true;
		getSemmel008Bean().setRenderedMsgFormBottom(true);
		
		if (StringUtils.isEmpty(rowsIdCC.toString())) {
			addMessageError("W0001", msg("message.contractDoc"));
			flgValid = false;
		}
		
		return flgValid;
	}

	
}