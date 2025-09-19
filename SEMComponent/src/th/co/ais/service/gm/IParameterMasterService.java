package th.co.ais.service.gm;

import java.util.List;

import org.hibernate.Query;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.gm.LovMaster;
import th.co.ais.domain.gm.ParameterMaster;
import th.co.ais.service.BaseService;
import th.co.ais.service.util.ServiceConstants;
import th.co.ais.to.gm.LovMasterSearchTO;
import th.co.ais.to.gm.ParameterMasterSearchTO;

public interface IParameterMasterService extends BaseService{

	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public ParameterMaster createParameterMaster(ParameterMaster paramMaster) throws  Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public ParameterMaster updateParameterMaster(ParameterMaster paramMaster) throws  Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public ParameterMaster deleteParameterMaster(ParameterMaster paramMaster) throws  Exception;
	
	public List querySPList(String spName, Object property) throws Exception;
	
	public Query getSPQuery(String spName) throws Exception;
	
	public ParameterMaster queryParameterMasterByRowId(String rowId) throws Exception;
	
}
