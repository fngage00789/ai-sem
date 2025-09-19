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
@Table(name = "SEM_IR_LOAD_CLAIM_LOG", schema = "SEM")
public class IrLoadClaimLog extends AbstractDomain {

	private String rowId;
	private String fileName;
	private String recordStatus;
	private Long version;
	
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "LOAD_CLAIM_LOG_ID", unique = true, nullable = false, length = 50)
	public String getRowId() {
		return rowId;
	}

	@Column(name = "FILE_NAME", length = 255)
	public String getFileName() {
		return fileName;
	}

	@Column(name = "RECORD_STATUS", length = 5)
	public String getRecordStatus() {
		return recordStatus;
	}

	@Version
	@Column(name = "VERSION", precision = 10, scale = 0)
	public Long getVersion() {
		return version;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
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
