package th.co.ais.dao.impl.gm;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.gm.LovMaster;


public class LovMasterHibernateDAO extends AbstractHibernateDAO<LovMaster>{
	
	
	public List<LovMaster> queryLovMaster(final LovMaster lovMaster) throws DAOException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(LovMaster.class);
		
		if(lovMaster != null){
			if(lovMaster.getLovName() != null && !lovMaster.getLovName().isEmpty()){
				criteria.add(Restrictions.like("lovName", lovMaster.getLovName().replace("*", "%")));
			}
			if(lovMaster.getLovType() != null && !lovMaster.getLovType().isEmpty()){
				criteria.add(Restrictions.like("lovType", lovMaster.getLovType().replace("*", "%")));
			}
			if(lovMaster.getLovCode() != null && !lovMaster.getLovCode().isEmpty()){
				criteria.add(Restrictions.like("lovCode", lovMaster.getLovCode().replace("*", "%")));
			}
			if(lovMaster.getLovVal() != null && !lovMaster.getLovVal().isEmpty()){
				criteria.add(Restrictions.like("lovVal", lovMaster.getLovVal().replace("*", "%")));
			}
			if(lovMaster.getRecordStatus() != null && !lovMaster.getRecordStatus().isEmpty()){
				criteria.add(Restrictions.like("recordStatus", lovMaster.getRecordStatus().replace("*", "%")));
			}
			if(lovMaster.getInsertFlag() != null && !lovMaster.getInsertFlag().isEmpty()){
				criteria.add(Restrictions.eq("insertFlag", lovMaster.getInsertFlag()));
			}
		}

		criteria.addOrder(Order.asc("lovOrder"))
				.addOrder(Order.asc("lovCode"));
		
		return criteria.list();
	}
	
	public LovMaster queryLovMasterByTypeAndCode(String type,String lovVal, String code) throws DAOException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(LovMaster.class);
		
		if (StringUtils.isNotEmpty(type) && StringUtils.isNotEmpty(code)) {
			criteria.add(Restrictions.like("lovType", type));
			criteria.add(Restrictions.like("lovCode", code));
			criteria.add(Restrictions.like("lovCond1", lovVal));
			criteria.add(Restrictions.like("recordStatus", "Y"));
		}
		
		return (LovMaster)criteria.uniqueResult();
	}
	
	public LovMaster queryLovMasterByTypeAndCode(String type, String code) throws DAOException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(LovMaster.class);
		
		if (StringUtils.isNotEmpty(type) && StringUtils.isNotEmpty(code)) {
			criteria.add(Restrictions.like("lovType", type));
			criteria.add(Restrictions.like("lovCode", code));
			criteria.add(Restrictions.like("recordStatus", "Y"));
		}
		
		return (LovMaster)criteria.uniqueResult();
	}
	
	public LovMaster queryLovMasterVatRate() {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(LovMaster.class);
		criteria.add(Restrictions.like("lovType", "CT_VAT_RATE"));
		criteria.add(Restrictions.like("recordStatus", "Y"));
		return (LovMaster)criteria.uniqueResult();
	}
	
	public LovMaster findByRowId(final String rowId) throws DAOException{
		String hql = "FROM LovMaster lm WHERE lm.rowId = ?";
		return querySingleByHQL(hql, rowId);
	}
	
	public LovMaster getContractLostStatus() throws DAOException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(LovMaster.class);
		criteria.add(Restrictions.like("lovType", "CO_CONTRACT_STATUS"));
		criteria.add(Restrictions.like("lovCode", "25"));
		criteria.add(Restrictions.like("recordStatus", "Y"));
		return (LovMaster)criteria.uniqueResult();
	}

}