package th.co.ais.service.impl.el;

import java.util.List;

import th.co.ais.dao.impl.el.PaymentDefaultHibernateDAO;
import th.co.ais.domain.el.PaymentDefault;
import th.co.ais.service.AbstractService;
import th.co.ais.service.el.IPaymentDefaultService;

public class PaymentDefaultServiceImpl extends AbstractService implements
		IPaymentDefaultService {
	PaymentDefaultHibernateDAO paymentDefaultDao;

	
	public void setPaymentDefaultDao(PaymentDefaultHibernateDAO paymentDefaultDao) {
		this.paymentDefaultDao = paymentDefaultDao;
	}


	@Override
	public List<PaymentDefault> queryPaymentDefaultByCritiria(
			PaymentDefault paymentDefault,String sortBy,String sortType) throws Exception {
		// TODO Auto-generated method stub
		return paymentDefaultDao.queryByCriteria(paymentDefault,sortBy,sortType);
	}

	@Override
	public List<PaymentDefault> queryByExpenseType(String contractNo, String expenseType) throws Exception {
		
		return paymentDefaultDao.queryByExpenseType(contractNo, expenseType);
	}

}
