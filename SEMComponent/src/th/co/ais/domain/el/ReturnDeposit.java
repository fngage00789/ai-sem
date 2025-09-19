package th.co.ais.domain.el;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import th.co.ais.domain.AbstractDomain;

@Entity(name="th.co.ais.domain.el.ReturnDeposit")
@Table(name="SEM_EL_RETURN_DEPOSIT", schema="SEM")
public class ReturnDeposit extends AbstractDomain {

	private static final long serialVersionUID = -447751008177283669L;
	
	private String rowId;
	private Payment paymentId;
	private DepositDetail depositDetailId;
	private String siteInfoId;
	private String depositType;
	private String depositStatus;
	private String returnType;
	private String bgNo;
	private String bankName;
	private String vendorId;
	private String vendorName;
	private BigDecimal depositAmt;
	private String vatType;
	private BigDecimal vatRate;
	private BigDecimal vatAmt;
	private BigDecimal depositTotAmt;
	private BigDecimal returnAmt;
	private String remark;
	private String receiptNo;
	private String taxInvoiceNo;
	private String docClear;
	private Date docClearDate;
	private String recordStatus;
	private String version;

	@Id
   	@GeneratedValue(generator="system-uuid")
   	@GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="RETURN_DEPOSIT_ID")			
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PAYMENT_ID", nullable = false)
	public Payment getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Payment paymentId) {
		this.paymentId = paymentId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEPOSIT_DETAIL_ID", nullable = false)
	public DepositDetail getDepositDetailId() {
		return depositDetailId;
	}
	public void setDepositDetailId(DepositDetail depositDetailId) {
		this.depositDetailId = depositDetailId;
	}
	
	@Column(name="SITE_INFO_ID")
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	
	@Column(name="DEPOSIT_TYPE")
	public String getDepositType() {
		return depositType;
	}
	public void setDepositType(String depositType) {
		this.depositType = depositType;
	}
	
	@Column(name="DEPOSIT_STATUS")
	public String getDepositStatus() {
		return depositStatus;
	}
	public void setDepositStatus(String depositStatus) {
		this.depositStatus = depositStatus;
	}
	
	@Column(name="RETURN_TYPE")
	public String getReturnType() {
		return returnType;
	}
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
	
	@Column(name="BG_NO")
	public String getBgNo() {
		return bgNo;
	}
	public void setBgNo(String bgNo) {
		this.bgNo = bgNo;
	}
	
	@Column(name="BANK_NAME")
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	@Column(name="VENDOR_ID")
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	
	@Column(name="VENDOR_NAME")
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	
	@Column(name="DEPOSIT_AMT")
	public BigDecimal getDepositAmt() {
		return depositAmt;
	}
	public void setDepositAmt(BigDecimal depositAmt) {
		this.depositAmt = depositAmt;
	}
	
	@Column(name="VAT_TYPE")
	public String getVatType() {
		return vatType;
	}
	public void setVatType(String vatType) {
		this.vatType = vatType;
	}
	
	@Column(name="VAT_RATE")
	public BigDecimal getVatRate() {
		return vatRate;
	}
	public void setVatRate(BigDecimal vatRate) {
		this.vatRate = vatRate;
	}
	
	@Column(name="VAT_AMT")
	public BigDecimal getVatAmt() {
		return vatAmt;
	}
	public void setVatAmt(BigDecimal vatAmt) {
		this.vatAmt = vatAmt;
	}
	
	@Column(name="DEPOSIT_TOT_AMT")
	public BigDecimal getDepositTotAmt() {
		return depositTotAmt;
	}
	public void setDepositTotAmt(BigDecimal depositTotAmt) {
		this.depositTotAmt = depositTotAmt;
	}
	
	@Column(name="RETURN_AMT")
	public BigDecimal getReturnAmt() {
		return returnAmt;
	}
	public void setReturnAmt(BigDecimal returnAmt) {
		this.returnAmt = returnAmt;
	}
	
	@Column(name="REMARK")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(name="RECEIPT_NO")
	public String getReceiptNo() {
		return receiptNo;
	}
	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}
	
	@Column(name="TAX_INVOICE_NO")
	public String getTaxInvoiceNo() {
		return taxInvoiceNo;
	}
	public void setTaxInvoiceNo(String taxInvoiceNo) {
		this.taxInvoiceNo = taxInvoiceNo;
	}
	
	@Column(name="DOC_CLEAR")
	public String getDocClear() {
		return docClear;
	}
	public void setDocClear(String docClear) {
		this.docClear = docClear;
	}
	
	@Column(name="DOC_CLEAR_DATE")
	public Date getDocClearDate() {
		return docClearDate;
	}
	public void setDocClearDate(Date docClearDate) {
		this.docClearDate = docClearDate;
	}
	
	@Column(name="RECORD_STATUS")
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	
	@Column(name="VERSION")
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
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
	
}
