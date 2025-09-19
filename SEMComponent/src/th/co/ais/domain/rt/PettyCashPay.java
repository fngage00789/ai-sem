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

@Entity
@Table(name = "SEM_RT_PETTY_CASH_PAY", schema = "SEM")
public class PettyCashPay extends AbstractDomain {

	// Fields
	private String rowId;
	private String pettyCashPayNo;
	private String company;
	private String region;
	private Date requestDt;
	private String requestName;
	private String requestSubject;
	private Double requestAmt;
	private String vatType;
	private Double vatRate;
	private Double vatAmt;
	private Double excRequestAmt;
	private Double incRequestAmt;
	private String clrReceiptTaxFlag;
	private String receiptTaxFlag;
	private String pettyCashPayStatus;
	private String remark;
	private String recordStatus;
	private Long version;
	
	private String refClrBatchNo;
	private String taxInvoiceNo;
	private Date taxInvoiceDt;
	private String expenseType;
	// Property accessors
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "PETTY_CASH_PAY_ID", unique = true, nullable = false, length = 50)
	public String getRowId() {
		return this.rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "PETTY_CASH_PAY_NO", length = 20)
	public String getPettyCashPayNo() {
		return this.pettyCashPayNo;
	}

	public void setPettyCashPayNo(String pettyCashPayNo) {
		this.pettyCashPayNo = pettyCashPayNo;
	}

	@Column(name = "COMPANY", nullable = false, length = 5)
	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "REGION", length = 10)
	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "REQUEST_DT", length = 7)
	public Date getRequestDt() {
		return this.requestDt;
	}

	public void setRequestDt(Date requestDt) {
		this.requestDt = requestDt;
	}

	@Column(name = "REQUEST_NAME", length = 100)
	public String getRequestName() {
		return this.requestName;
	}

	public void setRequestName(String requestName) {
		this.requestName = requestName;
	}

	@Column(name = "REQUEST_SUBJECT", length = 100)
	public String getRequestSubject() {
		return this.requestSubject;
	}

	public void setRequestSubject(String requestSubject) {
		this.requestSubject = requestSubject;
	}

	@Column(name = "REQUEST_AMT", precision = 15)
	public Double getRequestAmt() {
		return this.requestAmt;
	}

	public void setRequestAmt(Double requestAmt) {
		this.requestAmt = requestAmt;
	}

	@Column(name = "VAT_TYPE", length = 20)
	public String getVatType() {
		return this.vatType;
	}

	public void setVatType(String vatType) {
		this.vatType = vatType;
	}

	@Column(name = "VAT_RATE", precision = 5)
	public Double getVatRate() {
		return this.vatRate;
	}

	public void setVatRate(Double vatRate) {
		this.vatRate = vatRate;
	}

	@Column(name = "VAT_AMT", precision = 15)
	public Double getVatAmt() {
		return this.vatAmt;
	}

	public void setVatAmt(Double vatAmt) {
		this.vatAmt = vatAmt;
	}

	@Column(name = "EXC_REQUEST_AMT", precision = 15)
	public Double getExcRequestAmt() {
		return this.excRequestAmt;
	}

	public void setExcRequestAmt(Double excRequestAmt) {
		this.excRequestAmt = excRequestAmt;
	}

	@Column(name = "INC_REQUEST_AMT", precision = 15)
	public Double getIncRequestAmt() {
		return this.incRequestAmt;
	}

	public void setIncRequestAmt(Double incRequestAmt) {
		this.incRequestAmt = incRequestAmt;
	}

	@Column(name = "CLR_RECEIPT_TAX_FLAG", length = 1)
	public String getClrReceiptTaxFlag() {
		return this.clrReceiptTaxFlag;
	}

	public void setClrReceiptTaxFlag(String clrReceiptTaxFlag) {
		this.clrReceiptTaxFlag = clrReceiptTaxFlag;
	}

	@Column(name = "RECEIPT_TAX_FLAG", length = 1)
	public String getReceiptTaxFlag() {
		return this.receiptTaxFlag;
	}

	public void setReceiptTaxFlag(String receiptTaxFlag) {
		this.receiptTaxFlag = receiptTaxFlag;
	}

	@Column(name = "PETTY_CASH_PAY_STATUS", length = 20)
	public String getPettyCashPayStatus() {
		return this.pettyCashPayStatus;
	}

	public void setPettyCashPayStatus(String pettyCashPayStatus) {
		this.pettyCashPayStatus = pettyCashPayStatus;
	}

	@Column(name = "REMARK", length = 250)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	@Column(name = "RECORD_STATUS", length = 1)
	public String getRecordStatus() {
		return this.recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	@Version
	@Column(name = "VERSION", nullable = false)
	public Long getVersion() {
		return this.version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Override
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DT", length = 7)
	public Date getCreateDt() {
		return this.createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	@Override
	@Column(name = "CREATE_BY", length = 50)
	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Override
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATE_DT", length = 7)
	public Date getUpdateDt() {
		return this.updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	@Override
	@Column(name = "UPDATE_BY", length = 50)
	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	
	@Column(name = "REF_CLR_BATCH_NO", length = 20)
	public String getRefClrBatchNo() {
		return refClrBatchNo;
	}

	public void setRefClrBatchNo(String refClrBatchNo) {
		this.refClrBatchNo = refClrBatchNo;
	}
	
	@Column(name = "TAX_INVOICE_NO", length = 20)
	public String getTaxInvoiceNo() {
		return taxInvoiceNo;
	}

	public void setTaxInvoiceNo(String taxInvoiceNo) {
		this.taxInvoiceNo = taxInvoiceNo;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "TAX_INVOICE_DT", length = 7)
	public Date getTaxInvoiceDt() {
		return taxInvoiceDt;
	}

	public void setTaxInvoiceDt(Date taxInvoiceDt) {
		this.taxInvoiceDt = taxInvoiceDt;
	}

	@Column(name = "EXPENSE_TYPE", length = 50)
	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	
	
	

}