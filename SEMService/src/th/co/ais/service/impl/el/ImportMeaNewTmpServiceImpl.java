package th.co.ais.service.impl.el;

import java.util.List;

import th.co.ais.dao.impl.el.ImportMeaNewTmpHibernateDAO;
import th.co.ais.domain.el.ImportMeaNewTmp;
import th.co.ais.service.AbstractService;
import th.co.ais.service.el.IImportMeaNewTmpService;

public class ImportMeaNewTmpServiceImpl  extends AbstractService implements IImportMeaNewTmpService{

	ImportMeaNewTmpHibernateDAO importMeaNewTmpDao;
	
	public void setImportMeaNewTmpDao(ImportMeaNewTmpHibernateDAO importMeaNewTmpDao) {
		this.importMeaNewTmpDao = importMeaNewTmpDao;
	}

	@Override
	public void createImportMeaNewTmp(ImportMeaNewTmp importMeaNewTmp)
			throws Exception {
		
		importMeaNewTmpDao.createImportMeaNewTmp(importMeaNewTmp);
	}

	@Override
	public void createImportMeaNewTmps(List<ImportMeaNewTmp> importMeaNewTmps) throws Exception {
		
		importMeaNewTmpDao.createImportMeaNewTmps(importMeaNewTmps);
		
	}

}
