package th.co.ais.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Example.PropertySelector;
import org.hibernate.envers.configuration.AuditConfiguration;
import org.hibernate.impl.SessionFactoryImpl;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

//import com.fasterxml.jackson.databind.ObjectMapper;

import th.co.ais.dao.exception.DAOException;

import th.co.ais.domain.AbstractDomain;
import th.co.ais.domain.el.Payment;
import th.co.ais.domain.gm.VendorMapPayee;
import th.co.ais.util.SEMDataUtility;



public abstract class AbstractHibernateDAO<T> extends HibernateDaoSupport {
	private Class<T> persistentClass;
	private static AuditConfiguration auditConfig;
	public static final int DEFAULT_MAX_RESULTS = 200;
	public static final String DEFAULT_REF_ID = "0000000000000000000000";
	public static final String SPRING_USER_REF_ID = "9999999999999999999999";
	public static boolean DEFAULT_CACHEABLE = false;
	public static final int NESTED_DEPTH_SEARCH = 7;
	public static final String ROOT_ALIAS_ = Criteria.ROOT_ALIAS + "_";


	protected static final PropertySelector NOT_NULL_OR_EMPTY = new NotNullOrEmptyPropertySelector();

	@SuppressWarnings("unchecked")
	public AbstractHibernateDAO() {
		persistentClass = (Class<T>) ((java.lang.reflect.ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * get class type of entity.
	 * 
	 * @return class type
	 */
	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	private static final class NotNullOrEmptyPropertySelector implements PropertySelector {
		private static final long serialVersionUID = 1L;
		protected Log logger = LogFactory.getLog(getClass());
	

		public boolean include(Object object, String propertyName, org.hibernate.type.Type type) {
			if (object == null) {
				return false;
			}
			if (object.getClass().getName().indexOf("$") != -1) {
				return false;
			}
			if (object.getClass().getName().startsWith("_") && object.getClass().getName().endsWith("Backref")) {
				return false;
			}
			if ((object instanceof String) && ((String) object).trim().length() == 0) {
				return false;
			}
			if ((object instanceof Number) && ((Number) object).longValue() == 0) {
				return false;
			}
			if (propertyName != null && propertyName.trim().equals("refId")) {
				return false;
			}
			if (propertyName != null && propertyName.trim().equals("dbVersion")) {
				return false;
			}
			logger.debug("Property approved: " + propertyName);
			return true;
		}

		private Object readResolve() {
			return NOT_NULL_OR_EMPTY;
		}
	}

	protected int executeUpdate(String queryString) {
		return getSession().createSQLQuery(queryString).executeUpdate();
	}



	protected AuditConfiguration getAuditConfig() {
		if (auditConfig == null) {
			AnnotationConfiguration annoConfig = new AnnotationConfiguration();
			annoConfig.setProperties(((SessionFactoryImpl) getSessionFactory().getCurrentSession().getSessionFactory()).getProperties());
			auditConfig = new AuditConfiguration(annoConfig);
		}
		return auditConfig;
	}


	// Stored Procedure ----------------------------------------
	@SuppressWarnings("unchecked")
	public List<T> querySP(String spName) throws DAOException {
		try {
			return getSession().getNamedQuery(spName).list();
		} catch (Exception e) {
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
	
	@SuppressWarnings("unchecked")
	public List<T> querySP(String spName, Object property) throws DAOException {
		Query query = null;
		try {
			query = getSession().getNamedQuery(spName);
			query.setProperties(property);
            List list = query.list();
			//logger.info("querySP : "+spName+" ### property :" + property.toString());
			//return getSession().getNamedQuery(spName).setProperties(property).list();
            return list;
		} catch (Exception e) {
			throw new DAOException(e);
		} finally {
			query = null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List querySPList(String spName, Object property) throws DAOException {
		Query query = null;
		try {						
			try {
			//ObjectMapper mapper = new ObjectMapper();
			//System.out.println(mapper.writeValueAsString(property));
			
			//logger.info("querySPList : "+spName+" ### Params-property :" +mapper.writeValueAsString(property));	
			//return getSession().getNamedQuery(spName).setProperties(property).list();
			//logger.info("querySPList params : " +getSession().getNamedQuery(spName).setProperties(property).getNamedParameters());
			
			query = getSession().getNamedQuery(spName);
			logger.info("querySPList params : " +query.getQueryString());
			} catch (Exception e) {
				logger.info("Cannot ObjectMapper "+e.getMessage()+e.getCause());
			}
			
            query.setProperties(property);
            List list = query.list();
			//List rsList = getSession().getNamedQuery(spName).setProperties(property).list();
			//return getSession().getNamedQuery(spName).setProperties(property).list();
            
            return list;
		} catch (Exception e) {
			throw new DAOException(e);
		} finally {
			query = null;
		}
	}
	
	public Query getSPQuery(String spName) throws DAOException {
		try {
			return getSession().getNamedQuery(spName);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}
	
	// Write DB ----------------------------------------
	public final void save(T input) throws DAOException {
		try {
			injectInfoToDomain(input);
			getHibernateTemplate().save(input);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}
	
	public void injectInfoToDomain(T input) throws Exception{
		Log LOG = LogFactory.getLog(getClass());
		
		if(input instanceof AbstractDomain){
			AbstractDomain domain = (AbstractDomain)input;
			if(StringUtils.isEmpty(domain.getRowId())) {
				LOG.info("merge do create");
				if(domain.getCurrentUser() != null){
					SEMDataUtility.injectCreatorToDomain(domain, domain.getCurrentUser());
					SEMDataUtility.injectCreatDateToDomain(input);
					SEMDataUtility.injectModifierToDomain(domain, domain.getCurrentUser());
					SEMDataUtility.injectModifiedDateToDomain(input);
				}
			}else{
				LOG.info("merge do update");
				SEMDataUtility.injectModifierToDomain(domain, domain.getCurrentUser());
				SEMDataUtility.injectModifiedDateToDomain(input);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public T merge(T input) throws DAOException {
		try {
			injectInfoToDomain(input);
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
			injectInfoToDomain(input);
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
			injectInfoToDomain(input);
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
	public List<String> queryStringByHQL(String hql) throws DAOException {
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
		});
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
	
	public BigDecimal getSEQ(final String fieldName, final Class o) throws DAOException {
		Criteria c = getSession().createCriteria(o);
		ProjectionList projList = Projections.projectionList();
		projList.add(Projections.max(fieldName));
		c.setProjection(projList);
		BigDecimal max = (BigDecimal)c.uniqueResult();
		BigDecimal seqDef = new BigDecimal(1);
		if(null == max){
			return seqDef;
		}else{
			return max.add(seqDef);
		}
	}
	
	public Integer countColByRowId(final String fieldName, final Class o, final String rowId) throws DAOException {
		Criteria c = getSession().createCriteria(o);
		ProjectionList projList = Projections.projectionList();
		projList.add(Projections.count(fieldName));
		c.setProjection(projList);
		c.add(Restrictions.eq(fieldName, rowId));
		c.add(Restrictions.eq("recordStatus", "Y"));
		Integer total = (Integer)c.uniqueResult();
		return total;
	}
	
	@SuppressWarnings("unchecked")
	public T findByPK(String rowId) throws DataAccessException {
		Session session = getSessionFactory().getCurrentSession();
		
		T entity = (T) session.get(getPersistentClass(), rowId);
		if (entity == null) {
			try {
				entity = (T) session.load(getPersistentClass(), rowId);
			} catch (ObjectNotFoundException ex) {
				entity = null;
			}
		}

		return entity;
	}
	
	public boolean updateVendorMapPayee(VendorMapPayee vp) throws Exception{
		String hql = "UPDATE SEM_CT_VENDOR_MAP_PAYEE SET RECORD_STATUS = :recordStatus , UPDATE_BY = :updateBy , UPDATE_DT = current_timestamp " +
				"WHERE VENDOR_MAP_PAYEE_ID = :vendorMapPayeeId";
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createSQLQuery(hql);
		query.setParameter("recordStatus", vp.getRecordStatus());
		query.setParameter("updateBy", vp.getUpdateBy());
		query.setParameter("vendorMapPayeeId", vp.getRowId());
	    return query.executeUpdate() >= 0?true:false;
	}
	
    /*===== 08/10/2022  add for support Postgresql  ===*/
    public final void saveOrUpdate(String entityName,T input) throws DAOException {
        try {
            injectInfoToDomain(input);
            getHibernateTemplate().saveOrUpdate(entityName,input);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException(e);
        }
    }
    
    public boolean saveOrUpdatePayment(Payment payment) {
            Transaction transaction = null;
            Session session = getSessionFactory().getCurrentSession();
            try {
                // start a transaction
                transaction = session.beginTransaction();
                // save the student object
                session.saveOrUpdate(payment);            

                // commit transaction
                transaction.commit();
                return true;
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
                return false;
            }
        }
	
}