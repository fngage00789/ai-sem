package th.co.ais.dao.impl.el;

import java.util.List;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.domain.el.ImportMeaOldExt;

public class ImportMeaOldExtHibernateDAO extends AbstractHibernateDAO<ImportMeaOldExt> {

	public String createImportMeaOldExt(ImportMeaOldExt importMeaOldExt){
		return (String) getHibernateTemplate().save(importMeaOldExt);
	}
	
	public void createImportMeaOldExts(List<ImportMeaOldExt> importMeaOldExtList){
		getHibernateTemplate().saveOrUpdateAll(importMeaOldExtList);
	}
	
}
