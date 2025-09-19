package th.co.ais.dao.impl.pt;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.pt.PtaxPayment;

public class PTaxPaymentHibernateDAO extends AbstractHibernateDAO<PtaxPayment>{

		public PtaxPayment findByRowId(final String rowId)throws DAOException{
			getHibernateTemplate().setCacheQueries(true);
			String query = "select distinct ptPay from PtaxPayment ptPay where ptPay.rowId = ? and ptPay.recordStatus = 'Y'";
			return querySingleByHQL(query, rowId);
		}
}
