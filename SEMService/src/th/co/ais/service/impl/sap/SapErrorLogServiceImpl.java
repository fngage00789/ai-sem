package th.co.ais.service.impl.sap;

import java.util.List;

import th.co.ais.dao.impl.sap.SapErrorLogHibernateDAO;
import th.co.ais.domain.sap.SapErrorLog;
import th.co.ais.service.AbstractService;
import th.co.ais.service.sap.ISAPErrorLog;

public class SapErrorLogServiceImpl extends AbstractService implements ISAPErrorLog{

	private SapErrorLogHibernateDAO sapErrorLogDao;

	public void setSapErrorLogDao(SapErrorLogHibernateDAO sapErrorLogDao) {
		this.sapErrorLogDao = sapErrorLogDao;
	}

	@Override
	public SapErrorLog getSapErrorLogByRowId(String rowId) throws Exception {
		return sapErrorLogDao.findByRowId(rowId);
	}

	@Override
	public SapErrorLog updateSapErrorLog(SapErrorLog sapErrorLog)
			throws Exception {
		return sapErrorLogDao.merge(sapErrorLog);
	}

	@Override
	public List querySPList(String spName, Object property) throws Exception {
		return sapErrorLogDao.querySPList(spName, property);
	}
	

}
