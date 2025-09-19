package th.co.ais.domain.gm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OM_MST_EMPLOYEE", schema="PFM")	
public class Employee implements Serializable {

	private static final long serialVersionUID = 7815288305966740799L;
	
	private String pin;
	private String positionName;
	private String orgId;
	private String telNo;
	private String employeeType;
	private String employeeGroup;
	private String mobileNo;
	private String email;
	private String costCenter;
	private String status;
	private String companyCode;
	private String userStamp;
	private String recDateTime;
	private String section;
	private String zone;
	private String floor;
	private String buildingCode;
	private String provinceName;
	private String engName;
	private String engSurname;
	private String thaiName;
	private String thaiSurname;
	private String orgDesc;
	private String positionId;
	
	@Id
	@Column(name = "PIN", unique = true, nullable = false, length = 8)
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	
	@Column(name = "POSITIONNAME", length = 120)
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	
	@Column(name = "ORGID", length = 8)
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	
	@Column(name = "TELNO", length = 120)
	public String getTelNo() {
		return telNo;
	}
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	
	@Column(name = "EMPLOYEETYPE", length = 2)
	public String getEmployeeType() {
		return employeeType;
	}
	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}
	
	@Column(name = "EMPLOYEEGROUP", length = 2)
	public String getEmployeeGroup() {
		return employeeGroup;
	}
	public void setEmployeeGroup(String employeeGroup) {
		this.employeeGroup = employeeGroup;
	}
	
	@Column(name = "MOBILENO", length = 20)
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	@Column(name = "EMAIL", length = 90)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "COSTCENTER", length = 12)
	public String getCostCenter() {
		return costCenter;
	}
	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}
	
	@Column(name = "STATUS", length = 2)
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name = "COMPANYCODE", length = 10)
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	
	@Column(name = "USERSTAMP", length = 15)
	public String getUserStamp() {
		return userStamp;
	}
	public void setUserStamp(String userStamp) {
		this.userStamp = userStamp;
	}
	
	@Column(name = "RECDATETIME", length = 20)
	public String getRecDateTime() {
		return recDateTime;
	}
	public void setRecDateTime(String recDateTime) {
		this.recDateTime = recDateTime;
	}
	
	@Column(name = "SECTION", length = 50)
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	
	@Column(name = "ZONE", length = 20)
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	
	@Column(name = "FLOOR", length = 20)
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	
	@Column(name = "BUILDINGCODE", length = 40)
	public String getBuildingCode() {
		return buildingCode;
	}
	public void setBuildingCode(String buildingCode) {
		this.buildingCode = buildingCode;
	}
	
	@Column(name = "PROVINCENAME", length = 20)
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	
	@Column(name = "ENGNAME", length = 25)
	public String getEngName() {
		return engName;
	}
	public void setEngName(String engName) {
		this.engName = engName;
	}
	
	@Column(name = "ENGSURNAME", length = 100)
	public String getEngSurname() {
		return engSurname;
	}
	public void setEngSurname(String engSurname) {
		this.engSurname = engSurname;
	}
	
	@Column(name = "THANAME", length = 40)
	public String getThaiName() {
		return thaiName;
	}
	public void setThaiName(String thaiName) {
		this.thaiName = thaiName;
	}
	
	@Column(name = "THASURNAME", length = 40)
	public String getThaiSurname() {
		return thaiSurname;
	}
	public void setThaiSurname(String thaiSurname) {
		this.thaiSurname = thaiSurname;
	}
	
	@Column(name = "ORGDESC", length = 120)
	public String getOrgDesc() {
		return orgDesc;
	}
	public void setOrgDesc(String orgDesc) {
		this.orgDesc = orgDesc;
	}
	
	@Column(name = "POSITIONID", length = 12)
	public String getPositionId() {
		return positionId;
	}
	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}
	
}
