package th.co.ais.web.rt.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import th.co.ais.domain.rt.PettyCashMapPayment;
import th.co.ais.domain.rt.PettyCashMapPaymentSP;
import th.co.ais.domain.rt.PettyCashPay;
import th.co.ais.domain.rt.PettyCashPaySP;
import th.co.ais.rpt.util.bean.CellDomain;
import th.co.ais.rpt.util.bean.EnumDocStyleDomain;
import th.co.ais.rpt.util.bean.RowDomain;
import th.co.ais.rpt.util.enums.EnumDocStyle;
import th.co.ais.rpt.util.enums.EnumDocumentType;
import th.co.ais.service.gm.ILovMasterService;
import th.co.ais.service.rt.IPettyCashPayService;
import th.co.ais.service.util.ServiceConstants;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.report.util.DocumentExportManager;
import th.co.ais.web.rt.bean.SEMMRT008PayBean;
import th.co.ais.web.util.FacesUtils;

public class SEMMRT008PayAction extends AbstractAction {
	
	private Logger LOG = Logger.getLogger(getClass());
	
	public static final String EVENT_SEARCH = "Search";
	public static final String EVENT_ADD = "Add";
	public static final String EVENT_EDIT = "Edit";
	public static final String EVENT_CANCEL = "Cancel";
	public static final String EVENT_APPROVE = "Approve";
	
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
		}else if(methodWithNavi.equalsIgnoreCase("pageLoad")){
			flag = pageLoad();
		}else if(methodWithNavi.equalsIgnoreCase("doSave")){
			flag = doSave();
		}else if(methodWithNavi.equalsIgnoreCase("doDefaultDate")){
			flag = doDefaultDate();
		}else if(methodWithNavi.equalsIgnoreCase("initDelPettyCashPay")){
			flag = initDelPettyCashPay();
		}else if(methodWithNavi.equalsIgnoreCase("doDelPettyCash")){
			flag = doDelPettyCash();
		}else if(methodWithNavi.equalsIgnoreCase("doApprove")){
			flag = doApprove();
		}else if(methodWithNavi.equalsIgnoreCase("doCancel")){
			flag = doCancel();
		}else if(methodWithNavi.equalsIgnoreCase("getPettyCashPayNo")){
			flag = getPettyCashPayNo();
		}else if(methodWithNavi.equalsIgnoreCase("calIncRequestAmount")){
			flag = calIncRequestAmount();
		}else if(methodWithNavi.equalsIgnoreCase("initExportPropertyTax")){
			flag = initExportPropertyTax();
		}
		
		return flag;
	}
	
	private boolean initExportPropertyTax() {
		semmrt008PayBean = getSemmrt008PayBean();
		if(isCheckSELBox()==false){
			addMessageError("incContent:frmSearchResult:pnlSearchResult", "E0001", "");
			return false;
			}
		try {
		double totalIncReqAmt = 0;
		Collection<PettyCashPaySP> exList = new ArrayList<PettyCashPaySP>();
		semmrt008PayBean.setExList(new ArrayList<PettyCashPaySP>());
		semmrt008PayBean.setPettyCashPaySP(new PettyCashPaySP());
		semmrt008PayBean.setTotalIncRequestAmt(0);
		List<WrapperBeanObject<PettyCashPaySP>> detailList = new ArrayList<WrapperBeanObject<PettyCashPaySP>>();
		detailList = getSemmrt008PayBean().getPettyCashPayList();
		
		StringBuffer strBuff = new StringBuffer();
		
		int j=1;
		for(int i=0; i<detailList.size(); i++){
			WrapperBeanObject<PettyCashPaySP> detail = new WrapperBeanObject<PettyCashPaySP>();
			detail = detailList.get(i);
			if(detail.isCheckBox()){
				PettyCashPaySP tmp = new PettyCashPaySP();
				tmp = (PettyCashPaySP)detail.getDataObj();
				strBuff.append(tmp.getRowId());
				totalIncReqAmt += tmp.getIncRequestAmt();
				tmp.setNo(j++);
				exList.add(tmp);
			}
			
			if(i+1 != detailList.size())
			strBuff.append(",");
		}
		semmrt008PayBean.setExList(exList);
		semmrt008PayBean.setTotalIncRequestAmt(totalIncReqAmt);
//		EnumDocStyleDomain	defaultStyle	= new EnumDocStyleDomain(EnumDocStyle.CELL_DEFAULT);
		String pettyCashPayIds = strBuff.toString();
		LOG.info(pettyCashPayIds);
		//update export date
			PettyCashPaySP p = updateExportDt(pettyCashPayIds);
			semmrt008PayBean.setPettyCashPaySP(p);
			doSearch();
			onRenderExportButton();
			semmrt008PayBean.setDisplayReportFlag(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			semmrt008PayBean.setDisplayReportFlag(false);
		}
		return false;
	}

	public boolean calIncRequestAmount(){
		boolean flag = false;
		try {
			getIncReqAmt();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	private Double getExcReqAmt(){
		Double reqAmt = getSemmrt008PayBean().getPettyCashPay().getRequestAmt();
		String vatType = getSemmrt008PayBean().getPettyCashPay().getVatType();
		Double excReqAmt = new Double(0.0);
		
		try {
			ILovMasterService lovService = (ILovMasterService)FacesUtils.getInstance().getBean("lovMasterService");
			String strVatRate = lovService.getVatRate();
			
			Double vatRate = new Double(strVatRate);
			//include vat
			if(StringUtils.equals(vatType, "01")){
				excReqAmt = reqAmt/(1+(vatRate/100));
			}else{//exclude vat
				excReqAmt = reqAmt;
			}
			
			getSemmrt008PayBean().getPettyCashPay().setVatRate(vatRate);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return excReqAmt;
	}
	
	private Double getVatAmt(Double excReqAmt){
		Double vatAmt = new Double(0.0);
		try {
			String vatType = getSemmrt008PayBean().getPettyCashPay().getVatType();
			ILovMasterService lovService = (ILovMasterService)FacesUtils.getInstance().getBean("lovMasterService");
			String strVatRate = lovService.getVatRate();
			Double vatRate = new Double(strVatRate);
			if(StringUtils.equals(vatType, "03")){
				vatRate =  new Double(0.0);
			}
			vatAmt = excReqAmt*(vatRate/100);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vatAmt;
	}
	
	private Double getIncReqAmt(){
		Double incReqAmt = new Double(0.0);
		Double excReqAmt = getExcReqAmt();
		Double vatAmt = getVatAmt(excReqAmt);
		incReqAmt = getExcReqAmt() + vatAmt;
		
		getSemmrt008PayBean().getPettyCashPay().setVatAmt(vatAmt);
		getSemmrt008PayBean().getPettyCashPay().setExcRequestAmt(excReqAmt);
		getSemmrt008PayBean().getPettyCashPay().setIncRequestAmt(incReqAmt);
		return incReqAmt;
	}
	
	public boolean initDelPettyCashPay(){
		boolean flag = false;
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		SEMMRT008PayBean rt008PayBean = getSemmrt008PayBean();
		
		IPettyCashPayService service = (IPettyCashPayService)getBean("pettyCashPayService");
		try {
			//prepare for editing ,set user login
			PettyCashPay pettyCashPay = service.queryPettyCashPayByRowId(rowId);
			pettyCashPay.setCurrentUser(rt008PayBean.getUserLogin());
			rt008PayBean.setPettyCashPay(pettyCashPay);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmrt008PayBean(rt008PayBean);
		return flag;
	}
	
	public boolean doDelPettyCash() {
		boolean falg = false;
		IPettyCashPayService service = (IPettyCashPayService)getBean("pettyCashPayService");
		SEMMRT008PayBean rt008Bean = getSemmrt008PayBean();
		//Message in form search is not render. will be showing in panel result only.
		rt008Bean.setRenderedMsgFormSearch(false);
		try {
			service.deletePettyCashPay(rt008Bean.getPettyCashPay());
			doSearch();
			
			//do not show message in search form.
			rt008Bean.setRenderedMsgFormSearch(false);
			addMessageInfo("incContent:frmSearchResult:pnlSearchResult", "M0002", "");
			
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError("incContent:frmSearchResult:pnlSearchResult", "E0002", "");
		}
		rt008Bean.setRenderedMsgDataNotFound(false);
		return falg;
	}
	
	public boolean doCancel() {
		boolean falg = false;
		IPettyCashPayService service = (IPettyCashPayService)getBean("pettyCashPayService");
		SEMMRT008PayBean rt008Bean = getSemmrt008PayBean();
		try {
			List<WrapperBeanObject<PettyCashPaySP>> detailList = rt008Bean.getPettyCashPayList();
			for(int i=0; i<detailList.size(); i++){
				WrapperBeanObject<PettyCashPaySP> detail = new WrapperBeanObject<PettyCashPaySP>();
				detail = detailList.get(i);
				if(detail.isCheckBox()){
				PettyCashPaySP sp = (PettyCashPaySP)detail.getDataObj();
				
				PettyCashPay pettyCashPay = service.queryPettyCashPayByRowId(sp.getRowId());
//				PettyCashPay pettyCashPay = convertPayToPaySP(sp);
				pettyCashPay.setCurrentUser(rt008Bean.getUserLogin());
				pettyCashPay.setPettyCashPayStatus("03");
				service.updatePettyCashPay(pettyCashPay);
				}
			}
			doSearch();
			addMessageInfo("incContent:frmSearchResult:pnlSearchResult", "M0001", "");
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError("incContent:frmSearchResult:pnlSearchResult", "E0002", "");
		}
		rt008Bean.setRenderedMsgDataNotFound(false);
		return falg;
	}
	
	public boolean doApprove() {
		boolean falg = false;
		IPettyCashPayService service = (IPettyCashPayService)getBean("pettyCashPayService");
		SEMMRT008PayBean rt008Bean = getSemmrt008PayBean();
		try {
			List<WrapperBeanObject<PettyCashPaySP>> detailList = rt008Bean.getPettyCashPayList();
			for(int i=0; i<detailList.size(); i++){
				WrapperBeanObject<PettyCashPaySP> detail = new WrapperBeanObject<PettyCashPaySP>();
				detail = detailList.get(i);
				if(detail.isCheckBox()){
				PettyCashPaySP sp = (PettyCashPaySP)detail.getDataObj();
				
				PettyCashPay pettyCashPay = service.queryPettyCashPayByRowId(sp.getRowId());
				//PettyCashPay pettyCashPay = convertPayToPaySP(sp);
				pettyCashPay.setPettyCashPayStatus("02");
				pettyCashPay.setCurrentUser(rt008Bean.getUserLogin());
				service.updatePettyCashPay(pettyCashPay);
				}
			}
			doSearch();
			//do not show message in search form.
			rt008Bean.setRenderedMsgFormSearch(false);
			addMessageInfo("incContent:frmSearchResult:pnlSearchResult", "M0001", "");
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError("incContent:frmSearchResult:pnlSearchResult", "E0002", "");
		}
		rt008Bean.setRenderedMsgDataNotFound(false);
		return falg;
	}
	private PettyCashPay convertPayToPaySP(PettyCashPaySP sp){
		PettyCashPay p = new PettyCashPay();
		p.setRowId(sp.getRowId());
		p.setPettyCashPayNo(sp.getPettyCashPayNo());
		p.setCompany(sp.getCompany());
		p.setRegion(sp.getRegion());
		p.setRequestDt(sp.getRequestDt());
		p.setRequestName(sp.getRequestName());
		p.setRequestSubject(sp.getRequestSubject());
		p.setRequestAmt(sp.getRequestAmt());
		p.setVatType(sp.getVatType());
		p.setVatRate(sp.getVatRate());
		p.setVatAmt(sp.getVatAmt());
		p.setExcRequestAmt(sp.getExcRequestAmt());
		p.setIncRequestAmt(sp.getIncRequestAmt());
		p.setClrReceiptTaxFlag(sp.getClrReceiptTaxFlag());
		p.setReceiptTaxFlag(sp.getReceiptTaxFlag());
		p.setPettyCashPayStatus(sp.getPettyCashPayStatus());
		p.setRemark(sp.getRemark());
		p.setRecordStatus(sp.getRecordStatus());
		p.setVersion(sp.getVersion());
		return p;
	}
	
	private boolean doClearSession() {
		boolean flag = true;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("semmrt008PayBean");
		return flag;
	}

	private boolean doClear() {
		boolean flag = false;
		//clear search criteria.
		getSemmrt008PayBean().setTmpPettyCashPay(null);
		//clear data table.
		getSemmrt008PayBean().setPettyCashPayList(null);
		//clear msg data not found.
		getSemmrt008PayBean().setRenderedMsgDataNotFound(false);
		return flag;
	}
	
	private boolean doDefaultDate(){
		boolean flag = false;
		SEMMRT008PayBean semmrt008Bean = getSemmrt008PayBean();
		Date requestDtFrom = semmrt008Bean.getTmpPettyCashPay().getRequestDtFrom();
		Date requestDtTo = semmrt008Bean.getTmpPettyCashPay().getRequestDtTo();
		Date dueDtFrom = semmrt008Bean.getTmpPettyCashPay().getDueDtFrom();
		Date dueDtTo = semmrt008Bean.getTmpPettyCashPay().getDueDtTo();
		
		LOG.info("requestDtFrom :" + requestDtFrom);
		LOG.info("requestDtTo :" + requestDtTo);
		LOG.info("dueDtFrom :" + dueDtFrom);
		LOG.info("dueDtTo :" + dueDtTo);
		
		if(requestDtFrom != null)
			if(requestDtTo == null)
			return defaultRequestFromToDt(requestDtFrom);
		
		if(requestDtTo != null)
			if(requestDtFrom == null)
			return defaultRequestFromToDt(requestDtTo);
		
		if(dueDtFrom != null)
			if(dueDtTo == null)
			return defaultDueFromToDt(dueDtFrom);
		
		if(dueDtTo != null)
			if(dueDtFrom == null)
			return defaultDueFromToDt(dueDtTo);
		
		setSemmrt008PayBean(semmrt008Bean);
		return flag; 
	}	
	
	private boolean defaultDueFromToDt(Date selDt){
		boolean flag = false;
		SEMMRT008PayBean semmrt008Bean = getSemmrt008PayBean();
		semmrt008Bean.getTmpPettyCashPay().setDueDtFrom(selDt);
		semmrt008Bean.getTmpPettyCashPay().setDueDtTo(selDt);
		setSemmrt008PayBean(semmrt008Bean);
		return flag;
	}
	private boolean defaultRequestFromToDt(Date selDt){
		boolean flag = false;
		SEMMRT008PayBean semmrt008Bean = getSemmrt008PayBean();
		semmrt008Bean.getTmpPettyCashPay().setRequestDtFrom(selDt);
		semmrt008Bean.getTmpPettyCashPay().setRequestDtTo(selDt);
		setSemmrt008PayBean(semmrt008Bean);
		return flag;
	}
	private boolean doSearch() {
		SEMMRT008PayBean rt008PayBean = getSemmrt008PayBean();
		//show message after submit search button.
		rt008PayBean.setRenderedMsgFormSearch(true);
		boolean flag = false;
		
		if(validateFormSearch()){
			return flag;
		}
		IPettyCashPayService service = (IPettyCashPayService)getBean("pettyCashPayService");
		List<PettyCashPaySP> pettyCashPayList = null;
		rt008PayBean.setPettyCashPayList(new ArrayList<WrapperBeanObject<PettyCashPaySP>>());
		try {
			
			pettyCashPayList = service.querySPList(EQueryName.SP_MRT008PAY_SRCH.name, rt008PayBean.getTmpPettyCashPay());
			
			if(pettyCashPayList != null && !pettyCashPayList.isEmpty()){
				 Double totalAmount = new Double(0.0);
				 PettyCashPaySP pettyCashPay = new PettyCashPaySP();
				 for(int i=0; i<pettyCashPayList.size(); i++){
					pettyCashPay = (PettyCashPaySP)pettyCashPayList.get(i);
					WrapperBeanObject<PettyCashPaySP> tmpWrapperBean = new WrapperBeanObject<PettyCashPaySP>();
					
					//convert date to TH year for displaying.
					pettyCashPay.setRequestDt(convertYearENtoTH(pettyCashPay.getRequestDt()));
					pettyCashPay.setEffectiveDt(convertYearENtoTH(pettyCashPay.getEffectiveDt()));
					pettyCashPay.setExpireDt(convertYearENtoTH(pettyCashPay.getExpireDt()));
					pettyCashPay.setDueDt(convertYearENtoTH(pettyCashPay.getDueDt()));
					pettyCashPay.setExportDt(convertYearENtoTH(pettyCashPay.getExportDt()));
					pettyCashPay.setTaxInvoiceDt(convertYearENtoTH(pettyCashPay.getTaxInvoiceDt()));
//					totalAmount += pettyCashPay.getRequestAmt();
					totalAmount += pettyCashPay.getIncRequestAmt();
					tmpWrapperBean.setDataObj(pettyCashPay);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					rt008PayBean.getPettyCashPayList().add(tmpWrapperBean);
					//do not show message in search form.
					rt008PayBean.setRenderedMsgFormSearch(true);
					rt008PayBean.setRenderedMsgDataNotFound(false);
				 }
				 getSemmrt008PayBean().setChkSelAll(false);
				 getSemmrt008PayBean().getTmpPettyCashPay().setTotalAmount(totalAmount);
				 
			 }else{
				 //do not show message in search form.
				 rt008PayBean.setRenderedMsgFormSearch(false);
				 rt008PayBean.setRenderedMsgDataNotFound(true);
			 }
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			//always set disabled button.
			getSemmrt008PayBean().setDisabledBtnExport(true);
		}
		setSemmrt008PayBean(rt008PayBean);
		return flag;
	}
	
	private void setUserToPettyCashPay(SEMMRT008PayBean rt008Bean){
		PettyCashPay pettyCashPay = rt008Bean.getPettyCashPay();
		pettyCashPay.setCurrentUser(getSemmrt008PayBean().getUserLogin());
		rt008Bean.setPettyCashPay(pettyCashPay);
	}
	
	private boolean doSave() {
		
		boolean flag = false;
		SEMMRT008PayBean rt008PayBean = getSemmrt008PayBean();
		String eventType = (String)getFacesUtils().getRequestParameter("eventType");
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		//validation 
		if(StringUtils.equals(eventType, EVENT_ADD) || StringUtils.equals(eventType, EVENT_EDIT)) {
			if (validateFormSave()) {
				return flag;
			}
		}
		
		try{
			IPettyCashPayService service =(IPettyCashPayService)getBean("pettyCashPayService");
			//set User
			setUserToPettyCashPay(rt008PayBean);
			PettyCashPay newPettyCashPay = new PettyCashPay();
			if(ServiceConstants.MODULE_ACTION_INSERT.equals(mode)){
				
				PettyCashPay pettyCashPay = getSemmrt008PayBean().getPettyCashPay();
				String runningNo = service.getRunningNo("PETTY_CASH_PAY", pettyCashPay.getPettyCashPayNo());
				//set running no by company selected
				rt008PayBean.getPettyCashPay().setPettyCashPayNo(runningNo);
				//set expenseType = 99
				rt008PayBean.getPettyCashPay().setExpenseType("99");
				newPettyCashPay = service.createPettyCashPay(rt008PayBean.getPettyCashPay());
				//showing message success in result panel
				addMessageInfo("M0001");
				
			}else if(ServiceConstants.MODULE_ACTION_UPDATE.equals(mode)){
				
//				PettyCashPay pettyCashPay = service.updatePettyCashPay(rt008PayBean.getPettyCashPay());
//				rt008PayBean.setPettyCashPay(pettyCashPay);
				if(StringUtils.equals(eventType, "Approve")){
					getSemmrt008PayBean().getPettyCashPay().setPettyCashPayStatus("02");
					getSemmrt008PayBean().getPettyCashPay().setCurrentUser(getUserLogIn());
				}else if(StringUtils.equals(eventType, "Cancel")){
					getSemmrt008PayBean().getPettyCashPay().setPettyCashPayStatus("03");
					getSemmrt008PayBean().getPettyCashPay().setCurrentUser(getUserLogIn());
				}
				newPettyCashPay = service.updatePettyCashPay(rt008PayBean.getPettyCashPay());
				//showing message success in result panel
				addMessageInfo("M0001");
			}
			rt008PayBean.setPettyCashPay(newPettyCashPay);
			//set pop up close
			rt008PayBean.setPopupClose(new Boolean(true));
			//search 
//			doSearch();
			//do not show message in search form.
			rt008PayBean.setRenderedMsgFormSearch(false);
			setSemmrt008PayBean(rt008PayBean);
		}catch(Exception e){
			e.printStackTrace();
			//set pop up close
			rt008PayBean.setPopupClose(new Boolean(false));
			addMessageError("E0001");
		}
		return flag;
	}
	
	private PettyCashPay queryPettyCashPayByRowID(String rowId) throws Exception{
		IPettyCashPayService service = (IPettyCashPayService)getBean("pettyCashPayService");
		PettyCashPay pettyCashPay = service.queryPettyCashPayByRowId(rowId);
		getSemmrt008PayBean().setPettyCashPay(pettyCashPay);
		return pettyCashPay;
	}
	
	private List<PettyCashMapPaymentSP> queryPettyCashMapPaymentSP(Object property) throws Exception{
		IPettyCashPayService service = (IPettyCashPayService)getBean("pettyCashPayService");
		List<PettyCashMapPaymentSP> mapPayments = (List<PettyCashMapPaymentSP>)service.querySPList(EQueryName.SP_MRT008_SRCH_MAP_PAY.name, property);
		getSemmrt008PayBean().setPettyCashMapPaySPList(mapPayments);
		return mapPayments;
	}

	private boolean isRenderPanelPaymenInfo(String rowId) throws Exception{
		IPettyCashPayService service = (IPettyCashPayService)getBean("pettyCashPayService");
		Integer t = service.getCountByRowId("rowId", PettyCashMapPayment.class, rowId);
		if(t > 0)
		return true;
		else
		return false;
	}
	
	private boolean pageLoad() {
		LOG.info("-- pageLoad --");
		boolean flag = true;
		String eventType = (String)getFacesUtils().getRequestParameter("eventType");
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		
		LOG.info("eventType :" + eventType);
		LOG.info("mode :" + mode);
		
		try {
			if(ServiceConstants.MODULE_ACTION_UPDATE.equals(mode)){
				//set ddl company to read only.
				getSemmrt008PayBean().setReadOnlyCompany(true);
				
				
				//for displaying in pop up header
				if(StringUtils.equals(eventType, EVENT_EDIT)){
					String rowId = (String)getFacesUtils().getRequestParameter("rowId");
					//query data for rendering on panel edit
					queryPettyCashPayByRowID(rowId);
					String company = (String)getFacesUtils().getRequestParameter("companyName");
					getSemmrt008PayBean().setActModeDisplay(EVENT_EDIT);
					if(StringUtils.isNotEmpty(rowId)){
						
						//set criteria
						PettyCashMapPaymentSP criteria = new PettyCashMapPaymentSP();
						criteria.setRowId(rowId);
						criteria.setCompany(company);
						//query petty cash map pay for showing
						queryPettyCashMapPaymentSP(criteria);
						if(isRenderPanelPaymenInfo(rowId))
						getSemmrt008PayBean().setRenderedPanelPaymentInfo(true);
						else
						getSemmrt008PayBean().setRenderedPanelPaymentInfo(false);
						
						
					}
				}else if(StringUtils.equals(eventType, EVENT_APPROVE)){
					getSemmrt008PayBean().setActModeDisplay(EVENT_APPROVE);
					if(StringUtils.equals(getNavPrograme(), "semmrt008pay-4")){
						if(isAuthent()){
							//show dialog
							getSemmrt008PayBean().setRenderedDailog(true);
						}else{
							addMessageError("incContent:frmSearchResult:pnlSearchResult", "W0010", "");
							//do not show message in search form.
							getSemmrt008PayBean().setRenderedMsgFormSearch(false);
							//do not show dialog
							getSemmrt008PayBean().setRenderedDailog(false);
							return flag;
						}
					}else{
						String pettyCashPayStatus = ""; 
						if(null != getSemmrt008PayBean().getPettyCashPay()){
							pettyCashPayStatus = getSemmrt008PayBean().getPettyCashPay().getPettyCashPayStatus();
						}
						if(!StringUtils.equals(pettyCashPayStatus, "01")){
							//do not show dialog
							getSemmrt008PayBean().setRenderedDailog(false);
						}else{
							//show dialog
							getSemmrt008PayBean().setRenderedDailog(true);
						}
						
					}
					
					
				}else if(StringUtils.equals(eventType, EVENT_CANCEL)){
					getSemmrt008PayBean().setActModeDisplay(EVENT_CANCEL);
					if(StringUtils.equals(getNavPrograme(), "semmrt008pay-4")){
						if(isAuthent()){
							//show dialog
							getSemmrt008PayBean().setRenderedDailog(true);
						}else{
							addMessageError("incContent:frmSearchResult:pnlSearchResult", "W0010", "");
							//do not show message in search form.
							getSemmrt008PayBean().setRenderedMsgFormSearch(false);
							//do not show dialog
							getSemmrt008PayBean().setRenderedDailog(false);
							return flag;
						}
					}else{
						String pettyCashPayStatus = ""; 
						if(null != getSemmrt008PayBean().getPettyCashPay()){
							pettyCashPayStatus = getSemmrt008PayBean().getPettyCashPay().getPettyCashPayStatus();
						}
						if(!StringUtils.equals(pettyCashPayStatus, "01")){
							//do not show dialog
							getSemmrt008PayBean().setRenderedDailog(false);
						}else{
							//show dialog
							getSemmrt008PayBean().setRenderedDailog(true);
						}
					}
				}else if(StringUtils.equals(eventType, EVENT_SEARCH)){
					getSemmrt008PayBean().setActModeDisplay(EVENT_SEARCH);
					doSearch();
				}
				getSemmrt008PayBean().setMode(ServiceConstants.MODULE_ACTION_UPDATE);
			}else if(ServiceConstants.MODULE_ACTION_INSERT.equals(mode)){
				
				//set ddl company to read only.
				getSemmrt008PayBean().setReadOnlyCompany(false);
				//set company type list
				getSemmrt008PayBean().setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
				//clear all of value.
				getSemmrt008PayBean().setPettyCashPay(getDefaultValue());
				//do not show data table
				getSemmrt008PayBean().setRenderedPanelPaymentInfo(false);
				//for displaying in pop up header
				getSemmrt008PayBean().setActModeDisplay(EVENT_ADD);
				getSemmrt008PayBean().setMode(ServiceConstants.MODULE_ACTION_INSERT);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	private PettyCashPay getDefaultValue() throws Exception{
		PettyCashPay p = new PettyCashPay();
		p.setRequestDt(SEMDataUtility.getCurrentDate());
		p.setPettyCashPayStatus("01");
		//p.setPettyCashPayNo("xxxxx");
		p.setReceiptTaxFlag("N");
		p.setClrReceiptTaxFlag("N");
		p.setVatType("03");
		return p;
	}
	
	public boolean getPettyCashPayNo(){
		boolean flagValid = false;
		try {
			IPettyCashPayService service = (IPettyCashPayService)getBean("pettyCashPayService");
			PettyCashPay pettyCashPay = getSemmrt008PayBean().getPettyCashPay();
			String runningNo = service.getRunningNo("PETTY_CASH_PAY", pettyCashPay.getPettyCashPayNo());
			//set running no by AIS
			pettyCashPay.setPettyCashPayNo(runningNo);
			getSemmrt008PayBean().setPettyCashPay(pettyCashPay);
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError("E0001");
		}
		return flagValid;
	}
	
	private boolean isAuthent(){
		boolean isTrue = true;
		boolean isSelect = false;
		SEMMRT008PayBean rt008PayBean = getSemmrt008PayBean();
		List<WrapperBeanObject<PettyCashPaySP>> detailList = rt008PayBean.getPettyCashPayList();
		for(int i=0; i<detailList.size(); i++){
			WrapperBeanObject<PettyCashPaySP> detail = detailList.get(i);
			if(detail.isCheckBox()){
				isSelect = true;
				PettyCashPaySP sp = (PettyCashPaySP)detail.getDataObj();
				if(!StringUtils.equals(sp.getPettyCashPayStatus(), "01")){
					return isTrue = false;
				}
			}
		}
		return (isTrue && isSelect);
	}
 
	@Override
	public void clearSessionNotUsed() {
		
	}

	@Override
	public void init() {
		SEMMRT008PayBean rt008PayBean = new SEMMRT008PayBean();
		rt008PayBean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		//String lovVals = "AIS,FXL";
		//rt008PayBean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name, EX_IN, lovVals, null, null));
		rt008PayBean.setRegionList(getRegionItems());
		//request type
		//rt008PayBean.setExpenseTypeList(getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name));
		rt008PayBean.setExpenseTypeList(getLovItemsByTypeExceptLovCodes(ELovType.T_CT_EXPENSE_TYPE.name, "08,10,99,18,13,14"));
		rt008PayBean.setPayStatusList(getLovItemsByType(ELovType.T_RT_PETTY_CASH_PAY_STATUS.name));
		rt008PayBean.setRequestSubjList(getLovItemsByType(ELovType.T_RT_PETTY_CASH_SUBJECT.name));
		rt008PayBean.setCategoryList(getLovItemsByType(ELovType.T_RT_PETTY_CASH_CATEGORY.name));
		//default category.
		rt008PayBean.getTmpPettyCashPay().setCategory("01");
		setSemmrt008PayBean(rt008PayBean);
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
		String company = getSemmrt008PayBean().getPettyCashPay().getCompany();
//		String region = getSemmrt008PayBean().getPettyCashPay().getRegion();
		String requestName = getSemmrt008PayBean().getPettyCashPay().getRequestName();
		Date reqDt = getSemmrt008PayBean().getPettyCashPay().getRequestDt();
		String requestSbj = getSemmrt008PayBean().getPettyCashPay().getRequestSubject();
		Double incReqAmt = getSemmrt008PayBean().getPettyCashPay().getIncRequestAmt();
		String payStatusName = getSemmrt008PayBean().getPettyCashPay().getPettyCashPayStatus();
		String vatType = getSemmrt008PayBean().getPettyCashPay().getVatType();
		
		if (StringUtils.isEmpty(company)) {
			addMessageError("W0001", msg("message.company"));
			flagValid = true;
		}
//		if (StringUtils.isEmpty(region)) {
//			addMessageError("W0001", msg("message.region"));
//			flagValid = true;
//		}
		if (StringUtils.isEmpty(requestName)) {
			addMessageError("W0001", msg("message.reqName"));
			flagValid = true;
		}
		if (reqDt == null) {
			addMessageError("W0001", msg("message.reqDt"));
			flagValid = true;
		}
		if (StringUtils.isEmpty(requestSbj)) {
			addMessageError("W0001", msg("message.title"));
			flagValid = true;
		}
		if (StringUtils.isEmpty(vatType)) {
			addMessageError("W0001", "Vat");
			flagValid = true;
		}
		
		if (incReqAmt == null || incReqAmt == 0.0d) {
			addMessageError("W0001",  msg("message.bgAmt"));
			flagValid = true;
		}
		if (StringUtils.isEmpty(payStatusName)) {
			addMessageError("W0001", msg("message.payStatus"));
			flagValid = true;
		}
		
		
		
		
		return flagValid;
	}
	
	public boolean validateFormSearch() {
		boolean flagValid = false;
		
		if (StringUtils.isEmpty(getSemmrt008PayBean().getTmpPettyCashPay().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flagValid = true;
		}
			
		
		SEMMRT008PayBean rt008PayBean = getSemmrt008PayBean();
		Date requestDtFrom = rt008PayBean.getTmpPettyCashPay().getRequestDtFrom();
		Date requestDtTo = rt008PayBean.getTmpPettyCashPay().getRequestDtTo();
		Date dueDtFrom = rt008PayBean.getTmpPettyCashPay().getDueDtFrom();
		Date dueDtTo = rt008PayBean.getTmpPettyCashPay().getDueDtTo();
//		String refClrNo = rt008PayBean.getTmpPettyCashPay().getRefClrBatchNo();
		
		LOG.info("requestDtFrom :" + requestDtFrom);
		LOG.info("requestDtTo :" + requestDtTo);
		LOG.info("dueDtFrom :" + dueDtFrom);
		LOG.info("dueDtTo :" + dueDtTo);
		
		if(requestDtFrom != null)
			if(requestDtTo == null)
			return defaultRequestFromToDt(requestDtFrom);
		
		if(requestDtTo != null)
			if(requestDtFrom == null)
			return defaultRequestFromToDt(requestDtTo);
		
		if(dueDtFrom != null)
			if(dueDtTo == null)
			return defaultDueFromToDt(dueDtFrom);
		
		if(dueDtTo != null)
			if(dueDtFrom == null)
			return defaultDueFromToDt(dueDtTo);
		
//		if(StringUtils.isEmpty(refClrNo)){
//			addMessageError("W0001", "Ref.Batch Clear");
//			flagValid = true;
//		}
		
		if(requestDtFrom != null && requestDtTo != null){
			if (requestDtFrom.after(requestDtTo)) {
				addMessageErrorWithArgument("W0006" ,msg("message.bgStrDt"), msg("message.bgEndDt") );
				flagValid = true;
			}
		}
		if(dueDtFrom != null && dueDtTo != null){
			if (dueDtFrom.after(dueDtTo)) {
				addMessageErrorWithArgument("W0006" ,msg("message.ctlStrDt"), msg("message.ctlEndDt") );
				flagValid = true;
			}
		}
		return flagValid;
	}
	
	public void doExportExcel(){
		LOG.info("doExportExcel");
		try{
			semmrt008PayBean = getSemmrt008PayBean();
			semmrt008PayBean.setDisplayReportFlag(false);
//			if(isCheckSELBox()==false){
//			addMessageError("incContent:frmSearchResult:pnlSearchResult", "E0001", "");
//			}
			
		    
			/***********************************************/
			short line = 0;
//			Collection<PettyCashPaySP> exList = new ArrayList<PettyCashPaySP>();
			//PDocumentManager export to excel
			DocumentExportManager<PettyCashPaySP> docManager = new DocumentExportManager<PettyCashPaySP>
			(PettyCashPaySP.class, EnumDocumentType.XLS);
			// set current configuration of work book.	
			docManager.setRowStart(line);
			/***********************************************/
//			List<WrapperBeanObject<PettyCashPaySP>> detailList = new ArrayList<WrapperBeanObject<PettyCashPaySP>>();
//			detailList = getSemmrt008PayBean().getPettyCashPayList();
//			
//			StringBuffer strBuff = new StringBuffer();
//			
//			int j=1;
//			for(int i=0; i<detailList.size(); i++){
//				WrapperBeanObject<PettyCashPaySP> detail = new WrapperBeanObject<PettyCashPaySP>();
//				detail = detailList.get(i);
//				if(detail.isCheckBox()){
//					PettyCashPaySP tmp = new PettyCashPaySP();
//					tmp = (PettyCashPaySP)detail.getDataObj();
//					strBuff.append(tmp.getRowId());
//					
//					tmp.setNo(j++);
//					exList.add(tmp);
//				}
//				
//				if(i+1 != detailList.size())
//				strBuff.append(",");
//			}
			EnumDocStyleDomain	defaultStyle	= new EnumDocStyleDomain(EnumDocStyle.CELL_DEFAULT);
			EnumDocStyleDomain	moneyStyle	= new EnumDocStyleDomain(EnumDocStyle.CELL_MONEY);
//			String pettyCashPayIds = strBuff.toString();
//			LOG.info(pettyCashPayIds);
			String refClrBatchNo = "";
			Date exportDt = null;
			//update export date
			PettyCashPaySP p = semmrt008PayBean.getPettyCashPaySP();
			if(p!=null){
				refClrBatchNo = p.getRefClrBatchNo();
				exportDt = p.getExportDt();
				RowDomain rowD = new RowDomain(0);
				rowD.setCell(new CellDomain(0, null, String.class, defaultStyle, msg("export.col.exportDt"),null));
				rowD.setCell(new CellDomain(1, null, Date.class, new EnumDocStyleDomain(EnumDocStyle.CELL_B_DATE), exportDt,null));
				rowD.setCell(new CellDomain(2, null, String.class, defaultStyle, "Batch Clear No.",null));
				rowD.setCell(new CellDomain(3, null, String.class,defaultStyle, refClrBatchNo,null));
				docManager.putDetailRow(rowD);
				
			}
			EnumDocStyleDomain headerStyle = new EnumDocStyleDomain(EnumDocStyle.HEADER);
			
			RowDomain rowD = new RowDomain(1);
			rowD.setCell(new CellDomain(0, null, String.class, headerStyle, msg("export.col.no"),null));
			rowD.setCell(new CellDomain(1, null, String.class, headerStyle, msg("export.col.payNo"),null));
//			rowD.setCell(new CellDomain(2, null, String.class, headerStyle, "Batch Clear",null));
//			rowD.setCell(new CellDomain(1, null, String.class, headerStyle, msg("export.col.exportDt"),null));
			rowD.setCell(new CellDomain(2, null, String.class, headerStyle, msg("export.col.requestName"),null));
			rowD.setCell(new CellDomain(3, null, String.class, headerStyle, msg("export.col.requestSubject"),null));
			rowD.setCell(new CellDomain(4, null, String.class, headerStyle, msg("export.col.requestAmt"),null));
			rowD.setCell(new CellDomain(5, null, String.class, headerStyle, "VAT",null));
			rowD.setCell(new CellDomain(6, null, String.class, headerStyle, msg("export.col.requestAmt"),null));
			rowD.setCell(new CellDomain(7, null, String.class, headerStyle, msg("export.col.incRequestAmt"),null));
			rowD.setCell(new CellDomain(8, null, String.class, headerStyle, msg("export.col.taxInvoiceNo"),null));
			rowD.setCell(new CellDomain(9, null, String.class, headerStyle, msg("export.col.taxInvoiceDt"),null));
			rowD.setCell(new CellDomain(10, null, String.class, headerStyle, msg("export.col.requestDt"),null));
			rowD.setCell(new CellDomain(11, null, String.class, headerStyle, msg("export.col.contractNo"),null));
			rowD.setCell(new CellDomain(12, null, String.class, headerStyle, msg("export.col.siteName"),null));
			rowD.setCell(new CellDomain(13, null, String.class, headerStyle, msg("export.col.effDt"),null));
			rowD.setCell(new CellDomain(14, null, String.class, headerStyle, msg("export.col.expireDt"),null));
			rowD.setCell(new CellDomain(15, null, String.class, headerStyle, msg("export.col.expenseTypeName"),null));
			rowD.setCell(new CellDomain(16, null, String.class, headerStyle, msg("export.col.dueDt"),null));
			rowD.setCell(new CellDomain(17, null, String.class, headerStyle, msg("export.col.payStatus"),null));
			
			RowDomain rowD2 = new RowDomain(semmrt008PayBean.getExList().size()+2);
			rowD2.setCell(new CellDomain(7, null, Double.class, moneyStyle, semmrt008PayBean.getTotalIncRequestAmt(),null));			
			
			docManager.putDetailRow(rowD);
			docManager.putDetailRow(rowD2);
			docManager.seteObjectList(semmrt008PayBean.getExList());
			docManager.setModule("PettyCashPay_" + refClrBatchNo + "_");
			docManager.getObjectFromDocument();
			docManager.exportServletFile();
			
			
			
		}catch(NullPointerException ne){
			LOG.error(ne);
		}catch(Exception e){
			LOG.error(e);
		}finally{
//			doSearch();
		}
		
	}
	
	private PettyCashPaySP updateExportDt(String pettyCashPayIds) throws Exception{
		IPettyCashPayService service = (IPettyCashPayService)getBean("pettyCashPayService");
		PettyCashPaySP p = service.updateExportDt(pettyCashPayIds, getUserLogIn());
		return p;
	}
	
	public void onRender(){
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		LOG.info("tmpRowId :" + rowId);
		getSemmrt008PayBean().setTmpRowId(rowId);
		
		if(isCheckSELBox()==false)
		addMessageError("E0001");
	}
	public void onRenderExportButton(){
		
		if(isCheckAvalibleToExport()){
			getSemmrt008PayBean().setDisabledBtnExport(true);
		}else{
			getSemmrt008PayBean().setDisabledBtnExport(false);
		}
	}
	
	private boolean isCheckSELBox(){
		boolean isCheck = false;
		List<WrapperBeanObject<PettyCashPaySP>> pettyCashPay = getSemmrt008PayBean().getPettyCashPayList();
		for (WrapperBeanObject<PettyCashPaySP> wrapperBeanObject : pettyCashPay) {
			if(wrapperBeanObject.isCheckBox()){
				return true;
				
			}
		}
		return isCheck;
	}
	
	/*private boolean isCheckAvalibleToExport(){
		boolean isDisbleToExport = false;
		boolean isNotCheck = true;
		
		List<WrapperBeanObject<PettyCashPaySP>> pettyCashPay = getSemmrt008PayBean().getPettyCashPayList();
		for (WrapperBeanObject<PettyCashPaySP> wrapperBeanObject : pettyCashPay) {
			if(wrapperBeanObject.isCheckBox()){
				PettyCashPaySP o = (PettyCashPaySP)wrapperBeanObject.getDataObj();
				isNotCheck = false;
				String status = o.getPettyCashPayStatus();
				if(!StringUtils.equals(status, "02")){
					isDisbleToExport = true;
				}
			}
		}
		if(isNotCheck)
		isDisbleToExport = true;
		return isDisbleToExport;
	}*/
	
	private boolean isCheckAvalibleToExport(){
		boolean isDisbleToExport = false;
		boolean isNotCheck = true;
		
		List<WrapperBeanObject<PettyCashPaySP>> pettyCashPay = getSemmrt008PayBean().getPettyCashPayList();
		for (WrapperBeanObject<PettyCashPaySP> wrapperBeanObject : pettyCashPay) {
			if(wrapperBeanObject.isCheckBox()){
				PettyCashPaySP o = (PettyCashPaySP)wrapperBeanObject.getDataObj();
				isNotCheck = false;
				String exportFlag = o.getExportFlag();
				
				if(StringUtils.equals(exportFlag, "N")){
					isDisbleToExport = true;
				}
			}
		}
		if(isNotCheck)
		isDisbleToExport = true;
		return isDisbleToExport;
	}
	
	public void selectAllRow(){
		LOG.info("select row all");
		try{
			getSemmrt008PayBean().setDisabledBtnExport(false);
			boolean chkAll = getSemmrt008PayBean().isChkSelAll();
			
				List<WrapperBeanObject<PettyCashPaySP>> detailList = new ArrayList<WrapperBeanObject<PettyCashPaySP>>();
				detailList = getSemmrt008PayBean().getPettyCashPayList();
				for(int i=0; i<detailList.size(); i++){
					PettyCashPaySP o = (PettyCashPaySP)detailList.get(i).getDataObj();
					disbledExportBtn(o, chkAll);
					detailList.get(i).setCheckBox(chkAll);
				}
				getSemmrt008PayBean().setPettyCashPayList(detailList);
		}catch(NullPointerException ne){
			LOG.error(ne);
		}catch(Exception e){
			LOG.error(e);
		}
	}
	
	private void disbledExportBtn(PettyCashPaySP o, boolean chkAll){
		String exportFlag = o.getExportFlag();
		//if(!StringUtils.equals(status, "02")){
		//}

		if(chkAll){
			if(StringUtils.equals(exportFlag, "N"))
			getSemmrt008PayBean().setDisabledBtnExport(true);
		}else{
			getSemmrt008PayBean().setDisabledBtnExport(true);
		}
	}
	
	private SEMMRT008PayBean semmrt008PayBean;
	
	public SEMMRT008PayBean getSemmrt008PayBean() {
		return (SEMMRT008PayBean)getFacesUtils().getSessionMapValue("semmrt008PayBean");
	}

	public void setSemmrt008PayBean(SEMMRT008PayBean semmrt008PayBean) {
		this.semmrt008PayBean = semmrt008PayBean;
		getFacesUtils().setSessionMapValue("semmrt008PayBean", semmrt008PayBean);
	}
	
	
	
	
	
	
	

}
