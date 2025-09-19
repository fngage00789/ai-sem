package th.co.ais.rpt.domain;

import java.util.Date;

import java.io.File;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="REPORT_SCHEDULE_JOB", schema="sem")
public class ReportScheduleJob implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9125465760878712081L;
	private String jobId;
	private Integer version;
	private String status;
	private String remark;
	private String reportTypeId;
	private Date startDt;
	private Date endDt;
	private Date jobSchedule;
	private String reportParam;
	private String requestBy;
	private Date requestDt;
	private String reportExportType;
	private String runOnServer;
	private String reportExportFilePath;
	

	@Transient
	public String getReportExportFileName() {
		if(reportExportFilePath == null) {
			return null;
		}
			
		File file = new File(reportExportFilePath);
		return file.getName();
	}
	
	@Column(name="REPORT_EXPORT_FILE_PATH")
	public String getReportExportFilePath() {
		if(reportExportFilePath != null){
			reportExportFilePath = reportExportFilePath.replace("\\","/");
		}
		return reportExportFilePath;
	}

	public void setReportExportFilePath(String reportExportFilePath) {
		this.reportExportFilePath = reportExportFilePath;
	}

	//##### method #####
	@Column(name="STATUS")
	public String getStatus() {
		return status;
	}
	
	@Column(name="REMARK")
	public String getRemark() {
		return remark;
	}

	@Version
	@Column(name="VERSION")
	public Integer getVersion() {
		return version;
	}

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="JOB_ID",nullable=false,length=50)
	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(name="END_DT")
	public Date getEndDt() {
		return endDt;
	}
	
	public void setEndDt(Date endDt) {
		this.endDt = endDt;
	}
	
	@Column(name="JOB_SCHEDULE")
	public Date getJobSchedule() {
		return jobSchedule;
	}
	
	public void setJobSchedule(Date jobSchedule) {
		this.jobSchedule = jobSchedule;
	}
	
	@Column(name="REPORT_EXPORT_TYPE")
	public String getReportExportType() {
		return reportExportType;
	}
	
	public void setReportExportType(String reportExportType) {
		this.reportExportType = reportExportType;
	}
	
	@Column(name="REPORT_PARAM")
	public String getReportParam() {
		return reportParam;
	}
	
	public void setReportParam(String reportParam) {
		this.reportParam = reportParam;
	}
	
	@Column(name="REPORT_TYPE_ID")
	public String getReportTypeId() {
		return reportTypeId;
	}
	
	public void setReportTypeId(String reportTypeId) {
		this.reportTypeId = reportTypeId;
	}
	
	@Column(name="REQUEST_BY")
	public String getRequestBy() {
		return requestBy;
	}
	
	public void setRequestBy(String requestBy) {
		this.requestBy = requestBy;
	}
	
	@Column(name="REQUEST_DT")
	public Date getRequestDt() {
		return requestDt;
	}
	
	public void setRequestDt(Date requestDt) {
		this.requestDt = requestDt;
	}
	
	@Column(name="START_DT")
	public Date getStartDt() {
		return startDt;
	}
	
	public void setStartDt(Date startDt) {
		this.startDt = startDt;
	}
	
	@Column(name="RUN_ON_SERVER")
	public String getRunOnServer() {
		return runOnServer;
	}

	
	public void setRunOnServer(String runOnServer) {
		this.runOnServer = runOnServer;
	}


}
