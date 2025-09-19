package th.co.ais.service.rt;

import java.util.List;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.rt.ReturnDeposit;
import th.co.ais.service.util.ServiceConstants;

public interface IReturnDepositService {

	public List querySPList(String spName, Object property) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public ReturnDeposit createReturnDeposti(ReturnDeposit returnDeposit) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public ReturnDeposit updateReturnDeposit(ReturnDeposit returnDeposit) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteReturnDeposit(String rowId) throws Exception;
	
	public ReturnDeposit queryByRowId(String rowId) throws Exception;
}
