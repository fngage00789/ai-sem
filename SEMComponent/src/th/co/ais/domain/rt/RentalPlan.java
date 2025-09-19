package th.co.ais.domain.rt;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

import th.co.ais.domain.AbstractDomain;

@Entity
@Table(name="SEM_RT_RENTAL_PLAN", schema="SEM")
public class RentalPlan extends AbstractDomain {

	// Fields

	private String rowId;
	private String company;
	private String planType;
	private String region;
	private String planYear;
	private Integer siteTotal;
	private Double percentGrowth;
	private Double planAmt;
	private String recordStatus;
	private Long version;
	private Date createDt;
	private String createBy;
	private Date updateDt;
	private String updateBy;

	

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "RENTAL_PLAN_ID", unique = true, nullable = false, length = 50)
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "COMPANY", nullable = false, length = 5)
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "PLAN_TYPE", nullable = false, length = 20)
	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	@Column(name = "REGION", nullable = false, length = 20)
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Column(name = "PLAN_YEAR", length = 4)
	public String getPlanYear() {
		return planYear;
	}

	public void setPlanYear(String planYear) {
		this.planYear = planYear;
	}

	@Column(name = "SITE_TOTAL", precision = 5, scale = 0)
	public Integer getSiteTotal() {
		return siteTotal;
	}

	public void setSiteTotal(Integer siteTotal) {
		this.siteTotal = siteTotal;
	}

	@Column(name = "PERCENT_GROWTH", precision = 5)
	public Double getPercentGrowth() {
		return percentGrowth;
	}

	public void setPercentGrowth(Double percentGrowth) {
		this.percentGrowth = percentGrowth;
	}

	@Column(name = "PLAN_AMT", precision = 15)
	public Double getPlanAmt() {
		return planAmt;
	}

	public void setPlanAmt(Double planAmt) {
		this.planAmt = planAmt;
	}

	@Column(name = "RECORD_STATUS", length = 1)
	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	@Version
	@Column(name = "VERSION", nullable = false)
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DT", length = 7)
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

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATE_DT", length = 7)
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

}