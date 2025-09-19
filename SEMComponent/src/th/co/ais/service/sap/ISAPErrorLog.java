package th.co.ais.service.sap;

import java.util.List;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.sap.SapErrorLog;
import th.co.ais.service.BaseService;
import th.co.ais.service.util.ServiceConstants;

public interface ISAPErrorLog extends BaseService {
		
	public SapErrorLog getSapErrorLogByRowId(String rowId) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public SapErrorLog updateSapErrorLog(SapErrorLog sapErrorLog)throws Exception;
	
	public List querySPList(String spName, Object property) throws Exception;
}
