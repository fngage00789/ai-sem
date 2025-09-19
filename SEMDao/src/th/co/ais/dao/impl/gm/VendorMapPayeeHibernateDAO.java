package th.co.ais.dao.impl.gm;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.gm.VendorMapPayee;
import th.co.ais.domain.ir.Replacement;

public class VendorMapPayeeHibernateDAO extends AbstractHibernateDAO<VendorMapPayee> {

	@SuppressWarnings("unchecked")
	public List<VendorMapPayee> queryAllVendorMapPayee() throws DAOException{
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(VendorMapPayee.class);
		
		return criteria.list();
	}	
	
	@SuppressWarnings("unchecked")
	public List<VendorMapPayee> queryAllVendorMapPayeeMasterForCash(String expenseType, String recordStatus) throws DAOException{
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(VendorMapPayee.class);
		
		if(StringUtils.isNotEmpty(expenseType)){
			
			criteria.add(Restrictions.eq("expenseType",expenseType));
			criteria.add(Restrictions.eq("recordStatus", recordStatus));
		}
		
		return criteria.list();
	}
	
	public VendorMapPayee findByRowId(final String rowId) throws DAOException {
		String hql = "FROM VendorMapPayee vmp WHERE vmp.rowId = ?";
		return querySingleByHQL(hql, rowId);
	}
	
	public VendorMapPayee findByVendorMasterId(final String masterId) throws DAOException {
		String hql = "FROM VendorMapPayee vmp WHERE vmp.vendorMasterId = ?";
		return querySingleByHQL(hql, masterId);
	}
	
	public List<VendorMapPayee> queryVendorMapPayeeNoMapping(final VendorMapPayee vendorMapPayee) throws DAOException {
		
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(VendorMapPayee.class);
		
		if(vendorMapPayee != null){
			if(StringUtils.isNotEmpty(vendorMapPayee.getContractNo())){
				criteria.add(Restrictions.eq("contractNo", vendorMapPayee.getContractNo()));
			}
			if(StringUtils.isNotEmpty(vendorMapPayee.getExpenseType())){
				criteria.add(Restrictions.eq("expenseType", vendorMapPayee.getExpenseType()));
			}
			if(StringUtils.isNotEmpty(vendorMapPayee.getVendorMasterId())){
				criteria.add(Restrictions.eq("vendorMasterId", vendorMapPayee.getVendorMasterId()));
			}
			
			criteria.add(Restrictions.eq("recordStatus", "Y"));
			criteria.add(Expression.isNull("payeeMasterId"));
		}

		criteria.addOrder(Order.asc("rowId"));
		return criteria.list();
	}
	
	public List<VendorMapPayee> queryVendorMapPayeeMapping(final VendorMapPayee vendorMapPayee) throws DAOException {
		
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(VendorMapPayee.class);
		
		if(vendorMapPayee != null){
			if(StringUtils.isNotEmpty(vendorMapPayee.getContractNo())){
				criteria.add(Restrictions.eq("contractNo", vendorMapPayee.getContractNo()));
			}
			if(StringUtils.isNotEmpty(vendorMapPayee.getExpenseType())){
				criteria.add(Restrictions.eq("expenseType", vendorMapPayee.getExpenseType()));
			}
			if(StringUtils.isNotEmpty(vendorMapPayee.getVendorMasterId())){
				criteria.add(Restrictions.eq("vendorMasterId", vendorMapPayee.getVendorMasterId()));
			}
			if(StringUtils.isNotEmpty(vendorMapPayee.getPayeeMasterId())){
				criteria.add(Restrictions.eq("payeeMasterId", vendorMapPayee.getPayeeMasterId()));
			}
			criteria.add(Restrictions.eq("recordStatus", "Y"));
		}

		criteria.addOrder(Order.asc("rowId"));
		return criteria.list();
	}
}
