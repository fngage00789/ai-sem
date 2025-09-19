package th.co.ais.dao.impl.el;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.WarrantMaster;

public class WarrantMasterHibernateDAO extends AbstractHibernateDAO<WarrantMaster> {

	public WarrantMaster findByRowId(final String rowId) throws DAOException{
		
		getHibernateTemplate().setCacheQueries(true);
		
		return querySingleByHQL("select distinct warrantMaster from WarrantMaster warrantMaster where warrantMaster.rowId = ? ", rowId);
	}
	
	@SuppressWarnings("unchecked")
	public List<WarrantMaster> findByManagement(final Management manage) throws DAOException {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(WarrantMaster.class);
		criteria.add(Restrictions.eq("company", manage.getCompany()));
		criteria.add(Restrictions.eq("electricUseType", manage.getElectricUseType()));
		criteria.add(Restrictions.eq("recordStatus", manage.getRecordStatus()));
		criteria.addOrder(Order.asc("rowId"));
		
		return criteria.list();
	}
	
}
