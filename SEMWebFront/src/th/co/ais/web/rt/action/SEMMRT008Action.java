package th.co.ais.web.rt.action;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.rt.PettyCash;
import th.co.ais.domain.rt.PettyCashSP;
import th.co.ais.service.rt.IPettyCashService;
import th.co.ais.service.util.ServiceConstants;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.rt.bean.SEMMRT008Bean;

public class SEMMRT008Action extends AbstractAction {
	
	private Logger LOG = Logger.getLogger(getClass());
	
	public static final String EVENT_ADD = "Add";
	public static final String EVENT_EDIT = "Edit";
	public static final String EVENT_CLEAR = "Clear";
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		LOG.info("- - actionWithNavi - -");
		
		if (methodWithNavi.equalsIgnoreCase("doSearch")) {
			flag = doSearch();
		} else if (methodWithNavi.equalsIgnoreCase("doClear")) {
			flag = doClear();
		} else if (methodWithNavi.equalsIgnoreCase("doClearSession")) {
			flag = doClearSession();
		}else if(methodWithNavi.equalsIgnoreCase("initDelPettyCash")){
			flag = initDelPettyCash();
		}else if(methodWithNavi.equalsIgnoreCase("popupLoad")){
			flag = popupLoad();
		}else if(methodWithNavi.equalsIgnoreCase("doSave")){
			flag = doSave();
		}else if(methodWithNavi.equalsIgnoreCase("doDefaultDate")){
			flag = doDefaultDate();
		}else if(methodWithNavi.equalsIgnoreCase("doDelPettyCash")){
			flag = doDelPettyCash();
		}else if(methodWithNavi.equalsIgnoreCase("getReceiveBalance")){
			flag = getReceiveBalance();
		}else if(methodWithNavi.equalsIgnoreCase("getClearBalance")){
			flag = getClearBalance();
		}else if(methodWithNavi.equalsIgnoreCase("validateCompany")){
			flag = validateCompany();
			if(!flag)
			setClearAndBalanceAmt();
		}
		return flag;
	}
	
	
	public boolean getReceiveBalance(){
		boolean flag = false;
		
		SEMMRT008Bean rt008Bean = getSemmrt008Bean();
		Double pettyCashAmt = rt008Bean.getPettyCash().getPettyCashAmt();
		Double balanceAmt = new Double(0.0);
		try {
			if(ServiceConstants.MODULE_ACTION_INSERT.equals(rt008Bean.getMode())){
			IPettyCashService service = (IPettyCashService)getBean("pettyCashService");
				String company = rt008Bean.getPettyCash().getCompany();
				Double bfAmt = service.getLastBalanceAmt(company);
				//balance amount
				balanceAmt = calEditBalanceAmtAdd(bfAmt, pettyCashAmt);
				
			}else if(ServiceConstants.MODULE_ACTION_UPDATE.equals(rt008Bean.getMode())){
				Double bfAmt = rt008Bean.getPettyCash().getBfAmt();
				//balance amount
				balanceAmt = calEditBalanceAmtAdd(bfAmt, pettyCashAmt);
			}
			
			rt008Bean.getPettyCash().setBalanceAmt(balanceAmt);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setSemmrt008Bean(rt008Bean);
		return flag;
	}
	
	public boolean getClearBalance(){
		boolean flag = false;
		
		SEMMRT008Bean rt008Bean = getSemmrt008Bean();
		Double clearAmt = rt008Bean.getPettyCash().getClearAmt();
		Double balanceAmt = new Double(0.0);
		try {
			
			if(ServiceConstants.MODULE_ACTION_INSERT.equals(rt008Bean.getMode())){
				IPettyCashService service = (IPettyCashService)getBean("pettyCashService");
				String company = rt008Bean.getPettyCash().getCompany();
				Double bfAmt = service.getLastBalanceAmt(company);
				//balance amount
				balanceAmt = calEditBalanceAmtClear(bfAmt, clearAmt);
				
			}else if(ServiceConstants.MODULE_ACTION_UPDATE.equals(rt008Bean.getMode())){
				Double bfAmt = rt008Bean.getPettyCash().getBfAmt();
				//balance amount
				balanceAmt = calEditBalanceAmtClear(bfAmt, clearAmt);
			}
			rt008Bean.getPettyCash().setBalanceAmt(balanceAmt);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setSemmrt008Bean(rt008Bean);
		return flag;
	}
	
	public boolean initDelPettyCash(){
		boolean flag = false;
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		SEMMRT008Bean rt008Bean = getSemmrt008Bean();
		
		IPettyCashService service = (IPettyCashService)getBean("pettyCashService");
		try {
			//prepare for editing ,set user login
			PettyCash pettyCash = service.queryPettyCashByRowId(rowId);
			pettyCash.setCurrentUser(rt008Bean.getUserLogin());
			rt008Bean.setPettyCash(pettyCash);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmrt008Bean(rt008Bean);
		return flag;
	}
	
	public boolean doDelPettyCash() {
		boolean falg = false;
		IPettyCashService service = (IPettyCashService)getBean("pettyCashService");
		SEMMRT008Bean rt008Bean = getSemmrt008Bean();
		
		try {
			service.deletePettyCash(rt008Bean.getPettyCash());
			doSearch();
			//Message in form search is not render. will be showing in panel result only.
			rt008Bean.setRenderedMsgFormSearch(false);
			addMessageInfo("incContent:frmSearchResult:pnlSearchResult", "M0002", "");
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError("incContent:frmSearchResult:pnlSearchResult", "E0002", "");
		}
		return falg;
	}
	private boolean doClearSession() {
		boolean flag = true;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("semmrt008Bean");
		return flag;
	}

	private boolean doClear() {
		boolean flag = false;
		//clear search criteria.
		getSemmrt008Bean().setTmpPettyCash(null);
		//clear data table.
		getSemmrt008Bean().setPettyCashList(null);
		//clear msg data not found.
		getSemmrt008Bean().setRenderedMsgDataNotFound(false);
		return flag;
	}
	
	private boolean doDefaultDate(){
		boolean flag = false;
		SEMMRT008Bean semmrt008Bean = getSemmrt008Bean();
		Date receiveDtFrom = semmrt008Bean.getTmpPettyCash().getReceiveDtFrom();
		Date receiveDtTo = semmrt008Bean.getTmpPettyCash().getReceiveDtTo();
		Date clearDtFrom = semmrt008Bean.getTmpPettyCash().getClearDtFrom();
		Date clearDtTo = semmrt008Bean.getTmpPettyCash().getClearDtTo();
		
		LOG.info("receiveDtFrom :" + receiveDtFrom);
		LOG.info("receiveDtTo :" + receiveDtTo);
		LOG.info("clearDtFrom :" + clearDtFrom);
		LOG.info("clearDtTo :" + clearDtTo);
		
		if(receiveDtFrom != null)
			if(receiveDtTo == null)
			return defaultReceiveFromToDt(receiveDtFrom);
		
		if(receiveDtTo != null)
			if(receiveDtFrom == null)
			return defaultReceiveFromToDt(receiveDtTo);
		
		if(clearDtFrom != null)
			if(clearDtTo == null)
			return defaultClearFromToDt(clearDtFrom);
		
		if(clearDtTo != null)
			if(clearDtFrom == null)
			return defaultClearFromToDt(clearDtTo);
		
		setSemmrt008Bean(semmrt008Bean);
		return flag; 
	}	
	
	private boolean defaultClearFromToDt(Date selDt){
		boolean flag = false;
		SEMMRT008Bean semmrt008Bean = getSemmrt008Bean();
		semmrt008Bean.getTmpPettyCash().setClearDtFrom(selDt);
		semmrt008Bean.getTmpPettyCash().setClearDtTo(selDt);
		setSemmrt008Bean(semmrt008Bean);
		return flag;
	}
	private boolean defaultReceiveFromToDt(Date selDt){
		boolean flag = false;
		SEMMRT008Bean semmrt008Bean = getSemmrt008Bean();
		semmrt008Bean.getTmpPettyCash().setReceiveDtFrom(selDt);
		semmrt008Bean.getTmpPettyCash().setReceiveDtTo(selDt);
		setSemmrt008Bean(semmrt008Bean);
		return flag;
	}
	private boolean doSearch() {
		SEMMRT008Bean semmrt008Bean = getSemmrt008Bean();
		//show message after submit search button.
		semmrt008Bean.setRenderedMsgFormSearch(true);
		boolean flag = false;
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		if(StringUtils.equals(mode, "SEARCH")){
			if(validateFormSearch()){
				return flag;
			}
		}
		IPettyCashService service = (IPettyCashService)getBean("pettyCashService");
		List<PettyCashSP> pettyCashList = null;
		semmrt008Bean.setPettyCashList(new ArrayList<WrapperBeanObject<PettyCashSP>>());
		try {
			
			pettyCashList = service.queryPettyCashSPList(EQueryName.SP_MRT008_SRCH.name, semmrt008Bean.getTmpPettyCash());
			
			if(pettyCashList != null && !pettyCashList.isEmpty()){
				 for(int i=0; i<pettyCashList.size(); i++){
					PettyCashSP pettyCash = (PettyCashSP)pettyCashList.get(i);
					WrapperBeanObject<PettyCashSP> tmpWrapperBean = new WrapperBeanObject<PettyCashSP>();
					
					//convert date to TH year for displaying.
					pettyCash.setClearDt(convertYearENtoTH(pettyCash.getClearDt()));
					pettyCash.setReceiveDt(convertYearENtoTH(pettyCash.getReceiveDt()));
					
					tmpWrapperBean.setDataObj(pettyCash);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					semmrt008Bean.getPettyCashList().add(tmpWrapperBean);
					semmrt008Bean.setRenderedMsgDataNotFound(false);
				 }
			 }else{
				 if(StringUtils.equals(mode, "SEARCH")){
				 semmrt008Bean.setRenderedMsgDataNotFound(true);
				 }
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmrt008Bean(semmrt008Bean);
		return flag;
	}
	
	private void setUserToPettyCash(SEMMRT008Bean rt008Bean){
		PettyCash pettyCash = rt008Bean.getPettyCash();
		pettyCash.setCurrentUser(getSemmrt008Bean().getUserLogin());
		rt008Bean.setPettyCash(pettyCash);
	}
//	private Double calAddBalanceAmtReceive(Double lastBalAmt, Double pettyCashAmt){
//		Double balAmt = new Double(0.0d);
//		balAmt = lastBalAmt + pettyCashAmt;
//		return balAmt;
//	}
//	
//	private Double calAddBalanceAmtClear(Double lastBalAmt, Double clearAmt){
//		Double balAmt = new Double(0.0d);
//		balAmt = lastBalAmt + clearAmt;
//		return balAmt;
//	}
	
	private Double calEditBalanceAmtAdd(Double bfAmt, Double pettyCashAmt){
		Double balAmt = new Double(0.0d);
		balAmt = bfAmt + pettyCashAmt;
		return balAmt;
	}
	
	private Double calEditBalanceAmtClear(Double bfAmt, Double pettyCashAmt){
		Double balAmt = new Double(0.0d);
		balAmt = bfAmt - pettyCashAmt;
		return balAmt;
	}
	
	private PettyCashSP checkMrt008(PettyCash p) throws Exception{
		IPettyCashService service =(IPettyCashService)getBean("pettyCashService");
		PettyCashSP property = new PettyCashSP();
		property.setCompany(p.getCompany());
		property.setRefClrBatchNo(p.getRefClrBatchNo());
		property.setReceiveDt(p.getReceiveDt());
		property.setClearDt(p.getClearDt());
		return service.mrt008Check(property);
	}
	private boolean doSave() {
		
		boolean flag = false;
		SEMMRT008Bean rt008Bean = getSemmrt008Bean();
		String eventType = (String)getFacesUtils().getRequestParameter("eventType");
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		//validation 
		if(StringUtils.equals(eventType, EVENT_ADD) || StringUtils.equals(eventType, EVENT_EDIT)) {
			if (validateFormSave()) {
				//do not show message in search form.
				rt008Bean.setRenderedMsgFormSearch(false);
				//set pop up open still
				rt008Bean.setPopupClose(new Boolean(false));
				return flag;
			}
		}else if (StringUtils.equals(eventType, EVENT_CLEAR)){
			if (validateFormClear()) {
				//do not show message in search form.
				rt008Bean.setRenderedMsgFormSearch(false);
				//set pop up open still
				rt008Bean.setPopupClose(new Boolean(false));
				return flag;
			}
		}
		
		try{
			IPettyCashService service =(IPettyCashService)getBean("pettyCashService");
			//set User
			setUserToPettyCash(rt008Bean);
			
			Double pettyCashAmt = rt008Bean.getPettyCash().getPettyCashAmt();
//			String company = rt008Bean.getPettyCash().getCompany();
			//balance amount
//			Double lastBalAmt = service.getLastBalanceAmt(company);
//			Double clearAmt = rt008Bean.getPettyCash().getClearAmt();
			
			String pettyCashType = rt008Bean.getPettyCash().getPettyCashType();
			pettyCashType = pettyCashType.trim();
			Boolean isPopupColse = true;
			if(ServiceConstants.MODULE_ACTION_INSERT.equals(mode)){
				//get Max sequence ID and set before inserting.
				BigDecimal maxSEQ = service.getSEQ("pettyCashSeq", PettyCash.class);
				rt008Bean.getPettyCash().setPettyCashSeq(maxSEQ);
				
				if(pettyCashAmt == null)
					pettyCashAmt = 0.0d;
				
				PettyCashSP result = checkMrt008(rt008Bean.getPettyCash());
				if(result != null){
					
					if(StringUtils.equals("Success", result.getStatusResult())){
						service.createPettyCash(rt008Bean.getPettyCash());
						isPopupColse = true;
						//showing message success in result panel
						addMessageInfo("incContent:frmSearchResult:pnlSearchResult", "M0001", "");
						
					}else{
						//set pop up close
						isPopupColse = false;
						addGeneralMessageError(result.getRemark());
					}
				}
					
//				Double balanceAmt = new Double(0.0d);
//				//petty cash type = 01
//				//calculate balance amount
//				if(StringUtils.equals(pettyCashType, "01")){
//					balanceAmt = calAddBalanceAmtReceive(lastBalAmt, pettyCashAmt);
//				}else if(StringUtils.equals(pettyCashType, "02")){ //petty cash type = 02
//					balanceAmt = calAddBalanceAmtClear(lastBalAmt, clearAmt);
//				}
//				//calculate balance amount
//				rt008Bean.getPettyCash().setBalanceAmt(balanceAmt);
				
				
			}else if(ServiceConstants.MODULE_ACTION_UPDATE.equals(mode)){
				
//				//petty cash type = 01
//				if(StringUtils.equals(pettyCashType, "01")){
//					Double balanceAmt = calEditBalanceAmtAdd(lastBalAmt, pettyCashAmt);
//					rt008Bean.getPettyCash().setBalanceAmt(balanceAmt);
//				}else if(StringUtils.equals(pettyCashType, "02")){ //petty cash type = 02
//					Double balanceAmt = calEditBalanceAmtClear(lastBalAmt, clearAmt);
//					rt008Bean.getPettyCash().setBalanceAmt(balanceAmt);
//				}
				PettyCash newPettyCash = service.updatePettyCash(rt008Bean.getPettyCash());
				rt008Bean.setPettyCash(newPettyCash);
				//showing message success in result panel
				addMessageInfo("incContent:frmSearchResult:pnlSearchResult", "M0001", "");
			}
			setSemmrt008Bean(rt008Bean);
			if(isPopupColse){
				//set pop up close
				rt008Bean.setPopupClose(new Boolean(true));
			}else{
				rt008Bean.setPopupClose(new Boolean(false));	
			}
			if(rt008Bean.getPettyCash() != null)
			rt008Bean.getTmpPettyCash().setCompany(rt008Bean.getPettyCash().getCompany());
			//search 
			doSearch();
			//do not show message in search form.
			rt008Bean.setRenderedMsgFormSearch(false);
			
		}catch(Exception e){
			e.printStackTrace();
			//set pop up close
			rt008Bean.setPopupClose(new Boolean(false));
			addMessageError("incContent:frmSearchResult:pnlSearchResult", "E0001", "");
		}
		return flag;
	}
	
	
	private PettyCash queryPettyCashByRowID(String rowId) throws Exception{
		IPettyCashService service = (IPettyCashService)getBean("pettyCashService");
		PettyCash pettyCash = service.queryPettyCashByRowId(rowId);
		getSemmrt008Bean().setPettyCash(pettyCash);
		return pettyCash;
	}
	
	private boolean popupLoad() {
		LOG.info("-- popupLoad --");
		boolean flag = true;
		String pettyCashType = (String)getFacesUtils().getRequestParameter("pettyCashType");
		String eventType = (String)getFacesUtils().getRequestParameter("eventType");
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		String bfAmt = (String)getFacesUtils().getRequestParameter("bfAmt");
		LOG.info("bfAmt :" + bfAmt);
		LOG.info("eventType :" + eventType);
		LOG.info("mode :" + mode);
		
		try {
			if(ServiceConstants.MODULE_ACTION_UPDATE.equals(mode)){
				
//				if(StringUtils.isNotBlank(bfAmt))
//				getSemmrt008Bean().getPettyCash().setBfAmt(new Double(bfAmt));
				
				//for displaying in pop up header
				if(StringUtils.equals(eventType, EVENT_EDIT)){
					getSemmrt008Bean().setActModeDisplay(EVENT_EDIT);
				}else if(StringUtils.equals(eventType, EVENT_CLEAR)){
					getSemmrt008Bean().setActModeDisplay(EVENT_CLEAR);
				}
				if(StringUtils.isNotEmpty(rowId)){
					if(StringUtils.equals(pettyCashType.trim(), "01")){
						getSemmrt008Bean().setPopupFormName("popupFrmRT008Save");
					}else if(StringUtils.equals(pettyCashType.trim(), "02")){
						getSemmrt008Bean().setPopupFormName("popupFrmRT008Clear");
					}
					queryPettyCashByRowID(rowId);
					if(bfAmt != null)
					getSemmrt008Bean().getPettyCash().setBfAmt(new Double(bfAmt));
					
				}
				//for inform mode when submit
				getSemmrt008Bean().setMode(ServiceConstants.MODULE_ACTION_UPDATE);
				
			}else if(ServiceConstants.MODULE_ACTION_INSERT.equals(mode)){
				//clear all of value.
				getSemmrt008Bean().setPettyCash(new PettyCash());
				if(StringUtils.equals(EVENT_ADD , eventType)){
					getSemmrt008Bean().getPettyCash().setPettyCashType("01");
				}else if(StringUtils.equals(EVENT_CLEAR, eventType)){
					getSemmrt008Bean().getPettyCash().setPettyCashType("02");
				}
				//for displaying in pop up header
				getSemmrt008Bean().setActModeDisplay(EVENT_ADD);
				//for inform mode when submit
				getSemmrt008Bean().setMode(ServiceConstants.MODULE_ACTION_INSERT);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	

 
	@Override
	public void clearSessionNotUsed() {
		
	}

	@Override
	public void init() {
		SEMMRT008Bean semmrt008Bean = new SEMMRT008Bean();
		semmrt008Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		setSemmrt008Bean(semmrt008Bean);
	}
	
	
	@Override
	public boolean validate() {
		boolean flagValid = false;
		
		return flagValid;
	}
	
	//validate form add/edit
	public boolean validateFormSave() {
		boolean flagValid = false;
		
		//validation add
		Date receiveDt = getSemmrt008Bean().getPettyCash().getReceiveDt();
		Double receiveAmt = getSemmrt008Bean().getPettyCash().getPettyCashAmt();
		String company = getSemmrt008Bean().getPettyCash().getCompany();
		if (StringUtils.isEmpty(company)) {
			addMessageError("W0001", msg("message.company"));
			flagValid = true;
		}
		if (receiveDt == null) {
			addMessageError("W0001", "received Date");
			flagValid = true;
		}
		if (receiveAmt == 0.0d || receiveAmt == null) {
			addMessageError("W0001", "received amount");
			flagValid = true;
		}
		
		return flagValid;
	}
	
	public boolean validateFormSearch() {
		boolean flagValid = false;
		
		if (StringUtils.isEmpty(getSemmrt008Bean().getTmpPettyCash().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flagValid = true;
		}
			
		
		SEMMRT008Bean semmrt008Bean = getSemmrt008Bean();
		Date receiveDtFrom = semmrt008Bean.getTmpPettyCash().getReceiveDtFrom();
		Date receiveDtTo = semmrt008Bean.getTmpPettyCash().getReceiveDtTo();
		Date clearDtFrom = semmrt008Bean.getTmpPettyCash().getClearDtFrom();
		Date clearDtTo = semmrt008Bean.getTmpPettyCash().getClearDtTo();
		
		LOG.info("receiveDtFrom :" + receiveDtFrom);
		LOG.info("receiveDtTo :" + receiveDtTo);
		LOG.info("clearDtFrom :" + clearDtFrom);
		LOG.info("clearDtTo :" + clearDtTo);
		
		
		
		if(receiveDtFrom != null && receiveDtTo != null){
			if (receiveDtFrom.after(receiveDtTo)) {
				addMessageErrorWithArgument("W0006" ,msg("message.bgStrDt"), msg("message.bgEndDt") );
				flagValid = true;
			}
		}
		if(clearDtFrom != null && clearDtTo != null){
			if (clearDtFrom.after(clearDtTo)) {
				addMessageErrorWithArgument("W0006" ,msg("message.ctlStrDt"), msg("message.ctlEndDt") );
				flagValid = true;
			}
		}
		return flagValid;
	}
	
	public boolean validateFormClear() {
		boolean flagValid = false;
		
		//validation clear
		Date clearDt = getSemmrt008Bean().getPettyCash().getClearDt();
		Double clearAmt = getSemmrt008Bean().getPettyCash().getClearAmt();
		String company = getSemmrt008Bean().getPettyCash().getCompany();
		String refClrBatchNo = getSemmrt008Bean().getPettyCash().getRefClrBatchNo();
		
		if (clearDt == null) {
			addMessageError("W0001", "clear Date");
			flagValid = true;
		}
		/*if (clearAmt == null || clearAmt == 0.0d) {
			addMessageError("W0001", "clear amount");
			flagValid = true;
		}*/
		if (StringUtils.isEmpty(company)) {
			addMessageError("W0001", msg("message.company"));
			flagValid = true;
		}
		
		if (StringUtils.isEmpty(refClrBatchNo)) {
			addMessageError("W0001", "Ref.Batch Clear");
			flagValid = true;
		}
			
		return flagValid;
	}
	
	public boolean validateCompany(){
		boolean flagValid = false;
		String company = getSemmrt008Bean().getPettyCash().getCompany();
		if (StringUtils.isEmpty(company)) {
			addMessageError("W0001", msg("message.company"));
			flagValid = true;
		}
		//do not show message in search form.
		getSemmrt008Bean().setRenderedMsgFormSearch(false);
		return flagValid;
	}
	
	public void setClearAndBalanceAmt(){
		try {
			IPettyCashService service = (IPettyCashService)getBean("pettyCashService");
			String company = getSemmrt008Bean().getPettyCash().getCompany();
			String refBatchClear = getSemmrt008Bean().getPettyCash().getRefClrBatchNo();
			PettyCashSP pettyCashSP = new PettyCashSP();
			pettyCashSP.setCompany(company);
			pettyCashSP.setRefClrBatchNo(refBatchClear);
			PettyCashSP result = service.mrt008BalanceAmount(pettyCashSP);
			
			Boolean isPopupColse = true;
			if(result != null){
				if(StringUtils.equals("Success", result.getStatusResult())){
					isPopupColse = true;
					//showing message success in result panel
					//addMessageInfo("incContent:frmSearchResult:pnlSearchResult", "M0001", "");
					getSemmrt008Bean().setDisabledBtnSaveClear(false);
					
				}else{
					//set pop up close
					isPopupColse = false;
					//do not show message in search form.
					getSemmrt008Bean().setRenderedMsgFormSearch(false);
					getSemmrt008Bean().setDisabledBtnSaveClear(true);
					addGeneralMessageError(result.getRemark());
				}
				getSemmrt008Bean().getPettyCash().setBalanceAmt(result.getBalanceAmt());
				getSemmrt008Bean().getPettyCash().setClearAmt(result.getClearAmt());
			}
			if(isPopupColse){
				//set pop up close
				getSemmrt008Bean().setPopupClose(new Boolean(true));
			}else{
				getSemmrt008Bean().setPopupClose(new Boolean(false));	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private SEMMRT008Bean semmrt008Bean;
	
	public SEMMRT008Bean getSemmrt008Bean() {
		return (SEMMRT008Bean)getFacesUtils().getSessionMapValue("semmrt008Bean");
	}

	public void setSemmrt008Bean(SEMMRT008Bean semmrt008Bean) {
		this.semmrt008Bean = semmrt008Bean;
		getFacesUtils().setSessionMapValue("semmrt008Bean", semmrt008Bean);
	}

}
