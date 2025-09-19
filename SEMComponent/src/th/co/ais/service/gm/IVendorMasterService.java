package th.co.ais.service.gm;

import java.util.List;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.gm.CT001Export;
import th.co.ais.domain.gm.CT001SrchMSP;
import th.co.ais.domain.gm.CT001UpdateSP;
import th.co.ais.domain.gm.SPStatus;
import th.co.ais.domain.gm.VendorBookbank;
import th.co.ais.domain.gm.VendorMapPayee;
import th.co.ais.domain.gm.VendorMaster;
import th.co.ais.domain.mm.ItemMasterSP;
import th.co.ais.domain.mm.Mmm001ContractSP;
import th.co.ais.service.BaseService;
import th.co.ais.service.util.ServiceConstants;

public interface IVendorMasterService extends BaseService {
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public Object[] createVendorMasterInfo(VendorMaster vdm, VendorMapPayee vmp, VendorBookbank vbb) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public Object[] updateVendorMasterInfo(VendorMaster vdm, VendorMapPayee vmp, VendorBookbank vbb) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public VendorMaster createVendorMaster(VendorMaster vendorMaster) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteVendorMaster(VendorMaster vendorMaster) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public VendorMaster updateVendorMaster(VendorMaster vendorMaster) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public SPStatus updateStatus(String vendorMapPayeeIds, String userId) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE) 
	public CT001UpdateSP updateMCT001(String vendorMasterId, String vendorMapPayeeId, String userId, String lessorId) throws Exception;
	
	public List<VendorMaster> queryVendorMaster(VendorMaster vendorMaster, String orderBy) throws Exception;
	
	public VendorMaster queryVendorMasterByRowId(String rowId) throws Exception;
	
	public VendorMaster queryVendorMasterByIdCard(String idCard) throws Exception;
	
	public VendorMaster queryVendorMasterByTaxId(String taxId) throws Exception;
	
	public VendorMaster queryVendorMasterByTaxId13(String taxId13) throws Exception;
	
	public VendorMaster queryVendorMasterByVendorName1(String vendorName1) throws Exception;
	
	public List<VendorMaster> queryAllVendorMaster() throws Exception;	
	
	public List queryVendorMasterSPList(String spName, Object property) throws Exception;
	
	public CT001SrchMSP queryCT001SrchMSPByVendorMasterId(String vendorMasterId) throws Exception;
	
	public List<CT001Export> queryCT001ForExport(String vendorMasterIds) throws Exception;
	
	public String getRunningNo(String runningType) throws Exception;
	
	public List querySPList(String spName, Object property) throws Exception;
	
	public List<String> getVendorCodeList(String contractNo) throws Exception;

	// --
	public List getRegionMasterCheckList(String spName) throws Exception;
//	public Mmm001ContractSP queryVendorContractByRowId(String spName, String rowId) throws Exception;
}
