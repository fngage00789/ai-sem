package th.co.ais.dao.impl.el;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.domain.el.ImportTransaction;


public class ImportTransactionELHibernateDAO extends AbstractHibernateDAO<ImportTransaction> {
	
	public List<ImportTransaction> queryByCriteria(ImportTransaction importTransaction){		
		if(importTransaction==null){
			return null;
		}
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(ImportTransaction.class);
		criteria.createAlias("processId", "processIdAlias");
		if(null!=importTransaction.getProcessId() && !"".equals(importTransaction.getProcessId().getRowId())){
			criteria.add(Restrictions.eq("processIdAlias.rowId", importTransaction.getProcessId().getRowId()));
		}
		if(null!=importTransaction.getCompany() && !"".equals(importTransaction.getCompany())){
			criteria.add(Restrictions.eq("company", importTransaction.getCompany()));
		}	
		if(null!=importTransaction.getProcessStatus() && !"".equals(importTransaction.getProcessStatus())){
			criteria.add(Restrictions.eq("processStatus", importTransaction.getProcessStatus()));
		}
		if(null!=importTransaction.getFileName() && !"".equals(importTransaction.getFileName())){
			criteria.add(Restrictions.like("fileName", "%"+importTransaction.getFileName()+"%"));
		}
		if(null!=importTransaction.getRecordStatus() && !"".equals(importTransaction.getRecordStatus())){
			criteria.add(Restrictions.eq("recordStatus", importTransaction.getRecordStatus()));
		}
		if(null!=importTransaction.getUploadDtFrom()){
			Criterion ge = Restrictions.ge("uploadDt", getFromDate(importTransaction.getUploadDtFrom()));
			Criterion le = Restrictions.le("uploadDt", getToDate(importTransaction.getUploadDtTo()));
			criteria.add(ge);
			criteria.add(le);
		}
		if(null!=importTransaction.getProcessDtFrom()){
			Criterion ge = Restrictions.ge("processDt", getFromDate(importTransaction.getProcessDtFrom()));
			Criterion le = Restrictions.le("processDt", getToDate(importTransaction.getProcessDtTo()));
			criteria.add(ge);
			criteria.add(le);
		}
		if(null!=importTransaction.getClearingFlag() && !"".equals(importTransaction.getClearingFlag())){
			criteria.add(Restrictions.eq("clearingFlag", importTransaction.getClearingFlag()));
		}
		
		criteria.addOrder(Order.desc("createDt"));
		return criteria.list();
	}
	
	public String createImportTransaction(ImportTransaction importTransaction){
		return (String)getHibernateTemplate().save(importTransaction);
	}
	
	public void updateImportTransaction(ImportTransaction importTransaction){
		getHibernateTemplate().update(importTransaction);
	}
	
	public ImportTransaction queryByImportTransactionId(String importTransactionId){		
		if(importTransactionId==null){
			return null;
		}
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(ImportTransaction.class);
		criteria.add(Restrictions.eq("rowId", importTransactionId));
		List<ImportTransaction>  importTransactionList = criteria.list();
		ImportTransaction importTransaction = null;
		if(null!=importTransactionList && importTransactionList.size()>0){
			importTransaction = importTransactionList.get(0);
		}
		
		return importTransaction;
	}
	
	private Date getFromDate(Date date){
		
		Calendar fromDate = Calendar.getInstance();
		fromDate.setTime(date);
		fromDate.set(Calendar.HOUR_OF_DAY, 0);
		fromDate.set(Calendar.MINUTE, 0);
		fromDate.set(Calendar.SECOND, 0);
		fromDate.set(Calendar.MILLISECOND, 0);
		return fromDate.getTime();
	}
	
	private Date getToDate(Date date){
		
		Calendar toDate = Calendar.getInstance();
		toDate.setTime(date);
		toDate.set(Calendar.HOUR_OF_DAY, 23);
		toDate.set(Calendar.MINUTE, 59);
		toDate.set(Calendar.SECOND, 59);
		toDate.set(Calendar.MILLISECOND, 59);
		return toDate.getTime();
	}
	
}
