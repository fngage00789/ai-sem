package th.co.ais.web.cp.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import com.sun.org.apache.bcel.internal.generic.NEW;

import th.co.ais.domain.cp.FirstPageProxyConstructionPermissionUploadFile;
import th.co.ais.domain.cp.MCP002ReportParam;
import th.co.ais.domain.cp.ProxyConStructionUploadElPermistionWarrant;
import th.co.ais.domain.cp.ProxyConstructionPermissionUploadFile;
import th.co.ais.domain.cp.ConstructionPermissionWarrant;
import th.co.ais.domain.cp.ProxyConstructionUploadPermissionFile;
import th.co.ais.domain.el.ProxyElectricPermissionUploadFile;
import th.co.ais.domain.el.ProxyUploadElPermistionWarrant;
import th.co.ais.domain.el.ProxyUploadPermissionFile;
import th.co.ais.domain.el.UploadMeter;
import th.co.ais.domain.el.UploadMeterFile;
import th.co.ais.domain.el.WarrantDetailSP;
import th.co.ais.domain.gm.Zone;
import th.co.ais.web.bean.AbstractBean;
import th.co.ais.web.report.AbstractReportBean;

public class SEMMCP002Bean  extends AbstractReportBean implements Serializable {

	private static final long serialVersionUID = 3061355227034982739L;
	private UploadMeterFile uploadMeterFile = new UploadMeterFile();
	private String uploadMeterId;
	private List<UploadMeter> uploadMeterSuccessList = new ArrayList<UploadMeter>();
	private List<UploadMeter> uploadMeterELMTR01List = new ArrayList<UploadMeter>();
	private List<UploadMeter> uploadMeterELMTR02List = new ArrayList<UploadMeter>();
	private List<UploadMeter> uploadMeterELMTR03List = new ArrayList<UploadMeter>();
	private List<UploadMeter> uploadMeterELMTR04List = new ArrayList<UploadMeter>();
	private List<UploadMeter> uploadMeterELMTR05List = new ArrayList<UploadMeter>();
	private List<UploadMeter> uploadMeterELMTR06List = new ArrayList<UploadMeter>();
	private List<UploadMeter> uploadMeterELMTR07List = new ArrayList<UploadMeter>();	
	private List<UploadMeter> uploadMeterELMTR08List = new ArrayList<UploadMeter>();
	
	private boolean renderedExportErrorButton = false;
	private boolean renderedSelectFile = false;
	private boolean renderedMsgDataNotFoundFirstPage = false;
	private String msgDataNotFoundFirstPage;
	private boolean renderedMsgDataNotFoundSecondPage = false;
	private String msgDataNotFoundSecondPage;
	private List<SelectItem> amphurList;
	private List<SelectItem> typeAttennaList;
	private boolean disabledBtnImport = false;
	private boolean displayShowPopup;
	private boolean disabledBtnPopupEdit;
	private String region;
	private String province;
	private String company;
	private List<SelectItem> companyList;
	private List<SelectItem> provinceList;
	private List<SelectItem> regionList;
	private List<SelectItem> typeUseElectricList;
	private List<SelectItem> reqTypeList;
	private String typeUseElectric;
	private String fileName;
	private String reqType;
	private Date uploadFileDtFrom;
	private Date uploadFileDtTo;
	//Render message form Popup
	private boolean renderedMsgFormPopup = true;
	//popupEdit
	private String areaName;
	private String address;
	private String tumbon;
	private String amphur;
	private String city;
	private String provincePopup;
	private String supplier;
	private String remark;
	private String antennaType;
	private String antennaHight;
	private String department;
	private List<SelectItem> zoneList;
	private List<Zone> allZoneList;
	private List<ConstructionPermissionWarrant> warrantList = new ArrayList<ConstructionPermissionWarrant>();
	private String flagPrint;
	private String logId;
	
	private ProxyConstructionUploadPermissionFile uploadPermissionFile = new ProxyConstructionUploadPermissionFile();
	private List<ProxyConstructionPermissionUploadFile> uploadFileList = new ArrayList<ProxyConstructionPermissionUploadFile>(); 
	private List<ProxyConStructionUploadElPermistionWarrant> uploadElPerList = new ArrayList<ProxyConStructionUploadElPermistionWarrant>();
	private ProxyConStructionUploadElPermistionWarrant permistionWarrant = new ProxyConStructionUploadElPermistionWarrant();
	private List<ProxyConStructionUploadElPermistionWarrant> uploadElPerListForPopup = new ArrayList<ProxyConStructionUploadElPermistionWarrant>();
	
	private List<FirstPageProxyConstructionPermissionUploadFile> uploadFileListForFirstPage = new ArrayList<FirstPageProxyConstructionPermissionUploadFile>(); 
	
	private boolean showReport = false;
	private MCP002ReportParam mcp002ReportParam = new MCP002ReportParam();
	
	private List<MCP002ReportParam> mcp002ReportParamList = new ArrayList<MCP002ReportParam>();
	private String contractNo;
	private String siteName;
	private String locationId;
	private String locationCode;
	private String subCon;
	private String subConCode;
	private List<WarrantDetailSP> warrantDetailSPList;
	private boolean disabledBtnExport = true;
	private boolean disabledBtnUpdateStatusWarrant = true;
	private boolean chkSelAll;
	
	private String uploadFileErrorCode;
	private String errorThisPage;
	
	private boolean renderedSavePage0Button = false;
	private boolean renderedSavePage2Button = false;
	private String failUpload; 
	private String statusForDelete;
	private String regionPage2;
	private String companyPage2;
	private List<SelectItem> companyListPage2;
	private List<SelectItem> regionListPage2;
	private Date uploadFileDtFromPage2;
	private Date uploadFileDtToPage2;
	private String fileNamePage2;
	
	private boolean renderedBackButtonToPage1 = false;
	private boolean renderedBackButtonToPage2 = false;
	private String logIdFordelete;
	private String rowIdFordelete;
	private List<SelectItem> statusPrintList;
	private String statusPrint;
	@Override
	public int getRowPerPage() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		// TODO Auto-generated method stub
		
	}

	public UploadMeterFile getUploadMeterFile() {
		return uploadMeterFile;
	}

	public void setUploadMeterFile(UploadMeterFile uploadMeterFile) {
		this.uploadMeterFile = uploadMeterFile;
	}

	public String getUploadMeterId() {
		return uploadMeterId;
	}

	public void setUploadMeterId(String uploadMeterId) {
		this.uploadMeterId = uploadMeterId;
	}

	public List<UploadMeter> getUploadMeterELMTR01List() {
		return uploadMeterELMTR01List;
	}

	public void setUploadMeterELMTR01List(List<UploadMeter> uploadMeterELMTR01List) {
		this.uploadMeterELMTR01List = uploadMeterELMTR01List;
	}

	public List<UploadMeter> getUploadMeterELMTR02List() {
		return uploadMeterELMTR02List;
	}

	public void setUploadMeterELMTR02List(List<UploadMeter> uploadMeterELMTR02List) {
		this.uploadMeterELMTR02List = uploadMeterELMTR02List;
	}

	public List<UploadMeter> getUploadMeterELMTR03List() {
		return uploadMeterELMTR03List;
	}

	public void setUploadMeterELMTR03List(List<UploadMeter> uploadMeterELMTR03List) {
		this.uploadMeterELMTR03List = uploadMeterELMTR03List;
	}

	public List<UploadMeter> getUploadMeterELMTR04List() {
		return uploadMeterELMTR04List;
	}

	public void setUploadMeterELMTR04List(List<UploadMeter> uploadMeterELMTR04List) {
		this.uploadMeterELMTR04List = uploadMeterELMTR04List;
	}

	public List<UploadMeter> getUploadMeterELMTR05List() {
		return uploadMeterELMTR05List;
	}

	public void setUploadMeterELMTR05List(List<UploadMeter> uploadMeterELMTR05List) {
		this.uploadMeterELMTR05List = uploadMeterELMTR05List;
	}

	public List<UploadMeter> getUploadMeterELMTR06List() {
		return uploadMeterELMTR06List;
	}

	public void setUploadMeterELMTR06List(List<UploadMeter> uploadMeterELMTR06List) {
		this.uploadMeterELMTR06List = uploadMeterELMTR06List;
	}

	public List<UploadMeter> getUploadMeterELMTR07List() {
		return uploadMeterELMTR07List;
	}

	public void setUploadMeterELMTR07List(List<UploadMeter> uploadMeterELMTR07List) {
		this.uploadMeterELMTR07List = uploadMeterELMTR07List;
	}

	public List<UploadMeter> getUploadMeterSuccessList() {
		return uploadMeterSuccessList;
	}

	public void setUploadMeterSuccessList(List<UploadMeter> uploadMeterSuccessList) {
		this.uploadMeterSuccessList = uploadMeterSuccessList;
	}

	public List<UploadMeter> getUploadMeterELMTR08List() {
		return uploadMeterELMTR08List;
	}

	public void setUploadMeterELMTR08List(List<UploadMeter> uploadMeterELMTR08List) {
		this.uploadMeterELMTR08List = uploadMeterELMTR08List;
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public List<SelectItem> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getUploadFileDtFrom() {
		return uploadFileDtFrom;
	}

	public void setUploadFileDtFrom(Date uploadFileDtFrom) {
		this.uploadFileDtFrom = uploadFileDtFrom;
	}

	public Date getUploadFileDtTo() {
		return uploadFileDtTo;
	}

	public void setUploadFileDtTo(Date uploadFileDtTo) {
		this.uploadFileDtTo = uploadFileDtTo;
	}

	public boolean isRenderedMsgFormPopup() {
		return renderedMsgFormPopup;
	}

	public void setRenderedMsgFormPopup(boolean renderedMsgFormPopup) {
		this.renderedMsgFormPopup = renderedMsgFormPopup;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTumbon() {
		return tumbon;
	}

	public void setTumbon(String tumbon) {
		this.tumbon = tumbon;
	}

	public String getAmphur() {
		return amphur;
	}

	public void setAmphur(String amphur) {
		this.amphur = amphur;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvincePopup() {
		return provincePopup;
	}

	public void setProvincePopup(String provincePopup) {
		this.provincePopup = provincePopup;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public boolean isDisabledBtnImport() {
		return disabledBtnImport;
	}

	public void setDisabledBtnImport(boolean disabledBtnImport) {
		this.disabledBtnImport = disabledBtnImport;
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

	public String getAntennaType() {
		return antennaType;
	}

	public void setAntennaType(String antennaType) {
		this.antennaType = antennaType;
	}

	public String getAntennaHight() {
		return antennaHight;
	}

	public void setAntennaHight(String antennaHight) {
		this.antennaHight = antennaHight;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<ConstructionPermissionWarrant> getWarrantList() {
		return warrantList;
	}

	public void setWarrantList(List<ConstructionPermissionWarrant> warrantList) {
		this.warrantList = warrantList;
	}

	public List<ProxyConstructionPermissionUploadFile> getUploadFileList() {
		return uploadFileList;
	}

	public void setUploadFileList(
			List<ProxyConstructionPermissionUploadFile> uploadFileList) {
		this.uploadFileList = uploadFileList;
	}

	public List<Zone> getAllZoneList() {
		return allZoneList;
	}

	public void setAllZoneList(List<Zone> allZoneList) {
		this.allZoneList = allZoneList;
	}

	public List<SelectItem> getZoneList() {
		return zoneList;
	}

	public void setZoneList(List<SelectItem> zoneList) {
		this.zoneList = zoneList;
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

	public boolean isRenderedExportErrorButton() {
		return renderedExportErrorButton;
	}

	public void setRenderedExportErrorButton(boolean renderedExportErrorButton) {
		this.renderedExportErrorButton = renderedExportErrorButton;
	}

	public boolean isRenderedSelectFile() {
		return renderedSelectFile;
	}

	public void setRenderedSelectFile(boolean renderedSelectFile) {
		this.renderedSelectFile = renderedSelectFile;
	}

	public List<SelectItem> getAmphurList() {
		return amphurList;
	}

	public void setAmphurList(List<SelectItem> amphurList) {
		this.amphurList = amphurList;
	}

	public ProxyConstructionUploadPermissionFile getUploadPermissionFile() {
		return uploadPermissionFile;
	}

	public void setUploadPermissionFile(
			ProxyConstructionUploadPermissionFile uploadPermissionFile) {
		this.uploadPermissionFile = uploadPermissionFile;
	}

	public List<ProxyConStructionUploadElPermistionWarrant> getUploadElPerList() {
		return uploadElPerList;
	}

	public void setUploadElPerList(
			List<ProxyConStructionUploadElPermistionWarrant> uploadElPerList) {
		this.uploadElPerList = uploadElPerList;
	}

	public ProxyConStructionUploadElPermistionWarrant getPermistionWarrant() {
		return permistionWarrant;
	}

	public void setPermistionWarrant(
			ProxyConStructionUploadElPermistionWarrant permistionWarrant) {
		this.permistionWarrant = permistionWarrant;
	}

	public List<ProxyConStructionUploadElPermistionWarrant> getUploadElPerListForPopup() {
		return uploadElPerListForPopup;
	}

	public void setUploadElPerListForPopup(
			List<ProxyConStructionUploadElPermistionWarrant> uploadElPerListForPopup) {
		this.uploadElPerListForPopup = uploadElPerListForPopup;
	}

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
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

	public List<WarrantDetailSP> getWarrantDetailSPList() {
		return warrantDetailSPList;
	}

	public void setWarrantDetailSPList(List<WarrantDetailSP> warrantDetailSPList) {
		this.warrantDetailSPList = warrantDetailSPList;
	}

	public boolean isDisabledBtnExport() {
		return disabledBtnExport;
	}

	public void setDisabledBtnExport(boolean disabledBtnExport) {
		this.disabledBtnExport = disabledBtnExport;
	}

	public boolean isDisabledBtnUpdateStatusWarrant() {
		return disabledBtnUpdateStatusWarrant;
	}

	public void setDisabledBtnUpdateStatusWarrant(
			boolean disabledBtnUpdateStatusWarrant) {
		this.disabledBtnUpdateStatusWarrant = disabledBtnUpdateStatusWarrant;
	}

	public boolean isChkSelAll() {
		return chkSelAll;
	}

	public void setChkSelAll(boolean chkSelAll) {
		this.chkSelAll = chkSelAll;
	}

	public String getSubCon() {
		return subCon;
	}

	public void setSubCon(String subCon) {
		this.subCon = subCon;
	}

	public String getSubConCode() {
		return subConCode;
	}

	public void setSubConCode(String subConCode) {
		this.subConCode = subConCode;
	}

	public List<SelectItem> getTypeAttennaList() {
		return typeAttennaList;
	}

	public void setTypeAttennaList(List<SelectItem> typeAttennaList) {
		this.typeAttennaList = typeAttennaList;
	}

	public List<FirstPageProxyConstructionPermissionUploadFile> getUploadFileListForFirstPage() {
		return uploadFileListForFirstPage;
	}

	public void setUploadFileListForFirstPage(
			List<FirstPageProxyConstructionPermissionUploadFile> uploadFileListForFirstPage) {
		this.uploadFileListForFirstPage = uploadFileListForFirstPage;
	}

	public MCP002ReportParam getMcp002ReportParam() {
		return mcp002ReportParam;
	}

	public void setMcp002ReportParam(MCP002ReportParam mcp002ReportParam) {
		this.mcp002ReportParam = mcp002ReportParam;
	}

	public List<MCP002ReportParam> getMcp002ReportParamList() {
		return mcp002ReportParamList;
	}

	public void setMcp002ReportParamList(
			List<MCP002ReportParam> mcp002ReportParamList) {
		this.mcp002ReportParamList = mcp002ReportParamList;
	}

	public boolean isShowReport() {
		return showReport;
	}

	public void setShowReport(boolean showReport) {
		this.showReport = showReport;
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

	public boolean isRenderedSavePage0Button() {
		return renderedSavePage0Button;
	}

	public void setRenderedSavePage0Button(boolean renderedSavePage0Button) {
		this.renderedSavePage0Button = renderedSavePage0Button;
	}

	public boolean isRenderedSavePage2Button() {
		return renderedSavePage2Button;
	}

	public void setRenderedSavePage2Button(boolean renderedSavePage2Button) {
		this.renderedSavePage2Button = renderedSavePage2Button;
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

	public String getRegionPage2() {
		return regionPage2;
	}

	public void setRegionPage2(String regionPage2) {
		this.regionPage2 = regionPage2;
	}

	public String getCompanyPage2() {
		return companyPage2;
	}

	public void setCompanyPage2(String companyPage2) {
		this.companyPage2 = companyPage2;
	}

	public List<SelectItem> getCompanyListPage2() {
		return companyListPage2;
	}

	public void setCompanyListPage2(List<SelectItem> companyListPage2) {
		this.companyListPage2 = companyListPage2;
	}

	public List<SelectItem> getRegionListPage2() {
		return regionListPage2;
	}

	public void setRegionListPage2(List<SelectItem> regionListPage2) {
		this.regionListPage2 = regionListPage2;
	}

	public Date getUploadFileDtFromPage2() {
		return uploadFileDtFromPage2;
	}

	public void setUploadFileDtFromPage2(Date uploadFileDtFromPage2) {
		this.uploadFileDtFromPage2 = uploadFileDtFromPage2;
	}

	public Date getUploadFileDtToPage2() {
		return uploadFileDtToPage2;
	}

	public void setUploadFileDtToPage2(Date uploadFileDtToPage2) {
		this.uploadFileDtToPage2 = uploadFileDtToPage2;
	}

	public String getFileNamePage2() {
		return fileNamePage2;
	}

	public void setFileNamePage2(String fileNamePage2) {
		this.fileNamePage2 = fileNamePage2;
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

	public String getFlagPrint() {
		return flagPrint;
	}

	public void setFlagPrint(String flagPrint) {
		this.flagPrint = flagPrint;
	}

	public List<SelectItem> getStatusPrintList() {
		return statusPrintList;
	}

	public void setStatusPrintList(List<SelectItem> statusPrintList) {
		this.statusPrintList = statusPrintList;
	}

	public String getStatusPrint() {
		return statusPrint;
	}

	public void setStatusPrint(String statusPrint) {
		this.statusPrint = statusPrint;
	}
	
}
