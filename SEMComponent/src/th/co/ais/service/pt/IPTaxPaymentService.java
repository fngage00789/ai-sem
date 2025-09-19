package th.co.ais.service.pt;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.pt.PtaxPayment;
import th.co.ais.service.BaseService;
import th.co.ais.service.util.ServiceConstants;

public interface IPTaxPaymentService extends BaseService{

	public PtaxPayment getPTaxPaymentByRowId(String rowId) throws Exception;

	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public void updatePtaxPayment(PtaxPayment pTaxPayment)throws Exception;
	
	
}
