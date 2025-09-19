package th.co.ais.domain.ir;

import java.math.BigDecimal;
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
@Table(name="SEM_IR_ACQ_COST_LOG", schema="SEM")
public class AcqCostLog extends AbstractDomain implements java.io.Serializable {
	
	private String rowId;
	private String acqType;
	private String fileName;
	private String remark;
	private String asOfMonth;
	private Long version;
	
	private String reNewFlg;
	private String networkType;
	private String recordStatus;
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "ACQ_COST_LOG_ID", unique = true, nullable = false, length = 50)
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "ACQ_TYPE",  length = 4)
	public String getAcqType() {
		return acqType;
	}

	public void setAcqType(String acqType) {
		this.acqType = acqType;
	}
	
	@Column(name = "FILE_NAME",  length = 255)
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Column(name = "REMARK",  length = 255)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(name = "AS_OF_MONTH",  length = 4)
	public String getAsOfMonth() {
		return asOfMonth;
	}

	public void setAsOfMonth(String asOfMonth) {
		this.asOfMonth = asOfMonth;
	}
	
	@Column(name = "VERSION", precision = 10, scale = 0)
	public Long getVersion() {
		return version;
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

	@Column(name = "RENEW_FLG",  length = 5)
	public String getReNewFlg() {
		return reNewFlg;
	}

	public void setReNewFlg(String reNewFlg) {
		this.reNewFlg = reNewFlg;
	}

	@Column(name = "NETWORK_TYPE",  length = 5)
	public String getNetworkType() {
		return networkType;
	}

	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}
	
	@Column(name = "RECORD_STATUS",  length = 5)
	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

}
