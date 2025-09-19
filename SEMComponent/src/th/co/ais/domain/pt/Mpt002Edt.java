package th.co.ais.domain.pt;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mpt002Edt extends AbstractDomain{

	private String rowId;
	private String estmFlag;
	private String userId;
	private String resultMsg;
	private String pRemark;
	
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
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getEstmFlag() {
		return estmFlag;
	}
	public void setEstmFlag(String estmFlag) {
		this.estmFlag = estmFlag;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
}
