package th.co.ais.service.si;

import java.util.List;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.si.SendRenew;
import th.co.ais.service.BaseService;
import th.co.ais.service.util.ServiceConstants;
//
public interface ISendRenewService extends BaseService{
	
	public List querySPList(String spName, Object property) throws Exception;
	
	public SendRenew querySendRenewByRowId(String rowId)throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteSendRenew(SendRenew sendRenew)throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public void createSendRenew(SendRenew sendRenew)throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public void updateSendRenew(SendRenew sendRenew)throws Exception;
}
