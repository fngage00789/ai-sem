package th.co.ais.domain.ac;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mac004Act extends AbstractDomain{

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
	
	private String docPayment;
	private Date docPaymentDt;
	private String docCancel;
	private Date docCancelDt;
	
	private String paymentStatus;
	private String paymentStatusRemark;
	
	@Override
	public String getCreateBy() {
		return this.createBy;
	}
	@Override
	public Date getCreateDt() {
		return this.createDt;
	}
	@Override
	public String getUpdateBy() {
		return this.updateBy;
	}
	@Override
	public Date getUpdateDt() {
		return this.updateDt;
	}
	@Override
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	@Override
	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}
	@Override
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	@Override
	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
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
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getPaymentStatusRemark() {
		return paymentStatusRemark;
	}
	public void setPaymentStatusRemark(String paymentStatusRemark) {
		this.paymentStatusRemark = paymentStatusRemark;
	}
	
}
