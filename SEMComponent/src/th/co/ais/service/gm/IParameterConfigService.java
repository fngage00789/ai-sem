package th.co.ais.service.gm;

import java.util.List;

import th.co.ais.domain.gm.ParameterConfig;
import th.co.ais.service.BaseService;

public interface IParameterConfigService extends BaseService {
	
	public List<ParameterConfig> queryParameterConfigAll() throws Exception; 
	public String queryParameterConfigByValue(String paramValue) throws Exception;

}
