package th.co.ais.service.impl.rt;

import java.util.List;

import th.co.ais.dao.impl.rt.RentalPaymentHibernateDAO;
import th.co.ais.domain.rt.RentalPayment;
import th.co.ais.service.AbstractService;
import th.co.ais.service.rt.IRentalPaymentService;

public class RentalPaymentServiceImpl extends AbstractService implements IRentalPaymentService{

	private RentalPaymentHibernateDAO rentalPaymentDao;
	
	public void setRentalPaymentDao(RentalPaymentHibernateDAO rentalPaymentDao) {
		this.rentalPaymentDao = rentalPaymentDao;
	}
	
	@Override
	public List querySPList(String spName, Object property) throws Exception {
		return rentalPaymentDao.querySPList(spName, property);
	}

	@Override
	public RentalPayment getRentalPaymentByRowId(String rentalPaymentId)
			throws Exception {
		return rentalPaymentDao.findByRowId(rentalPaymentId);
	}

	@Override
	public void updateRentalPayment(RentalPayment rentalpayment)
			throws Exception {
		rentalPaymentDao.mergeFlush(rentalpayment);
	}

}
