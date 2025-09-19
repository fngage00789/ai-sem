package th.co.ais.dao.impl.ir;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.ir.Deduct;

public class DeductibleHibernateDAO extends AbstractHibernateDAO<Deduct>{
	
	public Deduct findByRowId(final String rowId) throws DAOException{
		getHibernateTemplate().setCacheQueries(true);
		Deduct deduct = querySingleByHQL("select distinct dct from Deduct dct where dct.rowId = ? ", rowId);
		return deduct;
	}
	
	public List<Deduct> queryDeductible(final Deduct deduct) throws DAOException {
		
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Deduct.class);
		
		if(deduct != null){
			if(StringUtils.isNotEmpty(deduct.getCompany())){
				criteria.add(Restrictions.like("company", "%" + deduct.getCompany() + "%"));
			}
			if(StringUtils.isNotEmpty(deduct.getNetworkType())){
				criteria.add(Restrictions.like("networkType", "%" + deduct.getNetworkType() + "%"));
			}
			if(StringUtils.isNotEmpty(deduct.getTransferType())){
				criteria.add(Restrictions.like("transferType", "%" + deduct.getTransferType() + "%"));
			}
			if(StringUtils.isNotEmpty(deduct.getLossType())){
				criteria.add(Restrictions.like("lossType", "%" + deduct.getLossType() + "%"));
			}
			if(deduct.getEffDt() != null){
				criteria.add(Restrictions.like("effDt",  deduct.getEffDt() ));
			}
		}

		criteria.addOrder(Order.asc("rowId"));
		
		return criteria.list();
	}
}
