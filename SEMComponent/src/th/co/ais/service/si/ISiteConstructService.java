package th.co.ais.service.si;

import java.util.List;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.si.Construct;
import th.co.ais.service.util.ServiceConstants;

public interface ISiteConstructService {
	
	public List querySPList(String spName, Object property) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public Construct createSiteConstruct(Construct siteConstruct) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public Construct updateConstruct(Construct construct) throws Exception;
	
	public Construct queryConstructBySiteInfoId(String assignSiteInfoId) throws Exception;
	
	public Construct querySiteConstructByRowId(String rowId) throws Exception ;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteConstruct(Construct construct) throws Exception;
	
	public Construct createSiteConstructWithOutUser(Construct siteConstruct) throws Exception;
	
	public Construct updateConstructWithOutUser(Construct construct) throws Exception;
}
