package th.co.ais.service.impl.si;

import java.util.List;

import th.co.ais.dao.impl.si.SiteApproveMapLocHibernateDAO;
import th.co.ais.domain.si.SiteApproveMapLoc;
import th.co.ais.service.AbstractService;
import th.co.ais.service.si.ISiteApproveMapLocService;

public class SiteApproveMapLocServiceImpl extends AbstractService implements ISiteApproveMapLocService {
	
	private SiteApproveMapLocHibernateDAO siteApproveMapLocDao;
	
	public void setSiteApproveMapLocDao(SiteApproveMapLocHibernateDAO siteApproveMapLocDao) {
		this.siteApproveMapLocDao = siteApproveMapLocDao;
	}

	@Override
	public boolean createSiteApproveMapLoc(SiteApproveMapLoc siteApproveMapLoc)
			throws Exception {
		if (siteApproveMapLocDao.checkDuplicateByLocationIdAndSiteApproveId(siteApproveMapLoc)) {
			// กรณี มีข้อมูล ซ้ำ
			return false;
		}
		siteApproveMapLocDao.save(siteApproveMapLoc);
		return true;
	}

	@Override
	public void deleteSiteApproveMapLoc(SiteApproveMapLoc siteApproveMapLoc)
			throws Exception {
		siteApproveMapLoc.setRecordStatus("N");
		siteApproveMapLocDao.mergeFlush(siteApproveMapLoc);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List querySPList(String spName, Object property) throws Exception {
		return siteApproveMapLocDao.querySPList(spName, property);
	}

	@Override
	public SiteApproveMapLoc querySiteApproveMapLoc(
			SiteApproveMapLoc siteApproveMapLoc) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSiteApproveMapLoc(SiteApproveMapLoc siteApproveMapLoc)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SiteApproveMapLoc getSiteApproveMapLocByRowId(String rowId)
			throws Exception {
		return siteApproveMapLocDao.findByRowId(rowId);
	}
	
}
