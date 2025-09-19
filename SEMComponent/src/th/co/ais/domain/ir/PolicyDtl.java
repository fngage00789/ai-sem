package th.co.ais.domain.ir;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="SEM_IR_POLICY_DTL", schema="SEM")
public class PolicyDtl implements java.io.Serializable {

	private static final long serialVersionUID = -2550783902822881118L;
	private String rowId;
	private String parRowId;
	private Integer locationId;
	private Double insuredAmt;
	private Double estPremiumAmt;
	private Double premiumAmt;
	private String remark;
	private String recordStatus;
	private Long version;
	private Date createDt;
	private String createBy;
	private Date updateDt;
	private String updateBy;

	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "POLICY_DTL_ID", unique = true, nullable = false, length = 50)
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "PAR_ROW_ID", nullable = false, length = 50)
	public String getParRowId() {
		return parRowId;
	}

	public void setParRowId(String parRowId) {
		this.parRowId = parRowId;
	}

	@Column(name = "LOCATION_ID", precision = 22, scale = 0)
	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	@Column(name = "INSURED_AMT", precision = 15)
	public Double getInsuredAmt() {
		return insuredAmt;
	}

	public void setInsuredAmt(Double insuredAmt) {
		this.insuredAmt = insuredAmt;
	}

	@Column(name = "EST_PREMIUM_AMT", precision = 15)
	public Double getEstPremiumAmt() {
		return estPremiumAmt;
	}

	public void setEstPremiumAmt(Double estPremiumAmt) {
		this.estPremiumAmt = estPremiumAmt;
	}

	@Column(name = "PREMIUM_AMT", precision = 15)
	public Double getPremiumAmt() {
		return premiumAmt;
	}

	public void setPremiumAmt(Double premiumAmt) {
		this.premiumAmt = premiumAmt;
	}

	@Column(name = "REMARK", length = 250)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "RECORD_STATUS", length = 5)
	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	@Column(name = "VERSION", precision = 10, scale = 0)
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