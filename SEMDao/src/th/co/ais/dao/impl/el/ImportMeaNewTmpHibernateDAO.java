package th.co.ais.dao.impl.el;

import java.util.List;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.domain.el.ImportMeaNewTmp;

public class ImportMeaNewTmpHibernateDAO extends AbstractHibernateDAO<ImportMeaNewTmp> {

	public void createImportMeaNewTmp(ImportMeaNewTmp importMeaNewTmp){
		getHibernateTemplate().save(importMeaNewTmp);
	}
	
	public void createImportMeaNewTmps(List<ImportMeaNewTmp> importMeaNewTmps){
		getHibernateTemplate().saveOrUpdateAll(importMeaNewTmps);
	}
	
}
