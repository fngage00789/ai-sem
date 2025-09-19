package th.co.ais.service.impl.si;

import java.util.List;

import th.co.ais.dao.impl.si.SiteTerminateHibernateDAO;
import th.co.ais.domain.si.SiteTerminate;
import th.co.ais.service.AbstractService;
import th.co.ais.service.si.ISiteTerminateService;

public class SiteTerminateServiceImpl extends AbstractService implements ISiteTerminateService {
	
	private SiteTerminateHibernateDAO siteTerminateDao;



	public void setSiteTerminateDao(SiteTerminateHibernateDAO siteTerminateDao) {
		this.siteTerminateDao = siteTerminateDao;
	}



	@Override
	public SiteTerminate createSiteTerminate(SiteTerminate siteTerminate)
			throws Exception {
		siteTerminate.setRecordStatus("Y");
		return siteTerminateDao.merge(siteTerminate);
		
		
	}



	@Override
	public void deleteSiteTerminate(SiteTerminate siteTerminate)
			throws Exception {
		siteTerminate.setRecordStatus("N");
		siteTerminateDao.mergeFlush(siteTerminate);
	}



	@Override
	@SuppressWarnings("unchecked")
	public List querySPList(String spName, Object property)
			throws Exception {
		return siteTerminateDao.querySPList(spName, property);
	}



	@Override
	public SiteTerminate updateSiteTerminate(SiteTerminate siteTerminate)
			throws Exception {
		return siteTerminateDao.merge(siteTerminate);
	}



	@Override
	public SiteTerminate querySiteTerminateByRowId(String rowId)
			throws Exception {
		return siteTerminateDao.findByRowId(rowId);
	}



	@Override
	public List<SiteTerminate> querySiteTerminateByCriteria(
			SiteTerminate siteTerminate) throws Exception {
		return siteTerminateDao.querySiteTerminate(siteTerminate);
	}



	
	
	

	
}
