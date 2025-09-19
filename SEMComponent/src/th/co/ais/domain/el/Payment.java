package th.co.ais.domain.el;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.GenericGenerator;

import th.co.ais.domain.AbstractDomain;
import th.co.ais.domain.si.Contract;

	
@Entity
@Table(name="SEM_EL_PAYMENT", schema="SEM")
public class Payment  extends AbstractDomain {
	private static final long serialVersionUID = -7485992463289088321L;
	private static final SimpleDateFormat exportFormat = new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));
	
	private String rowId;
	private Management electricId;
	private DepositDetail depositDetailId;
	private String payNo;
	private String paySumNo;
	private String contractNo;
	private String oldContractNo;
	private String company;
	private String siteInfoId;
	private String siteName;
	private String locationId;
	private String locationCode;
	private String siteType;
	private String region;
	private String siteStatus;
	private String netWorkStatus;
	private String electricUseType;
	private Date warrantPrintDt;
	private String expenseType;
	private String expenseTypeDisplay;
	private String docType;
	private String docNo;
	private Date docDt;
	private String refDocType;
	private String refDocNo;
	private Date refDocDt;
	private BigDecimal invTotalSite;
	private BigDecimal invTotalExcludeVat;
	private BigDecimal invTotalVat;
	private BigDecimal invTotalIncludeVat;
	private BigDecimal dbTotalSite;
	private BigDecimal dbTotalExcludeVat;
	private BigDecimal dbTotalVat;
	private BigDecimal dbTotalIncludeVat;
	private BigDecimal noDbTotalSite;
	private BigDecimal noDbTotalExcludeVat;
	private BigDecimal noDbTotalVat;
	private BigDecimal noDbIncludeVat;
	private BigDecimal payAmt;
	private String vatType;
	private BigDecimal vatRate;
	private BigDecimal vatAmt;
	private String whtType;
	private BigDecimal whtRate;
	private BigDecimal whtAmt;
	private BigDecimal excludeVatAmt;
	private BigDecimal includeVatAmt;
	private BigDecimal includeVatAmtCR;
	private Date depositPeriodDt;
	private BigDecimal depositAmt;
	private String vendorId;
	private String vendorName;
	private String payeeId;
	private String payeeName;
	private String paymentType;
	private String paymentMethod;
	private String bankName;
	private String bankAccount;
	private String chqNo;
	private String chqBank;
	private BigDecimal chqAmt;
	private Date chqPostingDt;
	private Date chqReceivedDt;
	private String chqClearingStatus;
	private Date chqClearingDt;
	private Date transferDt;
	private String exportFlag;
	private Date exportDt;
	private String remark;
	private Date sentPaymentDt;
	private String electricPayStatus;
	private String paymentStatus;
	private String doc68;
	private String doc92;
	private String accApprove;
	private String rejectStatus;
	private String recordStatus;
	private BigDecimal version;
	
	private String paymentTypeTxt;
	private String paymentMethodTxt;
	private String oldPaymentTypeTxt;
	private String oldPaymentMethodTxt;
	private String electricUseTypeTxt;
	private String expenseTypeTxt;
	private String refDocTypeTxt;
	private String docTypeDisplay;
	private String paymentStatusDisplay;
	private String whtCheck;
	private String vatTypeTxt;
	
	private Set<PaymentDetail> details;
	private int totalExpense;
	private int totalMeterExpense;
	
	private String batchNo;
	private String collectiveDbNo;
	private String collectiveDbFlag;
	private String rejectReason;
	private List<PaymentDetail> paymentDetailList;
	private String crBankName;
	private Date crPayInDt;
	private String crPayInFlag;
	private boolean enableEditButton;
	private String specialFlag;
	private String vendorType;//WT###Add 20110202
	//WT###Add 20110203 Start
	private String oldVendorIdTypeV;
	private String oldVendorNameTypeV;
	private String oldPayeeIdTypeV;
	private String oldPayeeNameTypeV;
	private String oldPaymentMethodTypeV;
	private String oldPaymentTypeTypeV;
	private String oldBankAccountTypeV;
	private String oldBankNameTypeV;
	
	private String oldVendorIdTypeS;
	private String oldVendorNameTypeS;
	private String oldPayeeIdTypeS;
	private String oldPayeeNameTypeS;
	private String oldPaymentMethodTypeS;
	private String oldPaymentTypeTypeS;
	private String oldBankAccountTypeS;
	private String oldBankNameTypeS;
	private Date   docDtFrom;
	private Date   docDtTo;
	private String monthDetailDisplay;
	
	//WT###Add 20110203 End
	private BigDecimal invPayAmt;
	

	// Add new for button 7
	private String crPayinChqNo;
	private BigDecimal crPayinAmt;	 
	private String crBankNo;
	//private Date crPayinDt;
	private String crCreditFlag;
	
	private String transID;
	private BigDecimal elBillPayAmt;
	private String orderBy;//WT###Add 20110426
	private String elImportStatus;
	private String elImportStatusDetail;
	private String payment_channel;
	
	private Contract contract;
	private MeterInfo meterInfo;
	private String siteStatusDisplay;
	private String networkStatusDisplay;
	private String doc69;
	private String expenseTypeCode;
	private Date displayCreateDate;
	private Date displayUpdateDate;
	private String siteStatusShow;
	private String netWorkStatusShow;
	private String expenseTypeShow;
	private String paymentStatusShow;
	private String docTypeShow;
	private String vatTypeShow;
	private String paymentTypeShow;
	private String paymentMethodShow;
	private Date effDt;
	private Date effDtTH;
	private Date expDt;
	private Date expDtTH;
	
	
	// added by.. YUT 2014/09/10
	private Double rcptPayCutAmount;
	private boolean chkRcptPay;
	private String rcptPayFlag;
	
	private String paymentId;
	private String sendInfoStatus;
	
	
	private String elCondSubType;
	private String siteCode;
	private String siteId;
	private String service;
	private Date periodStartDt;
	private Date periodEndDt;
	
	private String serviceType;
	private String receiptNo;
	private String contFlowStatus;
	private String strParam;
	
	@Id
  	@GeneratedValue(generator="system-uuid")
  	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "PAYMENT_ID")	
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	
	@OneToMany (mappedBy = "paymentId" ,cascade = CascadeType.ALL )
	@org.hibernate.annotations.OrderBy(clause = "FROM_TERM_OF_PAYMENT_DT desc") 
	public Set<PaymentDetail> getDetails() {
		return details;
	}
	public void setDetails(Set<PaymentDetail> details) {
		this.details = details;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ELECTRIC_ID")
	public Management getElectricId() {
		return electricId;
	}
	public void setElectricId(Management electricId) {
		this.electricId = electricId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "DEPOSIT_DETAIL_ID")
	
	public DepositDetail getDepositDetailId() {
		return depositDetailId;
	}
	public void setDepositDetailId(DepositDetail depositDetailId) {
		this.depositDetailId = depositDetailId;
	}
	
	@Column(name = "PAY_NO")
	public String getPayNo() {
		return payNo;
	}
	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}
	
	@Column(name = "PAY_SUM_NO")
	public String getPaySumNo() {
		return paySumNo;
	}
	public void setPaySumNo(String paySumNo) {
		this.paySumNo = paySumNo;
	}
	
	@Column(name = "CONTRACT_NO")
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	
	@Column(name = "OLD_CONTRACT_NO")
	public String getOldContractNo() {
		return oldContractNo;
	}
	public void setOldContractNo(String oldContractNo) {
		this.oldContractNo = oldContractNo;
	}
	
	@Column(name = "COMPANY")
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	@Column(name = "SITE_INFO_ID")
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	
	@Column(name = "SITE_NAME")
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	
	@Column(name = "LOCATION_ID")
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	
	@Column(name = "LOCATION_CODE")
	public String getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	
	@Column(name = "SITE_TYPE")
	public String getSiteType() {
		return siteType;
	}
	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}
	

	@Column(name = "REGION")
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	@Column(name = "SITE_STATUS")
	public String getSiteStatus() {
		return siteStatus;
	}
	public void setSiteStatus(String siteStatus) {
		this.siteStatus = siteStatus;
	}
	
	@Column(name = "NETWORK_STATUS")
	public String getNetWorkStatus() {
		return netWorkStatus;
	}
	public void setNetWorkStatus(String netWorkStatus) {
		this.netWorkStatus = netWorkStatus;
	}
	
	@Column(name = "ELECTRIC_USE_TYPE")
	public String getElectricUseType() {
		return electricUseType;
	}
	public void setElectricUseType(String electricUseType) {
		this.electricUseType = electricUseType;
	}
	
	@Column(name = "WARRANT_PRINT_DT")
	public Date getWarrantPrintDt() {
		return warrantPrintDt;
	}
	public void setWarrantPrintDt(Date warrantPrintDt) {
		this.warrantPrintDt = warrantPrintDt;
	}
	
	@Column(name = "EXPENSE_TYPE")
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	
	@Column(name = "DOC_TYPE")
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	
	@Column(name = "DOC_NO")
	public String getDocNo() {
		return docNo;
	}
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	
	@Column(name = "DOC_DT")
	public Date getDocDt() {
		return docDt;
	}
	public void setDocDt(Date docDt) {
		this.docDt = docDt;
	}
	
	@Column(name = "REF_DOC_TYPE")
	public String getRefDocType() {
		return refDocType;
	}
	public void setRefDocType(String refDocType) {
		this.refDocType = refDocType;
	}
	
	@Column(name = "REF_DOC_NO")
	public String getRefDocNo() {
		return refDocNo;
	}
	public void setRefDocNo(String refDocNo) {
		this.refDocNo = refDocNo;
	}
	
	@Column(name = "REF_DOC_DT")
	public Date getRefDocDt() {
		return refDocDt;
	}
	public void setRefDocDt(Date refDocDt) {
		this.refDocDt = refDocDt;
	}
	
	@Column(name = "INV_TOTAL_SITE")
	public BigDecimal getInvTotalSite() {
		return invTotalSite;
	}
	public void setInvTotalSite(BigDecimal invTotalSite) {
		this.invTotalSite = invTotalSite;
	}
	
	@Column(name = "INV_TOTAL_EXCLUDE_VAT")
	public BigDecimal getInvTotalExcludeVat() {
		return invTotalExcludeVat;
	}
	public void setInvTotalExcludeVat(BigDecimal invTotalExcludeVat) {
		this.invTotalExcludeVat = invTotalExcludeVat;
	}
	
	@Column(name = "INV_TOTAL_VAT")
	public BigDecimal getInvTotalVat() {
		return invTotalVat;
	}
	public void setInvTotalVat(BigDecimal invTotalVat) {
		this.invTotalVat = invTotalVat;
	}
	
	@Column(name = "INV_TOTAL_INCLUDE_VAT")
	public BigDecimal getInvTotalIncludeVat() {
		return invTotalIncludeVat;
	}
	public void setInvTotalIncludeVat(BigDecimal invTotalIncludeVat) {
		this.invTotalIncludeVat = invTotalIncludeVat;
	}
	
	@Column(name = "DB_TOTAL_SITE")
	public BigDecimal getDbTotalSite() {
		return dbTotalSite;
	}
	public void setDbTotalSite(BigDecimal dbTotalSite) {
		this.dbTotalSite = dbTotalSite;
	}
	
	@Column(name = "DB_TOTAL_EXCLUDE_VAT")
	public BigDecimal getDbTotalExcludeVat() {
		return dbTotalExcludeVat;
	}
	public void setDbTotalExcludeVat(BigDecimal dbTotalExcludeVat) {
		this.dbTotalExcludeVat = dbTotalExcludeVat;
	}
	
	@Column(name = "DB_TOTAL_VAT")
	public BigDecimal getDbTotalVat() {
		return dbTotalVat;
	}
	public void setDbTotalVat(BigDecimal dbTotalVat) {
		this.dbTotalVat = dbTotalVat;
	}
	
	@Column(name = "DB_TOTAL_INCLUDE_VAT")
	public BigDecimal getDbTotalIncludeVat() {
		return dbTotalIncludeVat;
	}
	public void setDbTotalIncludeVat(BigDecimal dbTotalIncludeVat) {
		this.dbTotalIncludeVat = dbTotalIncludeVat;
	}
	
	@Column(name = "NO_DB_TOTAL_SITE")
	public BigDecimal getNoDbTotalSite() {
		return noDbTotalSite;
	}
	public void setNoDbTotalSite(BigDecimal noDbTotalSite) {
		this.noDbTotalSite = noDbTotalSite;
	}
	
	@Column(name = "NO_DB_TOTAL_EXCLUDE_VAT")
	public BigDecimal getNoDbTotalExcludeVat() {
		return noDbTotalExcludeVat;
	}
	public void setNoDbTotalExcludeVat(BigDecimal noDbTotalExcludeVat) {
		this.noDbTotalExcludeVat = noDbTotalExcludeVat;
	}
	
	@Column(name = "NO_DB_TOTAL_VAT")
	public BigDecimal getNoDbTotalVat() {
		return noDbTotalVat;
	}
	public void setNoDbTotalVat(BigDecimal noDbTotalVat) {
		this.noDbTotalVat = noDbTotalVat;
	}
	
	@Column(name = "NO_DB_INCLUDE_VAT")
	public BigDecimal getNoDbIncludeVat() {
		return noDbIncludeVat;
	}
	public void setNoDbIncludeVat(BigDecimal noDbIncludeVat) {
		this.noDbIncludeVat = noDbIncludeVat;
	}
	
	@Column(name = "PAY_AMT")
	public BigDecimal getPayAmt() {
		return payAmt;
	}
	public void setPayAmt(BigDecimal payAmt) {
		this.payAmt = payAmt;
	}
	
	@Column(name = "VAT_TYPE")
	public String getVatType() {
		return vatType;
	}
	public void setVatType(String vatType) {
		this.vatType = vatType;
	}
	
	@Column(name = "VAT_RATE")
	public BigDecimal getVatRate() {
		return vatRate;
	}
	public void setVatRate(BigDecimal vatRate) {
		this.vatRate = vatRate;
	}
	
	@Column(name = "VAT_AMT")
	public BigDecimal getVatAmt() {
		return vatAmt;
	}
	public void setVatAmt(BigDecimal vatAmt) {
		this.vatAmt = vatAmt;
	}
	
	@Column(name = "WHT_TYPE")
	public String getWhtType() {
		return whtType;
	}
	public void setWhtType(String whtType) {
		this.whtType = whtType;
	}
	
	@Column(name = "WHT_RATE")
	public BigDecimal getWhtRate() {
		return whtRate;
	}
	public void setWhtRate(BigDecimal whtRate) {
		this.whtRate = whtRate;
	}
	
	@Column(name = "WHT_AMT")
	public BigDecimal getWhtAmt() {
		return whtAmt;
	}
	public void setWhtAmt(BigDecimal whtAmt) {
		this.whtAmt = whtAmt;
	}
	
	@Column(name = "EXCLUDE_VAT_AMT")
	public BigDecimal getExcludeVatAmt() {
		return excludeVatAmt;
	}
	public void setExcludeVatAmt(BigDecimal excludeVatAmt) {
		this.excludeVatAmt = excludeVatAmt;
	}
	
	@Column(name = "INCLUDE_VAT_AMT")
	public BigDecimal getIncludeVatAmt() {
		return includeVatAmt;
	}
	public void setIncludeVatAmt(BigDecimal includeVatAmt) {
		this.includeVatAmt = includeVatAmt;
	}
	
	@Column(name = "DEPOSIT_PERIOD_DT")
	public Date getDepositPeriodDt() {
		return depositPeriodDt;
	}
	public void setDepositPeriodDt(Date depositPeriodDt) {
		this.depositPeriodDt = depositPeriodDt;
	}
	
	@Column(name = "DEPOSIT_AMT")
	public BigDecimal getDepositAmt() {
		return depositAmt;
	}
	public void setDepositAmt(BigDecimal depositAmt) {
		this.depositAmt = depositAmt;
	}
	
	@Column(name = "VENDOR_ID")
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	
	@Column(name = "VENDOR_NAME")
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	
	@Column(name = "PAYEE_ID")
	public String getPayeeId() {
		return payeeId;
	}
	public void setPayeeId(String payeeId) {
		this.payeeId = payeeId;
	}
	
	@Column(name = "PAYEE_NAME")
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	
	@Column(name = "PAYMENT_TYPE")
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	@Column(name = "PAYMENT_METHOD")
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	@Column(name = "BANK_NAME")
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	@Column(name = "BANK_ACCOUNT")
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	@Column(name = "CHQ_NO")
	public String getChqNo() {
		return chqNo;
	}
	public void setChqNo(String chqNo) {
		this.chqNo = chqNo;
	}
	
	@Column(name = "CHQ_BANK")
	public String getChqBank() {
		return chqBank;
	}
	public void setChqBank(String chqBank) {
		this.chqBank = chqBank;
	}
	
	@Column(name = "CHQ_AMT")
	public BigDecimal getChqAmt() {
		return chqAmt;
	}
	public void setChqAmt(BigDecimal chqAmt) {
		this.chqAmt = chqAmt;
	}
	
	@Column(name = "CHQ_POSTING_DT")
	public Date getChqPostingDt() {
		return chqPostingDt;
	}
	public void setChqPostingDt(Date chqPostingDt) {
		this.chqPostingDt = chqPostingDt;
	}
	
	@Column(name = "CHQ_RECEIVED_DT")
	public Date getChqReceivedDt() {
		return chqReceivedDt;
	}
	public void setChqReceivedDt(Date chqReceivedDt) {
		this.chqReceivedDt = chqReceivedDt;
	}
	
	@Column(name = "CHQ_CLEARING_STATUS")
	public String getChqClearingStatus() {
		return chqClearingStatus;
	}
	public void setChqClearingStatus(String chqClearingStatus) {
		this.chqClearingStatus = chqClearingStatus;
	}
	
	@Column(name = "CHQ_CLEARING_DT")
	public Date getChqClearingDt() {
		return chqClearingDt;
	}
	public void setChqClearingDt(Date chqClearingDt) {
		this.chqClearingDt = chqClearingDt;
	}
	
	@Column(name = "TRANSFER_DT")
	public Date getTransferDt() {
		return transferDt;
	}
	public void setTransferDt(Date transferDt) {
		this.transferDt = transferDt;
	}
	
	@Column(name = "EXPORT_FLAG")
	public String getExportFlag() {
		return exportFlag;
	}
	public void setExportFlag(String exportFlag) {
		this.exportFlag = exportFlag;
	}
	
	@Column(name = "EXPORT_DT")
	public Date getExportDt() {
		return exportDt;
	}
	public void setExportDt(Date exportDt) {
		this.exportDt = exportDt;
	}
	
	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(name = "SENT_PAYMENT_DT")
	public Date getSentPaymentDt() {
		return sentPaymentDt;
	}
	public void setSentPaymentDt(Date sentPaymentDt) {
		this.sentPaymentDt = sentPaymentDt;
	}
	
	@Column(name = "ELECTRIC_PAY_STATUS")
	public String getElectricPayStatus() {
		return electricPayStatus;
	}
	public void setElectricPayStatus(String electricPayStatus) {
		this.electricPayStatus = electricPayStatus;
	}
	
	@Column(name = "PAYMENT_STATUS")
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	@Column(name = "DOC_68")
	public String getDoc68() {
		return doc68;
	}
	public void setDoc68(String doc68) {
		this.doc68 = doc68;
	}
	
	@Column(name = "DOC_92")
	public String getDoc92() {
		return doc92;
	}
	public void setDoc92(String doc92) {
		this.doc92 = doc92;
	}
	
	@Column(name = "ACC_APPROVE")
	public String getAccApprove() {
		return accApprove;
	}
	public void setAccApprove(String accApprove) {
		this.accApprove = accApprove;
	}
	
	@Column(name = "REJECT_STATUS")
	public String getRejectStatus() {
		return rejectStatus;
	}
	public void setRejectStatus(String rejectStatus) {
		this.rejectStatus = rejectStatus;
	}
	
	@Column(name = "RECORD_STATUS")
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	
	@Column(name = "VERSION")
	public BigDecimal getVersion() {
		return version;
	}
	public void setVersion(BigDecimal version) {
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
	
	@Transient
	public String getExpenseTypeDisplay() {
		return expenseTypeDisplay;
	}
	public void setExpenseTypeDisplay(String expenseTypeDisplay) {
		this.expenseTypeDisplay = expenseTypeDisplay;
	}
	
	@Transient
	public int getTotalExpense() {
		return totalExpense;
	}
	public void setTotalExpense(int totalExpense) {
		this.totalExpense = totalExpense;
	}

	
	@Transient
	public int getTotalMeterExpense() {
		return totalMeterExpense;
	}
	public void setTotalMeterExpense(int totalMeterExpense) {
		this.totalMeterExpense = totalMeterExpense;
	}
	@Transient
	public String getPaymentTypeTxt() {
		return paymentTypeTxt;
	}
	public void setPaymentTypeTxt(String paymentTypeTxt) {
		this.paymentTypeTxt = paymentTypeTxt;
	}
	@Transient
	public String getPaymentMethodTxt() {
		return paymentMethodTxt;
	}
	public void setPaymentMethodTxt(String paymentMethodTxt) {
		this.paymentMethodTxt = paymentMethodTxt;
	}
	@Transient
	public String getElectricUseTypeTxt() {
		return electricUseTypeTxt;
	}
	public void setElectricUseTypeTxt(String electricUseTypeTxt) {
		this.electricUseTypeTxt = electricUseTypeTxt;
	}
	@Transient
	public String getExpenseTypeTxt() {
		return expenseTypeTxt;
	}
	public void setExpenseTypeTxt(String expenseTypeTxt) {
		this.expenseTypeTxt = expenseTypeTxt;
	}
	@Transient
	public String getRefDocTypeTxt() {
		return refDocTypeTxt;
	}
	public void setRefDocTypeTxt(String refDocTypeTxt) {
		this.refDocTypeTxt = refDocTypeTxt;
	}
	
	@Column(name = "BATCH_NO")
	public String getBatchNo() {
		return batchNo;
	}
	
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	
	@Column(name = "COLLECTIVE_DB_NO")
	public String getCollectiveDbNo() {
		return collectiveDbNo;
	}
	
	public void setCollectiveDbNo(String collectiveDbNo) {
		this.collectiveDbNo = collectiveDbNo;
	}
	
	@Column(name = "COLLECTIVE_DB_FLAG")
	public String getCollectiveDbFlag() {
		return collectiveDbFlag;
	}
	
	public void setCollectiveDbFlag(String collectiveDbFlag) {
		this.collectiveDbFlag = collectiveDbFlag;
	}
	
	@Column(name = "REJECT_REASON")
	public String getRejectReason() {
		return rejectReason;
	}
	
	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	@Column(name = "CR_BANK_NAME")
	public String getCrBankName() {
		return crBankName;
	}
	
	public void setCrBankName(String crBankName) {
		this.crBankName = crBankName;
	}
	
	@Column(name = "CR_PAY_IN_DT")
	public Date getCrPayInDt() {
		return crPayInDt;
	}
	
	public void setCrPayInDt(Date crPayInDt) {
		this.crPayInDt = crPayInDt;
	}
	
	@Column(name = "CR_PAY_IN_FLAG")
	public String getCrPayInFlag() {
		return crPayInFlag;
	}
	
	public void setCrPayInFlag(String crPayInFlag) {
		this.crPayInFlag = crPayInFlag;
	}
	
	@Transient
	public List<PaymentDetail> getPaymentDetailList() {
		return paymentDetailList;
	}
	public void setPaymentDetailList(List<PaymentDetail> paymentDetailList) {
		this.paymentDetailList = paymentDetailList;
	}
	@Transient
	public String getDocTypeDisplay() {
		return docTypeDisplay;
	}
	public void setDocTypeDisplay(String docTypeDisplay) {
		this.docTypeDisplay = docTypeDisplay;
	}
	@Transient
	public String getChqPostingDtTH() {
		return chqPostingDt!=null?exportFormat.format(chqPostingDt):"";
	}
	@Transient
	public String getChqReceivedDtTH() {
		return chqReceivedDt!=null?exportFormat.format(chqReceivedDt):"";
	}
	@Transient
	public String getDocDtTH() {
		return docDt!=null?exportFormat.format(docDt):"";
	}
	@Transient
	public String getTransferDtTH() {
		return transferDt!=null?exportFormat.format(transferDt):"";
	}
	
	@Transient
	public String getChqClearingDtTH() {
		return chqClearingDt!=null?exportFormat.format(chqClearingDt):"";
	}
	@Transient
	public String getRefDocDtTH() {
		return refDocDt!=null?exportFormat.format(refDocDt):"";
	}
	
	@Transient
	public boolean isCrPayInFlagBoolean(){
		
		return crPayInFlag != null && crPayInFlag.equals("Y") ? true : false;
	}
	
	
	public void setCrPayInFlagBoolean(boolean crPayInFlagBoolean){
		
		if(crPayInFlagBoolean) setCrPayInFlag("Y");
		else setCrPayInFlag("N");
	}
	
	@Transient
	public boolean isEnableEditButton() {
		return enableEditButton;
	}
	public void setEnableEditButton(boolean enableEditButton) {
		this.enableEditButton = enableEditButton;
	}
	
	@Transient
	public String getPaymentStatusDisplay() {
		return paymentStatusDisplay;
	}
	public void setPaymentStatusDisplay(String paymentStatusDisplay) {
		this.paymentStatusDisplay = paymentStatusDisplay;
	}
	@Transient
	public String getWhtCheck() {
		return whtCheck;
	}
	public void setWhtCheck(String whtCheck) {
		this.whtCheck = whtCheck;
	}

	@Transient
	public boolean isWhtCheckBoolean(){		
		return getWhtCheck() != null && getWhtCheck().equalsIgnoreCase("y");
	}

	public void setWhtCheckBoolean(boolean flag){		
		if(flag) setWhtCheck("Y");
		else setWhtCheck("N");
	}
	@Transient
	public String getVatTypeTxt() {
		return vatTypeTxt;
	}
	public void setVatTypeTxt(String vatTypeTxt) {
		this.vatTypeTxt = vatTypeTxt;
	}
	
	@Column(name = "SPECIAL_FLAG")
	public String getSpecialFlag() {
		return specialFlag;
	}
	public void setSpecialFlag(String specialFlag) {
		this.specialFlag = specialFlag;
	}
	
	@Column(name = "VENDOR_TYPE")
	public String getVendorType() {
		return vendorType;
	}
	public void setVendorType(String vendorType) {
		this.vendorType = vendorType;
	}
	
	@Transient
	public String getOldVendorIdTypeV() {
		return oldVendorIdTypeV;
	}
	public void setOldVendorIdTypeV(String oldVendorIdTypeV) {
		this.oldVendorIdTypeV = oldVendorIdTypeV;
	}
	
	@Transient
	public String getOldVendorNameTypeV() {
		return oldVendorNameTypeV;
	}
	public void setOldVendorNameTypeV(String oldVendorNameTypeV) {
		this.oldVendorNameTypeV = oldVendorNameTypeV;
	}
	
	@Transient
	public String getOldPayeeIdTypeV() {
		return oldPayeeIdTypeV;
	}
	public void setOldPayeeIdTypeV(String oldPayeeIdTypeV) {
		this.oldPayeeIdTypeV = oldPayeeIdTypeV;
	}
	
	@Transient
	public String getOldPayeeNameTypeV() {
		return oldPayeeNameTypeV;
	}
	public void setOldPayeeNameTypeV(String oldPayeeNameTypeV) {
		this.oldPayeeNameTypeV = oldPayeeNameTypeV;
	}
	
	@Transient
	public String getOldVendorIdTypeS() {
		return oldVendorIdTypeS;
	}
	public void setOldVendorIdTypeS(String oldVendorIdTypeS) {
		this.oldVendorIdTypeS = oldVendorIdTypeS;
	}
	
	@Transient
	public String getOldVendorNameTypeS() {
		return oldVendorNameTypeS;
	}
	public void setOldVendorNameTypeS(String oldVendorNameTypeS) {
		this.oldVendorNameTypeS = oldVendorNameTypeS;
	}
	
	@Transient
	public String getOldPayeeIdTypeS() {
		return oldPayeeIdTypeS;
	}
	public void setOldPayeeIdTypeS(String oldPayeeIdTypeS) {
		this.oldPayeeIdTypeS = oldPayeeIdTypeS;
	}
	
	@Transient
	public String getOldPayeeNameTypeS() {
		return oldPayeeNameTypeS;
	}
	public void setOldPayeeNameTypeS(String oldPayeeNameTypeS) {
		this.oldPayeeNameTypeS = oldPayeeNameTypeS;
	}
	
	@Transient
	public String getOldPaymentMethodTypeV() {
		return oldPaymentMethodTypeV;
	}
	public void setOldPaymentMethodTypeV(String oldPaymentMethodTypeV) {
		this.oldPaymentMethodTypeV = oldPaymentMethodTypeV;
	}
	
	@Transient
	public String getOldPaymentTypeTypeV() {
		return oldPaymentTypeTypeV;
	}
	public void setOldPaymentTypeTypeV(String oldPaymentTypeTypeV) {
		this.oldPaymentTypeTypeV = oldPaymentTypeTypeV;
	}
	
	@Transient
	public String getOldBankAccountTypeV() {
		return oldBankAccountTypeV;
	}
	public void setOldBankAccountTypeV(String oldBankAccountTypeV) {
		this.oldBankAccountTypeV = oldBankAccountTypeV;
	}
	
	@Transient
	public String getOldBankNameTypeV() {
		return oldBankNameTypeV;
	}
	public void setOldBankNameTypeV(String oldBankNameTypeV) {
		this.oldBankNameTypeV = oldBankNameTypeV;
	}
	
	@Transient
	public String getOldPaymentMethodTypeS() {
		return oldPaymentMethodTypeS;
	}
	public void setOldPaymentMethodTypeS(String oldPaymentMethodTypeS) {
		this.oldPaymentMethodTypeS = oldPaymentMethodTypeS;
	}
	
	@Transient
	public String getOldPaymentTypeTypeS() {
		return oldPaymentTypeTypeS;
	}
	public void setOldPaymentTypeTypeS(String oldPaymentTypeTypeS) {
		this.oldPaymentTypeTypeS = oldPaymentTypeTypeS;
	}
	
	@Transient
	public String getOldBankAccountTypeS() {
		return oldBankAccountTypeS;
	}
	public void setOldBankAccountTypeS(String oldBankAccountTypeS) {
		this.oldBankAccountTypeS = oldBankAccountTypeS;
	}
	
	@Transient
	public String getOldBankNameTypeS() {
		return oldBankNameTypeS;
	}
	public void setOldBankNameTypeS(String oldBankNameTypeS) {
		this.oldBankNameTypeS = oldBankNameTypeS;
	}
	@Column(name = "INV_CR_AMT")
	public BigDecimal getIncludeVatAmtCR() {
		return includeVatAmtCR;
	}
	public void setIncludeVatAmtCR(BigDecimal includeVatAmtCR) {
		this.includeVatAmtCR = includeVatAmtCR;
	}
	
	@Column(name = "INV_PAY_AMT")
	public BigDecimal getInvPayAmt() {
		return invPayAmt;
	}
	
	public void setInvPayAmt(BigDecimal invPayAmt) {
		this.invPayAmt = invPayAmt;
	}
	@Transient
	public Date getDocDtFrom() {
		return docDtFrom;
	}
	public void setDocDtFrom(Date docDtFrom) {
		this.docDtFrom = docDtFrom;
	}
	@Transient
	public Date getDocDtTo() {
		return docDtTo;
	}
	
	public void setDocDtTo(Date docDtTo) {
		this.docDtTo = docDtTo;
	}
	
	@Column(name = "CR_PAY_IN_CHQ_NO")
	public String getCrPayinChqNo() {
		return crPayinChqNo;
	}
	
	public void setCrPayinChqNo(String crPayinChqNo) {
		this.crPayinChqNo = crPayinChqNo;
	}
	
	@Column(name = "CR_PAY_IN_AMT")
	public BigDecimal getCrPayinAmt() {
		return crPayinAmt;
	}
	
	public void setCrPayinAmt(BigDecimal crPayinAmt) {
		this.crPayinAmt = crPayinAmt;
	}
	
	@Column(name = "CR_BANK_NO")
	public String getCrBankNo() {
		return crBankNo;
	}
	public void setCrBankNo(String crBankNo) {
		this.crBankNo = crBankNo;
	}


	@Transient
	public boolean isCrCreditFlagBoolean(){
		
		return crCreditFlag != null && crCreditFlag.equals("Y") ? true : false;
	}
	
	public void setCrCreditFlagBoolean(boolean crCreditFlagBoolean){
		
		if(crCreditFlagBoolean) setCrCreditFlag("Y");
		else setCrCreditFlag("N");
	}
	
	@Column(name = "CR_CREDIT_FLAG")
	public String getCrCreditFlag() {
		return crCreditFlag;
	}
	public void setCrCreditFlag(String crCreditFlag) {
		this.crCreditFlag = crCreditFlag;
	}
	
	@Transient
	public String getTransID() {
		return transID;
	}
	public void setTransID(String transID) {
		this.transID = transID;
	}
	@Column(name = "EL_BILL_AMT")
	public BigDecimal getElBillPayAmt() {
		return elBillPayAmt;
	}
	public void setElBillPayAmt(BigDecimal elBillPayAmt) {
		this.elBillPayAmt = elBillPayAmt;
	}
	
	@Transient
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	@Transient
	public String getMonthDetailDisplay() {
		return monthDetailDisplay;
	}
	public void setMonthDetailDisplay(String monthDetailDisplay) {
		this.monthDetailDisplay = monthDetailDisplay;
	}
	@Column(name = "EL_IMPORT_TEXT_STATUS")
	public String getElImportStatus() {
		return elImportStatus;
	}
	public void setElImportStatus(String elImportStatus) {
		this.elImportStatus = elImportStatus;
	}
	@Transient
	public String getElImportStatusDetail() {
		return elImportStatusDetail;
	}
	
	public void setElImportStatusDetail(String elImportStatusDetail) {
		this.elImportStatusDetail = elImportStatusDetail;
	}
	@Column(name = "PAYMENT_CHANNEL")
	public String getPayment_channel() {
		return payment_channel;
	}
	public void setPayment_channel(String paymentChannel) {
		payment_channel = paymentChannel;
	}
	@Transient
	public String getOldPaymentTypeTxt() {
		return oldPaymentTypeTxt;
	}
	public void setOldPaymentTypeTxt(String oldPaymentTypeTxt) {
		this.oldPaymentTypeTxt = oldPaymentTypeTxt;
	}
	@Transient
	public String getOldPaymentMethodTxt() {
		return oldPaymentMethodTxt;
	}
	public void setOldPaymentMethodTxt(String oldPaymentMethodTxt) {
		this.oldPaymentMethodTxt = oldPaymentMethodTxt;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "SITE_INFO_ID",referencedColumnName = "SITE_INFO_ID",insertable = false,updatable = false)
	public Contract getContract() {
		return contract;
	}
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ELECTRIC_ID", referencedColumnName = "ELECTRIC_ID",insertable = false,updatable = false)
	public MeterInfo getMeterInfo() {
		return meterInfo;
	}
	public void setMeterInfo(MeterInfo meterInfo) {
		this.meterInfo = meterInfo;
	}
	@Formula("(select l.LOV_NAME from SEM_CT_LOV_MASTER l where  l.LOV_TYPE = 'SI_SITE_STATUS' and  l.LOV_CODE = SITE_STATUS)")
	public String getSiteStatusDisplay() {
		return siteStatusDisplay;
	}
	public void setSiteStatusDisplay(String siteStatusDisplay) {
		this.siteStatusDisplay = siteStatusDisplay;
	}
	@Formula("(select l.LOV_NAME from SEM_CT_LOV_MASTER l where  l.LOV_TYPE = 'CT_NETWORK_STATUS' and  l.LOV_CODE=NETWORK_STATUS)")
	public String getNetworkStatusDisplay() {
		return networkStatusDisplay;
	}
	public void setNetworkStatusDisplay(String networkStatusDisplay) {
		this.networkStatusDisplay = networkStatusDisplay;
	}
	@Column(name="DOC_CANCEL")
	public String getDoc69() {
		return doc69;
	}
	public void setDoc69(String doc69) {
		this.doc69 = doc69;
	}
	@Transient
	public String getExpenseTypeCode() {
		return expenseTypeCode;
	}
	public void setExpenseTypeCode(String expenseTypeCode) {
		this.expenseTypeCode = expenseTypeCode;
	}
	@Transient
	public Date getDisplayCreateDate() {
		return displayCreateDate;
	}
	public void setDisplayCreateDate(Date displayCreateDate) {
		this.displayCreateDate = displayCreateDate;
	}
	@Transient
	public Date getDisplayUpdateDate() {
		return displayUpdateDate;
	}
	public void setDisplayUpdateDate(Date displayUpdateDate) {
		this.displayUpdateDate = displayUpdateDate;
	}
	@Transient
	public String getSiteStatusShow() {
		return siteStatusShow;
	}
	public void setSiteStatusShow(String siteStatusShow) {
		this.siteStatusShow = siteStatusShow;
	}
	@Transient
	public String getNetWorkStatusShow() {
		return netWorkStatusShow;
	}
	public void setNetWorkStatusShow(String netWorkStatusShow) {
		this.netWorkStatusShow = netWorkStatusShow;
	}
	@Transient
	public String getExpenseTypeShow() {
		return expenseTypeShow;
	}
	public void setExpenseTypeShow(String expenseTypeShow) {
		this.expenseTypeShow = expenseTypeShow;
	}
	@Transient
	public String getPaymentStatusShow() {
		return paymentStatusShow;
	}
	public void setPaymentStatusShow(String paymentStatusShow) {
		this.paymentStatusShow = paymentStatusShow;
	}
	@Transient
	public String getDocTypeShow() {
		return docTypeShow;
	}
	public void setDocTypeShow(String docTypeShow) {
		this.docTypeShow = docTypeShow;
	}
	@Transient
	public String getVatTypeShow() {
		return vatTypeShow;
	}
	public void setVatTypeShow(String vatTypeShow) {
		this.vatTypeShow = vatTypeShow;
	}
	@Transient
	public String getPaymentTypeShow() {
		return paymentTypeShow;
	}
	public void setPaymentTypeShow(String paymentTypeShow) {
		this.paymentTypeShow = paymentTypeShow;
	}
	@Transient
	public String getPaymentMethodShow() {
		return paymentMethodShow;
	}
	public void setPaymentMethodShow(String paymentMethodShow) {
		this.paymentMethodShow = paymentMethodShow;
	}
	@Transient
	public Date getEffDt() {
		return effDt;
	}
	public void setEffDt(Date effDt) {
		this.effDt = effDt;
	}
	@Transient
	public Date getEffDtTH() {
		return effDtTH;
	}
	public void setEffDtTH(Date effDtTH) {
		this.effDtTH = effDtTH;
	}
	@Transient
	public Date getExpDt() {
		return expDt;
	}
	public void setExpDt(Date expDt) {
		this.expDt = expDt;
	}
	@Transient
	public Date getExpDtTH() {
		return expDtTH;
	}
	
	
	public void setExpDtTH(Date expDtTH) {
		this.expDtTH = expDtTH;
	}
	@Transient
	public Double getRcptPayCutAmount() {
		return rcptPayCutAmount;
	}
	public void setRcptPayCutAmount(Double rcptPayCutAmount) {
		this.rcptPayCutAmount = rcptPayCutAmount;
	}
	@Transient
	public boolean isChkRcptPay() {
		return chkRcptPay;
	}
	public void setChkRcptPay(boolean chkRcptPay) {
		this.chkRcptPay = chkRcptPay;
	}
	@Transient
	public String getRcptPayFlag() {
		return rcptPayFlag;
	}
	public void setRcptPayFlag(String rcptPayFlag) {
		this.rcptPayFlag = rcptPayFlag;
	}
	@Transient
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	@Transient
	public String getSendInfoStatus() {
		return sendInfoStatus;
	}
	public void setSendInfoStatus(String sendInfoStatus) {
		this.sendInfoStatus = sendInfoStatus;
	}
	@Transient
	public String getElCondSubType() {
		return elCondSubType;
	}
	public void setElCondSubType(String elCondSubType) {
		this.elCondSubType = elCondSubType;
	}
	@Transient
	public String getSiteCode() {
		return siteCode;
	}
	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}
	@Transient
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	@Transient
	public Date getPeriodStartDt() {
		return periodStartDt;
	}
	public void setPeriodStartDt(Date periodStartDt) {
		this.periodStartDt = periodStartDt;
	}
	@Transient
	public Date getPeriodEndDt() {
		return periodEndDt;
	}
	public void setPeriodEndDt(Date periodEndDt) {
		this.periodEndDt = periodEndDt;
	}
	@Transient
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	@Transient
	public String getReceiptNo() {
		return receiptNo;
	}
	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}
	@Transient
	public String getContFlowStatus() {
		return contFlowStatus;
	}
	public void setContFlowStatus(String contFlowStatus) {
		this.contFlowStatus = contFlowStatus;
	}
	@Transient
	public String getStrParam() {
		return strParam;
	}
	public void setStrParam(String strParam) {
		this.strParam = strParam;
	}
	@Transient
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	
}
