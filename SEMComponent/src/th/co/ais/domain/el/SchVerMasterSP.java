package th.co.ais.domain.el;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SchVerMasterSP implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4040068119111629109L;
	
	private static final SimpleDateFormat SDF 	= new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));
	
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
	private String networkStatusName;
	private String processStatusCode;
	private String processStatusName;
	private Date actionDt;
	private String createBy;
	private Date createDt;
	private String updateBy;
	private Date updateDt;
	
	private String firstEffectiveDtStr;
	private String effectiveDtStr;
	private String expireDtStr;
	private String actionDtStr;
	
	public SchVerMasterSP() {
		
	}
	
	public SchVerMasterSP(String electricId) {
		this.electricId = electricId;
	}
	
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
	public String getNetworkStatusName() {
		return networkStatusName;
	}
	public void setNetworkStatusName(String networkStatusName) {
		this.networkStatusName = networkStatusName;
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
	public Date getActionDt() {
		return actionDt;
	}
	public void setActionDt(Date actionDt) {
		this.actionDt = actionDt;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Date getCreateDt() {
		return createDt;
	}
	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public Date getUpdateDt() {
		return updateDt;
	}
	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	public String getFirstEffectiveDtStr() {
		firstEffectiveDtStr = (null != firstEffectiveDt) ? SDF.format(firstEffectiveDt) : "";
		return firstEffectiveDtStr;
	}

	public void setFirstEffectiveDtStr(String firstEffectiveDtStr) {
		this.firstEffectiveDtStr = firstEffectiveDtStr;
	}

	public String getEffectiveDtStr() {
		effectiveDtStr = (null != effectiveDt) ? SDF.format(effectiveDt) : "";
		return effectiveDtStr;
	}

	public void setEffectiveDtStr(String effectiveDtStr) {
		this.effectiveDtStr = effectiveDtStr;
	}

	public String getExpireDtStr() {
		expireDtStr = (null != expireDt) ? SDF.format(expireDt) : "";
		return expireDtStr;
	}

	public void setExpireDtStr(String expireDtStr) {
		this.expireDtStr = expireDtStr;
	}

	public String getActionDtStr() {
		actionDtStr = (null != actionDt) ? SDF.format(actionDt) : "";
		return actionDtStr;
	}

	public void setActionDtStr(String actionDtStr) {
		this.actionDtStr = actionDtStr;
	}
	

}
