package th.co.ais.dao.impl.el;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.el.VendorMapPayeeEL;
import th.co.ais.domain.gm.PayeeBookbank;
import th.co.ais.domain.gm.PayeeMaster;
import th.co.ais.domain.gm.VendorBookbank;
import th.co.ais.domain.gm.VendorMaster;

public class VendorMapPayeeELHibernateDAO extends AbstractHibernateDAO<VendorMapPayeeEL> {

	@SuppressWarnings("unchecked")
	public List<VendorMapPayeeEL> queryAllVendorMapPayee() throws DAOException{
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(VendorMapPayeeEL.class);
		
		return criteria.list();
	}	
	
	@SuppressWarnings("unchecked")
	public List<VendorMapPayeeEL> queryAllVendorMapPayeeMasterForCash(String expenseType,String recordStatus) throws DAOException{
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(VendorMapPayeeEL.class);
		
		if(StringUtils.isNotEmpty(expenseType)){
			
			criteria.add(Restrictions.eq("expenseType",expenseType));
			criteria.add(Restrictions.eq("recordStatus", recordStatus));
		}
		
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<VendorMapPayeeEL> queryAllVendorMapPayeeMasterForCash(String expenseType,String recordStatus,String contractNo, String vendorStatus, String payeeStatus) throws DAOException{
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(VendorMapPayeeEL.class);
		
		if(StringUtils.isNotEmpty(expenseType)){
			
			criteria.add(Restrictions.eq("expenseType",expenseType));
			
		}
		if(StringUtils.isNotEmpty(contractNo)){
			criteria.add(Restrictions.eq("contractNo",contractNo.toUpperCase()));
		
		} 
		if(StringUtils.isNotEmpty(recordStatus)){
			
			criteria.add(Restrictions.eq("recordStatus", recordStatus));
		}
		//edit by NEW 19/03/2015
		/*if(StringUtils.isNotEmpty(vendorStatus)){
			criteria.createAlias("vendorMasterId", "vendorMasterIdAlias", Criteria.LEFT_JOIN);
			criteria.add(Restrictions.eq("vendorMasterIdAlias.vendorStatus", vendorStatus));
		}
		/*if(StringUtils.isNotEmpty(payeeStatus)){
			criteria.createAlias("payeeMasterId", "payeeMasterIdAlias", Criteria.LEFT_JOIN);
			criteria.add(Restrictions.eq("payeeMasterIdAlias.payeeStatus", payeeStatus));
		}*/
		
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<VendorMapPayeeEL> queryAllVendorMapPayeeMasterForCash(String expenseType,String recordStatus,String contractNo) throws DAOException{
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(VendorMapPayeeEL.class);
		
		if(StringUtils.isNotEmpty(expenseType)){
			
			criteria.add(Restrictions.eq("expenseType",expenseType));
			
		}
		if(StringUtils.isNotEmpty(contractNo)){
			criteria.add(Restrictions.eq("contractNo",contractNo.toUpperCase()));
		
		} 
		if(StringUtils.isNotEmpty(recordStatus)){
			
			criteria.add(Restrictions.eq("recordStatus", recordStatus));
		}
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public VendorMapPayeeEL queryVendorMasterForELTemp(VendorMapPayeeEL vendorIn) throws DAOException{
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(VendorMapPayeeEL.class);
		//1.1	EXPENSE_TYPE = 06
		//1.2	RECORD_STATUS = Y
		VendorMapPayeeEL vendorReturn = null;
		try{
			criteria.add(Restrictions.eq("expenseType",vendorIn.getExpenseType()));	
			criteria.add(Restrictions.eq("recordStatus", vendorIn.getRecordStatus()));
			//WT###Add 20101215
			if(vendorIn.getContractNo()==null){
				criteria.add(Restrictions.eq("contractNo", vendorIn.getContractNo()));
			}else{
				criteria.add(Restrictions.eq("contractNo", vendorIn.getContractNo().toUpperCase()));
			}
			//WT###Add 20101215 End
			List<VendorMapPayeeEL>  result = criteria.list();
			if(result!=null&&result.size()>0){
				vendorReturn = result.get(0);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}

		return vendorReturn;
	}
	
	public List<Object> getVendorList(String contractNo){
		String hql = " SELECT C.VENDOR_CODE " +
						" FROM SEM_CT_VENDOR_MAP_PAYEE T ,SEM_CT_VENDOR_MASTER C " +
						" WHERE T.CONTRACT_NO = '"+contractNo+"' " +
						" AND C.VENDOR_MASTER_ID = T.VENDOR_MASTER_ID " +
						" AND C.VENDOR_CODE IS NOT NULL ";
		
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createSQLQuery(hql);
	    return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public VendorMaster getVendorMasterForELTemp(VendorMaster vendorIn) throws DAOException{
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(VendorMaster.class);
		//1.1	EXPENSE_TYPE = 06
		//1.2	RECORD_STATUS = Y
		VendorMaster vendorReturn = null;
		try{
			criteria.add(Restrictions.eq("rowId",vendorIn.getRowId()));	
			//criteria.add(Restrictions.eq("vendorStatus",vendorIn.getVendorStatus()));	
			//criteria.add(Restrictions.eq("recordStatus", vendorIn.getRecordStatus()));
			
			//Add 2012/11/09
			criteria.addOrder(Order.asc("vendorCode"));
			
			List<VendorMaster>  result = criteria.list();
			if(result!=null&&result.size()>0){
				vendorReturn = result.get(0);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}

		return vendorReturn;
	}	
	
	@SuppressWarnings("unchecked")
	public PayeeMaster getPayeeMasterForELTemp(PayeeMaster payeeIn) throws DAOException{
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(PayeeMaster.class);
		//1.1	EXPENSE_TYPE = 06
		//1.2	RECORD_STATUS = Y
		PayeeMaster payeeReturn = null;
		try{
			criteria.add(Restrictions.eq("rowId",payeeIn.getRowId()));	
			if(!StringUtils.isEmpty(payeeIn.getPayeeStatus())){
				criteria.add(Restrictions.eq("payeeStatus",payeeIn.getPayeeStatus()));	
			}
			criteria.add(Restrictions.eq("recordStatus", payeeIn.getRecordStatus()));
			List<PayeeMaster>  result = criteria.list();
			if(result!=null&&result.size()>0){
				payeeReturn = result.get(0);
				 
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}

		return payeeReturn;
	}
	@SuppressWarnings("unchecked")
	public PayeeBookbank getPayeeBookbankForEL(PayeeBookbank payeeIn) throws DAOException{
		Session session = getSessionFactory().getCurrentSession();
		//Criteria criteria = session.createCriteria(PayeeMaster.class);
		Criteria criteria = session.createCriteria(PayeeBookbank.class);
		//1.1	EXPENSE_TYPE = 06
		//1.2	RECORD_STATUS = Y
		PayeeBookbank payeeReturn = null;
		try{
			//WT###Edit 20101223 Start
			//if(StringUtils.isNotEmpty(payeeIn.getRowId())){
			if(StringUtils.isNotEmpty(payeeIn.getPayeeMasterId())){				
				//criteria.add(Restrictions.eq("rowId",payeeIn.getRowId()));
				criteria.add(Restrictions.eq("payeeMasterId",payeeIn.getPayeeMasterId()));
			//WT###Edit 20101223 End
			}
			if(StringUtils.isNotEmpty(payeeIn.getPayeeBookbankStatus())){
				criteria.add(Restrictions.eq("payeeBookbankStatus",payeeIn.getPayeeBookbankStatus()));	
			}
			if(StringUtils.isNotEmpty(payeeIn.getRecordStatus())){
				criteria.add(Restrictions.eq("recordStatus", payeeIn.getRecordStatus()));
			}
		
			
			List<PayeeBookbank>  result = criteria.list();
			if(result!=null&&result.size()>0){
				payeeReturn = result.get(0);
				 
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}

		return payeeReturn;
	}
	@SuppressWarnings("unchecked")
	public VendorBookbank getVendorBookbankForEL(VendorBookbank payeeIn) throws DAOException{
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(VendorBookbank.class);
		//1.1	EXPENSE_TYPE = 06
		//1.2	RECORD_STATUS = Y
		VendorBookbank payeeReturn = null;
		try{
			if(StringUtils.isNotEmpty(payeeIn.getVendorMasterId())){
				criteria.add(Restrictions.eq("vendorMasterId",payeeIn.getVendorMasterId()));
			}
			if(StringUtils.isNotEmpty(payeeIn.getVendorBookbankStatus())){
				criteria.add(Restrictions.eq("vendorBookbankStatus",payeeIn.getVendorBookbankStatus()));
			}
			if(StringUtils.isNotEmpty(payeeIn.getRecordStatus())){
				criteria.add(Restrictions.eq("recordStatus", payeeIn.getRecordStatus()));	
			}					
			
			
			List<VendorBookbank>  result = criteria.list();
			if(result!=null&&result.size()>0){
				payeeReturn = result.get(0);
				 
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return payeeReturn;
	}		
	
	public List<VendorMapPayeeEL> getVendorMapPayeeByContractNo(String contractNo) throws DAOException{
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(VendorMapPayeeEL.class);
		try{
			criteria.add(Restrictions.eq("recordStatus","Y"));
			if(StringUtils.isNotEmpty(contractNo)){
				criteria.add(Restrictions.eq("contractNo",contractNo.toUpperCase()));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return criteria.list();
	}	
	
	public void saveVendorMapPayee(VendorMapPayeeEL vendorMapPayeeEL) throws DAOException{
		getHibernateTemplate().merge(vendorMapPayeeEL);
	}
	
}
