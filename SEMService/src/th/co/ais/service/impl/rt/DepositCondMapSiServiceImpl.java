package th.co.ais.service.impl.rt;

import th.co.ais.dao.impl.rt.DepositCondMapSiHibernateDAO;
import th.co.ais.domain.rt.DepositCondMapSi;
import th.co.ais.domain.rt.RentalDetail;
import th.co.ais.service.AbstractService;
import th.co.ais.service.rt.IDepositCondMapSiService;

public class DepositCondMapSiServiceImpl extends AbstractService implements IDepositCondMapSiService {

	private DepositCondMapSiHibernateDAO depositCondMapSiDao;
	
	public void setDepositCondMapSiDao(DepositCondMapSiHibernateDAO depositCondMapSiDao) {
		this.depositCondMapSiDao = depositCondMapSiDao;
	}

	@Override
	public DepositCondMapSi createDepositCondMapSi(DepositCondMapSi dpstCondMapSi) throws Exception {
		return depositCondMapSiDao.merge(dpstCondMapSi);
	}

	@Override
	public void deleteDepositCondMapSi(DepositCondMapSi dpstCondMapSi) throws Exception {
		dpstCondMapSi.setRecordStatus("N");
		depositCondMapSiDao.mergeFlush(dpstCondMapSi);
	}

	@Override
	public DepositCondMapSi queryByRowId(String rowId) throws Exception {
		return depositCondMapSiDao.findByRowId(rowId);
	}

	@Override
	public DepositCondMapSi updateDepositCondMapSi(DepositCondMapSi dpstCondMapSi) throws Exception {
		return depositCondMapSiDao.merge(dpstCondMapSi);
	}

}
