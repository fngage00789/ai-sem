package th.co.ais.dao.impl.si;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.si.Contract;

public class SiteContractHibernateDAO extends AbstractHibernateDAO<Contract> {

	public Contract queryContractBySiteInfoId(final String assignSiteInfoId) throws DAOException {
		getHibernateTemplate().setCacheQueries(true);
		Contract contract = querySingleByHQL("select distinct con from Contract con where con.siteInfoId = ? and con.recordStatus = 'Y' ", assignSiteInfoId);
		return contract;
	}

	public Contract queryByRowId(final String rowId) throws DAOException{
		getHibernateTemplate().setCacheQueries(true);
		Contract contract = querySingleByHQL("select distinct con from Contract con where con.rowId= ?  ", rowId);
		return contract;
	}

	@SuppressWarnings("unchecked")
	public List<Contract> queryContract(final Contract contract, final String orderBy) throws DAOException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Contract.class);
		
		if (contract != null) {
			if (StringUtils.isNotEmpty(contract.getRowId())) {
				criteria.add(Restrictions.like("rowId", contract.getRowId().replace("*", "%")));
			}
			if (StringUtils.isNotEmpty(contract.getContractNo())) {
				criteria.add(Restrictions.like("contractNo", contract.getContractNo().replace("*", "%")));
			}
			if (StringUtils.isNotEmpty(contract.getRecordStatus())) {
				criteria.add(Restrictions.like("recordStatus", contract.getRecordStatus().replace("*", "%")));
			}
		}
		
		if (StringUtils.isNotEmpty(orderBy)) {
			criteria.addOrder(Order.asc(orderBy));
		} else {
			criteria.addOrder(Order.asc("rowId"));
		}
		
		return criteria.list();
	}
}
