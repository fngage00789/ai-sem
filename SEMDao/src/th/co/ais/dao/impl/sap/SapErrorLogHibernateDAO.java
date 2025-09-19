package th.co.ais.dao.impl.sap;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.sap.SapErrorLog;

public class SapErrorLogHibernateDAO extends AbstractHibernateDAO<SapErrorLog> {
		
	public SapErrorLog findByRowId(final String rowId)throws DAOException{
		getHibernateTemplate().setCacheQueries(true);
		String query = "select distinct sapLog from SapErrorLog sapLog where sapLog.rowId = ? and sapLog.recordStatus = 'Y'";
		return querySingleByHQL(query, rowId);
	}
}
