package th.co.ais.web.co.action;

import java.io.IOException;
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
import org.apache.log4j.Logger;
import org.richfaces.component.UITree;
import org.richfaces.component.html.HtmlTree;
import org.richfaces.event.NodeSelectedEvent;
import org.richfaces.model.TreeNode;
import org.richfaces.model.TreeNodeImpl;

import th.co.ais.common.service.IMenuTreeService;
import th.co.ais.domain.co.ContractCheckDoc;
import th.co.ais.domain.co.Mco001ContractStatusSP;
import th.co.ais.domain.co.Mco001Exp;
import th.co.ais.domain.co.Mco001SrchSP;
import th.co.ais.domain.co.Mco001UpdateCheckDocLSP;
import th.co.ais.domain.co.Mco001UpdateCheckDocSP;
import th.co.ais.domain.common.MenuTreeSP;
import th.co.ais.domain.gm.Attachment;
import th.co.ais.domain.sa.MSA001LovSP;
import th.co.ais.domain.sa.SiteAppSP;
import th.co.ais.domain.si.Construct;
import th.co.ais.domain.si.Contract;
import th.co.ais.domain.si.Deposit;
import th.co.ais.domain.si.Electric;
import th.co.ais.domain.si.Insurance;
import th.co.ais.domain.si.LegalSiteAppSP;
import th.co.ais.domain.si.Lessor;
import th.co.ais.domain.si.PropertyTax;
import th.co.ais.domain.si.Rent;
import th.co.ais.domain.si.RentCond;
import th.co.ais.domain.si.SiteInfo;
import th.co.ais.domain.si.SubRent;
import th.co.ais.rpt.domain.SEMECO007Domain;
import th.co.ais.rpt.util.bean.CellDomain;
import th.co.ais.rpt.util.bean.EnumDocStyleDomain;
import th.co.ais.rpt.util.bean.RowDomain;
import th.co.ais.rpt.util.enums.EnumDocStyle;
import th.co.ais.rpt.util.enums.EnumDocumentType;
import th.co.ais.service.co.IContractCheckDocService;
import th.co.ais.service.gm.IAttachmentService;
import th.co.ais.service.sa.ISiteAcquistionService;
import th.co.ais.service.si.ILegalSiteAppService;
import th.co.ais.service.si.ISiteContractService;
import th.co.ais.util.ELovType;
import th.co.ais.util.ELovVal;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.TreeUtilBean;
import th.co.ais.web.bean.UserSession;
import th.co.ais.web.bean.common.PopupUploadFilePictureBean;
import th.co.ais.web.co.bean.SEMMCO001Bean;
import th.co.ais.web.ir.bean.FileUploadBean;
import th.co.ais.web.report.util.DocumentExportManager;
import th.co.ais.web.sa.bean.LegalDocComponentBean;
import th.co.ais.web.si.action.SEMMSI004Action;
import th.co.ais.web.si.action.SEMMSI004Tab1Action;
import th.co.ais.web.si.action.SEMMSI004Tab2Action;
import th.co.ais.web.si.action.SEMMSI004Tab3Action;
import th.co.ais.web.si.action.SEMMSI004Tab4Action;
import th.co.ais.web.si.action.SEMMSI004Tab5Action;
import th.co.ais.web.si.action.SEMMSI004Tab6Action;
import th.co.ais.web.si.action.SEMMSI004Tab7Action;
import th.co.ais.web.si.bean.SEMMSI002Bean;
import th.co.ais.web.si.bean.SEMMSI004Bean;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.FileNameUtil;
import th.co.ais.web.util.FileUtil;
import th.co.ais.web.util.RegionCacheUtil;

public class SEMMCO001Action extends AbstractAction{

	private static final long serialVersionUID = 5934806069385322547L;

	private Logger log = Logger.getLogger(getClass());
	
	private PopupUploadFilePictureBean popupUploadFilePictureBean;
	public void setPopupUploadFilePictureBean(PopupUploadFilePictureBean popupUploadFilePictureBean) {
		this.popupUploadFilePictureBean = popupUploadFilePictureBean;
		getFacesUtils().setSessionMapValue("popupUploadFilePictureBean", popupUploadFilePictureBean);
	}
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		
		if (methodWithNavi.equalsIgnoreCase("doSearch")) {
			flag = doSearch();
		}
		if (methodWithNavi.equalsIgnoreCase("initUpdateContract")) {
			flag = initUpdateContract();
		}
		if (methodWithNavi.equalsIgnoreCase("doBack")) {
			flag = doBack();
		}
		if (methodWithNavi.equalsIgnoreCase("initSiteInfo")) {
			flag = initSiteInfo();
		}
		if (methodWithNavi.equalsIgnoreCase("doUpdateTab")) {
			flag = doUpdateTab();
		}
		if (methodWithNavi.equalsIgnoreCase("doClear")) {
			flag = doClear();
		}
		if(methodWithNavi.equalsIgnoreCase("doDefaultEffDateFrom")){
			flag = doDefaultEffDateFrom();
		}
		if(methodWithNavi.equalsIgnoreCase("doDefaultEffDateTo")){
			flag = doDefaultEffDateTo();
		}
		if(methodWithNavi.equalsIgnoreCase("doDefaultExpDateFrom")){
			flag = doDefaultExpDateFrom();
		}
		if(methodWithNavi.equalsIgnoreCase("doDefaultExpDateTo")){
			flag = doDefaultExpDateTo();
		}
		if(methodWithNavi.equalsIgnoreCase("doClearSession")){
			flag = doClearSession();
		}
		if(methodWithNavi.equalsIgnoreCase("doDelAttachment")){
			flag = doDelAttachment();
		}
		if(methodWithNavi.equalsIgnoreCase("initDelAttachment")){
			flag = initDelAttachment();
		}
		if (methodWithNavi.equalsIgnoreCase("doCreateAttachment")) {
			flag = doCreateAttachment();
		}
		
		// 2015/01/26 added by.. YUT 
		if(methodWithNavi.equalsIgnoreCase("doInitialForSearchContract")) {
			flag = this.doInitialForSearchContract();
		}
		if(methodWithNavi.equalsIgnoreCase("doInitTodoList")){
			flag = this.doInitTodoList();
		}
		if(methodWithNavi.equalsIgnoreCase("getTreeNode")){
			getTreeNode();
		}
		// 04/03/2016 added by NEW
		if(methodWithNavi.equalsIgnoreCase("setTabNo")){
			flag = setTabNo();
		}

		return flag;
	}


	private boolean doDefaultExpDateTo() {
		boolean flag = false;
		Date expDateFrom = getSemmco001Bean().getCriteriaSP().getExpDateFrom();
		Date expDateTo = getSemmco001Bean().getCriteriaSP().getExpDateTo();
		log.info("expDateFrom :" + expDateFrom);
		log.info("expDateTo :" + expDateTo);
		if(expDateTo != null){
			if(expDateFrom == null){
				defaultExpFromToDt(expDateTo);
			}
		}else{
			getSemmco001Bean().getCriteriaSP().setExpDateFrom(null);
		}
		return flag;
	}

	private boolean doDefaultExpDateFrom() {
		boolean flag = false;
		Date expDateFrom = getSemmco001Bean().getCriteriaSP().getExpDateFrom();
		Date expDateTo = getSemmco001Bean().getCriteriaSP().getExpDateTo();
		log.info("expDateFrom :" + expDateFrom);
		log.info("expDateTo :" + expDateTo);
		if(expDateFrom != null){
			if(expDateTo == null){
				defaultExpFromToDt(expDateFrom);
			}
		}else{
			getSemmco001Bean().getCriteriaSP().setExpDateTo(null);
		}
		return flag;
	}
	
	private boolean defaultExpFromToDt(Date selDt){
		boolean flag = false;
		SEMMCO001Bean semmco001Bean = getSemmco001Bean();
		semmco001Bean.getCriteriaSP().setExpDateFrom(selDt);
		semmco001Bean.getCriteriaSP().setExpDateTo(selDt);
		setSemmco001Bean(semmco001Bean);
		return flag;
	}

	private boolean doDefaultEffDateTo() {
		boolean flag = false;
		Date effDateFrom = getSemmco001Bean().getCriteriaSP().getEffDateFrom();
		Date effDateTo = getSemmco001Bean().getCriteriaSP().getEffDateTo();
		log.info("effDateFrom :" + effDateFrom);
		log.info("effDateTo :" + effDateTo);
		
		if(effDateTo != null){
			if(effDateFrom == null){
				defaultEffFromToDt(effDateTo);
			}
		}else{
			getSemmco001Bean().getCriteriaSP().setEffDateFrom(null);
		}
		return flag;
	}

	private boolean doDefaultEffDateFrom() {
		boolean flag = false;
		Date effDateFrom = getSemmco001Bean().getCriteriaSP().getEffDateFrom();
		Date effDateTo = getSemmco001Bean().getCriteriaSP().getEffDateTo();
		log.info("effDateFrom :" + effDateFrom);
		log.info("effDateTo :" + effDateTo);
		
		if(effDateFrom != null){
			if(effDateTo == null){
				defaultEffFromToDt(effDateFrom);
			}
		}else{
			getSemmco001Bean().getCriteriaSP().setEffDateTo(null);
		}
		return flag;
	}
	private boolean defaultEffFromToDt(Date selDt){
		boolean flag = false;
		SEMMCO001Bean semmco001Bean = getSemmco001Bean();
		semmco001Bean.getCriteriaSP().setEffDateFrom(selDt);
		semmco001Bean.getCriteriaSP().setEffDateTo(selDt);
		setSemmco001Bean(semmco001Bean);
		return flag;
	}


	private boolean doClear() {
		boolean flag = false;
		semmco001Bean = getSemmco001Bean();
		semmco001Bean.setCriteriaSP(new Mco001SrchSP());
		semmco001Bean.getCriteriaSP().setCompany("");
		semmco001Bean.getCriteriaSP().setRegion("");
		semmco001Bean.getCriteriaSP().setDocNo("");
		semmco001Bean.getCriteriaSP().setReqType("");
		semmco001Bean.getCriteriaSP().setTitle("");
		semmco001Bean.getCriteriaSP().setContractNo("");
		semmco001Bean.getCriteriaSP().setSiteName("");
		semmco001Bean.getCriteriaSP().setEffDateFrom(null);
		semmco001Bean.getCriteriaSP().setEffDateTo(null);
		semmco001Bean.getCriteriaSP().setExpDateFrom(null);
		semmco001Bean.getCriteriaSP().setExpDateTo(null);
		semmco001Bean.getCriteriaSP().setLessorName("");
		semmco001Bean.getCriteriaSP().setLocationId("");
		semmco001Bean.getCriteriaSP().setContractStatus("");
		semmco001Bean.getCriteriaSP().setCheckDocStatus("");
		semmco001Bean.getCriteriaSP().setDutyPayStatus("");
		semmco001Bean.getCriteriaSP().setTotSendStatus("");
		semmco001Bean.getCriteriaSP().setCurrentFlag("Y");
		semmco001Bean.setContractSPList(new ArrayList<WrapperBeanObject<Mco001SrchSP>>());
		semmco001Bean.setDisabledBtnPrint(true);
		semmco001Bean.setChkSelAll(false);
		semmco001Bean.setChkNoExpireFlag(false);
		semmco001Bean.setRenderedMsgDataNotFound(false);
		semmco001Bean.setContractStatusList(getEmptyDropDown());
		
		//added by NEW 18/03/2015 for to do list page
		semmco001Bean.setTreeUtilBean(new TreeUtilBean());
		semmco001Bean.setRootNode(new TreeNodeImpl());
		rootNode = null;
		semmco001Bean.setMenuTreeMacroList(new ArrayList<WrapperBeanObject<MenuTreeSP>>());
		semmco001Bean.setMenuTreePicoList(new ArrayList<WrapperBeanObject<MenuTreeSP>>());
		semmco001Bean.setTreeMacroFlag(false);
		semmco001Bean.setTreePicoFlag(false);
		setSemmco001Bean(semmco001Bean);
		return flag;
	}


	private boolean doUpdateTab() {
		boolean flag = false;
		String tabNo = (String)getFacesUtils().getRequestParameter("tabNo");
		if(tabNo != null && tabNo.equals("1")){
			getSemmco001tab1Action().doUpdateTab1();
		}
		if(tabNo != null && tabNo.equals("2")){
			getSemmco001tab1Action().doUpdateTab2();
		}
		if(tabNo != null && tabNo.equals("3")){
			doUpdateLegalDoc();
			getSemmco001tab3Action().doUpdateTab3();
		}
		return flag;
	}


	private boolean initSiteInfo() {
		boolean flag = true;
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		String page = (String)getFacesUtils().getRequestParameter("page");
		try{
			if(rowId != null){
				getSemmsi004Action().init();
				getSemmsi004tab1Action().init();
				getSemmsi004tab2Action().init();
				getSemmsi004tab1Action().initTab1();
				getSemmsi004tab1Action().getDataTab1(rowId);
				getSemmsi004Action().getDataContract(getSemmco001Bean().getSiteInfoParam());
				getSemmsi004Bean().setSiteInfoId(rowId);
				getSemmsi004Bean().setRenderedBtnBackSiteInfo(true);
				getSemmsi004Bean().setRenderedBtnBackContract(false);
				getSemmsi004Bean().setRenderBtnSave(false);
				getSemmsi004Bean().setRenderTab1(true);
				getSemmsi004Bean().setRenderPanelLog(true);
				getSemmsi004Bean().setRenderBtnSave(true);
				getSemmsi004Bean().setSelectedTab("tab1");
				getSemmsi004Bean().setTempTabNo("1");
				getSemmsi004Bean().setShowMessageSave(true);
				getSemmsi004Bean().setMode(mode);
				getSemmsi004Bean().setPage(page);
				setSemmsi004Bean(getSemmsi004Bean());
				getSemmsi004tab1Action().checkMode(rowId);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}


	private boolean doBack() {
		boolean flag = true;
		semmco001Bean = getSemmco001Bean();
		this.doSearch();
		this.renderCompany();
		setSemmco001Bean(semmco001Bean);
		return flag;
	}

	private boolean doClearSession() {
		boolean flag = true;
		try{
		semmco001Bean = getSemmco001Bean();
		getSemmco001tab1Action().initTab1(semmco001Bean.getSiteInfoParam());
		setSemmco001Bean(semmco001Bean);
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}


	public boolean initUpdateContract() {
		boolean flag = true;
		try{
			initSiteInfoSemmsi004();
			semmco001Bean = getSemmco001Bean();
			String rowId = (String)getFacesUtils().getRequestParameter("rowId");
			String siteName = (String)getFacesUtils().getRequestParameter("siteName");
			String company = (String)getFacesUtils().getRequestParameter("company");
			String siteInfoId = (String)getFacesUtils().getRequestParameter("siteInfoId");
			String picoFlag = (String)getFacesUtils().getRequestParameter("picoFlag");
			
			String siteAppId = getFacesUtils().getRequestParameter("siteAppId") == null ? "" : (String) getFacesUtils().getRequestParameter("siteAppId");
			String placeType = getFacesUtils().getRequestParameter("placeType") == null ? "" : (String) getFacesUtils().getRequestParameter("placeType");
			String partiesType = getFacesUtils().getRequestParameter("partiesType") == null ? "" : (String) getFacesUtils().getRequestParameter("partiesType");
			String placeTypeRemark = getFacesUtils().getRequestParameter("placeTypeRemark") == null ? "" : (String) getFacesUtils().getRequestParameter("placeTypeRemark");
			String partiesTypeRemark = getFacesUtils().getRequestParameter("partiesTypeRemark") == null ? "" : (String) getFacesUtils().getRequestParameter("partiesTypeRemark");
			String docApproveId = getFacesUtils().getRequestParameter("docApproveId") == null ? "" : (String) getFacesUtils().getRequestParameter("docApproveId");
			semmco001Bean.setContractIdParam(rowId);
			semmco001Bean.setSiteNameParam(siteName);
			semmco001Bean.setCompanyParam(company);
			semmco001Bean.setRenderedMsgFormSearch(true);
			semmco001Bean.setSiteInfoParam(siteInfoId);
			semmco001Bean.setLegalPlaceTypeList(getLovItemsByType(ELovType.T_SI_LEGAL_PLACE_TYPE.name));
			semmco001Bean.setLegalPartiesTypeList(getLovItemsByType(ELovType.T_SI_LEGAL_PARTIES_TYPE.name));
			//semmco001Bean.setPicoFlag("Y");
			semmco001Bean.setPicoFlag(picoFlag);
			semmco001Bean.setSiteAppObjParam(new SiteAppSP());
			semmco001Bean.getSiteAppObjParam().setSiteAppId(siteAppId);
			semmco001Bean.getSiteAppObjParam().setDocApproveId(docApproveId);
			if(!placeType.isEmpty())
				semmco001Bean.getSiteAppObjParam().setPlaceType(placeType);
			else
				semmco001Bean.getSiteAppObjParam().setPlaceType("");
			semmco001Bean.getSiteAppObjParam().setPlaceTypeRemark(placeTypeRemark);
			if(!partiesType.isEmpty())
				semmco001Bean.getSiteAppObjParam().setPartiesType(partiesType);
			else
				semmco001Bean.getSiteAppObjParam().setPartiesType("");
			semmco001Bean.getSiteAppObjParam().setPartiesTypeRemark(partiesTypeRemark);
			setSemmco001Bean(semmco001Bean);
			// get contractNo, siteInfoId, effDate, expDate
			this.getContractByRowId();
			
			if(semmco001Bean.isRenderedContract()){
				getSemmco001tab1Action().initTab1(semmco001Bean.getSiteInfoParam());
				getSemmco001Bean().setTabNo("2");
				getSemmco001tab2Action().initTab2();
			}else{
				getSemmco001tab1Action().initTab1(semmco001Bean.getSiteInfoParam());
			}
			
			semmco001Bean.setSemeco007Domain(new SEMECO007Domain());
			
			// save contract check doc
			this.createContractCheckDoc();
			
			//get legalDoc Tab 3
			doGetLegalDoc();
			setSemmco001Bean(semmco001Bean);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			getSemmco001tab3Action().init();
		}
		return flag;
	}
	
	private void initSiteInfoSemmsi004() {
		String reqType = (String)getFacesUtils().getRequestParameter("reqType");
		String docApproveId = (String)getFacesUtils().getRequestParameter("docApproveId");
		String assignSiteInfoId = (String)getFacesUtils().getRequestParameter("assignSiteInfoId");
	    String siteInfoId = (String)getFacesUtils().getRequestParameter("siteInfoId");
	    String company = (String)getFacesUtils().getRequestParameter("company");
	    String region = (String)getFacesUtils().getRequestParameter("region");
	    String docApproveType = (String)getFacesUtils().getRequestParameter("docApproveType");
	    String assignContractNo = (String)getFacesUtils().getRequestParameter("assignContractNo");
	    String siteType = (String)getFacesUtils().getRequestParameter("siteType");
	    String siteAppId = (getFacesUtils().getRequestParameter("siteAppId") == null) ? "" : (String)getFacesUtils().getRequestParameter("siteAppId");
	    String mode = (String)getFacesUtils().getRequestParameter("mode");
	    String page = (String)getFacesUtils().getRequestParameter("page");
	    getSemmsi004tab1Action().init();
	    getSemmsi004tab1Action().initTab1();
	    getSemmsi004tab2Action().init();
	    getSemmsi004tab4Action().init();
	    getSemmsi004tab4Action().initTab4(siteInfoId);
	    getSemmsi004tab5Action().init();
	    getSemmsi004tab5Action().initTab5(siteInfoId);
	    getSemmsi004tab3Action().init();
	    this.semmsi004Bean = getSemmsi004Bean();
	    this.semmsi004Bean.setSiteInfo(new SiteInfo());
	    this.semmsi004Bean.setSiteContract(new Contract());
	    this.semmsi004Bean.setSiteConstruct(new Construct());
	    this.semmsi004Bean.setSiteDeposit(new Deposit());
	    this.semmsi004Bean.setSiteElectric(new Electric());
	    this.semmsi004Bean.setSiteInfo(new SiteInfo());
	    this.semmsi004Bean.setSiteInsurance(new Insurance());
	    this.semmsi004Bean.setSiteLessor(new Lessor());
	    this.semmsi004Bean.setSitePropertyTax(new PropertyTax());
	    this.semmsi004Bean.setSiteRent(new Rent());
	    this.semmsi004Bean.setSiteRentCond(new RentCond());
	    this.semmsi004Bean.setSiteSubRent(new SubRent());
	    this.semmsi004Bean.setPage(page);
	    this.semmsi004Bean.setMode(mode);
	    this.semmsi004Bean.setReqTypeParam(reqType);
	    this.semmsi004Bean.setSiteTypeParam(siteType);
	    this.semmsi004Bean.setSiteInfoId(siteInfoId);
	    this.semmsi004Bean.setDocApproveIdParam(docApproveId);
	    this.semmsi004Bean.setDocApproveTypeParam(docApproveType);
	    this.semmsi004Bean.setCompanyParam(company);
	    this.semmsi004Bean.setRegionParam(region);
	    this.semmsi004Bean.setAssignContractNoParam(assignContractNo);
	    this.semmsi004Bean.setRenderTab1(true);
	    this.semmsi004Bean.setRenderPanelLog(true);
	    this.semmsi004Bean.setRenderBtnSave(true);
	    this.semmsi004Bean.setSelectedTab("tab1");
	    this.semmsi004Bean.setTempTabNo("1");
	    this.semmsi004Bean.setShowMessageSave(true);
	    this.semmsi004Bean.setSiteAppObjParam(new SiteAppSP());
	}
	
	//update by new 17/12/2014
	public void doGetLegalDoc() {
		log.info("::: SEMMSI002Action :: doGetLegalDoc >> BEGIN :::");

		try {
			
			//SEMMSI002Bean semmsi002Bean = getSemmsi002Bean();
			semmco001Bean = getSemmco001Bean();

			String paramSiteAppId = semmco001Bean.getSiteAppObjParam().getSiteAppId();
			String paramPlaceType = semmco001Bean.getSiteAppObjParam().getPlaceType(); //String paramPlaceType = semmsa002Bean.getParamPlaceType(); old fixed to new 
			String paramPartiesType = semmco001Bean.getSiteAppObjParam().getPartiesType(); //String paramPartiesType = semmsa002Bean.getParamPartiesType(); old fixed to new 
//			
//	        System.out.println("paramSiteAppId: " + paramSiteAppId);
//	        System.out.println("paramPlaceType: " + paramPlaceType);
//	        System.out.println("paramPartiesType: " + paramPartiesType);
//	        
	        
	        SEMMSI002Bean semmsi002BeanCriteria = new SEMMSI002Bean();
	        semmsi002BeanCriteria.setParamSiteAppId(paramSiteAppId);
	        semmsi002BeanCriteria.setParamPlaceType(paramPlaceType);
	        semmsi002BeanCriteria.setParamPartiesType(paramPartiesType);
			
	        semmco001Bean.setLegalDocList(new ArrayList<WrapperBeanObject<LegalDocComponentBean>>());
	        
	        if((paramSiteAppId != null && !paramSiteAppId.equalsIgnoreCase("")) 
	        	&& (paramPlaceType != null && !paramPlaceType.equalsIgnoreCase("")) 
	        	&& (paramPartiesType != null && !paramPartiesType.equalsIgnoreCase(""))){

				ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService");
	
				List<MSA001LovSP> retObjList = service.siteAppDao_querySPList(EQueryName.SP_MSA001_GET_LEGAL_DOC.name, semmsi002BeanCriteria);
				int count = 1;
				int retObjListSize = retObjList.size();
				if(retObjList != null && !retObjList.isEmpty()){
					for(int i = 0; i < retObjList.size(); i++){
						MSA001LovSP ret = (MSA001LovSP) retObjList.get(i);
						System.out.println("SP_MSA001_GET_LEGAL_DOC: " + ret.toString());
						
						String myCode = ret.getLovCode();
						String myDesc = ret.getLovName();
						String myChk = ret.getDocFlag() == null ? "" : ret.getDocFlag().toString();
						String myRemark = ret.getDocRemark();
						String myDispRemark = ret.getShowRemark();
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
						//--------------------------------------------------------------
						
						log.debug("mco001 getLicenseDocument : "+myComponent.getLicenseDocument());
						WrapperBeanObject<LegalDocComponentBean> tmpWrapperBean = new WrapperBeanObject<LegalDocComponentBean>();
						
						tmpWrapperBean.setDataObj(myComponent);
						tmpWrapperBean.setMessage("");

						semmco001Bean.getLegalDocList().add(tmpWrapperBean);
						// gen legal doc component list <<
						
						count++;
					}
					semmco001Bean.setRenderedMsgDataNotFound(false);
	        	} else {
	        		semmco001Bean.setRenderedMsgDataNotFound(true);
	        	}
        	
	        }
			setSemmco001Bean(semmco001Bean);
			//setSEMMSA002Bean(semmsa002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			addMessageError("EL0000", "SEMMSI002Action");
		} finally {
			log.info("::: SEMMCO001Action :: doGetLegalDoc >> END :::");
		}
	}
	
	public void doChangeChkBoxLegalDoc() {
		String checkBoxStatus = "";
		String itemCode = "";
		if(getFacesUtils().getRequestParameter("checkBoxStatus")!=null)
			checkBoxStatus = (String)getFacesUtils().getRequestParameter("checkBoxStatus");
		if(getFacesUtils().getRequestParameter("itemCode")!=null)
			itemCode = (String)getFacesUtils().getRequestParameter("itemCode");
		try {
			semmco001Bean = getSemmco001Bean();
			//semmsi002Bean = getSemmsi002Bean();
			
//			HashSet keys = new HashSet<Integer>();
//	        int rowKey = getRepeater().getRowIndex();
			
	       // System.out.println("rowKey: " + Integer.toString(rowKey));
	        
			List<WrapperBeanObject<LegalDocComponentBean>> legalDocLst = semmco001Bean.getLegalDocList();
			List<WrapperBeanObject<LegalDocComponentBean>> legalDocLstNew = new ArrayList<WrapperBeanObject<LegalDocComponentBean>>();
			WrapperBeanObject<LegalDocComponentBean> legalDocNew = new WrapperBeanObject<LegalDocComponentBean>();
			System.out.println("getLegalDocList size: " + legalDocLst.size());
			
			for(int i=0; i<legalDocLst.size(); i++){
				legalDocNew = new WrapperBeanObject<LegalDocComponentBean>();
				LegalDocComponentBean myObj = (LegalDocComponentBean) legalDocLst.get(i).getDataObj();

				System.out.println("myObj.isChkHaveFlag(): " + myObj.isChkHaveFlag());
				System.out.println("myObj.isChkNotHaveFlag(): " + myObj.isChkNotHaveFlag());
				if(myObj.getItemCode().equals(itemCode)){
//					log.debug("checkBoxStatus : "+checkBoxStatus);
//					log.debug("itemCode : "+itemCode);
					if(checkBoxStatus.equals("Y")){
						
						if(myObj.isChkHaveFlag()){
							myObj.setItemIsChk("Y");
							myObj.setChkHaveFlag(true); 
							myObj.setChkNotHaveFlag(false);
						}else{
							myObj.setItemIsChk("");
							myObj.setChkHaveFlag(false); 
							myObj.setChkNotHaveFlag(false);
						}
					}else if(checkBoxStatus.equals("N")){
						if(myObj.isChkNotHaveFlag()){
							myObj.setItemIsChk("N");
							myObj.setChkHaveFlag(false); 
							myObj.setChkNotHaveFlag(true);
						}else{
							myObj.setItemIsChk("");
							myObj.setChkHaveFlag(false); 
							myObj.setChkNotHaveFlag(false);
						}
					}
					
					legalDocNew.setDataObj(myObj);
					legalDocLstNew.add(legalDocNew);
					semmco001Bean.setLegalDocList(legalDocLst);
				}
				
//				if(myObj.isChkHaveFlag() && !myObj.isChkNotHaveFlag()) {
//				 	myObj.setChkHaveFlag(true);
//				 	myObj.setChkNotHaveFlag(false);
//					myObj.setItemIsChk("Y");
//				}  else if (!myObj.isChkHaveFlag() && myObj.isChkNotHaveFlag()) {
//					myObj.setChkHaveFlag(false);
//				 	myObj.setChkNotHaveFlag(true);
//					myObj.setItemIsChk("N");
//				} else {
//					myObj.setChkHaveFlag(false);
//				 	myObj.setChkNotHaveFlag(false);
//					myObj.setItemIsChk("");
//				}
				
				//legalDocLst.get(i).setDataObj(myObj);
				//legalDocNew.setDataObj(myObj);
				//legalDocLstNew.add(legalDocNew);
				//semmsi002Bean.setLegalDocList(legalDocLst);
			}
			
			//setSEMMSA002Bean(semmsa002Bean);
			setSemmco001Bean(semmco001Bean);
		} catch(Exception e) {
			e.printStackTrace();
			addMessageError("EL0000", "SEMMCO001Action");
			
			//semmco001Bean.setRenderedMsgAlert(true);
			setSemmco001Bean(semmco001Bean);
		} finally {
			
		}
	}
	
	public void doUpdateLegalDoc() {
		
		try {
			
			this.doSetCheckBoxLegalDocEntity();			
			
			semmco001Bean = getSemmco001Bean();
			//semmsi002Bean = getSemmsi002Bean();
			
			List<WrapperBeanObject<LegalDocComponentBean>> legalDocLst = semmco001Bean.getLegalDocList();
			System.out.println("getLegalDocList size: " + legalDocLst.size());
			
			String strDataList = "";
			
			for(int i=0; i<legalDocLst.size(); i++){
				System.out.println("getLegalDocList i getDataObj: " + legalDocLst.get(i).getDataObj().toString());
				
				LegalDocComponentBean myObj = (LegalDocComponentBean) legalDocLst.get(i).getDataObj();
				
				String docCode = myObj.getItemCode() == null ? "" : myObj.getItemCode().toString();
				String docRemark = myObj.getItemRemark() == null ? "" : myObj.getItemRemark().toString();
				String docFlag = myObj.getItemIsChk() == null ? "" : myObj.getItemIsChk().toString();
				String docAmount = myObj.getItemDocAmount() == null ? "" : myObj.getItemDocAmount().toString();
				
				strDataList += "" + docCode + "|" + docFlag + "|" + docRemark + "|" +docAmount + ", ";
			}
			if(strDataList != null && !strDataList.equals("")){
				strDataList = strDataList.substring(0, strDataList.length() - 2);
			}
			
//			System.out.println("strDataList: " + strDataList);
//
//			System.out.println("getSiteAppId: " + semmco001Bean.getSiteAppObjParam().getSiteAppId());
			semmco001Bean.getSiteAppObjParam().setStrDataList(strDataList);
			semmco001Bean.getSiteAppObjParam().setUserLogin(getUserLogIn());
//
//			ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService");
//			List<SiteAppSP> to = service.siteAppDao_querySPList(EQueryName.SP_MSA002_SITE_APP_DOC_SAVE.name, semmco001Bean.getSiteAppObjParam());
//			
//			if (to != null && !to.isEmpty()) {
//				if (to.get(0).getRetResult().equals("Success")) {
//					addMessageInfo("M0001");	// data save success
//					//semmco001Bean.setRenderedMsgAlert(true);
//				} else {
//					addMessageError("E0001");	// data save fail
//					//semmco001Bean.setRenderedMsgAlert(true);
//				}
//			}
			
			setSemmco001Bean(semmco001Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			addMessageError("EL0000", "SEMMCO001Action");
			
			setSemmco001Bean(semmco001Bean);
		} finally {
			
		}
		
	}
	
	public void doSetCheckBoxLegalDocEntity() {
		
		try {
			
			semmco001Bean = getSemmco001Bean();
			//semmsi002Bean = getSemmsi002Bean();
			
			List<WrapperBeanObject<LegalDocComponentBean>> legalDocLst = semmco001Bean.getLegalDocList();
			System.out.println("getLegalDocList size: " + legalDocLst.size());
			
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
				
				semmco001Bean.setLegalDocList(legalDocLst);
			}
			
			setSemmco001Bean(semmco001Bean);
			//setSemmsi002Bean(semmsi002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			addMessageError("EL0000", "SEMMCO001Action");
			log.debug("ERROR SEMMCO001Action doSetCheckBoxLegalDocEntity "+e);
			setSemmco001Bean(semmco001Bean);
		} finally {
			
		}
	}


	private void createContractCheckDoc() {
		semmco001Bean = getSemmco001Bean();
		List<ContractCheckDoc> list = null;
		try{
			IContractCheckDocService service = (IContractCheckDocService)getBean("contractCheckDocService");
			String contractId = semmco001Bean.getContractIdParam();
			if(contractId != null && !contractId.equals("")){
				list = service.queryContractCheckDocByContractId(contractId);
				ContractCheckDoc contractCheckDoc = new ContractCheckDoc();
				contractCheckDoc.setContractId(contractId);
				contractCheckDoc.setCurrentUser(semmco001Bean.getUserLogin());
				if (list.size()>0){
					List<Mco001UpdateCheckDocLSP> toDocL = null;
					// UPDATE CHECK DOC CALL SEM_SP_MCO001_UPD_CHECK_DOC
					Mco001UpdateCheckDocLSP docL = new Mco001UpdateCheckDocLSP();
					docL.setSiteInfoId(semmco001Bean.getSiteInfoParam());
					docL.setCurrentUser(semmco001Bean.getUserLogin());
					docL.setpOption("DEL");
					toDocL = service.querySPList(EQueryName.SP_MCO001_UPD_CHECK_DOC_L.name, docL);
					if(toDocL != null && !toDocL.isEmpty() && toDocL.get(0).getResultMsg().equals("Success")){
						log.debug("update check doc Legal result [" + toDocL.get(0).getResultMsg());
					}
				}
					ContractCheckDoc checkDoc = service.createContractCheckDoc(contractCheckDoc);
					try{
						if(checkDoc != null){
							List<Mco001UpdateCheckDocSP> to = null;
							// UPDATE CHECK DOC CALL SEM_SP_MCO001_UPD_CHECK_DOC
							Mco001UpdateCheckDocSP criteria = new Mco001UpdateCheckDocSP();
							criteria.setSiteInfoId(semmco001Bean.getSiteInfoParam());
							criteria.setCurrentUser(semmco001Bean.getUserLogin());
							to = service.querySPList(EQueryName.SP_MCO001_UPD_CHECK_DOC.name, criteria);
							if(to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")){
//								log.debug("update check doc result [" + to.get(0).getResultMsg());
							}
						}
					}catch(Exception e){
						e.printStackTrace();
						log.debug("ERROR SEMMCO001Action createContractCheckDoc "+e);
					}
				}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco001Bean(semmco001Bean);
		
	}


	private void getContractByRowId() {
		semmco001Bean = getSemmco001Bean();
		try{
			ISiteContractService service = (ISiteContractService)getBean("siteContractService");
			Contract contract = service.queryContractByRowId(semmco001Bean.getContractIdParam());
			if(contract != null){
				semmco001Bean.setSiteInfoParam(contract.getSiteInfoId());
				semmco001Bean.setContractNoParam(contract.getContractNo());
//				if(contract.getEffectiveDt() != null) semmco001Bean.setEffDateParam(convertYearENtoTH(contract.getEffectiveDt()));
//				if(contract.getExpireDt() != null) semmco001Bean.setExpDateParam(convertYearENtoTH(contract.getExpireDt()));
				if(contract.getEffectiveDt() != null) semmco001Bean.setEffDateParam(contract.getEffectiveDt());
				if(contract.getExpireDt() != null) semmco001Bean.setExpDateParam(contract.getExpireDt());
				if(contract.getEffectiveDt() != null) semmco001Bean.setEffDateParamStr(convertYearENtoTHStr(contract.getEffectiveDt()));
				if(contract.getExpireDt() != null) semmco001Bean.setExpDateParamStr(convertYearENtoTHStr(contract.getExpireDt()));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco001Bean(semmco001Bean);
	}


	private boolean doSearch() {
		boolean flag = false;
		semmco001Bean = getSemmco001Bean();
		
		if(semmco001Bean.getCriteriaSP().getStrParam() == null){
		// incase search from To Do List
			
			if(!validate()){
				semmco001Bean.setRenderedMsgFormSearch(true);
				return flag;
			}
		}
			
		try{
			ISiteContractService service = (ISiteContractService)getBean("siteContractService");
			List<Mco001SrchSP> to = null;
			semmco001Bean.getCriteriaSP().setCurrentFlag(semmco001Bean.getCriteriaSP().isCurrentFlagBoolean()?"N":"Y");
			if(semmco001Bean.isChkNoExpireFlag()){
				semmco001Bean.getCriteriaSP().setNoExpireFlag("Y");
			}else{
				semmco001Bean.getCriteriaSP().setNoExpireFlag(null);
			}
			to = service.querySPList(EQueryName.SP_MCO001_SRCH.name, semmco001Bean.getCriteriaSP());
			if(to == null ||  to.size() == 0){
//				addMessageError("M0004");	
				semmco001Bean.setRenderedMsgDataNotFound(true);
				semmco001Bean.setContractSPList(null);
			}
			
			if(to != null && to.size() > 0){
				semmco001Bean.setRenderedMsgDataNotFound(false);
				semmco001Bean.setContractSPList(new ArrayList<WrapperBeanObject<Mco001SrchSP>>());
				for (int i = 0; i < to.size(); i++) {
					Mco001SrchSP contract = (Mco001SrchSP)to.get(i);
					if(contract != null){
						WrapperBeanObject<Mco001SrchSP> tmpWrapperBean = new WrapperBeanObject<Mco001SrchSP>();
//						if(contract.getEffDate() != null) contract.setEffDate(convertYearENtoTH(contract.getEffDate()));
//						if(contract.getExpDate() != null) contract.setExpDate(convertYearENtoTH(contract.getExpDate()));
//						if(contract.getOutDate() != null) contract.setOutDate(convertYearENtoTH(contract.getOutDate()));
						if(contract.getEffDate() != null) contract.setEffDateStr(convertYearENtoTHStr(contract.getEffDate()));
						if(contract.getExpDate() != null) contract.setExpDateStr(convertYearENtoTHStr(contract.getExpDate()));
						if(contract.getOutDate() != null) contract.setOutDateStr(convertYearENtoTHStr(contract.getOutDate()));
						tmpWrapperBean.setDataObj(contract);
						tmpWrapperBean.setMessage("");
						tmpWrapperBean.setCheckBox(false);
//						log.debug("contract getDocApproveId : "+contract.getDocApproveId());
//						log.debug("contract getSiteAppId : "+contract.getSiteAppId());
						semmco001Bean.getContractSPList().add(tmpWrapperBean);
					}
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		this.checkScreenName();
		setSemmco001Bean(semmco001Bean);
		return flag;
	}
	
	
	public void onRenderButton() {
		semmco001Bean = getSemmco001Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		semmco001Bean.setTmpRowId(rowId);
		
		if (isCheckSELBox()) {
			semmco001Bean.setDisabledBtnPrint(false);
			semmco001Bean.setDisabledBtnExport(false);
		} else {
			semmco001Bean.setDisabledBtnPrint(true);
			semmco001Bean.setDisabledBtnExport(true);
		}
		setSemmco001Bean(semmco001Bean);
		
	}
	
	private boolean isCheckSELBox() {
		boolean isCheck = false;
		
		List<WrapperBeanObject<Mco001SrchSP>> contractList = getSemmco001Bean().getContractSPList();
		for (WrapperBeanObject<Mco001SrchSP> wrapperBeanObject : contractList) {
			if (wrapperBeanObject.isCheckBox()) {
				return true;
			}
		}
		
		return isCheck;
	}
	
	public boolean setTabNo(){
		boolean flag = false;
		semmco001Bean = getSemmco001Bean();
		String tabNo = (String)getFacesUtils().getRequestParameter("tabNo");
		semmco001Bean.setTabNo(tabNo);
		
		try {
			if(tabNo.equals("1")){
				semmco001Bean.setTabHeader(msg("message.tab.contract"));
				semmco001Bean.setRenderBtnSave(true);
				semmco001Bean.setRenderedAttachment(false);
				getSemmco001tab1Action().initTab1(semmco001Bean.getSiteInfoParam());
			}else if(tabNo.equals("2")){
				semmco001Bean.setTabHeader(msg("message.tab.contractFile"));
				semmco001Bean.setRenderBtnSave(false);
				semmco001Bean.setRenderedAttachment(true);
				getSemmco001tab2Action().initTab2();
				queryAttachmentByRefID(semmco001Bean.getContractIdParam());
			}else{
				semmco001Bean.setTabHeader(msg("message.tab.contractDoc"));
				semmco001Bean.setRenderBtnSave(true);
				semmco001Bean.setRenderedAttachment(false);
				getSemmco001tab3Action().initTab3();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmco001Bean(semmco001Bean);
		
		return flag;
	}
	
	@Override
	public boolean validate() {
		boolean flgValid = true;
		if(StringUtils.isEmpty(getSemmco001Bean().getCriteriaSP().getDocNo()) 
			&& StringUtils.isEmpty(getSemmco001Bean().getCriteriaSP().getContractNo())
			&& StringUtils.isEmpty(getSemmco001Bean().getCriteriaSP().getLocationId())
			&& StringUtils.isEmpty(getSemmco001Bean().getCriteriaSP().getSiteName())){
			if(StringUtils.isEmpty(getSemmco001Bean().getCriteriaSP().getCompany())){
				addMessageError("W0001", msg("message.company"));
				flgValid = false;
			}
			
		}
		Date effDateFrom = getSemmco001Bean().getCriteriaSP().getEffDateFrom();
		Date effDateTo = getSemmco001Bean().getCriteriaSP().getEffDateTo();
		Date expDateFrom = getSemmco001Bean().getCriteriaSP().getExpDateFrom();
		Date expDateTo = getSemmco001Bean().getCriteriaSP().getExpDateTo();
		if(effDateFrom != null && effDateTo != null){
			if (effDateFrom.after(effDateTo)) {
				addMessageErrorWithArgument("W0006" ,msg("message.effDateBegin"), msg("message.effDateEnd"));
				flgValid = false;
			}
		}
		if(expDateFrom != null && expDateTo != null){
			if (expDateFrom.after(expDateTo)) {
				addMessageErrorWithArgument("W0006" ,msg("message.expDateBegin"), msg("message.expDateEnd"));
				flgValid = false;
			}
		}
		return flgValid;
	}
	
	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void init() {
		SEMMCO001Bean semmco001Bean = new SEMMCO001Bean();
		semmco001Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmco001Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
		semmco001Bean.setReqTypeList(getLovItemsByType(ELovType.T_SI_APPROVE_TYPE.name, EX_AND, null, null, ELovVal.V_CO_CONTRACT.name));
		semmco001Bean.setContractStatusList(getEmptyDropDown());
		semmco001Bean.setDutyPayStatusList(getLovItemsByType(ELovType.T_CO_DUTY_PAY_STATUS.name));
		semmco001Bean.setTotSendStatusList(getLovItemsByType(ELovType.T_CO_TOT_SEND_STATUS.name));
		semmco001Bean.setCheckDocStatusList(getLovItemsByType(ELovType.T_CO_CHECK_DOC_STATUS.name));
		semmco001Bean.setCriteriaSP(new Mco001SrchSP());
		semmco001Bean.getCriteriaSP().setCurrentFlag("Y");
		semmco001Bean.getCriteriaSP().setCurrentFlagBoolean(false);
		semmco001Bean.setContractSPList(new ArrayList<WrapperBeanObject<Mco001SrchSP>>());
		semmco001Bean.setDisabledBtnPrint(true);
		semmco001Bean.setDisabledBtnExport(true);
		semmco001Bean.setRenderedMsgFormSearch(true);
		semmco001Bean.setRenderedAttachment(false);
		semmco001Bean.setRenderedColDel(true);
		semmco001Bean.setRenderedTab2(true);
		semmco001Bean.setRenderedDataTab1(true);
		semmco001Bean.setTreeUtilBean(new TreeUtilBean());
		semmco001Bean.setTodoReqTypeList(getLovItemsByType(ELovType.T_SI_TODO_MENU_REQ_TYPE.name));
		UserSession userSession = (UserSession)FacesUtils.getInstance().getSessionMapValue("userSession");
		setSemmco001Bean(semmco001Bean);
		if(userSession != null){
			semmco001Bean.setScreenName(userSession.getScreenName());
			this.checkScreenName();
		}
		
//		this.getContractStatusListByRole();
		getSemmco001tab1Action().init();
		getSemmco001tab2Action().init();
		getSemmco001tab3Action().init();
		
		PopupUploadFilePictureBean uploadBean = new PopupUploadFilePictureBean();
		uploadBean.setModuleList(new ArrayList<SelectItem>());
		uploadBean.setSubModuleList(new ArrayList<SelectItem>());
		setPopupUploadFilePictureBean(uploadBean);
	}
	
	public void checkScreenName() {
		semmco001Bean = getSemmco001Bean();
		if(!semmco001Bean.getScreenName().equals("") 
		  && semmco001Bean.getScreenName().equals("LEGAL")){
			// show data table legal
			semmco001Bean.setRenderedLegal(true);
			// hide data table contract
			semmco001Bean.setRenderedContract(false);
			// hide tab2
			semmco001Bean.setRenderedTab2(false);
			// hide right address and contract in tab1
			semmco001Bean.setRenderedDataTab1(false);
			// hide button save
			semmco001Bean.setRenderBtnSave(false);
		}else{
			semmco001Bean.setRenderedLegal(false);
			semmco001Bean.setRenderedContract(true);
			semmco001Bean.setRenderedTab2(true);
			semmco001Bean.setRenderedDataTab1(true);
			semmco001Bean.setRenderBtnSave(true);
		}
		setSemmco001Bean(semmco001Bean);
	}


	public void selectAllRow(){
		semmco001Bean = getSemmco001Bean();
		try{
			boolean chkAll = getSemmco001Bean().isChkSelAll();
			List<WrapperBeanObject<Mco001SrchSP>> contractList = new ArrayList<WrapperBeanObject<Mco001SrchSP>>();
			contractList = getSemmco001Bean().getContractSPList();
			for(int i = 0; i < contractList.size(); i++) {
				Mco001SrchSP o = (Mco001SrchSP)contractList.get(i).getDataObj();
				if (StringUtils.isNotEmpty(o.getRowId())) {
					contractList.get(i).setCheckBox(chkAll);
				}
			}
			onRenderButton();
			
		}catch(NullPointerException ne){
			// TODO
			
		}catch(Exception e){
			//TODO
		}
		setSemmco001Bean(semmco001Bean);
	}
	
//	private void getContractStatusListByRole() {
//		semmco001Bean = getSemmco001Bean();
//		if(semmco001Bean.getScreenName() != null && semmco001Bean.getScreenName().equals(ELovVal.V_CO_ROLE.name)){
//			semmco001Bean.setContractStatusList(getLovItemsByType(ELovType.T_CO_CONTRACT_STATUS.name,EX_IN, ELovVal.V_CO_LEGAL.name, null, null));
//		}else{
//			semmco001Bean.setContractStatusList(getLovItemsByType(ELovType.T_CO_CONTRACT_STATUS.name));
//		}
//		setSemmco001Bean(semmco001Bean);
//		
//	}

	public boolean doCreateAttachment() {
		log.info("-- doCreateAttachment --");
		boolean flag = false;

		String refId = (String)getFacesUtils().getRequestParameter("refId");
		log.info("refId :" + refId);
		
		String filename = getFileUploadBean().getFileName();
    	String filePath = getFileUploadBean().getPathName();
    	
    	try {
        	
        	IAttachmentService atchService = (IAttachmentService)FacesUtils.getInstance().getBean("attachmentService");
        	Attachment attachment = new Attachment();
        	attachment.setAttachmentModule("CO");
        	attachment.setFileName(filename);
        	attachment.setRefferenceId(refId);
        	attachment.setAttachmentPath(filePath);
        	attachment.setCurrentUser(getSemmco001Bean().getUserLogin());
			atchService.createAttachment(attachment);
			
			queryAttachmentByRefID(refId);
			disabledUpload(refId);
			
			addMessageInfo("incContent:frmFileUpload:txtFileUpload", "M0001" , "");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				//remove file uploaded.
				FileUtil.getInstance().removeFile(filePath);
				addMessageError("incContent:frmFileUpload:txtFileUpload", "File upload failed with I/O error." ,"");
			} catch (IOException e1) {
				e1.printStackTrace();
				 //show error message.
	        	addMessageError("incContent:frmFileUpload:txtFileUpload", "(remove) File upload failed with I/O error." ,"");
			}
			 //show error message.
        	addMessageError("incContent:frmFileUpload:txtFileUpload", "File upload failed with I/O error.", "");
		} finally{
			getSemmco001Bean().setRenderedMsgFormTop(false);
		}
    	
    	return flag;
    }
	
	private void queryAttachmentByRefID(String refID) throws Exception{
		List<Attachment> attachmentList = new ArrayList<Attachment>();
		IAttachmentService atchService = (IAttachmentService)getBean("attachmentService");
		Attachment attachment = new Attachment();
		String tmpRefID = getSemmco001Bean().getTmpAttachment().getRefferenceId();
		attachment.setRefferenceId(StringUtils.isEmpty(tmpRefID) ? refID : tmpRefID);
		attachmentList = atchService.queryAttachmentByCriteria(attachment);
		getSemmco001Bean().setAttachmentList(attachmentList);
		getSemmco001Bean().setTmpAttachment(null);
	}
	
	public void doDownload(){
		try {
			String fileName = (String)getFacesUtils().getRequestParameter("fileName");
			String pathName = (String)getFacesUtils().getRequestParameter("pathName");
			String type = FileNameUtil.getInstance().GetFileExt(fileName);
			
			log.info("fileName =" + fileName);
			log.info("pathName =" + pathName);
			log.info("type =" + type);
			//String fName = attachment.getFileRealName();
			//String fullPath = this.pathFile + RsaUtil.encrypt("0", attachment.getFileName());
			
			FileUtil fileUtil = new FileUtil();
			fileUtil.getFile(pathName +"/" + fileName, fileName, type);

		} catch (Exception e) {
			log.error(e, e.getCause());
			addMessageError("E0004");
		}
	}
	
	private void disabledUpload(String rowId){
		if(StringUtils.isNotEmpty(rowId)){
			getSemmco001Bean().setDisabledUpload(false);
		}else{
			getSemmco001Bean().setDisabledUpload(true);
		}
	}
	
	public boolean initDelAttachment(){
		boolean flag = false;
		IAttachmentService atchService = (IAttachmentService)getBean("attachmentService");
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		SEMMCO001Bean semmco001Bean = getSemmco001Bean();
		try {
			Attachment attachment = atchService.getAttachmentByRowId(rowId);
			attachment.setCurrentUser(semmco001Bean.getUserLogin());
			semmco001Bean.setTmpAttachment(attachment);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmco001Bean(semmco001Bean);
		return flag;
	}
	
	private boolean doDelAttachment() {
		boolean flag = false;
		IAttachmentService atchService = (IAttachmentService)getBean("attachmentService");
		semmco001Bean = getSemmco001Bean();
		try {
			atchService.deleteAttachmentRecord(semmco001Bean.getTmpAttachment());
			//addMessageInfo("incContent:frmUploadFile:txtFileUpload", "M0002" , "");
			addMessageInfo("M0002");
			
		} catch (Exception e) {
			e.printStackTrace();
			//addMessageError("incContent:frmUploadFile:txtFileUpload", "E0002" , "");
			addMessageError("E0002");
		} finally{
			getSemmco001Bean().setRenderedMsgFormTop(false);
			getSemmco001Bean().setRenderedMsgFormBottom(true);
			//pageLoad();
			String rowId = getSemmco001Bean().getContractIdParam();
			try {
				queryAttachmentByRefID(rowId);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	public void getRowIdOnClick() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemmco001Bean().setTmpRowId(rowId);
	}
	
	public void renderCompany(){
		semmco001Bean = getSemmco001Bean();
		String company = semmco001Bean.getCriteriaSP().getCompany();
		if(company != null && !company.equals("")){
//			if(company.equals(ELovVal.V_CO_AIS.name)){
//				semmco001Bean.setContractStatusList(getLovItemsByType(ELovType.T_CO_CONTRACT_STATUS.name));
//			}else{
//				semmco001Bean.setContractStatusList(getLovItemsByType(ELovType.T_CO_CONTRACT_STATUS.name,EX_IN, ELovVal.V_CO_LEGAL.name, null, null));
//			}
			try {
				semmco001Bean.setContractStatusList(getContractStatusSPList());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			semmco001Bean.setContractStatusList(getEmptyDropDown());
		}
		setSemmco001Bean(semmco001Bean);
	}
	
	private List<SelectItem> getContractStatusSPList() throws Exception{
		IContractCheckDocService service = (IContractCheckDocService)getBean("contractCheckDocService");
		Mco001ContractStatusSP conStatus = new Mco001ContractStatusSP();
		conStatus.setCompany(getSemmco001Bean().getCriteriaSP().getCompany());
		conStatus.setCurrentFlag(semmco001Bean.getCriteriaSP().isCurrentFlagBoolean()?"N":"Y");
		conStatus.setRole(getSemmco001Bean().isRenderedContract()?"CONTRACT":"LEGAL");
		List<Mco001ContractStatusSP> list = service.querySPList(EQueryName.SP_MCO001_SRCH_DDL_STATUS.name, conStatus);
		List<SelectItem> items = new ArrayList<SelectItem>();
		items.add(new SelectItem(null, "-- Select --"));
		for(Mco001ContractStatusSP con : list){
			items.add(new SelectItem(con.getLovCode(), con.getLovName()));
		}
		return items;
	}

	private SEMMCO001Bean semmco001Bean;
	
	public SEMMCO001Bean getSemmco001Bean() {
		return (SEMMCO001Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmco001Bean");
	}
	
	public void setSemmco001Bean(SEMMCO001Bean semmco001Bean) {
		this.semmco001Bean = semmco001Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmco001Bean", this.semmco001Bean);
	}
	
	private SEMMCO001Tab1Action semmco001tab1Action;

	public SEMMCO001Tab1Action getSemmco001tab1Action() {
		if(semmco001tab1Action == null){
			semmco001tab1Action = new SEMMCO001Tab1Action();
		}
		return semmco001tab1Action;
	}

	public void setSemmco001tab1Action(SEMMCO001Tab1Action semmco001tab1Action) {
		this.semmco001tab1Action = semmco001tab1Action;
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
	
	private SEMMCO001Tab2Action semmco001tab2Action;

	public SEMMCO001Tab2Action getSemmco001tab2Action() {
		if(semmco001tab2Action == null){
			semmco001tab2Action = new SEMMCO001Tab2Action();
		}
		return semmco001tab2Action;
	}

	public void setSemmco001tab2Action(SEMMCO001Tab2Action semmco001tab2Action) {
		this.semmco001tab2Action = semmco001tab2Action;
	}

	private SEMMCO001Tab3Action semmco001tab3Action;

	public SEMMCO001Tab3Action getSemmco001tab3Action() {
		if(semmco001tab3Action == null){
			semmco001tab3Action = new SEMMCO001Tab3Action();
		}
		return semmco001tab3Action;
	}

	public void setSemmco001tab3Action(SEMMCO001Tab3Action semmco001tab3Action) {
		this.semmco001tab3Action = semmco001tab3Action;
	}
	
	
	private SEMMSI004Action semmsi004Action;
	
	public SEMMSI004Action getSemmsi004Action() {
		if(semmsi004Action == null){
			semmsi004Action = new SEMMSI004Action();
		}
		return semmsi004Action;
	}

	public void setSemmsi004Action(SEMMSI004Action semmsi004Action) {
		this.semmsi004Action = semmsi004Action;
	}
	
	private SEMMSI004Bean semmsi004Bean;
	
	public SEMMSI004Bean getSemmsi004Bean() {
		return (SEMMSI004Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi004Bean");
	}
	
	public void setSemmsi004Bean(SEMMSI004Bean semmsi004Bean) {
		this.semmsi004Bean = semmsi004Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi004Bean", this.semmsi004Bean);
	}

	private FileUploadBean fileUploadBean;
	
	public FileUploadBean getFileUploadBean() {
		return (FileUploadBean)getFacesUtils().getSessionMapValue("fileUploadBean");
	}
	
	public void setFileUploadBean(FileUploadBean fileUploadBean) {
		getFacesUtils().setSessionMapValue("fileUploadBean", fileUploadBean);
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
	
	public void doExportExcel() {
		try {
			/***********************************************/
			short line = 0;
			Collection<Mco001SrchSP> exList = new ArrayList<Mco001SrchSP>();
			//PDocumentManager export to excel
			DocumentExportManager<Mco001SrchSP> docManager =
				new DocumentExportManager<Mco001SrchSP>(Mco001SrchSP.class, EnumDocumentType.XLS);
			// set current configuration of work book.	
				docManager.setRowStart(line);
		   /***********************************************/
				
//			EnumDocStyleDomain headerStyle = new EnumDocStyleDomain(EnumDocStyle.HEADER);
			EnumDocStyleDomain headerStyle = docManager.getStyle("rt003FieldHeader");
			RowDomain row0 = new RowDomain(0,true);
			row0.setCell(new CellDomain(0, null, String.class, headerStyle, msg("export.col.order"),1,1200));
			row0.setCell(new CellDomain(1, null, String.class, headerStyle, msg("export.column.company"),1,1200));
			row0.setCell(new CellDomain(2, null, String.class, headerStyle, msg("export.column.region"),1,1300));
			row0.setCell(new CellDomain(3, null, String.class, headerStyle, msg("export.column.reqTypeName"),1,4300));
			row0.setCell(new CellDomain(4, null, String.class, headerStyle, msg("export.col.docNo"),1,3000));
			row0.setCell(new CellDomain(5, null, String.class, headerStyle, msg("export.col.contractNo"),1,2900));
			row0.setCell(new CellDomain(6, null, String.class, headerStyle, msg("export.col.locatioName"),1,5200));
			row0.setCell(new CellDomain(7,8, null, String.class, headerStyle, msg("export.col.outDt"),-1,5000));
			row0.setCell(new CellDomain(8, null, String.class, headerStyle, " ",-1,2500));
			row0.setCell(new CellDomain(9,10, null, String.class, headerStyle, msg("export.col.checkDocStatus01"),-1,5000));
			row0.setCell(new CellDomain(10, null, String.class, headerStyle, " ",-1,2500));
			row0.setCell(new CellDomain(11,12, null, String.class, headerStyle, msg("export.col.checkDocStatus02"),-1,6000));
			row0.setCell(new CellDomain(12, null, String.class, headerStyle, " ",-1,3000));
			
			
			RowDomain row1 = new RowDomain(1,true);	
			row1.setCell(new CellDomain(0, null, String.class, headerStyle," ",-1,1200));
			row1.setCell(new CellDomain(1, null, String.class, headerStyle," ",-1,1200));
			row1.setCell(new CellDomain(2, null, String.class, headerStyle," ",-1,1300));
			row1.setCell(new CellDomain(3, null, String.class, headerStyle," ",-1,4300));
			row1.setCell(new CellDomain(4, null, String.class, headerStyle," ",-1,3000));
			row1.setCell(new CellDomain(5, null, String.class, headerStyle," ",-1,2900));
			row1.setCell(new CellDomain(6, null, String.class, headerStyle," ",-1,5200));
			row1.setCell(new CellDomain(7, null, String.class, headerStyle, msg("export.col.date"),-1,2500));
			row1.setCell(new CellDomain(8, null, String.class, headerStyle, msg("export.col.recipients"),-1,3000));
			row1.setCell(new CellDomain(9, null, String.class, headerStyle, msg("export.col.date"),-1,2500));
			row1.setCell(new CellDomain(10, null, String.class, headerStyle, msg("export.col.recipients"),-1,3000));
			row1.setCell(new CellDomain(11, null, String.class, headerStyle, msg("export.col.date"),-1,3000));
			row1.setCell(new CellDomain(12, null, String.class, headerStyle, msg("export.col.recipients"),-1,3000));
			
			List<WrapperBeanObject<Mco001SrchSP>> contractList = new ArrayList<WrapperBeanObject<Mco001SrchSP>>();
			contractList = getSemmco001Bean().getContractSPList();
			
				int no = 0;
				if(contractList != null && contractList.size() > 0){
					for(int i=0; i<contractList.size(); i++){
						WrapperBeanObject<Mco001SrchSP> detail = new WrapperBeanObject<Mco001SrchSP>();
						detail = contractList.get(i);
						if(detail.isCheckBox()){
							 ++no;
							((Mco001SrchSP)detail.getDataObj()).setNo(no);
							exList.add((Mco001SrchSP)detail.getDataObj());
						}
					}
					docManager.putDetailRow(row0);
					docManager.putDetailRow(row1);
					docManager.seteObjectList(exList);
					docManager.setModule("CONTRACT_LEGAL_");
					docManager.setPrintPageLandScape(true);
					docManager.setMargin(0.05, 0.05, 0.5, 0.05);
					docManager.getObjectFromDocument();
					docManager.exportServletFile();
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void doExportExcelContract() {
		try {
			/*************************ADD BY NOOM 15/03/2013**********************/
			short line = 0;
//			Collection<Mco001SrchSP> exList = new ArrayList<Mco001SrchSP>();
			Collection<Mco001Exp> exList = new ArrayList<Mco001Exp>();
			//PDocumentManager export to excel
			DocumentExportManager<Mco001Exp> docManager =
				new DocumentExportManager<Mco001Exp>(Mco001Exp.class, EnumDocumentType.XLS);
			// set current configuration of work book.	
				docManager.setRowStart(line);
		   /***********************************************/
				
//			EnumDocStyleDomain headerStyle = new EnumDocStyleDomain(EnumDocStyle.HEADER);
			EnumDocStyleDomain headerStyle = docManager.getStyle("rt003FieldHeader");
			RowDomain row0 = new RowDomain(0,true);
			row0.setCell(new CellDomain(0, null, String.class, headerStyle, msg("export.column.reqTypeName"),-1,5300));
			row0.setCell(new CellDomain(1, null, String.class, headerStyle, msg("export.col.docNoCancel"),-1,3000));
			row0.setCell(new CellDomain(2, null, String.class, headerStyle, msg("export.col.locationId"),-1,3000));
			row0.setCell(new CellDomain(3, null, String.class, headerStyle, msg("export.col.contractNo"),-1,3000));
			row0.setCell(new CellDomain(4, null, String.class, headerStyle, msg("export.col.oldNew"),-1,3000));
			row0.setCell(new CellDomain(5, null, String.class, headerStyle, msg("export.col.siteName"),-1,5200));
			row0.setCell(new CellDomain(6, null, String.class, headerStyle, msg("export.col.effDt"),-1,3000));
			row0.setCell(new CellDomain(7, null, String.class, headerStyle, msg("export.col.expireDt"),-1,3000));
			row0.setCell(new CellDomain(8, null, String.class, headerStyle, msg("export.column.dutyAmt"),-1,3000));
			row0.setCell(new CellDomain(9, null, String.class, headerStyle, msg("message.contractStatus"),-1,4300));
			row0.setCell(new CellDomain(10, null, String.class, headerStyle, msg("export.column.borrowStatus"),-1,4300));
			row0.setCell(new CellDomain(11, null, String.class, headerStyle, msg("export.column.receivePersonName"),-1,4300));
			row0.setCell(new CellDomain(12, null, String.class, headerStyle, msg("export.column.createPersonName"),-1,4300));
			row0.setCell(new CellDomain(13, null, String.class, headerStyle, msg("export.column.approvePersonName"),-1,4300));
			row0.setCell(new CellDomain(14, null, String.class, headerStyle, msg("export.col.receiveDt"),-1,3500));
			row0.setCell(new CellDomain(15, null, String.class, headerStyle, msg("export.col.sentLawDt"),-1,3500));
			row0.setCell(new CellDomain(16, null, String.class, headerStyle, msg("export.col.aqmSentDt"),-1,3500));
			row0.setCell(new CellDomain(17, null, String.class, headerStyle, msg("export.col.aqmReceiveDt"),-1,3500));
			row0.setCell(new CellDomain(18, null, String.class, headerStyle, msg("export.col.totSentDt"),-1,3500));
			row0.setCell(new CellDomain(19, null, String.class, headerStyle, msg("export.col.totReceiveDt"),-1,3500));
			row0.setCell(new CellDomain(20, null, String.class, headerStyle, msg("export.col.customerReturnDt"),-1,3500));
			row0.setCell(new CellDomain(21, null, String.class, headerStyle, msg("export.col.portpKeepDt"),-1,3500));
			row0.setCell(new CellDomain(22, null, String.class, headerStyle, msg("export.col.cancelDt"),-1,3500));
			row0.setCell(new CellDomain(23, null, String.class, headerStyle, msg("export.col.remarkTh"),-1,3500));
			row0.setCell(new CellDomain(24, null, String.class, headerStyle, msg("export.col.siteStatus"),-1,3500));
			row0.setCell(new CellDomain(25, null, String.class, headerStyle, msg("export.col.flowStatus"),-1,3500));
			
			
			
			List<WrapperBeanObject<Mco001SrchSP>> contractList = new ArrayList<WrapperBeanObject<Mco001SrchSP>>();
			contractList = getSemmco001Bean().getContractSPList();
			
				if(contractList != null && contractList.size() > 0){
					for(int i=0; i<contractList.size(); i++){
						WrapperBeanObject<Mco001SrchSP> detail = new WrapperBeanObject<Mco001SrchSP>();
						WrapperBeanObject<Mco001Exp> detailExp = new WrapperBeanObject<Mco001Exp>();
						detail = contractList.get(i);
						if(detail.isCheckBox()){
							detailExp.setDataObj(new Mco001Exp());
							((Mco001Exp)detailExp.getDataObj()).setReqTypeName2(((Mco001SrchSP)detail.getDataObj()).getReqTypeName2());
							((Mco001Exp)detailExp.getDataObj()).setDocNo(((Mco001SrchSP)detail.getDataObj()).getDocNo());
							((Mco001Exp)detailExp.getDataObj()).setLocationId(((Mco001SrchSP)detail.getDataObj()).getLocationId());
							((Mco001Exp)detailExp.getDataObj()).setContractNo(((Mco001SrchSP)detail.getDataObj()).getContractNo());
							((Mco001Exp)detailExp.getDataObj()).setOldContractNo(((Mco001SrchSP)detail.getDataObj()).getOldContractNo());
							((Mco001Exp)detailExp.getDataObj()).setSiteName(((Mco001SrchSP)detail.getDataObj()).getSiteName());
							if(((Mco001SrchSP)detail.getDataObj()).getExpDate() != null){
							((Mco001Exp)detailExp.getDataObj()).setEffDate(SEMDataUtility.convertToThYear(((Mco001SrchSP)detail.getDataObj()).getEffDate()));
							}
							
							if(((Mco001SrchSP)detail.getDataObj()).getExpDate() != null){
							((Mco001Exp)detailExp.getDataObj()).setExpDate(SEMDataUtility.convertToThYear(((Mco001SrchSP)detail.getDataObj()).getExpDate()));
							}
							((Mco001Exp)detailExp.getDataObj()).setDutyAmt(((Mco001SrchSP)detail.getDataObj()).getDutyAmt());
							((Mco001Exp)detailExp.getDataObj()).setContractStatusName(((Mco001SrchSP)detail.getDataObj()).getContractStatusName());
							((Mco001Exp)detailExp.getDataObj()).setBorrowStatus(((Mco001SrchSP)detail.getDataObj()).getBorrowStatus());
							((Mco001Exp)detailExp.getDataObj()).setReceivePerson(((Mco001SrchSP)detail.getDataObj()).getReceivePerson());
							((Mco001Exp)detailExp.getDataObj()).setCreatePersonName(((Mco001SrchSP)detail.getDataObj()).getCreatePersonName());
							((Mco001Exp)detailExp.getDataObj()).setSiteApprovePersonName(((Mco001SrchSP)detail.getDataObj()).getSiteApprovePersonName());
							if(((Mco001SrchSP)detail.getDataObj()).getD1() != null)((Mco001Exp)detailExp.getDataObj()).setD1(SEMDataUtility.convertToThYear(((Mco001SrchSP)detail.getDataObj()).getD1()));
							if(((Mco001SrchSP)detail.getDataObj()).getD2() != null)((Mco001Exp)detailExp.getDataObj()).setD2(SEMDataUtility.convertToThYear(((Mco001SrchSP)detail.getDataObj()).getD2()));
							if(((Mco001SrchSP)detail.getDataObj()).getD9() != null)((Mco001Exp)detailExp.getDataObj()).setD9(SEMDataUtility.convertToThYear(((Mco001SrchSP)detail.getDataObj()).getD9()));
							if(((Mco001SrchSP)detail.getDataObj()).getD3() != null)((Mco001Exp)detailExp.getDataObj()).setD3(SEMDataUtility.convertToThYear(((Mco001SrchSP)detail.getDataObj()).getD3()));
							if(((Mco001SrchSP)detail.getDataObj()).getD4() != null)((Mco001Exp)detailExp.getDataObj()).setD4(SEMDataUtility.convertToThYear(((Mco001SrchSP)detail.getDataObj()).getD4()));
							if(((Mco001SrchSP)detail.getDataObj()).getD5() != null)((Mco001Exp)detailExp.getDataObj()).setD5(SEMDataUtility.convertToThYear(((Mco001SrchSP)detail.getDataObj()).getD5()));
							if(((Mco001SrchSP)detail.getDataObj()).getD6() != null)((Mco001Exp)detailExp.getDataObj()).setD6(SEMDataUtility.convertToThYear(((Mco001SrchSP)detail.getDataObj()).getD6()));
							if(((Mco001SrchSP)detail.getDataObj()).getD7() != null)((Mco001Exp)detailExp.getDataObj()).setD7(SEMDataUtility.convertToThYear(((Mco001SrchSP)detail.getDataObj()).getD7()));
							if(((Mco001SrchSP)detail.getDataObj()).getD8() != null)((Mco001Exp)detailExp.getDataObj()).setD8(SEMDataUtility.convertToThYear(((Mco001SrchSP)detail.getDataObj()).getD8()));
							
							((Mco001Exp)detailExp.getDataObj()).setRemark(((Mco001SrchSP)detail.getDataObj()).getRemark());
							((Mco001Exp)detailExp.getDataObj()).setSiteStatusName(((Mco001SrchSP)detail.getDataObj()).getSiteStatusName());
							((Mco001Exp)detailExp.getDataObj()).setFlowStatus(((Mco001SrchSP)detail.getDataObj()).getFlowStatus());
							
							exList.add((Mco001Exp)detailExp.getDataObj());
						}
					}
					docManager.putDetailRow(row0);
					docManager.seteObjectList(exList);
					docManager.setModule("CONTRACT_REPORT");
					docManager.setPrintPageLandScape(true);
					docManager.setMargin(0.05, 0.05, 0.5, 0.05);
					docManager.getObjectFromDocument();
					docManager.exportServletFile();
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	// added by.. YUT
	public boolean doInitialForSearchContract() {
		log.info("::: SEMMCO001Action :: doInitialForSearchContract >> BEGIN :::");
		boolean flag = true;

		try {

			semmco001Bean = getSemmco001Bean();

			String paramUrl = getFacesUtils().getRequestParameter("paramUrl") == null ? "" : (String) getFacesUtils().getRequestParameter("paramUrl");
	        String paramMenuGroup = getFacesUtils().getRequestParameter("paramMenuGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuGroup");
	        String paramMenuSubGroup = getFacesUtils().getRequestParameter("paramMenuSubGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuSubGroup");
	        String paramParameter = getFacesUtils().getRequestParameter("paramParameter") == null ? "" : (String) getFacesUtils().getRequestParameter("paramParameter");
	        
	        System.out.println("paramUrl: " + paramUrl);
	        System.out.println("paramMenuGroup: " + paramMenuGroup);
	        System.out.println("paramMenuSubGroup: " + paramMenuSubGroup);
	        System.out.println("paramParameter: " + paramParameter);
	        
	        semmco001Bean.getCriteriaSP().setStrParam(paramParameter);
	        semmco001Bean.setRenderedOnToDoList(true); //

			setSemmco001Bean(semmco001Bean);
			
			this.doSearch();

		} catch(Exception e) {
			e.printStackTrace();
			addMessageError("EL0000", "SEMMCO001Action");
			flag = false;
			
		} finally {
			log.info("::: SEMMCO001Action :: doInitialForSearchContract >> END :::");
		}
		return flag;
	}
	
	public boolean doInitTodoList(){
		boolean flag = true;
		try{
			semmco001Bean = getSemmco001Bean();
			loadTree();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			flag = false;
		}finally{
			//setSemmco001Bean(semmco001Bean);
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
    	semmco001Bean = getSemmco001Bean();
    	
    	semmco001Bean.setTreeMacroFlag(false);
    	semmco001Bean.setTreePicoFlag(false);
    	TreeUtilBean myParam = new TreeUtilBean();
    	List<Object> mySendList = new ArrayList<Object>();
    	String searchFlag = getFacesUtils().getRequestParameter("searchFlag") == null ? "" : (String) getFacesUtils().getRequestParameter("searchFlag");
    	IMenuTreeService service = (IMenuTreeService)getBean("menuTreeService");
    	String backWard;
    	backWard = getFacesUtils().getRequestParameter("backWard") == null ? "" : (String) getFacesUtils().getRequestParameter("backWard");
    	
    	String groupType = "CO";
    	String reqTypeName = "";
        try {
        	
        	if("Y".equals(searchFlag)){
        		List<MenuTreeSP> menuTreeList = null;
        		semmco001Bean.getTreeUtilBean().setMenuGroup(groupType);
        		semmco001Bean.getTreeUtilBean().setUserLogin(getUserLogIn());
        		if(!semmco001Bean.getTreeUtilBean().getCompany().equals("") && !semmco001Bean.getTreeUtilBean().getRegion().equals("")){
        			if(!semmco001Bean.getTreeUtilBean().getMenuSubGroup().equals("")){
            			menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name, semmco001Bean.getTreeUtilBean());
            			
        				Map<String, Object> myMap = new HashMap<String, Object>();
        				
        				if(menuTreeList != null && !menuTreeList.isEmpty()){
        					
        					for(SelectItem item : semmco001Bean.getTodoReqTypeList()){
        						if(StringUtils.equals(semmco001Bean.getTreeUtilBean().getMenuSubGroup(), item.getValue().toString())){
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
//            			for(int i = 0;i<2;i++){
            			for(int i = 1;i<semmco001Bean.getTodoReqTypeList().size();i++){
//        					if(i==0){
//        						semmco001Bean.getTreeUtilBean().setMenuSubGroup("M");
//        					}
            				if(semmco001Bean.getTodoReqTypeList().get(i) != null){
            					SelectItem item = semmco001Bean.getTodoReqTypeList().get(i);
            					semmco001Bean.getTreeUtilBean().setMenuSubGroup(item.getValue().toString());
            				}
            			
    	        			menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name, semmco001Bean.getTreeUtilBean());
    	        			
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
    	    				semmco001Bean.getTreeUtilBean().setMenuSubGroup("P");
    	        		}
            			semmco001Bean.getTreeUtilBean().setMenuSubGroup("");
            		}
        		}else{
        			validateToDoList();
        		}
        	}else{
        		if("Y".equals(backWard)){
            		List<MenuTreeSP> menuTreeList = null;
            		semmco001Bean.getTreeUtilBean().setMenuGroup(groupType);
            		semmco001Bean.getTreeUtilBean().setUserLogin(getUserLogIn());
            		if(!semmco001Bean.getTreeUtilBean().getCompany().equals("") && !semmco001Bean.getTreeUtilBean().getRegion().equals("")){
            			if(!semmco001Bean.getTreeUtilBean().getMenuSubGroup().equals("")){
                			menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name, semmco001Bean.getTreeUtilBean());
                			
            				Map<String, Object> myMap = new HashMap<String, Object>();
            				
            				if(menuTreeList != null && !menuTreeList.isEmpty()){
            			
            					for(SelectItem item : semmco001Bean.getTodoReqTypeList()){
            						if(StringUtils.equals(semmco001Bean.getTreeUtilBean().getMenuSubGroup(), item.getValue().toString())){
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
//                			for(int i = 0;i<2;i++){
                			for(int i = 1;i<semmco001Bean.getTodoReqTypeList().size();i++){
//                				if(i==0){
//            						semmco001Bean.getTreeUtilBean().setMenuSubGroup("M");
//            					}
                				if(semmco001Bean.getTodoReqTypeList().get(i) != null){
                					SelectItem item = semmco001Bean.getTodoReqTypeList().get(i);
                					semmco001Bean.getTreeUtilBean().setMenuSubGroup(item.getValue().toString());
                				}
                			
        	        			menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name, semmco001Bean.getTreeUtilBean());
        	        			
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
        	    				semmco001Bean.getTreeUtilBean().setMenuSubGroup("P");
        	        		}
                			semmco001Bean.getTreeUtilBean().setMenuSubGroup("");
                		}
            		}else{
            			validateToDoList();
            		}
        		}else{
        			semmco001Bean.setTreeUtilBean(new TreeUtilBean());
            		setSemmco001Bean(semmco001Bean);	
        		}
        	}
        	semmco001Bean.setHeaderTreeMacro(reqTypeName);
        	
        	semmco001Bean.setRootNode(new TreeNodeImpl());
    		addNodes(semmco001Bean, mySendList);
        	//// <<
    		
        } catch (Exception e) {
            throw new FacesException(e.getMessage(), e);
        } finally {
        	//semmco001Bean = getSemmco001Bean();
        	myParam = null;
        	mySendList = null;
        	searchFlag = null;
        	service = null;
        	backWard = null;
        	
        	groupType = null;
        }
    }
    
    public void validateToDoList(){
    	try{
    		semmco001Bean = getSemmco001Bean();
    		if(semmco001Bean.getTreeUtilBean().getCompany().equals("")){
    			addMessageErrorWithArgument("W0001",msg("message.company"));
    		}
    		if(semmco001Bean.getTreeUtilBean().getRegion().equals("")){
    			addMessageErrorWithArgument("W0001",msg("message.region"));
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
			// TODO: handle exception
		}
    }

    @SuppressWarnings({ "unused", "unchecked" })
	private void addNodes(SEMMCO001Bean semmco001Bean, List<Object> propList) {
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
			String parent1 = mapArr_[i].toString();	// get key by sorting
			
			MenuTreeSP mapObj1 =  (MenuTreeSP) map.get(parent1);
			
			_MENU_LABEL = "";
//		
			
//			if(mapObj1.getMenuSubGroup().equals("M")){
				_MENU_LABEL = "Site Info "+semmco001Bean.getHeaderTreeMacro();
				
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
//	        	}
				
				semmco001Bean.setTreeMacroFlag(true);
				semmco001Bean.setMenuTreeMacroList(menuTreeWrapList);
			}
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
//	    			String myUrl = mapObj.getMenuUrl() == null ? "SEMMCO001-0" : mapObj.getMenuUrl().toString();
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
//				semmco001Bean.setHeaderTreePico(_MENU_LABEL);
//				semmco001Bean.setTreePicoFlag(true);
//				semmco001Bean.setMenuTreePicoList(menuTreeWrapList);
//			}
    		// <<
    		
    		
    	}
    	semmco001Bean.setHeaderTreeMacro(_MENU_LABEL);
    	setSemmco001Bean(semmco001Bean);
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
    	semmco001Bean = getSemmco001Bean();
    	String searchFlag = getFacesUtils().getRequestParameter("searchFlag") == null ? "" : (String)getFacesUtils().getRequestParameter("searchFlag");
        if (semmco001Bean.getRootNode() == null || "Y".equals(searchFlag)) {
            loadTree();
        }
        
        return semmco001Bean.getRootNode();
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
}
