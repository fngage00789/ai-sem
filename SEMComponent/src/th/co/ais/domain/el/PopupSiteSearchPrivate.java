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

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

@NamedNativeQueries({
	@NamedNativeQuery(   name="searchSitePrivatePostpaid",     
			query="call SEM_PG_EL_VENDOR_PAYEE_SP_PRIVATE_POSTPAID_SRCH(?, :company, :contractNo, :siteName, :vendorName, :vendorAddress, :payeeName, :payeeAddress, :region, :vendorId, :prepaidFlag,:meterID,:pwh)",    
			callable = true, readOnly = true,    
			resultClass=PopupSiteSearchPrivate.class ),
	@NamedNativeQuery(   name="searchSitePrivatePrepaid",     
			query="call SEM_PG_EL_VENDOR_PAYEE_SP_PRIVATE_PREPAID_SRCH(?, :company, :contractNo, :siteName, :vendorName, :vendorAddress, :payeeName, :payeeAddress, :region, :vendorId)",    
			callable = true, readOnly = true,    
			resultClass=PopupSiteSearchPrivate.class )
			
})
@Entity 
public class PopupSiteSearchPrivate implements Serializable{
	private static final long serialVersionUID = 1137928449676053552L;
	private static final SimpleDateFormat exportFormat = new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));
	

	@Id
	@Column(name = "ELECTRIC_ID")	
	private String electricId;

	@Column(name = "CONTRACT_NO")		
	private String contractNo;
	
	@Column(name = "COMPANY")
	private String company;	
	
	@Column(name = "OLD_CONTRACT_NO")
	private String oldContractNo;	
	
	@Column(name = "ELECTRIC_USE_TYPE")
	private String electricUseType;
	
	@Column(name = "RECORD_STATUS")
	private String recordStatus;	
	
	@Column(name = "CONTRACT_START_DT")	
	private Date contractStartDt;
	
	@Column(name = "CONTRACT_END_DT")
	private Date contractEndDt;	
	
	@Column(name = "SITE_NAME")
	private String siteName;	
	
	@Column(name = "SITE_STATUS")
	private String siteStatus;	
	
	@Column(name = "NETWORK_STATUS")
	private String networkStatus;
	
	@Column(name = "LOCATION_ID")
	private String locationId;
	
	@Column(name = "LOCATION_CODE")
	private String locationCode;
	
	@Column(name = "SITE_INFO_ID")
	private String siteInfoId;	
	
	@Column(name = "SITE_TYPE")
	private String siteType;	
	
	@Column(name = "REGION")
	private String region;
	
	@Column(name = "P_PAY_PERIOD")
	private String pPayPeriod;	
	
	@Column(name = "P_TAKE_ALL_AMOUNT")
	private BigDecimal pTakeAllAmount;	
	
	@Column(name = "P_TAKE_ALL_PERIOD_TYPE")
	private String pTakeAllPeriodType;	
	
	@Column(name = "P_VAT_TYPE")
	private String pVatType;	
	 
	@Column(name = "P_PAY_PERIOD_TYPE")
	private String pPayPeriodType;	
	
	@Column(name = "PAYMENT_CHANNEL")
	private String payment_channel;
	
	@Column(name = "VENDOR")
	private String vendor;	
	
	@Column(name = "PAYEE")
	private String payee;
	
	@Column(name = "OWNER_GROUP")
	private String ownerGroup;	
	
	@Column(name = "OWNER_GROUP_NAME")
	private String ownerGroupName;	
	
	@Column(name = "V_RESULT")
	private String result;	
	
	@Column(name = "V_REMARK")
	private String remark;	
	
	
	//@Column(name = "VENDOR_NAME")
	@Transient
	private String vendorName;
	
	//@Column(name = "VENDOR_ADDRESS")
	@Transient
	private String vendorAddress;
	
	//@Column(name = "PAYEE_NAME")
	@Transient
	private String payeeName;
	
	//@Column(name = "PAYEE_ADDRESS")
	@Transient
	private String payeeAddress;
	
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getVendorAddress() {
		return vendorAddress;
	}
	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public String getPayeeAddress() {
		return payeeAddress;
	}
	public void setPayeeAddress(String payeeAddress) {
		this.payeeAddress = payeeAddress;
	}
	public String getElectricId() {
		return electricId;
	}
	public void setElectricId(String electricId) {
		this.electricId = electricId;
	}
	public String getOldContractNo() {
		return oldContractNo;
	}
	public void setOldContractNo(String oldContractNo) {
		this.oldContractNo = oldContractNo;
	}
	public String getElectricUseType() {
		return electricUseType;
	}
	public void setElectricUseType(String electricUseType) {
		this.electricUseType = electricUseType;
	}
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	public Date getContractStartDt() {
		return contractStartDt;
	}
	public void setContractStartDt(Date contractStartDt) {
		this.contractStartDt = contractStartDt;
	}
	public Date getContractEndDt() {
		return contractEndDt;
	}
	public void setContractEndDt(Date contractEndDt) {
		this.contractEndDt = contractEndDt;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getSiteStatus() {
		return siteStatus;
	}
	public void setSiteStatus(String siteStatus) {
		this.siteStatus = siteStatus;
	}
	public String getNetworkStatus() {
		return networkStatus;
	}
	public void setNetworkStatus(String networkStatus) {
		this.networkStatus = networkStatus;
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
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
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
	public String getpPayPeriod() {
		return pPayPeriod;
	}
	public void setpPayPeriod(String pPayPeriod) {
		this.pPayPeriod = pPayPeriod;
	}
	public BigDecimal getpTakeAllAmount() {
		return pTakeAllAmount;
	}
	public void setpTakeAllAmount(BigDecimal pTakeAllAmount) {
		this.pTakeAllAmount = pTakeAllAmount;
	}	
	public String getpTakeAllPeriodType() {
		return pTakeAllPeriodType;
	}
	public void setpTakeAllPeriodType(String pTakeAllPeriodType) {
		this.pTakeAllPeriodType = pTakeAllPeriodType;
	}
	public String getpVatType() {
		return pVatType;
	}
	public void setpVatType(String pVatType) {
		this.pVatType = pVatType;
	}
	public String getpPayPeriodType() {
		return pPayPeriodType;
	}
	public void setpPayPeriodType(String pPayPeriodType) {
		this.pPayPeriodType = pPayPeriodType;
	}
	public String getPayment_channel() {
		return payment_channel;
	}
	public void setPayment_channel(String paymentChannel) {
		payment_channel = paymentChannel;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getPayee() {
		return payee;
	}
	public void setPayee(String payee) {
		this.payee = payee;
	}
	public String getOwnerGroup() {
		return ownerGroup;
	}
	public void setOwnerGroup(String ownerGroup) {
		this.ownerGroup = ownerGroup;
	}
	public String getOwnerGroupName() {
		return ownerGroupName;
	}
	public void setOwnerGroupName(String ownerGroupName) {
		this.ownerGroupName = ownerGroupName;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
