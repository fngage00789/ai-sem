package th.co.ais.service.si;

import java.util.List;

import th.co.ais.domain.si.SiteApprove;

public interface ISiteApproveService {
	
	public SiteApprove createSiteApprove(SiteApprove siteApprove) throws Exception;
	
	public SiteApprove updateSiteApprove(SiteApprove siteApprove) throws Exception;
	
	public void deleteSiteApprove(SiteApprove siteApprove) throws Exception;
	
	public SiteApprove querySiteApprove(SiteApprove siteApprove) throws Exception;
	
	public List querySPList(String spName, Object property) throws Exception;
	
	public SiteApprove querySiteApproveByRowId(String rowId) throws Exception;
}
