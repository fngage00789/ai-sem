package th.co.ais.domain.si;

import java.io.Serializable;
import java.util.Date;

public class PopupContractSearchSP implements Serializable{

	private static final long serialVersionUID = -5860905113316848734L;
	
	private String rowId;
	private String contractNo;
	private String siteName;
	private String company;
	private String region;
	private String siteInfoId;
	private Date effDate;
	private Date expDate;
	private String currentFlag;
	private String siteAddress;
	private String lessorAddress;
	private boolean selected;
	private Date vendorEffectiveDt;
	private String vendorEffectiveDtStr;
	
	private String contractType;
	private String contractStatus;
	private String networkStatus;
	private String locationId;
	private String locationCode;
	private String locationName;
	private String contractName;
	private String contractNoOld;
	
	private String remark;
	
	private String pRemark;
	private String pResult;

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}


	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getSiteInfoId() {
		return siteInfoId;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}

	public Date getEffDate() {
		return effDate;
	}

	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public String getCurrentFlag() {
		return currentFlag;
	}

	public void setCurrentFlag(String currentFlag) {
		this.currentFlag = currentFlag;
	}

	public String getSiteAddress() {
		return siteAddress;
	}

	public void setSiteAddress(String siteAddress) {
		this.siteAddress = siteAddress;
	}

	public String getLessorAddress() {
		return lessorAddress;
	}

	public void setLessorAddress(String lessorAddress) {
		this.lessorAddress = lessorAddress;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public Date getVendorEffectiveDt() {
		return vendorEffectiveDt;
	}

	public void setVendorEffectiveDt(Date vendorEffectiveDt) {
		this.vendorEffectiveDt = vendorEffectiveDt;
	}

	public String getVendorEffectiveDtStr() {
		return vendorEffectiveDtStr;
	}

	public void setVendorEffectiveDtStr(String vendorEffectiveDtStr) {
		this.vendorEffectiveDtStr = vendorEffectiveDtStr;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public String getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
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

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public String getContractNoOld() {
		return contractNoOld;
	}

	public void setContractNoOld(String contractNoOld) {
		this.contractNoOld = contractNoOld;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getpRemark() {
		return pRemark;
	}

	public void setpRemark(String pRemark) {
		this.pRemark = pRemark;
	}

	public String getpResult() {
		return pResult;
	}

	public void setpResult(String pResult) {
		this.pResult = pResult;
	}
	
	
}
