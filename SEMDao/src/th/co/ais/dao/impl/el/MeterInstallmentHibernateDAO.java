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
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.ManagementSP;
import th.co.ais.domain.el.MeterInstallment;
import th.co.ais.domain.el.PopupSiteSearch;
import th.co.ais.domain.el.PopupSiteSearchInstallment;
import th.co.ais.domain.el.PopupSiteSearchPrivate;
import th.co.ais.domain.el.PrivatePrepaid;

public class MeterInstallmentHibernateDAO extends
		AbstractHibernateDAO<MeterInstallment> {
	private static final Logger LOGGER 		= Logger.getLogger(PrepaidPaymentHibernateDAO.class);
	public MeterInstallment findByRowId(final String rowId) throws DAOException {
		getHibernateTemplate().setCacheQueries(true);
		StringBuffer hql = new StringBuffer();
		hql.append("select distinct meterInstallment from MeterInstallment mi");
		hql.append(" where m.rowId = ? ");

		return querySingleByHQL(hql.toString(), rowId);
	}
	
	public PrivatePrepaid findPrivatePrepaidByRowId(final String rowId) throws DAOException {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(PrivatePrepaid.class);
		criteria.add(Restrictions.eq("rowId", rowId));
		List<PrivatePrepaid> privatePrepaidList = criteria.list();
		PrivatePrepaid privatePrepaid = null;
		if(null!=privatePrepaidList && privatePrepaidList.size()>0){
			privatePrepaid = privatePrepaidList.get(0);
		}

		return privatePrepaid;
	}

	@SuppressWarnings("unchecked")
	public List<MeterInstallment> findByContractNo(String contractNo)
			throws DAOException {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(MeterInstallment.class);
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

		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(MeterInstallment.class);
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
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(MeterInstallment.class);
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
	public List<MeterInstallment> findByManagement(ManagementSP manage, boolean isDistinctMeterIdOnly) throws DAOException {

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
		Criteria criteria = session.createCriteria(MeterInstallment.class);
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
			criteria.addOrder(Order.asc("dueDt"));
		}
		return criteria.list();
	}
	@SuppressWarnings("unchecked")
	public List<MeterInstallment> findByMeterId(Management manage, MeterInstallment meterInstallment, boolean isMeterIdOnly) throws DAOException{
		
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
			
			return new ArrayList<MeterInstallment>(0);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<MeterInstallment> findByMeterId(ManagementSP manage, MeterInstallment meterInstallment, boolean isMeterIdOnly) throws DAOException{
		
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
			
			return new ArrayList<MeterInstallment>(0);
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
		//querySingleByHQL(hql.toString(), privatePrepaid.getRowId()); 
	}
	
	@SuppressWarnings("unchecked")
	public List<PopupSiteSearchInstallment> queryByContractNo06ByPL(MeterInstallment meterInstallment) throws DAOException {
		Session session = getSessionFactory().getCurrentSession();
		Query q = session.getNamedQuery("searchInstallment");
		Date fromTermOfPaymentDt = null;
		Date ToTermOfPaymentDt = null;
		try{
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy",	new Locale("th", "TH"));
		String periodTxt = "01"	+ meterInstallment.getFormTermOfPaymentMonth()+ meterInstallment.getFormTermOfPaymentYear();
		fromTermOfPaymentDt = sdf.parse(periodTxt);
		periodTxt = "01" + meterInstallment.getToTermOfPaymentMonth()+ meterInstallment.getToTermOfPaymentYear();
		ToTermOfPaymentDt = sdf.parse(periodTxt);
		
		
		//return q.list();
		}
		catch (Exception e) {
		
		}	
		LOGGER.info("meterInstallment.getCompany():"+meterInstallment.getCompany());
		LOGGER.info("meterInstallment.getRegion().getRowId():"+meterInstallment.getRegion().getRowId());
		LOGGER.info("meterInstallment.getElectricUseType()():"+meterInstallment.getElectricUseType());
		LOGGER.info("fromTermOfPaymentDt:"+meterInstallment.getFormTermOfPaymentDt());
		LOGGER.info("ToTermOfPaymentDt():"+meterInstallment.getToTermOfPaymentDt());
		
		
		q.setString("company", meterInstallment.getCompany());
		q.setString("region",meterInstallment.getRegion().getRowId() );
		q.setString("electricUseType", meterInstallment.getElectricUseType());
		q.setDate("fromDt", meterInstallment.getFormTermOfPaymentDt());
		q.setDate("toDt", meterInstallment.getToTermOfPaymentDt());
		
		return q.list();
	}
}
