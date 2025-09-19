package th.co.ais.service.si;

import java.util.List;
import th.co.ais.service.BaseService;

public interface IRegionZoneService extends BaseService{
	public List<Object[]> getRegionZone() throws Exception;
}
