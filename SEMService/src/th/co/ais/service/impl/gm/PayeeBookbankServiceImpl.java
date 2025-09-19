package th.co.ais.service.impl.gm;

import java.util.List;

import th.co.ais.dao.impl.gm.PayeeBookbankHibernateDAO;
import th.co.ais.domain.gm.PayeeBookbank;
import th.co.ais.service.AbstractService;
import th.co.ais.service.gm.IPayeeBookbankService;

public class PayeeBookbankServiceImpl extends AbstractService implements IPayeeBookbankService {

	private PayeeBookbankHibernateDAO payeeBookbankDao;
	
	public void setPayeeBookbankDao(PayeeBookbankHibernateDAO payeeBookbankDao) {
		this.payeeBookbankDao = payeeBookbankDao;
	}

	@Override
	public PayeeBookbank queryByPayeeMasterId(String payeeMasterId) throws Exception {
		return payeeBookbankDao.queryPayeeBookBankByPayeeMasterId(payeeMasterId);
	}
	
	@Override
	public List<PayeeBookbank> queryAllPayeeBookbank() throws Exception {
		
		return payeeBookbankDao.queryAllPayeeBookbank();
	}


	@Override
	public List<PayeeBookbank> queryPayeeBookbankByPayeeId(String payeeId)
			throws Exception {
		return payeeBookbankDao.queryPayeeBookbankByPayeeMasterId(payeeId);
	}
	
	@Override
	public List<PayeeBookbank> queryPayeeBookbankByPayee(PayeeBookbank payeeBookbank)
			throws Exception {
		return payeeBookbankDao.queryPayeeBookbankByPayeeMaster(payeeBookbank);
	}

	@Override
	public PayeeBookbank createPayeeBookbank(PayeeBookbank payeeBookbank) throws Exception {
		payeeBookbank.setRecordStatus(STATUS_Y);
		payeeBookbank.setPayeeBookbankStatus("01");
		return payeeBookbankDao.merge(payeeBookbank);
	}

	@Override
	public void deletePayeeBookbank(PayeeBookbank payeeBookbank) throws Exception {
		payeeBookbank.setRecordStatus(STATUS_N);
		payeeBookbankDao.merge(payeeBookbank);
	}

	@Override
	public PayeeBookbank updatePayeeBookbank(PayeeBookbank payeeBookbank) throws Exception {
		if(payeeBookbank != null){
			PayeeBookbank oldPayeeBookbank = queryByPayeeMasterId(payeeBookbank.getPayeeMasterId());
			if(oldPayeeBookbank != null)
			deletePayeeBookbank(oldPayeeBookbank);
			payeeBookbank.setRowId(null);
		}
		return createPayeeBookbank(payeeBookbank);
	}

}
