package th.co.ais.dao.impl.el;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.MeterInstallment;
import th.co.ais.domain.el.MeterInstallmentSearch;
import th.co.ais.domain.el.PrepaidInfo;
import th.co.ais.domain.el.PrivatePrepaid;
import th.co.ais.domain.gm.Province;
import th.co.ais.domain.gm.Region;
 
public class PrivatePrepaidMeterInstallmentHibernateDAO extends
		AbstractHibernateDAO<PrivatePrepaid> {

	private static final Logger LOGGER 		= Logger.getLogger(PrepaidPaymentHibernateDAO.class);
	
	public PrivatePrepaid findByRowId(final String rowId) throws DAOException {
		getHibernateTemplate().setCacheQueries(true);
		StringBuffer hql = new StringBuffer();
		hql.append("select distinct meterInstallment from MeterInstallment mi");
		hql.append(" where m.rowId = ? ");

		return querySingleByHQL(hql.toString(), rowId);
	}

	@SuppressWarnings("unchecked")
	public List<MeterInstallment> findByContractNo(String contractNo)
			throws DAOException {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(PrivatePrepaid.class);
		if(contractNo==null){
			criteria.add(Restrictions.eq("contractNo", contractNo));
		}else{
			criteria.add(Restrictions.eq("contractNo", contractNo.toUpperCase()));
		}
		criteria.addOrder(Order.asc("rowId"));
		return criteria.list();
	}

	@SuppressWarnings("rawtypes")
	public List searchEL009(MeterInstallment meterInstallment)
			throws DAOException, ParseException {

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(PrivatePrepaid.class);
		if (meterInstallment != null) {
			if (meterInstallment.isSelected()) {
				//Subquery
				DetachedCriteria subquery = DetachedCriteria.forClass(MeterInstallment.class, "sbq");
				subquery.add(Restrictions.eq("paidFlag", "N"));
				subquery.add(Restrictions.eq("recordStatus", "Y"));
				
				if (meterInstallment.getCompany() != null) {
					subquery.add(Restrictions.eq("company",	meterInstallment.getCompany()));
				}
				if (meterInstallment.getRegion() != null) {
					subquery.add(Restrictions.eq("region", meterInstallment.getRegion()));
				}
				if ((meterInstallment.getElectricUseType() != null)
						&& !("ALL".equals(meterInstallment.getElectricUseType()))) {
					subquery.add(Restrictions.eq("electricUseType",	meterInstallment.getElectricUseType()));
				}

				ProjectionList projList = Projections.projectionList();
				projList.add(Projections.min("termOfPaymentDt"));
				subquery.setProjection(projList);
				
				//Main query
				criteria.add(Property.forName("termOfPaymentDt").eq(subquery));
				
				ProjectionList projLists = Projections.projectionList();
				projLists.add(Projections.min("termOfPaymentDt"));
				projLists.add(Projections.groupProperty("company"));
				projLists.add(Projections.groupProperty("region"));
				projLists.add(Projections.groupProperty("electricUseType"));
				projLists.add(Projections.rowCount());
				criteria.setProjection(projLists);
				
			} else {
				criteria.add(Restrictions.eq("paidFlag", "N"));
				criteria.add(Restrictions.eq("recordStatus", "Y"));
				
				if (meterInstallment.getCompany() != null) {
					criteria.add(Restrictions.eq("company",	meterInstallment.getCompany()));
				}
				if (meterInstallment.getRegion() != null) {
					criteria.add(Restrictions.eq("region",	meterInstallment.getRegion()));
				}
				if ((meterInstallment.getElectricUseType() != null)
						&& !("ALL".equals(meterInstallment.getElectricUseType()))) {
					criteria.add(Restrictions.eq("electricUseType",	meterInstallment.getElectricUseType()));
				}

				SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy",	new Locale("th", "TH"));
				String periodTxt = "01"	+ meterInstallment.getFormTermOfPaymentMonth()+ meterInstallment.getFormTermOfPaymentYear();
				Date fromTermOfPaymentDt = sdf.parse(periodTxt);
				periodTxt = "01" + meterInstallment.getToTermOfPaymentMonth()+ meterInstallment.getToTermOfPaymentYear();
				Date ToTermOfPaymentDt = sdf.parse(periodTxt);
				criteria.add(Restrictions.between("termOfPaymentDt",fromTermOfPaymentDt, ToTermOfPaymentDt));
				
				ProjectionList projList = Projections.projectionList();
				projList.add(Projections.groupProperty("company"));
				projList.add(Projections.groupProperty("region"));
				projList.add(Projections.groupProperty("electricUseType"));
				projList.add(Projections.count("company"));

				criteria.setProjection(projList);
			}
		}
		
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<MeterInstallment> getDetailEL009(
			MeterInstallment meterInstallment) throws DAOException,
			ParseException {
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(PrivatePrepaid.class);
		criteria.add(Restrictions.eq("paidFlag", "N"));
		criteria.add(Restrictions.eq("recordStatus", "Y"));
		criteria.add(Restrictions.eq("company", meterInstallment.getCompany()));
		criteria.add(Restrictions.eq("region", meterInstallment.getRegion()));
		criteria.add(Restrictions.eq("electricUseType",	meterInstallment.getElectricUseType()));
		if (meterInstallment.isSelected()) {
			criteria.add(Restrictions.eq("termOfPaymentDt",	meterInstallment.getTermOfPaymentDt()));
		}else{
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy",	new Locale("th", "TH"));
			String periodTxt = "01"	+ meterInstallment.getFormTermOfPaymentMonth()+ meterInstallment.getFormTermOfPaymentYear();
			Date fromTermOfPaymentDt = sdf.parse(periodTxt);
			periodTxt = "01" + meterInstallment.getToTermOfPaymentMonth()+ meterInstallment.getToTermOfPaymentYear();
			Date ToTermOfPaymentDt = sdf.parse(periodTxt);
			criteria.add(Restrictions.between("termOfPaymentDt",fromTermOfPaymentDt, ToTermOfPaymentDt));
		}
		
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<MeterInstallment> findByManagement(Management manage, boolean isDistinctMeterIdOnly) throws DAOException {

		Session session = getSessionFactory().getCurrentSession();
		
		// distinct
		String[] properties = null;
		
		if(isDistinctMeterIdOnly){
			
			properties = new String[]{"meterId"};
			
		}else{
			
			properties = new String[]{"meterId", "referMeterId"};
		}
		
		ProjectionList projectionList = Projections.projectionList();
        for(int i=0;i<properties.length;i++){
        	
        	projectionList.add(Projections.property(properties[i]), properties[i]);
        }
		
	    // criteria
		Criteria criteria = session.createCriteria(MeterInstallment.class);
		if(manage.getContractNo()==null){
			criteria.add(Restrictions.eq("contractNo", manage.getContractNo()));
		}else{
			criteria.add(Restrictions.eq("contractNo", manage.getContractNo().toUpperCase()));
		}
		criteria.add(Restrictions.eq("electricUseType",	manage.getElectricUseType()));
		criteria.add(Restrictions.eq("company", manage.getCompany()));
		criteria.add(Restrictions.eq("paidFlag", "N"));
		criteria.add(Restrictions.eq("recordStatus", "Y"));
		criteria.setProjection(Projections.distinct(projectionList));

		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<MeterInstallment> queryByCritiria(MeterInstallment meterInstallment) throws DAOException{
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(PrivatePrepaid.class);
		if(meterInstallment != null){
			if(StringUtils.isNotEmpty(meterInstallment.getContractNo())){
				criteria.add(Restrictions.eq("contractNo", meterInstallment.getContractNo().toUpperCase()));
			}
			if(StringUtils.isNotEmpty(meterInstallment.getRecordStatus())){
				criteria.add(Restrictions.like("recordStatus", meterInstallment.getRecordStatus()));
			}
			if(StringUtils.isNotEmpty(meterInstallment.getPaidFlag())){
				criteria.add(Restrictions.like("paidFlag", meterInstallment.getPaidFlag()));
			}
		}
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<PrivatePrepaid> queryByCritiriaPrivatePrepaid(PrivatePrepaid  meterInstallment) throws DAOException{
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(PrivatePrepaid.class);
		if(meterInstallment != null){
			if(StringUtils.isNotEmpty(meterInstallment.getContractNo())){
				criteria.add(Restrictions.eq("contractNo", meterInstallment.getContractNo().toUpperCase()));
			}
			if(StringUtils.isNotEmpty(meterInstallment.getRecordStatus())){
				criteria.add(Restrictions.like("recordStatus", meterInstallment.getRecordStatus()));
			}
			if(StringUtils.isNotEmpty(meterInstallment.getPaidFlag())){
				criteria.add(Restrictions.like("paidFlag", meterInstallment.getPaidFlag()));
			}
		}
		return criteria.list();
	}
	@SuppressWarnings("unchecked")
	public List<PrivatePrepaid> findByMeterId(Management manage, PrivatePrepaid meterInstallment, boolean isMeterIdOnly) throws DAOException{
		
		Session session = getSessionFactory().getCurrentSession();
		
		Criteria criteria = session.createCriteria(MeterInstallment.class);
		
		if(meterInstallment != null){
			
			if(isMeterIdOnly){
				
				criteria.add(Restrictions.eq("meterId", meterInstallment.getMeterId()));
				
			}else{
				
				if(StringUtils.isNotEmpty(meterInstallment.getMeterId())){
					
					criteria.add(Restrictions.eq("meterId", meterInstallment.getMeterId()));
					
				}else{
					
					criteria.add(Restrictions.isNull("meterId"));
				}
				
				if(StringUtils.isNotEmpty(meterInstallment.getReferMeterId())){
					
					criteria.add(Restrictions.eq("referMeterId", meterInstallment.getReferMeterId()));
					
				}else{
					
					criteria.add(Restrictions.isNull("referMeterId"));
				}
			}
			if(manage.getContractNo()==null){
				criteria.add(Restrictions.eq("contractNo", manage.getContractNo()));
			}else{
				criteria.add(Restrictions.eq("contractNo", manage.getContractNo().toUpperCase()));
			}
			criteria.add(Restrictions.eq("electricUseType",	manage.getElectricUseType()));
			criteria.add(Restrictions.eq("company", manage.getCompany()));
			criteria.add(Restrictions.eq("paidFlag", "N"));
			criteria.add(Restrictions.eq("recordStatus", "Y"));
			criteria.addOrder(Order.asc("termOfPaymentDt"));
			
			return criteria.list();
			
		}else{
			
			return new ArrayList<PrivatePrepaid>(0);
		}
	}
	
	public List<PrivatePrepaid> getDefaultPrepaidList(MeterInstallmentSearch meterSearch) 
	throws DAOException {

	//LOGGER.debug("Starting getDefaultAlertPrepaidList()");
	
	StringBuffer hql = new StringBuffer();
	hql.append(" from th.co.ais.domain.el.PrivatePrepaid mi");
	hql.append(" where mi.paidFlag = ?");
	hql.append(" and mi.prepaidFlag = ?");
	hql.append(" and mi.recordStatus = ?");
	//hql.append(" and trunc(mi.dueDt - sysdate) <= ?");
	//hql.append(" and trunc(mi.dueDt) >=  trunc(sysdate)");
	//hql.append(" and trunc(mi.dueDt) <= trunc(sysdate+?)");
	
	hql.append(" and cast(mi.dueDt as date) >=  (current_date)");
	hql.append(" and cast(mi.dueDt as date) <= cast(current_date+cast(? as integer) as date)");
	
	hql.append(" order by mi.contractNo,mi.periodNo");
	
	Object[] params = { 
			meterSearch.getPaidFlag(), 
			meterSearch.getPrepaidFlag(),
			meterSearch.getRecordStatus(), 
			meterSearch.getAlertDay() 
			};

	//LOGGER.debug("HQL : "+hql);
	//LOGGER.debug("parameter : "+params);
	
	return queryByHQL(hql.toString(), params);
	}
	
	@SuppressWarnings("unchecked")
	public List<PrepaidInfo> getInstallment() throws DAOException {
		//LOGGER.debug("Starting getInstallment()");
		
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
	
	@SuppressWarnings("unchecked")
	public List<PrivatePrepaid> searchPrepaidList(
			MeterInstallmentSearch meterSearch) throws DAOException {

		LOGGER.debug("Starting searchPrepaidList()");
		LOGGER.debug("Search Parameter : " + meterSearch);
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(PrivatePrepaid.class);
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
    //-----------------------------------------------------------------------------------------
	@SuppressWarnings("unchecked")
	public List<PrivatePrepaid> searchPrivatePrepaid(
			MeterInstallmentSearch meterSearch) throws DAOException {

		LOGGER.debug("Starting searchPrepaidList()");
		LOGGER.debug("Search Parameter : " + meterSearch);
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(PrivatePrepaid.class);
		criteria.add(Restrictions.eq("paidFlag", "N"));
		criteria.add(Restrictions.eq("prepaidFlag", "Y"));
		criteria.add(Restrictions.eq("recordStatus", "Y"));
		
		boolean  fromTermOfPaymentDt = false;
		boolean  toTermOfPaymentDt   = false;
		
		
		
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
		if(meterSearch.isCheckSite()){
			criteria.add(Restrictions.eq("siteType", "02"));
		}
		//-------------------------------------------------------------------------------------------------------
		if(null != meterSearch.getFromTermOfPaymentDt()){
			//criteria.add(Restrictions.eq("formTermOfPaymentDt", meterSearch.getFromTermOfPaymentDt()));
			fromTermOfPaymentDt = true;
		}
		if(null != meterSearch.getToTermOfPaymentDt()){
			//criteria.add(Restrictions.eq("toTermOfPaymentDt", meterSearch.getToTermOfPaymentDt()));
			toTermOfPaymentDt = true;
		}
		
		if(fromTermOfPaymentDt && toTermOfPaymentDt ){
			LOGGER.debug("fromTermOfPaymentDt && toTermOfPaymentDt:1");	
			criteria.add(Restrictions.and(
					//Restrictions.sqlRestriction("trunc(DUE_DT) >= trunc(?)",meterSearch.getFromTermOfPaymentDt(),Hibernate.DATE),
					//Restrictions.sqlRestriction("trunc(DUE_DT) <= trunc(?)",meterSearch.getToTermOfPaymentDt(),Hibernate.DATE)
					
					Restrictions.sqlRestriction("cast(DUE_DT as date) >= cast(? as date)",meterSearch.getFromTermOfPaymentDt(),Hibernate.DATE),
					Restrictions.sqlRestriction("cast(DUE_DT as date) <= cast(? as date)",meterSearch.getToTermOfPaymentDt(),Hibernate.DATE)

					
					));
			
		}else if(fromTermOfPaymentDt && !toTermOfPaymentDt){
			LOGGER.debug("fromTermOfPaymentDt && !toTermOfPaymentDt:2");
			//criteria.add(Restrictions.sqlRestriction("trunc(TERM_OF_PAYMENT_DT) >= trunc(?)",meterSearch.getFromTermOfPaymentDt(),Hibernate.DATE));
			criteria.add(Restrictions.sqlRestriction("cast(TERM_OF_PAYMENT_DT as date) >= cast(? as date)",meterSearch.getFromTermOfPaymentDt(),Hibernate.DATE));
			
		}else if(!fromTermOfPaymentDt && toTermOfPaymentDt){
			LOGGER.debug("!fromTermOfPaymentDt && toTermOfPaymentDt:3)");
			criteria.add(Restrictions.sqlRestriction("cast(TERM_OF_PAYMENT_DT as date) <= cast(? as date)",meterSearch.getToTermOfPaymentDt(),Hibernate.DATE));
			//Hibernate.DATE;
		}
		
		criteria.addOrder(Order.asc("contractNo"));
		criteria.addOrder(Order.asc("periodNo"));
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
	
	public void updateByRowId(PrivatePrepaid privatePrepaid) throws DAOException {
		getHibernateTemplate().setCacheQueries(true);
		StringBuffer hql = new StringBuffer();
		LOGGER.debug("updateByRowId(PrivatePrepaid privatePrepaid) : ");
		//LOGGER.debug("privatePrepaid.getRowId() : "+ privatePrepaid.getRowId());
		//hql.append("select distinct meterInstallment from MeterInstallment mi");
		//hql.append(" where m.rowId = ? ");
		//hql.append("UPDATE PrivatePrepaid p set p.paidFlag = Y");
		//hql.append(" WHERE p.rowId ? ");
		//return querySingleByHQL(hql.toString(), privatePrepaid.getRowId());
	}
}
