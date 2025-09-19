package th.co.ais.service.impl.common;

import java.util.HashMap;

import th.co.ais.common.service.ICommonService;
import th.co.ais.exception.AISBusinessException;


public class CommonService implements ICommonService {
	
	public String hello(String name) throws AISBusinessException{
		return "hello spring in " + name;
	}
	
	public String helloException(String name) throws AISBusinessException{
		throw new AISBusinessException("Error in helloException ");
	}
	
	public HashMap testResultMap(String name) throws AISBusinessException{
		HashMap map = new HashMap();
		map.put("A", "A");
		map.put("B", "B");
		return map;
	}
}
