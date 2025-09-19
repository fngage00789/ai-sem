package th.co.ais.dao.impl.ir;

import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.ir.Replacement;



public class ReplacementHibernateDAO extends AbstractHibernateDAO<Replacement>{
	
	public Replacement findByRowId(final String rowId) throws DAOException{
		getHibernateTemplate().setCacheQueries(true);
		Replacement rpl = querySingleByHQL("select distinct repl from Replacement repl where repl.rowId = ? ", rowId);
		return rpl;
	}
	
	public List<Replacement> queryReplacement(final Replacement replacement) throws DAOException {
		
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Replacement.class);
		
		if(replacement != null){
			if(StringUtils.isNotEmpty(replacement.getCompany())){
				criteria.add(Restrictions.like("company", "%" + replacement.getCompany() + "%"));
			}
			if(StringUtils.isNotEmpty(replacement.getNetworkType())){
				criteria.add(Restrictions.like("networkType", "%" + replacement.getNetworkType() + "%"));
			}
			if(StringUtils.isNotEmpty(replacement.getTransferType())){
				criteria.add(Restrictions.like("transferType", "%" + replacement.getTransferType() + "%"));
			}
			if(replacement.getEffDt() != null){
				criteria.add(Restrictions.like("effDt",  replacement.getEffDt() ));
			}
		}

		criteria.addOrder(Order.asc("rowId"));
		
		return criteria.list();
	}
	

}