package th.co.ais.dao.impl.si;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.si.SubRent;

public class SiteSubRentHibernateDAO extends AbstractHibernateDAO<SubRent> {

	public List<SubRent> querySubRentBySiteInfoId(String assignSiteInfoId) throws DAOException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(SubRent.class);
		
		if(assignSiteInfoId != null){
				criteria.add(Restrictions.like("siteInfoId",  assignSiteInfoId));
				criteria.add(Restrictions.like("recordStatus", "Y"));
		}
		
		criteria.addOrder(Order.asc("rowId"));
		
		return criteria.list();
	}

	public SubRent findByRowId(final String rowId) throws DAOException{
		String hql = "SELECT DISTINCT subRent FROM SubRent subRent WHERE subRent.rowId = ?";
		return querySingleByHQL(hql, rowId);
	}

}
