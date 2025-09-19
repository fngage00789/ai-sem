package th.co.ais.dao.impl.si;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.si.PropertyTax;

public class SitePropertyTaxHibernateDAO extends AbstractHibernateDAO<PropertyTax> {

	public PropertyTax queryPropertyTaxBySiteInfoId(final String assignSiteInfoId) throws DAOException {
		getHibernateTemplate().setCacheQueries(true);
		PropertyTax construct = querySingleByHQL("select distinct prop from PropertyTax prop where prop.siteInfoId = ? and prop.recordStatus = 'Y' ", assignSiteInfoId);
		return construct;
	}

}
