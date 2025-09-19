package th.co.ais.common.service;

import java.util.List;

import th.co.ais.service.BaseService;

public interface IMenuTreeService extends BaseService {
	
	public List querySPList(String spName, Object property) throws Exception;
	
}
