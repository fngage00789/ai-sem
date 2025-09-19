//package th.co.ais.domain.gm;
//
//import java.util.Date;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//
//import org.hibernate.annotations.GenericGenerator;
//
//import th.co.ais.domain.AbstractDomain;
//
//@Entity
//@Table(name="SEM_CT_BG_ATTACH", schema="SEM")
//public class BgAttach extends AbstractDomain {
//
//	// Fields
//	private String rowId;
//	private String bgMasterId;
//	private String bgAttachPath;
//	private String bgAttachName;
//	private String recordStatus;
//	private Long version;
//	private Date createDt;
//	private String createBy;
//	private Date updateDt;
//	private String updateBy;
//
//	@Id
//	@GeneratedValue(generator="system-uuid")
//	@GenericGenerator(name="system-uuid", strategy = "uuid")
//	@Column(name = "BG_ATTACH_ID", unique = true, nullable = false, length = 50)
//	public String getRowId() {
//		return rowId;
//	}
//
//	public void setRowId(String rowId) {
//		this.rowId = rowId;
//	}
//
//	@Column(name = "BG_MASTER_ID", length = 50)
//	public String getBgMasterId() {
//		return bgMasterId;
//	}
//
//	public void setBgMasterId(String bgMasterId) {
//		this.bgMasterId = bgMasterId;
//	}
//
//	@Column(name = "BG_ATTACH_PATH", length = 250)
//	public String getBgAttachPath() {
//		return bgAttachPath;
//	}
//
//	public void setBgAttachPath(String bgAttachPath) {
//		this.bgAttachPath = bgAttachPath;
//	}
//
//	@Column(name = "BG_ATTACH_NAME", length = 100)
//	public String getBgAttachName() {
//		return bgAttachName;
//	}
//
//	public void setBgAttachName(String bgAttachName) {
//		this.bgAttachName = bgAttachName;
//	}
//
//	@Column(name = "RECORD_STATUS", length = 1)
//	public String getRecordStatus() {
//		return recordStatus;
//	}
//
//	public void setRecordStatus(String recordStatus) {
//		this.recordStatus = recordStatus;
//	}
//
//	@Column(name = "VERSION", precision = 10, scale = 0)
//	public Long getVersion() {
//		return version;
//	}
//
//	public void setVersion(Long version) {
//		this.version = version;
//	}
//
//	@Temporal(TemporalType.DATE)
//	@Column(name = "CREATE_DT", length = 7)
//	public Date getCreateDt() {
//		return createDt;
//	}
//
//	public void setCreateDt(Date createDt) {
//		this.createDt = createDt;
//	}
//
//	@Column(name = "CREATE_BY", length = 50)
//	public String getCreateBy() {
//		return createBy;
//	}
//
//	public void setCreateBy(String createBy) {
//		this.createBy = createBy;
//	}
//
//	@Temporal(TemporalType.DATE)
//	@Column(name = "UPDATE_DT", length = 7)
//	public Date getUpdateDt() {
//		return updateDt;
//	}
//
//	public void setUpdateDt(Date updateDt) {
//		this.updateDt = updateDt;
//	}
//
//	@Column(name = "UPDATE_BY", length = 50)
//	public String getUpdateBy() {
//		return updateBy;
//	}
//
//	public void setUpdateBy(String updateBy) {
//		this.updateBy = updateBy;
//	}
//
//}