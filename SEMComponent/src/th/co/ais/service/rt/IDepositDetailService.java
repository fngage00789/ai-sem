package th.co.ais.service.rt;

import java.util.List;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.rt.DepositCondMapSi;
import th.co.ais.domain.rt.DepositDetail;
import th.co.ais.service.util.ServiceConstants;

public interface IDepositDetailService {

	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public DepositDetail createDepositDetail(DepositDetail depositDetail) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public DepositDetail updateDepositDetail(DepositDetail depositDetail) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteDepositDetail(DepositDetail depositDetail) throws Exception;
	
	@SuppressWarnings("unchecked")
	public List querySPList(String spName, Object property) throws Exception;
	
	public DepositDetail queryByRowId(String rowId) throws Exception;
	
	public DepositDetail saveVerifyDepositSetup(DepositDetail oDetail, List<DepositCondMapSi> oList, String mode) throws Exception;
	
	public void deleteVerifyDepositSetup(DepositDetail oDetail) throws Exception;
}
