package th.co.ais.dao.impl.el;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.PrivateDeposit;

public class PrivateDepositHibernateDAO extends AbstractHibernateDAO<PrivateDeposit> {

	public PrivateDeposit findByRowId(final String rowId) throws DAOException{
		
		getHibernateTemplate().setCacheQueries(true);
		
		return querySingleByHQL("select distinct privateDeposit from PrivateDeposit privateDeposit where privateDeposit.rowId = ? ", rowId);
	}
	
	@SuppressWarnings("unchecked")
	public List<PrivateDeposit> findByManagement(final Management manage) throws DAOException {
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(PrivateDeposit.class);
		if(manage.getContractNo()==null){
			criteria.add(Restrictions.eq("contractNo", manage.getContractNo()));
		}else{
			criteria.add(Restrictions.eq("contractNo", manage.getContractNo().toUpperCase()));
		}
		
		criteria.add(Restrictions.eq("siteInfoId", manage.getSiteInfoId()));
		criteria.add(Restrictions.eq("recordStatus", "Y"));
		criteria.addOrder(Order.asc("rowId"));
		
		return criteria.list();
	}
	
	//WT###Add 20110121 Start
	@SuppressWarnings("unchecked")
	public List<PrivateDeposit> findByManagementWithDepositType(final Management manage, String depositType) throws DAOException {
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(PrivateDeposit.class);
		if(manage.getContractNo()==null){
			criteria.add(Restrictions.eq("contractNo", manage.getContractNo()));
		}else{
			criteria.add(Restrictions.eq("contractNo", manage.getContractNo().toUpperCase()));
		}
		
		criteria.add(Restrictions.eq("siteInfoId", manage.getSiteInfoId()));
		criteria.add(Restrictions.eq("recordStatus", "Y"));
		criteria.add(Restrictions.eq("depositType", depositType));
		criteria.addOrder(Order.asc("rowId"));
		
		return criteria.list();
	}
	//WT###Add 20110121 End
	
	@SuppressWarnings("unchecked")
	public List<PrivateDeposit> findByCriteria(String contractNo, String depositType, String depositSpecialFlag) throws DAOException {
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(PrivateDeposit.class);
		if(contractNo==null){
			criteria.add(Restrictions.eq("contractNo", contractNo));
		}else{
			criteria.add(Restrictions.eq("contractNo", contractNo.toUpperCase()));
		}
		
		criteria.add(Restrictions.eq("depositType", depositType));
		criteria.add(Restrictions.eq("depositSpecialFlag", depositSpecialFlag));
		criteria.add(Restrictions.eq("recordStatus", "Y"));
		criteria.addOrder(Order.asc("rowId"));
		
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<PrivateDeposit> findByCriteria(String siteInfoId, String contractNo, String depositType, String depositSpecialFlag) throws DAOException {
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(PrivateDeposit.class);
		if(siteInfoId != null){
			criteria.add(Restrictions.eq("siteInfoId", siteInfoId));
		}
		
		if(contractNo==null){
			criteria.add(Restrictions.eq("contractNo", contractNo));
		}else{
			criteria.add(Restrictions.eq("contractNo", contractNo.toUpperCase()));
		}
		
		criteria.add(Restrictions.eq("depositType", depositType));
		criteria.add(Restrictions.eq("depositSpecialFlag", depositSpecialFlag));
		criteria.add(Restrictions.eq("recordStatus", "Y"));
		criteria.addOrder(Order.asc("rowId"));
		
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<PrivateDeposit> findByContractNoAndNewFlag(String contractNo, String newFlag, String recordStatus) throws DAOException {
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(PrivateDeposit.class);
		if(contractNo==null){
			criteria.add(Restrictions.eq("contractNo", contractNo));
		}else{
			criteria.add(Restrictions.eq("contractNo", contractNo.toUpperCase()));
		}
		
		criteria.add(Restrictions.eq("newFlag", newFlag));
		criteria.add(Restrictions.eq("recordStatus", recordStatus));
		
		criteria.addOrder(Order.asc("rowId"));
		
		return criteria.list();
	}
}
