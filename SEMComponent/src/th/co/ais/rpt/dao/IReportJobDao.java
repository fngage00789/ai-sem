package th.co.ais.rpt.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.dao.DataAccessException;

import th.co.ais.rpt.domain.ReportJob;
import th.co.ais.rpt.parameter.SFRMO001ReportParameter;




public interface IReportJobDao {
	public static final String STATUS_WAITING = "W";
	public static final String STATUS_RUNNING = "R";
	public static final String STATUS_SUCCESS = "S";
	public static final String STATUS_FAIL = "F";
	public static final String REMARK_CLEAR_FAIL_JOB = "SYSTEM_CLEAR_FAIL_JOB";
	
	public ReportJob getReportJob(String jobId) throws DataAccessException;
	public List getReportJob() throws DataAccessException;
	public void insertReportJob(ReportJob reportJob) throws DataAccessException;
	public void updateReportJob(ReportJob ReportJob) throws DataAccessException;
	public void deleteReportJob(ReportJob ReportJob) throws DataAccessException;
	public ReportJob getNewReportJobForStartBatch() throws DataAccessException;
	public ReportJob getNewReportJobForStartBatch(String reportTypeId) throws DataAccessException;
	public List getClearFailJobList(String serverName, String reportOverTimeMinutes, Set currentJobIdList) throws DataAccessException;
	public int countWaitJobScheduleWithReportTypeId(String reportTypeId) throws DataAccessException;
	public List searchReportMonitoringByCriteria(SFRMO001ReportParameter criteria) throws DataAccessException;
	public List updateStatusReportMonitoring(ReportJob reportJob,SFRMO001ReportParameter criteria) throws DataAccessException;
	
	public byte[] callExportExcelMSA003(Map<String, Object> paramMap) throws DataAccessException, SQLException;
}
