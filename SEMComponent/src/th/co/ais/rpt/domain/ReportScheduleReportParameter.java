package th.co.ais.rpt.domain;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="REPORT_PARAMETER", schema="sem")

public class ReportScheduleReportParameter implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String paramId;
	private String reportTypeId;
	private String paramName;
	private String paramValue;
	private String status;
	private String created;
	private String createdBy;
	private Date lastUpdate;
	private String lastUpdateBy;
	
	@Column(name="CREATED")
	public String getCreated() {
		return created;
	}
	
	public void setCreated(String created) {
		this.created = created;
	}
	
	@Column(name="CREATED_BY")
	public String getCreatedBy() {
		return createdBy;
	}
	
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column(name="LAST_UPD")
	public Date getLastUpdate() {
		return lastUpdate;
	}
	
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	@Column(name="LAST_UPD_BY")
	public String getLastUpdateBy() {
		return lastUpdateBy;
	}
	
	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="PARAMETER_ID")
	public String getParamId() {
		return paramId;
	}
	
	public void setParamId(String paramId) {
		this.paramId = paramId;
	}
	
	@Column(name="PARAMETER_NAME")
	public String getParamName() {
		return paramName;
	}
	
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	
	@Column(name="PARAMETER_VALUE")
	public String getParamValue() {
		return paramValue;
	}
	
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}
	
	@Column(name="REPORT_TYPE_ID")
	public String getReportTypeId() {
		return reportTypeId;
	}
	
	public void setReportTypeId(String reportTypeId) {
		this.reportTypeId = reportTypeId;
	}
	
	@Column(name="STATUS")
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
