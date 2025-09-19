package th.co.ais.web.si.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.swing.GroupLayout.Alignment;
import javax.swing.text.Position;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFPrintSetup;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.richfaces.component.html.HtmlTree;
import org.richfaces.event.NodeSelectedEvent;
import org.richfaces.model.TreeNode;
import org.richfaces.model.TreeNodeImpl;

import th.co.ais.common.service.IMenuTreeService;
import th.co.ais.domain.common.MenuTreeSP;
import th.co.ais.domain.ir.PolicySP;
import th.co.ais.domain.rt.EMAILModel;
import th.co.ais.domain.rt.MrtGetRunningNo;
import th.co.ais.domain.rt.RentalPayNormalSearchSP;
import th.co.ais.domain.sa.SiteAppSP;
import th.co.ais.domain.sa.SiteContractStatusSP;
import th.co.ais.domain.si.LegalSiteAppSP;
import th.co.ais.domain.si.Msi001ChkDocNo;
import th.co.ais.domain.si.Msi001Del;
import th.co.ais.domain.si.Msi001GenDocNo;
import th.co.ais.domain.si.Msi001Seq;
import th.co.ais.domain.si.Msi001UpdOutDt;
import th.co.ais.domain.si.Msi001UpdRegion;
import th.co.ais.domain.si.Msi001UpdateExport;
import th.co.ais.domain.si.Msi001chkReqTypeDel;
import th.co.ais.domain.si.Psi005Srch;
import th.co.ais.domain.si.SiteApprove;
import th.co.ais.domain.si.SiteApproveDisplaySP;
import th.co.ais.domain.si.SiteApproveMapLoc;
import th.co.ais.domain.si.SiteApproveMapLocSP;
import th.co.ais.domain.si.SiteApproveMapLocSeqSP;
import th.co.ais.domain.si.SiteApproveSP;
import th.co.ais.domain.si.SiteLocationBySiteInfoIdSP;
import th.co.ais.domain.si.SiteLocationSP;
import th.co.ais.rpt.util.bean.CellDomain;
import th.co.ais.rpt.util.bean.EnumDocStyleDomain;
import th.co.ais.rpt.util.bean.RowDomain;
import th.co.ais.rpt.util.enums.EnumDocStyle;
import th.co.ais.rpt.util.enums.EnumDocumentType;
import th.co.ais.service.gm.ILovMasterService;
import th.co.ais.service.rt.IRentalPaymentService;
import th.co.ais.service.sa.ISiteAcquistionService;
import th.co.ais.service.si.ILegalApproveService;
import th.co.ais.service.si.ILegalSiteAppService;
import th.co.ais.service.si.ISiteApproveMapLocService;
import th.co.ais.service.si.ISiteApproveService;
import th.co.ais.service.si.ISiteContractService;
import th.co.ais.util.ELovType;
import th.co.ais.util.ELovVal;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.TreeUtilBean;
import th.co.ais.web.bean.common.PopupSiteContractBean;
import th.co.ais.web.bean.common.PopupSiteLocationBean;
import th.co.ais.web.report.util.DocumentExportManager;
import th.co.ais.web.si.bean.SEMMSI001Bean;
import th.co.ais.web.util.EmailMessageUtil;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.LOVCacheUtil;
import th.co.ais.web.util.MSGCacheUtil;
import th.co.ais.web.util.RegionCacheUtil;
import th.co.ais.web.util.SelectItemLOVCacheUtil;
import th.co.ais.web.util.SemUtils;
import th.co.ais.web.util.ZoneCasheUtil;

public class SEMMSI001Action extends AbstractAction {
	private Logger log = Logger.getLogger(getClass());
	/**
	 * 
	 */
	private static final long serialVersionUID = -5833854159521536218L;
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if (methodWithNavi.equalsIgnoreCase("doSearch")) {
			flag = doSearch();
		} else if (methodWithNavi.equalsIgnoreCase("doClear")) {
			flag = doClear();
		} else if (methodWithNavi.equalsIgnoreCase("initDelete")) {
			flag = initDelete();
		} else if (methodWithNavi.equalsIgnoreCase("doDelete")) {
			flag = doDelete();
		} else if (methodWithNavi.equalsIgnoreCase("pageLoad")) {
			flag = pageLoad();
		} else if (methodWithNavi.equalsIgnoreCase("doSave")) {
			flag = doSave();
		} else if (methodWithNavi.equalsIgnoreCase("doCancel")) {
			flag = doCancel();
		} else if (methodWithNavi.equalsIgnoreCase("doReset")) {
			flag = doReset();
		}else if (methodWithNavi.equalsIgnoreCase("onAddSiteLocation")) {
			flag = onAddSiteLocation();
		} else if (methodWithNavi.equalsIgnoreCase("initDeleteSiteMapLoc")) {
			flag = initDeleteSiteMapLoc();
		} else if (methodWithNavi.equalsIgnoreCase("doDeleteSiteMapLoc")) {
			flag = doDeleteSiteMapLoc();
		} else if (methodWithNavi.equalsIgnoreCase("copyLocation")) {
			flag = copyLocation();
		} else if (methodWithNavi.equalsIgnoreCase("doDefaultDate")) {
			flag = doDefaultDate();
		} else if (methodWithNavi.equalsIgnoreCase("chkReRenderExport")) {
			flag = chkReRenderExport();
		} else if (methodWithNavi.equalsIgnoreCase("doExportExcel")){
			doExportExcel();
		} else if (methodWithNavi.equalsIgnoreCase("doGenDocNo")){
			doGenDocNo();
		} else if (methodWithNavi.equalsIgnoreCase("doInit")){
			flag = doInit();
		}
		
		return flag;
	}
	
	private boolean doInit() {
		log.info("::: SEMMSI001Action :: doInit >> BEGIN :::");
		boolean flag = false;

		//SEMMSI001Bean semmmm001Bean = new SEMMSI001Bean();
		
		try {
			
			init();
			
		} catch(Exception e) {
			e.printStackTrace();
			log.error(e);
			log.debug(e);
			addMessageError("EL0000", "SEMMSI001Action");
			flag = false;
		} finally {
			setSemmsi001Bean(semmsi001Bean);
			log.info("::: SEMMSI001Action :: doInit >> END :::");
		}
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("popupSiteLocationBean");
//		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("popupSiteContractBean");
	}

	@Override
	public void init() {
		SEMMSI001Bean semmsi001Bean = new SEMMSI001Bean();
		semmsi001Bean.setSearchCriteria(new SiteApproveDisplaySP());
		semmsi001Bean.getSearchCriteria().setChkCurrentFlag(false);
		semmsi001Bean.getSearchCriteria().setSiteApproveStatus("00");
		semmsi001Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmsi001Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
		semmsi001Bean.setReqTypeList(LOVCacheUtil.getInstance().getApproveTypeSelList());
		// semmsi001Bean.setSiteApproveStatusList(LOVCacheUtil.getInstance().getSiteApproveStatusSelList());
		semmsi001Bean.setSiteApproveStatusList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(
				ELovType.T_SI_APPROVE_STATUS.name));
		semmsi001Bean.setTxtContent2(MSGCacheUtil.getInstance().getMessageByCode("Q0019"));
		semmsi001Bean.setReqOfficerList(SelectItemLOVCacheUtil.getInstance().getLovItemsValueNameByType(ELovType.T_SI_SITE_APPROVE_FROM.name));
		semmsi001Bean.setDisBtnExport(true);
		semmsi001Bean.setRenderedMsgFormMiddle(false);
		// semmsi001Bean.setRenderedMsgFormSearch(false);
		semmsi001Bean.setZoneList(ZoneCasheUtil.getInstance().getZoneSelList());
		
		//semmsi001Bean.setPanelDisplay("semmlg01"); // landing page for [TO DO LIST]
		
		setSemmsi001Bean(semmsi001Bean);
		
		//SetpopupSiteLocationBean	
		PopupSiteLocationBean popupSiteLocationBean = getPopupSiteLocationBean();
		if(popupSiteLocationBean != null){
			popupSiteLocationBean.setSiteLocationCriteria(new SiteLocationSP());
			popupSiteLocationBean.setSiteLocationList(null);
			popupSiteLocationBean.setRenderPopup(false);
		}
		setPopupSiteLocationBean(popupSiteLocationBean);
		
	}

	@Override
	public boolean validate() {
		boolean flagValid = true;
		if (StringUtils.isEmpty(getSemmsi001Bean().getSiteSP().getDocNo())) {
			addMessageError("W0001", msg("message.docNo"));
			flagValid = false;
		}
		if (getSemmsi001Bean().getSiteSP().getDocDt() == null) {
			addMessageError("W0001", msg("message.docDate"));
			flagValid = false;
		}
		if (StringUtils.isEmpty(getSemmsi001Bean().getSiteSP().getReqOfficer()) && StringUtils.isEmpty(getSemmsi001Bean().getOtherReqOfficer())) {
			addMessageError("W0001", msg("message.reqOfficer"));
			flagValid = false;
		}
		if (StringUtils.isEmpty(getSemmsi001Bean().getSiteSP().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flagValid = false;
		}
		if (StringUtils.isEmpty(getSemmsi001Bean().getSiteSP().getReqDocType())) {
			addMessageError("W0001", msg("message.reqDocType"));
			flagValid = false;
		}
		if (StringUtils.isEmpty(getSemmsi001Bean().getSiteSP().getReqType())) {
			addMessageError("W0001", msg("message.reqType"));
			flagValid = false;
		} else if (!getSemmsi001Bean().getSiteSP().getReqType().equals("01") && !getSemmsi001Bean().getSiteSP().getReqType().equals("07")) {
			if (StringUtils.isEmpty(getPopupSiteContractBean().getContractNo())) {
				addMessageError("W0001", msg("message.contractNo"));
				flagValid = false;
			}
			if (getSemmsi001Bean().getSiteSP().getReqType().equals("98")) {
				if (getSemmsi001Bean().getSiteSP().getInvalidDt() == null) {
					addMessageError("W0001", msg("message.invalidDt"));
					flagValid = false;
				} 
//					else if (getSemmsi001Bean().getSiteSP().getInvalidDt().before(new Date())) {
//					addMessageErrorWithArgument("W0006", msg("message.invalidDt"), msg("message.currentDate"));
//					flagValid = false;
//				}
			}
		}
		if (StringUtils.isEmpty(getSemmsi001Bean().getSiteSP().getTitle())) {
			addMessageError("W0001", msg("message.title"));
			flagValid = false;
		}
		if (getSemmsi001Bean().getSiteSP().getInDt() == null) {
			addMessageError("W0001", msg("message.inDt"));
			flagValid = false;
		} else if (getSemmsi001Bean().getSiteSP().getDocDt() != null) {  
			if (getSemmsi001Bean().getSiteSP().getInDt().before(getSemmsi001Bean().getSiteSP().getDocDt())) {
				addMessageErrorWithArgument("W0006", msg("message.inDt"), msg("message.docDate"));
				flagValid = false;
			}
		}
		if (StringUtils.isEmpty(getSemmsi001Bean().getSiteSP().getSiteApproveStatus())) {
			addMessageError("W0001", msg("message.siteApproveStatus"));
			flagValid = false;
		}
		
		if(checkCompany()){
			flagValid = false;
		}
		
		return flagValid;
	}
	
	public boolean validateCaseAdd() {
		boolean flagValid = true;
		if (getSemmsi001Bean().getSiteSP().getDocDt() == null) {
			addMessageError("W0001", msg("message.docDate"));
			flagValid = false;
		}
		if (StringUtils.isEmpty(getSemmsi001Bean().getSiteSP().getReqOfficer()) && StringUtils.isEmpty(getSemmsi001Bean().getOtherReqOfficer())) {
			addMessageError("W0001", msg("message.reqOfficer"));
			flagValid = false;
		}
		if (StringUtils.isEmpty(getSemmsi001Bean().getSiteSP().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flagValid = false;
		}
		if (StringUtils.isEmpty(getSemmsi001Bean().getSiteSP().getReqDocType())) {
			addMessageError("W0001", msg("message.reqDocType"));
			flagValid = false;
		}
		if (StringUtils.isEmpty(getSemmsi001Bean().getSiteSP().getReqType())) {
			addMessageError("W0001", msg("message.reqType"));
			flagValid = false;
		} else if (!getSemmsi001Bean().getSiteSP().getReqType().equals("01") && !getSemmsi001Bean().getSiteSP().getReqType().equals("07")) {
			if (StringUtils.isEmpty(getPopupSiteContractBean().getContractNo())) {
				addMessageError("W0001", msg("message.contractNo"));
				flagValid = false;
			}
			if (getSemmsi001Bean().getSiteSP().getReqType().equals("98")) {
				if (getSemmsi001Bean().getSiteSP().getInvalidDt() == null) {
					addMessageError("W0001", msg("message.invalidDt"));
					flagValid = false;
				} 
//					else if (getSemmsi001Bean().getSiteSP().getInvalidDt().before(new Date())) {
//					addMessageErrorWithArgument("W0006", msg("message.invalidDt"), msg("message.currentDate"));
//					flagValid = false;
//				}
			}
		}
		if (StringUtils.isEmpty(getSemmsi001Bean().getSiteSP().getTitle())) {
			addMessageError("W0001", msg("message.title"));
			flagValid = false;
		}
		if (getSemmsi001Bean().getSiteSP().getInDt() == null) {
			addMessageError("W0001", msg("message.inDt"));
			flagValid = false;
		} else if (getSemmsi001Bean().getSiteSP().getDocDt() != null) {  
			if (getSemmsi001Bean().getSiteSP().getInDt().before(getSemmsi001Bean().getSiteSP().getDocDt())) {
				addMessageErrorWithArgument("W0006", msg("message.inDt"), msg("message.docDate"));
				flagValid = false;
			}
		}
		if (StringUtils.isEmpty(getSemmsi001Bean().getSiteSP().getSiteApproveStatus())) {
			addMessageError("W0001", msg("message.siteApproveStatus"));
			flagValid = false;
		}
		
		if(checkCompany()){
			flagValid = false;
		}
		
		return flagValid;
	}

	private SEMMSI001Bean semmsi001Bean;
	private EMAILModel email;
	
	public SEMMSI001Bean getSemmsi001Bean() {
		return (SEMMSI001Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi001Bean");
	}
	
	public void setSemmsi001Bean(SEMMSI001Bean semmsi001Bean) {
		this.semmsi001Bean = semmsi001Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi001Bean", this.semmsi001Bean);
	}
	
	private PopupSiteLocationBean popupSiteLocationBean;
	
	public PopupSiteLocationBean getPopupSiteLocationBean() {
		return (PopupSiteLocationBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupSiteLocationBean");
	}

	public void setPopupSiteLocationBean(PopupSiteLocationBean popupSiteLocationBean) {
		this.popupSiteLocationBean = popupSiteLocationBean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupSiteLocationBean", this.popupSiteLocationBean);
	}
	
	private PopupSiteContractBean popupSiteContractBean;

	public PopupSiteContractBean getPopupSiteContractBean() {
		return (PopupSiteContractBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupSiteContractBean");
	}

	public void setPopupSiteContractBean(PopupSiteContractBean popupSiteContractBean) {
		this.popupSiteContractBean = popupSiteContractBean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupSiteContractBean", this.popupSiteContractBean);
	}
	
	private boolean validateFrmSearch() {
		boolean flagValid = false;
		
		if (StringUtils.isNotEmpty(getSemmsi001Bean().getSearchCriteria().getDocNo()) 
			|| StringUtils.isNotEmpty(getSemmsi001Bean().getSearchCriteria().getContractNo()) 
			|| StringUtils.isNotEmpty(getSemmsi001Bean().getSearchCriteria().getLocationId()) 
			|| StringUtils.isNotEmpty(getSemmsi001Bean().getSearchCriteria().getLocationName())
			|| StringUtils.isNotEmpty(getSemmsi001Bean().getSearchCriteria().getBatchNo())){
			return flagValid;
		} else if (StringUtils.isEmpty(getSemmsi001Bean().getSearchCriteria().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flagValid = true;
		}
		
		Date docDateFrom = getSemmsi001Bean().getSearchCriteria().getDocDateFrom();
		Date docDateTo = getSemmsi001Bean().getSearchCriteria().getDocDateTo();
		
		if(docDateFrom != null && docDateTo != null){
			if (docDateFrom.after(docDateTo)) {
				addMessageErrorWithArgument("W0006" ,msg("message.docDtForm"), msg("message.docDtTo"));
				flagValid = true;
			}
		}
		
		return flagValid;
	}
	
	@SuppressWarnings("unchecked")
	private void searchSiteApprove() {
		ISiteApproveService service = (ISiteApproveService)getBean("siteApproveService");
		List<SiteApproveDisplaySP> to = null;
		try {
			
			semmsi001Bean.setSiteApproveList(new ArrayList<WrapperBeanObject<SiteApproveDisplaySP>>());
			setSemmsi001Bean(semmsi001Bean);
			
			if (semmsi001Bean.getSearchCriteria().isChkCurrentFlag()){
				semmsi001Bean.getSearchCriteria().setCurrentFlag("Y");
				}
			else {
				semmsi001Bean.getSearchCriteria().setCurrentFlag("N");
			}
			log.debug("   FLAG   :  "+semmsi001Bean.getSearchCriteria().getCurrentFlag());
			to = service.querySPList(EQueryName.Q_SEARCH_SITE_APPROVE_DISPLAY.name, semmsi001Bean.getSearchCriteria());
			if (null == to || to.isEmpty()) {
//				addMessageError("M0004");
				semmsi001Bean.setRenderedMsgDataNotFound(true);
			} else {
//				semmsi001Bean.setSiteApproveList(to);
				semmsi001Bean.setRenderedMsgDataNotFound(false);
				log.debug("to.size() = "+to.size());
				for (int i=0; i<to.size(); i++) {
					SiteApproveDisplaySP o = to.get(i);
					WrapperBeanObject<SiteApproveDisplaySP> tmpWrapperBean = new WrapperBeanObject<SiteApproveDisplaySP>();
					
//					o.setDocDate(convertYearENtoTH(o.getDocDate()));
//					o.setOutDt(convertYearENtoTH(o.getOutDt()));
					o.setDocDateStr(convertYearENtoTHStr(o.getDocDate()));
					o.setOutDtStr(convertYearENtoTHStr(o.getOutDt()));
					
					tmpWrapperBean.setDataObj(o);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					semmsi001Bean.getSiteApproveList().add(tmpWrapperBean);
				}
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("error from SEMMSO001Action searchSiteApprove()");
			log.error(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public boolean doSearch() {
		boolean flag = false;
		semmsi001Bean = getSemmsi001Bean();
		semmsi001Bean.setDisBtnExport(true);
		semmsi001Bean.setChkSelAll(false);
		semmsi001Bean.setScrollerPage("");
		if (validateFrmSearch()) {
			semmsi001Bean.setRenderedMsgFormSearch(true);
			return flag;
		} else {
			searchSiteApprove();
		}
		setSemmsi001Bean(semmsi001Bean);
		return flag;
	}
	
	public boolean doClear() {
		boolean flag = false;
		SEMMSI001Bean semmsi001Bean = getSemmsi001Bean();
		semmsi001Bean.setSearchCriteria(new SiteApproveDisplaySP());
		semmsi001Bean.getSearchCriteria().setChkCurrentFlag(false);
		semmsi001Bean.setSiteApproveList(null);
		semmsi001Bean.setRenderedMsgDataNotFound(false);
		setSemmsi001Bean(semmsi001Bean);
		return flag;
	}
	
	public boolean doCancel() {
		boolean flag = false;
		SEMMSI001Bean semmsi001Bean = getSemmsi001Bean();
		semmsi001Bean.setSiteSP(new SiteApprove());
		setSemmsi001Bean(semmsi001Bean);
		return flag;
	}
	
	public boolean doReset() {
		boolean flag = false;
		SEMMSI001Bean semmsi001Bean = getSemmsi001Bean();
		semmsi001Bean.setPageStatus("ADD");
		// backup value company
		String tmpCompany = semmsi001Bean.getSiteSP().getCompany();
		// clear value in add form
		semmsi001Bean.setSiteSP(new SiteApprove());
		semmsi001Bean.getSiteSP().setDocDt(new Date());
		semmsi001Bean.getSiteSP().setInDt(new Date());
		semmsi001Bean.getSiteSP().setSiteApproveStatus("01");
		semmsi001Bean.getSiteSP().setReqType("");
		semmsi001Bean.setOtherReqOfficer("");
		semmsi001Bean.setDisTxtReqOfficer(true);
//		if (StringUtils.isNotEmpty(tmpCompany)) semmsi001Bean.getSiteSP().setCompany(tmpCompany);
		
		semmsi001Bean.setSiteMapLoc(new SiteLocationSP());
		semmsi001Bean.setSiteMapLocList(null);
		semmsi001Bean.setVisibleModeEdit(false);
		semmsi001Bean.setVisibleModeView(false);
		
		popupSiteContractBean = new PopupSiteContractBean();
		popupSiteContractBean.setContractNo("");
		setPopupSiteContractBean(popupSiteContractBean);
		
		popupSiteLocationBean = new PopupSiteLocationBean();
		setPopupSiteLocationBean(popupSiteLocationBean);
		
//		semmsi001Bean.setTxtAlert("");
//		semmsi001Bean.setTxtAlertSiteLoc("");
		setSemmsi001Bean(semmsi001Bean);
		return flag;
	}
	
	@SuppressWarnings("unchecked")
	public boolean pageLoad() {
		boolean flag = true;
		// get parameter 'mode' 
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		String siteInfoId = (String)getFacesUtils().getRequestParameter("siteInfoId");
		SEMMSI001Bean semmsi001Bean = getSemmsi001Bean();
		semmsi001Bean.setSiteMapLoc(new SiteLocationSP());
		semmsi001Bean.setSiteMapLocList(null);
		semmsi001Bean.setOtherReqOfficer("");
		semmsi001Bean.setPageStatus(mode);
		semmsi001Bean.setRenderDate(false);
		semmsi001Bean.setReqDocTypeList(LOVCacheUtil.getInstance().getReqDocTypeSelList());
		
		popupSiteContractBean = new PopupSiteContractBean();
		setPopupSiteContractBean(popupSiteContractBean);
		
		popupSiteLocationBean = new PopupSiteLocationBean();
		setPopupSiteLocationBean(popupSiteLocationBean);
		if ("EDIT".equals(mode) || "VIEW".equals(mode)) {
			// mode 'Edit' or 'View'
			// manage dropdown site approve status by check cancel and close flag
			String cancelFlag = (String)getFacesUtils().getRequestParameter("cancelFlag");
			String closeFlag = (String)getFacesUtils().getRequestParameter("closeFlag");
			String siteInfoStatus = (String)getFacesUtils().getRequestParameter("siteInfoStatus");
			if (cancelFlag.equals("Y")) {
				semmsi001Bean.setSiteApproveStatusList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(
						ELovType.T_SI_APPROVE_STATUS.name, EX_IN, null, "Y", null));
			} else if (closeFlag.equals("Y")) {
				semmsi001Bean.setSiteApproveStatusList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(
						ELovType.T_SI_APPROVE_STATUS.name, EX_IN, null, null, "Y"));
			}
			
			String siteApproveId = (String)getFacesUtils().getRequestParameter("siteApproveId");
			ISiteApproveService service = (ISiteApproveService)getBean("siteApproveService");

			PopupSiteContractBean popupSiteContractBean = new PopupSiteContractBean();
			SiteApprove to = null;
			List<SiteApproveMapLocSP> toSiteLoc = null;
			try {
				SiteApproveSP criteria = new SiteApproveSP();
				criteria.setSiteApproveId(siteApproveId);
				SiteApproveMapLocSP criteriaLoc = new SiteApproveMapLocSP();
				criteriaLoc.setSiteApproveId(siteApproveId);
				to = service.querySiteApproveByRowId(siteApproveId);
				toSiteLoc = service.querySPList(EQueryName.Q_SERACH_MAP_LOC_BY_SITE_APPROVE_ID.name, criteriaLoc);
				if (null != to) {
					semmsi001Bean.setSiteSP(to);
					semmsi001Bean.setTmpDocNo(to.getDocNo());
					popupSiteContractBean.setContractNo(semmsi001Bean.getSiteSP().getContractNo());
					popupSiteContractBean.setSiteInfoId(semmsi001Bean.getSiteSP().getSiteInfoId());
					
					List<Psi005Srch> psi005List = null;
					Psi005Srch psi005Srch = new Psi005Srch();
					psi005Srch.setContractNo(semmsi001Bean.getSiteSP().getContractNo());
					psi005Srch.setSiInfoId(siteInfoId);
					
					psi005List = service.querySPList(EQueryName.SP_PSI005_SRCH.name, psi005Srch);
					
					if(psi005List.size()>0 && psi005List!=null){
						if(psi005List.get(0).getEffDate()!=null && psi005List.get(0).getExpDate()!=null){
							semmsi001Bean.setRenderDate(true);
							popupSiteContractBean.setEffDt(SEMDataUtility.toStringThaiDateSimpleFormat(psi005List.get(0).getEffDate()));
							popupSiteContractBean.setExpDt(SEMDataUtility.toStringThaiDateSimpleFormat(psi005List.get(0).getExpDate()));
						}
					
					}
					
					boolean flg = false;
					for (SelectItem o: semmsi001Bean.getReqOfficerList()) {
						if(to.getReqOfficer() != null){
							if (to.getReqOfficer().equals(o.getLabel())) {
								flg = true;
								break;
							}
						}
						
					}
					if (flg) {
						semmsi001Bean.setDisTxtReqOfficer(false);
					} else {
						semmsi001Bean.setDisTxtReqOfficer(true);
						semmsi001Bean.setOtherReqOfficer(to.getReqOfficer());
					}
				}
				if (null != toSiteLoc && !toSiteLoc.isEmpty()) {
					semmsi001Bean.setFirstSiteMapLocId(toSiteLoc.get(0).getMapLocId());
					semmsi001Bean.setSiteMapLocList(toSiteLoc);
				}
			} catch (Exception e) {
				e.printStackTrace();
				log.error("error from SEMMSO001Action pageLoad()");
				log.error(e);
			}
			setPopupSiteContractBean(popupSiteContractBean);
			semmsi001Bean.setVisibleModeEdit(true);
			if ("VIEW".equals(mode)) {
				semmsi001Bean.setVisibleBtnModeView(false);
				semmsi001Bean.setVisibleModeView(true);
				semmsi001Bean.setVisibleApproveStatus(true);
			} else {
//				if (cancelFlag.equals("Y") || closeFlag.equals("Y")) {
				if ("01".equals(siteInfoStatus) || closeFlag.equals("Y")) {
					semmsi001Bean.setVisibleModeView(true);
				} else {
					semmsi001Bean.setVisibleModeView(false);
				}
				semmsi001Bean.setVisibleApproveStatus(false);
				semmsi001Bean.setVisibleBtnModeView(true);
			}
		} else if ("ADD".equals(mode)){
			// mode 'Add'
			semmsi001Bean.setSiteApproveStatusList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(
					ELovType.T_SI_APPROVE_STATUS.name, EX_AND, "Y", null, null));
			semmsi001Bean.setVisibleBtnModeView(true);
			semmsi001Bean.setVisibleModeView(false);
			semmsi001Bean.setDisTxtReqOfficer(true);
			semmsi001Bean.setRenderDate(false);
			semmsi001Bean.setSiteSP(new SiteApprove());
			semmsi001Bean.getSiteSP().setDocDt(new Date());
			semmsi001Bean.getSiteSP().setInDt(new Date());
			semmsi001Bean.getSiteSP().setSiteApproveStatus("01");
			semmsi001Bean.getSiteSP().setReqType("");
			semmsi001Bean.setSiteMapLoc(new SiteLocationSP());
			semmsi001Bean.setSiteMapLocList(null);
			getPopupSiteContractBean().setContractNo("");
		} else if ("SEARCH".equals(mode)) {
			semmsi001Bean.setSiteApproveStatusList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(
					ELovType.T_SI_APPROVE_STATUS.name));
			if (StringUtils.isNotEmpty(getSemmsi001Bean().getSearchCriteria().getCompany())) {
				doSearch();
			}
			return flag;
		}
		setSemmsi001Bean(semmsi001Bean);
		return flag;
	}
	
	private boolean doSaveSiteApprove() {
		boolean flag = true;
		
		// set data from popup site contract
		popupSiteContractBean = getPopupSiteContractBean();
		if (popupSiteContractBean != null) {
			semmsi001Bean.getSiteSP().setContractNo(popupSiteContractBean.getContractNo());
			semmsi001Bean.getSiteSP().setSiteInfoId(popupSiteContractBean.getSiteInfoId());
			semmsi001Bean.getSiteSP().setSendRenewId(popupSiteContractBean.getSendRenewId());
		}
		ISiteApproveService service = (ISiteApproveService)getBean("siteApproveService");
		try {
			
			
			if (!semmsi001Bean.getSiteSP().getReqType().equals("98")) {
				semmsi001Bean.getSiteSP().setInvalidDt(null);
			}

			// 20110119 check doc number 
			Msi001ChkDocNo msi001ChkDocNo = new Msi001ChkDocNo();
			msi001ChkDocNo.setDocNo(semmsi001Bean.getSiteSP().getDocNo());
			msi001ChkDocNo.setSiteApproveId(semmsi001Bean.getSiteSP().getRowId());
			msi001ChkDocNo.setReqType(semmsi001Bean.getSiteSP().getReqType());
			msi001ChkDocNo.setContractNo(semmsi001Bean.getSiteSP().getContractNo());
			msi001ChkDocNo.setUserId(getUserLogIn());
			List<Msi001ChkDocNo> to = null;
			
			boolean chk = false;
			boolean chkChangeDocNo = true;
			
			
			
			if (semmsi001Bean.getPageStatus().equals("EDIT")) {
//				chkChangReqType();
				chk = (semmsi001Bean.getTmpDocNo().equals(semmsi001Bean.getSiteSP().getDocNo()))? true: false;
			}
			if (chk) {
				// case edit not change docNo
				to = new ArrayList<Msi001ChkDocNo>();
				Msi001ChkDocNo tmp = new Msi001ChkDocNo();
				tmp.setResult("Success");
				to.add(tmp);
				
				chkChangeDocNo = false;
			} else {
				// case add, edit change docNo
				to = service.querySPList(EQueryName.SP_MSI001_CHK_DOC_NO.name, msi001ChkDocNo);				
			}
			
			if (to != null && !to.isEmpty()) {
				String resultMsg = to.get(0).getResult();
				if (resultMsg.equals("Success")) {
					// success
					
					if (chkChangeDocNo) {
						Msi001Seq msi001Seq = new Msi001Seq();
						msi001Seq.setDocNo(semmsi001Bean.getSiteSP().getDocNo());
						List<Msi001Seq> toSeq = service.querySPList(EQueryName.SP_MSI001_SEQ.name, msi001Seq);
						if (toSeq != null && !toSeq.isEmpty()) {
							Integer seq = toSeq.get(0).getSeqNo();
							semmsi001Bean.getSiteSP().setSeqNo(seq);
						}
					}
					
					// check req officer
					if (StringUtils.isEmpty(semmsi001Bean.getSiteSP().getReqOfficer())) {
						semmsi001Bean.getSiteSP().setReqOfficer(semmsi001Bean.getOtherReqOfficer());
					}
					
					if ("ADD".equals(semmsi001Bean.getPageStatus())) {
						semmsi001Bean.getSiteSP().setRecordStatus("Y");
						semmsi001Bean.getSiteSP().setCurrentUser(getUserLogIn());
						SiteApprove result = service.createSiteApprove(semmsi001Bean.getSiteSP());
						if (result != null) {
							semmsi001Bean.setSiteSP(result);
						}
						semmsi001Bean.setPageStatus("EDIT");
						semmsi001Bean.setTmpDocNo(semmsi001Bean.getSiteSP().getDocNo());
						// addMessageInfo("M0001");
						semmsi001Bean.setVisibleModeEdit(true);
					} else {
						// Mode 'Edit'
						semmsi001Bean.getSiteSP().setCurrentUser(getUserLogIn());
						SiteApprove siteApp = service.querySiteApproveByRowId(semmsi001Bean.getSiteSP().getRowId());
						String temp;
						temp = semmsi001Bean.getSiteSP().getReqType();
						if ("01".equals(temp)){
							semmsi001Bean.getSiteSP().setContractNo(null);
							semmsi001Bean.getSiteSP().setSiteInfoId(null);	
						}
						SiteApprove result = service.updateSiteApprove(semmsi001Bean.getSiteSP());
						
						
						log.debug("result = "+result);
						log.debug("result _____CONTRACT NO = "+result.getContractNo());
						log.debug("result _____SITEINFOID = "+result.getSiteInfoId());
						
						if (result != null) {
							semmsi001Bean.setSiteSP(result);
							chkChangReqType(semmsi001Bean.getSiteSP().getReqType(),siteApp.getReqType(),semmsi001Bean.getSiteSP().getContractNo(),siteApp.getContractNo(),
									semmsi001Bean.getSiteSP().getSiteInfoId(),siteApp.getSiteInfoId());
						}
						// addMessageInfo("M0001");
					}
//					addMessageInfo("M0001");
					
					//added by new 2015/05/13
					to = new ArrayList<Msi001ChkDocNo>();
//					log.debug("SiteAppId : "+msi001ChkDocNo.getSiteApproveId());
//					log.debug("userId : "+msi001ChkDocNo.getUserId());
					to = service.querySPList(EQueryName.SP_MSI001_SAVE.name, msi001ChkDocNo);	
					if(to != null && !to.isEmpty()) {
						String resultMsgAfterUPD = to.get(0).getResult();
						if (resultMsgAfterUPD.equals("Success")) {
							
							log.debug("getLeaderApproveStatus = "+semmsi001Bean.getSiteSP().getSiteApproveStatus());
							//added by NEW 2016/07/14 send email to owner if reject
							if("04".equals(semmsi001Bean.getSiteSP().getSiteApproveStatus())){
								email = new EMAILModel();
//								
								email.setV_type("4");
								email.setRow_ID(msi001ChkDocNo.getSiteApproveId());
								email.setUserId(getUserLogIn());
								email.setBatchFlag("N");
//								
								flag = this.doSendEmail(email);
							}
							
							if("04".equals(semmsi001Bean.getSiteSP().getSiteApproveStatus())){
								if(flag){
//									addMessageInfo("M0001");
								}else{
									addMessageError("W0117");
								}
							}else{
//								addMessageInfo("M0001");
							}
							
							flag = true;
						}else{
							addMessageError("E0001");
							flag = false;
						}
					}
				} else {
					// duplicate
					addGeneralMessageError(resultMsg);
					flag = false;
				}
				
			} else {
				// error store proc
				addMessageError("E0001");
				flag = false;
			}
		} catch (Exception e) {
			addMessageError("E0001");
			e.printStackTrace();
			log.error("error from SEMMSO001Action doSaveSiteApprove()");
			log.error(e);
			flag = false;
		}
		
		return flag;
	}
	
//	//added by NEW 2016/03/30 send mail to owner when status reject
//    public boolean doSendEmail(EMAILModel email){
//    	semmsi001Bean = getSemmsi001Bean();
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
//    		log.debug("error from SEMMSA001 Action doSendEmail : "+e);
//			// TODO: handle exception
//		}finally{
//			email = null;
//		}
//		return result;
//    }
	
	private void chkChangReqType(String reqType,String oldReqType,String contractNo,String oldContractNo,String siteInfoId,String oldSiteInfoId) {
		SEMMSI001Bean semmsi001Bean = getSemmsi001Bean();
		ISiteApproveService service = (ISiteApproveService)getBean("siteApproveService");
		
		String siApproveId = semmsi001Bean.getSiteSP().getRowId();
		SiteApprove siteApp = null;
		List<Msi001chkReqTypeDel> chkType;
		boolean fail = false;
		try {
			
//			siteApp = service.querySiteApproveByRowId(siApproveId);
//			oldReqType = siteApp.getReqType();
//		to = service.querySPList(spName, property)(siteApproveId);
//		reqType = semmsi001Bean.getSiteSP().getReqType();
		log.debug("reqType = "+reqType);
		log.debug("oldReqType = "+oldReqType);
		log.debug("siApproveId = "+siApproveId);
		log.debug("siteInfoId = "+siteInfoId);
		log.debug("oldSiteInfoId = "+oldSiteInfoId);
		if(!StringUtils.equals(reqType, oldReqType) || !StringUtils.equals(contractNo, oldContractNo) || !StringUtils.equals(siteInfoId, oldSiteInfoId)){ 
			Msi001chkReqTypeDel param = new Msi001chkReqTypeDel();
			param.setSiteApproveId(siApproveId);
			chkType = service.querySPList(EQueryName.SEM_SP_MSI001_DELETE_SITE_INFO.name, param);	
			log.debug("chkType.get(0).getResult() = "+chkType.get(0).getResult());
			if(chkType!= null&& "Success".equals(chkType.get(0).getResult())){
			}else{
				fail = true;
				FrontMessageUtils.addMessageError(chkType.get(0).getMessage());
			}
			
		
		}
		if(!fail){
			addMessageInfo("M0001");
		}
//		if (to.getReqType() != reqType){
//			log.debug("ReqType : " +to.getReqType());
//		}
		}
		catch (Exception e) {
			
			e.printStackTrace();
			log.error("error from SEMMSO001Action chkChangReqType()");
			log.error(e);
		}
	
		
		
		
		
	}

	public boolean doSave() {
		boolean flag = false;
		semmsi001Bean = getSemmsi001Bean();
		semmsi001Bean.setRenderedMsgFormSearch(true);
		if (validate()) {
			if (semmsi001Bean.getSiteSP().getSiteApproveStatus().equals("01") && !semmsi001Bean.getSiteSP().getReqType().equals("07")) {
				if (null == semmsi001Bean.getSiteMapLocList() || semmsi001Bean.getSiteMapLocList().size() == 0) {
					addMessageError("W0062");
					return flag;
				}
			}
			doSaveSiteApprove();
//			doSearch();
			//Search
			semmsi001Bean = getSemmsi001Bean();
			semmsi001Bean.setDisBtnExport(true);
			semmsi001Bean.setChkSelAll(false);
			semmsi001Bean.setScrollerPage("");
			searchSiteApprove();
		}
		setSemmsi001Bean(semmsi001Bean);
		return flag;
	}
	
	public boolean initDelete(){
		boolean flag = false;
		String siteApproveId = (String)getFacesUtils().getRequestParameter("siteApproveId");
		SEMMSI001Bean semmsi001Bean = getSemmsi001Bean();
		semmsi001Bean.setSiteApproveIdDel(siteApproveId);
		setSemmsi001Bean(semmsi001Bean);
		return flag;
	}
	
	public boolean initDeleteSiteMapLoc() {
		boolean flag = false;
		ISiteApproveMapLocService siteMapLocService = (ISiteApproveMapLocService)getBean("siteApproveMapLocService");
		String siteMapLocId = (String)getFacesUtils().getRequestParameter("siteMapLocId");
		semmsi001Bean = getSemmsi001Bean();
		try {
//			if (semmsi001Bean.getSiteMapLocList().size() == 1) {
//				semmsi001Bean.setModeDelPopup("ALERT");
//				semmsi001Bean.setMsgDoDelete(getMessageByCode("W0076"));
//			} else {
				semmsi001Bean.setMsgDoDelete(getMessageByCode("Q0002"));
				semmsi001Bean.setModeDelPopup("DEL");
				semmsi001Bean.setTempSiteMapLoc(siteMapLocService.getSiteApproveMapLocByRowId(siteMapLocId));
				semmsi001Bean.getTempSiteMapLoc().setCurrentUser(getUserLogIn());
//			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("error from SEMMSO001Action initDeleteSiteMapLoc()");
			log.error(e);
		}
		setSemmsi001Bean(semmsi001Bean);
		return flag;
	}
	
	@SuppressWarnings("unchecked")
	public boolean doDelete() {
		boolean flag = false;
		ISiteApproveService service = (ISiteApproveService)getBean("siteApproveService");
		semmsi001Bean = getSemmsi001Bean();
		try{
//			semmsi001Bean.getSiteSP().setCurrentUser(getUserLogIn());
//			service.deleteSiteApprove(semmsi001Bean.getSiteSP());
			Msi001Del msi001Del = new Msi001Del();
			msi001Del.setSiteApproveId(semmsi001Bean.getSiteApproveIdDel());
			msi001Del.setCurrentUser(getUserLogIn());
			List<Msi001Del> to = service.querySPList(EQueryName.SP_MSI001_DEL.name, msi001Del);
			if (to != null && !to.isEmpty()) {
				if (to.get(0).getResult().equals("Success")) {
					addMessageInfo("M0002");
					searchSiteApprove();
				}
			}
		}catch(Exception e){
			addMessageError("E0002");
			e.printStackTrace();
			log.error("error from SEMMSO001Action doDelete()");
			log.error(e);
		}
		return flag;
	}
	
	@SuppressWarnings("unchecked")
	public boolean doDeleteSiteMapLoc() {
		boolean flag = false;
		ISiteApproveMapLocService siteMapLocService = (ISiteApproveMapLocService)getBean("siteApproveMapLocService");
		semmsi001Bean = getSemmsi001Bean();
		try {
			String tempSiteMapLocId = semmsi001Bean.getTempSiteMapLoc().getRowId();
			String tempSiteApproveId = semmsi001Bean.getTempSiteMapLoc().getSiteApproveId();
			siteMapLocService.deleteSiteApproveMapLoc(semmsi001Bean.getTempSiteMapLoc());
			if (tempSiteMapLocId.equals(semmsi001Bean.getFirstSiteMapLocId())) {
				Msi001UpdRegion msi001UpdRegion = new Msi001UpdRegion();
				msi001UpdRegion.setSiteApproveId(tempSiteApproveId);
				msi001UpdRegion.setCurrentUser(getUserLogIn());
				List<Msi001UpdRegion> to = siteMapLocService.querySPList(EQueryName.SP_MSI001_UPD_REGION.name, msi001UpdRegion);
				if (to != null && !to.isEmpty()) {
					// For check result after upd region

				}
			}
			addMessageInfo("incContent:frmAddSiteApprove:txtLocationId", "M0002", "");
			
			List<SiteApproveMapLocSP> toSiteLoc = null;
			SiteApproveMapLocSP criteriaLoc = new SiteApproveMapLocSP();
			criteriaLoc.setSiteApproveId(semmsi001Bean.getSiteSP().getRowId());
			toSiteLoc = siteMapLocService.querySPList(EQueryName.Q_SERACH_MAP_LOC_BY_SITE_APPROVE_ID.name, criteriaLoc);
			semmsi001Bean.setSiteMapLocList(toSiteLoc);
		} catch (Exception e) {
			addMessageError("incContent:frmAddSiteApprove:txtLocationId", "E0002", "");
			e.printStackTrace();
			log.error("error from SEMMSO001Action doDeleteSiteMapLoc()");
			log.error(e);
		}
		setSemmsi001Bean(semmsi001Bean);
		return flag;
	}
	
	private boolean validateSiteLocation() {
		boolean flagValid = false;
		if (StringUtils.isEmpty(getPopupSiteLocationBean().getLocationId())) {
			addMessageError("incContent:frmAddSiteApprove:txtLocationId", "W0001", msg("message.locationId"));
			flagValid = true;
		}
		return flagValid;
	}
	
	@SuppressWarnings("unchecked")
	private boolean onAddSiteLocation() {
		boolean flag = false;
		semmsi001Bean = getSemmsi001Bean();
		semmsi001Bean.setRenderedMsgFormSearch(false);
		if (validateSiteLocation()) {
			return flag;
		}
		if ("ADD".equals(getSemmsi001Bean().getPageStatus())) {
//			if (validate()) {
			if(validateCaseAdd()){
				if (getSemmsi001Bean().getSiteMapLocList() == null || getSemmsi001Bean().getSiteMapLocList().isEmpty()) {
					getSemmsi001Bean().getSiteSP().setRegion(getPopupSiteLocationBean().getRegion());
				}
				if (!doSaveSiteApprove()) {
					semmsi001Bean.setRenderedMsgFormSearch(true);
					setSemmsi001Bean(semmsi001Bean);
					return flag;
				}
			} else {
				semmsi001Bean.setRenderedMsgFormSearch(true);
				setSemmsi001Bean(semmsi001Bean);
				return flag;
			}
		} else {
			if (getSemmsi001Bean().getSiteMapLocList() == null || getSemmsi001Bean().getSiteMapLocList().isEmpty()) {
				getSemmsi001Bean().getSiteSP().setRegion(getPopupSiteLocationBean().getRegion());
				if (validate()) {
					if (!doSaveSiteApprove()) {
						return flag;
					}
				} else {
					return flag;
				}
			}
		}
		PopupSiteLocationBean popupSiteLocationBean = getPopupSiteLocationBean();
		ISiteApproveMapLocService siteMapLocService = (ISiteApproveMapLocService)getBean("siteApproveMapLocService");
		
		try {
			SiteApproveMapLoc o = new SiteApproveMapLoc();
			o.setSiteApproveId(semmsi001Bean.getSiteSP().getRowId());
			o.setLocationId(semmsi001Bean.getSiteMapLoc().getLocationId());
			o.setLocationId(popupSiteLocationBean.getLocationId());
			o.setRecordStatus("Y");
			o.setCurrentUser(getUserLogIn());
			SiteApproveMapLocSeqSP oSeq = new SiteApproveMapLocSeqSP();
			oSeq.setSiteApproveId(o.getSiteApproveId());
			
			List<SiteApproveMapLocSeqSP> toSeq = siteMapLocService.querySPList(EQueryName.Q_SEQ_MAP_LOC_BY_SITE_APPROVE_ID.name, oSeq);
			if (toSeq != null && !toSeq.isEmpty()) {
				o.setSeqNo(toSeq.get(0).getSeq());
			}
			
			if (siteMapLocService.createSiteApproveMapLoc(o)) {
				List<SiteApproveMapLocSP> toSiteLoc = null;
				SiteApproveMapLocSP criteriaLoc = new SiteApproveMapLocSP();
				criteriaLoc.setSiteApproveId(o.getSiteApproveId());
				toSiteLoc = siteMapLocService.querySPList(EQueryName.Q_SERACH_MAP_LOC_BY_SITE_APPROVE_ID.name, criteriaLoc);
				if (null != toSiteLoc && !toSiteLoc.isEmpty()) {
					semmsi001Bean.setFirstSiteMapLocId(toSiteLoc.get(0).getMapLocId());
					semmsi001Bean.setSiteMapLocList(toSiteLoc);
				}
				semmsi001Bean.setSiteMapLoc(new SiteLocationSP());
				
				popupSiteLocationBean.setLocationId("");
				popupSiteLocationBean.setLocationCode("");
				popupSiteLocationBean.setLocationName("");
				popupSiteLocationBean.setStationType("");
				popupSiteLocationBean.setContractNo("");
				popupSiteLocationBean.setRegion("");
				popupSiteLocationBean.setNetworkStatus("");
				
				addMessageInfo("incContent:frmAddSiteApprove:txtLocationId", "M0001", "");
			} else {
				// duplicate
				addMessageError("incContent:frmAddSiteApprove:txtLocationId", "E0005", "Location ID " + o.getLocationId());
			}
		} catch (Exception e) {
			addMessageError("incContent:frmAddSiteApprove:txtLocationId", "E0001", "");
			e.printStackTrace();
			log.error("error from SEMMSO001Action onAddSiteLocation()");
			log.error(e);
		}
		setSemmsi001Bean(semmsi001Bean);
		return flag;
	}
	
	public void onRenderExportButton() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		String batchNo = (String)getFacesUtils().getRequestParameter("batchNo");
		semmsi001Bean = getSemmsi001Bean();
		semmsi001Bean.setTmpRowId(rowId);
		if (isCheckSELBox()) {
			semmsi001Bean.setDisBtnExport(false);
//			if(isOneValue()){
			if(checkDupBatchNo()){
				semmsi001Bean.setBtnExportFlag(true);
			}else{
				semmsi001Bean.setBtnExportFlag(false);
			}
		} else {
			getSemmsi001Bean().setDisBtnExport(true);
//			if(isOneValue()){
//			if(checkDupBatchNo()){
				semmsi001Bean.setBtnExportFlag(false);
//			}else{
//				semmsi001Bean.setBtnExportFlag(true);
//			}
		}
		setSemmsi001Bean(semmsi001Bean);
	}
	
	private boolean isCheckSELBox() {
		boolean isCheck = false;
		
		List<WrapperBeanObject<SiteApproveDisplaySP>> list = getSemmsi001Bean().getSiteApproveList();
		for (WrapperBeanObject<SiteApproveDisplaySP> wrapperBeanObject : list) {
			if (wrapperBeanObject.isCheckBox()) {
				return true;
			}
		}
		return isCheck;
	}
	
	public void selectAllRow(){
		try{
			boolean chkAll = getSemmsi001Bean().isChkSelAll();
			List<WrapperBeanObject<SiteApproveDisplaySP>> detailList = new ArrayList<WrapperBeanObject<SiteApproveDisplaySP>>();
			detailList = getSemmsi001Bean().getSiteApproveList();
			for(int i=0; i<detailList.size(); i++){
				SiteApproveDisplaySP o = (SiteApproveDisplaySP)detailList.get(i).getDataObj();
				if (o.getSiteApproveStatus().equals("01")) {
					detailList.get(i).setCheckBox(chkAll);
				}
			}
			onRenderExportButton();
		}catch(NullPointerException ne){

		}catch(Exception e){
			
			log.error("error from SEMMSO001Action selectAllRow()");
			log.error(e);
		}
	}
	
//	private boolean doSearchContractNo() {
//		boolean flag = false;
//		SEMMSI001Bean semmsi001Bean = getSemmsi001Bean();
//		ISiteContractService siteContractService = (ISiteContractService)getBean("siteContractService");
//		List<PopupContractSearchSP> to = null;
//		try{
//			to = siteContractService.querySPList(EQueryName.Q_SEARCH_POPUP_SITE_CONTRACT.name, semmsi001Bean.getPopupContractCriteria());
//			if(to != null && to.size() > 0)
//				semmsi001Bean.setContractList(to);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		setSemmsi001Bean(semmsi001Bean);
//		return flag;
//	}
//	
//	public void getSiteInfoId() {
//		if (StringUtils.isNotEmpty(getPopupSiteContractBean().getContractNo())) {
//			SEMMSI001Bean semmsi001Bean = getSemmsi001Bean();
//			semmsi001Bean.setPopupContractCriteria(new PopupContractSearchSP());
//			semmsi001Bean.getPopupContractCriteria().setContractNo(getPopupSiteContractBean().getContractNo());
//			setSemmsi001Bean(semmsi001Bean);
//			doSearchContractNo();
//			semmsi001Bean = getSemmsi001Bean();
//			popupSiteContractBean = getPopupSiteContractBean();
//			if (null == getSemmsi001Bean().getContractList() || getSemmsi001Bean().getContractList().isEmpty()) {
//				semmsi001Bean.getSiteSP().setContractNo("");
//				popupSiteContractBean.setContractNo("");
//			} else {
//				semmsi001Bean.getSiteSP().setSiteInfoId(semmsi001Bean.getContractList().get(0).getSiteInfoId());
//				popupSiteContractBean.setSiteInfoId(semmsi001Bean.getContractList().get(0).getSiteInfoId());
//			}
//			setSemmsi001Bean(semmsi001Bean);
//			setPopupSiteContractBean(popupSiteContractBean);
//		}
//	}

	public void getLovVal2ByTypeAndCode() {
		ILovMasterService service = (ILovMasterService)getBean("lovMasterService");
		SEMMSI001Bean semmsi001Bean = getSemmsi001Bean();
		
		if (!getSemmsi001Bean().getSiteSP().getReqType().equals("")) {
			try {
				semmsi001Bean.getSiteSP().setTitle(service.getLovValByTypeAndCode(ELovType.T_SI_APPROVE_TYPE.name, 
						ELovVal.V_SI_APPROVE_TYPE.name, getSemmsi001Bean().getSiteSP().getReqType()));
				semmsi001Bean.getSiteSP().setReqDocType(service.getLovVal2ByTypeAndCode(ELovType.T_SI_APPROVE_TYPE.name, 
						ELovVal.V_SI_APPROVE_TYPE.name, getSemmsi001Bean().getSiteSP().getReqType()));
				if (!getSemmsi001Bean().getSiteSP().getReqType().equals("01")) {
					if(StringUtils.equalsIgnoreCase("02", getSemmsi001Bean().getSiteSP().getReqType())
					   || StringUtils.equalsIgnoreCase("03", getSemmsi001Bean().getSiteSP().getReqType())
					   || StringUtils.equalsIgnoreCase("04", getSemmsi001Bean().getSiteSP().getReqType())){
						semmsi001Bean.setRenderDate(true);
					}else{
						semmsi001Bean.setRenderDate(false);
					}
					getPopupSiteContractBean().setContractNo("");
					getPopupSiteContractBean().setEffDate(null);
					getPopupSiteContractBean().setExpDate(null);
					semmsi001Bean.setReqContractNo(true);
				} else {
					getPopupSiteContractBean().setContractNo("");
					getPopupSiteContractBean().setEffDate(null);
					getPopupSiteContractBean().setExpDate(null);
					semmsi001Bean.setRenderDate(false);
					semmsi001Bean.setReqContractNo(false);
				}
			} catch (Exception e) {
				log.error("error from SEMMSO001Action getLovVal2ByTypeAndCode()");
				log.error(e);
			}
		} else {
			semmsi001Bean.setRenderDate(false);
			semmsi001Bean.getSiteSP().setTitle("");
		}
	}
	
	public void getRowIdOnClick() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemmsi001Bean().setTmpRowId(rowId);
		
		
	}
	
	private void addLocationFromSiteInfo(List<SiteLocationBySiteInfoIdSP> to) {
		try {
			ISiteApproveMapLocService siteMapLocService = (ISiteApproveMapLocService)getBean("siteApproveMapLocService");
			int i = 1;
			for (SiteLocationBySiteInfoIdSP tempSP : to) {
				SiteApproveMapLoc siteMapLoc = new SiteApproveMapLoc();
				siteMapLoc.setLocationId(tempSP.getLocationId());
				siteMapLoc.setSiteApproveId(semmsi001Bean.getSiteSP().getRowId());
				siteMapLoc.setRecordStatus("Y");
				siteMapLoc.setCurrentUser(getUserLogIn());
				siteMapLoc.setSeqNo(i);
				siteMapLocService.createSiteApproveMapLoc(siteMapLoc);
				i++;
			}
		} catch (Exception e) {
			addMessageError("incContent:frmAddSiteApprove:txtLocationId", "E0001", "");
			log.error("error from SEMMSO001Action addLocationFromSiteInfo()");
			log.error(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public boolean copyLocation() {
		boolean flag = false;
		if (StringUtils.isNotEmpty(getPopupSiteContractBean().getContractNo())) {
			if (getSemmsi001Bean().getSiteMapLocList() == null || getSemmsi001Bean().getSiteMapLocList().isEmpty()) {
				try {
				
					ISiteApproveService service = (ISiteApproveService)getBean("siteApproveService");
					SiteLocationBySiteInfoIdSP o = new SiteLocationBySiteInfoIdSP();
					o.setSiteInfoId(getPopupSiteContractBean().getSiteInfoId());
					List<SiteLocationBySiteInfoIdSP> to = service.querySPList(EQueryName.Q_SITE_LOCATION_BY_SITE_INFO_ID.name, o);
					if (to != null && !to.isEmpty()) {
						semmsi001Bean = getSemmsi001Bean();
						semmsi001Bean.setRenderedMsgFormSearch(true);
						if (validate()) {
							
							semmsi001Bean.getSiteSP().setRegion(to.get(0).getRegion());
							semmsi001Bean.getSiteSP().setContractNo(getPopupSiteContractBean().getContractNo());
							semmsi001Bean.getSiteSP().setSiteInfoId(getPopupSiteContractBean().getSiteInfoId());
							
							if (getSemmsi001Bean().getPageStatus().equals("ADD")) {
								if (doSaveSiteApprove()) {
									addLocationFromSiteInfo(to);
									semmsi001Bean.setRenderedMsgFormSearch(false);
								} else {
									return flag;
								}
							} else {
								addLocationFromSiteInfo(to);
								doSaveSiteApprove();
							}
							
							List<SiteApproveMapLocSP> toSiteLoc = null;
							SiteApproveMapLocSP criteriaLoc = new SiteApproveMapLocSP();
							criteriaLoc.setSiteApproveId(semmsi001Bean.getSiteSP().getRowId());
							toSiteLoc = service.querySPList(EQueryName.Q_SERACH_MAP_LOC_BY_SITE_APPROVE_ID.name, criteriaLoc);
							if (null != toSiteLoc && !toSiteLoc.isEmpty()) {
								semmsi001Bean.setSiteMapLocList(toSiteLoc);
							}
							semmsi001Bean.setSiteMapLoc(new SiteLocationSP());
							
							addMessageInfo("incContent:frmAddSiteApprove:txtLocationId", "M0001", "");
						} else {
							return flag;
						}
						setSemmsi001Bean(semmsi001Bean);
					} else {
						addMessageError("incContent:frmAddSiteApprove:txtLocationId", "M0004", "");
					}
				} catch (Exception e) {
					addMessageError("incContent:frmAddSiteApprove:txtLocationId", "E0001", "");
				}
			} else {
				addMessageError("incContent:frmAddSiteApprove:txtLocationId", "W0014", "");
			}
		} else {
			addMessageError("incContent:frmAddSiteApprove:txtLocationId", "W0001", "ดำเนินการกับเลขที่สัญญา");
		}
		return flag;
	}
	
	private void getListSiteApproveId() {

		String chkReceiptDt;
		String chkCancelDt;
		String siApproveDt;
		semmsi001Bean = getSemmsi001Bean();
		semmsi001Bean.setTmpBatch("");
		semmsi001Bean.setSiteApproveIdStr("");
		String batchNo = "";
		String tmpPaymentBatchNo = "";
		int totalPBatchNo = 0;
		List<SiteApproveDisplaySP> listSiteApp = null;
		for (WrapperBeanObject<SiteApproveDisplaySP> temp : semmsi001Bean.getSiteApproveList()) {
			SiteApproveDisplaySP o = (SiteApproveDisplaySP)temp.getDataObj();
			
			if (temp.isCheckBox()) {
				batchNo = o.getBatchNo();
				if(StringUtils.isNotBlank(batchNo)){
					if(!StringUtils.equals(batchNo, tmpPaymentBatchNo))
					totalPBatchNo++;
				}
				
				if (o.getReceiptDt() != null){
					chkReceiptDt = new SimpleDateFormat("dd/mm/yyyy").format(o.getReceiptDt()); 
				}
				if (o.getSiteInfoApproveDt() != null){
					siApproveDt = new SimpleDateFormat("dd/mm/yyyy").format(o.getSiteInfoApproveDt());
					
				}
				if (o.getCancelDt() != null){
					chkCancelDt = new SimpleDateFormat("dd/mm/yyyy").format(o.getCancelDt());
				}
				if (o.getSiteApproveStatus().equals("01")) {
					if (StringUtils.isEmpty(semmsi001Bean.getSiteApproveIdStr())) {
						semmsi001Bean.setSiteApproveIdStr(o.getRowId());

					} else {
						semmsi001Bean.setSiteApproveIdStr(semmsi001Bean.getSiteApproveIdStr() + "," + o.getRowId());
					}
				}
				
				if (StringUtils.isNotBlank(batchNo)){
					semmsi001Bean.setTmpBatch(batchNo);
					tmpPaymentBatchNo = batchNo;
				}
				
				if (totalPBatchNo>1){
					semmsi001Bean.setValidateExportFlag(true);
				}
				
			}else {
				temp.setCheckBox(false);
			}
		}
		
		setSemmsi001Bean(semmsi001Bean);
	}
	
	
	public void doExportExcel() {
		String clearBatch = (String)getFacesUtils().getRequestParameter("clearBatch");
		log.debug("clearBatch = "+clearBatch);
		//Check Batch
		
			// get rental_clr_rec_id List
			getListSiteApproveId();
			semmsi001Bean = getSemmsi001Bean();
			
			//flag check export
			semmsi001Bean.setDisplayBtn(true);		
			setSemmsi001Bean(semmsi001Bean);
	
			// upd data from store procedure
			Msi001UpdOutDt msi001UpdOutDt = new Msi001UpdOutDt();
			msi001UpdOutDt.setSiteApproveIdList(getSemmsi001Bean().getSiteApproveIdStr());
			msi001UpdOutDt.setCurrentUser(getUserLogIn());
			semmsi001Bean.setMrtGetRunningNo(new MrtGetRunningNo());
			ISiteApproveService service = (ISiteApproveService)getBean("siteApproveService");
			List<MrtGetRunningNo> to1 = null;
			String batchNo ="";
			
			try {
				 //Clear Batch
				if(StringUtils.equals("Y", clearBatch)){
					Msi001UpdateExport msi001UpdatExport = new Msi001UpdateExport(); 
					msi001UpdatExport.setSiteApproveId(getSemmsi001Bean().getSiteApproveIdStr());
					msi001UpdatExport.setUserId(getUserLogIn());
					msi001UpdatExport.setClearBatch("Y");
					List<Msi001UpdateExport> toResult = service.querySPList(EQueryName.SP_MSI001_EXP.name, msi001UpdatExport );
					if(toResult!=null&&toResult.get(0).getResult().equals("Success")){
						doSearch();
						addMessageInfo("M0001");
					}
				}else{
					
					 //call store procedure get BatchNo
						
					if(StringUtils.isEmpty(semmsi001Bean.getTmpBatch())){
						semmsi001Bean.getMrtGetRunningNo().setRunningType("SI_BATCH_NO");
					    to1 = service.querySPList(EQueryName.SP_MRT_GET_RUNNING_NO.name, semmsi001Bean.getMrtGetRunningNo());
						
						batchNo = to1.get(0).getRunningNo();
					}else {
						batchNo = semmsi001Bean.getTmpBatch();
					}
					
					List to = service.querySPList(EQueryName.SP_MSI001_UPD_OUT_DT.name, msi001UpdOutDt);
					DateFormat df =  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
					if (to != null && !to.isEmpty()) {
						// export excel with POI
		//				HSSFWorkbook wb = new HSSFWorkbook();   
		//				HSSFSheet sheet = wb.createSheet();   
		//				HSSFRow row;  
			            
						//get cell style from configure.
		//				Map<String, HSSFCellStyle> styles = createStyles(wb);
						short line = 0;
						Collection<SiteApproveDisplaySP> exList = new ArrayList<SiteApproveDisplaySP>();
						
						DocumentExportManager<SiteApproveDisplaySP> docManager =
							new DocumentExportManager<SiteApproveDisplaySP>(SiteApproveDisplaySP.class, EnumDocumentType.XLS);
		///////////			 set current configuration of work book.	
							docManager.setRowStart(line);
		//				
						EnumDocStyleDomain	titleStyle	= new EnumDocStyleDomain(EnumDocStyle.TITLE);
		//				EnumDocStyleDomain field = docManager.getStyle("normalField");
						EnumDocStyleDomain headerStyle = new EnumDocStyleDomain(EnumDocStyle.HEADER);
						
						RowDomain row0 = new RowDomain(0,true);	
						row0.setCell(new CellDomain(0,16, null, String.class, titleStyle, msg("export.header.submitDetail")+" "+df.format(SEMDataUtility.convertToThYear(new Date())),null));
						
						
						
						RowDomain row1 = new RowDomain(1,true);	
						row1.setCell(new CellDomain(0,16, null, String.class, titleStyle, msg("export.col.paymentBatchNo")+batchNo,null));
						
						
						RowDomain row2 = new RowDomain(2,true);	
						row2.setCell(new CellDomain(0, null, String.class,headerStyle, msg("export.col.no"),-1,800));
						row2.setCell(new CellDomain(1, null, String.class,headerStyle, msg("message.company"),-1,1500));
						row2.setCell(new CellDomain(2, null, String.class,headerStyle, msg("message.region"),-1,1700));
						row2.setCell(new CellDomain(3, null, String.class,headerStyle, msg("export.col.docNo"),-1,3000));
						row2.setCell(new CellDomain(4, null, String.class,headerStyle, msg("export.col.contractNo"),-1,2700));
						row2.setCell(new CellDomain(5, null, String.class,headerStyle, msg("export.col.locatioName"),-1,3000));
						row2.setCell(new CellDomain(6, null, String.class,headerStyle, msg("export.col.receiptDt"),-1,2300));
						row2.setCell(new CellDomain(7, null, String.class,headerStyle, msg("export.col.reject"),-1,2300));
						row2.setCell(new CellDomain(8, null, String.class,headerStyle, msg("export.col.receipt"),-1,2300));
						row2.setCell(new CellDomain(9, null, String.class,headerStyle, msg("export.col.raw"),-1,2200));
						row2.setCell(new CellDomain(10, null, String.class,headerStyle, msg("menu.si.module.name"),-1,2100));
						row2.setCell(new CellDomain(11, null, String.class,headerStyle, msg("export.col.newElectic"),-1,2200));
						row2.setCell(new CellDomain(12, null, String.class,headerStyle, msg("export.col.insurance"),-1,2100));
						row2.setCell(new CellDomain(13, null, String.class,headerStyle, msg("export.col.electic"),-1,2100));
						row2.setCell(new CellDomain(14, null, String.class,headerStyle, msg("export.col.rental"),-1,2100));
						row2.setCell(new CellDomain(15, null, String.class,headerStyle, msg("export.col.contract"),-1,2100));
						row2.setCell(new CellDomain(16, null, String.class,headerStyle, msg("export.col.title"),-1,3200));
			
						List<WrapperBeanObject<SiteApproveDisplaySP>> detailList = new ArrayList<WrapperBeanObject<SiteApproveDisplaySP>>();
						detailList = getSemmsi001Bean().getSiteApproveList();
						int no = 0;
						
						for(int i=0; i<detailList.size(); i++){
							WrapperBeanObject<SiteApproveDisplaySP> detail = new WrapperBeanObject<SiteApproveDisplaySP>();
							detail = detailList.get(i);
							if(detail.isCheckBox()){
								 ++no;
								 SiteApproveDisplaySP siteApproveDSP = ((SiteApproveDisplaySP)detail.getDataObj());
								 siteApproveDSP.setNo(no);
								 //Set Format Date dd/mm/yyyy to Excel
								 if(siteApproveDSP.getSiteInfoApproveDt() != null)
									 siteApproveDSP.setSiApproveDt(SEMDataUtility.toStringThaiDateSimpleFormat(siteApproveDSP.getSiteInfoApproveDt()));
								 if(siteApproveDSP.getCancelDt() != null)
									 siteApproveDSP.setChkCancelDt(SEMDataUtility.toStringThaiDateSimpleFormat(siteApproveDSP.getCancelDt()));
								 if(siteApproveDSP.getInDt() != null)
									 siteApproveDSP.setChkReceiptDt(SEMDataUtility.toStringThaiDateSimpleFormat(siteApproveDSP.getInDt()));
								exList.add(siteApproveDSP);
							}
						}
						
			
						docManager.putDetailRow(row0);
						docManager.putDetailRow(row1);
						docManager.putDetailRow(row2);
						docManager.setMargin(0.05, 0.05, 0.5, 0.05);
						docManager.seteObjectList(exList);
						docManager.setModule("SITE_INFO");
						docManager.setPrintPageLandScape(true);
						docManager.getObjectFromDocument();
						docManager.exportServletFile();
			           
		//				semmsi001Bean.setBtnStatus("EP");
						setSemmsi001Bean(semmsi001Bean);
						
						Msi001UpdateExport exportUpdate = new Msi001UpdateExport();
						exportUpdate.setSiteApproveId(getSemmsi001Bean().getSiteApproveIdStr());
						exportUpdate.setUserId(getUserLogIn());
						exportUpdate.setClearBatch("N");
						List<Msi001UpdateExport> toResult = service.querySPList(EQueryName.SP_MSI001_EXP.name, exportUpdate );
						if(toResult!=null&&toResult.get(0).getResult().equals("Success")){
							addMessageInfo("M0001");
						}
						
						semmsi001Bean.setDisplayShowExcel(false);
					}
					
				}
				
			} catch(NullPointerException ne){
				log.error(ne);
				log.error("error from SEMMSO001Action doExportExcel()");
				log.error(ne);
			}catch(Exception e){
				log.error("error from SEMMSO001Action doExportExcel()");
				log.error(e);
			}finally{
				setSemmsi001Bean(semmsi001Bean);
			}
	}
			
				
//				RowDomain row1 = new RowDomain(1,true);
//				row1.setCell(new CellDomain(0, null, String.class, field, value))
//				
//				row = sheet.createRow(line);
//				
//				setExcelStyle(styles.get("header"), row, (short)0, msg("export.column.no"));
//				setExcelStyle(styles.get("header"), row, (short)1, msg("message.company"));
//				setExcelStyle(styles.get("header"), row, (short)2, msg("message.region"));
//				setExcelStyle(styles.get("header"), row, (short)3, msg("export.col.docNo"));
//				setExcelStyle(styles.get("header"), row, (short)4, msg("export.col.contractNo"));
//				setExcelStyle(styles.get("header"), row, (short)5, msg("export.col.locatioName"));
//				setExcelStyle(styles.get("header"), row, (short)6, msg("export.col.receiptDt"));
//				setExcelStyle(styles.get("header"), row, (short)7, msg("export.col.reject"));
//				setExcelStyle(styles.get("header"), row, (short)8, msg("export.col.receipt"));
//				setExcelStyle(styles.get("header"), row, (short)9, msg("export.col.raw"));
//				setExcelStyle(styles.get("header"), row, (short)10,"Site Info");
//				setExcelStyle(styles.get("header"), row, (short)11, msg("export.col.newElectic"));
//				setExcelStyle(styles.get("header"), row, (short)12, msg("export.col.electic"));
//				setExcelStyle(styles.get("header"), row, (short)13, msg("export.col.rental"));
//				setExcelStyle(styles.get("header"), row, (short)14, msg("export.col.contract"));
//				setExcelStyle(styles.get("header"), row, (short)15, msg("export.col.title"));
//				
//				List<WrapperBeanObject<SiteApproveDisplaySP>> detailList = new ArrayList<WrapperBeanObject<SiteApproveDisplaySP>>();
//				detailList = getSemmsi001Bean().getSiteApproveList();
//				
//				int no = 0;
//				for(int i=0; i<detailList.size(); i++){
//					WrapperBeanObject<SiteApproveDisplaySP> detail = new WrapperBeanObject<SiteApproveDisplaySP>();
//					detail = detailList.get(i);
//					
//					if(detail.isCheckBox()) {
//						SiteApproveDisplaySP tmp = new SiteApproveDisplaySP();
//						tmp = (SiteApproveDisplaySP)detail.getDataObj();
//						
//						String docNo = "";
//						if(StringUtils.isNotBlank(tmp.getDocNo())){
//							docNo = tmp.getDocNo();
//						}
//						
//						String contractNo = "";
//						if(StringUtils.isNotBlank(tmp.getContractNo())){
//							contractNo = tmp.getContractNo();
//						}
//						
//						String locationName = "";
//						if(StringUtils.isNotBlank(tmp.getLocationName())){
//							locationName = tmp.getLocationName();
//						}
//						
//						String title = "";
//						if(StringUtils.isNotBlank(tmp.getTitle())){
//							title = tmp.getTitle();
//						}
//						
//						String company = "";
//						if (StringUtils.isNotBlank(tmp.getCompany())) {
//							company = tmp.getCompany();
//						}
//						
//						String region = "";
//						if (StringUtils.isNotBlank(tmp.getRegionName())) {
//							region = tmp.getRegionName();
//						}
//						
//						String receiptDt = "";
//						if (tmp.getInDt() != null) {
//							receiptDt = SEMDataUtility.toStringEngDateSimpleFormat(SEMDataUtility.convertToThYear(tmp.getInDt()));
//						}
//						
//						String cancelDt = "";
//						if (tmp.getCancelDt() != null) {
//							cancelDt = SEMDataUtility.toStringEngDateSimpleFormat(SEMDataUtility.convertToThYear(tmp.getCancelDt()));
//						}
//						
//						String siteInfoApproveDt = "";
//						if (tmp.getSiteInfoApproveDt() != null) {
//							siteInfoApproveDt = SEMDataUtility.toStringEngDateSimpleFormat(SEMDataUtility.convertToThYear(tmp.getSiteInfoApproveDt()));
//						}
//						
//						row = sheet.createRow(++line);
//						no = no+1;
//						String strNo = Integer.toString(no);
//						setExcelStyle(styles.get("cell_default"), row, (short)0,  strNo);
//						setExcelStyle(styles.get("cell_default"), row, (short)1,  company);
//						setExcelStyle(styles.get("cell_default"), row, (short)2,  region);
//						setExcelStyle(styles.get("cell_default"), row, (short)3,  docNo);
//						setExcelStyle(styles.get("cell_default"), row, (short)4,  contractNo);
//						setExcelStyle(styles.get("cell_normal"), row, (short)5,  locationName);
//						setExcelStyle(styles.get("cell_normal_date"), row, (short)6,  receiptDt);
//						setExcelStyle(styles.get("cell_normal_date"), row, (short)7,  cancelDt);
//						setExcelStyle(styles.get("cell_normal_date"), row, (short)8,  siteInfoApproveDt);
//						setExcelStyle(styles.get("cell_default"), row, (short)9,  "");
//						setExcelStyle(styles.get("cell_default"), row, (short)10,  "");
//						setExcelStyle(styles.get("cell_default"), row, (short)11,  "");
//						setExcelStyle(styles.get("cell_default"), row, (short)12,  "");
//						setExcelStyle(styles.get("cell_default"), row, (short)13,  "");
//						setExcelStyle(styles.get("cell_default"), row, (short)14,  "");
//						setExcelStyle(styles.get("cell_default"), row, (short)15,  title);
//						
//					}
//				}
//				
//				sheet.setColumnWidth((short)0, 1700);
//				sheet.setColumnWidth((short)1, 1595);
//				sheet.setColumnWidth((short)2, 1885);
//				sheet.setColumnWidth((short)3, 4060);
//				sheet.setColumnWidth((short)4, 3190);
//				sheet.setColumnWidth((short)5, 6380);
//				sheet.setColumnWidth((short)6, 3045);
//				sheet.setColumnWidth((short)7, 3045);
//				sheet.setColumnWidth((short)8, 3045);
//				sheet.setColumnWidth((short)9, 2320);
//				sheet.setColumnWidth((short)10, 2320);
//				sheet.setColumnWidth((short)11, 2320);
//				sheet.setColumnWidth((short)12, 2320);
//				sheet.setColumnWidth((short)13, 2320);
//				sheet.setColumnWidth((short)14, 2320);
//				sheet.setColumnWidth((short)15, 5800);
//				
//				HttpServletResponse res = FacesUtils.getInstance().getHttpResponse();   
//				res.setContentType("application/vnd.ms-excel");   
//				res.setHeader("Content-disposition",  "attachment;filename=SITE_APPROVE_" + SEMDataUtility.getCurrentDateDefaultForFileName() + ".xls");
//				
//				ServletOutputStream out = res.getOutputStream();   
//			     
//	            wb.write(out);   
//	            out.flush();   
//	            out.close(); 
//	            
//	            FacesContext faces = FacesContext.getCurrentInstance();   
//	            faces.responseComplete();
//				
	            //searchSiteApprove();
//	        } else {
//				// fail process
//				
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	private boolean doDefaultDate(){
		boolean flag = false;
		semmsi001Bean = getSemmsi001Bean();
		Date docDateFrom = getSemmsi001Bean().getSearchCriteria().getDocDateFrom();
		Date docDateTo = getSemmsi001Bean().getSearchCriteria().getDocDateTo();
		
		if(docDateFrom != null)
			if(docDateTo == null)
			return defaultPeriodStartEndDt(docDateFrom);
		
		if(docDateTo != null)
			if(docDateFrom == null)
			return defaultPeriodStartEndDt(docDateTo);
		
		setSemmsi001Bean(semmsi001Bean);
		return flag;
	}
	
	private boolean defaultPeriodStartEndDt(Date selDt){
		boolean flag = false;
		semmsi001Bean.getSearchCriteria().setDocDateFrom(selDt);
		semmsi001Bean.getSearchCriteria().setDocDateTo(selDt);
		return flag;
	}
	
	public void chkTxtReqOfficer() {
		semmsi001Bean = getSemmsi001Bean();
		if (StringUtils.isEmpty(semmsi001Bean.getSiteSP().getReqOfficer())) {
			semmsi001Bean.setDisTxtReqOfficer(true);
		} else {
			semmsi001Bean.setDisTxtReqOfficer(false);
		}
		setSemmsi001Bean(semmsi001Bean);
	}
	
	public void getCompany(){
		popupSiteContractBean = getPopupSiteContractBean();
		
		//set company
		if(popupSiteContractBean != null)
		getSemmsi001Bean().getSiteSP().setCompany(popupSiteContractBean.getCompanyId());
		
		
		
	}
	
	public void doSearchPopupContractNo(){
		popupSiteContractBean = getPopupSiteContractBean();
//		String company = (String)getFacesUtils().getRequestParameter("company");
		SEMMSI001Bean semmsi001Bean = (SEMMSI001Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi001Bean");
		if (semmsi001Bean!=null){
			String company = semmsi001Bean.getSiteSP().getCompany();
			if(popupSiteContractBean != null){
				popupSiteContractBean.setPopupCriteriaPsi005(new Psi005Srch());
				popupSiteContractBean.getPopupCriteriaPsi005().setContractNo(popupSiteContractBean.getContractNo());
				popupSiteContractBean.getPopupCriteriaPsi005().setReqType(semmsi001Bean.getSiteSP().getReqType());
				popupSiteContractBean.setContractPsi005List(new ArrayList<Psi005Srch>());
				popupSiteContractBean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
				popupSiteContractBean.setRenderedMsgDataNotFound(false);
				if(company != null){
					popupSiteContractBean.getPopupCriteriaPsi005().setCompany(company);
				}
			}
		}
		if (!StringUtils.isEmpty(popupSiteContractBean.getContractNo())){
			ISiteContractService siteContractService = (ISiteContractService)getBean("siteContractService");
			List<Psi005Srch> to = null;
			popupSiteContractBean.setContractList(null);
			try{
				to = siteContractService.querySPList(EQueryName.SP_PSI005_SRCH.name, popupSiteContractBean.getPopupCriteriaPsi005());
				if (null == to || to.isEmpty()) {
					// set error message after search not found
					addMessageErrorWithArgument("W0032",popupSiteContractBean.getPopupCriteriaPsi005().getContractNo());
					popupSiteContractBean.setRenderedMsgDataNotFound(true);
					popupSiteContractBean.setRenderedMsgFormSearch(false);
					semmsi001Bean.setRenderedMsgFormSearch(false);
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi001Bean", semmsi001Bean);
				} else {
					popupSiteContractBean.setRenderedMsgDataNotFound(false);
					if(to != null && to.size() > 0){
						log.debug("size [" + to.size() + "]");
						popupSiteContractBean.setReqType(semmsi001Bean.getSiteSP().getReqType());
						List<Psi005Srch> list = new ArrayList<Psi005Srch>();
						for(Psi005Srch contract : to){
							if(contract.getEffDate() != null){
								contract.setEffDate(SEMDataUtility.convertToThYear(contract.getEffDate()));
							}
							if(contract.getExpDate()!= null){
								contract.setExpDate(SEMDataUtility.convertToThYear(contract.getExpDate()));
							}
							if(contract.getDocDate()!=null){
								contract.setDocDate(SEMDataUtility.convertToThYear(contract.getDocDate()));
							}
							list.add(contract);
						}
						popupSiteContractBean.setContractPsi005List(list);
					}
				}
			}catch(Exception e){
				e.printStackTrace();
				log.error("error from SEMMSO001Action doSearchPopupContractNo()");
				log.error(e);
			}
		}
		setPopupSiteContractBean(popupSiteContractBean);
	}
	
	public void doClosePopup(){
		popupSiteContractBean = getPopupSiteContractBean();
		if (popupSiteContractBean!=null){
			popupSiteContractBean.setContractNo("");
			popupSiteContractBean.setEffDt("");
			popupSiteContractBean.setExpDt("");
		}
		setPopupSiteContractBean(popupSiteContractBean);
	}
	
	public void chkBlankContract(){
		popupSiteContractBean = getPopupSiteContractBean();
		if (popupSiteContractBean!=null){
			popupSiteContractBean.setChkBlnkFlag(false);
			if (!StringUtils.isEmpty(popupSiteContractBean.getContractNo())){
				popupSiteContractBean.setChkBlnkFlag(true);
				popupSiteContractBean.setJsName("getContractNoJS();");
			}else {
				popupSiteContractBean.setChkBlnkFlag(false);
				popupSiteContractBean.setJsName("return false;");
				popupSiteContractBean.setEffDt("");
				popupSiteContractBean.setExpDt("");
			}
		}
		setPopupSiteContractBean(popupSiteContractBean);
	}
	
	private boolean isOneValue(){
		boolean isTrue = true;
		int totalPBatchNo = 0;
		String paymentBatchNo = "";
		String tmpPaymentBatchNo = "";
		for (WrapperBeanObject<SiteApproveDisplaySP> temp : semmsi001Bean.getSiteApproveList()) {
			SiteApproveDisplaySP o = (SiteApproveDisplaySP)temp.getDataObj();
			if(temp.isCheckBox()){
				//Adding by mr.John from (mr.Choosak) 28/04/2011
				paymentBatchNo = o.getBatchNo();
				if(StringUtils.isNotBlank(paymentBatchNo)){
					if(!StringUtils.equals(tmpPaymentBatchNo, paymentBatchNo))
					totalPBatchNo++;
				}
				
				if(totalPBatchNo > 1)
				return isTrue = false;
				
			}
			tmpPaymentBatchNo = paymentBatchNo;
		}
			
		return isTrue;
	}
	
	public boolean chkReRenderExport(){
		semmsi001Bean = getSemmsi001Bean();
//		addMessageError("W0098");
		addMessageError("W0106");
		semmsi001Bean.setRenderedMsgFormSearch(true);
		return false;
	}
	
	public boolean checkCompany(){
		boolean result = false;
		popupSiteContractBean = getPopupSiteContractBean();
		semmsi001Bean = getSemmsi001Bean();
		if(StringUtils.isNotEmpty(popupSiteContractBean.getCompanyId()) && !StringUtils.equals(semmsi001Bean.getSiteSP().getReqType(), "01")
				&& !StringUtils.equals(popupSiteContractBean.getCompanyId(), semmsi001Bean.getSiteSP().getCompany())){
			addMessageError("W0105");
			semmsi001Bean.setRenderedMsgFormSearch(true);
			result = true;
		}
		setSemmsi001Bean(semmsi001Bean);
		return result;
	}
	
	public boolean checkDupBatchNo(){
		boolean result = false;
		semmsi001Bean = getSemmsi001Bean();
		String batchNo = "";
		boolean firstRow = true;
		for (WrapperBeanObject<SiteApproveDisplaySP> temp : semmsi001Bean.getSiteApproveList()) {
			SiteApproveDisplaySP o = (SiteApproveDisplaySP)temp.getDataObj();
			
			if (temp.isCheckBox()) {
				if(firstRow){
					batchNo = o.getBatchNo();
					firstRow = false;
				}else if(!StringUtils.equals(batchNo, o.getBatchNo())){
						result = true;
						break;
				}
			}
		}
		return result;
	}
	
	private boolean doGenDocNo(){
		ISiteApproveService service = (ISiteApproveService)getBean("siteApproveService");
		List<Msi001GenDocNo> result = null;
		Msi001GenDocNo msi001GenDocNo = null;
		semmsi001Bean = getSemmsi001Bean();
		popupSiteContractBean = getPopupSiteContractBean();
		try {
			if(StringUtils.isNotEmpty(semmsi001Bean.getSiteSP().getDocNo())){
				addMessageError("W0109");
				semmsi001Bean.setRenderedMsgFormSearch(true);
				return false;
			}
			
			msi001GenDocNo = new Msi001GenDocNo();
			msi001GenDocNo.setReqType(semmsi001Bean.getSiteSP().getReqType());
			msi001GenDocNo.setReqDocType(semmsi001Bean.getSiteSP().getReqDocType());
			msi001GenDocNo.setCompany(semmsi001Bean.getSiteSP().getCompany());
			if(semmsi001Bean.getSiteMapLocList() != null && !semmsi001Bean.getSiteMapLocList().isEmpty()){
				msi001GenDocNo.setLocationId(semmsi001Bean.getSiteMapLocList().get(0).getLocationId());
			}else{
				msi001GenDocNo.setLocationId(null);
			}
			msi001GenDocNo.setContractNo(popupSiteContractBean.getContractId());
			
			log.debug("msi001GenDocNo.getReqType() = "+msi001GenDocNo.getReqType());
			log.debug("msi001GenDocNo.getReqDocType() = "+msi001GenDocNo.getReqDocType());
			log.debug("msi001GenDocNo.getDocNo() = "+msi001GenDocNo.getCompany());
			log.debug("msi001GenDocNo.getLocationId() = "+msi001GenDocNo.getLocationId());
			log.debug("msi001GenDocNo.getContractNo() = "+msi001GenDocNo.getContractNo());
			
			result = service.querySPList(EQueryName.SP_MSI001_GEN_DOC_NO.name, msi001GenDocNo);
			log.debug("result = "+result);
			if (null != result && !result.isEmpty() && result.get(0) != null) {
				log.debug("result "+result.get(0).getResult());
				log.debug("result getMessage "+result.get(0).getMessage());
				if(StringUtils.equalsIgnoreCase("Success", result.get(0).getResult())){
					if(StringUtils.isNotEmpty(result.get(0).getGenDocNo())){
						semmsi001Bean.getSiteSP().setDocNo(result.get(0).getGenDocNo());
					}
				}else{
					FrontMessageUtils.addMessageError(result.get(0).getMessage());
					semmsi001Bean.setRenderedMsgFormSearch(true);
				}
			} 
		} catch (Exception e) {
			e.printStackTrace();
			log.error("error from SEMMSO001Action doGenDocNo()");
			log.error(e);
		}
		setSemmsi001Bean(semmsi001Bean);
		
		return false;
	}

}
