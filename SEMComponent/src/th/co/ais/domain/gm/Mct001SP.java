package th.co.ais.domain.gm;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mct001SP extends AbstractDomain {

	
	private String ResultMsg;
	private String pRemark;
	private String actionType;
	private String lessorId;
	
	
	
	public String getResultMsg() {
		return ResultMsg;
	}

	public void setResultMsg(String resultMsg) {
		ResultMsg = resultMsg;
	}

	public String getpRemark() {
		return pRemark;
	}

	public void setpRemark(String pRemark) {
		this.pRemark = pRemark;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getLessorId() {
		return lessorId;
	}

	public void setLessorId(String lessorId) {
		this.lessorId = lessorId;
	}

	@Override
	public String getCreateBy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getCreateDt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUpdateBy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getUpdateDt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCreateBy(String createBy) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCreateDt(Date createDt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setUpdateBy(String updateBy) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setUpdateDt(Date updateDt) {
		// TODO Auto-generated method stub

	}

}
