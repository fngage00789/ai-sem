package th.co.ais.dao.impl.si;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.si.RentCond;

public class SiteRentCondHibernateDAO extends AbstractHibernateDAO<RentCond> {

	public List<RentCond> queryRentCondBySiteInfoId(String assignSiteInfoId) throws DAOException{
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(RentCond.class);
		
		if(assignSiteInfoId != null){
				criteria.add(Restrictions.like("siteInfoId",  assignSiteInfoId));
				criteria.add(Restrictions.like("recordStatus", "Y"));
		}
		criteria.addOrder(Order.asc("rowId"));
		
		return criteria.list();
	}

	public RentCond findByRowId(final String rowId) throws DAOException{
		String hql = "SELECT DISTINCT rentCond FROM RentCond rentCond WHERE rentCond.rowId = ?";
		return querySingleByHQL(hql, rowId);
	}

	public List<RentCond> queryRentCondBySiteInfoIdAndRentCondType(
			String siteInfoId, String rentCondType) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(RentCond.class);
		
		if(siteInfoId != null){
				criteria.add(Restrictions.like("siteInfoId",  siteInfoId));
		}
		if(rentCondType != null){
			criteria.add(Restrictions.like("rentCondType",  rentCondType));
		}
		criteria.add(Restrictions.like("recordStatus", "Y"));
		criteria.addOrder(Order.asc("rowId"));
		
		return criteria.list();
	}

}
