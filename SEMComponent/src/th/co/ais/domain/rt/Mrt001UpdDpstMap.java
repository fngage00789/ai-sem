package th.co.ais.domain.rt;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mrt001UpdDpstMap extends AbstractDomain {
	
	private String rentalMasterId;
	private String depositDetailId;
	private Double depositAmt;
	
	private String result;
	
	public String getRentalMasterId() {
		return rentalMasterId;
	}
	public void setRentalMasterId(String rentalMasterId) {
		this.rentalMasterId = rentalMasterId;
	}
	public String getDepositDetailId() {
		return depositDetailId;
	}
	public void setDepositDetailId(String depositDetailId) {
		this.depositDetailId = depositDetailId;
	}
	public Double getDepositAmt() {
		return depositAmt;
	}
	public void setDepositAmt(Double depositAmt) {
		this.depositAmt = depositAmt;
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
