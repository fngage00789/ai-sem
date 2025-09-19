package th.co.ais.domain.gm;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import th.co.ais.domain.AbstractDomain;

@Entity
@Table(name="SEM_CT_PAYEE_MASTER", schema="SEM")
public class PayeeMaster extends AbstractDomain {

	private static final long serialVersionUID = -1158049455786092380L;
	
	private String rowId;
	private String payeeCode;
	private String payeeName;
	private String vendorType;
	private String idCard;
	private String taxId;
	private String address;
	private String district;
	private String districtCode;
	private String amphur;
	private String amphurCode;
	
	private String province;
	private String postCode;
	private String telephone;
	private String mobileNo;
	private String fax;
	private String contractName;
	private String remark;
	private String payeeStatus;
	private String recordStatus;
	private Long version;
	private String email; 
	
	private String address1;
	private String address2;
	private String city;
	private String cityCode;
	private String taxId13;
	@Id
	@Column(name = "PAYEE_MASTER_ID")
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "PAYEE_CODE")
	public String getPayeeCode() {
		return payeeCode;
	}

	public void setPayeeCode(String payeeCode) {
		this.payeeCode = payeeCode;
	}

	@Column(name = "PAYEE_NAME")
	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}


	@Column(name = "VENDOR_TYPE")
	public String getVendorType() {
		return vendorType;
	}

	public void setVendorType(String vendorType) {
		this.vendorType = vendorType;
	}

	@Column(name = "ID_CARD")
	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	@Column(name = "TAX_ID")
	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	@Column(name = "ADDRESS")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "DISTRICT")
	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}
	
	@Column(name = "DISTRICT_CODE")
	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	@Column(name = "AMPHUR")
	public String getAmphur() {
		return this.amphur;
	}

	public void setAmphur(String amphur) {
		this.amphur = amphur;
	}
	
	@Column(name = "AMPHUR_CODE")
	public String getAmphurCode() {
		return this.amphurCode;
	}

	public void setAmphurCode(String amphurCode) {
		this.amphurCode = amphurCode;
	}

	@Column(name = "PROVINCE")
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "POST_CODE")
	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	@Column(name = "TELEPHONE")
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "MOBILE_NO")
	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Column(name = "FAX")
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "CONTACT_NAME")
	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "RECORD_STATUS" , nullable = false)
	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	
	@Column(name = "PAYEE_STATUS")
	public String getPayeeStatus() {
		return payeeStatus;
	}

	public void setPayeeStatus(String payeeStatus) {
		this.payeeStatus = payeeStatus;
	}

	@Column(name = "ADDRESS1")
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	
	@Column(name = "ADDRESS2")
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	@Column(name = "CITY")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name = "CITY_CODE")
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	
	@Version
	@Column(name = "VERSION", precision = 10, scale = 0 , nullable = false)
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	
	@Column(name = "CREATE_DT")
	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	@Column(name = "CREATE_BY", length = 50)
	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Column(name = "UPDATE_DT")
	public Date getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	@Column(name = "UPDATE_BY", length = 50)
	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	@Column(name = "TAX13", length = 20)
	public String getTaxId13() {
		return taxId13;
	}

	public void setTaxId13(String taxId13) {
		this.taxId13 = taxId13;
	}
	
	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "PayeeMaster [address=" + address + ", address1=" + address1
				+ ", address2=" + address2 + ", amphur=" + amphur + ", city="
				+ city + ", contractName=" + contractName + ", district="
				+ district + ", fax=" + fax + ", idCard=" + idCard
				+ ", mobileNo=" + mobileNo + ", payeeCode=" + payeeCode
				+ ", payeeName=" + payeeName + ", payeeStatus=" + payeeStatus
				+ ", postCode=" + postCode + ", province=" + province
				+ ", recordStatus=" + recordStatus + ", remark=" + remark
				+ ", rowId=" + rowId + ", taxId=" + taxId + ", telephone="
				+ telephone + ", vendorType=" + vendorType + ", version="
				+ version + "]";
	}
	
}
