package th.co.ais.dao.impl.rt;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.rt.PettyCash;

public class PettyCashHibernateDAO extends AbstractHibernateDAO<PettyCash> {
 
	public PettyCash findByRowId(final String rowId) throws DAOException {
		String hql = "from PettyCash p where p.rowId = ?";
		return querySingleByHQL(hql, rowId);
	}
	
	public PettyCash getLastBalanceAmount(String company) throws DAOException{
		
		String hql ="select p from PettyCash p " +
				    "where p.recordStatus = 'Y' and p.company = ? and p.pettyCashSeq = " +
				    "(select max(pettyCashSeq) from PettyCash m where m.company = ? and m.recordStatus = 'Y')";
		return (PettyCash)querySingleByHQL(hql, company, company);
	}
}
