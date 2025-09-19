package th.co.ais.service.co;

import java.util.List;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.co.ContractCheckDoc;
import th.co.ais.service.util.ServiceConstants;

public interface IContractCheckDocService {
	
	public List querySPList(String spName, Object property) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public ContractCheckDoc createContractCheckDoc(ContractCheckDoc contractCheckDoc) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public ContractCheckDoc updateContractCheckDoc(ContractCheckDoc contractCheckDoc) throws Exception;
	
	public ContractCheckDoc queryContractCheckDocByRowId(String rowId) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteContractCheckDoc(ContractCheckDoc contractCheckDoc) throws Exception;
	
	public List<ContractCheckDoc> queryContractCheckDocByContractId(String contractId) throws Exception;

}
