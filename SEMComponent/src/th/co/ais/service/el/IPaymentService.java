package th.co.ais.service.el;

import java.util.List;

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

public interface IPaymentService {
	
	public List querySPList(String spName, Object property) throws Exception;
	public void createSEMElectricPay(Payment semElectricPay) throws Exception;
	public void updateSEMElectricPay(Payment semElectricPay) throws Exception;
	public void deleteSEMElectricPay(Payment semElectricPay) throws Exception;
	public Payment querySEMElectricPayByRowId(String rowId) throws Exception;
	public List<Payment> queryPaymentByCriteria(Payment payment,PaymentDetail paymentDetail) throws Exception;
	public List<Payment> queryPaymentByCriteria4Popup(Payment payment) throws Exception;
	public boolean savePayment(List<Payment> paymentList )throws Exception;
	public List<PaymentSearch> searchPayment(PaymentSearch searchPayment) throws Exception;
	
	public List<PopupSiteSearch> searchSite(PopupSiteSearch searchSite,String nameQuery) throws Exception;
	public List<PopupOldDocSearch> searchOldDoc(PopupOldDocSearch searchOldDoc) throws Exception;
	public boolean savePayment(Payment payment , List<PaymentDetail> paymentDetailList) throws Exception ;
	//WT###Add 20110107 Start
	public boolean savePaymentWithPL(Payment payment , List<PaymentDetail> paymentDetailList, String plName, List<PaymentDetail> oldPaymentDetailList) throws Exception ;
	//WT###Add 20110107 End
	public boolean savePayment(Management manage, List<DepositDetail> depositDetailList, Payment payment, List<PaymentDetail> paymentDetailList, String plName)throws Exception;
	public boolean updatePaymentPage6(Payment payment, List<PaymentDetail> paymentDetailList)throws Exception;//WT###Add 20110114
	public boolean savePayment(Management manage, List<DepositDetail> depositDetailList, Payment payment, List<PaymentDetail> paymentDetailList, List<PrivateDeposit> privateDepositList, String plName) throws Exception;
	public boolean savePayment(DepositDetail depositDetail,Payment payment , List<PaymentDetail> paymentDetailList)throws Exception;
	public boolean savePayment(DepositDetail depositDetail,Payment payment , List<PaymentDetail> paymentDetailList,List<PrivateDeposit> privateDepositList) throws Exception;
	public Payment mergePayment(Payment payment , List<PaymentDetail> paymentDetailList) throws Exception ;

	public List<Payment> querySEMMEL008PaymentByCriteria(Payment payment) throws Exception;
	public Object queryPaymentStatusCount(String status) throws Exception;
	public Object queryPaymentStatusCountByCriteria(Payment payment) throws Exception;//WT###Add 20110421
	public Payment queryPaymentByRowId(String rowId) throws Exception; 
	public String queryBatchNo(String plName, String param1, String param2) throws Exception;
	public Object[] queryBatchNoForExport(String plName, String param1, String param2) throws Exception;
	public boolean isDuplicatePayment(Payment payment)throws Exception;
	public boolean isDuplicatePayment4Update(Payment payment)throws Exception;//WT###Add 20110114
	public void savePaymentForSEMMEL008(List<Payment> paymentList, String plName, String payNo)throws Exception;
	
	public boolean savePaymentELPostpaid(Payment payment , List<PaymentDetail> paymentDetailList, String plName) throws Exception ;

	
	public List addELPostpaidToModel(String plName, PaymentDetail detail) throws Exception;
	public List addELTempToModel(String plName, PaymentDetail detail) throws Exception;
	
	public void callSendPLForSEMMEL008(String plName, String batchNo) throws Exception;
	
	public boolean savePaymentPRPospaid(Payment payment,List<PaymentDetail> paymentDetailList, String plName) throws Exception ;
	public boolean savePaymentPRPrepaid(Payment payment,List<PaymentDetail> paymentDetailList,List<MeterInstallment> meterInstallmentList,String plName) throws Exception ;
	public List addELPostpaidToModel5(String plName, PaymentDetail detail) throws Exception;
	public String checkDuplicatePaymentDetail(String plName, String electricId, String contractNo, String expenseType) throws Exception;
	public void upDateBatchWithPL(String plName, String batchNo) throws Exception;
	public void disbursedWithPL(String plName, String paymentId, String userName) throws Exception;
	
	public List<PaymentSearch> queryByCriteriaEL_BILL(PaymentSearch paymentSearch) throws Exception;
	boolean updatePaymentPRPospaidAndDelPaymentDetail(Payment payment, List<PaymentDetail> paymentDetailList, String plName)
			throws Exception;//WT###Add 20110118
	boolean savePaymentPRPrepaidWithDelPaymentDetail(Payment payment, List<PaymentDetail> paymentDetailList,
			List<MeterInstallment> meterInstallmentList, String plName)
			throws Exception;//WT###Add 20110118
	public boolean savePaymentPrepaidWithDelPaymentDetail(Payment payment,List<PaymentDetail> paymentDetailList,List<PrivatePrepaid> meterInstallmentList,String plName) throws Exception;
	public boolean savePaymentPrivatePrepaid(Payment payment,List<PaymentDetail> paymentDetailList,List<PrivatePrepaid> meterInstallmentList,String plName) throws Exception;
	Payment queryByRowIdFilterDetail(String rowId) throws Exception;//WT###Add 20110125
	
	//------------------------------------------
	public void saveRejectPayment(List<Payment> paymentList,String plName,String userName) throws Exception;
	
	
	// Button 7 
	
	public List<PopupSiteSearch7> searchSite7(PopupSiteSearch7 searchSite,String nameQuery) throws Exception;
	public List<PopupOldDocSearch7> searchOldDoc7(PopupOldDocSearch7 searchOldDoc) throws Exception;
	public boolean savePaymentPage7(Payment payment,	List<PaymentDetail> paymentDetailList,  String plName) throws Exception;
	public boolean updatePaymentPage7(Payment payment,	List<PaymentDetail> paymentDetailList,  String plName) throws Exception;
	public List<InstallmentDataDetail> searchInstallmentDataDetail(InstallmentDataDetail dataDetail)throws Exception;
	
	public List<Payment> querySEMMELPaymentHistoryByCriteria(Payment payment) throws Exception;
	public List<InstallmentSearch7> queryInstallment(InstallmentSearch7 installment) throws Exception;
	public List updateInstallment(String plName, InstallmentSearch7 installment) throws Exception;
}




