package th.co.ais.dao.impl.el;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.domain.el.DepositDetail;
import th.co.ais.domain.el.ImportDataLog;

public class ImportDataLogHibernateDAO extends AbstractHibernateDAO<ImportDataLog> {

	public void createImportMeaNewExt(ImportDataLog importDataLog){
		getHibernateTemplate().save(importDataLog);
	}
	
	public List<ImportDataLog> queryImportDataLogByTransactionId(String transactionId){
		
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(ImportDataLog.class).createAlias("importTransId", "importTransIdAlias");
		criteria.add(Restrictions.eq("importTransIdAlias.rowId", transactionId));
		
		return criteria.list();
	}
	
}
