package th.co.ais.dao.impl.co;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.domain.co.ReturnContract;

public class ReturnContractHibernateDAO  extends AbstractHibernateDAO<ReturnContract>{
	public ReturnContract getReturnContractByRowId(String rowID){
		Criteria criteria = getSession().createCriteria(ReturnContract.class);
		criteria.add(Restrictions.eq("rowId", rowID));
		return (ReturnContract)criteria.uniqueResult();
	}

}
