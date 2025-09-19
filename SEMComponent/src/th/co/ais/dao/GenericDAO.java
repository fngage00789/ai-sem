package th.co.ais.dao;

import java.io.Serializable;

import org.hibernate.LockMode;
import org.hibernate.ReplicationMode;

import th.co.ais.dao.exception.DAOException;

public class GenericDAO extends AbstractHibernateDAO<Object> {
	
	public Object loadObjectByClassAndId(Class<?> clazz, Serializable id) {
		return getHibernateTemplate().load(clazz, id);
	}

	public Object merge(Object datachedObj) {
		return getHibernateTemplate().merge(datachedObj);
	}

	public void persist(Object datachedObj) {
		getHibernateTemplate().persist(datachedObj);
	}

	public void lock(Object datachedObj) {
		getHibernateTemplate().lock(datachedObj, LockMode.NONE);
	}


	public void reattach(Object datachedObj) throws DAOException {
		getHibernateTemplate().replicate(datachedObj, ReplicationMode.OVERWRITE);
	}

	public void evict(Object persistObj) {
		getHibernateTemplate().evict(persistObj);
	}

}
