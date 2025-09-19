package th.co.ais.dao.impl.el;

import java.util.List;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.domain.el.ImportPeaOldExt;

public class ImportPeaOldExtHibernateDAO extends AbstractHibernateDAO<ImportPeaOldExt> {

	public String createImportMeaOldExt(ImportPeaOldExt importPeaOldExt){
		return (String) getHibernateTemplate().save(importPeaOldExt);
	}
	
	public void createImportMeaOldExts(List<ImportPeaOldExt> importPeaOldExtList){
		getHibernateTemplate().saveOrUpdateAll(importPeaOldExtList);
	}
	
}
