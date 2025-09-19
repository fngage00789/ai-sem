package th.co.ais.service.impl.el;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import th.co.ais.dao.impl.el.DepositDetailHibernateDAO;
import th.co.ais.dao.impl.el.MeterInstallmentHibernateDAO;
import th.co.ais.dao.impl.el.PLUtil;
import th.co.ais.dao.impl.el.PaymentDetailHibernateDAO;
import th.co.ais.dao.impl.el.PaymentHibernateDAO;
import th.co.ais.dao.impl.el.PrivateDepositHibernateDAO;
import th.co.ais.dao.impl.el.PrivatePrepaidMeterInstallmentHibernateDAO;
import th.co.ais.domain.el.DepositDetail;
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
import th.co.ais.domain.el.PrivateDeposit;
import th.co.ais.domain.el.PrivatePrepaid;
import th.co.ais.service.AbstractService;
import th.co.ais.service.el.IPaymentService;
import th.co.ais.util.BeanUtils;

public class PaymentServiceImpl extends AbstractService implements IPaymentService {
	
	Logger logger = Logger.getLogger(PaymentServiceImpl.class);
	
	private PaymentHibernateDAO paymentDao;
	private DepositDetailHibernateDAO depositDetailDao;
	private PrivateDepositHibernateDAO privateDepositDao;
	private PLUtil plUtil;
	private PaymentDetailHibernateDAO paymentDetailDao;
	private MeterInstallmentHibernateDAO meterInstallmentDao;
	private PrivatePrepaidMeterInstallmentHibernateDAO privatePrepaidDao;
	
   public void setPrivatePrepaidDao(
			PrivatePrepaidMeterInstallmentHibernateDAO privatePrepaidDao) {
		this.privatePrepaidDao = privatePrepaidDao;
	}

	public void setPaymentDetailDao(PaymentDetailHibernateDAO paymentDetailDao) {
		this.paymentDetailDao = paymentDetailDao;
	}

	public void setDepositDetailDao(DepositDetailHibernateDAO depositDetailDao) {
		this.depositDetailDao = depositDetailDao;
	}

	public void setPrivateDepositDao(PrivateDepositHibernateDAO privateDepositDao) {
		this.privateDepositDao = privateDepositDao;
	}
	
	public void setPaymentDao(PaymentHibernateDAO paymentDao) {
		
		this.paymentDao = paymentDao;
	}



	public void setMeterInstallmentDao(
			MeterInstallmentHibernateDAO meterInstallmentDao) {
		this.meterInstallmentDao = meterInstallmentDao;
	}
	
	
	
	public void setPlUtil(PLUtil plUtil) {
		this.plUtil = plUtil;
	}

	@Override
	public List<PopupSiteSearch> searchSite(PopupSiteSearch searchSite,String nameQuery)
			throws Exception {
		//paymentDao.s
		logger.debug(" --- searchSite -- : EL Search Site " );
		return paymentDao.searchSite(searchSite,nameQuery);
		
	}


	
	@Override
	public List<PaymentSearch> searchPayment(PaymentSearch searchPayment)
			throws Exception {		
		logger.debug(" -- searchPayment --");
		
		// 1. EXPENSE_TYPE = EL_POSTPAID, EL_DEBIT เน�เธฅเธฐ EL_CREDIT
		// 2.EXPENSE_TYPE = EL_TEMP
		// 3. EXPENSE_TYPE = PR_POSTPAID, PR_DEBIT เน�เธฅเธฐ PR_CREDIT
		// 4. EXPENSE_TYPE = PR_PREPAID
		
		List <PaymentSearch> resultList = paymentDao.searchPayment(searchPayment);
		
		//WT###Add 20110119 Start
		String expenseTypeDetail = "";
		if(null!=resultList && resultList.size()>0){
			expenseTypeDetail = resultList.get(0).getExpenseType();
		}
		//WT###Add 20110119 End
		List <PaymentSearch> returnList = new ArrayList();
		String expenseType =searchPayment.getExpenseType();
		
		for(PaymentSearch tmp:resultList){
			
			if("".equals(expenseType) || null==expenseType){
				expenseType = expenseTypeDetail;
			}
			String tmpExpenseType = tmp.getExpenseType();
			logger.debug("Expense Search:"+ expenseType+"  Expense Type Return :"+tmpExpenseType);
			if("EL_POSTPAID".equalsIgnoreCase(expenseType) ||   
			    "EL_DEBIT".equalsIgnoreCase(expenseType) ||
			    "EL_CREDIT".equalsIgnoreCase(expenseType)
			   ){
				logger.debug(" Get All EXPENSE_TYPE = EL_POSTPAID, EL_DEBIT   EL_CREDIT ");
					returnList.add(tmp);
							
			}else if("EL_TEMP".equalsIgnoreCase(expenseType)){
				logger.debug(" Get All EXPENSE_TYPE = EL_TEMP ");
				if("EL_TEMP".equalsIgnoreCase(tmpExpenseType)){
					returnList.add(tmp);
				}				
			}else if("PR_POSTPAID".equalsIgnoreCase(tmpExpenseType)||
					 "PR_DEBIT".equalsIgnoreCase(tmpExpenseType)||
					 "PR_CREDIT".equalsIgnoreCase(tmpExpenseType)){
				{
				logger.debug(" Get All EXPENSE_TYPE = PR_POSTPAID, PR_DEBIT, PR_CREDIT ");
					returnList.add(tmp);
				}				
			}else if("PR_PREPAID".equalsIgnoreCase(expenseType)){
				logger.debug(" Get All EXPENSE_TYPE = PR_PREPAID ");	
				if("PR_PREPAID".equalsIgnoreCase(tmpExpenseType)){
					returnList.add(tmp);
				}	
			}			
		}
		
		int i =1;
		for(PaymentSearch tmp:returnList){
			tmp.setRowNumber(""+i++);
		}
		
		return returnList;
	}

	@Override
	public List querySPList(String spName, Object property) throws Exception {
		return paymentDao.querySPList(spName, property);
	}

	@Override
	public void createSEMElectricPay(Payment semElectricPay)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateSEMElectricPay(Payment semElectricPay) throws Exception {
		
	}

	@Override
	public void deleteSEMElectricPay(Payment semElectricPay) throws Exception {
		
	}

	@Override
	public Payment querySEMElectricPayByRowId(String rowId) throws Exception {
		
		return null;
	}

	@Override
	public List<Payment> queryPaymentByCriteria(Payment payment, PaymentDetail paymentDetail) throws Exception {
			
		logger.debug(" --- queryPaymentByCriteria --" );
		
		return paymentDao.queryPaymentByCriteria(payment, paymentDetail);
	}
	
	@Override
	public String checkDuplicatePaymentDetail(String plName, String electricId, String contractNo, String expenseType) throws Exception {
		String strReturn;
		String errorCode = null;
		String errorDescription = null;
		int []inParamType = new int[]{
				PLUtil.IN_PARAM_TYPE_VARCHAR
				,PLUtil.IN_PARAM_TYPE_VARCHAR
				,PLUtil.IN_PARAM_TYPE_VARCHAR				
				};
		int []outParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR};
		
		Object []inParamValue = new Object[]{electricId, contractNo, expenseType};
		
		Object []result = plUtil.callPLWithReturnValue(plName, inParamType, outParamType, inParamValue);	
		
		if(result != null && result.length > 0) {
			errorCode = (String) result[0];
			errorDescription = (String)result[1];
		}
		strReturn =  errorCode+"|"+errorDescription;
		return strReturn;
	}
	
	@Override
	public List<Payment> queryPaymentByCriteria4Popup(Payment payment) throws Exception {
			
		logger.debug(" --- queryPaymentByCriteria4Popup --" );
		
		return paymentDao.queryByCriteria4Popup(payment);
	}

	@Override
	public boolean savePayment(List<Payment> paymentList) throws Exception  {
		return paymentDao.saveOrUpdateElectricPayment(paymentList);
	}
    
	
	
	@Override
	public List<PopupOldDocSearch> searchOldDoc(PopupOldDocSearch searchOldDoc)
			throws Exception {
		logger.debug(" --- searchOldDoc --" );
		return paymentDao.searchOldDoc(searchOldDoc);
	}

	public boolean savePayment(Payment payment , List<PaymentDetail> paymentDetailList) throws Exception  {
		
		// delete paymentDetail
		if(paymentDetailList != null){
			
			for(int i=paymentDetailList.size()-1;i>-1;i--){
				
				PaymentDetail paymentDetail = paymentDetailList.get(i);
				
				if(paymentDetail.isDeleted()){
					
					paymentDetailDao.delete(paymentDetail);
					paymentDetailList.remove(i);
				}
			}
		}
		
		Set<PaymentDetail> temp = new HashSet<PaymentDetail>();
		temp.addAll(paymentDetailList);
		payment.setDetails(temp);
		paymentDao.saveOrUpdateElectricPayment(payment);
		
		return true;
	}
	
	//WT###Add 20110107 Start
	public boolean savePaymentWithPL(Payment payment , List<PaymentDetail> paymentDetailList, String plName, List<PaymentDetail> oldPaymentDetailList) throws Exception  {
				
		String paymentId = "";
		if(null!=payment.getRowId() && !"".equals(payment.getRowId())){
			if(oldPaymentDetailList != null){
				for(int i=oldPaymentDetailList.size()-1;i>-1;i--){
					
					PaymentDetail paymentDetail = oldPaymentDetailList.get(i);
						paymentDetail.setRecordStatus("N");
						paymentDetailDao.update(paymentDetail);
				}
			}
			for(PaymentDetail obj : paymentDetailList){
				PaymentDetail paymentDetail = obj.clonePaymentDetail();
				//paymentDetail.setPaymentId(payment);
				paymentDetailDao.save(paymentDetail);
			}
			payment.setDetails(new HashSet<PaymentDetail>());
			paymentDao.saveOrUpdateElectricPayment(payment);
			paymentId = payment.getRowId();
		}else{
			Set<PaymentDetail> temp = new HashSet<PaymentDetail>();
			temp.addAll(paymentDetailList);
			payment.setDetails(temp);
			paymentId = paymentDao.saveReturnId(payment);
		}
		
		int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR};
		
		logger.debug(" --- payment.getElectricId().getRowId() --"+ payment.getElectricId().getRowId());
		
		Object []inParamValue = new Object[]{payment.getElectricId().getRowId(), paymentId};
		plUtil.callPL(plName, inParamType, inParamValue);
		
		return true;
	}
	//WT###Add 20110107 End
	
	//WT###Add 20101228 Start
	public String createPaymentReturnId(Payment payment) throws Exception  {
		
		return paymentDao.saveReturnId(payment);
	}
	//WT###Add 20101228 End

	public boolean savePayment(DepositDetail depositDetail,Payment payment , List<PaymentDetail> paymentDetailList) throws Exception  {
		// save deposit detail
		depositDetailDao.saveOrUpdate(depositDetail) ;
		// save payment
		payment.setDepositDetailId(depositDetail);
		Set<PaymentDetail> temp = new HashSet<PaymentDetail>();
		temp.addAll(paymentDetailList);
		payment.setDetails(temp);
		paymentDao.saveOrUpdateElectricPayment(payment);
		
		
		return true;
	}
	
	public boolean savePayment(DepositDetail depositDetail,Payment payment , List<PaymentDetail> paymentDetailList,List<PrivateDeposit> privateDepositList) throws Exception  {
		//save private deposit
		if(privateDepositList.size()>0){
			privateDepositDao.saveOrUpdateAll((Collection<PrivateDeposit>)privateDepositList);
		}
		// save deposit detail
		depositDetailDao.saveOrUpdate(depositDetail) ;
		// save payment , payment detail
		payment.setDepositDetailId(depositDetail);
		Set<PaymentDetail> temp = new HashSet<PaymentDetail>();
		temp.addAll(paymentDetailList);
		payment.setDetails(temp);
		paymentDao.saveOrUpdateElectricPayment(payment);
		
		return true;
	}
	
	@Override
	public boolean savePayment(Management manage, List<DepositDetail> depositDetailList, Payment payment, List<PaymentDetail> paymentDetailList, String plName) throws Exception  {
		
		// save deposit detail
		//WT###Comment 20110124depositDetailDao.saveOrUpdateAll(depositDetailList);
		
		// delete paymentDetail
		if(paymentDetailList != null){
			
			for(int i=paymentDetailList.size()-1;i>-1;i--){
				
				PaymentDetail paymentDetail = paymentDetailList.get(i);
				
				if(paymentDetail.isDeleted()){
					
					paymentDetailDao.delete(paymentDetail);
					paymentDetailList.remove(i);
				}
			}
		}
		
		// save payment
		Set<PaymentDetail> temp = new HashSet<PaymentDetail>();
		temp.addAll(paymentDetailList);
		payment.setDetails(temp);
		paymentDao.saveOrUpdateElectricPayment(payment);
		
		String depositType = manage.getDepositType() == null ? "" : manage.getDepositType();
		int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR};
		Object []inParamValue = new Object[]{manage.getRowId(), depositType};
		plUtil.callPL(plName, inParamType, inParamValue);
		
		return true;
	}
	@Override
	public boolean updatePaymentPage6(Payment payment, List<PaymentDetail> paymentDetailList) throws Exception  {
				
		// delete paymentDetail
		
		if(paymentDetailList != null){
			
			for(int i=paymentDetailList.size()-1;i>-1;i--){
				
				PaymentDetail paymentDetail = paymentDetailList.get(i);				
				paymentDetail.setPaymentId(payment);
				
				if(paymentDetail.isDeleted()){
					
					paymentDetailDao.delete(paymentDetail);
					paymentDetailList.remove(i);
				}
			}
		}
		
		// save payment
		Set<PaymentDetail> temp = new HashSet<PaymentDetail>();
		temp.addAll(paymentDetailList);
		payment.setDetails(temp);
		paymentDao.saveOrUpdateElectricPayment(payment);
		
		return true;
	}
	
	public boolean savePayment(Management manage, List<DepositDetail> depositDetailList, Payment payment, List<PaymentDetail> paymentDetailList, List<PrivateDeposit> privateDepositList, String plName) throws Exception  {
		
		//save private deposit
		if(privateDepositList.size()>0){
			privateDepositDao.saveOrUpdateAll((Collection<PrivateDeposit>)privateDepositList);
		}
		
		// save deposit detail
		//WT###Comment 20110112 depositDetailDao.saveOrUpdateAll(depositDetailList) ;
		
		// delete paymentDetail
		if(paymentDetailList != null){
			
			for(int i=paymentDetailList.size()-1;i>-1;i--){
				
				PaymentDetail paymentDetail = paymentDetailList.get(i);
				
				if(paymentDetail.isDeleted()){
					
					paymentDetailDao.delete(paymentDetail);
					paymentDetailList.remove(i);
				}
			}
		}
		
		// save payment , payment detail
		Set<PaymentDetail> temp = new HashSet<PaymentDetail>();
		System.out.println("WT###Print paymentDetailList.size()="+paymentDetailList.size());
		temp.addAll(paymentDetailList);
		payment.setDetails(temp);
		paymentDao.saveOrUpdateElectricPayment(payment);
		
		int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR};
		Object []inParamValue = new Object[]{manage.getRowId(), manage.getDepositType()};
		plUtil.callPL(plName, inParamType, inParamValue);
		
		return true;
	}

	@Override
	public Payment mergePayment(Payment payment,	List<PaymentDetail> paymentDetailList) throws Exception {	
		for(PaymentDetail tmp:paymentDetailList){		
			tmp.setPaymentId(payment);
		}
		Set<PaymentDetail> temp = new HashSet<PaymentDetail>();
		temp.addAll(paymentDetailList);
		payment.setDetails(temp);
//		paymentDao.mergeFlush(payment);
		payment = paymentDao.merge(payment);

		return payment;
	}

	@Override
	public List<Payment> querySEMMEL008PaymentByCriteria(final Payment payment) throws Exception {
		
		//return paymentDao.querySEMMEL008ByCriteria(payment);
		List<Payment> paymentList = paymentDao.querySEMMEL008ByCriteria(payment);
		if(paymentList!=null){
			for(Payment obj : paymentList){
				if(obj.getDetails()!=null){
					obj.getDetails().size();
				}
			}
		}
		return paymentList;
	}

	@Override
	public Object queryPaymentStatusCount(String status) throws Exception {
		
		return paymentDao.countPaymentByStatus(status);
	}
	
	@Override
	public Object queryPaymentStatusCountByCriteria(Payment payment) throws Exception {
		
		return paymentDao.countPaymentByCriteria(payment);
	}

	@Override
	public Payment queryPaymentByRowId(String rowId) throws Exception {
		
		Payment payment = paymentDao.findByRowId(rowId);
		
		if(payment != null && payment.getElectricId() != null){
			
			Management manage = new Management();
			manage.setContractNo(payment.getElectricId().getContractNo());
		}
		
		return payment;
	}
	
	@Override
	public Payment queryByRowIdFilterDetail(String rowId) throws Exception {
		
		Payment payment = paymentDao.findByRowIdFilterDetail(rowId);
		
		if(payment != null && payment.getElectricId() != null){
			
			Management manage = new Management();
			manage.setContractNo(payment.getElectricId().getContractNo());
		}
		
		return payment;
	}	

	@Override
	public String queryBatchNo(String plName, String param1, String param2) throws Exception {
		
		int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR};
		Object []inParamValue = new Object[]{param1, param2};
		
		return (String)plUtil.callFNWithReturnValue(plName, inParamType, PLUtil.IN_PARAM_TYPE_VARCHAR, inParamValue);
	}

	@Override
	public boolean isDuplicatePayment(Payment payment) throws Exception {
		// TODO Auto-generated method stub
		boolean returnResult = false;
		try{
			List resultList = paymentDao.queryByCriteria(payment);
			logger.info(" resultList size:"+resultList.size());
			if(resultList!=null&&resultList.size()>0){
				returnResult = true;
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return returnResult;
		
	}
	
	@Override
	public boolean isDuplicatePayment4Update(Payment payment) throws Exception {
		// TODO Auto-generated method stub
		boolean returnResult = false;
		try{
			List resultList = paymentDao.queryByCriteria(payment);
			logger.info(" resultList size:"+resultList.size());
			if(resultList!=null&&resultList.size()>0){
				Payment objPayment = (Payment) resultList.get(0);
				if(!payment.getRowId().equals(objPayment.getRowId())){
					returnResult = true;
				}				
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return returnResult;
		
	}

	

	@Override
	public boolean savePaymentELPostpaid(Payment payment,	List<PaymentDetail> paymentDetailList,  String plName) throws Exception {

		
		//mergePayment(payment,paymentDetailList);

		String key = paymentDao.savePaymentReturnId(payment,paymentDetailList);
		//String a = (String)getHibernateTemplate().save(null);
		
		System.out.println(" ELECTRIC_ID :"+payment.getElectricId().getRowId());
		System.out.println(" payment Id :"+key);
		System.out.println(" trans Id   :"+ payment.getTransID());
		
		String transId = payment.getTransID();
		int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR,PLUtil.IN_PARAM_TYPE_VARCHAR,PLUtil.IN_PARAM_TYPE_VARCHAR};
		Object []inParamValue = new Object[]{payment.getElectricId().getRowId(),key,transId};
		
		//if()
		plUtil.callPL(plName, inParamType, inParamValue);

		return true;
	}
	
	
	@Override
	public List  addELPostpaidToModel(String plName, PaymentDetail paymentDetail) throws Exception {
	
		List returnList = new ArrayList();

		int []inParamType = new int[]{
				PLUtil.IN_PARAM_TYPE_VARCHAR
				,PLUtil.IN_PARAM_TYPE_VARCHAR
				,PLUtil.IN_PARAM_TYPE_DATE
				,PLUtil.IN_PARAM_TYPE_DATE
				,PLUtil.IN_PARAM_TYPE_NUMBER
				,PLUtil.IN_PARAM_TYPE_NUMBER
				,PLUtil.IN_PARAM_TYPE_NUMBER
				,PLUtil.IN_PARAM_TYPE_DATE
				,PLUtil.IN_PARAM_TYPE_VARCHAR
				,PLUtil.IN_PARAM_TYPE_VARCHAR
				};
		int []outParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR,PLUtil.IN_PARAM_TYPE_VARCHAR};
		
		//logger.debug("  addELPostpaidToModel paymentDetail:"+BeanUtils.getBeanString(paymentDetail) );
		logger.debug(" paymentDetail.getTermOfPaymentDt():"+paymentDetail.getTermOfPaymentDt());
		logger.debug(" getValidatePaymentDetailFlag      :"+paymentDetail.getValidatePaymentDetailFlag());
		long pRead = 0;
		long lRead = 0;
		long kwhTotal = 0;
		if(paymentDetail.getpRead()!=null){
			pRead = paymentDetail.getpRead().longValue();
		}
		if(paymentDetail.getlRead()!=null){
			lRead = paymentDetail.getlRead().longValue(); 
		}
		if(paymentDetail.getKwhTotal()!=null){
			kwhTotal = paymentDetail.getKwhTotal().longValue();
		}
		
		Object []inParamValue = new Object[]{paymentDetail.getReferMeterId(),paymentDetail.getMeterId(),getSQLDate(paymentDetail.getpDate())
				,getSQLDate(paymentDetail.getlDate()),pRead,lRead,kwhTotal,
				getSQLDate(paymentDetail.getTermOfPaymentDt()),paymentDetail.getExpenseType(),paymentDetail.getValidatePaymentDetailFlag()};
		
		Object []result = plUtil.callPLWithReturnValue(plName, inParamType, outParamType, inParamValue);	
		
		if(result != null && result.length > 0) {
			String value0 = (String)result[0];
			if(value0.equals("01")){
				returnList.add((String)result[0]);
				returnList.add((String)result[1]);			
			}else if(value0.equals("00")){
				returnList.add((String)result[0]);
			}
		}
		return returnList;
	}
	
	@Override
	public List  addELPostpaidToModel5(String plName, PaymentDetail paymentDetail) throws Exception {
	
		
		List returnList = new ArrayList();
		int []inParamType = new int[]{
				PLUtil.IN_PARAM_TYPE_VARCHAR	
				,PLUtil.IN_PARAM_TYPE_VARCHAR	
				,PLUtil.IN_PARAM_TYPE_DATE
				,PLUtil.IN_PARAM_TYPE_DATE
				,PLUtil.IN_PARAM_TYPE_NUMBER
				,PLUtil.IN_PARAM_TYPE_NUMBER
				,PLUtil.IN_PARAM_TYPE_NUMBER
				,PLUtil.IN_PARAM_TYPE_VARCHAR
				,PLUtil.IN_PARAM_TYPE_VARCHAR
				,PLUtil.IN_PARAM_TYPE_NUMBER
				};
		int []outParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR,PLUtil.IN_PARAM_TYPE_VARCHAR};
		
		logger.debug("paymentDetail.getReferMeterId():"+paymentDetail.getReferMeterId()+ 
				"paymentDetail.getMeterId():"+paymentDetail.getMeterId()+ 
				"paymentDetail.getFromTermOfPaymentDt():"+paymentDetail.getFromTermOfPaymentDt()+ 
				"paymentDetail.getToTermOfPaymentDt():"+paymentDetail.getToTermOfPaymentDt()+
				" paymentDetail.getpRead():"+paymentDetail.getpRead()+
				" paymentDetail.getlRead():"+paymentDetail.getlRead()+
				" paymentDetail.getKwhTotal():"+paymentDetail.getKwhTotal()+
				" paymentDetail.getExpenseType():"+paymentDetail.getExpenseType());
		
		
		Object []inParamValue = new Object[]{
				paymentDetail.getReferMeterId()	, 
				paymentDetail.getMeterId()	,
				new java.sql.Date(paymentDetail.getFromTermOfPaymentDt().getTime()),
				new java.sql.Date(paymentDetail.getToTermOfPaymentDt().getTime()),
				paymentDetail.getpRead().longValue(),
				paymentDetail.getlRead().longValue(),
				paymentDetail.getKwhTotal().longValue(),
				paymentDetail.getExpenseType(),
				paymentDetail.getMultiVendorCheck(),
				paymentDetail.getPayAmt().longValue()
		        };
		
		Object []result = plUtil.callPLWithReturnValue(plName, inParamType, outParamType, inParamValue);	
		
		if(result != null && result.length > 0) {
			String value0 = (String)result[0];
			if(value0.equals("01")){
				returnList.add((String)result[0]);
				returnList.add((String)result[1]);			
			}else if(value0.equals("00")){
				returnList.add((String)result[0]);
			}
		}
		return returnList;
	}

	@Override
	public List  addELTempToModel(String plName, PaymentDetail paymentDetail) throws Exception {
	
		List returnList = new ArrayList();

		int []inParamType = new int[]{
				PLUtil.IN_PARAM_TYPE_VARCHAR
				,PLUtil.IN_PARAM_TYPE_VARCHAR
				,PLUtil.IN_PARAM_TYPE_DATE
				,PLUtil.IN_PARAM_TYPE_DATE
				,PLUtil.IN_PARAM_TYPE_VARCHAR				
				};
		int []outParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR,PLUtil.IN_PARAM_TYPE_VARCHAR};
		//logger.debug("  addELPostpaidToModel paymentDetail:"+BeanUtils.getBeanString(paymentDetail) );
		
		Object []inParamValue = new Object[]{paymentDetail.getReferMeterId(),paymentDetail.getMeterId(),new java.sql.Date(paymentDetail.getFromTermOfPaymentDt().getTime())
				,new java.sql.Date(paymentDetail.getToTermOfPaymentDt().getTime()),paymentDetail.getProcessType()};
		
		Object []result = plUtil.callPLWithReturnValue(plName, inParamType, outParamType, inParamValue);	
		
		if(result != null && result.length > 0) {
			String value0 = (String)result[0];
			if(value0.equals("01")){
				returnList.add((String)result[0]);
				returnList.add((String)result[1]);			
			}else if(value0.equals("00")){
				returnList.add((String)result[0]);
			}
		}
		return returnList;
	}
	
	@Override
	public void callSendPLForSEMMEL008(String plName, String batchNo) throws Exception {
		
		int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR};
		Object []inParamValue = new Object[]{batchNo};
		
		plUtil.callPL(plName, inParamType, inParamValue);
	}
	
	@Override
	public boolean savePaymentPRPospaid(Payment payment,List<PaymentDetail> paymentDetailList,String plName) throws Exception {
		 
		 // Step 1 Update MeterInstallmentList
		//mergePayment(payment,paymentDetailList);
		String key = paymentDao.savePaymentReturnId(payment,paymentDetailList);
		// call PL (P_IN_ELECTRIC_ID IN VARCHAR2,P_IN_PAYMENT_ID IN VARCHAR2
		int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR,PLUtil.IN_PARAM_TYPE_VARCHAR};
		Object []inParamValue = new Object[]{payment.getElectricId().getRowId(),key};
		
		plUtil.callPL(plName, inParamType, inParamValue);
		
		return true;
	}
	
	//WT###Add 20110118 Start
	@Override
	public boolean updatePaymentPRPospaidAndDelPaymentDetail(Payment payment,List<PaymentDetail> paymentDetailList,String plName) throws Exception {
		 		
		if(paymentDetailList != null){
			
			for(int i=paymentDetailList.size()-1;i>-1;i--){
				
				PaymentDetail paymentDetail = paymentDetailList.get(i);
				paymentDetail.setPaymentId(payment);
				
				if(paymentDetail.isDeleted()){
					
					paymentDetailDao.delete(paymentDetail);
					paymentDetailList.remove(i);
				}
			}
		}
		
		Set<PaymentDetail> temp = new HashSet<PaymentDetail>();
		temp.addAll(paymentDetailList);
		payment.setDetails(temp);
		paymentDao.saveOrUpdateElectricPayment(payment);
		
		int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR,PLUtil.IN_PARAM_TYPE_VARCHAR};
		Object []inParamValue = new Object[]{payment.getElectricId().getRowId(),payment.getRowId()};
		
		plUtil.callPL(plName, inParamType, inParamValue);
		
		return true;
	}
	
	@Override
	public boolean savePaymentPRPrepaidWithDelPaymentDetail(Payment payment,List<PaymentDetail> paymentDetailList,List<MeterInstallment> meterInstallmentList,String plName) throws Exception {
		 
		 // Step 1 Update MeterInstallmentList
		for(MeterInstallment tmp:meterInstallmentList){			
			meterInstallmentDao.mergeFlush(tmp);
		}
		
		if(paymentDetailList != null){
			
			for(int i=paymentDetailList.size()-1;i>-1;i--){
				
				PaymentDetail paymentDetail = paymentDetailList.get(i);
				paymentDetail.setPaymentId(payment);
				
				if(paymentDetail.isDeleted()){
					
					paymentDetailDao.delete(paymentDetail);
					paymentDetailList.remove(i);
				}
			}
		}
		
		Set<PaymentDetail> temp = new HashSet<PaymentDetail>();
		temp.addAll(paymentDetailList);
		payment.setDetails(temp);
		paymentDao.saveOrUpdateElectricPayment(payment);
		
		int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR,PLUtil.IN_PARAM_TYPE_VARCHAR};
		Object []inParamValue = new Object[]{payment.getElectricId().getRowId(),payment.getRowId()};
		
		plUtil.callPL(plName, inParamType, inParamValue);
		
		return true;
	}
	//------------------------------
	@Override
	public boolean savePaymentPrepaidWithDelPaymentDetail(Payment payment,List<PaymentDetail> paymentDetailList,List<PrivatePrepaid> meterInstallmentList,String plName) throws Exception {
		 
		 // Step 1 Update MeterInstallmentList
		for(PrivatePrepaid tmp:meterInstallmentList){			
			logger.debug(" tmp.getRowId :"+tmp.getRowId());	
			//privatePrepaidDao.mergeFlush(tmp);
			
		}
		
		if(paymentDetailList != null){
			
			for(int i=paymentDetailList.size()-1;i>-1;i--){
				
				PaymentDetail paymentDetail = paymentDetailList.get(i);
				paymentDetail.setPaymentId(payment);
				
				if(paymentDetail.isDeleted()){
					
					paymentDetailDao.delete(paymentDetail);
					paymentDetailList.remove(i);
				}
			}
		}
		
		Set<PaymentDetail> temp = new HashSet<PaymentDetail>();
		temp.addAll(paymentDetailList);
		payment.setDetails(temp);
		paymentDao.saveOrUpdateElectricPayment(payment);
		
		int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR,PLUtil.IN_PARAM_TYPE_VARCHAR};
		Object []inParamValue = new Object[]{payment.getElectricId().getRowId(),payment.getRowId()};
		
		plUtil.callPL(plName, inParamType, inParamValue);
		
		return true;
	}
	
	//WT###Add 20110118 End
		
	@Override
	public boolean savePaymentPRPrepaid(Payment payment,List<PaymentDetail> paymentDetailList,List<MeterInstallment> meterInstallmentList,String plName) throws Exception {
		 
		 // Step 1 Update MeterInstallmentList
		for(MeterInstallment tmp:meterInstallmentList){			
			meterInstallmentDao.mergeFlush(tmp);
		}
		
		//mergePayment(payment,paymentDetailList);
		String key = paymentDao.savePaymentReturnId(payment,paymentDetailList);
		// call PL (P_IN_ELECTRIC_ID IN VARCHAR2,P_IN_PAYMENT_ID IN VARCHAR2
		int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR,PLUtil.IN_PARAM_TYPE_VARCHAR};
		Object []inParamValue = new Object[]{payment.getElectricId().getRowId(),key};
		
		plUtil.callPL(plName, inParamType, inParamValue);
		
		return true;
	}
    
	@Override
	public boolean savePaymentPrivatePrepaid(Payment payment,List<PaymentDetail> paymentDetailList,List<PrivatePrepaid> meterInstallmentList,String plName) throws Exception {
		 
		 // Step 1 Update MeterInstallmentList
		for(PrivatePrepaid tmp:meterInstallmentList){			
			logger.debug(" tmp.getRowId :"+tmp.getRowId());	
			logger.debug(" tmp.getContractNo():"+tmp.getContractNo());
			logger.debug(" tmp.getPaidFlag() :"+tmp.getPaidFlag());
			logger.debug(" tmp.getPrepaidFlag() :"+tmp.getPrepaidFlag());
			logger.debug("privatePrepaidDao.mergeFlush(tmp):1");
			//privatePrepaidDao.mergeFlush(tmp);
			//privatePrepaidDao.update(tmp);
			//privateInstallmentDao.update(tmp);
			//privateInstallmentDao.updateByRowId(tmp);
			//logger.debug(" meterInstallmentDao.updateByRowId(tmp);"); 
			//meterInstallmentDao.updateByRowId(tmp);
		}
		
		//mergePayment(payment,paymentDetailList);
		String key = paymentDao.savePaymentReturnId(payment,paymentDetailList);
		// call PL (P_IN_ELECTRIC_ID IN VARCHAR2,P_IN_PAYMENT_ID IN VARCHAR2
		int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR,PLUtil.IN_PARAM_TYPE_VARCHAR};
		Object []inParamValue = new Object[]{payment.getElectricId().getRowId(),key};
		
		plUtil.callPL(plName, inParamType, inParamValue);
		
		return true;
	}
	@Override
	public Object[] queryBatchNoForExport(String plName, String param1, String param2) throws Exception {
		
		int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR};
		int []outParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR};
		Object []inParamValue = new Object[]{param1, param2};
		
		return plUtil.callPLWithReturnValue(plName, inParamType, outParamType, inParamValue);
		/*Object []result = plUtil.callPLWithReturnValue(plName, inParamType, outParamType, inParamValue);
		for(int i=0; i<result.length; i++){
			System.out.println("WT###Print result["+i+"]="+result[i]);
			String tom = (String) result[i];
		}
		
		return null;*/
	}

	@Override
	public void savePaymentForSEMMEL008(List<Payment> paymentList, String plName, String payNo) throws Exception {
		
		paymentDao.saveOrUpdateElectricPayment(paymentList);
		
		// call PL
		int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR};
		Object []inParamValue = new Object[]{payNo};
		
		plUtil.callPL(plName, inParamType, inParamValue);
	}

	@Override
	public void upDateBatchWithPL(String plName, String batchNo) throws Exception {
		
		// call PL
		int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR};
		Object []inParamValue = new Object[]{batchNo};
		
		plUtil.callPL(plName, inParamType, inParamValue);
		
	}
	
	@Override
	public void disbursedWithPL(String plName, String paymentId, String userName) throws Exception {
		
		// call PL
		int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR};
		Object []inParamValue = new Object[]{paymentId, userName};
		
		plUtil.callPL(plName, inParamType, inParamValue);
		
	}

	@Override
	public List<PaymentSearch> queryByCriteriaEL_BILL(	PaymentSearch paymentSearch) throws Exception {
		// TODO Auto-generated method stub
		
		List <Payment> result = paymentDao.queryByCriteriaEL_BILL(paymentSearch);
		List <PaymentSearch > paymentSearchReturnList = new ArrayList();
		int i=1;
		for(Payment tmp: result){
			System.out.println(" paymentId:"+tmp.getRowId());
			PaymentSearch paymentSearchReturn = new PaymentSearch();
			paymentSearchReturn.setRowNumber(""+i++);
			paymentSearchReturn.setPaymentId(tmp.getRowId());
			paymentSearchReturn.setCompany(tmp.getCompany());
			paymentSearchReturn.setElectricUseType(tmp.getElectricUseType());
			paymentSearchReturn.setDocNo(tmp.getDocNo());
			paymentSearchReturn.setDocDt(tmp.getDocDt());
			paymentSearchReturn.setInvTotalSite(tmp.getInvTotalSite());
			paymentSearchReturn.setDbTotalSite(tmp.getDbTotalSite());
			paymentSearchReturn.setInvTotalIncludeVat(tmp.getInvTotalIncludeVat());
			paymentSearchReturn.setDbTotalIncludeVat(tmp.getDbTotalIncludeVat());
			paymentSearchReturn.setInvTotalVat(tmp.getInvTotalVat());
			paymentSearchReturn.setDbTotalVat(tmp.getDbTotalVat());
			paymentSearchReturn.setChqAmt(tmp.getChqAmt());
			paymentSearchReturn.setPaymentType(tmp.getPaymentType());
			paymentSearchReturn.setPaymentMethod(tmp.getPaymentMethod());
			paymentSearchReturn.setBankName(tmp.getBankName());
			paymentSearchReturn.setBankAccount(tmp.getBankAccount());
			paymentSearchReturn.setChqPostingDt(tmp.getChqPostingDt());
			paymentSearchReturn.setChqReceivedDt(tmp.getChqReceivedDt());			
			paymentSearchReturn.setTransferDt(tmp.getTransferDt());
			paymentSearchReturn.setRemark(tmp.getRemark());
			paymentSearchReturn.setCreateBy(tmp.getCreateBy());
			paymentSearchReturn.setCreateDt(tmp.getCreateDt());
			
			paymentSearchReturn.setOldContractId(tmp.getOldContractNo());
			if(tmp.getContract()!=null){
				if(tmp.getContract().getEffectiveDt()!=null){
				paymentSearchReturn.setEffectiveDt(tmp.getContract().getEffectiveDt());
				}
				if(tmp.getContract().getExpireDt()!=null){
				paymentSearchReturn.setExpireDt(tmp.getContract().getExpireDt());
				}
			}
			
			paymentSearchReturn.setSiteStatus(tmp.getSiteStatus());
			paymentSearchReturn.setSiteStatusDisplay(tmp.getSiteStatusDisplay());
			paymentSearchReturn.setNetworkStatus(tmp.getNetWorkStatus());
			paymentSearchReturn.setNetworkStatusDisplay(tmp.getNetworkStatusDisplay());
			if (tmp.getMeterInfo()!=null){
				paymentSearchReturn.setMeterStatus(tmp.getMeterInfo().getMeterStatus());
				paymentSearchReturn.setMeterId(tmp.getMeterInfo().getMeterId());
			}
			
			paymentSearchReturnList.add(paymentSearchReturn);
			
		}
		return paymentSearchReturnList;
	}
	
	@Override
	public void saveRejectPayment(List<Payment> paymentList,String plName,String userName) throws Exception  {
		
		paymentDao.saveOrUpdateElectricPayment(paymentList);
		
		for(Payment payment : paymentList){
		    rejectPaymentPL(plName,payment.getRowId(),userName);
		}
		
	}
	
	public void rejectPaymentPL(String plName, String paymentId, String userName) throws Exception {
		
		// call PL
		int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR};
		Object []inParamValue = new Object[]{paymentId, userName};
		
		plUtil.callPL(plName, inParamType, inParamValue);
		
	}
	
	@Override
	public List<PopupSiteSearch7> searchSite7(PopupSiteSearch7 searchSite,String nameQuery)
		throws Exception {
		return paymentDao.searchSite7(searchSite,nameQuery);
	
	}	
	@Override
	public List<PopupOldDocSearch7> searchOldDoc7(PopupOldDocSearch7 olddoc )		throws Exception {
	//paymentDao.s
	logger.debug(" --- searchSite7 -- : Test" );
	return paymentDao.searchOldDoc7(olddoc);
	
	}		
	@Override
	public boolean savePaymentPage7(Payment payment,	List<PaymentDetail> paymentDetailList,  String plName) throws Exception {

		String key = paymentDao.savePaymentReturnId(payment,paymentDetailList);
		System.out.println(" ELECTRIC_ID :"+payment.getElectricId().getRowId());
		System.out.println(" payment Id :"+key);
		System.out.println(" trans Id   :"+ payment.getTransID());
		
		int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR,PLUtil.IN_PARAM_TYPE_VARCHAR};
		Object []inParamValue = new Object[]{payment.getElectricId().getRowId(),key};
		plUtil.callPL(plName, inParamType, inParamValue);
		
		return true;
	}
	
	@Override
	public boolean updatePaymentPage7(Payment payment,	List<PaymentDetail> paymentDetailList,  String plName) throws Exception {

		 paymentDao.saveOrUpdateElectricPayment(payment);
		 String key = payment.getRowId();
		System.out.println(" ON Service ELECTRIC_ID :"+payment.getElectricId().getRowId());
		System.out.println(" payment Id :"+key);
		
		int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR,PLUtil.IN_PARAM_TYPE_VARCHAR};
		Object []inParamValue = new Object[]{payment.getElectricId().getRowId(),key};
		plUtil.callPL(plName, inParamType, inParamValue);
		
		return true;
	}
	private java.sql.Date getSQLDate (java.util.Date date){
		
		if(null != date ){
			return new java.sql.Date(date.getTime());
		}
		return null;
	}
	
	@Override
	public List<InstallmentDataDetail> searchInstallmentDataDetail (InstallmentDataDetail dataDetail) throws Exception {
	//paymentDao.s
	logger.debug(" --- searchInstallmentDataDetail -- : Test" );
	return paymentDao.searchInstallmentDataDetail(dataDetail);
	
	}
	
	@Override
	public List<Payment> querySEMMELPaymentHistoryByCriteria(final Payment payment) throws Exception {
		
		//return paymentDao.querySEMMEL008ByCriteria(payment);
		List<Payment> paymentList = paymentDao.querySEMMELPaymentHistoryByCriteria(payment);
		if(paymentList!=null){
			for(Payment obj : paymentList){
				if(obj.getDetails()!=null){
					obj.getDetails().size();
				}
			}
		}
		return paymentList;
	}
	
	@Override
	public List<InstallmentSearch7> queryInstallment(InstallmentSearch7 installment) throws Exception {
		//paymentDao.s
		logger.debug(" --- queryInstallment -- : Test" );
		return paymentDao.searchInstallment(installment);
		
		}		
	@Override
	public List updateInstallment(String plName, InstallmentSearch7 installment) throws Exception {
	
		
		List returnList = new ArrayList();
		int []inParamType = new int[]{
				PLUtil.IN_PARAM_TYPE_VARCHAR	
				,PLUtil.IN_PARAM_TYPE_DATE
				,PLUtil.IN_PARAM_TYPE_DATE
				,PLUtil.IN_PARAM_TYPE_NUMBER
				,PLUtil.IN_PARAM_TYPE_NUMBER
				,PLUtil.IN_PARAM_TYPE_NUMBER
				,PLUtil.IN_PARAM_TYPE_DOUBLE
				,PLUtil.IN_PARAM_TYPE_DOUBLE
				,PLUtil.IN_PARAM_TYPE_DOUBLE
				,PLUtil.IN_PARAM_TYPE_DOUBLE
				,PLUtil.IN_PARAM_TYPE_VARCHAR
				
				};
		int []outParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR,PLUtil.IN_PARAM_TYPE_VARCHAR};
		
		
		
		Object []inParamValue = new Object[]{
				installment.getMeterInstallmentID(), 
				getSQLDate(installment.getpDate()),
				getSQLDate(installment.getlDate()),
				installment.getpRaed().longValue(),
				installment.getlRaed().longValue(),
				installment.getKwh().longValue(),
				installment.getPayAmt(),
				installment.getInculdeVat(),
				installment.getExculdeVat(),
				installment.getVatAmt(),
				installment.getVatType()
				};
		
		Object []result = plUtil.callPLWithReturnValueInstallment(plName, inParamType, outParamType, inParamValue);	
		
		if(result != null && result.length > 0) {
			String value0 = (String)result[0];
			if(value0.equals("01")){
				returnList.add((String)result[0]);
				returnList.add((String)result[1]);			
			}else if(value0.equals("00")){
				returnList.add((String)result[0]);
			}
		}
		return returnList;
	}
}   
