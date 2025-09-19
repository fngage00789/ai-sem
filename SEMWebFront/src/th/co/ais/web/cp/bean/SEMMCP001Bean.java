package th.co.ais.web.cp.bean;

import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import org.richfaces.model.TreeNode;

import th.co.ais.domain.co.ContractCheckDoc;
import th.co.ais.domain.common.MenuTreeSP;
import th.co.ais.domain.cp.ConstructionPermissionGenDocNoSearchSP;
import th.co.ais.domain.cp.ConstructionPermissionLocationSearchSP;
import th.co.ais.domain.cp.ConstructionPermissionSavePay;
import th.co.ais.domain.cp.Mcp001CanclePay;
import th.co.ais.domain.cp.Mcp001ChkPayable;
import th.co.ais.domain.cp.Mcp001ChkSavePay;
import th.co.ais.domain.cp.Mcp001SavePay;
//import th.co.ais.domain.cp.ConstructionPermissionSaveSP;
import th.co.ais.domain.cp.ConstructionPermissionSearchSP;
import th.co.ais.domain.pt.Mpt004Cal;
import th.co.ais.domain.si.Construct;
import th.co.ais.domain.si.SiteInfoSP;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;
import th.co.ais.web.bean.TreeUtilBean;

public class SEMMCP001Bean extends AbstractBean{
	
	private static final long serialVersionUID = -3578155470405023645L;
	 
	
	private List<SelectItem> regionList;
	private List<SelectItem> companyList;
	private List<SelectItem> siteConstructStatusList;
	private List<SelectItem> siteConstructStatusTmpList;
	
	private List<SelectItem> constructTypeList; //ประเภทขออนุญาตก่อสร้าง
	private List<SelectItem> constructStatusList;//สถานะขออนุญาตก่อสร้าง
	private List<SelectItem> postTypeList; //เสาอากาศ ชนิด
	private List<SelectItem> whtRateList;
	private List<SelectItem> paymentTypeList;
	private List<SelectItem> paymentMethodList;
	private List<SelectItem> paymentStatusList;

	private List<SelectItem> conBillPayStatusList; 
	

	private List<SelectItem> totResultStatusList; //ผลการอนุญาตแจ้งก่อสร้าง TOT
	private List<SelectItem> conResultStatusList; //ผลการอนุญาต Construction Rereuest Result
	private List<SelectItem> conReqBillPayStatusList; // สถานะเบิก ConResultExpose conReqBillPayStatus
	
	private boolean companyAis;
	private boolean viewMode;
	private boolean renderRemark;
	private boolean renderConstruct;
	private boolean editable = true;
	private boolean payable;
	private boolean nonCostruct;
	private boolean conPayable;
	private String conTmp;
	private boolean renderedMsgFormPopup = false;
	
	private TreeUtilBean treeUtilBean;
	
	private ConstructionPermissionSearchSP conToken = null;
	
	// added by.. YUT
	private boolean renderedOnToDoList = false;
	private TreeNode rootNode = null;
	
	public List<SelectItem> getConReqBillPayStatusList() {
		return conReqBillPayStatusList;
	}
	public void setConReqBillPayStatusList(List<SelectItem> conReqBillPayStatusList) {
		this.conReqBillPayStatusList = conReqBillPayStatusList;
	}
	//For Search Construction in Page semmcp001-1.jsp
	private List<ConstructionPermissionSearchSP> constructionPermissionSearchSPList;
	private ConstructionPermissionSearchSP constructionPermissionSearchSP;
	
	private ConstructionPermissionSearchSP constructionPermissionForSearch;
	
	private ConstructionPermissionSavePay constructionPermissionSavePay;
	
	// For Search Construction Location In Grids Page semmcp001-2.jsp
	private List<ConstructionPermissionLocationSearchSP> constructionPermissionLocationSearchSPList;
	private ConstructionPermissionLocationSearchSP constructionPermissionLocationSearchSP;
	
	
	private List<ConstructionPermissionGenDocNoSearchSP> constructionPermissionGenDocNoSearchSPList;
	public List<ConstructionPermissionGenDocNoSearchSP> getConstructionPermissionGenDocNoSearchSPList() {
		return constructionPermissionGenDocNoSearchSPList;
	}
	public void setConstructionPermissionGenDocNoSearchSPList(
			List<ConstructionPermissionGenDocNoSearchSP> constructionPermissionGenDocNoSearchSPList) {
		this.constructionPermissionGenDocNoSearchSPList = constructionPermissionGenDocNoSearchSPList;
	}
	public ConstructionPermissionGenDocNoSearchSP getConstructionPermissionGenDocNoSearchSP() {
		return constructionPermissionGenDocNoSearchSP;
	}
	public void setConstructionPermissionGenDocNoSearchSP(
			ConstructionPermissionGenDocNoSearchSP constructionPermissionGenDocNoSearchSP) {
		this.constructionPermissionGenDocNoSearchSP = constructionPermissionGenDocNoSearchSP;
	}
	private ConstructionPermissionGenDocNoSearchSP constructionPermissionGenDocNoSearchSP;

	
	// For Save Construction 
	/*private List<ConstructionPermissionSaveSP> constructionPermissionSaveSPsList;
	private ConstructionPermissionSaveSP constructionPermissionSaveSP;*/
	
	private String confirmDeleteMsg;
	private Boolean buttonAdd;
	private Date sendRenewBackDt;
	private String validatePopup;
	
	//old date for constructstatusReq
	private Date oldConSubReqDt;
	private Date oldConpermissionDocDt;
	private Date oldConsendSubDt;
	private String oldConResultStatus01;
	private String oldConResultStatus02;
	private Date oldRejectDt;
	private Date oldRejectClearDt;
	
	//old date for noticeTOT
	private Date oldSubReqDt;
	private Date oldTotSendTotDt;
	private Date oldTotSendSubDt;
	private Date oldTotSubReceiveDt;
	private String oldTotResultStatus01;
	private String oldTotResultStatus02;
	
	private boolean tmpConstructType;
	private boolean disableBtnTot;
	private boolean disableBtnConstructStatus;
	private boolean disablePnlRemarkNotAllow;
	private boolean disablePnlConRemarkNotAllow;
	private boolean flagCheckRequireWBS;
	
	private boolean disableConstructType;
	
	private Construct construct;
	private Mpt004Cal mpt004Cal;
	private Mcp001ChkPayable mcp001ChkPayable;
	private Mcp001ChkSavePay mcp001ChkSavePay;
	private Mcp001SavePay mcp001SavePay;
	private Mcp001CanclePay mcp001CanclePay;
	
	// excAmt vatAmt whtAmt for (+ - 1)
	private Double oldExcAmt;
	private Double oldVatAmt;
	private Double oldWhtAmt;
	private Double oldIncAmt;
	private Double oldchqAmt;
	
	private boolean disableWhtRate;
	private boolean renderCldChqDt;
	private boolean renderCldTransferDt;
	private boolean disabelBtnSavePay;
	private boolean disableBtnCanclePay;
	private String tmpFlagValidate;
	private boolean disablePnlShowDetailConstruct;
	private boolean checkResultChange;
	private boolean checkReject;
	
// 16/10/2013 Add By Noom -- use for show document contract like legal approve 
	private String createBy;
	private String updateBy;
	private Date createDate;
	private Date updateDate;
	private ContractCheckDoc contractCheckDoc;
	private boolean renderChk1;
	private boolean renderChk2;
	private boolean renderChk3;
	private boolean renderChk4;
	private boolean renderChk5;
	private boolean renderChk6;
	private boolean renderChk7;
	private boolean renderChk8;
	// rentalType1
	private boolean chkDoc111;
	private boolean chkDoc112;
	private boolean chkDoc121;
	private boolean chkDoc122;
	private boolean chkDoc131;
	private boolean chkDoc132;
	private boolean chkDoc141;
	private boolean chkDoc142;
	private boolean chkDoc151;
	private boolean chkDoc152;
	private boolean chkDoc161;
	private boolean chkDoc162;
	private boolean chkDoc171;
	private boolean chkDoc172;
	private boolean chkDoc181;
	private boolean chkDoc182;
	private boolean chkDoc191;
	private boolean chkDoc192;
	private String rentalOtherRemark1;
	
	// rentalType2
	private boolean chkDoc211;
	private boolean chkDoc212;
	private boolean chkDoc221;
	private boolean chkDoc222;
	private boolean chkDoc231;
	private boolean chkDoc232;
	private boolean chkDoc241;
	private boolean chkDoc242;
	private boolean chkDoc251;
	private boolean chkDoc252;
	private boolean chkDoc261;
	private boolean chkDoc262;
	private boolean chkDoc271;
	private boolean chkDoc272;
	private boolean chkDoc281;
	private boolean chkDoc282;
	private String rentalOtherRemark2;
	
	// rentalType3
	private boolean chkDoc311;
	private boolean chkDoc312;
	private boolean chkDoc321;
	private boolean chkDoc322;
	private boolean chkDoc331;
	private boolean chkDoc332;
	private boolean chkDoc341;
	private boolean chkDoc342;
	private boolean chkDoc351;
	private boolean chkDoc352;
	private boolean chkDoc361;
	private boolean chkDoc362;
	private boolean chkDoc371;
	private boolean chkDoc372;
	private boolean chkDoc381;
	private boolean chkDoc382;
	private boolean chkDoc391;
	private boolean chkDoc392;
	private String rentalOtherRemark3;
	
	// rentalType4
	private boolean chkDoc411;
	private boolean chkDoc412;
	private boolean chkDoc421;
	private boolean chkDoc422;
	private boolean chkDoc431;
	private boolean chkDoc432;
	private boolean chkDoc441;
	private boolean chkDoc442;
	private boolean chkDoc451;
	private boolean chkDoc452;
	private boolean chkDoc461;
	private boolean chkDoc462;
	private boolean chkDoc471;
	private boolean chkDoc472;
	private boolean chkDoc481;
	private boolean chkDoc482;
	private boolean chkDoc491;
	private boolean chkDoc492;
	private boolean chkDoc4101;
	private boolean chkDoc4102;
	private String rentalOtherRemark4;
	
	// rentalType5
	private boolean chkDoc511;
	private boolean chkDoc512;
	private boolean chkDoc521;
	private boolean chkDoc522;
	private boolean chkDoc531;
	private boolean chkDoc532;
	private boolean chkDoc541;
	private boolean chkDoc542;
	private boolean chkDoc551;
	private boolean chkDoc552;
	private boolean chkDoc561;
	private boolean chkDoc562;
	private boolean chkDoc571;
	private boolean chkDoc572;
	private boolean chkDoc581;
	private boolean chkDoc582;
	private boolean chkDoc591;
	private boolean chkDoc592;
	private String rentalOtherRemark5;
	
	// rentalType6
	private boolean chkDoc611;
	private boolean chkDoc612;
	private boolean chkDoc621;
	private boolean chkDoc622;
	private boolean chkDoc631;
	private boolean chkDoc632;
	private boolean chkDoc641;
	private boolean chkDoc642;
	private boolean chkDoc651;
	private boolean chkDoc652;
	private boolean chkDoc661;
	private boolean chkDoc662;
	private boolean chkDoc671;
	private boolean chkDoc672;
	private boolean chkDoc681;
	private boolean chkDoc682;
	private boolean chkDoc691;
	private boolean chkDoc692;
	private String rentalOtherRemark6;
	
	// rentalType7
	private boolean chkDoc711;
	private boolean chkDoc712;
	private boolean chkDoc721;
	private boolean chkDoc722;
	private boolean chkDoc731;
	private boolean chkDoc732;
	private boolean chkDoc741;
	private boolean chkDoc742;
	private boolean chkDoc751;
	private boolean chkDoc752;
	private boolean chkDoc761;
	private boolean chkDoc762;
	private boolean chkDoc771;
	private boolean chkDoc772;
	private boolean chkDoc781;
	private boolean chkDoc782;
	private boolean chkDoc791;
	private boolean chkDoc792;
	private boolean chkDoc7101;
	private boolean chkDoc7102;
	private boolean chkDoc7111;
	private boolean chkDoc7112;
	private String rentalOtherRemark7;
	
	private boolean chkDoc811;
	private boolean chkDoc812;
	private boolean chkDoc821;
	private boolean chkDoc822;
	private boolean chkDoc831;
	private boolean chkDoc832;
	private boolean chkDoc841;
	private boolean chkDoc842;
	private boolean chkDoc851;
	private boolean chkDoc852;
	private String rentalOtherRemark8;
	private String rentalType99;
	
	//added by NEW 20151030
	public boolean treeMacroFlag = false;
	public String headerTreeMacro;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreeMacroList;
	
	public boolean treePicoFlag = false;
	public String headerTreePico;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreePicoList;
	
	private ConstructionPermissionSearchSP constructionPermissionTransferSP;
	private boolean disabledTransfer;
	private SiteInfoSP siteInfoData;
	
	
	/*public List<ConstructionPermissionSaveSP> getConstructionPermissionSaveSPsList() {
		return constructionPermissionSaveSPsList;
	}
	public void setConstructionPermissionSaveSPsList(
			List<ConstructionPermissionSaveSP> constructionPermissionSaveSPsList) {
		this.constructionPermissionSaveSPsList = constructionPermissionSaveSPsList;
	}
	public ConstructionPermissionSaveSP getConstructionPermissionSaveSP() {
		return constructionPermissionSaveSP;
	}
	public void setConstructionPermissionSaveSP(
			ConstructionPermissionSaveSP constructionPermissionSaveSP) {
		this.constructionPermissionSaveSP = constructionPermissionSaveSP;
	}*/
	public List<SelectItem> getPostTypeList() {
		return postTypeList;
	}
	public void setPostTypeList(List<SelectItem> postTypeList) {
		this.postTypeList = postTypeList;
	}
	public List<SelectItem> getTotResultStatusList() {
		return totResultStatusList;
	}
	public void setTotResultStatusList(List<SelectItem> totResultStatusList) {
		this.totResultStatusList = totResultStatusList;
	}
	public List<SelectItem> getConResultStatusList() {
		return conResultStatusList;
	}
	public void setConResultStatusList(List<SelectItem> conResultStatusList) {
		this.conResultStatusList = conResultStatusList;
	}
	
	public List<ConstructionPermissionLocationSearchSP> getConstructionPermissionLocationSearchSPList() {
		return constructionPermissionLocationSearchSPList;
	}
	public void setConstructionPermissionLocationSearchSPList(
			List<ConstructionPermissionLocationSearchSP> constructionPermissionLocationSearchSPList) {
		this.constructionPermissionLocationSearchSPList = constructionPermissionLocationSearchSPList;
	}
	public ConstructionPermissionLocationSearchSP getConstructionPermissionLocationSearchSP() {
		return constructionPermissionLocationSearchSP;
	}
	public void setConstructionPermissionLocationSearchSP(
			ConstructionPermissionLocationSearchSP constructionPermissionLocationSearchSP) {
		this.constructionPermissionLocationSearchSP = constructionPermissionLocationSearchSP;
	}
	public List<SelectItem> getSiteConstructStatusList() {
		return siteConstructStatusList;
	}
	public void setSiteConstructStatusList(List<SelectItem> siteConstructStatusList) {
		this.siteConstructStatusList = siteConstructStatusList;
	}
	public List<SelectItem> getConstructStatusList() {
		return constructStatusList;
	}
	public void setConstructStatusList(List<SelectItem> constructStatusList) {
		this.constructStatusList = constructStatusList;
	}
	public List<SelectItem> getConBillPayStatusList() {
		return conBillPayStatusList;
	}
	public void setConBillPayStatusList(List<SelectItem> conBillPayStatusList) {
		this.conBillPayStatusList = conBillPayStatusList;
	}
	public List<ConstructionPermissionSearchSP> getConstructionPermissionSearchSPList() {
		return constructionPermissionSearchSPList;
	}
	public void setConstructionPermissionSearchSPList(
			List<ConstructionPermissionSearchSP> constructionPermissionSearchSPList) {
		this.constructionPermissionSearchSPList = constructionPermissionSearchSPList;
	}
	public ConstructionPermissionSearchSP getConstructionPermissionSearchSP() {
		return constructionPermissionSearchSP;
	}
	public void setConstructionPermissionSearchSP(
			ConstructionPermissionSearchSP constructionPermissionSearchSP) {
		this.constructionPermissionSearchSP = constructionPermissionSearchSP;
	}
	
	public List<SelectItem> getCompanyList() {
		return companyList;
	}
	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}
	public List<SelectItem> getRegionList() {
		return regionList;
	}
	public void setRegionList(List<SelectItem> regionList) {
		this.regionList = regionList;
	}
	
	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	
	public List<SelectItem> getConstructTypeList() {
		return constructTypeList;
	}
	public void setConstructTypeList(List<SelectItem> constructTypeList) {
		this.constructTypeList = constructTypeList;
	}
	
	public void setConfirmDeleteMsg(String confirmDeleteMsg) {
		this.confirmDeleteMsg = confirmDeleteMsg;
	}
	public String getConfirmDeleteMsg() {
		return confirmDeleteMsg;
	}
	public void setButtonAdd(Boolean buttonAdd) {
		this.buttonAdd = buttonAdd;
	}
	public Boolean getButtonAdd() {
		return buttonAdd;
	}
	public void setSendRenewBackDt(Date sendRenewBackDt) {
		this.sendRenewBackDt = sendRenewBackDt;
	}
	public Date getSendRenewBackDt() {
		return sendRenewBackDt;
	}
	public void setValidatePopup(String validatePopup) {
		this.validatePopup = validatePopup;
	}
	public String getValidatePopup() {
		return validatePopup;
	}
	public Date getOldConSubReqDt() {
		return oldConSubReqDt;
	}
	public void setOldConSubReqDt(Date oldConSubReqDt) {
		this.oldConSubReqDt = oldConSubReqDt;
	}
	public Date getOldConpermissionDocDt() {
		return oldConpermissionDocDt;
	}
	public void setOldConpermissionDocDt(Date oldConpermissionDocDt) {
		this.oldConpermissionDocDt = oldConpermissionDocDt;
	}
	public Date getOldConsendSubDt() {
		return oldConsendSubDt;
	}
	public void setOldConsendSubDt(Date oldConsendSubDt) {
		this.oldConsendSubDt = oldConsendSubDt;
	}
	public Date getOldRejectDt() {
		return oldRejectDt;
	}
	public void setOldRejectDt(Date oldRejectDt) {
		this.oldRejectDt = oldRejectDt;
	}
	public Date getOldRejectClearDt() {
		return oldRejectClearDt;
	}
	public void setOldRejectClearDt(Date oldRejectClearDt) {
		this.oldRejectClearDt = oldRejectClearDt;
	}
	public Date getOldSubReqDt() {
		return oldSubReqDt;
	}
	public void setOldSubReqDt(Date oldSubReqDt) {
		this.oldSubReqDt = oldSubReqDt;
	}
	public Date getOldTotSendTotDt() {
		return oldTotSendTotDt;
	}
	public void setOldTotSendTotDt(Date oldTotSendTotDt) {
		this.oldTotSendTotDt = oldTotSendTotDt;
	}
	public Date getOldTotSendSubDt() {
		return oldTotSendSubDt;
	}
	public void setOldTotSendSubDt(Date oldTotSendSubDt) {
		this.oldTotSendSubDt = oldTotSendSubDt;
	}
	public String getOldConResultStatus01() {
		return oldConResultStatus01;
	}
	public void setOldConResultStatus01(String oldConResultStatus01) {
		this.oldConResultStatus01 = oldConResultStatus01;
	}
	public String getOldConResultStatus02() {
		return oldConResultStatus02;
	}
	public void setOldConResultStatus02(String oldConResultStatus02) {
		this.oldConResultStatus02 = oldConResultStatus02;
	}
	public String getOldTotResultStatus01() {
		return oldTotResultStatus01;
	}
	public void setOldTotResultStatus01(String oldTotResultStatus01) {
		this.oldTotResultStatus01 = oldTotResultStatus01;
	}
	public String getOldTotResultStatus02() {
		return oldTotResultStatus02;
	}
	public void setOldTotResultStatus02(String oldTotResultStatus02) {
		this.oldTotResultStatus02 = oldTotResultStatus02;
	}
	public void setTmpConstructType(boolean tmpConstructType) {
		this.tmpConstructType = tmpConstructType;
	}
	public boolean isTmpConstructType() {
		return tmpConstructType;
	}
	public void setConstructionPermissionSavePay(
			ConstructionPermissionSavePay constructionPermissionSavePay) {
		this.constructionPermissionSavePay = constructionPermissionSavePay;
	}
	public ConstructionPermissionSavePay getConstructionPermissionSavePay() {
		return constructionPermissionSavePay;
	}
	public boolean isDisableBtnTot() {
		return disableBtnTot;
	}
	public void setDisableBtnTot(boolean disableBtnTot) {
		this.disableBtnTot = disableBtnTot;
	}
	public boolean isDisableBtnConstructStatus() {
		return disableBtnConstructStatus;
	}
	public void setDisableBtnConstructStatus(boolean disableBtnConstructStatus) {
		this.disableBtnConstructStatus = disableBtnConstructStatus;
	}
	public void setDisablePnlRemarkNotAllow(boolean disablePnlRemarkNotAllow) {
		this.disablePnlRemarkNotAllow = disablePnlRemarkNotAllow;
	}
	public boolean isDisablePnlRemarkNotAllow() {
		return disablePnlRemarkNotAllow;
	}
	public void setFlagCheckRequireWBS(boolean flagCheckRequireWBS) {
		this.flagCheckRequireWBS = flagCheckRequireWBS;
	}
	public boolean isFlagCheckRequireWBS() {
		return flagCheckRequireWBS;
	}
	public void setDisablePnlConRemarkNotAllow(boolean disablePnlConRemarkNotAllow) {
		this.disablePnlConRemarkNotAllow = disablePnlConRemarkNotAllow;
	}
	public boolean isDisablePnlConRemarkNotAllow() {
		return disablePnlConRemarkNotAllow;
	}
	public void setOldTotSubReceiveDt(Date oldTotSubReceiveDt) {
		this.oldTotSubReceiveDt = oldTotSubReceiveDt;
	}
	public Date getOldTotSubReceiveDt() {
		return oldTotSubReceiveDt;
	}
	public void setDisableConstructType(boolean disableConstructType) {
		this.disableConstructType = disableConstructType;
	}
	public boolean isDisableConstructType() {
		return disableConstructType;
	}
	public void setConstruct(Construct construct) {
		this.construct = construct;
	}
	public Construct getConstruct() {
		return construct;
	}
	public void setMpt004Cal(Mpt004Cal mpt004Cal) {
		this.mpt004Cal = mpt004Cal;
	}
	public Mpt004Cal getMpt004Cal() {
		return mpt004Cal;
	}
	public Double getOldExcAmt() {
		return oldExcAmt;
	}
	public void setOldExcAmt(Double oldExcAmt) {
		this.oldExcAmt = oldExcAmt;
	}
	public Double getOldVatAmt() {
		return oldVatAmt;
	}
	public void setOldVatAmt(Double oldVatAmt) {
		this.oldVatAmt = oldVatAmt;
	}
	public Double getOldWhtAmt() {
		return oldWhtAmt;
	}
	public void setOldWhtAmt(Double oldWhtAmt) {
		this.oldWhtAmt = oldWhtAmt;
	}
	public Double getOldIncAmt() {
		return oldIncAmt;
	}
	public void setOldIncAmt(Double oldIncAmt) {
		this.oldIncAmt = oldIncAmt;
	}
	public void setOldchqAmt(Double oldchqAmt) {
		this.oldchqAmt = oldchqAmt;
	}
	public Double getOldchqAmt() {
		return oldchqAmt;
	}
	public void setDisableWhtRate(boolean disableWhtRate) {
		this.disableWhtRate = disableWhtRate;
	}
	public boolean isDisableWhtRate() {
		return disableWhtRate;
	}
	public void setWhtRateList(List<SelectItem> whtRateList) {
		this.whtRateList = whtRateList;
	}
	public List<SelectItem> getWhtRateList() {
		return whtRateList;
	}
	public void setPaymentTypeList(List<SelectItem> paymentTypeList) {
		this.paymentTypeList = paymentTypeList;
	}
	public List<SelectItem> getPaymentTypeList() {
		return paymentTypeList;
	}
	public void setPaymentMethodList(List<SelectItem> paymentMethodList) {
		this.paymentMethodList = paymentMethodList;
	}
	public List<SelectItem> getPaymentMethodList() {
		return paymentMethodList;
	}
	public boolean isRenderCldChqDt() {
		return renderCldChqDt;
	}
	public void setRenderCldChqDt(boolean renderCldChqDt) {
		this.renderCldChqDt = renderCldChqDt;
	}
	public boolean isRenderCldTransferDt() {
		return renderCldTransferDt;
	}
	public void setRenderCldTransferDt(boolean renderCldTransferDt) {
		this.renderCldTransferDt = renderCldTransferDt;
	}
	public void setMcp001ChkPayable(Mcp001ChkPayable mcp001ChkPayable) {
		this.mcp001ChkPayable = mcp001ChkPayable;
	}
	public Mcp001ChkPayable getMcp001ChkPayable() {
		return mcp001ChkPayable;
	}
	public boolean isDisabelBtnSavePay() {
		return disabelBtnSavePay;
	}
	public void setDisabelBtnSavePay(boolean disabelBtnSavePay) {
		this.disabelBtnSavePay = disabelBtnSavePay;
	}
	public boolean isDisableBtnCanclePay() {
		return disableBtnCanclePay;
	}
	public void setDisableBtnCanclePay(boolean disableBtnCanclePay) {
		this.disableBtnCanclePay = disableBtnCanclePay;
	}
	/**
	 * @param mcp001ChkSavePay the mcp001ChkSavePay to set
	 */
	public void setMcp001ChkSavePay(Mcp001ChkSavePay mcp001ChkSavePay) {
		this.mcp001ChkSavePay = mcp001ChkSavePay;
	}
	/**
	 * @return the mcp001ChkSavePay
	 */
	public Mcp001ChkSavePay getMcp001ChkSavePay() {
		return mcp001ChkSavePay;
	}
	/**
	 * @param mcp001SavePay the mcp001SavePay to set
	 */
	public void setMcp001SavePay(Mcp001SavePay mcp001SavePay) {
		this.mcp001SavePay = mcp001SavePay;
	}
	/**
	 * @return the mcp001SavePay
	 */
	public Mcp001SavePay getMcp001SavePay() {
		return mcp001SavePay;
	}
	/**
	 * @param tmpFlagValidate the tmpFlagValidate to set
	 */
	public void setTmpFlagValidate(String tmpFlagValidate) {
		this.tmpFlagValidate = tmpFlagValidate;
	}
	/**
	 * @return the tmpFlagValidate
	 */
	public String getTmpFlagValidate() {
		return tmpFlagValidate;
	}
	/**
	 * @param paymentStatusList the paymentStatusList to set
	 */
	public void setPaymentStatusList(List<SelectItem> paymentStatusList) {
		this.paymentStatusList = paymentStatusList;
	}
	/**
	 * @return the paymentStatusList
	 */
	public List<SelectItem> getPaymentStatusList() {
		return paymentStatusList;
	}
	/**
	 * @param mcp001CanclePay the mcp001CanclePay to set
	 */
	public void setMcp001CanclePay(Mcp001CanclePay mcp001CanclePay) {
		this.mcp001CanclePay = mcp001CanclePay;
	}
	/**
	 * @return the mcp001CanclePay
	 */
	public Mcp001CanclePay getMcp001CanclePay() {
		return mcp001CanclePay;
	}
	/**
	 * @param disablePnlShowDetailConstruct the disablePnlShowDetailConstruct to set
	 */
	public void setDisablePnlShowDetailConstruct(
			boolean disablePnlShowDetailConstruct) {
		this.disablePnlShowDetailConstruct = disablePnlShowDetailConstruct;
	}
	/**
	 * @return the disablePnlShowDetailConstruct
	 */
	public boolean isDisablePnlShowDetailConstruct() {
		return disablePnlShowDetailConstruct;
	}
	public ConstructionPermissionSearchSP getConstructionPermissionForSearch() {
		return constructionPermissionForSearch;
	}
	public void setConstructionPermissionForSearch(
			ConstructionPermissionSearchSP constructionPermissionForSearch) {
		this.constructionPermissionForSearch = constructionPermissionForSearch;
	}
	public boolean isCompanyAis() {
		return companyAis;
	}
	public void setCompanyAis(boolean companyAis) {
		this.companyAis = companyAis;
	}
	public boolean isViewMode() {
		return viewMode;
	}
	public void setViewMode(boolean viewMode) {
		this.viewMode = viewMode;
	}
	public boolean isRenderRemark() {
		return renderRemark;
	}
	public void setRenderRemark(boolean renderRemark) {
		this.renderRemark = renderRemark;
	}
	public boolean isRenderConstruct() {
		return renderConstruct;
	}
	public void setRenderConstruct(boolean renderConstruct) {
		this.renderConstruct = renderConstruct;
	}
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	public boolean isPayable() {
		return payable;
	}
	public void setPayable(boolean payable) {
		this.payable = payable;
	}
	public boolean isNonCostruct() {
		return nonCostruct;
	}
	public void setNonCostruct(boolean nonCostruct) {
		this.nonCostruct = nonCostruct;
	}
	public boolean isConPayable() {
		return conPayable;
	}
	public void setConPayable(boolean conPayable) {
		this.conPayable = conPayable;
	}
	public boolean isCheckResultChange() {
		return checkResultChange;
	}
	public void setCheckResultChange(boolean checkResultChange) {
		this.checkResultChange = checkResultChange;
	}
	public boolean isCheckReject() {
		return checkReject;
	}
	public void setCheckReject(boolean checkReject) {
		this.checkReject = checkReject;
	}
	public ConstructionPermissionSearchSP getConToken() {
		return conToken;
	}
	public void setConToken(ConstructionPermissionSearchSP conToken) {
		this.conToken = conToken;
	}
	public String getConTmp() {
		return conTmp;
	}
	public void setConTmp(String conTmp) {
		this.conTmp = conTmp;
	}
	public boolean isRenderedMsgFormPopup() {
		return renderedMsgFormPopup;
	}
	public void setRenderedMsgFormPopup(boolean renderedMsgFormPopup) {
		this.renderedMsgFormPopup = renderedMsgFormPopup;
	}
	public boolean isRenderChk1() {
		return renderChk1;
	}
	public void setRenderChk1(boolean renderChk1) {
		this.renderChk1 = renderChk1;
	}
	public boolean isRenderChk2() {
		return renderChk2;
	}
	public void setRenderChk2(boolean renderChk2) {
		this.renderChk2 = renderChk2;
	}
	public boolean isRenderChk3() {
		return renderChk3;
	}
	public void setRenderChk3(boolean renderChk3) {
		this.renderChk3 = renderChk3;
	}
	public boolean isRenderChk4() {
		return renderChk4;
	}
	public void setRenderChk4(boolean renderChk4) {
		this.renderChk4 = renderChk4;
	}
	public boolean isRenderChk5() {
		return renderChk5;
	}
	public void setRenderChk5(boolean renderChk5) {
		this.renderChk5 = renderChk5;
	}
	public boolean isRenderChk6() {
		return renderChk6;
	}
	public void setRenderChk6(boolean renderChk6) {
		this.renderChk6 = renderChk6;
	}
	public boolean isRenderChk7() {
		return renderChk7;
	}
	public void setRenderChk7(boolean renderChk7) {
		this.renderChk7 = renderChk7;
	}
	public ContractCheckDoc getContractCheckDoc() {
		return contractCheckDoc;
	}
	public void setContractCheckDoc(ContractCheckDoc contractCheckDoc) {
		this.contractCheckDoc = contractCheckDoc;
	}
	public String getRentalType99() {
		return rentalType99;
	}
	public void setRentalType99(String rentalType99) {
		this.rentalType99 = rentalType99;
	}
	public boolean isRenderChk8() {
		return renderChk8;
	}
	public void setRenderChk8(boolean renderChk8) {
		this.renderChk8 = renderChk8;
	}
	public boolean isChkDoc111() {
		return chkDoc111;
	}
	public void setChkDoc111(boolean chkDoc111) {
		this.chkDoc111 = chkDoc111;
	}
	public boolean isChkDoc112() {
		return chkDoc112;
	}
	public void setChkDoc112(boolean chkDoc112) {
		this.chkDoc112 = chkDoc112;
	}
	public boolean isChkDoc121() {
		return chkDoc121;
	}
	public void setChkDoc121(boolean chkDoc121) {
		this.chkDoc121 = chkDoc121;
	}
	public boolean isChkDoc122() {
		return chkDoc122;
	}
	public void setChkDoc122(boolean chkDoc122) {
		this.chkDoc122 = chkDoc122;
	}
	public boolean isChkDoc131() {
		return chkDoc131;
	}
	public void setChkDoc131(boolean chkDoc131) {
		this.chkDoc131 = chkDoc131;
	}
	public boolean isChkDoc132() {
		return chkDoc132;
	}
	public void setChkDoc132(boolean chkDoc132) {
		this.chkDoc132 = chkDoc132;
	}
	public boolean isChkDoc141() {
		return chkDoc141;
	}
	public void setChkDoc141(boolean chkDoc141) {
		this.chkDoc141 = chkDoc141;
	}
	public boolean isChkDoc142() {
		return chkDoc142;
	}
	public void setChkDoc142(boolean chkDoc142) {
		this.chkDoc142 = chkDoc142;
	}
	public boolean isChkDoc151() {
		return chkDoc151;
	}
	public void setChkDoc151(boolean chkDoc151) {
		this.chkDoc151 = chkDoc151;
	}
	public boolean isChkDoc152() {
		return chkDoc152;
	}
	public void setChkDoc152(boolean chkDoc152) {
		this.chkDoc152 = chkDoc152;
	}
	public boolean isChkDoc161() {
		return chkDoc161;
	}
	public void setChkDoc161(boolean chkDoc161) {
		this.chkDoc161 = chkDoc161;
	}
	public boolean isChkDoc162() {
		return chkDoc162;
	}
	public void setChkDoc162(boolean chkDoc162) {
		this.chkDoc162 = chkDoc162;
	}
	public boolean isChkDoc171() {
		return chkDoc171;
	}
	public void setChkDoc171(boolean chkDoc171) {
		this.chkDoc171 = chkDoc171;
	}
	public boolean isChkDoc172() {
		return chkDoc172;
	}
	public void setChkDoc172(boolean chkDoc172) {
		this.chkDoc172 = chkDoc172;
	}
	public boolean isChkDoc181() {
		return chkDoc181;
	}
	public void setChkDoc181(boolean chkDoc181) {
		this.chkDoc181 = chkDoc181;
	}
	public boolean isChkDoc182() {
		return chkDoc182;
	}
	public void setChkDoc182(boolean chkDoc182) {
		this.chkDoc182 = chkDoc182;
	}
	public boolean isChkDoc191() {
		return chkDoc191;
	}
	public void setChkDoc191(boolean chkDoc191) {
		this.chkDoc191 = chkDoc191;
	}
	public boolean isChkDoc192() {
		return chkDoc192;
	}
	public void setChkDoc192(boolean chkDoc192) {
		this.chkDoc192 = chkDoc192;
	}
	public String getRentalOtherRemark1() {
		return rentalOtherRemark1;
	}
	public void setRentalOtherRemark1(String rentalOtherRemark1) {
		this.rentalOtherRemark1 = rentalOtherRemark1;
	}
	public boolean isChkDoc211() {
		return chkDoc211;
	}
	public void setChkDoc211(boolean chkDoc211) {
		this.chkDoc211 = chkDoc211;
	}
	public boolean isChkDoc212() {
		return chkDoc212;
	}
	public void setChkDoc212(boolean chkDoc212) {
		this.chkDoc212 = chkDoc212;
	}
	public boolean isChkDoc221() {
		return chkDoc221;
	}
	public void setChkDoc221(boolean chkDoc221) {
		this.chkDoc221 = chkDoc221;
	}
	public boolean isChkDoc222() {
		return chkDoc222;
	}
	public void setChkDoc222(boolean chkDoc222) {
		this.chkDoc222 = chkDoc222;
	}
	public boolean isChkDoc231() {
		return chkDoc231;
	}
	public void setChkDoc231(boolean chkDoc231) {
		this.chkDoc231 = chkDoc231;
	}
	public boolean isChkDoc232() {
		return chkDoc232;
	}
	public void setChkDoc232(boolean chkDoc232) {
		this.chkDoc232 = chkDoc232;
	}
	public boolean isChkDoc241() {
		return chkDoc241;
	}
	public void setChkDoc241(boolean chkDoc241) {
		this.chkDoc241 = chkDoc241;
	}
	public boolean isChkDoc242() {
		return chkDoc242;
	}
	public void setChkDoc242(boolean chkDoc242) {
		this.chkDoc242 = chkDoc242;
	}
	public boolean isChkDoc251() {
		return chkDoc251;
	}
	public void setChkDoc251(boolean chkDoc251) {
		this.chkDoc251 = chkDoc251;
	}
	public boolean isChkDoc252() {
		return chkDoc252;
	}
	public void setChkDoc252(boolean chkDoc252) {
		this.chkDoc252 = chkDoc252;
	}
	public boolean isChkDoc261() {
		return chkDoc261;
	}
	public void setChkDoc261(boolean chkDoc261) {
		this.chkDoc261 = chkDoc261;
	}
	public boolean isChkDoc262() {
		return chkDoc262;
	}
	public void setChkDoc262(boolean chkDoc262) {
		this.chkDoc262 = chkDoc262;
	}
	public boolean isChkDoc271() {
		return chkDoc271;
	}
	public void setChkDoc271(boolean chkDoc271) {
		this.chkDoc271 = chkDoc271;
	}
	public boolean isChkDoc272() {
		return chkDoc272;
	}
	public void setChkDoc272(boolean chkDoc272) {
		this.chkDoc272 = chkDoc272;
	}
	public boolean isChkDoc281() {
		return chkDoc281;
	}
	public void setChkDoc281(boolean chkDoc281) {
		this.chkDoc281 = chkDoc281;
	}
	public boolean isChkDoc282() {
		return chkDoc282;
	}
	public void setChkDoc282(boolean chkDoc282) {
		this.chkDoc282 = chkDoc282;
	}
	public String getRentalOtherRemark2() {
		return rentalOtherRemark2;
	}
	public void setRentalOtherRemark2(String rentalOtherRemark2) {
		this.rentalOtherRemark2 = rentalOtherRemark2;
	}
	public boolean isChkDoc311() {
		return chkDoc311;
	}
	public void setChkDoc311(boolean chkDoc311) {
		this.chkDoc311 = chkDoc311;
	}
	public boolean isChkDoc312() {
		return chkDoc312;
	}
	public void setChkDoc312(boolean chkDoc312) {
		this.chkDoc312 = chkDoc312;
	}
	public boolean isChkDoc321() {
		return chkDoc321;
	}
	public void setChkDoc321(boolean chkDoc321) {
		this.chkDoc321 = chkDoc321;
	}
	public boolean isChkDoc322() {
		return chkDoc322;
	}
	public void setChkDoc322(boolean chkDoc322) {
		this.chkDoc322 = chkDoc322;
	}
	public boolean isChkDoc331() {
		return chkDoc331;
	}
	public void setChkDoc331(boolean chkDoc331) {
		this.chkDoc331 = chkDoc331;
	}
	public boolean isChkDoc332() {
		return chkDoc332;
	}
	public void setChkDoc332(boolean chkDoc332) {
		this.chkDoc332 = chkDoc332;
	}
	public boolean isChkDoc341() {
		return chkDoc341;
	}
	public void setChkDoc341(boolean chkDoc341) {
		this.chkDoc341 = chkDoc341;
	}
	public boolean isChkDoc342() {
		return chkDoc342;
	}
	public void setChkDoc342(boolean chkDoc342) {
		this.chkDoc342 = chkDoc342;
	}
	public boolean isChkDoc351() {
		return chkDoc351;
	}
	public void setChkDoc351(boolean chkDoc351) {
		this.chkDoc351 = chkDoc351;
	}
	public boolean isChkDoc352() {
		return chkDoc352;
	}
	public void setChkDoc352(boolean chkDoc352) {
		this.chkDoc352 = chkDoc352;
	}
	public boolean isChkDoc361() {
		return chkDoc361;
	}
	public void setChkDoc361(boolean chkDoc361) {
		this.chkDoc361 = chkDoc361;
	}
	public boolean isChkDoc362() {
		return chkDoc362;
	}
	public void setChkDoc362(boolean chkDoc362) {
		this.chkDoc362 = chkDoc362;
	}
	public boolean isChkDoc371() {
		return chkDoc371;
	}
	public void setChkDoc371(boolean chkDoc371) {
		this.chkDoc371 = chkDoc371;
	}
	public boolean isChkDoc372() {
		return chkDoc372;
	}
	public void setChkDoc372(boolean chkDoc372) {
		this.chkDoc372 = chkDoc372;
	}
	public boolean isChkDoc381() {
		return chkDoc381;
	}
	public void setChkDoc381(boolean chkDoc381) {
		this.chkDoc381 = chkDoc381;
	}
	public boolean isChkDoc382() {
		return chkDoc382;
	}
	public void setChkDoc382(boolean chkDoc382) {
		this.chkDoc382 = chkDoc382;
	}
	public boolean isChkDoc391() {
		return chkDoc391;
	}
	public void setChkDoc391(boolean chkDoc391) {
		this.chkDoc391 = chkDoc391;
	}
	public boolean isChkDoc392() {
		return chkDoc392;
	}
	public void setChkDoc392(boolean chkDoc392) {
		this.chkDoc392 = chkDoc392;
	}
	public String getRentalOtherRemark3() {
		return rentalOtherRemark3;
	}
	public void setRentalOtherRemark3(String rentalOtherRemark3) {
		this.rentalOtherRemark3 = rentalOtherRemark3;
	}
	public boolean isChkDoc411() {
		return chkDoc411;
	}
	public void setChkDoc411(boolean chkDoc411) {
		this.chkDoc411 = chkDoc411;
	}
	public boolean isChkDoc412() {
		return chkDoc412;
	}
	public void setChkDoc412(boolean chkDoc412) {
		this.chkDoc412 = chkDoc412;
	}
	public boolean isChkDoc421() {
		return chkDoc421;
	}
	public void setChkDoc421(boolean chkDoc421) {
		this.chkDoc421 = chkDoc421;
	}
	public boolean isChkDoc422() {
		return chkDoc422;
	}
	public void setChkDoc422(boolean chkDoc422) {
		this.chkDoc422 = chkDoc422;
	}
	public boolean isChkDoc431() {
		return chkDoc431;
	}
	public void setChkDoc431(boolean chkDoc431) {
		this.chkDoc431 = chkDoc431;
	}
	public boolean isChkDoc432() {
		return chkDoc432;
	}
	public void setChkDoc432(boolean chkDoc432) {
		this.chkDoc432 = chkDoc432;
	}
	public boolean isChkDoc441() {
		return chkDoc441;
	}
	public void setChkDoc441(boolean chkDoc441) {
		this.chkDoc441 = chkDoc441;
	}
	public boolean isChkDoc442() {
		return chkDoc442;
	}
	public void setChkDoc442(boolean chkDoc442) {
		this.chkDoc442 = chkDoc442;
	}
	public boolean isChkDoc451() {
		return chkDoc451;
	}
	public void setChkDoc451(boolean chkDoc451) {
		this.chkDoc451 = chkDoc451;
	}
	public boolean isChkDoc452() {
		return chkDoc452;
	}
	public void setChkDoc452(boolean chkDoc452) {
		this.chkDoc452 = chkDoc452;
	}
	public boolean isChkDoc461() {
		return chkDoc461;
	}
	public void setChkDoc461(boolean chkDoc461) {
		this.chkDoc461 = chkDoc461;
	}
	public boolean isChkDoc462() {
		return chkDoc462;
	}
	public void setChkDoc462(boolean chkDoc462) {
		this.chkDoc462 = chkDoc462;
	}
	public boolean isChkDoc471() {
		return chkDoc471;
	}
	public void setChkDoc471(boolean chkDoc471) {
		this.chkDoc471 = chkDoc471;
	}
	public boolean isChkDoc472() {
		return chkDoc472;
	}
	public void setChkDoc472(boolean chkDoc472) {
		this.chkDoc472 = chkDoc472;
	}
	public boolean isChkDoc481() {
		return chkDoc481;
	}
	public void setChkDoc481(boolean chkDoc481) {
		this.chkDoc481 = chkDoc481;
	}
	public boolean isChkDoc482() {
		return chkDoc482;
	}
	public void setChkDoc482(boolean chkDoc482) {
		this.chkDoc482 = chkDoc482;
	}
	public boolean isChkDoc491() {
		return chkDoc491;
	}
	public void setChkDoc491(boolean chkDoc491) {
		this.chkDoc491 = chkDoc491;
	}
	public boolean isChkDoc492() {
		return chkDoc492;
	}
	public void setChkDoc492(boolean chkDoc492) {
		this.chkDoc492 = chkDoc492;
	}
	public boolean isChkDoc4101() {
		return chkDoc4101;
	}
	public void setChkDoc4101(boolean chkDoc4101) {
		this.chkDoc4101 = chkDoc4101;
	}
	public boolean isChkDoc4102() {
		return chkDoc4102;
	}
	public void setChkDoc4102(boolean chkDoc4102) {
		this.chkDoc4102 = chkDoc4102;
	}
	public String getRentalOtherRemark4() {
		return rentalOtherRemark4;
	}
	public void setRentalOtherRemark4(String rentalOtherRemark4) {
		this.rentalOtherRemark4 = rentalOtherRemark4;
	}
	public boolean isChkDoc511() {
		return chkDoc511;
	}
	public void setChkDoc511(boolean chkDoc511) {
		this.chkDoc511 = chkDoc511;
	}
	public boolean isChkDoc512() {
		return chkDoc512;
	}
	public void setChkDoc512(boolean chkDoc512) {
		this.chkDoc512 = chkDoc512;
	}
	public boolean isChkDoc521() {
		return chkDoc521;
	}
	public void setChkDoc521(boolean chkDoc521) {
		this.chkDoc521 = chkDoc521;
	}
	public boolean isChkDoc522() {
		return chkDoc522;
	}
	public void setChkDoc522(boolean chkDoc522) {
		this.chkDoc522 = chkDoc522;
	}
	public boolean isChkDoc531() {
		return chkDoc531;
	}
	public void setChkDoc531(boolean chkDoc531) {
		this.chkDoc531 = chkDoc531;
	}
	public boolean isChkDoc532() {
		return chkDoc532;
	}
	public void setChkDoc532(boolean chkDoc532) {
		this.chkDoc532 = chkDoc532;
	}
	public boolean isChkDoc541() {
		return chkDoc541;
	}
	public void setChkDoc541(boolean chkDoc541) {
		this.chkDoc541 = chkDoc541;
	}
	public boolean isChkDoc542() {
		return chkDoc542;
	}
	public void setChkDoc542(boolean chkDoc542) {
		this.chkDoc542 = chkDoc542;
	}
	public boolean isChkDoc551() {
		return chkDoc551;
	}
	public void setChkDoc551(boolean chkDoc551) {
		this.chkDoc551 = chkDoc551;
	}
	public boolean isChkDoc552() {
		return chkDoc552;
	}
	public void setChkDoc552(boolean chkDoc552) {
		this.chkDoc552 = chkDoc552;
	}
	public boolean isChkDoc561() {
		return chkDoc561;
	}
	public void setChkDoc561(boolean chkDoc561) {
		this.chkDoc561 = chkDoc561;
	}
	public boolean isChkDoc562() {
		return chkDoc562;
	}
	public void setChkDoc562(boolean chkDoc562) {
		this.chkDoc562 = chkDoc562;
	}
	public boolean isChkDoc571() {
		return chkDoc571;
	}
	public void setChkDoc571(boolean chkDoc571) {
		this.chkDoc571 = chkDoc571;
	}
	public boolean isChkDoc572() {
		return chkDoc572;
	}
	public void setChkDoc572(boolean chkDoc572) {
		this.chkDoc572 = chkDoc572;
	}
	public boolean isChkDoc581() {
		return chkDoc581;
	}
	public void setChkDoc581(boolean chkDoc581) {
		this.chkDoc581 = chkDoc581;
	}
	public boolean isChkDoc582() {
		return chkDoc582;
	}
	public void setChkDoc582(boolean chkDoc582) {
		this.chkDoc582 = chkDoc582;
	}
	public boolean isChkDoc591() {
		return chkDoc591;
	}
	public void setChkDoc591(boolean chkDoc591) {
		this.chkDoc591 = chkDoc591;
	}
	public boolean isChkDoc592() {
		return chkDoc592;
	}
	public void setChkDoc592(boolean chkDoc592) {
		this.chkDoc592 = chkDoc592;
	}
	public String getRentalOtherRemark5() {
		return rentalOtherRemark5;
	}
	public void setRentalOtherRemark5(String rentalOtherRemark5) {
		this.rentalOtherRemark5 = rentalOtherRemark5;
	}
	public boolean isChkDoc611() {
		return chkDoc611;
	}
	public void setChkDoc611(boolean chkDoc611) {
		this.chkDoc611 = chkDoc611;
	}
	public boolean isChkDoc612() {
		return chkDoc612;
	}
	public void setChkDoc612(boolean chkDoc612) {
		this.chkDoc612 = chkDoc612;
	}
	public boolean isChkDoc621() {
		return chkDoc621;
	}
	public void setChkDoc621(boolean chkDoc621) {
		this.chkDoc621 = chkDoc621;
	}
	public boolean isChkDoc622() {
		return chkDoc622;
	}
	public void setChkDoc622(boolean chkDoc622) {
		this.chkDoc622 = chkDoc622;
	}
	public boolean isChkDoc631() {
		return chkDoc631;
	}
	public void setChkDoc631(boolean chkDoc631) {
		this.chkDoc631 = chkDoc631;
	}
	public boolean isChkDoc632() {
		return chkDoc632;
	}
	public void setChkDoc632(boolean chkDoc632) {
		this.chkDoc632 = chkDoc632;
	}
	public boolean isChkDoc641() {
		return chkDoc641;
	}
	public void setChkDoc641(boolean chkDoc641) {
		this.chkDoc641 = chkDoc641;
	}
	public boolean isChkDoc642() {
		return chkDoc642;
	}
	public void setChkDoc642(boolean chkDoc642) {
		this.chkDoc642 = chkDoc642;
	}
	public boolean isChkDoc651() {
		return chkDoc651;
	}
	public void setChkDoc651(boolean chkDoc651) {
		this.chkDoc651 = chkDoc651;
	}
	public boolean isChkDoc652() {
		return chkDoc652;
	}
	public void setChkDoc652(boolean chkDoc652) {
		this.chkDoc652 = chkDoc652;
	}
	public boolean isChkDoc661() {
		return chkDoc661;
	}
	public void setChkDoc661(boolean chkDoc661) {
		this.chkDoc661 = chkDoc661;
	}
	public boolean isChkDoc662() {
		return chkDoc662;
	}
	public void setChkDoc662(boolean chkDoc662) {
		this.chkDoc662 = chkDoc662;
	}
	public boolean isChkDoc671() {
		return chkDoc671;
	}
	public void setChkDoc671(boolean chkDoc671) {
		this.chkDoc671 = chkDoc671;
	}
	public boolean isChkDoc672() {
		return chkDoc672;
	}
	public void setChkDoc672(boolean chkDoc672) {
		this.chkDoc672 = chkDoc672;
	}
	public boolean isChkDoc681() {
		return chkDoc681;
	}
	public void setChkDoc681(boolean chkDoc681) {
		this.chkDoc681 = chkDoc681;
	}
	public boolean isChkDoc682() {
		return chkDoc682;
	}
	public void setChkDoc682(boolean chkDoc682) {
		this.chkDoc682 = chkDoc682;
	}
	public boolean isChkDoc691() {
		return chkDoc691;
	}
	public void setChkDoc691(boolean chkDoc691) {
		this.chkDoc691 = chkDoc691;
	}
	public boolean isChkDoc692() {
		return chkDoc692;
	}
	public void setChkDoc692(boolean chkDoc692) {
		this.chkDoc692 = chkDoc692;
	}
	public String getRentalOtherRemark6() {
		return rentalOtherRemark6;
	}
	public void setRentalOtherRemark6(String rentalOtherRemark6) {
		this.rentalOtherRemark6 = rentalOtherRemark6;
	}
	public boolean isChkDoc711() {
		return chkDoc711;
	}
	public void setChkDoc711(boolean chkDoc711) {
		this.chkDoc711 = chkDoc711;
	}
	public boolean isChkDoc712() {
		return chkDoc712;
	}
	public void setChkDoc712(boolean chkDoc712) {
		this.chkDoc712 = chkDoc712;
	}
	public boolean isChkDoc721() {
		return chkDoc721;
	}
	public void setChkDoc721(boolean chkDoc721) {
		this.chkDoc721 = chkDoc721;
	}
	public boolean isChkDoc722() {
		return chkDoc722;
	}
	public void setChkDoc722(boolean chkDoc722) {
		this.chkDoc722 = chkDoc722;
	}
	public boolean isChkDoc731() {
		return chkDoc731;
	}
	public void setChkDoc731(boolean chkDoc731) {
		this.chkDoc731 = chkDoc731;
	}
	public boolean isChkDoc732() {
		return chkDoc732;
	}
	public void setChkDoc732(boolean chkDoc732) {
		this.chkDoc732 = chkDoc732;
	}
	public boolean isChkDoc741() {
		return chkDoc741;
	}
	public void setChkDoc741(boolean chkDoc741) {
		this.chkDoc741 = chkDoc741;
	}
	public boolean isChkDoc742() {
		return chkDoc742;
	}
	public void setChkDoc742(boolean chkDoc742) {
		this.chkDoc742 = chkDoc742;
	}
	public boolean isChkDoc751() {
		return chkDoc751;
	}
	public void setChkDoc751(boolean chkDoc751) {
		this.chkDoc751 = chkDoc751;
	}
	public boolean isChkDoc752() {
		return chkDoc752;
	}
	public void setChkDoc752(boolean chkDoc752) {
		this.chkDoc752 = chkDoc752;
	}
	public boolean isChkDoc761() {
		return chkDoc761;
	}
	public void setChkDoc761(boolean chkDoc761) {
		this.chkDoc761 = chkDoc761;
	}
	public boolean isChkDoc762() {
		return chkDoc762;
	}
	public void setChkDoc762(boolean chkDoc762) {
		this.chkDoc762 = chkDoc762;
	}
	public boolean isChkDoc771() {
		return chkDoc771;
	}
	public void setChkDoc771(boolean chkDoc771) {
		this.chkDoc771 = chkDoc771;
	}
	public boolean isChkDoc772() {
		return chkDoc772;
	}
	public void setChkDoc772(boolean chkDoc772) {
		this.chkDoc772 = chkDoc772;
	}
	public boolean isChkDoc781() {
		return chkDoc781;
	}
	public void setChkDoc781(boolean chkDoc781) {
		this.chkDoc781 = chkDoc781;
	}
	public boolean isChkDoc782() {
		return chkDoc782;
	}
	public void setChkDoc782(boolean chkDoc782) {
		this.chkDoc782 = chkDoc782;
	}
	public boolean isChkDoc791() {
		return chkDoc791;
	}
	public void setChkDoc791(boolean chkDoc791) {
		this.chkDoc791 = chkDoc791;
	}
	public boolean isChkDoc792() {
		return chkDoc792;
	}
	public void setChkDoc792(boolean chkDoc792) {
		this.chkDoc792 = chkDoc792;
	}
	public boolean isChkDoc7101() {
		return chkDoc7101;
	}
	public void setChkDoc7101(boolean chkDoc7101) {
		this.chkDoc7101 = chkDoc7101;
	}
	public boolean isChkDoc7102() {
		return chkDoc7102;
	}
	public void setChkDoc7102(boolean chkDoc7102) {
		this.chkDoc7102 = chkDoc7102;
	}
	public boolean isChkDoc7111() {
		return chkDoc7111;
	}
	public void setChkDoc7111(boolean chkDoc7111) {
		this.chkDoc7111 = chkDoc7111;
	}
	public boolean isChkDoc7112() {
		return chkDoc7112;
	}
	public void setChkDoc7112(boolean chkDoc7112) {
		this.chkDoc7112 = chkDoc7112;
	}
	public String getRentalOtherRemark7() {
		return rentalOtherRemark7;
	}
	public void setRentalOtherRemark7(String rentalOtherRemark7) {
		this.rentalOtherRemark7 = rentalOtherRemark7;
	}
	public boolean isChkDoc811() {
		return chkDoc811;
	}
	public void setChkDoc811(boolean chkDoc811) {
		this.chkDoc811 = chkDoc811;
	}
	public boolean isChkDoc812() {
		return chkDoc812;
	}
	public void setChkDoc812(boolean chkDoc812) {
		this.chkDoc812 = chkDoc812;
	}
	public boolean isChkDoc821() {
		return chkDoc821;
	}
	public void setChkDoc821(boolean chkDoc821) {
		this.chkDoc821 = chkDoc821;
	}
	public boolean isChkDoc822() {
		return chkDoc822;
	}
	public void setChkDoc822(boolean chkDoc822) {
		this.chkDoc822 = chkDoc822;
	}
	public boolean isChkDoc831() {
		return chkDoc831;
	}
	public void setChkDoc831(boolean chkDoc831) {
		this.chkDoc831 = chkDoc831;
	}
	public boolean isChkDoc832() {
		return chkDoc832;
	}
	public void setChkDoc832(boolean chkDoc832) {
		this.chkDoc832 = chkDoc832;
	}
	public boolean isChkDoc841() {
		return chkDoc841;
	}
	public void setChkDoc841(boolean chkDoc841) {
		this.chkDoc841 = chkDoc841;
	}
	public boolean isChkDoc842() {
		return chkDoc842;
	}
	public void setChkDoc842(boolean chkDoc842) {
		this.chkDoc842 = chkDoc842;
	}
	public boolean isChkDoc851() {
		return chkDoc851;
	}
	public void setChkDoc851(boolean chkDoc851) {
		this.chkDoc851 = chkDoc851;
	}
	public boolean isChkDoc852() {
		return chkDoc852;
	}
	public void setChkDoc852(boolean chkDoc852) {
		this.chkDoc852 = chkDoc852;
	}
	public String getRentalOtherRemark8() {
		return rentalOtherRemark8;
	}
	public void setRentalOtherRemark8(String rentalOtherRemark8) {
		this.rentalOtherRemark8 = rentalOtherRemark8;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public List<SelectItem> getSiteConstructStatusTmpList() {
		return siteConstructStatusTmpList;
	}
	public void setSiteConstructStatusTmpList(
			List<SelectItem> siteConstructStatusTmpList) {
		this.siteConstructStatusTmpList = siteConstructStatusTmpList;
	}
	public boolean isRenderedOnToDoList() {
		return renderedOnToDoList;
	}
	public void setRenderedOnToDoList(boolean renderedOnToDoList) {
		this.renderedOnToDoList = renderedOnToDoList;
	}
	public TreeUtilBean getTreeUtilBean() {
		return treeUtilBean;
	}
	public void setTreeUtilBean(TreeUtilBean treeUtilBean) {
		this.treeUtilBean = treeUtilBean;
	}
	public TreeNode getRootNode() {
		return rootNode;
	}
	public void setRootNode(TreeNode rootNode) {
		this.rootNode = rootNode;
	}
	public boolean isTreeMacroFlag() {
		return treeMacroFlag;
	}
	public void setTreeMacroFlag(boolean treeMacroFlag) {
		this.treeMacroFlag = treeMacroFlag;
	}
	public String getHeaderTreeMacro() {
		return headerTreeMacro;
	}
	public void setHeaderTreeMacro(String headerTreeMacro) {
		this.headerTreeMacro = headerTreeMacro;
	}
	public List<WrapperBeanObject<MenuTreeSP>> getMenuTreeMacroList() {
		return menuTreeMacroList;
	}
	public void setMenuTreeMacroList(
			List<WrapperBeanObject<MenuTreeSP>> menuTreeMacroList) {
		this.menuTreeMacroList = menuTreeMacroList;
	}
	public boolean isTreePicoFlag() {
		return treePicoFlag;
	}
	public void setTreePicoFlag(boolean treePicoFlag) {
		this.treePicoFlag = treePicoFlag;
	}
	public String getHeaderTreePico() {
		return headerTreePico;
	}
	public void setHeaderTreePico(String headerTreePico) {
		this.headerTreePico = headerTreePico;
	}
	public List<WrapperBeanObject<MenuTreeSP>> getMenuTreePicoList() {
		return menuTreePicoList;
	}
	public void setMenuTreePicoList(
			List<WrapperBeanObject<MenuTreeSP>> menuTreePicoList) {
		this.menuTreePicoList = menuTreePicoList;
	}
	public ConstructionPermissionSearchSP getConstructionPermissionTransferSP() {
		return constructionPermissionTransferSP;
	}
	public void setConstructionPermissionTransferSP(
			ConstructionPermissionSearchSP constructionPermissionTransferSP) {
		this.constructionPermissionTransferSP = constructionPermissionTransferSP;
	}
	public boolean isDisabledTransfer() {
		return disabledTransfer;
	}
	public void setDisabledTransfer(boolean disabledTransfer) {
		this.disabledTransfer = disabledTransfer;
	}
	public SiteInfoSP getSiteInfoData() {
		return siteInfoData;
	}
	public void setSiteInfoData(SiteInfoSP siteInfoData) {
		this.siteInfoData = siteInfoData;
	}

	
	
}
