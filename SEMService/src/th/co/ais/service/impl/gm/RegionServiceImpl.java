package th.co.ais.service.impl.gm;
import java.util.List;

import th.co.ais.dao.exception.DAOException;
import th.co.ais.dao.impl.gm.RegionHibernateDAO;
import th.co.ais.domain.gm.Region;
import th.co.ais.service.AbstractService;
import th.co.ais.service.gm.IRegionService;

public class RegionServiceImpl extends AbstractService implements IRegionService {
	
	private RegionHibernateDAO regionDao;
	
	public void setRegionDao(RegionHibernateDAO regionDao) {
		this.regionDao = regionDao;
	}

	@Override
	public List<Region> searchRegionByCode(String regionCode) throws Exception {
		Region region = new Region();
		region.setRowId(regionCode);
		return regionDao.queryRegion(region);
	}

	@Override
	public List<Region> searchRegionByName(String regionName) throws Exception {
		Region region = new Region();
		region.setThaiDescription(regionName);
		return regionDao.queryRegion(region);
	}

	@Override
	public List<Region> searchRegionAll() throws Exception {
		return regionDao.getRegionAll();
	}
	
	@Override
	public List<Region> searchRegion(final Region region) throws Exception {
		return regionDao.queryRegion(region);
	}

}
