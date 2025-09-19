package th.co.ais.service.impl.si;

import java.util.List;

import th.co.ais.dao.impl.si.SitePropertyTaxHibernateDAO;
import th.co.ais.domain.si.PropertyTax;
import th.co.ais.service.AbstractService;
import th.co.ais.service.si.ISitePropertyTaxService;

public class SitePropertyTaxServiceImpl extends AbstractService implements ISitePropertyTaxService {

	private SitePropertyTaxHibernateDAO sitePropertyTaxDao;

	public void setSitePropertyTaxDao(SitePropertyTaxHibernateDAO sitePropertyTaxDao) {
		this.sitePropertyTaxDao = sitePropertyTaxDao;
	}

	@Override
	public PropertyTax createSitePropertyTax(PropertyTax sitePropertyTax)
			throws Exception {
		sitePropertyTax.setRowId(null);
		sitePropertyTax.setRecordStatus("Y");
		return sitePropertyTaxDao.merge(sitePropertyTax);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List querySPList(String spName, Object property) throws Exception {
		return sitePropertyTaxDao.querySP(spName, property);
	}

	@Override
	public PropertyTax queryPropertyTaxBySiteInfoId(String assignSiteInfoId)
			throws Exception {
		return sitePropertyTaxDao.queryPropertyTaxBySiteInfoId(assignSiteInfoId);
	}

	@Override
	public PropertyTax updateSitePropertyTax(PropertyTax sitePropertyTax)
			throws Exception {
		return sitePropertyTaxDao.merge(sitePropertyTax);
		
	}

	@Override
	public void deleteSitePropertyTax(PropertyTax sitePropertyTax)
			throws Exception {
		sitePropertyTax.setRecordStatus("N");
		sitePropertyTaxDao.mergeFlush(sitePropertyTax);
		
	}
	
	
}
