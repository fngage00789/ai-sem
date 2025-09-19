package th.co.ais.domain.rt;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mrt001VerifyStatus extends AbstractDomain {

	private String siteInfoId;
	private String rentalMasterId;
	private String verifyStatus;
	private String rentalJobStatus;
	private Date pendingDt;
	
	private String result;
	private String remark;
	private String specialFlag;
	private Date terminateDt;
	
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	public String getRentalMasterId() {
		return rentalMasterId;
	}
	public void setRentalMasterId(String rentalMasterId) {
		this.rentalMasterId = rentalMasterId;
	}
	public String getVerifyStatus() {
		return verifyStatus;
	}
	public void setVerifyStatus(String verifyStatus) {
		this.verifyStatus = verifyStatus;
	}
	public String getRentalJobStatus() {
		return rentalJobStatus;
	}
	public void setRentalJobStatus(String rentalJobStatus) {
		this.rentalJobStatus = rentalJobStatus;
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
	public Date getPendingDt() {
		return pendingDt;
	}
	public void setPendingDt(Date pendingDt) {
		this.pendingDt = pendingDt;
	}
	public String getSpecialFlag() {
		return specialFlag;
	}
	public void setSpecialFlag(String specialFlag) {
		this.specialFlag = specialFlag;
	}
	public Date getTerminateDt() {
		return terminateDt;
	}
	public void setTerminateDt(Date terminateDt) {
		this.terminateDt = terminateDt;
	}
	
}
