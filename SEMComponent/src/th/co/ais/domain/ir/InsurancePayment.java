package th.co.ais.domain.ir;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import th.co.ais.domain.AbstractDomain;

@Entity
@Table(name="SEM_IR_PAYMENT", schema="SEM")
public class InsurancePayment implements java.io.Serializable {
	
	private String rowId;
	private String company;
	private String expenseType;
	private String policyNo;
	private String contranctNo;
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
	private int periodNoStart;
	private int periodNoEnd;
	private String periodType;
	private int periodInterval;
	private Date periodStartDt;
	private Date periodEndDt;
	private Double permiumAmt;
	private String vatType;
	private Double vatRate;
	private String whtType;
	private Double whtRate;
	private Double excAmt;
	private Double vatAmt;
	private Double incAmt;
	private Double whtAmt;
	private Double dutyAmt;
	private String paymentType;
	private String paymentMethod;
	private Date chqDt;
	private String chqNo;
	private Date chqReceiveDt;
	private Date transferDt;
	private String paymentStatus;
	private String remark;
	private String recordStatus;
	private int version;
	private Date createDt;
	private String createBy;
	private Date updateDt;
	private String updateBy;
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "IR_PAYMENT_ID", unique = true, nullable = false,  length = 50)
	public String getRowId() {
		return rowId;
	}
	
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	
	@Column(name = "COMPANY", nullable = false,  length = 5)
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Column(name = "EXPENSE_TYPE",  length = 5)
	public String getExpenseType() {
		return expenseType;
	}
	
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	@Column(name = "POLICY_NO",  length = 50)
	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	@Column(name = "CONTRACT_NO",  length = 50)
	public String getContranctNo() {
		return contranctNo;
	}

	public void setContranctNo(String contranctNo) {
		this.contranctNo = contranctNo;
	}
	@Column(name = "VENDOR_MASTER_ID",  length = 50)
	public String getVendorMasterId() {
		return vendorMasterId;
	}

	public void setVendorMasterId(String vendorMasterId) {
		this.vendorMasterId = vendorMasterId;
	}
	@Column(name = "VENDOR_CODE",  length = 50)
	public String getVendorCode() {
		return vendorCode;
	}
	
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}
	@Column(name = "PAYEE_MASTER_ID",  length = 50)
	public String getPayeeMasterId() {
		return payeeMasterId;
	}

	public void setPayeeMasterId(String payeeMasterId) {
		this.payeeMasterId = payeeMasterId;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "PAYMENT_DT",  length = 7)
	public Date getPaymentDt() {
		return paymentDt;
	}

	public void setPaymentDt(Date paymentDt) {
		this.paymentDt = paymentDt;
	}
	@Column(name = "PAYMENT_BATCH_NO",  length = 20)
	public String getPaymentBatchNo() {
		return paymentBatchNo;
	}

	public void setPaymentBatchNo(String paymentBatchNo) {
		this.paymentBatchNo = paymentBatchNo;
	}
	@Column(name = "PAYMENT_GROUP_NO",  length = 50)
	public String getPaymentGroupNo() {
		return paymentGroupNo;
	}

	public void setPaymentGroupNo(String paymentGroupNo) {
		this.paymentGroupNo = paymentGroupNo;
	}
	@Column(name = "PAYMENT_DOC_NO",  length = 20)
	public String getPaymentDocNo() {
		return paymentDocNo;
	}

	public void setPaymentDocNo(String paymentDocNo) {
		this.paymentDocNo = paymentDocNo;
	}
	@Column(name = "DOC_TYPE",  length = 20)
	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}
	@Column(name = "DOC_NO",  length = 20)
	public String getDocNo() {
		return docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "DOC_DT",  length = 7)
	public Date getDocDt() {
		return docDt;
	}

	public void setDocDt(Date docDt) {
		this.docDt = docDt;
	}
	@Column(name = "PERIOD_NO_START",  precision = 2)
	public int getPeriodNoStart() {
		return periodNoStart;
	}

	public void setPeriodNoStart(int periodNoStart) {
		this.periodNoStart = periodNoStart;
	}
	@Column(name = "PERIOD_NO_END",  precision = 2)
	public int getPeriodNoEnd() {
		return periodNoEnd;
	}

	public void setPeriodNoEnd(int periodNoEnd) {
		this.periodNoEnd = periodNoEnd;
	}
	@Column(name = "PERIOD_TYPE",  length = 5)
	public String getPeriodType() {
		return periodType;
	}

	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}
	@Column(name = "PERIOD_INTERVAL",  precision = 2)
	public int getPeriodInterval() {
		return periodInterval;
	}

	public void setPeriodInterval(int periodInterval) {
		this.periodInterval = periodInterval;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "PERIOD_START_DT",  length = 7)
	public Date getPeriodStartDt() {
		return periodStartDt;
	}

	public void setPeriodStartDt(Date periodStartDt) {
		this.periodStartDt = periodStartDt;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "PERIOD_END_DT",  length = 7)
	public Date getPeriodEndDt() {
		return periodEndDt;
	}

	public void setPeriodEndDt(Date periodEndDt) {
		this.periodEndDt = periodEndDt;
	}
	@Column(name = "PREMIUM_AMT",  precision = 15)
	public Double getPermiumAmt() {
		return permiumAmt;
	}

	public void setPermiumAmt(Double permiumAmt) {
		this.permiumAmt = permiumAmt;
	}
	@Column(name = "VAT_TYPE",  length = 5)
	public String getVatType() {
		return vatType;
	}

	public void setVatType(String vatType) {
		this.vatType = vatType;
	}
	@Column(name = "VAT_RATE",  precision = 4)
	public Double getVatRate() {
		return vatRate;
	}

	public void setVatRate(Double vatRate) {
		this.vatRate = vatRate;
	}
	@Column(name = "WHT_TYPE",  length = 5)
	public String getWhtType() {
		return whtType;
	}

	public void setWhtType(String whtType) {
		this.whtType = whtType;
	}
	@Column(name = "WHT_RATE",  precision = 4)
	public Double getWhtRate() {
		return whtRate;
	}

	public void setWhtRate(Double whtRate) {
		this.whtRate = whtRate;
	}
	@Column(name = "EXC_AMT",  precision = 15)
	public Double getExcAmt() {
		return excAmt;
	}

	public void setExcAmt(Double excAmt) {
		this.excAmt = excAmt;
	}
	@Column(name = "VAT_AMT",  precision = 15)
	public Double getVatAmt() {
		return vatAmt;
	}

	public void setVatAmt(Double vatAmt) {
		this.vatAmt = vatAmt;
	}
	@Column(name = "INC_AMT",  precision = 15)
	public Double getIncAmt() {
		return incAmt;
	}

	public void setIncAmt(Double incAmt) {
		this.incAmt = incAmt;
	}
	@Column(name = "WHT_AMT",  precision = 15)
	public Double getWhtAmt() {
		return whtAmt;
	}

	public void setWhtAmt(Double whtAmt) {
		this.whtAmt = whtAmt;
	}
	@Column(name = "DUTY_AMT",  precision = 15)
	public Double getDutyAmt() {
		return dutyAmt;
	}

	public void setDutyAmt(Double dutyAmt) {
		this.dutyAmt = dutyAmt;
	}
	@Column(name = "PAYMENT_TYPE",  length = 5)
	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	@Column(name = "PAYMENT_METHOD",  length = 5)
	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "CHQ_DT",  length = 7)
	public Date getChqDt() {
		return chqDt;
	}

	public void setChqDt(Date chqDt) {
		this.chqDt = chqDt;
	}
	@Column(name = "CHQ_NO",  length = 20)
	public String getChqNo() {
		return chqNo;
	}

	public void setChqNo(String chqNo) {
		this.chqNo = chqNo;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "CHQ_RECEIVE_DT",  length = 7)
	public Date getChqReceiveDt() {
		return chqReceiveDt;
	}

	public void setChqReceiveDt(Date chqReceiveDt) {
		this.chqReceiveDt = chqReceiveDt;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "TRANSFER_DT",  length = 7)
	public Date getTransferDt() {
		return transferDt;
	}

	public void setTransferDt(Date transferDt) {
		this.transferDt = transferDt;
	}
	@Column(name = "PAYMENT_STATUS",  length = 5)
	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	@Column(name = "REMARK",  length = 250)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Column(name = "RECORD_STATUS",  length = 5)
	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	@Column(name = "VERSION",  precision = 10)
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DT",  length = 7)
	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}
	@Column(name = "CREATE_BY",  length = 50)
	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATE_DT",  length = 7)
	public Date getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}
	@Column(name = "UPDATE_BY",  length = 50)
	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	

	
}
