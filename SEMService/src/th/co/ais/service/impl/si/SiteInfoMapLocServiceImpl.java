package th.co.ais.service.impl.si;

import java.util.List;

import th.co.ais.dao.impl.si.SiteInfoMapLocHibernateDAO;
import th.co.ais.domain.si.SiteInfoMapLoc;
import th.co.ais.service.AbstractService;
import th.co.ais.service.si.ISiteInfoMapLocService;

public class SiteInfoMapLocServiceImpl extends AbstractService implements ISiteInfoMapLocService {

	private SiteInfoMapLocHibernateDAO siteInfoMapLocDao;
	
	
	public void setSiteInfoMapLocDao(SiteInfoMapLocHibernateDAO siteInfoMapLocDao) {
		this.siteInfoMapLocDao = siteInfoMapLocDao;
	}


	@Override
	@SuppressWarnings("unchecked")
	public List querySPList(String spName, Object property)
			throws Exception {
		return siteInfoMapLocDao.querySPList(spName, property);
	}


	@Override
	public Boolean checkSiteInfoMapLocDuplicate(SiteInfoMapLoc siteInfoMapLoc)
			throws Exception {
		List<SiteInfoMapLoc> siteLoc = querySiteInfoMapLocByCriteria(siteInfoMapLoc);
		if (siteLoc != null && !siteLoc.isEmpty()) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}


	@Override
	public void createSiteInfoMapLoc(List<SiteInfoMapLoc> siteInfoMapLocList)
			throws Exception {
		for(SiteInfoMapLoc siteInfoMapLoc : siteInfoMapLocList){
			siteInfoMapLoc.setRowId(null);
			siteInfoMapLoc.setRecordStatus("Y");
			siteInfoMapLocDao.save(siteInfoMapLoc);
		}
	}


	@Override
	public List<SiteInfoMapLoc> querySiteInfoMapLocByCriteria(
			SiteInfoMapLoc siteInfoMapLoc) throws Exception {
		return siteInfoMapLocDao.querySiteInfoMapLoc(siteInfoMapLoc);
	}


	@Override
	public void deleteSiteInfoMapLoc(SiteInfoMapLoc siteInfoMapLoc)
			throws Exception {
		siteInfoMapLoc.setRecordStatus("N");
		siteInfoMapLocDao.mergeFlush(siteInfoMapLoc);
		
	}


	@Override
	public SiteInfoMapLoc querySiteInfoMapLocByRowId(String rowId)
			throws Exception {
		return siteInfoMapLocDao.findByRowId(rowId);
	}


	@Override
	public SiteInfoMapLoc updateSiteInfoMapLoc(SiteInfoMapLoc siteInfoMapLoc)
			throws Exception {
		return siteInfoMapLocDao.merge(siteInfoMapLoc);
	}


	@Override
	public void deleteSiteInfoMapLocList(List<SiteInfoMapLoc> siteInfoMapLocList)
			throws Exception {
		for(SiteInfoMapLoc siteInfoMapLoc : siteInfoMapLocList){
			this.deleteSiteInfoMapLoc(siteInfoMapLoc);
		}
		
	}



	


}
