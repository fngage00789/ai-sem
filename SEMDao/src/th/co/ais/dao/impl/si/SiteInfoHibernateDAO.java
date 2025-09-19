package th.co.ais.dao.impl.si;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.si.SiteInfo;

public class SiteInfoHibernateDAO extends AbstractHibernateDAO<SiteInfo>{

	public SiteInfo findByRowId(final String rowId) throws DAOException{
		getHibernateTemplate().setCacheQueries(true);
		SiteInfo siteInfo = querySingleByHQL("select distinct s from SiteInfo s where s.rowId = ? ", rowId);
		return siteInfo;
	}

}
