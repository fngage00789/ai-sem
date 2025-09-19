package th.co.ais.service.si;

import java.util.List;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.si.SubRent;
import th.co.ais.service.util.ServiceConstants;

public interface ISiteSubRentService {
	
	public List querySPList(String spName, Object property) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public SubRent createSiteSubRent(SubRent siteSubRent) throws Exception;
	
	public List<SubRent> querySubRentBySiteInfoId(String assignSiteInfoId) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public void createSiteSubRentList(List<SubRent> siteSubRentList, String siteInfoId, String user) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public SubRent updateSubRent(SubRent subRent) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteSubRent(SubRent subRent) throws Exception;
	
	public SubRent querySubRentByRowId(String rowId) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteSubRentList(List<SubRent> subRentList) throws Exception;

}
