package th.co.ais.dao.impl.el;

import java.util.List;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.domain.el.ImportPeaNewExt;

public class ImportPeaNewExtHibernateDAO extends AbstractHibernateDAO<ImportPeaNewExt> {

	public String createImportMeaNewExt(ImportPeaNewExt importPeaNewExt){
		return (String) getHibernateTemplate().save(importPeaNewExt);
	}
	
	public void createImportMeaNewExts(List<ImportPeaNewExt> importPeaNewExtList){
		getHibernateTemplate().saveOrUpdateAll(importPeaNewExtList);
	}
	
}
