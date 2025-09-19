package th.co.ais.domain.co;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mco004UpdateDuty extends AbstractDomain {

	
	private String pResult;
	private String contractId;
	 private Double dutyAmt;
    private Date dutyPayDt;
    private String dutyPayStatus;
    private Integer copyDuty;
    private Double copyDutyAmt;
    private Double otherDutyAmt;
    private String groupNo;
	
	public String getpResult() {
		return pResult;
	}

	public void setpResult(String pResult) {
		this.pResult = pResult;
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

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public Double getDutyAmt() {
		return dutyAmt;
	}

	public void setDutyAmt(Double dutyAmt) {
		this.dutyAmt = dutyAmt;
	}

	public Date getDutyPayDt() {
		return dutyPayDt;
	}

	public void setDutyPayDt(Date dutyPayDt) {
		this.dutyPayDt = dutyPayDt;
	}

	public String getDutyPayStatus() {
		return dutyPayStatus;
	}

	public void setDutyPayStatus(String dutyPayStatus) {
		this.dutyPayStatus = dutyPayStatus;
	}

	public Integer getCopyDuty() {
		return copyDuty;
	}

	public void setCopyDuty(Integer copyDuty) {
		this.copyDuty = copyDuty;
	}

	public Double getCopyDutyAmt() {
		return copyDutyAmt;
	}

	public void setCopyDutyAmt(Double copyDutyAmt) {
		this.copyDutyAmt = copyDutyAmt;
	}

	public Double getOtherDutyAmt() {
		return otherDutyAmt;
	}

	public void setOtherDutyAmt(Double otherDutyAmt) {
		this.otherDutyAmt = otherDutyAmt;
	}

	public String getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}

}
