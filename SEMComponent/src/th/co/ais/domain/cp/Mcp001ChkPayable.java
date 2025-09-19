package th.co.ais.domain.cp;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mcp001ChkPayable extends AbstractDomain{

	private String payAbleFlag;
	private String cancleAbleFlag;
	
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
	public String getPayAbleFlag() {
		return payAbleFlag;
	}
	public void setPayAbleFlag(String payAbleFlag) {
		this.payAbleFlag = payAbleFlag;
	}
	public String getCancleAbleFlag() {
		return cancleAbleFlag;
	}
	public void setCancleAbleFlag(String cancleAbleFlag) {
		this.cancleAbleFlag = cancleAbleFlag;
	}
}
