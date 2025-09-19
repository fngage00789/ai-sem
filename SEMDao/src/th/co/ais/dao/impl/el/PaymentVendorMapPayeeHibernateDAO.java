package th.co.ais.dao.impl.el;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.el.PaymentVendorMapPayee;

public class PaymentVendorMapPayeeHibernateDAO extends AbstractHibernateDAO<PaymentVendorMapPayee> {

	@SuppressWarnings("unchecked")
	public List<PaymentVendorMapPayee> queryPaymentVendorMapPayeeByCodeStatus(final PaymentVendorMapPayee manage) throws DAOException {
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(PaymentVendorMapPayee.class);
		
		if(manage != null){
			
			if(StringUtils.isNotEmpty(manage.getExpenseCode())){
				
				criteria.add(Restrictions.eq("EXPENSE_CODE",manage.getExpenseCode()));
				criteria.add(Restrictions.eq("RECORD_STATUS", manage.getRecordStatus()));
			}
		}

		criteria.addOrder(Order.asc("rowId"));
		
		return criteria.list();
	}
}
