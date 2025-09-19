package th.co.ais.domain.el;

import java.io.Serializable;
import java.util.Date;

public class ElSearchRecDtlSP implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5514360375311196520L;
	
	
	private String electricId;
	private String siteInfoId;
	private String company;
	private String contractNo;
	private String oldContractNo;
	private String region;
	private String siteName;
	private String locationId;
	private String locationCode;
	private String locationStatus;
	private String siteCode;
	private Date firstEffectiveDt;
	private Date effectiveDt;
	private Date expireDt;
	private String noExpireFlag;
	private String siteStatus;
	private String siteStatusName;
	private String networkstatusName;
	private String processStatusCode;
	private String processStatusName;
	private String electricUseType;
	private String transferFlag;
	private Date newReceivedDt;
	private Date terminateReceivedDt;
	
	public String getElectricId() {
		return electricId;
	}
	public void setElectricId(String electricId) {
		this.electricId = electricId;
	}
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
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
	public String getOldContractNo() {
		return oldContractNo;
	}
	public void setOldContractNo(String oldContractNo) {
		this.oldContractNo = oldContractNo;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
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
	public String getLocationStatus() {
		return locationStatus;
	}
	public void setLocationStatus(String locationStatus) {
		this.locationStatus = locationStatus;
	}
	public String getSiteCode() {
		return siteCode;
	}
	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}
	public Date getFirstEffectiveDt() {
		return firstEffectiveDt;
	}
	public void setFirstEffectiveDt(Date firstEffectiveDt) {
		this.firstEffectiveDt = firstEffectiveDt;
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
	public String getNoExpireFlag() {
		return noExpireFlag;
	}
	public void setNoExpireFlag(String noExpireFlag) {
		this.noExpireFlag = noExpireFlag;
	}
	public String getSiteStatus() {
		return siteStatus;
	}
	public void setSiteStatus(String siteStatus) {
		this.siteStatus = siteStatus;
	}
	public String getSiteStatusName() {
		return siteStatusName;
	}
	public void setSiteStatusName(String siteStatusName) {
		this.siteStatusName = siteStatusName;
	}
	public String getNetworkstatusName() {
		return networkstatusName;
	}
	public void setNetworkstatusName(String networkstatusName) {
		this.networkstatusName = networkstatusName;
	}
	public String getProcessStatusCode() {
		return processStatusCode;
	}
	public void setProcessStatusCode(String processStatusCode) {
		this.processStatusCode = processStatusCode;
	}
	public String getProcessStatusName() {
		return processStatusName;
	}
	public void setProcessStatusName(String processStatusName) {
		this.processStatusName = processStatusName;
	}
	public String getElectricUseType() {
		return electricUseType;
	}
	public void setElectricUseType(String electricUseType) {
		this.electricUseType = electricUseType;
	}
	public String getTransferFlag() {
		return transferFlag;
	}
	public void setTransferFlag(String transferFlag) {
		this.transferFlag = transferFlag;
	}
	public Date getNewReceivedDt() {
		return newReceivedDt;
	}
	public void setNewReceivedDt(Date newReceivedDt) {
		this.newReceivedDt = newReceivedDt;
	}
	public Date getTerminateReceivedDt() {
		return terminateReceivedDt;
	}
	public void setTerminateReceivedDt(Date terminateReceivedDt) {
		this.terminateReceivedDt = terminateReceivedDt;
	}
	
}
