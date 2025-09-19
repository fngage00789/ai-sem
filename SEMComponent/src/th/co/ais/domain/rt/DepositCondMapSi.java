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
 * SemRtDepositCondMapSi entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SEM_RT_DEPOSIT_COND_MAP_SI", schema = "SEM")
public class DepositCondMapSi extends AbstractDomain {

	// Fields

	private String rowId;
	private String company;
	private String rentalMasterId;
	private String depositDetailId;
	private String siteDepositId;
	private Double depositSetupAmt;
	private String recordStatus;
	private Long version;

	// Property accessors
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "DEPOSIT_COND_MAP_SI_ID", unique = true, nullable = false, length = 50)
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

	@Column(name = "RENTAL_MASTER_ID", nullable = false, length = 50)
	public String getRentalMasterId() {
		return this.rentalMasterId;
	}

	public void setRentalMasterId(String rentalMasterId) {
		this.rentalMasterId = rentalMasterId;
	}

	@Column(name = "DEPOSIT_DETAIL_ID", nullable = false, length = 50)
	public String getDepositDetailId() {
		return this.depositDetailId;
	}

	public void setDepositDetailId(String depositDetailId) {
		this.depositDetailId = depositDetailId;
	}

	@Column(name = "SITE_DEPOSIT_ID", nullable = false, length = 50)
	public String getSiteDepositId() {
		return this.siteDepositId;
	}

	public void setSiteDepositId(String siteDepositId) {
		this.siteDepositId = siteDepositId;
	}

	@Column(name = "DEPOSIT_SETUP_AMT", precision = 15)
	public Double getDepositSetupAmt() {
		return this.depositSetupAmt;
	}

	public void setDepositSetupAmt(Double depositSetupAmt) {
		this.depositSetupAmt = depositSetupAmt;
	}

	@Column(name = "RECORD_STATUS", length = 5)
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