package th.co.ais.service.si;

import java.util.List;

import th.co.ais.domain.si.SiteApproveMapLoc;

public interface ISiteApproveMapLocService {
	
	public boolean createSiteApproveMapLoc(SiteApproveMapLoc siteApproveMapLoc) throws Exception;
	
	public void updateSiteApproveMapLoc(SiteApproveMapLoc siteApproveMapLoc) throws Exception;
	
	public void deleteSiteApproveMapLoc(SiteApproveMapLoc siteApproveMapLoc) throws Exception;
	
	public SiteApproveMapLoc querySiteApproveMapLoc(SiteApproveMapLoc siteApproveMapLoc) throws Exception;
	
	public List querySPList(String spName, Object property) throws Exception;
	
	public SiteApproveMapLoc getSiteApproveMapLocByRowId(String rowId) throws Exception;
	
}
