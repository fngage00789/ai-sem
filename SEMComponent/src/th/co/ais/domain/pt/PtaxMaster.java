package th.co.ais.domain.pt;

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
 * SemPtPtaxMaster entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SEM_PT_PTAX_MASTER", schema = "SEM")
public class PtaxMaster extends AbstractDomain{

	// Fields

	private String rowId;
	private String company;
	private Short ptaxYear;
	private String contractNo;
	private String ptaxPayType;
	private String payGovtFlag;
	private String estmFlag;
	private String estmBy;
	private Date estmDt;
	private String vendorCode;
	private Double rentalAmt;
	private String whtType;
	private Double ptaxRate;
	private Double ptaxAmt;
	private String remark;
	private String ptaxStatus;
	private String recordStatus;
	private Long version;

	
	// Property accessors
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "PTAX_MASTER_ID", unique = true, nullable = false, length = 50)
	public String getRowId() {
		return this.rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "COMPANY", length = 20)
	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "PTAX_YEAR", precision = 4, scale = 0)
	public Short getPtaxYear() {
		return this.ptaxYear;
	}

	public void setPtaxYear(Short ptaxYear) {
		this.ptaxYear = ptaxYear;
	}

	@Column(name = "CONTRACT_NO", length = 20)
	public String getContractNo() {
		return this.contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	@Column(name = "PTAX_PAY_TYPE", length = 5)
	public String getPtaxPayType() {
		return this.ptaxPayType;
	}

	public void setPtaxPayType(String ptaxPayType) {
		this.ptaxPayType = ptaxPayType;
	}

	@Column(name = "PAY_GOVT_FLAG", length = 1)
	public String getPayGovtFlag() {
		return this.payGovtFlag;
	}

	public void setPayGovtFlag(String payGovtFlag) {
		this.payGovtFlag = payGovtFlag;
	}

	@Column(name = "ESTM_FLAG", length = 1)
	public String getEstmFlag() {
		return this.estmFlag;
	}

	public void setEstmFlag(String estmFlag) {
		this.estmFlag = estmFlag;
	}

	@Column(name = "ESTM_BY", length = 50)
	public String getEstmBy() {
		return this.estmBy;
	}

	public void setEstmBy(String estmBy) {
		this.estmBy = estmBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ESTM_DT", length = 7)
	public Date getEstmDt() {
		return this.estmDt;
	}

	public void setEstmDt(Date estmDt) {
		this.estmDt = estmDt;
	}

	@Column(name = "VENDOR_CODE", length = 20)
	public String getVendorCode() {
		return this.vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	@Column(name = "RENTAL_AMT", precision = 15)
	public Double getRentalAmt() {
		return this.rentalAmt;
	}

	public void setRentalAmt(Double rentalAmt) {
		this.rentalAmt = rentalAmt;
	}

	@Column(name = "WHT_TYPE", length = 5)
	public String getWhtType() {
		return this.whtType;
	}

	public void setWhtType(String whtType) {
		this.whtType = whtType;
	}

	@Column(name = "PTAX_RATE", precision = 5)
	public Double getPtaxRate() {
		return this.ptaxRate;
	}

	public void setPtaxRate(Double ptaxRate) {
		this.ptaxRate = ptaxRate;
	}

	@Column(name = "PTAX_AMT", precision = 15)
	public Double getPtaxAmt() {
		return this.ptaxAmt;
	}

	public void setPtaxAmt(Double ptaxAmt) {
		this.ptaxAmt = ptaxAmt;
	}

	@Column(name = "REMARK", length = 500)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "PTAX_STATUS", length = 5)
	public String getPtaxStatus() {
		return this.ptaxStatus;
	}

	public void setPtaxStatus(String ptaxStatus) {
		this.ptaxStatus = ptaxStatus;
	}

	@Column(name = "RECORD_STATUS", nullable = false, length = 1)
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