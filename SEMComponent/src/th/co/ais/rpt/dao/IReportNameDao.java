package th.co.ais.rpt.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import th.co.ais.rpt.domain.ReportJob;
import th.co.ais.rpt.domain.ReportName;
import th.co.ais.rpt.domain.ReportScheduleJob;



public interface IReportNameDao {
	public List<ReportName> searchReportNameBySchedule(List<ReportScheduleJob> listScheduleJob) throws DataAccessException;
	public List<ReportName> searchReportNameByJob(List<ReportJob> listReportjob) throws DataAccessException;
}
