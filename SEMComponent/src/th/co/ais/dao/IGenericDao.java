package th.co.ais.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

public interface IGenericDao<T, ID extends Serializable> {

	 void insert(T entity) throws DataAccessException; 
	 void update(T entity) throws DataAccessException;
	 void delete(T entity) throws DataAccessException;      
	 T getByPrimaryKey(String rowId) throws DataAccessException;
	 List<T> getBySQLCriteria(String sql) throws DataAccessException;
	 List<T> getByHQLCriteria(String hql) throws DataAccessException;
}
