package th.co.ais.service.si;

import java.util.List;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.si.Electric;
import th.co.ais.service.util.ServiceConstants;

public interface ISiteElectricService {
	
	public List querySPList(String spName, Object property) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public Electric createSiteElectric(Electric siteElectric) throws Exception;
	
	public Electric queryElectricBySiteInfoId(String assignSiteInfoId) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public Electric updateSiteElectric(Electric siteElectric) throws Exception;
	
	public Electric queryRentByRowId(String rowId) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteElectric(Electric electric) throws Exception;
}
