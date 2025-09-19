package th.co.ais.service.el;

import java.util.List;

import th.co.ais.domain.el.ImportTransaction;
import th.co.ais.service.BaseService;

public interface IImportTransactionELService extends BaseService{

	public List<ImportTransaction> queryByCriteria(ImportTransaction importTransaction) throws Exception;
	public String createImportTransaction(ImportTransaction importTransaction) throws Exception;
	public void updateImportTransaction(ImportTransaction importTransaction) throws Exception;
	public ImportTransaction queryByTransactionId(String importTransactionId) throws Exception;
	public void updateImportTransactionWithCallPL(ImportTransaction importTransaction, String plName) throws Exception;
	
}
