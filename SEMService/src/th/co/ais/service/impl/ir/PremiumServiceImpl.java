package th.co.ais.service.impl.ir;

import java.util.List;

import th.co.ais.dao.impl.ir.PremiumHibernateDAO;
import th.co.ais.domain.ir.Premium;
import th.co.ais.service.AbstractService;
import th.co.ais.service.ir.IPremiumService;

public class PremiumServiceImpl extends AbstractService implements IPremiumService {

	private PremiumHibernateDAO premiumDao;
	
	public void setPremiumDao(PremiumHibernateDAO premiumDao) {
		this.premiumDao = premiumDao;
	}

	@Override
	public void deletePremium(Premium premium) throws Exception {
		premium.setRecordStatus(STATUS_N);
		premiumDao.mergeFlush(premium);
	}

	@Override
	public Premium queryPremiumByRowId(String rowId) throws Exception {
		return premiumDao.findByRowId(rowId);
	}

	@Override
	public List querySPList(String spName, Object property) throws Exception {
		return premiumDao.querySPList(spName, property);
	}

}
