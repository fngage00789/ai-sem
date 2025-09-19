package th.co.ais.service.gm;

import java.util.List;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.gm.PayeeBookbank;
import th.co.ais.domain.gm.PayeeMaster;
import th.co.ais.domain.gm.VendorMapPayee;
import th.co.ais.service.BaseService;
import th.co.ais.service.util.ServiceConstants;

public interface IPayeeMasterService extends BaseService {

	public List<PayeeMaster> queryAllPayeeMaster() throws Exception;
	public List<PayeeMaster> queryPayeeMasterByCriteria(PayeeMaster PayeeMaster) throws Exception;
	public List queryPayeeMasterSPList(String spName, Object property) throws Exception;
	public PayeeMaster queryPayeeMasterByRowId(String rowId) throws Exception;
	public PayeeMaster queryPayeeMasterByIdCard(String idCardNo) throws Exception;
	public PayeeMaster queryPayeeMasterByTaxId(String taxIdNo) throws Exception;
	public PayeeMaster queryPayeeMasterByPayeeName(String payeeName) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public Object[] createPayeeMasterInfo(String vendorMasterId, PayeeMaster payeeMaster, VendorMapPayee vendorMapPayee, PayeeBookbank payeeBookbank) throws Exception;
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public Object[] updatePayeeMasterInfo(PayeeMaster payeeMaster, VendorMapPayee vendorMapPayee, PayeeBookbank payeeBookbank) throws Exception;
	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public PayeeMaster createPayeeMaster(PayeeMaster payeeMaster) throws Exception;
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deletePayeeMaster(PayeeMaster payeeMaster) throws Exception;
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public PayeeMaster updatePayeeMaster(PayeeMaster payeeMaster) throws Exception;
	
	
	
}
