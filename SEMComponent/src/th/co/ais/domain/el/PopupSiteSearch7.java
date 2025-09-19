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
	/*@NamedNativeQuery(  name="queryOldDoc7",    
			query="call SEM.SEM_PG_EL_VENDOR_PAYEE.SP_CR_SITE_SRCH(?,:company, :contractNo, :siteName, :vendorCode, :vendorName, :vendorAddress, :payeeName, :payeeAddress, :meterId)",      
			callable = true, readOnly = true,    
			resultClass=PopupSiteSearch7.class ),*/
	@NamedNativeQuery(  name="querySite7",    
			//query="call SEM_PG_EL_VENDOR_PAYEE.SP_CR_SITE_SRCH(?,:company, :contractNo, :siteName, :vendorCode, :vendorName, :vendorAddress, :payeeName, :payeeAddress, :meterId ,:region,:electricId)",      
			query="call SEM_PG_EL_VENDOR_PAYEE_SP_CR_SITE_SRCH(?,:company, :contractNo, :siteName, :vendorCode, :vendorName, :vendorAddress, :payeeName, :payeeAddress, :meterId ,:region,:electricId)",      
			callable = true, readOnly = true,    
			resultClass=PopupSiteSearch7.class )
	
})
@Entity 
public class PopupSiteSearch7 implements Serializable{
	private static final long serialVersionUID = 1137928449633053552L;	
	private static final SimpleDateFormat exportFormat = new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));
	
	/*
	1. ELECTRIC_ID
	2. COMPANY = บริษัท
	3. OLD_CONTRACT_NO = Previous Contract ID
	4. CONTRACT_NO = เลขที่สัญญา
	5. ELECTRIC_USE_TYPE = ประเภทการใช้ไฟ
	6. CONTRACT_START_DT = วันเริ่มต้นสัญญา
	7. CONTRACT_END_DT = วันสิ้นสุดสัญญา
	8. SITE_NAME = ชื่อสถานีฐาน
	9. E_AREA_CODE = เขตการไฟฟ้า
	10. SITE_STATUS = สถานะสถานีฐาน
	11. NETWORK_STATUS = Network Status
	12. LOCATION_ID = Location ID
	13. LOCATION_CODE = Location Code
	14. EXPENSE_TYPE = ประเภทขอเบิก

	 */
	
	@Id
	@Column(name = "ELECTRIC_ID")	 
	private String electricId;
	
	@Column(name = "COMPANY")	 
	private String company;
	
	@Column(name = "OLD_CONTRACT_NO")	
	private String oldContractNo;
	
	@Column(name = "CONTRACT_NO")	
	private String contractNo;
	
	@Column(name = "ELECTRIC_USE_TYPE")	
	private String electricUseType;
	
	@Column(name = "CONTRACT_START_DT")	
	private Date contractStartDt;
	 
	@Column(name = "CONTRACT_END_DT")	
	private Date contractEndDt;

	@Column(name = "SITE_NAME")	
	private String siteName;
	
//	@Column(name = "E_AREA_CODE")	
//	private String areaCode;
	
	@Column(name = "E_AREA_NAME")	
	private String areaName;

	@Column(name = "SITE_STATUS")	
	private String siteStatus;
	
	@Column(name = "NETWORK_STATUS")	
	private String networkStatus;
	
	@Column(name = "LOCATION_ID")	
	private String locationId;
	
	@Column(name = "LOCATION_CODE")	
	private String locationCode;
	
	@Column(name = "ELECTRIC_USE_TYPE_DISPLAY")
	private String electricUseTypeDisplay;
	
	@Column(name = "SITE_STATUS_DISPLAY")
	private String siteStatusDisplay;	
	
	@Column(name = "NETWORK_STATUS_DISPLAY")
	private String networkStatusDisplay;

	@Transient
	private String vendorId;
	@Transient
	private String vendorCode;
	@Transient
	private String vendorName;
	@Transient
	private String vendorAddress;
	@Transient
	private String payeeName;
	@Transient
	private String payeeAddress;
	@Transient
	private String meterId;
	
	@Transient
	private String region;
	
	public String getElectricId() {
		return electricId;
	}

	public void setElectricId(String electricId) {
		this.electricId = electricId;
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

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getElectricUseType() {
		return electricUseType;
	}

	public void setElectricUseType(String electricUseType) {
		this.electricUseType = electricUseType;
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

//	public String getAreaCode() {
//		return areaCode;
//	}
//
//	public void setAreaCode(String areaCode) {
//		this.areaCode = areaCode;
//	}

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

	public static SimpleDateFormat getExportformat() {
		return exportFormat;
	}

	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
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

	public String getMeterId() {
		return meterId;
	}

	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getElectricUseTypeDisplay() {
		return electricUseTypeDisplay;
	}

	public void setElectricUseTypeDisplay(String electricUseTypeDisplay) {
		this.electricUseTypeDisplay = electricUseTypeDisplay;
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
	
	@Transient
	public String getContractStartDtTH() {
		return contractStartDt!=null?exportFormat.format(contractStartDt):"";
	}
	@Transient
	public String getContractEndDtTH() {
		return contractEndDt!=null?exportFormat.format(contractEndDt):"";
	} 
	
	
	
}
