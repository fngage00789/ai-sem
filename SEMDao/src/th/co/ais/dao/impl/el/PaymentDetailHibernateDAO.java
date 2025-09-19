package th.co.ais.dao.impl.el;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
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
import th.co.ais.domain.el.WarrantDatail;
import th.co.ais.util.BeanUtils;

public class PaymentDetailHibernateDAO extends AbstractHibernateDAO<PaymentDetail> {
	
	public boolean saveOrUpdatePaymentDetail(PaymentDetail electricPayment) throws DAOException{
		
		saveOrUpdate(electricPayment);
		
		return true;
	}
	
	public boolean saveOrUpdatePaymentDetail(List<PaymentDetail> electricPaymentList) throws DAOException{
		
		saveOrUpdateAll((Collection<PaymentDetail>)electricPaymentList);
		
		return true;
	}
	
	public List<PaymentDetail> getPaymentDetailByPayment(Payment payment)throws DAOException{
		Session session = getSessionFactory().getCurrentSession();		
		Criteria criteria = session.createCriteria(PaymentDetail.class);
		//logger.debug(" ---- queryByCriteria  payment :"+BeanUtils.getBeanString(payment) );
		criteria.add(Restrictions.eq("paymentId", payment));
		criteria.add(Restrictions.eq("recordStatus", "Y"));
		criteria.addOrder( Order.desc("termOfPaymentDt"));          

		return criteria.list();
	}
	
	public PaymentDetail findByMeterInfoAndMaxToTermOfPayment(MeterInfo meterInfo) throws Exception{
		
		Date maxDate = findMaxToTermOfPaymentDt(meterInfo);
		
		Session session = getSessionFactory().getCurrentSession();
		
		Criteria criteria = session.createCriteria(PaymentDetail.class);
		
		//criteria = criteria.createCriteria("meterInfos");
		if(meterInfo != null){
			
			Criterion meterIdExp = null;
	        Criterion refMeterIdExp = null;
			
			if(StringUtils.isNotEmpty(meterInfo.getMeterId())){
				
				meterIdExp = Restrictions.eq("meterId", meterInfo.getMeterId());
			}
			
			if(StringUtils.isNotEmpty(meterInfo.getReferMeterId())){
				
				refMeterIdExp = Restrictions.eq("referMeterId", meterInfo.getReferMeterId());
			}
			
			if(meterIdExp != null && refMeterIdExp != null){
				
				criteria.add(Restrictions.or(meterIdExp,refMeterIdExp));
				
			}else{
				
				if(meterIdExp != null) criteria.add(meterIdExp);
				if(refMeterIdExp != null) criteria.add(refMeterIdExp);
			}
			
			if(maxDate != null){
				
				Criterion between = Restrictions.between("toTermOfPaymentDt", getFromDate(maxDate), getToDate(maxDate));
				Criterion equal = Restrictions.eq("toTermOfPaymentDt", maxDate);
				
				LogicalExpression orExp = Restrictions.or(between, equal);
				
				criteria.add(orExp);
			}
		}
		
		List<PaymentDetail> result = criteria.list();
		
		return result != null && result.size() > 0 ? result.get(0) : null;
	}
	
	private Date getFromDate(Date date){
		
		Calendar fromDate = Calendar.getInstance();
		fromDate.setTime(date);
		fromDate.set(Calendar.HOUR_OF_DAY, 0);
		fromDate.set(Calendar.MINUTE, 0);
		fromDate.set(Calendar.SECOND, 0);
		fromDate.set(Calendar.MILLISECOND, 1);
		
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
	public Date findMaxToTermOfPaymentDt(MeterInfo meterInfo) throws Exception{
		
		Session session = getSessionFactory().getCurrentSession();
		
		Criteria criteria = session.createCriteria(PaymentDetail.class);
		
		//criteria = criteria.createCriteria("meterInfos");
		if(meterInfo != null){
			
			Criterion meterIdExp = null;
	        Criterion refMeterIdExp = null;
			
			if(StringUtils.isNotEmpty(meterInfo.getMeterId())){
				
				meterIdExp = Restrictions.eq("meterId", meterInfo.getMeterId());
			}
			
			if(StringUtils.isNotEmpty(meterInfo.getReferMeterId())){
				
				refMeterIdExp = Restrictions.eq("referMeterId", meterInfo.getReferMeterId());
			}
			
			if(meterIdExp != null && refMeterIdExp != null){
				
				criteria.add(Restrictions.or(meterIdExp,refMeterIdExp));
				
			}else{
				
				if(meterIdExp != null) criteria.add(meterIdExp);
				if(refMeterIdExp != null) criteria.add(refMeterIdExp);
			}
			
			criteria.setProjection(Projections.projectionList().add(Projections.max("toTermOfPaymentDt")));
			
			List<Date> result = criteria.list();
			
			return result != null && result.size() > 0 ? result.get(0) : null;
		}
		
		return null;
	}
}
