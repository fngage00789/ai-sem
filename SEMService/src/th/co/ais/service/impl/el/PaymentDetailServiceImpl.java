package th.co.ais.service.impl.el;

import java.util.List;

import th.co.ais.dao.impl.el.PaymentDetailHibernateDAO;
import th.co.ais.domain.el.MeterInfo;
import th.co.ais.domain.el.Payment;
import th.co.ais.domain.el.PaymentDetail;
import th.co.ais.service.AbstractService;
import th.co.ais.service.el.IPaymentDetailService;


public class PaymentDetailServiceImpl extends AbstractService implements IPaymentDetailService{
	
	private PaymentDetailHibernateDAO paymentDao;

	public void setPaymentDao(PaymentDetailHibernateDAO paymentDao){
		this.paymentDao = paymentDao;
	}
	
	@Override
	public boolean savePaymentDetail(List<Payment> paymentList) throws Exception {
		
		return false;
	}

	@Override
	public boolean savePaymentDetail(Payment electricPayment) throws Exception {
		
		return false;
	}

	@Override
	public List<PaymentDetail> getPaymentDetailByPayment(Payment payment)
			throws Exception {
		// TODO Auto-generated method stub
		return paymentDao.getPaymentDetailByPayment(payment);
	}

	@Override
	public PaymentDetail queryByMeterInfoAndToTermOfPayment(MeterInfo meterInfo) throws Exception {
		
		return paymentDao.findByMeterInfoAndMaxToTermOfPayment(meterInfo);
	}
}
