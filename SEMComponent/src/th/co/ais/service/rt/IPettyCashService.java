package th.co.ais.service.rt;

import java.math.BigDecimal;
import java.util.List;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.rt.PettyCash;
import th.co.ais.domain.rt.PettyCashSP;
import th.co.ais.service.BaseService;
import th.co.ais.service.util.ServiceConstants;

public interface IPettyCashService extends BaseService {
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public void createPettyCash(PettyCash pettyCash) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public PettyCash updatePettyCash(PettyCash pettyCash) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deletePettyCash(PettyCash pettyCash) throws Exception;
	
	public PettyCash queryPettyCashByRowId(String rowId) throws Exception;
	
	public List queryPettyCashSPList(String spName, Object property) throws Exception;
	
	public BigDecimal getSEQ(String fieldName, Class o) throws Exception;
	
	public Double getLastBalanceAmt(String company) throws Exception;
	
	public PettyCashSP mrt008Check(PettyCashSP property) throws Exception;
	
	public PettyCashSP mrt008BalanceAmount(PettyCashSP property) throws Exception;
}
