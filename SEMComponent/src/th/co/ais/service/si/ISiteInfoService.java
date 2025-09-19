package th.co.ais.service.si;

import java.util.List;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.si.SiteInfo;
import th.co.ais.service.util.ServiceConstants;

public interface ISiteInfoService {
	
	public List querySPList(String spName, Object property) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public SiteInfo createSiteInfo(SiteInfo siteInfo) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public SiteInfo updateSiteInfo(SiteInfo siteInfo) throws Exception;
	
	public SiteInfo querySiteInfoByRowId(String rowId) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteSiteInfo(SiteInfo siteInfo) throws Exception;

}
