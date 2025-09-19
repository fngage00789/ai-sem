package th.co.ais.web.el.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.model.SelectItem;

import org.richfaces.model.UploadItem;

import th.co.ais.domain.el.BgMaster;
import th.co.ais.domain.el.BgMasterFile;
import th.co.ais.domain.el.BgMasterSPEL;
import th.co.ais.domain.el.DepositDetail;
import th.co.ais.domain.el.ExportMainBgSP;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.WarrantDatail;
import th.co.ais.domain.el.WarrantDetailSP;
import th.co.ais.web.bean.AbstractBean;
import th.co.ais.web.ir.bean.File;

public class SEMMEL010_2Bean extends AbstractBean implements Serializable {

	
	private static final long serialVersionUID = -168357028041134335L;
	
	private String company;
	private String electricUseType;
	private String contractNo;
	private Date startDt;
	private Date endDt;
	private BigDecimal bgAmt;
	private String contractorAddress;
	private BigDecimal totalSiteMeter;
	private BigDecimal totalSiteBG;
	private BigDecimal totalSiteAdd;
	private BigDecimal totalSiteDecrease;
	private BigDecimal totalSiteRemain;
	private BigDecimal totalSiteChange;
	private String bgStatus;
	private List<SelectItem> bgStatusList;
	private String remark;
	private String bgNo;
	private String bankName;
	private String bankNameDisplay;
	private List bankList;
	private String receiveBgRemark;
	private boolean disableBtnSiteDetail = true;
	private boolean disabledBtnExport = true;
	private boolean disableBtnSaveDraft = true;
	private boolean disableBtnExport = true;
	private boolean disableBtnSave = true;
	private boolean disableBtnCancel = true;
	private boolean disableStartDt;
	private boolean disableEndDt;
	private boolean disableBgAmt;
	private boolean disableContractorAddress;
	private boolean disableTotalSiteBG;
	private boolean disableTotalSiteChange;
	private boolean disableRemark;
	private boolean disableBtnUploadFile;
	private Set<Management> managementList;
	private BgMaster bgMaster;
	private List<UploadItem> uploadFileList;
	private List<BgMasterFile> bgMasterFileList;
	private List<BgMasterSPEL> bgMasterSPELList;
	private List<ExportMainBgSP> exportMainBgSP;
	private List<BgMaster> bgMasterList;
	private List<DepositDetail> depositDetailList;
	private Set<BgMasterFile> BgMasterFile = new HashSet<BgMasterFile>(0);
	private String delRowId;
	private BgMaster delBgMaster = new BgMaster(); ;
	private boolean disableDeletFile = true;
	private ArrayList<File> files = new ArrayList<File>();
	@Override
	public int getRowPerPage() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void setRowPerPage(int rowPerPage) {
		// TODO Auto-generated method stub
		
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getElectricUseType() {
		return electricUseType;
	}
	public void setElectricUseType(String electricUseType) {
		this.electricUseType = electricUseType;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public Date getStartDt() {
		return startDt;
	}
	public void setStartDt(Date startDt) {
		this.startDt = startDt;
	}
	public Date getEndDt() {
		return endDt;
	}
	public void setEndDt(Date endDt) {
		this.endDt = endDt;
	}
	public BigDecimal getBgAmt() {
		return bgAmt;
	}
	public void setBgAmt(BigDecimal bgAmt) {
		this.bgAmt = bgAmt;
	}
	public String getContractorAddress() {
		return contractorAddress;
	}
	public void setContractorAddress(String contractorAddress) {
		this.contractorAddress = contractorAddress;
	}
	public BigDecimal getTotalSiteMeter() {
		return totalSiteMeter;
	}
	public void setTotalSiteMeter(BigDecimal totalSiteMeter) {
		this.totalSiteMeter = totalSiteMeter;
	}
	public BigDecimal getTotalSiteBG() {
		return totalSiteBG;
	}
	public void setTotalSiteBG(BigDecimal totalSiteBG) {
		this.totalSiteBG = totalSiteBG;
	}
	public BigDecimal getTotalSiteAdd() {
		return totalSiteAdd;
	}
	public void setTotalSiteAdd(BigDecimal totalSiteAdd) {
		this.totalSiteAdd = totalSiteAdd;
	}
	public BigDecimal getTotalSiteDecrease() {
		return totalSiteDecrease;
	}
	public void setTotalSiteDecrease(BigDecimal totalSiteDecrease) {
		this.totalSiteDecrease = totalSiteDecrease;
	}
	public BigDecimal getTotalSiteRemain() {
		return totalSiteRemain;
	}
	public void setTotalSiteRemain(BigDecimal totalSiteRemain) {
		this.totalSiteRemain = totalSiteRemain;
	}
	public BigDecimal getTotalSiteChange() {
		return totalSiteChange;
	}
	public void setTotalSiteChange(BigDecimal totalSiteChange) {
		this.totalSiteChange = totalSiteChange;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getBgNo() {
		return bgNo;
	}
	public void setBgNo(String bgNo) {
		this.bgNo = bgNo;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}	
	public List getBankList() {
		return bankList;
	}
	public void setBankList(List bankList) {
		this.bankList = bankList;
	}
	public String getReceiveBgRemark() {
		return receiveBgRemark;
	}
	public void setReceiveBgRemark(String receiveBgRemark) {
		this.receiveBgRemark = receiveBgRemark;
	}
	public boolean isDisableBtnSiteDetail() {
		return disableBtnSiteDetail;
	}
	public void setDisableBtnSiteDetail(boolean disableBtnSiteDetail) {
		this.disableBtnSiteDetail = disableBtnSiteDetail;
	}
	public String getBgStatus() {
		return bgStatus;
	}
	public void setBgStatus(String bgStatus) {
		this.bgStatus = bgStatus;
	}
	public List<SelectItem> getBgStatusList() {
		return bgStatusList;
	}
	public void setBgStatusList(List<SelectItem> bgStatusList) {
		this.bgStatusList = bgStatusList;
	}
	public boolean isDisabledBtnExport() {
		return disabledBtnExport;
	}
	public void setDisabledBtnExport(boolean disabledBtnExport) {
		this.disabledBtnExport = disabledBtnExport;
	}
	public boolean isDisableBtnSaveDraft() {
		return disableBtnSaveDraft;
	}
	public void setDisableBtnSaveDraft(boolean disableBtnSaveDraft) {
		this.disableBtnSaveDraft = disableBtnSaveDraft;
	}
	public boolean isDisableBtnExport() {
		return disableBtnExport;
	}
	public void setDisableBtnExport(boolean disableBtnExport) {
		this.disableBtnExport = disableBtnExport;
	}
	public boolean isDisableBtnSave() {
		return disableBtnSave;
	}
	public void setDisableBtnSave(boolean disableBtnSave) {
		this.disableBtnSave = disableBtnSave;
	}
	public boolean isDisableBtnCancel() {
		return disableBtnCancel;
	}
	public void setDisableBtnCancel(boolean disableBtnCancel) {
		this.disableBtnCancel = disableBtnCancel;
	}

	public Set<Management> getManagementList() {
		return managementList;
	}

	public void setManagementList(Set<Management> managementList) {
		this.managementList = managementList;
	}

	public BgMaster getBgMaster() {
		return bgMaster;
	}

	public void setBgMaster(BgMaster bgMaster) {
		this.bgMaster = bgMaster;
	}

	public List<UploadItem> getUploadFileList() {
		return uploadFileList;
	}

	public void setUploadFileList(List<UploadItem> uploadFileList) {
		this.uploadFileList = uploadFileList;
	}

	public List<BgMasterFile> getBgMasterFileList() {
		return bgMasterFileList;
	}

	public void setBgMasterFileList(List<BgMasterFile> bgMasterFileList) {
		this.bgMasterFileList = bgMasterFileList;
	}

	public List<BgMasterSPEL> getBgMasterSPELList() {
		return bgMasterSPELList;
	}

	public void setBgMasterSPELList(List<BgMasterSPEL> bgMasterSPELList) {
		this.bgMasterSPELList = bgMasterSPELList;
	}

	public List<ExportMainBgSP> getExportMainBgSP() {
		return exportMainBgSP;
	}

	public void setExportMainBgSP(List<ExportMainBgSP> exportMainBgSP) {
		this.exportMainBgSP = exportMainBgSP;
	}

	public boolean isDisableStartDt() {
		return disableStartDt;
	}

	public void setDisableStartDt(boolean disableStartDt) {
		this.disableStartDt = disableStartDt;
	}

	public boolean isDisableEndDt() {
		return disableEndDt;
	}

	public void setDisableEndDt(boolean disableEndDt) {
		this.disableEndDt = disableEndDt;
	}

	public boolean isDisableBgAmt() {
		return disableBgAmt;
	}

	public void setDisableBgAmt(boolean disableBgAmt) {
		this.disableBgAmt = disableBgAmt;
	}

	public boolean isDisableContractorAddress() {
		return disableContractorAddress;
	}

	public void setDisableContractorAddress(boolean disableContractorAddress) {
		this.disableContractorAddress = disableContractorAddress;
	}

	public boolean isDisableTotalSiteBG() {
		return disableTotalSiteBG;
	}

	public void setDisableTotalSiteBG(boolean disableTotalSiteBG) {
		this.disableTotalSiteBG = disableTotalSiteBG;
	}

	public boolean isDisableTotalSiteChange() {
		return disableTotalSiteChange;
	}

	public void setDisableTotalSiteChange(boolean disableTotalSiteChange) {
		this.disableTotalSiteChange = disableTotalSiteChange;
	}

	public boolean isDisableRemark() {
		return disableRemark;
	}

	public void setDisableRemark(boolean disableRemark) {
		this.disableRemark = disableRemark;
	}

	public boolean isDisableBtnUploadFile() {
		return disableBtnUploadFile;
	}

	public void setDisableBtnUploadFile(boolean disableBtnUploadFile) {
		this.disableBtnUploadFile = disableBtnUploadFile;
	}

	public List<BgMaster> getBgMasterList() {
		return bgMasterList;
	}

	public void setBgMasterList(List<BgMaster> bgMasterList) {
		this.bgMasterList = bgMasterList;
	}

	public List<DepositDetail> getDepositDetailList() {
		return depositDetailList;
	}

	public void setDepositDetailList(List<DepositDetail> depositDetailList) {
		this.depositDetailList = depositDetailList;
	}

	public String getBankNameDisplay() {
		return bankNameDisplay;
	}

	public void setBankNameDisplay(String bankNameDisplay) {
		this.bankNameDisplay = bankNameDisplay;
	}

	public Set<BgMasterFile> getBgMasterFile() {
		return BgMasterFile;
	}

	public void setBgMasterFile(Set<BgMasterFile> bgMasterFile) {
		BgMasterFile = bgMasterFile;
	}

	public String getDelRowId() {
		return delRowId;
	}

	public void setDelRowId(String delRowId) {
		this.delRowId = delRowId;
	}

	public BgMaster getDelBgMaster() {
		return delBgMaster;
	}

	public void setDelBgMaster(BgMaster delBgMaster) {
		this.delBgMaster = delBgMaster;
	}

	public boolean isDisableDeletFile() {
		return disableDeletFile;
	}

	public void setDisableDeletFile(boolean disableDeletFile) {
		this.disableDeletFile = disableDeletFile;
	}

	public ArrayList<File> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<File> files) {
		this.files = files;
	}
		
}
