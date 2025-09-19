package th.co.ais.service.lc;

import th.co.ais.domain.ac.LoadClearCheque;
import th.co.ais.service.BaseService;


public interface ILoadClearChequeService extends BaseService{
	public boolean updateClearCheque(LoadClearCheque loadClearCheque) throws Exception;
}
