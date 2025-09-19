package th.co.ais.web.ir.action;

import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.ir.Insured;
import th.co.ais.domain.ir.Mir006SP;
import th.co.ais.service.ir.IInsuredService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.common.PopupSiteContractBean;
import th.co.ais.web.ir.bean.SEMMIR006Bean;
import th.co.ais.web.util.SelectItemLOVCacheUtil;

public class SEMMIR006Action extends AbstractAction {

	private static final long serialVersionUID = 3687788604275209804L;
	private Logger log = Logger.getLogger(getClass());
	private SEMMIR006Bean semmir006Bean;
	private PopupSiteContractBean popupSiteContractBean;
	
	public SEMMIR006Bean getSemmir006Bean() {
		return (SEMMIR006Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmir006Bean");
	}

	public void setSemmir006Bean(SEMMIR006Bean semmir006Bean) {
		this.semmir006Bean = semmir006Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmir006Bean", semmir006Bean);
	}
	
	public PopupSiteContractBean getPopupSiteContractBean() {
		return (PopupSiteContractBean)getFacesUtils().getSessionMapValue("popupSiteContractBean");
	}

	public void setPopupSiteContractBean(PopupSiteContractBean popupSiteContractBean) {
		this.popupSiteContractBean = popupSiteContractBean;
		getFacesUtils().setSessionMapValue("popupSiteContractBean", popupSiteContractBean);
		
	}

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		
		if (methodWithNavi.equalsIgnoreCase("doSearch")) {
			flag = doSearch();
		} else if (methodWithNavi.equalsIgnoreCase("doClear")) {
			doClear();
		} else if (methodWithNavi.equalsIgnoreCase("initPopup")) {
			initPopup();
		} else if (methodWithNavi.equalsIgnoreCase("doSave")) {
			doSave();
		} else if (methodWithNavi.equalsIgnoreCase("initDelete")) {
			initDelete();
		} else if (methodWithNavi.equalsIgnoreCase("doDelete")) {
			doDelete();
		}
		
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		semmir006Bean = new SEMMIR006Bean(getLovItemsByType(ELovType.T_COMPANY.name), 
				SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_IR_NETWORK_TYPES.name));
		
		setSemmir006Bean(semmir006Bean);
	}

	@Override
	public boolean validate() {
		boolean flgValid = true;
		
		log.debug("++++++++++++++++++ PLX FLAG +++++++++++++++++ "+getSemmir006Bean().getCriteria().getPlxFlag());
		if (StringUtils.isEmpty(getSemmir006Bean().getCriteria().getCompany())
			&&StringUtils.isEmpty(getSemmir006Bean().getCriteria().getNetworkType())
			&&StringUtils.isEmpty(getSemmir006Bean().getCriteria().getContractNo())
			&&StringUtils.isEmpty(getSemmir006Bean().getCriteria().getLocationId())
			&&StringUtils.isEmpty(getSemmir006Bean().getCriteria().getLocationName())			
			&&getSemmir006Bean().getCriteria().getEffDateFrom()== null 
			&&getSemmir006Bean().getCriteria().getEffDateTo()== null) {
			addMessageError("W0004", msg("message.requireOne"));
			flgValid = false;
		}
		
		Date docDateFrom = getSemmir006Bean().getCriteria().getEffDateFrom();
		Date docDateTo = getSemmir006Bean().getCriteria().getEffDateTo();
		if(docDateFrom != null && docDateTo != null){
			if (docDateFrom.after(docDateTo)) {
				addMessageErrorWithArgument("W0006" ,msg("message.docDtForm"), msg("message.docDtTo"));
				flgValid = false;
			}
		} else {
			if (docDateFrom == null && docDateTo != null) {
				addMessageError("W0001", msg("message.docDtForm"));
				flgValid = false;
			} 
			if (docDateTo == null && docDateFrom != null) {
				addMessageError("W0001", msg("message.docDtTo"));
				flgValid = false;
			}
		}
		
		return flgValid;
	}
	
	public void getRowIdOnClick() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemmir006Bean().setTmpRowId(rowId);
	}
	
	
	@SuppressWarnings("unchecked")
	private void getMir006Srch() {
		
		IInsuredService service = (IInsuredService)getBean("insuredService");
		List resultList = null;
		try {
			semmir006Bean.getCriteria().setPlxFlag((semmir006Bean.getCriteria().isPlxFlagBoolean() ? "T": "F"));
			resultList = service.querySPList(EQueryName.Q_INSURED.name, semmir006Bean.getCriteria());
			if (resultList != null && !resultList.isEmpty()) {
				for (int i=0; i<resultList.size(); i++) {
					Mir006SP tmp = (Mir006SP)resultList.get(i);
//					tmp.setEffDate(convertYearENtoTH(tmp.getEffDate()));
//					tmp.setUpdateDt(convertYearENtoTH(tmp.getUpdateDt()));
					tmp.setEffDateStr(convertYearENtoTHStr(tmp.getEffDate()));
					tmp.setUpdateDtStr(convertYearENtoTHStr(tmp.getUpdateDt()));
				}
				
				semmir006Bean.setResultList(resultList);
				semmir006Bean.setRenderedMsgDataNotFound(false);
			} else {
				semmir006Bean.setResultList(null);
				semmir006Bean.setRenderedMsgDataNotFound(true);
			}
			semmir006Bean.getCriteria().setPlxFlag((semmir006Bean.getCriteria().isPlxFlagBoolean() ? "true": "false"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public boolean doSearch() {
		boolean flag = false;
		semmir006Bean = getSemmir006Bean();
		semmir006Bean.setRenderedMsgDataNotFound(false);
		
		if (validate()) {
			getMir006Srch();
		} else {
			semmir006Bean.setRenderedMsgFormSearch(true);
		}
		
		setSemmir006Bean(semmir006Bean);
		return flag;
	}
	
	public void doClear() {
		semmir006Bean = getSemmir006Bean();
		
		semmir006Bean.setCriteria(new Mir006SP());
		semmir006Bean.setResultList(null);
		semmir006Bean.setRenderedMsgFormSearch(false);
		semmir006Bean.setRenderedMsgDataNotFound(false);
		
		setSemmir006Bean(semmir006Bean);
	}
	
	private void initPopup() {
		semmir006Bean = getSemmir006Bean();
		popupSiteContractBean = getPopupSiteContractBean();
		
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		if (mode.equals("ADD")) {
			semmir006Bean.setTmpSave(new Mir006SP());
			popupSiteContractBean.setContractNo("");
			semmir006Bean.setViewMode(false);
		} else if (mode.equals("EDIT")) {
			semmir006Bean.setViewMode(true);
			String rowId = (String)getFacesUtils().getRequestParameter("rowId");
			for (int i=0; i<semmir006Bean.getResultList().size(); i++) {
				Mir006SP tmp = (Mir006SP)semmir006Bean.getResultList().get(i);
				if (tmp.getRowId().equals(rowId)) {
					semmir006Bean.setTmpSave(new Mir006SP(tmp));
					popupSiteContractBean.setContractNo(tmp.getContractNo());
					break;
				}
			}
		}
		
		semmir006Bean.setActModeDisplay(mode);
		semmir006Bean.setRenderedMsgFormSearch(false);
		setSemmir006Bean(semmir006Bean);
		setPopupSiteContractBean(popupSiteContractBean);
	}
	
	private boolean validateSave() {
		boolean flgValid = true;
		
		if (StringUtils.isEmpty(getSemmir006Bean().getTmpSave().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		
		if (StringUtils.isEmpty(getSemmir006Bean().getTmpSave().getNetworkType())) {
			addMessageError("W0001", msg("message.networkType"));
			flgValid = false;
		}
		
		if (getSemmir006Bean().getTmpSave().getInsuredAmt() == 0) {
			addMessageError("W0001", msg("message.insuredAmt"));
			flgValid = false;
		}
		
		if (getSemmir006Bean().getTmpSave().getEffDate() == null) {
			addMessageError("W0001", msg("message.effectiveDt"));
			flgValid = false;
		}
		
		return flgValid;
	}
	
	@SuppressWarnings("unchecked")
	private void doSave() {
		semmir006Bean = getSemmir006Bean();
		popupSiteContractBean = getPopupSiteContractBean();
		if (validateSave()) {
			IInsuredService service = (IInsuredService)getBean("insuredService");
			List resultList = null;
			semmir006Bean.getTmpSave().setCurrentUser(getUserLogIn());
			semmir006Bean.getTmpSave().setContractNo(popupSiteContractBean.getContractNo());
			try {
				resultList = service.querySPList(EQueryName.Q_INSURED_EDT.name, semmir006Bean.getTmpSave());
				if (resultList != null && !resultList.isEmpty() && resultList.size() > 0) {
					Mir006SP tmp = (Mir006SP)resultList.get(0);
					if (tmp.getResult().equals("Success")) {
						addMessageInfo("M0001");
						semmir006Bean.setRenderedMsgFormSearch(true);
						semmir006Bean.setRenderedMsgFormTop(false);
						semmir006Bean.setPopupClose(true);
						if (semmir006Bean.getResultList() != null) {
							getMir006Srch();
						}
					} else {
						addGeneralMessageError(tmp.getMsgError());
						semmir006Bean.setRenderedMsgFormSearch(false);
						semmir006Bean.setRenderedMsgFormTop(true);
						semmir006Bean.setPopupClose(false);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			semmir006Bean.setRenderedMsgFormSearch(false);
			semmir006Bean.setRenderedMsgFormTop(true);
			semmir006Bean.setPopupClose(false);
		}
		setSemmir006Bean(semmir006Bean);
	}
	

	private void initDelete() {
		semmir006Bean = getSemmir006Bean();
		
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		semmir006Bean.setTmpDelId(rowId);
		
		setSemmir006Bean(semmir006Bean);
	}
	
	private void doDelete() {
		semmir006Bean = getSemmir006Bean();
		
		IInsuredService service = (IInsuredService)getBean("insuredService");
		Insured tmp = null;
		try {
			tmp = service.queryInsuredByRowId(semmir006Bean.getTmpDelId());
			if (tmp != null) {
				tmp.setCurrentUser(getUserLogIn());
//				if (StringUtils.isEmpty(tmp.getContractNo())) {
					service.deleteInsured(tmp);
//				} else {
//					tmp.setInsuredAmt(new Double(0));
//					service.updateInsured(tmp);
//				}
				addMessageInfo("M0002");
				getMir006Srch();
			} else {
				addMessageError("E0002");
			}
		} catch (Exception e) {
			addMessageError("E0002");
			e.printStackTrace();
		}
		semmir006Bean.setRenderedMsgFormSearch(true);
		
		setSemmir006Bean(semmir006Bean);
	}
	
}
