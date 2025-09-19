package th.co.ais.domain.si;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class SendRenewActSP extends AbstractDomain{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6935848661511582247L;
	
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
	private String result;
	private String recordStatus;
	private Long version;
	private String actionType;
	private String userId;
	
	
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public Date getSendRenewDt() {
		return sendRenewDt;
	}
	public void setSendRenewDt(Date sendRenewDt) {
		this.sendRenewDt = sendRenewDt;
	}
	public Date getSendRenewBackDt() {
		return sendRenewBackDt;
	}
	public void setSendRenewBackDt(Date sendRenewBackDt) {
		this.sendRenewBackDt = sendRenewBackDt;
	}
	public Date getApproveDt() {
		return approveDt;
	}
	public void setApproveDt(Date approveDt) {
		this.approveDt = approveDt;
	}
	public Date getApproveBackDt() {
		return approveBackDt;
	}
	public void setApproveBackDt(Date approveBackDt) {
		this.approveBackDt = approveBackDt;
	}
	public Date getSamDt() {
		return samDt;
	}
	public void setSamDt(Date samDt) {
		this.samDt = samDt;
	}
	public String getRenewAgeCode() {
		return renewAgeCode;
	}
	public void setRenewAgeCode(String renewAgeCode) {
		this.renewAgeCode = renewAgeCode;
	}
	public String getSendRenewStatus() {
		return sendRenewStatus;
	}
	public void setSendRenewStatus(String sendRenewStatus) {
		this.sendRenewStatus = sendRenewStatus;
	}
	public String getApproveStatus() {
		return approveStatus;
	}
	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String getCreateBy() {
		// TODO Auto-generated method stub
		return this.createBy;
	}
	@Override
	public Date getCreateDt() {
		// TODO Auto-generated method stub
		return this.createDt;
	}
	@Override
	public String getUpdateBy() {
		// TODO Auto-generated method stub
		return this.updateBy;
	}
	@Override
	public Date getUpdateDt() {
		// TODO Auto-generated method stub
		return this.updateDt;
	}
	@Override
	public void setCreateBy(String createBy) {
		// TODO Auto-generated method stub
		this.createBy = createBy;
		
	}
	@Override
	public void setCreateDt(Date createDt) {
		// TODO Auto-generated method stub
		this.createDt = createDt;
	}
	@Override
	public void setUpdateBy(String updateBy) {
		// TODO Auto-generated method stub
		this.updateBy = updateBy;
	}
	@Override
	public void setUpdateDt(Date updateDt) {
		// TODO Auto-generated method stub
		this.updateDt = updateDt;
	}

}
