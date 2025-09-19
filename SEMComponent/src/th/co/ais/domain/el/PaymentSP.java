package th.co.ais.domain.el;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import th.co.ais.domain.AbstractDomain;

public class PaymentSP extends AbstractDomain implements Serializable {

	private String id;
	private String rowId; 
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
	
	private Set<PaymentDetailSP> details;
	private int totalExpense;
	private int totalMeterExpense;
	
	private String batchNo;
	private String collectiveDbNo;
	private String collectiveDbFlag;
	private String rejectReason;
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
	
	private Date createDate;
	private String pCreateBy;
	
	// added by.. YUT 2014/09/10
	private Double rcptPayCutAmount;
	private boolean chkRcptPay;
	private String rcptPayFlag;
	
	private String paymentId;
	private String sendInfoStatus;
	
	private String elCondSubType;
	private String siteCode;
	private String service;
	private Date periodStartDt;
	private Date periodEndDt;
	
	private String serviceType;
	
	private String receiptNo;
	private String contFlowStatus;
	
	private String strParam;
	
	private String siteId;
	
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getPayNo() {
		return payNo;
	}

	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}

	public String getPaySumNo() {
		return paySumNo;
	}

	public void setPaySumNo(String paySumNo) {
		this.paySumNo = paySumNo;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getOldContractNo() {
		return oldContractNo;
	}

	public void setOldContractNo(String oldContractNo) {
		this.oldContractNo = oldContractNo;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getSiteInfoId() {
		return siteInfoId;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getSiteType() {
		return siteType;
	}

	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getSiteStatus() {
		return siteStatus;
	}

	public void setSiteStatus(String siteStatus) {
		this.siteStatus = siteStatus;
	}

	public String getNetWorkStatus() {
		return netWorkStatus;
	}

	public void setNetWorkStatus(String netWorkStatus) {
		this.netWorkStatus = netWorkStatus;
	}

	public String getElectricUseType() {
		return electricUseType;
	}

	public void setElectricUseType(String electricUseType) {
		this.electricUseType = electricUseType;
	}

	public Date getWarrantPrintDt() {
		return warrantPrintDt;
	}

	public void setWarrantPrintDt(Date warrantPrintDt) {
		this.warrantPrintDt = warrantPrintDt;
	}

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	public String getExpenseTypeDisplay() {
		return expenseTypeDisplay;
	}

	public void setExpenseTypeDisplay(String expenseTypeDisplay) {
		this.expenseTypeDisplay = expenseTypeDisplay;
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

	public Date getDocDt() {
		return docDt;
	}

	public void setDocDt(Date docDt) {
		this.docDt = docDt;
	}

	public String getRefDocType() {
		return refDocType;
	}

	public void setRefDocType(String refDocType) {
		this.refDocType = refDocType;
	}

	public String getRefDocNo() {
		return refDocNo;
	}

	public void setRefDocNo(String refDocNo) {
		this.refDocNo = refDocNo;
	}

	public Date getRefDocDt() {
		return refDocDt;
	}

	public void setRefDocDt(Date refDocDt) {
		this.refDocDt = refDocDt;
	}

	public BigDecimal getInvTotalSite() {
		return invTotalSite;
	}

	public void setInvTotalSite(BigDecimal invTotalSite) {
		this.invTotalSite = invTotalSite;
	}

	public BigDecimal getInvTotalExcludeVat() {
		return invTotalExcludeVat;
	}

	public void setInvTotalExcludeVat(BigDecimal invTotalExcludeVat) {
		this.invTotalExcludeVat = invTotalExcludeVat;
	}

	public BigDecimal getInvTotalVat() {
		return invTotalVat;
	}

	public void setInvTotalVat(BigDecimal invTotalVat) {
		this.invTotalVat = invTotalVat;
	}

	public BigDecimal getInvTotalIncludeVat() {
		return invTotalIncludeVat;
	}

	public void setInvTotalIncludeVat(BigDecimal invTotalIncludeVat) {
		this.invTotalIncludeVat = invTotalIncludeVat;
	}

	public BigDecimal getDbTotalSite() {
		return dbTotalSite;
	}

	public void setDbTotalSite(BigDecimal dbTotalSite) {
		this.dbTotalSite = dbTotalSite;
	}

	public BigDecimal getDbTotalExcludeVat() {
		return dbTotalExcludeVat;
	}

	public void setDbTotalExcludeVat(BigDecimal dbTotalExcludeVat) {
		this.dbTotalExcludeVat = dbTotalExcludeVat;
	}

	public BigDecimal getDbTotalVat() {
		return dbTotalVat;
	}

	public void setDbTotalVat(BigDecimal dbTotalVat) {
		this.dbTotalVat = dbTotalVat;
	}

	public BigDecimal getDbTotalIncludeVat() {
		return dbTotalIncludeVat;
	}

	public void setDbTotalIncludeVat(BigDecimal dbTotalIncludeVat) {
		this.dbTotalIncludeVat = dbTotalIncludeVat;
	}

	public BigDecimal getNoDbTotalSite() {
		return noDbTotalSite;
	}

	public void setNoDbTotalSite(BigDecimal noDbTotalSite) {
		this.noDbTotalSite = noDbTotalSite;
	}

	public BigDecimal getNoDbTotalExcludeVat() {
		return noDbTotalExcludeVat;
	}

	public void setNoDbTotalExcludeVat(BigDecimal noDbTotalExcludeVat) {
		this.noDbTotalExcludeVat = noDbTotalExcludeVat;
	}

	public BigDecimal getNoDbTotalVat() {
		return noDbTotalVat;
	}

	public void setNoDbTotalVat(BigDecimal noDbTotalVat) {
		this.noDbTotalVat = noDbTotalVat;
	}

	public BigDecimal getNoDbIncludeVat() {
		return noDbIncludeVat;
	}

	public void setNoDbIncludeVat(BigDecimal noDbIncludeVat) {
		this.noDbIncludeVat = noDbIncludeVat;
	}

	public BigDecimal getPayAmt() {
		return payAmt;
	}

	public void setPayAmt(BigDecimal payAmt) {
		this.payAmt = payAmt;
	}

	public String getVatType() {
		return vatType;
	}

	public void setVatType(String vatType) {
		this.vatType = vatType;
	}

	public BigDecimal getVatRate() {
		return vatRate;
	}

	public void setVatRate(BigDecimal vatRate) {
		this.vatRate = vatRate;
	}

	public BigDecimal getVatAmt() {
		return vatAmt;
	}

	public void setVatAmt(BigDecimal vatAmt) {
		this.vatAmt = vatAmt;
	}

	public String getWhtType() {
		return whtType;
	}

	public void setWhtType(String whtType) {
		this.whtType = whtType;
	}

	public BigDecimal getWhtRate() {
		return whtRate;
	}

	public void setWhtRate(BigDecimal whtRate) {
		this.whtRate = whtRate;
	}

	public BigDecimal getWhtAmt() {
		return whtAmt;
	}

	public void setWhtAmt(BigDecimal whtAmt) {
		this.whtAmt = whtAmt;
	}

	public BigDecimal getExcludeVatAmt() {
		return excludeVatAmt;
	}

	public void setExcludeVatAmt(BigDecimal excludeVatAmt) {
		this.excludeVatAmt = excludeVatAmt;
	}

	public BigDecimal getIncludeVatAmt() {
		return includeVatAmt;
	}

	public void setIncludeVatAmt(BigDecimal includeVatAmt) {
		this.includeVatAmt = includeVatAmt;
	}

	public BigDecimal getIncludeVatAmtCR() {
		return includeVatAmtCR;
	}

	public void setIncludeVatAmtCR(BigDecimal includeVatAmtCR) {
		this.includeVatAmtCR = includeVatAmtCR;
	}

	public Date getDepositPeriodDt() {
		return depositPeriodDt;
	}

	public void setDepositPeriodDt(Date depositPeriodDt) {
		this.depositPeriodDt = depositPeriodDt;
	}

	public BigDecimal getDepositAmt() {
		return depositAmt;
	}

	public void setDepositAmt(BigDecimal depositAmt) {
		this.depositAmt = depositAmt;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getPayeeId() {
		return payeeId;
	}

	public void setPayeeId(String payeeId) {
		this.payeeId = payeeId;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
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

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getChqNo() {
		return chqNo;
	}

	public void setChqNo(String chqNo) {
		this.chqNo = chqNo;
	}

	public String getChqBank() {
		return chqBank;
	}

	public void setChqBank(String chqBank) {
		this.chqBank = chqBank;
	}

	public BigDecimal getChqAmt() {
		return chqAmt;
	}

	public void setChqAmt(BigDecimal chqAmt) {
		this.chqAmt = chqAmt;
	}

	public Date getChqPostingDt() {
		return chqPostingDt;
	}

	public void setChqPostingDt(Date chqPostingDt) {
		this.chqPostingDt = chqPostingDt;
	}

	public Date getChqReceivedDt() {
		return chqReceivedDt;
	}

	public void setChqReceivedDt(Date chqReceivedDt) {
		this.chqReceivedDt = chqReceivedDt;
	}

	public String getChqClearingStatus() {
		return chqClearingStatus;
	}

	public void setChqClearingStatus(String chqClearingStatus) {
		this.chqClearingStatus = chqClearingStatus;
	}

	public Date getChqClearingDt() {
		return chqClearingDt;
	}

	public void setChqClearingDt(Date chqClearingDt) {
		this.chqClearingDt = chqClearingDt;
	}

	public Date getTransferDt() {
		return transferDt;
	}

	public void setTransferDt(Date transferDt) {
		this.transferDt = transferDt;
	}

	public String getExportFlag() {
		return exportFlag;
	}

	public void setExportFlag(String exportFlag) {
		this.exportFlag = exportFlag;
	}

	public Date getExportDt() {
		return exportDt;
	}

	public void setExportDt(Date exportDt) {
		this.exportDt = exportDt;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getSentPaymentDt() {
		return sentPaymentDt;
	}

	public void setSentPaymentDt(Date sentPaymentDt) {
		this.sentPaymentDt = sentPaymentDt;
	}

	public String getElectricPayStatus() {
		return electricPayStatus;
	}

	public void setElectricPayStatus(String electricPayStatus) {
		this.electricPayStatus = electricPayStatus;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getDoc68() {
		return doc68;
	}

	public void setDoc68(String doc68) {
		this.doc68 = doc68;
	}

	public String getDoc92() {
		return doc92;
	}

	public void setDoc92(String doc92) {
		this.doc92 = doc92;
	}

	public String getAccApprove() {
		return accApprove;
	}

	public void setAccApprove(String accApprove) {
		this.accApprove = accApprove;
	}

	public String getRejectStatus() {
		return rejectStatus;
	}

	public void setRejectStatus(String rejectStatus) {
		this.rejectStatus = rejectStatus;
	}

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	public BigDecimal getVersion() {
		return version;
	}

	public void setVersion(BigDecimal version) {
		this.version = version;
	}

	public String getPaymentTypeTxt() {
		return paymentTypeTxt;
	}

	public void setPaymentTypeTxt(String paymentTypeTxt) {
		this.paymentTypeTxt = paymentTypeTxt;
	}

	public String getPaymentMethodTxt() {
		return paymentMethodTxt;
	}

	public void setPaymentMethodTxt(String paymentMethodTxt) {
		this.paymentMethodTxt = paymentMethodTxt;
	}

	public String getOldPaymentTypeTxt() {
		return oldPaymentTypeTxt;
	}

	public void setOldPaymentTypeTxt(String oldPaymentTypeTxt) {
		this.oldPaymentTypeTxt = oldPaymentTypeTxt;
	}

	public String getOldPaymentMethodTxt() {
		return oldPaymentMethodTxt;
	}

	public void setOldPaymentMethodTxt(String oldPaymentMethodTxt) {
		this.oldPaymentMethodTxt = oldPaymentMethodTxt;
	}

	public String getElectricUseTypeTxt() {
		return electricUseTypeTxt;
	}

	public void setElectricUseTypeTxt(String electricUseTypeTxt) {
		this.electricUseTypeTxt = electricUseTypeTxt;
	}

	public String getExpenseTypeTxt() {
		return expenseTypeTxt;
	}

	public void setExpenseTypeTxt(String expenseTypeTxt) {
		this.expenseTypeTxt = expenseTypeTxt;
	}

	public String getRefDocTypeTxt() {
		return refDocTypeTxt;
	}

	public void setRefDocTypeTxt(String refDocTypeTxt) {
		this.refDocTypeTxt = refDocTypeTxt;
	}

	public String getDocTypeDisplay() {
		return docTypeDisplay;
	}

	public void setDocTypeDisplay(String docTypeDisplay) {
		this.docTypeDisplay = docTypeDisplay;
	}

	public String getPaymentStatusDisplay() {
		return paymentStatusDisplay;
	}

	public void setPaymentStatusDisplay(String paymentStatusDisplay) {
		this.paymentStatusDisplay = paymentStatusDisplay;
	}

	public String getWhtCheck() {
		return whtCheck;
	}

	public void setWhtCheck(String whtCheck) {
		this.whtCheck = whtCheck;
	}

	public String getVatTypeTxt() {
		return vatTypeTxt;
	}

	public void setVatTypeTxt(String vatTypeTxt) {
		this.vatTypeTxt = vatTypeTxt;
	}

	public Set<PaymentDetailSP> getDetails() {
		return details;
	}

	public void setDetails(Set<PaymentDetailSP> details) {
		this.details = details;
	}

	public int getTotalExpense() {
		return totalExpense;
	}

	public void setTotalExpense(int totalExpense) {
		this.totalExpense = totalExpense;
	}

	public int getTotalMeterExpense() {
		return totalMeterExpense;
	}

	public void setTotalMeterExpense(int totalMeterExpense) {
		this.totalMeterExpense = totalMeterExpense;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getCollectiveDbNo() {
		return collectiveDbNo;
	}

	public void setCollectiveDbNo(String collectiveDbNo) {
		this.collectiveDbNo = collectiveDbNo;
	}

	public String getCollectiveDbFlag() {
		return collectiveDbFlag;
	}

	public void setCollectiveDbFlag(String collectiveDbFlag) {
		this.collectiveDbFlag = collectiveDbFlag;
	}

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	public String getCrBankName() {
		return crBankName;
	}

	public void setCrBankName(String crBankName) {
		this.crBankName = crBankName;
	}

	public Date getCrPayInDt() {
		return crPayInDt;
	}

	public void setCrPayInDt(Date crPayInDt) {
		this.crPayInDt = crPayInDt;
	}

	public String getCrPayInFlag() {
		return crPayInFlag;
	}

	public void setCrPayInFlag(String crPayInFlag) {
		this.crPayInFlag = crPayInFlag;
	}

	public boolean isEnableEditButton() {
		return enableEditButton;
	}

	public void setEnableEditButton(boolean enableEditButton) {
		this.enableEditButton = enableEditButton;
	}

	public String getSpecialFlag() {
		return specialFlag;
	}

	public void setSpecialFlag(String specialFlag) {
		this.specialFlag = specialFlag;
	}

	public String getVendorType() {
		return vendorType;
	}

	public void setVendorType(String vendorType) {
		this.vendorType = vendorType;
	}

	public String getOldVendorIdTypeV() {
		return oldVendorIdTypeV;
	}

	public void setOldVendorIdTypeV(String oldVendorIdTypeV) {
		this.oldVendorIdTypeV = oldVendorIdTypeV;
	}

	public String getOldVendorNameTypeV() {
		return oldVendorNameTypeV;
	}

	public void setOldVendorNameTypeV(String oldVendorNameTypeV) {
		this.oldVendorNameTypeV = oldVendorNameTypeV;
	}

	public String getOldPayeeIdTypeV() {
		return oldPayeeIdTypeV;
	}

	public void setOldPayeeIdTypeV(String oldPayeeIdTypeV) {
		this.oldPayeeIdTypeV = oldPayeeIdTypeV;
	}

	public String getOldPayeeNameTypeV() {
		return oldPayeeNameTypeV;
	}

	public void setOldPayeeNameTypeV(String oldPayeeNameTypeV) {
		this.oldPayeeNameTypeV = oldPayeeNameTypeV;
	}

	public String getOldPaymentMethodTypeV() {
		return oldPaymentMethodTypeV;
	}

	public void setOldPaymentMethodTypeV(String oldPaymentMethodTypeV) {
		this.oldPaymentMethodTypeV = oldPaymentMethodTypeV;
	}

	public String getOldPaymentTypeTypeV() {
		return oldPaymentTypeTypeV;
	}

	public void setOldPaymentTypeTypeV(String oldPaymentTypeTypeV) {
		this.oldPaymentTypeTypeV = oldPaymentTypeTypeV;
	}

	public String getOldBankAccountTypeV() {
		return oldBankAccountTypeV;
	}

	public void setOldBankAccountTypeV(String oldBankAccountTypeV) {
		this.oldBankAccountTypeV = oldBankAccountTypeV;
	}

	public String getOldBankNameTypeV() {
		return oldBankNameTypeV;
	}

	public void setOldBankNameTypeV(String oldBankNameTypeV) {
		this.oldBankNameTypeV = oldBankNameTypeV;
	}

	public String getOldVendorIdTypeS() {
		return oldVendorIdTypeS;
	}

	public void setOldVendorIdTypeS(String oldVendorIdTypeS) {
		this.oldVendorIdTypeS = oldVendorIdTypeS;
	}

	public String getOldVendorNameTypeS() {
		return oldVendorNameTypeS;
	}

	public void setOldVendorNameTypeS(String oldVendorNameTypeS) {
		this.oldVendorNameTypeS = oldVendorNameTypeS;
	}

	public String getOldPayeeIdTypeS() {
		return oldPayeeIdTypeS;
	}

	public void setOldPayeeIdTypeS(String oldPayeeIdTypeS) {
		this.oldPayeeIdTypeS = oldPayeeIdTypeS;
	}

	public String getOldPayeeNameTypeS() {
		return oldPayeeNameTypeS;
	}

	public void setOldPayeeNameTypeS(String oldPayeeNameTypeS) {
		this.oldPayeeNameTypeS = oldPayeeNameTypeS;
	}

	public String getOldPaymentMethodTypeS() {
		return oldPaymentMethodTypeS;
	}

	public void setOldPaymentMethodTypeS(String oldPaymentMethodTypeS) {
		this.oldPaymentMethodTypeS = oldPaymentMethodTypeS;
	}

	public String getOldPaymentTypeTypeS() {
		return oldPaymentTypeTypeS;
	}

	public void setOldPaymentTypeTypeS(String oldPaymentTypeTypeS) {
		this.oldPaymentTypeTypeS = oldPaymentTypeTypeS;
	}

	public String getOldBankAccountTypeS() {
		return oldBankAccountTypeS;
	}

	public void setOldBankAccountTypeS(String oldBankAccountTypeS) {
		this.oldBankAccountTypeS = oldBankAccountTypeS;
	}

	public String getOldBankNameTypeS() {
		return oldBankNameTypeS;
	}

	public void setOldBankNameTypeS(String oldBankNameTypeS) {
		this.oldBankNameTypeS = oldBankNameTypeS;
	}

	public Date getDocDtFrom() {
		return docDtFrom;
	}

	public void setDocDtFrom(Date docDtFrom) {
		this.docDtFrom = docDtFrom;
	}

	public Date getDocDtTo() {
		return docDtTo;
	}

	public void setDocDtTo(Date docDtTo) {
		this.docDtTo = docDtTo;
	}

	public String getMonthDetailDisplay() {
		return monthDetailDisplay;
	}

	public void setMonthDetailDisplay(String monthDetailDisplay) {
		this.monthDetailDisplay = monthDetailDisplay;
	}

	public BigDecimal getInvPayAmt() {
		return invPayAmt;
	}

	public void setInvPayAmt(BigDecimal invPayAmt) {
		this.invPayAmt = invPayAmt;
	}

	public String getCrPayinChqNo() {
		return crPayinChqNo;
	}

	public void setCrPayinChqNo(String crPayinChqNo) {
		this.crPayinChqNo = crPayinChqNo;
	}

	public BigDecimal getCrPayinAmt() {
		return crPayinAmt;
	}

	public void setCrPayinAmt(BigDecimal crPayinAmt) {
		this.crPayinAmt = crPayinAmt;
	}

	public String getCrBankNo() {
		return crBankNo;
	}

	public void setCrBankNo(String crBankNo) {
		this.crBankNo = crBankNo;
	}

	public String getCrCreditFlag() {
		return crCreditFlag;
	}

	public void setCrCreditFlag(String crCreditFlag) {
		this.crCreditFlag = crCreditFlag;
	}

	public String getTransID() {
		return transID;
	}

	public void setTransID(String transID) {
		this.transID = transID;
	}

	public BigDecimal getElBillPayAmt() {
		return elBillPayAmt;
	}

	public void setElBillPayAmt(BigDecimal elBillPayAmt) {
		this.elBillPayAmt = elBillPayAmt;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getElImportStatus() {
		return elImportStatus;
	}

	public void setElImportStatus(String elImportStatus) {
		this.elImportStatus = elImportStatus;
	}

	public String getElImportStatusDetail() {
		return elImportStatusDetail;
	}

	public void setElImportStatusDetail(String elImportStatusDetail) {
		this.elImportStatusDetail = elImportStatusDetail;
	}

	public String getPayment_channel() {
		return payment_channel;
	}

	public void setPayment_channel(String paymentChannel) {
		payment_channel = paymentChannel;
	}

	public String getSiteStatusDisplay() {
		return siteStatusDisplay;
	}

	public void setSiteStatusDisplay(String siteStatusDisplay) {
		this.siteStatusDisplay = siteStatusDisplay;
	}

	public String getNetworkStatusDisplay() {
		return networkStatusDisplay;
	}

	public void setNetworkStatusDisplay(String networkStatusDisplay) {
		this.networkStatusDisplay = networkStatusDisplay;
	}

	public String getDoc69() {
		return doc69;
	}

	public void setDoc69(String doc69) {
		this.doc69 = doc69;
	}

	public String getExpenseTypeCode() {
		return expenseTypeCode;
	}

	public void setExpenseTypeCode(String expenseTypeCode) {
		this.expenseTypeCode = expenseTypeCode;
	}

	public Date getDisplayCreateDate() {
		return displayCreateDate;
	}

	public void setDisplayCreateDate(Date displayCreateDate) {
		this.displayCreateDate = displayCreateDate;
	}

	public Date getDisplayUpdateDate() {
		return displayUpdateDate;
	}

	public void setDisplayUpdateDate(Date displayUpdateDate) {
		this.displayUpdateDate = displayUpdateDate;
	}

	public String getSiteStatusShow() {
		return siteStatusShow;
	}

	public void setSiteStatusShow(String siteStatusShow) {
		this.siteStatusShow = siteStatusShow;
	}

	public String getNetWorkStatusShow() {
		return netWorkStatusShow;
	}

	public void setNetWorkStatusShow(String netWorkStatusShow) {
		this.netWorkStatusShow = netWorkStatusShow;
	}

	public String getExpenseTypeShow() {
		return expenseTypeShow;
	}

	public void setExpenseTypeShow(String expenseTypeShow) {
		this.expenseTypeShow = expenseTypeShow;
	}

	public String getPaymentStatusShow() {
		return paymentStatusShow;
	}

	public void setPaymentStatusShow(String paymentStatusShow) {
		this.paymentStatusShow = paymentStatusShow;
	}

	public String getDocTypeShow() {
		return docTypeShow;
	}

	public void setDocTypeShow(String docTypeShow) {
		this.docTypeShow = docTypeShow;
	}

	public String getVatTypeShow() {
		return vatTypeShow;
	}

	public void setVatTypeShow(String vatTypeShow) {
		this.vatTypeShow = vatTypeShow;
	}

	public String getPaymentTypeShow() {
		return paymentTypeShow;
	}

	public void setPaymentTypeShow(String paymentTypeShow) {
		this.paymentTypeShow = paymentTypeShow;
	}

	public String getPaymentMethodShow() {
		return paymentMethodShow;
	}

	public void setPaymentMethodShow(String paymentMethodShow) {
		this.paymentMethodShow = paymentMethodShow;
	}

	public Date getEffDt() {
		return effDt;
	}

	public void setEffDt(Date effDt) {
		this.effDt = effDt;
	}

	public Date getEffDtTH() {
		return effDtTH;
	}

	public void setEffDtTH(Date effDtTH) {
		this.effDtTH = effDtTH;
	}

	public Date getExpDt() {
		return expDt;
	}

	public void setExpDt(Date expDt) {
		this.expDt = expDt;
	}

	public Date getExpDtTH() {
		return expDtTH;
	}

	public void setExpDtTH(Date expDtTH) {
		this.expDtTH = expDtTH;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getpCreateBy() {
		return pCreateBy;
	}

	public void setpCreateBy(String pCreateBy) {
		this.pCreateBy = pCreateBy;
	}

	public Double getRcptPayCutAmount() {
		return rcptPayCutAmount;
	}

	public void setRcptPayCutAmount(Double rcptPayCutAmount) {
		this.rcptPayCutAmount = rcptPayCutAmount;
	}

	public boolean isChkRcptPay() {
		return chkRcptPay;
	}

	public void setChkRcptPay(boolean chkRcptPay) {
		this.chkRcptPay = chkRcptPay;
	}

	public String getRcptPayFlag() {
		return rcptPayFlag;
	}

	public void setRcptPayFlag(String rcptPayFlag) {
		this.rcptPayFlag = rcptPayFlag;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getSendInfoStatus() {
		return sendInfoStatus;
	}

	public void setSendInfoStatus(String sendInfoStatus) {
		this.sendInfoStatus = sendInfoStatus;
	}

	public String getElCondSubType() {
		return elCondSubType;
	}

	public void setElCondSubType(String elCondSubType) {
		this.elCondSubType = elCondSubType;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public Date getPeriodStartDt() {
		return periodStartDt;
	}

	public void setPeriodStartDt(Date periodStartDt) {
		this.periodStartDt = periodStartDt;
	}

	public Date getPeriodEndDt() {
		return periodEndDt;
	}

	public void setPeriodEndDt(Date periodEndDt) {
		this.periodEndDt = periodEndDt;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

	public String getContFlowStatus() {
		return contFlowStatus;
	}

	public void setContFlowStatus(String contFlowStatus) {
		this.contFlowStatus = contFlowStatus;
	}

	public String getStrParam() {
		return strParam;
	}

	public void setStrParam(String strParam) {
		this.strParam = strParam;
	}

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

}
