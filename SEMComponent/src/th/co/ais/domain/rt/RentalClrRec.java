package th.co.ais.domain.rt;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

import th.co.ais.domain.AbstractDomain;

/**
 * SemRtRentalClrRec entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SEM_RT_RENTAL_CLR_REC", schema = "SEM")
public class RentalClrRec extends AbstractDomain {

	// Fields

	private String rentalPaymentId;
	private String paymentGroupNo;
	private String paymentDocNo;
	private String depositDetailId;
	private String company;
	private String siteInfoId;
	private String receiptNo;
	private String taxInvoiceNo;
	private Date taxInvoiceDt;
	private String remark;
	private String clrReceiptStatus;
	private String batchNo;
	private String exportStatus;
	private Date exportDt;
	private String clrRejectReason;
	private String recordStatus;
	private String receiptStatus;
	private Long version;
	
	private Double sumAmt;
	private String vatType;
	
	private String notClrFlag;

	private String donateFlag;
	private boolean donateFlagBoolean;
	private boolean displayDonateFlag;
	
	private Date smClearDt;
	
	// Property accessors
	@Id
 	@GeneratedValue(generator="system-uuid")
 	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "RENTAL_CLR_REC_ID", unique = true, nullable = false, length = 50)
	public String getRowId() {
		return this.rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "RENTAL_PAYMENT_ID", length = 50)
	public String getRentalPaymentId() {
		return this.rentalPaymentId;
	}

	public void setRentalPaymentId(String rentalPaymentId) {
		this.rentalPaymentId = rentalPaymentId;
	}

	@Column(name = "PAYMENT_GROUP_NO", length = 50)
	public String getPaymentGroupNo() {
		return this.paymentGroupNo;
	}

	public void setPaymentGroupNo(String paymentGroupNo) {
		this.paymentGroupNo = paymentGroupNo;
	}

	@Column(name = "PAYMENT_DOC_NO", length = 50)
	public String getPaymentDocNo() {
		return this.paymentDocNo;
	}

	public void setPaymentDocNo(String paymentDocNo) {
		this.paymentDocNo = paymentDocNo;
	}

	@Column(name = "DEPOSIT_DETAIL_ID", length = 50)
	public String getDepositDetailId() {
		return this.depositDetailId;
	}

	public void setDepositDetailId(String depositDetailId) {
		this.depositDetailId = depositDetailId;
	}

	@Column(name = "COMPANY", nullable = false, length = 5)
	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "SITE_INFO_ID", length = 50)
	public String getSiteInfoId() {
		return this.siteInfoId;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}

	@Column(name = "RECEIPT_NO", length = 20)
	public String getReceiptNo() {
		return this.receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

	@Column(name = "TAX_INVOICE_NO", length = 20)
	public String getTaxInvoiceNo() {
		return this.taxInvoiceNo;
	}

	public void setTaxInvoiceNo(String taxInvoiceNo) {
		this.taxInvoiceNo = taxInvoiceNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TAX_INVOICE_DT", length = 7)
	public Date getTaxInvoiceDt() {
		return this.taxInvoiceDt;
	}

	public void setTaxInvoiceDt(Date taxInvoiceDt) {
		this.taxInvoiceDt = taxInvoiceDt;
	}

	@Column(name = "REMARK", length = 250)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "CLR_RECEIPT_STATUS", length = 20)
	public String getClrReceiptStatus() {
		return this.clrReceiptStatus;
	}

	public void setClrReceiptStatus(String clrReceiptStatus) {
		this.clrReceiptStatus = clrReceiptStatus;
	}

	@Column(name = "BATCH_NO", length = 20)
	public String getBatchNo() {
		return this.batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	@Column(name = "EXPORT_STATUS", length = 18)
	public String getExportStatus() {
		return this.exportStatus;
	}

	public void setExportStatus(String exportStatus) {
		this.exportStatus = exportStatus;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EXPORT_DT", length = 7)
	public Date getExportDt() {
		return this.exportDt;
	}

	public void setExportDt(Date exportDt) {
		this.exportDt = exportDt;
	}

	@Column(name = "CLR_REJECT_REASON", length = 250)
	public String getClrRejectReason() {
		return this.clrRejectReason;
	}

	public void setClrRejectReason(String clrRejectReason) {
		this.clrRejectReason = clrRejectReason;
	}

	@Column(name = "RECORD_STATUS", length = 1)
	public String getRecordStatus() {
		return this.recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	@Column(name = "RECEIPT_STATUS")
	public String getReceiptStatus() {
		return receiptStatus;
	}

	public void setReceiptStatus(String receiptStatus) {
		this.receiptStatus = receiptStatus;
	}

	@Version
	@Column(name = "VERSION", precision = 10, scale = 0 , nullable = false)
	public Long getVersion() {
		return this.version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Override
	@Column(name = "CREATE_DT")
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
	@Column(name = "UPDATE_DT")
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

	@Transient
	public Double getSumAmt() {
		return sumAmt;
	}

	public void setSumAmt(Double sumAmt) {
		this.sumAmt = sumAmt;
	}

	@Transient
	public String getVatType() {
		return vatType;
	}

	public void setVatType(String vatType) {
		this.vatType = vatType;
	}

	@Column(name = "NOT_CLR_FLAG", length = 1)
	public String getNotClrFlag() {
		return notClrFlag;
	}

	public void setNotClrFlag(String notClrFlag) {
		this.notClrFlag = notClrFlag;
	}

	@Column(name = "DONATE_FLAG", length = 1)
	public String getDonateFlag() {
		return donateFlag;
	}

	public void setDonateFlag(String donateFlag) {
		this.donateFlag = donateFlag;
	}

	@Transient
	public boolean isDonateFlagBoolean() {
		return donateFlagBoolean;
	}

	public void setDonateFlagBoolean(boolean donateFlagBoolean) {
		this.donateFlagBoolean = donateFlagBoolean;
	}

	@Transient
	public boolean isDisplayDonateFlag() {
		return displayDonateFlag;
	}

	public void setDisplayDonateFlag(boolean displayDonateFlag) {
		this.displayDonateFlag = displayDonateFlag;
	}
	
	@Column(name = "SM_CLEAR_DT")
	public Date getSmClearDt() {
		return smClearDt;
	}

	public void setSmClearDt(Date smClearDt) {
		this.smClearDt = smClearDt;
	}

}