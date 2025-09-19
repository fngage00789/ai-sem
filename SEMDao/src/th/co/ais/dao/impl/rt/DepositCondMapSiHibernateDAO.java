package th.co.ais.dao.impl.rt;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.rt.DepositCondMapSi;

public class DepositCondMapSiHibernateDAO extends AbstractHibernateDAO<DepositCondMapSi> {

	public DepositCondMapSi findByRowId(final String rowId) throws DAOException {
		getHibernateTemplate().setCacheQueries(true);
		String query = "select distinct dpstCondMapSi from DepositCondMapSi dpstCondMapSi where dpstCondMapSi.rowId = ? and dpstCondMapSi.recordStatus = 'Y'";
		return querySingleByHQL(query, rowId);
	}
	
	@SuppressWarnings("unchecked")
	public List<DepositCondMapSi> queryDepositCondMapSi(final String depositDetailId) throws DAOException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(DepositCondMapSi.class);
		
		if (StringUtils.isNotEmpty(depositDetailId)) {
			criteria.add(Restrictions.like("depositDetailId", depositDetailId));
			criteria.add(Restrictions.like("recordStatus", "Y"));
		}
		
		return criteria.list();
	}
	
}
