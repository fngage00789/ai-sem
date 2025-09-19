package th.co.ais.service.el;

import java.util.List;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.el.BgMaster;
import th.co.ais.domain.el.BgMasterFile;
import th.co.ais.domain.el.BgMasterSPEL;
import th.co.ais.domain.el.DepositDetail;
import th.co.ais.domain.el.ExportMainBgSP;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.PrivateDeposit;
import th.co.ais.domain.gm.Attachment;
import th.co.ais.service.BaseService;
import th.co.ais.service.util.ServiceConstants;

public interface IBgMasterService extends BaseService {

	public List<BgMaster> queryAllBgMaster() throws Exception;
	public List<BgMaster> queryByCriteria(BgMaster bgMaster) throws Exception;
	public List<BgMaster> queryByCriteria(String bgType, String expenseType, String bgStatus, String company, String electricUseType, String recordStatus) throws Exception;
	public BgMaster queryBGMasterByRowId(String rowId) throws Exception;
	public Integer countTotalMeterInfo(String bgMasterId, String plName) throws Exception;
	public void createBGMaster(BgMaster bgMaster) throws Exception;
	public void updateBGMaster(BgMaster bgMaster) throws Exception;
	public void updateBGMasterWithPL(BgMaster bgMaster, String plName) throws Exception;
	public void createBGMeaPea(BgMaster bgMaster, Management manage, String plName, List<Attachment> attachmentList) throws Exception;
	public void createBGPrivate(BgMaster bgMaster, Management manage, List<PrivateDeposit> privateDepositList, String plName, List<Attachment> attachmentList) throws Exception;
	public void updateByPl(String plName) throws Exception;
	public String createBGMasterReturnId(BgMaster bgMaster, List<Attachment> attachmentList) throws Exception;
	public BgMaster queryBgMasterByHQL(String hql, String bgMasterId) throws Exception;
	public List<BgMasterSPEL> queryBgMasterSP(String bgMasterId) throws Exception;
	public List<ExportMainBgSP> queryExportMainBgSP(String bgMasterId) throws Exception;
	public void createBgMapContractByPL(String plName, String bgMasterId, List<BgMaster> bgMasterList, List<DepositDetail> depositDetailList) throws Exception;
	public void deleteAttachment(String plName, String bgMasterId)throws Exception;
	public void updateBGMasterAttachment(BgMaster bgMaster,List<Attachment> attachmentList) throws Exception;
	public void updateBgMasterElctric(String rowId,String plName) throws Exception;
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteBgMasterRecord(BgMaster criteria) throws Exception;
	
}
