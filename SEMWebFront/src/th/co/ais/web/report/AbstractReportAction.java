package th.co.ais.web.report;

import java.util.Date;

import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;

import th.co.ais.domain.gm.Company;
import th.co.ais.rpt.parameter.ReportParameter;
import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.rpt.web.util.IReportWebHelper;
import th.co.ais.service.gm.ICompanyService;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.report.util.ReportUIUtil;
import th.co.ais.web.report.util.ReportWebConstant;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.JSFServiceFinderUtil;

public abstract class AbstractReportAction extends AbstractAction{
	
	public abstract void clearReport();
	public abstract void runReport();
	public abstract void enableBatchType();
	public abstract void resetReportDate();
	public abstract void showReport();
	
	public void runReport(String reportId, ReportParameter param, String reportType, String runType, String batchType, Date jobSchedule){
		IReportWebHelper reportWebHelper = null;
		String outPageMessage = null;
		try {
			if (StringUtils.isNotEmpty(param.getReportEngine())) {
				reportWebHelper = (IReportWebHelper)JSFServiceFinderUtil.getInstance().getBean("reportWebHelper");
				if(runType.equals(ReportWebConstant.RUN_AS_WEB)){
					outPageMessage = reportWebHelper.loadReport(reportId, param, reportType);		
					if(outPageMessage.equals("viewReportComplete")){
						System.out.println("outPageMessage :"+outPageMessage);
						// message report complete
					}else if(outPageMessage.equals("TRANSACTION_TIMEOUT")){
						// message report timeout
						System.out.println("outPageMessage :"+outPageMessage);
					}else{
						System.out.println("outPageMessage :"+outPageMessage);
						// message report other error
					}
				}else{
					if(batchType.equals(ReportWebConstant.RUN_AS_JOB_NOW)){
						outPageMessage = reportWebHelper.exportReport(reportId, DateUtil.getCurrentDateTime().getTime(), param, "username", reportType);
					}else{
						outPageMessage = reportWebHelper.exportReport(reportId, jobSchedule, param, "username", reportType);
					}
					if(outPageMessage.equals("createReportJobComplete")){
						// message create job complete	
					}else{
						// message create job error
					}						
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// message error
		} finally{
			reportWebHelper = null;
			outPageMessage = null;
		}
	}
	
	public void enableBatchType(String formBean){
		try {
			ReportUIUtil.enableBatchType(formBean, "getRunType", "setBatchType", "setJobSchedule", "setDisplayJobSchedule", 
					"setDisabledRdoBatchImmediate", "setDisabledRdoBatchRunAt", "setDisplayBatchTime");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
		}
	}
	
	public void resetReportDate(String formBean){
		try {
			ReportUIUtil.resetReportDate(formBean, "getBatchType", "setJobSchedule", "setDisplayJobSchedule");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String showReport(String reportId, String reportType){
		IReportWebHelper reportWebHelper = null;
		
		try {
			reportWebHelper = (IReportWebHelper)JSFServiceFinderUtil.getInstance().getBean("reportWebHelper");
			reportWebHelper.showReport(reportId, reportType);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			reportWebHelper = null;
		}
		return null;
	}
	
	protected void clearSessionBean(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(ServiceConstants.DATA_INPUT_STREAM);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("popupMultiVendorBean");
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("popupSiteMultiContractBean");
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("popupSiteMultiLocationBean");
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("popupSiteMultiRegionBean");
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("popupMultiZoneBean");
	}
	
	public String getCompanyHeaderName(String rowId) {	
		ICompanyService service = (ICompanyService)FacesUtils.getInstance().getBean("companyService");
		Company company = null;
		String headerName = null;
		
		try {
			if (StringUtils.isNotEmpty(rowId)) {
				company = new Company();
				company.setRowId(rowId);
				headerName = service.queryContract(company).getThName();
				
				if (!StringUtils.isNotEmpty(headerName)) {
					headerName = rowId;
				}
			}
		} catch (Exception e) {
			company = null;
		}
		return headerName;
	}
}
