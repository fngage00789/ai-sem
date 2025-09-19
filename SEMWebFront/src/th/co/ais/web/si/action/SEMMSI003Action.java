package th.co.ais.web.si.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.si.Contract;
import th.co.ais.domain.si.PopupContractSearchSP;
import th.co.ais.domain.si.SiteInfoMapLocSP;
import th.co.ais.domain.si.SiteTerminate;
import th.co.ais.domain.si.SiteTerminateSP;
import th.co.ais.service.gm.ILovMasterService;
import th.co.ais.service.si.ISiteContractService;
import th.co.ais.service.si.ISiteTerminateService;
import th.co.ais.util.ELovType;
import th.co.ais.util.ELovVal;
import th.co.ais.util.EQueryName;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.common.PopupSiteContractBean;
import th.co.ais.web.common.action.PopupSiteContractAction;
import th.co.ais.web.si.bean.SEMMSI003Bean;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.MSGCacheUtil;
import th.co.ais.web.util.RegionCacheUtil;

public class SEMMSI003Action extends AbstractAction{

	private static final long serialVersionUID = 5934806069385322547L;

	private Logger log = Logger.getLogger(getClass());
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if (methodWithNavi.equalsIgnoreCase("doSearch")) {
			flag = doSearch();
		}
		if (methodWithNavi.equalsIgnoreCase("doClear")) {
			flag = doClear();
		}
		if (methodWithNavi.equalsIgnoreCase("doClearSession")) {
			flag = doClearSession();
		}
		if (methodWithNavi.equalsIgnoreCase("pageLoad")) {
			flag = pageLoad();
		}

		if(methodWithNavi.equalsIgnoreCase("doUpdate")){
			flag = doUpdate();
		}
		if(methodWithNavi.equalsIgnoreCase("initDelete")){
			flag = initDelete();
		}
		if(methodWithNavi.equalsIgnoreCase("doDelete")){
			flag = doDelete();
		}
		if(methodWithNavi.equalsIgnoreCase("doReset")){
			flag = doReset();
		}
		if(methodWithNavi.equalsIgnoreCase("doDefaultDate")){
			flag = doDefaultDate();
		}
		
		return flag;
	}


	private boolean doReset() {
		boolean flag = false;
		semmsi003Bean = getSemmsi003Bean();
		semmsi003Bean.setSiteTerminateSP(new SiteTerminateSP());
		String title = semmsi003Bean.getSiteTerminate().getTitle();
		String company = semmsi003Bean.getSiteTerminate().getCompany();
		semmsi003Bean.setSiteTerminate(new SiteTerminate());
		semmsi003Bean.getSiteTerminate().setTitle(title);
		semmsi003Bean.getSiteTerminate().setCompany(company);
		semmsi003Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
		semmsi003Bean.setRenderPanelLog(false);
		semmsi003Bean.setPageStatus("ADD");
		popupSiteContractBean = getPopupSiteContractBean();
		popupSiteContractBean.setPopupContractCriteria(new PopupContractSearchSP());
		popupSiteContractBean.setEffDate(null);
		popupSiteContractBean.setExpDate(null);
		popupSiteContractBean.setContractNo("");
		popupSiteContractBean.setRegion("");
		popupSiteContractBean.setSiteInfoId("");
		popupSiteContractBean.setSiteInfoMapLocSPList(null);
		semmsi003Bean.getSiteTerminate().setDocDt(new Date());
		semmsi003Bean.getSiteTerminate().setTitle(this.getTitle());
		semmsi003Bean.setRenderedMsgFormSearch(false);
		setPopupSiteContractBean(popupSiteContractBean);
		setSemmsi003Bean(semmsi003Bean);
		return flag;
	}

	private boolean doDelete() {
		boolean flag = false;
		ISiteTerminateService siteTerminateService = (ISiteTerminateService)getBean("siteTerminateService");
		semmsi003Bean = getSemmsi003Bean();
		String messageCode = "M0002";
		try{
			siteTerminateService.deleteSiteTerminate(semmsi003Bean.getSiteTerminate());
			doSearch();
			addMessageInfo(messageCode);
		}catch(Exception e){
			log.error(e);
			messageCode = "E0002";
			addMessageError(messageCode);
		}
		
		return flag;
	}

	private boolean initDelete() {
		boolean flag = false;
		ISiteTerminateService siteTerminateService = (ISiteTerminateService)getBean("siteTerminateService");
		String siteTerminateId = (String)getFacesUtils().getRequestParameter("rowId");
		semmsi003Bean = getSemmsi003Bean();
		try{
			semmsi003Bean.setSiteTerminate(siteTerminateService.querySiteTerminateByRowId(siteTerminateId));
		}catch(Exception e){
			log.error(e);
		}
		return flag;
	}


	private boolean doUpdate() {
		boolean flag = false;
		if(!validate())
			return flag;
		
		ISiteTerminateService siteTerminateService = (ISiteTerminateService)getBean("siteTerminateService");
		semmsi003Bean = getSemmsi003Bean();
		popupSiteContractBean = getPopupSiteContractBean();
		if(popupSiteContractBean.getSiteInfoId() != null) semmsi003Bean.getSiteTerminate().setSiteInfoId(popupSiteContractBean.getSiteInfoId());
		if(popupSiteContractBean.getContractNo() != null) semmsi003Bean.getSiteTerminate().setContractNo(popupSiteContractBean.getContractNo());
		if(popupSiteContractBean.getRegion() != null) semmsi003Bean.getSiteTerminate().setRegion(popupSiteContractBean.getRegion());
		if(semmsi003Bean.getUserLogin() != null) semmsi003Bean.getSiteTerminate().setCurrentUser(semmsi003Bean.getUserLogin());
		String messageCode = "M0001";
		try {
			String mode = semmsi003Bean.getPageStatus();
			if(mode.equals("ADD")){
				// check duplicate
				List<SiteTerminateSP> to = null;
				SiteTerminateSP criteria = new SiteTerminateSP();
				criteria.setDocNo(semmsi003Bean.getSiteTerminate().getDocNo());
				to =  siteTerminateService.querySPList(EQueryName.Q_SEARCH_SITE_TERMINATE.name, criteria);
				if(to != null && to.size() > 0){
					// duplicate
					addMessageError("W0028", semmsi003Bean.getSiteTerminate().getDocNo());
					
				}else{
					SiteTerminate siteTerminate = siteTerminateService.createSiteTerminate(semmsi003Bean.getSiteTerminate());
					semmsi003Bean.setSiteTerminate(siteTerminate);
					semmsi003Bean.setPageStatus("EDIT");
					semmsi003Bean.setRenderPanelLog(true);
					addMessageInfo(messageCode);	
				}
				
			}else if(mode.equals("EDIT")){
				siteTerminateService.updateSiteTerminate(semmsi003Bean.getSiteTerminate());
				setDataUpdate();
				addMessageInfo(messageCode);
			}else{
				return flag;
			}
		} catch (Exception e) {
			log.error(e);
			messageCode = "E0001";
			addMessageError(messageCode);
		}
		semmsi003Bean.setRenderedMsgFormSearch(true);
		setSemmsi003Bean(semmsi003Bean);
		setPopupSiteContractBean(popupSiteContractBean);
		return flag;
	}

	

	private boolean doClearSession() {
		boolean flag = true;
		semmsi003Bean = getSemmsi003Bean();
		semmsi003Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
		if(semmsi003Bean.getSiteTerminateSP().getCompany() != null && !semmsi003Bean.getSiteTerminateSP().getCompany().equals("")){
			doSearch();
		}
		setSemmsi003Bean(semmsi003Bean);
		return flag;
	}

	private boolean doClear() {
		boolean flag = false;
		semmsi003Bean = getSemmsi003Bean();
		semmsi003Bean.setSiteTerminateSP(new SiteTerminateSP());
		semmsi003Bean.setSiteTerminateSPList(null);
		setSemmsi003Bean(semmsi003Bean);
		return flag;
	}

	private boolean pageLoad() {
		boolean flag = true;
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		semmsi003Bean = getSemmsi003Bean();
		popupSiteContractBean = new PopupSiteContractBean();
		popupSiteContractBean.setCompanyList(getCompanyItemsAll());
		semmsi003Bean.setPageStatus(mode);
		if(mode.equals("EDIT") || mode.equals("VIEW")){
			String siteTerminateId = (String)getFacesUtils().getRequestParameter("rowId");
			semmsi003Bean.getSiteTerminate().setRowId(siteTerminateId);
			setDataUpdate();
			semmsi003Bean.setRenderPanelLog(true);
		}else if(mode.equals("ADD")){
			semmsi003Bean.setSiteTerminate(new SiteTerminate());
			// default current date
			semmsi003Bean.getSiteTerminate().setDocDt(new Date());
			semmsi003Bean.getSiteTerminate().setTitle(this.getTitle());
			semmsi003Bean.setCompanyList(getCompanyItemsAll());
			semmsi003Bean.setRenderPanelLog(false);
			popupSiteContractBean.setEffDate(null);
			popupSiteContractBean.setExpDate(null);
			popupSiteContractBean.setContractNo("");
			popupSiteContractBean.setRegion("");
			popupSiteContractBean.setSiteInfoId("");
			popupSiteContractBean.setSiteInfoMapLocSPList(new ArrayList<SiteInfoMapLocSP>());
			popupSiteContractBean.setPopupContractCriteria(new PopupContractSearchSP());
		}else{
			return flag;
		}
		semmsi003Bean.setRenderedMsgFormSearch(false);
		setSemmsi003Bean(semmsi003Bean);
		setPopupSiteContractBean(popupSiteContractBean);
		// render button
		setRenderButton(mode);
		
		return flag;
	}
	
	

	private String getTitle() {
		String title = "";
		try{
			ILovMasterService lovService = (ILovMasterService)FacesUtils.getInstance().getBean("lovMasterService");
			title = lovService.getLovVal2ByTypeAndCode(ELovType.T_SI_APPROVE_TYPE.name, ELovVal.V_SI_TERMINATE_TYPE.name,
					ELovVal.V_SI_TERMINATE_REQ_TYPE.name);
		}catch(Exception e){
			e.printStackTrace();
		}
		return title;
	}


	private void setDataUpdate() {
		semmsi003Bean = getSemmsi003Bean();
		popupSiteContractBean = getPopupSiteContractBean();
		
		ISiteTerminateService service = (ISiteTerminateService)getBean("siteTerminateService");
		SiteTerminate to = new SiteTerminate();
		try{
			to = service.querySiteTerminateByRowId(semmsi003Bean.getSiteTerminate().getRowId());
			if(to != null){
				semmsi003Bean.setSiteTerminate(to);
				popupSiteContractBean.setContractNo(to.getContractNo());
				popupSiteContractBean.setSiteInfoId(to.getSiteInfoId());
				popupSiteContractBean.setRegion(to.getRegion());
				// search location
				popupSiteContractBean.setSiteInfoMapLocSP(new SiteInfoMapLocSP());
				popupSiteContractBean.getSiteInfoMapLocSP().setSiteInfoId(to.getSiteInfoId());
				popupSiteContractBean.setPopupContractCriteria(new PopupContractSearchSP());
				popupSiteContractBean.getPopupContractCriteria().setContractNo(to.getContractNo());
				getPopupSiteContractAction().doSearchLocationList();
				// search effDate, expDate by ContractNo
				this.getContractBySiteInfoId(to.getSiteInfoId());
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi003Bean(semmsi003Bean);
		setPopupSiteContractBean(popupSiteContractBean);
		
	}


	private void getContractBySiteInfoId(String siteInfoId) {
		popupSiteContractBean = getPopupSiteContractBean();
		try{
			ISiteContractService siteContractService = (ISiteContractService)getBean("siteContractService");
			Contract contract = siteContractService.queryContractBySiteInfoId(siteInfoId);
			if(contract != null){
				popupSiteContractBean.setEffDate(contract.getEffectiveDt());
				popupSiteContractBean.setExpDate(contract.getExpireDt());
				setPopupSiteContractBean(popupSiteContractBean);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}


	private void setRenderButton(String mode) {
		semmsi003Bean = getSemmsi003Bean();
		if(mode.equals("ADD") || mode.equals("EDIT")){
			semmsi003Bean.setRenderBtnBack(true);
			semmsi003Bean.setRenderBtnSave(true);
			semmsi003Bean.setRenderBtnNew(true);
			semmsi003Bean.setRenderBtnPopup(true);
			semmsi003Bean.setDisabledModeView(false);
		}else{
			semmsi003Bean.setRenderBtnBack(true);
			semmsi003Bean.setRenderBtnSave(false);
			semmsi003Bean.setRenderBtnNew(false);
			semmsi003Bean.setRenderBtnPopup(false);
			semmsi003Bean.setDisabledModeView(true);
			
		}
		
		setSemmsi003Bean(semmsi003Bean);
	}

	private boolean doSearch() {
		boolean flag = false;
		if(!validateSearch())
			return flag;
		
		semmsi003Bean = getSemmsi003Bean();
		ISiteTerminateService siteTerminateService = (ISiteTerminateService)getBean("siteTerminateService");
		List<SiteTerminateSP> to = null;
		try{
			to = siteTerminateService.querySPList(EQueryName.Q_SEARCH_SITE_TERMINATE.name, semmsi003Bean.getSiteTerminateSP());
			if (null == to || to.isEmpty()) {
				// set error message after search not found
				addMessageError("M0004");	
				semmsi003Bean.setSiteTerminateSPList(null);
				
			}
			if(to != null && to.size() > 0){
//				log.debug("size [" + to.size() + "]");
				List<SiteTerminateSP> list = new ArrayList<SiteTerminateSP>();
				for(SiteTerminateSP siteTerminate : to){
					if(siteTerminate.getDocDate() != null){
						siteTerminate.setDocDate(convertYearENtoTH(siteTerminate.getDocDate()));
					}
					list.add(siteTerminate);
				}
				semmsi003Bean.setSiteTerminateSPList(list);
			}
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0003");
		}
		semmsi003Bean.setRenderedMsgFormSearch(true);
		setSemmsi003Bean(semmsi003Bean);
		
		return flag;
	}
	

	private boolean validateSearch() {
		boolean flgValid = true;
		if(StringUtils.isEmpty(getSemmsi003Bean().getSiteTerminateSP().getDocNo()) &&
		   StringUtils.isEmpty(getSemmsi003Bean().getSiteTerminateSP().getContractNo())){
			if(StringUtils.isEmpty(getSemmsi003Bean().getSiteTerminateSP().getCompany())){
				addMessageError("W0001", msg("message.company"));
				flgValid = false;
			}
		}
		Date docDateFrom = getSemmsi003Bean().getSiteTerminateSP().getDocDateFrom();
		Date docDateTo = getSemmsi003Bean().getSiteTerminateSP().getDocDateTo();
		try {
			log.info("docDateFrom [" + docDateFrom + "]");
			log.info("docDateTo [" + docDateTo + "]");
			
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError("Invalid Date!");
		}
		
		if(docDateFrom != null && docDateTo != null){
			if (docDateFrom.after(docDateTo)) {
				addMessageErrorWithArgument("W0006" ,msg("message.docDateBegin"), msg("message.docDateEnd"));
				flgValid = false;
			}
		}
		return flgValid;
	}

	@Override
	public void clearSessionNotUsed() {
//		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("popupSiteContractBean");
	}

	@Override
	public void init() {
		SEMMSI003Bean semmsi003Bean = new SEMMSI003Bean();
		semmsi003Bean.setSiteTerminateSP(new SiteTerminateSP());
		semmsi003Bean.setSiteTerminate(new SiteTerminate());
		semmsi003Bean.setCompanyList(getCompanyItemsAll());
		semmsi003Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
		semmsi003Bean.setConfirmDeleteMsg(MSGCacheUtil.getInstance().getMessageByCode("Q0002"));
		semmsi003Bean.setConfirmResetMsg(MSGCacheUtil.getInstance().getMessageByCode("Q0001"));
		semmsi003Bean.setRenderedMsgFormSearch(true);
		setSemmsi003Bean(semmsi003Bean);
		PopupSiteContractBean popupSiteContractBean = new PopupSiteContractBean();
		setPopupSiteContractBean(popupSiteContractBean);
	}

	@Override
	public boolean validate() {
		boolean flgValid = true;
		if(StringUtils.isEmpty(getSemmsi003Bean().getSiteTerminate().getCompany())){
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
				
		if(StringUtils.isEmpty(getSemmsi003Bean().getSiteTerminate().getDocNo())){
			addMessageError("W0001", msg("message.siteTerminateDocNo"));
			flgValid = false;
		}
		if(StringUtils.isEmpty(getPopupSiteContractBean().getContractNo())){
			addMessageError("W0001", msg("message.cancelContractNo"));
			flgValid = false;
		}
		
		if(getSemmsi003Bean().getSiteTerminate().getDocDt() == null){
			addMessageError("W0001", msg("message.docDate"));
			flgValid = false;
		}
		
		if(StringUtils.isEmpty(getSemmsi003Bean().getSiteTerminate().getTitle())){
			addMessageError("W0001", msg("message.title"));
			flgValid = false;
		}
		
		
		if(getSemmsi003Bean().getSiteTerminate().getInvalidDt() == null){
			addMessageError("W0001", msg("message.invalidDate"));
			flgValid = false;
		}
		
		return flgValid;
	}
	
	public void getRowIdOnClick() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemmsi003Bean().setTmpRowId(rowId);
	}
	
	private boolean doDefaultDate(){
		boolean flag = false;
		semmsi003Bean = getSemmsi003Bean();
		Date docDateFrom = semmsi003Bean.getSiteTerminateSP().getDocDateFrom();
		Date docDateTo = semmsi003Bean.getSiteTerminateSP().getDocDateTo();
		
		log.info("docDateFrom :" + docDateFrom);
		log.info("docDateTo :" + docDateTo);
		
		if(docDateFrom != null)
			if(docDateTo == null)
			return defaultDocDateFromToDt(docDateFrom);
		
		if(docDateTo != null)
			if(docDateFrom == null)
			return defaultDocDateFromToDt(docDateTo);
		
		setSemmsi003Bean(semmsi003Bean);
		return flag; 
	}
	
	private boolean defaultDocDateFromToDt(Date selDt){
		boolean flag = false;
		semmsi003Bean = getSemmsi003Bean();
		semmsi003Bean.getSiteTerminateSP().setDocDateFrom(selDt);
		semmsi003Bean.getSiteTerminateSP().setDocDateTo(selDt);
		setSemmsi003Bean(semmsi003Bean);
		return flag;
	}
	

	private SEMMSI003Bean semmsi003Bean;
	
	public SEMMSI003Bean getSemmsi003Bean() {
		return (SEMMSI003Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi003Bean");
	}
	
	public void setSemmsi003Bean(SEMMSI003Bean semmsi003Bean) {
		this.semmsi003Bean = semmsi003Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi003Bean", this.semmsi003Bean);
	}
	
	private PopupSiteContractBean popupSiteContractBean;

	public PopupSiteContractBean getPopupSiteContractBean() {
		return (PopupSiteContractBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupSiteContractBean");
	}

	public void setPopupSiteContractBean(PopupSiteContractBean popupSiteContractBean) {
		this.popupSiteContractBean = popupSiteContractBean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupSiteContractBean", this.popupSiteContractBean);
	}
	
	private PopupSiteContractAction popupSiteContractAction;

	public PopupSiteContractAction getPopupSiteContractAction() {
		if(popupSiteContractAction == null){
			popupSiteContractAction = new PopupSiteContractAction();
		}
		return popupSiteContractAction;
	}


	public void setPopupSiteContractAction(
			PopupSiteContractAction popupSiteContractAction) {
		this.popupSiteContractAction = popupSiteContractAction;
	}
	
}
