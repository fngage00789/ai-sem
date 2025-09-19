package th.co.ais.dao.impl.si;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.si.Insurance;

public class SiteInsuranceHibernateDAO extends AbstractHibernateDAO<Insurance> {

	public Insurance queryInsuranceBySiteInfoId(final String assignSiteInfoId) throws DAOException {
		getHibernateTemplate().setCacheQueries(true);
		Insurance insurance = querySingleByHQL("select distinct ins from Insurance ins where ins.siteInfoId = ? and ins.recordStatus = 'Y' ", assignSiteInfoId);
		return insurance;
	}

	public Insurance findByRowId(final String rowId) throws DAOException {
		String hql = "SELECT DISTINCT ins FROM Insurance ins WHERE ins.rowId = ?";
		return querySingleByHQL(hql, rowId);
	}

}
