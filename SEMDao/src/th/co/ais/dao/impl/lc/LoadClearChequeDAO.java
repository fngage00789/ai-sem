package th.co.ais.dao.impl.lc;

import org.hibernate.Query;
import org.hibernate.Session;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.domain.ac.LoadClearCheque;

public class LoadClearChequeDAO extends AbstractHibernateDAO<LoadClearCheque>{

	public boolean updateClearCheque(LoadClearCheque lc) throws Exception{
		String hql = "UPDATE SEM_CT_TRANS_PAYMENT SET CHQ_CLEARING_STATUS = :clearStatus , CHQ_CLEARING_DT = :clearDate" +
				" WHERE CHQ_NO = :chequeNo";
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createSQLQuery(hql);
		query.setParameter("clearStatus", lc.getChequeClearStatus());
		query.setParameter("clearDate", lc.getClearDate());
		query.setParameter("chequeNo", lc.getChequeNo().toString());
	    return query.executeUpdate() >= 0?true:false;
	}
}
