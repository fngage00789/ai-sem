package th.co.ais.web.el.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.el.ElectricPermissionUploadFile;
import th.co.ais.domain.el.ElectricPermissionWarrant;
import th.co.ais.domain.el.UploadElPermistionWarrant;
import th.co.ais.domain.el.UploadMeterFile;
import th.co.ais.domain.el.UploadPermissionFile;
import th.co.ais.domain.el.WarrantDatail;
import th.co.ais.domain.el.WarrantDetailSP;
import th.co.ais.web.bean.AbstractBean;

public class SEMMEL002Bean extends AbstractBean implements Serializable {

	private static final long serialVersionUID = -168357028041134335L;

	private String company;
	private String electricUseType;
	private String oneBillAddFlag;
	private String contractNo;
	private String siteName;
	private String pMeterOwnerName;
	private String locationId;
	private String locationCode;
	private String batchNo;
	private Date printDt;
	private Date printDtFrom;
	private Date printDtTo;
	private Date sentSamuserDtFrom;
	private Date sentSamuserDtTo;
	private String warrantType;
	private String exportFlag;
	private boolean isMaxPrintTimes = false;
	private boolean renderedSelectFile = true;
	private boolean renderedExportErrorButton = false;
	private String supplier;
	private boolean chkSelAll;
	private boolean disabledBtnExport = true;
	private boolean disabledBtnUpdateStatusWarrant = true;
	private List<WarrantDatail> warrantDetailList;
	private List<WarrantDetailSP> warrantDetailSPList;
	private List<WarrantDetailSP> popupWarrantDetailSPList;//WT###20110127

	// data dropdown list
	private List<SelectItem> companyList;
	private List<SelectItem> warrantTypeList;
	private List<SelectItem> exportFlagList;
	
	//WT###Add 20110126 Start
	private String region;
	private String province;
	private String warrantStatus;
	private List<SelectItem> provinceList;
	private List<SelectItem> regionList;
	private List<SelectItem> warrantStatusList;
	private Date sentContractDtFrom;
	private Date sentContractDtTo;
	private Date sentWarrantDtTo;
	private Date sentWarrantDtFrom;
	private Date sentSighDtFrom;
	private Date sentSighDtTo;
	private Date sighDtFrom;
	private Date sighDtTo;
	private Date popupSentSighDt;
	private boolean isDisablePopupSentSighDt;
	private Date popupSighDt;
	private boolean disablePopupSighDt;
	private Date popupSentWarrantDt;
	private boolean disablePopupSentWarrantDt;
	private Date popupSentContractDt;
	private boolean disablePopupSentContractDt;
	private Date popupSentSamuserDt;
	private boolean disablePopupSentSamuserDt;
	private String popupSamUsername;
	private String popupSamuserPhone;
	private String popupRemark;
	//WT###Add 20110126 End
	//WT###Add 20110207 Start
	private boolean displayPopupUpdateStatus;
	private Date compleateDtFrom;
	private Date compleateDtTo;
	private Date exportDtFrom;
	private Date exportDtTo;
	//WT###Add 20110227 End

	//SUKANLAYA###Add 20160329 Start
	private boolean disabledBtnImport = false;
	private String fileName;
	private String statusAction;
	private Date uploadFileDtTo;
	private Date uploadFileDtFrom;
	private List<SelectItem> reqTypeList;
	private String reqType;
	private boolean displayShowPopup;
	private boolean disabledBtnPopupEdit;
	private UploadPermissionFile uploadPermissionFile = new UploadPermissionFile();
	//Render message form Popup
	private boolean renderedMsgFormPopup = true;
	//popupEdit
	private String areaCodeElectric;
	private String areaElectric;
	private String memberWithArea;
	private String numberMeter;
	private String meterType;
	private String meterSize;
	private String rateOfElectric;
	private Date elActiveDt;
	private String line;
	private String elTransformersBrand;
	private String elLevel;
	private String elTransformersNumber;
	private String elTransformersSize;
	private Date elTransformersInstallDt;
	private String remark;
	private List<SelectItem> typeUseElectricList;
	private String typeUseElectric;
	
	private List<ElectricPermissionUploadFile>  uploadFileList = new ArrayList<ElectricPermissionUploadFile>();
	private List<ElectricPermissionWarrant> permissionWarrantForShow = new ArrayList<ElectricPermissionWarrant>();
	private List<UploadElPermistionWarrant> uploadElPerList = new ArrayList<UploadElPermistionWarrant>();
	private UploadElPermistionWarrant permistionWarrant = new UploadElPermistionWarrant();
	private List<UploadElPermistionWarrant> uploadElPerListForPopup = new ArrayList<UploadElPermistionWarrant>();
	private String logId;
	private String uploadFileErrorCode;
	private String errorThisPage;
	
	private boolean renderedSavePage1Button = false;
	private boolean renderedSavePage3Button = false;
	private String processStatusCode;
	private List<SelectItem> processStatusNameList;
	private String failUpload ;
	private String statusForDelete;
	
	private String companyPage2;
	private String electricUseTypePage2;
	private String processStatusCodePage2;
	private List<SelectItem> processStatusNameListPage2;
	private List<SelectItem> typeUseElectricListPage2;
	private String typeUseElectricPage2;
	private Date uploadFileDtToPage2;
	private Date uploadFileDtFromPage2;
	private List<SelectItem> companyListPage2;
	private List<SelectItem> warrantTypeListPage2;
	private String fileNamePage2;
	private List<SelectItem> regionListPage2;
	private List<SelectItem> warrantStatusListPage2;
	private List<SelectItem> reqTypeListPage2;
	private String reqTypePage2;
	private String regionPage2;
	private boolean renderedMsgDataNotFoundFirstPage = false;
	private String msgDataNotFoundFirstPage;
	private boolean renderedMsgDataNotFoundSecondPage = false;
	private String msgDataNotFoundSecondPage;
	private boolean renderedBackButtonToPage1 = false;
	private boolean renderedBackButtonToPage2 = false;
	
	private String logIdFordelete;
	private String rowIdFordelete;
	//SUKANLAYA###Add 20160329 End
	
	
	public boolean isDisabledBtnExport() {
		return disabledBtnExport;
	}

	public String getRegionPage2() {
		return regionPage2;
	}

	public void setRegionPage2(String regionPage2) {
		this.regionPage2 = regionPage2;
	}

	public void setDisabledBtnExport(boolean disabledBtnExport) {
		this.disabledBtnExport = disabledBtnExport;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getpMeterOwnerName() {
		return pMeterOwnerName;
	}

	public void setpMeterOwnerName(String pMeterOwnerName) {
		this.pMeterOwnerName = pMeterOwnerName;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public Date getPrintDt() {
		return printDt;
	}

	public void setPrintDt(Date printDt) {
		this.printDt = printDt;
	}

	public Date getPrintDtFrom() {
		return printDtFrom;
	}

	public void setPrintDtFrom(Date printDtFrom) {
		this.printDtFrom = printDtFrom;
	}

	public Date getPrintDtTo() {
		return printDtTo;
	}

	public void setPrintDtTo(Date printDtTo) {
		this.printDtTo = printDtTo;
	}

	public List<SelectItem> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}

	public List<SelectItem> getWarrantTypeList() {
		return warrantTypeList;
	}

	public void setWarrantTypeList(List<SelectItem> warrantTypeList) {
		this.warrantTypeList = warrantTypeList;
	}

	public List<SelectItem> getExportFlagList() {
		return exportFlagList;
	}

	public void setExportFlagList(List<SelectItem> exportFlagList) {
		this.exportFlagList = exportFlagList;
	}

	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
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

	public String getOneBillAddFlag() {
		return oneBillAddFlag;
	}

	public void setOneBillAddFlag(String oneBillAddFlag) {
		this.oneBillAddFlag = oneBillAddFlag;
	}

	public boolean isChkSelAll() {
		return chkSelAll;
	}

	public void setChkSelAll(boolean chkSelAll) {
		this.chkSelAll = chkSelAll;
	}

	public List<WarrantDatail> getWarrantDetailList() {
		return warrantDetailList;
	}

	public void setWarrantDetailList(List<WarrantDatail> warrantDetailList) {
		this.warrantDetailList = warrantDetailList;
	}

	public String getWarrantType() {
		return warrantType;
	}

	public void setWarrantType(String warrantType) {
		this.warrantType = warrantType;
	}

	public String getExportFlag() {
		return exportFlag;
	}

	public void setExportFlag(String exportFlag) {
		this.exportFlag = exportFlag;
	}

	public Date getSentSamuserDtFrom() {
		return sentSamuserDtFrom;
	}

	public void setSentSamuserDtFrom(Date sentSamuserDtFrom) {
		this.sentSamuserDtFrom = sentSamuserDtFrom;
	}

	public Date getSentSamuserDtTo() {
		return sentSamuserDtTo;
	}

	public void setSentSamuserDtTo(Date sentSamuserDtTo) {
		this.sentSamuserDtTo = sentSamuserDtTo;
	}

	public boolean isMaxPrintTimes() {
		return isMaxPrintTimes;
	}

	public void setMaxPrintTimes(boolean isMaxPrintTimes) {
		this.isMaxPrintTimes = isMaxPrintTimes;
	}

	public List<WarrantDetailSP> getWarrantDetailSPList() {
		return warrantDetailSPList;
	}

	public void setWarrantDetailSPList(List<WarrantDetailSP> warrantDetailSPList) {
		this.warrantDetailSPList = warrantDetailSPList;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public List<SelectItem> getProvinceList() {
		return provinceList;
	}

	public void setProvinceList(List<SelectItem> provinceList) {
		this.provinceList = provinceList;
	}

	public List<SelectItem> getRegionList() {
		return regionList;
	}

	public void setRegionList(List<SelectItem> regionList) {
		this.regionList = regionList;
	}

	public List<SelectItem> getWarrantStatusList() {
		return warrantStatusList;
	}

	public void setWarrantStatusList(List<SelectItem> warrantStatusList) {
		this.warrantStatusList = warrantStatusList;
	}

	public String getWarrantStatus() {
		return warrantStatus;
	}

	public void setWarrantStatus(String warrantStatus) {
		this.warrantStatus = warrantStatus;
	}

	public Date getSentContractDtFrom() {
		return sentContractDtFrom;
	}

	public void setSentContractDtFrom(Date sentContractDtFrom) {
		this.sentContractDtFrom = sentContractDtFrom;
	}

	public Date getSentContractDtTo() {
		return sentContractDtTo;
	}

	public void setSentContractDtTo(Date sentContractDtTo) {
		this.sentContractDtTo = sentContractDtTo;
	}

	public Date getSentWarrantDtTo() {
		return sentWarrantDtTo;
	}

	public void setSentWarrantDtTo(Date sentWarrantDtTo) {
		this.sentWarrantDtTo = sentWarrantDtTo;
	}

	public Date getSentWarrantDtFrom() {
		return sentWarrantDtFrom;
	}

	public void setSentWarrantDtFrom(Date sentWarrantDtFrom) {
		this.sentWarrantDtFrom = sentWarrantDtFrom;
	}

	public Date getSentSighDtFrom() {
		return sentSighDtFrom;
	}

	public void setSentSighDtFrom(Date sentSighDtFrom) {
		this.sentSighDtFrom = sentSighDtFrom;
	}

	public Date getSentSighDtTo() {
		return sentSighDtTo;
	}

	public void setSentSighDtTo(Date sentSighDtTo) {
		this.sentSighDtTo = sentSighDtTo;
	}

	public Date getSighDtFrom() {
		return sighDtFrom;
	}

	public void setSighDtFrom(Date sighDtFrom) {
		this.sighDtFrom = sighDtFrom;
	}

	public Date getSighDtTo() {
		return sighDtTo;
	}

	public void setSighDtTo(Date sighDtTo) {
		this.sighDtTo = sighDtTo;
	}

	public boolean isDisabledBtnUpdateStatusWarrant() {
		return disabledBtnUpdateStatusWarrant;
	}

	public void setDisabledBtnUpdateStatusWarrant(
			boolean disabledBtnUpdateStatusWarrant) {
		this.disabledBtnUpdateStatusWarrant = disabledBtnUpdateStatusWarrant;
	}

	public List<WarrantDetailSP> getPopupWarrantDetailSPList() {
		return popupWarrantDetailSPList;
	}

	public void setPopupWarrantDetailSPList(
			List<WarrantDetailSP> popupWarrantDetailSPList) {
		this.popupWarrantDetailSPList = popupWarrantDetailSPList;
	}

	public Date getPopupSentSighDt() {
		return popupSentSighDt;
	}

	public void setPopupSentSighDt(Date popupSentSighDt) {
		this.popupSentSighDt = popupSentSighDt;
	}

	public Date getPopupSighDt() {
		return popupSighDt;
	}

	public void setPopupSighDt(Date popupSighDt) {
		this.popupSighDt = popupSighDt;
	}

	public Date getPopupSentWarrantDt() {
		return popupSentWarrantDt;
	}

	public void setPopupSentWarrantDt(Date popupSentWarrantDt) {
		this.popupSentWarrantDt = popupSentWarrantDt;
	}

	public Date getPopupSentContractDt() {
		return popupSentContractDt;
	}

	public void setPopupSentContractDt(Date popupSentContractDt) {
		this.popupSentContractDt = popupSentContractDt;
	}

	public Date getPopupSentSamuserDt() {
		return popupSentSamuserDt;
	}

	public void setPopupSentSamuserDt(Date popupSentSamuserDt) {
		this.popupSentSamuserDt = popupSentSamuserDt;
	}

	public String getPopupSamUsername() {
		return popupSamUsername;
	}

	public void setPopupSamUsername(String popupSamUsername) {
		this.popupSamUsername = popupSamUsername;
	}

	public String getPopupSamuserPhone() {
		return popupSamuserPhone;
	}

	public void setPopupSamuserPhone(String popupSamuserPhone) {
		this.popupSamuserPhone = popupSamuserPhone;
	}

	public String getPopupRemark() {
		return popupRemark;
	}

	public void setPopupRemark(String popupRemark) {
		this.popupRemark = popupRemark;
	}

	public boolean isDisablePopupSentSighDt() {
		return isDisablePopupSentSighDt;
	}

	public void setDisablePopupSentSighDt(boolean isDisablePopupSentSighDt) {
		this.isDisablePopupSentSighDt = isDisablePopupSentSighDt;
	}

	public boolean isDisablePopupSighDt() {
		return disablePopupSighDt;
	}

	public void setDisablePopupSighDt(boolean disablePopupSighDt) {
		this.disablePopupSighDt = disablePopupSighDt;
	}

	public boolean isDisablePopupSentWarrantDt() {
		return disablePopupSentWarrantDt;
	}

	public void setDisablePopupSentWarrantDt(boolean disablePopupSentWarrantDt) {
		this.disablePopupSentWarrantDt = disablePopupSentWarrantDt;
	}

	public boolean isDisablePopupSentContractDt() {
		return disablePopupSentContractDt;
	}

	public void setDisablePopupSentContractDt(boolean disablePopupSentContractDt) {
		this.disablePopupSentContractDt = disablePopupSentContractDt;
	}

	public boolean isDisablePopupSentSamuserDt() {
		return disablePopupSentSamuserDt;
	}

	public void setDisablePopupSentSamuserDt(boolean disablePopupSentSamuserDt) {
		this.disablePopupSentSamuserDt = disablePopupSentSamuserDt;
	}

	public boolean isDisplayPopupUpdateStatus() {
		return displayPopupUpdateStatus;
	}

	public void setDisplayPopupUpdateStatus(boolean displayPopupUpdateStatus) {
		this.displayPopupUpdateStatus = displayPopupUpdateStatus;
	}

	public Date getCompleateDtFrom() {
		return compleateDtFrom;
	}

	public void setCompleateDtFrom(Date compleateDtFrom) {
		this.compleateDtFrom = compleateDtFrom;
	}

	public Date getCompleateDtTo() {
		return compleateDtTo;
	}

	public void setCompleateDtTo(Date compleateDtTo) {
		this.compleateDtTo = compleateDtTo;
	}

	public Date getExportDtFrom() {
		return exportDtFrom;
	}

	public void setExportDtFrom(Date exportDtFrom) {
		this.exportDtFrom = exportDtFrom;
	}

	public Date getExportDtTo() {
		return exportDtTo;
	}

	public void setExportDtTo(Date exportDtTo) {
		this.exportDtTo = exportDtTo;
	}

	public boolean isDisabledBtnImport() {
		return disabledBtnImport;
	}

	public void setDisabledBtnImport(boolean disabledBtnImport) {
		this.disabledBtnImport = disabledBtnImport;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getStatusAction() {
		return statusAction;
	}

	public void setStatusAction(String statusAction) {
		this.statusAction = statusAction;
	}

	public Date getUploadFileDtTo() {
		return uploadFileDtTo;
	}

	public void setUploadFileDtTo(Date uploadFileDtTo) {
		this.uploadFileDtTo = uploadFileDtTo;
	}

	public Date getUploadFileDtFrom() {
		return uploadFileDtFrom;
	}

	public void setUploadFileDtFrom(Date uploadFileDtFrom) {
		this.uploadFileDtFrom = uploadFileDtFrom;
	}

	public List<SelectItem> getReqTypeList() {
		return reqTypeList;
	}

	public void setReqTypeList(List<SelectItem> reqTypeList) {
		this.reqTypeList = reqTypeList;
	}

	public String getReqType() {
		return reqType;
	}

	public void setReqType(String reqType) {
		this.reqType = reqType;
	}

	public UploadPermissionFile getUploadPermissionFile() {
		return uploadPermissionFile;
	}

	public void setUploadPermissionFile(UploadPermissionFile uploadPermissionFile) {
		this.uploadPermissionFile = uploadPermissionFile;
	}

	public boolean isDisplayShowPopup() {
		return displayShowPopup;
	}

	public void setDisplayShowPopup(boolean displayShowPopup) {
		this.displayShowPopup = displayShowPopup;
	}

	public boolean isDisabledBtnPopupEdit() {
		return disabledBtnPopupEdit;
	}

	public void setDisabledBtnPopupEdit(boolean disabledBtnPopupEdit) {
		this.disabledBtnPopupEdit = disabledBtnPopupEdit;
	}

	public boolean isRenderedMsgFormPopup() {
		return renderedMsgFormPopup;
	}

	public void setRenderedMsgFormPopup(boolean renderedMsgFormPopup) {
		this.renderedMsgFormPopup = renderedMsgFormPopup;
	}

	public String getAreaCodeElectric() {
		return areaCodeElectric;
	}

	public void setAreaCodeElectric(String areaCodeElectric) {
		this.areaCodeElectric = areaCodeElectric;
	}

	public String getAreaElectric() {
		return areaElectric;
	}

	public void setAreaElectric(String areaElectric) {
		this.areaElectric = areaElectric;
	}

	public String getMemberWithArea() {
		return memberWithArea;
	}

	public void setMemberWithArea(String memberWithArea) {
		this.memberWithArea = memberWithArea;
	}

	public String getNumberMeter() {
		return numberMeter;
	}

	public void setNumberMeter(String numberMeter) {
		this.numberMeter = numberMeter;
	}

	public String getMeterType() {
		return meterType;
	}

	public void setMeterType(String meterType) {
		this.meterType = meterType;
	}

	public String getMeterSize() {
		return meterSize;
	}

	public void setMeterSize(String meterSize) {
		this.meterSize = meterSize;
	}

	public String getRateOfElectric() {
		return rateOfElectric;
	}

	public void setRateOfElectric(String rateOfElectric) {
		this.rateOfElectric = rateOfElectric;
	}

	public Date getElActiveDt() {
		return elActiveDt;
	}

	public void setElActiveDt(Date elActiveDt) {
		this.elActiveDt = elActiveDt;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getElTransformersBrand() {
		return elTransformersBrand;
	}

	public void setElTransformersBrand(String elTransformersBrand) {
		this.elTransformersBrand = elTransformersBrand;
	}

	public String getElLevel() {
		return elLevel;
	}

	public void setElLevel(String elLevel) {
		this.elLevel = elLevel;
	}

	public String getElTransformersNumber() {
		return elTransformersNumber;
	}

	public void setElTransformersNumber(String elTransformersNumber) {
		this.elTransformersNumber = elTransformersNumber;
	}

	public String getElTransformersSize() {
		return elTransformersSize;
	}

	public void setElTransformersSize(String elTransformersSize) {
		this.elTransformersSize = elTransformersSize;
	}

	public Date getElTransformersInstallDt() {
		return elTransformersInstallDt;
	}

	public void setElTransformersInstallDt(Date elTransformersInstallDt) {
		this.elTransformersInstallDt = elTransformersInstallDt;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<ElectricPermissionUploadFile> getUploadFileList() {
		return uploadFileList;
	}

	public void setUploadFileList(List<ElectricPermissionUploadFile> uploadFileList) {
		this.uploadFileList = uploadFileList;
	}

	public List<SelectItem> getTypeUseElectricList() {
		return typeUseElectricList;
	}

	public void setTypeUseElectricList(List<SelectItem> typeUseElectricList) {
		this.typeUseElectricList = typeUseElectricList;
	}

	public String getTypeUseElectric() {
		return typeUseElectric;
	}

	public void setTypeUseElectric(String typeUseElectric) {
		this.typeUseElectric = typeUseElectric;
	}

	public List<ElectricPermissionWarrant> getPermissionWarrantForShow() {
		return permissionWarrantForShow;
	}

	public void setPermissionWarrantForShow(List<ElectricPermissionWarrant> permissionWarrantForShow) {
		this.permissionWarrantForShow = permissionWarrantForShow;
	}

	public List<UploadElPermistionWarrant> getUploadElPerList() {
		return uploadElPerList;
	}

	public void setUploadElPerList(List<UploadElPermistionWarrant> uploadElPerList) {
		this.uploadElPerList = uploadElPerList;
	}

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public UploadElPermistionWarrant getPermistionWarrant() {
		return permistionWarrant;
	}

	public void setPermistionWarrant(UploadElPermistionWarrant permistionWarrant) {
		this.permistionWarrant = permistionWarrant;
	}

	public List<UploadElPermistionWarrant> getUploadElPerListForPopup() {
		return uploadElPerListForPopup;
	}

	public void setUploadElPerListForPopup(
			List<UploadElPermistionWarrant> uploadElPerListForPopup) {
		this.uploadElPerListForPopup = uploadElPerListForPopup;
	}

	public boolean isRenderedSelectFile() {
		return renderedSelectFile;
	}

	public void setRenderedSelectFile(boolean renderedSelectFile) {
		this.renderedSelectFile = renderedSelectFile;
	}

	public boolean isRenderedExportErrorButton() {
		return renderedExportErrorButton;
	}

	public void setRenderedExportErrorButton(boolean renderedExportErrorButton) {
		this.renderedExportErrorButton = renderedExportErrorButton;
	}

	public String getUploadFileErrorCode() {
		return uploadFileErrorCode;
	}

	public void setUploadFileErrorCode(String uploadFileErrorCode) {
		this.uploadFileErrorCode = uploadFileErrorCode;
	}

	public String getErrorThisPage() {
		return errorThisPage;
	}

	public void setErrorThisPage(String errorThisPage) {
		this.errorThisPage = errorThisPage;
	}

	public boolean isRenderedSavePage1Button() {
		return renderedSavePage1Button;
	}

	public void setRenderedSavePage1Button(boolean renderedSavePage1Button) {
		this.renderedSavePage1Button = renderedSavePage1Button;
	}

	public boolean isRenderedSavePage3Button() {
		return renderedSavePage3Button;
	}

	public void setRenderedSavePage3Button(boolean renderedSavePage3Button) {
		this.renderedSavePage3Button = renderedSavePage3Button;
	}

	public String getProcessStatusCode() {
		return processStatusCode;
	}

	public void setProcessStatusCode(String processStatusCode) {
		this.processStatusCode = processStatusCode;
	}

	public List<SelectItem> getProcessStatusNameList() {
		return processStatusNameList;
	}

	public void setProcessStatusNameList(List<SelectItem> processStatusNameList) {
		this.processStatusNameList = processStatusNameList;
	}

	public String getFailUpload() {
		return failUpload;
	}

	public void setFailUpload(String failUpload) {
		this.failUpload = failUpload;
	}

	public String getStatusForDelete() {
		return statusForDelete;
	}

	public void setStatusForDelete(String statusForDelete) {
		this.statusForDelete = statusForDelete;
	}

	public String getCompanyPage2() {
		return companyPage2;
	}

	public void setCompanyPage2(String companyPage2) {
		this.companyPage2 = companyPage2;
	}

	public String getElectricUseTypePage2() {
		return electricUseTypePage2;
	}

	public void setElectricUseTypePage2(String electricUseTypePage2) {
		this.electricUseTypePage2 = electricUseTypePage2;
	}

	public String getProcessStatusCodePage2() {
		return processStatusCodePage2;
	}

	public void setProcessStatusCodePage2(String processStatusCodePage2) {
		this.processStatusCodePage2 = processStatusCodePage2;
	}

	public List<SelectItem> getProcessStatusNameListPage2() {
		return processStatusNameListPage2;
	}

	public void setProcessStatusNameListPage2(
			List<SelectItem> processStatusNameListPage2) {
		this.processStatusNameListPage2 = processStatusNameListPage2;
	}

	public List<SelectItem> getTypeUseElectricListPage2() {
		return typeUseElectricListPage2;
	}

	public void setTypeUseElectricListPage2(
			List<SelectItem> typeUseElectricListPage2) {
		this.typeUseElectricListPage2 = typeUseElectricListPage2;
	}

	public String getTypeUseElectricPage2() {
		return typeUseElectricPage2;
	}

	public void setTypeUseElectricPage2(String typeUseElectricPage2) {
		this.typeUseElectricPage2 = typeUseElectricPage2;
	}

	public Date getUploadFileDtToPage2() {
		return uploadFileDtToPage2;
	}

	public void setUploadFileDtToPage2(Date uploadFileDtToPage2) {
		this.uploadFileDtToPage2 = uploadFileDtToPage2;
	}

	public Date getUploadFileDtFromPage2() {
		return uploadFileDtFromPage2;
	}

	public void setUploadFileDtFromPage2(Date uploadFileDtFromPage2) {
		this.uploadFileDtFromPage2 = uploadFileDtFromPage2;
	}

	public List<SelectItem> getCompanyListPage2() {
		return companyListPage2;
	}

	public void setCompanyListPage2(List<SelectItem> companyListPage2) {
		this.companyListPage2 = companyListPage2;
	}

	public List<SelectItem> getWarrantTypeListPage2() {
		return warrantTypeListPage2;
	}

	public void setWarrantTypeListPage2(List<SelectItem> warrantTypeListPage2) {
		this.warrantTypeListPage2 = warrantTypeListPage2;
	}

	public String getFileNamePage2() {
		return fileNamePage2;
	}

	public void setFileNamePage2(String fileNamePage2) {
		this.fileNamePage2 = fileNamePage2;
	}

	public List<SelectItem> getRegionListPage2() {
		return regionListPage2;
	}

	public void setRegionListPage2(List<SelectItem> regionListPage2) {
		this.regionListPage2 = regionListPage2;
	}

	public List<SelectItem> getWarrantStatusListPage2() {
		return warrantStatusListPage2;
	}

	public void setWarrantStatusListPage2(List<SelectItem> warrantStatusListPage2) {
		this.warrantStatusListPage2 = warrantStatusListPage2;
	}

	public List<SelectItem> getReqTypeListPage2() {
		return reqTypeListPage2;
	}

	public void setReqTypeListPage2(List<SelectItem> reqTypeListPage2) {
		this.reqTypeListPage2 = reqTypeListPage2;
	}

	public String getReqTypePage2() {
		return reqTypePage2;
	}

	public void setReqTypePage2(String reqTypePage2) {
		this.reqTypePage2 = reqTypePage2;
	}

	public boolean isRenderedMsgDataNotFoundFirstPage() {
		return renderedMsgDataNotFoundFirstPage;
	}

	public void setRenderedMsgDataNotFoundFirstPage(
			boolean renderedMsgDataNotFoundFirstPage) {
		this.renderedMsgDataNotFoundFirstPage = renderedMsgDataNotFoundFirstPage;
	}

	public String getMsgDataNotFoundFirstPage() {
		return msgDataNotFoundFirstPage;
	}

	public void setMsgDataNotFoundFirstPage(String msgDataNotFoundFirstPage) {
		this.msgDataNotFoundFirstPage = msgDataNotFoundFirstPage;
	}

	public boolean isRenderedMsgDataNotFoundSecondPage() {
		return renderedMsgDataNotFoundSecondPage;
	}

	public void setRenderedMsgDataNotFoundSecondPage(
			boolean renderedMsgDataNotFoundSecondPage) {
		this.renderedMsgDataNotFoundSecondPage = renderedMsgDataNotFoundSecondPage;
	}

	public String getMsgDataNotFoundSecondPage() {
		return msgDataNotFoundSecondPage;
	}

	public void setMsgDataNotFoundSecondPage(String msgDataNotFoundSecondPage) {
		this.msgDataNotFoundSecondPage = msgDataNotFoundSecondPage;
	}

	public boolean isRenderedBackButtonToPage1() {
		return renderedBackButtonToPage1;
	}

	public void setRenderedBackButtonToPage1(boolean renderedBackButtonToPage1) {
		this.renderedBackButtonToPage1 = renderedBackButtonToPage1;
	}

	public boolean isRenderedBackButtonToPage2() {
		return renderedBackButtonToPage2;
	}

	public void setRenderedBackButtonToPage2(boolean renderedBackButtonToPage2) {
		this.renderedBackButtonToPage2 = renderedBackButtonToPage2;
	}

	public String getLogIdFordelete() {
		return logIdFordelete;
	}

	public void setLogIdFordelete(String logIdFordelete) {
		this.logIdFordelete = logIdFordelete;
	}

	public String getRowIdFordelete() {
		return rowIdFordelete;
	}

	public void setRowIdFordelete(String rowIdFordelete) {
		this.rowIdFordelete = rowIdFordelete;
	}


	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	
	
	
}
