package th.co.ais.dao.impl.co;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.domain.co.BorrowRequest;

public class BorrowRequestHibernateDAO extends AbstractHibernateDAO<BorrowRequest>{
	
	public BorrowRequest getBorrowRequestByRowId(String rowID){
		Criteria criteria = getSession().createCriteria(BorrowRequest.class);
		criteria.add(Restrictions.eq("rowId", rowID));
		criteria.add(Restrictions.eq("recordStatus", "Y"));
		return (BorrowRequest)criteria.uniqueResult();
	}
	
	public BorrowRequest getBorrowReqByDocNo(String docNo) {
		Criteria criteria = getSession().createCriteria(BorrowRequest.class);
		criteria.add(Restrictions.eq("docNo", docNo));
		criteria.add(Restrictions.eq("recordStatus", "Y"));
		return (BorrowRequest)criteria.uniqueResult();
	}
}
