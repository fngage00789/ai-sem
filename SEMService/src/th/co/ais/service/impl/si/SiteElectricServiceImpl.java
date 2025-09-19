package th.co.ais.service.impl.si;

import java.util.List;

import th.co.ais.dao.impl.si.SiteElectricHibernateDAO;
import th.co.ais.domain.si.Electric;
import th.co.ais.service.AbstractService;
import th.co.ais.service.si.ISiteElectricService;

public class SiteElectricServiceImpl extends AbstractService implements ISiteElectricService {

	private SiteElectricHibernateDAO siteElectricDao;
	
	
	public void setSiteElectricDao(SiteElectricHibernateDAO siteElectricDao) {
		this.siteElectricDao = siteElectricDao;
	}


	@Override
	public Electric createSiteElectric(Electric siteElectric) throws Exception {
		siteElectric.setRowId(null);
		siteElectric.setRecordStatus("Y");
		return siteElectricDao.merge(siteElectric);
		
	}


	@Override
	@SuppressWarnings("unchecked")
	public List querySPList(String spName, Object property) throws Exception {
		return siteElectricDao.querySP(spName, property);
	}


	@Override
	public Electric queryElectricBySiteInfoId(String assignSiteInfoId)
			throws Exception {
		return siteElectricDao.queryElectricBySiteInfoId(assignSiteInfoId);
	}


	@Override
	public Electric updateSiteElectric(Electric siteElectric) throws Exception {
		return siteElectricDao.merge(siteElectric);
		
	}


	@Override
	public Electric queryRentByRowId(String rowId) throws Exception {
		return siteElectricDao.findByRowId(rowId);
	}


	@Override
	public void deleteElectric(Electric electric) throws Exception {
		electric.setRecordStatus("N");
		siteElectricDao.mergeFlush(electric);
	}


}
