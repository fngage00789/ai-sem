package th.co.ais.service.impl.el;

import java.util.List;

import th.co.ais.dao.impl.el.ManagementMasterHibernateDAO;
import th.co.ais.domain.el.ManagementMaster;
import th.co.ais.service.AbstractService;
import th.co.ais.service.el.IManagementMasterService;

public class ManagementMasterServiceImpl extends AbstractService implements IManagementMasterService{

	private ManagementMasterHibernateDAO managementMasterDao;
	
	public void setManagementMasterDao(
			ManagementMasterHibernateDAO managementMasterDao) {
		this.managementMasterDao = managementMasterDao;
	}

	@Override
	public List<ManagementMaster> queryAllManagementMaster() throws Exception {
		// TODO Auto-generated method stub
		return managementMasterDao.queryAllManagementMaster();
	}

}
