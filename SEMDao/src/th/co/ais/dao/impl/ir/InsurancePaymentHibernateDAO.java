package th.co.ais.dao.impl.ir;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.ir.InsurancePayment;
import th.co.ais.domain.rt.RentalPayment;

public class InsurancePaymentHibernateDAO extends AbstractHibernateDAO<InsurancePayment> {
	
	public InsurancePayment findByRowId(final String insurancePaymentId) throws DAOException {
		getHibernateTemplate().setCacheQueries(true);
		String query = "select distinct rp from InsurancePayment rp where rp.rowId = ? and rp.recordStatus = 'Y'";
		InsurancePayment insurancePayment = querySingleByHQL(query, insurancePaymentId);
		return insurancePayment;
	}
}
