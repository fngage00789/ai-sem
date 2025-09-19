package th.co.ais.service.el;

import java.util.Date;
import java.util.List;

import th.co.ais.domain.el.BgMaster;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.ManagementSO;
import th.co.ais.domain.el.ManagementWrapper;
import th.co.ais.domain.el.PopupSiteSearch;
import th.co.ais.domain.el.PopupSiteSearchPrivate;
import th.co.ais.service.BaseService;

public interface IManagementService extends BaseService {

	public List<Management> queryManagementByCriteria(Management management) throws Exception;
	public List<Management> querySEMMEl001ManagementByCriteria(Management manage) throws Exception;
	public ManagementWrapper queryManagementWrapperByRowId(String rowId) throws Exception;
	public Management queryManagementByRowId(String rowId) throws Exception;
	public void createManagement(Management manage) throws Exception;
	public void updateManagement(Management manage) throws Exception;
	public void updateManagementWithPL(Management manage, String plName) throws Exception;
	public void callPL(String plName, int []inParamType, Object []inParamValue) throws Exception;
	public void updateReceiveJobNew(Management manage, BgMaster bgMaster, String plName) throws Exception;
	public void updateReceiveJobTerminate(Management manage, BgMaster bgMaster, String plName) throws Exception;
	public void updateVerifyPrivateNew(Management manage, String plName) throws Exception;
	public void updateVerifyPrivateTerminate(Management manage, String plName) throws Exception;
	public List<Management> queryManagementByContractNo(String contractNo) throws Exception;
	public List<Management> querySEMMEl001ManagementByPL(Management manage, String plName) throws Exception;
	public List<String>[] updateGroupReceive(String plName, Date groupReceiveDt, List<ManagementWrapper> groupReceiveList) throws Exception;
	public List<Management> queryManagementByContractNo06(String contractNo) throws Exception;
	public List<PopupSiteSearchPrivate> queryManagementByContractNo06ByPL(PopupSiteSearch popupSiteCriteria) throws Exception;//WT###Add 20110201
	public List<PopupSiteSearchPrivate> queryManagementByContractNo06PrepaidByPL(PopupSiteSearch popupSiteCriteria) throws Exception;//WT###Add 20110202
	public Object[] callPLWithReturnValue(String plName, int []inParamType, Object []inParamValue, int []outParamType) throws Exception;//WT###Add 20110301
	public List<ManagementSO> querySEMMEl001ManagementSO(Management manage) throws Exception;//WT###Add 200110526 
	public List<PopupSiteSearchPrivate> queryDepositDetailByID(PopupSiteSearch popupSiteCriteria)throws Exception;
	public List<ManagementSO> querySEMMEl001ManagementSOExport(Management manage) throws Exception; 
	public void updateManagementPrivate(Management manage) throws Exception;
	public List querySPList(String spName, Object property) throws Exception;
}
