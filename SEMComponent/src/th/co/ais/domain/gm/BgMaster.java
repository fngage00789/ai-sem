package th.co.ais.domain.gm;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

import th.co.ais.domain.AbstractDomain;

@Entity
@Table(name="SEM_CT_BG_MASTER", schema="SEM")
public class BgMaster extends AbstractDomain {

	// Fields
	private String rowId;
	private String company;
	private String depositDetailId;
	private String siteInfoId;
	private String siteName;
	private String contractNo;
	private String vendorId;
	private String expenseType;
	private String bgStatus;
	private String bgNo;
	private String bgBank;
	private String bgRemark;
	private Date bgStartDt;
	private Date bgEndDt;
	private Double bgAmt;
	private String contractAddr;
	private String siteAddr;
	private String remark;
	private String exportBgFlag;
	private Date exportBgDt;
	private String exportBgListFlag;
	private Date exportBgListDt;
	private String rejectReason;
	private String recordStatus;
	private Long version;
	private Date createDt;
	private String createBy;
	private Date updateDt;
	private String updateBy;

	
//	private String vendorName;
//	private String bgStatusName;
//	private Date ctrStartDt;
//	private Date ctrEndDt;
//	private String expenseName;
//	private String renewFalg;
	
	
	// Property accessors
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "BG_MASTER_ID", unique = true, nullable = false, length = 50)
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	@Column(name = "COMPANY", nullable = false, length = 5)
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "DEPOSIT_DETAIL_ID", length = 50)
	public String getDepositDetailId() {
		return depositDetailId;
	}

	public void setDepositDetailId(String depositDetailId) {
		this.depositDetailId = depositDetailId;
	}

	@Column(name = "SITE_INFO_ID", length = 50)
	public String getSiteInfoId() {
		return siteInfoId;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}

	@Column(name = "SITE_NAME", length = 200)
	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	@Column(name = "CONTRACT_NO", length = 20)
	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	@Column(name = "VENDOR_ID", length = 50)
	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	@Column(name = "EXPENSE_TYPE", length = 20)
	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	@Column(name = "BG_STATUS", length = 30)
	public String getBgStatus() {
		return bgStatus;
	}

	public void setBgStatus(String bgStatus) {
		this.bgStatus = bgStatus;
	}

	@Column(name = "BG_NO", length = 20)
	public String getBgNo() {
		return bgNo;
	}

	public void setBgNo(String bgNo) {
		this.bgNo = bgNo;
	}

	@Column(name = "BG_BANK", length = 50)
	public String getBgBank() {
		return bgBank;
	}

	public void setBgBank(String bgBank) {
		this.bgBank = bgBank;
	}

	@Column(name = "BG_REMARK", length = 250)
	public String getBgRemark() {
		return bgRemark;
	}

	public void setBgRemark(String bgRemark) {
		this.bgRemark = bgRemark;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "BG_START_DT", length = 7)
	public Date getBgStartDt() {
		return bgStartDt;
	}

	public void setBgStartDt(Date bgStartDt) {
		this.bgStartDt = bgStartDt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "BG_END_DT", length = 7)
	public Date getBgEndDt() {
		return bgEndDt;
	}

	public void setBgEndDt(Date bgEndDt) {
		this.bgEndDt = bgEndDt;
	}

	@Column(name = "BG_AMT", precision = 15)
	public Double getBgAmt() {
		return bgAmt;
	}

	public void setBgAmt(Double bgAmt) {
		this.bgAmt = bgAmt;
	}

	@Column(name = "CONTRACT_ADDR", length = 100)
	public String getContractAddr() {
		return contractAddr;
	}

	public void setContractAddr(String contractAddr) {
		this.contractAddr = contractAddr;
	}

	@Column(name = "SITE_ADDR", length = 100)
	public String getSiteAddr() {
		return siteAddr;
	}

	public void setSiteAddr(String siteAddr) {
		this.siteAddr = siteAddr;
	}

	@Column(name = "REMARK", length = 250)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "EXPORT_BG_FLAG", length = 1)
	public String getExportBgFlag() {
		return exportBgFlag;
	}

	public void setExportBgFlag(String exportBgFlag) {
		this.exportBgFlag = exportBgFlag;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EXPORT_BG_DT", length = 7)
	public Date getExportBgDt() {
		return exportBgDt;
	}

	public void setExportBgDt(Date exportBgDt) {
		this.exportBgDt = exportBgDt;
	}

	@Column(name = "EXPORT_BG_LIST_FLAG", length = 1)
	public String getExportBgListFlag() {
		return exportBgListFlag;
	}

	public void setExportBgListFlag(String exportBgListFlag) {
		this.exportBgListFlag = exportBgListFlag;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EXPORT_BG_LIST_DT", length = 7)
	public Date getExportBgListDt() {
		return exportBgListDt;
	}

	public void setExportBgListDt(Date exportBgListDt) {
		this.exportBgListDt = exportBgListDt;
	}

	@Column(name = "REJECT_REASON", length = 250)
	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	@Column(name = "RECORD_STATUS", length = 1)
	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	
	@Version
	@Column(name = "VERSION", precision = 10, scale = 0 , nullable = false)
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
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

	@Override
	public String toString() {
		return "BgMaster [bgAmt=" + bgAmt + ", bgBank=" + bgBank + ", bgEndDt="
				+ bgEndDt + ", bgNo=" + bgNo + ", bgRemark=" + bgRemark
				+ ", bgStartDt=" + bgStartDt + ", bgStatus=" + bgStatus
				+ ", company=" + company + ", contractAddr=" + contractAddr
				+ ", contractNo=" + contractNo + ", createBy=" + createBy
				+ ", createDt=" + createDt + ", depositDetailId="
				+ depositDetailId + ", expenseType=" + expenseType
				+ ", exportBgDt=" + exportBgDt + ", exportBgFlag="
				+ exportBgFlag + ", exportBgListDt=" + exportBgListDt
				+ ", exportBgListFlag=" + exportBgListFlag + ", recordStatus="
				+ recordStatus + ", rejectReason=" + rejectReason + ", remark="
				+ remark + ", rowId=" + rowId + ", siteAddr=" + siteAddr
				+ ", siteInfoId=" + siteInfoId + ", siteName=" + siteName
				+ ", updateBy=" + updateBy + ", updateDt=" + updateDt
				+ ", vendorId=" + vendorId + ", version=" + version + "]";
	}

}