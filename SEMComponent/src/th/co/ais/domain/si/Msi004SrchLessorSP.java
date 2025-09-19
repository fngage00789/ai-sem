package th.co.ais.domain.si;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Msi004SrchLessorSP extends AbstractDomain{

	private static final long serialVersionUID = 8535991161351804985L;
	
	private String rowId;
	private String siteInfoId;
	private String lessorName;
	private String address;
	private String tel;
	private String fax;
	private String editableFlag;
	private String deleteableFalg;
	private String overFlag;
	private String overFlagName;
	
	
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
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	public String getLessorName() {
		return lessorName;
	}
	public void setLessorName(String lessorName) {
		this.lessorName = lessorName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	public String getEditableFlag() {
		return editableFlag;
	}
	public void setEditableFlag(String editableFlag) {
		this.editableFlag = editableFlag;
	}
	public String getDeleteableFalg() {
		return deleteableFalg;
	}
	public void setDeleteableFalg(String deleteableFalg) {
		this.deleteableFalg = deleteableFalg;
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
