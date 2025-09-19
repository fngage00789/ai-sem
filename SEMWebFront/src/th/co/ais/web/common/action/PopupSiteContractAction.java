package th.co.ais.web.common.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import sun.java2d.pipe.SpanShapeRenderer.Simple;
import th.co.ais.domain.gm.Pct002SrchBgContract;
import th.co.ais.domain.si.PopupContractSearchSP;
import th.co.ais.domain.si.Psi005Srch;
import th.co.ais.domain.si.SiteInfoMapLocSP;
import th.co.ais.service.si.ISiteContractService;
import th.co.ais.service.si.ISiteInfoMapLocService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.common.PopupSiteContractBean;
import th.co.ais.web.el.action.SEMMEL011Action;
import th.co.ais.web.gm.bean.SEMMCT002Bean;
import th.co.ais.web.ir.bean.SEMMIR006Bean;
import th.co.ais.web.pt.bean.SEMMPT004Bean;
import th.co.ais.web.si.bean.SEMMSI004Bean;
import th.co.ais.web.si.action.SEMMSI001Action;
import th.co.ais.web.si.bean.SEMMSI001Bean;

public class PopupSiteContractAction extends AbstractAction{

	private static final long serialVersionUID = 154181415663741549L;
	private Logger log = Logger.getLogger(getClass());

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if(methodWithNavi.equalsIgnoreCase("initPopupSearchContractNo")){
			flag = initPopupSearchContractNo();
		} else if(methodWithNavi.equalsIgnoreCase("doSearchPopupContractNo")){
			flag = doSearchPopupContractNo();
		} else if(methodWithNavi.equalsIgnoreCase("doClearPopupContractNo")){
			flag = doClearPopupContractNo();
		} else if(methodWithNavi.equalsIgnoreCase("doSelectContractNo")){
			flag = doSelectContractNo();
		} else if (methodWithNavi.equalsIgnoreCase("initPopupSearchContractNoPsi005")) {
			flag = initPopupSearchContractNoPsi005();
		} else if (methodWithNavi.equalsIgnoreCase("doSearchContractNoPsi005")) {
			flag = doSearchContractNoPsi005();
		} else if (methodWithNavi.equalsIgnoreCase("doClearPopupContractNoPsi005")) {
			flag = doClearPopupContractNoPsi005();
		} else if (methodWithNavi.equalsIgnoreCase("initPopupSearchContractNoPct002")) {
			flag = initPopupSearchContractNoPct002();
		} else if (methodWithNavi.equalsIgnoreCase("doSearchContractNoPct002")) {
			flag = doSearchContractNoPct002();
		} else if (methodWithNavi.equalsIgnoreCase("doClearPopupContractNoPct002")) {
			flag = doClearPopupContractNoPct002();
		} else if(methodWithNavi.equalsIgnoreCase("doSelectContractNoCT002")){
			flag = doSelectContractNoCT002();
		}else if (methodWithNavi.equalsIgnoreCase("initPopupSearchContractNoMir006")) {
			flag = initPopupSearchContractNoMir006();
		} else if (methodWithNavi.equalsIgnoreCase("doSearchContractNoMir006")) {
			flag = doSearchContractNoMir006();
		}else if (methodWithNavi.equalsIgnoreCase("doSearchContractForRollBack")) {
			flag = doSearchContractForRollBack();
		}else if (methodWithNavi.equalsIgnoreCase("doRollBackContract")) {
			flag = doRollBackContract();
		}
		
		
		
		return flag;
	}
	
	private boolean doSelectContractNoCT002() {
		boolean flag = false;
		try {
			String siteInfoId = (String)getFacesUtils().getRequestParameter("siteInfoId");
			String siteName = (String)getFacesUtils().getRequestParameter("siteName");
			String contractNo = (String)getFacesUtils().getRequestParameter("contractNo");
			String rentalMaster = (String)getFacesUtils().getRequestParameter("rentalMaster");
			String dpstDetailId = (String)getFacesUtils().getRequestParameter("dpstDetailId");
			String dpstCondType = (String)getFacesUtils().getRequestParameter("dpstCondType");
			String dpstType = (String)getFacesUtils().getRequestParameter("dpstType");
			String vendorMasterId = (String)getFacesUtils().getRequestParameter("vendorMasterId");
			String electricId = (String)getFacesUtils().getRequestParameter("electricId");
			String dpstSpecialFlag = (String)getFacesUtils().getRequestParameter("dpstSpecialFlag");
			String areaCode = (String)getFacesUtils().getRequestParameter("areaCode");
			String areaName = (String)getFacesUtils().getRequestParameter("areaName");
			String masterId = (String)getFacesUtils().getRequestParameter("masterId");
			
			popupSiteContractBean = getPopupSiteContractBean();
			popupSiteContractBean.setContractNo(contractNo);
			popupSiteContractBean.setSiteInfoId(siteInfoId);
			popupSiteContractBean.setSiteName(siteName);
			popupSiteContractBean.setRentalMaster(rentalMaster);
			popupSiteContractBean.setDpstDetailId(dpstDetailId);
			popupSiteContractBean.setDpstType(dpstType);
			popupSiteContractBean.setDpstCondType(dpstCondType);
			popupSiteContractBean.setVendorMasterId(vendorMasterId);
			popupSiteContractBean.setElectricId(electricId);
			popupSiteContractBean.setDpstSpecialFlag(dpstSpecialFlag);
			popupSiteContractBean.setAreaCode(areaCode);
			popupSiteContractBean.setAreaName(areaName);
			popupSiteContractBean.setMasterId(masterId);
			
			//set address
			setAddress(popupSiteContractBean);
			setPopupSiteContractBean(popupSiteContractBean);
			
			searchContractByContractNo();
			
			getSemmct002Bean().setValueFrom("popup");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	private boolean doSelectContractNo() {
		boolean flag = false;
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
			
			popupSiteContractBean = getPopupSiteContractBean();
			popupSiteContractBean.setContractNo(contractNo);
			popupSiteContractBean.setRegion(region);
			popupSiteContractBean.setSiteInfoId(siteInfoId);
			popupSiteContractBean.setSiteName(siteName);
			popupSiteContractBean.setCompanyId(companyId);
			popupSiteContractBean.setEffDt(effDt);
			popupSiteContractBean.setExpDt(expDt);
			popupSiteContractBean.setContractId(contractId);
			
			
			if (sendRenewId.equals("EMPTY") || StringUtils.isEmpty(sendRenewId)) {
				popupSiteContractBean.setSendRenewId(null);
			} else {
				popupSiteContractBean.setSendRenewId(sendRenewId);
			}
			
			
			//Add By Noom 12/11/2012
//			if (!StringUtils.isEmpty(popupSiteContractBean.getReqType())){
//				if (StringUtils.equalsIgnoreCase("01", popupSiteContractBean.getReqType())){
//					
//				}else if (StringUtils.equalsIgnoreCase("02", popupSiteContractBean.getReqType())){
//					
//				}
//			}
			
			
			
			//set address
			setAddress(popupSiteContractBean);
			if(popupSiteContractBean.getPage() != null && !popupSiteContractBean.getPage().equals("")){
				doSearchLocationList();
				searchContractByContractNo();
			}
			
			// call from semmsi004tab1
			if(popupSiteContractBean.getFromButton() != null && popupSiteContractBean.getFromButton().equals("oldContractNo")){
				popupSiteContractBean.setOldContractNo(contractNo);
			}
			if(popupSiteContractBean.getFromButton() != null && popupSiteContractBean.getFromButton().equals("siteContractNo")){
				popupSiteContractBean.setSiteContractNo(contractNo);
				popupSiteContractBean.setSiteInfoIdForElectric(siteInfoId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		setPopupSiteContractBean(popupSiteContractBean);
		return flag;
	}
	
	private void setAddress(PopupSiteContractBean p) throws Exception{
		ISiteContractService siteContractService = (ISiteContractService)getBean("siteContractService");
		if(siteContractService != null){
			if(p!=null){
				String siteAddress = siteContractService.getSiteAddressBySiteInfoId(p.getSiteInfoId());
				String lessorAddress = siteContractService.getLessorAddressBySiteInfoId(p.getSiteInfoId()); 
				
				p.setLessorAddr(lessorAddress);
				p.setSiteAddr(siteAddress);
			}
		}
	}
	
	public void doSearchLocationList() {
		popupSiteContractBean = getPopupSiteContractBean();
		popupSiteContractBean.setSiteInfoMapLocSPList(new ArrayList<SiteInfoMapLocSP>());
		ISiteInfoMapLocService siteInfoMapLocService = (ISiteInfoMapLocService)getBean("siteInfoMapLocService");
		List<SiteInfoMapLocSP> to = null;
		try{
			popupSiteContractBean.setSiteInfoMapLocSP(new SiteInfoMapLocSP());
			popupSiteContractBean.getSiteInfoMapLocSP().setSiteInfoId(popupSiteContractBean.getSiteInfoId());
			log.debug("siteInfoId [" + popupSiteContractBean.getSiteInfoMapLocSP().getSiteInfoId() + "]");
			to = siteInfoMapLocService.querySPList(EQueryName.Q_SEARCH_MAP_LOC_BY_SITE_INFO_ID.name,popupSiteContractBean.getSiteInfoMapLocSP());
			log.debug("doSearchLocationList size [" + to.size() + "]");
			popupSiteContractBean.setSiteInfoMapLocSPList(to);
			setPopupSiteContractBean(popupSiteContractBean);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void searchContractByContractNo() {
		popupSiteContractBean = getPopupSiteContractBean();
		popupSiteContractBean.getPopupContractCriteria().setContractNo(popupSiteContractBean.getContractNo());
		searchContract();
		List<PopupContractSearchSP> contractList = popupSiteContractBean.getContractList();
		if(contractList != null && contractList.size() > 0){
			PopupContractSearchSP contract = popupSiteContractBean.getContractList().get(0);
			try {
				popupSiteContractBean.setDefEffDate(SEMDataUtility.convertToEnYear(contract.getEffDate()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			popupSiteContractBean.setEffDate(contract.getEffDate());
			popupSiteContractBean.setExpDate(contract.getExpDate());
			popupSiteContractBean.setRegion(contract.getRegion());
			popupSiteContractBean.setSiteInfoId(contract.getSiteInfoId());
			popupSiteContractBean.setContractNo(contract.getContractNo());
			// call from semmsi004tab1
			if(popupSiteContractBean.getFromButton() != null && popupSiteContractBean.getFromButton().equals("oldContractNo")){
				popupSiteContractBean.setOldContractNo(contract.getContractNo());
			}
			if(popupSiteContractBean.getFromButton() != null && popupSiteContractBean.getFromButton().equals("siteContractNo")){
				popupSiteContractBean.setSiteContractNo(contract.getContractNo());
				popupSiteContractBean.setSiteInfoIdForElectric(contract.getSiteInfoId());
			}
		}else{
			popupSiteContractBean.setContractNo("");
			popupSiteContractBean.setSiteInfoId("");
			popupSiteContractBean.setOldContractNo("");
			popupSiteContractBean.setSiteContractNo("");
		}
		setPopupSiteContractBean(popupSiteContractBean);
	}
	

	private boolean doClearPopupContractNo() {
		boolean flag = false;
		popupSiteContractBean = getPopupSiteContractBean();
		popupSiteContractBean.getPopupContractCriteria().setCurrentFlag("Y");
		popupSiteContractBean.getPopupContractCriteria().setContractNo("");
		popupSiteContractBean.getPopupContractCriteria().setSiteName("");
		popupSiteContractBean.getPopupContractCriteria().setCompany("");
		popupSiteContractBean.setContractList(null);
		setPopupSiteContractBean(popupSiteContractBean);
		return flag;
	}
	
	private boolean doClearPopupContractNoPsi005() {
		boolean flag = false;
		popupSiteContractBean = getPopupSiteContractBean();
		popupSiteContractBean.getPopupCriteriaPsi005().setContractNo("");
		popupSiteContractBean.getPopupCriteriaPsi005().setSiteName("");
		popupSiteContractBean.setContractPsi005List(null);
		popupSiteContractBean.setRenderedMsgDataNotFound(false);
		setPopupSiteContractBean(popupSiteContractBean);
		return flag;
	}
	
	private boolean doClearPopupContractNoPct002() {
		boolean flag = false;
		popupSiteContractBean = getPopupSiteContractBean();
		popupSiteContractBean.getPopupCriteriaPct002().setContractNo("");
		popupSiteContractBean.getPopupCriteriaPct002().setSiteName("");
		popupSiteContractBean.setContractPct002List(null);
		popupSiteContractBean.setRenderedMsgDataNotFound(false);
		setPopupSiteContractBean(popupSiteContractBean);
		return flag;
	}
	
	private boolean doSearchContractNoPct002() {
		boolean flag = false;
		if (!validatePct002()) {
			popupSiteContractBean.setRenderedMsgFormSearch(true);
			return flag;
		}
		searchContractPct002();
		return flag;
	}
	
	private void searchContractPct002() {
		popupSiteContractBean = getPopupSiteContractBean();
		ISiteContractService service = (ISiteContractService)getBean("siteContractService");
		List<Pct002SrchBgContract> to = null;
		try {
			to = service.querySPList(EQueryName.SP_PCT002_SRCH_BG.name, popupSiteContractBean.getPopupCriteriaPct002());
			if (null == to || to.isEmpty()) {
				popupSiteContractBean.setRenderedMsgDataNotFound(true);
			} else {
				for (Pct002SrchBgContract contract : to) {
					if(contract.getEffectiveDt() != null){
						contract.setEffectiveDt(SEMDataUtility.convertToThYear(contract.getEffectiveDt()));
					}
					if(contract.getExpireDt() != null){
						contract.setExpireDt(SEMDataUtility.convertToThYear(contract.getExpireDt()));
					}
				}
				popupSiteContractBean.setContractPct002List(to);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setPopupSiteContractBean(popupSiteContractBean);
	}
	
	private boolean doSearchContractNoPsi005() {
		boolean flag = false;
		if(!validatePsi005()) {
			getPopupSiteContractBean().setRenderedMsgFormSearch(true);
		} else {
			getPopupSiteContractBean().setRenderedMsgFormSearch(false);
			searchContractPsi005();
		}
		return flag;
	}
	
	private void searchContractPsi005() {
		popupSiteContractBean = getPopupSiteContractBean();
		ISiteContractService siteContractService = (ISiteContractService)getBean("siteContractService");
		List<Psi005Srch> to = null;
		popupSiteContractBean.setContractList(null);
		try{
			to = siteContractService.querySPList(EQueryName.SP_PSI005_SRCH.name, popupSiteContractBean.getPopupCriteriaPsi005());
			if (null == to || to.isEmpty()) {
				// set error message after search not found
				addMessageErrorWithArgument("W0032",popupSiteContractBean.getPopupCriteriaPsi005().getContractNo());
				popupSiteContractBean.setRenderedMsgDataNotFound(true);
				popupSiteContractBean.setContractPsi005List(null);
				popupSiteContractBean.setRenderedMsgFormSearch(false);
				popupSiteContractBean.setJsCheckDataNotFound("return false;");
				SEMMSI001Bean semmsi001Bean = (SEMMSI001Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi001Bean");
				semmsi001Bean.setRenderedMsgFormSearch(false);
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi001Bean", semmsi001Bean);
			} else {
				popupSiteContractBean.setRenderedMsgDataNotFound(false);
				if(to != null && to.size() > 0){
					log.debug("size [" + to.size() + "]");
					List<Psi005Srch> list = new ArrayList<Psi005Srch>();
					for(Psi005Srch contract : to){
						if(contract.getEffDate() != null){
							contract.setEffDate(SEMDataUtility.convertToThYear(contract.getEffDate()));
							contract.setEffDateStr(SEMDataUtility.converDateToString(contract.getEffDate()));
						}
						if(contract.getExpDate()!= null){
							contract.setExpDate(SEMDataUtility.convertToThYear(contract.getExpDate()));
							contract.setExpDateStr(SEMDataUtility.converDateToString(contract.getExpDate()));
						}
						if(contract.getDocDate()!=null){
							contract.setDocDate(SEMDataUtility.convertToThYear(contract.getDocDate()));
							contract.setDocDateStr(SEMDataUtility.converDateToString(contract.getDocDate()));
						}
						list.add(contract);
					}
					popupSiteContractBean.setJsCheckDataNotFound("getCompany();");
					if (StringUtils.isEmpty(popupSiteContractBean.getTmpContract())){
						popupSiteContractBean.setTmpContract(popupSiteContractBean.getContractNo());
						if (list.size()>0 && list!=null){
						popupSiteContractBean.setEffDt(list.get(0).getEffDateStr());
						popupSiteContractBean.setExpDt(list.get(0).getExpDateStr());
						}
					}else{
						if (!StringUtils.equalsIgnoreCase(popupSiteContractBean.getTmpContract(), popupSiteContractBean.getContractNo())){
							if (list.size()>0 && list!=null){
								popupSiteContractBean.setEffDt(list.get(0).getEffDateStr());
								popupSiteContractBean.setExpDt(list.get(0).getExpDateStr());
								}
							popupSiteContractBean.setTmpContract(popupSiteContractBean.getContractNo());
						}else{
							if(StringUtils.isEmpty(popupSiteContractBean.getEffDt())&& StringUtils.isEmpty(popupSiteContractBean.getExpDt())) {
								if (list.size()>0 && list!=null){
								popupSiteContractBean.setEffDt(list.get(0).getEffDateStr());
								popupSiteContractBean.setExpDt(list.get(0).getExpDateStr());
								}
							}
						}
					}
					popupSiteContractBean.setContractPsi005List(list);
					
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		setPopupSiteContractBean(popupSiteContractBean);
	}
	
	private boolean doSearchContractNoMir006() {
		boolean flag = false;
		if(!validatePsi005()) {
			getPopupSiteContractBean().setRenderedMsgFormSearch(true);
		} else {
			getPopupSiteContractBean().setRenderedMsgFormSearch(false);
			searchContractMir006();
		}
		return flag;
	}
	
	private void searchContractMir006() {
		popupSiteContractBean = getPopupSiteContractBean();
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
				SEMMIR006Bean semmir006Bean = (SEMMIR006Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmir006Bean");
				semmir006Bean.setRenderedMsgFormSearch(false);
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmir006Bean", semmir006Bean);
			} else {
				popupSiteContractBean.setRenderedMsgDataNotFound(false);
				if(to != null && to.size() > 0){
					log.debug("size [" + to.size() + "]");
					List<Psi005Srch> list = new ArrayList<Psi005Srch>();
					for(Psi005Srch contract : to){
						if(contract.getEffDate() != null){
							contract.setEffDate(SEMDataUtility.convertToThYear(contract.getEffDate()));
						}
						if(contract.getExpDate()!= null){
							contract.setExpDate(SEMDataUtility.convertToThYear(contract.getExpDate()));
						}
						list.add(contract);
					}
					popupSiteContractBean.setContractPsi005List(list);
					
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		setPopupSiteContractBean(popupSiteContractBean);
	}

	private boolean doSearchPopupContractNo() {
		boolean flag = false;
		if(!validate())
			return flag;
			searchContract();
		
		return flag;
	}
	
	public boolean doSearchPopupContractNoMCP() {
		boolean flag = false;
		if(!validate())
			return flag;
			searchContract();
		
		return flag;
	}
	
	private void searchContract(){
		popupSiteContractBean = getPopupSiteContractBean();
		ISiteContractService siteContractService = (ISiteContractService)getBean("siteContractService");
		List<PopupContractSearchSP> to = null;
		popupSiteContractBean.setContractList(null);
		try{
			to = siteContractService.querySPList(EQueryName.Q_SEARCH_POPUP_SITE_CONTRACT.name, popupSiteContractBean.getPopupContractCriteria());
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
				popupSiteContractBean.setContractList(list);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		setPopupSiteContractBean(popupSiteContractBean);
	}
	
	private boolean initPopupSearchContractNoPct002() {
		boolean flag = false;
		SEMMCT002Bean semmct002Bean = (SEMMCT002Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmct002Bean");
		popupSiteContractBean = getPopupSiteContractBean();
		if (StringUtils.isEmpty(semmct002Bean.getBgMaster().getCompany()) || StringUtils.isEmpty(semmct002Bean.getBgMaster().getExpenseType())) {
			addGeneralMessageError("กรุณาระบุ บริษัท และ ประเภทค่าใช้จ่าย ให้ครบ");
			popupSiteContractBean.setOpenPopup(false);
			return flag;
		} else {
			popupSiteContractBean.setOpenPopup(true);
		}
		
		popupSiteContractBean.setPopupCriteriaPct002(new Pct002SrchBgContract());
		popupSiteContractBean.getPopupCriteriaPct002().setCompany(semmct002Bean.getBgMaster().getCompany());
		popupSiteContractBean.getPopupCriteriaPct002().setExpenseType(semmct002Bean.getBgMaster().getExpenseType());
		
		popupSiteContractBean.setContractPct002List(new ArrayList<Pct002SrchBgContract>());
		popupSiteContractBean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		
		setPopupSiteContractBean(popupSiteContractBean);
		return flag;
	}
	
	private boolean initPopupSearchContractNoPsi005() {
		boolean flag = false;
		String company = (String)getFacesUtils().getRequestParameter("company");
		SEMMSI001Bean semmsi001Bean = (SEMMSI001Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi001Bean");
		popupSiteContractBean = getPopupSiteContractBean();
		
		popupSiteContractBean.setPopupCriteriaPsi005(new Psi005Srch());
		if (!StringUtils.isEmpty(popupSiteContractBean.getContractNo())){
			popupSiteContractBean.getPopupCriteriaPsi005().setContractNo(popupSiteContractBean.getContractNo());
		}else if (StringUtils.isEmpty(popupSiteContractBean.getContractNo())) {
			popupSiteContractBean.getPopupCriteriaPsi005().setContractNo("");
		}
		popupSiteContractBean.getPopupCriteriaPsi005().setReqType(semmsi001Bean.getSiteSP().getReqType());
		popupSiteContractBean.setContractPsi005List(new ArrayList<Psi005Srch>());
		popupSiteContractBean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		popupSiteContractBean.setRenderedMsgDataNotFound(false);
		if(company != null){
			popupSiteContractBean.getPopupCriteriaPsi005().setCompany(company);
		}
		setPopupSiteContractBean(popupSiteContractBean);
		return flag;
	}
	
	private boolean initPopupSearchContractNoMir006() {
		boolean flag = false;
		popupSiteContractBean = getPopupSiteContractBean();
		
		popupSiteContractBean.setPopupCriteriaPsi005(new Psi005Srch());
		popupSiteContractBean.getPopupCriteriaPsi005().setContractNo("");
		popupSiteContractBean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		popupSiteContractBean.setRenderedMsgDataNotFound(false);
		setPopupSiteContractBean(popupSiteContractBean);
		return flag;
	}

	private boolean initPopupSearchContractNo() {
		boolean flag = false;
		String company = (String)getFacesUtils().getRequestParameter("company");
		String page = (String)getFacesUtils().getRequestParameter("page");
		String fromButton = (String)getFacesUtils().getRequestParameter("fromButton") == null ? "" : (String)getFacesUtils().getRequestParameter("fromButton");
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
			SEMMEL011Action mel011Action = new SEMMEL011Action();
			mel011Action.semmsi004Bean = mel011Action.getSemmsi004Bean();
			mel011Action.semmsi004Bean.setDisabledTransfer(true);
			mel011Action.setSemmsi004Bean(mel011Action.semmsi004Bean);
		}
		setPopupSiteContractBean(popupSiteContractBean);
		return flag;
	}
	
	public boolean getLocationList(){
		boolean flag = false;
		popupSiteContractBean = getPopupSiteContractBean();
			
		try{
			String contractNo = popupSiteContractBean.getContractNo();
			popupSiteContractBean.setEffDate(null);
			popupSiteContractBean.setExpDate(null);
			popupSiteContractBean.setSiteInfoMapLocSPList(null);
			popupSiteContractBean.setSiteInfoMapLocSP(new SiteInfoMapLocSP());
			if(contractNo != null && !contractNo.equals("")){
				searchContractByContractNo();
				String siteInfoId = popupSiteContractBean.getSiteInfoId();
				if(siteInfoId != null && !siteInfoId.equals("")){
					doSearchLocationList();
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setPopupSiteContractBean(popupSiteContractBean);
		return flag;
	}
	
	public void getSiteInfoIdPsi005() {
		popupSiteContractBean = getPopupSiteContractBean();
		try{
			String contractNo = popupSiteContractBean.getContractNo();
			popupSiteContractBean.setEffDate(null);
			popupSiteContractBean.setExpDate(null);
			popupSiteContractBean.setPopupCriteriaPsi005(new Psi005Srch());
			
			if(contractNo != null && !contractNo.equals("")){
				SEMMSI001Bean semmsi001Bean = (SEMMSI001Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi001Bean");
				popupSiteContractBean.setContractNo(contractNo);
				popupSiteContractBean.getPopupCriteriaPsi005().setReqType(semmsi001Bean.getSiteSP().getReqType());
				popupSiteContractBean.getPopupCriteriaPsi005().setContractNo(contractNo);
				setPopupSiteContractBean(popupSiteContractBean);
				
				searchContractPsi005();
				
				semmsi001Bean.setRenderedMsgFormSearch(true);
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi001Bean", semmsi001Bean);
				popupSiteContractBean = getPopupSiteContractBean();
				List<Psi005Srch> contractList = popupSiteContractBean.getContractPsi005List();
				if(contractList != null && contractList.size() > 0){
					Psi005Srch contract = popupSiteContractBean.getContractPsi005List().get(0);
					try {
						popupSiteContractBean.setDefEffDate(SEMDataUtility.convertToEnYear(contract.getEffDate()));
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					popupSiteContractBean.setEffDate(contract.getEffDate());
					popupSiteContractBean.setExpDate(contract.getExpDate());
					popupSiteContractBean.setRegion(contract.getRegion());
					popupSiteContractBean.setSiteInfoId(contract.getSiteInfoId());
					popupSiteContractBean.setContractNo(contract.getContractNo());
					popupSiteContractBean.setSendRenewId(contract.getSendRenewId());
					popupSiteContractBean.setSiteName(contract.getSiteName());
					popupSiteContractBean.setCompanyId(contract.getCompany());
					popupSiteContractBean.setContractId(contract.getContractId());
					
				}else{
					popupSiteContractBean.setContractNo("");
					popupSiteContractBean.setSiteInfoId("");
					popupSiteContractBean.setOldContractNo("");
					popupSiteContractBean.setSiteContractNo("");
					popupSiteContractBean.setSendRenewId("");
					popupSiteContractBean.setCompanyId("");
					popupSiteContractBean.setContractId("");
				}
				setPopupSiteContractBean(popupSiteContractBean);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setPopupSiteContractBean(popupSiteContractBean);
	}
	
	public void getSiteInfoId() {
		popupSiteContractBean = getPopupSiteContractBean();
		semmpt004Bean = new SEMMPT004Bean();
		try{
			String fromButton = (String)getFacesUtils().getRequestParameter("fromButton");
			if(popupSiteContractBean.getContractNo() != null)
				popupSiteContractBean.setContractNo(popupSiteContractBean.getContractNo().toUpperCase());
			popupSiteContractBean.setFromButton(fromButton);
			String contractNo = popupSiteContractBean.getContractNo();
			popupSiteContractBean.setEffDate(null);
			popupSiteContractBean.setExpDate(null);
			popupSiteContractBean.setSiteInfoMapLocSPList(null);
			popupSiteContractBean.setSiteInfoMapLocSP(new SiteInfoMapLocSP());
			popupSiteContractBean.setPopupContractCriteria(new PopupContractSearchSP());
			// call from semmsi004tab1
			if(popupSiteContractBean.getFromButton() != null && popupSiteContractBean.getFromButton().equals("oldContractNo")){
				contractNo = popupSiteContractBean.getOldContractNo();
			}
			if(popupSiteContractBean.getFromButton() != null && popupSiteContractBean.getFromButton().equals("siteContractNo")){
				contractNo = popupSiteContractBean.getSiteContractNo();
			}
			if(contractNo != null && !contractNo.equals("")){
				popupSiteContractBean.setContractNo(contractNo);
				setPopupSiteContractBean(popupSiteContractBean);
				searchContractByContractNo();
				//set message semmpt004-2
				semmpt004Bean.setMsgTop(true);
				semmpt004Bean.setPnlPayInfo(false);
				semmpt004Bean.setPnlPayment(false);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setPopupSiteContractBean(popupSiteContractBean);
		setSemmpt004Bean(semmpt004Bean);
	}
	
	public void getRowIdOnClick() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getPopupSiteContractBean().setTmpRowId(rowId);
	}
	
	private PopupSiteContractBean popupSiteContractBean;

	public PopupSiteContractBean getPopupSiteContractBean() {
		return (PopupSiteContractBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupSiteContractBean");
	}

	public void setPopupSiteContractBean(PopupSiteContractBean popupSiteContractBean) {
		this.popupSiteContractBean = popupSiteContractBean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupSiteContractBean", this.popupSiteContractBean);
	}
	
	


	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		popupSiteContractBean = getPopupSiteContractBean();
		popupSiteContractBean.setPopupContractCriteria(new PopupContractSearchSP());
		popupSiteContractBean.setContractList(null);
		popupSiteContractBean.setSiteInfoMapLocSP(new SiteInfoMapLocSP());
		popupSiteContractBean.setSiteInfoMapLocSPList(null);
		popupSiteContractBean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		setPopupSiteContractBean(popupSiteContractBean);
		
	}

	@Override
	public boolean validate() {
		boolean flgValid = true;
		if(StringUtils.isEmpty(getPopupSiteContractBean().getPopupContractCriteria().getCompany()) 
				&& StringUtils.isEmpty(getPopupSiteContractBean().getPopupContractCriteria().getContractNo())){
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		
		return flgValid;
	}
	
	public boolean validatePsi005() {
		boolean flgValid = true;
		if(StringUtils.isEmpty(getPopupSiteContractBean().getPopupCriteriaPsi005().getContractNo())&&StringUtils.isEmpty(getPopupSiteContractBean().getPopupCriteriaPsi005().getCompany())){
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		
		return flgValid;
	}
	
	public boolean validatePct002() {
		boolean flgValid = true;
		if(StringUtils.isEmpty(getPopupSiteContractBean().getPopupCriteriaPct002().getCompany())){
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		
		return flgValid;
	}
	
	private SEMMPT004Bean semmpt004Bean;
	
	public SEMMPT004Bean getSemmpt004Bean() {
		return (SEMMPT004Bean)getFacesUtils().getSessionMapValue("semmpt004Bean");
	}

	public void setSemmpt004Bean(SEMMPT004Bean semmpt004Bean) {
		this.semmpt004Bean = semmpt004Bean;
		getFacesUtils().setSessionMapValue("semmpt004Bean", semmpt004Bean);
	}
	
	public SEMMCT002Bean getSemmct002Bean() {
		
		SEMMCT002Bean ct002Bean =(SEMMCT002Bean)getFacesUtils().getSessionMapValue("semmct002Bean");
		if(ct002Bean == null)
			ct002Bean = new SEMMCT002Bean();
		return ct002Bean;
	}
	
	private boolean doSearchContractForRollBack(){
		
		SEMMEL011Action mel011Action = new SEMMEL011Action();
		mel011Action.semmsi004Bean = mel011Action.getSemmsi004Bean();
		mel011Action.semmsi004Bean.setDisabledTransfer(true);
		mel011Action.setSemmsi004Bean(mel011Action.semmsi004Bean);
	
		popupSiteContractBean = getPopupSiteContractBean();
		ISiteContractService siteContractService = (ISiteContractService)getBean("siteContractService");
		List<PopupContractSearchSP> to = null;
		popupSiteContractBean.setContractListForRollBack(null);
		popupSiteContractBean.setContractNo(mel011Action.semmsi004Bean.getSiteInfoData().getContractNo());
		popupSiteContractBean.setSiteInfoId(mel011Action.semmsi004Bean.getSiteInfoData().getRowId());
		
		try{
			to = siteContractService.querySPList(EQueryName.SP_MSI004_SRCH_ROLLBACK_DUMMY.name, popupSiteContractBean);
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
		
		SEMMEL011Action mel011Action = new SEMMEL011Action();
		mel011Action.semmsi004Bean = mel011Action.getSemmsi004Bean();
		mel011Action.semmsi004Bean.setDisabledTransfer(true);
		mel011Action.setSemmsi004Bean(mel011Action.semmsi004Bean);
	
		popupSiteContractBean = getPopupSiteContractBean();
		ISiteContractService siteContractService = (ISiteContractService)getBean("siteContractService");
		List<PopupContractSearchSP> to = null;
		popupSiteContractBean.setContractListForRollBack(null);
		//popupSiteContractBean.setUserId(getUserLogIn());
		popupSiteContractBean.setContractNo(mel011Action.semmsi004Bean.getSiteInfoData().getContractNo());
		popupSiteContractBean.setSiteInfoId(mel011Action.semmsi004Bean.getSiteInfoData().getRowId());
		popupSiteContractBean.setUserLogin(getUserLogIn());
		
		try{
			to = siteContractService.querySPList(EQueryName.SP_MEL011_ROLLBACK_DUMMY.name, popupSiteContractBean);
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
