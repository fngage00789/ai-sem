package th.co.ais.service.gm;

import java.util.List;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.gm.Bank;
import th.co.ais.service.BaseService;
import th.co.ais.service.util.ServiceConstants;

public interface IBankService extends BaseService{
	
	public List<Bank> searchBank(Bank bank) throws Exception;
	
	public Bank queryBankByCode(String bankCode) throws Exception;
	
	public List<Bank> queryBankAll() throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public Bank createBank(Bank bank) throws Exception;
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public Bank updateBank(Bank bank) throws Exception;
	
}
