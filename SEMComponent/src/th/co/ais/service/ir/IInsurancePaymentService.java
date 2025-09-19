package th.co.ais.service.ir;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.ir.InsurancePayment;
import th.co.ais.service.BaseService;
import th.co.ais.service.util.ServiceConstants;

public interface IInsurancePaymentService extends BaseService {
	
	public InsurancePayment getInsurancePaymentByRowId(String insurancePaymentId) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public void updateInsurancePayment(InsurancePayment insurancePayment) throws Exception;
}
