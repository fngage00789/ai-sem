package th.co.ais.web.el.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.el.FirstPageProxyPermissionUploadFile;
import th.co.ais.domain.el.FirstPageUploadMeterUploadFile;
import th.co.ais.domain.el.MeterElectricPermissionUploadFile;
import th.co.ais.domain.el.MeterUploadPermissionFile;
import th.co.ais.domain.el.ProxyElectricPermissionUploadFile;
import th.co.ais.domain.el.ProxyUploadElPermistionWarrant;
import th.co.ais.domain.el.UploadElPermistionWarrant;
import th.co.ais.domain.el.UploadMeter;
import th.co.ais.domain.el.UploadMeterFile;
import th.co.ais.domain.el.UploadMeterPermistionWarrant;
import th.co.ais.domain.el.WarrantDetailSP;
import th.co.ais.web.bean.AbstractBean;

public class SEMMEL003Bean  extends AbstractBean implements Serializable {

	private static final long serialVersionUID = 4410965581677181365L;
	
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
	private List<UploadMeter> uploadMeterELMTR09List = new ArrayList<UploadMeter>();	
	private List<UploadMeter> uploadMeterELMTR10List = new ArrayList<UploadMeter>();
	
	private boolean disabledBtnImport = false;
	private boolean displayShowPopup;
	private boolean disabledBtnPopupEdit;
	private boolean renderedPnlUploadFile = true;
	private MeterUploadPermissionFile uploadPermissionFile = new MeterUploadPermissionFile();
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
	private String statusAction;
	private Date uploadFileDt;
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
	
	
	//Add by oum 2016
	private Date uploadFileDtTo;
	private Date uploadFileDtFrom;
	private String reqType;
	private String contractNo;
	private String siteName;
	private String siteCode;
	private String locationId;
	private String locationCode;
	private List<MeterElectricPermissionUploadFile> uploadFileList = new ArrayList<MeterElectricPermissionUploadFile>(); 
	private List<FirstPageUploadMeterUploadFile> uploadFileListForFirstPage = new ArrayList<FirstPageUploadMeterUploadFile>();
	private List<UploadMeterPermistionWarrant> uploadElPerList = new ArrayList<UploadMeterPermistionWarrant>();
	private UploadMeterPermistionWarrant permistionWarrant = new UploadMeterPermistionWarrant();
	private boolean renderedExportErrorButton = false;
	private boolean renderedExportAllButton = false;
	private boolean renderedExportSuccessButton = false;
	private boolean renderedSelectFile = false;
	private List<WarrantDetailSP> warrantDetailSPList;
	private boolean disabledBtnExport = true;
	private boolean disabledBtnUpdateStatusWarrant = true;
	private List<SelectItem> amphurList;
	private boolean chkSelAll;
	private String logId;
	private String uploadFileErrorCode;
	private String errorThisPage;
	private String meterId;
	private String processStatusCode;
	private List<SelectItem> processStatusNameList;
	private String failUpload;
	private boolean renderedSavePage1Button = false;
	private boolean renderedSavePage3Button = false;
	private String statusForDelete;
	private List<SelectItem> elMeterTypeList;
	private String supplier;
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
	private String batchNo;
	private String logIdFordelete;
	private String rowIdFordelete;
	
	private String status;
	private boolean displayBtn = false;
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

	public Date getUploadFileDt() {
		return uploadFileDt;
	}

	public void setUploadFileDt(Date uploadFileDt) {
		this.uploadFileDt = uploadFileDt;
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

	public boolean isRenderedMsgFormPopup() {
		return renderedMsgFormPopup;
	}

	public void setRenderedMsgFormPopup(boolean renderedMsgFormPopup) {
		this.renderedMsgFormPopup = renderedMsgFormPopup;
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

	public MeterUploadPermissionFile getUploadPermissionFile() {
		return uploadPermissionFile;
	}

	public void setUploadPermissionFile(MeterUploadPermissionFile uploadPermissionFile) {
		this.uploadPermissionFile = uploadPermissionFile;
	}

	public List<SelectItem> getReqTypeList() {
		return reqTypeList;
	}

	public void setReqTypeList(List<SelectItem> reqTypeList) {
		this.reqTypeList = reqTypeList;
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

	public List<MeterElectricPermissionUploadFile> getUploadFileList() {
		return uploadFileList;
	}

	public void setUploadFileList(
			List<MeterElectricPermissionUploadFile> uploadFileList) {
		this.uploadFileList = uploadFileList;
	}

	public String getReqType() {
		return reqType;
	}

	public void setReqType(String reqType) {
		this.reqType = reqType;
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

	public List<SelectItem> getAmphurList() {
		return amphurList;
	}

	public void setAmphurList(List<SelectItem> amphurList) {
		this.amphurList = amphurList;
	}

	public boolean isChkSelAll() {
		return chkSelAll;
	}

	public void setChkSelAll(boolean chkSelAll) {
		this.chkSelAll = chkSelAll;
	}

	public List<FirstPageUploadMeterUploadFile> getUploadFileListForFirstPage() {
		return uploadFileListForFirstPage;
	}

	public void setUploadFileListForFirstPage(
			List<FirstPageUploadMeterUploadFile> uploadFileListForFirstPage) {
		this.uploadFileListForFirstPage = uploadFileListForFirstPage;
	}

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public List<UploadMeterPermistionWarrant> getUploadElPerList() {
		return uploadElPerList;
	}

	public void setUploadElPerList(List<UploadMeterPermistionWarrant> uploadElPerList) {
		this.uploadElPerList = uploadElPerList;
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

	public String getMeterId() {
		return meterId;
	}

	public void setMeterId(String meterId) {
		this.meterId = meterId;
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

	public UploadMeterPermistionWarrant getPermistionWarrant() {
		return permistionWarrant;
	}

	public void setPermistionWarrant(UploadMeterPermistionWarrant permistionWarrant) {
		this.permistionWarrant = permistionWarrant;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public List<SelectItem> getElMeterTypeList() {
		return elMeterTypeList;
	}

	public void setElMeterTypeList(List<SelectItem> elMeterTypeList) {
		this.elMeterTypeList = elMeterTypeList;
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

	public String getRegionPage2() {
		return regionPage2;
	}

	public void setRegionPage2(String regionPage2) {
		this.regionPage2 = regionPage2;
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

	public boolean isRenderedPnlUploadFile() {
		return renderedPnlUploadFile;
	}

	public void setRenderedPnlUploadFile(boolean renderedPnlUploadFile) {
		this.renderedPnlUploadFile = renderedPnlUploadFile;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	
	public boolean isRenderedExportAllButton() {
		return renderedExportAllButton;
	}

	public void setRenderedExportAllButton(boolean renderedExportAllButton) {
		this.renderedExportAllButton = renderedExportAllButton;
	}

	public boolean isRenderedExportSuccessButton() {
		return renderedExportSuccessButton;
	}

	public void setRenderedExportSuccessButton(boolean renderedExportSuccessButton) {
		this.renderedExportSuccessButton = renderedExportSuccessButton;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isDisplayBtn() {
		return displayBtn;
	}

	public void setDisplayBtn(boolean displayBtn) {
		this.displayBtn = displayBtn;
	}

	public List<UploadMeter> getUploadMeterELMTR09List() {
		return uploadMeterELMTR09List;
	}

	public void setUploadMeterELMTR09List(List<UploadMeter> uploadMeterELMTR09List) {
		this.uploadMeterELMTR09List = uploadMeterELMTR09List;
	}

	public List<UploadMeter> getUploadMeterELMTR10List() {
		return uploadMeterELMTR10List;
	}

	public void setUploadMeterELMTR10List(List<UploadMeter> uploadMeterELMTR10List) {
		this.uploadMeterELMTR10List = uploadMeterELMTR10List;
	}

	
	
	
}
