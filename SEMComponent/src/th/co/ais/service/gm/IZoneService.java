package th.co.ais.service.gm;

import java.util.List;

import th.co.ais.domain.gm.Zone;
import th.co.ais.service.BaseService;

public interface IZoneService extends BaseService{
	
	public List<Zone> searchZoneAll() throws Exception;
	public List<Zone> searchZone(final Zone zone) throws Exception;
}
