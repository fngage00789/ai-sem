package th.co.ais.domain.ac;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mac001Sap extends AbstractDomain{

	private String transPaymentId;
	private String drcr;
	private String accNo;
	private String specialGl;
	private String accDesc;
	private String costCenter;
	private String wbsNo;
	private Double amount;
	private String taxCode;
	private Double taxBase;
	private String whtCode;
	private Double whtBase;
	private Double whtAmt;
	private String lineItemText;
	private String expenseDesc;
	
	
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
	public String getTransPaymentId() {
		return transPaymentId;
	}
	public void setTransPaymentId(String transPaymentId) {
		this.transPaymentId = transPaymentId;
	}
	public String getDrcr() {
		return drcr;
	}
	public void setDrcr(String drcr) {
		this.drcr = drcr;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getSpecialGl() {
		return specialGl;
	}
	public void setSpecialGl(String specialGl) {
		this.specialGl = specialGl;
	}
	public String getCostCenter() {
		return costCenter;
	}
	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}
	public String getWbsNo() {
		return wbsNo;
	}
	public void setWbsNo(String wbsNo) {
		this.wbsNo = wbsNo;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getTaxCode() {
		return taxCode;
	}
	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}
	public String getWhtCode() {
		return whtCode;
	}
	public void setWhtCode(String whtCode) {
		this.whtCode = whtCode;
	}
	public Double getWhtAmt() {
		return whtAmt;
	}
	public void setWhtAmt(Double whtAmt) {
		this.whtAmt = whtAmt;
	}
	public String getLineItemText() {
		return lineItemText;
	}
	public void setLineItemText(String lineItemText) {
		this.lineItemText = lineItemText;
	}
	public void setAccDesc(String accDesc) {
		this.accDesc = accDesc;
	}
	public String getAccDesc() {
		return accDesc;
	}
	public Double getTaxBase() {
		return taxBase;
	}
	public void setTaxBase(Double taxBase) {
		this.taxBase = taxBase;
	}
	public Double getWhtBase() {
		return whtBase;
	}
	public void setWhtBase(Double whtBase) {
		this.whtBase = whtBase;
	}
	public String getExpenseDesc() {
		return expenseDesc;
	}
	public void setExpenseDesc(String expenseDesc) {
		this.expenseDesc = expenseDesc;
	}
	
	
}
