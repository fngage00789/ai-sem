package com.ais.migrate.sem.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ais.migrate.sem.hibernate.annotion.SapMapping;
import com.ais.migrate.sem.spring.dao.exception.DAOException;

public class SapMappingDAO extends HibernateDaoSupport{
	
	@SuppressWarnings("unchecked")
	public List<SapMapping> querySapMapping(final String templateId) throws DAOException{
		Session session =  this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		Criteria c = session.createCriteria(SapMapping.class);
		if(null!=templateId){
			c.add(Restrictions.eq("templateId", templateId));
		}
		c.addOrder(Order.asc("templateId"))
		 .addOrder(Order.asc("sequence"));		
		return c.list();
	}
	
	/*@SuppressWarnings("unchecked")
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
	}*/
	
}
