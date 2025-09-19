package th.co.ais.service.el;

import java.util.List;

import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.PrivateDeposit;
import th.co.ais.service.BaseService;

public interface IPrivateDepositService extends BaseService{

	public List<PrivateDeposit> queryByManagement(final Management manage) throws Exception;
	public List<PrivateDeposit> queryByCriteria(String contractNo, String depositType, String depositSpecialFlag) throws Exception;
	public List<PrivateDeposit> queryByContractNoAndNewFlag(String contractNo, String newFlag, String recordStatus) throws Exception;
	public PrivateDeposit queryByRowId(String rowId) throws Exception;
	public void createPrivateDeposit(PrivateDeposit privateDeposit) throws Exception;
	public void updatePrivateDeposit(PrivateDeposit privateDeposit) throws Exception;
	public List<PrivateDeposit> queryByManagementWithDepositType(Management manage, String eLDEPOSITBGTYPE) throws Exception;////WT###Add 20110121
	public List<PrivateDeposit> queryPrivateDepositByPL(final Management manage,String plName ) throws Exception;
	
	public List<PrivateDeposit> queryByCriteria(String siteInfoId, String contractNo, String depositType, String depositSpecialFlag) throws Exception;//added by NEW
}
