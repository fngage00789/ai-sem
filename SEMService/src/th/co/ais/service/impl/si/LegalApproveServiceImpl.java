package th.co.ais.service.impl.si;

import java.util.List;

import th.co.ais.dao.impl.si.LegalApproveHibernateDAO;
import th.co.ais.domain.si.LegalApprove;
import th.co.ais.service.AbstractService;
import th.co.ais.service.si.ILegalApproveService;

public class LegalApproveServiceImpl extends AbstractService implements ILegalApproveService{

	private LegalApproveHibernateDAO legalApproveDao;
	
	@Override
	public List querySPList(String spName, Object property) throws Exception {
		return legalApproveDao.querySPList(spName, property);
	}

	public void setLegalApproveDao(LegalApproveHibernateDAO legalApproveDao) {
		this.legalApproveDao = legalApproveDao;
	}

	@Override
	public LegalApprove createLegalApprove(LegalApprove legalApprove) throws Exception {
		legalApprove.setLatestFlag("Y");
		legalApprove.setRecordStatus("Y");
		return legalApproveDao.merge(legalApprove);
	}

	@Override
	public List<LegalApprove> queryLegalApproveByCriteria(LegalApprove legalApprove) throws Exception {
		return legalApproveDao.queryLegalApprove(legalApprove);
	}

	@Override
	public void deleteLegalApprove(LegalApprove legalApprove) throws Exception {
			legalApprove.setRecordStatus("N");
			legalApproveDao.merge(legalApprove);
	}

	@Override
	public LegalApprove updateLegalApprove(LegalApprove legalApprove) throws Exception {
		return legalApproveDao.merge(legalApprove);
	}

	@Override
	public LegalApprove getLegalApproveByRowId(String legalApproveId)
			throws Exception {
		return legalApproveDao.findByRowId(legalApproveId);
	}

}
