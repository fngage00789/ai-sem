package th.co.ais.service.impl.el;

import java.util.List;

import th.co.ais.dao.impl.el.ImportPeaNewExtHibernateDAO;
import th.co.ais.domain.el.ImportPeaNewExt;
import th.co.ais.service.AbstractService;
import th.co.ais.service.el.IImportPeaNewExtService;

public class ImportPeaNewExtServiceImpl extends AbstractService implements IImportPeaNewExtService{

	ImportPeaNewExtHibernateDAO importPeaNewExtDao;
	
	public void setImportPeaNewExtDao(ImportPeaNewExtHibernateDAO importPeaNewExtDao) {
		this.importPeaNewExtDao = importPeaNewExtDao;
	}

	@Override
	public void createImportPeaNewExts(List<ImportPeaNewExt> importPeaNewExtList)
			throws Exception {
		
		importPeaNewExtDao.createImportMeaNewExts(importPeaNewExtList);
		
	}

	@Override
	public String createImportPeaNewTmp(ImportPeaNewExt importPeaNewExt)
			throws Exception {
		
		return importPeaNewExtDao.createImportMeaNewExt(importPeaNewExt);
	}

}
