package th.co.ais.domain.cp;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class ConstructionPermissionGenDocNoSearchSP extends AbstractDomain{

	private static final long serialVersionUID = 6636113475771022070L;
	
	private String rowId;
	private String genDocNo;
	
	
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getGenDocNo() {
		return genDocNo;
	}
	public void setGenDocNo(String genDocNo) {
		this.genDocNo = genDocNo;
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
