package th.co.ais.domain.rt;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mrt007UpdStatus extends AbstractDomain {

	private String rentalClrRecId;
	private String clrReceiptStatus;
	private String reason;
	
	private String result;
	
	public String getRentalClrRecId() {
		return rentalClrRecId;
	}
	public void setRentalClrRecId(String rentalClrRecId) {
		this.rentalClrRecId = rentalClrRecId;
	}
	public String getClrReceiptStatus() {
		return clrReceiptStatus;
	}
	public void setClrReceiptStatus(String clrReceiptStatus) {
		this.clrReceiptStatus = clrReceiptStatus;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
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
