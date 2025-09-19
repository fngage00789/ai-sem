package th.co.ais.domain.el;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import th.co.ais.domain.AbstractDomain;
import th.co.ais.domain.gm.Attachment;


@Entity(name="th.co.ais.domain.el.BgMaster")
@Table(name="SEM_CT_BG_MASTER", schema="SEM")
public class BgMaster extends AbstractDomain {
	
	private static final long serialVersionUID = -2701220841471315835L;
	private static final SimpleDateFormat SDF 	= new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));
	
	private String rowId;
	private Management electricId;
	private DepositDetail depositDetailId;
	private String company;
	private String electricUseType;
	private String siteInfoId;
	private String siteName;
	private String contractNo;
	private String bgType;
	private String vendorId;
	private String expenseType;
	private String bgStatus;
	private String bgNo;
	private String bgBankName;
	private String bgRemark;
	private Date bgStartDt;
	private Date bgEndDt;
	private BigDecimal bgAmt;
	private String contractAddress;
	private String siteAddress;
	private String remark;
	private String exportBgFlag;
	private Date exportBgDt;
	private String exportBgListFlag;
	private Date exportBgListDt;
	private String rejectReason;
	private BigDecimal totalSiteMeter;
	private BigDecimal totalSiteBg;
	private BigDecimal totalSiteAdd;
	private BigDecimal totalSiteDecrease;
	private BigDecimal totalSiteRemain;
	private BigDecimal totalSiteChange;
	private String recordStatus;
	private BigDecimal version;
	
	private Date bgStartDtFrom;
	private Date bgStartDtTo;
	private Date bgEndDtFrom;
	private Date bgEndDtTo;
	private boolean selected;
	private String bgStatusDisplay;
	private String bgTypeDisplay;
	private String bgBankNameDisplay;
	private String electricUseTypeDisplay;
	private Set<BgMapContract> bgMapContracts = new HashSet<BgMapContract>(0);
	private String bankNameLabel;
	private String previousBgMasterId;
	private String bgStartDtLabel;
	private String bgEndDtLabel;
	private boolean disableEditButton;
	private boolean disableViewButton;
	//private boolBgMasterFileeDBgMasterFilee;
	private boolean disableDelbtn;
	
	@Id
  	@GeneratedValue(generator="system-uuid")
  	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "BG_MASTER_ID")
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ELECTRIC_ID")	
	public Management getElectricId() {
		return electricId;
	}
		public void setElectricId(Management electricId) {
		this.electricId = electricId;
	}
	@Column(name = "ELECTRIC_USE_TYPE")
	public String getElectricUseType() {
		return electricUseType;
	}
	public void setElectricUseType(String electricUseType) {
		this.electricUseType = electricUseType;
	}
	@Column(name = "RECORD_STATUS", length = 1)
	@Filter(name="validRecord", condition="RECORD_STATUS = 'Y'") 
	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	
	@ManyToOne(fetch = FetchType.LAZY, cascade={CascadeType.ALL})
	@JoinColumn(name = "DEPOSIT_DETAIL_ID")
	public DepositDetail getDepositDetailId() {
		return depositDetailId;
	}	
	public void setDepositDetailId(DepositDetail depositDetailId) {
		this.depositDetailId = depositDetailId;
	}
	
	@Column(name = "COMPANY")
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	@Column(name = "SITE_INFO_ID")
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	
	@Column(name = "SITE_NAME")
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	
	@Column(name = "CONTRACT_NO")
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	
	@Column(name = "BG_TYPE")
	public String getBgType() {
		return bgType;
	}
	public void setBgType(String bgType) {
		this.bgType = bgType;
	}
	
	@Column(name = "VENDOR_ID")
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	
	@Column(name = "EXPENSE_TYPE")
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	
	@Column(name = "BG_STATUS")
	public String getBgStatus() {
		return bgStatus;
	}
	public void setBgStatus(String bgStatus) {
		this.bgStatus = bgStatus;
	}
	
	@Column(name = "BG_NO")
	public String getBgNo() {
		return bgNo;
	}
	public void setBgNo(String bgNo) {
		this.bgNo = bgNo;
	}
	
	@Column(name = "BG_BANK")
	public String getBgBankName() {
		return bgBankName;
	}
	public void setBgBankName(String bgBankName) {
		this.bgBankName = bgBankName;
	}
	
	@Column(name = "BG_REMARK")
	public String getBgRemark() {
		return bgRemark;
	}
	public void setBgRemark(String bgRemark) {
		this.bgRemark = bgRemark;
	}
	
	@Column(name = "BG_START_DT")
	public Date getBgStartDt() {
		return bgStartDt;
	}
	public void setBgStartDt(Date bgStartDt) {
		this.bgStartDt = bgStartDt;
	}
	
	@Column(name = "BG_END_DT")
	public Date getBgEndDt() {
		return bgEndDt;
	}
	public void setBgEndDt(Date bgEndDt) {
		this.bgEndDt = bgEndDt;
	}
	
	//bgStartDt
	@Transient
	public String getBgStartDtDisplay() {
		String bgStartDtStr = (null != bgStartDt) ? SDF.format(bgStartDt) : "";
		return bgStartDtStr;
	}
	//bgEndDtDisplay
	@Transient
	public String getBgEndDtDisplay() {
		String bgEndDtStr = (null != bgEndDt) ? SDF.format(bgEndDt) : "";
		return bgEndDtStr;
	}
	
	@Column(name = "BG_AMT")
	public BigDecimal getBgAmt() {
		return bgAmt;
	}
	public void setBgAmt(BigDecimal bgAmt) {
		this.bgAmt = bgAmt;
	}
	
	@Column(name = "CONTRACT_ADDR")
	public String getContractAddress() {
		return contractAddress;
	}
	public void setContractAddress(String contractAddress) {
		this.contractAddress = contractAddress;
	}
	
	@Column(name = "SITE_ADDR")
	public String getSiteAddress() {
		return siteAddress;
	}
	public void setSiteAddress(String siteAddress) {
		this.siteAddress = siteAddress;
	}
	
	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(name = "EXPORT_BG_FLAG")
	public String getExportBgFlag() {
		return exportBgFlag;
	}
	public void setExportBgFlag(String exportBgFlag) {
		this.exportBgFlag = exportBgFlag;
	}
	
	@Column(name = "EXPORT_BG_DT")
	public Date getExportBgDt() {
		return exportBgDt;
	}
	public void setExportBgDt(Date exportBgDt) {
		this.exportBgDt = exportBgDt;
	}
	
	@Column(name = "EXPORT_BG_LIST_FLAG")
	public String getExportBgListFlag() {
		return exportBgListFlag;
	}
	public void setExportBgListFlag(String exportBgListFlag) {
		this.exportBgListFlag = exportBgListFlag;
	}
	
	@Column(name = "EXPORT_BG_LIST_DT")
	public Date getExportBgListDt() {
		return exportBgListDt;
	}
	public void setExportBgListDt(Date exportBgListDt) {
		this.exportBgListDt = exportBgListDt;
	}
	
	@Column(name = "REJECT_REASON")
	public String getRejectReason() {
		return rejectReason;
	}
	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}
	
	@Column(name = "TOTAL_SITE_METER")
	public BigDecimal getTotalSiteMeter() {
		return totalSiteMeter;
	}
	public void setTotalSiteMeter(BigDecimal totalSiteMeter) {
		this.totalSiteMeter = totalSiteMeter;
	}
	
	@Column(name = "TOTAL_SITE_BG")
	public BigDecimal getTotalSiteBg() {
		return totalSiteBg;
	}
	public void setTotalSiteBg(BigDecimal totalSiteBg) {
		this.totalSiteBg = totalSiteBg;
	}
	
	@Column(name = "TOTAL_SITE_ADD")
	public BigDecimal getTotalSiteAdd() {
		return totalSiteAdd;
	}
	public void setTotalSiteAdd(BigDecimal totalSiteAdd) {
		this.totalSiteAdd = totalSiteAdd;
	}
	
	@Column(name = "TOTAL_SITE_DECREASE")
	public BigDecimal getTotalSiteDecrease() {
		return totalSiteDecrease;
	}
	public void setTotalSiteDecrease(BigDecimal totalSiteDecrease) {
		this.totalSiteDecrease = totalSiteDecrease;
	}
	
	@Column(name = "TOTAL_SITE_REMAIN")
	public BigDecimal getTotalSiteRemain() {
		return totalSiteRemain;
	}
	public void setTotalSiteRemain(BigDecimal totalSiteRemain) {
		this.totalSiteRemain = totalSiteRemain;
	}
	
	@Column(name = "TOTAL_SITE_CHANGE")
	public BigDecimal getTotalSiteChange() {
		return totalSiteChange;
	}
	public void setTotalSiteChange(BigDecimal totalSiteChange) {
		this.totalSiteChange = totalSiteChange;
	}
	
	@Column(name = "VERSION")
	public BigDecimal getVersion() {
		return version;
	}
	public void setVersion(BigDecimal version) {
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
	
	@Column(name="PREVIOUS_BG_MASTER_ID")
	public String getPreviousBgMasterId() {
		return previousBgMasterId;
	}
	
	public void setPreviousBgMasterId(String previousBgMasterId) {
		this.previousBgMasterId = previousBgMasterId;
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
	public Date getBgStartDtFrom() {
		return bgStartDtFrom;
	}
	public void setBgStartDtFrom(Date bgStartDtFrom) {
		this.bgStartDtFrom = bgStartDtFrom;
	}
	@Transient
	public Date getBgStartDtTo() {
		return bgStartDtTo;
	}
	public void setBgStartDtTo(Date bgStartDtTo) {
		this.bgStartDtTo = bgStartDtTo;
	}
	@Transient
	public Date getBgEndDtFrom() {
		return bgEndDtFrom;
	}
	public void setBgEndDtFrom(Date bgEndDtFrom) {
		this.bgEndDtFrom = bgEndDtFrom;
	}
	@Transient
	public Date getBgEndDtTo() {
		return bgEndDtTo;
	}
	public void setBgEndDtTo(Date bgEndDtTo) {
		this.bgEndDtTo = bgEndDtTo;
	}
	@Transient
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	@Transient
	public boolean getDisableCheckbox(){
		boolean booleanReturn = false;
		if("D".equals(bgStatus) || "N".equals(bgStatus) || "R".equals(bgStatus)){
			booleanReturn = true;
		}
		
		return booleanReturn;
	}
	
	@Transient
	public boolean getDisableEditIcon(){
		boolean booleanReturn = false;
		if("MAIN".equals(bgType) && "A".equals(bgStatus)){
			booleanReturn = true;
		}else if("BG".equals(bgType)){
			booleanReturn = true;
		}
		
		return booleanReturn;
	}
	
	@Transient
	public boolean getDisableViewIcon(){
		boolean booleanReturn = false;
		if("MAIN".equals(bgType) && "D".equals(bgStatus)){
			booleanReturn = true;
		}else if(!"BG".equals(bgType)){
			booleanReturn = true;
		}
		
		return booleanReturn;
	}
	
	public BgMaster clone(){
		BgMaster bgMaster = new BgMaster();
		bgMaster.setRowId(this.rowId);
		bgMaster.setBgAmt(this.bgAmt);
		bgMaster.setBgBankName(this.bgBankName);
		bgMaster.setBgEndDt(this.bgEndDt);
		bgMaster.setBgNo(this.bgNo);
		bgMaster.setBgRemark(this.remark);
		bgMaster.setBgStartDt(this.bgStartDt);
		bgMaster.setBgStatus(this.bgStatus);
		bgMaster.setBgType(this.bgType);
		
		return bgMaster;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "bgMasterId")
	public Set<BgMapContract> getBgMapContracts() {
		return bgMapContracts;
	}
	public void setBgMapContracts(Set<BgMapContract> bgMapContracts) {
		this.bgMapContracts = bgMapContracts;
	}
	
	@Transient
	public String getBgStatusDisplay() {
		return bgStatusDisplay;
	}
	public void setBgStatusDisplay(String bgStatusDisplay) {
		this.bgStatusDisplay = bgStatusDisplay;
	}
	
	@Transient
	public String getBankNameLabel() {
		return bankNameLabel;
	}
	public void setBankNameLabel(String bankNameLabel) {
		this.bankNameLabel = bankNameLabel;
	}
	
	@Transient
	public String getBgBankNameDisplay() {
		return bgBankNameDisplay;
	}
	public void setBgBankNameDisplay(String bgBankNameDisplay) {
		this.bgBankNameDisplay = bgBankNameDisplay;
	}
	
	@Transient
	public String getElectricUseTypeDisplay() {
		return electricUseTypeDisplay;
	}
	public void setElectricUseTypeDisplay(String electricUseTypeDisplay) {
		this.electricUseTypeDisplay = electricUseTypeDisplay;
	}
	
	@Transient
	public String getBgTypeDisplay() {
		return bgTypeDisplay;
	}
	public void setBgTypeDisplay(String bgTypeDisplay) {
		this.bgTypeDisplay = bgTypeDisplay;
	}
	
	@Transient
	public String getBgStartDtLabel() {
		return bgStartDtLabel;
	}
	public void setBgStartDtLabel(String bgStartDtLabel) {
		this.bgStartDtLabel = bgStartDtLabel;
	}
	
	@Transient
	public String getBgEndDtLabel() {
		return bgEndDtLabel;
	}
	public void setBgEndDtLabel(String bgEndDtLabel) {
		this.bgEndDtLabel = bgEndDtLabel;
	}
	
	@Transient
	public boolean isDisableEditButton() {
		boolean booleanReturn = true;
				
		/*if("D".equals(bgStatus) || "A".equals(bgStatus) || "R".equals(bgStatus)){
			booleanReturn = false;
		}*/
		if("01".equals(bgType)){
			booleanReturn = false;
		}else if("02".equals(bgType)){//Special
			if("D".equals(bgStatus) || "R".equals(bgStatus) || "A".equals(bgStatus)){
				booleanReturn = true;
			}else if("F".equals(bgStatus) || "N".equals(bgStatus)){
					booleanReturn = false;
			}
		}
		
		return booleanReturn;
	}
	public void setDisableEditButton(boolean disableEditButton) {
		this.disableEditButton = disableEditButton;
	}
	
	@Transient
	public boolean isDisableViewButton() {
		boolean booleanReturn = true;
		
		/*if("D".equals(bgStatus) || "N".equals(bgStatus) || "A".equals(bgStatus) || "R".equals(bgStatus)){
			booleanReturn = false;
		}*/
		if("01".equals(bgType)){//Normal
			booleanReturn = false;
		}else if("02".equals(bgType)){//Special
				if("D".equals(bgStatus) || "R".equals(bgStatus) || "A".equals(bgStatus)){
					booleanReturn = true;
				}else if("F".equals(bgStatus) || "N".equals(bgStatus)){
					booleanReturn = true;
				}
		}
		return booleanReturn;
	}
	public void setDisableViewButton(boolean disableViewButton) {
		this.disableViewButton = disableViewButton;
	}
	@Transient
	public boolean isDisableDelbtn() {
		if(bgStatus.equals("D")){
			disableDelbtn = true;	
		}else{
			disableDelbtn = false;
		}
			
		return disableDelbtn;
	}
	public void setDisableDelbtn(boolean disableDelbtn) {
		this.disableDelbtn = disableDelbtn;
	}
	
}
