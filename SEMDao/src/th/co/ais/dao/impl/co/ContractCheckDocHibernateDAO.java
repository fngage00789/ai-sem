package th.co.ais.dao.impl.co;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.co.ContractCheckDoc;

public class ContractCheckDocHibernateDAO extends AbstractHibernateDAO<ContractCheckDoc>{

	public ContractCheckDoc findByRowId(final String rowId) throws DAOException{
		getHibernateTemplate().setCacheQueries(true);
		ContractCheckDoc contractCheckDoc = querySingleByHQL("select distinct c from ContractCheckDoc c where c.rowId = ? ", rowId);
		return contractCheckDoc;
	}

	public List<ContractCheckDoc> queryContractCheckDocByContractId(
			String contractId) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(ContractCheckDoc.class);
		
		if(contractId != null){
				criteria.add(Restrictions.like("contractId",  contractId));
				criteria.add(Restrictions.like("recordStatus",  "Y"));
		}
		criteria.addOrder(Order.asc("rowId"));
		
		return criteria.list();
	}

}
