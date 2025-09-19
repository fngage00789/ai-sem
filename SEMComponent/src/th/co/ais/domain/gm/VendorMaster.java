package th.co.ais.domain.gm;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;
import th.co.ais.domain.AbstractDomain;

@Entity
@Table(name = "SEM_CT_VENDOR_MASTER", schema = "SEM")
public class VendorMaster extends AbstractDomain{

	// Fields
	private String rowId;
	private Long version;
	private String vendorCode;
	private String vendorName;
	private String vendorType;
	private String idCard;
	private String tax13;
	private String address;
	private String province;
	private String telephone;
	private String mobileNo;
	private String fax;
	private String contactName;
	private String remark;
	private String vendorStatus;
	private String recordStatus;
	private Date createDt;
	private String createBy;
	private Date updateDt;
	private String updateBy;
	private String vendorName1;
	private String vendorName2;
	private String vendorName3;
	private String vendorName4;
	private String address1;
	private String address2;
	private String address3;
	private String address4;
	private String district;
	private String amphur;
	private String city;
	private String postCode;
	private String country;
	private String ptaxFlag;
	private String hqFlag;
	private String branchNo;
	private String email;
	private String sapVendorName1;
	private String sapVendorName2;
	private String sapVendorName3;
	private String sapVendorName4;
	private String rtContactName;
	private String rtAddress1;
	private String rtAddress2;
	private String rtDistrict;
	private String rtAmphur;
	private String rtCity;
	private String rtPostCode;
	private String rtTelephone;
	private String rtMobileNo;
	private String rtFax;
	private String rtEmail;
	private String rtPtaxFlag;
	private String elContactName;
	private String elAddress1;
	private String elAddress2;
	private String elDistrict;
	private String elAmphur;
	private String elCity;
	private String elPostCode;
	private String elTelephone;
	private String elMobileNo;
	private String elFax;
	private String elEmail;
	private String elPtaxFlag;
	private String ptContactName;
	private String ptAddress1;
	private String ptAddress2;
	private String ptDistrict;
	private String ptAmphur;
	private String ptCity;
	private String ptPostCode;
	private String ptTelephone;
	private String ptMobileNo;
	private String ptFax;
	private String ptEmail;
	private String ptPtaxFlag;
	private String irContactName;
	private String irAddress1;
	private String irAddress2;
	private String irDistrict;
	private String irAmphur;
	private String irCity;
	private String irPostCode;
	private String irTelephone;
	private String irMobileNo;
	private String irFax;
	private String irEmail;
	private String irPtaxFlag;
	private String vendorBatchNo;
	private String vendorLotNo;
	private String sapRemark;
	private String districtCode;
	private String amphurCode;
	private String cityCode;
	private String rtDistrictCode;
	private String rtAmphurCode;
	private String rtCityCode;
	private String elDistrictCode;
	private String elAmphurCode;
	private String elCityCode;
	private String ptDistrictCode;
	private String ptAmphurCode;
	private String ptCityCode;
	private String irDistrictCode;
	private String irAmphurCode;
	private String irCityCode;
	private String taxId;
	// -
	
	private boolean selected;
	private String vendorStatusDesc;
	
	//added by NEW 20151029
	private String blockFlag;
	
	public VendorMaster() {
	}

	public VendorMaster(String rowId, String recordStatus) {
		this.rowId = rowId;
		this.recordStatus = recordStatus;
	}

	public VendorMaster(String rowId, String vendorCode,
			String vendorName, String vendorType, String idCard, String tax13,
			String address, String province, String telephone, String mobileNo,
			String fax, String contactName, String remark, String vendorStatus,
			String recordStatus, Date createDt, String createBy, Date updateDt,
			String updateBy, String vendorName1, String vendorName2,
			String vendorName3, String vendorName4, String address1,
			String address2, String address3, String address4, String district,
			String amphur, String city, String postCode, String country,
			String ptaxFlag, String hqFlag, String branchNo, String email,
			String sapVendorName1, String sapVendorName2,
			String sapVendorName3, String sapVendorName4, String rtContactName,
			String rtAddress1, String rtAddress2, String rtDistrict,
			String rtAmphur, String rtCity, String rtPostCode,
			String rtTelephone, String rtMobileNo, String rtFax,
			String rtEmail, String rtPtaxFlag, String elContactName,
			String elAddress1, String elAddress2, String elDistrict,
			String elAmphur, String elCity, String elPostCode,
			String elTelephone, String elMobileNo, String elFax,
			String elEmail, String elPtaxFlag, String ptContactName,
			String ptAddress1, String ptAddress2, String ptDistrict,
			String ptAmphur, String ptCity, String ptPostCode,
			String ptTelephone, String ptMobileNo, String ptFax,
			String ptEmail, String ptPtaxFlag, String irContactName,
			String irAddress1, String irAddress2, String irDistrict,
			String irAmphur, String irCity, String irPostCode,
			String irTelephone, String irMobileNo, String irFax,
			String irEmail, String irPtaxFlag, String vendorBatchNo,
			String vendorLotNo, String sapRemark, String districtCode,
			String amphurCode, String cityCode, String rtDistrictCode,
			String rtAmphurCode, String rtCityCode, String elDistrictCode,
			String elAmphurCode, String elCityCode, String ptDistrictCode,
			String ptAmphurCode, String ptCityCode, String irDistrictCode,
			String irAmphurCode, String irCityCode, String taxId) {
		this.rowId = rowId;
		this.vendorCode = vendorCode;
		this.vendorName = vendorName;
		this.vendorType = vendorType;
		this.idCard = idCard;
		this.tax13 = tax13;
		this.address = address;
		this.province = province;
		this.telephone = telephone;
		this.mobileNo = mobileNo;
		this.fax = fax;
		this.contactName = contactName;
		this.remark = remark;
		this.vendorStatus = vendorStatus;
		this.recordStatus = recordStatus;
		this.createDt = createDt;
		this.createBy = createBy;
		this.updateDt = updateDt;
		this.updateBy = updateBy;
		this.vendorName1 = vendorName1;
		this.vendorName2 = vendorName2;
		this.vendorName3 = vendorName3;
		this.vendorName4 = vendorName4;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.address4 = address4;
		this.district = district;
		this.amphur = amphur;
		this.city = city;
		this.postCode = postCode;
		this.country = country;
		this.ptaxFlag = ptaxFlag;
		this.hqFlag = hqFlag;
		this.branchNo = branchNo;
		this.email = email;
		this.sapVendorName1 = sapVendorName1;
		this.sapVendorName2 = sapVendorName2;
		this.sapVendorName3 = sapVendorName3;
		this.sapVendorName4 = sapVendorName4;
		this.rtContactName = rtContactName;
		this.rtAddress1 = rtAddress1;
		this.rtAddress2 = rtAddress2;
		this.rtDistrict = rtDistrict;
		this.rtAmphur = rtAmphur;
		this.rtCity = rtCity;
		this.rtPostCode = rtPostCode;
		this.rtTelephone = rtTelephone;
		this.rtMobileNo = rtMobileNo;
		this.rtFax = rtFax;
		this.rtEmail = rtEmail;
		this.rtPtaxFlag = rtPtaxFlag;
		this.elContactName = elContactName;
		this.elAddress1 = elAddress1;
		this.elAddress2 = elAddress2;
		this.elDistrict = elDistrict;
		this.elAmphur = elAmphur;
		this.elCity = elCity;
		this.elPostCode = elPostCode;
		this.elTelephone = elTelephone;
		this.elMobileNo = elMobileNo;
		this.elFax = elFax;
		this.elEmail = elEmail;
		this.elPtaxFlag = elPtaxFlag;
		this.ptContactName = ptContactName;
		this.ptAddress1 = ptAddress1;
		this.ptAddress2 = ptAddress2;
		this.ptDistrict = ptDistrict;
		this.ptAmphur = ptAmphur;
		this.ptCity = ptCity;
		this.ptPostCode = ptPostCode;
		this.ptTelephone = ptTelephone;
		this.ptMobileNo = ptMobileNo;
		this.ptFax = ptFax;
		this.ptEmail = ptEmail;
		this.ptPtaxFlag = ptPtaxFlag;
		this.irContactName = irContactName;
		this.irAddress1 = irAddress1;
		this.irAddress2 = irAddress2;
		this.irDistrict = irDistrict;
		this.irAmphur = irAmphur;
		this.irCity = irCity;
		this.irPostCode = irPostCode;
		this.irTelephone = irTelephone;
		this.irMobileNo = irMobileNo;
		this.irFax = irFax;
		this.irEmail = irEmail;
		this.irPtaxFlag = irPtaxFlag;
		this.vendorBatchNo = vendorBatchNo;
		this.vendorLotNo = vendorLotNo;
		this.sapRemark = sapRemark;
		this.districtCode = districtCode;
		this.amphurCode = amphurCode;
		this.cityCode = cityCode;
		this.rtDistrictCode = rtDistrictCode;
		this.rtAmphurCode = rtAmphurCode;
		this.rtCityCode = rtCityCode;
		this.elDistrictCode = elDistrictCode;
		this.elAmphurCode = elAmphurCode;
		this.elCityCode = elCityCode;
		this.ptDistrictCode = ptDistrictCode;
		this.ptAmphurCode = ptAmphurCode;
		this.ptCityCode = ptCityCode;
		this.irDistrictCode = irDistrictCode;
		this.irAmphurCode = irAmphurCode;
		this.irCityCode = irCityCode;
		this.taxId = taxId;
	}

	@Id
	@Column(name = "VENDOR_MASTER_ID", unique = true, nullable = false, length = 50)
	public String getRowId() {
		return this.rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Version
	@Column(name = "VERSION", precision = 10, scale = 0)
	public Long getVersion() {
		return this.version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Column(name = "VENDOR_CODE", length = 50)
	public String getVendorCode() {
		return this.vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	@Column(name = "VENDOR_NAME")
	public String getVendorName() {
		return this.vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	@Column(name = "VENDOR_TYPE", length = 5)
	public String getVendorType() {
		return this.vendorType;
	}

	public void setVendorType(String vendorType) {
		this.vendorType = vendorType;
	}

	@Column(name = "ID_CARD", length = 20)
	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	@Column(name = "TAX13", length = 20)
	public String getTax13() {
		return this.tax13;
	}

	public void setTax13(String tax13) {
		this.tax13 = tax13;
	}

	@Column(name = "ADDRESS")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "PROVINCE")
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "TELEPHONE")
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "MOBILE_NO")
	public String getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Column(name = "FAX")
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "CONTACT_NAME")
	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "VENDOR_STATUS", length = 5)
	public String getVendorStatus() {
		return this.vendorStatus;
	}

	public void setVendorStatus(String vendorStatus) {
		this.vendorStatus = vendorStatus;
	}

	@Column(name = "RECORD_STATUS", nullable = false, length = 1)
	public String getRecordStatus() {
		return this.recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DT", length = 7)
	public Date getCreateDt() {
		return this.createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	@Column(name = "CREATE_BY", length = 50)
	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATE_DT", length = 7)
	public Date getUpdateDt() {
		return this.updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	@Column(name = "UPDATE_BY", length = 50)
	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	@Column(name = "VENDOR_NAME1", length = 35)
	public String getVendorName1() {
		return this.vendorName1;
	}

	public void setVendorName1(String vendorName1) {
		this.vendorName1 = vendorName1;
	}

	@Column(name = "VENDOR_NAME2", length = 35)
	public String getVendorName2() {
		return this.vendorName2;
	}

	public void setVendorName2(String vendorName2) {
		this.vendorName2 = vendorName2;
	}

	@Column(name = "VENDOR_NAME3", length = 35)
	public String getVendorName3() {
		return this.vendorName3;
	}

	public void setVendorName3(String vendorName3) {
		this.vendorName3 = vendorName3;
	}

	@Column(name = "VENDOR_NAME4", length = 35)
	public String getVendorName4() {
		return this.vendorName4;
	}

	public void setVendorName4(String vendorName4) {
		this.vendorName4 = vendorName4;
	}

	@Column(name = "ADDRESS1", length = 35)
	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	@Column(name = "ADDRESS2", length = 35)
	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	@Column(name = "ADDRESS3", length = 35)
	public String getAddress3() {
		return this.address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	@Column(name = "ADDRESS4", length = 35)
	public String getAddress4() {
		return this.address4;
	}

	public void setAddress4(String address4) {
		this.address4 = address4;
	}

	@Column(name = "DISTRICT")
	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@Column(name = "AMPHUR")
	public String getAmphur() {
		return this.amphur;
	}

	public void setAmphur(String amphur) {
		this.amphur = amphur;
	}

	@Column(name = "CITY", length = 35)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "POST_CODE", length = 10)
	public String getPostCode() {
		return this.postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	@Column(name = "COUNTRY", length = 3)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "PTAX_FLAG", length = 5)
	public String getPtaxFlag() {
		return this.ptaxFlag;
	}

	public void setPtaxFlag(String ptaxFlag) {
		this.ptaxFlag = ptaxFlag;
	}

	@Column(name = "HQ_FLAG", length = 2)
	public String getHqFlag() {
		return this.hqFlag;
	}

	public void setHqFlag(String hqFlag) {
		this.hqFlag = hqFlag;
	}

	@Column(name = "BRANCH_NO", length = 5)
	public String getBranchNo() {
		return this.branchNo;
	}

	public void setBranchNo(String branchNo) {
		this.branchNo = branchNo;
	}

	@Column(name = "EMAIL")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "SAP_VENDOR_NAME1", length = 60)
	public String getSapVendorName1() {
		return this.sapVendorName1;
	}

	public void setSapVendorName1(String sapVendorName1) {
		this.sapVendorName1 = sapVendorName1;
	}

	@Column(name = "SAP_VENDOR_NAME2", length = 60)
	public String getSapVendorName2() {
		return this.sapVendorName2;
	}

	public void setSapVendorName2(String sapVendorName2) {
		this.sapVendorName2 = sapVendorName2;
	}

	@Column(name = "SAP_VENDOR_NAME3", length = 60)
	public String getSapVendorName3() {
		return this.sapVendorName3;
	}

	public void setSapVendorName3(String sapVendorName3) {
		this.sapVendorName3 = sapVendorName3;
	}

	@Column(name = "SAP_VENDOR_NAME4", length = 60)
	public String getSapVendorName4() {
		return this.sapVendorName4;
	}

	public void setSapVendorName4(String sapVendorName4) {
		this.sapVendorName4 = sapVendorName4;
	}

	@Column(name = "RT_CONTACT_NAME")
	public String getRtContactName() {
		return this.rtContactName;
	}

	public void setRtContactName(String rtContactName) {
		this.rtContactName = rtContactName;
	}

	@Column(name = "RT_ADDRESS1", length = 70)
	public String getRtAddress1() {
		return this.rtAddress1;
	}

	public void setRtAddress1(String rtAddress1) {
		this.rtAddress1 = rtAddress1;
	}

	@Column(name = "RT_ADDRESS2", length = 70)
	public String getRtAddress2() {
		return this.rtAddress2;
	}

	public void setRtAddress2(String rtAddress2) {
		this.rtAddress2 = rtAddress2;
	}

	@Column(name = "RT_DISTRICT")
	public String getRtDistrict() {
		return this.rtDistrict;
	}

	public void setRtDistrict(String rtDistrict) {
		this.rtDistrict = rtDistrict;
	}

	@Column(name = "RT_AMPHUR")
	public String getRtAmphur() {
		return this.rtAmphur;
	}

	public void setRtAmphur(String rtAmphur) {
		this.rtAmphur = rtAmphur;
	}

	@Column(name = "RT_CITY", length = 35)
	public String getRtCity() {
		return this.rtCity;
	}

	public void setRtCity(String rtCity) {
		this.rtCity = rtCity;
	}

	@Column(name = "RT_POST_CODE", length = 10)
	public String getRtPostCode() {
		return this.rtPostCode;
	}

	public void setRtPostCode(String rtPostCode) {
		this.rtPostCode = rtPostCode;
	}

	@Column(name = "RT_TELEPHONE")
	public String getRtTelephone() {
		return this.rtTelephone;
	}

	public void setRtTelephone(String rtTelephone) {
		this.rtTelephone = rtTelephone;
	}

	@Column(name = "RT_MOBILE_NO")
	public String getRtMobileNo() {
		return this.rtMobileNo;
	}

	public void setRtMobileNo(String rtMobileNo) {
		this.rtMobileNo = rtMobileNo;
	}

	@Column(name = "RT_FAX")
	public String getRtFax() {
		return this.rtFax;
	}

	public void setRtFax(String rtFax) {
		this.rtFax = rtFax;
	}

	@Column(name = "RT_EMAIL")
	public String getRtEmail() {
		return this.rtEmail;
	}

	public void setRtEmail(String rtEmail) {
		this.rtEmail = rtEmail;
	}

	@Column(name = "RT_PTAX_FLAG", length = 5)
	public String getRtPtaxFlag() {
		return this.rtPtaxFlag;
	}

	public void setRtPtaxFlag(String rtPtaxFlag) {
		this.rtPtaxFlag = rtPtaxFlag;
	}

	@Column(name = "EL_CONTACT_NAME")
	public String getElContactName() {
		return this.elContactName;
	}

	public void setElContactName(String elContactName) {
		this.elContactName = elContactName;
	}

	@Column(name = "EL_ADDRESS1", length = 70)
	public String getElAddress1() {
		return this.elAddress1;
	}

	public void setElAddress1(String elAddress1) {
		this.elAddress1 = elAddress1;
	}

	@Column(name = "EL_ADDRESS2", length = 70)
	public String getElAddress2() {
		return this.elAddress2;
	}

	public void setElAddress2(String elAddress2) {
		this.elAddress2 = elAddress2;
	}

	@Column(name = "EL_DISTRICT")
	public String getElDistrict() {
		return this.elDistrict;
	}

	public void setElDistrict(String elDistrict) {
		this.elDistrict = elDistrict;
	}

	@Column(name = "EL_AMPHUR")
	public String getElAmphur() {
		return this.elAmphur;
	}

	public void setElAmphur(String elAmphur) {
		this.elAmphur = elAmphur;
	}

	@Column(name = "EL_CITY", length = 35)
	public String getElCity() {
		return this.elCity;
	}

	public void setElCity(String elCity) {
		this.elCity = elCity;
	}

	@Column(name = "EL_POST_CODE", length = 10)
	public String getElPostCode() {
		return this.elPostCode;
	}

	public void setElPostCode(String elPostCode) {
		this.elPostCode = elPostCode;
	}

	@Column(name = "EL_TELEPHONE")
	public String getElTelephone() {
		return this.elTelephone;
	}

	public void setElTelephone(String elTelephone) {
		this.elTelephone = elTelephone;
	}

	@Column(name = "EL_MOBILE_NO")
	public String getElMobileNo() {
		return this.elMobileNo;
	}

	public void setElMobileNo(String elMobileNo) {
		this.elMobileNo = elMobileNo;
	}

	@Column(name = "EL_FAX")
	public String getElFax() {
		return this.elFax;
	}

	public void setElFax(String elFax) {
		this.elFax = elFax;
	}

	@Column(name = "EL_EMAIL")
	public String getElEmail() {
		return this.elEmail;
	}

	public void setElEmail(String elEmail) {
		this.elEmail = elEmail;
	}

	@Column(name = "EL_PTAX_FLAG", length = 5)
	public String getElPtaxFlag() {
		return this.elPtaxFlag;
	}

	public void setElPtaxFlag(String elPtaxFlag) {
		this.elPtaxFlag = elPtaxFlag;
	}

	@Column(name = "PT_CONTACT_NAME")
	public String getPtContactName() {
		return this.ptContactName;
	}

	public void setPtContactName(String ptContactName) {
		this.ptContactName = ptContactName;
	}

	@Column(name = "PT_ADDRESS1", length = 70)
	public String getPtAddress1() {
		return this.ptAddress1;
	}

	public void setPtAddress1(String ptAddress1) {
		this.ptAddress1 = ptAddress1;
	}

	@Column(name = "PT_ADDRESS2", length = 70)
	public String getPtAddress2() {
		return this.ptAddress2;
	}

	public void setPtAddress2(String ptAddress2) {
		this.ptAddress2 = ptAddress2;
	}

	@Column(name = "PT_DISTRICT")
	public String getPtDistrict() {
		return this.ptDistrict;
	}

	public void setPtDistrict(String ptDistrict) {
		this.ptDistrict = ptDistrict;
	}

	@Column(name = "PT_AMPHUR")
	public String getPtAmphur() {
		return this.ptAmphur;
	}

	public void setPtAmphur(String ptAmphur) {
		this.ptAmphur = ptAmphur;
	}

	@Column(name = "PT_CITY", length = 35)
	public String getPtCity() {
		return this.ptCity;
	}

	public void setPtCity(String ptCity) {
		this.ptCity = ptCity;
	}

	@Column(name = "PT_POST_CODE", length = 10)
	public String getPtPostCode() {
		return this.ptPostCode;
	}

	public void setPtPostCode(String ptPostCode) {
		this.ptPostCode = ptPostCode;
	}

	@Column(name = "PT_TELEPHONE")
	public String getPtTelephone() {
		return this.ptTelephone;
	}

	public void setPtTelephone(String ptTelephone) {
		this.ptTelephone = ptTelephone;
	}

	@Column(name = "PT_MOBILE_NO")
	public String getPtMobileNo() {
		return this.ptMobileNo;
	}

	public void setPtMobileNo(String ptMobileNo) {
		this.ptMobileNo = ptMobileNo;
	}

	@Column(name = "PT_FAX")
	public String getPtFax() {
		return this.ptFax;
	}

	public void setPtFax(String ptFax) {
		this.ptFax = ptFax;
	}

	@Column(name = "PT_EMAIL")
	public String getPtEmail() {
		return this.ptEmail;
	}

	public void setPtEmail(String ptEmail) {
		this.ptEmail = ptEmail;
	}

	@Column(name = "PT_PTAX_FLAG", length = 5)
	public String getPtPtaxFlag() {
		return this.ptPtaxFlag;
	}

	public void setPtPtaxFlag(String ptPtaxFlag) {
		this.ptPtaxFlag = ptPtaxFlag;
	}

	@Column(name = "IR_CONTACT_NAME")
	public String getIrContactName() {
		return this.irContactName;
	}

	public void setIrContactName(String irContactName) {
		this.irContactName = irContactName;
	}

	@Column(name = "IR_ADDRESS1", length = 70)
	public String getIrAddress1() {
		return this.irAddress1;
	}

	public void setIrAddress1(String irAddress1) {
		this.irAddress1 = irAddress1;
	}

	@Column(name = "IR_ADDRESS2", length = 70)
	public String getIrAddress2() {
		return this.irAddress2;
	}

	public void setIrAddress2(String irAddress2) {
		this.irAddress2 = irAddress2;
	}

	@Column(name = "IR_DISTRICT")
	public String getIrDistrict() {
		return this.irDistrict;
	}

	public void setIrDistrict(String irDistrict) {
		this.irDistrict = irDistrict;
	}

	@Column(name = "IR_AMPHUR")
	public String getIrAmphur() {
		return this.irAmphur;
	}

	public void setIrAmphur(String irAmphur) {
		this.irAmphur = irAmphur;
	}

	@Column(name = "IR_CITY", length = 35)
	public String getIrCity() {
		return this.irCity;
	}

	public void setIrCity(String irCity) {
		this.irCity = irCity;
	}

	@Column(name = "IR_POST_CODE", length = 10)
	public String getIrPostCode() {
		return this.irPostCode;
	}

	public void setIrPostCode(String irPostCode) {
		this.irPostCode = irPostCode;
	}

	@Column(name = "IR_TELEPHONE")
	public String getIrTelephone() {
		return this.irTelephone;
	}

	public void setIrTelephone(String irTelephone) {
		this.irTelephone = irTelephone;
	}

	@Column(name = "IR_MOBILE_NO")
	public String getIrMobileNo() {
		return this.irMobileNo;
	}

	public void setIrMobileNo(String irMobileNo) {
		this.irMobileNo = irMobileNo;
	}

	@Column(name = "IR_FAX")
	public String getIrFax() {
		return this.irFax;
	}

	public void setIrFax(String irFax) {
		this.irFax = irFax;
	}

	@Column(name = "IR_EMAIL")
	public String getIrEmail() {
		return this.irEmail;
	}

	public void setIrEmail(String irEmail) {
		this.irEmail = irEmail;
	}

	@Column(name = "IR_PTAX_FLAG", length = 5)
	public String getIrPtaxFlag() {
		return this.irPtaxFlag;
	}

	public void setIrPtaxFlag(String irPtaxFlag) {
		this.irPtaxFlag = irPtaxFlag;
	}

	@Column(name = "VENDOR_BATCH_NO", length = 20)
	public String getVendorBatchNo() {
		return this.vendorBatchNo;
	}

	public void setVendorBatchNo(String vendorBatchNo) {
		this.vendorBatchNo = vendorBatchNo;
	}

	@Column(name = "VENDOR_LOT_NO", length = 20)
	public String getVendorLotNo() {
		return this.vendorLotNo;
	}

	public void setVendorLotNo(String vendorLotNo) {
		this.vendorLotNo = vendorLotNo;
	}

	@Column(name = "SAP_REMARK")
	public String getSapRemark() {
		return this.sapRemark;
	}

	public void setSapRemark(String sapRemark) {
		this.sapRemark = sapRemark;
	}

	@Column(name = "DISTRICT_CODE", length = 20)
	public String getDistrictCode() {
		return this.districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	@Column(name = "AMPHUR_CODE", length = 20)
	public String getAmphurCode() {
		return this.amphurCode;
	}

	public void setAmphurCode(String amphurCode) {
		this.amphurCode = amphurCode;
	}

	@Column(name = "CITY_CODE", length = 20)
	public String getCityCode() {
		return this.cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	@Column(name = "RT_DISTRICT_CODE", length = 20)
	public String getRtDistrictCode() {
		return this.rtDistrictCode;
	}

	public void setRtDistrictCode(String rtDistrictCode) {
		this.rtDistrictCode = rtDistrictCode;
	}

	@Column(name = "RT_AMPHUR_CODE", length = 20)
	public String getRtAmphurCode() {
		return this.rtAmphurCode;
	}

	public void setRtAmphurCode(String rtAmphurCode) {
		this.rtAmphurCode = rtAmphurCode;
	}

	@Column(name = "RT_CITY_CODE", length = 20)
	public String getRtCityCode() {
		return this.rtCityCode;
	}

	public void setRtCityCode(String rtCityCode) {
		this.rtCityCode = rtCityCode;
	}

	@Column(name = "EL_DISTRICT_CODE", length = 20)
	public String getElDistrictCode() {
		return this.elDistrictCode;
	}

	public void setElDistrictCode(String elDistrictCode) {
		this.elDistrictCode = elDistrictCode;
	}

	@Column(name = "EL_AMPHUR_CODE", length = 20)
	public String getElAmphurCode() {
		return this.elAmphurCode;
	}

	public void setElAmphurCode(String elAmphurCode) {
		this.elAmphurCode = elAmphurCode;
	}

	@Column(name = "EL_CITY_CODE", length = 20)
	public String getElCityCode() {
		return this.elCityCode;
	}

	public void setElCityCode(String elCityCode) {
		this.elCityCode = elCityCode;
	}

	@Column(name = "PT_DISTRICT_CODE", length = 20)
	public String getPtDistrictCode() {
		return this.ptDistrictCode;
	}

	public void setPtDistrictCode(String ptDistrictCode) {
		this.ptDistrictCode = ptDistrictCode;
	}

	@Column(name = "PT_AMPHUR_CODE", length = 20)
	public String getPtAmphurCode() {
		return this.ptAmphurCode;
	}

	public void setPtAmphurCode(String ptAmphurCode) {
		this.ptAmphurCode = ptAmphurCode;
	}

	@Column(name = "PT_CITY_CODE", length = 20)
	public String getPtCityCode() {
		return this.ptCityCode;
	}

	public void setPtCityCode(String ptCityCode) {
		this.ptCityCode = ptCityCode;
	}

	@Column(name = "IR_DISTRICT_CODE", length = 20)
	public String getIrDistrictCode() {
		return this.irDistrictCode;
	}

	public void setIrDistrictCode(String irDistrictCode) {
		this.irDistrictCode = irDistrictCode;
	}

	@Column(name = "IR_AMPHUR_CODE", length = 20)
	public String getIrAmphurCode() {
		return this.irAmphurCode;
	}

	public void setIrAmphurCode(String irAmphurCode) {
		this.irAmphurCode = irAmphurCode;
	}

	@Column(name = "IR_CITY_CODE", length = 20)
	public String getIrCityCode() {
		return this.irCityCode;
	}

	public void setIrCityCode(String irCityCode) {
		this.irCityCode = irCityCode;
	}

	@Column(name = "TAX_ID", length = 20)
	public String getTaxId() {
		return this.taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}
	
	@Transient
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	@Transient
	public String getVendorStatusDesc() {
		return vendorStatusDesc;
	}
	
	public void setVendorStatusDesc(String vendorStatusDesc) {
		this.vendorStatusDesc = vendorStatusDesc;
	}
	
	@Column(name = "BLOCK_FLAG")
	public String getBlockFlag() {
		return blockFlag;
	}

	public void setBlockFlag(String blockFlag) {
		this.blockFlag = blockFlag;
	}
	
}