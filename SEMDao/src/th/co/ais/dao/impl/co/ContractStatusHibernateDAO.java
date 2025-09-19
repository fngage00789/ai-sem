package th.co.ais.dao.impl.co;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.co.ContractStatus;

public class ContractStatusHibernateDAO extends AbstractHibernateDAO<ContractStatus>{

	public ContractStatus findByRowId(final String rowId) throws DAOException{
		getHibernateTemplate().setCacheQueries(true);
		ContractStatus contractStatus = querySingleByHQL("select distinct c from ContractStatus c where c.rowId = ? ", rowId);
		return contractStatus;
	}

}
