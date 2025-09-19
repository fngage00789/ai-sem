package th.co.ais.domain.pt;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;
import th.co.ais.rpt.util.annotation.PCell;

public class Mpt006Srch extends AbstractDomain{

	
	private static final long serialVersionUID = 1L;
	private boolean selected;
	private String rowId;
	
	private String ptTaxPayType;  
	private Date createDateFrom; //From
	private Date createDateTo;   // To  
	private String vendorSave;  
	
	// output In Excel
	private String pTaxHistId;   
	private String contractNo; 
	private Integer changeAmt;	
	private String pTaxPayDesc; 
	
	public Date getCreateDateFrom() {
		return createDateFrom;
	}
	public void setCreateDateFrom(Date createDateFrom) {
		this.createDateFrom = createDateFrom;
	}
	public Date getCreateDateTo() {
		return createDateTo;
	}
	public void setCreateDateTo(Date createDateTo) {
		this.createDateTo = createDateTo;
	}
	public String getVendorSave() {
		return vendorSave;
	}
	public void setVendorSave(String vendorSave) {
		this.vendorSave = vendorSave;
	}
	
	public String getpTaxHistId() {
		return pTaxHistId;
	}
	public void setpTaxHistId(String pTaxHistId) {
		this.pTaxHistId = pTaxHistId;
	}
	@PCell(cellType = Integer.class, no = 1)
	public Integer getChangeAmt() {
		return changeAmt;
	}
	public void setChangeAmt(Integer changeAmt) {
		this.changeAmt = changeAmt;
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
	@PCell(cellType = String.class, no = 3)
	public String getUpdateBy() {
		return this.updateBy;
	}
	@Override
	@PCell(cellType = Date.class, no = 4)
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
	@PCell(cellType = String.class, no = 0)
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	@PCell(cellType = String.class, no = 2)
	public String getpTaxPayDesc() {
		return pTaxPayDesc;
	}
	public void setpTaxPayDesc(String pTaxPayDesc) {
		this.pTaxPayDesc = pTaxPayDesc;
	}
	public String getRowId() {
		return rowId;
	}
	
	/*
	 * à¸œà¸¹à¹‰à¸ˆà¹ˆà¸²à¸¢à¸ à¸²à¸©à¸µà¹‚à¸£à¸‡à¹€à¸£à¸·à¸­à¸™(à¸›à¸£à¸°à¸§à¸±à¸•à¸´) 
	 * @see th.co.ais.domain.AbstractDomain#setRowId(java.lang.String)
	 */
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	/*
	 * à¸œà¸¹à¹‰à¸ˆà¹ˆà¸²à¸¢à¸ à¸²à¸©à¸µà¹‚à¸£à¸‡à¹€à¸£à¸·à¸­à¸™(à¸›à¸£à¸°à¸§à¸±à¸•à¸´) 
	 */
	public void setPtTaxPayType(String ptTaxPayType) {
		this.ptTaxPayType = ptTaxPayType;
	}
	public String getPtTaxPayType() {
		return ptTaxPayType;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public boolean isSelected() {
		return selected;
	}
}
