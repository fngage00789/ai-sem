package th.co.ais.dao.impl.gm;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.gm.VendorBookbank;

public class VendorBookbankHibernateDAO extends AbstractHibernateDAO<VendorBookbank> {

	public VendorBookbank queryVendorBookBankByVendorMasterId(String vendorMasterId) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(VendorBookbank.class);
		
		if (StringUtils.isNotEmpty(vendorMasterId)) {
			criteria.add(Restrictions.like("vendorMasterId", vendorMasterId));
			criteria.add(Restrictions.like("recordStatus", "Y"));
			return (VendorBookbank)criteria.uniqueResult();
		}
		return null;
	}
	
	public VendorBookbank queryVendorBookBankByVendorMaster(VendorBookbank vendorBookbank) {
		if(null==vendorBookbank){
			return null;
		}
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(VendorBookbank.class);
		
		if (StringUtils.isNotEmpty(vendorBookbank.getVendorMasterId())) {
			criteria.add(Restrictions.like("vendorMasterId", vendorBookbank.getVendorMasterId()));
			criteria.add(Restrictions.like("recordStatus", "Y"));
		}
		if (StringUtils.isNotEmpty(vendorBookbank.getVendorBookbankStatus())) {
			criteria.add(Restrictions.like("vendorBookbankStatus", vendorBookbank.getVendorBookbankStatus()));
		}
		return (VendorBookbank)criteria.uniqueResult();
	}
	
	public List<VendorBookbank> queryAllVendorBookbank(){
		Criteria criteria = getSession().createCriteria(VendorBookbank.class);
		return criteria.list();
	}	
	
	public VendorBookbank findByRowId(final String rowId) throws DAOException {
		String hql = "FROM VendorBookbank vbb WHERE vbb.rowId = ?";
		return querySingleByHQL(hql, rowId);
	}
	
	public VendorBookbank findByBankAccountNo(final String bankAccNo) throws DAOException {
		String hql = "FROM VendorBookbank vbb WHERE vbb.bankAccNo = ? and vbb.recordStatus = 'Y'";
		return querySingleByHQL(hql, bankAccNo);
	}
	
	public List<VendorBookbank> queryVendorBookbank(final VendorBookbank vendorBookbank) throws DAOException {
		
		Criteria criteria = getSession().createCriteria(VendorBookbank.class);
		
		if(vendorBookbank != null){
			
			if(StringUtils.isNotEmpty(vendorBookbank.getBankCode())){
				criteria.add(Restrictions.like("bankCode", vendorBookbank.getBankCode().replace("*", "%")));
			}
			if(StringUtils.isNotEmpty(vendorBookbank.getBankAccName())){
				criteria.add(Restrictions.like("bankAccName", vendorBookbank.getBankAccName().replace("*", "%")));
			}
			if(StringUtils.isNotEmpty(vendorBookbank.getRecordStatus())){
				criteria.add(Restrictions.eq("recordStatus", vendorBookbank.getRecordStatus()));
			}
			if(StringUtils.isNotEmpty(vendorBookbank.getVendorMasterId())){
				criteria.add(Restrictions.eq("vendorMasterId", vendorBookbank.getVendorMasterId()));
			}
			
		}
		criteria.addOrder(Order.asc("bankCode"));
		
		return criteria.list();
	}
}
