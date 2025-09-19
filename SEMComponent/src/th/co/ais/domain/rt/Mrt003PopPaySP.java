package th.co.ais.domain.rt;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mrt003PopPaySP extends AbstractDomain{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3637715235396475967L;
	private String paymentType;
	private String paymentMethod;
	private Date chqDt;
	private Date chqReceiveDt;
	private Date transferDt;
	private String doc68;
	private Date doc68Dt;
	private String userId;	
	
	private String resultMsg;
	private String pRemark;
	
	//for view display
	private String vendorCode;
	private String vendorName;
	private String payeeName;
	private String bankAccNo;
	private String invoiceNo;
	private Double totalAmt;
	private Double vatAmt;
	private Double whtAmt;
	private Double payamount;
	private Double dutyAmt;
	private String docNo;
	private String docPayment;
	private Date docPaymentDt;
	private String docCancel;
	private Date docCancelDt;
	
	private String paramRentalPaymentId;
	
	private String paymentStatus;
	private String remarkPaymentStatus;
	
	private String pResult;
	
	private Double payVatAmt;
	private Double payWhtAmt;
	private Double payDutyAmt;
	private Double payAmt;
	
	// added by.. YUT 2014/09/10
	private String payCutCheck;
	private Double rcptPayCutAmount;
	
	@Override
	public String getCreateBy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getCreateDt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUpdateBy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getUpdateDt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCreateBy(String createBy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCreateDt(Date createDt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUpdateBy(String updateBy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUpdateDt(Date updateDt) {
		// TODO Auto-generated method stub
		
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Date getChqDt() {
		return chqDt;
	}

	public void setChqDt(Date chqDt) {
		this.chqDt = chqDt;
	}

	public Date getChqReceiveDt() {
		return chqReceiveDt;
	}

	public void setChqReceiveDt(Date chqReceiveDt) {
		this.chqReceiveDt = chqReceiveDt;
	}

	public Date getTransferDt() {
		return transferDt;
	}

	public void setTransferDt(Date transferDt) {
		this.transferDt = transferDt;
	}

	public String getDoc68() {
		return doc68;
	}

	public void setDoc68(String doc68) {
		this.doc68 = doc68;
	}

	public Date getDoc68Dt() {
		return doc68Dt;
	}

	public void setDoc68Dt(Date doc68Dt) {
		this.doc68Dt = doc68Dt;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public String getpRemark() {
		return pRemark;
	}

	public void setpRemark(String pRemark) {
		this.pRemark = pRemark;
	}

	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public String getBankAccNo() {
		return bankAccNo;
	}

	public void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public Double getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(Double totalAmt) {
		this.totalAmt = totalAmt;
	}

	public Double getVatAmt() {
		return vatAmt;
	}

	public void setVatAmt(Double vatAmt) {
		this.vatAmt = vatAmt;
	}

	public Double getWhtAmt() {
		return whtAmt;
	}

	public void setWhtAmt(Double whtAmt) {
		this.whtAmt = whtAmt;
	}

	public Double getPayamount() {
		return payamount;
	}

	public void setPayamount(Double payamount) {
		this.payamount = payamount;
	}

	public Double getDutyAmt() {
		return dutyAmt;
	}

	public void setDutyAmt(Double dutyAmt) {
		this.dutyAmt = dutyAmt;
	}

	public String getDocPayment() {
		return docPayment;
	}

	public void setDocPayment(String docPayment) {
		this.docPayment = docPayment;
	}

	public Date getDocPaymentDt() {
		return docPaymentDt;
	}

	public void setDocPaymentDt(Date docPaymentDt) {
		this.docPaymentDt = docPaymentDt;
	}

	public String getDocCancel() {
		return docCancel;
	}

	public void setDocCancel(String docCancel) {
		this.docCancel = docCancel;
	}

	public Date getDocCancelDt() {
		return docCancelDt;
	}

	public void setDocCancelDt(Date docCancelDt) {
		this.docCancelDt = docCancelDt;
	}

	public String getParamRentalPaymentId() {
		return paramRentalPaymentId;
	}

	public void setParamRentalPaymentId(String paramRentalPaymentId) {
		this.paramRentalPaymentId = paramRentalPaymentId;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getRemarkPaymentStatus() {
		return remarkPaymentStatus;
	}

	public void setRemarkPaymentStatus(String remarkPaymentStatus) {
		this.remarkPaymentStatus = remarkPaymentStatus;
	}

	public String getpResult() {
		return pResult;
	}

	public void setpResult(String pResult) {
		this.pResult = pResult;
	}

	public String getDocNo() {
		return docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	public Double getPayVatAmt() {
		return payVatAmt;
	}

	public void setPayVatAmt(Double payVatAmt) {
		this.payVatAmt = payVatAmt;
	}

	public Double getPayWhtAmt() {
		return payWhtAmt;
	}

	public void setPayWhtAmt(Double payWhtAmt) {
		this.payWhtAmt = payWhtAmt;
	}

	public Double getPayDutyAmt() {
		return payDutyAmt;
	}

	public void setPayDutyAmt(Double payDutyAmt) {
		this.payDutyAmt = payDutyAmt;
	}

	public Double getPayAmt() {
		return payAmt;
	}

	public void setPayAmt(Double payAmt) {
		this.payAmt = payAmt;
	}

	public String getPayCutCheck() {
		return payCutCheck;
	}

	public void setPayCutCheck(String payCutCheck) {
		this.payCutCheck = payCutCheck;
	}

	public Double getRcptPayCutAmount() {
		return rcptPayCutAmount;
	}

	public void setRcptPayCutAmount(Double rcptPayCutAmount) {
		this.rcptPayCutAmount = rcptPayCutAmount;
	}
	
	
	
	
}
