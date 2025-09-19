package th.co.ais.dao.impl.el;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.domain.el.ImportMasterData;


public class ImportMasterDataELHibernateDAO extends AbstractHibernateDAO<ImportMasterData> {
	
	public ImportMasterData queryByProcessId(String processId){
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(ImportMasterData.class);
		criteria.add(Restrictions.eq("rowId", processId));
		
		List<ImportMasterData> importMasterDataList = criteria.list();
		ImportMasterData importMasterData = null;
		if(null!=importMasterDataList && importMasterDataList.size()>0){
			importMasterData = importMasterDataList.get(0);
		}
		
		return importMasterData;
	}
	
}
