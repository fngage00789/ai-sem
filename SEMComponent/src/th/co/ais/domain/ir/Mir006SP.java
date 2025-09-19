package th.co.ais.domain.ir;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mir006SP extends AbstractDomain{

	private static final long serialVersionUID = 4622479689040988633L;
	
	private String company;
	private String networkType;
	private String contractNo;
	private String plxFlag;
	private boolean plxFlagBoolean;
	private String locationId;
	private String locationName;
	private Date effDateFrom;
	private Date effDateTo;
	
	private String networkTypeDesc;
	private Double insuredAmt;
	private Date effDate;
	
	private String result;
	private String msgError;
	
	private String effDateStr;
	private String updateDtStr;
	
	public Mir006SP() {
		this.rowId = null;
	}
	
	public Mir006SP(Mir006SP tmp) {
		this.rowId = tmp.getRowId();
		this.company = tmp.getCompany();
		this.networkType = tmp.getNetworkType();
		this.contractNo = tmp.getContractNo();
		this.locationId = tmp.getLocationId();
		this.locationName = tmp.getLocationName();
		this.insuredAmt = tmp.getInsuredAmt();
		this.effDate = tmp.getEffDate();
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
	
	public String getNetworkTypeDesc() {
		return networkTypeDesc;
	}

	public void setNetworkTypeDesc(String networkTypeDesc) {
		this.networkTypeDesc = networkTypeDesc;
	}
	
	public String getPlxFlag() {
		return plxFlag;
	}

	public void setPlxFlag(String plxFlag) {
		this.plxFlag = plxFlag;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public Double getInsuredAmt() {
		return insuredAmt;
	}

	public void setInsuredAmt(Double insuredAmt) {
		this.insuredAmt = insuredAmt;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMsgError() {
		return msgError;
	}

	public void setMsgError(String msgError) {
		this.msgError = msgError;
	}

	public Date getEffDateFrom() {
		return effDateFrom;
	}

	public void setEffDateFrom(Date effDateFrom) {
		this.effDateFrom = effDateFrom;
	}

	public Date getEffDateTo() {
		return effDateTo;
	}

	public void setEffDateTo(Date effDateTo) {
		this.effDateTo = effDateTo;
	}
	

	public Date getEffDate() {
		return effDate;
	}

	public void setEffDate(Date effDate) {
		this.effDate = effDate;
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

	public String getEffDateStr() {
		return effDateStr;
	}

	public void setEffDateStr(String effDateStr) {
		this.effDateStr = effDateStr;
	}

	public String getUpdateDtStr() {
		return updateDtStr;
	}

	public void setUpdateDtStr(String updateDtStr) {
		this.updateDtStr = updateDtStr;
	}

	public boolean isPlxFlagBoolean() {
		return plxFlagBoolean;
	}

	public void setPlxFlagBoolean(boolean plxFlagBoolean) {
		this.plxFlagBoolean = plxFlagBoolean;
	}

//	public boolean isPlxFlagBoolean() {
//		if("Y".equalsIgnoreCase(this.plxFlag) || "true".equalsIgnoreCase(this.plxFlag)) {
//			this.plxFlagBoolean = true;
//		}
//		return plxFlagBoolean;
//	}
//
//	public void setPlxFlagBoolean(boolean plxFlagBoolean) {
//		this.plxFlagBoolean = plxFlagBoolean;
//	}

}

