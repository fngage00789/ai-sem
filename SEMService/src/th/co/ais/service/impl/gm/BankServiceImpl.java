package th.co.ais.service.impl.gm;

import java.util.List;

import th.co.ais.dao.impl.gm.BankHibernateDAO;
import th.co.ais.domain.gm.Bank;
import th.co.ais.service.AbstractService;
import th.co.ais.service.gm.IBankService;

public class BankServiceImpl extends AbstractService implements IBankService {

	private BankHibernateDAO bankDao;

	public void setBankDao(BankHibernateDAO bankDao) {
		this.bankDao = bankDao;
	}

	@Override
	public List<Bank> searchBank(Bank bank) throws Exception {
		return bankDao.queryBank(bank);
	}

	@Override
	public Bank queryBankByCode(String bankCode) throws Exception {
		return bankDao.findByBankCode(bankCode);
	}

	@Override
	public List<Bank> queryBankAll() throws Exception {
		return bankDao.queryBank(new Bank());
	}

	@Override
	public Bank createBank(Bank bank) throws Exception {
		bank.setRecordStatus(STATUS_Y);
		return bankDao.merge(bank);
	}
	
	@Override
	public Bank updateBank(Bank bank) throws Exception {
		return bankDao.merge(bank);
	}

}
