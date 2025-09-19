package th.co.ais.service.rt;

import java.util.List;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.rt.RentalPayment;
import th.co.ais.service.util.ServiceConstants;

public interface IRentalPaymentService {
	
	public List querySPList(String spName, Object property) throws Exception;
	
	public RentalPayment getRentalPaymentByRowId(String rentalPaymentId) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public void updateRentalPayment(RentalPayment rentalpayment) throws Exception;
}
