package th.co.ais.service.impl.gm;

import java.util.List;

import th.co.ais.dao.impl.gm.TransPaymentHibernateDAO;
import th.co.ais.domain.gm.TransPayment;
import th.co.ais.service.AbstractService;
import th.co.ais.service.gm.ITransPaymentService;

public class TransPaymentServiceImpl extends AbstractService implements ITransPaymentService {
	
	private TransPaymentHibernateDAO transPaymentDao;
	public void setTransPaymentDao(TransPaymentHibernateDAO transPaymentDao) {
		this.transPaymentDao = transPaymentDao;
	}
	
	public List<TransPayment> queryTransPayment(TransPayment transPayment) throws Exception {
		return transPaymentDao.queryTransPayment(transPayment);
	}
}
