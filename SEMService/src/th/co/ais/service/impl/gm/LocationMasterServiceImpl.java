package th.co.ais.service.impl.gm;

import java.util.List;

import th.co.ais.dao.impl.gm.LocationMasterHibernateDAO;
import th.co.ais.domain.gm.LocationMaster;
import th.co.ais.service.AbstractService;
import th.co.ais.service.gm.ILocationMasterService;

public class LocationMasterServiceImpl extends AbstractService implements ILocationMasterService{

	private LocationMasterHibernateDAO locationDao;
	
	public void setLocationMasterDao(LocationMasterHibernateDAO locationDao) {
		this.locationDao = locationDao;
	}

	@Override
	public List<LocationMaster> searchLocationMaster(LocationMaster location) throws Exception {
		return locationDao.queryLocationMaster(location);
	}

	@Override
	public List<LocationMaster> searchLocationMasterByCode(String locationCode)
			throws Exception {
		LocationMaster location = new LocationMaster();
		location.setLocationCode(locationCode);
		return locationDao.queryLocationMaster(location);
	}

	@Override
	public List<LocationMaster> searchLocationMasterByName(String locationName)
			throws Exception {
		LocationMaster location = new LocationMaster();
		location.setLocationName(locationName);
		return locationDao.queryLocationMaster(location);
	}

	@Override
	public void createLocationMaster(LocationMaster location) throws Exception {
		locationDao.save(location);
	}

}
