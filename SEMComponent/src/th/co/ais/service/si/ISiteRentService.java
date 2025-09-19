package th.co.ais.service.si;

import java.util.List;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.si.Rent;
import th.co.ais.service.util.ServiceConstants;

public interface ISiteRentService {
	
	public List querySPList(String spName, Object property) throws Exception;

	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public Rent createSiteRent(Rent siteRent) throws Exception;
	
	public Rent queryRentBySiteInfoId(String assignSiteInfoId) throws Exception;
	
	public Rent queryRentByRowId(String rowId) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteSiteRent(Rent siteRent) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public Rent updateSiteRent(Rent siteRent) throws Exception;
}
