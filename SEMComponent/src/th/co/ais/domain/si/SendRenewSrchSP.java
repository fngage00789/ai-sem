package th.co.ais.domain.si;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;
import th.co.ais.rpt.util.annotation.PCell;
import th.co.ais.util.SEMDataUtility;

public class SendRenewSrchSP extends AbstractDomain{

	private static final long serialVersionUID = 6636113475771022070L;
	
	private Boolean selected;
	
	private String rowId;
	private String contractNo;
	private String siteName;
	private Date firstEffDt;
	private Date effDt;
	private Date expDt;
	private Double rentAmt;
	private String locationId;
	private String locationCode;
	private String networkStatus;
	private String sendRenewType;
	private String approveStatus;
	private String sendRenewStatus;
	private Date sendRenewDt;
	private Date sendRenewBackDt;
	private Date approvebackDt;
	private String remark;
	private Date samDt;
	private String sendRenewStatusCd;
	private String company;
	private Date contractStartDt;
	private Date contractEndDt;
	private String contractNoEndFlag;
	private String region;
	private Date approveDtFrom;
	private Date approveDtTo;
	private Date approveBackDtFrom;
	private Date approveBackDtTo;
	private Date samDtFrom;
	private Date samDtTo;
	private String siteAds;
	private String siteStatus;
	private String flowStatus;
	private String zoneId;
	private String address;
	private String district;
	private String amphur;
	private String province;
	private String renewAgeDesc;
	private String userName;
	private String contactName;
	private String telephone;
	
	private String siteType;
	private Date expireDtFrom;
	private Date expireDtTo;
	
	private String firstEffDtStr;
	private String effDtStr;
	private String expDtStr;
	private String sendRenewDtStr;
	private String sendRenewBackDtStr;
	private String approvebackDtStr;
	private String samDtStr;
	
	private int no;
	
	//added BY new 20190418
	private String siteInfoId;
	
	private String chkPico;
	
	public Date getApproveDtFrom() {
		return approveDtFrom;
	}
	public void setApproveDtFrom(Date approveDtFrom) {
		this.approveDtFrom = approveDtFrom;
	}
	public Date getApproveDtTo() {
		return approveDtTo;
	}
	public void setApproveDtTo(Date approveDtTo) {
		this.approveDtTo = approveDtTo;
	}
	public Date getApproveBackDtFrom() {
		return approveBackDtFrom;
	}
	public void setApproveBackDtFrom(Date approveBackDtFrom) {
		this.approveBackDtFrom = approveBackDtFrom;
	}
	public Date getApproveBackDtTo() {
		return approveBackDtTo;
	}
	public void setApproveBackDtTo(Date approveBackDtTo) {
		this.approveBackDtTo = approveBackDtTo;
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
	@PCell(cellType = String.class, no = 3)
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	@PCell(cellType = String.class, no = 4)
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
	@PCell(cellType = Date.class, no = 11)
	public Date getEffDt() {
		return effDt;
	}
	public void setEffDt(Date effDt) {
		this.effDt = effDt;
	}
	@PCell(cellType = Date.class, no = 12)
	public Date getExpDt() {
		return expDt;
	}
	public void setExpDt(Date expDt) {
		this.expDt = expDt;
	}
	@PCell(cellType = String.class, no = 5)
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	@PCell(cellType = String.class, no = 6)
	public String getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
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
	@PCell(cellType = String.class, no = 13)
	public String getApproveStatus() {
		return approveStatus;
	}
	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}
	public String getSendRenewStatus() {
		return sendRenewStatus;
	}
	public void setSendRenewStatus(String sendRenewStatus) {
		this.sendRenewStatus = sendRenewStatus;
	}
	public Date getSendRenewDt() {
		return sendRenewDt;
	}
	public void setSendRenewDt(Date sendRenewDt) {
		this.sendRenewDt = sendRenewDt;
	}
	public Date getSendRenewBackDt() {
		return sendRenewBackDt;
	}
	public void setSendRenewBackDt(Date sendRenewBackDt) {
		this.sendRenewBackDt = sendRenewBackDt;
	}
	public Date getApprovebackDt() {
		return approvebackDt;
	}
	public void setApprovebackDt(Date approvebackDt) {
		this.approvebackDt = approvebackDt;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getSamDt() {
		return samDt;
	}
	public void setSamDt(Date samDt) {
		this.samDt = samDt;
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
	public void setSendRenewStatusCd(String sendRenewStatusCd) {
		this.sendRenewStatusCd = sendRenewStatusCd;
	}
	public String getSendRenewStatusCd() {
		return sendRenewStatusCd;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@PCell(cellType = String.class, no = 1)
	public String getCompany() {
		return company;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	@PCell(cellType = String.class, no = 2)
	public String getRegion() {
		return region;
	}
	public void setRentAmt(Double rentAmt) {
		this.rentAmt = rentAmt;
	}
	public Double getRentAmt() {
		return rentAmt;
	}
	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
	public Boolean getSelected() {
		return selected;
	}
	@PCell(cellType = String.class, no = 7)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@PCell(cellType = String.class, no = 8)
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	@PCell(cellType = String.class, no = 9)
	public String getAmphur() {
		return amphur;
	}
	public void setAmphur(String amphur) {
		this.amphur = amphur;
	}
	@PCell(cellType = String.class, no = 10)
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public void setRenewAgeDesc(String renewAgeDesc) {
		this.renewAgeDesc = renewAgeDesc;
	}
	@PCell(cellType = String.class, no = 14)
	public String getRenewAgeDesc() {
		return renewAgeDesc;
	}
	@PCell(cellType = String.class, no = 15)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@PCell(cellType = String.class, no = 16)
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	@PCell(cellType = String.class, no = 17)
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}
	public String getSiteType() {
		return siteType;
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
	public String getSiteAds() {
		return siteAds;
	}
	public void setSiteAds(String siteAds) {
		this.siteAds = siteAds;
	}
	public String getSiteStatus() {
		return siteStatus;
	}
	public void setSiteStatus(String siteStatus) {
		this.siteStatus = siteStatus;
	}
	public String getFlowStatus() {
		return flowStatus;
	}
	public void setFlowStatus(String flowStatus) {
		this.flowStatus = flowStatus;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	@PCell(cellType = String.class, no = 0)
	public String getStringNo() {
		return no+"";
	}
	@PCell(cellType = String.class, no = 18)
	public String getZoneId() {
		return zoneId;
	}
	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}
	public String getFirstEffDtStr() {
		return firstEffDtStr;
	}
	public void setFirstEffDtStr(String firstEffDtStr) {
		this.firstEffDtStr = firstEffDtStr;
	}
	public String getExpDtStr() {
		return expDtStr;
	}
	public void setExpDtStr(String expDtStr) {
		this.expDtStr = expDtStr;
	}
	public String getSendRenewDtStr() {
		return sendRenewDtStr;
	}
	public void setSendRenewDtStr(String sendRenewDtStr) {
		this.sendRenewDtStr = sendRenewDtStr;
	}
	public String getSendRenewBackDtStr() {
		return sendRenewBackDtStr;
	}
	public void setSendRenewBackDtStr(String sendRenewBackDtStr) {
		this.sendRenewBackDtStr = sendRenewBackDtStr;
	}
	public String getSamDtStr() {
		return samDtStr;
	}
	public void setSamDtStr(String samDtStr) {
		this.samDtStr = samDtStr;
	}
	public String getApprovebackDtStr() {
		return approvebackDtStr;
	}
	public void setApprovebackDtStr(String approvebackDtStr) {
		this.approvebackDtStr = approvebackDtStr;
	}
	public String getEffDtStr() {
		return effDtStr;
	}
	public void setEffDtStr(String effDtStr) {
		this.effDtStr = effDtStr;
	}
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	public String getChkPico() {
		return chkPico;
	}
	public void setChkPico(String chkPico) {
		this.chkPico = chkPico;
	}
	
	
}
