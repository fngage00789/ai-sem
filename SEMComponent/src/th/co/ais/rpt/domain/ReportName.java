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
@Table(name="REPORT_NAME", schema="sem")
public class ReportName implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String rptTypeId;
	private String rptName;
	private String status;
	private Date created;
	private String createdBy;
	private Date lastUpd;
	private String lastUpdBy;
	
	@Column(name="CREATED")
	public Date getCreated() {
		return created;
	}
	
	public void setCreated(Date created) {
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
	public Date getLastUpd() {
		return lastUpd;
	}
	
	public void setLastUpd(Date lastUpd) {
		this.lastUpd = lastUpd;
	}
	
	@Column(name="LAST_UPD_BY")
	public String getLastUpdBy() {
		return lastUpdBy;
	}
	
	public void setLastUpdBy(String lastUpdBy) {
		this.lastUpdBy = lastUpdBy;
	}
	
	@Column(name="REPORT_NAME")
	public String getRptName() {
		return rptName;
	}
	
	public void setRptName(String rptName) {
		this.rptName = rptName;
	}
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="REPORT_TYPE_ID")
	public String getRptTypeId() {
		return rptTypeId;
	}
	
	public void setRptTypeId(String rptTypeId) {
		this.rptTypeId = rptTypeId;
	}
	
	@Column(name="STATUS")
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}	
	
}
