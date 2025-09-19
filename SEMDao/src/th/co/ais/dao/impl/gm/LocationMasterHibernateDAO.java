package th.co.ais.dao.impl.gm;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.gm.LocationMaster;

public class LocationMasterHibernateDAO extends AbstractHibernateDAO<LocationMaster> {

	@SuppressWarnings("unchecked")
	public List<LocationMaster> queryLocationMaster(final LocationMaster locMaster) throws DAOException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(LocationMaster.class);
		
		if (locMaster != null) {
//			if (locMaster.getLocationId() != null && !locMaster.getLocationId().equals(new BigDecimal(0))) {
//				criteria.add(Restrictions.like("locationId", locMaster.getLocationId()));
//			}
			if (StringUtils.isNotEmpty(locMaster.getLocationId())) {
				criteria.add(Restrictions.like("locationId", locMaster.getLocationId().replace("*", "%")));
			}
			if (StringUtils.isNotEmpty(locMaster.getLocationCode())) {
				criteria.add(Restrictions.like("locationCode", locMaster.getLocationCode().replace("*", "%")));
			}
			if (StringUtils.isNotEmpty(locMaster.getLocationName())) {
				criteria.add(Restrictions.like("locationName", locMaster.getLocationName().replace("*", "%")));
			}
		}
		
		criteria.addOrder(Order.asc("rowId"));
		
		return criteria.list();
	}
}
