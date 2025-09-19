package com.ais.migrate.sem.spring.dao;

import java.awt.Cursor;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.ais.migrate.sem.hibernate.annotion.MpContractClean;
import com.ais.migrate.sem.hibernate.annotion.SapMapping;
import com.ais.migrate.sem.model.SPProcedure;
import com.ais.migrate.sem.spring.dao.exception.DAOException;

public class MigrateDAO extends HibernateDaoSupport {
	
	
	public void save(Object input) throws DAOException {
		try {
			getHibernateTemplate().save(input);
		} catch (Exception e) {
			e.printStackTrace();
//			throw new DAOException(e);
		}
	}
	
	public List queryListBySP(String spName, Object property) throws DAOException {
		try {
			List resultList = getSession().getNamedQuery(spName).setProperties(property).list();			
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}
	
	public Object querySingleBySP(String spName, Object property) throws DAOException {
		try {
			List resultList = getSession().getNamedQuery(spName).setProperties(property).list();			
			return getSingleResultObject(resultList);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}
	
	private Object getSingleResultObject(List<Object> resultList) throws Exception {
		Object result = null;
		if (resultList != null && resultList.size() > 1) {
			throw new Exception("Invalid query, query result not contain single record");
		}
		if (resultList != null && resultList.size() == 1) {
			result = resultList.get(0);
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<SapMapping> querySapMapping(final String templateId) throws DAOException{
//		Session session =  this.getHibernateTemplate().getSessionFactory().getCurrentSession();
//		Criteria c = session.createCriteria(SapMapping.class);
//		if(null!=templateId){
//			c.add(Restrictions.eq("templateId", templateId));
//		}
//		c.addOrder(Order.asc("templateId"))
//		 .addOrder(Order.asc("sequence"));
		
		String hqlStr = "from SapMapping where templateId='"+templateId+"' order by templateId,sequence";
		return this.getHibernateTemplate().find(hqlStr);
		
//		List<SapMapping> sapMappingList = new LinkedList<SapMapping>();
//		SapMapping sapMapping = new SapMapping();
//		sapMappingList.add(sapMapping);
//		return sapMappingList;
	}
	
	/*public List getMpContractCleans(int rowStart, int rowEnd) throws DAOException{
		
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(MpContractClean.class);
		criteria.setFirstResult(0);
	    criteria.setMaxResults(25);
	    //criteria.add(Restrictions.eq("uniqueId",1));
	    //criteria.setFirstResult(rowStart);
	    //criteria.setMaxResults(rowEnd - rowStart);
	    criteria.addOrder(Order.asc("uniqueId"));
	    session.close();
	    return criteria.list();
	}*/
}
