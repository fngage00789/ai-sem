package th.co.ais.service.pt;

import java.util.List;

import th.co.ais.service.BaseService;

public interface IPTaxMasterService extends BaseService{

	public List querySPList(String spName, Object property) throws Exception;
	
}
