package th.co.ais.domain.rt;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mrt001SrchDpstCond extends AbstractDomain {
	
	private String siteInfoId;
	private String rentalMasterId;
	
	private String depositCondType;
	private String siteDepositId;
	private String seqNo;
	private String expenseType;
	private String expenseTypeName;
	private String depositType;
	private String depositTypeName;
	private String detail;
	private String remark;
	private Double condDepositAmt;
	private String vatType;
	private String vatTypeName;
	private String vatRate;
	private String newStatus;
	private String newStatusName;
	private Double sumDepositAmt;
	private Double condBalanceAmt; 
	private Date periodStDt;
	private Date periodEndDt;
	
	private boolean selected;
	private boolean disSelect;
	
	public boolean isDisSelect() {
		return disSelect;
	}
	public void setDisSelect(boolean disSelect) {
		this.disSelect = disSelect;
	}
	public Date getPeriodStDt() {
		return periodStDt;
	}
	public void setPeriodStDt(Date periodStDt) {
		this.periodStDt = periodStDt;
	}
	public Date getPeriodEndDt() {
		return periodEndDt;
	}
	public void setPeriodEndDt(Date periodEndDt) {
		this.periodEndDt = periodEndDt;
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
	public String getDepositCondType() {
		return depositCondType;
	}
	public void setDepositCondType(String depositCondType) {
		this.depositCondType = depositCondType;
	}
	public String getSiteDepositId() {
		return siteDepositId;
	}
	public void setSiteDepositId(String siteDepositId) {
		this.siteDepositId = siteDepositId;
	}
	public String getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
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
	public String getDepositType() {
		return depositType;
	}
	public void setDepositType(String depositType) {
		this.depositType = depositType;
	}
	public String getDepositTypeName() {
		return depositTypeName;
	}
	public void setDepositTypeName(String depositTypeName) {
		this.depositTypeName = depositTypeName;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Double getCondDepositAmt() {
		return condDepositAmt;
	}
	public void setCondDepositAmt(Double condDepositAmt) {
		this.condDepositAmt = condDepositAmt;
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
	public String getVatRate() {
		return vatRate;
	}
	public void setVatRate(String vatRate) {
		this.vatRate = vatRate;
	}
	public String getNewStatus() {
		return newStatus;
	}
	public void setNewStatus(String newStatus) {
		this.newStatus = newStatus;
	}
	public String getNewStatusName() {
		return newStatusName;
	}
	public void setNewStatusName(String newStatusName) {
		this.newStatusName = newStatusName;
	}
	public Double getSumDepositAmt() {
		return sumDepositAmt;
	}
	public void setSumDepositAmt(Double sumDepositAmt) {
		this.sumDepositAmt = sumDepositAmt;
	}
	public Double getCondBalanceAmt() {
		return condBalanceAmt;
	}
	public void setCondBalanceAmt(Double condBalanceAmt) {
		this.condBalanceAmt = condBalanceAmt;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
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
