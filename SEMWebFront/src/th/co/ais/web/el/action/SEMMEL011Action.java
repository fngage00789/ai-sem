package th.co.ais.web.el.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
//import org.hsqldb.lib.StringUtil;

import th.co.ais.domain.cp.PopupVendorSupplierSearchSP;
import th.co.ais.domain.el.Payment;
import th.co.ais.domain.el.PaymentSearch;
import th.co.ais.domain.gm.Province;
import th.co.ais.domain.si.ApproveSiteInfoSP;
import th.co.ais.domain.si.Construct;
import th.co.ais.domain.si.Contract;
import th.co.ais.domain.si.Deposit;
import th.co.ais.domain.si.Electric;
import th.co.ais.domain.si.Insurance;
import th.co.ais.domain.si.Lessor;
import th.co.ais.domain.si.Msi004CalcAgeSP;
import th.co.ais.domain.si.Msi004CalcExpireDateSP;
import th.co.ais.domain.si.Msi004ChkCopySP;
import th.co.ais.domain.si.Msi004DefaultTotSP;
import th.co.ais.domain.si.Msi004GenDummy;
import th.co.ais.domain.si.Msi004SrchDepositElectricSP;
import th.co.ais.domain.si.Msi004SrchExportSP;
import th.co.ais.domain.si.Msi004SrchSumRentAgeSP;
import th.co.ais.domain.si.PopupContractSearchSP;
import th.co.ais.domain.si.PropertyTax;
import th.co.ais.domain.si.Rent;
import th.co.ais.domain.si.RentCond;
import th.co.ais.domain.si.SiteInfo;
import th.co.ais.domain.si.SiteInfoMapLocSP;
import th.co.ais.domain.si.SiteInfoSP;
import th.co.ais.domain.si.SiteInfoSeqSP;
import th.co.ais.domain.si.SiteLocationSP;
import th.co.ais.domain.si.SubRent;
import th.co.ais.rpt.parameter.SEMESI001ReportParameter;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.rpt.util.bean.CellDomain;
import th.co.ais.rpt.util.bean.EnumDocStyleDomain;
import th.co.ais.rpt.util.bean.RowDomain;
import th.co.ais.rpt.util.enums.EnumDocStyle;
import th.co.ais.rpt.util.enums.EnumDocumentType;
import th.co.ais.service.si.ISiteConstructService;
import th.co.ais.service.si.ISiteContractService;
import th.co.ais.service.si.ISiteDepositService;
import th.co.ais.service.si.ISiteElectricService;
import th.co.ais.service.si.ISiteInfoMapLocService;
import th.co.ais.service.si.ISiteInfoService;
import th.co.ais.service.si.ISiteInsuranceService;
import th.co.ais.service.si.ISiteLessorService;
import th.co.ais.service.si.ISitePropertyTaxService;
import th.co.ais.service.si.ISiteRentCondService;
import th.co.ais.service.si.ISiteRentService;
import th.co.ais.service.si.ISiteSubRentService;
import th.co.ais.util.ELovType;
import th.co.ais.util.ELovVal;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.SsoBean;
import th.co.ais.web.bean.common.PopupSiteContractBean;
import th.co.ais.web.bean.common.PopupSiteLocationBean;
import th.co.ais.web.bean.common.PopupUploadFilePictureBean;
import th.co.ais.web.bean.common.PopupVendorSupplierBean;
import th.co.ais.web.common.action.PopupSiteContractAction;
import th.co.ais.web.common.action.PopupSiteLocationAction;
import th.co.ais.web.common.action.PopupViewSiteInfoAction;
import th.co.ais.web.el.bean.SEMMEL004Bean;
import th.co.ais.web.el.bean.SEMMEL005Bean;
import th.co.ais.web.el.bean.SEMMEL006Bean;
import th.co.ais.web.el.bean.SEMMEL010Bean;
import th.co.ais.web.el.bean.SEMMEL010_2Bean;
import th.co.ais.web.el.bean.SEMMEL011Bean;
import th.co.ais.web.report.util.DocumentExportManager;
import th.co.ais.web.si.action.SEMMSI004Tab1Action;
import th.co.ais.web.si.action.SEMMSI004Tab2Action;
import th.co.ais.web.si.action.SEMMSI004Tab3Action;
import th.co.ais.web.si.action.SEMMSI004Tab4Action;
import th.co.ais.web.si.action.SEMMSI004Tab5Action;
import th.co.ais.web.si.action.SEMMSI004Tab6Action;
import th.co.ais.web.si.action.SEMMSI004Tab7Action;
import th.co.ais.web.si.bean.SEMMSI001Bean;
import th.co.ais.web.si.bean.SEMMSI004Bean;
import th.co.ais.web.si.bean.SEMMSI004Tab1Bean;
import th.co.ais.web.si.bean.SEMMSI004Tab2Bean;
import th.co.ais.web.si.bean.SEMMSI004Tab3Bean;
import th.co.ais.web.si.bean.SEMMSI004Tab4Bean;
import th.co.ais.web.si.bean.SEMMSI004Tab5Bean;
import th.co.ais.web.si.bean.SEMMSI004Tab6Bean;
import th.co.ais.web.si.bean.SEMMSI004Tab7Bean;
import th.co.ais.web.util.CompanyCacheUtil;
import th.co.ais.web.util.ELUtils;
import th.co.ais.web.util.LOVCacheUtil;
import th.co.ais.web.util.MSGCacheUtil;
import th.co.ais.web.util.ProvinceCacheUtil;
import th.co.ais.web.util.RegionCacheUtil;

public class SEMMEL011Action extends AbstractAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8718332522013659195L;
	Logger log = Logger.getLogger(SEMMEL011Action.class);
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if (methodWithNavi.equalsIgnoreCase("doSearch")) {
			flag = doSearch();
		} else if (methodWithNavi.equalsIgnoreCase("doClear")) {
			flag = doClear();
		} else if (methodWithNavi.equalsIgnoreCase("initAddSiteInfo")) {
			flag = initAddSiteInfo();
		} else if(methodWithNavi.equalsIgnoreCase("doUpdateTab")){
			flag = doUpdateTab(true);
		} else if(methodWithNavi.equalsIgnoreCase("doDefaultEffDateFrom")){
			flag = doDefaultEffDateFrom();
		} else if(methodWithNavi.equalsIgnoreCase("doDefaultEffDateTo")){
			flag = doDefaultEffDateTo();
		} else if(methodWithNavi.equalsIgnoreCase("doDefaultExpDateFrom")){
			flag = doDefaultExpDateFrom();
		} else if(methodWithNavi.equalsIgnoreCase("doDefaultExpDateTo")){
			flag = doDefaultExpDateTo();
		} else if(methodWithNavi.equalsIgnoreCase("doClearSession")){
			flag = doClearSession();
		} else if(methodWithNavi.equalsIgnoreCase("doApprove")){
			flag = doApprove();
		} else if(methodWithNavi.equalsIgnoreCase("initChangeTab")){
			flag = initChangeTab();
		} else if(methodWithNavi.equalsIgnoreCase("setTabNo")){
			flag = setTabNo();
		} else if(methodWithNavi.equalsIgnoreCase("doCancelApprove")){
			flag = doCancelApprove();
//		}  else if(methodWithNavi.equalsIgnoreCase("doRunReport")){
//			runReport();
		}else if(methodWithNavi.equalsIgnoreCase("checkSiteInfo")){
			checkSiteInfo();
		}else if(methodWithNavi.equalsIgnoreCase("doGenDummy")){
			flag = doGenDummy();
		}else if(methodWithNavi.equalsIgnoreCase("doBackWard")){
			flag = doBackWard();
		}else if(methodWithNavi.equalsIgnoreCase("doSaveEditDummy")){
			flag = doSaveEditDummy();
		}else if(methodWithNavi.equalsIgnoreCase("doSelectContractNo")){
			flag = doSelectContractNo();
		}else if(methodWithNavi.equalsIgnoreCase("doTransfer")){
			flag = doTransfer();
		}else if(methodWithNavi.equalsIgnoreCase("doDeleteDummy")){
			flag = doDeleteDummy();
		}else if(methodWithNavi.equalsIgnoreCase("initDeleteDummy")){
			flag = initDeleteDummy();
		}else if(methodWithNavi.equalsIgnoreCase("renderedSiteName")){
			renderedSiteName();
		}
		
		
		
		return flag;
	}
	
	private PopupUploadFilePictureBean popupUploadFilePictureBean;
	
	public void setPopupUploadFilePictureBean(PopupUploadFilePictureBean popupUploadFilePictureBean) {
		this.popupUploadFilePictureBean = popupUploadFilePictureBean;
		getFacesUtils().setSessionMapValue("popupUploadFilePictureBean", popupUploadFilePictureBean);
	}		

	private boolean initChangeTab() {
		boolean flag = false;
		semmsi004Bean = getSemmsi004Bean();
		try{
			// set Temp
			semmsi004Bean.setTempTabNo(semmsi004Bean.getTabNo());
			String tabNo = (String)getFacesUtils().getRequestParameter("tabNo");
			String mode = semmsi004Bean.getMode();
			if(mode != null && mode.equals("EDIT")){
				// false == change
				if(checkValueChange()){
					log.debug("=====in function=====");
					semmsi004Bean.setValueChange(true);
					semmsi004Bean.setSelectedTab("tab" + tabNo);
					semmsi004Bean.setTabNo(tabNo);
					setSemmsi004Bean(semmsi004Bean);
					this.setTabNo();
				}else{
					log.debug("=====in else=====");
					semmsi004Bean.setValueChange(false);
					semmsi004Bean.setSelectedTab("tab" + tabNo);
					semmsi004Bean.setTabNo(tabNo);
					setSemmsi004Bean(semmsi004Bean);
					this.setTabNo();
				}
			}else{
				semmsi004Bean.setValueChange(false);
				semmsi004Bean.setSelectedTab("tab" + tabNo);
				semmsi004Bean.setTabNo(tabNo);
				setSemmsi004Bean(semmsi004Bean);
				this.setTabNo();
			}
			semmsi004Bean.setSelectedTab("tab" + tabNo);
			semmsi004Bean.setTabNo(tabNo);
			setSemmsi004Bean(semmsi004Bean);
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	private boolean doApprove() {
		boolean flag = false;
		
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		if(semmsi004tab5Bean == null){
			semmsi004tab5Bean = new SEMMSI004Tab5Bean();
		}
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		semmsi004Bean = getSemmsi004Bean();
		
		try{
			// save before approve
			String tabNo = semmsi004Bean.getTabNo();
			semmsi004Bean.setShowMessageSave(false);
			if(tabNo.equals("3")){
				flag = getSemmsi004tab3Action().autoSaveTab3();
			}else if(tabNo.equals("5")){
				flag = getSemmsi004tab5Action().autoSaveTab5();
			}else{
				flag = this.doUpdateTab(semmsi004Bean.isShowMessageSave());
			}
			// validate approve
			if(!flag || !getSemmsi004tab1Action().checkApproveSiteInfo()){
				semmsi004tab1Bean.setRenderedMsgFormSearch(true);
				semmsi004tab5Bean.setRenderedMsgFormMiddle(false);
				setSemmsi004tab1Bean(semmsi004tab1Bean);
				setSemmsi004tab5Bean(semmsi004tab5Bean);
				return flag;
			}
			String siteInfoId = getSemmsi004tab1Bean().getSiteInfo().getRowId();
			ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
			this.getSiteInfoByRowId(siteInfoId);
			semmsi004tab1Bean = getSemmsi004tab1Bean();
			// update site_info_status = 01
			if(semmsi004tab1Bean.getSiteInfo() != null){
				semmsi004tab1Bean.getSiteInfo().setSiteInfoStatus("01"); // approve
				semmsi004tab1Bean.getSiteInfo().setApproveDt(SEMDataUtility.getCurrentDate());
				semmsi004tab1Bean.setSiteInfo(service.updateSiteInfo(semmsi004tab1Bean.getSiteInfo()));
				
				approveSiteInfo(getSemmsi004Bean().getTabNo());
				
				addMessageInfo("M0005");
				
				// check enable button approve
				getSemmsi004tab1Action().checkEnableApprove(getSemmsi004tab1Bean().getSiteInfo().getRowId());
				
				// get site status name
				getSemmsi004tab1Action().getSiteStatusNameBySiteInfoId(siteInfoId);
				
				// update LatestFlag
				getSemmsi004tab1Action().updateLatestFlag();
				
				this.checkEditabledFlag();
			}
			
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0001");
		}
		semmsi004tab1Bean.setRenderedMsgFormSearch(true);
		semmsi004tab1Bean.setDisabledSiteName(true);
		semmsi004tab5Bean.setRenderedMsgFormMiddle(false);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		setSemmsi004tab5Bean(semmsi004tab5Bean);
		return flag;
	}
	
	private boolean doCancelApprove() {
		boolean flag = false;
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		if(semmsi004tab5Bean == null){
			semmsi004tab5Bean = new SEMMSI004Tab5Bean();
		}
		if(!getSemmsi004tab1Action().checkApproveSiteInfo()){
			semmsi004tab1Bean.setRenderedMsgFormSearch(true);
			semmsi004tab5Bean.setRenderedMsgFormMiddle(false);
			setSemmsi004tab1Bean(semmsi004tab1Bean);
			setSemmsi004tab5Bean(semmsi004tab5Bean);
			return flag;
		}
		try{
			String siteInfoId = getSemmsi004tab1Bean().getSiteInfo().getRowId();
			ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
			this.getSiteInfoByRowId(siteInfoId);
			semmsi004tab1Bean = getSemmsi004tab1Bean();
			// update site_info_status = 00
			if(semmsi004tab1Bean.getSiteInfo() != null){
				semmsi004tab1Bean.getSiteInfo().setSiteInfoStatus("00"); // waiting
				semmsi004tab1Bean.getSiteInfo().setApproveDt(null);
				semmsi004tab1Bean.setSiteInfo(service.updateSiteInfo(semmsi004tab1Bean.getSiteInfo()));
				addMessageInfo("W0093");
				
				// check enable button approve
				getSemmsi004tab1Action().checkEnableApprove(getSemmsi004tab1Bean().getSiteInfo().getRowId());
				
				// get site status name
				getSemmsi004tab1Action().getSiteStatusNameBySiteInfoId(siteInfoId);
				
				// update LatestFlag
				getSemmsi004tab1Action().updateLatestFlag();
				
				this.checkEditabledFlag();
			}
			
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0001");
		}
		semmsi004tab1Bean.setRenderedMsgFormSearch(true);
		semmsi004tab5Bean.setRenderedMsgFormMiddle(false);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		setSemmsi004tab5Bean(semmsi004tab5Bean);
		return flag;
	}

	public void checkEditabledFlag() {
		// check editabled flag
		String tabNo = getSemmsi004Bean().getTabNo();
		if(tabNo.equals("1")){
			getSemmsi004tab1Action().checkCancelableFlag();
			// check  enable drop down siteInfo status, editabled site,contract, property tax, electric
			getSemmsi004tab1Action().checkEnabledTab1();
		}else if(tabNo.equals("2")){
			// check editabled contract
			getSemmsi004tab2Action().checkEditableContract();
		}else if(tabNo.equals("3")){
			// check editabled rent
			getSemmsi004tab3Action().checkEditableRent();
			// check editabled deposit rent
			getSemmsi004tab3Action().checkEditableDepositRent();
			getSemmsi004tab3Action().initTab3(getSemmsi004tab1Bean().getSiteInfo().getRowId());
		}else if(tabNo.equals("4")){
			// check editabled property tax
			getSemmsi004tab1Action().checkEditableFlagPropertyTax();
		}else if(tabNo.equals("5")){
			// check editabled electric
			getSemmsi004tab1Action().checkEditableFlagElectric();
			// check editabled deposit electric
//			getSemmsi004tab5Action().checkMode();
			getSemmsi004tab5Action().initTab5(getSemmsi004tab1Bean().getSiteInfo().getRowId());
			
		}else if(tabNo.equals("6")){
			// check editabled insurance
			getSemmsi004tab6Action().checkEditableInsurance();
		}else{
			// tab 7 not check
		}
		
	}

	private boolean doDefaultExpDateTo() {
		boolean flag = false;
		Date expDateFrom = getSemmsi004Bean().getSiteInfoSP().getExpDateFrom();
		Date expDateTo = getSemmsi004Bean().getSiteInfoSP().getExpDateTo();
		log.info("expDateFrom :" + expDateFrom);
		log.info("expDateTo :" + expDateTo);
		if(expDateTo != null){
			if(expDateFrom == null){
				defaultExpFromToDt(expDateTo);
			}
		}else{
			getSemmsi004Bean().getSiteInfoSP().setExpDateFrom(null);
		}
		return flag;
	}

	private boolean doDefaultExpDateFrom() {
		boolean flag = false;
		Date expDateFrom = getSemmsi004Bean().getSiteInfoSP().getExpDateFrom();
		Date expDateTo = getSemmsi004Bean().getSiteInfoSP().getExpDateTo();
		log.info("expDateFrom :" + expDateFrom);
		log.info("expDateTo :" + expDateTo);
		if(expDateFrom != null){
			if(expDateTo == null){
				defaultExpFromToDt(expDateFrom);
			}
		}else{
			getSemmsi004Bean().getSiteInfoSP().setExpDateTo(null);
		}
		return flag;
	}
	
	private boolean defaultExpFromToDt(Date selDt){
		boolean flag = false;
		SEMMSI004Bean semmsi004Bean = getSemmsi004Bean();
		semmsi004Bean.getSiteInfoSP().setExpDateFrom(selDt);
		semmsi004Bean.getSiteInfoSP().setExpDateTo(selDt);
		setSemmsi004Bean(semmsi004Bean);
		return flag;
	}

	private boolean doDefaultEffDateTo() {
		boolean flag = false;
		Date effDateFrom = getSemmsi004Bean().getSiteInfoSP().getEffDateFrom();
		Date effDateTo = getSemmsi004Bean().getSiteInfoSP().getEffDateTo();
		log.info("effDateFrom :" + effDateFrom);
		log.info("effDateTo :" + effDateTo);
		
		if(effDateTo != null){
			if(effDateFrom == null){
				defaultEffFromToDt(effDateTo);
			}
		}else{
			getSemmsi004Bean().getSiteInfoSP().setEffDateFrom(null);
		}
		return flag;
	}

	private boolean doDefaultEffDateFrom() {
		boolean flag = false;
		Date effDateFrom = getSemmsi004Bean().getSiteInfoSP().getEffDateFrom();
		Date effDateTo = getSemmsi004Bean().getSiteInfoSP().getEffDateTo();
		log.info("effDateFrom :" + effDateFrom);
		log.info("effDateTo :" + effDateTo);
		
		if(effDateFrom != null){
			if(effDateTo == null){
				defaultEffFromToDt(effDateFrom);
			}
		}else{
			getSemmsi004Bean().getSiteInfoSP().setEffDateTo(null);
		}
		return flag;
	}
	private boolean defaultEffFromToDt(Date selDt){
		boolean flag = false;
		SEMMSI004Bean semmsi004Bean = getSemmsi004Bean();
		semmsi004Bean.getSiteInfoSP().setEffDateFrom(selDt);
		semmsi004Bean.getSiteInfoSP().setEffDateTo(selDt);
		setSemmsi004Bean(semmsi004Bean);
		return flag;
	}

	public boolean doUpdateTab(boolean showMessage) {
		boolean flag = false;
		semmsi004Bean = getSemmsi004Bean();
		semmsi004Bean.setShowMessageSave(showMessage);
		setSemmsi004Bean(semmsi004Bean);
		String tabNo = semmsi004Bean.getTabNo();
		try{
			if(tabNo != null && tabNo.equals("1")){
				flag = getSemmsi004tab1Action().doUpdateTab1();
			}else if(tabNo != null && tabNo.equals("2")){
				flag = getSemmsi004tab2Action().doUpdateTab2();
			}else if(tabNo != null && tabNo.equals("4")){
				flag = getSemmsi004tab4Action().doUpdateTab4();
			}else if(tabNo != null && tabNo.equals("5")){
				flag = getSemmsi004tab5Action().doUpdateTab5();
			}else if(tabNo != null && tabNo.equals("6")){
				flag = getSemmsi004tab6Action().doUpdateTab6();
			}
			if(flag){
				// update LatestFlag
				getSemmsi004tab1Action().updateLatestFlag();
			}
			// check enable button approve
			getSemmsi004tab1Action().checkEnableApprove(getSemmsi004tab1Bean().getSiteInfo().getRowId());
			
			// get site status name
			getSemmsi004tab1Action().getSiteStatusNameBySiteInfoId(getSemmsi004tab1Bean().getSiteInfo().getRowId());
			
			// check editable flag
			this.checkEditabledFlag();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return flag;
	}
	private boolean autoSaveTab() {
		boolean flag = false;
		semmsi004Bean = getSemmsi004Bean();
		try{
			String tabNo = getSemmsi004Bean().getTabNo();
			semmsi004Bean.setShowMessageSave(true);
			setSemmsi004Bean(semmsi004Bean);
			if(tabNo != null && tabNo.equals("1")){
				flag = getSemmsi004tab1Action().doUpdateTab1();
			}else if(tabNo != null && tabNo.equals("2")){
				flag = getSemmsi004tab2Action().doUpdateTab2();
			}else if(tabNo != null && tabNo.equals("3")){
				getSemmsi004tab3Action().autoSaveTab3();
				// no validate
				flag = true;
			}else if(tabNo != null && tabNo.equals("4")){
				getSemmsi004tab4Action().doUpdateTab4();
				// no validate
				flag = true;
			}else if(tabNo != null && tabNo.equals("5")){
				flag = getSemmsi004tab5Action().autoSaveTab5();
			}else if(tabNo != null && tabNo.equals("6")){
				flag = getSemmsi004tab6Action().doUpdateTab6();
			}
			// check enable button approve
			getSemmsi004tab1Action().checkEnableApprove(getSemmsi004tab1Bean().getSiteInfo().getRowId());
			
			// check editable flag
			this.checkEditabledFlag();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return flag;
	}

	public boolean setTabNo(){
		boolean flag = false;
		semmsi004Bean = getSemmsi004Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		String clickButton = (String)getFacesUtils().getRequestParameter("clickButton");
		// ONCHANG TAB DO SAVE
		if(semmsi004Bean.getMode() != null && semmsi004Bean.getMode().equals("EDIT")){
			if(semmsi004Bean.isValueChange() && (clickButton != null && clickButton.equals("Yes"))){
				semmsi004Bean.setSelectedTab(getSemmsi004Bean().getTabNo());
				semmsi004Bean.setTabNo(semmsi004Bean.getTempTabNo());
				setSemmsi004Bean(semmsi004Bean);
				flag = this.autoSaveTab();
				// check validate
				if(!flag){
					semmsi004Bean.setSelectedTab("tab" + semmsi004Bean.getTempTabNo());
					setSemmsi004Bean(semmsi004Bean);
					return flag;
				}else{
					String tabNo = (String)getFacesUtils().getRequestParameter("tabNo");
					// update LatestFlag
					getSemmsi004tab1Action().updateLatestFlag();
					semmsi004Bean.setSelectedTab("tab" + tabNo);
					semmsi004Bean.setTabNo(tabNo);
					setSemmsi004Bean(semmsi004Bean);
				}
			}
			if(clickButton != null && clickButton.equals("Cancel")){
				semmsi004Bean.setSelectedTab("tab" + semmsi004Bean.getTempTabNo());
				semmsi004Bean.setTabNo(semmsi004Bean.getTempTabNo());
			}
		}
		String tabNo = semmsi004Bean.getTabNo();
		semmsi004Bean.setSelectedTab("tab" + tabNo);
		
		if(tabNo.equals("1")){
			semmsi004Bean.setTabHeader(msg("message.tab.site"));
			semmsi004Bean.setRenderBtnSave(true);
			semmsi004Bean.setRenderPanelLog(true);
			getSemmsi004tab1Bean().setChkNoExpenses(false);
			getSemmsi004tab1Action().getDataTab1(semmsi004tab1Bean.getSiteInfo().getRowId());
			this.getDataContract(semmsi004tab1Bean.getSiteInfo().getRowId());
			getSemmsi004tab1Action().checkMode(semmsi004tab1Bean.getSiteInfo().getRowId());
			
		}else if(tabNo.equals("2")){
			semmsi004Bean.setTabHeader(msg("message.tab.contract"));
			semmsi004Bean.setRenderBtnSave(true);
			semmsi004Bean.setRenderPanelLog(true);
			getSemmsi004tab2Action().initTab2();
			
		}else if(tabNo.equals("3") || tabNo.equals("8")){
			semmsi004Bean.setTabHeader(msg("message.tab.rentAndService"));
			semmsi004Bean.setRenderBtnSave(false);
			semmsi004Bean.setRenderPanelLog(false);
			getSemmsi004tab3Action().initTab3(semmsi004tab1Bean.getSiteInfo().getRowId());
		}else if(tabNo.equals("4")){
			semmsi004Bean.setTabHeader(msg("message.tab.tax"));
			semmsi004Bean.setRenderBtnSave(true);
			semmsi004Bean.setRenderPanelLog(true);
			getSemmsi004tab4Action().initTab4(semmsi004tab1Bean.getSiteInfo().getRowId());
		}else if(tabNo.equals("5")){
			semmsi004Bean.setTabHeader(msg("message.tab.electric"));
			semmsi004Bean.setRenderBtnSave(true);
			semmsi004Bean.setRenderPanelLog(true);
			getSemmsi004tab5Action().initTab5(semmsi004tab1Bean.getSiteInfo().getRowId());
		}else if(tabNo.equals("6")){
			semmsi004Bean.setTabHeader(msg("message.tab.insurance"));
			semmsi004Bean.setRenderBtnSave(true);
			semmsi004Bean.setRenderPanelLog(true);
			getSemmsi004tab6Action().initTab6(semmsi004tab1Bean.getSiteInfo().getRowId());
		}else {
			semmsi004Bean.setTabHeader(msg("message.tab.rent"));
			semmsi004Bean.setRenderBtnSave(false);
			semmsi004Bean.setRenderPanelLog(false);
			getSemmsi004tab7Action().initTab7(semmsi004tab1Bean.getSiteInfo().getRowId());
		}
		
		if(semmsi004Bean.getMode() != null && semmsi004Bean.getMode().equals("VIEW")){
			semmsi004Bean.setRenderBtnSave(false);
		}
		setSemmsi004Bean(semmsi004Bean);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		
		return flag;
	}

	private boolean checkValueChange() {
		boolean flag = false;
		semmsi004Bean = getSemmsi004Bean();
		try{
			String tab = semmsi004Bean.getTempTabNo();
			if(tab.equals("1")){
				flag = getSemmsi004tab1Action().compareTab1();
			}else if(tab.equals("2")){
				flag = getSemmsi004tab2Action().compareTab2();
			}else if(tab.equals("3")){
				flag = getSemmsi004tab3Action().compareTab3();
			}else if(tab.equals("4")){
				flag = getSemmsi004tab4Action().compareTab4();
			}else if(tab.equals("5")){
				flag = getSemmsi004tab5Action().compareTab5();
			}else if(tab.equals("6")){
				flag = getSemmsi004tab6Action().compareTab6();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	private boolean doClearSession() {
		boolean flag = true;
		doSearch();
		semmsi004Bean = getSemmsi004Bean();
		semmsi004Bean.setDisabledLink(false);
		setSemmsi004Bean(semmsi004Bean);
		return flag;
	}

	private boolean initAddSiteInfo() {
//		popupViewSiteInfoBean = getPopupViewSiteInfoBean();
		boolean flag = true;
		semmsi004Bean = getSemmsi004Bean();
		String genDummyFlag = getFacesUtils().getRequestParameter("genDummyFlag") == null ? "" : (String)getFacesUtils().getRequestParameter("genDummyFlag");
		String company = "";
		String region = "";
		String locationId = "";
		String siteName = "";
		String siteStatus = "";
		String contractNo = "";
		String effDate = "";
		String expDate = "";
		String noExpireFlag = "";
		String siteInfoId = "";
		//set param 
		if("".equals(genDummyFlag)){
			 company = getFacesUtils().getRequestParameter("company") == null ? "" : (String)getFacesUtils().getRequestParameter("company");
			 region = getFacesUtils().getRequestParameter("region") == null ? "" : (String)getFacesUtils().getRequestParameter("region");
			 locationId = getFacesUtils().getRequestParameter("locationId") == null ? "": (String)getFacesUtils().getRequestParameter("locationId");
			 siteName = getFacesUtils().getRequestParameter("siteName") == null ? "" : (String)getFacesUtils().getRequestParameter("siteName");
			 siteStatus = getFacesUtils().getRequestParameter("siteStatus") == null ? "" : (String)getFacesUtils().getRequestParameter("siteStatus");
			 contractNo = getFacesUtils().getRequestParameter("contractNo") == null ? "" : (String)getFacesUtils().getRequestParameter("contractNo");
			 effDate = getFacesUtils().getRequestParameter("effDate") == null ? "" : (String)getFacesUtils().getRequestParameter("effDate");
			 expDate = getFacesUtils().getRequestParameter("expDate") == null ? "" : (String)getFacesUtils().getRequestParameter("expDate");
			 noExpireFlag = getFacesUtils().getRequestParameter("noExpireFlag") == null ? "" : (String)getFacesUtils().getRequestParameter("noExpireFlag");
			 siteInfoId = getFacesUtils().getRequestParameter("siteInfoId") == null ? "" : (String)getFacesUtils().getRequestParameter("siteInfoId");
		}else{
			if(semmsi004Bean.getSiteInfoData().getCompany() != null)
				company = semmsi004Bean.getSiteInfoData().getCompany();
			if(semmsi004Bean.getSiteInfoData().getRegion() != null)
				region = semmsi004Bean.getSiteInfoData().getRegion();
			if(semmsi004Bean.getSiteInfoData().getLocationId() != null)
				locationId = semmsi004Bean.getSiteInfoData().getLocationId();
			 siteName = getFacesUtils().getRequestParameter("siteName") == null ? "" : (String)getFacesUtils().getRequestParameter("siteName");
			 siteStatus = getFacesUtils().getRequestParameter("siteStatus") == null ? "" : (String)getFacesUtils().getRequestParameter("siteStatus");
			 contractNo = getFacesUtils().getRequestParameter("contractNo") == null ? "" : (String)getFacesUtils().getRequestParameter("contractNo");
			 effDate = getFacesUtils().getRequestParameter("effDate") == null ? "" : (String)getFacesUtils().getRequestParameter("effDate");
			 expDate = getFacesUtils().getRequestParameter("expDate") == null ? "" : (String)getFacesUtils().getRequestParameter("expDate");
			 noExpireFlag = getFacesUtils().getRequestParameter("noExpireFlag") == null ? "" : (String)getFacesUtils().getRequestParameter("noExpireFlag");
			 if(semmsi004Bean.getSiteInfoData().getSiteInfoId() != null)
				 siteInfoId = semmsi004Bean.getSiteInfoData().getSiteInfoId();
		}
		
	
		String mode = getFacesUtils().getRequestParameter("mode") == null ? "" : (String)getFacesUtils().getRequestParameter("mode");
		String page = getFacesUtils().getRequestParameter("page") == null ? "" : (String)getFacesUtils().getRequestParameter("page");
		ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
		List<SiteInfoSP> to = null;
		SiteInfoSP siteInfoSP = new SiteInfoSP();
		try {
			getSemmsi004tab1Action().init();
			getSemmsi004tab1Action().initTab1();
			getSemmsi004tab2Action().init();
			
			//semmsi004Bean.setSiteInfo(new SiteInfo());
//			semmsi004Bean.setSiteContract(new Contract());
//			semmsi004Bean.setSiteConstruct(new Construct());
//			semmsi004Bean.setSiteDeposit(new Deposit());
//			semmsi004Bean.setSiteElectric(new Electric());
//			semmsi004Bean.setSiteInfo(new SiteInfo());
//			semmsi004Bean.setSiteInsurance(new Insurance());
//			semmsi004Bean.setSiteLessor(new Lessor());
//			semmsi004Bean.setSitePropertyTax(new PropertyTax());
//			semmsi004Bean.setSiteRent(new Rent());
//			semmsi004Bean.setSiteRentCond(new RentCond());
//			semmsi004Bean.setSiteSubRent(new SubRent());
//			semmsi004Bean.getSiteInfoData().setContractNo(semmsi004Bean.getDummyContractId());
			semmsi004Bean.setPage(page);
			semmsi004Bean.setMode(mode);
//			
//			semmsi004Bean.setCompanyParam(company);
//			semmsi004Bean.setRegionParam(region);
			semmsi004Bean.setRenderTab1(true);
			semmsi004Bean.setRenderPanelLog(true);
			semmsi004Bean.setRenderBtnSave(true);
//			semmsi004Bean.setSelectedTab("tab1");
			semmsi004Bean.setTempTabNo("1");
			semmsi004Bean.setShowMessageSave(true);
			semmsi004tab1Bean = getSemmsi004tab1Bean();
			semmsi004tab1Bean.setDisabledSiteName(true);
			
			semmsi004tab2Bean = getSemmsi004tab2Action().getSemmsi004tab2Bean();
			//semmsi004tab2Bean = new SEMMSI004Tab2Bean();
			semmsi004tab2Bean.setContract(new Contract());
			semmsi004tab2Bean.setSiteLessor(new Lessor());
			semmsi004tab2Bean.setDisabledContractNo(false);
			semmsi004tab2Bean.setRenderedMsgFormMiddle(false);
			semmsi004tab2Bean.setDisabledChkDummyContract(false);
			semmsi004tab2Bean.setPeriodTypeList(getLovItemsByType(ELovType.T_CT_PERIOD_TYPE.name));
//			semmsi004tab2Bean.setContractDocTypeList(getLovItemsByType(ELovType.T_SI_CONTRACT_DOC_TYPE.name));
			semmsi004tab2Bean.setOwnerGroupList(getLovItemsByType(ELovType.T_SI_SITE_OWNER_GROUP.name));
			semmsi004tab2Bean.setDisabledEffDate(false);
			// GET DATA CONTRACT
			//this.getDataContract(siteInfoId);
			
			//init popupViewSiteInfoAction
			PopupViewSiteInfoAction popupViewSiteInfoAction = new PopupViewSiteInfoAction();
			popupViewSiteInfoAction.initial(semmsi004Bean.getSiteInfoId());
////			
			//siteInfoSP.setContractNo(semmsi004Bean.getDummyContractId());
			if(siteInfoId!=null && !siteInfoId.equals("")){
				siteInfoSP.setCompany(company);
				siteInfoSP.setSiteInfoId(siteInfoId);
				siteInfoSP.setRegion(region);
				siteInfoSP.setLocationId(locationId);
				siteInfoSP.setSiteName(siteName);
				siteInfoSP.setSiteStatus(siteStatus);
				siteInfoSP.setContractNo(contractNo);
				//siteInfoSP.setEffDate(convertYearENtoTHStr(siteInfo.getEffDate()));DateUtil
				siteInfoSP.setNoExpireFlag(noExpireFlag);
			}else{
				//search dummy
				this.doSearchDummy();
				siteInfoSP = semmsi004Bean.getSiteInfoData();
				siteInfoSP.setSiteInfoId(semmsi004Bean.getDummyContractId());
			}
			//srch dummy
			to = service.querySPList(EQueryName.SP_MEL011_SRCH_DUMMY_DTL.name, siteInfoSP);
			log.debug("size [" + to.size() + "]");
			
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsi004Bean.setRenderedMsgDataNotFound(true);
				semmsi004Bean.setSiteInfoSPList(null);
				semmsi004Bean.getSiteInfoData().setContractNo(semmsi004Bean.getDummyContractId());
			}
			
			if(to != null && to.size() > 0){
				semmsi004Bean.setRenderedMsgDataNotFound(false);
				semmsi004Bean.setSiteInfoSPList(new ArrayList<WrapperBeanObject<SiteInfoSP>>());
				for (int i = 0; i < to.size(); i++) {
					SiteInfoSP siteInfo = to.get(i);
					WrapperBeanObject<SiteInfoSP> tmpWrapperBean = new WrapperBeanObject<SiteInfoSP>();
					if(siteInfo.getChkNoExpireFlag() != null && "Y".equals(siteInfo.getChkNoExpireFlag())){
						semmsi004Bean.setChkNoExpireFlag(true);
					}
					if(siteInfo.getNoUnitPriceFlag() != null && "Y".equals(siteInfo.getNoUnitPriceFlag())){
						semmsi004tab1Bean.setChkNoUnitPriceFlag(true);
					}
					if(siteInfo.getEffDate() != null) {
//						siteInfo.setEffDate(convertYearENtoTH(siteInfo.getEffDate()));
						siteInfo.setEffDateStr(convertYearENtoTHStr(siteInfo.getEffDate()));
					}
					if(siteInfo.getExpDate() != null){
//						siteInfo.setExpDate(convertYearENtoTH(siteInfo.getExpDate()));
						siteInfo.setExpDateStr(convertYearENtoTHStr(siteInfo.getExpDate()));
					}
					if(siteInfo.getElectricType1() != null && siteInfo.getElectricType1().equals("Y")){
						semmsi004tab1Bean.setChkElectricType1(true);
					}
					if(siteInfo.getElectricType2() != null && siteInfo.getElectricType2().equals("Y")){
						semmsi004tab1Bean.setChkElectricType2(true);
					}
					if(siteInfo.getElectricType3() != null && siteInfo.getElectricType3().equals("Y")){
						semmsi004tab1Bean.setChkElectricType3(true);
					}
					if(siteInfo.getElectricType4() != null && siteInfo.getElectricType4().equals("Y")){
						semmsi004tab1Bean.setChkElectricType4(true);
					}
					if(siteInfo.getMultiElectricTypeFlag() != null && siteInfo.getMultiElectricTypeFlag().equals("Y")){
						semmsi004tab1Bean.setChkMultiElectricTypeFlag(true);
					}
					if(siteInfo.getElectricOwnerType() != null){
						semmsi004tab1Bean.getSiteElectric().setElectricOwnerType(siteInfo.getElectricOwnerType());
					}
					
					//vat type = null
					if(StringUtils.isEmpty(siteInfo.getVatType())){
						siteInfo.setVatType("");
					}
					
					if(siteInfo.getPayPeriodType() != null){
						if(siteInfo.getPayPeriodType().equals("01")){
							semmsi004tab1Bean.setPayPeriodType01(siteInfo.getPayPeriodType());
						}else if(siteInfo.getPayPeriodType().equals("02")){
							semmsi004tab1Bean.setPayPeriodType02(siteInfo.getPayPeriodType());
						}else if(siteInfo.getPayPeriodType().equals("03")){
							semmsi004tab1Bean.setPayPeriodType03(siteInfo.getPayPeriodType());
							semmsi004tab1Bean.setPayPeriod03(siteInfo.getPayPeriod());
						}else if(siteInfo.getPayPeriodType().equals("04")){
							semmsi004tab1Bean.setPayPeriod04(siteInfo.getPayPeriod());
							semmsi004tab1Bean.setPayPeriodType04(siteInfo.getPayPeriodType());
						}else if(siteInfo.getPayPeriodType().equals("05")){
							semmsi004tab1Bean.setPayPeriodType05(siteInfo.getPayPeriodType());
						}
						
					}
					
					this.renderElectricType3();
					this.renderElectricOwnerType();
					tmpWrapperBean.setDataObj(siteInfo);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					semmsi004Bean.setSiteInfoData(siteInfo);
					semmsi004Bean.getSiteInfoSPList().add(tmpWrapperBean);
				}
				
				semmsi004Bean.getSiteInfoData().setChkNoExpireFlag("Y");
				semmsi004Bean.getSiteInfoData().setChkOwnerContractFlag("Y");
				getSiteInfoMapLoc(siteInfoId);
				this.getSiteAmphurList();
				setSemmsi004Bean(semmsi004Bean);
				setSemmsi004tab1Bean(semmsi004tab1Bean);
			}
			
			//getSemmsi004tab1Action().getDataTab1(siteInfoId);
			//GET LOCATION LIST
//			getSiteInfoMapLoc(siteInfoId);
			// CHECK MODE VIEW/EDIT
			this.checkMode(mode);
			//this.checkEnabled();
//			this.getSiteAmphurList();
			getSemmsi004tab2Action().setSemmsi004tab2Bean(semmsi004tab2Bean);
//			setSemmsi004Bean(semmsi004Bean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			semmsi004Bean.setDisabledLink(false);
			setSemmsi004Bean(semmsi004Bean);
			service = null;
		}
		return flag;
	}
	
	public boolean doSearchDummy() {
		boolean flag = false;
		semmsi004Bean = getSemmsi004Bean();
//		if(!validateSearch()){
//			semmsi004Bean.setRenderedMsgFormSearch(true);
//			return flag;
//		}
		
		ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
		List<SiteInfoSP> to = null;
		SiteInfoSP siteinfoSP = new SiteInfoSP();
		try{
			if(semmsi004Bean.getSiteInfoData() != null){
				siteinfoSP = semmsi004Bean.getSiteInfoData();
			}
			if(semmsi004Bean.isExpireStatus()){
				siteinfoSP.setExpireStatus("Y");
			} else {
				siteinfoSP.setExpireStatus("N");
			}
			if(semmsi004Bean.isPendingStatus()){
				siteinfoSP.setPendingStatus("Y");
			} else {
				siteinfoSP.setPendingStatus("N");
			}
			if(semmsi004Bean.isChkCurrentFlag()){
				siteinfoSP.setCurrentFlag("Y");
			}else{
				siteinfoSP.setCurrentFlag("N");
			}
			
			if(semmsi004Bean.isChkNoExpireFlag()){
				siteinfoSP.setNoExpireFlag("Y");
			}else{
				siteinfoSP.setNoExpireFlag(null);
			}
//			semmsi004Bean.setSiteInfoData(semmsi004Bean.getSiteInfoSP());
			//to = service.querySPList(EQueryName.Q_SEARCH_SITE_INFO.name, semmsi004Bean.getSiteInfoSP());
			to = service.querySPList(EQueryName.SP_MEL011_SRCH_DUMMY.name, siteinfoSP);
			log.debug("size [" + to.size() + "]");
			
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsi004Bean.setRenderedMsgDataNotFound(true);
				semmsi004Bean.setSiteInfoSPList(null);
			}
			
			if(to != null && to.size() > 0){
				semmsi004Bean.setRenderedMsgDataNotFound(false);
				semmsi004Bean.setSiteInfoSPList(new ArrayList<WrapperBeanObject<SiteInfoSP>>());
				semmsi004Bean.setSiteInfoData(to.get(0));
//				for (int i = 0; i < to.size(); i++) {
//					SiteInfoSP siteInfo = to.get(i);
//					WrapperBeanObject<SiteInfoSP> tmpWrapperBean = new WrapperBeanObject<SiteInfoSP>();
//					if(siteInfo.getEffDate() != null) {
////						siteInfo.setEffDate(convertYearENtoTH(siteInfo.getEffDate()));
//						siteInfo.setEffDateStr(convertYearENtoTHStr(siteInfo.getEffDate()));
//					}
//					if(siteInfo.getExpDate() != null){
////						siteInfo.setExpDate(convertYearENtoTH(siteInfo.getExpDate()));
//						siteInfo.setExpDateStr(convertYearENtoTHStr(siteInfo.getExpDate()));
//					}
//					
//					tmpWrapperBean.setDataObj(siteInfo);
//					tmpWrapperBean.setMessage("");
//					tmpWrapperBean.setCheckBox(false);
//					semmsi004Bean.getSiteInfoSPList().add(tmpWrapperBean);
//				}
			}
				
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0003");
			semmsi004Bean.setRenderedMsgFormSearch(true);
		}
		
		setSemmsi004Bean(semmsi004Bean);
		
		return flag;
	}
	
	public void checkMode(String siteInfoId) {
		semmsi004Bean = getSemmsi004Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
//		semmsi004tab2Bean = getSemmsi004tab2Bean();
		semmsi004tab2Bean = getSemmsi004tab2Action().getSemmsi004tab2Bean();
		try{
			String mode = semmsi004Bean.getMode();
			if(mode != null && mode.equals("EDIT")){
				semmsi004Bean.setDisabledModeView(false);
				semmsi004Bean.setRenderedModeView(true);
				semmsi004Bean.setRenderBtnSave(true);
				semmsi004Bean.setRenderedBtnApprove(true);
				semmsi004Bean.setRenderedBtnCancelApprove(true);
				//this.checkEnabledPage();
				semmsi004tab1Bean.setDisabledElectric(false);
				semmsi004tab1Bean.setChkNoExpenses(false);
				setSemmsi004Bean(semmsi004Bean);
				setSemmsi004tab1Bean(semmsi004tab1Bean);
				getSemmsi004tab2Action().setSemmsi004tab2Bean(semmsi004tab2Bean);
				semmsi004Bean.setRenderBtnSave(true);
				semmsi004tab1Bean.setDisabledElectric(false);
				this.renderAge();
				checkNoExpenses();
				
			}else{
				// MODE VIEW
				semmsi004Bean.setRenderBtnSave(false);
				semmsi004Bean.setDisabledModeView(true);
				semmsi004tab1Bean.setDisabledSite(true);
				semmsi004tab1Bean.setDisabledElectric(true);
				semmsi004tab1Bean.setChkNoExpenses(true);
				semmsi004tab1Bean.setDisabledSiteContractNo(true);
				this.renderAge();
//				semmsi004tab1Bean.setDisabledPropertyTax(true);
//				semmsi004tab1Bean.setDisabledElectric(true);
//				semmsi004tab2Bean.setDisabledExpDate(true);
//				semmsi004Bean.setDisabledEffDate(true);
//				semmsi004tab2Bean.setDisabledEffDate(true);
//				semmsi004Bean.setRenderedBtnCopySiteInfo(false);
//				semmsi004tab2Bean.setDisabledChkDummyContract(true);
//				semmsi004Bean.setDisabledOldContractNo(true);
//				semmsi004Bean.setDisabledSiteType(true);
//				semmsi004tab1Bean.setDisabledUnitPriceAmt(true);
//				semmsi004tab1Bean.setDisabledTakeAllAmt(true);
//				semmsi004tab1Bean.setDisabledPayPeriod03(true);
//				semmsi004tab1Bean.setDisabledPayPeriod04(true);
//				semmsi004Bean.setRenderedModeView(false);
//				semmsi004tab1Bean.setRenderedBtnGenContractNo(false);
//				semmsi004tab2Bean.setDisabledContractNo(true);
//				semmsi004tab2Bean.setDisabledNoExpireFlag(true);
//				semmsi004tab2Bean.setDisabledAge(true);
//				semmsi004Bean.setDisabledModeView(true);
//				semmsi004tab1Bean.setDisabledPendingStatus(true);
//				semmsi004tab1Bean.setDisabledSiteInfoStatus(true);
//				semmsi004Bean.setRenderBtnSave(false);
//				semmsi004Bean.setRenderedBtnApprove(false);
//				semmsi004Bean.setRenderedBtnCancelApprove(false);
//				semmsi004tab1Bean.setDisabledPropertyTaxUndefined(true);
//				semmsi004tab1Bean.setDisabledPendingDate(true);
//				semmsi004tab1Bean.setDisabledTerminateDate(true);
//				// from page contract
//				if(semmsi004Bean.isRenderedBtnBackInternalContract()){
//					semmsi004Bean.setRenderedBtnBackContract(false);
//					semmsi004Bean.setRenderedBtnBackSiteInfo(false);
//				}else if(semmsi004Bean.getPage().equals("CONTRACT")){
//					semmsi004Bean.setRenderedBtnBackContract(true);
//					semmsi004Bean.setRenderedBtnBackContractSubRent(false);
//					semmsi004Bean.setRenderedBtnBackSiteInfo(false);
//				}else if(semmsi004Bean.getPage().equals("CONTRACT_SUBRENT")){
//					semmsi004Bean.setRenderedBtnBackContract(false);
//					semmsi004Bean.setRenderedBtnBackContractSubRent(true);
//					semmsi004Bean.setRenderedBtnBackSiteInfo(false);
//				}else{
//					semmsi004Bean.setRenderedBtnBackContract(false);
//					semmsi004Bean.setRenderedBtnBackContractSubRent(false);
//					semmsi004Bean.setRenderedBtnBackSiteInfo(true);
//				}
				checkNoExpenses();
			}
			
		}catch(Exception e){
			log.error(e);
			e.printStackTrace();
		}
		setSemmsi004Bean(semmsi004Bean);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		getSemmsi004tab2Action().setSemmsi004tab2Bean(semmsi004tab2Bean);
		
	}
	
	private void checkNoExpenses(){
		semmsi004Bean = getSemmsi004Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		//Check NoExpenses
		
		if("Y".equalsIgnoreCase(semmsi004Bean.getSiteInfoData().getElectricType3()) && "00".equals(semmsi004Bean.getSiteInfoData().getElectricOwnerType())){
			semmsi004Bean.getSiteInfoData().setChkNoExpenses("true");
			//semmsi004tab1Bean.setChkElectricType3(false);
			semmsi004Bean.getSiteInfoData().setElectricType3("false");
			semmsi004tab1Bean.setRenderedElectricOwnerType(false);
		}
		
		//semmsi004tab1Bean.disabledElectric semmsi004tab1Bean.chkNoExpenses
	}
	
	private boolean checkDepositElectric(String depositCondType) {
		boolean flag = false;
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		List<Msi004SrchDepositElectricSP> to = null;
		try{
			ISiteDepositService service = (ISiteDepositService)getBean("siteDepositService");
			Msi004SrchDepositElectricSP criteria = new Msi004SrchDepositElectricSP();
			criteria.setSiteInfoId(semmsi004tab1Bean.getSiteInfo().getRowId());
			criteria.setDepositType(null);
			criteria.setDepositCondType(depositCondType);
			to = service.querySPList(EQueryName.SP_MSI004_SRCH_DPST_E.name, criteria);
			log.debug("search electric depost  size [" + to.size() + "]");
			
			if(to != null && to.size() > 0){
				flag = true;
			}else{
				flag = false;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean renderElectricMutiType(){
		boolean flag = false;
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		semmsi004Bean = getSemmsi004Bean();
		// select only one checkbox
		if(!semmsi004tab1Bean.isChkMultiElectricTypeFlag()){
//			if(semmsi004tab1Bean.isChkElectricType1()){
				semmsi004tab1Bean.setChkElectricType1(false);
				semmsi004tab1Bean.setChkElectricType2(false);
				semmsi004tab1Bean.setChkElectricType3(false);
				semmsi004tab1Bean.setChkElectricType4(false);
				semmsi004Bean.getSiteInfoData().setElectricType1("N");
				semmsi004Bean.getSiteInfoData().setElectricType2("N");
				semmsi004Bean.getSiteInfoData().setElectricType3("N");
				semmsi004Bean.getSiteInfoData().setElectricType4("N");
//			}else{
//				semmsi004tab1Bean.setChkElectricType1(false);
//				semmsi004Bean.getSiteInfoData().setElectricType1("N");
//			}
			semmsi004tab1Bean.setRenderedElectricOwnerType(false);
			semmsi004tab1Bean.setDisabledSiteContractNo(true);
			// select manay checkbox
		}
			
		setElectricType();
		
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		setSemmsi004Bean(semmsi004Bean);	
		return flag;
	}
	
	public boolean renderElectricType1(){
		boolean flag = false;
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		semmsi004Bean = getSemmsi004Bean();
		// select only one checkbox
		if(!semmsi004tab1Bean.isChkMultiElectricTypeFlag()){
			if(semmsi004tab1Bean.isChkElectricType1()){
				semmsi004tab1Bean.setChkElectricType2(false);
				semmsi004tab1Bean.setChkElectricType3(false);
				semmsi004tab1Bean.setChkElectricType4(false);
				semmsi004Bean.getSiteInfoData().setElectricType1("Y");
				semmsi004Bean.getSiteInfoData().setElectricType2("");
				semmsi004Bean.getSiteInfoData().setElectricType3("");
				semmsi004Bean.getSiteInfoData().setElectricType4("");
				this.renderElectricType3();
			}else{
				semmsi004tab1Bean.setChkElectricType1(false);
				semmsi004Bean.getSiteInfoData().setElectricType1("");
			}
			semmsi004tab1Bean.setRenderedElectricOwnerType(false);
			semmsi004tab1Bean.setDisabledSiteContractNo(true);
			// select manay checkbox
		}else{
			// clear electric type2
			semmsi004tab1Bean.setChkElectricType2(false);
			if(semmsi004tab1Bean.isChkElectricType3()){
				semmsi004tab1Bean.setRenderedElectricOwnerType(true);
				if("00".equals(semmsi004tab1Bean.getSiteElectric().getElectricOwnerType())){
					semmsi004tab1Bean.setRenderedVatType(false);
				}else{
					semmsi004tab1Bean.setRenderedVatType(true);
				}
				semmsi004Bean.getSiteInfoData().setElectricType1("Y");
			}else{
				semmsi004tab1Bean.setRenderedElectricOwnerType(false);
				semmsi004tab1Bean.setRenderedVatType(false);
				semmsi004Bean.getSiteInfoData().setElectricType1("");
			}
			
			setElectricType();
		}
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		setSemmsi004Bean(semmsi004Bean);	
		return flag;
	}
	
	public boolean renderElectricType2(){
		boolean flag = false;
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		semmsi004Bean = getSemmsi004Bean();
		// select only one checkbox
		if(!semmsi004tab1Bean.isChkMultiElectricTypeFlag()){
			if(semmsi004tab1Bean.isChkElectricType2()){
				semmsi004tab1Bean.setChkElectricType1(false);
				semmsi004tab1Bean.setChkElectricType3(false);
				semmsi004tab1Bean.setChkElectricType4(false);
				semmsi004Bean.getSiteInfoData().setElectricType1("");
				semmsi004Bean.getSiteInfoData().setElectricType2("Y");
				semmsi004Bean.getSiteInfoData().setElectricType3("");
				semmsi004Bean.getSiteInfoData().setElectricType4("");
				semmsi004tab1Bean.setRenderedElectricOwnerType(false);
				this.renderElectricType3();
			}else{
				semmsi004tab1Bean.setChkElectricType2(false);
				semmsi004Bean.getSiteInfoData().setElectricType2("");
			}
			semmsi004tab1Bean.setDisabledSiteContractNo(true);
			// select manay checkbox
		}else{
			// clear electric type1
				semmsi004tab1Bean.setChkElectricType1(false);
			if(semmsi004tab1Bean.isChkElectricType3()){
				semmsi004tab1Bean.setRenderedElectricOwnerType(true);
				if("00".equals(semmsi004Bean.getSiteInfoData().getElectricOwnerType())){
					semmsi004tab1Bean.setRenderedVatType(false);
				}else{
					semmsi004tab1Bean.setRenderedVatType(true);
				}
				semmsi004Bean.getSiteInfoData().setElectricType2("Y");
			}else{
				semmsi004tab1Bean.setRenderedElectricOwnerType(false);
				semmsi004tab1Bean.setRenderedVatType(false);
				semmsi004Bean.getSiteInfoData().setElectricType2("");
			}
			setElectricType();
		}
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		setSemmsi004Bean(semmsi004Bean);	
		return flag;
	}
	
	public boolean renderElectricType3(){
		boolean flag = false;
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		semmsi004Bean = getSemmsi004Bean();
		// select only one checkbox
		if(!semmsi004tab1Bean.isChkMultiElectricTypeFlag()){
			if(semmsi004tab1Bean.isChkElectricType3()){
				semmsi004tab1Bean.setChkElectricType1(false);
				semmsi004tab1Bean.setChkElectricType2(false);
				semmsi004tab1Bean.setChkElectricType4(false);
				semmsi004tab1Bean.setRenderedElectricOwnerType(true);
				semmsi004tab1Bean.setRenderedVatType(true);
				semmsi004tab1Bean.setDisabledTakeAllAmt(true);
				semmsi004tab1Bean.setDisabledUnitPriceAmt(true);
				if(semmsi004Bean.getSiteInfoData().getElectricType3() == null ||
						"00".equals(semmsi004Bean.getSiteInfoData().getElectricOwnerType())){
					// default electric vatType and payPeriodType
					semmsi004Bean.getSiteInfoData().setElectricOwnerType("01");
					semmsi004Bean.getSiteInfoData().setVatType("");
					semmsi004tab1Bean.setPayPeriodType01("");
					semmsi004tab1Bean.setDisabledChkNoUnitPriceFlag(false);
				}else{
					if(semmsi004Bean.getSiteInfoData().getPayPeriodType() == null){
//						semmsi004tab1Bean.setPayPeriodType01("01");
					}
				}
//				semmsi004tab1Bean.siteElectric.electricOwnerType();
				semmsi004Bean.getSiteInfoData().setElectricType1("");
				semmsi004Bean.getSiteInfoData().setElectricType2("");
				semmsi004Bean.getSiteInfoData().setElectricType3("Y");
				semmsi004Bean.getSiteInfoData().setElectricType4("");
			}else{
				semmsi004tab1Bean.setChkElectricType3(false);
				semmsi004tab1Bean.setRenderedElectricOwnerType(false);
				semmsi004tab1Bean.setRenderedVatType(false);
				semmsi004Bean.getSiteInfoData().setElectricType3("");
				semmsi004tab1Bean.getSiteElectric().setElectricOwnerType("");
				semmsi004Bean.getSiteInfoData().setUnitPriceAmt(new BigDecimal(0));
				semmsi004Bean.getSiteInfoData().setTakeAllAmt(new BigDecimal(0));
				semmsi004Bean.getSiteInfoData().setTakeAllPeriodType("");
				semmsi004Bean.getSiteInfoData().setVatType("");
				semmsi004tab1Bean.setPayPeriodType01("01");
				semmsi004tab1Bean.setPayPeriodType02("");
				semmsi004tab1Bean.setPayPeriodType03("");
				semmsi004tab1Bean.setPayPeriodType04("");
				semmsi004tab1Bean.setPayPeriodType05("");
				semmsi004tab1Bean.setPayPeriod03(0);
				semmsi004tab1Bean.setPayPeriod04(0);
				semmsi004Bean.getSiteInfoData().setElectricOwnerType("");
				semmsi004Bean.getSiteInfoData().setVatType("01");
				semmsi004Bean.getSiteInfoData().setPayPeriodType01("");
				semmsi004Bean.getSiteInfoData().setPayPeriodType02("");
				semmsi004Bean.getSiteInfoData().setPayPeriodType03("");
				semmsi004Bean.getSiteInfoData().setPayPeriodType04("");
				semmsi004Bean.getSiteInfoData().setPayPeriodType05("");
				semmsi004tab1Bean.setChkNoUnitPriceFlag(false); 
				semmsi004tab1Bean.setDisabledUnitPriceAmt(true);
				semmsi004tab1Bean.setDisabledTakeAllAmt(true);
//				this.renderElectricOwnerType();
			}
			semmsi004tab1Bean.setDisabledSiteContractNo(true);
				
			// select manay checkbox
		}else{
			if(semmsi004tab1Bean.isChkElectricType3()){
				semmsi004tab1Bean.setRenderedElectricOwnerType(true);
				semmsi004tab1Bean.setRenderedVatType(true);
				semmsi004tab1Bean.setDisabledTakeAllAmt(true);
				if("00".equals(semmsi004Bean.getSiteInfoData().getElectricOwnerType())){
					semmsi004tab1Bean.setRenderedVatType(false);
				}else{
					semmsi004tab1Bean.setRenderedVatType(true);
				}
				if(semmsi004Bean.getSiteInfoData().getElectricType3() == null){
					// default electric vatType and payPeriodType
					semmsi004Bean.getSiteInfoData().setElectricOwnerType("01");
					semmsi004Bean.getSiteInfoData().setVatType("");
					semmsi004tab1Bean.setPayPeriodType01("01");
					semmsi004tab1Bean.setDisabledUnitPriceAmt(true);
					semmsi004tab1Bean.setDisabledChkNoUnitPriceFlag(false);
				}else{
					if(semmsi004Bean.getSiteInfoData().getPayPeriodType() == null){
						semmsi004tab1Bean.setPayPeriodType01("01");
					}
				}
				semmsi004Bean.getSiteInfoData().setElectricType3("Y");
			}else{
				semmsi004tab1Bean.setRenderedElectricOwnerType(false);
				semmsi004tab1Bean.setRenderedVatType(false);
				semmsi004Bean.getSiteInfoData().setElectricType3("");
				semmsi004tab1Bean.getSiteElectric().setElectricOwnerType("");
				semmsi004Bean.getSiteInfoData().setUnitPriceAmt(new BigDecimal(0));
				semmsi004Bean.getSiteInfoData().setTakeAllAmt(new BigDecimal(0));
				semmsi004Bean.getSiteInfoData().setTakeAllPeriodType("");
				semmsi004Bean.getSiteInfoData().setVatType("");
				semmsi004tab1Bean.setPayPeriod03(0);
				semmsi004tab1Bean.setPayPeriod04(0);
				semmsi004Bean.getSiteInfoData().setElectricOwnerType("");
				semmsi004Bean.getSiteInfoData().setVatType("01");
				semmsi004Bean.getSiteInfoData().setPayPeriodType01("");
				semmsi004Bean.getSiteInfoData().setPayPeriodType02("");
				semmsi004Bean.getSiteInfoData().setPayPeriodType03("");
				semmsi004Bean.getSiteInfoData().setPayPeriodType04("");
				semmsi004tab1Bean.setChkNoUnitPriceFlag(false); 
				semmsi004tab1Bean.setDisabledUnitPriceAmt(false);
//				this.renderElectricOwnerType();
			}
			setElectricType();
		}
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		setSemmsi004Bean(semmsi004Bean);	
		return flag;
	}
	
	public boolean renderElectricType4(){
		boolean flag = false;
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		semmsi004Bean = getSemmsi004Bean();
		// select only one checkbox
		if(!semmsi004tab1Bean.isChkMultiElectricTypeFlag()){
			if(semmsi004tab1Bean.isChkElectricType4()){
				
				semmsi004tab1Bean.setChkElectricType1(false);
				semmsi004tab1Bean.setChkElectricType2(false);
				semmsi004tab1Bean.setChkElectricType3(false);
				this.renderElectricType3();
				semmsi004Bean.getSiteInfoData().setElectricType1("");
				semmsi004Bean.getSiteInfoData().setElectricType2("");
				semmsi004Bean.getSiteInfoData().setElectricType3("");
				semmsi004Bean.getSiteInfoData().setElectricType4("Y");
				semmsi004tab1Bean.setRenderedElectricOwnerType(false);
				semmsi004tab1Bean.setDisabledSiteContractNo(false);
				
			}else{
				semmsi004tab1Bean.setChkElectricType4(false);
				semmsi004Bean.getSiteInfoData().setElectricType4("");
				semmsi004tab1Bean.setDisabledSiteContractNo(true);
			}
				
			// select manay checkbox
		}else{
			if(semmsi004tab1Bean.isChkElectricType3()){
				semmsi004tab1Bean.setRenderedElectricOwnerType(true);
				if("00".equals(semmsi004Bean.getSiteInfoData().getElectricOwnerType())){
					semmsi004tab1Bean.setRenderedVatType(false);
				}else{
					semmsi004tab1Bean.setRenderedVatType(true);
				}
				semmsi004Bean.getSiteInfoData().setElectricType4("Y");
			}else{
				semmsi004tab1Bean.setRenderedElectricOwnerType(false);
				semmsi004tab1Bean.setRenderedVatType(false);
				semmsi004Bean.getSiteInfoData().setElectricType4("");
			}
			setElectricType();
		}
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		setSemmsi004Bean(semmsi004Bean);	
		return flag;
	}
	
	public boolean renderChkElectricType(){
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		semmsi004Bean = getSemmsi004Bean();
		if(semmsi004tab1Bean.isChkNoExpenses()){
			semmsi004tab1Bean.setChkElectricType1(false);
			semmsi004tab1Bean.setChkElectricType2(false);
			semmsi004tab1Bean.setChkElectricType3(false);
			semmsi004tab1Bean.setChkElectricType4(false);
			semmsi004Bean.getSiteInfoData().setElectricType1("");
			semmsi004Bean.getSiteInfoData().setElectricType2("");
			semmsi004Bean.getSiteInfoData().setElectricType3("");
			semmsi004Bean.getSiteInfoData().setElectricType4("");
			semmsi004Bean.getSiteInfoData().setMultiElectricTypeFlag("");
			semmsi004tab1Bean.setChkMultiElectricTypeFlag(false);
			semmsi004tab1Bean.setRenderedElectricOwnerType(false);
			semmsi004tab1Bean.getSiteElectric().setElectricOwnerType("00");
			semmsi004tab1Bean.getSiteElectric().setVatType("01");
			semmsi004tab1Bean.setPayPeriodType01("01");
			semmsi004tab1Bean.getSiteElectric().setElectricType3("Y");
			semmsi004tab1Bean.setDisabledSiteContractNo(true);
			semmsi004tab1Bean.setDisabledUnitPriceAmt(true);
			semmsi004tab1Bean.setDisabledTakeAllAmt(true);
			semmsi004tab1Bean.setRenderedVatType(false);
			
		}
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		return false;
	}
	private void clearElectricOwnerType() {
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		semmsi004tab1Bean.getSiteElectric().setElectricType3(null);
		semmsi004tab1Bean.getSiteElectric().setUnitPriceAmt(null);
		semmsi004tab1Bean.getSiteElectric().setNoUnitPriceFlag("");
		semmsi004tab1Bean.getSiteElectric().setTakeAllAmt(null);
		semmsi004tab1Bean.getSiteElectric().setTakeAllPeriodType(null);
		semmsi004tab1Bean.getSiteElectric().setElectricOwnerType(null);
		semmsi004tab1Bean.getSiteElectric().setEffectiveDt(null);
		semmsi004tab1Bean.getSiteElectric().setPayPeriodType(null);
		semmsi004tab1Bean.getSiteElectric().setPayPeriod(null);
		semmsi004tab1Bean.getSiteElectric().setVatType(null);
		semmsi004tab1Bean.getSiteElectric().setNoDeposit(null);
		semmsi004tab1Bean.setPayPeriod03(null);
		semmsi004tab1Bean.setPayPeriod04(null);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
	}
	
	public boolean reRenderNoUnitPriceFlag(){
		boolean flag = false;
		semmsi004Bean = getSemmsi004Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		try{
			if(semmsi004tab1Bean.isChkNoUnitPriceFlag()){
				semmsi004Bean.getSiteInfoData().setUnitPriceAmt(new BigDecimal(0));
			}else
				semmsi004Bean.getSiteInfoData().setUnitPriceAmt(new BigDecimal(0));
		}catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			setSemmsi004Bean(semmsi004Bean);
			setSemmsi004tab1Bean(semmsi004tab1Bean);
		}
		return flag;
	}
	
	public boolean renderElectricOwnerType(){
		boolean flag = false;
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		semmsi004Bean = getSemmsi004Bean();
		String electricOwnerType = semmsi004tab1Bean.getSiteElectric().getElectricOwnerType();
		if(electricOwnerType != null){
			if(electricOwnerType.equals("01")){
				semmsi004tab1Bean.setDisabledUnitPriceAmt(false);
				semmsi004tab1Bean.setDisabledChkNoUnitPriceFlag(false);
//				semmsi004tab1Bean.getSiteElectric().setVatType("01");
//				semmsi004Bean.getSiteInfoData().setVatType("01");
				semmsi004Bean.getSiteInfoData().setElectricOwnerType("01");
//				semmsi004Bean.getSiteInfoData().setPayPeriodType01("01");
//				semmsi004Bean.getSiteInfoData().setPayPeriodType02("");
//				semmsi004Bean.getSiteInfoData().setPayPeriodType03("");
//				semmsi004Bean.getSiteInfoData().setPayPeriodType04("");
//				semmsi004tab1Bean.setPayPeriodType01("01");
//				semmsi004tab1Bean.setPayPeriodType02(null);
//				semmsi004tab1Bean.setPayPeriodType03(null);
//				semmsi004tab1Bean.setPayPeriodType04(null);
//				semmsi004tab1Bean.setPayPeriodType05(null);
//				semmsi004tab1Bean.setPayPeriod03(null);
//				semmsi004tab1Bean.setPayPeriod04(null);
				semmsi004tab1Bean.setDisabledPayPeriod03(true);
				semmsi004tab1Bean.setDisabledPayPeriod04(true);
			}else{
				semmsi004tab1Bean.setDisabledUnitPriceAmt(true);
				semmsi004tab1Bean.setDisabledChkNoUnitPriceFlag(true);
				semmsi004tab1Bean.setChkNoUnitPriceFlag(false);
			}
			
			if(electricOwnerType.equals("02")){
				semmsi004tab1Bean.setDisabledTakeAllAmt(false);
				semmsi004Bean.getSiteInfoData().setElectricOwnerType("02");
//				semmsi004Bean.getSiteInfoData().setVatType("01");
//				semmsi004Bean.getSiteInfoData().setPayPeriodType01("01");
//				semmsi004Bean.getSiteInfoData().setPayPeriodType02("");
//				semmsi004Bean.getSiteInfoData().setPayPeriodType03("");
//				semmsi004Bean.getSiteInfoData().setPayPeriodType04("");
//				semmsi004tab1Bean.getSiteElectric().setVatType("01");
//				semmsi004tab1Bean.setPayPeriodType01("01");
//				semmsi004tab1Bean.setPayPeriodType02(null);
//				semmsi004tab1Bean.setPayPeriodType03(null);
//				semmsi004tab1Bean.setPayPeriodType04(null);
//				semmsi004tab1Bean.setPayPeriodType05(null);
//				semmsi004tab1Bean.setPayPeriod03(null);
//				semmsi004tab1Bean.setPayPeriod04(null);
				semmsi004tab1Bean.setDisabledPayPeriod03(true);
				semmsi004tab1Bean.setDisabledPayPeriod04(true);
			}else{
				semmsi004tab1Bean.setDisabledTakeAllAmt(true);
			}
			if(electricOwnerType.equals("00")){
				semmsi004tab1Bean.setDisabledUnitPriceAmt(true);
				semmsi004tab1Bean.setDisabledTakeAllAmt(true);
				semmsi004tab1Bean.setRenderedVatType(false);
			}else{
				semmsi004tab1Bean.setRenderedVatType(true);
			}
			semmsi004tab1Bean.getSiteElectric().setUnitPriceAmt(null);
			semmsi004tab1Bean.getSiteElectric().setTakeAllAmt(null);
			semmsi004tab1Bean.getSiteElectric().setTakeAllPeriodType("");
			semmsi004Bean.getSiteInfoData().setUnitPriceAmt(null);
			semmsi004Bean.getSiteInfoData().setTakeAllAmt(null);
			semmsi004Bean.getSiteInfoData().setTakeAllPeriodType("");
		}
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		setSemmsi004Bean(semmsi004Bean);
		return flag;
	}
	
	public boolean renderPayPeriodType(){
		boolean flag = false;
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		semmsi004Bean = getSemmsi004Bean();
		try{
			String payPeriodType = (String)getFacesUtils().getRequestParameter("payPeriodType");
			if(payPeriodType.equals("01")){
				semmsi004Bean.getSiteInfoData().setPayPeriodType(semmsi004tab1Bean.getPayPeriodType01());
				
				semmsi004Bean.getSiteInfoData().setPayPeriodType01(semmsi004tab1Bean.getPayPeriodType01());
				
				semmsi004Bean.getSiteInfoData().setPayPeriodType02("");
				semmsi004Bean.getSiteInfoData().setPayPeriodType03("");
				semmsi004Bean.getSiteInfoData().setPayPeriodType04("");
				semmsi004Bean.getSiteInfoData().setPayPeriodType05("");
				semmsi004Bean.getSiteInfoData().setPayPeriod03(null);
				semmsi004Bean.getSiteInfoData().setPayPeriod04(null);
				semmsi004tab1Bean.setPayPeriodType02("");
				semmsi004tab1Bean.setPayPeriodType03("");
				semmsi004tab1Bean.setPayPeriodType04("");
				semmsi004tab1Bean.setPayPeriodType05("");
				semmsi004tab1Bean.setPayPeriod03(null);
				semmsi004tab1Bean.setPayPeriod04(null);
				semmsi004Bean.getSiteInfoData().setPayPeriod(null);
				semmsi004tab1Bean.setDisabledPayPeriod03(true);
				semmsi004tab1Bean.setDisabledPayPeriod04(true);
			}
			if(payPeriodType.equals("02")){
				semmsi004Bean.getSiteInfoData().setPayPeriodType(semmsi004tab1Bean.getPayPeriodType02());
				semmsi004Bean.getSiteInfoData().setPayPeriodType02(semmsi004tab1Bean.getPayPeriodType02());
				semmsi004Bean.getSiteInfoData().setPayPeriodType01("");
				semmsi004Bean.getSiteInfoData().setPayPeriodType03("");
				semmsi004Bean.getSiteInfoData().setPayPeriodType04("");
				semmsi004Bean.getSiteInfoData().setPayPeriodType05("");
				semmsi004Bean.getSiteInfoData().setPayPeriod03(null);
				semmsi004Bean.getSiteInfoData().setPayPeriod04(null);
				semmsi004tab1Bean.setPayPeriodType01("");
				semmsi004tab1Bean.setPayPeriodType03("");
				semmsi004tab1Bean.setPayPeriodType04("");
				semmsi004tab1Bean.setPayPeriodType05("");
				semmsi004tab1Bean.setPayPeriod03(null);
				semmsi004tab1Bean.setPayPeriod04(null);
				semmsi004Bean.getSiteInfoData().setPayPeriod(null);
				semmsi004tab1Bean.setDisabledPayPeriod03(true);
				semmsi004tab1Bean.setDisabledPayPeriod04(true);
			}
			if(payPeriodType.equals("03") ){
				semmsi004Bean.getSiteInfoData().setPayPeriodType(semmsi004tab1Bean.getPayPeriodType03());
				semmsi004Bean.getSiteInfoData().setPayPeriodType03(semmsi004tab1Bean.getPayPeriodType03());
				if(semmsi004tab1Bean.getPayPeriod03() != null){
					semmsi004tab1Bean.getSiteElectric().setPayPeriod(semmsi004tab1Bean.getPayPeriod03());
					semmsi004Bean.getSiteInfoData().setPayPeriod(semmsi004tab1Bean.getPayPeriod03());
				}
				semmsi004Bean.getSiteInfoData().setPayPeriodType01("");
				semmsi004Bean.getSiteInfoData().setPayPeriodType02("");
				semmsi004Bean.getSiteInfoData().setPayPeriodType04("");
				semmsi004Bean.getSiteInfoData().setPayPeriodType05("");
				semmsi004Bean.getSiteInfoData().setPayPeriod03(null);
				semmsi004Bean.getSiteInfoData().setPayPeriod04(null);
				semmsi004tab1Bean.setPayPeriodType01("");
				semmsi004tab1Bean.setPayPeriodType02("");
				semmsi004tab1Bean.setPayPeriodType04("");
				semmsi004tab1Bean.setPayPeriodType05("");
				semmsi004tab1Bean.setPayPeriod03(null);
				semmsi004tab1Bean.setPayPeriod04(null);
				semmsi004tab1Bean.setDisabledPayPeriod03(false);
				semmsi004tab1Bean.setDisabledPayPeriod04(true);
			}
			if(payPeriodType.equals("04")){
				semmsi004Bean.getSiteInfoData().setPayPeriodType(semmsi004tab1Bean.getPayPeriodType04());
				semmsi004Bean.getSiteInfoData().setPayPeriodType04(semmsi004tab1Bean.getPayPeriodType04());
				if(semmsi004tab1Bean.getPayPeriod04() != null){
					semmsi004tab1Bean.getSiteElectric().setPayPeriod(semmsi004tab1Bean.getPayPeriod04());
					semmsi004Bean.getSiteInfoData().setPayPeriod(semmsi004tab1Bean.getPayPeriod04());
				}
				semmsi004Bean.getSiteInfoData().setPayPeriodType01("");
				semmsi004Bean.getSiteInfoData().setPayPeriodType02("");
				semmsi004Bean.getSiteInfoData().setPayPeriodType03("");
				semmsi004Bean.getSiteInfoData().setPayPeriodType05("");
				semmsi004Bean.getSiteInfoData().setPayPeriod03(null);
				semmsi004Bean.getSiteInfoData().setPayPeriod04(null);
				semmsi004tab1Bean.setPayPeriodType01("");
				semmsi004tab1Bean.setPayPeriodType02("");
				semmsi004tab1Bean.setPayPeriodType03("");
				semmsi004tab1Bean.setPayPeriodType05("");
				semmsi004tab1Bean.setPayPeriod03(null);
				semmsi004tab1Bean.setPayPeriod04(null);
				semmsi004tab1Bean.setDisabledPayPeriod03(true);
				semmsi004tab1Bean.setDisabledPayPeriod04(false);
			}
			if(payPeriodType.equals("05")){
				semmsi004Bean.getSiteInfoData().setPayPeriodType(semmsi004tab1Bean.getPayPeriodType05());
				semmsi004Bean.getSiteInfoData().setPayPeriodType05(semmsi004tab1Bean.getPayPeriodType05());
				semmsi004Bean.getSiteInfoData().setPayPeriodType01("");
				semmsi004Bean.getSiteInfoData().setPayPeriodType02("");
				semmsi004Bean.getSiteInfoData().setPayPeriodType03("");
				semmsi004Bean.getSiteInfoData().setPayPeriodType04("");
				semmsi004Bean.getSiteInfoData().setPayPeriod03(null);
				semmsi004Bean.getSiteInfoData().setPayPeriod04(null);
				semmsi004tab1Bean.setPayPeriodType01("");
				semmsi004tab1Bean.setPayPeriodType02("");
				semmsi004tab1Bean.setPayPeriodType03("");
				semmsi004tab1Bean.setPayPeriodType04("");
				semmsi004tab1Bean.setPayPeriod03(null);
				semmsi004tab1Bean.setPayPeriod04(null);
				semmsi004Bean.getSiteInfoData().setPayPeriod(null);
				semmsi004tab1Bean.setDisabledPayPeriod03(true);
				semmsi004tab1Bean.setDisabledPayPeriod04(true);
			}
			semmsi004tab1Bean.getSiteElectric().setPayPeriodType(payPeriodType);
			semmsi004Bean.getSiteInfoData().setPayPeriodType(payPeriodType);
			setSemmsi004tab1Bean(semmsi004tab1Bean);
			setSemmsi004Bean(semmsi004Bean);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public void setElectricType(){
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		semmsi004Bean = getSemmsi004Bean();
		if(semmsi004tab1Bean.isChkElectricType1()){
			semmsi004Bean.getSiteInfoData().setElectricType1("Y");
		}else{
			semmsi004Bean.getSiteInfoData().setElectricType1("");
		}
		if(semmsi004tab1Bean.isChkElectricType2()){
			semmsi004Bean.getSiteInfoData().setElectricType2("Y");
		}else{
			semmsi004Bean.getSiteInfoData().setElectricType2("");
		}
		if(semmsi004tab1Bean.isChkElectricType3() || semmsi004tab1Bean.isChkNoExpenses()){
			semmsi004Bean.getSiteInfoData().setElectricType3("Y");
		}else{
			this.clearElectricOwnerType();
		}
		if(semmsi004tab1Bean.isChkElectricType4()){
			semmsi004Bean.getSiteInfoData().setElectricType4("Y");
			semmsi004tab1Bean.setDisabledSiteContractNo(false);
		}else{
			semmsi004Bean.getSiteInfoData().setElectricType4("");
			semmsi004tab1Bean.setDisabledSiteContractNo(true);
		}
		if(semmsi004tab1Bean.isChkMultiElectricTypeFlag()){
			semmsi004Bean.getSiteInfoData().setMultiElectricTypeFlag("Y");
		}else{
			semmsi004Bean.getSiteInfoData().setMultiElectricTypeFlag("");
		}
		if(semmsi004tab1Bean.getSiteElectric().getElectricOwnerType() != null){
			if(semmsi004tab1Bean.getSiteElectric().getElectricOwnerType().equals("01")){
				semmsi004Bean.getSiteInfoData().setElectricOwnerType("01");
			}else if(semmsi004tab1Bean.getSiteElectric().getElectricOwnerType().equals("02")){
				semmsi004Bean.getSiteInfoData().setElectricOwnerType("02");
			}
		}
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		setSemmsi004Bean(semmsi004Bean);
	}
	
	public boolean renderAge(){
		boolean flag = false;
		semmsi004Bean = getSemmsi004Bean();
//		semmsi004tab2Bean = getSemmsi004tab2Action().getSemmsi004tab2Bean();
		if(semmsi004Bean.isChkNoExpireFlag()){
			semmsi004Bean.setDisabledExpDate(true);
//			semmsi004tab2Bean.setRenderStarImage(false);
			semmsi004Bean.getSiteInfoData().setAgeYear(null);
			semmsi004Bean.getSiteInfoData().setAgeMonth(null);
			semmsi004Bean.getSiteInfoData().setAgeDay(null);
			semmsi004Bean.getSiteInfoData().setExpDate(null);
			//check and put value in firstEFFDate
			if(semmsi004Bean.getSiteInfoData().getFristEffDT() == null){
				semmsi004Bean.getSiteInfoData().setFristEffDT(semmsi004Bean.getSiteInfoData().getEffDate());
			}
		}else{
			this.getSiteContractBySiteInfoId(semmsi004Bean.getSiteInfoData().getRowId());
			Date effDate = semmsi004Bean.getSiteInfoData().getEffDate();
			Date expDate = semmsi004Bean.getSiteInfoData().getExpDate();
			if(effDate != null && expDate != null){
				this.calAgeContract(effDate, expDate);
			}
			semmsi004Bean.setDisabledExpDate(false);
//			semmsi004tab2Bean.setRenderStarImage(true);
		}
//		getSemmsi004tab2Action().setSemmsi004tab2Bean(semmsi004tab2Bean);
		setSemmsi004Bean(semmsi004Bean);
//		log.debug("semmsi004tab2Bean.getSiteContract().getFirstEffectiveDt() = "+semmsi004Bean.getSiteInfoData().getFristEffDT());
		return flag;
	}
	
	public boolean calAge(){
		boolean flag = false;
		semmsi004Bean = getSemmsi004Bean();
		try{
			Date effDate = semmsi004Bean.getSiteInfoData().getEffDate();
			Date expDate = semmsi004Bean.getSiteInfoData().getExpDate();
			if(effDate != null && expDate != null){
				if (effDate.after(expDate)) {
					addMessageErrorWithArgument("W0005" ,msg("message.contractEffDate"), msg("message.contractExpDate"));
					flag = false;
				}else{
					semmsi004Bean = getSemmsi004Bean();
					this.calAgeContract(effDate, expDate);
					if(semmsi004Bean.getReqTypeParam() != null){
						if (semmsi004Bean.getReqTypeParam().equals("01")) {
							semmsi004Bean.getSiteInfoData().setFristEffDT(effDate);
						}
					}
					this.getSumRent();
					
				}
			}else{
				semmsi004Bean.getSiteInfoData().setAgeYear(null);
				semmsi004Bean.getSiteInfoData().setAgeMonth(null);
				semmsi004Bean.getSiteInfoData().setAgeDay(null);
				if(effDate != null) semmsi004Bean.getSiteInfoData().setFristEffDT(effDate);
			} 
			
		}catch(Exception e){
			e.printStackTrace();
		}
//		setSemmsi004tab2Bean(semmsi004tab2Bean);
		setSemmsi004Bean(semmsi004Bean);
		return flag;
	}
	
	private void getSumRent() {
		semmsi004Bean = getSemmsi004Bean();
//		semmsi004tab2Bean = getSemmsi004tab2Bean();
		try{
			List<Msi004SrchSumRentAgeSP> to = null;
			ISiteRentService service = (ISiteRentService)getBean("siteRentService");
			Msi004SrchSumRentAgeSP criteria = new Msi004SrchSumRentAgeSP();
			criteria.setSiteInfoId(semmsi004Bean.getSiteInfoData().getRowId());
			criteria.setAgeYear(semmsi004Bean.getSiteInfoData().getAgeYear());
			criteria.setAgeMonth(semmsi004Bean.getSiteInfoData().getAgeMonth());
			criteria.setAgeDay(semmsi004Bean.getSiteInfoData().getAgeDay());
			
			to = service.querySPList(EQueryName.SP_MSI004_SRCH_SUM_RENT_A.name, criteria);
			if(to != null && to.size() > 0){
				semmsi004Bean.setSiteRent(new Rent());
				Msi004SrchSumRentAgeSP sumRent = to.get(0);
				if(sumRent.getAgeRentAmt() != null)
					semmsi004Bean.getSiteRent().setTotalAgeRentAmt(sumRent.getAgeRentAmt());
				if(sumRent.getAgeServiceAmt() != null)
					semmsi004Bean.getSiteRent().setTotalAgeServiceAmt(sumRent.getAgeServiceAmt());
				if(sumRent.getAgeRentServiceAmt() != null)
					semmsi004Bean.getSiteRent().setTotalAgeRentServiceAmt(sumRent.getAgeRentServiceAmt());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004Bean(semmsi004Bean);
		
	}
	
	private void calAgeContract(Date effDate, Date expDate) {
//		semmsi004tab2Bean = getSemmsi004tab2Action().getSemmsi004tab2Bean();
		semmsi004Bean = getSemmsi004Bean();
		// CALL MSI004_CALC_AGE
		ISiteContractService service = (ISiteContractService)getBean("siteContractService");
		List<Msi004CalcAgeSP> to = null;
		semmsi004Bean.getSiteInfoData().setAgeYear(null);
		semmsi004Bean.getSiteInfoData().setAgeMonth(null);
		semmsi004Bean.getSiteInfoData().setAgeDay(null);
		try{
			Msi004CalcAgeSP criteria = new Msi004CalcAgeSP();
			criteria.setEffDate(effDate);
			criteria.setExpDate(expDate);
			to = service.querySPList(EQueryName.SP_MSI004_CALC_AGE.name, criteria);
			if(to != null && to.size() > 0){
				Msi004CalcAgeSP cal = to.get(0);
				if(cal.getAgeYear() != null){
					semmsi004Bean.getSiteInfoData().setAgeYear(cal.getAgeYear());
				}
				if(cal.getAgeMonth() != null){
					semmsi004Bean.getSiteInfoData().setAgeMonth(cal.getAgeMonth());
				}
				if(cal.getAgeDay() != null){
					semmsi004Bean.getSiteInfoData().setAgeDay(cal.getAgeDay());
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
//		getSemmsi004tab2Action().setSemmsi004tab2Bean(semmsi004tab2Bean);
		setSemmsi004Bean(semmsi004Bean);
	}
	
	public void getDataContract(String siteInfoId) {
		semmsi004tab2Bean = getSemmsi004tab2Action().getSemmsi004tab2Bean();
		semmsi004tab2Bean.setContractNo1("");
		semmsi004tab2Bean.setContractNo2("");
		semmsi004tab2Bean.setContractNo3("");
		setSemmsi004tab2Bean(semmsi004tab2Bean);
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		try{
			this.getSiteContractBySiteInfoId(siteInfoId);
			semmsi004Bean = getSemmsi004Bean();
			if(getSemmsi004Bean().getSiteContract() != null){
				semmsi004tab2Bean.setSiteContract(new Contract());
				semmsi004tab2Bean.setSiteContract(semmsi004Bean.getSiteContract());
				// set tempContractNo
				if(semmsi004tab2Bean.getSiteContract().getContractNo() != null){
					semmsi004tab2Bean.setTempContractNo(semmsi004tab2Bean.getSiteContract().getContractNo());
				}
				
					semmsi004tab2Bean.setChkDummyFlag(true);
				
				if(semmsi004tab2Bean.getSiteContract().getOwnerContractFlag() != null && 
						semmsi004tab2Bean.getSiteContract().getOwnerContractFlag().equals("Y")){
						semmsi004tab2Bean.setChkOwnerContractFlag(true);
					}else{
						semmsi004tab2Bean.setChkOwnerContractFlag(false);
					}
				if(semmsi004tab2Bean.getSiteContract().getAgeDay() != null && semmsi004tab2Bean.getSiteContract().getAgeDay() == 0){
					semmsi004tab2Bean.getSiteContract().setAgeDay(null);
				}
				if(semmsi004tab2Bean.getSiteContract().getAgeMonth() != null && semmsi004tab2Bean.getSiteContract().getAgeMonth() == 0){
					semmsi004tab2Bean.getSiteContract().setAgeMonth(null);
				}
				if(semmsi004tab2Bean.getSiteContract().getAgeYear() != null && semmsi004tab2Bean.getSiteContract().getAgeYear() == 0){
					semmsi004tab2Bean.getSiteContract().setAgeYear(null);
				}
				if(semmsi004tab2Bean.getSiteContract().getNoExpireFlag() != null && 
				   semmsi004tab2Bean.getSiteContract().getNoExpireFlag().equals("Y")){
					semmsi004tab2Bean.setChkNoExpireFlag(true);
					semmsi004tab2Bean.setDisabledAge(true);
					semmsi004tab2Bean.setRenderStarImage(false);
					semmsi004tab2Bean.setDisabledExpDate(true);
					semmsi004tab2Bean.getSiteContract().setExpireDt(null);
					semmsi004tab2Bean.getSiteContract().setAgeYear(null);
					semmsi004tab2Bean.getSiteContract().setAgeMonth(null);
					semmsi004tab2Bean.getSiteContract().setAgeDay(null);
				}else{
					semmsi004tab2Bean.setChkNoExpireFlag(true);
					semmsi004tab2Bean.setDisabledAge(false);
					semmsi004tab2Bean.setRenderStarImage(true);
				}
				// check company
				if((semmsi004Bean.getCompanyParam() != null && semmsi004Bean.getCompanyParam().equals("DPC")) ||
				   (semmsi004tab2Bean.isChkDummyFlag()) && (StringUtils.isEmpty(semmsi004tab2Bean.getSiteContract().getNoFormat()) || 
					semmsi004tab2Bean.getSiteContract().getNoFormat().equals("N"))){
					semmsi004tab1Bean.setDummyContractNo(semmsi004tab2Bean.getSiteContract().getContractNo());
					semmsi004tab1Bean.setRenderContractNo(false);
					semmsi004tab1Bean.setRenderDummyContractNo(true);
					semmsi004tab1Bean.setRenderedBtnGenContractNo(false);
				}else{
					getSemmsi004tab2Action().setContractNo();
					if (StringUtils.isEmpty(semmsi004tab2Bean.getSiteContract().getNoFormat()) || 
							semmsi004tab2Bean.getSiteContract().getNoFormat().equals("")) {
						semmsi004tab1Bean.setRenderedBtnGenContractNo(true);
						semmsi004tab1Bean.setRenderContractNo(true);
						semmsi004tab1Bean.setRenderDummyContractNo(false);
						semmsi004tab1Bean.setRenderNoFormatContractNo(false);
					} else {
						semmsi004tab1Bean.setRenderedBtnGenContractNo(false);
						semmsi004tab1Bean.setRenderContractNo(false);
						semmsi004tab1Bean.setRenderDummyContractNo(false);
						semmsi004tab1Bean.setRenderNoFormatContractNo(true);
					}
					getSemmsi004tab2Action().setSemmsi004tab2Bean(semmsi004tab2Bean);
				}
				
			}else{
				//default
				semmsi004tab2Bean.setDisabledContractNo(false);
				semmsi004tab2Bean.setRenderStarImage(true);
				setSemmsi004tab2Bean(semmsi004tab2Bean);
				getSemmsi004tab2Action().setSemmsi004tab2Bean(semmsi004tab2Bean);
			}
			String t = semmsi004Bean.getDummyContractId();
			semmsi004tab2Bean.getSiteContract().setContractNo(semmsi004Bean.getDummyContractId());
		}catch(Exception e){
			e.printStackTrace();
		}
		
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		getSemmsi004tab2Action().setSemmsi004tab2Bean(semmsi004tab2Bean);
	}
	
	private void updateSiteInfo() {
		semmsi004Bean = getSemmsi004Bean();
		try{
		ISiteInfoService siteInfoService = (ISiteInfoService)getBean("siteInfoService");
		semmsi004Bean.getSiteInfo().setCurrentUser(semmsi004Bean.getUserLogin());
		
		siteInfoService.updateSiteInfo(semmsi004Bean.getSiteInfo());
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004Bean(semmsi004Bean);
		
	}
	
	public void getDataBySiteInfoId(String siteInfoId) {
		try{
			// GET SITE INFO
			this.getSiteInfoByRowId(siteInfoId);
			
			// GET SITE CONTRACT
			this.getSiteContractBySiteInfoId(siteInfoId);
			
			// GET SITE CONSTRUCT
			this.getSiteConstructBySiteInfoId(siteInfoId);
			
			// GET SITE ELECTRIC
			this.getSiteElectricBySiteInfoId(siteInfoId);
			
			// GET SITE INSURANCE
			this.getSiteInsuranceBySiteInfoId(siteInfoId);
			
			// GET SITE RENT
			this.getSiteRentBySiteInfoId(siteInfoId);
			
			// GET SITE PROPERTY TAX
			this.getSitePropertyTaxBySiteInfoId(siteInfoId);
			
			// GET SITE LESSOR LIST
			this.getSiteLessorListBySiteInfoId(siteInfoId);
			
			// GET SITE DEPOSIT LIST
			this.getSiteDepositBySiteInfoId(siteInfoId);
			
			// GET SITE RENTCOND LIST
			this.getSiteRentCondListBySiteInfoId(siteInfoId);
			
			// GET SITE SUBRENT LIST
			this.getSiteSubRentListBySiteInfoId(siteInfoId);
			
			//GET LOCATION call SEM_SP_MSI004_SRCH_MAP_LOC 
			this.getSiteInfoMapLoc(siteInfoId);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void getSiteElectricBySiteInfoId(String siteInfoId) {
		semmsi004Bean = getSemmsi004Bean();
		try{
			ISiteElectricService siteElectricService = (ISiteElectricService)getBean("siteElectricService");
			Electric electric = siteElectricService.queryElectricBySiteInfoId(siteInfoId);
			if(electric != null){
				semmsi004Bean.setSiteElectric(electric);
			}else{
				semmsi004Bean.setSiteElectric(new Electric());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004Bean(semmsi004Bean);
	}
	public void getSitePropertyTaxBySiteInfoId(String siteInfoId) {
		semmsi004Bean = getSemmsi004Bean();
		try{
			ISitePropertyTaxService sitePropertyTaxService = (ISitePropertyTaxService)getBean("sitePropertyTaxService");
			PropertyTax propertyTax = sitePropertyTaxService.queryPropertyTaxBySiteInfoId(siteInfoId);
			if(propertyTax != null){
				semmsi004Bean.setSitePropertyTax(propertyTax);
			}else{
				semmsi004Bean.setSitePropertyTax(new PropertyTax());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004Bean(semmsi004Bean);
	}
	
	public void getSiteInfoMapLoc(String assignSiteInfoId) {
		semmsi004Bean = getSemmsi004Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		ISiteInfoMapLocService siteInfoMapLocService = (ISiteInfoMapLocService)getBean("siteInfoMapLocService");
		List<SiteInfoMapLocSP> to = null;
		try{
			SiteInfoMapLocSP criteria = new SiteInfoMapLocSP();
			criteria.setSiteInfoId(assignSiteInfoId);
			to = siteInfoMapLocService.querySPList(EQueryName.Q_SEARCH_MAP_LOC_BY_SITE_INFO_ID.name, criteria);
			if(to != null && to.size() > 0){
				semmsi004Bean.setSiteInfoMapLocSPList(to);
				semmsi004tab1Bean.setSiteInfoMapLocSPList(to);
			}else{
				semmsi004Bean.setSiteInfoMapLocSPList(new ArrayList<SiteInfoMapLocSP>());
				semmsi004tab1Bean.setSiteInfoMapLocSPList(new ArrayList<SiteInfoMapLocSP>());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004Bean(semmsi004Bean);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
	}
	
	public void getSiteContractBySiteInfoId(String siteInfoId) {
		semmsi004Bean = getSemmsi004Bean();
		try{
			ISiteContractService siteContractService = (ISiteContractService)getBean("siteContractService");
			Contract contract = siteContractService.queryContractBySiteInfoId(siteInfoId);
			if(contract != null){
				semmsi004Bean.setSiteContract(contract);
			}else{
				semmsi004Bean.setSiteContract(new Contract());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004Bean(semmsi004Bean);
		
	}
	private void getSiteInfoByRowId(String siteInfoId) {
		semmsi004Bean = getSemmsi004Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		try{
			ISiteInfoService siteInfoService = (ISiteInfoService)getBean("siteInfoService");
			SiteInfo siteInfo = siteInfoService.querySiteInfoByRowId(siteInfoId);
			if(siteInfo != null){
				semmsi004Bean.setSiteInfo(siteInfo);
				semmsi004tab1Bean.setSiteInfo(siteInfo);
			}else{
				semmsi004Bean.setSiteInfo(new SiteInfo());
				semmsi004tab1Bean.setSiteInfo(new SiteInfo());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004Bean(semmsi004Bean);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
	}


	public void getSiteSubRentListBySiteInfoId(String siteInfoId) {
		semmsi004Bean = getSemmsi004Bean();
		try{
			ISiteSubRentService siteSubRentService = (ISiteSubRentService)getBean("siteSubRentService");
			List<SubRent> subRentList = siteSubRentService.querySubRentBySiteInfoId(siteInfoId);
			if(subRentList != null && !subRentList.isEmpty()){
				semmsi004Bean.setSiteSubRentList(subRentList);
			}else{
				semmsi004Bean.setSiteSubRentList(new ArrayList<SubRent>());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004Bean(semmsi004Bean);
	}

	private void getSiteRentCondListBySiteInfoId(String siteInfoId) {
		semmsi004Bean = getSemmsi004Bean();
		try{
			ISiteRentCondService siteRentCondService = (ISiteRentCondService)getBean("siteRentCondService");
			List<RentCond> rentCondList = siteRentCondService.queryRentCondBySiteInfoId(siteInfoId);
			if(rentCondList != null && !rentCondList.isEmpty()){
				semmsi004Bean.setSiteRentCondList(rentCondList);
			}else{
				semmsi004Bean.setSiteRentCondList(new ArrayList<RentCond>());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004Bean(semmsi004Bean);
	}

	public void getSiteDepositBySiteInfoId(String siteInfoId) {
		semmsi004Bean = getSemmsi004Bean();
		try{
			ISiteDepositService siteDepositService = (ISiteDepositService)getBean("siteDepositService");
			List<Deposit> depositList = siteDepositService.queryDepositBySiteInfoId(siteInfoId);
			if(depositList != null && !depositList.isEmpty()){
				semmsi004Bean.setSiteDepositList(depositList);
			}else{
				semmsi004Bean.setSiteDepositList(new ArrayList<Deposit>());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004Bean(semmsi004Bean);
	}

	private void getSiteLessorListBySiteInfoId(String siteInfoId) {
		semmsi004Bean = getSemmsi004Bean();
		try{
			ISiteLessorService siteLessorService = (ISiteLessorService)getBean("siteLessorService");
			List<Lessor> lessorList = siteLessorService.queryLessorBySiteInfoId(siteInfoId);
			if(lessorList != null && !lessorList.isEmpty()){
				semmsi004Bean.setSiteLessorList(lessorList);
			}else{
				semmsi004Bean.setSiteLessorList(new ArrayList<Lessor>());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004Bean(semmsi004Bean);
	}


	public void getSiteRentBySiteInfoId(String siteInfoId) {
		semmsi004Bean = getSemmsi004Bean();
		try{
			ISiteRentService siteRentService = (ISiteRentService)getBean("siteRentService");
			Rent rent = siteRentService.queryRentBySiteInfoId(siteInfoId);
			if(rent != null){
				semmsi004Bean.setSiteRent(rent);
				if(rent.getNoRent() != null && rent.getNoRent().equals("Y")){
					semmsi004Bean.setChkNoRent(true);
				}else{
					semmsi004Bean.setChkNoRent(false);
				}
				if(rent.getNoDeposit() != null && rent.getNoDeposit().equals("Y")){
					semmsi004Bean.setChkNoDeposit(true);
				}else{
					semmsi004Bean.setChkNoDeposit(false);
				}
			}else{
				semmsi004Bean.setSiteRent(new Rent());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004Bean(semmsi004Bean);
	}
	

	public void getSiteInsuranceBySiteInfoId(String siteInfoId) {
		semmsi004Bean = getSemmsi004Bean();
		try{
			ISiteInsuranceService siteInsuranceService = (ISiteInsuranceService)getBean("siteInsuranceService");
			Insurance insurance = siteInsuranceService.queryInsuranceBySiteInfoId(siteInfoId);
			if(insurance != null){
				semmsi004Bean.setSiteInsurance(insurance);
			}else{
				semmsi004Bean.setSiteInsurance(new Insurance());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004Bean(semmsi004Bean);
	}



	private void getSiteConstructBySiteInfoId(String siteInfoId) {
		semmsi004Bean = getSemmsi004Bean();
		try{
			ISiteConstructService siteConstructService = (ISiteConstructService)getBean("siteConstructService");
			Construct construct = siteConstructService.queryConstructBySiteInfoId(siteInfoId);
			if(construct != null){
				semmsi004Bean.setSiteConstruct(construct);
			}else{
				semmsi004Bean.setSiteConstruct(new Construct());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004Bean(semmsi004Bean);
	}


	public void saveSiteInfo(String reqType) {
		semmsi004Bean = getSemmsi004Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		ISiteInfoService siteInfoService = (ISiteInfoService)getBean("siteInfoService");
		try{
			if(semmsi004Bean.getSiteInfo() != null){
				// CREATE NEW SITE INFO
				if(reqType.equals("01")){
					semmsi004Bean.getSiteInfo().setSeqNo(1);
					semmsi004Bean.getSiteInfo().setSiteStatus("01"); // Active
					
				}else{
					// set SeqNo
					Integer siteInfoSeqNo = this.getSiteInfoSeqNo(semmsi004Bean.getAssignContractNoParam());
					semmsi004Bean.getSiteInfo().setSeqNo(siteInfoSeqNo);
					// set siteStatus
					if(reqType.equals("98")){
						semmsi004Bean.getSiteInfo().setSiteStatus("03");
					}
//					if(reqType.equals("99")){
//						semmsi004Bean.getSiteInfo().setSiteStatus("04");
//					}
				}
				semmsi004Bean.getSiteInfo().setSiteInfoStatus("00"); // Waiting
				semmsi004Bean.getSiteInfo().setMigrateFlag("");
				semmsi004Bean.getSiteInfo().setLatestFlag("N");
				semmsi004Bean.getSiteInfo().setDocApproveId(semmsi004Bean.getDocApproveIdParam());
				semmsi004Bean.getSiteInfo().setDocApproveType(semmsi004Bean.getDocApproveTypeParam());
				semmsi004Bean.getSiteInfo().setRegion(semmsi004Bean.getRegionParam());
				semmsi004Bean.getSiteInfo().setCompany(semmsi004Bean.getCompanyParam());
				semmsi004Bean.getSiteInfo().setCurrentUser(semmsi004Bean.getUserLogin());
				// get siteName from siteApprove first record
				semmsi004Bean.getSiteInfo().setSiteName(semmsi004tab1Bean.getSiteInfo().getSiteName());
				// set Edit Flag = null
				semmsi004Bean.getSiteInfo().setSiteEditFlag(null);
				semmsi004Bean.getSiteInfo().setContractEditFlag(null);
				semmsi004Bean.getSiteInfo().setLessorEditFlag(null);
				semmsi004Bean.getSiteInfo().setRentEditFlag(null);
				semmsi004Bean.getSiteInfo().setPropertyTaxEditFlag(null);
				semmsi004Bean.getSiteInfo().setElectricEditFlag(null);
				semmsi004Bean.getSiteInfo().setInsuranceEditFlag(null);
				semmsi004Bean.getSiteInfo().setDepositRentEditFlag(null);
				semmsi004Bean.getSiteInfo().setDepositElectricEditFlag(null);
				SiteInfo siteInfo = siteInfoService.createSiteInfo(semmsi004Bean.getSiteInfo());
				semmsi004Bean.setSiteInfo(siteInfo);
				semmsi004Bean.setSiteInfoId(siteInfo.getRowId());
				// SAVE SEM_SI_CONTRACT
					saveSiteContract();
				// SAVE SEM_SITE_CONSTRUCT
					saveSiteConstruct();
				// SAVE SEM_SITE_RENT
					saveSiteRent();
				// SAVE SEM_SITE_PROPERTY_TAX
					saveSitePropertyTax();
				// SAVE SEM_SITE_ELECTRIC
					saveSiteElectric();
				// SAVE SEM_SITE_INSURANCE
					saveSiteInsurance();
				// SAVE SEM_SITE_INFO_MAP_LOC 
					getSemmsi004tab1Action().saveSiteInfoMapLoc();
				// UPDATE RIGHT ADDRESS BY SITE ADDRESS
//					getSemmsi004tab1Action().updateRightAddress();
				
				if(!reqType.equals("01")){
					// SAVE SEM_SITE_LESSOR
						saveSiteLessor();
					// SAVE SEM_SITE_RENT_COND
						saveSiteRentCond();
					// SAVE SEM_SITE_DEPOSIT
						saveSiteDeposit();
					// SAVE SEM_SITE_SUB_RENT
						saveSiteSubRent();
				}
				
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004Bean(semmsi004Bean);
		
	}
	
	private Integer getSiteInfoSeqNo(String assignContractNo) {
		ISiteInfoService siteInfoService = (ISiteInfoService)getBean("siteInfoService");
		List<SiteInfoSeqSP> to = null;
		Integer seqNo = 0;
		try{
			SiteInfoSeqSP criteria = new SiteInfoSeqSP();
			criteria.setContractNo(assignContractNo);
			to = siteInfoService.querySPList(EQueryName.Q_SEARCH_SITE_INFO_SEQ_NO.name, criteria);
			if(to != null && to.size() > 0){
				seqNo = Integer.parseInt(to.get(0).getSeqNo());
				log.debug("seqNo SiteInfo [" + seqNo + "]");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return seqNo;
	}

	private void saveSiteSubRent() {
		semmsi004Bean = getSemmsi004Bean();
		ISiteSubRentService siteSubRentService = (ISiteSubRentService)getBean("siteSubRentService");
		try{
			if(semmsi004Bean.getSiteSubRentList() != null && semmsi004Bean.getSiteSubRentList().size() > 0){
				String siteInfoId = semmsi004Bean.getSiteInfo().getRowId();
				String user = semmsi004Bean.getUserLogin();
				siteSubRentService.createSiteSubRentList(semmsi004Bean.getSiteSubRentList(), siteInfoId, user);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void saveSiteDeposit() {
		semmsi004Bean = getSemmsi004Bean();
		ISiteDepositService siteDepositService = (ISiteDepositService)getBean("siteDepositService");
		try{
			if(semmsi004Bean.getSiteDepositList() != null && semmsi004Bean.getSiteDepositList().size() > 0){
				String siteInfoId = semmsi004Bean.getSiteInfo().getRowId();
				String user = semmsi004Bean.getUserLogin();
				siteDepositService.createSiteDepositList(semmsi004Bean.getSiteDepositList(), siteInfoId, user);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void saveSiteRentCond() {
		semmsi004Bean = getSemmsi004Bean();
		ISiteRentCondService siteRentCondService = (ISiteRentCondService)getBean("siteRentCondService");
		try{
			if(semmsi004Bean.getSiteRentCondList() != null && semmsi004Bean.getSiteRentCondList().size() > 0){
				String siteInfoId = semmsi004Bean.getSiteInfo().getRowId();
				String user = semmsi004Bean.getUserLogin();
				String reqType = semmsi004Bean.getReqTypeParam();
				siteRentCondService.createSiteRentCondList(semmsi004Bean.getSiteRentCondList(), siteInfoId, user, reqType);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	private void saveSiteLessor() {
		semmsi004Bean = getSemmsi004Bean();
		ISiteLessorService siteLessorService = (ISiteLessorService)getBean("siteLessorService");
		try{
			if(semmsi004Bean.getSiteLessorList() != null && semmsi004Bean.getSiteLessorList().size() > 0){
				String siteInfoId = semmsi004Bean.getSiteInfo().getRowId();
				String user = semmsi004Bean.getUserLogin();
				siteLessorService.createSiteLessorList(semmsi004Bean.getSiteLessorList(), siteInfoId, user);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	private void saveSiteInsurance() {
		semmsi004Bean = getSemmsi004Bean();
		ISiteInsuranceService siteInsuranceService = (ISiteInsuranceService)getBean("siteInsuranceService");
		try{
			if(semmsi004Bean.getSiteInsurance() != null){
				semmsi004Bean.getSiteInsurance().setSiteInfoId(semmsi004Bean.getSiteInfo().getRowId());
				semmsi004Bean.getSiteInsurance().setCurrentUser(semmsi004Bean.getUserLogin());
				if(semmsi004Bean.getReqTypeParam().equals("01")){
					semmsi004Bean.getSiteInsurance().setInsuranceType("00");
				}
				Insurance insurance = siteInsuranceService.createSiteInsurance(semmsi004Bean.getSiteInsurance());
				semmsi004Bean.setSiteInsurance(insurance);
				setSemmsi004Bean(semmsi004Bean);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	private void saveSiteElectric() {
		semmsi004Bean = getSemmsi004Bean();
		ISiteElectricService siteElectricService = (ISiteElectricService)getBean("siteElectricService");
		try{
			if(semmsi004Bean.getSiteElectric() != null){
				semmsi004Bean.getSiteElectric().setSiteInfoId(semmsi004Bean.getSiteInfo().getRowId());
				semmsi004Bean.getSiteElectric().setCurrentUser(semmsi004Bean.getUserLogin());
				if(semmsi004Bean.getReqTypeParam().equals("01")){
					if(semmsi004Bean.getRegionParam() != null && semmsi004Bean.getRegionParam().equals("BKK")){
						semmsi004Bean.getSiteElectric().setElectricType1("Y");
					}else{
						semmsi004Bean.getSiteElectric().setElectricType2("Y");
					}
				}
				Electric electric = siteElectricService.createSiteElectric(semmsi004Bean.getSiteElectric());
				semmsi004Bean.setSiteElectric(electric);
				setSemmsi004Bean(semmsi004Bean);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	private void saveSitePropertyTax() {
		semmsi004Bean = getSemmsi004Bean();
		ISitePropertyTaxService sitePropertyTaxService = (ISitePropertyTaxService)getBean("sitePropertyTaxService");
		try{
			if(semmsi004Bean.getSitePropertyTax() != null){
				semmsi004Bean.getSitePropertyTax().setSiteInfoId(semmsi004Bean.getSiteInfo().getRowId());
				semmsi004Bean.getSitePropertyTax().setCurrentUser(semmsi004Bean.getUserLogin());
				if(semmsi004Bean.getReqTypeParam().equals("01")){
					semmsi004Bean.getSitePropertyTax().setPropertyTaxPayType("00");
				}
				PropertyTax propertyTax = sitePropertyTaxService.createSitePropertyTax(semmsi004Bean.getSitePropertyTax());
				semmsi004Bean.setSitePropertyTax(propertyTax);
				setSemmsi004Bean(semmsi004Bean);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	private void saveSiteRent() {
		semmsi004Bean = getSemmsi004Bean();
		ISiteRentService siteRentService = (ISiteRentService)getBean("siteRentService");
		try{
			if(semmsi004Bean.getSiteRent() != null){
				semmsi004Bean.getSiteRent().setSiteInfoId(semmsi004Bean.getSiteInfo().getRowId());
				semmsi004Bean.getSiteRent().setCurrentUser(semmsi004Bean.getUserLogin());
				Rent rent = siteRentService.createSiteRent(semmsi004Bean.getSiteRent());
				semmsi004Bean.setSiteRent(rent);
				setSemmsi004Bean(semmsi004Bean);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	private void saveSiteConstruct() {
		semmsi004Bean = getSemmsi004Bean();
		ISiteConstructService siteConstructService = (ISiteConstructService)getBean("siteConstructService");
		try{
			if(semmsi004Bean.getSiteConstruct() != null){
				semmsi004Bean.getSiteConstruct().setSiteInfoId(semmsi004Bean.getSiteInfo().getRowId());
//				semmsi004Bean.getSiteConstruct().setCurrentUser(semmsi004Bean.getUserLogin());
				Construct construct = siteConstructService.createSiteConstructWithOutUser(semmsi004Bean.getSiteConstruct());
				semmsi004Bean.setSiteConstruct(construct);
				setSemmsi004Bean(semmsi004Bean);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	private void saveSiteContract() {
		semmsi004Bean = getSemmsi004Bean();
		ISiteContractService siteContractService = (ISiteContractService)getBean("siteContractService");
		try{
			if(semmsi004Bean.getSiteContract() != null){
				
				if(semmsi004Bean.getReqTypeParam() != null ){
					// new
					if(semmsi004Bean.getReqTypeParam().equals("01")){
						semmsi004Bean.getSiteContract().setRenewNo(0);
					}
					// Renew
					if(semmsi004Bean.getReqTypeParam().equals("02")){
						if(semmsi004Bean.getSiteContract().getRenewNo() != null){
							semmsi004Bean.getSiteContract().setRenewNo(semmsi004Bean.getSiteContract().getRenewNo() + 1);
						}else{
							semmsi004Bean.getSiteContract().setRenewNo(1);
						}
						// call SEM_SP_MSI004_CALC_EXPIRE_DT
						List<Msi004CalcExpireDateSP> to = null;
						Date newDate = null;
						if(semmsi004Bean.getSiteContract().getExpireDt() != null){
							newDate = SEMDataUtility.shiftDateUp(semmsi004Bean.getSiteContract().getExpireDt(), 1);
						}
						Msi004CalcExpireDateSP criteria = new Msi004CalcExpireDateSP();
						if(newDate != null) criteria.setEffDate(newDate);
						criteria.setAgeYear(semmsi004Bean.getSiteContract().getAgeYear().intValue());						
						criteria.setAgeMonth(semmsi004Bean.getSiteContract().getAgeMonth().intValue());
						criteria.setAgeDay(semmsi004Bean.getSiteContract().getAgeDay().intValue());
						try{
							to = siteContractService.querySPList(EQueryName.SP_MSI004_CALC_EXPIRE_DT.name, criteria);
							if(to != null && !to.isEmpty()){
								semmsi004Bean.getSiteContract().setEffectiveDt(newDate);
								semmsi004Bean.getSiteContract().setExpireDt(to.get(0).getExpDate());
							}
						}catch(Exception ex){
							ex.printStackTrace();
						}
					}
					// case edit
//					if(semmsi004Bean.getReqTypeParam().equals("03") || semmsi004Bean.getReqTypeParam().equals("04")){
//						semmsi004Bean.getSiteContract().setTotSendFlag("N");
//					}
					// SAVE TOT SEND FLAG
					List<Msi004DefaultTotSP> sendTotFlagList = null;
					Msi004DefaultTotSP criteria = new Msi004DefaultTotSP();
					criteria.setSiteApproveId(semmsi004Bean.getDocApproveIdParam());
					sendTotFlagList = siteContractService.querySPList(EQueryName.SP_MSI004_DEFAULT_TOT.name, criteria);
					if(sendTotFlagList != null && sendTotFlagList.size() > 0){
						semmsi004Bean.getSiteContract().setTotSendFlag(sendTotFlagList.get(0).getTotSendFlag());
					}
					
				}
				
				semmsi004Bean.getSiteContract().setPromiseRenewPeriodType("Y"); // default
				semmsi004Bean.getSiteContract().setPromiseRenewPeriod(3); // default
				semmsi004Bean.getSiteContract().setPromiseRenewTime(1); // default
				semmsi004Bean.getSiteContract().setSiteInfoId(semmsi004Bean.getSiteInfo().getRowId());
				semmsi004Bean.getSiteContract().setCurrentUser(semmsi004Bean.getUserLogin());
				Contract contract = siteContractService.createContract(semmsi004Bean.getSiteContract());
				semmsi004Bean.setSiteContract(contract);
				setSemmsi004Bean(semmsi004Bean);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	private boolean doClear() {
		boolean flag = false;
		semmsi004Bean = getSemmsi004Bean();
		semmsi004Bean.setSiteInfoSP(new SiteInfoSP());
		semmsi004Bean.setSiteInfoSPList(new ArrayList<WrapperBeanObject<SiteInfoSP>>());
		semmsi004Bean.setPendingStatus(false);
		semmsi004Bean.setExpireStatus(false);
		semmsi004Bean.setChkCurrentFlag(false);
		semmsi004Bean.getSiteInfoSP().setSiteInfoStatus("00");
		semmsi004Bean.getSiteInfoSP().setLegalApproveStatus("");
		semmsi004Bean.getSiteInfoSP().setSiteStatus("");
		semmsi004Bean.getSiteInfoSP().setSiteType("");
		semmsi004Bean.getSiteInfoSP().setCurrentFlag("");
		semmsi004Bean.getSiteInfoSP().setCompany("");
//		semmsi004Bean.setDisabledBtnExport(true);
		semmsi004Bean.setChkSelAll(false);
		semmsi004Bean.setRenderedMsgDataNotFound(false);
		semmsi004Bean.setChkNoExpireFlag(flag);
		setSemmsi004Bean(semmsi004Bean);
		return flag;
	}

	public boolean doSearch() {
		boolean flag = false;
		semmsi004Bean = getSemmsi004Bean();
		if(!validateSearch()){
			semmsi004Bean.setRenderedMsgFormSearch(true);
			return flag;
		}
		
		ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
		List<SiteInfoSP> to = null;
		try{
			if(semmsi004Bean.isExpireStatus()){
				semmsi004Bean.getSiteInfoSP().setExpireStatus("Y");
			} else {
				semmsi004Bean.getSiteInfoSP().setExpireStatus("N");
			}
			if(semmsi004Bean.isPendingStatus()){
				semmsi004Bean.getSiteInfoSP().setPendingStatus("Y");
			} else {
				semmsi004Bean.getSiteInfoSP().setPendingStatus("N");
			}
			if(semmsi004Bean.isChkCurrentFlag()){
				semmsi004Bean.getSiteInfoSP().setCurrentFlag("Y");
			}else{
				semmsi004Bean.getSiteInfoSP().setCurrentFlag("N");
			}
			
			if(semmsi004Bean.isChkNoExpireFlagSP()){
				semmsi004Bean.getSiteInfoSP().setNoExpireFlag("Y");
			}else{
				semmsi004Bean.getSiteInfoSP().setNoExpireFlag(null);
			}
			semmsi004Bean.setSiteInfoData(semmsi004Bean.getSiteInfoSP());
			//to = service.querySPList(EQueryName.Q_SEARCH_SITE_INFO.name, semmsi004Bean.getSiteInfoSP());
			to = service.querySPList(EQueryName.SP_MEL011_SRCH_DUMMY.name, semmsi004Bean.getSiteInfoSP());
			log.debug("size [" + to.size() + "]");
			
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsi004Bean.setRenderedMsgDataNotFound(true);
				semmsi004Bean.setSiteInfoSPList(null);
			}
			
			if(to != null && to.size() > 0){
				semmsi004Bean.setRenderedMsgDataNotFound(false);
				semmsi004Bean.setSiteInfoSPList(new ArrayList<WrapperBeanObject<SiteInfoSP>>());
				for (int i = 0; i < to.size(); i++) {
					SiteInfoSP siteInfo = to.get(i);
					WrapperBeanObject<SiteInfoSP> tmpWrapperBean = new WrapperBeanObject<SiteInfoSP>();
					if(siteInfo.getEffDate() != null) {
//						siteInfo.setEffDate(convertYearENtoTH(siteInfo.getEffDate()));
						siteInfo.setEffDateStr(convertYearENtoTHStr(siteInfo.getEffDate()));
					}
					if(siteInfo.getExpDate() != null){
//						siteInfo.setExpDate(convertYearENtoTH(siteInfo.getExpDate()));
						siteInfo.setExpDateStr(convertYearENtoTHStr(siteInfo.getExpDate()));
					}
					
					tmpWrapperBean.setDataObj(siteInfo);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					semmsi004Bean.getSiteInfoSPList().add(tmpWrapperBean);
				}
			}
				
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0003");
			semmsi004Bean.setRenderedMsgFormSearch(true);
		}
		
		setSemmsi004Bean(semmsi004Bean);
		
		return flag;
	}
	
	private boolean validateSearch() {
		boolean flagValid = true;
		
		if(StringUtils.isEmpty(getSemmsi004Bean().getSiteInfoSP().getDocNo()) 
			&& StringUtils.isEmpty(getSemmsi004Bean().getSiteInfoSP().getContractNo())
			&& StringUtils.isEmpty(getSemmsi004Bean().getSiteInfoSP().getLocationId())
			&& StringUtils.isEmpty(getSemmsi004Bean().getSiteInfoSP().getLocationName())
			&& StringUtils.isEmpty(getSemmsi004Bean().getSiteInfoSP().getLocationCode())
			&& StringUtils.isEmpty(getSemmsi004Bean().getSiteInfoSP().getBatchNo())){
			if(StringUtils.isEmpty(getSemmsi004Bean().getSiteInfoSP().getCompany())){
				addMessageError("W0001", msg("message.company"));
				flagValid = false;
			}
			if(StringUtils.isEmpty(getSemmsi004Bean().getSiteInfoSP().getRegion())){
				addMessageError("W0001", msg("message.region"));
				flagValid = false;
			}
		}
		
		Date effDateFrom = getSemmsi004Bean().getSiteInfoSP().getEffDateFrom();
		Date effDateTo = getSemmsi004Bean().getSiteInfoSP().getEffDateTo();
		Date expDateFrom = getSemmsi004Bean().getSiteInfoSP().getExpDateFrom();
		Date expDateTo = getSemmsi004Bean().getSiteInfoSP().getExpDateTo();
		try {
			log.info("effDateFrom [" + effDateFrom + "]");
			log.info("effDateTo [" + effDateTo + "]");
			log.info("expDateFrom [" + expDateFrom + "]");
			log.info("expDateTo [" + expDateTo + "]");
			
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError("Invalid Date!");
		}
		
		if(effDateFrom != null && effDateTo != null){
			if (effDateFrom.after(effDateTo)) {
				addMessageErrorWithArgument("W0006" ,msg("message.effDateBegin"), msg("message.effDateEnd"));
				flagValid = false;
			}
		}
		if(expDateFrom != null && expDateTo != null){
			if (expDateFrom.after(expDateTo)) {
				addMessageErrorWithArgument("W0006" ,msg("message.expDateBegin"), msg("message.expDateEnd"));
				flagValid = false;
			}
		}
		
		return flagValid;
	}
	
	public void getRowIdOnClick() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemmsi004Bean().setTmpRowId(rowId);
	}
	
	public void doExportExcel(){
		try {
			List<WrapperBeanObject<SiteInfoSP>> siteInfoList = new ArrayList<WrapperBeanObject<SiteInfoSP>>();
			siteInfoList = getSemmsi004Bean().getSiteInfoSPList();
			String rowsIdConcat = "";
			for(int i = 0; i < siteInfoList.size(); i++){
				WrapperBeanObject<SiteInfoSP> siteInfo = new WrapperBeanObject<SiteInfoSP>();
				siteInfo = siteInfoList.get(i);
				if(siteInfo.isCheckBox()){
					SiteInfoSP tmp = new SiteInfoSP();
					tmp = (SiteInfoSP)siteInfo.getDataObj();
					if(rowsIdConcat.equals("")){
						rowsIdConcat = tmp.getSiteInfoId();
					}else{
						rowsIdConcat = rowsIdConcat +",".trim()+ tmp.getSiteInfoId();
					}
				}
			}
			log.debug("rowIdConcat [" + rowsIdConcat + "]");
			
			this.searchExport(rowsIdConcat);
			List<Msi004SrchExportSP> exportList = getSemmsi004Bean().getExportList();
			/***********************************************/
			short line = 0;
			Collection<Msi004SrchExportSP> exList = new ArrayList<Msi004SrchExportSP>();
			//PDocumentManager export to excel
			DocumentExportManager<Msi004SrchExportSP> docManager =
				new DocumentExportManager<Msi004SrchExportSP>(Msi004SrchExportSP.class, EnumDocumentType.XLS);
			// set current configuration of work book.	
				docManager.setRowStart(line);
			/***********************************************/
				int no = 0;
				if(exportList != null && exportList.size() > 0){
					for(int i = 0; i < exportList.size(); i++){
						Msi004SrchExportSP detail = new Msi004SrchExportSP();
						detail = exportList.get(i);
						no++;
						detail.setNo(no);
						exList.add(detail);
					}
				}
				EnumDocStyleDomain headerStyle = new EnumDocStyleDomain(EnumDocStyle.HEADER);
					RowDomain rowD = new RowDomain(0);
					rowD.setCell(new CellDomain(0, null, String.class, headerStyle, msg("export.column.siteInfo.items"),null));
					rowD.setCell(new CellDomain(1, null, String.class, headerStyle, msg("export.column.company"),-1,5000));
					rowD.setCell(new CellDomain(2, null, String.class, headerStyle, msg("export.column.region"),-1,5000));
					rowD.setCell(new CellDomain(3, null, String.class, headerStyle, msg("export.column.reqTypeName"),-1,6000));
					rowD.setCell(new CellDomain(4, null, String.class, headerStyle, msg("export.column.siteInfo.idContract"),null));
					rowD.setCell(new CellDomain(5, null, String.class, headerStyle, msg("export.column.siteInfo.siteName"),null));
					rowD.setCell(new CellDomain(6, null, String.class, headerStyle, msg("export.column.siteInfo.locationId"),null));
					rowD.setCell(new CellDomain(7, null, String.class, headerStyle, msg("export.column.siteInfo.statusCode"),null));
					rowD.setCell(new CellDomain(8, null, String.class, headerStyle, msg("export.column.siteInfo.phase"),null));
					rowD.setCell(new CellDomain(9, null, String.class, headerStyle, msg("export.column.siteInfo.system"),null));
					rowD.setCell(new CellDomain(10, null, String.class, headerStyle, msg("export.column.siteInfo.conStart"),null));
					rowD.setCell(new CellDomain(11, null, String.class, headerStyle, msg("export.column.siteInfo.conEnd"),null));
					rowD.setCell(new CellDomain(12, null, String.class, headerStyle, msg("export.column.siteInfo.address"),-1,6000));
					rowD.setCell(new CellDomain(13, null, String.class, headerStyle, msg("export.column.siteInfo.street"),-1,5000));
					rowD.setCell(new CellDomain(14, null, String.class, headerStyle, msg("export.column.siteInfo.district"),-1,6000));
					rowD.setCell(new CellDomain(15, null, String.class, headerStyle, msg("export.column.siteInfo.subDivision"),null));
					rowD.setCell(new CellDomain(16, null, String.class, headerStyle, msg("export.column.siteInfo.province"),-1,6000));
					rowD.setCell(new CellDomain(17, null, String.class, headerStyle, msg("export.column.siteInfo.ownerName"),null));
					rowD.setCell(new CellDomain(18, null, String.class, headerStyle, msg("export.column.siteInfo.telephone"),null));
					rowD.setCell(new CellDomain(19, null, String.class, headerStyle, msg("export.column.siteInfo.siteTypeName"),-1,6000));
					rowD.setCell(new CellDomain(20, null, String.class, headerStyle, msg("export.column.siteInfo.deckArea"),null));
					rowD.setCell(new CellDomain(21, null, String.class, headerStyle, msg("export.column.siteInfo.roomArea"),null));
					rowD.setCell(new CellDomain(22, null, String.class, headerStyle, msg("export.column.siteInfo.landAreaSqm"),-1,8000));
					rowD.setCell(new CellDomain(23, null, String.class, headerStyle, msg("export.column.siteInfo.landAreaSqw"),-1,8000));
					rowD.setCell(new CellDomain(24, null, String.class, headerStyle, msg("export.column.siteInfo.rentAmtMonth"),-1,8000));
					rowD.setCell(new CellDomain(25, null, String.class, headerStyle, msg("export.column.siteInfo.rentAmtYear"),-1,8000));
					rowD.setCell(new CellDomain(26, null, String.class, headerStyle, msg("export.column.siteInfo.sumRentAmt"),-1,8000));
					rowD.setCell(new CellDomain(27, null, String.class, headerStyle, msg("export.column.siteInfo.serviceAmtMonth"),-1,8000));
					rowD.setCell(new CellDomain(28, null, String.class, headerStyle, msg("export.column.siteInfo.serviceAmtYear"),-1,8000));
					rowD.setCell(new CellDomain(29, null, String.class, headerStyle, msg("export.column.siteInfo.sumServiceAmt"),-1,8000));
					rowD.setCell(new CellDomain(30, null, String.class, headerStyle, msg("export.column.siteInfo.sumRentServiceAmt"),-1,8000));
					
					docManager.setListHeader(rowD);
					docManager.seteObjectList(exList);
					docManager.setModule("SITE_INFO_");
					docManager.getObjectFromDocument();
					docManager.exportServletFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void searchExport(String siteInfoId){
		semmsi004Bean = getSemmsi004Bean();
		semmsi004Bean.setExportList(new ArrayList<Msi004SrchExportSP>());
		try{
			List<Msi004SrchExportSP> to = null;
			ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
			Msi004SrchExportSP criteria = new Msi004SrchExportSP();
			criteria.setSiteInfoId(siteInfoId);
			
			to = service.querySPList(EQueryName.SP_MSI004_SRCH_EXPORT.name, criteria);
			if(to != null && !to.isEmpty()){
				semmsi004Bean.setExportList(to);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		setSemmsi004Bean(semmsi004Bean);
		
	}
	public void getAmphurList(){
		semmsi004Bean = getSemmsi004Bean();
		Province province = new Province();
		province.setRowId(semmsi004Bean.getSiteInfoSP().getProvince());
		semmsi004Bean.setAmphurList(this.getAmphurByProvince(province));
		setSemmsi004Bean(semmsi004Bean);
	}
	

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		SEMMSI004Bean semmsi004Bean = new SEMMSI004Bean();
		
		semmsi004Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmsi004Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
		semmsi004Bean.setReqTypeList(getLovItemsByTypeExceptLovCodes(ELovType.T_SI_APPROVE_TYPE.name, ELovVal.V_SI_REQ_TYPE_OTHER.name));
		semmsi004Bean.setSiteTypeList(getLovItemsByType(ELovType.T_SI_SITE_TYPE.name));
		semmsi004Bean.setSiteInfoStatusList(getLovItemsByType(ELovType.T_SI_SITE_INFO_STATUS.name));
		semmsi004Bean.setSiteStatusList(getLovItemsByType(ELovType.T_SI_SITE_STATUS.name));
		semmsi004Bean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList());
		semmsi004Bean.setGroupRentList(getLovItemsByType(ELovType.T_CT_SITE_GROUP.name));
		semmsi004Bean.setAmphurList(getEmptyDropDown());
		semmsi004Bean.setSiteInfoSP(new SiteInfoSP());
		semmsi004Bean.getSiteInfoSP().setCompany("");
		semmsi004Bean.getSiteInfoSP().setSiteInfoStatus("00");
		semmsi004Bean.getSiteInfoSP().setLegalApproveStatus("");
		semmsi004Bean.getSiteInfoSP().setSiteStatus("");
		semmsi004Bean.getSiteInfoSP().setSiteType("");
		semmsi004Bean.getSiteInfoSP().setHouseNo("");
		semmsi004Bean.getSiteInfoSP().setTambol("");
		semmsi004Bean.getSiteInfoSP().setCurrentFlag("Y");
		semmsi004Bean.setSiteInfoSPList(new ArrayList<WrapperBeanObject<SiteInfoSP>>());
		semmsi004Bean.setDisabledLink(false);
		semmsi004Bean.setTmpSiteInfoSP(new SiteInfoSP());
		semmsi004Bean.setDisabledBtnGenDummy(true);
		setSemmsi004Bean(semmsi004Bean);
		
		PopupUploadFilePictureBean uploadBean = new PopupUploadFilePictureBean();
//		uploadBean.setModuleList(new ArrayList<SelectItem>());
//		uploadBean.setSubModuleList(new ArrayList<SelectItem>());
//		uploadBean.setModuleList(new ArrayList<SelectItem>());
//		uploadBean.setSubModuleList(new ArrayList<SelectItem>());
		setPopupUploadFilePictureBean(uploadBean);
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	public void approveSiteInfo(String tabNo){
		semmsi004Bean = getSemmsi004Bean();
		try{
			ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
			ApproveSiteInfoSP criteria = new ApproveSiteInfoSP();
			criteria.setSiteInfoId(semmsi004Bean.getSiteInfoId());
			criteria.setScreen(tabNo);
			criteria.setCurrentUser(semmsi004Bean.getUserLogin());
			service.querySPList(EQueryName.SP_APPROVE_SITE_INFO.name, criteria);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void selectAllRow(){
		semmsi004Bean = getSemmsi004Bean();
		try{
			boolean chkAll = semmsi004Bean.isChkSelAll();
			List<WrapperBeanObject<SiteInfoSP>> siteInfoList = new ArrayList<WrapperBeanObject<SiteInfoSP>>();
			siteInfoList = semmsi004Bean.getSiteInfoSPList();
			for(int i = 0; i < siteInfoList.size(); i++) {
				SiteInfoSP o = (SiteInfoSP)siteInfoList.get(i).getDataObj();
				if (StringUtils.isNotEmpty(o.getRowId())) {
					siteInfoList.get(i).setCheckBox(chkAll);
				}
			}
			onRenderButton();
			
		}catch(NullPointerException ne){
			// TODO
			
		}catch(Exception e){
			//TODO
		}
		setSemmsi004Bean(semmsi004Bean);
	}
	
	public void onRenderButton() {
		semmsi004Bean = getSemmsi004Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		semmsi004Bean.setTmpRowId(rowId);
		
		if (isCheckSELBox()) {
			semmsi004Bean.setDisabledBtnExport(false);
		} else {
			semmsi004Bean.setDisabledBtnExport(true);
		}
		setSemmsi004Bean(semmsi004Bean);
		
	}
	
	private boolean isCheckSELBox() {
		boolean isCheck = false;
		
		List<WrapperBeanObject<SiteInfoSP>> siteInfoList = getSemmsi004Bean().getSiteInfoSPList();
		for (WrapperBeanObject<SiteInfoSP> wrapperBeanObject : siteInfoList) {
			if (wrapperBeanObject.isCheckBox()) {
				return true;
			}
		}
		
		return isCheck;
	}
	public SEMMSI004Bean semmsi004Bean;
	
	public SEMMSI004Bean getSemmsi004Bean() {
		return (SEMMSI004Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi004Bean");
	}
	
	public void setSemmsi004Bean(SEMMSI004Bean semmsi004Bean) {
		this.semmsi004Bean = semmsi004Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi004Bean", this.semmsi004Bean);
	}
	
	private SEMMSI004Tab1Bean semmsi004tab1Bean;
	
	
	public SEMMSI004Tab1Bean getSemmsi004tab1Bean() {
		return (SEMMSI004Tab1Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi004tab1Bean");
	}

	public void setSemmsi004tab1Bean(SEMMSI004Tab1Bean semmsi004tab1Bean) {
		this.semmsi004tab1Bean = semmsi004tab1Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi004tab1Bean", this.semmsi004tab1Bean);
	}
	
	private SEMMSI004Tab2Bean semmsi004tab2Bean;
	
	
	public SEMMSI004Tab2Bean getSemmsi004tab2Bean() {
		return (SEMMSI004Tab2Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("getSemmsi004tab2Bean");
	}

	public void setSemmsi004tab2Bean(SEMMSI004Tab2Bean semmsi004tab2Bean) {
		this.semmsi004tab2Bean = semmsi004tab2Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi004tab2Bean", this.semmsi004tab2Bean);
	}
	
	private SEMMSI004Tab3Bean semmsi004tab3Bean;
	
	public SEMMSI004Tab3Bean getSemmsi004tab3Bean() {
		return (SEMMSI004Tab3Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi004tab3Bean");
	}

	public void setSemmsi004tab3Bean(SEMMSI004Tab3Bean semmsi004tab3Bean) {
		this.semmsi004tab3Bean = semmsi004tab3Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi004tab3Bean", this.semmsi004tab3Bean);
	}
	
	private SEMMSI004Tab4Bean semmsi004tab4Bean;
	
	public SEMMSI004Tab4Bean getSemmsi004tab4Bean() {
		return (SEMMSI004Tab4Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi004tab4Bean");
	}

	public void setSemmsi004tab4Bean(SEMMSI004Tab4Bean semmsi004tab4Bean) {
		this.semmsi004tab4Bean = semmsi004tab4Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi004tab4Bean", this.semmsi004tab4Bean);
	}
	
	private SEMMSI004Tab5Bean semmsi004tab5Bean;
	
	public SEMMSI004Tab5Bean getSemmsi004tab5Bean() {
		return (SEMMSI004Tab5Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi004tab5Bean");
	}

	public void setSemmsi004tab5Bean(SEMMSI004Tab5Bean semmsi004tab5Bean) {
		this.semmsi004tab5Bean = semmsi004tab5Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi004tab5Bean", this.semmsi004tab5Bean);
	}
	
	private SEMMSI004Tab6Bean semmsi004tab6Bean;
	
	public SEMMSI004Tab6Bean getSemmsi004tab6Bean() {
		return (SEMMSI004Tab6Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi004tab6Bean");
	}

	public void setSemmsi004tab6Bean(SEMMSI004Tab6Bean semmsi004tab6Bean) {
		this.semmsi004tab6Bean = semmsi004tab6Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi004tab6Bean", this.semmsi004tab6Bean);
	}
	
	private SEMMSI004Tab7Bean semmsi004tab7Bean;
	
	public SEMMSI004Tab7Bean getSemmsi004tab7Bean() {
		return (SEMMSI004Tab7Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi004tab7Bean");
	}

	public void setSemmsi004tab7Bean(SEMMSI004Tab7Bean semmsi004tab7Bean) {
		this.semmsi004tab7Bean = semmsi004tab7Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi004tab7Bean", this.semmsi004tab7Bean);
	}
	
	private SEMMSI004Tab1Action semmsi004tab1Action;
	
	public SEMMSI004Tab1Action getSemmsi004tab1Action() {
		if(semmsi004tab1Action == null){
			semmsi004tab1Action = new SEMMSI004Tab1Action();
		}
		return semmsi004tab1Action;
	}

	public void setSemmsi004tab1Action(SEMMSI004Tab1Action semmsi004tab1Action) {
		this.semmsi004tab1Action = semmsi004tab1Action;
	}
	
	private SEMMSI004Tab2Action semmsi004tab2Action;
	
	public SEMMSI004Tab2Action getSemmsi004tab2Action() {
		if(semmsi004tab2Action == null){
			semmsi004tab2Action = new SEMMSI004Tab2Action();
		}
		return semmsi004tab2Action;
	}

	public void setSemmsi004tab2Action(SEMMSI004Tab2Action semmsi004tab2Action) {
		this.semmsi004tab2Action = semmsi004tab2Action;
	}
	
	private SEMMSI004Tab3Action semmsi004tab3Action;

	public SEMMSI004Tab3Action getSemmsi004tab3Action() {
		if(semmsi004tab3Action == null){
			semmsi004tab3Action = new SEMMSI004Tab3Action();
		}
		return semmsi004tab3Action;
	}

	public void setSemmsi004tab3Action(SEMMSI004Tab3Action semmsi004tab3Action) {
		this.semmsi004tab3Action = semmsi004tab3Action;
	}
	
	private SEMMSI004Tab4Action semmsi004tab4Action;

	public SEMMSI004Tab4Action getSemmsi004tab4Action() {
		if(semmsi004tab4Action == null){
			semmsi004tab4Action = new SEMMSI004Tab4Action();
		}
		return semmsi004tab4Action;
	}

	public void setSemmsi004tab4Action(SEMMSI004Tab4Action semmsi004tab4Action) {
		this.semmsi004tab4Action = semmsi004tab4Action;
	}
	
	private SEMMSI004Tab5Action semmsi004tab5Action;

	public SEMMSI004Tab5Action getSemmsi004tab5Action() {
		if(semmsi004tab5Action == null){
			semmsi004tab5Action = new SEMMSI004Tab5Action();
		}
		return semmsi004tab5Action;
	}

	public void setSemmsi004tab5Action(SEMMSI004Tab5Action semmsi004tab5Action) {
		this.semmsi004tab5Action = semmsi004tab5Action;
	}
	
	private SEMMSI004Tab6Action semmsi004tab6Action;

	public SEMMSI004Tab6Action getSemmsi004tab6Action() {
		if(semmsi004tab6Action == null){
			semmsi004tab6Action = new SEMMSI004Tab6Action();
		}
		return semmsi004tab6Action;
	}

	public void setSemmsi004tab6Action(SEMMSI004Tab6Action semmsi004tab6Action) {
		this.semmsi004tab6Action = semmsi004tab6Action;
	}
	private SEMMSI004Tab7Action semmsi004tab7Action;

	public SEMMSI004Tab7Action getSemmsi004tab7Action() {
		if(semmsi004tab7Action == null){
			semmsi004tab7Action = new SEMMSI004Tab7Action();
		}
		return semmsi004tab7Action;
	}

	public void setSemmsi004tab7Action(SEMMSI004Tab7Action semmsi004tab7Action) {
		this.semmsi004tab7Action = semmsi004tab7Action;
	}

//	@Override
//	public void clearReport() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void enableBatchType() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void resetReportDate() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void runReport() {
//		semmsi004Bean = getSemmsi004Bean();
//		SiteInfoSP si = null;
//		SEMESI001ReportParameter param = null;
//		
//		if (validateSearch()) {
//			try {
//				si = semmsi004Bean.getSiteInfoSP();
//				param = new SEMESI001ReportParameter();
//				param.setDocNo(si.getDocNo());
//				param.setCompany(si.getCompany());
//				param.setRegion(si.getRegion());
//				param.setReqType(si.getReqType());
//				param.setTitle(si.getTitle());
//				param.setAssignContractNo(si.getAssignContractNo());
//				param.setLegalApproveStatus(si.getLegalApproveStatus());
//				param.setLocationId(si.getLocationId());
//				param.setLocationCode(si.getLocationCode());
//				param.setSiteName(si.getLocationName());
//				param.setSiteType(si.getSiteType());
//				param.setSiteInfoStatus(si.getSiteInfoStatus());
//				param.setSiteStatus(si.getSiteStatus());
//				param.setContractNo(si.getContractNo());
//				param.setPendingStatus(si.getPendingStatus());
//				param.setExpireStatus(si.getExpireStatus());
//				param.setEffectiveDtFrom(si.getEffDateFrom());
//				param.setEffectiveDtTo(si.getEffDateTo());
//				param.setExpireDtFrom(si.getExpDateFrom());
//				param.setExpireDtTo(si.getEffDateTo());
//				param.setNoExpireFlag(si.getNoExpireFlag());
//				param.setLessorName(si.getLessorName());
//				param.setCurrentFlag(si.getCurrentFlag());
//				
//				super.runReport("SEMESI001", param, 
//						semmsi004Bean.getReportType(), semmsi004Bean.getRunType(), 
//						semmsi004Bean.getBatchType(), semmsi004Bean.getJobSchedule());
//			
//			} catch (Exception e) {
//				log.error("RUN REPORT ERROR IN " + getClass() +  " : " + e);
//				e.printStackTrace();
//			} finally{
//				param = null;
//			}
//		}
//	}
//
//	@Override
//	public void showReport() {
//		showReport("SEMESI001", getSemmsi004Bean().getReportType());
//	}
//	
	public void approveEL(String tabNo){
		semmsi004Bean = getSemmsi004Bean();
		try{
			ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
			ApproveSiteInfoSP criteria = new ApproveSiteInfoSP();
			criteria.setSiteInfoId(semmsi004Bean.getSiteInfoId());
			criteria.setScreen(tabNo);
			criteria.setCurrentUser(semmsi004Bean.getUserLogin());
			service.querySPList(EQueryName.SP_APPROVE_EL.name, criteria);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public boolean checkSiteInfo (){
		semmsi004Bean = getSemmsi004Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		semmsi004Bean.setTmpRowId(rowId);
		ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
		String docApproveId = (String)getFacesUtils().getRequestParameter("docApproveId");
		SiteInfoSP tmpSiteInfo = new SiteInfoSP();
		for(WrapperBeanObject<SiteInfoSP> obj :semmsi004Bean.getSiteInfoSPList()){
			tmpSiteInfo = (SiteInfoSP)obj.getDataObj();
			if(StringUtils.equals(tmpSiteInfo.getDocApproveId(), docApproveId)){
				break;
			}
		}
		semmsi004Bean.setTmpSiteInfoSP(tmpSiteInfo);
		Msi004ChkCopySP msi004ChkCopy = new Msi004ChkCopySP();
		msi004ChkCopy.setDocApproveId(docApproveId);
		List<Msi004ChkCopySP> resultList = null;
		if(tmpSiteInfo.getSiteInfoId() == null)
			tmpSiteInfo.setSiteInfoId("");
		if(tmpSiteInfo.getSiteType() == null)
			tmpSiteInfo.setSiteType("");
		//
		try {
			resultList = service.querySPList(EQueryName.SP_MSI004_CHK_ALERT.name, msi004ChkCopy);
			if (resultList != null && !resultList.isEmpty()) {
				String resultMsg = resultList.get(0).getResult();
				if (resultMsg.equals("Success")) {
					semmsi004Bean.setPopupConfirmSiteInfo(true);
					semmsi004Bean.setDisabledLink(true);
				} else {
					String errMsg = resultList.get(0).getErrorMsg();
					semmsi004Bean.setComfirmSiteInfo(errMsg);
					semmsi004Bean.setPopupConfirmSiteInfo(false);
				}
			}
			log.debug("popup = "+semmsi004Bean.isPopupConfirmSiteInfo());
		} catch (Exception e) {
			addGeneralMessageError("ERROR ในการตรวจสอบ SiteInfo.");
			e.printStackTrace();
		}
		setSemmsi004Bean(semmsi004Bean);
		return false;
	}
	
	public void getDataBySiteInfoIdForCopySiteInfo(String siteInfoId) {
		try{
			// GET SITE INFO
			this.getSiteInfoByRowId(siteInfoId);
			
			// GET SITE CONTRACT
			this.getSiteContractBySiteInfoId(siteInfoId);
			
			// GET SITE CONSTRUCT
//			this.getSiteConstructBySiteInfoId(siteInfoId);
			
			// GET SITE ELECTRIC
			this.getSiteElectricBySiteInfoId(siteInfoId);
			
			// GET SITE INSURANCE
			this.getSiteInsuranceBySiteInfoId(siteInfoId);
			
			// GET SITE RENT
			this.getSiteRentBySiteInfoId(siteInfoId);
			
			// GET SITE PROPERTY TAX
			this.getSitePropertyTaxBySiteInfoId(siteInfoId);
			
			// GET SITE LESSOR LIST
			this.getSiteLessorListBySiteInfoId(siteInfoId);
			
			// GET SITE DEPOSIT LIST
			this.getSiteDepositBySiteInfoId(siteInfoId);
			
			// GET SITE RENTCOND LIST
			this.getSiteRentCondListBySiteInfoId(siteInfoId);
			
			// GET SITE SUBRENT LIST
			this.getSiteSubRentListBySiteInfoId(siteInfoId);
			
			//GET LOCATION call SEM_SP_MSI004_SRCH_MAP_LOC 
			this.getSiteInfoMapLoc(siteInfoId);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public boolean doGenDummy(){
		boolean flag = false;
		semmsi004Bean = getSemmsi004Bean();
		ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
		//List<Msi004GenDummy> to;
		List<SiteInfoSP> to;
//		Msi004GenDummy msi004GenDummy = new Msi004GenDummy();
//		msi004GenDummy.setCompany(semmsi004Bean.getSiteInfoSP().getCompany());
//		msi004GenDummy.setUser(getUserLogIn());
		SiteInfoSP siteinfo = new SiteInfoSP();
		siteinfo = semmsi004Bean.getSiteInfoSP();
		siteinfo.setUserId(getUserLogIn());
		semmsi004Bean.setSiteInfoData(new SiteInfoSP());
		//semmsi004Bean.setSiteInfoData(siteinfo);
		try{
			to = service.querySPList(EQueryName.SP_MEL011_GEN_DUMMY.name, siteinfo);
			if(to != null && to.size() > 0){
				if(StringUtils.equals("Success", to.get(0).getpResult())){
					semmsi004Bean.setDummyContractId(to.get(0).getpRemark());
//					semmsi004Bean.getSiteInfoData().setContractNo(to.get(0).getpRemark());
					semmsi004Bean.getSiteInfoData().setSiteInfoId(to.get(0).getpRemark());
					semmsi004Bean.getSiteInfoData().setCompany(siteinfo.getCompany());
					semmsi004Bean.getSiteInfoData().setRegion(siteinfo.getRegion());
					semmsi004Bean.getSiteInfoData().setLocationId(siteinfo.getLocationId());
					flag = true;
					//addMessageInfo("M0006",to.get(0).getpRemark());
				}else{
					addMessageError("E0008",to.get(0).getpRemark());
				}
				
			}else{
				addMessageError("E0001");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			setSemmsi004Bean(semmsi004Bean);
			service = null;
		}
		return flag;
	}
	
	public void doCheckGenDummy(){
		semmsi004Bean = getSemmsi004Bean();
		String company = "";
		String LocationId = "";
		String region = "";
		semmsi004Bean.setDisabledBtnGenDummy(true);
		try{
			if(!semmsi004Bean.getSiteInfoSP().getCompany().isEmpty()){
				company = semmsi004Bean.getSiteInfoSP().getCompany();
			}
			if(!semmsi004Bean.getSiteInfoSP().getRegion().isEmpty()){
				region = semmsi004Bean.getSiteInfoSP().getRegion();
			}
			if(!semmsi004Bean.getSiteInfoSP().getLocationId().isEmpty()){
				if(this.getSiteLocation()){
					LocationId = semmsi004Bean.getSiteInfoSP().getLocationId();
				}
			}
			if(!company.equals("") && !LocationId.equals("") && !region.equals("")){
				semmsi004Bean.setDisabledBtnGenDummy(false);
			}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			setSemmsi004Bean(semmsi004Bean);
		}
	}
	
	//create by new 17/02/2015
	public boolean doBackWard(){
		boolean flag = false;
		semmsi004Bean = getSemmsi004Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		semmsi004tab2Bean = getSemmsi004tab2Action().getSemmsi004tab2Bean();
		try{
			flag = true;
			
			setSemmsi004Bean(semmsi004Bean);
			setSemmsi004tab1Bean(semmsi004tab1Bean);
			getSemmsi004tab2Action().setSemmsi004tab2Bean(semmsi004tab2Bean);
			
			this.doSearch();
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return flag;
	}
	
	public boolean doValidateSaveEditDummy(){
		boolean flag = true;
		semmsi004Bean = getSemmsi004Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		try{
			if(StringUtils.isEmpty(semmsi004Bean.getSiteInfoData().getSiteType())){
				addMessageErrorWithArgument("W0001",msg("message.siteType"));
				flag = false;
				return flag;
			}
			if(semmsi004Bean.getSiteInfoData().getFristEffDT() == null){
				addMessageErrorWithArgument("W0001",msg("message.firstEffDate"));
				flag = false;
				return flag;
			}
			if(semmsi004Bean.getSiteInfoData().getEffDate() == null){
				addMessageErrorWithArgument("W0001",msg("message.effDate"));
				flag = false;
				return flag;
			}
			if(StringUtils.isEmpty(semmsi004Bean.getSiteInfoData().getPlaceType())){
				addMessageErrorWithArgument("W0001",msg("export.excel.placeType"));
				flag = false;
				return flag;
			}
			if(StringUtils.isEmpty(semmsi004Bean.getSiteInfoData().getSiteHouseNo())){
				addMessageErrorWithArgument("W0001",msg("message.siteHouseNo"));
				flag = false;
				return flag;
			}
			if(StringUtils.isEmpty(semmsi004Bean.getSiteInfoData().getSiteTambon())){
				addMessageErrorWithArgument("W0001",msg("message.siteTambon"));
				flag = false;
				return flag;
			}
			if(StringUtils.isEmpty(semmsi004Bean.getSiteInfoData().getSiteAmphurId())){
				addMessageErrorWithArgument("W0001",msg("message.siteAmphur"));
				flag = false;
				return flag;
			}
			if(StringUtils.isEmpty(semmsi004Bean.getSiteInfoData().getSiteProvinceId())){
				addMessageErrorWithArgument("W0001",msg("message.siteProvince"));
				flag = false;
				return flag;
			}
			if(StringUtils.isEmpty(semmsi004Bean.getSiteInfoData().getRightHouseNo())){
				addMessageErrorWithArgument("W0001",msg("message.rightHouseNo"));
				flag = false;
				return flag;
			}
			if(StringUtils.isEmpty(semmsi004Bean.getSiteInfoData().getRightTambon())){
				addMessageErrorWithArgument("W0001",msg("message.rightTambon"));
				flag = false;
				return flag;
			}
			if(StringUtils.isEmpty(semmsi004Bean.getSiteInfoData().getRightAmphur())){
				addMessageErrorWithArgument("W0001",msg("message.rightAmphur"));
				flag = false;
				return flag;
			}
			if(StringUtils.isEmpty(semmsi004Bean.getSiteInfoData().getRightProvince())){
				addMessageErrorWithArgument("W0001",msg("message.rightProvince"));
				flag = false;
				return flag;
			}
			if(!semmsi004tab1Bean.isChkElectricType1() && !semmsi004tab1Bean.isChkElectricType2()
					&& !semmsi004tab1Bean.isChkElectricType3() && !semmsi004tab1Bean.isChkElectricType4()){
				addMessageErrorWithArgument("W0001",msg("message.electricType"));
				flag = false;
				return flag;
			}
						
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return flag;
	}
	
	public boolean doSaveEditDummy(){
		boolean flag = false;
		semmsi004Bean = getSemmsi004Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
		List<SiteInfoSP> to = null;
		SiteInfoSP siteInfoSP;
		String locationId = "";
		try{
//			semmsi004Bean.getSiteInfoData().setUserId(getUserLogIn());
			//set param for save dummy
			siteInfoSP = semmsi004Bean.getSiteInfoData();
			siteInfoSP.setUserId(getUserLogIn());
			
			this.chkCheckBoxFlag();
//			if(semmsi004tab1Bean.isChkNoUnitPriceFlag())siteInfoSP.setNoUnitPriceFlag("Y");
			//validate 
			if(doValidateSaveEditDummy()){
				if(semmsi004tab1Bean.getSiteInfoMapLocSPList() != null){
					for(SiteInfoMapLocSP siteInfoMapLocSP : semmsi004tab1Bean.getSiteInfoMapLocSPList()){
//						if(locationId.equals("")){
//							locationId = siteInfoMapLocSP.getLocationId();
//						}else{
//							locationId = locationId+","+siteInfoMapLocSP.getLocationId();
//						}
						if(siteInfoMapLocSP.getMainLocFlag() != null){
							if(siteInfoMapLocSP.getMainLocFlag().equals("Y")){
								siteInfoSP.setLocationId(siteInfoMapLocSP.getLocationId());
								
							}
						}
					}
//					siteInfoSP.setLocationId(locationId);
				}
				log.debug("payPeriodType : "+siteInfoSP.getPayPeriodType());
				to = service.querySPList(EQueryName.SP_MEL011_SAVE_DUMMY.name, siteInfoSP);
				
				if(to != null && to.size() > 0){
					if(StringUtils.equals("Success", to.get(0).getpResult())){
//						semmsi004Bean.setDummyContractId(to.get(0).getpRemark());
//						semmsi004Bean.getSiteInfoData().setContractNo(to.get(0).getpRemark());
						flag = true;
						addMessageInfo(to.get(0).getpRemark());
						semmsi004Bean.setRenderedMsgFormSearch(true);
					}else{
						addMessageError(to.get(0).getpRemark());
						semmsi004Bean.setRenderedMsgFormSearch(true);
					}
					
				}else{
					addMessageError("E0001");
					semmsi004Bean.setRenderedMsgFormSearch(true);
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			addMessageError("E0001");
			semmsi004Bean.setRenderedMsgFormSearch(true);
			// TODO: handle exception
		}finally{
			service = null;
			setSemmsi004Bean(semmsi004Bean);
		}
		
		return flag;
	}
	
	public void chkCheckBoxFlag(){
		semmsi004Bean = getSemmsi004Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		try{
			if(semmsi004Bean.isChkNoExpireFlag()){
				semmsi004Bean.getSiteInfoData().setChkNoExpireFlag("Y");
			}else{
				semmsi004Bean.getSiteInfoData().setChkNoExpireFlag("N");
			}
			
			if(semmsi004tab1Bean.getSiteElectric().getElectricOwnerType() != null){
				semmsi004Bean.getSiteInfoData().setElectricOwnerType(semmsi004tab1Bean.getSiteElectric().getElectricOwnerType());
			}
			
			
			if(semmsi004tab1Bean.isChkNoUnitPriceFlag())
				semmsi004Bean.getSiteInfoData().setNoUnitPriceFlag("Y");
			else
				semmsi004Bean.getSiteInfoData().setNoUnitPriceFlag("N");
			
			if(!StringUtils.isEmpty(semmsi004tab1Bean.getPayPeriodType01())){
				semmsi004Bean.getSiteInfoData().setPayPeriodType(semmsi004tab1Bean.getPayPeriodType01());
			}
			
			if(!StringUtils.isEmpty(semmsi004tab1Bean.getPayPeriodType02())){
				semmsi004Bean.getSiteInfoData().setPayPeriodType(semmsi004tab1Bean.getPayPeriodType02());
			}
			
			if(!StringUtils.isEmpty(semmsi004tab1Bean.getPayPeriodType03())){
				semmsi004Bean.getSiteInfoData().setPayPeriodType(semmsi004tab1Bean.getPayPeriodType03());
			}
				if(semmsi004tab1Bean.getPayPeriod03() != null){
					semmsi004tab1Bean.getSiteElectric().setPayPeriod(semmsi004tab1Bean.getPayPeriod03());
					semmsi004Bean.getSiteInfoData().setPayPeriod(semmsi004tab1Bean.getPayPeriod03());
				}
			if(!StringUtils.isEmpty(semmsi004tab1Bean.getPayPeriodType04())){
				semmsi004Bean.getSiteInfoData().setPayPeriodType(semmsi004tab1Bean.getPayPeriodType04());
			}
				if(semmsi004tab1Bean.getPayPeriod04() != null){
					semmsi004tab1Bean.getSiteElectric().setPayPeriod(semmsi004tab1Bean.getPayPeriod04());
					semmsi004Bean.getSiteInfoData().setPayPeriod(semmsi004tab1Bean.getPayPeriod04());
				}
			if(!StringUtils.isEmpty(semmsi004tab1Bean.getPayPeriodType05())){
				semmsi004Bean.getSiteInfoData().setPayPeriodType(semmsi004tab1Bean.getPayPeriodType05());
			}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			setSemmsi004Bean(semmsi004Bean);
			setSemmsi004tab1Bean(semmsi004tab1Bean);
		}
	}
	
	public boolean doTransfer(){
		boolean flag = false;
		semmsi004Bean = getSemmsi004Bean();
		ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
		List<SiteInfoSP> to = null;
		try{
			semmsi004Bean.getSiteInfoData().setUserId(getUserLogIn());
			
			log.debug("doTransfer siteInfoId  : "+semmsi004Bean.getSiteInfoData().getTransferSiteInfoId());
			log.debug("doTransfer contractNo : "+semmsi004Bean.getSiteInfoData().getTransferContNo());
			log.debug("doTransfer siteInfoId dum : "+semmsi004Bean.getSiteInfoData().getRowId());
			log.debug("doTransfer contractNo dum : "+semmsi004Bean.getSiteInfoData().getContractNo());
			log.debug("doTransfer userId : "+semmsi004Bean.getSiteInfoData().getUserId());
			to = service.querySPList(EQueryName.SP_MEL011_TRANSFER_DUMMY.name, semmsi004Bean.getSiteInfoData());
			
			if(to != null && to.size() > 0){
				if(StringUtils.equals("Success", to.get(0).getpResult())){
//					semmsi004Bean.setDummyContractId(to.get(0).getpRemark());
//					semmsi004Bean.getSiteInfoData().setContractNo(to.get(0).getpRemark());
					flag = true;
//					log.debug("message success : "+to.get(0).getpRemark());
					addMessageInfo(to.get(0).getpRemark());
					semmsi004Bean.setSiteInfoSP(new SiteInfoSP());
					this.init();
//					this.doSearchDummy();
				}else{
					addMessageError(to.get(0).getpRemark());
//					log.error("message error : "+to.get(0).getpRemark());
				}
				
				semmsi004Bean.setDisabledTransfer(true);
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
			setSemmsi004Bean(semmsi004Bean);
		}
		
		return flag;
	}
	
	public boolean initDeleteDummy(){
		boolean flag = false;
		semmsi004Bean = getSemmsi004Bean();
		String siteInfoId;
		try{
			siteInfoId = getFacesUtils().getRequestParameter("siteInfoId") == null ? "" : (String)getFacesUtils().getRequestParameter("siteInfoId");
			
			if(!"".equals(siteInfoId)){
				semmsi004Bean.setSiteInfoIdTemp(siteInfoId);
				flag = true;
			}
		}catch (Exception e) {
			flag = false;
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			setSemmsi004Bean(semmsi004Bean);
		}
		return flag;
	}
	
	public boolean doDeleteDummy(){
		semmsi004Bean = getSemmsi004Bean();
		ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
		List<SiteInfoSP> to = null;
		SiteInfoSP siteInfoSP = new SiteInfoSP();
		boolean flag = false;
		try{
			siteInfoSP.setSiteInfoId(semmsi004Bean.getSiteInfoIdTemp());
			siteInfoSP.setUserId(getUserLogIn());
			to = service.querySPList(EQueryName.SP_MEL011_DEL_DUMMY.name, siteInfoSP);
			if(to != null && to.size() > 0){
				if(StringUtils.equals("Success", to.get(0).getpResult())){
//					semmsi004Bean.setDummyContractId(to.get(0).getpRemark());
//					semmsi004Bean.getSiteInfoData().setContractNo(to.get(0).getpRemark());
					this.doSearch();
					flag = true;
					addMessageInfo("M0002",to.get(0).getpRemark());
					semmsi004Bean.setRenderedMsgFormSearch(true);
				}else{
					addMessageError("E0002",to.get(0).getpRemark());
					semmsi004Bean.setRenderedMsgFormSearch(true);
				}
				
			}else{
				addMessageError("E0001");
			}
		}catch (Exception e) {
			e.printStackTrace();
			addMessageError("E0004");
			// TODO: handle exception
		}finally{
			service = null;
			setSemmsi004Bean(semmsi004Bean);
		}
		return flag;
	}
	
	public void getSiteAmphurList(){
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		semmsi004Bean = getSemmsi004Bean();
		Province province = new Province();
		if(semmsi004Bean.getSiteInfoData().getSiteProvinceId() != null){
			province.setRowId(semmsi004Bean.getSiteInfoData().getSiteProvinceId());
			semmsi004tab1Bean.setSiteAmphurList(this.getAmphurByProvince(province));
		}
		setSemmsi004tab1Bean(semmsi004tab1Bean);
	}
	
	private boolean doSelectContractNo() {
		boolean flag = false;
		semmsi004Bean = getSemmsi004Bean();
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
			semmsi004Bean.getSiteInfoData().setTransferSiteInfoId(siteInfoId);
			semmsi004Bean.getSiteInfoData().setTransferContNo(contractNo);
			semmsi004Bean.getSiteInfoData().setUserId(getUserLogIn());
			semmsi004Bean.setDisabledTransfer(false);
			log.debug("siteInfoId  : "+semmsi004Bean.getSiteInfoData().getTransferSiteInfoId());
			log.debug("contractNo : "+semmsi004Bean.getSiteInfoData().getTransferContNo());
			log.debug("siteInfoId dum : "+semmsi004Bean.getSiteInfoData().getRowId());
			log.debug("contractNo dum : "+semmsi004Bean.getSiteInfoData().getContractNo());
			setSemmsi004Bean(semmsi004Bean);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			popupAction = null;
		}
		//setPopupSiteContractBean(popupSiteContractBean);
		return flag;
	}
	
	public boolean getSiteLocation() {
		boolean flag = false;
		PopupSiteLocationBean popupSiteLocationBean = new PopupSiteLocationBean();
		semmsi004Bean = getSemmsi004Bean();
//		PopupSiteLocationAction popupSiteLocationAction = new PopupSiteLocationAction();
		ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
		List<SiteInfoSP> to = null;
//		semmsi004Bean.setDisabledBtnGenDummy(true);
		try{
			if(semmsi004Bean.getSiteInfoSP().getLocationId() != null){
				to = service.querySPList(EQueryName.SP_MEL011_CHK_LOC.name, semmsi004Bean.getSiteInfoSP());
				
				if(to != null){
					for(SiteInfoSP siteInfo : to){
						if("Success".equals(siteInfo.getpResult())){
//							semmsi004Bean.setDisabledBtnGenDummy(false);
							if(!StringUtils.isEmpty(siteInfo.getpRemark())){
//								addMessageWarn(siteInfo.getpRemark(), siteInfo.getContractNo());
								addMessageWarn("incContent:frmSearchCriteria:txtLocationId", siteInfo.getpRemark(), 
										semmsi004Bean.getSiteInfoSP().getLocationId(), siteInfo.getContractNo());
							}
							flag = true;
						}else{
							addMessageError(siteInfo.getpRemark(), semmsi004Bean.getSiteInfoSP().getLocationId());
							flag = false;
//							semmsi004Bean.setDisabledBtnGenDummy(true);
						}
					}
				}else{
					addMessageError("W0061", semmsi004Bean.getSiteInfoSP().getLocationId());
					flag = false;
//					semmsi004Bean.setDisabledBtnGenDummy(true);
				}
//				popupSiteLocationBean.setLocationId(semmsi004Bean.getSiteInfoSP().getLocationId());
//				popupSiteLocationAction.setPopupSiteLocationBean(popupSiteLocationBean);
//				popupSiteLocationAction.getSiteLocation();
//				popupSiteLocationBean = popupSiteLocationAction.getPopupSiteLocationBean();
			}
			
		}catch (Exception e) {
			addMessageError("E0001");
			log.error(e);
			e.printStackTrace();
			// TODO: handle exception
		}finally{
//			popupSiteLocationAction = null;
			setSemmsi004Bean(semmsi004Bean);
			service = null;
			popupSiteLocationBean = null;
		}
		return flag;
	}
	
	public void renderedSiteName() {
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		
		if (semmsi004tab1Bean.isChkEditSite()) {
			semmsi004tab1Bean.setDisabledSiteName(false);
		} else {
			semmsi004tab1Bean.setDisabledSiteName(true);
		}
		setSemmsi004tab1Bean(semmsi004tab1Bean);
	}
	
	public boolean doRollBack(){
		boolean flag = false;
		semmsi004Bean = getSemmsi004Bean();
		ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
		List<SiteInfoSP> to = null;
		try{
			semmsi004Bean.getSiteInfoData().setUserId(getUserLogIn());
			
			log.debug("doTransfer siteInfoId  : "+semmsi004Bean.getSiteInfoData().getTransferSiteInfoId());
			log.debug("doTransfer contractNo : "+semmsi004Bean.getSiteInfoData().getTransferContNo());
			log.debug("doTransfer siteInfoId dum : "+semmsi004Bean.getSiteInfoData().getRowId());
			log.debug("doTransfer contractNo dum : "+semmsi004Bean.getSiteInfoData().getContractNo());
			log.debug("doTransfer userId : "+semmsi004Bean.getSiteInfoData().getUserId());
			to = service.querySPList(EQueryName.SP_MEL011_ROLLBACK_DUMMY.name, semmsi004Bean.getSiteInfoData());
			
			if(to != null && to.size() > 0){
				if(StringUtils.equals("Success", to.get(0).getpResult())){
//					semmsi004Bean.setDummyContractId(to.get(0).getpRemark());
//					semmsi004Bean.getSiteInfoData().setContractNo(to.get(0).getpRemark());
					flag = true;
//					log.debug("message success : "+to.get(0).getpRemark());
					addMessageInfo(to.get(0).getpRemark());
					semmsi004Bean.setSiteInfoSP(new SiteInfoSP());
					this.init();
//					this.doSearchDummy();
				}else{
					addMessageError(to.get(0).getpRemark());
//					log.error("message error : "+to.get(0).getpRemark());
				}
				
				semmsi004Bean.setDisabledTransfer(true);
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
			setSemmsi004Bean(semmsi004Bean);
		}
		
		return flag;
	}
	

}
