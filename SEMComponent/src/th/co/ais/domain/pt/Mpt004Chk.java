package th.co.ais.domain.pt;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mpt004Chk extends AbstractDomain{
	
	private String resultMsg;
	private String message;
	private String pTaxPayType;
	private String pTaxPayTypeDesc;
	private String payGovtFlag;
	private String paymentStatus;
	private String paymentStatusDesc;
	private String vendorCode;
	private String vendorName;
	private String payeeName;
	private Double estmAmt;
	private Double pTaxAmt;
	
	private String contractNo;
	private String pTaxYear;
	private String expenseType;
	private String periodNo;
	private String docType;
	private String docNo;
	
	private String monthFrom;
	private String monthTo;
	private String payeeId;
	
	private String paymentType;
	private String paymentMethod;
	private String bankName;
	private String bankAccNo;
	private String pTaxPaymentId;
	
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
	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getpTaxPayType() {
		return pTaxPayType;
	}
	public void setpTaxPayType(String pTaxPayType) {
		this.pTaxPayType = pTaxPayType;
	}
	public String getpTaxPayTypeDesc() {
		return pTaxPayTypeDesc;
	}
	public void setpTaxPayTypeDesc(String pTaxPayTypeDesc) {
		this.pTaxPayTypeDesc = pTaxPayTypeDesc;
	}
	public String getPayGovtFlag() {
		return payGovtFlag;
	}
	public void setPayGovtFlag(String payGovtFlag) {
		this.payGovtFlag = payGovtFlag;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getPaymentStatusDesc() {
		return paymentStatusDesc;
	}
	public void setPaymentStatusDesc(String paymentStatusDesc) {
		this.paymentStatusDesc = paymentStatusDesc;
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
	public Double getEstmAmt() {
		return estmAmt;
	}
	public void setEstmAmt(Double estmAmt) {
		this.estmAmt = estmAmt;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public String getDocNo() {
		return docNo;
	}
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	public Double getpTaxAmt() {
		return pTaxAmt;
	}
	public void setpTaxAmt(Double pTaxAmt) {
		this.pTaxAmt = pTaxAmt;
	}
	public String getContractNo() {
		return contractNo;
	}
	public String getpTaxYear() {
		return pTaxYear;
	}
	public void setpTaxYear(String pTaxYear) {
		this.pTaxYear = pTaxYear;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public String getPeriodNo() {
		return periodNo;
	}
	public void setPeriodNo(String periodNo) {
		this.periodNo = periodNo;
	}
	public String getMonthFrom() {
		return monthFrom;
	}
	public void setMonthFrom(String monthFrom) {
		this.monthFrom = monthFrom;
	}
	public String getMonthTo() {
		return monthTo;
	}
	public void setMonthTo(String monthTo) {
		this.monthTo = monthTo;
	}
	public String getPayeeId() {
		return payeeId;
	}
	public void setPayeeId(String payeeId) {
		this.payeeId = payeeId;
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
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankAccNo() {
		return bankAccNo;
	}
	public void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
	}
	/**
	 * @param pTaxPaymentId the pTaxPaymentId to set
	 */
	public void setpTaxPaymentId(String pTaxPaymentId) {
		this.pTaxPaymentId = pTaxPaymentId;
	}
	/**
	 * @return the pTaxPaymentId
	 */
	public String getpTaxPaymentId() {
		return pTaxPaymentId;
	}
}
