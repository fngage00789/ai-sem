package th.co.ais.domain.rt;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import th.co.ais.domain.AbstractDomain;

/**
 * SemRtRentalVendor entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SEM_RT_RENTAL_VENDOR", schema = "SEM")
public class RentalVendor extends AbstractDomain {

	// Fields

	private String rowId;
	private String company;
	private String rentalMasterId;
	private String siteInfoId;
	private String siteLessorId;
	private String vendorMasterId;
	private String rentalVendorName;
	private String recordStatus;
	private Long version;

	// Property accessors
	@Id
	@Column(name = "RENTAL_VENDOR_ID", unique = true, nullable = false, length = 50)
	public String getRowId() {
		return this.rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "COMPANY", length = 5)
	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "RENTAL_MASTER_ID", length = 50)
	public String getRentalMasterId() {
		return this.rentalMasterId;
	}

	public void setRentalMasterId(String rentalMasterId) {
		this.rentalMasterId = rentalMasterId;
	}

	@Column(name = "SITE_INFO_ID", length = 50)
	public String getSiteInfoId() {
		return this.siteInfoId;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}

	@Column(name = "SITE_LESSOR_ID", length = 50)
	public String getSiteLessorId() {
		return this.siteLessorId;
	}

	public void setSiteLessorId(String siteLessorId) {
		this.siteLessorId = siteLessorId;
	}

	@Column(name = "VENDOR_MASTER_ID", length = 50)
	public String getVendorMasterId() {
		return this.vendorMasterId;
	}

	public void setVendorMasterId(String vendorMasterId) {
		this.vendorMasterId = vendorMasterId;
	}

	@Column(name = "RENTAL_VENDOR_NAME", length = 100)
	public String getRentalVendorName() {
		return this.rentalVendorName;
	}

	public void setRentalVendorName(String rentalVendorName) {
		this.rentalVendorName = rentalVendorName;
	}

	@Column(name = "RECORD_STATUS", length = 1)
	public String getRecordStatus() {
		return this.recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	@Version
	@Column(name = "VERSION", nullable = false)
	public Long getVersion() {
		return this.version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Override
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DT", length = 7)
	public Date getCreateDt() {
		return this.createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	@Override
	@Column(name = "CREATE_BY", length = 50)
	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Override
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATE_DT", length = 7)
	public Date getUpdateDt() {
		return this.updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	@Override
	@Column(name = "UPDATE_BY", length = 50)
	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

}