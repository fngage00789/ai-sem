package th.co.ais.web.report;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import javax.faces.context.FacesContext;

import th.co.ais.web.bean.AbstractBean;
import th.co.ais.web.report.util.ReportWebConstant;
import th.co.ais.web.util.WebUtil;

import th.co.ais.rpt.service.ServiceConstants;

public abstract class AbstractReportBean extends AbstractBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7111889504554598809L;
	private Date jobSchedule;
	private String reportType;
	private String runType;
	private String batchType;
	private String disabledRdoBatchImmediate;
	private String disabledRdoBatchRunAt;
	private boolean displayJobSchedule;
	private boolean displayBatchTime;
	private boolean displayShowReport;
	private boolean reportName;
	
	public AbstractReportBean(){
		
	}
	
	public AbstractReportBean(String reportType){
		initReport(reportType);
	}

	public void initReport(String reportType){
		this.reportType = ServiceConstants.TYPE_XLS;
		this.runType = ReportWebConstant.RUN_AS_WEB;
		this.batchType = ReportWebConstant.RUN_AS_JOB_NOW;
		this.disabledRdoBatchImmediate = "true";
		this.disabledRdoBatchRunAt = "true";
		this.displayJobSchedule = false;
		this.displayBatchTime = false;
		this.reportType = reportType;
	}
	
	public void clearReportSimple(){
		this.runType = ReportWebConstant.RUN_AS_WEB;
		this.batchType = ReportWebConstant.RUN_AS_JOB_NOW;
		this.disabledRdoBatchImmediate = "true";
		this.disabledRdoBatchRunAt = "true";
		this.displayJobSchedule = false;
		this.displayBatchTime = false;	
	}
	
	public String getBatchType() {
		return batchType;
	}
	
	public void setBatchType(String batchType) {
		this.batchType = batchType;
	}
	
	public String getDisabledRdoBatchImmediate() {
		return disabledRdoBatchImmediate;
	}
	
	public void setDisabledRdoBatchImmediate(String disabledRdoBatchImmediate) {
		this.disabledRdoBatchImmediate = disabledRdoBatchImmediate;
	}
	
	public String getDisabledRdoBatchRunAt() {
		return disabledRdoBatchRunAt;
	}
	
	public void setDisabledRdoBatchRunAt(String disabledRdoBatchRunAt) {
		this.disabledRdoBatchRunAt = disabledRdoBatchRunAt;
	}
	
	public boolean isDisplayBatchTime() {
		return displayBatchTime;
	}
	
	public void setDisplayBatchTime(boolean displayBatchTime) {
		this.displayBatchTime = displayBatchTime;
	}
	
	public boolean isDisplayJobSchedule() {
		return displayJobSchedule;
	}
	
	public void setDisplayJobSchedule(boolean displayJobSchedule) {
		this.displayJobSchedule = displayJobSchedule;
	}
	
	public boolean isDisplayShowReport() {
		boolean flag = false;
		byte[] bytes = null;
		try {
			bytes = (byte[])FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(ServiceConstants.DATA_INPUT_STREAM);
			if(bytes!=null && bytes.length>0){
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			bytes = null;
		}
		
		return flag;
	}
	
	public void setDisplayShowReport(boolean displayShowReport) {
		this.displayShowReport = displayShowReport;
	}
	
	public Date getJobSchedule() {
		return  (jobSchedule != null)?jobSchedule:new Date();
	}
	
	public void setJobSchedule(Date jobSchedule) {
		this.jobSchedule = jobSchedule;
	}
	
	public String getReportType() {
		return reportType;
	}
	
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	
	public String getRunType() {
		return runType;
	}
	
	public void setRunType(String runType) {
		this.runType = runType;
	}

	public boolean isReportName() {
		return reportName;
	}

	public void setReportName(boolean reportName) {
		this.reportName = reportName;
	}
	
	public Map<String, Boolean> getRendererSSO() {
		return WebUtil.getRenderSSO();
	}
	
}
