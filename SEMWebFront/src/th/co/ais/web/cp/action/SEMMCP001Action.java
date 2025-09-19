package th.co.ais.web.cp.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.richfaces.component.UITree;
import org.richfaces.component.html.HtmlTree;
import org.richfaces.event.NodeSelectedEvent;
import org.richfaces.model.TreeNode;
import org.richfaces.model.TreeNodeImpl;

import th.co.ais.common.service.IMenuTreeService;
import th.co.ais.domain.co.ContractCheckDoc;
import th.co.ais.domain.common.MenuTreeSP;
import th.co.ais.domain.cp.ConstructionPermissionGenDocNoSearchSP;
import th.co.ais.domain.cp.ConstructionPermissionLocationSearchSP;
import th.co.ais.domain.cp.ConstructionPermissionSavePay;
import th.co.ais.domain.cp.ConstructionPermissionSearchSP;
import th.co.ais.domain.cp.Mcp001CanclePay;
import th.co.ais.domain.cp.Mcp001ChkPayable;
import th.co.ais.domain.cp.Mcp001ChkSavePay;
import th.co.ais.domain.cp.Mcp001SavePay;
import th.co.ais.domain.cp.PopupVendorSupplierSearchSP;
import th.co.ais.domain.gm.VendorMaster;
import th.co.ais.domain.pt.Mpt004Cal;
import th.co.ais.domain.si.Construct;
import th.co.ais.domain.si.PopupContractSearchSP;
import th.co.ais.domain.si.SiteInfoSP;
import th.co.ais.service.co.IContractCheckDocService;
import th.co.ais.service.gm.IVendorMasterService;
import th.co.ais.service.pt.IPTaxMasterService;
import th.co.ais.service.si.ISendRenewService;
import th.co.ais.service.si.ISiteConstructService;
import th.co.ais.service.si.ISiteContractService;
import th.co.ais.service.si.ISiteInfoService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.TreeUtilBean;
import th.co.ais.web.bean.common.PopupSiteContractBean;
import th.co.ais.web.bean.common.PopupVendorSupplierBean;
import th.co.ais.web.common.action.PopupSiteContractAction;
import th.co.ais.web.cp.bean.SEMMCP001Bean;
import th.co.ais.web.el.action.SEMMEL011Action;
import th.co.ais.web.util.ELUtils;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.LOVCacheUtil;
import th.co.ais.web.util.MSGCacheUtil;
import th.co.ais.web.util.ProvinceCacheUtil;
import th.co.ais.web.util.WebUtil;
import th.co.ais.web.util.config.ParameterConfigUtil;

public class SEMMCP001Action extends AbstractAction {

	/**
	 * Apichat H
	 */
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(getClass());
	String tmpFlagValidate = "Y";
	String tmpFlagMsgSave = "Y";
	String siteInfoId ;
	String siteContructId;
	String siteName ;
	String siteContractNo;
	String migrateFlag;
	

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if (methodWithNavi.equalsIgnoreCase("doSearch")) {
			flag = doSearch();
		} else if (methodWithNavi.equalsIgnoreCase("pageLoad")) {
			flag = pageLoad();
		} else if (methodWithNavi.equalsIgnoreCase("doClear")) {
			flag = doClear();
		} else if (methodWithNavi.equalsIgnoreCase("doShow")) {
			flag = doShow();
		}else if (methodWithNavi.equalsIgnoreCase("expandApprovePanel")) {
			flag = expandApprovePanel();
		}else if(methodWithNavi.equalsIgnoreCase("changeCriteriaConstructStatusListDropdownCp002")) {
			flag = changeCriteriaConstructStatusListDropdownCp002();
		}else if(methodWithNavi.equalsIgnoreCase("changeCriteriaConstructStatusListDropdown")) {
			flag = changeCriteriaConstructStatusListDropdown();
		}else if (methodWithNavi.equalsIgnoreCase("doClearSession")) {
			flag = doClearSession();
		}else if(methodWithNavi.equalsIgnoreCase("doUpdate")){
			flag = doUpdate(true);
		}else if(methodWithNavi.equalsIgnoreCase("doSavePay")){
			flag = doSavePay();
		}else if(methodWithNavi.equalsIgnoreCase("doUpdatePay")){
			flag = doUpdatePay();
		}else if(methodWithNavi.equalsIgnoreCase("doCanclePay")){
			flag = doCanclePay();
		}else if(methodWithNavi.equalsIgnoreCase("companyChange")){
			flag = companyChange();
		}else if(methodWithNavi.equalsIgnoreCase("initPopupDocContract")){
			flag = initPopupDocContract();
		}else if(methodWithNavi.equalsIgnoreCase("doInitialForSearchConstruction")){
			flag = this.doInitialForSearchConstruction();
		}
		//added by NEW 09/04/2015 
		else if(methodWithNavi.equalsIgnoreCase("getTreeNode")){
			getTreeNode();
		}else if(methodWithNavi.equalsIgnoreCase("doInitTodoList")){
			flag = this.doInitTodoList();
		}
		
		else if(methodWithNavi.equalsIgnoreCase("initPopupSearchContractNo")){
			flag = this.initPopupSearchContractNo();
		}else if(methodWithNavi.equalsIgnoreCase("doSelectContractNo")){
			flag = this.doSelectContractNo();
		}else if(methodWithNavi.equalsIgnoreCase("doTransfer")){
			flag = this.doTransfer();
		}else if(methodWithNavi.equalsIgnoreCase("doSearchContractForRollBack")){
			flag = this.doSearchContractForRollBack();
		}else if(methodWithNavi.equalsIgnoreCase("doRollBackContract")){
			flag = this.doRollBackContract();
		}else if(methodWithNavi.equalsIgnoreCase("doSearchPopupContractNo")){
			flag = this.doSearchPopupContractNo();
		}else if(methodWithNavi.equalsIgnoreCase("doClearPopupContractNo")){
			flag = this.doClearPopupContractNo();
		}
		
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub

	}

	private boolean doClearSession() {
		boolean flag = true;
		semmcp001Bean = getSemmcp001Bean();
		popupVendorSupplierBean = getPopupVendorSupplierBean();
		
		/*semmcp001Bean.setConstructionPermissionSearchSP(new ConstructionPermissionSearchSP());
		semmcp001Bean.getConstructionPermissionSearchSP().setMigrateFlag("Y");
		semmcp001Bean.setConstructionPermissionSearchSPList(new ArrayList());*/
		if(semmcp001Bean.getConstructionPermissionSearchSP().getCompanyCri() != null && !semmcp001Bean.getConstructionPermissionSearchSP().getCompanyCri().equals("")){
			semmcp001Bean.getConstructionPermissionSearchSP().setSiteConstructStatusCri(semmcp001Bean.getConstructionPermissionSearchSP().getSiteConstructStatus());
			doSearch();
		}
		semmcp001Bean.setConstructionPermissionLocationSearchSP(new ConstructionPermissionLocationSearchSP());
		semmcp001Bean.setConstructionPermissionLocationSearchSPList(new ArrayList());
		
		popupVendorSupplierBean.setPopupVendorSupplierSearchSP(new PopupVendorSupplierSearchSP());
		popupVendorSupplierBean.setPopupVendorSupplierSearchSPList(new ArrayList());
		
		semmcp001Bean.getConstructionPermissionSearchSP().setCheckExpandPanelCon(false);
		semmcp001Bean.getConstructionPermissionSearchSP().setCheckExpandPanelTOT(false);
		
		setPopupVendorSupplierBean(popupVendorSupplierBean);
		semmcp001Bean.setRenderedMsgFormTop(true);
		semmcp001Bean.setRenderedMsgFormMiddle(false);
		setSemmcp001Bean(semmcp001Bean);
		clearValuePanelTOTandCon("CLEARALL");
		
	/***************init****************/	
		semmcp001Bean.setConstructionPermissionSearchSP(new ConstructionPermissionSearchSP());
		semmcp001Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmcp001Bean.setRegionList(getRegionItems());
		semmcp001Bean.getConstructionPermissionSearchSP().setMigrateFlagCri("Y");
		semmcp001Bean.getConstructionPermissionForSearch().setMigrateFlagCri("Y");
		semmcp001Bean.getConstructionPermissionSearchSP().setCheckExpandPanelNoticeReject(false);
		semmcp001Bean.setMcp001ChkPayable(new Mcp001ChkPayable());
		semmcp001Bean.setMcp001ChkSavePay(new Mcp001ChkSavePay());
		semmcp001Bean.setMcp001SavePay(new Mcp001SavePay());
		semmcp001Bean.setMcp001CanclePay(new Mcp001CanclePay());
		semmcp001Bean.setDisableBtnTot(false);
		semmcp001Bean.setDisableBtnConstructStatus(false);
		semmcp001Bean.setEditable(true);
		setSemmcp001Bean(semmcp001Bean);
		
		PopupVendorSupplierBean  popupVendorSupplierBean= new PopupVendorSupplierBean();
		popupVendorSupplierBean.setPopupVendorSupplierSearchSP(new PopupVendorSupplierSearchSP());
		popupVendorSupplierBean.setPostTypeList(getLovItemsByType(ELovType.T_CP_POST_TYPE.name)); // เสาอากาศชนิด
		popupVendorSupplierBean.setConstructTypeList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_TYPE.name)); // ประเภทขออนุญาตก่อสร้าง 
		popupVendorSupplierBean.setConstructStatusList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_STATUS.name).subList(0, 1));// สถานะขออนุญาตก่อสร้าง init  T_CP_CONSTRUCT_STATUS("CP_CONSTRUCT_STATUS"),
		semmcp001Bean.getConstructionPermissionSearchSP().setSiteConstructStatusCri("00");
		setPopupVendorSupplierBean(popupVendorSupplierBean);
		/***************init****************/	
		
		//doSearch();
		return flag;
	}
	
	@Override
	public void init() {
		SEMMCP001Bean semmcp001Bean = new SEMMCP001Bean();
		
//		SEMMCP001Bean semmcp001Bean = getSemmcp001Bean();
		
		
		String siteContructId = (String) getFacesUtils().getRequestParameter("siteContructIdParam");
		doSearchSiteContructId(siteContructId);
		
		semmcp001Bean.setConstructionPermissionSearchSP(new ConstructionPermissionSearchSP());
		semmcp001Bean.setConstructionPermissionForSearch(new ConstructionPermissionSearchSP());
		semmcp001Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
//		semmcp001Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
//		semmcp001Bean.setCompanyList(getCompanyItemsAll());
		semmcp001Bean.setRegionList(getRegionItems());
		semmcp001Bean.setSiteConstructStatusList(getLovItemsByType(ELovType.T_CP_SITE_CONSTRUCT_STATUS.name)); // สถานะงาน
		semmcp001Bean.setSiteConstructStatusTmpList(getLovItemsByType(ELovType.T_CP_SITE_CONSTRUCT_STATUS.name));
		semmcp001Bean.setConstructTypeList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_TYPE.name)); // ประเภทขออนุญาตก่อสร้าง 
		semmcp001Bean.setConstructStatusList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_STATUS.name).subList(0, 1)); // สถานะขออนุญาตก่อสร้าง init  T_CP_CONSTRUCT_STATUS("CP_CONSTRUCT_STATUS"),
//		semmcp001Bean.setConstructStatusList(new ArrayList()); // สถานะขออนุญาตก่อสร้าง init  T_CP_CONSTRUCT_STATUS("CP_CONSTRUCT_STATUS"),
		semmcp001Bean.getConstructionPermissionSearchSP().setMigrateFlagCri("Y");
		semmcp001Bean.getConstructionPermissionForSearch().setMigrateFlagCri("Y");
		semmcp001Bean.setPaymentTypeList(getLovItemsByType(ELovType.T_CT_PAYMENT_TYPE.name, EX_IN, "NORMAL", null, null));
		semmcp001Bean.setPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name));
		
		//set default value for page
		semmcp001Bean.getConstructionPermissionForSearch().setCheckDisabled(true);
		
		// value TOT
		semmcp001Bean.setConBillPayStatusList(getPaymentStatusDDLForCP001());
		//semmcp001Bean.setConBillPayStatusList(getLovItemsByType(ELovType.T_CT_PAYMENT_STATUS.name));	
		semmcp001Bean.setWhtRateList(getLovItemsByType(ELovType.T_CT_WHT_RATE.name));
		semmcp001Bean.setPostTypeList(getLovItemsByType(ELovType.T_CP_POST_TYPE.name)); // เสาอากาศชนิด
//		-- semmcp001Bean.getConstructionPermissionSearchSP().setCheckDisabled(true);
// edit 26		semmcp001Bean.getConstructionPermissionSearchSP().setCheckExpandPanelTOT(false);
		semmcp001Bean.setTotResultStatusList(getLovItemsByType(ELovType.T_CP_CON_RESULT_STATUS.name));	//ผลการอนุญาตแจ้งก่อสร้าง
	
		//setCon Panel
// edit 26		semmcp001Bean.getConstructionPermissionSearchSP().setCheckExpandPanelCon(false);
		semmcp001Bean.getConstructionPermissionSearchSP().setCheckExpandPanelNoticeReject(false);
		semmcp001Bean.getConstructionPermissionForSearch().setCheckExpandPanelNoticeReject(false);
		semmcp001Bean.setConResultStatusList(getLovItemsByType(ELovType.T_CP_CON_RESULT_STATUS.name));
		semmcp001Bean.setConReqBillPayStatusList(getLovItemsByType(ELovType.T_CP_CON_BILL_PAY_STATUS.name));
		semmcp001Bean.setPaymentStatusList(getLovItemsByType(ELovType.T_CT_PAYMENT_STATUS.name));
		
		
		//remove lov code '02' and  '04'
//		try{
//			semmcp001Bean.getPaymentStatusList().remove(WebUtil.getSelectItemByValue("02", semmcp001Bean.getPaymentStatusList()).get(0));
//			semmcp001Bean.getPaymentStatusList().remove(WebUtil.getSelectItemByValue("04", semmcp001Bean.getPaymentStatusList()).get(0));
//		}catch(Exception e){}
		
		semmcp001Bean.setConstructionPermissionSavePay(new ConstructionPermissionSavePay());
		semmcp001Bean.setMcp001ChkPayable(new Mcp001ChkPayable());
		semmcp001Bean.setMcp001ChkSavePay(new Mcp001ChkSavePay());
		semmcp001Bean.setMcp001SavePay(new Mcp001SavePay());
		semmcp001Bean.setMcp001CanclePay(new Mcp001CanclePay());
		
		semmcp001Bean.setConstructionPermissionTransferSP(new ConstructionPermissionSearchSP());
		semmcp001Bean.setSiteInfoData(new SiteInfoSP());
		
		// SetList semmcp001-2 
		setSemmcp001Bean(semmcp001Bean);
		
		// set Object PopupVendorSupplirBean
		PopupVendorSupplierBean  popupVendorSupplierBean= new PopupVendorSupplierBean();
		popupVendorSupplierBean.setPopupVendorSupplierSearchSP(new PopupVendorSupplierSearchSP());
		popupVendorSupplierBean.setPostTypeList(getLovItemsByType(ELovType.T_CP_POST_TYPE.name)); // เสาอากาศชนิด
		popupVendorSupplierBean.setConstructTypeList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_TYPE.name)); // ประเภทขออนุญาตก่อสร้าง 
//		popupVendorSupplierBean.setConstructStatusList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_STATUS.name)); // สถานะขออนุญาตก่อสร้าง init  T_CP_CONSTRUCT_STATUS("CP_CONSTRUCT_STATUS"),
		popupVendorSupplierBean.setConstructStatusList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_STATUS.name).subList(0, 1));// สถานะขออนุญาตก่อสร้าง init  T_CP_CONSTRUCT_STATUS("CP_CONSTRUCT_STATUS"),
		semmcp001Bean.getConstructionPermissionSearchSP().setSiteConstructStatusCri("00");
		semmcp001Bean.getConstructionPermissionForSearch().setSiteConstructStatusCri("00");
		semmcp001Bean.setTreeUtilBean(new TreeUtilBean());
		setPopupVendorSupplierBean(popupVendorSupplierBean);
		
	}
	
	private List<SelectItem> getPaymentStatusDDLForCP001(){
		List<SelectItem> list = getLovItemsByType(ELovType.T_CT_PAYMENT_STATUS.name);
		List<SelectItem> newList = new LinkedList<SelectItem>();
		for(SelectItem s : list){
			if(null != s.getValue()){
				if(!"02".equals(s.getValue()) && !"04".equals(s.getValue())){
					newList.add(s);
				}
			}
		}
		return newList;
	}
	
	
	@SuppressWarnings("null")
	public boolean expandApprovePanel() {
		boolean flag = true;
		semmcp001Bean = getSemmcp001Bean();
		popupVendorSupplierBean = getPopupVendorSupplierBean();
		String constructStatus = getSemmcp001Bean().getConstructionPermissionSearchSP().getSiteConstructStatus();
		String company = "";		
		for(ConstructionPermissionSearchSP cp : semmcp001Bean.getConstructionPermissionSearchSPList()){
			if(cp.getRowId().equals(semmcp001Bean.getConstructionPermissionSearchSP().getSiteContructId())){
				company = cp.getCompanyCri();
				break;
			}
		}
		
		// Set value Panel Case Reqest Construct 
//		PopupVendorSupplierBean  popupVendorSupplierBean= new PopupVendorSupplierBean();
//		popupVendorSupplierBean.setPopupVendorSupplierSearchSP(new PopupVendorSupplierSearchSP());
		popupVendorSupplierBean.setPostTypeList(getLovItemsByType(ELovType.T_CP_POST_TYPE.name)); // เสาอากาศชนิด
		List<SelectItem> constructTypeList = getLovItemsByType(ELovType.T_CP_CONSTRUCT_TYPE.name);
		SelectItem selectItem = new SelectItem();
		List<SelectItem> constructModif = new LinkedList<SelectItem>();
		semmcp001Bean.setDisableConstructType(false);
		
		//default Date DocDt
		if(StringUtils.isEmpty(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getDocNo())){
			popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setDocDt(new Date());
		}
		
		if(!company.isEmpty()){
			if(!company.equals("AIS")){
				for(int i =0 ; i<constructTypeList.size(); i++ ){
					if(constructTypeList.get(i).getValue().equals("02")){
						selectItem.setLabel("-- Select --");
						selectItem.setValue("");
						constructModif.add(selectItem);
						selectItem = new SelectItem();
						selectItem.setLabel(constructTypeList.get(i).getLabel());
						selectItem.setValue(constructTypeList.get(i).getValue());
						constructModif.add(selectItem);
						
					}
					popupVendorSupplierBean.setConstructTypeList(constructModif);
				}
//				popupVendorSupplierBean.setConstructTypeList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_TYPE.name)); // ประเภทขออนุญาตก่อสร้าง 
				semmcp001Bean.setDisableConstructType(true);
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructType("02");
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("01");
			}else{
				popupVendorSupplierBean.setConstructTypeList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_TYPE.name)); // ประเภทขออนุญาตก่อสร้าง 
				
			}
			
		}
		
//		popupVendorSupplierBean.setConstructTypeList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_TYPE.name)); // ประเภทขออนุญาตก่อสร้าง
		popupVendorSupplierBean.setConstructStatusList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_STATUS.name)); // สถานะขออนุญาตก่อสร้าง init  T_CP_CONSTRUCT_STATUS("CP_CONSTRUCT_STATUS"),
		setPopupVendorSupplierBean(popupVendorSupplierBean);
		
//		clearValuePanelTOTandCon();
		
		SEMMCP001Bean semmcp001Bean = getSemmcp001Bean();// new SEMMCP001Bean();
		changeCriteriaConstructStatusListDropdownCp002();
		if(!StringUtils.isEmpty(constructStatus)) {
			if(constructStatus.equals("01")){
				semmcp001Bean.setNonCostruct(true);
				semmcp001Bean.getConstructionPermissionSearchSP().setCheckExpandPanel(true); 
			}else{
				semmcp001Bean.setRenderRemark(false);
				if(constructStatus.equals("02")){
					semmcp001Bean.setNonCostruct(false);
				}else{
					semmcp001Bean.setNonCostruct(true);
				}
				semmcp001Bean.setDisableBtnTot(false);
				semmcp001Bean.setDisableBtnConstructStatus(false);
				semmcp001Bean.getConstructionPermissionSearchSP().setCheckExpandPanel(false); // main 
				semmcp001Bean.getConstructionPermissionSearchSP().setCheckExpandPanelTOT(false);// panel TOT แจ้งเพื่อทราบไปยัง TOT
				semmcp001Bean.getConstructionPermissionSearchSP().setCheckExpandPanelCon(false);//panel Construction ขออนุญาตก่อสร้าง
				semmcp001Bean.getConstructionPermissionSearchSP().setCheckExpandPanelNoticeReject(false); //panel Notic Reject 
				semmcp001Bean.setCheckReject(false);
			}
		}else{
			semmcp001Bean.setNonCostruct(true);
			semmcp001Bean.setDisableBtnTot(false);
			semmcp001Bean.setDisableBtnConstructStatus(false);
			semmcp001Bean.getConstructionPermissionSearchSP().setCheckExpandPanel(false); // main 
			semmcp001Bean.getConstructionPermissionSearchSP().setCheckExpandPanelTOT(false);// panel TOT แจ้งเพื่อทราบไปยัง TOT
			semmcp001Bean.getConstructionPermissionSearchSP().setCheckExpandPanelCon(false);//panel Construction ขออนุญาตก่อสร้าง
			semmcp001Bean.getConstructionPermissionSearchSP().setCheckExpandPanelNoticeReject(false); //panel Notic Reject 
		}
		setSemmcp001Bean(semmcp001Bean);
		
		return flag;
	}
	public boolean changeCriteriaConstructStatusListDropdownCp002() {
		boolean flag = false;
		semmcp001Bean = getSemmcp001Bean();
		popupVendorSupplierBean = getPopupVendorSupplierBean();
		String constructType = getPopupVendorSupplierBean().getPopupVendorSupplierSearchSP().getConstructType();
//		String page = (String) getFacesUtils().getRequestParameter("page");
		String dropdownActionStatus = (String) getFacesUtils().getRequestParameter("dropdownActionStatus");
		try{
			if(dropdownActionStatus != null && dropdownActionStatus.equals("Y")){
				semmcp001Bean.setTmpConstructType(false);
			}else{
				dropdownActionStatus = "";
			}
			
			if(semmcp001Bean.isTmpConstructType() == false){
//				clearValuePanelTOTandCon();
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("01");
			}
//			doClearCheckConstructType();
			
			if (!StringUtils.isEmpty(constructType)) {
//					semmcp001Bean.getConstructionPermissionSearchSP().setCheckDisabled(false);
				
				semmcp001Bean.setOldConResultStatus01("");
				semmcp001Bean.setOldConResultStatus02("");
				semmcp001Bean.setOldTotResultStatus01("");
				semmcp001Bean.setOldTotResultStatus02("");
				semmcp001Bean.setOldRejectDt(semmcp001Bean.getConstructionPermissionSearchSP().getReject_dt());
				semmcp001Bean.setOldRejectClearDt(semmcp001Bean.getConstructionPermissionSearchSP().getReject_clear_dt());
					
				if (constructType.equals("01")) {
					popupVendorSupplierBean.setConstructStatusList(null);
					popupVendorSupplierBean.setConstructStatusList(getLovItemsByType(ELovType.T_CP_TOT_STATUS.name));
					
					semmcp001Bean.getConstructionPermissionSearchSP().setCheckExpandPanelCon(false);
					semmcp001Bean.getConstructionPermissionSearchSP().setCheckExpandPanelTOT(true);
					semmcp001Bean.getConstructionPermissionSearchSP().setCheckExpandPanelNoticeReject(true);
					
					if(semmcp001Bean.getConstructionPermissionSearchSP().getTot_sup_req_dt() == null){
						semmcp001Bean.getConstructionPermissionSearchSP().setTot_sup_req_dt(new Date());
					}
					
					//set old noticeTOT
					semmcp001Bean.setOldSubReqDt(semmcp001Bean.getConstructionPermissionSearchSP().getCon_sup_req_dt());
					semmcp001Bean.setOldTotSendTotDt(semmcp001Bean.getConstructionPermissionSearchSP().getTot_send_tot_dt());
					semmcp001Bean.setOldTotSendSubDt(semmcp001Bean.getConstructionPermissionSearchSP().getTot_send_sup_dt());
					semmcp001Bean.setOldTotSubReceiveDt(semmcp001Bean.getConstructionPermissionSearchSP().getTotSubReceiveDt());
//					semmcp001Bean.setDisableBtnTot(false);
//					semmcp001Bean.setDisableBtnConstructStatus(true);
					
				} else if (constructType.equals("02")) {
					popupVendorSupplierBean.setConstructStatusList(null);
					popupVendorSupplierBean.setConstructStatusList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_STATUS.name));
					
					semmcp001Bean.getConstructionPermissionSearchSP().setCheckExpandPanelTOT(false);
					semmcp001Bean.getConstructionPermissionSearchSP().setCheckExpandPanelCon(true);
					semmcp001Bean.getConstructionPermissionSearchSP().setCheckExpandPanelNoticeReject(true);
					
					if(semmcp001Bean.getConstructionPermissionSearchSP().getCon_sup_req_dt() == null){
						semmcp001Bean.getConstructionPermissionSearchSP().setCon_sup_req_dt(new Date());
					}
					
					//set old constructReq
					semmcp001Bean.setOldConSubReqDt(semmcp001Bean.getConstructionPermissionSearchSP().getCon_sup_req_dt());
					semmcp001Bean.setOldConpermissionDocDt(semmcp001Bean.getConstructionPermissionSearchSP().getCon_permission_doc_dt());
					semmcp001Bean.setOldConsendSubDt(semmcp001Bean.getConstructionPermissionSearchSP().getCon_send_sup_dt());
//					semmcp001Bean.setDisableBtnTot(true);
//					semmcp001Bean.setDisableBtnConstructStatus(false);
				}
				flag = true;
			}else{
//				semmcp001Bean.getConstructionPermissionSearchSP().setCheckDisabled(true);
				popupVendorSupplierBean.setConstructStatusList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_STATUS.name).subList(0, 1));
//				semmcp001Bean.setConstructStatusList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_STATUS.name).subList(0, 1)); // สถานะขออนุญาตก่อสร้าง init  T_CP_CONSTRUCT_STATUS("CP_CONSTRUCT_STATUS"),
				semmcp001Bean.getConstructionPermissionSearchSP().setCheckExpandPanelTOT(false);
				semmcp001Bean.getConstructionPermissionSearchSP().setCheckExpandPanelCon(false);
				semmcp001Bean.getConstructionPermissionSearchSP().setCheckExpandPanelNoticeReject(false);
				flag = false;
				
			}
			onRenderConstructStatus(); 
			if(StringUtils.isNotEmpty(semmcp001Bean.getConTmp())){
				if(!semmcp001Bean.getConTmp().equals(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getConstructType())){
					semmcp001Bean.setDisableBtnConstructStatus(false);
					semmcp001Bean.setDisableBtnTot(false);
				}
			}
			setPopupVendorSupplierBean(popupVendorSupplierBean);
			setSemmcp001Bean(semmcp001Bean);
			checkResultChange();
		}catch (Exception e) {
			log.error("error in SEMMCP001Action Method changeCriteriaConstructStatusListDropdownCP002 : " + e);
		}
		
		return flag;
	}
	
	public void clearConStructtion(){
		semmcp001Bean.getConstructionPermissionSearchSP().setCon_sup_req_dt(null);
		semmcp001Bean.getConstructionPermissionSearchSP().setCon_permission_doc_dt(null);
		semmcp001Bean.getConstructionPermissionSearchSP().setCon_permission_doc_no(null);
		semmcp001Bean.getConstructionPermissionSearchSP().setCon_send_sup_dt(null);
		semmcp001Bean.getConstructionPermissionSearchSP().setCon_result_status(null);
		semmcp001Bean.getConstructionPermissionSearchSP().setCon_build_doc_dt(null);
		semmcp001Bean.getConstructionPermissionSearchSP().setCon_build_doc_no(null);
		semmcp001Bean.getConstructionPermissionSearchSP().setCon_remark_not_allow(null);
	}
	
	public void clearTOT(){
		semmcp001Bean.getConstructionPermissionSearchSP().setTot_sup_req_dt(null);
		semmcp001Bean.getConstructionPermissionSearchSP().setTot_send_doc_no(null);
		semmcp001Bean.getConstructionPermissionSearchSP().setTot_send_tot_dt(null);
		semmcp001Bean.getConstructionPermissionSearchSP().setTot_return_dt(null);
		semmcp001Bean.getConstructionPermissionSearchSP().setTot_result_status(null);
		semmcp001Bean.getConstructionPermissionSearchSP().setTot_remark_not_allow(null);
		semmcp001Bean.getConstructionPermissionSearchSP().setTot_ref_doc_dt(null);
		semmcp001Bean.getConstructionPermissionSearchSP().setTot_ref_doc_no(null);
		semmcp001Bean.getConstructionPermissionSearchSP().setTot_send_sup_dt(null);
		semmcp001Bean.getConstructionPermissionSearchSP().setTotSubReceiveDt(null);
	}
	
	public void clearValuePanelTOTandCon(String flagChkClear){
		semmcp001Bean = getSemmcp001Bean();
		// TOT
		if(flagChkClear.equals("CLEARALL") || 
				(!StringUtils.isEmpty(getPopupVendorSupplierBean().getPopupVendorSupplierSearchSP().getConstructType())&& getPopupVendorSupplierBean().getPopupVendorSupplierSearchSP().getConstructType().equals("02"))){
			semmcp001Bean.getConstructionPermissionSearchSP().setTot_sup_req_dt(new Date());  //วันที่ Supplier ขอก่อสร้าง
			semmcp001Bean.getConstructionPermissionSearchSP().setTot_send_doc_no(null); //เลขที่เอกสารแจ้ง TOT
			semmcp001Bean.getConstructionPermissionSearchSP().setTot_send_tot_dt(null);  //วันที่แจ้งไปยัง TOT	
			semmcp001Bean.getConstructionPermissionSearchSP().setTot_return_dt(null);  //วันที่ TOT ตอบกลับ
			semmcp001Bean.getConstructionPermissionSearchSP().setTot_result_status(null); //ผลการอนุญาตแจ้งก่อสร้าง  Dropdown List 
			semmcp001Bean.getConstructionPermissionSearchSP().setTot_ref_doc_no(null); //เลขที่หนังสืออ้างอิงจาก TOT
			semmcp001Bean.getConstructionPermissionSearchSP().setTot_remark_not_allow(null); //เหตุผลที่ไม่อนุญาต
			semmcp001Bean.getConstructionPermissionSearchSP().setTot_send_sup_dt(null); //วันที่แจ้ง Supplier
			semmcp001Bean.getConstructionPermissionSearchSP().setTotSubReceiveDt(null);//วันที่ Supplier รับ
		}
		
		//Construction Request
		if(flagChkClear.equals("CLEARALL") || 
				(!StringUtils.isEmpty(getPopupVendorSupplierBean().getPopupVendorSupplierSearchSP().getConstructType()) && getPopupVendorSupplierBean().getPopupVendorSupplierSearchSP().getConstructType().equals("01"))){
			semmcp001Bean.getConstructionPermissionSearchSP().setCon_sup_req_dt(new Date());	//	วันที่ Supplier ขอหนังสือมอบอำนาจ
			semmcp001Bean.getConstructionPermissionSearchSP().setCon_permission_doc_dt(null); //วันที่บันทึกหนังสือมอบอำนาจ
			semmcp001Bean.getConstructionPermissionSearchSP().setCon_permission_doc_no(null); //วันที่ส่งหนังสือมอบอำนาจให้ Supplier
			semmcp001Bean.getConstructionPermissionSearchSP().setCon_send_sup_dt(null); //เลขที่หนังสือมอบอำนาจ
			semmcp001Bean.getConstructionPermissionSearchSP().setCon_result_status(null); //ผลการอนุญาต Dropdown List 
			semmcp001Bean.getConstructionPermissionSearchSP().setCon_build_doc_no(null); //เลขที่หนังสืออนุญาตก่อสร้าง
			semmcp001Bean.getConstructionPermissionSearchSP().setCon_bill_no(null);//เลขที่ใบเสร็จรับเงิน
			semmcp001Bean.getConstructionPermissionSearchSP().setCon_bill_amt(null);// จำนวนเงิน
			semmcp001Bean.getConstructionPermissionSearchSP().setCon_wbs(null);// WBS
			semmcp001Bean.getConstructionPermissionSearchSP().setCon_bill_pay_flag("Y"); // เบิก = Y, ไม่เบิก = N
			semmcp001Bean.getConstructionPermissionSearchSP().setCon_bill_pay_status(null);//สถานะเบิก
			semmcp001Bean.getConstructionPermissionSearchSP().setCon_remark_not_allow(null); //เหตุผลที่ไม่อนุญาต
		}
		
		
		//แจ้งระงับ
		if(flagChkClear.equals("CLEARALL")){
			semmcp001Bean.getConstructionPermissionSearchSP().setReject_dt(null);	//วันที่แจ้งระงับ
			semmcp001Bean.getConstructionPermissionSearchSP().setReject_by(null);		// ผู้แจ้งระงับ
			semmcp001Bean.getConstructionPermissionSearchSP().setReject_remark(null);  // หมายเหตุ		
			semmcp001Bean.getConstructionPermissionSearchSP().setReject_clear_dt(null); // วันที่เคลียการระงับ		
			semmcp001Bean.getConstructionPermissionSearchSP().setReject_clear_remark(null);//หมายเหตุ
		}
		
		if(semmcp001Bean.getConstructionPermissionSearchSP().getSiteConstructStatus().equals("00") || semmcp001Bean.getConstructionPermissionSearchSP().getSiteConstructStatus().equals("02")){
			PopupVendorSupplierBean  popupVendorSupplierBean= new PopupVendorSupplierBean();
		}
		 
		setSemmcp001Bean(semmcp001Bean);
		
	}
	public boolean changeCriteriaConstructStatusListDropdown() {
		boolean flag = false;
		semmcp001Bean = getSemmcp001Bean();
		String constructType = getSemmcp001Bean().getConstructionPermissionForSearch().getConstructTypeCri();
		boolean isAis = "AIS".equals(semmcp001Bean.getConstructionPermissionForSearch().getCompanyCri());
		String company = getSemmcp001Bean().getConstructionPermissionForSearch().getCompanyCri();
		try {
			if (!StringUtils.isEmpty(constructType) || !StringUtils.isEmpty(company)) {

				SEMMCP001Bean semmcp001Bean = getSemmcp001Bean();
				semmcp001Bean.setConstructionPermissionSearchSP(new ConstructionPermissionSearchSP());
				semmcp001Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
				semmcp001Bean.setRegionList(getRegionItems());
				semmcp001Bean.setSiteConstructStatusList(getLovItemsByType(ELovType.T_CP_SITE_CONSTRUCT_STATUS.name)); // สถานะงาน
				semmcp001Bean.setConBillPayStatusList(getLovItemsByType(ELovType.T_CT_PAYMENT_STATUS.name));
//				semmcp001Bean.setConstructTypeList(LOVCacheUtil.getInstance().getCoonstructTypeSelList()); // ประเภทขออนุญาตก่อสร้าง
//				
//				if(!"AIS".equals(company)){
//					semmcp001Bean.getConstructTypeList().remove(1);
//				}
				
//				semmcp001Bean.getConstructionPermissionSearchSP().setCheckDisabled(false);
				if(!isAis){
					semmcp001Bean.setConstructStatusList(LOVCacheUtil.getInstance().getConstructStatusSelList());
				}
				
				if ("01".equals(constructType)) {
					semmcp001Bean.setConstructStatusList(null);
					semmcp001Bean.setConstructStatusList(LOVCacheUtil.getInstance().getConstructTOTStatusSelList());
				} else if ("02".equals(constructType)) {
					semmcp001Bean.setConstructStatusList(null);
					semmcp001Bean.setConstructStatusList(LOVCacheUtil.getInstance().getConstructStatusSelList());
				}else{
					semmcp001Bean.setConstructStatusList(getEmptyDropDown());
				}
				
				semmcp001Bean.getConstructionPermissionForSearch().setCheckDisabled(!checkEnable());
				setSemmcp001Bean(semmcp001Bean);
				flag = true;
			} else {
				init();
				semmcp001Bean.setConstructStatusList(getEmptyDropDown());
				semmcp001Bean.getConstructionPermissionForSearch().setCheckDisabled(!checkEnable());
				flag = true;
			}
		}catch (Exception e) {
			log.error("error in SEMMCP001Action Method changeCriteriaConstructStatusListDropdown : " + e);
		}
		return flag;
	}

	private boolean checkEnable(){
		return "01".equals(getSemmcp001Bean().getConstructionPermissionForSearch().getSiteConstructStatusCri());
	}
	
	public void changeStatus(){
		semmcp001Bean = getSemmcp001Bean();
		semmcp001Bean.getConstructionPermissionForSearch().getConstructTypeCri();
		semmcp001Bean.getConstructionPermissionForSearch().setCheckDisabled(!checkEnable());
		// reset search critiria
		semmcp001Bean.getConstructionPermissionForSearch().setSupplierNameCri(null);
		semmcp001Bean.getConstructionPermissionForSearch().setTotRefDocNoCri(null);
		semmcp001Bean.getConstructionPermissionForSearch().setConBuildDocNoCri(null);
		semmcp001Bean.getConstructionPermissionForSearch().setConstructStatusCri(null);
		semmcp001Bean.getConstructionPermissionForSearch().setConBillPayStatusCri(null);
		semmcp001Bean.getConstructionPermissionForSearch().setConBillNoCri(null);
		semmcp001Bean.getConstructionPermissionForSearch().setConstructTypeCri(null);
		semmcp001Bean.getConstructionPermissionForSearch().setConPermissionDocNoCri(null);
		semmcp001Bean.getConstructionPermissionForSearch().setTotSendDocNoCri(null);
		semmcp001Bean.getConstructionPermissionForSearch().setDocNoCri(null);
		setSemmcp001Bean(semmcp001Bean);
	}
	
	@Override
	public boolean validate() {
		boolean flgValid = true;
		semmcp001Bean = getSemmcp001Bean();
		popupVendorSupplierBean = getPopupVendorSupplierBean();
		String conType = popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getConstructType();
		String constructStatus = getSemmcp001Bean().getConstructionPermissionSearchSP().getSiteConstructStatus();
		if(!StringUtils.isEmpty(constructStatus)){ // ส  tus);
			if(constructStatus.equals("01")){  //ขอก่อสร้าง
					
					//supplier
					 if(StringUtils.isEmpty(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getVendorFullName())){ 
						 addMessageError("W0001", msg("message.vendorFullName"));
			 			 flgValid = false;
					 }
					 
					  //วันที่ส่งเอกสาร
					 if(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getDocDt() == null || popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getDocDt().equals("")){
						 addMessageError("W0001", msg("message.docDt"));
			 			 flgValid = false;
					 }
					 
					 //หน่วยงานราชการที่ขออนุญาติ
					 if(StringUtils.isEmpty(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getVendorFullNameLocal())){
						 addMessageError("W0001", msg("message.vendorFullNameLocal"));
			 			 flgValid = false;
					 }
					 
					 //ประเภทขออนุญาติ
					 if(StringUtils.isEmpty(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getConstructType())){
						 addMessageError("W0001", msg("message.constructType"));
			 			 flgValid = false;
					 }
					 //check require WBS
//					 if(semmcp001Bean.isFlagCheckRequireWBS() == true){
//						 if(StringUtils.isEmpty(getSemmcp001Bean().getConstructionPermissionSearchSP().getCon_wbs())){
//							 addMessageError("W0001", "WBS");
//				 			 flgValid = false;
//						 }
//					 }
					 
					 if(StringUtils.isEmpty(getPopupVendorSupplierBean().getPopupVendorSupplierSearchSP().getPostHeight())){
						 addMessageError("W0001", msg("message.postHeight"));
						 flgValid = false;
					 }
					 
					 if(StringUtils.isEmpty(getPopupVendorSupplierBean().getPopupVendorSupplierSearchSP().getPostType())){
						 addMessageError("W0001", msg("message.postType"));
						 flgValid = false;
					 }
					 log.debug("conType = "+conType);
					 if("02".equals(conType)){// for construct type
						 if(getSemmcp001Bean().getConstructionPermissionSearchSP().getCon_sup_req_dt() == null){
							 addMessageError("W0001", msg("message.con_sup_req_dt"));
							 flgValid = false;
						 }
						 
						 if(getSemmcp001Bean().getConstructionPermissionSearchSP().getCon_permission_doc_dt() == null){
							 addMessageError("W0001", msg("message.con_permission_doc_dt"));
							 flgValid = false;
						 }
						 
						 if("01".equals(getSemmcp001Bean().getConstructionPermissionSearchSP().getCon_result_status())){
							 if(StringUtils.isEmpty(getSemmcp001Bean().getConstructionPermissionSearchSP().getCon_permission_doc_no())){
								 addMessageError("W0001", msg("message.conPermissionDocNo"));
								 flgValid = false;
							 }
							 
//							 if(StringUtils.isEmpty(getSemmcp001Bean().getConstructionPermissionSearchSP().getCon_build_doc_no())){
//								 addMessageError("W0001", msg("message.con_build_doc_no"));
//								 flgValid = false;
//							 }
							 
//							 if(null == getSemmcp001Bean().getConstructionPermissionSearchSP().getCon_build_doc_dt()){
//								 addMessageError("W0001", msg("message.con_build_doc_dt"));
//								 flgValid = false;
//							 }
							 
							 
						 }
						 
						 
						 
						Date reqDt = getSemmcp001Bean().getConstructionPermissionSearchSP().getCon_sup_req_dt();
						Date docDt = getSemmcp001Bean().getConstructionPermissionSearchSP().getCon_permission_doc_dt();
			
						 if(reqDt != null && docDt != null){
							if (reqDt.after(docDt)) {
								addMessageErrorWithArgument("W0006" ,msg("message.con_sup_req_dt"), msg("message.con_permission_doc_dt") );
								flgValid = false;
							}
						}
						 
						Date supDt = getSemmcp001Bean().getConstructionPermissionSearchSP().getCon_send_sup_dt();
						if(supDt != null){
							if (docDt.after(supDt)) {
								addMessageErrorWithArgument("W0006" ,msg("message.con_permission_doc_dt"), msg("message.con_send_sup_dt") );
								flgValid = false;
							}
						}
						
						Date billDt = getSemmcp001Bean().getConstruct().getConBillDt();
						if(supDt != null && billDt != null){
							if (supDt.after(billDt)) {
								addMessageErrorWithArgument("W0006" ,msg("message.con_send_sup_dt"), msg("message.conBillDt") );
								flgValid = false;
							}
						}
						 
						Date conChgDt = getSemmcp001Bean().getConstruct().getConChqDt();
						Date recChgDt = getSemmcp001Bean().getConstruct().getConChqReceiveDt();
						
						 log.debug("conChgDt = "+conChgDt);
						 log.debug("recChgDt = "+recChgDt);
						if(billDt != null && conChgDt != null){
							if (billDt.after(conChgDt)) {
								addMessageErrorWithArgument("W0006" ,msg("message.conBillDt"), msg("export.col.chqDt") );
								flgValid = false;
							}
						}
						 
						if(conChgDt != null){
							if(new Date().after(conChgDt)){
								addMessageErrorWithArgument("W0006" ,msg("message.currentDate"), msg("export.col.chqDt") );
								flgValid = false;
							}
						}
						
						if(conChgDt != null && recChgDt != null){
							if (conChgDt.after(recChgDt)) {
								addMessageErrorWithArgument("W0006" ,msg("export.col.chqDt"), msg("export.col.chqReceiveDt") );
								flgValid = false;
							}
						}
						
						if(recChgDt != null){
							if(new Date().after(recChgDt)){
								addMessageErrorWithArgument("W0006" ,msg("message.currentDate"), msg("export.col.chqReceiveDt") );
								flgValid = false;
							}
						}
					}else{
						 if("01".equals(conType)){  // for send to tot
							 if(getSemmcp001Bean().getConstructionPermissionSearchSP().getTot_sup_req_dt() == null){
								 addMessageError("W0001", msg("message.tot_sup_req_dt"));
								 flgValid = false;
							 }
							 
							if("01".equals(getSemmcp001Bean().getConstructionPermissionSearchSP().getTot_result_status())){
								 if(StringUtils.isEmpty(getSemmcp001Bean().getConstructionPermissionSearchSP().getTot_send_doc_no())){
									 addMessageError("W0001", msg("message.tot_send_doc_no"));
									 flgValid = false;
								 }
								 if(StringUtils.isEmpty(getSemmcp001Bean().getConstructionPermissionSearchSP().getTot_ref_doc_no())){
									 addMessageError("W0001", msg("message.tot_ref_doc_no"));
									 flgValid = false;
								 }
								 if(null == getSemmcp001Bean().getConstructionPermissionSearchSP().getTot_ref_doc_dt()){
									 addMessageError("W0001", msg("message.tot_ref_doc_dt"));
									 flgValid = false;
								 }
								 
							 }
							 
							 Date reqDt = getSemmcp001Bean().getConstructionPermissionSearchSP().getTot_sup_req_dt();
							 Date sendDt = getSemmcp001Bean().getConstructionPermissionSearchSP().getTot_send_tot_dt();
					
							 if(reqDt != null && sendDt != null){
								if (reqDt.after(sendDt)) {
									addMessageErrorWithArgument("W0006" ,msg("message.tot_sup_req_dt"), msg("message.tot_send_tot_dt") );
									flgValid = false;
								}
							 }
							 
							 Date returnDt = getSemmcp001Bean().getConstructionPermissionSearchSP().getTot_return_dt();
							 if(sendDt != null && returnDt != null){
									if (sendDt.after(returnDt)) {
										addMessageErrorWithArgument("W0006" ,msg("message.tot_send_tot_dt"), msg("message.tot_return_dt") );
										flgValid = false;
									}
							 }
							 
							 Date supDt = getSemmcp001Bean().getConstructionPermissionSearchSP().getTot_send_sup_dt();
							 if(returnDt != null && supDt != null){
									if (returnDt.after(supDt)) {
										addMessageErrorWithArgument("W0006" ,msg("message.tot_return_dt"), msg("message.con_send_sup_dt") );
										flgValid = false;
									}
							 }
							 
							 Date subDt = getSemmcp001Bean().getConstructionPermissionSearchSP().getTotSubReceiveDt();
							 if(supDt != null && subDt != null){
									if (supDt.after(subDt)) {
										addMessageErrorWithArgument("W0006" ,msg("message.con_send_sup_dt"), msg("message.totSubReceiveDt") );
										flgValid = false;
									}
							 }
							 
						 }
					}
					
					
//					 if(semmcp001Bean.getConstruct().getConChqDt() == null && getSemmcp001Bean().isRenderCldChqDt() == false){
//							addMessageError(("W0001"), msg("message.chqDt"));
//							flgValid = false;
//						}
//						if(semmcp001Bean.getConstruct().getConChqReceiveDt() == null && getSemmcp001Bean().isRenderCldChqDt() == false){
//							addMessageError(("W0001"), msg("message.chqReceiveDt"));
//							flgValid = false;
//						}
//						if(semmcp001Bean.getConstruct().getConTransferDt() == null && getSemmcp001Bean().isRenderCldTransferDt() == false){
//							addMessageError(("W0001"), msg("message.transferDt"));
//							flgValid = false;
//						}
					 
			}else{
				if(constructStatus.equals("02")){ // tot
					 if(StringUtils.isEmpty(getSemmcp001Bean().getConstructionPermissionSearchSP().getRemarkNoRequest())){
						 addMessageError("W0001", msg("message.remarkNoRequest"));
						 flgValid = false;
					 }
				 }
				return flgValid;
			}
			
		}else{
				 addMessageError("W0001", msg("message.siteConstructStatus"));
	 			 flgValid = false;
		}
		
		return flgValid;
	}
	
	
	
	private PopupVendorSupplierBean popupVendorSupplierBean;
	
	public PopupVendorSupplierBean getPopupVendorSupplierBean() {
		return (PopupVendorSupplierBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupVendorSupplierBean");
	}
	public void setPopupVendorSupplierBean(PopupVendorSupplierBean popupVendorSupplierBean) {
		this.popupVendorSupplierBean = popupVendorSupplierBean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupVendorSupplierBean",popupVendorSupplierBean);
	}
	
	private SEMMCP001Bean semmcp001Bean;

	public void setSemmcp001Bean(SEMMCP001Bean semmcp001Bean) {
		this.semmcp001Bean = semmcp001Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.put("semmcp001Bean", semmcp001Bean);
	}

	public SEMMCP001Bean getSemmcp001Bean() {
		return (SEMMCP001Bean) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("semmcp001Bean");
	}
	
	private boolean doUpdate(boolean validateFlag) {
		boolean flag = false;
		semmcp001Bean = getSemmcp001Bean();
		
		String migrateFlag = semmcp001Bean.getConstructionPermissionSearchSP().getMigrateFlag();
		String createBy = semmcp001Bean.getConstructionPermissionSearchSP().getCreate_by();
		log.debug("validateFlag = "+validateFlag);
		if(validateFlag){
			if(!StringUtils.equals("Y", migrateFlag) || !StringUtils.equals("MIGRATE", createBy)){
				if(!validate()){
					tmpFlagValidate = "N";
					return flag;
				}
			}
		}
		
		tmpFlagValidate = "Y";	
		popupVendorSupplierBean = getPopupVendorSupplierBean();
		clearHiddenFieldData();
		ISiteConstructService constructService = (ISiteConstructService)getBean("siteConstructService");
		
		ISendRenewService sendRenewService = (ISendRenewService) getBean("sendRenewService");
		Construct tmpCon = semmcp001Bean.getConstruct();
		Construct to = new Construct();
		List<ConstructionPermissionGenDocNoSearchSP> constructPerDocGen  = null;
		String messageCode = "M0001";
		String siteConStruct = semmcp001Bean.getConstructionPermissionSearchSP().getSiteConstructStatus();
		clearValuePanelTOTandCon("");
		try{
			if(!StringUtils.isEmpty(semmcp001Bean.getConstructionPermissionSearchSP().getSiteContructId())){
				to =constructService.querySiteConstructByRowId(semmcp001Bean.getConstructionPermissionSearchSP().getSiteContructId());
				
				if(to != null){
					if(!siteConStruct.isEmpty() && siteConStruct.equals("01") ){
						constructPerDocGen = sendRenewService.querySPList(EQueryName.SP_MCP001_GEN_DOC_NO.name, semmcp001Bean.getConstructionPermissionSearchSP());
						to.setDocNo(constructPerDocGen.get(0).getGenDocNo() !=null? constructPerDocGen.get(0).getGenDocNo():"");
						popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setDocNo(constructPerDocGen.get(0).getGenDocNo());
					}else{
						popupVendorSupplierBean.setPopupVendorSupplierSearchSP(new PopupVendorSupplierSearchSP());
						to.setDocNo("");
					}
					
					if(!semmcp001Bean.isDisablePnlConRemarkNotAllow()){
						semmcp001Bean.getConstructionPermissionSearchSP().setCon_remark_not_allow(null);
					}else{
						semmcp001Bean.getConstructionPermissionSearchSP().setTot_remark_not_allow(null);
					}
					
					semmcp001Bean.getConstructionPermissionSearchSP().setCreate_by(to.getCreateBy());
					semmcp001Bean.getConstructionPermissionSearchSP().setCreate_dt(to.getCreateDt());
					
//					to.setSiteInfoId(siteInfoId);
					to.setSiteConstructStatus(semmcp001Bean.getConstructionPermissionSearchSP().getSiteConstructStatus());
					
					
//					to.setDocNo(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getDocNo());
					to.setProjectName(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getProject());
					to.setDocDt(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getDocDt());
					to.setSupplierId(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getVendorMasterId()); //Check sup
					to.setSupplierName(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getVendorFullName()); //Check sup 
					to.setContactName(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getContactName());
					to.setContactTel(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getTelephone());
					to.setContactFax(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getFax());
					to.setContactEmail(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getEmail());
					to.setDetail(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getDetail());
					to.setPostType(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getPostType());
					to.setPostHeight(Double.valueOf(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getPostHeight() != null && !popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getPostHeight().equals("") && !popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getPostHeight().equals("null") ? popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getPostHeight() : "0"));
					
					to.setRemark(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getOther());
					to.setConstructType(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getConstructType());
					to.setConstructStatus(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getConstructStatus());
					
					String constructType = getPopupVendorSupplierBean().getPopupVendorSupplierSearchSP().getConstructType();
					
					//TOT
					if(StringUtils.equals(constructType, "01")){
						semmcp001Bean.getConstructionPermissionSearchSP().setVendorFullName("");
						semmcp001Bean.getConstructionPermissionSearchSP().setFax("");
						semmcp001Bean.getConstructionPermissionSearchSP().setTelephone("");
						to.setTotSupReqDt(semmcp001Bean.getConstructionPermissionSearchSP().getTot_sup_req_dt());
						to.setTotSendDocNo(semmcp001Bean.getConstructionPermissionSearchSP().getTot_send_doc_no());
						to.setTotSendSupDt(semmcp001Bean.getConstructionPermissionSearchSP().getTot_send_sup_dt());
						to.setTotReturnDt(semmcp001Bean.getConstructionPermissionSearchSP().getTot_return_dt());
						to.setTotResultStatus(semmcp001Bean.getConstructionPermissionSearchSP().getTot_result_status());
						to.setTotRefDocNo(semmcp001Bean.getConstructionPermissionSearchSP().getTot_ref_doc_no());
						to.setTotRemarkNotAllow(semmcp001Bean.getConstructionPermissionSearchSP().getTot_remark_not_allow());
						to.setTotSendSupDt(semmcp001Bean.getConstructionPermissionSearchSP().getTot_send_sup_dt());
						to.setTotSupReceiveDt(semmcp001Bean.getConstructionPermissionSearchSP().getTotSubReceiveDt());
						to.setTotSendTotDt(semmcp001Bean.getConstructionPermissionSearchSP().getTot_send_tot_dt());
						//Clear Construction
						to.setConSupReqDt(null);
						to.setConPermissionDocDt(null);
						to.setConPermissionDocNo(null);
						to.setConSendSupDt(null);
						to.setConSupReturnDt(null);
						to.setConResultStatus(null);
						to.setConBuildDocNo(null);
					}
					// Construct
					if(StringUtils.equals(constructType, "02")){
						to.setConSupReqDt(semmcp001Bean.getConstructionPermissionSearchSP().getCon_sup_req_dt());
						to.setConPermissionDocDt(semmcp001Bean.getConstructionPermissionSearchSP().getCon_permission_doc_dt());
						to.setConPermissionDocNo(semmcp001Bean.getConstructionPermissionSearchSP().getCon_permission_doc_no());
						to.setConSendSupDt(semmcp001Bean.getConstructionPermissionSearchSP().getCon_send_sup_dt());
						to.setConSupReturnDt(semmcp001Bean.getConstructionPermissionSearchSP().getCon_sup_req_dt());
						to.setConResultStatus(semmcp001Bean.getConstructionPermissionSearchSP().getCon_result_status());
						to.setConBuildDocNo(semmcp001Bean.getConstructionPermissionSearchSP().getCon_build_doc_no());
						//Clear Tot
						to.setTotSupReqDt(null);
						to.setTotSendDocNo(null);
						to.setTotSendSupDt(null);
						to.setTotReturnDt(null);
						to.setTotResultStatus(null);
						to.setTotRefDocNo(null);
						to.setTotRemarkNotAllow(null);
						to.setTotSendSupDt(null);
						to.setTotSupReceiveDt(null);
						to.setTotSendTotDt(null);
					}
					
					
					if(StringUtils.equals(constructType, "01")){
						to.setTotRefDocDate(semmcp001Bean.getConstructionPermissionSearchSP().getTot_ref_doc_dt());
						to.setTotRefDocNo(semmcp001Bean.getConstructionPermissionSearchSP().getTot_ref_doc_no());
						to.setConBuildDocDate(null);
						to.setConBuildDocNo("");
					}
					
					if(StringUtils.equals(constructType, "02")){
						to.setTotRefDocDate(null);
						to.setTotRefDocNo("");
						to.setConBuildDocDate(semmcp001Bean.getConstructionPermissionSearchSP().getCon_build_doc_dt());
						to.setConBuildDocNo(semmcp001Bean.getConstructionPermissionSearchSP().getCon_build_doc_no());
					}
					
//					if(!"01".equals(semmcp001Bean.getConstructionPermissionSearchSP().getSiteConstructStatus())){
						to.setConBillNo(semmcp001Bean.getConstruct().getConBillNo());
						to.setConBillDt(semmcp001Bean.getConstruct().getConBillDt());
						to.setConBillAmt(semmcp001Bean.getConstruct().getConBillAmt());
//						to.setConWbs(semmcp001Bean.getConstructionPermissionSearchSP().getCon_wbs());
//					}else{
//						to.setConBillNo(null);
//						to.setConBillDt(null);
//						to.setConBillAmt(null);
//						to.setConWbs(null);
//					}
				
					to.setConBillPayFlag(semmcp001Bean.getConstructionPermissionSearchSP().getCon_bill_pay_flag());
					to.setConBillPayStatus(semmcp001Bean.getConstructionPermissionSearchSP().getCon_bill_pay_status());
					to.setConRemarkNotAllow(semmcp001Bean.getConstructionPermissionSearchSP().getCon_remark_not_allow());
					
					to.setRejectDt(semmcp001Bean.getConstructionPermissionSearchSP().getReject_dt());
					to.setRejectBy(semmcp001Bean.getConstructionPermissionSearchSP().getReject_by());
					to.setRejectRemark(semmcp001Bean.getConstructionPermissionSearchSP().getReject_remark());
					to.setRejectClearDt(semmcp001Bean.getConstructionPermissionSearchSP().getReject_clear_dt());
					to.setRejectClearRemark(semmcp001Bean.getConstructionPermissionSearchSP().getReject_clear_remark());
					
//					to.setRecordStatus("Y");

					to.setLocalName(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getVendorFullNameLocal());
					to.setLocalHouseNo(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getAddress1());
					to.setLocalTambon(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getAddress2());
//					to.setLocalAmphur(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getAmphur());
					to.setLocalProvince(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getCity());
//					to.setLocalPostcode(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getPostCode());
					
					//panel Detail
					to.setConVatType(tmpCon.getConVatType());
					to.setConWhtType(tmpCon.getConWhtType());
					to.setConWhtRate(tmpCon.getConWhtRate());
					to.setConExcAmt(tmpCon.getConExcAmt());
					to.setConVatAmt(tmpCon.getConVatAmt());
					to.setConIncAmt(tmpCon.getConIncAmt());
					to.setConWhtAmt(tmpCon.getConWhtAmt());
					to.setConPaymentType(tmpCon.getConPaymentType());
					
//					if(!"01".equals(semmcp001Bean.getConstructionPermissionSearchSP().getSiteConstructStatus())){
						to.setConPaymentMethod(tmpCon.getConPaymentMethod());
						to.setConChqDt(tmpCon.getConChqDt()); // is chq every time.
						to.setConChqReceiveDt(tmpCon.getConChqReceiveDt());
						to.setConTransferDt(tmpCon.getConTransferDt());
						to.setConPayRemark(tmpCon.getConPayRemark());
						to.setConPaymentStatus(tmpCon.getConPaymentStatus());
//					}else{
//						to.setConPaymentMethod(null);
//						to.setConChqDt(null);
//						to.setConChqReceiveDt(null);
//						to.setConTransferDt(null);
//						to.setConPayRemark(null);
//						to.setConPaymentStatus(null);
//					}
//					to.setUpdateBy(semmcp001Bean.getUserLogin());
					
					//set createby and updateby
					if(StringUtils.isEmpty(to.getCreateBy())){
						to.setCreateBy(semmcp001Bean.getUserLogin());
						to.setCreateDt(new Date());
					}else{
						to.setUpdateBy(semmcp001Bean.getUserLogin());
						to.setUpdateDt(new Date());
						semmcp001Bean.getConstructionPermissionSearchSP().setUpdate_by(semmcp001Bean.getUserLogin());
						semmcp001Bean.getConstructionPermissionSearchSP().setUpdate_dt(to.getUpdateDt());
					}
					
					
					//query for displaying new Con Payement Status.
					semmcp001Bean.setConstruct(constructService.updateConstructWithOutUser(to));
					
					semmcp001Bean.setRenderedMsgFormTop(true);
					semmcp001Bean.setRenderedMsgFormMiddle(false);
					
					semmcp001Bean.setRenderedMsgFormTop(true);
					semmcp001Bean.setRenderedMsgFormMiddle(false);
					setPopupVendorSupplierBean(popupVendorSupplierBean);
					setSemmcp001Bean(semmcp001Bean);
					if(tmpFlagMsgSave.equals("Y")){
						addMessageInfo(messageCode);
					}
					//String constructType = getPopupVendorSupplierBean().getPopupVendorSupplierSearchSP().getConstructType();
					//hide print button after construct result not null
					if(!StringUtils.isEmpty(semmcp001Bean.getConstructionPermissionSearchSP().getTot_result_status()) || !StringUtils.isEmpty(semmcp001Bean.getConstructionPermissionSearchSP().getCon_result_status())){
						semmcp001Bean.setDisableBtnTot(false);
						semmcp001Bean.setDisableBtnConstructStatus(false);
					}else{
						if ("01".equals(constructType)) {
							semmcp001Bean.setDisableBtnTot(false);
							semmcp001Bean.setDisableBtnConstructStatus(true);
						}else{
							if("02".equals(constructType)){
								semmcp001Bean.setDisableBtnTot(true);
								semmcp001Bean.setDisableBtnConstructStatus(false);
							}
						}
					}
				}
			}
			
			// ReSearch all data again.
			/**********************************/
			semmcp001Bean.setConToken(new ConstructionPermissionSearchSP());
			semmcp001Bean.getConToken().setSiteInfoId(semmcp001Bean.getConstructionPermissionSearchSP().getSiteInfoId());
			semmcp001Bean.getConToken().setSiteContructId(semmcp001Bean.getConstructionPermissionSearchSP().getSiteContructId());
			semmcp001Bean.getConToken().setSiteName(semmcp001Bean.getConstructionPermissionSearchSP().getSiteName());
			semmcp001Bean.getConToken().setContractNo(semmcp001Bean.getConstructionPermissionSearchSP().getContractNo());
			doShow();
			semmcp001Bean.setConToken(null);
			/**********************************/
			
		}catch (Exception e) {
			log.error(e);
			messageCode = "E0001";
			addMessageError(messageCode);
		}
		return flag;
	}
	
	public boolean doSearchSiteContructId(String siteContructId) {
		boolean flag = true;
		Construct construct = new Construct();
		ISiteConstructService constructService = (ISiteConstructService)getBean("siteConstructService");
		IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
		SEMMCP001Bean semmcp001Bean = getSemmcp001Bean();
		PopupVendorSupplierBean	popupVendorSupplierBean = getPopupVendorSupplierBean();
		if(!StringUtils.isEmpty(siteContructId)){
			try {
				construct = constructService.querySiteConstructByRowId(siteContructId);
				
				/*Set CreateBy */
				semmcp001Bean.getConstructionPermissionSearchSP().setCreate_by(construct.getCreateBy());
				semmcp001Bean.getConstructionPermissionSearchSP().setCreate_dt(construct.getCreateDt());
				
				construct.setConPaymentType("01");
				if(construct != null){
					//added by NEW
					semmcp001Bean.getConstructionPermissionTransferSP().setRecordStatus(construct.getRecordStatus());
					
					if(construct.getSiteConstructStatus() != null && !construct.getSiteConstructStatus().equals("")){
						if(construct.getSiteConstructStatus().equals("01")){
						  
							/// Start set value 
						  semmcp001Bean.getConstructionPermissionSearchSP().setCheckExpandPanel(true); 
						  semmcp001Bean.getConstructionPermissionSearchSP().setSiteConstructStatus(construct.getSiteConstructStatus());
						  popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setDocNo(construct.getDocNo());
						  popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setDocDt(construct.getDocDt());
						  popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setProject(construct.getProjectName());
						  
						  if(construct.getSupplierId() != null){
							  VendorMaster vendorMaster = service.queryVendorMasterByRowId(construct.getSupplierId());
							  if(vendorMaster != null){
								  popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setVendorFullName(vendorMaster.getVendorName() != null ? vendorMaster.getVendorName() : "");// select befor  
							  }
						  }
						  
						  popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setContactName(construct.getContactName());
						  popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setTelephone(construct.getContactTel());
						  popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setFax(construct.getContactFax());
						  popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setEmail(construct.getContactEmail());
						  popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setDetail(construct.getDetail());
						  popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setPostType(construct.getPostType());
						  popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setPostHeight(construct.getPostHeight() != null ? String.valueOf(construct.getPostHeight()) : "");
						  popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setOther(construct.getRemark());
						  popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setVendorMasterId(construct.getSupplierId());
						  popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setVendorFullNameLocal(construct.getLocalName()); // 	vendorFullNameLocal
						  popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setVendorFullName(construct.getSupplierName()); // 	vendorFullName
						  popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setAddress1(construct.getLocalHouseNo());
						  popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setAddress2(construct.getLocalTambon());
						  popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setAmphur(construct.getLocalAmphur());
						  popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setCity(construct.getLocalProvince());
						  popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setPostCode(construct.getLocalPostcode());
						  popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructType(construct.getConstructType());
						  popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus(construct.getConstructStatus());
						  // End Set value panel 1
						  
						  if(construct.getConstructType() != null && !construct.getConstructType().equals("")){
							  popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructType(construct.getConstructType());
							  if(construct.getConstructType().equals("01")){
								  
								  semmcp001Bean.getConstructionPermissionSearchSP().setCheckExpandPanelTOT(true);
								  semmcp001Bean.getConstructionPermissionSearchSP().setCheckExpandPanelNoticeReject(true);
								  semmcp001Bean.getConstructionPermissionSearchSP().setCheckExpandPanelCon(false);
								  
								  semmcp001Bean.getConstructionPermissionSearchSP().setTot_sup_req_dt(construct.getTotSupReqDt());
								  semmcp001Bean.getConstructionPermissionSearchSP().setTot_send_doc_no(construct.getTotSendDocNo());
								  semmcp001Bean.getConstructionPermissionSearchSP().setTot_send_tot_dt(construct.getTotSendTotDt());
								  semmcp001Bean.getConstructionPermissionSearchSP().setTot_return_dt(construct.getTotReturnDt());
								  semmcp001Bean.getConstructionPermissionSearchSP().setTot_result_status(construct.getTotResultStatus());
								  semmcp001Bean.getConstructionPermissionSearchSP().setTot_ref_doc_no(construct.getTotRefDocNo());
								  semmcp001Bean.getConstructionPermissionSearchSP().setTot_remark_not_allow(construct.getTotRemarkNotAllow());
								  semmcp001Bean.getConstructionPermissionSearchSP().setTot_send_sup_dt(construct.getTotSendSupDt());
								  semmcp001Bean.getConstructionPermissionSearchSP().setTotSubReceiveDt(construct.getTotSupReceiveDt());
								  semmcp001Bean.getConstructionPermissionSearchSP().setTot_ref_doc_dt(construct.getTotRefDocDate());
								  semmcp001Bean.getConstructionPermissionSearchSP().setTot_ref_doc_no(construct.getTotRefDocNo());
							  }else if(construct.getConstructType().equals("02")){
								  
								  semmcp001Bean.getConstructionPermissionSearchSP().setCheckExpandPanelCon(true);
								  semmcp001Bean.getConstructionPermissionSearchSP().setCheckExpandPanelNoticeReject(true);
								  semmcp001Bean.getConstructionPermissionSearchSP().setCheckExpandPanelTOT(false);
								  
								  semmcp001Bean.getConstructionPermissionSearchSP().setCon_sup_req_dt(construct.getConSupReqDt());
								  semmcp001Bean.getConstructionPermissionSearchSP().setCon_permission_doc_dt(construct.getConPermissionDocDt());
								  semmcp001Bean.getConstructionPermissionSearchSP().setCon_permission_doc_no(construct.getConPermissionDocNo());
								  semmcp001Bean.getConstructionPermissionSearchSP().setCon_send_sup_dt(construct.getConSendSupDt());
								  semmcp001Bean.getConstructionPermissionSearchSP().setCon_result_status(construct.getConResultStatus());
								  semmcp001Bean.getConstructionPermissionSearchSP().setCon_build_doc_no(construct.getConBuildDocNo());
								  semmcp001Bean.getConstructionPermissionSearchSP().setCon_bill_amt(construct.getConBillAmt() != null ? String.valueOf(construct.getConBillAmt()) : "");
								  semmcp001Bean.getConstructionPermissionSearchSP().setCon_wbs(construct.getConWbs());
								  semmcp001Bean.getConstructionPermissionSearchSP().setCon_bill_pay_flag(construct.getConBillPayFlag());
								  semmcp001Bean.getConstructionPermissionSearchSP().setCon_bill_pay_status(construct.getConBillPayStatus());
								  semmcp001Bean.getConstructionPermissionSearchSP().setCon_remark_not_allow(construct.getConRemarkNotAllow());
								  semmcp001Bean.getConstructionPermissionSearchSP().setCon_bill_dt(construct.getConBillDt());
								  semmcp001Bean.getConstructionPermissionSearchSP().setCon_build_doc_dt(construct.getConBuildDocDate());
								  semmcp001Bean.getConstructionPermissionSearchSP().setCon_build_doc_no(construct.getConBuildDocNo());
							  }
							  
							  //Reject panel 
							  semmcp001Bean.getConstructionPermissionSearchSP().setReject_dt(construct.getRejectDt());
							  semmcp001Bean.getConstructionPermissionSearchSP().setReject_by(construct.getRejectBy());
							  semmcp001Bean.getConstructionPermissionSearchSP().setReject_remark(construct.getRejectRemark());
							  semmcp001Bean.getConstructionPermissionSearchSP().setReject_clear_dt(construct.getRejectClearDt());
							  semmcp001Bean.getConstructionPermissionSearchSP().setReject_clear_remark(construct.getRejectClearRemark());
							  
						  }
						}else{
							semmcp001Bean.getConstructionPermissionSearchSP().setCheckExpandPanelCon(false);
							semmcp001Bean.getConstructionPermissionSearchSP().setCheckExpandPanelTOT(false);
							semmcp001Bean.getConstructionPermissionSearchSP().setCheckExpandPanel(false);
							semmcp001Bean.getConstructionPermissionSearchSP().setCheckExpandPanelNoticeReject(false);
							semmcp001Bean.getConstructionPermissionSearchSP().setSiteConstructStatus(construct.getSiteConstructStatus());
						}
					}else{
						semmcp001Bean.getConstructionPermissionSearchSP().setCheckExpandPanel(false);
						semmcp001Bean.getConstructionPermissionSearchSP().setCheckExpandPanelCon(false);
						semmcp001Bean.getConstructionPermissionSearchSP().setCheckExpandPanelTOT(false);
						semmcp001Bean.getConstructionPermissionSearchSP().setCheckExpandPanelNoticeReject(false);
						semmcp001Bean.getConstructionPermissionSearchSP().setSiteConstructStatus("00");
					}
				}else{
					System.out.println(" construct is null ");
					
				}
				setPopupVendorSupplierBean(popupVendorSupplierBean);
				setSemmcp001Bean(semmcp001Bean);
				
			} catch (Exception e) {
				log.error(e);
				e.printStackTrace();
			}
		}
		
		return flag;
	}
	
	public boolean doShow() {
		boolean flag = true;
		
		semmcp001Bean = getSemmcp001Bean();
		PopupVendorSupplierBean	popupVendorSupplierBean = getPopupVendorSupplierBean();
		String mode;
		if(semmcp001Bean.getConToken() == null){
			siteInfoId = (String) getFacesUtils().getRequestParameter("siteInfoIdParam");
			siteContructId = (String) getFacesUtils().getRequestParameter("siteContructIdParam");
			siteName = (String) getFacesUtils().getRequestParameter("siteNameParam");
			siteContractNo = (String)getFacesUtils().getRequestParameter("siteContractNoParam");
			migrateFlag = (String)getFacesUtils().getRequestParameter("migrateFlag");
			mode = (String)getFacesUtils().getRequestParameter("mode");
		}else{
			siteInfoId = semmcp001Bean.getConToken().getSiteInfoId();
			siteContructId = semmcp001Bean.getConToken().getSiteContructId();
			siteName = semmcp001Bean.getConToken().getSiteName();
			siteContractNo = semmcp001Bean.getConToken().getContractNo();
			migrateFlag = semmcp001Bean.getConToken().getMigrateFlag();
			mode = semmcp001Bean.isViewMode()?"VIEW":"EDIT";
		}
		ISiteConstructService constructService = (ISiteConstructService)getBean("siteConstructService");
		
		String terminateFlag = (String) getFacesUtils().getRequestParameter("terminateFlag");
		String  contractId  = (String) getFacesUtils().getRequestParameter("contractIdParam");
		
		// for search data from table sem_si_site_construct
		doSearchSiteContructId(siteContructId);
		
		if("VIEW".equals(mode)){
			semmcp001Bean.setViewMode(true);
		}else{
			semmcp001Bean.setViewMode(false);
		}
		
		semmcp001Bean.getConstructionPermissionSearchSP().setSiteInfoId(siteInfoId);
		semmcp001Bean.getConstructionPermissionSearchSP().setSiteContructId(siteContructId);
		semmcp001Bean.getConstructionPermissionSearchSP().setContractId(contractId);
		semmcp001Bean.getConstructionPermissionSearchSP().setTerminateFlag(terminateFlag);
		semmcp001Bean.getConstructionPermissionSearchSP().setSiteName(siteName);
		semmcp001Bean.getConstructionPermissionSearchSP().setContractNo(siteContractNo);
		semmcp001Bean.getConstructionPermissionSearchSP().setMigrateFlag(migrateFlag);
		
		//added by NEW
		semmcp001Bean.getConstructionPermissionTransferSP().setSiteInfoId(siteInfoId);
		semmcp001Bean.getConstructionPermissionTransferSP().setSiteContructId(siteContructId);
		semmcp001Bean.getConstructionPermissionTransferSP().setContractId(contractId);
		semmcp001Bean.getConstructionPermissionTransferSP().setTerminateFlag(terminateFlag);
		semmcp001Bean.getConstructionPermissionTransferSP().setSiteName(siteName);
		semmcp001Bean.getConstructionPermissionTransferSP().setContractNo(siteContractNo);
		semmcp001Bean.getConstructionPermissionTransferSP().setMigrateFlag(migrateFlag);
		
		semmcp001Bean.getSiteInfoData().setRowId(siteInfoId);
		semmcp001Bean.getSiteInfoData().setContractNo(siteContractNo);
		
		if(StringUtils.equalsIgnoreCase("Y", terminateFlag)){
			semmcp001Bean.setSiteConstructStatusList(semmcp001Bean.getSiteConstructStatusTmpList());
		}else{
			List<SelectItem> selectList = new ArrayList<SelectItem>();
//			if(StringUtils.equalsIgnoreCase("00", semmcp001Bean.getConstructionPermissionSearchSP().getSiteConstructStatus())){
				for(SelectItem select : semmcp001Bean.getSiteConstructStatusTmpList()){
					if(!StringUtils.equalsIgnoreCase("03", select.getValue().toString()) ){
						selectList.add(select);
					}
				}
				semmcp001Bean.setSiteConstructStatusList(selectList);
//			}else{
//				semmcp001Bean.setSiteConstructStatusList(semmcp001Bean.getSiteConstructStatusTmpList());
//			}
			
		}
		
		if("02".equals(semmcp001Bean.getConstructionPermissionSearchSP().getCon_result_status())){
			semmcp001Bean.setDisablePnlConRemarkNotAllow(true);
			semmcp001Bean.setRenderConstruct(false);
		}else{
			semmcp001Bean.setRenderConstruct(true);
		}
		if("02".equals(semmcp001Bean.getConstructionPermissionSearchSP().getTot_result_status())){
			semmcp001Bean.setDisablePnlRemarkNotAllow(true);
			}
		
		for(ConstructionPermissionSearchSP cp : semmcp001Bean.getConstructionPermissionSearchSPList()){
			if(cp.getRowId().equals(semmcp001Bean.getConstructionPermissionSearchSP().getSiteContructId())){
				semmcp001Bean.getConstructionPermissionSearchSP().setCompanyCri(cp.getCompanyCri()) ;
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setProvinceCri(cp.getSiteProvinceId());
				semmcp001Bean.getConstructionPermissionSearchSP().setTokenProvince(cp.getSiteProvinceId());
				break;
			}
		}
		
		if("01".equals(semmcp001Bean.getConstructionPermissionSearchSP().getSiteConstructStatus())){
			semmcp001Bean.setNonCostruct(true);
			semmcp001Bean.setRenderRemark(false);
		}else{
			if("02".equals(semmcp001Bean.getConstructionPermissionSearchSP().getSiteConstructStatus())){
				semmcp001Bean.setNonCostruct(false);
			}else{
				semmcp001Bean.setNonCostruct(true);
			}
			semmcp001Bean.setRenderRemark(true);
			// hide print btn
			semmcp001Bean.setDisableBtnTot(false);
			semmcp001Bean.setDisableBtnConstructStatus(false);
		}
		checkResultChange();
		
		ISendRenewService sendRenewService = (ISendRenewService) getBean("sendRenewService");
		List<ConstructionPermissionLocationSearchSP> to = null;
		List<Mcp001ChkPayable>to2 = null;
		semmcp001Bean.getMcp001ChkPayable().setRowId(siteContructId);
		try {
			
			to = sendRenewService.querySPList(EQueryName.Q_SEARCH_CONSTRUCTION_LOCATION.name, semmcp001Bean.getConstructionPermissionSearchSP());
			to2 = sendRenewService.querySPList(EQueryName.SP_MCP001_Check_Payable.name, semmcp001Bean.getMcp001ChkPayable());
			 if (null == to || to.isEmpty()) {
				// set error message after search not found
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("M0004"), ""));
			 }
			 
			 if(to2.get(0).getPayAbleFlag().equals("Y")){
				 semmcp001Bean.setDisabelBtnSavePay(false);
				 semmcp001Bean.setDisablePnlShowDetailConstruct(false);
			 }else{
				 semmcp001Bean.setDisabelBtnSavePay(true);
				 semmcp001Bean.setDisablePnlShowDetailConstruct(true);
			 }
			 
			 if(to2.get(0).getCancleAbleFlag().equals("Y")){
				 semmcp001Bean.setDisableBtnCanclePay(false);
			 }else{
				 semmcp001Bean.setDisableBtnCanclePay(true);
			 }
			semmcp001Bean.getConstructionPermissionSearchSP().setCon_permission_doc_no(to.get(0).getLocationId()); 
			semmcp001Bean.setConstructionPermissionLocationSearchSPList(to);
			semmcp001Bean.setMcp001ChkPayable(to2.get(0));
			semmcp001Bean.setConfirmDeleteMsg(MSGCacheUtil.getInstance().getMessageByCode("Q0002"));
			semmcp001Bean.setTmpConstructType(true);
			popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setDocDt(new Date());
			
			semmcp001Bean.setConstruct(constructService.querySiteConstructByRowId(semmcp001Bean.getConstructionPermissionSearchSP().getSiteContructId()));
			if(semmcp001Bean.getConstruct().getConPaymentType() == null){
				semmcp001Bean.getConstruct().setConPaymentType("03");
			}
			semmcp001Bean.setMpt004Cal(new Mpt004Cal());
			semmcp001Bean.getConstruct().setConVatType("03");
			semmcp001Bean.getConstruct().setConWhtType("03");
			semmcp001Bean.setRenderedMsgFormTop(true);
			semmcp001Bean.setRenderedMsgFormMiddle(false);
			semmcp001Bean.getConstruct().setConPaymentType("01");
			semmcp001Bean.setConTmp(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getConstructType());
			
			//set supplierid
			popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setVendorMasterId(getSemmcp001Bean().getConstruct().getSupplierId());
			popupVendorSupplierBean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList() == null ? getEmptyDropDown():ProvinceCacheUtil.getInstance().getProvinceSelList());
			setPopupVendorSupplierBean(popupVendorSupplierBean);
			
			if(!StringUtils.isEmpty(semmcp001Bean.getConstructionPermissionSearchSP().getTot_result_status()) || !StringUtils.isEmpty(semmcp001Bean.getConstructionPermissionSearchSP().getCon_result_status())){
				semmcp001Bean.setDisableBtnTot(false);
				semmcp001Bean.setDisableBtnConstructStatus(false);
			}else{
				String constructType = getPopupVendorSupplierBean().getPopupVendorSupplierSearchSP().getConstructType();
				if ("01".equals(constructType)) {
					semmcp001Bean.setDisableBtnTot(false);
					semmcp001Bean.setDisableBtnConstructStatus(true);
				}else{
					if("02".equals(constructType)){
						semmcp001Bean.setDisableBtnTot(true);
						semmcp001Bean.setDisableBtnConstructStatus(false);
					}
				}
				
			}
			
			setSemmcp001Bean(semmcp001Bean);
			changeCriteriaConstructStatusListDropdownCp002();
			onRenderConstructStatusFromDoShow();
			onrenderPaymentType();
			onRenderWhtRate();
			flag = true;
			
		} catch (Exception e) {
			log.error(e);
		}
		checkResultChange();
		checkDisableResult();
		return flag;
	}

	public boolean doSearch() {

		boolean flag = false;
		semmcp001Bean = getSemmcp001Bean();
		if(!semmcp001Bean.isRenderedOnToDoList()){
			if (!validateSearch()) {
				semmcp001Bean.getConstructionPermissionForSearch().setCheckDisabled(!checkEnable());
				return flag;
			}
		}
		
		if("true".equalsIgnoreCase(semmcp001Bean.getConstructionPermissionForSearch().getNoContract())){
			semmcp001Bean.getConstructionPermissionForSearch().setNoContract("Y");
		}
		if("true".equalsIgnoreCase(semmcp001Bean.getConstructionPermissionForSearch().getDummyFlag())){
			semmcp001Bean.getConstructionPermissionForSearch().setDummyFlag("Y");
		}
		
		
		 log.debug(" getCompanyCri "+semmcp001Bean.getConstructionPermissionForSearch().getCompanyCri()); 
		 log.debug("getContractNoCri "+semmcp001Bean.getConstructionPermissionForSearch().getContractNoCri()); 
		 log.debug("getSiteNameCri "+semmcp001Bean.getConstructionPermissionForSearch().getSiteNameCri()); 
		 log.debug(""+semmcp001Bean.getConstructionPermissionForSearch().getLocationIdCri()); 
			
		 log.debug("getRegionCri "+semmcp001Bean.getConstructionPermissionForSearch().getRegionCri()); 
		 log.debug("getSiteConstructStatusCri "+semmcp001Bean.getConstructionPermissionForSearch().getSiteConstructStatusCri()); 
		 log.debug("getDocNoCri "+semmcp001Bean.getConstructionPermissionForSearch().getDocNoCri()); 
		 log.debug("getSupplierNameCri "+semmcp001Bean.getConstructionPermissionForSearch().getSupplierNameCri()); 
		 log.debug("getTotSendDocNoCri "+semmcp001Bean.getConstructionPermissionForSearch().getTotSendDocNoCri()); 
		 log.debug("getTotRefDocNoCri "+semmcp001Bean.getConstructionPermissionForSearch().getTotRefDocNoCri()); 
			
		 log.debug("getConPermissionDocNoCri "+semmcp001Bean.getConstructionPermissionForSearch().getConPermissionDocNoCri()); 
		 log.debug("getConstructTypeCri "+semmcp001Bean.getConstructionPermissionForSearch().getConstructTypeCri()); 
		 log.debug("getConstructStatusCri "+semmcp001Bean.getConstructionPermissionForSearch().getConstructStatusCri()); 
		 log.debug("getConBuildDocNoCri "+semmcp001Bean.getConstructionPermissionForSearch().getConBuildDocNoCri()); 
		 log.debug("getConBillNoCri "+semmcp001Bean.getConstructionPermissionForSearch().getConBillNoCri()); 
			
		 log.debug("getConBillPayStatusCri "+semmcp001Bean.getConstructionPermissionForSearch().getConBillPayStatusCri()); 
		 log.debug("getMigrateFlagCri "+semmcp001Bean.getConstructionPermissionForSearch().getMigrateFlagCri()); 
		 log.debug("getStrParam "+semmcp001Bean.getConstructionPermissionForSearch().getStrParam());
		 log.debug("getNoContract "+semmcp001Bean.getConstructionPermissionForSearch().getNoContract());
		 log.debug("getDummyFlag "+semmcp001Bean.getConstructionPermissionForSearch().getDummyFlag());
		 log.debug("getLocationCodeCri "+semmcp001Bean.getConstructionPermissionForSearch().getLocationCodeCri());
		 log.debug("getSiteCodeCri "+semmcp001Bean.getConstructionPermissionForSearch().getSiteCodeCri());
		
		semmcp001Bean.getConstructionPermissionSearchSP().setCompany(semmcp001Bean.getConstructionPermissionForSearch().getCompanyCri());
		semmcp001Bean.getConstructionPermissionForSearch().setCompany(semmcp001Bean.getConstructionPermissionForSearch().getCompanyCri());
		ISendRenewService sendRenewService = (ISendRenewService) getBean("sendRenewService");
		List<ConstructionPermissionSearchSP> to = null;
		try {
			to = sendRenewService.querySPList(EQueryName.Q_SEARCH_CONSTRUCTIONPERMISSION.name,semmcp001Bean.getConstructionPermissionForSearch());
			
			if (null == to || to.isEmpty()) {
				// set error message after search not found
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("M0004"),""));
			}

			semmcp001Bean.setConstructionPermissionSearchSPList(to);
			semmcp001Bean.setConfirmDeleteMsg(MSGCacheUtil.getInstance().getMessageByCode("Q0002"));
			semmcp001Bean.getConstructionPermissionForSearch().setCheckDisabled(!checkEnable());
			setSemmcp001Bean(semmcp001Bean);

			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError("E0003");
		}

		return flag;
	}

	private boolean validateSearch() {
		boolean flgValid = true;
		if(StringUtils.isEmpty(getSemmcp001Bean().getConstructionPermissionForSearch().getContractNoCri()) 
				&& StringUtils.isEmpty(getSemmcp001Bean().getConstructionPermissionForSearch().getLocationIdCri())
				&& StringUtils.isEmpty(getSemmcp001Bean().getConstructionPermissionForSearch().getNoContract()) 
				&& StringUtils.isEmpty(getSemmcp001Bean().getConstructionPermissionForSearch().getDummyFlag())){
			
			if (StringUtils.isEmpty(getSemmcp001Bean().getConstructionPermissionForSearch().getCompanyCri())) {
//				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"),msg("message.company")));
				addMessageError("W0001",msg("message.company"));
				flgValid = false;
			}
//			if(StringUtils.isEmpty(getSemmcp001Bean().getConstructionPermissionForSearch().getSiteConstructStatusCri())){
//				addMessageError("W0001",msg("message.sendrenewStatus"));
//				flgValid = false;
//			}
		}
		return flgValid;
	}

	private void setMessage(String messageCode) {
		FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(
				MSGCacheUtil.getInstance().getMessageByCode(messageCode), ""));

	}

	private boolean pageLoad() {
		boolean flag = true;
		semmcp001Bean = getSemmcp001Bean();
		semmcp001Bean.setButtonAdd(true);
		setSemmcp001Bean(semmcp001Bean);

		return flag;
	}

	public boolean doClear() {
		boolean flag = false;

		semmcp001Bean = getSemmcp001Bean();
		semmcp001Bean.setConstructionPermissionForSearch(new ConstructionPermissionSearchSP());
//		semmcp001Bean.getConstructionPermissionSearchSP().setCon_bill_pay_flag("Y"); 
		semmcp001Bean.getConstructionPermissionForSearch().setMigrateFlagCri("Y");
		semmcp001Bean.setConstructionPermissionSearchSPList(null);
		
		//added by NEW 18/03/2015 for to do list page
		semmcp001Bean.setTreeUtilBean(new TreeUtilBean());
		semmcp001Bean.setRootNode(new TreeNodeImpl());
		rootNode = null;
		semmcp001Bean.setMenuTreeMacroList(new ArrayList<WrapperBeanObject<MenuTreeSP>>());
		semmcp001Bean.setMenuTreePicoList(new ArrayList<WrapperBeanObject<MenuTreeSP>>());
		semmcp001Bean.setTreeMacroFlag(false);
		semmcp001Bean.setTreePicoFlag(false);
		setSemmcp001Bean(semmcp001Bean);
		
		return flag;
	}
	
	public void onRenderConstructStatus(){
	
		semmcp001Bean = getSemmcp001Bean();		
		popupVendorSupplierBean = getPopupVendorSupplierBean();
		String constructType = getPopupVendorSupplierBean().getPopupVendorSupplierSearchSP().getConstructType();
		//notice TOT
		 String chkStatus =  doClearTmpConstructStatus(constructType);
		 if(StringUtils.isEmpty(chkStatus)){
			 chkStatus = "1";
		 }
		if (constructType.equals("01")){
			if(semmcp001Bean.getConstructionPermissionSearchSP().getTot_sup_req_dt() != null && semmcp001Bean.getOldSubReqDt() == null){
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("01");
				semmcp001Bean.setOldSubReqDt(semmcp001Bean.getConstructionPermissionSearchSP().getTot_sup_req_dt());
			}else if(chkStatus.equals("1")){
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("01");
			}
			if(semmcp001Bean.getConstructionPermissionSearchSP().getTot_send_tot_dt() != null && semmcp001Bean.getOldTotSendTotDt() == null){
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("02");
				semmcp001Bean.setOldTotSendTotDt(semmcp001Bean.getConstructionPermissionSearchSP().getTot_send_tot_dt());
			}else if(chkStatus.equals("2")){
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("02");
			}
			
			if(StringUtils.isEmpty(semmcp001Bean.getConstructionPermissionSearchSP().getTot_result_status())){
				semmcp001Bean.setEditable(true);
				semmcp001Bean.setDisablePnlRemarkNotAllow(false);
			}else{
//				semmcp001Bean.setEditable(false);
				//Change on 11/3/2013 enable all 
				semmcp001Bean.setEditable(true);
				semmcp001Bean.setDisablePnlRemarkNotAllow(false);
				if(semmcp001Bean.getConstructionPermissionSearchSP().getTot_result_status().equals("01")
				   && StringUtils.isEmpty(semmcp001Bean.getOldTotResultStatus01())){
							popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("03");
							semmcp001Bean.setOldTotResultStatus01(semmcp001Bean.getConstructionPermissionSearchSP().getTot_result_status());
					}else if(chkStatus.equals("3")){
						popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("03");
					}
				if(semmcp001Bean.getConstructionPermissionSearchSP().getTot_result_status().equals("02")
				   && StringUtils.isEmpty(semmcp001Bean.getOldTotResultStatus02())){
								popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("04");
								semmcp001Bean.setOldTotResultStatus02(semmcp001Bean.getConstructionPermissionSearchSP().getTot_result_status());
								semmcp001Bean.setDisablePnlRemarkNotAllow(true);
				}else if(semmcp001Bean.getConstructionPermissionSearchSP().getTot_result_status().equals("02")){
					if(chkStatus.equals("4")){
						popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("04");
					}
					semmcp001Bean.setDisablePnlRemarkNotAllow(true);
				}
				
				if(StringUtils.isEmpty(semmcp001Bean.getConstruct().getConPaymentMethod())){
					semmcp001Bean.getConstruct().setConPaymentMethod(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.CT_PAYMENT_METHOD));
				}
			}
			
			semmcp001Bean.setRenderConstruct(true);
			if(semmcp001Bean.getConstructionPermissionSearchSP().getTot_send_sup_dt() != null && semmcp001Bean.getOldTotSendSubDt() == null){
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("05");
				semmcp001Bean.setOldTotSendSubDt(semmcp001Bean.getConstructionPermissionSearchSP().getTot_send_sup_dt());
			}else if(chkStatus.equals("5")){
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("05");
			}
			
			if(semmcp001Bean.getConstructionPermissionSearchSP().getTotSubReceiveDt() != null && semmcp001Bean.getOldTotSubReceiveDt() == null){
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("06");
				semmcp001Bean.setOldTotSubReceiveDt(semmcp001Bean.getConstructionPermissionSearchSP().getTotSubReceiveDt());
			}else if(chkStatus.equals("6")){
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("06");
			}
			
			if(semmcp001Bean.getConstructionPermissionSearchSP().getReject_dt() != null && semmcp001Bean.getOldRejectDt() == null){
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("07");
				semmcp001Bean.setOldRejectDt(semmcp001Bean.getConstructionPermissionSearchSP().getReject_dt());
			}else if(chkStatus.equals("7")){
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("07");
			}
			if(semmcp001Bean.getConstructionPermissionSearchSP().getReject_clear_dt() != null && semmcp001Bean.getOldRejectClearDt() == null){
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("08");
				semmcp001Bean.setOldRejectClearDt(semmcp001Bean.getConstructionPermissionSearchSP().getReject_clear_dt());
			}else if(chkStatus.equals("8")){
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("08");
			}
		}
		
		//constructReq
		if (constructType.equals("02")){
			if(semmcp001Bean.getConstructionPermissionSearchSP().getCon_sup_req_dt() != null && semmcp001Bean.getOldConSubReqDt() == null){
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("01");
				semmcp001Bean.setOldConSubReqDt(semmcp001Bean.getConstructionPermissionSearchSP().getCon_sup_req_dt());
			}else if(chkStatus.equals("1")){
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("01");
			}
			if(semmcp001Bean.getConstructionPermissionSearchSP().getCon_permission_doc_dt() != null && semmcp001Bean.getOldConpermissionDocDt() == null){
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("02");
				semmcp001Bean.setOldConpermissionDocDt(semmcp001Bean.getConstructionPermissionSearchSP().getCon_permission_doc_dt());
			}else if(chkStatus.equals("2")){
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("02");
			}
			if(semmcp001Bean.getConstructionPermissionSearchSP().getCon_send_sup_dt() != null && semmcp001Bean.getOldConsendSubDt() == null){
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("03");
				semmcp001Bean.setOldConsendSubDt(semmcp001Bean.getConstructionPermissionSearchSP().getCon_send_sup_dt());
			}else if(chkStatus.equals("3")){
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("03");
			}
			if(StringUtils.isEmpty(semmcp001Bean.getConstructionPermissionSearchSP().getCon_result_status())){
				semmcp001Bean.setEditable(true);
				semmcp001Bean.setDisablePnlConRemarkNotAllow(false);
			}else{
//				semmcp001Bean.setEditable(false);
				//Change on 11/3/2013 enable all 
				semmcp001Bean.setEditable(true);
				semmcp001Bean.setDisablePnlConRemarkNotAllow(false);
				if(semmcp001Bean.getConstructionPermissionSearchSP().getCon_result_status().equals("01")
						&& StringUtils.isEmpty(semmcp001Bean.getOldConResultStatus01())){
							if(StringUtils.isEmpty(semmcp001Bean.getConstruct().getConPaymentMethod())){
								semmcp001Bean.getConstruct().setConPaymentMethod(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.CT_PAYMENT_METHOD));
							}
							popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("04");
							semmcp001Bean.setOldConResultStatus01(semmcp001Bean.getConstructionPermissionSearchSP().getCon_result_status());
					}else if(chkStatus.equals("4")){
						popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("04");
					}
					if(semmcp001Bean.getConstructionPermissionSearchSP().getCon_result_status().equals("02")
							&& StringUtils.isEmpty(semmcp001Bean.getOldConResultStatus02())){
								popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("05");
								semmcp001Bean.setOldConResultStatus02(semmcp001Bean.getConstructionPermissionSearchSP().getCon_result_status());
								semmcp001Bean.setDisablePnlConRemarkNotAllow(true);
					}else if(semmcp001Bean.getConstructionPermissionSearchSP().getCon_result_status().equals("02")){
						if(chkStatus.equals("5")){
							popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("05");
						}
						semmcp001Bean.setDisablePnlConRemarkNotAllow(true);
					}
			}
			
			semmcp001Bean.setRenderConstruct(false);
			
			if(semmcp001Bean.getConstructionPermissionSearchSP().getReject_dt() != null && semmcp001Bean.getOldRejectDt() == null){
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("06");
				semmcp001Bean.setOldRejectDt(semmcp001Bean.getConstructionPermissionSearchSP().getReject_dt());
			}else if(chkStatus.equals("6")){
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("06");
			}
			if(semmcp001Bean.getConstructionPermissionSearchSP().getReject_clear_dt() != null && semmcp001Bean.getOldRejectClearDt() == null){
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("07");
				semmcp001Bean.setOldRejectClearDt(semmcp001Bean.getConstructionPermissionSearchSP().getReject_clear_dt());
			}else if(chkStatus.equals("7")){
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("07");
			}
		}
		
		if("02".equals(semmcp001Bean.getConstruct().getConPaymentStatus())){
			semmcp001Bean.setPayable(true);
		}else{
			semmcp001Bean.setPayable(false);
		}
		
		setPopupVendorSupplierBean(popupVendorSupplierBean);
		setSemmcp001Bean(semmcp001Bean);
		checkResultChange();
		
		
		
		/*************************************************************************/
//		String tmpConStatus = semmcp001Bean.getConstructionPermissionSearchSP().getCon_result_status();
//		if(StringUtils.isEmpty(tmpConStatus)){
//			semmcp001Bean.setDisableConstructType(false);
//		}else{
//			semmcp001Bean.setDisableConstructType(true);
//		}
		/*************************************************************************/
	}
	
	public String doClearTmpConstructStatus(String constructType){
		String chkStatus = "";
		semmcp001Bean = getSemmcp001Bean();
		if (constructType.equals("01")){
			if(semmcp001Bean.getConstructionPermissionSearchSP().getReject_clear_dt() == null){
				semmcp001Bean.setOldRejectClearDt(null);
			}else {
				chkStatus = "8";
				return chkStatus;
			}
			
			if(semmcp001Bean.getConstructionPermissionSearchSP().getReject_dt() == null){
				semmcp001Bean.setOldRejectDt(null);
			}else {
				chkStatus = "7";
				return chkStatus;
			}
			
			if(semmcp001Bean.getConstructionPermissionSearchSP().getTotSubReceiveDt() == null){
				semmcp001Bean.setOldTotSubReceiveDt(null);
			}else {
				chkStatus = "6";
				return chkStatus;
			}
			
			if(semmcp001Bean.getConstructionPermissionSearchSP().getTot_send_sup_dt() == null){
				semmcp001Bean.setOldTotSendSubDt(null);
			}else {
				chkStatus = "5";
				return chkStatus;
			}
			
			if(StringUtils.isEmpty(semmcp001Bean.getConstructionPermissionSearchSP().getTot_result_status())
					&& !"02".equals(semmcp001Bean.getConstructionPermissionSearchSP().getTot_result_status())){
				semmcp001Bean.setOldTotResultStatus02(null);
			}else {
				chkStatus = "4";
				return chkStatus;
			}
			
			if(StringUtils.isEmpty(semmcp001Bean.getConstructionPermissionSearchSP().getTot_result_status())
					&& !"01".equals(semmcp001Bean.getConstructionPermissionSearchSP().getTot_result_status())){
				semmcp001Bean.setOldTotResultStatus01(null);
			}else{
				chkStatus = "3";
				return chkStatus;
			}
			
			if(semmcp001Bean.getConstructionPermissionSearchSP().getTot_send_tot_dt() == null){
				semmcp001Bean.setOldTotSendTotDt(null);
			}else {
				chkStatus = "2";
				return chkStatus;
			}
			
			if(semmcp001Bean.getConstructionPermissionSearchSP().getTot_sup_req_dt() == null){
				semmcp001Bean.setOldSubReqDt(null);
			}else {
				chkStatus = "1";
				return chkStatus;
			}
			
		}
		
		//constructReq
		if (constructType.equals("02")){
			if(semmcp001Bean.getConstructionPermissionSearchSP().getReject_clear_dt() == null){
				semmcp001Bean.setOldRejectClearDt(null);
			}else {
				chkStatus = "6";
				return chkStatus;
			}
			
			if(semmcp001Bean.getConstructionPermissionSearchSP().getReject_dt() == null){
				semmcp001Bean.setOldRejectDt(null);
			}else {
				chkStatus = "5";
				return chkStatus;
			}
			
			if(StringUtils.isEmpty(semmcp001Bean.getConstructionPermissionSearchSP().getCon_result_status()) 
					&& !"02".equals(semmcp001Bean.getConstructionPermissionSearchSP().getCon_result_status())){
				semmcp001Bean.setOldConResultStatus02("");
			}else {
				chkStatus = "4";
				return chkStatus;
			}
			
			if(StringUtils.isEmpty(semmcp001Bean.getConstructionPermissionSearchSP().getCon_result_status()) 
					&& !"01".equals(semmcp001Bean.getConstructionPermissionSearchSP().getCon_result_status())){
					semmcp001Bean.setOldConResultStatus01("");
				}else {
					chkStatus = "3";
					return chkStatus;
			}
			
			if(semmcp001Bean.getConstructionPermissionSearchSP().getCon_send_sup_dt() == null){
				semmcp001Bean.setOldConsendSubDt(null);
			}else {
				chkStatus = "2" ;
				return chkStatus;
			}
			if(semmcp001Bean.getConstructionPermissionSearchSP().getCon_sup_req_dt() == null){
				semmcp001Bean.setOldConSubReqDt(null);
			}else {
				chkStatus = "1";
				return chkStatus;
			}
//			if(semmcp001Bean.getConstructionPermissionSearchSP().getCon_permission_doc_dt() == null){
//				semmcp001Bean.setOldConpermissionDocDt(null);
//			}else if(semmcp001Bean.getConstructionPermissionSearchSP().getCon_permission_doc_dt() != null && semmcp001Bean.getOldConpermissionDocDt() != null){
//				chkStatus = "2";
//			}
		}
		setSemmcp001Bean(semmcp001Bean);
		return chkStatus;
	}
	
	
	public void onRenderConstructStatusFromDoShow(){
		semmcp001Bean = getSemmcp001Bean();
		popupVendorSupplierBean = getPopupVendorSupplierBean();
		String constructType = getPopupVendorSupplierBean().getPopupVendorSupplierSearchSP().getConstructType();
		//notice TOT
		if (!StringUtils.isEmpty(constructType)&& constructType.equals("01")){
			if(semmcp001Bean.getConstructionPermissionSearchSP().getTot_sup_req_dt() != null){
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("01");
				semmcp001Bean.setOldSubReqDt(semmcp001Bean.getConstructionPermissionSearchSP().getTot_sup_req_dt());
			}
			if(semmcp001Bean.getConstructionPermissionSearchSP().getTot_send_tot_dt() != null){
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("02");
				semmcp001Bean.setOldTotSendTotDt(semmcp001Bean.getConstructionPermissionSearchSP().getTot_send_tot_dt());
			}
			if(semmcp001Bean.getConstructionPermissionSearchSP().getTot_result_status() != null 
					&& semmcp001Bean.getConstructionPermissionSearchSP().getTot_result_status().equals("01")){
						popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("03");
						semmcp001Bean.setOldTotResultStatus01(semmcp001Bean.getConstructionPermissionSearchSP().getTot_result_status());
				}
			if(semmcp001Bean.getConstructionPermissionSearchSP().getTot_result_status() != null 
					&& semmcp001Bean.getConstructionPermissionSearchSP().getTot_result_status().equals("02")){
							popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("04");
							semmcp001Bean.setOldTotResultStatus02(semmcp001Bean.getConstructionPermissionSearchSP().getTot_result_status());
			}
			if(semmcp001Bean.getConstructionPermissionSearchSP().getTot_send_sup_dt() != null){
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("05");
				semmcp001Bean.setOldTotSendSubDt(semmcp001Bean.getConstructionPermissionSearchSP().getTot_send_sup_dt());
			}
			if(semmcp001Bean.getConstructionPermissionSearchSP().getReject_dt() != null){
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("06");
				semmcp001Bean.setOldRejectDt(semmcp001Bean.getConstructionPermissionSearchSP().getReject_dt());
			}
			if(semmcp001Bean.getConstructionPermissionSearchSP().getReject_clear_dt() != null){
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("07");
				semmcp001Bean.setOldRejectClearDt(semmcp001Bean.getConstructionPermissionSearchSP().getReject_clear_dt());
			}
		}
		
		//constructReq
		if (!StringUtils.isEmpty(constructType)&& constructType.equals("02")){
			if(semmcp001Bean.getConstructionPermissionSearchSP().getCon_sup_req_dt() != null){
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("01");
				semmcp001Bean.setOldConSubReqDt(semmcp001Bean.getConstructionPermissionSearchSP().getCon_sup_req_dt());
			}
			if(semmcp001Bean.getConstructionPermissionSearchSP().getCon_permission_doc_dt() != null){
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("02");
				semmcp001Bean.setOldConpermissionDocDt(semmcp001Bean.getConstructionPermissionSearchSP().getCon_permission_doc_dt());
			}
			if(semmcp001Bean.getConstructionPermissionSearchSP().getCon_send_sup_dt() != null){
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("03");
				semmcp001Bean.setOldConsendSubDt(semmcp001Bean.getConstructionPermissionSearchSP().getCon_send_sup_dt());
			}
			if(semmcp001Bean.getConstructionPermissionSearchSP().getCon_result_status() != null 
				&& semmcp001Bean.getConstructionPermissionSearchSP().getCon_result_status().equals("01")){
					popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("04");
					semmcp001Bean.setOldConResultStatus01(semmcp001Bean.getConstructionPermissionSearchSP().getCon_result_status());
			}
			if(semmcp001Bean.getConstructionPermissionSearchSP().getCon_result_status() != null 
					&& semmcp001Bean.getConstructionPermissionSearchSP().getCon_result_status().equals("02")){
						popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("05");
						semmcp001Bean.setOldConResultStatus02(semmcp001Bean.getConstructionPermissionSearchSP().getCon_result_status());
			}
			if(semmcp001Bean.getConstructionPermissionSearchSP().getReject_dt() != null){
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("06");
				semmcp001Bean.setOldRejectDt(semmcp001Bean.getConstructionPermissionSearchSP().getReject_dt());
			}
			if(semmcp001Bean.getConstructionPermissionSearchSP().getReject_clear_dt() != null){
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructStatus("07");
				semmcp001Bean.setOldRejectClearDt(semmcp001Bean.getConstructionPermissionSearchSP().getReject_clear_dt());
			}
		}
		
		
		setPopupVendorSupplierBean(popupVendorSupplierBean);
		setSemmcp001Bean(semmcp001Bean);
	}
	
	public boolean doSavePay() {
		boolean flag = false;

		semmcp001Bean = getSemmcp001Bean();
		ISendRenewService sendRenewService = (ISendRenewService) getBean("sendRenewService");
		List<ConstructionPermissionSavePay> to = null;
		
		//set value
		semmcp001Bean.getConstructionPermissionSavePay().setConResultStatus(semmcp001Bean.getConstructionPermissionSearchSP().getCon_result_status());
		semmcp001Bean.getConstructionPermissionSavePay().setConBuildDocno(semmcp001Bean.getConstructionPermissionSearchSP().getCon_build_doc_no());
		semmcp001Bean.getConstructionPermissionSavePay().setConBillNo(semmcp001Bean.getConstructionPermissionSearchSP().getCon_bill_no());
		semmcp001Bean.getConstructionPermissionSavePay().setConBillAmt(Double.parseDouble(semmcp001Bean.getConstructionPermissionSearchSP().getCon_bill_amt()));
//		semmcp001Bean.getConstructionPermissionSavePay().setConWbs(semmcp001Bean.getConstructionPermissionSearchSP().getCon_wbs());
		semmcp001Bean.getConstructionPermissionSavePay().setConBillPayFlag(semmcp001Bean.getConstructionPermissionSearchSP().getCon_bill_pay_flag());
		semmcp001Bean.getConstructionPermissionSavePay().setConBillPayStatus(semmcp001Bean.getConstructionPermissionSearchSP().getCon_bill_pay_status());
		
		try {
			to = sendRenewService.querySPList(EQueryName.SP_MCP001_SAVE_PAY.name,semmcp001Bean.getConstructionPermissionSavePay());
			if (to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")) {
				addMessageInfo("M0001");
			}else if(to != null && !to.isEmpty()){
//				FrontMessageUtils.addMessageError(to.get(0).getpRemark());
			}
			semmcp001Bean.setRenderedMsgFormTop(false);
			semmcp001Bean.setRenderedMsgFormMiddle(true);
			setSemmcp001Bean(semmcp001Bean);
			
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}
	
	public void renderBillPay(){
		semmcp001Bean = getSemmcp001Bean();
		semmcp001Bean.setFlagCheckRequireWBS(false);
		if(semmcp001Bean.getConstructionPermissionSearchSP().getCon_bill_pay_flag().equals("Y")){
			semmcp001Bean.setFlagCheckRequireWBS(true);
		}
		setSemmcp001Bean(semmcp001Bean);
	}
	
	public void onRenderAmount(){
		semmcp001Bean = getSemmcp001Bean();
		IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
		List<Mpt004Cal> to = null;
		
		if(!StringUtils.isEmpty(semmcp001Bean.getConstructionPermissionSearchSP().getCon_bill_amt())){
			semmcp001Bean.getConstruct().setConBillAmt(Double.parseDouble(semmcp001Bean.getConstructionPermissionSearchSP().getCon_bill_amt()));
		}
		// check Estmamt don't null
		if(semmcp001Bean.getConstruct().getConWhtRate() == null){
			semmcp001Bean.getConstruct().setConWhtRate(0.00);
		}
		
		//check 
		if(!StringUtils.isEmpty(semmcp001Bean.getConstruct().getConVatType()) && !StringUtils.isEmpty(semmcp001Bean.getConstruct().getConWhtType())){
			if(semmcp001Bean.getConstruct().getConBillAmt() != null){
				
			//set value to mpt004Cal
				semmcp001Bean.getMpt004Cal().setTotalAmt(semmcp001Bean.getConstruct().getConBillAmt());
				semmcp001Bean.getMpt004Cal().setVatType(semmcp001Bean.getConstruct().getConVatType());
				semmcp001Bean.getMpt004Cal().setWhtType(semmcp001Bean.getConstruct().getConWhtType());
				semmcp001Bean.getMpt004Cal().setWhtRate(semmcp001Bean.getConstruct().getConWhtRate());
				semmcp001Bean.getMpt004Cal().setEstmAmt(semmcp001Bean.getConstruct().getConBillAmt());
				
				try {
					to = pTaxMasterService.querySPList(EQueryName.SP_MPT004_CAL.name, semmcp001Bean.getMpt004Cal());
				
					if (to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")) {
						semmcp001Bean.getConstruct().setConExcAmt(to.get(0).getExcAmt());
						semmcp001Bean.getConstruct().setConVatAmt(to.get(0).getVatAmt());
						semmcp001Bean.getConstruct().setConIncAmt(to.get(0).getIncAmt());
						semmcp001Bean.getConstruct().setConWhtAmt(to.get(0).getWhtAmt());
						
						//get excAmt vatAmt whtAmt add bean Because validate + - 1
						semmcp001Bean.setOldExcAmt(to.get(0).getExcAmt());
						semmcp001Bean.setOldVatAmt(to.get(0).getVatAmt());
						semmcp001Bean.setOldWhtAmt(to.get(0).getWhtAmt());
						semmcp001Bean.setOldIncAmt(to.get(0).getIncAmt());
						semmcp001Bean.setOldchqAmt(to.get(0).getChqAmt());
						
					}else if(to != null && !to.isEmpty()){
						FrontMessageUtils.addMessageError(to.get(0).getpRemark());
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		onRenderWhtRate();
		onRenderIncludeAmt();
		setSemmcp001Bean(semmcp001Bean);
	}
	
	public void onRenderWhtRate(){
		semmcp001Bean = getSemmcp001Bean();
		semmcp001Bean.setDisableWhtRate(false);
		if(semmcp001Bean.getConstruct().getConWhtType().equals("03")){
			semmcp001Bean.setDisableWhtRate(true);
		}
		setSemmcp001Bean(semmcp001Bean);
	}
	
	public void onrenderPaymentType(){
		semmcp001Bean = getSemmcp001Bean();
		if(semmcp001Bean.getConstruct().getConPaymentType() != null && semmcp001Bean.getConstruct().getConPaymentType().equals("01")){
			semmcp001Bean.setRenderCldTransferDt(true);
			if(getSemmcp001Bean().getMcp001ChkPayable().getPayAbleFlag().equals("N")){
				semmcp001Bean.setRenderCldChqDt(true);
			}else{
				semmcp001Bean.setRenderCldChqDt(false);
			}
			
			semmcp001Bean.setPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name, EX_IN, "CHEQUE", null, null));
			semmcp001Bean.getConstruct().setConTransferDt(null);
		}
		if(semmcp001Bean.getConstruct().getConPaymentType() != null && semmcp001Bean.getConstruct().getConPaymentType().equals("02")){
			semmcp001Bean.setRenderCldChqDt(true);
			semmcp001Bean.setRenderCldTransferDt(false);
			semmcp001Bean.setPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name, EX_IN, "TRANSFER", null, null));
			semmcp001Bean.getConstruct().setConChqDt(null);
			semmcp001Bean.getConstruct().setConChqReceiveDt(null);
			semmcp001Bean.getConstruct().setConPaymentMethod("05");
		}
		setSemmcp001Bean(semmcp001Bean);
	}
	
	public void onRenderIncludeAmt(){
		semmcp001Bean = getSemmcp001Bean();
		if(!validateTotalAmount()){
			addMessageError("W0031");
			semmcp001Bean.getConstruct().setConIncAmt(
					(semmcp001Bean.getConstruct().getConExcAmt()!=null?semmcp001Bean.getConstruct().getConExcAmt():0.00 )
				  + (semmcp001Bean.getConstruct().getConVatAmt()!=null?semmcp001Bean.getConstruct().getConVatAmt():0.00));
		}else{
			semmcp001Bean.getConstruct().setConIncAmt(
					(semmcp001Bean.getConstruct().getConExcAmt()!=null?semmcp001Bean.getConstruct().getConExcAmt():0.00 )
				  + (semmcp001Bean.getConstruct().getConVatAmt()!=null?semmcp001Bean.getConstruct().getConVatAmt():0.00));
		}
		setSemmcp001Bean(semmcp001Bean);
		onRenderTotalAmt();
	}
	
	public void onRenderTotalAmt(){
		semmcp001Bean = getSemmcp001Bean();
		if(!validateTotalAmount()){
			addMessageError("W0031");
		}else{
			semmcp001Bean.getMpt004Cal().setChqAmt(
					(semmcp001Bean.getConstruct().getConIncAmt()!=null?semmcp001Bean.getConstruct().getConIncAmt():0.00 )
				  - (semmcp001Bean.getConstruct().getConWhtAmt()!=null?semmcp001Bean.getConstruct().getConWhtAmt():0.00));
		}
		setSemmcp001Bean(semmcp001Bean);
	}
	
	public boolean validateTotalAmount(){
		boolean flagValid = true;
		semmcp001Bean = getSemmcp001Bean();
		Double defaultValPositive = 1.00;
		Double defaultValNegative = -1.00;
		if(semmcp001Bean.getConstruct().getConVatAmt() != null){
			if(semmcp001Bean.getOldVatAmt() == null){
				semmcp001Bean.setOldVatAmt(0.00);
			}
			if(semmcp001Bean.getOldExcAmt() == null){
				semmcp001Bean.setOldExcAmt(0.00);
			}
			
			Double tmpExcAmt = semmcp001Bean.getOldExcAmt() - semmcp001Bean.getConstruct().getConExcAmt();
			if(tmpExcAmt > defaultValPositive || tmpExcAmt < defaultValNegative){
				semmcp001Bean.getConstruct().setConExcAmt(semmcp001Bean.getOldExcAmt());
				semmcp001Bean.getConstruct().setConIncAmt(semmcp001Bean.getOldIncAmt());
				flagValid = false;
			}
			
			Double tmpVatAmt = semmcp001Bean.getOldVatAmt() - semmcp001Bean.getConstruct().getConVatAmt();
			if(tmpVatAmt > defaultValPositive || tmpVatAmt < defaultValNegative){
				semmcp001Bean.getConstruct().setConVatAmt(semmcp001Bean.getOldVatAmt());
				semmcp001Bean.getConstruct().setConIncAmt(semmcp001Bean.getOldIncAmt());
				flagValid = false;
			}
		}
		if(semmcp001Bean.getConstruct().getConWhtAmt() != null && semmcp001Bean.getOldWhtAmt() != null){
			Double tmpWhtAmt = semmcp001Bean.getOldWhtAmt() - semmcp001Bean.getConstruct().getConWhtAmt();
			if(tmpWhtAmt > defaultValPositive || tmpWhtAmt < defaultValNegative){
				semmcp001Bean.getConstruct().setConWhtAmt(semmcp001Bean.getOldWhtAmt());
				semmcp001Bean.getMpt004Cal().setChqAmt(semmcp001Bean.getOldchqAmt());
				flagValid = false;
			}
		}
		setSemmcp001Bean(semmcp001Bean);
		return flagValid;
	}
	
	public boolean doUpdatePay() {
		boolean flag = false;
		tmpFlagMsgSave = "N";
		semmcp001Bean = getSemmcp001Bean();
		if (!validateUpdatePay()) {
			semmcp001Bean.setRenderedMsgFormTop(false);
			semmcp001Bean.setRenderedMsgFormMiddle(true);
			setSemmcp001Bean(semmcp001Bean);
			return flag;
		}
		getSemmcp001Bean().getConstruct().setConPaymentStatus("03");
		doUpdate(true);
		ISendRenewService sendRenewService = (ISendRenewService) getBean("sendRenewService");
		List<Mcp001ChkSavePay> to = null;
		List<Mcp001SavePay> to2 = null;
		List<Mcp001ChkPayable>to3 = null;
		semmcp001Bean.getMcp001ChkSavePay().setRowId(semmcp001Bean.getConstruct().getRowId());
		semmcp001Bean.getMcp001SavePay().setRowId(semmcp001Bean.getConstruct().getRowId());
		semmcp001Bean.getMcp001SavePay().setUser(getUserLogIn());
		semmcp001Bean.getMcp001ChkPayable().setRowId(semmcp001Bean.getConstruct().getRowId());
		try {
			if(!tmpFlagValidate.equals("N")){
				to = sendRenewService.querySPList(EQueryName.SP_MCP001_CHECK_SAVE_PAY.name, semmcp001Bean.getMcp001ChkSavePay());
				if(to != null || to.size() != 0){
					if(to.get(0).getChkStatus().equals("Success")){
						to2 = sendRenewService.querySPList(EQueryName.SP_MCP001_SAVE_PAY_SP.name, semmcp001Bean.getMcp001SavePay());
						if(to2.size() != 0 && to2.get(0).getpResult().equals("Success")){
							addMessageInfo("M0001");
							to3 = sendRenewService.querySPList(EQueryName.SP_MCP001_Check_Payable.name, semmcp001Bean.getMcp001ChkPayable());
							 if("Y".equals(to3.get(0).getPayAbleFlag())){
								 semmcp001Bean.setDisabelBtnSavePay(false);
								 semmcp001Bean.setDisablePnlShowDetailConstruct(false);
							 }else{
								 semmcp001Bean.setDisabelBtnSavePay(true);
								 semmcp001Bean.setDisablePnlShowDetailConstruct(true);
							 }
							 
							 if("Y".equals(to3.get(0).getCancleAbleFlag())){
								 semmcp001Bean.setDisableBtnCanclePay(false);
							 }else{
								 semmcp001Bean.setDisableBtnCanclePay(true);
							 }
							 if ("01".equals(semmcp001Bean.getConstructionPermissionSearchSP().getConstructType())){
								 semmcp001Bean.setDisableBtnTot(false);
								 semmcp001Bean.setDisableBtnConstructStatus(true);
							 }else{
								 semmcp001Bean.setDisableBtnTot(true);
				 				 semmcp001Bean.setDisableBtnConstructStatus(false);
							 }
						}else{							
							log.info("##SAVE NOT SUCESS##");
						}
						
					}else{
						FrontMessageUtils.addMessageError(to.get(0).getMessage());
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			addMessageError("E0001");
		}
		semmcp001Bean.setRenderedMsgFormTop(false);
		semmcp001Bean.setRenderedMsgFormMiddle(true);
		setSemmcp001Bean(semmcp001Bean);
		checkDisableResult();
		return flag;
	}
	
	public boolean validateUpdatePay() {
		boolean flgValid = true;
		
		 popupVendorSupplierBean = getPopupVendorSupplierBean();
		 if(StringUtils.isEmpty(popupVendorSupplierBean.getPopupVendorSupplierSearchSP().getVendorFullName())){ 
			 addMessageError("W0001", msg("message.vendorFullName"));
 			 flgValid = false;
		 }
		 if(StringUtils.isEmpty(getSemmcp001Bean().getConstruct().getConBillNo())){
			 addMessageError("W0001", msg("message.conBillNo"));
			 flgValid = false;
		 }
		 if(getSemmcp001Bean().getConstruct().getConBillDt() == null){
			 addMessageError("W0001", msg("message.conBillDt"));
	 		 flgValid = false;
		 }
		 //default digit null
		 if(getSemmcp001Bean().getConstruct().getConBillAmt() == 0){
			 getSemmcp001Bean().getConstruct().setConBillAmt(null);
		 }
		 
		 if(getSemmcp001Bean().getConstruct().getConBillAmt() == null){
			 addMessageError("W0001", msg("message.totalAmt"));
	 		 flgValid = false;
		 }
 
//		 if(StringUtils.isEmpty(getSemmcp001Bean().getConstructionPermissionSearchSP().getCon_wbs())){
//			 addMessageError("W0001", "WBS");
//	 		 flgValid = false;
//		 }
		 
		 if(StringUtils.isEmpty(getSemmcp001Bean().getConstruct().getConPaymentType())){
			 addMessageError("W0001", msg("message.paymentType"));
	 		 flgValid = false;
		 }
		 if(StringUtils.isEmpty(getSemmcp001Bean().getConstruct().getConPaymentMethod())){
			 addMessageError("W0001", msg("message.paymentMethod"));
	 		 flgValid = false;
		 }
		
		 
		return flgValid;
	}
	
	public boolean doCanclePay() {
		boolean flag = false;
		semmcp001Bean = getSemmcp001Bean();
//		if (!validateUpdatePay()) {
//			semmcp001Bean.setRenderedMsgFormTop(false);
//			semmcp001Bean.setRenderedMsgFormMiddle(true);
//			setSemmcp001Bean(semmcp001Bean);
//			return flag;
//		}
		getSemmcp001Bean().getConstruct().setConPaymentStatus("01");
		doUpdate(false);
		ISendRenewService sendRenewService = (ISendRenewService) getBean("sendRenewService");
		List<Mcp001CanclePay> to = null;
		List<Mcp001ChkPayable>to2 = null;
		semmcp001Bean.getMcp001CanclePay().setRowId(semmcp001Bean.getConstruct().getRowId());
		try {
			to = sendRenewService.querySPList(EQueryName.SP_MCP001_CANCLE_PAY.name, semmcp001Bean.getMcp001CanclePay());
			if(to != null || to.size() != 0){
				to2 = sendRenewService.querySPList(EQueryName.SP_MCP001_Check_Payable.name, semmcp001Bean.getMcp001ChkPayable());
				 if(to2.get(0).getPayAbleFlag().equals("Y")){
					 semmcp001Bean.setDisabelBtnSavePay(false);
					 semmcp001Bean.setDisablePnlShowDetailConstruct(false);
				 }else{
					 semmcp001Bean.setDisabelBtnSavePay(true);
					 semmcp001Bean.setDisablePnlShowDetailConstruct(true);
				 }
				 
				 if(to2.get(0).getCancleAbleFlag().equals("Y")){
					 semmcp001Bean.setDisableBtnCanclePay(false);
				 }else{
					 semmcp001Bean.setDisableBtnCanclePay(true);
				 }
			}
			else{
				FrontMessageUtils.addMessageError(to.get(0).getMessage());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		semmcp001Bean.setRenderedMsgFormTop(false);
		semmcp001Bean.setRenderedMsgFormMiddle(true);
		setSemmcp001Bean(semmcp001Bean);
		checkDisableResult();
		return flag;
	}
	public void getRowIdOnClick() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemmcp001Bean().setTmpRowId(rowId);
	}
	
	private boolean companyChange(){
		boolean flag = false;
		SEMMCP001Bean semmcp001Bean = getSemmcp001Bean();
		boolean isAis = "AIS".equals(semmcp001Bean.getConstructionPermissionForSearch().getCompanyCri());
		boolean isSelectResult = StringUtils.isEmpty(semmcp001Bean.getConstructionPermissionForSearch().getSiteConstructStatusCri());
		semmcp001Bean.setCompanyAis(isAis && isSelectResult);
		semmcp001Bean.getConstructionPermissionForSearch().setConstructStatusCri(null);
		if(!StringUtils.isEmpty(semmcp001Bean.getConstructionPermissionForSearch().getCompanyCri())){
			semmcp001Bean.getConstructionPermissionForSearch().setConstructTypeCri(null);
		}else{
			semmcp001Bean.getConstructionPermissionForSearch().setConstructTypeCri(null);
		}
		if(StringUtils.isNotEmpty(semmcp001Bean.getConstructionPermissionForSearch().getCompanyCri())){
			List<SelectItem> l = new ArrayList<SelectItem>();
			for(SelectItem s : getLovItemsByType(ELovType.T_CP_CONSTRUCT_TYPE.name)){
				l.add(new SelectItem(s.getValue(),s.getLabel()));
			}
			// ประเภทขออนุญาตก่อสร้าง
			if(!isAis){
				l.remove(1);
			}
			semmcp001Bean.setConstructTypeList(l); 
		}else{
			semmcp001Bean.setConstructTypeList(getEmptyDropDown()); 
			semmcp001Bean.getConstructionPermissionForSearch().setConstructStatus(null);
			semmcp001Bean.getConstructionPermissionForSearch().setConstructType(null);
		}
		semmcp001Bean.setConstructStatusList(getEmptyDropDown());
		setSemmcp001Bean(semmcp001Bean);
		changeCriteriaConstructStatusListDropdown();
		semmcp001Bean.getConstructionPermissionForSearch().setCheckDisabled(!checkEnable());
		setSemmcp001Bean(semmcp001Bean);
		return flag;
	}
	
	public void paymentChange(){
		SEMMCP001Bean se = getSemmcp001Bean();
		if(StringUtils.isEmpty(se.getConstruct().getConPaymentStatus()) || ("01".equals(se.getConstruct().getConPaymentStatus()))){
			se.setConPayable(false);
		}else{
			se.setConPayable(true);
		}
		setSemmcp001Bean(se);
		
	}
	
	private void checkResultChange(){
		SEMMCP001Bean se = getSemmcp001Bean();

		if("01".equals(getPopupVendorSupplierBean().getPopupVendorSupplierSearchSP().getConstructType())){
			if(!StringUtils.isEmpty(se.getConstructionPermissionSearchSP().getTot_result_status())){
				if("01".equals(se.getConstructionPermissionSearchSP().getTot_result_status())){
					se.setCheckReject(false);
					se.getConstructionPermissionSearchSP().setCheckExpandPanelNoticeReject(false);
					se.setCheckResultChange(false);
				}else{
					se.setCheckReject(false);
					se.getConstructionPermissionSearchSP().setCheckExpandPanelNoticeReject(false);
					se.setCheckResultChange(false);
				}
			}else{
				se.setCheckReject(true);
				se.getConstructionPermissionSearchSP().setCheckExpandPanelNoticeReject(true);
				se.setCheckResultChange(false);
			}
		}else{
			if("02".equals(getPopupVendorSupplierBean().getPopupVendorSupplierSearchSP().getConstructType())){
				if(!StringUtils.isEmpty(se.getConstructionPermissionSearchSP().getCon_result_status())){
					if("01".equals(se.getConstructionPermissionSearchSP().getCon_result_status())){
						se.setCheckReject(false);
						se.getConstructionPermissionSearchSP().setCheckExpandPanelNoticeReject(false);
						se.setCheckResultChange(true);
					}else{
						se.setCheckReject(false);
						se.getConstructionPermissionSearchSP().setCheckExpandPanelNoticeReject(false);
						se.setCheckResultChange(false);
					}
				}else{
					se.setCheckReject(true);
					se.getConstructionPermissionSearchSP().setCheckExpandPanelNoticeReject(true);
					se.setCheckResultChange(false);
				}
			}else{
				se.setCheckReject(false);
				se.getConstructionPermissionSearchSP().setCheckExpandPanelNoticeReject(false);
				se.setCheckResultChange(false);
			}
		}
		setSemmcp001Bean(se);
	}
	
	private void checkDisableResult(){
		SEMMCP001Bean se = getSemmcp001Bean();
		if(StringUtils.isEmpty(se.getConstruct().getConPaymentStatus()) || "01".equals(se.getConstruct().getConPaymentStatus())){
			se.setConPayable(false);
		}else{
			se.setConPayable(true);
		}
		setSemmcp001Bean(se);
	}
	
	private void clearHiddenFieldData(){
		semmcp001Bean = getSemmcp001Bean();
		Construct con = semmcp001Bean.getConstruct();
		if(!semmcp001Bean.isCheckResultChange()){
			con.setConBillNo(null);
			con.setConBillAmt(null);
			con.setConBillDt(null);
			con.setConChqReceiveDt(null);
			con.setConChqDt(null);
			con.setConPaymentMethod(null);
			con.setConPaymentStatus(null);
			con.setConPayRemark(null);
			semmcp001Bean.getConstructionPermissionSearchSP().setCon_wbs(null);
		}
		
		ConstructionPermissionSearchSP consPer =  semmcp001Bean.getConstructionPermissionSearchSP();
		if(!semmcp001Bean.isCheckReject()){
			consPer.setReject_dt(null);
			consPer.setReject_by(null);
			consPer.setReject_remark(null);
			consPer.setReject_clear_dt(null);
			consPer.setReject_clear_remark(null);
		}
		
		if(!consPer.isCheckExpandPanelTOT()){
			consPer.setTot_sup_req_dt(null);
			consPer.setTot_send_doc_no(null);
			consPer.setTot_send_tot_dt(null);
			consPer.setTot_return_dt(null);
			consPer.setTot_result_status(null);
			consPer.setTot_ref_doc_no(null);
			if(StringUtils.isEmpty(consPer.getTot_result_status()) || "01".equals(consPer.getTot_result_status())){
				consPer.setTot_remark_not_allow(null);
			}
			if("01".equals(consPer.getCon_result_status())){
				consPer.setCon_remark_not_allow(null);
			}
			consPer.setTot_send_sup_dt(null);
			consPer.setTotSubReceiveDt(null);
		}
			
		if(!consPer.isCheckExpandPanelCon()){
			consPer.setCon_sup_req_dt(null);
			consPer.setCon_permission_doc_dt(null);
			consPer.setCon_permission_doc_no(null);
			consPer.setCon_send_sup_dt(null);
			consPer.setCon_result_status(null);
			if("01".equals(consPer.getTot_result_status())){
				consPer.setTot_remark_not_allow(null);
			}
			consPer.setCon_build_doc_no(null);
			if(StringUtils.isEmpty(consPer.getCon_result_status()) || "01".equals(consPer.getCon_result_status())){
				consPer.setCon_remark_not_allow(null);
			}
		}
		
		
		if("02".equals(semmcp001Bean.getConstructionPermissionSearchSP().getCon_result_status())){
			semmcp001Bean.getConstructionPermissionSearchSP().setRemarkNoRequest(null);
		}
		
		PopupVendorSupplierBean	popupVendorSupplierBean = getPopupVendorSupplierBean();
		if(!"01".equals(semmcp001Bean.getConstructionPermissionSearchSP().getSiteConstructStatus())){
			popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setProject(null);
			popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setDocDt(null);
			popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setContactName(null);
			popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setTelephone(null);
			popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setFax(null);
			popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setEmail(null);
			popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setDetail(null);
			popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setPostType(null);
			popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setPostHeight(null);
			popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setOther(null);
			popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setVendorFullNameLocal(null);
			popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setAddress1(null);
			popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setAddress2(null);
			popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setCity(null);
			popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setConstructType(null);
		}
		
		if(!"02".equals(semmcp001Bean.getConstructionPermissionSearchSP().getSiteConstructStatus())){
			semmcp001Bean.getConstructionPermissionSearchSP().setRemarkNoRequest(null);
		}
		
//		semmcp001Bean.setConstructionPermissionSearchSP(new ConstructionPermissionSearchSP());
//		semmcp001Bean.setConstructionPermissionLocationSearchSP(new ConstructionPermissionLocationSearchSP());
//		semmcp001Bean.setMcp001ChkPayable(new Mcp001ChkPayable());
//		semmcp001Bean.setConstruct(new Construct());
	}
	
	public boolean initPopupDocContract() {
		semmcp001Bean = getSemmcp001Bean();
		this.setDefaultRadio();
		setSemmcp001Bean(semmcp001Bean);
		this.searchContractCheckDocByContractId();
		return false;
	}
	
	private void setDefaultRadio() {
		semmcp001Bean = getSemmcp001Bean();
		semmcp001Bean.setContractCheckDoc(new ContractCheckDoc());
		semmcp001Bean.setRenderChk1(true);
		semmcp001Bean.setRenderChk2(false);
		semmcp001Bean.setRenderChk3(false);
		semmcp001Bean.setRenderChk4(false);
		semmcp001Bean.setRenderChk5(false);
		semmcp001Bean.setRenderChk6(false);
		semmcp001Bean.setRenderChk7(false);
		semmcp001Bean.getContractCheckDoc().setRentalType("01");
		setSemmcp001Bean(semmcp001Bean);
	}
	
	private void searchContractCheckDocByContractId() {
		semmcp001Bean = getSemmcp001Bean();
		List<ContractCheckDoc> to = null;
		try{
			String contractId = semmcp001Bean.getConstructionPermissionSearchSP().getContractId();
			
			if(contractId != null && !contractId.equals("")){
				IContractCheckDocService service = (IContractCheckDocService)getBean("contractCheckDocService");
				to = service.queryContractCheckDocByContractId(contractId);
				if(to != null && !to.isEmpty()){
					semmcp001Bean.setContractCheckDoc(to.get(0));
					if(semmcp001Bean.getContractCheckDoc().getRentalType() == null){
						semmcp001Bean.getContractCheckDoc().setRentalType("01");
						semmcp001Bean.getContractCheckDoc().setRentalTypeOtherRemark("");
						this.doShowRentType();
					}else{
						if(semmcp001Bean.getContractCheckDoc().getRentalType().equals("99")){
							semmcp001Bean.setRentalType99("99");
							semmcp001Bean.getContractCheckDoc().setRentalType("");
							this.setRentalType();
							this.doShowRentType99();
						}else{
							semmcp001Bean.getContractCheckDoc().setRentalTypeOtherRemark("");
							this.setRentalType();
							this.doShowRentType();
						}
					}
					semmcp001Bean.setCreateBy(semmcp001Bean.getContractCheckDoc().getCreateBy());
					semmcp001Bean.setUpdateBy(semmcp001Bean.getContractCheckDoc().getUpdateBy());
					semmcp001Bean.setCreateDate(semmcp001Bean.getContractCheckDoc().getCreateDt());
					semmcp001Bean.setUpdateDate(semmcp001Bean.getContractCheckDoc().getUpdateDt());
				}else{
					this.setDefaultRadio();
				}
				setSemmcp001Bean(semmcp001Bean);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void doShowRentType() {
		semmcp001Bean = getSemmcp001Bean();
		// clear radio other
		semmcp001Bean.setRentalType99("");
		String rentalType = semmcp001Bean.getContractCheckDoc().getRentalType();
		if(rentalType != null){
			if(rentalType.equals("01")){
				semmcp001Bean.setRenderChk1(true);
				semmcp001Bean.setRenderChk2(false);
				semmcp001Bean.setRenderChk3(false);
				semmcp001Bean.setRenderChk4(false);
				semmcp001Bean.setRenderChk5(false);
				semmcp001Bean.setRenderChk6(false);
				semmcp001Bean.setRenderChk7(false);
				semmcp001Bean.setRenderChk8(false);
			}else if(rentalType.equals("02")){
				semmcp001Bean.setRenderChk1(false);
				semmcp001Bean.setRenderChk2(true);
				semmcp001Bean.setRenderChk3(false);
				semmcp001Bean.setRenderChk4(false);
				semmcp001Bean.setRenderChk5(false);
				semmcp001Bean.setRenderChk6(false);
				semmcp001Bean.setRenderChk7(false);
				semmcp001Bean.setRenderChk8(false);
			}else if(rentalType.equals("03")){
				semmcp001Bean.setRenderChk1(false);
				semmcp001Bean.setRenderChk2(false);
				semmcp001Bean.setRenderChk3(true);
				semmcp001Bean.setRenderChk4(false);
				semmcp001Bean.setRenderChk5(false);
				semmcp001Bean.setRenderChk6(false);
				semmcp001Bean.setRenderChk7(false);
				semmcp001Bean.setRenderChk8(false);
			}else if(rentalType.equals("04")){
				semmcp001Bean.setRenderChk1(false);
				semmcp001Bean.setRenderChk2(false);
				semmcp001Bean.setRenderChk3(false);
				semmcp001Bean.setRenderChk4(true);
				semmcp001Bean.setRenderChk5(false);
				semmcp001Bean.setRenderChk6(false);
				semmcp001Bean.setRenderChk7(false);
				semmcp001Bean.setRenderChk8(false);
			}else if(rentalType.equals("05")){
				semmcp001Bean.setRenderChk1(false);
				semmcp001Bean.setRenderChk2(false);
				semmcp001Bean.setRenderChk3(false);
				semmcp001Bean.setRenderChk4(false);
				semmcp001Bean.setRenderChk5(true);
				semmcp001Bean.setRenderChk6(false);
				semmcp001Bean.setRenderChk7(false);
				semmcp001Bean.setRenderChk8(false);
			}else if(rentalType.equals("06")){
				semmcp001Bean.setRenderChk1(false);
				semmcp001Bean.setRenderChk2(false);
				semmcp001Bean.setRenderChk3(false);
				semmcp001Bean.setRenderChk4(false);
				semmcp001Bean.setRenderChk5(false);
				semmcp001Bean.setRenderChk6(true);
				semmcp001Bean.setRenderChk7(false);
				semmcp001Bean.setRenderChk8(false);
			}else if(rentalType.equals("07")){
				semmcp001Bean.setRenderChk1(false);
				semmcp001Bean.setRenderChk2(false);
				semmcp001Bean.setRenderChk3(false);
				semmcp001Bean.setRenderChk4(false);
				semmcp001Bean.setRenderChk5(false);
				semmcp001Bean.setRenderChk6(false);
				semmcp001Bean.setRenderChk7(false);
				semmcp001Bean.setRenderChk8(true);
			}
		}
		setSemmcp001Bean(semmcp001Bean);
	}
	
	private void setRentalType() {
		semmcp001Bean = getSemmcp001Bean();
		String rentalType = semmcp001Bean.getContractCheckDoc().getRentalType();
		if(rentalType != null){
			if(rentalType.equals("01")){
				this.setRentalType1();
				this.clearRentalType2();
				this.clearRentalType3();
				this.clearRentalType4();
				this.clearRentalType5();
				this.clearRentalType6();
				this.clearRentalType7();
				this.clearRentalType8();
			}else if(rentalType.equals("02")){
				this.setRentalType2();
				this.clearRentalType1();
				this.clearRentalType3();
				this.clearRentalType4();
				this.clearRentalType5();
				this.clearRentalType6();
				this.clearRentalType7();
				this.clearRentalType8();
			}else if(rentalType.equals("03")){
				this.setRentalType3();
				this.clearRentalType1();
				this.clearRentalType2();
				this.clearRentalType4();
				this.clearRentalType5();
				this.clearRentalType6();
				this.clearRentalType7();
				this.clearRentalType8();
			}else if(rentalType.equals("04")){
				this.setRentalType4();
				this.clearRentalType1();
				this.clearRentalType2();
				this.clearRentalType3();
				this.clearRentalType5();
				this.clearRentalType6();
				this.clearRentalType7();
				this.clearRentalType8();
			}else if(rentalType.equals("05")){
				this.setRentalType5();
				this.clearRentalType1();
				this.clearRentalType2();
				this.clearRentalType3();
				this.clearRentalType4();
				this.clearRentalType6();
				this.clearRentalType7();
				this.clearRentalType8();
			}else if(rentalType.equals("06")){
				this.setRentalType6();
				this.clearRentalType1();
				this.clearRentalType2();
				this.clearRentalType3();
				this.clearRentalType4();
				this.clearRentalType5();
				this.clearRentalType7();
				this.clearRentalType8();
			}if(rentalType.equals("07")){
				this.setRentalType8();
				this.clearRentalType1();
				this.clearRentalType2();
				this.clearRentalType3();
				this.clearRentalType4();
				this.clearRentalType5();
				this.clearRentalType7();
			}else if(rentalType.equals("99")){
				this.setRentalType7();
				this.clearRentalType1();
				this.clearRentalType2();
				this.clearRentalType3();
				this.clearRentalType4();
				this.clearRentalType5();
				this.clearRentalType6();
				this.clearRentalType8();
				
			}else if(semmcp001Bean.getRentalType99() != null && semmcp001Bean.getRentalType99().equals("99")){
				this.setRentalType7();
			}
		}
		setSemmcp001Bean(semmcp001Bean);
	}
	
	private void setRentalType1() {
		semmcp001Bean = getSemmcp001Bean();
		ContractCheckDoc doc = semmcp001Bean.getContractCheckDoc();
		if(doc.getDoc11() != null && doc.getDoc11().equals("Y")){
			semmcp001Bean.setChkDoc111(true);
		}else{
			semmcp001Bean.setChkDoc111(false);
		}
		if(doc.getDoc12() != null && doc.getDoc12().equals("Y")){
			semmcp001Bean.setChkDoc112(true);
		}else{
			semmcp001Bean.setChkDoc112(false);
		}
		if(doc.getDoc21() != null && doc.getDoc21().equals("Y")){
			semmcp001Bean.setChkDoc121(true);
		}else{
			semmcp001Bean.setChkDoc121(false);
		}
		if(doc.getDoc22() != null && doc.getDoc22().equals("Y")){
			semmcp001Bean.setChkDoc122(true);
		}else{
			semmcp001Bean.setChkDoc122(false);
		}
		if(doc.getDoc31() != null && doc.getDoc31().equals("Y")){
			semmcp001Bean.setChkDoc131(true);
		}else{
			semmcp001Bean.setChkDoc131(false);
		}
		if(doc.getDoc32() != null && doc.getDoc32().equals("Y")){
			semmcp001Bean.setChkDoc132(true);
		}else{
			semmcp001Bean.setChkDoc132(false);
		}
		if(doc.getDoc41() != null && doc.getDoc41().equals("Y")){
			semmcp001Bean.setChkDoc141(true);
		}else{
			semmcp001Bean.setChkDoc141(false);
		}
		if(doc.getDoc42() != null && doc.getDoc42().equals("Y")){
			semmcp001Bean.setChkDoc142(true);
		}else{
			semmcp001Bean.setChkDoc142(false);
		}
		if(doc.getDoc51() != null && doc.getDoc51().equals("Y")){
			semmcp001Bean.setChkDoc151(true);
		}else{
			semmcp001Bean.setChkDoc151(false);
		}
		if(doc.getDoc52() != null && doc.getDoc52().equals("Y")){
			semmcp001Bean.setChkDoc152(true);
		}else{
			semmcp001Bean.setChkDoc152(false);
		}
		
		if(doc.getDoc61() != null && doc.getDoc61().equals("Y")){
			semmcp001Bean.setChkDoc161(true);
		}else{
			semmcp001Bean.setChkDoc161(false);
		}
		if(doc.getDoc62() != null && doc.getDoc62().equals("Y")){
			semmcp001Bean.setChkDoc162(true);
		}else{
			semmcp001Bean.setChkDoc162(false);
		}
		if(doc.getDoc71() != null && doc.getDoc71().equals("Y")){
			semmcp001Bean.setChkDoc171(true);
		}else{
			semmcp001Bean.setChkDoc171(false);
		}
		if(doc.getDoc72() != null && doc.getDoc72().equals("Y")){
			semmcp001Bean.setChkDoc172(true);
		}else{
			semmcp001Bean.setChkDoc172(false);
		}
		if(doc.getDoc81() != null && doc.getDoc81().equals("Y")){
			semmcp001Bean.setChkDoc181(true);
		}else{
			semmcp001Bean.setChkDoc181(false);
		}
		if(doc.getDoc82() != null && doc.getDoc82().equals("Y")){
			semmcp001Bean.setChkDoc182(true);
		}else{
			semmcp001Bean.setChkDoc182(false);
		}
		
		if(doc.getDocOther1() != null && doc.getDocOther1().equals("Y")){
			semmcp001Bean.setChkDoc191(true);
		}else{
			semmcp001Bean.setChkDoc191(false);
		}
		if(doc.getDocOther2() != null && doc.getDocOther2().equals("Y")){
			semmcp001Bean.setChkDoc192(true);
		}else{
			semmcp001Bean.setChkDoc192(false);
		}
		if(doc.getDocOtherRemark() != null){
			semmcp001Bean.setRentalOtherRemark1(doc.getDocOtherRemark());
		}
		setSemmcp001Bean(semmcp001Bean);
	}
	
	private void setRentalType2() {
		semmcp001Bean = getSemmcp001Bean();
		ContractCheckDoc doc = semmcp001Bean.getContractCheckDoc();
		if(doc.getDoc11() != null && doc.getDoc11().equals("Y")){
			semmcp001Bean.setChkDoc211(true);
		}else{
			semmcp001Bean.setChkDoc211(false);
		}
		if(doc.getDoc12() != null && doc.getDoc12().equals("Y")){
			semmcp001Bean.setChkDoc212(true);
		}else{
			semmcp001Bean.setChkDoc212(false);
		}
		if(doc.getDoc21() != null && doc.getDoc21().equals("Y")){
			semmcp001Bean.setChkDoc221(true);
		}else{
			semmcp001Bean.setChkDoc221(false);
		}
		if(doc.getDoc22() != null && doc.getDoc22().equals("Y")){
			semmcp001Bean.setChkDoc222(true);
		}else{
			semmcp001Bean.setChkDoc222(false);
		}
		if(doc.getDoc31() != null && doc.getDoc31().equals("Y")){
			semmcp001Bean.setChkDoc231(true);
		}else{
			semmcp001Bean.setChkDoc231(false);
		}
		if(doc.getDoc32() != null && doc.getDoc32().equals("Y")){
			semmcp001Bean.setChkDoc232(true);
		}else{
			semmcp001Bean.setChkDoc232(false);
		}
		if(doc.getDoc41() != null && doc.getDoc41().equals("Y")){
			semmcp001Bean.setChkDoc241(true);
		}else{
			semmcp001Bean.setChkDoc241(false);
		}
		if(doc.getDoc42() != null && doc.getDoc42().equals("Y")){
			semmcp001Bean.setChkDoc242(true);
		}else{
			semmcp001Bean.setChkDoc242(false);
		}
		if(doc.getDoc51() != null && doc.getDoc51().equals("Y")){
			semmcp001Bean.setChkDoc251(true);
		}else{
			semmcp001Bean.setChkDoc251(false);
		}
		if(doc.getDoc52() != null && doc.getDoc52().equals("Y")){
			semmcp001Bean.setChkDoc252(true);
		}else{
			semmcp001Bean.setChkDoc252(false);
		}
		if(doc.getDoc61() != null && doc.getDoc61().equals("Y")){
			semmcp001Bean.setChkDoc261(true);
		}else{
			semmcp001Bean.setChkDoc261(false);
		}
		if(doc.getDoc62() != null && doc.getDoc62().equals("Y")){
			semmcp001Bean.setChkDoc262(true);
		}else{
			semmcp001Bean.setChkDoc262(false);
		}
		if(doc.getDoc71() != null && doc.getDoc71().equals("Y")){
			semmcp001Bean.setChkDoc271(true);
		}else{
			semmcp001Bean.setChkDoc271(false);
		}
		if(doc.getDoc72() != null && doc.getDoc72().equals("Y")){
			semmcp001Bean.setChkDoc272(true);
		}else{
			semmcp001Bean.setChkDoc272(false);
		}
		if(doc.getDocOther1() != null && doc.getDocOther1().equals("Y")){
			semmcp001Bean.setChkDoc281(true);
		}else{
			semmcp001Bean.setChkDoc281(false);
		}
		if(doc.getDocOther2() != null && doc.getDocOther2().equals("Y")){
			semmcp001Bean.setChkDoc282(true);
		}else{
			semmcp001Bean.setChkDoc282(false);
		}
		if(doc.getDocOtherRemark() != null){
			semmcp001Bean.setRentalOtherRemark2(doc.getDocOtherRemark());
		}
		setSemmcp001Bean(semmcp001Bean);
		
	}
	private void setRentalType3() {
		semmcp001Bean = getSemmcp001Bean();
		ContractCheckDoc doc = semmcp001Bean.getContractCheckDoc();
		if(doc.getDoc11() != null && doc.getDoc11().equals("Y")){
			semmcp001Bean.setChkDoc311(true);
		}else{
			semmcp001Bean.setChkDoc311(false);
		}
		if(doc.getDoc12() != null && doc.getDoc12().equals("Y")){
			semmcp001Bean.setChkDoc312(true);
		}else{
			semmcp001Bean.setChkDoc312(false);
		}
		if(doc.getDoc21() != null && doc.getDoc21().equals("Y")){
			semmcp001Bean.setChkDoc321(true);
		}else{
			semmcp001Bean.setChkDoc321(false);
		}
		if(doc.getDoc22() != null && doc.getDoc22().equals("Y")){
			semmcp001Bean.setChkDoc322(true);
		}else{
			semmcp001Bean.setChkDoc322(false);
		}
		if(doc.getDoc31() != null && doc.getDoc31().equals("Y")){
			semmcp001Bean.setChkDoc331(true);
		}else{
			semmcp001Bean.setChkDoc331(false);
		}
		if(doc.getDoc32() != null && doc.getDoc32().equals("Y")){
			semmcp001Bean.setChkDoc332(true);
		}else{
			semmcp001Bean.setChkDoc332(false);
		}
		if(doc.getDoc41() != null && doc.getDoc41().equals("Y")){
			semmcp001Bean.setChkDoc341(true);
		}else{
			semmcp001Bean.setChkDoc341(false);
		}
		if(doc.getDoc42() != null && doc.getDoc42().equals("Y")){
			semmcp001Bean.setChkDoc342(true);
		}else{
			semmcp001Bean.setChkDoc342(false);
		}
		if(doc.getDoc51() != null && doc.getDoc51().equals("Y")){
			semmcp001Bean.setChkDoc351(true);
		}else{
			semmcp001Bean.setChkDoc351(false);
		}
		if(doc.getDoc52() != null && doc.getDoc52().equals("Y")){
			semmcp001Bean.setChkDoc352(true);
		}else{
			semmcp001Bean.setChkDoc352(false);
		}
		if(doc.getDoc61() != null && doc.getDoc61().equals("Y")){
			semmcp001Bean.setChkDoc361(true);
		}else{
			semmcp001Bean.setChkDoc361(false);
		}
		if(doc.getDoc62() != null && doc.getDoc62().equals("Y")){
			semmcp001Bean.setChkDoc362(true);
		}else{
			semmcp001Bean.setChkDoc362(false);
		}
		if(doc.getDoc71() != null && doc.getDoc71().equals("Y")){
			semmcp001Bean.setChkDoc371(true);
		}else{
			semmcp001Bean.setChkDoc371(false);
		}
		if(doc.getDoc72() != null && doc.getDoc72().equals("Y")){
			semmcp001Bean.setChkDoc372(true);
		}else{
			semmcp001Bean.setChkDoc372(false);
		}
		if(doc.getDoc81() != null && doc.getDoc81().equals("Y")){
			semmcp001Bean.setChkDoc381(true);
		}else{
			semmcp001Bean.setChkDoc381(false);
		}
		if(doc.getDoc82() != null && doc.getDoc82().equals("Y")){
			semmcp001Bean.setChkDoc382(true);
		}else{
			semmcp001Bean.setChkDoc382(false);
		}
		if(doc.getDocOther1() != null && doc.getDocOther1().equals("Y")){
			semmcp001Bean.setChkDoc391(true);
		}else{
			semmcp001Bean.setChkDoc391(false);
		}
		if(doc.getDocOther2() != null && doc.getDocOther2().equals("Y")){
			semmcp001Bean.setChkDoc392(true);
		}else{
			semmcp001Bean.setChkDoc392(false);
		}
		if(doc.getDocOtherRemark() != null){
			semmcp001Bean.setRentalOtherRemark3(doc.getDocOtherRemark());
		}
		setSemmcp001Bean(semmcp001Bean);
	}
	
	private void setRentalType4() {
		semmcp001Bean = getSemmcp001Bean();
		ContractCheckDoc doc = semmcp001Bean.getContractCheckDoc();
		if(doc.getDoc11() != null && doc.getDoc11().equals("Y")){
			semmcp001Bean.setChkDoc411(true);
		}else{
			semmcp001Bean.setChkDoc411(false);
		}
		if(doc.getDoc12() != null && doc.getDoc12().equals("Y")){
			semmcp001Bean.setChkDoc412(true);
		}else{
			semmcp001Bean.setChkDoc412(false);
		}
		if(doc.getDoc21() != null && doc.getDoc21().equals("Y")){
			semmcp001Bean.setChkDoc421(true);
		}else{
			semmcp001Bean.setChkDoc421(false);
		}
		if(doc.getDoc22() != null && doc.getDoc22().equals("Y")){
			semmcp001Bean.setChkDoc422(true);
		}else{
			semmcp001Bean.setChkDoc422(false);
		}
		if(doc.getDoc31() != null && doc.getDoc31().equals("Y")){
			semmcp001Bean.setChkDoc431(true);
		}else{
			semmcp001Bean.setChkDoc431(false);
		}
		if(doc.getDoc32() != null && doc.getDoc32().equals("Y")){
			semmcp001Bean.setChkDoc432(true);
		}else{
			semmcp001Bean.setChkDoc432(false);
		}
		if(doc.getDoc41() != null && doc.getDoc41().equals("Y")){
			semmcp001Bean.setChkDoc441(true);
		}else{
			semmcp001Bean.setChkDoc441(false);
		}
		if(doc.getDoc42() != null && doc.getDoc42().equals("Y")){
			semmcp001Bean.setChkDoc442(true);
		}else{
			semmcp001Bean.setChkDoc442(false);
		}
		if(doc.getDoc51() != null && doc.getDoc51().equals("Y")){
			semmcp001Bean.setChkDoc451(true);
		}else{
			semmcp001Bean.setChkDoc451(false);
		}
		if(doc.getDoc52() != null && doc.getDoc52().equals("Y")){
			semmcp001Bean.setChkDoc452(true);
		}else{
			semmcp001Bean.setChkDoc452(false);
		}
		if(doc.getDoc61() != null && doc.getDoc61().equals("Y")){
			semmcp001Bean.setChkDoc461(true);
		}else{
			semmcp001Bean.setChkDoc461(false);
		}
		if(doc.getDoc62() != null && doc.getDoc62().equals("Y")){
			semmcp001Bean.setChkDoc462(true);
		}else{
			semmcp001Bean.setChkDoc462(false);
		}
		if(doc.getDoc71() != null && doc.getDoc71().equals("Y")){
			semmcp001Bean.setChkDoc471(true);
		}else{
			semmcp001Bean.setChkDoc471(false);
		}
		if(doc.getDoc72() != null && doc.getDoc72().equals("Y")){
			semmcp001Bean.setChkDoc472(true);
		}else{
			semmcp001Bean.setChkDoc472(false);
		}
		if(doc.getDoc81() != null && doc.getDoc81().equals("Y")){
			semmcp001Bean.setChkDoc481(true);
		}else{
			semmcp001Bean.setChkDoc481(false);
		}
		if(doc.getDoc82() != null && doc.getDoc82().equals("Y")){
			semmcp001Bean.setChkDoc482(true);
		}else{
			semmcp001Bean.setChkDoc482(false);
		}
		if(doc.getDoc91() != null && doc.getDoc91().equals("Y")){
			semmcp001Bean.setChkDoc491(true);
		}else{
			semmcp001Bean.setChkDoc491(false);
		}
		if(doc.getDoc92() != null && doc.getDoc92().equals("Y")){
			semmcp001Bean.setChkDoc492(true);
		}else{
			semmcp001Bean.setChkDoc492(false);
		}
		if(doc.getDocOther1() != null && doc.getDocOther1().equals("Y")){
			semmcp001Bean.setChkDoc4101(true);
		}else{
			semmcp001Bean.setChkDoc4101(false);
		}
		if(doc.getDocOther2() != null && doc.getDocOther2().equals("Y")){
			semmcp001Bean.setChkDoc4102(true);
		}else{
			semmcp001Bean.setChkDoc4102(false);
		}
		if(doc.getDocOtherRemark() != null){
			semmcp001Bean.setRentalOtherRemark4(doc.getDocOtherRemark());
		}
		setSemmcp001Bean(semmcp001Bean);
	}
	
	private void setRentalType5() {
		semmcp001Bean = getSemmcp001Bean();
		ContractCheckDoc doc = semmcp001Bean.getContractCheckDoc();
		if(doc.getDoc11() != null && doc.getDoc11().equals("Y")){
			semmcp001Bean.setChkDoc511(true);
		}else{
			semmcp001Bean.setChkDoc511(false);
		}
		if(doc.getDoc12() != null && doc.getDoc12().equals("Y")){
			semmcp001Bean.setChkDoc512(true);
		}else{
			semmcp001Bean.setChkDoc512(false);
		}
		if(doc.getDoc21() != null && doc.getDoc21().equals("Y")){
			semmcp001Bean.setChkDoc521(true);
		}else{
			semmcp001Bean.setChkDoc521(false);
		}
		if(doc.getDoc22() != null && doc.getDoc22().equals("Y")){
			semmcp001Bean.setChkDoc522(true);
		}else{
			semmcp001Bean.setChkDoc522(false);
		}
		if(doc.getDoc31() != null && doc.getDoc31().equals("Y")){
			semmcp001Bean.setChkDoc531(true);
		}else{
			semmcp001Bean.setChkDoc531(false);
		}
		if(doc.getDoc32() != null && doc.getDoc32().equals("Y")){
			semmcp001Bean.setChkDoc532(true);
		}else{
			semmcp001Bean.setChkDoc532(false);
		}
		if(doc.getDoc41() != null && doc.getDoc41().equals("Y")){
			semmcp001Bean.setChkDoc541(true);
		}else{
			semmcp001Bean.setChkDoc541(false);
		}
		if(doc.getDoc42() != null && doc.getDoc42().equals("Y")){
			semmcp001Bean.setChkDoc542(true);
		}else{
			semmcp001Bean.setChkDoc542(false);
		}
		if(doc.getDoc51() != null && doc.getDoc51().equals("Y")){
			semmcp001Bean.setChkDoc551(true);
		}else{
			semmcp001Bean.setChkDoc551(false);
		}
		if(doc.getDoc52() != null && doc.getDoc52().equals("Y")){
			semmcp001Bean.setChkDoc552(true);
		}else{
			semmcp001Bean.setChkDoc552(false);
		}
		if(doc.getDoc61() != null && doc.getDoc61().equals("Y")){
			semmcp001Bean.setChkDoc561(true);
		}else{
			semmcp001Bean.setChkDoc561(false);
		}
		if(doc.getDoc62() != null && doc.getDoc62().equals("Y")){
			semmcp001Bean.setChkDoc562(true);
		}else{
			semmcp001Bean.setChkDoc562(false);
		}
		if(doc.getDoc71() != null && doc.getDoc71().equals("Y")){
			semmcp001Bean.setChkDoc571(true);
		}else{
			semmcp001Bean.setChkDoc571(false);
		}
		if(doc.getDoc72() != null && doc.getDoc72().equals("Y")){
			semmcp001Bean.setChkDoc572(true);
		}else{
			semmcp001Bean.setChkDoc572(false);
		}
		if(doc.getDoc81() != null && doc.getDoc81().equals("Y")){
			semmcp001Bean.setChkDoc581(true);
		}else{
			semmcp001Bean.setChkDoc581(false);
		}
		if(doc.getDoc82() != null && doc.getDoc82().equals("Y")){
			semmcp001Bean.setChkDoc582(true);
		}else{
			semmcp001Bean.setChkDoc582(false);
		}
		if(doc.getDocOther1() != null && doc.getDocOther1().equals("Y")){
			semmcp001Bean.setChkDoc591(true);
		}else{
			semmcp001Bean.setChkDoc591(false);
		}
		if(doc.getDocOther2() != null && doc.getDocOther2().equals("Y")){
			semmcp001Bean.setChkDoc592(true);
		}else{
			semmcp001Bean.setChkDoc592(false);
		}
		if(doc.getDocOtherRemark() != null){
			semmcp001Bean.setRentalOtherRemark5(doc.getDocOtherRemark());
		}
		setSemmcp001Bean(semmcp001Bean);
	}
	
	private void setRentalType6() {
		semmcp001Bean = getSemmcp001Bean();
		ContractCheckDoc doc = semmcp001Bean.getContractCheckDoc();
		if(doc.getDoc11() != null && doc.getDoc11().equals("Y")){
			semmcp001Bean.setChkDoc611(true);
		}else{
			semmcp001Bean.setChkDoc611(false);
		}
		if(doc.getDoc12() != null && doc.getDoc12().equals("Y")){
			semmcp001Bean.setChkDoc612(true);
		}else{
			semmcp001Bean.setChkDoc612(false);
		}
		if(doc.getDoc21() != null && doc.getDoc21().equals("Y")){
			semmcp001Bean.setChkDoc621(true);
		}else{
			semmcp001Bean.setChkDoc621(false);
		}
		if(doc.getDoc22() != null && doc.getDoc22().equals("Y")){
			semmcp001Bean.setChkDoc622(true);
		}else{
			semmcp001Bean.setChkDoc622(false);
		}
		if(doc.getDoc31() != null && doc.getDoc31().equals("Y")){
			semmcp001Bean.setChkDoc631(true);
		}else{
			semmcp001Bean.setChkDoc631(false);
		}
		if(doc.getDoc32() != null && doc.getDoc32().equals("Y")){
			semmcp001Bean.setChkDoc632(true);
		}else{
			semmcp001Bean.setChkDoc632(false);
		}
		if(doc.getDoc41() != null && doc.getDoc41().equals("Y")){
			semmcp001Bean.setChkDoc641(true);
		}else{
			semmcp001Bean.setChkDoc641(false);
		}
		if(doc.getDoc42() != null && doc.getDoc42().equals("Y")){
			semmcp001Bean.setChkDoc642(true);
		}else{
			semmcp001Bean.setChkDoc642(false);
		}
		if(doc.getDoc51() != null && doc.getDoc51().equals("Y")){
			semmcp001Bean.setChkDoc651(true);
		}else{
			semmcp001Bean.setChkDoc651(false);
		}
		if(doc.getDoc52() != null && doc.getDoc52().equals("Y")){
			semmcp001Bean.setChkDoc652(true);
		}else{
			semmcp001Bean.setChkDoc652(false);
		}
		if(doc.getDoc61() != null && doc.getDoc61().equals("Y")){
			semmcp001Bean.setChkDoc661(true);
		}else{
			semmcp001Bean.setChkDoc661(false);
		}
		if(doc.getDoc62() != null && doc.getDoc62().equals("Y")){
			semmcp001Bean.setChkDoc662(true);
		}else{
			semmcp001Bean.setChkDoc662(false);
		}
		if(doc.getDoc71() != null && doc.getDoc71().equals("Y")){
			semmcp001Bean.setChkDoc671(true);
		}else{
			semmcp001Bean.setChkDoc671(false);
		}
		if(doc.getDoc72() != null && doc.getDoc72().equals("Y")){
			semmcp001Bean.setChkDoc672(true);
		}else{
			semmcp001Bean.setChkDoc672(false);
		}
		if(doc.getDoc81() != null && doc.getDoc81().equals("Y")){
			semmcp001Bean.setChkDoc681(true);
		}else{
			semmcp001Bean.setChkDoc681(false);
		}
		if(doc.getDoc82() != null && doc.getDoc82().equals("Y")){
			semmcp001Bean.setChkDoc682(true);
		}else{
			semmcp001Bean.setChkDoc682(false);
		}
		if(doc.getDocOther1() != null && doc.getDocOther1().equals("Y")){
			semmcp001Bean.setChkDoc691(true);
		}else{
			semmcp001Bean.setChkDoc691(false);
		}
		if(doc.getDocOther2() != null && doc.getDocOther2().equals("Y")){
			semmcp001Bean.setChkDoc692(true);
		}else{
			semmcp001Bean.setChkDoc692(false);
		}
		if(doc.getDocOtherRemark() != null){
			semmcp001Bean.setRentalOtherRemark6(doc.getDocOtherRemark());
		}
		setSemmcp001Bean(semmcp001Bean);
	}
	
	private void setRentalType7() {
		semmcp001Bean = getSemmcp001Bean();
		ContractCheckDoc doc = semmcp001Bean.getContractCheckDoc();
		if(doc.getDoc11() != null && doc.getDoc11().equals("Y")){
			semmcp001Bean.setChkDoc711(true);
		}else{
			semmcp001Bean.setChkDoc711(false);
		}
		if(doc.getDoc12() != null && doc.getDoc12().equals("Y")){
			semmcp001Bean.setChkDoc712(true);
		}else{
			semmcp001Bean.setChkDoc712(false);
		}
		if(doc.getDoc21() != null && doc.getDoc21().equals("Y")){
			semmcp001Bean.setChkDoc721(true);
		}else{
			semmcp001Bean.setChkDoc721(false);
		}
		if(doc.getDoc22() != null && doc.getDoc22().equals("Y")){
			semmcp001Bean.setChkDoc722(true);
		}else{
			semmcp001Bean.setChkDoc722(false);
		}
		if(doc.getDoc31() != null && doc.getDoc31().equals("Y")){
			semmcp001Bean.setChkDoc731(true);
		}else{
			semmcp001Bean.setChkDoc731(false);
		}
		if(doc.getDoc32() != null && doc.getDoc32().equals("Y")){
			semmcp001Bean.setChkDoc732(true);
		}else{
			semmcp001Bean.setChkDoc732(false);
		}
		if(doc.getDoc41() != null && doc.getDoc41().equals("Y")){
			semmcp001Bean.setChkDoc741(true);
		}else{
			semmcp001Bean.setChkDoc741(false);
		}
		if(doc.getDoc42() != null && doc.getDoc42().equals("Y")){
			semmcp001Bean.setChkDoc742(true);
		}else{
			semmcp001Bean.setChkDoc742(false);
		}
		if(doc.getDoc51() != null && doc.getDoc51().equals("Y")){
			semmcp001Bean.setChkDoc751(true);
		}else{
			semmcp001Bean.setChkDoc751(false);
		}
		if(doc.getDoc52() != null && doc.getDoc52().equals("Y")){
			semmcp001Bean.setChkDoc752(true);
		}else{
			semmcp001Bean.setChkDoc752(false);
		}
		if(doc.getDoc61() != null && doc.getDoc61().equals("Y")){
			semmcp001Bean.setChkDoc761(true);
		}else{
			semmcp001Bean.setChkDoc761(false);
		}
		if(doc.getDoc62() != null && doc.getDoc62().equals("Y")){
			semmcp001Bean.setChkDoc762(true);
		}else{
			semmcp001Bean.setChkDoc762(false);
		}
		if(doc.getDoc71() != null && doc.getDoc71().equals("Y")){
			semmcp001Bean.setChkDoc771(true);
		}else{
			semmcp001Bean.setChkDoc771(false);
		}
		if(doc.getDoc72() != null && doc.getDoc72().equals("Y")){
			semmcp001Bean.setChkDoc772(true);
		}else{
			semmcp001Bean.setChkDoc772(false);
		}
		if(doc.getDoc81() != null && doc.getDoc81().equals("Y")){
			semmcp001Bean.setChkDoc781(true);
		}else{
			semmcp001Bean.setChkDoc781(false);
		}
		if(doc.getDoc82() != null && doc.getDoc82().equals("Y")){
			semmcp001Bean.setChkDoc782(true);
		}else{
			semmcp001Bean.setChkDoc782(false);
		}
		if(doc.getDoc91() != null && doc.getDoc91().equals("Y")){
			semmcp001Bean.setChkDoc791(true);
		}else{
			semmcp001Bean.setChkDoc791(false);
		}
		if(doc.getDoc92() != null && doc.getDoc92().equals("Y")){
			semmcp001Bean.setChkDoc792(true);
		}else{
			semmcp001Bean.setChkDoc792(false);
		}
		if(doc.getDoc101() != null && doc.getDoc101().equals("Y")){
			semmcp001Bean.setChkDoc7101(true);
		}else{
			semmcp001Bean.setChkDoc7101(false);
		}
		if(doc.getDoc102() != null && doc.getDoc102().equals("Y")){
			semmcp001Bean.setChkDoc7102(true);
		}else{
			semmcp001Bean.setChkDoc7102(false);
		}
		if(doc.getDocOther1() != null && doc.getDocOther1().equals("Y")){
			semmcp001Bean.setChkDoc7111(true);
		}else{
			semmcp001Bean.setChkDoc7111(false);
		}
		if(doc.getDocOther2() != null && doc.getDocOther2().equals("Y")){
			semmcp001Bean.setChkDoc7112(true);
		}else{
			semmcp001Bean.setChkDoc7112(false);
		}
		if(doc.getDocOtherRemark() != null){
			semmcp001Bean.setRentalOtherRemark7(doc.getDocOtherRemark());
		}
		
		
		setSemmcp001Bean(semmcp001Bean);
	}

	
	private void setRentalType8() {
		semmcp001Bean = getSemmcp001Bean();
		ContractCheckDoc doc = semmcp001Bean.getContractCheckDoc();
		
		if(doc.getDoc11() != null && doc.getDoc11().equals("Y")){
			semmcp001Bean.setChkDoc811(true);
		}else{
			semmcp001Bean.setChkDoc811(false);
		}
		if(doc.getDoc12() != null && doc.getDoc12().equals("Y")){
			semmcp001Bean.setChkDoc812(true);
		}else{
			semmcp001Bean.setChkDoc812(false);
		}
		if(doc.getDoc21() != null && doc.getDoc21().equals("Y")){
			semmcp001Bean.setChkDoc821(true);
		}else{
			semmcp001Bean.setChkDoc821(false);
		}
		if(doc.getDoc22() != null && doc.getDoc22().equals("Y")){
			semmcp001Bean.setChkDoc822(true);
		}else{
			semmcp001Bean.setChkDoc822(false);
		}
		if(doc.getDoc31() != null && doc.getDoc31().equals("Y")){
			semmcp001Bean.setChkDoc831(true);
		}else{
			semmcp001Bean.setChkDoc831(false);
		}
		if(doc.getDoc32() != null && doc.getDoc32().equals("Y")){
			semmcp001Bean.setChkDoc832(true);
		}else{
			semmcp001Bean.setChkDoc832(false);
		}
		if(doc.getDoc41() != null && doc.getDoc41().equals("Y")){
			semmcp001Bean.setChkDoc841(true);
		}else{
			semmcp001Bean.setChkDoc841(false);
		}
		if(doc.getDoc42() != null && doc.getDoc42().equals("Y")){
			semmcp001Bean.setChkDoc842(true);
		}else{
			semmcp001Bean.setChkDoc842(false);
		}
		if(doc.getDocOther1() != null && doc.getDocOther1().equals("Y")){
			semmcp001Bean.setChkDoc851(true);
		}else{
			semmcp001Bean.setChkDoc851(false);
		}
		if(doc.getDocOther2() != null && doc.getDocOther2().equals("Y")){
			semmcp001Bean.setChkDoc852(true);
		}else{
			semmcp001Bean.setChkDoc852(false);
		}
		if(doc.getDocOtherRemark() != null){
			semmcp001Bean.setRentalOtherRemark8(doc.getDocOtherRemark());
		}
		setSemmcp001Bean(semmcp001Bean);
	}
	
	private void clearRentalType1() {
		semmcp001Bean = getSemmcp001Bean();
		semmcp001Bean.setChkDoc111(false);
		semmcp001Bean.setChkDoc112(false);
		semmcp001Bean.setChkDoc121(false);
		semmcp001Bean.setChkDoc122(false);
		semmcp001Bean.setChkDoc131(false);
		semmcp001Bean.setChkDoc132(false);
		semmcp001Bean.setChkDoc141(false);
		semmcp001Bean.setChkDoc142(false);
		semmcp001Bean.setChkDoc151(false);
		semmcp001Bean.setChkDoc152(false);
		semmcp001Bean.setChkDoc161(false);
		semmcp001Bean.setChkDoc162(false);
		semmcp001Bean.setChkDoc171(false);
		semmcp001Bean.setChkDoc172(false);
		semmcp001Bean.setChkDoc181(false);
		semmcp001Bean.setChkDoc182(false);
		semmcp001Bean.setChkDoc191(false);
		semmcp001Bean.setChkDoc192(false);
		semmcp001Bean.setRentalOtherRemark1("");
		setSemmcp001Bean(semmcp001Bean);
	}
	
	private void clearRentalType2() {
		semmcp001Bean = getSemmcp001Bean();
		semmcp001Bean.setChkDoc211(false);
		semmcp001Bean.setChkDoc212(false);
		semmcp001Bean.setChkDoc221(false);
		semmcp001Bean.setChkDoc222(false);
		semmcp001Bean.setChkDoc231(false);
		semmcp001Bean.setChkDoc232(false);
		semmcp001Bean.setChkDoc241(false);
		semmcp001Bean.setChkDoc242(false);
		semmcp001Bean.setChkDoc251(false);
		semmcp001Bean.setChkDoc252(false);
		semmcp001Bean.setChkDoc261(false);
		semmcp001Bean.setChkDoc262(false);
		semmcp001Bean.setChkDoc271(false);
		semmcp001Bean.setChkDoc272(false);
		semmcp001Bean.setChkDoc281(false);
		semmcp001Bean.setChkDoc282(false);
		semmcp001Bean.setRentalOtherRemark2("");
		setSemmcp001Bean(semmcp001Bean);
		
	}
	
	private void clearRentalType3() {
		semmcp001Bean = getSemmcp001Bean();
		semmcp001Bean.setChkDoc311(false);
		semmcp001Bean.setChkDoc312(false);
		semmcp001Bean.setChkDoc321(false);
		semmcp001Bean.setChkDoc322(false);
		semmcp001Bean.setChkDoc331(false);
		semmcp001Bean.setChkDoc332(false);
		semmcp001Bean.setChkDoc341(false);
		semmcp001Bean.setChkDoc342(false);
		semmcp001Bean.setChkDoc351(false);
		semmcp001Bean.setChkDoc352(false);
		semmcp001Bean.setChkDoc361(false);
		semmcp001Bean.setChkDoc362(false);
		semmcp001Bean.setChkDoc371(false);
		semmcp001Bean.setChkDoc372(false);
		semmcp001Bean.setChkDoc381(false);
		semmcp001Bean.setChkDoc382(false);
		semmcp001Bean.setChkDoc391(false);
		semmcp001Bean.setChkDoc392(false);
		semmcp001Bean.setRentalOtherRemark3("");
		setSemmcp001Bean(semmcp001Bean);
		
	}
	
	private void clearRentalType4() {
		semmcp001Bean = getSemmcp001Bean();
		semmcp001Bean.setChkDoc411(false);
		semmcp001Bean.setChkDoc412(false);
		semmcp001Bean.setChkDoc421(false);
		semmcp001Bean.setChkDoc422(false);
		semmcp001Bean.setChkDoc431(false);
		semmcp001Bean.setChkDoc432(false);
		semmcp001Bean.setChkDoc441(false);
		semmcp001Bean.setChkDoc442(false);
		semmcp001Bean.setChkDoc451(false);
		semmcp001Bean.setChkDoc452(false);
		semmcp001Bean.setChkDoc461(false);
		semmcp001Bean.setChkDoc462(false);
		semmcp001Bean.setChkDoc471(false);
		semmcp001Bean.setChkDoc472(false);
		semmcp001Bean.setChkDoc481(false);
		semmcp001Bean.setChkDoc482(false);
		semmcp001Bean.setChkDoc491(false);
		semmcp001Bean.setChkDoc492(false);
		semmcp001Bean.setChkDoc4101(false);
		semmcp001Bean.setChkDoc4102(false);
		semmcp001Bean.setRentalOtherRemark4("");
		setSemmcp001Bean(semmcp001Bean);
		
	}
	
	private void clearRentalType5() {
		semmcp001Bean = getSemmcp001Bean();
		semmcp001Bean.setChkDoc511(false);
		semmcp001Bean.setChkDoc512(false);
		semmcp001Bean.setChkDoc521(false);
		semmcp001Bean.setChkDoc522(false);
		semmcp001Bean.setChkDoc531(false);
		semmcp001Bean.setChkDoc532(false);
		semmcp001Bean.setChkDoc541(false);
		semmcp001Bean.setChkDoc542(false);
		semmcp001Bean.setChkDoc551(false);
		semmcp001Bean.setChkDoc552(false);
		semmcp001Bean.setChkDoc561(false);
		semmcp001Bean.setChkDoc562(false);
		semmcp001Bean.setChkDoc571(false);
		semmcp001Bean.setChkDoc572(false);
		semmcp001Bean.setChkDoc581(false);
		semmcp001Bean.setChkDoc582(false);
		semmcp001Bean.setChkDoc591(false);
		semmcp001Bean.setChkDoc592(false);
		semmcp001Bean.setRentalOtherRemark5("");
		setSemmcp001Bean(semmcp001Bean);
		
	}
	
	private void clearRentalType6() {
		semmcp001Bean = getSemmcp001Bean();
		semmcp001Bean.setChkDoc611(false);
		semmcp001Bean.setChkDoc612(false);
		semmcp001Bean.setChkDoc621(false);
		semmcp001Bean.setChkDoc622(false);
		semmcp001Bean.setChkDoc631(false);
		semmcp001Bean.setChkDoc632(false);
		semmcp001Bean.setChkDoc641(false);
		semmcp001Bean.setChkDoc642(false);
		semmcp001Bean.setChkDoc651(false);
		semmcp001Bean.setChkDoc652(false);
		semmcp001Bean.setChkDoc661(false);
		semmcp001Bean.setChkDoc662(false);
		semmcp001Bean.setChkDoc671(false);
		semmcp001Bean.setChkDoc672(false);
		semmcp001Bean.setChkDoc681(false);
		semmcp001Bean.setChkDoc682(false);
		semmcp001Bean.setChkDoc691(false);
		semmcp001Bean.setChkDoc692(false);
		semmcp001Bean.setRentalOtherRemark6("");
		setSemmcp001Bean(semmcp001Bean);
		
	}

	private void clearRentalType7() {
		semmcp001Bean = getSemmcp001Bean();
		semmcp001Bean.setChkDoc711(false);
		semmcp001Bean.setChkDoc712(false);
		semmcp001Bean.setChkDoc721(false);
		semmcp001Bean.setChkDoc722(false);
		semmcp001Bean.setChkDoc731(false);
		semmcp001Bean.setChkDoc732(false);
		semmcp001Bean.setChkDoc741(false);
		semmcp001Bean.setChkDoc742(false);
		semmcp001Bean.setChkDoc751(false);
		semmcp001Bean.setChkDoc752(false);
		semmcp001Bean.setChkDoc761(false);
		semmcp001Bean.setChkDoc762(false);
		semmcp001Bean.setChkDoc771(false);
		semmcp001Bean.setChkDoc772(false);
		semmcp001Bean.setChkDoc781(false);
		semmcp001Bean.setChkDoc782(false);
		semmcp001Bean.setChkDoc791(false);
		semmcp001Bean.setChkDoc792(false);
		semmcp001Bean.setChkDoc7101(false);
		semmcp001Bean.setChkDoc7102(false);
		semmcp001Bean.setChkDoc7111(false);
		semmcp001Bean.setChkDoc7112(false);
		semmcp001Bean.setRentalOtherRemark7("");
		setSemmcp001Bean(semmcp001Bean);
		
	}
	
	private void clearRentalType8() {
		semmcp001Bean = getSemmcp001Bean();
		semmcp001Bean.setChkDoc811(false);
		semmcp001Bean.setChkDoc812(false);
		semmcp001Bean.setChkDoc821(false);
		semmcp001Bean.setChkDoc822(false);
		semmcp001Bean.setChkDoc831(false);
		semmcp001Bean.setChkDoc832(false);
		semmcp001Bean.setChkDoc841(false);
		semmcp001Bean.setChkDoc842(false);
		semmcp001Bean.setChkDoc851(false);
		semmcp001Bean.setChkDoc852(false);
		semmcp001Bean.setRentalOtherRemark8("");
		setSemmcp001Bean(semmcp001Bean);
		
	}
	
	public void doShowRentType99() {
		semmcp001Bean = getSemmcp001Bean();
		String rentalType = semmcp001Bean.getRentalType99();
		semmcp001Bean.getContractCheckDoc().setRentalType("");
		if(rentalType != null){
			if(rentalType.equals("99")){
				semmcp001Bean.setRenderChk1(false);
				semmcp001Bean.setRenderChk2(false);
				semmcp001Bean.setRenderChk3(false);
				semmcp001Bean.setRenderChk4(false);
				semmcp001Bean.setRenderChk5(false);
				semmcp001Bean.setRenderChk6(false);
				semmcp001Bean.setRenderChk7(true);
				semmcp001Bean.setRenderChk8(false);
			}
		}
		
		setSemmcp001Bean(semmcp001Bean);
		
	}
	
	
	// added by.. YUT
	public boolean doInitialForSearchConstruction() {
		log.info("::: SEMMCP001Action :: doInitialForSearchConstruction >> BEGIN :::");
		boolean flag = true;

		try {

			semmcp001Bean = getSemmcp001Bean();

			String paramUrl = getFacesUtils().getRequestParameter("paramUrl") == null ? "" : (String) getFacesUtils().getRequestParameter("paramUrl");
	        String paramMenuGroup = getFacesUtils().getRequestParameter("paramMenuGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuGroup");
	        String paramMenuSubGroup = getFacesUtils().getRequestParameter("paramMenuSubGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuSubGroup");
	        String paramParameter = getFacesUtils().getRequestParameter("paramParameter") == null ? "" : (String) getFacesUtils().getRequestParameter("paramParameter");
	        
	        System.out.println("paramUrl: " + paramUrl);
	        System.out.println("paramMenuGroup: " + paramMenuGroup);
	        System.out.println("paramMenuSubGroup: " + paramMenuSubGroup);
	        System.out.println("paramParameter: " + paramParameter);
	        
//	        semmcp001Bean.getCriteriaSP().setStrParam(paramParameter);
	        semmcp001Bean.getConstructionPermissionForSearch().setStrParam(paramParameter);
	        semmcp001Bean.setRenderedOnToDoList(true); //

			//setSemmco001Bean(semmco001Bean);
	        setSemmcp001Bean(semmcp001Bean);
			
			this.doSearch();

		} catch(Exception e) {
			e.printStackTrace();
			addMessageError("EL0000", "SEMMCO001Action");
			flag = false;
			
		} finally {
			log.info("::: SEMMCP001Action :: doInitialForSearchConstruction >> END :::");
		}
		return flag;
	}
	
	//added by NEW 09/04/2015 
	public boolean doInitTodoList(){
		boolean flag = true;
		try{
			semmcp001Bean = getSemmcp001Bean();
//			getTreeNode();
			loadTree();
		}catch (Exception e) {
			e.printStackTrace();
			flag = false;
			// TODO: handle exception
		}finally{
			//setSemmcp001Bean(semmcp001Bean);
		}
		return flag;
	}
	
	
	
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// menu util >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	private TreeNode rootNode = null;
    private List<String> selectedNodeChildren = new ArrayList<String>();    
    
    private String nodeTitle;
    private MenuTreeSP nodeValue;
    private MenuTreeSP menuRoot;
    
    private void loadTree() {
    	String searchFlag;
    	searchFlag = getFacesUtils().getRequestParameter("searchFlag") == null ? "" : (String) getFacesUtils().getRequestParameter("searchFlag");
    	String backWard;
    	backWard = getFacesUtils().getRequestParameter("backWard") == null ? "" : (String) getFacesUtils().getRequestParameter("backWard");
    	semmcp001Bean = getSemmcp001Bean();
    	semmcp001Bean.setTreeMacroFlag(false);
    	semmcp001Bean.setTreePicoFlag(false);
    	//// >>
    	TreeUtilBean myParam = new TreeUtilBean();
    	List<Object> mySendList = new ArrayList<Object>();
    	
    	IMenuTreeService service = (IMenuTreeService)getBean("menuTreeService");
    	
    	String groupType = "CP";
        try {

//        
        	if("Y".equals(searchFlag)){
        		List<MenuTreeSP> menuTreeList = null;
        		semmcp001Bean.getTreeUtilBean().setMenuGroup(groupType);
        		semmcp001Bean.getTreeUtilBean().setUserLogin(getUserLogIn());
        		if(!semmcp001Bean.getTreeUtilBean().getCompany().equals("") && !semmcp001Bean.getTreeUtilBean().getRegion().equals("")){
        			if(!semmcp001Bean.getTreeUtilBean().getMenuSubGroup().equals("")){
            			menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name, semmcp001Bean.getTreeUtilBean());
            			
        				Map<String, Object> myMap = new HashMap<String, Object>();
        				
        				if(menuTreeList != null && !menuTreeList.isEmpty()){
        			
        					/// >
        					for(int j=0; j<menuTreeList.size(); j++){
        						String mLevel = menuTreeList.get(j).getMenuLevel();
        						myMap.put(mLevel, menuTreeList.get(j));
        					}
        					mySendList.add(myMap);
        					/// <
        					
        				}
            		}else{
            			for(int i = 0;i<2;i++){
        					if(i==0){
        						semmcp001Bean.getTreeUtilBean().setMenuSubGroup("M");
        					}
            			
    	        			menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name, semmcp001Bean.getTreeUtilBean());
    	        			
    	    				Map<String, Object> myMap = new HashMap<String, Object>();
    	    				
    	    				if(menuTreeList != null && !menuTreeList.isEmpty()){
    	    			
    	    					/// >
    	    					for(int j=0; j<menuTreeList.size(); j++){
    	    						String mLevel = menuTreeList.get(j).getMenuLevel();
    	    						myMap.put(mLevel, menuTreeList.get(j));
    	    					}
    	    					mySendList.add(myMap);
    	    					/// <
    	    					
    	    				}
    	    				semmcp001Bean.getTreeUtilBean().setMenuSubGroup("P");
    	        		}
            			semmcp001Bean.getTreeUtilBean().setMenuSubGroup("");
            		}
            		
        		}else{
        			validateToDoList();
        		}
        		
        	}else{
        		if("Y".equals(backWard)){
            		List<MenuTreeSP> menuTreeList = null;
            		semmcp001Bean.getTreeUtilBean().setMenuGroup(groupType);
            		semmcp001Bean.getTreeUtilBean().setUserLogin(getUserLogIn());
            		if(!semmcp001Bean.getTreeUtilBean().getCompany().equals("") && !semmcp001Bean.getTreeUtilBean().getRegion().equals("")){
            			if(!semmcp001Bean.getTreeUtilBean().getMenuSubGroup().equals("")){
                			menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name, semmcp001Bean.getTreeUtilBean());
                			
            				Map<String, Object> myMap = new HashMap<String, Object>();
            				
            				if(menuTreeList != null && !menuTreeList.isEmpty()){
            			
            					/// >
            					for(int j=0; j<menuTreeList.size(); j++){
            						String mLevel = menuTreeList.get(j).getMenuLevel();
            						myMap.put(mLevel, menuTreeList.get(j));
            					}
            					mySendList.add(myMap);
            					/// <
            					
            				}
                		}else{
                			for(int i = 0;i<2;i++){
            					if(i==0){
            						semmcp001Bean.getTreeUtilBean().setMenuSubGroup("M");
            					}
                			
        	        			menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name, semmcp001Bean.getTreeUtilBean());
        	        			
        	    				Map<String, Object> myMap = new HashMap<String, Object>();
        	    				
        	    				if(menuTreeList != null && !menuTreeList.isEmpty()){
        	    			
        	    					/// >
        	    					for(int j=0; j<menuTreeList.size(); j++){
        	    						String mLevel = menuTreeList.get(j).getMenuLevel();
        	    						myMap.put(mLevel, menuTreeList.get(j));
        	    					}
        	    					mySendList.add(myMap);
        	    					/// <
        	    					
        	    				}
        	    				semmcp001Bean.getTreeUtilBean().setMenuSubGroup("P");
        	        		}
                			semmcp001Bean.getTreeUtilBean().setMenuSubGroup("");
                		}
            		}else{
            			validateToDoList();
            		}
        		}else{
        			semmcp001Bean.setTreeUtilBean(new TreeUtilBean());
            		setSemmcp001Bean(semmcp001Bean);
        		}
        	}
        	semmcp001Bean.setRootNode(new TreeNodeImpl());
    		addNodes(semmcp001Bean, mySendList);
        	//// <<
    		
        } catch (Exception e) {
            throw new FacesException(e.getMessage(), e);
        } finally {
        	searchFlag = null;
        	backWard = null;
        	//semmcp001Bean = getSemmcp001Bean();
        	//// >>
        	myParam = null;
        	mySendList = null;
        	
        	service = null;
        	
        	groupType = null; 
        }
    }
    
    public void validateToDoList(){
    	try{
    		semmcp001Bean = getSemmcp001Bean();
    		if(semmcp001Bean.getTreeUtilBean().getCompany().equals("")){
    			addMessageErrorWithArgument("W0001",msg("message.company"));
    		}
    		if(semmcp001Bean.getTreeUtilBean().getRegion().equals("")){
    			addMessageErrorWithArgument("W0001",msg("message.region"));
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
			// TODO: handle exception
		}
    }

    @SuppressWarnings({ "unused", "unchecked" })
	private void addNodes(SEMMCP001Bean semmcp001Bean, List<Object> propList) {
    	
    	for(int i=0; i<propList.size(); i++) {
    		List<WrapperBeanObject<MenuTreeSP>> menuTreeWrapList = new ArrayList<WrapperBeanObject<MenuTreeSP>>();
        	// >>
    		Map<String, Object> map = (Map<String, Object>) propList.get(i);
    		
    		int mapSize = map.keySet().size();
    		Object[] mapArr = map.keySet().toArray();
    		
    		// for sorting
    		Object[] mapArr_ = map.keySet().toArray();
    		Arrays.sort(mapArr_);
    		// <<

			MenuTreeSP myParent = new MenuTreeSP();
			
			String _MENU_LABEL = "";
//			
			String parent1 = mapArr_[i].toString();	// get key by sorting
			MenuTreeSP mapObj1 =  (MenuTreeSP) map.get(parent1);
			
			if(mapObj1.getMenuSubGroup().equals("M")){
				_MENU_LABEL = "Site Info Non PICO";
				
				if(mapObj1.getRegion() != null){
					_MENU_LABEL = _MENU_LABEL+" "+mapObj1.getRegion();
				}
				
				if(mapObj1.getCompany() != null){
					_MENU_LABEL = _MENU_LABEL+" "+mapObj1.getCompany();
				}
				
				for(int x=0; x<mapSize; x++){
	    			TreeNodeImpl<MenuTreeSP> child = new TreeNodeImpl<MenuTreeSP>();
	    			
	    			String parentNode = mapArr_[x].toString();	// get key by sorting
	    			
	    			MenuTreeSP mapObj =  (MenuTreeSP) map.get(parentNode);

//	    			 2015/01/30 fixed.. dynamic URL
	    			String myUrl = mapObj.getMenuUrl() == null ? "SEMMCO001-0" : mapObj.getMenuUrl().toString();
	    			String myAction = myUrl.substring(0, myUrl.length() - 2);
	    			mapObj.setMenuUrl(myUrl);
	    			mapObj.setMenuAction(myAction);
//	    			// fixed.. dynamic URL
//	    			
					WrapperBeanObject<MenuTreeSP> tmpWrapperBean = new WrapperBeanObject<MenuTreeSP>();
					tmpWrapperBean.setDataObj(mapObj);
					tmpWrapperBean.setMessage("");
					menuTreeWrapList.add(tmpWrapperBean);
	        	}
				semmcp001Bean.setHeaderTreeMacro(_MENU_LABEL);
				semmcp001Bean.setTreeMacroFlag(true);
				semmcp001Bean.setMenuTreeMacroList(menuTreeWrapList);
			}else if(mapObj1.getMenuSubGroup().equals("P")){
				_MENU_LABEL = "Site Info Pico";
								
				if(mapObj1.getRegion() != null){
					_MENU_LABEL = _MENU_LABEL+" "+mapObj1.getRegion();
				}
				
				if(mapObj1.getCompany() != null){
					_MENU_LABEL = _MENU_LABEL+" "+mapObj1.getCompany();
				}
				
				for(int x=0; x<mapSize; x++){
	    			TreeNodeImpl<MenuTreeSP> child = new TreeNodeImpl<MenuTreeSP>();
	    			
	    			String parentNode = mapArr_[x].toString();	// get key by sorting
	    			
	    			MenuTreeSP mapObj =  (MenuTreeSP) map.get(parentNode);

//	    			2015/01/30 fixed.. dynamic URL
	    			String myUrl = mapObj.getMenuUrl() == null ? "SEMMCO001-0" : mapObj.getMenuUrl().toString();
	    			String myAction = myUrl.substring(0, myUrl.length() - 2);
	    			mapObj.setMenuUrl(myUrl);
	    			mapObj.setMenuAction(myAction);
//	    			// fixed.. dynamic URL
	    			
					WrapperBeanObject<MenuTreeSP> tmpWrapperBean = new WrapperBeanObject<MenuTreeSP>();
					tmpWrapperBean.setDataObj(mapObj);
					tmpWrapperBean.setMessage("");
					menuTreeWrapList.add(tmpWrapperBean);
	        	}
				semmcp001Bean.setHeaderTreePico(_MENU_LABEL);
				semmcp001Bean.setTreePicoFlag(true);
				semmcp001Bean.setMenuTreePicoList(menuTreeWrapList);
			}
			setSemmcp001Bean(semmcp001Bean);
    	}
    }
    
    public void processSelection(NodeSelectedEvent event) {
        HtmlTree tree = (HtmlTree) event.getComponent();
        nodeTitle = ((MenuTreeSP)tree.getRowData()).toString();
        nodeValue = (MenuTreeSP) tree.getRowData();

        selectedNodeChildren.clear();
        
        TreeNode currentNode = tree.getModelTreeNode(tree.getRowKey());
        if (currentNode.isLeaf()){
            selectedNodeChildren.add(((MenuTreeSP)currentNode.getData()).toString());
            System.out.println("selected node Child [y]: " + ((MenuTreeSP)currentNode.getData()).toString());
        }else
        {
            Iterator<Map.Entry<Object, TreeNode>> it = currentNode.getChildren();
            while (it!=null &&it.hasNext()) {
                Map.Entry<Object, TreeNode> entry = it.next();
                selectedNodeChildren.add(entry.getValue().getData().toString());
                System.out.println("selected nod Parent have Childred [x]: " + entry.getValue().getData().toString());
            }
        }
        
        
    }
    
    // fixed 2015/01/27
    public boolean nodeExpandAll(UITree tree) {  
    	// can do somthing
    	return true;
    }
    
    public TreeNode getTreeNode() {
    	semmcp001Bean = getSemmcp001Bean();
    	String searchFlag = getFacesUtils().getRequestParameter("searchFlag") == null ? "" : (String)getFacesUtils().getRequestParameter("searchFlag");
        if (semmcp001Bean.getRootNode() == null || "Y".equals(searchFlag)) {
            loadTree();
        }
        
        return semmcp001Bean.getRootNode();
    }

    public String getNodeTitle() {
        return nodeTitle;
    }

    public void setNodeTitle(String nodeTitle) {
        this.nodeTitle = nodeTitle;
    }
    
    public MenuTreeSP getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(MenuTreeSP nodeValue) {
        this.nodeValue = nodeValue;
    }
    
    public MenuTreeSP getMenuRoot() {
        return menuRoot;
    }

    public void setMenuRoot(MenuTreeSP menuRoot) {
        this.menuRoot = menuRoot;
    }
	
    private PopupSiteContractBean popupSiteContractBean;

	public PopupSiteContractBean getPopupSiteContractBean() {
		return (PopupSiteContractBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupSiteContractBean");
	}

	public void setPopupSiteContractBean(PopupSiteContractBean popupSiteContractBean) {
		this.popupSiteContractBean = popupSiteContractBean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupSiteContractBean", this.popupSiteContractBean);
	}
	
	private boolean initPopupSearchContractNo() {
		boolean flag = false;
		String company = (String)getFacesUtils().getRequestParameter("company");
		String page = (String)getFacesUtils().getRequestParameter("page");
		String fromButton = (String)getFacesUtils().getRequestParameter("fromButton") == null ? "" : (String)getFacesUtils().getRequestParameter("fromButton");
		semmcp001Bean = getSemmcp001Bean();
		try{
			popupSiteContractBean = getPopupSiteContractBean();
			popupSiteContractBean.setPopupContractCriteria(new PopupContractSearchSP());
			popupSiteContractBean.getPopupContractCriteria().setCurrentFlag("Y");
			popupSiteContractBean.getPopupContractCriteria().setContractNo("");
			popupSiteContractBean.setContractList(new ArrayList<PopupContractSearchSP>());
			popupSiteContractBean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
			popupSiteContractBean.setPage(page);
			popupSiteContractBean.setFromButton(fromButton);
			if(company != null){
				popupSiteContractBean.getPopupContractCriteria().setCompany(company);
			}
			if("oldContractNo".equals(fromButton)){
//				SEMMEL011Action mel011Action = new SEMMEL011Action();
//				mel011Action.semmsi004Bean = mel011Action.getSemmsi004Bean();
				semmcp001Bean.setDisabledTransfer(true);
//				mel011Action.setSemmsi004Bean(mel011Action.semmsi004Bean);
			}
			setSemmcp001Bean(semmcp001Bean);
			setPopupSiteContractBean(popupSiteContractBean);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.debug(" ###### Error initPopupSearchContractNo : "+e);
		}
		
		return flag;
	}
	
	private boolean doSearchPopupContractNo(){
		boolean flag = true;
		semmcp001Bean = getSemmcp001Bean();
		PopupSiteContractAction popupAction = new PopupSiteContractAction();
		try{
			PopupContractSearchSP popupContractSearchSP = new PopupContractSearchSP();
			
			popupAction.doSearchPopupContractNoMCP();
			semmcp001Bean.setDisabledTransfer(false);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			semmcp001Bean.setDisabledTransfer(true);
		}finally{
			setSemmcp001Bean(semmcp001Bean);
		}
		return flag;
	}
	
	private boolean doClearPopupContractNo() {
		boolean flag = false;
		semmcp001Bean = getSemmcp001Bean();
		try{
			popupSiteContractBean = getPopupSiteContractBean();
			popupSiteContractBean.getPopupContractCriteria().setCurrentFlag("Y");
			popupSiteContractBean.getPopupContractCriteria().setContractNo("");
			popupSiteContractBean.getPopupContractCriteria().setSiteName("");
			popupSiteContractBean.getPopupContractCriteria().setCompany("");
			popupSiteContractBean.setContractList(null);
			setPopupSiteContractBean(popupSiteContractBean);
			
			semmcp001Bean.setDisabledTransfer(true);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			setSemmcp001Bean(semmcp001Bean);
		}
		
		return flag;
	}
	
	private boolean doSelectContractNo() {
		boolean flag = false;
		semmcp001Bean = getSemmcp001Bean();
		PopupSiteContractAction popupAction = new PopupSiteContractAction();
		try {
			String siteInfoId = (String)getFacesUtils().getRequestParameter("siteInfoId");
			String siteName = (String)getFacesUtils().getRequestParameter("siteName");
			String contractNo = (String)getFacesUtils().getRequestParameter("contractNo");
			String region = (String)getFacesUtils().getRequestParameter("region");
			String sendRenewId = (String)getFacesUtils().getRequestParameter("sendRenewId");
			String companyId = (String)getFacesUtils().getRequestParameter("companyId");
			String effDt = (String)getFacesUtils().getRequestParameter("effDt");
			String expDt = (String)getFacesUtils().getRequestParameter("expDt");
			String contractId = (String)getFacesUtils().getRequestParameter("contractId");
			//set popup data
			PopupSiteContractBean popupSiteContractBean = new PopupSiteContractBean();
			popupSiteContractBean = popupAction.getPopupSiteContractBean();
			PopupContractSearchSP popupContractSearchSP = new PopupContractSearchSP();
			popupAction.getPopupSiteContractBean().setContractNo(contractNo);
			popupContractSearchSP.setContractNo(contractNo);
			popupContractSearchSP.setRegion(region);
			popupContractSearchSP.setSiteInfoId(siteInfoId);
//			popupContractSearchSP.setCompany(companyId);
			popupContractSearchSP.setSiteName(siteName);
//			//popupSiteContractBean.getPopupContractCriteria().setEffDate(effDt);
//			popupSiteContractBean.setRegion(region);
//			popupSiteContractBean.setSiteInfoId(siteInfoId);
//			popupSiteContractBean.setSiteName(siteName);
//			popupSiteContractBean.setCompanyId(companyId);
//			popupSiteContractBean.setEffDt(effDt);
//			popupSiteContractBean.setExpDt(expDt);
//			popupSiteContractBean.setContractId(contractId);
//			popupAction.getPopupSiteContractBean().setPopupContractCriteria(popupContractSearchSP);
			popupSiteContractBean.setPopupContractCriteria(popupContractSearchSP);
			popupAction.setPopupSiteContractBean(popupSiteContractBean); 
			semmcp001Bean.getSiteInfoData().setTransferSiteInfoId(siteInfoId);
			semmcp001Bean.getSiteInfoData().setTransferContNo(contractNo);
			semmcp001Bean.getSiteInfoData().setUserId(getUserLogIn());
			semmcp001Bean.setDisabledTransfer(false);
			log.debug("siteInfoId  : "+semmcp001Bean.getSiteInfoData().getTransferSiteInfoId());
			log.debug("contractNo : "+semmcp001Bean.getSiteInfoData().getTransferContNo());
			log.debug("siteInfoId dum : "+semmcp001Bean.getSiteInfoData().getRowId());
			log.debug("contractNo dum : "+semmcp001Bean.getSiteInfoData().getContractNo());
			setSemmcp001Bean(semmcp001Bean);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			popupAction = null;
			setSemmcp001Bean(semmcp001Bean);
		}
		//setPopupSiteContractBean(popupSiteContractBean);
		return flag;
	}
	
	public boolean doTransfer(){
		boolean flag = false;
		semmcp001Bean = getSemmcp001Bean();
		ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
		List<SiteInfoSP> to = null;
		try{
			semmcp001Bean.getSiteInfoData().setUserId(getUserLogIn());
			
//			semmcp001Bean.getConstructionPermissionTransferSP().setSiteInfoId(siteInfoId);
//			semmcp001Bean.getConstructionPermissionTransferSP().setSiteContructId(siteContructId);
//			semmcp001Bean.getConstructionPermissionTransferSP().setContractId(contractId);
//			semmcp001Bean.getConstructionPermissionTransferSP().setTerminateFlag(terminateFlag);
//			semmcp001Bean.getConstructionPermissionTransferSP().setSiteName(siteName);
//			semmcp001Bean.getConstructionPermissionTransferSP().setContractNo(siteContractNo);
//			semmcp001Bean.getConstructionPermissionTransferSP().setMigrateFlag(migrateFlag);
			
			log.debug("doTransfer siteInfoId  : "+semmcp001Bean.getSiteInfoData().getTransferSiteInfoId());
			log.debug("doTransfer contractNo : "+semmcp001Bean.getSiteInfoData().getTransferContNo());
			log.debug("doTransfer siteInfoId dum : "+semmcp001Bean.getSiteInfoData().getRowId());
			log.debug("doTransfer contractNo dum : "+semmcp001Bean.getSiteInfoData().getContractNo());
			log.debug("doTransfer userId : "+semmcp001Bean.getSiteInfoData().getUserId());
			to = service.querySPList(EQueryName.SP_MCP001_TRANSFER_DUMMY.name, semmcp001Bean.getSiteInfoData());
			
			if(to != null && to.size() > 0){
				if(StringUtils.equals("Success", to.get(0).getpResult())){
//					semmsi004Bean.setDummyContractId(to.get(0).getpRemark());
//					semmsi004Bean.getSiteInfoData().setContractNo(to.get(0).getpRemark());
					flag = true;
//					log.debug("message success : "+to.get(0).getpRemark());
					doSearch();
					if(to.get(0).getpRemark() != null)addMessageInfo(to.get(0).getpRemark());
//					semmcp001Bean.setSiteInfoSP(new SiteInfoSP());
//					this.init();
//					this.doSearchDummy();
				}else{
					if(to.get(0).getpRemark() != null)addMessageError(to.get(0).getpRemark());
//					log.error("message error : "+to.get(0).getpRemark());
				}
				
				semmcp001Bean.setDisabledTransfer(true);
			}else{
				addMessageError("E0001");
			}
		}catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			service = null;
			to = null;
			setSemmcp001Bean(semmcp001Bean);
		}
		
		return flag;
	}
	
	private boolean doSearchContractForRollBack(){
		
		semmcp001Bean = getSemmcp001Bean();
//		SEMMCP001Action mel011Action = new SEMMEL011Action();
//		mel011Action.semmsi004Bean = mel011Action.getSemmsi004Bean();
		semmcp001Bean.setDisabledTransfer(true);
//		mel011Action.setSemmsi004Bean(mel011Action.semmsi004Bean);
	
		popupSiteContractBean = getPopupSiteContractBean();
		ISiteContractService siteContractService = (ISiteContractService)getBean("siteContractService");
		List<PopupContractSearchSP> to = null;
		popupSiteContractBean.setContractListForRollBack(null);
		popupSiteContractBean.setContractNo(semmcp001Bean.getSiteInfoData().getContractNo());
		popupSiteContractBean.setSiteInfoId(semmcp001Bean.getSiteInfoData().getRowId());
		
		try{
			to = siteContractService.querySPList(EQueryName.SP_MCP001_SRCH_ROLLBACK_DUMMY.name, popupSiteContractBean);
			if (null == to || to.isEmpty()) {
				// set error message after search not found
				addMessageErrorWithArgument("W0032",popupSiteContractBean.getPopupContractCriteria().getContractNo());
			}
			
			if(to != null && to.size() > 0){
				log.debug("size [" + to.size() + "]");
				List<PopupContractSearchSP> list = new ArrayList<PopupContractSearchSP>();
				for(PopupContractSearchSP contract : to){
					if(contract.getEffDate() != null){
						contract.setEffDate(SEMDataUtility.convertToThYear(contract.getEffDate()));
					}
					if(contract.getExpDate()!= null){
						contract.setExpDate(SEMDataUtility.convertToThYear(contract.getExpDate()));
					}
					list.add(contract);
				}
				popupSiteContractBean.setContractListForRollBack(list);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		setPopupSiteContractBean(popupSiteContractBean);
		
		return true;
	}
	
	private boolean doRollBackContract(){
		
		semmcp001Bean = getSemmcp001Bean();
//		SEMMEL011Action mel011Action = new SEMMEL011Action();
//		mel011Action.semmsi004Bean = mel011Action.getSemmsi004Bean();
		semmcp001Bean.setDisabledTransfer(true);
//		mel011Action.setSemmsi004Bean(mel011Action.semmsi004Bean);
	
		popupSiteContractBean = getPopupSiteContractBean();
		ISiteContractService siteContractService = (ISiteContractService)getBean("siteContractService");
		List<PopupContractSearchSP> to = null;
		popupSiteContractBean.setContractListForRollBack(null);
		//popupSiteContractBean.setUserId(getUserLogIn());
		popupSiteContractBean.setContractNo(semmcp001Bean.getSiteInfoData().getContractNo());
		popupSiteContractBean.setSiteInfoId(semmcp001Bean.getSiteInfoData().getRowId());
		popupSiteContractBean.setUserLogin(getUserLogIn());
		
		try{
			to = siteContractService.querySPList(EQueryName.SP_MCP001_ROLLBACK_DUMMY.name, popupSiteContractBean);
			if (null == to || to.isEmpty()) {
				// set error message after search not found
				addMessageErrorWithArgument("W0032",popupSiteContractBean.getPopupContractCriteria().getContractNo());
			}
			
			if(to != null && to.size() > 0){
				log.debug("size [" + to.size() + "]");
				
				if(to.get(0).getpResult().equalsIgnoreCase("success")){
					log.debug("RollBack is Sucess !!");
				}else{
					log.debug("RollBack is Fail !!");
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		setPopupSiteContractBean(popupSiteContractBean);
		
		return true;
	}
}
