package th.co.ais.dao.impl.ir;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.ir.PolicyDtl;

public class PolicyDtlHibernateDAO extends AbstractHibernateDAO<PolicyDtl>{
	
	public PolicyDtl findByRowId(final String rowId) throws DAOException{
		getHibernateTemplate().setCacheQueries(true);
		PolicyDtl pDtl = querySingleByHQL("select distinct pDtl from PolicyDtl pDtl where pDtl.rowId = ? ", rowId);
		return pDtl;
	}
	
	public List<PolicyDtl> queryPolicy(final PolicyDtl policy) throws DAOException {
		
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(PolicyDtl.class);
		
		if(policy != null){
//			if(StringUtils.isNotEmpty(p.getCompany())){
//				criteria.add(Restrictions.like("company", "%" + replacement.getCompany() + "%"));
//			}
		}

		criteria.addOrder(Order.asc("rowId"));
		
		return criteria.list();
	}
}
