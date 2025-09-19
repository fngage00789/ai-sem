package th.co.ais.service.gm;

import java.util.HashMap;
import java.util.List;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.gm.VendorMapPayee;
import th.co.ais.service.BaseService;
import th.co.ais.service.util.ServiceConstants;

public interface IVendorMapPayeeService extends BaseService {

public List<VendorMapPayee> queryAllVendorMapPayeeMaster() throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public VendorMapPayee createVendorMapPayee(VendorMapPayee vendorMapPayee) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public VendorMapPayee updateVendorMapPayee(VendorMapPayee vendorMapPayee) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public boolean updateVendorMapPayeeM(VendorMapPayee vendorMapPayee) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public VendorMapPayee updateVendorMapPayeeInfo(VendorMapPayee vendorMapPayee) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteVendorMapPayee(VendorMapPayee vendorMapPayee) throws Exception;
	
	public VendorMapPayee queryByRowId(String rowId) throws Exception;
	
	public VendorMapPayee queryByVendorMasterId(String vendorMasterId) throws Exception;
	
	public String getRunningNo(String runningType) throws Exception;
	
	public VendorMapPayee checkVendorNoMapExisted(String contractNo, String expenseType, String vendorMasterId) throws Exception;

	public VendorMapPayee checkVendorMapExisted(String contractNo,
			String expenseType, String vendorMasterId, String payeeMasterId)
			throws Exception;
	
	public VendorMapPayee queryVendorMapPayeeMasterForCash(String expenseType,String recordStatus) throws Exception;
	public HashMap<String,String> queryVendorPayeeBankForCash(String expenseType, String recordStatus) throws Exception;
	
}
