package th.co.ais.rpt.manager;

import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import th.co.ais.rpt.domain.SEMECO001Domain;
import th.co.ais.rpt.exception.ReportServiceException;
import th.co.ais.rpt.parameter.ReportParameter;

public interface IReportServiceManager {
	public void createReportJob(String reportTypeId, Date jobSchedule, ReportParameter param, String requestBy, String reportExportType) throws ReportServiceException;
	public byte[] viewReport(String reportServiceName, ReportParameter param, String exportType) throws ReportServiceException;
	public String exportReport(String reportServiceName, ReportParameter param, String exportType,String covername) throws ReportServiceException;
	public SEMECO001Domain exportReport(String reportServiceName, ReportParameter param) throws ReportServiceException;
	
	public byte[] prepareExportExcelMSA003(Map<String, Object> paramMap) throws DataAccessException, SQLException;
	public String exportReport(String reportServiceName, ReportParameter param, Object obj, String exportType, String coverName)throws ReportServiceException;
}
