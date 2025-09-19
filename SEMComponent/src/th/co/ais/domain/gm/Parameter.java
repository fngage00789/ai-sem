package th.co.ais.domain.gm;

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
@Table(name="SEM_CT_PARAMETER", schema="SEM")
public class Parameter extends AbstractDomain {

	private static final long serialVersionUID = -5718984209034450462L;
	
	private String rowId;
	private String paramValue;
	private String paramName;
	private String displayThai;
	private String displayEng;
	private String remark;
	private String recordStatus;

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "PARAM_CODE")	
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "PARAM_VALUE")
	public String getParamValue() {
		return paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	@Column(name = "PARAM_NAME")
	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	@Column(name = "DISPLAY_THAI")
	public String getDisplayThai() {
		return displayThai;
	}

	public void setDisplayThai(String displayThai) {
		this.displayThai = displayThai;
	}

	@Column(name = "DISPLAY_ENG")
	public String getDisplayEng() {
		return displayEng;
	}

	public void setDisplayEng(String displayEng) {
		this.displayEng = displayEng;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "RECORD_STATUS")
	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
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
