package th.co.ais.dao.rpt.hibernate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.dao.DataAccessException;

import th.co.ais.rpt.dao.IReportScheduleJobDao;
import th.co.ais.rpt.domain.ReportScheduleJob;
import th.co.ais.rpt.domain.ReportScheduleReportParameter;
import th.co.ais.rpt.parameter.SFRMO001ReportParameter;
import th.co.ais.rpt.service.ServiceConstants;

/**
 * @author Warawit
 *
 */
public class HibernateReportScheduleJobDao implements IReportScheduleJobDao, ServiceConstants{
	
	private static Log log = LogFactory.getLog(HibernateReportScheduleJobDao.class);

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void deleteReportScheduleJob(ReportScheduleJob reportScheduleJob) throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();
		session.delete(reportScheduleJob);
	}

	public ReportScheduleJob getReportScheduleJob(String jobId) throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();
		return (ReportScheduleJob) session.createCriteria(ReportScheduleJob.class).add(
				Restrictions.eq("jobId", jobId)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<ReportScheduleJob> getReportScheduleJob() throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(ReportScheduleJob.class).list();
	}

	public ReportScheduleJob getNewReportScheduleJobForStartBatch() throws DataAccessException {
		ReportScheduleJob ReportScheduleJob = null;
        List list = null;
        Session session = null;
        
        try {
             session = sessionFactory.getCurrentSession();
             list = session.createCriteria(ReportScheduleJob.class).
                    add(Restrictions.eq("status", IReportScheduleJobDao.STATUS_WAITING)).
                    add(Restrictions.le("jobSchedule", new Date())).
                    add(Restrictions.isNull("runOnServer")).
                    addOrder(org.hibernate.criterion.Order.asc("jobSchedule")).setMaxResults(1).list();
             log.debug("HibernateReportScheduleJobDao.getNewReportScheduleJobForStartBatch() : List = "+list.size());
             if(list != null && list.size() > 0){
            	 ReportScheduleJob = (ReportScheduleJob)list.get(0);
             }
        } catch (DataAccessException e) {
                throw e;
        } finally{
                list = null;
                session = null;
        }
        return ReportScheduleJob;
    }

	public ReportScheduleJob getNewReportScheduleJobForStartBatch(String reportTypeId) throws DataAccessException {
		ReportScheduleJob ReportScheduleJob = null;
        List list = null;
        Session session = null;
        try {
             session = sessionFactory.getCurrentSession();
             list = session.createCriteria(ReportScheduleJob.class).
             		add(Restrictions.eq("reportTypeId", reportTypeId)).
                    add(Restrictions.eq("status", IReportScheduleJobDao.STATUS_WAITING)).
                    add(Restrictions.le("jobSchedule", new Date())).
                    add(Restrictions.isNull("runOnServer")).
                    addOrder(org.hibernate.criterion.Order.asc("jobId")).setMaxResults(1).list();
             log.debug("HibernateReportScheduleJobDao.getNewReportScheduleJobForStartBatch() : List = "+list.size());
             if(list != null && list.size() > 0){
            	 ReportScheduleJob = (ReportScheduleJob)list.get(0);
             }
        } catch (DataAccessException e) {
                throw e;
        } finally{
                list = null;
                session = null;
        }
        return ReportScheduleJob;
    }
	
	public void updateReportScheduleJob(ReportScheduleJob ReportScheduleJob) throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();
		session.update(ReportScheduleJob);
	}
	
	@SuppressWarnings("unchecked")
	public List<ReportScheduleJob> getClearFailJobList(String serverName, String reportOverTimeMinutes, Set currentJobIdList) throws DataAccessException {
		List list = null;
		Calendar cal = null;
		try {
			cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.add(Calendar.MINUTE, (Integer.parseInt(reportOverTimeMinutes)*-1));
			Session session = sessionFactory.getCurrentSession();
			if(currentJobIdList!=null && currentJobIdList.size()>0){
				list = session.createCriteria(ReportScheduleJob.class).add(
						Restrictions.eq("runOnServer", serverName)).add(
							Restrictions.eq("status", IReportScheduleJobDao.STATUS_RUNNING)).add(
									Restrictions.not(Restrictions.in("jobId", currentJobIdList))).add(
											Restrictions.le("startDt", cal.getTime())).addOrder(
										org.hibernate.criterion.Order.asc("jobId")).setMaxResults(10).list();	
			}else{
				list = session.createCriteria(ReportScheduleJob.class).add(
						Restrictions.eq("runOnServer", serverName)).add(
							Restrictions.eq("status", IReportScheduleJobDao.STATUS_RUNNING)).add(
											Restrictions.le("startDt", cal.getTime())).addOrder(
										org.hibernate.criterion.Order.asc("jobId")).setMaxResults(10).list();	
			}	
		} catch (DataAccessException e) {
			throw e;
		} finally{
			cal = null;
		}
		return list;
	}	
	
	public int countWaitJobScheduleWithReportTypeId(String reportTypeId) throws DataAccessException {
		int count = 0;
		Session session = null;
		List list = null;
		try {
			session = sessionFactory.getCurrentSession();
			list = session.createCriteria(ReportScheduleJob.class).
				setProjection(Projections.rowCount()).
				add(Restrictions.eq("reportTypeId", reportTypeId)).
				add(Restrictions.eq("status", IReportScheduleJobDao.STATUS_WAITING)).
				add(Restrictions.le("jobSchedule", new Date())).
				add(Restrictions.isNull("runOnServer")).list();
			if(list!=null && list.size()>0){
				count = ((Integer)list.get(0)).intValue();
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw e;
		} finally{
			session = null;
			list = null;
		}
		return count;
		
	}

	public void insertReportScheduleJob(ReportScheduleJob reportScheduleJob) throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();
		session.save(reportScheduleJob);
	}
	
	public List searchReportMonitoringByCriteria(SFRMO001ReportParameter criteria) throws DataAccessException {
		int index = 0;
		Iterator iter = null;
		List returnList = null;
		List ReportMonitoringList = null;
		Query query = null;
		ReportScheduleJob reportScheduleJob = null;
		String sql = null;
		Session session = null;
		

		try{
			session = sessionFactory.getCurrentSession();
			
			sql = " SELECT JOB_ID jobId, REPORT_TYPE_ID reportTypeId , REPORT_EXPORT_FILE_PATH  reportExportFilePath, STATUS status, " +
		    	  " REQUEST_BY requestBy , REQUEST_DT requestDt , START_DT startDt, END_DT endDt , REMARK  remark , JOB_SCHEDULE jobSchedule" + 
		    	  " FROM SFFADM.SFF_REPORT_SCHEDULE_JOB" +
		    	  " WHERE 1=1 ";
			
			if(criteria.getRequestDateFrom() != null)
		       //sql += " AND TRUNC(REQUEST_DT) >= TRUNC(TO_DATE(?, 'DD/MM/YYYY', 'NLS_CALENDAR=GREGORIAN'))";	
			   sql += " AND cast(REQUEST_DT as date) >= (TO_DATE(?, 'DD/MM/YYYY'))";	
		    if(criteria.getRequestDateTo() != null)
		       //sql += " AND TRUNC(REQUEST_DT) <= TRUNC(TO_DATE(?, 'DD/MM/YYYY', 'NLS_CALENDAR=GREGORIAN'))";
		       sql += " AND cast(REQUEST_DT as date) <= (TO_DATE(?, 'DD/MM/YYYY'))";
		    if(criteria.getScheduleDateFrom() != null)
		       //sql += " AND TRUNC(JOB_SCHEDULE) >= TRUNC(TO_DATE(?, 'DD/MM/YYYY', 'NLS_CALENDAR=GREGORIAN'))";
		       sql += " AND cast(JOB_SCHEDULE as date) >= (TO_DATE(?, 'DD/MM/YYYY'))";
		    if(criteria.getScheduleDateTo() != null)
		       //sql += " AND TRUNC(JOB_SCHEDULE) <= TRUNC(TO_DATE(?, 'DD/MM/YYYY', 'NLS_CALENDAR=GREGORIAN'))";
		       sql += " AND cast(JOB_SCHEDULE as date) <= (TO_DATE(?, 'DD/MM/YYYY'))";
		    if(criteria.getStatus() != null && !"".equals(criteria.getStatus().trim()))
		       sql += "AND STATUS = ? ";		    
		    if(criteria.getUserName() != null && !"".equals(criteria.getUserName().trim()))
		       sql += "AND UPPER(REQUEST_BY) LIKE ? ";
		    
		    sql += "ORDER BY reportTypeId, requestDt DESC";
		    
		    query = session.createSQLQuery(sql).
		    		addScalar("jobId",Hibernate.STRING).
		            addScalar("reportTypeId",Hibernate.STRING).
		            addScalar("reportExportFilePath",Hibernate.STRING).
		            addScalar("status",Hibernate.STRING).
		            addScalar("requestBy",Hibernate.STRING).
		            addScalar("requestDt",Hibernate.TIMESTAMP).
		            addScalar("startDt",Hibernate.TIMESTAMP).
		            addScalar("endDt",Hibernate.TIMESTAMP).
		            addScalar("remark",Hibernate.STRING).
		            addScalar("jobSchedule",Hibernate.TIMESTAMP);
		     		    
		    if(criteria.getRequestDateFrom() != null)
		       query.setString(index++, criteria.getRequestDateFrom());
		    if(criteria.getRequestDateTo() != null)
		       query.setString(index++, criteria.getRequestDateTo());
		    if(criteria.getScheduleDateFrom() != null)
		       query.setString(index++, criteria.getScheduleDateFrom());
		    if(criteria.getScheduleDateTo() != null)
		       query.setString(index++, criteria.getScheduleDateTo());
		    if(criteria.getStatus() != null && !"".equals(criteria.getStatus().trim()))
		       query.setString(index++, criteria.getStatus().trim());
		    if(criteria.getUserName() != null && !"".equals(criteria.getUserName().trim()))
			   query.setString(index++, "%"+criteria.getUserName().toUpperCase().trim()+"%");
				    
		    returnList = query.setResultTransformer(Transformers.aliasToBean(ReportScheduleJob.class)).list();
		    if(returnList != null && returnList.size() > 0){
				  ReportMonitoringList = new ArrayList();
			      for(iter=returnList.iterator();iter.hasNext();){
			    	  reportScheduleJob = (ReportScheduleJob)iter.next();
			    	  if(reportScheduleJob.getStatus() != null && !"".equals(reportScheduleJob.getStatus())){
			    		  if(reportScheduleJob.getStatus().equals(REPORT_STATUS_CODE_WAITING))
			    			  reportScheduleJob.setStatus(REPORT_STATUS_DESC_WAITING);
			    		  if(reportScheduleJob.getStatus().equals(REPORT_STATUS_CODE_RUNNING))
			    			  reportScheduleJob.setStatus(REPORT_STATUS_DESC_RUNNING);
			    		  if(reportScheduleJob.getStatus().equals(REPORT_STATUS_CODE_SUCCESS))
			    			  reportScheduleJob.setStatus(REPORT_STATUS_DESC_SUCCESS);
			    		  if(reportScheduleJob.getStatus().equals(REPORT_STATUS_CODE_FAIL))
			    			  reportScheduleJob.setStatus(REPORT_STATUS_DESC_FAIL);
			    		  if(reportScheduleJob.getStatus().equals(REPORT_STATUS_CODE_CANCEL))
			    			  reportScheduleJob.setStatus(REPORT_STATUS_DESC_CANCEL);
			    	  }
//			    	  if(reportScheduleJob.getReportExportFilePath() != null && !"".equals(reportScheduleJob.getReportExportFilePath())){
//			    		  String filePath = reportScheduleJob.getReportExportFilePath();
//			    		  String fileName = filePath.substring(filePath.lastIndexOf("/")+1,filePath.length());
//			    		  reportScheduleJob.setReportExportFilePath(fileName);			    		  
//			    	  }
			    	  ReportMonitoringList.add(reportScheduleJob);
			      }
			   }
		    log.debug("returnList.size() : "+returnList.size());
		    
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			sql = null;
			session = null;
			query = null;
		}
		return ReportMonitoringList;
	}
	
	public List updateStatusReportMonitoring(ReportScheduleJob reportScheduleJob, SFRMO001ReportParameter criteria) throws DataAccessException {
		List returnListUpdate = null;
		Query query = null;
		String sql = null;
		Session session = null;

		try{
			session = sessionFactory.getCurrentSession();
			sql = " UPDATE SFFADM.SFF_REPORT_SCHEDULE_JOB SET STATUS = ? " +
		    	  " WHERE JOB_ID = ? ";

		    query = session.createSQLQuery(sql);
		    query.setString(0, reportScheduleJob.getStatus());
		    query.setString(1, reportScheduleJob.getJobId());
		    query.executeUpdate();
		    
		    returnListUpdate = searchReportMonitoringByCriteria(criteria);
		    
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw e;
		} finally {
			sql = null;
			session = null;
			query = null;
		}
		return returnListUpdate;
	}

	public List<ReportScheduleReportParameter> selectReportParameter(String reportId) {
		Session session = null;
		List<ReportScheduleReportParameter> l = null;
		try{
			session = sessionFactory.getCurrentSession();
			l = session.createCriteria(ReportScheduleReportParameter.class)
			.add(Restrictions.eq("reportTypeId",reportId))
			.list();
		}catch(Exception e){}
		return l;
	}
	
	public void updateReportParameter(ReportScheduleReportParameter param) {
		Session session = null;
		Query query = null;
		String sql = null;
		try{
			session = sessionFactory.getCurrentSession();
			
			sql = "UPDATE SFFADM.SFF_REPORT_PARAMETER SET " +
				  "parameter_value = to_char(to_date(?,'dd/mm/yyyy')+1,'dd/mm/yyyy'), " +
				  "last_upd = SYSDATE ,"+
				  "last_upd_by = 'SYSTEM'"+
				  " WHERE REPORT_TYPE_ID = ? AND PARAMETER_ID = ?";
			query = session.createSQLQuery(sql);
			query.setString(0,param.getParamValue());
			query.setString(1,param.getReportTypeId());
			query.setString(2,param.getParamId());
			query.executeUpdate();
			    
		}catch(Exception e){}
		finally{
			sql = null;
			session = null;
			query = null;
		}
	}
}
