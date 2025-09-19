package th.co.ais.manager.impl.rpt;

import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import th.co.ais.rpt.domain.SEMECO001Domain;
import th.co.ais.rpt.exception.ReportServiceException;
import th.co.ais.rpt.manager.IReportServiceManager;
import th.co.ais.rpt.parameter.ReportParameter;
import th.co.ais.rpt.service.IReportJobService;
import th.co.ais.rpt.service.IReportServiceHelper;

public class ReportServiceManagerImpl implements IReportServiceManager {

	private IReportJobService reportJobService;
	private IReportServiceHelper reportServiceHelper;
	
	public void setReportJobService(IReportJobService reportJobService) {
		this.reportJobService = reportJobService;
	}

	public void setReportServiceHelper(IReportServiceHelper reportServiceHelper) {
		this.reportServiceHelper = reportServiceHelper;
	}

	public void createReportJob(String reportTypeId, Date jobSchedule,
			ReportParameter param, String requestBy, String reportExportType) throws ReportServiceException {
		reportJobService.createReportJob(reportTypeId, jobSchedule, param, requestBy, reportExportType);

	}
	
	public byte[] viewReport(String reportServiceName, ReportParameter param, String exportType) throws ReportServiceException {
		return reportServiceHelper.view(reportServiceName, param, exportType);
	}
		
	public String exportReport(String reportServiceName, ReportParameter param, String exportType,String coverName) throws ReportServiceException{
		return reportServiceHelper.export(reportServiceName, param, exportType,coverName);
	}
	
	public String exportReport(String reportServiceName, ReportParameter param, Object obj, String exportType,String coverName) throws ReportServiceException{
		return reportServiceHelper.export(reportServiceName, param, obj, exportType,coverName);
	}
	
	public SEMECO001Domain exportReport(String reportServiceName, ReportParameter param) throws ReportServiceException{
		return reportServiceHelper.export(reportServiceName, param);
	}

	// added by.. YUT 2015/09/14
	@Override
	public byte[] prepareExportExcelMSA003(Map<String, Object> paramMap) throws DataAccessException, SQLException {
		byte[] bytes = null;
		bytes = reportJobService.doExportExcelMSA003(paramMap);
		return bytes;
	}

	
	
}
