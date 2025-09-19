package th.co.ais.service.el;

import java.util.List;


import th.co.ais.domain.el.PaymentVendorMapPayee;
import th.co.ais.service.BaseService;

public interface IPaymentVendorMapPayeeService extends BaseService {
	
	public List<PaymentVendorMapPayee> queryVendorMasterByCriteria(PaymentVendorMapPayee vendorMapPayee) throws Exception;
	public PaymentVendorMapPayee qeuryVendorMasterByRowId(String rowId) throws Exception;
}
