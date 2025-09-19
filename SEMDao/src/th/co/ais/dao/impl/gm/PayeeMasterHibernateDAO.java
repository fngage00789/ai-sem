package th.co.ais.dao.impl.gm;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.el.PaymentVendorMapPayee;
import th.co.ais.domain.gm.PayeeMaster;

public class PayeeMasterHibernateDAO extends AbstractHibernateDAO<PayeeMaster> {

	public PayeeMaster findByRowId(final String rowId) throws DAOException{
		String hql = "FROM PayeeMaster pm WHERE pm.rowId = ?";
		return querySingleByHQL(hql, rowId);
	}
	
	public PayeeMaster findByIdCard(final String idCard) throws DAOException{
		String hql = "FROM PayeeMaster pm WHERE pm.idCard = ?";
		return querySingleByHQL(hql, idCard);
	}
	
	public PayeeMaster findByTaxId(final String taxId) throws DAOException{
		String hql = "FROM PayeeMaster pm WHERE pm.taxId = ?";
		return querySingleByHQL(hql, taxId);
	}
	
	public PayeeMaster findByPayeeName(final String payeeName) throws DAOException{
		String hql = "FROM PayeeMaster pm WHERE pm.payeeName = ?";
		return querySingleByHQL(hql, payeeName);
	}
	
	@SuppressWarnings("unchecked")
	public List<PayeeMaster> queryAllVendorMaster() throws DAOException{
		
		Session session = getSessionFactory().getCurrentSession();
		
		Criteria criteria = session.createCriteria(PayeeMaster.class);
		
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<PayeeMaster> queryPayeeMasterByCode(PayeeMaster payeeMaster){
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(PaymentVendorMapPayee.class);
		
		if(payeeMaster != null){
			
			if(StringUtils.isNotEmpty(payeeMaster.getPayeeCode())){
				
				criteria.add(Restrictions.eq("EXPENSE_CODE",payeeMaster.getPayeeCode()));
			}
		}

		criteria.addOrder(Order.asc("rowId"));
		
		return criteria.list();
	}
}
