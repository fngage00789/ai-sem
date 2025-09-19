package th.co.ais.domain.si;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class LegalApproveSrchByAppvSP extends AbstractDomain{

	private boolean selected;
	private String rowId;
	private String siteApproveId;
	private Date chkDt;
	private Date receiveDt;
	private String legalApproveStatus;
	private String legalApproveStatusName;
	private String remark;
	private Integer cRound;
	
	private String editTableFlag;
	private boolean chkFlagEditable;
	private String deletableFlag;
	private String cancleTable;
	private boolean renderedDeletetable;
	private String lastestFlag;
	private String docNotComplete;
	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getSiteApproveId() {
		return siteApproveId;
	}

	public void setSiteApproveId(String siteApproveId) {
		this.siteApproveId = siteApproveId;
	}

	public Date getChkDt() {
		return chkDt;
	}

	public void setChkDt(Date chkDt) {
		this.chkDt = chkDt;
	}

	public String getLegalApproveStatusName() {
		return legalApproveStatusName;
	}

	public void setLegalApproveStatusName(String legalApproveStatusName) {
		this.legalApproveStatusName = legalApproveStatusName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getLegalApproveStatus() {
		return legalApproveStatus;
	}

	public void setLegalApproveStatus(String legalApproveStatus) {
		this.legalApproveStatus = legalApproveStatus;
	}
	
	public Date getReceiveDt() {
		return receiveDt;
	}

	public void setReceiveDt(Date receiveDt) {
		this.receiveDt = receiveDt;
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

	public void setcRound(Integer cRound) {
		this.cRound = cRound;
	}

	public Integer getcRound() {
		return cRound;
	}

	public void setEditTableFlag(String editTableFlag) {
		this.editTableFlag = editTableFlag;
	}

	public String getEditTableFlag() {
		return editTableFlag;
	}

	public void setChkFlagEditable(boolean chkFlagEditable) {
		this.chkFlagEditable = chkFlagEditable;
	}

	public boolean isChkFlagEditable() {
		return chkFlagEditable;
	}

	public String getDeletableFlag() {
		return deletableFlag;
	}

	public void setDeletableFlag(String deletableFlag) {
		this.deletableFlag = deletableFlag;
	}

	public String getCancleTable() {
		return cancleTable;
	}

	public void setCancleTable(String cancleTable) {
		this.cancleTable = cancleTable;
	}

	public void setRenderedDeletetable(boolean renderedDeletetable) {
		this.renderedDeletetable = renderedDeletetable;
	}

	public boolean isRenderedDeletetable() {
		return renderedDeletetable;
	}

	public String getLastestFlag() {
		return lastestFlag;
	}

	public void setLastestFlag(String lastestFlag) {
		this.lastestFlag = lastestFlag;
	}

	public String getDocNotComplete() {
		return docNotComplete;
	}

	public void setDocNotComplete(String docNotComplete) {
		this.docNotComplete = docNotComplete;
	}

}
