package th.co.ais.service.impl.pt;

import java.util.List;

import th.co.ais.dao.impl.pt.PTaxMasterHibernateDAO;
import th.co.ais.service.AbstractService;
import th.co.ais.service.pt.IPTaxMasterService;

public class PTaxMasterServiceImpl extends AbstractService implements IPTaxMasterService{

	private PTaxMasterHibernateDAO pTaxMasterDao;
	
	public void setpTaxMasterDao(PTaxMasterHibernateDAO pTaxMasterDao) {
		this.pTaxMasterDao = pTaxMasterDao;
	}

	@Override
	public List querySPList(String spName, Object property) throws Exception {
		return pTaxMasterDao.querySPList(spName, property);
	}

}
