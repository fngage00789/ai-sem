package th.co.ais.dao.impl.gm;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.gm.ParameterMaster;


public class ParameterMasterHibernateDAO extends AbstractHibernateDAO<ParameterMaster>{
	
	public ParameterMaster findByRowId(final String rowId) throws DAOException{
		String hql = "FROM ParameterMaster pm WHERE pm.rowId = ?";
		return querySingleByHQL(hql, rowId);
	}
	
}