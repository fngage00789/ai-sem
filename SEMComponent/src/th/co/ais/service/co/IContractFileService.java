package th.co.ais.service.co;

import java.util.List;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.co.ContractFile;
import th.co.ais.service.util.ServiceConstants;

public interface IContractFileService {
	
	public List querySPList(String spName, Object property) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public ContractFile createContractFile(ContractFile contractFile) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public ContractFile updateContractFile(ContractFile contractFile) throws Exception;
	
	public ContractFile queryContractFileByRowId(String rowId) throws Exception;
	
	public ContractFile queryContractFileByContractId(String rowId) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteContractFile(ContractFile contractFile) throws Exception;
	

}
