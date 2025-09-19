package th.co.ais.web.si.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.richfaces.component.UITree;
import org.richfaces.component.html.HtmlTree;
import org.richfaces.event.NodeSelectedEvent;
import org.richfaces.model.TreeNode;
import org.richfaces.model.TreeNodeImpl;

import th.co.ais.common.service.IMenuTreeService;
import th.co.ais.domain.ac.Mac003Srch;
import th.co.ais.domain.common.MenuTreeSP;
import th.co.ais.domain.gm.Province;
import th.co.ais.domain.mm.ItemResultSP;
import th.co.ais.domain.rt.EMAILModel;
import th.co.ais.domain.sa.SiteAppSP;
import th.co.ais.domain.sa.SiteAppSiteSP;
import th.co.ais.domain.si.ApproveSiteInfoSP;
import th.co.ais.domain.si.Construct;
import th.co.ais.domain.si.Contract;
import th.co.ais.domain.si.Deposit;
import th.co.ais.domain.si.Electric;
import th.co.ais.domain.si.Insurance;
import th.co.ais.domain.si.Lessor;
import th.co.ais.domain.si.Msi004CalcExpireDateSP;
import th.co.ais.domain.si.Msi004ChkCopySP;
import th.co.ais.domain.si.Msi004DefaultTotSP;
import th.co.ais.domain.si.Msi004GenDummy;
import th.co.ais.domain.si.Msi004SrchDepositElectricSP;
import th.co.ais.domain.si.Msi004SrchExportSP;
import th.co.ais.domain.si.Msi004SrchLessorSP;
import th.co.ais.domain.si.Msi004SrchRentCondSP;
import th.co.ais.domain.si.PropertyTax;
import th.co.ais.domain.si.Rent;
import th.co.ais.domain.si.RentCond;
import th.co.ais.domain.si.SiteInfo;
import th.co.ais.domain.si.SiteInfoMapLocSP;
import th.co.ais.domain.si.SiteInfoMapSiteAcqSP;
import th.co.ais.domain.si.SiteInfoSP;
import th.co.ais.domain.si.SiteInfoSeqSP;
import th.co.ais.domain.si.SubRent;
import th.co.ais.domain.si.SumDepositRentSP;
import th.co.ais.domain.si.SumRentSP;
import th.co.ais.rpt.parameter.SEMESI001ReportParameter;
import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.rpt.util.bean.CellDomain;
import th.co.ais.rpt.util.bean.EnumDocStyleDomain;
import th.co.ais.rpt.util.bean.RowDomain;
import th.co.ais.rpt.util.enums.EnumDocStyle;
import th.co.ais.rpt.util.enums.EnumDocumentType;
import th.co.ais.rpt.web.util.IReportWebHelper;
import th.co.ais.service.sa.ISiteAcquistionService;
import th.co.ais.service.si.ISiteApproveService;
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
import th.co.ais.web.bean.TreeUtilBean;
import th.co.ais.web.bean.common.PopupSiteContractBean;
import th.co.ais.web.bean.common.PopupSiteLocationBean;
import th.co.ais.web.bean.common.PopupUploadFilePictureBean;
import th.co.ais.web.common.action.PopupViewSiteInfoAction;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.util.DocumentExportManager;
import th.co.ais.web.sa.action.SEMMSA002Action;
import th.co.ais.web.sa.bean.SEMMSA002Bean;
import th.co.ais.web.si.bean.SEMMSI004Bean;
import th.co.ais.web.si.bean.SEMMSI004Tab1Bean;
import th.co.ais.web.si.bean.SEMMSI004Tab2Bean;
import th.co.ais.web.si.bean.SEMMSI004Tab3Bean;
import th.co.ais.web.si.bean.SEMMSI004Tab4Bean;
import th.co.ais.web.si.bean.SEMMSI004Tab5Bean;
import th.co.ais.web.si.bean.SEMMSI004Tab6Bean;
import th.co.ais.web.si.bean.SEMMSI004Tab7Bean;
import th.co.ais.web.util.EmailMessageUtil;
import th.co.ais.web.util.JSFServiceFinderUtil;
import th.co.ais.web.util.ProvinceCacheUtil;
import th.co.ais.web.util.RegionCacheUtil;

public class SEMMSI004Action extends AbstractReportAction {

	private static final long serialVersionUID = -1583285579687727946L;
	private Logger log = Logger.getLogger(getClass());
	
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
		}  else if(methodWithNavi.equalsIgnoreCase("doRunReport")){
			runReport();
		}else if(methodWithNavi.equalsIgnoreCase("checkSiteInfo")){
			checkSiteInfo();
		}else if(methodWithNavi.equalsIgnoreCase("doGenDummy")){
			doGenDummy();
		}else if(methodWithNavi.equalsIgnoreCase("getTreeNode")){
			getTreeNode();
		}else if(methodWithNavi.equalsIgnoreCase("doCopySiteInfo")){
			flag = doCopySiteInfo();
		}else if(methodWithNavi.equalsIgnoreCase("doCopyContract")){
			flag = doCopyContract();
		}else if(methodWithNavi.equalsIgnoreCase("doCopyRentalService")){
			flag = doCopyRentalService();
		}else if(methodWithNavi.equalsIgnoreCase("doCopyPropertyTax")){
			flag = doCopyPropertyTax();
		}else if(methodWithNavi.equalsIgnoreCase("doCopyElectric")){
			flag = doCopyElectric();
		}else if(methodWithNavi.equalsIgnoreCase("doCopyDepositElectric")){
			flag = doCopyDepositElectric();
		}else if(methodWithNavi.equalsIgnoreCase("doCopyInsurance")){
			flag = doCopyInsurance();
		}
		
		else if(methodWithNavi.equalsIgnoreCase("doRunReportNew")){
			runReportNew();
		}
		
		// 2015/01/22 added by.. YUT 
		else if(methodWithNavi.equalsIgnoreCase("doInitialForSearchSiteInfo")) {
			flag = this.doInitialForSearchSiteInfo();
		}else if(methodWithNavi.equalsIgnoreCase("doInitTodoList")){
			flag = this.doInitTodoList();
		}
		
		
		return flag;
	}
	
	private PopupUploadFilePictureBean popupUploadFilePictureBean;
	private EMAILModel email;
	
	public void setPopupUploadFilePictureBean(PopupUploadFilePictureBean popupUploadFilePictureBean) {
		this.popupUploadFilePictureBean = popupUploadFilePictureBean;
		getFacesUtils().setSessionMapValue("popupUploadFilePictureBean", popupUploadFilePictureBean);
	}		

	private boolean initChangeTab() {
		boolean flag = false;
		semmsi004Bean = getSemmsi004Bean();
		semmsa002Bean = getSemmsa002Bean();
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
				
				if(tabNo.equals("5")){
					semmsi004tab5Action.doSiteAppELCondSrch(semmsi004Bean.getSiteInfoId());
					semmsi004tab5Action.doSiteInfoELCondSrch("A");
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
			semmsa002Bean.setDisabledBtnCopySiteInfo(true);
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
				deleteMessageInfo();
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
	
	//added by NEW 2016/08/30
	private boolean autoSaveAllTab() {
		boolean flag = false;
		semmsi004Bean = getSemmsi004Bean();
		try{
			String tabNo = getSemmsi004Bean().getTabNo();
			semmsi004Bean.setShowMessageSave(false);
//			getSemmsi004Bean().isShowMessageSave()
			setSemmsi004Bean(semmsi004Bean);
			if(tabNo != null && tabNo.equals("1")){
				flag = getSemmsi004tab1Action().doUpdateTab1();
			}else if(tabNo != null && tabNo.equals("2")){
				flag = getSemmsi004tab2Action().doUpdateTab2();
			}else if(tabNo != null && tabNo.equals("3")){
				getSemmsi004tab3Action().autoSaveTab3(true);
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
//			getSemmsi004tab1Action().checkEnableApprove(getSemmsi004tab1Bean().getSiteInfo().getRowId());
			
			// check editable flag
//			this.checkEditabledFlag();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
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
			String elOwnerType = "";
			if(getSemmsi004tab5Action().getSemmsi004tab5Bean().getSiteElectric().getElectricOwnerType() != null){
				elOwnerType = getSemmsi004tab5Action().getSemmsi004tab5Bean().getSiteElectric().getElectricOwnerType();
			}
//			semmsi004tab5Bean = semmsi004tab5Action.getSemmsi004tab5Bean();
			
			semmsi004Bean.setTabHeader(msg("message.tab.site"));
			semmsi004Bean.setRenderBtnSave(true);
			semmsi004Bean.setRenderPanelLog(true);
			getSemmsi004tab1Bean().setChkNoExpenses(false);
			getSemmsi004tab1Action().getDataTab1(semmsi004tab1Bean.getSiteInfo().getRowId());
			this.getDataContract(semmsi004tab1Bean.getSiteInfo().getRowId());
			getSemmsi004tab1Action().checkMode(semmsi004tab1Bean.getSiteInfo().getRowId());
			if(semmsi004tab5Action.getSemmsi004tab5Bean().getSiteElectric() != null){
				semmsi004tab5Action.getSemmsi004tab5Bean().getSiteElectric().setElectricOwnerType(elOwnerType);
			}
			
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
		SEMMSA002Action semmsa002Action = new SEMMSA002Action();
		SEMMSA002Bean semmsa002Bean = new SEMMSA002Bean();
		String reqType = (String)getFacesUtils().getRequestParameter("reqType");
		String docApproveId = (String)getFacesUtils().getRequestParameter("docApproveId");
		String assignSiteInfoId = (String)getFacesUtils().getRequestParameter("assignSiteInfoId");
		String siteInfoId = (String)getFacesUtils().getRequestParameter("siteInfoId");
		String company = (String)getFacesUtils().getRequestParameter("company");
		String region = (String)getFacesUtils().getRequestParameter("region");
		String docApproveType = (String)getFacesUtils().getRequestParameter("docApproveType");
		String assignContractNo = (String)getFacesUtils().getRequestParameter("assignContractNo");
		String siteType = (String)getFacesUtils().getRequestParameter("siteType");
		String siteAppId = getFacesUtils().getRequestParameter("siteAppId") == null ? "" : (String)getFacesUtils().getRequestParameter("siteAppId");
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		String page = (String)getFacesUtils().getRequestParameter("page");
		try {
			getSemmsi004tab1Action().init();
			getSemmsi004tab1Action().initTab1();
			getSemmsi004tab2Action().init();
			getSemmsi004tab4Action().init();
			getSemmsi004tab4Action().initTab4(siteInfoId);
			getSemmsi004tab5Action().init();
			getSemmsi004tab5Action().initTab5(siteInfoId);
			getSemmsi004tab3Action().init();
			
			semmsi004Bean = getSemmsi004Bean();
			semmsi004Bean.setSiteInfo(new SiteInfo());
			semmsi004Bean.setSiteContract(new Contract());
			semmsi004Bean.setSiteConstruct(new Construct());
			semmsi004Bean.setSiteDeposit(new Deposit());
			semmsi004Bean.setSiteElectric(new Electric());
			semmsi004Bean.setSiteInfo(new SiteInfo());
			semmsi004Bean.setSiteInsurance(new Insurance());
			semmsi004Bean.setSiteLessor(new Lessor());
			semmsi004Bean.setSitePropertyTax(new PropertyTax());
			semmsi004Bean.setSiteRent(new Rent());
			semmsi004Bean.setSiteRentCond(new RentCond());
			semmsi004Bean.setSiteSubRent(new SubRent());
			semmsi004Bean.setPage(page);
			semmsi004Bean.setMode(mode);
			semmsi004Bean.setReqTypeParam(reqType);
			semmsi004Bean.setSiteTypeParam(siteType);
			semmsi004Bean.setSiteInfoId(siteInfoId);
			semmsi004Bean.setDocApproveIdParam(docApproveId);
			semmsi004Bean.setDocApproveTypeParam(docApproveType);
			semmsi004Bean.setCompanyParam(company);
			semmsi004Bean.setRegionParam(region);
			semmsi004Bean.setAssignContractNoParam(assignContractNo);
			semmsi004Bean.setRenderTab1(true);
			semmsi004Bean.setRenderPanelLog(true);
			semmsi004Bean.setRenderBtnSave(true);
			semmsi004Bean.setSelectedTab("tab1");
			semmsi004Bean.setTempTabNo("1");
			semmsi004Bean.setShowMessageSave(true);
			semmsi004Bean.setSiteAppObjParam(new SiteAppSP());
			semmsi004tab1Bean = getSemmsi004tab1Bean();
			
			if(StringUtils.equalsIgnoreCase(mode, "EDIT")||StringUtils.equalsIgnoreCase(mode, "VIEW")){
				semmsi004Bean.setDisabledLink(true);
			}
			
			if(semmsi004Bean.isDisabledLink()){
				semmsi004Bean.setDisabledLink(false);
				setSemmsi004Bean(semmsi004Bean);
				// save siteInfo
				if(siteInfoId.equals("")){
					// semmsi004Bean.setPageStatus("ADD");
					if(reqType != null && reqType.equals("01")){
						// CALL SEM_SP_MSI001_SRCH_MAP_LOC FOR SAVE
						getSemmsi004tab1Action().getSiteApproveMapLoc(docApproveId);
						
					}else{
						// GET DATA BY assignSiteInfoId (duplicate)
						getDataBySiteInfoId(assignSiteInfoId);
						
						// edit by ming 20110419 site rent cond set 'null'
						if (semmsi004Bean.getSiteRentCondList() != null && semmsi004Bean.getSiteRentCondList().size() > 0) {
							List<RentCond> tempList = semmsi004Bean.getSiteRentCondList();
							for (RentCond tmp : tempList) {
//								tmp.setEffectiveDt(null);
							}
						}
						
						// UPDATE OLD SITE INFO (LASTED FLAG = 'N')
//						semmsi004Bean.getSiteInfo().setLatestFlag("N");
//						this.updateSiteInfo();
						
					}
					
					// SAVE SEM_SI_SITE_INFO
					saveSiteInfo(reqType);
					
					getSemmsi004tab1Action().getDataTab1(getSemmsi004Bean().getSiteInfoId());
					// GET DATA CONTRACT
					this.getDataContract(getSemmsi004Bean().getSiteInfoId());
					
					//init tab5
//					getSemmsi004tab5Action().initTab5(siteInfoId);
//					getSemmsi004tab5Action().doSiteAppELCondSrch(siteInfoId,"A");
					getSemmsi004tab5Action().doSiteInfoELCondSrch("A");
				} else{
					getSemmsi004tab1Action().searchSumRent(siteInfoId);
					this.updateTotalRent(siteInfoId);
					getSemmsi004tab1Action().searchSumDepositRent(siteInfoId);
					this.updateTotalDeposit(siteInfoId);
					
					// MODE EDIT
					getSemmsi004tab1Action().getDataTab1(siteInfoId);
					// GET DATA CONTRACT
					this.getDataContract(siteInfoId);
					
					// GET SITE STATUS NAME
					getSemmsi004tab1Action().getSiteStatusNameBySiteInfoId(siteInfoId);
					
					//init tab5
//					getSemmsi004tab5Action().initTab5(siteInfoId);
//					getSemmsi004tab5Action().doSiteAppELCondSrch(siteInfoId,"A");
					getSemmsi004tab5Action().doSiteInfoELCondSrch("A");
					
				}
			}
			// CHECK BTN BACK
			if(page != null && page.equals("SITEINFO")){
				semmsi004Bean.setRenderedBtnBackSiteInfo(true);
				semmsi004Bean.setRenderedBtnBackContract(false);
			}else{
				semmsi004Bean.setRenderedBtnBackSiteInfo(false);
				semmsi004Bean.setRenderedBtnBackContract(true);
			}
			
			if(!"".equals(siteAppId)){
				semmsi004Bean.getSiteAppObjParam().setSiteAppId(siteAppId);
			}
			
			setSemmsi004Bean(semmsi004Bean);
			
			// CHECK MODE VIEW/EDIT
			getSemmsi004tab1Action().checkMode(getSemmsi004Bean().getSiteInfoId());
			
			//init popupViewSiteInfoAction
			PopupViewSiteInfoAction popupViewSiteInfoAction = new PopupViewSiteInfoAction();
			popupViewSiteInfoAction.initial(semmsi004Bean.getSiteInfoId());
			
			//init site rent
			this.getSiteRentBySiteInfoId(semmsi004Bean.getSiteInfoId());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			semmsi004Bean.setDisabledLink(false);
			setSemmsi004Bean(semmsi004Bean);
			semmsa002Action.setSemmsa002Bean(semmsa002Bean);
			semmsa002Action = null;
			semmsa002Bean = null;
		}
		return flag;
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
				if(semmsi004tab2Bean.getSiteContract().getDummyFlag() != null && 
					semmsi004tab2Bean.getSiteContract().getDummyFlag().equals("Y")){
					semmsi004tab2Bean.setChkDummyFlag(true);
				}else{
					semmsi004tab2Bean.setChkDummyFlag(false);
				}
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
					semmsi004tab2Bean.setChkNoExpireFlag(false);
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
							semmsi004tab2Bean.getSiteContract().getNoFormat().equals("N")) {
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
		}catch(Exception e){
			e.printStackTrace();
		}
		
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		setSemmsi004tab2Bean(semmsi004tab2Bean);
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
					semmsi004Bean.setChkNoDeposit(true);
					
				}else{
					semmsi004Bean.setChkNoRent(false);
					
					//rental deposit
					if(rent.getNoDeposit() != null && rent.getNoDeposit().equals("Y")){
						semmsi004Bean.setChkNoDeposit(true);
					}else{
						semmsi004Bean.setChkNoDeposit(false);
					}
				}
//				if(rent.getNoDeposit() != null && rent.getNoDeposit().equals("Y")){
//					semmsi004Bean.setChkNoDeposit(true);
//				}else{
//					semmsi004Bean.setChkNoDeposit(false);
//				}
				
				//added by NEW 23/02/2016 check box fix5% 
//				if(rent.getFix5Percent() != null && rent.getFix5Percent().equals("Y")){
//					semmsi004Bean.setFix5Percent(true);
//				}else{
//					semmsi004Bean.setFix5Percent(false);
//				}
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
		
		//added by NEW 18/03/2015 for to do list page
		semmsi004Bean.setTreeUtilBean(new TreeUtilBean());
		rootNode = null;
		semmsi004Bean.setMenuTreeMacroList(new ArrayList<WrapperBeanObject<MenuTreeSP>>());
		semmsi004Bean.setMenuTreePicoList(new ArrayList<WrapperBeanObject<MenuTreeSP>>());
		semmsi004Bean.setTreeMacroFlag(false);
		semmsi004Bean.setTreePicoFlag(false);
		setSemmsi004Bean(semmsi004Bean);
		return flag;
	}

	public boolean doSearch() {
		boolean flag = false;
		semmsi004Bean = getSemmsi004Bean();
		
		if(semmsi004Bean.getSiteInfoSP().getStrParam() == null){
		// incase search from To Do List
			
			if(!validateSearch()){
				semmsi004Bean.setRenderedMsgFormSearch(true);
				return flag;
			}
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
			
			if(semmsi004Bean.isChkNoExpireFlag()){
				semmsi004Bean.getSiteInfoSP().setNoExpireFlag("Y");
			}else{
				semmsi004Bean.getSiteInfoSP().setNoExpireFlag(null);
			}
			to = service.querySPList(EQueryName.Q_SEARCH_SITE_INFO.name, semmsi004Bean.getSiteInfoSP());
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
		semmsi004Bean.setTreeUtilBean(new TreeUtilBean());
		semmsi004Bean.setTodoReqTypeList(getLovItemsByType(ELovType.T_SI_TODO_MENU_REQ_TYPE.name));
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
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		boolean flag = false;
		List<ApproveSiteInfoSP> approveSiteInfoList = new ArrayList<ApproveSiteInfoSP>();
		ApproveSiteInfoSP approveSiteInfo = new ApproveSiteInfoSP();
		try{
			ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
			ApproveSiteInfoSP criteria = new ApproveSiteInfoSP();
			criteria.setSiteInfoId(semmsi004Bean.getSiteInfoId());
			criteria.setScreen(tabNo);
			criteria.setCurrentUser(semmsi004Bean.getUserLogin());
			approveSiteInfoList = service.querySPList(EQueryName.SP_APPROVE_SITE_INFO.name, criteria);
			
			//added by NEW 20160712 
			if(approveSiteInfoList.get(0) != null){
				approveSiteInfo = approveSiteInfoList.get(0);
				if(approveSiteInfo.getResultMsg() != null && StringUtils.equalsIgnoreCase("success", approveSiteInfo.getResultMsg())){
					if("02".equals(semmsi004tab1Bean.getSiteInfo().getSiteInfoStatus())){
						email = new EMAILModel();
						log.debug("criteria.getSiteInfoId()  := "+criteria.getSiteInfoId());
//						getLeaderApproveStatus strApprStatus,strApprRemark
//						email.setCreateDt(new Date());
//						email.setCreateBy(getUserLogIn());
//						email.setCurrentUser(getUserLogIn());
						email.setV_type("3");
						email.setRow_ID(criteria.getSiteInfoId());
						email.setUserId(getUserLogIn());
						email.setBatchFlag("N");
//						email.setV_Subject("Leader Reject DocNo:"+strDocNo);
//						email.setV_Message(strApprRemark);
//						email.setEmail_from("slimsAdmin@ais.co.th");
//						email.setEmail_to(msg("massage.MAIL_TEST"));
//						flag = this.doSendEmail(email);
					}
				}
			}
			
//			if("02".equals(semmsi004tab1Bean.getSiteInfo().getSiteInfoStatus())){
//				if(flag){
////					addMessageInfo("M0001");
//				}else{
//					addMessageError("W0117");
//				}
//			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	//added by NEW 20160712 send mail to owner when status reject
//    public boolean doSendEmail(EMAILModel email){
//    	semmsi004Bean = getSemmsi004Bean();
//    	boolean result = false;
//    	List<EMAILModel> emailList = new ArrayList<EMAILModel>();
//    	ISiteApproveService service = (ISiteApproveService)getBean("siteApproveService");
//    	try{
//    		
//    		emailList = service.querySPList(EQueryName.SP_MSA001_MAIL.name, email);
//			
//			if(emailList == null || emailList.size() == 0){
////				addMessageError("E0004");
//				result = false;
//			}else{
//				for(EMAILModel emailM :emailList){
////					emailM.setV_Message(emailM.getV_Message()+" FROM SEMMRT003-1");
////					emailM.setV_Message(emailM.getV_Message());
//					//test
////					email.setEmail_to(msg("massage.MAIL_TEST"));
////					email.setEmail_from(msg("MAIL_SEM"));
//					System.out.println("email from : "+emailM.getEmail_from());
//					System.out.println("email to : "+emailM.getEmail_to());
//					result = true;
//					EmailMessageUtil.sendEmail(emailM);
////					LOG.debug("result = "+result);
//				}
////				addMessageInfo("M0003");
////				result = EmailMessageUtil.sendEmail(email);
//			}
////    				
//    		
////							
//			log.debug("result = "+result);
//    	}catch (Exception e) {
//    		e.printStackTrace();
//    		log.debug("error from SEMMSI004 Action doSendEmail : "+e);
//			// TODO: handle exception
//		}finally{
//			email = null;
//		}
//		return result;
//    }
	
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
	private SEMMSI004Bean semmsi004Bean;
	
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

	@Override
	public void clearReport() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enableBatchType() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetReportDate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void runReport() {
		semmsi004Bean = getSemmsi004Bean();
		SiteInfoSP si = null;
		SEMESI001ReportParameter param = null;
		
		if (validateSearch()) {
			try {
				//set checkBox added by NEW 20160706
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
				
				if(semmsi004Bean.isChkNoExpireFlag()){
					semmsi004Bean.getSiteInfoSP().setNoExpireFlag("Y");
				}else{
					semmsi004Bean.getSiteInfoSP().setNoExpireFlag(null);
				}
				
				si = semmsi004Bean.getSiteInfoSP();
				param = new SEMESI001ReportParameter();
				param.setDocNo(si.getDocNo());
				param.setCompany(si.getCompany());
				param.setRegion(si.getRegion());
				param.setReqType(si.getReqType());
				param.setTitle(si.getTitle());
				param.setAssignContractNo(si.getAssignContractNo());
				param.setLegalApproveStatus(si.getLegalApproveStatus());
				param.setLocationId(si.getLocationId());
				param.setLocationCode(si.getLocationCode());
				param.setSiteName(si.getLocationName());
				param.setSiteType(si.getSiteType());
				param.setSiteInfoStatus(si.getSiteInfoStatus());
				param.setSiteStatus(si.getSiteStatus());
				param.setContractNo(si.getContractNo());
				param.setPendingStatus(si.getPendingStatus());
				param.setExpireStatus(si.getExpireStatus());
				param.setEffectiveDtFrom(si.getEffDateFrom());
				param.setEffectiveDtTo(si.getEffDateTo());
				param.setExpireDtFrom(si.getExpDateFrom());
				param.setExpireDtTo(si.getEffDateTo());
				param.setNoExpireFlag(si.getNoExpireFlag());
				param.setLessorName(si.getLessorName());
				param.setCurrentFlag(si.getCurrentFlag());
				
				super.runReport("SEMESI001", param, 
						semmsi004Bean.getReportType(), semmsi004Bean.getRunType(), 
						semmsi004Bean.getBatchType(), semmsi004Bean.getJobSchedule());
			
			} catch (Exception e) {
				log.error("RUN REPORT ERROR IN " + getClass() +  " : " + e);
				e.printStackTrace();
			} finally{
				param = null;
			}
		}
	}
	
	public void runReportNew(){
		semmsi004Bean = getSemmsi004Bean();
		SiteInfoSP si = null;
		SEMESI001ReportParameter param = null;
		
		if (validateSearch()) {
			try {
				//set checkBox added by NEW 20160706
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
				
				if(semmsi004Bean.isChkNoExpireFlag()){
					semmsi004Bean.getSiteInfoSP().setNoExpireFlag("Y");
				}else{
					semmsi004Bean.getSiteInfoSP().setNoExpireFlag(null);
				}
				
				si = semmsi004Bean.getSiteInfoSP();
				
				Map<String, Object> paramMap = new HashMap<String, Object>();
				paramMap.put("DOC_NO", si.getDocNo());
				paramMap.put("COMPANY", si.getCompany());
				paramMap.put("REGION", si.getRegion());
				paramMap.put("REQ_TYPE", si.getReqType());
				paramMap.put("TITLE", si.getTitle());
				paramMap.put("ASSGN_CNTRCT_NO", si.getAssignContractNo());
				paramMap.put("LEGAL_APPR_STTS", si.getLegalApproveStatus());
				paramMap.put("LOCATION_ID", si.getLocationId());
				paramMap.put("LOCATION_CODE", si.getLocationCode());
				paramMap.put("SITE_NAME", si.getSiteName());
				paramMap.put("SITE_TYPE", si.getSiteType());
				paramMap.put("SITE_INF_STTS", si.getSiteInfoStatus());
				paramMap.put("SITE_STTS", si.getSiteStatus());
				paramMap.put("CNTRCT_NO", si.getContractNo());
				paramMap.put("PENDING_STTS", si.getPendingStatus());
				paramMap.put("EXP_STTS", si.getExpireStatus());
				
				paramMap.put("EFFTVE_DT_FROM", si.getEffDateFrom());
				paramMap.put("EFFTVE_DT_TO", si.getEffDateTo());
				paramMap.put("EXP_DT_FROM", si.getExpDateFrom());
				paramMap.put("EXP_DT_TO", si.getExpDateTo());
				
//				if(si.getEffDateFrom() != null)paramMap.put("EFFTVE_DT_FROM", DateUtil.convertDateTime2StringNoLocale(si.getEffDateFrom(), "MM/dd/yyyy"));
//				if(si.getEffDateTo() != null)paramMap.put("EFFTVE_DT_TO", DateUtil.convertDateTime2StringNoLocale(si.getEffDateTo(), "MM/dd/yyyy"));
//				if(si.getExpDateFrom() != null)paramMap.put("EXP_DT_FROM", DateUtil.convertDateTime2StringNoLocale(si.getExpDateFrom(), "MM/dd/yyyy"));
//				if(si.getExpDateTo() != null)paramMap.put("EXP_DT_TO", DateUtil.convertDateTime2StringNoLocale(si.getExpDateTo(), "MM/dd/yyyy"));
				
//				if(si.getEffDateFrom() != null)paramMap.put("EFFTVE_DT_FROM", DateUtil.convertDateTime2StringNoLocale(si.getEffDateFrom(), DateUtil.SIMPLE_DATE_PATTERN));
//				if(si.getEffDateTo() != null)paramMap.put("EFFTVE_DT_TO", DateUtil.convertDateTime2StringNoLocale(si.getEffDateTo(), DateUtil.SIMPLE_DATE_PATTERN));
//				if(si.getExpDateFrom() != null)paramMap.put("EXP_DT_FROM", DateUtil.convertDateTime2StringNoLocale(si.getExpDateFrom(), DateUtil.SIMPLE_DATE_PATTERN));
//				if(si.getExpDateTo() != null)paramMap.put("EXP_DT_TO", DateUtil.convertDateTime2StringNoLocale(si.getExpDateTo(), DateUtil.SIMPLE_DATE_PATTERN));
				
				System.out.println("getEffDateFrom : "+DateUtil.convertDateTime2StringNoLocale(si.getEffDateFrom(), "MM/dd/yyyy"));
				System.out.println("getEffDateTo : "+DateUtil.convertDateTime2StringNoLocale(si.getEffDateTo(), "MM/dd/yyyy"));
				System.out.println("getExpDateFrom : "+DateUtil.convertDateTime2StringNoLocale(si.getExpDateFrom(), "MM/dd/yyyy"));
				System.out.println("getExpDateTo : "+DateUtil.convertDateTime2StringNoLocale(si.getExpDateTo(), "MM/dd/yyyy"));
				paramMap.put("EFFTVE_DT_TO", si.getEffDateTo());
				paramMap.put("EXP_DT_FROM", si.getExpDateFrom());
				paramMap.put("EXP_DT_TO", si.getExpDateTo());
				paramMap.put("NO_EXP_FLG", si.getNoExpireFlag());
				paramMap.put("LSSR_NAME", si.getLessorName());
				paramMap.put("CRR_FLG", si.getCurrentFlag());
				
				/*param = new SEMESI001ReportParameter();
				param.setDocNo(si.getDocNo());
				param.setCompany(si.getCompany());
				param.setRegion(si.getRegion());
				param.setReqType(si.getReqType());
				param.setTitle(si.getTitle());
				param.setAssignContractNo(si.getAssignContractNo());
				param.setLegalApproveStatus(si.getLegalApproveStatus());
				param.setLocationId(si.getLocationId());
				param.setLocationCode(si.getLocationCode());
				param.setSiteName(si.getLocationName());
				param.setSiteType(si.getSiteType());
				param.setSiteInfoStatus(si.getSiteInfoStatus());
				param.setSiteStatus(si.getSiteStatus());
				param.setContractNo(si.getContractNo());
				param.setPendingStatus(si.getPendingStatus());
				param.setExpireStatus(si.getExpireStatus());
				param.setEffectiveDtFrom(si.getEffDateFrom());
				param.setEffectiveDtTo(si.getEffDateTo());
				param.setExpireDtFrom(si.getExpDateFrom());
				param.setExpireDtTo(si.getEffDateTo());
				param.setNoExpireFlag(si.getNoExpireFlag());
				param.setLessorName(si.getLessorName());
				param.setCurrentFlag(si.getCurrentFlag());*/
				
				
				
				String reportViewer = null;
				String xxx = "";
				byte [] respBytesArray = null;
				
				IReportWebHelper reportWebHelper = (IReportWebHelper)JSFServiceFinderUtil.getInstance().getBean("reportWebHelper");
				reportViewer = reportWebHelper.exportExcelMSA003(paramMap);
				
				System.out.println("reportViewer: " + reportViewer);
				
				// -> jsf context renderer popup download
				//FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(ServiceConstants.DATA_INPUT_STREAM, respBytesArray);
				// <- jsf context renderer popup download
				
			} catch (Exception e) {
				log.error("RUN REPORT ERROR IN " + getClass() +  " : " + e);
				e.printStackTrace();
			} finally{
				param = null;
				
				/*
				try {
					if(stmt != null){
						stmt.close();
					}
					
					if(rs != null){
						rs.close();
					}
					
					if(conn != null){
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				*/
			}
		}
	}

	@Override
	public void showReport() {
		//edit by NEW 20160518
		try{
			String reportName = "SEMESI001";
			Date date = new Date();
			reportName = reportName+"_"+DateUtil.convertDateTime2String(date, "ddMMyyyy_HHmmss");
//			log.debug("reportName = "+reportName);
			//showReport("SEMESI001", getSemmsi004Bean().getReportType());
			showReport(reportName, getSemmsi004Bean().getReportType());
		}catch (Exception e) {
			e.printStackTrace();
			log.debug("ERROR FROM SEMMSI004Action showReport : "+e);
			// TODO: handle exception
		}
		
	}
	
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
	
	public void doGenDummy(){
		semmsi004Bean = getSemmsi004Bean();
		ISiteInfoService service = (ISiteInfoService)getBean("siteInfoService");
		List<Msi004GenDummy> to;
		Msi004GenDummy msi004GenDummy = new Msi004GenDummy();
		msi004GenDummy.setCompany(semmsi004Bean.getSiteInfoSP().getCompany());
		msi004GenDummy.setUser(getUserLogIn());
		try{
			to = service.querySPList(EQueryName.SP_MSI004_GEN_DUMMY.name, msi004GenDummy);
			if(to != null && to.size() > 0){
				if(StringUtils.equals("Success", to.get(0).getpResult())){
					addMessageInfo("M0006",to.get(0).getpRemark());
				}else{
					addMessageError("E0008",to.get(0).getpRemark());
				}
				
			}else{
				addMessageError("E0001");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	// added by.. YUT
	public boolean doInitialForSearchSiteInfo() {
		log.info("::: SEMMSI004Action :: doInitialForSearchSiteInfo >> BEGIN :::");
		boolean flag = true;

		try {

			semmsi004Bean = getSemmsi004Bean();

			String paramUrl = getFacesUtils().getRequestParameter("paramUrl") == null ? "" : (String) getFacesUtils().getRequestParameter("paramUrl");
	        String paramMenuGroup = getFacesUtils().getRequestParameter("paramMenuGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuGroup");
	        String paramMenuSubGroup = getFacesUtils().getRequestParameter("paramMenuSubGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuSubGroup");
	        String paramParameter = getFacesUtils().getRequestParameter("paramParameter") == null ? "" : (String) getFacesUtils().getRequestParameter("paramParameter");
	       
//	        System.out.println("paramUrl: " + paramUrl);
//	        System.out.println("paramMenuGroup: " + paramMenuGroup);
//	        System.out.println("paramMenuSubGroup: " + paramMenuSubGroup);
//	        System.out.println("paramParameter: " + paramParameter);
	        
	        semmsi004Bean.getSiteInfoSP().setStrParam(paramParameter);
	        semmsi004Bean.setRenderedOnToDoList(true); //

			setSemmsi004Bean(semmsi004Bean);
			
			this.doSearch();

		} catch(Exception e) {
			e.printStackTrace();
			addMessageError("EL0000", "SEMMSI004Action");
			flag = false;
			
		} finally {
			log.info("::: SEMMSI004Action :: doInitialForSearchSiteInfo >> END :::");
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
    	semmsi004Bean = getSemmsi004Bean();
    	semmsi004Bean.setTreeMacroFlag(false);
    	semmsi004Bean.setTreePicoFlag(false);
    	//// >>
    	TreeUtilBean myParam = new TreeUtilBean();
    	List<Object> mySendList = new ArrayList<Object>();
    	
    	IMenuTreeService service = (IMenuTreeService)getBean("menuTreeService");
    	
    	String groupType = "SI";
    	String reqTypeName = "";
        try {
        		if("Y".equals(searchFlag)){
            		List<MenuTreeSP> menuTreeList = null;
            		semmsi004Bean.getTreeUtilBean().setMenuGroup(groupType);
            		semmsi004Bean.getTreeUtilBean().setUserLogin(getUserLogIn());
            		if(!semmsi004Bean.getTreeUtilBean().getCompany().equals("") && !semmsi004Bean.getTreeUtilBean().getRegion().equals("")){
            			if(!semmsi004Bean.getTreeUtilBean().getMenuSubGroup().equals("")){
            				
                			menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name, semmsi004Bean.getTreeUtilBean());
                			
            				Map<String, Object> myMap = new HashMap<String, Object>();
            				
            				if(menuTreeList != null && !menuTreeList.isEmpty()){
            			
            					for(SelectItem item : semmsi004Bean.getTodoReqTypeList()){
            						if(StringUtils.equals(semmsi004Bean.getTreeUtilBean().getMenuSubGroup(), item.getValue().toString())){
            							reqTypeName = item.getLabel().toString();
            						}
            					}
            					/// >
            					for(int j=0; j<menuTreeList.size(); j++){
            						String mLevel = menuTreeList.get(j).getMenuLevel();
            						myMap.put(mLevel, menuTreeList.get(j));
            					}
            					mySendList.add(myMap);
            					/// <
            					
            				}
                		}else{
                			for(int i = 1;i<semmsi004Bean.getTodoReqTypeList().size();i++){
//            					if(i==0){
//            						semmsi004Bean.getTreeUtilBean().setMenuSubGroup("M");
//            					}
                				if(semmsi004Bean.getTodoReqTypeList().get(i) != null){
                					SelectItem item = semmsi004Bean.getTodoReqTypeList().get(i);
                					semmsi004Bean.getTreeUtilBean().setMenuSubGroup(item.getValue().toString());
                				}
                			
        	        			menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name, semmsi004Bean.getTreeUtilBean());
        	        			
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
//        	    				semmsi004Bean.getTreeUtilBean().setMenuSubGroup("P");
        	        		}
                			semmsi004Bean.getTreeUtilBean().setMenuSubGroup("");
                		}
            		}else{
            			validateToDoList();
            		}
            		
            		
            		
            	}else{
            					
            		if("Y".equals(backWard)){
                		List<MenuTreeSP> menuTreeList = null;
                		semmsi004Bean.getTreeUtilBean().setMenuGroup(groupType);
                		semmsi004Bean.getTreeUtilBean().setUserLogin(getUserLogIn());
                		if(!semmsi004Bean.getTreeUtilBean().getCompany().equals("") && !semmsi004Bean.getTreeUtilBean().getRegion().equals("")){
                			if(!semmsi004Bean.getTreeUtilBean().getMenuSubGroup().equals("")){
                    			menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name, semmsi004Bean.getTreeUtilBean());
                    			
                				Map<String, Object> myMap = new HashMap<String, Object>();
                				
                				if(menuTreeList != null && !menuTreeList.isEmpty()){
                			
                					for(SelectItem item : semmsi004Bean.getTodoReqTypeList()){
                						if(StringUtils.equals(semmsi004Bean.getTreeUtilBean().getMenuSubGroup(), item.getValue().toString())){
                							reqTypeName = item.getLabel().toString();
                						}
                					}
                					
                					/// >
                					for(int j=0; j<menuTreeList.size(); j++){
                						String mLevel = menuTreeList.get(j).getMenuLevel();
                						myMap.put(mLevel, menuTreeList.get(j));
                					}
                					mySendList.add(myMap);
                					/// <
                					
                				}
                    		}else{
                    			for(int i = 1;i<semmsi004Bean.getTodoReqTypeList().size();i++){
//                					if(i==0){
//                						semmsi004Bean.getTreeUtilBean().setMenuSubGroup("M");
//                					}
                    				if(semmsi004Bean.getTodoReqTypeList().get(i) != null){
                    					SelectItem item = semmsi004Bean.getTodoReqTypeList().get(i);
                    					semmsi004Bean.getTreeUtilBean().setMenuSubGroup(item.getValue().toString());
                    				}
                    			
            	        			menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name, semmsi004Bean.getTreeUtilBean());
            	        			
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
//            	    				semmsi004Bean.getTreeUtilBean().setMenuSubGroup("P");
            	        		}
                    			semmsi004Bean.getTreeUtilBean().setMenuSubGroup("");
                    		}
                		}else{
                			validateToDoList();
                		}
                		
            		}else{
            			semmsi004Bean.setTreeUtilBean(new TreeUtilBean());
                		setSemmsi004Bean(semmsi004Bean);	
            		}
            	
            	}
        		
        		
//            	rootNode = new TreeNodeImpl();
//        		addNodes(rootNode, mySendList);
        		semmsi004Bean.setHeaderTreeMacro(reqTypeName);
        		
        		semmsi004Bean.setRootNode(new TreeNodeImpl());
        		addNodes(semmsi004Bean, mySendList);
        	
        } catch (Exception e) {
            throw new FacesException(e.getMessage(), e);
        } finally {
        	searchFlag = null;
        	//semmsi004Bean = null;
        	//// >>
        	myParam = null;
        	mySendList = null;
        	
        	service = null;
        	
        	groupType = null;
        }
    }
    
    public void validateToDoList(){
    	try{
    		semmsi004Bean = getSemmsi004Bean();
    		if(semmsi004Bean.getTreeUtilBean().getCompany().equals("")){
    			addMessageErrorWithArgument("W0001",msg("message.company"));
    		}
    		if(semmsi004Bean.getTreeUtilBean().getRegion().equals("")){
    			addMessageErrorWithArgument("W0001",msg("message.region"));
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
			// TODO: handle exception
		}
    }

    @SuppressWarnings({ "unused", "unchecked" })
	private void addNodes(SEMMSI004Bean semmsi004Bean, List<Object> propList) {
//    	semmsi004Bean = getSemmsi004Bean();
    	String _MENU_LABEL = "";
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
			
			_MENU_LABEL = "";
//			
			String parent1 = mapArr_[i].toString();	// get key by sorting
			MenuTreeSP mapObj1 =  (MenuTreeSP) map.get(parent1);
			
			
//			if(mapObj1.getMenuSubGroup().equals("M")){
				
				_MENU_LABEL = "Site Info "+semmsi004Bean.getHeaderTreeMacro();
							
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
	    			String myUrl = mapObj.getMenuUrl() == null ? "SEMMSI004-0" : mapObj.getMenuUrl().toString();
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
				
				semmsi004Bean.setTreeMacroFlag(true);
				semmsi004Bean.setMenuTreeMacroList(menuTreeWrapList);
//			}
//			else if(mapObj1.getMenuSubGroup().equals("P")){
//				_MENU_LABEL = "Site Info Pico";
//							
//				if(mapObj1.getRegion() != null){
//					_MENU_LABEL = _MENU_LABEL+" "+mapObj1.getRegion();
//				}
//				
//				if(mapObj1.getCompany() != null){
//					_MENU_LABEL = _MENU_LABEL+" "+mapObj1.getCompany();
//				}
//				
//				for(int x=0; x<mapSize; x++){
//	    			TreeNodeImpl<MenuTreeSP> child = new TreeNodeImpl<MenuTreeSP>();
//	    			
//	    			String parentNode = mapArr_[x].toString();	// get key by sorting
//	    			
//	    			MenuTreeSP mapObj =  (MenuTreeSP) map.get(parentNode);
//
////	    			2015/01/30 fixed.. dynamic URL
//	    			String myUrl = mapObj.getMenuUrl() == null ? "SEMMSI004-0" : mapObj.getMenuUrl().toString();
//	    			String myAction = myUrl.substring(0, myUrl.length() - 2);
//	    			mapObj.setMenuUrl(myUrl);
//	    			mapObj.setMenuAction(myAction);
////	    			// fixed.. dynamic URL
//	    			
//					WrapperBeanObject<MenuTreeSP> tmpWrapperBean = new WrapperBeanObject<MenuTreeSP>();
//					tmpWrapperBean.setDataObj(mapObj);
//					tmpWrapperBean.setMessage("");
//					menuTreeWrapList.add(tmpWrapperBean);
//	        	}
//				semmsi004Bean.setHeaderTreePico(_MENU_LABEL);
//				semmsi004Bean.setTreePicoFlag(true);
//				semmsi004Bean.setMenuTreePicoList(menuTreeWrapList);
//			}
			
			
//			myParent.setMenuLabel(_MENU_LABEL);
//    		
//    		// >>
//    		TreeNodeImpl<MenuTreeSP> stationNodes = new TreeNodeImpl<MenuTreeSP>();
//    		
//    		MenuTreeSP menuTreeObj = new MenuTreeSP();
//    		
//    		stationNodes.setData(myParent);
//    		stationNodes.setParent(stationNodes);
//        	masterRoot.addChild(i, stationNodes);
        	// <<
    		
//    		for(int x=0; x<mapSize; x++){
//    			TreeNodeImpl<MenuTreeSP> child = new TreeNodeImpl<MenuTreeSP>();
//    			
//    			String parentNode = mapArr_[x].toString();	// get key by sorting
//    			
//    			MenuTreeSP mapObj =  (MenuTreeSP) map.get(parentNode);
//    			
//    			// 2015/01/30 fixed.. dynamic URL
//    			String myUrl = mapObj.getMenuUrl() == null ? "SEMMSI004-0" : mapObj.getMenuUrl().toString();
//    			String myAction = myUrl.substring(0, myUrl.length() - 2);
//    			mapObj.setMenuUrl(myUrl);
//    			mapObj.setMenuAction(myAction);
//    			// fixed.. dynamic URL
//
//    			child.setData(mapObj);
//    			
//    			stationNodes.addChild(x, child);
//    		}
    		// <<
    		
//    		masterRoot.addChild(i, stationNodes);
        	
    	}
    	semmsi004Bean.setHeaderTreeMacro(_MENU_LABEL);
    	setSemmsi004Bean(semmsi004Bean);
    }
    
    public void processSelection(NodeSelectedEvent event) {
        HtmlTree tree = (HtmlTree) event.getComponent();
        nodeTitle = ((MenuTreeSP)tree.getRowData()).toString();
        nodeValue = (MenuTreeSP) tree.getRowData();
        
        String paramUrl = getFacesUtils().getRequestParameter("paramUrl") == null ? "" : (String)getFacesUtils().getRequestParameter("paramUrl");
        String paramMenuGroup = (String)getFacesUtils().getRequestParameter("paramMenuGroup");

        selectedNodeChildren.clear();
        
        TreeNode currentNode = tree.getModelTreeNode(tree.getRowKey());
        if (currentNode.isLeaf()){
            selectedNodeChildren.add(((MenuTreeSP)currentNode.getData()).toString());
//            System.out.println("selected node Child [y]: " + ((MenuTreeSP)currentNode.getData()).toString());
        }else
        {
            Iterator<Map.Entry<Object, TreeNode>> it = currentNode.getChildren();
            while (it!=null &&it.hasNext()) {
                Map.Entry<Object, TreeNode> entry = it.next();
                selectedNodeChildren.add(entry.getValue().getData().toString());
//                System.out.println("selected nod Parent have Childred [x]: " + entry.getValue().getData().toString());
            }
        }   
    }
    
    // fixed 2015/01/27
    public boolean nodeExpandAll(UITree tree) {  
    	// can do something
    	return true;
    }
    
    public TreeNode getTreeNode() {
        if (rootNode == null) {
            loadTree();
        }
        
        return rootNode;
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
    
    //added by NEW 21/03/2015
    private SEMMSA002Bean semmsa002Bean;
	
	public SEMMSA002Bean getSemmsa002Bean() {
		return (SEMMSA002Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsa002Bean");
	}

	public void setSemmsa002Bean(SEMMSA002Bean semmsa002Bean) {
		this.semmsa002Bean = semmsa002Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsa002Bean", semmsa002Bean);
	}
	
	private PopupSiteContractBean popupSiteContractBean;
	
	public PopupSiteContractBean getPopupSiteContractBean() {
		return (PopupSiteContractBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupSiteContractBean");
	}

	public void setPopupSiteContractBean(PopupSiteContractBean popupSiteContractBean) {
		this.popupSiteContractBean = popupSiteContractBean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupSiteContractBean", this.popupSiteContractBean);
	}
	
	private PopupSiteLocationBean popupSiteLocationBean;
	
	public PopupSiteLocationBean getPopupSiteLocationBean() {
		return (PopupSiteLocationBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupSiteLocationBean");
	}

	public void setPopupSiteLocationBean(PopupSiteLocationBean popupSiteLocationBean) {
		this.popupSiteLocationBean = popupSiteLocationBean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupSiteLocationBean", this.popupSiteLocationBean);
	}
	
    public void doShowPopupHistory(){
    	semmsi004Bean = getSemmsi004Bean();
		semmsa002Bean = getSemmsa002Bean();
		String tabNo = getFacesUtils().getRequestParameter("tabNo").toString().equals("") ? "" : (String)getFacesUtils().getRequestParameter("tabNo");
		//String tabNo = semmsa002Bean.getSelectedTab();
		semmsa002Bean.setChkDataNotFound(false);
		List<SiteAppSP> siteAppList = null;
		List<SiteAppSiteSP> siteAppSiteList = null;
		//SiteAppSP
		try{
//			semmsi004Bean.setSiteAppObjParam(new SiteAppSP());
			semmsa002Bean.setSiteAppObjParam(new SiteAppSP()); 
//			semmsi004Bean.getSiteAppObjParam().setSiteAppId("0E6AF8936CA34003E050D00AAA980EDE");
			semmsa002Bean.getSiteAppObjParam().setSiteAppId(semmsi004Bean.getSiteAppObjParam().getSiteAppId()); 
			semmsa002Bean.setChkCopySiteInfo(true);
			semmsa002Bean.setDisabledBtnCopySiteInfo(true);
			ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService");
			log.debug("Start doPopupHistoryTab1()");
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
								tmpWrapperSubBean.setDisableCheckBox(false);
								tmpWrapperSubBean.setCheckBox(true);
								//semmsa002Bean.getSiteAppPopupHistoryList().add(tmpWrapperBean);
								siteApp.getSiteAppSiteList().add(tmpWrapperSubBean);
							}
						}
					}
					
					tmpWrapperBean.setDataObj(siteApp);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setDisableCheckBox(false);
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
			// TODO: handle exception
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			semmsa002Bean = null;
			tabNo = null;
			siteAppList = null;
			siteAppSiteList = null;
		}
	}
    
    public void onSelected() {
		//semmsi004Bean = getSemmsi004Bean();
		semmsa002Bean = getSemmsa002Bean();
		String rowId = getFacesUtils().getRequestParameter("rowId").toString().equals("") ? "" : (String)getFacesUtils().getRequestParameter("rowId");
		String checkBox = getFacesUtils().getRequestParameter("checkBox").toString().equals("") ? "" : (String)getFacesUtils().getRequestParameter("checkBox");
		SiteAppSP siteAppSP = new SiteAppSP(); 
		int i = 1;
		//semmsi004Bean.setTmpRowId(rowId);
		
//		if (isCheckSELBox()) {
//			semmsa003Bean.setDisabledBtnExport(false);
//		} else {
//			semmsa003Bean.setDisabledBtnExport(true);
//		}
		
		try{
			List<WrapperBeanObject<SiteAppSP>> siteAppList = semmsa002Bean.getSiteAppPopupHistoryList();
			List<WrapperBeanObject<SiteAppSP>> newSiteAppList = new ArrayList<WrapperBeanObject<SiteAppSP>>();;
			for (WrapperBeanObject<SiteAppSP> wrapperBeanObject : siteAppList) {
				siteAppSP = (SiteAppSP) wrapperBeanObject.getDataObj();
//				if (wrapperBeanObject.isCheckBox()) {

					//check 
					if(siteAppSP.getRowId() != null){
						if(!siteAppSP.getRowId().equals(rowId)){
							wrapperBeanObject.setCheckBox(false);
							siteAppSP.setSelectFlag(false);
						}else{
							if(siteAppSP.isSelectFlag()){
								wrapperBeanObject.setCheckBox(false);
								siteAppSP.setSelectFlag(false);
								semmsa002Bean.setDisabledBtnCopySiteInfo(true);
							}else{
								wrapperBeanObject.setCheckBox(true);
								siteAppSP.setSelectFlag(true);
								semmsa002Bean.setDisabledBtnCopySiteInfo(false);
							}
						}
					}
					
					newSiteAppList.add(wrapperBeanObject);
//				}
				i++;
			}
			semmsa002Bean.setSiteAppPopupHistoryList(newSiteAppList);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			setSemmsa002Bean(semmsa002Bean);
			semmsa002Bean = null;
			rowId = null;
			siteAppSP = null; 
			i = 0;
		}
	}
    
    public boolean doCopySiteInfo(){
    	boolean flag = false;
    	
		semmsa002Bean = getSemmsa002Bean();
		semmsi004Bean = getSemmsi004Bean();
		semmsi004tab1Bean = getSemmsi004tab1Action().getSemmsi004tab1Bean();
		semmsi004tab2Bean = getSemmsi004tab2Action().getSemmsi004tab2Bean();
		//String rowId = getFacesUtils().getRequestParameter("rowId").toString().equals("") ? "" : (String)getFacesUtils().getRequestParameter("rowId");
		SiteAppSP siteAppSP = new SiteAppSP(); 
		SiteAppSiteSP siteAppSiteSP = new SiteAppSiteSP(); 
		SiteInfoMapLocSP siteInfoMapLocSP;
		List<SiteInfoMapLocSP> siteInfoMapLocList = new ArrayList<SiteInfoMapLocSP>();
		List<WrapperBeanObject<Mac003Srch>> detailList = new ArrayList<WrapperBeanObject<Mac003Srch>>();
		popupSiteContractBean = getPopupSiteContractBean();
		
    	try{
    		List<WrapperBeanObject<SiteAppSP>> siteAppList = semmsa002Bean.getSiteAppPopupHistoryList();
			for (WrapperBeanObject<SiteAppSP> wrapperBeanObject : siteAppList) {
				siteAppSP = (SiteAppSP) wrapperBeanObject.getDataObj();
				if (siteAppSP.isSelectFlag()) {
					//copy site info
					log.debug("test : "+siteAppSP.getRowId());
					flag = true;
					//semmsi004tab2Bean.siteContract.contractNo
					if(siteAppSP.getCompany() != null)semmsi004tab1Bean.getSiteInfo().setCompany(siteAppSP.getCompany());

					if(siteAppSP.getRegion() != null)semmsi004tab1Bean.getSiteInfo().setRegion(siteAppSP.getRegion());
										
					if(siteAppSP.getLocationName() != null)semmsi004tab1Bean.getSiteInfo().setSiteName(siteAppSP.getLocationName());
										
					semmsi004tab1Bean.setChkEditSite(false);
										
//					popupSiteContractBean.setOldContractNo();
										
//					semmsi004tab1Bean.getSiteInfo().setSiteType(siteAppSP.getStationType());
										
//					if(siteAppSP.getTerminateContractDt() != null)semmsi004tab1Bean.getSiteInfo().setGroupRent("");
										
//					semmsi004tab2Bean.setContractNo1();
										
//					semmsi004tab2Bean.setContractNo2();
										
//					semmsi004tab2Bean.setContractNo3()
										
//					semmsi004tab1Bean.setDummyContractNo()
										
//					semmsi004tab2Bean.setContractNoFormat()
					
										
					semmsi004tab2Bean.setChkDummyFlag(false);
										
//					semmsi004tab2Bean.setChkOwnerContractFlag()
										
//					semmsi004tab2Bean.siteContract.setFirstEffectiveDt(siteAppSP.get);
										
//					semmsi004tab2Bean.chkNoExpireFlag();
										
//					semmsi004tab2Bean.getSiteContract().setEffectiveDt(siteAppSP.getEffectiveDt());
//					semmsi004tab2Bean.getSiteContract().setExpireDt(siteAppSP.getExpireDt());
//					getSemmsi004tab2Action().setSemmsi004tab2Bean(semmsi004tab2Bean);

					//this.getSemmsi004tab2Action().calAge();
										
//					semmsi004tab2Bean.getSiteContract().setAgeYear(siteAppSP.getAgeYear());
//					semmsi004tab2Bean.getSiteContract().setAgeMonth(siteAppSP.getAgeMonth());
//					semmsi004tab2Bean.getSiteContract().setAgeDay(siteAppSP.getAgeDay());
										
										
////				semmsi004tab1Bean.getSi004SrchSiteStatusSP().getSiteStatus();
					if(siteAppSP.getTerminateContractDt() != null)semmsi004tab1Bean.getSiteInfo().setTerminateDt(siteAppSP.getTerminateContractDt());
//					semmsi004tab1Bean.setChkPendingStatus(false);
//					semmsi004tab1Bean.getSiteInfo().getPendingDt();
					if(siteAppSP.getRecordStatus() != null)semmsi004tab1Bean.getSiteInfo().setSiteInfoStatus(siteAppSP.getRecordStatus());
//					semmsi004tab2Bean.getSiteContract().getRemark();
										
					//set Location
					List<WrapperBeanObject<SiteAppSiteSP>> siteAppSiteList = siteAppSP.getSiteAppSiteList();
//						if(siteAppSiteList != null){
//							for (WrapperBeanObject<SiteAppSiteSP> subWrapperBeanObject : siteAppSiteList) {
//								siteAppSiteSP = (SiteAppSiteSP) subWrapperBeanObject.getDataObj();
//												
//								siteInfoMapLocSP = new SiteInfoMapLocSP(); 
//								siteInfoMapLocSP.setLocationId(siteAppSiteSP.getLocationId());
////												
//								siteInfoMapLocSP.setRowId(siteAppSiteSP.getRowId());
////								siteInfoMapLocSP.setRegion(siteAppSiteSP.getRegion());
//								siteInfoMapLocSP.setStationType(siteAppSiteSP.getStationType());
//								siteInfoMapLocSP.setLocationId(siteAppSiteSP.getLocationId());
//								siteInfoMapLocSP.setLocationCode(siteAppSiteSP.getLocationCode());
//								siteInfoMapLocSP.setLocationName(siteAppSiteSP.getLocationName());
////								siteInfoMapLocSP.setRentAmt(siteAppSiteSP.getLocationId());
////								siteInfoMapLocSP.setMainLocFlag(siteAppSiteSP.getLocationId());
//												
//								siteInfoMapLocList.add(siteInfoMapLocSP);
//							}
//							semmsi004tab1Bean.setSiteInfoMapLocSPList(siteInfoMapLocList);
							//siteAppSP.getSiteAppSiteList()
//						}
					//semmsi004tab1Bean.setSiteInfoMapLocSPList(siteAppSP.getSiteAppSiteList());
										
					if(siteAppSP.getLocationType() != null)semmsi004tab1Bean.getSiteInfo().setPlaceType(siteAppSP.getLocationType());
					if(siteAppSP.getLocationAddressNo() != null)semmsi004tab1Bean.getSiteInfo().setSiteHouseNo(siteAppSP.getLocationAddressNo());
					if(siteAppSP.getLessorBuilding() != null)semmsi004tab1Bean.getSiteInfo().setSiteBuilding(siteAppSP.getLessorBuilding());
					if(siteAppSP.getLocationStreet() != null)semmsi004tab1Bean.getSiteInfo().setSiteStreet(siteAppSP.getLocationStreet());
					if(siteAppSP.getLocationFloor() != null)semmsi004tab1Bean.getSiteInfo().setSiteFloor(siteAppSP.getLocationFloor());
					if(siteAppSP.getLocationTambon() != null)semmsi004tab1Bean.getSiteInfo().setSiteTambon(siteAppSP.getLocationTambon());
//					semmsi004tab1Bean.getSiteInfo().setDeckAreaType("");
					if(siteAppSP.getDeckArea() != null)
						semmsi004tab1Bean.getSiteInfo().setDeckArea(Double.valueOf(siteAppSP.getDeckArea().doubleValue()));
										
					if(siteAppSP.getLocationAmphurId() != null)semmsi004tab1Bean.getSiteInfo().setSiteAmphurId(siteAppSP.getLocationAmphurId());
											
										
					//semmsi004tab1Bean.getSiteInfo().getBuildingAreaType();
					if(siteAppSP.getBuildingArea() != null)
						semmsi004tab1Bean.getSiteInfo().setBuildingArea(Double.valueOf(siteAppSP.getBuildingArea().doubleValue()));
										
					if(siteAppSP.getLocationProvinceId() != null)semmsi004tab1Bean.getSiteInfo().setSiteProvinceId(siteAppSP.getLocationProvinceId());
					if(siteAppSP.getLocationRoomNo() != null)semmsi004tab1Bean.getSiteInfo().setSiteRoomNo(siteAppSP.getLocationRoomNo());
					if(siteAppSP.getLocationPostCode() != null)semmsi004tab1Bean.getSiteInfo().setSitePostcode(siteAppSP.getLocationPostCode());
										
					//semmsi004tab1Bean.getSiteInfo().getRoomAreaType(siteAppSP);
					if(siteAppSP.getRoomArea() != null)
						semmsi004tab1Bean.getSiteInfo().setRoomArea(Double.valueOf(siteAppSP.getRoomArea().doubleValue()));
										
					//semmsi004tab1Bean.getSiteInfo().getLandAreaType(siteAppSP);
					if(siteAppSP.getLandArea() != null)
						semmsi004tab1Bean.getSiteInfo().setLandArea(Double.valueOf(siteAppSP.getLandArea().doubleValue()));
										
					//semmsi004tab1Bean.getSiteInfo().getLandAreaUnitType(siteAppSP);
//										
					if(siteAppSP.getLessorHouseNo() != null)semmsi004tab1Bean.getSiteInfo().setRightHouseNo(siteAppSP.getLessorHouseNo());
					if(siteAppSP.getLessorBuilding() != null)semmsi004tab1Bean.getSiteInfo().setRightBuilding(siteAppSP.getLessorBuilding());
					if(siteAppSP.getLessorStreet() != null)semmsi004tab1Bean.getSiteInfo().setRightStreet(siteAppSP.getLessorStreet());
					if(siteAppSP.getLessorFloor() != null)semmsi004tab1Bean.getSiteInfo().setRightFloor(siteAppSP.getLessorFloor());
					if(siteAppSP.getLessorTambon() != null)semmsi004tab1Bean.getSiteInfo().setRightTambon(siteAppSP.getLessorTambon());
					if(siteAppSP.getLessorRoomNo() != null)semmsi004tab1Bean.getSiteInfo().setRightRoomNo(siteAppSP.getLessorRoomNo());
					if(siteAppSP.getLessorAmphurId() != null)semmsi004tab1Bean.getSiteInfo().setRightAmphur(siteAppSP.getLessorAmphurId());
					if(siteAppSP.getLessorProvinceId() != null)semmsi004tab1Bean.getSiteInfo().setRightProvince(siteAppSP.getLessorProvinceId());
					if(siteAppSP.getLessorPostCode() != null)semmsi004tab1Bean.getSiteInfo().setRightPostcode(siteAppSP.getLessorPostCode());
//					
//					semmsi004Bean.getSiteRent().getTotalRentAddAmt();
//					semmsi004Bean.getSiteRent().getTotalRentAddPeriodType();
//					semmsi004Bean.getSiteRent().getTotalServiceAddAmt();
//					semmsi004Bean.getSiteRent().getTotalServiceAddPeriodType();
//					semmsi004Bean.getSiteRent().getTotalRentAmt();
//					semmsi004Bean.getSiteRent().getTotalRentPeriodType();
//					semmsi004Bean.getSiteRent().getTotalServiceAmt();
//					semmsi004Bean.getSiteRent().getTotalServicePeriodType();
//					semmsi004Bean.getSiteRent().getTotalRentServiceAmt();
//					semmsi004Bean.getSiteRent().getTotalRentServicePeriodType();
//					semmsi004Bean.getSiteRent().getTotalAgeRentAmt();
//					semmsi004Bean.getSiteRent().getTotalAgeServiceAmt();
//					semmsi004Bean.getSiteRent().getTotalAgeRentServiceAmt();
//					semmsi004Bean.getSiteRent().getTotalDepositBgAmt();
//					semmsi004Bean.getSiteRent().getTotalDepositCashAmt();
//					semmsi004Bean.setChkNoDeposit(false);
//					
//					semmsi004tab1Bean.getSitePropertyTax().getPropertyTaxPayType();
//					
//					semmsi004tab1Bean.setChkElectricType1(false);
//					semmsi004tab1Bean.setChkMultiElectricTypeFlag(false);
//					semmsi004tab1Bean.setChkElectricType2(false);
//					semmsi004tab1Bean.setChkNoExpenses(false);
//					semmsi004tab1Bean.setChkElectricType3(false);
//					semmsi004tab1Bean.setChkElectricType4(false);
//					//popupSiteContractBean.getSiteContractNo();
//					semmsi004tab1Bean.getSiteElectric().getRemark();
//					semmsi004tab1Bean.getSiteElectric().getElectricOwnerType();
//					semmsi004tab1Bean.getSiteElectric().getUnitPriceAmt();
//					semmsi004tab1Bean.getSiteElectric().getTakeAllAmt();
//					semmsi004tab1Bean.getSiteElectric().getTakeAllPeriodType();
//					semmsi004tab1Bean.getSiteElectric().getVatType();
//					semmsi004tab1Bean.getPayPeriodType01();
//					semmsi004tab1Bean.getPayPeriodType02();
//					semmsi004tab1Bean.getPayPeriodType03();
//					semmsi004tab1Bean.getPayPeriodType04();
//					semmsi004tab1Bean.getPayPeriod04();
//					semmsi004tab1Bean.getPayPeriodType05();
				}
			}
    	}catch (Exception e){
    		log.debug("Error Semmsi004Action doCopyInfo");
    		e.printStackTrace();
    		flag = false;
    	}finally{
    		getSemmsi004tab1Action().setSemmsi004tab1Bean(semmsi004tab1Bean);
//    		setPopupSiteContractBean(popupSiteContractBean);
//    		setPopupSiteLocationBean(popupSiteLocationBean);
    		getSemmsi004tab2Action().setSemmsi004tab2Bean(semmsi004tab2Bean);
    	}
    	return flag;
    }
    
    public boolean doCopyContract(){
    	boolean flag = false;
    	
		semmsa002Bean = getSemmsa002Bean();
		semmsi004Bean = getSemmsi004Bean();
//		semmsi004tab1Bean = getSemmsi004tab1Bean();
		semmsi004tab2Bean = getSemmsi004tab2Action().getSemmsi004tab2Bean();
		//String rowId = getFacesUtils().getRequestParameter("rowId").toString().equals("") ? "" : (String)getFacesUtils().getRequestParameter("rowId");
		SiteAppSP siteAppSP = new SiteAppSP(); 
		SiteAppSiteSP siteAppSiteSP = new SiteAppSiteSP(); 
		SiteInfoMapLocSP siteInfoMapLocSP;
		List<SiteInfoMapLocSP> siteInfoMapLocList = new ArrayList<SiteInfoMapLocSP>();
		List<WrapperBeanObject<Mac003Srch>> detailList = new ArrayList<WrapperBeanObject<Mac003Srch>>();
//		popupSiteContractBean = getPopupSiteContractBean();
		
    	try{
    		List<WrapperBeanObject<SiteAppSP>> siteAppList = semmsa002Bean.getSiteAppPopupHistoryList();
			for (WrapperBeanObject<SiteAppSP> wrapperBeanObject : siteAppList) {
				siteAppSP = (SiteAppSP) wrapperBeanObject.getDataObj();
				if (siteAppSP.isSelectFlag()) {
					//copy Contract
					log.debug("test : "+siteAppSP.getRowId());
					
//					semmsi004tab2Bean.getContract().setContractNo(siteAppSP.getContractNo());
//					semmsi004tab2Bean.getContract().getPromiseRenewTime();
//					semmsi004tab2Bean.getContract().getPromiseRenewPeriod();
//					semmsi004tab2Bean.getContract().getPromiseRenewPeriodType();
//					semmsi004tab2Bean.getContract().getOwnerGroup();
//					semmsi004tab2Bean.getContract().getOwnerName();
					if(siteAppSP.getLessorName() != null)semmsi004tab2Bean.getContract().setLessorName(siteAppSP.getLessorName());
					if(siteAppSP.getLessorHouseNo() != null)semmsi004tab2Bean.getContract().setLessorHouseNo(siteAppSP.getLessorHouseNo());
					if(siteAppSP.getLessorStreet() != null)semmsi004tab2Bean.getContract().setLessorStreet(siteAppSP.getLessorStreet());
					if(siteAppSP.getLessorTambon() != null)semmsi004tab2Bean.getContract().setLessorTambon(siteAppSP.getLessorTambon());
//					if(siteAppSP.getAmphurName() != null)semmsi004tab2Bean.getContract().setLessorAmphurId(siteAppSP.getAmphurName());
//					if(siteAppSP.getLessorProvinceId() != null)semmsi004tab2Bean.getContract().setLessorProvinceId(siteAppSP.getLessorProvinceId());
					if(siteAppSP.getLessorPostCode() != null)semmsi004tab2Bean.getContract().setLessorPostcode(siteAppSP.getLessorPostCode());
//					semmsi004tab2Bean.getContract().setLessorTel(siteAppSP.getContactTel());
//					semmsi004tab2Bean.getContract().setLessorFax(siteAppSP.get);
					
//					if(siteAppSP.getLessorPostCode() != null)semmsi004tab2Bean.setLessorSPList(new ArrayList<Msi004SrchLessorSP>());
					
					if(siteAppSP.getContactName() != null)semmsi004tab2Bean.getContract().setContactName(siteAppSP.getContactName());
//					semmsi004tab2Bean.getContract().getContactHouseNo();
//					semmsi004tab2Bean.getContract().getContactStreet();
//					semmsi004tab2Bean.getContract().getContactTambon();
//					semmsi004tab2Bean.getContract().getContactAmphurId();
//					semmsi004tab2Bean.getContract().getContactProvinceId();
//					semmsi004tab2Bean.getContract().getContactPostcode();
					if(siteAppSP.getContactTel() != null)semmsi004tab2Bean.getContract().setContactTel(siteAppSP.getContactTel());
					
				}
			}
			flag = true;
    	}catch (Exception e){
    		flag = false;
    		log.debug("Error Semmsi004Action doCopyInfo");
    		e.printStackTrace();
    	}finally{
//    		setSemmsi004tab1Bean(semmsi004tab1Bean);
    		getSemmsi004tab2Action().setSemmsi004tab2Bean(semmsi004tab2Bean);
//    		setPopupSiteContractBean(popupSiteContractBean);
//    		setPopupSiteLocationBean(popupSiteLocationBean);
    	}
    	return flag;
    }
    
    public boolean doCopyRentalService(){
    	boolean flag = false;
    	
		semmsa002Bean = getSemmsa002Bean();
		semmsi004Bean = getSemmsi004Bean();
//		semmsi004tab1Bean = getSemmsi004tab1Bean();
//		semmsi004tab2Bean = getSemmsi004tab2Action().getSemmsi004tab2Bean();
		semmsi004tab3Bean = getSemmsi004tab3Action().getSemmsi004tab3Bean();
		//String rowId = getFacesUtils().getRequestParameter("rowId").toString().equals("") ? "" : (String)getFacesUtils().getRequestParameter("rowId");
		SiteAppSP siteAppSP = new SiteAppSP(); 
		SiteAppSiteSP siteAppSiteSP = new SiteAppSiteSP(); 
		SiteInfoMapLocSP siteInfoMapLocSP;
		List<SiteInfoMapLocSP> siteInfoMapLocList = new ArrayList<SiteInfoMapLocSP>();
		List<WrapperBeanObject<Mac003Srch>> detailList = new ArrayList<WrapperBeanObject<Mac003Srch>>();
//		popupSiteContractBean = getPopupSiteContractBean();
		
    	try{
    		List<WrapperBeanObject<SiteAppSP>> siteAppList = semmsa002Bean.getSiteAppPopupHistoryList();
			for (WrapperBeanObject<SiteAppSP> wrapperBeanObject : siteAppList) {
				siteAppSP = (SiteAppSP) wrapperBeanObject.getDataObj();
				if (siteAppSP.isSelectFlag()) {
					//copy Contract
					log.debug("test : "+siteAppSP.getRowId());
					
					//Edit rentai And service
//					semmsi004tab3Bean.setRentCondSPList(new ArrayList<Msi004SrchRentCondSP>());
//					semmsi004tab2Bean.getSiteContract().getContractNo();
//					semmsi004tab2Bean.getSiteContract().getEffectiveDt();
//					semmsi004tab2Bean.getSiteContract().getExpireDt();
//					
//					semmsi004tab3Bean.getRentCondNormal().getExpenseType();
//					semmsi004tab3Bean.getRentCondNormal().getPlaceName();
////					semmsi004tab3Bean.getRentCondNormal().setDetail(siteAppSP.getRentDetail());
//					semmsi004tab2Bean.getContract().getOwnerGroup();
//					semmsi004tab3Bean.getRentCondNormal().getRentOldAmt();
//					semmsi004tab3Bean.getRentCondNormal().getRentOldPeriodType();
//					semmsi004tab3Bean.getRentCondNormal().getRentAddPercent();
//					semmsi004tab3Bean.getRentCondNormal().getRentAddAmt();
//					semmsi004tab3Bean.getRentCondNormal().getRentAddPeriodType();
////					semmsi004tab3Bean.getRentCondNormal().setRentAmt(new Double(siteAppSP.getRentAmt()));
//					semmsi004tab3Bean.getRentCondNormal().getRentPeriodType();
//					semmsi004tab3Bean.getRentCondNormal().getWhtType();
//					semmsi004tab3Bean.getRentCondNormal().getWhtRate();
//					semmsi004tab3Bean.isChkWhtRateNormal();
//					semmsi004tab3Bean.getRentCondNormal().getVatType();
					
					
					Msi004SrchRentCondSP rentCondSP = new Msi004SrchRentCondSP();
					List<Msi004SrchRentCondSP> rentCondSPList = new ArrayList<Msi004SrchRentCondSP>();
					
					//delete old rent
//					semmsi004tab3Action.
					
					//set Rent Type
//					if(siteAppSP.getRentAmt() != null){
//						rentCondSP = new Msi004SrchRentCondSP();
//						rentCondSP.setRentAmt(new Double(siteAppSP.getRentAmt().doubleValue()));
//						rentCondSP.setDetail(siteAppSP.getRentDetail());
//						log.debug(siteAppSP.getReqType());
//						log.debug(siteAppSP.getReqDocType());
//						
//						rentCondSP.setExpenseType("04");
//						rentCondSP.setExpenseTypeName(msg("message.rent"));
////						rentCondSP.setPlaceName();
////						rentCondSP.setDetail();
//						if(siteAppSP.getRentAmtOld() != null)rentCondSP.setRentOldAmt(Double.parseDouble(siteAppSP.getRentAmtOld().toString()));
//						if(siteAppSP.getRentAmtAddPerc() != null)rentCondSP.setRentAddPercent(Double.parseDouble(siteAppSP.getRentAmtAddPerc().toString()));
//						if(siteAppSP.getRentAmtAdd() != null)rentCondSP.setRentAddAmt(Double.parseDouble(siteAppSP.getRentAmtAdd().toString()));
////						rentCondSP.setRentAmt();
//						rentCondSP.setRentPeriodTypeName(siteAppSP.getRentPeriodType());
//						rentCondSP.setWhtTypeName(siteAppSP.getRentWhtType());
//						if(siteAppSP.getRentWhtRate() != null)rentCondSP.setWhtRate(Double.parseDouble(siteAppSP.getRentWhtRate().toString()));
//						rentCondSP.setVatTypeName(siteAppSP.getRentVatType());
//						rentCondSP.setPayPeriodType(siteAppSP.getRentPaymentPeriod());
//						if(siteAppSP.getRentPaymentPeriodOth() != null)rentCondSP.setPayPeriod(siteAppSP.getRentPaymentPeriodOth().toString());
//						rentCondSP.setEffDate(siteAppSP.getEffectiveDt());
//						rentCondSP.setDeleteableFlag("Y");
////						rentCondSP.set
//						
//						rentCondSPList.add(rentCondSP);
//					}
//					//set Setvice Type
//					if(siteAppSP.getRentServiceAmt() != null){
//						rentCondSP = new Msi004SrchRentCondSP();
//						rentCondSP.setRentAmt(new Double(siteAppSP.getRentServiceAmt().doubleValue()));
//						rentCondSP.setDetail(siteAppSP.getRentServiceDetail());
//						siteAppSP.getRentServiceVatType();
//						siteAppSP.getRentServiceWht();
//						
//						
//						rentCondSP.setExpenseType("05");
//						rentCondSP.setExpenseTypeName(msg("message.service"));
////						rentCondSP.setPlaceName();
////						rentCondSP.setDetail();
//						if(siteAppSP.getRentServAmtOld() != null)rentCondSP.setRentOldAmt(Double.parseDouble(siteAppSP.getRentServAmtOld().toString()));
//						if(siteAppSP.getRentServAmtAddPerc() != null)rentCondSP.setRentAddPercent(Double.parseDouble(siteAppSP.getRentServAmtAddPerc().toString()));
//						if(siteAppSP.getRentServAmtAdd() != null)rentCondSP.setRentAddAmt(Double.parseDouble(siteAppSP.getRentServAmtAdd().toString()));
////						rentCondSP.setRentAmt();
//						rentCondSP.setRentPeriodTypeName(siteAppSP.getRentServicePeriodType());
//						rentCondSP.setWhtTypeName(siteAppSP.getRentServiceWht());
//						if(siteAppSP.getRentServiceWhtRate() != null)rentCondSP.setWhtRate(Double.parseDouble(siteAppSP.getRentServiceWhtRate().toString()));
//						rentCondSP.setVatTypeName(siteAppSP.getRentServiceVatType());
//						rentCondSP.setPayPeriodType(siteAppSP.getServPaymentPeriod());
//						if(siteAppSP.getServPaymentPeriodOth() != null)rentCondSP.setPayPeriod(siteAppSP.getServPaymentPeriodOth().toString());
//						rentCondSP.setEffDate(siteAppSP.getEffectiveDt());
//						rentCondSP.setDeleteableFlag("Y");
//						
//						
//						rentCondSPList.add(rentCondSP);
//					}
//					semmsi004tab3Bean.setRentCondSPList(rentCondSPList);
					
//					
//					semmsi004tab3Bean.getPayPeriodType01();
//					semmsi004tab3Bean.getPayPeriodType02();
//					semmsi004tab3Bean.getPayPeriodType03();
//					semmsi004tab3Bean.getPayPeriod03();
//					semmsi004tab3Bean.getPayPeriodType04();
//					semmsi004tab3Bean.getPayPeriod04();
//					semmsi004tab3Bean.getPayPeriodType05();
//					semmsi004tab3Bean.getRentCondNormal().getEffectiveDt();
//					semmsi004tab3Bean.getRentCondNormal().getEffectiveDt();
					if(siteAppSP.getRentAreaAmtMemo() != null)semmsi004tab3Bean.getRentCondSpecial1().setDetail(siteAppSP.getRentAreaAmtMemo());
//					semmsi004tab3Bean.getRentCondSpecial1().getWhtType();
//					semmsi004tab3Bean.getRentCondSpecial1().getWhtRate();
//					semmsi004tab3Bean.getRentCondSpecial1().getVatType();
//					semmsi004tab3Bean.isChkWhtRateRentSpecial();
					if(siteAppSP.getRentServiceAmtMemo() != null)semmsi004tab3Bean.getRentCondSpecial2().setDetail(siteAppSP.getRentServiceAmtMemo());
//					semmsi004tab3Bean.getRentCondSpecial2().getWhtType();
//					semmsi004tab3Bean.getRentCondSpecial2().getWhtRate();
//					semmsi004tab3Bean.isChkWhtRateServiceSpecial();
//					semmsi004tab3Bean.getRentCondSpecial2().getVatType();
					if(siteAppSP.getRentSetupAmtMemo() != null)semmsi004tab3Bean.getRentCondSpecial3().setDetail(siteAppSP.getRentSetupAmtMemo());
//					semmsi004tab3Bean.getRentCondSpecial3().getWhtType();
//					semmsi004tab3Bean.getRentCondSpecial3().getWhtRate();
//					semmsi004tab3Bean.isChkWhtRateRentSetupSpecial();
//					semmsi004tab3Bean.getRentCondSpecial3().getVatType();
					if(siteAppSP.getRentOtherAmtMemo() != null)semmsi004tab3Bean.getRentCondSpecial4().setDetail(siteAppSP.getRentOtherAmtMemo());
//					semmsi004tab3Bean.getRentCondSpecial4().getWhtType();
//					semmsi004tab3Bean.getRentCondSpecial4().getWhtRate();
//					semmsi004tab3Bean.isChkWhtRateServiceOtherSpecial();
//					semmsi004tab3Bean.getRentCondSpecial4().getVatType();
//					
					
					//total
					semmsi004tab3Bean.getTotalRent().getTotalRentAddAmt();
//					semmsi004tab3Bean.getTotalRent().getTotalServiceAddAmt();
//					semmsi004tab3Bean.getTotalRent().getTotalRentAddPeriodType();
//					semmsi004tab3Bean.getTotalRent().getTotalServiceAddPeriodType();
					if(siteAppSP.getTotalRentService() != null)
						semmsi004tab3Bean.getTotalRent().setTotalRentAmt(new Double(siteAppSP.getTotalRentService().doubleValue()));
//					semmsi004tab3Bean.getTotalRent().getTotalRentPeriodType();
//					semmsi004tab3Bean.getTotalRent().getTotalServiceAmt();
//					semmsi004tab3Bean.getTotalRent().getTotalServicePeriodType();
//					semmsi004tab3Bean.getTotalRent().getTotalRentServiceAmt();
//					semmsi004tab3Bean.getTotalRent().getTotalRentServicePeriodType();
//					semmsi004tab3Bean.getTotalRent().getTotalAgeRentAmt();
//					semmsi004tab3Bean.getTotalRent().getTotalAgeServiceAmt();
//					semmsi004tab3Bean.getTotalRent().getTotalAgeRentServiceAmt();
//					semmsi004tab3Bean.isChkNoRent();
//					semmsi004tab3Bean.getSiteDepositNormal().getDepositType();
//					semmsi004tab3Bean.getSiteDepositNormal().getExpenseType();
//					semmsi004tab3Bean.getSiteDepositNormal().getDepositAmt();
//					semmsi004tab3Bean.getSiteDepositNormal().getVatType();
//					semmsi004tab3Bean.getSiteDepositNormal().getRemark();
//					semmsi004tab3Bean.getSiteDepositNormal().isChkNewStatus();
//					semmsi004tab3Bean.getDepositRentBgSPList();
//					semmsi004tab3Bean.getDepositRentCashSPList();
//					semmsi004tab3Bean.getSiteDepositSpecialBg().getDetail();
//					semmsi004tab3Bean.getSiteDepositSpecialCash().getDetail();
//					semmsi004tab3Bean.getSiteDepositSpecialCash().getVatType();
//					semmsi004tab3Bean.getTotalDeposit().getTotalDepositBgAmt();
//					semmsi004tab3Bean.getTotalDeposit().getTotalDepositCashAmt();
//					semmsi004tab3Bean.isChkNoRentDeposit();
					this.getSemmsi004tab3Action().checkEditableRent();
					
					//list deposit
//					semmsi004tab3Bean.depositRentBgSPList
//					semmsi004tab3Bean.depositRentCashSPList
				}
			}
			flag = true;
    	}catch (Exception e){
    		flag = false;
    		log.debug("Error Semmsi004Action doCopyRentalService");
    		e.printStackTrace();
    	}finally{
//    		setSemmsi004tab1Bean(semmsi004tab1Bean);
    		this.getSemmsi004tab3Action().setSemmsi004tab3Bean(semmsi004tab3Bean);
//    		setPopupSiteContractBean(popupSiteContractBean);
//    		setPopupSiteLocationBean(popupSiteLocationBean);
    	}
    	return flag;
    }
    
    public boolean doCopyPropertyTax(){
    	boolean flag = false;
    	
		semmsa002Bean = getSemmsa002Bean();
		semmsi004Bean = getSemmsi004Bean();
//		semmsi004tab2Bean = getSemmsi004tab2Action().getSemmsi004tab2Bean();
		semmsi004tab4Bean = getSemmsi004tab4Action().getSemmsi004tab4Bean();
		//String rowId = getFacesUtils().getRequestParameter("rowId").toString().equals("") ? "" : (String)getFacesUtils().getRequestParameter("rowId");
		SiteAppSP siteAppSP = new SiteAppSP(); 
		SiteAppSiteSP siteAppSiteSP = new SiteAppSiteSP(); 
		SiteInfoMapLocSP siteInfoMapLocSP;
		List<SiteInfoMapLocSP> siteInfoMapLocList = new ArrayList<SiteInfoMapLocSP>();
		List<WrapperBeanObject<Mac003Srch>> detailList = new ArrayList<WrapperBeanObject<Mac003Srch>>();
//		popupSiteContractBean = getPopupSiteContractBean();
		
    	try{
    		List<WrapperBeanObject<SiteAppSP>> siteAppList = semmsa002Bean.getSiteAppPopupHistoryList();
			for (WrapperBeanObject<SiteAppSP> wrapperBeanObject : siteAppList) {
				siteAppSP = (SiteAppSP) wrapperBeanObject.getDataObj();
				if (siteAppSP.isSelectFlag()) {
					//copy Contract
					log.debug("test : "+siteAppSP.getRowId());
//					
//					semmsi004tab2Bean.siteContract.contractNo
					semmsi004tab4Bean.getPropertyTax().getPropertyTaxPayType();
					semmsi004tab4Bean.getPropertyTax().setRemark(siteAppSP.getPtRemark());
//					semmsi004tab4Bean.propertyTaxHistSPList
					
//					payBy
//					siteAppSP.getPtRemark()
				}
			}
			flag = true;
    	}catch (Exception e){
    		flag = false;
    		log.debug("Error Semmsi004Action doCopyPropertyTax");
    		e.printStackTrace();
    	}finally{
//    		setSemmsi004tab1Bean(semmsi004tab1Bean);
    		getSemmsi004tab4Action().setSemmsi004tab4Bean(semmsi004tab4Bean);
//    		setPopupSiteContractBean(popupSiteContractBean);
//    		setPopupSiteLocationBean(popupSiteLocationBean);
    	}
    	return flag;
    }
    
    public boolean doCopyElectric(){
    	boolean flag = false;
    	
		semmsa002Bean = getSemmsa002Bean();
		semmsi004Bean = getSemmsi004Bean();
//		semmsi004tab2Bean = getSemmsi004tab2Action().getSemmsi004tab2Bean();
		semmsi004tab5Bean = getSemmsi004tab5Action().getSemmsi004tab5Bean();
		//String rowId = getFacesUtils().getRequestParameter("rowId").toString().equals("") ? "" : (String)getFacesUtils().getRequestParameter("rowId");
		SiteAppSP siteAppSP = new SiteAppSP(); 
		SiteAppSiteSP siteAppSiteSP = new SiteAppSiteSP(); 
		SiteInfoMapLocSP siteInfoMapLocSP;
		List<SiteInfoMapLocSP> siteInfoMapLocList = new ArrayList<SiteInfoMapLocSP>();
		List<WrapperBeanObject<Mac003Srch>> detailList = new ArrayList<WrapperBeanObject<Mac003Srch>>();
		popupSiteContractBean = getPopupSiteContractBean();
		
    	try{
    		List<WrapperBeanObject<SiteAppSP>> siteAppList = semmsa002Bean.getSiteAppPopupHistoryList();
			for (WrapperBeanObject<SiteAppSP> wrapperBeanObject : siteAppList) {
				siteAppSP = (SiteAppSP) wrapperBeanObject.getDataObj();
				if (siteAppSP.isSelectFlag()) {
					//copy Contract
					log.debug("test : "+siteAppSP.getRowId());
//					
//					semmsi004tab2Bean.siteContract.contractNo
					semmsi004tab5Bean.isChkElectricType1();
					semmsi004tab5Bean.isChkElectricType2();
					semmsi004tab5Bean.isChkElectricType3();
					semmsi004tab5Bean.isChkElectricType4();
					log.debug("siteAppSP multi  "+siteAppSP.getElUseMultiResourse());
					semmsi004tab5Bean.isChkMultiElectricTypeFlag();
					semmsi004tab5Bean.isChkNoExpenses();
					semmsi004tab5Bean.getSiteElectric().setRemark(siteAppSP.getPayDesc());
					
//					siteAppSP.getElUseDesc
//					siteAppSP.getPayDesc
					log.debug("siteAppSP elOwnerType  "+siteAppSP.getElOwnerType());
//					semmsi004tab5Bean.siteElectric.electricOwnerType
					if(siteAppSP.getElUnitPrice() != null)
					semmsi004tab5Bean.getSiteElectric().setUnitPriceAmt(Double.parseDouble(siteAppSP.getElUnitPrice().toString()));
//					semmsi004tab5Bean.chkNoUnitPriceFlag
					
					log.debug("siteAppSP elPayOnPackage  "+siteAppSP.getElPayOnPackage());
					if(siteAppSP.getElPayOnPackage() != null)semmsi004tab5Bean.getSiteElectric().setTakeAllAmt(Double.parseDouble(siteAppSP.getElPayOnPackage().toString()));
					semmsi004tab5Bean.getSiteElectric().setTakeAllPeriodType(siteAppSP.getElPackagePeriodType());
					
//					semmsi004tab5Bean.siteElectric.vatType(siteAppSP.getElVatType())
//					semmsi004tab5Bean.payPeriodType01
//					semmsi004tab5Bean.payPeriodType02
//					semmsi004tab5Bean.payPeriodType03
//					semmsi004tab5Bean.payPeriod03
//					semmsi004tab5Bean.payPeriodType04
//					semmsi004tab5Bean.payPeriod04
//					semmsi004tab5Bean.payPeriodType05
//					
//					semmsi004tab5Bean.electricDepositNormal.depositCondType
//					semmsi004tab5Action.renderVatType
//					semmsi004tab5Bean.electricDepositNormal.depositAmt
//					semmsi004tab5Bean.electricDepositNormal.vatType
//					semmsi004tab5Bean.electricDepositNormal.remark
//					semmsi004tab5Bean.electricDepositNormal.chkNewStatus
//					semmsi004tab5Bean.electricDepositSpecialBg.detail
//					semmsi004tab5Bean.electricDepositSpecialCash.detail
//					semmsi004tab5Bean.electricDepositSpecialCash.vatType
//					
//					semmsi004tab5Bean.depositElectricBgSPList
//					semmsi004tab5Bean.depositElectricCashSPList
					
//					semmsi004tab5Bean.totalDeposit.totalDepositBgAmt
//					semmsi004tab5Bean.totalDeposit.totalDepositCashAmt
//					semmsi004tab5Bean.chkNoDepositElectric
				}
			}
			flag = true;
    	}catch (Exception e){
    		flag = false;
    		log.debug("Error Semmsi004Action doCopyElectric");
    		e.printStackTrace();
    	}finally{
//    		setSemmsi004tab1Bean(semmsi004tab1Bean);
    		getSemmsi004tab5Action().setSemmsi004tab5Bean(semmsi004tab5Bean);
//    		setPopupSiteContractBean(popupSiteContractBean);
//    		setPopupSiteLocationBean(popupSiteLocationBean);
    	}
    	return flag;
    }
    
    public boolean doCopyDepositElectric(){
    	boolean flag = false;
    	
		semmsa002Bean = getSemmsa002Bean();
		semmsi004Bean = getSemmsi004Bean();
//		semmsi004tab2Bean = getSemmsi004tab2Action().getSemmsi004tab2Bean();
		semmsi004tab5Bean = getSemmsi004tab5Action().getSemmsi004tab5Bean();
		//String rowId = getFacesUtils().getRequestParameter("rowId").toString().equals("") ? "" : (String)getFacesUtils().getRequestParameter("rowId");
		SiteAppSP siteAppSP = new SiteAppSP(); 
		SiteAppSiteSP siteAppSiteSP = new SiteAppSiteSP(); 
		SiteInfoMapLocSP siteInfoMapLocSP;
		List<SiteInfoMapLocSP> siteInfoMapLocList = new ArrayList<SiteInfoMapLocSP>();
		List<WrapperBeanObject<Mac003Srch>> detailList = new ArrayList<WrapperBeanObject<Mac003Srch>>();
//		popupSiteContractBean = getPopupSiteContractBean();
		List<Msi004SrchDepositElectricSP> depositElectricBgSPList = new ArrayList<Msi004SrchDepositElectricSP>();
		List<Msi004SrchDepositElectricSP> depositElectricCashSPList = new ArrayList<Msi004SrchDepositElectricSP>();
		
    	try{
    		List<WrapperBeanObject<SiteAppSP>> siteAppList = semmsa002Bean.getSiteAppPopupHistoryList();
			for (WrapperBeanObject<SiteAppSP> wrapperBeanObject : siteAppList) {
				siteAppSP = (SiteAppSP) wrapperBeanObject.getDataObj();
				if (siteAppSP.isSelectFlag()) {
					//copy Contract
					log.debug("test : "+siteAppSP.getRowId());
//		
//					if(siteAppSP.getElBGDeposit() != null){
//						Msi004SrchDepositElectricSP elDepositBG = new Msi004SrchDepositElectricSP();
//						elDepositBG.setExpenseType("08");
////						elDepositBG.setExpenseTypeName();
//						elDepositBG.setDepositType("01");
//						if(siteAppSP.getElBGDeposit() != null)elDepositBG.setDepositAmt(Double.parseDouble(siteAppSP.getElBGDeposit().toString()));
//						elDepositBG.setVatType(siteAppSP.getElBGDepositVatType());
//						elDepositBG.setRemark(siteAppSP.getElDepositRemarkBG());
////						NEW_STATUS
////						elDepositBG.setRECORD_STATUS,
////						elDepositBG.setVERSION,
//						elDepositBG.setSeqNo("1");
//						elDepositBG.setDepositCondType("01");
//						
//						depositElectricBgSPList.add(elDepositBG);
//						
//						semmsi004tab5Bean.setDepositElectricBgSPList(depositElectricBgSPList);	
//					}
//					
//					if(siteAppSP.getElCashDeposit() != null){
//						Msi004SrchDepositElectricSP elDepositBG = new Msi004SrchDepositElectricSP();
//						elDepositBG.setExpenseType("08");
//						elDepositBG.setDepositType("02");
//						if(siteAppSP.getElCashDeposit() != null)elDepositBG.setDepositAmt(Double.parseDouble(siteAppSP.getElCashDeposit().toString()));
//						elDepositBG.setVatType(siteAppSP.getElCashDepositVatType());
//						elDepositBG.setRemark(siteAppSP.getElDepositRemark());
////						NEW_STATUS
////						elDepositBG.setRECORD_STATUS,
////						elDepositBG.setVERSION,
//						elDepositBG.setSeqNo("1");
//						elDepositBG.setDepositCondType("01");
//						
//						depositElectricCashSPList.add(elDepositBG);
//						
//						semmsi004tab5Bean.setDepositElectricCashSPList(depositElectricCashSPList);
//					}
//					semmsi004tab5Bean.depositElectricCashSPList
					
//					semmsi004tab5Bean.totalDeposit.totalDepositBgAmt
//					semmsi004tab5Bean.totalDeposit.totalDepositCashAmt
//					semmsi004tab5Bean.chkNoDepositElectric
				}
			}
			flag = true;
    	}catch (Exception e){
    		flag = false;
    		log.debug("Error Semmsi004Action doCopyDepositElectric");
    		e.printStackTrace();
    	}finally{
//    		setSemmsi004tab1Bean(semmsi004tab1Bean);
    		getSemmsi004tab5Action().setSemmsi004tab5Bean(semmsi004tab5Bean);
//    		setPopupSiteContractBean(popupSiteContractBean);
//    		setPopupSiteLocationBean(popupSiteLocationBean);
    	}
    	return flag;
    }
    
    public boolean doCopyInsurance(){
    	boolean flag = false;
    	
		semmsa002Bean = getSemmsa002Bean();
		semmsi004Bean = getSemmsi004Bean();
//		semmsi004tab2Bean = getSemmsi004tab2Action().getSemmsi004tab2Bean();
		semmsi004tab6Bean = getSemmsi004tab6Action().getSemmsi004tab6Bean();
		//String rowId = getFacesUtils().getRequestParameter("rowId").toString().equals("") ? "" : (String)getFacesUtils().getRequestParameter("rowId");
		SiteAppSP siteAppSP = new SiteAppSP(); 
		SiteAppSiteSP siteAppSiteSP = new SiteAppSiteSP(); 
		SiteInfoMapLocSP siteInfoMapLocSP;
		List<SiteInfoMapLocSP> siteInfoMapLocList = new ArrayList<SiteInfoMapLocSP>();
		List<WrapperBeanObject<Mac003Srch>> detailList = new ArrayList<WrapperBeanObject<Mac003Srch>>();
		popupSiteContractBean = getPopupSiteContractBean();
		
    	try{
    		List<WrapperBeanObject<SiteAppSP>> siteAppList = semmsa002Bean.getSiteAppPopupHistoryList();
			for (WrapperBeanObject<SiteAppSP> wrapperBeanObject : siteAppList) {
				siteAppSP = (SiteAppSP) wrapperBeanObject.getDataObj();
				if (siteAppSP.isSelectFlag()) {
					//copy Contract
					log.debug("test : "+siteAppSP.getRowId());
//					
//					semmsi004tab2Bean.siteContract.contractNo
					semmsi004tab6Bean.getInsurance().getInsuranceType();
					semmsi004tab6Bean.getInsurance().setRemark(siteAppSP.getInsBeneficiary());
					semmsi004tab6Bean.getInsurance().getPlxOldAmt();
					semmsi004tab6Bean.getInsurance().getPlxAddAmt();
					semmsi004tab6Bean.getInsurance().getPlxAmt();
//					semmsi004tab6Bean.getInsurance().setPlxEffectiveDt(DateUtil.getDate(siteAppSP.getInsEffectiveDtStr(), "ddMMyyyy"));
					semmsi004tab6Bean.getInsurance().getPlxExpireDt();
//					if(siteAppSP.getInsSumInsured() != null)
//						semmsi004tab6Bean.getInsurance().setOwnerAmt(new Double(siteAppSP.getInsSumInsured().doubleValue()));
					semmsi004tab6Bean.getInsurance().getOwnerPeriodType();
					semmsi004tab6Bean.getInsurance().getOwnerVatType();
					semmsi004tab6Bean.getPayPeriodType01();
					semmsi004tab6Bean.getPayPeriodType02();
					semmsi004tab6Bean.getPayPeriodType03();
					semmsi004tab6Bean.getPayPeriod03();
					semmsi004tab6Bean.getPayPeriodType04();
					semmsi004tab6Bean.getPayPeriod04();
					semmsi004tab6Bean.getPayPeriodType05();
					
					
//					insFlag()
//					siteAppSP.getInsSumInsured();
//					siteAppSP.getInsEffectiveDtStr();
//					siteAppSP.getInsBeneficiary();
					
				}
			}
			flag = true;
    	}catch (Exception e){
    		flag = false;
    		log.debug("Error Semmsi004Action doCopyElectric");
    		e.printStackTrace();
    	}finally{
//    		setSemmsi004tab1Bean(semmsi004tab1Bean);
    		getSemmsi004tab6Action().setSemmsi004tab6Bean(semmsi004tab6Bean);
//    		setPopupSiteContractBean(popupSiteContractBean);
//    		setPopupSiteLocationBean(popupSiteLocationBean);
    	}
    	return flag;
    }
    
    public boolean doInitTodoList(){
    	try{
    		semmsi004Bean = getSemmsi004Bean();
    		getTreeNode();
    	}catch (Exception e) {
    		e.printStackTrace();
			// TODO: handle exception
		}finally{
			//setSemmsi004Bean(semmsi004Bean);
		}
		return true;
	}
    
    public void doSetParamPopupConfirm(Object obj){
		log.debug(" ####### Start SEMMSI004Action doSetParamPopupConfirm  ####### ");
		semmsi004Bean = getSemmsi004Bean();
		try{
			semmsi004Bean.setRetResultObj(new ItemResultSP());
			
			ItemResultSP itemObj = (ItemResultSP)obj;
			semmsi004Bean.setRenderedMsgPopup(true);
			
			if(itemObj.getResultMessage() != null)
				semmsi004Bean.getRetResultObj().setResultMessage(itemObj.getResultMessage());
			
			//set button type
			if(itemObj.getResultType() != null)semmsi004Bean.getRetResultObj().setResultType(itemObj.getResultType());
			
			if(itemObj.getOkBtnLabel() != null)semmsi004Bean.getRetResultObj().setOkBtnLabel(itemObj.getOkBtnLabel());
			if(itemObj.getNavProgram() != null)semmsi004Bean.getRetResultObj().setNavProgram(itemObj.getNavProgram());
			if(itemObj.getMethodWithNavi() != null)semmsi004Bean.getRetResultObj().setMethodWithNavi(itemObj.getMethodWithNavi());
			if(itemObj.getActionWithNavi() != null)semmsi004Bean.getRetResultObj().setActionWithNavi(itemObj.getActionWithNavi());
			
			if(itemObj.getCancelBtnLabel() != null)semmsi004Bean.getRetResultObj().setCancelBtnLabel(itemObj.getCancelBtnLabel());
			if(itemObj.getNavProgramCancel() != null)semmsi004Bean.getRetResultObj().setNavProgramCancel(itemObj.getNavProgramCancel());
			if(itemObj.getMethodWithNaviCancel() != null)semmsi004Bean.getRetResultObj().setMethodWithNaviCancel(itemObj.getMethodWithNaviCancel());
			if(itemObj.getActionWithNaviCancel() != null)semmsi004Bean.getRetResultObj().setActionWithNaviCancel(itemObj.getActionWithNaviCancel());
			
			//set param in button
			if(itemObj.getVal1() != null)semmsi004Bean.getRetResultObj().setVal1(itemObj.getVal1());
			if(itemObj.getVal2() != null)semmsi004Bean.getRetResultObj().setVal2(itemObj.getVal2());
			if(itemObj.getVal3() != null)semmsi004Bean.getRetResultObj().setVal3(itemObj.getVal3());
			if(itemObj.getVal4() != null)semmsi004Bean.getRetResultObj().setVal4(itemObj.getVal4());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.debug("###### Error SEMMSI004Action doSetParamPopupConfirm : "+e);
			
		}finally{
			setSemmsi004Bean(semmsi004Bean);
			log.debug(" ####### End SEMMSI004Action doSetParamPopupConfirm  ####### ");
		}
	}
    
    private void updateTotalRent(String siteInfoId) {
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		try{
			ISiteRentService service = (ISiteRentService)getBean("siteRentService");
			Rent rent = service.queryRentBySiteInfoId(siteInfoId);
			if(rent != null){
//				if(semmsi004tab3Bean.getRentCondNormal().getRentCondType().equals("01")){
					SumRentSP sumRent = semmsi004tab1Bean.getSumRentSP();
					if(sumRent != null){
						rent.setTotalRentAddAmt(sumRent.getRentAddAmt());
						rent.setTotalRentAddPeriodType(sumRent.getRentAddPeriodType());
						rent.setTotalServiceAddAmt(sumRent.getServiceAddAmt());
						rent.setTotalServiceAddPeriodType(sumRent.getServiceAddPeriodType());
						rent.setTotalRentAmt(sumRent.getRentAmt());
						rent.setTotalRentPeriodType(sumRent.getRentPeriodType());
						rent.setTotalServiceAmt(sumRent.getServiceAmt());
						rent.setTotalServicePeriodType(sumRent.getServicePeriodType());
						rent.setTotalRentServiceAmt(sumRent.getRentServiceAmt());
						rent.setTotalRentServicePeriodType(sumRent.getRentServicePeriodType());

						//rent.setTotalAgeRentServiceAmt(sumRent.getAgeRentServiceAmt()
						//13/03/2023 modify TotalAgeRentServiceAmt = TotalAgeRentServiceAmt+TotalAgeDonateAmt
						rent.setTotalAgeRentServiceAmt(sumRent.getAgeRentServiceAmt()+(sumRent.getAgeDonateAmt()==null?0:sumRent.getAgeDonateAmt()));
						rent.setTotalAgeDonateAmt(sumRent.getAgeDonateAmt());
						
						rent.setTotalAgeRentAmt(sumRent.getAgeRentAmt());
						rent.setTotalAgeServiceAmt(sumRent.getAgeServiceAmt());
					}
//				}else{
//					rent.setTotalRentAddAmt(semmsi004tab3Bean.getTotalRent().getTotalRentAddAmt());
//					rent.setTotalRentAddPeriodType(semmsi004tab3Bean.getTotalRent().getTotalRentAddPeriodType());
//					rent.setTotalServiceAddAmt(semmsi004tab3Bean.getTotalRent().getTotalServiceAddAmt());
//					rent.setTotalServiceAddPeriodType(semmsi004tab3Bean.getTotalRent().getTotalServiceAddPeriodType());
//					rent.setTotalRentAmt(semmsi004tab3Bean.getTotalRent().getTotalRentAmt());
//					rent.setTotalRentPeriodType(semmsi004tab3Bean.getTotalRent().getTotalRentPeriodType());
//					rent.setTotalServiceAmt(semmsi004tab3Bean.getTotalRent().getTotalServiceAmt());
//					rent.setTotalServicePeriodType(semmsi004tab3Bean.getTotalRent().getTotalServicePeriodType());
//					rent.setTotalRentServiceAmt(semmsi004tab3Bean.getTotalRent().getTotalRentServiceAmt());
//					rent.setTotalRentServicePeriodType(semmsi004tab3Bean.getTotalRent().getTotalRentServicePeriodType());
//					rent.setTotalAgeRentServiceAmt(semmsi004tab3Bean.getTotalRent().getTotalRentServiceAmt());
//					rent.setTotalAgeRentAmt(semmsi004tab3Bean.getTotalRent().getTotalAgeRentAmt());
//					rent.setTotalAgeServiceAmt(semmsi004tab3Bean.getTotalRent().getTotalAgeServiceAmt());
//				}
				rent.setCurrentUser(semmsi004tab3Bean.getUserLogin());
				semmsi004tab3Bean.setTotalRent(service.updateSiteRent(rent));
				setSemmsi004tab3Bean(semmsi004tab3Bean);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
    
    private void updateTotalDeposit(String siteInfoId) {
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		try{
			ISiteRentService service = (ISiteRentService)getBean("siteRentService");
			Rent rent = service.queryRentBySiteInfoId(siteInfoId);
			if(rent != null){
				
				//Add 7/12/2012
				SumDepositRentSP sumDepositRent = semmsi004tab1Bean.getSumDepositRentSP();
				if(semmsi004tab3Bean.getSiteDepositSpecialBg() != null && StringUtils.isNotEmpty(semmsi004tab3Bean.getSiteDepositSpecialBg().getDetail())){
					rent.setTotalDepositBgAmt(semmsi004tab3Bean.getTotalDeposit().getTotalDepositBgAmt());
				}else{
					if(sumDepositRent.getDepositBgAmt() != null)rent.setTotalDepositBgAmt(sumDepositRent.getDepositBgAmt());
				}
				
				if(semmsi004tab3Bean.getSiteDepositSpecialCash() != null && StringUtils.isNotEmpty(semmsi004tab3Bean.getSiteDepositSpecialCash().getDetail())){
					rent.setTotalDepositCashAmt(semmsi004tab3Bean.getTotalDeposit().getTotalDepositCashAmt());
				}else{
					if(sumDepositRent.getDepositCashAmt() != null)rent.setTotalDepositCashAmt(sumDepositRent.getDepositCashAmt());
				}
				
				
//				if(semmsi004tab3Bean.getSiteDepositNormal().getDepositCondType().equals("01")){
//					SumDepositRentSP sumDepositRent = semmsi004tab1Bean.getSumDepositRentSP();
//					rent.setTotalDepositBgAmt(sumDepositRent.getDepositBgAmt());
//					rent.setTotalDepositCashAmt(sumDepositRent.getDepositCashAmt());
//				}else{
//					rent.setTotalDepositBgAmt(semmsi004tab3Bean.getTotalDeposit().getTotalDepositBgAmt());
//					rent.setTotalDepositCashAmt(semmsi004tab3Bean.getTotalDeposit().getTotalDepositCashAmt());
//				}
				
				rent.setCurrentUser(semmsi004tab3Bean.getUserLogin());
				semmsi004tab3Bean.setTotalDeposit(service.updateSiteRent(rent));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab3Bean(semmsi004tab3Bean);
	}
}
