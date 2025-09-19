package th.co.ais.domain.rt;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

import th.co.ais.domain.AbstractDomain;

/**
 * SemRtRentalMaster entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SEM_RT_RENTAL_MASTER", schema = "SEM")
public class RentalMaster extends AbstractDomain {

	// Fields

	private String rowId;
	private String company;
	private String rentalJobStatus;
	private String verifyStatus;
	private String siteInfoId;
	private String rentalLastestFlag;
	private String recordStatus;
	private Long version;
	
	private Date pendingStDt;
	private String specialFlg;
	private String remark;

	// Property accessors
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "RENTAL_MASTER_ID", unique = true, nullable = false, length = 50)
	public String getRowId() {
		return this.rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "COMPANY", nullable = false, length = 5)
	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "RENTAL_JOB_STATUS", length = 20)
	public String getRentalJobStatus() {
		return this.rentalJobStatus;
	}

	public void setRentalJobStatus(String rentalJobStatus) {
		this.rentalJobStatus = rentalJobStatus;
	}

	@Column(name = "VERIFY_STATUS", length = 20)
	public String getVerifyStatus() {
		return this.verifyStatus;
	}

	public void setVerifyStatus(String verifyStatus) {
		this.verifyStatus = verifyStatus;
	}

	@Column(name = "SITE_INFO_ID", length = 50)
	public String getSiteInfoId() {
		return this.siteInfoId;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}

	@Column(name = "RENTAL_LASTEST_FLAG", length = 1)
	public String getRentalLastestFlag() {
		return this.rentalLastestFlag;
	}

	public void setRentalLastestFlag(String rentalLastestFlag) {
		this.rentalLastestFlag = rentalLastestFlag;
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

	@Temporal(TemporalType.DATE)
	@Column(name = "PENDING_START_DT", length=7)
	public Date getPendingStDt() {
		return pendingStDt;
	}

	public void setPendingStDt(Date pendingStDt) {
		this.pendingStDt = pendingStDt;
	}

	@Column(name = "SPECIAL_FLG", length = 5)
	public String getSpecialFlg() {
		return specialFlg;
	}

	public void setSpecialFlg(String specialFlg) {
		this.specialFlg = specialFlg;
	}

	@Column(name = "REMARK", length = 255)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	@Column(name = "CREATE_DT")
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
	@Column(name = "UPDATE_DT")
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