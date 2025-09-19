package th.co.ais.domain.rt;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

import th.co.ais.domain.AbstractDomain;

/**
 * SemRtRentalPayment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SEM_RT_RENTAL_PAYMENT", schema = "SEM")
public class RentalPayment extends AbstractDomain {

	// Fields

	private String rowId;
	private String company;
	private String expenseType;
	private String siteInfoId;
	private String rentalDetailId;
	private String depositDetailId;
	private String pettyCashPayId;
	private String vendorMasterId;
	private String vendorCode;
	private String payeeMasterId;
	private Date paymentDt;
	private String paymentBatchNo;
	private String paymentGroupNo;
	private String paymentDocNo;
	private String docType;
	private String docNo;
	private Date docDt;
	private String referenceDocType;
	private String referenceDocNo;
	private Date referenceDocDt;
	private Byte periodNoStart;
	private Byte periodNoEnd;
	private String periodType;
	private Byte periodInterval;
	private Date periodStartDt;
	private Date periodEndDt;
	private Double periodAmt;
	private Integer calYear;
	private Integer calMonth;
	private String vatType;
	private Double vatRate;
	private String whtType;
	private Double whtRate;
	private Double excAmt;
	private Double vatAmt;
	private Double incAmt;
	private Double whtAmt;
	private Double depositAmt;
	private String paymentType;
	private String paymentMethod;
	private Date chqDt;
	private String chqNo;
	private Date chqReceiveDt;
	private Date transferDt;
	private String paymentStatus;
	private String rejectStatus;
	private String recordStatus;
	private String exportFlag;
	private Date exportDt;
	private String expiredFlag;
	private String pendingFlag;
	private String remark;
	private Long version;
	private Date createDt;
	private String createBy;
	private Date updateDt;
	private String updateBy;

	
	// Property accessors
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "RENTAL_PAYMENT_ID", unique = true, nullable = false, length = 50)
	public String getRowId() {
		return this.rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "COMPANY", length = 5)
	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "EXPENSE_TYPE", length = 20)
	public String getExpenseType() {
		return this.expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	@Column(name = "SITE_INFO_ID", length = 20)
	public String getSiteInfoId() {
		return this.siteInfoId;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}

	@Column(name = "RENTAL_DETAIL_ID", length = 50)
	public String getRentalDetailId() {
		return this.rentalDetailId;
	}

	public void setRentalDetailId(String rentalDetailId) {
		this.rentalDetailId = rentalDetailId;
	}

	@Column(name = "DEPOSIT_DETAIL_ID", length = 50)
	public String getDepositDetailId() {
		return this.depositDetailId;
	}

	public void setDepositDetailId(String depositDetailId) {
		this.depositDetailId = depositDetailId;
	}

	@Column(name = "PETTY_CASH_PAY_ID", length = 50)
	public String getPettyCashPayId() {
		return this.pettyCashPayId;
	}

	public void setPettyCashPayId(String pettyCashPayId) {
		this.pettyCashPayId = pettyCashPayId;
	}

	@Column(name = "VENDOR_MASTER_ID", length = 50)
	public String getVendorMasterId() {
		return this.vendorMasterId;
	}

	public void setVendorMasterId(String vendorMasterId) {
		this.vendorMasterId = vendorMasterId;
	}

	@Column(name = "VENDOR_CODE", length = 50)
	public String getVendorCode() {
		return this.vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	@Column(name = "PAYEE_MASTER_ID", length = 50)
	public String getPayeeMasterId() {
		return this.payeeMasterId;
	}

	public void setPayeeMasterId(String payeeMasterId) {
		this.payeeMasterId = payeeMasterId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PAYMENT_DT", length = 7)
	public Date getPaymentDt() {
		return this.paymentDt;
	}

	public void setPaymentDt(Date paymentDt) {
		this.paymentDt = paymentDt;
	}

	@Column(name = "PAYMENT_BATCH_NO", length = 20)
	public String getPaymentBatchNo() {
		return this.paymentBatchNo;
	}

	public void setPaymentBatchNo(String paymentBatchNo) {
		this.paymentBatchNo = paymentBatchNo;
	}

	@Column(name = "PAYMENT_GROUP_NO", length = 20)
	public String getPaymentGroupNo() {
		return this.paymentGroupNo;
	}

	public void setPaymentGroupNo(String paymentGroupNo) {
		this.paymentGroupNo = paymentGroupNo;
	}

	@Column(name = "PAYMENT_DOC_NO", length = 20)
	public String getPaymentDocNo() {
		return this.paymentDocNo;
	}

	public void setPaymentDocNo(String paymentDocNo) {
		this.paymentDocNo = paymentDocNo;
	}

	@Column(name = "DOC_TYPE", length = 20)
	public String getDocType() {
		return this.docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	@Column(name = "DOC_NO", length = 20)
	public String getDocNo() {
		return this.docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DOC_DT", length = 7)
	public Date getDocDt() {
		return this.docDt;
	}

	public void setDocDt(Date docDt) {
		this.docDt = docDt;
	}

	@Column(name = "REFERENCE_DOC_TYPE", length = 20)
	public String getReferenceDocType() {
		return this.referenceDocType;
	}

	public void setReferenceDocType(String referenceDocType) {
		this.referenceDocType = referenceDocType;
	}

	@Column(name = "REFERENCE_DOC_NO", length = 20)
	public String getReferenceDocNo() {
		return this.referenceDocNo;
	}

	public void setReferenceDocNo(String referenceDocNo) {
		this.referenceDocNo = referenceDocNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "REFERENCE_DOC_DT", length = 7)
	public Date getReferenceDocDt() {
		return this.referenceDocDt;
	}

	public void setReferenceDocDt(Date referenceDocDt) {
		this.referenceDocDt = referenceDocDt;
	}

	@Column(name = "PERIOD_NO_START", precision = 2, scale = 0)
	public Byte getPeriodNoStart() {
		return this.periodNoStart;
	}

	public void setPeriodNoStart(Byte periodNoStart) {
		this.periodNoStart = periodNoStart;
	}

	@Column(name = "PERIOD_NO_END", precision = 2, scale = 0)
	public Byte getPeriodNoEnd() {
		return this.periodNoEnd;
	}

	public void setPeriodNoEnd(Byte periodNoEnd) {
		this.periodNoEnd = periodNoEnd;
	}

	@Column(name = "PERIOD_TYPE", length = 5)
	public String getPeriodType() {
		return this.periodType;
	}

	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}

	@Column(name = "PERIOD_INTERVAL", precision = 2, scale = 0)
	public Byte getPeriodInterval() {
		return this.periodInterval;
	}

	public void setPeriodInterval(Byte periodInterval) {
		this.periodInterval = periodInterval;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PERIOD_START_DT", length = 7)
	public Date getPeriodStartDt() {
		return this.periodStartDt;
	}

	public void setPeriodStartDt(Date periodStartDt) {
		this.periodStartDt = periodStartDt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PERIOD_END_DT", length = 7)
	public Date getPeriodEndDt() {
		return this.periodEndDt;
	}

	public void setPeriodEndDt(Date periodEndDt) {
		this.periodEndDt = periodEndDt;
	}

	@Column(name = "PERIOD_AMT", precision = 15)
	public Double getPeriodAmt() {
		return this.periodAmt;
	}

	public void setPeriodAmt(Double periodAmt) {
		this.periodAmt = periodAmt;
	}

	@Column(name = "CAL_YEAR", precision = 5, scale = 0)
	public Integer getCalYear() {
		return this.calYear;
	}

	public void setCalYear(Integer calYear) {
		this.calYear = calYear;
	}

	@Column(name = "CAL_MONTH", precision = 5, scale = 0)
	public Integer getCalMonth() {
		return this.calMonth;
	}

	public void setCalMonth(Integer calMonth) {
		this.calMonth = calMonth;
	}

	@Column(name = "VAT_TYPE", length = 5)
	public String getVatType() {
		return this.vatType;
	}

	public void setVatType(String vatType) {
		this.vatType = vatType;
	}

	@Column(name = "VAT_RATE", precision = 4)
	public Double getVatRate() {
		return this.vatRate;
	}

	public void setVatRate(Double vatRate) {
		this.vatRate = vatRate;
	}

	@Column(name = "WHT_TYPE", length = 5)
	public String getWhtType() {
		return this.whtType;
	}

	public void setWhtType(String whtType) {
		this.whtType = whtType;
	}

	@Column(name = "WHT_RATE", precision = 4)
	public Double getWhtRate() {
		return this.whtRate;
	}

	public void setWhtRate(Double whtRate) {
		this.whtRate = whtRate;
	}

	@Column(name = "EXC_AMT", precision = 15)
	public Double getExcAmt() {
		return this.excAmt;
	}

	public void setExcAmt(Double excAmt) {
		this.excAmt = excAmt;
	}

	@Column(name = "VAT_AMT", precision = 15)
	public Double getVatAmt() {
		return this.vatAmt;
	}

	public void setVatAmt(Double vatAmt) {
		this.vatAmt = vatAmt;
	}

	@Column(name = "INC_AMT", precision = 15)
	public Double getIncAmt() {
		return this.incAmt;
	}

	public void setIncAmt(Double incAmt) {
		this.incAmt = incAmt;
	}

	@Column(name = "WHT_AMT", precision = 15)
	public Double getWhtAmt() {
		return this.whtAmt;
	}

	public void setWhtAmt(Double whtAmt) {
		this.whtAmt = whtAmt;
	}

	@Column(name = "DEPOSIT_AMT", precision = 15)
	public Double getDepositAmt() {
		return this.depositAmt;
	}

	public void setDepositAmt(Double depositAmt) {
		this.depositAmt = depositAmt;
	}

	@Column(name = "PAYMENT_TYPE", length = 5)
	public String getPaymentType() {
		return this.paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	@Column(name = "PAYMENT_METHOD", length = 5)
	public String getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CHQ_DT", length = 7)
	public Date getChqDt() {
		return this.chqDt;
	}

	public void setChqDt(Date chqDt) {
		this.chqDt = chqDt;
	}

	@Column(name = "CHQ_NO", length = 20)
	public String getChqNo() {
		return this.chqNo;
	}

	public void setChqNo(String chqNo) {
		this.chqNo = chqNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CHQ_RECEIVE_DT", length = 7)
	public Date getChqReceiveDt() {
		return this.chqReceiveDt;
	}

	public void setChqReceiveDt(Date chqReceiveDt) {
		this.chqReceiveDt = chqReceiveDt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TRANSFER_DT", length = 7)
	public Date getTransferDt() {
		return this.transferDt;
	}

	public void setTransferDt(Date transferDt) {
		this.transferDt = transferDt;
	}

	@Column(name = "PAYMENT_STATUS", length = 5)
	public String getPaymentStatus() {
		return this.paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Column(name = "REJECT_STATUS", length = 5)
	public String getRejectStatus() {
		return this.rejectStatus;
	}

	public void setRejectStatus(String rejectStatus) {
		this.rejectStatus = rejectStatus;
	}

	@Column(name = "RECORD_STATUS", length = 5)
	public String getRecordStatus() {
		return this.recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	@Column(name = "EXPORT_FLAG", length = 5)
	public String getExportFlag() {
		return this.exportFlag;
	}

	public void setExportFlag(String exportFlag) {
		this.exportFlag = exportFlag;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EXPORT_DT", length = 7)
	public Date getExportDt() {
		return this.exportDt;
	}

	public void setExportDt(Date exportDt) {
		this.exportDt = exportDt;
	}

	@Column(name = "EXPIRED_FLAG", length = 5)
	public String getExpiredFlag() {
		return this.expiredFlag;
	}

	public void setExpiredFlag(String expiredFlag) {
		this.expiredFlag = expiredFlag;
	}

	@Column(name = "PENDING_FLAG", length = 5)
	public String getPendingFlag() {
		return this.pendingFlag;
	}

	public void setPendingFlag(String pendingFlag) {
		this.pendingFlag = pendingFlag;
	}

	@Column(name = "REMARK", length = 250)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Version
	@Column(name = "VERSION", nullable = false)
	public Long getVersion() {
		return this.version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	
	@Column(name = "CREATE_DT")
	public Date getCreateDt() {
		return this.createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	@Column(name = "CREATE_BY", length = 50)
	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Column(name = "UPDATE_DT")
	public Date getUpdateDt() {
		return this.updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	@Column(name = "UPDATE_BY", length = 50)
	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

}