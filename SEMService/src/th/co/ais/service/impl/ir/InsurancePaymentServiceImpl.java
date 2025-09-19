package th.co.ais.service.impl.ir;

import th.co.ais.dao.impl.ir.InsurancePaymentHibernateDAO;
import th.co.ais.dao.impl.ir.InsuredHibernateDAO;
import th.co.ais.domain.ir.InsurancePayment;
import th.co.ais.domain.rt.RentalPayment;
import th.co.ais.service.AbstractService;
import th.co.ais.service.ir.IInsurancePaymentService;

public class InsurancePaymentServiceImpl extends AbstractService implements
		IInsurancePaymentService {
	
	private InsurancePaymentHibernateDAO insurancePaymentDao;

	public void setInsurancePaymentDao(InsurancePaymentHibernateDAO insurancePaymentDao) {
		this.insurancePaymentDao = insurancePaymentDao;
	}
	
	@Override
	public InsurancePayment getInsurancePaymentByRowId(String insurancePaymentId)
			throws Exception {
		return insurancePaymentDao.findByRowId(insurancePaymentId);
	}
	
	@Override
	public void updateInsurancePayment(InsurancePayment insurancePayment)
			throws Exception {
		insurancePaymentDao.mergeFlush(insurancePayment);
	}

}
