package th.co.ais.service.impl.el;

import java.util.List;

import th.co.ais.dao.impl.el.WarrantMasterHibernateDAO;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.WarrantMaster;
import th.co.ais.service.AbstractService;
import th.co.ais.service.el.IWarrantMasterService;

public class WarrantMasterServiceImpl extends AbstractService implements IWarrantMasterService{

	private WarrantMasterHibernateDAO warrantMasterDao;
	
	public void setWarrantMasterDao(WarrantMasterHibernateDAO warrantMasterDao) {
		this.warrantMasterDao = warrantMasterDao;
	}

	@Override
	public List<WarrantMaster> queryByManagement(final Management manage) throws Exception {
		
		return warrantMasterDao.findByManagement(manage);
	}

	@Override
	public WarrantMaster queryWarrantMasterByRowId(String rowId) throws Exception {
		
		return warrantMasterDao.findByRowId(rowId);
	}
}
