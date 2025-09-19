package th.co.ais.service.impl.el;

import java.util.List;

import th.co.ais.dao.impl.el.ImportPeaOldExtHibernateDAO;
import th.co.ais.domain.el.ImportPeaOldExt;
import th.co.ais.service.AbstractService;
import th.co.ais.service.el.IImportPeaOldExtService;

public class ImportPeaOldExtServiceImpl extends AbstractService implements IImportPeaOldExtService{

	ImportPeaOldExtHibernateDAO importPeaOldExtDao;

	public void setImportPeaOldExtDao(ImportPeaOldExtHibernateDAO importPeaOldExtDao) {
		this.importPeaOldExtDao = importPeaOldExtDao;
	}

	@Override
	public String createImportPeaNewTmp(ImportPeaOldExt importPeaOldExt)
			throws Exception {
		// TODO Auto-generated method stub
		return importPeaOldExtDao.createImportMeaOldExt(importPeaOldExt);
	}

	@Override
	public void createImportPeaOldExts(List<ImportPeaOldExt> importPeaOldExtList)
			throws Exception {
		
		importPeaOldExtDao.createImportMeaOldExts(importPeaOldExtList);
		
	}

}
