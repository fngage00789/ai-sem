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
	@NamedNativeQuery(  name="querySiteEL",    
			query="call SEM_PG_EL_SEARCH_SITE_SEM_SP_EL006_SRCH_SITE(?,:contractNo, :meterId)",      
			callable = true, readOnly = true,    
			resultClass=PopupSiteSearch.class ) 
		,
		
	@NamedNativeQuery(   name="querySiteELPostpaid",     
			query="call SEM_PG_EL_SEARCH_SITE_SEM_EL006_SRCH_SITE_ELPOSTPAID(?,:contractNo, :meterId,:outstandingFlag)",    
			callable = true, readOnly = true,    
			resultClass=PopupSiteSearch.class )  			
		,
		
		
	@NamedNativeQuery(   name="querySiteELTemp",     
			query="call SEM_PG_EL_SEARCH_SITE_SEM_EL006_SRCH_SITE_ELTEMP(?,:contractNo, :meterId,:outstandingFlag,:company,:region,:siteName,:vendorId,:vendorName,:vendorAddress,:payeeName,:payeeAddress,:pRead)",    
			callable = true, readOnly = true,    
			resultClass=PopupSiteSearch.class )  			
		,	
		
		
	@NamedNativeQuery(   name="querySiteELTmp",     
			query="call SEM_PG_EL_SEARCH_SITE_SEM_SP_EL006_SRCH_SITE_ELTMP(?,:contractNo)",    
			callable = true, readOnly = true,    
			resultClass=PopupSiteSearch.class )  	
		,
		
	@NamedNativeQuery(   name="querySiteELPrepaid",     
			query="call SEM_PG_EL_SEARCH_SITE_SEM_EL006_SRCH_ELPRPREPAID(?,:contractNo)",    
			callable = true, readOnly = true,    
			resultClass=PopupSiteSearch.class )  		
		,
	@NamedNativeQuery(   name="querySiteELPR",     
			query="call SEM_PG_EL_SEARCH_SITE_SEM_EL006_SRCH_SITE_ELPR(?,:contractNo)",    
			callable = true, readOnly = true,    
			resultClass=PopupSiteSearch.class )
			
})
@Entity 
public class PopupSiteSearch implements Serializable{
	private static final long serialVersionUID = 1137928449676053552L;	
	private static final SimpleDateFormat exportFormat = new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));
	
	
	/*

COMPANY
OLD_CONTRACT_NO
CONTRACT_NO
ELECTRIC_USE_TYPE
CONTRACT_START_DT
CONTRACT_END_DT
SITE_NAME
E_AREA_CODE
SITE_STATUS
NETWORK_STATUS
LOCATION_ID
LOCATION_CODE

METER_ID
E_ON_METER_DT
E_METER_TYPE
E_METER_RATE


     ,M.P_TAKE_ALL_AMOUNT
     ,M. P_TAKE_ALL_PERIOD_TYPE
     ,M.P_VAT_TYPE
      ,M.P_PAY_PERIOD_TYPE
	
	*/
	

	@Id
	@Column(name = "ROWNUMBER")		
	private String rowNumber;

	@Column(name = "CONTRACT_NO")		
	private String contractNo;
	
	@Column(name = "COMPANY")
	private String company;	
	
	@Column(name = "OLD_CONTRACT_NO")
	private String oldContractNo;		

	@Column(name = "RECORD_STATUS")
	private String recordStatus;	
	 
	@Column(name = "OUTSTANDING_FLAG")
	private String outstandingFlag;	
	
	@Column(name = "RECORD_STATUS_DISPLAY")
	private String recordStatusDisplay;	
	
	@Column(name = "ELECTRIC_USE_TYPE")
	private String electricUseType;

	@Column(name = "ELECTRIC_USE_TYPE_DISPLAY")
	private String electricUseTypeDisplay;
	
	public String getElectricUseTypeDisplay() {
		return electricUseTypeDisplay;
	}
	public void setElectricUseTypeDisplay(String electricUseTypeDisplay) {
		this.electricUseTypeDisplay = electricUseTypeDisplay;
	}
	@Column(name = "CONTRACT_START_DT")	
	private Date contractStartDt;
	
	@Column(name = "CONTRACT_END_DT")
	private Date contractEndDt;	
	
	@Column(name = "SITE_NAME")
	private String siteName;	
	
	@Column(name = "SITE_STATUS")
	private String siteStatus;	
	
	@Column(name = "SITE_INFO_ID")
	private String siteInfoId;	

	
	@Column(name = "SITE_TYPE")
	private String siteType;	
	
	@Column(name = "REGION")
	private String region;	
	
	@Column(name = "REFER_METER_ID")
	private String referMeterId;		
	  
	
	@Column(name = "SITE_STATUS_DISPLAY")
	private String siteStatusDisplay;	
	
	@Column(name = "NETWORK_STATUS")
	private String networkStatus;

	@Column(name = "NETWORK_STATUS_DISPLAY")
	private String networkStatusDisplay;
	
	@Column(name = "LOCATION_ID")
	private String locationId;
	
	@Column(name = "LOCATION_CODE")
	private String locationCode;
	
	@Column(name = "E_AREA_CODE")
	private String eAreaCode;
	
	@Column(name = "E_ON_METER_DT")
	private Date eOnMeterDt;	
	
	@Column(name = "METER_INFO_ID")	
	private String meterInfoId;	
	
	@Column(name = "ELECTRIC_ID")	
	private String electricId;
	
	@Column(name = "METER_ID")
	private String meterId;

	@Column(name = "E_METER_TYPE")
	private String eMeterType;
	
	@Column(name = "E_METER_RATE")
	private String eMeterRate;	

	@Column(name = "P_TAKE_ALL_AMOUNT")
	private BigDecimal pTakeAllAmount;	
	
	@Column(name = "P_TAKE_ALL_PERIOD_TYPE")
	private String pTakeAllPreiodType;	

	@Column(name = "P_VAT_TYPE")
	private String pVatType;	
	
	@Column(name = "P_PAY_PERIOD_TYPE")
	private String pPayPeriodType;	
	
	@Column(name = "P_PAY_PERIOD")
	private String pPayPeriod;	
	
	@Column(name = "METER_STATUS")
	private String meterStatus;
	
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
	
	@Transient
	private String pPayPeriod03;
	
	@Transient
	private String pPayPeriod04;
	
	//WT###Add 20110201 Start
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
	//WT###Add 20110201 End
	@Transient
	private String vendorId;//WT###Add 20110301
	@Transient
	private String prepaidFlagStr;//WT###Add 20110524
	@Transient
	private boolean prepaidFlag;//WT###Add 20110524
	
	@Transient
	private String pRead;
	@Transient
	private String meterID;
	
	@Transient
	private String locationID;
	
	public String getpPayPeriod03() {
		return pPayPeriod03;
		/*
		if("03".equals(pPayPeriodType)){
			System.out.print("pPayPeriodType:03" );
			return pPayPeriod;
		}else{
			return "";
		}*/

	}
	public void setpPayPeriod03(String pPayPeriod03) {
	    this.pPayPeriod03 = pPayPeriod03;
		/*
		if("03".equals(this.getpPayPeriodType())){
			System.out.print("pPayPeriodType:03" );
			this.pPayPeriod03 = pPayPeriod;
		}else{
			System.out.print("pPayPeriodType 03:"+this.getpPayPeriodType());
			this.pPayPeriod03 = "";
		}*/
	}
	public String getpPayPeriod04() {
		return pPayPeriod04;
		/*
		if("04".equals(pPayPeriodType)){
			System.out.print("pPayPeriodType:04" );
			return pPayPeriod;
		}else{
			return "";
		}
		*/
	}
	public void setpPayPeriod04(String pPayPeriod04) {
		this.pPayPeriod04 = pPayPeriod04;
		/*
		if("04".equals(this.getpPayPeriodType())){
			System.out.print("pPayPeriodType:04" );
			this.pPayPeriod04 = pPayPeriod;
		}else{
			System.out.print("pPayPeriodType: 04"+this.getpPayPeriodType());
			this.pPayPeriod04 = "";
		}*/
	}
	public String getpPayPeriod() {
		return pPayPeriod;
	}
	public void setpPayPeriod(String pPayPeriod) {
		this.pPayPeriod = pPayPeriod;
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
	public BigDecimal getpTakeAllAmount() {
		return pTakeAllAmount;
	}
	public void setpTakeAllAmount(BigDecimal pTakeAllAmount) {
		this.pTakeAllAmount = pTakeAllAmount;
	}
	public String getpTakeAllPreiodType() {
		return pTakeAllPreiodType;
	}
	public void setpTakeAllPreiodType(String pTakeAllPreiodType) {
		this.pTakeAllPreiodType = pTakeAllPreiodType;
	}
	public String geteMeterType() {
		return eMeterType;
	}
	public void seteMeterType(String eMeterType) {
		this.eMeterType = eMeterType;
	}
	public String geteMeterRate() {
		return eMeterRate;
	}
	public void seteMeterRate(String eMeterRate) {
		this.eMeterRate = eMeterRate;
	}
	public String getElectricUseType() {
		return electricUseType;
	}
	public void setElectricUseType(String electricUseType) {
		this.electricUseType = electricUseType;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getMeterId() {
		return meterId;
	}
	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}
	public String getElectricId() {
		return electricId;
	}
	public void setElectricId(String electricId) {
		this.electricId = electricId;
	}
	public String getMeterInfoId() {
		return meterInfoId;
	}
	public void setMeterInfoId(String meterInfoId) {
		this.meterInfoId = meterInfoId;
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
	public String geteAreaCode() {
		return eAreaCode;
	}
	public void seteAreaCode(String eAreaCode) {
		this.eAreaCode = eAreaCode;
	}
	public Date geteOnMeterDt() {
		return eOnMeterDt;
	}
	public void seteOnMeterDt(Date eOnMeterDt) {
		this.eOnMeterDt = eOnMeterDt;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getOldContractNo() {
		return oldContractNo;
	}
	public void setOldContractNo(String oldContractNo) {
		this.oldContractNo = oldContractNo;
	}
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	public String getRecordStatusDisplay() {
		return recordStatusDisplay;
	}
	public void setRecordStatusDisplay(String recordStatusDisplay) {
		this.recordStatusDisplay = recordStatusDisplay;
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
	public String getRowNumber() {
		return rowNumber;
	}
	public void setRowNumber(String rowNumber) {
		this.rowNumber = rowNumber;
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
	public String getReferMeterId() {
		return referMeterId;
	}
	public void setReferMeterId(String referMeterId) {
		this.referMeterId = referMeterId;
	}
	public String getOutstandingFlag() {
		return outstandingFlag;
	}
	public void setOutstandingFlag(String outstandingFlag) {
		this.outstandingFlag = outstandingFlag;
	}
	
	//
	
	
	
	@Transient
	public String getContractStartDtTH() {
		return contractStartDt!=null?exportFormat.format(contractStartDt):"";
	}
	@Transient
	public String getContractEndDtTH() {
		return contractEndDt!=null?exportFormat.format(contractEndDt):"";
	}
	@Transient
	public String geteOnMeterDtTH() {
		return eOnMeterDt!=null?exportFormat.format(eOnMeterDt):"";
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
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	public String getMeterStatus() {
		return meterStatus;
	}
	public void setMeterStatus(String meterStatus) {
		this.meterStatus = meterStatus;
	}
	public String getPrepaidFlagStr() {
		return prepaidFlagStr;
	}
	public void setPrepaidFlagStr(String prepaidFlagStr) {
		this.prepaidFlagStr = prepaidFlagStr;
	}
	public boolean isPrepaidFlag() {
		return prepaidFlag;
	}
	public void setPrepaidFlag(boolean prepaidFlag) {
		this.prepaidFlag = prepaidFlag;
	}
	public String getpRead() {
		return pRead;
	}
	public void setpRead(String pRead) {
		this.pRead = pRead;
	}
	public String getMeterID() {
		return meterID;
	}
	public void setMeterID(String meterID) {
		this.meterID = meterID;
	}
	public String getLocationID() {
		return locationID;
	}
	public void setLocationID(String locationID) {
		this.locationID = locationID;
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
