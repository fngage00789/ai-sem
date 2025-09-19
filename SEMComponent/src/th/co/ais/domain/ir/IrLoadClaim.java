package th.co.ais.domain.ir;

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

@Entity
@Table(name = "SEM_IR_LOAD_CLAIM", schema = "SEM")
public class IrLoadClaim extends AbstractDomain {

	private String rowId;
	private String loadClaimLogId;
	private String provinceCode;
	private String siteName;
	private String provinceName;
	private Date lossDt;
	private String lossTime;
	private Date checkDt;
	private String lossType;
	private String lossSubType;
	private String lossDetail;
	private Double estimateAmt;
	private String networkType;
	private String recordStatus;
	private Long version;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "LOAD_CLAIM_ID", unique = true, nullable = false, length = 50)
	public String getRowId() {
		return rowId;
	}

	@Column(name = "LOAD_CLAIM_LOG_ID", unique = true, nullable = false, length = 50)
	public String getLoadClaimLogId() {
		return loadClaimLogId;
	}

	@Column(name = "PROVINCE_CODE", length = 5)
	public String getProvinceCode() {
		return provinceCode;
	}

	@Column(name = "SITE_NAME", length = 255)
	public String getSiteName() {
		return siteName;
	}

	@Column(name = "PROVINCE_NAME", length = 255)
	public String getProvinceName() {
		return provinceName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "LOSS_DT", length = 7)
	public Date getLossDt() {
		return lossDt;
	}

	@Column(name = "LOSS_TIME", length = 10)
	public String getLossTime() {
		return lossTime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CHECK_DT", length = 7)
	public Date getCheckDt() {
		return checkDt;
	}

	@Column(name = "LOSS_TYPE", length = 255)
	public String getLossType() {
		return lossType;
	}

	@Column(name = "LOSS_SUBTYPE", length = 255)
	public String getLossSubType() {
		return lossSubType;
	}

	@Column(name = "LOSS_DETAIL", length = 255)
	public String getLossDetail() {
		return lossDetail;
	}

	@Column(name = "ESTIMATE_AMT", precision = 15)
	public Double getEstimateAmt() {
		return estimateAmt;
	}

	@Column(name = "NETWORK_TYPE", length = 5)
	public String getNetworkType() {
		return networkType;
	}
	
	@Version
	@Column(name = "VERSION", precision = 10, scale = 0)
	public Long getVersion() {
		return version;
	}
	
	@Column(name = "RECORD_STATUS", length = 5)
	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public void setLoadClaimLogId(String loadClaimLogId) {
		this.loadClaimLogId = loadClaimLogId;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public void setLossDt(Date lossDt) {
		this.lossDt = lossDt;
	}

	public void setLossTime(String lossTime) {
		this.lossTime = lossTime;
	}

	public void setCheckDt(Date checkDt) {
		this.checkDt = checkDt;
	}

	public void setLossType(String lossType) {
		this.lossType = lossType;
	}

	public void setLossSubType(String lossSubType) {
		this.lossSubType = lossSubType;
	}

	public void setLossDetail(String lossDetail) {
		this.lossDetail = lossDetail;
	}

	public void setEstimateAmt(Double estimateAmt) {
		this.estimateAmt = estimateAmt;
	}

	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}

	public void setVersion(Long version) {
		this.version = version;
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

}
