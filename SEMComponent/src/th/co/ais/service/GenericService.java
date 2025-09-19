package th.co.ais.service;

import java.io.Serializable;
public interface GenericService extends BaseService {

	public Object loadObjectByClassAndId(Class<?> clazz, Serializable id);

	public Object merge(Object datachedObj);

//	public Object getObjectById(Class<? extends ATOMDomain> entityClass, Long id) throws Exception;
//
//	public Object getObjectSnapshotById(Class<? extends ATOMDomain> entityClass, Long id) throws Exception;

	public void persist(Object datachedObj);

	public Object copyTo(Long id, Class<?> clazz) throws Exception;

	public void reattach(Object datachedObj) throws Exception;

	public void evict(Object persistObj) throws Exception;

	public void flush() throws Exception;

}
