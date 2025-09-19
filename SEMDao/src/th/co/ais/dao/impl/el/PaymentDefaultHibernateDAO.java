package th.co.ais.dao.impl.el;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.PaymentDefault;

public class PaymentDefaultHibernateDAO extends AbstractHibernateDAO<PaymentDefault> {
	
	public List<PaymentDefault> queryByCriteria(PaymentDefault paymentDefault,String sortBy,String sortType) throws DAOException{
		
		Session session = getSessionFactory().getCurrentSession();
		
		Criteria criteria = session.createCriteria(PaymentDefault.class);
		
		//criteria = criteria.createCriteria("meterInfos");
		if(paymentDefault != null){			
			if(StringUtils.isNotEmpty(paymentDefault.getContractNo())){
				criteria.add(Restrictions.like("contractNo", paymentDefault.getContractNo().toUpperCase()));
			}
			if(StringUtils.isNotEmpty(paymentDefault.getExpenseType())){
				criteria.add(Restrictions.like("expenseType", paymentDefault.getExpenseType()));
			}
			// add more
		}
		
		if(StringUtils.isNotEmpty(sortBy)){
			if("DESC".equalsIgnoreCase(sortType)){
				criteria.addOrder(Order.desc(sortBy));
			}else{
				criteria.addOrder(Order.asc(sortBy));
			}
		}
		
		return criteria.list();
	}
	
	public List<PaymentDefault> queryByExpenseType(String contractNo, String expenseType) throws DAOException{
		
		Session session = getSessionFactory().getCurrentSession();
		
		Criteria criteria = session.createCriteria(PaymentDefault.class);
		if(contractNo==null){
			criteria.add(Restrictions.like("contractNo", contractNo));
		}else{
			criteria.add(Restrictions.like("contractNo", contractNo.toLowerCase()));
		}	
		
		criteria.add(Restrictions.like("expenseType", expenseType));
		
		return criteria.list();
	}
}
