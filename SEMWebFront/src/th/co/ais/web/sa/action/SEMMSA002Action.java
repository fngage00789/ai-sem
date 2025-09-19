
package th.co.ais.web.sa.action;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.ajax4jsf.component.UIRepeat;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import th.co.ais.domain.AbstractDomain;
import th.co.ais.domain.gm.Province;
import th.co.ais.domain.mm.ItemResultSP;
import th.co.ais.domain.sa.MSA001LovSP;
import th.co.ais.domain.sa.SemTySaSiteAppUpd;
import th.co.ais.domain.sa.SiteAcqSP;
import th.co.ais.domain.sa.SiteAppMailSP;
import th.co.ais.domain.sa.SiteAppRegHistSrch;
import th.co.ais.domain.sa.SiteAppSP;
import th.co.ais.domain.sa.SiteAppSiteSP;
import th.co.ais.domain.si.Msi004CalcAgeSP;
import th.co.ais.rpt.util.bean.CellDomain;
import th.co.ais.rpt.util.bean.EnumDocStyleDomain;
import th.co.ais.rpt.util.bean.RowDomain;
import th.co.ais.rpt.util.enums.EnumDocStyle;
import th.co.ais.rpt.util.enums.EnumDocumentType;
import th.co.ais.service.sa.ISiteAcquistionService;
import th.co.ais.service.si.ISiteApproveService;
import th.co.ais.service.si.ISiteContractService;
import th.co.ais.util.ELovType;
import th.co.ais.util.ELovVal;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.common.PopupSiteContractBean;
import th.co.ais.web.report.util.DocumentExportManager;
import th.co.ais.web.sa.bean.LegalDocComponentBean;
import th.co.ais.web.sa.bean.SEMMSA002Bean;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.ProvinceCacheUtil;
import th.co.ais.web.util.RegionCacheUtil;
import th.co.ais.web.util.SelectItemLOVCacheUtil;
import th.co.ais.web.util.ZoneCasheUtil;

public class SEMMSA002Action extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3412618125850012716L;
	private static final Logger LOG = Logger.getLogger(SEMMSA002Action.class);
	
	private SEMMSA002Bean semmsa002Bean;
	
	private PopupSiteContractBean popupSiteContractBean;
	
	public SEMMSA002Bean getSemmsa002Bean() {
		return (SEMMSA002Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsa002Bean");
	}

	public void setSemmsa002Bean(SEMMSA002Bean semmsa002Bean) {
		this.semmsa002Bean = semmsa002Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsa002Bean", semmsa002Bean);
	}

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		LOG.info("::: SEMMSA002Action :: actionWithNavi >> BEGIN :::");
		boolean flag = false;
		
		try {
			
			// --
			semmsa002Bean = getSemmsa002Bean();
			// --
			
			if(methodWithNavi.equalsIgnoreCase("doUpdateAll")) {
				flag = this.doUpdateAll();
			} else if(methodWithNavi.equalsIgnoreCase("doInitChangeTab")){
				flag = this.doInitChangeTab();
			} else if(methodWithNavi.equalsIgnoreCase("doInitialMsa002Tab")) {
				flag = this.doInitialMsa002Tab();
			} else if(methodWithNavi.equalsIgnoreCase("doSendOfficerApprove")) {
				flag = this.doSendOfficerApprove();
			} else if(methodWithNavi.equalsIgnoreCase("doByPass")) {
				flag = this.doByPass();
			}else if(methodWithNavi.equalsIgnoreCase("doCalAmt")) {
				doCalAmt();
			}else if(methodWithNavi.equalsIgnoreCase("doSelectContractNo")){
				flag = this.doSelectContractNo();
			}else if(methodWithNavi.equalsIgnoreCase("doAddSiteAppRentCont")){
				flag = this.doAddSiteAppRentCont();
			}else if(methodWithNavi.equalsIgnoreCase("doUpdateSiteAppRentCont")){
				flag = this.doUpdateSiteAppRentCont();
			}else if(methodWithNavi.equalsIgnoreCase("doDetSiteAppRentCont")){
				flag = this.doDetSiteAppRentCont();
			}else if(methodWithNavi.equalsIgnoreCase("doEditRental")){
				flag = this.doEditRental();
			}else if(methodWithNavi.equalsIgnoreCase("doEditRentalExisting")){
				flag = this.doEditRentalExisting();
			}else if(methodWithNavi.equalsIgnoreCase("doClearSiteAppRentCont")){
				flag = this.doClearSiteAppRentCont();
			}else if(methodWithNavi.equalsIgnoreCase("renderDeptReturnType")){
				flag = this.renderDeptReturnType();
			}else if(methodWithNavi.equalsIgnoreCase("doAddSiteAppDept")){
				flag = this.doAddSiteAppDept();
			}else if(methodWithNavi.equalsIgnoreCase("doUpdateSiteAppDept")){
				flag = this.doUpdateSiteAppDept();
			}else if(methodWithNavi.equalsIgnoreCase("doInitDetSiteAppDept")){
				flag = this.doInitDetSiteAppDept();
			}else if(methodWithNavi.equalsIgnoreCase("doEditRentalDeposit")){
				flag = this.doEditRentalDeposit();
			}else if(methodWithNavi.equalsIgnoreCase("doClearSiteAppDeposit")){
				flag = this.doClearSiteAppDeposit();
			}else if(methodWithNavi.equalsIgnoreCase("doDetSiteAppDept")){
				flag = this.doDetSiteAppDept();
			}else if(methodWithNavi.equalsIgnoreCase("doAddSiteAppELCond")){
				flag = this.doAddSiteAppELCond();
			}else if(methodWithNavi.equalsIgnoreCase("doUpdateSiteAppELCond")){
				flag = this.doUpdateSiteAppELCond();
			}else if(methodWithNavi.equalsIgnoreCase("doDetSiteAppELCond")){
				flag = this.doDetSiteAppELCond();
			}else if(methodWithNavi.equalsIgnoreCase("doEditEL")){
				flag = this.doEditEL();
			}else if(methodWithNavi.equalsIgnoreCase("doInitEditPT")){
				flag = this.doInitEditPT();
			}else if(methodWithNavi.equalsIgnoreCase("doUpdateSiteAppPT")){
				flag = this.doUpdateSiteAppPT();
			}else if(methodWithNavi.equalsIgnoreCase("doClearSiteAppPT")){
				flag = this.doClearSiteAppPT();
			}else if(methodWithNavi.equalsIgnoreCase("doSiteAppIRIns")){
				flag = this.doSiteAppIRIns();
			}else if(methodWithNavi.equalsIgnoreCase("doSiteAppIRUpd")){
				flag = this.doSiteAppIRUpd();
			}else if(methodWithNavi.equalsIgnoreCase("doDetSiteAppIR")){
				flag = this.doDetSiteAppIR();
			}else if(methodWithNavi.equalsIgnoreCase("doClearSiteAppIR")){
				flag = this.doClearSiteAppIR();
			}else if(methodWithNavi.equalsIgnoreCase("doInitEditIR")){
				flag = this.doInitEditIR();
			}else if(methodWithNavi.equalsIgnoreCase("doClearSiteAppEl")){
				this.doClearSiteAppEl();
			}else if(methodWithNavi.equalsIgnoreCase("doEditDepositEl")){
				flag = this.doEditDepositEl();
			}else if(methodWithNavi.equalsIgnoreCase("doClearSiteAppDepositEl")){
				flag = this.doClearSiteAppDepositEl();
			}else if(methodWithNavi.equalsIgnoreCase("doExportAddress")){
				flag = this.doExportAddress();
			}else if(methodWithNavi.equalsIgnoreCase("doCheckRentalChange")){
				flag = this.doCheckRentalChange();
			}else if(methodWithNavi.equalsIgnoreCase("doCheckRentalDepositChange")){
				flag = this.doCheckRentalDepositChange();
			}else if(methodWithNavi.equalsIgnoreCase("doCheckContractChange")){
				flag = this.doCheckContractChange();
			}else if(methodWithNavi.equalsIgnoreCase("doCheckElChange")){
				flag = this.doCheckElChange();
			}else if(methodWithNavi.equalsIgnoreCase("doCheckElDepositChange")){
				flag = this.doCheckElDepositChange();
			}else if(methodWithNavi.equalsIgnoreCase("doCheckPTChange")){
				flag = this.doCheckPTChange();
			}else if(methodWithNavi.equalsIgnoreCase("doCheckInsuranceChange")){
				flag = this.doCheckInsuranceChange();
			}else if(methodWithNavi.equalsIgnoreCase("doCheckContDocChange")){
				flag = this.doCheckContDocChange();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA002Action");
			flag = false;
			
			semmsa002Bean.setRenderedMsgAlert(true);
			setSemmsa002Bean(semmsa002Bean);
		} finally {
			LOG.info("::: SEMMSA002Action :: actionWithNavi >> END :::");
		}
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		LOG.info("::: SEMMSA002Action :: init >> BEGIN :::");
		
		try {
			
			SEMMSA002Bean semmsa002Bean = new SEMMSA002Bean();
			
			// >> do set data
			semmsa002Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
			semmsa002Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
			semmsa002Bean.setAmphurList(getEmptyDropDown());
			semmsa002Bean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList());
			semmsa002Bean.setReqOfficerList(SelectItemLOVCacheUtil.getInstance().getLovItemsValueNameByType(ELovType.T_SI_SITE_APPROVE_FROM.name));
			semmsa002Bean.setZoneList(ZoneCasheUtil.getInstance().getZoneSelList());
			semmsa002Bean.setLocationList(getLovItemsByType(ELovType.T_SI_PLACE_TYPE.name));
			semmsa002Bean.setAreaUnitTypeList(getLovItemsByType(ELovType.T_SI_AREA_UNIT_TYPE.name));
			
			semmsa002Bean.setPackagePeriodTypeList(getLovItemsByType(ELovType.T_SI_RENEW_AGE_CODE.name));
			semmsa002Bean.setPromiseRenewPeriodTypeList(getLovItemsByType(ELovType.T_CT_PERIOD_TYPE.name));
			semmsa002Bean.setRentPeriodTypeList(getLovItemsByType(ELovType.T_SI_RENEW_AGE_CODE.name));
			
			semmsa002Bean.setCoOperatorList(getEmptyDropDown());
			
			semmsa002Bean.setLegalPlaceTypeList(getEmptyDropDown());
			semmsa002Bean.setLegalPartiesTypeList(getEmptyDropDown());
			// << do set data
			
			semmsa002Bean.setContractElUseObjParam(new SiteAppSP());
			semmsa002Bean.setChgReqObjParam(new SiteAppSP());
			
			semmsa002Bean.setReqTypeList(getEmptyDropDown());
			semmsa002Bean.setTeamList(getEmptyDropDown());
        	semmsa002Bean.setMemberList(getEmptyDropDown());
        	semmsa002Bean.setRentAdjList(getLovItemsByType(ELovType.T_SA_RENT_ADJ.name));
        	
        	//semmsa002Bean.setChkEditFlag(true);
        	
        	semmsa002Bean.setElUseTypeList(getLovItemsByType(ELovType.T_SA_ELECTRIC_TYPE.name));
		
			setSemmsa002Bean(semmsa002Bean);
			
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA002Action");
			
			semmsa002Bean.setRenderedMsgAlert(true);
			setSemmsa002Bean(semmsa002Bean);
		} finally {
			LOG.info("::: SEMMSA002Action :: init >> END :::");
		}
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void doPrepareBackward() {
		try {
			
			String paramBackToOther = getFacesUtils().getRequestParameter("paramBackToMe") == null ? "" : (String) getFacesUtils().getRequestParameter("paramBackToMe");
			
			if(paramBackToOther.equals("Y")){
				String paramNavModuleFrom = getFacesUtils().getRequestParameter("paramNavModuleFrom") == null ? "" : (String) getFacesUtils().getRequestParameter("paramNavModuleFrom");
				String paramNavProgramFrom = getFacesUtils().getRequestParameter("paramNavProgramFrom") == null ? "" : (String) getFacesUtils().getRequestParameter("paramNavProgramFrom");
				String paramModuleWithNaviFrom = getFacesUtils().getRequestParameter("paramModuleWithNaviFrom") == null ? "" : (String) getFacesUtils().getRequestParameter("paramModuleWithNaviFrom");
				String paramActionWithNaviFrom = getFacesUtils().getRequestParameter("paramActionWithNaviFrom") == null ? "" : (String) getFacesUtils().getRequestParameter("paramActionWithNaviFrom");
				String paramMethodWithNaviFrom = getFacesUtils().getRequestParameter("paramMethodWithNaviFrom") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMethodWithNaviFrom");

				semmsa002Bean.setRenderedBtnBack(false);
				semmsa002Bean.setRenderedBtnBackOther(true);
				semmsa002Bean.setNavModuleFrom(paramNavModuleFrom);
				semmsa002Bean.setNavProgramFrom(paramNavProgramFrom);
				semmsa002Bean.setModuleWithNaviFrom(paramModuleWithNaviFrom);
				semmsa002Bean.setActionWithNaviFrom(paramActionWithNaviFrom);
				semmsa002Bean.setMethodWithNaviFrom(paramMethodWithNaviFrom);
			} else {
				// do nothing
			}
			
			setSemmsa002Bean(semmsa002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA002Action");
			
			semmsa002Bean.setRenderedMsgAlert(true);
			setSemmsa002Bean(semmsa002Bean);
		} 
	}
	
	
	public boolean doByPass(){
		try{
			semmsa002Bean = getSemmsa002Bean();
			String popupFlag = getFacesUtils().getRequestParameter("popupFlag") == null ? "" : (String) getFacesUtils().getRequestParameter("popupFlag");
			
//			if(popupFlag.equals("N")){
//				semmsa002Bean.setUploadFileFlag(true);
//				semmsa002Bean.setOpenPopupUploadFlag(false);
//			}else if(popupFlag.equals("Y")){
//				semmsa002Bean.setUploadFileFlag(false);
//				semmsa002Bean.setOpenPopupUploadFlag(true);
//			}
//			
			setSemmsa002Bean(semmsa002Bean);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error(e);
		}
		return true;
	}
	
	public void getAmphurList(){
		semmsa002Bean = getSemmsa002Bean();
		Province province = new Province();
		
		String myParam = getFacesUtils().getRequestParameter("paramAmphr") == null ? "" : (String) getFacesUtils().getRequestParameter("paramAmphr");
		
		String strProvinceId = "";
		if(myParam.equals("M")) { // incase mailAddr 'msa002tab7'
			strProvinceId = semmsa002Bean.getSiteAppTab7ObjParam().getMailProvinceId().toString();
			
			province.setRowId(strProvinceId);
			semmsa002Bean.setMsa002Tab7AmphurList(this.getAmphurByProvince(province));
		} else if(myParam.equals("L")) { // incase  'msa002tab2'
			strProvinceId = semmsa002Bean.getSiteAppObjParam().getLessorProvinceId().toString();
			
			province.setRowId(strProvinceId);
			semmsa002Bean.setMsa002Tab2AmphurList(this.getAmphurByProvince(province));
		} else {
			strProvinceId = semmsa002Bean.getSiteAppObjParam().getLocationProvinceId().toString();
			
			province.setRowId(strProvinceId);
			semmsa002Bean.setAmphurLocalList(this.getAmphurByProvince(province));
		}
		
		setSemmsa002Bean(semmsa002Bean);
	}
	
	public void getContAmphurList(){
		LOG.info(" #### Start SEMMSA002 Action getContAmphurList ####");
		semmsa002Bean = getSemmsa002Bean();
		Province province = new Province();
		
		String myParam = getFacesUtils().getRequestParameter("paramAmphr") == null ? "" : (String) getFacesUtils().getRequestParameter("paramAmphr");
		
		try{
			String strProvinceId = "";
			if(myParam.equals("M")) { // incase mailAddr 'msa002tab7'
				strProvinceId = semmsa002Bean.getSiteAppTab7ObjParam().getMailProvinceId().toString();
				
				province.setRowId(strProvinceId);
				semmsa002Bean.setMsa002Tab7AmphurList(this.getAmphurByProvince(province));
			} else if(myParam.equals("L")) { // incase  'msa002tab2'
				strProvinceId = semmsa002Bean.getSiteAppObjParam().getLessorProvinceId().toString();
				
				province.setRowId(strProvinceId);
				semmsa002Bean.setMsa002Tab2AmphurList(this.getAmphurByProvince(province));
			} else {
				strProvinceId = semmsa002Bean.getSiteAppObjParam().getDocLocProvinceId().toString();
				
				province.setRowId(strProvinceId);
				semmsa002Bean.setAmphurReqDocList(this.getAmphurByProvince(province));
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action getContAmphurList : "+e);
		}finally{
			LOG.info(" #### End SEMMSA002 Action getContAmphurList ####");
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	
	public void getAmphurTab2List(){
		semmsa002Bean = getSemmsa002Bean();
		Province province = new Province();
		
		String myParam = getFacesUtils().getRequestParameter("paramAmphr") == null ? "" : (String) getFacesUtils().getRequestParameter("paramAmphr");
		
		String strProvinceId = "";
		if(myParam.equals("M")) { // incase mailAddr 'msa002tab7'
			strProvinceId = semmsa002Bean.getSiteAppTab7ObjParam().getMailProvinceId().toString();
			
			province.setRowId(strProvinceId);
			semmsa002Bean.setMsa002Tab7AmphurList(this.getAmphurByProvince(province));
		} else if(myParam.equals("L")) { // incase  'msa002tab2'
			strProvinceId = semmsa002Bean.getSiteAppObjParam().getLessorProvinceId().toString();
			
			province.setRowId(strProvinceId);
			semmsa002Bean.setMsa002Tab2AmphurLessorList(this.getAmphurByProvince(province));
		} else if(StringUtils.equals("C", myParam)){
			strProvinceId = semmsa002Bean.getSiteAppObjParam().getContactProvinceId().toString();
			
			province.setRowId(strProvinceId);
			semmsa002Bean.setMsa002Tab2AmphurContactList(this.getAmphurByProvince(province));
		}
		
		setSemmsa002Bean(semmsa002Bean);
	}
	
	public boolean doSearch() {
		LOG.info("::: SEMMSA002Action :: doSearch >> BEGIN :::");
		boolean flag = false;

		try {
			
			semmsa002Bean = getSemmsa002Bean();
			
			/*
			 * 
			 * */
			
			setSemmsa002Bean(semmsa002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA002Action");
			flag = false;
			
			semmsa002Bean.setRenderedMsgAlert(true);
			setSemmsa002Bean(semmsa002Bean);
		} finally {
			LOG.info("::: SEMMSA002Action :: doSearch >> END :::");
		}
		return flag;
	}
	
	public boolean doClear() {
		LOG.info("::: SEMMSA002Action :: doClear >> BEGIN :::");
		boolean flag = false;

		try {
			
			semmsa002Bean = getSemmsa002Bean();
			
			/*
			 * 
			 * */
			
			setSemmsa002Bean(semmsa002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA002Action");
			flag = false;
			
			semmsa002Bean.setRenderedMsgAlert(true);
			setSemmsa002Bean(semmsa002Bean);
		} finally {
			LOG.info("::: SEMMSA002Action :: doClear >> END :::");
		}
		return flag;
	}
	
	public void doInitial002Bean(){
		try{
			semmsa002Bean = new SEMMSA002Bean();

			semmsa002Bean.setTeamList(getLovItemsByType(ELovType.T_SA_TEAM_LIST.name));
        	semmsa002Bean.setMemberList(getEmptyDropDown());
        	
        	semmsa002Bean.setSiteAppLocalObjParam(new SiteAppSP());
			// >> do initiate data
			semmsa002Bean.setChgReqObjParam(new SiteAppSP());
			semmsa002Bean.setSiteAppRentObjParam(new SiteAppSP());
			semmsa002Bean.setSiteAppRentAmt(new SiteAppSP());
			semmsa002Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
			semmsa002Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
			semmsa002Bean.setAmphurList(getEmptyDropDown());
			semmsa002Bean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList());
			semmsa002Bean.setAmphurReqDocList(getEmptyDropDown());
			semmsa002Bean.setAmphurLocalList(getEmptyDropDown());
			semmsa002Bean.setReqOfficerList(SelectItemLOVCacheUtil.getInstance().getLovItemsValueNameByType(ELovType.T_SI_SITE_APPROVE_FROM.name));
			semmsa002Bean.setZoneList(ZoneCasheUtil.getInstance().getZoneSelList());
			semmsa002Bean.setElCondTypeList(getEmptyDropDown()); 
			semmsa002Bean.setElCondSubTypeList(getEmptyDropDown()); 
			semmsa002Bean.setLocationList(getLovItemsByType(ELovType.T_SI_PLACE_TYPE.name));
			
			semmsa002Bean.setLandAreaTypeList(getLovItemsByType(ELovType.T_SI_LAND_AREA_TYPE.name));
			
			semmsa002Bean.setPlaceTypeList(getLovItemsByType(ELovType.T_SI_PLACE_TYPE.name));
			semmsa002Bean.setDeckAreaTypeList(getLovItemsByType(ELovType.T_SI_DECK_AREA_TYPE.name));
			semmsa002Bean.setRoomAreaTypeList(getLovItemsByType(ELovType.T_SI_ROOM_AREA_TYPE.name));
			semmsa002Bean.setBuildingAreaTypeList(getLovItemsByType(ELovType.T_SI_BUILDING_AREA_TYPE.name));
			
			semmsa002Bean.setAreaUnitTypeList(getLovItemsByType(ELovType.T_SI_AREA_UNIT_TYPE.name));
			
			semmsa002Bean.setPackagePeriodTypeList(getLovItemsByType(ELovType.T_SI_RENEW_AGE_CODE.name));
			semmsa002Bean.setPromiseRenewPeriodTypeList(getLovItemsByType(ELovType.T_CT_PERIOD_TYPE.name));
			semmsa002Bean.setRentPeriodTypeList(getLovItemsByType(ELovType.T_SI_RENEW_AGE_CODE.name));
			
			semmsa002Bean.setLegalPlaceTypeList(getLovItemsByType(ELovType.T_SI_LEGAL_PLACE_TYPE.name));
			semmsa002Bean.setLegalPartiesTypeList(getLovItemsByType(ELovType.T_SI_LEGAL_PARTIES_TYPE.name));
			semmsa002Bean.setReqTitleList(getLovItemsByType(ELovType.T_SA_REQ_TITLE.name));
			semmsa002Bean.setElUseTypeList(getLovItemsByType(ELovType.T_SA_ELECTRIC_TYPE.name));
			
			semmsa002Bean.setTitleList(getLovItemsByType(ELovType.T_SA_SITE_APP_TITLE.name));
			
			semmsa002Bean.setSiteAppTab0ObjParam(new SiteAppSP());	// object tab0
			
			semmsa002Bean.setSiteAppTab7ObjParam(new SiteAppMailSP());	// object tab7
			
			semmsa002Bean.setMsa002Tab7AmphurList(getEmptyDropDown()); //tab7
			semmsa002Bean.setMsa002Tab7ProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList()); // tab7
			
			semmsa002Bean.setMsa002Tab2AmphurList(getEmptyDropDown()); //tab2
			semmsa002Bean.setMsa002Tab2ProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList()); // tab2
			
			semmsa002Bean.setCoOperatorList(getLovItemsByType(ELovType.T_CT_CO_COMPANY.name));
			
			semmsa002Bean.setDocTypeList(getEmptyDropDown());
			
			semmsa002Bean.setSiteTypeList(getLovItemsByType(ELovType.T_SI_SITE_TYPE.name));
			
			semmsa002Bean.setOwnerCategoryList(getEmptyDropDown());
			semmsa002Bean.setOwnerSubCategoryList(getEmptyDropDown());
			
			semmsa002Bean.setOwnerCategoryList(getLovItemsByType(ELovType.T_SA_OWNER_CATEGORY.name));
			semmsa002Bean.setOwnerSubCategoryList(getLovItemsByType(ELovType.T_SA_OWNER_SUB_CATEGORY.name));
			
			semmsa002Bean.setRentAdjList(getLovItemsByType(ELovType.T_SA_RENT_ADJ.name));
			
			//TODO init TAB3
			semmsa002Bean.setExpenseTypeDepositRentList(getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name,EX_IN, ELovVal.V_CT_DEPOSIT_RENT.name, null, null));
			semmsa002Bean.setExpenseTypeRentList(getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name,EX_AND, ELovVal.V_CT_RENT.name, null, null));
			semmsa002Bean.setSiteAppDeptObj(new SiteAppSP());
			//
			semmsa002Bean.setMsa002Tab2ProvinceLessorList(ProvinceCacheUtil.getInstance().getProvinceSelList());
			semmsa002Bean.setMsa002Tab2AmphurLessorList(getEmptyDropDown());
			
			semmsa002Bean.setMsa002Tab2ProvinceContactList(ProvinceCacheUtil.getInstance().getProvinceSelList());
			semmsa002Bean.setMsa002Tab2AmphurContactList(getEmptyDropDown());
			
			semmsa002Bean.setContractElUseObjParam(new SiteAppSP());
			semmsa002Bean.setSiteAppDeptObj(new SiteAppSP());
			semmsa002Bean.setSiteAppDeptCashObj(new SiteAppSP());
			semmsa002Bean.setSiteAppDeptBgObj(new SiteAppSP());
			// << do initiate data
			
			//TODO init TAB4
			semmsa002Bean.setSiteAppELObjParam(new SiteAppSP());
			semmsa002Bean.setExpenseTypeDepositElList(getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name,EX_IN, ELovVal.V_CT_DEPOSIT_ELECTRIC.name, null, null));
			semmsa002Bean.setSiteAppELCondTakeAllList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
			semmsa002Bean.setSiteAppELCondUnitList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
			semmsa002Bean.setSiteAppELCondOtherList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
			semmsa002Bean.setElCondTypeList(getLovItemsByType(ELovType.T_SA_EL_COND_TYPE.name)); 
			semmsa002Bean.setElCondSubTypeList(getLovItemsByType(ELovType.T_SA_EL_COND_SUB_TYPE.name)); 
			semmsa002Bean.setSiteAppDeptElObj(new SiteAppSP());
			semmsa002Bean.setSiteAppELCondExistingList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
			semmsa002Bean.setSiteAppELCondAllList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
			semmsa002Bean.setSiteAppELCondUnitList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
			semmsa002Bean.setSiteAppELCondTakeAllList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
			semmsa002Bean.setSiteAppELCondOtherList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
			semmsa002Bean.setSiteAppELCondNoExpenseList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
			semmsa002Bean.setSiteAppDeptCashElObj(new SiteAppSP());
			semmsa002Bean.setSiteAppDeptBgElObj(new SiteAppSP());
			
			//TODO init TAB5
			semmsa002Bean.setSiteAppPTObjParam(new SiteAppSP());
			semmsa002Bean.setSiteAppPTObj(new SiteAppSP());
			semmsa002Bean.setSiteAppPTHistList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
			
			//TODO init TAB6
			semmsa002Bean.setInsuranceTypeList(getEmptyDropDown());
			semmsa002Bean.setInsuranceTypeList(getLovItemsByType(ELovType.T_SA_IR_TYPE.name));
			semmsa002Bean.setSiteAppInsuranceObjParam(new SiteAppSP());
			semmsa002Bean.setSiteAppInsuranceObj(new SiteAppSP());
			semmsa002Bean.setSiteAppInsuranceList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
			semmsa002Bean.setPeriodTypeList(getLovItemsByType(ELovType.T_CT_PERIOD_TYPE.name));
			
			
			// -- back in case SA
			String paramUrl = getFacesUtils().getRequestParameter("paramUrl") == null ? "" : (String) getFacesUtils().getRequestParameter("paramUrl");
			String paramMenuGroup = getFacesUtils().getRequestParameter("paramMenuGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuGroup");
			String paramMenuType = getFacesUtils().getRequestParameter("paramMenuType") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuType");
			semmsa002Bean.setPanelDisplay(paramUrl);
			semmsa002Bean.setMenuGroupDisplay(paramMenuGroup);
			semmsa002Bean.setMenuGroupType(paramMenuType);
			//
//			System.out.println("paramMenuGroup = "+paramMenuGroup);
			semmsa002Bean.setRenderedBtnBack(true);
			semmsa002Bean.setRenderedBtnBackOther(false);
			
			
			// -- back in case Other
			this.doPrepareBackward();
			//
			
			setSemmsa002Bean(semmsa002Bean);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doInitial002Bean");
		}
	}
	
	public boolean doInitialMsa002Tab() {
		LOG.info("::: SEMMSA002Action :: doInitialMsa002Tab >> BEGIN :::");
		boolean flag = true;
		
		try {
			
			this.doInitial002Bean();
			
			//TODO init All TAB
			this.doInitialMSA002AllDetail();
			this.msa002Tab1_APP_SITE_SEARCH_dataTable();
			
			//TODO init TAB1
			//added by NEW 12/06/2018 get Service Existing 
			this.doInitSiteAcqServ("E");
			//added by NEW 12/06/2018 get Service Current 
			this.doInitSiteAcqServ("C");
			//added by NEW 12/06/2018 get Service All 
			this.doInitSiteAcqServ("A");
			//
		
			
			this.doGetSiteContractMasterInfo();
			
			//TODO get Service DropDown
			this.doGetSiteAppServSelItem();
			
		
			
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA002Action");
			flag = false;
			
			semmsa002Bean.setRenderedMsgAlert(true);
			setSemmsa002Bean(semmsa002Bean);
		} finally {
			LOG.debug("##### init getSiteAppId : "+semmsa002Bean.getSiteAppRentObjParam().getSiteAppId());
			LOG.debug("##### init getPtTaxPayType : "+semmsa002Bean.getSiteAppPTObj().getPtTaxPayType());
			setSemmsa002Bean(semmsa002Bean);
			LOG.info("::: SEMMSA002Action :: doInitialMsa002Tab >> END :::");
		}
		return flag;
	}
	
	
	public boolean doInitChangeTab() {
		LOG.info("::: SEMMSA002Action :: doInitChangeTab >> BEGIN :::");
		boolean flag = false;

		try {
			//doClearUpload();
			semmsa002Bean = getSemmsa002Bean();
			
			// -- on change tab
			this.doUpdateAllonChangeTab();
			// -- on change tab

			String tabNo = getFacesUtils().getRequestParameter("tabNo") == null ? "" : (String) getFacesUtils().getRequestParameter("tabNo");
			String paramMode = getFacesUtils().getRequestParameter("paramMode") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMode");
			LOG.info("ooo paramTabNo: " + tabNo);
			LOG.info("ooo paramMode: " + paramMode); // 'V' = view only, 'S' = edit some, 'E' = edit all,
			
			
			semmsa002Bean.setSelectedTab("tab" + tabNo);
			semmsa002Bean.setTabNo(tabNo);
			//set saveFlag TO N
			semmsa002Bean.getSiteAppObjParam().setSaveFlag("N");
//			System.out.println("SaveFlag =: "+semmsa002Bean.getSiteAppObjParam().getSaveFlag());
			
			//default not edit
//			semmsa002Bean.getSiteAppObjParam().setElEditFlag("N");
//			semmsa002Bean.getSiteAppObjParam().setElDepositEditFlag("N");
			
			// tab2 Contract Info
			if(tabNo.equals("2")){
				this.msa002Tab2_initiate();
			}
			
			//tab3 Rental
			if(tabNo.equals("3")){
				//added by NEW 11/02/2016
				this.initUpdateRentCond();
				this.initUpdateRentServiceCond();
				//TODO init TAB3
				//added by NEW 12/06/2018 get Service Existing 
				this.doInitSiteAcqServ("E");
				//added by NEW 12/06/2018 get Service Current 
				this.doInitSiteAcqServ("C");
				//added by NEW 12/06/2018 get Service All 
				this.doInitSiteAcqServ("A");
				//
				
				//TODO init TAB3
				semmsa002Bean.setExpenseTypeDepositRentList(getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name,EX_IN, ELovVal.V_CT_DEPOSIT_RENT.name, null, null));
				this.doGetSiteAppRentContExisting();
				this.doGetSiteAppRentCont();
				LOG.debug("##### init getSiteAppId : "+semmsa002Bean.getSiteAppRentObjParam().getSiteAppId());
				this.doGetSiteAppRentServSrch();
				this.doGetSiteAppRentAmtSrch();
				this.doRenderDeptBgCash();
				this.doSiteAppDepositSrch();
				//
				
//				if(semmsa002Bean.getSiteAppObjParam().getServPaymentPeriod()!=null){
//					if("".equals(semmsa002Bean.getSiteAppObjParam().getServPaymentPeriod())){
//						semmsa002Bean.getSiteAppObjParam().setServPaymentPeriod("01");
//					}
//				}else{
//					semmsa002Bean.getSiteAppObjParam().setServPaymentPeriod("01");
//				}
				//get rent total
				this.doGetSiteAppRentAmtSrch();
				
				//get rent serv 
				this.doGetSiteAppRentServSrch();
				
				//set default rent PeriodStartDt
				if(semmsa002Bean.getSiteAppObjParam().getEffectiveDt() != null)
					semmsa002Bean.getSiteAppRentObjParam().setPeriodStartDt(semmsa002Bean.getSiteAppObjParam().getEffectiveDt());
				
				//set default rent setPeriodEndDt
				if(semmsa002Bean.getSiteAppObjParam().getExpireDt() != null)
					semmsa002Bean.getSiteAppRentObjParam().setPeriodEndDt(semmsa002Bean.getSiteAppObjParam().getExpireDt());
				
				//set default rental No Vat
				semmsa002Bean.getSiteAppRentObjParam().setRentVatType("04");
				//set default rental Deposit No Vat
				semmsa002Bean.getSiteAppDeptObj().setVatType("04");
			}
//				
//				if(semmsa002Bean.getSiteAppObjParam().getRentAmt() == null) semmsa002Bean.getSiteAppObjParam().setRentAmt(new BigDecimal(0));
//				if(semmsa002Bean.getSiteAppObjParam().getRentServiceAmt() == null) semmsa002Bean.getSiteAppObjParam().setRentServiceAmt(new BigDecimal(0));
//				
//				if((semmsa002Bean.getSiteAppObjParam().getRentAmt() > 0) || (semmsa002Bean.getSiteAppObjParam().getRentServiceAmt() > 0)){
//					semmsa002Bean.setChkRentalPayOneCond(true);
//					semmsa002Bean.setChkRentalPayManyCond(false);
//				}
//				
//				if(semmsa002Bean.getSiteAppObjParam().getRentAreaAmtMemo() != null || semmsa002Bean.getSiteAppObjParam().getRentServiceAmtMemo() != null ||
//						semmsa002Bean.getSiteAppObjParam().getRentSetupAmtMemo() != null || semmsa002Bean.getSiteAppObjParam().getRentOtherAmtMemo() != null){
//					semmsa002Bean.setChkRentalPayOneCond(false);
//					semmsa002Bean.setChkRentalPayManyCond(true);
//				}
//			}
			
			
			// --

			// tab4 EL
			if(tabNo.equals("4")){
				
				semmsa002Bean.setRowPerPage(10);
				
				//TODO init TAB4
				//this.doSiteAppELCondSrch();
				this.doSiteAppELCondSrch("H");
				this.doSiteAppELCondSrch("C");
				
				doSiteAppDepositSrch();
				semmsa002Bean.getSiteAppDeptElObj().setVatType("04");
				

				
				System.out.println("chkElUseOth " +semmsa002Bean.getSiteAppObjParam().getElUseNewMeter());
				System.out.println("chkElUseOth " +semmsa002Bean.getSiteAppObjParam().getElUseMultiResourse());
				System.out.println("chkElUseOth " +semmsa002Bean.getSiteAppObjParam().getElUseOldMeter());
				
				if(semmsa002Bean.getSiteAppObjParam().getElUseMultiResourse().equals("Y")){
					semmsa002Bean.setChkMultiElectricTypeFlag(true);
				}
				if(semmsa002Bean.getSiteAppObjParam().getElUseNewMeter().equals("Y")){
					semmsa002Bean.setChkElUseNewMeter(true);
				}
				if(semmsa002Bean.getSiteAppObjParam().getElUseOldMeter().equals("Y")){
					semmsa002Bean.setChkElUseOldMeter(true);
				}
				if(semmsa002Bean.getSiteAppObjParam().getElUseOwner().equals("Y")){
					semmsa002Bean.setChkElUseOwner(true);
				}
				if(semmsa002Bean.getSiteAppObjParam().getElUseOthSite().equals("Y")){
					semmsa002Bean.setChkElUseOthSite(true);
				}
				if(semmsa002Bean.getSiteAppObjParam().getElUseOth().equals("Y")){
					semmsa002Bean.setChkElUseOth(true);
				}
				

				
				if(semmsa002Bean.isChkElUseOthSite()){
					//this.doSiteAppELCondSrch("O");
					if(semmsa002Bean.getSiteAppELCondTakeAllList() != null && semmsa002Bean.getSiteAppELCondTakeAllList().size() > 0){
						semmsa002Bean.setRenderedTbElUseOth(true);
					}else{
						semmsa002Bean.setRenderedTbElUseOth(false);
					}
				}
				
				
				if(semmsa002Bean.isChkElUseOwner()){
					semmsa002Bean.setDisabledElctTypeDetail(false);
					if(semmsa002Bean.isChkElPayOnPackage()){
						semmsa002Bean.setDisabledElctPackageTypeDetail(false);
						semmsa002Bean.setDisabledElctUnitTypeDetail(true);
					}
					if(semmsa002Bean.isChkElOwnerType()){
						semmsa002Bean.setDisabledElctPackageTypeDetail(true);
						semmsa002Bean.setDisabledElctUnitTypeDetail(false);
					}
					
					if(semmsa002Bean.getSiteAppObjParam().getElVatType() == null){
						semmsa002Bean.getSiteAppObjParam().setElVatType("");
					}
				}else{
					semmsa002Bean.setDisabledElctTypeDetail(true);
					semmsa002Bean.setDisabledElctPackageTypeDetail(true);
					semmsa002Bean.setDisabledElctUnitTypeDetail(true);
					//semmsa002Bean.setChkEditElExistingList(false);
					
				}
				
				if(semmsa002Bean.isChkElUseOthSite()){
					semmsa002Bean.setDisabledElUserOthSite(false);
				}else{
					semmsa002Bean.setDisabledElUserOthSite(true);
				}
				
				//set default El PeriodStartDt
//				if(semmsa002Bean.getSiteAppObjParam().getEffectiveDt() != null)
//					semmsa002Bean.getSiteAppELObjParam().setPeriodStartDt(semmsa002Bean.getSiteAppObjParam().getEffectiveDt());
				
				//set default El setPeriodEndDt
//				if(semmsa002Bean.getSiteAppObjParam().getExpireDt() != null)
//					semmsa002Bean.getSiteAppELObjParam().setPeriodEndDt(semmsa002Bean.getSiteAppObjParam().getExpireDt());
				checkEdit();
			}
			
			//tab5 PT
			if(tabNo.equals("5")){
				
				//TODO init TAB5
				this.doSiteAppTPSrch();
				this.doSiteAppTPHistSrch();
				
			}
			
			//tab6 IR
			if(tabNo.equals("6")){
				//set Default Insurance No VAT
				semmsa002Bean.getSiteAppInsuranceObjParam().setOwnerVatType("04");
				//TODO init TAB6
				this.doSiteAppIRSrch();
				this.doSiteAppIRHistSrch();
				
			}
			
			//tab7 contract Doc
			if(tabNo.equals("7")){
				//TODO init TAB7
				this.doSiteAppDocSrch("E");
				this.doSiteAppDocSrch("H");
				
			}
			
			// tab8 mail address 
			if(tabNo.equals("9")){
				this.msa002Tab7_initiate();
			}
			FrontMessageUtils.deleteMessage();
			setSemmsa002Bean(semmsa002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA002Action");
			flag = false;
			
			semmsa002Bean.setRenderedMsgAlert(true);
			setSemmsa002Bean(semmsa002Bean);
		} finally {
			LOG.info("::: SEMMSA002Action :: doInitChangeTab >> END :::");
		}
		return flag;
	}
	
	public boolean doUpdateAll() {
		LOG.info("::: SEMMSA002Action :: doUpdateAll >> BEGIN :::");
		boolean flag = false;

		try {
			
			semmsa002Bean = getSemmsa002Bean();
			
			String paramSiteAppId = getFacesUtils().getRequestParameter("paramSiteAppId") == null ? "" : (String) getFacesUtils().getRequestParameter("paramSiteAppId");
			String saveFlag = getFacesUtils().getRequestParameter("saveFlag") == null ? "" : (String)getFacesUtils().getRequestParameter("saveFlag");
			LOG.info("ooo siteAppId: " + paramSiteAppId);
			
			ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService");

			semmsa002Bean.getSiteAppObjParam().setUserLogin(getUserLogIn());
			semmsa002Bean.getSiteAppObjParam().setUpdateBy(getUserLogIn());

			String strDocNo = semmsa002Bean.getSiteAppObjParam().getDocNo() == null ? "" : semmsa002Bean.getSiteAppObjParam().getDocNo().toString();
			String strContractName = semmsa002Bean.getSiteAppObjParam().getContactName() == null ? "" : semmsa002Bean.getSiteAppObjParam().getContactName().toString();
			Date dtmDocDt = semmsa002Bean.getSiteAppObjParam().getDocDt();
			Date dtmEffectiveDt = semmsa002Bean.getSiteAppObjParam().getEffectiveDt();
			Date dtmExpireDt = semmsa002Bean.getSiteAppObjParam().getExpireDt();
			String lessorName = semmsa002Bean.getSiteAppObjParam().getLessorName();
			Date dtmChangeEffDt = semmsa002Bean.getSiteAppObjParam().getChangeEffectiveDT();
			String contactMobile = semmsa002Bean.getSiteAppObjParam().getContactMobile() == null ? "" : semmsa002Bean.getSiteAppObjParam().getContactMobile();
			//Add By OUM 2/9/2016 for TaxID
			String taxId = semmsa002Bean.getSiteAppObjParam().getLessorTaxId() == null ? "" : (String)semmsa002Bean.getSiteAppObjParam().getLessorTaxId();
			//String strContactTel = semmsa002Bean.getSiteAppObjParam().getContactTel() == null ? "" : semmsa002Bean.getSiteAppObjParam().getContactTel().toString();
			//String strContactMobile = semmsa002Bean.getSiteAppObjParam().getContactMobile() == null ? "" : semmsa002Bean.getSiteAppObjParam().getContactMobile().toString();
			
			boolean myFlagValidate = false;
			
			if (strDocNo.equals("")) {
				addMessageError("W0001", msg("export.col.docNo")); //docNo
				semmsa002Bean.setRenderedMsgAlert(true);
				return false;
			}else if(StringUtils.isEmpty(semmsa002Bean.getSiteAppObjParam().getReqOfficer()) && 
					StringUtils.isEmpty(semmsa002Bean.getSiteAppObjParam().getReqOfficerManual())){ 
				addMessageError("W0001", msg("msg.reqOfficer")); //request officer
				semmsa002Bean.setRenderedMsgAlert(true);
				return false;
			}else if (dtmDocDt == null) {
				addMessageError("W0001", msg("export.col.date")); //docDt
				semmsa002Bean.setRenderedMsgAlert(true);
				return false;
			} else if (dtmEffectiveDt == null) {
				addMessageError("W0001", msg("message.contractStartDt")); // Dtexport.col.policyStartDt
				semmsa002Bean.setRenderedMsgAlert(true);
				return false;
			} else if (dtmExpireDt == null) {
				if(semmsa002Bean.isChkContractNeverExpire()) {
					myFlagValidate = true;
				} else {
					addMessageError("W0001", msg("message.contractEndDt")); // 
					semmsa002Bean.setRenderedMsgAlert(true);
					return false;
				}
//			}else if(contactMobile.equals("")){
//				addMessageError("W0001", msg("label.th_mobilePhone")); //docDt
//				semmsa002Bean.setRenderedMsgAlert(true);

			}else if(lessorName.equals("")){
				addMessageError("W0001", msg("message.lessorNames")); // 
				semmsa002Bean.setRenderedMsgAlert(true);
				return false;
			}else if (strContractName.equals("")) {
				addMessageError("W0001", msg("message.contactName")); // 
				semmsa002Bean.setRenderedMsgAlert(true);
				return false;
			} else if(semmsa002Bean.isDisabledChangeEffDate()){
				if(dtmChangeEffDt == null){
					addMessageError("W0001", msg("export.col.changeEffDt")); // 
					semmsa002Bean.setRenderedMsgAlert(true);
					return false;
				}else{
					myFlagValidate = true;
				}
			}else if (!taxId.equals("") && !taxId.equals(null)) {
				//Add By OUM 2/9/2016 for TaxID
				if(taxId.length()<13){
					addMessageError("W0001", msg("message.taxIdAlert")); // 
					semmsa002Bean.setRenderedMsgAlert(true);
					myFlagValidate = false;
					return false;
				}else {
					myFlagValidate = true;
				} 
			}else {
				myFlagValidate = true;
			}
			
			//check rent service EL PeriodType
			if(semmsa002Bean.getSiteAppObjParam().getRentAmt() != null && semmsa002Bean.getSiteAppObjParam().getRentAmt().doubleValue() > 0){
				if(semmsa002Bean.getSiteAppObjParam().getRentPeriodType() == null || "".equals(semmsa002Bean.getSiteAppObjParam().getRentPeriodType())){
					addMessageError("W0001", msg("message.rentPeriod")); // 
					semmsa002Bean.setRenderedMsgAlert(true);
					myFlagValidate = false;
					setSemmsa002Bean(semmsa002Bean);
					return false;
				}else{
					myFlagValidate = true;
				}
			}
			//service service
			if(semmsa002Bean.getSiteAppObjParam().getRentServiceAmt() != null && semmsa002Bean.getSiteAppObjParam().getRentServiceAmt().doubleValue() > 0){
				if(semmsa002Bean.getSiteAppObjParam().getRentServicePeriodType() == null || 
						"".equals(semmsa002Bean.getSiteAppObjParam().getRentServicePeriodType())){
					addMessageError("W0001", msg("message.servicePeriod")); // 
					semmsa002Bean.setRenderedMsgAlert(true);
					myFlagValidate = false;
					setSemmsa002Bean(semmsa002Bean);
					return false;
				}else{
					myFlagValidate = true;
				}
			}
			//EL PeriodType
			if(semmsa002Bean.getSiteAppObjParam().getElPayOnPackageAmt() != null && semmsa002Bean.getSiteAppObjParam().getElPayOnPackageAmt().doubleValue() > 0){
				if(semmsa002Bean.getSiteAppObjParam().getElPackagePeriodType() == null || 
						"".equals(semmsa002Bean.getSiteAppObjParam().getElPackagePeriodType())){
					addMessageError("W0001", msg("message.elPeriod")); // 
					semmsa002Bean.setRenderedMsgAlert(true);
					myFlagValidate = false;
					setSemmsa002Bean(semmsa002Bean);
					return false;
				}else{
					myFlagValidate = true;
				}
			}
		
			if(myFlagValidate) {
				
				this.doSetCheckBoxEntity();
				//added by NEW 12/02/2016 for init set param รายxเดือน รายxปี
				if(semmsa002Bean.getPayPeriod03() != null)
					semmsa002Bean.getSiteAppObjParam().setRentPaymentPeriodOth(semmsa002Bean.getPayPeriod03());
				if(semmsa002Bean.getPayPeriod04() != null)
					semmsa002Bean.getSiteAppObjParam().setRentPaymentPeriodOth(semmsa002Bean.getPayPeriod04());
				
				if(semmsa002Bean.getServicePayPeriod03() != null)
					semmsa002Bean.getSiteAppObjParam().setServPaymentPeriodOth(semmsa002Bean.getServicePayPeriod03());
				if(semmsa002Bean.getServicePayPeriod04() != null)
					semmsa002Bean.getSiteAppObjParam().setServPaymentPeriodOth(semmsa002Bean.getServicePayPeriod04());
				
				//added by NEW 20160323 set save Action
				if("Y".equals(saveFlag))semmsa002Bean.getSiteAppObjParam().setSaveFlag("Y");
//				System.out.println("SaveFlag =: "+semmsa002Bean.getSiteAppObjParam().getSaveFlag()); 
				//added by NEW 17/02/2016 clear data not use
				this.doCheckNoExpenses();
				LOG.debug("elVatType = "+semmsa002Bean.getSiteAppObjParam().getElVatType());
				LOG.debug("semmsa002Bean.getSiteAppObjParam().getLeaseHoldRights) =: "+semmsa002Bean.getSiteAppObjParam().getLeaseHoldRights());
				LOG.debug("semmsa002Bean.getSiteAppObjParam().getContractWanted) =: "+semmsa002Bean.getSiteAppObjParam().getContractWanted());
				LOG.debug("semmsa002Bean.getSiteAppObjParam().getLicense) =: "+semmsa002Bean.getSiteAppObjParam().getLicense());
				LOG.debug("semmsa002Bean.getSiteAppObjParam().getLlRentalAgreement) =: "+semmsa002Bean.getSiteAppObjParam().getLlRentalAgreement());
				LOG.debug("semmsa002Bean.getSiteAppObjParam().getDeckAreaType) =: "+semmsa002Bean.getSiteAppObjParam().getDeckAreaType());
				LOG.debug("semmsa002Bean.getSiteAppObjParam().getBuildingAreaType) =: "+semmsa002Bean.getSiteAppObjParam().getBuildingAreaType());
				LOG.debug("semmsa002Bean.getSiteAppObjParam().getPlaceType() = "+semmsa002Bean.getSiteAppObjParam().getPlaceType());
				LOG.debug("semmsa002Bean.getSiteAppObjParam().deckAreaUnitType() = "+semmsa002Bean.getSiteAppObjParam().getDeckAreaUnitType());
				
			   /*====== Begin 28/07/2022 Modify Parameter for Postgresql ====*/	
				SiteAppSP pData = semmsa002Bean.getSiteAppObjParam();
				ObjectMapper mapper = new ObjectMapper();
				String jsonStr = "";
				SemTySaSiteAppUpd dataSaSiteAppUpd = new SemTySaSiteAppUpd();
				
			    try {		   				    
				jsonStr = mapper.writeValueAsString(pData);				
				
				//semmsa002Bean.getSiteAppObjParam().setJsonData(jsonStr);				
				
				dataSaSiteAppUpd.setJsonData(jsonStr);
				
				//LOG.info("Save ===> UpdateALL json :"+jsonStr);
				
			    } catch (JsonProcessingException e) {
			   	   e.printStackTrace();
			   }
			   /*====== End 28/07/2022 Modify Parameter for Postgresql ====*/	  
				
				//List<SiteAppSP> to = service.siteAppDao_querySPList(EQueryName.SP_MSA002_SITE_APP_UPD.name, semmsa002Bean.getSiteAppObjParam());
			    List<SiteAppSP> to = service.siteAppDao_querySPList(EQueryName.SP_MSA002_SITE_APP_UPD.name, dataSaSiteAppUpd);
				
				if (to != null && !to.isEmpty()) {
					String retMsg = to.get(0).getRetResultMsg() == null ? "" : to.get(0).getRetResultMsg().toString();
					
					if (to.get(0).getRetResult().equals("Success")) {

						this.doUpdateLegalDoc();
						
						String myMsgArr[];
						if(!retMsg.equals("")){
							myMsgArr = retMsg.split("<BR/>");
							
							for(int i=0; i < myMsgArr.length; i++){
								//addGeneralMessageInfo(myMsgArr[i]);
								//addGeneralMessageWarn(myMsgArr[i]);
								FrontMessageUtils.addMessageWarn(myMsgArr[i]);	// optional
							}
						}
						flag = true;
						semmsa002Bean.setRenderedMsgAlert(true);
					} else {
						if(to.get(0).getRetResult() != null){
							//if("FAIL".equals(to.get(0).getRetResult().toUpperCase())){
							if(to.get(0).getRetResult().toUpperCase().contains("FAIL")){
								LOG.error("ERROR SP_MSA002_SITE_APP_UPD :"+to.get(0).getRetResult());
								semmsa002Bean.setDisabledButtonPopupResult(false);
							}else if("FAIL2".equals(to.get(0).getRetResult().toUpperCase())){
								semmsa002Bean.setDisabledButtonPopupResult(true);
							}
							
						}
//						System.out.println("to.get(0).getRetResultMsg() = "+to.get(0).getRetResultMsg());
						if(to.get(0).getRetResultMsg() != null)
							addGeneralMessageError(to.get(0).getRetResultMsg());	// data save fail						
						else
							addMessageError("E0001");	// data save fail
		        		semmsa002Bean.setRenderedMsgAlert(true);
					}
				}
			} 
			
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA002Action");
			flag = false;
			
			semmsa002Bean.setRenderedMsgAlert(true);
			setSemmsa002Bean(semmsa002Bean);
		} finally {
			setSemmsa002Bean(semmsa002Bean);
			LOG.info("::: SEMMSA002Action :: doUpdateAll >> END :::");
		}
		return flag;
	}
	
	//added by NEW 2016/10/18
	public boolean doCheckTaxId(){
		boolean flag = false;
		semmsa002Bean = getSemmsa002Bean();
		String taxId = semmsa002Bean.getSiteAppObjParam().getLessorTaxId();
		semmsa002Bean.setRenderedMsgAlert(false);
		try{
			if (!taxId.equals("") && !taxId.equals(null)) {
				if(!StringUtils.isNumeric(taxId)){
					addMessageErrorWithArgument("W0007" ,msg("label.th_personalTaxId"));
					semmsa002Bean.setRenderedMsgAlert(true);
//					semmsa002Bean.setRenderedMsgFormChkExpire(true);
					flag = true;
					setSemmsa002Bean(semmsa002Bean);
					return flag;
				}
				
//				System.out.println("taxId.length : "+taxId.length());
				if(taxId.length()>13 || taxId.length()<13 ){
//					addMessageError("W0001", msg("message.taxIdAlert")); // 
					addMessageErrorWithArgument("W0092" ,msg("label.th_personalTaxId"), "13");
					semmsa002Bean.setRenderedMsgAlert(true);
//					semmsa002Bean.setRenderedMsgFormChkExpire(true);
					flag = true;
					setSemmsa002Bean(semmsa002Bean);
					return flag;
				}else{
					semmsa002Bean.setRenderedMsgAlert(false);
				}
			}else{
				semmsa002Bean.setRenderedMsgAlert(false);
			}
		}catch (Exception e) {
			LOG.debug("error Semmsa002Action doCheckTaxId : "+e);
			// TODO: handle exception
		}finally{
			setSemmsa002Bean(semmsa002Bean);
		}
		return flag;
	}
	
	public String doUpdateAllonChangeTab() {
		LOG.info("::: SEMMSA002Action :: doUpdateAllBeforeChangeTab >> BEGIN :::");
		String strRet = "";
		
		try {
			
			semmsa002Bean = getSemmsa002Bean();
			LOG.debug("semmsa002Bean.getSiteAppObjParam().getPlaceType() = "+semmsa002Bean.getSiteAppObjParam().getPlaceType());
			String strSiteAppId = semmsa002Bean.getSiteAppObjParam().getSiteAppId() == null ? "" : semmsa002Bean.getSiteAppObjParam().getSiteAppId();
			LOG.info("ooo siteAppId: " + strSiteAppId);

			ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService");

			semmsa002Bean.getSiteAppObjParam().setUserLogin(getUserLogIn());
			semmsa002Bean.getSiteAppObjParam().setUpdateBy(getUserLogIn());

			this.doSetCheckBoxEntity();
			LOG.debug("semmsa002Bean.getSiteAppObjParam().getPlaceType() = "+semmsa002Bean.getSiteAppObjParam().getPlaceType());
			LOG.debug("semmsa002Bean.getSiteAppObjParam().getOwnerCategory() = "+semmsa002Bean.getSiteAppObjParam().getOwnerCategory());
			LOG.debug("semmsa002Bean.getSiteAppObjParam().getElUseOth() = "+semmsa002Bean.getSiteAppObjParam().getElUseOth());
		
			
			/*====== Begin 28/07/2022 Modify Parameter for Postgresql ====*/	
			SiteAppSP pData = semmsa002Bean.getSiteAppObjParam();
			ObjectMapper mapper = new ObjectMapper();
			String jsonStr = "";
			SemTySaSiteAppUpd dataSaSiteAppUpd = new SemTySaSiteAppUpd();
			
		    try {		   				    
			jsonStr = mapper.writeValueAsString(pData);				
			
			//semmsa002Bean.getSiteAppObjParam().setJsonData(jsonStr);				
			
			dataSaSiteAppUpd.setJsonData(jsonStr);
			
			LOG.info("Save ===> UpdateALL json :"+jsonStr);
			
		    } catch (JsonProcessingException e) {
		   	   e.printStackTrace();
		   }
		   /*====== End 28/07/2022 Modify Parameter for Postgresql ====*/				
			
			//List<SiteAppSP> to = service.siteAppDao_querySPList(EQueryName.SP_MSA002_SITE_APP_UPD.name, semmsa002Bean.getSiteAppObjParam());
		   List<SiteAppSP> to = service.siteAppDao_querySPList(EQueryName.SP_MSA002_SITE_APP_UPD.name, dataSaSiteAppUpd); 
			
			if (to != null && !to.isEmpty()) {
				if (to.get(0).getRetResult().equals("Success")) {
					this.doUpdateLegalDoc();
					
					strRet = "Success";
				} else {
					strRet = to.get(0).getRetResultMsg().toString();
					LOG.error(to.get(0).getRetResult());
				}
			}

			semmsa002Bean.setRenderedMsgAlert(false);
			setSemmsa002Bean(semmsa002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
		} finally {
			LOG.info("::: SEMMSA002Action :: doUpdateAllBeforeChangeTab >> END :::");
		}
		
		return strRet;
	}
	
	public void chkRantelNoExpenses(){
		LOG.debug("::: SEMMSA002Action :: chkRantelNoExpenses >> BEGIN :::");
		semmsa002Bean = getSemmsa002Bean();
		try{
			if(semmsa002Bean.isChkRentalNoExpenses()){
				semmsa002Bean.setSiteAppRentObjParam(new SiteAppSP());
			}else{
				semmsa002Bean.setSiteAppRentObjParam(new SiteAppSP());
				
				//set default rent PeriodStartDt
				if(semmsa002Bean.getSiteAppObjParam().getEffectiveDt() != null)
					semmsa002Bean.getSiteAppRentObjParam().setPeriodStartDt(semmsa002Bean.getSiteAppObjParam().getEffectiveDt());
				
				//set default rent setPeriodEndDt
				if(semmsa002Bean.getSiteAppObjParam().getExpireDt() != null)
					semmsa002Bean.getSiteAppRentObjParam().setPeriodEndDt(semmsa002Bean.getSiteAppObjParam().getExpireDt());
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("::: SEMMSA002Action :: chkRantelNoExpenses >> ERROR :::");
		}finally{
			setSemmsa002Bean(semmsa002Bean);
		}
		LOG.debug("::: SEMMSA002Action :: chkRantelNoExpenses >> END :::");
	}
	
	public void msa002_chkRentalPayConditions(){
		LOG.info("::: SEMMSA002Action :: doChkRentalPayConditions >> BEGIN :::");
		semmsa002Bean = getSemmsa002Bean();
		SiteAppSP siteAppSp = semmsa002Bean.getSiteAppObjParam();
		String paramRantalType = getFacesUtils().getRequestParameter("paramRantalType") == null ? "" : (String)getFacesUtils().getRequestParameter("paramRantalType");
		try{
			if(!paramRantalType.equals("")){
				//rental one condition
				if(paramRantalType.equals("O")){
					if(semmsa002Bean.isChkRentalPayOneCond()){
						semmsa002Bean.setChkRentalPayOneCond(true);
						semmsa002Bean.setChkRentalPayManyCond(false);
						semmsa002Bean.setChkRentalNoExpenses(false);
						
//						semmsa002Bean.getSiteAppObjParam().setRentAreaAmtMemo("");
//						semmsa002Bean.getSiteAppObjParam().setRentServiceAmtMemo("");
//						semmsa002Bean.getSiteAppObjParam().setRentSetupAmtMemo("");
//						semmsa002Bean.getSiteAppObjParam().setRentOtherAmtMemo("");
//						semmsa002Bean.getSiteAppObjParam().setRentAreaMemoVatType("");
//						semmsa002Bean.getSiteAppObjParam().setRentAreaMemoWhtType("");
//						semmsa002Bean.getSiteAppObjParam().setRentServMemoVatType("");
//						semmsa002Bean.getSiteAppObjParam().setRentServMemoWhtType("");
//						semmsa002Bean.getSiteAppObjParam().setRentSetupMemoVatType("");
//						semmsa002Bean.getSiteAppObjParam().setRentSetupMemoWhtType("");
//						semmsa002Bean.getSiteAppObjParam().setRentOtherMemoVatType("");
//						semmsa002Bean.getSiteAppObjParam().setRentOtherMemoWhtType("");
//						semmsa002Bean.getSiteAppObjParam().setRentVatType("01");
//						semmsa002Bean.getSiteAppObjParam().setRentWhtType("01");
//						semmsa002Bean.getSiteAppObjParam().setRentPaymentPeriod("01");
//						semmsa002Bean.getSiteAppObjParam().setRentServiceVatType("01");
//						semmsa002Bean.getSiteAppObjParam().setRentServiceWhtType("01");
//						semmsa002Bean.getSiteAppObjParam().setServPaymentPeriod("01");
					}else{
						semmsa002Bean.setChkRentalPayOneCond(false);
						
//						semmsa002Bean.getSiteAppObjParam().setRentAmt(new BigDecimal(0));
//						semmsa002Bean.getSiteAppObjParam().setRentPeriodType("");
//						semmsa002Bean.getSiteAppObjParam().setRentAmtAdd(new BigDecimal(0));
//						semmsa002Bean.getSiteAppObjParam().setRentAmtAddPerc(new BigDecimal(0));
//						semmsa002Bean.getSiteAppObjParam().setRentVatType("");
//						semmsa002Bean.getSiteAppObjParam().setRentWhtType("");
//						semmsa002Bean.getSiteAppObjParam().setRentPaymentPeriod("");
////						semmsa002Bean.getSiteAppObjParam().setRentPaymentPeriodOth("");
//						semmsa002Bean.getSiteAppObjParam().setRentPaymentPeriodOth(0);
//						semmsa002Bean.getSiteAppObjParam().setRentServAmtAdd(new BigDecimal(0));
//						semmsa002Bean.getSiteAppObjParam().setRentServAmtAddPerc(new BigDecimal(0));
//						semmsa002Bean.getSiteAppObjParam().setRentServiceAmt(new BigDecimal(0));
//						semmsa002Bean.getSiteAppObjParam().setRentServicePeriodType("");
//						semmsa002Bean.getSiteAppObjParam().setRentServiceVatType("");
//						semmsa002Bean.getSiteAppObjParam().setRentServiceWhtType("");
//						semmsa002Bean.getSiteAppObjParam().setServPaymentPeriod("");
//						semmsa002Bean.getSiteAppObjParam().setServPaymentPeriodOth(0);
					}
					
				}
				//rental many condition
				if(paramRantalType.equals("M")){
					if(semmsa002Bean.isChkRentalPayManyCond()){
						semmsa002Bean.setChkRentalPayOneCond(false);
						semmsa002Bean.setChkRentalPayManyCond(true);
						semmsa002Bean.setChkRentalNoExpenses(false);
						
//						semmsa002Bean.getSiteAppObjParam().setRentAmt(new BigDecimal(0));
//						semmsa002Bean.getSiteAppObjParam().setRentPeriodType("");
//						semmsa002Bean.getSiteAppObjParam().setRentAmtAdd(new BigDecimal(0));
//						semmsa002Bean.getSiteAppObjParam().setRentAmtAddPerc(new BigDecimal(0));
//						semmsa002Bean.getSiteAppObjParam().setRentVatType("");
//						semmsa002Bean.getSiteAppObjParam().setRentWhtType("");
//						semmsa002Bean.getSiteAppObjParam().setRentPaymentPeriod("");
////						semmsa002Bean.getSiteAppObjParam().setRentPaymentPeriodOth("");
//						semmsa002Bean.getSiteAppObjParam().setRentPaymentPeriodOth(null);
//						semmsa002Bean.getSiteAppObjParam().setRentServAmtAdd(new BigDecimal(0));
//						semmsa002Bean.getSiteAppObjParam().setRentServAmtAddPerc(new BigDecimal(0));
//						semmsa002Bean.getSiteAppObjParam().setRentServiceAmt(new BigDecimal(0));
//						semmsa002Bean.getSiteAppObjParam().setRentServicePeriodType("");
//						semmsa002Bean.getSiteAppObjParam().setRentServiceVatType("");
//						semmsa002Bean.getSiteAppObjParam().setRentServiceWhtType("");
//						semmsa002Bean.getSiteAppObjParam().setServPaymentPeriod("");
//						semmsa002Bean.getSiteAppObjParam().setServPaymentPeriodOth(0);
//						
//						semmsa002Bean.getSiteAppObjParam().setRentAreaAmtMemo("");
//						semmsa002Bean.getSiteAppObjParam().setRentAreaMemoVatType("01");
//						semmsa002Bean.getSiteAppObjParam().setRentAreaMemoWhtType("01");
//						
//						semmsa002Bean.getSiteAppObjParam().setRentServiceAmtMemo("");
//						semmsa002Bean.getSiteAppObjParam().setRentServMemoVatType("01");
//						semmsa002Bean.getSiteAppObjParam().setRentServMemoWhtType("01");
//						
//						semmsa002Bean.getSiteAppObjParam().setRentSetupAmtMemo("");
//						semmsa002Bean.getSiteAppObjParam().setRentSetupMemoVatType("01");
//						semmsa002Bean.getSiteAppObjParam().setRentSetupMemoWhtType("01");
//						
//						semmsa002Bean.getSiteAppObjParam().setRentOtherAmtMemo("");
//						semmsa002Bean.getSiteAppObjParam().setRentOtherMemoVatType("01");
//						semmsa002Bean.getSiteAppObjParam().setRentOtherMemoWhtType("01");
					}else{
						semmsa002Bean.setChkRentalPayManyCond(false);
//						semmsa002Bean.getSiteAppObjParam().setRentAreaAmtMemo("");
//						semmsa002Bean.getSiteAppObjParam().setRentServiceAmtMemo("");
//						semmsa002Bean.getSiteAppObjParam().setRentSetupAmtMemo("");
//						semmsa002Bean.getSiteAppObjParam().setRentOtherAmtMemo("");
//						semmsa002Bean.getSiteAppObjParam().setRentAreaMemoVatType("");
//						semmsa002Bean.getSiteAppObjParam().setRentAreaMemoWhtType("");
//						semmsa002Bean.getSiteAppObjParam().setRentServMemoVatType("");
//						semmsa002Bean.getSiteAppObjParam().setRentServMemoWhtType("");
//						semmsa002Bean.getSiteAppObjParam().setRentSetupMemoVatType("");
//						semmsa002Bean.getSiteAppObjParam().setRentSetupMemoWhtType("");
//						semmsa002Bean.getSiteAppObjParam().setRentOtherMemoVatType("");
//						semmsa002Bean.getSiteAppObjParam().setRentOtherMemoWhtType("");
					}
					
				}
				//no expenses
				if(paramRantalType.equals("00")){
					if(semmsa002Bean.isChkRentalNoExpenses()){
						semmsa002Bean.setChkRentalPayOneCond(false);
						semmsa002Bean.setChkRentalPayManyCond(false);
						
//						semmsa002Bean.getSiteAppObjParam().setRentAmt(new BigDecimal(0));
//						semmsa002Bean.getSiteAppObjParam().setRentPeriodType("");
//						semmsa002Bean.getSiteAppObjParam().setRentAmtAdd(new BigDecimal(0));
//						semmsa002Bean.getSiteAppObjParam().setRentAmtAddPerc(new BigDecimal(0));
//						semmsa002Bean.getSiteAppObjParam().setRentVatType("");
//						semmsa002Bean.getSiteAppObjParam().setRentWhtType("");
//						semmsa002Bean.getSiteAppObjParam().setRentPaymentPeriod("");
////						semmsa002Bean.getSiteAppObjParam().setRentPaymentPeriodOth("");
//						semmsa002Bean.getSiteAppObjParam().setRentPaymentPeriodOth(null);
//						semmsa002Bean.getSiteAppObjParam().setRentServAmtAdd(new BigDecimal(0));
//						semmsa002Bean.getSiteAppObjParam().setRentServAmtAddPerc(new BigDecimal(0));
//						semmsa002Bean.getSiteAppObjParam().setRentServiceAmt(new BigDecimal(0));
//						semmsa002Bean.getSiteAppObjParam().setRentServicePeriodType("");
//						semmsa002Bean.getSiteAppObjParam().setRentServiceVatType("");
//						semmsa002Bean.getSiteAppObjParam().setRentServiceWhtType("");
//						semmsa002Bean.getSiteAppObjParam().setServPaymentPeriod("");
//						semmsa002Bean.getSiteAppObjParam().setServPaymentPeriodOth(0);
//						
//						semmsa002Bean.getSiteAppObjParam().setRentAreaAmtMemo("");
//						semmsa002Bean.getSiteAppObjParam().setRentAreaMemoVatType("01");
//						semmsa002Bean.getSiteAppObjParam().setRentAreaMemoWhtType("01");
//						
//						semmsa002Bean.getSiteAppObjParam().setRentServiceAmtMemo("");
//						semmsa002Bean.getSiteAppObjParam().setRentServMemoVatType("01");
//						semmsa002Bean.getSiteAppObjParam().setRentServMemoWhtType("01");
//						
//						semmsa002Bean.getSiteAppObjParam().setRentSetupAmtMemo("");
//						semmsa002Bean.getSiteAppObjParam().setRentSetupMemoVatType("01");
//						semmsa002Bean.getSiteAppObjParam().setRentSetupMemoWhtType("01");
//						
//						semmsa002Bean.getSiteAppObjParam().setRentOtherAmtMemo("");
//						semmsa002Bean.getSiteAppObjParam().setRentOtherMemoVatType("01");
//						semmsa002Bean.getSiteAppObjParam().setRentOtherMemoWhtType("01");
					}else{
						semmsa002Bean.setChkRentalPayManyCond(false);
						semmsa002Bean.setChkRentalNoExpenses(false);
//						semmsa002Bean.getSiteAppObjParam().setRentAreaAmtMemo("");
//						semmsa002Bean.getSiteAppObjParam().setRentServiceAmtMemo("");
//						semmsa002Bean.getSiteAppObjParam().setRentSetupAmtMemo("");
//						semmsa002Bean.getSiteAppObjParam().setRentOtherAmtMemo("");
//						semmsa002Bean.getSiteAppObjParam().setRentAreaMemoVatType("");
//						semmsa002Bean.getSiteAppObjParam().setRentAreaMemoWhtType("");
//						semmsa002Bean.getSiteAppObjParam().setRentServMemoVatType("");
//						semmsa002Bean.getSiteAppObjParam().setRentServMemoWhtType("");
//						semmsa002Bean.getSiteAppObjParam().setRentSetupMemoVatType("");
//						semmsa002Bean.getSiteAppObjParam().setRentSetupMemoWhtType("");
//						semmsa002Bean.getSiteAppObjParam().setRentOtherMemoVatType("");
//						semmsa002Bean.getSiteAppObjParam().setRentOtherMemoWhtType("");
					}
					
				}
				
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
			// TODO: handle exception
		}finally{
			LOG.info("::: SEMMSA002Action :: doChkRentalPayConditions >> END :::");
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	
	public boolean doSendOfficerApprove() {
		LOG.info("::: SEMMSA002Action :: doSendOfficerApprove >> BEGIN :::");
		boolean flag = true;

		try {
			
			semmsa002Bean = getSemmsa002Bean();
			
			String paramSiteAppId = getFacesUtils().getRequestParameter("paramSiteAppId") == null ? "" : (String) getFacesUtils().getRequestParameter("paramSiteAppId");
			LOG.info("ooo siteAppId: " + paramSiteAppId);

			ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService");

			semmsa002Bean.getSiteAppObjParam().setSiteAppId(paramSiteAppId);
			semmsa002Bean.getSiteAppObjParam().setUserLogin(getUserLogIn());
			semmsa002Bean.getSiteAppObjParam().setUpdateBy(getUserLogIn());

			List<SiteAppSP> to = service.siteAppDao_querySPList(EQueryName.SP_MSA001_OFFICER_APPROVE.name, semmsa002Bean.getSiteAppObjParam());
			
			if (to != null && !to.isEmpty()) {
				if (to.get(0).getRetResult().equals("Success")) {
					addMessageInfo("M0001");	// data save success
					semmsa002Bean.setRenderedMsgAlert(true);
				} else {
					addMessageError("E0001");	// data save fail
	        		semmsa002Bean.setRenderedMsgAlert(true);
				}
			}
			
			setSemmsa002Bean(semmsa002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA002Action");
			flag = false;
			
			semmsa002Bean.setRenderedMsgAlert(true);
			setSemmsa002Bean(semmsa002Bean);
		} finally {
			LOG.info("::: SEMMSA002Action :: doSendOfficerApprove >> END :::");
		}
		return flag;
	}
	
	public void doGenDocNo() {
		LOG.info("::: SEMMSA002Action :: doGenDocNo >> BEGIN :::");

		try {
			String chkRet = "";
			String myState = "";
			List<SiteAppSP> to = null;
			semmsa002Bean = getSemmsa002Bean();
			
			String paramSiteAppId = getFacesUtils().getRequestParameter("paramSiteAppId") == null ? "" : (String) getFacesUtils().getRequestParameter("paramSiteAppId");

			// -- fixed by.. YUT 2015/03/10
			String strReqType = semmsa002Bean.getSiteAppObjParam().getReqType() == null ? "" : (String) semmsa002Bean.getSiteAppObjParam().getReqType();
			String strCompany = semmsa002Bean.getSiteAppObjParam().getCompany() == null ? "" : (String) semmsa002Bean.getSiteAppObjParam().getCompany();
			String strRegion = semmsa002Bean.getSiteAppObjParam().getRegion() == null ? "" : (String) semmsa002Bean.getSiteAppObjParam().getRegion();
			Date dtmDocDt = semmsa002Bean.getSiteAppObjParam().getDocDt();
			
			String siteType = semmsa002Bean.getSiteAppLocalObjParam().getLocationSiteType() == null ? "" : (String)semmsa002Bean.getSiteAppLocalObjParam().getLocationSiteType();
			
			if(strReqType.equals("01") || strReqType.equals("02") || strReqType.equals("03")) {
				
				semmsa002Bean.setRenderedMsgAlert(true);
				
				if(strCompany.equals("")){
					FrontMessageUtils.addMessageWarn("กรุณาระบุ บริษัท");	// optional
				} else if(strRegion.equals("")) {
					FrontMessageUtils.addMessageWarn("กรุณาระบุ ภูมิภาค");	// optional
				} else if(dtmDocDt == null) {
					FrontMessageUtils.addMessageWarn("กรุณาระบุ วันที่");	// optional
//				}else if(StringUtils.equals("", siteType)){
//					FrontMessageUtils.addMessageWarn("กรุณาระบุ ประเภทการเช่าของสถานี");	// optional
				}else {
//					if(semmsa002Bean.isChkMacroType() || semmsa002Bean.isChkMicroType() || semmsa002Bean.isChkPicoType() ||
//					   semmsa002Bean.isChkRepeaterType() || semmsa002Bean.isChkTowerType() || semmsa002Bean.isChkWifiType() ||
//					   semmsa002Bean.isChkSmallcellType() || semmsa002Bean.isChkFBBType() ||
//					   semmsa002Bean.isChkOFCType() || semmsa002Bean.isChkFTTXType() ||semmsa002Bean.isChkOtherType()){
//						
//						// -- auto save before gendoc (loaned method)
						chkRet = this.doUpdateAllonChangeTab();
//						 
						if(chkRet.equalsIgnoreCase("Success")){
							myState = "GEN_DOC";
							semmsa002Bean.setRenderedMsgAlert(false);	// not show message
						} else {
							addMessageError("E0008", chkRet);
						}
//					} else {
//						FrontMessageUtils.addMessageWarn("กรุณาระบุ ประเภทสถานีฐาน");	// optional
//					}
				}
			} else {
				myState = "GEN_DOC";
			}
			// --

			if(myState.equals("GEN_DOC")){
				ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService");
	
				semmsa002Bean.getSiteAppObjParam().setSiteAppId(paramSiteAppId);
				semmsa002Bean.getSiteAppObjParam().setUserLogin(getUserLogIn());
				System.out.println("siteAppId : "+semmsa002Bean.getSiteAppObjParam().getSiteAppId());
				System.out.println("reqType : "+semmsa002Bean.getSiteAppObjParam().getReqType());
				System.out.println("region : "+semmsa002Bean.getSiteAppObjParam().getRegion());
				System.out.println("userLogin : "+semmsa002Bean.getSiteAppObjParam().getUserLogin());
				
				to = service.siteAppDao_querySPList(EQueryName.SP_MSA002_GEN_DOC_NO.name, semmsa002Bean.getSiteAppObjParam());
				
				if (to != null && to.size() > 0) {
					String retGenDocNo = to.get(0).getDocNo() == null ? "" : to.get(0).getDocNo().toString();
					
					semmsa002Bean.getSiteAppObjParam().setDocNo(retGenDocNo);
					semmsa002Bean.setDisabledGenDocNoBtn(true);
				}
			}
				
			setSemmsa002Bean(semmsa002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA002Action");
			
			semmsa002Bean.setRenderedMsgAlert(true);
			setSemmsa002Bean(semmsa002Bean);
		} finally {
			LOG.info("::: SEMMSA002Action :: doGenDocNo >> END :::");
		}
	}

	public void doInitialMSA002AllDetail() {
		LOG.info("::: SEMMSA002Action :: doInitialMSA002AllDetail >> BEGIN :::");

		try {
			
			semmsa002Bean = getSemmsa002Bean();
				
			String paramUrl = getFacesUtils().getRequestParameter("paramUrl") == null ? "" : (String) getFacesUtils().getRequestParameter("paramUrl");
			String paramRowId = getFacesUtils().getRequestParameter("rowId") == null ? "" : (String) getFacesUtils().getRequestParameter("rowId");
			String paramMode = getFacesUtils().getRequestParameter("paramMode") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMode");
			String paramMenuGroup = getFacesUtils().getRequestParameter("paramMenuGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuGroup");
			String paramLeaderFlag = getFacesUtils().getRequestParameter("paramLeaderFlag") == null ? "" : (String) getFacesUtils().getRequestParameter("paramLeaderFlag");
			String paramMenuType = getFacesUtils().getRequestParameter("paramMenuType") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuType");
			
			LOG.info("ooo siteAppId: " + paramRowId);
			
	        semmsa002Bean.setParamMode(paramMode);
	        //check mode
	        if("V".equals(paramMode)){
	        	semmsa002Bean.setDisabledModeViewOnly(true);
	        }else if("ELG".equals(paramMode)){
	        	semmsa002Bean.setDisabledModeEditFromLG(true);
	        }
			
	        
	        List<SiteAppSP> sAppList = new ArrayList<SiteAppSP>();
	        ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
			
	        semmsa002Bean.setSiteAppList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
			
	        semmsa002Bean.setSiteAppObjParam(new SiteAppSP()); // clear object
	        semmsa002Bean.getSiteAppObjParam().setSiteAppId(paramRowId);
        	
        	sAppList = service.siteAppDao_querySPList(EQueryName.SP_MSA002_SRCH_SITEAPP_ALL_DETAIL.name, semmsa002Bean.getSiteAppObjParam());
        	
        	if(sAppList != null && !sAppList.isEmpty()){
				SiteAppSP ret = (SiteAppSP) sAppList.get(0);
//				LOG.debug("ret.getRentServMemoWhtType() =: "+ret.getRentServMemoWhtType());
//				
//				LOG.debug("ret.getLocationProvinceId() =: "+ret.getLocationProvinceId());
//				LOG.debug("ret.getLocationAmphurId() =: "+ret.getLocationAmphurId());
//				LOG.debug("ret.getLocationPostCode() =: "+ret.getLocationPostCode());
//				
//				LOG.debug("ret.getLocProvince() =: "+ret.getLocProvince());
//				LOG.debug("ret.getLocAmphur() =: "+ret.getLocAmphur());
//				LOG.debug("ret.getLocZipCode() =: "+ret.getLocZipCode());
//				
//				LOG.debug("ret.getDocLocProvinceId() =: "+ret.getDocLocProvinceId());
//				LOG.debug("ret.getDocLocAmphurId() =: "+ret.getDocLocAmphurId());
//				LOG.debug("ret.getDocLocPostCode() =: "+ret.getDocLocPostCode());
//				LOG.debug("ret.getDocLocPostCode() =: "+ret.getDocLocPostCode());
//				
//				LOG.debug("ret.getPlaceType) =: "+ret.getPlaceType());
//				LOG.debug("ret.getReqType() : "+ret.getReqType()); 		
//				LOG.debug("ret.getDocType() : "+ret.getDocType());
//				
//				LOG.debug("ret.getLeaseHoldRights) =: "+ret.getLeaseHoldRights());
//				LOG.debug("ret).getContractWanted) =: "+ret.getContractWanted());
//				LOG.debug("ret.getLicense) =: "+ret.getLicense());
//				LOG.debug("ret.getLlRentalAgreement) =: "+ret.getLlRentalAgreement());
//				LOG.debug("ret.getDeckAreaType) =: "+ret.getDeckAreaType());
//				
//				LOG.debug("ret.getElUseOth() = "+ret.getElUseOth());
				// -- 
				String myDocNo = ret.getDocNo() == null ? "" : ret.getDocNo().toString();
				if(myDocNo.equals("")) {
					semmsa002Bean.setDisabledGenDocNoBtn(false);
				} else {
					semmsa002Bean.setDisabledGenDocNoBtn(true);
				}
				// --
				
				//set checkBox edit

				if(StringUtils.isEmpty( ret.getContractEditFlag()))ret.setContractEditFlag("N");
				if(StringUtils.isEmpty(ret.getRentEditFlag()))ret.setRentEditFlag("N");
				if(StringUtils.isEmpty(ret.getRentDepositEditFlag()))ret.setRentDepositEditFlag("N");
				if(StringUtils.isEmpty(ret.getElEditFlag()))ret.setElEditFlag("N");
				if(StringUtils.isEmpty(ret.getElDepositEditFlag()))ret.setElDepositEditFlag("N");
				if(StringUtils.isEmpty(ret.getPropertyTaxEditFlag()))ret.setPropertyTaxEditFlag("N");
				if(StringUtils.isEmpty(ret.getInsuranceEditFlag()))ret.setInsuranceEditFlag("N");
				
				// -- reqType not in (04, 05) >> disabled tab0, reqType in (04, 05) >> disabled tab1
				String myReqType = ret.getReqType() == null ? "" : ret.getReqType().toString();
				if(myReqType.equals("04") || myReqType.equals("05")) {
					semmsa002Bean.setDisabledTab_0(false);
					semmsa002Bean.setDisabledTab_1(true);
					
					// initiate object tab0
					semmsa002Bean.setSiteAppTab0ObjParam(ret);
				} else {
					semmsa002Bean.setDisabledTab_0(true);
					semmsa002Bean.setDisabledTab_1(false);
				}
				
//				semmsa002Bean.getSiteAppObjParam().getLeaseHoldRights) =: Y
//				semmsa002Bean.getSiteAppObjParam().getContractWanted) =: Y
//				semmsa002Bean.getSiteAppObjParam().getLicense) =: 01
//				semmsa002Bean.getSiteAppObjParam().getLlRentalAgreement) =: Y
				
				if(ret.getLeaseHoldRights() != null){
					semmsa002Bean.setLeaseHoldRights(ret.getLeaseHoldRights().equals("Y") ? true : false);
				}else{
					semmsa002Bean.setLeaseHoldRights(false);
				}
				
				if(ret.getContractWanted() != null){
					semmsa002Bean.setChkContractWanted(ret.getContractWanted().equals("Y") ? true : false);
				}else{
					semmsa002Bean.setChkContractWanted(false);
				}
				
				if(ret.getLlRentalAgreement() != null){
					semmsa002Bean.setLlRentalAgreement(ret.getLlRentalAgreement().equals("Y") ? true : false);
				}else{
					semmsa002Bean.setLlRentalAgreement(false);
				}
				
				// --

				// render checkBox
				this.doRenderCheckBox(ret);
				
				// -- (tab3) default VAT type >> if null or '' set '' ****
				String myRentVatType = ret.getRentVatType() == null ? "" : ret.getRentVatType().toString();
				String myRentServiceVatType = ret.getRentServiceVatType() == null ? "" : ret.getRentServiceVatType().toString();
				String myRentAreaMemoVatType = ret.getRentAreaMemoVatType() == null ? "" : ret.getRentAreaMemoVatType().toString();
				String myRentServMemoVatType = ret.getRentServMemoVatType() == null ? "" : ret.getRentServMemoVatType().toString();
				String myRentSetupMemoVatType = ret.getRentSetupMemoVatType() == null ? "" : ret.getRentSetupMemoVatType().toString();
				String myRentOtherMemoVatType = ret.getRentOtherMemoVatType() == null ? "" : ret.getRentOtherMemoVatType().toString();
				String myRentDepositCashVat = ret.getRentDepositCashVat() == null ? "" : ret.getRentDepositCashVat().toString();
				
				ret.setRentVatType(myRentVatType);
				ret.setRentServiceVatType(myRentServiceVatType);
				ret.setRentAreaMemoVatType(myRentAreaMemoVatType);
				ret.setRentServMemoWhtType(myRentServMemoVatType);
				ret.setRentSetupMemoVatType(myRentSetupMemoVatType);
				ret.setRentOtherMemoVatType(myRentOtherMemoVatType);
				ret.setRentDepositCashVat(myRentDepositCashVat);
				
				//tab3 chk RentalPayConditions
				if(ret.getRentAmt() == null) ret.setRentAmt(new BigDecimal(0));
				if(ret.getRentServiceAmt() == null) ret.setRentServiceAmt(new BigDecimal(0));
				
//				if((ret.getRentAmt() > 0) || (ret.getRentServiceAmt() > 0)){
//					semmsa002Bean.setChkRentalPayOneCond(true);
//					semmsa002Bean.setChkRentalPayManyCond(false);
//				}
				if(ret.getRentalNoExpenses() != null && "Y".equals(ret.getRentalNoExpenses())){
					semmsa002Bean.setChkRentalPayOneCond(false);
					semmsa002Bean.setChkRentalPayManyCond(false);
				}else{
					if(ret.getRentAreaAmtMemo() != null || ret.getRentServiceAmtMemo() != null ||
							ret.getRentSetupAmtMemo() != null || ret.getRentOtherAmtMemo() != null){
						semmsa002Bean.setChkRentalPayOneCond(false);
						semmsa002Bean.setChkRentalPayManyCond(true);
					}
//					added by NEW 2016/01/05 for default CB rental
					else{
//						if((ret.getRentAmt() > 0) || (ret.getRentServiceAmt() > 0)){
//							semmsa002Bean.setChkRentalPayOneCond(true);
//							semmsa002Bean.setChkRentalPayManyCond(false);
//						}
						semmsa002Bean.setChkRentalPayOneCond(true);
					}
				}
				
				// --
				
				if(ret.getPromiseRenewPeriodType()==null){
					ret.setPromiseRenewPeriodType("Y");
				}
				
				//vat%
				if(ret.getRentWhtRate()==null){
					ret.setRentWhtRate(new BigDecimal(5));
				}
				
				if(ret.getRentServiceWhtRate()==null){
					ret.setRentServiceWhtRate(new BigDecimal(3));
				}
				
				if(ret.getRentAreaMemoWhtRate()==null){
					ret.setRentAreaMemoWhtRate(new BigDecimal(5));
				}
				
				if(ret.getRentServMemoWhtRate()==null){
					ret.setRentServMemoWhtRate(new BigDecimal(3));
				}
				
				if(ret.getRentSetupMemoWhtRate()==null){
					ret.setRentSetupMemoWhtRate(new BigDecimal(5));
				}
				
				if(ret.getRentOtherMemoWhtRate()==null){
					ret.setRentOtherMemoWhtRate(new BigDecimal(3));
				}
				
				if(ret.getChangeEffectiveDT()==null){
					ret.setChangeEffectiveDT(new Date());
				}
//				System.out.println("elVatType =: "+semmsa002Bean.getSiteAppObjParam().getElVatType());
				semmsa002Bean.setSiteAppObjParam(ret);
				
				
				LOG.debug("ret.getLocationSiteType() > "+ret.getLocationSiteType());
				semmsa002Bean.setSiteAppLocalObjParam(ret);
				
				// do this after set SiteAppObject
				// initiate LegalDoc for tab5
				this.doGetLegalDoc();
				
				semmsa002Bean.setRenderedMsgAlert(false);
        	} else {
        		addMessageWarn("M0004");	// data not found
        		semmsa002Bean.setRenderedMsgAlert(true);
        		//
        		semmsa002Bean.setDisabledTab_0(true);
				semmsa002Bean.setDisabledTab_1(false);
				
				semmsa002Bean.setDisabledModeViewOnly(true);
	        	semmsa002Bean.setDisabledModeEditFromLG(true);
        	}
        	
        	// get amphur by province slim
        	if(semmsa002Bean.getSiteAppObjParam().getLocProvince() != null){
				Province province = new Province();
				province.setRowId(semmsa002Bean.getSiteAppObjParam().getLocProvince());
				semmsa002Bean.setAmphurList(getAmphurByProvince(province));
				
			}else{
				semmsa002Bean.setAmphurList(getEmptyDropDown());
			}
        	
        	// get amphur by province location
        	if(semmsa002Bean.getSiteAppObjParam().getLocationProvinceId() != null){
				Province province = new Province();
				province.setRowId(semmsa002Bean.getSiteAppObjParam().getLocationProvinceId());
				semmsa002Bean.setAmphurLocalList(getAmphurByProvince(province));
				
			}else{
				semmsa002Bean.setAmphurLocalList(getEmptyDropDown());
			}
        	
        	// get amphur by province Doc
        	if(semmsa002Bean.getSiteAppObjParam().getDocLocProvinceId() != null){
				Province province = new Province();
				province.setRowId(semmsa002Bean.getSiteAppObjParam().getDocLocProvinceId());
				semmsa002Bean.setAmphurReqDocList(getAmphurByProvince(province));
				
			}else{
				semmsa002Bean.setAmphurReqDocList(getEmptyDropDown());
			}
        	
        	// get amphur by province 'msa002tab2'
        	if(semmsa002Bean.getSiteAppObjParam().getLessorProvinceId() != null){
				Province province = new Province();
				province.setRowId(semmsa002Bean.getSiteAppObjParam().getLessorProvinceId().toString());
				semmsa002Bean.setMsa002Tab2AmphurList(getAmphurByProvince(province));
				
			}else{
				semmsa002Bean.setMsa002Tab2AmphurList(getEmptyDropDown());
			}
        	
        	// get Lessor amphur by province 'msa002tab2 Lessor'
        	if(semmsa002Bean.getSiteAppObjParam().getLessorProvinceId() != null){
				Province province = new Province();
				
				if(semmsa002Bean.getSiteAppObjParam().getLessorProvinceId() != null){
					province.setRowId(semmsa002Bean.getSiteAppObjParam().getLessorProvinceId().toString());
					semmsa002Bean.setMsa002Tab2AmphurLessorList(getAmphurByProvince(province));
				}
				
				
			}else{
				semmsa002Bean.setMsa002Tab2AmphurLessorList(getEmptyDropDown());
			}
        	
        	// get Contact amphur by province 'msa002tab2 Contact'
        	if(semmsa002Bean.getSiteAppObjParam().getLessorProvinceId() != null){
				Province province = new Province();
				if(semmsa002Bean.getSiteAppObjParam().getContactProvinceId() != null){
					province.setRowId(semmsa002Bean.getSiteAppObjParam().getContactProvinceId().toString());
					semmsa002Bean.setMsa002Tab2AmphurContactList(getAmphurByProvince(province));
				}
				
			}else{
				semmsa002Bean.setMsa002Tab2AmphurContactList(getEmptyDropDown());
			}
        	
        	//set chkInsureHave tab3
        	if(semmsa002Bean.getSiteAppObjParam().getInsFlag() != null){
        		if(semmsa002Bean.getSiteAppObjParam().getInsFlag().equals("Y")){
        			semmsa002Bean.setChkInsureHave(true);
        			semmsa002Bean.setChkInsureNotHave(false);
        			semmsa002Bean.setDisabledInsureDetail(false);
        		}else{
        			semmsa002Bean.setChkInsureHave(false);
//        			System.out.println("getInsFlag = : "+semmsa002Bean.getSiteAppObjParam().getInsFlag());
        			if(semmsa002Bean.getSiteAppObjParam().getInsFlag().equals("N"))semmsa002Bean.setChkInsureNotHave(true);
        			semmsa002Bean.setDisabledInsureDetail(true);
        		}
        	}
        	
        	//set chkNoLegal tab1
//        	if("N".equals(paramMenuGroup) || "R".equals(paramMenuGroup)){
//        		semmsa002Bean.setDisabledChkNoLegal(false);
//        	}
        	
        	//set disabledElUseOldMeter 
        	if("N".equals(paramMenuType)){
        		semmsa002Bean.setDisabledElUseOldMeter(false);
        	}
        	
        	//set disabled change Date tab1
        	if("O".equals(paramMenuType) || "E".equals(paramMenuType)){
        		semmsa002Bean.setDisabledChangeEffDate(true);
        		semmsa002Bean.setDisabledChkNoLegal(true);
        	}
        	
        	//chk Approve button
        	if("Y".equals(paramLeaderFlag)){
        		semmsa002Bean.setChkUserFlag(false);
        	}
        	
        	//added by NEW 20160401 check multiElectric
        	if("Y".equals(semmsa002Bean.getSiteAppObjParam().getElUseMultiResourse())){
				semmsa002Bean.setChkMultiElectricTypeFlag(true);
			}else{
				semmsa002Bean.setChkMultiElectricTypeFlag(false);
			}
        	
        	//chk EL USE OTHER
//        	if(StringUtils.equals("Y", semmsa002Bean.getSiteAppELObjParam().getElUseOth())){
//				semmsa002Bean.setChkElUseOth(true);
//			}else{
//				semmsa002Bean.setChkElUseOth(false);
//			}
        	if(semmsa002Bean.getSiteAppObjParam().getUpdateBy() != null){
        		semmsa002Bean.getSiteAppObjParam().setReqKey(semmsa002Bean.getSiteAppObjParam().getUpdateBy());
        	}else
        		semmsa002Bean.getSiteAppObjParam().setReqKey(getUserLogIn());
        	
        	//        	
	        setSemmsa002Bean(semmsa002Bean);
	        LOG.debug("getDocType : "+semmsa002Bean.getSiteAppObjParam().getDocType());
	        LOG.debug("semmsa002Bean.getSiteAppObjParam().getOwnerCategory() = "+semmsa002Bean.getSiteAppObjParam().getOwnerCategory());
	        this.doGetPlaceType();
			this.doGetDocTypeSelectItem();
			 LOG.debug("getDocType >> : "+semmsa002Bean.getSiteAppObjParam().getDocType());
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA002Action");
			
			semmsa002Bean.setRenderedMsgAlert(true);
			setSemmsa002Bean(semmsa002Bean);
		} finally {
			LOG.info("::: SEMMSA002Action :: doInitialMSA002AllDetail >> END :::");
		}
	}
	
	public void doInitialMSA002Tab1AllDetail() {
		LOG.info("::: SEMMSA002Action :: doInitialMSA002Tab1AllDetail >> BEGIN :::");

		try {
			
			semmsa002Bean = getSemmsa002Bean();
				
//			String paramUrl = getFacesUtils().getRequestParameter("paramUrl") == null ? "" : (String) getFacesUtils().getRequestParameter("paramUrl");
//			String paramRowId = getFacesUtils().getRequestParameter("rowId") == null ? "" : (String) getFacesUtils().getRequestParameter("rowId");
//			String paramMode = getFacesUtils().getRequestParameter("paramMode") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMode");
//			String paramMenuGroup = getFacesUtils().getRequestParameter("paramMenuGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuGroup");
//			String paramLeaderFlag = getFacesUtils().getRequestParameter("paramLeaderFlag") == null ? "" : (String) getFacesUtils().getRequestParameter("paramLeaderFlag");
//			String paramMenuType = getFacesUtils().getRequestParameter("paramMenuType") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuType");
//			
			LOG.info("ooo siteAppId: " + semmsa002Bean.getSiteAppObjParam().getSiteAppId());
			
//	        semmsa002Bean.setParamMode(paramMode);
//	        //check mode
//	        if("V".equals(paramMode)){
//	        	semmsa002Bean.setDisabledModeViewOnly(true);
//	        }else if("ELG".equals(paramMode)){
//	        	semmsa002Bean.setDisabledModeEditFromLG(true);
//	        }
			
	        
	        List<SiteAppSP> sAppList = new ArrayList<SiteAppSP>();
	        ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
			
//	        semmsa002Bean.setSiteAppList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
			
//	        semmsa002Bean.setSiteAppObjParam(new SiteAppSP()); // clear object
//	        semmsa002Bean.getSiteAppObjParam().setSiteAppId(paramRowId);
        	
        	sAppList = service.siteAppDao_querySPList(EQueryName.SP_MSA002_SRCH_SITEAPP_ALL_DETAIL.name, semmsa002Bean.getSiteAppObjParam());
        	
        	if(sAppList != null && !sAppList.isEmpty()){
				SiteAppSP ret = (SiteAppSP) sAppList.get(0);
//				System.out.println("ret.getPromiseRenewTime() =: "+ret.getPromiseRenewTime());
				// -- 
				String myDocNo = ret.getDocNo() == null ? "" : ret.getDocNo().toString();
				if(myDocNo.equals("")) {
					semmsa002Bean.setDisabledGenDocNoBtn(false);
				} else {
					semmsa002Bean.setDisabledGenDocNoBtn(true);
				}
				// --
				
				// -- reqType not in (04, 05) >> disabled tab0, reqType in (04, 05) >> disabled tab1
				String myReqType = ret.getReqType() == null ? "" : ret.getReqType().toString();
				if(myReqType.equals("04") || myReqType.equals("05")) {
					semmsa002Bean.setDisabledTab_0(false);
					semmsa002Bean.setDisabledTab_1(true);
					
					// initiate object tab0
					semmsa002Bean.setSiteAppTab0ObjParam(ret);
				} else {
					semmsa002Bean.setDisabledTab_0(true);
					semmsa002Bean.setDisabledTab_1(false);
				}
				// --

				// render checkBox
				this.doRenderCheckBox(ret);
				
				// -- (tab3) default VAT type >> if null or '' set '' ****
				String myRentVatType = ret.getRentVatType() == null ? "" : ret.getRentVatType().toString();
				String myRentServiceVatType = ret.getRentServiceVatType() == null ? "" : ret.getRentServiceVatType().toString();
				String myRentAreaMemoVatType = ret.getRentAreaMemoVatType() == null ? "" : ret.getRentAreaMemoVatType().toString();
				String myRentServMemoVatType = ret.getRentServMemoVatType() == null ? "" : ret.getRentServMemoVatType().toString();
				String myRentSetupMemoVatType = ret.getRentSetupMemoVatType() == null ? "" : ret.getRentSetupMemoVatType().toString();
				String myRentOtherMemoVatType = ret.getRentOtherMemoVatType() == null ? "" : ret.getRentOtherMemoVatType().toString();
				String myRentDepositCashVat = ret.getRentDepositCashVat() == null ? "" : ret.getRentDepositCashVat().toString();
				
				ret.setRentVatType(myRentVatType);
				ret.setRentServiceVatType(myRentServiceVatType);
				ret.setRentAreaMemoVatType(myRentAreaMemoVatType);
				ret.setRentServMemoWhtType(myRentServMemoVatType);
				ret.setRentSetupMemoVatType(myRentSetupMemoVatType);
				ret.setRentOtherMemoVatType(myRentOtherMemoVatType);
				ret.setRentDepositCashVat(myRentDepositCashVat);
				
				//tab3 chk RentalPayConditions
				if(ret.getRentAmt() == null) ret.setRentAmt(new BigDecimal(0));
				if(ret.getRentServiceAmt() == null) ret.setRentServiceAmt(new BigDecimal(0));
				
				if(ret.getChkContDocEditFlag() == null){
					ret.setChkContDocEditFlag("N");
				}
				
//				if((ret.getRentAmt() > 0) || (ret.getRentServiceAmt() > 0)){
//					semmsa002Bean.setChkRentalPayOneCond(true);
//					semmsa002Bean.setChkRentalPayManyCond(false);
//				}
				if(ret.getRentalNoExpenses() != null && "Y".equals(ret.getRentalNoExpenses())){
					semmsa002Bean.setChkRentalPayOneCond(false);
					semmsa002Bean.setChkRentalPayManyCond(false);
				}else{
					if(ret.getRentAreaAmtMemo() != null || ret.getRentServiceAmtMemo() != null ||
							ret.getRentSetupAmtMemo() != null || ret.getRentOtherAmtMemo() != null){
						semmsa002Bean.setChkRentalPayOneCond(false);
						semmsa002Bean.setChkRentalPayManyCond(true);
					}
//					added by NEW 2016/01/05 for default CB rental
					else{
//						if((ret.getRentAmt() > 0) || (ret.getRentServiceAmt() > 0)){
//							semmsa002Bean.setChkRentalPayOneCond(true);
//							semmsa002Bean.setChkRentalPayManyCond(false);
//						}
						semmsa002Bean.setChkRentalPayOneCond(true);
					}
				}
				
				// --
				
				if(ret.getPromiseRenewPeriodType()==null){
					ret.setPromiseRenewPeriodType("Y");
				}
				
				//vat%
				if(ret.getRentWhtRate()==null){
					ret.setRentWhtRate(new BigDecimal(5));
				}
				
				if(ret.getRentServiceWhtRate()==null){
					ret.setRentServiceWhtRate(new BigDecimal(3));
				}
				
				if(ret.getRentAreaMemoWhtRate()==null){
					ret.setRentAreaMemoWhtRate(new BigDecimal(5));
				}
				
				if(ret.getRentServMemoWhtRate()==null){
					ret.setRentServMemoWhtRate(new BigDecimal(3));
				}
				
				if(ret.getRentSetupMemoWhtRate()==null){
					ret.setRentSetupMemoWhtRate(new BigDecimal(5));
				}
				
				if(ret.getRentOtherMemoWhtRate()==null){
					ret.setRentOtherMemoWhtRate(new BigDecimal(3));
				}
				
				if(ret.getChangeEffectiveDT()==null){
					ret.setChangeEffectiveDT(new Date());
				}
//				System.out.println("elVatType =: "+semmsa002Bean.getSiteAppObjParam().getElVatType());
				
				LOG.debug("ret.getLocationId() : "+ret.getLocationId());
				semmsa002Bean.setSiteAppObjParam(ret);
				semmsa002Bean.setSiteAppLocalObjParam(ret);
				
				// do this after set SiteAppObject
				// initiate LegalDoc for tab5
//				this.doGetLegalDoc();
				
				semmsa002Bean.setRenderedMsgAlert(false);
        	} else {
        		addMessageWarn("M0004");	// data not found
        		semmsa002Bean.setRenderedMsgAlert(true);
        		//
        		semmsa002Bean.setDisabledTab_0(true);
				semmsa002Bean.setDisabledTab_1(false);
				
				semmsa002Bean.setDisabledModeViewOnly(true);
	        	semmsa002Bean.setDisabledModeEditFromLG(true);
        	}
	        
        	// get amphur by province
//        	if(semmsa002Bean.getSiteAppObjParam().getLocationProvinceId() != null){
//				Province province = new Province();
//				province.setRowId(semmsa002Bean.getSiteAppObjParam().getLocationProvinceId());
//				semmsa002Bean.setAmphurList(getAmphurByProvince(province));
//				
//			}else{
//				semmsa002Bean.setAmphurList(getEmptyDropDown());
//			}
//        	
//        	// get amphur by province 'msa002tab2'
//        	if(semmsa002Bean.getSiteAppObjParam().getLessorProvinceId() != null){
//				Province province = new Province();
//				province.setRowId(semmsa002Bean.getSiteAppObjParam().getLessorProvinceId().toString());
//				semmsa002Bean.setMsa002Tab2AmphurList(getAmphurByProvince(province));
//				
//			}else{
//				semmsa002Bean.setMsa002Tab2AmphurList(getEmptyDropDown());
//			}
//        	
//        	//set chkInsureHave tab3
//        	if(semmsa002Bean.getSiteAppObjParam().getInsFlag() != null){
//        		if(semmsa002Bean.getSiteAppObjParam().getInsFlag().equals("Y")){
//        			semmsa002Bean.setChkInsureHave(true);
//        			semmsa002Bean.setChkInsureNotHave(false);
//        			semmsa002Bean.setDisabledInsureDetail(false);
//        		}else{
//        			semmsa002Bean.setChkInsureHave(false);
////        			System.out.println("getInsFlag = : "+semmsa002Bean.getSiteAppObjParam().getInsFlag());
//        			if(semmsa002Bean.getSiteAppObjParam().getInsFlag().equals("N"))semmsa002Bean.setChkInsureNotHave(true);
//        			semmsa002Bean.setDisabledInsureDetail(true);
//        		}
//        	}
//        	
//        	//set chkNoLegal tab1
////        	if("N".equals(paramMenuGroup) || "R".equals(paramMenuGroup)){
////        		semmsa002Bean.setDisabledChkNoLegal(false);
////        	}
//        	
//        	//set disabledElUseOldMeter 
//        	if("N".equals(paramMenuType)){
//        		semmsa002Bean.setDisabledElUseOldMeter(false);
//        	}
//        	
//        	//set disabled change Date tab1
//        	if("O".equals(paramMenuType) || "E".equals(paramMenuType)){
//        		semmsa002Bean.setDisabledChangeEffDate(true);
//        		semmsa002Bean.setDisabledChkNoLegal(true);
//        	}
//        	
//        	//chk Approve button
//        	if("Y".equals(paramLeaderFlag)){
//        		semmsa002Bean.setChkUserFlag(false);
//        	}
//        	
//        	//added by NEW 20160401 check multiElectric
//        	if("Y".equals(semmsa002Bean.getSiteAppObjParam().getElUseMultiResourse())){
////				semmsa002Bean.getSiteAppObjParam().setElUseMultiResourse("Y");
//				semmsa002Bean.setChkMultiElectricTypeFlag(true);
//			}else{
//				semmsa002Bean.setChkMultiElectricTypeFlag(false);
//			}
//        	//    
        	if(semmsa002Bean.getSiteAppObjParam().getUpdateBy() != null){
        		semmsa002Bean.getSiteAppObjParam().setReqKey(semmsa002Bean.getSiteAppObjParam().getUpdateBy());
        	}else
        		semmsa002Bean.getSiteAppObjParam().setReqKey(getUserLogIn());
	        setSemmsa002Bean(semmsa002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA002Action");
			
			semmsa002Bean.setRenderedMsgAlert(true);
			setSemmsa002Bean(semmsa002Bean);
		} finally {
			LOG.info("::: SEMMSA002Action :: doInitialMSA002Tab1AllDetail >> END :::");
		}
	}
	
	// msa002Tab1 app_site_srch
	public void msa002Tab1_APP_SITE_SEARCH_dataTable() {

		try {
			
			semmsa002Bean = getSemmsa002Bean();
			
			String paramRowId = getFacesUtils().getRequestParameter("rowId") == null ? "" : (String) getFacesUtils().getRequestParameter("rowId");
			
	        List<SiteAppSiteSP> sAppSiteList = new ArrayList<SiteAppSiteSP>();
	        ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
	        semmsa002Bean.setSiteAppSiteList(new ArrayList<WrapperBeanObject<SiteAppSiteSP>>());
	        semmsa002Bean.setSiteAppSiteInuseList(new ArrayList<WrapperBeanObject<SiteAppSiteSP>>());
			
	        semmsa002Bean.setSiteAppSiteObjParam(new SiteAppSiteSP()); // clear object
	        semmsa002Bean.getSiteAppSiteObjParam().setSiteAppId(paramRowId);
        	String firstRow = "Y";
	        sAppSiteList = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA002_SITE_APP_SITE_SRCH.name, semmsa002Bean.getSiteAppSiteObjParam());
        	if(sAppSiteList != null && !sAppSiteList.isEmpty()){
				for(int i = 0; i < sAppSiteList.size(); i++){
					SiteAppSiteSP ret = (SiteAppSiteSP) sAppSiteList.get(i);
					
					WrapperBeanObject<SiteAppSiteSP> tmpWrapperBean = new WrapperBeanObject<SiteAppSiteSP>();
					
//					if(StringUtils.equals("Y", ret.getNewFlag())){
//						ret.setAction("New");
//					}else{
//						ret.setAction("Existing");
//					}
					LOG.debug("getMainLocalFlag : "+ret.getMainLocalFlag());
					tmpWrapperBean.setDataObj(ret);
					tmpWrapperBean.setMessage("");
					
//					semmsa002Bean.getSiteAppSiteList().add(tmpWrapperBean);
					
//					if(StringUtils.equals("Y", firstRow) && StringUtils.equals("01", ret.getCheckType())){
////						semmsa002Bean.getSiteAppObjParam().setLocationId(ret.getLocationId());
////						semmsa002Bean.getSiteAppObjParam().setLocationCode(ret.getSiteCode());
////						semmsa002Bean.getSiteAppObjParam().setLocationZone(ret.getLocationZone());
////						semmsa002Bean.getSiteAppObjParam().setLocationName(ret.getSiteNameTh());
////						semmsa002Bean.getSiteAppObjParam().setReLocateContractNo(ret.getReLocateContractNo());
////						semmsa002Bean.getSiteAppObjParam().setPhase(ret.getPhase());
//						firstRow = "N";
//					}
					if(StringUtils.equals("02", ret.getCheckType()) || StringUtils.equals("03", ret.getCheckType())
							|| StringUtils.equals("04", ret.getCheckType())){
						semmsa002Bean.getSiteAppSiteList().add(tmpWrapperBean);
					}else{
						semmsa002Bean.getSiteAppSiteInuseList().add(tmpWrapperBean);
					}
					
					if(semmsa002Bean.isChkSrchAllDetail()){
						this.doInitialMSA002Tab1AllDetail();
						semmsa002Bean.setChkSrchAllDetail(false);
					}
					
				}
				semmsa002Bean.setRenderedMsgAlert(false);
        	} else {
        		addMessageWarn("M0004");	// data not found
        		semmsa002Bean.setRenderedMsgAlert(true);
        	}
//			System.out.println("elVatType =: "+semmsa002Bean.getSiteAppObjParam().getElVatType());
        	semmsa002Bean.setChkSrchAllDetail(false);
        	 semmsa002Bean.getSiteAppObjParam().getReqKey();
			setSemmsa002Bean(semmsa002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA002Action");
			
			semmsa002Bean.setRenderedMsgAlert(true);
			setSemmsa002Bean(semmsa002Bean);
		} finally {
			
		}
	}
	
	// msa002Tab2 initiate
	public void msa002Tab2_initiate() {

		try {
			
			semmsa002Bean = getSemmsa002Bean();
//			System.out.println("promiseRenewTime = : "+semmsa002Bean.getSiteAppObjParam().getPromiseRenewTime());

			
			// get amphur by province 'msa002tab2'
        	if(semmsa002Bean.getSiteAppObjParam().getLessorProvinceId() != null){
				Province province = new Province();
				province.setRowId(semmsa002Bean.getSiteAppObjParam().getLessorProvinceId().toString());
				semmsa002Bean.setMsa002Tab2AmphurList(getAmphurByProvince(province));
				
			}else{
				semmsa002Bean.setMsa002Tab2AmphurList(getEmptyDropDown());
			}
        	//added by NEW 2016/03/22 
        	if(semmsa002Bean.getSiteAppObjParam().getPromiseRenewTime() <= 0)semmsa002Bean.getSiteAppObjParam().setPromiseRenewTime(null);
        	if(semmsa002Bean.getSiteAppObjParam().getPromiseRenewPeriod() <= 0)semmsa002Bean.getSiteAppObjParam().setPromiseRenewPeriod(null);
        	
//        	//added by NEW 2018/10/17
//        	semmsa002Bean.setOwnerCategoryList(getLovItemsByType(ELovType.T_SA_OWNER_CATEGORY.name));
        	
			setSemmsa002Bean(semmsa002Bean);
			
		} catch(Exception e) {
			
			addMessageError("EL0000", "SEMMSA002Action");
			
			semmsa002Bean.setRenderedMsgAlert(true);
			setSemmsa002Bean(semmsa002Bean);
		} finally {
			
		}
	}
	
	// msa002Tab3 initiate
	public void msa002Tab3_initiate() {

		try {
			
			semmsa002Bean = getSemmsa002Bean();

			// chack new Location 'msa002tab3'
//			if(){
//				
//			}
//        	if(semmsa002Bean.getSiteAppObjParam().getLessorProvinceId() != null){
//				Province province = new Province();
//				province.setRowId(semmsa002Bean.getSiteAppObjParam().getLessorProvinceId().toString());
//				semmsa002Bean.setMsa002Tab2AmphurList(getAmphurByProvince(province));
//				
//			}else{
//				semmsa002Bean.setMsa002Tab2AmphurList(getEmptyDropDown());
//			}
        	
			setSemmsa002Bean(semmsa002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA002Action");
			
			semmsa002Bean.setRenderedMsgAlert(true);
			setSemmsa002Bean(semmsa002Bean);
		} finally {
			
		}
	}
	
	// msa002Tab7 initiate
	public void msa002Tab7_initiate() {

		try {
			
			semmsa002Bean = getSemmsa002Bean();

			String strSiteAppId = semmsa002Bean.getSiteAppObjParam().getSiteAppId() == null ? "" : (String) semmsa002Bean.getSiteAppObjParam().getSiteAppId();
			//String paramSiteAppId = getFacesUtils().getRequestParameter("rowId") == null ? "" : (String) getFacesUtils().getRequestParameter("rowId");
			
			
			List<SiteAppMailSP> sAppMailList = new ArrayList<SiteAppMailSP>();
	        ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
			
	        semmsa002Bean.setSiteAppMailList(new ArrayList<WrapperBeanObject<SiteAppMailSP>>());
			
	        semmsa002Bean.setSiteAppTab7ObjParam(new SiteAppMailSP()); // 
	        semmsa002Bean.getSiteAppTab7ObjParam().setSiteAppId(strSiteAppId);
        	
	        sAppMailList = service.siteAppMailDao_querySPList(EQueryName.SP_MSA002_MAIL_ADDRESS_SEARCH_ALL.name, semmsa002Bean.getSiteAppTab7ObjParam());
        	if(sAppMailList != null && !sAppMailList.isEmpty()){
				for(int i = 0; i < sAppMailList.size(); i++){
					SiteAppMailSP ret = (SiteAppMailSP) sAppMailList.get(i);
					
					WrapperBeanObject<SiteAppMailSP> tmpWrapperBean = new WrapperBeanObject<SiteAppMailSP>();
					
					tmpWrapperBean.setDataObj(ret);
					tmpWrapperBean.setMessage("");

					semmsa002Bean.getSiteAppMailList().add(tmpWrapperBean);
				}
				
				semmsa002Bean.setRenderedMsgAlert(false);
        	} else {
        		addMessageWarn("M0004");	// data not found
        		semmsa002Bean.setRenderedMsgAlert(true);
        	}
			
			setSemmsa002Bean(semmsa002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA002Action");
			
			semmsa002Bean.setRenderedMsgAlert(true);
			setSemmsa002Bean(semmsa002Bean);
		} finally {
			
		}
	}
	
	// msa002Tab7 initiate
	public void msa002Tab7_doExplainIUD() {

		try {
			
			semmsa002Bean = getSemmsa002Bean();
			
			String paramSiteAppId = getFacesUtils().getRequestParameter("paramSiteAppId") == null ? "" : (String) getFacesUtils().getRequestParameter("paramSiteAppId");
			String paramMailAddrId = getFacesUtils().getRequestParameter("paramMailAddrId") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMailAddrId");
			String paramMode = getFacesUtils().getRequestParameter("paramMode") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMode");
			
			SiteAppMailSP out = new SiteAppMailSP();
			if(paramMode.equals("U")) {
				// get MailAddr Detail >>
		        for (WrapperBeanObject<SiteAppMailSP> temp : semmsa002Bean.getSiteAppMailList()) {
		        	
		        	out = (SiteAppMailSP) temp.getDataObj();
		        	String tempMailAddrId = out.getMailAddrId() == null ? "" : out.getMailAddrId().toString() ;
		        	
					if (!tempMailAddrId.equals("") && tempMailAddrId.equals(paramMailAddrId)) {
						
						semmsa002Bean.setSiteAppTab7ObjParam(out);
						
					} else {
						// do nothing
					}
				}
		        // get MailAddr Detail <<

				semmsa002Bean.getSiteAppTab7ObjParam().setStrParam("U");
				semmsa002Bean.getSiteAppTab7ObjParam().setMailAddrId(paramMailAddrId);
				
			} else if(paramMode.equals("D")) {
				semmsa002Bean.getSiteAppTab7ObjParam().setStrParam("D");
				semmsa002Bean.getSiteAppTab7ObjParam().setMailAddrId(paramMailAddrId);
				
			} else if(paramMode.equals("I")) { 
				out = new SiteAppMailSP();
				out.setSiteAppId(paramSiteAppId);
				semmsa002Bean.setSiteAppTab7ObjParam(out);
				semmsa002Bean.getSiteAppTab7ObjParam().setStrParam("I");
				
			}
			
			// get amphur by province 'msa002tab7'
        	if(semmsa002Bean.getSiteAppTab7ObjParam().getMailProvinceId() != null){
				Province province = new Province();
				province.setRowId(semmsa002Bean.getSiteAppTab7ObjParam().getMailProvinceId());
				semmsa002Bean.setMsa002Tab7AmphurList(getAmphurByProvince(province));
				
			}else{
				semmsa002Bean.setMsa002Tab7AmphurList(getEmptyDropDown());
			}
        	
			setSemmsa002Bean(semmsa002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA002Action");
			
			semmsa002Bean.setRenderedMsgAlert(true);
			setSemmsa002Bean(semmsa002Bean);
		} finally {
			
		}
	}
	
	// msa002Tab7 save addr
	public void msa002Tab7_doSaveAddr() {

		try {
			
			semmsa002Bean = getSemmsa002Bean();
			
			String paramMode = semmsa002Bean.getSiteAppTab7ObjParam().getStrParam() == null ? "" : semmsa002Bean.getSiteAppTab7ObjParam().getStrParam().toString();
			String strSiteAppId = semmsa002Bean.getSiteAppTab7ObjParam().getSiteAppId() == null ? "" : semmsa002Bean.getSiteAppTab7ObjParam().getSiteAppId().toString();
			
			String strMailAddrId = semmsa002Bean.getSiteAppTab7ObjParam().getMailAddrId() == null ? "" : semmsa002Bean.getSiteAppTab7ObjParam().getMailAddrId().toString();
			String strMailName = semmsa002Bean.getSiteAppTab7ObjParam().getMailName() == null ? "" : semmsa002Bean.getSiteAppTab7ObjParam().getMailName().toString();
			String strMailHouseNo = semmsa002Bean.getSiteAppTab7ObjParam().getMailHouseNo() == null ? "" : semmsa002Bean.getSiteAppTab7ObjParam().getMailHouseNo().toString();
			String strMailBuilding = semmsa002Bean.getSiteAppTab7ObjParam().getMailBuilding() == null ? "" : semmsa002Bean.getSiteAppTab7ObjParam().getMailBuilding().toString();
			String strMailFloor = semmsa002Bean.getSiteAppTab7ObjParam().getMailFloor() == null ? "" : semmsa002Bean.getSiteAppTab7ObjParam().getMailFloor().toString();
			String strMailRoomNo = semmsa002Bean.getSiteAppTab7ObjParam().getMailRoomNo() == null ? "" : semmsa002Bean.getSiteAppTab7ObjParam().getMailRoomNo().toString();
			
			String strMailStreet = semmsa002Bean.getSiteAppTab7ObjParam().getMailStreet() == null ? "" : semmsa002Bean.getSiteAppTab7ObjParam().getMailStreet().toString();
			String strMailTambon = semmsa002Bean.getSiteAppTab7ObjParam().getMailTambon() == null ? "" : semmsa002Bean.getSiteAppTab7ObjParam().getMailTambon().toString();
			String strMailAmphurId = semmsa002Bean.getSiteAppTab7ObjParam().getMailAmphurId() == null ? "" : semmsa002Bean.getSiteAppTab7ObjParam().getMailAmphurId().toString();
			String strMailProvinceId = semmsa002Bean.getSiteAppTab7ObjParam().getMailProvinceId() == null ? "" : semmsa002Bean.getSiteAppTab7ObjParam().getMailProvinceId().toString();
			String strPhoneNo = semmsa002Bean.getSiteAppTab7ObjParam().getPhoneNo() == null ? "" : semmsa002Bean.getSiteAppTab7ObjParam().getPhoneNo().toString();
			String strMailPostCode = semmsa002Bean.getSiteAppTab7ObjParam().getMailPostCode() == null ? "" : semmsa002Bean.getSiteAppTab7ObjParam().getMailPostCode().toString();

			ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService");

			semmsa002Bean.setSiteAppTab7ObjParam(new SiteAppMailSP());
			semmsa002Bean.getSiteAppTab7ObjParam().setSiteAppId(strSiteAppId);
			semmsa002Bean.getSiteAppTab7ObjParam().setStrParam(paramMode);
			semmsa002Bean.getSiteAppTab7ObjParam().setMailAddrId(strMailAddrId);
			semmsa002Bean.getSiteAppTab7ObjParam().setMailName(strMailName);
			semmsa002Bean.getSiteAppTab7ObjParam().setMailHouseNo(strMailHouseNo);
			semmsa002Bean.getSiteAppTab7ObjParam().setMailBuilding(strMailBuilding);
			semmsa002Bean.getSiteAppTab7ObjParam().setMailFloor(strMailFloor);
			semmsa002Bean.getSiteAppTab7ObjParam().setMailRoomNo(strMailRoomNo);
			semmsa002Bean.getSiteAppTab7ObjParam().setMailStreet(strMailStreet);
			semmsa002Bean.getSiteAppTab7ObjParam().setMailTambon(strMailTambon);
			semmsa002Bean.getSiteAppTab7ObjParam().setMailAmphurId(strMailAmphurId);
			semmsa002Bean.getSiteAppTab7ObjParam().setMailProvinceId(strMailProvinceId);
			semmsa002Bean.getSiteAppTab7ObjParam().setMailPostCode(strMailPostCode);
			semmsa002Bean.getSiteAppTab7ObjParam().setPhoneNo(strPhoneNo);
			semmsa002Bean.getSiteAppTab7ObjParam().setUserLogin(getUserLogIn());
			
			
			List<SiteAppSP> ret = service.siteAppMailDao_querySPList(EQueryName.SP_MSA002_MAIL_ADDRESS_IUD.name, semmsa002Bean.getSiteAppTab7ObjParam());
			
			if (ret != null && !ret.isEmpty()) {
				if (ret.get(0).getRetResult().equals("Success")) {
					
					// reload
					semmsa002Bean.getSiteAppObjParam().setSiteAppId(strSiteAppId);
					this.msa002Tab7_initiate();
					// reload
					
					addMessageInfo("M0001");	// data save success
					semmsa002Bean.setRenderedMsgAlert(true);
				} else {
					addMessageError("E0001");	// data save fail
	        		semmsa002Bean.setRenderedMsgAlert(true);
				}
			}
			
			
			setSemmsa002Bean(semmsa002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA002Action");
			
			semmsa002Bean.setRenderedMsgAlert(true);
			setSemmsa002Bean(semmsa002Bean);
		} finally {
			
		}
	}
	
	// msa002Tab7 save main Location
	public void msa002Tab7_doSaveMainLoc() {
		LOG.debug(" ##### Start Semmsa002Action msa002Tab7_doSaveMainLoc #####");
		semmsa002Bean = getSemmsa002Bean();
		String paramMailAddrId = getFacesUtils().getRequestParameter("paramMailAddrId") == null ? "" : (String)getFacesUtils().getRequestParameter("paramMailAddrId");
		try {
			ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService");
			if(semmsa002Bean.getSiteAppMailList() != null){
				for(WrapperBeanObject<SiteAppMailSP> wrapMailSP : semmsa002Bean.getSiteAppMailList()){
					SiteAppMailSP mailSP = (SiteAppMailSP)wrapMailSP.getDataObj();
					if(StringUtils.equals(paramMailAddrId, mailSP.getMailAddrId())){
						String paramMode = mailSP.getStrParam() == null ? "" : mailSP.getStrParam().toString();
						String strSiteAppId = mailSP.getSiteAppId() == null ? "" : mailSP.getSiteAppId().toString();
						
						String strMailAddrId = mailSP.getMailAddrId() == null ? "" : mailSP.getMailAddrId().toString();
						String strMailName = mailSP.getMailName() == null ? "" : mailSP.getMailName().toString();
						String strMailHouseNo = mailSP.getMailHouseNo() == null ? "" : mailSP.getMailHouseNo().toString();
						String strMailBuilding = mailSP.getMailBuilding() == null ? "" : mailSP.getMailBuilding().toString();
						String strMailFloor = mailSP.getMailFloor() == null ? "" : mailSP.getMailFloor().toString();
						String strMailRoomNo = mailSP.getMailRoomNo() == null ? "" : mailSP.getMailRoomNo().toString();
						
						String strMailStreet = mailSP.getMailStreet() == null ? "" : mailSP.getMailStreet().toString();
						String strMailTambon = mailSP.getMailTambon() == null ? "" : mailSP.getMailTambon().toString();
						String strMailAmphurId = mailSP.getMailAmphurId() == null ? "" : mailSP.getMailAmphurId().toString();
						String strMailProvinceId = mailSP.getMailProvinceId() == null ? "" : mailSP.getMailProvinceId().toString();
						String strPhoneNo = mailSP.getPhoneNo() == null ? "" : mailSP.getPhoneNo().toString();
						String strMailPostCode = mailSP.getMailPostCode() == null ? "" : mailSP.getMailPostCode().toString();

						SiteAppMailSP mailObjParam = new SiteAppMailSP();

//						semmsa002Bean.setSiteAppTab7ObjParam(new SiteAppMailSP());
						mailObjParam.setSiteAppId(strSiteAppId);
						mailObjParam.setStrParam("U");
						mailObjParam.setMailAddrId(strMailAddrId);
						mailObjParam.setMailName(strMailName);
						mailObjParam.setMailHouseNo(strMailHouseNo);
						mailObjParam.setMailBuilding(strMailBuilding);
						mailObjParam.setMailFloor(strMailFloor);
						mailObjParam.setMailRoomNo(strMailRoomNo);
						mailObjParam.setMailStreet(strMailStreet);
						mailObjParam.setMailTambon(strMailTambon);
						mailObjParam.setMailAmphurId(strMailAmphurId);
						mailObjParam.setMailProvinceId(strMailProvinceId);
						mailObjParam.setMailPostCode(strMailPostCode);
						mailObjParam.setPhoneNo(strPhoneNo);
						mailObjParam.setUserLogin(getUserLogIn());
						mailObjParam.setMainFlag("Y");
						
						
						List<SiteAppSP> ret = service.siteAppMailDao_querySPList(EQueryName.SP_MSA002_MAIL_ADDRESS_IUD.name, mailObjParam);
						
						if (ret != null && !ret.isEmpty()) {
							if (ret.get(0).getRetResult().equals("Success")) {
								
								// reload
								semmsa002Bean.getSiteAppObjParam().setSiteAppId(strSiteAppId);
								this.msa002Tab7_initiate();
								// reload
								
								addMessageInfo("M0001");	// data save success
								semmsa002Bean.setRenderedMsgAlert(true);
							} else {
								addMessageError("E0001");	// data save fail
				        		semmsa002Bean.setRenderedMsgAlert(true);
							}
						}
					}
				}
			}else{
				addMessageError("E0001");	// data save fail
        		semmsa002Bean.setRenderedMsgAlert(true);
			}
			
			
			
			
			
			
			
		} catch(Exception e) {
			
			e.printStackTrace();
			LOG.error(" ##### Error Semmsa002Action msa002Tab7_doSaveMainLoc #####");
			LOG.error(e);
			
			addMessageError("EL0000", "SEMMSA002Action");
			
			semmsa002Bean.setRenderedMsgAlert(true);
			setSemmsa002Bean(semmsa002Bean);
		} finally {
			LOG.debug(" ##### END Semmsa002Action msa002Tab7_doSaveMainLoc #####");
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	
	// msa002Tab1 doEditSiteInitiate
	public void msa002Tab1_doEditSiteInitiate() {

		try {
			
			semmsa002Bean = getSemmsa002Bean();
			
			//String paramSiteAppId = getFacesUtils().getRequestParameter("paramSiteAppId") == null ? "" : (String) getFacesUtils().getRequestParameter("paramSiteAppId");
			String paramSiteAppSiteId = getFacesUtils().getRequestParameter("paramSiteAppSiteId") == null ? "" : (String) getFacesUtils().getRequestParameter("paramSiteAppSiteId");
			String paramCheckType = getFacesUtils().getRequestParameter("paramCheckType") == null ? "" : (String) getFacesUtils().getRequestParameter("paramCheckType");
			
			semmsa002Bean.setChkEditSiteModeINS(false);
			semmsa002Bean.setChkEditSiteModeRMV(false);
			semmsa002Bean.setDisabledSiteModeBtn(false);
			
			int countTmp = 0;
			
			
			// get SiteAppSite Detail >>
			SiteAppSiteSP out = new SiteAppSiteSP();
	        for (WrapperBeanObject<SiteAppSiteSP> temp : semmsa002Bean.getSiteAppSiteList()) {
	        	
	        	out = (SiteAppSiteSP) temp.getDataObj();
	        	String tempSiteAppSiteId = out.getSiteAppSiteId() == null ? "" : out.getSiteAppSiteId().toString();

				if (!tempSiteAppSiteId.equals("") && tempSiteAppSiteId.equals(paramSiteAppSiteId)) {
					
					semmsa002Bean.setSiteAppSiteObjParam(out);
					
				} else {
					// do nothing
				}
				
				// --
				String checkTypeTmp = out.getCheckType() == null ? "" : out.getCheckType().toString();
				if(checkTypeTmp.equals("01")) {
					countTmp++;
				}
				// --
			}
	        // get SiteAppSite Detail <<
				
				
			
			if(paramCheckType.equals("01")) {
				semmsa002Bean.setDisabledModeINS(true);
				semmsa002Bean.setDisabledModeRMV(false);
				
				if(countTmp == 1) { // can not remove when approve site have 1 record
					semmsa002Bean.setDisabledSiteModeBtn(true);
				}
			} else { // otherwise
				if(paramCheckType.equals("02") || paramCheckType.equals("04")) { // '02', '04'
					semmsa002Bean.setDisabledSiteModeBtn(true);
				}
				
				semmsa002Bean.setDisabledModeINS(false);
				semmsa002Bean.setDisabledModeRMV(true);
			} 

			setSemmsa002Bean(semmsa002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA002Action");
			
			semmsa002Bean.setRenderedMsgAlert(true);
			setSemmsa002Bean(semmsa002Bean);
		} finally {
			
		}
	}
	
	// msa002tab1 swap mode (optional idea)
	public void msa002tab1_siteModeChk() {

		try {
			
			semmsa002Bean = getSemmsa002Bean();
			
			String paramSiteMode = getFacesUtils().getRequestParameter("paramSiteMode") == null ? "" : (String) getFacesUtils().getRequestParameter("paramSiteMode");

			semmsa002Bean.setParamSiteMode(paramSiteMode);

			if(paramSiteMode.equals("I")) { // 'INS'
				semmsa002Bean.setChkEditSiteModeRMV(false);
			} else { // 'D' (RMV)
				semmsa002Bean.setChkEditSiteModeINS(false);
			}
			
			//boolean chkModeINS = semmsa002Bean.isChkEditSiteModeINS();
			//boolean chkModeRMV = semmsa002Bean.isChkEditSiteModeRMV();
			
			setSemmsa002Bean(semmsa002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA002Action");
			
			semmsa002Bean.setRenderedMsgAlert(true);
			setSemmsa002Bean(semmsa002Bean);
		} finally {
			
		}
	}
	
	// msa002Tab1 doSaveEditSite
	public void msa002Tab1_doSaveEditSite() {

		try {
			
			semmsa002Bean = getSemmsa002Bean();
			
			boolean chkModeINS = semmsa002Bean.isChkEditSiteModeINS();
			boolean chkModeRMV = semmsa002Bean.isChkEditSiteModeRMV();

			String paramSiteMode = getFacesUtils().getRequestParameter("paramSiteMode") == null ? "" : (String) getFacesUtils().getRequestParameter("paramSiteMode");
//			String strLocationId = semmsa002Bean.getSiteAppObjParam().getLocationId() == null ? "" : (String) semmsa002Bean.getSiteAppObjParam().getLocationId();
			
			if(chkModeINS == false && chkModeRMV == false) {
				addMessageError("W0001", ""); 
				semmsa002Bean.setRenderedMsgAlert(true);
			} else {
				
//				semmsa002Bean.getSiteAppSiteObjParam().setLocationId(strLocationId);
				semmsa002Bean.getSiteAppSiteObjParam().setCheckType(paramSiteMode);
				semmsa002Bean.getSiteAppSiteObjParam().setUpdateBy(getUserLogIn());
				LOG.info("ooo strLocationId: " + semmsa002Bean.getSiteAppSiteObjParam().getLocationId());
				LOG.info("ooo paramSiteMode: " + paramSiteMode);
				LOG.info("ooo getSiteAppSiteId: " + semmsa002Bean.getSiteAppSiteObjParam().getSiteAppSiteId());
				
				ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService");
				
				List<SiteAppSP> ret = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA002_SITE_APP_SITE_UPD.name, semmsa002Bean.getSiteAppSiteObjParam());
				
				if (ret != null && !ret.isEmpty()) {
					if (ret.get(0).getRetResult().equals("Success")) {
						semmsa002Bean.setChkSrchAllDetail(true);
						this.msa002Tab1_APP_SITE_SEARCH_dataTable();
						
						addMessageInfo("M0001");	// data save success
						semmsa002Bean.setRenderedMsgAlert(true);
					} else {
						addMessageError("E0001");	// data save fail
		        		semmsa002Bean.setRenderedMsgAlert(true);
					}
				}
			}
			
			setSemmsa002Bean(semmsa002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA002Action");
			
			semmsa002Bean.setRenderedMsgAlert(true);
			setSemmsa002Bean(semmsa002Bean);
		} finally {
			
		}
	}
	
	// msa002Tab1 doAddLocationSite
	public void msa002Tab1_doAddLocationSite() {

		try {
			
			semmsa002Bean = getSemmsa002Bean();
			semmsa002Bean.setSiteLocationObjParam(new SiteAppSiteSP());
			String paramSiteMode = getFacesUtils().getRequestParameter("paramSiteMode") == null ? "" : (String) getFacesUtils().getRequestParameter("paramSiteMode");
			
			String paramSiteAppId = getFacesUtils().getRequestParameter("paramSiteAppId") == null ? "" : (String) getFacesUtils().getRequestParameter("paramSiteAppId");
			String paramSiteAppSiteId = getFacesUtils().getRequestParameter("paramSiteAppSiteId") == null ? "" : (String) getFacesUtils().getRequestParameter("paramSiteAppSiteId");
			String paramLocationId = getFacesUtils().getRequestParameter("paramLocationId") == null ? "" : (String) getFacesUtils().getRequestParameter("paramLocationId");
			String paramSiteId = getFacesUtils().getRequestParameter("paramSiteId") == null ? "" : (String) getFacesUtils().getRequestParameter("paramSiteId");
			String paramSiteCode = getFacesUtils().getRequestParameter("paramSiteCode") == null ? "" : (String) getFacesUtils().getRequestParameter("paramSiteCode");
			String paramLocationCode = getFacesUtils().getRequestParameter("paramLocationCode") == null ? "" : (String) getFacesUtils().getRequestParameter("paramLocationCode");
			String paramLocationName = getFacesUtils().getRequestParameter("paramLocationName") == null ? "" : (String) getFacesUtils().getRequestParameter("paramLocationName");
			String paramTowerType = getFacesUtils().getRequestParameter("paramTowerType") == null ? "" : (String) getFacesUtils().getRequestParameter("paramTowerType");
			String paramTowerLocation = getFacesUtils().getRequestParameter("paramTowerLocation") == null ? "" : (String) getFacesUtils().getRequestParameter("paramTowerLocation");
			Float paramTowerHeight = getFacesUtils().getRequestParameter("paramTowerHeight") == null ? 0f : Float.parseFloat((String) getFacesUtils().getRequestParameter("paramTowerHeight"));
			String paramServiceId = getFacesUtils().getRequestParameter("paramServiceId") == null ? "" : (String)getFacesUtils().getRequestParameter("paramServiceId");
			String paramSiteGroup = getFacesUtils().getRequestParameter("paramSiteGroup") == null ? "" : (String)getFacesUtils().getRequestParameter("paramSiteGroup");
			String paramStationType = getFacesUtils().getRequestParameter("paramStationType") == null ? "" : (String)getFacesUtils().getRequestParameter("paramStationType");
			String paramSystem = getFacesUtils().getRequestParameter("paramSystem") == null ? "" : (String)getFacesUtils().getRequestParameter("paramSystem");
			
			
			LOG.info("ooo paramSiteAppId: " + paramSiteAppId);
			LOG.info("ooo paramSiteMode: " + paramSiteMode);
			LOG.info("ooo paramSiteAppSiteId: " + paramSiteAppSiteId);
			
			semmsa002Bean.getSiteLocationObjParam().setCheckType(paramSiteMode);
			semmsa002Bean.getSiteLocationObjParam().setUpdateBy(getUserLogIn());
			
			semmsa002Bean.getSiteLocationObjParam().setSiteAppId(paramSiteAppId);
			semmsa002Bean.getSiteLocationObjParam().setSiteAppSiteId(paramSiteAppSiteId);
			semmsa002Bean.getSiteLocationObjParam().setLocationId(paramLocationId);
			semmsa002Bean.getSiteLocationObjParam().setSiteId(paramSiteId);
			semmsa002Bean.getSiteLocationObjParam().setSiteCode(paramSiteCode);
			semmsa002Bean.getSiteLocationObjParam().setLocationCode(paramLocationCode);
			semmsa002Bean.getSiteLocationObjParam().setLocationName(paramLocationName);
			semmsa002Bean.getSiteLocationObjParam().setTowerType(paramTowerType);
			semmsa002Bean.getSiteLocationObjParam().setTowerLocation(paramTowerLocation);
			semmsa002Bean.getSiteLocationObjParam().setTowerHeight(new BigDecimal(paramTowerHeight));
			semmsa002Bean.getSiteLocationObjParam().setServiceId(paramServiceId);
			semmsa002Bean.getSiteLocationObjParam().setSiteGroup(paramSiteGroup);
			semmsa002Bean.getSiteLocationObjParam().setStationType(paramStationType);
			semmsa002Bean.getSiteLocationObjParam().setSystem(paramSystem);
				
				ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService");
				
				List<SiteAppSP> ret = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA002_SITE_APP_SITE_UPD.name, semmsa002Bean.getSiteLocationObjParam());
				
				if (ret != null && !ret.isEmpty()) {
					if (ret.get(0).getRetResult().equals("Success")) {
						semmsa002Bean.setChkSrchAllDetail(true);
						this.msa002Tab1_APP_SITE_SEARCH_dataTable();
						
						//TODO init TAB1
						//added by NEW 12/06/2018 get Service Existing 
						this.doInitSiteAcqServ("E");
						//added by NEW 12/06/2018 get Service Current 
						this.doInitSiteAcqServ("C");
						//added by NEW 12/06/2018 get Service All 
						this.doInitSiteAcqServ("A");
						//
						
						this.doGetSiteAppServSelItem();
						
						//addMessageInfo("M0001");	// data save success
						//semmsa002Bean.setRenderedMsgAlert(true);
					} else {
						addMessageError("E0001");	// data save fail
		        		semmsa002Bean.setRenderedMsgAlert(true);
					}
				}
			
			setSemmsa002Bean(semmsa002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA002Action");
			
			semmsa002Bean.setRenderedMsgAlert(true);
			setSemmsa002Bean(semmsa002Bean);
		} finally {
			
		}
	}
	
	public void doUpdateTsTerminate() {
		LOG.info("::: SEMMSA002Action :: doUpdateTsTerminate >> BEGIN :::");

		try {
			semmsa002Bean = getSemmsa002Bean();
			
			String strSiteAppId = semmsa002Bean.getSiteAppTab0ObjParam().getSiteAppId() == null ? "" : semmsa002Bean.getSiteAppTab0ObjParam().getSiteAppId().toString();
			String strDocNo = semmsa002Bean.getSiteAppTab0ObjParam().getDocNo() == null ? "" : semmsa002Bean.getSiteAppTab0ObjParam().getDocNo().toString();
			Date dtmDocDt = semmsa002Bean.getSiteAppTab0ObjParam().getDocDt() == null ? null : semmsa002Bean.getSiteAppTab0ObjParam().getDocDt();
//			Date dtmTerminateCancelContractDt = semmsa002Bean.getSiteAppTab0ObjParam().getTerminateCancelContractDt() == null ? null : semmsa002Bean.getSiteAppTab0ObjParam().getTerminateCancelContractDt();
//			String strTerminateReason = semmsa002Bean.getSiteAppTab0ObjParam().getTerminateReason() == null ? "" : semmsa002Bean.getSiteAppTab0ObjParam().getTerminateReason().toString();
//			Date dtmTerminateRemoveDt = semmsa002Bean.getSiteAppTab0ObjParam().getTerminateRemoveDt() == null ? null : semmsa002Bean.getSiteAppTab0ObjParam().getTerminateRemoveDt();
//			Date dtmTerminateRemoveEndDt = semmsa002Bean.getSiteAppTab0ObjParam().getTerminateRemoveEndDt() == null ? null : semmsa002Bean.getSiteAppTab0ObjParam().getTerminateRemoveEndDt();
//			String strTerminateNote = semmsa002Bean.getSiteAppTab0ObjParam().getTerminateNote() == null ? "" : semmsa002Bean.getSiteAppTab0ObjParam().getTerminateNote().toString();
//			
//			String strTitle = semmsa002Bean.getSiteAppTab0ObjParam().getTitle() == null ? "" : semmsa002Bean.getSiteAppTab0ObjParam().getTitle().toString();
//			String strCompany = semmsa002Bean.getSiteAppTab0ObjParam().getCompany() == null ? "" : semmsa002Bean.getSiteAppTab0ObjParam().getCompany().toString();
//			String strCoContractNo = semmsa002Bean.getSiteAppTab0ObjParam().getCoContractNo() == null ? "" : semmsa002Bean.getSiteAppTab0ObjParam().getCoContractNo().toString();
//			String strDocStatusText = semmsa002Bean.getSiteAppTab0ObjParam().getDocStatusText() == null ? "" : semmsa002Bean.getSiteAppTab0ObjParam().getDocStatusText().toString();
//			
//			//20161018 add by oum
//			String reqOfficer = semmsa002Bean.getSiteAppTab0ObjParam().getReqOfficer() == null ? "" : semmsa002Bean.getSiteAppTab0ObjParam().getReqOfficer().toString();
//			String reqOfficerManual = semmsa002Bean.getSiteAppTab0ObjParam().getReqOfficerManual() == null ? "" : semmsa002Bean.getSiteAppTab0ObjParam().getReqOfficerManual().toString();

			LOG.info("ooo siteAppId: " + strSiteAppId);
			
			if (strDocNo.equals("")) {
				addMessageError("W0001", msg("export.col.docNo")); //docNo
				semmsa002Bean.setRenderedMsgAlert(true);
			} else if (dtmDocDt == null) {
				addMessageError("W0001", msg("export.col.date")); //docDt
				semmsa002Bean.setRenderedMsgAlert(true);
			} else {
				ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService");
//	
//				semmsa002Bean.setSiteAppTab0ObjParam(new SiteAppSP());
//				semmsa002Bean.getSiteAppTab0ObjParam().setSiteAppId(strSiteAppId);
//				semmsa002Bean.getSiteAppTab0ObjParam().setDocNo(strDocNo);
//				semmsa002Bean.getSiteAppTab0ObjParam().setDocDt(dtmDocDt);
//				semmsa002Bean.getSiteAppTab0ObjParam().setTerminateCancelContractDt(dtmTerminateCancelContractDt);
//				semmsa002Bean.getSiteAppTab0ObjParam().setTerminateReason(strTerminateReason);
//				semmsa002Bean.getSiteAppTab0ObjParam().setTerminateRemoveDt(dtmTerminateRemoveDt);
//				semmsa002Bean.getSiteAppTab0ObjParam().setTerminateRemoveEndDt(dtmTerminateRemoveEndDt);
//				semmsa002Bean.getSiteAppTab0ObjParam().setTerminateNote(strTerminateNote);
//				
//				semmsa002Bean.getSiteAppTab0ObjParam().setTitle(strTitle);
//				semmsa002Bean.getSiteAppTab0ObjParam().setCompany(strCompany);
//				semmsa002Bean.getSiteAppTab0ObjParam().setCoContractNo(strCoContractNo);
//				semmsa002Bean.getSiteAppTab0ObjParam().setDocStatusText(strDocStatusText);
//				
				semmsa002Bean.getSiteAppTab0ObjParam().setUserLogin(getUserLogIn());
//				
//				//20161018 add by oum
//				semmsa002Bean.getSiteAppTab0ObjParam().setReqOfficer(reqOfficer);
//				semmsa002Bean.getSiteAppTab0ObjParam().setReqOfficerManual(reqOfficerManual);
				
				this.doSetCheckBoxEntity();
				
				List<SiteAppSP> to = service.siteAppDao_querySPList(EQueryName.SP_MSA002_UPD_TS_TERMINATE.name, semmsa002Bean.getSiteAppTab0ObjParam());
				
				if (to != null && !to.isEmpty()) {
					if (to.get(0).getRetResult().equals("Success")) {
						addMessageInfo("M0001");	// data save success
						semmsa002Bean.setRenderedMsgAlert(true);
					} else {
						LOG.debug("call-->"+EQueryName.SP_MSA002_UPD_TS_TERMINATE.name+" => result :" +to.get(0).getRetResult());
						addMessageError("E0001");	// data save fail
		        		semmsa002Bean.setRenderedMsgAlert(true);
					}
				}
			}
			
			setSemmsa002Bean(semmsa002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA002Action");
			
			semmsa002Bean.setRenderedMsgAlert(true);
			setSemmsa002Bean(semmsa002Bean);
		} finally {
			LOG.info("::: SEMMSA002Action :: doUpdateTsTerminate >> END :::");
		}
	}
	
	public void doGetLegalDoc() {
		LOG.info("::: SEMMSA002Action :: doGetLegalDoc >> BEGIN :::");

		try {
			
			semmsa002Bean = getSemmsa002Bean();

			String paramSiteAppId = semmsa002Bean.getSiteAppObjParam().getSiteAppId();
			String paramPlaceType = semmsa002Bean.getSiteAppObjParam().getPlaceType(); //String paramPlaceType = semmsa002Bean.getParamPlaceType(); old fixed to new 
			String paramPartiesType = semmsa002Bean.getSiteAppObjParam().getPartiesType(); //String paramPartiesType = semmsa002Bean.getParamPartiesType(); old fixed to new 
	        
	        SEMMSA002Bean semmsa002BeanCriteria = new SEMMSA002Bean();
	        semmsa002BeanCriteria.setParamSiteAppId(paramSiteAppId);
	        semmsa002BeanCriteria.setParamPlaceType(paramPlaceType);
	        semmsa002BeanCriteria.setParamPartiesType(paramPartiesType);
			
	        semmsa002Bean.setLegalDocList(new ArrayList<WrapperBeanObject<LegalDocComponentBean>>());
	        
	        if((paramSiteAppId != null && !paramSiteAppId.equalsIgnoreCase("")) 
	        	&& (paramPlaceType != null && !paramPlaceType.equalsIgnoreCase("")) 
	        	&& (paramPartiesType != null && !paramPartiesType.equalsIgnoreCase(""))){

				ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService");
	
				List<MSA001LovSP> retObjList = service.siteAppDao_querySPList(EQueryName.SP_MSA001_GET_LEGAL_DOC.name, semmsa002BeanCriteria);
				int count = 1;
				int retObjListSize = retObjList.size();
				if(retObjList != null && !retObjList.isEmpty()){
					for(int i = 0; i < retObjList.size(); i++){
						MSA001LovSP ret = (MSA001LovSP) retObjList.get(i);
						
						String myCode = ret.getLovCode();
						String myDesc = ret.getLovName();
						String myChk = ret.getDocFlag() == null ? "" : ret.getDocFlag().toString();
						String myRemark = ret.getDocRemark();
						String myDispRemark = ret.getShowRemark();
						Date docEffDT = ret.getDocEffectiveDt();
						String licenseDoc = ret.getLicenseDocument() == null ? "" : (String)ret.getLicenseDocument();
						
						// gen legal doc component list >>						
						//--------------------------------------------------------------
						LegalDocComponentBean myComponent = new LegalDocComponentBean();
						myComponent.setItemNumber(Integer.toString(count) + ".");
						myComponent.setItemCode(myCode);
						myComponent.setItemDesc(myDesc);
						if(myChk.equals("Y")) { 
							myComponent.setChkHaveFlag(true); 
							myComponent.setChkNotHaveFlag(false);
							myComponent.setItemIsChk("Y");
						} else if(myChk.equals("N")) {
							myComponent.setChkHaveFlag(false); 
							myComponent.setChkNotHaveFlag(true); 
							myComponent.setItemIsChk("N");
						} else { 
							myComponent.setChkHaveFlag(false); 
							myComponent.setChkNotHaveFlag(false);
							myComponent.setItemIsChk("");
						}
						myComponent.setItemRemark(myRemark);
						myComponent.setItemDispRemark(myDispRemark);
						myComponent.setLicenseDocument(licenseDoc);
						LOG.debug("getItemDispRemark : "+myComponent.getItemDispRemark());
						LOG.debug("getLicenseDocument : "+myComponent.getLicenseDocument());
						//--------------------------------------------------------------
						
						WrapperBeanObject<LegalDocComponentBean> tmpWrapperBean = new WrapperBeanObject<LegalDocComponentBean>();
						
						tmpWrapperBean.setDataObj(myComponent);
						tmpWrapperBean.setMessage("");

						semmsa002Bean.getLegalDocList().add(tmpWrapperBean);
						semmsa002Bean.getSiteAppObjParam().setLegalDocEffectiveDt(docEffDT);
						// gen legal doc component list <<
						
						count++;
					}
					semmsa002Bean.setRenderedMsgDataNotFound(false);
	        	} else {
	        		semmsa002Bean.setRenderedMsgDataNotFound(true);
	        	}
        	
	        }
	        
			setSemmsa002Bean(semmsa002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA002Action");
			
			semmsa002Bean.setRenderedMsgAlert(true);
			setSemmsa002Bean(semmsa002Bean);
		} finally {
			LOG.info("::: SEMMSA002Action :: doGetLegalDoc >> END :::");
		}
	}
	
	public void doRenderCheckBox(SiteAppSP retObj) {
		
		try {
			
			semmsa002Bean = getSemmsa002Bean();
			
			// tab0
			if(retObj.getTerminateRemoveFlag() != null && retObj.getTerminateRemoveFlag().equalsIgnoreCase("Y")){
				semmsa002Bean.setChkTerminateRemoveFlag(true);
			} else {
				semmsa002Bean.setChkTerminateRemoveFlag(false);
			}
			
			if(retObj.getTerminateCancelRelateData() != null && retObj.getTerminateCancelRelateData().equalsIgnoreCase("Y")){
				semmsa002Bean.setChkTerminateCancelRelateData(true);
			} else {
				semmsa002Bean.setChkTerminateCancelRelateData(false);
			}
			
			//added by NEW 2018/11/02
			if(retObj.getOtherWaitingFlag() != null && retObj.getOtherWaitingFlag().equalsIgnoreCase("Y")){
				semmsa002Bean.setChkOtherWaitingFlag(true);
			} else {
				semmsa002Bean.setChkOtherWaitingFlag(false);
			}
			
			if(retObj.getReturnDepositFlag() != null && retObj.getReturnDepositFlag().equalsIgnoreCase("Y")){
				semmsa002Bean.setChkReturnDepositFlag(true);
			} else {
				semmsa002Bean.setChkReturnDepositFlag(false);
			}
			
			if(retObj.getNoReturnDepositFlag() != null && retObj.getNoReturnDepositFlag().equalsIgnoreCase("Y")){
				semmsa002Bean.setChkNoReturnDepositFlag(true);
			} else {
				semmsa002Bean.setChkNoReturnDepositFlag(false);
			}
			
			if(retObj.getCancelMeterFlag() != null && retObj.getCancelMeterFlag().equalsIgnoreCase("Y")){
				semmsa002Bean.setChkCancelMeterFlag(true);
			} else {
				semmsa002Bean.setChkCancelMeterFlag(false);
			}
			
			if(retObj.getTerminateElFlag() != null && retObj.getTerminateElFlag().equalsIgnoreCase("Y")){
				semmsa002Bean.setChkTerminateElFlag(true);
			} else {
				semmsa002Bean.setChkTerminateElFlag(false);
			}
			
			if(retObj.getOtherTerminateFlag() != null && retObj.getOtherTerminateFlag().equalsIgnoreCase("Y")){
				semmsa002Bean.setChkOtherTerminateFlag(true);
			} else {
				semmsa002Bean.setChkOtherTerminateFlag(false);
			}
			
			
			// tab1
			if(retObj.getNeedLegalApprove() != null && retObj.getNeedLegalApprove().equalsIgnoreCase("Y")){
				semmsa002Bean.setChkNeedLegalApprove(true);
			} else {
				semmsa002Bean.setChkNeedLegalApprove(false);
			}
			
			if(retObj.getNeedAvpApprove() != null && retObj.getNeedAvpApprove().equalsIgnoreCase("Y")){
				semmsa002Bean.setChkNeedAvpApprove(true);
			} else {
				semmsa002Bean.setChkNeedAvpApprove(false);
			}
			
			if(retObj.getNeedConstruction() != null && retObj.getNeedConstruction().equalsIgnoreCase("Y")){
				semmsa002Bean.setChkNeedConstruction(true);
			} else {
				semmsa002Bean.setChkNeedConstruction(false);
			}
			
			if(retObj.getIsCoLocate() != null && retObj.getIsCoLocate().equalsIgnoreCase("Y")){
				semmsa002Bean.setChkCoLocate(true);
			} else {
				semmsa002Bean.setChkCoLocate(false);
			}
			
			if(retObj.getReqOfficerManual() != null && !retObj.getReqOfficerManual().equals("Y")){
				semmsa002Bean.setChkReqOfficerManual(true);
			} else {
				semmsa002Bean.setChkReqOfficerManual(false);
			}
			
			if(retObj.getIsMacroType() != null && retObj.getIsMacroType().equals("Y")){
				semmsa002Bean.setChkMacroType(true);
			} else {
				semmsa002Bean.setChkMacroType(false);
			}
			
			if(retObj.getIsMicroType() != null && retObj.getIsMicroType().equals("Y")){
				semmsa002Bean.setChkMicroType(true);
			} else {
				semmsa002Bean.setChkMicroType(false);
			}
			
			if(retObj.getIsPicoType() != null && retObj.getIsPicoType().equals("Y")){
				semmsa002Bean.setChkPicoType(true);
			} else {
				semmsa002Bean.setChkPicoType(false);
			}
			
			if(retObj.getIsRepeaterType() != null && retObj.getIsRepeaterType().equals("Y")){
				semmsa002Bean.setChkRepeaterType(true);
			} else {
				semmsa002Bean.setChkRepeaterType(false);
			}
			
			if(retObj.getIsTowerType() != null && retObj.getIsTowerType().equals("Y")){
				semmsa002Bean.setChkTowerType(true);
			} else {
				semmsa002Bean.setChkTowerType(false);
			}
			
			if(retObj.getIsWifiType() != null && retObj.getIsWifiType().equals("Y")){
				semmsa002Bean.setChkWifiType(true);
			} else {
				semmsa002Bean.setChkWifiType(false);
			}
			
			if(retObj.getIsOtherType() != null && retObj.getIsOtherType().equals("Y")){
				semmsa002Bean.setChkOtherType(true);
			} else {
				semmsa002Bean.setChkOtherType(false);
			}
			
			if(retObj.getIsSmallcellType() != null && retObj.getIsSmallcellType().equals("Y")){
				semmsa002Bean.setChkSmallcellType(true);
			} else {
				semmsa002Bean.setChkSmallcellType(false);
			}
			
			if(retObj.getIsFBBType() != null && retObj.getIsFBBType().equals("Y")){
				semmsa002Bean.setChkFBBType(true);
			} else {
				semmsa002Bean.setChkFBBType(false);
			}
			
			if(retObj.getIsOFCType() != null && retObj.getIsOFCType().equals("Y")){
				semmsa002Bean.setChkOFCType(true);
			} else {
				semmsa002Bean.setChkOFCType(false);
			}
			
			if(retObj.getIsFTTXType() != null && retObj.getIsFTTXType().equals("Y")){
				semmsa002Bean.setChkFTTXType(true);
			} else {
				semmsa002Bean.setChkFTTXType(false);
			}
			
			// tab2
			if(retObj.getContractWanted() != null && retObj.getContractWanted().equalsIgnoreCase("Y")){
				semmsa002Bean.setChkContractWanted(true);
			} else {
				semmsa002Bean.setChkContractWanted(false);
			}
			
			if(retObj.getContractNeverExpire() != null && retObj.getContractNeverExpire().equalsIgnoreCase("Y")){
				semmsa002Bean.setChkContractNeverExpire(true);
			} else {
				semmsa002Bean.setChkContractNeverExpire(false);
			}
			
			if(retObj.getRenewRentAddFlag() != null && retObj.getRenewRentAddFlag().equalsIgnoreCase("Y")){
				semmsa002Bean.setChkContRentAdd(true);
			} else {
				semmsa002Bean.setChkContRentAdd(false);
			}
			
			// tab3
			if(retObj.getRentDepositFlag() != null && retObj.getRentDepositFlag().equalsIgnoreCase("Y")){
				semmsa002Bean.setChkRentDepositFlag(true);
			} else {
				semmsa002Bean.setChkRentDepositFlag(false);
			}
			
			// tab4
			if(retObj.getElUseNewMeter() != null && retObj.getElUseNewMeter().equalsIgnoreCase("Y")){
				semmsa002Bean.setChkElUseNewMeter(true);
			} else {
				semmsa002Bean.setChkElUseNewMeter(false);
			}
			
			if(retObj.getElUseOwner() != null && retObj.getElUseOwner().equalsIgnoreCase("Y")){
				semmsa002Bean.setChkElUseOwner(true);
			} else {
				semmsa002Bean.setChkElUseOwner(false);
			}
			
			if(retObj.getElUseOldMeter() != null && retObj.getElUseOldMeter().equalsIgnoreCase("Y")){
				semmsa002Bean.setChkElUseOldMeter(true);
			} else {
				semmsa002Bean.setChkElUseOldMeter(false);
			}
			
			if(retObj.getElPayOnPackage() != null && retObj.getElPayOnPackage().equalsIgnoreCase("Y")){
				semmsa002Bean.setChkElPayOnPackage(true);
			} else {
				semmsa002Bean.setChkElPayOnPackage(false);
			}
			
			if(retObj.getElOwnerType() != null && retObj.getElOwnerType().equalsIgnoreCase("Y")){
				semmsa002Bean.setChkElOwnerType(true);
			} else {
				semmsa002Bean.setChkElOwnerType(false);
			}
			
			if(retObj.getElDepositFlag() != null && retObj.getElDepositFlag().equalsIgnoreCase("Y")){
				semmsa002Bean.setChkElDepositFlag(true);
			} else {
				semmsa002Bean.setChkElDepositFlag(false);
			}
			
			if(retObj.getElUseOthSite() != null && retObj.getElUseOthSite().equals("Y")){
				semmsa002Bean.setChkElUseOthSite(true);
			} else {
				semmsa002Bean.setChkElUseOthSite(false);
			}
			
			if(retObj.getElUseOth() != null && retObj.getElUseOth().equals("Y")){
				semmsa002Bean.setChkElUseOth(true);
			} else {
				semmsa002Bean.setChkElUseOth(false);
			}
			
			if(retObj.getElNoExpenses() != null && retObj.getElNoExpenses().equals("Y")){
				semmsa002Bean.setChkNoExpenses(true);
			} else {
				semmsa002Bean.setChkNoExpenses(false);
			}
			
			if(retObj.getRentalNoExpenses() != null && retObj.getRentalNoExpenses().equals("Y")){
				semmsa002Bean.setChkRentalNoExpenses(true);
			} else {
				semmsa002Bean.setChkRentalNoExpenses(false);
			}
			
			if(retObj.getRentalNoDeposit() != null && StringUtils.equals("Y", retObj.getRentalNoDeposit())){
				semmsa002Bean.setChkNoRentalDeposit(true);
			}else{
				semmsa002Bean.setChkNoRentalDeposit(false);
			}
			
			//added by NEW 20160401 check multiElectric CheckBox
			if(semmsa002Bean.isChkElUseNewMeter()){
				semmsa002Bean.setChkMultiElectricTypeFlag(true);
			}
			
			if(retObj.getElNoDeposit() != null && StringUtils.equals("Y", retObj.getElNoDeposit())){
				semmsa002Bean.setChkNoELDeposit(true);
			}else{
				semmsa002Bean.setChkNoELDeposit(false);
			}
			
			//Tab5
			if(retObj.getPropertyTaxEditFlag() != null && retObj.getPropertyTaxEditFlag().equals("Y")){
				semmsa002Bean.setPropertyTaxEditFlag(true);
			} else {
				semmsa002Bean.setPropertyTaxEditFlag(false);
			}
			
			//TAB6 
			if(retObj.getInsuranceEditFlag() != null && retObj.getInsuranceEditFlag().equals("Y")){
				semmsa002Bean.setInsuranceEditFlag(true);
			} else {
				semmsa002Bean.setInsuranceEditFlag(false);
			}
			
			setSemmsa002Bean(semmsa002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA002Action");
			
			semmsa002Bean.setRenderedMsgAlert(true);
			setSemmsa002Bean(semmsa002Bean);
		} finally {
			
		}
	}
	
	public void doSetCheckBoxEntity() {
		
		try {
			
			semmsa002Bean = getSemmsa002Bean();

			// tab0 only 'getSiteAppTab0ObjParam'
			if(semmsa002Bean.isChkTerminateRemoveFlag()){
				semmsa002Bean.getSiteAppTab0ObjParam().setTerminateRemoveFlag("Y");
			} else {
				semmsa002Bean.getSiteAppTab0ObjParam().setTerminateRemoveFlag("");
			}
			
			if(semmsa002Bean.isChkTerminateCancelRelateData()){
				semmsa002Bean.getSiteAppTab0ObjParam().setTerminateCancelRelateData("Y");
			} else {
				semmsa002Bean.getSiteAppTab0ObjParam().setTerminateCancelRelateData("");
			}
			
			
			//added by NEW 2018/11/02
			if(semmsa002Bean.isChkOtherWaitingFlag()){
				semmsa002Bean.getSiteAppTab0ObjParam().setOtherWaitingFlag("Y");
			} else {
				semmsa002Bean.getSiteAppTab0ObjParam().setOtherWaitingFlag("");
			}
			
			if(semmsa002Bean.isChkReturnDepositFlag()){
				semmsa002Bean.getSiteAppTab0ObjParam().setReturnDepositFlag("Y");
			} else {
				semmsa002Bean.getSiteAppTab0ObjParam().setReturnDepositFlag("");
			}
			
			if(semmsa002Bean.isChkNoReturnDepositFlag()){
				semmsa002Bean.getSiteAppTab0ObjParam().setNoReturnDepositFlag("Y");
			} else {
				semmsa002Bean.getSiteAppTab0ObjParam().setNoReturnDepositFlag("");
			}
			
			if(semmsa002Bean.isChkCancelMeterFlag()){
				semmsa002Bean.getSiteAppTab0ObjParam().setCancelMeterFlag("Y");
			} else {
				semmsa002Bean.getSiteAppTab0ObjParam().setCancelMeterFlag("");
			}
			
			if(semmsa002Bean.isChkTerminateElFlag()){
				semmsa002Bean.getSiteAppTab0ObjParam().setTerminateElFlag("Y");
			} else {
				semmsa002Bean.getSiteAppTab0ObjParam().setTerminateElFlag("");
			}
			
			if(semmsa002Bean.isChkOtherTerminateFlag()){
				semmsa002Bean.getSiteAppTab0ObjParam().setOtherTerminateFlag("Y");
			} else {
				semmsa002Bean.getSiteAppTab0ObjParam().setOtherTerminateFlag("");
			}
			
			// tab1
			if(semmsa002Bean.isChkNeedLegalApprove()){
				semmsa002Bean.getSiteAppObjParam().setNeedLegalApprove("Y");
			} else {
				semmsa002Bean.getSiteAppObjParam().setNeedLegalApprove("");
			}
			
			if(semmsa002Bean.isChkNeedAvpApprove()){
				semmsa002Bean.getSiteAppObjParam().setNeedAvpApprove("Y");
			} else {
				semmsa002Bean.getSiteAppObjParam().setNeedAvpApprove("");
			}
			
			if(semmsa002Bean.isChkNeedConstruction()){
				semmsa002Bean.getSiteAppObjParam().setNeedConstruction("Y");
			} else {
				semmsa002Bean.getSiteAppObjParam().setNeedConstruction("");
			}
			
			if(semmsa002Bean.isChkCoLocate()){
				semmsa002Bean.getSiteAppObjParam().setIsCoLocate("Y");
			} else {
				semmsa002Bean.getSiteAppObjParam().setIsCoLocate("");
			}
			
			if(semmsa002Bean.isChkMacroType()){
				semmsa002Bean.getSiteAppObjParam().setIsMacroType("Y");
			} else {
				semmsa002Bean.getSiteAppObjParam().setIsMacroType("N");
			}
			
			if(semmsa002Bean.isChkMicroType()){
				semmsa002Bean.getSiteAppObjParam().setIsMicroType("Y");
			} else {
				semmsa002Bean.getSiteAppObjParam().setIsMicroType("N");
			}
			
			if(semmsa002Bean.isChkPicoType()){
				semmsa002Bean.getSiteAppObjParam().setIsPicoType("Y");
			} else {
				semmsa002Bean.getSiteAppObjParam().setIsPicoType("N");
			}
			
			if(semmsa002Bean.isChkRepeaterType()){
				semmsa002Bean.getSiteAppObjParam().setIsRepeaterType("Y");
			} else {
				semmsa002Bean.getSiteAppObjParam().setIsRepeaterType("N");
			}

			if(semmsa002Bean.isChkTowerType()){
				semmsa002Bean.getSiteAppObjParam().setIsTowerType("Y");
			} else {
				semmsa002Bean.getSiteAppObjParam().setIsTowerType("N");
			}
			
			if(semmsa002Bean.isChkWifiType()){
				semmsa002Bean.getSiteAppObjParam().setIsWifiType("Y");
			} else {
				semmsa002Bean.getSiteAppObjParam().setIsWifiType("N");
			}
			
			if(semmsa002Bean.isChkOtherType()){
				semmsa002Bean.getSiteAppObjParam().setIsOtherType("Y");
			} else {
				semmsa002Bean.getSiteAppObjParam().setIsOtherType("N");
			}
			
			if(semmsa002Bean.isChkSmallcellType()){
				semmsa002Bean.getSiteAppObjParam().setIsSmallcellType("Y");
			} else {
				semmsa002Bean.getSiteAppObjParam().setIsSmallcellType("N");
			}
			
			if(semmsa002Bean.isChkFBBType()){
				semmsa002Bean.getSiteAppObjParam().setIsFBBType("Y");
			} else {
				semmsa002Bean.getSiteAppObjParam().setIsFBBType("N");
			}
			
			if(semmsa002Bean.isChkOFCType()){
				semmsa002Bean.getSiteAppObjParam().setIsOFCType("Y");
			} else {
				semmsa002Bean.getSiteAppObjParam().setIsOFCType("N");
			}
			
			if(semmsa002Bean.isChkFTTXType()){
				semmsa002Bean.getSiteAppObjParam().setIsFTTXType("Y");
			} else {
				semmsa002Bean.getSiteAppObjParam().setIsFTTXType("N");
			}
			
			// tab2
			if(semmsa002Bean.isChkContractWanted()){
				semmsa002Bean.getSiteAppObjParam().setContractWanted("Y");
			} else {
				semmsa002Bean.getSiteAppObjParam().setContractWanted("");
			}
			
			if(semmsa002Bean.isChkContractNeverExpire()){
				semmsa002Bean.getSiteAppObjParam().setContractNeverExpire("Y");
			} else {
				semmsa002Bean.getSiteAppObjParam().setContractNeverExpire("");
			}
			
			if(semmsa002Bean.isLeaseHoldRights()){
				semmsa002Bean.getSiteAppObjParam().setLeaseHoldRights("Y");
			}else{
				semmsa002Bean.getSiteAppObjParam().setLeaseHoldRights("");
			}
			
			if(semmsa002Bean.isChkContRentAdd()){
				semmsa002Bean.getSiteAppObjParam().setRenewRentAddFlag("Y");
			}else{
				semmsa002Bean.getSiteAppObjParam().setRenewRentAddFlag("");
			}
			
//			if(semmsa002Bean.isLicense()){
//				semmsa002Bean.getSiteAppObjParam().setLicense("Y");
//			}else{
//				semmsa002Bean.getSiteAppObjParam().setLicense("");
//			}
			
			if(semmsa002Bean.isLlRentalAgreement()){
				semmsa002Bean.getSiteAppObjParam().setLlRentalAgreement("Y");
			}else{
				semmsa002Bean.getSiteAppObjParam().setLlRentalAgreement("");
			}
			
			// tab3
			if(semmsa002Bean.isChkRentDepositFlag()){
				semmsa002Bean.getSiteAppObjParam().setRentDepositFlag("Y");
			} else {
				semmsa002Bean.getSiteAppObjParam().setRentDepositFlag("");
			}
			if(semmsa002Bean.isChkInsureHave()){
				semmsa002Bean.getSiteAppObjParam().setInsFlag("Y");
			}else{
				semmsa002Bean.getSiteAppObjParam().setInsFlag("");
			}
			if(semmsa002Bean.isChkInsureNotHave()){
				semmsa002Bean.getSiteAppObjParam().setInsFlag("N");
			}else{
				semmsa002Bean.getSiteAppObjParam().setInsFlag("");
			}
			if(semmsa002Bean.isChkRentalNoExpenses()){
				semmsa002Bean.getSiteAppObjParam().setRentalNoExpenses("Y");
			} else {
				semmsa002Bean.getSiteAppObjParam().setRentalNoExpenses("");
			}
			if(semmsa002Bean.isChkNoRentalDeposit()){
				semmsa002Bean.getSiteAppObjParam().setRentalNoDeposit("Y");
			}else{
				semmsa002Bean.getSiteAppObjParam().setRentalNoDeposit("");
			}
			
			// tab4
			if(semmsa002Bean.isChkElUseNewMeter()){
				semmsa002Bean.getSiteAppObjParam().setElUseNewMeter("Y");
			} else {
				semmsa002Bean.getSiteAppObjParam().setElUseNewMeter("");
			}
			
			if(semmsa002Bean.isChkElUseOwner()){
				semmsa002Bean.getSiteAppObjParam().setElUseOwner("Y");
			} else {
				semmsa002Bean.getSiteAppObjParam().setElUseOwner("");
			}

			if(semmsa002Bean.isChkElUseOldMeter()){
				semmsa002Bean.getSiteAppObjParam().setElUseOldMeter("Y");
			} else {
				semmsa002Bean.getSiteAppObjParam().setElUseOldMeter("");
			}

			if(semmsa002Bean.isChkElPayOnPackage()){
				semmsa002Bean.getSiteAppObjParam().setElPayOnPackage("Y");
			} else {
				semmsa002Bean.getSiteAppObjParam().setElPayOnPackage("");
			}

			if(semmsa002Bean.isChkElOwnerType()){
				semmsa002Bean.getSiteAppObjParam().setElOwnerType("Y");
			} else {
				semmsa002Bean.getSiteAppObjParam().setElOwnerType("");
			}
			
			if(semmsa002Bean.isChkElDepositFlag()){
				semmsa002Bean.getSiteAppObjParam().setElDepositFlag("Y");
			} else {
				semmsa002Bean.getSiteAppObjParam().setElDepositFlag("");
			}
			
			if(semmsa002Bean.isChkElUseOthSite()){
				semmsa002Bean.getSiteAppObjParam().setElUseOthSite("Y");
			} else {
				semmsa002Bean.getSiteAppObjParam().setElUseOthSite("N");
			}
			
			if(semmsa002Bean.isChkNoExpenses()){
				semmsa002Bean.getSiteAppObjParam().setElNoExpenses("Y");
			}else{
				semmsa002Bean.getSiteAppObjParam().setElNoExpenses("");
			}
			
			if(semmsa002Bean.isChkMultiElectricTypeFlag()){
				semmsa002Bean.getSiteAppObjParam().setElUseMultiResourse("Y");
			}else{
				semmsa002Bean.getSiteAppObjParam().setElUseMultiResourse("");
			}
			
			if(semmsa002Bean.isChkNoUtilPrice()){
				semmsa002Bean.getSiteAppObjParam().setNoUtilPrice("Y");
			}else{
				semmsa002Bean.getSiteAppObjParam().setNoUtilPrice("");
			}
			
			if(semmsa002Bean.isChkElUseOth()){
				semmsa002Bean.getSiteAppObjParam().setElUseOth("Y");
			}else{
				semmsa002Bean.getSiteAppObjParam().setElUseOth("");
			}
			
			if(semmsa002Bean.isChkNoELDeposit()){
				semmsa002Bean.getSiteAppObjParam().setElNoDeposit("Y");
			}else{
				semmsa002Bean.getSiteAppObjParam().setElNoDeposit("");
			}
			
			//Tab5
//			if(semmsa002Bean.isPropertyTaxEditFlag()){
//				semmsa002Bean.getSiteAppObjParam().setPropertyTaxEditFlag("Y");
//			}else{
//				semmsa002Bean.getSiteAppObjParam().setPropertyTaxEditFlag("");
//			}
//			
//			//TA6
//			if(semmsa002Bean.isInsuranceEditFlag()){
//				semmsa002Bean.getSiteAppObjParam().setInsuranceEditFlag("Y");
//			}else{
//				semmsa002Bean.getSiteAppObjParam().setInsuranceEditFlag("");
//			}
			setSemmsa002Bean(semmsa002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA002Action");
			
			semmsa002Bean.setRenderedMsgAlert(true);
			setSemmsa002Bean(semmsa002Bean);
		} finally {
			
		}
	}
	
	// tab5
	public void doSetCheckBoxLegalDocEntity() {
		
		try {
			
			semmsa002Bean = getSemmsa002Bean();
			
			List<WrapperBeanObject<LegalDocComponentBean>> legalDocLst = semmsa002Bean.getLegalDocList();
			
			for(int i=0; i<legalDocLst.size(); i++){
				LegalDocComponentBean myObj = (LegalDocComponentBean) legalDocLst.get(i).getDataObj();

				if(myObj.isChkHaveFlag()) {
					myObj.setItemIsChk("Y");
				} else if (myObj.isChkNotHaveFlag()) {
					myObj.setItemIsChk("N");
				} else {
					myObj.setItemIsChk("");
				}
				legalDocLst.get(i).setDataObj(myObj);
				
				semmsa002Bean.setLegalDocList(legalDocLst);
			}
			
			setSemmsa002Bean(semmsa002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA002Action");
			
			semmsa002Bean.setRenderedMsgAlert(true);
			setSemmsa002Bean(semmsa002Bean);
		} finally {
			
		}
	}
	
	
	// tab5
	private UIRepeat repeater;
	public void setRepeater(UIRepeat repeater) {
        this.repeater = repeater;
    }

    public UIRepeat getRepeater() {
        return repeater;
    }

	// tab5
	public void doChangeChkBoxLegalDoc() {
		
		try {
			
			semmsa002Bean = getSemmsa002Bean();
			
			/*HashSet keys = new HashSet<Integer>();
	        int rowKey = getRepeater().getRowIndex();
	        System.out.println("rowKey: " + Integer.toString(rowKey));*/
			
			String paramChkStts = getFacesUtils().getRequestParameter("paramChkStts") == null ? "" : (String) getFacesUtils().getRequestParameter("paramChkStts");
			String paramItemCode = getFacesUtils().getRequestParameter("paramItemCode") == null ? "" : (String) getFacesUtils().getRequestParameter("paramItemCode");
	        
			List<WrapperBeanObject<LegalDocComponentBean>> legalDocLst = semmsa002Bean.getLegalDocList();
			System.out.println("getLegalDocList size: " + legalDocLst.size());
			
			for(int i=0; i<legalDocLst.size(); i++){
				LegalDocComponentBean myObj = (LegalDocComponentBean) legalDocLst.get(i).getDataObj();
				
				String myItemCode = myObj.getItemCode();
				
				if(myItemCode.equals(paramItemCode)) {
					if(paramChkStts.equals("Y")) {
						
						if(myObj.isChkHaveFlag()) {
							myObj.setChkHaveFlag(true);
						 	myObj.setChkNotHaveFlag(false);
							myObj.setItemIsChk("Y");
						} else {
							myObj.setChkHaveFlag(false);
						 	myObj.setChkNotHaveFlag(false);
							myObj.setItemIsChk("");
						}
						
					} else if (paramChkStts.equals("N")) {
						
						if(myObj.isChkNotHaveFlag()) {
							myObj.setChkHaveFlag(false);
						 	myObj.setChkNotHaveFlag(true);
							myObj.setItemIsChk("N");
						} else {
							myObj.setChkHaveFlag(false);
						 	myObj.setChkNotHaveFlag(false);
							myObj.setItemIsChk("");
						}
					}
				}
				legalDocLst.get(i).setDataObj(myObj);
				semmsa002Bean.setLegalDocList(legalDocLst);
			}
			
			setSemmsa002Bean(semmsa002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA002Action");
			
			semmsa002Bean.setRenderedMsgAlert(true);
			setSemmsa002Bean(semmsa002Bean);
		} finally {
			
		}
	}
	
	public void doUpdateLegalDoc() {
		
		try {
			
			this.doSetCheckBoxLegalDocEntity();			
			
			semmsa002Bean = getSemmsa002Bean();
			
			List<WrapperBeanObject<LegalDocComponentBean>> legalDocLst = semmsa002Bean.getLegalDocList();
			//System.out.println("getLegalDocList size: " + legalDocLst.size());
			
			String strDataList = "";
			
			for(int i=0; i<legalDocLst.size(); i++){
				
				LegalDocComponentBean myObj = (LegalDocComponentBean) legalDocLst.get(i).getDataObj();
				
				String docCode = myObj.getItemCode() == null ? "" : myObj.getItemCode().toString();
				String docRemark = myObj.getItemRemark() == null ? "" : myObj.getItemRemark().toString();
				String docFlag = myObj.getItemIsChk() == null ? "" : myObj.getItemIsChk().toString();
				
				strDataList += "" + docCode + "|" + docFlag + "|" + docRemark + ", ";
			}
			strDataList = strDataList.equals("") ? "" : strDataList.substring(0, strDataList.length() - 2);

			semmsa002Bean.getSiteAppObjParam().setStrDataList(strDataList);
			semmsa002Bean.getSiteAppObjParam().setUserLogin(getUserLogIn());

			ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService");
			List<SiteAppSP> to = service.siteAppDao_querySPList(EQueryName.SP_MSA002_SITE_APP_DOC_SAVE.name, semmsa002Bean.getSiteAppObjParam());
			
			if (to != null && !to.isEmpty()) {
				if (to.get(0).getRetResult().equals("Success")) {
					addMessageInfo("M0001");	// data save success
					semmsa002Bean.setRenderedMsgAlert(true);
				} else {
					addMessageError("E0001");	// data save fail
					LOG.error("ERROR SP_MSA002_SITE_APP_DOC_SAVE :"+to.get(0).getRetResult());
	        		semmsa002Bean.setRenderedMsgAlert(true);
				}
			}
			
			setSemmsa002Bean(semmsa002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA002Action");
			
			semmsa002Bean.setRenderedMsgAlert(true);
			setSemmsa002Bean(semmsa002Bean);
		} finally {
			
		}
		
	}
	
	public void doShowPopupHistory(){
		semmsa002Bean = getSemmsa002Bean();
		String tabNo = (String)getFacesUtils().getRequestParameter("tabNo");
		//String tabNo = semmsa002Bean.getSelectedTab();
		semmsa002Bean.setChkDataNotFound(false);
		List<SiteAppSP> siteAppList = null;
		List<SiteAppSiteSP> siteAppSiteList = null;
		try{
			ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService");
			LOG.debug("Start doPopupHistoryTab1()");
			if("1".equals(tabNo)){
				siteAppList = service.siteAppDao_querySPList(EQueryName.SP_MSA002_MAIN_SITE_HISTORY_TAB.name, semmsa002Bean.getSiteAppObjParam());
			}else if("2".equals(tabNo)){
				siteAppList = service.siteAppDao_querySPList(EQueryName.SP_MSA002_POPUP_CONTRACT_HISTORY_TAB.name, semmsa002Bean.getSiteAppObjParam());
			}else if("3".equals(tabNo)){
				siteAppList = service.siteAppDao_querySPList(EQueryName.SP_MSA002_POPUP_RENTAL_HISTORY_TAB.name, semmsa002Bean.getSiteAppObjParam());
			}else if("4".equals(tabNo)){
				siteAppList = service.siteAppDao_querySPList(EQueryName.SP_MSA002_POPUP_ELECTRICAL_HISTORY_TAB.name, semmsa002Bean.getSiteAppObjParam());
			}else if("5".equals(tabNo)){
				siteAppList = service.siteAppDao_querySPList(EQueryName.SP_MSA002_POPUP_ELECTRICAL_DEPOSIT_HISTORY_TAB.name, semmsa002Bean.getSiteAppObjParam());
			}else if("6".equals(tabNo)){
				siteAppList = service.siteAppDao_querySPList(EQueryName.SP_MSA002_POPUP_PROPERTY_TAX_HISTORY_TAB.name, semmsa002Bean.getSiteAppObjParam());
			}else if("7".equals(tabNo)){
				siteAppList = service.siteAppDao_querySPList(EQueryName.SP_MSA002_POPUP_INSURANCE_HISTORY_TAB.name, semmsa002Bean.getSiteAppObjParam());
			}

			if(siteAppList != null && siteAppList.size()>0){
				//LOG.debug("siteAppObjParam siteappID = "+siteAppList.get(0).getRowId());
				semmsa002Bean.setSiteAppPopupHistoryList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				for (int i = 0; i < siteAppList.size(); i++) {
					SiteAppSP siteApp = siteAppList.get(i);
					WrapperBeanObject<SiteAppSP> tmpWrapperBean = new WrapperBeanObject<SiteAppSP>();
					if(siteApp.getUpdateDT() != null) {
//						siteInfo.setEffDate(convertYearENtoTH(siteInfo.getEffDate()));
						siteApp.setUpdateDTStr(convertYearENtoTHStr(siteApp.getUpdateDT()));
					}
					if(siteApp.getInsEffectiveDt() != null){
//						siteInfo.setExpDate(convertYearENtoTH(siteInfo.getExpDate()));
						siteApp.setInsEffectiveDtStr(convertYearENtoTHStr(siteApp.getInsEffectiveDt()));
					}
					if(siteApp.getInsExpireDt() != null){
//						siteInfo.setExpDate(convertYearENtoTH(siteInfo.getExpDate()));
						siteApp.setInsExpireDtStr(convertYearENtoTHStr(siteApp.getInsExpireDt()));
					}
//					if(siteApp.getApproveDT() != null){
////						siteInfo.setExpDate(convertYearENtoTH(siteInfo.getExpDate()));
//						siteApp.setApproveDTStr(convertYearENtoTHStr(siteApp.getApproveDT()));
//					}
					
					//query subSite
					if("1".equals(tabNo)){
						SiteAppSiteSP siteAppSiteSP = new SiteAppSiteSP();
						siteAppSiteSP.setSiteAppId(siteApp.getSiteAppId());
						
						siteAppSiteList = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA002_SUB_SITE_HISTORY_TAB.name, siteAppSiteSP);
						
						if(siteAppSiteList != null && siteAppSiteList.size()>0){
							siteApp.setSiteAppSiteList(new ArrayList<WrapperBeanObject<SiteAppSiteSP>>());
							for(int j = 0; j < siteAppSiteList.size(); j++){
								siteAppSiteSP = siteAppSiteList.get(j);
								//SiteAppSP siteApp = siteAppList.get(i);
								WrapperBeanObject<SiteAppSiteSP> tmpWrapperSubBean = new WrapperBeanObject<SiteAppSiteSP>();
								if(siteAppSiteSP.getUpdateDT() != null){
									siteAppSiteSP.setUpdateDTStr(convertYearENtoTHStr(siteAppSiteSP.getUpdateDT()));
								}
								
								tmpWrapperSubBean.setDataObj(siteAppSiteSP);
								tmpWrapperSubBean.setMessage("");
								//semmsa002Bean.getSiteAppPopupHistoryList().add(tmpWrapperBean);
								siteApp.getSiteAppSiteList().add(tmpWrapperSubBean);
							}
						}
					}
					
					tmpWrapperBean.setDataObj(siteApp);
					tmpWrapperBean.setMessage("");
					semmsa002Bean.getSiteAppPopupHistoryList().add(tmpWrapperBean);
				}
				
				//set data return
				//semmsa002Bean.setSiteAppPopupHistoryList(siteAppList);
			}else{
				semmsa002Bean.setChkDataNotFound(true);
				semmsa002Bean.setSiteAppPopupHistoryList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				semmsa002Bean.setSiteAppSiteList(new ArrayList<WrapperBeanObject<SiteAppSiteSP>>());
//				SiteAppSP siteApp = new SiteAppSP();
//				WrapperBeanObject<SiteAppSP> tmpWrapperBean = new WrapperBeanObject<SiteAppSP>();
//				//List<WrapperBeanObject<SiteAppSP>> siteappList = new ArrayList<WrapperBeanObject<SiteAppSP>>();
//				semmsa002Bean.setSiteAppPopupHistoryList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
//				//siteApp.setDocNo("test");
//				siteApp = semmsa002Bean.getSiteAppObjParam();
//				tmpWrapperBean.setDataObj(siteApp);
//				tmpWrapperBean.setMessage("");
//				
//			
//				semmsa002Bean.getSiteAppPopupHistoryList().add(tmpWrapperBean);
//				//semmsa002Bean.setSiteAppPopupHistoryList(siteAppPopupHistoryList)
			}
			
		}catch (Exception e) {
			semmsa002Bean.setSiteAppPopupHistoryList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
			semmsa002Bean.setSiteAppSiteList(new ArrayList<WrapperBeanObject<SiteAppSiteSP>>());
			e.printStackTrace();
			LOG.error(e);
			// TODO: handle exception
		}finally{
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	
	public void doShowPopupRentalHistory(){
		semmsa002Bean = getSemmsa002Bean();
		semmsa002Bean.setChkDataNotFound(false);
		List<SiteAppSP> siteAppList = null;
		List<SiteAppSiteSP> siteAppSiteList = null;
		try{
			ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService");
			siteAppList = service.siteAppDao_querySPList(EQueryName.SP_MSA002_RENTAL_HISTORY_TAB.name, semmsa002Bean.getSiteAppObjParam());
			

			if(siteAppList != null && siteAppList.size()>0){
				//LOG.debug("siteAppObjParam siteappID = "+siteAppList.get(0).getRowId());
				semmsa002Bean.setSiteAppPopupHistoryList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				for (int i = 0; i < siteAppList.size(); i++) {
					SiteAppSP siteApp = siteAppList.get(i);
					WrapperBeanObject<SiteAppSP> tmpWrapperBean = new WrapperBeanObject<SiteAppSP>();
					if(siteApp.getUpdateDT() != null) {
//						siteInfo.setEffDate(convertYearENtoTH(siteInfo.getEffDate()));
						siteApp.setUpdateDTStr(convertYearENtoTHStr(siteApp.getUpdateDT()));
					}
					if(siteApp.getEffectiveDt() != null){
//						siteInfo.setExpDate(convertYearENtoTH(siteInfo.getExpDate()));
						siteApp.setEffectiveDtStr(convertYearENtoTHStr(siteApp.getEffectiveDt()));
					}
					if(siteApp.getExpireDt() != null){
//						siteInfo.setExpDate(convertYearENtoTH(siteInfo.getExpDate()));
						siteApp.setExpireDtStr(convertYearENtoTHStr(siteApp.getExpireDt()));
					}
//					
					tmpWrapperBean.setDataObj(siteApp);
					tmpWrapperBean.setMessage("");
					semmsa002Bean.getSiteAppPopupHistoryList().add(tmpWrapperBean);
				}
				
				//set data return
				//semmsa002Bean.setSiteAppPopupHistoryList(siteAppList);
			}else{
				semmsa002Bean.setChkDataNotFound(true);
				semmsa002Bean.setSiteAppPopupHistoryList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				semmsa002Bean.setSiteAppSiteList(new ArrayList<WrapperBeanObject<SiteAppSiteSP>>());
//				
			}
		}catch (Exception e) {
			LOG.debug("Error from SEMMSA002Action doShowPopupRentalHistory : "+e);
			// TODO: handle exception
		}finally{
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	
	public void doChkReqOfficer() {
		try {
			
			semmsa002Bean = getSemmsa002Bean();

			if(semmsa002Bean.isChkReqOfficerManual()){
				semmsa002Bean.getSiteAppObjParam().setReqOfficer("");
			} else {
				semmsa002Bean.getSiteAppObjParam().setReqOfficerManual("");
			}
			
			setSemmsa002Bean(semmsa002Bean);
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
	}
	
	public void doChkReqOfficerPopup() {
		try {
			
			semmsa002Bean = getSemmsa002Bean();
			if(semmsa002Bean.isChkReqOfficerManualPopup()){
				semmsa002Bean.getChgReqObjParam().setReqOfficer("");
			} else {
				semmsa002Bean.getChgReqObjParam().setReqOfficerManual("");
			}
			
			setSemmsa002Bean(semmsa002Bean);
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
	}
	
	public void doChkContractWanted() {
		try {
			
			semmsa002Bean = getSemmsa002Bean();

			semmsa002Bean.getSiteAppObjParam().setContractWantedRemark("");
			
			setSemmsa002Bean(semmsa002Bean);
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
	}
	
	public void doChkOtherType() {
		try {
			
			semmsa002Bean = getSemmsa002Bean();
			
			semmsa002Bean.getSiteAppObjParam().setIsOtherTypeDetail("");
			
			setSemmsa002Bean(semmsa002Bean);
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
	}
	
	public void doChkInsure() {
		try {
			
			semmsa002Bean = getSemmsa002Bean();

			String paramChkIns = getFacesUtils().getRequestParameter("paramChkIns") == null ? "" : (String) getFacesUtils().getRequestParameter("paramChkIns");
			
			if(paramChkIns.endsWith("Y")){
				if(semmsa002Bean.isChkInsureHave() == true){
					semmsa002Bean.setChkInsureHave(true);
					semmsa002Bean.setChkInsureNotHave(false);
					semmsa002Bean.setDisabledInsureDetail(false);
				}else{
					semmsa002Bean.setChkInsureHave(false);
					semmsa002Bean.setChkInsureNotHave(false);
					semmsa002Bean.setDisabledInsureDetail(true);
				}
				
			} else {
				if(semmsa002Bean.isChkInsureNotHave() == true){
					semmsa002Bean.setChkInsureHave(false);
					semmsa002Bean.setChkInsureNotHave(true);
					semmsa002Bean.setDisabledInsureDetail(true);
					semmsa002Bean.getSiteAppObjParam().setInsSumInsured(null);
					semmsa002Bean.getSiteAppObjParam().setInsEffectiveDt(null);
					semmsa002Bean.getSiteAppObjParam().setInsExpireDt(null);
					semmsa002Bean.getSiteAppObjParam().setInsBeneficiary("");
				}else{
					semmsa002Bean.setChkInsureHave(false);
					semmsa002Bean.setChkInsureNotHave(false);
					semmsa002Bean.setDisabledInsureDetail(true);
					semmsa002Bean.getSiteAppObjParam().setInsSumInsured(null);
					semmsa002Bean.getSiteAppObjParam().setInsEffectiveDt(null);
					semmsa002Bean.getSiteAppObjParam().setInsExpireDt(null);
					semmsa002Bean.getSiteAppObjParam().setInsBeneficiary("");
				}
//				semmsa002Bean.setChkInsureHave(false);
//				semmsa002Bean.setChkInsureNotHave(true);
//				semmsa002Bean.setDisabledInsureDetail(true);
//				semmsa002Bean.getSiteAppObjParam().setInsSumInsured(null);
//				semmsa002Bean.getSiteAppObjParam().setInsEffectiveDt(null);
//				semmsa002Bean.getSiteAppObjParam().setInsExpireDt(null);
//				semmsa002Bean.getSiteAppObjParam().setInsBeneficiary("");
			}
			
			setSemmsa002Bean(semmsa002Bean);
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
	}
	
	public void doChkDupDocNo() {
		try {
			
			semmsa002Bean = getSemmsa002Bean();
			
			semmsa002Bean.setRenderedMsgAlert(false);

			String strDocNo = semmsa002Bean.getSiteAppObjParam().getDocNo() == null ? "" : (String) semmsa002Bean.getSiteAppObjParam().getDocNo();
			LOG.info("strDocNo: " + strDocNo);
			
			ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService");
			
			List<SiteAppSP> to = null;
			if(strDocNo.equals("") || strDocNo.equals("undefined")){
				semmsa002Bean.getSiteAppObjParam().setDocNo("");
			} else {
				to = service.siteAppDao_querySPList(EQueryName.SP_MSA002_CHECK_DUPLICATE_DOC_NO.name, semmsa002Bean.getSiteAppObjParam());
			}
			
			if (to != null && !to.isEmpty()) {
				String retResult = to.get(0).getRetResult() == null ? "" : to.get(0).getRetResult().toString();
				String retResultMsg = to.get(0).getRetResultMsg() == null ? "" : to.get(0).getRetResultMsg().toString();
				String retResultMsgType = to.get(0).getRetResultMsgType() == null ? "" : to.get(0).getRetResultMsgType().toString();
				
				if(retResult.equalsIgnoreCase("Fail")){
					semmsa002Bean.setRenderedMsgAlert(true);
					semmsa002Bean.getSiteAppObjParam().setDocNo("");
					
					if(retResultMsgType.equalsIgnoreCase("ERROR")){
						FrontMessageUtils.addMessageError(retResultMsg);	// optional
					} else if(retResultMsgType.equalsIgnoreCase("WARNNING")){
						FrontMessageUtils.addMessageWarn(retResultMsg);		// optional
					} else if(retResultMsgType.equalsIgnoreCase("INFORMATION")){
						FrontMessageUtils.addMessageInfo(retResultMsg);		// optional
					} else {
						FrontMessageUtils.addMessageInfo(retResultMsg);		// optional
					}	
				}
			}
			
			setSemmsa002Bean(semmsa002Bean);
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
	}
	
	public void doChkContractNo() {
		try {
			
			semmsa002Bean = getSemmsa002Bean();
			
			semmsa002Bean.setRenderedMsgAlert(false);

			String strReLocateContractNo = semmsa002Bean.getSiteAppObjParam().getReLocateContractNo() == null ? "" : (String) semmsa002Bean.getSiteAppObjParam().getReLocateContractNo();
			LOG.info("reLocateContractNo: " + strReLocateContractNo);
			
			ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService");
			
			List<SiteAppSP> to = null;
			if(strReLocateContractNo.equals("") || strReLocateContractNo.equals("undefined")){
				semmsa002Bean.getSiteAppObjParam().setReLocateContractNo("");
			} else {
				to = service.siteAppDao_querySPList(EQueryName.SP_MSA002_CHECK_CONTRACT_NO.name, semmsa002Bean.getSiteAppObjParam());
			}
			
			if (to != null && !to.isEmpty()) {
				String retResult = to.get(0).getRetResult() == null ? "" : to.get(0).getRetResult().toString();
				String retResultMsg = to.get(0).getRetResultMsg() == null ? "" : to.get(0).getRetResultMsg().toString();
				String retResultMsgType = to.get(0).getRetResultMsgType() == null ? "" : to.get(0).getRetResultMsgType().toString();
				
				if(retResult.equalsIgnoreCase("Fail")){
					semmsa002Bean.setRenderedMsgAlert(true);
					semmsa002Bean.getSiteAppObjParam().setReLocateContractNo("");
					
					if(retResultMsgType.equalsIgnoreCase("ERROR")){
						FrontMessageUtils.addMessageError(retResultMsg);	// optional
					} else if(retResultMsgType.equalsIgnoreCase("WARNNING")){
						FrontMessageUtils.addMessageWarn(retResultMsg);		// optional
					} else if(retResultMsgType.equalsIgnoreCase("INFORMATION")){
						FrontMessageUtils.addMessageInfo(retResultMsg);		// optional
					} else {
						FrontMessageUtils.addMessageInfo(retResultMsg);		// optional
					}	
				}
			}
			
			setSemmsa002Bean(semmsa002Bean);
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
	}
	
	public void doCopyLocation() {

		try {
			
			semmsa002Bean = getSemmsa002Bean();
			
			String paramLocateFrom = getFacesUtils().getRequestParameter("paramLocateFrom") == null ? "" : (String) getFacesUtils().getRequestParameter("paramLocateFrom");
			String paramLocateTo = getFacesUtils().getRequestParameter("paramLocateTo") == null ? "" : (String) getFacesUtils().getRequestParameter("paramLocateTo");
			
			String strName = "";
			String strHouseNo = "";
			String strBuilding = "";
			String strFloor = "";
			String strRoomNo = "";
			String strStreet = "";
			String strTambon = "";
			String strAmphurId = "";
			String strProvinceId = "";
			String strPostCode = "";
			String strPhoneNo = "";
			String strMobileNo = "";
			String strFax = "";
			String strEmail = "";
			String strTitleName = "";
			String strOwnerName = "";
			
			String strLessorTitleName = "";
			String strLessorName = "";
			String strLessorTaxId = "";
			Date lessorBirthday = new Date();
			
			// COPY FROM..
			if(paramLocateFrom.equals("tab1_siteStation")){
				strHouseNo = semmsa002Bean.getSiteAppObjParam().getLocationAddressNo() == null ? "" : semmsa002Bean.getSiteAppObjParam().getLocationAddressNo().toString();
				strBuilding = semmsa002Bean.getSiteAppObjParam().getLocationBuilding() == null ? "" : semmsa002Bean.getSiteAppObjParam().getLocationBuilding().toString();
				strFloor = semmsa002Bean.getSiteAppObjParam().getLocationFloor() == null ? "" : semmsa002Bean.getSiteAppObjParam().getLocationFloor().toString();
				strRoomNo = semmsa002Bean.getSiteAppObjParam().getLocationRoomNo() == null ? "" : semmsa002Bean.getSiteAppObjParam().getLocationRoomNo().toString();
				strStreet = semmsa002Bean.getSiteAppObjParam().getLocationStreet() == null ? "" : semmsa002Bean.getSiteAppObjParam().getLocationStreet().toString();
				strTambon = semmsa002Bean.getSiteAppObjParam().getLocationTambon() == null ? "" : semmsa002Bean.getSiteAppObjParam().getLocationTambon().toString();
				strAmphurId = semmsa002Bean.getSiteAppObjParam().getLocationAmphurId() == null ? "" : semmsa002Bean.getSiteAppObjParam().getLocationAmphurId().toString();
				strProvinceId = semmsa002Bean.getSiteAppObjParam().getLocationProvinceId() == null ? "" : semmsa002Bean.getSiteAppObjParam().getLocationProvinceId().toString();
				strPostCode = semmsa002Bean.getSiteAppObjParam().getLocationPostCode() == null ? "" : semmsa002Bean.getSiteAppObjParam().getLocationPostCode().toString();
			} else if(paramLocateFrom.equals("tab2_lessor")) {
				strName = semmsa002Bean.getSiteAppObjParam().getLessorName() == null ? "" : semmsa002Bean.getSiteAppObjParam().getLessorName().toString();
				strHouseNo = semmsa002Bean.getSiteAppObjParam().getLessorHouseNo() == null ? "" : semmsa002Bean.getSiteAppObjParam().getLessorHouseNo().toString();
				strBuilding = semmsa002Bean.getSiteAppObjParam().getLessorBuilding() == null ? "" : semmsa002Bean.getSiteAppObjParam().getLessorBuilding().toString();
				strFloor = semmsa002Bean.getSiteAppObjParam().getLessorFloor() == null ? "" : semmsa002Bean.getSiteAppObjParam().getLessorFloor().toString();
				strRoomNo = semmsa002Bean.getSiteAppObjParam().getLessorRoomNo() == null ? "" : semmsa002Bean.getSiteAppObjParam().getLessorRoomNo().toString();
				strStreet = semmsa002Bean.getSiteAppObjParam().getLessorStreet() == null ? "" : semmsa002Bean.getSiteAppObjParam().getLessorStreet().toString();
				strTambon = semmsa002Bean.getSiteAppObjParam().getLessorTambon() == null ? "" : semmsa002Bean.getSiteAppObjParam().getLessorTambon().toString();
				strAmphurId = semmsa002Bean.getSiteAppObjParam().getLessorAmphurId() == null ? "" : semmsa002Bean.getSiteAppObjParam().getLessorAmphurId().toString();
				strProvinceId = semmsa002Bean.getSiteAppObjParam().getLessorProvinceId() == null ? "" : semmsa002Bean.getSiteAppObjParam().getLessorProvinceId().toString();
				strPostCode = semmsa002Bean.getSiteAppObjParam().getLessorPostCode() == null ? "" : semmsa002Bean.getSiteAppObjParam().getLessorPostCode().toString();
				strPhoneNo = semmsa002Bean.getSiteAppObjParam().getLessorTel() == null ? "" : semmsa002Bean.getSiteAppObjParam().getLessorTel().toString();
				strMobileNo = semmsa002Bean.getSiteAppObjParam().getLessorMobile() == null ? "" : semmsa002Bean.getSiteAppObjParam().getLessorMobile().toString();
				strFax = semmsa002Bean.getSiteAppObjParam().getLessorFax() == null ? "" : semmsa002Bean.getSiteAppObjParam().getLessorFax().toString();
				strEmail = semmsa002Bean.getSiteAppObjParam().getLessorEmail() == null ? "" : semmsa002Bean.getSiteAppObjParam().getLessorEmail().toString();
				
				strLessorTitleName = semmsa002Bean.getSiteAppObjParam().getLessorTitleName() == null ? "" : semmsa002Bean.getSiteAppObjParam().getLessorTitleName().toString();
				strLessorName = semmsa002Bean.getSiteAppObjParam().getLessorName() == null ? "" : semmsa002Bean.getSiteAppObjParam().getLessorName().toString();
				strLessorTaxId = semmsa002Bean.getSiteAppObjParam().getLessorTaxId() == null ? "" : semmsa002Bean.getSiteAppObjParam().getLessorTaxId().toString();
				lessorBirthday = semmsa002Bean.getSiteAppObjParam().getLessorBirthday() == null ? new Date() : semmsa002Bean.getSiteAppObjParam().getLessorBirthday();
				
				if(paramLocateTo.equals("tab7_mail")){
					strPhoneNo = (semmsa002Bean.getSiteAppObjParam().getContactTel() == "" ? "" : semmsa002Bean.getSiteAppObjParam().getContactTel().toString()+",")+
					(semmsa002Bean.getSiteAppObjParam().getContactMobile() == "" ? "" : semmsa002Bean.getSiteAppObjParam().getContactMobile().toString()+",")+
							(semmsa002Bean.getSiteAppObjParam().getContactFax() == "" ? "" : semmsa002Bean.getSiteAppObjParam().getContactFax().toString()+",");
					strPhoneNo = strPhoneNo.substring(0,strPhoneNo.lastIndexOf(","));
				}
				
			}else if (StringUtils.equals("tab1_siteLocal", paramLocateFrom)){
				strHouseNo = semmsa002Bean.getSiteAppObjParam().getLocationAddressNo();
				strBuilding = semmsa002Bean.getSiteAppObjParam().getLocationBuilding();
				strStreet = semmsa002Bean.getSiteAppObjParam().getLocationStreet();
				strFloor = semmsa002Bean.getSiteAppObjParam().getLocationFloor();
				strTambon = semmsa002Bean.getSiteAppObjParam().getLocationTambon();
				strAmphurId = semmsa002Bean.getSiteAppObjParam().getLocationAmphurId();
				strProvinceId = semmsa002Bean.getSiteAppObjParam().getLocationProvinceId();
				strPostCode = semmsa002Bean.getSiteAppObjParam().getLocationPostCode();
			}else if(StringUtils.equals("tab2_ownerName", paramLocateFrom)){
				strTitleName = semmsa002Bean.getSiteAppObjParam().getOwnerTitleName();
				strOwnerName = semmsa002Bean.getSiteAppObjParam().getOwnerName();
			}
				
			// COPY TO..
			if(paramLocateTo.equals("tab2_lessor")){
				semmsa002Bean.getSiteAppObjParam().setLessorName(strName);
				semmsa002Bean.getSiteAppObjParam().setLessorHouseNo(strHouseNo);
				semmsa002Bean.getSiteAppObjParam().setLessorBuilding(strBuilding);
				semmsa002Bean.getSiteAppObjParam().setLessorFloor(strFloor);
				semmsa002Bean.getSiteAppObjParam().setLessorRoomNo(strRoomNo);
				semmsa002Bean.getSiteAppObjParam().setLessorStreet(strStreet);
				semmsa002Bean.getSiteAppObjParam().setLessorTambon(strTambon);
				semmsa002Bean.getSiteAppObjParam().setLessorAmphurId(strAmphurId);
				semmsa002Bean.getSiteAppObjParam().setLessorProvinceId(strProvinceId);
				semmsa002Bean.getSiteAppObjParam().setLessorPostCode(strPostCode);
				
				// get amphur by province
	        	if(!strProvinceId.equals("")){
					Province province = new Province();
					province.setRowId(strProvinceId);
					semmsa002Bean.setMsa002Tab2AmphurLessorList(getAmphurByProvince(province));
					
				}else{
					semmsa002Bean.setMsa002Tab2AmphurLessorList(getEmptyDropDown());
				}
	        	semmsa002Bean.getSiteAppObjParam().setLessorAmphurId(strAmphurId);
	        	// get amphur by province
			}else if(StringUtils.equals("tab2_contact", paramLocateTo)){
//				semmsa002Bean.getSiteAppObjParam().setLessorName(strName);
				semmsa002Bean.getSiteAppObjParam().setContactHouseNo(strHouseNo);
				semmsa002Bean.getSiteAppObjParam().setContactBuilding(strBuilding);
				semmsa002Bean.getSiteAppObjParam().setContactFloor(strFloor);
				semmsa002Bean.getSiteAppObjParam().setContactRoomNo(strRoomNo);
				semmsa002Bean.getSiteAppObjParam().setContactStreet(strStreet);
				semmsa002Bean.getSiteAppObjParam().setContactTambon(strTambon);
				semmsa002Bean.getSiteAppObjParam().setContactAmphurId(strAmphurId);
				semmsa002Bean.getSiteAppObjParam().setContactProvinceId(strProvinceId);
				semmsa002Bean.getSiteAppObjParam().setContactPostCode(strPostCode);
				
				semmsa002Bean.getSiteAppObjParam().setContactTel(strPhoneNo);
				semmsa002Bean.getSiteAppObjParam().setContactMobile(strMobileNo);
				semmsa002Bean.getSiteAppObjParam().setContactFax(strFax);
				semmsa002Bean.getSiteAppObjParam().setContactEmail(strEmail);
				
				
				semmsa002Bean.getSiteAppObjParam().setContactTitleName(strLessorTitleName);
				semmsa002Bean.getSiteAppObjParam().setContactName(strLessorName);
				semmsa002Bean.getSiteAppObjParam().setContactIdCard(strLessorTaxId);
				semmsa002Bean.getSiteAppObjParam().setContactBirthday(lessorBirthday);
				
				
				// get amphur by province
	        	if(!strProvinceId.equals("")){
					Province province = new Province();
					province.setRowId(strProvinceId);
					semmsa002Bean.setMsa002Tab2AmphurContactList(getAmphurByProvince(province));
					
				}else{
					semmsa002Bean.setMsa002Tab2AmphurContactList(getEmptyDropDown());
				}
	        	semmsa002Bean.getSiteAppObjParam().setContactAmphurId(strAmphurId);
			}else if(StringUtils.equals("tab2_emContact", paramLocateTo)){
				semmsa002Bean.getSiteAppObjParam().setEmerContactHouseNo(strHouseNo);
				semmsa002Bean.getSiteAppObjParam().setEmerContactBuilding(strBuilding);
				semmsa002Bean.getSiteAppObjParam().setEmerContactFloor(strFloor);
				semmsa002Bean.getSiteAppObjParam().setEmerContactRoomNo(strRoomNo);
				semmsa002Bean.getSiteAppObjParam().setEmerContactStreet(strStreet);
				semmsa002Bean.getSiteAppObjParam().setEmerContactTambon(strTambon);
				semmsa002Bean.getSiteAppObjParam().setEmerContactAmphurId(strAmphurId);
				semmsa002Bean.getSiteAppObjParam().setEmerContactProvinceId(strProvinceId);
				semmsa002Bean.getSiteAppObjParam().setEmerContactPostCode(strPostCode);
				
				semmsa002Bean.getSiteAppObjParam().setEmerContactTel(strPhoneNo);
				semmsa002Bean.getSiteAppObjParam().setEmerContactMobile(strMobileNo);
				semmsa002Bean.getSiteAppObjParam().setEmerContactFax(strFax);
				semmsa002Bean.getSiteAppObjParam().setEmerContactEmail(strEmail);
				
				
				semmsa002Bean.getSiteAppObjParam().setEmerContactTitleName(strLessorTitleName);
				semmsa002Bean.getSiteAppObjParam().setEmerContactName(strLessorName);
				semmsa002Bean.getSiteAppObjParam().setEmerContactIdCard(strLessorTaxId);
				semmsa002Bean.getSiteAppObjParam().setEmerContactBirthday(lessorBirthday);
				
				
				// get amphur by province
	        	if(!strProvinceId.equals("")){
					Province province = new Province();
					province.setRowId(strProvinceId);
					semmsa002Bean.setMsa002Tab2AmphurContactList(getAmphurByProvince(province));
					
				}else{
					semmsa002Bean.setMsa002Tab2AmphurContactList(getEmptyDropDown());
				}
	        	semmsa002Bean.getSiteAppObjParam().setEmerContactAmphurId(strAmphurId);
			}else if(paramLocateTo.equals("tab7_mail")){
				semmsa002Bean.getSiteAppTab7ObjParam().setMailName(strName);
				semmsa002Bean.getSiteAppTab7ObjParam().setMailHouseNo(strHouseNo);
				semmsa002Bean.getSiteAppTab7ObjParam().setMailBuilding(strBuilding);
				semmsa002Bean.getSiteAppTab7ObjParam().setMailFloor(strFloor);
				semmsa002Bean.getSiteAppTab7ObjParam().setMailRoomNo(strRoomNo);
				semmsa002Bean.getSiteAppTab7ObjParam().setMailStreet(strStreet);
				semmsa002Bean.getSiteAppTab7ObjParam().setMailTambon(strTambon);
				
				semmsa002Bean.getSiteAppTab7ObjParam().setMailProvinceId(strProvinceId);
				semmsa002Bean.getSiteAppTab7ObjParam().setMailPostCode(strPostCode);
				semmsa002Bean.getSiteAppTab7ObjParam().setPhoneNo(strPhoneNo);
				
				// get amphur by province
	        	if(!strProvinceId.equals("")){
					Province province = new Province();
					province.setRowId(strProvinceId);
					semmsa002Bean.setMsa002Tab7AmphurList(getAmphurByProvince(province));
					
				}else{
					semmsa002Bean.setMsa002Tab7AmphurList(getEmptyDropDown());
				}
	        	semmsa002Bean.getSiteAppTab7ObjParam().setMailAmphurId(strAmphurId);
	        	// get amphur by province
			}else if (StringUtils.equals("tab1_reqDocLocal", paramLocateTo)){
				semmsa002Bean.getSiteAppObjParam().setDocLocAddrNo(strHouseNo);
				semmsa002Bean.getSiteAppObjParam().setDocLocBuilding(strBuilding);
				semmsa002Bean.getSiteAppObjParam().setDocLocStreet(strStreet);
				semmsa002Bean.getSiteAppObjParam().setDocLocFloor(strFloor);
				semmsa002Bean.getSiteAppObjParam().setDocLocTambon(strTambon);
				semmsa002Bean.getSiteAppObjParam().setDocLocAmphurId(strAmphurId);
				semmsa002Bean.getSiteAppObjParam().setDocLocProvinceId(strProvinceId);
				semmsa002Bean.getSiteAppObjParam().setDocLocPostCode(strPostCode);
				
				// get amphur by province
	        	if(!strProvinceId.equals("")){
					Province province = new Province();
					province.setRowId(strProvinceId);
					
					semmsa002Bean.setAmphurReqDocList(getAmphurByProvince(province));
					
				}else{
					semmsa002Bean.setAmphurReqDocList(getEmptyDropDown());
				}
	        	semmsa002Bean.getSiteAppObjParam().setDocLocAmphurId(strAmphurId);
			}else if(StringUtils.equals("tab2_lessorName", paramLocateTo)){
				semmsa002Bean.getSiteAppObjParam().setLessorTitleName(strTitleName);
				semmsa002Bean.getSiteAppObjParam().setLessorName(strOwnerName);
			}
			
			setSemmsa002Bean(semmsa002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA002Action");
			
			semmsa002Bean.setRenderedMsgAlert(true);
			setSemmsa002Bean(semmsa002Bean);
		} finally {
			
		}
	}
	
	public void tab1AddSite_doSearchSiteLocation() {
		try {
			
			semmsa002Bean = getSemmsa002Bean();
			
			String strSiteAppId = semmsa002Bean.getSiteAppObjParam().getSiteAppId() == null ? "" : (String) semmsa002Bean.getSiteAppObjParam().getSiteAppId();

			List<SiteAppSiteSP> siteLocationList = new ArrayList<SiteAppSiteSP>();
	        ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
			
	        semmsa002Bean.setSiteLocationList(new ArrayList<WrapperBeanObject<SiteAppSiteSP>>());

			semmsa002Bean.getSiteLocationObjParam().setSiteAppId(strSiteAppId);
			
			siteLocationList = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA002_POPUP_ADD_SITE_SRCH.name, semmsa002Bean.getSiteLocationObjParam());
			LOG.info("::: SEMMSA002Action :: SP_MSA002_POPUP_ADD_SITE_SRCH  size :"+siteLocationList.size());
			
        	if(siteLocationList != null && !siteLocationList.isEmpty()){
				for(int i = 0; i < siteLocationList.size(); i++){
					SiteAppSiteSP ret = (SiteAppSiteSP) siteLocationList.get(i);
					
					WrapperBeanObject<SiteAppSiteSP> tmpWrapperBean = new WrapperBeanObject<SiteAppSiteSP>();
					
					tmpWrapperBean.setDataObj(ret);
					tmpWrapperBean.setMessage("");

					semmsa002Bean.getSiteLocationList().add(tmpWrapperBean);
				}
				
				semmsa002Bean.setRenderedMsgAlert(false);
        	} else {
        		addMessageWarn("M0004");	// data not found
        		semmsa002Bean.setRenderedMsgAlert(true);
        	}
			
			setSemmsa002Bean(semmsa002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA002Action");
			
			semmsa002Bean.setRenderedMsgAlert(true);
			setSemmsa002Bean(semmsa002Bean);
		} finally {
		}
	}
	
	public void tab1AddSite_doClearSiteLocation() {
		try {
			
			semmsa002Bean = getSemmsa002Bean();
			
			semmsa002Bean.setSiteLocationObjParam(new SiteAppSiteSP());
	        semmsa002Bean.setSiteLocationList(new ArrayList<WrapperBeanObject<SiteAppSiteSP>>());
			
			setSemmsa002Bean(semmsa002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA002Action");
			
			semmsa002Bean.setRenderedMsgAlert(true);
			setSemmsa002Bean(semmsa002Bean);
		} finally {
		}
	}
	
	public void tab4AddContractElUse_doSearchContractElUse() {
		try {
			
			semmsa002Bean = getSemmsa002Bean();
			
			semmsa002Bean.setRenderedMsgAlert(false);
			
			String strCompany = semmsa002Bean.getContractElUseObjParam().getCompany() == null ? "" : (String) semmsa002Bean.getContractElUseObjParam().getCompany();
			LOG.info("strCompany: " + strCompany);
			
			if(strCompany.equals("") && semmsa002Bean.getContractElUseObjParam().getContractNo().equalsIgnoreCase("")){
				semmsa002Bean.setContractElUseList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				semmsa002Bean.setMsgReqcompanyPopup("T");
				//FrontMessageUtils.addMessageWarn("กรุณาระบุ บริษัท");	// optional
				//semmsa002Bean.setRenderedMsgAlert(true);
			} else {
				List<SiteAppSP> cntrctElUseList = new ArrayList<SiteAppSP>();
		        ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		        semmsa002Bean.setMsgReqcompanyPopup(null);
		        try{
		        	
		        
		        semmsa002Bean.setContractElUseList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				
				cntrctElUseList = service.siteAppDao_querySPList(EQueryName.SP_MSA002_POPUP_CONTRACT_EL_USE.name, semmsa002Bean.getContractElUseObjParam());				
				if(cntrctElUseList != null && !cntrctElUseList.isEmpty()){
					for(int i = 0; i <= cntrctElUseList.size(); i++){
						SiteAppSP ret = (SiteAppSP) cntrctElUseList.get(i);
						
						WrapperBeanObject<SiteAppSP> tmpWrapperBean = new WrapperBeanObject<SiteAppSP>();
						
						if(ret.getEffectiveDt() != null){
							ret.setEffectiveDtStr(this.convertYearENtoTHStr(ret.getEffectiveDt()));
						}
						
						if(ret.getExpireDt() != null){
							ret.setExpireDtStr(this.convertYearENtoTHStr(ret.getExpireDt()));
						}
						
						// check status terminate of contract.
						if(ret.getContractStatusName().startsWith("Terminate")){
							ret.setTerminateOfcontractFlag("T");
							//popupSiteContractBean.getContractList().get(i).setTerminateOfcontractFlag("T");
							LOG.debug(ret.getContractNo()+" "+ret.getContractStatusName());
							
						}else{
							//popupSiteContractBean.getContractList().get(i).setTerminateOfcontractFlag("F");
							ret.setTerminateOfcontractFlag("F");
						}
						
						
						tmpWrapperBean.setDataObj(ret);
						tmpWrapperBean.setMessage("");
	
						semmsa002Bean.getContractElUseList().add(tmpWrapperBean);
						
					}
					
	        	}else{
	        		System.out.println("---------------");
	        	}
		        }catch (Exception e) {
					// TODO: handle exception
				}
	        	//semmsa002Bean.setRenderedMsgAlert(false);
			}
			
			setSemmsa002Bean(semmsa002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA002Action");
			
			semmsa002Bean.setRenderedMsgAlert(true);
			setSemmsa002Bean(semmsa002Bean);
		} finally {
		}
	}
	
	public void tab4AddContractElUse_doClearContractElUse() {
		try {
			
			semmsa002Bean = getSemmsa002Bean();
			
			semmsa002Bean.setContractElUseObjParam(new SiteAppSP());
	        semmsa002Bean.setContractElUseList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
	        semmsa002Bean.setMsgReqcompanyPopup(null);
			setSemmsa002Bean(semmsa002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA002Action");
			
			semmsa002Bean.setRenderedMsgAlert(true);
			
			setSemmsa002Bean(semmsa002Bean);
		} finally {
		}
	}
	
	public void tab4AddContractElUse_doAddContractElUse() {
		try {
			
			semmsa002Bean = getSemmsa002Bean();
			
			String paramContractNo = getFacesUtils().getRequestParameter("paramContractNo") == null ? "" : (String) getFacesUtils().getRequestParameter("paramContractNo");
			
			semmsa002Bean.getSiteAppELObjParam().setElUseOthSiteContractNo(paramContractNo);
			
			setSemmsa002Bean(semmsa002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA002Action");
			
			semmsa002Bean.setRenderedMsgAlert(true);
			setSemmsa002Bean(semmsa002Bean);
		} finally {
			
		}
	}
	
	public void msa002tab4_doChkContractElUse() {
		try {
			
			semmsa002Bean = getSemmsa002Bean();
			
			String myRetResult = "";
			String myRetMsg = "";
			String myRetContractNo = "";
			
			//String strElUseOthSiteContractNo = semmsa002Bean.getSiteAppObjParam().getElUseOthSiteContractNo() == null ? "" : (String) semmsa002Bean.getSiteAppObjParam().getElUseOthSiteContractNo();
			
			List<SiteAppSP> resultList = new ArrayList<SiteAppSP>();
	        ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 

	        resultList = service.siteAppDao_querySPList(EQueryName.SP_MSA002_CHECK_CONTRACT_EL_USE.name, semmsa002Bean.getSiteAppObjParam());
        	
	        if(resultList != null && !resultList.isEmpty()){
	        	myRetResult = resultList.get(0).getRetResult() == null ? "" : resultList.get(0).getRetResult().toString();
	        	myRetMsg = resultList.get(0).getRetResultMsg() == null ? "" : resultList.get(0).getRetResultMsg().toString();
	        	myRetContractNo = resultList.get(0).getContractNo() == null ? "" : resultList.get(0).getContractNo().toString();
				
	        	if(myRetResult.equalsIgnoreCase("FOUND")){
	        		//semmsa002Bean.getSiteAppObjParam().setElUseOthSiteContractNo(myRetContractNo);
	        	} else {
	        		if(myRetResult.equalsIgnoreCase("NOT FOUND")){
	        			semmsa002Bean.getSiteAppELObjParam().setElUseOthSiteContractNo(myRetContractNo);
	        			
	        			FrontMessageUtils.addMessageError(myRetMsg);
		        		semmsa002Bean.setRenderedMsgAlert(true);
	        		} else {
	        			semmsa002Bean.setRenderedMsgAlert(false);
	        		}
	        	}
        	}
			
			setSemmsa002Bean(semmsa002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA002Action");
			
			semmsa002Bean.setRenderedMsgAlert(true);
			setSemmsa002Bean(semmsa002Bean);
		} finally {
			
		}
	}
	
	public void countElType() {

		
		int count = 0;
		
		if((semmsa002Bean.chkMultiElectricTypeFlag ==false)){
			int temp = 2;
			for (int i = 0; i == 0; i++) {
				if (semmsa002Bean.chkElUseNewMeter == true) {
					count = count + 1;
				}
				if (semmsa002Bean.chkElUseOwner == true) {
					count = count + 1;
				}
				if (semmsa002Bean.chkElUseOthSite == true) {
					count = count + 1;
				}
				if (semmsa002Bean.chkElUseOth == true) {
					count = count + 1;
				}

			}
			if(count >= temp){
			semmsa002Bean.chkMultiElectricTypeFlag = true;
			}else{
				semmsa002Bean.chkMultiElectricTypeFlag = false;
			}
		}else if(semmsa002Bean.chkMultiElectricTypeFlag ==true){
			int temp = 2;
			for (int i = 0; i == 0; i++) {
				if (semmsa002Bean.chkElUseNewMeter == true) {
					count = count + 1;
				}
				if (semmsa002Bean.chkElUseOwner == true) {
					count = count + 1;
				}
				if (semmsa002Bean.chkElUseOthSite == true) {
					count = count + 1;
				}if (semmsa002Bean.chkElUseOth == true) {
					count = count + 1;
				}

			}
			if(count==2){
				semmsa002Bean.setCount(2);
			}
			
			if(count <= temp){
				if(semmsa002Bean.getCount()==2){
					semmsa002Bean.chkMultiElectricTypeFlag = true;
					semmsa002Bean.setCount(0);
				}else if(count==1){
					semmsa002Bean.chkMultiElectricTypeFlag = false;
					semmsa002Bean.setCount(0);
				}else{
					semmsa002Bean.chkMultiElectricTypeFlag = false;
				}
			}
			
		}		
		
	}
	
	
	public void msa002tab4_doChkElctType() {
		
		try {
			
			semmsa002Bean = getSemmsa002Bean();
//			System.out.println("semmsa002Bean.siteAppObjParam.elPayOnPackageAmt : "+semmsa002Bean.getSiteAppObjParam().getElPayOnPackageAmt());
			//semmsa002Bean.setDisabledElctTypeDetail(true);
					
			// -- 
			String paramChkElType = getFacesUtils().getRequestParameter("paramChkElType") == null ? "" : (String) getFacesUtils().getRequestParameter("paramChkElType");
			String elType = getFacesUtils().getRequestParameter("elType") == null ? "" : (String) getFacesUtils().getRequestParameter("elType");
			semmsa002Bean.getSiteAppELObjParam().setElEffectiveDt(null);
			semmsa002Bean.getSiteAppELObjParam().setElCondType("");
			semmsa002Bean.getSiteAppELObjParam().setElCondSubType("");
			semmsa002Bean.getSiteAppELObjParam().setElRemark("");
			
		
			
			if(paramChkElType.equals("NEW")){
				semmsa002Bean.setChkElUseOldMeter(false);
				//added by NEW 20160401 check if check MultiElectric checkbox
				if(!semmsa002Bean.isChkMultiElectricTypeFlag()){
					/*semmsa002Bean.setChkElUseOldMeter(false);
					semmsa002Bean.setChkElUseNewMeter(false);
					semmsa002Bean.setChkElUseOwner(false);
					semmsa002Bean.setChkNoExpenses(false);
					semmsa002Bean.setChkElUseOthSite(false);
					semmsa002Bean.setChkElUseOth(false);*/
					semmsa002Bean.setDisabledElctTypeDetail(true);
					semmsa002Bean.setDisabledElctPackageTypeDetail(true);
					semmsa002Bean.setDisabledElctUnitTypeDetail(true);
					semmsa002Bean.getSiteAppELObjParam().setElPayOnPackageAmt(BigDecimal.valueOf(0));
					semmsa002Bean.getSiteAppELObjParam().setElPackagePeriodType("");
					semmsa002Bean.getSiteAppELObjParam().setElUnitPrice(BigDecimal.valueOf(0));
					semmsa002Bean.getSiteAppELObjParam().setElVatType("");
				}
				if(semmsa002Bean.isChkElUseOwner()){
					semmsa002Bean.setDisabledElctTypeDetail(false);
					
				} else {
					semmsa002Bean.setChkElPayOnPackage(false);
//					semmsa002Bean.getSiteAppObjParam().setElPayOnPackageAmt(new BigDecimal(0));
//					semmsa002Bean.getSiteAppObjParam().setElPackagePeriodType("");
					semmsa002Bean.setChkElOwnerType(false);
//					semmsa002Bean.getSiteAppObjParam().setElUnitPrice(new BigDecimal(0));
//					semmsa002Bean.getSiteAppObjParam().setElVatType("");
				}
				
				this.doInitAddSiteAppELCond();
			} else if(paramChkElType.equals("OWNER")){
				//semmsa002Bean.setChkElUseOwner(true);
			

				if(semmsa002Bean.isChkElUseOwner()){
					semmsa002Bean.setDisabledElctTypeDetail(false);
//					semmsa002Bean.setChkNoExpenses(false);
					if(!elType.equals("")){
						semmsa002Bean.setChkNoExpenses(false);
						if(elType.equals("T")){
							semmsa002Bean.getSiteAppObjParam().setElUnitPrice(new BigDecimal(0));
							if(semmsa002Bean.isChkElPayOnPackage()){
								semmsa002Bean.setChkElOwnerType(false);
								semmsa002Bean.setDisabledElctPackageTypeDetail(false);
								semmsa002Bean.setDisabledElctUnitTypeDetail(true);
								semmsa002Bean.getSiteAppELObjParam().setElUnitPrice(BigDecimal.valueOf(0));
							}else{
//								semmsa002Bean.setChkElPayOnPackage(false);
								semmsa002Bean.setDisabledElctPackageTypeDetail(true);
								semmsa002Bean.setDisabledElctUnitTypeDetail(false);
								semmsa002Bean.getSiteAppELObjParam().setElPayOnPackageAmt(BigDecimal.valueOf(0));
								semmsa002Bean.getSiteAppELObjParam().setElPackagePeriodType("");
							}
//							semmsa002Bean.setChkElPayOnPackage(true);
//							semmsa002Bean.setChkElOwnerType(false);
						}else{
							semmsa002Bean.getSiteAppELObjParam().setElPayOnPackageAmt(new BigDecimal(0));
							semmsa002Bean.getSiteAppELObjParam().setElPackagePeriodType("");
							if(semmsa002Bean.isChkElOwnerType()){
								semmsa002Bean.setChkElPayOnPackage(false);
								semmsa002Bean.setDisabledElctPackageTypeDetail(true);
								semmsa002Bean.setDisabledElctUnitTypeDetail(false);
								semmsa002Bean.getSiteAppELObjParam().setElPayOnPackageAmt(BigDecimal.valueOf(0));
								semmsa002Bean.getSiteAppELObjParam().setElPackagePeriodType("");
							}else{
//								semmsa002Bean.setChkElOwnerType(false);
//								semmsa002Bean.setDisabledElctPackageTypeDetail(false);
								semmsa002Bean.setDisabledElctUnitTypeDetail(true);
								semmsa002Bean.getSiteAppELObjParam().setElUnitPrice(BigDecimal.valueOf(0));
							}
//							semmsa002Bean.setChkElPayOnPackage(false);
//							semmsa002Bean.setChkElOwnerType(true);
						}
					}
					
					
										
				} else {
					semmsa002Bean.setDisabledElctTypeDetail(true);
					semmsa002Bean.setChkElPayOnPackage(false);
					semmsa002Bean.setChkElOwnerType(false);
					semmsa002Bean.setChkNoExpenses(false);
					semmsa002Bean.getSiteAppELObjParam().setElUnitPrice(BigDecimal.valueOf(0));
					semmsa002Bean.getSiteAppELObjParam().setElPayOnPackageAmt(BigDecimal.valueOf(0));
					semmsa002Bean.getSiteAppELObjParam().setElPackagePeriodType("");
					semmsa002Bean.setDisabledElctPackageTypeDetail(true);
					semmsa002Bean.setDisabledElctUnitTypeDetail(true);
				}
			}  else if(paramChkElType.equals("OLD")){
				//added by NEW 20160401 check if check MultiElectric checkbox
				if(!semmsa002Bean.isChkMultiElectricTypeFlag()){
//					semmsa002Bean.setChkElUseOldMeter(false);
					semmsa002Bean.setChkElUseNewMeter(false);
					semmsa002Bean.setChkElUseOwner(false);
					semmsa002Bean.setChkNoExpenses(false);
					semmsa002Bean.setChkElUseOthSite(false);
					semmsa002Bean.setChkElUseOth(false);
					semmsa002Bean.setDisabledElctTypeDetail(true);
					semmsa002Bean.setDisabledElctPackageTypeDetail(true);
					semmsa002Bean.setDisabledElctUnitTypeDetail(true);
					semmsa002Bean.getSiteAppELObjParam().setElPayOnPackageAmt(BigDecimal.valueOf(0));
					semmsa002Bean.getSiteAppELObjParam().setElPackagePeriodType("");
					semmsa002Bean.getSiteAppELObjParam().setElUnitPrice(BigDecimal.valueOf(0));
					semmsa002Bean.setChkElPayOnPackage(false);
					semmsa002Bean.setChkElOwnerType(false);
					semmsa002Bean.getSiteAppELObjParam().setElVatType("");
				}
				semmsa002Bean.setChkElUseNewMeter(false);
				
				this.doInitAddSiteAppELCond();
//				semmsa002Bean.setChkElUseOwner(false);
				
//				semmsa002Bean.setChkElPayOnPackage(false);
//				semmsa002Bean.getSiteAppObjParam().setElPayOnPackageAmt(new BigDecimal(0));
//				semmsa002Bean.getSiteAppObjParam().setElPackagePeriodType("");
//				semmsa002Bean.setChkElOwnerType(false);
//				semmsa002Bean.setChkNoExpenses(false);
//				semmsa002Bean.getSiteAppObjParam().setElUnitPrice(new BigDecimal(0));
//				semmsa002Bean.getSiteAppObjParam().setElVatType("");
			}else if(paramChkElType.equals("OTHER")){
//				semmsa002Bean.getSiteAppObjParam().setElUseOthSiteContractNo("");
				//added by NEW 20160401 check if check MultiElectric checkbox
				if(!semmsa002Bean.isChkMultiElectricTypeFlag()){
					/*semmsa002Bean.setChkElUseOldMeter(false);
					semmsa002Bean.setChkElUseNewMeter(false);
					semmsa002Bean.setChkElUseOwner(false);
					semmsa002Bean.setChkNoExpenses(false);*/
					semmsa002Bean.setDisabledElctTypeDetail(true);
					semmsa002Bean.setDisabledElctPackageTypeDetail(true);
					semmsa002Bean.setDisabledElctUnitTypeDetail(true);
//					semmsa002Bean.setChkElUseOthSite(false);
					semmsa002Bean.getSiteAppELObjParam().setElPayOnPackageAmt(BigDecimal.valueOf(0));
					semmsa002Bean.getSiteAppELObjParam().setElPackagePeriodType("");
					semmsa002Bean.getSiteAppELObjParam().setElUnitPrice(BigDecimal.valueOf(0));
					semmsa002Bean.setChkElPayOnPackage(false);
					semmsa002Bean.setChkElOwnerType(false);
					semmsa002Bean.getSiteAppELObjParam().setElVatType("");
				}
			
				
			}else if(paramChkElType.equals("OTH")){
				semmsa002Bean.setChkElUseOldMeter(false);
				
				//added by NEW 20160401 check if check MultiElectric checkbox
				if(!semmsa002Bean.isChkMultiElectricTypeFlag()){
					/*semmsa002Bean.setChkElUseOldMeter(false);
					semmsa002Bean.setChkElUseNewMeter(false);
					semmsa002Bean.setChkElUseOwner(false);
					semmsa002Bean.setChkNoExpenses(false);
					semmsa002Bean.setChkElUseOthSite(false);*/
					semmsa002Bean.setDisabledElctTypeDetail(true);
					semmsa002Bean.setDisabledElctPackageTypeDetail(true);
					semmsa002Bean.setDisabledElctUnitTypeDetail(true);
					semmsa002Bean.getSiteAppELObjParam().setElPayOnPackageAmt(BigDecimal.valueOf(0));
					semmsa002Bean.getSiteAppELObjParam().setElPackagePeriodType("");
					semmsa002Bean.getSiteAppELObjParam().setElUnitPrice(BigDecimal.valueOf(0));
					semmsa002Bean.getSiteAppELObjParam().setElVatType("");
				}
				
				semmsa002Bean.getSiteAppObjParam().setElRemark("");	
				
			}
			
		
			
			countElType();
			doCheckElecticTypeChanged();
	
			setSemmsa002Bean(semmsa002Bean);
//			System.out.println("semmsa002Bean.siteAppObjParam.elPayOnPackageAmt : "+semmsa002Bean.getSiteAppObjParam().getElPayOnPackageAmt());
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
	}
	
	public void msa002_calAmtAdd(){
		semmsa002Bean = getSemmsa002Bean();
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService");
		try{
			Float numRentAmtOld = semmsa002Bean.getSiteAppRentObjParam().getRentAmtOld() == null ? 0f : semmsa002Bean.getSiteAppRentObjParam().getRentAmtOld().floatValue();
			Float numRentAmt = semmsa002Bean.getSiteAppRentObjParam().getRentAmt() == null ? 0f : semmsa002Bean.getSiteAppRentObjParam().getRentAmt().floatValue();
			Float numRentAmtAddPerc = semmsa002Bean.getSiteAppRentObjParam().getRentAmtAddPerc() == null ? 0f : semmsa002Bean.getSiteAppRentObjParam().getRentAmtAddPerc().floatValue();
			
//			Float numRentServAmtOld = semmsa002Bean.getSiteAppObjParam().getRentServAmtOld() == null ? 0f : semmsa002Bean.getSiteAppObjParam().getRentServAmtOld().floatValue();
//			Float numRentServAmtAdd = semmsa002Bean.getSiteAppObjParam().getRentServAmtAdd() == null ? 0f : semmsa002Bean.getSiteAppObjParam().getRentServAmtAdd().floatValue();
//			Float numRentServAmtAddPerc = semmsa002Bean.getSiteAppObjParam().getRentServAmtAddPerc() == null ? 0f : semmsa002Bean.getSiteAppObjParam().getRentServAmtAddPerc().floatValue();
//			
			String flagType = getFacesUtils().getRequestParameter("flagType") == null ? "" : (String) getFacesUtils().getRequestParameter("flagType");
			
			Float retValC = 0f;
			Float retValD = 0f;
//			Float retValE = 0f;
			List<SiteAppSP> to2 = new ArrayList<SiteAppSP>();
			
//			if(numRentAmt != null ){
//				retValC = numRentAmt-numRentAmtOld;
//				if(retValC>0 && numRentAmtOld > 0)retValD = retValC*100/numRentAmtOld;
//			}
			
//			semmsa002Bean.getSiteAppRentObjParam().setRentAmtAdd(new BigDecimal(retValC));
//			
//			if(retValD != null && retValD > 0){
//				semmsa002Bean.getSiteAppRentObjParam().setRentAmtAddPerc(new BigDecimal(retValD));
//			}else{
//				semmsa002Bean.getSiteAppRentObjParam().setRentAmtAddPerc(null);
//			}
			
			//cal
			SiteAppSP siteAppSp = semmsa002Bean.getSiteAppRentObjParam();
			to2 = service.siteAppDao_querySPList(EQueryName.SP_MSA002_CAL_RENT_AMT.name, siteAppSp);
				if(to2 != null){
					SiteAppSP siteAppTemp = new SiteAppSP();
					siteAppTemp = to2.get(0);
					System.out.println("getRentAmtAdd = "+siteAppTemp.getRentAmtAdd());
					System.out.println("getRentAmtAddPerc = "+siteAppTemp.getRentAmtAddPerc());
					System.out.println("getRentAmt = "+siteAppTemp.getRentAmt());
					System.out.println("getRentPeriodType = "+siteAppTemp.getRentPeriodType());
					if(siteAppTemp.getRentAmtAdd()!=null){
						semmsa002Bean.getSiteAppRentObjParam().setRentAmtAdd(siteAppTemp.getRentAmtAdd());
					}
						
					if(siteAppTemp.getRentAmtAddPerc()!=null){
						semmsa002Bean.getSiteAppRentObjParam().setRentAmtAddPerc(siteAppTemp.getRentAmtAddPerc());
					}
						
					if(siteAppTemp.getRentAmt()!=null){
						semmsa002Bean.getSiteAppRentObjParam().setRentAmt(siteAppTemp.getRentAmt());
					}
						
					if(siteAppTemp.getRentPeriodType()!=null){
						semmsa002Bean.getSiteAppRentObjParam().setRentPeriodType(siteAppTemp.getRentPeriodType());
					}
				}
			
		}catch (Exception e) {
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action msa002_calAmtAdd :"+e);
			// TODO: handle exception
		}finally{
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	
	public void msa002_calAmtRate() {
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService");
		try {
			
			semmsa002Bean = getSemmsa002Bean();
			LOG.debug("test msa002_calAmtRate");
			String paramCalAmt = getFacesUtils().getRequestParameter("paramCalAmt") == null ? "" : (String) getFacesUtils().getRequestParameter("paramCalAmt");
			
			
			Float numRentAmtOld = semmsa002Bean.getSiteAppRentObjParam().getRentAmtOld() == null ? 0f : semmsa002Bean.getSiteAppRentObjParam().getRentAmtOld().floatValue();
			Float numRentAmtAdd = semmsa002Bean.getSiteAppRentObjParam().getRentAmtAdd() == null ? 0f : semmsa002Bean.getSiteAppRentObjParam().getRentAmtAdd().floatValue();
			Float numRentAmtAddPerc = semmsa002Bean.getSiteAppRentObjParam().getRentAmtAddPerc() == null ? 0f : semmsa002Bean.getSiteAppRentObjParam().getRentAmtAddPerc().floatValue();
			
//			Float numRentServAmtOld = semmsa002Bean.getSiteAppObjParam().getRentServAmtOld() == null ? 0f : semmsa002Bean.getSiteAppObjParam().getRentServAmtOld().floatValue();
//			Float numRentServAmtAdd = semmsa002Bean.getSiteAppObjParam().getRentServAmtAdd() == null ? 0f : semmsa002Bean.getSiteAppObjParam().getRentServAmtAdd().floatValue();
//			Float numRentServAmtAddPerc = semmsa002Bean.getSiteAppObjParam().getRentServAmtAddPerc() == null ? 0f : semmsa002Bean.getSiteAppObjParam().getRentServAmtAddPerc().floatValue();
//			
			String flagType = getFacesUtils().getRequestParameter("flagType") == null ? "" : (String) getFacesUtils().getRequestParameter("flagType");
			
			Float retValC = 0f;
			Float retValD = 0f;
			Float retValE = 0f;
			List<SiteAppSP> to2 = null;
			
			if(paramCalAmt.equals("rentC")){
				LOG.debug("test rentC strat");
				if(numRentAmtOld == 0){
//					retValD = (numRentAmtAdd / 100) * 100;
					retValD = null;
				}else{
					retValD = (numRentAmtAdd / numRentAmtOld) * 100;
				}
				//retValD = numRentAmtOld == 0 ? new Float(100) : (numRentAmtAdd / numRentAmtOld) * 100;
				retValE = numRentAmtOld + numRentAmtAdd;
				LOG.debug("test numRentAmtOld :"+numRentAmtOld);
				LOG.debug("test numRentAmtAdd :"+numRentAmtAdd);
				LOG.debug("test numRentAmtAddPerc :"+numRentAmtAddPerc);
//				LOG.debug("test numRentServAmtOld :"+numRentServAmtOld);
//				LOG.debug("test numRentServAmtAdd :"+numRentServAmtAdd);
//				LOG.debug("test numRentServAmtAddPerc :"+numRentServAmtAddPerc);
				LOG.debug("test retValD :"+retValD);
				LOG.debug("test retValE :"+retValE);
				if(retValD != null){
					semmsa002Bean.getSiteAppRentObjParam().setRentAmtAddPerc(new BigDecimal(retValD));
				}else{
					semmsa002Bean.getSiteAppRentObjParam().setRentAmtAddPerc(null);
				}
				
				semmsa002Bean.getSiteAppRentObjParam().setRentAmt(new BigDecimal(retValE));
				LOG.debug("test rentC end");
			} else if(paramCalAmt.equals("rentD")){
				if(numRentAmtOld == 0){
					retValC = (100 * numRentAmtAddPerc) / 100;
				}else{
					retValC = (numRentAmtOld * numRentAmtAddPerc) / 100;
				}
				//retValC = numRentAmtOld == 0 ? new Float(100) : (numRentAmtOld * numRentAmtAddPerc) / 100;
				retValE = numRentAmtOld + retValC;
				semmsa002Bean.getSiteAppRentObjParam().setRentAmtAdd(new BigDecimal(retValC));
				semmsa002Bean.getSiteAppRentObjParam().setRentAmt(new BigDecimal(retValE));
				
			} else if(paramCalAmt.equals("serviceF")){
				
			}else if(paramCalAmt.equals("serviceC")){
//				if(numRentServAmtOld == 0){
//					retValD = (numRentServAmtAdd / 100) * 100;
//				}else{
//					retValD = (numRentServAmtAdd / numRentServAmtOld) * 100;
//				}
//				retValD = numRentServAmtOld == 0 ? new Float(100) : (numRentServAmtAdd / numRentServAmtOld) * 100;
//				retValE = numRentServAmtOld + numRentServAmtAdd;
				semmsa002Bean.getSiteAppObjParam().setRentServAmtAddPerc(new BigDecimal(retValD));
				semmsa002Bean.getSiteAppObjParam().setRentServiceAmt(new BigDecimal(retValE));
			} else if(paramCalAmt.equals("serviceD")){
//				if(numRentServAmtOld == 0){
//					retValC = (100 * numRentServAmtAddPerc) / 100;
//				}else{
//					retValC = (numRentServAmtOld * numRentServAmtAddPerc) / 100;
//				}
//				retValC = numRentServAmtOld == 0 ? new Float(100) : (numRentServAmtOld * numRentServAmtAddPerc) / 100;
//				retValE = numRentServAmtOld + retValC;
				semmsa002Bean.getSiteAppObjParam().setRentServAmtAdd(new BigDecimal(retValC));
				semmsa002Bean.getSiteAppObjParam().setRentServiceAmt(new BigDecimal(retValE));
			}
			
			//cal
			SiteAppSP siteAppSp = semmsa002Bean.getSiteAppObjParam();
			
			if(flagType != null){
				if("R".equals(flagType)){
					to2 = service.siteAppDao_querySPList(EQueryName.SP_MSA002_CAL_RENT_AMT.name, siteAppSp);
					if(to2 != null){
						SiteAppSP siteAppTemp = new SiteAppSP();
						siteAppTemp = to2.get(0);
//						System.out.println("getRentAmtAdd = "+siteAppTemp.getRentAmtAdd());
//						System.out.println("getRentAmtAddPerc = "+siteAppTemp.getRentAmtAddPerc());
//						System.out.println("getRentAmt = "+siteAppTemp.getRentAmt());
//						System.out.println("getRentPeriodType = "+siteAppTemp.getRentPeriodType());
						if(siteAppTemp.getRentAmtAdd()!=null){
							semmsa002Bean.getSiteAppObjParam().setRentAmtAdd(siteAppTemp.getRentAmtAdd());
						}
						
						if(siteAppTemp.getRentAmtAddPerc()!=null){
							semmsa002Bean.getSiteAppObjParam().setRentAmtAddPerc(siteAppTemp.getRentAmtAddPerc());
						}
						
						if(siteAppTemp.getRentAmt()!=null){
							semmsa002Bean.getSiteAppObjParam().setRentAmt(siteAppTemp.getRentAmt());
						}
						
						if(siteAppTemp.getRentPeriodType()!=null){
							semmsa002Bean.getSiteAppObjParam().setRentPeriodType(siteAppTemp.getRentPeriodType());
						}
					}
				}else if("S".equals(flagType)){
					to2 = service.siteAppDao_querySPList(EQueryName.SP_MSA002_CAL_SERVICE_AMT.name, siteAppSp);
					if(to2 != null){
						SiteAppSP siteAppTemp = new SiteAppSP();
						siteAppTemp = to2.get(0);
//						System.out.println("getRentSerAmtAdd = "+siteAppTemp.getRentAmtAdd());
//						System.out.println("getRentAmtSerAddPerc = "+siteAppTemp.getRentAmtAddPerc());
//						System.out.println("getRentSerAmt = "+siteAppTemp.getRentAmt());
//						System.out.println("getRentSerPeriodType = "+siteAppTemp.getRentPeriodType());
						if(siteAppTemp.getRentAmtAdd()!=null){
							semmsa002Bean.getSiteAppObjParam().setRentServAmtAdd(siteAppTemp.getRentAmtAdd());
						}
						
						if(siteAppTemp.getRentAmtAddPerc()!=null){
							semmsa002Bean.getSiteAppObjParam().setRentServAmtAddPerc(siteAppTemp.getRentAmtAddPerc());
						}
						
						if(siteAppTemp.getRentAmt()!=null){
							semmsa002Bean.getSiteAppObjParam().setRentServiceAmt(siteAppTemp.getRentAmt());
						}
						
						if(siteAppTemp.getRentPeriodType()!=null){
							semmsa002Bean.getSiteAppObjParam().setRentServicePeriodType(siteAppTemp.getRentPeriodType());
						}
					}
				}
			}
//			setSemmsa002Bean(semmsa002Bean);
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}finally{
			LOG.debug("finally retValD :"+semmsa002Bean.getSiteAppObjParam().getRentAmtAddPerc());
			LOG.debug("finally retValE :"+semmsa002Bean.getSiteAppObjParam().getRentAmt());
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	
	public void msa002_calDtm() {
		try {
			
			semmsa002Bean = getSemmsa002Bean();
			
			String paramCalDtm = getFacesUtils().getRequestParameter("paramCalDtm") == null ? "" : (String) getFacesUtils().getRequestParameter("paramCalDtm");
			//boolean paramChkNoExpire = semmsa002Bean.isChkContractNeverExpire() == null ? "" : (boolean) semmsa002Bean.isChkContractNeverExpire();
			semmsa002Bean.setRenderedMsgFormChkExpire(false);
			// -- tab2
			if(paramCalDtm.equals("tab2")){
				Date dtmEffct = semmsa002Bean.getSiteAppObjParam().getEffectiveDt();
				Date dtmExpr = semmsa002Bean.getSiteAppObjParam().getExpireDt();

				if(dtmEffct != null && dtmExpr != null){
					
					semmsa002Bean.getSiteAppObjParam().setAgeYear(0);
					semmsa002Bean.getSiteAppObjParam().setAgeMonth(0);
					semmsa002Bean.getSiteAppObjParam().setAgeDay(0);
					
					if(dtmEffct.after(dtmExpr)) {
						addMessageErrorWithArgument("W0006" ,msg("message.contractEffDate"), msg("message.contractExpDate"));
						semmsa002Bean.setRenderedMsgFormChkExpire(true);
						semmsa002Bean.getSiteAppObjParam().setExpireDt(null);
					} else {
						
						Msi004CalcAgeSP cal = this.calDtm(dtmEffct, dtmExpr);
						
						if(cal.getAgeYear() != null){
							semmsa002Bean.getSiteAppObjParam().setAgeYear(cal.getAgeYear());
						}
						if(cal.getAgeMonth() != null){
							semmsa002Bean.getSiteAppObjParam().setAgeMonth(cal.getAgeMonth());
						}
						if(cal.getAgeDay() != null){
							semmsa002Bean.getSiteAppObjParam().setAgeDay(cal.getAgeDay());
						}
						
						//set default rent PeriodStartDt
						if(semmsa002Bean.getSiteAppObjParam().getEffectiveDt() != null)
							semmsa002Bean.getSiteAppRentObjParam().setPeriodStartDt(semmsa002Bean.getSiteAppObjParam().getEffectiveDt());
						
						//set default rent setPeriodEndDt
						if(semmsa002Bean.getSiteAppObjParam().getExpireDt() != null)
							semmsa002Bean.getSiteAppRentObjParam().setPeriodEndDt(semmsa002Bean.getSiteAppObjParam().getExpireDt());
						
					}
				}else{
					semmsa002Bean.getSiteAppObjParam().setAgeYear(0);
					semmsa002Bean.getSiteAppObjParam().setAgeMonth(0);
					semmsa002Bean.getSiteAppObjParam().setAgeDay(0);
					semmsa002Bean.getSiteAppObjParam().setTotalRentService(new BigDecimal(0));
					if(semmsa002Bean.isChkContractNeverExpire()){
						semmsa002Bean.getSiteAppObjParam().setPromiseRenewTime(0);
						semmsa002Bean.getSiteAppObjParam().setPromiseRenewPeriod(0);
						semmsa002Bean.getSiteAppObjParam().setPromiseRenewPeriodType("");
						semmsa002Bean.getSiteAppObjParam().setTotalRentService(new BigDecimal(0));
						semmsa002Bean.getSiteAppObjParam().setRevenue(new BigDecimal(0));
					}
				}
				
				this.doGetSiteAppRentServSrch();
				this.doGetSiteAppRentAmtSrch();
			}
			
			//tab6
			else if(paramCalDtm.equals("tab6")){
				Date dtmEffctIns = semmsa002Bean.getSiteAppObjParam().getInsEffectiveDt();
				Date dtmExprIns = semmsa002Bean.getSiteAppObjParam().getInsExpireDt();
			
				if(dtmEffctIns != null && dtmExprIns != null){
					if(dtmEffctIns.after(dtmExprIns)) {
						semmsa002Bean.getSiteAppObjParam().setInsExpireDt(null);
						
						//addMessageErrorWithArgument("W0005", "effective date", "expire date");
						//semmsa002Bean.setRenderedMsgAlert(true);
					} else {
						// do nothing
					}
				}
			}
			
			//tab3
			else if(paramCalDtm.equals("tab3")){
				//contract Date
				Date dtmEffct = semmsa002Bean.getSiteAppObjParam().getEffectiveDt();
				Date dtmExpr = semmsa002Bean.getSiteAppObjParam().getExpireDt();
				
				//rent period date
				Date dtmEffctPrd = semmsa002Bean.getSiteAppRentObjParam().getPeriodStartDt();
				Date dtmExprPrd = semmsa002Bean.getSiteAppRentObjParam().getPeriodEndDt();
			
				if(dtmEffctPrd != null && dtmExprPrd != null){
					if(dtmEffctPrd.after(dtmExprPrd)) {
						semmsa002Bean.getSiteAppRentObjParam().setPeriodEndDt(null);
						
						addMessageErrorWithArgument("W0006", msg("message.startperioddate"), msg("message.endperioddt"));
						semmsa002Bean.setRenderedMsgFormChkExpire(true);
						return;
					} else {
						// do nothing
					}
					
				}
				
				if(dtmEffct != null && dtmEffctPrd != null){
					//check rentPeriodStartDate >= contractEffectiveDate
					if(dtmEffctPrd.before(dtmEffct)){
						semmsa002Bean.getSiteAppRentObjParam().setPeriodStartDt(null);
						
						addMessageErrorWithArgument("W0006", msg("message.startperioddate"), msg("message.contractEffDate") );
						semmsa002Bean.setRenderedMsgFormChkExpire(true);
						return;
					}
					
				}
				
				if(!semmsa002Bean.isChkContractNeverExpire()){
					if(dtmExpr != null){
						if(dtmExprPrd != null){
							//check rentPeriodEndDate <= contractExpireDate
							if(dtmExprPrd.after(dtmExpr)){
								semmsa002Bean.getSiteAppRentObjParam().setPeriodEndDt(null);
								
								addMessageErrorWithArgument("W0122", msg("message.endperioddt"), msg("message.contractExpDate"));
								semmsa002Bean.setRenderedMsgFormChkExpire(true);
								return;
							}
						}
					}else{
						addMessageErrorWithArgument("W0001", msg("message.contractExpDate"));
						semmsa002Bean.setRenderedMsgFormChkExpire(true);
						return;
					}
				}
				this.doGetSiteAppRentServSrch();
				this.doGetSiteAppRentAmtSrch();
			}
			
//			setSemmsa002Bean(semmsa002Bean);
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	
	public Msi004CalcAgeSP calDtm(Date dtmFrom, Date dtmTo) {
		
		Msi004CalcAgeSP cal = new Msi004CalcAgeSP();
		
		try {
			ISiteContractService service = (ISiteContractService)getBean("siteContractService");
			List<Msi004CalcAgeSP> to = null;
			
			Msi004CalcAgeSP criteria = new Msi004CalcAgeSP();
			criteria.setEffDate(dtmFrom);
			criteria.setExpDate(dtmTo);
			
			to = service.querySPList(EQueryName.SP_MSI004_CALC_AGE.name, criteria);
			
			if(to != null && to.size() > 0){
				cal = to.get(0);
			}
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
		return cal;
	}
	
	public void doCalAmt(){
		semmsa002Bean = getSemmsa002Bean();
		String flagType = getFacesUtils().getRequestParameter("flagType") == null ? "" : (String) getFacesUtils().getRequestParameter("flagType");
		SiteAppSP siteAppSp = semmsa002Bean.getSiteAppRentObjParam();
		List<SiteAppSP> to = null;
		List<SiteAppSP> to2 = null;
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService");
		try{
			//cal 
			if(flagType != null){
				if("R".equals(flagType)){
					to2 = service.siteAppDao_querySPList(EQueryName.SP_MSA002_CAL_RENT_AMT.name, siteAppSp);
					if(to2 != null){
						SiteAppSP siteAppTemp = new SiteAppSP();
						siteAppTemp = to2.get(0);
//						System.out.println("getRentAmtAdd = "+siteAppTemp.getRentAmtAdd());
//						System.out.println("getRentAmtAddPerc = "+siteAppTemp.getRentAmtAddPerc());
//						System.out.println("getRentAmt = "+siteAppTemp.getRentAmt());
//						System.out.println("getRentPeriodType = "+siteAppTemp.getRentPeriodType());
						if(siteAppTemp.getRentAmtAdd()!=null){
							semmsa002Bean.getSiteAppObjParam().setRentAmtAdd(siteAppTemp.getRentAmtAdd());
							semmsa002Bean.getSiteAppRentObjParam().setRentAmtAdd(siteAppTemp.getRentAmtAdd());
							
						}
						
						if(siteAppTemp.getRentAmtAddPerc()!=null){
							semmsa002Bean.getSiteAppObjParam().setRentAmtAddPerc(siteAppTemp.getRentAmtAddPerc());
							semmsa002Bean.getSiteAppRentObjParam().setRentAmtAddPerc(siteAppTemp.getRentAmtAddPerc());
						}
						
						if(siteAppTemp.getRentAmt()!=null){
							semmsa002Bean.getSiteAppObjParam().setRentAmt(siteAppTemp.getRentAmt());
							semmsa002Bean.getSiteAppRentObjParam().setRentAmt(siteAppTemp.getRentAmt());
						}
						
						if(siteAppTemp.getRentPeriodType()!=null){
							semmsa002Bean.getSiteAppObjParam().setRentPeriodType(siteAppTemp.getRentPeriodType());
							semmsa002Bean.getSiteAppRentObjParam().setRentPeriodType(siteAppTemp.getRentPeriodType());
						}
					}
					
					//added by NEW 2016/03/29 check rentPeriod for set defult rentPayPeriod
					if(semmsa002Bean.getSiteAppObjParam().getRentPeriodType() != null){
						if("M".equals(semmsa002Bean.getSiteAppObjParam().getRentPeriodType().toUpperCase())){
							semmsa002Bean.setPayPeriodType01("01");
							semmsa002Bean.setPayPeriodType02("");
							semmsa002Bean.setPayPeriodType05("");
//							renderPayPeriodType();
							semmsa002Bean.getSiteAppObjParam().setRentPaymentPeriod(semmsa002Bean.getPayPeriodType01());
						}else if("Y".equals(semmsa002Bean.getSiteAppObjParam().getRentPeriodType().toUpperCase())){
							semmsa002Bean.setPayPeriodType02("02");
							semmsa002Bean.setPayPeriodType01("");
							semmsa002Bean.setPayPeriodType05("");
							semmsa002Bean.getSiteAppObjParam().setRentPaymentPeriod(semmsa002Bean.getPayPeriodType02());
						}else if("O".equals(semmsa002Bean.getSiteAppObjParam().getRentPeriodType().toUpperCase())){
							semmsa002Bean.setPayPeriodType05("05");
							semmsa002Bean.setPayPeriodType01("");
							semmsa002Bean.setPayPeriodType02("");
							semmsa002Bean.getSiteAppObjParam().setRentPaymentPeriod(semmsa002Bean.getPayPeriodType05());
						}
//						System.out.println("getRentPeriodType "+semmsa002Bean.getSiteAppObjParam().getRentPeriodType());
//						semmsa002Bean.payPeriodType02()
					}
				}else if("S".equals(flagType)){
					to2 = service.siteAppDao_querySPList(EQueryName.SP_MSA002_CAL_SERVICE_AMT.name, siteAppSp);
					if(to2 != null){
						SiteAppSP siteAppTemp = new SiteAppSP();
						siteAppTemp = to2.get(0);
//						System.out.println("getRentSerAmtAdd = "+siteAppTemp.getRentAmtAdd());
//						System.out.println("getRentAmtSerAddPerc = "+siteAppTemp.getRentAmtAddPerc());
//						System.out.println("getRentSerAmt = "+siteAppTemp.getRentAmt());
//						System.out.println("getRentSerPeriodType = "+siteAppTemp.getRentPeriodType());
						if(siteAppTemp.getRentAmtAdd()!=null){
							semmsa002Bean.getSiteAppObjParam().setRentServAmtAdd(siteAppTemp.getRentAmtAdd());
						}
						
						if(siteAppTemp.getRentAmtAddPerc()!=null){
							semmsa002Bean.getSiteAppObjParam().setRentServAmtAddPerc(siteAppTemp.getRentAmtAddPerc());
						}
						
						if(siteAppTemp.getRentAmt()!=null){
							semmsa002Bean.getSiteAppObjParam().setRentServiceAmt(siteAppTemp.getRentAmt());
						}
						
						if(siteAppTemp.getRentPeriodType()!=null){
							semmsa002Bean.getSiteAppObjParam().setRentServicePeriodType(siteAppTemp.getRentPeriodType());
						}
					}
					
					//added by NEW 2016/03/29 check servPeriod for set defult servPayPeriod
					if(semmsa002Bean.getSiteAppObjParam().getRentServicePeriodType() != null){
						if("M".equals(semmsa002Bean.getSiteAppObjParam().getRentServicePeriodType().toUpperCase())){
							semmsa002Bean.setServicePayPeriodType01("01");
							semmsa002Bean.setServicePayPeriodType02("");
							semmsa002Bean.setServicePayPeriodType05("");
							semmsa002Bean.getSiteAppObjParam().setServPaymentPeriod(semmsa002Bean.getServicePayPeriodType01());
						}else if("Y".equals(semmsa002Bean.getSiteAppObjParam().getRentServicePeriodType().toUpperCase())){
							semmsa002Bean.setServicePayPeriodType02("02");
							semmsa002Bean.setServicePayPeriodType01("");
							semmsa002Bean.setServicePayPeriodType05("");
							semmsa002Bean.getSiteAppObjParam().setServPaymentPeriod(semmsa002Bean.getServicePayPeriodType02());
						}else if("O".equals(semmsa002Bean.getSiteAppObjParam().getRentServicePeriodType().toUpperCase())){
							semmsa002Bean.setServicePayPeriodType05("05");
							semmsa002Bean.setServicePayPeriodType01("");
							semmsa002Bean.setServicePayPeriodType02("");
							semmsa002Bean.getSiteAppObjParam().setServPaymentPeriod(semmsa002Bean.getServicePayPeriodType05());
						}
//						System.out.println("getServPeriodType "+semmsa002Bean.getSiteAppObjParam().getRentServicePeriodType());
//						semmsa002Bean.payPeriodType02()
					}
				}
			}
			
			
			SiteAppSP siteAppParam = semmsa002Bean.getSiteAppObjParam();
			if(siteAppParam != null){
				if(siteAppParam.getEffectiveDt() != null && siteAppParam.getExpireDt() != null &&
						siteAppParam.getRentAmt() != null && siteAppParam.getRentPeriodType() != null &&
						siteAppParam.getRentServiceAmt() != null && siteAppParam.getRentServicePeriodType() != null){
					to = service.siteAppDao_querySPList(EQueryName.SP_MSA002_CAL_AMT.name, siteAppParam);
					
					if(to != null){
						siteAppParam  = to.get(0);
						if(siteAppParam.getRetResult() != null){
							semmsa002Bean.getSiteAppObjParam().setTotalRentService(new BigDecimal(siteAppParam.getRetResult()));
						}
						
					}else{
						semmsa002Bean.getSiteAppObjParam().setTotalRentService(new BigDecimal(0));
					}
				}else{
					semmsa002Bean.getSiteAppObjParam().setTotalRentService(new BigDecimal(0));
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
			// TODO: handle exception
		}finally{
			setSemmsa002Bean(semmsa002Bean);
//			semmsa002Bean = null;
		}
	}
	
	
	// custom convert DTM
	public String convertYearENtoTHStr(Date date){
		if(date == null)
			return null;
		try {
			return this.convertToThYearStr(date);
		} catch (Exception e) {
			return null;
		}
	}
	
	public String convertToThYearStr(Date inputDate) throws Exception {
		String result = "";
		try {
			Date currentDate = SEMDataUtility.getCurrentDate();
			SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
			SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
			SimpleDateFormat dayFormat = new SimpleDateFormat("dd");

			SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");

			String strCurrYear = yearFormat.format(currentDate);
			String strInputYear = yearFormat.format(inputDate);
			String strInputMonth = monthFormat.format(inputDate);
			String strInputDay = dayFormat.format(inputDate);
			String strInputTime = timeFormat.format(inputDate);
			if (StringUtils.isNumeric(strInputYear) && StringUtils.isNumeric(strCurrYear)) {
				int inputYear = Integer.parseInt(strInputYear);
				int currYear = Integer.parseInt(strCurrYear);

				// lazy solution 555 !!
				if (inputYear < 2400) {
					inputYear += 543;
				}

					strInputYear = Integer.toString(inputYear);
					DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
					inputDate = (Date) formatter.parse(strInputDay + "/" + strInputMonth + "/" + strInputYear + " " + strInputTime);
					result = strInputDay + "/" + strInputMonth + "/" + strInputYear;
				//}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
		return result;
	}
	// custom convert DTM
	
	//added by new 2015/05/18
	public void msa002Tab3_calRentDepositBg(){
		semmsa002Bean = getSemmsa002Bean();
		BigDecimal rentDepOld = new BigDecimal(0);
		BigDecimal rentDepApp = new BigDecimal(0);
		try{
			if(semmsa002Bean.getSiteAppObjParam().getRentDepositBgAmtOld() != null)
				rentDepOld = semmsa002Bean.getSiteAppObjParam().getRentDepositBgAmtOld();
			if(semmsa002Bean.getSiteAppObjParam().getRentDepositBgAmtAdd() != null)
				rentDepApp = semmsa002Bean.getSiteAppObjParam().getRentDepositBgAmtAdd();
			
			semmsa002Bean.getSiteAppObjParam().setRentDepositBgAmt(rentDepOld.add(rentDepApp));
			setSemmsa002Bean(semmsa002Bean);
		}catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
			// TODO: handle exception
		}
	}
	
	public void msa002Tab3_calRentDepositCash(){
		semmsa002Bean = getSemmsa002Bean();
		BigDecimal rentDepOld = new BigDecimal(0); 
		BigDecimal rentDepApp = new BigDecimal(0); 
		try{
			if(semmsa002Bean.getSiteAppObjParam().getRentDepositCashAmtOld() != null)
				rentDepOld = semmsa002Bean.getSiteAppObjParam().getRentDepositCashAmtOld();
			if(semmsa002Bean.getSiteAppObjParam().getRentDepositCashAmtAdd() != null)
				rentDepApp = semmsa002Bean.getSiteAppObjParam().getRentDepositCashAmtAdd();
			
			semmsa002Bean.getSiteAppObjParam().setRentDepositCashAmt(rentDepOld.add(rentDepApp));
			setSemmsa002Bean(semmsa002Bean);
		}catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
			// TODO: handle exception
		}
	}
	
	//added by new 2015/05/21
	public void msa002Tab4_calElectricDepositBg(){
		semmsa002Bean = getSemmsa002Bean();
		BigDecimal elDepOld = new BigDecimal(0);
		BigDecimal elDepApp = new BigDecimal(0);
		try{
			if(semmsa002Bean.getSiteAppObjParam().getElDepositBgAmtOld() != null)
				elDepOld = semmsa002Bean.getSiteAppObjParam().getElDepositBgAmtOld();
			if(semmsa002Bean.getSiteAppObjParam().getElDepositBgAmtAdd() != null)
				elDepApp = semmsa002Bean.getSiteAppObjParam().getElDepositBgAmtAdd();
			
			semmsa002Bean.getSiteAppObjParam().setElBgDeposit(elDepOld.add(elDepApp));
			setSemmsa002Bean(semmsa002Bean);
		}catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
			// TODO: handle exception
		}
	}
	
	public void msa002Tab4_calELDepositCash(){
		semmsa002Bean = getSemmsa002Bean();
		BigDecimal elDepOld = new BigDecimal(0);
		BigDecimal elDepApp = new BigDecimal(0);
		try{
			if(semmsa002Bean.getSiteAppObjParam().getElDepositCashAmtOld() != null)
				elDepOld = semmsa002Bean.getSiteAppObjParam().getElDepositCashAmtOld();
			if(semmsa002Bean.getSiteAppObjParam().getElDepositCashAmtAdd() != null)
				elDepApp = semmsa002Bean.getSiteAppObjParam().getElDepositCashAmtAdd();
			
			semmsa002Bean.getSiteAppObjParam().setElCashDeposit(elDepOld.add(elDepApp));
			setSemmsa002Bean(semmsa002Bean);
		}catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
			// TODO: handle exception
		}
	}
	
	//added by NEW 11/02/2016 
	public boolean renderPayPeriodType(){
		boolean flag = false;
		semmsa002Bean = getSemmsa002Bean();
		try{
			String payPeriodType = (String)getFacesUtils().getRequestParameter("payPeriodType");
			if(payPeriodType.equals("01")){
				semmsa002Bean.setPayPeriodType02("");
				semmsa002Bean.setPayPeriodType03("");
				semmsa002Bean.setPayPeriodType04("");
				semmsa002Bean.setPayPeriodType05("");
				semmsa002Bean.setPayPeriodType06("");
				semmsa002Bean.setPayPeriodType07("");
				semmsa002Bean.setPayPeriod03(null);
				semmsa002Bean.setPayPeriod04(null);
				semmsa002Bean.setDisabledPayPeriod03(true);
				semmsa002Bean.setDisabledPayPeriod04(true);
			}
			if(payPeriodType.equals("02")){
				semmsa002Bean.setPayPeriodType01("");
				semmsa002Bean.setPayPeriodType03("");
				semmsa002Bean.setPayPeriodType04("");
				semmsa002Bean.setPayPeriodType05("");
				semmsa002Bean.setPayPeriodType06("");
				semmsa002Bean.setPayPeriodType07("");
				semmsa002Bean.setPayPeriod03(null);
				semmsa002Bean.setPayPeriod04(null);
				semmsa002Bean.setDisabledPayPeriod03(true);
				semmsa002Bean.setDisabledPayPeriod04(true);
			}
			if(payPeriodType.equals("03")){
				if(semmsa002Bean.getPayPeriod03() != null) semmsa002Bean.getSiteAppRentObjParam().setRentPaymentPeriodOth(semmsa002Bean.getPayPeriod03());
				semmsa002Bean.setPayPeriodType01("");
				semmsa002Bean.setPayPeriodType02("");
				semmsa002Bean.setPayPeriodType04("");
				semmsa002Bean.setPayPeriodType05("");
				semmsa002Bean.setPayPeriodType06("");
				semmsa002Bean.setPayPeriodType07("");
//				semmsa002Bean.setPayPeriod03(null);
				semmsa002Bean.setPayPeriod04(null);
				semmsa002Bean.setDisabledPayPeriod03(false);
				semmsa002Bean.setDisabledPayPeriod04(true);
			}
			if(payPeriodType.equals("04")){
				if(semmsa002Bean.getPayPeriod04() != null) semmsa002Bean.getSiteAppRentObjParam().setRentPaymentPeriodOth(semmsa002Bean.getPayPeriod04());
				semmsa002Bean.setPayPeriodType01("");
				semmsa002Bean.setPayPeriodType02("");
				semmsa002Bean.setPayPeriodType03("");
				semmsa002Bean.setPayPeriodType05("");
				semmsa002Bean.setPayPeriodType06("");
				semmsa002Bean.setPayPeriodType07("");
				semmsa002Bean.setPayPeriod03(null);
//				semmsa002Bean.setPayPeriod04(null);
				semmsa002Bean.setDisabledPayPeriod03(true);
				semmsa002Bean.setDisabledPayPeriod04(false);
			}
			if(payPeriodType.equals("05")){
				semmsa002Bean.setPayPeriodType01("");
				semmsa002Bean.setPayPeriodType02("");
				semmsa002Bean.setPayPeriodType03("");
				semmsa002Bean.setPayPeriodType04("");
				semmsa002Bean.setPayPeriodType06("");
				semmsa002Bean.setPayPeriodType07("");
				semmsa002Bean.setPayPeriod03(null);
				semmsa002Bean.setPayPeriod04(null);
				semmsa002Bean.setDisabledPayPeriod03(true);
				semmsa002Bean.setDisabledPayPeriod04(true);
			}
			if(payPeriodType.equals("06")){
				semmsa002Bean.setPayPeriodType01("");
				semmsa002Bean.setPayPeriodType02("");
				semmsa002Bean.setPayPeriodType03("");
				semmsa002Bean.setPayPeriodType04("");
				semmsa002Bean.setPayPeriodType05("");
//				semmsa002Bean.setPayPeriodType06("");
				semmsa002Bean.setPayPeriodType07("");
				semmsa002Bean.setPayPeriod03(null);
				semmsa002Bean.setPayPeriod04(null);
				semmsa002Bean.setDisabledPayPeriod03(true);
				semmsa002Bean.setDisabledPayPeriod04(true);
			}
			if(payPeriodType.equals("07")){
				semmsa002Bean.setPayPeriodType01("");
				semmsa002Bean.setPayPeriodType02("");
				semmsa002Bean.setPayPeriodType03("");
				semmsa002Bean.setPayPeriodType04("");
				semmsa002Bean.setPayPeriodType05("");
				semmsa002Bean.setPayPeriodType06("");
//				semmsa002Bean.setPayPeriodType07("");
				semmsa002Bean.setPayPeriod03(null);
				semmsa002Bean.setPayPeriod04(null);
				semmsa002Bean.setDisabledPayPeriod03(true);
				semmsa002Bean.setDisabledPayPeriod04(true);
			}
			semmsa002Bean.getSiteAppRentObjParam().setRentPaymentPeriod(payPeriodType);
			setSemmsa002Bean(semmsa002Bean);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return flag;
	}
	
	private boolean initUpdateRentCond() {
		boolean flag = false;
		semmsa002Bean = getSemmsa002Bean();
//		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		
		try{
//			ISiteRentCondService service = (ISiteRentCondService)getBean("siteRentCondService");
//			RentCond rentCond = service.queryRentCondByRowId(rowId);
			if(semmsa002Bean.getSiteAppRentObjParam().getRentPaymentPeriod() != null){
				if(StringUtils.isEmpty(semmsa002Bean.getSiteAppRentObjParam().getRentPaymentPeriod())){
					semmsa002Bean.getSiteAppRentObjParam().setRentPaymentPeriod("");
				}
				
				if(semmsa002Bean.getSiteAppRentObjParam().getRentPaymentPeriod() != null && semmsa002Bean.getSiteAppRentObjParam().getRentPaymentPeriod().equals("01")){
					semmsa002Bean.setPayPeriodType01(semmsa002Bean.getSiteAppRentObjParam().getRentPaymentPeriod());
					semmsa002Bean.setPayPeriodType02(null);
					semmsa002Bean.setPayPeriodType03(null);
					semmsa002Bean.setPayPeriodType04(null);
					semmsa002Bean.setPayPeriodType05(null);
					semmsa002Bean.setPayPeriodType06(null);
					semmsa002Bean.setPayPeriodType07(null);
					semmsa002Bean.setPayPeriod03(null);
					semmsa002Bean.setPayPeriod04(null);
					semmsa002Bean.setDisabledPayPeriod03(true);
					semmsa002Bean.setDisabledPayPeriod04(true);
					
				}
				if(semmsa002Bean.getSiteAppRentObjParam().getRentPaymentPeriod() != null && semmsa002Bean.getSiteAppRentObjParam().getRentPaymentPeriod().equals("02")){
					semmsa002Bean.setPayPeriodType02(semmsa002Bean.getSiteAppRentObjParam().getRentPaymentPeriod());
					semmsa002Bean.setPayPeriodType01(null);
					semmsa002Bean.setPayPeriodType03(null);
					semmsa002Bean.setPayPeriodType04(null);
					semmsa002Bean.setPayPeriodType05(null);
					semmsa002Bean.setPayPeriodType06(null);
					semmsa002Bean.setPayPeriodType07(null);
					semmsa002Bean.setPayPeriod03(null);
					semmsa002Bean.setPayPeriod04(null);
					semmsa002Bean.setDisabledPayPeriod03(true);
					semmsa002Bean.setDisabledPayPeriod04(true);
				}
				if(semmsa002Bean.getSiteAppRentObjParam().getRentPaymentPeriod() != null && semmsa002Bean.getSiteAppRentObjParam().getRentPaymentPeriod().equals("03")){
					LOG.debug("getRentPaymentPeriodOth3 =: "+semmsa002Bean.getSiteAppRentObjParam().getRentPaymentPeriodOth());
					semmsa002Bean.setPayPeriod03(semmsa002Bean.getSiteAppRentObjParam().getRentPaymentPeriodOth());
					semmsa002Bean.setPayPeriodType03(semmsa002Bean.getSiteAppRentObjParam().getRentPaymentPeriod());
					semmsa002Bean.setPayPeriodType01(null);
					semmsa002Bean.setPayPeriodType02(null);
					semmsa002Bean.setPayPeriodType04(null);
					semmsa002Bean.setPayPeriodType05(null);
					semmsa002Bean.setPayPeriodType06(null);
					semmsa002Bean.setPayPeriodType07(null);
					semmsa002Bean.setPayPeriod04(null);
					semmsa002Bean.setDisabledPayPeriod03(false);
					semmsa002Bean.setDisabledPayPeriod04(true);
				}
				if(semmsa002Bean.getSiteAppRentObjParam().getRentPaymentPeriod() != null && semmsa002Bean.getSiteAppRentObjParam().getRentPaymentPeriod().equals("04")){
					LOG.debug("getRentPaymentPeriodOth4 =: "+semmsa002Bean.getSiteAppRentObjParam().getRentPaymentPeriodOth());
					semmsa002Bean.setPayPeriod04(semmsa002Bean.getSiteAppRentObjParam().getRentPaymentPeriodOth());
					semmsa002Bean.setPayPeriodType04(semmsa002Bean.getSiteAppRentObjParam().getRentPaymentPeriod());
					semmsa002Bean.setPayPeriodType01(null);
					semmsa002Bean.setPayPeriodType02(null);
					semmsa002Bean.setPayPeriodType03(null);
					semmsa002Bean.setPayPeriodType05(null);
					semmsa002Bean.setPayPeriodType06(null);
					semmsa002Bean.setPayPeriodType07(null);
					semmsa002Bean.setPayPeriod03(null);
					semmsa002Bean.setDisabledPayPeriod03(true);
					semmsa002Bean.setDisabledPayPeriod04(false);
				}
				if(semmsa002Bean.getSiteAppRentObjParam().getRentPaymentPeriod() != null && semmsa002Bean.getSiteAppRentObjParam().getRentPaymentPeriod().equals("05")){
					semmsa002Bean.setPayPeriodType05(semmsa002Bean.getSiteAppRentObjParam().getRentPaymentPeriod());
					semmsa002Bean.setPayPeriodType01(null);
					semmsa002Bean.setPayPeriodType02(null);
					semmsa002Bean.setPayPeriodType03(null);
					semmsa002Bean.setPayPeriodType04(null);
					semmsa002Bean.setPayPeriodType06(null);
					semmsa002Bean.setPayPeriodType07(null);
					semmsa002Bean.setPayPeriod03(null);
					semmsa002Bean.setPayPeriod04(null);
					semmsa002Bean.setDisabledPayPeriod03(true);
					semmsa002Bean.setDisabledPayPeriod04(true);
				}
				if(semmsa002Bean.getSiteAppRentObjParam().getRentPaymentPeriod() != null && semmsa002Bean.getSiteAppRentObjParam().getRentPaymentPeriod().equals("06")){
					semmsa002Bean.setPayPeriodType06(semmsa002Bean.getSiteAppRentObjParam().getRentPaymentPeriod());
					semmsa002Bean.setPayPeriodType01(null);
					semmsa002Bean.setPayPeriodType02(null);
					semmsa002Bean.setPayPeriodType03(null);
					semmsa002Bean.setPayPeriodType04(null);
					semmsa002Bean.setPayPeriodType05(null);
					semmsa002Bean.setPayPeriodType07(null);
					semmsa002Bean.setPayPeriod03(null);
					semmsa002Bean.setPayPeriod04(null);
					semmsa002Bean.setDisabledPayPeriod03(true);
					semmsa002Bean.setDisabledPayPeriod04(true);
					
				}
				if(semmsa002Bean.getSiteAppRentObjParam().getRentPaymentPeriod() != null && semmsa002Bean.getSiteAppRentObjParam().getRentPaymentPeriod().equals("07")){
					semmsa002Bean.setPayPeriodType07(semmsa002Bean.getSiteAppRentObjParam().getRentPaymentPeriod());
					semmsa002Bean.setPayPeriodType01(null);
					semmsa002Bean.setPayPeriodType02(null);
					semmsa002Bean.setPayPeriodType03(null);
					semmsa002Bean.setPayPeriodType04(null);
					semmsa002Bean.setPayPeriodType05(null);
					semmsa002Bean.setPayPeriodType06(null);
					semmsa002Bean.setPayPeriod03(null);
					semmsa002Bean.setPayPeriod04(null);
					semmsa002Bean.setDisabledPayPeriod03(true);
					semmsa002Bean.setDisabledPayPeriod04(true);
					
				}
//				if(rentCond.getExpenseType() != null && rentCond.getExpenseType().equals("02")){
//					semmsi004tab3Bean.setRenderedNormalVatType(true);
//				}else{
//					semmsi004tab3Bean.setRenderedNormalVatType(false);
//				}
//				if(rentCond.getWhtType() != null && !rentCond.getWhtType().equals("03")){
//					semmsi004tab3Bean.setDisabledChkWhtRateNormal(false);
//				}else{
//					semmsi004tab3Bean.setDisabledChkWhtRateNormal(true);
//				}
//				if(rentCond.getOverFlag() != null && rentCond.getOverFlag().equals("Y")){
//					semmsi004tab3Bean.setChkOverFlag(true);
//				}else{
//					semmsi004tab3Bean.setChkOverFlag(false);
//				}
//				semmsi004tab3Bean.getRentCondNormal().setRentCondType("01");
//				semmsi004tab3Bean.setDisabledBtnAddRentCond(true);
//				semmsi004tab3Bean.setDisabledBtnUpdateRentCond(false);
//				semmsi004tab3Bean.setRentCondNormal(rentCond);
//				semmsi004tab3Bean.setDisabledPeriodType(true);
//				semmsi004tab3Bean.setDisabledWhtRateNormal(true);
//				semmsi004tab3Bean.setDisabledRent(false);
//				semmsi004tab3Bean.setDisabledRentSetup(false);
//				if(rentCond.getRentOldAmt() != null){
//					semmsi004tab3Bean.setRenderedRentOldAmt(true);
//					semmsi004tab3Bean.setDisabledRentOldAmt(true);
//				}else{
//					semmsi004tab3Bean.setRenderedRentOldAmt(false);
//				}
				
				setSemmsa002Bean(semmsa002Bean);
			}else{
				semmsa002Bean.setPayPeriodType01(null);
				semmsa002Bean.setPayPeriodType02(null);
				semmsa002Bean.setPayPeriodType03(null);
				semmsa002Bean.setPayPeriodType04(null);
				semmsa002Bean.setPayPeriodType05(null);
				semmsa002Bean.setPayPeriodType06(null);
				semmsa002Bean.setPayPeriodType07(null);
				semmsa002Bean.setPayPeriod03(null);
				semmsa002Bean.setPayPeriod04(null);
				semmsa002Bean.setDisabledPayPeriod03(true);
				semmsa002Bean.setDisabledPayPeriod04(true);
			}
			
			// add 13/02/2023
		   if (StringUtils.equals("03", semmsa002Bean.getSiteAppRentObjParam().getExpenseType())) {
			   semmsa002Bean.setDisabledExpenseDesc(false);
		   }else {
			   semmsa002Bean.setDisabledExpenseDesc(true);
			   semmsa002Bean.getSiteAppRentObjParam().setExpenseDesc(null);
		   }
		   
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public boolean renderServicePayPeriodType(){
		boolean flag = false;
		semmsa002Bean = getSemmsa002Bean();
		try{
			String payPeriodType = (String)getFacesUtils().getRequestParameter("servicePayPeriodType");
			if(payPeriodType.equals("01")){
				semmsa002Bean.setServicePayPeriodType02("");
				semmsa002Bean.setServicePayPeriodType03("");
				semmsa002Bean.setServicePayPeriodType04("");
				semmsa002Bean.setServicePayPeriodType05("");
				semmsa002Bean.setServicePayPeriod03(null);
				semmsa002Bean.setServicePayPeriod04(null);
				semmsa002Bean.setDisabledServicePayPeriod03(true);
				semmsa002Bean.setDisabledServicePayPeriod04(true);
			}
			if(payPeriodType.equals("02")){
				semmsa002Bean.setServicePayPeriodType01("");
				semmsa002Bean.setServicePayPeriodType03("");
				semmsa002Bean.setServicePayPeriodType04("");
				semmsa002Bean.setServicePayPeriodType05("");
				semmsa002Bean.setServicePayPeriod03(null);
				semmsa002Bean.setServicePayPeriod04(null);
				semmsa002Bean.setDisabledServicePayPeriod03(true);
				semmsa002Bean.setDisabledServicePayPeriod04(true);
			}
			if(payPeriodType.equals("03")){
				if(semmsa002Bean.getPayPeriod03() != null) semmsa002Bean.getSiteAppRentObjParam().setServPaymentPeriodOth(semmsa002Bean.getServicePayPeriod03());
				semmsa002Bean.setServicePayPeriodType01("");
				semmsa002Bean.setServicePayPeriodType02("");
				semmsa002Bean.setServicePayPeriodType04("");
				semmsa002Bean.setServicePayPeriodType05("");
				semmsa002Bean.setServicePayPeriod03(null);
				semmsa002Bean.setServicePayPeriod04(null);
				semmsa002Bean.setDisabledServicePayPeriod03(false);
				semmsa002Bean.setDisabledServicePayPeriod04(true);
			}
			if(payPeriodType.equals("04")){
				if(semmsa002Bean.getPayPeriod04() != null) semmsa002Bean.getSiteAppRentObjParam().setServPaymentPeriodOth(semmsa002Bean.getServicePayPeriod04());
				semmsa002Bean.setServicePayPeriodType01("");
				semmsa002Bean.setServicePayPeriodType02("");
				semmsa002Bean.setServicePayPeriodType03("");
				semmsa002Bean.setServicePayPeriodType05("");
				semmsa002Bean.setServicePayPeriod03(null);
				semmsa002Bean.setServicePayPeriod04(null);
				semmsa002Bean.setDisabledServicePayPeriod03(true);
				semmsa002Bean.setDisabledServicePayPeriod04(false);
			}
			if(payPeriodType.equals("05")){
				semmsa002Bean.setServicePayPeriodType01("");
				semmsa002Bean.setServicePayPeriodType02("");
				semmsa002Bean.setServicePayPeriodType03("");
				semmsa002Bean.setServicePayPeriodType04("");
				semmsa002Bean.setServicePayPeriod03(null);
				semmsa002Bean.setServicePayPeriod04(null);
				semmsa002Bean.setDisabledServicePayPeriod03(true);
				semmsa002Bean.setDisabledServicePayPeriod04(true);
			}
			semmsa002Bean.getSiteAppRentObjParam().setServPaymentPeriod(payPeriodType);
			setSemmsa002Bean(semmsa002Bean);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return flag;
	}
	
	private boolean initUpdateRentServiceCond() {
		boolean flag = false;
		semmsa002Bean = getSemmsa002Bean();
//		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		
		try{
//			ISiteRentCondService service = (ISiteRentCondService)getBean("siteRentCondService");
//			RentCond rentCond = service.queryRentCondByRowId(rowId);
//			System.out.println("getServPaymentPeriod =: "+semmsa002Bean.getSiteAppObjParam().getServPaymentPeriod());
			if(semmsa002Bean.getSiteAppObjParam().getServPaymentPeriod() != null){
				if(StringUtils.isEmpty(semmsa002Bean.getSiteAppObjParam().getServPaymentPeriod())){
					semmsa002Bean.getSiteAppObjParam().setServPaymentPeriod("");
				}
				
				if(semmsa002Bean.getSiteAppObjParam().getServPaymentPeriod() != null && semmsa002Bean.getSiteAppObjParam().getServPaymentPeriod().equals("01")){
					semmsa002Bean.setServicePayPeriodType01(semmsa002Bean.getSiteAppObjParam().getServPaymentPeriod());
					semmsa002Bean.setServicePayPeriodType02(null);
					semmsa002Bean.setServicePayPeriodType03(null);
					semmsa002Bean.setServicePayPeriodType04(null);
					semmsa002Bean.setServicePayPeriodType05(null);
					semmsa002Bean.setServicePayPeriod03(null);
					semmsa002Bean.setServicePayPeriod04(null);
					semmsa002Bean.setDisabledServicePayPeriod03(true);
					semmsa002Bean.setDisabledServicePayPeriod04(true);
					
				}
				if(semmsa002Bean.getSiteAppObjParam().getServPaymentPeriod() != null && semmsa002Bean.getSiteAppObjParam().getServPaymentPeriod().equals("02")){
					semmsa002Bean.setServicePayPeriodType02(semmsa002Bean.getSiteAppObjParam().getServPaymentPeriod());
					semmsa002Bean.setServicePayPeriodType01(null);
					semmsa002Bean.setServicePayPeriodType03(null);
					semmsa002Bean.setServicePayPeriodType04(null);
					semmsa002Bean.setServicePayPeriodType05(null);
					semmsa002Bean.setServicePayPeriod03(null);
					semmsa002Bean.setServicePayPeriod04(null);
					semmsa002Bean.setDisabledServicePayPeriod03(true);
					semmsa002Bean.setDisabledServicePayPeriod04(true);
				}
				if(semmsa002Bean.getSiteAppObjParam().getServPaymentPeriod() != null && semmsa002Bean.getSiteAppObjParam().getServPaymentPeriod().equals("03")){
					semmsa002Bean.setServicePayPeriod03(semmsa002Bean.getSiteAppObjParam().getServPaymentPeriodOth());
					semmsa002Bean.setServicePayPeriodType03(semmsa002Bean.getSiteAppObjParam().getServPaymentPeriod());
					semmsa002Bean.setServicePayPeriodType01(null);
					semmsa002Bean.setServicePayPeriodType02(null);
					semmsa002Bean.setServicePayPeriodType04(null);
					semmsa002Bean.setServicePayPeriodType05(null);
					semmsa002Bean.setServicePayPeriod04(null);
					semmsa002Bean.setDisabledServicePayPeriod03(false);
					semmsa002Bean.setDisabledServicePayPeriod04(true);
				}
				if(semmsa002Bean.getSiteAppObjParam().getServPaymentPeriod() != null && semmsa002Bean.getSiteAppObjParam().getServPaymentPeriod().equals("04")){
					semmsa002Bean.setServicePayPeriod04(semmsa002Bean.getSiteAppObjParam().getServPaymentPeriodOth());
					semmsa002Bean.setServicePayPeriodType04(semmsa002Bean.getSiteAppObjParam().getServPaymentPeriod());
					semmsa002Bean.setServicePayPeriodType01(null);
					semmsa002Bean.setServicePayPeriodType02(null);
					semmsa002Bean.setServicePayPeriodType03(null);
					semmsa002Bean.setServicePayPeriodType05(null);
					semmsa002Bean.setServicePayPeriod03(null);
					semmsa002Bean.setDisabledServicePayPeriod03(true);
					semmsa002Bean.setDisabledServicePayPeriod04(false);
				}
				if(semmsa002Bean.getSiteAppObjParam().getServPaymentPeriod() != null && semmsa002Bean.getSiteAppObjParam().getServPaymentPeriod().equals("05")){
					semmsa002Bean.setServicePayPeriodType05(semmsa002Bean.getSiteAppObjParam().getServPaymentPeriod());
					semmsa002Bean.setServicePayPeriodType01(null);
					semmsa002Bean.setServicePayPeriodType02(null);
					semmsa002Bean.setServicePayPeriodType03(null);
					semmsa002Bean.setServicePayPeriodType04(null);
					semmsa002Bean.setServicePayPeriod03(null);
					semmsa002Bean.setServicePayPeriod04(null);
					semmsa002Bean.setDisabledServicePayPeriod03(true);
					semmsa002Bean.setDisabledServicePayPeriod04(true);
				}
//				if(rentCond.getExpenseType() != null && rentCond.getExpenseType().equals("02")){
//					semmsi004tab3Bean.setRenderedNormalVatType(true);
//				}else{
//					semmsi004tab3Bean.setRenderedNormalVatType(false);
//				}
//				if(rentCond.getWhtType() != null && !rentCond.getWhtType().equals("03")){
//					semmsi004tab3Bean.setDisabledChkWhtRateNormal(false);
//				}else{
//					semmsi004tab3Bean.setDisabledChkWhtRateNormal(true);
//				}
//				if(rentCond.getOverFlag() != null && rentCond.getOverFlag().equals("Y")){
//					semmsi004tab3Bean.setChkOverFlag(true);
//				}else{
//					semmsi004tab3Bean.setChkOverFlag(false);
//				}
//				semmsi004tab3Bean.getRentCondNormal().setRentCondType("01");
//				semmsi004tab3Bean.setDisabledBtnAddRentCond(true);
//				semmsi004tab3Bean.setDisabledBtnUpdateRentCond(false);
//				semmsi004tab3Bean.setRentCondNormal(rentCond);
//				semmsi004tab3Bean.setDisabledPeriodType(true);
//				semmsi004tab3Bean.setDisabledWhtRateNormal(true);
//				semmsi004tab3Bean.setDisabledRent(false);
//				semmsi004tab3Bean.setDisabledRentSetup(false);
//				if(rentCond.getRentOldAmt() != null){
//					semmsi004tab3Bean.setRenderedRentOldAmt(true);
//					semmsi004tab3Bean.setDisabledRentOldAmt(true);
//				}else{
//					semmsi004tab3Bean.setRenderedRentOldAmt(false);
//				}
				
				setSemmsa002Bean(semmsa002Bean);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public boolean renderChkElectricType(){
		semmsa002Bean = getSemmsa002Bean();
		if(semmsa002Bean.isChkNoExpenses()){
			
			if(!semmsa002Bean.isChkMultiElectricTypeFlag()){
				semmsa002Bean.setChkElUseOldMeter(false);
				semmsa002Bean.setChkElUseNewMeter(false);
//				semmsa002Bean.setChkElUseOwner(false);
//				semmsa002Bean.setChkNoExpenses(false);
				semmsa002Bean.setChkElUseOthSite(false);
				semmsa002Bean.setDisabledElUserOthSite(true);
				semmsa002Bean.getSiteAppObjParam().setElPayOnPackageAmt(new BigDecimal(0));
				semmsa002Bean.getSiteAppObjParam().setElPackagePeriodType("");
				semmsa002Bean.getSiteAppObjParam().setElUnitPrice(new BigDecimal(0));
//				semmsa002Bean.setDisabledElctTypeDetail(true);
//				semmsa002Bean.setDisabledElctPackageTypeDetail(true);
//				semmsa002Bean.setDisabledElctUnitTypeDetail(true);
			}
			
//			semmsa002Bean.setChkElUseOldMeter(false);
//			semmsa002Bean.setChkElUseNewMeter(false);
//			semmsa002Bean.setChkElUseOthSite(false);
			semmsa002Bean.setChkElUseOwner(true);
			semmsa002Bean.setChkElPayOnPackage(false);
			semmsa002Bean.setDisabledModeViewOnly(false);
			semmsa002Bean.getSiteAppObjParam().setElPackagePeriodType("");
			semmsa002Bean.setChkElOwnerType(false);
			semmsa002Bean.getSiteAppObjParam().setElUnitPrice(new BigDecimal(0));
//			semmsa002Bean.setDisabledElctTypeDetail(true);
			semmsa002Bean.setDisabledElctPackageTypeDetail(true);
			semmsa002Bean.setDisabledElctUnitTypeDetail(true);
			semmsa002Bean.getSiteAppObjParam().setElVatType("");
//			semmsa002Bean.setChkElectricType1(false);
//			semmsa002Bean.setChkElectricType2(false);
//			semmsa002Bean.setChkElectricType3(false);
//			semmsa002Bean.setChkElectricType4(false);
//			semmsa002Bean.setChkMultiElectricTypeFlag(false);
//			semmsa002Bean.setRenderedElectricOwnerType(false);
//			semmsa002Bean.getSiteElectric().setElectricOwnerType("00");
//			semmsa002Bean.getSiteElectric().setVatType("01");
//			semmsa002Bean.setPayPeriodType01("01");
//			semmsa002Bean.getSiteElectric().setElectricType3("Y");
//			semmsa002Bean.setDisabledSiteContractNo(true);
//			semmsa002Bean.setDisabledUnitPriceAmt(true);
//			semmsa002Bean.setDisabledTakeAllAmt(true);
//			semmsa002Bean.setRenderedVatType(false);
			
		}else{
			semmsa002Bean.setDisabledElctTypeDetail(false);
		}
		setSemmsa002Bean(semmsa002Bean);
		return false;
	}
	//
	
	public void doCheckNoExpenses(){
		semmsa002Bean = getSemmsa002Bean();
		try{
			//tab3 rental
			if(semmsa002Bean.isChkRentalNoExpenses()){
				//rental one condition
				semmsa002Bean.getSiteAppObjParam().setRentAmtAdd(BigDecimal.valueOf(0));
				semmsa002Bean.getSiteAppObjParam().setRentAmtAddPerc(BigDecimal.valueOf(0));
				semmsa002Bean.getSiteAppObjParam().setRentAmt(BigDecimal.valueOf(0));
				semmsa002Bean.getSiteAppObjParam().setRentPeriodType("");
				semmsa002Bean.getSiteAppObjParam().setRentVatType("");
//				semmsa002Bean.getSiteAppObjParam().setRentWhtRate(BigDecimal.valueOf(0));
				semmsa002Bean.getSiteAppObjParam().setRentWhtType("");
				semmsa002Bean.getSiteAppObjParam().setRentPaymentPeriod("");
				semmsa002Bean.getSiteAppObjParam().setRentPaymentPeriodOth(0);
				
				semmsa002Bean.getSiteAppObjParam().setRentServAmtAdd(BigDecimal.valueOf(0));
				semmsa002Bean.getSiteAppObjParam().setRentServAmtAddPerc(BigDecimal.valueOf(0));
				semmsa002Bean.getSiteAppObjParam().setRentServiceAmt(BigDecimal.valueOf(0));
				semmsa002Bean.getSiteAppObjParam().setRentServicePeriodType("");
				semmsa002Bean.getSiteAppObjParam().setRentServiceVatType("");
//				semmsa002Bean.getSiteAppObjParam().setRentServiceWhtRate(BigDecimal.valueOf(0));
				semmsa002Bean.getSiteAppObjParam().setRentServiceWhtType("");
				semmsa002Bean.getSiteAppObjParam().setServPaymentPeriod("");
				semmsa002Bean.getSiteAppObjParam().setServPaymentPeriodOth(0);
				
				//rental meny condition
				semmsa002Bean.getSiteAppObjParam().setRentAreaAmtMemo("");
				semmsa002Bean.getSiteAppObjParam().setRentAreaMemoVatType("");
//				semmsa002Bean.getSiteAppObjParam().setRentAreaMemoWhtRate(BigDecimal.valueOf(0));
				semmsa002Bean.getSiteAppObjParam().setRentAreaMemoWhtType("");
				
				semmsa002Bean.getSiteAppObjParam().setRentServiceAmtMemo("");
				semmsa002Bean.getSiteAppObjParam().setRentServMemoVatType("");
//				semmsa002Bean.getSiteAppObjParam().setRentServMemoWhtRate(BigDecimal.valueOf(0));
				semmsa002Bean.getSiteAppObjParam().setRentServMemoWhtType("");
				
				semmsa002Bean.getSiteAppObjParam().setRentSetupAmtMemo("");
				semmsa002Bean.getSiteAppObjParam().setRentSetupMemoVatType("");
//				semmsa002Bean.getSiteAppObjParam().setRentSetupMemoWhtRate(BigDecimal.valueOf(0));
				semmsa002Bean.getSiteAppObjParam().setRentSetupMemoWhtType("");
				
				semmsa002Bean.getSiteAppObjParam().setRentOtherAmtMemo("");
				semmsa002Bean.getSiteAppObjParam().setRentOtherMemoVatType("");
//				semmsa002Bean.getSiteAppObjParam().setRentOtherMemoWhtRate(BigDecimal.valueOf(0));
				semmsa002Bean.getSiteAppObjParam().setRentOtherMemoWhtType("");
				
				//clear rental AMT
				semmsa002Bean.getSiteAppObjParam().setTotalRentService(BigDecimal.valueOf(0));
				
			}else{
				if(semmsa002Bean.isChkRentalPayOneCond()){
					semmsa002Bean.getSiteAppObjParam().setRentAreaAmtMemo("");
					semmsa002Bean.getSiteAppObjParam().setRentAreaMemoVatType("");
//					semmsa002Bean.getSiteAppObjParam().setRentAreaMemoWhtRate(BigDecimal.valueOf(0));
					semmsa002Bean.getSiteAppObjParam().setRentAreaMemoWhtType("");
					
					semmsa002Bean.getSiteAppObjParam().setRentServiceAmtMemo("");
					semmsa002Bean.getSiteAppObjParam().setRentServMemoVatType("");
//					semmsa002Bean.getSiteAppObjParam().setRentServMemoWhtRate(BigDecimal.valueOf(0));
					semmsa002Bean.getSiteAppObjParam().setRentServMemoWhtType("");
					
					semmsa002Bean.getSiteAppObjParam().setRentSetupAmtMemo("");
					semmsa002Bean.getSiteAppObjParam().setRentSetupMemoVatType("");
//					semmsa002Bean.getSiteAppObjParam().setRentSetupMemoWhtRate(BigDecimal.valueOf(0));
					semmsa002Bean.getSiteAppObjParam().setRentSetupMemoWhtType("");
					
					semmsa002Bean.getSiteAppObjParam().setRentOtherAmtMemo("");
					semmsa002Bean.getSiteAppObjParam().setRentOtherMemoVatType("");
//					semmsa002Bean.getSiteAppObjParam().setRentOtherMemoWhtRate(BigDecimal.valueOf(0));
					semmsa002Bean.getSiteAppObjParam().setRentOtherMemoWhtType("");
					
				}else if(semmsa002Bean.isChkRentalPayManyCond()){
					semmsa002Bean.getSiteAppObjParam().setRentAmtAdd(BigDecimal.valueOf(0));
					semmsa002Bean.getSiteAppObjParam().setRentAmtAddPerc(BigDecimal.valueOf(0));
					semmsa002Bean.getSiteAppObjParam().setRentAmt(BigDecimal.valueOf(0));
					semmsa002Bean.getSiteAppObjParam().setRentPeriodType("");
					semmsa002Bean.getSiteAppObjParam().setRentVatType("");
//					semmsa002Bean.getSiteAppObjParam().setRentWhtRate(BigDecimal.valueOf(0));
					semmsa002Bean.getSiteAppObjParam().setRentWhtType("");
					semmsa002Bean.getSiteAppObjParam().setRentPaymentPeriod("");
					semmsa002Bean.getSiteAppObjParam().setRentPaymentPeriodOth(0);
					
					semmsa002Bean.getSiteAppObjParam().setRentServAmtAdd(BigDecimal.valueOf(0));
					semmsa002Bean.getSiteAppObjParam().setRentServAmtAddPerc(BigDecimal.valueOf(0));
					semmsa002Bean.getSiteAppObjParam().setRentServiceAmt(BigDecimal.valueOf(0));
					semmsa002Bean.getSiteAppObjParam().setRentServicePeriodType("");
					semmsa002Bean.getSiteAppObjParam().setRentServiceVatType("");
//					semmsa002Bean.getSiteAppObjParam().setRentServiceWhtRate(BigDecimal.valueOf(0));
					semmsa002Bean.getSiteAppObjParam().setRentServiceWhtType("");
					semmsa002Bean.getSiteAppObjParam().setServPaymentPeriod("");
					semmsa002Bean.getSiteAppObjParam().setServPaymentPeriodOth(0);
					
					//clear rental AMT
					semmsa002Bean.getSiteAppObjParam().setTotalRentService(BigDecimal.valueOf(0));
				}
			
			}
			
			
			//tab4 electric
			if(semmsa002Bean.isChkNoExpenses()){
				if(!semmsa002Bean.isChkMultiElectricTypeFlag()){
					semmsa002Bean.setChkElUseOldMeter(false);
					semmsa002Bean.setChkElUseNewMeter(false);
//					semmsa002Bean.setChkElUseOwner(false);
//					semmsa002Bean.setChkNoExpenses(false);
					semmsa002Bean.setChkElUseOthSite(false);
					semmsa002Bean.setDisabledElctTypeDetail(true);
					semmsa002Bean.setDisabledElctPackageTypeDetail(true);
					semmsa002Bean.setDisabledElctUnitTypeDetail(true);
				}
//				semmsa002Bean.setChkElUseOldMeter(false);
//				semmsa002Bean.setChkElUseNewMeter(false);
//				semmsa002Bean.setChkElUseOthSite(false);
//				semmsa002Bean.setChkElUseOwner(false);
				semmsa002Bean.setChkElPayOnPackage(false);
				semmsa002Bean.setDisabledModeViewOnly(false);
				semmsa002Bean.getSiteAppObjParam().setElPackagePeriodType("");
				semmsa002Bean.setChkElOwnerType(false);
				semmsa002Bean.getSiteAppObjParam().setElUnitPrice(new BigDecimal(0));
				semmsa002Bean.setDisabledElctTypeDetail(true);
				semmsa002Bean.getSiteAppObjParam().setElPayOnPackageAmt(BigDecimal.valueOf(0));
				semmsa002Bean.getSiteAppObjParam().setElUnitPrice(BigDecimal.valueOf(0));
				semmsa002Bean.getSiteAppObjParam().setElUseOthSiteContractNo("");
				semmsa002Bean.getSiteAppObjParam().setElPackagePeriodType("");
			}else{
				if(semmsa002Bean.isChkElUseOwner()){
					if(semmsa002Bean.isChkElPayOnPackage()){
						semmsa002Bean.getSiteAppObjParam().setElUnitPrice(BigDecimal.valueOf(0));
					}else if(semmsa002Bean.isChkElOwnerType()){
						semmsa002Bean.getSiteAppObjParam().setElPayOnPackageAmt(BigDecimal.valueOf(0));
						semmsa002Bean.getSiteAppObjParam().setElPackagePeriodType("");
					}
				}else{
					semmsa002Bean.getSiteAppObjParam().setElPayOnPackageAmt(BigDecimal.valueOf(0));
					semmsa002Bean.getSiteAppObjParam().setElUnitPrice(BigDecimal.valueOf(0));
//					semmsa002Bean.getSiteAppObjParam().setElUseOthSiteContractNo("");
					semmsa002Bean.getSiteAppObjParam().setElPackagePeriodType("");
					
					
					
					
					semmsa002Bean.setDisabledElctTypeDetail(true);
					semmsa002Bean.setChkElPayOnPackage(false);
					semmsa002Bean.setChkElOwnerType(false);
					semmsa002Bean.getSiteAppObjParam().setElUnitPrice(BigDecimal.valueOf(0));
					semmsa002Bean.getSiteAppObjParam().setElPayOnPackageAmt(BigDecimal.valueOf(0));
					semmsa002Bean.getSiteAppObjParam().setElPackagePeriodType("");
					semmsa002Bean.setDisabledElctPackageTypeDetail(true);
					semmsa002Bean.setDisabledElctUnitTypeDetail(true);
				}
				
				if(!semmsa002Bean.isChkElUseOthSite()){
					semmsa002Bean.getSiteAppObjParam().setElUseOthSiteContractNo("");
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			LOG.debug("error SEMMSA002Action : "+e);
			// TODO: handle exception
		}
		setSemmsa002Bean(semmsa002Bean);
	}
	
	public void doGetOldContrant(){
		semmsa002Bean = getSemmsa002Bean();
		try{
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error from SEMMSA002Action doGetOldContrant : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	
	public void doGetOutstandingWork(){
		semmsa002Bean = getSemmsa002Bean();
		try{
			semmsa002Bean.setChgReqObjParam(new SiteAppSP());
			semmsa002Bean.setTeamList(getLovItemsByType(ELovType.T_SA_TEAM_LIST.name));
			semmsa002Bean.setMemberList(getEmptyDropDown());
			semmsa002Bean.setChkReqOfficerManualPopup(false);
			
			this.doGetReqHistSrch();
			this.doGetDocRemainSrch();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error from SEMMSA002Action doGetOutstandingWork : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	
	//added by NEW 20180528
	private boolean doSelectContractNo() {
		LOG.debug("########## Start SEMMSA002Action doSelectContractNo ###########");
		boolean flag = true;
		semmsa002Bean = getSemmsa002Bean();
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
			String remark = getFacesUtils().getRequestParameter("remark") == null ? "" : (String)getFacesUtils().getRequestParameter("remark");
			
			if(contractNo != null){
				semmsa002Bean.getSiteAppObjParam().setContractNoOld(contractNo);
			}
			
			if(StringUtils.isNotEmpty(remark)){
				addMessageError(remark);
				semmsa002Bean.setRenderedMsgFormSearch(true);
			}
			
//			popupSiteContractBean = getPopupSiteContractBean();
//			popupSiteContractBean.setContractNo(contractNo);
//			popupSiteContractBean.setRegion(region);
//			popupSiteContractBean.setSiteInfoId(siteInfoId);
//			popupSiteContractBean.setSiteName(siteName);
//			popupSiteContractBean.setCompanyId(companyId);
//			popupSiteContractBean.setEffDt(effDt);
//			popupSiteContractBean.setExpDt(expDt);
//			popupSiteContractBean.setContractId(contractId);
			
			
//			if (sendRenewId.equals("EMPTY") || StringUtils.isEmpty(sendRenewId)) {
//				popupSiteContractBean.setSendRenewId(null);
//			} else {
//				popupSiteContractBean.setSendRenewId(sendRenewId);
//			}
			
			
			//Add By Noom 12/11/2012
//			if (!StringUtils.isEmpty(popupSiteContractBean.getReqType())){
//				if (StringUtils.equalsIgnoreCase("01", popupSiteContractBean.getReqType())){
//					
//				}else if (StringUtils.equalsIgnoreCase("02", popupSiteContractBean.getReqType())){
//					
//				}
//			}
			
			
			
			//set address
//			setAddress(popupSiteContractBean);
//			if(popupSiteContractBean.getPage() != null && !popupSiteContractBean.getPage().equals("")){
//				doSearchLocationList();
//				searchContractByContractNo();
//			}
			
			// call from semmsi004tab1
//			if(popupSiteContractBean.getFromButton() != null && popupSiteContractBean.getFromButton().equals("oldContractNo")){
//				popupSiteContractBean.setOldContractNo(contractNo);
//			}
//			if(popupSiteContractBean.getFromButton() != null && popupSiteContractBean.getFromButton().equals("siteContractNo")){
//				popupSiteContractBean.setSiteContractNo(contractNo);
//				popupSiteContractBean.setSiteInfoIdForElectric(siteInfoId);
//			}
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug("########## END SEMMSA002Action doSelectContractNo ###########");
		}
//		setPopupSiteContractBean(popupSiteContractBean);
		return flag;
	}
	
	public void doInitSiteAcqServ(String mode){
		semmsa002Bean = getSemmsa002Bean();
		List<WrapperBeanObject<SiteAppRegHistSrch>> siteAppServList = new ArrayList<WrapperBeanObject<SiteAppRegHistSrch>>();
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteAppRegHistSrch> to = null;
		try{
//			siteAppServList = 
			semmsa002Bean.getSiteAppObjParam().setMode(mode);
				
			to = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA002_SITE_APP_SERVICE.name, semmsa002Bean.getSiteAppObjParam());
			LOG.debug("size [" + to.size() + "]");
			
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsa002Bean.setRenderedMsgDataNotFound(true);
				
				if(StringUtils.equals("E", mode.toUpperCase())){
					semmsa002Bean.setSiteAppExtServList(null);
				}else if(StringUtils.equals("C",  mode.toUpperCase())){
					semmsa002Bean.setSiteAppCurrServList(null);
				}else if(StringUtils.equals("A",  mode.toUpperCase())){
					semmsa002Bean.setSiteAppServList(null);
				}
				
			}
			
			if(to != null && to.size() > 0){
//				flag = true;
				semmsa002Bean.setRenderedMsgDataNotFound(false);

				if(StringUtils.equals("E", mode.toUpperCase())){
					semmsa002Bean.setSiteAppExtServList(new ArrayList<WrapperBeanObject<SiteAppRegHistSrch>>());
				}else if(StringUtils.equals("C",  mode.toUpperCase())){
					semmsa002Bean.setSiteAppCurrServList(new ArrayList<WrapperBeanObject<SiteAppRegHistSrch>>());
				}else if(StringUtils.equals("A",  mode.toUpperCase())){
					semmsa002Bean.setSiteAppServList(new ArrayList<WrapperBeanObject<SiteAppRegHistSrch>>());
				}
				
				for (int i = 0; i < to.size(); i++) {
					SiteAppRegHistSrch siteAcq = (SiteAppRegHistSrch) to.get(i);
					WrapperBeanObject<SiteAppRegHistSrch> tmpWrapperBean = new WrapperBeanObject<SiteAppRegHistSrch>();
					
					if(siteAcq != null){
						if(siteAcq.getCreateDt() != null) {
							siteAcq.setCreateDtStr(convertYearENtoTHStr(siteAcq.getCreateDt()));
						}
						if(siteAcq.getUpdateDt() != null){
							siteAcq.setUpdateDtStr(convertYearENtoTHStr(siteAcq.getUpdateDt()));
						}
					}
					
					tmpWrapperBean.setDataObj(siteAcq);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					
					if(StringUtils.equals("E", mode.toUpperCase())){
						semmsa002Bean.getSiteAppExtServList().add(tmpWrapperBean);
					}else if(StringUtils.equals("C",  mode.toUpperCase())){
						semmsa002Bean.getSiteAppCurrServList().add(tmpWrapperBean);
					}else if(StringUtils.equals("A",  mode.toUpperCase())){
						semmsa002Bean.getSiteAppServList().add(tmpWrapperBean);
					}
					
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doInitSiteAcqExtServ : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
		}
	}

	public void doGetSiteContractMasterInfo(){
		LOG.info(" ### Start doGetSiteContractMasterInfo ###");
		semmsa002Bean = getSemmsa002Bean();
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteAppSP> to = null;
		try{
			
			to = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA002_SITE_APP_MASTER_SRCH.name, semmsa002Bean.getSiteAppObjParam());
			LOG.debug("size [" + to.size() + "]");
			
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsa002Bean.setRenderedMsgDataNotFound(true);
				semmsa002Bean.setSiteContInfo(null);
				
			}
			
			if(to != null && to.size() > 0){
//				flag = true;
				semmsa002Bean.setRenderedMsgDataNotFound(false);

				semmsa002Bean.setSiteContInfo(new SiteAppSP());
				
				for (int i = 0; i < to.size(); i++) {
					SiteAppSP siteAcq = (SiteAppSP) to.get(i);
//					WrapperBeanObject<SiteAppRegHistSrch> tmpWrapperBean = new WrapperBeanObject<SiteAppRegHistSrch>();
					
					if(siteAcq.getNoExpFlag() != null){
						if(StringUtils.equals("Y", siteAcq.getNoExpFlag().toUpperCase())){
							semmsa002Bean.setNoExpFlag(true);
						}else{
							semmsa002Bean.setNoExpFlag(false);
						}
					}else{
						semmsa002Bean.setNoExpFlag(false);
					}
					
					if(siteAcq != null){
						semmsa002Bean.setSiteContInfo(siteAcq);
					}
					
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doGetSiteContractMasterInfo : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.info(" ### End doGetSiteContractMasterInfo ###");
		}
	}
	
	public void doGetSiteAppRentContExisting(){
		LOG.debug(" #### Start SEMMSA002Action doGetSiteAppRentContExisting ####");
		semmsa002Bean = getSemmsa002Bean();
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteAppSP> to = null;
		try{
			LOG.debug("doGetSiteAppRentCont getSiteAppId :"+semmsa002Bean.getSiteAppObjParam().getSiteAppId());
			semmsa002Bean.getSiteAppObjParam().setRentContMode("H");
			to = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA002_SITE_APP_RENT_CONT_SRCH.name, semmsa002Bean.getSiteAppObjParam());
			LOG.debug("size [" + to.size() + "]");
			
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsa002Bean.setRenderedMsgDataNotFound(true);
				semmsa002Bean.setSiteAppRentContExisting(new ArrayList<WrapperBeanObject<SiteAppSP>>());
			}
			
			if(to != null && to.size() > 0){
//				flag = true;
				semmsa002Bean.setRenderedMsgDataNotFound(false);

				semmsa002Bean.setSiteAppRentContExisting(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				
				for (int i = 0; i < to.size(); i++) {
					SiteAppSP siteAcq = (SiteAppSP) to.get(i);
					WrapperBeanObject<SiteAppSP> tmpWrapperBean = new WrapperBeanObject<SiteAppSP>();
					
					if(siteAcq.getNoExpFlag() != null){
						if(StringUtils.equals("Y", siteAcq.getNoExpFlag().toUpperCase())){
							semmsa002Bean.setNoExpFlag(true);
						}else{
							semmsa002Bean.setNoExpFlag(false);
						}
					}else{
						semmsa002Bean.setNoExpFlag(false);
					}
					
					
					if(siteAcq.getPeriodStartDt() != null){
						siteAcq.setPeriodStartDtStr(convertYearENtoTHStr(siteAcq.getPeriodStartDt()));
					}
					
					if(siteAcq.getPeriodEndDt() != null){
						siteAcq.setPeriodEndDtStr(convertYearENtoTHStr(siteAcq.getPeriodEndDt()));
					}
					
					if(siteAcq.getEffectiveDt() != null){
						siteAcq.setEffectiveDtStr(convertYearENtoTHStr(siteAcq.getEffectiveDt()));
					}
					
					if(siteAcq.getStartDt() != null){
						siteAcq.setStartDtStr(convertYearENtoTHStr(siteAcq.getStartDt()));
					}
					
					if(siteAcq.getEndDt() != null){
						siteAcq.setEndDtStr(convertYearENtoTHStr(siteAcq.getEndDt()));
					}
					
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					tmpWrapperBean.setDataObj(siteAcq);
					
					if(siteAcq != null){
						semmsa002Bean.getSiteAppRentContExisting().add(tmpWrapperBean);
					}
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doGetSiteAppRentContExisting : "+e);
		}finally{
			LOG.debug(" #### End SEMMSA002Action doGetSiteAppRentContExisting ####");
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	
	public void doGetSiteAppRentCont(){
		LOG.debug(" #### Start SEMMSA002Action doGetSiteAppRentCont ####");
		semmsa002Bean = getSemmsa002Bean();
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteAppSP> to = null;
		try{
			LOG.debug("doGetSiteAppRentCont getSiteAppId :"+semmsa002Bean.getSiteAppObjParam().getSiteAppId());
			semmsa002Bean.getSiteAppObjParam().setRentContMode("C");
			to = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA002_SITE_APP_RENT_CONT_SRCH.name, semmsa002Bean.getSiteAppObjParam());
			LOG.debug("size [" + to.size() + "]");
			
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsa002Bean.setRenderedMsgDataNotFound(true);
				semmsa002Bean.setSiteAppRentCont(new ArrayList<WrapperBeanObject<SiteAppSP>>());
			}
			
			if(to != null && to.size() > 0){
//				flag = true;
				semmsa002Bean.setRenderedMsgDataNotFound(false);

				semmsa002Bean.setSiteAppRentCont(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				
				for (int i = 0; i < to.size(); i++) {
					SiteAppSP siteAcq = (SiteAppSP) to.get(i);
					WrapperBeanObject<SiteAppSP> tmpWrapperBean = new WrapperBeanObject<SiteAppSP>();
					
					if(siteAcq.getNoExpFlag() != null){
						if(StringUtils.equals("Y", siteAcq.getNoExpFlag().toUpperCase())){
							semmsa002Bean.setNoExpFlag(true);
						}else{
							semmsa002Bean.setNoExpFlag(false);
						}
					}else{
						semmsa002Bean.setNoExpFlag(false);
					}
					
					
					if(siteAcq.getPeriodStartDt() != null){
						siteAcq.setPeriodStartDtStr(convertYearENtoTHStr(siteAcq.getPeriodStartDt()));
					}
					
					if(siteAcq.getPeriodEndDt() != null){
						siteAcq.setPeriodEndDtStr(convertYearENtoTHStr(siteAcq.getPeriodEndDt()));
					}
					
					if(siteAcq.getEffectiveDt() != null){
						siteAcq.setEffectiveDtStr(convertYearENtoTHStr(siteAcq.getEffectiveDt()));
					}
					
					if(siteAcq.getStartDt() != null){
						siteAcq.setStartDtStr(convertYearENtoTHStr(siteAcq.getStartDt()));
					}
					
					if(siteAcq.getEndDt() != null){
						siteAcq.setEndDtStr(convertYearENtoTHStr(siteAcq.getEndDt()));
					}
					
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					tmpWrapperBean.setDataObj(siteAcq);
					
					///LOG.debug("siteAcq.expenseDesc : "+siteAcq.);
					
					if(siteAcq != null){
						semmsa002Bean.getSiteAppRentCont().add(tmpWrapperBean);
					}
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doGetSiteAppRentCont : "+e);
		}finally{
			LOG.debug(" #### End SEMMSA002Action doGetSiteAppRentCont ####");
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	
	public boolean doValidateRentCond(){
		LOG.debug(" #### Start SEMMSA002Action doValidateRentCond ####");
		boolean flag = true;
		semmsa002Bean = getSemmsa002Bean();
		try{
			if(!semmsa002Bean.isChkRentalNoExpenses()){
				if(StringUtils.isEmpty(semmsa002Bean.getSiteAppRentObjParam().getExpenseType())){
					flag = false;
					addMessageError("W0001", msg("label.exp"));
					semmsa002Bean.setRenderedMsgFormChkExpire(true);
				}
				
				if(semmsa002Bean.getSiteAppRentObjParam().getRentAmt() != null && 
						semmsa002Bean.getSiteAppRentObjParam().getRentAmt().intValue() > 0){
					if(StringUtils.isEmpty(semmsa002Bean.getSiteAppRentObjParam().getRentPeriodType())){
						flag = false;
						addMessageError("W0001", msg("label.rentperiod"));
						semmsa002Bean.setRenderedMsgFormChkExpire(true);
					}
				}
				
				if(StringUtils.equals("03", semmsa002Bean.getPayPeriodType03())){
					
					if(semmsa002Bean.getPayPeriod03() == null || semmsa002Bean.getPayPeriod03()<1){
						flag = false;
						addMessageError("W0001", msg("msg.error.payperiodM"));
						semmsa002Bean.setRenderedMsgFormChkExpire(true);
					}
					
				}
				
				if(StringUtils.equals("04", semmsa002Bean.getPayPeriodType04())){
					
					if(semmsa002Bean.getPayPeriod04() == null || semmsa002Bean.getPayPeriod04()<1){
						flag = false;
						addMessageError("W0001", msg("msg.error.payperiodY"));
						semmsa002Bean.setRenderedMsgFormChkExpire(true);
					}
					
				}
				
				if(StringUtils.equals("03", semmsa002Bean.getSiteAppObjParam().getReqType())){
					if(semmsa002Bean.getSiteAppRentObjParam().getEffectiveDt() != null){
						if(semmsa002Bean.getSiteAppRentObjParam().getEffectiveDt().before(semmsa002Bean.getSiteAppObjParam().getEffectiveDt())){
							flag = false;
							addMessageErrorWithArgument("W0006", msg("msg.effdate"), msg("message.contractEffDate") );
							semmsa002Bean.setRenderedMsgFormChkExpire(true);
						}
						
						if(semmsa002Bean.getSiteAppRentObjParam().getEffectiveDt().after(semmsa002Bean.getSiteAppObjParam().getExpireDt())){
							flag = false;
							addMessageErrorWithArgument("W0122", msg("msg.effdate"), msg("message.contractExpDate") );
							semmsa002Bean.setRenderedMsgFormChkExpire(true);
						}
					}else{
						if(semmsa002Bean.getSiteAppObjParam().getEffectiveDt() != null){
							semmsa002Bean.getSiteAppRentObjParam().setEffectiveDt(semmsa002Bean.getSiteAppObjParam().getEffectiveDt());
						}
						
					}
				}	
				
				// add logic on 22/02/2023
				if(StringUtils.equals("03", semmsa002Bean.getSiteAppRentObjParam().getExpenseType()) ){
					
					if (StringUtils.isEmpty(semmsa002Bean.getSiteAppRentObjParam().getExpenseDesc())){
					    addMessageError("W0001",msg("msg.error.expenseDesc"));
					    flag = false;
					    semmsa002Bean.setRenderedMsgFormChkExpire(true);
					}
					else if (semmsa002Bean.getSiteAppRentObjParam().getExpenseDesc().length()>=100) {
						addMessageError("W0001",msg("msg.error.expenseDesc.Length"));
						 flag = false;
						 semmsa002Bean.setRenderedMsgFormChkExpire(true);
					}
					
				
				}else semmsa002Bean.getSiteAppRentObjParam().setExpenseDesc(null);
				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error(" #### Error SEMMSA002Action doValidateRentCond : "+e);
		}
		LOG.debug(" #### Start SEMMSA002Action doValidateRentCond ####");
		setSemmsa002Bean(semmsa002Bean);
		return flag;
	}
	
	public boolean doAddSiteAppRentCont(){
		LOG.debug(" #### Start SEMMSA002Action doAddSiteAppRentCont ####");
		boolean flag = false;
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		semmsa002Bean = getSemmsa002Bean();
		List<SiteAppSP> to = null;
		String siteAppId = "";
		try{
			siteAppId = semmsa002Bean.getSiteAppObjParam().getSiteAppId();
			
			
			if(this.doValidateRentCond()){
				semmsa002Bean.getSiteAppRentObjParam().setSiteAppId(siteAppId);
				semmsa002Bean.getSiteAppRentObjParam().setUserId(getUserLogIn());
				if(semmsa002Bean.isChkRentalNoExpenses()){
					semmsa002Bean.getSiteAppRentObjParam().setRentalNoExpenses("Y");
				}else{
					semmsa002Bean.getSiteAppRentObjParam().setRentalNoExpenses("");
				}
				
				LOG.debug("siteAppId : "+semmsa002Bean.getSiteAppRentObjParam().getSiteAppId());
				LOG.debug("expenseType : "+semmsa002Bean.getSiteAppRentObjParam().getExpenseType());
				LOG.debug("rentDetail : "+semmsa002Bean.getSiteAppRentObjParam().getRentDetail());
				LOG.debug("rentAmtOld : "+semmsa002Bean.getSiteAppRentObjParam().getRentAmtOld());
				LOG.debug("rentAmtAddPerc : "+semmsa002Bean.getSiteAppRentObjParam().getRentAmtAddPerc());
				LOG.debug("rentAmtAdd : "+semmsa002Bean.getSiteAppRentObjParam().getRentAmtAdd());
				LOG.debug("rentAmt : "+semmsa002Bean.getSiteAppRentObjParam().getRentAmt());
				LOG.debug("rentPeriodType : "+semmsa002Bean.getSiteAppRentObjParam().getRentPeriodType());
				LOG.debug("rentWhtType : "+semmsa002Bean.getSiteAppRentObjParam().getRentWhtType());
				LOG.debug("rentWhtRate : "+semmsa002Bean.getSiteAppRentObjParam().getRentWhtRate());
				LOG.debug("rentVatType : "+semmsa002Bean.getSiteAppRentObjParam().getRentVatType());
				LOG.debug("rentPaymentPeriod : "+semmsa002Bean.getSiteAppRentObjParam().getRentPaymentPeriod());
				LOG.debug("rentPaymentPeriodOth : "+semmsa002Bean.getSiteAppRentObjParam().getRentPaymentPeriodOth());
				LOG.debug("periodStartDt : "+semmsa002Bean.getSiteAppRentObjParam().getPeriodStartDt());
				LOG.debug("periodEndDt : "+semmsa002Bean.getSiteAppRentObjParam().getPeriodEndDt());
				LOG.debug("effectiveDt : "+semmsa002Bean.getSiteAppRentObjParam().getEffectiveDt());
				LOG.debug("rentAdj : "+semmsa002Bean.getSiteAppRentObjParam().getRentAdj());
				LOG.debug("rentAdjPeriodType : "+semmsa002Bean.getSiteAppRentObjParam().getRentAdjPeriodType());
				LOG.debug("serviceId : "+semmsa002Bean.getSiteAppRentObjParam().getServiceId());
				LOG.debug("rentCondType : "+semmsa002Bean.getSiteAppRentObjParam().getRentCondType());
				LOG.debug("rentOldPeriodType : "+semmsa002Bean.getSiteAppRentObjParam().getRentOldPeriodType());
				LOG.debug("rentAddPeriodType : "+semmsa002Bean.getSiteAppRentObjParam().getRentAddPeriodType());
				LOG.debug("refSiteRentCondId : "+semmsa002Bean.getSiteAppRentObjParam().getRefSiteRentCondId());
				LOG.debug("userId : "+semmsa002Bean.getSiteAppRentObjParam().getUserId());
				LOG.debug("rentalNoExpenses : "+semmsa002Bean.getSiteAppRentObjParam().getRentalNoExpenses());
				LOG.debug("expenseDesc : "+semmsa002Bean.getSiteAppRentObjParam().getExpenseDesc());
				
				
				to = service.siteAppDao_querySPList(EQueryName.SP_MSA002_SITE_APP_RENT_COND_INS.name, semmsa002Bean.getSiteAppRentObjParam());
				
				if (to != null && !to.isEmpty()) {
					String retMsg = to.get(0).getRetResultMsg() == null ? "" : to.get(0).getRetResultMsg().toString();
					
					if (to.get(0).getRetResult().equals("Success")) {

						
						String myMsgArr[];
						if(!retMsg.equals("")){
							myMsgArr = retMsg.split("<BR/>");
							
							for(int i=0; i < myMsgArr.length; i++){
								//addGeneralMessageInfo(myMsgArr[i]);
								//addGeneralMessageWarn(myMsgArr[i]);
								FrontMessageUtils.addMessageWarn(myMsgArr[i]);	// optional
							}
						}
//						this.doGetSiteAppRentCont();
						
						if(StringUtils.equals("H", semmsa002Bean.getSiteAppRentObjParam().getRentContMode())){
							this.doGetSiteAppRentContExisting();
						}else{
							this.doGetSiteAppRentCont();
						}
						
						//get rent total
						this.doGetSiteAppRentAmtSrch();
						
						//get rent serv 
						this.doGetSiteAppRentServSrch();
						
						flag = true;
						//TODO clear save param obj
						this.doClearSiteAppRentCont();
						
						semmsa002Bean.setChkRentAmtAdd(false);
						semmsa002Bean.setChkService(false);
						semmsa002Bean.setChkRentalNoExpenses(false);
						semmsa002Bean.setRenderedMsgAlert(true);
					} else {
						if(to.get(0).getRetResult() != null){
							if("FAIL".equals(to.get(0).getRetResult().toUpperCase())){
								semmsa002Bean.setDisabledButtonPopupResult(false);
							}else if("FAIL2".equals(to.get(0).getRetResult().toUpperCase())){
								semmsa002Bean.setDisabledButtonPopupResult(true);
							}
							
						}
//						System.out.println("to.get(0).getRetResultMsg() = "+to.get(0).getRetResultMsg());
						if(to.get(0).getRetResultMsg() != null)
							addGeneralMessageError(to.get(0).getRetResultMsg());	// data save fail
						else
							addMessageError("E0001");	// data save fail
		        		semmsa002Bean.setRenderedMsgAlert(true);
					}
				}
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doAddSiteAppRentCont : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
		}
		LOG.debug(" #### End SEMMSA002Action doAddSiteAppRentCont ####");
		return flag;
	}
	
	public boolean doUpdateSiteAppRentCont(){
		LOG.debug(" #### Start SEMMSA002Action doUpdateSiteAppRentCont ####");
		boolean flag = false;
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteAppSP> to = null;
		try{
			
			
			if(this.doValidateRentCond()){
				semmsa002Bean.getSiteAppRentObjParam().setUserId(getUserLogIn());
				if(semmsa002Bean.isChkRentalNoExpenses()){
					semmsa002Bean.getSiteAppRentObjParam().setRentalNoExpenses("Y");
				}else{
					semmsa002Bean.getSiteAppRentObjParam().setRentalNoExpenses("");
				}
				
				LOG.debug("SiteAppRentContId : "+semmsa002Bean.getSiteAppRentObjParam().getSiteAppRentContId());
				LOG.debug("siteAppId : "+semmsa002Bean.getSiteAppRentObjParam().getSiteAppId());
				LOG.debug("expenseType : "+semmsa002Bean.getSiteAppRentObjParam().getExpenseType());
				LOG.debug("rentDetail : "+semmsa002Bean.getSiteAppRentObjParam().getRentDetail());
				LOG.debug("rentAmtOld : "+semmsa002Bean.getSiteAppRentObjParam().getRentAmtOld());
				LOG.debug("rentAmtAddPerc : "+semmsa002Bean.getSiteAppRentObjParam().getRentAmtAddPerc());
				LOG.debug("rentAmtAdd : "+semmsa002Bean.getSiteAppRentObjParam().getRentAmtAdd());
				LOG.debug("rentAmt : "+semmsa002Bean.getSiteAppRentObjParam().getRentAmt());
				LOG.debug("rentPeriodType : "+semmsa002Bean.getSiteAppRentObjParam().getRentPeriodType());
				LOG.debug("rentWhtType : "+semmsa002Bean.getSiteAppRentObjParam().getRentWhtType());
				LOG.debug("rentWhtRate : "+semmsa002Bean.getSiteAppRentObjParam().getRentWhtRate());
				LOG.debug("rentVatType : "+semmsa002Bean.getSiteAppRentObjParam().getRentVatType());
				LOG.debug("rentPaymentPeriod : "+semmsa002Bean.getSiteAppRentObjParam().getRentPaymentPeriod());
				LOG.debug("rentPaymentPeriodOth : "+semmsa002Bean.getSiteAppRentObjParam().getRentPaymentPeriodOth());
				LOG.debug("periodStartDt : "+semmsa002Bean.getSiteAppRentObjParam().getPeriodStartDt());
				LOG.debug("periodEndDt : "+semmsa002Bean.getSiteAppRentObjParam().getPeriodEndDt());
				LOG.debug("effectiveDt : "+semmsa002Bean.getSiteAppRentObjParam().getEffectiveDt());
				LOG.debug("rentAdj : "+semmsa002Bean.getSiteAppRentObjParam().getRentAdj());
				LOG.debug("rentAdjPeriodType : "+semmsa002Bean.getSiteAppRentObjParam().getRentAdjPeriodType());
				LOG.debug("serviceId : "+semmsa002Bean.getSiteAppRentObjParam().getServiceId());
				LOG.debug("rentCondType : "+semmsa002Bean.getSiteAppRentObjParam().getRentCondType());
				LOG.debug("rentOldPeriodType : "+semmsa002Bean.getSiteAppRentObjParam().getRentOldPeriodType());
				LOG.debug("rentAddPeriodType : "+semmsa002Bean.getSiteAppRentObjParam().getRentAddPeriodType());
				LOG.debug("refSiteRentCondId : "+semmsa002Bean.getSiteAppRentObjParam().getRefSiteRentCondId());
				LOG.debug("userId : "+semmsa002Bean.getSiteAppRentObjParam().getUserId());
				LOG.debug("rentalNoExpenses : "+semmsa002Bean.getSiteAppRentObjParam().getRentalNoExpenses());
				
				to = service.siteAppDao_querySPList(EQueryName.SP_MSA002_SITE_APP_RENT_COND_UPD.name, semmsa002Bean.getSiteAppRentObjParam());
				
				if (to != null && !to.isEmpty()) {
					String retMsg = to.get(0).getRetResultMsg() == null ? "" : to.get(0).getRetResultMsg().toString();
					
					if (to.get(0).getRetResult().equals("Success")) {

						
						String myMsgArr[];
						if(!retMsg.equals("")){
							myMsgArr = retMsg.split("<BR/>");
							
							for(int i=0; i < myMsgArr.length; i++){
								//addGeneralMessageInfo(myMsgArr[i]);
								//addGeneralMessageWarn(myMsgArr[i]);
								FrontMessageUtils.addMessageWarn(myMsgArr[i]);	// optional
							}
						}
//						this.doGetSiteAppRentCont();
						
						if(StringUtils.equals("H", semmsa002Bean.getSiteAppRentObjParam().getRentContMode())){
							this.doGetSiteAppRentContExisting();
						}else {
							this.doGetSiteAppRentCont();
						}
						
						//get rent total
						this.doGetSiteAppRentAmtSrch();
						
						//get rent serv 
						this.doGetSiteAppRentServSrch();
						
						flag = true;
						
						//TODO clear save param obj
						this.doClearSiteAppRentCont();
						
						semmsa002Bean.setChkRentAmtAdd(false);
						semmsa002Bean.setChkService(false);
						semmsa002Bean.setChkRentalNoExpenses(false);
						semmsa002Bean.setRenderedMsgAlert(true);
					} else {
						if(to.get(0).getRetResult() != null){
							if("FAIL".equals(to.get(0).getRetResult().toUpperCase())){
								semmsa002Bean.setDisabledButtonPopupResult(false);
							}else if("FAIL2".equals(to.get(0).getRetResult().toUpperCase())){
								semmsa002Bean.setDisabledButtonPopupResult(true);
							}
							
						}
//						System.out.println("to.get(0).getRetResultMsg() = "+to.get(0).getRetResultMsg());
						if(to.get(0).getRetResultMsg() != null)
							addGeneralMessageError(to.get(0).getRetResultMsg());	// data save fail
						else
							addMessageError("E0001");	// data save fail
		        		semmsa002Bean.setRenderedMsgAlert(true);
					}
				}
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doUpdateSiteAppRentCont : "+e);
		}
		LOG.debug(" #### End SEMMSA002Action doUpdateSiteAppRentCont ####");
		return flag;
	}
	
	public boolean doClearSiteAppRentCont(){
		LOG.debug(" #### Start SEMMSA002Action doClearSiteAppRentCont ####");
		semmsa002Bean = getSemmsa002Bean();
		try{
			semmsa002Bean.setSiteAppRentObjParam(new SiteAppSP());
			//set default rent PeriodStartDt
			if(semmsa002Bean.getSiteAppObjParam().getEffectiveDt() != null)
				semmsa002Bean.getSiteAppRentObjParam().setPeriodStartDt(semmsa002Bean.getSiteAppObjParam().getEffectiveDt());
			
			//set default rent setPeriodEndDt
			if(semmsa002Bean.getSiteAppObjParam().getExpireDt() != null)
				semmsa002Bean.getSiteAppRentObjParam().setPeriodEndDt(semmsa002Bean.getSiteAppObjParam().getExpireDt());
			
			//set default rental No Vat
			semmsa002Bean.getSiteAppRentObjParam().setRentVatType("04");
			
			setSemmsa002Bean(semmsa002Bean);
			this.initUpdateRentCond();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doClearSiteAppRentCont : "+e);
		}
		LOG.debug(" #### End SEMMSA002Action doClearSiteAppRentCont ####");
		return true;
	}
	
	public boolean doInitDetSiteAppRentCont(){
		LOG.debug(" #### Start SEMMSA002Action doInitDetSiteAppRentCont #### ");
		semmsa002Bean = getSemmsa002Bean();
		boolean flag = true;
		
		try{
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("Error SEMMSA002Action doInitDetSiteAppRentCont : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" #### End SEMMSA002Action doInitDetSiteAppRentCont #### ");
		}
		return flag;
	}
	
	public boolean doDetSiteAppRentCont(){
		LOG.debug(" #### Start SEMMSA002Action doDetSiteAppRentCont #### ");
		boolean flag = false;
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteAppSP> to = null;
		SiteAppSP siteAppObj = new SiteAppSP();
		try{
			//TODO get param
			String siteRentCondId = getFacesUtils().getRequestParameter("siteAppRentContId") == null ? "" : (String)getFacesUtils().getRequestParameter("siteAppRentContId");
			String siteAppId = getFacesUtils().getRequestParameter("siteAppId") == null ? "" : (String)getFacesUtils().getRequestParameter("siteAppId");
			String expenseType = getFacesUtils().getRequestParameter("expenseType") == null ? "" : (String)getFacesUtils().getRequestParameter("expenseType");
			String serviceId = getFacesUtils().getRequestParameter("serviceId") == null ? "" : (String)getFacesUtils().getRequestParameter("serviceId");
			String siteAppRentContMode = getFacesUtils().getRequestParameter("siteAppRentContMode") == null ? "" : (String)getFacesUtils().getRequestParameter("siteAppRentContMode");
			String userId = getUserLogIn();
			
			
			siteAppObj.setSiteAppRentContId(siteRentCondId);
			siteAppObj.setSiteAppId(siteAppId);
			siteAppObj.setExpenseType(expenseType);
			siteAppObj.setServiceId(serviceId);
			siteAppObj.setUserId(userId);
			
			to = service.siteAppDao_querySPList(EQueryName.SP_MSA002_SITE_APP_RENT_COND_DEL.name, siteAppObj);
			
			if (to != null && !to.isEmpty()) {
				String retMsg = to.get(0).getRetResultMsg() == null ? "" : to.get(0).getRetResultMsg().toString();
				
				if (to.get(0).getRetResult().equals("Success")) {

					
					String myMsgArr[];
					if(!retMsg.equals("")){
						myMsgArr = retMsg.split("<BR/>");
						
						for(int i=0; i < myMsgArr.length; i++){
							//addGeneralMessageInfo(myMsgArr[i]);
							//addGeneralMessageWarn(myMsgArr[i]);
							FrontMessageUtils.addMessageWarn(myMsgArr[i]);	// optional
						}
					}else{
						addMessageInfo("M0001");
						
					}
					
					if(StringUtils.equals("H", siteAppRentContMode)){
						this.doGetSiteAppRentContExisting();
					}else if(StringUtils.equals("C", siteAppRentContMode)){
						this.doGetSiteAppRentCont();
					}
					
					//get rent total
					this.doGetSiteAppRentAmtSrch();
					
					//get rent serv 
					this.doGetSiteAppRentServSrch();
					
					flag = true;
					semmsa002Bean.setRenderedMsgAlert(true);
				} else {
					if(to.get(0).getRetResult() != null){
						if("FAIL".equals(to.get(0).getRetResult().toUpperCase())){
							semmsa002Bean.setDisabledButtonPopupResult(false);
						}else if("FAIL2".equals(to.get(0).getRetResult().toUpperCase())){
							semmsa002Bean.setDisabledButtonPopupResult(true);
						}
						
					}
//					System.out.println("to.get(0).getRetResultMsg() = "+to.get(0).getRetResultMsg());
					if(to.get(0).getRetResultMsg() != null)
						addGeneralMessageError(to.get(0).getRetResultMsg());	// data save fail
					else
						addMessageError("E0001");	// data save fail
	        		semmsa002Bean.setRenderedMsgAlert(true);
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doDetSiteAppRentCont : "+e);
		}
		LOG.debug(" #### End SEMMSA002Action doDetSiteAppRentCont #### ");
		return flag;
	}
	
	public void doGetSiteAppRentServSrch(){
		LOG.debug(" #### Start SEMMSA002Action doGetSiteAppRentServSrch ####");
		semmsa002Bean = getSemmsa002Bean();
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteAppSP> to = null;
		try{
			
			to = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA002_SITE_APP_RENT_SERV_SRCH.name, semmsa002Bean.getSiteAppObjParam());
			LOG.debug("size [" + to.size() + "]");
			
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsa002Bean.setRenderedMsgDataNotFound(true);
				semmsa002Bean.setSiteAppRentServList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
			}
			
			if(to != null && to.size() > 0){
//				flag = true;
				semmsa002Bean.setRenderedMsgDataNotFound(false);

				semmsa002Bean.setSiteAppRentServList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				
				for (SiteAppSP siteAcq : to) {
//					SiteAppSP siteAcq = (SiteAppSP) to.get(i);
					WrapperBeanObject<SiteAppSP> tmpWrapperBean = new WrapperBeanObject<SiteAppSP>();
					
//					if(siteAcq.getNoExpFlag() != null){
//						if(StringUtils.equals("Y", siteAcq.getNoExpFlag().toUpperCase())){
//							semmsa002Bean.setNoExpFlag(true);
//						}else{
//							semmsa002Bean.setNoExpFlag(false);
//						}
//					}else{
//						semmsa002Bean.setNoExpFlag(false);
//					}
					
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					tmpWrapperBean.setDataObj(siteAcq);
					
					if(siteAcq != null){
						semmsa002Bean.getSiteAppRentServList().add(tmpWrapperBean);
					}
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doGetSiteAppRentServSrch : "+e);
		}finally{
			LOG.debug(" #### End SEMMSA002Action doGetSiteAppRentServSrch ####");
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	
	public void doGetSiteAppRentAmtSrch(){
		LOG.debug(" #### Start SEMMSA002Action doGetSiteAppRentAmtSrch ####");
		semmsa002Bean = getSemmsa002Bean();
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteAppSP> to = null;
		try{
			
			to = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA002_SITE_APP_RENT_SRCH.name, semmsa002Bean.getSiteAppObjParam());
			LOG.debug("size [" + to.size() + "]");
			
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsa002Bean.setRenderedMsgDataNotFound(true);
				semmsa002Bean.setSiteAppRentAmt(new SiteAppSP());
			}
			
			if(to != null && to.size() > 0){
				
				/* begin remove on 24/02/2023  by Siriporn 
				 * 
				if(to.get(0).getRowId() != null && StringUtils.equals("0", to.get(0).getRowId())){
					// set data not found message
					// semmsa002Bean.setRenderedMsgDataNotFound(true);
					// semmsa002Bean.setSiteAppRentAmt(new SiteAppSP());
				}else{
				
				end remove on 24/02/2023  by Siriporn */

//					flag = true;
					semmsa002Bean.setRenderedMsgDataNotFound(false);

//					semmsa002Bean.setSiteAppRentServList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
					semmsa002Bean.setSiteAppRentAmt(new SiteAppSP());
					
					for (SiteAppSP siteAcq : to) {
//						SiteAppSP siteAcq = (SiteAppSP) to.get(i);
						WrapperBeanObject<SiteAppSP> tmpWrapperBean = new WrapperBeanObject<SiteAppSP>();
						
//						if(siteAcq.getNoExpFlag() != null){
//							if(StringUtils.equals("Y", siteAcq.getNoExpFlag().toUpperCase())){
//								semmsa002Bean.setNoExpFlag(true);
//							}else{
//								semmsa002Bean.setNoExpFlag(false);
//							}
//						}else{
//							semmsa002Bean.setNoExpFlag(false);
//						}
						if(siteAcq.getRentService() != null)
							siteAcq.setRentServiceAmt(BigDecimal.valueOf(Double.parseDouble(siteAcq.getRentService())));
						
						if(siteAcq.getSupport() != null)
							siteAcq.setSupportAmt(BigDecimal.valueOf(Double.parseDouble(siteAcq.getSupport())));
						
						if(siteAcq.getDonate() != null)
							siteAcq.setDonateAmt(BigDecimal.valueOf(Double.parseDouble(siteAcq.getDonate())));
						
						if(siteAcq.getOther() != null)
							siteAcq.setOtherPaymentAmt(BigDecimal.valueOf(Double.parseDouble(siteAcq.getOther())));
						
						if(siteAcq.getAll() != null)
							siteAcq.setAllPaymentAmt(BigDecimal.valueOf(Double.parseDouble(siteAcq.getAll())));
						
						tmpWrapperBean.setMessage("");
						tmpWrapperBean.setCheckBox(false);
						tmpWrapperBean.setDataObj(siteAcq);
						
						if(siteAcq != null){
							semmsa002Bean.setSiteAppRentAmt(siteAcq);
						}
					}  
				//} remove on 24/02/2023  by Siriporn
				
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doGetSiteAppRentAmtSrch : "+e);
		}finally{
			LOG.debug(" #### End SEMMSA002Action doGetSiteAppRentAmtSrch ####");
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	
	public void doGetDocTypeSelectItem(){
		LOG.debug(" ### START SEMMSA002Action doGetDocTypeSelectItem ### ");
		semmsa002Bean = getSemmsa002Bean();
		try{
			String placeType = semmsa002Bean.getSiteAppObjParam().getPlaceType();
			LOG.debug("semmsa002Bean.getSiteAppObjParam().getPlaceType() =: "+semmsa002Bean.getSiteAppObjParam().getPlaceType());
			
			if(placeType != null){
				semmsa002Bean.setDocTypeList(getLovItemsByType(ELovType.T_SI_LEGAL_DOC_TYPE.name, EX_IN, placeType, null, "Y"));
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug(" ### Error SEMMSA002Action doGetDocTypeSelectItem : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" ### END SEMMSA002Action doGetDocTypeSelectItem ### ");
		}
	}
	
	public void doGetSiteAppServSelItem(){
		LOG.debug(" ### START SEMMSA002Action dogetSiteAppServSelItem ### ");
		semmsa002Bean = getSemmsa002Bean();
		List<WrapperBeanObject<SiteAppRegHistSrch>> siteAppServList = new ArrayList<WrapperBeanObject<SiteAppRegHistSrch>>();
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteAppRegHistSrch> to = null;
		SelectItem selItem = null;
		try{
//			siteAppServList = 
			semmsa002Bean.getSiteAppObjParam().setMode("C");
		
			
			LOG.debug("### getSiteAppObjParam().setMode = C ");
			LOG.debug("### 	semmsa002Bean.getSiteAppObjParam().getSiteAppId() =  "+	semmsa002Bean.getSiteAppObjParam().getSiteAppId());	
			to = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA002_SITE_APP_SERVICE.name, semmsa002Bean.getSiteAppObjParam());
			LOG.debug("size [" + to.size() + "]");
			
			if(to == null || to.isEmpty()){
				// set data not found message
				List<SelectItem> listlov = new LinkedList<SelectItem>();		
				selItem = new SelectItem("ALL" , msg("value.allServItem"));
				listlov.add(selItem);
				semmsa002Bean.setServTypeList(listlov);
				
			}
			
			if(to != null && to.size() > 0){
//				flag = true;
				List<SelectItem> listlov = new LinkedList<SelectItem>();		
				selItem = new SelectItem("ALL" , msg("value.allServItem"));
				listlov.add(selItem);
				for (int i = 0; i < to.size(); i++) {
					SiteAppRegHistSrch siteAcq = (SiteAppRegHistSrch) to.get(i);
//					WrapperBeanObject<SiteAppRegHistSrch> tmpWrapperBean = new WrapperBeanObject<SiteAppRegHistSrch>();

					if (StringUtils.isNotBlank(siteAcq.getServiceId()) && 
							   StringUtils.isNotEmpty(siteAcq.getServName())) {
						selItem = new SelectItem();
						selItem.setLabel(siteAcq.getServName());
						selItem.setValue(siteAcq.getServiceId());
						listlov.add(selItem);
						LOG.debug("siteAcq.getServName() : "+siteAcq.getServName());
						LOG.debug("siteAcq.getServiceId() : "+siteAcq.getServiceId());
					}
				}
				
				semmsa002Bean.setServTypeList(listlov);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action dogetSiteAppServSelItem : "+e);
		}finally{
			semmsa002Bean.getSiteAppObjParam().setMode("");
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" ### END SEMMSA002Action dogetSiteAppServSelItem ### ");
		}
	}
	
	public void doSetPlaceType(){
		LOG.info(" #### START SEMMSA002Action doSetPlaceType ####  ");
		semmsa002Bean = getSemmsa002Bean();
		
		String tabNo = "";
		try{
			tabNo = getFacesUtils().getRequestParameter("tabNo") == null ? "" : (String)getFacesUtils().getRequestParameter("tabNo");
			
			if(StringUtils.equals("1", tabNo)){
				LOG.debug("semmsa002Bean.getPlaceTypeTab1() : "+semmsa002Bean.getPlaceTypeTab1());
				semmsa002Bean.getSiteAppObjParam().setPlaceType(semmsa002Bean.getPlaceTypeTab1());
				semmsa002Bean.setPlaceTypeTab7(semmsa002Bean.getPlaceTypeTab1());
			}else if(StringUtils.equals("7", tabNo)){
				LOG.debug("semmsa002Bean.getPlaceTypeTab7() : "+semmsa002Bean.getPlaceTypeTab7());
				semmsa002Bean.getSiteAppObjParam().setPlaceType(semmsa002Bean.getPlaceTypeTab7());
				semmsa002Bean.setPlaceTypeTab1(semmsa002Bean.getPlaceTypeTab7());
			}
			LOG.debug("semmsa002Bean.getSiteAppObjParam().getPlaceType() : "+semmsa002Bean.getSiteAppObjParam().getPlaceType());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.info("Error Semmsa002Action doSetPlaceType : "+e);
		}finally{
			LOG.info(" #### END SEMMSA002Action doSetPlaceType ####  ");
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	
	public void doGetPlaceType(){
		LOG.info(" #### START SEMMSA002Action doGetPlaceType ####  ");
		semmsa002Bean = getSemmsa002Bean();
		
//		String tabNo = "";
		try{
//		
			if(semmsa002Bean.getSiteAppObjParam().getPlaceType() != null){
				semmsa002Bean.setPlaceTypeTab1(semmsa002Bean.getSiteAppObjParam().getPlaceType());
				semmsa002Bean.setPlaceTypeTab7(semmsa002Bean.getSiteAppObjParam().getPlaceType());
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.info("Error Semmsa002Action doGetPlaceType : "+e);
		}finally{
			LOG.info(" #### END SEMMSA002Action doGetPlaceType ####  ");
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	
	public void getMemberList() {
		try {
			
			semmsa002Bean = getSemmsa002Bean();
			
			SelectItem selItem = null;
			List<SelectItem> selList = new ArrayList<SelectItem>();
			List<SelectItem> selTempList = new ArrayList<SelectItem>();

			String myTeamCode = semmsa002Bean.getChgReqObjParam().getToTeam();
			
			ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
			semmsa002Bean.setLovObjParam(new MSA001LovSP());
			semmsa002Bean.getLovObjParam().setLovType("SA_MEMBER_LIST");
			semmsa002Bean.getLovObjParam().setRecordStatus("Y");
			semmsa002Bean.getLovObjParam().setLovName2("");
			semmsa002Bean.getLovObjParam().setLovVal2(myTeamCode);
			
			if(myTeamCode != null && !myTeamCode.equals("")) {
				List<MSA001LovSP> retLst = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA001_SRCH_TEAM.name, semmsa002Bean.getLovObjParam());
		
				if(retLst != null && !retLst.isEmpty()){
					for(MSA001LovSP lov : retLst){
						selItem = new SelectItem();
						selItem.setLabel(lov.getLovName());
						selItem.setValue(lov.getLovCode());
						selList.add(selItem);
					}
					
					// -- insert label '-- select --' at index 0
					if(selList.size() >= 1) {
						selTempList = selList;
						SelectItem selItem_idx0 = new SelectItem();
						selItem_idx0.setLabel("-- Select --");
						selItem_idx0.setValue("");
						
						selList = new ArrayList<SelectItem>();
						selList.add(selItem_idx0);
						
						for(int i = 0;i < selTempList.size();i++){
							SelectItem selItem_idx1 = new SelectItem();
							selItem_idx1.setLabel(selTempList.get(i).getLabel());
							selItem_idx1.setValue(selTempList.get(i).getValue());

							selList.add(selItem_idx1);
						}
//						SelectItem selItem_idx1 = new SelectItem();
//						selItem_idx1.setLabel(selList.get(0).getLabel());
//						selItem_idx1.setValue(selList.get(0).getValue());

//						selList = new ArrayList<SelectItem>();
//						selList.add(selItem_idx0);
//						selList.add(selItem_idx1);
					}
					// --
				} else {
					selItem = new SelectItem();
					selItem.setLabel("-- not found --");
					selItem.setValue("");
					selList.add(selItem);
				}
			} else {
				selItem = new SelectItem();
				selItem.setLabel("-- Select --");
				selItem.setValue("");
				selList.add(selItem);
			}
			semmsa002Bean.getChgReqObjParam().setToUser("");
//			semmsa002Bean.setDisabledAssignBtn(true);
			semmsa002Bean.setMemberList(selList);
			
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	
	public void getMemberSelected() {
		try {
			
			semmsa002Bean = getSemmsa002Bean();

			String myUserCode = semmsa002Bean.getSiteAppObjParam().getToUser() == null ? "" : semmsa002Bean.getSiteAppObjParam().getToUser().toString();
//			
//			if(myUserCode.equals("")) {
//				semmsa002Bean.setDisabledAssignBtn(true);
//			} else {
//				semmsa001Bean.setDisabledAssignBtn(false);
//			}
//			
//			setSemmsa001Bean(semmsa001Bean);
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
		}
	}
	
	public void doChkRegion(){
		semmsa002Bean = getSemmsa002Bean();
		try{
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("Error SEMMSA002Action doChkRegion : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	
	public void doGetReqHistSrch(){
		LOG.info("  ### START SEMMSA002Action doGetReqHistSrch ### ");
		semmsa002Bean = getSemmsa002Bean();
		
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService");
		List<WrapperBeanObject<SiteAppRegHistSrch>> wrapObjList = new ArrayList<WrapperBeanObject<SiteAppRegHistSrch>>();
		WrapperBeanObject<SiteAppRegHistSrch> wrapObj;
		try{
			
			List<SiteAppRegHistSrch> to = service.siteAppDao_querySPList(EQueryName.SP_MSA002_REQ_HIST_SRCH.name, semmsa002Bean.getSiteAppObjParam());
			
			if(to != null && to.size() > 0){
				SiteAppRegHistSrch histSrch = to.get(0);
				
				if(histSrch.getEffectiveDt() != null){
					histSrch.setEffectiveDtStr(convertYearENtoTHStr(histSrch.getEffectiveDt()));
				}
				
				if(histSrch.getExpireDt() != null){
					histSrch.setExpireDtStr(convertYearENtoTHStr(histSrch.getExpireDt()));
				}
				
				if(histSrch.getModifyDt() != null){
					histSrch.setModifyDtStr(convertYearENtoTHStr(histSrch.getModifyDt()));
				}
				
				wrapObj = new WrapperBeanObject<SiteAppRegHistSrch>();
				wrapObj.setDataObj(histSrch); 
				wrapObjList.add(wrapObj);
				
				semmsa002Bean.setSiteAppRegHistList(wrapObjList);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("Error SEMMSA002Action doGetReqHistSrch : "+e);
		}finally{
			LOG.info("  ### END SEMMSA002Action doGetReqHistSrch ### ");
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	
	public void doGetDocRemainSrch(){
		LOG.info("  ### START SEMMSA002Action doGetDocRemainSrch ### ");
		semmsa002Bean = getSemmsa002Bean();
		
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService");
		List<WrapperBeanObject<SiteAppSP>> wrapObjList = new ArrayList<WrapperBeanObject<SiteAppSP>>();
		WrapperBeanObject<SiteAppSP> wrapObj;
		try{
			LOG.info("getContractNo : "+semmsa002Bean.getSiteAppObjParam().getContractNo());
			List<SiteAppSP> to = service.siteAppDao_querySPList(EQueryName.SP_MSA002_DOC_REMAIN_SRCH.name, semmsa002Bean.getSiteAppObjParam());
			
			if(to != null && to.size() > 0){
				SiteAppSP siteAppObj = to.get(0);
				
				wrapObj = new WrapperBeanObject<SiteAppSP>();
				wrapObj.setDataObj(siteAppObj); 
				wrapObjList.add(wrapObj);
				
				semmsa002Bean.setSiteAppDocRemainList(wrapObjList);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("Error SEMMSA002Action doGetDocRemainSrch : "+e);
		}finally{
			LOG.info("  ### END SEMMSA002Action doGetDocRemainSrch ### ");
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	
	public boolean doSaveNewDocReq(){
		LOG.info(" ### Start SEMMSA002Acion doSaveNewDocReq ### ");
		
		boolean flag = true;
		semmsa002Bean = getSemmsa002Bean();
		
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService");
		try{
			//TODO set param
			semmsa002Bean.getChgReqObjParam().setContractNo(semmsa002Bean.getSiteContInfo().getContractNo());
			semmsa002Bean.getChgReqObjParam().setEffectiveDt(semmsa002Bean.getSiteAppObjParam().getEffectiveDt());
			semmsa002Bean.getChgReqObjParam().setExpireDt(semmsa002Bean.getSiteAppObjParam().getExpireDt());
			semmsa002Bean.getChgReqObjParam().setReqOfficerOld(semmsa002Bean.getSiteAppObjParam().getReqOfficer());
			
			if(semmsa002Bean.isChkReqOfficerManualPopup()){
				semmsa002Bean.getChgReqObjParam().setReqOfficerNew(semmsa002Bean.getChgReqObjParam().getReqOfficerManual());
			}else{
				semmsa002Bean.getChgReqObjParam().setReqOfficerNew(semmsa002Bean.getChgReqObjParam().getReqOfficer());
			}
			
			semmsa002Bean.getChgReqObjParam().setRemark(semmsa002Bean.getChgReqObjParam().getRemark());
			semmsa002Bean.getChgReqObjParam().setContractStatus(""); 
			semmsa002Bean.getChgReqObjParam().setSlimsStatus(""); 
			semmsa002Bean.getChgReqObjParam().setNetworkStatus(semmsa002Bean.getSiteAppObjParam().getNetworkStatus());
			semmsa002Bean.getChgReqObjParam().setUserId(getUserLogIn());
			
			List<SiteAppSP> to = service.siteAppDao_querySPList(EQueryName.SP_MSA002_SITE_REQ_HIST_INS.name, semmsa002Bean.getChgReqObjParam());
			
			if(to != null && to.size() > 0){
				if (to.get(0).getRetResult().equals("Success")) {
					this.doInitialMsa002Tab();
					semmsa002Bean.setRenderedMsgAlert(true);
					addMessageInfo("M0001");
				}
			}else{
				addMessageError("E0001");	// data save fail
        		semmsa002Bean.setRenderedMsgAlert(true);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("Error SEMMSA002Action doSaveNewDocReq : "+e);
		}finally{
			LOG.info(" ### End SEMMSA002Acion doSaveNewDocReq ### ");
			setSemmsa002Bean(semmsa002Bean);
		}
		
		return flag;
	}
	
	public void doClearPopupChgReqDoc(){
		LOG.info(" ### START SEMMSA002Action doClearPopupChgReqDoc ### ");
		semmsa002Bean = getSemmsa002Bean();
		try{
			semmsa002Bean.getChgReqObjParam().setToTeam("");
			semmsa002Bean.getChgReqObjParam().setReqOfficer("");
			semmsa002Bean.setChkReqOfficerManualPopup(false);
			semmsa002Bean.getChgReqObjParam().setReqOfficerManual("");
			semmsa002Bean.getChgReqObjParam().setRemark("");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("ERROR SEMMSA002Action doClearPopupChgReqDoc : "+e);
		}finally{
			LOG.info(" ### END SEMMSA002Action doClearPopupChgReqDoc ### ");
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	
	public boolean doEditRental(){
		LOG.debug(" ### START SEMMSA002Action doEditRental ### ");
		boolean flag = true;
		semmsa002Bean = getSemmsa002Bean();
		String siteAppRentContId = getFacesUtils().getRequestParameter("siteAppRentContId") == null ? "" : (String)getFacesUtils().getRequestParameter("siteAppRentContId");
		try{
			
			if(semmsa002Bean.getSiteAppRentCont() != null){
				for(WrapperBeanObject<SiteAppSP> rentContWrapObj : semmsa002Bean.getSiteAppRentCont()){
					SiteAppSP siteApp = new SiteAppSP(); 
					siteApp = (SiteAppSP) rentContWrapObj.getDataObj();
					
					if(StringUtils.equals(siteAppRentContId, siteApp.getSiteAppRentContId())){
						LOG.debug("getRentVatType  : "+siteApp.getRentVatType());
						siteApp.setRentContMode("C");
						if(siteApp.getRentVatType() == null || StringUtils.equals("", siteApp.getRentVatType())){
							siteApp.setRentVatType("");
						}
						semmsa002Bean.setSiteAppRentObjParam(siteApp);
						this.initUpdateRentCond();
					}
				}
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("ERROR SEMMSA002Action doEditRental : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" ### START SEMMSA002Action doEditRental ### ");
		}
		return flag;
	}
	
	public boolean doEditRentalExisting(){
		LOG.debug(" ### START SEMMSA002Action doEditRentalExisting ### ");
		boolean flag = true;
		semmsa002Bean = getSemmsa002Bean();
		String siteAppRentContId = getFacesUtils().getRequestParameter("siteAppRentContId") == null ? "" : (String)getFacesUtils().getRequestParameter("siteAppRentContId");
		try{
			
			if(semmsa002Bean.getSiteAppRentContExisting() != null){
				for(WrapperBeanObject<SiteAppSP> rentContWrapObj : semmsa002Bean.getSiteAppRentContExisting()){
					SiteAppSP siteApp = new SiteAppSP(); 
					siteApp = (SiteAppSP) rentContWrapObj.getDataObj();
					
					if(StringUtils.equals(siteAppRentContId, siteApp.getSiteAppRentContId())){
						
						siteApp.setRentContMode("H");
						semmsa002Bean.setSiteAppRentObjParam(siteApp);
						this.initUpdateRentCond();
					}
				}
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("ERROR SEMMSA002Action doEditRentalExisting : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" ### START SEMMSA002Action doEditRentalExisting ### ");
		}
		return flag;
	}
	

	public void doSiteAppDepositSrch(){
		LOG.debug(" #### Start SEMMSA002Action doSiteAppDepositSrch ####");
		semmsa002Bean = getSemmsa002Bean();
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteAppSP> to = null;
		try{
			LOG.debug("doSiteAppDeposotSrch getSiteAppId :"+semmsa002Bean.getSiteAppObjParam().getSiteAppId());
//			semmsa002Bean.getSiteAppObjParam().setRentContMode("C");
			to = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA002_SITE_APP_DEPOSIT_SRCH.name, semmsa002Bean.getSiteAppObjParam());
			LOG.debug("size [" + to.size() + "]");
			
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsa002Bean.setRenderedMsgDataNotFound(true);
				
			}
			
			if(to != null && to.size() > 0){
//				flag = true;
				semmsa002Bean.setRenderedMsgDataNotFound(false);

				semmsa002Bean.setSiteAppDeptObj(new SiteAppSP());
				semmsa002Bean.setSiteAppDeptCashList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				semmsa002Bean.setSiteAppDeptBGList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				semmsa002Bean.setSiteAppDeptCashElList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				semmsa002Bean.setSiteAppDeptBGElList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				
				for (int i = 0; i < to.size(); i++) {
					SiteAppSP siteAcq = (SiteAppSP) to.get(i);
					WrapperBeanObject<SiteAppSP> tmpWrapperBean = new WrapperBeanObject<SiteAppSP>();
					
					if(siteAcq.getNoExpFlag() != null){
						if(StringUtils.equals("Y", siteAcq.getNoExpFlag().toUpperCase())){
							semmsa002Bean.setNoExpFlag(true);
						}else{
							semmsa002Bean.setNoExpFlag(false);
						}
					}else{
						semmsa002Bean.setNoExpFlag(false);
					}
					
					if(siteAcq.getEffectiveDt() != null){
						siteAcq.setEffectiveDtStr(convertYearENtoTHStr(siteAcq.getEffectiveDt()));
					}
					
					if(siteAcq.getExpireDt() != null){
						siteAcq.setExpireDtStr(convertYearENtoTHStr(siteAcq.getExpireDt()));
					}
					

					if(siteAcq.getBgEffectiveDt() != null){
						siteAcq.setBgEffectiveDtStr(convertYearENtoTHStr(siteAcq.getBgEffectiveDt()));
					}
					
					if(siteAcq.getBgExpireDt() != null){
						siteAcq.setBgExpireDtStr(convertYearENtoTHStr(siteAcq.getBgExpireDt()));
					}
					
//					
//					if(siteAcq.getEndDt() != null){
//						siteAcq.setEndDtStr(convertYearENtoTHStr(siteAcq.getEndDt()));
//					}
//					
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					tmpWrapperBean.setDataObj(siteAcq);
					
					if(siteAcq != null){
//						semmsa002Bean.getSiteAppRentCont().add(tmpWrapperBean);
//						semmsa002Bean.setSiteAppDeptObj(siteAcq);
						if(StringUtils.equals("06", siteAcq.getExpenseType()) || StringUtils.equals("08", siteAcq.getExpenseType()) ){
							if(StringUtils.equals("01", siteAcq.getDepositType())){
								semmsa002Bean.getSiteAppDeptBGElList().add(tmpWrapperBean);
							}else if(StringUtils.equals("02", siteAcq.getDepositType())){
								semmsa002Bean.getSiteAppDeptCashElList().add(tmpWrapperBean);
							}
						}else{
						
							if(StringUtils.equals("01", siteAcq.getDepositType())){
								semmsa002Bean.getSiteAppDeptBGList().add(tmpWrapperBean);
							}else if(StringUtils.equals("02", siteAcq.getDepositType())){
								semmsa002Bean.getSiteAppDeptCashList().add(tmpWrapperBean);
							}
						}
					}
					
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doSiteAppDepositSrch : "+e);
		}finally{
			LOG.debug(" #### End SEMMSA002Action doSiteAppDepositSrch ####");
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	
	public boolean doValidateDeposit(){
		semmsa002Bean = getSemmsa002Bean();
		boolean flag = true;
		try{
			if(StringUtils.isEmpty(semmsa002Bean.getSiteAppDeptObj().getDepositType()) ){
				flag = false;
				addMessageError("W0001",msg("label.rentalDepType"));
			}
			
			if(StringUtils.isEmpty(semmsa002Bean.getSiteAppDeptObj().getExpenseType()) ){
				flag = false;
				addMessageError("W0001",msg("column.header.rantalPayment"));
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("Error SEMMSA002Action doValidateElDeposit : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
		}
		return flag;
	}
	
	public boolean doValidateElDeposit(){
		semmsa002Bean = getSemmsa002Bean();
		boolean flag = true;
		try{
			if(StringUtils.isEmpty(semmsa002Bean.getSiteAppDeptElObj().getDepositType()) ){
				flag = false;
				addMessageError("W0001",msg("label.rentalDepType"));
			}
			
			if(StringUtils.isEmpty(semmsa002Bean.getSiteAppDeptElObj().getExpenseType()) ){
				flag = false;
				addMessageError("W0001",msg("column.header.rantalPayment"));
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("Error SEMMSA002Action doValidateElDeposit : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
		}
		return flag;
	}
	
	public boolean doAddSiteAppDept(){
		LOG.debug(" #### Start SEMMSA002Action doAddSiteAppDept ####");
		boolean flag = false;
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		semmsa002Bean = getSemmsa002Bean();
		List<SiteAppSP> to = null;
		String siteAppId = "";
		String depositType = "";
		String expenseType = "";
		String depType = getFacesUtils().getRequestParameter("depositType") == null ? "" : (String)getFacesUtils().getRequestParameter("depositType");
		SiteAppSP siteAppObj = new SiteAppSP();
		try{
			siteAppId = semmsa002Bean.getSiteAppObjParam().getSiteAppId();
//			depositType = semmsa002Bean.getSiteAppDeptObj().getDepositType();
			expenseType = semmsa002Bean.getSiteAppDeptElObj().getExpenseType();
			
			if(StringUtils.equals("08", depType)){
				if(this.doValidateElDeposit()){
					depositType = semmsa002Bean.getSiteAppDeptElObj().getDepositType();
					if(StringUtils.equals("02", depositType)){
						semmsa002Bean.getSiteAppDeptCashElObj().setSiteAppId(siteAppId);
						semmsa002Bean.getSiteAppDeptCashElObj().setUserId(getUserLogIn());
						
						semmsa002Bean.getSiteAppDeptCashElObj().setExpenseType(semmsa002Bean.getSiteAppDeptElObj().getExpenseType());
						semmsa002Bean.getSiteAppDeptCashElObj().setDepositType(semmsa002Bean.getSiteAppDeptElObj().getDepositType());
						semmsa002Bean.getSiteAppDeptCashElObj().setVatType(semmsa002Bean.getSiteAppDeptElObj().getVatType());
						semmsa002Bean.getSiteAppDeptCashElObj().setServiceId(semmsa002Bean.getSiteAppDeptElObj().getServiceId());
						semmsa002Bean.getSiteAppDeptCashElObj().setRemark(semmsa002Bean.getSiteAppDeptElObj().getRemark());
						
						if(semmsa002Bean.isWithdrawFlagEl()){
							semmsa002Bean.getSiteAppDeptCashElObj().setWithdrawFlag("Y");
						}else{
							semmsa002Bean.getSiteAppDeptCashElObj().setWithdrawFlag("");
						}
						
						if(semmsa002Bean.getSiteAppDeptCashElObj().getDepositAmtOld() == null){
							semmsa002Bean.getSiteAppDeptCashElObj().setDepositAmtOld(BigDecimal.ZERO);
						}
						
						if(semmsa002Bean.getSiteAppDeptCashElObj().getDepositBringForward() == null){
							semmsa002Bean.getSiteAppDeptCashElObj().setDepositBringForward(BigDecimal.ZERO);
						}
						//Debug 
						LOG.debug(" El siteAppId : "+semmsa002Bean.getSiteAppDeptCashElObj().getSiteAppId());
						LOG.debug(" El expenseType : "+semmsa002Bean.getSiteAppDeptCashElObj().getExpenseType());
						LOG.debug(" El depositType : "+semmsa002Bean.getSiteAppDeptCashElObj().getDepositType());
						LOG.debug(" El depositAmt : "+semmsa002Bean.getSiteAppDeptCashElObj().getDepositAmt());
						LOG.debug(" El vatType : "+semmsa002Bean.getSiteAppDeptCashElObj().getVatType());
						LOG.debug(" El remark : "+semmsa002Bean.getSiteAppDeptCashElObj().getRemark());
						LOG.debug(" El newStatus : "+semmsa002Bean.getSiteAppDeptCashElObj().getNewStatus());
						LOG.debug(" El detail : "+semmsa002Bean.getSiteAppDeptCashElObj().getDetail());
						LOG.debug(" El depositCondType : "+semmsa002Bean.getSiteAppDeptCashElObj().getDepositCondType());
						LOG.debug(" El depositAmtOld : "+semmsa002Bean.getSiteAppDeptCashElObj().getDepositAmtOld());
						LOG.debug(" El depositAmtNew : "+semmsa002Bean.getSiteAppDeptCashElObj().getDepositAmtNew());
						LOG.debug(" El depositReturnType : "+semmsa002Bean.getSiteAppDeptCashElObj().getDepositReturnType());
						LOG.debug(" El returnAmt : "+semmsa002Bean.getSiteAppDeptCashElObj().getReturnAmt());
						LOG.debug(" El depositBringForward : "+semmsa002Bean.getSiteAppDeptCashElObj().getDepositBringForward());
						LOG.debug(" El withDrawFlag : "+semmsa002Bean.getSiteAppDeptCashElObj().getWithdrawFlag());
						LOG.debug(" El serviceId : "+semmsa002Bean.getSiteAppDeptCashElObj().getServiceId());
						LOG.debug(" El depositStatus : "+semmsa002Bean.getSiteAppDeptCashElObj().getDepositStatus());
						LOG.debug(" El userId : "+semmsa002Bean.getSiteAppDeptCashElObj().getUserId());
						siteAppObj = semmsa002Bean.getSiteAppDeptCashElObj();
					}else if(StringUtils.equals("01", depositType)){
						semmsa002Bean.getSiteAppDeptBgElObj().setSiteAppId(siteAppId);
						semmsa002Bean.getSiteAppDeptBgElObj().setUserId(getUserLogIn());
						
						semmsa002Bean.getSiteAppDeptBgElObj().setExpenseType(semmsa002Bean.getSiteAppDeptElObj().getExpenseType());
						semmsa002Bean.getSiteAppDeptBgElObj().setDepositType(semmsa002Bean.getSiteAppDeptElObj().getDepositType());
						semmsa002Bean.getSiteAppDeptBgElObj().setVatType(semmsa002Bean.getSiteAppDeptElObj().getVatType());
						semmsa002Bean.getSiteAppDeptBgElObj().setServiceId(semmsa002Bean.getSiteAppDeptElObj().getServiceId());
						semmsa002Bean.getSiteAppDeptBgElObj().setRemark(semmsa002Bean.getSiteAppDeptElObj().getRemark());
						
						if(semmsa002Bean.isWithdrawFlagEl()){
							semmsa002Bean.getSiteAppDeptBgElObj().setWithdrawFlag("Y");
						}else{
							semmsa002Bean.getSiteAppDeptBgElObj().setWithdrawFlag("");
						}
						
						//Debug 
						LOG.debug(" El siteAppId : "+semmsa002Bean.getSiteAppDeptBgElObj().getSiteAppId());
						LOG.debug(" El expenseType : "+semmsa002Bean.getSiteAppDeptBgElObj().getExpenseType());
						LOG.debug(" El depositType : "+semmsa002Bean.getSiteAppDeptBgElObj().getDepositType());
						LOG.debug(" El depositAmt : "+semmsa002Bean.getSiteAppDeptBgElObj().getDepositAmt());
						LOG.debug(" El vatType : "+semmsa002Bean.getSiteAppDeptBgElObj().getVatType());
						LOG.debug(" El remark : "+semmsa002Bean.getSiteAppDeptBgElObj().getRemark());
						LOG.debug(" El newStatus : "+semmsa002Bean.getSiteAppDeptBgElObj().getNewStatus());
						LOG.debug(" El detail : "+semmsa002Bean.getSiteAppDeptBgElObj().getDetail());
						LOG.debug(" El depositCondType : "+semmsa002Bean.getSiteAppDeptBgElObj().getDepositCondType());
						LOG.debug(" El depositAmtOld : "+semmsa002Bean.getSiteAppDeptBgElObj().getDepositAmtOld());
						LOG.debug(" El depositAmtNew : "+semmsa002Bean.getSiteAppDeptBgElObj().getDepositAmtNew());
						LOG.debug(" El depositReturnType : "+semmsa002Bean.getSiteAppDeptBgElObj().getDepositReturnType());
						LOG.debug(" El returnAmt : "+semmsa002Bean.getSiteAppDeptBgElObj().getReturnAmt());
						LOG.debug(" El depositBringForward : "+semmsa002Bean.getSiteAppDeptBgElObj().getDepositBringForward());
						LOG.debug(" El withDrawFlag : "+semmsa002Bean.getSiteAppDeptBgElObj().getWithdrawFlag());
						LOG.debug(" El serviceId : "+semmsa002Bean.getSiteAppDeptBgElObj().getServiceId());
						LOG.debug(" El depositStatus : "+semmsa002Bean.getSiteAppDeptBgElObj().getDepositStatus());
						LOG.debug(" El userId : "+semmsa002Bean.getSiteAppDeptBgElObj().getUserId());
						siteAppObj = semmsa002Bean.getSiteAppDeptBgElObj();
					}
				}else{
					semmsa002Bean.setRenderedMsgDeposit(true);
					setSemmsa002Bean(semmsa002Bean);
					return flag;
				}
				
			}else{
				if(doValidateDeposit()){
					depositType = semmsa002Bean.getSiteAppDeptObj().getDepositType();
					if(StringUtils.equals("02", depositType)){
						semmsa002Bean.getSiteAppDeptCashObj().setSiteAppId(siteAppId);
						semmsa002Bean.getSiteAppDeptCashObj().setUserId(getUserLogIn());
						
						semmsa002Bean.getSiteAppDeptCashObj().setExpenseType(semmsa002Bean.getSiteAppDeptObj().getExpenseType());
						semmsa002Bean.getSiteAppDeptCashObj().setDepositType(semmsa002Bean.getSiteAppDeptObj().getDepositType());
						semmsa002Bean.getSiteAppDeptCashObj().setVatType(semmsa002Bean.getSiteAppDeptObj().getVatType());
						semmsa002Bean.getSiteAppDeptCashObj().setServiceId(semmsa002Bean.getSiteAppDeptObj().getServiceId());
						semmsa002Bean.getSiteAppDeptCashObj().setRemark(semmsa002Bean.getSiteAppDeptObj().getRemark());
						
						if(semmsa002Bean.isWithdrawFlag()){
							semmsa002Bean.getSiteAppDeptCashObj().setWithdrawFlag("Y");
						}else{
							semmsa002Bean.getSiteAppDeptCashObj().setWithdrawFlag("");
						}
						
						if(semmsa002Bean.getSiteAppDeptCashObj().getDepositAmtOld() == null){
							semmsa002Bean.getSiteAppDeptCashObj().setDepositAmtOld(BigDecimal.ZERO);
						}
						
						if(semmsa002Bean.getSiteAppDeptCashObj().getDepositBringForward() == null){
							semmsa002Bean.getSiteAppDeptCashObj().setDepositBringForward(BigDecimal.ZERO);
						}
						//Debug 
						LOG.debug("siteAppId : "+semmsa002Bean.getSiteAppDeptCashObj().getSiteAppId());
						LOG.debug("expenseType : "+semmsa002Bean.getSiteAppDeptCashObj().getExpenseType());
						LOG.debug("depositType : "+semmsa002Bean.getSiteAppDeptCashObj().getDepositType());
						LOG.debug("depositAmt : "+semmsa002Bean.getSiteAppDeptCashObj().getDepositAmt());
						LOG.debug("vatType : "+semmsa002Bean.getSiteAppDeptCashObj().getVatType());
						LOG.debug("remark : "+semmsa002Bean.getSiteAppDeptCashObj().getRemark());
						LOG.debug("newStatus : "+semmsa002Bean.getSiteAppDeptCashObj().getNewStatus());
						LOG.debug("detail : "+semmsa002Bean.getSiteAppDeptCashObj().getDetail());
						LOG.debug("depositCondType : "+semmsa002Bean.getSiteAppDeptCashObj().getDepositCondType());
						LOG.debug("depositAmtOld : "+semmsa002Bean.getSiteAppDeptCashObj().getDepositAmtOld());
						LOG.debug("depositAmtNew : "+semmsa002Bean.getSiteAppDeptCashObj().getDepositAmtNew());
						LOG.debug("depositReturnType : "+semmsa002Bean.getSiteAppDeptCashObj().getDepositReturnType());
						LOG.debug("returnAmt : "+semmsa002Bean.getSiteAppDeptCashObj().getReturnAmt());
						LOG.debug("depositBringForward : "+semmsa002Bean.getSiteAppDeptCashObj().getDepositBringForward());
						LOG.debug("withDrawFlag : "+semmsa002Bean.getSiteAppDeptCashObj().getWithdrawFlag());
						LOG.debug("serviceId : "+semmsa002Bean.getSiteAppDeptCashObj().getServiceId());
						LOG.debug("depositStatus : "+semmsa002Bean.getSiteAppDeptCashObj().getDepositStatus());
						LOG.debug("userId : "+semmsa002Bean.getSiteAppDeptCashObj().getUserId());
						siteAppObj = semmsa002Bean.getSiteAppDeptCashObj();
					}else if(StringUtils.equals("01", depositType)){
						semmsa002Bean.getSiteAppDeptBgObj().setSiteAppId(siteAppId);
						semmsa002Bean.getSiteAppDeptBgObj().setUserId(getUserLogIn());
						
						semmsa002Bean.getSiteAppDeptBgObj().setExpenseType(semmsa002Bean.getSiteAppDeptObj().getExpenseType());
						semmsa002Bean.getSiteAppDeptBgObj().setDepositType(semmsa002Bean.getSiteAppDeptObj().getDepositType());
						semmsa002Bean.getSiteAppDeptBgObj().setVatType(semmsa002Bean.getSiteAppDeptObj().getVatType());
						semmsa002Bean.getSiteAppDeptBgObj().setServiceId(semmsa002Bean.getSiteAppDeptObj().getServiceId());
						semmsa002Bean.getSiteAppDeptBgObj().setRemark(semmsa002Bean.getSiteAppDeptObj().getRemark());
						
						if(semmsa002Bean.isWithdrawFlag()){
							semmsa002Bean.getSiteAppDeptBgObj().setWithdrawFlag("Y");
						}else{
							semmsa002Bean.getSiteAppDeptBgObj().setWithdrawFlag("");
						}
						
						//Debug 
						LOG.debug("siteAppId : "+semmsa002Bean.getSiteAppDeptBgObj().getSiteAppId());
						LOG.debug("expenseType : "+semmsa002Bean.getSiteAppDeptBgObj().getExpenseType());
						LOG.debug("depositType : "+semmsa002Bean.getSiteAppDeptBgObj().getDepositType());
						LOG.debug("depositAmt : "+semmsa002Bean.getSiteAppDeptBgObj().getDepositAmt());
						LOG.debug("vatType : "+semmsa002Bean.getSiteAppDeptBgObj().getVatType());
						LOG.debug("remark : "+semmsa002Bean.getSiteAppDeptBgObj().getRemark());
						LOG.debug("newStatus : "+semmsa002Bean.getSiteAppDeptBgObj().getNewStatus());
						LOG.debug("detail : "+semmsa002Bean.getSiteAppDeptBgObj().getDetail());
						LOG.debug("depositCondType : "+semmsa002Bean.getSiteAppDeptBgObj().getDepositCondType());
						LOG.debug("depositAmtOld : "+semmsa002Bean.getSiteAppDeptBgObj().getDepositAmtOld());
						LOG.debug("depositAmtNew : "+semmsa002Bean.getSiteAppDeptBgObj().getDepositAmtNew());
						LOG.debug("depositReturnType : "+semmsa002Bean.getSiteAppDeptBgObj().getDepositReturnType());
						LOG.debug("returnAmt : "+semmsa002Bean.getSiteAppDeptBgObj().getReturnAmt());
						LOG.debug("depositBringForward : "+semmsa002Bean.getSiteAppDeptBgObj().getDepositBringForward());
						LOG.debug("withDrawFlag : "+semmsa002Bean.getSiteAppDeptBgObj().getWithdrawFlag());
						LOG.debug("serviceId : "+semmsa002Bean.getSiteAppDeptBgObj().getServiceId());
						LOG.debug("depositStatus : "+semmsa002Bean.getSiteAppDeptBgObj().getDepositStatus());
						LOG.debug("userId : "+semmsa002Bean.getSiteAppDeptBgObj().getUserId());
						siteAppObj = semmsa002Bean.getSiteAppDeptBgObj();
					}
				}else{
					semmsa002Bean.setRenderedMsgDeposit(true);
					setSemmsa002Bean(semmsa002Bean);
					return flag;
				}
				
			}
			
			
//			semmsa002Bean.getSiteAppDeptObj().setSiteAppId(siteAppId);
//			semmsa002Bean.getSiteAppDeptObj().setUserId(getUserLogIn());
			
			
			
			to = service.siteAppDao_querySPList(EQueryName.SP_MSA002_SITE_APP_DEPOSIT_INS.name, siteAppObj);
			
			if (to != null && !to.isEmpty()) {
				String retMsg = to.get(0).getRetResultMsg() == null ? "" : to.get(0).getRetResultMsg().toString();
				
				if (to.get(0).getRetResult().equals("Success")) {

					
					String myMsgArr[];
					if(!retMsg.equals("")){
						myMsgArr = retMsg.split("<BR/>");
						
						for(int i=0; i < myMsgArr.length; i++){
							//addGeneralMessageInfo(myMsgArr[i]);
							//addGeneralMessageWarn(myMsgArr[i]);
							FrontMessageUtils.addMessageWarn(myMsgArr[i]);	// optional
						}
					}
					if(StringUtils.equals("08", expenseType)){
						this.doSiteAppDepositSrch();
						this.doClearSiteAppDepositEl();
					}else{
						this.doSiteAppDepositSrch();
						
						this.doClearSiteAppDeposit();
					}
				
					
					flag = true;
					semmsa002Bean.setRenderedMsgAlert(true);
//					//TODO clear save param obj
//					this.doClearSiteAppDeposit();
//					this.doClearSiteAppDepositEl();
				} else {
					if(to.get(0).getRetResult() != null){
//						if("FAIL".equals(to.get(0).getRetResult().toUpperCase())){
//							semmsa002Bean.setDisabledButtonPopupResult(false);
//						}else if("FAIL2".equals(to.get(0).getRetResult().toUpperCase())){
//							semmsa002Bean.setDisabledButtonPopupResult(true);
//						}
						
						if(to.get(0).getRetResult().toUpperCase().contains("FAIL")){
                            semmsa002Bean.setDisabledButtonPopupResult(false);
                            LOG.debug("call-->"+EQueryName.SP_MSA002_SITE_APP_DEPOSIT_INS.name+" => result :" +to.get(0).getRetResult());
                        }else if("FAIL2".equals(to.get(0).getRetResult().toUpperCase())){
                            semmsa002Bean.setDisabledButtonPopupResult(true);
                        }
						
					}
//					System.out.println("to.get(0).getRetResultMsg() = "+to.get(0).getRetResultMsg());
					if(to.get(0).getRetResultMsg() != null)
						addGeneralMessageError(to.get(0).getRetResultMsg());	// data save fail
					else
						addMessageError("E0001");	// data save fail
	        		semmsa002Bean.setRenderedMsgAlert(true);
				}
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doAddSiteAppDept : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
		}
		LOG.debug(" #### End SEMMSA002Action doAddSiteAppDept ####");
		return flag;
	}
	
	public boolean doUpdateSiteAppDept(){
		LOG.debug(" #### Start SEMMSA002Action doUpdateSiteAppDept ####");
		boolean flag = false;
		semmsa002Bean = getSemmsa002Bean();
		String siteAppId = "";
		String depositType = "";
		String expenseType = "";
		String depType = getFacesUtils().getRequestParameter("depositType") == null ? "" : (String)getFacesUtils().getRequestParameter("depositType");
		SiteAppSP siteAppObj = new SiteAppSP();
		try{
			ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
			List<SiteAppSP> to = null;
			
			siteAppId = semmsa002Bean.getSiteAppObjParam().getSiteAppId();
//			depositType = semmsa002Bean.getSiteAppDeptObj().getDepositType();
			expenseType = semmsa002Bean.getSiteAppDeptElObj().getExpenseType();
			
			if(StringUtils.equals("08", depType)){
				if(this.doValidateElDeposit()){
					depositType = semmsa002Bean.getSiteAppDeptElObj().getDepositType();
					if(StringUtils.equals("02", depositType)){
						semmsa002Bean.getSiteAppDeptCashElObj().setSiteAppId(siteAppId);
						semmsa002Bean.getSiteAppDeptCashElObj().setUserId(getUserLogIn());
						semmsa002Bean.getSiteAppDeptCashElObj().setSiteAppDepositId(semmsa002Bean.getSiteAppDeptElObj().getSiteAppDepositId());
						
						semmsa002Bean.getSiteAppDeptCashElObj().setExpenseType(semmsa002Bean.getSiteAppDeptElObj().getExpenseType());
						semmsa002Bean.getSiteAppDeptCashElObj().setDepositType(semmsa002Bean.getSiteAppDeptElObj().getDepositType());
						semmsa002Bean.getSiteAppDeptCashElObj().setVatType(semmsa002Bean.getSiteAppDeptElObj().getVatType());
						semmsa002Bean.getSiteAppDeptCashElObj().setServiceId(semmsa002Bean.getSiteAppDeptElObj().getServiceId());
						semmsa002Bean.getSiteAppDeptCashElObj().setRemark(semmsa002Bean.getSiteAppDeptElObj().getRemark());
						
						if(semmsa002Bean.isWithdrawFlagEl()){
							semmsa002Bean.getSiteAppDeptCashElObj().setWithdrawFlag("Y");
						}else{
							semmsa002Bean.getSiteAppDeptCashElObj().setWithdrawFlag("");
						}
						
						//Debug
						LOG.debug(" El doUpdateSiteAppDept siteAppDepositId : "+semmsa002Bean.getSiteAppDeptElObj().getSiteAppDepositId());
						LOG.debug(" El doUpdateSiteAppDept siteAppId : "+semmsa002Bean.getSiteAppDeptCashElObj().getSiteAppId());
						LOG.debug(" El doUpdateSiteAppDept expenseType : "+semmsa002Bean.getSiteAppDeptCashElObj().getExpenseType());
						LOG.debug(" El doUpdateSiteAppDept depositType : "+semmsa002Bean.getSiteAppDeptCashElObj().getDepositType());
						LOG.debug(" El doUpdateSiteAppDept depositAmt : "+semmsa002Bean.getSiteAppDeptCashElObj().getDepositAmt());
						LOG.debug(" El doUpdateSiteAppDept vatType : "+semmsa002Bean.getSiteAppDeptCashElObj().getVatType());
						LOG.debug(" El doUpdateSiteAppDept remark : "+semmsa002Bean.getSiteAppDeptCashElObj().getRemark());
						LOG.debug(" El doUpdateSiteAppDept newStatus : "+semmsa002Bean.getSiteAppDeptCashElObj().getNewStatus());
						LOG.debug(" El doUpdateSiteAppDept detail : "+semmsa002Bean.getSiteAppDeptCashElObj().getDetail());
						LOG.debug(" El doUpdateSiteAppDept depositCondType : "+semmsa002Bean.getSiteAppDeptCashElObj().getDepositCondType());
						LOG.debug(" El doUpdateSiteAppDept depositAmtOld : "+semmsa002Bean.getSiteAppDeptCashElObj().getDepositAmtOld());
						LOG.debug(" El doUpdateSiteAppDept depositAmtNew : "+semmsa002Bean.getSiteAppDeptCashElObj().getDepositAmtNew());
						LOG.debug(" El doUpdateSiteAppDept depositReturnType : "+semmsa002Bean.getSiteAppDeptCashElObj().getDepositReturnType());
						LOG.debug(" El doUpdateSiteAppDept returnAmt : "+semmsa002Bean.getSiteAppDeptCashElObj().getReturnAmt());
						LOG.debug(" El doUpdateSiteAppDept depositBringForward : "+semmsa002Bean.getSiteAppDeptCashElObj().getDepositBringForward());
						LOG.debug(" El doUpdateSiteAppDept withDrawFlag : "+semmsa002Bean.getSiteAppDeptCashElObj().getWithdrawFlag());
						LOG.debug(" El doUpdateSiteAppDept getServiceId "+semmsa002Bean.getSiteAppDeptCashElObj().getServiceId());
						LOG.debug(" El doUpdateSiteAppDept depositStatus : "+semmsa002Bean.getSiteAppDeptCashElObj().getDepositStatus());
						LOG.debug(" El doUpdateSiteAppDept userId : "+semmsa002Bean.getSiteAppDeptCashElObj().getUserId());
						siteAppObj = semmsa002Bean.getSiteAppDeptCashElObj();
					}else if(StringUtils.equals("01", depositType)){
						semmsa002Bean.getSiteAppDeptBgElObj().setSiteAppId(siteAppId);
						semmsa002Bean.getSiteAppDeptBgElObj().setUserId(getUserLogIn());
						semmsa002Bean.getSiteAppDeptCashElObj().setSiteAppDepositId(semmsa002Bean.getSiteAppDeptElObj().getSiteAppDepositId());
						
						semmsa002Bean.getSiteAppDeptBgElObj().setExpenseType(semmsa002Bean.getSiteAppDeptElObj().getExpenseType());
						semmsa002Bean.getSiteAppDeptBgElObj().setDepositType(semmsa002Bean.getSiteAppDeptElObj().getDepositType());
						semmsa002Bean.getSiteAppDeptBgElObj().setVatType(semmsa002Bean.getSiteAppDeptElObj().getVatType());
						semmsa002Bean.getSiteAppDeptBgElObj().setServiceId(semmsa002Bean.getSiteAppDeptElObj().getServiceId());
						semmsa002Bean.getSiteAppDeptBgElObj().setRemark(semmsa002Bean.getSiteAppDeptElObj().getRemark());
						
						if(semmsa002Bean.isWithdrawFlagEl()){
							semmsa002Bean.getSiteAppDeptBgElObj().setWithdrawFlag("Y");
						}else{
							semmsa002Bean.getSiteAppDeptBgElObj().setWithdrawFlag("");
						}
						
						//Debug
						LOG.debug(" El doUpdateSiteAppDept siteAppDepositId : "+semmsa002Bean.getSiteAppDeptElObj().getSiteAppDepositId());
						LOG.debug(" El doUpdateSiteAppDept siteAppId : "+semmsa002Bean.getSiteAppDeptBgElObj().getSiteAppId());
						LOG.debug(" El doUpdateSiteAppDept expenseType : "+semmsa002Bean.getSiteAppDeptBgElObj().getExpenseType());
						LOG.debug(" El doUpdateSiteAppDept depositType : "+semmsa002Bean.getSiteAppDeptBgElObj().getDepositType());
						LOG.debug(" El doUpdateSiteAppDept depositAmt : "+semmsa002Bean.getSiteAppDeptBgElObj().getDepositAmt());
						LOG.debug(" El doUpdateSiteAppDept vatType : "+semmsa002Bean.getSiteAppDeptBgElObj().getVatType());
						LOG.debug(" El doUpdateSiteAppDept remark : "+semmsa002Bean.getSiteAppDeptBgElObj().getRemark());
						LOG.debug(" El doUpdateSiteAppDept newStatus : "+semmsa002Bean.getSiteAppDeptBgElObj().getNewStatus());
						LOG.debug(" El doUpdateSiteAppDept detail : "+semmsa002Bean.getSiteAppDeptBgElObj().getDetail());
						LOG.debug(" El doUpdateSiteAppDept depositCondType : "+semmsa002Bean.getSiteAppDeptBgElObj().getDepositCondType());
						LOG.debug(" El doUpdateSiteAppDept depositAmtOld : "+semmsa002Bean.getSiteAppDeptBgElObj().getDepositAmtOld());
						LOG.debug(" El doUpdateSiteAppDept depositAmtNew : "+semmsa002Bean.getSiteAppDeptBgElObj().getDepositAmtNew());
						LOG.debug(" El doUpdateSiteAppDept depositReturnType : "+semmsa002Bean.getSiteAppDeptBgElObj().getDepositReturnType());
						LOG.debug(" El doUpdateSiteAppDept returnAmt : "+semmsa002Bean.getSiteAppDeptBgElObj().getReturnAmt());
						LOG.debug(" El doUpdateSiteAppDept depositBringForward : "+semmsa002Bean.getSiteAppDeptBgElObj().getDepositBringForward());
						LOG.debug(" El doUpdateSiteAppDept withDrawFlag : "+semmsa002Bean.getSiteAppDeptBgElObj().getWithdrawFlag());
						LOG.debug(" El doUpdateSiteAppDept serviceId : "+semmsa002Bean.getSiteAppDeptBgElObj().getServiceId());
						LOG.debug(" El doUpdateSiteAppDept depositStatus : "+semmsa002Bean.getSiteAppDeptBgElObj().getDepositStatus());
						LOG.debug(" El doUpdateSiteAppDept userId : "+semmsa002Bean.getSiteAppDeptBgElObj().getUserId());
						siteAppObj = semmsa002Bean.getSiteAppDeptBgElObj();
					}
				}else{
					semmsa002Bean.setRenderedMsgDeposit(true);
					setSemmsa002Bean(semmsa002Bean);
					return flag;
				}
			}else{
				if(this.doValidateDeposit()){
					depositType = semmsa002Bean.getSiteAppDeptObj().getDepositType();
					if(StringUtils.equals("02", depositType)){
						semmsa002Bean.getSiteAppDeptCashObj().setSiteAppId(siteAppId);
						semmsa002Bean.getSiteAppDeptCashObj().setUserId(getUserLogIn());
						semmsa002Bean.getSiteAppDeptCashObj().setSiteAppDepositId(semmsa002Bean.getSiteAppDeptObj().getSiteAppDepositId());
						
						semmsa002Bean.getSiteAppDeptCashObj().setExpenseType(semmsa002Bean.getSiteAppDeptObj().getExpenseType());
						semmsa002Bean.getSiteAppDeptCashObj().setDepositType(semmsa002Bean.getSiteAppDeptObj().getDepositType());
						semmsa002Bean.getSiteAppDeptCashObj().setVatType(semmsa002Bean.getSiteAppDeptObj().getVatType());
						semmsa002Bean.getSiteAppDeptCashObj().setServiceId(semmsa002Bean.getSiteAppDeptObj().getServiceId());
						semmsa002Bean.getSiteAppDeptCashObj().setRemark(semmsa002Bean.getSiteAppDeptObj().getRemark());
						
						if(semmsa002Bean.isWithdrawFlag()){
							semmsa002Bean.getSiteAppDeptCashObj().setWithdrawFlag("Y");
						}else{
							semmsa002Bean.getSiteAppDeptCashObj().setWithdrawFlag("");
						}
						
						//Debug
						LOG.debug("doUpdateSiteAppDept siteAppDepositId : "+semmsa002Bean.getSiteAppDeptObj().getSiteAppDepositId());
						LOG.debug("doUpdateSiteAppDept siteAppId : "+semmsa002Bean.getSiteAppDeptCashObj().getSiteAppId());
						LOG.debug("doUpdateSiteAppDept expenseType : "+semmsa002Bean.getSiteAppDeptCashObj().getExpenseType());
						LOG.debug("doUpdateSiteAppDept depositType : "+semmsa002Bean.getSiteAppDeptCashObj().getDepositType());
						LOG.debug("doUpdateSiteAppDept depositAmt : "+semmsa002Bean.getSiteAppDeptCashObj().getDepositAmt());
						LOG.debug("doUpdateSiteAppDept vatType : "+semmsa002Bean.getSiteAppDeptCashObj().getVatType());
						LOG.debug("doUpdateSiteAppDept remark : "+semmsa002Bean.getSiteAppDeptCashObj().getRemark());
						LOG.debug("doUpdateSiteAppDept newStatus : "+semmsa002Bean.getSiteAppDeptCashObj().getNewStatus());
						LOG.debug("doUpdateSiteAppDept detail : "+semmsa002Bean.getSiteAppDeptCashObj().getDetail());
						LOG.debug("doUpdateSiteAppDept depositCondType : "+semmsa002Bean.getSiteAppDeptCashObj().getDepositCondType());
						LOG.debug("doUpdateSiteAppDept depositAmtOld : "+semmsa002Bean.getSiteAppDeptCashObj().getDepositAmtOld());
						LOG.debug("doUpdateSiteAppDept depositAmtNew : "+semmsa002Bean.getSiteAppDeptCashObj().getDepositAmtNew());
						LOG.debug("doUpdateSiteAppDept depositReturnType : "+semmsa002Bean.getSiteAppDeptCashObj().getDepositReturnType());
						LOG.debug("doUpdateSiteAppDept returnAmt : "+semmsa002Bean.getSiteAppDeptCashObj().getReturnAmt());
						LOG.debug("doUpdateSiteAppDept depositBringForward : "+semmsa002Bean.getSiteAppDeptCashObj().getDepositBringForward());
						LOG.debug("doUpdateSiteAppDept withDrawFlag : "+semmsa002Bean.getSiteAppDeptCashObj().getWithdrawFlag());
						LOG.debug("doUpdateSiteAppDept serviceId : "+semmsa002Bean.getSiteAppDeptCashObj().getServiceId());
						LOG.debug("doUpdateSiteAppDept depositStatus : "+semmsa002Bean.getSiteAppDeptCashObj().getDepositStatus());
						LOG.debug("doUpdateSiteAppDept userId : "+semmsa002Bean.getSiteAppDeptCashObj().getUserId());
						siteAppObj = semmsa002Bean.getSiteAppDeptCashObj();
					}else if(StringUtils.equals("01", depositType)){
						semmsa002Bean.getSiteAppDeptBgObj().setSiteAppId(siteAppId);
						semmsa002Bean.getSiteAppDeptBgObj().setUserId(getUserLogIn());
						semmsa002Bean.getSiteAppDeptBgObj().setSiteAppDepositId(semmsa002Bean.getSiteAppDeptObj().getSiteAppDepositId());
						
						semmsa002Bean.getSiteAppDeptBgObj().setExpenseType(semmsa002Bean.getSiteAppDeptObj().getExpenseType());
						semmsa002Bean.getSiteAppDeptBgObj().setDepositType(semmsa002Bean.getSiteAppDeptObj().getDepositType());
						semmsa002Bean.getSiteAppDeptBgObj().setVatType(semmsa002Bean.getSiteAppDeptObj().getVatType());
						semmsa002Bean.getSiteAppDeptBgObj().setServiceId(semmsa002Bean.getSiteAppDeptObj().getServiceId());
						semmsa002Bean.getSiteAppDeptBgObj().setRemark(semmsa002Bean.getSiteAppDeptObj().getRemark());
						
						if(semmsa002Bean.isWithdrawFlag()){
							semmsa002Bean.getSiteAppDeptBgObj().setWithdrawFlag("Y");
						}else{
							semmsa002Bean.getSiteAppDeptBgObj().setWithdrawFlag("");
						}
						
						//Debug
						LOG.debug("doUpdateSiteAppDept siteAppDepositId : "+semmsa002Bean.getSiteAppDeptObj().getSiteAppDepositId());
						LOG.debug("doUpdateSiteAppDept siteAppId : "+semmsa002Bean.getSiteAppDeptBgObj().getSiteAppId());
						LOG.debug("doUpdateSiteAppDept expenseType : "+semmsa002Bean.getSiteAppDeptBgObj().getExpenseType());
						LOG.debug("doUpdateSiteAppDept depositType : "+semmsa002Bean.getSiteAppDeptBgObj().getDepositType());
						LOG.debug("doUpdateSiteAppDept depositAmt : "+semmsa002Bean.getSiteAppDeptBgObj().getDepositAmt());
						LOG.debug("doUpdateSiteAppDept vatType : "+semmsa002Bean.getSiteAppDeptBgObj().getVatType());
						LOG.debug("doUpdateSiteAppDept remark : "+semmsa002Bean.getSiteAppDeptBgObj().getRemark());
						LOG.debug("doUpdateSiteAppDept newStatus : "+semmsa002Bean.getSiteAppDeptBgObj().getNewStatus());
						LOG.debug("doUpdateSiteAppDept detail : "+semmsa002Bean.getSiteAppDeptBgObj().getDetail());
						LOG.debug("doUpdateSiteAppDept depositCondType : "+semmsa002Bean.getSiteAppDeptBgObj().getDepositCondType());
						LOG.debug("doUpdateSiteAppDept depositAmtOld : "+semmsa002Bean.getSiteAppDeptBgObj().getDepositAmtOld());
						LOG.debug("doUpdateSiteAppDept depositAmtNew : "+semmsa002Bean.getSiteAppDeptBgObj().getDepositAmtNew());
						LOG.debug("doUpdateSiteAppDept depositReturnType : "+semmsa002Bean.getSiteAppDeptBgObj().getDepositReturnType());
						LOG.debug("doUpdateSiteAppDept returnAmt : "+semmsa002Bean.getSiteAppDeptBgObj().getReturnAmt());
						LOG.debug("doUpdateSiteAppDept depositBringForward : "+semmsa002Bean.getSiteAppDeptBgObj().getDepositBringForward());
						LOG.debug("doUpdateSiteAppDept withDrawFlag : "+semmsa002Bean.getSiteAppDeptBgObj().getWithdrawFlag());
						LOG.debug("doUpdateSiteAppDept serviceId : "+semmsa002Bean.getSiteAppDeptBgObj().getServiceId());
						LOG.debug("doUpdateSiteAppDept depositStatus : "+semmsa002Bean.getSiteAppDeptBgObj().getDepositStatus());
						LOG.debug("doUpdateSiteAppDept userId : "+semmsa002Bean.getSiteAppDeptBgObj().getUserId());
						siteAppObj = semmsa002Bean.getSiteAppDeptBgObj();
					}
				}else{
					semmsa002Bean.setRenderedMsgDeposit(true);
					setSemmsa002Bean(semmsa002Bean);
					return flag;
				}
				
			}
			
			to = service.siteAppDao_querySPList(EQueryName.SP_MSA002_SITE_APP_DEPOSIT_UPD.name, siteAppObj);
			
			if (to != null && !to.isEmpty()) {
				String retMsg = to.get(0).getRetResultMsg() == null ? "" : to.get(0).getRetResultMsg().toString();
				
				if (to.get(0).getRetResult().equals("Success")) {

					
					String myMsgArr[];
					if(!retMsg.equals("")){
						myMsgArr = retMsg.split("<BR/>");
						
						for(int i=0; i < myMsgArr.length; i++){
							//addGeneralMessageInfo(myMsgArr[i]);
							//addGeneralMessageWarn(myMsgArr[i]);
							FrontMessageUtils.addMessageWarn(myMsgArr[i]);	// optional
						}
					}
					
					if(StringUtils.equals("08", expenseType)){
						this.doSiteAppDepositSrch();
						this.doClearSiteAppDepositEl();
					}else{
						this.doSiteAppDepositSrch();
						
						this.doClearSiteAppDeposit();
					}
					
					flag = true;
					semmsa002Bean.setRenderedMsgAlert(true);
				} else {
					if(to.get(0).getRetResult() != null){
//						if("FAIL".equals(to.get(0).getRetResult().toUpperCase())){
						if(to.get(0).getRetResult().toUpperCase().contains("FAIL")){
					        LOG.debug("===> CALL "+EQueryName.SP_MSA002_SITE_APP_DEPOSIT_UPD.name+ "==>Result :"+ to.get(0).getRetResult());
							semmsa002Bean.setDisabledButtonPopupResult(false);
						}else if("FAIL2".equals(to.get(0).getRetResult().toUpperCase())){
							semmsa002Bean.setDisabledButtonPopupResult(true);
						}
						
					}
//					System.out.println("to.get(0).getRetResultMsg() = "+to.get(0).getRetResultMsg());
					if(to.get(0).getRetResultMsg() != null)
						addGeneralMessageError(to.get(0).getRetResultMsg());	// data save fail
					else
						addMessageError("E0001");	// data save fail
	        		semmsa002Bean.setRenderedMsgAlert(true);
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doUpdateSiteAppDept : "+e);
		}
		LOG.debug(" #### End SEMMSA002Action doUpdateSiteAppDept ####");
		return flag;
	}
	
	public boolean doInitDetSiteAppDept(){
		LOG.debug(" #### Start SEMMSA002Action doInitDetSiteAppDept #### ");
		semmsa002Bean = getSemmsa002Bean();
		boolean flag = true;
		
		try{
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("Error SEMMSA002Action doInitDetSiteAppDept : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" #### End SEMMSA002Action doInitDetSiteAppDept #### ");
		}
		return flag;
	}
	
	public boolean doDetSiteAppDept(){
		LOG.debug(" #### Start SEMMSA002Action doDetSiteAppDept #### ");
		boolean flag = false;
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteAppSP> to = null;
		SiteAppSP siteAppObj = new SiteAppSP();
		try{
			//TODO get param
			String siteAppDepositId = getFacesUtils().getRequestParameter("siteAppDepositId") == null ? "" : (String)getFacesUtils().getRequestParameter("siteAppDepositId");
			String siteAppId = getFacesUtils().getRequestParameter("siteAppId") == null ? "" : (String)getFacesUtils().getRequestParameter("siteAppId");
			String expenseType = getFacesUtils().getRequestParameter("expenseType") == null ? "" : (String)getFacesUtils().getRequestParameter("expenseType");
			String serviceId = getFacesUtils().getRequestParameter("serviceId") == null ? "" : (String)getFacesUtils().getRequestParameter("serviceId");
//			String siteAppRentContMode = getFacesUtils().getRequestParameter("siteAppRentContMode") == null ? "" : (String)getFacesUtils().getRequestParameter("siteAppRentContMode");
			String userId = getUserLogIn();
			
			
			siteAppObj.setSiteAppDepositId(siteAppDepositId);
			siteAppObj.setSiteAppId(siteAppId);
			siteAppObj.setExpenseType(expenseType);
			siteAppObj.setServiceId(serviceId);
			siteAppObj.setUserId(userId);
			
			to = service.siteAppDao_querySPList(EQueryName.SP_MSA002_SITE_APP_DEPOSIT_DEL.name, siteAppObj);
			
			if (to != null && !to.isEmpty()) {
				String retMsg = to.get(0).getRetResultMsg() == null ? "" : to.get(0).getRetResultMsg().toString();
				
				if (to.get(0).getRetResult().equals("Success")) {

					
					String myMsgArr[];
					if(!retMsg.equals("")){
						myMsgArr = retMsg.split("<BR/>");
						
						for(int i=0; i < myMsgArr.length; i++){
							//addGeneralMessageInfo(myMsgArr[i]);
							//addGeneralMessageWarn(myMsgArr[i]);
							FrontMessageUtils.addMessageWarn(myMsgArr[i]);	// optional
						}
					}
					
					this.doSiteAppDepositSrch();
					
					flag = true;
					semmsa002Bean.setRenderedMsgAlert(true);
				} else {
					if(to.get(0).getRetResult() != null){
						if("FAIL".equals(to.get(0).getRetResult().toUpperCase())){
							semmsa002Bean.setDisabledButtonPopupResult(false);
						}else if("FAIL2".equals(to.get(0).getRetResult().toUpperCase())){
							semmsa002Bean.setDisabledButtonPopupResult(true);
						}
						
					}
//					System.out.println("to.get(0).getRetResultMsg() = "+to.get(0).getRetResultMsg());
					if(to.get(0).getRetResultMsg() != null)
						addGeneralMessageError(to.get(0).getRetResultMsg());	// data save fail
					else
						addMessageError("E0001");	// data save fail
	        		semmsa002Bean.setRenderedMsgAlert(true);
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doDetSiteAppDept : "+e);
		}
		LOG.debug(" #### End SEMMSA002Action doDetSiteAppDept #### ");
		return flag;
	}
	
	public void doRenderDeptBgCash(){
		LOG.debug(" #### Start SEMMSA002Action doRenderDeptBgCash ####");
		semmsa002Bean = getSemmsa002Bean();
		semmsa002Bean.setRenderedPnlDeptCash(false);
		semmsa002Bean.setRenderedPnlDeptBg(false);
		try{
			if(semmsa002Bean.getSiteAppDeptObj().getDepositType() != null){
				if(StringUtils.equals("02", semmsa002Bean.getSiteAppDeptObj().getDepositType())){
					semmsa002Bean.setRenderedPnlDeptCash(true);
					semmsa002Bean.setRenderedPnlDeptBg(false);
				}else if(StringUtils.equals("01", semmsa002Bean.getSiteAppDeptObj().getDepositType())){
					semmsa002Bean.setRenderedPnlDeptCash(false);
					semmsa002Bean.setRenderedPnlDeptBg(true);
				}
				semmsa002Bean.getSiteAppDeptObj().setExpenseType("");
				semmsa002Bean.getSiteAppDeptObj().setServiceId("");
				semmsa002Bean.getSiteAppDeptObj().setRemark("");
				semmsa002Bean.setSiteAppDeptCashObj(new SiteAppSP());
				semmsa002Bean.setSiteAppDeptBgObj(new SiteAppSP());
				setSemmsa002Bean(semmsa002Bean);
				this.initUpdDeptReturnType();
				this.doCalDepositReturnAmt();
				this.doCalDepositAmt();
				this.doInitDeposit();
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("Error SEMMSA002Action doRenderDeptBgCash : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" #### END SEMMSA002Action doRenderDeptBgCash ####");
		}
	}
	
	public boolean renderDeptReturnType(){
		LOG.debug(" #### START SEMMSA002Action renderDeptReturnType ####");
		semmsa002Bean = getSemmsa002Bean();
		
		try{
			String deptReturnType = getFacesUtils().getRequestParameter("deptReturnType") == null ? "" : (String)getFacesUtils().getRequestParameter("deptReturnType");
			if(deptReturnType != null){
				if(StringUtils.equals("01", deptReturnType)){
					if(semmsa002Bean.getSiteAppDeptObj().getDepositType() != null && StringUtils.equals("02", semmsa002Bean.getSiteAppDeptObj().getDepositType())){
						semmsa002Bean.getSiteAppDeptCashObj().setReturnAmt(null);
					}else if(semmsa002Bean.getSiteAppDeptObj().getDepositType() != null && StringUtils.equals("01", semmsa002Bean.getSiteAppDeptObj().getDepositType())){
						semmsa002Bean.getSiteAppDeptBgObj().setReturnAmt(null);
					}
					
					
//					semmsa002Bean.setDeptReturnType01(true);
					semmsa002Bean.setDeptReturnType02("");
					semmsa002Bean.setDeptReturnType03("");
				}
				
				if(StringUtils.equals("02", deptReturnType)){
					
					
					semmsa002Bean.setDeptReturnType01("");
//					semmsa002Bean.setDeptReturnType02(true);
					semmsa002Bean.setDeptReturnType03("");
				}
				
				if(StringUtils.equals("03", deptReturnType)){
					if(semmsa002Bean.getSiteAppDeptObj().getDepositType() != null && StringUtils.equals("02", semmsa002Bean.getSiteAppDeptObj().getDepositType())){
//						if(semmsa002Bean.getSiteAppDeptCashObj().getDepositAmtOld() != null && semmsa002Bean.getSiteAppDeptCashObj().getDepositAmtOld().compareTo(BigDecimal.valueOf(0.00)) > 0){
//							semmsa002Bean.getSiteAppDeptCashObj().setReturnAmt(semmsa002Bean.getSiteAppDeptCashObj().getDepositAmtOld());
//						}else{
//							semmsa002Bean.getSiteAppDeptCashObj().setReturnAmt(null);
//						}
						
					}else if(semmsa002Bean.getSiteAppDeptObj().getDepositType() != null && StringUtils.equals("01", semmsa002Bean.getSiteAppDeptObj().getDepositType())){
//						if(semmsa002Bean.getSiteAppDeptBgObj().getDepositAmtOld() != null && semmsa002Bean.getSiteAppDeptBgObj().getDepositAmtOld().compareTo(BigDecimal.valueOf(0.00)) > 0){
//							semmsa002Bean.getSiteAppDeptBgObj().setReturnAmt(semmsa002Bean.getSiteAppDeptBgObj().getDepositAmtOld());
//						}else
//						semmsa002Bean.getSiteAppDeptBgObj().setReturnAmt(null);
					}
					
					semmsa002Bean.setDeptReturnType01("");
					semmsa002Bean.setDeptReturnType02("");
//					semmsa002Bean.setDeptReturnType03(true);
				}
				if(semmsa002Bean.getSiteAppDeptObj().getDepositType() != null && StringUtils.equals("02", semmsa002Bean.getSiteAppDeptObj().getDepositType())){
					semmsa002Bean.getSiteAppDeptCashObj().setDepositReturnType(deptReturnType);
				}else if(semmsa002Bean.getSiteAppDeptObj().getDepositType() != null && StringUtils.equals("01", semmsa002Bean.getSiteAppDeptObj().getDepositType())){
					semmsa002Bean.getSiteAppDeptBgObj().setDepositReturnType(deptReturnType);
				}
				setSemmsa002Bean(semmsa002Bean);
				this.doCalDepositReturnAmt();
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("Error SEMMSA002Action renderDeptReturnType : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" #### END SEMMSA002Action renderDeptReturnType ####");
		}
		return true;
	}
	
	public void initUpdDeptReturnType(){
		LOG.debug(" #### START SEMMSA002Action initUpdDeptReturnType ####");
		semmsa002Bean = getSemmsa002Bean();
		try{
			if(semmsa002Bean.getSiteAppDeptObj().getDepositType() != null && StringUtils.equals("02", semmsa002Bean.getSiteAppDeptObj().getDepositType())){
				if(semmsa002Bean.getSiteAppDeptCashObj().getDepositReturnType() != null){
					if(StringUtils.isEmpty(semmsa002Bean.getSiteAppDeptCashObj().getDepositReturnType())){
						semmsa002Bean.getSiteAppDeptCashObj().setDepositReturnType("");
					}
					
					if(semmsa002Bean.getSiteAppDeptCashObj().getDepositReturnType() != null && semmsa002Bean.getSiteAppDeptCashObj().getDepositReturnType().equals("01")){
						semmsa002Bean.setDeptReturnType01(semmsa002Bean.getSiteAppDeptObj().getDepositReturnType());
						semmsa002Bean.setDeptReturnType02(null);
						semmsa002Bean.setDeptReturnType03(null);

						semmsa002Bean.getSiteAppDeptCashObj().setReturnAmt(BigDecimal.ZERO);
						
					}
					
					if(semmsa002Bean.getSiteAppDeptCashObj().getDepositReturnType() != null && semmsa002Bean.getSiteAppDeptCashObj().getDepositReturnType().equals("02")){
						semmsa002Bean.setDeptReturnType02(semmsa002Bean.getSiteAppDeptCashObj().getDepositReturnType());
						semmsa002Bean.setDeptReturnType01(null);
						semmsa002Bean.setDeptReturnType03(null);

//						semmsa002Bean.getSiteAppDeptObj().setReturnAmt(BigDecimal.ZERO);
						
					}
					
					if(semmsa002Bean.getSiteAppDeptCashObj().getDepositReturnType() != null && semmsa002Bean.getSiteAppDeptCashObj().getDepositReturnType().equals("03")){
						semmsa002Bean.setDeptReturnType03(semmsa002Bean.getSiteAppDeptCashObj().getDepositReturnType());
						semmsa002Bean.setDeptReturnType01(null);
						semmsa002Bean.setDeptReturnType02(null);

						semmsa002Bean.getSiteAppDeptCashObj().setReturnAmt(BigDecimal.ZERO);
						
					}
					
				}else{
					semmsa002Bean.setDeptReturnType01(null);
					semmsa002Bean.setDeptReturnType02(null);
					semmsa002Bean.setDeptReturnType03(null);

					semmsa002Bean.getSiteAppDeptCashObj().setReturnAmt(BigDecimal.ZERO);
				}
			}else if(semmsa002Bean.getSiteAppDeptObj().getDepositType() != null && StringUtils.equals("01", semmsa002Bean.getSiteAppDeptObj().getDepositType())){
				if(semmsa002Bean.getSiteAppDeptBgObj().getDepositReturnType() != null){
					if(StringUtils.isEmpty(semmsa002Bean.getSiteAppDeptBgObj().getDepositReturnType())){
						semmsa002Bean.getSiteAppDeptBgObj().setDepositReturnType("");
					}
					
					if(semmsa002Bean.getSiteAppDeptBgObj().getRentPaymentPeriod() != null && semmsa002Bean.getSiteAppDeptBgObj().getDepositReturnType().equals("01")){
						semmsa002Bean.setDeptReturnType01(semmsa002Bean.getSiteAppDeptObj().getDepositReturnType());
						semmsa002Bean.setDeptReturnType02(null);
						semmsa002Bean.setDeptReturnType03(null);

						semmsa002Bean.getSiteAppDeptBgObj().setReturnAmt(BigDecimal.ZERO);
						
					}
					
					if(semmsa002Bean.getSiteAppDeptBgObj().getRentPaymentPeriod() != null && semmsa002Bean.getSiteAppDeptBgObj().getDepositReturnType().equals("02")){
						semmsa002Bean.setDeptReturnType02(semmsa002Bean.getSiteAppDeptBgObj().getDepositReturnType());
						semmsa002Bean.setDeptReturnType01(null);
						semmsa002Bean.setDeptReturnType03(null);

//						semmsa002Bean.getSiteAppDeptObj().setReturnAmt(BigDecimal.ZERO);
						
					}
					
					if(semmsa002Bean.getSiteAppDeptBgObj().getRentPaymentPeriod() != null && semmsa002Bean.getSiteAppDeptBgObj().getDepositReturnType().equals("03")){
						semmsa002Bean.setDeptReturnType03(semmsa002Bean.getSiteAppDeptBgObj().getDepositReturnType());
						semmsa002Bean.setDeptReturnType01(null);
						semmsa002Bean.setDeptReturnType02(null);

						semmsa002Bean.getSiteAppDeptBgObj().setReturnAmt(BigDecimal.ZERO);
						
					}
					
				}else{
					semmsa002Bean.setDeptReturnType01(null);
					semmsa002Bean.setDeptReturnType02(null);
					semmsa002Bean.setDeptReturnType03(null);

					semmsa002Bean.getSiteAppDeptBgObj().setReturnAmt(BigDecimal.ZERO);
				}
			}else{
				semmsa002Bean.setDeptReturnType01(null);
				semmsa002Bean.setDeptReturnType02(null);
				semmsa002Bean.setDeptReturnType03(null);
				semmsa002Bean.getSiteAppDeptCashObj().setReturnAmt(BigDecimal.ZERO);
				semmsa002Bean.getSiteAppDeptBgObj().setReturnAmt(BigDecimal.ZERO);
			}
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("Error SEMMSA002Action initUpdDeptReturnType : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" #### END SEMMSA002Action initUpdDeptReturnType ####");
		}
	}
	
	public boolean doEditRentalDeposit(){
		LOG.debug(" ### START SEMMSA002Action doEditRentalDeposit ### ");
		boolean flag = true;
		semmsa002Bean = getSemmsa002Bean();
		String siteAppDepositId = getFacesUtils().getRequestParameter("siteAppDepositId") == null ? "" : (String)getFacesUtils().getRequestParameter("siteAppDepositId");
		String depositType = getFacesUtils().getRequestParameter("depositType") == null ? "" : (String)getFacesUtils().getRequestParameter("depositType");
		try{
			
			if(semmsa002Bean.getSiteAppRentCont() != null){
				if(StringUtils.equals("02", depositType)){
					for(WrapperBeanObject<SiteAppSP> rentContWrapObj : semmsa002Bean.getSiteAppDeptCashList()){
						SiteAppSP siteApp = new SiteAppSP(); 
						siteApp = (SiteAppSP) rentContWrapObj.getDataObj();
						
						if(StringUtils.equals(siteAppDepositId, siteApp.getSiteAppDepositId())){
							if(StringUtils.equals("Y", siteApp.getWithdrawFlag())){
								semmsa002Bean.setWithdrawFlag(true);
							}else{
								semmsa002Bean.setWithdrawFlag(false);
							}
							
							if(siteApp.getVatType() == null || StringUtils.equals("", siteApp.getVatType())){
								siteApp.setVatType("");
							}
//							siteApp.setRentContMode("C");
							semmsa002Bean.setSiteAppDeptObj(siteApp);
							semmsa002Bean.setSiteAppDeptCashObj(siteApp);
							
							setSemmsa002Bean(semmsa002Bean);
							this.doRenderEditDeptBgCash();
							this.initUpdDeptReturnType();
							this.doCalDepositReturnAmt();
							this.doCalDepositAmt();
							this.doInitDeposit();
						}
					}
				}
				
				if(StringUtils.equals("01", depositType)){
					for(WrapperBeanObject<SiteAppSP> rentContWrapObj : semmsa002Bean.getSiteAppDeptBGList()){
						SiteAppSP siteApp = new SiteAppSP(); 
						siteApp = (SiteAppSP) rentContWrapObj.getDataObj();
						
						if(StringUtils.equals(siteAppDepositId, siteApp.getSiteAppDepositId())){

							if(StringUtils.equals("Y", siteApp.getWithdrawFlag())){
								semmsa002Bean.setWithdrawFlag(true);
							}else{
								semmsa002Bean.setWithdrawFlag(false);
							}
							
//							siteApp.setRentContMode("C");
							semmsa002Bean.setSiteAppDeptObj(siteApp);
							semmsa002Bean.setSiteAppDeptBgObj(siteApp);
							setSemmsa002Bean(semmsa002Bean);
							this.doRenderEditDeptBgCash();
							this.initUpdDeptReturnType();
							this.doCalDepositReturnAmt();
							this.doCalDepositAmt();
							this.doInitDeposit();
						}
					}
				}
				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("ERROR SEMMSA002Action doEditRentalDeposit : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" ### END SEMMSA002Action doEditRentalDeposit ### ");
		}
		return flag;
	}
	
	public void doRenderEditDeptBgCash(){
		LOG.debug(" #### Start SEMMSA002Action doRenderEditDeptBgCash ####");
		semmsa002Bean = getSemmsa002Bean();
		semmsa002Bean.setRenderedPnlDeptCash(false);
		semmsa002Bean.setRenderedPnlDeptBg(false);
		try{
			if(semmsa002Bean.getSiteAppDeptObj().getDepositType() != null){
				if(StringUtils.equals("02", semmsa002Bean.getSiteAppDeptObj().getDepositType())){
					semmsa002Bean.setRenderedPnlDeptCash(true);
					semmsa002Bean.setRenderedPnlDeptBg(false);
				}else if(StringUtils.equals("01", semmsa002Bean.getSiteAppDeptObj().getDepositType())){
					semmsa002Bean.setRenderedPnlDeptCash(false);
					semmsa002Bean.setRenderedPnlDeptBg(true);
				}
				
//				semmsa002Bean.setSiteAppDeptCashObj(new SiteAppSP());
//				semmsa002Bean.setSiteAppDeptBgObj(new SiteAppSP());
//				setSemmsa002Bean(semmsa002Bean);
				this.initUpdDeptReturnType();
				this.doCalDepositReturnAmt();
				this.doCalDepositAmt();
				this.doInitDeposit();
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("Error SEMMSA002Action doRenderEditDeptBgCash : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" #### END SEMMSA002Action doRenderEditDeptBgCash ####");
		}
	}
	
	public void doInitDeposit(){
		LOG.debug(" ### START SEMMSA002Action doInitDeposit ### ");
		semmsa002Bean = getSemmsa002Bean();
		String depositType = semmsa002Bean.getSiteAppDeptObj().getDepositType();
		try{
			if(StringUtils.equals("02", depositType)){
				if(semmsa002Bean.getSiteAppDeptCashObj().getWithdrawFlag() != null && StringUtils.equals("Y", semmsa002Bean.getSiteAppDeptCashObj().getWithdrawFlag())){
					semmsa002Bean.setWithdrawFlag(true);
				}else{
					semmsa002Bean.setWithdrawFlag(false);
				}
				LOG.debug("doInitDeposit Cash getWithdrawFlag : "+semmsa002Bean.getSiteAppDeptCashObj().getWithdrawFlag());
			
			}
			
			if(StringUtils.equals("01", depositType)){
				if(semmsa002Bean.getSiteAppDeptBgObj().getWithdrawFlag() != null && StringUtils.equals("Y", semmsa002Bean.getSiteAppDeptBgObj().getWithdrawFlag())){
					semmsa002Bean.setWithdrawFlag(true);
				}else{
					semmsa002Bean.setWithdrawFlag(false);
				}
				LOG.debug("doInitDeposit BG getWithdrawFlag : "+semmsa002Bean.getSiteAppDeptBgObj().getWithdrawFlag());
			
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error(" Error SEMMSA002Action doInitDeposit ");
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" ### END SEMMSA002Action doInitDeposit ### ");
		}
	}
	
	public boolean doClearSiteAppDeposit(){
		LOG.debug(" #### Start SEMMSA002Action doClearSiteAppDeposit ####");
		semmsa002Bean = getSemmsa002Bean();
		try{
			semmsa002Bean.setSiteAppDeptObj(new SiteAppSP());
			semmsa002Bean.setSiteAppDeptCashObj(new SiteAppSP());
			semmsa002Bean.setSiteAppDeptBgObj(new SiteAppSP());
			setSemmsa002Bean(semmsa002Bean);
			this.initUpdDeptReturnType();
			this.doRenderDeptBgCash();
			//set default rental Deposit No Vat
			semmsa002Bean.getSiteAppDeptObj().setVatType("04");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doClearSiteAppDeposit : "+e);
		}
		LOG.debug(" #### End SEMMSA002Action doClearSiteAppDeposit ####");
		return true;
	}
	
	public void doCalDepositReturnAmt(){
		LOG.debug(" #### Start SEMMSA002Action doCalDepositReturnAmt ####");
		semmsa002Bean = getSemmsa002Bean();
		BigDecimal deptReturnAmt = BigDecimal.ZERO;
		try{
			if(semmsa002Bean.getSiteAppDeptCashObj().getDepositAmtOld() != null){
				deptReturnAmt = semmsa002Bean.getSiteAppDeptCashObj().getDepositAmtOld();
			}
			
			if(semmsa002Bean.getDeptReturnType02() != null && StringUtils.equals("02", semmsa002Bean.getDeptReturnType02())){
				if(semmsa002Bean.getSiteAppDeptCashObj().getReturnAmt() != null){
					deptReturnAmt = deptReturnAmt.add(semmsa002Bean.getSiteAppDeptCashObj().getReturnAmt().negate());
				}
				
			}
			
			
			semmsa002Bean.getSiteAppDeptCashObj().setDepositReturnAmt(deptReturnAmt);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("Error SEMMSA002Action doCalDepositReturnAmt : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" #### End SEMMSA002Action doCalDepositReturnAmt ####");
		}
	}
	
	public void doCalDepositAmt(){
		LOG.debug(" #### Start SEMMSA002Action doCalDepositAmt ####");
		semmsa002Bean = getSemmsa002Bean();
		BigDecimal deptReturnAmt = BigDecimal.ZERO;
		try{
			
			if(StringUtils.equals("02", semmsa002Bean.getSiteAppDeptObj().getDepositType())){
				if(semmsa002Bean.getSiteAppDeptCashObj().getDepositAmtOld() != null){
					deptReturnAmt = semmsa002Bean.getSiteAppDeptCashObj().getDepositAmtOld();
				}
			
				
//				if(semmsa002Bean.isWithdrawFlag()){
					if(semmsa002Bean.getSiteAppDeptCashObj().getDepositAmtNew() != null){
						deptReturnAmt = deptReturnAmt.add(semmsa002Bean.getSiteAppDeptCashObj().getDepositAmtNew());
					}
					
//				}
				
				
				semmsa002Bean.getSiteAppDeptCashObj().setDepositAmt(deptReturnAmt);
			}
			
			if(StringUtils.equals("01", semmsa002Bean.getSiteAppDeptObj().getDepositType())){
				if(semmsa002Bean.getSiteAppDeptBgObj().getDepositAmtOld() != null){
					deptReturnAmt = semmsa002Bean.getSiteAppDeptBgObj().getDepositAmtOld();
				}
			
				
//				if(semmsa002Bean.isWithdrawFlag()){
					if(semmsa002Bean.getSiteAppDeptBgObj().getDepositAmtNew() != null){
						deptReturnAmt = deptReturnAmt.add(semmsa002Bean.getSiteAppDeptBgObj().getDepositAmtNew());
					}
					
//				}
				
				
				semmsa002Bean.getSiteAppDeptBgObj().setDepositAmt(deptReturnAmt);
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("Error SEMMSA002Action doCalDepositAmt : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" #### End SEMMSA002Action doCalDepositAmt ####");
		}
	}
	
	public void doSiteAppELCondSrch(){
		LOG.debug(" #### Start SEMMSA002Action doSiteAppELCondSrch ####");
		semmsa002Bean = getSemmsa002Bean();
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteAppSP> to = null;
		try{
			LOG.debug("doSiteAppDeposotSrch getSiteAppId :"+semmsa002Bean.getSiteAppObjParam().getSiteAppId());
			SiteAppSP siteAppObj = new SiteAppSP();
			siteAppObj.setSiteAppId(semmsa002Bean.getSiteAppObjParam().getSiteAppId());
			siteAppObj.setMode("A");
			to = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA002_SITE_APP_EL_COND_SRCH.name, siteAppObj);
			LOG.debug("size [" + to.size() + "]");
			
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsa002Bean.setRenderedMsgDataNotFound(true);
				semmsa002Bean.setSiteAppELCondExistingList(null);
				
			}
			
			if(to != null && to.size() > 0){
//				flag = true;
				semmsa002Bean.setRenderedMsgDataNotFound(false);

				semmsa002Bean.setSiteAppDeptObj(new SiteAppSP());
				semmsa002Bean.setSiteAppELCondExistingList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
//				semmsa002Bean.setSiteAppDeptBGList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				
				for (int i = 0; i < to.size(); i++) {
					SiteAppSP siteAcq = (SiteAppSP) to.get(i);
					WrapperBeanObject<SiteAppSP> tmpWrapperBean = new WrapperBeanObject<SiteAppSP>();
					
//					if(siteAcq.getNoExpFlag() != null){
//						if(StringUtils.equals("Y", siteAcq.getNoExpFlag().toUpperCase())){
//							semmsa002Bean.setNoExpFlag(true);
//						}else{
//							semmsa002Bean.setNoExpFlag(false);
//						}
//					}else{
//						semmsa002Bean.setNoExpFlag(false);
//					}
					
					if(siteAcq.getEffectiveDt() != null){
						siteAcq.setEffectiveDtStr(convertYearENtoTHStr(siteAcq.getEffectiveDt()));
					}
					
					if(siteAcq.getExpireDt() != null){
						siteAcq.setExpireDtStr(convertYearENtoTHStr(siteAcq.getExpireDt()));
					}
					

					if(siteAcq.getElEffectiveDt() != null){
						siteAcq.setChgEffectiveDtStr(convertYearENtoTHStr(siteAcq.getElEffectiveDt()));
					}
					
					if(siteAcq.getPeriodStartDt() != null){
						siteAcq.setPeriodStartDtStr(convertYearENtoTHStr(siteAcq.getPeriodStartDt()));
					}
					
					if(siteAcq.getPeriodEndDt() != null){
						siteAcq.setPeriodEndDtStr(convertYearENtoTHStr(siteAcq.getPeriodEndDt()));
					}
//					
//					if(siteAcq.getEndDt() != null){
//						siteAcq.setEndDtStr(convertYearENtoTHStr(siteAcq.getEndDt()));
//					}
//					
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					tmpWrapperBean.setDataObj(siteAcq);
					
					if(siteAcq != null){
						semmsa002Bean.getSiteAppELCondExistingList().add(tmpWrapperBean);
						
					}
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doSiteAppELCondSrch : "+e);
		}finally{
			LOG.debug(" #### End SEMMSA002Action doSiteAppELCondSrch ####");
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	
	public void doSiteAppELCondSrch(String mode){
		LOG.debug(" #### Start SEMMSA002Action doSiteAppELCondSrch ####");
		semmsa002Bean = getSemmsa002Bean();
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteAppSP> to = null;
		try{
			LOG.debug("doSiteAppELCondSrch getSiteAppId :"+semmsa002Bean.getSiteAppObjParam().getSiteAppId());
			LOG.debug("doSiteAppELCondSrch mode : "+mode);
			SiteAppSP siteAppObj = new SiteAppSP();
			siteAppObj.setSiteAppId(semmsa002Bean.getSiteAppObjParam().getSiteAppId());
			siteAppObj.setMode(mode);
			to = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA002_SITE_APP_EL_COND_SRCH.name, siteAppObj);
			LOG.debug("size [" + to.size() + "]");
			
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsa002Bean.setRenderedMsgDataNotFound(true);
				if(StringUtils.equals("A", mode)){
					semmsa002Bean.setSiteAppELCondExistingList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				}else if(StringUtils.equals("U", mode)){
					semmsa002Bean.setSiteAppELCondUnitList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
					semmsa002Bean.setRenderedTbElUnit(false);
				}else if(StringUtils.equals("T", mode)){
					semmsa002Bean.setSiteAppELCondTakeAllList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
					semmsa002Bean.setRenderedTbElTakeAll(false);
				}else if(StringUtils.equals("O", mode)){
					semmsa002Bean.setSiteAppELCondOtherList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				}else if(StringUtils.equals("N", mode)){
					semmsa002Bean.setSiteAppELCondNoExpenseList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
					semmsa002Bean.setRenderedTbElNoExpense(false);
				}else if(StringUtils.equals("H", mode)){
					semmsa002Bean.setSiteAppELCondExistingList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
					
				}else if(StringUtils.equals("C", mode)){
					semmsa002Bean.setSiteAppELCondAllList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
					
				}
				
			}
			
			if(to != null && to.size() > 0){
//				flag = true;
				semmsa002Bean.setRenderedMsgDataNotFound(false);
				
				if(StringUtils.equals("A", mode)){
					semmsa002Bean.setSiteAppELCondExistingList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				/*else if(StringUtils.equals("U", mode)){
					semmsa002Bean.setSiteAppELCondAllList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
					semmsa002Bean.setSiteAppELCondUnitList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				}else if(StringUtils.equals("T", mode)){
					semmsa002Bean.setSiteAppELCondAllList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
					semmsa002Bean.setSiteAppELCondTakeAllList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				}else if(StringUtils.equals("O", mode)){
					semmsa002Bean.setSiteAppELCondOtherList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				}else if(StringUtils.equals("N", mode)){
					semmsa002Bean.setSiteAppELCondNoExpenseList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				}*/
				}else if(StringUtils.equals("C", mode)){
					semmsa002Bean.setSiteAppELCondAllList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				}else if(StringUtils.equals("H", mode)){
					semmsa002Bean.setSiteAppELCondExistingList(new ArrayList<WrapperBeanObject<SiteAppSP>>());	

				}
				for (int i = 0; i < to.size(); i++) {
					SiteAppSP siteAcq = (SiteAppSP) to.get(i);
					WrapperBeanObject<SiteAppSP> tmpWrapperBean = new WrapperBeanObject<SiteAppSP>();
					
//					if(siteAcq.getNoExpFlag() != null){
//						if(StringUtils.equals("Y", siteAcq.getNoExpFlag().toUpperCase())){
//							semmsa002Bean.setNoExpFlag(true);
//						}else{
//							semmsa002Bean.setNoExpFlag(false);
//						}
//					}else{
//						semmsa002Bean.setNoExpFlag(false);
//					}
					
					
					if(siteAcq.getEffectiveDt() != null){
						siteAcq.setEffectiveDtStr(convertYearENtoTHStr(siteAcq.getEffectiveDt()));
					}
					
					if(siteAcq.getExpireDt() != null){
						siteAcq.setExpireDtStr(convertYearENtoTHStr(siteAcq.getExpireDt()));
					}
					

					if(siteAcq.getElEffectiveDt() != null){
						siteAcq.setChgEffectiveDtStr(convertYearENtoTHStr(siteAcq.getElEffectiveDt()));
					}
					
					if(siteAcq.getPeriodStartDt() != null){
						siteAcq.setPeriodStartDtStr(convertYearENtoTHStr(siteAcq.getPeriodStartDt()));
					}
					
					if(siteAcq.getPeriodEndDt() != null){
						siteAcq.setPeriodEndDtStr(convertYearENtoTHStr(siteAcq.getPeriodEndDt()));
					}
					
//					if(siteAcq.getEndDt() != null){
//						siteAcq.setEndDtStr(convertYearENtoTHStr(siteAcq.getEndDt()));
//					}
//					
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					tmpWrapperBean.setDataObj(siteAcq);
					
					if(siteAcq.getElUseMultiResourse()!=null){
						if(siteAcq.getElUseMultiResourse().equalsIgnoreCase("Y")){
							semmsa002Bean.setChkMultiElectricTypeFlag(true);
						}
					}
					if(siteAcq != null){
						if(StringUtils.equals("A", mode)){
							semmsa002Bean.getSiteAppELCondExistingList().add(tmpWrapperBean);
						}
							/*}else if(StringUtils.equals("U", mode)){
							semmsa002Bean.getSiteAppELCondAllList().add(tmpWrapperBean);
							semmsa002Bean.getSiteAppELCondUnitList().add(tmpWrapperBean);
						}else if(StringUtils.equals("T", mode)){
							semmsa002Bean.getSiteAppELCondTakeAllList().add(tmpWrapperBean);
						}else if(StringUtils.equals("O", mode)){
							semmsa002Bean.getSiteAppELCondAllList().add(tmpWrapperBean);
							semmsa002Bean.getSiteAppELCondOtherList().add(tmpWrapperBean);
						}else if(StringUtils.equals("N", mode)){
							semmsa002Bean.getSiteAppELCondNoExpenseList().add(tmpWrapperBean);
						}*/
						else if(StringUtils.equals("H", mode)){
							semmsa002Bean.getSiteAppELCondExistingList().add(tmpWrapperBean);
						}
						else if(StringUtils.equals("C", mode)){
							semmsa002Bean.getSiteAppELCondAllList().add(tmpWrapperBean);
						}
//						semmsa002Bean.getSiteAppELCondExistingList().add(tmpWrapperBean);
						
					}
				}
				
				if(semmsa002Bean.getSiteAppELCondUnitList() != null && semmsa002Bean.getSiteAppELCondUnitList().size() > 0){
					semmsa002Bean.setRenderedTbElUnit(true);
				}else{
					semmsa002Bean.setRenderedTbElUnit(false);
				}
				
				if(semmsa002Bean.getSiteAppELCondTakeAllList() != null && semmsa002Bean.getSiteAppELCondTakeAllList().size() > 0){
					semmsa002Bean.setRenderedTbElTakeAll(true);
				}else{
					semmsa002Bean.setRenderedTbElTakeAll(false);
				}
				
				if(semmsa002Bean.getSiteAppELCondNoExpenseList() != null && semmsa002Bean.getSiteAppELCondNoExpenseList().size() > 0){
					semmsa002Bean.setRenderedTbElNoExpense(true);
				}else{
					semmsa002Bean.setRenderedTbElNoExpense(false);
				}
				
				setSemmsa002Bean(semmsa002Bean);
				this.initElUpdateCond();
				
			}
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doSiteAppELCondSrch : "+e);
		}finally{
			LOG.debug(" #### End SEMMSA002Action doSiteAppELCondSrch ####");
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	
	public void doSetELCheckBoxEntity() {
		
		try {
			
			semmsa002Bean = getSemmsa002Bean();

			// tab4
			if(semmsa002Bean.isChkElUseNewMeter()){
				semmsa002Bean.getSiteAppELObjParam().setElUseNewMeter("Y");
				semmsa002Bean.getSiteAppELObjParam().setElType1("Y");
			} else {
				semmsa002Bean.getSiteAppELObjParam().setElUseNewMeter("");
				semmsa002Bean.getSiteAppELObjParam().setElType1("");
			}
			
			if(semmsa002Bean.isChkElUseOwner()){
				semmsa002Bean.getSiteAppELObjParam().setElUseOwner("Y");
				semmsa002Bean.getSiteAppELObjParam().setElType3("Y");
			} else {
				semmsa002Bean.getSiteAppELObjParam().setElUseOwner("");
				semmsa002Bean.getSiteAppELObjParam().setElType3("");
			}

			if(semmsa002Bean.isChkElUseOldMeter()){
				semmsa002Bean.getSiteAppELObjParam().setElUseOldMeter("Y");
				semmsa002Bean.getSiteAppELObjParam().setElType2("Y");
			} else {
				semmsa002Bean.getSiteAppELObjParam().setElUseOldMeter("");
				semmsa002Bean.getSiteAppELObjParam().setElType2("");
			}

			if(semmsa002Bean.isChkElPayOnPackage()){
				semmsa002Bean.getSiteAppELObjParam().setElPayOnPackage("Y");
			} else {
				semmsa002Bean.getSiteAppELObjParam().setElPayOnPackage("");
			}

			if(semmsa002Bean.isChkElOwnerType()){
				semmsa002Bean.getSiteAppELObjParam().setElOwnerType("Y");
			} else {
				semmsa002Bean.getSiteAppELObjParam().setElOwnerType("");
			}
			
			if(semmsa002Bean.isChkElDepositFlag()){
				semmsa002Bean.getSiteAppELObjParam().setElDepositFlag("Y");
			} else {
				semmsa002Bean.getSiteAppELObjParam().setElDepositFlag("");
			}
			
			if(semmsa002Bean.isChkElUseOthSite()){
				semmsa002Bean.getSiteAppELObjParam().setElUseOthSite("Y");
				semmsa002Bean.getSiteAppELObjParam().setElType4("Y");
			} else {
				semmsa002Bean.getSiteAppELObjParam().setElUseOthSite("N");
				semmsa002Bean.getSiteAppELObjParam().setElType4("");
			}
			
			if(semmsa002Bean.isChkNoExpenses()){
				semmsa002Bean.getSiteAppELObjParam().setElNoExpenses("Y");
			}else{
				semmsa002Bean.getSiteAppELObjParam().setElNoExpenses("");
			}
			
			if(semmsa002Bean.isChkMultiElectricTypeFlag()){
				semmsa002Bean.getSiteAppELObjParam().setElUseMultiResourse("Y");
			}else{
				semmsa002Bean.getSiteAppELObjParam().setElUseMultiResourse("");
			}
			
			if(semmsa002Bean.isChkNoUtilPrice()){
				semmsa002Bean.getSiteAppELObjParam().setNoUtilPrice("Y");
			}else{
				semmsa002Bean.getSiteAppELObjParam().setNoUtilPrice("");
			}
			
			if(semmsa002Bean.isChkElUseOth()){
				semmsa002Bean.getSiteAppELObjParam().setElUseOth("Y");
			}else{
				semmsa002Bean.getSiteAppELObjParam().setElUseOth("");
			}
			
			
			setSemmsa002Bean(semmsa002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA002Action");
			
			semmsa002Bean.setRenderedMsgAlert(true);
			setSemmsa002Bean(semmsa002Bean);
		} finally {
			
		}
	}
	
	public boolean doValidateEl(){
		LOG.debug(" #### Start SEMMSA002Action doValidateEl ####");
		boolean flag = true;
		semmsa002Bean = getSemmsa002Bean();
		String elType = getFacesUtils().getRequestParameter("elType") == null ? "" : (String)getFacesUtils().getRequestParameter("elType");

		
		try{
			if(semmsa002Bean.isChkElUseOwner() && elType.equals("03")){
				if(!StringUtils.equals("00", semmsa002Bean.getSiteAppELObjParam().getElCondType())){
					if(StringUtils.isEmpty(semmsa002Bean.getSiteAppELObjParam().getElCondType())){
						addMessageError("W0001", msg("label.ELcond"));
						flag = false;
					}else{
						if(StringUtils.isEmpty(semmsa002Bean.getSiteAppELObjParam().getElCondSubType())){
							addMessageError("W0001", msg("label.ELcondOth"));
							flag = false;
						}
					}
				}
			}
			
			if(semmsa002Bean.isChkElUseOthSite() && elType.equals("04")){
				if(StringUtils.isEmpty(semmsa002Bean.getSiteAppELObjParam().getElUseOthSiteContractNo())){
					addMessageError("W0001", msg("label.conNo_siteuseel"));
					flag = false;
				}
			
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			 flag = false;
			 LOG.error(" #### Error SEMMSA002Action doValidateEl : "+e);
		}
		LOG.debug(" #### End SEMMSA002Action doValidateEl ####");
		return flag;
	}
	
	public boolean doInitAddSiteAppELCond(){
		LOG.debug(" ####### Start SEMMSA002Action doInitAddSiteAppELCond ######");
		boolean flag = true;
		semmsa002Bean = getSemmsa002Bean();
		try{
			String elType = getFacesUtils().getRequestParameter("elType") == null ? "" : (String)getFacesUtils().getRequestParameter("elType");
			if(StringUtils.equals("01", elType)){
				if(semmsa002Bean.isChkElUseNewMeter()){
					this.doAddSiteAppELCond();
				}else{
					this.doDetSiteAppELCond();
				}
			}else if(StringUtils.equals("02", elType)){
				if(semmsa002Bean.isChkElUseOldMeter()){
					this.doAddSiteAppELCond();
				}else{
					this.doDetSiteAppELCond();
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error(" #### Error SEMMSA002Action doInitAddSiteAppELCond : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" ####### Start SEMMSA002Action doInitAddSiteAppELCond ######");
		}
		return flag;
	}
	
	public boolean doAddSiteAppELCond(){
		LOG.debug(" #### Start SEMMSA002Action doAddSiteAppELCond ####");
		boolean flag = false;
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		semmsa002Bean = getSemmsa002Bean();
		List<SiteAppSP> to = null;
		String siteAppId = "";
		String depositType = "";
		SiteAppSP siteAppObj = new SiteAppSP();
		String mode = "";
		semmsa002Bean.setpRemark("");
		try{
			String elType = getFacesUtils().getRequestParameter("elType") == null ? "" : (String)getFacesUtils().getRequestParameter("elType");
			String serviceId = getFacesUtils().getRequestParameter("serviceId") == null ? "" : (String)getFacesUtils().getRequestParameter("serviceId");
			

			String elTypeSub = getFacesUtils().getRequestParameter("elTypeSub") == null ? "" : (String)getFacesUtils().getRequestParameter("elTypeSub");
			siteAppId = semmsa002Bean.getSiteAppObjParam().getSiteAppId();

			semmsa002Bean.getSiteAppELObjParam().setSiteAppId(siteAppId);
			semmsa002Bean.getSiteAppELObjParam().setUserId(getUserLogIn());
			semmsa002Bean.getSiteAppELObjParam().setElectricType(elType);
			
//			semmsa002Bean.getSiteAppELObjParam().setElRemark(semmsa002Bean.getSiteAppObjParam().getElRemark());
			
			if(semmsa002Bean.getSiteAppELObjParam().getElectricType().equals("01")){
//				semmsa002Bean.getSiteAppELObjParam().setElectricType(null);
				semmsa002Bean.setShowEditBtn(false);
			}
			
			if(this.doValidateEl()){
				Object obj = this.doMapELParamObj((Object)semmsa002Bean.getSiteAppELObjParam());
				SiteAppSP siteAppSP = new SiteAppSP();
				siteAppSP = (SiteAppSP)obj;
			
				LOG.debug("siteAppSP"+siteAppSP.getElType());
				LOG.debug("siteAppSP"+siteAppSP.getElectricType());
				
				to = service.siteAppDao_querySPList(EQueryName.SP_MSA002_SITE_APP_EL_COND_INS.name, siteAppSP);
				
				if (to != null && !to.isEmpty() && to.size() > 0) {
					String retMsg = to.get(0).getRetResultMsg() == null ? "" : to.get(0).getRetResultMsg().toString();
					
					if (StringUtils.equals("SUCCESS", to.get(0).getRetResult().toUpperCase())) {

						
						String myMsgArr[];
						if(!retMsg.equals("")){
							myMsgArr = retMsg.split("<BR/>");
							
							for(int i=0; i < myMsgArr.length; i++){
								//addGeneralMessageInfo(myMsgArr[i]);
								//addGeneralMessageWarn(myMsgArr[i]);
								FrontMessageUtils.addMessageWarn(myMsgArr[i]);	// optional
							}
						}
						
						// -- Start Save EL Type
						this.doUpdateAllonChangeTab();
						// -- End Save EL Type
						
						mode = "C";
						this.doSiteAppELCondSrch(mode);
					
						flag = true;
						semmsa002Bean.setRenderedMsgAlert(true);
						
						if ("03".equals(siteAppSP.getpSaElectricType())) {
							semmsa002Bean.setChkElUseOwner(true);

						} else if ("04".equals(siteAppSP.getpSaElectricType())) {
							semmsa002Bean.setChkElUseOthSite(true);

						} else if ("05".equals(siteAppSP.getpSaElectricType())) {
							semmsa002Bean.setChkElUseOth(true);
							semmsa002Bean.getSiteAppObjParam().setElRemark(null);

						}
						
						
						
						//TODO clear save param obj
						this.doClearSiteAppEl();
						
						
						
						semmsa002Bean.setpRemark("");
						
					} else {
						if(to.get(0).getRetResult() != null){
							 //if("FAIL".equals(to.get(0).getRetResult().toUpperCase())){
						       if(to.get(0).getRetResult().toUpperCase().contains("FAIL")){
						           LOG.debug("===> CALL "+EQueryName.SP_MSA002_SITE_APP_EL_COND_INS.name+ "==>Result :"+ to.get(0).getRetResult()); 
						        semmsa002Bean.setDisabledButtonPopupResult(false);
						        semmsa002Bean.setpRemark(to.get(0).getpRemark());
						       }else if("FAIL2".equals(to.get(0).getRetResult().toUpperCase())){
						        semmsa002Bean.setDisabledButtonPopupResult(true);
						       }
							
						}
//						System.out.println("to.get(0).getRetResultMsg() = "+to.get(0).getRetResultMsg());
						if(to.get(0).getRetResultMsg() != null)
							addGeneralMessageError(to.get(0).getRetResultMsg());	// data save fail
						else
							addMessageError("E0001");	// data save fail
		        		semmsa002Bean.setRenderedMsgAlert(true);
		        		
		        		
		        		//check checkBox
		        		System.out.println("getElType : "+siteAppSP.getElType());
						if (siteAppSP.getElType().equals("03")) {
							semmsa002Bean.setChkElUseOwner(true);

						} else if (siteAppSP.getElType().equals("04")) {
							semmsa002Bean.setChkElUseOthSite(true);

						} else if (siteAppSP.getElType().equals("05")) {
							
							semmsa002Bean.getSiteAppObjParam().setElRemark(null);

						}
		        		
					}
					
					
					semmsa002Bean.getSiteAppELObjParam().setElRemark("");
				}
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doAddSiteAppELCond : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" #### End SEMMSA002Action doAddSiteAppELCond ####");
		}
		
		return flag;
	}
	
	public Object doMapELParamObj(Object obj){
		Object object = new Object();
		object = obj;
		Object newObj = new Object();
		try{
			String elType = getFacesUtils().getRequestParameter("elType") == null ? "" : (String)getFacesUtils().getRequestParameter("elType");
			String elTypeSub = getFacesUtils().getRequestParameter("elTypeSub") == null ? "" : (String)getFacesUtils().getRequestParameter("elTypeSub");
			String serviceId = getFacesUtils().getRequestParameter("serviceId") == null ? "" : (String)getFacesUtils().getRequestParameter("serviceId");
			
			if((elType == "") && (semmsa002Bean.chkElUseOldMeter)){
				elType = "02"; 
			}
	
			SiteAppSP siteApp = new SiteAppSP();
			SiteAppSP siteAppObj = new SiteAppSP();
			if(object != null){
				siteApp = (SiteAppSP)object;
				if(siteApp.getSiteAppId() != null)siteAppObj.setSiteAppId(siteApp.getSiteAppId());
				if(siteApp.getSiteAppELContId() != null)siteAppObj.setSiteAppELContId(siteApp.getSiteAppELContId());
				if(siteApp.getElEffectiveDt() != null)siteAppObj.setElEffectiveDt(siteApp.getElEffectiveDt());
				if(elType != null)siteAppObj.setElOwnerType(elType);
				siteAppObj.setpElectricType(elType);
				siteAppObj.setServiceId(semmsa002Bean.getSiteAppELObjParam().getServiceId());
				siteAppObj.setUserId(getUserLogIn());
//				siteAppObj.setElType(elType);
				
				
				
				if(StringUtils.equals("03", elType)){//ELUserOwner
//					semmsa002Bean.chkElUseOwner
					if(siteApp.getElCondSubType() != null)siteAppObj.setElCondSubType(siteApp.getElCondSubType());
					if(semmsa002Bean.isChkElUseOwner()){
						siteAppObj.setElUseOwner("Y");
						siteAppObj.setElType3("Y");
					} else {
						siteAppObj.setElUseOwner("");
						siteAppObj.setElType3("");
					}
					siteAppObj.setpSaElectricType("03");
					siteAppObj.setElPayPeriod(semmsa002Bean.getElPayPeriod04());
					
					if(siteApp.getElCondType() != null)siteAppObj.setElCondType(siteApp.getElCondType());
					if(siteApp.getElCondSubType() != null)siteAppObj.setElCondSubType(siteApp.getElCondSubType());
					if(siteApp.getElEffectiveDt03() != null)siteAppObj.setElEffectiveDt(siteApp.getElEffectiveDt03());
					//unit
					if(StringUtils.equals("01", elTypeSub)){
//						siteAppObj.setpSaElectricType("03");
						
						//Add actually use
						if(siteApp.getElPayOnPackageAmt() != null)siteAppObj.setElPayOnPackageAmt(siteApp.getElPayOnPackageAmt());
						if(siteApp.getElPackagePeriodType() != null)siteAppObj.setElPackagePeriodType(siteApp.getElPackagePeriodType());
						if(siteApp.getElVatType() != null)siteAppObj.setElVatType(siteApp.getElVatType());
						if(siteApp.getWhtType() != null)siteAppObj.setWhtType(siteApp.getWhtType());
						if(siteApp.getElPayPeriod() != null)siteAppObj.setElPayPeriod(siteApp.getElPayPeriod());
						if(siteApp.getPayPeriodType() != null)siteAppObj.setPayPeriodType(siteApp.getPayPeriodType());
						if(siteApp.getTakeAllAmt() != null)siteAppObj.setTakeAllAmt(siteApp.getTakeAllAmt());
						if(siteApp.getTakeAllPeriodType() != null)siteAppObj.setTakeAllPeriodType(siteApp.getTakeAllPeriodType());
						if(siteApp.getPeriodStartDt() != null)siteAppObj.setPeriodStartDt(siteApp.getPeriodStartDt());
						if(siteApp.getPeriodEndDt() != null)siteAppObj.setPeriodEndDt(siteApp.getPeriodEndDt());
						
						if(siteApp.getElUnitPrice() != null)siteAppObj.setElUnitPrice(siteApp.getElUnitPrice());
						if(semmsa002Bean.isChkNoUtilPrice()){
							siteAppObj.setNoUtilPrice("Y");
						}else{
							siteAppObj.setNoUtilPrice("");
						}
						
						if(semmsa002Bean.getElPayPeriodType01() != "" && semmsa002Bean.getElPayPeriodType01() !=null){
							siteAppObj.setPayPeriodType("01");
						}else if(semmsa002Bean.getElPayPeriodType02() != "" && semmsa002Bean.getElPayPeriodType02() !=null){
							siteAppObj.setPayPeriodType("02");
						}else if(semmsa002Bean.getElPayPeriodType03() != "" && semmsa002Bean.getElPayPeriodType03() !=null){
							siteAppObj.setPayPeriodType("03");
						}else if(semmsa002Bean.getElPayPeriodType04() != "" && semmsa002Bean.getElPayPeriodType04() !=null){
							siteAppObj.setPayPeriodType("04");
						}else if(semmsa002Bean.getElPayPeriodType05() != "" && semmsa002Bean.getElPayPeriodType05() !=null){
							siteAppObj.setPayPeriodType("05");
						}else if(semmsa002Bean.getElPayPeriodType06() != "" && semmsa002Bean.getElPayPeriodType06() !=null){
							siteAppObj.setPayPeriodType("06");
						}else if(semmsa002Bean.getElPayPeriodType07() != "" && semmsa002Bean.getElPayPeriodType07() !=null){
							siteAppObj.setPayPeriodType("07");
						}
						
						
						
					}else if(StringUtils.equals("02", elTypeSub)){//takeAll
						if(siteApp.getElPayOnPackageAmt() != null)siteAppObj.setElPayOnPackageAmt(siteApp.getElPayOnPackageAmt());
						if(siteApp.getElPackagePeriodType() != null)siteAppObj.setElPackagePeriodType(siteApp.getElPackagePeriodType());
						if(siteApp.getDetail() != null)siteAppObj.setDetail(siteApp.getDetail());
							if(siteApp.getElVatType().equalsIgnoreCase("")){
								siteApp.setElVatType("04");
							}
						if(siteApp.getElVatType() != null)siteAppObj.setElVatType(siteApp.getElVatType());
						if(siteApp.getWhtType() != null)siteAppObj.setWhtType(siteApp.getWhtType());
						if(siteApp.getElPayPeriod() != null)siteAppObj.setElPayPeriod(siteApp.getElPayPeriod());
						if(siteApp.getPayPeriodType() != null)siteAppObj.setPayPeriodType(siteApp.getPayPeriodType());
						if(siteApp.getTakeAllAmt() != null)siteAppObj.setTakeAllAmt(siteApp.getTakeAllAmt());
						if(siteApp.getTakeAllPeriodType() != null)siteAppObj.setTakeAllPeriodType(siteApp.getTakeAllPeriodType());
						if(siteApp.getPeriodStartDt() != null)siteAppObj.setPeriodStartDt(siteApp.getPeriodStartDt());
						if(siteApp.getPeriodEndDt() != null)siteAppObj.setPeriodEndDt(siteApp.getPeriodEndDt());
						if(siteApp.getDetail03() != null)siteAppObj.setDetail(siteApp.getDetail03());
						
						if(semmsa002Bean.getElPayPeriodType01() != "" && semmsa002Bean.getElPayPeriodType01() !=null){
							siteAppObj.setPayPeriodType("01");
						}else if(semmsa002Bean.getElPayPeriodType02() != "" && semmsa002Bean.getElPayPeriodType02() !=null){
							siteAppObj.setPayPeriodType("02");
						}else if(semmsa002Bean.getElPayPeriodType03() != "" && semmsa002Bean.getElPayPeriodType03() !=null){
							siteAppObj.setPayPeriodType("03");
						}else if(semmsa002Bean.getElPayPeriodType04() != "" && semmsa002Bean.getElPayPeriodType04() !=null){
							siteAppObj.setPayPeriodType("04");
						}else if(semmsa002Bean.getElPayPeriodType05() != "" && semmsa002Bean.getElPayPeriodType05() !=null){
							siteAppObj.setPayPeriodType("05");
						}else if(semmsa002Bean.getElPayPeriodType06() != "" && semmsa002Bean.getElPayPeriodType06() !=null){
							siteAppObj.setPayPeriodType("06");
						}else if(semmsa002Bean.getElPayPeriodType07() != "" && semmsa002Bean.getElPayPeriodType07() !=null){
							siteAppObj.setPayPeriodType("07");
						}
						
						
						siteAppObj.setpSaElectricType("03");
					}else{
						siteAppObj.setpSaElectricType("03");
						if(siteApp.getPeriodStartDt() != null)siteAppObj.setPeriodStartDt(siteApp.getPeriodStartDt());
						if(siteApp.getPeriodEndDt() != null)siteAppObj.setPeriodEndDt(siteApp.getPeriodEndDt());
					}
				
				}else if(StringUtils.equals("04", elType)){
					//EL Other Site
					siteAppObj.setpSaElectricType("04");	
					
					if(semmsa002Bean.isChkElUseOthSite()){
						siteAppObj.setElUseOthSite("Y");
						siteAppObj.setElType4("Y");
					} else {
						siteAppObj.setElUseOthSite("N");
						siteAppObj.setElType4("");
					}
					if(siteApp.getElUseOthSiteContractNo() != null)siteAppObj.setElUseOthSiteContractNo(siteApp.getElUseOthSiteContractNo());
					if(siteApp.getElRemark() != null)siteAppObj.setElRemark(siteApp.getElRemark());
					if(siteApp.getElEffectiveDt() != null)siteAppObj.setElEffectiveDt(siteApp.getElEffectiveDt());
					if(siteApp.getDetail04() != null)siteAppObj.setDetail(siteApp.getDetail04());	
					if(siteApp.getElEffectiveDt04() != null)siteAppObj.setElEffectiveDt(siteApp.getElEffectiveDt04());
					
					
				}else if(StringUtils.equals("05", elType)){
					siteAppObj.setDetail(siteApp.getDetail05());
					siteAppObj.setpSaElectricType("05");
					
				}
				else if(StringUtils.equals("01", elType)){
					siteAppObj.setpSaElectricType("01");
					siteAppObj.setElType("");
					siteAppObj.setElectricType("");
					if(siteApp.getPeriodStartDt() != null)siteAppObj.setPeriodStartDt(siteApp.getEndDt());
					if(siteApp.getPeriodEndDt() != null)siteAppObj.setPeriodEndDt(siteApp.getPeriodEndDt());
					
					
				}else if(StringUtils.equals("02", elType)){
					siteAppObj.setpSaElectricType("02");
					siteAppObj.setElType("");
				}
				
				//Debug 
				LOG.debug("doMapELParamObj : siteAppId : "+siteAppObj.getSiteAppId());
				LOG.debug("doMapELParamObj : getFromSiteInfoId : "+siteAppObj.getFromSiteInfoId()); 
				LOG.debug("doMapELParamObj : getRemark : "+siteAppObj.getRemark()); 
				LOG.debug("doMapELParamObj : getElOwnerType : "+siteAppObj.getElOwnerType()); 
				LOG.debug("doMapELParamObj : getElType : "+siteAppObj.getElType()); 
				LOG.debug("doMapELParamObj : getpSaElectricType : "+siteAppObj.getpSaElectricType()); 
				LOG.debug("doMapELParamObj : getTakeAllAmt : "+siteAppObj.getTakeAllAmt()); 
				LOG.debug("doMapELParamObj : getTakeAllPeriodType : "+siteAppObj.getTakeAllPeriodType()); 
				LOG.debug("doMapELParamObj : getElUnitPrice : "+siteAppObj.getElUnitPrice());
				LOG.debug("doMapELParamObj : getPayPeriodType : "+siteAppObj.getPayPeriodType()); 
				LOG.debug("doMapELParamObj : getElPayPeriod : "+siteAppObj.getElPayPeriod()); 
				LOG.debug("doMapELParamObj : getDepositCondType : "+siteAppObj.getDepositCondType()); 
				LOG.debug("doMapELParamObj : getElUseMultiResourse : "+siteAppObj.getElUseMultiResourse()); 
				LOG.debug("doMapELParamObj : getElType1 : "+siteAppObj.getElType1()); 
				LOG.debug("doMapELParamObj : getElType2 : "+siteAppObj.getElType2()); 
				LOG.debug("doMapELParamObj : getElType3 : "+siteAppObj.getElType3()); 
				LOG.debug("doMapELParamObj : getElType4 : "+siteAppObj.getElType4()); 
				LOG.debug("doMapELParamObj : getNoUtilPrice : "+siteAppObj.getNoUtilPrice()); 
				LOG.debug("doMapELParamObj : getElUseOthSiteContractNo : "+siteAppObj.getElUseOthSiteContractNo()); 
				LOG.debug("doMapELParamObj : getVersion : "+siteAppObj.getVersion()); 
				LOG.debug("doMapELParamObj : getTotalDepositBgAmt : "+siteAppObj.getTotalDepositBgAmt()); 
				LOG.debug("doMapELParamObj : getTotalDepositCashAmt : "+siteAppObj.getTotalDepositCashAmt()); 
				LOG.debug("doMapELParamObj : getNoDeposit : "+siteAppObj.getNoDeposit()); 
				LOG.debug("doMapELParamObj : getElEffectiveDt : "+siteAppObj.getElEffectiveDt()); 
				LOG.debug("doMapELParamObj : getDetail : "+siteAppObj.getDetail()); 
				LOG.debug("doMapELParamObj : getElOldAmt  : "+siteAppObj.getElOldAmt()); 
				LOG.debug("doMapELParamObj : getElAddPercent : "+siteAppObj.getElAddPercent()); 
				LOG.debug("doMapELParamObj : getElAddAmt : "+siteAppObj.getElAddAmt()); 
				LOG.debug("doMapELParamObj : getElAmt : "+siteAppObj.getElAmt()); 
				LOG.debug("doMapELParamObj : getElPeriodType : "+siteAppObj.getElPeriodType());
				LOG.debug("doMapELParamObj : getWhtType : "+siteAppObj.getWhtType()); 
				LOG.debug("doMapELParamObj : getWhtRate : "+siteAppObj.getWhtRate()); 
				LOG.debug("doMapELParamObj : getWhtRate : "+siteAppObj.getElVatType()); 
				LOG.debug("doMapELParamObj : getPeriodStartDt : "+siteAppObj.getPeriodStartDt()); 
				LOG.debug("doMapELParamObj : getPeriodEndDt : "+siteAppObj.getPeriodEndDt()); 
				LOG.debug("doMapELParamObj : getElAdj : "+siteAppObj.getElAdj()); 
				LOG.debug("doMapELParamObj : getElAdjPeriodType : "+siteAppObj.getElAdjPeriodType()); 
				LOG.debug("doMapELParamObj : getServiceId : "+siteAppObj.getServiceId());
				LOG.debug("doMapELParamObj : getElOldPeriodType : "+siteAppObj.getElOldPeriodType()); 
				LOG.debug("doMapELParamObj : getElAddPeriodType : "+siteAppObj.getElAddPeriodType()); 
				LOG.debug("doMapELParamObj : getRefSiteElCond : "+siteAppObj.getRefSiteElCond()); 
				LOG.debug("doMapELParamObj : getElCondType : "+siteAppObj.getElCondType());
				LOG.debug("doMapELParamObj : getElCondSubType : "+siteAppObj.getElCondSubType());
				LOG.debug("doMapELParamObj : getUserId : "+siteAppObj.getUserId()); 
				newObj = (Object)siteAppObj;
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("ERROR doMapELParamObj : "+e);
		}
		return newObj;
	}
	
	public Object doMapELParamObjForUpdate(Object obj){
		Object object = new Object();
		object = obj;
		Object newObj = new Object();
		try{
			String elType = getFacesUtils().getRequestParameter("elType") == null ? "" : (String)getFacesUtils().getRequestParameter("elType");
			String elTypeSub = getFacesUtils().getRequestParameter("elTypeSub") == null ? "" : (String)getFacesUtils().getRequestParameter("elTypeSub");
			String serviceId = getFacesUtils().getRequestParameter("serviceId") == null ? "" : (String)getFacesUtils().getRequestParameter("serviceId");

//			elType = semmsa002Bean.getSiteAppELObjParam().getElectricType();
			String siteAppId = semmsa002Bean.getSiteAppELObjParam().getSiteAppId();
			String siteAppELContId = semmsa002Bean.getSiteAppELObjParam().getSiteAppELContId();
			Date effectiveDt = semmsa002Bean.getSiteAppELObjParam().getEffectiveDt();
			Date expire = semmsa002Bean.getSiteAppELObjParam().getExpireDt();
			
			SiteAppSP siteApp = new SiteAppSP();
			SiteAppSP siteAppObj = new SiteAppSP();
			if(object != null){
				siteApp = (SiteAppSP)object;
				if(siteApp.getSiteAppId() != null)siteAppObj.setSiteAppId(siteAppId);
				if(siteApp.getSiteAppELContId() != null)siteAppObj.setSiteAppELContId(siteAppELContId);
				if(siteApp.getElEffectiveDt() != null)siteAppObj.setElEffectiveDt(effectiveDt);
				if(elType != null)siteAppObj.setElOwnerType(elType);
				siteAppObj.setServiceId(semmsa002Bean.getSiteAppELObjParam().getServiceId());
				siteAppObj.setUserId(getUserLogIn());
//				siteAppObj.setElType(elType);
//				siteAppObj.setElectricType(elType);
//				
				
				if(StringUtils.equals("03", elType)){//ELUserOwner
//					semmsa002Bean.chkElUseOwner
					if(siteApp.getElCondSubType() != null)siteAppObj.setElCondSubType(siteApp.getElCondSubType());
					if(semmsa002Bean.isChkElUseOwner()){
						siteAppObj.setElUseOwner("Y");
						siteAppObj.setElType3("Y");
					} else {
						siteAppObj.setElUseOwner("");
						siteAppObj.setElType3("");
					}
					
					
					
					if(siteApp.getElCondType() != null)siteAppObj.setElCondType(siteApp.getElCondType());
					if(siteApp.getElCondSubType() != null)siteAppObj.setElCondSubType(siteApp.getElCondSubType());
					if(siteApp.getElEffectiveDt03() != null)siteAppObj.setElEffectiveDt(siteApp.getElEffectiveDt03());
					//unit
					if(StringUtils.equals("01", elTypeSub)){
						System.out.println("siteApp.getElPayPeriod( : "+siteApp.getElPayPeriod());
						//Add actually use
						if(siteApp.getElPayOnPackageAmt() != null)siteAppObj.setElPayOnPackageAmt(siteApp.getElPayOnPackageAmt());
						if(siteApp.getElPackagePeriodType() != null)siteAppObj.setElPackagePeriodType(siteApp.getElPackagePeriodType());
						if(siteApp.getElVatType() != null)siteAppObj.setElVatType(siteApp.getElVatType());
						if(siteApp.getWhtType() != null)siteAppObj.setWhtType(siteApp.getWhtType());
						if(siteApp.getElPayPeriod() != null)siteAppObj.setElPayPeriod(siteApp.getElPayPeriod());
						if(siteApp.getPayPeriodType() != null)siteAppObj.setPayPeriodType(siteApp.getPayPeriodType());
						if(siteApp.getTakeAllAmt() != null)siteAppObj.setTakeAllAmt(siteApp.getTakeAllAmt());
						if(siteApp.getTakeAllPeriodType() != null)siteAppObj.setTakeAllPeriodType(siteApp.getTakeAllPeriodType());
						if(siteApp.getPeriodStartDt() != null)siteAppObj.setPeriodStartDt(effectiveDt);
						if(siteApp.getPeriodEndDt() != null)siteAppObj.setPeriodEndDt(siteApp.getPeriodEndDt());
						
						if(siteApp.getElUnitPrice() != null)siteAppObj.setElUnitPrice(siteApp.getElUnitPrice());
						if(semmsa002Bean.isChkNoUtilPrice()){
							siteAppObj.setNoUtilPrice("Y");
						}else{
							siteAppObj.setNoUtilPrice("");
						}

						
						
					}else if(StringUtils.equals("02", elTypeSub)){//takeAll
						if(siteApp.getElPayOnPackageAmt() != null)siteAppObj.setElPayOnPackageAmt(siteApp.getElPayOnPackageAmt());
						if(siteApp.getElPackagePeriodType() != null)siteAppObj.setElPackagePeriodType(siteApp.getElPackagePeriodType());
						if(siteApp.getDetail() != null)siteAppObj.setDetail(siteApp.getDetail());
						if(siteApp.getElVatType() != null)siteAppObj.setElVatType(siteApp.getElVatType());
						if(siteApp.getWhtType() != null)siteAppObj.setWhtType(siteApp.getWhtType());
						if(siteApp.getElPayPeriod() != null)siteAppObj.setElPayPeriod(siteApp.getElPayPeriod());
						if(siteApp.getPayPeriodType() != null)siteAppObj.setPayPeriodType(siteApp.getPayPeriodType());
						if(siteApp.getTakeAllAmt() != null)siteAppObj.setTakeAllAmt(siteApp.getTakeAllAmt());
						if(siteApp.getTakeAllPeriodType() != null)siteAppObj.setTakeAllPeriodType(siteApp.getTakeAllPeriodType());
						if(siteApp.getPeriodStartDt() != null)siteAppObj.setPeriodStartDt(siteApp.getPeriodStartDt());
						if(siteApp.getPeriodEndDt() != null)siteAppObj.setPeriodEndDt(siteApp.getPeriodEndDt());
						if(siteApp.getDetail03() != null)siteAppObj.setDetail(siteApp.getDetail03());
					}
					siteAppObj.setpSaElectricType("03");
				}else if(StringUtils.equals("04", elType)){
					//EL Other Site
					siteAppObj.setpSaElectricType("04");
					if(semmsa002Bean.isChkElUseOthSite()){
						siteAppObj.setElUseOthSite("Y");
						siteAppObj.setElType4("Y");
					} else {
						siteAppObj.setElUseOthSite("N");
						siteAppObj.setElType4("");
					}
					if(siteApp.getElUseOthSiteContractNo() != null)siteAppObj.setElUseOthSiteContractNo(siteApp.getElUseOthSiteContractNo());
					if(siteApp.getContractNo() != null)siteAppObj.setElUseOthSiteContractNo(siteApp.getElUseOthSiteContractNo());
					if(siteApp.getElRemark() != null)siteAppObj.setElRemark(siteApp.getElRemark());
					if(siteApp.getElEffectiveDt() != null)siteAppObj.setElEffectiveDt(siteApp.getElEffectiveDt());
					if(siteApp.getDetail() != null)siteAppObj.setDetail(siteApp.getDetail());	
					if(siteApp.getElEffectiveDt04() != null)siteAppObj.setElEffectiveDt(siteApp.getElEffectiveDt04());
				
				}else if(StringUtils.equals("05", elType)){
					if(siteApp.getDetail05() != null)siteAppObj.setDetail(siteApp.getDetail05());	
					siteAppObj.setpSaElectricType("05");
				}
				
				
				//Debug 
				LOG.debug("doMapELParamObj : siteAppId : "+siteAppObj.getSiteAppId());
				LOG.debug("doMapELParamObj : getFromSiteInfoId : "+siteAppObj.getFromSiteInfoId()); 
				LOG.debug("doMapELParamObj : getRemark : "+siteAppObj.getRemark()); 
				LOG.debug("doMapELParamObj : getElOwnerType : "+siteAppObj.getElOwnerType()); 
				LOG.debug("doMapELParamObj : getElType : "+siteAppObj.getElType()); 
				LOG.debug("doMapELParamObj : getTakeAllAmt : "+siteAppObj.getTakeAllAmt()); 
				LOG.debug("doMapELParamObj : getTakeAllPeriodType : "+siteAppObj.getTakeAllPeriodType()); 
				LOG.debug("doMapELParamObj : getElUnitPrice : "+siteAppObj.getElUnitPrice());
				LOG.debug("doMapELParamObj : getPayPeriodType : "+siteAppObj.getPayPeriodType()); 
				LOG.debug("doMapELParamObj : getElPayPeriod : "+siteAppObj.getElPayPeriod()); 
				LOG.debug("doMapELParamObj : getDepositCondType : "+siteAppObj.getDepositCondType()); 
				LOG.debug("doMapELParamObj : getElUseMultiResourse : "+siteAppObj.getElUseMultiResourse()); 
				LOG.debug("doMapELParamObj : getElType1 : "+siteAppObj.getElType1()); 
				LOG.debug("doMapELParamObj : getElType2 : "+siteAppObj.getElType2()); 
				LOG.debug("doMapELParamObj : getElType3 : "+siteAppObj.getElType3()); 
				LOG.debug("doMapELParamObj : getElType4 : "+siteAppObj.getElType4()); 
				LOG.debug("doMapELParamObj : getNoUtilPrice : "+siteAppObj.getNoUtilPrice()); 
				LOG.debug("doMapELParamObj : getElUseOthSiteContractNo : "+siteAppObj.getElUseOthSiteContractNo()); 
				LOG.debug("doMapELParamObj : getVersion : "+siteAppObj.getVersion()); 
				LOG.debug("doMapELParamObj : getTotalDepositBgAmt : "+siteAppObj.getTotalDepositBgAmt()); 
				LOG.debug("doMapELParamObj : getTotalDepositCashAmt : "+siteAppObj.getTotalDepositCashAmt()); 
				LOG.debug("doMapELParamObj : getNoDeposit : "+siteAppObj.getNoDeposit()); 
				LOG.debug("doMapELParamObj : getElEffectiveDt : "+siteAppObj.getElEffectiveDt()); 
				LOG.debug("doMapELParamObj : getDetail : "+siteAppObj.getDetail()); 
				LOG.debug("doMapELParamObj : getElOldAmt  : "+siteAppObj.getElOldAmt()); 
				LOG.debug("doMapELParamObj : getElAddPercent : "+siteAppObj.getElAddPercent()); 
				LOG.debug("doMapELParamObj : getElAddAmt : "+siteAppObj.getElAddAmt()); 
				LOG.debug("doMapELParamObj : getElAmt : "+siteAppObj.getElAmt()); 
				LOG.debug("doMapELParamObj : getElPeriodType : "+siteAppObj.getElPeriodType());
				LOG.debug("doMapELParamObj : getWhtType : "+siteAppObj.getWhtType()); 
				LOG.debug("doMapELParamObj : getWhtRate : "+siteAppObj.getWhtRate()); 
				LOG.debug("doMapELParamObj : getWhtRate : "+siteAppObj.getElVatType()); 
				LOG.debug("doMapELParamObj : getPeriodStartDt : "+siteAppObj.getPeriodStartDt()); 
				LOG.debug("doMapELParamObj : getPeriodEndDt : "+siteAppObj.getPeriodEndDt()); 
				LOG.debug("doMapELParamObj : getElAdj : "+siteAppObj.getElAdj()); 
				LOG.debug("doMapELParamObj : getElAdjPeriodType : "+siteAppObj.getElAdjPeriodType()); 
				LOG.debug("doMapELParamObj : getServiceId : "+siteAppObj.getServiceId());
				LOG.debug("doMapELParamObj : getElOldPeriodType : "+siteAppObj.getElOldPeriodType()); 
				LOG.debug("doMapELParamObj : getElAddPeriodType : "+siteAppObj.getElAddPeriodType()); 
				LOG.debug("doMapELParamObj : getRefSiteElCond : "+siteAppObj.getRefSiteElCond()); 
				LOG.debug("doMapELParamObj : getElCondType : "+siteAppObj.getElCondType());
				LOG.debug("doMapELParamObj : getElCondSubType : "+siteAppObj.getElCondSubType());
				LOG.debug("doMapELParamObj : getUserId : "+siteAppObj.getUserId()); 
				newObj = (Object)siteAppObj;
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("ERROR doMapELParamObj : "+e);
		}
		return newObj;
	}
	public boolean doUpdateSiteAppELCond(){
		LOG.debug(" #### Start SEMMSA002Action doUpdateSiteAppELCond ####");
		boolean flag = false;
		semmsa002Bean = getSemmsa002Bean();
		String siteAppId = "";
		String depositType = "";
		SiteAppSP siteAppObj = new SiteAppSP();
		semmsa002Bean.setpRemark("");
		System.out.println(semmsa002Bean.getSiteAppELObjParam().getElUnitPrice());
		
		try{
			ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
			List<SiteAppSP> to = null;
			String elType = getFacesUtils().getRequestParameter("elType") == null ? "" : (String)getFacesUtils().getRequestParameter("elType");
			String elTypeSub = getFacesUtils().getRequestParameter("elTypeSub") == null ? "" : (String)getFacesUtils().getRequestParameter("elTypeSub");
			String siteAppELContId = getFacesUtils().getRequestParameter("siteAppELContId") == null ? "" : (String)getFacesUtils().getRequestParameter("siteAppELContId");
		
//			elType = semmsa002Bean.getSiteAppELObjParam().getElectricType();
			
			String mode = "";
			
			siteAppId = semmsa002Bean.getSiteAppObjParam().getSiteAppId();
			depositType = semmsa002Bean.getSiteAppDeptObj().getDepositType();
			
			
			//this.doSetELCheckBoxEntity();	
			semmsa002Bean.getSiteAppELObjParam().setSiteAppId(siteAppId);
			semmsa002Bean.getSiteAppELObjParam().setSiteAppELContId(siteAppELContId);
			semmsa002Bean.getSiteAppELObjParam().setUserId(getUserLogIn());
			
//			
//			semmsa002Bean.getSiteAppELObjParam().setElUnitPrice(semmsa002Bean.getSiteAppELObjParam().getElUnitPrice());
//			semmsa002Bean.getSiteAppELObjParam().setEffectiveDt(semmsa002Bean.getSiteAppELObjParam().getPeriodStartDt());
//			semmsa002Bean.getSiteAppELObjParam().setExpireDt(semmsa002Bean.getSiteAppELObjParam().getPeriodEndDt());
//			semmsa002Bean.getSiteAppELObjParam().setElPayPeriod(semmsa002Bean.getSiteAppELObjParam().getElPayPeriod());
//			semmsa002Bean.getSiteAppELObjParam().setDetail(semmsa002Bean.getSiteAppELObjParam().getDetail03());
//			semmsa002Bean.getSiteAppELObjParam().setElVatType(semmsa002Bean.getSiteAppELObjParam().getElVatType());
			
			
			if(elType.equals("03")){
				if(semmsa002Bean.getElPayPeriodType01() != ""){
					siteAppObj.setPayPeriodType("01");
				}else if(semmsa002Bean.getElPayPeriodType02() != ""){
					siteAppObj.setPayPeriodType("02");
				}else if(semmsa002Bean.getElPayPeriodType03() != ""){
					siteAppObj.setPayPeriodType("03");
				}else if(semmsa002Bean.getElPayPeriodType04() != ""){
					siteAppObj.setPayPeriodType("04");
				}else if(semmsa002Bean.getElPayPeriodType05() != ""){
					siteAppObj.setPayPeriodType("05");
				}else if(semmsa002Bean.getElPayPeriodType06() != ""){
					siteAppObj.setPayPeriodType("06");
				}else if(semmsa002Bean.getElPayPeriodType07() != ""){
					siteAppObj.setPayPeriodType("07");
				}
				
			}else if(elType.equals("04")){
				semmsa002Bean.getSiteAppELObjParam().setDetail(semmsa002Bean.getSiteAppELObjParam().getDetail04());
				semmsa002Bean.getSiteAppELObjParam().setContractNo(semmsa002Bean.getSiteAppELObjParam().getElUseOthSiteContractNo());
			}else if(elType.equals("05")){
				semmsa002Bean.getSiteAppELObjParam().setDetail(semmsa002Bean.getSiteAppObjParam().getDetail05());
			}
			
			if(semmsa002Bean.chkElUseNewMeter){
				semmsa002Bean.getSiteAppELObjParam().setUseOldMeter(null);
				semmsa002Bean.getSiteAppELObjParam().setUseNewMeter("Y");
			}else if(semmsa002Bean.chkElUseOldMeter){
				semmsa002Bean.getSiteAppELObjParam().setUseOldMeter("Y");
				semmsa002Bean.getSiteAppELObjParam().setUseNewMeter(null);
			}else{
				semmsa002Bean.getSiteAppELObjParam().setUseOldMeter(null);
				semmsa002Bean.getSiteAppELObjParam().setUseNewMeter(null);
			}
			
			if(this.doValidateEl()){
				Object obj = doMapELParamObjForUpdate((Object)semmsa002Bean.getSiteAppELObjParam());
				//Object obj = doMapELParamObj((Object)semmsa002Bean.getSiteAppELObjParam());
				
				SiteAppSP siteAppSP = new SiteAppSP();
				siteAppObj = (SiteAppSP)obj;
//					//Debug 

				to = service.siteAppDao_querySPList(EQueryName.SP_MSA002_SITE_APP_EL_COND_UPD.name, siteAppObj);
				
				if (to != null && !to.isEmpty()) { 
					String retMsg = to.get(0).getRetResultMsg() == null ? "" : to.get(0).getRetResultMsg().toString();
					
					if (to.get(0).getRetResult().equals("Success")) {

						
						String myMsgArr[];
						if(!retMsg.equals("")){
							myMsgArr = retMsg.split("<BR/>");
							
							for(int i=0; i < myMsgArr.length; i++){
								//addGeneralMessageInfo(myMsgArr[i]);
								//addGeneralMessageWarn(myMsgArr[i]);
								FrontMessageUtils.addMessageWarn(myMsgArr[i]);	// optional
							}
						}
						// -- Start Save EL Type
						this.doUpdateAllonChangeTab();
						// -- End Save EL Type
						
						
//						this.doSiteAppELCondSrch();
						
//						if(StringUtils.equals("03", elType)){
//							if(StringUtils.equals("01", elTypeSub)){
//								mode = "U";
//							}else if(StringUtils.equals("02", elTypeSub)){
//								mode = "T";
//							}else{
//								mode = "N";
//							}
							//this.doSiteAppELCondSrch("U");
							//.doSiteAppELCondSrch("T");
							//this.doSiteAppELCondSrch("N");
							
							this.doSiteAppELCondSrch("C");
//						}else if(StringUtils.equals("04", elType)){
//							mode = "O";
//							this.doSiteAppELCondSrch(mode);
//						}
//						this.doSiteAppELCondSrch(mode);
					
						flag = true;
						semmsa002Bean.setRenderedMsgAlert(true);
						//TODO clear save param obj
						this.doClearSiteAppEl();
					} else {
						if(to.get(0).getRetResult() != null){
//							if("FAIL".equals(to.get(0).getRetResult().toUpperCase())){
							if(to.get(0).getRetResult().toUpperCase().contains("FAIL")){
						        LOG.debug("===> CALL "+EQueryName.SP_MSA002_SITE_APP_EL_COND_UPD.name+ "==>Result :"+ to.get(0).getRetResult());
								semmsa002Bean.setDisabledButtonPopupResult(false);
							}else if("FAIL2".equals(to.get(0).getRetResult().toUpperCase())){
								semmsa002Bean.setDisabledButtonPopupResult(true);
							}
							
						}
//						System.out.println("to.get(0).getRetResultMsg() = "+to.get(0).getRetResultMsg());
						if(to.get(0).getRetResultMsg() != null)
							addGeneralMessageError(to.get(0).getRetResultMsg());	// data save fail
						else
							addMessageError("E0001");	// data save fail
		        		semmsa002Bean.setRenderedMsgAlert(true);
					}
				}
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doUpdateSiteAppELCond : "+e);
		}
		LOG.debug(" #### End SEMMSA002Action doUpdateSiteAppELCond ####");
		return flag;
	}
	
	public boolean doInitDetSiteAppELCond(){
		LOG.debug(" #### Start SEMMSA002Action doInitDetSiteAppELCond #### ");
		semmsa002Bean = getSemmsa002Bean();
		boolean flag = true;
		
		try{
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("Error SEMMSA002Action doInitDetSiteAppELCond : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" #### End SEMMSA002Action doInitDetSiteAppELCond #### ");
		}
		return flag;
	}
	
	public boolean doDetSiteAppELCond(){
		LOG.debug(" #### Start SEMMSA002Action doDetSiteAppELCond #### ");
		boolean flag = false;
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteAppSP> to = null;
		SiteAppSP siteAppObj = new SiteAppSP();
		semmsa002Bean = getSemmsa002Bean();
		semmsa002Bean.setpRemark("");
		try{
			//TODO get param
			String siteAppELContId = getFacesUtils().getRequestParameter("siteAppELContId") == null ? "" : (String)getFacesUtils().getRequestParameter("siteAppELContId");
			String siteAppId = getFacesUtils().getRequestParameter("siteAppId") == null ? "" : (String)getFacesUtils().getRequestParameter("siteAppId");
			String expenseType = getFacesUtils().getRequestParameter("expenseType") == null ? "" : (String)getFacesUtils().getRequestParameter("expenseType");
			String serviceId = getFacesUtils().getRequestParameter("serviceId") == null ? "" : (String)getFacesUtils().getRequestParameter("serviceId");
			String elType = getFacesUtils().getRequestParameter("elType") == null ? "" : (String)getFacesUtils().getRequestParameter("elType");
			
			String userId = getUserLogIn();
			
			if(StringUtils.equals("01", elType) || StringUtils.equals("02", elType)){
				semmsa002Bean.setChkElUseOldMeter(false);
				semmsa002Bean.setChkElUseNewMeter(false);
			}
			
			siteAppObj.setSiteAppELContId(siteAppELContId);
			siteAppObj.setSiteAppId(siteAppId);
			siteAppObj.setExpenseType(expenseType);
			siteAppObj.setServiceId(serviceId);
			siteAppObj.setUserId(userId);
			
			to = service.siteAppDao_querySPList(EQueryName.SP_MSA002_SITE_APP_EL_COND_DEL.name, siteAppObj);
			
			if (to != null && !to.isEmpty()) {
				String retMsg = to.get(0).getRetResultMsg() == null ? "" : to.get(0).getRetResultMsg().toString();
				
				if (to.get(0).getRetResult().equals("Success")) {

					
					String myMsgArr[];
					if(!retMsg.equals("")){
						myMsgArr = retMsg.split("<BR/>");
						
						for(int i=0; i < myMsgArr.length; i++){
							//addGeneralMessageInfo(myMsgArr[i]);
							//addGeneralMessageWarn(myMsgArr[i]);
							FrontMessageUtils.addMessageWarn(myMsgArr[i]);	// optional
						}
					}
					
					// -- Start Save EL Type
					this.doUpdateAllonChangeTab();
					// -- End Save EL Type
					
					this.doSiteAppELCondSrch("H");
					this.doSiteAppELCondSrch("C");

					
					this.doClearSiteAppEl();
					
					flag = true;
					semmsa002Bean.setRenderedMsgAlert(true);
				} else {
					if(to.get(0).getRetResult() != null){
						if("FAIL".equals(to.get(0).getRetResult().toUpperCase())){
							semmsa002Bean.setDisabledButtonPopupResult(false);
						}else if("FAIL2".equals(to.get(0).getRetResult().toUpperCase())){
							semmsa002Bean.setDisabledButtonPopupResult(true);
						}
						
					}
//					System.out.println("to.get(0).getRetResultMsg() = "+to.get(0).getRetResultMsg());
					if(to.get(0).getRetResultMsg() != null)
						addGeneralMessageError(to.get(0).getRetResultMsg());	// data save fail
					else
						addMessageError("E0001");	// data save fail
	        		semmsa002Bean.setRenderedMsgAlert(true);
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doDetSiteAppELCond : "+e);
		}
		LOG.debug(" #### End SEMMSA002Action doDetSiteAppELCond #### ");
		return flag;
	}
	
	public boolean doClearSiteAppEl(){
		LOG.debug(" #### Start SEMMSA002Action doClearSiteAppEl ####");
		semmsa002Bean = getSemmsa002Bean();
		try{
			semmsa002Bean.setSiteAppELObjParam(new SiteAppSP());
			//set default El PeriodStartDt
//			if(semmsa002Bean.getSiteAppObjParam().getEffectiveDt() != null)
//				semmsa002Bean.getSiteAppELObjParam().setPeriodStartDt(semmsa002Bean.getSiteAppObjParam().getEffectiveDt());
			
			//set default El setPeriodEndDt
//			if(semmsa002Bean.getSiteAppObjParam().getExpireDt() != null)
//				semmsa002Bean.getSiteAppELObjParam().setPeriodEndDt(semmsa002Bean.getSiteAppObjParam().getExpireDt());
//			semmsa002Bean.setSiteAppDeptCashObj(new SiteAppSP());
//			semmsa002Bean.setSiteAppDeptBgObj(new SiteAppSP());
			setSemmsa002Bean(semmsa002Bean);
//			this.initUpdDeptReturnType();
//			this.doRenderDeptBgCash();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doClearSiteAppEl : "+e);
		}
		LOG.debug(" #### End SEMMSA002Action doClearSiteAppEl ####");
		return true;
	}
	
	//added by NEW 11/02/2016 
	public boolean renderElPayPeriodType(){
		boolean flag = false;
		semmsa002Bean = getSemmsa002Bean();
		try{
			String payPeriodType = (String)getFacesUtils().getRequestParameter("payPeriodType");
			if(payPeriodType.equals("01")){
				semmsa002Bean.setElPayPeriodType02("");
				semmsa002Bean.setElPayPeriodType03("");
				semmsa002Bean.setElPayPeriodType04("");
				semmsa002Bean.setElPayPeriodType05("");
				semmsa002Bean.setElPayPeriodType06("");
				semmsa002Bean.setElPayPeriodType07("");
				semmsa002Bean.setElPayPeriod03(null);
				semmsa002Bean.setElPayPeriod04(null);
				semmsa002Bean.setDisabledElPayPeriod03(true);
				semmsa002Bean.setDisabledElPayPeriod04(true);
			}
			if(payPeriodType.equals("02")){
				semmsa002Bean.setElPayPeriodType01("");
				semmsa002Bean.setElPayPeriodType03("");
				semmsa002Bean.setElPayPeriodType04("");
				semmsa002Bean.setElPayPeriodType05("");
				semmsa002Bean.setElPayPeriodType06("");
				semmsa002Bean.setElPayPeriodType07("");
				semmsa002Bean.setElPayPeriod03(null);
				semmsa002Bean.setPayPeriod04(null);
				semmsa002Bean.setDisabledElPayPeriod03(true);
				semmsa002Bean.setDisabledElPayPeriod04(true);
			}
			if(payPeriodType.equals("03")){
				if(semmsa002Bean.getElPayPeriod03() != null) semmsa002Bean.getSiteAppELObjParam().setElPayPeriod(semmsa002Bean.getElPayPeriod03());
				semmsa002Bean.setElPayPeriodType01("");
				semmsa002Bean.setElPayPeriodType02("");
				semmsa002Bean.setElPayPeriodType04("");
				semmsa002Bean.setElPayPeriodType05("");
				semmsa002Bean.setElPayPeriodType06("");
				semmsa002Bean.setElPayPeriodType07("");
//				semmsa002Bean.setElPayPeriod03(null);
				semmsa002Bean.setElPayPeriod04(null);
				semmsa002Bean.setDisabledElPayPeriod03(false);
				semmsa002Bean.setDisabledElPayPeriod04(true);
			}
			if(payPeriodType.equals("04")){
				if(semmsa002Bean.getElPayPeriod04() != null) semmsa002Bean.getSiteAppELObjParam().setElPayPeriod(semmsa002Bean.getElPayPeriod04());
				System.out.println("semmsa002Bean.getSiteAppELObjParam().setElPayPeriod : "+semmsa002Bean.getSiteAppELObjParam().getElPayPeriod());
				System.out.println("semmsa002Bean.getElPayPeriod04() : "+semmsa002Bean.getElPayPeriod04());
				semmsa002Bean.setElPayPeriodType01("");
				semmsa002Bean.setElPayPeriodType02("");
				semmsa002Bean.setElPayPeriodType03("");
				semmsa002Bean.setElPayPeriodType05("");
				semmsa002Bean.setElPayPeriodType06("");
				semmsa002Bean.setElPayPeriodType07("");
				semmsa002Bean.setElPayPeriod03(null);
//				semmsa002Bean.setElPayPeriod04(null);
				semmsa002Bean.setDisabledElPayPeriod03(true);
				semmsa002Bean.setDisabledElPayPeriod04(false);
			}
			if(payPeriodType.equals("05")){
				semmsa002Bean.setElPayPeriodType01("");
				semmsa002Bean.setElPayPeriodType02("");
				semmsa002Bean.setElPayPeriodType03("");
				semmsa002Bean.setElPayPeriodType04("");
//				semmsa002Bean.setPayPeriodType05("");
				semmsa002Bean.setElPayPeriodType06("");
				semmsa002Bean.setElPayPeriodType07("");
				semmsa002Bean.setElPayPeriod03(null);
				semmsa002Bean.setElPayPeriod04(null);
				semmsa002Bean.setDisabledElPayPeriod03(true);
				semmsa002Bean.setDisabledElPayPeriod04(true);
			}
			if(payPeriodType.equals("06")){
				semmsa002Bean.setElPayPeriodType01("");
				semmsa002Bean.setElPayPeriodType02("");
				semmsa002Bean.setElPayPeriodType03("");
				semmsa002Bean.setElPayPeriodType04("");
				semmsa002Bean.setElPayPeriodType05("");
//				semmsa002Bean.setPayPeriodType06("");
				semmsa002Bean.setElPayPeriodType07("");
				semmsa002Bean.setElPayPeriod03(null);
				semmsa002Bean.setElPayPeriod04(null);
				semmsa002Bean.setDisabledElPayPeriod03(true);
				semmsa002Bean.setDisabledElPayPeriod04(true);
			}
			if(payPeriodType.equals("07")){
				semmsa002Bean.setElPayPeriodType01("");
				semmsa002Bean.setElPayPeriodType02("");
				semmsa002Bean.setElPayPeriodType03("");
				semmsa002Bean.setElPayPeriodType04("");
				semmsa002Bean.setElPayPeriodType05("");
				semmsa002Bean.setElPayPeriodType06("");
//				semmsa002Bean.setPayPeriodType07("");
				semmsa002Bean.setElPayPeriod03(null);
				semmsa002Bean.setElPayPeriod04(null);
				semmsa002Bean.setDisabledElPayPeriod03(true);
				semmsa002Bean.setDisabledElPayPeriod04(true);
			}
			semmsa002Bean.getSiteAppELObjParam().setPayPeriodType(payPeriodType);
			setSemmsa002Bean(semmsa002Bean);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return flag;
	}
	
	private boolean initElUpdateCond() {
		boolean flag = false;
		semmsa002Bean = getSemmsa002Bean();
//		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		
		try{
//			ISiteRentCondService service = (ISiteRentCondService)getBean("siteRentCondService");
//			RentCond rentCond = service.queryRentCondByRowId(rowId);
			if(semmsa002Bean.getSiteAppELObjParam().getPayPeriodType() != null){
//				if(StringUtils.isEmpty(semmsa002Bean.getSiteAppELObjParam().getTakeAllPeriodType())){
//					semmsa002Bean.getSiteAppELObjParam().setTakeAllPeriodType("");
//				}
				
				if(semmsa002Bean.getSiteAppELObjParam().getPayPeriodType() != null && semmsa002Bean.getSiteAppELObjParam().getPayPeriodType().equals("01")){
					semmsa002Bean.setElPayPeriodType01(semmsa002Bean.getSiteAppELObjParam().getPayPeriodType());
					semmsa002Bean.setElPayPeriodType02(null);
					semmsa002Bean.setElPayPeriodType03(null);
					semmsa002Bean.setElPayPeriodType04(null);
					semmsa002Bean.setElPayPeriodType05(null);
					semmsa002Bean.setElPayPeriodType06(null);
					semmsa002Bean.setElPayPeriodType07(null);
					semmsa002Bean.setElPayPeriod03(null);
					semmsa002Bean.setElPayPeriod04(null);
					semmsa002Bean.setDisabledElPayPeriod03(true);
					semmsa002Bean.setDisabledElPayPeriod04(true);
					
				}
				if(semmsa002Bean.getSiteAppELObjParam().getPayPeriodType() != null && semmsa002Bean.getSiteAppELObjParam().getPayPeriodType().equals("02")){
					semmsa002Bean.setElPayPeriodType02(semmsa002Bean.getSiteAppELObjParam().getPayPeriodType());
					semmsa002Bean.setElPayPeriodType01(null);
					semmsa002Bean.setElPayPeriodType03(null);
					semmsa002Bean.setElPayPeriodType04(null);
					semmsa002Bean.setElPayPeriodType05(null);
					semmsa002Bean.setElPayPeriodType06(null);
					semmsa002Bean.setElPayPeriodType07(null);
					semmsa002Bean.setElPayPeriod03(null);
					semmsa002Bean.setElPayPeriod04(null);
					semmsa002Bean.setDisabledElPayPeriod03(true);
					semmsa002Bean.setDisabledElPayPeriod04(true);
				}
				if(semmsa002Bean.getSiteAppELObjParam().getPayPeriodType() != null && semmsa002Bean.getSiteAppELObjParam().getPayPeriodType().equals("03")){
					LOG.debug("getElPayPeriod =: "+semmsa002Bean.getSiteAppELObjParam().getElPayPeriod());
					
					if(semmsa002Bean.getSiteAppELObjParam().getElPayPeriod() != null){
//						int payperiod = Integer.parseInt(semmsa002Bean.getSiteAppRentObjParam().getPayPeriod());
						semmsa002Bean.setElPayPeriod03(semmsa002Bean.getSiteAppELObjParam().getElPayPeriod());
					}
					
//					semmsa002Bean.setPayPeriod03(BigDecimal.valueOf(arg0) semmsa002Bean.getSiteAppRentObjParam().getPayPeriod());
					semmsa002Bean.setElPayPeriodType03(semmsa002Bean.getSiteAppELObjParam().getPayPeriodType());
					semmsa002Bean.setElPayPeriodType01(null);
					semmsa002Bean.setElPayPeriodType02(null);
					semmsa002Bean.setElPayPeriodType04(null);
					semmsa002Bean.setElPayPeriodType05(null);
					semmsa002Bean.setElPayPeriodType06(null);
					semmsa002Bean.setElPayPeriodType07(null);
					semmsa002Bean.setElPayPeriod04(null);
					semmsa002Bean.setDisabledElPayPeriod03(false);
					semmsa002Bean.setDisabledElPayPeriod04(true);
				}
				if(semmsa002Bean.getSiteAppELObjParam().getPayPeriodType() != null && semmsa002Bean.getSiteAppELObjParam().getPayPeriodType().equals("04")){
					
					LOG.debug("getElPayPeriod =: "+semmsa002Bean.getSiteAppELObjParam().getElPayPeriod());
					
					if(semmsa002Bean.getSiteAppELObjParam().getElPayPeriod() != null){
//						int payperiod = Integer.parseInt(semmsa002Bean.getSiteAppRentObjParam().getElPayPeriod());
						semmsa002Bean.setElPayPeriod04(semmsa002Bean.getSiteAppELObjParam().getElPayPeriod());
					}
					
//					semmsa002Bean.setElPayPeriod04(semmsa002Bean.getSiteAppELObjParam().getPayPeriod());
					semmsa002Bean.setElPayPeriodType04(semmsa002Bean.getSiteAppELObjParam().getPayPeriodType());
					semmsa002Bean.setElPayPeriodType01(null);
					semmsa002Bean.setElPayPeriodType02(null);
					semmsa002Bean.setElPayPeriodType03(null);
					semmsa002Bean.setElPayPeriodType05(null);
					semmsa002Bean.setElPayPeriodType06(null);
					semmsa002Bean.setElPayPeriodType07(null);
					semmsa002Bean.setElPayPeriod03(null);
					semmsa002Bean.setDisabledElPayPeriod03(true);
					semmsa002Bean.setDisabledElPayPeriod04(false);
				}
				if(semmsa002Bean.getSiteAppELObjParam().getPayPeriodType() != null && semmsa002Bean.getSiteAppELObjParam().getPayPeriodType().equals("05")){
					semmsa002Bean.setElPayPeriodType05(semmsa002Bean.getSiteAppELObjParam().getPayPeriodType());
					semmsa002Bean.setElPayPeriodType01(null);
					semmsa002Bean.setElPayPeriodType02(null);
					semmsa002Bean.setElPayPeriodType03(null);
					semmsa002Bean.setElPayPeriodType04(null);
					semmsa002Bean.setElPayPeriodType06(null);
					semmsa002Bean.setElPayPeriodType07(null);
					semmsa002Bean.setElPayPeriod03(null);
					semmsa002Bean.setElPayPeriod04(null);
					semmsa002Bean.setDisabledElPayPeriod03(true);
					semmsa002Bean.setDisabledElPayPeriod04(true);
				}
				if(semmsa002Bean.getSiteAppELObjParam().getPayPeriodType() != null && semmsa002Bean.getSiteAppELObjParam().getPayPeriodType().equals("06")){
					semmsa002Bean.setElPayPeriodType06(semmsa002Bean.getSiteAppELObjParam().getPayPeriodType());
					semmsa002Bean.setElPayPeriodType01(null);
					semmsa002Bean.setElPayPeriodType02(null);
					semmsa002Bean.setElPayPeriodType03(null);
					semmsa002Bean.setElPayPeriodType04(null);
					semmsa002Bean.setElPayPeriodType05(null);
					semmsa002Bean.setElPayPeriodType07(null);
					semmsa002Bean.setElPayPeriod03(null);
					semmsa002Bean.setElPayPeriod04(null);
					semmsa002Bean.setDisabledElPayPeriod03(true);
					semmsa002Bean.setDisabledElPayPeriod04(true);
					
				}
				if(semmsa002Bean.getSiteAppELObjParam().getPayPeriodType() != null && semmsa002Bean.getSiteAppELObjParam().getPayPeriodType().equals("07")){
					semmsa002Bean.setElPayPeriodType07(semmsa002Bean.getSiteAppELObjParam().getPayPeriodType());
					semmsa002Bean.setElPayPeriodType01(null);
					semmsa002Bean.setElPayPeriodType02(null);
					semmsa002Bean.setElPayPeriodType03(null);
					semmsa002Bean.setElPayPeriodType04(null);
					semmsa002Bean.setElPayPeriodType05(null);
					semmsa002Bean.setElPayPeriodType06(null);
					semmsa002Bean.setElPayPeriod03(null);
					semmsa002Bean.setElPayPeriod04(null);
					semmsa002Bean.setDisabledElPayPeriod03(true);
					semmsa002Bean.setDisabledElPayPeriod04(true);
					
				}
				
				setSemmsa002Bean(semmsa002Bean);
			}else{
				semmsa002Bean.setElPayPeriodType01(null);
				semmsa002Bean.setElPayPeriodType02(null);
				semmsa002Bean.setElPayPeriodType03(null);
				semmsa002Bean.setElPayPeriodType04(null);
				semmsa002Bean.setElPayPeriodType05(null);
				semmsa002Bean.setElPayPeriodType06(null);
				semmsa002Bean.setElPayPeriodType07(null);
				semmsa002Bean.setElPayPeriod03(null);
				semmsa002Bean.setElPayPeriod04(null);
				semmsa002Bean.setDisabledElPayPeriod03(true);
				semmsa002Bean.setDisabledElPayPeriod04(true);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public void doChkNoUnitPrice(){
		LOG.debug(" #### Start SEMMSA002Action doChkNoUnitPrice #### ");
		semmsa002Bean = getSemmsa002Bean();
		try{
			if(semmsa002Bean.isChkNoUtilPrice()){
				semmsa002Bean.getSiteAppELObjParam().setElUnitPrice(null);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error(" #### Error SEMMSA002Action doChkNoUnitPrice : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" #### End SEMMSA002Action doChkNoUnitPrice #### ");
		}
	}
	
	public void doGetNoUnitPrice(){
		LOG.debug(" #### Start SEMMSA002Action doGetNoUnitPrice #### ");
		semmsa002Bean = getSemmsa002Bean();
		try{
			
			if(semmsa002Bean.getSiteAppELObjParam().getNoUnitPriceFlag() != null 
					&& StringUtils.equals("Y", semmsa002Bean.getSiteAppELObjParam().getNoUnitPriceFlag())){
				semmsa002Bean.setChkNoUtilPrice(true);
			}else{
				semmsa002Bean.setChkNoUtilPrice(false);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error(" #### Error SEMMSA002Action doGetNoUnitPrice : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" #### End SEMMSA002Action doGetNoUnitPrice #### ");
		}
	}
	
	public boolean doEditEL(){
		LOG.debug(" ### START SEMMSA002Action doEditEL ### ");
		boolean flag = true;
		semmsa002Bean = getSemmsa002Bean();
		String siteAppELContId = getFacesUtils().getRequestParameter("siteAppELContId") == null ? "" : (String)getFacesUtils().getRequestParameter("siteAppELContId");
		String electricCondSubtype = getFacesUtils().getRequestParameter("electricCondSubtype") == null ? "" : (String)getFacesUtils().getRequestParameter("electricCondSubtype");
		String elType = getFacesUtils().getRequestParameter("elType") == null ? "" : (String)getFacesUtils().getRequestParameter("elType");
		String pSa = getFacesUtils().getRequestParameter("pSa") == null ? "" : (String)getFacesUtils().getRequestParameter("pSa");

		System.out.println("pSa "+pSa);
		//String elType = semmsa002Bean.getSiteAppELObjParam().getpSaElectricType();
		
		List<WrapperBeanObject<SiteAppSP>>  elObjList = new ArrayList<WrapperBeanObject<SiteAppSP>>();
		
		if((StringUtils.equals("03", elType)) || (StringUtils.equals("03", pSa))){
			if(StringUtils.equals("01", electricCondSubtype)){
				elType = "U";
			}else{
				elType = "T";
			}
		}else if((StringUtils.equals("04", elType))|| (StringUtils.equals("04", pSa))){
			elType = "O";
		}else if((StringUtils.equals("05", elType))|| (StringUtils.equals("05", pSa))){
			elType = "OTH";
		}else if(StringUtils.equals("01", pSa)){
			elType = "N";
		}else if(StringUtils.equals("02", pSa)){
			elType = "OLD";
		}
		
		try{
			
			elObjList = semmsa002Bean.getSiteAppELCondAllList();
			
			if(elObjList != null){
				for(WrapperBeanObject<SiteAppSP> rentContWrapObj : elObjList){
					SiteAppSP siteApp = new SiteAppSP(); 
					siteApp = (SiteAppSP) rentContWrapObj.getDataObj();
					
					if(StringUtils.equals(siteAppELContId, siteApp.getSiteAppELContId())){
						semmsa002Bean.setSiteAppELObjParam(new SiteAppSP());
						if(StringUtils.equals("U", elType)){
							semmsa002Bean.setChkElUseOwner(true); 
//							semmsa002Bean.getSiteAppELObjParam().setElCondSubType(electricCondSubtype);
							if(siteApp.getElEffectiveDt() != null)siteApp.setElEffectiveDt03(siteApp.getElEffectiveDt());
							if(siteApp.getElectricAmt() != null)siteApp.setElUnitPrice(siteApp.getElectricAmt());
							
							if(siteApp.getNoUnitPriceFlag() != null 
									&& StringUtils.equals("Y", siteApp.getNoUnitPriceFlag())){
								semmsa002Bean.setChkNoUtilPrice(true);
							}else{
								semmsa002Bean.setChkNoUtilPrice(false);
							}
							
							System.out.println("getServiceId "+siteApp.getServiceId());

//							ow
//							--
							System.out.println("getElCondType "+siteApp.getElCondType());
							System.out.println("getElCondSubType "+siteApp.getElCondSubType());

//							unit
//							--
							System.out.println("getElectricAmt : "+siteApp.getElectricAmt());
							System.out.println("getElUnitPric "+siteApp.getElUnitPrice());
							System.out.println("getChkNoUtilPrice "+siteApp.getNoUnitPriceFlag());
							System.out.println("getElVatType "+siteApp.getElVatType());
							System.out.println("getPayPeriodType "+siteApp.getPayPeriodType());
							System.out.println("getElPayPeriod "+siteApp.getElPayPeriod());
							System.out.println("getPeriodStartDT "+siteApp.getPeriodStartDt());
							System.out.println("getPeriodStartDT "+siteApp.getPeriodEndDt());
							
//							// set value for edit
//							semmsa002Bean.getSiteAppELObjParam().setElCondType("01");
//							semmsa002Bean.getSiteAppELObjParam().setElCondSubType("01");			
//							semmsa002Bean.getSiteAppELObjParam().setElectricAmt(siteApp.getElectricAmt());	
//							//semmsa002Bean.getSiteAppELObjParam().setElectricAmt(siteApp.getElectricAmt());
//							semmsa002Bean.getSiteAppELObjParam().setElUnitPrice(siteApp.getElectricAmt());
//							semmsa002Bean.getSiteAppELObjParam().setElVatType(siteApp.getElVatType());
//							semmsa002Bean.setElPayPeriodType01(siteApp.getElVatType());
//							semmsa002Bean.getSiteAppELObjParam().setPeriodStartDt(siteApp.getEffectiveDt());
//							semmsa002Bean.getSiteAppELObjParam().setPeriodEndDt(siteApp.getExpireDt());
							
						}else if(StringUtils.equals("T", elType)){ //เหมารวม
							 
							
							if(siteApp.getDetail() != null)siteApp.setDetail03(siteApp.getDetail());
							if(siteApp.getElEffectiveDt() != null)siteApp.setElEffectiveDt03(siteApp.getElEffectiveDt());
							if(siteApp.getElectricAmt() != null)siteApp.setTakeAllAmt(siteApp.getElectricAmt());
							
							System.out.println("getElEditFlag "+semmsa002Bean.getSiteAppObjParam().getElEditFlag());
							System.out.println("chkElUseOwner  "+semmsa002Bean.chkElUseOwner );
							System.out.println("electricCondSubtype  "+electricCondSubtype );
//							
//							semmsa002Bean.setChkElUseOwner(true);
//							semmsa002Bean.getSiteAppELObjParam().setElCondType("01");
//							semmsa002Bean.getSiteAppELObjParam().setElCondSubType("02");
//							semmsa002Bean.getSiteAppELObjParam().setElectricCondSubtype("02");
//							semmsa002Bean.getSiteAppELObjParam().setTakeAllAmt(siteApp.getElectricAmt());
//							semmsa002Bean.getSiteAppELObjParam().setTakeAllPeriodType(siteApp.getElectricPeriodType());
//							semmsa002Bean.getSiteAppELObjParam().setDetail03(siteApp.getDetail());
//							semmsa002Bean.setElPayPeriodType01(siteApp.getElVatType());
//							semmsa002Bean.getSiteAppELObjParam().setElVatType(siteApp.getPayPeriodType());
//							semmsa002Bean.getSiteAppELObjParam().setPeriodStartDt(siteApp.getEffectiveDt());
//							semmsa002Bean.getSiteAppELObjParam().setPeriodEndDt(siteApp.getExpireDt());
							
							
						}else if(StringUtils.equals("O", elType)){
							semmsa002Bean.setChkElUseOthSite(true); 
							if(siteApp.getDetail() != null)siteApp.setDetail04(siteApp.getDetail());
							if(siteApp.getElEffectiveDt() != null)siteApp.setElEffectiveDt04(siteApp.getElEffectiveDt());
							
							System.out.println("getElEditFlag "+semmsa002Bean.getSiteAppObjParam().getElEditFlag());
							System.out.println("chkElUseOwner "+semmsa002Bean.chkElUseOthSite);
							
//							siteApp.setElUseOthSiteContractNo(siteApp.getContractNo());
//							semmsa002Bean.getSiteAppELObjParam().setElUseOthSiteContractNo(siteApp.getContractNo());
//							semmsa002Bean.getSiteAppELObjParam().setDetail04(siteApp.getDetail());
							
						}else if(StringUtils.equals("N", elType)){
//							if(siteApp.getDetail() != null)siteApp.setDetail03(siteApp.getDetail());
//							if(siteApp.getElEffectiveDt() != null)siteApp.setElEffectiveDt03(siteApp.getElEffectiveDt());
						}
						else if(StringUtils.equals("OTH", elType)){
							semmsa002Bean.setChkElUseOth(true);
							if(siteApp.getDetail() != null)
								siteApp.setDetail05(siteApp.getDetail());
//							semmsa002Bean.getSiteAppELObjParam().setServiceId(siteApp.getServiceId());
							
							System.out.println("chkElUseOth " +semmsa002Bean.chkElUseOth);
							System.out.println("elEditFlag "+siteApp.getElEditFlag());
							
							
						}
						
						
//						siteApp.setRentContMode("H");
						semmsa002Bean.setSiteAppELObjParam(siteApp);
						setSemmsa002Bean(semmsa002Bean);
						if(StringUtils.equals("U", elType) || StringUtils.equals("T", elType)){
							this.initElUpdateCond();
						}
					}
				}
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("ERROR SEMMSA002Action doEditEL : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" ### START SEMMSA002Action doEditEL ### ");
		}
		return flag;
	}
	
	public boolean doClearSiteAppDepositEl(){
		LOG.debug(" #### Start SEMMSA002Action doClearSiteAppDepositEl ####");
		semmsa002Bean = getSemmsa002Bean();
		try{
			semmsa002Bean.setSiteAppDeptElObj(new SiteAppSP());
			semmsa002Bean.setSiteAppDeptCashElObj(new SiteAppSP());
			semmsa002Bean.setSiteAppDeptBgElObj(new SiteAppSP());
			setSemmsa002Bean(semmsa002Bean);
			this.initUpdDeptElReturnType();
			this.doRenderDeptBgCashEl();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doClearSiteAppDepositEl : "+e);
		}
		LOG.debug(" #### End SEMMSA002Action doClearSiteAppDepositEl ####");
		return true;
	}
	
	public void doRenderDeptBgCashEl(){
		LOG.debug(" #### Start SEMMSA002Action doRenderDeptBgCash ####");
		semmsa002Bean = getSemmsa002Bean();
		semmsa002Bean.setRenderedPnlDeptCashEl(false);
		semmsa002Bean.setRenderedPnlDeptBgEl(false);
		try{
			if(semmsa002Bean.getSiteAppDeptElObj().getDepositType() != null){
				if(StringUtils.equals("01", semmsa002Bean.getSiteAppDeptElObj().getDepositType())){
					semmsa002Bean.setRenderedPnlDeptCashEl(false);
					semmsa002Bean.setRenderedPnlDeptBgEl(true);
				}else if(StringUtils.equals("02", semmsa002Bean.getSiteAppDeptElObj().getDepositType())){
					semmsa002Bean.setRenderedPnlDeptCashEl(true);
					semmsa002Bean.setRenderedPnlDeptBgEl(false);
				}
				//Default expenseType		
				semmsa002Bean.getSiteAppDeptElObj().setExpenseType("08");
				
				semmsa002Bean.getSiteAppDeptElObj().setServiceId("");
				semmsa002Bean.getSiteAppDeptElObj().setRemark("");
				semmsa002Bean.setSiteAppDeptCashElObj(new SiteAppSP());
				semmsa002Bean.setSiteAppDeptBgElObj(new SiteAppSP());
				setSemmsa002Bean(semmsa002Bean);
				this.initUpdDeptElReturnType();
				this.doCalDepositElReturnAmt();
				this.doCalDepositElAmt();
				this.doInitDepositEl();
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("Error SEMMSA002Action doRenderDeptBgCash : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" #### END SEMMSA002Action doRenderDeptBgCash ####");
		}
	}
	
	public void doRenderEditDeptBgCashEl(){
		LOG.debug(" #### Start SEMMSA002Action doRenderEditDeptBgCashEl ####");
		semmsa002Bean = getSemmsa002Bean();
		semmsa002Bean.setRenderedPnlDeptCashEl(false);
		semmsa002Bean.setRenderedPnlDeptBgEl(false);
		try{
			if(semmsa002Bean.getSiteAppDeptElObj().getDepositType() != null){
				if(StringUtils.equals("02", semmsa002Bean.getSiteAppDeptElObj().getDepositType())){
					semmsa002Bean.setRenderedPnlDeptCashEl(true);
					semmsa002Bean.setRenderedPnlDeptBgEl(false);
				}else if(StringUtils.equals("01", semmsa002Bean.getSiteAppDeptElObj().getDepositType())){
					semmsa002Bean.setRenderedPnlDeptCashEl(false);
					semmsa002Bean.setRenderedPnlDeptBgEl(true);
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("Error SEMMSA002Action doRenderEditDeptBgCashEl : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" #### END SEMMSA002Action doRenderEditDeptBgCashEl ####");
		}
	}
	
	public void initUpdDeptElReturnType(){
		LOG.debug(" #### START SEMMSA002Action initUpdDeptElReturnType ####");
		semmsa002Bean = getSemmsa002Bean();
		try{
			if(semmsa002Bean.getSiteAppDeptElObj().getDepositType() != null && StringUtils.equals("02", semmsa002Bean.getSiteAppDeptElObj().getDepositType())){
				if(semmsa002Bean.getSiteAppDeptCashElObj().getDepositReturnType() != null){
					if(StringUtils.isEmpty(semmsa002Bean.getSiteAppDeptCashElObj().getDepositReturnType())){
						semmsa002Bean.getSiteAppDeptCashElObj().setDepositReturnType("");
					}
					
					if(semmsa002Bean.getSiteAppDeptCashElObj().getDepositReturnType() != null && semmsa002Bean.getSiteAppDeptCashElObj().getDepositReturnType().equals("01")){
						semmsa002Bean.setDeptReturnTypeEl01(semmsa002Bean.getSiteAppDeptCashElObj().getDepositReturnType());
						semmsa002Bean.setDeptReturnTypeEl02(null);
						semmsa002Bean.setDeptReturnTypeEl03(null);

						semmsa002Bean.getSiteAppDeptCashElObj().setReturnAmt(BigDecimal.ZERO);
						
					}
					
					if(semmsa002Bean.getSiteAppDeptCashElObj().getDepositReturnType() != null && semmsa002Bean.getSiteAppDeptCashElObj().getDepositReturnType().equals("02")){
						semmsa002Bean.setDeptReturnTypeEl02(semmsa002Bean.getSiteAppDeptCashElObj().getDepositReturnType());
						semmsa002Bean.setDeptReturnTypeEl01(null);
						semmsa002Bean.setDeptReturnTypeEl03(null);

//						semmsa002Bean.getSiteAppDeptObj().setReturnAmt(BigDecimal.ZERO);
						
					}
					
					if(semmsa002Bean.getSiteAppDeptCashElObj().getDepositReturnType() != null && semmsa002Bean.getSiteAppDeptCashElObj().getDepositReturnType().equals("03")){
						semmsa002Bean.setDeptReturnTypeEl03(semmsa002Bean.getSiteAppDeptCashElObj().getDepositReturnType());
						semmsa002Bean.setDeptReturnTypeEl01(null);
						semmsa002Bean.setDeptReturnTypeEl02(null);

						semmsa002Bean.getSiteAppDeptCashElObj().setReturnAmt(BigDecimal.ZERO);
						
					}
					
				}else{
					semmsa002Bean.setDeptReturnTypeEl01(null);
					semmsa002Bean.setDeptReturnTypeEl02(null);
					semmsa002Bean.setDeptReturnTypeEl03(null);

					semmsa002Bean.getSiteAppDeptCashElObj().setReturnAmt(BigDecimal.ZERO);
				}
			}else if(semmsa002Bean.getSiteAppDeptElObj().getDepositType() != null && StringUtils.equals("01", semmsa002Bean.getSiteAppDeptElObj().getDepositType())){
				if(semmsa002Bean.getSiteAppDeptBgElObj().getDepositReturnType() != null){
					if(StringUtils.isEmpty(semmsa002Bean.getSiteAppDeptBgElObj().getDepositReturnType())){
						semmsa002Bean.getSiteAppDeptBgElObj().setDepositReturnType("");
					}
					
					if(semmsa002Bean.getSiteAppDeptBgElObj().getRentPaymentPeriod() != null && semmsa002Bean.getSiteAppDeptBgElObj().getDepositReturnType().equals("01")){
						semmsa002Bean.setDeptReturnTypeEl01(semmsa002Bean.getSiteAppDeptBgElObj().getDepositReturnType());
						semmsa002Bean.setDeptReturnTypeEl02(null);
						semmsa002Bean.setDeptReturnTypeEl03(null);

						semmsa002Bean.getSiteAppDeptBgElObj().setReturnAmt(BigDecimal.ZERO);
						
					}
					
					if(semmsa002Bean.getSiteAppDeptBgElObj().getRentPaymentPeriod() != null && semmsa002Bean.getSiteAppDeptBgElObj().getDepositReturnType().equals("02")){
						semmsa002Bean.setDeptReturnTypeEl02(semmsa002Bean.getSiteAppDeptBgElObj().getDepositReturnType());
						semmsa002Bean.setDeptReturnTypeEl01(null);
						semmsa002Bean.setDeptReturnTypeEl03(null);

//						semmsa002Bean.getSiteAppDeptObj().setReturnAmt(BigDecimal.ZERO);
						
					}
					
					if(semmsa002Bean.getSiteAppDeptBgElObj().getRentPaymentPeriod() != null && semmsa002Bean.getSiteAppDeptBgElObj().getDepositReturnType().equals("03")){
						semmsa002Bean.setDeptReturnTypeEl03(semmsa002Bean.getSiteAppDeptBgElObj().getDepositReturnType());
						semmsa002Bean.setDeptReturnTypeEl01(null);
						semmsa002Bean.setDeptReturnTypeEl02(null);

						semmsa002Bean.getSiteAppDeptBgElObj().setReturnAmt(BigDecimal.ZERO);
						
					}
					
				}else{
					semmsa002Bean.setDeptReturnTypeEl01(null);
					semmsa002Bean.setDeptReturnTypeEl02(null);
					semmsa002Bean.setDeptReturnTypeEl03(null);

					semmsa002Bean.getSiteAppDeptBgElObj().setReturnAmt(BigDecimal.ZERO);
				}
			}else{
				semmsa002Bean.setDeptReturnTypeEl01(null);
				semmsa002Bean.setDeptReturnTypeEl02(null);
				semmsa002Bean.setDeptReturnTypeEl03(null);
				semmsa002Bean.getSiteAppDeptCashElObj().setReturnAmt(BigDecimal.ZERO);
				semmsa002Bean.getSiteAppDeptBgElObj().setReturnAmt(BigDecimal.ZERO);
			}
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("Error SEMMSA002Action initUpdDeptElReturnType : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" #### END SEMMSA002Action initUpdDeptElReturnType ####");
		}
	}
	
	public void doCalDepositElReturnAmt(){
		LOG.debug(" #### Start SEMMSA002Action doCalDepositElReturnAmt ####");
		semmsa002Bean = getSemmsa002Bean();
		BigDecimal deptReturnAmt = BigDecimal.ZERO;
		try{
			if(semmsa002Bean.getSiteAppDeptCashElObj() != null){
				if(semmsa002Bean.getSiteAppDeptCashElObj().getDepositAmtOld() != null){
					deptReturnAmt = semmsa002Bean.getSiteAppDeptCashElObj().getDepositAmtOld();
				}
				
				if(semmsa002Bean.getDeptReturnTypeEl02() != null && StringUtils.equals("02", semmsa002Bean.getDeptReturnTypeEl02())){
					if(semmsa002Bean.getSiteAppDeptCashElObj().getReturnAmt() != null){
						deptReturnAmt = deptReturnAmt.add(semmsa002Bean.getSiteAppDeptCashElObj().getReturnAmt().negate());
					}
					
				}
			}
			
			semmsa002Bean.getSiteAppDeptCashElObj().setDepositReturnAmt(deptReturnAmt);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("Error SEMMSA002Action doCalDepositElReturnAmt : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" #### End SEMMSA002Action doCalDepositElReturnAmt ####");
		}
	}
	
	public void doCalDepositElAmt(){
		LOG.debug(" #### Start SEMMSA002Action doCalDepositElAmt ####");
		semmsa002Bean = getSemmsa002Bean();
		BigDecimal deptReturnAmt = BigDecimal.ZERO;
		try{
			if(StringUtils.equals("02", semmsa002Bean.getSiteAppDeptElObj().getDepositType())){
				if((semmsa002Bean.getSiteAppDeptCashElObj().getDepositAmtOld() != null) 
						&& semmsa002Bean.getSiteAppDeptCashElObj().getDepositAmtOld().compareTo(new BigDecimal(0)) == 1) {
				//if((semmsa002Bean.getSiteAppDeptCashElObj().getDepositAmtOld() != null)){
					deptReturnAmt = semmsa002Bean.getSiteAppDeptCashElObj().getDepositAmtOld();
				}
				else if(semmsa002Bean.getSiteAppDeptCashElObj().getDepositAmt() != null){
					deptReturnAmt = semmsa002Bean.getSiteAppDeptCashElObj().getDepositAmtNew();
					//deptReturnAmt = semmsa002Bean.getSiteAppDeptCashElObj().getDepositAmt();
				}
				
				if(semmsa002Bean.isWithdrawFlagEl()){
					if(semmsa002Bean.getSiteAppDeptCashElObj().getDepositAmtNew() != null){
						deptReturnAmt = deptReturnAmt.add(semmsa002Bean.getSiteAppDeptCashElObj().getDepositAmtNew());
					}
					
				}
				
				semmsa002Bean.getSiteAppDeptCashElObj().setDepositAmt(deptReturnAmt);
			}
			
			if(StringUtils.equals("01", semmsa002Bean.getSiteAppDeptElObj().getDepositType())){
				if(semmsa002Bean.getSiteAppDeptBgElObj().getDepositAmtOld() != null){
					deptReturnAmt = semmsa002Bean.getSiteAppDeptBgElObj().getDepositAmtOld();
				}
			
				
				if(semmsa002Bean.isWithdrawFlagEl()){
					if(semmsa002Bean.getSiteAppDeptBgElObj().getDepositAmtNew() != null){
						deptReturnAmt = deptReturnAmt.add(semmsa002Bean.getSiteAppDeptBgElObj().getDepositAmtNew());
					}
					
				}
				
				
				semmsa002Bean.getSiteAppDeptBgElObj().setDepositAmt(deptReturnAmt);
			}
			
			setSemmsa002Bean(semmsa002Bean);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("Error SEMMSA002Action doCalDepositElAmt : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" #### End SEMMSA002Action doCalDepositElAmt ####");
		}
	}
	
	public void doInitDepositEl(){
		LOG.debug(" ### START SEMMSA002Action doInitDepositEl ### ");
		semmsa002Bean = getSemmsa002Bean();
		String depositType = semmsa002Bean.getSiteAppDeptElObj().getDepositType();
		try{
			if(StringUtils.equals("02", depositType)){
				if(semmsa002Bean.getSiteAppDeptCashElObj().getWithdrawFlag() != null && StringUtils.equals("Y", semmsa002Bean.getSiteAppDeptCashElObj().getWithdrawFlag())){
					semmsa002Bean.setWithdrawFlagEl(true);
				}else{
					semmsa002Bean.setWithdrawFlagEl(false);
				}
				LOG.debug("doInitDepositEl Cash getWithdrawFlag : "+semmsa002Bean.getSiteAppDeptCashElObj().getWithdrawFlag());
			
			}
			
			if(StringUtils.equals("01", depositType)){
				if(semmsa002Bean.getSiteAppDeptBgElObj().getWithdrawFlag() != null && StringUtils.equals("Y", semmsa002Bean.getSiteAppDeptBgElObj().getWithdrawFlag())){
					semmsa002Bean.setWithdrawFlagEl(true);
				}else{
					semmsa002Bean.setWithdrawFlagEl(false);
				}
				LOG.debug("doInitDepositEl BG getWithdrawFlag : "+semmsa002Bean.getSiteAppDeptBgElObj().getWithdrawFlag());
			
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error(" Error SEMMSA002Action doInitDepositEl ");
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" ### END SEMMSA002Action doInitDepositEl ### ");
		}
	}
	
	public boolean renderDeptReturnTypeEl(){
		LOG.debug(" #### START SEMMSA002Action renderDeptReturnTypeEl ####");
		semmsa002Bean = getSemmsa002Bean();
		
		try{
			String deptReturnType = getFacesUtils().getRequestParameter("deptReturnType") == null ? "" : (String)getFacesUtils().getRequestParameter("deptReturnType");
			if(deptReturnType != null){
				if(StringUtils.equals("01", deptReturnType)){
					if(semmsa002Bean.getSiteAppDeptElObj().getDepositType() != null && StringUtils.equals("02", semmsa002Bean.getSiteAppDeptElObj().getDepositType())){
						semmsa002Bean.getSiteAppDeptCashElObj().setReturnAmt(null);
					}else if(semmsa002Bean.getSiteAppDeptElObj().getDepositType() != null && StringUtils.equals("01", semmsa002Bean.getSiteAppDeptElObj().getDepositType())){
						semmsa002Bean.getSiteAppDeptBgElObj().setReturnAmt(null);
					}
					
					
//					semmsa002Bean.setDeptReturnType01(true);
					semmsa002Bean.setDeptReturnTypeEl02("");
					semmsa002Bean.setDeptReturnTypeEl03("");
				}
				
				if(StringUtils.equals("02", deptReturnType)){
					
					
					semmsa002Bean.setDeptReturnTypeEl01("");
//					semmsa002Bean.setDeptReturnType02(true);
					semmsa002Bean.setDeptReturnTypeEl03("");
				}
				
				if(StringUtils.equals("03", deptReturnType)){
					if(semmsa002Bean.getSiteAppDeptElObj().getDepositType() != null && StringUtils.equals("02", semmsa002Bean.getSiteAppDeptElObj().getDepositType())){
						semmsa002Bean.getSiteAppDeptCashElObj().setReturnAmt(null);
					}else if(semmsa002Bean.getSiteAppDeptElObj().getDepositType() != null && StringUtils.equals("01", semmsa002Bean.getSiteAppDeptElObj().getDepositType())){
						semmsa002Bean.getSiteAppDeptBgElObj().setReturnAmt(null);
					}
					
					semmsa002Bean.setDeptReturnTypeEl01("");
					semmsa002Bean.setDeptReturnTypeEl02("");
//					semmsa002Bean.setDeptReturnType03(true);
				}
				if(semmsa002Bean.getSiteAppDeptElObj().getDepositType() != null && StringUtils.equals("02", semmsa002Bean.getSiteAppDeptElObj().getDepositType())){
					semmsa002Bean.getSiteAppDeptCashElObj().setDepositReturnType(deptReturnType);
				}else if(semmsa002Bean.getSiteAppDeptElObj().getDepositType() != null && StringUtils.equals("01", semmsa002Bean.getSiteAppDeptElObj().getDepositType())){
					semmsa002Bean.getSiteAppDeptBgElObj().setDepositReturnType(deptReturnType);
				}
				setSemmsa002Bean(semmsa002Bean);
				this.doCalDepositElReturnAmt();
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("Error SEMMSA002Action renderDeptReturnTypeEl : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" #### END SEMMSA002Action renderDeptReturnTypeEl ####");
		}
		return true;
	}
	
	public void initUpdDeptReturnTypeEl(){
		LOG.debug(" #### START SEMMSA002Action initUpdDeptReturnTypeEl ####");
		semmsa002Bean = getSemmsa002Bean();
		try{
			if(semmsa002Bean.getSiteAppDeptElObj().getDepositType() != null && StringUtils.equals("02", semmsa002Bean.getSiteAppDeptElObj().getDepositType())){
				if(semmsa002Bean.getSiteAppDeptCashElObj().getDepositReturnType() != null){
					if(StringUtils.isEmpty(semmsa002Bean.getSiteAppDeptCashElObj().getDepositReturnType())){
						semmsa002Bean.getSiteAppDeptCashElObj().setDepositReturnType("");
					}
					
					if(semmsa002Bean.getSiteAppDeptCashElObj().getDepositReturnType() != null && semmsa002Bean.getSiteAppDeptCashElObj().getDepositReturnType().equals("01")){
						semmsa002Bean.setDeptReturnTypeEl01(semmsa002Bean.getSiteAppDeptElObj().getDepositReturnType());
						semmsa002Bean.setDeptReturnTypeEl02(null);
						semmsa002Bean.setDeptReturnTypeEl03(null);

						semmsa002Bean.getSiteAppDeptCashElObj().setReturnAmt(BigDecimal.ZERO);
						
					}
					
					if(semmsa002Bean.getSiteAppDeptCashElObj().getDepositReturnType() != null && semmsa002Bean.getSiteAppDeptCashElObj().getDepositReturnType().equals("02")){
						semmsa002Bean.setDeptReturnTypeEl02(semmsa002Bean.getSiteAppDeptCashElObj().getDepositReturnType());
						semmsa002Bean.setDeptReturnTypeEl01(null);
						semmsa002Bean.setDeptReturnTypeEl03(null);

//						semmsa002Bean.getSiteAppDeptObj().setReturnAmt(BigDecimal.ZERO);
						
					}
					
					if(semmsa002Bean.getSiteAppDeptCashElObj().getDepositReturnType() != null && semmsa002Bean.getSiteAppDeptCashElObj().getDepositReturnType().equals("03")){
						semmsa002Bean.setDeptReturnTypeEl03(semmsa002Bean.getSiteAppDeptCashElObj().getDepositReturnType());
						semmsa002Bean.setDeptReturnTypeEl01(null);
						semmsa002Bean.setDeptReturnTypeEl02(null);

						semmsa002Bean.getSiteAppDeptCashElObj().setReturnAmt(BigDecimal.ZERO);
						
					}
					
				}else{
					semmsa002Bean.setDeptReturnTypeEl01(null);
					semmsa002Bean.setDeptReturnTypeEl02(null);
					semmsa002Bean.setDeptReturnTypeEl03(null);

					semmsa002Bean.getSiteAppDeptCashObj().setReturnAmt(BigDecimal.ZERO);
				}
			}else if(semmsa002Bean.getSiteAppDeptElObj().getDepositType() != null && StringUtils.equals("01", semmsa002Bean.getSiteAppDeptElObj().getDepositType())){
				if(semmsa002Bean.getSiteAppDeptBgElObj().getDepositReturnType() != null){
					if(StringUtils.isEmpty(semmsa002Bean.getSiteAppDeptBgElObj().getDepositReturnType())){
						semmsa002Bean.getSiteAppDeptBgElObj().setDepositReturnType("");
					}
					
					if(semmsa002Bean.getSiteAppDeptBgElObj().getDepositReturnType() != null && semmsa002Bean.getSiteAppDeptBgElObj().getDepositReturnType().equals("01")){
						semmsa002Bean.setDeptReturnTypeEl01(semmsa002Bean.getSiteAppDeptElObj().getDepositReturnType());
						semmsa002Bean.setDeptReturnTypeEl02(null);
						semmsa002Bean.setDeptReturnTypeEl03(null);

						semmsa002Bean.getSiteAppDeptBgElObj().setReturnAmt(BigDecimal.ZERO);
						
					}
					
					if(semmsa002Bean.getSiteAppDeptBgElObj().getDepositReturnType() != null && semmsa002Bean.getSiteAppDeptBgElObj().getDepositReturnType().equals("02")){
						semmsa002Bean.setDeptReturnTypeEl02(semmsa002Bean.getSiteAppDeptBgElObj().getDepositReturnType());
						semmsa002Bean.setDeptReturnTypeEl01(null);
						semmsa002Bean.setDeptReturnTypeEl03(null);

//						semmsa002Bean.getSiteAppDeptObj().setReturnAmt(BigDecimal.ZERO);
						
					}
					
					if(semmsa002Bean.getSiteAppDeptBgElObj().getDepositReturnType() != null && semmsa002Bean.getSiteAppDeptBgElObj().getDepositReturnType().equals("03")){
						semmsa002Bean.setDeptReturnTypeEl03(semmsa002Bean.getSiteAppDeptBgElObj().getDepositReturnType());
						semmsa002Bean.setDeptReturnTypeEl01(null);
						semmsa002Bean.setDeptReturnTypeEl02(null);

						semmsa002Bean.getSiteAppDeptBgElObj().setReturnAmt(BigDecimal.ZERO);
						
					}
					
				}else{
					semmsa002Bean.setDeptReturnTypeEl01(null);
					semmsa002Bean.setDeptReturnTypeEl02(null);
					semmsa002Bean.setDeptReturnTypeEl03(null);

					semmsa002Bean.getSiteAppDeptBgElObj().setReturnAmt(BigDecimal.ZERO);
				}
			}else{
				semmsa002Bean.setDeptReturnTypeEl01(null);
				semmsa002Bean.setDeptReturnTypeEl02(null);
				semmsa002Bean.setDeptReturnTypeEl03(null);
				semmsa002Bean.getSiteAppDeptCashElObj().setReturnAmt(BigDecimal.ZERO);
				semmsa002Bean.getSiteAppDeptBgElObj().setReturnAmt(BigDecimal.ZERO);
			}
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("Error SEMMSA002Action initUpdDeptReturnTypeEl : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" #### END SEMMSA002Action initUpdDeptReturnTypeEl ####");
		}
	}
	
	public boolean doEditDepositEl(){
		LOG.debug(" ### START SEMMSA002Action doEditDepositEl ### ");
		boolean flag = true;
		semmsa002Bean = getSemmsa002Bean();
		String siteAppDepositId = getFacesUtils().getRequestParameter("siteAppDepositId") == null ? "" : (String)getFacesUtils().getRequestParameter("siteAppDepositId");
		String depositType = getFacesUtils().getRequestParameter("depositType") == null ? "" : (String)getFacesUtils().getRequestParameter("depositType");
		try{
			
			
				if(StringUtils.equals("02", depositType)){
					if(semmsa002Bean.getSiteAppDeptCashElList() != null && semmsa002Bean.getSiteAppDeptCashElList().size() > 0){
						for(WrapperBeanObject<SiteAppSP> rentContWrapObj : semmsa002Bean.getSiteAppDeptCashElList()){
							SiteAppSP siteApp = new SiteAppSP(); 
							siteApp = (SiteAppSP) rentContWrapObj.getDataObj();
							
							if(StringUtils.equals(siteAppDepositId, siteApp.getSiteAppDepositId())){
								if(StringUtils.equals("Y", siteApp.getWithdrawFlag())){
									semmsa002Bean.setWithdrawFlagEl(true);
								}else{
									semmsa002Bean.setWithdrawFlagEl(false);
								}
								
//								siteApp.setRentContMode("C");
								semmsa002Bean.setSiteAppDeptElObj(siteApp);
								semmsa002Bean.setSiteAppDeptCashElObj(siteApp);
								
								setSemmsa002Bean(semmsa002Bean);
								this.doRenderEditDeptBgCashEl();
								this.initUpdDeptReturnTypeEl();
								this.doCalDepositElReturnAmt();
								this.doCalDepositElAmt();
								this.doInitDepositEl();
								
								semmsa002Bean.getSiteAppDeptElObj().setSiteAppDepositId(siteAppDepositId);
								semmsa002Bean.getSiteAppDeptCashElObj().setSiteAppDepositId(siteAppDepositId);
							}
						}
					}
				}
				
				if(StringUtils.equals("01", depositType)){
					if(semmsa002Bean.getSiteAppDeptBGElList() != null && semmsa002Bean.getSiteAppDeptBGElList().size() > 0){
						for(WrapperBeanObject<SiteAppSP> rentContWrapObj : semmsa002Bean.getSiteAppDeptBGElList()){
							SiteAppSP siteApp = new SiteAppSP(); 
							siteApp = (SiteAppSP) rentContWrapObj.getDataObj();
							
							if(StringUtils.equals(siteAppDepositId, siteApp.getSiteAppDepositId())){

								if(StringUtils.equals("Y", siteApp.getWithdrawFlag())){
									semmsa002Bean.setWithdrawFlagEl(true);
								}else{
									semmsa002Bean.setWithdrawFlagEl(false);
								}
								
//								siteApp.setRentContMode("C");
								semmsa002Bean.setSiteAppDeptElObj(siteApp);
								semmsa002Bean.setSiteAppDeptBgElObj(siteApp);
								setSemmsa002Bean(semmsa002Bean);
								this.doRenderEditDeptBgCashEl();
								this.initUpdDeptReturnTypeEl();
								this.doCalDepositElReturnAmt();
								this.doCalDepositElAmt();
								this.doInitDepositEl();
								
								semmsa002Bean.getSiteAppDeptElObj().setSiteAppDepositId(siteAppDepositId);
								semmsa002Bean.getSiteAppDeptBgElObj().setSiteAppDepositId(siteAppDepositId);
							}
						}
					}
					
				}
				
				
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("ERROR SEMMSA002Action doEditDepositEl : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" ### END SEMMSA002Action doEditDepositEl ### ");
		}
		return flag;
	}
	
	public void doSiteAppTPSrch(){
		LOG.debug(" #### Start SEMMSA002Action doSiteAppTPSrch ####");
		semmsa002Bean = getSemmsa002Bean();
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteAppSP> to = null;
		try{
			LOG.debug("doSiteAppTPSrch getSiteAppId :"+semmsa002Bean.getSiteAppObjParam().getSiteAppId());
//			semmsa002Bean.getSiteAppObjParam().setRentContMode("C");
			to = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA002_SITE_APP_PT_SRCH.name, semmsa002Bean.getSiteAppObjParam());
			LOG.debug("size [" + to.size() + "]");
			
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsa002Bean.setRenderedMsgDataNotFound(true);
//				semmsa002Bean.setSiteContInfo(null);
			}
			
			if(to != null && to.size() > 0){
//				flag = true;
				semmsa002Bean.setRenderedMsgDataNotFound(false);

				semmsa002Bean.setSiteAppPTObj(new SiteAppSP());
				
				for (int i = 0; i < to.size(); i++) {
					SiteAppSP siteAcq = (SiteAppSP) to.get(i);
					WrapperBeanObject<SiteAppSP> tmpWrapperBean = new WrapperBeanObject<SiteAppSP>();
					
					if(siteAcq.getNoExpFlag() != null){
						if(StringUtils.equals("Y", siteAcq.getNoExpFlag().toUpperCase())){
							semmsa002Bean.setNoExpFlag(true);
						}else{
							semmsa002Bean.setNoExpFlag(false);
						}
					}else{
						semmsa002Bean.setNoExpFlag(false);
					}
					
					if(siteAcq.getEffectiveDt() != null){
						siteAcq.setEffectiveDtStr(convertYearENtoTHStr(siteAcq.getEffectiveDt()));
					}
					
					if(siteAcq.getExpireDt() != null){
						siteAcq.setExpireDtStr(convertYearENtoTHStr(siteAcq.getExpireDt()));
					}
					

					if(siteAcq.getPtEffectiveDt() != null){
						siteAcq.setPtEffectiveDtStr(convertYearENtoTHStr(siteAcq.getPtEffectiveDt()));
					}
					
					if(siteAcq.getPtRemark() == null){
						siteAcq.setPtRemark("");
					}
					
//				semmsa002Bean.siteAppPTObj.ptTaxPayType
					LOG.debug(" getPtTaxPayType ;:: "+siteAcq.getPtTaxPayType());
					LOG.debug(" getPtRemark ;:: "+siteAcq.getPtRemark());
					if(siteAcq != null){
//						semmsa002Bean.getSiteAppRentCont().add(tmpWrapperBean);
						semmsa002Bean.setSiteAppPTObj(siteAcq);
//						
						
					}
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doSiteAppTPSrch : "+e);
		}finally{
			LOG.debug(" #### End SEMMSA002Action doSiteAppTPSrch ####");
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	
	public void doSiteAppTPHistSrch(){
		LOG.debug(" #### Start SEMMSA002Action doSiteAppTPHistSrch ####");
		semmsa002Bean = getSemmsa002Bean();
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteAppSP> to = null;
		try{
			LOG.debug("doSiteAppTPHistSrch getSiteAppId :"+semmsa002Bean.getSiteAppObjParam().getSiteAppId());
//			semmsa002Bean.getSiteAppObjParam().setRentContMode("C");
			to = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA002_SITE_APP_PT_HIST_SRCH.name, semmsa002Bean.getSiteAppObjParam());
			LOG.debug("size [" + to.size() + "]");
			
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsa002Bean.setRenderedMsgDataNotFound(true);
//				semmsa002Bean.setSiteContInfo(null);
				
			}
			
			if(to != null && to.size() > 0){
//				flag = true;
				semmsa002Bean.setRenderedMsgDataNotFound(false);

//				semmsa002Bean.setSiteAppPTObj(new SiteAppSP());
				semmsa002Bean.setSiteAppPTHistList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				
				for (int i = 0; i < to.size(); i++) {
					SiteAppSP siteAcq = (SiteAppSP) to.get(i);
					WrapperBeanObject<SiteAppSP> tmpWrapperBean = new WrapperBeanObject<SiteAppSP>();
					
					if(siteAcq.getNoExpFlag() != null){
						if(StringUtils.equals("Y", siteAcq.getNoExpFlag().toUpperCase())){
							semmsa002Bean.setNoExpFlag(true);
						}else{
							semmsa002Bean.setNoExpFlag(false);
						}
					}else{
						semmsa002Bean.setNoExpFlag(false);
					}
					
					if(siteAcq.getEffectiveDt() != null){
						siteAcq.setEffectiveDtStr(convertYearENtoTHStr(siteAcq.getEffectiveDt()));
					}
					
					if(siteAcq.getExpireDt() != null){
						siteAcq.setExpireDtStr(convertYearENtoTHStr(siteAcq.getExpireDt()));
					}
					

					if(siteAcq.getPtEffectiveDt() != null){
						siteAcq.setPtEffectiveDtStr(convertYearENtoTHStr(siteAcq.getPtEffectiveDt()));
					}
					
					
//					
					if(siteAcq.getUpdateDt() != null){
						siteAcq.setUpdateDtStr(convertYearENtoTHStr(siteAcq.getUpdateDt()));
					}
////					
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					tmpWrapperBean.setDataObj(siteAcq);
					
					if(siteAcq != null){
						semmsa002Bean.getSiteAppPTHistList().add(tmpWrapperBean);
//						
					}
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doSiteAppTPHistSrch : "+e);
		}finally{
			LOG.debug(" #### End SEMMSA002Action doSiteAppTPHistSrch ####");
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	
	public boolean doUpdateSiteAppPT(){
		LOG.debug(" #### Start SEMMSA002Action doUpdateSiteAppPT ####");
		boolean flag = false;
		semmsa002Bean = getSemmsa002Bean();
		String siteAppId = "";
		String depositType = "";
		String expenseType = "";
		SiteAppSP siteAppObj = new SiteAppSP();
		try{
			ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
			List<SiteAppSP> to = null;
			
			siteAppId = semmsa002Bean.getSiteAppObjParam().getSiteAppId();
//			depositType = semmsa002Bean.getSiteAppDeptObj().getDepositType();
//			expenseType = semmsa002Bean.getSiteAppDeptElObj().getExpenseType();
			
			if(semmsa002Bean.getSiteAppPTObjParam() != null){
					semmsa002Bean.getSiteAppPTObjParam().setSiteAppId(siteAppId);
					semmsa002Bean.getSiteAppPTObjParam().setUserId(getUserLogIn());
					
					//Debug
					LOG.debug(" doUpdateSiteAppPT siteAppDepositId : "+semmsa002Bean.getSiteAppPTObjParam().getSiteAppDepositId());
					LOG.debug(" doUpdateSiteAppPT siteAppId : "+semmsa002Bean.getSiteAppPTObjParam().getSiteAppId());
					LOG.debug(" doUpdateSiteAppPT getPtTaxPayType : "+semmsa002Bean.getSiteAppPTObjParam().getPtTaxPayType());
					LOG.debug(" doUpdateSiteAppPT getPtRemark : "+semmsa002Bean.getSiteAppPTObjParam().getPtRemark());
					LOG.debug(" doUpdateSiteAppPT getPtEffectiveDt : "+semmsa002Bean.getSiteAppPTObjParam().getPtEffectiveDt());
					
					siteAppObj = semmsa002Bean.getSiteAppPTObjParam();
				}
			
			to = service.siteAppDao_querySPList(EQueryName.SP_MSA002_SITE_APP_PT_UPD.name, siteAppObj);
			
			if (to != null && !to.isEmpty()) {
				String retMsg = to.get(0).getRetResultMsg() == null ? "" : to.get(0).getRetResultMsg().toString();
				
				if (to.get(0).getRetResult().equals("Success")) {

					
					String myMsgArr[];
					if(!retMsg.equals("")){
						myMsgArr = retMsg.split("<BR/>");
						
						for(int i=0; i < myMsgArr.length; i++){
							//addGeneralMessageInfo(myMsgArr[i]);
							//addGeneralMessageWarn(myMsgArr[i]);
							FrontMessageUtils.addMessageWarn(myMsgArr[i]);	// optional
						}
					}
					
						this.doSiteAppTPSrch();
//						this.doSiteAppTPHistSrch();
						
						this.doClearSiteAppPT();
					
					
					flag = true;
					semmsa002Bean.setRenderedMsgAlert(true);
				} else {
					if(to.get(0).getRetResult() != null){
						if("FAIL".equals(to.get(0).getRetResult().toUpperCase())){
							semmsa002Bean.setDisabledButtonPopupResult(false);
						}else if("FAIL2".equals(to.get(0).getRetResult().toUpperCase())){
							semmsa002Bean.setDisabledButtonPopupResult(true);
						}
						
					}
//					System.out.println("to.get(0).getRetResultMsg() = "+to.get(0).getRetResultMsg());
					if(to.get(0).getRetResultMsg() != null)
						addGeneralMessageError(to.get(0).getRetResultMsg());	// data save fail
					else
						addMessageError("E0001");	// data save fail
	        		semmsa002Bean.setRenderedMsgAlert(true);
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("Error SEMMSA002Action doUpdateSiteAppPT : "+e);
		}
		LOG.debug(" #### End SEMMSA002Action doUpdateSiteAppPT ####");
		return flag;
	}
	
	public boolean doClearSiteAppPT(){
		LOG.debug(" #### Start SEMMSA002Action doClearSiteAppPT ####");
		semmsa002Bean = getSemmsa002Bean();
		try{
			semmsa002Bean.setSiteAppPTObjParam(new SiteAppSP());
			semmsa002Bean.setPropertyTaxEditFlag(false);
//			semmsa002Bean.setSiteAppDeptCashObj(new SiteAppSP());
//			semmsa002Bean.setSiteAppDeptBgObj(new SiteAppSP());
			setSemmsa002Bean(semmsa002Bean);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doClearSiteAppPT : "+e);
		}
		LOG.debug(" #### End SEMMSA002Action doClearSiteAppPT ####");
		return true;
	}
	
	private boolean doInitEditPT(){
		LOG.debug(" #### Start SEMMSA002Action doInitEditPT ####");
		semmsa002Bean = getSemmsa002Bean();
		try{
			String ptTaxPayType = getFacesUtils().getRequestParameter("ptTaxPayType") == null ? "" : (String)getFacesUtils().getRequestParameter("ptTaxPayType");
			String ptRemark = getFacesUtils().getRequestParameter("ptRemark") == null ? "" : (String)getFacesUtils().getRequestParameter("ptRemark");
//			String ptEffectiveDt = getFacesUtils().getRequestParameter("ptEffectiveDt") == null ? "" : (String)getFacesUtils().getRequestParameter("ptEffectiveDt");
			
			if(semmsa002Bean.isPropertyTaxEditFlag()){
				if(StringUtils.isNotEmpty(ptTaxPayType)){
					semmsa002Bean.getSiteAppPTObjParam().setPtTaxPayType(ptTaxPayType);
				}
				
				if(StringUtils.isNotEmpty(ptRemark)){
					semmsa002Bean.getSiteAppPTObjParam().setPtRemark(ptRemark);
				}
			}else{
				this.doClearSiteAppPT();
			}
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doInitEditPT : "+e);
		}finally{
			LOG.debug(" #### End SEMMSA002Action doInitEditPT ####");	
			setSemmsa002Bean(semmsa002Bean);
		}
		return true;
	}
	
	public boolean renderInsuranceType(){
		boolean flag = true;
		semmsa002Bean = getSemmsa002Bean();
		try{
			String insuranceType = semmsa002Bean.getSiteAppInsuranceObjParam().getInsuranceType();
			if(insuranceType != null){
				if(StringUtils.equals("04", insuranceType)){
					semmsa002Bean.setRenderedPLX(true);
					semmsa002Bean.setRenderedInsuranceOwner(false);
					
					//set default IR PeriodStartDt
					if(semmsa002Bean.getSiteAppObjParam().getEffectiveDt() != null)
						semmsa002Bean.getSiteAppInsuranceObjParam().setPlxEffectiveDt(semmsa002Bean.getSiteAppObjParam().getEffectiveDt());
					
					//set default IR setPeriodEndDt
					if(semmsa002Bean.getSiteAppObjParam().getExpireDt() != null)
						semmsa002Bean.getSiteAppInsuranceObjParam().setPlxExpireDt(semmsa002Bean.getSiteAppObjParam().getExpireDt());
					
					semmsa002Bean.setPayPeriodTypeIns01(null);
					semmsa002Bean.setPayPeriodTypeIns02(null);
					semmsa002Bean.setPayPeriodTypeIns03(null);
					semmsa002Bean.setPayPeriodTypeIns04(null);
					semmsa002Bean.setPayPeriodTypeIns05(null);
					semmsa002Bean.setPayPeriodIns03(null);
					semmsa002Bean.setPayPeriodIns04(null);
					semmsa002Bean.setDisabledPayPeriodIns03(true);
					semmsa002Bean.setDisabledPayPeriodIns04(true);
					semmsa002Bean.getSiteAppInsuranceObjParam().setOwnerVatType("04");
//					semmsa002Bean.getSiteAppInsuranceObjParam().setOwnerAmt(null);
					semmsa002Bean.getSiteAppInsuranceObjParam().setOwnerPeriodType("");
				}else if(StringUtils.equals("02", insuranceType) || StringUtils.equals("03", insuranceType)){
					semmsa002Bean.setRenderedInsuranceOwner(true);
					semmsa002Bean.setRenderedPLX(false);
					semmsa002Bean.setPayPeriodTypeIns01("01");
					semmsa002Bean.setPayPeriodTypeIns02(null);
					semmsa002Bean.setPayPeriodTypeIns03(null);
					semmsa002Bean.setPayPeriodTypeIns04(null);
					semmsa002Bean.setPayPeriodTypeIns05(null);
					semmsa002Bean.setPayPeriodIns03(null);
					semmsa002Bean.setPayPeriodIns04(null);
					semmsa002Bean.setDisabledPayPeriodIns03(true);
					semmsa002Bean.setDisabledPayPeriodIns04(true);
					semmsa002Bean.getSiteAppInsuranceObjParam().setPlxEffectiveDt(null);
					semmsa002Bean.getSiteAppInsuranceObjParam().setPlxExpireDt(null);
					semmsa002Bean.getSiteAppInsuranceObjParam().setPlxBeneficiary("");
//					semmsa002Bean.getSiteAppInsuranceObjParam().setPlxAmt(null);
					semmsa002Bean.getSiteAppInsuranceObjParam().setOwnerVatType("03");
				}else{
					semmsa002Bean.setRenderedInsuranceOwner(false);
					semmsa002Bean.setRenderedPLX(false);
					
					semmsa002Bean.setPayPeriodTypeIns01(null);
					semmsa002Bean.setPayPeriodTypeIns02(null);
					semmsa002Bean.setPayPeriodTypeIns03(null);
					semmsa002Bean.setPayPeriodTypeIns04(null);
					semmsa002Bean.setPayPeriodTypeIns05(null);
					semmsa002Bean.setPayPeriodIns03(null);
					semmsa002Bean.setPayPeriodIns04(null);
					semmsa002Bean.setDisabledPayPeriodIns03(true);
					semmsa002Bean.setDisabledPayPeriodIns04(true);
					semmsa002Bean.getSiteAppInsuranceObjParam().setPlxEffectiveDt(null);
					semmsa002Bean.getSiteAppInsuranceObjParam().setPlxExpireDt(null);
					semmsa002Bean.getSiteAppInsuranceObjParam().setPlxBeneficiary("");
//					semmsa002Bean.getSiteAppInsuranceObjParam().setPlxAmt(null);
					semmsa002Bean.getSiteAppInsuranceObjParam().setOwnerVatType("04");
					semmsa002Bean.getSiteAppInsuranceObjParam().setOwnerAmt(null);
					semmsa002Bean.getSiteAppInsuranceObjParam().setOwnerPeriodType("");
				}
			}else{
				semmsa002Bean.setRenderedInsuranceOwner(false);
				semmsa002Bean.setRenderedPLX(false);
				
				semmsa002Bean.setPayPeriodTypeIns01(null);
				semmsa002Bean.setPayPeriodTypeIns02(null);
				semmsa002Bean.setPayPeriodTypeIns03(null);
				semmsa002Bean.setPayPeriodTypeIns04(null);
				semmsa002Bean.setPayPeriodTypeIns05(null);
				semmsa002Bean.setPayPeriodIns03(null);
				semmsa002Bean.setPayPeriodIns04(null);
				semmsa002Bean.setDisabledPayPeriodIns03(true);
				semmsa002Bean.setDisabledPayPeriodIns04(true);
				semmsa002Bean.getSiteAppInsuranceObjParam().setPlxEffectiveDt(null);
				semmsa002Bean.getSiteAppInsuranceObjParam().setPlxExpireDt(null);
				semmsa002Bean.getSiteAppInsuranceObjParam().setPlxBeneficiary("");
//				semmsa002Bean.getSiteAppInsuranceObjParam().setPlxAmt(null);
				semmsa002Bean.getSiteAppInsuranceObjParam().setOwnerVatType("04");
				semmsa002Bean.getSiteAppInsuranceObjParam().setOwnerAmt(null);
				semmsa002Bean.getSiteAppInsuranceObjParam().setOwnerPeriodType("");
			}
			
			
			String irHeaderLabel;
			semmsa002Bean.setIrHeaderLabel("");
			for(int i = 0;i<semmsa002Bean.getInsuranceTypeList().size();i++){
				if(StringUtils.equals(insuranceType, (String)semmsa002Bean.getInsuranceTypeList().get(i).getValue())){
					irHeaderLabel = (String)semmsa002Bean.getInsuranceTypeList().get(i).getLabel();
					semmsa002Bean.setIrHeaderLabel(irHeaderLabel);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			setSemmsa002Bean(semmsa002Bean);
		}
		
		return flag;
	}
	
	public boolean renderPayPeriodTypeIns(){
		LOG.debug(" #### Start SEMMSA002Action renderPayPeriodTypeIns ####");	
		boolean flag = false;
		semmsa002Bean = getSemmsa002Bean();
		String ownerPayPeriodType = (String)getFacesUtils().getRequestParameter("ownerPayPeriodType");
		
		try{
			if(StringUtils.equals("01", ownerPayPeriodType)){
				semmsa002Bean.setPayPeriodTypeIns02("");
				semmsa002Bean.setPayPeriodTypeIns03("");
				semmsa002Bean.setPayPeriodTypeIns04("");
				semmsa002Bean.setPayPeriodTypeIns05("");
				semmsa002Bean.setPayPeriodTypeIns06("");
				semmsa002Bean.setPayPeriodTypeIns07("");
				semmsa002Bean.setPayPeriodIns03(null);
				semmsa002Bean.setPayPeriodIns04(null);
				semmsa002Bean.setDisabledPayPeriodIns03(true);
				semmsa002Bean.setDisabledPayPeriodIns04(true);
			}else if(StringUtils.equals("02", ownerPayPeriodType)){
				semmsa002Bean.setPayPeriodTypeIns01("");
				semmsa002Bean.setPayPeriodTypeIns03("");
				semmsa002Bean.setPayPeriodTypeIns04("");
				semmsa002Bean.setPayPeriodTypeIns05("");
				semmsa002Bean.setPayPeriodTypeIns06("");
				semmsa002Bean.setPayPeriodTypeIns07("");
				semmsa002Bean.setPayPeriodIns03(null);
				semmsa002Bean.setPayPeriodIns04(null);
				semmsa002Bean.setDisabledPayPeriodIns03(true);
				semmsa002Bean.setDisabledPayPeriodIns04(true);
			}else if(StringUtils.equals("03", ownerPayPeriodType)){
				if(semmsa002Bean.getPayPeriodIns03() != null) semmsa002Bean.getSiteAppInsuranceObjParam().setOwnerPayPeriod(semmsa002Bean.getPayPeriodIns03());
				semmsa002Bean.setPayPeriodTypeIns01("");
				semmsa002Bean.setPayPeriodTypeIns02("");
				semmsa002Bean.setPayPeriodTypeIns04("");
				semmsa002Bean.setPayPeriodTypeIns05("");
				semmsa002Bean.setPayPeriodTypeIns06("");
				semmsa002Bean.setPayPeriodTypeIns07("");
				semmsa002Bean.setPayPeriodIns04(null);
				semmsa002Bean.setDisabledPayPeriodIns03(false);
				semmsa002Bean.setDisabledPayPeriodIns04(true);
			}else if(StringUtils.equals("04", ownerPayPeriodType)){
				if(semmsa002Bean.getPayPeriodIns04() != null) semmsa002Bean.getSiteAppInsuranceObjParam().setOwnerPayPeriod(semmsa002Bean.getPayPeriodIns04());
				semmsa002Bean.setPayPeriodTypeIns01("");
				semmsa002Bean.setPayPeriodTypeIns02("");
				semmsa002Bean.setPayPeriodTypeIns03("");
				semmsa002Bean.setPayPeriodTypeIns05("");
				semmsa002Bean.setPayPeriodTypeIns06("");
				semmsa002Bean.setPayPeriodTypeIns07("");
				semmsa002Bean.setPayPeriodIns03(null);
				semmsa002Bean.setDisabledPayPeriodIns03(true);
				semmsa002Bean.setDisabledPayPeriodIns04(false);
			}else if(StringUtils.equals("06", ownerPayPeriodType)){
				semmsa002Bean.setPayPeriodTypeIns01("");
				semmsa002Bean.setPayPeriodTypeIns02("");
				semmsa002Bean.setPayPeriodTypeIns03("");
				semmsa002Bean.setPayPeriodTypeIns04("");
				semmsa002Bean.setPayPeriodTypeIns05("");
				semmsa002Bean.setPayPeriodTypeIns07("");
				semmsa002Bean.setPayPeriodIns03(null);
				semmsa002Bean.setPayPeriodIns04(null);
				semmsa002Bean.setDisabledPayPeriodIns03(true);
				semmsa002Bean.setDisabledPayPeriodIns04(true);
			}else if(StringUtils.equals("07", ownerPayPeriodType)){
				semmsa002Bean.setPayPeriodTypeIns01("");
				semmsa002Bean.setPayPeriodTypeIns02("");
				semmsa002Bean.setPayPeriodTypeIns03("");
				semmsa002Bean.setPayPeriodTypeIns04("");
				semmsa002Bean.setPayPeriodTypeIns05("");
				semmsa002Bean.setPayPeriodTypeIns06("");
				semmsa002Bean.setPayPeriodIns03(null);
				semmsa002Bean.setPayPeriodIns04(null);
				semmsa002Bean.setDisabledPayPeriodIns03(true);
				semmsa002Bean.setDisabledPayPeriodIns04(true);
			}else {
				semmsa002Bean.setPayPeriodTypeIns01("");
				semmsa002Bean.setPayPeriodTypeIns02("");
				semmsa002Bean.setPayPeriodTypeIns03("");
				semmsa002Bean.setPayPeriodTypeIns04("");
				semmsa002Bean.setPayPeriodTypeIns05("");
				semmsa002Bean.setPayPeriodTypeIns06("");
				semmsa002Bean.setPayPeriodTypeIns07("");
				semmsa002Bean.setPayPeriodIns03(null);
				semmsa002Bean.setPayPeriodIns04(null);
				semmsa002Bean.setDisabledPayPeriodIns03(true);
				semmsa002Bean.setDisabledPayPeriodIns04(true);
			}
			if(ownerPayPeriodType != null)
				semmsa002Bean.getSiteAppInsuranceObjParam().setOwnerPayPeriodType(ownerPayPeriodType);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action renderPayPeriodTypeIns : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" #### End SEMMSA002Action renderPayPeriodTypeIns ####");	
		}
		
		return flag;
	}
	

	public void doSiteAppIRSrch(){
		LOG.debug(" #### Start SEMMSA002Action doSiteAppIRSrch ####");
		semmsa002Bean = getSemmsa002Bean();
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteAppSP> to = null;
		try{
			LOG.debug("doSiteAppIRSrch getSiteAppId :"+semmsa002Bean.getSiteAppObjParam().getSiteAppId());
			SiteAppSP siteAppObj = new SiteAppSP();
			siteAppObj.setSiteAppId(semmsa002Bean.getSiteAppObjParam().getSiteAppId());
			siteAppObj.setMode("C");
			siteAppObj.setContractNo(semmsa002Bean.getSiteAppObjParam().getContractNo());
			to = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA002_SITE_APP_IR_SRCH.name, siteAppObj);
			LOG.debug("size [" + to.size() + "]");
			
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsa002Bean.setRenderedMsgDataNotFound(true);
				semmsa002Bean.setSiteAppInsuranceObj(null);
				
			}
			
			if(to != null && to.size() > 0){
//				flag = true;
				semmsa002Bean.setRenderedMsgDataNotFound(false);

				semmsa002Bean.setSiteAppInsuranceObj(new SiteAppSP());
//				semmsa002Bean.setSiteAppInsuranceList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
//				semmsa002Bean.setSiteAppDeptBGList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				
				for (int i = 0; i < to.size(); i++) {
					SiteAppSP siteAcq = (SiteAppSP) to.get(i);
//					
					if(siteAcq.getPlxEffectiveDt() != null){
						siteAcq.setPlxEffectiveDtStr(convertYearENtoTHStr(siteAcq.getPlxEffectiveDt()));
					}
					
					if(siteAcq.getPlxExpireDt() != null){
						siteAcq.setPlxExpireDtStr(convertYearENtoTHStr(siteAcq.getPlxExpireDt()));
					}
					
					if(siteAcq.getInsEffectiveDt() != null){
						siteAcq.setInsEffectiveDtStr(convertYearENtoTHStr(siteAcq.getInsEffectiveDt()));
					}
					
					if(siteAcq.getEffectiveDt() != null){
						siteAcq.setEffectiveDtStr(convertYearENtoTHStr(siteAcq.getEffectiveDt()));
					}
					
					if(siteAcq.getExpireDt() != null){
						siteAcq.setExpireDtStr(convertYearENtoTHStr(siteAcq.getExpireDt()));
					}
					
					if(StringUtils.equals("Y", siteAcq.getNoOwnerAmt())){
						semmsa002Bean.setNoOwnerAmtFlag(true);
					}
//
					LOG.debug("siteAcq.getPlxAmt() : "+siteAcq.getPlxAmt());
					LOG.debug("siteAcq.getOwnerAmtt() : "+siteAcq.getOwnerAmt());
					LOG.debug("siteAcq.getsiteAppInsuranceId() : "+siteAcq.getSiteAppInsuranceId());
					if(siteAcq != null){
						semmsa002Bean.setSiteAppInsuranceObj(siteAcq);
					}
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doSiteAppIRSrch : "+e);
		}finally{
			LOG.debug(" #### End SEMMSA002Action doSiteAppIRSrch ####");
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	
	public void doSiteAppIRHistSrch(){
		LOG.debug(" #### Start SEMMSA002Action doSiteAppIRHistSrch ####");
		semmsa002Bean = getSemmsa002Bean();
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteAppSP> to = null;
		try{
			LOG.debug("doSiteAppIRSrch getSiteAppId :"+semmsa002Bean.getSiteAppObjParam().getSiteAppId());
			SiteAppSP siteAppObj = new SiteAppSP();
			siteAppObj.setSiteAppId(semmsa002Bean.getSiteAppObjParam().getSiteAppId());
			siteAppObj.setMode("H");
			siteAppObj.setContractNo(semmsa002Bean.getSiteAppObjParam().getContractNo());
			to = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA002_SITE_APP_IR_SRCH.name, siteAppObj);
			LOG.debug("size [" + to.size() + "]");
			
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsa002Bean.setRenderedMsgDataNotFound(true);
				semmsa002Bean.setSiteAppInsuranceList(null);
				
			}
			
			if(to != null && to.size() > 0){
//				flag = true;
				semmsa002Bean.setRenderedMsgDataNotFound(false);

//				semmsa002Bean.setSiteAppInsuranceObj(new SiteAppSP());
				semmsa002Bean.setSiteAppInsuranceList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
//				semmsa002Bean.setSiteAppDeptBGList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				
				for (int i = 0; i < to.size(); i++) {
					SiteAppSP siteAcq = (SiteAppSP) to.get(i);
					WrapperBeanObject<SiteAppSP> tmpWrapperBean = new WrapperBeanObject<SiteAppSP>();
				
					
					if(siteAcq.getPlxEffectiveDt() != null){
						siteAcq.setPlxEffectiveDtStr(convertYearENtoTHStr(siteAcq.getPlxEffectiveDt()));
					}
					
					if(siteAcq.getPlxExpireDt() != null){
						siteAcq.setPlxExpireDtStr(convertYearENtoTHStr(siteAcq.getPlxExpireDt()));
					}
					
					if(siteAcq.getEffectiveDt() != null){
						siteAcq.setEffectiveDtStr(convertYearENtoTHStr(siteAcq.getEffectiveDt()));
					}
					
					if(siteAcq.getExpireDt() != null){
						siteAcq.setExpireDtStr(convertYearENtoTHStr(siteAcq.getExpireDt()));
					}
					
					if(StringUtils.equals("Y", siteAcq.getNoOwnerAmt())){
						semmsa002Bean.setNoOwnerAmtFlag(true);
					}
//
//					
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					tmpWrapperBean.setDataObj(siteAcq);
					
					if(siteAcq != null){
						semmsa002Bean.getSiteAppInsuranceList().add(tmpWrapperBean);
						
					}
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doSiteAppIRHistSrch : "+e);
		}finally{
			LOG.debug(" #### End SEMMSA002Action doSiteAppIRHistSrch ####");
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	
	public boolean doSiteAppIRIns(){
		LOG.debug(" #### Start SEMMSA002Action doSiteAppIRIns ####");
		boolean flag = false;
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		semmsa002Bean = getSemmsa002Bean();
		List<SiteAppSP> to = null;
		String siteAppId = "";
		String depositType = "";
		SiteAppSP siteAppObj = new SiteAppSP();
		String mode = "";
		try{
			String elType = getFacesUtils().getRequestParameter("elType") == null ? "" : (String)getFacesUtils().getRequestParameter("elType");
			siteAppId = semmsa002Bean.getSiteAppObjParam().getSiteAppId();
//			depositType = semmsa002Bean.getSiteAppDeptObj().getDepositType();
			
//			if(StringUtils.equals("01", depositType)){
			this.doSetELCheckBoxEntity();	
			semmsa002Bean.getSiteAppInsuranceObjParam().setSiteAppId(siteAppId);
			semmsa002Bean.getSiteAppInsuranceObjParam().setUserId(getUserLogIn());
			
			if(semmsa002Bean.isNoOwnerAmtFlag()){
				semmsa002Bean.getSiteAppInsuranceObjParam().setNoOwnerAmt("Y");
			}
//			
//			semmsa002Bean.getSiteAppInsuranceObjParam().getInsuranceType();
//			semmsa002Bean.getSiteAppInsuranceObjParam().getRemark();
//			semmsa002Bean.getSiteAppInsuranceObjParam().getPlxOldAmt();
//			semmsa002Bean.getSiteAppInsuranceObjParam().getPlxAddAmt();
//			semmsa002Bean.getSiteAppInsuranceObjParam().getPlxAmt();
//			semmsa002Bean.getSiteAppInsuranceObjParam().getPlxEffectiveDt();
//			semmsa002Bean.getSiteAppInsuranceObjParam().getPlxExpireDt();
//			semmsa002Bean.getSiteAppInsuranceObjParam().getOwnerAmt();
//			semmsa002Bean.getSiteAppInsuranceObjParam().getOwnerPeriodType();
//			semmsa002Bean.getSiteAppInsuranceObjParam().getOwnerVatType();
//			semmsa002Bean.getSiteAppInsuranceObjParam().getPayPeriodType();
//			semmsa002Bean.getSiteAppInsuranceObjParam().getPayPeriod();
//			semmsa002Bean.getSiteAppInsuranceObjParam().getEffectiveDt();
//				
				LOG.debug("getInsuranceType : "+semmsa002Bean.getSiteAppInsuranceObjParam().getInsuranceType());
				LOG.debug("getRemark : "+semmsa002Bean.getSiteAppInsuranceObjParam().getRemark());
				LOG.debug("getPlxOldAmt : "+semmsa002Bean.getSiteAppInsuranceObjParam().getPlxOldAmt());
				LOG.debug("getPlxAddAmt : "+semmsa002Bean.getSiteAppInsuranceObjParam().getPlxAddAmt());
				LOG.debug("getPlxAmt : "+semmsa002Bean.getSiteAppInsuranceObjParam().getPlxAmt());
				LOG.debug("getPlxEffectiveDt : "+semmsa002Bean.getSiteAppInsuranceObjParam().getPlxEffectiveDt());
				LOG.debug("getPlxExpireDt : "+semmsa002Bean.getSiteAppInsuranceObjParam().getPlxExpireDt());
				LOG.debug("getOwnerAmt : "+semmsa002Bean.getSiteAppInsuranceObjParam().getOwnerAmt());
				LOG.debug("getOwnerPeriodType : "+semmsa002Bean.getSiteAppInsuranceObjParam().getOwnerPeriodType());
				LOG.debug("getOwnerVatType : "+semmsa002Bean.getSiteAppInsuranceObjParam().getOwnerVatType());
				LOG.debug("getPayPeriodType : "+semmsa002Bean.getSiteAppInsuranceObjParam().getPayPeriodType());
				LOG.debug("getPayPeriod : "+semmsa002Bean.getSiteAppInsuranceObjParam().getPayPeriod());
				LOG.debug("getEffectiveDt : "+semmsa002Bean.getSiteAppInsuranceObjParam().getEffectiveDt());
				LOG.debug("userId : "+semmsa002Bean.getSiteAppInsuranceObjParam().getUserId());
//				siteAppObj = semmsa002Bean.getSiteAppDeptCashObj();
//			}
//			semmsa002Bean.getSiteAppDeptObj().setSiteAppId(siteAppId);
//			semmsa002Bean.getSiteAppDeptObj().setUserId(getUserLogIn());
			
		
			
			to = service.siteAppDao_querySPList(EQueryName.SP_MSA002_SITE_APP_IR_INS.name, semmsa002Bean.getSiteAppInsuranceObjParam());
			
			if (to != null && !to.isEmpty() && to.size() > 0) {
				String retMsg = to.get(0).getRetResultMsg() == null ? "" : to.get(0).getRetResultMsg().toString();
				
				if (StringUtils.equals("SUCCESS", to.get(0).getRetResult().toUpperCase())) {

					
					String myMsgArr[];
					if(!retMsg.equals("")){
						myMsgArr = retMsg.split("<BR/>");
						
						for(int i=0; i < myMsgArr.length; i++){
							//addGeneralMessageInfo(myMsgArr[i]);
							//addGeneralMessageWarn(myMsgArr[i]);
							FrontMessageUtils.addMessageWarn(myMsgArr[i]);	// optional
						}
					}
					this.doSiteAppIRSrch();
					
					flag = true;
					semmsa002Bean.setRenderedMsgAlert(true);
					//TODO clear save param obj
					this.doClearSiteAppIR();
				} else {
					if(to.get(0).getRetResult() != null){
						if("FAIL".equals(to.get(0).getRetResult().toUpperCase())){
							semmsa002Bean.setDisabledButtonPopupResult(false);
						}else if("FAIL2".equals(to.get(0).getRetResult().toUpperCase())){
							semmsa002Bean.setDisabledButtonPopupResult(true);
						}
						
					}
//					System.out.println("to.get(0).getRetResultMsg() = "+to.get(0).getRetResultMsg());
					if(to.get(0).getRetResultMsg() != null)
						addGeneralMessageError(to.get(0).getRetResultMsg());	// data save fail
					else
						addMessageError("E0001");	// data save fail
	        		semmsa002Bean.setRenderedMsgAlert(true);
				}
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doSiteAppIRIns : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" #### End SEMMSA002Action doSiteAppIRIns ####");
		}
		
		return flag;
	}
	
	public boolean doSiteAppIRUpd(){
		LOG.debug(" #### Start SEMMSA002Action doSiteAppIRUpd ####");
		boolean flag = false;
		semmsa002Bean = getSemmsa002Bean();
		String siteAppId = "";
		String depositType = "";
		SiteAppSP siteAppObj = new SiteAppSP();
		try{
			ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
			List<SiteAppSP> to = null;
			
			siteAppId = semmsa002Bean.getSiteAppObjParam().getSiteAppId();
			depositType = semmsa002Bean.getSiteAppDeptObj().getDepositType();
			
			
				semmsa002Bean.getSiteAppInsuranceObjParam().setSiteAppId(siteAppId);
				semmsa002Bean.getSiteAppInsuranceObjParam().setUserId(getUserLogIn());
				
				if(semmsa002Bean.isNoOwnerAmtFlag()){
					semmsa002Bean.getSiteAppInsuranceObjParam().setNoOwnerAmt("Y");
				}
				
//				semmsa002Bean.getSiteAppDeptCashObj().setExpenseType(semmsa002Bean.getSiteAppDeptObj().getExpenseType());
//				semmsa002Bean.getSiteAppDeptCashObj().setDepositType(semmsa002Bean.getSiteAppDeptObj().getDepositType());
//				semmsa002Bean.getSiteAppDeptCashObj().setVatType(semmsa002Bean.getSiteAppDeptObj().getVatType());
//				semmsa002Bean.getSiteAppDeptCashObj().setServiceId(semmsa002Bean.getSiteAppDeptObj().getServiceId());
//				semmsa002Bean.getSiteAppDeptCashObj().setRemark(semmsa002Bean.getSiteAppDeptObj().getRemark());
//				
//				if(semmsa002Bean.isWithdrawFlag()){
//					semmsa002Bean.getSiteAppDeptCashObj().setWithdrawFlag("Y");
//				}else{
//					semmsa002Bean.getSiteAppDeptCashObj().setWithdrawFlag("");
//				}
//				
				//Debug
				LOG.debug("getInsuranceType : "+semmsa002Bean.getSiteAppInsuranceObjParam().getInsuranceType());
				LOG.debug("getRemark : "+semmsa002Bean.getSiteAppInsuranceObjParam().getRemark());
				LOG.debug("getPlxOldAmt : "+semmsa002Bean.getSiteAppInsuranceObjParam().getPlxOldAmt());
				LOG.debug("getPlxAddAmt : "+semmsa002Bean.getSiteAppInsuranceObjParam().getPlxAddAmt());
				LOG.debug("getPlxAmt : "+semmsa002Bean.getSiteAppInsuranceObjParam().getPlxAmt());
				LOG.debug("getPlxEffectiveDt : "+semmsa002Bean.getSiteAppInsuranceObjParam().getPlxEffectiveDt());
				LOG.debug("getPlxExpireDt : "+semmsa002Bean.getSiteAppInsuranceObjParam().getPlxExpireDt());
				LOG.debug("getOwnerAmt : "+semmsa002Bean.getSiteAppInsuranceObjParam().getOwnerAmt());
				LOG.debug("getOwnerPeriodType : "+semmsa002Bean.getSiteAppInsuranceObjParam().getOwnerPeriodType());
				LOG.debug("getOwnerVatType : "+semmsa002Bean.getSiteAppInsuranceObjParam().getOwnerVatType());
				LOG.debug("getPayPeriodType : "+semmsa002Bean.getSiteAppInsuranceObjParam().getPayPeriodType());
				LOG.debug("getPayPeriod : "+semmsa002Bean.getSiteAppInsuranceObjParam().getPayPeriod());
				LOG.debug("getEffectiveDt : "+semmsa002Bean.getSiteAppInsuranceObjParam().getEffectiveDt());
				LOG.debug("userId : "+semmsa002Bean.getSiteAppInsuranceObjParam().getUserId());
				if(StringUtils.equals("01", semmsa002Bean.getSiteAppObjParam().getReqType()) || semmsa002Bean.getSiteAppInsuranceObjParam().getSiteAppInsuranceId() == null){
					if(semmsa002Bean.getSiteAppInsuranceObj().getSiteAppInsuranceId() != null){
						semmsa002Bean.getSiteAppInsuranceObjParam().setSiteAppInsuranceId(semmsa002Bean.getSiteAppInsuranceObj().getSiteAppInsuranceId());
					}
				}
				
				LOG.debug("getSiteAppInsuranceId : "+semmsa002Bean.getSiteAppInsuranceObjParam().getSiteAppInsuranceId());
				siteAppObj = semmsa002Bean.getSiteAppInsuranceObjParam();
			
			
			
			to = service.siteAppDao_querySPList(EQueryName.SP_MSA002_SITE_APP_IR_UPD.name, siteAppObj);
			
			if (to != null && !to.isEmpty()) {
				String retMsg = to.get(0).getRetResultMsg() == null ? "" : to.get(0).getRetResultMsg().toString();
				
				if (to.get(0).getRetResult().equals("Success")) {

					
					String myMsgArr[];
					if(!retMsg.equals("")){
						myMsgArr = retMsg.split("<BR/>");
						
						for(int i=0; i < myMsgArr.length; i++){
							//addGeneralMessageInfo(myMsgArr[i]);
							//addGeneralMessageWarn(myMsgArr[i]);
							FrontMessageUtils.addMessageWarn(myMsgArr[i]);	// optional
						}
					}
					this.doSiteAppIRSrch();
					
					this.doClearSiteAppIR();
					flag = true;
					semmsa002Bean.setRenderedMsgAlert(true);
				} else {
					if(to.get(0).getRetResult() != null){
						if("FAIL".equals(to.get(0).getRetResult().toUpperCase())){
							semmsa002Bean.setDisabledButtonPopupResult(false);
						}else if("FAIL2".equals(to.get(0).getRetResult().toUpperCase())){
							semmsa002Bean.setDisabledButtonPopupResult(true);
						}
						
					}
//					System.out.println("to.get(0).getRetResultMsg() = "+to.get(0).getRetResultMsg());
					if(to.get(0).getRetResultMsg() != null)
						addGeneralMessageError(to.get(0).getRetResultMsg());	// data save fail
					else
						addMessageError("E0001");	// data save fail
	        		semmsa002Bean.setRenderedMsgAlert(true);
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doSiteAppIRUpd : "+e);
		}
		LOG.debug(" #### End SEMMSA002Action doSiteAppIRUpd ####");
		return flag;
	}
	
	public boolean doInitDetSiteAppIR(){
		LOG.debug(" #### Start SEMMSA002Action doInitDetSiteAppIR #### ");
		semmsa002Bean = getSemmsa002Bean();
		boolean flag = true;
		
		try{
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("Error SEMMSA002Action doInitDetSiteAppIR : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" #### End SEMMSA002Action doInitDetSiteAppIR #### ");
		}
		return flag;
	}
	
	public boolean doDetSiteAppIR(){
		LOG.debug(" #### Start SEMMSA002Action doDetSiteAppIR #### ");
		boolean flag = false;
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteAppSP> to = null;
		SiteAppSP siteAppObj = new SiteAppSP();
		try{
			//TODO get param
			
//			siteAppInsuranceId, :siteAppId, :userId
			
			if(semmsa002Bean.getSiteAppInsuranceObjParam() != null){
				siteAppObj = semmsa002Bean.getSiteAppInsuranceObjParam();
			}
			
			
//			siteAppObj.setSiteAppDepositId(siteAppDepositId);
			siteAppObj.setSiteAppId(semmsa002Bean.getSiteAppObjParam().getSiteAppId());
			siteAppObj.setUserId(getUserLogIn());
			
			to = service.siteAppDao_querySPList(EQueryName.SP_MSA002_SITE_APP_IR_DEL.name, siteAppObj);
			
			if (to != null && !to.isEmpty()) {
				String retMsg = to.get(0).getRetResultMsg() == null ? "" : to.get(0).getRetResultMsg().toString();
				
				if (to.get(0).getRetResult().equals("Success")) {

					
					String myMsgArr[];
					if(!retMsg.equals("")){
						myMsgArr = retMsg.split("<BR/>");
						
						for(int i=0; i < myMsgArr.length; i++){
							//addGeneralMessageInfo(myMsgArr[i]);
							//addGeneralMessageWarn(myMsgArr[i]);
							FrontMessageUtils.addMessageWarn(myMsgArr[i]);	// optional
						}
					}
					
					this.doSiteAppIRSrch();
					
					this.doClearSiteAppIR();
					flag = true;
					semmsa002Bean.setRenderedMsgAlert(true);
				} else {
					if(to.get(0).getRetResult() != null){
						if("FAIL".equals(to.get(0).getRetResult().toUpperCase())){
							semmsa002Bean.setDisabledButtonPopupResult(false);
						}else if("FAIL2".equals(to.get(0).getRetResult().toUpperCase())){
							semmsa002Bean.setDisabledButtonPopupResult(true);
						}
						
					}
//					System.out.println("to.get(0).getRetResultMsg() = "+to.get(0).getRetResultMsg());
					if(to.get(0).getRetResultMsg() != null)
						addGeneralMessageError(to.get(0).getRetResultMsg());	// data save fail
					else
						addMessageError("E0001");	// data save fail
	        		semmsa002Bean.setRenderedMsgAlert(true);
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doDetSiteAppIR : "+e);
		}
		LOG.debug(" #### End SEMMSA002Action doDetSiteAppIR #### ");
		return flag;
	}
	
	public boolean doClearSiteAppIR(){
		LOG.debug(" #### Start SEMMSA002Action doClearSiteAppIR ####");
		semmsa002Bean = getSemmsa002Bean();
		try{
			semmsa002Bean.setSiteAppInsuranceObjParam(new SiteAppSP());
			semmsa002Bean.setNoOwnerAmtFlag(false);
			semmsa002Bean.setInsuranceEditFlag(false);
			//set Default Insurance No VAT
			semmsa002Bean.getSiteAppInsuranceObjParam().setOwnerVatType("04");
			setSemmsa002Bean(semmsa002Bean);
			this.renderPayPeriodTypeIns();
			this.renderInsuranceType();
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doClearSiteAppIR : "+e);
		}
		LOG.debug(" #### End SEMMSA002Action doClearSiteAppIR ####");
		return true;
	}
	
	private boolean doInitEditIR(){
		LOG.debug(" #### Start SEMMSA002Action doInitEditIR ####");
		semmsa002Bean = getSemmsa002Bean();
		try{
			SiteAppSP irObj = new SiteAppSP();
			
			if(semmsa002Bean.isInsuranceEditFlag()){
				irObj = semmsa002Bean.getSiteAppInsuranceObj();
				if(irObj != null){
					LOG.debug("irObj.getSiteAppInsuranceId() : "+irObj.getSiteAppInsuranceId());
					LOG.debug("irObj.getInsuranceType() : "+irObj.getInsuranceType());
					LOG.debug("irObj.getPlxAmt() : "+irObj.getPlxAmt());
					LOG.debug("irObj.getOwnerAmtt() : "+irObj.getOwnerAmt());
//					getFacesUtils().setRequestMapValue("ownerPayPeriodType", irObj.getInsuranceType());
					
					if(irObj.getOwnerVatType() == null || StringUtils.equals("", irObj.getOwnerVatType())){
						irObj.setOwnerVatType("04");
					}
					semmsa002Bean.setSiteAppInsuranceObjParam(irObj);
					setSemmsa002Bean(semmsa002Bean);
					this.renderPayPeriodTypeEdit();
					this.renderInsuranceTypeEdit();
				}
			}else{
				this.doClearSiteAppIR();
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doInitEditIR : "+e);
		}finally{
			LOG.debug(" #### End SEMMSA002Action doInitEditIR ####");	
			setSemmsa002Bean(semmsa002Bean);
		}
		return true;
	}
	
	public boolean renderPayPeriodTypeEdit(){
		LOG.debug(" #### Start SEMMSA002Action renderPayPeriodTypeEdit ####");	
		boolean flag = false;
		semmsa002Bean = getSemmsa002Bean();
		String ownerPayPeriodType = semmsa002Bean.getSiteAppInsuranceObj().getOwnerPayPeriodType();
		
		try{
			if(StringUtils.equals("01", ownerPayPeriodType)){
				semmsa002Bean.setPayPeriodTypeIns01(ownerPayPeriodType);
				semmsa002Bean.setPayPeriodTypeIns02("");
				semmsa002Bean.setPayPeriodTypeIns03("");
				semmsa002Bean.setPayPeriodTypeIns04("");
				semmsa002Bean.setPayPeriodTypeIns05("");
				semmsa002Bean.setPayPeriodTypeIns06("");
				semmsa002Bean.setPayPeriodTypeIns07("");
				semmsa002Bean.setPayPeriodIns03(null);
				semmsa002Bean.setPayPeriodIns04(null);
				semmsa002Bean.setDisabledPayPeriodIns03(true);
				semmsa002Bean.setDisabledPayPeriodIns04(true);
			}else if(StringUtils.equals("02", ownerPayPeriodType)){
				semmsa002Bean.setPayPeriodTypeIns02(ownerPayPeriodType);
				semmsa002Bean.setPayPeriodTypeIns01("");
				semmsa002Bean.setPayPeriodTypeIns03("");
				semmsa002Bean.setPayPeriodTypeIns04("");
				semmsa002Bean.setPayPeriodTypeIns05("");
				semmsa002Bean.setPayPeriodTypeIns06("");
				semmsa002Bean.setPayPeriodTypeIns07("");
				semmsa002Bean.setPayPeriodIns03(null);
				semmsa002Bean.setPayPeriodIns04(null);
				semmsa002Bean.setDisabledPayPeriodIns03(true);
				semmsa002Bean.setDisabledPayPeriodIns04(true);
			}else if(StringUtils.equals("03", ownerPayPeriodType)){
				semmsa002Bean.setPayPeriodTypeIns03(ownerPayPeriodType);
				LOG.debug("semmsa002Bean.getSiteAppInsuranceObj().getOwnerPayPeriod() : "+semmsa002Bean.getSiteAppInsuranceObj().getOwnerPayPeriod());
				if(semmsa002Bean.getSiteAppInsuranceObj().getOwnerPayPeriod() != null){
					semmsa002Bean.setPayPeriodIns03(semmsa002Bean.getSiteAppInsuranceObj().getOwnerPayPeriod());
					semmsa002Bean.getSiteAppInsuranceObjParam().setOwnerPayPeriod(semmsa002Bean.getSiteAppInsuranceObj().getOwnerPayPeriod());
				}
				semmsa002Bean.setPayPeriodTypeIns01("");
				semmsa002Bean.setPayPeriodTypeIns02("");
				semmsa002Bean.setPayPeriodTypeIns04("");
				semmsa002Bean.setPayPeriodTypeIns05("");
				semmsa002Bean.setPayPeriodTypeIns06("");
				semmsa002Bean.setPayPeriodTypeIns07("");
				semmsa002Bean.setPayPeriodIns04(null);
				semmsa002Bean.setDisabledPayPeriodIns03(false);
				semmsa002Bean.setDisabledPayPeriodIns04(true);
			}else if(StringUtils.equals("04", ownerPayPeriodType)){
				semmsa002Bean.setPayPeriodTypeIns04(ownerPayPeriodType);
				if(semmsa002Bean.getSiteAppInsuranceObj().getOwnerPayPeriod() != null){
					semmsa002Bean.setPayPeriodIns04(semmsa002Bean.getSiteAppInsuranceObj().getOwnerPayPeriod());
					semmsa002Bean.getSiteAppInsuranceObjParam().setOwnerPayPeriod(semmsa002Bean.getSiteAppInsuranceObj().getOwnerPayPeriod());
				}
				semmsa002Bean.setPayPeriodTypeIns01("");
				semmsa002Bean.setPayPeriodTypeIns02("");
				semmsa002Bean.setPayPeriodTypeIns03("");
				semmsa002Bean.setPayPeriodTypeIns05("");
				semmsa002Bean.setPayPeriodTypeIns06("");
				semmsa002Bean.setPayPeriodTypeIns07("");
				semmsa002Bean.setPayPeriodIns03(null);
				semmsa002Bean.setDisabledPayPeriodIns03(true);
				semmsa002Bean.setDisabledPayPeriodIns04(false);
			}else if(StringUtils.equals("05", ownerPayPeriodType)){
				semmsa002Bean.setPayPeriodTypeIns05(ownerPayPeriodType);
				semmsa002Bean.setPayPeriodTypeIns01("");
				semmsa002Bean.setPayPeriodTypeIns02("");
				semmsa002Bean.setPayPeriodTypeIns03("");
				semmsa002Bean.setPayPeriodTypeIns04("");
				semmsa002Bean.setPayPeriodTypeIns06("");
				semmsa002Bean.setPayPeriodTypeIns07("");
				semmsa002Bean.setPayPeriodIns03(null);
				semmsa002Bean.setDisabledPayPeriodIns03(true);
				semmsa002Bean.setDisabledPayPeriodIns04(true);
			}else if(StringUtils.equals("06", ownerPayPeriodType)){
				semmsa002Bean.setPayPeriodTypeIns06(ownerPayPeriodType);
				semmsa002Bean.setPayPeriodTypeIns01("");
				semmsa002Bean.setPayPeriodTypeIns02("");
				semmsa002Bean.setPayPeriodTypeIns03("");
				semmsa002Bean.setPayPeriodTypeIns04("");
				semmsa002Bean.setPayPeriodTypeIns05("");
				semmsa002Bean.setPayPeriodTypeIns07("");
				semmsa002Bean.setPayPeriodIns03(null);
				semmsa002Bean.setDisabledPayPeriodIns03(true);
				semmsa002Bean.setDisabledPayPeriodIns04(true);
			}else if(StringUtils.equals("07", ownerPayPeriodType)){
				semmsa002Bean.setPayPeriodTypeIns07(ownerPayPeriodType);
				semmsa002Bean.setPayPeriodTypeIns01("");
				semmsa002Bean.setPayPeriodTypeIns02("");
				semmsa002Bean.setPayPeriodTypeIns03("");
				semmsa002Bean.setPayPeriodTypeIns04("");
				semmsa002Bean.setPayPeriodTypeIns05("");
				semmsa002Bean.setPayPeriodTypeIns06("");
				semmsa002Bean.setPayPeriodIns03(null);
				semmsa002Bean.setDisabledPayPeriodIns03(true);
				semmsa002Bean.setDisabledPayPeriodIns04(true);
			}else {
				semmsa002Bean.setPayPeriodTypeIns01("");
				semmsa002Bean.setPayPeriodTypeIns02("");
				semmsa002Bean.setPayPeriodTypeIns03("");
				semmsa002Bean.setPayPeriodTypeIns04("");
				semmsa002Bean.setPayPeriodTypeIns05("");
				semmsa002Bean.setPayPeriodTypeIns06("");
				semmsa002Bean.setPayPeriodTypeIns07("");
				semmsa002Bean.setPayPeriodIns03(null);
				semmsa002Bean.setPayPeriodIns04(null);
				semmsa002Bean.setDisabledPayPeriodIns03(true);
				semmsa002Bean.setDisabledPayPeriodIns04(true);
			}
			semmsa002Bean.getSiteAppInsuranceObjParam().setOwnerPayPeriodType(ownerPayPeriodType);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action renderPayPeriodTypeEdit : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" #### End SEMMSA002Action renderPayPeriodTypeEdit ####");	
		}
		
		return flag;
	}
	
	public boolean renderInsuranceTypeEdit(){
		boolean flag = true;
		semmsa002Bean = getSemmsa002Bean();
		try{
			String insuranceType = semmsa002Bean.getSiteAppInsuranceObjParam().getInsuranceType();
			if(insuranceType != null){
				if(insuranceType.equals("04")){
					semmsa002Bean.setRenderedPLX(true);
					semmsa002Bean.setRenderedInsuranceOwner(false);
				}else if(insuranceType.equals("02") || insuranceType.equals("03")){
					semmsa002Bean.setRenderedInsuranceOwner(true);
					semmsa002Bean.setRenderedPLX(false);
				}else{
					semmsa002Bean.setRenderedInsuranceOwner(false);
					semmsa002Bean.setRenderedPLX(false);
				}
			}else{
				semmsa002Bean.setRenderedInsuranceOwner(false);
				semmsa002Bean.setRenderedPLX(false);
			}
			
			String irHeaderLabel;
			semmsa002Bean.setIrHeaderLabel("");
			for(int i = 0;i<semmsa002Bean.getInsuranceTypeList().size();i++){
				if(StringUtils.equals(insuranceType, (String)semmsa002Bean.getInsuranceTypeList().get(i).getValue())){
					irHeaderLabel = (String)semmsa002Bean.getInsuranceTypeList().get(i).getLabel();
					semmsa002Bean.setIrHeaderLabel(irHeaderLabel);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			setSemmsa002Bean(semmsa002Bean);
		}
		
		return flag;
	}
	
	public void doSelectELUseCond(){
		LOG.debug(" #### Start SEMMSA002Action doSelectELUseCond ####");	
		semmsa002Bean = getSemmsa002Bean();
		try{
			LOG.debug("semmsa002Bean.getSiteAppELObjParam().getElCondType() : "+semmsa002Bean.getSiteAppELObjParam().getElCondType());
			if(StringUtils.equals("00", semmsa002Bean.getSiteAppELObjParam().getElCondType())){
				
				semmsa002Bean.getSiteAppELObjParam().setElCondSubType("");
				semmsa002Bean.getSiteAppELObjParam().setElUnitPrice(null);
				semmsa002Bean.setChkNoUtilPrice(false);
				semmsa002Bean.setElPayPeriodType01("01");
				semmsa002Bean.getSiteAppELObjParam().setElVatType("");
				
				//semmsa002Bean.set semmsa002Bean.getSiteAppObjParam().effectiveDt
				
				
			}else{
				semmsa002Bean.setElPayPeriodType01("01");
				semmsa002Bean.getSiteAppELObjParam().setElVatType("");
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error(" #### ERROR SEMMSA002Action doSelectELUseCond : "+e);	
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" #### End SEMMSA002Action doSelectELUseCond ####");	
		}
	}
	
	public boolean doExportAddress(){
		LOG.debug(" #### Start SEMMSA002Action doExportAddress ####");
		String clearBatch = (String)getFacesUtils().getRequestParameter("clearBatch");
		boolean flag = false;
		LOG.debug("clearBatch = "+clearBatch);
		//Check Batch
		
			// get rental_clr_rec_id List
			//getListSiteApproveId();
			semmsa002Bean = getSemmsa002Bean();
			semmsa002Bean.setRenderedMsgExpMail(false);
			//flag check export
//			semmsa002Bean.setDisplayBtn(false);
//			semmsa002Bean.setRedirectFlag(false);	
			setSemmsa002Bean(semmsa002Bean);
			SiteAcqSP siteAcqSP = null;
			// upd data from store procedure
//			Msi001UpdOutDt msi001UpdOutDt = new Msi001UpdOutDt();
//			msi001UpdOutDt.setSiteApproveIdList(getSemmsa003Bean().getSiteApproveIdStr());
//			msi001UpdOutDt.setCurrentUser(getUserLogIn());
//			semmsi001Bean.setMrtGetRunningNo(new MrtGetRunningNo());
			ISiteApproveService service = (ISiteApproveService)getBean("siteApproveService");
			
			String batchNo ="";
			
			try {
				
				

					
					DateFormat df =  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 

						semmsa002Bean = getSemmsa002Bean();
						
//						batchNo = semmsa002Bean.getBatchNo();
						short line = 0;
				
						
						DocumentExportManager<SiteAcqSP> docManager = new DocumentExportManager<SiteAcqSP>(SiteAcqSP.class, EnumDocumentType.XLS);
		
							docManager.setRowStart(line);
		//				
						EnumDocStyleDomain	titleStyle	= new EnumDocStyleDomain(EnumDocStyle.TITLE);
		//				EnumDocStyleDomain field = docManager.getStyle("normalField");
						EnumDocStyleDomain headerStyle = new EnumDocStyleDomain(EnumDocStyle.HEADER);
						EnumDocStyleDomain normalStyle = new EnumDocStyleDomain(EnumDocStyle.CELL_NORMAL_CENTER);
						
						RowDomain row0 = new RowDomain(0,true);	
						row0.setCell(new CellDomain(0,15, null, String.class, titleStyle, msg("export.header.mailAddr"),null));
						
						
						
//						RowDomain row1 = new RowDomain(1,true);	
//						row1.setCell(new CellDomain(0,15, null, String.class, titleStyle, msg("export.col.paymentBatchNo")+batchNo,null));
						
						
						RowDomain row1 = new RowDomain(1,true);	
						row1.setCell(new CellDomain(0, null, String.class,headerStyle, msg("message.contractNo"),-1,3800));
						row1.setCell(new CellDomain(1, null, String.class,headerStyle, "Name",-1,7500));
						row1.setCell(new CellDomain(2, null, String.class,headerStyle, "Address",-1,25000));
						row1.setCell(new CellDomain(3, null, String.class,normalStyle, "",-1,100));
//						row2.setCell(new CellDomain(3, null, String.class,headerStyle, msg("export.col.reqType"),-1,2600));
//						row2.setCell(new CellDomain(4, null, String.class,headerStyle, msg("export.col.title"),-1,2800));
//						row2.setCell(new CellDomain(5, null, String.class,headerStyle, msg("export.col.docNo"),-1,2500));
//						row2.setCell(new CellDomain(6, null, String.class,headerStyle, msg("export.col.contractNo"),-1,2300));
//						row2.setCell(new CellDomain(7, null, String.class,headerStyle, msg("export.col.locatioId"),-1,2500));
//						row2.setCell(new CellDomain(8, null, String.class,headerStyle, msg("export.col.locatioName"),-1,3000));
//						row2.setCell(new CellDomain(9, null, String.class,headerStyle, msg("export.col.siteDetail"),-1,3200));
//						row2.setCell(new CellDomain(10, null, String.class,headerStyle, msg("export.col.locationZone"),-1,1700));
//						row2.setCell(new CellDomain(11, null, String.class,headerStyle, msg("export.col.effectiveDt"),-1,2500));
//						row2.setCell(new CellDomain(12, null, String.class,headerStyle, msg("export.col.expireDt"),-1,2500));
//						row2.setCell(new CellDomain(13, null, String.class,headerStyle, msg("export.col.networkStatus"),-1,2500));
//						row2.setCell(new CellDomain(14, null, String.class,headerStyle, msg("export.col.onwer"),-1,2500));
//						row2.setCell(new CellDomain(15, null, String.class,headerStyle, msg("export.col.reqOfficer"),-1,2500));
						
						//CellDomain(int no, String name, Class<?> clazz, EnumDocStyleDomain style, Object value, int rowNoTo,Integer width)
						//List<WrapperBeanObject<SiteApproveDisplaySP>> detailList = new ArrayList<WrapperBeanObject<SiteApproveDisplaySP>>();
						//detailList = getSemmsi001Bean().getSiteApproveList();
						List<SiteAppMailSP> expObjList = new ArrayList<SiteAppMailSP>();
						SiteAppMailSP mailAddrTemp = new SiteAppMailSP();
//						expTemp.setP_batch_no(batchNo);
//						detailList = service.querySPList(EQueryName.SP_MSA003_EXP.name, expTemp );
						
						this.doGetMailAddrExport();
					
						if(semmsa002Bean.getSiteAppMailExpList() != null && semmsa002Bean.getSiteAppMailExpList().size() > 0){
							expObjList = semmsa002Bean.getSiteAppMailExpList();
							
							int no = 3;
							int noRow = 1;
							docManager.putDetailRow(row0);
							docManager.putDetailRow(row1);
//							docManager.putDetailRow(row2);
							//docManager.setMargin(0.05, 0.05, 0.5, 0.05);
							
							
							for(int i=0; i<expObjList.size(); i++){
								SiteAppMailSP detail = new SiteAppMailSP();
								//detail = detailList.get(i);
								detail = (SiteAppMailSP)expObjList.get(i);
								
								//Set Format Date dd/mm/yyyy to Excel
							
								//if(detail.isCheckBox()){
									 	RowDomain rowData = new RowDomain(no,true);	
									 	rowData.setCell(new CellDomain(0, null, String.class,normalStyle, semmsa002Bean.getSiteAppObjParam().getContractNo(),-1,3800));
									 	rowData.setCell(new CellDomain(1, null, String.class,normalStyle, detail.getMailName(),-1,7500));
									 	rowData.setCell(new CellDomain(2, null, String.class,normalStyle, detail.getFullAddress(),-1,25000));
									 	rowData.setCell(new CellDomain(3, null, String.class,normalStyle, "",-1,100));
//									 	rowData.setCell(new CellDomain(4, null, String.class,normalStyle, siteAcqSP.getP_title(),-1));
//									 	rowData.setCell(new CellDomain(5, null, String.class,normalStyle, siteAcqSP.getDocNo(),-1));
//									 	rowData.setCell(new CellDomain(6, null, String.class,normalStyle, siteAcqSP.getP_contract_no(),-1));
//									 	rowData.setCell(new CellDomain(7, null, String.class,normalStyle, siteAcqSP.getP_location_id(),-1));
//									 	rowData.setCell(new CellDomain(8, null, String.class,normalStyle, siteAcqSP.getP_location_name(),-1));
//									 	rowData.setCell(new CellDomain(9, null, String.class,normalStyle, siteAcqSP.getSiteDetail(),-1,3200));
//									 	rowData.setCell(new CellDomain(10, null, String.class,normalStyle, siteAcqSP.getP_location_zone(),-1));
//									 	rowData.setCell(new CellDomain(11, null, String.class,normalStyle, siteAcqSP.getEffDateStr(),-1));
//									 	rowData.setCell(new CellDomain(12, null, String.class,normalStyle, siteAcqSP.getExpDateStr(),-1));
//									 	rowData.setCell(new CellDomain(13, null, String.class,normalStyle, siteAcqSP.getNetworkStatus(),-1));
//									 	rowData.setCell(new CellDomain(14, null, String.class,normalStyle, siteAcqSP.getOwner(),-1));
//									 	rowData.setCell(new CellDomain(15, null, String.class,normalStyle, siteAcqSP.getReqOfficer(),-1));
										docManager.putDetailRow(rowData);
										no++;
										noRow = noRow+1;
//								
							}
							
				
							docManager.setModule("SITE_ACQ");
							docManager.setPrintPageLandScape(true);
							docManager.getObjectFromDocument();
							docManager.exportServletFile();
				           
								
							flag = true;
						}else{
							flag = false;
							addMessageError("M0004");
							semmsa002Bean.setRenderedMsgExpMail(true);
						}
						
				
				
			} catch(NullPointerException ne){
				flag = false;
				LOG.error("#### ERROR SEMMSA002Action doExportAddress : "+ne);
			}catch(Exception e){
				flag = false;
				LOG.error("#### ERROR SEMMSA002Action doExportAddress : "+e);
			}finally{
				setSemmsa002Bean(semmsa002Bean);
				LOG.debug(" #### End SEMMSA002Action doExportAddress ####");
			}
			return flag;
	}
	
	public void doGetMailAddrExport(){
		LOG.debug(" #### Start SEMMSA002Action doGetMailAddrExport #####");
		semmsa002Bean = getSemmsa002Bean();
		List<SiteAppMailSP> mailObjList = new ArrayList<SiteAppMailSP>();
		semmsa002Bean.setSiteAppMailExpList(new ArrayList<SiteAppMailSP>());
		SiteAppMailSP objParam = new SiteAppMailSP(); 
		try{
//			String strSiteAppId = semmsa002Bean.getSiteAppObjParam().getSiteAppId() == null ? "" : semmsa002Bean.getSiteAppObjParam().getSiteAppId();
			
			String mailAddrIdTmp = semmsa002Bean.getMailAddrIdTmp() == null ? "" : semmsa002Bean.getMailAddrIdTmp();
			LOG.info("ooo mailAddrIdTmp: " + mailAddrIdTmp);

			ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService");

//			semmsa002Bean.getSiteAppObjParam().setUserLogin(getUserLogIn());
//			semmsa002Bean.getSiteAppObjParam().setUpdateBy(getUserLogIn());

//			this.doSetCheckBoxEntity();
			
			if(StringUtils.isNotEmpty( mailAddrIdTmp)){
				objParam.setMailAddrId(mailAddrIdTmp);
			}

			List<SiteAppMailSP> to = service.siteAppDao_querySPList(EQueryName.SP_MSA002_MAIL_EXPORT.name, objParam);
			
			if (to != null && !to.isEmpty() && to.size() > 0) {
				semmsa002Bean.setSiteAppMailExpList(to);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error(" #### Error SEMMSA002Action doGetMailAddrExport : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" #### End SEMMSA002Action doGetMailAddrExport #####");
		}
	}
	
	public void doSiteAppDocSrch(String mode){
		LOG.debug(" #### Start SEMMSA002Action doSiteAppDocSrch ####");
		semmsa002Bean = getSemmsa002Bean();
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteAppSP> to = null;
		try{
			LOG.debug("doSiteAppDocSrch getSiteAppId :"+semmsa002Bean.getSiteAppObjParam().getSiteAppId());
			LOG.debug("doSiteAppDocSrch getContractNo :"+semmsa002Bean.getSiteAppObjParam().getContractNo());
			LOG.debug("doSiteAppDocSrch mode : "+mode);
			SiteAppSP siteAppObj = new SiteAppSP();
			siteAppObj.setSiteAppId(semmsa002Bean.getSiteAppObjParam().getSiteAppId());
			siteAppObj.setContractNo(semmsa002Bean.getSiteAppObjParam().getContractNo());
			siteAppObj.setMode(mode);
			to = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA002_DOC_SRCH.name, siteAppObj);
			LOG.debug("size [" + to.size() + "]");
			
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsa002Bean.setRenderedMsgDataNotFound(true);
				if(StringUtils.equals("E", mode)){
					semmsa002Bean.setSiteAppdocExtList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				}else if(StringUtils.equals("H", mode)){
					semmsa002Bean.setSiteAppdocHistList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				}
				
			}
			
			if(to != null && to.size() > 0){
//				flag = true;
				semmsa002Bean.setRenderedMsgDataNotFound(false);
				
				if(StringUtils.equals("E", mode)){
					semmsa002Bean.setSiteAppdocExtList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				}else if(StringUtils.equals("H", mode)){
					semmsa002Bean.setSiteAppdocHistList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				}

				
				for (int i = 0; i < to.size(); i++) {
					SiteAppSP siteAcq = (SiteAppSP) to.get(i);
					WrapperBeanObject<SiteAppSP> tmpWrapperBean = new WrapperBeanObject<SiteAppSP>();
					
//					if(siteAcq.getNoExpFlag() != null){
//						if(StringUtils.equals("Y", siteAcq.getNoExpFlag().toUpperCase())){
//							semmsa002Bean.setNoExpFlag(true);
//						}else{
//							semmsa002Bean.setNoExpFlag(false);
//						}
//					}else{
//						semmsa002Bean.setNoExpFlag(false);
//					}
					
					if(siteAcq.getEffectiveDt() != null){
						siteAcq.setEffectiveDtStr(convertYearENtoTHStr(siteAcq.getEffectiveDt()));
					}
					
					if(siteAcq.getExpireDt() != null){
						siteAcq.setExpireDtStr(convertYearENtoTHStr(siteAcq.getExpireDt()));
					}
					
					if(siteAcq.getLegalDocEffectiveDt() != null){
						siteAcq.setLegalDocEffectiveDtStr(convertYearENtoTHStr(siteAcq.getLegalDocEffectiveDt()));
					}

//					if(siteAcq.getEndDt() != null){
//						siteAcq.setEndDtStr(convertYearENtoTHStr(siteAcq.getEndDt()));
//					}
//					
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					tmpWrapperBean.setDataObj(siteAcq);
					
					if(siteAcq != null){
						if(StringUtils.equals("E", mode)){
							semmsa002Bean.getSiteAppdocExtList().add(tmpWrapperBean);
						}else if(StringUtils.equals("H", mode)){
							semmsa002Bean.getSiteAppdocHistList().add(tmpWrapperBean);
						}
//						semmsa002Bean.getSiteAppELCondExistingList().add(tmpWrapperBean);
						
					}
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doSiteAppDocSrch : "+e);
		}finally{
			LOG.debug(" #### End SEMMSA002Action doSiteAppDocSrch ####");
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	
	public void doSetDefaultRental(){
		LOG.debug(" #### start SEMMSA002Action doSetDefaultRental ####");
		semmsa002Bean = getSemmsa002Bean();
		try{
			  // add 13/02/2023
			 semmsa002Bean.setDisabledExpenseDesc(true);
			 
			if(StringUtils.equals("01", semmsa002Bean.getSiteAppRentObjParam().getExpenseType())){
				semmsa002Bean.getSiteAppRentObjParam().setRentWhtType("02");
				semmsa002Bean.getSiteAppRentObjParam().setRentVatType("04");
				semmsa002Bean.getSiteAppRentObjParam().setExpenseDesc(null);
			}else if(StringUtils.equals("02", semmsa002Bean.getSiteAppRentObjParam().getExpenseType())){
				semmsa002Bean.getSiteAppRentObjParam().setRentWhtType("01");
				semmsa002Bean.getSiteAppRentObjParam().setRentVatType("02");
				semmsa002Bean.getSiteAppRentObjParam().setExpenseDesc(null);
			}else{
				semmsa002Bean.getSiteAppRentObjParam().setRentWhtType("03");
				semmsa002Bean.getSiteAppRentObjParam().setRentVatType("04");
				
				// add 13/02/2023
			   if (StringUtils.equals("03", semmsa002Bean.getSiteAppRentObjParam().getExpenseType())) {
				   semmsa002Bean.setDisabledExpenseDesc(false);
			   }
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("Error SEMMSA002Action doSetDefaultRental : "+e);
		}finally{
			LOG.debug(" #### End SEMMSA002Action doSetDefaultRental ####");
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	
	public void doSetDefaultRentPayPeriod(){
		LOG.debug(" #### Start SEMMSA002Action doSetDefaultRentPayPeriod ####");
		semmsa002Bean = getSemmsa002Bean();
		try{
			if(semmsa002Bean.getSiteAppRentObjParam().getRentPeriodType() != null){
				LOG.debug("semmsa002Bean.getSiteAppRentObjParam().getRentPeriodType() : "+semmsa002Bean.getSiteAppRentObjParam().getRentPeriodType());
				if(StringUtils.equals("M", semmsa002Bean.getSiteAppRentObjParam().getRentPeriodType())){
					semmsa002Bean.getSiteAppRentObjParam().setRentPaymentPeriod("01");
				}else if(StringUtils.equals("Y", semmsa002Bean.getSiteAppRentObjParam().getRentPeriodType())){
					semmsa002Bean.getSiteAppRentObjParam().setRentPaymentPeriod("02");
				}else if(StringUtils.equals("O", semmsa002Bean.getSiteAppRentObjParam().getRentPeriodType())){
					semmsa002Bean.getSiteAppRentObjParam().setRentPaymentPeriod("05");
				}
				
				
				this.initUpdateRentCond();
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("#####  Error SEMMSA002Action doSetDefaultRentPayPeriod : "+e);
		}finally{
			LOG.debug(" #### End SEMMSA002Action doSetDefaultRentPayPeriod ####");
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	
	public void doSetDefaultEl(){
		LOG.debug(" #### start SEMMSA002Action doSetDefaultEl ####");
		semmsa002Bean = getSemmsa002Bean();
		try{
			if(StringUtils.equals("01", semmsa002Bean.getSiteAppELObjParam().getElCondSubType())){

				//set default El PeriodStartDt
				if(semmsa002Bean.getSiteAppObjParam().getEffectiveDt() != null)
					semmsa002Bean.getSiteAppELObjParam().setPeriodStartDt(semmsa002Bean.getSiteAppObjParam().getEffectiveDt());
					
				//set default El setPeriodEndDt
				if(semmsa002Bean.getSiteAppObjParam().getExpireDt() != null)
					semmsa002Bean.getSiteAppELObjParam().setPeriodEndDt(semmsa002Bean.getSiteAppObjParam().getExpireDt());
				
					semmsa002Bean.getSiteAppELObjParam().setElVatType("04");
					
					semmsa002Bean.getSiteAppELObjParam().setWhtType("03");
				
			}else if(StringUtils.equals("02", semmsa002Bean.getSiteAppELObjParam().getElCondSubType())){
				semmsa002Bean.getSiteAppELObjParam().setElUnitPrice(null);
				//set default El PeriodStartDt
				if(semmsa002Bean.getSiteAppObjParam().getEffectiveDt() != null)
					semmsa002Bean.getSiteAppELObjParam().setPeriodStartDt(semmsa002Bean.getSiteAppObjParam().getEffectiveDt());
					
				//set default El setPeriodEndDt
				if(semmsa002Bean.getSiteAppObjParam().getExpireDt() != null)
					semmsa002Bean.getSiteAppELObjParam().setPeriodEndDt(semmsa002Bean.getSiteAppObjParam().getExpireDt());
//				semmsa002Bean.getSiteAppRentObjParam().setRentWhtType("03");
				
				semmsa002Bean.getSiteAppELObjParam().setElVatType("04");
				semmsa002Bean.getSiteAppELObjParam().setWhtType("03");
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("Error SEMMSA002Action doSetDefaultEl : "+e);
		}finally{
			LOG.debug(" #### End SEMMSA002Action doSetDefaultEl ####");
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	
	public void doSetDefaultElPayPeriod(){
		LOG.debug(" #### Start SEMMSA002Action doSetDefaultElPayPeriod ####");
		semmsa002Bean = getSemmsa002Bean();
		try{
			if(semmsa002Bean.getSiteAppELObjParam().getTakeAllPeriodType() != null){
				LOG.debug("semmsa002Bean.getSiteAppELObjParam().getTakeAllPeriodType() : "+semmsa002Bean.getSiteAppELObjParam().getTakeAllPeriodType());
				if(StringUtils.equals("M", semmsa002Bean.getSiteAppELObjParam().getTakeAllPeriodType())){
					semmsa002Bean.getSiteAppELObjParam().setPayPeriodType("01");
				}else if(StringUtils.equals("Y", semmsa002Bean.getSiteAppELObjParam().getTakeAllPeriodType())){
					semmsa002Bean.getSiteAppELObjParam().setPayPeriodType("02");
				}else if(StringUtils.equals("O", semmsa002Bean.getSiteAppELObjParam().getTakeAllPeriodType())){
					semmsa002Bean.getSiteAppELObjParam().setPayPeriodType("05");
				}
				
				
				this.initElUpdateCond();
				LOG.debug("semmsa002Bean.getSiteAppELObjParam().getTakeAllPeriodType() : "+semmsa002Bean.getSiteAppELObjParam().getTakeAllPeriodType());
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("#####  Error SEMMSA002Action doSetDefaultElPayPeriod : "+e);
		}finally{
			LOG.debug(" #### End SEMMSA002Action doSetDefaultElPayPeriod ####");
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	
	public void doSetDefaultIRPayPeriod(){
		LOG.debug(" #### Start SEMMSA002Action doSetDefaultIRPayPeriod ####");
		semmsa002Bean = getSemmsa002Bean();
		try{
			if(semmsa002Bean.getSiteAppInsuranceObjParam().getOwnerPeriodType() != null){
				LOG.debug("semmsa002Bean.getSiteAppInsuranceObjParam().getOwnerPeriodType() : "+semmsa002Bean.getSiteAppInsuranceObjParam().getOwnerPeriodType());
				if(StringUtils.equals("M", semmsa002Bean.getSiteAppInsuranceObjParam().getOwnerPeriodType())){
					semmsa002Bean.getSiteAppInsuranceObjParam().setOwnerPayPeriodType("01");
				}else if(StringUtils.equals("Y", semmsa002Bean.getSiteAppInsuranceObjParam().getOwnerPeriodType())){
					semmsa002Bean.getSiteAppInsuranceObjParam().setOwnerPayPeriodType("02");
				}else if(StringUtils.equals("O", semmsa002Bean.getSiteAppInsuranceObjParam().getOwnerPeriodType())){
					semmsa002Bean.getSiteAppInsuranceObjParam().setOwnerPayPeriodType("05");
				}
				
				
				this.renderPayPeriodTypeDefault();
				LOG.debug("semmsa002Bean.getSiteAppInsuranceObjParam().getOwnerPeriodType() : "+semmsa002Bean.getSiteAppInsuranceObjParam().getOwnerPeriodType());
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("#####  Error SEMMSA002Action doSetDefaultIRPayPeriod : "+e);
		}finally{
			LOG.debug(" #### End SEMMSA002Action doSetDefaultIRPayPeriod ####");
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	
	public boolean renderPayPeriodTypeDefault(){
		LOG.debug(" #### Start SEMMSA002Action renderPayPeriodTypeDefault ####");	
		boolean flag = false;
		semmsa002Bean = getSemmsa002Bean();
		String ownerPayPeriodType = semmsa002Bean.getSiteAppInsuranceObjParam().getOwnerPayPeriodType();
		
		try{
			if(StringUtils.equals("01", ownerPayPeriodType)){
				semmsa002Bean.setPayPeriodTypeIns01(ownerPayPeriodType);
				semmsa002Bean.setPayPeriodTypeIns02("");
				semmsa002Bean.setPayPeriodTypeIns03("");
				semmsa002Bean.setPayPeriodTypeIns04("");
				semmsa002Bean.setPayPeriodTypeIns05("");
				semmsa002Bean.setPayPeriodTypeIns06("");
				semmsa002Bean.setPayPeriodTypeIns07("");
				semmsa002Bean.setPayPeriodIns03(null);
				semmsa002Bean.setPayPeriodIns04(null);
				semmsa002Bean.setDisabledPayPeriodIns03(true);
				semmsa002Bean.setDisabledPayPeriodIns04(true);
			}else if(StringUtils.equals("02", ownerPayPeriodType)){
				semmsa002Bean.setPayPeriodTypeIns02(ownerPayPeriodType);
				semmsa002Bean.setPayPeriodTypeIns01("");
				semmsa002Bean.setPayPeriodTypeIns03("");
				semmsa002Bean.setPayPeriodTypeIns04("");
				semmsa002Bean.setPayPeriodTypeIns05("");
				semmsa002Bean.setPayPeriodTypeIns06("");
				semmsa002Bean.setPayPeriodTypeIns07("");
				semmsa002Bean.setPayPeriodIns03(null);
				semmsa002Bean.setPayPeriodIns04(null);
				semmsa002Bean.setDisabledPayPeriodIns03(true);
				semmsa002Bean.setDisabledPayPeriodIns04(true);
			}else if(StringUtils.equals("03", ownerPayPeriodType)){
				semmsa002Bean.setPayPeriodTypeIns03(ownerPayPeriodType);
				LOG.debug("semmsa002Bean.getSiteAppInsuranceObj().getOwnerPayPeriod() : "+semmsa002Bean.getSiteAppInsuranceObjParam().getOwnerPayPeriod());
				if(semmsa002Bean.getSiteAppInsuranceObjParam().getOwnerPayPeriod() != null){
					semmsa002Bean.setPayPeriodIns03(semmsa002Bean.getSiteAppInsuranceObjParam().getOwnerPayPeriod());
//					semmsa002Bean.getSiteAppInsuranceObjParam().setOwnerPayPeriod(semmsa002Bean.getSiteAppInsuranceObjParam().getOwnerPayPeriod());
				}
				semmsa002Bean.setPayPeriodTypeIns01("");
				semmsa002Bean.setPayPeriodTypeIns02("");
				semmsa002Bean.setPayPeriodTypeIns04("");
				semmsa002Bean.setPayPeriodTypeIns05("");
				semmsa002Bean.setPayPeriodTypeIns06("");
				semmsa002Bean.setPayPeriodTypeIns07("");
				semmsa002Bean.setPayPeriodIns04(null);
				semmsa002Bean.setDisabledPayPeriodIns03(false);
				semmsa002Bean.setDisabledPayPeriodIns04(true);
			}else if(StringUtils.equals("04", ownerPayPeriodType)){
				semmsa002Bean.setPayPeriodTypeIns04(ownerPayPeriodType);
				if(semmsa002Bean.getSiteAppInsuranceObjParam().getOwnerPayPeriod() != null){
					semmsa002Bean.setPayPeriodIns04(semmsa002Bean.getSiteAppInsuranceObjParam().getOwnerPayPeriod());
//					semmsa002Bean.getSiteAppInsuranceObjParam().setOwnerPayPeriod(semmsa002Bean.getSiteAppInsuranceObj().getOwnerPayPeriod());
				}
				semmsa002Bean.setPayPeriodTypeIns01("");
				semmsa002Bean.setPayPeriodTypeIns02("");
				semmsa002Bean.setPayPeriodTypeIns03("");
				semmsa002Bean.setPayPeriodTypeIns05("");
				semmsa002Bean.setPayPeriodTypeIns06("");
				semmsa002Bean.setPayPeriodTypeIns07("");
				semmsa002Bean.setPayPeriodIns03(null);
				semmsa002Bean.setDisabledPayPeriodIns03(true);
				semmsa002Bean.setDisabledPayPeriodIns04(false);
			}else if(StringUtils.equals("05", ownerPayPeriodType)){
				semmsa002Bean.setPayPeriodTypeIns05(ownerPayPeriodType);
				semmsa002Bean.setPayPeriodTypeIns01("");
				semmsa002Bean.setPayPeriodTypeIns02("");
				semmsa002Bean.setPayPeriodTypeIns03("");
				semmsa002Bean.setPayPeriodTypeIns04("");
				semmsa002Bean.setPayPeriodTypeIns06("");
				semmsa002Bean.setPayPeriodTypeIns07("");
				semmsa002Bean.setPayPeriodIns03(null);
				semmsa002Bean.setDisabledPayPeriodIns03(true);
				semmsa002Bean.setDisabledPayPeriodIns04(true);
			}else if(StringUtils.equals("06", ownerPayPeriodType)){
				semmsa002Bean.setPayPeriodTypeIns06(ownerPayPeriodType);
				semmsa002Bean.setPayPeriodTypeIns01("");
				semmsa002Bean.setPayPeriodTypeIns02("");
				semmsa002Bean.setPayPeriodTypeIns03("");
				semmsa002Bean.setPayPeriodTypeIns04("");
				semmsa002Bean.setPayPeriodTypeIns05("");
				semmsa002Bean.setPayPeriodTypeIns07("");
				semmsa002Bean.setPayPeriodIns03(null);
				semmsa002Bean.setDisabledPayPeriodIns03(true);
				semmsa002Bean.setDisabledPayPeriodIns04(true);
			}else if(StringUtils.equals("07", ownerPayPeriodType)){
				semmsa002Bean.setPayPeriodTypeIns07(ownerPayPeriodType);
				semmsa002Bean.setPayPeriodTypeIns01("");
				semmsa002Bean.setPayPeriodTypeIns02("");
				semmsa002Bean.setPayPeriodTypeIns03("");
				semmsa002Bean.setPayPeriodTypeIns04("");
				semmsa002Bean.setPayPeriodTypeIns05("");
				semmsa002Bean.setPayPeriodTypeIns06("");
				semmsa002Bean.setPayPeriodIns03(null);
				semmsa002Bean.setDisabledPayPeriodIns03(true);
				semmsa002Bean.setDisabledPayPeriodIns04(true);
			}else {
				semmsa002Bean.setPayPeriodTypeIns01("");
				semmsa002Bean.setPayPeriodTypeIns02("");
				semmsa002Bean.setPayPeriodTypeIns03("");
				semmsa002Bean.setPayPeriodTypeIns04("");
				semmsa002Bean.setPayPeriodTypeIns05("");
				semmsa002Bean.setPayPeriodTypeIns06("");
				semmsa002Bean.setPayPeriodTypeIns07("");
				semmsa002Bean.setPayPeriodIns03(null);
				semmsa002Bean.setPayPeriodIns04(null);
				semmsa002Bean.setDisabledPayPeriodIns03(true);
				semmsa002Bean.setDisabledPayPeriodIns04(true);
			}
			semmsa002Bean.getSiteAppInsuranceObjParam().setOwnerPayPeriodType(ownerPayPeriodType);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action renderPayPeriodTypeDefault : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" #### End SEMMSA002Action renderPayPeriodTypeDefault ####");	
		}
		
		return flag;
	}
	
	public void doCheckLeaseHoldRights(){
		LOG.debug(" #### Start SEMMSA002Action doCheckLeaseHoldRights #### ");
		semmsa002Bean = getSemmsa002Bean();
		
		try{
			if(semmsa002Bean.isLeaseHoldRights()){
				if(semmsa002Bean.getSiteAppObjParam().getAgeYear() != null){
					if(semmsa002Bean.getSiteAppObjParam().getAgeYear() < 3){
						addMessageError("W0174");
						semmsa002Bean.setRenderedMsgFormChkExpire(true);
					}
				}else{
					addMessageError("W0174");
					semmsa002Bean.setRenderedMsgFormChkExpire(true);
//					semmsa002Bean.chkContractNeverExpire
				}
			}else{
				semmsa002Bean.setRenderedMsgFormChkExpire(false);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("Error SEMMSA002Action doCheckLeaseHoldRights : "+e);
			semmsa002Bean.setRenderedMsgFormChkExpire(true);
			addGeneralMessageError("E0004", " > SEMMSA002Action doCheckLeaseHoldRights ");
		}finally{
			LOG.debug(" #### End SEMMSA002Action doCheckLeaseHoldRights #### ");
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	
	public void checkEdit(){
		semmsa002Bean = getSemmsa002Bean();
		
		if(semmsa002Bean.getSiteAppLocalObjParam().getReqType().equalsIgnoreCase("01")){
			semmsa002Bean.setChkEditFlag(false);
		}else{
			semmsa002Bean.setChkEditFlag(true);
		}
		if((semmsa002Bean.isChkEditElExistingList()==true) || (semmsa002Bean.getSiteAppLocalObjParam().getReqType().equalsIgnoreCase("01"))){
			semmsa002Bean.setChkEditFlag(false);
		}else{
			semmsa002Bean.setChkEditFlag(true);
		}
		System.out.println(semmsa002Bean.isDisabledModeViewOnly()+ "   "+semmsa002Bean.isChkEditFlag());
		setSemmsa002Bean(semmsa002Bean);
	}
	
	public void doSetParamPopupConfirm(Object obj){
		LOG.debug(" ####### Start SEMMSA002Action doSetParamPopupConfirm  ####### ");
		semmsa002Bean = getSemmsa002Bean();
		try{
			ItemResultSP itemObj = (ItemResultSP)obj;
			semmsa002Bean.setRenderedMsgPopup(true);
			if(itemObj.getResultMessage() != null)
				semmsa002Bean.getRetResultObj().setResultMessage(itemObj.getResultMessage());
			
			//set button type
			if(itemObj.getResultType() != null)semmsa002Bean.getRetResultObj().setResultType(itemObj.getResultType());
			
			if(itemObj.getOkBtnLabel() != null)semmsa002Bean.getRetResultObj().setOkBtnLabel(itemObj.getOkBtnLabel());
			if(itemObj.getNavProgram() != null)semmsa002Bean.getRetResultObj().setNavProgram(itemObj.getNavProgram());
			if(itemObj.getMethodWithNavi() != null)semmsa002Bean.getRetResultObj().setMethodWithNavi(itemObj.getMethodWithNavi());
			
			if(itemObj.getCancelBtnLabel() != null)semmsa002Bean.getRetResultObj().setCancelBtnLabel(itemObj.getCancelBtnLabel());
			if(itemObj.getNavProgramCancel() != null)semmsa002Bean.getRetResultObj().setNavProgramCancel(itemObj.getNavProgramCancel());
			if(itemObj.getMethodWithNaviCancel() != null)semmsa002Bean.getRetResultObj().setMethodWithNaviCancel(itemObj.getMethodWithNaviCancel());
			
			//set param in button
			if(itemObj.getVal1() != null)semmsa002Bean.getRetResultObj().setVal1(itemObj.getVal1());
			if(itemObj.getVal2() != null)semmsa002Bean.getRetResultObj().setVal2(itemObj.getVal2());
			if(itemObj.getVal3() != null)semmsa002Bean.getRetResultObj().setVal3(itemObj.getVal3());
			if(itemObj.getVal4() != null)semmsa002Bean.getRetResultObj().setVal4(itemObj.getVal4());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("###### Error SEMMSA002Action doSetParamPopupConfirm : "+e);
			
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" ####### End SEMMSA002Action doSetParamPopupConfirm  ####### ");
		}
	}

	public void doSetParamConfirmNotChangeEl(){
			LOG.debug(" ####### Start SEMMSA002Action doSetParamConfirmNotChangeEL ####### ");
			semmsa002Bean = getSemmsa002Bean();
			try{
				ItemResultSP itemObj = new ItemResultSP();
				System.out.println("getElEditFlag + "+semmsa002Bean.getSiteAppObjParam().getElEditFlag());
				
//				if(StringUtils.equals("N", semmsa002Bean.getSiteAppObjParam().getElEditFlag())){
					itemObj.setResultMessage(msg("msg.warn.confirmUndo"));
//					//set button type
//					itemObj.setResultType("01");
//					itemObj.setVal1("Y");
//				}else{
//					itemObj.setResultMessage(msg("msg.warn.changeEl"));
//					//set button type
//					itemObj.setResultType("01");
//					itemObj.setVal3("N");
//				}
				
				
				itemObj.setOkBtnLabel("Yes");
				itemObj.setNavProgram("SEMMSA002-1");
				itemObj.setMethodWithNavi("doCheckELChange");
		
				itemObj.setCancelBtnLabel("No");
				itemObj.setNavProgramCancel("SEMMSA002-1");
				itemObj.setMethodWithNaviCancel("doCheckELChange");
				
				itemObj.setVal1("panelTab4");
				//semmsa002Bean.setChkElUseOwner(false);
				//set param in button OK
//				itemObj.setVal2("Y");
//				
//				//set param in button Cancel
//				itemObj.setVal4("N");
				
				Object obj = itemObj;
				this.doSetParamPopupConfirm(obj);
				
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				LOG.debug("###### Error SEMMSA002Action doSetParamConfirmNotChangeEL : "+e);
				
			}finally{
				setSemmsa002Bean(semmsa002Bean);
				LOG.debug(" ####### End SEMMSA002Action doSetParamConfirmNotChange  ####### ");
			}
		}
		
	
	
	
	public void doSetParamConfirmNotChangeElDeposit(){
		LOG.debug(" ####### Start SEMMSA002Action doSetParamConfirmNotChangeInsurance ####### ");
		semmsa002Bean = getSemmsa002Bean();
		try{
			ItemResultSP itemObj = new ItemResultSP();
			System.out.println("getElDepositFlag + "+semmsa002Bean.getSiteAppObjParam().getElDepositEditFlag());
//			
//			if(StringUtils.equals("N", semmsa002Bean.getSiteAppObjParam().getElDepositEditFlag())){
				itemObj.setResultMessage(msg("msg.warn.confirmUndo"));
//				//set button type
//				itemObj.setResultType("01");
//				itemObj.setVal1("Y");
//			}else{
//				itemObj.setResultMessage(msg("msg.warn.changeElDeposit"));
//				//set button type
//				itemObj.setResultType("01");
//				itemObj.setVal3("N");
//			}
//			
			
			itemObj.setOkBtnLabel("Yes");
			itemObj.setNavProgram("SEMMSA002-1");
			itemObj.setMethodWithNavi("doCheckElDepositChange");
	
			itemObj.setCancelBtnLabel("No");
			itemObj.setNavProgramCancel("SEMMSA002-1");
			itemObj.setMethodWithNaviCancel("doCheckElDepositChange");
			
			
			itemObj.setVal1("panelTab4");
			//set param in button OK
//			itemObj.setVal2("Y");
//			
//			//set param in button Cancel
//			itemObj.setVal4("N");
			
			Object obj = itemObj;
			this.doSetParamPopupConfirm(obj);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("###### Error SEMMSA002Action doSetParamConfirmNotChangeInsurance : "+e);
			
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" ####### End SEMMSA002Action doSetParamConfirmNotChange  ####### ");
		}
	}
	
	public boolean doCheckElDepositChange(){
		LOG.debug(" ##### Start SEMMSA002Action doCheckElDepositChange ##### ");
		boolean flag = true;
		semmsa002Bean = getSemmsa002Bean();
		String changeType = getFacesUtils().getRequestParameter("val1") == null ? "" : (String)getFacesUtils().getRequestParameter("val1");
		String confirmNotChElDeposit = getFacesUtils().getRequestParameter("val2") == null ? "" : (String)getFacesUtils().getRequestParameter("val2");
//		System.out.println(" doCheckElDepositChange changeType = "+ changeType);
		
		try{
//			if(StringUtils.equals("Y", confirmNotChElDeposit)){
//				if(StringUtils.equals("Y", changeType)){
					
					this.doElDepositUndo();
					
//				}
//			}else{
//				if(semmsa002Bean.isChkEditELDeposit()){
//					semmsa002Bean.getSiteAppObjParam().setElDepositEditFlag("Y");
//				}else{
//					semmsa002Bean.getSiteAppObjParam().setElDepositEditFlag("N");
//				}
//			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug(" ##### Error SEMMSA002Action doCheckElDepositChange : "+e);
		}finally{
			LOG.debug(" ##### End SEMMSA002Action doCheckElDepositChange ##### ");
//			System.out.println("semmsa002Bean.disabledModeViewOnly "+semmsa002Bean.isDisabledModeViewOnly());
//			System.out.println("semmsa002Bean.siteAppObjParam.elDepositEditFlag "+semmsa002Bean.getSiteAppObjParam().getElDepositEditFlag());
//			System.out.println("semmsa002Bean.siteAppObjParam.getReqType "+semmsa002Bean.getSiteAppObjParam().getReqType());

			setSemmsa002Bean(semmsa002Bean);
//			flag = false;
		}
		return flag;
	}
	
	public boolean doCheckElChange(){
		LOG.debug(" ##### Start SEMMSA002Action doCheckElChange ##### ");
		boolean flag = true;
		semmsa002Bean = getSemmsa002Bean();
		String changeType = getFacesUtils().getRequestParameter("val1") == null ? "" : (String)getFacesUtils().getRequestParameter("val1");
		String confirmNotChEl = getFacesUtils().getRequestParameter("val2") == null ? "" : (String)getFacesUtils().getRequestParameter("val2");
		try{
//			if(StringUtils.equals("Y", confirmNotChEl)){
//				if(StringUtils.equals("Y", changeType)){
					LOG.debug("doCheckElChange changeType = "+ changeType);
					this.doElUndo();
//				}
//			}else{
//				if(semmsa002Bean.isChkEditELDeposit()){
//					semmsa002Bean.getSiteAppObjParam().setElEditFlag("Y");
//				}else{
//					semmsa002Bean.getSiteAppObjParam().setElEditFlag("N");
//				}
//				
//			}
			
			//set render panel deposit
//			if(StringUtils.equals("Y", semmsa002Bean.getSiteAppObjParam().getElEditFlag())){
//				semmsa002Bean.setChkEditELDeposit(true); 
//			}else{
//				semmsa002Bean.setChkEditELDeposit(false);
//			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug(" ##### Error SEMMSA002Action doCheckElChange : "+e);
		}finally{
			LOG.debug(" ##### End SEMMSA002Action doCheckElChange ##### ");
			setSemmsa002Bean(semmsa002Bean);
//			flag = false;
		}
		return flag;
	}
	
	public boolean doElUndo(){
		
		LOG.debug(" #### Start SEMMSA002Action doElUndo ####");
		semmsa002Bean = getSemmsa002Bean();
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteAppSP> to = null;
		boolean flag = true;
		try{
			LOG.debug("doGetSiteAppELCont getSiteAppId :"+semmsa002Bean.getSiteAppObjParam().getSiteAppId());

			to = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA002_SITE_APP_EL_UNDO.name, semmsa002Bean.getSiteAppObjParam());

			LOG.debug("size [" + to.size() + "]");
				
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsa002Bean.setRenderedMsgDataNotFound(true);
//				semmsa002Bean.setSiteContInfo(null);
				//semmsa002Bean.setSiteAppRentCont(new ArrayList<WrapperBeanObject<SiteAppSP>>());
			}
				
			if(to != null && to.size() > 0){
//					flag = true;
					semmsa002Bean.setRenderedMsgDataNotFound(false);

//					semmsa002Bean.setSiteContInfo(new SiteAppSP());
					//semmsa002Bean.setSiteAppRentCont(new ArrayList<WrapperBeanObject<SiteAppSP>>());
					semmsa002Bean.setSiteAppELCondAllList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
					
					for (int i = 0; i < to.size(); i++) {
						SiteAppSP siteAcq = (SiteAppSP) to.get(i);
						WrapperBeanObject<SiteAppSP> tmpWrapperBean = new WrapperBeanObject<SiteAppSP>();
						
						if(siteAcq.getNoExpFlag() != null){
							if(StringUtils.equals("Y", siteAcq.getNoExpFlag().toUpperCase())){
								semmsa002Bean.setNoExpFlag(true);
							}else{
								semmsa002Bean.setNoExpFlag(false);
							}
						}else{
							semmsa002Bean.setNoExpFlag(false);
						}
						
						
						if(siteAcq.getPeriodStartDt() != null){
							siteAcq.setPeriodStartDtStr(convertYearENtoTHStr(siteAcq.getPeriodStartDt()));
						}
						
						if(siteAcq.getPeriodEndDt() != null){
							siteAcq.setPeriodEndDtStr(convertYearENtoTHStr(siteAcq.getPeriodEndDt()));
						}
						
						if(siteAcq.getEffectiveDt() != null){
							siteAcq.setEffectiveDtStr(convertYearENtoTHStr(siteAcq.getEffectiveDt()));
						}
						
						if(siteAcq.getStartDt() != null){
							siteAcq.setStartDtStr(convertYearENtoTHStr(siteAcq.getStartDt()));
						}
						
						if(siteAcq.getEndDt() != null){
							siteAcq.setEndDtStr(convertYearENtoTHStr(siteAcq.getEndDt()));
						}
						
						tmpWrapperBean.setMessage("");
						tmpWrapperBean.setCheckBox(false);
						tmpWrapperBean.setDataObj(siteAcq);
						
						if(siteAcq != null){
							//semmsa002Bean.getSiteAppRentCont().add(tmpWrapperBean);
							semmsa002Bean.getSiteAppELCondAllList().add(tmpWrapperBean);
						}
					}
				}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doRentalUndo : "+e);
		}finally{
			LOG.debug(" ##### End SEMMSA002Action doRentalUndo #####");
			setSemmsa002Bean(semmsa002Bean);
		}
		return flag;
	}
	

	public void doElDepositUndo(){
		LOG.debug(" #### Start SEMMSA002Action doElDepositUndo ####");
		semmsa002Bean = getSemmsa002Bean();
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteAppSP> to = null;
		try{
			LOG.debug("doElDepositUndo getSiteAppId :"+semmsa002Bean.getSiteAppObjParam().getSiteAppId());
			semmsa002Bean.getSiteAppObjParam().setUserId( getUserLogIn());
//			semmsa002Bean.getSiteAppObjParam().setRentContMode("C");
			to = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA002_SITE_APP_EL_DEPOSIT_UNDO.name, semmsa002Bean.getSiteAppObjParam());
			LOG.debug("size [" + to.size() + "]");
			
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsa002Bean.setRenderedMsgDataNotFound(true);
				
			}
			
			if(to != null && to.size() > 0){
//				flag = true;
				semmsa002Bean.setRenderedMsgDataNotFound(false);

				semmsa002Bean.setSiteAppDeptObj(new SiteAppSP());
				semmsa002Bean.setSiteAppDeptCashList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				semmsa002Bean.setSiteAppDeptBGList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				semmsa002Bean.setSiteAppDeptCashElList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				semmsa002Bean.setSiteAppDeptBGElList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
							
				
				for (int i = 0; i < to.size(); i++) {
					SiteAppSP siteAcq = (SiteAppSP) to.get(i);
					WrapperBeanObject<SiteAppSP> tmpWrapperBean = new WrapperBeanObject<SiteAppSP>();
					
					if(siteAcq.getNoExpFlag() != null){
						if(StringUtils.equals("Y", siteAcq.getNoExpFlag().toUpperCase())){
							semmsa002Bean.setNoExpFlag(true);
						}else{
							semmsa002Bean.setNoExpFlag(false);
						}
					}else{
						semmsa002Bean.setNoExpFlag(false);
					}
					
					if(siteAcq.getEffectiveDt() != null){
						siteAcq.setEffectiveDtStr(convertYearENtoTHStr(siteAcq.getEffectiveDt()));
					}
					
					if(siteAcq.getExpireDt() != null){
						siteAcq.setExpireDtStr(convertYearENtoTHStr(siteAcq.getExpireDt()));
					}
					

					if(siteAcq.getBgEffectiveDt() != null){
						siteAcq.setBgEffectiveDtStr(convertYearENtoTHStr(siteAcq.getBgEffectiveDt()));
					}
					
					if(siteAcq.getBgExpireDt() != null){
						siteAcq.setBgExpireDtStr(convertYearENtoTHStr(siteAcq.getBgExpireDt()));
					}
					
//					
//					if(siteAcq.getEndDt() != null){
//						siteAcq.setEndDtStr(convertYearENtoTHStr(siteAcq.getEndDt()));
//					}
//					
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					tmpWrapperBean.setDataObj(siteAcq);
					
					if(siteAcq != null){
//						semmsa002Bean.getSiteAppRentCont().add(tmpWrapperBean);
//						semmsa002Bean.setSiteAppDeptObj(siteAcq);
//						if(StringUtils.equals("06", siteAcq.getExpenseType()) || StringUtils.equals("08", siteAcq.getExpenseType()) ){
						if(StringUtils.equals("08", siteAcq.getExpenseType()) ){
	
							if(StringUtils.equals("01", siteAcq.getDepositType())){
								semmsa002Bean.getSiteAppDeptBGElList().add(tmpWrapperBean);
							}else if(StringUtils.equals("02", siteAcq.getDepositType())){
								semmsa002Bean.getSiteAppDeptCashElList().add(tmpWrapperBean);
							}
						}
					}
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doElDepositUndo : "+e);
		}finally{
			LOG.debug(" #### End SEMMSA002Action doElDepositUndo ####");
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	

	public void doGetELUseType(){
		LOG.debug(" ### START SEMMSA002Action dogetSiteAppServSelItem ### ");
		semmsa002Bean = getSemmsa002Bean();
		List<WrapperBeanObject<SiteAppRegHistSrch>> siteAppServList = new ArrayList<WrapperBeanObject<SiteAppRegHistSrch>>();
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteAppRegHistSrch> to = null;
		SelectItem selItem = null;
		try{
//			siteAppServList = 
			semmsa002Bean.getSiteAppObjParam().setMode("C");
				
			to = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA002_SITE_APP_SERVICE.name, semmsa002Bean.getSiteAppObjParam());
			LOG.debug("size [" + to.size() + "]");
			
			if(to == null || to.isEmpty()){
				// set data not found message
				List<SelectItem> listlov = new LinkedList<SelectItem>();		
				selItem = new SelectItem("ALL" , msg("value.allServItem"));
				listlov.add(selItem);
				//semmsa002Bean.setServTypeList(listlov);
				semmsa002Bean.setElUseTypeList(listlov);
				
			}
			
			if(to != null && to.size() > 0){
//				flag = true;
				List<SelectItem> listlov = new LinkedList<SelectItem>();		
				selItem = new SelectItem("ALL" , msg("value.allServItem"));
				listlov.add(selItem);
				for (int i = 0; i < to.size(); i++) {
					SiteAppRegHistSrch siteAcq = (SiteAppRegHistSrch) to.get(i);
//					WrapperBeanObject<SiteAppRegHistSrch> tmpWrapperBean = new WrapperBeanObject<SiteAppRegHistSrch>();

					if (StringUtils.isNotBlank(siteAcq.getServiceId()) && 
							   StringUtils.isNotEmpty(siteAcq.getServName())) {
						selItem = new SelectItem();
						selItem.setLabel(siteAcq.getServName());
						selItem.setValue(siteAcq.getServiceId());
						listlov.add(selItem);
						LOG.debug("siteAcq.getServName() : "+siteAcq.getServName());
						LOG.debug("siteAcq.getServiceId() : "+siteAcq.getServiceId());
					}
				}
				
				semmsa002Bean.setServTypeList(listlov);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action dogetSiteAppServSelItem : "+e);
		}finally{
			semmsa002Bean.getSiteAppObjParam().setMode("");
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" ### END SEMMSA002Action dogetSiteAppServSelItem ### ");
		}
	}
	
	
	
	
	
	
	
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	public void doSetParamConfirmNotChangeRental(){
		LOG.debug(" ####### Start SEMMSA002Action doSetParamConfirmNotChangeRental ####### ");
		semmsa002Bean = getSemmsa002Bean();
		try{
			ItemResultSP itemObj = new ItemResultSP();
			
//			if(StringUtils.equals("N", semmsa002Bean.getSiteAppObjParam().getRentEditFlag())){
				itemObj.setResultMessage(msg("msg.warn.confirmUndo"));
//				//set button type
//				itemObj.setResultType("01");
//				itemObj.setVal1("Y");
//				itemObj.setVal3("Y");
//			}else{
//				itemObj.setResultMessage(msg("msg.warn.change"));
//				//set button type
//				itemObj.setResultType("01");
//				itemObj.setVal1("N");
//				itemObj.setVal3("N");
//			}
			
			
			itemObj.setOkBtnLabel("Yes");
			itemObj.setNavProgram("SEMMSA002-1");
			itemObj.setMethodWithNavi("doCheckRentalChange");
	
			itemObj.setCancelBtnLabel("No");
			itemObj.setNavProgramCancel("SEMMSA002-1");
			itemObj.setMethodWithNaviCancel("doCheckRentalChange");
			
			itemObj.setVal1("panelTab3");
			
			//set param in button OK
//			itemObj.setVal2("Y");
//			
//			//set param in button Cancel
//			itemObj.setVal4("N");
			
			Object obj = itemObj;
			this.doSetParamPopupConfirm(obj);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("###### Error SEMMSA002Action doSetParamConfirmNotChangeRental : "+e);
			
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" ####### End SEMMSA002Action doSetParamConfirmNotChange  ####### ");
		}
	}
	
	public boolean doCheckRentalChange(){
		LOG.debug(" ##### Start SEMMSA002Action doCheckRentalChange ##### ");
		boolean flag = true;
		semmsa002Bean = getSemmsa002Bean();
		String changeType = getFacesUtils().getRequestParameter("val1") == null ? "" : (String)getFacesUtils().getRequestParameter("val1");
		String confirmNotChRental = getFacesUtils().getRequestParameter("val2") == null ? "" : (String)getFacesUtils().getRequestParameter("val2");
		try{
//			if(StringUtils.equals("Y", confirmNotChRental)){
//				if(StringUtils.equals("Y", changeType)){
					LOG.debug(" doCheckRentalChange changeType = "+ changeType);
					this.doRentalUndo();
//				}
//				
//				//TODO clear save param obj
//				this.doClearSiteAppRentCont();
//			}else{
//				if(semmsa002Bean.isChkEditRental()){
//					semmsa002Bean.getSiteAppObjParam().setRentEditFlag("Y");
//				}else{
//					semmsa002Bean.getSiteAppObjParam().setRentEditFlag("N");
//				}
////				semmsa002Bean.getSiteAppObjParam().setRentEditFlag(changeType);
//			}
			
			//set render panel deposit
//			if(StringUtils.equals("Y", semmsa002Bean.getSiteAppObjParam().getRentEditFlag())){
//				semmsa002Bean.setChkEditRental(true);
//			}else{
//				semmsa002Bean.setChkEditRental(false);
//			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug(" ##### Error SEMMSA002Action doCheckRentalChange : "+e);
		}finally{
			LOG.debug(" ##### End SEMMSA002Action doCheckRentalChange ##### ");
			setSemmsa002Bean(semmsa002Bean);
			flag = false;
		}
		return flag;
	}
	
	public boolean doRentalUndo(){
		
		LOG.debug(" #### Start SEMMSA002Action doRentalUndo ####");
		semmsa002Bean = getSemmsa002Bean();
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteAppSP> to = null;
		boolean flag = true;
		try{
			LOG.debug("doGetSiteAppRentCont getSiteAppId :"+semmsa002Bean.getSiteAppObjParam().getSiteAppId());
//			semmsa002Bean.getSiteAppObjParam().setRentContMode("C");
			semmsa002Bean.getSiteAppObjParam().setUserId(getUserLogIn());
			to = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA002_SITE_APP_RENT_UNDO.name, semmsa002Bean.getSiteAppObjParam());
			LOG.debug("size [" + to.size() + "]");
				
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsa002Bean.setRenderedMsgDataNotFound(true);
				semmsa002Bean.setSiteAppRentCont(new ArrayList<WrapperBeanObject<SiteAppSP>>());
			}
				
			if(to != null && to.size() > 0){
//					flag = true;
					semmsa002Bean.setRenderedMsgDataNotFound(false);

					semmsa002Bean.setSiteAppRentCont(new ArrayList<WrapperBeanObject<SiteAppSP>>());
					
					for (int i = 0; i < to.size(); i++) {
						SiteAppSP siteAcq = (SiteAppSP) to.get(i);
						WrapperBeanObject<SiteAppSP> tmpWrapperBean = new WrapperBeanObject<SiteAppSP>();
						
						if(siteAcq.getNoExpFlag() != null){
							if(StringUtils.equals("Y", siteAcq.getNoExpFlag().toUpperCase())){
								semmsa002Bean.setNoExpFlag(true);
							}else{
								semmsa002Bean.setNoExpFlag(false);
							}
						}else{
							semmsa002Bean.setNoExpFlag(false);
						}
						
						
						if(siteAcq.getPeriodStartDt() != null){
							siteAcq.setPeriodStartDtStr(convertYearENtoTHStr(siteAcq.getPeriodStartDt()));
						}
						
						if(siteAcq.getPeriodEndDt() != null){
							siteAcq.setPeriodEndDtStr(convertYearENtoTHStr(siteAcq.getPeriodEndDt()));
						}
						
						if(siteAcq.getEffectiveDt() != null){
							siteAcq.setEffectiveDtStr(convertYearENtoTHStr(siteAcq.getEffectiveDt()));
						}
						
						if(siteAcq.getStartDt() != null){
							siteAcq.setStartDtStr(convertYearENtoTHStr(siteAcq.getStartDt()));
						}
						
						if(siteAcq.getEndDt() != null){
							siteAcq.setEndDtStr(convertYearENtoTHStr(siteAcq.getEndDt()));
						}
						
						tmpWrapperBean.setMessage("");
						tmpWrapperBean.setCheckBox(false);
						tmpWrapperBean.setDataObj(siteAcq);
						
						if(siteAcq != null){
							semmsa002Bean.getSiteAppRentCont().add(tmpWrapperBean);
						}
					}
				}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doRentalUndo : "+e);
		}finally{
			LOG.debug(" ##### End SEMMSA002Action doRentalUndo #####");
			setSemmsa002Bean(semmsa002Bean);
		}
		return flag;
	}
	
	public void doSetParamConfirmNotChangeRentalDeposit(){
		LOG.debug(" ####### Start SEMMSA002Action doSetParamConfirmNotChangeRentalDeposit ####### ");
		semmsa002Bean = getSemmsa002Bean();
		try{
			ItemResultSP itemObj = new ItemResultSP();
			
//			if(StringUtils.equals("N", semmsa002Bean.getSiteAppObjParam().getRentDepositEditFlag())){
				itemObj.setResultMessage(msg("msg.warn.confirmUndo"));
//				//set button type
//				itemObj.setResultType("01");
//				itemObj.setVal1("Y");
//				itemObj.setVal3("Y");
//			}else{
//				itemObj.setResultMessage(msg("msg.warn.change"));
//				//set button type
//				itemObj.setResultType("01");
//				itemObj.setVal1("N");
//				itemObj.setVal3("N");
//			}
			
			
			itemObj.setOkBtnLabel("Yes");
			itemObj.setNavProgram("SEMMSA002-1");
			itemObj.setMethodWithNavi("doCheckRentalDepositChange");
	
			itemObj.setCancelBtnLabel("No");
			itemObj.setNavProgramCancel("SEMMSA002-1");
			itemObj.setMethodWithNaviCancel("doCheckRentalDepositChange");
			
			
			itemObj.setVal1("panelTab3");
			//set param in button OK
//			itemObj.setVal2("Y");
//			
//			//set param in button Cancel
//			itemObj.setVal4("N");
			
			Object obj = itemObj;
			this.doSetParamPopupConfirm(obj);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("###### Error SEMMSA002Action doSetParamConfirmNotChangeRentalDeposit : "+e);
			
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" ####### End SEMMSA002Action doSetParamConfirmNotChangeDeposit  ####### ");
		}
	}
	
	public boolean doCheckRentalDepositChange(){
		LOG.debug(" ##### Start SEMMSA002Action doCheckRentalDepositChange ##### ");
		boolean flag = true;
		semmsa002Bean = getSemmsa002Bean();
		String changeType = getFacesUtils().getRequestParameter("val1") == null ? "" : (String)getFacesUtils().getRequestParameter("val1");
		String confirmNotChRental = getFacesUtils().getRequestParameter("val2") == null ? "" : (String)getFacesUtils().getRequestParameter("val2");
		try{
//			if(StringUtils.equals("Y", confirmNotChRental)){
//				if(StringUtils.equals("Y", changeType)){
					LOG.debug("doCheckRentalDepositChange changeType = "+ changeType);
					this.doRentalDepositUndo();
//				}
//			}else{
//				if(semmsa002Bean.isChkEditRentalDeposit()){
//					semmsa002Bean.getSiteAppObjParam().setRentDepositEditFlag("Y");
//				}else{
//					semmsa002Bean.getSiteAppObjParam().setRentDepositEditFlag("N");
//				}
////				semmsa002Bean.getSiteAppObjParam().setRentDepositEditFlag(changeType);
//			}
			
			//set render panel deposit
//			if(StringUtils.equals("Y", semmsa002Bean.getSiteAppObjParam().getRentDepositEditFlag())){
//				semmsa002Bean.setChkEditRentalDeposit(true);
//			}else{
//				semmsa002Bean.setChkEditRentalDeposit(false);
//			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug(" ##### Error SEMMSA002Action doCheckRentalDepositChange : "+e);
		}finally{
			LOG.debug(" ##### End SEMMSA002Action doCheckRentalDepositChange ##### ");
			setSemmsa002Bean(semmsa002Bean);
			flag = false;
		}
		return flag;
	}
	
	public void doRentalDepositUndo(){
		LOG.debug(" #### Start SEMMSA002Action doRentalDepositUndo ####");
		semmsa002Bean = getSemmsa002Bean();
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteAppSP> to = null;
		try{
			LOG.debug("doRentalDepositUndo getSiteAppId :"+semmsa002Bean.getSiteAppObjParam().getSiteAppId());
			semmsa002Bean.getSiteAppObjParam().setUserId( getUserLogIn());
//			semmsa002Bean.getSiteAppObjParam().setRentContMode("C");
			to = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA002_SITE_APP_RENT_DEPOSIT_UNDO.name, semmsa002Bean.getSiteAppObjParam());
			LOG.debug("size [" + to.size() + "]");
			
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsa002Bean.setRenderedMsgDataNotFound(true);
				
			}
			
			if(to != null && to.size() > 0){
//				flag = true;
				semmsa002Bean.setRenderedMsgDataNotFound(false);

				semmsa002Bean.setSiteAppDeptObj(new SiteAppSP());
				semmsa002Bean.setSiteAppDeptCashList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				semmsa002Bean.setSiteAppDeptBGList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				semmsa002Bean.setSiteAppDeptCashElList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				semmsa002Bean.setSiteAppDeptBGElList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				
				for (int i = 0; i < to.size(); i++) {
					SiteAppSP siteAcq = (SiteAppSP) to.get(i);
					WrapperBeanObject<SiteAppSP> tmpWrapperBean = new WrapperBeanObject<SiteAppSP>();
					
					if(siteAcq.getNoExpFlag() != null){
						if(StringUtils.equals("Y", siteAcq.getNoExpFlag().toUpperCase())){
							semmsa002Bean.setNoExpFlag(true);
						}else{
							semmsa002Bean.setNoExpFlag(false);
						}
					}else{
						semmsa002Bean.setNoExpFlag(false);
					}
					
					if(siteAcq.getEffectiveDt() != null){
						siteAcq.setEffectiveDtStr(convertYearENtoTHStr(siteAcq.getEffectiveDt()));
					}
					
					if(siteAcq.getExpireDt() != null){
						siteAcq.setExpireDtStr(convertYearENtoTHStr(siteAcq.getExpireDt()));
					}
					

					if(siteAcq.getBgEffectiveDt() != null){
						siteAcq.setBgEffectiveDtStr(convertYearENtoTHStr(siteAcq.getBgEffectiveDt()));
					}
					
					if(siteAcq.getBgExpireDt() != null){
						siteAcq.setBgExpireDtStr(convertYearENtoTHStr(siteAcq.getBgExpireDt()));
					}
					
//					
//					if(siteAcq.getEndDt() != null){
//						siteAcq.setEndDtStr(convertYearENtoTHStr(siteAcq.getEndDt()));
//					}
//					
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					tmpWrapperBean.setDataObj(siteAcq);
					
					if(siteAcq != null){
//						semmsa002Bean.getSiteAppRentCont().add(tmpWrapperBean);
//						semmsa002Bean.setSiteAppDeptObj(siteAcq);
						if(StringUtils.equals("06", siteAcq.getExpenseType()) || StringUtils.equals("08", siteAcq.getExpenseType()) ){
							if(StringUtils.equals("01", siteAcq.getDepositType())){
								semmsa002Bean.getSiteAppDeptBGElList().add(tmpWrapperBean);
							}else if(StringUtils.equals("02", siteAcq.getDepositType())){
								semmsa002Bean.getSiteAppDeptCashElList().add(tmpWrapperBean);
							}
						}else{
						
							if(StringUtils.equals("01", siteAcq.getDepositType())){
								semmsa002Bean.getSiteAppDeptBGList().add(tmpWrapperBean);
							}else if(StringUtils.equals("02", siteAcq.getDepositType())){
								semmsa002Bean.getSiteAppDeptCashList().add(tmpWrapperBean);
							}
						}
					}
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doRentalDepositUndo : "+e);
		}finally{
			LOG.debug(" #### End SEMMSA002Action doRentalDepositUndo ####");
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	
	public void doSetParamConfirmNotChangeContractInfo(){
		LOG.debug(" ####### Start SEMMSA002Action doSetParamConfirmNotChangeContractInfo ####### ");
		semmsa002Bean = getSemmsa002Bean();
		try{
			ItemResultSP itemObj = new ItemResultSP();
//			
//			if(StringUtils.equals("N", semmsa002Bean.getSiteAppObjParam().getContractEditFlag())){
				itemObj.setResultMessage(msg("msg.warn.confirmUndo"));
//				//set button type
//				itemObj.setResultType("01");
//				itemObj.setVal1("Y");
//				itemObj.setVal3("Y");
//			}else{
//				itemObj.setResultMessage(msg("msg.warn.change"));
//				//set button type
//				itemObj.setResultType("01");
//				itemObj.setVal3("N");
//				itemObj.setVal1("N");
//			}
			
			
			itemObj.setOkBtnLabel("Yes");
			itemObj.setNavProgram("SEMMSA002-1");
			itemObj.setMethodWithNavi("doCheckContractChange");
	
			itemObj.setCancelBtnLabel("No");
			itemObj.setNavProgramCancel("SEMMSA002-1");
			itemObj.setMethodWithNaviCancel("doCheckContractChange");
			
			itemObj.setVal1("panelTab2");
			
			
			//set param in button OK
			itemObj.setVal2("Y");
			
			//set param in button Cancel
			itemObj.setVal4("N");
			
			Object obj = itemObj;
			this.doSetParamPopupConfirm(obj);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("###### Error SEMMSA002Action doSetParamConfirmNotChangeContractInfo : "+e);
			
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" ####### End SEMMSA002Action doSetParamConfirmNotChangeContractInfo  ####### ");
		}
	}
	
	public boolean doCheckContractChange(){
		LOG.debug(" ##### Start SEMMSA002Action doCheckContractChange ##### ");
		boolean flag = true;
		semmsa002Bean = getSemmsa002Bean();
		String changeType = getFacesUtils().getRequestParameter("val1") == null ? "" : (String)getFacesUtils().getRequestParameter("val1");
		String confirmNotChRental = getFacesUtils().getRequestParameter("val2") == null ? "" : (String)getFacesUtils().getRequestParameter("val2");
		try{
//			if(StringUtils.equals("Y", confirmNotChRental)){
//				if(StringUtils.equals("Y", changeType)){
					LOG.debug("doCheckContractChange changeType = "+ changeType);
					this.doContractUndo();
//				}
//			}else{
//				if(semmsa002Bean.isChkEditContractInfo()){
//					semmsa002Bean.getSiteAppObjParam().setContractEditFlag("Y");
//				}else{
//					semmsa002Bean.getSiteAppObjParam().setContractEditFlag("N");
//				}
//				
//			}
			
			//set render panel deposit
//			if(StringUtils.equals("Y", semmsa002Bean.getSiteAppObjParam().getContractEditFlag())){
//				semmsa002Bean.setChkEditContractInfo(true);
//			}else{
//				semmsa002Bean.setChkEditContractInfo(false);
//			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug(" ##### Error SEMMSA002Action doCheckContractChange : "+e);
		}finally{
			LOG.debug(" ##### End SEMMSA002Action doCheckContractChange ##### ");
			setSemmsa002Bean(semmsa002Bean);
			flag = false;
		}
		return flag;
	}
	
	public void doContractUndo(){
		LOG.debug(" #### Start SEMMSA002Action doContractUndo ####");
		semmsa002Bean = getSemmsa002Bean();
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteAppSP> to = null;
		try{
			LOG.debug("doContractUndo getSiteAppId :"+semmsa002Bean.getSiteAppObjParam().getSiteAppId());
			semmsa002Bean.getSiteAppObjParam().setUserId( getUserLogIn());
//			semmsa002Bean.getSiteAppObjParam().setRentContMode("C");
			to = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA002_SITE_APP_CONTRACT_UNDO.name, semmsa002Bean.getSiteAppObjParam());
			LOG.debug("size [" + to.size() + "]");
			
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsa002Bean.setRenderedMsgDataNotFound(true);
				
			}
			
			if(to != null && to.size() > 0){
//				flag = true;
				semmsa002Bean.setRenderedMsgDataNotFound(false);
				SiteAppSP siteAcq = (SiteAppSP) to.get(0);
				if(StringUtils.isNotEmpty( siteAcq.getRowId())){
					this.doInitialMSA002Tab1AllDetail();
				}else{
					addMessageError("Error SEMMSA002Action doContractUndo : ","E0001");
				}

			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doContractUndo : "+e);
		}finally{
			LOG.debug(" #### End SEMMSA002Action doContractUndo ####");
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	
	public void doSetParamConfirmNotChangePT(){
		LOG.debug(" ####### Start SEMMSA002Action doSetParamConfirmNotChangePT ####### ");
		semmsa002Bean = getSemmsa002Bean();
		try{
			ItemResultSP itemObj = new ItemResultSP();
			
//			if(StringUtils.equals("N", semmsa002Bean.getSiteAppObjParam().getPropertyTaxEditFlag())){
				itemObj.setResultMessage(msg("msg.warn.confirmUndo"));
//				//set button type
//				itemObj.setResultType("01");
//				itemObj.setVal1("Y");
//				itemObj.setVal3("Y");
//			}else{
//				itemObj.setResultMessage(msg("msg.warn.change"));
//				//set button type
//				itemObj.setResultType("01");
//				itemObj.setVal1("N");
//				itemObj.setVal3("N");
//			}
			
			
			itemObj.setOkBtnLabel("Yes");
			itemObj.setNavProgram("SEMMSA002-1");
			itemObj.setMethodWithNavi("doCheckPTChange");
	
			itemObj.setCancelBtnLabel("No");
			itemObj.setNavProgramCancel("SEMMSA002-1");
			itemObj.setMethodWithNaviCancel("doCheckPTChange");
			
			
			itemObj.setVal1("panelTab6");
			//set param in button OK
//			itemObj.setVal2("Y");
//			
//			//set param in button Cancel
//			itemObj.setVal4("N");
			
			Object obj = itemObj;
			this.doSetParamPopupConfirm(obj);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("###### Error SEMMSA002Action doSetParamConfirmNotChangePT : "+e);
			
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" ####### End SEMMSA002Action doSetParamConfirmNotChangePT  ####### ");
		}
	}
	
	public boolean doCheckPTChange(){
		LOG.debug(" ##### Start SEMMSA002Action doCheckPTChange ##### ");
		boolean flag = true;
		semmsa002Bean = getSemmsa002Bean();
		String changeType = getFacesUtils().getRequestParameter("val1") == null ? "" : (String)getFacesUtils().getRequestParameter("val1");
		String confirmNotCh = getFacesUtils().getRequestParameter("val2") == null ? "" : (String)getFacesUtils().getRequestParameter("val2");
		try{
//			if(StringUtils.equals("Y", confirmNotCh)){
//				if(StringUtils.equals("Y", changeType)){
//					LOG.debug("doCheckPTChange changeType = "+ changeType);
					this.doSiteAppTPUndo();
//				}
//			}else{
//				if(semmsa002Bean.isPropertyTaxEditFlag()){
//					semmsa002Bean.getSiteAppObjParam().setPropertyTaxEditFlag("Y");
//				}else{
//					semmsa002Bean.getSiteAppObjParam().setPropertyTaxEditFlag("N");
//				}
//				
//			}
			
			//set render panel deposit
//			if(StringUtils.equals("Y", semmsa002Bean.getSiteAppObjParam().getPropertyTaxEditFlag())){
//				semmsa002Bean.setPropertyTaxEditFlag(true);
//			}else{
//				semmsa002Bean.setPropertyTaxEditFlag(false);
//			}
			
			this.doInitEditPT(semmsa002Bean.getSiteAppPTObj().getPtTaxPayType(),semmsa002Bean.getSiteAppPTObj().getPtRemark());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug(" ##### Error SEMMSA002Action doCheckPTChange : "+e);
		}finally{
			LOG.debug(" ##### End SEMMSA002Action doCheckPTChange ##### ");
			setSemmsa002Bean(semmsa002Bean);
			flag = false;
		}
		return flag;
	}
	
	public void doSiteAppTPUndo(){
		LOG.debug(" #### Start SEMMSA002Action doSiteAppTPUndo ####");
		semmsa002Bean = getSemmsa002Bean();
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteAppSP> to = null;
		try{
			LOG.debug("doSiteAppTPUndo getSiteAppId :"+semmsa002Bean.getSiteAppObjParam().getSiteAppId());
			semmsa002Bean.getSiteAppObjParam().setUserId(getUserLogIn());
//			semmsa002Bean.getSiteAppObjParam().setRentContMode("C");
			to = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA002_SITE_APP_PT_UNDO.name, semmsa002Bean.getSiteAppObjParam());
			LOG.debug("size [" + to.size() + "]");
			
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsa002Bean.setRenderedMsgDataNotFound(true);
			}
			
			if(to != null && to.size() > 0){
//				flag = true;
				semmsa002Bean.setRenderedMsgDataNotFound(false);

				semmsa002Bean.setSiteAppPTObj(new SiteAppSP());
				
				for (int i = 0; i < to.size(); i++) {
					SiteAppSP siteAcq = (SiteAppSP) to.get(i);
					WrapperBeanObject<SiteAppSP> tmpWrapperBean = new WrapperBeanObject<SiteAppSP>();
					
					if(siteAcq.getNoExpFlag() != null){
						if(StringUtils.equals("Y", siteAcq.getNoExpFlag().toUpperCase())){
							semmsa002Bean.setNoExpFlag(true);
						}else{
							semmsa002Bean.setNoExpFlag(false);
						}
					}else{
						semmsa002Bean.setNoExpFlag(false);
					}
					
					if(siteAcq.getEffectiveDt() != null){
						siteAcq.setEffectiveDtStr(convertYearENtoTHStr(siteAcq.getEffectiveDt()));
					}
					
					if(siteAcq.getExpireDt() != null){
						siteAcq.setExpireDtStr(convertYearENtoTHStr(siteAcq.getExpireDt()));
					}
					

					if(siteAcq.getPtEffectiveDt() != null){
						siteAcq.setPtEffectiveDtStr(convertYearENtoTHStr(siteAcq.getPtEffectiveDt()));
					}
					
					if(siteAcq.getPtRemark() == null){
						siteAcq.setPtRemark("");
					}
					
//				semmsa002Bean.siteAppPTObj.ptTaxPayType
					LOG.debug(" doSiteAppTPUndo getPtTaxPayType ;:: "+siteAcq.getPtTaxPayType());
					LOG.debug(" doSiteAppTPUndo getPtRemark ;:: "+siteAcq.getPtRemark());
					if(siteAcq != null){
//						semmsa002Bean.getSiteAppRentCont().add(tmpWrapperBean);
						semmsa002Bean.setSiteAppPTObj(siteAcq);
//						
						
					}
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doSiteAppTPUndo : "+e);
		}finally{
			LOG.debug(" #### End SEMMSA002Action doSiteAppTPUndo ####");
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	
	private boolean doInitEditPT(String ptTaxPayType,String ptRemark){
		LOG.debug(" #### Start SEMMSA002Action doInitEditPT ####");
		semmsa002Bean = getSemmsa002Bean();
		try{
//			ptTaxPayType = getFacesUtils().getRequestParameter("ptTaxPayType") == null ? "" : (String)getFacesUtils().getRequestParameter("ptTaxPayType");
//			ptRemark = getFacesUtils().getRequestParameter("ptRemark") == null ? "" : (String)getFacesUtils().getRequestParameter("ptRemark");
//			String ptEffectiveDt = getFacesUtils().getRequestParameter("ptEffectiveDt") == null ? "" : (String)getFacesUtils().getRequestParameter("ptEffectiveDt");
			
			if(semmsa002Bean.isPropertyTaxEditFlag()){
				if(StringUtils.isNotEmpty(ptTaxPayType)){
					semmsa002Bean.getSiteAppPTObjParam().setPtTaxPayType(ptTaxPayType);
				}
				
				if(StringUtils.isNotEmpty(ptRemark)){
					semmsa002Bean.getSiteAppPTObjParam().setPtRemark(ptRemark);
				}
			}else{
				this.doClearSiteAppPT();
			}
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doInitEditPT : "+e);
		}finally{
			LOG.debug(" #### End SEMMSA002Action doInitEditPT ####");	
			setSemmsa002Bean(semmsa002Bean);
		}
		return true;
	}
	
	public void doSetParamConfirmNotChangeEL(){
		LOG.debug(" ####### Start SEMMSA002Action doSetParamConfirmNotChangeRental ####### ");
		semmsa002Bean = getSemmsa002Bean();
		try{
			ItemResultSP itemObj = new ItemResultSP();
			
			System.out.println("getElEditFlag() + "+semmsa002Bean.getSiteAppObjParam().getElEditFlag());
			
			if(StringUtils.equals("N", semmsa002Bean.getSiteAppObjParam().getElEditFlag())){
				itemObj.setResultMessage(msg("msg.warn.notchange"));
				//set button type
				itemObj.setResultType("01");
				itemObj.setVal1("Y");
			}else{
				itemObj.setResultMessage(msg("msg.warn.change"));
				//set button type
				itemObj.setResultType("02");
				itemObj.setVal3("N");
			}
			
			
			itemObj.setOkBtnLabel("Yes");
			itemObj.setNavProgram("SEMMSA002-1");
			itemObj.setMethodWithNavi("doCheckELChanger");
	
			itemObj.setCancelBtnLabel("No");
			itemObj.setNavProgramCancel("SEMMSA002-1");
			itemObj.setMethodWithNaviCancel("doCheckELChanger");
			
			
			
			//set param in button OK
			itemObj.setVal2("Y");
			
			//set param in button Cancel
			itemObj.setVal4("N");
			
			Object obj = itemObj;
			this.doSetParamPopupConfirm(obj);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("###### Error SEMMSA002Action doSetParamConfirmNotChangeRental : "+e);
			
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" ####### End SEMMSA002Action doSetParamConfirmNotChange  ####### ");
		}
	}
	
	public boolean doCheckELChanger(){
		LOG.debug(" ##### Start SEMMSA002Action doCheckRentalChanger ##### ");
		boolean flag = true;
		semmsa002Bean = getSemmsa002Bean();
		String changeType = getFacesUtils().getRequestParameter("val1") == null ? "" : (String)getFacesUtils().getRequestParameter("val1");
		String confirmNotChRental = getFacesUtils().getRequestParameter("val2") == null ? "" : (String)getFacesUtils().getRequestParameter("val2");
		try{
			if(StringUtils.equals("Y", confirmNotChRental)){
				
			}else{
				semmsa002Bean.getSiteAppObjParam().setRentEditFlag(changeType);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug(" ##### Error SEMMSA002Action doCheckRentalChanger : "+e);
		}finally{
			LOG.debug(" ##### End SEMMSA002Action doCheckRentalChanger ##### ");
			setSemmsa002Bean(semmsa002Bean);
			flag = false;
		}
		return flag;
	}
	
	public void doSetParamConfirmNotChangeIR(){
		LOG.debug(" ####### Start SEMMSA002Action doSetParamConfirmNotChangeIR ####### ");
		semmsa002Bean = getSemmsa002Bean();
		try{
			ItemResultSP itemObj = new ItemResultSP();
//			
//			if(StringUtils.equals("N", semmsa002Bean.getSiteAppObjParam().getInsuranceEditFlag())){
				itemObj.setResultMessage(msg("msg.warn.confirmUndo"));
//				//set button type
//				itemObj.setResultType("01");
//				itemObj.setVal1("Y");
//				itemObj.setVal3("Y");
//			}else{
//				itemObj.setResultMessage(msg("msg.warn.change"));
//				//set button type
//				itemObj.setResultType("01");
//				itemObj.setVal1("N");
//				itemObj.setVal3("N");
//			}
			
			
			itemObj.setOkBtnLabel("Yes");
			itemObj.setNavProgram("SEMMSA002-1");
			itemObj.setMethodWithNavi("doCheckInsuranceChange");
	
			itemObj.setCancelBtnLabel("No");
			itemObj.setNavProgramCancel("SEMMSA002-1");
			itemObj.setMethodWithNaviCancel("doCheckInsuranceChange");
			
			
			itemObj.setVal1("panelTab6");
			//set param in button OK
//			itemObj.setVal2("Y");
//			
//			//set param in button Cancel
//			itemObj.setVal4("N");
			
			Object obj = itemObj;
			this.doSetParamPopupConfirm(obj);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("###### Error SEMMSA002Action doSetParamConfirmNotChangeIR : "+e);
			
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" ####### End SEMMSA002Action doSetParamConfirmNotChangeIR  ####### ");
		}
	}
	
	public boolean doCheckInsuranceChange(){
		LOG.debug(" ##### Start SEMMSA002Action doCheckInsuranceChange ##### ");
		boolean flag = true;
		semmsa002Bean = getSemmsa002Bean();
		String changeType = getFacesUtils().getRequestParameter("val1") == null ? "" : (String)getFacesUtils().getRequestParameter("val1");
		String confirmNotCh = getFacesUtils().getRequestParameter("val2") == null ? "" : (String)getFacesUtils().getRequestParameter("val2");
		try{
//			if(StringUtils.equals("Y", confirmNotCh)){
//				if(StringUtils.equals("Y", changeType)){
					LOG.debug("doCheckContractChange changeType = "+ changeType);
					this.doSiteAppIRUndo();
//				}
//			}else{
//				if(semmsa002Bean.isInsuranceEditFlag()){
//					semmsa002Bean.getSiteAppObjParam().setInsuranceEditFlag("Y");
//				}else{
//					semmsa002Bean.getSiteAppObjParam().setInsuranceEditFlag("N");
//				}
//				
//			}
			
			//set render panel insurance
//			if(StringUtils.equals("Y", semmsa002Bean.getSiteAppObjParam().getInsuranceEditFlag())){
//				semmsa002Bean.setInsuranceEditFlag(true);
//			}else{
//				semmsa002Bean.setInsuranceEditFlag(false);
//			}
			
			this.doInitEditIR();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug(" ##### Error SEMMSA002Action doCheckInsuranceChange : "+e);
		}finally{
			LOG.debug(" ##### End SEMMSA002Action doCheckInsuranceChange ##### ");
			setSemmsa002Bean(semmsa002Bean);
//			flag = false;
		}
		return flag;
	}
	
	public void doSiteAppIRUndo(){
		LOG.debug(" #### Start SEMMSA002Action doSiteAppIRUndo ####");
		semmsa002Bean = getSemmsa002Bean();
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteAppSP> to = null;
		try{
			LOG.debug("doSiteAppIRUndo getSiteAppId :"+semmsa002Bean.getSiteAppObjParam().getSiteAppId());
			SiteAppSP siteAppObj = new SiteAppSP();
			siteAppObj.setSiteAppId(semmsa002Bean.getSiteAppObjParam().getSiteAppId());
			siteAppObj.setUserId(getUserLogIn());
//			siteAppObj.setContractNo(semmsa002Bean.getSiteAppObjParam().getContractNo());
			to = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA002_SITE_APP_IR_UNDO.name, siteAppObj);
			LOG.debug("size [" + to.size() + "]");
			
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsa002Bean.setRenderedMsgDataNotFound(true);
				semmsa002Bean.setSiteAppInsuranceObj(null);
				
			}
			
			if(to != null && to.size() > 0){
//				flag = true;
				semmsa002Bean.setRenderedMsgDataNotFound(false);

				semmsa002Bean.setSiteAppInsuranceObj(new SiteAppSP());
//				semmsa002Bean.setSiteAppInsuranceList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
//				semmsa002Bean.setSiteAppDeptBGList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
				
				for (int i = 0; i < to.size(); i++) {
					SiteAppSP siteAcq = (SiteAppSP) to.get(i);
//					
					if(siteAcq.getPlxEffectiveDt() != null){
						siteAcq.setPlxEffectiveDtStr(convertYearENtoTHStr(siteAcq.getPlxEffectiveDt()));
					}
					
					if(siteAcq.getPlxExpireDt() != null){
						siteAcq.setPlxExpireDtStr(convertYearENtoTHStr(siteAcq.getPlxExpireDt()));
					}
					
					if(StringUtils.equals("Y", siteAcq.getNoOwnerAmt())){
						semmsa002Bean.setNoOwnerAmtFlag(true);
					}
//
					LOG.debug("doSiteAppIRUndo siteAcq.getPlxAmt() : "+siteAcq.getPlxAmt());
					LOG.debug("doSiteAppIRUndo siteAcq.getOwnerAmtt() : "+siteAcq.getOwnerAmt());
					if(siteAcq != null){
						semmsa002Bean.setSiteAppInsuranceObj(siteAcq);
					}
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doSiteAppIRUndo : "+e);
		}finally{
			LOG.debug(" #### End SEMMSA002Action doSiteAppIRUndo ####");
			setSemmsa002Bean(semmsa002Bean);
		}
	}

	public void doSetParamConfirmNotChangeContDoc(){
		LOG.debug(" ####### Start SEMMSA002Action doSetParamConfirmNotChangeContDoc ####### ");
		semmsa002Bean = getSemmsa002Bean();
		try{
			ItemResultSP itemObj = new ItemResultSP();
			
//			if(StringUtils.equals("N", semmsa002Bean.getSiteAppObjParam().getChkContDocEditFlag())){
				itemObj.setResultMessage(msg("msg.warn.confirmUndo"));
//				//set button type
//				itemObj.setResultType("01");
//				itemObj.setVal1("Y");
//				itemObj.setVal3("Y");
//			}else{
//				itemObj.setResultMessage(msg("msg.warn.change"));
//				//set button type
//				itemObj.setResultType("01");
//				itemObj.setVal1("N");
//				itemObj.setVal3("N");
//			}
			
			
			itemObj.setOkBtnLabel("Yes");
			itemObj.setNavProgram("SEMMSA002-1");
			itemObj.setMethodWithNavi("doCheckContDocChange");
	
			itemObj.setCancelBtnLabel("No");
			itemObj.setNavProgramCancel("SEMMSA002-1");
			itemObj.setMethodWithNaviCancel("doCheckContDocChange");
			
			
			itemObj.setVal1("panelTab7");
			//set param in button OK
//			itemObj.setVal2("Y");
//			
//			//set param in button Cancel
//			itemObj.setVal4("N");
			
			Object obj = itemObj;
			this.doSetParamPopupConfirm(obj);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("###### Error SEMMSA002Action doSetParamConfirmNotChangeContDoc : "+e);
			
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" ####### End SEMMSA002Action doSetParamConfirmNotChangeContDoc  ####### ");
		}
	}
	
	public boolean doCheckContDocChange(){
		LOG.debug(" ##### Start SEMMSA002Action doCheckContDocChange ##### ");
		boolean flag = true;
		semmsa002Bean = getSemmsa002Bean();
		String changeType = getFacesUtils().getRequestParameter("val1") == null ? "" : (String)getFacesUtils().getRequestParameter("val1");
		String confirmNotCh = getFacesUtils().getRequestParameter("val2") == null ? "" : (String)getFacesUtils().getRequestParameter("val2");
		try{
//			if(StringUtils.equals("Y", confirmNotCh)){
//				if(StringUtils.equals("Y", changeType)){
					LOG.debug("doCheckContDocChange changeType = "+ changeType);
					this.doContDocUndo();
//				}
//			}else{
//				if(semmsa002Bean.isChkEditSiteAppDoc()){
//					semmsa002Bean.getSiteAppObjParam().setChkContDocEditFlag("Y");
//				}else{
//					semmsa002Bean.getSiteAppObjParam().setChkContDocEditFlag("N");
//				}
//				
//			}
			
			//set render panel doCheckContDocChange
//			if(StringUtils.equals("Y", semmsa002Bean.getSiteAppObjParam().getChkContDocEditFlag())){
//				semmsa002Bean.setChkEditSiteAppDoc(true);
//			}else{
//				semmsa002Bean.setChkEditSiteAppDoc(false);
//			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug(" ##### Error SEMMSA002Action doCheckContDocChange : "+e);
		}finally{
			LOG.debug(" ##### End SEMMSA002Action doCheckContDocChange ##### ");
			setSemmsa002Bean(semmsa002Bean);
			flag = false;
		}
		return flag;
	}
	
	public void doContDocUndo(){
		LOG.debug(" #### Start SEMMSA002Action doContDocUndo ####");
		semmsa002Bean = getSemmsa002Bean();
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteAppSP> to = null;
		try{
			LOG.debug("doContDocUndo getSiteAppId :"+semmsa002Bean.getSiteAppObjParam().getSiteAppId());
			semmsa002Bean.getSiteAppObjParam().setUserId( getUserLogIn());
//			semmsa002Bean.getSiteAppObjParam().setRentContMode("C");
			to = service.siteAppSiteDao_querySPList(EQueryName.P_MSA002_SITE_APP_DOC_UNDO.name, semmsa002Bean.getSiteAppObjParam());
			LOG.debug("size [" + to.size() + "]");
			
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsa002Bean.setRenderedMsgDataNotFound(true);
				addMessageError("Error SEMMSA002Action doContDocUndo : ","E0001");
			}
			
			if(to != null && to.size() > 0){
//				flag = true;
				semmsa002Bean.setRenderedMsgDataNotFound(false);
				SiteAppSP siteAcq = (SiteAppSP) to.get(0);
				if(StringUtils.isNotEmpty( siteAcq.getRowId())){
					if(StringUtils.equals("SUCCESS", siteAcq.getRetResult().toUpperCase())){
						this.doInitialMSA002Tab1AllDetail();
						
						// initiate LegalDoc for tab5
						this.doGetLegalDoc();
					}else{
						semmsa002Bean.setRenderedMsgDataNotFound(true);
						addGeneralMessageError(siteAcq.getResultMsg());
					}
					
				}else{
					addMessageError("Error SEMMSA002Action doContDocUndo : ","E0001");
				}

			}else{
				addMessageError("Error SEMMSA002Action doContDocUndo : ","E0001");
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMSA002Action doContDocUndo : "+e);
		}finally{
			LOG.debug(" #### End SEMMSA002Action doContDocUndo ####");
			setSemmsa002Bean(semmsa002Bean);
		}
	}
	
	public void onRenderButton_tab9Address(){
		semmsa002Bean = getSemmsa002Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		semmsa002Bean.setTmpRowId(rowId);
		
//		if (isCheckSELBox()) {
//			semmsa003Bean.setDisabledBtnExport(false);
//		} else {
//			semmsa003Bean.setDisabledBtnExport(true);
//		}
		
		if (this.isCheckSELBox()) {
			semmsa002Bean.setDisabledBtnExportAddr(false);
			
		} else {
			semmsa002Bean.setDisabledBtnExportAddr(true);
		}
		setSemmsa002Bean(semmsa002Bean);
	}
	
	private boolean isCheckSELBox() {
		boolean isCheck = false;
		int rowSelect = 0;
		SiteAppMailSP siteAcqSP = new SiteAppMailSP();
		String mailAddrIdTmp = null; 
		String rowId = getFacesUtils().getRequestParameter("rowId") == null ? "" : (String)getFacesUtils().getRequestParameter("rowId");
		try{
			List<WrapperBeanObject<SiteAppMailSP>> siteAcqList = getSemmsa002Bean().getSiteAppMailList();
			for (WrapperBeanObject<SiteAppMailSP> wrapperBeanObject : siteAcqList) {
				siteAcqSP = (SiteAppMailSP) wrapperBeanObject.getDataObj();
				if (wrapperBeanObject.isCheckBox()) {
					if(StringUtils.equals(rowId, siteAcqSP.getMailAddrId())){
						
						isCheck = true;
						if(siteAcqSP.getMailAddrId() != null)semmsa002Bean.setMailAddrIdTmp(siteAcqSP.getMailAddrId());
					}else{
						getSemmsa002Bean().getSiteAppMailList().get(rowSelect).setCheckBox(false);
						wrapperBeanObject.setCheckBox(false);
					}
//					
					rowSelect++;
				}
			}
			//check batch
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error(e);
		}
		
		return isCheck;
	}
	
	//added by NEW 2018/11/01
	public void doChkWaitforTerFunc(){
		LOG.debug(" ##########  Start SEMMSA002Action doChkWaitforTerFunc  #########");
		semmsa002Bean = getSemmsa002Bean();
		String chkType = getFacesUtils().getRequestParameter("chkType") == null ? "" : (String)getFacesUtils().getRequestParameter("chkType");
		try{
			LOG.debug("semmsa002Bean.isChkTerminateRemoveFlag() : "+semmsa002Bean.isChkTerminateRemoveFlag());
			if(StringUtils.equals("01", chkType)){
				if(!semmsa002Bean.isChkTerminateRemoveFlag()){
					semmsa002Bean.getSiteAppTab0ObjParam().setTerminateRemoveDt(null);
					semmsa002Bean.getSiteAppTab0ObjParam().setTerminateRemoveEndDt(null);
				}
			}else if(StringUtils.equals("03", chkType)){
				if(!semmsa002Bean.isChkOtherWaitingFlag()){
					semmsa002Bean.getSiteAppTab0ObjParam().setTerminateNote("");
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			LOG.error("Error SEMMSA002Action doChkWaitforTerFunc : "+e);
			e.printStackTrace();
		}finally{
			LOG.debug(" ##########  End SEMMSA002Action doChkWaitforTerFunc  #########");	
			setSemmsa002Bean(semmsa002Bean);
		}
		
	}
	
	public void doChkTerFunc(){
		LOG.debug(" ##########  Start SEMMSA002Action doChkTerFunc  #########");
		semmsa002Bean = getSemmsa002Bean();
		String chkType = getFacesUtils().getRequestParameter("chkType") == null ? "" : (String)getFacesUtils().getRequestParameter("chkType");
		try{
			if(StringUtils.equals("01", chkType)){
				if(!semmsa002Bean.isChkReturnDepositFlag()){
					semmsa002Bean.getSiteAppTab0ObjParam().setReturnDepositAmt(null);
					semmsa002Bean.getSiteAppTab0ObjParam().setReturnDepositDt(null);
//					semmsa002Bean.setChkNoReturnDepositFlag(false);
				}else{
					semmsa002Bean.setChkNoReturnDepositFlag(false);
				}
			}else if(StringUtils.equals("03", chkType)){
				if(!semmsa002Bean.isChkOtherTerminateFlag()){
					semmsa002Bean.getSiteAppTab0ObjParam().setOtherTerminateNote("");
				}
			}else if(StringUtils.equals("04", chkType)){
				if(semmsa002Bean.isChkNoReturnDepositFlag()){
					semmsa002Bean.getSiteAppTab0ObjParam().setReturnDepositAmt(null);
					semmsa002Bean.getSiteAppTab0ObjParam().setReturnDepositDt(null);
					semmsa002Bean.setChkReturnDepositFlag(false);
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			LOG.error("Error SEMMSA002Action doChkTerFunc : "+e);
			e.printStackTrace();
		}finally{
			LOG.debug(" ##########  End SEMMSA002Action doChkTerFunc  #########");	
			setSemmsa002Bean(semmsa002Bean);
		}
		
	}
	
	public void doNoInsurancePay(){
		LOG.debug(" ##########  Start SEMMSA002Action doNoInsurancePay  #########");	
		semmsa002Bean = getSemmsa002Bean();
		try{
			semmsa002Bean.setSiteAppInsuranceObjParam(new SiteAppSP());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error("Error SEMMSA002Action doNoInsurancePay : "+e);
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			LOG.debug(" ##########  End SEMMSA002Action doNoInsurancePay  #########");	
		}
	}
	
	public boolean doCheckElecticTypeChanged(){
		boolean flag = true;
		semmsa002Bean = getSemmsa002Bean();
		try{
			// ------------ chack EL NEW ----------------
//			if(semmsa002Bean.getSiteAppLocalObjParam().getElUseMultiResourse().equals("Y")){
//				if(!semmsa002Bean.isChkMultiElectricTypeFlag()){
//					addMessageErrorWithArgument("W0176", msg("message.endperioddt"));
//				}
//			}else{
//				if(semmsa002Bean.isChkMultiElectricTypeFlag()){
//					addMessageErrorWithArgument("W0176", msg("message.endperioddt"));
//				}
//			}
			
			// ------------ chack EL NEW Meter----------------
			
			if(!semmsa002Bean.isChkElUseNewMeter()){
				if(semmsa002Bean.getSiteAppObjParam().getElUseNewMeter().equals("Y")){
					addMessageErrorWithArgument("W0176", msg("msg.elUseNewMeter"));
				}
			}
			
			
			// ------------ chack EL OLD Meter ----------------
			if(!semmsa002Bean.isChkElUseOldMeter()){
				if(semmsa002Bean.getSiteAppLocalObjParam().getElUseOldMeter().equals("Y")){
					addMessageErrorWithArgument("W0176", msg("msg.elUseOldMeter"));
				}
			}
			
			// ------------ chack EL Owner ----------------
			if(!semmsa002Bean.isChkElUseOwner()){
				if(semmsa002Bean.getSiteAppLocalObjParam().getElUseOwner().equals("Y")){
					addMessageErrorWithArgument("W0176", msg("msg.elUseOwner"));
				}
					
			}
			
			// ------------ chack EL chkElUseOthSite ----------------
			if(!semmsa002Bean.isChkElUseOthSite()){
				if(semmsa002Bean.getSiteAppLocalObjParam().getElUseOthSite().equals("Y")){
					addMessageErrorWithArgument("W0176", msg("msg.elUseOthSite"));
				}
				
			}
			
			// ------------ chack EL chkElUseOth ----------------
			if(!semmsa002Bean.isChkElUseOth()){
				if(semmsa002Bean.getSiteAppLocalObjParam().getElUseOth().equals("Y")){
					addMessageErrorWithArgument("W0176", msg("msg.elUseOth"));
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error(" ########## Error SEMMSA002Action doCheckElecticTypeChanged #########");
		}finally{
			
		}
		return flag;
	}
	
	public void getSubCategoryList() {
		try {
			
			semmsa002Bean = getSemmsa002Bean();
			
			SelectItem selItem = null;
			List<SelectItem> selList = new ArrayList<SelectItem>();
			List<SelectItem> selTempList = new ArrayList<SelectItem>();

			String myOwnerCatCode = semmsa002Bean.getSiteAppObjParam().getOwnerCategory();
			
			ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
			semmsa002Bean.setLovObjParam(new MSA001LovSP());
			semmsa002Bean.getLovObjParam().setLovType("CT_SUB_CATEGORY");
			semmsa002Bean.getLovObjParam().setRecordStatus("Y");
			semmsa002Bean.getLovObjParam().setLovName2("");
			semmsa002Bean.getLovObjParam().setLovVal2(myOwnerCatCode);
			
			if(myOwnerCatCode != null && !myOwnerCatCode.equals("")) {
				List<MSA001LovSP> retLst = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA001_SRCH_TEAM.name, semmsa002Bean.getLovObjParam());
		
				if(retLst != null && !retLst.isEmpty()){
					for(MSA001LovSP lov : retLst){
						selItem = new SelectItem();
						selItem.setLabel(lov.getLovName());
						selItem.setValue(lov.getLovCode());
						selList.add(selItem);
					}
					
					// -- insert label '-- select --' at index 0
					if(selList.size() >= 1) {
						selTempList = selList;
						SelectItem selItem_idx0 = new SelectItem();
						selItem_idx0.setLabel("-- Select --");
						selItem_idx0.setValue("");
						
						selList = new ArrayList<SelectItem>();
						selList.add(selItem_idx0);
						
						for(int i = 0;i < selTempList.size();i++){
							SelectItem selItem_idx1 = new SelectItem();
							selItem_idx1.setLabel(selTempList.get(i).getLabel());
							selItem_idx1.setValue(selTempList.get(i).getValue());

							selList.add(selItem_idx1);
						}
//						SelectItem selItem_idx1 = new SelectItem();
//						selItem_idx1.setLabel(selList.get(0).getLabel());
//						selItem_idx1.setValue(selList.get(0).getValue());

//						selList = new ArrayList<SelectItem>();
//						selList.add(selItem_idx0);
//						selList.add(selItem_idx1);
					}
					// --
				} else {
					selItem = new SelectItem();
					selItem.setLabel("-- not found --");
					selItem.setValue("");
					selList.add(selItem);
				}
			} else {
				selItem = new SelectItem();
				selItem.setLabel("-- Select --");
				selItem.setValue("");
				selList.add(selItem);
			}
			semmsa002Bean.getSiteAppObjParam().setOwnerSubCategory("");
			semmsa002Bean.setOwnerSubCategoryList(selList);
			
			setSemmsa002Bean(semmsa002Bean);
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
		}
	}
	
}
