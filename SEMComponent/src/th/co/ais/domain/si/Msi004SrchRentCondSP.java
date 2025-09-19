package th.co.ais.domain.si;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Msi004SrchRentCondSP extends AbstractDomain{

	private static final long serialVersionUID = 4860593220050079696L;
	
	private String rowId;
	private String seqNo;
	private String rentCondType;
	private String expenseType;
	private String expenseTypeName;
	private String placeName;
	private String detail;
	private Double rentOldAmt;
	private Double rentAddPercent;
	private Double rentAddAmt;
	private Double rentAmt;
	private String rentPeriodType;
	private String rentPeriodTypeName;
	private String whtType;
	private String whtTypeName;
	private Double whtRate;
	private String vatType;
	private String vatTypeName;
	private String payPeriod;
	private String payPeriodType;
	private String payPeriodTypeName;
	private Date effDate;
	private String siteInfoId;
	private String editableFlag;
	private String deleteableFlag;
	private String overFlag;
	private String overFlagName;
	private boolean renderedButtonDelete;
	private boolean renderRendCondType;
	
	//added BY NEW 2015/04/29
	private String subExpenseType;
	
	private String effDateStr;
	
	//added BY OUM 2016/08/04
	private String siteAqId;
	
	//added by NEW 2018/09/26
	private Date expireDt;
	private String expireDtStr;
	private Date periodStartDt;
	private String periodStartDtStr;
	private Date periodEndDt;
	private String periodEndDtStr;
	private Date changeEffectiveDt;
	private String changeEffectiveDtStr;
	private String rentAdj;
	private String rentAdjName;
	private String rentAdjPeriodType;
	private String rentAdjPeriodTypeName;
	private String serviceId;
	private String serviceName;
	private String rentOldPeriodType;
	private String rentOldPeriodTypeName;
	private String rentAddPeriodType;
	private String rentAddPeriodTypeName;
	private String refSiteRentCondId;
	
	private String editTableFlag;
	private String deleteTableFlag;
	
	private Date effectiveDt;
	private String effectiveDtStr;
	private Date startDt;
	private String startDtStr;
	private Date endDt;
	private String endDtStr;
	private String recordStatus;
	
	// add for Donate 02/03/2023 
	private String expenseDesc;  
	
	public boolean isRenderedButtonDelete() {
		return renderedButtonDelete;
	}
	public void setRenderedButtonDelete(boolean renderedButtonDelete) {
		this.renderedButtonDelete = renderedButtonDelete;
	}
	public String getOverFlag() {
		return overFlag;
	}
	public void setOverFlag(String overFlag) {
		this.overFlag = overFlag;
	}
	public String getOverFlagName() {
		return overFlagName;
	}
	public void setOverFlagName(String overFlagName) {
		this.overFlagName = overFlagName;
	}
	public String getEditableFlag() {
		return editableFlag;
	}
	public void setEditableFlag(String editableFlag) {
		this.editableFlag = editableFlag;
	}
	public String getDeleteableFlag() {
		return deleteableFlag;
	}
	public void setDeleteableFlag(String deleteableFlag) {
		this.deleteableFlag = deleteableFlag;
	}
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	
	public String getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	public String getRentCondType() {
		return rentCondType;
	}
	public void setRentCondType(String rentCondType) {
		this.rentCondType = rentCondType;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public String getExpenseTypeName() {
		return expenseTypeName;
	}
	public void setExpenseTypeName(String expenseTypeName) {
		this.expenseTypeName = expenseTypeName;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Double getRentOldAmt() {
		return rentOldAmt;
	}
	public void setRentOldAmt(Double rentOldAmt) {
		this.rentOldAmt = rentOldAmt;
	}
	public Double getRentAddPercent() {
		return rentAddPercent;
	}
	public void setRentAddPercent(Double rentAddPercent) {
		this.rentAddPercent = rentAddPercent;
	}
	public Double getRentAddAmt() {
		return rentAddAmt;
	}
	public void setRentAddAmt(Double rentAddAmt) {
		this.rentAddAmt = rentAddAmt;
	}
	public Double getRentAmt() {
		return rentAmt;
	}
	public void setRentAmt(Double rentAmt) {
		this.rentAmt = rentAmt;
	}
	public String getRentPeriodType() {
		return rentPeriodType;
	}
	public void setRentPeriodType(String rentPeriodType) {
		this.rentPeriodType = rentPeriodType;
	}
	public String getRentPeriodTypeName() {
		return rentPeriodTypeName;
	}
	public void setRentPeriodTypeName(String rentPeriodTypeName) {
		this.rentPeriodTypeName = rentPeriodTypeName;
	}
	
	public String getWhtType() {
		return whtType;
	}
	public void setWhtType(String whtType) {
		this.whtType = whtType;
	}
	public String getWhtTypeName() {
		return whtTypeName;
	}
	public void setWhtTypeName(String whtTypeName) {
		this.whtTypeName = whtTypeName;
	}
	public Double getWhtRate() {
		return whtRate;
	}
	public void setWhtRate(Double whtRate) {
		this.whtRate = whtRate;
	}
	public String getVatType() {
		return vatType;
	}
	public void setVatType(String vatType) {
		this.vatType = vatType;
	}
	public String getVatTypeName() {
		return vatTypeName;
	}
	public void setVatTypeName(String vatTypeName) {
		this.vatTypeName = vatTypeName;
	}
	
	public String getPayPeriodType() {
		return payPeriodType;
	}
	public void setPayPeriodType(String payPeriodType) {
		this.payPeriodType = payPeriodType;
	}
	
	public String getPayPeriodTypeName() {
		return payPeriodTypeName;
	}
	public void setPayPeriodTypeName(String payPeriodTypeName) {
		this.payPeriodTypeName = payPeriodTypeName;
	}
	public String getPayPeriod() {
		return payPeriod;
	}
	public void setPayPeriod(String payPeriod) {
		this.payPeriod = payPeriod;
	}
	public Date getEffDate() {
		return effDate;
	}
	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
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
	public boolean isRenderRendCondType() {
		return renderRendCondType;
	}
	public void setRenderRendCondType(boolean renderRendCondType) {
		this.renderRendCondType = renderRendCondType;
	}
	public String getEffDateStr() {
		return effDateStr;
	}
	public void setEffDateStr(String effDateStr) {
		this.effDateStr = effDateStr;
	}
	public String getSubExpenseType() {
		return subExpenseType;
	}
	public void setSubExpenseType(String subExpenseType) {
		this.subExpenseType = subExpenseType;
	}
	public String getSiteAqId() {
		return siteAqId;
	}
	public void setSiteAqId(String siteAqId) {
		this.siteAqId = siteAqId;
	}
	public Date getExpireDt() {
		return expireDt;
	}
	public void setExpireDt(Date expireDt) {
		this.expireDt = expireDt;
	}
	public Date getPeriodStartDt() {
		return periodStartDt;
	}
	public void setPeriodStartDt(Date periodStartDt) {
		this.periodStartDt = periodStartDt;
	}
	public Date getPeriodEndDt() {
		return periodEndDt;
	}
	public void setPeriodEndDt(Date periodEndDt) {
		this.periodEndDt = periodEndDt;
	}
	public Date getChangeEffectiveDt() {
		return changeEffectiveDt;
	}
	public void setChangeEffectiveDt(Date changeEffectiveDt) {
		this.changeEffectiveDt = changeEffectiveDt;
	}
	public String getRentAdjPeriodType() {
		return rentAdjPeriodType;
	}
	public void setRentAdjPeriodType(String rentAdjPeriodType) {
		this.rentAdjPeriodType = rentAdjPeriodType;
	}
	public String getRentAdjPeriodTypeName() {
		return rentAdjPeriodTypeName;
	}
	public void setRentAdjPeriodTypeName(String rentAdjPeriodTypeName) {
		this.rentAdjPeriodTypeName = rentAdjPeriodTypeName;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getRentOldPeriodType() {
		return rentOldPeriodType;
	}
	public void setRentOldPeriodType(String rentOldPeriodType) {
		this.rentOldPeriodType = rentOldPeriodType;
	}
	public String getRentOldPeriodTypeName() {
		return rentOldPeriodTypeName;
	}
	public void setRentOldPeriodTypeName(String rentOldPeriodTypeName) {
		this.rentOldPeriodTypeName = rentOldPeriodTypeName;
	}
	public String getRentAddPeriodType() {
		return rentAddPeriodType;
	}
	public void setRentAddPeriodType(String rentAddPeriodType) {
		this.rentAddPeriodType = rentAddPeriodType;
	}
	public String getRentAddPeriodTypeName() {
		return rentAddPeriodTypeName;
	}
	public void setRentAddPeriodTypeName(String rentAddPeriodTypeName) {
		this.rentAddPeriodTypeName = rentAddPeriodTypeName;
	}
	public String getRefSiteRentCondId() {
		return refSiteRentCondId;
	}
	public void setRefSiteRentCondId(String refSiteRentCondId) {
		this.refSiteRentCondId = refSiteRentCondId;
	}
	public String getRentAdj() {
		return rentAdj;
	}
	public void setRentAdj(String rentAdj) {
		this.rentAdj = rentAdj;
	}
	public String getExpireDtStr() {
		return expireDtStr;
	}
	public void setExpireDtStr(String expireDtStr) {
		this.expireDtStr = expireDtStr;
	}
	public String getPeriodStartDtStr() {
		return periodStartDtStr;
	}
	public void setPeriodStartDtStr(String periodStartDtStr) {
		this.periodStartDtStr = periodStartDtStr;
	}
	public String getPeriodEndDtStr() {
		return periodEndDtStr;
	}
	public void setPeriodEndDtStr(String periodEndDtStr) {
		this.periodEndDtStr = periodEndDtStr;
	}
	public String getChangeEffectiveDtStr() {
		return changeEffectiveDtStr;
	}
	public void setChangeEffectiveDtStr(String changeEffectiveDtStr) {
		this.changeEffectiveDtStr = changeEffectiveDtStr;
	}
	public String getEditTableFlag() {
		return editTableFlag;
	}
	public void setEditTableFlag(String editTableFlag) {
		this.editTableFlag = editTableFlag;
	}
	public String getDeleteTableFlag() {
		return deleteTableFlag;
	}
	public void setDeleteTableFlag(String deleteTableFlag) {
		this.deleteTableFlag = deleteTableFlag;
	}
	public Date getEffectiveDt() {
		return effectiveDt;
	}
	public void setEffectiveDt(Date effectiveDt) {
		this.effectiveDt = effectiveDt;
	}
	public String getEffectiveDtStr() {
		return effectiveDtStr;
	}
	public void setEffectiveDtStr(String effectiveDtStr) {
		this.effectiveDtStr = effectiveDtStr;
	}
	public Date getStartDt() {
		return startDt;
	}
	public void setStartDt(Date startDt) {
		this.startDt = startDt;
	}
	public String getStartDtStr() {
		return startDtStr;
	}
	public void setStartDtStr(String startDtStr) {
		this.startDtStr = startDtStr;
	}
	public Date getEndDt() {
		return endDt;
	}
	public void setEndDt(Date endDt) {
		this.endDt = endDt;
	}
	public String getEndDtStr() {
		return endDtStr;
	}
	public void setEndDtStr(String endDtStr) {
		this.endDtStr = endDtStr;
	}
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	public String getRentAdjName() {
		return rentAdjName;
	}
	public void setRentAdjName(String rentAdjName) {
		this.rentAdjName = rentAdjName;
	}
	public String getExpenseDesc() {
		return expenseDesc;
	}
	public void setExpenseDesc(String expenseDesc) {
		this.expenseDesc = expenseDesc;
	}
	
	
	
}
