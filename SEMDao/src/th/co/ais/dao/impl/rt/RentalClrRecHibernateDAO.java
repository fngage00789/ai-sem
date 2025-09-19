package th.co.ais.dao.impl.rt;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.rt.RentalClrRec;

public class RentalClrRecHibernateDAO extends AbstractHibernateDAO<RentalClrRec> {
	
	public RentalClrRec findByRowId(final String rowId) throws DAOException {
		getHibernateTemplate().setCacheQueries(true);
		String query = "select distinct rentalClr from RentalClrRec rentalClr where rentalClr.rowId = ? and rentalClr.recordStatus = 'Y'";
		return querySingleByHQL(query, rowId);
	}

}
