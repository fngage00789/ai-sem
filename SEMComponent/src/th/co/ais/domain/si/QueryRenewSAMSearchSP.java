package th.co.ais.domain.si;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class QueryRenewSAMSearchSP extends AbstractDomain{

	private static final long serialVersionUID = 6636113475771022070L;
	
	private Boolean select;
	private String rowId;
	private String contractNo;
	private String company;
	private Date contractStartDt;
	private Date contractEndDt;
	private String contractNoEndFlag; 
	private String locationId;
	private String locationCode;
	private String siteName;
	private String region;
	private String sendRenewType;
	private String approveStatus;
	private Date samDt;
	private Date samDtFrom;
	private Date samDtTo;
	private String siteStatus;
	
	private String siteType;
	private Date expireDtFrom;
	private Date expireDtTo;
	
	public String getSiteStatus() {
		return siteStatus;
	}
	public void setSiteStatus(String siteStatus) {
		this.siteStatus = siteStatus;
	}
	private Date invalidDtFrom;
	private Date invalidDtTo;
	private Date invalidDt;
	
	//outPut
	private Date firstEffDt;
	private Date effDt;
	private Date expDt;
	private String networkStatus;
	private String address;
	
	
	public String getApproveStatus() {
		return approveStatus;
	}
	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	public String getContractNoEndFlag() {
		return contractNoEndFlag;
	}
	public void setContractNoEndFlag(String contractNoEndFlag) {
		this.contractNoEndFlag = contractNoEndFlag;
	}
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
	public Date getFirstEffDt() {
		return firstEffDt;
	}
	public void setFirstEffDt(Date firstEffDt) {
		this.firstEffDt = firstEffDt;
	}
	public Date getEffDt() {
		return effDt;
	}
	public void setEffDt(Date effDt) {
		this.effDt = effDt;
	}
	public Date getExpDt() {
		return expDt;
	}
	public void setExpDt(Date expDt) {
		this.expDt = expDt;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public String getNetworkStatus() {
		return networkStatus;
	}
	public void setNetworkStatus(String networkStatus) {
		this.networkStatus = networkStatus;
	}
	public String getSendRenewType() {
		return sendRenewType;
	}
	public void setSendRenewType(String sendRenewType) {
		this.sendRenewType = sendRenewType;
	}
	
	@Override
	public String getCreateBy() {
		return this.createBy;
	}
	@Override
	public Date getCreateDt() {
		return this.createDt;
	}
	@Override
	public String getUpdateBy() {
		return this.updateBy;
	}
	@Override
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
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCompany() {
		return company;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getRegion() {
		return region;
	}
	public void setSelect(Boolean select) {
		this.select = select;
	}
	public Boolean getSelect() {
		return select;
	}
	public String getSiteType() {
		return siteType;
	}
	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}
	public Date getExpireDtFrom() {
		return expireDtFrom;
	}
	public void setExpireDtFrom(Date expireDtFrom) {
		this.expireDtFrom = expireDtFrom;
	}
	public Date getExpireDtTo() {
		return expireDtTo;
	}
	public void setExpireDtTo(Date expireDtTo) {
		this.expireDtTo = expireDtTo;
	}
	public String getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	public Date getSamDtFrom() {
		return samDtFrom;
	}
	public void setSamDtFrom(Date samDtFrom) {
		this.samDtFrom = samDtFrom;
	}
	public Date getSamDtTo() {
		return samDtTo;
	}
	public void setSamDtTo(Date samDtTo) {
		this.samDtTo = samDtTo;
	}
	public Date getInvalidDtFrom() {
		return invalidDtFrom;
	}
	public void setInvalidDtFrom(Date invalidDtFrom) {
		this.invalidDtFrom = invalidDtFrom;
	}
	public Date getInvalidDtTo() {
		return invalidDtTo;
	}
	public void setInvalidDtTo(Date invalidDtTo) {
		this.invalidDtTo = invalidDtTo;
	}
	public void setSamDt(Date samDt) {
		this.samDt = samDt;
	}
	public Date getSamDt() {
		return samDt;
	}
	public void setInvalidDt(Date invalidDt) {
		this.invalidDt = invalidDt;
	}
	public Date getInvalidDt() {
		return invalidDt;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
}
