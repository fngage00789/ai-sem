package th.co.ais.domain.co;

import java.util.Date;


import th.co.ais.domain.AbstractDomain;
public class Mco001CheckAddAbleSP extends AbstractDomain{
	private static final long serialVersionUID = -7563082147781224969L;
	
	private String rowId;
	private String contractId;
	private String role;
	private String addAbleFlag;
	private String editAbleFlag;
	private String deleteAbleFlag;
	private String editDutyFlag;
	private String editTotFlag;
	
	
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAddAbleFlag() {
		return addAbleFlag;
	}
	public void setAddAbleFlag(String addAbleFlag) {
		this.addAbleFlag = addAbleFlag;
	}
	public String getEditAbleFlag() {
		return editAbleFlag;
	}
	public void setEditAbleFlag(String editAbleFlag) {
		this.editAbleFlag = editAbleFlag;
	}
	public String getDeleteAbleFlag() {
		return deleteAbleFlag;
	}
	public void setDeleteAbleFlag(String deleteAbleFlag) {
		this.deleteAbleFlag = deleteAbleFlag;
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
	public String getEditDutyFlag() {
		return editDutyFlag;
	}
	public void setEditDutyFlag(String editDutyFlag) {
		this.editDutyFlag = editDutyFlag;
	}
	public String getEditTotFlag() {
		return editTotFlag;
	}
	public void setEditTotFlag(String editTotFlag) {
		this.editTotFlag = editTotFlag;
	}
	
}
