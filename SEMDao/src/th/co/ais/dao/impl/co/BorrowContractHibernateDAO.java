package th.co.ais.dao.impl.co;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.domain.co.BorrowContract;

public class BorrowContractHibernateDAO  extends AbstractHibernateDAO<BorrowContract>{
	public BorrowContract getBorrowContractByRowId(String rowID){
		Criteria criteria = getSession().createCriteria(BorrowContract.class);
		criteria.add(Restrictions.eq("rowId", rowID));
		return (BorrowContract)criteria.uniqueResult();
	}

}
