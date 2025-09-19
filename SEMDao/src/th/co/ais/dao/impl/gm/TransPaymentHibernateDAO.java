package th.co.ais.dao.impl.gm;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.gm.TransPayment;

public class TransPaymentHibernateDAO extends AbstractHibernateDAO<TransPayment> {
	
	@SuppressWarnings("unchecked")
	public List<TransPayment> queryTransPayment(final TransPayment filter) throws DAOException{
		Session session = getSessionFactory().getCurrentSession();
		Criteria c = session.createCriteria(TransPayment.class);
		if(null!=filter){
			if(filter.getTransPaymentId()!=null && filter.getTransPaymentId().length()>0)
				c.add(Restrictions.eq("transPaymentId", filter.getTransPaymentId()));
		}
		c.addOrder(Order.asc("transPaymentId"));		
		return c.list();
	}
	
	public TransPayment findById(final String transPaymentId) throws DAOException {
		String hql = "FROM TransPayment tp WHERE tp.transPaymentId = ?";
		return querySingleByHQL(hql, transPaymentId);
	}
}
