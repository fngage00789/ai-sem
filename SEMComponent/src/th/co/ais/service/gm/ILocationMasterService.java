package th.co.ais.service.gm;

import java.util.List;

import th.co.ais.domain.gm.LocationMaster;
import th.co.ais.service.BaseService;

public interface ILocationMasterService extends BaseService {

	public List<LocationMaster> searchLocationMasterByCode(String locationCode) throws Exception;
	
	public List<LocationMaster> searchLocationMasterByName(String locationName) throws Exception;
	
	public List<LocationMaster> searchLocationMaster(LocationMaster location) throws Exception;
	
	public void createLocationMaster(LocationMaster location) throws Exception;
}
