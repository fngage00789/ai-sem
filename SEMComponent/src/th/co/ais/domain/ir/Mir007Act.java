package th.co.ais.domain.ir;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mir007Act extends AbstractDomain {
	
	private String rowId;
	private String result;
	private String remark;
	private String genType;
	private String actionType;
	private String company;
	private String networkType;
	private String transferType;
	private String policyType;
	private String locationID;
	private String draftNo;
	private String userID;
	
	//Mir007ADD
	private String refPolicyNo;
	private Date effDt;
	private Date expDt;
	private String asMonth;
	private String asYear;
	private String dataAsOf;
	private Date newEffDt;
	private Date newExpDt;
	private String contractNo;
	private String premiumId;
	
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

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getGenType() {
		return genType;
	}

	public void setGenType(String genType) {
		this.genType = genType;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getNetworkType() {
		return networkType;
	}

	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}

	public String getTransferType() {
		return transferType;
	}

	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getLocationID() {
		return locationID;
	}

	public void setLocationID(String locationID) {
		this.locationID = locationID;
	}

	public String getDraftNo() {
		return draftNo;
	}

	public void setDraftNo(String draftNo) {
		this.draftNo = draftNo;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getRefPolicyNo() {
		return refPolicyNo;
	}

	public Date getEffDt() {
		return effDt;
	}

	public Date getExpDt() {
		return expDt;
	}

	public String getAsMonth() {
		return asMonth;
	}

	public String getAsYear() {
		return asYear;
	}

	public void setRefPolicyNo(String refPolicyNo) {
		this.refPolicyNo = refPolicyNo;
	}

	public void setEffDt(Date effDt) {
		this.effDt = effDt;
	}

	public void setExpDt(Date expDt) {
		this.expDt = expDt;
	}

	public void setAsMonth(String asMonth) {
		this.asMonth = asMonth;
	}

	public void setAsYear(String asYear) {
		this.asYear = asYear;
	}

	public String getDataAsOf() {
		return dataAsOf;
	}

	public Date getNewEffDt() {
		return newEffDt;
	}

	public Date getNewExpDt() {
		return newExpDt;
	}

	public void setDataAsOf(String dataAsOf) {
		this.dataAsOf = dataAsOf;
	}

	public void setNewEffDt(Date newEffDt) {
		this.newEffDt = newEffDt;
	}

	public void setNewExpDt(Date newExpDt) {
		this.newExpDt = newExpDt;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getPremiumId() {
		return premiumId;
	}

	public void setPremiumId(String premiumId) {
		this.premiumId = premiumId;
	}
	
}
