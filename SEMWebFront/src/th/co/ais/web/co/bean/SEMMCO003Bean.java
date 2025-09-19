package th.co.ais.web.co.bean;

import java.util.HashMap;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.co.BorrowContract;
import th.co.ais.domain.co.BorrowRequest;
import th.co.ais.domain.co.Mco003SearchBorrowSP;
import th.co.ais.domain.co.Mco003SearchPSI002SP;
import th.co.ais.domain.co.Mco003SrchBorrowRequestSP;
import th.co.ais.domain.co.ReturnContract;
import th.co.ais.domain.gm.BgMasterSP;
import th.co.ais.domain.sa.SiteAppSP;
import th.co.ais.domain.si.LegalApprove;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;
import th.co.ais.web.sa.bean.LegalDocComponentBean;

public class SEMMCO003Bean  extends AbstractBean  {
	
	private Mco003SrchBorrowRequestSP criteria;
	private Mco003SearchBorrowSP criteriaBorrow;
	private String addPreContractNo;
	private String addContractNo;
	private String viewContractNo;
	private String addContractNoList;
	// 20110106
	private String cacheContractSrch;
	private String cacheContractAdd;
	
	private List<Mco003SrchBorrowRequestSP> searchResult;
	private List<SelectItem> companyList;
	private List<SelectItem> borrowOfficerList;
	private List<WrapperBeanObject<Mco003SrchBorrowRequestSP>> borrowRequestSPList;
	private List<WrapperBeanObject<Mco003SearchBorrowSP>> borrowSPList;
	private List<WrapperBeanObject<Mco003SearchPSI002SP>> contractSPList;
	// 20110106
	private List<WrapperBeanObject<Mco003SearchBorrowSP>> cacheSrchBorrowList;
	private List<WrapperBeanObject<Mco003SearchBorrowSP>> cacheAddBorrowList;

	private BorrowRequest borrowRequest;
	private BorrowContract borrowContract;
	private ReturnContract returnContract;
	private String mode;
	private String modeReturn;
	private Boolean popupClose = false;
	
	private Boolean disableChk1;
	private Boolean disableChk2;
	private Boolean disableChk3;
	private Boolean disableChk4;
	private Boolean disableChk5;
	private Boolean disableChk6;
	private Boolean disableChk7;
	private Boolean disableChk8;
	private LegalApprove legalApprove;
	
	private List doc1List;
	private List doc2List;
	private List doc3List;
	private List doc4List;
	private List doc5List;
	private List doc6List;
	private List doc7List;
	private List doc8List;
	private List doc9List;
	private List doc10List;
	private List docOtherList;
	
	private HashMap pnlRentType;
	private String temp;
	
	private String insertBorrowID;
	private Boolean pageMode;
	
	//Highlight whole row.
	private String tmpRowId;
	private String tmpRowId2;
	
	//Export Excel
	private boolean chkSelAll = false;
	private boolean disabledBtnExport=true;
	public List<WrapperBeanObject<BgMasterSP>> bgMasterList;
	
	// 20101210 
	private String borrowRequestIdDel;
	private String borrowContractIdDel;
	private String returnContractIdDel;
	
	// 20110124
	private String borrowContractIdList;
	private boolean popupBorrowOpen;
	private boolean popupAlert;
	private String contentAlert;
	private String btnBorrowPopup;
	
	// 20110214
	private Integer sumSite;
	private boolean disBtnBorrow;
	
	private List<SelectItem> borrowNameList;
	private boolean disTxtBorrowName;
	private boolean disTxtReturnName;
	private String otherBorrowName;
	private String otherReturnName;
	//20121017
	private List<SelectItem> borrowForList;
	private String contractAdd;
	private String fromPopup;
	private String tmpCompany;
	private String tmpDocNo;
	private boolean onePopupFlag; 
	private String effDtStr;
	private String expDtStr;
	public String scrollerPopupPage = "1";
	public boolean disabledBtnAdd = true;
	
	//added by new 21/07/2015
	private List<SelectItem> legalPlaceTypeList;
	private List<SelectItem> legalPartiesTypeList;
	private SiteAppSP siteAppObjParam;
	public List<WrapperBeanObject<LegalDocComponentBean>> legalDocList;
	
	
	//add 28/11/2022
	private boolean docContractFlagBoolean;
	private boolean docApproveFlagBoolean;
	private boolean docOtherFlagBoolean;
	private boolean cannotBorrowFlagBoolean;
	
	private boolean returnDocContractFlagBoolean;
	private boolean returnDocApproveFlagBoolean;
	private boolean returnDocOtherFlagBoolean;
	
	private boolean returnNotAllFlagBoolean;	
	private boolean docOtherAddFlagBoolean;
	private boolean disabledCheckBox;	

	public boolean isDisTxtReturnName() {
		return disTxtReturnName;
	}
	public void setDisTxtReturnName(boolean disTxtReturnName) {
		this.disTxtReturnName = disTxtReturnName;
	}
	public String getOtherReturnName() {
		return otherReturnName;
	}
	public void setOtherReturnName(String otherReturnName) {
		this.otherReturnName = otherReturnName;
	}
	public String getOtherBorrowName() {
		return otherBorrowName;
	}
	public void setOtherBorrowName(String otherBorrowName) {
		this.otherBorrowName = otherBorrowName;
	}
	public boolean isDisTxtBorrowName() {
		return disTxtBorrowName;
	}
	public void setDisTxtBorrowName(boolean disTxtBorrowName) {
		this.disTxtBorrowName = disTxtBorrowName;
	}
	public List<SelectItem> getBorrowNameList() {
		return borrowNameList;
	}
	public void setBorrowNameList(List<SelectItem> borrowNameList) {
		this.borrowNameList = borrowNameList;
	}
	public String getModeReturn() {
		return modeReturn;
	}
	public void setModeReturn(String modeReturn) {
		this.modeReturn = modeReturn;
	}
	public boolean isDisBtnBorrow() {
		return disBtnBorrow;
	}
	public void setDisBtnBorrow(boolean disBtnBorrow) {
		this.disBtnBorrow = disBtnBorrow;
	}
	public Integer getSumSite() {
		return sumSite;
	}
	public void setSumSite(Integer sumSite) {
		this.sumSite = sumSite;
	}
	public String getBtnBorrowPopup() {
		return btnBorrowPopup;
	}
	public void setBtnBorrowPopup(String btnBorrowPopup) {
		this.btnBorrowPopup = btnBorrowPopup;
	}
	public String getContentAlert() {
		return contentAlert;
	}
	public void setContentAlert(String contentAlert) {
		this.contentAlert = contentAlert;
	}
	public boolean isPopupAlert() {
		return popupAlert;
	}
	public void setPopupAlert(boolean popupAlert) {
		this.popupAlert = popupAlert;
	}
	public boolean isPopupBorrowOpen() {
		return popupBorrowOpen;
	}
	public void setPopupBorrowOpen(boolean popupBorrowOpen) {
		this.popupBorrowOpen = popupBorrowOpen;
	}
	public String getBorrowContractIdList() {
		return borrowContractIdList;
	}
	public void setBorrowContractIdList(String borrowContractIdList) {
		this.borrowContractIdList = borrowContractIdList;
	}
	public String getCacheContractSrch() {
		return cacheContractSrch;
	}
	public void setCacheContractSrch(String cacheContractSrch) {
		this.cacheContractSrch = cacheContractSrch;
	}
	public String getCacheContractAdd() {
		return cacheContractAdd;
	}
	public void setCacheContractAdd(String cacheContractAdd) {
		this.cacheContractAdd = cacheContractAdd;
	}
	public List<WrapperBeanObject<Mco003SearchBorrowSP>> getCacheSrchBorrowList() {
		return cacheSrchBorrowList;
	}
	public Boolean getDisableChk8() {
		return disableChk8;
	}
	public void setDisableChk8(Boolean disableChk8) {
		this.disableChk8 = disableChk8;
	}
	public void setCacheSrchBorrowList(
			List<WrapperBeanObject<Mco003SearchBorrowSP>> cacheSrchBorrowList) {
		this.cacheSrchBorrowList = cacheSrchBorrowList;
	}
	public List<WrapperBeanObject<Mco003SearchBorrowSP>> getCacheAddBorrowList() {
		return cacheAddBorrowList;
	}
	public void setCacheAddBorrowList(
			List<WrapperBeanObject<Mco003SearchBorrowSP>> cacheAddBorrowList) {
		this.cacheAddBorrowList = cacheAddBorrowList;
	}
	public String getTmpRowId2() {
		return tmpRowId2;
	}
	public void setTmpRowId2(String tmpRowId2) {
		this.tmpRowId2 = tmpRowId2;
	}
	public String getBorrowContractIdDel() {
		return borrowContractIdDel;
	}
	public void setBorrowContractIdDel(String borrowContractIdDel) {
		this.borrowContractIdDel = borrowContractIdDel;
	}
	public String getReturnContractIdDel() {
		return returnContractIdDel;
	}
	public void setReturnContractIdDel(String returnContractIdDel) {
		this.returnContractIdDel = returnContractIdDel;
	}
	public String getBorrowRequestIdDel() {
		return borrowRequestIdDel;
	}
	public void setBorrowRequestIdDel(String borrowRequestIdDel) {
		this.borrowRequestIdDel = borrowRequestIdDel;
	}
	public Mco003SrchBorrowRequestSP getCriteria() {
		return criteria;
	}
	public void setCriteria(Mco003SrchBorrowRequestSP criteria) {
		this.criteria = criteria;
	}
	public List<Mco003SrchBorrowRequestSP> getSearchResult() {
		return searchResult;
	}
	public void setSearchResult(List<Mco003SrchBorrowRequestSP> searchResult) {
		this.searchResult = searchResult;
	}
	public List<SelectItem> getCompanyList() {
		return companyList;
	}
	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}
	
	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	public List<WrapperBeanObject<Mco003SrchBorrowRequestSP>> getBorrowRequestSPList() {
		return borrowRequestSPList;
	}
	public void setBorrowRequestSPList(
			List<WrapperBeanObject<Mco003SrchBorrowRequestSP>> borrowRequestSPList) {
		this.borrowRequestSPList = borrowRequestSPList;
	}
	public BorrowRequest getBorrowRequest() {
		return borrowRequest;
	}
	public void setBorrowRequest(BorrowRequest borrowRequest) {
		this.borrowRequest = borrowRequest;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public Boolean getPopupClose() {
		return popupClose;
	}
	public void setPopupClose(Boolean popupClose) {
		this.popupClose = popupClose;
	}
	public List<WrapperBeanObject<Mco003SearchBorrowSP>> getBorrowSPList() {
		return borrowSPList;
	}
	public void setBorrowSPList(
			List<WrapperBeanObject<Mco003SearchBorrowSP>> borrowSPList) {
		this.borrowSPList = borrowSPList;
	}
	public Mco003SearchBorrowSP getCriteriaBorrow() {
		return criteriaBorrow;
	}
	public void setCriteriaBorrow(Mco003SearchBorrowSP criteriaBorrow) {
		this.criteriaBorrow = criteriaBorrow;
	}
	public BorrowContract getBorrowContract() {
		return borrowContract;
	}
	public void setBorrowContract(BorrowContract borrowContract) {
		this.borrowContract = borrowContract;
	}
	public List<SelectItem> getBorrowOfficerList() {
		return borrowOfficerList;
	}
	public void setBorrowOfficerList(List<SelectItem> borrowOfficerList) {
		this.borrowOfficerList = borrowOfficerList;
	}
	public String getInsertBorrowID() {
		return insertBorrowID;
	}
	public void setInsertBorrowID(String insertBorrowID) {
		this.insertBorrowID = insertBorrowID;
	}
	public ReturnContract getReturnContract() {
		return returnContract;
	}
	public void setReturnContract(ReturnContract returnContract) {
		this.returnContract = returnContract;
	}
	public Boolean getDisableChk1() {
		return disableChk1;
	}
	public void setDisableChk1(Boolean disableChk1) {
		this.disableChk1 = disableChk1;
	}
	public Boolean getDisableChk2() {
		return disableChk2;
	}
	public void setDisableChk2(Boolean disableChk2) {
		this.disableChk2 = disableChk2;
	}
	public Boolean getDisableChk3() {
		return disableChk3;
	}
	public void setDisableChk3(Boolean disableChk3) {
		this.disableChk3 = disableChk3;
	}
	public Boolean getDisableChk4() {
		return disableChk4;
	}
	public void setDisableChk4(Boolean disableChk4) {
		this.disableChk4 = disableChk4;
	}
	public Boolean getDisableChk5() {
		return disableChk5;
	}
	public void setDisableChk5(Boolean disableChk5) {
		this.disableChk5 = disableChk5;
	}
	public Boolean getDisableChk6() {
		return disableChk6;
	}
	public void setDisableChk6(Boolean disableChk6) {
		this.disableChk6 = disableChk6;
	}
	public Boolean getDisableChk7() {
		return disableChk7;
	}
	public void setDisableChk7(Boolean disableChk7) {
		this.disableChk7 = disableChk7;
	}
	public LegalApprove getLegalApprove() {
		return legalApprove;
	}
	public void setLegalApprove(LegalApprove legalApprove) {
		this.legalApprove = legalApprove;
	}
	public List getDoc1List() {
		return doc1List;
	}
	public void setDoc1List(List doc1List) {
		this.doc1List = doc1List;
	}
	public List getDoc2List() {
		return doc2List;
	}
	public void setDoc2List(List doc2List) {
		this.doc2List = doc2List;
	}
	public List getDoc3List() {
		return doc3List;
	}
	public void setDoc3List(List doc3List) {
		this.doc3List = doc3List;
	}
	public List getDoc4List() {
		return doc4List;
	}
	public void setDoc4List(List doc4List) {
		this.doc4List = doc4List;
	}
	public List getDoc5List() {
		return doc5List;
	}
	public void setDoc5List(List doc5List) {
		this.doc5List = doc5List;
	}
	public List getDoc6List() {
		return doc6List;
	}
	public void setDoc6List(List doc6List) {
		this.doc6List = doc6List;
	}
	public List getDoc7List() {
		return doc7List;
	}
	public void setDoc7List(List doc7List) {
		this.doc7List = doc7List;
	}
	public List getDoc8List() {
		return doc8List;
	}
	public void setDoc8List(List doc8List) {
		this.doc8List = doc8List;
	}
	public List getDoc9List() {
		return doc9List;
	}
	public void setDoc9List(List doc9List) {
		this.doc9List = doc9List;
	}
	public List getDoc10List() {
		return doc10List;
	}
	public void setDoc10List(List doc10List) {
		this.doc10List = doc10List;
	}
	public List getDocOtherList() {
		return docOtherList;
	}
	public void setDocOtherList(List docOtherList) {
		this.docOtherList = docOtherList;
	}
	public HashMap getPnlRentType() {
		return pnlRentType;
	}
	public void setPnlRentType(HashMap pnlRentType) {
		this.pnlRentType = pnlRentType;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public Boolean getPageMode() {
		return pageMode;
	}
	public void setPageMode(Boolean pageMode) {
		this.pageMode = pageMode;
	}
	public String getTmpRowId() {
		return tmpRowId;
	}
	public void setTmpRowId(String tmpRowId) {
		this.tmpRowId = tmpRowId;
	}
	public boolean isChkSelAll() {
		return chkSelAll;
	}
	public void setChkSelAll(boolean chkSelAll) {
		this.chkSelAll = chkSelAll;
	}
	public boolean isDisabledBtnExport() {
		return disabledBtnExport;
	}
	public void setDisabledBtnExport(boolean disabledBtnExport) {
		this.disabledBtnExport = disabledBtnExport;
	}
	public List<WrapperBeanObject<BgMasterSP>> getBgMasterList() {
		return bgMasterList;
	}
	public void setBgMasterList(List<WrapperBeanObject<BgMasterSP>> bgMasterList) {
		this.bgMasterList = bgMasterList;
	}
	public String getAddContractNo() {
		return addContractNo;
	}
	public void setAddContractNo(String addContractNo) {
		this.addContractNo = addContractNo;
	}
	public String getAddContractNoList() {
		return addContractNoList;
	}
	public void setAddContractNoList(String addContractNoList) {
		this.addContractNoList = addContractNoList;
	}
	public String getViewContractNo() {
		return viewContractNo;
	}
	public void setViewContractNo(String viewContractNo) {
		this.viewContractNo = viewContractNo;
	}
	public String getAddPreContractNo() {
		return addPreContractNo;
	}
	public void setAddPreContractNo(String addPreContractNo) {
		this.addPreContractNo = addPreContractNo;
	}
	public List<SelectItem> getBorrowForList() {
		return borrowForList;
	}
	public void setBorrowForList(List<SelectItem> borrowForList) {
		this.borrowForList = borrowForList;
	}
	public String getContractAdd() {
		return contractAdd;
	}
	public void setContractAdd(String contractAdd) {
		this.contractAdd = contractAdd;
	}
	public String getFromPopup() {
		return fromPopup;
	}
	public void setFromPopup(String fromPopup) {
		this.fromPopup = fromPopup;
	}
	public String getTmpCompany() {
		return tmpCompany;
	}
	public void setTmpCompany(String tmpCompany) {
		this.tmpCompany = tmpCompany;
	}
	public String getTmpDocNo() {
		return tmpDocNo;
	}
	public void setTmpDocNo(String tmpDocNo) {
		this.tmpDocNo = tmpDocNo;
	}
	public boolean isOnePopupFlag() {
		return onePopupFlag;
	}
	public void setOnePopupFlag(boolean onePopupFlag) {
		this.onePopupFlag = onePopupFlag;
	}
	public String getEffDtStr() {
		return effDtStr;
	}
	public void setEffDtStr(String effDtStr) {
		this.effDtStr = effDtStr;
	}
	public String getExpDtStr() {
		return expDtStr;
	}
	public void setExpDtStr(String expDtStr) {
		this.expDtStr = expDtStr;
	}
	public List<WrapperBeanObject<Mco003SearchPSI002SP>> getContractSPList() {
		return contractSPList;
	}
	public void setContractSPList(
			List<WrapperBeanObject<Mco003SearchPSI002SP>> contractSPList) {
		this.contractSPList = contractSPList;
	}
	public String getScrollerPopupPage() {
		return scrollerPopupPage;
	}
	public void setScrollerPopupPage(String scrollerPopupPage) {
		this.scrollerPopupPage = scrollerPopupPage;
	}
	public boolean isDisabledBtnAdd() {
		return disabledBtnAdd;
	}
	public void setDisabledBtnAdd(boolean disabledBtnAdd) {
		this.disabledBtnAdd = disabledBtnAdd;
	}
	public List<SelectItem> getLegalPlaceTypeList() {
		return legalPlaceTypeList;
	}
	public void setLegalPlaceTypeList(List<SelectItem> legalPlaceTypeList) {
		this.legalPlaceTypeList = legalPlaceTypeList;
	}
	public List<SelectItem> getLegalPartiesTypeList() {
		return legalPartiesTypeList;
	}
	public void setLegalPartiesTypeList(List<SelectItem> legalPartiesTypeList) {
		this.legalPartiesTypeList = legalPartiesTypeList;
	}
	public SiteAppSP getSiteAppObjParam() {
		return siteAppObjParam;
	}
	public void setSiteAppObjParam(SiteAppSP siteAppObjParam) {
		this.siteAppObjParam = siteAppObjParam;
	}
	public List<WrapperBeanObject<LegalDocComponentBean>> getLegalDocList() {
		return legalDocList;
	}
	public void setLegalDocList(
			List<WrapperBeanObject<LegalDocComponentBean>> legalDocList) {
		this.legalDocList = legalDocList;
	}
	
	public boolean isDocContractFlagBoolean() {
		if(this.borrowContract != null && "true".equalsIgnoreCase(this.borrowContract.getDocContractFlag())) {
			this.docContractFlagBoolean =true;
		} else {
			this.docContractFlagBoolean =false;
			
		}
		return docContractFlagBoolean;
	}
	
	//Borrow
	public boolean isDocApproveFlagBoolean() {
		if(this.borrowContract != null && "true".equalsIgnoreCase(this.borrowContract.getDocApproveFlag())) {
			this.docApproveFlagBoolean=true;
		} else {
			this.docApproveFlagBoolean=false;
		}
		return docApproveFlagBoolean;
	}

	public boolean isDocOtherFlagBoolean() {
		if(this.borrowContract != null && "true".equalsIgnoreCase(this.borrowContract.getDocOtherFlag())) {
			this.docOtherFlagBoolean = true;
		} else {
			this.docOtherFlagBoolean = false;
		}
		return docOtherFlagBoolean;
	}

	public boolean isCannotBorrowFlagBoolean() {		
		 return cannotBorrowFlagBoolean;
	}
	
	
 // Return
	public boolean isReturnDocContractFlagBoolean() {		
		return returnDocContractFlagBoolean;
	}
	
	public boolean isReturnDocApproveFlagBoolean() {	
		return returnDocApproveFlagBoolean;
	}

	public boolean isReturnDocOtherFlagBoolean() {		
		return returnDocOtherFlagBoolean;
	}


	
	public boolean isReturnNotAllFlagBoolean() {	
		return returnNotAllFlagBoolean;
	}
	
	public boolean isDocOtherAddFlagBoolean() {				
		return docOtherAddFlagBoolean;
	}
	
	public void setDocContractFlagBoolean(boolean docContractFlagBoolean) {
		this.docContractFlagBoolean = docContractFlagBoolean;
	}
	public void setDocApproveFlagBoolean(boolean docApproveFlagBoolean) {
		this.docApproveFlagBoolean = docApproveFlagBoolean;
	}
	public void setDocOtherFlagBoolean(boolean docOtherFlagBoolean) {
		this.docOtherFlagBoolean = docOtherFlagBoolean;
	}
	public void setCannotBorrowFlagBoolean(boolean cannotBorrowFlagBoolean) {
		this.cannotBorrowFlagBoolean = cannotBorrowFlagBoolean;
	}
	public void setReturnNotAllFlagBoolean(boolean returnNotAllFlagBoolean) {
		this.returnNotAllFlagBoolean = returnNotAllFlagBoolean;
	}
	public boolean isDisabledCheckBox() {
		return disabledCheckBox;
	}
	public void setDisabledCheckBox(boolean disabledCheckBox) {
		this.disabledCheckBox = disabledCheckBox;
	}
	
	public void setDocOtherAddFlagBoolean(boolean docOtherAddFlagBoolean) {
		this.docOtherAddFlagBoolean = docOtherAddFlagBoolean;
		
	}
	public void setReturnDocContractFlagBoolean(boolean returnDocContractFlagBoolean) {
		this.returnDocContractFlagBoolean = returnDocContractFlagBoolean;
	}
	public void setReturnDocApproveFlagBoolean(boolean returnDocApproveFlagBoolean) {
		this.returnDocApproveFlagBoolean = returnDocApproveFlagBoolean;
	}
	public void setReturnDocOtherFlagBoolean(boolean returnDocOtherFlagBoolean) {
		this.returnDocOtherFlagBoolean = returnDocOtherFlagBoolean;
	}
	
	

}
