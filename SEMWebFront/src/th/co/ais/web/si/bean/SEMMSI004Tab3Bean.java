package th.co.ais.web.si.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.sa.SiteAppSP;
import th.co.ais.domain.si.Deposit;
import th.co.ais.domain.si.Msi004SrchDepositRentSP;
import th.co.ais.domain.si.Msi004SrchRentCondSP;
import th.co.ais.domain.si.Rent;
import th.co.ais.domain.si.RentCond;
import th.co.ais.domain.si.SiteInfoMapSiteAcqSP;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMMSI004Tab3Bean extends AbstractBean {
	
	private static final long serialVersionUID = 1L;
	
	private String conditionType;
	private boolean renderConditionNormal;
	private boolean renderConditionSpecial;
	private Rent siteRent;
	private RentCond rentCondNormal;
	private RentCond rentCondSpecial1;
	private RentCond rentCondSpecial2;
	private RentCond rentCondSpecial3;
	private RentCond rentCondSpecial4;
	private Deposit siteDepositNormal;
	private Deposit siteDepositSpecialBg;
	private Deposit siteDepositSpecialCash;
	private List<Msi004SrchRentCondSP> rentCondSPList;
	private List<Msi004SrchDepositRentSP> depositRentBgSPList;
	private List<Msi004SrchDepositRentSP> depositRentCashSPList;
	private List<Msi004SrchDepositRentSP> depositRentSpecialSPList;
	private List<SelectItem> expenseTypeRentList;
	private List<SelectItem> expenseTypeDepositRentList;
	private boolean renderDepositRentNormal;
	private boolean renderDepositRentSpecial;
	private boolean disabledWhtRateNormal;
	private boolean disabledWhtRateRentSpecial;
	private boolean disabledWhtRateRentSetupSpecial;
	private boolean disabledWhtRateServiceSpecial;
	private boolean disabledWhtRateServiceOtherSpecial;
	private boolean chkWhtRateNormal;
	private boolean chkWhtRateRentSpecial;
	private boolean chkWhtRateRentSetupSpecial;
	private boolean chkWhtRateServiceSpecial;
	private boolean chkWhtRateServiceOtherSpecial;
	private boolean disabledBtnAddRentCond;
	private boolean disabledBtnUpdateRentCond;
	private boolean disabledBtnAddDepositNormal;
	private boolean disabledBtnUpdateDepositNormal;
	private boolean renderDataTableRentCond;
	private boolean renderDataTableDeposit;
	private Integer payPeriod03;
	private Integer payPeriod04;
	private String payPeriodType01;
	private String payPeriodType02;
	private String payPeriodType03;
	private String payPeriodType04;
	private String payPeriodType05;
	private String payPeriodType06;
	private String payPeriodType07;
	private String siteInfoId;
	private boolean renderedNormalVatType;
	private boolean renderedDeposiNormalVatType;
	private boolean renderedDepositSpecialVatType;
	private String columnVatRate;
	private boolean renderedRentOldAmt;
	private boolean disabledPeriodType;
	private boolean renderedMsgSumDeposit;
	private boolean disabledChkWhtRateNormal;
	private boolean disabledChkWhtRateSpecial1;
	private boolean disabledChkWhtRateSpecial2;
	private boolean disabledChkWhtRateSpecial3;
	private boolean disabledChkWhtRateSpecial4;
	private boolean renderedEffDate;
	private boolean chkNoRentDeposit;
	private boolean chkNoRent;
	private boolean renderedNoRent;
	private boolean renderedNoRentDeposit;
	private boolean disabledPayPeriod03;
	private boolean disabledPayPeriod04;
	private boolean disabledRent;
	private boolean disabledRentSetup;
	private String editableRentFlag;
	private boolean disabledDepositRent;
	private String editableDepositRentFlag;
	private boolean disabledTotalNormalRent;
	private boolean disabledTotalNormalDeposit;
	private boolean disabledTotalDepositBG;
	private boolean disabledTotalDepositCash;
	private Rent totalDeposit;
	private Rent totalRent;
	private boolean chkOverFlag;
	private boolean disabledRentOldAmt;
	private boolean disabledWhtRateSupportSpecial;
	private boolean chkWhtRateSupportSpecial;
	private boolean DisabledChkWhtRateSpecial3;
	private boolean disabledChkNoRent;
	private boolean disabledChkNoDeposit;
	
	private boolean disabledOldInsurance = false;
	private boolean fix5Percent;
	private boolean renderAlertMessage = true;
	
	private boolean chkNoRentalPayment;
	private boolean chkRentalEditFlag;
	private String rentEditFlag = "N";
	
	private boolean chkRentalDepositEditFlag;
	private String rentDepositEditFlag = "N";
	
	private boolean renderedRantalDepositCash;
	private boolean renderedRantalDepositBg;
	private List<SelectItem> servTypeList;
	private boolean chkRentAdj;
	private boolean chkServId;
	private List<SelectItem> rentAdjList;
	private List<SelectItem> promiseRenewPeriodTypeList;
	
	private SiteAppSP siteAppDeptObj;
	private SiteAppSP siteAppDeptCashObj;
	private SiteAppSP siteAppDeptBgObj;
	
	private List<WrapperBeanObject<SiteAppSP>> siteAppDeptBGList;
	private List<WrapperBeanObject<SiteAppSP>> siteAppDeptCashList;
	
	private boolean deptReceiveBg;
	private boolean deptNoBg;
	private boolean deptCancelBg;
	
	private boolean renderedPnlDeptCash;
	private boolean renderedPnlDeptBg;
	
	private String deptReturnType01;
	private String deptReturnType02;
	private String deptReturnType03;
	
	private boolean withdrawFlag;
	
	private boolean chkContRentAdj;
	
	
	private SiteInfoMapSiteAcqSP siteInfoObjParam;
	
	
	private List<Msi004SrchRentCondSP> rentCondExtSPList;
	private List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> siteAppRentServList;
	
	private List<SelectItem> fix5PercentList;
	
	//add by Maa 2023/03/14
	private boolean disabledExpenseDesc = true;	
	
	
	public boolean isDisabledChkNoRent() {
		return disabledChkNoRent;
	}

	public void setDisabledChkNoRent(boolean disabledChkNoRent) {
		this.disabledChkNoRent = disabledChkNoRent;
	}

	public boolean isDisabledChkNoDeposit() {
		return disabledChkNoDeposit;
	}

	public void setDisabledChkNoDeposit(boolean disabledChkNoDeposit) {
		this.disabledChkNoDeposit = disabledChkNoDeposit;
	}

	public boolean isDisabledChkWhtRateSpecial3() {
		return DisabledChkWhtRateSpecial3;
	}

	public void setDisabledChkWhtRateSpecial3(boolean disabledChkWhtRateSpecial3) {
		DisabledChkWhtRateSpecial3 = disabledChkWhtRateSpecial3;
	}

	public boolean isChkWhtRateSupportSpecial() {
		return chkWhtRateSupportSpecial;
	}

	public void setChkWhtRateSupportSpecial(boolean chkWhtRateSupportSpecial) {
		this.chkWhtRateSupportSpecial = chkWhtRateSupportSpecial;
	}

	public boolean isDisabledWhtRateSupportSpecial() {
		return disabledWhtRateSupportSpecial;
	}

	public void setDisabledWhtRateSupportSpecial(
			boolean disabledWhtRateSupportSpecial) {
		this.disabledWhtRateSupportSpecial = disabledWhtRateSupportSpecial;
	}

	public RentCond getRentCondSpecial3() {
		return rentCondSpecial3;
	}

	public void setRentCondSpecial3(RentCond rentCondSpecial3) {
		this.rentCondSpecial3 = rentCondSpecial3;
	}

	public boolean isDisabledRentOldAmt() {
		return disabledRentOldAmt;
	}

	public void setDisabledRentOldAmt(boolean disabledRentOldAmt) {
		this.disabledRentOldAmt = disabledRentOldAmt;
	}

	public boolean isChkOverFlag() {
		return chkOverFlag;
	}

	public void setChkOverFlag(boolean chkOverFlag) {
		this.chkOverFlag = chkOverFlag;
	}

	

	
	public boolean isDisabledChkWhtRateSpecial1() {
		return disabledChkWhtRateSpecial1;
	}

	public void setDisabledChkWhtRateSpecial1(boolean disabledChkWhtRateSpecial1) {
		this.disabledChkWhtRateSpecial1 = disabledChkWhtRateSpecial1;
	}

	public boolean isDisabledChkWhtRateSpecial2() {
		return disabledChkWhtRateSpecial2;
	}

	public void setDisabledChkWhtRateSpecial2(boolean disabledChkWhtRateSpecial2) {
		this.disabledChkWhtRateSpecial2 = disabledChkWhtRateSpecial2;
	}

	public Rent getTotalRent() {
		return totalRent;
	}

	public void setTotalRent(Rent totalRent) {
		this.totalRent = totalRent;
	}

	public Rent getTotalDeposit() {
		return totalDeposit;
	}

	public void setTotalDeposit(Rent totalDeposit) {
		this.totalDeposit = totalDeposit;
	}

	public boolean isDisabledTotalNormalRent() {
		return disabledTotalNormalRent;
	}

	public void setDisabledTotalNormalRent(boolean disabledTotalNormalRent) {
		this.disabledTotalNormalRent = disabledTotalNormalRent;
	}

	public boolean isDisabledTotalNormalDeposit() {
		return disabledTotalNormalDeposit;
	}

	public void setDisabledTotalNormalDeposit(boolean disabledTotalNormalDeposit) {
		this.disabledTotalNormalDeposit = disabledTotalNormalDeposit;
	}

	public boolean isDisabledDepositRent() {
		return disabledDepositRent;
	}

	public void setDisabledDepositRent(boolean disabledDepositRent) {
		this.disabledDepositRent = disabledDepositRent;
	}

	public String getEditableDepositRentFlag() {
		return editableDepositRentFlag;
	}

	public void setEditableDepositRentFlag(String editableDepositRentFlag) {
		this.editableDepositRentFlag = editableDepositRentFlag;
	}

	public String getEditableRentFlag() {
		return editableRentFlag;
	}

	public void setEditableRentFlag(String editableRentFlag) {
		this.editableRentFlag = editableRentFlag;
	}

	public boolean isDisabledRent() {
		return disabledRent;
	}

	public void setDisabledRent(boolean disabledRent) {
		this.disabledRent = disabledRent;
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

	public boolean isRenderedNoRentDeposit() {
		return renderedNoRentDeposit;
	}

	public void setRenderedNoRentDeposit(boolean renderedNoRentDeposit) {
		this.renderedNoRentDeposit = renderedNoRentDeposit;
	}

	public boolean isRenderedNoRent() {
		return renderedNoRent;
	}

	public void setRenderedNoRent(boolean renderedNoRent) {
		this.renderedNoRent = renderedNoRent;
	}

	public boolean isChkNoRent() {
		return chkNoRent;
	}

	public void setChkNoRent(boolean chkNoRent) {
		this.chkNoRent = chkNoRent;
	}

	
	public boolean isChkNoRentDeposit() {
		return chkNoRentDeposit;
	}

	public void setChkNoRentDeposit(boolean chkNoRentDeposit) {
		this.chkNoRentDeposit = chkNoRentDeposit;
	}

	public boolean isRenderedEffDate() {
		return renderedEffDate;
	}

	public void setRenderedEffDate(boolean renderedEffDate) {
		this.renderedEffDate = renderedEffDate;
	}

	public boolean isDisabledChkWhtRateNormal() {
		return disabledChkWhtRateNormal;
	}

	public void setDisabledChkWhtRateNormal(boolean disabledChkWhtRateNormal) {
		this.disabledChkWhtRateNormal = disabledChkWhtRateNormal;
	}

	public boolean isRenderedMsgSumDeposit() {
		return renderedMsgSumDeposit;
	}

	public void setRenderedMsgSumDeposit(boolean renderedMsgSumDeposit) {
		this.renderedMsgSumDeposit = renderedMsgSumDeposit;
	}

	public boolean isDisabledPeriodType() {
		return disabledPeriodType;
	}

	public void setDisabledPeriodType(boolean disabledPeriodType) {
		this.disabledPeriodType = disabledPeriodType;
	}

	public boolean isRenderedRentOldAmt() {
		return renderedRentOldAmt;
	}

	public void setRenderedRentOldAmt(boolean renderedRentOldAmt) {
		this.renderedRentOldAmt = renderedRentOldAmt;
	}

	public boolean isRenderedDepositSpecialVatType() {
		return renderedDepositSpecialVatType;
	}

	public void setRenderedDepositSpecialVatType(
			boolean renderedDepositSpecialVatType) {
		this.renderedDepositSpecialVatType = renderedDepositSpecialVatType;
	}

	public String getColumnVatRate() {
		return columnVatRate;
	}

	public void setColumnVatRate(String columnVatRate) {
		this.columnVatRate = columnVatRate;
	}

	public boolean isRenderedDeposiNormalVatType() {
		return renderedDeposiNormalVatType;
	}

	public void setRenderedDeposiNormalVatType(boolean renderedDeposiNormalVatType) {
		this.renderedDeposiNormalVatType = renderedDeposiNormalVatType;
	}

	public boolean isRenderedNormalVatType() {
		return renderedNormalVatType;
	}

	public void setRenderedNormalVatType(boolean renderedNormalVatType) {
		this.renderedNormalVatType = renderedNormalVatType;
	}

	public String getSiteInfoId() {
		return siteInfoId;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
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

	public boolean isRenderDataTableDeposit() {
		return renderDataTableDeposit;
	}

	public void setRenderDataTableDeposit(boolean renderDataTableDeposit) {
		this.renderDataTableDeposit = renderDataTableDeposit;
	}

	public boolean isRenderDataTableRentCond() {
		return renderDataTableRentCond;
	}

	public void setRenderDataTableRentCond(boolean renderDataTableRentCond) {
		this.renderDataTableRentCond = renderDataTableRentCond;
	}

	public List<Msi004SrchDepositRentSP> getDepositRentSpecialSPList() {
		return depositRentSpecialSPList;
	}

	public void setDepositRentSpecialSPList(
			List<Msi004SrchDepositRentSP> depositRentSpecialSPList) {
		this.depositRentSpecialSPList = depositRentSpecialSPList;
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

	public boolean isDisabledBtnAddRentCond() {
		return disabledBtnAddRentCond;
	}

	public void setDisabledBtnAddRentCond(boolean disabledBtnAddRentCond) {
		this.disabledBtnAddRentCond = disabledBtnAddRentCond;
	}

	public boolean isDisabledBtnUpdateRentCond() {
		return disabledBtnUpdateRentCond;
	}

	public void setDisabledBtnUpdateRentCond(boolean disabledBtnUpdateRentCond) {
		this.disabledBtnUpdateRentCond = disabledBtnUpdateRentCond;
	}

	public boolean isDisabledWhtRateNormal() {
		return disabledWhtRateNormal;
	}

	public void setDisabledWhtRateNormal(boolean disabledWhtRateNormal) {
		this.disabledWhtRateNormal = disabledWhtRateNormal;
	}

	public boolean isDisabledWhtRateRentSpecial() {
		return disabledWhtRateRentSpecial;
	}

	public void setDisabledWhtRateRentSpecial(boolean disabledWhtRateRentSpecial) {
		this.disabledWhtRateRentSpecial = disabledWhtRateRentSpecial;
	}

	public boolean isDisabledWhtRateServiceSpecial() {
		return disabledWhtRateServiceSpecial;
	}

	public void setDisabledWhtRateServiceSpecial(
			boolean disabledWhtRateServiceSpecial) {
		this.disabledWhtRateServiceSpecial = disabledWhtRateServiceSpecial;
	}

	public boolean isChkWhtRateNormal() {
		return chkWhtRateNormal;
	}

	public void setChkWhtRateNormal(boolean chkWhtRateNormal) {
		this.chkWhtRateNormal = chkWhtRateNormal;
	}

	public boolean isChkWhtRateRentSpecial() {
		return chkWhtRateRentSpecial;
	}

	public void setChkWhtRateRentSpecial(boolean chkWhtRateRentSpecial) {
		this.chkWhtRateRentSpecial = chkWhtRateRentSpecial;
	}

	public boolean isChkWhtRateServiceSpecial() {
		return chkWhtRateServiceSpecial;
	}

	public void setChkWhtRateServiceSpecial(boolean chkWhtRateServiceSpecial) {
		this.chkWhtRateServiceSpecial = chkWhtRateServiceSpecial;
	}

	public boolean isRenderDepositRentNormal() {
		return renderDepositRentNormal;
	}

	public void setRenderDepositRentNormal(boolean renderDepositRentNormal) {
		this.renderDepositRentNormal = renderDepositRentNormal;
	}

	public boolean isRenderDepositRentSpecial() {
		return renderDepositRentSpecial;
	}

	public void setRenderDepositRentSpecial(boolean renderDepositRentSpecial) {
		this.renderDepositRentSpecial = renderDepositRentSpecial;
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

	public List<SelectItem> getExpenseTypeDepositRentList() {
		return expenseTypeDepositRentList;
	}

	public void setExpenseTypeDepositRentList(
			List<SelectItem> expenseTypeDepositRentList) {
		this.expenseTypeDepositRentList = expenseTypeDepositRentList;
	}

	public List<SelectItem> getExpenseTypeRentList() {
		return expenseTypeRentList;
	}

	public void setExpenseTypeRentList(List<SelectItem> expenseTypeRentList) {
		this.expenseTypeRentList = expenseTypeRentList;
	}

	public List<Msi004SrchDepositRentSP> getDepositRentBgSPList() {
		return depositRentBgSPList;
	}

	public void setDepositRentBgSPList(
			List<Msi004SrchDepositRentSP> depositRentBgSPList) {
		this.depositRentBgSPList = depositRentBgSPList;
	}

	public List<Msi004SrchDepositRentSP> getDepositRentCashSPList() {
		return depositRentCashSPList;
	}

	public void setDepositRentCashSPList(
			List<Msi004SrchDepositRentSP> depositRentCashSPList) {
		this.depositRentCashSPList = depositRentCashSPList;
	}

	public List<Msi004SrchRentCondSP> getRentCondSPList() {
		return rentCondSPList;
	}

	public void setRentCondSPList(List<Msi004SrchRentCondSP> rentCondSPList) {
		this.rentCondSPList = rentCondSPList;
	}

	public Rent getSiteRent() {
		return siteRent;
	}

	public void setSiteRent(Rent siteRent) {
		this.siteRent = siteRent;
	}

	public RentCond getRentCondNormal() {
		return rentCondNormal;
	}

	public void setRentCondNormal(RentCond rentCondNormal) {
		this.rentCondNormal = rentCondNormal;
	}

	public RentCond getRentCondSpecial1() {
		return rentCondSpecial1;
	}

	public void setRentCondSpecial1(RentCond rentCondSpecial1) {
		this.rentCondSpecial1 = rentCondSpecial1;
	}

	public RentCond getRentCondSpecial2() {
		return rentCondSpecial2;
	}

	public void setRentCondSpecial2(RentCond rentCondSpecial2) {
		this.rentCondSpecial2 = rentCondSpecial2;
	}


	public boolean isRenderConditionNormal() {
		return renderConditionNormal;
	}

	public void setRenderConditionNormal(boolean renderConditionNormal) {
		this.renderConditionNormal = renderConditionNormal;
	}


	public boolean isRenderConditionSpecial() {
		return renderConditionSpecial;
	}

	public void setRenderConditionSpecial(boolean renderConditionSpecial) {
		this.renderConditionSpecial = renderConditionSpecial;
	}

	public String getConditionType() {
		return conditionType;
	}

	public void setConditionType(String conditionType) {
		this.conditionType = conditionType;
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

	public boolean isDisabledTotalDepositBG() {
		return disabledTotalDepositBG;
	}

	public void setDisabledTotalDepositBG(boolean disabledTotalDepositBG) {
		this.disabledTotalDepositBG = disabledTotalDepositBG;
	}

	public boolean isDisabledTotalDepositCash() {
		return disabledTotalDepositCash;
	}

	public void setDisabledTotalDepositCash(boolean disabledTotalDepositCash) {
		this.disabledTotalDepositCash = disabledTotalDepositCash;
	}

	public RentCond getRentCondSpecial4() {
		return rentCondSpecial4;
	}

	public void setRentCondSpecial4(RentCond rentCondSpecial4) {
		this.rentCondSpecial4 = rentCondSpecial4;
	}

	public boolean isChkWhtRateRentSetupSpecial() {
		return chkWhtRateRentSetupSpecial;
	}

	public void setChkWhtRateRentSetupSpecial(boolean chkWhtRateRentSetupSpecial) {
		this.chkWhtRateRentSetupSpecial = chkWhtRateRentSetupSpecial;
	}

	public boolean isDisabledWhtRateRentSetupSpecial() {
		return disabledWhtRateRentSetupSpecial;
	}

	public void setDisabledWhtRateRentSetupSpecial(
			boolean disabledWhtRateRentSetupSpecial) {
		this.disabledWhtRateRentSetupSpecial = disabledWhtRateRentSetupSpecial;
	}

	public boolean isDisabledChkWhtRateSpecial4() {
		return disabledChkWhtRateSpecial4;
	}

	public void setDisabledChkWhtRateSpecial4(boolean disabledChkWhtRateSpecial4) {
		this.disabledChkWhtRateSpecial4 = disabledChkWhtRateSpecial4;
	}

	public boolean isDisabledRentSetup() {
		return disabledRentSetup;
	}

	public void setDisabledRentSetup(boolean disabledRentSetup) {
		this.disabledRentSetup = disabledRentSetup;
	}

	public boolean isDisabledWhtRateServiceOtherSpecial() {
		return disabledWhtRateServiceOtherSpecial;
	}

	public void setDisabledWhtRateServiceOtherSpecial(
			boolean disabledWhtRateServiceOtherSpecial) {
		this.disabledWhtRateServiceOtherSpecial = disabledWhtRateServiceOtherSpecial;
	}

	public boolean isChkWhtRateServiceOtherSpecial() {
		return chkWhtRateServiceOtherSpecial;
	}

	public void setChkWhtRateServiceOtherSpecial(
			boolean chkWhtRateServiceOtherSpecial) {
		this.chkWhtRateServiceOtherSpecial = chkWhtRateServiceOtherSpecial;
	}

	public boolean isFix5Percent() {
		return fix5Percent;
	}

	public void setFix5Percent(boolean fix5Percent) {
		this.fix5Percent = fix5Percent;
	}

	public boolean isRenderAlertMessage() {
		return renderAlertMessage;
	}

	public void setRenderAlertMessage(boolean renderAlertMessage) {
		this.renderAlertMessage = renderAlertMessage;
	}

	public String getPayPeriodType06() {
		return payPeriodType06;
	}

	public void setPayPeriodType06(String payPeriodType06) {
		this.payPeriodType06 = payPeriodType06;
	}

	public String getPayPeriodType07() {
		return payPeriodType07;
	}

	public void setPayPeriodType07(String payPeriodType07) {
		this.payPeriodType07 = payPeriodType07;
	}

	public boolean isChkNoRentalPayment() {
		return chkNoRentalPayment;
	}

	public void setChkNoRentalPayment(boolean chkNoRentalPayment) {
		this.chkNoRentalPayment = chkNoRentalPayment;
	}

	public boolean isChkRentalEditFlag() {
		return chkRentalEditFlag;
	}

	public void setChkRentalEditFlag(boolean chkRentalEditFlag) {
		this.chkRentalEditFlag = chkRentalEditFlag;
	}

	public String getRentEditFlag() {
		return rentEditFlag;
	}

	public void setRentEditFlag(String rentEditFlag) {
		this.rentEditFlag = rentEditFlag;
	}

	public boolean isRenderedRantalDepositCash() {
		return renderedRantalDepositCash;
	}

	public void setRenderedRantalDepositCash(boolean renderedRantalDepositCash) {
		this.renderedRantalDepositCash = renderedRantalDepositCash;
	}

	public boolean isRenderedRantalDepositBg() {
		return renderedRantalDepositBg;
	}

	public void setRenderedRantalDepositBg(boolean renderedRantalDepositBg) {
		this.renderedRantalDepositBg = renderedRantalDepositBg;
	}

	public List<SelectItem> getServTypeList() {
		return servTypeList;
	}

	public void setServTypeList(List<SelectItem> servTypeList) {
		this.servTypeList = servTypeList;
	}

	public List<Msi004SrchRentCondSP> getRentCondExtSPList() {
		return rentCondExtSPList;
	}

	public void setRentCondExtSPList(List<Msi004SrchRentCondSP> rentCondExtSPList) {
		this.rentCondExtSPList = rentCondExtSPList;
	}

	public boolean isChkRentAdj() {
		return chkRentAdj;
	}

	public void setChkRentAdj(boolean chkRentAdj) {
		this.chkRentAdj = chkRentAdj;
	}

	public boolean isChkServId() {
		return chkServId;
	}

	public void setChkServId(boolean chkServId) {
		this.chkServId = chkServId;
	}

	public List<SelectItem> getRentAdjList() {
		return rentAdjList;
	}

	public void setRentAdjList(List<SelectItem> rentAdjList) {
		this.rentAdjList = rentAdjList;
	}

	public List<SelectItem> getPromiseRenewPeriodTypeList() {
		return promiseRenewPeriodTypeList;
	}

	public void setPromiseRenewPeriodTypeList(
			List<SelectItem> promiseRenewPeriodTypeList) {
		this.promiseRenewPeriodTypeList = promiseRenewPeriodTypeList;
	}

	public SiteInfoMapSiteAcqSP getSiteInfoObjParam() {
		return siteInfoObjParam;
	}

	public void setSiteInfoObjParam(SiteInfoMapSiteAcqSP siteInfoObjParam) {
		siteInfoObjParam = siteInfoObjParam;
	}

	public SiteAppSP getSiteAppDeptObj() {
		return siteAppDeptObj;
	}

	public void setSiteAppDeptObj(SiteAppSP siteAppDeptObj) {
		this.siteAppDeptObj = siteAppDeptObj;
	}

	public SiteAppSP getSiteAppDeptCashObj() {
		return siteAppDeptCashObj;
	}

	public void setSiteAppDeptCashObj(SiteAppSP siteAppDeptCashObj) {
		this.siteAppDeptCashObj = siteAppDeptCashObj;
	}

	public SiteAppSP getSiteAppDeptBgObj() {
		return siteAppDeptBgObj;
	}

	public void setSiteAppDeptBgObj(SiteAppSP siteAppDeptBgObj) {
		this.siteAppDeptBgObj = siteAppDeptBgObj;
	}

	public List<WrapperBeanObject<SiteAppSP>> getSiteAppDeptBGList() {
		return siteAppDeptBGList;
	}

	public void setSiteAppDeptBGList(
			List<WrapperBeanObject<SiteAppSP>> siteAppDeptBGList) {
		this.siteAppDeptBGList = siteAppDeptBGList;
	}

	public List<WrapperBeanObject<SiteAppSP>> getSiteAppDeptCashList() {
		return siteAppDeptCashList;
	}

	public void setSiteAppDeptCashList(
			List<WrapperBeanObject<SiteAppSP>> siteAppDeptCashList) {
		this.siteAppDeptCashList = siteAppDeptCashList;
	}

	public boolean isDeptReceiveBg() {
		return deptReceiveBg;
	}

	public void setDeptReceiveBg(boolean deptReceiveBg) {
		this.deptReceiveBg = deptReceiveBg;
	}

	public boolean isDeptNoBg() {
		return deptNoBg;
	}

	public void setDeptNoBg(boolean deptNoBg) {
		this.deptNoBg = deptNoBg;
	}

	public boolean isDeptCancelBg() {
		return deptCancelBg;
	}

	public void setDeptCancelBg(boolean deptCancelBg) {
		this.deptCancelBg = deptCancelBg;
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

	public String getDeptReturnType01() {
		return deptReturnType01;
	}

	public void setDeptReturnType01(String deptReturnType01) {
		this.deptReturnType01 = deptReturnType01;
	}

	public String getDeptReturnType02() {
		return deptReturnType02;
	}

	public void setDeptReturnType02(String deptReturnType02) {
		this.deptReturnType02 = deptReturnType02;
	}

	public String getDeptReturnType03() {
		return deptReturnType03;
	}

	public void setDeptReturnType03(String deptReturnType03) {
		this.deptReturnType03 = deptReturnType03;
	}

	public boolean isWithdrawFlag() {
		return withdrawFlag;
	}

	public void setWithdrawFlag(boolean withdrawFlag) {
		this.withdrawFlag = withdrawFlag;
	}

	public List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> getSiteAppRentServList() {
		return siteAppRentServList;
	}

	public void setSiteAppRentServList(
			List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> siteAppRentServList) {
		this.siteAppRentServList = siteAppRentServList;
	}

	public boolean isChkRentalDepositEditFlag() {
		return chkRentalDepositEditFlag;
	}

	public void setChkRentalDepositEditFlag(boolean chkRentalDepositEditFlag) {
		this.chkRentalDepositEditFlag = chkRentalDepositEditFlag;
	}

	public String getRentDepositEditFlag() {
		return rentDepositEditFlag;
	}

	public void setRentDepositEditFlag(String rentDepositEditFlag) {
		this.rentDepositEditFlag = rentDepositEditFlag;
	}

	public List<SelectItem> getFix5PercentList() {
		return fix5PercentList;
	}

	public void setFix5PercentList(List<SelectItem> fix5PercentList) {
		this.fix5PercentList = fix5PercentList;
	}

	public boolean isChkContRentAdj() {
		return chkContRentAdj;
	}

	public void setChkContRentAdj(boolean chkContRentAdj) {
		this.chkContRentAdj = chkContRentAdj;
	}

	public boolean isDisabledExpenseDesc() {
		return disabledExpenseDesc;
	}

	public void setDisabledExpenseDesc(boolean disabledExpenseDesc) {
		this.disabledExpenseDesc = disabledExpenseDesc;
	}
	
	
	
	
}
