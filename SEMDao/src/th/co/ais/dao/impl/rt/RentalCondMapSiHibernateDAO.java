package th.co.ais.dao.impl.rt;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.rt.RentalCondMapSi;

public class RentalCondMapSiHibernateDAO extends AbstractHibernateDAO<RentalCondMapSi>{

	public RentalCondMapSi findByRowId(final String rowId) throws DAOException {
		getHibernateTemplate().setCacheQueries(true);
		String query = "select distinct rcms from RentalCondMapSi rcms where rcms.rowId = ? and rcms.recordStatus = 'Y'";
		return querySingleByHQL(query, rowId);
	}
	
	@SuppressWarnings("unchecked")
	public List<RentalCondMapSi> queryRentalCondMapSi(final String rentalDetailId) throws DAOException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(RentalCondMapSi.class);
		
		if (StringUtils.isNotEmpty(rentalDetailId)) {
			criteria.add(Restrictions.like("rentalDetailId", rentalDetailId));
			criteria.add(Restrictions.like("recordStatus", "Y"));
		}
		
		return criteria.list();
	}
	
}
