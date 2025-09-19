package th.co.ais.domain.si;

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
@Table(name="SEM_SI_SITE_APPROVE_MAP_LOC", schema="SEM")
public class SiteApproveMapLoc extends AbstractDomain {

	private static final long serialVersionUID = -563415699747532673L;
	private String rowId;
	private String siteApproveId;
	private String locationId;
	private Date createDt;
	private String createBy;
	private Date updateDt;
	private String updateBy;
	private String recordStatus;
	private Integer seqNo;
	private Long version;
	

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "SITE_APPROVE_MAP_LOC_ID", unique = true, nullable = false, length = 50)
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "SITE_APPROVE_ID", length = 20)
	public String getSiteApproveId() {
		return siteApproveId;
	}

	public void setSiteApproveId(String siteApproveId) {
		this.siteApproveId = siteApproveId;
	}

	@Column(name = "LOCATION_ID", length = 20)
	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	@Column(name = "CREATE_DT")
	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	@Column(name = "CREATE_BY", length = 20)
	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Column(name = "UPDATE_DT")
	public Date getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	@Column(name = "UPDATE_BY", length = 20)
	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	@Column(name = "RECORD_STATUS", nullable = false, length = 1)
	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	@Column(name = "SEQ_NO")
	public Integer getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}
	
	@Version
	@Column(name = "VERSION", precision = 10, scale = 0 , nullable = false)
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

}