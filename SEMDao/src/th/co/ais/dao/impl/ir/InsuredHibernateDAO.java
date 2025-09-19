package th.co.ais.dao.impl.ir;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.ir.Insured;

public class InsuredHibernateDAO extends AbstractHibernateDAO<Insured> {
	
	public Insured findByRowId(final String rowId) throws DAOException {
		String hql = "FROM Insured ins WHERE ins.rowId = ?";
		return querySingleByHQL(hql, rowId);
	}

	public List<Insured> queryInsured(final Insured insured) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Insured.class);
		
		if (insured != null) {
			if (StringUtils.isNotEmpty(insured.getCompany())) {
				criteria.add(Restrictions.like("company", "%" + insured.getCompany() + "%"));
			}
			if (StringUtils.isNotEmpty(insured.getNetworkType())) {
				criteria.add(Restrictions.like("networkType", "%" + insured.getNetworkType() + "%"));
			}
//			if (insured.getLocationId() != null) {
//				criteria.add(Restrictions.like("locationId", insured.getLocationId()));
//			}
			if (insured.getEffDt() != null) {
				criteria.add(Restrictions.like("effDt", insured.getEffDt()));
			}
		}
		criteria.addOrder(Order.asc("rowId"));
		return criteria.list();
	}
}
