package th.co.ais.service.rt;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.rt.RentalCondMapSi;
import th.co.ais.service.util.ServiceConstants;

public interface IRentalCondMapSiService {

	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public void createRentalCondMapSi(RentalCondMapSi rentalCondMapSi) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public void updateRentalCondMapSi(RentalCondMapSi rentalCondMapSi) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteRentalCondMapSi(RentalCondMapSi rentalCondMapSi) throws Exception;
	
	public RentalCondMapSi queryByRowId(String rowId) throws Exception;
	
}
