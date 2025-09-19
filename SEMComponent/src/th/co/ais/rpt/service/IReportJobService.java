package th.co.ais.rpt.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import th.co.ais.rpt.batch.jmx.IReportJMX;
import th.co.ais.rpt.domain.ReportJob;
import th.co.ais.rpt.exception.ReportServiceException;
import th.co.ais.rpt.parameter.ReportParameter;
import th.co.ais.rpt.parameter.SFRMO001ReportParameter;

public interface IReportJobService {
	public void createReportJob(String reportTypeId, Date jobSchedule, ReportParameter param, String requestBy, String reportExportType) throws ReportServiceException;
	public void updateEndRunReport(String job_id, boolean successFlag, String errorMessage, String filePath);
	public void clearFailJob(String serverName, String reportOverTimeMinutes, IReportJMX proxyReportJMX);
	public ReportJob getReportJob(String jobId);
	public HashMap searchReportMonitoring(SFRMO001ReportParameter criteria) throws ReportServiceException;
	public HashMap updateStatusReportMonitoring(List statusReportList, SFRMO001ReportParameter criteria) throws ReportServiceException;
	public HashMap searchReportNameByList(List<ReportJob> reportList)throws ReportServiceException;
	
	public byte[] doExportExcelMSA003(Map<String, Object> paramMap) throws DataAccessException, SQLException;
}
