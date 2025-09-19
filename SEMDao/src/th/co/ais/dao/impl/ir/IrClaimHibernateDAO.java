package th.co.ais.dao.impl.ir;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.ir.IrClaim;

public class IrClaimHibernateDAO extends AbstractHibernateDAO<IrClaim>{

	public IrClaim findByPKWithChild(String pk) throws DAOException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IrClaim.class);
		IrClaim irClaim = null;
		
		if (StringUtils.isNotEmpty(pk) && StringUtils.isNotBlank(pk)) {
			criteria.add(Restrictions.eq("rowId", pk));
			criteria.add(Restrictions.eq("recordStatus", "Y"));
			criteria.setFetchMode("irClaimDetails", FetchMode.JOIN);
			irClaim = (IrClaim) criteria.uniqueResult();
		}

		return irClaim;
	}
	
	public List<IrClaim> searchByUserLogin(String userLogin) throws DAOException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(IrClaim.class);
		List<IrClaim> irClaims = null;
		
		if (StringUtils.isNotEmpty(userLogin) && StringUtils.isNotBlank(userLogin)) {
			criteria.add(Restrictions.eq("createBy", userLogin));
			criteria.add(Restrictions.eq("recordStatus", "Y"));
			criteria.addOrder(Order.asc("locationId"));
			irClaims = criteria.list();
		}
	
		return irClaims;
	}
}
