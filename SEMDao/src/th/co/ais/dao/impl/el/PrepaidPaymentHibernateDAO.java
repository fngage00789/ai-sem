package th.co.ais.dao.impl.el;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.el.MeterInstallment;
import th.co.ais.domain.el.MeterInstallmentSearch;
import th.co.ais.domain.el.PrepaidInfo;
import th.co.ais.domain.el.PrivateDeposit;
import th.co.ais.domain.el.PrivatePrepaid;
import th.co.ais.domain.gm.Province;
import th.co.ais.domain.gm.Region;

public class PrepaidPaymentHibernateDAO extends AbstractHibernateDAO<MeterInstallment> {
	private static final Logger LOGGER 		= Logger.getLogger(PrepaidPaymentHibernateDAO.class);
	
	@SuppressWarnings("unchecked")
	public List<PrepaidInfo> getInstallment() throws DAOException {
		LOGGER.debug("Starting getInstallment()");
		
		Session session = getSessionFactory().getCurrentSession();
		Query q = session.getNamedQuery("queryPrepaidInfo");
		
		List<PrepaidInfo> returnList = q.list();		
		return returnList;
	}
	
	public PrepaidInfo getPrepaidInfo() throws DAOException {
		LOGGER.debug("Starting getPrepaidInfo()");
		PrepaidInfo prepaid = new PrepaidInfo();
		prepaid.setTotalExpenseBill("0");
		prepaid.setTotalExpenseSite("0");
		
		this.setCountAllRecord(prepaid);
		this.setCountDistinct(prepaid);
		
		return prepaid;
	}
	
	public List<MeterInstallment> getDefaultAlertPrepaidList(MeterInstallmentSearch meterSearch) 
		throws DAOException {

		LOGGER.debug("Starting getDefaultAlertPrepaidList()");
		
		StringBuffer hql = new StringBuffer();
		hql.append(" from th.co.ais.domain.el.MeterInstallment mi");
		hql.append(" where mi.paidFlag = ?");
		hql.append(" and mi.prepaidFlag = ?");
		hql.append(" and mi.recordStatus = ?");
		//hql.append(" and trunc(mi.dueDt - sysdate) <= ?");
		hql.append(" and (cast(mi.dueDt as date) - current_date) <= ?");
		
		Object[] params = { 
				meterSearch.getPaidFlag(), 
				meterSearch.getPrepaidFlag(),
				meterSearch.getRecordStatus(), 
				meterSearch.getAlertDay() };

		LOGGER.debug("HQL : "+hql);
		LOGGER.debug("parameter : "+params);
		
		return queryByHQL(hql.toString(), params);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<MeterInstallment> searchPrepaidList(
			MeterInstallmentSearch meterSearch) throws DAOException {

		LOGGER.debug("Starting searchPrepaidList()");
		LOGGER.debug("Search Parameter : " + meterSearch);
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(MeterInstallment.class);
		criteria.add(Restrictions.eq("paidFlag", "N"));
		criteria.add(Restrictions.eq("prepaidFlag", "Y"));
		criteria.add(Restrictions.eq("recordStatus", "Y"));
		
		if((null != meterSearch.getCompany())
			&& (!"".equals(meterSearch.getCompany()))){
			criteria.add(Restrictions.eq("company", meterSearch.getCompany()));
		}
		if((null != meterSearch.getContractNo())
				&& (!"".equals(meterSearch.getContractNo()))){
			criteria.add(Restrictions.like("contractNo", meterSearch.getContractNo().toUpperCase() +"%", MatchMode.START));
		}
		if((null != meterSearch.getSiteName()) 
				&& (!"".equals(meterSearch.getSiteName()))){
			criteria.add(Restrictions.like("siteName", meterSearch.getSiteName() +"%", MatchMode.START));
		}
		if((null != meterSearch.getRegion()) 
				&& (!"".equals(meterSearch.getRegion()))){
			Region region = new Region();
			region.setRowId(meterSearch.getRegion());
			criteria.add(Restrictions.eq("region", region));
		}
		if((null != meterSearch.getProvince())
				&& (!"".equals(meterSearch.getProvince()))){
			Province province = new Province();
			province.setRowId(meterSearch.getProvince());			
			criteria.add(Restrictions.eq("province", province));
		}
		if((null != meterSearch.getLocationId()) 
				&& (!"".equals(meterSearch.getLocationId()))){
			criteria.add(Restrictions.like("locationId", meterSearch.getLocationId() +"%", MatchMode.START));
		}
		if((null != meterSearch.getLocationCode())
				&& (!"".equals(meterSearch.getLocationCode()))){			
			criteria.add(Restrictions.like("locationCode", meterSearch.getLocationCode() +"%", MatchMode.START));
		}
		if(null != meterSearch.getFromTermOfPaymentDt()){
			criteria.add(Restrictions.eq("formTermOfPaymentDt", meterSearch.getFromTermOfPaymentDt()));
		}
		if(null != meterSearch.getToTermOfPaymentDt()){
			criteria.add(Restrictions.eq("toTermOfPaymentDt", meterSearch.getToTermOfPaymentDt()));
		}
		if((null != meterSearch.getSiteType())
				&& ("true".equals(meterSearch.getSiteType()))){
			criteria.add(Restrictions.eq("siteType", "02"));
		}
		
		return criteria.list();
	}

	private void setCountDistinct(PrepaidInfo prepaid){
		try{
			Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(MeterInstallment.class);
			criteria.add(Restrictions.eq("paidFlag", "N"));
			criteria.add(Restrictions.lt("dueDt", new Date()));
			criteria.add(Restrictions.eq("prepaidFlag", "Y"));
			criteria.add(Restrictions.eq("recordStatus", "Y"));
			
			ProjectionList projList = Projections.projectionList();
			projList.add(Projections.countDistinct("contractNo"));
			criteria.setProjection(projList);
			Object row = (Object) criteria.uniqueResult();
			LOGGER.debug("countDistinct contractNo : " + row);
			if(row != null){
				prepaid.setTotalExpenseSite(String.valueOf(row));
			}
		}catch (Exception e){
			LOGGER.error("Exception on setCountDistinct ", e);
		}
	}
	
	private void setCountAllRecord(PrepaidInfo prepaid){
		try{
			Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(MeterInstallment.class);
			criteria.add(Restrictions.eq("paidFlag", "N"));
			criteria.add(Restrictions.lt("dueDt", new Date()));
			criteria.add(Restrictions.eq("prepaidFlag", "Y"));
			criteria.add(Restrictions.eq("recordStatus", "Y"));
			
			ProjectionList projList = Projections.projectionList();
			projList.add(Projections.count("contractNo"));
			criteria.setProjection(projList);
			Object row = (Object) criteria.uniqueResult();
			LOGGER.debug("count contractNo : " + row);
			if(row != null){
				prepaid.setTotalExpenseBill(String.valueOf(row));
			}
		}catch (Exception e){
			LOGGER.error("Exception on setCountAllRecord ", e);
		}
	}
}
