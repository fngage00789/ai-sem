package th.co.ais.domain.co;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mco003Del extends AbstractDomain {

	private String borrowReqId;
	private String result;
	
	public String getBorrowReqId() {
		return borrowReqId;
	}
	public void setBorrowReqId(String borrowReqId) {
		this.borrowReqId = borrowReqId;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
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
}
