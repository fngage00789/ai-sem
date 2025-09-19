package th.co.ais.dao.impl.si;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.si.SiteInfoMapLoc;

public class SiteInfoMapLocHibernateDAO extends AbstractHibernateDAO<SiteInfoMapLoc> {
	
	
	public List<SiteInfoMapLoc> querySiteInfoMapLoc(final SiteInfoMapLoc siteInfoMapLoc) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(SiteInfoMapLoc.class);
		
		if (siteInfoMapLoc != null) {
			if (siteInfoMapLoc.getLocationId() != null) {
				criteria.add(Restrictions.like("locationId", siteInfoMapLoc.getLocationId()));
			}
		}
		criteria.addOrder(Order.asc("rowId"));
		return criteria.list();
	}

	public SiteInfoMapLoc findByRowId(String rowId) throws DAOException{
		String hql = "SELECT DISTINCT site FROM SiteInfoMapLoc site WHERE site.rowId = ?";
		return querySingleByHQL(hql, rowId);
	}

}
