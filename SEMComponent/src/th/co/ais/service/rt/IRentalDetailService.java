package th.co.ais.service.rt;

import java.util.List;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.rt.RentalCondMapSi;
import th.co.ais.domain.rt.RentalDetail;
import th.co.ais.service.util.ServiceConstants;

public interface IRentalDetailService {

	public List querySPList(String spName, Object property) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public RentalDetail createRentalDetail(RentalDetail rentalDetail) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public RentalDetail updateRentalDetail(RentalDetail rentalDetail) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteRentalDetail(RentalDetail rentalDetail) throws Exception;
	
	public RentalDetail queryByRowId(String rowId) throws Exception;
	
	public RentalDetail saveVerifyRentalSetup(RentalDetail oDetail, List<RentalCondMapSi> oList, String mode) throws Exception;
}
