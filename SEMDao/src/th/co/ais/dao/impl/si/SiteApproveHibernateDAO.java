package th.co.ais.dao.impl.si;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.si.SiteApprove;

public class SiteApproveHibernateDAO extends AbstractHibernateDAO<SiteApprove>{

	public SiteApprove findByRowId(final String rowId) throws DAOException {
		getHibernateTemplate().setCacheQueries(true);
		String query = "select distinct site from SiteApprove site where site.rowId = ? and site.recordStatus = 'Y'";
		SiteApprove siteApprove = querySingleByHQL(query, rowId);
		return siteApprove;
	}
	
}
