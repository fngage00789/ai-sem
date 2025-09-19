package th.co.ais.dao.impl.si;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.si.Construct;

public class SiteConstructHibernateDAO extends AbstractHibernateDAO<Construct> {

	public Construct queryConstructBySiteInfoId(final String assignSiteInfoId) throws DAOException {
		getHibernateTemplate().setCacheQueries(true);
		Construct construct = querySingleByHQL("select distinct con from Construct con where con.siteInfoId = ? and con.recordStatus = 'Y' ", assignSiteInfoId);
		return construct;
	}
	
	public Construct findByRowId(final String rowId) throws DAOException{
		getHibernateTemplate().setCacheQueries(true);
		Construct construct = querySingleByHQL("select distinct stm from Construct stm where stm.rowId = ? ", rowId);
		return construct;
	}
	
	public Construct mergeWithOutUser(Construct input) throws DAOException {
		try {
			return (Construct) getHibernateTemplate().merge(input);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}
}
