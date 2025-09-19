package th.co.ais.service.impl.el;

import th.co.ais.dao.impl.el.ImportMasterDataELHibernateDAO;
import th.co.ais.domain.el.ImportMasterData;
import th.co.ais.service.AbstractService;
import th.co.ais.service.el.IImportMasterDataELService;

public class ImportMasterDataELServiceImpl extends AbstractService implements IImportMasterDataELService {

	ImportMasterDataELHibernateDAO importMasterDataELDao;
	
	public void setImportMasterDataELDao(
			ImportMasterDataELHibernateDAO importMasterDataELDao) {
		this.importMasterDataELDao = importMasterDataELDao;
	}

	public ImportMasterData queryByProcessId(String processId) throws Exception {
		
		return importMasterDataELDao.queryByProcessId(processId);
	}

}
