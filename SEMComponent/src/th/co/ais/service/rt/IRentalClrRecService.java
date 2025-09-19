package th.co.ais.service.rt;

import java.util.List;

import th.co.ais.domain.annotation.ModuleAction;
import th.co.ais.domain.rt.RentalClrRec;
import th.co.ais.service.util.ServiceConstants;

public interface IRentalClrRecService {

	@ModuleAction(ServiceConstants.MODULE_ACTION_INSERT)
	public RentalClrRec createRentalClrRec(RentalClrRec rentalClrRec) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_UPDATE)
	public RentalClrRec updateRentalClrRec(RentalClrRec rentalClrRec) throws Exception;
	
	@ModuleAction(ServiceConstants.MODULE_ACTION_DELETE)
	public void deleteRentalClrRec(String rowId) throws Exception;
	
	@SuppressWarnings("unchecked")
	public List querySPList(String spName, Object property) throws Exception;

	public RentalClrRec queryByRowId(String rowId) throws Exception;
	
	public boolean updateRentalClrRec(List<RentalClrRec> rentalClrRecArr) throws Exception;
	
}
