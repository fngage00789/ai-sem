package th.co.ais.service.si;

import java.util.List;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.si.Deposit;
import th.co.ais.service.util.ServiceConstants;

public interface ISiteDepositService {
	
	public List querySPList(String spName, Object property) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public Deposit createSiteDeposit(Deposit siteDeposit) throws Exception;

	public List<Deposit> queryDepositBySiteInfoId(String assignSiteInfoId) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public void createSiteDepositList(List<Deposit> siteDepositList, String siteInfoId, String user) throws Exception;
	
	public Deposit queryDepositByRowId(String rowId) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteDeposit(Deposit siteDeposit) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public Deposit updateDeposit(Deposit siteDeposit) throws Exception;
	
	List<Deposit> queryDepositBySiteInfoIdAndDepositCondType(String siteInfoId, String depositCondType) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteDepositList(List<Deposit> siteDepositList) throws Exception;
}
