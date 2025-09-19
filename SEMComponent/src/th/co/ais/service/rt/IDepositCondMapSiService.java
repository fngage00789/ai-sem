package th.co.ais.service.rt;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.rt.DepositCondMapSi;
import th.co.ais.domain.rt.RentalDetail;
import th.co.ais.service.util.ServiceConstants;

public interface IDepositCondMapSiService {

	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public DepositCondMapSi createDepositCondMapSi(DepositCondMapSi dpstCondMapSi) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public DepositCondMapSi updateDepositCondMapSi(DepositCondMapSi dpstCondMapSi) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteDepositCondMapSi(DepositCondMapSi dpstCondMapSi) throws Exception;
	
	public DepositCondMapSi queryByRowId(String rowId) throws Exception;
}
