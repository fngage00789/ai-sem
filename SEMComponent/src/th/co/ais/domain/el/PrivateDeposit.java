package th.co.ais.domain.el;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import th.co.ais.domain.AbstractDomain;

@Entity
@Table(name="SEM_EL_PRIVATE_DEPOSIT", schema="SEM")

public class PrivateDeposit extends AbstractDomain {

	private static final long serialVersionUID = -5336280120229486833L;
	
	private String rowId;
	private String siteInfoId;
	private String contractNo;
	private String expenseType;
	private String depositType;
	private BigDecimal depositAmt;
	private String depositDetail;
	private String depositSpecialFlag;
	private String vatType;
	private String vatTypeLabel;
	private String remark;
	private String newFlag;
	private String recordStatus;
	
	private String newFlagTxt;
	private String expenseTypeTxt;
	private String depositTypeTxt;
	private String vatTypeTxt;

	private boolean selected;
	private boolean added;

	// business method
	@Transient
	public boolean isAdded() {
		return added;
	}
	
	public void setAdded(boolean added) {
		this.added = added;
	}
	
	@Transient
	public boolean isSelected() {
		return selected;
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	@Transient
	public boolean isNewFlagBoolean(){
		
		return getNewFlag() != null && getNewFlag().equalsIgnoreCase("y");
	}
	
	public void setNewFlagBoolean(boolean flag){
		
		if(flag) setNewFlag("Y");
		else setNewFlag("N");
	}
	
	@Transient
	public boolean isDepositSpecialFlagBoolean(){
		
		return getDepositSpecialFlag() != null && getDepositSpecialFlag().equalsIgnoreCase("y");
	}
	
	public void setDepositSpecialFlagBoolean(boolean flag){
		
		if(flag) setDepositSpecialFlag("Y");
		else setDepositSpecialFlag("N");
	}
	
	
	@Transient
	public String getVatTypeLabel() {
		return vatTypeLabel;
	}
	
	public void setVatTypeLabel(String vatTypeLabel) {
		this.vatTypeLabel = vatTypeLabel;
	}
	
	@Id
   	@GeneratedValue(generator="system-uuid")
   	@GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="PRIVATE_DEROSIT_ID")	
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	
	@Column(name="SITE_INFO_ID")	
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	
	@Column(name="CONTRACT_NO")
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	
	@Column(name="EXPENSE_TYPE")
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	
	@Column(name="DEPOSIT_TYPE")
	public String getDepositType() {
		return depositType;
	}
	public void setDepositType(String depositType) {
		this.depositType = depositType;
	}
	
	@Column(name="DEPOSIT_AMT")
	public BigDecimal getDepositAmt() {
		return depositAmt;
	}
	public void setDepositAmt(BigDecimal depositAmt) {
		this.depositAmt = depositAmt;
	}
	
	@Column(name="DEPOSIT_DETAIL")
	public String getDepositDetail() {
		return depositDetail;
	}
	public void setDepositDetail(String depositDetail) {
		this.depositDetail = depositDetail;
	}
	
	@Column(name="DEPOSIT_SPECIAL_FLAG")
	public String getDepositSpecialFlag() {
		return depositSpecialFlag;
	}
	public void setDepositSpecialFlag(String depositSpecialFlag) {
		this.depositSpecialFlag = depositSpecialFlag;
	}
	
	@Column(name="VAT_TYPE")
	public String getVatType() {
		return vatType;
	}
	public void setVatType(String vatType) {
		this.vatType = vatType;
	}
	
	@Column(name="REMARK")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(name="NEW_FLAG")
	public String getNewFlag() {
		return newFlag;
	}
	public void setNewFlag(String newFlag) {
		this.newFlag = newFlag;
	}
	
	@Column(name="RECORD_STATUS")
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	@Override
	@Column(name="CREATE_BY")
	public String getCreateBy() {
		return this.createBy;
	}
	@Override
	@Column(name="CREATE_DT")
	public Date getCreateDt() {
		return this.createDt;
	}

	@Override
	@Column(name="UPDATE_BY")
	public String getUpdateBy() {
		return this.updateBy;
	}

	@Override
	@Column(name="UPDATE_DT")
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
	@Transient
	public String getNewFlagTxt() {
		return newFlagTxt;
	}
	public void setNewFlagTxt(String newFlagTxt) {
		this.newFlagTxt = newFlagTxt;
	}
	@Transient
	public String getExpenseTypeTxt() {
		return expenseTypeTxt;
	}
	public void setExpenseTypeTxt(String expenseTypeTxt) {
		this.expenseTypeTxt = expenseTypeTxt;
	}
	@Transient
	public String getDepositTypeTxt() {
		return depositTypeTxt;
	}
	public void setDepositTypeTxt(String depositTypeTxt) {
		this.depositTypeTxt = depositTypeTxt;
	}
	@Transient
	public String getVatTypeTxt() {
		return vatTypeTxt;
	}
	public void setVatTypeTxt(String vatTypeTxt) {
		this.vatTypeTxt = vatTypeTxt;
	}
	public PrivateDeposit clonePrivateDeposit(){
		PrivateDeposit newPrivateDepost = new PrivateDeposit();
		newPrivateDepost.setRowId(rowId);
		newPrivateDepost.setSiteInfoId(siteInfoId);
		newPrivateDepost.setContractNo(contractNo);
		newPrivateDepost.setExpenseType(expenseType);
		newPrivateDepost.setDepositType(depositType);
		newPrivateDepost.setDepositAmt(depositAmt);
		newPrivateDepost.setDepositDetail(depositDetail);
		newPrivateDepost.setDepositSpecialFlag(depositSpecialFlag);
		newPrivateDepost.setVatType(vatType);
		newPrivateDepost.setVatTypeLabel(vatTypeLabel);
		newPrivateDepost.setRemark(remark);
		newPrivateDepost.setNewFlag(newFlag);
		newPrivateDepost.setRecordStatus(recordStatus);
		newPrivateDepost.setNewFlagTxt(newFlagTxt);
		newPrivateDepost.setExpenseTypeTxt(expenseTypeTxt);
		newPrivateDepost.setDepositTypeTxt(depositTypeTxt);
		newPrivateDepost.setVatTypeTxt(vatTypeTxt);
		
		return newPrivateDepost;
	}
	
}
