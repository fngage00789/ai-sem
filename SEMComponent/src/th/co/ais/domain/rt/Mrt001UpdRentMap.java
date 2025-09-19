/**
 * 
 */
package th.co.ais.domain.rt;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

/**
 * @author Kanchai
 *
 */
public class Mrt001UpdRentMap extends AbstractDomain{
	
	private String rentalMasterId;
	private String rentalDetailId;
	private Double periodAmt;
	
	private String result;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getRentalMasterId() {
		return rentalMasterId;
	}
	public void setRentalMasterId(String rentalMasterId) {
		this.rentalMasterId = rentalMasterId;
	}
	public String getRentalDetailId() {
		return rentalDetailId;
	}
	public void setRentalDetailId(String rentalDetailId) {
		this.rentalDetailId = rentalDetailId;
	}
	public Double getPeriodAmt() {
		return periodAmt;
	}
	public void setPeriodAmt(Double periodAmt) {
		this.periodAmt = periodAmt;
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
