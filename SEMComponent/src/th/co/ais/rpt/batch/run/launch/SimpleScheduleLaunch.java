package th.co.ais.rpt.batch.run.launch;

import org.apache.log4j.Logger;

import th.co.ais.rpt.parameter.ReportParameter;
import th.co.ais.rpt.service.IReportMailService;
import th.co.ais.rpt.service.IReportScheduleJobService;
import th.co.ais.rpt.service.IReportServiceHelper;




public abstract class SimpleScheduleLaunch implements IScheduleLaunch {
	
	public IReportScheduleJobService reportScheduleJobService = null;
	public IReportServiceHelper reportServiceHelper = null;
	public String reportTypeId = null;
	public ReportParameter reportParameter = null;
	public String requestBy = null;
	public String reportExportType = null;
	public String runOnServer = null;
	public IReportMailService reportMailService = null;
	
	public void setReportScheduleJobService(IReportScheduleJobService reportScheduleJobService) {
		this.reportScheduleJobService = reportScheduleJobService;
	}

	public void setReportServiceHelper(IReportServiceHelper reportServiceHelper) {
		this.reportServiceHelper = reportServiceHelper;
	}
	
	public void setReportTypeId(String reportTypeId) {
		this.reportTypeId = reportTypeId;
	}
		
	public void setReportParameter(ReportParameter reportParameter) {
		this.reportParameter = reportParameter;
		
	}

	public void setReportExportType(String reportExportType) {
		this.reportExportType = reportExportType;
	}

	public void setRequestBy(String requestBy) {
		this.requestBy = requestBy;
	}

	public void setRunOnServer(String runOnServer) {
		this.runOnServer = runOnServer;
	}
	
	public void setReportMailService(IReportMailService reportMailService) {
		this.reportMailService = reportMailService;
	}

	public void afterExecute(String job_id, boolean successFlag, String errorMessage, String filePath, Logger log){
		try {
			if(errorMessage!=null && errorMessage.trim().length()>50){
				errorMessage = errorMessage.substring(0,49);
			}
			//change update parameter method to main launcher
			//reportScheduleJobService.updateReportParam(job_id);
			reportScheduleJobService.updateEndRunReport(job_id, successFlag, errorMessage, filePath);
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("SimpleScheduleLaunch:afterExecute: = " + e.getMessage());
		} 
	}	
	
}
