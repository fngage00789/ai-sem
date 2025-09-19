package th.co.ais.service.si;

import java.util.List;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.si.PropertyTax;
import th.co.ais.service.util.ServiceConstants;

public interface ISitePropertyTaxService {
	
	public List querySPList(String spName, Object property) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public PropertyTax createSitePropertyTax(PropertyTax sitePropertyTax) throws Exception;
	
	public PropertyTax queryPropertyTaxBySiteInfoId(String assignSiteInfoId) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public PropertyTax updateSitePropertyTax(PropertyTax sitePropertyTax) throws Exception;

	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteSitePropertyTax(PropertyTax sitePropertyTax) throws Exception;
}
