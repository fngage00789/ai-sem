package th.co.ais.service.impl.gm;

import java.util.List;

import th.co.ais.dao.impl.gm.ParameterConfigHibernateDAO;
import th.co.ais.domain.gm.ParameterConfig;
import th.co.ais.service.AbstractService;
import th.co.ais.service.gm.IParameterConfigService;

public class ParameterConfigServiceImpl extends AbstractService implements IParameterConfigService {

	
	private ParameterConfigHibernateDAO parameterConfigDao;
	
	public void setParameterConfigDao(ParameterConfigHibernateDAO parameterConfigDao) {
		this.parameterConfigDao = parameterConfigDao;
	}

	@Override
	public List<ParameterConfig> queryParameterConfigAll() throws Exception {
		ParameterConfig param = new ParameterConfig();
		return parameterConfigDao.queryParameterConfigList(param);
	}

	@Override
	public String queryParameterConfigByValue(String paramValue) throws Exception {
		
		return parameterConfigDao.queryParameterConfigByValue(paramValue);
	}

}
