package th.co.ais.dao.impl.si;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.si.SiteApproveMapLoc;

public class SiteApproveMapLocHibernateDAO extends AbstractHibernateDAO<SiteApproveMapLoc>{

	public SiteApproveMapLoc findByRowId(final String rowId) throws DAOException {
		getHibernateTemplate().setCacheQueries(true);
		String query = "select distinct s from SiteApproveMapLoc s where s.rowId = ? and s.recordStatus = 'Y'";
		return querySingleByHQL(query, rowId);
	}
	
	public boolean checkDuplicateByLocationIdAndSiteApproveId(final SiteApproveMapLoc siteMapLoc) throws DAOException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(SiteApproveMapLoc.class);
		if (siteMapLoc != null) {
			if (StringUtils.isNotEmpty(siteMapLoc.getSiteApproveId())) {
				criteria.add(Restrictions.like("siteApproveId", siteMapLoc.getSiteApproveId()));
			}
			if (StringUtils.isNotEmpty(siteMapLoc.getLocationId())) {
				criteria.add(Restrictions.like("locationId", siteMapLoc.getLocationId()));
			}
			criteria.add(Restrictions.like("recordStatus", "Y"));
			List list = criteria.list();
			if (list == null || list.isEmpty()) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
	
}
