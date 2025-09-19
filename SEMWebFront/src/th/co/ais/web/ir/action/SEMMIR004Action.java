package th.co.ais.web.ir.action;

import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.ir.Deduct;
import th.co.ais.domain.ir.Mir004SP;
import th.co.ais.service.ir.IDeductibleService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.ir.bean.SEMMIR004Bean;
import th.co.ais.web.util.SelectItemLOVCacheUtil;

public class SEMMIR004Action extends AbstractAction {

	private static final long serialVersionUID = -8745622925985157882L;
	private Logger log = Logger.getLogger(getClass());
	
	private SEMMIR004Bean semmir004Bean;
	
	
	public SEMMIR004Bean getSemmir004Bean() {
		return (SEMMIR004Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmir004Bean");
	}

	public void setSemmir004Bean(SEMMIR004Bean semmir004Bean) {
		this.semmir004Bean = semmir004Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmir004Bean", semmir004Bean);
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
		semmir004Bean = new SEMMIR004Bean(getLovItemsByType(ELovType.T_COMPANY.name), 
				SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_IR_NETWORK_TYPES.name), 
				SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_IR_TRANSFER_TYPES.name), 
				SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_IR_LOSS_TYPE.name));
		
		setSemmir004Bean(semmir004Bean);
	}

	@Override
	public boolean validate() {
		boolean flgValid = true;
		
		if (StringUtils.isEmpty(getSemmir004Bean().getCriteria().getCompany()) && 
				StringUtils.isEmpty(getSemmir004Bean().getCriteria().getNetworkType()) && 
				StringUtils.isEmpty(getSemmir004Bean().getCriteria().getTransferType()) && 
				getSemmir004Bean().getCriteria().getEffDateFrom() == null && 
				getSemmir004Bean().getCriteria().getEffDateTo() == null) {
			addMessageError("W0004", msg("message.requireOne"));
			flgValid = false;
		} else {
			Date docDateFrom = getSemmir004Bean().getCriteria().getEffDateFrom();
			Date docDateTo = getSemmir004Bean().getCriteria().getEffDateTo();
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
		getSemmir004Bean().setTmpRowId(rowId);
	}
	
	
	@SuppressWarnings("unchecked")
	private void getMir004Srch() {
		
		IDeductibleService service = (IDeductibleService)getBean("deductibleService");
		List resultList = null;
		
		try {
			resultList = service.querySPList(EQueryName.Q_DEDUCTIBLE.name, semmir004Bean.getCriteria());
			if (resultList != null && !resultList.isEmpty()) {
				for (int i=0; i<resultList.size(); i++) {
					Mir004SP tmp = (Mir004SP)resultList.get(i);
//					tmp.setEffDate(convertYearENtoTH(tmp.getEffDate()));
//					tmp.setUpdateDt(convertYearENtoTH(tmp.getUpdateDt()));
					tmp.setEffDateStr(convertYearENtoTHStr(tmp.getEffDate()));
					tmp.setUpdateDtStr(convertYearENtoTHStr(tmp.getUpdateDt()));
				}
				
				semmir004Bean.setResultList(resultList);
				semmir004Bean.setRenderedMsgDataNotFound(false);
			} else {
				semmir004Bean.setResultList(null);
				semmir004Bean.setRenderedMsgDataNotFound(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private boolean doSearch() {
		boolean flag = false;
		semmir004Bean = getSemmir004Bean();
		
		if (validate()) {
			getMir004Srch();
		} else {
			semmir004Bean.setRenderedMsgFormSearch(true);
		}
		
		setSemmir004Bean(semmir004Bean);
		return flag;
	}
	
	private void doClear() {
		semmir004Bean = getSemmir004Bean();
		
		semmir004Bean.setCriteria(new Mir004SP());
		semmir004Bean.setResultList(null);
		semmir004Bean.setRenderedMsgFormSearch(false);
		semmir004Bean.setRenderedMsgDataNotFound(false);
		
		setSemmir004Bean(semmir004Bean);
	}
	
	private void initPopup() {
		semmir004Bean = getSemmir004Bean();
		
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		if (mode.equals("ADD")) {
			semmir004Bean.setTmpSave(new Mir004SP());
			semmir004Bean.setViewMode(false);
		} else if (mode.equals("EDIT")) {
			semmir004Bean.setViewMode(true);
			String rowId = (String)getFacesUtils().getRequestParameter("rowId");
			for (int i=0; i<semmir004Bean.getResultList().size(); i++) {
				Mir004SP tmp = (Mir004SP)semmir004Bean.getResultList().get(i);
				if (tmp.getRowId().equals(rowId)) {
					semmir004Bean.setTmpSave(new Mir004SP(tmp));
					break;
				}
			}
		}
		semmir004Bean.setActModeDisplay(mode);
		
		setSemmir004Bean(semmir004Bean);
	}
	
	private boolean validateSave() {
		boolean flgValid = true;
		
		if (StringUtils.isEmpty(getSemmir004Bean().getTmpSave().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		
		if (StringUtils.isEmpty(getSemmir004Bean().getTmpSave().getNetworkType())) {
			addMessageError("W0001", msg("message.networkType"));
			flgValid = false;
		}
		
		if (StringUtils.isEmpty(getSemmir004Bean().getTmpSave().getTransferType())) {
			addMessageError("W0001", msg("message.transferType"));
			flgValid = false;
		}
		
		if (getSemmir004Bean().getTmpSave().getEffDate() == null) {
			addMessageError("W0001", msg("message.effectiveDt"));
			flgValid = false;
		}
		
		return flgValid;
	}
	
	@SuppressWarnings("unchecked")
	private void doSave() {
		semmir004Bean = getSemmir004Bean();
		if (validateSave()) {
			IDeductibleService service = (IDeductibleService)getBean("deductibleService");
			List resultList = null;
			semmir004Bean.getTmpSave().setCurrentUser(getUserLogIn());
			try {
				resultList = service.querySPList(EQueryName.Q_DEDUCTIBLE_EDT.name, semmir004Bean.getTmpSave());
				if (resultList != null && !resultList.isEmpty() && resultList.size() > 0) {
					Mir004SP tmp = (Mir004SP)resultList.get(0);
					if (tmp.getResult().equals("Success")) {
						addMessageInfo("M0001");
						semmir004Bean.setRenderedMsgFormSearch(true);
						semmir004Bean.setRenderedMsgFormTop(false);
						semmir004Bean.setPopupClose(true);
						if (semmir004Bean.getResultList() != null) {
							getMir004Srch();
						}
					} else {
						// TODO
						addGeneralMessageError(tmp.getMsgError());
						semmir004Bean.setRenderedMsgFormSearch(false);
						semmir004Bean.setRenderedMsgFormTop(true);
						semmir004Bean.setPopupClose(false);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			semmir004Bean.setRenderedMsgFormSearch(false);
			semmir004Bean.setRenderedMsgFormTop(true);
			semmir004Bean.setPopupClose(false);
		}
		setSemmir004Bean(semmir004Bean);
	}
	
	private void initDelete() {
		semmir004Bean = getSemmir004Bean();
		
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		semmir004Bean.setTmpDelId(rowId);
		
		setSemmir004Bean(semmir004Bean);
	}
	
	private void doDelete() {
		semmir004Bean = getSemmir004Bean();
		
		IDeductibleService service = (IDeductibleService)getBean("deductibleService");
		Deduct tmp = null;
		try {
			tmp = service.queryDeductibleByRowId(semmir004Bean.getTmpDelId());
			if (tmp != null) {
				tmp.setCurrentUser(getUserLogIn());
				service.deleteDeduct(tmp);
				addMessageInfo("M0002");
				getMir004Srch();
			} else {
				addMessageError("E0002");
			}
		} catch (Exception e) {
			addMessageError("E0002");
			e.printStackTrace();
		}
		semmir004Bean.setRenderedMsgFormSearch(true);
		
		setSemmir004Bean(semmir004Bean);
	}
	
}
