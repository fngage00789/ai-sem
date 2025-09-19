package th.co.ais.service.impl.rt;

import java.util.List;

import th.co.ais.dao.impl.rt.ReturnDepositHibernateDAO;
import th.co.ais.domain.rt.ReturnDeposit;
import th.co.ais.service.AbstractService;
import th.co.ais.service.rt.IReturnDepositService;

public class ReturnDepositServiceImpl extends AbstractService implements IReturnDepositService {

	private ReturnDepositHibernateDAO returnDepositDao;
	
	public void setReturnDepositDao(ReturnDepositHibernateDAO returnDepositDao) {
		this.returnDepositDao = returnDepositDao;
	}

	@Override
	public ReturnDeposit createReturnDeposti(ReturnDeposit returnDeposit)
			throws Exception {
		return returnDepositDao.merge(returnDeposit);
	}

	@Override
	public void deleteReturnDeposit(String rowId) throws Exception {
		ReturnDeposit o = returnDepositDao.findByRowId(rowId);
		o.setRecordStatus("N");
		returnDepositDao.mergeFlush(o);
	}

	@Override
	public ReturnDeposit queryByRowId(String rowId) throws Exception {
		return returnDepositDao.findByRowId(rowId);
	}

	@Override
	public List querySPList(String spName, Object property) throws Exception {
		return returnDepositDao.querySPList(spName, property);
	}

	@Override
	public ReturnDeposit updateReturnDeposit(ReturnDeposit returnDeposit)
			throws Exception {
		return returnDepositDao.merge(returnDeposit);
	}

}
