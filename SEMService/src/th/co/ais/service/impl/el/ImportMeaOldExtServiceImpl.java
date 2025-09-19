package th.co.ais.service.impl.el;

import java.util.List;

import th.co.ais.dao.impl.el.ImportMeaOldExtHibernateDAO;
import th.co.ais.domain.el.ImportMeaOldExt;
import th.co.ais.service.AbstractService;
import th.co.ais.service.el.IImportMeaOldExtService;

public class ImportMeaOldExtServiceImpl extends AbstractService implements IImportMeaOldExtService{

	ImportMeaOldExtHibernateDAO importMeaOldExtDao;
	
	public void setImportMeaOldExtDao(ImportMeaOldExtHibernateDAO importMeaOldExtDao) {
		this.importMeaOldExtDao = importMeaOldExtDao;
	}

	@Override
	public String createImportMeaNewTmp(ImportMeaOldExt importMeaOldExt)
			throws Exception {
		
		return importMeaOldExtDao.createImportMeaOldExt(importMeaOldExt);
		
	}

	@Override
	public void createImportMeaOldExts(
			List<ImportMeaOldExt> importMeaOldExtList) throws Exception {
		
		importMeaOldExtDao.createImportMeaOldExts(importMeaOldExtList);
		
	}

}
