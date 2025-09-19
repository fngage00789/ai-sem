package th.co.ais.service.impl.si;

import java.util.List;
import java.util.Map;

import th.co.ais.dao.impl.si.RegionZoneDAO;
import th.co.ais.domain.si.RegionZone;
import th.co.ais.service.AbstractService;
import th.co.ais.service.si.IRegionZoneService;

public class RegionZoneServiceImpl extends AbstractService implements IRegionZoneService{
	
	private RegionZoneDAO  regionZoneDao; 
	
	@Override
	public List<Object[]> getRegionZone() throws Exception {
		return regionZoneDao.searchRegionZone();
	}

	public RegionZoneDAO getRegionZoneDao() {
		return regionZoneDao;
	}

	public void setRegionZoneDao(RegionZoneDAO regionZoneDao) {
		this.regionZoneDao = regionZoneDao;
	}

}
