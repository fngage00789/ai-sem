package th.co.ais.service.impl.si;

import java.util.List;

import th.co.ais.dao.impl.si.SiteInfoHibernateDAO;
import th.co.ais.domain.si.SiteInfo;
import th.co.ais.service.AbstractService;
import th.co.ais.service.si.ISiteInfoService;

public class SiteInfoServiceImpl extends AbstractService implements ISiteInfoService{
	
	private SiteInfoHibernateDAO siteInfoDao;
	
	
	public SiteInfoHibernateDAO getSiteInfoDao() {
		return siteInfoDao;
	}

	public void setSiteInfoDao(SiteInfoHibernateDAO siteInfoDao) {
		this.siteInfoDao = siteInfoDao;
	}


	@Override
	@SuppressWarnings("unchecked")
	public List querySPList(String spName, Object property) throws Exception {
		return siteInfoDao.querySPList(spName, property);
	}

	@Override
	public SiteInfo createSiteInfo(SiteInfo siteInfo) throws Exception {
		siteInfo.setRowId(null);
		siteInfo.setRecordStatus("Y");
		return siteInfoDao.merge(siteInfo);
		
	}

	@Override
	public SiteInfo querySiteInfoByRowId(String rowId) throws Exception {
		return siteInfoDao.findByRowId(rowId);
	}

	@Override
	public SiteInfo updateSiteInfo(SiteInfo siteInfo) throws Exception {
		siteInfo.setRecordStatus("Y");
		return siteInfoDao.merge(siteInfo);
		
	}

	@Override
	public void deleteSiteInfo(SiteInfo siteInfo) throws Exception {
		siteInfo.setRecordStatus("N");
		siteInfoDao.mergeFlush(siteInfo);
		
	}

}
