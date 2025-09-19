package th.co.ais.service.si;

import java.util.List;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.si.RentCond;
import th.co.ais.service.util.ServiceConstants;

public interface ISiteRentCondService {
	
	public List querySPList(String spName, Object property) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public RentCond createSiteRentCond(RentCond siteRentCond) throws Exception;

	public List<RentCond> queryRentCondBySiteInfoId(String assignSiteInfoId) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public void createSiteRentCondList(List<RentCond> siteRentCondList, String siteInfoId, String user, String reqType) throws Exception;
	
	public RentCond queryRentCondByRowId(String rowId) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteRentCond(RentCond rentCond) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public RentCond updateRentCond(RentCond rentCond) throws Exception;
	
	public List<RentCond> queryRentCondBySiteInfoIdAndRentCondType(String siteInfoId, String rentCondType) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteRentCondList(List<RentCond> rentCondList) throws Exception;
}
