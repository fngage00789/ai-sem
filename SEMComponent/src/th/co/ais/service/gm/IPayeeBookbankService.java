package th.co.ais.service.gm;

import java.util.List;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.gm.PayeeBookbank;
import th.co.ais.service.util.ServiceConstants;

public interface IPayeeBookbankService {

	public PayeeBookbank queryByPayeeMasterId(String payeeMasterId) throws Exception;
	public List<PayeeBookbank> queryAllPayeeBookbank() throws Exception;
	public List<PayeeBookbank> queryPayeeBookbankByPayeeId(String payeeId) throws Exception;
	public List<PayeeBookbank> queryPayeeBookbankByPayee(PayeeBookbank payeeBookbank) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public PayeeBookbank createPayeeBookbank(PayeeBookbank payeeBookbank) throws Exception;
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public PayeeBookbank updatePayeeBookbank(PayeeBookbank payeeBookbank) throws Exception;
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deletePayeeBookbank(PayeeBookbank payeeBookbank) throws Exception;
	
	
	
}
