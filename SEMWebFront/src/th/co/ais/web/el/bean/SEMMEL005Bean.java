package th.co.ais.web.el.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import org.richfaces.model.UploadItem;

import th.co.ais.domain.el.BgMasterFile;
import th.co.ais.domain.el.ElectricFTRateSearch;
import th.co.ais.domain.el.ImportDataLog;
import th.co.ais.domain.el.ImportTransaction;
import th.co.ais.domain.el.ManagementWrapper;
import th.co.ais.domain.el.Payment;
import th.co.ais.domain.el.PaymentHistSP;
import th.co.ais.domain.el.UploadText;
import th.co.ais.domain.el.UploadTextSP;
import th.co.ais.domain.ir.MEL005ExportMeterSP;
import th.co.ais.domain.ir.MEL005FailListSP;
import th.co.ais.domain.ir.MEL005FailSrchSP;
import th.co.ais.web.bean.AbstractBean;

public class SEMMEL005Bean extends AbstractBean implements Serializable {

	private static final long serialVersionUID = 2611248593751164974L;
	
	private List<SelectItem> companyList;
	private List<SelectItem> electricUseTypeList;
	private List<SelectItem> fileTypeList;
	private List<SelectItem> processStatusList;	
	private Date processDt;
	private String fileName;
	private String pathName;
	private String refDocId;	
	private String company;
	private String electricUseType;
	private String fileType;
	private String processStatus;
	private Date uploadDtFrom;
	private Date uploadDtTo;
	private Date processDtFrom;
	private Date processDtTo;
	private List<ImportTransaction> importTransactionList;
	private ImportTransaction importTransaction;
	
	private List<SelectItem> regionList;
	private List<SelectItem> paidFlagList;
	private List<SelectItem> errorCodeList;
	private String region;
	private String paidFlag;
	private String invNo;
	private String meterId;
	private String errorCode;
	private List<UploadText> uploadTextList;
	private List<UploadText> uploadTextSuccessPaidList;
	private List<UploadText> uploadTextSuccessNoPaidList;
	private String headerResultSuccessPaid;
	private String headerResultSuccessNoPaid;
	private boolean showResultSuccessPaid = false;
	private boolean showResultSuccessNoPaid = false;
	
	private String headerResultFailed;
	private List<UploadText> uploadTextELPAY01List;
	private List<UploadText> uploadTextELPAY02List;
	private List<UploadText> uploadTextELPAY03List;
	private List<UploadText> uploadTextELPAY04List;
	private List<UploadText> uploadTextELPAY05List;
	private List<UploadText> uploadTextELPAY06List;
	private List<UploadText> uploadTextELPAY07List;
	private List<UploadText> uploadTextELPAY08List;
	private List<UploadText> uploadTextELPAY11List;
	private List<UploadText> uploadTextELPAY12List;
	private List<UploadText> uploadTextELPAY13List;
	private List<UploadText> uploadTextELPAY14List;
	private List<UploadText> uploadTextELPAY15List;
	private List<UploadText> uploadTextELPAY16List;
	private List<UploadText> uploadTextELPAY17List;
	private List<UploadText> uploadTextELPAY18List;
	//-------------------------------------------------
	private List<UploadText> uploadTextELPAY001List;
	private List<UploadText> uploadTextELPAY002List;
	private List<UploadText> uploadTextELPAY081List;
	private List<UploadText> uploadTextELPAY082List;
	
	
	private UploadText uploadText;
	private List<UploadText> uploadTextErrorList;
	private List<UploadText> uploadTextSuccessList;
	private List<UploadItem> uploadFileList;
	private List<BgMasterFile> bgMasterFileList;
	
	private boolean meterTypeFlag;
	private boolean todtouFlag;
	private boolean kwhFlag;
	private boolean dataFlag;
	private String selectedRowIndex;
	private boolean companyFlag;//WT###Add 20110530
	
	private List<ImportDataLog> importDataLogList;
	private Payment payment;
	
	private String fileTypeDesc;
	private String paymentStatus;
	
	private Date docDTFrom;
	private Date docDTTo;
	//WT###Add 20110221 Start
	private boolean isDefineBackPage;
	private String methodWithNaviFrom;	
	//WT###Add 20110221 End	
	//WT###Add 20110222 Start
	private String methodB4Refresh;
	private String methodToRefresh;
	private boolean isDefineRefreshMethod;
	//WT###Add 20110222 End
	private boolean serviceFlag;
	//WT###Add 20110308 Start
	private int elPay00Size;
	private int elPay00PaidSize;
	private int elPay00NoPaidSize;
	private int elPay01Size;
	private int elPay01PaidSize;
	private int elPay01NoPaidSize;
	private int elPay02Size;
	private int elPay02PaidSize;
	private int elPay02NoPaidSize;
	private int elPay03Size;
	private int elPay03PaidSize;
	private int elPay03NoPaidSize;
	private int elPay04Size;
	private int elPay04PaidSize;
	private int elPay04NoPaidSize;
	private int elPay05Size;
	private int elPay05PaidSize;
	private int elPay05NoPaidSize;
	private int elPay06Size;
	private int elPay06PaidSize;
	private int elPay06NoPaidSize;
	private int elPay07Size;
	private int elPay07PaidSize;
	private int elPay07NoPaidSize;
	private int elPay08Size;
	private int elPay08PaidSize;
	private int elPay08NoPaidSize;
	private int elPay11Size;
	private int elPay11PaidSize;
	private int elPay11NoPaidSize;
	private int elPay12Size;
	private int elPay12PaidSize;
	private int elPay12NoPaidSize;
	private String rowIdRemove;
	private String confirmDeleteMsg;
	private boolean chkSelAll;
	private boolean disableCloseJobBtn;
	private boolean disableCloseJobValidateBtn;
	private String confirmCloseJobMsg;
	private String confirmCloseJobValidateMsg;
	//WT###Add 20110308 End
	private String clearingFlag;//WT###Add 20110323
	private boolean ctFlag;//WT###Add 20110331
	private String successPaidFlag;
	
	private String processAction;
	private boolean billPreriodFlag;
	private boolean oneBillPreriodFlag;
	private boolean showCloseJob = true;
	private String contractNo;
	private ElectricFTRateSearch ftRate;
	private List<ElectricFTRateSearch> ftRateList;
	private ElectricFTRateSearch updateFtRate;
	private boolean meterInfoDisplayFlag;
	private Date startDt;
	private Date endDt;
	private Date ftStartDt;
	private Date ftEndDt;
	private String ftRateType;
	private String actionType;
	private String ftRecordId;
	private String recordStatus;
	
	private UploadTextSP uploadTextSP;
	private List<UploadTextSP> uploadTextSPList;
	private List<UploadTextSP> uploadTextSPELPAY001List;
	private List<UploadTextSP> uploadTextSPELPAY002List;
	private List<UploadTextSP> uploadTextSPELPAY081List;
	private List<UploadTextSP> uploadTextSPELPAY082List;
	private List<UploadTextSP> uploadTextSPErrorList;
	private List<UploadTextSP> uploadTextSPSuccessList;
	private String elImportTranId;
	private String percentGrowth;
	private String month;
	private String type;
	private List<SelectItem> monthList;
	private List<SelectItem> typeList;
	private String fromPage;
	private boolean viewFlag = false;
	private String typeOfFile;
	private String fileProperty = "txt";

	private List<MEL005FailListSP> validateFailList;
	private List<MEL005FailSrchSP> validateFailNewList;
	private MEL005FailSrchSP validateFailNewSP;
	private MEL005FailSrchSP dataDetailSP;
	
	//added by NEW 2018/12/19
	private boolean periodFlag;
	private boolean contStatusInactiveFlag;
	private boolean networkStatusInactiveFlag;
	private boolean growthFlag;
	
	private boolean disableBtnExportMeter;
	private boolean disableBtnExportUptFormat;
	
	private boolean displayExportMeter;
	private boolean displayExportUptFormat; 
	private boolean displayExportReportUsage; 
	private boolean displayExportNewFormat; 
	private boolean displayExportPaymentHist; 
	
	private List<MEL005ExportMeterSP> exportMeterList;
	private String processIdTmp;
	
	private List<ManagementWrapper> paymentHistoryWrapperList = new ArrayList();
	private List<PaymentHistSP> paymentHistList;
	
	public Date getDocDTFrom() {
		return docDTFrom;
	}


	public void setDocDTFrom(Date docDTFrom) {
		this.docDTFrom = docDTFrom;
	}


	public Date getDocDTTo() {
		return docDTTo;
	}


	public void setDocDTTo(Date docDTTo) {
		this.docDTTo = docDTTo;
	}


	public String getFileTypeDesc() {
		return fileTypeDesc;
	}


	public void setFileTypeDesc(String fileTypeDesc) {
		this.fileTypeDesc = fileTypeDesc;
	}


	public String getPaymentStatus() {
		return paymentStatus;
	}


	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Payment getPayment() {
		return payment;
	}
	
	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public List<MEL005FailListSP> getValidateFailList() {
		return validateFailList;
	}


	public void setValidateFailList(List<MEL005FailListSP> validateFailList) {
		this.validateFailList = validateFailList;
	}


	public List<UploadText> getUploadTextSuccessList() {
		return uploadTextSuccessList;
	}


	@Override
	public int getRowPerPage() {
		
		return 10;
	}

	

	public List<SelectItem> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}

	public List<SelectItem> getElectricUseTypeList() {
		return electricUseTypeList;
	}

	public void setElectricUseTypeList(List<SelectItem> electricUseTypeList) {
		this.electricUseTypeList = electricUseTypeList;
	}

	

	public Date getProcessDt() {
		return processDt;
	}

	public void setProcessDt(Date processDt) {
		this.processDt = processDt;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getRefDocId() {
		return refDocId;
	}

	public void setRefDocId(String refDocId) {
		this.refDocId = refDocId;
	}

	public List<SelectItem> getFileTypeList() {
		return fileTypeList;
	}

	public void setFileTypeList(List<SelectItem> fileTypeList) {
		this.fileTypeList = fileTypeList;
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

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	public Date getUploadDtFrom() {
		return uploadDtFrom;
	}

	public void setUploadDtFrom(Date uploadDtFrom) {
		this.uploadDtFrom = uploadDtFrom;
	}

	public Date getUploadDtTo() {
		return uploadDtTo;
	}

	public void setUploadDtTo(Date uploadDtTo) {
		this.uploadDtTo = uploadDtTo;
	}

	public Date getProcessDtFrom() {
		return processDtFrom;
	}

	public void setProcessDtFrom(Date processDtFrom) {
		this.processDtFrom = processDtFrom;
	}

	public Date getProcessDtTo() {
		return processDtTo;
	}

	public void setProcessDtTo(Date processDtTo) {
		this.processDtTo = processDtTo;
	}

	public List<SelectItem> getProcessStatusList() {
		return processStatusList;
	}

	public void setProcessStatusList(List<SelectItem> processStatusList) {
		this.processStatusList = processStatusList;
	}

	public List<ImportTransaction> getImportTransactionList() {
		return importTransactionList;
	}

	public void setImportTransactionList(
			List<ImportTransaction> importTransactionList) {
		this.importTransactionList = importTransactionList;
	}

	public List<SelectItem> getRegionList() {
		return regionList;
	}

	public void setRegionList(List<SelectItem> regionList) {
		this.regionList = regionList;
	}

	public List<SelectItem> getPaidFlagList() {
		return paidFlagList;
	}

	public void setPaidFlagList(List<SelectItem> paidFlagList) {
		this.paidFlagList = paidFlagList;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPaidFlag() {
		return paidFlag;
	}

	public void setPaidFlag(String paidFlag) {
		this.paidFlag = paidFlag;
	}

	public String getInvNo() {
		return invNo;
	}

	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}

	public String getMeterId() {
		return meterId;
	}

	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}

	public ImportTransaction getImportTransaction() {
		return importTransaction;
	}

	public void setImportTransaction(ImportTransaction importTransaction) {
		this.importTransaction = importTransaction;
	}

	public List<SelectItem> getErrorCodeList() {
		return errorCodeList;
	}

	public void setErrorCodeList(List<SelectItem> errorCodeList) {
		this.errorCodeList = errorCodeList;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public List<UploadText> getUploadTextList() {
		return uploadTextList;
	}

	public void setUploadTextList(List<UploadText> uploadTextList) {
		this.uploadTextList = uploadTextList;
	}

	public String getHeaderResultSuccessPaid() {
		return headerResultSuccessPaid;
	}

	public void setHeaderResultSuccessPaid(String headerResultSuccessPaid) {
		this.headerResultSuccessPaid = headerResultSuccessPaid;
	}

	public String getHeaderResultSuccessNoPaid() {
		return headerResultSuccessNoPaid;
	}

	public void setHeaderResultSuccessNoPaid(String headerResultSuccessNoPaid) {
		this.headerResultSuccessNoPaid = headerResultSuccessNoPaid;
	}

	public List<UploadText> getUploadTextSuccessPaidList() {
		return uploadTextSuccessPaidList;
	}

	public void setUploadTextSuccessPaidList(
			List<UploadText> uploadTextSuccessPaidList) {
		this.uploadTextSuccessPaidList = uploadTextSuccessPaidList;
	}

	public List<UploadText> getUploadTextSuccessNoPaidList() {
		return uploadTextSuccessNoPaidList;
	}

	public void setUploadTextSuccessNoPaidList(
			List<UploadText> uploadTextSuccessNoPaidList) {
		this.uploadTextSuccessNoPaidList = uploadTextSuccessNoPaidList;
	}

	public boolean isShowResultSuccessPaid() {
		return showResultSuccessPaid;
	}

	public void setShowResultSuccessPaid(boolean showResultSuccessPaid) {
		this.showResultSuccessPaid = showResultSuccessPaid;
	}

	public boolean isShowResultSuccessNoPaid() {
		return showResultSuccessNoPaid;
	}

	public void setShowResultSuccessNoPaid(boolean showResultSuccessNoPaid) {
		this.showResultSuccessNoPaid = showResultSuccessNoPaid;
	}

	public List<UploadText> getUploadTextELPAY01List() {
		return uploadTextELPAY01List;
	}

	public void setUploadTextELPAY01List(List<UploadText> uploadTextELPAY01List) {
		this.uploadTextELPAY01List = uploadTextELPAY01List;
	}

	public List<UploadText> getUploadTextELPAY02List() {
		return uploadTextELPAY02List;
	}

	public void setUploadTextELPAY02List(List<UploadText> uploadTextELPAY02List) {
		this.uploadTextELPAY02List = uploadTextELPAY02List;
	}

	public List<UploadText> getUploadTextELPAY03List() {
		return uploadTextELPAY03List;
	}

	public void setUploadTextELPAY03List(List<UploadText> uploadTextELPAY03List) {
		this.uploadTextELPAY03List = uploadTextELPAY03List;
	}

	public List<UploadText> getUploadTextELPAY04List() {
		return uploadTextELPAY04List;
	}

	public void setUploadTextELPAY04List(List<UploadText> uploadTextELPAY04List) {
		this.uploadTextELPAY04List = uploadTextELPAY04List;
	}

	public List<UploadText> getUploadTextELPAY05List() {
		return uploadTextELPAY05List;
	}

	public void setUploadTextELPAY05List(List<UploadText> uploadTextELPAY05List) {
		this.uploadTextELPAY05List = uploadTextELPAY05List;
	}

	public List<UploadText> getUploadTextELPAY06List() {
		return uploadTextELPAY06List;
	}

	public void setUploadTextELPAY06List(List<UploadText> uploadTextELPAY06List) {
		this.uploadTextELPAY06List = uploadTextELPAY06List;
	}

	public List<UploadText> getUploadTextELPAY07List() {
		return uploadTextELPAY07List;
	}

	public void setUploadTextELPAY07List(List<UploadText> uploadTextELPAY07List) {
		this.uploadTextELPAY07List = uploadTextELPAY07List;
	}

	public List<UploadText> getUploadTextELPAY08List() {
		return uploadTextELPAY08List;
	}

	public void setUploadTextELPAY08List(List<UploadText> uploadTextELPAY08List) {
		this.uploadTextELPAY08List = uploadTextELPAY08List;
	}

	public String getHeaderResultFailed() {
		return headerResultFailed;
	}

	public void setHeaderResultFailed(String headerResultFailed) {
		this.headerResultFailed = headerResultFailed;
	}

	public UploadText getUploadText() {
		return uploadText;
	}

	public void setUploadText(UploadText uploadText) {
		this.uploadText = uploadText;
	}

	public List<UploadText> getUploadTextErrorList() {
		return uploadTextErrorList;
	}

	public void setUploadTextErrorList(List<UploadText> uploadTextErrorList) {
		this.uploadTextELPAY01List = new ArrayList<UploadText>();
		this.uploadTextELPAY02List = new ArrayList<UploadText>();
		this.uploadTextELPAY03List = new ArrayList<UploadText>();
		this.uploadTextELPAY04List = new ArrayList<UploadText>();
		this.uploadTextELPAY05List = new ArrayList<UploadText>();
		this.uploadTextELPAY06List = new ArrayList<UploadText>();
		this.uploadTextELPAY07List = new ArrayList<UploadText>();
		this.uploadTextELPAY08List = new ArrayList<UploadText>();
		this.uploadTextELPAY11List = new ArrayList<UploadText>();
		
		for(UploadText obj : uploadTextErrorList){
			if("ELPAY01".equals(obj.getErrorCode())){
				this.uploadTextELPAY01List.add(obj);
			}
			if("ELPAY02".equals(obj.getErrorCode())){
				this.uploadTextELPAY02List.add(obj);
			}
			if("ELPAY03".equals(obj.getErrorCode())){
				this.uploadTextELPAY03List.add(obj);
			}
			if("ELPAY04".equals(obj.getErrorCode())){
				this.uploadTextELPAY04List.add(obj);
			}
			if("ELPAY05".equals(obj.getErrorCode())){
				this.uploadTextELPAY05List.add(obj);
			}
			if("ELPAY06".equals(obj.getErrorCode())){
				this.uploadTextELPAY06List.add(obj);
			}
			if("ELPAY07".equals(obj.getErrorCode())){
				this.uploadTextELPAY07List.add(obj);
			}
			if("ELPAY08".equals(obj.getErrorCode())){
				this.uploadTextELPAY08List.add(obj);
			}
			if("ELPAY11".equals(obj.getErrorCode())){
				this.uploadTextELPAY11List.add(obj);
			}
		}
		this.uploadTextErrorList = uploadTextErrorList;
	}

	public String getPathName() {
		return pathName;
	}

	public void setPathName(String pathName) {
		this.pathName = pathName;
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

	public boolean isMeterTypeFlag() {
		return meterTypeFlag;
	}

	public void setMeterTypeFlag(boolean meterTypeFlag) {
		this.meterTypeFlag = meterTypeFlag;
	}

	public boolean isTodtouFlag() {
		return todtouFlag;
	}

	public void setTodtouFlag(boolean todtouFlag) {
		this.todtouFlag = todtouFlag;
	}

	public boolean isKwhFlag() {
		return kwhFlag;
	}

	public void setKwhFlag(boolean kwhFlag) {
		this.kwhFlag = kwhFlag;
	}

	public boolean isDataFlag() {
		return dataFlag;
	}

	public List<ImportDataLog> getImportDataLogList() {
		return importDataLogList;
	}

	public void setImportDataLogList(List<ImportDataLog> importDataLogList) {
		this.importDataLogList = importDataLogList;
	}

	public void setDataFlag(boolean dataFlag) {
		this.dataFlag = dataFlag;
	}

	public String getSelectedRowIndex() {
		return selectedRowIndex;
	}

	public void setSelectedRowIndex(String selectedRowIndex) {
		this.selectedRowIndex = selectedRowIndex;
	}


	public boolean isDefineBackPage() {
		return isDefineBackPage;
	}


	public void setDefineBackPage(boolean isDefineBackPage) {
		this.isDefineBackPage = isDefineBackPage;
	}


	public String getMethodWithNaviFrom() {
		return methodWithNaviFrom;
	}


	public void setMethodWithNaviFrom(String methodWithNaviFrom) {
		this.methodWithNaviFrom = methodWithNaviFrom;
	}


	public String getMethodB4Refresh() {
		return methodB4Refresh;
	}


	public void setMethodB4Refresh(String methodB4Refresh) {
		this.methodB4Refresh = methodB4Refresh;
	}


	public String getMethodToRefresh() {
		return methodToRefresh;
	}


	public void setMethodToRefresh(String methodToRefresh) {
		this.methodToRefresh = methodToRefresh;
	}


	public boolean isDefineRefreshMethod() {
		return isDefineRefreshMethod;
	}


	public void setDefineRefreshMethod(boolean isDefineRefreshMethod) {
		this.isDefineRefreshMethod = isDefineRefreshMethod;
	}


	public boolean isServiceFlag() {
		return serviceFlag;
	}


	public void setServiceFlag(boolean serviceFlag) {
		this.serviceFlag = serviceFlag;
	}


	public int getElPay01Size() {
		return elPay01Size;
	}


	public void setElPay01Size(int elPay01Size) {
		this.elPay01Size = elPay01Size;
	}


	public int getElPay01PaidSize() {
		return elPay01PaidSize;
	}


	public void setElPay01PaidSize(int elPay01PaidSize) {
		this.elPay01PaidSize = elPay01PaidSize;
	}


	public int getElPay01NoPaidSize() {
		return elPay01NoPaidSize;
	}


	public void setElPay01NoPaidSize(int elPay01NoPaidSize) {
		this.elPay01NoPaidSize = elPay01NoPaidSize;
	}


	public int getElPay02Size() {
		return elPay02Size;
	}


	public void setElPay02Size(int elPay02Size) {
		this.elPay02Size = elPay02Size;
	}


	public int getElPay02PaidSize() {
		return elPay02PaidSize;
	}


	public void setElPay02PaidSize(int elPay02PaidSize) {
		this.elPay02PaidSize = elPay02PaidSize;
	}


	public int getElPay02NoPaidSize() {
		return elPay02NoPaidSize;
	}


	public void setElPay02NoPaidSize(int elPay02NoPaidSize) {
		this.elPay02NoPaidSize = elPay02NoPaidSize;
	}


	public int getElPay03Size() {
		return elPay03Size;
	}


	public void setElPay03Size(int elPay03Size) {
		this.elPay03Size = elPay03Size;
	}


	public int getElPay03PaidSize() {
		return elPay03PaidSize;
	}


	public void setElPay03PaidSize(int elPay03PaidSize) {
		this.elPay03PaidSize = elPay03PaidSize;
	}


	public int getElPay03NoPaidSize() {
		return elPay03NoPaidSize;
	}


	public void setElPay03NoPaidSize(int elPay03NoPaidSize) {
		this.elPay03NoPaidSize = elPay03NoPaidSize;
	}


	public int getElPay04Size() {
		return elPay04Size;
	}


	public void setElPay04Size(int elPay04Size) {
		this.elPay04Size = elPay04Size;
	}


	public int getElPay04PaidSize() {
		return elPay04PaidSize;
	}


	public void setElPay04PaidSize(int elPay04PaidSize) {
		this.elPay04PaidSize = elPay04PaidSize;
	}


	public int getElPay04NoPaidSize() {
		return elPay04NoPaidSize;
	}


	public void setElPay04NoPaidSize(int elPay04NoPaidSize) {
		this.elPay04NoPaidSize = elPay04NoPaidSize;
	}


	public int getElPay05Size() {
		return elPay05Size;
	}


	public void setElPay05Size(int elPay05Size) {
		this.elPay05Size = elPay05Size;
	}


	public int getElPay05PaidSize() {
		return elPay05PaidSize;
	}


	public void setElPay05PaidSize(int elPay05PaidSize) {
		this.elPay05PaidSize = elPay05PaidSize;
	}


	public int getElPay05NoPaidSize() {
		return elPay05NoPaidSize;
	}


	public void setElPay05NoPaidSize(int elPay05NoPaidSize) {
		this.elPay05NoPaidSize = elPay05NoPaidSize;
	}


	public int getElPay06Size() {
		return elPay06Size;
	}


	public void setElPay06Size(int elPay06Size) {
		this.elPay06Size = elPay06Size;
	}


	public int getElPay06PaidSize() {
		return elPay06PaidSize;
	}


	public void setElPay06PaidSize(int elPay06PaidSize) {
		this.elPay06PaidSize = elPay06PaidSize;
	}


	public int getElPay06NoPaidSize() {
		return elPay06NoPaidSize;
	}


	public void setElPay06NoPaidSize(int elPay06NoPaidSize) {
		this.elPay06NoPaidSize = elPay06NoPaidSize;
	}


	public int getElPay07Size() {
		return elPay07Size;
	}


	public void setElPay07Size(int elPay07Size) {
		this.elPay07Size = elPay07Size;
	}


	public int getElPay07PaidSize() {
		return elPay07PaidSize;
	}


	public void setElPay07PaidSize(int elPay07PaidSize) {
		this.elPay07PaidSize = elPay07PaidSize;
	}


	public int getElPay07NoPaidSize() {
		return elPay07NoPaidSize;
	}


	public void setElPay07NoPaidSize(int elPay07NoPaidSize) {
		this.elPay07NoPaidSize = elPay07NoPaidSize;
	}


	public int getElPay08Size() {
		return elPay08Size;
	}


	public void setElPay08Size(int elPay08Size) {
		this.elPay08Size = elPay08Size;
	}


	public int getElPay08PaidSize() {
		return elPay08PaidSize;
	}


	public void setElPay08PaidSize(int elPay08PaidSize) {
		this.elPay08PaidSize = elPay08PaidSize;
	}


	public int getElPay08NoPaidSize() {
		return elPay08NoPaidSize;
	}


	public void setElPay08NoPaidSize(int elPay08NoPaidSize) {
		this.elPay08NoPaidSize = elPay08NoPaidSize;
	}


	public int getElPay00Size() {
		return elPay00Size;
	}


	public void setElPay00Size(int elPay00Size) {
		this.elPay00Size = elPay00Size;
	}


	public int getElPay00PaidSize() {
		return elPay00PaidSize;
	}


	public void setElPay00PaidSize(int elPay00PaidSize) {
		this.elPay00PaidSize = elPay00PaidSize;
	}


	public int getElPay00NoPaidSize() {
		return elPay00NoPaidSize;
	}


	public void setElPay00NoPaidSize(int elPay00NoPaidSize) {
		this.elPay00NoPaidSize = elPay00NoPaidSize;
	}

	public int getSumSuccess() {
		return elPay00Size+elPay08Size;
	}

	public int getSumSuccessPaid() {
		return elPay00PaidSize+elPay08PaidSize;
	}

	public int getSumSuccessNoPaid() {
		return elPay00NoPaidSize+elPay08NoPaidSize;
	}
	
	public int getSumFail() {		
		return elPay01Size+elPay02Size+elPay03Size+elPay04Size+elPay05Size+elPay06Size+elPay07Size+elPay11Size+elPay12Size;
	}
	
	public int getSumFailPaid() {
		return elPay01PaidSize+elPay02PaidSize+elPay03PaidSize+elPay04PaidSize+elPay05PaidSize+elPay06PaidSize+elPay07PaidSize+elPay11PaidSize+elPay12PaidSize;
	}

	public int getSumFailNoPaid() {
		return elPay01NoPaidSize+elPay02NoPaidSize+elPay03NoPaidSize+elPay04NoPaidSize+elPay05NoPaidSize+elPay06NoPaidSize+elPay07NoPaidSize+elPay11NoPaidSize+elPay12NoPaidSize;
	}


	public String getRowIdRemove() {
		return rowIdRemove;
	}


	public void setRowIdRemove(String rowIdRemove) {
		this.rowIdRemove = rowIdRemove;
	}


	public String getConfirmDeleteMsg() {
		return confirmDeleteMsg;
	}


	public void setConfirmDeleteMsg(String confirmDeleteMsg) {
		this.confirmDeleteMsg = confirmDeleteMsg;
	}


	public boolean isChkSelAll() {
		return chkSelAll;
	}


	public void setChkSelAll(boolean chkSelAll) {
		this.chkSelAll = chkSelAll;
	}


	public boolean isDisableCloseJobBtn() {
		return disableCloseJobBtn;
	}


	public void setDisableCloseJobBtn(boolean disableCloseJobBtn) {
		this.disableCloseJobBtn = disableCloseJobBtn;
	}


	public String getConfirmCloseJobMsg() {
		return confirmCloseJobMsg;
	}


	public void setConfirmCloseJobMsg(String confirmCloseJobMsg) {
		this.confirmCloseJobMsg = confirmCloseJobMsg;
	}


	public String getConfirmCloseJobValidateMsg() {
		return confirmCloseJobValidateMsg;
	}


	public void setConfirmCloseJobValidateMsg(String confirmCloseJobValidateMsg) {
		this.confirmCloseJobValidateMsg = confirmCloseJobValidateMsg;
	}


	public boolean isDisableCloseJobValidateBtn() {
		return disableCloseJobValidateBtn;
	}


	public void setDisableCloseJobValidateBtn(boolean disableCloseJobValidateBtn) {
		this.disableCloseJobValidateBtn = disableCloseJobValidateBtn;
	}


	public String getClearingFlag() {
		return clearingFlag;
	}


	public void setClearingFlag(String clearingFlag) {
		this.clearingFlag = clearingFlag;
	}


	public boolean isCompanyFlag() {
		return companyFlag;
	}
	
	public String getCompanyFlagStr(){
		
		String strReturn = "N";
		if(companyFlag){
			strReturn = "Y";
		}
		
		return strReturn;
	}


	public void setCompanyFlag(boolean companyFlag) {
		this.companyFlag = companyFlag;
	}


	public List<UploadText> getUploadTextELPAY11List() {
		return uploadTextELPAY11List;
	}


	public void setUploadTextELPAY11List(List<UploadText> uploadTextELPAY11List) {
		this.uploadTextELPAY11List = uploadTextELPAY11List;
	}


	public int getElPay11Size() {
		return elPay11Size;
	}


	public void setElPay11Size(int elPay11Size) {
		this.elPay11Size = elPay11Size;
	}


	public int getElPay11PaidSize() {
		return elPay11PaidSize;
	}


	public void setElPay11PaidSize(int elPay11PaidSize) {
		this.elPay11PaidSize = elPay11PaidSize;
	}


	public int getElPay11NoPaidSize() {
		return elPay11NoPaidSize;
	}


	public void setElPay11NoPaidSize(int elPay11NoPaidSize) {
		this.elPay11NoPaidSize = elPay11NoPaidSize;
	}


	public boolean isCtFlag() {
		return ctFlag;
	}


	public void setCtFlag(boolean ctFlag) {
		this.ctFlag = ctFlag;
	}
	
	public String getCtFlagStr(){
		String strReturn = "N";
		if(ctFlag){
			strReturn = "Y";
		}
		
		return strReturn;
	}


	public String getProcessAction() {
		return processAction;
	}


	public void setProcessAction(String processAction) {
		this.processAction = processAction;
	}


	public String getSuccessPaidFlag() {
		return successPaidFlag;
	}


	public void setSuccessPaidFlag(String successPaidFlag) {
		this.successPaidFlag = successPaidFlag;
	}


	public boolean isBillPreriodFlag() {
		return billPreriodFlag;
	}


	public void setBillPreriodFlag(boolean billPreriodFlag) {
		this.billPreriodFlag = billPreriodFlag;
	}


	public boolean isOneBillPreriodFlag() {
		return oneBillPreriodFlag;
	}


	public void setOneBillPreriodFlag(boolean oneBillPreriodFlag) {
		this.oneBillPreriodFlag = oneBillPreriodFlag;
	}


	public List<UploadText> getUploadTextELPAY001List() {
		return uploadTextELPAY001List;
	}


	public void setUploadTextELPAY001List(List<UploadText> uploadTextELPAY001List) {
		this.uploadTextELPAY001List = uploadTextELPAY001List;
	}


	public List<UploadText> getUploadTextELPAY002List() {
		return uploadTextELPAY002List;
	}


	public void setUploadTextELPAY002List(List<UploadText> uploadTextELPAY002List) {
		this.uploadTextELPAY002List = uploadTextELPAY002List;
	}


	public List<UploadText> getUploadTextELPAY081List() {
		return uploadTextELPAY081List;
	}


	public void setUploadTextELPAY081List(List<UploadText> uploadTextELPAY081List) {
		this.uploadTextELPAY081List = uploadTextELPAY081List;
	}


	public List<UploadText> getUploadTextELPAY082List() {
		return uploadTextELPAY082List;
	}


	public void setUploadTextELPAY082List(List<UploadText> uploadTextELPAY082List) {
		this.uploadTextELPAY082List = uploadTextELPAY082List;
	}
    
	public void setUploadTextSuccessList(List<UploadText> uploadTextSuccessList) {
		this.uploadTextELPAY001List = new ArrayList<UploadText>();
		this.uploadTextELPAY002List = new ArrayList<UploadText>();
		this.uploadTextELPAY081List = new ArrayList<UploadText>();
		this.uploadTextELPAY082List = new ArrayList<UploadText>();
		
		for(UploadText obj : uploadTextSuccessList){
			
			try{
				if (obj.getPaidStatus()== null){
					obj.setPaidStatus("N");
				}
			}catch(Exception e){
				obj.setPaidStatus("N");
				//LOG.error("ERROR ACTION doExportExcel : "+e, e);
				e.printStackTrace();
			}
			
			if("ELPAY00".equals(obj.getErrorCode()) && obj.getPaidStatus().equalsIgnoreCase("Y")){
				this.uploadTextELPAY001List.add(obj);
			}else if("ELPAY00".equals(obj.getErrorCode()) && obj.getPaidStatus().equalsIgnoreCase("N")){
				this.uploadTextELPAY002List.add(obj);
			}else if("ELPAY08".equals(obj.getErrorCode()) && obj.getPaidStatus().equalsIgnoreCase("Y")){
				this.uploadTextELPAY081List.add(obj);
			}else if("ELPAY08".equals(obj.getErrorCode()) && obj.getPaidStatus().equalsIgnoreCase("N")){
					this.uploadTextELPAY082List.add(obj);
			}
		}
		this.uploadTextSuccessList = uploadTextSuccessList;
	}


	public boolean isShowCloseJob() {
		return showCloseJob;
	}


	public void setShowCloseJob(boolean showCloseJob) {
		this.showCloseJob = showCloseJob;
	}


	public String getContractNo() {
		return contractNo;
	}


	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}


	public ElectricFTRateSearch getFtRate() {
		return ftRate;
	}


	public void setFtRate(ElectricFTRateSearch ftRate) {
		this.ftRate = ftRate;
	}


	public List<ElectricFTRateSearch> getFtRateList() {
		return ftRateList;
	}


	public void setFtRateList(List<ElectricFTRateSearch> ftRateList) {
		this.ftRateList = ftRateList;
	}


	public boolean isMeterInfoDisplayFlag() {
		return meterInfoDisplayFlag;
	}


	public void setMeterInfoDisplayFlag(boolean meterInfoDisplayFlag) {
		this.meterInfoDisplayFlag = meterInfoDisplayFlag;
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


	public ElectricFTRateSearch getUpdateFtRate() {
		return updateFtRate;
	}


	public void setUpdateFtRate(ElectricFTRateSearch updateFtRate) {
		this.updateFtRate = updateFtRate;
	}


	public String getFtRateType() {
		return ftRateType;
	}


	public void setFtRateType(String ftRateType) {
		this.ftRateType = ftRateType;
	}


	public Date getFtStartDt() {
		return ftStartDt;
	}


	public void setFtStartDt(Date ftStartDt) {
		this.ftStartDt = ftStartDt;
	}


	public Date getFtEndDt() {
		return ftEndDt;
	}


	public void setFtEndDt(Date ftEndDt) {
		this.ftEndDt = ftEndDt;
	}


	public String getActionType() {
		return actionType;
	}


	public void setActionType(String actionType) {
		this.actionType = actionType;
	}


	public String getFtRecordId() {
		return ftRecordId;
	}


	public void setFtRecordId(String ftRecordId) {
		this.ftRecordId = ftRecordId;
	}


	public String getRecordStatus() {
		return recordStatus;
	}


	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}


	public UploadTextSP getUploadTextSP() {
		return uploadTextSP;
	}


	public void setUploadTextSP(UploadTextSP uploadTextSP) {
		this.uploadTextSP = uploadTextSP;
	}


	public List<UploadTextSP> getUploadTextSPList() {
		return uploadTextSPList;
	}


	public void setUploadTextSPList(List<UploadTextSP> uploadTextSPList) {
		this.uploadTextSPList = uploadTextSPList;
	}


	public List<UploadTextSP> getUploadTextSPELPAY001List() {
		return uploadTextSPELPAY001List;
	}


	public void setUploadTextSPELPAY001List(
			List<UploadTextSP> uploadTextSPELPAY001List) {
		this.uploadTextSPELPAY001List = uploadTextSPELPAY001List;
	}


	public List<UploadTextSP> getUploadTextSPELPAY002List() {
		return uploadTextSPELPAY002List;
	}


	public void setUploadTextSPELPAY002List(
			List<UploadTextSP> uploadTextSPELPAY002List) {
		this.uploadTextSPELPAY002List = uploadTextSPELPAY002List;
	}


	public List<UploadTextSP> getUploadTextSPELPAY081List() {
		return uploadTextSPELPAY081List;
	}


	public void setUploadTextSPELPAY081List(
			List<UploadTextSP> uploadTextSPELPAY081List) {
		this.uploadTextSPELPAY081List = uploadTextSPELPAY081List;
	}


	public List<UploadTextSP> getUploadTextSPELPAY082List() {
		return uploadTextSPELPAY082List;
	}


	public void setUploadTextSPELPAY082List(
			List<UploadTextSP> uploadTextSPELPAY082List) {
		this.uploadTextSPELPAY082List = uploadTextSPELPAY082List;
	}


	public List<UploadTextSP> getUploadTextSPErrorList() {
		return uploadTextSPErrorList;
	}


	public void setUploadTextSPErrorList(List<UploadTextSP> uploadTextSPErrorList) {
		this.uploadTextSPErrorList = uploadTextSPErrorList;
	}
	
//	public void setUploadTextSPSuccessList(List<UploadTextSP> uploadTextSPSuccessList) {
//		this.uploadTextSPELPAY001List = new ArrayList<UploadTextSP>();
//		this.uploadTextSPELPAY002List = new ArrayList<UploadTextSP>();
//		this.uploadTextSPELPAY081List = new ArrayList<UploadTextSP>();
//		this.uploadTextSPELPAY082List = new ArrayList<UploadTextSP>();
//		
//		for(UploadTextSP obj : uploadTextSPSuccessList){
//			
//			try{
//				if (obj.getPaidStatus()== null){
//					obj.setPaidStatus("N");
//				}
//			}catch(Exception e){
//				obj.setPaidStatus("N");
//				//LOG.error("ERROR ACTION doExportExcel : "+e, e);
//				e.printStackTrace();
//			}
//			
//			if("ELPAY00".equals(obj.getErrorCode()) && obj.getPaidStatus().equalsIgnoreCase("Y")){
//				this.uploadTextSPELPAY001List.add(obj);
//			}else if("ELPAY00".equals(obj.getErrorCode()) && obj.getPaidStatus().equalsIgnoreCase("N")){
//				this.uploadTextSPELPAY002List.add(obj);
//			}else if("ELPAY08".equals(obj.getErrorCode()) && obj.getPaidStatus().equalsIgnoreCase("Y")){
//				this.uploadTextSPELPAY081List.add(obj);
//			}else if("ELPAY08".equals(obj.getErrorCode()) && obj.getPaidStatus().equalsIgnoreCase("N")){
//					this.uploadTextSPELPAY082List.add(obj);
//			}
//		}
//		this.uploadTextSPSuccessList = uploadTextSPSuccessList;
//	}


	public String getElImportTranId() {
		return elImportTranId;
	}


	public void setElImportTranId(String elImportTranId) {
		this.elImportTranId = elImportTranId;
	}


	public List<UploadTextSP> getUploadTextSPSuccessList() {
		return uploadTextSPSuccessList;
	}


	public void setUploadTextSPSuccessList(
			List<UploadTextSP> uploadTextSPSuccessList) {
		this.uploadTextSPSuccessList = uploadTextSPSuccessList;
	}


	public String getPercentGrowth() {
		return percentGrowth;
	}


	public void setPercentGrowth(String percentGrowth) {
		this.percentGrowth = percentGrowth;
	}


	public String getMonth() {
		return month;
	}


	public void setMonth(String month) {
		this.month = month;
	}


	public List<SelectItem> getMonthList() {
		return monthList;
	}


	public void setMonthList(List<SelectItem> monthList) {
		this.monthList = monthList;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public List<SelectItem> getTypeList() {
		return typeList;
	}


	public void setTypeList(List<SelectItem> typeList) {
		this.typeList = typeList;
	}


	public String getFromPage() {
		return fromPage;
	}


	public void setFromPage(String fromPage) {
		this.fromPage = fromPage;
	}


	public int getElPay12Size() {
		return elPay12Size;
	}


	public void setElPay12Size(int elPay12Size) {
		this.elPay12Size = elPay12Size;
	}


	public int getElPay12PaidSize() {
		return elPay12PaidSize;
	}


	public void setElPay12PaidSize(int elPay12PaidSize) {
		this.elPay12PaidSize = elPay12PaidSize;
	}


	public int getElPay12NoPaidSize() {
		return elPay12NoPaidSize;
	}


	public void setElPay12NoPaidSize(int elPay12NoPaidSize) {
		this.elPay12NoPaidSize = elPay12NoPaidSize;
	}


	public List<UploadText> getUploadTextELPAY12List() {
		return uploadTextELPAY12List;
	}


	public void setUploadTextELPAY12List(List<UploadText> uploadTextELPAY12List) {
		this.uploadTextELPAY12List = uploadTextELPAY12List;
	}


	public boolean isViewFlag() {
		return viewFlag;
	}


	public void setViewFlag(boolean viewFlag) {
		this.viewFlag = viewFlag;
	}


	public String getTypeOfFile() {
		return typeOfFile;
	}


	public void setTypeOfFile(String typeOfFile) {
		this.typeOfFile = typeOfFile;
	}


	public String getFileProperty() {
		return fileProperty;
	}


	public void setFileProperty(String fileProperty) {
		this.fileProperty = fileProperty;
	}


	public List<UploadText> getUploadTextELPAY13List() {
		return uploadTextELPAY13List;
	}


	public void setUploadTextELPAY13List(List<UploadText> uploadTextELPAY13List) {
		this.uploadTextELPAY13List = uploadTextELPAY13List;
	}


	public List<UploadText> getUploadTextELPAY14List() {
		return uploadTextELPAY14List;
	}


	public void setUploadTextELPAY14List(List<UploadText> uploadTextELPAY14List) {
		this.uploadTextELPAY14List = uploadTextELPAY14List;
	}


	public List<UploadText> getUploadTextELPAY15List() {
		return uploadTextELPAY15List;
	}


	public void setUploadTextELPAY15List(List<UploadText> uploadTextELPAY15List) {
		this.uploadTextELPAY15List = uploadTextELPAY15List;
	}


	public List<UploadText> getUploadTextELPAY16List() {
		return uploadTextELPAY16List;
	}


	public void setUploadTextELPAY16List(List<UploadText> uploadTextELPAY16List) {
		this.uploadTextELPAY16List = uploadTextELPAY16List;
	}


	public List<UploadText> getUploadTextELPAY17List() {
		return uploadTextELPAY17List;
	}


	public void setUploadTextELPAY17List(List<UploadText> uploadTextELPAY17List) {
		this.uploadTextELPAY17List = uploadTextELPAY17List;
	}


	public List<UploadText> getUploadTextELPAY18List() {
		return uploadTextELPAY18List;
	}


	public void setUploadTextELPAY18List(List<UploadText> uploadTextELPAY18List) {
		this.uploadTextELPAY18List = uploadTextELPAY18List;
	}


	public List<MEL005FailSrchSP> getValidateFailNewList() {
		return validateFailNewList;
	}


	public void setValidateFailNewList(List<MEL005FailSrchSP> validateFailNewList) {
		this.validateFailNewList = validateFailNewList;
	}


	public MEL005FailSrchSP getValidateFailNewSP() {
		return validateFailNewSP;
	}


	public void setValidateFailNewSP(MEL005FailSrchSP validateFailNewSP) {
		this.validateFailNewSP = validateFailNewSP;
	}


	public boolean isPeriodFlag() {
		return periodFlag;
	}


	public void setPeriodFlag(boolean periodFlag) {
		this.periodFlag = periodFlag;
	}


	public boolean isContStatusInactiveFlag() {
		return contStatusInactiveFlag;
	}


	public void setContStatusInactiveFlag(boolean contStatusInactiveFlag) {
		this.contStatusInactiveFlag = contStatusInactiveFlag;
	}


	public boolean isNetworkStatusInactiveFlag() {
		return networkStatusInactiveFlag;
	}


	public void setNetworkStatusInactiveFlag(boolean networkStatusInactiveFlag) {
		this.networkStatusInactiveFlag = networkStatusInactiveFlag;
	}


	public boolean isGrowthFlag() {
		return growthFlag;
	}


	public void setGrowthFlag(boolean growthFlag) {
		this.growthFlag = growthFlag;
	}


	public boolean isDisplayExportMeter() {
		return displayExportMeter;
	}


	public void setDisplayExportMeter(boolean displayExportMeter) {
		this.displayExportMeter = displayExportMeter;
	}


	public boolean isDisplayExportUptFormat() {
		return displayExportUptFormat;
	}


	public void setDisplayExportUptFormat(boolean displayExportUptFormat) {
		this.displayExportUptFormat = displayExportUptFormat;
	}


	public List<MEL005ExportMeterSP> getExportMeterList() {
		return exportMeterList;
	}


	public void setExportMeterList(List<MEL005ExportMeterSP> exportMeterList) {
		this.exportMeterList = exportMeterList;
	}


	public boolean isDisableBtnExportMeter() {
		return disableBtnExportMeter;
	}


	public void setDisableBtnExportMeter(boolean disableBtnExportMeter) {
		this.disableBtnExportMeter = disableBtnExportMeter;
	}


	public boolean isDisableBtnExportUptFormat() {
		return disableBtnExportUptFormat;
	}


	public void setDisableBtnExportUptFormat(boolean disableBtnExportUptFormat) {
		this.disableBtnExportUptFormat = disableBtnExportUptFormat;
	}


	public boolean isDisplayExportReportUsage() {
		return displayExportReportUsage;
	}


	public void setDisplayExportReportUsage(boolean displayExportReportUsage) {
		this.displayExportReportUsage = displayExportReportUsage;
	}


	public boolean isDisplayExportNewFormat() {
		return displayExportNewFormat;
	}


	public void setDisplayExportNewFormat(boolean displayExportNewFormat) {
		this.displayExportNewFormat = displayExportNewFormat;
	}


	public String getProcessIdTmp() {
		return processIdTmp;
	}


	public void setProcessIdTmp(String processIdTmp) {
		this.processIdTmp = processIdTmp;
	}


	@Override
	public void setRowPerPage(int rowPerPage) {
		// TODO Auto-generated method stub
		this.rowPerPage = rowPerPage;
	}


	public List<ManagementWrapper> getPaymentHistoryWrapperList() {
		return paymentHistoryWrapperList;
	}


	public void setPaymentHistoryWrapperList(
			List<ManagementWrapper> paymentHistoryWrapperList) {
		this.paymentHistoryWrapperList = paymentHistoryWrapperList;
	}


	public List<PaymentHistSP> getPaymentHistList() {
		return paymentHistList;
	}


	public void setPaymentHistList(List<PaymentHistSP> paymentHistList) {
		this.paymentHistList = paymentHistList;
	}


	public boolean isDisplayExportPaymentHist() {
		return displayExportPaymentHist;
	}


	public void setDisplayExportPaymentHist(boolean displayExportPaymentHist) {
		this.displayExportPaymentHist = displayExportPaymentHist;
	}


	public MEL005FailSrchSP getDataDetailSP() {
		return dataDetailSP;
	}


	public void setDataDetailSP(MEL005FailSrchSP dataDetailSP) {
		this.dataDetailSP = dataDetailSP;
	}


}
