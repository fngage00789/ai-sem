package th.co.ais.service.gm;

import java.util.List;

import th.co.ais.domain.gm.Parameter;
import th.co.ais.service.BaseService;

public interface IParameterService extends BaseService {

	public List<Parameter> queryAllParameter() throws Exception;
	
}
