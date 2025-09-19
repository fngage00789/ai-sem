package th.co.ais.domain.pt;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;
import th.co.ais.rpt.util.annotation.PCell;

public class Mpt003Act extends AbstractDomain{

		
	private String editPtaxMasterId;
	private String editContractNo;
	private Integer editPTaxYear;
	private Double editRentPreAmt;
	private Double editRentAmt;
	private String editRemark;
	private Double editPtaxAmt;
	private String editUsername;
	private String remark;
	private String pResult;
	private String pRemark;
	
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
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getEditPtaxMasterId() {
		return editPtaxMasterId;
	}
	public void setEditPtaxMasterId(String editPtaxMasterId) {
		this.editPtaxMasterId = editPtaxMasterId;
	}
	public String getEditContractNo() {
		return editContractNo;
	}
	public void setEditContractNo(String editContractNo) {
		this.editContractNo = editContractNo;
	}
	public Integer getEditPTaxYear() {
		return editPTaxYear;
	}
	public void setEditPTaxYear(Integer editPTaxYear) {
		this.editPTaxYear = editPTaxYear;
	}
	public Double getEditRentPreAmt() {
		return editRentPreAmt;
	}
	public void setEditRentPreAmt(Double editRentPreAmt) {
		this.editRentPreAmt = editRentPreAmt;
	}
	public Double getEditRentAmt() {
		return editRentAmt;
	}
	public void setEditRentAmt(Double editRentAmt) {
		this.editRentAmt = editRentAmt;
	}
	public String getEditRemark() {
		return editRemark;
	}
	public void setEditRemark(String editRemark) {
		this.editRemark = editRemark;
	}
	public Double getEditPtaxAmt() {
		return editPtaxAmt;
	}
	public void setEditPtaxAmt(Double editPtaxAmt) {
		this.editPtaxAmt = editPtaxAmt;
	}
	public String getEditUsername() {
		return editUsername;
	}
	public void setEditUsername(String editUsername) {
		this.editUsername = editUsername;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getpResult() {
		return pResult;
	}
	public void setpResult(String pResult) {
		this.pResult = pResult;
	}
	public String getpRemark() {
		return pRemark;
	}
	public void setpRemark(String pRemark) {
		this.pRemark = pRemark;
	}
	
	
	
}
