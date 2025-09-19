package th.co.ais.domain.co;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

import th.co.ais.domain.AbstractDomain;

/**
 * SemCoBorrowRequest entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SEM_CO_BORROW_REQUEST", schema = "SEM")
public class BorrowRequest extends AbstractDomain {

	// Fields

	private String rowId;
	private String docNo;
	private Date receiveDt;
	private Date samSendDt;
	private Date samAssignSendDt;
	private BigDecimal siteNum;
	private String recordStatus;
	private Long version;
	private String remark;
	private String company;
	
	private String fileType;


	// Property accessors
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "BORROW_REQUEST_ID", unique = true, nullable = false, length = 50)
	public String getRowId() {
		return this.rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "DOC_NO", length = 20)
	public String getDocNo() {
		return this.docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "RECEIVE_DT", length = 7)
	public Date getReceiveDt() {
		return this.receiveDt;
	}

	public void setReceiveDt(Date receiveDt) {
		this.receiveDt = receiveDt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SAM_SEND_DT", length = 7)
	public Date getSamSendDt() {
		return this.samSendDt;
	}

	public void setSamSendDt(Date samSendDt) {
		this.samSendDt = samSendDt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SAM_ASSIGN_SEND_DT", length = 7)
	public Date getSamAssignSendDt() {
		return this.samAssignSendDt;
	}

	public void setSamAssignSendDt(Date samAssignSendDt) {
		this.samAssignSendDt = samAssignSendDt;
	}

	@Column(name = "SITE_NUM", precision = 22, scale = 0)
	public BigDecimal getSiteNum() {
		return this.siteNum;
	}

	public void setSiteNum(BigDecimal siteNum) {
		this.siteNum = siteNum;
	}

	@Column(name = "RECORD_STATUS", nullable = false, length = 1)
	public String getRecordStatus() {
		return this.recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	@Override
	@Column(name = "CREATE_DT")
	public Date getCreateDt() {
		return this.createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	@Override
	@Column(name = "CREATE_BY", length = 50)
	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Override
	@Column(name = "UPDATE_DT")
	public Date getUpdateDt() {
		return this.updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	@Override
	@Column(name = "UPDATE_BY", length = 50)
	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	@Version
	@Column(name = "VERSION", nullable = false)
	public Long getVersion() {
		return this.version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Column(name = "REMARK", length = 1000)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "COMPANY", length = 20)
	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	@Column(name = "CONTRACT_TYPE", length = 20)
	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

}