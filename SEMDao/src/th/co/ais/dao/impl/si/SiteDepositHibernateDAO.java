package th.co.ais.dao.impl.si;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.si.Deposit;

public class SiteDepositHibernateDAO extends AbstractHibernateDAO<Deposit> {

	public List<Deposit> queryDepositBySiteInfoId(final String assignSiteInfoId) throws DAOException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Deposit.class);
		
		if(assignSiteInfoId != null){
				criteria.add(Restrictions.like("siteInfoId",  assignSiteInfoId));
				criteria.add(Restrictions.like("recordStatus", "Y"));
		}
		criteria.addOrder(Order.asc("rowId"));
		
		return criteria.list();
	}

	public Deposit findByRowId(final String rowId) throws DAOException {
		String hql = "SELECT DISTINCT deposit FROM Deposit deposit WHERE deposit.rowId = ? and deposit.recordStatus = 'Y'";
		return querySingleByHQL(hql, rowId);
	}

	public List<Deposit> queryDepositBySiteInfoIdAndDepositCondType(
			String siteInfoId, String depositCondType) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Deposit.class);
		
		if(siteInfoId != null){
				criteria.add(Restrictions.like("siteInfoId",  siteInfoId));
		}
		if(depositCondType != null){
			criteria.add(Restrictions.like("depositCondType",  depositCondType));
		}
		criteria.add(Restrictions.like("recordStatus", "Y"));
		criteria.addOrder(Order.asc("rowId"));
		
		return criteria.list();
	}

}
