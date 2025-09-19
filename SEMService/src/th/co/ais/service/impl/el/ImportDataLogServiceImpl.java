package th.co.ais.service.impl.el;

import java.util.List;

import th.co.ais.dao.impl.el.ImportDataLogHibernateDAO;
import th.co.ais.domain.el.ImportDataLog;
import th.co.ais.service.AbstractService;
import th.co.ais.service.el.IImportDataLogService;

public class ImportDataLogServiceImpl extends AbstractService implements IImportDataLogService{

	ImportDataLogHibernateDAO importDataLogDao;
	
	public void setImportDataLogDao(ImportDataLogHibernateDAO importDataLogDao) {
		this.importDataLogDao = importDataLogDao;
	}

	@Override
	public void createImportDataLog(ImportDataLog importDataLog)
			throws Exception {
		
		importDataLogDao.createImportMeaNewExt(importDataLog);
		
	}

	@Override
	public List<ImportDataLog> queryImportDataLogByTransactionId(String transactionId) throws Exception {
		
		return importDataLogDao.queryImportDataLogByTransactionId(transactionId);
	}

}
