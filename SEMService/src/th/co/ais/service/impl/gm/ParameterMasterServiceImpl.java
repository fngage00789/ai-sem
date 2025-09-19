package th.co.ais.service.impl.gm;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import th.co.ais.dao.impl.gm.LovMasterHibernateDAO;
import th.co.ais.dao.impl.gm.ParameterMasterHibernateDAO;
import th.co.ais.domain.gm.LovMaster;
import th.co.ais.domain.gm.ParameterMaster;
import th.co.ais.service.AbstractService;
import th.co.ais.service.gm.ILovMasterService;
import th.co.ais.service.gm.IParameterMasterService;
import th.co.ais.to.gm.LovMasterSearchTO;

public class ParameterMasterServiceImpl extends AbstractService implements IParameterMasterService {
	
	private ParameterMasterHibernateDAO parameterMasterDao;

	public void setParameterMasterDao(ParameterMasterHibernateDAO parameterMasterDao) {
		this.parameterMasterDao = parameterMasterDao;
	}

	@Override
	public ParameterMaster createParameterMaster(ParameterMaster paramMaster) throws Exception {
		paramMaster.setRecordStatus(STATUS_Y);
		paramMaster.setUpdateBy(paramMaster.getCurrentUser());
		paramMaster.setUpdateDt(new Timestamp(new Date().getTime()));
		return parameterMasterDao.merge(paramMaster);
	}
	
	@Override
	public ParameterMaster updateParameterMaster(ParameterMaster paramMaster) throws Exception {
		return parameterMasterDao.merge(paramMaster);
	}
	
	@Override
	public ParameterMaster deleteParameterMaster(ParameterMaster paramMaster) throws Exception {
		paramMaster.setRecordStatus(STATUS_N);
		return parameterMasterDao.merge(paramMaster);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List querySPList(String spName, Object property) throws Exception {
		return parameterMasterDao.querySPList(spName, property);
	}

	@Override
	public Query getSPQuery(String spName) throws Exception {
		return parameterMasterDao.getSPQuery(spName);
	}

	@Override
	public ParameterMaster queryParameterMasterByRowId(String rowId) throws Exception {
		return parameterMasterDao.findByRowId(rowId);
	}

}
