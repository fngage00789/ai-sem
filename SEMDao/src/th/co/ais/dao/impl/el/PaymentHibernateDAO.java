package th.co.ais.dao.impl.el;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.el.InstallmentDataDetail;
import th.co.ais.domain.el.InstallmentSearch7;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.MeterInstallment;
import th.co.ais.domain.el.Payment;
import th.co.ais.domain.el.PaymentDetail;
import th.co.ais.domain.el.PaymentSearch;
import th.co.ais.domain.el.PopupOldDocSearch;
import th.co.ais.domain.el.PopupOldDocSearch7;
import th.co.ais.domain.el.PopupSiteSearch;
import th.co.ais.domain.el.PopupSiteSearch7;
import th.co.ais.util.BeanUtils;

public class PaymentHibernateDAO extends AbstractHibernateDAO<Payment> {

	Logger logger = Logger.getLogger(PaymentHibernateDAO.class);
	
	public List<Payment> queryPaymentByCriteria(Payment payment,
			PaymentDetail paymentDetail) throws DAOException {
		// logger.debug(" ---- queryPaymentByCriteria ---" );
		return null;
	}

	public String saveReturnId(Payment payment) {
		return (String) getHibernateTemplate().save(payment);
	}

	@SuppressWarnings("unchecked")
	public List<Payment> queryByCriteria(Payment payment) throws DAOException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Payment.class);
		//logger.debug(" ---- queryByCriteria  payment :"+ BeanUtils.getBeanString(payment));
		criteria.add(Restrictions.eq("company", payment.getCompany()));
		criteria.add(Restrictions.eq("electricUseType", payment
				.getElectricUseType()));
		criteria.add(Restrictions.eq("docNo", payment.getDocNo()));
		criteria.add(Restrictions.eq("recordStatus", "Y"));
		criteria.add(Restrictions.eq("expenseType", "EL_BILL"));

		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Payment> queryByCriteriaEL_BILL(PaymentSearch paymentSearch) throws DAOException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Payment.class);
		//logger.debug(" ---- queryByCriteria  paymentSearch :"	+ BeanUtils.getBeanString(paymentSearch));
		criteria.createAlias("meterInfo", "meterInfo", criteria.LEFT_JOIN);
		
		if (StringUtils.isNotEmpty(paymentSearch.getCompany())){
			criteria.add(Restrictions.eq("company", paymentSearch.getCompany()));	
		}
		if (StringUtils.isNotEmpty(paymentSearch.getContractNo())){
			criteria.add(Restrictions.like("contractNo", "%"	+ paymentSearch.getContractNo().toUpperCase() + "%"));
		}		
		if (StringUtils.isNotEmpty(paymentSearch.getSiteName())){
			criteria.add(Restrictions.like("siteName", "%"	+ paymentSearch.getSiteName() + "%"));
		}

		if (StringUtils.isNotEmpty(paymentSearch.getElectricUseType())){
			criteria.add(Restrictions.eq("electricUseType", paymentSearch.getElectricUseType()));	
		}
		if (StringUtils.isNotEmpty(paymentSearch.getElectricUseType())){
			criteria.add(Restrictions.eq("expenseType", paymentSearch.getExpenseType()));	
		}
		if (StringUtils.isNotEmpty(paymentSearch.getRegion())){
			criteria.add(Restrictions.eq("region", paymentSearch.getRegion()));	
		}
		if (StringUtils.isNotEmpty(paymentSearch.getLocationId())){
			criteria.add(Restrictions.like("locationId", "%"	+ paymentSearch.getLocationId() + "%"));
		}
		if (StringUtils.isNotEmpty(paymentSearch.getLocationCode())){
			criteria.add(Restrictions.like("locationCode", "%"	+ paymentSearch.getLocationCode() + "%"));
		}
		if("Y".equals(paymentSearch.getSiteType())){ 
			criteria.add(Restrictions.eq("siteType", "02"));			 
		}
		
		//criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return criteria.list();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Payment> queryByCriteria4Popup(Payment payment)
			throws DAOException {
		//System.out.println("WT###Print queryByCriteria4Popup="+ BeanUtils.getBeanString(payment));
		boolean  fromTermOfPaymentDt = false;
		boolean  toTermOfPaymentDt   = false;
		
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Payment.class);
		
		criteria.add(Restrictions.eq("company",payment.getCompany()));
		criteria.add(Restrictions.eq("electricUseType",payment.getElectricUseType()));
		
		
		if (StringUtils.isNotEmpty(payment.getDocNo())) {
			criteria.add(Restrictions.like("docNo", "%" + payment.getDocNo()
					+ "%"));
		}
		
		if (StringUtils.isNotEmpty(payment.getExpenseType()))
			criteria.add(Restrictions.eq("expenseType", payment
					.getExpenseType()));
		
		if (StringUtils.isNotEmpty(payment.getRecordStatus()))
			criteria.add(Restrictions.eq("recordStatus", payment
					.getRecordStatus()));
		
		if (payment.getDocDtFrom() != null){
			fromTermOfPaymentDt = true;
		}
		if (payment.getDocDtTo() != null){
			toTermOfPaymentDt = true;
		}	
		
		
		if(fromTermOfPaymentDt && toTermOfPaymentDt ){
			
			criteria.add(Restrictions.and(
					//Restrictions.sqlRestriction("trunc(DOC_DT) >= trunc(?)",payment.getDocDtFrom(),Hibernate.DATE),
					//Restrictions.sqlRestriction("trunc(DOC_DT) <= trunc(?)",payment.getDocDtTo(),Hibernate.DATE)
					Restrictions.sqlRestriction("cast(DOC_DT as date) >= cast(? as date)",payment.getDocDtFrom(),Hibernate.DATE),
					Restrictions.sqlRestriction("cast(DOC_DT as date) <= cast(? as date)",payment.getDocDtTo(),Hibernate.DATE)
					));
			
		}else if(fromTermOfPaymentDt && !toTermOfPaymentDt){
			
			//criteria.add(Restrictions.sqlRestriction("trunc(DOC_DT) >= trunc(?)",payment.getDocDtFrom(),Hibernate.DATE));
			criteria.add(Restrictions.sqlRestriction("cast(DOC_DT as date) >= cast(? as date)",payment.getDocDtFrom(),Hibernate.DATE));
			
		}else if(!fromTermOfPaymentDt && toTermOfPaymentDt){
			//criteria.add(Restrictions.sqlRestriction("trunc(DOC_DT) <= trunc(?)",payment.getDocDtTo(),Hibernate.DATE));
			criteria.add(Restrictions.sqlRestriction("cast(DOC_DT as date) <= cast(? as date)",payment.getDocDtTo(),Hibernate.DATE));
			//Hibernate.DATE;
		}
		
		criteria.addOrder(Order.desc("docDt"));
		
		return criteria.list();
	}

	public List<PaymentSearch> searchPayment(PaymentSearch searchPayment)
			throws DAOException {
		// logger.debug(" ---- searchPayment ---" );
		Session session = getSessionFactory().getCurrentSession();
		logger.debug(" ---- searchPayment ---");
		/*
		String expenseTypeStr = "";
		if("EL_POSTPAID".equalsIgnoreCase(searchPayment.getExpenseType())){			
			expenseTypeStr ="('EL_POSTPAID', 'EL_DEBIT' , 'EL_CREDIT')";
		}else{
			expenseTypeStr = "('"+searchPayment.getExpenseType()+"')";
		}		
		System.out.println(" expenseTypeStr:"+expenseTypeStr);
		*/
		
		//logger.debug("WT### searchPayment="+BeanUtils.getBeanString(searchPayment));
		Query q = session.getNamedQuery("searchPaymentHistory");
		q.setString("company", searchPayment.getCompany());
		if(searchPayment.getContractNo()==null){
			q.setString("contractNo", searchPayment.getContractNo());
		}else{
			q.setString("contractNo", searchPayment.getContractNo().toUpperCase());
		}
		
		q.setString("siteName", searchPayment.getSiteName());
		q.setString("electricUseType", searchPayment.getElectricUseType());
		q.setString("region", searchPayment.getRegion());
		q.setString("locationId", searchPayment.getLocationId());
		q.setString("locationCode", searchPayment.getLocationCode());
		
		if("Y".equals(searchPayment.getSiteType())){
			q.setString("siteType", "02");
		}else{
			q.setString("siteType", null);
		}		
		
		//q.setString("expenseType", expenseTypeStr);
		q.setString("expenseType", searchPayment.getExpenseType());
		q.setString("meterId", searchPayment.getMeterId());
		q.setDate("fromTermOfPaymentDt", searchPayment.getFromTermOfPaymentDt());
		q.setDate("toTermOfPaymentDt", searchPayment.getToTermOfPaymentDt());
		// q.setString("docNo", searchPayment.getDocNo());
		List<PaymentSearch> returnList = q.list();
		System.out.println(" returnList:" + returnList);
		return returnList;

	}

	public List<PopupSiteSearch> searchSite(PopupSiteSearch searchSite,
			String nameQueryStr) throws DAOException {
		System.out.println(" ---- searchSite nameQueryStr:" + nameQueryStr);
		Session session = getSessionFactory().getCurrentSession();
		Query q = session.getNamedQuery(nameQueryStr);
		//System.out.println(" searchSite:" + BeanUtils.getBeanString(searchSite));
		if ("querySiteEL".equals(nameQueryStr)) {
			if(searchSite.getContractNo()==null){
				q.setString("contractNo", searchSite.getContractNo());
			}else{
				q.setString("contractNo", searchSite.getContractNo().toUpperCase());
			}
			
			q.setString("meterId", searchSite.getMeterId());
		} else if ("querySiteELPostpaid".equals(nameQueryStr)) {
			if(searchSite.getContractNo()==null){
				q.setString("contractNo", searchSite.getContractNo());
			}else{
				q.setString("contractNo", searchSite.getContractNo().toUpperCase());
			}
			
			q.setString("meterId", searchSite.getMeterId());
			if (!"All".equals(searchSite.getOutstandingFlag())) {
				q.setString("outstandingFlag", searchSite.getOutstandingFlag());
			} else {
				q.setString("outstandingFlag", null);
			}
		} else if ("querySiteELTmp".equals(nameQueryStr)) {
			if(searchSite.getContractNo()==null){
				q.setString("contractNo", searchSite.getContractNo());
			}else{
				q.setString("contractNo", searchSite.getContractNo().toUpperCase());
			}
		} else if ("querySiteELPrepaid".equals(nameQueryStr)) {
			if(searchSite.getContractNo()==null){
				q.setString("contractNo", searchSite.getContractNo());
			}else{
				q.setString("contractNo", searchSite.getContractNo().toUpperCase());
			}
			
		} else if ("querySiteELPR".equals(nameQueryStr)) {
			if(searchSite.getContractNo()==null){
				q.setString("contractNo", searchSite.getContractNo());
			}else{
				q.setString("contractNo", searchSite.getContractNo().toUpperCase());
			}
			
		}else if ("querySiteELTemp".equals(nameQueryStr)) {
			if(searchSite.getContractNo()==null){
				q.setString("contractNo", searchSite.getContractNo());
			}else{
				q.setString("contractNo", searchSite.getContractNo().toUpperCase());
			}
			
			q.setString("company", searchSite.getCompany());
			q.setString("meterId", searchSite.getMeterId());
			q.setString("siteName", searchSite.getSiteName());
			q.setString("vendorName", searchSite.getVendorName());
			q.setString("vendorAddress", searchSite.getVendorAddress());
			q.setString("payeeName", searchSite.getPayeeName());
			q.setString("payeeAddress", searchSite.getPayeeAddress());
			
			q.setString("region", searchSite.getRegion());
			q.setString("vendorId", searchSite.getVendorId());
//			q.setString("meterID", searchSite.getMeterID());
			q.setString("pRead", searchSite.getpRead());
			if (!"All".equals(searchSite.getOutstandingFlag())) {
				q.setString("outstandingFlag", searchSite.getOutstandingFlag());
			} else {
				q.setString("outstandingFlag", null);
			}
		} else {
			return null;
		}
		List<PopupSiteSearch> returnList = q.list();
		return returnList;
	}

	public List<PopupOldDocSearch> searchOldDoc(PopupOldDocSearch searchOldDoc)
			throws DAOException {
		logger.debug(" ---- searchSite ---");
		Session session = getSessionFactory().getCurrentSession();
		Query q = session.getNamedQuery("querySearchELOldDoc");
		System.out.println(" q:" + q);
		//System.out.println(" searchOldDoc:"+ BeanUtils.getBeanString(searchOldDoc));
		q.setString("docNo", searchOldDoc.getDocNo());
		q.setDate("fromDocDt", searchOldDoc.getFromDocDt());
		q.setDate("toDocDt", searchOldDoc.getToDocDt());
		List<PopupOldDocSearch> returnList = q.list();
		System.out.println(" returnList:" + returnList);
		return returnList;
	}

	public boolean saveOrUpdateElectricPayment(List<Payment> electricPaymentList)
			throws DAOException {
		//System.out.println(" electricPaymentList:"+ BeanUtils.getBeanString(electricPaymentList));
		saveOrUpdateAll((Collection<Payment>) electricPaymentList);
		return true;
	}

	public boolean saveOrUpdateElectricPayment(Payment payment)
			throws DAOException {
		//saveOrUpdate(payment); ---> remove for modify support Postgresql 
		saveOrUpdate("Payment",payment);
		
		return true;
	}

	@SuppressWarnings( { "unchecked", "rawtypes" })
	public List<Payment> querySEMMEL008ByCriteria(Payment payment)
			throws DAOException {

		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(Payment.class);

		if (payment != null) {
			
			if (StringUtils.isNotEmpty(payment.getCompany())){
				criteria.add(Restrictions.eq("company", payment.getCompany()));
				
			}
			if (StringUtils.isNotEmpty(payment.getContractNo())){
				//criteria.add(Restrictions.like("contractNo", "%"
				//		+ payment.getContractNo().toUpperCase() + "%"));
				//criteria.add(Restrictions.eq("contractNo",payment.getContractNo().toUpperCase()));
				criteria.add(Restrictions.like("contractNo",payment.getContractNo().toUpperCase().replace("*", "%") ));
			}
			if (StringUtils.isNotEmpty(payment.getSiteName())){
				criteria.add(Restrictions.like("siteName", "%"
						+ payment.getSiteName() + "%"));
				}
			if (StringUtils.isNotEmpty(payment.getElectricUseType())){
				criteria.add(Restrictions.eq("electricUseType", payment
						.getElectricUseType()));
			}
			if (StringUtils.isNotEmpty(payment.getRegion())){
				criteria.add(Restrictions.eq("region", payment.getRegion()));
			}
			if (StringUtils.isNotEmpty(payment.getVendorId())){
				criteria.add(Restrictions.like("vendorId", "%"
						+ payment.getVendorId() + "%"));
			}
			
			if (StringUtils.isNotEmpty(payment.getVendorName())){
				criteria.add(Restrictions.like("vendorName",payment.getVendorName().replace("*", "%") ));
			}
				
			
			
			if (StringUtils.isNotEmpty(payment.getExpenseType())){
				criteria.add(Restrictions.eq("expenseType", payment
						.getExpenseType()));
			}
			if (StringUtils.isNotEmpty(payment.getPaymentStatus())){
				criteria.add(Restrictions.eq("paymentStatus", payment
						.getPaymentStatus()));
			}
			if (StringUtils.isNotEmpty(payment.getPaymentType())){
				criteria.add(Restrictions.eq("paymentType", payment
						.getPaymentType()));
			}
			if (StringUtils.isNotEmpty(payment.getCreateBy())){
				criteria.add(Restrictions.like("createBy", "%"
						+ payment.getCreateBy() + "%"));
			}
			if (StringUtils.isNotEmpty(payment.getBatchNo())){
				criteria.add(Restrictions.like("batchNo", "%"
						+ payment.getBatchNo() + "%"));
			}
			if (StringUtils.isNotEmpty(payment.getPayeeName())){
				//criteria.add(Restrictions.like("payeeName", "%"+ payment.getPayeeName() + "%"));
				criteria.add(Restrictions.like("payeeName",payment.getPayeeName().replace("*", "%")));
			}
			
			if (StringUtils.isNotEmpty(payment.getDocNo())){
				criteria.add(Restrictions.like("docNo", "%"
						+ payment.getDocNo() + "%"));
			}
			
			// if(StringUtils.isNotEmpty(payment.getSiteType()) &&
			// payment.getSiteType().equals("Y")){
			//				
			// criteria.add(Restrictions.eq("electricId.siteType",
			// payment.getSiteType()));
			// criteria.add(Restrictions.eq("electricId.recordStatus", "Y"));
			// }

			// date
			if (payment.getTransferDt() != null) {

				Criterion between = Restrictions.between("transferDt",
						getFromDate(payment.getTransferDt()), getToDate(payment
								.getTransferDt()));
				Criterion equal = Restrictions.eq("transferDt", payment
						.getTransferDt());

				LogicalExpression orExp = Restrictions.or(between, equal);
				criteria.add(orExp);
			}

			if (payment.getChqPostingDt() != null) {

				Criterion between = Restrictions.between("chqPostingDt",
						getFromDate(payment.getChqPostingDt()),
						getToDate(payment.getChqPostingDt()));
				Criterion equal = Restrictions.eq("chqPostingDt", payment
						.getChqPostingDt());

				LogicalExpression orExp = Restrictions.or(between, equal);
				criteria.add(orExp);
			}

			if (payment.getChqReceivedDt() != null) {

				Criterion between = Restrictions.between("chqReceivedDt",
						getFromDate(payment.getChqReceivedDt()),
						getToDate(payment.getChqReceivedDt()));
				Criterion equal = Restrictions.eq("chqReceivedDt", payment
						.getChqReceivedDt());

				LogicalExpression orExp = Restrictions.or(between, equal);
				criteria.add(orExp);
			}

			if (payment.getCreateDt() != null) {

				Criterion between = Restrictions.between("createDt",
						getFromDate(payment.getCreateDt()), getToDate(payment
								.getCreateDt()));
				Criterion equal = Restrictions.eq("createDt", payment
						.getCreateDt());

				LogicalExpression orExp = Restrictions.or(between, equal);
				criteria.add(orExp);
			}

			if (payment.getSentPaymentDt() != null) {

				Criterion between = Restrictions.between("sentPaymentDt",
						getFromDate(payment.getSentPaymentDt()),
						getToDate(payment.getSentPaymentDt()));
				Criterion equal = Restrictions.eq("sentPaymentDt", payment
						.getSentPaymentDt());

				LogicalExpression orExp = Restrictions.or(between, equal);
				criteria.add(orExp);
			}
		}
        
		if (StringUtils.isNotEmpty(payment.getDoc68())){
			criteria.add(Restrictions.like("doc68",payment.getDoc68().replace("*", "%") ));
		}
			
		
		if (StringUtils.isNotEmpty(payment.getDoc92())){
			criteria.add(Restrictions.like("doc92",payment.getDoc92().replace("*", "%") ));
		}
			
		if (StringUtils.isNotEmpty(payment.getChqNo())){
			criteria.add(Restrictions.like("chqNo",payment.getChqNo().replace("*", "%")));
			//criteria.add(Restrictions.ilike("chqNo", payment.getChqNo().trim() )); 
		}
		
		
		criteria.add(Restrictions.eq("recordStatus", "Y"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		//criteria.addOrder(Order.asc("rowId"));
		if(payment!=null){
			if (payment.getOrderBy()!=null && !"".equals(payment.getOrderBy())) {
				criteria.addOrder(Order.asc(payment.getOrderBy()));
			}else{
				criteria.addOrder(Order.desc("createDt"));
				//criteria.addOrder(Order.desc("details.fromTermOfPaymentDt"));
				
				//criteria.addOrder(Order.desc("createBy"));
			}
		}else{
			criteria.addOrder(Order.desc("createDt"));
			//criteria.addOrder(Order.asc("createBy"));
		}
		
		

		logger.info(" SQL :::: "+criteria.toString());
		
		List resultList = criteria.setMaxResults(500).list();

		// filter picoCell (- -")
		if (StringUtils.isNotEmpty(payment.getSiteType())
				&& payment.getSiteType().equals("Y")) {

			for (int i = resultList.size() - 1; i > -1; i--) {

				payment = (Payment) resultList.get(i);
				Management manage = payment.getElectricId();

				if (manage == null) {

					resultList.remove(i);

					continue;
				}

				if (manage.getRecordStatus() == null
						|| manage.getRecordStatus().equals("N")) {

					resultList.remove(i);

					continue;
				}

				if (manage.getSiteType() == null
						|| !manage.getSiteType().equals("02")) {

					resultList.remove(i);

					continue;
				}
			}
		}

		return resultList;
	}

	private Date getFromDate(Date date) {

		Calendar fromDate = Calendar.getInstance();
		fromDate.setTime(date);
		fromDate.set(Calendar.HOUR_OF_DAY, 0);
		fromDate.set(Calendar.MINUTE, 0);
		fromDate.set(Calendar.SECOND, 0);
		fromDate.set(Calendar.MILLISECOND, 1);

		return fromDate.getTime();
	}

	private Date getToDate(Date date) {

		Calendar toDate = Calendar.getInstance();
		toDate.setTime(date);
		toDate.set(Calendar.HOUR_OF_DAY, 23);
		toDate.set(Calendar.MINUTE, 59);
		toDate.set(Calendar.SECOND, 59);
		toDate.set(Calendar.MILLISECOND, 59);

		return toDate.getTime();
	}

	@SuppressWarnings("unchecked")
	public Object countPaymentByStatus(String status) throws DAOException {

		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(Payment.class);
		criteria.add(Restrictions.eq("paymentStatus", status));
		criteria.setProjection(Projections.projectionList().add(
				Projections.count("paymentStatus")).add(
				Projections.groupProperty("paymentStatus")));

		List<Object[]> list = criteria.list();

		if (list.size() > 0) {

			return list.get(0)[0];
		}

		return null;
	}
	
	@SuppressWarnings("unchecked")
	public Object countPaymentByCriteria(Payment payment) throws DAOException {

		if(payment==null){
			return null;
		}
		
		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(Payment.class);		
		if (payment != null) {

			if (StringUtils.isNotEmpty(payment.getCompany()))
				criteria.add(Restrictions.eq("company", payment.getCompany()));
			if (StringUtils.isNotEmpty(payment.getContractNo()))
				criteria.add(Restrictions.like("contractNo", "%"
						+ payment.getContractNo().toUpperCase() + "%"));
			if (StringUtils.isNotEmpty(payment.getSiteName()))
				criteria.add(Restrictions.like("siteName", "%"
						+ payment.getSiteName() + "%"));
			if (StringUtils.isNotEmpty(payment.getElectricUseType()))
				criteria.add(Restrictions.eq("electricUseType", payment
						.getElectricUseType()));
			if (StringUtils.isNotEmpty(payment.getRegion()))
				criteria.add(Restrictions.eq("region", payment.getRegion()));
			if (StringUtils.isNotEmpty(payment.getVendorId()))
				criteria.add(Restrictions.like("vendorId", "%"
						+ payment.getVendorId() + "%"));
			if (StringUtils.isNotEmpty(payment.getVendorName()))
				criteria.add(Restrictions.like("vendorName", "%"
						+ payment.getVendorName() + "%"));
			if (StringUtils.isNotEmpty(payment.getExpenseType()))
				criteria.add(Restrictions.eq("expenseType", payment
						.getExpenseType()));
			if (StringUtils.isNotEmpty(payment.getPaymentStatus())){
				criteria.add(Restrictions.eq("paymentStatus", payment.getPaymentStatus()));
				criteria.setProjection(Projections.projectionList().add(
					Projections.count("paymentStatus")).add(
					Projections.groupProperty("paymentStatus")));
//				criteria.add(Restrictions.eq("paymentStatus", payment
//						.getPaymentStatus()));
			}
			if (StringUtils.isNotEmpty(payment.getPaymentType()))
				criteria.add(Restrictions.eq("paymentType", payment
						.getPaymentType()));
			if (StringUtils.isNotEmpty(payment.getCreateBy()))
				criteria.add(Restrictions.like("createBy", "%"
						+ payment.getCreateBy() + "%"));
			if (StringUtils.isNotEmpty(payment.getBatchNo()))
				criteria.add(Restrictions.like("batchNo", "%"
						+ payment.getBatchNo() + "%"));
			if (StringUtils.isNotEmpty(payment.getPayeeName()))
				criteria.add(Restrictions.like("payeeName", "%"
						+ payment.getPayeeName() + "%"));

			// date
			if (payment.getTransferDt() != null) {

				Criterion between = Restrictions.between("transferDt",
						getFromDate(payment.getTransferDt()), getToDate(payment
								.getTransferDt()));
				Criterion equal = Restrictions.eq("transferDt", payment
						.getTransferDt());

				LogicalExpression orExp = Restrictions.or(between, equal);
				criteria.add(orExp);
			}

			if (payment.getChqPostingDt() != null) {

				Criterion between = Restrictions.between("chqPostingDt",
						getFromDate(payment.getChqPostingDt()),
						getToDate(payment.getChqPostingDt()));
				Criterion equal = Restrictions.eq("chqPostingDt", payment
						.getChqPostingDt());

				LogicalExpression orExp = Restrictions.or(between, equal);
				criteria.add(orExp);
			}

			if (payment.getChqReceivedDt() != null) {

				Criterion between = Restrictions.between("chqReceivedDt",
						getFromDate(payment.getChqReceivedDt()),
						getToDate(payment.getChqReceivedDt()));
				Criterion equal = Restrictions.eq("chqReceivedDt", payment
						.getChqReceivedDt());

				LogicalExpression orExp = Restrictions.or(between, equal);
				criteria.add(orExp);
			}

			if (payment.getCreateDt() != null) {

				Criterion between = Restrictions.between("createDt",
						getFromDate(payment.getCreateDt()), getToDate(payment
								.getCreateDt()));
				Criterion equal = Restrictions.eq("createDt", payment
						.getCreateDt());

				LogicalExpression orExp = Restrictions.or(between, equal);
				criteria.add(orExp);
			}

			if (payment.getSentPaymentDt() != null) {

				Criterion between = Restrictions.between("sentPaymentDt",
						getFromDate(payment.getSentPaymentDt()),
						getToDate(payment.getSentPaymentDt()));
				Criterion equal = Restrictions.eq("sentPaymentDt", payment
						.getSentPaymentDt());

				LogicalExpression orExp = Restrictions.or(between, equal);
				criteria.add(orExp);
			}
			if (StringUtils.isNotEmpty(payment.getRecordStatus()))
				criteria.add(Restrictions.eq("recordStatus", payment.getRecordStatus()));
		}

		List<Object[]> list = criteria.list();

		if (list.size() > 0) {

			return list.get(0)[0];
		}

		return null;
	}

	public Payment findByRowId(final String rowId) throws DAOException {

		getHibernateTemplate().setCacheQueries(true);
		Payment pamentreturn = querySingleByHQL(
				"select distinct payment from Payment payment where payment.rowId = ? ",
				rowId);
		if (pamentreturn.getDetails() != null) {
			pamentreturn.getDetails().size();
		}

		return pamentreturn;
	}
	
	//WT###Add 20110125 Start
	public Payment findByRowIdFilterDetail(String rowId) throws DAOException {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Payment.class);		
		criteria.createAlias("details", "detailsAlias", Criteria.LEFT_JOIN);
		criteria.add(Restrictions.eq("rowId", rowId));
		criteria.add(Restrictions.eq("detailsAlias.recordStatus", "Y"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		List<Payment> paymentList = criteria.list();
		Payment paymentReturn = null;
		if(paymentList!=null && paymentList.size()>0){
			paymentReturn = paymentList.get(0);
		}

		return paymentReturn;
	}
	//WT###ADd 20110125 End

	public List<PaymentSearch> searchDuplicatePayment(Payment payment)
			throws DAOException {
		logger.debug(" ---- searchDuplicatePayment ---");
		Session session = getSessionFactory().getCurrentSession();
		Query q = session.getNamedQuery("searchPaymentHistory");

		q.setString("company", payment.getCompany());
		q.setString("electricUseType", payment.getElectricUseType());
		q.setString("docNo", payment.getDocNo());
		;
		List<PaymentSearch> returnList = q.list();
		System.out.println(" returnList:" + returnList);
		return returnList;
	}
	public String savePaymentReturnId(Payment payment,	List<PaymentDetail> paymentDetailList){
		for(PaymentDetail tmp:paymentDetailList){		
			tmp.setPaymentId(payment);
		}
		Set<PaymentDetail> temp = new HashSet<PaymentDetail>();
		temp.addAll(paymentDetailList);
		payment.setDetails(temp);
		payment = getHibernateTemplate().merge(payment);
		String key = payment.getRowId();
		System.out.println(" key:"+ key);
		return key;
		
	

	}
	
	public List<Payment> findByCriteria(String conTractNo){
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Payment.class);
		if(conTractNo==null){
			criteria.add(Restrictions.like("contractNo", conTractNo));
		}else{
			criteria.add(Restrictions.like("contractNo", conTractNo.toUpperCase()));
		}		
		
		return criteria.list();
	}
	
	public List<PopupSiteSearch7> searchSite7(PopupSiteSearch7 searchSite,
			String nameQueryStr) throws DAOException {
		System.out.println(" ---- searchSite7 nameQueryStr:" + nameQueryStr);
		Session session = getSessionFactory().getCurrentSession();
		Query q = session.getNamedQuery(nameQueryStr);
		
		//query="call SEM.SP_CR_SITE_SRCH(?,:company, :contractNo, :siteName, :vendorCode, :vendorName, :vendorAddress, :payeeName, :payeeAddress, :meterId)",      

		q.setString("company", searchSite.getCompany());
		
		if(searchSite.getContractNo()==null){
			q.setString("contractNo", searchSite.getContractNo());
		}else{
			q.setString("contractNo", searchSite.getContractNo().toUpperCase());
		}
		
		q.setString("siteName", searchSite.getSiteName());
		q.setString("vendorCode", searchSite.getVendorCode());
		q.setString("vendorName", searchSite.getVendorName());
		q.setString("vendorAddress", searchSite.getVendorAddress());
		q.setString("payeeName", searchSite.getPayeeName());
		q.setString("payeeAddress", searchSite.getPayeeAddress());
		q.setString("meterId", searchSite.getMeterId());
		q.setString("region", searchSite.getRegion());
	    q.setString("electricId", searchSite.getElectricId());
		
 
		List<PopupSiteSearch7> returnList = q.list();
		System.out.println(" returnList:" + returnList);
		return returnList;
	}	

	
	public List<PopupOldDocSearch7> searchOldDoc7(PopupOldDocSearch7 oldDoc) throws DAOException {
		
		Session session = getSessionFactory().getCurrentSession();
		Query q = session.getNamedQuery("querySearchELOldDoc7");
		 //query="call SEM_PG_EL_VENDOR_PAYEE.SP_REFER_DOC_SRCH(?,:company, :electricUseType,:expenseType, :docNo,:fromDocDt,:toDocDt,:meterId,:fromTermOfPaymentDt,:toTermOfPaymentDt)",   
		
		System.out.println(" contractNo:" + oldDoc.getContractNo()); 
		
	 	q.setString("company", oldDoc.getCompany());
		q.setString("electricUseType", oldDoc.getElectricUseType());
		q.setString("expenseType", oldDoc.getExpenseType());
		q.setString("docNo", oldDoc.getDocNo());
		q.setDate("fromDocDt", oldDoc.getFromDocDt());
		q.setDate("toDocDt", oldDoc.getToDocDt());		
		q.setString("meterId", oldDoc.getMeterId());
		q.setDate("fromTermOfPaymentDt", oldDoc.getFromTermOfPaymentDt());
		q.setDate("toTermOfPaymentDt", oldDoc.getToTermOfPaymentDt());
		
		if(oldDoc.getContractNo()==null){
			q.setString("contractNo", oldDoc.getContractNo());
		}else{
			q.setString("contractNo", oldDoc.getContractNo().toUpperCase());
		}
		
 
		List<PopupOldDocSearch7> returnList = q.list();
		return returnList;
	}
	public List<InstallmentDataDetail> searchInstallmentDataDetail(InstallmentDataDetail dataDetail) throws DAOException {
		
		Session session = getSessionFactory().getCurrentSession();
		Query q = session.getNamedQuery("installmentDataDetail");
		
		q.setString("meterInfoId", dataDetail.getMeterInfoId());
		q.setDate("termOfPaymentDt", dataDetail.getTermOfPaymentDt());
		List<InstallmentDataDetail> returnList = q.list();
	 	System.out.println(" returnList:" + returnList);
		return returnList;
	}
	
	@SuppressWarnings( { "unchecked", "rawtypes" })
	public List<Payment> querySEMMELPaymentHistoryByCriteria(Payment payment)
			throws DAOException {

		Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(Payment.class);
		System.out.println(" querySEMMELPaymentHistoryByCriteria:" +payment.getContractNo() );
		//System.out.println(" querySEMMELPaymentHistoryByCriteria Meter Info Id:" +payment.get;
		
		if (payment != null) {

			if (StringUtils.isNotEmpty(payment.getCompany()))
				criteria.add(Restrictions.eq("company", payment.getCompany()));
			if (StringUtils.isNotEmpty(payment.getContractNo()))
				criteria.add(Restrictions.eq("contractNo",payment.getContractNo().toUpperCase()));
			
		}

		criteria.add(Restrictions.eq("recordStatus", "Y"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		//criteria.addOrder(Order.asc("rowId"));
		if(payment!=null){
			if (payment.getOrderBy()!=null && !"".equals(payment.getOrderBy())) {
				criteria.addOrder(Order.asc(payment.getOrderBy()));
			}else{
				criteria.addOrder(Order.desc("createDt"));
				//criteria.addOrder(Order.desc("createBy"));
			}
		}else{
			criteria.addOrder(Order.desc("createDt"));
			//criteria.addOrder(Order.asc("createBy"));
		}
		
		

		List resultList = criteria.list();
		System.out.println(" querySEMMELPaymentHistoryByCriteria: resultList size:" + resultList.size() );

		// filter picoCell (- -")
		
		return resultList;
	}
public List<InstallmentSearch7> searchInstallment(InstallmentSearch7 installment) throws DAOException {
		
		Session session = getSessionFactory().getCurrentSession();
		Query q = session.getNamedQuery("querySearchInstallment");
		 //query="call SEM_PG_EL_VENDOR_PAYEE.SP_REFER_DOC_SRCH(?,:company, :electricUseType,:expenseType, :docNo,:fromDocDt,:toDocDt,:meterId,:fromTermOfPaymentDt,:toTermOfPaymentDt)",   
		
		System.out.println(" contractNo:" + installment.getContractNo()); 
		
		q.setString("contractNo", installment.getContractNo());
		q.setString("meterInfoId", installment.getMeterInfoId());
		q.setDate("fromTermOfPayment", installment.getFromTermOfPayment());
		q.setDate("toTermOfPayment", installment.getToTermOfPayment());
		
		List<InstallmentSearch7> returnList = q.list();
		return returnList;
	}
}
