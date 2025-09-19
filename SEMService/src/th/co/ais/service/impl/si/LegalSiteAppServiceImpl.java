package th.co.ais.service.impl.si;

import java.util.List;

import th.co.ais.dao.impl.si.LegalSiteAppHibernateDAO;
import th.co.ais.service.AbstractService;
import th.co.ais.service.si.ILegalSiteAppService;

public class LegalSiteAppServiceImpl extends AbstractService implements ILegalSiteAppService {

	private LegalSiteAppHibernateDAO legalSiteAppDao;

	public void setLegalSiteAppDao(LegalSiteAppHibernateDAO legalSiteAppDao) {
		this.legalSiteAppDao = legalSiteAppDao;
	}

	@Override
	public List querySPList(String spName, Object property) throws Exception {
		return legalSiteAppDao.querySPList(spName, property);
	}

}
