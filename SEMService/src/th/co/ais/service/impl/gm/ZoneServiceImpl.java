package th.co.ais.service.impl.gm;

import java.util.ArrayList;
import java.util.List;

import th.co.ais.dao.impl.gm.ZoneHibernateDAO;
import th.co.ais.domain.gm.Zone;
import th.co.ais.service.AbstractService;
import th.co.ais.service.gm.IZoneService;

public class ZoneServiceImpl extends AbstractService implements IZoneService{

	private ZoneHibernateDAO zoneDao;
	
	public void setZoneDao(ZoneHibernateDAO zoneDao) {
		this.zoneDao = zoneDao;
	}

	@Override
	public List<Zone> searchZoneAll() throws Exception {
		return zoneDao.getZoneAll();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Zone> searchZone(Zone zone) throws Exception {
		List<Zone> zoneList = new ArrayList<Zone>();
		Zone zoneTmp = new Zone();
		List<Object[]> objZoneList = zoneDao.searchZoneByRegion(zone);
		for(Object[] zoneObj : objZoneList){
			zoneTmp = new Zone();
			zoneTmp.setRegion(zoneObj[0].toString());
			zoneTmp.setZone(zoneObj[1].toString());
			zoneTmp.setDescription(zoneObj[2].toString());
			zoneList.add(zoneTmp);
		}
		return zoneList;
	}

}
