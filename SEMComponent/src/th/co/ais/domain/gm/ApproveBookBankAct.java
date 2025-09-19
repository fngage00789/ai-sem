package th.co.ais.domain.gm;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class ApproveBookBankAct extends AbstractDomain{
	
	private String actionType;
	private String vendorMapPayeeId;
	private String remark;
	private String userId;
	
	private String resultMsg;
	private String pRemark;
	private String fileName;
	
	private String sapStatus;
	private String sapMsg;
	
	@Override
	public String getCreateBy() {
		return this.createBy;
	}

	@Override
	public Date getCreateDt() {
		return this.createDt;
	}

	@Override
	public String getUpdateBy() {
		return this.updateBy;
	}

	@Override
	public Date getUpdateDt() {
		return this.updateDt;
	}

	@Override
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Override
	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	@Override
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	@Override
	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getVendorMapPayeeId() {
		return vendorMapPayeeId;
	}

	public void setVendorMapPayeeId(String vendorMapPayeeId) {
		this.vendorMapPayeeId = vendorMapPayeeId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public void setpRemark(String pRemark) {
		this.pRemark = pRemark;
	}

	public String getpRemark() {
		return pRemark;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSapStatus() {
		return sapStatus;
	}

	public void setSapStatus(String sapStatus) {
		this.sapStatus = sapStatus;
	}

	public String getSapMsg() {
		return sapMsg;
	}

	public void setSapMsg(String sapMsg) {
		this.sapMsg = sapMsg;
	}


}
