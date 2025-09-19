package th.co.ais.domain.gm;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
//@Table(name="LU_COMPANY", schema="SLIMS")
//@Table(name="SEM_V_COMPANY", schema="SEM")View
@Table(name="SEM_CT_COMPANY", schema="SEM")
public class Company implements Serializable {

	private static final long serialVersionUID = 4424858176892683994L;
	// Fields
	private String rowId;
	private String description;
	private String thName;
	private String enName;
	private String address;
	private String subDistrict;
	private String district;
	private String province;
	private String street;


	// Property accessors
	@Id
	@Column(name = "COMPANY", unique = true, nullable = false, length = 10)
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "DESCRIPTION", length = 50)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "TH_NAME", length = 200)
	public String getThName() {
		return thName;
	}

	public void setThName(String thName) {
		this.thName = thName;
	}

	@Column(name = "EN_NAME", length = 200)
	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	@Column(name = "ADDRESS", length = 100)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "SUB_DISTRICT", length = 100)
	public String getSubDistrict() {
		return subDistrict;
	}

	public void setSubDistrict(String subDistrict) {
		this.subDistrict = subDistrict;
	}

	@Column(name = "DISTRICT", length = 50)
	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@Column(name = "PROVINCE", length = 50)
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "STREET", length = 100)
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

}