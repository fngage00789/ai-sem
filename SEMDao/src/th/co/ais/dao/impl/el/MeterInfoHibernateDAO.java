package th.co.ais.dao.impl.el;

import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.MeterInfo;
import th.co.ais.domain.el.Payment;
import th.co.ais.domain.el.PaymentDetail;

public class MeterInfoHibernateDAO extends AbstractHibernateDAO<MeterInfo>{

	@SuppressWarnings("unchecked")
	public List<MeterInfo> queryByCriteria(MeterInfo meterInfo) throws Exception{
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(MeterInfo.class);
		criteria.createAlias("electricId", "electricIdAlias", CriteriaSpecification.LEFT_JOIN);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		if(meterInfo != null){
			if(StringUtils.isNotEmpty(meterInfo.getElectricId().getRowId())){
				criteria.add(Restrictions.eq("electricIdAlias.rowId", meterInfo.getElectricId().getRowId()));
			}
			if(StringUtils.isNotEmpty(meterInfo.getElectricId().getCompany())){
				criteria.add(Restrictions.eq("electricIdAlias.company", meterInfo.getElectricId().getCompany()));
			}
			if(StringUtils.isNotEmpty(meterInfo.getElectricId().getContractNo())){
				criteria.add(Restrictions.eq("electricIdAlias.contractNo", meterInfo.getElectricId().getContractNo()));
			}
			if(StringUtils.isNotEmpty(meterInfo.getElectricId().getSiteName())){
				criteria.add(Restrictions.eq("electricIdAlias.siteName", meterInfo.getElectricId().getSiteName()));
			}
			if(StringUtils.isNotEmpty(meterInfo.getElectricId().getElectricUseType())
					&& (!"ALL".equalsIgnoreCase(meterInfo.getElectricId().getElectricUseType()))){
				criteria.add(Restrictions.eq("electricIdAlias.electricUseType", meterInfo.getElectricId().getElectricUseType()));
			}else if("ALL".equalsIgnoreCase(meterInfo.getElectricId().getElectricUseType())){
				criteria.add(Restrictions.in("electricIdAlias.electricUseType", new Object[]{"MEA","PRIVATE"}));
			}
			if(StringUtils.isNotEmpty(meterInfo.getElectricId().getLocationId())){
				criteria.add(Restrictions.eq("electricIdAlias.locationId", meterInfo.getElectricId().getLocationId()));
			}
			if(StringUtils.isNotEmpty(meterInfo.getElectricId().getLocationCode())){
				criteria.add(Restrictions.eq("electricIdAlias.locationCode", meterInfo.getElectricId().getLocationCode()));
			}
			if(StringUtils.isNotEmpty(meterInfo.getOneBillFlag())){
				criteria.add(Restrictions.eq("oneBillFlag", meterInfo.getOneBillFlag()));
			}
			if(StringUtils.isNotEmpty(meterInfo.getpMeterOwnerName())){
				criteria.add(Restrictions.eq("pMeterOwnerName", meterInfo.getpMeterOwnerName()));
			}
			if(null != meterInfo.getUploadMeterDtFrom() && null != meterInfo.getUploadMeterDtTo()){
				criteria.add(Restrictions.between("uploadMeterDt", getFromDate(meterInfo.getUploadMeterDtFrom()), getToDate(meterInfo.getUploadMeterDtTo())));
			}
			if(StringUtils.isNotEmpty(meterInfo.getOneBillAddFlag())
					&& (!"ALL".equalsIgnoreCase(meterInfo.getOneBillAddFlag()))){
				criteria.add(Restrictions.eq("oneBillAddFlag", meterInfo.getOneBillAddFlag()));
			}
			//WT###Add 20110124 Start
//			if(null!=meterInfo.geteOneBillDt()){
//				criteria.add(Restrictions.eq("eOneBillDt", meterInfo.geteOneBillDt()));
//			}
			if(null!=meterInfo.geteOneBillDtFrom() && null!=meterInfo.geteOneBillDtTo()){
				criteria.add(Restrictions.between("eOneBillDt", getFromDate(meterInfo.geteOneBillDtFrom()), getToDate(meterInfo.geteOneBillDtTo())));
			}
			//WT###Add 20110124 End
			if(null!=meterInfo.getOutstandingFlag()){
				criteria.add(Restrictions.eq("outstandingFlag", meterInfo.getOutstandingFlag()));
			}
			if(null!=meterInfo.getRecordStatus()){
				criteria.add(Restrictions.eq("recordStatus", meterInfo.getRecordStatus()));
			}
			if(null!=meterInfo.getMeterId()){
				criteria.add(Restrictions.eq("meterId", meterInfo.getMeterId()));
			}
		}
		
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<MeterInfo> findByMeterId(String meterIdIn) throws DAOException {		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(MeterInfo.class);
		criteria.add(Restrictions.eq("meterId", meterIdIn));	
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<MeterInfo> queryByManagement(final Management manage) throws Exception{
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(MeterInfo.class);
		criteria.add(Restrictions.eq("electricId", manage));
		if(manage.getRecordStatus() != null) criteria.add(Restrictions.eq("recordStatus", manage.getRecordStatus()));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		//criteria.addOrder(Order.asc("rowId"));
		criteria.addOrder(Order.desc("createDt"));
		
		return criteria.list();
	}
	
	@SuppressWarnings("deprecation")
	public void updateMeterInfoExport(List<MeterInfo> meterInfoList, String plName) throws Exception{
		Session session = getSessionFactory().getCurrentSession();
		PreparedStatement st;
		plName = plName+"(?)";		
		st = session.connection().prepareStatement("call "+plName+" ");
		Date date = new Date();
		for (MeterInfo obj : meterInfoList) {
			obj.setOneBillAddFlag("Y");
			obj.seteOneBillDt(date);
			obj.setUpdateDt(date);

			session.update(obj);
			//session.flush();

			st.setString(1, obj.getElectricId().getRowId());
			st.execute();
		}
	}
	
	@SuppressWarnings("unchecked")
	public Number countByManage(Management manage) throws Exception{
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(MeterInfo.class);
		criteria.add(Restrictions.eq("electricId", manage));
		criteria.setProjection(Projections.projectionList().add(Projections.count("rowId")));
		
		List<Number> result = criteria.list();
		
		return result != null && result.size() > 0 && result.get(0) != null ? result.get(0) : 0;
	}
	
	public String createMeterInfo(MeterInfo meterInfo){
		return (String) getHibernateTemplate().save(meterInfo);
	}
	
	public void updateMeterInfo(MeterInfo meterInfo){
		getHibernateTemplate().update(meterInfo);
	}
	
	@SuppressWarnings("unchecked")
	public List<MeterInfo> queryMeterListForPayment(MeterInfo meterInfo) throws Exception{
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(MeterInfo.class);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);		
		if(meterInfo != null){
			/*
			if(null!=meterInfo.getOutstandingFlag()){
				criteria.add(Restrictions.eq("outstandingFlag", meterInfo.getOutstandingFlag()));
			}
			if(null!=meterInfo.getRecordStatus()){
				criteria.add(Restrictions.eq("recordStatus", meterInfo.getRecordStatus()));
			}

			*/
			Criterion outstandingEqual =  Restrictions.eq("outstandingFlag", meterInfo.getOutstandingFlag());
			Criterion recordStatusEqual = Restrictions.eq("recordStatus",meterInfo.getRecordStatus());
			LogicalExpression orExp = Restrictions.or(outstandingEqual, recordStatusEqual);
			if(meterInfo.isOrderForSelectMeterId()){
				criteria.addOrder(Order.asc("order1"));
				criteria.addOrder(Order.asc("referMeterId"));
				criteria.addOrder(Order.asc("order2"));
			}
			criteria.add(orExp);
			if(null!=meterInfo.getElectricId()){
				criteria.add(Restrictions.eq("electricId", meterInfo.getElectricId()));
			}
			
			
		}		
		return criteria.list();
	}
	
	
	public MeterInfo findByRowId(final String rowId) throws DAOException{
		
		getHibernateTemplate().setCacheQueries(true);
		
		return querySingleByHQL("select distinct meter from MeterInfo meter where meter.rowId = ? ", rowId);
	}
	
	private Date getFromDate(Date date){
		
		Calendar fromDate = Calendar.getInstance();
		fromDate.setTime(date);
		fromDate.set(Calendar.HOUR_OF_DAY, 0);
		fromDate.set(Calendar.MINUTE, 0);
		fromDate.set(Calendar.SECOND, 0);
		//WT###Edit 20101223 Start
		//fromDate.set(Calendar.MILLISECOND, 1);
		fromDate.set(Calendar.MILLISECOND, 0);
		//WT###Edit 20101223 End
		return fromDate.getTime();
	}
	
	private Date getToDate(Date date){
		
		Calendar toDate = Calendar.getInstance();
		toDate.setTime(date);
		toDate.set(Calendar.HOUR_OF_DAY, 23);
		toDate.set(Calendar.MINUTE, 59);
		toDate.set(Calendar.SECOND, 59);
		toDate.set(Calendar.MILLISECOND, 59);
		return toDate.getTime();
	}
	
	@SuppressWarnings("unchecked")
	public List<MeterInfo> queryMeterListByPayment(Payment payment,PaymentDetail paymentDetail) throws DAOException {		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(MeterInfo.class);
		criteria.createAlias("electricId", "e");
		//criteria.add(Restrictions.eq("recordStatus","Y"));
		criteria.add(Restrictions.eq("meterId", paymentDetail.getMeterId()));
		criteria.add(Restrictions.eq("e.company", payment.getCompany()));
		criteria.add(Restrictions.eq("electricUseType", payment.getElectricUseType()));
		
		if(StringUtils.isNotEmpty(paymentDetail.getInvAreaCode())){
			criteria.add(Restrictions.eq("eAreaCode", paymentDetail.getInvAreaCode()));
		}
		return criteria.list();
	}
	@SuppressWarnings("unchecked")
	public List<MeterInfo> queryMeterListForUpdateInstalment(MeterInfo meterInfo) throws Exception{
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(MeterInfo.class);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);		
		if(meterInfo != null){
			if(null!=meterInfo.getElectricId()){
				criteria.add(Restrictions.eq("electricId", meterInfo.getElectricId()));
			}		
			
		}		
		criteria.addOrder(Order.desc("recordStatus"));
		return criteria.list();
	}
}
