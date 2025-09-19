package th.co.ais.service.si;

import java.util.List;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.si.SiteTerminate;
import th.co.ais.service.util.ServiceConstants;

public interface ISiteTerminateService {
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public SiteTerminate createSiteTerminate(SiteTerminate siteTerminate) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public SiteTerminate updateSiteTerminate(SiteTerminate siteTerminate) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteSiteTerminate(SiteTerminate siteTerminate) throws Exception;
	
	public List querySPList(String spName, Object property) throws Exception;
	
	public SiteTerminate querySiteTerminateByRowId(String rowId) throws Exception;
	
	public List<SiteTerminate> querySiteTerminateByCriteria(SiteTerminate siteTerminate) throws Exception;
	
}
