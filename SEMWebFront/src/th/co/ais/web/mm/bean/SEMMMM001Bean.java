package th.co.ais.web.mm.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import org.richfaces.model.TreeNode;

import th.co.ais.domain.common.MenuTreeSP;
import th.co.ais.domain.gm.Bank;
import th.co.ais.domain.gm.BankMasterSP;
import th.co.ais.domain.gm.CT001ExportBank;
import th.co.ais.domain.mm.ItemResultSP;
import th.co.ais.domain.mm.Mmm001AddressSP;
import th.co.ais.domain.mm.Mmm001BookbankPayeeSP;
import th.co.ais.domain.mm.Mmm001BookbankSP;
import th.co.ais.domain.mm.Mmm001ContractHistory;
import th.co.ais.domain.mm.Mmm001ContractPayHistory;
import th.co.ais.domain.mm.Mmm001CriteriaSP;
import th.co.ais.domain.mm.Mmm001ContractSP;
import th.co.ais.domain.mm.Mmm001ExpenseWithContractOfVendorSP;
import th.co.ais.domain.mm.Mmm001ExportBatchResultSP;
import th.co.ais.domain.mm.Mmm001HistorySP;
import th.co.ais.domain.mm.Mmm001PayeeSP;
import th.co.ais.domain.mm.Mmm001PaymentSP;
import th.co.ais.domain.mm.Mmm001RequestParam;
import th.co.ais.domain.mm.Mmm001SAPBookbankSP;
import th.co.ais.domain.mm.Mmm001SAPVendorSP;
import th.co.ais.domain.mm.Mmm001ValidatePage;
import th.co.ais.domain.mm.Mmm001VendorContractSP;
import th.co.ais.domain.mm.Mmm001VendorMasterSP;
import th.co.ais.domain.mm.Mmm001VendorPayHistSP;
import th.co.ais.domain.mm.Mmm001VendorSP;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMMMM001Bean extends AbstractBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4487694900041346684L;
	
	private List<SelectItem> companyList;
	private List<SelectItem> expenseTypeList;
	private List<SelectItem> bankList;
	private List<SelectItem> vendorStatusList;
	private List<SelectItem> vendorFlowStatusList;
	private List<SelectItem> bookbankStatusList;
	private List<SelectItem> bookbankFlowStatusList;
	private List<SelectItem> payeeStatusList;
	private List<SelectItem> payeeFlowStatusList;
	private List<SelectItem> bookbankPayeeStatusList;
	private List<SelectItem> bookbankPayeeFlowStatusList;
	private List<SelectItem> tambolList;
	private List<SelectItem> amphurList;
	private List<SelectItem> provinceList;
	private List<SelectItem> regionList;
	
	private List<SelectItem> activeStatusList;
	private List<SelectItem> accountTypeList;
	private List<SelectItem> bankBranchList;
	private List<SelectItem> hqBranchList;
	private List<SelectItem> vendorTypeList;
	private List<SelectItem> vendorBlockStatusList;
	private List<SelectItem> vendorBlackListStatusList;
	
	private List<SelectItem> withholdList;
	
	private Mmm001CriteriaSP vendorMasterCriteria;
	private Mmm001CriteriaSP popupSearchContractCriteria;
	private Mmm001VendorMasterSP vendorMasterInfo;
	private Mmm001ContractSP contractInfo;
	private Mmm001VendorSP vendorInfo;
	private Mmm001VendorSP changeVendorCriteria;
	private Mmm001PayeeSP payeeInfo;
	private Mmm001BookbankSP bookbankInfo;
	private Mmm001BookbankPayeeSP bookbankPayeeInfo;
	private Mmm001PaymentSP paymentInfo;
	private Mmm001ExportBatchResultSP exportBatchInfo;
	private Mmm001SAPVendorSP semSapVendorInfo;
	private Mmm001VendorSP popupSAPVendorInfo;
	
	private Mmm001SAPBookbankSP semSapBookbankInfo;
	
	private Mmm001VendorSP vendorInfoCmpObj;
	private Mmm001BookbankSP bookbankInfoCmpObj;
	private Mmm001PayeeSP payeeInfoCmpObj;
	private Mmm001BookbankPayeeSP bookbankPayeeInfoCmpObj;
	
	private Mmm001VendorSP vendorInfoMissMatchWithSAPObj;
	private Mmm001BookbankSP bookbankInfoMissMatchWithSAPObj;
	
	private Mmm001ExpenseWithContractOfVendorSP expCntrctOfVndObj;
	
	private List<WrapperBeanObject<Mmm001VendorMasterSP>> vendorMasterResultList;
	private List<WrapperBeanObject<Mmm001VendorMasterSP>> vendorMasterTerminateResultList;
	private List<WrapperBeanObject<Mmm001VendorMasterSP>> convertVendorResultList;
	private List<WrapperBeanObject<Mmm001VendorContractSP>> vendorContractList;			//vendorOfContract
	private List<WrapperBeanObject<Mmm001ContractSP>> popupSearchContractResultList;
	private List<WrapperBeanObject<Mmm001BookbankSP>> bookbankList;
	private List<WrapperBeanObject<Mmm001PayeeSP>> payeeList;
	private List<WrapperBeanObject<Mmm001BookbankPayeeSP>> bookbankPayeeList;
	private List<WrapperBeanObject<Mmm001ContractSP>> contractList;						//contractOfVendor
	private List<WrapperBeanObject<Mmm001ContractSP>> contractOfBookbankList;
	private List<WrapperBeanObject<Mmm001ContractSP>> contractOfPayeeList;
	private List<WrapperBeanObject<Mmm001ContractSP>> contractOfBookbankPayeeList;
	private List<WrapperBeanObject<Mmm001PaymentSP>> paymentList;
	private List<WrapperBeanObject<Mmm001ExportBatchResultSP>> exportBatchResultList;
	private List<WrapperBeanObject<Mmm001SAPVendorSP>> semSapVendorList;
	private List<WrapperBeanObject<Mmm001VendorSP>> popupSAPVendorlist;
	
	private List<WrapperBeanObject<Mmm001SAPBookbankSP>> semSapBookbankList;
	
	private List<WrapperBeanObject<Mmm001PayeeSP>> popupPayeeResultList;
	
	// address --
	private Mmm001AddressSP vendorAddrObj;
	private Mmm001AddressSP rentalAddrObj;
	private Mmm001AddressSP electrictAddrObj;
	private Mmm001AddressSP propertyAddrObj;
	private Mmm001AddressSP insureAddrObj;
	private Mmm001AddressSP constructAddrObj;
	private Mmm001AddressSP withholdAddrObj;
	
	private Mmm001AddressSP vendorAddrCmpObj;
	private Mmm001AddressSP rentalAddrCmpObj;
	private Mmm001AddressSP electrictAddrCmpObj;
	private Mmm001AddressSP propertyAddrCmpObj;
	private Mmm001AddressSP insureAddrCmpObj;
	private Mmm001AddressSP constructAddrCmpObj;
	private Mmm001AddressSP withholdAddrCmpObj;
	
	
	// message result --
	private ItemResultSP retResultObj;
	
	private Mmm001HistorySP historyInfo;
	private List<WrapperBeanObject<Mmm001HistorySP>> historyResultList;
	
	
	private String selectedRowIndex;
	private String selectedTab;
	private String tabNo;
	
	private String pageParam;
	
	
	// enabled/disabled
	private boolean isDisableBtnNewVendor = false;
	private boolean isDisableBtnNewBookbank = true;
	private boolean isDisableBtnNewPayee = true;
	private boolean isDisableBtnNewBookbankPayee = true;
	
	private boolean isDisableBtnExportBatchVD = true;
	
	private boolean isRenderedBtnSendManagerVD = true;
	private boolean isDisableBtnSendManagerVD = true;
	
	
	private boolean isDisableBtnExportBatchPY = true;
	private boolean isDisableBtnSendManagerPY = true;
	private boolean isRenderedBtnSendManagerPY = true;
	private boolean isDisableBtnExportBatchPB = true;
	private boolean isDisableBtnSendManagerPB = true;
	private boolean isRenderedBtnSendManagerPB = true;
	private boolean isDisableBtnDelete = true;
	private boolean isRenderedBtnDelete = true;
	private boolean isDisableBtnDeleteVendor = true;
	
	private boolean isDisableBtnPopupResult = false;
	
	
	private boolean isDisableContent = true;
	private boolean isDisableBtnSiteInfo = true;
	private boolean isDisableBtnHistory = true;
	
	private boolean isDisableEditVendorContent = true;
	private boolean isDisableBtnEditVendor = false;
	private boolean isRenderedBtnEditVendor = false;
	private boolean isDisableBtnSaveVendor = false;
	private boolean isDisableBtnCancelVendor = false;
	
	private boolean isDisableEditPayeeContent = true;
	private boolean isDisableBtnEditPayee = false;
	private boolean isRenderedBtnEditPayee = false;
	private boolean isDisableBtnSavePayee = false;
	
	private boolean isDisableEditBookbankPayeeContent = true;
	private boolean isDisableBtnEditBookbankPayee = false;
	private boolean isRenderedBtnEditBookbankPayee = false;
	private boolean isDisableBtnSaveBookbankPayee = false;
	
	private boolean isDisableBtnNewBookbankOfVendor = true;
	private boolean isDisableBtnDeleteBookbankOfVendor = true;
	private boolean isDisableBtnNewPayeeOfVendor = true;
	private boolean isDisableBtnDeletePayeeOfVendor = true;
	private boolean isDisableBtnChangeContractOfVendor = true;
	private boolean isDisableBtnDeleteContractOfVendor = true;
	private boolean isDisableBtnAssignOrAddContract = true;
	private boolean isDisableBtnDeleteBookbankOfPayee = true;
	
	// visibled/invisibled
	private boolean isVisiblePnlContractInfo = false;
	private boolean isVisiblePnlAddContractInfo = false;
	private boolean renderedResultMsgAlert = true;
	private boolean renderedExportBatchResultAlert = false;
	
	private boolean isVisiblePnlVendorInfo = true;
	private boolean isVisiblePnlBankListInfo = true;
	private boolean isVisiblePnlBookbankPayeeListInfo = true;
	private boolean isVisiblePnlContractListInfo = true;
	
	private boolean renderedPnlCmpVendorInfo = false;
	private boolean renderedPnlCmpBookbankInfo = false;
	private boolean renderedPnlCmpPayeeInfo = false;
	private boolean renderedPnlCmpBookbankPayeeInfo = false;
	
	private boolean renderedBtnSAPVendorInfo = false;
	private boolean renderedPopupSAPVendorInfo = false;
	
	private boolean renderedBtnSAPBookbankInfo = false;
	private boolean renderedPopupSAPBookbankInfo = false;
	
	private boolean renderedAskForNewContract = true;
	private boolean renderedPnlForWithoutContract = true;
	
	private boolean renderedBtnNewVendor = false;
	
	// checked/unchecked
	private boolean chkSelAll;
	private boolean chkPicoType;
	private boolean chkSelAllTblAct;
	private boolean chkSelAllTblTmn;
	private boolean chkSelAllTblContractVendor;
	
	
	//added by NEW 02/05/2017
	private ArrayList selectIdList;
	private String actionType;
	private String flowStatus;
	private String rejectRemark;
	
	//added by new 04/05/2017
	private TreeNode rootNode = null;
	private List<MenuTreeSP> menuTreeList;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreeVendorList;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreeVendorBookbankList;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreePayeeList;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreePayeeBookbankList;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreeAbnormalList;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreeCreateByList;
	private boolean renderedTodoRejectButton;
	
	private String paramUrl;
	private String paramMenuGroup;
	
	private List<SelectItem> teamList;
	
	
	//added by NEW 17/05/2017
	private Mmm001VendorSP vendorInfoSap;
	private Mmm001VendorSP vendorInfoSem;
	private boolean renderedEditColumn = false;
	private Mmm001AddressSP vendorSapAddrObj;
	private Mmm001AddressSP vendorSemAddrObj;
	private Mmm001AddressSP withholdSapAddrObj;
	private Mmm001AddressSP withholdSemAddrObj;
	
	//added by NEW 18/05/2017
	private String groupType = "SEM";
	
	private List<SelectItem> companySemList;
	private List<SelectItem> expenseTypeSemList;
	private List<SelectItem> bankSemList;
	private List<SelectItem> vendorStatusSemList;
	private List<SelectItem> vendorFlowStatusSemList;
	private List<SelectItem> bookbankStatusSemList;
	private List<SelectItem> bookbankFlowStatusSemList;
	private List<SelectItem> payeeStatusSemList;
	private List<SelectItem> payeeFlowStatusSemList;
	private List<SelectItem> bookbankPayeeStatusSemList;
	private List<SelectItem> bookbankPayeeFlowStatusSemList;
	private List<SelectItem> tambolSemList;
	private List<SelectItem> amphurSemList;
	private List<SelectItem> provinceSemList;
	private List<SelectItem> regionSemList;
	
	private List<SelectItem> activeStatusSemList;
	private List<SelectItem> accountTypeSemList;
	private List<SelectItem> bankBranchSemList;
	private List<SelectItem> vendorTypeSemList;
	private List<SelectItem> vendorBlockStatusSemList;
	
	//added by NEW 22/05/2017
	private String selectedSapTab;
	private String selectedSemTab;
	private Mmm001BookbankSP bookbankSapInfo;
	private Mmm001BookbankSP bookbankSemInfo;
	
	private List<WrapperBeanObject<Mmm001ContractHistory>> contractHistoryList;
	private List<WrapperBeanObject<Mmm001ContractPayHistory>> contractPayHistoryList;
	
	private  String totalSumVendor;
	private  String totalSumVendorBookbank;
	private  String totalSumPayee;
	private  String totalSumPayeeBookbank;
	private  String totalSumAbnormal;
	private  String totalSumCreateBy;
	
	//added by NEW
	private Bank criteriaBank;
	public List<Bank> bankSelList;
	public List<Bank> bankTmpSelList;
	private String selectedRadio = "";
	
	private List<SelectItem> provinceBookbankList;
	
	private String doMode;
	
	//for search criteria
	private BankMasterSP criteriaBankMasterSP;
	private BankMasterSP popupCriteriaBankMasterSP;
	private BankMasterSP itemBankMasterSP;
	private BankMasterSP bankSearchSelected;
	
	public List<BankMasterSP> bankMasterSlctList;
	private List<SelectItem> bankNameSearchList;
	private List<SelectItem> bankSelectionSearchList;
	private List<SelectItem> bankCodeList;
	private List<SelectItem> bankNameList;
	
	private boolean chkForEdit = false;
	private boolean disbledDialogField = true;
	
	private String navPrograme;
	
	private boolean displayReport = false;
	private List<CT001ExportBank> ct001ExBankList;
	private String tmpBatch;
	private Date tmpBatchDT;
	private String status;
	
	private Mmm001ContractSP contractInfoHist;
	private Mmm001VendorSP vendorInfoHist;
	private Mmm001VendorSP vendorInfoHistSummary;
	private Mmm001PayeeSP payeeInfoHist;
	private Mmm001BookbankSP bookbankInfoHist;
	private Mmm001BookbankPayeeSP bookbankPayeeInfoHist;
	private Mmm001PayeeSP payeeInfoHistDetail;
	private Mmm001BookbankSP bookbankInfoHistDetail;
	private Mmm001BookbankPayeeSP bookbankPayeeInfoHistDetail;
	private List<WrapperBeanObject<Mmm001VendorContractSP>> vendorContractHistList;
	private List<WrapperBeanObject<Mmm001BookbankSP>> bookbankHistList;
	private List<WrapperBeanObject<Mmm001PayeeSP>> payeeHistList;
	private List<WrapperBeanObject<Mmm001BookbankPayeeSP>> bookbankPayeeHistList;
	private List<WrapperBeanObject<Mmm001ContractSP>> contractHistList;
	private List<WrapperBeanObject<Mmm001PaymentSP>> paymentHistList;
	private List<WrapperBeanObject<Mmm001VendorSP>> vendorInfoHistSummaryList;
	
	private boolean renderedPanelVendor;
	private boolean renderedBtnBack = false;
	private String contractNo;
	private String vendorId;
	private String bookbankId;
	private String payeeId;
	private String bookbankPayeeId;
	private String historyPage;
	private String backButtonFlag;
	
	//added by NEW 2017/07/21
	private boolean chkVendorType;
	private boolean chkPayeeType;
	private List<SelectItem> blockStatusList;
	private List<SelectItem> blackListStatusList;
	
	//added by NEW 2017/08/08
	private boolean renderedBtnTodoBack = false;
	private String navProgramBack;
	private String actionWithNaviBack;
	private String methodWithNaviBack;
	private String navModuleBack;
	private String todoManagerFlag;
	
	private boolean isDisableBtnClearBatch = true;
	private boolean isRenderedBtnClearBatch = true;
	
	private boolean isDisableBtnCancel = true;
	private boolean isRenderedBtnCancel = true;
	
	//added by NEW 2017/09/29
	private boolean vendorBlockStatus = false;
	private boolean vendorBlackListStatus = false;
	private boolean notPayeeFlag = false;
	private boolean otherExpenseFlag = false;
	
	private boolean vendorBlockStatusSAP = false;
	private boolean notPayeeFlagSAP = false;
	
	private boolean vendorHistBlockStatus = false;
	private boolean vendorHistBlackListStatus = false;
	private boolean notPayeeHistFlag = false;
	private boolean otherExpenseHistFlag = false;
	
	private boolean vendorCmpBlockStatus = false;
	private boolean vendorCmpBlackListStatus = false;
	private boolean notPayeeCmpFlag = false;
	private boolean otherExpenseCmpFlag = false;
	
	//added by NEW 2017/10/05
	private boolean renderedBtnSelectVendorCont = false;
	private String vendorContFlag;
	
	private boolean renderedBtnCloseVendor = false;
	private boolean renderedBtnOKVendor = false;
	private boolean renderedBtnCencelVendor = false;
	private boolean renderedBtnYesVendor = false;
	private boolean renderedBtnNoVendor = false;
	private boolean renderedMsgPopupSave = false;
	
	//added by NEW 2017/10/06
	private List<WrapperBeanObject<Mmm001BookbankSP>> bookbankActiveList;
	private List<WrapperBeanObject<Mmm001BookbankSP>> bookbankInactiveList;
	
	private List<WrapperBeanObject<Mmm001BookbankPayeeSP>> bookbankPayeeActiveList;
	private List<WrapperBeanObject<Mmm001BookbankPayeeSP>> bookbankPayeeInactiveList;
	
	//added by NEW 2017/10/09
	private String payeeSelectedRowIndex;
	private String payeeSelectedTab;
	private String payeeTabNo;
	
	private String payeeSelectedSapTab;
	private String payeeSelectedSemTab;
	
	private Mmm001AddressSP payeeAddrObj;
	private Mmm001AddressSP rentalPayeeAddrObj;
	private Mmm001AddressSP electrictPayeeAddrObj;
	private Mmm001AddressSP propertyPayeeAddrObj;
	private Mmm001AddressSP insurePayeeAddrObj;
	private Mmm001AddressSP constructPayeeAddrObj;
	private Mmm001AddressSP withholdPayeeAddrObj;
	
	private Mmm001PayeeSP changePayeeCriteria;
	
	private boolean renderedBtnNewAllVendor = false;
	private boolean disableBtnNewAllVendor = false;
	
	private boolean renderedBtnNewVendorDetail = false;
	private boolean disableBtnNewVendorDetail = false;
	
	private boolean renderedBtnSelectVendor = false;
	private boolean disableBtnSelectVendor = false;
	
	private boolean renderedBtnChangeVendor = false;
	private boolean disableBtnChangeVendor = true;
	
	private boolean renderedExportBatchVD = false;
	private boolean disableExportBatchVD = true;
	
	private boolean renderedClearBatchVD = false;
	private boolean disableClearBatchVD = true;
	
	private boolean renderedCancel = true;
	private boolean disableCancel = true;
	
	private boolean renderedDeleteVD = true;
	private boolean disableDeleteVD = true;
	
	private boolean disableBtnselectContract = true;
	private boolean renderedcolumnEditContractVendor = false;
	private boolean disableBtnNewBookbankVD = true;
	private boolean renderedColumnDeleteBookbankVendorVD = false;
	private boolean disableBtnNewPayeeVD = true;
	private boolean renderedColumnDeletePayeeVD = false;
	
	private boolean isDisableBtnExportBatchVB = true;
	private boolean isRenderedBtnExportBatchVB = true;
	private boolean isDisableBtnSendManagerVB = true;
	private boolean isRenderedBtnSendManagerVB = true;
	private boolean isDisableEditBookbankContent = true;
	private boolean isRenderedEditBookbankContent = true;
	private boolean isDisableBtnEditBookbank = false;
	private boolean isRenderedBtnEditBookbank = false;
	private boolean isDisableBtnSaveBookbank = false;
	private boolean isDisableBtnCancelBookbank = false;
	private boolean isRenderedBtnSaveBookbank = false;
	private boolean renderedBtnNewAllVB = true;
	private boolean disableBtnNewAllVB = true;
	private boolean renderedBtnNewVBDetail = false;
	private boolean disableBtnNewVBDetail = false;
	private boolean renderedBtnSelectVB = false;
	private boolean disableBtnSelectVB = false;
	private boolean disableBtnChangeVB = true;
	private boolean renderedBtnChangeVB = true;
	private boolean disableExportBatchVB = true;
	private boolean renderedExportBatchVB = true;
	private boolean disableClearBatchVB = true;
	private boolean renderedClearBatchVB = true;
	private boolean disableCancelVB = true;
	private boolean renderedCancelVB = true;
	private boolean disableDeleteVB = true;
	private boolean renderedDeleteVB = true;
	private boolean disableBtnCopyVBFromSAP = false;
	
	private boolean renderedBtnNewAllPY = false;
	private boolean disableBtnNewAllPY = false;
	private boolean renderedBtnNewPYDetail = false;
	private boolean disableBtnNewPYDetail = false;
	private boolean renderedBtnSelectPY = false;
	private boolean disableBtnSelectPY = false;
	private boolean disableBtnChangePY = false;
	private boolean renderedBtnChangePY = false;
	private boolean disableExportBatchPY = true;
	private boolean renderedExportBatchPY = true;
	private boolean disableClearBatchPY = true;
	private boolean renderedClearBatchPY = true;
	private boolean disableCancelPY = true;
	private boolean renderedCancelPY = true;
	private boolean disableDeletePY = true;
	private boolean renderedDeletePY = true;
	
	private boolean renderedBtnNewAllPB = true;
	private boolean disableBtnNewAllPB = true;
	private boolean renderedBtnNewPBDetail = false;
	private boolean disableBtnNewPBDetail = false;
	private boolean renderedBtnSelectPB = false;
	private boolean disableBtnSelectPB = false;
	private boolean disableBtnChangePB = true;
	private boolean renderedBtnChangePB = true;
	private boolean disableExportBatchPB = true;
	private boolean renderedExportBatchPB = true;
	private boolean disableClearBatchPB = true;
	private boolean renderedClearBatchPB = true;
	private boolean disableCancelPB = true;
	private boolean renderedCancelPB = true;
	private boolean disableDeletePB = true;
	private boolean renderedDeletePB = true;
	
	private Mmm001VendorMasterSP vendorInfoBackParam;
	private boolean historyFlag = false;
	
	private List<WrapperBeanObject<Mmm001VendorPayHistSP>> rtPaymentHistoryList;
	private List<WrapperBeanObject<Mmm001VendorPayHistSP>> elPaymentHistoryList;
	private List<WrapperBeanObject<Mmm001VendorPayHistSP>> ptPaymentHistoryList;
	private List<WrapperBeanObject<Mmm001VendorPayHistSP>> irPaymentHistoryList;
	private List<WrapperBeanObject<Mmm001VendorPayHistSP>> ctPaymentHistoryList;
	
	// address --
	private Mmm001AddressSP vendorAddrHistObj;
	private Mmm001AddressSP rentalAddrHistObj;
	private Mmm001AddressSP electrictAddrHistObj;
	private Mmm001AddressSP propertyAddrHistObj;
	private Mmm001AddressSP insureAddrHistObj;
	private Mmm001AddressSP constructAddrHistObj;
	private Mmm001AddressSP withholdAddrHistObj;
	
	private Mmm001AddressSP payeeAddrHistObj;
	private Mmm001AddressSP rentalPayeeAddrHistObj;
	private Mmm001AddressSP electrictPayeeAddrHistObj;
	private Mmm001AddressSP propertyPayeeAddrHistObj;
	private Mmm001AddressSP insurePayeeAddrHistObj;
	private Mmm001AddressSP constructPayeeAddrHistObj;
	private Mmm001AddressSP withholdPayeeAddrHistObj;
	
	//added by NEW 2017/10/20
	private String newVendorFlag;
	private String vendorFlowStatus;
	
	private Mmm001RequestParam semmmm001ReqParam;
	
	private boolean renderedRemarkContract = false;
	
	private boolean renderedConfirmVD = false;
	private boolean disableConfirmVD = true;
	
	private boolean renderedConfirmVB = false;
	private boolean disableConfirmVB = true;
	
	private boolean renderedConfirmPY = false;
	private boolean disableConfirmPY = true;
	
	private boolean renderedConfirmPB = false;
	private boolean disableConfirmPB = true;
	
	private boolean disableBtnCopyFromSAP;
	
	private String contractNoDelete;
	private String vendorIdDelete;
	private String vendorMapPayeeIdDelete;
	private String confirmMsg;
	
	private boolean disablePaymentVendorCont;
	private boolean disablePaymentVendorContVerify;
	
	private boolean disableBtnCopyPYFromSAP;
	private boolean disableBtnCopyPBFromSAP;
	
	private boolean disableDLLCompany;
	
	private String navProgram;
	private String methodWithNavi;
	
	private String renderedMsgConfirm;
	private boolean renderedBtnCheck;
	private boolean renderedBtnUncheck;
	
	private boolean chkDummyFlag;
	
	private List<SelectItem> noExportBatchList;
	
	private boolean renderedBtnBackOthPageFlow;
	
	private Mmm001ValidatePage validatePage;
	
	private boolean payeePageFlag = false;
	
	private List<Mmm001VendorMasterSP> ct001ExExcelList;
	
	private boolean disableBtnExportExcel = true;
	
	private boolean renderedBtnBackVD = false;
	private boolean renderedBtnBackVB = false;
	private boolean renderedBtnBackPY = false;
	private boolean renderedBtnBackPB = false;
	private boolean renderedBtnBackVDCancel = false;
	private boolean renderedBtnBackVBCancel = false;
	private boolean renderedBtnBackPYCancel = false;
	private boolean renderedBtnBackPBCancel = false;
	private String resultMsg;
	
	private String navModuleBackAfterSave;
	private String navProgramBackAfterSave;
	private String moduleWithNaviBackAfterSave;
	private String actionWithNaviBackAfterSave;
	private String todoManagerFlagBackAfterSave;
	private String contractNoParamBackAfterSave;
	private String vendorIdParamBackAfterSave;
	private String actionIdBackAfterSave;
	private String methodWithNaviBackAfterSave;
	
	private String modeBackAfterSave;
	private String headTypeBackAfterSave;
	
	private String expenseEffectiveDtStrParamBackAfterSave;
	private String effectiveDtStrParamBackAfterSave;
	private String expireDtStrParamBackAfterSave;
	private String expenseTypeIdParamBackAfterSave;
	private String payTypeIdParamBackAfterSave;
	private String vendorMapPayeeIdParamBackAfterSave;
	private String cancelFlagBackAfterSave;
	
	private boolean renderedBtnBackHide = false;
	
	private boolean isDisableBtnEditDataBookbank = false;
	private boolean isRenderedBtnEditDataBookbank = false;
	
	private boolean isDisableBtnEditDataPayee = false;
	private boolean isRenderedBtnEditDataPayee = false;
	
	private boolean isDisableBtnEditDataPayeeBB = false;
	private boolean isRenderedBtnEditDataPayeeBB = false;
	
	private List<WrapperBeanObject<Mmm001HistorySP>> confirmResultList;
	
	//Bas Add 
	private boolean togPnlVD = false;
	private boolean togPnlVB = false; 
	private boolean togPnlPY = false;
	private boolean togPnlPB = false;
	private boolean togPnlAB = false;
	private boolean togPnlCB = false;
	
	//added by NEW 20180201
	private boolean renderedMsgNewPayee = false;
	private boolean fromVendorFlag = false;
	private boolean fromPayeeFlag = false;
	
	private boolean msgFlag = true;
	
	private boolean renderedPopupConfirmBackVD = false;
	private boolean renderedPopupConfirmBackVB = false;
	private boolean renderedPopupConfirmBackPY = false;
	private boolean renderedPopupConfirmBackPB = false;
	
	private boolean saveSuccessFlag = false;
	
	//added by NEW 12/03/2018 selectItem vendor
	private List<SelectItem> tambolVendorList;
	private List<SelectItem> amphurVendorList;
	private List<SelectItem> provinceVendorList;
	
	private List<SelectItem> tambolRentalList;
	private List<SelectItem> amphurRentalList;
	private List<SelectItem> provinceRentalList;

	private List<SelectItem> tambolElectrictList;
	private List<SelectItem> amphurElectrictList;
	private List<SelectItem> provinceElectrictList;
	
	private List<SelectItem> tambolPropertyList;
	private List<SelectItem> amphurPropertyList;
	private List<SelectItem> provincePropertyList;
	
	private List<SelectItem> tambolInsureList;
	private List<SelectItem> amphurInsureList;
	private List<SelectItem> provinceInsureList;
	
	private List<SelectItem> tambolConstructList;
	private List<SelectItem> amphurConstructList;
	private List<SelectItem> provinceConstructList;
	
	private List<SelectItem> tambolWithholdList;
	private List<SelectItem> amphurWithholdList;
	private List<SelectItem> provinceWithholdList;
	
	//added by NEW 12/03/2018 selectItem vendor cmp
	private List<SelectItem> tambolVendorCmpList;
	private List<SelectItem> amphurVendorCmpList;
	private List<SelectItem> provinceVendorCmpList;
	
	private List<SelectItem> tambolRentalCmpList;
	private List<SelectItem> amphurRentalCmpList;
	private List<SelectItem> provinceRentalCmpList;

	private List<SelectItem> tambolElectrictCmpList;
	private List<SelectItem> amphurElectrictCmpList;
	private List<SelectItem> provinceElectrictCmpList;
	
	private List<SelectItem> tambolPropertyCmpList;
	private List<SelectItem> amphurPropertyCmpList;
	private List<SelectItem> provincePropertyCmpList;
	
	private List<SelectItem> tambolInsureCmpList;
	private List<SelectItem> amphurInsureCmpList;
	private List<SelectItem> provinceInsureCmpList;
	
	private List<SelectItem> tambolConstructCmpList;
	private List<SelectItem> amphurConstructCmpList;
	private List<SelectItem> provinceConstructCmpList;
	
	private List<SelectItem> tambolWithholdCmpList;
	private List<SelectItem> amphurWithholdCmpList;
	private List<SelectItem> provinceWithholdCmpList;
	
	private String accountNoMaxLength;
	private String accountNoMaxLengthCmp;
	private String accountNoMaxLengthPayee;
	private String accountNoMaxLengthPayeeCmp;
	
	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	
	public List<SelectItem> getCompanyList() {
		if(companyList == null) {
			companyList = new ArrayList<SelectItem>();
		}
		return companyList;
	}
	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}
	public List<SelectItem> getExpenseTypeList() {
		if(expenseTypeList == null){
			expenseTypeList = new ArrayList<SelectItem>();
		}
		return expenseTypeList;
	}
	public void setExpenseTypeList(List<SelectItem> expenseTypeList) {
		this.expenseTypeList = expenseTypeList;
	}
	public List<SelectItem> getBankList() {
		if(bankList == null){
			bankList = new ArrayList<SelectItem>();
		}
		return bankList;
	}
	public void setBankList(List<SelectItem> bankList) {
		this.bankList = bankList;
	}
	public List<SelectItem> getVendorStatusList() {
		if(vendorStatusList == null){
			vendorStatusList = new ArrayList<SelectItem>();
		}
		return vendorStatusList;
	}
	public void setVendorStatusList(List<SelectItem> vendorStatusList) {
		this.vendorStatusList = vendorStatusList;
	}
	public List<SelectItem> getBookbankStatusList() {
		if(bookbankStatusList == null){
			bookbankStatusList = new ArrayList<SelectItem>();
		}
		return bookbankStatusList;
	}
	public void setBookbankStatusList(List<SelectItem> bookbankStatusList) {
		this.bookbankStatusList = bookbankStatusList;
	}
	public List<SelectItem> getPayeeStatusList() {
		if(payeeStatusList == null){
			payeeStatusList = new ArrayList<SelectItem>();
		}
		return payeeStatusList;
	}
	public void setPayeeStatusList(List<SelectItem> payeeStatusList) {
		this.payeeStatusList = payeeStatusList;
	}
	public List<SelectItem> getBookbankPayeeStatusList() {
		if(bookbankPayeeStatusList == null){
			bookbankPayeeStatusList = new ArrayList<SelectItem>();
		}
		return bookbankPayeeStatusList;
	}
	public void setBookbankPayeeStatusList(List<SelectItem> bookbankPayeeStatusList) {
		this.bookbankPayeeStatusList = bookbankPayeeStatusList;
	}
	public List<SelectItem> getVendorFlowStatusList() {
		if(vendorFlowStatusList == null){
			vendorFlowStatusList = new ArrayList<SelectItem>();
		}
		return vendorFlowStatusList;
	}
	public void setVendorFlowStatusList(List<SelectItem> vendorFlowStatusList) {
		this.vendorFlowStatusList = vendorFlowStatusList;
	}
	public List<SelectItem> getBookbankFlowStatusList() {
		if(bookbankFlowStatusList == null){
			bookbankFlowStatusList = new ArrayList<SelectItem>();
		}
		return bookbankFlowStatusList;
	}
	public void setBookbankFlowStatusList(List<SelectItem> bookbankFlowStatusList) {
		this.bookbankFlowStatusList = bookbankFlowStatusList;
	}
	public List<SelectItem> getPayeeFlowStatusList() {
		if(payeeFlowStatusList == null){
			payeeFlowStatusList = new ArrayList<SelectItem>();
		}
		return payeeFlowStatusList;
	}
	public void setPayeeFlowStatusList(List<SelectItem> payeeFlowStatusList) {
		this.payeeFlowStatusList = payeeFlowStatusList;
	}
	
	public List<SelectItem> getBookbankPayeeFlowStatusList() {
		if(bookbankPayeeFlowStatusList == null){
			bookbankPayeeFlowStatusList = new ArrayList<SelectItem>();
		}
		return bookbankPayeeFlowStatusList;
	}
	public void setBookbankPayeeFlowStatusList(List<SelectItem> bookbankPayeeFlowStatusList) {
		this.bookbankPayeeFlowStatusList = bookbankPayeeFlowStatusList;
	}
	public String getSelectedRowIndex() {
		return selectedRowIndex;
	}
	public void setSelectedRowIndex(String selectedRowIndex) {
		this.selectedRowIndex = selectedRowIndex;
	}
	public boolean isChkSelAll() {
		return chkSelAll;
	}
	public void setChkSelAll(boolean chkSelAll) {
		this.chkSelAll = chkSelAll;
	}
	public boolean isChkSelAllTblAct() {
		return chkSelAllTblAct;
	}
	public void setChkSelAllTblAct(boolean chkSelAllTblAct) {
		this.chkSelAllTblAct = chkSelAllTblAct;
	}
	public boolean isChkSelAllTblTmn() {
		return chkSelAllTblTmn;
	}
	public void setChkSelAllTblTmn(boolean chkSelAllTblTmn) {
		this.chkSelAllTblTmn = chkSelAllTblTmn;
	}
	public boolean isChkSelAllTblContractVendor() {
		return chkSelAllTblContractVendor;
	}
	public void setChkSelAllTblContractVendor(boolean chkSelAllTblContractVendor) {
		this.chkSelAllTblContractVendor = chkSelAllTblContractVendor;
	}
	public String getSelectedTab() {
		return selectedTab;
	}
	public void setSelectedTab(String selectedTab) {
		this.selectedTab = selectedTab;
	}
	public String getTabNo() {
		return tabNo;
	}
	public void setTabNo(String tabNo) {
		this.tabNo = tabNo;
	}
	public String getPageParam() {
		return pageParam;
	}
	public void setPageParam(String pageParam) {
		this.pageParam = pageParam;
	}
	public List<SelectItem> getTambolList() {
		if(tambolList == null){
			tambolList = new ArrayList<SelectItem>();
		}
		return tambolList;
	}
	public void setTambolList(List<SelectItem> tambolList) {
		this.tambolList = tambolList;
	}
	public List<SelectItem> getAmphurList() {
		if(amphurList == null){
			amphurList = new ArrayList<SelectItem>();
		}
		return amphurList;
	}
	public void setAmphurList(List<SelectItem> amphurList) {
		this.amphurList = amphurList;
	}
	public List<SelectItem> getProvinceList() {
		if(provinceList == null){
			provinceList = new ArrayList<SelectItem>();
		}
		return provinceList;
	}
	public void setProvinceList(List<SelectItem> provinceList) {
		this.provinceList = provinceList;
	}
	public List<SelectItem> getRegionList() {
		if(regionList == null){
			regionList = new ArrayList<SelectItem>();
		}
		return regionList;
	}
	public void setRegionList(List<SelectItem> regionList) {
		this.regionList = regionList;
	}
	public List<SelectItem> getActiveStatusList() {
		if(activeStatusList == null){
			activeStatusList = new ArrayList<SelectItem>();
		}
		return activeStatusList;
	}
	public void setActiveStatusList(List<SelectItem> activeStatusList) {
		this.activeStatusList = activeStatusList;
	}
	public List<SelectItem> getAccountTypeList() {
		if(accountTypeList == null){
			accountTypeList = new ArrayList<SelectItem>();
		}
		return accountTypeList;
	}
	public void setAccountTypeList(List<SelectItem> accountTypeList) {
		this.accountTypeList = accountTypeList;
	}
	public List<SelectItem> getBankBranchList() {
		if(bankBranchList == null){
			bankBranchList = new ArrayList<SelectItem>();
		}
		return bankBranchList;
	}
	public void setBankBranchList(List<SelectItem> bankBranchList) {
		this.bankBranchList = bankBranchList;
	}
	public List<SelectItem> getHqBranchList() {
		if(hqBranchList == null){
			hqBranchList = new ArrayList<SelectItem>();
		}
		return hqBranchList;
	}
	public void setHqBranchList(List<SelectItem> hqBranchList) {
		this.hqBranchList = hqBranchList;
	}
	public List<SelectItem> getVendorTypeList() {
		if(vendorTypeList == null){
			vendorTypeList = new ArrayList<SelectItem>();
		}
		return vendorTypeList;
	}
	public void setVendorTypeList(List<SelectItem> vendorTypeList) {
		this.vendorTypeList = vendorTypeList;
	}
	public List<SelectItem> getVendorBlockStatusList() {
		if(vendorBlockStatusList == null){
			vendorBlockStatusList = new ArrayList<SelectItem>();
		}
		return vendorBlockStatusList;
	}
	public void setVendorBlockStatusList(List<SelectItem> vendorBlockStatusList) {
		this.vendorBlockStatusList = vendorBlockStatusList;
	}
	public List<SelectItem> getVendorBlackListStatusList() {
		if(vendorBlackListStatusList == null){
			vendorBlackListStatusList = new ArrayList<SelectItem>();
		}
		return vendorBlackListStatusList;
	}
	public void setVendorBlackListStatusList(
			List<SelectItem> vendorBlackListStatusList) {
		this.vendorBlackListStatusList = vendorBlackListStatusList;
	}
	public List<SelectItem> getWithholdList() {
		if(withholdList == null){
			withholdList = new ArrayList<SelectItem>();
		}
		return withholdList;
	}
	public void setWithholdList(List<SelectItem> withholdList) {
		this.withholdList = withholdList;
	}
	
	public Mmm001CriteriaSP getVendorMasterCriteria() {
		if(vendorMasterCriteria == null){
			vendorMasterCriteria = new Mmm001CriteriaSP();
		}
		return vendorMasterCriteria;
	}
	public void setVendorMasterCriteria(Mmm001CriteriaSP vendorMasterCriteria) {
		this.vendorMasterCriteria = vendorMasterCriteria;
	}
	public Mmm001CriteriaSP getPopupSearchContractCriteria() {
		if(popupSearchContractCriteria == null){
			popupSearchContractCriteria = new Mmm001CriteriaSP();
		}
		return popupSearchContractCriteria;
	}
	public void setPopupSearchContractCriteria(
			Mmm001CriteriaSP popupSearchContractCriteria) {
		this.popupSearchContractCriteria = popupSearchContractCriteria;
	}
	public Mmm001VendorMasterSP getVendorMasterInfo() {
		return vendorMasterInfo;
	}
	public void setVendorMasterInfo(Mmm001VendorMasterSP vendorMasterInfo) {
		this.vendorMasterInfo = vendorMasterInfo;
	}
	public List<WrapperBeanObject<Mmm001VendorMasterSP>> getVendorMasterResultList() {
		if(vendorMasterResultList == null){
			vendorMasterResultList = new ArrayList<WrapperBeanObject<Mmm001VendorMasterSP>>();
		}
		return vendorMasterResultList;
	}
	public void setVendorMasterResultList(List<WrapperBeanObject<Mmm001VendorMasterSP>> vendorMasterResultList) {
		this.vendorMasterResultList = vendorMasterResultList;
	}
	public List<WrapperBeanObject<Mmm001VendorMasterSP>> getVendorMasterTerminateResultList() {
		if(vendorMasterTerminateResultList == null){
			vendorMasterTerminateResultList = new ArrayList<WrapperBeanObject<Mmm001VendorMasterSP>>();
		}
		return vendorMasterTerminateResultList;
	}
	public void setVendorMasterTerminateResultList(
			List<WrapperBeanObject<Mmm001VendorMasterSP>> vendorMasterTerminateResultList) {
		this.vendorMasterTerminateResultList = vendorMasterTerminateResultList;
	}
	public List<WrapperBeanObject<Mmm001VendorMasterSP>> getConvertVendorResultList() {
		if(convertVendorResultList == null){
			convertVendorResultList = new ArrayList<WrapperBeanObject<Mmm001VendorMasterSP>>();
		}
		return convertVendorResultList;
	}
	public void setConvertVendorResultList(
			List<WrapperBeanObject<Mmm001VendorMasterSP>> convertVendorResultList) {
		this.convertVendorResultList = convertVendorResultList;
	}
	public List<WrapperBeanObject<Mmm001PaymentSP>> getPaymentList() {
		if(paymentList == null){
			paymentList = new ArrayList<WrapperBeanObject<Mmm001PaymentSP>>();
		}
		return paymentList;
	}
	public void setPaymentList(List<WrapperBeanObject<Mmm001PaymentSP>> paymentList) {
		this.paymentList = paymentList;
	}
	public List<WrapperBeanObject<Mmm001ExportBatchResultSP>> getExportBatchResultList() {
		if(exportBatchResultList == null){
			exportBatchResultList = new ArrayList<WrapperBeanObject<Mmm001ExportBatchResultSP>>();
		}
		return exportBatchResultList;
	}
	public void setExportBatchResultList(List<WrapperBeanObject<Mmm001ExportBatchResultSP>> exportBatchResultList) {
		this.exportBatchResultList = exportBatchResultList;
	}
	public List<WrapperBeanObject<Mmm001SAPVendorSP>> getSemSapVendorList() {
		if(semSapVendorList == null){
			semSapVendorList = new ArrayList<WrapperBeanObject<Mmm001SAPVendorSP>>();
		}
		return semSapVendorList;
	}
	public void setSemSapVendorList(
			List<WrapperBeanObject<Mmm001SAPVendorSP>> semSapVendorList) {
		this.semSapVendorList = semSapVendorList;
	}
	public List<WrapperBeanObject<Mmm001VendorSP>> getPopupSAPVendorlist() {
		if(popupSAPVendorlist == null){
			popupSAPVendorlist = new ArrayList<WrapperBeanObject<Mmm001VendorSP>>();
		}
		return popupSAPVendorlist;
	}
	public void setPopupSAPVendorlist(
			List<WrapperBeanObject<Mmm001VendorSP>> popupSAPVendorlist) {
		this.popupSAPVendorlist = popupSAPVendorlist;
	}
	public Mmm001ContractSP getContractInfo() {
		if(contractInfo == null){
			contractInfo = new Mmm001ContractSP();
		}
		return contractInfo;
	}
	public void setContractInfo(Mmm001ContractSP contractInfo) {
		this.contractInfo = contractInfo;
	}
	public Mmm001VendorSP getVendorInfo() {
		if(vendorInfo == null){
			vendorInfo = new Mmm001VendorSP();
		}
		return vendorInfo;
	}
	public Mmm001PayeeSP getPayeeInfo() {
		if(payeeInfo == null){
			payeeInfo = new Mmm001PayeeSP();
		}
		return payeeInfo;
	}
	public void setPayeeInfo(Mmm001PayeeSP payeeInfo) {
		this.payeeInfo = payeeInfo;
	}
	public void setVendorInfo(Mmm001VendorSP vendorInfo) {
		this.vendorInfo = vendorInfo;
	}
	public Mmm001BookbankSP getBookbankInfo() {
		if(bookbankInfo == null){
			bookbankInfo = new Mmm001BookbankSP();
		}
		return bookbankInfo;
	}
	public void setBookbankInfo(Mmm001BookbankSP bookbankInfo) {
		this.bookbankInfo = bookbankInfo;
	}
	public Mmm001BookbankPayeeSP getBookbankPayeeInfo() {
		if(bookbankPayeeInfo == null){
			bookbankPayeeInfo = new Mmm001BookbankPayeeSP();
		}
		return bookbankPayeeInfo;
	}
	public void setBookbankPayeeInfo(Mmm001BookbankPayeeSP bookbankPayeeInfo) {
		this.bookbankPayeeInfo = bookbankPayeeInfo;
	}
	public Mmm001PaymentSP getPaymentInfo() {
		if(paymentInfo == null){
			paymentInfo = new Mmm001PaymentSP();
		}
		return paymentInfo;
	}
	public void setPaymentInfo(Mmm001PaymentSP paymentInfo) {
		this.paymentInfo = paymentInfo;
	}
	public Mmm001ExportBatchResultSP getExportBatchInfo() {
		if(exportBatchInfo == null){
			exportBatchInfo = new Mmm001ExportBatchResultSP();
		}
		return exportBatchInfo;
	}
	public void setExportBatchInfo(Mmm001ExportBatchResultSP exportBatchInfo) {
		this.exportBatchInfo = exportBatchInfo;
	}
	public Mmm001SAPVendorSP getSemSapVendorInfo() {
		if(semSapVendorInfo == null){
			semSapVendorInfo = new Mmm001SAPVendorSP();
		}
		return semSapVendorInfo;
	}
	public void setSemSapVendorInfo(Mmm001SAPVendorSP semSapVendorInfo) {
		this.semSapVendorInfo = semSapVendorInfo;
	}
	public Mmm001VendorSP getPopupSAPVendorInfo() {
		if(popupSAPVendorInfo == null){
			popupSAPVendorInfo = new Mmm001VendorSP();
		}
		return popupSAPVendorInfo;
	}
	public void setPopupSAPVendorInfo(Mmm001VendorSP popupSAPVendorInfo) {
		this.popupSAPVendorInfo = popupSAPVendorInfo;
	}
	public Mmm001SAPBookbankSP getSemSapBookbankInfo() {
		if(semSapBookbankInfo != null){
			semSapBookbankInfo = new Mmm001SAPBookbankSP();
		}
		return semSapBookbankInfo;
	}
	public void setSemSapBookbankInfo(Mmm001SAPBookbankSP semSapBookbankInfo) {
		this.semSapBookbankInfo = semSapBookbankInfo;
	}
	public List<WrapperBeanObject<Mmm001SAPBookbankSP>> getSemSapBookbankList() {
		if(semSapBookbankList == null){
			semSapBookbankList = new ArrayList<WrapperBeanObject<Mmm001SAPBookbankSP>>();
		}
		return semSapBookbankList;
	}
	public void setSemSapBookbankList(
			List<WrapperBeanObject<Mmm001SAPBookbankSP>> semSapBookbankList) {
		this.semSapBookbankList = semSapBookbankList;
	}
	public List<WrapperBeanObject<Mmm001PayeeSP>> getPopupPayeeResultList() {
		if(popupPayeeResultList == null){
			popupPayeeResultList = new ArrayList<WrapperBeanObject<Mmm001PayeeSP>>();
		}
		return popupPayeeResultList;
	}
	public void setPopupPayeeResultList(
			List<WrapperBeanObject<Mmm001PayeeSP>> popupPayeeResultList) {
		this.popupPayeeResultList = popupPayeeResultList;
	}
	public List<WrapperBeanObject<Mmm001VendorContractSP>> getVendorContractList() {
		if(vendorContractList == null){
			vendorContractList = new ArrayList<WrapperBeanObject<Mmm001VendorContractSP>>();
		}
		return vendorContractList;
	}
	public void setVendorContractList(List<WrapperBeanObject<Mmm001VendorContractSP>> vendorContractList) {
		this.vendorContractList = vendorContractList;
	}
	public List<WrapperBeanObject<Mmm001ContractSP>> getPopupSearchContractResultList() {
		if(popupSearchContractResultList == null){
			popupSearchContractResultList = new ArrayList<WrapperBeanObject<Mmm001ContractSP>>();
		}
		return popupSearchContractResultList;
	}
	public void setPopupSearchContractResultList(
			List<WrapperBeanObject<Mmm001ContractSP>> popupSearchContractResultList) {
		this.popupSearchContractResultList = popupSearchContractResultList;
	}
	public List<WrapperBeanObject<Mmm001BookbankSP>> getBookbankList() {
		if(bookbankList == null){
			bookbankList = new ArrayList<WrapperBeanObject<Mmm001BookbankSP>>();
		}
		return bookbankList;
	}
	public void setBookbankList(List<WrapperBeanObject<Mmm001BookbankSP>> bookbankList) {
		this.bookbankList = bookbankList;
	}
	public List<WrapperBeanObject<Mmm001PayeeSP>> getPayeeList() {
		if(payeeList == null){
			payeeList = new ArrayList<WrapperBeanObject<Mmm001PayeeSP>>();
		}
		return payeeList;
	}
	public void setPayeeList(List<WrapperBeanObject<Mmm001PayeeSP>> payeeList) {
		this.payeeList = payeeList;
	}
	public List<WrapperBeanObject<Mmm001BookbankPayeeSP>> getBookbankPayeeList() {
		if(bookbankPayeeList == null){
			bookbankPayeeList = new ArrayList<WrapperBeanObject<Mmm001BookbankPayeeSP>>();
		}
		return bookbankPayeeList;
	}
	public void setBookbankPayeeList(
			List<WrapperBeanObject<Mmm001BookbankPayeeSP>> bookbankPayeeList) {
		this.bookbankPayeeList = bookbankPayeeList;
	}
	public List<WrapperBeanObject<Mmm001ContractSP>> getContractList() {
		if(contractList == null){
			contractList = new ArrayList<WrapperBeanObject<Mmm001ContractSP>>();
		}
		return contractList;
	}
	public void setContractList(List<WrapperBeanObject<Mmm001ContractSP>> contractList) {
		this.contractList = contractList;
	}
	public List<WrapperBeanObject<Mmm001ContractSP>> getContractOfBookbankList() {
		if(contractOfBookbankList == null){
			contractOfBookbankList = new ArrayList<WrapperBeanObject<Mmm001ContractSP>>();
		}
		return contractOfBookbankList;
	}
	public void setContractOfBookbankList(
			List<WrapperBeanObject<Mmm001ContractSP>> contractOfBookbankList) {
		this.contractOfBookbankList = contractOfBookbankList;
	}
	public List<WrapperBeanObject<Mmm001ContractSP>> getContractOfPayeeList() {
		if(contractOfPayeeList == null){
			contractOfPayeeList = new ArrayList<WrapperBeanObject<Mmm001ContractSP>>();
		}
		return contractOfPayeeList;
	}
	public void setContractOfPayeeList(
			List<WrapperBeanObject<Mmm001ContractSP>> contractOfPayeeList) {
		this.contractOfPayeeList = contractOfPayeeList;
	}
	public List<WrapperBeanObject<Mmm001ContractSP>> getContractOfBookbankPayeeList() {
		if(contractOfBookbankPayeeList == null){
			contractOfBookbankPayeeList = new ArrayList<WrapperBeanObject<Mmm001ContractSP>>();
		}
		return contractOfBookbankPayeeList;
	}
	public void setContractOfBookbankPayeeList(
			List<WrapperBeanObject<Mmm001ContractSP>> contractOfBookbankPayeeList) {
		this.contractOfBookbankPayeeList = contractOfBookbankPayeeList;
	}
	public Mmm001HistorySP getHistoryInfo() {
		if(historyInfo == null){
			historyInfo = new Mmm001HistorySP();
		}
		return historyInfo;
	}
	public void setHistoryInfo(Mmm001HistorySP historyInfo) {
		this.historyInfo = historyInfo;
	}
	public List<WrapperBeanObject<Mmm001HistorySP>> getHistoryResultList() {
		if(historyResultList == null){
			historyResultList = new ArrayList<WrapperBeanObject<Mmm001HistorySP>>();
		}
		return historyResultList;
	}
	public void setHistoryResultList(List<WrapperBeanObject<Mmm001HistorySP>> historyResultList) {
		this.historyResultList = historyResultList;
	}
	
	public boolean isDisableBtnNewBookbank() {
		return isDisableBtnNewBookbank;
	}
	public void setDisableBtnNewBookbank(boolean isDisableBtnNewBookbank) {
		this.isDisableBtnNewBookbank = isDisableBtnNewBookbank;
	}
	public boolean isDisableBtnNewPayee() {
		return isDisableBtnNewPayee;
	}
	public void setDisableBtnNewPayee(boolean isDisableBtnNewPayee) {
		this.isDisableBtnNewPayee = isDisableBtnNewPayee;
	}
	public boolean isDisableBtnNewBookbankPayee() {
		return isDisableBtnNewBookbankPayee;
	}
	public void setDisableBtnNewBookbankPayee(boolean isDisableBtnNewBookbankPayee) {
		this.isDisableBtnNewBookbankPayee = isDisableBtnNewBookbankPayee;
	}
	public boolean isDisableBtnNewVendor() {
		return isDisableBtnNewVendor;
	}
	public void setDisableBtnNewVendor(boolean isDisableBtnNewVendor) {
		this.isDisableBtnNewVendor = isDisableBtnNewVendor;
	}
	public boolean isDisableBtnExportBatchVD() {
		return isDisableBtnExportBatchVD;
	}
	public void setDisableBtnExportBatchVD(boolean isDisableBtnExportBatchVD) {
		this.isDisableBtnExportBatchVD = isDisableBtnExportBatchVD;
	}
	public boolean isDisableBtnSendManagerVD() {
		return isDisableBtnSendManagerVD;
	}
	public void setDisableBtnSendManagerVD(boolean isDisableBtnSendManagerVD) {
		this.isDisableBtnSendManagerVD = isDisableBtnSendManagerVD;
	}
	public boolean isDisableBtnExportBatchVB() {
		return isDisableBtnExportBatchVB;
	}
	public void setDisableBtnExportBatchVB(boolean isDisableBtnExportBatchVB) {
		this.isDisableBtnExportBatchVB = isDisableBtnExportBatchVB;
	}
	public boolean isDisableBtnSendManagerVB() {
		return isDisableBtnSendManagerVB;
	}
	public void setDisableBtnSendManagerVB(boolean isDisableBtnSendManagerVB) {
		this.isDisableBtnSendManagerVB = isDisableBtnSendManagerVB;
	}
	public boolean isDisableBtnExportBatchPY() {
		return isDisableBtnExportBatchPY;
	}
	public void setDisableBtnExportBatchPY(boolean isDisableBtnExportBatchPY) {
		this.isDisableBtnExportBatchPY = isDisableBtnExportBatchPY;
	}
	public boolean isDisableBtnSendManagerPY() {
		return isDisableBtnSendManagerPY;
	}
	public void setDisableBtnSendManagerPY(boolean isDisableBtnSendManagerPY) {
		this.isDisableBtnSendManagerPY = isDisableBtnSendManagerPY;
	}
	public boolean isDisableBtnExportBatchPB() {
		return isDisableBtnExportBatchPB;
	}
	public void setDisableBtnExportBatchPB(boolean isDisableBtnExportBatchPB) {
		this.isDisableBtnExportBatchPB = isDisableBtnExportBatchPB;
	}
	public boolean isDisableBtnSendManagerPB() {
		return isDisableBtnSendManagerPB;
	}
	public void setDisableBtnSendManagerPB(boolean isDisableBtnSendManagerPB) {
		this.isDisableBtnSendManagerPB = isDisableBtnSendManagerPB;
	}
	public boolean isDisableBtnDelete() {
		return isDisableBtnDelete;
	}
	public void setDisableBtnDelete(boolean isDisableBtnDelete) {
		this.isDisableBtnDelete = isDisableBtnDelete;
	}
	public boolean isDisableBtnDeleteVendor() {
		return isDisableBtnDeleteVendor;
	}
	public void setDisableBtnDeleteVendor(boolean isDisableBtnDeleteVendor) {
		this.isDisableBtnDeleteVendor = isDisableBtnDeleteVendor;
	}
	public boolean isDisableBtnPopupResult() {
		return isDisableBtnPopupResult;
	}
	public void setDisableBtnPopupResult(boolean isDisableBtnPopupResult) {
		this.isDisableBtnPopupResult = isDisableBtnPopupResult;
	}
	public boolean isDisableContent() {
		return isDisableContent;
	}
	public void setDisableContent(boolean isDisableContent) {
		this.isDisableContent = isDisableContent;
	}
	public boolean isDisableBtnSiteInfo() {
		return isDisableBtnSiteInfo;
	}
	public void setDisableBtnSiteInfo(boolean isDisableBtnSiteInfo) {
		this.isDisableBtnSiteInfo = isDisableBtnSiteInfo;
	}
	public boolean isDisableBtnHistory() {
		return isDisableBtnHistory;
	}
	public void setDisableBtnHistory(boolean isDisableBtnHistory) {
		this.isDisableBtnHistory = isDisableBtnHistory;
	}
	public boolean isDisableEditVendorContent() {
		return isDisableEditVendorContent;
	}
	public void setDisableEditVendorContent(boolean isDisableEditVendorContent) {
		this.isDisableEditVendorContent = isDisableEditVendorContent;
	}
	public boolean isDisableBtnEditVendor() {
		return isDisableBtnEditVendor;
	}
	public void setDisableBtnEditVendor(boolean isDisableBtnEditVendor) {
		this.isDisableBtnEditVendor = isDisableBtnEditVendor;
	}
	public boolean isDisableBtnSaveVendor() {
		return isDisableBtnSaveVendor;
	}
	public void setDisableBtnSaveVendor(boolean isDisableBtnSaveVendor) {
		this.isDisableBtnSaveVendor = isDisableBtnSaveVendor;
	}
	public boolean isDisableEditBookbankContent() {
		return isDisableEditBookbankContent;
	}
	public void setDisableEditBookbankContent(boolean isDisableEditBookbankContent) {
		this.isDisableEditBookbankContent = isDisableEditBookbankContent;
	}
	public boolean isDisableBtnEditBookbank() {
		return isDisableBtnEditBookbank;
	}
	public void setDisableBtnEditBookbank(boolean isDisableBtnEditBookbank) {
		this.isDisableBtnEditBookbank = isDisableBtnEditBookbank;
	}
	public boolean isDisableBtnSaveBookbank() {
		return isDisableBtnSaveBookbank;
	}
	public void setDisableBtnSaveBookbank(boolean isDisableBtnSaveBookbank) {
		this.isDisableBtnSaveBookbank = isDisableBtnSaveBookbank;
	}
	public boolean isDisableEditPayeeContent() {
		return isDisableEditPayeeContent;
	}
	public void setDisableEditPayeeContent(boolean isDisableEditPayeeContent) {
		this.isDisableEditPayeeContent = isDisableEditPayeeContent;
	}
	public boolean isDisableBtnEditPayee() {
		return isDisableBtnEditPayee;
	}
	public void setDisableBtnEditPayee(boolean isDisableBtnEditPayee) {
		this.isDisableBtnEditPayee = isDisableBtnEditPayee;
	}
	public boolean isDisableBtnSavePayee() {
		return isDisableBtnSavePayee;
	}
	public void setDisableBtnSavePayee(boolean isDisableBtnSavePayee) {
		this.isDisableBtnSavePayee = isDisableBtnSavePayee;
	}
	public boolean isDisableEditBookbankPayeeContent() {
		return isDisableEditBookbankPayeeContent;
	}
	public void setDisableEditBookbankPayeeContent(
			boolean isDisableEditBookbankPayeeContent) {
		this.isDisableEditBookbankPayeeContent = isDisableEditBookbankPayeeContent;
	}
	public boolean isDisableBtnEditBookbankPayee() {
		return isDisableBtnEditBookbankPayee;
	}
	public void setDisableBtnEditBookbankPayee(boolean isDisableBtnEditBookbankPayee) {
		this.isDisableBtnEditBookbankPayee = isDisableBtnEditBookbankPayee;
	}
	public boolean isDisableBtnSaveBookbankPayee() {
		return isDisableBtnSaveBookbankPayee;
	}
	public void setDisableBtnSaveBookbankPayee(boolean isDisableBtnSaveBookbankPayee) {
		this.isDisableBtnSaveBookbankPayee = isDisableBtnSaveBookbankPayee;
	}
	public boolean isDisableBtnNewBookbankOfVendor() {
		return isDisableBtnNewBookbankOfVendor;
	}
	public void setDisableBtnNewBookbankOfVendor(
			boolean isDisableBtnNewBookbankOfVendor) {
		this.isDisableBtnNewBookbankOfVendor = isDisableBtnNewBookbankOfVendor;
	}
	public boolean isDisableBtnDeleteBookbankOfVendor() {
		return isDisableBtnDeleteBookbankOfVendor;
	}
	public void setDisableBtnDeleteBookbankOfVendor(
			boolean isDisableBtnDeleteBookbankOfVendor) {
		this.isDisableBtnDeleteBookbankOfVendor = isDisableBtnDeleteBookbankOfVendor;
	}
	public boolean isDisableBtnNewPayeeOfVendor() {
		return isDisableBtnNewPayeeOfVendor;
	}
	public void setDisableBtnNewPayeeOfVendor(boolean isDisableBtnNewPayeeOfVendor) {
		this.isDisableBtnNewPayeeOfVendor = isDisableBtnNewPayeeOfVendor;
	}
	public boolean isDisableBtnDeletePayeeOfVendor() {
		return isDisableBtnDeletePayeeOfVendor;
	}
	public void setDisableBtnDeletePayeeOfVendor(
			boolean isDisableBtnDeletePayeeOfVendor) {
		this.isDisableBtnDeletePayeeOfVendor = isDisableBtnDeletePayeeOfVendor;
	}
	public boolean isDisableBtnChangeContractOfVendor() {
		return isDisableBtnChangeContractOfVendor;
	}
	public void setDisableBtnChangeContractOfVendor(
			boolean isDisableBtnChangeContractOfVendor) {
		this.isDisableBtnChangeContractOfVendor = isDisableBtnChangeContractOfVendor;
	}
	public boolean isDisableBtnDeleteContractOfVendor() {
		return isDisableBtnDeleteContractOfVendor;
	}
	public void setDisableBtnDeleteContractOfVendor(
			boolean isDisableBtnDeleteContractOfVendor) {
		this.isDisableBtnDeleteContractOfVendor = isDisableBtnDeleteContractOfVendor;
	}
	public boolean isDisableBtnAssignOrAddContract() {
		return isDisableBtnAssignOrAddContract;
	}
	public void setDisableBtnAssignOrAddContract(
			boolean isDisableBtnAssignOrAddContract) {
		this.isDisableBtnAssignOrAddContract = isDisableBtnAssignOrAddContract;
	}
	public boolean isDisableBtnDeleteBookbankOfPayee() {
		return isDisableBtnDeleteBookbankOfPayee;
	}
	public void setDisableBtnDeleteBookbankOfPayee(
			boolean isDisableBtnDeleteBookbankOfPayee) {
		this.isDisableBtnDeleteBookbankOfPayee = isDisableBtnDeleteBookbankOfPayee;
	}
	public boolean isChkPicoType() {
		return chkPicoType;
	}
	public void setChkPicoType(boolean chkPicoType) {
		this.chkPicoType = chkPicoType;
	}
	public boolean isVisiblePnlContractInfo() {
		return isVisiblePnlContractInfo;
	}
	public void setVisiblePnlContractInfo(boolean isVisiblePnlContractInfo) {
		this.isVisiblePnlContractInfo = isVisiblePnlContractInfo;
	}
	public boolean isVisiblePnlAddContractInfo() {
		return isVisiblePnlAddContractInfo;
	}
	public void setVisiblePnlAddContractInfo(boolean isVisiblePnlAddContractInfo) {
		this.isVisiblePnlAddContractInfo = isVisiblePnlAddContractInfo;
	}
	public boolean isVisiblePnlVendorInfo() {
		return isVisiblePnlVendorInfo;
	}
	public void setVisiblePnlVendorInfo(boolean isVisiblePnlVendorInfo) {
		this.isVisiblePnlVendorInfo = isVisiblePnlVendorInfo;
	}
	public boolean isVisiblePnlBankListInfo() {
		return isVisiblePnlBankListInfo;
	}
	public void setVisiblePnlBankListInfo(boolean isVisiblePnlBankListInfo) {
		this.isVisiblePnlBankListInfo = isVisiblePnlBankListInfo;
	}
	public boolean isVisiblePnlBookbankPayeeListInfo() {
		return isVisiblePnlBookbankPayeeListInfo;
	}
	public void setVisiblePnlBookbankPayeeListInfo(
			boolean isVisiblePnlBookbankPayeeListInfo) {
		this.isVisiblePnlBookbankPayeeListInfo = isVisiblePnlBookbankPayeeListInfo;
	}
	public boolean isVisiblePnlContractListInfo() {
		return isVisiblePnlContractListInfo;
	}
	public void setVisiblePnlContractListInfo(boolean isVisiblePnlContractListInfo) {
		this.isVisiblePnlContractListInfo = isVisiblePnlContractListInfo;
	}
	public boolean isRenderedResultMsgAlert() {
		return renderedResultMsgAlert;
	}
	public void setRenderedResultMsgAlert(boolean renderedResultMsgAlert) {
		this.renderedResultMsgAlert = renderedResultMsgAlert;
	}
	public boolean isRenderedExportBatchResultAlert() {
		return renderedExportBatchResultAlert;
	}
	public void setRenderedExportBatchResultAlert(boolean renderedExportBatchResultAlert) {
		this.renderedExportBatchResultAlert = renderedExportBatchResultAlert;
	}
	public boolean isRenderedPnlCmpVendorInfo() {
		return renderedPnlCmpVendorInfo;
	}
	public void setRenderedPnlCmpVendorInfo(boolean renderedPnlCmpVendorInfo) {
		this.renderedPnlCmpVendorInfo = renderedPnlCmpVendorInfo;
	}
	public boolean isRenderedPnlCmpBookbankInfo() {
		return renderedPnlCmpBookbankInfo;
	}
	public void setRenderedPnlCmpBookbankInfo(boolean renderedPnlCmpBookbankInfo) {
		this.renderedPnlCmpBookbankInfo = renderedPnlCmpBookbankInfo;
	}
	public boolean isRenderedPnlCmpPayeeInfo() {
		return renderedPnlCmpPayeeInfo;
	}
	public void setRenderedPnlCmpPayeeInfo(boolean renderedPnlCmpPayeeInfo) {
		this.renderedPnlCmpPayeeInfo = renderedPnlCmpPayeeInfo;
	}
	public boolean isRenderedPnlCmpBookbankPayeeInfo() {
		return renderedPnlCmpBookbankPayeeInfo;
	}
	public void setRenderedPnlCmpBookbankPayeeInfo(boolean renderedPnlCmpBookbankPayeeInfo) {
		this.renderedPnlCmpBookbankPayeeInfo = renderedPnlCmpBookbankPayeeInfo;
	}
	public boolean isRenderedPopupSAPVendorInfo() {
		return renderedPopupSAPVendorInfo;
	}
	public void setRenderedPopupSAPVendorInfo(boolean renderedPopupSAPVendorInfo) {
		this.renderedPopupSAPVendorInfo = renderedPopupSAPVendorInfo;
	}
	public boolean isRenderedBtnSAPVendorInfo() {
		return renderedBtnSAPVendorInfo;
	}
	public void setRenderedBtnSAPVendorInfo(boolean renderedBtnSAPVendorInfo) {
		this.renderedBtnSAPVendorInfo = renderedBtnSAPVendorInfo;
	}
	public boolean isRenderedBtnSAPBookbankInfo() {
		return renderedBtnSAPBookbankInfo;
	}
	public void setRenderedBtnSAPBookbankInfo(boolean renderedBtnSAPBookbankInfo) {
		this.renderedBtnSAPBookbankInfo = renderedBtnSAPBookbankInfo;
	}
	public boolean isRenderedPopupSAPBookbankInfo() {
		return renderedPopupSAPBookbankInfo;
	}
	public void setRenderedPopupSAPBookbankInfo(boolean renderedPopupSAPBookbankInfo) {
		this.renderedPopupSAPBookbankInfo = renderedPopupSAPBookbankInfo;
	}
	public boolean isRenderedAskForNewContract() {
		return renderedAskForNewContract;
	}
	public void setRenderedAskForNewContract(boolean renderedAskForNewContract) {
		this.renderedAskForNewContract = renderedAskForNewContract;
	}
	public boolean isRenderedPnlForWithoutContract() {
		return renderedPnlForWithoutContract;
	}
	public void setRenderedPnlForWithoutContract(
			boolean renderedPnlForWithoutContract) {
		this.renderedPnlForWithoutContract = renderedPnlForWithoutContract;
	}
	public boolean isRenderedBtnNewVendor() {
		return renderedBtnNewVendor;
	}
	public void setRenderedBtnNewVendor(boolean renderedBtnNewVendor) {
		this.renderedBtnNewVendor = renderedBtnNewVendor;
	}
	public Mmm001AddressSP getVendorAddrObj() {
		if(vendorAddrObj == null){
			vendorAddrObj = new Mmm001AddressSP();
		}
		return vendorAddrObj;
	}
	public void setVendorAddrObj(Mmm001AddressSP vendorAddrObj) {
		this.vendorAddrObj = vendorAddrObj;
	}
	public Mmm001AddressSP getVendorSapAddrObj() {
		if(vendorSapAddrObj == null){
			vendorSapAddrObj = new Mmm001AddressSP();
		}
		return vendorSapAddrObj;
	}
	public void setVendorSapAddrObj(Mmm001AddressSP vendorSapAddrObj) {
		this.vendorSapAddrObj = vendorSapAddrObj;
	}
	public Mmm001AddressSP getVendorSemAddrObj() {
		if(vendorSemAddrObj == null){
			vendorSemAddrObj = new Mmm001AddressSP();
		}
		return vendorSemAddrObj;
	}
	public void setVendorSemAddrObj(Mmm001AddressSP vendorSemAddrObj) {
		this.vendorSemAddrObj = vendorSemAddrObj;
	}
	public Mmm001AddressSP getRentalAddrObj() {
		if(rentalAddrObj == null){
			rentalAddrObj = new Mmm001AddressSP();
		}
		return rentalAddrObj;
	}
	public void setRentalAddrObj(Mmm001AddressSP rentalAddrObj) {
		this.rentalAddrObj = rentalAddrObj;
	}
	public Mmm001AddressSP getElectrictAddrObj() {
		if(electrictAddrObj == null){
			electrictAddrObj = new Mmm001AddressSP();
		}
		return electrictAddrObj;
	}
	public void setElectrictAddrObj(Mmm001AddressSP electrictAddrObj) {
		this.electrictAddrObj = electrictAddrObj;
	}
	public Mmm001AddressSP getPropertyAddrObj() {
		if(propertyAddrObj == null){
			propertyAddrObj = new Mmm001AddressSP();
		}
		return propertyAddrObj;
	}
	public void setPropertyAddrObj(Mmm001AddressSP propertyAddrObj) {
		this.propertyAddrObj = propertyAddrObj;
	}
	public Mmm001AddressSP getInsureAddrObj() {
		if(insureAddrObj == null){
			insureAddrObj = new Mmm001AddressSP();
		}
		return insureAddrObj;
	}
	public void setInsureAddrObj(Mmm001AddressSP insureAddrObj) {
		this.insureAddrObj = insureAddrObj;
	}
	public Mmm001AddressSP getConstructAddrObj() {
		if(constructAddrObj == null){
			constructAddrObj = new Mmm001AddressSP();
		}
		return constructAddrObj;
	}
	public void setConstructAddrObj(Mmm001AddressSP constructAddrObj) {
		this.constructAddrObj = constructAddrObj;
	}
	public Mmm001AddressSP getWithholdAddrObj() {
		if(withholdAddrObj == null){
			withholdAddrObj = new Mmm001AddressSP();
		}
		return withholdAddrObj;
	}
	public void setWithholdAddrObj(Mmm001AddressSP withholdAddrObj) {
		this.withholdAddrObj = withholdAddrObj;
	}
	public Mmm001AddressSP getVendorAddrCmpObj() {
		if(vendorAddrCmpObj == null){
			vendorAddrCmpObj = new Mmm001AddressSP();
		}
		return vendorAddrCmpObj;
	}
	public void setVendorAddrCmpObj(Mmm001AddressSP vendorAddrCmpObj) {
		this.vendorAddrCmpObj = vendorAddrCmpObj;
	}
	public Mmm001AddressSP getRentalAddrCmpObj() {
		if(rentalAddrCmpObj == null){
			rentalAddrCmpObj = new Mmm001AddressSP();
		}
		return rentalAddrCmpObj;
	}
	public void setRentalAddrCmpObj(Mmm001AddressSP rentalAddrCmpObj) {
		this.rentalAddrCmpObj = rentalAddrCmpObj;
	}
	public Mmm001AddressSP getElectrictAddrCmpObj() {
		if(electrictAddrCmpObj == null){
			electrictAddrCmpObj = new Mmm001AddressSP();
		}
		return electrictAddrCmpObj;
	}
	public void setElectrictAddrCmpObj(Mmm001AddressSP electrictAddrCmpObj) {
		this.electrictAddrCmpObj = electrictAddrCmpObj;
	}
	public Mmm001AddressSP getPropertyAddrCmpObj() {
		if(propertyAddrCmpObj == null){
			propertyAddrCmpObj = new Mmm001AddressSP();
		}
		return propertyAddrCmpObj;
	}
	public void setPropertyAddrCmpObj(Mmm001AddressSP propertyAddrCmpObj) {
		this.propertyAddrCmpObj = propertyAddrCmpObj;
	}
	public Mmm001AddressSP getInsureAddrCmpObj() {
		if(insureAddrCmpObj == null){
			insureAddrCmpObj = new Mmm001AddressSP();
		}
		return insureAddrCmpObj;
	}
	public void setInsureAddrCmpObj(Mmm001AddressSP insureAddrCmpObj) {
		this.insureAddrCmpObj = insureAddrCmpObj;
	}
	public Mmm001AddressSP getConstructAddrCmpObj() {
		if(constructAddrCmpObj == null){
			constructAddrCmpObj = new Mmm001AddressSP();
		}
		return constructAddrCmpObj;
	}
	public void setConstructAddrCmpObj(Mmm001AddressSP constructAddrCmpObj) {
		this.constructAddrCmpObj = constructAddrCmpObj;
	}
	public Mmm001AddressSP getWithholdAddrCmpObj() {
		if(withholdAddrCmpObj == null){
			withholdAddrCmpObj = new Mmm001AddressSP();
		}
		return withholdAddrCmpObj;
	}
	public void setWithholdAddrCmpObj(Mmm001AddressSP withholdAddrCmpObj) {
		this.withholdAddrCmpObj = withholdAddrCmpObj;
	}
	
	public ItemResultSP getRetResultObj() {
		if(retResultObj == null){
			retResultObj = new ItemResultSP();
		}
		return retResultObj;
	}
	public void setRetResultObj(ItemResultSP retResultObj) {
		this.retResultObj = retResultObj;
	}
	public Mmm001VendorSP getVendorInfoCmpObj() {
		if(vendorInfoCmpObj == null){
			vendorInfoCmpObj = new Mmm001VendorSP();
		}
		return vendorInfoCmpObj;
	}
	public void setVendorInfoCmpObj(Mmm001VendorSP vendorInfoCmpObj) {
		this.vendorInfoCmpObj = vendorInfoCmpObj;
	}
	public Mmm001BookbankSP getBookbankInfoCmpObj() {
		if(bookbankInfoCmpObj == null){
			bookbankInfoCmpObj = new Mmm001BookbankSP();
		}
		return bookbankInfoCmpObj;
	}
	public void setBookbankInfoCmpObj(Mmm001BookbankSP bookbankInfoCmpObj) {
		this.bookbankInfoCmpObj = bookbankInfoCmpObj;
	}
	public Mmm001PayeeSP getPayeeInfoCmpObj() {
		if(payeeInfoCmpObj == null){
			payeeInfoCmpObj = new Mmm001PayeeSP();
		}
		return payeeInfoCmpObj;
	}
	public void setPayeeInfoCmpObj(Mmm001PayeeSP payeeInfoCmpObj) {
		this.payeeInfoCmpObj = payeeInfoCmpObj;
	}
	public Mmm001BookbankPayeeSP getBookbankPayeeInfoCmpObj() {
		if(bookbankPayeeInfoCmpObj == null){
			bookbankPayeeInfoCmpObj = new Mmm001BookbankPayeeSP();
		}
		return bookbankPayeeInfoCmpObj;
	}
	public void setBookbankPayeeInfoCmpObj(
			Mmm001BookbankPayeeSP bookbankPayeeInfoCmpObj) {
		this.bookbankPayeeInfoCmpObj = bookbankPayeeInfoCmpObj;
	}
	
	
	public ArrayList getSelectIdList() {
		return selectIdList;
	}
	public void setSelectIdList(ArrayList selectIdList) {
		this.selectIdList = selectIdList;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public String getFlowStatus() {
		return flowStatus;
	}
	public void setFlowStatus(String flowStatus) {
		this.flowStatus = flowStatus;
	}
	public String getRejectRemark() {
		return rejectRemark;
	}
	public void setRejectRemark(String rejectRemark) {
		this.rejectRemark = rejectRemark;
	}
	public TreeNode getRootNode() {
		return rootNode;
	}
	public void setRootNode(TreeNode rootNode) {
		this.rootNode = rootNode;
	}
	public List<MenuTreeSP> getMenuTreeList() {
		return menuTreeList;
	}
	public void setMenuTreeList(List<MenuTreeSP> menuTreeList) {
		this.menuTreeList = menuTreeList;
	}
	public List<WrapperBeanObject<MenuTreeSP>> getMenuTreeVendorList() {
		return menuTreeVendorList;
	}
	public void setMenuTreeVendorList(
			List<WrapperBeanObject<MenuTreeSP>> menuTreeVendorList) {
		this.menuTreeVendorList = menuTreeVendorList;
	}
	public List<WrapperBeanObject<MenuTreeSP>> getMenuTreeVendorBookbankList() {
		return menuTreeVendorBookbankList;
	}
	public void setMenuTreeVendorBookbankList(
			List<WrapperBeanObject<MenuTreeSP>> menuTreeVendorBookbankList) {
		this.menuTreeVendorBookbankList = menuTreeVendorBookbankList;
	}
	public List<WrapperBeanObject<MenuTreeSP>> getMenuTreePayeeList() {
		return menuTreePayeeList;
	}
	public void setMenuTreePayeeList(
			List<WrapperBeanObject<MenuTreeSP>> menuTreePayeeList) {
		this.menuTreePayeeList = menuTreePayeeList;
	}
	public List<WrapperBeanObject<MenuTreeSP>> getMenuTreePayeeBookbankList() {
		return menuTreePayeeBookbankList;
	}
	public void setMenuTreePayeeBookbankList(
			List<WrapperBeanObject<MenuTreeSP>> menuTreePayeeBookbankList) {
		this.menuTreePayeeBookbankList = menuTreePayeeBookbankList;
	}
	public List<WrapperBeanObject<MenuTreeSP>> getMenuTreeAbnormalList() {
		return menuTreeAbnormalList;
	}
	public void setMenuTreeAbnormalList(
			List<WrapperBeanObject<MenuTreeSP>> menuTreeAbnormalList) {
		this.menuTreeAbnormalList = menuTreeAbnormalList;
	}
	public boolean isRenderedTodoRejectButton() {
		return renderedTodoRejectButton;
	}
	public void setRenderedTodoRejectButton(boolean renderedTodoRejectButton) {
		this.renderedTodoRejectButton = renderedTodoRejectButton;
	}
	public String getParamUrl() {
		return paramUrl;
	}
	public void setParamUrl(String paramUrl) {
		this.paramUrl = paramUrl;
	}
	public String getParamMenuGroup() {
		return paramMenuGroup;
	}
	public void setParamMenuGroup(String paramMenuGroup) {
		this.paramMenuGroup = paramMenuGroup;
	}
	public List<SelectItem> getTeamList() {
		return teamList;
	}
	public void setTeamList(List<SelectItem> teamList) {
		this.teamList = teamList;
	}
	
	public boolean isRenderedEditColumn() {
		return renderedEditColumn;
	}
	public void setRenderedEditColumn(boolean renderedEditColumn) {
		this.renderedEditColumn = renderedEditColumn;
	}
	
	public Mmm001VendorSP getVendorInfoSap() {
		if(vendorInfoSap == null){
			vendorInfoSap = new Mmm001VendorSP();
		}
		return vendorInfoSap;
	}
	
	public void setVendorInfoSap(Mmm001VendorSP vendorInfoSap){
		this.vendorInfoSap = vendorInfoSap;
	}
	
	public Mmm001VendorSP getVendorInfoSem() {
		if(vendorInfoSem == null){
			vendorInfoSem = new Mmm001VendorSP();
		}
		return vendorInfoSem;
	}
	
	public void setVendorInfoSem(Mmm001VendorSP vendorInfoSem){
		this.vendorInfoSem = vendorInfoSem;
	}
	public Mmm001AddressSP getWithholdSapAddrObj() {
		if(withholdSapAddrObj == null){
			withholdSapAddrObj = new Mmm001AddressSP();
		}
		return withholdSapAddrObj;
	}
	public void setWithholdSapAddrObj(Mmm001AddressSP withholdSapAddrObj) {
		this.withholdSapAddrObj = withholdSapAddrObj;
	}
	public Mmm001AddressSP getWithholdSemAddrObj() {
		if(withholdSemAddrObj == null){
			withholdSemAddrObj = new Mmm001AddressSP();
		}
		return withholdSemAddrObj;
	}
	public void setWithholdSemAddrObj(Mmm001AddressSP withholdSemAddrObj) {
		this.withholdSemAddrObj = withholdSemAddrObj;
	}
	
	public String getGroupType() {
		return groupType;
	}
	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}
	public List<SelectItem> getCompanySemList() {
		if(companySemList == null) {
			companySemList = new ArrayList<SelectItem>();
		}
		return companySemList;
	}
	public void setCompanySemList(List<SelectItem> companySemList) {
		this.companySemList = companySemList;
	}
	public List<SelectItem> getExpenseTypeSemList() {
		if(expenseTypeSemList == null){
			expenseTypeSemList = new ArrayList<SelectItem>();
		}
		return expenseTypeSemList;
	}
	public void setExpenseTypeSemList(List<SelectItem> expenseTypeSemList) {
		this.expenseTypeSemList = expenseTypeSemList;
	}
	public List<SelectItem> getBankSemList() {
		if(bankSemList == null){
			bankSemList = new ArrayList<SelectItem>();
		}
		return bankSemList;
	}
	public void setBankSemList(List<SelectItem> bankSemList) {
		this.bankSemList = bankSemList;
	}
	public List<SelectItem> getVendorStatusSemList() {
		if(vendorStatusSemList == null){
			vendorStatusSemList = new ArrayList<SelectItem>();
		}
		return vendorStatusSemList;
	}
	public void setVendorStatusSemList(List<SelectItem> vendorStatusSemList) {
		this.vendorStatusSemList = vendorStatusSemList;
	}
	public List<SelectItem> getBookbankStatusSemList() {
		if(bookbankStatusSemList == null){
			bookbankStatusSemList = new ArrayList<SelectItem>();
		}
		return bookbankStatusSemList;
	}
	public void setBookbankStatusSemList(List<SelectItem> bookbankStatusSemList) {
		this.bookbankStatusSemList = bookbankStatusSemList;
	}
	public List<SelectItem> getPayeeStatusSemList() {
		if(payeeStatusSemList == null){
			payeeStatusSemList = new ArrayList<SelectItem>();
		}
		return payeeStatusSemList;
	}
	public void setPayeeStatusSemList(List<SelectItem> payeeStatusSemList) {
		this.payeeStatusSemList = payeeStatusSemList;
	}
	public List<SelectItem> getBookbankPayeeStatusSemList() {
		if(bookbankPayeeStatusSemList == null){
			bookbankPayeeStatusSemList = new ArrayList<SelectItem>();
		}
		return bookbankPayeeStatusSemList;
	}
	public void setBookbankPayeeStatusSemList(List<SelectItem> bookbankPayeeStatusSemList) {
		this.bookbankPayeeStatusSemList = bookbankPayeeStatusSemList;
	}
	public List<SelectItem> getVendorFlowStatusSemList() {
		if(vendorFlowStatusSemList == null){
			vendorFlowStatusSemList = new ArrayList<SelectItem>();
		}
		return vendorFlowStatusSemList;
	}
	public void setVendorFlowStatusSemList(List<SelectItem> vendorFlowStatusSemList) {
		this.vendorFlowStatusSemList = vendorFlowStatusSemList;
	}
	public List<SelectItem> getBookbankFlowStatusSemList() {
		if(bookbankFlowStatusSemList == null){
			bookbankFlowStatusSemList = new ArrayList<SelectItem>();
		}
		return bookbankFlowStatusSemList;
	}
	public void setBookbankFlowStatusSemList(List<SelectItem> bookbankFlowStatusSemList) {
		this.bookbankFlowStatusSemList = bookbankFlowStatusSemList;
	}
	public List<SelectItem> getPayeeFlowStatusSemList() {
		if(payeeFlowStatusSemList == null){
			payeeFlowStatusSemList = new ArrayList<SelectItem>();
		}
		return payeeFlowStatusSemList;
	}
	public void setPayeeFlowStatusSemList(List<SelectItem> payeeFlowStatusSemList) {
		this.payeeFlowStatusSemList = payeeFlowStatusSemList;
	}
	
	public List<SelectItem> getBookbankPayeeFlowStatusSemList() {
		return bookbankPayeeFlowStatusSemList;
	}
	public List<SelectItem> getTambolSemList() {
		if(tambolSemList == null){
			tambolSemList = new ArrayList<SelectItem>();
		}
		return tambolSemList;
	}
	public void setTambolSemList(List<SelectItem> tambolSemList) {
		this.tambolSemList = tambolSemList;
	}
	public List<SelectItem> getAmphurSemList() {
		if(amphurSemList == null){
			amphurSemList = new ArrayList<SelectItem>();
		}
		return amphurSemList;
	}
	public void setAmphurSemList(List<SelectItem> amphurSemList) {
		this.amphurSemList = amphurSemList;
	}
	public List<SelectItem> getProvinceSemList() {
		if(provinceSemList == null){
			provinceSemList = new ArrayList<SelectItem>();
		}
		return provinceSemList;
	}
	public void setProvinceSemList(List<SelectItem> provinceSemList) {
		this.provinceSemList = provinceSemList;
	}
	
	public List<SelectItem> getRegionSemList() {
		if(regionSemList == null){
			regionSemList = new ArrayList<SelectItem>();
		}
		return regionSemList;
	}
	public void setRegionSemList(List<SelectItem> regionSemList) {
		this.regionSemList = regionSemList;
	}
	public List<SelectItem> getActiveStatusSemList() {
		if(activeStatusSemList == null){
			activeStatusSemList = new ArrayList<SelectItem>();
		}
		return activeStatusSemList;
	}
	public void setActiveStatusSemList(List<SelectItem> activeStatusSemList) {
		this.activeStatusSemList = activeStatusSemList;
	}
	public List<SelectItem> getAccountTypeSemList() {
		if(accountTypeSemList == null){
			accountTypeSemList = new ArrayList<SelectItem>();
		}
		return accountTypeSemList;
	}
	public void setAccountTypeSemList(List<SelectItem> accountTypeSemList) {
		this.accountTypeSemList = accountTypeSemList;
	}
	public List<SelectItem> getBankBranchSemList() {
		if(bankBranchSemList == null){
			bankBranchSemList = new ArrayList<SelectItem>();
		}
		return bankBranchSemList;
	}
	public void setBankBranchSemList(List<SelectItem> bankBranchSemList) {
		this.bankBranchSemList = bankBranchSemList;
	}
	public List<SelectItem> getVendorTypeSemList() {
		if(vendorTypeSemList == null){
			vendorTypeSemList = new ArrayList<SelectItem>();
		}
		return vendorTypeSemList;
	}
	public void setVendorTypeSemList(List<SelectItem> vendorTypeSemList) {
		this.vendorTypeSemList = vendorTypeSemList;
	}
	public List<SelectItem> getVendorBlockStatusSemList() {
		if(vendorBlockStatusSemList == null){
			vendorBlockStatusSemList = new ArrayList<SelectItem>();
		}
		return vendorBlockStatusSemList;
	}
	public void setVendorBlockStatusSemList(List<SelectItem> vendorBlockStatusSemList) {
		this.vendorBlockStatusSemList = vendorBlockStatusSemList;
	}
	
	public String getSelectedSapTab() {
		return selectedSapTab;
	}
	public void setSelectedSapTab(String selectedSapTab) {
		this.selectedSapTab = selectedSapTab;
	}
	public String getSelectedSemTab() {
		return selectedSemTab;
	}
	public void setSelectedSemTab(String selectedSemTab) {
		this.selectedSemTab = selectedSemTab;
	}
	public Mmm001BookbankSP getBookbankSapInfo() {
		if(bookbankSapInfo == null){
			bookbankSapInfo = new Mmm001BookbankSP();
		}
		return bookbankSapInfo;
	}
	public void setBookbankSapInfo(Mmm001BookbankSP bookbankSapInfo) {
		this.bookbankSapInfo = bookbankSapInfo;
	}
	public Mmm001BookbankSP getBookbankSemInfo() {
		if(bookbankSemInfo == null){
			bookbankSemInfo = new Mmm001BookbankSP();
		}
		return bookbankSemInfo;
	}
	public void setBookbankSemInfo(Mmm001BookbankSP bookbankSemInfo) {
		this.bookbankSemInfo = bookbankSemInfo;
	}
	
	
	public List<WrapperBeanObject<Mmm001ContractHistory>> getContractHistoryList() {
		return contractHistoryList;
	}
	public void setContractHistoryList(
			List<WrapperBeanObject<Mmm001ContractHistory>> contractHistoryList) {
		this.contractHistoryList = contractHistoryList;
	}
	public List<WrapperBeanObject<Mmm001ContractPayHistory>> getContractPayHistoryList() {
		return contractPayHistoryList;
	}
	public void setContractPayHistoryList(
			List<WrapperBeanObject<Mmm001ContractPayHistory>> contractPayHistoryList) {
		this.contractPayHistoryList = contractPayHistoryList;
	}
	public void setBookbankPayeeFlowStatusSemList(
			List<SelectItem> bookbankPayeeFlowStatusSemList) {
		this.bookbankPayeeFlowStatusSemList = bookbankPayeeFlowStatusSemList;
	}
	
	public String getTotalSumVendor() {
		return totalSumVendor;
	}
	public void setTotalSumVendor(String totalSumVendor) {
		this.totalSumVendor = totalSumVendor;
	}
	public String getTotalSumVendorBookbank() {
		return totalSumVendorBookbank;
	}
	public void setTotalSumVendorBookbank(String totalSumVendorBookbank) {
		this.totalSumVendorBookbank = totalSumVendorBookbank;
	}
	public String getTotalSumPayee() {
		return totalSumPayee;
	}
	public void setTotalSumPayee(String totalSumPayee) {
		this.totalSumPayee = totalSumPayee;
	}
	public String getTotalSumPayeeBookbank() {
		return totalSumPayeeBookbank;
	}
	public void setTotalSumPayeeBookbank(String totalSumPayeeBookbank) {
		this.totalSumPayeeBookbank = totalSumPayeeBookbank;
	}
	public String getTotalSumAbnormal() {
		return totalSumAbnormal;
	}
	public void setTotalSumAbnormal(String totalSumAbnormal) {
		this.totalSumAbnormal = totalSumAbnormal;
	}
	
	public Bank getCriteriaBank() {
		return criteriaBank;
	}
	public void setCriteriaBank(Bank criteriaBank) {
		this.criteriaBank = criteriaBank;
	}
	public List<Bank> getBankSelList() {
		return bankSelList;
	}
	public void setBankSelList(List<Bank> bankSelList) {
		this.bankSelList = bankSelList;
	}
	public List<Bank> getBankTmpSelList() {
		return bankTmpSelList;
	}
	public void setBankTmpSelList(List<Bank> bankTmpSelList) {
		this.bankTmpSelList = bankTmpSelList;
	}
	public String getSelectedRadio() {
		return selectedRadio;
	}
	public void setSelectedRadio(String selectedRadio) {
		this.selectedRadio = selectedRadio;
	}
	
	public List<SelectItem> getProvinceBookbankList() {
		return provinceBookbankList;
	}
	public void setProvinceBookbankList(List<SelectItem> provinceBookbankList) {
		this.provinceBookbankList = provinceBookbankList;
	}
	
	public String getDoMode() {
		return doMode;
	}
	public void setDoMode(String doMode) {
		this.doMode = doMode;
	}
	public BankMasterSP getCriteriaBankMasterSP() {
		if(criteriaBankMasterSP == null) criteriaBankMasterSP = new BankMasterSP();
		return criteriaBankMasterSP;
	}
	public void setCriteriaBankMasterSP(BankMasterSP criteriaBankMasterSP) {
		this.criteriaBankMasterSP = criteriaBankMasterSP;
	}
	public BankMasterSP getPopupCriteriaBankMasterSP() {
		return popupCriteriaBankMasterSP;
	}
	public void setPopupCriteriaBankMasterSP(BankMasterSP popupCriteriaBankMasterSP) {
		this.popupCriteriaBankMasterSP = popupCriteriaBankMasterSP;
	}
	public BankMasterSP getItemBankMasterSP() {
		return itemBankMasterSP;
	}
	public void setItemBankMasterSP(BankMasterSP itemBankMasterSP) {
		this.itemBankMasterSP = itemBankMasterSP;
	}
	public BankMasterSP getBankSearchSelected() {
		return bankSearchSelected;
	}
	public void setBankSearchSelected(BankMasterSP bankSearchSelected) {
		this.bankSearchSelected = bankSearchSelected;
	}
	public Mmm001VendorSP getVendorInfoMissMatchWithSAPObj() {
		if(vendorInfoMissMatchWithSAPObj == null){
			vendorInfoMissMatchWithSAPObj = new Mmm001VendorSP();
		}
		return vendorInfoMissMatchWithSAPObj;
	}
	public void setVendorInfoMissMatchWithSAPObj(
			Mmm001VendorSP vendorInfoMissMatchWithSAPObj) {
		this.vendorInfoMissMatchWithSAPObj = vendorInfoMissMatchWithSAPObj;
	}
	public Mmm001BookbankSP getBookbankInfoMissMatchWithSAPObj() {
		if(bookbankInfoMissMatchWithSAPObj == null){
			bookbankInfoMissMatchWithSAPObj = new Mmm001BookbankSP();
		}
		return bookbankInfoMissMatchWithSAPObj;
	}
	public void setBookbankInfoMissMatchWithSAPObj(
			Mmm001BookbankSP bookbankInfoMissMatchWithSAPObj) {
		this.bookbankInfoMissMatchWithSAPObj = bookbankInfoMissMatchWithSAPObj;
	}
	public Mmm001ExpenseWithContractOfVendorSP getExpCntrctOfVndObj() {
		if(expCntrctOfVndObj == null){
			expCntrctOfVndObj = new Mmm001ExpenseWithContractOfVendorSP();
		}
		return expCntrctOfVndObj;
	}
	public void setExpCntrctOfVndObj(
			Mmm001ExpenseWithContractOfVendorSP expCntrctOfVndObj) {
		this.expCntrctOfVndObj = expCntrctOfVndObj;
	}
	
	public List<BankMasterSP> getBankMasterSlctList() {
		return bankMasterSlctList;
	}
	public void setBankMasterSlctList(List<BankMasterSP> bankMasterSlctList) {
		this.bankMasterSlctList = bankMasterSlctList;
	}
	public List<SelectItem> getBankSelectionSearchList() {
		return bankSelectionSearchList;
	}
	public void setBankSelectionSearchList(List<SelectItem> bankSelectionSearchList) {
		this.bankSelectionSearchList = bankSelectionSearchList;
	}
	public List<SelectItem> getBankCodeList() {
		return bankCodeList;
	}
	public void setBankCodeList(List<SelectItem> bankCodeList) {
		this.bankCodeList = bankCodeList;
	}
	public List<SelectItem> getBankNameList() {
		return bankNameList;
	}
	public void setBankNameList(List<SelectItem> bankNameList) {
		this.bankNameList = bankNameList;
	}
	
	public boolean isChkForEdit() {
		return chkForEdit;
	}
	public void setChkForEdit(boolean chkForEdit) {
		this.chkForEdit = chkForEdit;
	}
	public boolean isDisbledDialogField() {
		return disbledDialogField;
	}
	public void setDisbledDialogField(boolean disbledDialogField) {
		this.disbledDialogField = disbledDialogField;
	}
	
	public String getNavPrograme() {
		return navPrograme;
	}
	public void setNavPrograme(String navPrograme) {
		this.navPrograme = navPrograme;
	}
	
	public boolean isDisplayReport() {
		return displayReport;
	}
	public void setDisplayReport(boolean displayReport) {
		this.displayReport = displayReport;
	}
	public List<CT001ExportBank> getCt001ExBankList() {
		return ct001ExBankList;
	}
	public void setCt001ExBankList(List<CT001ExportBank> ct001ExBankList) {
		this.ct001ExBankList = ct001ExBankList;
	}
	
	public String getTmpBatch() {
		return tmpBatch;
	}
	public void setTmpBatch(String tmpBatch) {
		this.tmpBatch = tmpBatch;
	}
	public Date getTmpBatchDT() {
		return tmpBatchDT;
	}
	public void setTmpBatchDT(Date tmpBatchDT) {
		this.tmpBatchDT = tmpBatchDT;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Mmm001ContractSP getContractInfoHist() {
		return contractInfoHist;
	}
	public void setContractInfoHist(Mmm001ContractSP contractInfoHist) {
		this.contractInfoHist = contractInfoHist;
	}
	public Mmm001VendorSP getVendorInfoHist() {
		return vendorInfoHist;
	}
	public void setVendorInfoHist(Mmm001VendorSP vendorInfoHist) {
		this.vendorInfoHist = vendorInfoHist;
	}
	public Mmm001PayeeSP getPayeeInfoHist() {
		return payeeInfoHist;
	}
	public void setPayeeInfoHist(Mmm001PayeeSP payeeInfoHist) {
		this.payeeInfoHist = payeeInfoHist;
	}
	public Mmm001BookbankSP getBookbankInfoHist() {
		return bookbankInfoHist;
	}
	public void setBookbankInfoHist(Mmm001BookbankSP bookbankInfoHist) {
		this.bookbankInfoHist = bookbankInfoHist;
	}
	public Mmm001BookbankPayeeSP getBookbankPayeeInfoHist() {
		return bookbankPayeeInfoHist;
	}
	public void setBookbankPayeeInfoHist(Mmm001BookbankPayeeSP bookbankPayeeInfoHist) {
		this.bookbankPayeeInfoHist = bookbankPayeeInfoHist;
	}
	public List<WrapperBeanObject<Mmm001VendorContractSP>> getVendorContractHistList() {
		return vendorContractHistList;
	}
	public void setVendorContractHistList(
			List<WrapperBeanObject<Mmm001VendorContractSP>> vendorContractHistList) {
		this.vendorContractHistList = vendorContractHistList;
	}
	public List<WrapperBeanObject<Mmm001BookbankSP>> getBookbankHistList() {
		return bookbankHistList;
	}
	public void setBookbankHistList(
			List<WrapperBeanObject<Mmm001BookbankSP>> bookbankHistList) {
		this.bookbankHistList = bookbankHistList;
	}
	public List<WrapperBeanObject<Mmm001PayeeSP>> getPayeeHistList() {
		return payeeHistList;
	}
	public void setPayeeHistList(
			List<WrapperBeanObject<Mmm001PayeeSP>> payeeHistList) {
		this.payeeHistList = payeeHistList;
	}
	public List<WrapperBeanObject<Mmm001BookbankPayeeSP>> getBookbankPayeeHistList() {
		return bookbankPayeeHistList;
	}
	public void setBookbankPayeeHistList(
			List<WrapperBeanObject<Mmm001BookbankPayeeSP>> bookbankPayeeHistList) {
		this.bookbankPayeeHistList = bookbankPayeeHistList;
	}
	public List<WrapperBeanObject<Mmm001ContractSP>> getContractHistList() {
		return contractHistList;
	}
	public void setContractHistList(
			List<WrapperBeanObject<Mmm001ContractSP>> contractHistList) {
		this.contractHistList = contractHistList;
	}
	public List<WrapperBeanObject<Mmm001PaymentSP>> getPaymentHistList() {
		return paymentHistList;
	}
	public void setPaymentHistList(
			List<WrapperBeanObject<Mmm001PaymentSP>> paymentHistList) {
		this.paymentHistList = paymentHistList;
	}
	
	public boolean isRenderedPanelVendor() {
		return renderedPanelVendor;
	}
	public void setRenderedPanelVendor(boolean renderedPanelVendor) {
		this.renderedPanelVendor = renderedPanelVendor;
	}
	
	public boolean isRenderedBtnBack() {
		return renderedBtnBack;
	}
	public void setRenderedBtnBack(boolean renderedBtnBack) {
		this.renderedBtnBack = renderedBtnBack;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	public String getBookbankId() {
		return bookbankId;
	}
	public void setBookbankId(String bookbankId) {
		this.bookbankId = bookbankId;
	}
	public String getPayeeId() {
		return payeeId;
	}
	public void setPayeeId(String payeeId) {
		this.payeeId = payeeId;
	}
	public String getBookbankPayeeId() {
		return bookbankPayeeId;
	}
	public void setBookbankPayeeId(String bookbankPayeeId) {
		this.bookbankPayeeId = bookbankPayeeId;
	}
	public String getHistoryPage() {
		return historyPage;
	}
	public void setHistoryPage(String historyPage) {
		this.historyPage = historyPage;
	}
	
	public String getBackButtonFlag() {
		return backButtonFlag;
	}
	public void setBackButtonFlag(String backButtonFlag) {
		this.backButtonFlag = backButtonFlag;
	}
	
	public boolean isChkVendorType() {
		return chkVendorType;
	}
	public void setChkVendorType(boolean chkVendorType) {
		this.chkVendorType = chkVendorType;
	}
	public boolean isChkPayeeType() {
		return chkPayeeType;
	}
	public void setChkPayeeType(boolean chkPayeeType) {
		this.chkPayeeType = chkPayeeType;
	}
	public List<SelectItem> getBlockStatusList() {
		if(blockStatusList == null){
			blockStatusList = new ArrayList<SelectItem>();
		}
		return blockStatusList;
	}
	public void setBlockStatusList(List<SelectItem> blockStatusList) {
		this.blockStatusList = blockStatusList;
	}
	public List<SelectItem> getBlackListStatusList() {
		if(blackListStatusList == null){
			blackListStatusList = new ArrayList<SelectItem>();
		}
		return blackListStatusList;
	}
	public void setBlackListStatusList(List<SelectItem> blackListStatusList) {
		this.blackListStatusList = blackListStatusList;
	}
	
	public boolean isRenderedBtnTodoBack() {
		return renderedBtnTodoBack;
	}
	public void setRenderedBtnTodoBack(boolean renderedBtnTodoBack) {
		this.renderedBtnTodoBack = renderedBtnTodoBack;
	}
	public String getNavProgramBack() {
		return navProgramBack;
	}
	public void setNavProgramBack(String navProgramBack) {
		this.navProgramBack = navProgramBack;
	}
	public String getActionWithNaviBack() {
		return actionWithNaviBack;
	}
	public void setActionWithNaviBack(String actionWithNaviBack) {
		this.actionWithNaviBack = actionWithNaviBack;
	}
	public String getMethodWithNaviBack() {
		return methodWithNaviBack;
	}
	public void setMethodWithNaviBack(String methodWithNaviBack) {
		this.methodWithNaviBack = methodWithNaviBack;
	}
	
	public String getTodoManagerFlag() {
		return todoManagerFlag;
	}
	public void setTodoManagerFlag(String todoManagerFlag) {
		this.todoManagerFlag = todoManagerFlag;
	}
	
	
	public boolean isDisableBtnClearBatch() {
		return isDisableBtnClearBatch;
	}
	public void setDisableBtnClearBatch(boolean isDisableBtnClearBatch) {
		this.isDisableBtnClearBatch = isDisableBtnClearBatch;
	}
	public boolean isDisableBtnCancel() {
		return isDisableBtnCancel;
	}
	public void setDisableBtnCancel(boolean isDisableBtnCancel) {
		this.isDisableBtnCancel = isDisableBtnCancel;
	}
	public boolean isVendorBlockStatus() {
		return vendorBlockStatus;
	}
	public void setVendorBlockStatus(boolean vendorBlockStatus) {
		this.vendorBlockStatus = vendorBlockStatus;
	}
	public boolean isVendorBlackListStatus() {
		return vendorBlackListStatus;
	}
	public void setVendorBlackListStatus(boolean vendorBlackListStatus) {
		this.vendorBlackListStatus = vendorBlackListStatus;
	}
	public boolean isNotPayeeFlag() {
		return notPayeeFlag;
	}
	public void setNotPayeeFlag(boolean notPayeeFlag) {
		this.notPayeeFlag = notPayeeFlag;
	}
	public boolean isOtherExpenseFlag() {
		return otherExpenseFlag;
	}
	public void setOtherExpenseFlag(boolean otherExpenseFlag) {
		this.otherExpenseFlag = otherExpenseFlag;
	}
	public boolean isVendorCmpBlockStatus() {
		return vendorCmpBlockStatus;
	}
	public void setVendorCmpBlockStatus(boolean vendorCmpBlockStatus) {
		this.vendorCmpBlockStatus = vendorCmpBlockStatus;
	}
	public boolean isVendorCmpBlackListStatus() {
		return vendorCmpBlackListStatus;
	}
	public void setVendorCmpBlackListStatus(boolean vendorCmpBlackListStatus) {
		this.vendorCmpBlackListStatus = vendorCmpBlackListStatus;
	}
	public boolean isNotPayeeCmpFlag() {
		return notPayeeCmpFlag;
	}
	public void setNotPayeeCmpFlag(boolean notPayeeCmpFlag) {
		this.notPayeeCmpFlag = notPayeeCmpFlag;
	}
	public boolean isOtherExpenseCmpFlag() {
		return otherExpenseCmpFlag;
	}
	public void setOtherExpenseCmpFlag(boolean otherExpenseCmpFlag) {
		this.otherExpenseCmpFlag = otherExpenseCmpFlag;
	}
	public boolean isRenderedBtnSelectVendorCont() {
		return renderedBtnSelectVendorCont;
	}
	public void setRenderedBtnSelectVendorCont(boolean renderedBtnSelectVendorCont) {
		this.renderedBtnSelectVendorCont = renderedBtnSelectVendorCont;
	}
	public String getVendorContFlag() {
		return vendorContFlag;
	}
	public void setVendorContFlag(String vendorContFlag) {
		this.vendorContFlag = vendorContFlag;
	}
	public Mmm001VendorSP getChangeVendorCriteria() {
		return changeVendorCriteria;
	}
	public void setChangeVendorCriteria(Mmm001VendorSP changeVendorCriteria) {
		this.changeVendorCriteria = changeVendorCriteria;
	}
	public boolean isRenderedBtnCloseVendor() {
		return renderedBtnCloseVendor;
	}
	public void setRenderedBtnCloseVendor(boolean renderedBtnCloseVendor) {
		this.renderedBtnCloseVendor = renderedBtnCloseVendor;
	}
	public boolean isRenderedBtnOKVendor() {
		return renderedBtnOKVendor;
	}
	public void setRenderedBtnOKVendor(boolean renderedBtnOKVendor) {
		this.renderedBtnOKVendor = renderedBtnOKVendor;
	}
	public boolean isRenderedBtnCencelVendor() {
		return renderedBtnCencelVendor;
	}
	public void setRenderedBtnCencelVendor(boolean renderedBtnCencelVendor) {
		this.renderedBtnCencelVendor = renderedBtnCencelVendor;
	}
	public boolean isRenderedBtnYesVendor() {
		return renderedBtnYesVendor;
	}
	public void setRenderedBtnYesVendor(boolean renderedBtnYesVendor) {
		this.renderedBtnYesVendor = renderedBtnYesVendor;
	}
	public boolean isRenderedBtnNoVendor() {
		return renderedBtnNoVendor;
	}
	public void setRenderedBtnNoVendor(boolean renderedBtnNoVendor) {
		this.renderedBtnNoVendor = renderedBtnNoVendor;
	}
	public List<WrapperBeanObject<Mmm001BookbankSP>> getBookbankActiveList() {
		if(bookbankActiveList == null){
			bookbankActiveList = new ArrayList<WrapperBeanObject<Mmm001BookbankSP>>();
		}
		return bookbankActiveList;
	}
	public void setBookbankActiveList(List<WrapperBeanObject<Mmm001BookbankSP>> bookbankActiveList) {
		this.bookbankActiveList = bookbankActiveList;
	}
	public List<WrapperBeanObject<Mmm001BookbankSP>> getBookbankInactiveList() {
		if(bookbankInactiveList == null){
			bookbankInactiveList = new ArrayList<WrapperBeanObject<Mmm001BookbankSP>>();
		}
		return bookbankInactiveList;
	}
	public void setBookbankInactiveList(List<WrapperBeanObject<Mmm001BookbankSP>> bookbankInactiveList) {
		this.bookbankInactiveList = bookbankInactiveList;
	}
	public List<WrapperBeanObject<Mmm001BookbankPayeeSP>> getBookbankPayeeActiveList() {
		if(bookbankPayeeActiveList == null){
			bookbankPayeeActiveList = new ArrayList<WrapperBeanObject<Mmm001BookbankPayeeSP>>();
		}
		return bookbankPayeeActiveList;
	}
	public void setBookbankPayeeActiveList(
			List<WrapperBeanObject<Mmm001BookbankPayeeSP>> bookbankPayeeActiveList) {
		this.bookbankPayeeActiveList = bookbankPayeeActiveList;
	}
	public List<WrapperBeanObject<Mmm001BookbankPayeeSP>> getBookbankPayeeInactiveList() {
		if(bookbankPayeeInactiveList == null){
			bookbankPayeeInactiveList = new ArrayList<WrapperBeanObject<Mmm001BookbankPayeeSP>>();
		}
		return bookbankPayeeInactiveList;
	}
	public void setBookbankPayeeInactiveList(
			List<WrapperBeanObject<Mmm001BookbankPayeeSP>> bookbankPayeeInactiveList) {
		this.bookbankPayeeInactiveList = bookbankPayeeInactiveList;
	}
	public String getPayeeSelectedRowIndex() {
		return payeeSelectedRowIndex;
	}
	public void setPayeeSelectedRowIndex(String payeeSelectedRowIndex) {
		this.payeeSelectedRowIndex = payeeSelectedRowIndex;
	}
	public String getPayeeSelectedTab() {
		return payeeSelectedTab;
	}
	public void setPayeeSelectedTab(String payeeSelectedTab) {
		this.payeeSelectedTab = payeeSelectedTab;
	}
	public String getPayeeTabNo() {
		return payeeTabNo;
	}
	public void setPayeeTabNo(String payeeTabNo) {
		this.payeeTabNo = payeeTabNo;
	}
	public String getPayeeSelectedSapTab() {
		return payeeSelectedSapTab;
	}
	public void setPayeeSelectedSapTab(String payeeSelectedSapTab) {
		this.payeeSelectedSapTab = payeeSelectedSapTab;
	}
	public String getPayeeSelectedSemTab() {
		return payeeSelectedSemTab;
	}
	public void setPayeeSelectedSemTab(String payeeSelectedSemTab) {
		this.payeeSelectedSemTab = payeeSelectedSemTab;
	}
	
	public Mmm001AddressSP getPayeeAddrObj() {
		if(payeeAddrObj == null){
			payeeAddrObj = new Mmm001AddressSP();
		}
		return payeeAddrObj;
	}
	public void setPayeeAddrObj(Mmm001AddressSP payeeAddrObj) {
		this.payeeAddrObj = payeeAddrObj;
	}
	public Mmm001AddressSP getRentalPayeeAddrObj() {
		if(rentalPayeeAddrObj == null){
			rentalPayeeAddrObj = new Mmm001AddressSP();
		}
		return rentalPayeeAddrObj;
	}
	public void setRentalPayeeAddrObj(Mmm001AddressSP rentalPayeeAddrObj) {
		this.rentalPayeeAddrObj = rentalPayeeAddrObj;
	}
	public Mmm001AddressSP getElectrictPayeeAddrObj() {
		if(electrictPayeeAddrObj == null){
			electrictPayeeAddrObj = new Mmm001AddressSP();
		}
		return electrictPayeeAddrObj;
	}
	public void setElectrictPayeeAddrObj(Mmm001AddressSP electrictPayeeAddrObj) {
		this.electrictPayeeAddrObj = electrictPayeeAddrObj;
	}
	public Mmm001AddressSP getPropertyPayeeAddrObj() {
		if(propertyPayeeAddrObj == null){
			propertyPayeeAddrObj = new Mmm001AddressSP();
		}
		return propertyPayeeAddrObj;
	}
	public void setPropertyPayeeAddrObj(Mmm001AddressSP propertyPayeeAddrObj) {
		this.propertyPayeeAddrObj = propertyPayeeAddrObj;
	}
	
	public Mmm001AddressSP getInsurePayeeAddrObj() {
		if(insurePayeeAddrObj == null){
			insurePayeeAddrObj = new Mmm001AddressSP();
		}
		return insurePayeeAddrObj;
	}
	public void setInsurePayeeAddrObj(Mmm001AddressSP insurePayeeAddrObj) {
		this.insurePayeeAddrObj = insurePayeeAddrObj;
	}
	public Mmm001AddressSP getConstructPayeeAddrObj() {
		if(constructPayeeAddrObj == null){
			constructPayeeAddrObj = new Mmm001AddressSP();
		}
		return constructPayeeAddrObj;
	}
	public void setConstructPayeeAddrObj(Mmm001AddressSP constructPayeeAddrObj) {
		this.constructPayeeAddrObj = constructPayeeAddrObj;
	}
	public Mmm001AddressSP getWithholdPayeeAddrObj() {
		if(withholdPayeeAddrObj == null){
			withholdPayeeAddrObj = new Mmm001AddressSP();
		}
		return withholdPayeeAddrObj;
	}
	public void setWithholdPayeeAddrObj(Mmm001AddressSP withholdPayeeAddrObj) {
		this.withholdPayeeAddrObj = withholdPayeeAddrObj;
	}
	public Mmm001PayeeSP getChangePayeeCriteria() {
		return changePayeeCriteria;
	}
	public void setChangePayeeCriteria(Mmm001PayeeSP changePayeeCriteria) {
		this.changePayeeCriteria = changePayeeCriteria;
	}
	public boolean isRenderedBtnNewAllVendor() {
		return renderedBtnNewAllVendor;
	}
	public void setRenderedBtnNewAllVendor(boolean renderedBtnNewAllVendor) {
		this.renderedBtnNewAllVendor = renderedBtnNewAllVendor;
	}
	public boolean isRenderedBtnNewVendorDetail() {
		return renderedBtnNewVendorDetail;
	}
	public void setRenderedBtnNewVendorDetail(boolean renderedBtnNewVendorDetail) {
		this.renderedBtnNewVendorDetail = renderedBtnNewVendorDetail;
	}
	public boolean isRenderedBtnSelectVendor() {
		return renderedBtnSelectVendor;
	}
	public void setRenderedBtnSelectVendor(boolean renderedBtnSelectVendor) {
		this.renderedBtnSelectVendor = renderedBtnSelectVendor;
	}
	public boolean isDisableBtnChangeVendor() {
		return disableBtnChangeVendor;
	}
	public void setDisableBtnChangeVendor(boolean disableBtnChangeVendor) {
		this.disableBtnChangeVendor = disableBtnChangeVendor;
	}
	public boolean isDisableExportBatchVD() {
		return disableExportBatchVD;
	}
	public void setDisableExportBatchVD(boolean disableExportBatchVD) {
		this.disableExportBatchVD = disableExportBatchVD;
	}
	public boolean isDisableClearBatchVD() {
		return disableClearBatchVD;
	}
	public void setDisableClearBatchVD(boolean disableClearBatchVD) {
		this.disableClearBatchVD = disableClearBatchVD;
	}
	public boolean isDisableCancel() {
		return disableCancel;
	}
	public void setDisableCancel(boolean disableCancel) {
		this.disableCancel = disableCancel;
	}
	public boolean isDisableDeleteVD() {
		return disableDeleteVD;
	}
	public void setDisableDeleteVD(boolean disableDeleteVD) {
		this.disableDeleteVD = disableDeleteVD;
	}
	public boolean isRenderedBtnNewAllVB() {
		return renderedBtnNewAllVB;
	}
	public void setRenderedBtnNewAllVB(boolean renderedBtnNewAllVB) {
		this.renderedBtnNewAllVB = renderedBtnNewAllVB;
	}
	public boolean isRenderedBtnNewVBDetail() {
		return renderedBtnNewVBDetail;
	}
	public void setRenderedBtnNewVBDetail(boolean renderedBtnNewVBDetail) {
		this.renderedBtnNewVBDetail = renderedBtnNewVBDetail;
	}
	public boolean isRenderedBtnSelectVB() {
		return renderedBtnSelectVB;
	}
	public void setRenderedBtnSelectVB(boolean renderedBtnSelectVB) {
		this.renderedBtnSelectVB = renderedBtnSelectVB;
	}
	public boolean isDisableBtnChangeVB() {
		return disableBtnChangeVB;
	}
	public void setDisableBtnChangeVB(boolean disableBtnChangeVB) {
		this.disableBtnChangeVB = disableBtnChangeVB;
	}
	public boolean isDisableExportBatchVB() {
		return disableExportBatchVB;
	}
	public void setDisableExportBatchVB(boolean disableExportBatchVB) {
		this.disableExportBatchVB = disableExportBatchVB;
	}
	public boolean isDisableClearBatchVB() {
		return disableClearBatchVB;
	}
	public void setDisableClearBatchVB(boolean disableClearBatchVB) {
		this.disableClearBatchVB = disableClearBatchVB;
	}
	public boolean isDisableCancelVB() {
		return disableCancelVB;
	}
	public void setDisableCancelVB(boolean disableCancelVB) {
		this.disableCancelVB = disableCancelVB;
	}
	public boolean isDisableDeleteVB() {
		return disableDeleteVB;
	}
	public void setDisableDeleteVB(boolean disableDeleteVB) {
		this.disableDeleteVB = disableDeleteVB;
	}
	public boolean isRenderedBtnNewAllPY() {
		return renderedBtnNewAllPY;
	}
	public void setRenderedBtnNewAllPY(boolean renderedBtnNewAllPY) {
		this.renderedBtnNewAllPY = renderedBtnNewAllPY;
	}
	public boolean isRenderedBtnNewPYDetail() {
		return renderedBtnNewPYDetail;
	}
	public void setRenderedBtnNewPYDetail(boolean renderedBtnNewPYDetail) {
		this.renderedBtnNewPYDetail = renderedBtnNewPYDetail;
	}
	public boolean isRenderedBtnSelectPY() {
		return renderedBtnSelectPY;
	}
	public void setRenderedBtnSelectPY(boolean renderedBtnSelectPY) {
		this.renderedBtnSelectPY = renderedBtnSelectPY;
	}
	public boolean isDisableBtnChangePY() {
		return disableBtnChangePY;
	}
	public void setDisableBtnChangePY(boolean disableBtnChangePY) {
		this.disableBtnChangePY = disableBtnChangePY;
	}
	public boolean isDisableExportBatchPY() {
		return disableExportBatchPY;
	}
	public void setDisableExportBatchPY(boolean disableExportBatchPY) {
		this.disableExportBatchPY = disableExportBatchPY;
	}
	public boolean isDisableClearBatchPY() {
		return disableClearBatchPY;
	}
	public void setDisableClearBatchPY(boolean disableClearBatchPY) {
		this.disableClearBatchPY = disableClearBatchPY;
	}
	public boolean isDisableCancelPY() {
		return disableCancelPY;
	}
	public void setDisableCancelPY(boolean disableCancelPY) {
		this.disableCancelPY = disableCancelPY;
	}
	public boolean isDisableDeletePY() {
		return disableDeletePY;
	}
	public void setDisableDeletePY(boolean disableDeletePY) {
		this.disableDeletePY = disableDeletePY;
	}
	public boolean isRenderedBtnNewAllPB() {
		return renderedBtnNewAllPB;
	}
	public void setRenderedBtnNewAllPB(boolean renderedBtnNewAllPB) {
		this.renderedBtnNewAllPB = renderedBtnNewAllPB;
	}
	public boolean isRenderedBtnNewPBDetail() {
		return renderedBtnNewPBDetail;
	}
	public void setRenderedBtnNewPBDetail(boolean renderedBtnNewPBDetail) {
		this.renderedBtnNewPBDetail = renderedBtnNewPBDetail;
	}
	public boolean isRenderedBtnSelectPB() {
		return renderedBtnSelectPB;
	}
	public void setRenderedBtnSelectPB(boolean renderedBtnSelectPB) {
		this.renderedBtnSelectPB = renderedBtnSelectPB;
	}
	public boolean isDisableBtnChangePB() {
		return disableBtnChangePB;
	}
	public void setDisableBtnChangePB(boolean disableBtnChangePB) {
		this.disableBtnChangePB = disableBtnChangePB;
	}
	public boolean isDisableExportBatchPB() {
		return disableExportBatchPB;
	}
	public void setDisableExportBatchPB(boolean disableExportBatchPB) {
		this.disableExportBatchPB = disableExportBatchPB;
	}
	public boolean isDisableClearBatchPB() {
		return disableClearBatchPB;
	}
	public void setDisableClearBatchPB(boolean disableClearBatchPB) {
		this.disableClearBatchPB = disableClearBatchPB;
	}
	public boolean isDisableCancelPB() {
		return disableCancelPB;
	}
	public void setDisableCancelPB(boolean disableCancelPB) {
		this.disableCancelPB = disableCancelPB;
	}
	public boolean isDisableDeletePB() {
		return disableDeletePB;
	}
	public void setDisableDeletePB(boolean disableDeletePB) {
		this.disableDeletePB = disableDeletePB;
	}
	public boolean isDisableBtnselectContract() {
		return disableBtnselectContract;
	}
	public void setDisableBtnselectContract(boolean disableBtnselectContract) {
		this.disableBtnselectContract = disableBtnselectContract;
	}
	public boolean isRenderedcolumnEditContractVendor() {
		return renderedcolumnEditContractVendor;
	}
	public void setRenderedcolumnEditContractVendor(
			boolean renderedcolumnEditContractVendor) {
		this.renderedcolumnEditContractVendor = renderedcolumnEditContractVendor;
	}
	public boolean isDisableBtnNewPayeeVD() {
		return disableBtnNewPayeeVD;
	}
	public void setDisableBtnNewPayeeVD(boolean disableBtnNewPayeeVD) {
		this.disableBtnNewPayeeVD = disableBtnNewPayeeVD;
	}
	public boolean isRenderedColumnDeletePayeeVD() {
		return renderedColumnDeletePayeeVD;
	}
	public void setRenderedColumnDeletePayeeVD(boolean renderedColumnDeletePayeeVD) {
		this.renderedColumnDeletePayeeVD = renderedColumnDeletePayeeVD;
	}
	public boolean isRenderedColumnDeleteBookbankVendorVD() {
		return renderedColumnDeleteBookbankVendorVD;
	}
	public void setRenderedColumnDeleteBookbankVendorVD(
			boolean renderedColumnDeleteBookbankVendorVD) {
		this.renderedColumnDeleteBookbankVendorVD = renderedColumnDeleteBookbankVendorVD;
	}
	public boolean isDisableBtnNewBookbankVD() {
		return disableBtnNewBookbankVD;
	}
	public void setDisableBtnNewBookbankVD(boolean disableBtnNewBookbankVD) {
		this.disableBtnNewBookbankVD = disableBtnNewBookbankVD;
	}
	public List<WrapperBeanObject<MenuTreeSP>> getMenuTreeCreateByList() {
		return menuTreeCreateByList;
	}
	public void setMenuTreeCreateByList(
			List<WrapperBeanObject<MenuTreeSP>> menuTreeCreateByList) {
		this.menuTreeCreateByList = menuTreeCreateByList;
	}
	public String getTotalSumCreateBy() {
		return totalSumCreateBy;
	}
	public void setTotalSumCreateBy(String totalSumCreateBy) {
		this.totalSumCreateBy = totalSumCreateBy;
	}
	public Mmm001VendorSP getVendorInfoHistSummary() {
		return vendorInfoHistSummary;
	}
	public void setVendorInfoHistSummary(Mmm001VendorSP vendorInfoHistSummary) {
		this.vendorInfoHistSummary = vendorInfoHistSummary;
	}
	public Mmm001VendorMasterSP getVendorInfoBackParam() {
		return vendorInfoBackParam;
	}
	public void setVendorInfoBackParam(Mmm001VendorMasterSP vendorInfoBackParam) {
		this.vendorInfoBackParam = vendorInfoBackParam;
	}
	public boolean isHistoryFlag() {
		return historyFlag;
	}
	public void setHistoryFlag(boolean historyFlag) {
		this.historyFlag = historyFlag;
	}
	public List<WrapperBeanObject<Mmm001VendorPayHistSP>> getRtPaymentHistoryList() {
		return rtPaymentHistoryList;
	}
	public void setRtPaymentHistoryList(
			List<WrapperBeanObject<Mmm001VendorPayHistSP>> rtPaymentHistoryList) {
		this.rtPaymentHistoryList = rtPaymentHistoryList;
	}
	public List<WrapperBeanObject<Mmm001VendorPayHistSP>> getElPaymentHistoryList() {
		return elPaymentHistoryList;
	}
	public void setElPaymentHistoryList(
			List<WrapperBeanObject<Mmm001VendorPayHistSP>> elPaymentHistoryList) {
		this.elPaymentHistoryList = elPaymentHistoryList;
	}
	public List<WrapperBeanObject<Mmm001VendorPayHistSP>> getPtPaymentHistoryList() {
		return ptPaymentHistoryList;
	}
	public void setPtPaymentHistoryList(
			List<WrapperBeanObject<Mmm001VendorPayHistSP>> ptPaymentHistoryList) {
		this.ptPaymentHistoryList = ptPaymentHistoryList;
	}
	public List<WrapperBeanObject<Mmm001VendorPayHistSP>> getIrPaymentHistoryList() {
		return irPaymentHistoryList;
	}
	public void setIrPaymentHistoryList(
			List<WrapperBeanObject<Mmm001VendorPayHistSP>> irPaymentHistoryList) {
		this.irPaymentHistoryList = irPaymentHistoryList;
	}
	public List<WrapperBeanObject<Mmm001VendorPayHistSP>> getCtPaymentHistoryList() {
		return ctPaymentHistoryList;
	}
	public void setCtPaymentHistoryList(
			List<WrapperBeanObject<Mmm001VendorPayHistSP>> ctPaymentHistoryList) {
		this.ctPaymentHistoryList = ctPaymentHistoryList;
	}
	public List<WrapperBeanObject<Mmm001VendorSP>> getVendorInfoHistSummaryList() {
		if(vendorInfoHistSummaryList == null){
			vendorInfoHistSummaryList = new ArrayList<WrapperBeanObject<Mmm001VendorSP>>();
		}
		return vendorInfoHistSummaryList;
	}
	public void setVendorInfoHistSummaryList(
			List<WrapperBeanObject<Mmm001VendorSP>> vendorInfoHistSummaryList) {
		this.vendorInfoHistSummaryList = vendorInfoHistSummaryList;
	}
	public Mmm001AddressSP getVendorAddrHistObj() {
		return vendorAddrHistObj;
	}
	public void setVendorAddrHistObj(Mmm001AddressSP vendorAddrHistObj) {
		this.vendorAddrHistObj = vendorAddrHistObj;
	}
	public Mmm001AddressSP getRentalAddrHistObj() {
		return rentalAddrHistObj;
	}
	public void setRentalAddrHistObj(Mmm001AddressSP rentalAddrHistObj) {
		this.rentalAddrHistObj = rentalAddrHistObj;
	}
	public Mmm001AddressSP getElectrictAddrHistObj() {
		return electrictAddrHistObj;
	}
	public void setElectrictAddrHistObj(Mmm001AddressSP electrictAddrHistObj) {
		this.electrictAddrHistObj = electrictAddrHistObj;
	}
	public Mmm001AddressSP getPropertyAddrHistObj() {
		return propertyAddrHistObj;
	}
	public void setPropertyAddrHistObj(Mmm001AddressSP propertyAddrHistObj) {
		this.propertyAddrHistObj = propertyAddrHistObj;
	}
	public Mmm001AddressSP getInsureAddrHistObj() {
		return insureAddrHistObj;
	}
	public void setInsureAddrHistObj(Mmm001AddressSP insureAddrHistObj) {
		this.insureAddrHistObj = insureAddrHistObj;
	}
	public Mmm001AddressSP getConstructAddrHistObj() {
		return constructAddrHistObj;
	}
	public void setConstructAddrHistObj(Mmm001AddressSP constructAddrHistObj) {
		this.constructAddrHistObj = constructAddrHistObj;
	}
	public Mmm001AddressSP getWithholdAddrHistObj() {
		return withholdAddrHistObj;
	}
	public void setWithholdAddrHistObj(Mmm001AddressSP withholdAddrHistObj) {
		this.withholdAddrHistObj = withholdAddrHistObj;
	}
	public Mmm001AddressSP getPayeeAddrHistObj() {
		return payeeAddrHistObj;
	}
	public void setPayeeAddrHistObj(Mmm001AddressSP payeeAddrHistObj) {
		this.payeeAddrHistObj = payeeAddrHistObj;
	}
	public Mmm001AddressSP getRentalPayeeAddrHistObj() {
		return rentalPayeeAddrHistObj;
	}
	public void setRentalPayeeAddrHistObj(Mmm001AddressSP rentalPayeeAddrHistObj) {
		this.rentalPayeeAddrHistObj = rentalPayeeAddrHistObj;
	}
	public Mmm001AddressSP getElectrictPayeeAddrHistObj() {
		return electrictPayeeAddrHistObj;
	}
	public void setElectrictPayeeAddrHistObj(
			Mmm001AddressSP electrictPayeeAddrHistObj) {
		this.electrictPayeeAddrHistObj = electrictPayeeAddrHistObj;
	}
	public Mmm001AddressSP getPropertyPayeeAddrHistObj() {
		return propertyPayeeAddrHistObj;
	}
	public void setPropertyPayeeAddrHistObj(Mmm001AddressSP propertyPayeeAddrHistObj) {
		this.propertyPayeeAddrHistObj = propertyPayeeAddrHistObj;
	}
	public Mmm001AddressSP getInsurePayeeAddrHistObj() {
		return insurePayeeAddrHistObj;
	}
	public void setInsurePayeeAddrHistObj(Mmm001AddressSP insurePayeeAddrHistObj) {
		this.insurePayeeAddrHistObj = insurePayeeAddrHistObj;
	}
	public Mmm001AddressSP getConstructPayeeAddrHistObj() {
		return constructPayeeAddrHistObj;
	}
	public void setConstructPayeeAddrHistObj(
			Mmm001AddressSP constructPayeeAddrHistObj) {
		this.constructPayeeAddrHistObj = constructPayeeAddrHistObj;
	}
	public Mmm001AddressSP getWithholdPayeeAddrHistObj() {
		return withholdPayeeAddrHistObj;
	}
	public void setWithholdPayeeAddrHistObj(Mmm001AddressSP withholdPayeeAddrHistObj) {
		this.withholdPayeeAddrHistObj = withholdPayeeAddrHistObj;
	}
	public boolean isVendorHistBlockStatus() {
		return vendorHistBlockStatus;
	}
	public void setVendorHistBlockStatus(boolean vendorHistBlockStatus) {
		this.vendorHistBlockStatus = vendorHistBlockStatus;
	}
	public boolean isVendorHistBlackListStatus() {
		return vendorHistBlackListStatus;
	}
	public void setVendorHistBlackListStatus(boolean vendorHistBlackListStatus) {
		this.vendorHistBlackListStatus = vendorHistBlackListStatus;
	}
	public boolean isNotPayeeHistFlag() {
		return notPayeeHistFlag;
	}
	public void setNotPayeeHistFlag(boolean notPayeeHistFlag) {
		this.notPayeeHistFlag = notPayeeHistFlag;
	}
	public boolean isOtherExpenseHistFlag() {
		return otherExpenseHistFlag;
	}
	public void setOtherExpenseHistFlag(boolean otherExpenseHistFlag) {
		this.otherExpenseHistFlag = otherExpenseHistFlag;
	}
	public Mmm001PayeeSP getPayeeInfoHistDetail() {
		return payeeInfoHistDetail;
	}
	public void setPayeeInfoHistDetail(Mmm001PayeeSP payeeInfoHistDetail) {
		this.payeeInfoHistDetail = payeeInfoHistDetail;
	}
	public Mmm001BookbankSP getBookbankInfoHistDetail() {
		return bookbankInfoHistDetail;
	}
	public void setBookbankInfoHistDetail(Mmm001BookbankSP bookbankInfoHistDetail) {
		this.bookbankInfoHistDetail = bookbankInfoHistDetail;
	}
	public Mmm001BookbankPayeeSP getBookbankPayeeInfoHistDetail() {
		return bookbankPayeeInfoHistDetail;
	}
	public void setBookbankPayeeInfoHistDetail(
			Mmm001BookbankPayeeSP bookbankPayeeInfoHistDetail) {
		this.bookbankPayeeInfoHistDetail = bookbankPayeeInfoHistDetail;
	}
	public String getNewVendorFlag() {
		return newVendorFlag;
	}
	public void setNewVendorFlag(String newVendorFlag) {
		this.newVendorFlag = newVendorFlag;
	}
	
	public String getVendorFlowStatus() {
		return vendorFlowStatus;
	}
	public void setVendorFlowStatus(String vendorFlowStatus) {
		this.vendorFlowStatus = vendorFlowStatus;
	}
	public List<SelectItem> getBankNameSearchList() {
		return bankNameSearchList;
	}
	public void setBankNameSearchList(List<SelectItem> bankNameSearchList) {
		this.bankNameSearchList = bankNameSearchList;
	}
	public boolean isDisableBtnNewAllVendor() {
		return disableBtnNewAllVendor;
	}
	public void setDisableBtnNewAllVendor(boolean disableBtnNewAllVendor) {
		this.disableBtnNewAllVendor = disableBtnNewAllVendor;
	}
	public boolean isRenderedBtnChangeVendor() {
		return renderedBtnChangeVendor;
	}
	public void setRenderedBtnChangeVendor(boolean renderedBtnChangeVendor) {
		this.renderedBtnChangeVendor = renderedBtnChangeVendor;
	}
	public boolean isRenderedExportBatchVD() {
		return renderedExportBatchVD;
	}
	public void setRenderedExportBatchVD(boolean renderedExportBatchVD) {
		this.renderedExportBatchVD = renderedExportBatchVD;
	}
	public boolean isRenderedClearBatchVD() {
		return renderedClearBatchVD;
	}
	public void setRenderedClearBatchVD(boolean renderedClearBatchVD) {
		this.renderedClearBatchVD = renderedClearBatchVD;
	}
	public boolean isRenderedCancel() {
		return renderedCancel;
	}
	public void setRenderedCancel(boolean renderedCancel) {
		this.renderedCancel = renderedCancel;
	}
	public boolean isRenderedDeleteVD() {
		return renderedDeleteVD;
	}
	public void setRenderedDeleteVD(boolean renderedDeleteVD) {
		this.renderedDeleteVD = renderedDeleteVD;
	}
	public boolean isRenderedBtnSendManagerVD() {
		return isRenderedBtnSendManagerVD;
	}
	public void setRenderedBtnSendManagerVD(boolean isRenderedBtnSendManagerVD) {
		this.isRenderedBtnSendManagerVD = isRenderedBtnSendManagerVD;
	}
	public boolean isRenderedBtnEditVendor() {
		return isRenderedBtnEditVendor;
	}
	public void setRenderedBtnEditVendor(boolean isRenderedBtnEditVendor) {
		this.isRenderedBtnEditVendor = isRenderedBtnEditVendor;
	}
	public boolean isRenderedBtnClearBatch() {
		return isRenderedBtnClearBatch;
	}
	public void setRenderedBtnClearBatch(boolean isRenderedBtnClearBatch) {
		this.isRenderedBtnClearBatch = isRenderedBtnClearBatch;
	}
	public boolean isRenderedBtnDelete() {
		return isRenderedBtnDelete;
	}
	public void setRenderedBtnDelete(boolean isRenderedBtnDelete) {
		this.isRenderedBtnDelete = isRenderedBtnDelete;
	}
	public boolean isRenderedBtnCancel() {
		return isRenderedBtnCancel;
	}
	public void setRenderedBtnCancel(boolean isRenderedBtnCancel) {
		this.isRenderedBtnCancel = isRenderedBtnCancel;
	}
	public boolean isDisableBtnNewVendorDetail() {
		return disableBtnNewVendorDetail;
	}
	public void setDisableBtnNewVendorDetail(boolean disableBtnNewVendorDetail) {
		this.disableBtnNewVendorDetail = disableBtnNewVendorDetail;
	}
	public boolean isDisableBtnSelectVendor() {
		return disableBtnSelectVendor;
	}
	public void setDisableBtnSelectVendor(boolean disableBtnSelectVendor) {
		this.disableBtnSelectVendor = disableBtnSelectVendor;
	}
	public boolean isRenderedBtnSendManagerPY() {
		return isRenderedBtnSendManagerPY;
	}
	public void setRenderedBtnSendManagerPY(boolean isRenderedBtnSendManagerPY) {
		this.isRenderedBtnSendManagerPY = isRenderedBtnSendManagerPY;
	}
	public boolean isRenderedBtnEditPayee() {
		return isRenderedBtnEditPayee;
	}
	public void setRenderedBtnEditPayee(boolean isRenderedBtnEditPayee) {
		this.isRenderedBtnEditPayee = isRenderedBtnEditPayee;
	}
	public boolean isDisableBtnNewAllPY() {
		return disableBtnNewAllPY;
	}
	public void setDisableBtnNewAllPY(boolean disableBtnNewAllPY) {
		this.disableBtnNewAllPY = disableBtnNewAllPY;
	}
	public boolean isDisableBtnNewPYDetail() {
		return disableBtnNewPYDetail;
	}
	public void setDisableBtnNewPYDetail(boolean disableBtnNewPYDetail) {
		this.disableBtnNewPYDetail = disableBtnNewPYDetail;
	}
	public boolean isDisableBtnSelectPY() {
		return disableBtnSelectPY;
	}
	public void setDisableBtnSelectPY(boolean disableBtnSelectPY) {
		this.disableBtnSelectPY = disableBtnSelectPY;
	}
	public boolean isRenderedBtnChangePY() {
		return renderedBtnChangePY;
	}
	public void setRenderedBtnChangePY(boolean renderedBtnChangePY) {
		this.renderedBtnChangePY = renderedBtnChangePY;
	}
	public boolean isRenderedExportBatchPY() {
		return renderedExportBatchPY;
	}
	public void setRenderedExportBatchPY(boolean renderedExportBatchPY) {
		this.renderedExportBatchPY = renderedExportBatchPY;
	}
	public boolean isRenderedClearBatchPY() {
		return renderedClearBatchPY;
	}
	public void setRenderedClearBatchPY(boolean renderedClearBatchPY) {
		this.renderedClearBatchPY = renderedClearBatchPY;
	}
	public boolean isRenderedCancelPY() {
		return renderedCancelPY;
	}
	public void setRenderedCancelPY(boolean renderedCancelPY) {
		this.renderedCancelPY = renderedCancelPY;
	}
	public boolean isRenderedDeletePY() {
		return renderedDeletePY;
	}
	public void setRenderedDeletePY(boolean renderedDeletePY) {
		this.renderedDeletePY = renderedDeletePY;
	}
	public boolean isDisableBtnNewAllVB() {
		return disableBtnNewAllVB;
	}
	public void setDisableBtnNewAllVB(boolean disableBtnNewAllVB) {
		this.disableBtnNewAllVB = disableBtnNewAllVB;
	}
	public boolean isDisableBtnNewVBDetail() {
		return disableBtnNewVBDetail;
	}
	public void setDisableBtnNewVBDetail(boolean disableBtnNewVBDetail) {
		this.disableBtnNewVBDetail = disableBtnNewVBDetail;
	}
	public boolean isDisableBtnSelectVB() {
		return disableBtnSelectVB;
	}
	public void setDisableBtnSelectVB(boolean disableBtnSelectVB) {
		this.disableBtnSelectVB = disableBtnSelectVB;
	}
	public boolean isRenderedBtnChangeVB() {
		return renderedBtnChangeVB;
	}
	public void setRenderedBtnChangeVB(boolean renderedBtnChangeVB) {
		this.renderedBtnChangeVB = renderedBtnChangeVB;
	}
	public boolean isRenderedExportBatchVB() {
		return renderedExportBatchVB;
	}
	public void setRenderedExportBatchVB(boolean renderedExportBatchVB) {
		this.renderedExportBatchVB = renderedExportBatchVB;
	}
	public boolean isRenderedClearBatchVB() {
		return renderedClearBatchVB;
	}
	public void setRenderedClearBatchVB(boolean renderedClearBatchVB) {
		this.renderedClearBatchVB = renderedClearBatchVB;
	}
	public boolean isRenderedCancelVB() {
		return renderedCancelVB;
	}
	public void setRenderedCancelVB(boolean renderedCancelVB) {
		this.renderedCancelVB = renderedCancelVB;
	}
	public boolean isRenderedDeleteVB() {
		return renderedDeleteVB;
	}
	public void setRenderedDeleteVB(boolean renderedDeleteVB) {
		this.renderedDeleteVB = renderedDeleteVB;
	}
	public boolean isDisableBtnNewAllPB() {
		return disableBtnNewAllPB;
	}
	public void setDisableBtnNewAllPB(boolean disableBtnNewAllPB) {
		this.disableBtnNewAllPB = disableBtnNewAllPB;
	}
	public boolean isDisableBtnNewPBDetail() {
		return disableBtnNewPBDetail;
	}
	public void setDisableBtnNewPBDetail(boolean disableBtnNewPBDetail) {
		this.disableBtnNewPBDetail = disableBtnNewPBDetail;
	}
	public boolean isDisableBtnSelectPB() {
		return disableBtnSelectPB;
	}
	public void setDisableBtnSelectPB(boolean disableBtnSelectPB) {
		this.disableBtnSelectPB = disableBtnSelectPB;
	}
	public boolean isRenderedBtnChangePB() {
		return renderedBtnChangePB;
	}
	public void setRenderedBtnChangePB(boolean renderedBtnChangePB) {
		this.renderedBtnChangePB = renderedBtnChangePB;
	}
	public boolean isRenderedExportBatchPB() {
		return renderedExportBatchPB;
	}
	public void setRenderedExportBatchPB(boolean renderedExportBatchPB) {
		this.renderedExportBatchPB = renderedExportBatchPB;
	}
	public boolean isRenderedClearBatchPB() {
		return renderedClearBatchPB;
	}
	public void setRenderedClearBatchPB(boolean renderedClearBatchPB) {
		this.renderedClearBatchPB = renderedClearBatchPB;
	}
	public boolean isRenderedCancelPB() {
		return renderedCancelPB;
	}
	public void setRenderedCancelPB(boolean renderedCancelPB) {
		this.renderedCancelPB = renderedCancelPB;
	}
	public boolean isRenderedDeletePB() {
		return renderedDeletePB;
	}
	public void setRenderedDeletePB(boolean renderedDeletePB) {
		this.renderedDeletePB = renderedDeletePB;
	}
	public boolean isRenderedEditBookbankContent() {
		return isRenderedEditBookbankContent;
	}
	public void setRenderedEditBookbankContent(boolean isRenderedEditBookbankContent) {
		this.isRenderedEditBookbankContent = isRenderedEditBookbankContent;
	}
	public boolean isRenderedBtnEditBookbank() {
		return isRenderedBtnEditBookbank;
	}
	public void setRenderedBtnEditBookbank(boolean isRenderedBtnEditBookbank) {
		this.isRenderedBtnEditBookbank = isRenderedBtnEditBookbank;
	}
	public boolean isRenderedBtnSaveBookbank() {
		return isRenderedBtnSaveBookbank;
	}
	public void setRenderedBtnSaveBookbank(boolean isRenderedBtnSaveBookbank) {
		this.isRenderedBtnSaveBookbank = isRenderedBtnSaveBookbank;
	}
	public boolean isRenderedBtnExportBatchVB() {
		return isRenderedBtnExportBatchVB;
	}
	public void setRenderedBtnExportBatchVB(boolean isRenderedBtnExportBatchVB) {
		this.isRenderedBtnExportBatchVB = isRenderedBtnExportBatchVB;
	}
	public boolean isRenderedBtnSendManagerVB() {
		return isRenderedBtnSendManagerVB;
	}
	public void setRenderedBtnSendManagerVB(boolean isRenderedBtnSendManagerVB) {
		this.isRenderedBtnSendManagerVB = isRenderedBtnSendManagerVB;
	}
	public boolean isRenderedBtnEditBookbankPayee() {
		return isRenderedBtnEditBookbankPayee;
	}
	public void setRenderedBtnEditBookbankPayee(
			boolean isRenderedBtnEditBookbankPayee) {
		this.isRenderedBtnEditBookbankPayee = isRenderedBtnEditBookbankPayee;
	}
	public boolean isDisableBtnCopyVBFromSAP() {
		return disableBtnCopyVBFromSAP;
	}
	public void setDisableBtnCopyVBFromSAP(boolean disableBtnCopyVBFromSAP) {
		this.disableBtnCopyVBFromSAP = disableBtnCopyVBFromSAP;
	}
	public boolean isRenderedBtnSendManagerPB() {
		return isRenderedBtnSendManagerPB;
	}
	public void setRenderedBtnSendManagerPB(boolean isRenderedBtnSendManagerPB) {
		this.isRenderedBtnSendManagerPB = isRenderedBtnSendManagerPB;
	}
	public Mmm001RequestParam getSemmmm001ReqParam() {
		return semmmm001ReqParam;
	}
	public void setSemmmm001ReqParam(Mmm001RequestParam semmmm001ReqParam) {
		this.semmmm001ReqParam = semmmm001ReqParam;
	}
	public boolean isVendorBlockStatusSAP() {
		return vendorBlockStatusSAP;
	}
	public void setVendorBlockStatusSAP(boolean vendorBlockStatusSAP) {
		this.vendorBlockStatusSAP = vendorBlockStatusSAP;
	}
	public boolean isNotPayeeFlagSAP() {
		return notPayeeFlagSAP;
	}
	public void setNotPayeeFlagSAP(boolean notPayeeFlagSAP) {
		this.notPayeeFlagSAP = notPayeeFlagSAP;
	}
	public boolean isRenderedRemarkContract() {
		return renderedRemarkContract;
	}
	public void setRenderedRemarkContract(boolean renderedRemarkContract) {
		this.renderedRemarkContract = renderedRemarkContract;
	}
	
	public boolean isRenderedConfirmVD() {
		return renderedConfirmVD;
	}
	public void setRenderedConfirmVD(boolean renderedConfirmVD) {
		this.renderedConfirmVD = renderedConfirmVD;
	}
	public boolean isDisableConfirmVD() {
		return disableConfirmVD;
	}
	public void setDisableConfirmVD(boolean disableConfirmVD) {
		this.disableConfirmVD = disableConfirmVD;
	}
	public boolean isRenderedConfirmVB() {
		return renderedConfirmVB;
	}
	public void setRenderedConfirmVB(boolean renderedConfirmVB) {
		this.renderedConfirmVB = renderedConfirmVB;
	}
	public boolean isDisableConfirmVB() {
		return disableConfirmVB;
	}
	public void setDisableConfirmVB(boolean disableConfirmVB) {
		this.disableConfirmVB = disableConfirmVB;
	}
	public boolean isRenderedConfirmPY() {
		return renderedConfirmPY;
	}
	public void setRenderedConfirmPY(boolean renderedConfirmPY) {
		this.renderedConfirmPY = renderedConfirmPY;
	}
	public boolean isDisableConfirmPY() {
		return disableConfirmPY;
	}
	public void setDisableConfirmPY(boolean disableConfirmPY) {
		this.disableConfirmPY = disableConfirmPY;
	}
	public boolean isRenderedConfirmPB() {
		return renderedConfirmPB;
	}
	public void setRenderedConfirmPB(boolean renderedConfirmPB) {
		this.renderedConfirmPB = renderedConfirmPB;
	}
	public boolean isDisableConfirmPB() {
		return disableConfirmPB;
	}
	public void setDisableConfirmPB(boolean disableConfirmPB) {
		this.disableConfirmPB = disableConfirmPB;
	}
	public boolean isDisableBtnCopyFromSAP() {
		return disableBtnCopyFromSAP;
	}
	public void setDisableBtnCopyFromSAP(boolean disableBtnCopyFromSAP) {
		this.disableBtnCopyFromSAP = disableBtnCopyFromSAP;
	}
	public String getContractNoDelete() {
		return contractNoDelete;
	}
	public void setContractNoDelete(String contractNoDelete) {
		this.contractNoDelete = contractNoDelete;
	}
	public String getVendorIdDelete() {
		return vendorIdDelete;
	}
	public void setVendorIdDelete(String vendorIdDelete) {
		this.vendorIdDelete = vendorIdDelete;
	}
	public String getVendorMapPayeeIdDelete() {
		return vendorMapPayeeIdDelete;
	}
	public void setVendorMapPayeeIdDelete(String vendorMapPayeeIdDelete) {
		this.vendorMapPayeeIdDelete = vendorMapPayeeIdDelete;
	}
	public String getConfirmMsg() {
		return confirmMsg;
	}
	public void setConfirmMsg(String confirmMsg) {
		this.confirmMsg = confirmMsg;
	}
	public boolean isDisablePaymentVendorCont() {
		return disablePaymentVendorCont;
	}
	public void setDisablePaymentVendorCont(boolean disablePaymentVendorCont) {
		this.disablePaymentVendorCont = disablePaymentVendorCont;
	}
	public boolean isDisableBtnCopyPYFromSAP() {
		return disableBtnCopyPYFromSAP;
	}
	public void setDisableBtnCopyPYFromSAP(boolean disableBtnCopyPYFromSAP) {
		this.disableBtnCopyPYFromSAP = disableBtnCopyPYFromSAP;
	}
	public boolean isDisableBtnCopyPBFromSAP() {
		return disableBtnCopyPBFromSAP;
	}
	public void setDisableBtnCopyPBFromSAP(boolean disableBtnCopyPBFromSAP) {
		this.disableBtnCopyPBFromSAP = disableBtnCopyPBFromSAP;
	}
	public boolean isDisableDLLCompany() {
		return disableDLLCompany;
	}
	public void setDisableDLLCompany(boolean disableDLLCompany) {
		this.disableDLLCompany = disableDLLCompany;
	}
	public String getNavProgram() {
		return navProgram;
	}
	public void setNavProgram(String navProgram) {
		this.navProgram = navProgram;
	}
	public String getMethodWithNavi() {
		return methodWithNavi;
	}
	public void setMethodWithNavi(String methodWithNavi) {
		this.methodWithNavi = methodWithNavi;
	}
	public String getRenderedMsgConfirm() {
		return renderedMsgConfirm;
	}
	public void setRenderedMsgConfirm(String renderedMsgConfirm) {
		this.renderedMsgConfirm = renderedMsgConfirm;
	}
	public boolean isRenderedBtnCheck() {
		return renderedBtnCheck;
	}
	public void setRenderedBtnCheck(boolean renderedBtnCheck) {
		this.renderedBtnCheck = renderedBtnCheck;
	}
	public boolean isRenderedBtnUncheck() {
		return renderedBtnUncheck;
	}
	public void setRenderedBtnUncheck(boolean renderedBtnUncheck) {
		this.renderedBtnUncheck = renderedBtnUncheck;
	}
	public boolean isChkDummyFlag() {
		return chkDummyFlag;
	}
	public void setChkDummyFlag(boolean chkDummyFlag) {
		this.chkDummyFlag = chkDummyFlag;
	}
	public List<SelectItem> getNoExportBatchList() {
		return noExportBatchList;
	}
	public void setNoExportBatchList(List<SelectItem> noExportBatchList) {
		this.noExportBatchList = noExportBatchList;
	}
	public String getNavModuleBack() {
		return navModuleBack;
	}
	public void setNavModuleBack(String navModuleBack) {
		this.navModuleBack = navModuleBack;
	}
	public boolean isRenderedBtnBackOthPageFlow() {
		return renderedBtnBackOthPageFlow;
	}
	public void setRenderedBtnBackOthPageFlow(boolean renderedBtnBackOthPageFlow) {
		this.renderedBtnBackOthPageFlow = renderedBtnBackOthPageFlow;
	}
	public boolean isDisablePaymentVendorContVerify() {
		return disablePaymentVendorContVerify;
	}
	public void setDisablePaymentVendorContVerify(
			boolean disablePaymentVendorContVerify) {
		this.disablePaymentVendorContVerify = disablePaymentVendorContVerify;
	}
	public Mmm001ValidatePage getValidatePage() {
		return validatePage;
	}
	public void setValidatePage(Mmm001ValidatePage validatePage) {
		this.validatePage = validatePage;
	}
	public boolean isPayeePageFlag() {
		return payeePageFlag;
	}
	public void setPayeePageFlag(boolean payeePageFlag) {
		this.payeePageFlag = payeePageFlag;
	}
	public List<Mmm001VendorMasterSP> getCt001ExExcelList() {
		return ct001ExExcelList;
	}
	public void setCt001ExExcelList(List<Mmm001VendorMasterSP> ct001ExExcelList) {
		this.ct001ExExcelList = ct001ExExcelList;
	}
	public boolean isDisableBtnExportExcel() {
		return disableBtnExportExcel;
	}
	public void setDisableBtnExportExcel(boolean disableBtnExportExcel) {
		this.disableBtnExportExcel = disableBtnExportExcel;
	}
	public boolean isRenderedBtnBackVD() {
		return renderedBtnBackVD;
	}
	public void setRenderedBtnBackVD(boolean renderedBtnBackVD) {
		this.renderedBtnBackVD = renderedBtnBackVD;
	}
	public boolean isRenderedBtnBackVB() {
		return renderedBtnBackVB;
	}
	public void setRenderedBtnBackVB(boolean renderedBtnBackVB) {
		this.renderedBtnBackVB = renderedBtnBackVB;
	}
	public boolean isRenderedBtnBackPY() {
		return renderedBtnBackPY;
	}
	public void setRenderedBtnBackPY(boolean renderedBtnBackPY) {
		this.renderedBtnBackPY = renderedBtnBackPY;
	}
	public boolean isRenderedBtnBackPB() {
		return renderedBtnBackPB;
	}
	public void setRenderedBtnBackPB(boolean renderedBtnBackPB) {
		this.renderedBtnBackPB = renderedBtnBackPB;
	}
	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	public String getNavModuleBackAfterSave() {
		return navModuleBackAfterSave;
	}
	public void setNavModuleBackAfterSave(String navModuleBackAfterSave) {
		this.navModuleBackAfterSave = navModuleBackAfterSave;
	}
	public String getNavProgramBackAfterSave() {
		return navProgramBackAfterSave;
	}
	public void setNavProgramBackAfterSave(String navProgramBackAfterSave) {
		this.navProgramBackAfterSave = navProgramBackAfterSave;
	}
	public String getModuleWithNaviBackAfterSave() {
		return moduleWithNaviBackAfterSave;
	}
	public void setModuleWithNaviBackAfterSave(String moduleWithNaviBackAfterSave) {
		this.moduleWithNaviBackAfterSave = moduleWithNaviBackAfterSave;
	}
	public String getActionWithNaviBackAfterSave() {
		return actionWithNaviBackAfterSave;
	}
	public void setActionWithNaviBackAfterSave(String actionWithNaviBackAfterSave) {
		this.actionWithNaviBackAfterSave = actionWithNaviBackAfterSave;
	}
	public String getTodoManagerFlagBackAfterSave() {
		return todoManagerFlagBackAfterSave;
	}
	public void setTodoManagerFlagBackAfterSave(String todoManagerFlagBackAfterSave) {
		this.todoManagerFlagBackAfterSave = todoManagerFlagBackAfterSave;
	}
	public String getContractNoParamBackAfterSave() {
		return contractNoParamBackAfterSave;
	}
	public void setContractNoParamBackAfterSave(String contractNoParamBackAfterSave) {
		this.contractNoParamBackAfterSave = contractNoParamBackAfterSave;
	}
	public String getVendorIdParamBackAfterSave() {
		return vendorIdParamBackAfterSave;
	}
	public void setVendorIdParamBackAfterSave(String vendorIdParamBackAfterSave) {
		this.vendorIdParamBackAfterSave = vendorIdParamBackAfterSave;
	}
	public String getActionIdBackAfterSave() {
		return actionIdBackAfterSave;
	}
	public void setActionIdBackAfterSave(String actionIdBackAfterSave) {
		this.actionIdBackAfterSave = actionIdBackAfterSave;
	}
	public boolean isRenderedBtnBackHide() {
		return renderedBtnBackHide;
	}
	public void setRenderedBtnBackHide(boolean renderedBtnBackHide) {
		this.renderedBtnBackHide = renderedBtnBackHide;
	}
	public String getMethodWithNaviBackAfterSave() {
		return methodWithNaviBackAfterSave;
	}
	public void setMethodWithNaviBackAfterSave(String methodWithNaviBackAfterSave) {
		this.methodWithNaviBackAfterSave = methodWithNaviBackAfterSave;
	}
	public String getModeBackAfterSave() {
		return modeBackAfterSave;
	}
	public void setModeBackAfterSave(String modeBackAfterSave) {
		this.modeBackAfterSave = modeBackAfterSave;
	}
	public String getHeadTypeBackAfterSave() {
		return headTypeBackAfterSave;
	}
	public void setHeadTypeBackAfterSave(String headTypeBackAfterSave) {
		this.headTypeBackAfterSave = headTypeBackAfterSave;
	}
	public String getExpenseEffectiveDtStrParamBackAfterSave() {
		return expenseEffectiveDtStrParamBackAfterSave;
	}
	public void setExpenseEffectiveDtStrParamBackAfterSave(
			String expenseEffectiveDtStrParamBackAfterSave) {
		this.expenseEffectiveDtStrParamBackAfterSave = expenseEffectiveDtStrParamBackAfterSave;
	}
	public String getEffectiveDtStrParamBackAfterSave() {
		return effectiveDtStrParamBackAfterSave;
	}
	public void setEffectiveDtStrParamBackAfterSave(
			String effectiveDtStrParamBackAfterSave) {
		this.effectiveDtStrParamBackAfterSave = effectiveDtStrParamBackAfterSave;
	}
	public String getExpireDtStrParamBackAfterSave() {
		return expireDtStrParamBackAfterSave;
	}
	public void setExpireDtStrParamBackAfterSave(
			String expireDtStrParamBackAfterSave) {
		this.expireDtStrParamBackAfterSave = expireDtStrParamBackAfterSave;
	}
	public String getExpenseTypeIdParamBackAfterSave() {
		return expenseTypeIdParamBackAfterSave;
	}
	public void setExpenseTypeIdParamBackAfterSave(
			String expenseTypeIdParamBackAfterSave) {
		this.expenseTypeIdParamBackAfterSave = expenseTypeIdParamBackAfterSave;
	}
	public String getPayTypeIdParamBackAfterSave() {
		return payTypeIdParamBackAfterSave;
	}
	public void setPayTypeIdParamBackAfterSave(String payTypeIdParamBackAfterSave) {
		this.payTypeIdParamBackAfterSave = payTypeIdParamBackAfterSave;
	}
	public String getVendorMapPayeeIdParamBackAfterSave() {
		return vendorMapPayeeIdParamBackAfterSave;
	}
	public void setVendorMapPayeeIdParamBackAfterSave(
			String vendorMapPayeeIdParamBackAfterSave) {
		this.vendorMapPayeeIdParamBackAfterSave = vendorMapPayeeIdParamBackAfterSave;
	}
	public String getCancelFlagBackAfterSave() {
		return cancelFlagBackAfterSave;
	}
	public void setCancelFlagBackAfterSave(String cancelFlagBackAfterSave) {
		this.cancelFlagBackAfterSave = cancelFlagBackAfterSave;
	}
	public boolean isRenderedBtnBackVDCancel() {
		return renderedBtnBackVDCancel;
	}
	public void setRenderedBtnBackVDCancel(boolean renderedBtnBackVDCancel) {
		this.renderedBtnBackVDCancel = renderedBtnBackVDCancel;
	}
	public boolean isRenderedBtnBackVBCancel() {
		return renderedBtnBackVBCancel;
	}
	public void setRenderedBtnBackVBCancel(boolean renderedBtnBackVBCancel) {
		this.renderedBtnBackVBCancel = renderedBtnBackVBCancel;
	}
	public boolean isRenderedBtnBackPYCancel() {
		return renderedBtnBackPYCancel;
	}
	public void setRenderedBtnBackPYCancel(boolean renderedBtnBackPYCancel) {
		this.renderedBtnBackPYCancel = renderedBtnBackPYCancel;
	}
	public boolean isRenderedBtnBackPBCancel() {
		return renderedBtnBackPBCancel;
	}
	public void setRenderedBtnBackPBCancel(boolean renderedBtnBackPBCancel) {
		this.renderedBtnBackPBCancel = renderedBtnBackPBCancel;
	}
	public boolean isDisableBtnCancelVendor() {
		return isDisableBtnCancelVendor;
	}
	public void setDisableBtnCancelVendor(boolean isDisableBtnCancelVendor) {
		this.isDisableBtnCancelVendor = isDisableBtnCancelVendor;
	}
	public boolean isDisableBtnCancelBookbank() {
		return isDisableBtnCancelBookbank;
	}
	public void setDisableBtnCancelBookbank(boolean isDisableBtnCancelBookbank) {
		this.isDisableBtnCancelBookbank = isDisableBtnCancelBookbank;
	}
	public boolean isDisableBtnEditDataBookbank() {
		return isDisableBtnEditDataBookbank;
	}
	public void setDisableBtnEditDataBookbank(boolean isDisableBtnEditDataBookbank) {
		this.isDisableBtnEditDataBookbank = isDisableBtnEditDataBookbank;
	}
	public boolean isRenderedBtnEditDataBookbank() {
		return isRenderedBtnEditDataBookbank;
	}
	public void setRenderedBtnEditDataBookbank(boolean isRenderedBtnEditDataBookbank) {
		this.isRenderedBtnEditDataBookbank = isRenderedBtnEditDataBookbank;
	}
	public boolean isDisableBtnEditDataPayee() {
		return isDisableBtnEditDataPayee;
	}
	public void setDisableBtnEditDataPayee(boolean isDisableBtnEditDataPayee) {
		this.isDisableBtnEditDataPayee = isDisableBtnEditDataPayee;
	}
	public boolean isRenderedBtnEditDataPayee() {
		return isRenderedBtnEditDataPayee;
	}
	public void setRenderedBtnEditDataPayee(boolean isRenderedBtnEditDataPayee) {
		this.isRenderedBtnEditDataPayee = isRenderedBtnEditDataPayee;
	}
	public boolean isDisableBtnEditDataPayeeBB() {
		return isDisableBtnEditDataPayeeBB;
	}
	public void setDisableBtnEditDataPayeeBB(boolean isDisableBtnEditDataPayeeBB) {
		this.isDisableBtnEditDataPayeeBB = isDisableBtnEditDataPayeeBB;
	}
	public boolean isRenderedBtnEditDataPayeeBB() {
		return isRenderedBtnEditDataPayeeBB;
	}
	public void setRenderedBtnEditDataPayeeBB(boolean isRenderedBtnEditDataPayeeBB) {
		this.isRenderedBtnEditDataPayeeBB = isRenderedBtnEditDataPayeeBB;
	}
	public List<WrapperBeanObject<Mmm001HistorySP>> getConfirmResultList() {
		return confirmResultList;
	}
	public void setConfirmResultList(
			List<WrapperBeanObject<Mmm001HistorySP>> confirmResultList) {
		this.confirmResultList = confirmResultList;
	}
	public boolean isRenderedMsgPopupSave() {
		return renderedMsgPopupSave;
	}
	public void setRenderedMsgPopupSave(boolean renderedMsgPopupSave) {
		this.renderedMsgPopupSave = renderedMsgPopupSave;
	}
	public boolean isTogPnlVD() {
		return togPnlVD;
	}
	public void setTogPnlVD(boolean togPnlVD) {
		this.togPnlVD = togPnlVD;
	}
	public boolean isTogPnlVB() {
		return togPnlVB;
	}
	public void setTogPnlVB(boolean togPnlVB) {
		this.togPnlVB = togPnlVB;
	}
	public boolean isTogPnlPY() {
		return togPnlPY;
	}
	public void setTogPnlPY(boolean togPnlPY) {
		this.togPnlPY = togPnlPY;
	}
	public boolean isTogPnlPB() {
		return togPnlPB;
	}
	public void setTogPnlPB(boolean togPnlPB) {
		this.togPnlPB = togPnlPB;
	}
	public boolean isTogPnlAB() {
		return togPnlAB;
	}
	public void setTogPnlAB(boolean togPnlAB) {
		this.togPnlAB = togPnlAB;
	}
	public boolean isTogPnlCB() {
		return togPnlCB;
	}
	public void setTogPnlCB(boolean togPnlCB) {
		this.togPnlCB = togPnlCB;
	}
	public boolean isRenderedMsgNewPayee() {
		return renderedMsgNewPayee;
	}
	public void setRenderedMsgNewPayee(boolean renderedMsgNewPayee) {
		this.renderedMsgNewPayee = renderedMsgNewPayee;
	}
	public boolean isFromVendorFlag() {
		return fromVendorFlag;
	}
	public void setFromVendorFlag(boolean fromVendorFlag) {
		this.fromVendorFlag = fromVendorFlag;
	}
	public boolean isFromPayeeFlag() {
		return fromPayeeFlag;
	}
	public void setFromPayeeFlag(boolean fromPayeeFlag) {
		this.fromPayeeFlag = fromPayeeFlag;
	}
	public boolean isMsgFlag() {
		return msgFlag;
	}
	public void setMsgFlag(boolean msgFlag) {
		this.msgFlag = msgFlag;
	}
	public boolean isRenderedPopupConfirmBackVD() {
		return renderedPopupConfirmBackVD;
	}
	public void setRenderedPopupConfirmBackVD(boolean renderedPopupConfirmBackVD) {
		this.renderedPopupConfirmBackVD = renderedPopupConfirmBackVD;
	}
	public boolean isRenderedPopupConfirmBackVB() {
		return renderedPopupConfirmBackVB;
	}
	public void setRenderedPopupConfirmBackVB(boolean renderedPopupConfirmBackVB) {
		this.renderedPopupConfirmBackVB = renderedPopupConfirmBackVB;
	}
	public boolean isRenderedPopupConfirmBackPY() {
		return renderedPopupConfirmBackPY;
	}
	public void setRenderedPopupConfirmBackPY(boolean renderedPopupConfirmBackPY) {
		this.renderedPopupConfirmBackPY = renderedPopupConfirmBackPY;
	}
	public boolean isRenderedPopupConfirmBackPB() {
		return renderedPopupConfirmBackPB;
	}
	public void setRenderedPopupConfirmBackPB(boolean renderedPopupConfirmBackPB) {
		this.renderedPopupConfirmBackPB = renderedPopupConfirmBackPB;
	}
	public boolean isSaveSuccessFlag() {
		return saveSuccessFlag;
	}
	public void setSaveSuccessFlag(boolean saveSuccessFlag) {
		this.saveSuccessFlag = saveSuccessFlag;
	}
	public List<SelectItem> getTambolVendorList() {
		return tambolVendorList;
	}
	public void setTambolVendorList(List<SelectItem> tambolVendorList) {
		this.tambolVendorList = tambolVendorList;
	}
	public List<SelectItem> getAmphurVendorList() {
		return amphurVendorList;
	}
	public void setAmphurVendorList(List<SelectItem> amphurVendorList) {
		this.amphurVendorList = amphurVendorList;
	}
	public List<SelectItem> getProvinceVendorList() {
		return provinceVendorList;
	}
	public void setProvinceVendorList(List<SelectItem> provinceVendorList) {
		this.provinceVendorList = provinceVendorList;
	}
	public List<SelectItem> getTambolRentalList() {
		return tambolRentalList;
	}
	public void setTambolRentalList(List<SelectItem> tambolRentalList) {
		this.tambolRentalList = tambolRentalList;
	}
	public List<SelectItem> getAmphurRentalList() {
		return amphurRentalList;
	}
	public void setAmphurRentalList(List<SelectItem> amphurRentalList) {
		this.amphurRentalList = amphurRentalList;
	}
	public List<SelectItem> getProvinceRentalList() {
		return provinceRentalList;
	}
	public void setProvinceRentalList(List<SelectItem> provinceRentalList) {
		this.provinceRentalList = provinceRentalList;
	}
	public List<SelectItem> getTambolElectrictList() {
		return tambolElectrictList;
	}
	public void setTambolElectrictList(List<SelectItem> tambolElectrictList) {
		this.tambolElectrictList = tambolElectrictList;
	}
	public List<SelectItem> getAmphurElectrictList() {
		return amphurElectrictList;
	}
	public void setAmphurElectrictList(List<SelectItem> amphurElectrictList) {
		this.amphurElectrictList = amphurElectrictList;
	}
	public List<SelectItem> getProvinceElectrictList() {
		return provinceElectrictList;
	}
	public void setProvinceElectrictList(List<SelectItem> provinceElectrictList) {
		this.provinceElectrictList = provinceElectrictList;
	}
	public List<SelectItem> getTambolPropertyList() {
		return tambolPropertyList;
	}
	public void setTambolPropertyList(List<SelectItem> tambolPropertyList) {
		this.tambolPropertyList = tambolPropertyList;
	}
	public List<SelectItem> getAmphurPropertyList() {
		return amphurPropertyList;
	}
	public void setAmphurPropertyList(List<SelectItem> amphurPropertyList) {
		this.amphurPropertyList = amphurPropertyList;
	}
	public List<SelectItem> getProvincePropertyList() {
		return provincePropertyList;
	}
	public void setProvincePropertyList(List<SelectItem> provincePropertyList) {
		this.provincePropertyList = provincePropertyList;
	}
	
	public List<SelectItem> getTambolInsureList() {
		return tambolInsureList;
	}
	public void setTambolInsureList(List<SelectItem> tambolInsureList) {
		this.tambolInsureList = tambolInsureList;
	}
	public List<SelectItem> getAmphurInsureList() {
		return amphurInsureList;
	}
	public void setAmphurInsureList(List<SelectItem> amphurInsureList) {
		this.amphurInsureList = amphurInsureList;
	}
	public List<SelectItem> getProvinceInsureList() {
		return provinceInsureList;
	}
	public void setProvinceInsureList(List<SelectItem> provinceInsureList) {
		this.provinceInsureList = provinceInsureList;
	}
	public List<SelectItem> getTambolConstructList() {
		return tambolConstructList;
	}
	public void setTambolConstructList(List<SelectItem> tambolConstructList) {
		this.tambolConstructList = tambolConstructList;
	}
	public List<SelectItem> getAmphurConstructList() {
		return amphurConstructList;
	}
	public void setAmphurConstructList(List<SelectItem> amphurConstructList) {
		this.amphurConstructList = amphurConstructList;
	}
	public List<SelectItem> getProvinceConstructList() {
		return provinceConstructList;
	}
	public void setProvinceConstructList(List<SelectItem> provinceConstructList) {
		this.provinceConstructList = provinceConstructList;
	}
	public List<SelectItem> getTambolWithholdList() {
		return tambolWithholdList;
	}
	public void setTambolWithholdList(List<SelectItem> tambolWithholdList) {
		this.tambolWithholdList = tambolWithholdList;
	}
	public List<SelectItem> getAmphurWithholdList() {
		return amphurWithholdList;
	}
	public void setAmphurWithholdList(List<SelectItem> amphurWithholdList) {
		this.amphurWithholdList = amphurWithholdList;
	}
	public List<SelectItem> getProvinceWithholdList() {
		return provinceWithholdList;
	}
	public void setProvinceWithholdList(List<SelectItem> provinceWithholdList) {
		this.provinceWithholdList = provinceWithholdList;
	}
	public List<SelectItem> getTambolVendorCmpList() {
		return tambolVendorCmpList;
	}
	public void setTambolVendorCmpList(List<SelectItem> tambolVendorCmpList) {
		this.tambolVendorCmpList = tambolVendorCmpList;
	}
	public List<SelectItem> getAmphurVendorCmpList() {
		return amphurVendorCmpList;
	}
	public void setAmphurVendorCmpList(List<SelectItem> amphurVendorCmpList) {
		this.amphurVendorCmpList = amphurVendorCmpList;
	}
	public List<SelectItem> getProvinceVendorCmpList() {
		return provinceVendorCmpList;
	}
	public void setProvinceVendorCmpList(List<SelectItem> provinceVendorCmpList) {
		this.provinceVendorCmpList = provinceVendorCmpList;
	}
	public List<SelectItem> getTambolRentalCmpList() {
		return tambolRentalCmpList;
	}
	public void setTambolRentalCmpList(List<SelectItem> tambolRentalCmpList) {
		this.tambolRentalCmpList = tambolRentalCmpList;
	}
	public List<SelectItem> getAmphurRentalCmpList() {
		return amphurRentalCmpList;
	}
	public void setAmphurRentalCmpList(List<SelectItem> amphurRentalCmpList) {
		this.amphurRentalCmpList = amphurRentalCmpList;
	}
	public List<SelectItem> getProvinceRentalCmpList() {
		return provinceRentalCmpList;
	}
	public void setProvinceRentalCmpList(List<SelectItem> provinceRentalCmpList) {
		this.provinceRentalCmpList = provinceRentalCmpList;
	}
	public List<SelectItem> getTambolElectrictCmpList() {
		return tambolElectrictCmpList;
	}
	public void setTambolElectrictCmpList(List<SelectItem> tambolElectrictCmpList) {
		this.tambolElectrictCmpList = tambolElectrictCmpList;
	}
	public List<SelectItem> getAmphurElectrictCmpList() {
		return amphurElectrictCmpList;
	}
	public void setAmphurElectrictCmpList(List<SelectItem> amphurElectrictCmpList) {
		this.amphurElectrictCmpList = amphurElectrictCmpList;
	}
	public List<SelectItem> getProvinceElectrictCmpList() {
		return provinceElectrictCmpList;
	}
	public void setProvinceElectrictCmpList(
			List<SelectItem> provinceElectrictCmpList) {
		this.provinceElectrictCmpList = provinceElectrictCmpList;
	}
	public List<SelectItem> getTambolPropertyCmpList() {
		return tambolPropertyCmpList;
	}
	public void setTambolPropertyCmpList(List<SelectItem> tambolPropertyCmpList) {
		this.tambolPropertyCmpList = tambolPropertyCmpList;
	}
	public List<SelectItem> getAmphurPropertyCmpList() {
		return amphurPropertyCmpList;
	}
	public void setAmphurPropertyCmpList(List<SelectItem> amphurPropertyCmpList) {
		this.amphurPropertyCmpList = amphurPropertyCmpList;
	}
	public List<SelectItem> getProvincePropertyCmpList() {
		return provincePropertyCmpList;
	}
	public void setProvincePropertyCmpList(List<SelectItem> provincePropertyCmpList) {
		this.provincePropertyCmpList = provincePropertyCmpList;
	}
	
	public List<SelectItem> getTambolInsureCmpList() {
		return tambolInsureCmpList;
	}
	public void setTambolInsureCmpList(List<SelectItem> tambolInsureCmpList) {
		this.tambolInsureCmpList = tambolInsureCmpList;
	}
	public List<SelectItem> getAmphurInsureCmpList() {
		return amphurInsureCmpList;
	}
	public void setAmphurInsureCmpList(List<SelectItem> amphurInsureCmpList) {
		this.amphurInsureCmpList = amphurInsureCmpList;
	}
	public List<SelectItem> getProvinceInsureCmpList() {
		return provinceInsureCmpList;
	}
	public void setProvinceInsureCmpList(List<SelectItem> provinceInsureCmpList) {
		this.provinceInsureCmpList = provinceInsureCmpList;
	}
	public List<SelectItem> getTambolConstructCmpList() {
		return tambolConstructCmpList;
	}
	public void setTambolConstructCmpList(List<SelectItem> tambolConstructCmpList) {
		this.tambolConstructCmpList = tambolConstructCmpList;
	}
	public List<SelectItem> getAmphurConstructCmpList() {
		return amphurConstructCmpList;
	}
	public void setAmphurConstructCmpList(List<SelectItem> amphurConstructCmpList) {
		this.amphurConstructCmpList = amphurConstructCmpList;
	}
	public List<SelectItem> getProvinceConstructCmpList() {
		return provinceConstructCmpList;
	}
	public void setProvinceConstructCmpList(
			List<SelectItem> provinceConstructCmpList) {
		this.provinceConstructCmpList = provinceConstructCmpList;
	}
	public List<SelectItem> getTambolWithholdCmpList() {
		return tambolWithholdCmpList;
	}
	public void setTambolWithholdCmpList(List<SelectItem> tambolWithholdCmpList) {
		this.tambolWithholdCmpList = tambolWithholdCmpList;
	}
	public List<SelectItem> getAmphurWithholdCmpList() {
		return amphurWithholdCmpList;
	}
	public void setAmphurWithholdCmpList(List<SelectItem> amphurWithholdCmpList) {
		this.amphurWithholdCmpList = amphurWithholdCmpList;
	}
	public List<SelectItem> getProvinceWithholdCmpList() {
		return provinceWithholdCmpList;
	}
	public void setProvinceWithholdCmpList(List<SelectItem> provinceWithholdCmpList) {
		this.provinceWithholdCmpList = provinceWithholdCmpList;
	}
	public String getAccountNoMaxLength() {
		return accountNoMaxLength;
	}
	public void setAccountNoMaxLength(String accountNoMaxLength) {
		this.accountNoMaxLength = accountNoMaxLength;
	}
	public String getAccountNoMaxLengthPayee() {
		return accountNoMaxLengthPayee;
	}
	public void setAccountNoMaxLengthPayee(String accountNoMaxLengthPayee) {
		this.accountNoMaxLengthPayee = accountNoMaxLengthPayee;
	}
	public String getAccountNoMaxLengthCmp() {
		return accountNoMaxLengthCmp;
	}
	public void setAccountNoMaxLengthCmp(String accountNoMaxLengthCmp) {
		this.accountNoMaxLengthCmp = accountNoMaxLengthCmp;
	}
	public String getAccountNoMaxLengthPayeeCmp() {
		return accountNoMaxLengthPayeeCmp;
	}
	public void setAccountNoMaxLengthPayeeCmp(String accountNoMaxLengthPayeeCmp) {
		this.accountNoMaxLengthPayeeCmp = accountNoMaxLengthPayeeCmp;
	}
	@Override
	public String toString() {
		return "SEMMMM001Bean [accountTypeList=" + accountTypeList
				+ ", accountTypeSemList=" + accountTypeSemList
				+ ", actionType=" + actionType + ", actionWithNaviBack="
				+ actionWithNaviBack + ", activeStatusList=" + activeStatusList
				+ ", activeStatusSemList=" + activeStatusSemList
				+ ", amphurList=" + amphurList + ", amphurSemList="
				+ amphurSemList + ", backButtonFlag=" + backButtonFlag
				+ ", bankBranchList=" + bankBranchList + ", bankBranchSemList="
				+ bankBranchSemList + ", bankCodeList=" + bankCodeList
				+ ", bankList=" + bankList + ", bankMasterSlctList="
				+ bankMasterSlctList + ", bankNameList=" + bankNameList
				+ ", bankSearchSelected=" + bankSearchSelected
				+ ", bankSelList=" + bankSelList + ", bankSelectionSearchList="
				+ bankSelectionSearchList + ", bankSemList=" + bankSemList
				+ ", bankTmpSelList=" + bankTmpSelList
				+ ", blackListStatusList=" + blackListStatusList
				+ ", blockStatusList=" + blockStatusList
				+ ", bookbankFlowStatusList=" + bookbankFlowStatusList
				+ ", bookbankFlowStatusSemList=" + bookbankFlowStatusSemList
				+ ", bookbankHistList=" + bookbankHistList + ", bookbankId="
				+ bookbankId + ", bookbankInfo=" + bookbankInfo
				+ ", bookbankInfoCmpObj=" + bookbankInfoCmpObj
				+ ", bookbankInfoHist=" + bookbankInfoHist
				+ ", bookbankInfoMissMatchWithSAPObj="
				+ bookbankInfoMissMatchWithSAPObj + ", bookbankList="
				+ bookbankList + ", bookbankPayeeFlowStatusList="
				+ bookbankPayeeFlowStatusList
				+ ", bookbankPayeeFlowStatusSemList="
				+ bookbankPayeeFlowStatusSemList + ", bookbankPayeeHistList="
				+ bookbankPayeeHistList + ", bookbankPayeeId="
				+ bookbankPayeeId + ", bookbankPayeeInfo=" + bookbankPayeeInfo
				+ ", bookbankPayeeInfoCmpObj=" + bookbankPayeeInfoCmpObj
				+ ", bookbankPayeeInfoHist=" + bookbankPayeeInfoHist
				+ ", bookbankPayeeList=" + bookbankPayeeList
				+ ", bookbankPayeeStatusList=" + bookbankPayeeStatusList
				+ ", bookbankPayeeStatusSemList=" + bookbankPayeeStatusSemList
				+ ", bookbankSapInfo=" + bookbankSapInfo + ", bookbankSemInfo="
				+ bookbankSemInfo + ", bookbankStatusList="
				+ bookbankStatusList + ", bookbankStatusSemList="
				+ bookbankStatusSemList + ", chkForEdit=" + chkForEdit
				+ ", chkPayeeType=" + chkPayeeType + ", chkPicoType="
				+ chkPicoType + ", chkSelAll=" + chkSelAll
				+ ", chkSelAllTblAct=" + chkSelAllTblAct
				+ ", chkSelAllTblContractVendor=" + chkSelAllTblContractVendor
				+ ", chkSelAllTblTmn=" + chkSelAllTblTmn + ", chkVendorType="
				+ chkVendorType + ", companyList=" + companyList
				+ ", companySemList=" + companySemList
				+ ", constructAddrCmpObj=" + constructAddrCmpObj
				+ ", constructAddrObj=" + constructAddrObj
				+ ", contractHistList=" + contractHistList
				+ ", contractHistoryList=" + contractHistoryList
				+ ", contractInfo=" + contractInfo + ", contractInfoHist="
				+ contractInfoHist + ", contractList=" + contractList
				+ ", contractNo=" + contractNo + ", contractOfBookbankList="
				+ contractOfBookbankList + ", contractOfBookbankPayeeList="
				+ contractOfBookbankPayeeList + ", contractOfPayeeList="
				+ contractOfPayeeList + ", contractPayHistoryList="
				+ contractPayHistoryList + ", convertVendorResultList="
				+ convertVendorResultList + ", criteriaBank=" + criteriaBank
				+ ", criteriaBankMasterSP=" + criteriaBankMasterSP
				+ ", ct001ExBankList=" + ct001ExBankList
				+ ", disbledDialogField=" + disbledDialogField
				+ ", displayReport=" + displayReport + ", doMode=" + doMode
				+ ", electrictAddrCmpObj=" + electrictAddrCmpObj
				+ ", electrictAddrObj=" + electrictAddrObj
				+ ", expCntrctOfVndObj=" + expCntrctOfVndObj
				+ ", expenseTypeList=" + expenseTypeList
				+ ", expenseTypeSemList=" + expenseTypeSemList
				+ ", exportBatchInfo=" + exportBatchInfo
				+ ", exportBatchResultList=" + exportBatchResultList
				+ ", flowStatus=" + flowStatus + ", groupType=" + groupType
				+ ", historyInfo=" + historyInfo + ", historyPage="
				+ historyPage + ", historyResultList=" + historyResultList
				+ ", hqBranchList=" + hqBranchList + ", insureAddrCmpObj="
				+ insureAddrCmpObj + ", insureAddrObj=" + insureAddrObj
				+ ", isDisableBtnAssignOrAddContract="
				+ isDisableBtnAssignOrAddContract
				+ ", isDisableBtnChangeContractOfVendor="
				+ isDisableBtnChangeContractOfVendor + ", isDisableBtnDelete="
				+ isDisableBtnDelete + ", isDisableBtnDeleteBookbankOfPayee="
				+ isDisableBtnDeleteBookbankOfPayee
				+ ", isDisableBtnDeleteBookbankOfVendor="
				+ isDisableBtnDeleteBookbankOfVendor
				+ ", isDisableBtnDeleteContractOfVendor="
				+ isDisableBtnDeleteContractOfVendor
				+ ", isDisableBtnDeletePayeeOfVendor="
				+ isDisableBtnDeletePayeeOfVendor
				+ ", isDisableBtnDeleteVendor=" + isDisableBtnDeleteVendor
				+ ", isDisableBtnEditBookbank=" + isDisableBtnEditBookbank
				+ ", isDisableBtnEditBookbankPayee="
				+ isDisableBtnEditBookbankPayee + ", isDisableBtnEditPayee="
				+ isDisableBtnEditPayee + ", isDisableBtnEditVendor="
				+ isDisableBtnEditVendor + ", isDisableBtnExportBatchPB="
				+ isDisableBtnExportBatchPB + ", isDisableBtnExportBatchPY="
				+ isDisableBtnExportBatchPY + ", isDisableBtnExportBatchVB="
				+ isDisableBtnExportBatchVB + ", isDisableBtnExportBatchVD="
				+ isDisableBtnExportBatchVD + ", isDisableBtnHistory="
				+ isDisableBtnHistory + ", isDisableBtnNewBookbank="
				+ isDisableBtnNewBookbank
				+ ", isDisableBtnNewBookbankOfVendor="
				+ isDisableBtnNewBookbankOfVendor
				+ ", isDisableBtnNewBookbankPayee="
				+ isDisableBtnNewBookbankPayee + ", isDisableBtnNewPayee="
				+ isDisableBtnNewPayee + ", isDisableBtnNewPayeeOfVendor="
				+ isDisableBtnNewPayeeOfVendor + ", isDisableBtnNewVendor="
				+ isDisableBtnNewVendor + ", isDisableBtnPopupResult="
				+ isDisableBtnPopupResult + ", isDisableBtnSaveBookbank="
				+ isDisableBtnSaveBookbank + ", isDisableBtnSaveBookbankPayee="
				+ isDisableBtnSaveBookbankPayee + ", isDisableBtnSavePayee="
				+ isDisableBtnSavePayee + ", isDisableBtnSaveVendor="
				+ isDisableBtnSaveVendor + ", isDisableBtnSendManagerPB="
				+ isDisableBtnSendManagerPB + ", isDisableBtnSendManagerPY="
				+ isDisableBtnSendManagerPY + ", isDisableBtnSendManagerVB="
				+ isDisableBtnSendManagerVB + ", isDisableBtnSendManagerVD="
				+ isDisableBtnSendManagerVD + ", isDisableBtnSiteInfo="
				+ isDisableBtnSiteInfo + ", isDisableContent="
				+ isDisableContent + ", isDisableEditBookbankContent="
				+ isDisableEditBookbankContent
				+ ", isDisableEditBookbankPayeeContent="
				+ isDisableEditBookbankPayeeContent
				+ ", isDisableEditPayeeContent=" + isDisableEditPayeeContent
				+ ", isDisableEditVendorContent=" + isDisableEditVendorContent
				+ ", isVisiblePnlAddContractInfo="
				+ isVisiblePnlAddContractInfo + ", isVisiblePnlBankListInfo="
				+ isVisiblePnlBankListInfo
				+ ", isVisiblePnlBookbankPayeeListInfo="
				+ isVisiblePnlBookbankPayeeListInfo
				+ ", isVisiblePnlContractInfo=" + isVisiblePnlContractInfo
				+ ", isVisiblePnlContractListInfo="
				+ isVisiblePnlContractListInfo + ", isVisiblePnlVendorInfo="
				+ isVisiblePnlVendorInfo + ", itemBankMasterSP="
				+ itemBankMasterSP + ", menuTreeAbnormalList="
				+ menuTreeAbnormalList + ", menuTreeList=" + menuTreeList
				+ ", menuTreePayeeBookbankList=" + menuTreePayeeBookbankList
				+ ", menuTreePayeeList=" + menuTreePayeeList
				+ ", menuTreeVendorBookbankList=" + menuTreeVendorBookbankList
				+ ", menuTreeVendorList=" + menuTreeVendorList
				+ ", methodWithNaviBack=" + methodWithNaviBack
				+ ", navProgramBack=" + navProgramBack + ", navPrograme="
				+ navPrograme + ", pageParam=" + pageParam
				+ ", paramMenuGroup=" + paramMenuGroup + ", paramUrl="
				+ paramUrl + ", payeeFlowStatusList=" + payeeFlowStatusList
				+ ", payeeFlowStatusSemList=" + payeeFlowStatusSemList
				+ ", payeeHistList=" + payeeHistList + ", payeeId=" + payeeId
				+ ", payeeInfo=" + payeeInfo + ", payeeInfoCmpObj="
				+ payeeInfoCmpObj + ", payeeInfoHist=" + payeeInfoHist
				+ ", payeeList=" + payeeList + ", payeeStatusList="
				+ payeeStatusList + ", payeeStatusSemList="
				+ payeeStatusSemList + ", paymentHistList=" + paymentHistList
				+ ", paymentInfo=" + paymentInfo + ", paymentList="
				+ paymentList + ", popupCriteriaBankMasterSP="
				+ popupCriteriaBankMasterSP + ", popupPayeeResultList="
				+ popupPayeeResultList + ", popupSAPVendorInfo="
				+ popupSAPVendorInfo + ", popupSAPVendorlist="
				+ popupSAPVendorlist + ", popupSearchContractCriteria="
				+ popupSearchContractCriteria
				+ ", popupSearchContractResultList="
				+ popupSearchContractResultList + ", propertyAddrCmpObj="
				+ propertyAddrCmpObj + ", propertyAddrObj=" + propertyAddrObj
				+ ", provinceBookbankList=" + provinceBookbankList
				+ ", provinceList=" + provinceList + ", provinceSemList="
				+ provinceSemList + ", regionList=" + regionList
				+ ", regionSemList=" + regionSemList + ", rejectRemark="
				+ rejectRemark + ", renderedAskForNewContract="
				+ renderedAskForNewContract + ", renderedBtnBack="
				+ renderedBtnBack + ", renderedBtnNewVendor="
				+ renderedBtnNewVendor + ", renderedBtnSAPBookbankInfo="
				+ renderedBtnSAPBookbankInfo + ", renderedBtnSAPVendorInfo="
				+ renderedBtnSAPVendorInfo + ", renderedBtnTodoBack="
				+ renderedBtnTodoBack + ", renderedEditColumn="
				+ renderedEditColumn + ", renderedExportBatchResultAlert="
				+ renderedExportBatchResultAlert + ", renderedPanelVendor="
				+ renderedPanelVendor + ", renderedPnlCmpBookbankInfo="
				+ renderedPnlCmpBookbankInfo
				+ ", renderedPnlCmpBookbankPayeeInfo="
				+ renderedPnlCmpBookbankPayeeInfo
				+ ", renderedPnlCmpPayeeInfo=" + renderedPnlCmpPayeeInfo
				+ ", renderedPnlCmpVendorInfo=" + renderedPnlCmpVendorInfo
				+ ", renderedPnlForWithoutContract="
				+ renderedPnlForWithoutContract
				+ ", renderedPopupSAPBookbankInfo="
				+ renderedPopupSAPBookbankInfo
				+ ", renderedPopupSAPVendorInfo=" + renderedPopupSAPVendorInfo
				+ ", renderedResultMsgAlert=" + renderedResultMsgAlert
				+ ", renderedTodoRejectButton=" + renderedTodoRejectButton
				+ ", rentalAddrCmpObj=" + rentalAddrCmpObj + ", rentalAddrObj="
				+ rentalAddrObj + ", retResultObj=" + retResultObj
				+ ", rootNode=" + rootNode + ", selectIdList=" + selectIdList
				+ ", selectedRadio=" + selectedRadio + ", selectedRowIndex="
				+ selectedRowIndex + ", selectedSapTab=" + selectedSapTab
				+ ", selectedSemTab=" + selectedSemTab + ", selectedTab="
				+ selectedTab + ", semSapBookbankInfo=" + semSapBookbankInfo
				+ ", semSapBookbankList=" + semSapBookbankList
				+ ", semSapVendorInfo=" + semSapVendorInfo
				+ ", semSapVendorList=" + semSapVendorList + ", status="
				+ status + ", tabNo=" + tabNo + ", tambolList=" + tambolList
				+ ", tambolSemList=" + tambolSemList + ", teamList=" + teamList
				+ ", tmpBatch=" + tmpBatch + ", tmpBatchDT=" + tmpBatchDT
				+ ", todoManagerFlag=" + todoManagerFlag
				+ ", totalSumAbnormal=" + totalSumAbnormal + ", totalSumPayee="
				+ totalSumPayee + ", totalSumPayeeBookbank="
				+ totalSumPayeeBookbank + ", totalSumVendor=" + totalSumVendor
				+ ", totalSumVendorBookbank=" + totalSumVendorBookbank
				+ ", vendorAddrCmpObj=" + vendorAddrCmpObj + ", vendorAddrObj="
				+ vendorAddrObj + ", vendorBlackListStatusList="
				+ vendorBlackListStatusList + ", vendorBlockStatusList="
				+ vendorBlockStatusList + ", vendorBlockStatusSemList="
				+ vendorBlockStatusSemList + ", vendorContractHistList="
				+ vendorContractHistList + ", vendorContractList="
				+ vendorContractList + ", vendorFlowStatusList="
				+ vendorFlowStatusList + ", vendorFlowStatusSemList="
				+ vendorFlowStatusSemList + ", vendorId=" + vendorId
				+ ", vendorInfo=" + vendorInfo + ", vendorInfoCmpObj="
				+ vendorInfoCmpObj + ", vendorInfoHist=" + vendorInfoHist
				+ ", vendorInfoMissMatchWithSAPObj="
				+ vendorInfoMissMatchWithSAPObj + ", vendorInfoSap="
				+ vendorInfoSap + ", vendorInfoSem=" + vendorInfoSem
				+ ", vendorMasterCriteria=" + vendorMasterCriteria
				+ ", vendorMasterInfo=" + vendorMasterInfo
				+ ", vendorMasterResultList=" + vendorMasterResultList
				+ ", vendorMasterTerminateResultList="
				+ vendorMasterTerminateResultList + ", vendorSapAddrObj="
				+ vendorSapAddrObj + ", vendorSemAddrObj=" + vendorSemAddrObj
				+ ", vendorStatusList=" + vendorStatusList
				+ ", vendorStatusSemList=" + vendorStatusSemList
				+ ", vendorTypeList=" + vendorTypeList + ", vendorTypeSemList="
				+ vendorTypeSemList + ", withholdAddrCmpObj="
				+ withholdAddrCmpObj + ", withholdAddrObj=" + withholdAddrObj
				+ ", withholdList=" + withholdList + ", withholdSapAddrObj="
				+ withholdSapAddrObj + ", withholdSemAddrObj="
				+ withholdSemAddrObj + "]";
	}
	
	
}
