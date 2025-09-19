package th.co.ais.service.impl.el;

import java.util.List;

import th.co.ais.dao.impl.el.ImportTransactionELHibernateDAO;
import th.co.ais.dao.impl.el.PLUtil;
import th.co.ais.domain.el.ImportTransaction;
import th.co.ais.service.AbstractService;
import th.co.ais.service.el.IImportTransactionELService;

public class ImportTransactionELServiceImpl extends AbstractService implements IImportTransactionELService {

	private ImportTransactionELHibernateDAO importTransactionELDao;	
	private PLUtil plUtil;
	
	public void setPlUtil(PLUtil plUtil) {
		this.plUtil = plUtil;
	}

	public void setImportTransactionELDao(
			ImportTransactionELHibernateDAO importTransactionELDao) {
		this.importTransactionELDao = importTransactionELDao;
	}

	@Override
	public String createImportTransaction(ImportTransaction importTransaction)
			throws Exception {
		
		return importTransactionELDao.createImportTransaction(importTransaction);
		
	}

	@Override
	public List<ImportTransaction> queryByCriteria(
			ImportTransaction importTransaction) throws Exception {
		
		return importTransactionELDao.queryByCriteria(importTransaction);
	}

	@Override
	public void updateImportTransaction(ImportTransaction importTransaction)
			throws Exception {
		
		importTransactionELDao.update(importTransaction);
		
	}

	@Override
	public ImportTransaction queryByTransactionId(String importTransactionId)
			throws Exception {
		
		return importTransactionELDao.queryByImportTransactionId(importTransactionId);
	}

	@Override
	public void updateImportTransactionWithCallPL(
			ImportTransaction importTransaction, String plName)
			throws Exception {
		
		importTransactionELDao.updateImportTransaction(importTransaction);
		plUtil.callPL(plName, null, null);
		
	}


}
