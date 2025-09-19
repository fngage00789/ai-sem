package th.co.ais.web.ir.action;

import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.ir.Mir005SP;
import th.co.ais.domain.ir.Premium;
import th.co.ais.service.ir.IPremiumService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.ir.bean.SEMMIR005Bean;
import th.co.ais.web.util.SelectItemLOVCacheUtil;

public class SEMMIR005Action extends AbstractAction {

	private static final long serialVersionUID = -8302075126184441761L;
	private Logger log = Logger.getLogger(getClass());
	private SEMMIR005Bean semmir005Bean;
	
	public SEMMIR005Bean getSemmir005Bean() {
		return (SEMMIR005Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmir005Bean");
	}

	public void setSemmir005Bean(SEMMIR005Bean semmir005Bean) {
		this.semmir005Bean = semmir005Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmir005Bean", semmir005Bean);
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
		semmir005Bean = new SEMMIR005Bean(getLovItemsByType(ELovType.T_COMPANY.name), 
				SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_IR_NETWORK_TYPES.name), 
				SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_IR_TRANSFER_TYPES.name),
				SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_IR_POLICY_TYPE.name)
				);
		
		setSemmir005Bean(semmir005Bean);
	}

	@Override
	public boolean validate() {
		boolean flgValid = true;
		
		if (StringUtils.isEmpty(getSemmir005Bean().getCriteria().getCompany()) && 
				StringUtils.isEmpty(getSemmir005Bean().getCriteria().getNetworkType()) && 
				StringUtils.isEmpty(getSemmir005Bean().getCriteria().getTransferType()) && 
				StringUtils.isEmpty(getSemmir005Bean().getCriteria().getPolicyType()) && 
				getSemmir005Bean().getCriteria().getEffDateFrom() == null && 
				getSemmir005Bean().getCriteria().getEffDateTo() == null) {
			addMessageError("W0004", msg("message.requireOne"));
			flgValid = false;
		} else {
			Date docDateFrom = getSemmir005Bean().getCriteria().getEffDateFrom();
			Date docDateTo = getSemmir005Bean().getCriteria().getEffDateTo();
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
		}
		
		return flgValid;
	}
	
	public void getRowIdOnClick() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemmir005Bean().setTmpRowId(rowId);
	}
	
	
	@SuppressWarnings("unchecked")
	private void getMir005Srch() {
		
		IPremiumService service = (IPremiumService)getBean("premiumService");
		List resultList = null;
		
		try {
			resultList = service.querySPList(EQueryName.Q_PREMIUM_SRCH.name, semmir005Bean.getCriteria());
			if (resultList != null && !resultList.isEmpty()) {
				for (int i=0; i<resultList.size(); i++) {
					Mir005SP tmp = (Mir005SP)resultList.get(i);
//					tmp.setEffDate(convertYearENtoTH(tmp.getEffDate()));
//					tmp.setUpdateDt(convertYearENtoTH(tmp.getUpdateDt()));
					tmp.setEffDateStr(convertYearENtoTHStr(tmp.getEffDate()));
					tmp.setUpdateDtStr(convertYearENtoTHStr(tmp.getUpdateDt()));
				}
				
				semmir005Bean.setResultList(resultList);
				semmir005Bean.setRenderedMsgDataNotFound(false);
			} else {
				semmir005Bean.setResultList(null);
				semmir005Bean.setRenderedMsgDataNotFound(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public boolean doSearch() {
		boolean flag = false;
		semmir005Bean = getSemmir005Bean();
		
		if (validate()) {
			getMir005Srch();
		} else {
			semmir005Bean.setRenderedMsgFormSearch(true);
		}
		
		setSemmir005Bean(semmir005Bean);
		return flag;
	}
	
	public void doClear() {
		semmir005Bean = getSemmir005Bean();
		
		semmir005Bean.setCriteria(new Mir005SP());
		semmir005Bean.setResultList(null);
		semmir005Bean.setRenderedMsgFormSearch(false);
		semmir005Bean.setRenderedMsgDataNotFound(false);
		
		setSemmir005Bean(semmir005Bean);
	}
	
	private void initPopup() {
		semmir005Bean = getSemmir005Bean();
		
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		if (mode.equals("ADD")) {
			semmir005Bean.setTmpSave(new Mir005SP());
			semmir005Bean.setViewMode(false);
		} else if (mode.equals("EDIT")) {
			semmir005Bean.setViewMode(true);
			String rowId = (String)getFacesUtils().getRequestParameter("rowId");
			for (int i=0; i<semmir005Bean.getResultList().size(); i++) {
				Mir005SP tmp = (Mir005SP)semmir005Bean.getResultList().get(i);
				if (tmp.getRowId().equals(rowId)) {
					semmir005Bean.setTmpSave(new Mir005SP(tmp));
					break;
				}
			}
		}
		semmir005Bean.setActModeDisplay(mode);
		
		setSemmir005Bean(semmir005Bean);
	}
	
	private boolean validateSave() {
		boolean flgValid = true;
		
		if (StringUtils.isEmpty(getSemmir005Bean().getTmpSave().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		
		if (StringUtils.isEmpty(getSemmir005Bean().getTmpSave().getNetworkType())) {
			addMessageError("W0001", msg("message.networkType"));
			flgValid = false;
		}
		
		if (StringUtils.isEmpty(getSemmir005Bean().getTmpSave().getTransferType()) && "01".equals(getSemmir005Bean().getTmpSave().getPolicyType())) {
			addMessageError("W0001", msg("message.transferType"));
			flgValid = false;
		}
		
		if (StringUtils.isEmpty(getSemmir005Bean().getTmpSave().getPolicyType())) {
			addMessageError("W0001", msg("message.policy"));
			flgValid = false;
		}
		
		if (getSemmir005Bean().getTmpSave().getPremiumRate() == 0) {
			addMessageError("W0001", msg("message.premium"));
			flgValid = false;
		}
		
		if (getSemmir005Bean().getTmpSave().getEffDate() == null) {
			addMessageError("W0001", msg("message.effectiveDt"));
			flgValid = false;
		}
		
		return flgValid;
	}
	
	@SuppressWarnings("unchecked")
	private void doSave() {
		semmir005Bean = getSemmir005Bean();
		if (validateSave()) {
			IPremiumService service = (IPremiumService)getBean("premiumService");
			List resultList = null;
			semmir005Bean.getTmpSave().setCurrentUser(getUserLogIn());
			try {
				resultList = service.querySPList(EQueryName.Q_PREMIUM_EDT.name, semmir005Bean.getTmpSave());
				if (resultList != null && !resultList.isEmpty() && resultList.size() > 0) {
					Mir005SP tmp = (Mir005SP)resultList.get(0);
					if (tmp.getResult().equals("Success")) {
						addMessageInfo("M0001");
						semmir005Bean.setRenderedMsgFormSearch(true);
						semmir005Bean.setRenderedMsgFormTop(false);
						semmir005Bean.setPopupClose(true);
						if (semmir005Bean.getResultList() != null) {
							getMir005Srch();
						}
					} else {
						addGeneralMessageError(tmp.getMsgError());
						semmir005Bean.setRenderedMsgFormSearch(false);
						semmir005Bean.setRenderedMsgFormTop(true);
						semmir005Bean.setPopupClose(false);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			semmir005Bean.setRenderedMsgFormSearch(false);
			semmir005Bean.setRenderedMsgFormTop(true);
			semmir005Bean.setPopupClose(false);
		}
		setSemmir005Bean(semmir005Bean);
	}
	
	private void initDelete() {
		semmir005Bean = getSemmir005Bean();
		
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		semmir005Bean.setTmpDelId(rowId);
		
		setSemmir005Bean(semmir005Bean);
	}
	
	private void doDelete() {
		semmir005Bean = getSemmir005Bean();
		
		IPremiumService service = (IPremiumService)getBean("premiumService");
		Premium tmp = null;
		try {
			log.debug("semmir005Bean.getTmpDelId() = "+semmir005Bean.getTmpDelId());
			tmp = service.queryPremiumByRowId(semmir005Bean.getTmpDelId());
			if (tmp != null) {
				tmp.setCurrentUser(getUserLogIn());
				service.deletePremium(tmp);
				addMessageInfo("M0002");
				getMir005Srch();
			} else {
				addMessageError("E0002");
			}
		} catch (Exception e) {
			addMessageError("E0002");
			e.printStackTrace();
		}
		semmir005Bean.setRenderedMsgFormSearch(true);
		
		setSemmir005Bean(semmir005Bean);
	}
	
}
