package th.co.ais.service.impl.el;

import java.util.List;

import th.co.ais.dao.impl.el.BgMapContractHibernateDAO;
import th.co.ais.domain.el.BgMapContract;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.ManagementSP;
import th.co.ais.service.AbstractService;
import th.co.ais.service.el.IBgMapContractService;

public class BgMapContractServiceImpl extends AbstractService implements IBgMapContractService{

	BgMapContractHibernateDAO bgMapContractDao;
	
	public void setBgMapContractDao(BgMapContractHibernateDAO bgMapContractDao) {
		this.bgMapContractDao = bgMapContractDao;
	}

	@Override
	public List<BgMapContract> queryAllBgMapContract() throws Exception {
		
		return bgMapContractDao.queryAllBgMapContract();
	}

	@Override
	public List<BgMapContract> queryByManagement(final Management manage) throws Exception {
		
		return bgMapContractDao.findByManagement(manage);
	}
	
	@Override
	public List<BgMapContract> queryByManagement(final ManagementSP manage) throws Exception {
		
		return bgMapContractDao.findByManagement(manage);
	}

	@Override
	public BgMapContract queryBGMapContractByRowId(String rowId) throws Exception {
		
		return bgMapContractDao.findByRowId(rowId);
	}
}
