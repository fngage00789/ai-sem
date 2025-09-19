package th.co.ais.web.si.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.mm.ItemResultSP;
import th.co.ais.domain.sa.SiteAppSP;
import th.co.ais.domain.si.Deposit;
import th.co.ais.domain.si.Electric;
import th.co.ais.domain.si.Msi004SrchDepositElectricSP;
import th.co.ais.domain.si.Msi004SrchSumDpstESP;
import th.co.ais.domain.si.SiteInfoMapSiteAcqSP;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMMSI004Tab5Bean extends AbstractBean {

	private static final long serialVersionUID = 2139509598034691594L;

	private String payPeriodType01;
	private String payPeriodType02;
	private String payPeriodType03;
	private String payPeriodType04;
	private String payPeriodType05;
	private Integer payPeriod03;
	private Integer payPeriod04;
	private Deposit electricDepositNormal;
	private Deposit electricDepositSpecialBg;
	private Deposit electricDepositSpecialCash;
	private boolean renderElectricDepositNormal;
	private boolean renderElectricDepositSpecial;
	private List<Msi004SrchDepositElectricSP> depositElectricBgSPList;
	private List<Msi004SrchDepositElectricSP> depositElectricCashSPList;
	private boolean disabledBtnAddElectricDepositNormal;
	private boolean disabledBtnSaveElectricDepositNormal;
	private boolean chkElectricType1;
	private boolean chkElectricType2;
	private boolean chkElectricType3;
	private boolean chkElectricType4;
	
	private boolean chkElectricType5;
	private boolean chkElectricType6;
	private String electricOthDetail;
	
	private boolean chkMultiElectricTypeFlag;
	private Electric siteElectric;
	private boolean chkNoUnitPriceFlag;
	private Msi004SrchSumDpstESP sumDepositElectric;
	private boolean renderVatType;
	private String siteInfoId;
	private boolean renderedElectricOwnerType;
	private List<Msi004SrchDepositElectricSP> electricDepositSpecialSPList;
	private boolean disabledUnitPriceAmt;
	private boolean disabledTakeAllAmt;
	private boolean renderedVatType;
	private boolean chkNoDepositElectric;
	private boolean disabledPayPeriod03;
	private boolean disabledPayPeriod04;
	private boolean renderedNoDepositElectric;
	private boolean disabledSiteContractNo;
	private String editableDepositElectricFlag;
	private boolean disabledDepositElectric;
	private boolean renderedNoDepositElectric2;
	private boolean disabledChkNoUnitPriceFlag;
	private boolean disabledTotalNormalDeposit;
	private Electric totalDeposit;
	private boolean disabledChkNoDeposit;
	
	private boolean disabledOldInsurance = false;
	private boolean chkNoExpenses;
	private boolean chNoUnit = false;
	//added by oum 20160916
	private String noDepositElectric;
	
	//added by NEW 20180904
	private SiteInfoMapSiteAcqSP siteInfoObjParam;
	private SiteInfoMapSiteAcqSP siteInfoObjELParam;
	private SiteInfoMapSiteAcqSP siteInfoDeptCashObj;
	private SiteInfoMapSiteAcqSP siteInfoDeptBgObj;
	private SiteInfoMapSiteAcqSP siteInfoDeptElObj;
	private SiteInfoMapSiteAcqSP siteInfoDeptCashElObj;
	private SiteInfoMapSiteAcqSP siteInfoDeptBgElObj;
	
	private List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> siteInfoDeptBGElList;
	private List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> siteInfoDeptCashElList;
	
	private boolean chkElUseOth;
	private boolean chkEditELDeposit;
	private boolean renderedPnlDeptBgEl;
	private boolean renderedPnlDeptCashEl;
	
	private String DeptReturnTypeEl01;
	private String DeptReturnTypeEl02;
	private String DeptReturnTypeEl03;
	
	private boolean withdrawFlagEl;
	
	private boolean renderedMsgAlert;
	private boolean renderedPanelDisplay;
	private boolean chkElUseOwner;
	private boolean elUnitPrice;
	private boolean chkElUseOthSite;
	private boolean chkNoUtilPrice;
	
	private String elPayPeriodType01;
	private String elPayPeriodType02;
	private String elPayPeriodType03;
	private String elPayPeriodType04;
	private String elPayPeriodType05;
	private String elPayPeriodType06;
	private String elPayPeriodType07;
	private Integer elPayPeriod03;
	private Integer elPayPeriod04;
	private boolean disabledElPayPeriod03;
	private boolean disabledElPayPeriod04;
	private boolean chkElUseNewMeter;
	private boolean chkElUseOldMeter;
	private boolean chkElPayOnPackage;
	private boolean chkElOwnerType;
	private boolean chkElDepositFlag;
	private List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> siteInfoELCondExistingList;
	private List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> siteInfoELCondTakeAllList;
	private List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> siteInfoELCondUnitList;
	private List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> siteInfoELCondNoExpenseList;
	private List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> siteInfoELCondOtherList;
	private boolean renderedTbElUnit;
	private boolean renderedTbElTakeAll;
	private boolean renderedTbElNoExpense;
	private List<SelectItem> servTypeList;
	private List<SelectItem> expenseTypeDepositElList;
	private List<SelectItem> elCondTypeList;
	private List<SelectItem> elCondSubTypeList;
	private List<SelectItem> promiseRenewPeriodTypeList;
	private boolean disabledElUserOthSite;
	
	private List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> siteAppELCondExistingList;
	private List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> siteAppELCondTakeAllList;
	private List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> siteAppELCondUnitList;
	private List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> siteAppELCondNoExpenseList;
	private List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> siteAppELCondOtherList;
	
	private SiteInfoMapSiteAcqSP contractElUseObjParam;
	public List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> contractElUseList;
	private List<SelectItem> companyList;
	
	private boolean renderedTbElUseOth;
	
	private List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> siteInfoELCondAllList;
	private String pRemark;
	
	private boolean disabledModeViewOnly = false;
	private String msgReqcompanyPopup;
	private boolean noExpFlag;
	private SiteInfoMapSiteAcqSP siteContInfo;
	private ItemResultSP retResultObj;
	private boolean renderedMsgPopup;
	private SiteInfoMapSiteAcqSP siteInfoDeptObj;
	private List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> siteInfoDeptBGList;
	private List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> siteInfoDeptCashList;
	
	private String elEditFlag = "N";
	private String elDepositEditFlag = "N";
	private boolean chkElEditFlag;
	private boolean chkElDepositEditFlag;
	
	private Deposit siteDepositNormal;
	private Deposit siteDepositSpecialBg;
	private Deposit siteDepositSpecialCash;
	private boolean renderedNormalVatType;
	private boolean renderedDeposiNormalVatType;
	private boolean renderedDepositSpecialVatType;
	private boolean renderedPnlDeptCash;
	private boolean renderedPnlDeptBg;
	private boolean disabledBtnAddDepositNormal;
	private boolean disabledBtnUpdateDepositNormal;
	
	private boolean disabledButtonPopupResult;
	private int count;
	private boolean chkWhtRateNormal;
	
	public boolean isDisabledChkNoDeposit() {
		return disabledChkNoDeposit;
	}

	public void setDisabledChkNoDeposit(boolean disabledChkNoDeposit) {
		this.disabledChkNoDeposit = disabledChkNoDeposit;
	}

	public Electric getTotalDeposit() {
		return totalDeposit;
	}

	public void setTotalDeposit(Electric totalDeposit) {
		this.totalDeposit = totalDeposit;
	}

	public boolean isDisabledTotalNormalDeposit() {
		return disabledTotalNormalDeposit;
	}

	public void setDisabledTotalNormalDeposit(boolean disabledTotalNormalDeposit) {
		this.disabledTotalNormalDeposit = disabledTotalNormalDeposit;
	}

	public boolean isDisabledChkNoUnitPriceFlag() {
		return disabledChkNoUnitPriceFlag;
	}

	public void setDisabledChkNoUnitPriceFlag(boolean disabledChkNoUnitPriceFlag) {
		this.disabledChkNoUnitPriceFlag = disabledChkNoUnitPriceFlag;
	}

	
	public boolean isRenderedNoDepositElectric2() {
		return renderedNoDepositElectric2;
	}

	public void setRenderedNoDepositElectric2(boolean renderedNoDepositElectric2) {
		this.renderedNoDepositElectric2 = renderedNoDepositElectric2;
	}

	public String getEditableDepositElectricFlag() {
		return editableDepositElectricFlag;
	}

	public void setEditableDepositElectricFlag(String editableDepositElectricFlag) {
		this.editableDepositElectricFlag = editableDepositElectricFlag;
	}

	public boolean isDisabledDepositElectric() {
		return disabledDepositElectric;
	}

	public void setDisabledDepositElectric(boolean disabledDepositElectric) {
		this.disabledDepositElectric = disabledDepositElectric;
	}

	public boolean isDisabledSiteContractNo() {
		return disabledSiteContractNo;
	}

	public void setDisabledSiteContractNo(boolean disabledSiteContractNo) {
		this.disabledSiteContractNo = disabledSiteContractNo;
	}

	public boolean isRenderedNoDepositElectric() {
		return renderedNoDepositElectric;
	}

	public void setRenderedNoDepositElectric(boolean renderedNoDepositElectric) {
		this.renderedNoDepositElectric = renderedNoDepositElectric;
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

	public boolean isChkNoDepositElectric() {
		return chkNoDepositElectric;
	}

	public void setChkNoDepositElectric(boolean chkNoDepositElectric) {
		this.chkNoDepositElectric = chkNoDepositElectric;
	}

	public boolean isRenderedVatType() {
		return renderedVatType;
	}

	public void setRenderedVatType(boolean renderedVatType) {
		this.renderedVatType = renderedVatType;
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

	public List<Msi004SrchDepositElectricSP> getElectricDepositSpecialSPList() {
		return electricDepositSpecialSPList;
	}

	public void setElectricDepositSpecialSPList(
			List<Msi004SrchDepositElectricSP> electricDepositSpecialSPList) {
		this.electricDepositSpecialSPList = electricDepositSpecialSPList;
	}


	public boolean isRenderedElectricOwnerType() {
		return renderedElectricOwnerType;
	}

	public void setRenderedElectricOwnerType(boolean renderedElectricOwnerType) {
		this.renderedElectricOwnerType = renderedElectricOwnerType;
	}

	public String getSiteInfoId() {
		return siteInfoId;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}

	public boolean isRenderVatType() {
		return renderVatType;
	}

	public void setRenderVatType(boolean renderVatType) {
		this.renderVatType = renderVatType;
	}

	public Msi004SrchSumDpstESP getSumDepositElectric() {
		return sumDepositElectric;
	}

	public void setSumDepositElectric(Msi004SrchSumDpstESP sumDepositElectric) {
		this.sumDepositElectric = sumDepositElectric;
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

	public boolean isDisabledBtnAddElectricDepositNormal() {
		return disabledBtnAddElectricDepositNormal;
	}

	public void setDisabledBtnAddElectricDepositNormal(
			boolean disabledBtnAddElectricDepositNormal) {
		this.disabledBtnAddElectricDepositNormal = disabledBtnAddElectricDepositNormal;
	}

	public boolean isDisabledBtnSaveElectricDepositNormal() {
		return disabledBtnSaveElectricDepositNormal;
	}

	public void setDisabledBtnSaveElectricDepositNormal(
			boolean disabledBtnSaveElectricDepositNormal) {
		this.disabledBtnSaveElectricDepositNormal = disabledBtnSaveElectricDepositNormal;
	}

	public List<Msi004SrchDepositElectricSP> getDepositElectricBgSPList() {
		return depositElectricBgSPList;
	}

	public void setDepositElectricBgSPList(
			List<Msi004SrchDepositElectricSP> depositElectricBgSPList) {
		this.depositElectricBgSPList = depositElectricBgSPList;
	}

	public List<Msi004SrchDepositElectricSP> getDepositElectricCashSPList() {
		return depositElectricCashSPList;
	}

	public void setDepositElectricCashSPList(
			List<Msi004SrchDepositElectricSP> depositElectricCashSPList) {
		this.depositElectricCashSPList = depositElectricCashSPList;
	}

	public boolean isRenderElectricDepositNormal() {
		return renderElectricDepositNormal;
	}

	public void setRenderElectricDepositNormal(boolean renderElectricDepositNormal) {
		this.renderElectricDepositNormal = renderElectricDepositNormal;
	}

	public boolean isRenderElectricDepositSpecial() {
		return renderElectricDepositSpecial;
	}

	public void setRenderElectricDepositSpecial(boolean renderElectricDepositSpecial) {
		this.renderElectricDepositSpecial = renderElectricDepositSpecial;
	}


	public Deposit getElectricDepositNormal() {
		return electricDepositNormal;
	}

	public void setElectricDepositNormal(Deposit electricDepositNormal) {
		this.electricDepositNormal = electricDepositNormal;
	}

	public Deposit getElectricDepositSpecialBg() {
		return electricDepositSpecialBg;
	}

	public void setElectricDepositSpecialBg(Deposit electricDepositSpecialBg) {
		this.electricDepositSpecialBg = electricDepositSpecialBg;
	}

	public Deposit getElectricDepositSpecialCash() {
		return electricDepositSpecialCash;
	}

	public void setElectricDepositSpecialCash(Deposit electricDepositSpecialCash) {
		this.electricDepositSpecialCash = electricDepositSpecialCash;
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

	public boolean isDisabledOldInsurance() {
		return disabledOldInsurance;
	}

	public void setDisabledOldInsurance(boolean disabledOldInsurance) {
		this.disabledOldInsurance = disabledOldInsurance;
	}

	public boolean isChNoUnit() {
		return chNoUnit;
	}

	public void setChNoUnit(boolean chNoUnit) {
		this.chNoUnit = chNoUnit;
	}

	public String getNoDepositElectric() {
		return noDepositElectric;
	}

	public void setNoDepositElectric(String noDepositElectric) {
		this.noDepositElectric = noDepositElectric;
	}

	public SiteInfoMapSiteAcqSP getSiteInfoObjParam() {
		return siteInfoObjParam;
	}

	public void setSiteInfoObjParam(SiteInfoMapSiteAcqSP siteInfoObjParam) {
		this.siteInfoObjParam = siteInfoObjParam;
	}

	public SiteInfoMapSiteAcqSP getSiteInfoObjELParam() {
		return siteInfoObjELParam;
	}

	public void setSiteInfoObjELParam(SiteInfoMapSiteAcqSP siteInfoObjELParam) {
		this.siteInfoObjELParam = siteInfoObjELParam;
	}


	public SiteInfoMapSiteAcqSP getSiteInfoDeptElObj() {
		return siteInfoDeptElObj;
	}

	public void setSiteInfoDeptElObj(SiteInfoMapSiteAcqSP siteInfoDeptElObj) {
		this.siteInfoDeptElObj = siteInfoDeptElObj;
	}

	public SiteInfoMapSiteAcqSP getSiteInfoDeptCashElObj() {
		return siteInfoDeptCashElObj;
	}

	public void setSiteInfoDeptCashElObj(SiteInfoMapSiteAcqSP siteInfoDeptCashElObj) {
		this.siteInfoDeptCashElObj = siteInfoDeptCashElObj;
	}

	public SiteInfoMapSiteAcqSP getSiteInfoDeptBgElObj() {
		return siteInfoDeptBgElObj;
	}

	public void setSiteInfoDeptBgElObj(SiteInfoMapSiteAcqSP siteInfoDeptBgElObj) {
		this.siteInfoDeptBgElObj = siteInfoDeptBgElObj;
	}

	public boolean isChkElUseOth() {
		return chkElUseOth;
	}

	public void setChkElUseOth(boolean chkElUseOth) {
		this.chkElUseOth = chkElUseOth;
	}

	public boolean isChkEditELDeposit() {
		return chkEditELDeposit;
	}

	public void setChkEditELDeposit(boolean chkEditELDeposit) {
		this.chkEditELDeposit = chkEditELDeposit;
	}

	public boolean isRenderedPnlDeptBgEl() {
		return renderedPnlDeptBgEl;
	}

	public void setRenderedPnlDeptBgEl(boolean renderedPnlDeptBgEl) {
		this.renderedPnlDeptBgEl = renderedPnlDeptBgEl;
	}

	public boolean isRenderedPnlDeptCashEl() {
		return renderedPnlDeptCashEl;
	}

	public void setRenderedPnlDeptCashEl(boolean renderedPnlDeptCashEl) {
		this.renderedPnlDeptCashEl = renderedPnlDeptCashEl;
	}

	public String getDeptReturnTypeEl01() {
		return DeptReturnTypeEl01;
	}

	public void setDeptReturnTypeEl01(String deptReturnTypeEl01) {
		DeptReturnTypeEl01 = deptReturnTypeEl01;
	}

	public String getDeptReturnTypeEl02() {
		return DeptReturnTypeEl02;
	}

	public void setDeptReturnTypeEl02(String deptReturnTypeEl02) {
		DeptReturnTypeEl02 = deptReturnTypeEl02;
	}

	public String getDeptReturnTypeEl03() {
		return DeptReturnTypeEl03;
	}

	public void setDeptReturnTypeEl03(String deptReturnTypeEl03) {
		DeptReturnTypeEl03 = deptReturnTypeEl03;
	}

	public SiteInfoMapSiteAcqSP getSiteInfoDeptCashObj() {
		return siteInfoDeptCashObj;
	}

	public void setSiteInfoDeptCashObj(SiteInfoMapSiteAcqSP siteInfoDeptCashObj) {
		this.siteInfoDeptCashObj = siteInfoDeptCashObj;
	}

	public SiteInfoMapSiteAcqSP getSiteInfoDeptBgObj() {
		return siteInfoDeptBgObj;
	}

	public void setSiteInfoDeptBgObj(SiteInfoMapSiteAcqSP siteInfoDeptBgObj) {
		this.siteInfoDeptBgObj = siteInfoDeptBgObj;
	}


	public List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> getSiteInfoDeptBGElList() {
		return siteInfoDeptBGElList;
	}

	public void setSiteInfoDeptBGElList(
			List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> siteInfoDeptBGElList) {
		this.siteInfoDeptBGElList = siteInfoDeptBGElList;
	}

	public List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> getSiteInfoDeptCashElList() {
		return siteInfoDeptCashElList;
	}

	public void setSiteInfoDeptCashElList(
			List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> siteInfoDeptCashElList) {
		this.siteInfoDeptCashElList = siteInfoDeptCashElList;
	}

	public boolean isWithdrawFlagEl() {
		return withdrawFlagEl;
	}

	public void setWithdrawFlagEl(boolean withdrawFlagEl) {
		this.withdrawFlagEl = withdrawFlagEl;
	}

	public boolean isRenderedMsgAlert() {
		return renderedMsgAlert;
	}

	public void setRenderedMsgAlert(boolean renderedMsgAlert) {
		this.renderedMsgAlert = renderedMsgAlert;
	}

	public boolean isRenderedPanelDisplay() {
		return renderedPanelDisplay;
	}

	public void setRenderedPanelDisplay(boolean renderedPanelDisplay) {
		this.renderedPanelDisplay = renderedPanelDisplay;
	}

	public boolean isChkElUseOwner() {
		return chkElUseOwner;
	}

	public void setChkElUseOwner(boolean chkElUseOwner) {
		this.chkElUseOwner = chkElUseOwner;
	}

	public boolean isElUnitPrice() {
		return elUnitPrice;
	}

	public void setElUnitPrice(boolean elUnitPrice) {
		this.elUnitPrice = elUnitPrice;
	}

	public boolean isChkElUseOthSite() {
		return chkElUseOthSite;
	}

	public void setChkElUseOthSite(boolean chkElUseOthSite) {
		this.chkElUseOthSite = chkElUseOthSite;
	}

	public boolean isChkNoUtilPrice() {
		return chkNoUtilPrice;
	}

	public void setChkNoUtilPrice(boolean chkNoUtilPrice) {
		this.chkNoUtilPrice = chkNoUtilPrice;
	}

	public String getElPayPeriodType01() {
		return elPayPeriodType01;
	}

	public void setElPayPeriodType01(String elPayPeriodType01) {
		this.elPayPeriodType01 = elPayPeriodType01;
	}

	public String getElPayPeriodType02() {
		return elPayPeriodType02;
	}

	public void setElPayPeriodType02(String elPayPeriodType02) {
		this.elPayPeriodType02 = elPayPeriodType02;
	}

	public String getElPayPeriodType03() {
		return elPayPeriodType03;
	}

	public void setElPayPeriodType03(String elPayPeriodType03) {
		this.elPayPeriodType03 = elPayPeriodType03;
	}

	public String getElPayPeriodType04() {
		return elPayPeriodType04;
	}

	public void setElPayPeriodType04(String elPayPeriodType04) {
		this.elPayPeriodType04 = elPayPeriodType04;
	}

	public String getElPayPeriodType05() {
		return elPayPeriodType05;
	}

	public void setElPayPeriodType05(String elPayPeriodType05) {
		this.elPayPeriodType05 = elPayPeriodType05;
	}

	public String getElPayPeriodType06() {
		return elPayPeriodType06;
	}

	public void setElPayPeriodType06(String elPayPeriodType06) {
		this.elPayPeriodType06 = elPayPeriodType06;
	}

	public String getElPayPeriodType07() {
		return elPayPeriodType07;
	}

	public void setElPayPeriodType07(String elPayPeriodType07) {
		this.elPayPeriodType07 = elPayPeriodType07;
	}

	public Integer getElPayPeriod03() {
		return elPayPeriod03;
	}

	public void setElPayPeriod03(Integer elPayPeriod03) {
		this.elPayPeriod03 = elPayPeriod03;
	}

	public Integer getElPayPeriod04() {
		return elPayPeriod04;
	}

	public void setElPayPeriod04(Integer elPayPeriod04) {
		this.elPayPeriod04 = elPayPeriod04;
	}

	public boolean isDisabledElPayPeriod03() {
		return disabledElPayPeriod03;
	}

	public void setDisabledElPayPeriod03(boolean disabledElPayPeriod03) {
		this.disabledElPayPeriod03 = disabledElPayPeriod03;
	}

	public boolean isDisabledElPayPeriod04() {
		return disabledElPayPeriod04;
	}

	public void setDisabledElPayPeriod04(boolean disabledElPayPeriod04) {
		this.disabledElPayPeriod04 = disabledElPayPeriod04;
	}

	public boolean isChkElUseNewMeter() {
		return chkElUseNewMeter;
	}

	public void setChkElUseNewMeter(boolean chkElUseNewMeter) {
		this.chkElUseNewMeter = chkElUseNewMeter;
	}

	public boolean isChkElUseOldMeter() {
		return chkElUseOldMeter;
	}

	public void setChkElUseOldMeter(boolean chkElUseOldMeter) {
		this.chkElUseOldMeter = chkElUseOldMeter;
	}

	public boolean isChkElPayOnPackage() {
		return chkElPayOnPackage;
	}

	public void setChkElPayOnPackage(boolean chkElPayOnPackage) {
		this.chkElPayOnPackage = chkElPayOnPackage;
	}

	public boolean isChkElOwnerType() {
		return chkElOwnerType;
	}

	public void setChkElOwnerType(boolean chkElOwnerType) {
		this.chkElOwnerType = chkElOwnerType;
	}

	public boolean isChkElDepositFlag() {
		return chkElDepositFlag;
	}

	public void setChkElDepositFlag(boolean chkElDepositFlag) {
		this.chkElDepositFlag = chkElDepositFlag;
	}

	public List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> getSiteInfoELCondExistingList() {
		return siteInfoELCondExistingList;
	}

	public void setSiteInfoELCondExistingList(
			List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> siteInfoELCondExistingList) {
		this.siteInfoELCondExistingList = siteInfoELCondExistingList;
	}

	public List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> getSiteInfoELCondTakeAllList() {
		return siteInfoELCondTakeAllList;
	}

	public void setSiteInfoELCondTakeAllList(
			List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> siteInfoELCondTakeAllList) {
		this.siteInfoELCondTakeAllList = siteInfoELCondTakeAllList;
	}

	public List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> getSiteInfoELCondUnitList() {
		return siteInfoELCondUnitList;
	}

	public void setSiteInfoELCondUnitList(
			List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> siteInfoELCondUnitList) {
		this.siteInfoELCondUnitList = siteInfoELCondUnitList;
	}

	public List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> getSiteInfoELCondOtherList() {
		return siteInfoELCondOtherList;
	}

	public void setSiteInfoELCondOtherList(
			List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> siteInfoELCondOtherList) {
		this.siteInfoELCondOtherList = siteInfoELCondOtherList;
	}

	public boolean isRenderedTbElUnit() {
		return renderedTbElUnit;
	}

	public void setRenderedTbElUnit(boolean renderedTbElUnit) {
		this.renderedTbElUnit = renderedTbElUnit;
	}

	public boolean isRenderedTbElTakeAll() {
		return renderedTbElTakeAll;
	}

	public void setRenderedTbElTakeAll(boolean renderedTbElTakeAll) {
		this.renderedTbElTakeAll = renderedTbElTakeAll;
	}

	public List<SelectItem> getServTypeList() {
		return servTypeList;
	}

	public void setServTypeList(List<SelectItem> servTypeList) {
		this.servTypeList = servTypeList;
	}

	public List<SelectItem> getExpenseTypeDepositElList() {
		return expenseTypeDepositElList;
	}

	public void setExpenseTypeDepositElList(
			List<SelectItem> expenseTypeDepositElList) {
		this.expenseTypeDepositElList = expenseTypeDepositElList;
	}

	public List<SelectItem> getElCondTypeList() {
		return elCondTypeList;
	}

	public void setElCondTypeList(List<SelectItem> elCondTypeList) {
		this.elCondTypeList = elCondTypeList;
	}

	public List<SelectItem> getElCondSubTypeList() {
		return elCondSubTypeList;
	}

	public void setElCondSubTypeList(List<SelectItem> elCondSubTypeList) {
		this.elCondSubTypeList = elCondSubTypeList;
	}

	public List<SelectItem> getPromiseRenewPeriodTypeList() {
		return promiseRenewPeriodTypeList;
	}

	public void setPromiseRenewPeriodTypeList(
			List<SelectItem> promiseRenewPeriodTypeList) {
		this.promiseRenewPeriodTypeList = promiseRenewPeriodTypeList;
	}

	public boolean isDisabledElUserOthSite() {
		return disabledElUserOthSite;
	}

	public void setDisabledElUserOthSite(boolean disabledElUserOthSite) {
		this.disabledElUserOthSite = disabledElUserOthSite;
	}

	public SiteInfoMapSiteAcqSP getContractElUseObjParam() {
		return contractElUseObjParam;
	}

	public void setContractElUseObjParam(SiteInfoMapSiteAcqSP contractElUseObjParam) {
		this.contractElUseObjParam = contractElUseObjParam;
	}

	public List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> getContractElUseList() {
		return contractElUseList;
	}

	public void setContractElUseList(
			List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> contractElUseList) {
		this.contractElUseList = contractElUseList;
	}

	public List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> getSiteAppELCondExistingList() {
		return siteAppELCondExistingList;
	}

	public void setSiteAppELCondExistingList(
			List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> siteAppELCondExistingList) {
		this.siteAppELCondExistingList = siteAppELCondExistingList;
	}

	public List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> getSiteAppELCondTakeAllList() {
		return siteAppELCondTakeAllList;
	}

	public void setSiteAppELCondTakeAllList(
			List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> siteAppELCondTakeAllList) {
		this.siteAppELCondTakeAllList = siteAppELCondTakeAllList;
	}

	public List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> getSiteAppELCondUnitList() {
		return siteAppELCondUnitList;
	}

	public void setSiteAppELCondUnitList(
			List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> siteAppELCondUnitList) {
		this.siteAppELCondUnitList = siteAppELCondUnitList;
	}

	public List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> getSiteAppELCondOtherList() {
		return siteAppELCondOtherList;
	}

	public void setSiteAppELCondOtherList(
			List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> siteAppELCondOtherList) {
		this.siteAppELCondOtherList = siteAppELCondOtherList;
	}

	public boolean isRenderedTbElUseOth() {
		return renderedTbElUseOth;
	}

	public void setRenderedTbElUseOth(boolean renderedTbElUseOth) {
		this.renderedTbElUseOth = renderedTbElUseOth;
	}

	public boolean isChkElectricType5() {
		return chkElectricType5;
	}

	public void setChkElectricType5(boolean chkElectricType5) {
		this.chkElectricType5 = chkElectricType5;
	}

	public boolean isChkElectricType6() {
		return chkElectricType6;
	}

	public void setChkElectricType6(boolean chkElectricType6) {
		this.chkElectricType6 = chkElectricType6;
	}

	public String getElectricOthDetail() {
		return electricOthDetail;
	}

	public void setElectricOthDetail(String electricOthDetail) {
		this.electricOthDetail = electricOthDetail;
	}

	public List<SelectItem> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}

	public List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> getSiteInfoELCondNoExpenseList() {
		return siteInfoELCondNoExpenseList;
	}

	public void setSiteInfoELCondNoExpenseList(
			List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> siteInfoELCondNoExpenseList) {
		this.siteInfoELCondNoExpenseList = siteInfoELCondNoExpenseList;
	}

	public boolean isRenderedTbElNoExpense() {
		return renderedTbElNoExpense;
	}

	public void setRenderedTbElNoExpense(boolean renderedTbElNoExpense) {
		this.renderedTbElNoExpense = renderedTbElNoExpense;
	}

	public List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> getSiteAppELCondNoExpenseList() {
		return siteAppELCondNoExpenseList;
	}

	public void setSiteAppELCondNoExpenseList(
			List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> siteAppELCondNoExpenseList) {
		this.siteAppELCondNoExpenseList = siteAppELCondNoExpenseList;
	}

	public List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> getSiteInfoELCondAllList() {
		return siteInfoELCondAllList;
	}

	public void setSiteInfoELCondAllList(
			List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> siteInfoELCondAllList) {
		this.siteInfoELCondAllList = siteInfoELCondAllList;
	}

	public String getpRemark() {
		return pRemark;
	}

	public void setpRemark(String pRemark) {
		this.pRemark = pRemark;
	}

	public boolean isDisabledModeViewOnly() {
		return disabledModeViewOnly;
	}

	public void setDisabledModeViewOnly(boolean disabledModeViewOnly) {
		this.disabledModeViewOnly = disabledModeViewOnly;
	}

	public String getMsgReqcompanyPopup() {
		return msgReqcompanyPopup;
	}

	public void setMsgReqcompanyPopup(String msgReqcompanyPopup) {
		this.msgReqcompanyPopup = msgReqcompanyPopup;
	}

	public boolean isNoExpFlag() {
		return noExpFlag;
	}

	public void setNoExpFlag(boolean noExpFlag) {
		this.noExpFlag = noExpFlag;
	}

	public SiteInfoMapSiteAcqSP getSiteContInfo() {
		return siteContInfo;
	}

	public void setSiteContInfo(SiteInfoMapSiteAcqSP siteContInfo) {
		this.siteContInfo = siteContInfo;
	}

	public ItemResultSP getRetResultObj() {
		return retResultObj;
	}

	public void setRetResultObj(ItemResultSP retResultObj) {
		this.retResultObj = retResultObj;
	}

	public boolean isRenderedMsgPopup() {
		return renderedMsgPopup;
	}

	public void setRenderedMsgPopup(boolean renderedMsgPopup) {
		this.renderedMsgPopup = renderedMsgPopup;
	}

	public SiteInfoMapSiteAcqSP getSiteInfoDeptObj() {
		return siteInfoDeptObj;
	}

	public void setSiteInfoDeptObj(SiteInfoMapSiteAcqSP siteInfoDeptObj) {
		this.siteInfoDeptObj = siteInfoDeptObj;
	}

	public List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> getSiteInfoDeptBGList() {
		return siteInfoDeptBGList;
	}

	public void setSiteInfoDeptBGList(
			List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> siteInfoDeptBGList) {
		this.siteInfoDeptBGList = siteInfoDeptBGList;
	}

	public List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> getSiteInfoDeptCashList() {
		return siteInfoDeptCashList;
	}

	public void setSiteInfoDeptCashList(
			List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> siteInfoDeptCashList) {
		this.siteInfoDeptCashList = siteInfoDeptCashList;
	}

	public boolean isChkElEditFlag() {
		return chkElEditFlag;
	}

	public void setChkElEditFlag(boolean chkElEditFlag) {
		this.chkElEditFlag = chkElEditFlag;
	}

	public String getElEditFlag() {
		return elEditFlag;
	}

	public void setElEditFlag(String elEditFlag) {
		this.elEditFlag = elEditFlag;
	}

	public String getElDepositEditFlag() {
		return elDepositEditFlag;
	}

	public void setElDepositEditFlag(String elDepositEditFlag) {
		this.elDepositEditFlag = elDepositEditFlag;
	}

	public boolean isChkElDepositEditFlag() {
		return chkElDepositEditFlag;
	}

	public void setChkElDepositEditFlag(boolean chkElDepositEditFlag) {
		this.chkElDepositEditFlag = chkElDepositEditFlag;
	}

	public Deposit getSiteDepositNormal() {
		return siteDepositNormal;
	}

	public void setSiteDepositNormal(Deposit siteDepositNormal) {
		this.siteDepositNormal = siteDepositNormal;
	}

	public Deposit getSiteDepositSpecialBg() {
		return siteDepositSpecialBg;
	}

	public void setSiteDepositSpecialBg(Deposit siteDepositSpecialBg) {
		this.siteDepositSpecialBg = siteDepositSpecialBg;
	}

	public Deposit getSiteDepositSpecialCash() {
		return siteDepositSpecialCash;
	}

	public void setSiteDepositSpecialCash(Deposit siteDepositSpecialCash) {
		this.siteDepositSpecialCash = siteDepositSpecialCash;
	}

	public boolean isRenderedNormalVatType() {
		return renderedNormalVatType;
	}

	public void setRenderedNormalVatType(boolean renderedNormalVatType) {
		this.renderedNormalVatType = renderedNormalVatType;
	}

	public boolean isRenderedDeposiNormalVatType() {
		return renderedDeposiNormalVatType;
	}

	public void setRenderedDeposiNormalVatType(boolean renderedDeposiNormalVatType) {
		this.renderedDeposiNormalVatType = renderedDeposiNormalVatType;
	}

	public boolean isRenderedDepositSpecialVatType() {
		return renderedDepositSpecialVatType;
	}

	public void setRenderedDepositSpecialVatType(
			boolean renderedDepositSpecialVatType) {
		this.renderedDepositSpecialVatType = renderedDepositSpecialVatType;
	}

	public boolean isRenderedPnlDeptCash() {
		return renderedPnlDeptCash;
	}

	public void setRenderedPnlDeptCash(boolean renderedPnlDeptCash) {
		this.renderedPnlDeptCash = renderedPnlDeptCash;
	}

	public boolean isRenderedPnlDeptBg() {
		return renderedPnlDeptBg;
	}

	public void setRenderedPnlDeptBg(boolean renderedPnlDeptBg) {
		this.renderedPnlDeptBg = renderedPnlDeptBg;
	}

	public boolean isDisabledBtnAddDepositNormal() {
		return disabledBtnAddDepositNormal;
	}

	public void setDisabledBtnAddDepositNormal(boolean disabledBtnAddDepositNormal) {
		this.disabledBtnAddDepositNormal = disabledBtnAddDepositNormal;
	}

	public boolean isDisabledBtnUpdateDepositNormal() {
		return disabledBtnUpdateDepositNormal;
	}

	public void setDisabledBtnUpdateDepositNormal(
			boolean disabledBtnUpdateDepositNormal) {
		this.disabledBtnUpdateDepositNormal = disabledBtnUpdateDepositNormal;
	}

	public boolean isDisabledButtonPopupResult() {
		return disabledButtonPopupResult;
	}

	public void setDisabledButtonPopupResult(boolean disabledButtonPopupResult) {
		this.disabledButtonPopupResult = disabledButtonPopupResult;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isChkWhtRateNormal() {
		return chkWhtRateNormal;
	}

	public void setChkWhtRateNormal(boolean chkWhtRateNormal) {
		this.chkWhtRateNormal = chkWhtRateNormal;
	}


	
}
