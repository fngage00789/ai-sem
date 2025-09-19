package th.co.ais.service.el;

import java.util.List;

import th.co.ais.domain.el.PaymentDefault;
import th.co.ais.service.BaseService;

public interface IPaymentDefaultService extends BaseService {
	public List<PaymentDefault> queryPaymentDefaultByCritiria(PaymentDefault paymentDefault,String sortBy,String sortType)throws Exception;
	public List<PaymentDefault> queryByExpenseType(String contractNo, String expenseType) throws Exception;
}
