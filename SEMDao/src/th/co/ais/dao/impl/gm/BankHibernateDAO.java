package th.co.ais.dao.impl.gm;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.gm.Bank;

public class BankHibernateDAO extends AbstractHibernateDAO<Bank>{
	
	
	public Bank findByBankCode(final String bankCode) throws DAOException {
		String hql = "FROM Bank b WHERE b.bankCode = ? and b.recordStatus = 'Y'";
		return querySingleByHQL(hql, bankCode);
	}
	
	
	public List<Bank> queryBank(final Bank bank) throws DAOException {
		
		Criteria criteria = getSession().createCriteria(Bank.class);
		if(bank != null){
			if(StringUtils.isNotEmpty(bank.getBankCode())){
				criteria.add(Restrictions.like("bankCode", bank.getBankCode().replace("*", "%")));
			}
			if(StringUtils.isNotEmpty(bank.getBankName())){
				criteria.add(Restrictions.like("bankName", bank.getBankName().replace("*", "%")));
			}
		}
		criteria.addOrder(Order.asc("rowId"));
		return criteria.list();
	}
	
}
