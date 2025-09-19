package th.co.ais.dao.impl.rt;


import org.hibernate.Query;
import org.hibernate.Session;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.rt.PettyCashPay;
import th.co.ais.domain.rt.PettyCashPaySP;
import th.co.ais.util.EQueryName;

public class PettyCashPayHibernateDAO extends AbstractHibernateDAO<PettyCashPay> {
 
	public PettyCashPay findByRowId(final String rowId) throws DAOException {
		String hql = "from PettyCashPay pp where pp.rowId = ?";
		return querySingleByHQL(hql, rowId);
	}
	
	public PettyCashPaySP updateExportDt(String pettyCashPayIds, String username) throws DAOException {
		Session session = getSession();
        Query q = session.getNamedQuery(EQueryName.SP_MRT008PAY_UPD_EXPORT.name);
        q.setString("pettyCashPayIds", pettyCashPayIds);
        q.setString("username", username);
        return (PettyCashPaySP)q.uniqueResult(); 
	}
	
}
