package th.co.ais.dao.impl.si;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.si.Electric;

public class SiteElectricHibernateDAO extends AbstractHibernateDAO<Electric> {

	public Electric queryElectricBySiteInfoId(final String assignSiteInfoId)throws DAOException {
		getHibernateTemplate().setCacheQueries(true);
		Electric electric = querySingleByHQL("select distinct e from Electric e where e.siteInfoId = ? and e.recordStatus = 'Y' ", assignSiteInfoId);
		return electric;
	}

	public Electric findByRowId(final String rowId) throws DAOException{
		String hql = "SELECT DISTINCT electric FROM Electric electric WHERE electric.rowId = ?";
		return querySingleByHQL(hql, rowId);
	}

}
