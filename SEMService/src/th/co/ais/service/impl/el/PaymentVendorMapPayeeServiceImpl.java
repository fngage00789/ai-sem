package th.co.ais.service.impl.el;

import java.util.List;

import th.co.ais.dao.impl.el.PaymentVendorMapPayeeHibernateDAO;
import th.co.ais.domain.el.PaymentVendorMapPayee;
import th.co.ais.service.AbstractService;
import th.co.ais.service.el.IPaymentVendorMapPayeeService;

public class PaymentVendorMapPayeeServiceImpl extends AbstractService implements IPaymentVendorMapPayeeService {

	private PaymentVendorMapPayeeHibernateDAO vendorMapPayeeDao;
	
	public void setVendorMapPayeeDao(PaymentVendorMapPayeeHibernateDAO vendorMapPayeeDao) {
		
		this.vendorMapPayeeDao = vendorMapPayeeDao;
	}

	@Override
	public List<PaymentVendorMapPayee> queryVendorMasterByCriteria(PaymentVendorMapPayee vendorMapPayee) throws Exception {
		
		return vendorMapPayeeDao.queryPaymentVendorMapPayeeByCodeStatus(vendorMapPayee);
	}

	@Override
	public PaymentVendorMapPayee qeuryVendorMasterByRowId(String rowId) throws Exception {
		
		return null;
	}
}
