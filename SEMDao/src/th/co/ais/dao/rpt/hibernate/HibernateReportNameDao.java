package th.co.ais.dao.rpt.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import th.co.ais.rpt.dao.IReportNameDao;
import th.co.ais.rpt.domain.ReportJob;
import th.co.ais.rpt.domain.ReportName;
import th.co.ais.rpt.domain.ReportScheduleJob;
import th.co.ais.rpt.service.ServiceConstants;

public class HibernateReportNameDao implements IReportNameDao, ServiceConstants{

	private static Log log = LogFactory.getLog(HibernateReportNameDao.class);

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<ReportName> searchReportNameByJob(List<ReportJob> listReportjob) throws DataAccessException {
		String cond = ""; 
		Session session =  sessionFactory.getCurrentSession();
		 Criteria criteria = session.createCriteria(ReportName.class);
		 for(ReportJob rpt:listReportjob){
			 cond = cond + "REPORT_TYPE_ID = '"+rpt.getReportTypeId()+"'"+" or ";
		 }
		 if(!cond.equals("")){
			 cond = cond.substring(0,cond.length()-3);
			 criteria.add(Restrictions.sqlRestriction(cond));
		 }
		 criteria.addOrder(Order.asc("rptTypeId"));
		return criteria.list();
	}

	public List<ReportName> searchReportNameBySchedule(List<ReportScheduleJob> listScheduleJob) throws DataAccessException {
		String cond = ""; 
		Session session =  sessionFactory.getCurrentSession();
		 Criteria criteria = session.createCriteria(ReportName.class);
		 for(ReportScheduleJob rpt:listScheduleJob){
			 cond = cond + "REPORT_TYPE_ID = '"+rpt.getReportTypeId()+"'"+" or ";
		 }
		 if(!cond.equals("")){
			 cond = cond.substring(0,cond.length()-3);
			 criteria.add(Restrictions.sqlRestriction(cond));
		 }
		 criteria.addOrder(Order.asc("rptTypeId"));
		return criteria.list();
	}
}
