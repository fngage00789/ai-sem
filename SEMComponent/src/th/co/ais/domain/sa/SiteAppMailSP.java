package th.co.ais.domain.sa;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class SiteAppMailSP extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String rowId;
	private String mailAddrId;
	private String siteAppId;
	private String mailName;
	private String mailHouseNo;
	private String mailBuilding;
	private String mailFloor;
	private String mailRoomNo;
	private String mailStreet;
	private String mailTambon;
	private String mailAmphurId;
	private String mailProvinceId;
	private String mailPostCode;
	private String recordStatus;
	private Long version;
	private String fullAddress;
	private Date ordering;
	
	private String userLogin;
	private String strParam;

	private String phoneNo;
	
	private String mainFlag;
	
	@Override
	public String toString() {
		return "SiteAppMailSP [fullAddress=" + fullAddress + ", mailAddrId="
				+ mailAddrId + ", mailAmphurId=" + mailAmphurId
				+ ", mailBuilding=" + mailBuilding + ", mailFloor=" + mailFloor
				+ ", mailHouseNo=" + mailHouseNo + ", mailName=" + mailName
				+ ", mailPostCode=" + mailPostCode + ", mailProvinceId="
				+ mailProvinceId + ", mailRoomNo=" + mailRoomNo
				+ ", mailStreet=" + mailStreet + ", mailTambon=" + mailTambon
				+ ", ordering=" + ordering + ", recordStatus=" + recordStatus
				+ ", rowId=" + rowId + ", siteAppId=" + siteAppId
				+ ", version=" + version + "]";
	}
	

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getMailAddrId() {
		return mailAddrId;
	}

	public void setMailAddrId(String mailAddrId) {
		this.mailAddrId = mailAddrId;
	}

	public String getSiteAppId() {
		return siteAppId;
	}

	public void setSiteAppId(String siteAppId) {
		this.siteAppId = siteAppId;
	}

	public String getMailName() {
		return mailName;
	}

	public void setMailName(String mailName) {
		this.mailName = mailName;
	}

	public String getMailHouseNo() {
		return mailHouseNo;
	}

	public void setMailHouseNo(String mailHouseNo) {
		this.mailHouseNo = mailHouseNo;
	}

	public String getMailBuilding() {
		return mailBuilding;
	}

	public void setMailBuilding(String mailBuilding) {
		this.mailBuilding = mailBuilding;
	}

	public String getMailFloor() {
		return mailFloor;
	}

	public void setMailFloor(String mailFloor) {
		this.mailFloor = mailFloor;
	}

	public String getMailRoomNo() {
		return mailRoomNo;
	}

	public void setMailRoomNo(String mailRoomNo) {
		this.mailRoomNo = mailRoomNo;
	}

	public String getMailStreet() {
		return mailStreet;
	}

	public void setMailStreet(String mailStreet) {
		this.mailStreet = mailStreet;
	}

	public String getMailTambon() {
		return mailTambon;
	}

	public void setMailTambon(String mailTambon) {
		this.mailTambon = mailTambon;
	}

	public String getMailAmphurId() {
		return mailAmphurId;
	}

	public void setMailAmphurId(String mailAmphurId) {
		this.mailAmphurId = mailAmphurId;
	}

	public String getMailProvinceId() {
		return mailProvinceId;
	}

	public void setMailProvinceId(String mailProvinceId) {
		this.mailProvinceId = mailProvinceId;
	}

	public String getMailPostCode() {
		return mailPostCode;
	}

	public void setMailPostCode(String mailPostCode) {
		this.mailPostCode = mailPostCode;
	}

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	
	public Long getVersion() {
		return version;
	}


	public void setVersion(Long version) {
		this.version = version;
	}


	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public Date getOrdering() {
		return ordering;
	}

	public void setOrdering(Date ordering) {
		this.ordering = ordering;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public String getStrParam() {
		return strParam;
	}

	public void setStrParam(String strParam) {
		this.strParam = strParam;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public String getMainFlag() {
		return mainFlag;
	}


	public void setMainFlag(String mainFlag) {
		this.mainFlag = mainFlag;
	}


	@Override
	public String getCreateBy() {
		return createBy;
	}

	@Override
	public Date getCreateDt() {
		return createDt;
	}

	@Override
	public String getUpdateBy() {
		return updateBy;
	}

	@Override
	public Date getUpdateDt() {
		return updateDt;
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

}
