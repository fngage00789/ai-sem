package th.co.ais.service.impl.si;

import java.util.List;

import th.co.ais.dao.impl.si.SiteApproveHibernateDAO;
import th.co.ais.domain.si.SiteApprove;
import th.co.ais.service.AbstractService;
import th.co.ais.service.si.ISiteApproveService;

public class SiteApproveServiceImpl extends AbstractService implements ISiteApproveService {
	
	private SiteApproveHibernateDAO siteApproveDao;
	 
	public void setSiteApproveDao(SiteApproveHibernateDAO siteApproveDao) {
		this.siteApproveDao = siteApproveDao;
	}

	@Override
	public SiteApprove createSiteApprove(SiteApprove siteApprove) throws Exception {
		return siteApproveDao.merge(siteApprove);
	}

	@Override
	public void deleteSiteApprove(SiteApprove siteApprove) throws Exception {
		siteApprove.setRecordStatus("N");
		siteApproveDao.mergeFlush(siteApprove);
	}

	@Override
	public SiteApprove querySiteApprove(SiteApprove siteApprove)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SiteApprove updateSiteApprove(SiteApprove siteApprove) throws Exception {
		return siteApproveDao.merge(siteApprove);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List querySPList(String spName, Object property) throws Exception {
		return siteApproveDao.querySPList(spName, property);
	}

	@Override
	public SiteApprove querySiteApproveByRowId(String rowId)
			throws Exception {
		return siteApproveDao.findByRowId(rowId);
	}
	
}
