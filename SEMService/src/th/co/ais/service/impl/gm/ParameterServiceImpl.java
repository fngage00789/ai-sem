package th.co.ais.service.impl.gm;

import java.util.List;

import th.co.ais.dao.impl.gm.ParameterHibernateDAO;
import th.co.ais.domain.gm.Parameter;
import th.co.ais.service.AbstractService;
import th.co.ais.service.gm.IParameterService;

public class ParameterServiceImpl extends AbstractService implements IParameterService{

	ParameterHibernateDAO parameterDao;	
	
	public void setParameterDao(ParameterHibernateDAO parameterDao) {
		this.parameterDao = parameterDao;
	}


	@Override
	public List<Parameter> queryAllParameter() throws Exception {
		
		return parameterDao.queryAllParameter();
	}

}
