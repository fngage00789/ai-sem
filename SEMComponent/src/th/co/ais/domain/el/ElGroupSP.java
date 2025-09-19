package th.co.ais.domain.el;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class ElGroupSP extends AbstractDomain implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5976707478808908686L;
	private String rowId;
	private String expenseType;
	
	private String percentContractNo;
	private Date termPayDt;
	private String termPayDtStr;
//	private boolean disableBtnPercent = true;
//	private boolean disableBtnElGroup = true;
	private String groupOwnerGroup;
	private String groupFlagType;
	
	private String contractNo;
	private String siteName;
	private String region;
	private String locationCode;
	private Date paymentDtFrom;
	private Date paymentDtTo;
	private String kwh;
	private String unit;
	private String amt;
	
	private String month;
	private String cost;
	private String rate;
	private String percentKwh;
	private String percentCost;
	private String percentRate;
	private String percentKwhNew;
	private String percentUnitNew;
	private String percentAmtNew;
	private String seqNo;
	private String percentType;
	private String percentTransId;
	private String percentRecStatus;
	private String percentErrCode;
	
	private Double percentKwhNewDouble;
	private Double percentUnitNewDouble;
	private Double percentAmtNewDouble;
	private boolean typeFlag = false;
	private String groupContractNo;
	private Date periodDt;
	
	
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

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	public String getPercentContractNo() {
		return percentContractNo;
	}

	public void setPercentContractNo(String percentContractNo) {
		this.percentContractNo = percentContractNo;
	}

	public Date getTermPayDt() {
		return termPayDt;
	}

	public void setTermPayDt(Date termPayDt) {
		this.termPayDt = termPayDt;
	}

	public String getGroupOwnerGroup() {
		return groupOwnerGroup;
	}

	public void setGroupOwnerGroup(String groupOwnerGroup) {
		this.groupOwnerGroup = groupOwnerGroup;
	}

	public String getGroupFlagType() {
		return groupFlagType;
	}

	public void setGroupFlagType(String groupFlagType) {
		this.groupFlagType = groupFlagType;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public Date getPaymentDtFrom() {
		return paymentDtFrom;
	}

	public void setPaymentDtFrom(Date paymentDtFrom) {
		this.paymentDtFrom = paymentDtFrom;
	}

	public Date getPaymentDtTo() {
		return paymentDtTo;
	}

	public void setPaymentDtTo(Date paymentDtTo) {
		this.paymentDtTo = paymentDtTo;
	}

	public String getKwh() {
		return kwh;
	}

	public void setKwh(String kwh) {
		this.kwh = kwh;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getAmt() {
		return amt;
	}

	public void setAmt(String amt) {
		this.amt = amt;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getPercentKwh() {
		return percentKwh;
	}

	public void setPercentKwh(String percentKwh) {
		this.percentKwh = percentKwh;
	}

	public String getPercentCost() {
		return percentCost;
	}

	public void setPercentCost(String percentCost) {
		this.percentCost = percentCost;
	}

	public String getPercentRate() {
		return percentRate;
	}

	public void setPercentRate(String percentRate) {
		this.percentRate = percentRate;
	}

	public String getPercentKwhNew() {
		return percentKwhNew;
	}

	public void setPercentKwhNew(String percentKwhNew) {
		this.percentKwhNew = percentKwhNew;
	}

	public String getPercentUnitNew() {
		return percentUnitNew;
	}

	public void setPercentUnitNew(String percentUnitNew) {
		this.percentUnitNew = percentUnitNew;
	}

	public String getPercentAmtNew() {
		return percentAmtNew;
	}

	public void setPercentAmtNew(String percentAmtNew) {
		this.percentAmtNew = percentAmtNew;
	}

	public String getTermPayDtStr() {
		return termPayDtStr;
	}

	public void setTermPayDtStr(String termPayDtStr) {
		this.termPayDtStr = termPayDtStr;
	}

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	public String getPercentType() {
		return percentType;
	}

	public void setPercentType(String percentType) {
		this.percentType = percentType;
	}

	public String getPercentTransId() {
		return percentTransId;
	}

	public void setPercentTransId(String percentTransId) {
		this.percentTransId = percentTransId;
	}

	public String getPercentRecStatus() {
		return percentRecStatus;
	}

	public void setPercentRecStatus(String percentRecStatus) {
		this.percentRecStatus = percentRecStatus;
	}

	public String getPercentErrCode() {
		return percentErrCode;
	}

	public void setPercentErrCode(String percentErrCode) {
		this.percentErrCode = percentErrCode;
	}

	public Double getPercentKwhNewDouble() {
		return percentKwhNewDouble;
	}

	public void setPercentKwhNewDouble(Double percentKwhNewDouble) {
		this.percentKwhNewDouble = percentKwhNewDouble;
	}

	public Double getPercentUnitNewDouble() {
		return percentUnitNewDouble;
	}

	public void setPercentUnitNewDouble(Double percentUnitNewDouble) {
		this.percentUnitNewDouble = percentUnitNewDouble;
	}

	public Double getPercentAmtNewDouble() {
		return percentAmtNewDouble;
	}

	public void setPercentAmtNewDouble(Double percentAmtNewDouble) {
		this.percentAmtNewDouble = percentAmtNewDouble;
	}

	public boolean isTypeFlag() {
		return typeFlag;
	}

	public void setTypeFlag(boolean typeFlag) {
		this.typeFlag = typeFlag;
	}

	public String getGroupContractNo() {
		return groupContractNo;
	}

	public void setGroupContractNo(String groupContractNo) {
		this.groupContractNo = groupContractNo;
	}

	public Date getPeriodDt() {
		return periodDt;
	}

	public void setPeriodDt(Date periodDt) {
		this.periodDt = periodDt;
	}
	
	
	
	/**
	 * 
	 */

}
