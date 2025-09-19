package th.co.ais.dao.impl.co;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.co.ContractFile;

public class ContractFileHibernateDAO extends AbstractHibernateDAO<ContractFile>{

	public ContractFile findByRowId(final String rowId) throws DAOException{
		getHibernateTemplate().setCacheQueries(true);
		ContractFile contractFile = querySingleByHQL("select distinct c from ContractFile c where c.rowId = ? ", rowId);
		return contractFile;
	}

	public ContractFile findByContractId(final String rowId) throws DAOException{
		getHibernateTemplate().setCacheQueries(true);
		ContractFile contractFile = querySingleByHQL("select distinct c from ContractFile c where c.contractId = ? ", rowId);
		return contractFile;
	}
}
