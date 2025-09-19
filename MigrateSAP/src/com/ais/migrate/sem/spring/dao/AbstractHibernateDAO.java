package com.ais.migrate.sem.spring.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ais.migrate.sem.spring.dao.exception.DAOException;

public abstract class AbstractHibernateDAO<T> extends HibernateDaoSupport {
	private Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public AbstractHibernateDAO() {
		persistentClass = (Class<T>) ((java.lang.reflect.ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}
	
	public final void save(T input) throws DAOException {
		try {
			getHibernateTemplate().save(input);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public T merge(T input) throws DAOException {
		try {
			return (T) getHibernateTemplate().merge(input);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}
	

	public void flush() throws DAOException {
		try {
			getHibernateTemplate().flush();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	public void mergeFlush(T input) throws DAOException {
		T result = merge(input);
		flush();
		refresh(result);
	}

	public void mergeClearSession(T input) throws DAOException {
		removeFromSession(merge(input));
	}

	public void removeFromSession(T input) {
		getHibernateTemplate().evict(input);
	}

	public void mergeAll(Collection<?> input) throws DAOException {
		try {
			for (Object element : input) {
				//injectDateToDomain(element);
				getHibernateTemplate().merge(element);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	public void persist(T input) {
		getHibernateTemplate().refresh(input);
	}

	@SuppressWarnings("unchecked")
	public T loadById(Serializable id) {
		return (T) getHibernateTemplate().load(persistentClass, id);
	}

	public void lock(T input) {
		getHibernateTemplate().lock(input, LockMode.NONE);
	}

	public final void saveOrUpdate(T input) throws DAOException {
		try {
			getHibernateTemplate().saveOrUpdate(input);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	public void saveOrUpdateAll(Collection<?> input) throws DAOException {
		try {
			getHibernateTemplate().saveOrUpdateAll(input);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	public void update(T input) throws DAOException {
		try {
			getHibernateTemplate().update(input);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	public void delete(T input) throws DAOException {
		try {
			//injectInfoToDomain(input);
			//getHibernateTemplate().update(input);
			getHibernateTemplate().delete(input);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	public void refresh(T input) throws DAOException {
		try {
			getHibernateTemplate().refresh(input);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	// HQL ----------------------------------------
	public T querySingleByHQL(String hql, Object... values) throws DAOException {
		try {
			List<T> resultList = queryByHQL(hql, values);
			return getSingleResult(resultList);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> queryByHQL(String hql, Object... values) throws DAOException {
		try {
			return getHibernateTemplate().find(hql, values);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<T> queryByHQL(String hql) throws DAOException {
		try {
			return getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}
	

	@SuppressWarnings("unchecked")
	private List<T> findByHQL(final int firstResult, final int pageSize, final String hql, final Object... values) {
		return (List<T>) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(final Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setFirstResult(firstResult);
				query.setMaxResults(pageSize);
				if (values != null) {
					for (int i = 0; i < values.length; i++) {
						query.setParameter(i, values[i]);
					}
				}
				return query.list();
			}
		}, false);
	}
	
	private T getSingleResult(List<T> resultList) throws Exception {
		T result = null;
		if (resultList != null && resultList.size() > 1) {
			throw new Exception("Invalid query, query result not contain single record");
		}
		if (resultList != null && resultList.size() == 1) {
			result = resultList.get(0);
		}
		return result;
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
}
