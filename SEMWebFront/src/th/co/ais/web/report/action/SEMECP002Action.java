package th.co.ais.web.report.action;

import java.util.Calendar;
import java.util.Date;

import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.rpt.parameter.SEMECP002ReportParameter;
import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.web.bean.common.PopupVendorSupplierBean;
import th.co.ais.web.cp.bean.SEMMCP001Bean;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMECP002Bean;

/**
 * 
 * @author Warawit Kitmongkonsak
 *
 */
public class SEMECP002Action extends AbstractReportAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -521234585178528140L;

	private Logger log = Logger.getLogger(getClass());
	
	private SEMECP002Bean semecp002Bean;
	private SEMMCP001Bean semmcp001Bean;
	private String siteConstructId;
	private String reportName = "SEMECP002"; 
	
	public SEMECP002Action() {
		
	}
	
	public SEMECP002Bean getSemecp002Bean() {
		return (SEMECP002Bean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semecp002Bean");
	}

	public void setSemecp002Bean(SEMECP002Bean semecp002Bean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semecp002Bean", semecp002Bean);
	}
	
	public SEMMCP001Bean getSemmcp001Bean() {
		return (SEMMCP001Bean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmcp001Bean");
	}

	public void setSemmcp001Bean(SEMMCP001Bean semmcp001Bean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmcp001Bean", semmcp001Bean);
	}
	
	@Override
	public void init() {
		super.clearSessionBean();
		
		semecp002Bean = new SEMECP002Bean();
		setSemecp002Bean(semecp002Bean);
	}
	
	@Override
	public void clearReport() {
		super.clearSessionBean();
		
		semecp002Bean = getSemecp002Bean();
		semecp002Bean.clearReportSimple();
		setSemecp002Bean(semecp002Bean);
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		super.enableBatchType("semecp002Bean");
	}

	@Override
	public void resetReportDate() {
		super.resetReportDate("semecp002Bean");	
	}

	public PopupVendorSupplierBean getPopupVendorSupplierBean() {
		return (PopupVendorSupplierBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupVendorSupplierBean");
	}
	
	@Override
	public void runReport() {
		semmcp001Bean = getSemmcp001Bean();
		semecp002Bean = getSemecp002Bean();
		SEMECP002ReportParameter param = null;
		siteConstructId = semmcp001Bean.getConstructionPermissionSearchSP().getSiteContructId();
		
		if (validate()) {
			try {
				param = new SEMECP002ReportParameter();
				param.setSITE_CONSTRUCT_ID(siteConstructId);
				param.setReportEngine(ServiceConstants.REPORT_ENGINE_DOCMOSIS);

				runReport("SEMECP002", param, 
						semecp002Bean.getReportType(), semecp002Bean.getRunType(), 
						semecp002Bean.getBatchType(), semecp002Bean.getJobSchedule());
			
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
		if("02".equals(getPopupVendorSupplierBean().getPopupVendorSupplierSearchSP().getConstructType())){
			reportName =(getSemmcp001Bean().getConstructionPermissionSearchSP().getContractNo().replace(" ", "_"))+"_"+ msg("rpt.name.conType");
		}else{
			if("01".equals(getPopupVendorSupplierBean().getPopupVendorSupplierSearchSP().getConstructType())){
				reportName = (getSemmcp001Bean().getConstructionPermissionSearchSP().getContractNo().replace(" ", "_"))+"_"+msg("rpt.name.totType");
			}
		}
		super.showReport(reportName, getSemecp002Bean().getReportType());
	}

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		
		if(methodWithNavi.equalsIgnoreCase("doRunReport")){
			runReport();
		} else if (methodWithNavi.equalsIgnoreCase("doShowReport")) {
			showReport();
		}
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {

	}

	@Override
	public boolean validate() {
		boolean flgValid = true;

		if (StringUtils.isEmpty(siteConstructId)) {
			addMessageError("W0001", msg("message.siteConstruct"));
			flgValid = false;
		}
		
		return flgValid;
	}

}