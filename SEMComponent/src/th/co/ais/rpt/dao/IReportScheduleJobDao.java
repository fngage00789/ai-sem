package th.co.ais.rpt.dao;

import java.util.List;
import java.util.Set;

import org.springframework.dao.DataAccessException;

import th.co.ais.rpt.domain.ReportScheduleJob;
import th.co.ais.rpt.domain.ReportScheduleReportParameter;
import th.co.ais.rpt.parameter.SFRMO001ReportParameter;



public interface IReportScheduleJobDao {
	public static final String STATUS_WAITING = "W";
	public static final String STATUS_RUNNING = "R";
	public static final String STATUS_SUCCESS = "S";
	public static final String STATUS_FAIL = "F";
	public static final String REMARK_CLEAR_FAIL_JOB = "SYSTEM_CLEAR_FAIL_JOB";
	
	public ReportScheduleJob getReportScheduleJob(String jobId) throws DataAccessException;
	public List getReportScheduleJob() throws DataAccessException;
	public void insertReportScheduleJob(ReportScheduleJob reportScheduleJob) throws DataAccessException;
	public void updateReportScheduleJob(ReportScheduleJob reportScheduleJob) throws DataAccessException;
	public void deleteReportScheduleJob(ReportScheduleJob reportScheduleJob) throws DataAccessException;
	public ReportScheduleJob getNewReportScheduleJobForStartBatch() throws DataAccessException;
	public ReportScheduleJob getNewReportScheduleJobForStartBatch(String reportTypeId) throws DataAccessException;
	public List getClearFailJobList(String serverName, String reportOverTimeMinutes, Set currentJobIdList) throws DataAccessException;
	public int countWaitJobScheduleWithReportTypeId(String reportTypeId) throws DataAccessException;
	public List searchReportMonitoringByCriteria(SFRMO001ReportParameter criteria) throws DataAccessException;
	public List updateStatusReportMonitoring(ReportScheduleJob reportJob,SFRMO001ReportParameter criteria) throws DataAccessException;
	public List<ReportScheduleReportParameter> selectReportParameter(String reportId);
	public void updateReportParameter(ReportScheduleReportParameter param);
}
