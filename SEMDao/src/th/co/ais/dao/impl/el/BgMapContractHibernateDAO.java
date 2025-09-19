package th.co.ais.dao.impl.el;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.el.BgMapContract;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.ManagementSP;

public class BgMapContractHibernateDAO extends AbstractHibernateDAO<BgMapContract> {

	@SuppressWarnings("unchecked")
	public List<BgMapContract> queryAllBgMapContract() throws DAOException{
		
		Session session = getSessionFactory().getCurrentSession();
		
		Criteria criteria = session.createCriteria(BgMapContract.class);
		
		return criteria.list();
	}	
	
	public BgMapContract findByRowId(final String rowId) throws DAOException{
		
		getHibernateTemplate().setCacheQueries(true);
		
		return querySingleByHQL("select distinct bgMapContract from BgMapContract bgMapContract where bgMapContract.rowId = ? ", rowId);
	}
	
	@SuppressWarnings("unchecked")
	public List<BgMapContract> findByManagement(final Management manage) throws DAOException {
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(BgMapContract.class);
		criteria.add(Restrictions.eq("electricId", manage));
		criteria.add(Restrictions.eq("recordStatus", "Y"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.addOrder(Order.asc("rowId"));
		
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<BgMapContract> findByManagement(final ManagementSP manage) throws DAOException {
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(BgMapContract.class);
		criteria.add(Restrictions.eq("electricId", manage));
		criteria.add(Restrictions.eq("recordStatus", "Y"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.addOrder(Order.asc("rowId"));
		
		return criteria.list();
	}
	
}
