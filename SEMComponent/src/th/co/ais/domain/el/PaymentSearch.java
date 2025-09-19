package th.co.ais.domain.el;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;


@org.hibernate.annotations.NamedNativeQuery(
	    name="searchPaymentHistory",  
	    query="call SEM_PG_EL_SEARCH_SITE_SEM_SP_EL006_SRCH_PAYMENT(?,:company, :contractNo,:siteName,:electricUseType,:region,:locationId,:locationCode,:siteType,:expenseType,:meterId,:fromTermOfPaymentDt,:toTermOfPaymentDt)",   
	    callable = true, readOnly = true,
	    resultClass=PaymentSearch.class 
	)  

	
@Entity
public class PaymentSearch  implements Serializable {

	private static final long serialVersionUID = -7485992463289088321L;	
	private static final SimpleDateFormat exportFormat = new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));


	
	@Transient
	private String rowNumber;	
	
	@Id
	@Column(name="ROWNUMBER")	
	private String uniqueRow;	

	@Column(name="PAYMENT_ID")	
	private String paymentId;	
	

	@Column(name="PERIOD_NAME")	
	private String periodName;
	
	@Column(name="PAYMENT_DETAIL_ID")	
	private String paymentDetailId;	
	
	@Column(name="CONTRACT_NO")	
	private String contractNo;	

	
	@Column(name="DETAIL_FLAG")	
	private String detailFlag;
	
	
	@Column(name="COMPANY")	
	private String company;
	@Column(name="SITE_NAME")	
	private String siteName;
	@Column(name="LOCATION_ID")	
	private String locationId;
	@Column(name="LOCATION_CODE")	
	private String locationCode;
	@Column(name="SITE_TYPE")	
	private String siteType;	

	
	// Display 
	
	@Column(name="ELECTRIC_USE_TYPE_DISPLAY")	
	private String electricUseTypeDisplay;
	
	@Column(name="PAYMENT_TYPE_DISPLAY")	
	private String paymentTypeDisplay;
	
	@Column(name="EXPENSE_TYPE_DISPLAY")	
	private String expenseTypeDisplay;
	
	@Column(name="PAYMENT_METHOD_DISPLAY")	
	private String paymentMethodDisplay;

	@Column(name="REGION")	
	private String region;
	@Column(name="ELECTRIC_USE_TYPE")	
	private String electricUseType;
	@Column(name="DOC_NO")	
	private String docNo;
	@Column(name="DOC_DT")	
	private Date docDt;
	@Column(name="INV_TOTAL_SITE")	
	private BigDecimal invTotalSite;
	@Column(name="INV_TOTAL_VAT")	
	private BigDecimal invTotalVat;	
	@Column(name="INV_TOTAL_INCLUDE_VAT")	
	private BigDecimal invTotalIncludeVat;	
	@Column(name="DB_TOTAL_SITE")	
	private BigDecimal dbTotalSite;
	@Column(name="DB_TOTAL_VAT")
	private BigDecimal dbTotalVat;	
	@Column(name="DB_TOTAL_INCLUDE_VAT")	
	private BigDecimal dbTotalIncludeVat;
	@Column(name="VENDOR_ID")	
	private String vendorId;


	@Column(name="VENDOR_NAME")	
	private String vendorName;
	@Column(name="PAYEE_ID")	
	private String payeeId;
	@Column(name="PAYEE_NAME")	
	private String payeeName;
	@Column(name="PAYMENT_TYPE")	
	private String paymentType;
	@Column(name="PAYMENT_METHOD")	
	private String paymentMethod;
	@Column(name="BANK_NAME")	
	private String bankName;
	@Column(name="BANK_ACCOUNT")	
	private String bankAccount;
	@Column(name="CHQ_AMT")	
	private BigDecimal chqAmt;
	@Column(name="CHQ_POSTING_DT")	
	private Date chqPostingDt;
	@Column(name="CHQ_RECEIVED_DT")	
	private Date chqReceivedDt;
	@Column(name="TRANSFER_DT")	
	private Date transferDt;
	@Column(name="REMARK")	
	private String remark;
	@Column(name="CREATE_DT")	
	protected Date createDt;
	@Column(name="CREATE_BY")	
	protected String createBy;

	@Column(name="EXPENSE_TYPE")	
	private String expenseType;
	@Column(name="METER_ID")	
	private String meterId;

	@Column(name="P_READ")	
	private BigDecimal pRead;
	@Column(name="L_READ")	
	private BigDecimal lRead;
	@Column(name="KWH_TOTAL")	
	private BigDecimal kwhTotal;
	@Column(name="UNIT_PRICE")	
	private BigDecimal unitPrice;
	@Column(name="UNIT_VAT_TYPE")	
	private String unitVatType;
	

	@Column(name="UNIT_VAT_TYPE_DISPLAY")	
	private String unitVatTypeDisplay;
	
	@Column(name="TERM_OF_PAYMENT_DT")	
	private Date termOfPaymentDt;
	@Column(name="FROM_TERM_OF_PAYMENT_DT")
	private Date fromTermOfPaymentDt;
	@Column(name="TO_TERM_OF_PAYMENT_DT")	
	private Date toTermOfPaymentDt;

	@Column(name="PAY_AMT")	
	private BigDecimal payAmt;
	@Column(name="VAT_TYPE")	
	private String vatType;

	
	@Column(name="VAT_TYPE_DISPLAY")	
	private String vatTypeDisplay;
	
	
	@Column(name="VAT_AMT")	
	private BigDecimal vatAmt;
	@Column(name="WHT_AMT")	
	private BigDecimal whtAmt;
	@Column(name="EXCLUDE_VAT_AMT")	
	private BigDecimal excludeVatAmt;
	@Column(name="INCLUDE_VAT_AMT")	
	private BigDecimal includeVatAmt;
	@Column(name="CHQ_AMT_DETAIL")	
	private BigDecimal chqAmtDetail;
	@Column(name="PERIOD_TYPE")	
	private String periodType;
	@Column(name="PERIOD_INTERVAL")	
	private BigDecimal periodInterval;
	// Pament
	@Transient
	private String docDtTH;
	@Transient
	private String chqPostingDtTH;	
	@Transient
	private String chqReceivedDtTH;
	@Transient
	private String transferDtTH;
	@Transient
	protected String createDtTH;
	
	@Transient
	private String termOfPaymentDtTH;
	@Transient
	private String fromTermOfPaymentDtTH;
	@Transient
	private String toTermOfPaymentDtTH;
	
	@Column(name="OLD_CONTRACT_NO")
	private String oldContractId;
	@Column(name="EFFECTIVE_DT")
	private Date effectiveDt;
	@Column(name="EXPIRE_DT")
	private Date expireDt;
	@Column(name="SITE_STATUS")
	private String siteStatus;
	@Column(name="SITE_STATUS_DISPLAY")
	private String siteStatusDisplay;
	@Column(name="NETWORK_STATUS")
	private String networkStatus;
	@Column(name="NETWORK_STATUS_DISPLAY")
	private String networkStatusDisplay;
	@Column(name="METER_STATUS")
	private String meterStatus;

	// PamentDetail

	@Transient
	public boolean isSiteTypeBoolean(){		
		return getSiteType() != null && getSiteType().equalsIgnoreCase("Y");
	}
	


	public void setSiteTypeBoolean(boolean flag){		
		if(flag) {
			setSiteType("Y");
		}else {
			setSiteType("N");
		}
	}
	
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getElectricUseType() {
		return electricUseType;
	}
	public void setElectricUseType(String electricUseType) {
		this.electricUseType = electricUseType;
	}
	
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
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
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public String getMeterId() {
		return meterId;
	}
	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}
	public Date getFromTermOfPaymentDt() {
		return fromTermOfPaymentDt;
	}
	public void setFromTermOfPaymentDt(Date fromTermOfPaymentDt) {
		this.fromTermOfPaymentDt = fromTermOfPaymentDt;
	}
	public Date getToTermOfPaymentDt() {
		return toTermOfPaymentDt;
	}
	public void setToTermOfPaymentDt(Date toTermOfPaymentDt) {
		this.toTermOfPaymentDt = toTermOfPaymentDt;
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
	public BigDecimal getInvTotalSite() {
		return invTotalSite;
	}
	public void setInvTotalSite(BigDecimal invTotalSite) {
		this.invTotalSite = invTotalSite;
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
	public Date getTransferDt() {
		return transferDt;
	}
	public void setTransferDt(Date transferDt) {
		this.transferDt = transferDt;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getCreateDt() {
		return createDt;
	}
	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public BigDecimal getpRead() {
		return pRead;
	}
	public void setpRead(BigDecimal pRead) {
		this.pRead = pRead;
	}
	public BigDecimal getlRead() {
		return lRead;
	}
	public void setlRead(BigDecimal lRead) {
		this.lRead = lRead;
	}
	public BigDecimal getKwhTotal() {
		return kwhTotal;
	}
	public void setKwhTotal(BigDecimal kwhTotal) {
		this.kwhTotal = kwhTotal;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getUnitVatType() {
		return unitVatType;
	}
	public void setUnitVatType(String unitVatType) {
		this.unitVatType = unitVatType;
	}
	public Date getTermOfPaymentDt() {
		return termOfPaymentDt;
	}
	public void setTermOfPaymentDt(Date termOfPaymentDt) {
		this.termOfPaymentDt = termOfPaymentDt;
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
	public BigDecimal getVatAmt() {
		return vatAmt;
	}
	public void setVatAmt(BigDecimal vatAmt) {
		this.vatAmt = vatAmt;
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
	public BigDecimal getChqAmtDetail() {
		return chqAmtDetail;
	}
	public void setChqAmtDetail(BigDecimal chqAmtDetail) {
		this.chqAmtDetail = chqAmtDetail;
	}
	public String getPeriodType() {
		return periodType;
	}
	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}
	public BigDecimal getPeriodInterval() {
		return periodInterval;
	}
	public void setPeriodInterval(BigDecimal periodInterval) {
		this.periodInterval = periodInterval;
	}
	
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getPaymentDetailId() {
		return paymentDetailId;
	}
	public void setPaymentDetailId(String paymentDetailId) {
		this.paymentDetailId = paymentDetailId;
	}

	public String getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(String rowNumber) {
		this.rowNumber = rowNumber;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentTypeDisplay() {
		return paymentTypeDisplay;
	}

	public void setPaymentTypeDisplay(String paymentTypeDisplay) {
		this.paymentTypeDisplay = paymentTypeDisplay;
	}

	public String getExpenseTypeDisplay() {
		return expenseTypeDisplay;
	}

	public void setExpenseTypeDisplay(String expenseTypeDisplay) {
		this.expenseTypeDisplay = expenseTypeDisplay;
	}

	public String getPaymentMethodDisplay() {
		return paymentMethodDisplay;
	}

	public void setPaymentMethodDisplay(String paymentMethodDisplay) {
		this.paymentMethodDisplay = paymentMethodDisplay;
	}

	public String getElectricUseTypeDisplay() {
		return electricUseTypeDisplay;
	}

	public void setElectricUseTypeDisplay(String electricUseTypeDisplay) {
		this.electricUseTypeDisplay = electricUseTypeDisplay;
	}

	public String getDocDtTH() {
		
		return docDt!=null?exportFormat.format(docDt):"";
	}

	public String getChqPostingDtTH() {
		
		return chqPostingDt!=null?exportFormat.format(chqPostingDt):"";
	}

	public String getChqReceivedDtTH() {
		
		return chqReceivedDt!=null?exportFormat.format(chqReceivedDt):"";
	}

	public String getTransferDtTH() {
		
		return  transferDt!=null?exportFormat.format( transferDt):"";
	}

	public String getCreateDtTH() {
		
		return createDt!=null?exportFormat.format(createDt):"";
	}



	public String getTermOfPaymentDtTH() {	
		return termOfPaymentDt!=null?exportFormat.format(termOfPaymentDt):"";
	}



	public String getFromTermOfPaymentDtTH() {	
		return fromTermOfPaymentDt!=null?exportFormat.format(fromTermOfPaymentDt):"";
	}



	public String getToTermOfPaymentDtTH() {
		return toTermOfPaymentDt!=null?exportFormat.format(toTermOfPaymentDt):"";
		 
	}



	public String getPeriodName() {
		return periodName;
	}



	public void setPeriodName(String periodName) {
		this.periodName = periodName;
	}



	public String getVatTypeDisplay() {
		return vatTypeDisplay;
	}



	public void setVatTypeDisplay(String vatTypeDisplay) {
		this.vatTypeDisplay = vatTypeDisplay;
	}



	public String getUnitVatTypeDisplay() {
		return unitVatTypeDisplay;
	}



	public void setUnitVatTypeDisplay(String unitVatTypeDisplay) {
		this.unitVatTypeDisplay = unitVatTypeDisplay;
	}



	public String getDetailFlag() {
		return detailFlag;
	}



	public void setDetailFlag(String detailFlag) {
		this.detailFlag = detailFlag;
	}



	public String getUniqueRow() {
		return uniqueRow;
	}



	public void setUniqueRow(String uniqueRow) {
		this.uniqueRow = uniqueRow;
	}



	public String getOldContractId() {
		return oldContractId;
	}



	public void setOldContractId(String oldContractId) {
		this.oldContractId = oldContractId;
	}



	public Date getEffectiveDt() {
		return effectiveDt;
	}



	public void setEffectiveDt(Date effectiveDt) {
		this.effectiveDt = effectiveDt;
	}



	public Date getExpireDt() {
		return expireDt;
	}



	public void setExpireDt(Date expireDt) {
		this.expireDt = expireDt;
	}



	public String getNetworkStatus() {
		return networkStatus;
	}



	public void setNetworkStatus(String networkStatus) {
		this.networkStatus = networkStatus;
	}



	public String getMeterStatus() {
		return meterStatus;
	}



	public void setMeterStatus(String meterStatus) {
		this.meterStatus = meterStatus;
	}



	public String getSiteStatus() {
		return siteStatus;
	}



	public void setSiteStatus(String siteStatus) {
		this.siteStatus = siteStatus;
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
}
