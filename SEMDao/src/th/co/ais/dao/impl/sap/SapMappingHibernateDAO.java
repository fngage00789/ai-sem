package th.co.ais.dao.impl.sap;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.sap.SapMapping;

public class SapMappingHibernateDAO extends AbstractHibernateDAO<SapMapping> {
	
	@SuppressWarnings("unchecked")
	public List<SapMapping> querySapMapping(final SapMapping filter) throws DAOException{
		Session session = getSessionFactory().getCurrentSession();
		Criteria c = session.createCriteria(SapMapping.class);
		if(null!=filter){
			if(filter.getTemplateId()!=null && filter.getTemplateId().length()>0)
				c.add(Restrictions.eq("templateId", filter.getTemplateId()));
		}
		c.addOrder(Order.asc("templateId"))
		 .addOrder(Order.asc("sequence"));		
		return c.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<SapMapping> querySapMapping(final String templateId) throws DAOException{
		Session session = getSessionFactory().getCurrentSession();
		Criteria c = session.createCriteria(SapMapping.class);
		if(null!=templateId){
			c.add(Restrictions.eq("templateId", templateId));
		}
		c.addOrder(Order.asc("templateId"))
		 .addOrder(Order.asc("sequence"));		
		return c.list();
	}
}
