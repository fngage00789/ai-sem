package th.co.ais.dao.impl.el;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.el.BgMaster;
import th.co.ais.domain.el.BgMasterSPEL;
import th.co.ais.domain.el.ExportMainBgSP;

public class BgMasterHibernateDAO extends AbstractHibernateDAO<BgMaster> {

	@SuppressWarnings("unchecked")
	public List<BgMaster> queryAllVendorMaster() throws DAOException{
		
		Session session = getSessionFactory().getCurrentSession();
		
		Criteria criteria = session.createCriteria(BgMaster.class);
		
		return criteria.list();
	}
	
	public BgMaster findByRowId(final String rowId) throws DAOException{
		
		getHibernateTemplate().setCacheQueries(true);
		
		return querySingleByHQL("select distinct bgMaster from ElectricBGMaster bgMaster where bgMaster.rowId = ? ", rowId);
	}
	
	@SuppressWarnings("unchecked")
	public List<BgMaster> findByCriteria(String bgType, String expenseType, String bgStatus, String company, 
			String electricUseType, String recordStatus) throws DAOException {
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(BgMaster.class);
		criteria.add(Restrictions.eq("bgType", bgType));
		criteria.add(Restrictions.eq("bgStatus", bgStatus));
		criteria.add(Restrictions.eq("company", company));
		criteria.add(Restrictions.eq("electricUseType", electricUseType));
		criteria.add(Restrictions.eq("recordStatus", recordStatus));
		
		criteria.addOrder(Order.asc("rowId"));
		
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<BgMaster> queryByCriteria(BgMaster bgMaster) throws DAOException {
		
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(BgMaster.class);
		criteria.add(Restrictions.eq("company", bgMaster.getCompany()));
		criteria.add(Restrictions.eq("electricUseType", bgMaster.getElectricUseType()));
		if(null!=bgMaster.getContractNo() && !"".equals(bgMaster.getContractNo())){
			criteria.add(Restrictions.eq("contractNo", bgMaster.getContractNo().toUpperCase()));
		}
		if(null != bgMaster.getBgStartDtFrom() && null != bgMaster.getBgStartDtTo()){
			criteria.add(Restrictions.between("bgStartDt", bgMaster.getBgStartDtFrom(), bgMaster.getBgStartDtTo()));
		}
		if(null != bgMaster.getBgEndDtFrom() && null != bgMaster.getBgEndDtTo()){
			criteria.add(Restrictions.between("bgEndDt", bgMaster.getBgEndDtFrom(), bgMaster.getBgEndDtTo()));
		}
		
		/* WT###Edit 20101222
		 * Criterion statusD = Restrictions.eq("bgStatus","D");
		Criterion statusA = Restrictions.eq("bgStatus","A");
		LogicalExpression orExp = Restrictions.or(statusD,statusA);
		criteria.add(orExp);*/
		criteria.add(Restrictions.disjunction().
				add(Restrictions.eq("bgStatus", "D")).
				add(Restrictions.eq("bgStatus", "A")).
				add(Restrictions.eq("bgStatus", "N")).
				add(Restrictions.eq("bgStatus", "F")).
				add(Restrictions.eq("bgStatus", "E")).
				add(Restrictions.eq("bgStatus", "R")));
		//WT###Edit 20101222 End
		
		criteria.addOrder(Order.asc("rowId"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		return criteria.list();
	}

	public String saveWithReturnId(BgMaster bgMaster) {
		if(null!=bgMaster.getBgMapContracts() && bgMaster.getBgMapContracts().size()>0){
			System.out.println("WT###PrintbgMaster getBgMapContracts().size()="+bgMaster.getBgMapContracts().size());
			
		}
		
		return (String) getHibernateTemplate().save(bgMaster);
	}
	
	@SuppressWarnings("unchecked")
	public List<BgMasterSPEL> queryBgMasterSP(String bgMasterId)
			throws DAOException {
		
		Session session = getSessionFactory().getCurrentSession();
		session.flush();
        Query q = session.getNamedQuery("queryBgMasterSP");
        q.setString("bgMasterId",bgMasterId); 
        List<BgMasterSPEL> returnList = q.list();
        return returnList; 
	}
	
	@SuppressWarnings("unchecked")
	public List<ExportMainBgSP> queryExportMainBgSP(String bgMasterId)
			throws DAOException {
		
		Session session = getSessionFactory().getCurrentSession();
		session.flush();
        Query q = session.getNamedQuery("queryExportMainBgSP");
        q.setString("bgMasterId",bgMasterId); 
        List<ExportMainBgSP> returnList = q.list();
        return returnList; 
	}
	
}
