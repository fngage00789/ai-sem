package th.co.ais.service.si;

import java.util.List;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.si.Contract;
import th.co.ais.service.util.ServiceConstants;

public interface ISiteContractService {
	
	public List querySPList(String spName, Object property) throws Exception;
	
	public List<Contract> searchContract(final Contract contract, final String orderBy) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public Contract createContract(Contract contract) throws Exception;
	
	public Contract queryContractBySiteInfoId(String assignSiteInfoId) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public Contract updateContract(Contract contract)throws Exception;
	
	public Contract queryContractByRowId(String rowId) throws Exception;
	
	public String getLessorAddressBySiteInfoId(String siteInfoId) throws Exception;
	
	public String getSiteAddressBySiteInfoId(String siteInfoId) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteContract(Contract contract) throws Exception;

}
