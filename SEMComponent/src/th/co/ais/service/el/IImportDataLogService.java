package th.co.ais.service.el;

import java.util.List;

import th.co.ais.domain.el.ImportDataLog;

public interface IImportDataLogService {

	public void createImportDataLog(ImportDataLog importDataLog) throws Exception;
	public List<ImportDataLog> queryImportDataLogByTransactionId(String transactionId) throws Exception;
	
}
