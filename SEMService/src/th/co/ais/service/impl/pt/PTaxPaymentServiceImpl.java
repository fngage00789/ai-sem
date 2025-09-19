package th.co.ais.service.impl.pt;

import th.co.ais.dao.impl.pt.PTaxPaymentHibernateDAO;
import th.co.ais.domain.pt.PtaxPayment;
import th.co.ais.service.AbstractService;
import th.co.ais.service.pt.IPTaxPaymentService;

public class PTaxPaymentServiceImpl extends AbstractService implements IPTaxPaymentService{

	private PTaxPaymentHibernateDAO pTaxPaymentDao;
	
	public void setpTaxPaymentDao(PTaxPaymentHibernateDAO pTaxPaymentDao) {
		this.pTaxPaymentDao = pTaxPaymentDao;
	}

	@Override
	public PtaxPayment getPTaxPaymentByRowId(String rowId) throws Exception {
		return pTaxPaymentDao.findByRowId(rowId);
	}

	@Override
	public void updatePtaxPayment(PtaxPayment pTaxPayment) throws Exception {
		pTaxPaymentDao.merge(pTaxPayment);		
	}

}
