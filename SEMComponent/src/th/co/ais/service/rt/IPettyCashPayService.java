package th.co.ais.service.rt;

import java.util.List;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.rt.PettyCashPay;
import th.co.ais.domain.rt.PettyCashPaySP;
import th.co.ais.service.BaseService;
import th.co.ais.service.util.ServiceConstants;

public interface IPettyCashPayService extends BaseService {
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public PettyCashPay createPettyCashPay(PettyCashPay pettyCashPay) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public PettyCashPay updatePettyCashPay(PettyCashPay pettyCashPay) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deletePettyCashPay(PettyCashPay pettyCashPay) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public PettyCashPaySP updateExportDt(String pettyCashPayIds, String username) throws Exception;
	
	public PettyCashPay queryPettyCashPayByRowId(String rowId) throws Exception;
	
	public List querySPList(String spName, Object property) throws Exception;
	
	public Integer getCountByRowId(String fieldName, Class o, String rowId) throws Exception;
	
	public String getRunningNo(String runningType, String company) throws Exception;
	
}
