package th.co.ais.dao.impl.rt;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.rt.RentalPayment;

public class RentalPaymentHibernateDAO extends AbstractHibernateDAO<RentalPayment>{
	
	public RentalPayment findByRowId(final String rentalPaymentId) throws DAOException {
		getHibernateTemplate().setCacheQueries(true);
		String query = "select distinct rp from RentalPayment rp where rp.rowId = ? and rp.recordStatus = 'Y'";
		RentalPayment rentalpayment = querySingleByHQL(query, rentalPaymentId);
		return rentalpayment;
	}
}
