package th.co.ais.service.impl.lc;

import th.co.ais.dao.impl.lc.LoadClearChequeDAO;
import th.co.ais.domain.ac.LoadClearCheque;
import th.co.ais.service.AbstractService;
import th.co.ais.service.lc.ILoadClearChequeService;

public class LoadClearChequeServiceImpl extends AbstractService implements ILoadClearChequeService{

	private LoadClearChequeDAO loadClearChequeDao;
	
	@Override
	public boolean updateClearCheque(LoadClearCheque loadClearCheque)
			throws Exception {
		return loadClearChequeDao.updateClearCheque(loadClearCheque);
	}

	public LoadClearChequeDAO getLoadClearChequeDao() {
		return loadClearChequeDao;
	}

	public void setLoadClearChequeDao(LoadClearChequeDAO loadClearChequeDao) {
		this.loadClearChequeDao = loadClearChequeDao;
	}

	
}
