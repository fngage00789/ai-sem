package th.co.ais.web.report.action;

import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.co.Mco001SrchSP;
import th.co.ais.rpt.parameter.SEMECP001ReportParameter;
import th.co.ais.rpt.parameter.SEMMCO001ReportParameter;
import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.common.PopupVendorSupplierBean;
import th.co.ais.web.cp.bean.SEMMCP001Bean;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMECP001Bean;

/**
 * 
 * @author Warawit Kitmongkonsak
 *
 */
public class SEMECP001Action extends AbstractReportAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -521234585178528140L;

	private Logger log = Logger.getLogger(getClass());
	
	private SEMECP001Bean semecp001Bean;
	private SEMMCP001Bean semmcp001Bean;
	private String reportName = "SEMECP001";
	private String siteConstructId;
	
	public SEMECP001Action() {
		
	}
	
	public SEMECP001Bean getSemecp001Bean() {
		return (SEMECP001Bean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semecp001Bean");
	}

	public void setSemecp001Bean(SEMECP001Bean semecp001Bean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semecp001Bean", semecp001Bean);
	}
	
	public SEMMCP001Bean getSemmcp001Bean() {
		return (SEMMCP001Bean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmcp001Bean");
	}

	public void setSemmcp001Bean(SEMMCP001Bean semmcp001Bean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmcp001Bean", semmcp001Bean);
	}
	
	public PopupVendorSupplierBean getPopupVendorSupplierBean() {
		return (PopupVendorSupplierBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupVendorSupplierBean");
	}
	
	@Override
	public void init() {
		super.clearSessionBean();
		
		semecp001Bean = new SEMECP001Bean();
		setSemecp001Bean(semecp001Bean);
	}
	
	@Override
	public void clearReport() {
		super.clearSessionBean();
		
		semecp001Bean = getSemecp001Bean();
		semecp001Bean.clearReportSimple();
		setSemecp001Bean(semecp001Bean);
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		super.enableBatchType("semecp001Bean");
	}

	@Override
	public void resetReportDate() {
		super.resetReportDate("semecp001Bean");	
	}

	@Override
	public void runReport() {
		semmcp001Bean = getSemmcp001Bean();
		semecp001Bean = getSemecp001Bean();
		SEMECP001ReportParameter param = null;
		siteConstructId = semmcp001Bean.getConstructionPermissionSearchSP().getSiteContructId();
		
		if (validate()) {
			try {
				param = new SEMECP001ReportParameter();
				param.setSITE_CONSTRUCT_ID(siteConstructId);
				param.setReportEngine(ServiceConstants.REPORT_ENGINE_DOCMOSIS);

				runReport("SEMECP001", param, 
						semecp001Bean.getReportType(), semecp001Bean.getRunType(), 
						semecp001Bean.getBatchType(), semecp001Bean.getJobSchedule());
			
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
		super.showReport(reportName, getSemecp001Bean().getReportType());
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