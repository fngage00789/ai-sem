package th.co.ais.service.impl.rpt;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import th.co.ais.rpt.batch.jmx.IReportJMX;
import th.co.ais.rpt.dao.IReportJobDao;
import th.co.ais.rpt.dao.IReportNameDao;
import th.co.ais.rpt.domain.ReportJob;
import th.co.ais.rpt.domain.ReportName;
import th.co.ais.rpt.exception.ReportServiceException;
import th.co.ais.rpt.parameter.ReportParameter;
import th.co.ais.rpt.parameter.SFRMO001ReportParameter;
import th.co.ais.rpt.service.IReportJobService;
import th.co.ais.rpt.service.IReportServiceHelper;
import th.co.ais.rpt.service.ServiceConstants;



public class ReportJobServiceImpl implements IReportJobService {
	
	private IReportJobDao reportJobDao;
	private IReportServiceHelper reportServiceHelper;
	private IReportNameDao reportNameDao;
		
	
	public IReportNameDao getReportNameDao() {
		return reportNameDao;
	}


	public void setReportNameDao(IReportNameDao reportNameDao) {
		this.reportNameDao = reportNameDao;
	}


	public void setReportJobDao(IReportJobDao reportJobDao) {
		this.reportJobDao = reportJobDao;
	}


	public void setReportServiceHelper(IReportServiceHelper reportServiceHelper) {
		this.reportServiceHelper = reportServiceHelper;
	}


	public void createReportJob(String reportTypeId, Date jobSchedule, ReportParameter reportParameter, String requestBy, String reportExportType) throws ReportServiceException{
		ReportJob reportJob = null;
		try {
			reportJob = new ReportJob();
			reportJob.setJobSchedule(jobSchedule);
			reportJob.setReportExportType(reportExportType);
			reportJob.setReportParam(reportServiceHelper.genParamXMl(reportTypeId, reportParameter));
			reportJob.setReportTypeId(reportTypeId);
			reportJob.setRequestBy(requestBy);
			reportJob.setRequestDt(new Date());
			reportJob.setStatus(IReportJobDao.STATUS_WAITING);
			reportJobDao.insertReportJob(reportJob);
		} catch (Exception e) {
			if(e instanceof ReportServiceException){
				throw (ReportServiceException)e;
			}else{
				throw new ReportServiceException("Error Create Report Job");
			}				
		} finally{
			
		}
	}
	
	public void updateEndRunReport(String job_id, boolean successFlag, String errorMessage, String filePath) {
		
		ReportJob ReportJob = null;
		
		try {
			//update end date & status of Report_Job S or F
			ReportJob = reportJobDao.getReportJob(job_id);
			ReportJob.setEndDt(new Date());
			if(successFlag){
				ReportJob.setStatus(IReportJobDao.STATUS_SUCCESS);
			}else{
				ReportJob.setStatus(IReportJobDao.STATUS_FAIL);
				ReportJob.setRemark(errorMessage);
			}
			if(filePath!=null && filePath.length()>0){
				ReportJob.setReportExportFilePath(filePath);	
			}
			
			reportJobDao.updateReportJob(ReportJob);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReportJob = null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public void clearFailJob(String serverName, String reportOverTimeMinutes, IReportJMX proxyReportJMX){
		
		List<ReportJob> failJobList = null;
		ReportJob ReportJob = null;
		Date now = null;
		
		try {
			now = new Date();
			if(proxyReportJMX!=null && proxyReportJMX.getCurrentJobId()!=null && proxyReportJMX.getCurrentJobId().size()>0){
				failJobList = reportJobDao.getClearFailJobList(serverName, reportOverTimeMinutes, proxyReportJMX.getCurrentJobId().keySet());	
			}else{
				failJobList = reportJobDao.getClearFailJobList(serverName, reportOverTimeMinutes, null);
			}
			if(failJobList!=null && failJobList.size()>0){
				for(Iterator<ReportJob> iter = failJobList.iterator();iter.hasNext();){
					ReportJob = iter.next();
					ReportJob.setEndDt(now);
					ReportJob.setStatus(IReportJobDao.STATUS_FAIL);
					ReportJob.setRemark(IReportJobDao.REMARK_CLEAR_FAIL_JOB);
					reportJobDao.updateReportJob(ReportJob);
				}	
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReportJob = null;
			now = null;
			failJobList = null;
		}
	}	
	
	public ReportJob getReportJob(String jobId){
		
		ReportJob ReportJob = null;
		
		try {
			ReportJob = reportJobDao.getReportJob(jobId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ReportJob;
	}
	
	public HashMap searchReportMonitoring(SFRMO001ReportParameter criteria) throws ReportServiceException {
		HashMap returnMap = new HashMap();
		List resultList = null;

		try {
			resultList = reportJobDao.searchReportMonitoringByCriteria(criteria);
		    returnMap.put("REPORT_MONITORING_LIST", resultList);
			returnMap.put(ServiceConstants.STATUS, ServiceConstants.STATUS_SUCCESS);
	    } catch (Exception e) {
			e.printStackTrace();
			returnMap.put(ServiceConstants.STATUS,ServiceConstants.STATUS_ERROR);
			if (e instanceof ReportServiceException) {
				throw (ReportServiceException) e;
			} else {
				throw new ReportServiceException("Error ReportMonitoringServiceImpl searchReportMonitoring");
			}
		} finally {
			resultList = null;
		}
		return returnMap;		
	}
	
	public HashMap updateStatusReportMonitoring(List statusReportList,SFRMO001ReportParameter criteria) throws ReportServiceException {
		HashMap returnMap = new HashMap();
		ReportJob reportJob = null;
		List returnListUpdate = null;
		
		try{
			reportJob = (ReportJob)statusReportList.get(0);
			reportJob.setStatus("C");
			returnListUpdate = reportJobDao.updateStatusReportMonitoring(reportJob,criteria);	
			returnMap.put("ReportMonitoringListUpdate",returnListUpdate);
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
			reportJob = null;
		}
		return returnMap;
	}


	public HashMap searchReportNameByList(List<ReportJob> listJob) throws ReportServiceException {
		HashMap returnMap = new HashMap();
		List<ReportName> resultList = null;
		
		try {
			resultList = reportNameDao.searchReportNameByJob(listJob);
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


	// added by.. YUT 2015/09/14
	@Override
	public byte[] doExportExcelMSA003(Map<String, Object> paramMap) throws DataAccessException, SQLException {
		byte[] bytes = null;
		bytes = reportJobDao.callExportExcelMSA003(paramMap);
		
		return bytes;
	}
		
}
