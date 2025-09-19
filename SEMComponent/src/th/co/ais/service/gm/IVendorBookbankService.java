package th.co.ais.service.gm;

import java.util.List;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.gm.VendorBookbank;
import th.co.ais.service.util.ServiceConstants;

public interface IVendorBookbankService {

	public String queryByVendorMasterId(String vendorMasterId) throws Exception;
	public List<VendorBookbank> queryAllVendorBookbankService() throws Exception;
	public VendorBookbank getVendorBookbankByVendorMasterId(String vendorMasterId) throws Exception;
	public VendorBookbank queryVendorBookbankByVendorMaster(VendorBookbank vendorBookbank) throws Exception;
	public VendorBookbank queryByRowId(String rowId) throws Exception;
	public VendorBookbank queryByBankAccountNo(String bankAccNo) throws Exception;
	public List<VendorBookbank> searchVendorBookbank(VendorBookbank vendorBookBank) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public VendorBookbank createVendorBookbank(VendorBookbank vendorBookBank) throws Exception;
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public VendorBookbank updateVendorBookbank(VendorBookbank vendorBookBank) throws Exception;
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteVendorBookbank(VendorBookbank vendorBookBank) throws Exception;

	
}
