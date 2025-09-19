package th.co.ais.web.si.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.sa.SiteAppRegHistSrch;
import th.co.ais.domain.sa.SiteAppSP;
import th.co.ais.domain.si.Contract;
import th.co.ais.domain.si.Electric;
import th.co.ais.domain.si.Msi004SrchSiteStatusSP;
import th.co.ais.domain.si.PropertyTax;
import th.co.ais.domain.si.SiteApproveMapLocSP;
import th.co.ais.domain.si.SiteInfo;
import th.co.ais.domain.si.SiteInfoMapLoc;
import th.co.ais.domain.si.SiteInfoMapLocSP;
import th.co.ais.domain.si.SiteInfoMapSiteAcqSP;
import th.co.ais.domain.si.SiteInfoRegHistSrch;
import th.co.ais.domain.si.SumDepositRentSP;
import th.co.ais.domain.si.SumRentSP;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMMSI004Tab1Bean extends AbstractBean  {

	private static final long serialVersionUID = 1L;
	
	private List<SelectItem> rightAmphurList;
	private List<SelectItem> siteAmphurList;
	private List<SelectItem> placeTypeList;
	private List<SelectItem> deckAreaTypeList;
	private List<SelectItem> buildingAreaTypeList;
	private List<SelectItem> areaUnitTypeList;
	private List<SelectItem> propertyTaxTypeList;
	private List<SelectItem> propertyTaxPayTypeList;
	private List<SelectItem> roomAreaTypeList;
	private List<SelectItem> landAreaTypeList;
	private SiteInfo siteInfo;
	private SiteInfoMapLoc siteInfoMapLoc;
	private List<SiteInfoMapLocSP> siteInfoMapLocSPList;
	private List<SiteApproveMapLocSP> siteApproveMapLocSPList;
	private String confirmAddMsg;
	private boolean disableBtnAddLocation;
	private boolean disableBtnSaveLocation;
	private boolean chkPendingStatus;
	private PropertyTax sitePropertyTax;
	private Electric siteElectric;
	private boolean chkNoUnitPriceFlag;
	private boolean chkEditSite;
	private boolean chkElectricType1;
	private boolean chkElectricType2;
	private boolean chkElectricType3;
	private boolean chkElectricType4;
	private boolean chkMultiElectricTypeFlag;
	private SumRentSP sumRentSP;
	private SumDepositRentSP sumDepositRentSP;
	private boolean popupConfirmAdd;
	private boolean chkMainLocFlag;
	private boolean renderedBtnGenContractNo;
	private String confirmGenContractNo;
	private boolean renderedMsgLocation;
	private boolean renderContractNo;
	private boolean renderDummyContractNo;
	private boolean renderNoFormatContractNo;
	private String dummyContractNo;
	private boolean disabledPendingDate;
	private boolean disabledUnitPriceAmt;
	private boolean disabledTakeAllAmt;
	private String payPeriodType01;
	private String payPeriodType02;
	private String payPeriodType03;
	private String payPeriodType04;
	private String payPeriodType05;
	private Integer payPeriod03;
	private Integer payPeriod04;
	private boolean renderedElectricOwnerType;
	private boolean renderedVatType;
	private String confirmCopyOldSiteInfo;
	private boolean disabledPayPeriod03;
	private boolean disabledPayPeriod04;
	private boolean disabledSiteContractNo;
	private String cancelableFlag;
	private String editableSiteFlag;
	private String editablePropertyTaxFlag;
	private String editableElectricFlag;
	private boolean disabledSite;
	private boolean disabledPropertyTax;
	private boolean disabledElectric;
	private boolean disabledSiteInfoStatus;
	private boolean disabledPendingStatus;
	private String confirmChangeTab;
	private SiteInfo tempSiteInfo;
	private Contract tempContract;
	private PropertyTax tempPropertyTax;
	private Electric tempElectric;
	private boolean disabledChkNoUnitPriceFlag;
	private boolean disabledPropertyTaxUndefined;
	private String modeDelPopup;
	private String oldSiteInfoStatus;
	private boolean disabledTerminateDate;
	private boolean disabledSiteName;
	private boolean chkNoExpenses;
	
	private SiteInfoRegHistSrch siteAppExtServ; 
	private List<WrapperBeanObject<SiteInfoRegHistSrch>> siteAppExtServList;
	
	private SiteInfoRegHistSrch siteAppCurrServ; 
	private List<WrapperBeanObject<SiteInfoRegHistSrch>> siteAppCurrServList;
	
	private SiteInfoRegHistSrch siteAppServ; 
	private List<WrapperBeanObject<SiteInfoRegHistSrch>> siteAppServList;
	
	private Msi004SrchSiteStatusSP si004SrchSiteStatusSP;
	
	private SiteInfoMapSiteAcqSP siteInfoObjParam;
	
	private List<SelectItem> locationList;
	private List<SelectItem> provinceList;
	private List<SelectItem> amphurList;
	
	private List<SelectItem> servTypeList;
	
	private boolean chkEditLocalName;
	
	public boolean isRenderNoFormatContractNo() {
		return renderNoFormatContractNo;
	}

	public void setRenderNoFormatContractNo(boolean renderNoFormatContractNo) {
		this.renderNoFormatContractNo = renderNoFormatContractNo;
	}

	public boolean isDisabledSiteName() {
		return disabledSiteName;
	}

	public void setDisabledSiteName(boolean disabledSiteName) {
		this.disabledSiteName = disabledSiteName;
	}

	public boolean isDisabledTerminateDate() {
		return disabledTerminateDate;
	}

	public void setDisabledTerminateDate(boolean disabledTerminateDate) {
		this.disabledTerminateDate = disabledTerminateDate;
	}

	public String getOldSiteInfoStatus() {
		return oldSiteInfoStatus;
	}

	public void setOldSiteInfoStatus(String oldSiteInfoStatus) {
		this.oldSiteInfoStatus = oldSiteInfoStatus;
	}

	public String getModeDelPopup() {
		return modeDelPopup;
	}

	public void setModeDelPopup(String modeDelPopup) {
		this.modeDelPopup = modeDelPopup;
	}

	public boolean isDisabledPropertyTaxUndefined() {
		return disabledPropertyTaxUndefined;
	}

	public void setDisabledPropertyTaxUndefined(boolean disabledPropertyTaxUndefined) {
		this.disabledPropertyTaxUndefined = disabledPropertyTaxUndefined;
	}

	public boolean isDisabledChkNoUnitPriceFlag() {
		return disabledChkNoUnitPriceFlag;
	}

	public void setDisabledChkNoUnitPriceFlag(boolean disabledChkNoUnitPriceFlag) {
		this.disabledChkNoUnitPriceFlag = disabledChkNoUnitPriceFlag;
	}

	public SiteInfo getTempSiteInfo() {
		return tempSiteInfo;
	}

	public void setTempSiteInfo(SiteInfo tempSiteInfo) {
		this.tempSiteInfo = tempSiteInfo;
	}

	public Contract getTempContract() {
		return tempContract;
	}

	public void setTempContract(Contract tempContract) {
		this.tempContract = tempContract;
	}

	public PropertyTax getTempPropertyTax() {
		return tempPropertyTax;
	}

	public void setTempPropertyTax(PropertyTax tempPropertyTax) {
		this.tempPropertyTax = tempPropertyTax;
	}

	public Electric getTempElectric() {
		return tempElectric;
	}

	public void setTempElectric(Electric tempElectric) {
		this.tempElectric = tempElectric;
	}

	public String getConfirmChangeTab() {
		return confirmChangeTab;
	}

	public void setConfirmChangeTab(String confirmChangeTab) {
		this.confirmChangeTab = confirmChangeTab;
	}

	public boolean isDisabledPendingStatus() {
		return disabledPendingStatus;
	}

	public void setDisabledPendingStatus(boolean disabledPendingStatus) {
		this.disabledPendingStatus = disabledPendingStatus;
	}

	public boolean isDisabledSiteInfoStatus() {
		return disabledSiteInfoStatus;
	}

	public void setDisabledSiteInfoStatus(boolean disabledSiteInfoStatus) {
		this.disabledSiteInfoStatus = disabledSiteInfoStatus;
	}


	public boolean isDisabledSite() {
		return disabledSite;
	}

	public void setDisabledSite(boolean disabledSite) {
		this.disabledSite = disabledSite;
	}

	public boolean isDisabledPropertyTax() {
		return disabledPropertyTax;
	}

	public void setDisabledPropertyTax(boolean disabledPropertyTax) {
		this.disabledPropertyTax = disabledPropertyTax;
	}

	public boolean isDisabledElectric() {
		return disabledElectric;
	}

	public void setDisabledElectric(boolean disabledElectric) {
		this.disabledElectric = disabledElectric;
	}

	public String getEditableSiteFlag() {
		return editableSiteFlag;
	}

	public void setEditableSiteFlag(String editableSiteFlag) {
		this.editableSiteFlag = editableSiteFlag;
	}

	
	public String getEditablePropertyTaxFlag() {
		return editablePropertyTaxFlag;
	}

	public void setEditablePropertyTaxFlag(String editablePropertyTaxFlag) {
		this.editablePropertyTaxFlag = editablePropertyTaxFlag;
	}

	public String getEditableElectricFlag() {
		return editableElectricFlag;
	}

	public void setEditableElectricFlag(String editableElectricFlag) {
		this.editableElectricFlag = editableElectricFlag;
	}

	public String getCancelableFlag() {
		return cancelableFlag;
	}

	public void setCancelableFlag(String cancelableFlag) {
		this.cancelableFlag = cancelableFlag;
	}

	
	public boolean isDisabledSiteContractNo() {
		return disabledSiteContractNo;
	}

	public void setDisabledSiteContractNo(boolean disabledSiteContractNo) {
		this.disabledSiteContractNo = disabledSiteContractNo;
	}

	public boolean isDisabledPayPeriod03() {
		return disabledPayPeriod03;
	}

	public void setDisabledPayPeriod03(boolean disabledPayPeriod03) {
		this.disabledPayPeriod03 = disabledPayPeriod03;
	}

	public boolean isDisabledPayPeriod04() {
		return disabledPayPeriod04;
	}

	public void setDisabledPayPeriod04(boolean disabledPayPeriod04) {
		this.disabledPayPeriod04 = disabledPayPeriod04;
	}

	public String getConfirmCopyOldSiteInfo() {
		return confirmCopyOldSiteInfo;
	}

	public void setConfirmCopyOldSiteInfo(String confirmCopyOldSiteInfo) {
		this.confirmCopyOldSiteInfo = confirmCopyOldSiteInfo;
	}

	public boolean isRenderedVatType() {
		return renderedVatType;
	}

	public void setRenderedVatType(boolean renderedVatType) {
		this.renderedVatType = renderedVatType;
	}

	public boolean isRenderedElectricOwnerType() {
		return renderedElectricOwnerType;
	}

	public void setRenderedElectricOwnerType(boolean renderedElectricOwnerType) {
		this.renderedElectricOwnerType = renderedElectricOwnerType;
	}

	public String getPayPeriodType01() {
		return payPeriodType01;
	}

	public void setPayPeriodType01(String payPeriodType01) {
		this.payPeriodType01 = payPeriodType01;
	}

	public String getPayPeriodType02() {
		return payPeriodType02;
	}

	public void setPayPeriodType02(String payPeriodType02) {
		this.payPeriodType02 = payPeriodType02;
	}

	public String getPayPeriodType03() {
		return payPeriodType03;
	}

	public void setPayPeriodType03(String payPeriodType03) {
		this.payPeriodType03 = payPeriodType03;
	}

	public String getPayPeriodType04() {
		return payPeriodType04;
	}

	public void setPayPeriodType04(String payPeriodType04) {
		this.payPeriodType04 = payPeriodType04;
	}

	public String getPayPeriodType05() {
		return payPeriodType05;
	}

	public void setPayPeriodType05(String payPeriodType05) {
		this.payPeriodType05 = payPeriodType05;
	}

	public Integer getPayPeriod03() {
		return payPeriod03;
	}

	public void setPayPeriod03(Integer payPeriod03) {
		this.payPeriod03 = payPeriod03;
	}

	public Integer getPayPeriod04() {
		return payPeriod04;
	}

	public void setPayPeriod04(Integer payPeriod04) {
		this.payPeriod04 = payPeriod04;
	}

	public boolean isDisabledUnitPriceAmt() {
		return disabledUnitPriceAmt;
	}

	public void setDisabledUnitPriceAmt(boolean disabledUnitPriceAmt) {
		this.disabledUnitPriceAmt = disabledUnitPriceAmt;
	}

	public boolean isDisabledTakeAllAmt() {
		return disabledTakeAllAmt;
	}

	public void setDisabledTakeAllAmt(boolean disabledTakeAllAmt) {
		this.disabledTakeAllAmt = disabledTakeAllAmt;
	}

	public boolean isDisabledPendingDate() {
		return disabledPendingDate;
	}

	public void setDisabledPendingDate(boolean disabledPendingDate) {
		this.disabledPendingDate = disabledPendingDate;
	}

	public boolean isRenderDummyContractNo() {
		return renderDummyContractNo;
	}

	public void setRenderDummyContractNo(boolean renderDummyContractNo) {
		this.renderDummyContractNo = renderDummyContractNo;
	}

	public String getDummyContractNo() {
		return dummyContractNo;
	}

	public void setDummyContractNo(String dummyContractNo) {
		this.dummyContractNo = dummyContractNo;
	}

	public boolean isRenderContractNo() {
		return renderContractNo;
	}

	public void setRenderContractNo(boolean renderContractNo) {
		this.renderContractNo = renderContractNo;
	}

	public boolean isRenderedMsgLocation() {
		return renderedMsgLocation;
	}

	public void setRenderedMsgLocation(boolean renderedMsgLocation) {
		this.renderedMsgLocation = renderedMsgLocation;
	}

	public String getConfirmGenContractNo() {
		return confirmGenContractNo;
	}

	public void setConfirmGenContractNo(String confirmGenContractNo) {
		this.confirmGenContractNo = confirmGenContractNo;
	}

	public boolean isRenderedBtnGenContractNo() {
		return renderedBtnGenContractNo;
	}

	public void setRenderedBtnGenContractNo(boolean renderedBtnGenContractNo) {
		this.renderedBtnGenContractNo = renderedBtnGenContractNo;
	}


	public boolean isChkMainLocFlag() {
		return chkMainLocFlag;
	}

	public void setChkMainLocFlag(boolean chkMainLocFlag) {
		this.chkMainLocFlag = chkMainLocFlag;
	}

	public boolean isPopupConfirmAdd() {
		return popupConfirmAdd;
	}

	public void setPopupConfirmAdd(boolean popupConfirmAdd) {
		this.popupConfirmAdd = popupConfirmAdd;
	}

	public SumRentSP getSumRentSP() {
		return sumRentSP;
	}

	public void setSumRentSP(SumRentSP sumRentSP) {
		this.sumRentSP = sumRentSP;
	}

	public SumDepositRentSP getSumDepositRentSP() {
		return sumDepositRentSP;
	}

	public void setSumDepositRentSP(SumDepositRentSP sumDepositRentSP) {
		this.sumDepositRentSP = sumDepositRentSP;
	}

	public List<SelectItem> getAreaUnitTypeList() {
		return areaUnitTypeList;
	}

	public void setAreaUnitTypeList(List<SelectItem> areaUnitTypeList) {
		this.areaUnitTypeList = areaUnitTypeList;
	}

	public List<SelectItem> getPropertyTaxTypeList() {
		return propertyTaxTypeList;
	}

	public void setPropertyTaxTypeList(List<SelectItem> propertyTaxTypeList) {
		this.propertyTaxTypeList = propertyTaxTypeList;
	}

	public List<SelectItem> getPropertyTaxPayTypeList() {
		return propertyTaxPayTypeList;
	}

	public void setPropertyTaxPayTypeList(List<SelectItem> propertyTaxPayTypeList) {
		this.propertyTaxPayTypeList = propertyTaxPayTypeList;
	}

	public List<SelectItem> getPlaceTypeList() {
		return placeTypeList;
	}

	public void setPlaceTypeList(List<SelectItem> placeTypeList) {
		this.placeTypeList = placeTypeList;
	}

	public List<SelectItem> getDeckAreaTypeList() {
		return deckAreaTypeList;
	}

	public void setDeckAreaTypeList(List<SelectItem> deckAreaTypeList) {
		this.deckAreaTypeList = deckAreaTypeList;
	}

	public List<SelectItem> getBuildingAreaTypeList() {
		return buildingAreaTypeList;
	}

	public void setBuildingAreaTypeList(List<SelectItem> buildingAreaTypeList) {
		this.buildingAreaTypeList = buildingAreaTypeList;
	}

	public boolean isChkEditSite() {
		return chkEditSite;
	}

	public void setChkEditSite(boolean chkEditSite) {
		this.chkEditSite = chkEditSite;
	}


	public boolean isChkElectricType1() {
		return chkElectricType1;
	}

	public void setChkElectricType1(boolean chkElectricType1) {
		this.chkElectricType1 = chkElectricType1;
	}

	public boolean isChkElectricType2() {
		return chkElectricType2;
	}

	public void setChkElectricType2(boolean chkElectricType2) {
		this.chkElectricType2 = chkElectricType2;
	}

	public boolean isChkElectricType3() {
		return chkElectricType3;
	}

	public void setChkElectricType3(boolean chkElectricType3) {
		this.chkElectricType3 = chkElectricType3;
	}

	public boolean isChkElectricType4() {
		return chkElectricType4;
	}

	public void setChkElectricType4(boolean chkElectricType4) {
		this.chkElectricType4 = chkElectricType4;
	}

	public boolean isChkMultiElectricTypeFlag() {
		return chkMultiElectricTypeFlag;
	}

	public void setChkMultiElectricTypeFlag(boolean chkMultiElectricTypeFlag) {
		this.chkMultiElectricTypeFlag = chkMultiElectricTypeFlag;
	}

	public boolean isChkNoUnitPriceFlag() {
		return chkNoUnitPriceFlag;
	}

	public void setChkNoUnitPriceFlag(boolean chkNoUnitPriceFlag) {
		this.chkNoUnitPriceFlag = chkNoUnitPriceFlag;
	}

	public Electric getSiteElectric() {
		return siteElectric;
	}

	public void setSiteElectric(Electric siteElectric) {
		this.siteElectric = siteElectric;
	}

	public PropertyTax getSitePropertyTax() {
		return sitePropertyTax;
	}

	public void setSitePropertyTax(PropertyTax sitePropertyTax) {
		this.sitePropertyTax = sitePropertyTax;
	}

	public boolean isChkPendingStatus() {
		return chkPendingStatus;
	}

	public void setChkPendingStatus(boolean chkPendingStatus) {
		this.chkPendingStatus = chkPendingStatus;
	}

	public List<SelectItem> getSiteAmphurList() {
		return siteAmphurList;
	}

	public void setSiteAmphurList(List<SelectItem> siteAmphurList) {
		this.siteAmphurList = siteAmphurList;
	}

	public List<SiteApproveMapLocSP> getSiteApproveMapLocSPList() {
		return siteApproveMapLocSPList;
	}

	public void setSiteApproveMapLocSPList(
			List<SiteApproveMapLocSP> siteApproveMapLocSPList) {
		this.siteApproveMapLocSPList = siteApproveMapLocSPList;
	}


	public boolean isDisableBtnAddLocation() {
		return disableBtnAddLocation;
	}

	public void setDisableBtnAddLocation(boolean disableBtnAddLocation) {
		this.disableBtnAddLocation = disableBtnAddLocation;
	}

	public boolean isDisableBtnSaveLocation() {
		return disableBtnSaveLocation;
	}

	public void setDisableBtnSaveLocation(boolean disableBtnSaveLocation) {
		this.disableBtnSaveLocation = disableBtnSaveLocation;
	}


	public String getConfirmAddMsg() {
		return confirmAddMsg;
	}

	public void setConfirmAddMsg(String confirmAddMsg) {
		this.confirmAddMsg = confirmAddMsg;
	}

	public List<SiteInfoMapLocSP> getSiteInfoMapLocSPList() {
		return siteInfoMapLocSPList;
	}

	public void setSiteInfoMapLocSPList(List<SiteInfoMapLocSP> siteInfoMapLocSPList) {
		this.siteInfoMapLocSPList = siteInfoMapLocSPList;
	}

	public SiteInfoMapLoc getSiteInfoMapLoc() {
		return siteInfoMapLoc;
	}

	public void setSiteInfoMapLoc(SiteInfoMapLoc siteInfoMapLoc) {
		this.siteInfoMapLoc = siteInfoMapLoc;
	}

	public List<SelectItem> getRightAmphurList() {
		return rightAmphurList;
	}

	public void setRightAmphurList(List<SelectItem> rightAmphurList) {
		this.rightAmphurList = rightAmphurList;
	}

	public SiteInfo getSiteInfo() {
		return siteInfo;
	}

	public void setSiteInfo(SiteInfo siteInfo) {
		this.siteInfo = siteInfo;
	}
	

	public List<SelectItem> getRoomAreaTypeList() {
		return roomAreaTypeList;
	}

	public void setRoomAreaTypeList(List<SelectItem> roomAreaTypeList) {
		this.roomAreaTypeList = roomAreaTypeList;
	}

	public List<SelectItem> getLandAreaTypeList() {
		return landAreaTypeList;
	}

	public void setLandAreaTypeList(List<SelectItem> landAreaTypeList) {
		this.landAreaTypeList = landAreaTypeList;
	}


	public boolean isChkNoExpenses() {
		return chkNoExpenses;
	}

	public void setChkNoExpenses(boolean chkNoExpenses) {
		this.chkNoExpenses = chkNoExpenses;
	}

	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
		
	}

	public Msi004SrchSiteStatusSP getSi004SrchSiteStatusSP() {
		if(si004SrchSiteStatusSP == null)
		si004SrchSiteStatusSP = new Msi004SrchSiteStatusSP();
		return si004SrchSiteStatusSP;
	}

	public void setSi004SrchSiteStatusSP(
			Msi004SrchSiteStatusSP si004SrchSiteStatusSP) {
		this.si004SrchSiteStatusSP = si004SrchSiteStatusSP;
	}

	public SiteInfoMapSiteAcqSP getSiteInfoObjParam() {
		return siteInfoObjParam;
	}

	public void setSiteInfoObjParam(SiteInfoMapSiteAcqSP siteInfoObjParam) {
		this.siteInfoObjParam = siteInfoObjParam;
	}

	public SiteInfoRegHistSrch getSiteAppExtServ() {
		return siteAppExtServ;
	}

	public void setSiteAppExtServ(SiteInfoRegHistSrch siteAppExtServ) {
		this.siteAppExtServ = siteAppExtServ;
	}

	public List<WrapperBeanObject<SiteInfoRegHistSrch>> getSiteAppExtServList() {
		return siteAppExtServList;
	}

	public void setSiteAppExtServList(
			List<WrapperBeanObject<SiteInfoRegHistSrch>> siteAppExtServList) {
		this.siteAppExtServList = siteAppExtServList;
	}

	public SiteInfoRegHistSrch getSiteAppCurrServ() {
		return siteAppCurrServ;
	}

	public void setSiteAppCurrServ(SiteInfoRegHistSrch siteAppCurrServ) {
		this.siteAppCurrServ = siteAppCurrServ;
	}

	public List<WrapperBeanObject<SiteInfoRegHistSrch>> getSiteAppCurrServList() {
		return siteAppCurrServList;
	}

	public void setSiteAppCurrServList(
			List<WrapperBeanObject<SiteInfoRegHistSrch>> siteAppCurrServList) {
		this.siteAppCurrServList = siteAppCurrServList;
	}

	public SiteInfoRegHistSrch getSiteAppServ() {
		return siteAppServ;
	}

	public void setSiteAppServ(SiteInfoRegHistSrch siteAppServ) {
		this.siteAppServ = siteAppServ;
	}

	public List<WrapperBeanObject<SiteInfoRegHistSrch>> getSiteAppServList() {
		return siteAppServList;
	}

	public void setSiteAppServList(
			List<WrapperBeanObject<SiteInfoRegHistSrch>> siteAppServList) {
		this.siteAppServList = siteAppServList;
	}

	public List<SelectItem> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<SelectItem> locationList) {
		this.locationList = locationList;
	}

	public List<SelectItem> getProvinceList() {
		return provinceList;
	}

	public void setProvinceList(List<SelectItem> provinceList) {
		this.provinceList = provinceList;
	}

	public List<SelectItem> getAmphurList() {
		return amphurList;
	}

	public void setAmphurList(List<SelectItem> amphurList) {
		this.amphurList = amphurList;
	}

	public List<SelectItem> getServTypeList() {
		return servTypeList;
	}

	public void setServTypeList(List<SelectItem> servTypeList) {
		this.servTypeList = servTypeList;
	}

	public boolean isChkEditLocalName() {
		return chkEditLocalName;
	}

	public void setChkEditLocalName(boolean chkEditLocalName) {
		this.chkEditLocalName = chkEditLocalName;
	}
	
	

}
