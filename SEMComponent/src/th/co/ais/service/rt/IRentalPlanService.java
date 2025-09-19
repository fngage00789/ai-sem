package th.co.ais.service.rt;

import java.util.List;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.rt.RentalPlan;
import th.co.ais.service.util.ServiceConstants;

public interface IRentalPlanService {

	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public void createRentalPlan(RentalPlan rentalPlan) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public void updateRentalPlan(RentalPlan rentalPlan) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteRentalPlan(RentalPlan rentalPlan) throws Exception;
	
	public RentalPlan queryRentalPlanByRowId(String rowId) throws Exception;
	
	public List<RentalPlan> queryRentalPlanByCriteria(RentalPlan rentalPlan) throws Exception;
}
