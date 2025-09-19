package th.co.ais.service.el;

import java.util.List;

import th.co.ais.domain.el.MeterInfo;
import th.co.ais.domain.el.Payment;
import th.co.ais.domain.el.PaymentDetail;
import th.co.ais.service.BaseService;

public interface IPaymentDetailService extends BaseService{
	
	public boolean savePaymentDetail(List<Payment> paymentList )throws Exception;
	public boolean savePaymentDetail(Payment payment )throws Exception;
	public List<PaymentDetail> getPaymentDetailByPayment(Payment payment )throws Exception;
	public PaymentDetail queryByMeterInfoAndToTermOfPayment(MeterInfo meterInfo) throws Exception;
}
