package th.co.ais.rpt.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import th.co.ais.rpt.domain.ReportJob;
import th.co.ais.rpt.domain.ReportScheduleJob;
import th.co.ais.rpt.domain.ReportScheduleReportParameter;
import th.co.ais.rpt.exception.ReportServiceException;
import th.co.ais.rpt.parameter.ReportParameter;

public interface IReportScheduleJobService {
	public void createReportScheduleJob(String reportTypeId, Date jobSchedule, ReportParameter param, String requestBy, String reportExportType) throws ReportServiceException;
	public void updateEndRunReport(String job_id, boolean successFlag, String errorMessage, String filePath);
	public ReportScheduleJob getReportScheduleJob(String jobId);
	public ReportScheduleJob createReportScheduleJobWithReturn(String reportTypeId, Date jobSchedule, ReportParameter reportParameter, String requestBy, String reportExportType, String runOnServer) throws ReportServiceException;
	public List<ReportScheduleReportParameter> selectReportParameter(String reportId);
	public void updateReportParameter(ReportScheduleReportParameter param);
	public HashMap searchReportNameByList(List<ReportScheduleJob> listJob) throws ReportServiceException;
}
