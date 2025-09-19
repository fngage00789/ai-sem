package th.co.ais.service.impl.rpt;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import th.co.ais.rpt.dao.IReportNameDao;
import th.co.ais.rpt.dao.IReportScheduleJobDao;
import th.co.ais.rpt.domain.ReportName;
import th.co.ais.rpt.domain.ReportScheduleJob;
import th.co.ais.rpt.domain.ReportScheduleReportParameter;
import th.co.ais.rpt.exception.ReportServiceException;
import th.co.ais.rpt.parameter.ReportParameter;
import th.co.ais.rpt.parameter.SFRMO001ReportParameter;
import th.co.ais.rpt.service.IReportScheduleJobService;
import th.co.ais.rpt.service.IReportServiceHelper;
import th.co.ais.rpt.service.ServiceConstants;

public class ReportScheduleJobServiceImpl implements IReportScheduleJobService {
	
	private IReportScheduleJobDao reportScheduleJobDao;
	private IReportServiceHelper reportServiceHelper;
	private IReportNameDao reportNameDao;
	
	public void setReportNameDao(IReportNameDao reportNameDao) {
		this.reportNameDao = reportNameDao;
	}


	public void setReportScheduleJobDao(IReportScheduleJobDao reportScheduleJobDao) {
		this.reportScheduleJobDao = reportScheduleJobDao;
	}


	public void setReportServiceHelper(IReportServiceHelper reportServiceHelper) {
		this.reportServiceHelper = reportServiceHelper;
	}


	public void createReportScheduleJob(String reportTypeId, Date jobSchedule, ReportParameter reportParameter, String requestBy, String reportExportType) throws ReportServiceException{
		ReportScheduleJob reportScheduleJob = null;
		try {
			reportScheduleJob = new ReportScheduleJob();
			reportScheduleJob.setJobSchedule(jobSchedule);
			reportScheduleJob.setReportExportType(reportExportType);
			reportScheduleJob.setReportParam(reportServiceHelper.genParamXMl(reportTypeId, reportParameter));
			reportScheduleJob.setReportTypeId(reportTypeId);
			reportScheduleJob.setRequestBy(requestBy);
			reportScheduleJob.setRequestDt(new Date());
			reportScheduleJob.setStatus(IReportScheduleJobDao.STATUS_WAITING);
			reportScheduleJobDao.insertReportScheduleJob(reportScheduleJob);
		} catch (Exception e) {
			if(e instanceof ReportServiceException){
				throw (ReportServiceException)e;
			}else{
				throw new ReportServiceException("Error Create Report Job");
			}				
		} finally{
			
		}
	}
	
	public ReportScheduleJob createReportScheduleJobWithReturn(String reportTypeId, Date jobSchedule, ReportParameter reportParameter
			, String requestBy, String reportExportType, String runOnServer) throws ReportServiceException{
		ReportScheduleJob reportScheduleJob = null;
		try {
			reportScheduleJob = new ReportScheduleJob();
			reportScheduleJob.setJobSchedule(jobSchedule);
			reportScheduleJob.setReportExportType(reportExportType);
			reportScheduleJob.setReportParam(reportServiceHelper.genParamXMl(reportTypeId, reportParameter));
			reportScheduleJob.setReportTypeId(reportTypeId);
			reportScheduleJob.setRequestBy(requestBy);
			reportScheduleJob.setRequestDt(new Date());
			reportScheduleJob.setStatus(IReportScheduleJobDao.STATUS_RUNNING);
			reportScheduleJob.setStartDt(new Date());
			reportScheduleJob.setRunOnServer(runOnServer);
			reportScheduleJobDao.insertReportScheduleJob(reportScheduleJob);
		} catch (Exception e) {
			if(e instanceof ReportServiceException){
				throw (ReportServiceException)e;
			}else{
				throw new ReportServiceException("Error Create Report Job");
			}				
		} finally{
			
		}
		return reportScheduleJob;
	}
	
	public void updateEndRunReport(String job_id, boolean successFlag, String errorMessage, String filePath) {
		
		ReportScheduleJob ReportScheduleJob = null;
		
		try {
			//update end date & status of Report_Job S or F
			ReportScheduleJob = reportScheduleJobDao.getReportScheduleJob(job_id);
			ReportScheduleJob.setEndDt(new Date());
			if(successFlag){
				ReportScheduleJob.setStatus(IReportScheduleJobDao.STATUS_SUCCESS);
			}else{
				ReportScheduleJob.setStatus(IReportScheduleJobDao.STATUS_FAIL);
				ReportScheduleJob.setRemark(errorMessage);
			}
			if(filePath!=null && filePath.length()>0){
				ReportScheduleJob.setReportExportFilePath(filePath);	
			}
			
			reportScheduleJobDao.updateReportScheduleJob(ReportScheduleJob);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReportScheduleJob = null;
		}
	}
	
	public ReportScheduleJob getReportScheduleJob(String jobId){
		
		ReportScheduleJob ReportScheduleJob = null;
		
		try {
			ReportScheduleJob = reportScheduleJobDao.getReportScheduleJob(jobId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ReportScheduleJob;
	}


	public HashMap searchReportMonitoring(SFRMO001ReportParameter criteria) throws ReportServiceException {
		HashMap returnMap = new HashMap();
		List resultList = null;

		try {
			resultList = reportScheduleJobDao.searchReportMonitoringByCriteria(criteria);
		    returnMap.put("REPORT_SCHEDULE_MONITORING_LIST", resultList);
			returnMap.put(ServiceConstants.STATUS, ServiceConstants.STATUS_SUCCESS);
	    } catch (Exception e) {
			e.printStackTrace();
			returnMap.put(ServiceConstants.STATUS,ServiceConstants.STATUS_ERROR);
			if (e instanceof ReportServiceException) {
				throw (ReportServiceException) e;
			} else {
				throw new ReportServiceException("Error ReportScheduleJobServiceImpl searchReportMonitoring");
			}
		} finally {
			resultList = null;
		}
		return returnMap;		
	}
	
	public HashMap updateStatusReportMonitoring(List statusReportList,SFRMO001ReportParameter criteria) throws ReportServiceException {
		HashMap returnMap = new HashMap();
		ReportScheduleJob reportScheduleJob = null;
		List returnListUpdate = null;
		
		try{
			reportScheduleJob = (ReportScheduleJob)statusReportList.get(0);
			reportScheduleJob.setStatus("C");
			returnListUpdate = reportScheduleJobDao.updateStatusReportMonitoring(reportScheduleJob,criteria);	
			returnMap.put("ReportScheduleMonitoringListUpdate",returnListUpdate);
	        returnMap.put(ServiceConstants.STATUS,ServiceConstants.STATUS_SUCCESS);
	        
		}catch (Exception e) {
			e.printStackTrace();
			returnMap.put(ServiceConstants.STATUS,ServiceConstants.STATUS_ERROR);
			if (e instanceof ReportServiceException) {
				throw (ReportServiceException) e;
			} else {
				throw new ReportServiceException("Error TransactionBarCodeServiceImpl editTransactionBarCode");
			}
		}finally{
			reportScheduleJob = null;
		}
		return returnMap;
	}

	public List<ReportScheduleReportParameter> selectReportParameter(String reportId){
		return reportScheduleJobDao.selectReportParameter(reportId);
	}
	
	public void updateReportParameter(ReportScheduleReportParameter param){
		reportScheduleJobDao.updateReportParameter(param);
	}
	
	public HashMap searchReportNameByList(List<ReportScheduleJob> listJob) throws ReportServiceException {
		HashMap returnMap = new HashMap();
		List<ReportName> resultList = null;
		
		try {
			resultList = reportNameDao.searchReportNameBySchedule(listJob);
		    returnMap.put("REPORT_NAME_LIST", resultList);
			returnMap.put(ServiceConstants.STATUS, ServiceConstants.STATUS_SUCCESS);
	    } catch (Exception e) {
			e.printStackTrace();
			returnMap.put(ServiceConstants.STATUS,ServiceConstants.STATUS_ERROR);
			if (e instanceof ReportServiceException) {
				throw (ReportServiceException) e;
			} else {
				throw new ReportServiceException("Error ReportJobServiceImpl searchReportName");
			}
		} finally {
			resultList = null;
		}
		return returnMap;		

	}
}
