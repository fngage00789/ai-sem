package th.co.ais.dao.impl.el;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.el.DepositDetail;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.ManagementSP;

public class DepositDetailHibernateDAO extends AbstractHibernateDAO<DepositDetail> {

	public DepositDetail findByRowId(final String rowId) throws DAOException{
		
		getHibernateTemplate().setCacheQueries(true);
		
		return querySingleByHQL("select distinct depositDetail from DepositDetail depositDetail where depositDetail.rowId = ? ", rowId);
	}
	
	@SuppressWarnings("unchecked")
	public List<DepositDetail> findByManagement(final Management manage, String depositType, String expenseType, String recordStatus) throws DAOException {
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(DepositDetail.class);
		criteria.add(Restrictions.eq("electricId", manage));
		criteria.add(Restrictions.eq("depositType", depositType));
		criteria.add(Restrictions.eq("expenseType", expenseType));
		criteria.add(Restrictions.eq("recordStatus", recordStatus));
		criteria.addOrder(Order.asc("rowId"));
		
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<DepositDetail> findByManagement(final ManagementSP manage, String depositType, String expenseType, String recordStatus) throws DAOException {
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(DepositDetail.class);
		criteria.add(Restrictions.eq("electricId", manage));
		criteria.add(Restrictions.eq("depositType", depositType));
		criteria.add(Restrictions.eq("expenseType", expenseType));
		criteria.add(Restrictions.eq("recordStatus", recordStatus));
		criteria.addOrder(Order.asc("rowId"));
		
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<DepositDetail> queryByCriteria(DepositDetail depositDetail) throws DAOException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(DepositDetail.class).createAlias("electricId", "electricIdAlias");
		criteria.add(Restrictions.eq("electricIdAlias.company", depositDetail.getElectricId().getCompany()));
		criteria.add(Restrictions.eq("electricIdAlias.electricUseType", depositDetail.getElectricId().getElectricUseType()));
		if(null!=depositDetail.getElectricId().getContractNo() && !"".equals(depositDetail.getElectricId().getContractNo())){
			criteria.add(Restrictions.eq("electricIdAlias.contractNo", depositDetail.getElectricId().getContractNo()));
		}
		if(null != depositDetail.getElectricId().getContractStartDtFrom() && null != depositDetail.getElectricId().getContractStartDtTo()){
			criteria.add(Restrictions.between("electricIdAlias.contractStartDt",depositDetail.getElectricId().getContractStartDtFrom(), depositDetail.getElectricId().getContractStartDtTo()));
		}
		if(null != depositDetail.getElectricId().getContractEndDtFrom() && null != depositDetail.getElectricId().getContractEndDtTo()){
			criteria.add(Restrictions.between("electricIdAlias.contractEndDt",depositDetail.getElectricId().getContractEndDtFrom(), depositDetail.getElectricId().getContractEndDtTo()));
		}
		if(null!= depositDetail.getDepositType() && !"".equals(depositDetail.getDepositType())){
			criteria.add(Restrictions.eq("depositType", depositDetail.getDepositType()));
		}
		if(null!= depositDetail.getRecordStatus() && !"".equals(depositDetail.getRecordStatus())){
			criteria.add(Restrictions.eq("recordStatus", depositDetail.getRecordStatus()));
		}
		
		criteria.addOrder(Order.asc("rowId"));
		
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<DepositDetail> queryDepositDetail(DepositDetail depositDetail) throws DAOException {
		System.out.println("WT###Print queryDepositDetail=");
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(DepositDetail.class);		
		if(null!= depositDetail.getDepositType() && !"".equals(depositDetail.getDepositType())){
			criteria.add(Restrictions.eq("depositType", depositDetail.getDepositType()));
		}
		if(null!= depositDetail.getRecordStatus() && !"".equals(depositDetail.getRecordStatus())){
			criteria.add(Restrictions.eq("recordStatus", depositDetail.getRecordStatus()));
		}
		if(null!=depositDetail.getElectricId().getContractNo() && !"".equals(depositDetail.getElectricId().getContractNo())){
			criteria.createAlias("electricId", "electricIdAlias");
			criteria.add(Restrictions.eq("electricIdAlias.contractNo", depositDetail.getElectricId().getContractNo()));
		}
		if(null != depositDetail.getElectricId().getContractStartDtFrom() && null != depositDetail.getElectricId().getContractStartDtTo()){
			criteria.createAlias("electricId", "electricIdAlias");
			criteria.add(Restrictions.between("electricIdAlias.contractStartDt",depositDetail.getElectricId().getContractStartDtFrom(), depositDetail.getElectricId().getContractStartDtTo()));
		}
		if(null != depositDetail.getElectricId().getContractEndDtFrom() && null != depositDetail.getElectricId().getContractEndDtTo()){
			criteria.createAlias("electricId", "electricIdAlias");
			criteria.add(Restrictions.between("electricIdAlias.contractEndDt",depositDetail.getElectricId().getContractEndDtFrom(), depositDetail.getElectricId().getContractEndDtTo()));
		}
		if(null!=depositDetail.getElectricId().getElectricUseType() && !"".equals(depositDetail.getElectricId().getElectricUseType())){
			criteria.createAlias("electricId", "electricIdAlias");
			criteria.add(Restrictions.eq("electricIdAlias.electricUseType", depositDetail.getElectricId().getElectricUseType()));
		}
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.addOrder(Order.asc("rowId"));
		
		return criteria.list();
	}
}
