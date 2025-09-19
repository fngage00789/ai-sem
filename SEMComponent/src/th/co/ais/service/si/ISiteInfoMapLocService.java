package th.co.ais.service.si;

import java.util.List;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.si.SiteInfoMapLoc;
import th.co.ais.service.util.ServiceConstants;

public interface ISiteInfoMapLocService {

	public List querySPList(String spName, Object property) throws Exception;
	
	public List<SiteInfoMapLoc> querySiteInfoMapLocByCriteria(SiteInfoMapLoc siteInfoMapLoc) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public void createSiteInfoMapLoc(List<SiteInfoMapLoc> siteInfoMapLocList) throws Exception;
	
	public Boolean checkSiteInfoMapLocDuplicate(SiteInfoMapLoc siteInfoMapLoc) throws Exception;
	
	public SiteInfoMapLoc querySiteInfoMapLocByRowId(String rowId) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public SiteInfoMapLoc updateSiteInfoMapLoc(SiteInfoMapLoc siteInfoMapLoc) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteSiteInfoMapLoc(SiteInfoMapLoc siteInfoMapLoc) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteSiteInfoMapLocList(List<SiteInfoMapLoc> siteInfoMapLocList) throws Exception; 
}
