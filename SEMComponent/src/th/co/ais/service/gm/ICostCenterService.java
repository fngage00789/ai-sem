package th.co.ais.service.gm;

import java.util.List;

import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.gm.CostCenter;
import th.co.ais.service.BaseService;
import th.co.ais.service.util.ServiceConstants;

public interface ICostCenterService extends BaseService{
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_SELECT)
	public List<CostCenter> searchCostCenterByCriteria(CostCenter costCenter)throws DAOException ;
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public void updateCostCenter(CostCenter costCenter)throws DAOException ;
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteCostCenterByCriteria(CostCenter costCenter)throws DAOException ;
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteCostCenterById(String id)throws DAOException ;
	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public CostCenter createCostCenter(CostCenter costCenter)throws DAOException ;
	@ModuleAction(ServiceConstants.MODULE_ACTION_SELECT)
	public List<CostCenter> searchCostCenterById(String id)throws DAOException ;
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public List<CostCenter> updateCostCenterById(String id)throws DAOException ;
}
