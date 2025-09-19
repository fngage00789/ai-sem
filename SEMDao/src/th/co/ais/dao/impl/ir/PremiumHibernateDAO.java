package th.co.ais.dao.impl.ir;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.ir.Premium;

public class PremiumHibernateDAO extends AbstractHibernateDAO<Premium> {

	public Premium findByRowId(final String rowId) throws DAOException {
		getHibernateTemplate().setCacheQueries(true);
		Premium premium = querySingleByHQL("select distinct pre from Premium pre where pre.rowId = ? ", rowId);
		return premium;
	}
	
}
