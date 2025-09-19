package th.co.ais.dao.impl.rt;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.rt.ReturnDeposit;

public class ReturnDepositHibernateDAO extends AbstractHibernateDAO<ReturnDeposit> {

	public ReturnDeposit findByRowId(final String rowId) throws DAOException {
		getHibernateTemplate().setCacheQueries(true);
		String query = "select distinct returnDeposit from ReturnDeposit returnDeposit where returnDeposit.rowId = ? and returnDeposit.recordStatus = 'Y'";
		return querySingleByHQL(query, rowId);
	}
}
