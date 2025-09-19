package th.co.ais.service.si;

import java.util.List;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.si.Insurance;
import th.co.ais.service.util.ServiceConstants;

public interface ISiteInsuranceService {
	
	public List querySPList(String spName, Object property) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public Insurance createSiteInsurance(Insurance siteInsurance) throws Exception;

	public Insurance queryInsuranceBySiteInfoId(String assignSiteInfoId) throws Exception;
	
	public Insurance queryInsuranceByRowId(String rowId) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public Insurance updateInsurance(Insurance insurance) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteInsurance(Insurance insurance) throws Exception;
}
