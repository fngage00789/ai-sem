package th.co.ais.domain.gm;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import th.co.ais.domain.AbstractDomain;

@Entity
@Table(name="VW_LU_LOCATION", schema="SLIMS2")
public class Location extends AbstractDomain {

	// Fields

	private String locationId;
	private String locationCode;
	private String locationThaiName;
	private String country;
	private String region;
	private String address;
	private String tumbol;
	private String amphur;
	private String province;
	private String latitudeWgs84;
	private String longitudeWgs84;
	private String company;
	private Date updateDate;
	private String updateUser;
	private String locationEngName;
	private String status;
	private String reqContract;
	private String zipCode;
	private String fax;
	private String telephone;
	private String locationType;
	private boolean selected;
	
	// Property accessors
	@Id
	@Column(name = "LOCATION_ID", unique = true, nullable = false, length = 15)
	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	@Column(name = "LOCATION_CODE", length = 50)
	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	@Column(name = "LOCATION_THAI_NAME")
	public String getLocationThaiName() {
		return locationThaiName;
	}

	public void setLocationThaiName(String locationThaiName) {
		this.locationThaiName = locationThaiName;
	}

	@Column(name = "COUNTRY", length = 15)
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "REGION", length = 3)
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Column(name = "ADDRESS")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "TUMBOL", length = 50)
	public String getTumbol() {
		return tumbol;
	}

	public void setTumbol(String tumbol) {
		this.tumbol = tumbol;
	}

	@Column(name = "AMPHUR", length = 50)
	public String getAmphur() {
		return amphur;
	}

	public void setAmphur(String amphur) {
		this.amphur = amphur;
	}

	@Column(name = "PROVINCE", length = 50)
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "LATITUDE_WGS84", length = 50)
	public String getLatitudeWgs84() {
		return latitudeWgs84;
	}

	public void setLatitudeWgs84(String latitudeWgs84) {
		this.latitudeWgs84 = latitudeWgs84;
	}

	@Column(name = "LONGITUDE_WGS84", length = 50)
	public String getLongitudeWgs84() {
		return longitudeWgs84;
	}

	public void setLongitudeWgs84(String longitudeWgs84) {
		this.longitudeWgs84 = longitudeWgs84;
	}

	@Column(name = "COMPANY", length = 15)
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	
	@Column(name = "UPDATE_DATE")
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "UPDATE_USER", length = 30)
	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	@Column(name = "LOCATION_ENG_NAME")
	public String getLocationEngName() {
		return locationEngName;
	}

	public void setLocationEngName(String locationEngName) {
		this.locationEngName = locationEngName;
	}

	@Column(name = "STATUS", length = 20)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "REQ_CONTRACT", length = 1)
	public String getReqContract() {
		return reqContract;
	}

	public void setReqContract(String reqContract) {
		this.reqContract = reqContract;
	}

	@Column(name = "ZIP_CODE", length = 20)
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Column(name = "FAX", length = 50)
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "TELEPHONE", length = 50)
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "LOCATION_TYPE", length = 100)
	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	@Override
	public String getCreateBy() {
		// TODO Auto-generated method stub
		return createBy;
	}

	@Override
	public Date getCreateDt() {
		// TODO Auto-generated method stub
		return createDt;
	}

	@Override
	public String getUpdateBy() {
		// TODO Auto-generated method stub
		return updateBy;
	}

	@Override
	public Date getUpdateDt() {
		// TODO Auto-generated method stub
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

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
}