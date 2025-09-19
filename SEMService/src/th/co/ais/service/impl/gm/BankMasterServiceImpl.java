package th.co.ais.service.impl.gm;

import java.util.List;

import th.co.ais.dao.impl.gm.BankMasterHibernateDAO;
import th.co.ais.service.AbstractService;
import th.co.ais.service.gm.IBankMasterService;

public class BankMasterServiceImpl extends AbstractService implements IBankMasterService{

	private BankMasterHibernateDAO bankMasterDao;

	public void setBankMasterDao(BankMasterHibernateDAO bankMasterDao) {
		this.bankMasterDao = bankMasterDao;
	}

	@Override
	public List querySPList(String spName, Object property) throws Exception {
		return  bankMasterDao.querySPList(spName, property);
	}

}
