package th.co.ais.service.gm;

import java.util.List;

import th.co.ais.domain.gm.Region;
import th.co.ais.service.BaseService;

public interface IRegionService extends BaseService{
	
	public List<Region> searchRegionByCode(String regionCd) throws Exception;
	
	public List<Region> searchRegionByName(String regionName) throws Exception;
	
	public List<Region> searchRegionAll() throws Exception;
	
	public List<Region> searchRegion(final Region region) throws Exception;
	
}
