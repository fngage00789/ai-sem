package th.co.ais.service.gm;

import java.util.List;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.gm.BgMaster;
import th.co.ais.domain.gm.CT002UpdateRentSP;
import th.co.ais.service.BaseService;
import th.co.ais.service.util.ServiceConstants;

public interface IBgMasterService extends BaseService {

	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public BgMaster createBgMaster(BgMaster bgMaster) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public void updateBgMaster(BgMaster bgMaster) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteBgMasterRecord(BgMaster criteria) throws Exception;
	
	public List<BgMaster> queryBgMasterByCriteria(BgMaster criteria) throws Exception;
	
	public BgMaster getBgMasterByRowId(String rowId) throws Exception;
	
	public List queryBGMasterSPList(String spName, Object property) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public CT002UpdateRentSP updateMCT002Rent(CT002UpdateRentSP property) throws Exception;
	
}
