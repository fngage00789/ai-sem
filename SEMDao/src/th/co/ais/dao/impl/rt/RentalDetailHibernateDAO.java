package th.co.ais.dao.impl.rt;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.rt.RentalDetail;

public class RentalDetailHibernateDAO extends AbstractHibernateDAO<RentalDetail> {
	
	public RentalDetail findByRowId(final String rowId) throws DAOException {
		getHibernateTemplate().setCacheQueries(true);
		String query = "select distinct rentDetail from RentalDetail rentDetail where rentDetail.rowId = ? and rentDetail.recordStatus = 'Y'";
		return querySingleByHQL(query, rowId);
	}
	
}
