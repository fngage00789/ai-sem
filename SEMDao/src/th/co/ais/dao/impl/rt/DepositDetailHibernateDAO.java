package th.co.ais.dao.impl.rt;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.rt.DepositDetail;

public class DepositDetailHibernateDAO extends AbstractHibernateDAO<DepositDetail> {

	public DepositDetail findByRowId(final String rowId) throws DAOException {
		getHibernateTemplate().setCacheQueries(true);
		String query = "select distinct dpstDetail from DepositDetail dpstDetail where dpstDetail.rowId = ? and dpstDetail.recordStatus = 'Y'";
		return querySingleByHQL(query, rowId);
	}
	
}
