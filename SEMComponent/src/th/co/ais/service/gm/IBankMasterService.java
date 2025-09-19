package th.co.ais.service.gm;

import java.util.List;

import th.co.ais.service.BaseService;

public interface IBankMasterService {

	public List querySPList(String spName, Object property) throws Exception;
}
