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
@Table(name="SEM_SI_SEND_RENEW", schema="SEM")
public class SendRenew extends AbstractDomain {

	// Fields

	private String rowId;
	private String siteInfoId;
	private String contractNo;
	private Date sendRenewDt;
	private Date sendRenewBackDt;
	private Date approveDt;
	private Date approveBackDt;
	private Date samDt;
	private String renewAgeCode;
	private String sendRenewStatus;
	private String approveStatus;
	private String remark;
	private String recordStatus;
	private Long version;
	private Date createDt;
	private String createBy;
	private Date updateDt;
	private String updateBy;

	// Property accessors
    @Id
  	@GeneratedValue(generator="system-uuid")
  	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "SEND_RENEW_ID", unique = true, nullable = false, length = 50)
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "SITE_INFO_ID", nullable = false, length = 50)
	public String getSiteInfoId() {
		return siteInfoId;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}

	@Column(name = "CONTRACT_NO", length = 20)
	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SEND_RENEW_DT", length = 7)
	public Date getSendRenewDt() {
		return sendRenewDt;
	}

	public void setSendRenewDt(Date sendRenewDt) {
		this.sendRenewDt = sendRenewDt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SEND_RENEW_BACK_DT", length = 7)
	public Date getSendRenewBackDt() {
		return sendRenewBackDt;
	}

	public void setSendRenewBackDt(Date sendRenewBackDt) {
		this.sendRenewBackDt = sendRenewBackDt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "APPROVE_DT", length = 7)
	public Date getApproveDt() {
		return approveDt;
	}

	public void setApproveDt(Date approveDt) {
		this.approveDt = approveDt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "APPROVE_BACK_DT", length = 7)
	public Date getApproveBackDt() {
		return approveBackDt;
	}

	public void setApproveBackDt(Date approveBackDt) {
		this.approveBackDt = approveBackDt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SAM_DT", length = 7)
	public Date getSamDt() {
		return samDt;
	}

	public void setSamDt(Date samDt) {
		this.samDt = samDt;
	}

	@Column(name = "RENEW_AGE_CODE", length = 5)
	public String getRenewAgeCode() {
		return renewAgeCode;
	}

	public void setRenewAgeCode(String renewAgeCode) {
		this.renewAgeCode = renewAgeCode;
	}

	@Column(name = "SEND_RENEW_STATUS", nullable = false, length = 5)
	public String getSendRenewStatus() {
		return sendRenewStatus;
	}

	public void setSendRenewStatus(String sendRenewStatus) {
		this.sendRenewStatus = sendRenewStatus;
	}

	@Column(name = "APPROVE_STATUS", length = 5)
	public String getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "RECORD_STATUS", nullable = false, length = 5)
	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	@Version
	@Column(name = "VERSION", precision = 10, scale = 0 , nullable = false)
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Column(name = "CREATE_DT")
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

	@Column(name = "UPDATE_DT")
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