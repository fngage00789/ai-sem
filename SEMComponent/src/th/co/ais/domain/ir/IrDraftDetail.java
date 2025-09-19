package th.co.ais.domain.ir;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import th.co.ais.domain.AbstractDomain;

@Entity
@Table(name = "SEM_IR_DRAFT_DETAIL", schema = "SEM")
public class IrDraftDetail extends AbstractDomain implements Serializable {

	private String rowId;
	private String draftId;
	private String locationId;
	private Double insuredAmt;
	private Double estPremiumAmt;
	private Double premiumAmt;
	private String remark;
	private String recordStatus;
	private Long version;
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "DRAFT_DETAIL_ID", unique = true, nullable = false, length = 50)
	public String getRowId() {
		return rowId;
	}

	@Column(name = "DRAFT_ID", unique = true, nullable = false, length = 50)
	public String getDraftId() {
		return draftId;
	}

	@Column(name = "LOCATION_ID", length = 20)
	public String getLocationId() {
		return locationId;
	}

	@Column(name = "INSURED_AMT", precision = 15)
	public Double getInsuredAmt() {
		return insuredAmt;
	}
	
	@Column(name = "EST_PREMIUM_AMT", precision = 15)
	public Double getEstPremiumAmt() {
		return estPremiumAmt;
	}

	@Column(name = "PREMIUM_AMT", precision = 15)
	public Double getPremiumAmt() {
		return premiumAmt;
	}

	@Column(name = "REMARK", length = 250)
	public String getRemark() {
		return remark;
	}

	@Column(name = "RECORD_STATUS", length = 5)
	public String getRecordStatus() {
		return recordStatus;
	}

	@Column(name = "VERSION", precision = 10, scale = 0)
	public Long getVersion() {
		return version;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public void setDraftId(String draftId) {
		this.draftId = draftId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public void setInsuredAmt(Double insuredAmt) {
		this.insuredAmt = insuredAmt;
	}

	public void setEstPremiumAmt(Double estPremiumAmt) {
		this.estPremiumAmt = estPremiumAmt;
	}

	public void setPremiumAmt(Double premiumAmt) {
		this.premiumAmt = premiumAmt;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DT",  length = 7)
	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}
	
	@Column(name = "CREATE_BY",  length = 50)
	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATE_DT",  length = 7)
	public Date getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}
	
	@Column(name = "UPDATE_BY",  length = 50)
	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

}
