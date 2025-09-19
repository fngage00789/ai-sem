package th.co.ais.rpt.web.util;

import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import th.co.ais.rpt.domain.SEMECO001Domain;
import th.co.ais.rpt.exception.ReportServiceException;
import th.co.ais.rpt.parameter.ReportParameter;
import th.co.ais.rpt.parameter.SEMECO001ReportParameter;

public interface IReportWebHelper {
	public static final String REPORT_SERVICE_NAME = "reportServiceManager";
	
	public String exportReport(String reportTypeId, Date jobSchedule, ReportParameter reportParameter, String requestBy, String reportExportType);
	public String viewReport(String reportTypeId, ReportParameter param, String exportType);
	public String loadReport(String reportTypeId, ReportParameter param, String exportType);
	public void showReport(String reportTypeId, String exportType);
	public SEMECO001Domain exportReport(String reportServiceName, ReportParameter param) throws ReportServiceException, Exception;
	public String exportReport(String reportServiceName, ReportParameter param, String exportType) throws ReportServiceException, Exception;
	public String exportReport(String reportServiceName, ReportParameter param, String exportType,String coverName) throws ReportServiceException, Exception;
	
	public String exportExcelMSA003(Map<String, Object> paramMap) throws DataAccessException, SQLException;
	public String exportReport(String reportId, ReportParameter param,Object obj, String reportType, String coverName)throws ReportServiceException, Exception;
}
