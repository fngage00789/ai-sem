package th.co.ais.service.co;

import java.util.List;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.co.ContractStatus;
import th.co.ais.service.util.ServiceConstants;

public interface IContractStatusService {
	
	public List querySPList(String spName, Object property) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public ContractStatus createContractStatus(ContractStatus contractStatus) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public ContractStatus updateContractStatus(ContractStatus contractStatus) throws Exception;
	
	public ContractStatus queryContractStatusByRowId(String rowId) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteContractStatus(ContractStatus contractStatus) throws Exception;

}
