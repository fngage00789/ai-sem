package th.co.ais.dao.impl.si;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.si.Lessor;

public class SiteLessorHibernateDAO extends AbstractHibernateDAO<Lessor> {

	public List<Lessor> queryLessorBySiteInfoId(final String assignSiteInfoId) throws DAOException{
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Lessor.class);
		
		if(assignSiteInfoId != null){
				criteria.add(Restrictions.like("siteInfoId",  assignSiteInfoId));
				criteria.add(Restrictions.like("recordStatus",  "Y"));
		}
		criteria.addOrder(Order.asc("rowId"));
		
		return criteria.list();
	}

	public Lessor findByRowId(final String rowId) throws DAOException{
		getHibernateTemplate().setCacheQueries(true);
		Lessor siteLessor = querySingleByHQL("select distinct l from Lessor l where l.rowId = ? ", rowId);
		return siteLessor;
	}
	
//	public Lessor queryLessorInfoByRowId(String rowId) throws DAOException{
//		String sql = "SELECT sl.*, " +
//					 "(SELECT amp.thai_name " +
//					 "FROM slims.lu_amphur amp " +
//					 "WHERE amp.amphur_id = sl.amphur_id and rownum = 1) address2 ," +
//					 "(SELECT prv.thai_name " +
//					 "FROM slims.lu_province prv " +
//					 "WHERE prv.province_id = sl.province_id and rownum = 1) AS city " +
//					 "FROM sem_si_site_lessor sl  " +
//					 "WHERE sl.site_lessor_id = ? ";
//		Query query = getSession().createSQLQuery(sql).addEntity(Lessor.class);
//		if(query != null){
//			query.setString(0, rowId);
//		}
//		return (Lessor)query.uniqueResult();
//	}

}
