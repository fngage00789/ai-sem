package th.co.ais.dao.impl.rt;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.rt.RentalPlan;

public class RentalPlanHibernateDAO extends AbstractHibernateDAO<RentalPlan> {
 
	public RentalPlan findByRowId(final String rowId) throws DAOException {
		getHibernateTemplate().setCacheQueries(true);
		RentalPlan rtp = querySingleByHQL("select distinct r from RentalPlan r where r.rowId = ? and recordStatus = 'Y'", rowId);
		return rtp;
	}
	
	public List<RentalPlan> queryRentalPlan(final RentalPlan rentalPlan) throws DAOException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(RentalPlan.class);
		
		if (rentalPlan != null) {
			if (StringUtils.isNotEmpty(rentalPlan.getPlanType())) {
				criteria.add(Restrictions.like("planType", rentalPlan.getPlanType()));
			}
			if (StringUtils.isNotEmpty(rentalPlan.getCompany())) {
				criteria.add(Restrictions.like("company", rentalPlan.getCompany()));
			}
			if (StringUtils.isNotEmpty(rentalPlan.getPlanYear())) {
				criteria.add(Restrictions.like("planYear", rentalPlan.getPlanYear()));
			}
			if (StringUtils.isNotEmpty(rentalPlan.getRegion())) {
				criteria.add(Restrictions.like("region", rentalPlan.getRegion()));
			}
			criteria.add(Restrictions.like("recordStatus", "Y"));
		}
		criteria.addOrder(Order.asc("rowId"));
		return criteria.list();
	}
}
