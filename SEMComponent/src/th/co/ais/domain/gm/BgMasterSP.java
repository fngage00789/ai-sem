package th.co.ais.domain.gm;

import java.math.BigDecimal;
import java.util.Date;
import th.co.ais.domain.AbstractDomain;
import th.co.ais.rpt.util.annotation.PCell;
import th.co.ais.rpt.util.enums.EnumDocStyle;
public class BgMasterSP extends AbstractDomain {
	
	private String rowId;
	private String company;
	private String siteInfoId;
	private String siteName;
	private String contractNo;
	private String vendorId;
	private String expenseType;
	private String bgStatus;
	private String bgNo;
	private String bgBank;
	private String bgBankName;
	private String bgRemark;
	private Date bgStartDt;
	private Date bgEndDt;
	private Double bgAmt;
	private String contractAddr;
	private String siteAddr;
	private String remark;
	private String rejectReason;
	private String recordStatus;
	
	private String vendorName;
	private String bgStatusName;
	private Date ctrStartDt;
	private Date ctrEndDt;
	private String expenseName;
	private String renewFlag;
	private String newFlag;
	// row on for excel
	private int no;
	
	private String electricUseType;
	private Date receiveDt;
	private String bgStartDtLabel;
	private String bgEndDtLabel; 
	private BigDecimal totalSiteRemain;
	private String bankNameLabel;
	
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getSiteInfoId() {
		return siteInfoId;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}

	@PCell(cellType = String.class, no = 3)
	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	@PCell(cellType = String.class, no = 2)
	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	@PCell(cellType = String.class, no = 1)
	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	public String getBgStatus() {
		return bgStatus;
	}

	public void setBgStatus(String bgStatus) {
		this.bgStatus = bgStatus;
	}

	public String getBgNo() {
		return bgNo;
	}

	public void setBgNo(String bgNo) {
		this.bgNo = bgNo;
	}

	public String getBgBank() {
		return bgBank;
	}

	public void setBgBank(String bgBank) {
		this.bgBank = bgBank;
	}

	public String getBgRemark() {
		return bgRemark;
	}

	public void setBgRemark(String bgRemark) {
		this.bgRemark = bgRemark;
	}

	public Date getBgStartDt() {
		return bgStartDt;
	}

	public void setBgStartDt(Date bgStartDt) {
		this.bgStartDt = bgStartDt;
	}

	public Date getBgEndDt() {
		return bgEndDt;
	}

	public void setBgEndDt(Date bgEndDt) {
		this.bgEndDt = bgEndDt;
	}

	@PCell(cellType = Double.class, no = 9, styleName = EnumDocStyle.CELL_MONEY)
	public Double getBgAmt() {
		return bgAmt;
	}

	public void setBgAmt(Double bgAmt) {
		this.bgAmt = bgAmt;
	}

	public String getContractAddr() {
		return contractAddr;
	}

	public void setContractAddr(String contractAddr) {
		this.contractAddr = contractAddr;
	}

	public String getSiteAddr() {
		return siteAddr;
	}

	public void setSiteAddr(String siteAddr) {
		this.siteAddr = siteAddr;
	}

	@PCell(cellType = String.class, no = 10)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	@PCell(cellType = String.class, no = 8)
	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getBgStatusName() {
		return bgStatusName;
	}

	public void setBgStatusName(String bgStatusName) {
		this.bgStatusName = bgStatusName;
	}

	@PCell(cellType = Date.class, no = 4)
	public Date getCtrStartDt() {
		return ctrStartDt;
	}

	public void setCtrStartDt(Date ctrStartDt) {
		this.ctrStartDt = ctrStartDt;
	}

	@PCell(cellType = Date.class, no = 5)
	public Date getCtrEndDt() {
		return ctrEndDt;
	}

	public void setCtrEndDt(Date ctrEndDt) {
		this.ctrEndDt = ctrEndDt;
	}

	public String getExpenseName() {
		return expenseName;
	}

	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}

	@PCell(cellType = String.class, no = 6)
	public String getRenewFlag() {
		return renewFlag;
	}

	public void setRenewFlag(String renewFlag) {
		this.renewFlag = renewFlag;
	}
	
	@PCell(cellType = String.class, no = 7)
	public String getNewFlag() {
		return newFlag;
	}

	public void setNewFlag(String newFlag) {
		this.newFlag = newFlag;
	}
	
	public String getBgBankName() {
		return bgBankName;
	}

	public void setBgBankName(String bgBankName) {
		this.bgBankName = bgBankName;
	}
	
	@PCell(cellType = String.class, no = 0)
	public String getStringNo() {
		return no + "";
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	public String getElectricUseType() {
		return electricUseType;
	}

	public void setElectricUseType(String electricUseType) {
		this.electricUseType = electricUseType;
	}

	public Date getReceiveDt() {
		return receiveDt;
	}

	public void setReceiveDt(Date receiveDt) {
		this.receiveDt = receiveDt;
	}

	public String getBgStartDtLabel() {
		return bgStartDtLabel;
	}

	public void setBgStartDtLabel(String bgStartDtLabel) {
		this.bgStartDtLabel = bgStartDtLabel;
	}

	public String getBgEndDtLabel() {
		return bgEndDtLabel;
	}

	public void setBgEndDtLabel(String bgEndDtLabel) {
		this.bgEndDtLabel = bgEndDtLabel;
	}

	public BigDecimal getTotalSiteRemain() {
		return totalSiteRemain;
	}

	public void setTotalSiteRemain(BigDecimal totalSiteRemain) {
		this.totalSiteRemain = totalSiteRemain;
	}

	public String getBankNameLabel() {
		return bankNameLabel;
	}

	public void setBankNameLabel(String bankNameLabel) {
		this.bankNameLabel = bankNameLabel;
	}

	@Override
	public String toString() {
		return "BgMasterSP [bgAmt=" + bgAmt + ", bgBank=" + bgBank
				+ ", bgBankName=" + bgBankName + ", bgEndDt=" + bgEndDt
				+ ", bgNo=" + bgNo + ", bgRemark=" + bgRemark + ", bgStartDt="
				+ bgStartDt + ", bgStatus=" + bgStatus + ", bgStatusName="
				+ bgStatusName + ", company=" + company + ", contractAddr="
				+ contractAddr + ", contractNo=" + contractNo + ", ctrEndDt="
				+ ctrEndDt + ", ctrStartDt=" + ctrStartDt + ", expenseName="
				+ expenseName + ", expenseType=" + expenseType + ", newFlag="
				+ newFlag + ", no=" + no + ", recordStatus=" + recordStatus
				+ ", rejectReason=" + rejectReason + ", remark=" + remark
				+ ", renewFlag=" + renewFlag + ", rowId=" + rowId
				+ ", siteAddr=" + siteAddr + ", siteInfoId=" + siteInfoId
				+ ", siteName=" + siteName + ", vendorId=" + vendorId
				+ ", vendorName=" + vendorName + "]";
	}

}