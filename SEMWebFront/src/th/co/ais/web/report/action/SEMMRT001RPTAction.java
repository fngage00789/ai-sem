package th.co.ais.web.report.action;

import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.rt.RentalPayNormalSearchSP;
import th.co.ais.rpt.parameter.SEMMRT003ReportParameter;
import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.report.bean.SEMMRT003RPTBean;
import th.co.ais.web.rt.bean.SEMMRT001Bean;
import th.co.ais.web.rt.bean.SEMMRT001PayBean;
import th.co.ais.web.rt.bean.SEMMRT004Bean;

public class SEMMRT001RPTAction extends SEMMRT003RPTAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7526023027190797757L;
	private Logger log = Logger.getLogger(getClass());
	private StringBuilder rowsIdCC;
	private SEMMRT001PayBean semmrt001PayBean;
	private SEMMRT003RPTBean semmrt003RPTBean;
	
	public SEMMRT001PayBean getSemmrt001PayBean() {
		return (SEMMRT001PayBean)getFacesUtils().getSessionMapValue("semmrt001PayBean");
	}

	public void setSemmrt001PayBean(SEMMRT001PayBean semmrt001PayBean) {
		this.semmrt001PayBean = semmrt001PayBean;
		getFacesUtils().setSessionMapValue("semmrt001PayBean", semmrt001PayBean);
	}
	
	public SEMMRT003RPTBean getSemmrt003RPTBean() {
		return (SEMMRT003RPTBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmrt003RPTBean");
	}

	public void setSemmrt003RPTBean(SEMMRT003RPTBean semmrt003RPTBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmrt003RPTBean", semmrt003RPTBean);
	}
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		init();
		if(methodWithNavi.equalsIgnoreCase("doRunReport")){
			runReport();
		} else if (methodWithNavi.equalsIgnoreCase("doShowReport")) {
			showReport();
		}
		return flag;
	}
	
	@Override
	public void runReport() {
		semmrt001PayBean = getSemmrt001PayBean();
		semmrt003RPTBean = getSemmrt003RPTBean();
		rowsIdCC = new StringBuilder();
		SEMMRT003ReportParameter param = null;
		
		for (WrapperBeanObject<RentalPayNormalSearchSP> temps : semmrt001PayBean.getRentalPayNormalSearchSPList()) {
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
				param.setUSER_NAME(getUserLogIn());

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
	public boolean validate() {
		boolean flgValid = true;
		getSemmrt001PayBean().setRenderedMsgFormBottom(true);
		
		if (StringUtils.isEmpty(rowsIdCC.toString())) {
			addMessageError("W0001", msg("message.contractDoc"));
			flgValid = false;
		}
		
		return flgValid;
	}
	
	@Override
	public void init() {
		super.clearSessionBean();
		
		semmrt003RPTBean = new SEMMRT003RPTBean();
		setSemmrt003RPTBean(semmrt003RPTBean);
	}
	
}
