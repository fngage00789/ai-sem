package th.co.ais.web.report.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.rt.RentalPayNormalSearchSP;
import th.co.ais.rpt.parameter.SEMMRT003ReportParameter;
import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMMRT003RPTBean;
import th.co.ais.web.rt.bean.SEMMRT003Bean;

/**
 * 
 * @author Warawit Kitmongkonsak
 *
 */
public class SEMMRT003RPTAction extends AbstractReportAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6332816276685124847L;

	private Logger log = Logger.getLogger(getClass());
	
	private SEMMRT003RPTBean semmrt003RPTBean;
	private SEMMRT003Bean semmrt003Bean;
	private StringBuilder rowsIdCC;
	public SEMMRT003RPTAction() {
		
	}
	
	public SEMMRT003RPTBean getSemmrt003RPTBean() {
		return (SEMMRT003RPTBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmrt003RPTBean");
	}

	public void setSemmrt003RPTBean(SEMMRT003RPTBean semmrt003RPTBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmrt003RPTBean", semmrt003RPTBean);
	}
	
	public SEMMRT003Bean getSemmrt003Bean() {
		return (SEMMRT003Bean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmrt003Bean");
	}

	public void setSemmrt003Bean(SEMMRT003Bean semmrt003Bean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmrt003Bean", semmrt003Bean);
	}
	
	@Override
	public void init() {
		super.clearSessionBean();
		
		semmrt003RPTBean = new SEMMRT003RPTBean();
		setSemmrt003RPTBean(semmrt003RPTBean);
	}
	
	@Override
	public void clearReport() {
		super.clearSessionBean();
		
		semmrt003RPTBean = getSemmrt003RPTBean();
		semmrt003RPTBean.clearReportSimple();
		setSemmrt003RPTBean(semmrt003RPTBean);
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		super.enableBatchType("semmrt003RPTBean");
	}

	@Override
	public void resetReportDate() {
		super.resetReportDate("semmrt003RPTBean");	
	}

	@Override
	public void runReport() {
		semmrt003Bean = getSemmrt003Bean();
		semmrt003RPTBean = getSemmrt003RPTBean();
		rowsIdCC = new StringBuilder();
		SEMMRT003ReportParameter param = null;
		
		for (WrapperBeanObject<RentalPayNormalSearchSP> temps : semmrt003Bean.getRentalPayNormalSearchSPList()) {
			RentalPayNormalSearchSP temp = (RentalPayNormalSearchSP) temps.getDataObj();
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
						semmrt003RPTBean.getReportType(), semmrt003RPTBean.getRunType(), 
						semmrt003RPTBean.getBatchType(), semmrt003RPTBean.getJobSchedule());
			
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
		super.showReport("RENTAL"+ new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()), getSemmrt003RPTBean().getReportType());
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
		getSemmrt003Bean().setRenderedMsgFormBottom(true);
		
		if (StringUtils.isEmpty(rowsIdCC.toString())) {
			addMessageError("W0001", msg("message.contractDoc"));
			flgValid = false;
		}
		
		return flgValid;
	}

	
}