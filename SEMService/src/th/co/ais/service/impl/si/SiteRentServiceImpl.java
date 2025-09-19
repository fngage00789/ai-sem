package th.co.ais.service.impl.si;

import java.util.List;

import th.co.ais.dao.impl.si.SiteRentHibernateDAO;
import th.co.ais.domain.si.Rent;
import th.co.ais.service.AbstractService;
import th.co.ais.service.si.ISiteRentService;

public class SiteRentServiceImpl extends AbstractService implements ISiteRentService {

	private SiteRentHibernateDAO siteRentDao;

	public void setSiteRentDao(SiteRentHibernateDAO siteRentDao) {
		this.siteRentDao = siteRentDao;
	}

	@Override
	public Rent createSiteRent(Rent siteRent) throws Exception {
		siteRent.setRowId(null);
		siteRent.setRecordStatus("Y");
		return siteRentDao.merge(siteRent);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List querySPList(String spName, Object property) throws Exception {
		return siteRentDao.querySPList(spName, property);
	}

	@Override
	public Rent queryRentBySiteInfoId(String assignSiteInfoId) throws Exception {
		return siteRentDao.queryRentBySiteInfoId(assignSiteInfoId);
	}

	@Override
	public void deleteSiteRent(Rent siteRent) throws Exception {
		siteRent.setRecordStatus("N");
		siteRentDao.mergeFlush(siteRent);
		
	}

	@Override
	public Rent queryRentByRowId(String rowId) throws Exception {
		return siteRentDao.findByRowId(rowId);
	}

	@Override
	public Rent updateSiteRent(Rent siteRent) throws Exception {
		return siteRentDao.merge(siteRent);
	}
	
	
}
