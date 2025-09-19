package th.co.ais.web.ir.action;

import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.ir.Mir003SP;
import th.co.ais.domain.ir.Replacement;
import th.co.ais.service.gm.ILovMasterService;
import th.co.ais.service.ir.IReplacementService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.ir.bean.SEMMIR003Bean;
import th.co.ais.web.util.SelectItemLOVCacheUtil;

public class SEMMIR003Action extends AbstractAction {

	private static final long serialVersionUID = -8745622925985157882L;
	private Logger log = Logger.getLogger(getClass());
	private SEMMIR003Bean semmir003Bean;
	
	public SEMMIR003Bean getSemmir003Bean() {
		return (SEMMIR003Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmir003Bean");
	}

	public void setSemmir003Bean(SEMMIR003Bean semmir003Bean) {
		this.semmir003Bean = semmir003Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmir003Bean", semmir003Bean);
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
		semmir003Bean = new SEMMIR003Bean(getLovItemsByType(ELovType.T_COMPANY.name), 
				SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_IR_NETWORK_TYPES.name), 
				SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_IR_TRANSFER_TYPES.name));
		
		setSemmir003Bean(semmir003Bean);
	}

	@Override
	public boolean validate() {
		boolean flgValid = true;
		
		if (StringUtils.isEmpty(getSemmir003Bean().getCriteria().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		
		Date docDateFrom = getSemmir003Bean().getCriteria().getEffDateFrom();
		Date docDateTo = getSemmir003Bean().getCriteria().getEffDateTo();
		
		if(docDateFrom != null && docDateTo != null){
			if (docDateFrom.after(docDateTo)) {
				addMessageErrorWithArgument("W0006" ,msg("message.docDtForm"), msg("message.docDtTo"));
				flgValid = false;
			}
		}
		
		return flgValid;
	}
	
	public void getRowIdOnClick() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemmir003Bean().setTmpRowId(rowId);
	}
	
	
	@SuppressWarnings("unchecked")
	private void getMir003Srch() {
		
		ILovMasterService service = (ILovMasterService)getBean("lovMasterService");
		List resultList = null;
		
		try {
			resultList = service.querySPList(EQueryName.Q_REPLACEMENT_VALUE.name, semmir003Bean.getCriteria());
			if (resultList != null && !resultList.isEmpty()) {
				
				for (int i=0; i<resultList.size(); i++) {
					Mir003SP tmp = (Mir003SP)resultList.get(i);
//					tmp.setEffDate(convertYearENtoTH(tmp.getEffDate()));
//					tmp.setUpdateDt(convertYearENtoTH(tmp.getUpdateDt()));
					tmp.setEffDateStr(convertYearENtoTHStr(tmp.getEffDate()));
					tmp.setUpdateDtStr(convertYearENtoTHStr(tmp.getUpdateDt()));
				}
				
				semmir003Bean.setResultList(resultList);
				semmir003Bean.setRenderedMsgDataNotFound(false);
			} else {
				semmir003Bean.setResultList(null);
				semmir003Bean.setRenderedMsgDataNotFound(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public boolean doSearch() {
		boolean flag = false;
		semmir003Bean = getSemmir003Bean();
		
		if (validate()) {
			getMir003Srch();
		} else {
			semmir003Bean.setRenderedMsgFormSearch(true);
			semmir003Bean.setRenderedMsgFormTop(true);
			semmir003Bean.setPopupClose(false);
		}
		
		setSemmir003Bean(semmir003Bean);
		return flag;
	}
	
	public void doClear() {
		semmir003Bean = getSemmir003Bean();
		
		semmir003Bean.setCriteria(new Mir003SP());
		semmir003Bean.setResultList(null);
		semmir003Bean.setRenderedMsgFormSearch(false);
		semmir003Bean.setRenderedMsgDataNotFound(false);
		
		setSemmir003Bean(semmir003Bean);
	}
	
	private void initPopup() {
		semmir003Bean = getSemmir003Bean();
		
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		if (mode.equals("ADD")) {
			semmir003Bean.setTmpSave(new Mir003SP());
			semmir003Bean.getTmpSave().setRowId(null);
			semmir003Bean.setViewMode(false);
		} else if (mode.equals("EDIT")) {
			semmir003Bean.setViewMode(true);
			String replId = (String)getFacesUtils().getRequestParameter("replId");
			for (int i=0; i<semmir003Bean.getResultList().size(); i++) {
				Mir003SP tmp = (Mir003SP)semmir003Bean.getResultList().get(i);
				if (tmp.getRowId().equals(replId)) {
					semmir003Bean.setTmpSave(new Mir003SP(tmp));
					break;
				}
			}
		}
		semmir003Bean.setActModeDisplay(mode);
		
		setSemmir003Bean(semmir003Bean);
	}
	
	private boolean validateSave() {
		boolean flgValid = true;
		
		if (StringUtils.isEmpty(getSemmir003Bean().getTmpSave().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		
		if (StringUtils.isEmpty(getSemmir003Bean().getTmpSave().getNetworkType())) {
			addMessageError("W0001", msg("message.networkType"));
			flgValid = false;
		}
		
		if (StringUtils.isEmpty(getSemmir003Bean().getTmpSave().getTransferType())) {
			addMessageError("W0001", msg("message.transferType"));
			flgValid = false;
		}
		
		if (getSemmir003Bean().getTmpSave().getReplRate() == 0) {
			addMessageError("W0001", msg("message.replacement"));
			flgValid = false;
		}
		
		if (getSemmir003Bean().getTmpSave().getEffDate() == null) {
			addMessageError("W0001", msg("message.effectiveDt"));
			flgValid = false;
		}
		
		return flgValid;
	}
	
	@SuppressWarnings("unchecked")
	private void doSave() {
		semmir003Bean = getSemmir003Bean();
		if (validateSave()) {
			ILovMasterService service = (ILovMasterService)getBean("lovMasterService");
			List resultList = null;
			semmir003Bean.getTmpSave().setCurrentUser(getUserLogIn());
			try {
				resultList = service.querySPList(EQueryName.Q_REPLACEMENT_VALUE_EDT.name, semmir003Bean.getTmpSave());
				if (resultList != null && !resultList.isEmpty() && resultList.size() > 0) {
					Mir003SP tmp = (Mir003SP)resultList.get(0);
					if (tmp.getResult().equals("Success")) {
						addMessageInfo("M0001");
						semmir003Bean.setRenderedMsgFormSearch(true);
						semmir003Bean.setRenderedMsgFormTop(false);
						semmir003Bean.setPopupClose(true);
						if (semmir003Bean.getResultList() != null) {
							getMir003Srch();
						}
					} else {
						// TODO
						addGeneralMessageError(tmp.getMsgError());
						semmir003Bean.setRenderedMsgFormSearch(false);
						semmir003Bean.setRenderedMsgFormTop(true);
						semmir003Bean.setPopupClose(false);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			semmir003Bean.setRenderedMsgFormSearch(false);
			semmir003Bean.setRenderedMsgFormTop(true);
			semmir003Bean.setPopupClose(false);
		}
		setSemmir003Bean(semmir003Bean);
	}
	
	private void initDelete() {
		semmir003Bean = getSemmir003Bean();
		
		String replId = (String)getFacesUtils().getRequestParameter("replId");
		semmir003Bean.setTmpDelId(replId);
		
		setSemmir003Bean(semmir003Bean);
	}
	
	private void doDelete() {
		semmir003Bean = getSemmir003Bean();
		
		IReplacementService service = (IReplacementService)getBean("replacementService");
		Replacement tmp = null;
		try {
			tmp = service.queryReplacementByRowId(semmir003Bean.getTmpDelId());
			if (tmp != null) {
				tmp.setCurrentUser(getUserLogIn());
				service.deleteReplacement(tmp);
				addMessageInfo("M0002");
				getMir003Srch();
			} else {
				addMessageError("E0002");
			}
		} catch (Exception e) {
			addMessageError("E0002");
			e.printStackTrace();
		}
		semmir003Bean.setRenderedMsgFormSearch(true);
		
		setSemmir003Bean(semmir003Bean);
	}
	
}
