package th.co.ais.domain.gm;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import th.co.ais.domain.AbstractDomain;

@Entity
@Table(name="SEM_CT_TRANS_PAYMENT", schema="SEM")
public class TransPayment extends AbstractDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7293893687178363780L;
	
	private String transPaymentId;
	private String expenseType;
	private String payVatType;
	private Double payVatRate;
	private String payWhtType;
	private Double payWhtRate;
	private Double payExcAmt;
	private Double payVatAmt;
	private Double payIncAmt;
	private Double payWhtAmt;
	private Double payDutyAmt;
	private String paymentType;
	private String paymentMethod;
	
	private Date paymentDt;
	private String paymentBatchNo;
	private String paymentGroupNo;
	private String paymentDocNo;
	private String vendorCode;
	private String payeeName;
	private String payeeAddress;
	private String payeeBankAccNo;
	private String docType;
	private String docNo;
	private Date docDt;
	private String referenceDocType;
	private String referenceDocNo;
	private Integer periodNoStart;
	private Integer periodNoEnd;
	private String periodType;
	private Integer periodInterval;
	private Date periodStartDt;
	private Date periodEndDt;
	private Double periodAmt;
	private String glAccount;
	private String costCenter;
	private String wbsNo;	
	
	private Date chqDt;
	private String chqNo;
	private Date chqReceiveDt;
	private Date transferDt;
	private String company;
	private String chqClearingStatus;
	private String approveBy;
	private Date approveDt;
	private Date chqClearingDt;
	private String paymentStatus;
	private String reason;
	private String reasonDesc;
	//private String rejectStatus;
	private String remark;
	private String doc68;
	private Date doc68Dt;
	private String doc92;
	private Date doc92Dt;
	private String recordStatus;
	private String sapGroupNo;
	private String sapUpdateFile;
	private Date sapUpdateDt;
	private String doc68Year;
	private String doc92Year;
	private String doc68Linitm;
	private Integer version;
	
	/**	Transient **/
	private boolean selected;
		
	@Id
	@Column(name = "TRANS_PAYMENT_ID", unique = true, nullable = false, length = 50)
	public String getTransPaymentId() {
		return transPaymentId;
	}
	public void setTransPaymentId(String transPaymentId) {
		this.transPaymentId = transPaymentId;
	}
	
	@Column(name = "EXPENSE_TYPE", length = 20)
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	
	@Column(name = "PAY_VAT_TYPE", length = 5)
	public String getPayVatType() {
		return payVatType;
	}
	public void setPayVatType(String payVatType) {
		this.payVatType = payVatType;
	}
	
	@Column(name = "PAY_VAT_RATE", length = 4)
	public Double getPayVatRate() {
		return payVatRate;
	}
	public void setPayVatRate(Double payVatRate) {
		this.payVatRate = payVatRate;
	}
	
	@Column(name = "PAY_WHT_TYPE", length = 5)
	public String getPayWhtType() {
		return payWhtType;
	}
	public void setPayWhtType(String payWhtType) {
		this.payWhtType = payWhtType;
	}
	
	@Column(name = "PAY_WHT_RATE", length = 4)
	public Double getPayWhtRate() {
		return payWhtRate;
	}
	public void setPayWhtRate(Double payWhtRate) {
		this.payWhtRate = payWhtRate;
	}
	
	@Column(name = "PAY_EXC_AMT", length = 15)
	public Double getPayExcAmt() {
		return payExcAmt;
	}
	public void setPayExcAmt(Double payExcAmt) {
		this.payExcAmt = payExcAmt;
	}
	
	@Column(name = "PAY_VAT_AMT", length = 15)
	public Double getPayVatAmt() {
		return payVatAmt;
	}
	public void setPayVatAmt(Double payVatAmt) {
		this.payVatAmt = payVatAmt;
	}
	
	@Column(name = "PAY_INC_AMT", length = 15)
	public Double getPayIncAmt() {
		return payIncAmt;
	}
	public void setPayIncAmt(Double payIncAmt) {
		this.payIncAmt = payIncAmt;
	}
	
	@Column(name = "PAY_WHT_AMT", length = 15)
	public Double getPayWhtAmt() {
		return payWhtAmt;
	}
	public void setPayWhtAmt(Double payWhtAmt) {
		this.payWhtAmt = payWhtAmt;
	}
	
	@Column(name = "PAY_DUTY_AMT", precision = 15)
	public Double getPayDutyAmt() {
		return this.payDutyAmt;
	}

	public void setPayDutyAmt(Double payDutyAmt) {
		this.payDutyAmt = payDutyAmt;
	}
	
	@Column(name = "PAYMENT_TYPE", length = 5)
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	@Column(name = "PAYMENT_METHOD", length = 5)
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CHQ_DT", length = 7)
	public Date getChqDt() {
		return chqDt;
	}
	public void setChqDt(Date chqDt) {
		this.chqDt = chqDt;
	}
	
	@Column(name = "CHQ_NO", length = 20)
	public String getChqNo() {
		return chqNo;
	}
	public void setChqNo(String chqNo) {
		this.chqNo = chqNo;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CHQ_RECEIVE_DT", length = 7)
	public Date getChqReceiveDt() {
		return chqReceiveDt;
	}
	public void setChqReceiveDt(Date chqReceiveDt) {
		this.chqReceiveDt = chqReceiveDt;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "TRANSFER_DT", length = 7)
	public Date getTransferDt() {
		return transferDt;
	}
	public void setTransferDt(Date transferDt) {
		this.transferDt = transferDt;
	}
	
	@Column(name = "COMPANY", length = 5)
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	@Column(name = "CHQ_CLEARING_STATUS", length = 5)
	public String getChqClearingStatus() {
		return chqClearingStatus;
	}
	public void setChqClearingStatus(String chqClearingStatus) {
		this.chqClearingStatus = chqClearingStatus;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CHQ_CLEARING_DT", length = 7)
	public Date getChqClearingDt() {
		return chqClearingDt;
	}
	public void setChqClearingDt(Date chqClearingDt) {
		this.chqClearingDt = chqClearingDt;
	}
	
	@Column(name = "APPROVE_BY", length = 20)
	public String getApproveBy() {
		return approveBy;
	}
	public void setApproveBy(String approveBy) {
		this.approveBy = approveBy;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "APPROVE_DT", length = 7)
	public Date getApproveDt() {
		return approveDt;
	}
	public void setApproveDt(Date approveDt) {
		this.approveDt = approveDt;
	}
	
	@Column(name = "PAYMENT_STATUS", length = 5)
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	/*@Column(name = "REJECT_STATUS", length = 5)
	public String getRejectStatus() {
		return rejectStatus;
	}
	public void setRejectStatus(String rejectStatus) {
		this.rejectStatus = rejectStatus;
	}*/
	
	@Column(name = "REASON", length = 50)
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	@Column(name = "REASON_DESC", length = 500)
	public String getReasonDesc() {
		return reasonDesc;
	}
	public void setReasonDesc(String reasonDesc) {
		this.reasonDesc = reasonDesc;
	}
	
	@Column(name = "REMARK", length = 250)
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(name = "DOC_68", length = 20)
	public String getDoc68() {
		return doc68;
	}
	public void setDoc68(String doc68) {
		this.doc68 = doc68;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DOC_68_DT", length=7)
	public Date getDoc68Dt() {
		return doc68Dt;
	}
	public void setDoc68Dt(Date doc68Dt) {
		this.doc68Dt = doc68Dt;
	}
	
	@Column(name = "DOC_92", length = 20)
	public String getDoc92() {
		return doc92;
	}
	public void setDoc92(String doc92) {
		this.doc92 = doc92;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DOC_92_DT", length=7)
	public Date getDoc92Dt() {
		return doc92Dt;
	}
	public void setDoc92Dt(Date doc92Dt) {
		this.doc92Dt = doc92Dt;
	}
	
	@Column(name = "RECORD_STATUS", length = 10)
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	
	@Column(name = "VERSION", precision = 22, scale = 0)
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "PAYMENT_DT", length=7)
	public Date getPaymentDt() {
		return paymentDt;
	}
	public void setPaymentDt(Date paymentDt) {
		this.paymentDt = paymentDt;
	}
	
	@Column(name = "PAYMENT_BATCH_NO", length = 20)
	public String getPaymentBatchNo() {
		return paymentBatchNo;
	}
	public void setPaymentBatchNo(String paymentBatchNo) {
		this.paymentBatchNo = paymentBatchNo;
	}
	
	@Column(name = "PAYMENT_GROUP_NO", length = 20)
	public String getPaymentGroupNo() {
		return paymentGroupNo;
	}
	public void setPaymentGroupNo(String paymentGroupNo) {
		this.paymentGroupNo = paymentGroupNo;
	}
	
	@Column(name = "PAYMENT_DOC_NO", length = 20)
	public String getPaymentDocNo() {
		return paymentDocNo;
	}
	public void setPaymentDocNo(String paymentDocNo) {
		this.paymentDocNo = paymentDocNo;
	}
	
	@Column(name = "VENDOR_CODE", length = 20)
	public String getVendorCode() {
		return vendorCode;
	}
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}
	
	@Column(name = "PAYEE_NAME", length = 255)
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	
	@Column(name = "PAYEE_ADDRESS", length = 255)
	public String getPayeeAddress() {
		return payeeAddress;
	}
	public void setPayeeAddress(String payeeAddress) {
		this.payeeAddress = payeeAddress;
	}
	
	@Column(name = "PAYEE_BANK_ACC_NO", length = 20)
	public String getPayeeBankAccNo() {
		return payeeBankAccNo;
	}
	public void setPayeeBankAccNo(String payeeBankAccNo) {
		this.payeeBankAccNo = payeeBankAccNo;
	}	
	
	@Column(name = "DOC_TYPE", length = 20)
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	
	@Column(name = "DOC_NO", length = 20)
	public String getDocNo() {
		return docNo;
	}
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DOC_DT", length=7)
	public Date getDocDt() {
		return docDt;
	}
	public void setDocDt(Date docDt) {
		this.docDt = docDt;
	}
	@Column(name = "REFERENCE_DOC_TYPE", length = 20)
	public String getReferenceDocType() {
		return referenceDocType;
	}
	public void setReferenceDocType(String referenceDocType) {
		this.referenceDocType = referenceDocType;
	}
	
	@Column(name = "REFERENCE_DOC_NO", length = 20)
	public String getReferenceDocNo() {
		return referenceDocNo;
	}
	public void setReferenceDocNo(String referenceDocNo) {
		this.referenceDocNo = referenceDocNo;
	}
	
	@Column(name = "PERIOD_NO_START", precision = 2, scale = 0)
	public Integer getPeriodNoStart() {
		return periodNoStart;
	}
	public void setPeriodNoStart(Integer periodNoStart) {
		this.periodNoStart = periodNoStart;
	}
	
	@Column(name = "PERIOD_NO_END", precision = 2, scale = 0)
	public Integer getPeriodNoEnd() {
		return periodNoEnd;
	}
	public void setPeriodNoEnd(Integer periodNoEnd) {
		this.periodNoEnd = periodNoEnd;
	}
	
	@Column(name = "PERIOD_TYPE", length = 5)
	public String getPeriodType() {
		return periodType;
	}
	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}
	
	@Column(name = "PERIOD_INTERVAL", precision = 2, scale = 0)
	public Integer getPeriodInterval() {
		return periodInterval;
	}
	public void setPeriodInterval(Integer periodInterval) {
		this.periodInterval = periodInterval;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "PERIOD_START_DT", length=7)
	public Date getPeriodStartDt() {
		return periodStartDt;
	}
	public void setPeriodStartDt(Date periodStartDt) {
		this.periodStartDt = periodStartDt;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "PERIOD_END_DT", length=7)
	public Date getPeriodEndDt() {
		return periodEndDt;
	}
	public void setPeriodEndDt(Date periodEndDt) {
		this.periodEndDt = periodEndDt;
	}
	
	@Column(name = "PERIOD_AMT", precision = 15, scale = 2)
	public Double getPeriodAmt() {
		return periodAmt;
	}
	public void setPeriodAmt(Double periodAmt) {
		this.periodAmt = periodAmt;
	}
	
	@Column(name = "GL_ACCOUNT", length = 20)
	public String getGlAccount() {
		return glAccount;
	}
	public void setGlAccount(String glAccount) {
		this.glAccount = glAccount;
	}
	
	@Column(name = "COST_CENTER", length = 20)
	public String getCostCenter() {
		return costCenter;
	}
	public void setCostCenter(String CostCenter) {
		this.costCenter = CostCenter;
	}
	
	@Column(name = "WBS_NO", length = 20)
	public String getWbsNo() {
		return wbsNo;
	}
	public void setWbsNo(String wbsNo) {
		this.wbsNo = wbsNo;
	}
	
	@Column(name = "SAP_UPDATE_FILE", length = 100)
	public String getSapUpdateFile() {
		return this.sapUpdateFile;
	}

	public void setSapUpdateFile(String sapUpdateFile) {
		this.sapUpdateFile = sapUpdateFile;
	}

	@Column(name = "SAP_GROUP_NO", length = 2)
	public String getSapGroupNo() {
		return this.sapGroupNo;
	}

	public void setSapGroupNo(String sapGroupNo) {
		this.sapGroupNo = sapGroupNo;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "SAP_UPDATE_DT", length = 7)
	public Date getSapUpdateDt() {
		return this.sapUpdateDt;
	}

	public void setSapUpdateDt(Date sapUpdateDt) {
		this.sapUpdateDt = sapUpdateDt;
	}

	@Column(name = "DOC_68_YEAR", length = 4)
	public String getDoc68Year() {
		return this.doc68Year;
	}

	public void setDoc68Year(String doc68Year) {
		this.doc68Year = doc68Year;
	}

	@Column(name = "DOC_92_YEAR", length = 4)
	public String getDoc92Year() {
		return this.doc92Year;
	}

	public void setDoc92Year(String doc92Year) {
		this.doc92Year = doc92Year;
	}

	@Column(name = "DOC_68_LINITM", length = 3)
	public String getDoc68Linitm() {
		return this.doc68Linitm;
	}

	public void setDoc68Linitm(String doc68Linitm) {
		this.doc68Linitm = doc68Linitm;
	}
	

	@Override
	@Column(name="CREATE_BY")
	public String getCreateBy() {
		return this.createBy;
	}
	@Override
	@Column(name="CREATE_DT")
	public Date getCreateDt() {
		return this.createDt;
	}

	@Override
	@Column(name="UPDATE_BY")
	public String getUpdateBy() {
		return this.updateBy;
	}

	@Override
	@Column(name="UPDATE_DT")
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
	
	@Transient
	public boolean isSelected() {return selected;	}
	public void setSelected(boolean selected) { this.selected = selected;	}
}
