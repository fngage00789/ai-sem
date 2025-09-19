package th.co.ais.web.co.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.co.BorrowContract;
import th.co.ais.domain.co.BorrowRequest;
import th.co.ais.domain.co.BorrowRequestGenDocNoSearchSP;
import th.co.ais.domain.co.ContractCheckDoc;
import th.co.ais.domain.co.Mco001UpdateCheckDocLSP;
import th.co.ais.domain.co.Mco001UpdateCheckDocSP;
import th.co.ais.domain.co.Mco003ChkBorrow;
import th.co.ais.domain.co.Mco003ChkContractSP;
import th.co.ais.domain.co.Mco003ChkReturn;
import th.co.ais.domain.co.Mco003Del;
import th.co.ais.domain.co.Mco003DelBorrow;
import th.co.ais.domain.co.Mco003InsertBorrowSP;
import th.co.ais.domain.co.Mco003SaveBorrow;
import th.co.ais.domain.co.Mco003SaveReturn;
import th.co.ais.domain.co.Mco003SearchBorrowSP;
import th.co.ais.domain.co.Mco003SearchPSI002SP;
import th.co.ais.domain.co.Mco003SrchBorrowRequestSP;
import th.co.ais.domain.co.ReturnContract;
import th.co.ais.domain.el.PaymentWrapper;
import th.co.ais.domain.sa.MSA001LovSP;
import th.co.ais.domain.sa.SiteAcqSP;
import th.co.ais.domain.sa.SiteAppSP;
import th.co.ais.rpt.util.bean.CellDomain;
import th.co.ais.rpt.util.bean.EnumDocStyleDomain;
import th.co.ais.rpt.util.bean.RowDomain;
import th.co.ais.rpt.util.enums.EnumDocStyle;
import th.co.ais.rpt.util.enums.EnumDocumentType;
import th.co.ais.service.co.IBorrowRequestService;
import th.co.ais.service.co.IContractCheckDocService;
import th.co.ais.service.co.IContractStatusService;
import th.co.ais.service.sa.ISiteAcquistionService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.co.bean.SEMMCO003Bean;
import th.co.ais.web.el.bean.SEMMEL008Bean;
import th.co.ais.web.report.util.DocumentExportManager;
import th.co.ais.web.sa.bean.LegalDocComponentBean;
import th.co.ais.web.si.bean.SEMMSI002Bean;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.MSGCacheUtil;
import th.co.ais.web.util.SelectItemLOVCacheUtil;

public class SEMMCO003Action  extends AbstractAction{
	
	private static final long serialVersionUID = 5023762913406300754L;
	private Logger log = Logger.getLogger(getClass());
	private SEMMCO003Bean semmco003Bean;

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if (methodWithNavi.equalsIgnoreCase("doSearch")) {
			flag = doSearch();
		} else if (methodWithNavi.equalsIgnoreCase("doBack")) {
			flag = doBack();
		} else if (methodWithNavi.equalsIgnoreCase("initAddBorrowContract")) {
			flag = initAddBorrowContract();
		} else if (methodWithNavi.equalsIgnoreCase("doSaveBorrowContract")) {
			flag = doSaveBorrowContract();
		} else if (methodWithNavi.equalsIgnoreCase("doUpdateBorrowContract")) {
			flag = doUpdateBorrowContract();
		} else if (methodWithNavi.equalsIgnoreCase("editBorrowContract")) {
			flag = editBorrowContract();
		} else if (methodWithNavi.equalsIgnoreCase("doInitBorrowContract")) {
			flag = doInitBorrowContract();
		} else if (methodWithNavi.equalsIgnoreCase("doSearchContract")) {
			flag = doSearchContract();
		} else if (methodWithNavi.equalsIgnoreCase("doAddContract")) {
			flag = doAddContract();
		} else if (methodWithNavi.equalsIgnoreCase("initBorrowContract")) {
			flag = initBorrowContract();
		} else if (methodWithNavi.equalsIgnoreCase("doSaveContractDetail")) {
			flag = doSaveContractDetail();
		} else if (methodWithNavi.equalsIgnoreCase("doinitReturnContract")) {
			flag = doinitReturnContract();
		} else if (methodWithNavi.equalsIgnoreCase("doSaveContractReturn")) {
			flag = doSaveContractReturn();
		} else if (methodWithNavi.equalsIgnoreCase("deleteRequest")) {
			flag = deleteRequest();
		} else if (methodWithNavi.equalsIgnoreCase("deleteContract")) {
			flag = deleteContract();
		} else if (methodWithNavi.equalsIgnoreCase("doClear")) {
			flag = doClear();
		} else if (methodWithNavi.equalsIgnoreCase("doClearBorrow")) {
			flag = doClearBorrow();
		} else if (methodWithNavi.equalsIgnoreCase("initDeleteRequest")) {
			flag = initDeleteRequest();
		} else if (methodWithNavi.equalsIgnoreCase("initDeleteContract")) {
			flag = initDeleteContract();
		}else if (methodWithNavi.equalsIgnoreCase("doInitAddContract")) {
			flag = doInitAddContract();
		}else if (methodWithNavi.equalsIgnoreCase("doClearAddContrac")) {
			flag = doClearAddContrac();
		}else if (methodWithNavi.equalsIgnoreCase("doClearPop")) {
			flag = doClearPop();
		}else if (methodWithNavi.equalsIgnoreCase("doCancelBorrow")) {
			flag = doCancelBorrow();
		}else if (methodWithNavi.equalsIgnoreCase("chkTxtBorrowName")) {
			chkTxtBorrowName();
		}else if (methodWithNavi.equalsIgnoreCase("doSearchBeforAddContract")) {
			flag = doSearchBeforAddContract();
		}else if(methodWithNavi.equalsIgnoreCase("doApproveBorrow")){
			flag = doApproveBorrow();
		}
		
		
		return flag;
	}


	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void init() {
		SEMMCO003Bean semmco003Bean = new SEMMCO003Bean();
		semmco003Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmco003Bean.setCriteria(new Mco003SrchBorrowRequestSP());
		semmco003Bean.setBorrowRequestSPList(new ArrayList());
		semmco003Bean.setReturnContract(new ReturnContract());
		semmco003Bean.setDisBtnBorrow(true);
		//  MERGE NEW POPUP BY NOOM
		
//		semmco003Bean.setBorrowNameList(new ArrayList<SelectItem>());
//		semmco003Bean.setBorrowOfficerList(new ArrayList<SelectItem>());
//		semmco003Bean.setBorrowForList(new ArrayList<SelectItem>());
		
		
		setSemmco003Bean(semmco003Bean);
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void setSemmco003Bean(SEMMCO003Bean semmco003Bean) {
		this.semmco003Bean = semmco003Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmco003Bean", this.semmco003Bean);
	}

	public SEMMCO003Bean getSemmco003Bean() {
		return (SEMMCO003Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmco003Bean");
	}
	
	private boolean doBack() {
		boolean flag = true;
		doSearch();
		return flag;
	}
	
	@SuppressWarnings("unchecked")
	private boolean doSearch() {
		boolean flag = false;
		semmco003Bean = getSemmco003Bean();
		semmco003Bean.setBorrowRequestSPList(new ArrayList<WrapperBeanObject<Mco003SrchBorrowRequestSP>>());
		semmco003Bean.setRenderedMsgFormSearch(false);
		if(!validateSearch()){
			semmco003Bean.setRenderedMsgFormSearch(true);
			return flag;
		}
		List<Mco003SrchBorrowRequestSP> to = null;
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			
			//fix status 01 = site acq send approve
			semmco003Bean.getCriteria().setStatus("01");
			to = service.querySPList(EQueryName.SEM_SP_MCO003_SRCH.name, semmco003Bean.getCriteria());
			if(to != null && to.size() > 0){
				semmco003Bean.setRenderedMsgDataNotFound(false);
				for (int i = 0; i < to.size(); i++) {
					Mco003SrchBorrowRequestSP contract = to.get(i);
					WrapperBeanObject<Mco003SrchBorrowRequestSP> tmpWrapperBean = new WrapperBeanObject<Mco003SrchBorrowRequestSP>();
//					if(contract.getReceiveDt() != null) contract.setReceiveDt(convertYearENtoTH(contract.getReceiveDt()));
//					if(contract.getSamSendDt() != null) contract.setSamSendDt(convertYearENtoTH(contract.getSamSendDt()));
//					if(contract.getSamAssignSendDt() != null) contract.setSamAssignSendDt(convertYearENtoTH(contract.getSamAssignSendDt()));
					if(contract.getReceiveDt() != null) contract.setReceiveDtStr(convertYearENtoTHStr(contract.getReceiveDt()));
					if(contract.getSamSendDt() != null) contract.setSamSendDtStr(convertYearENtoTHStr(contract.getSamSendDt()));
					if(contract.getSamAssignSendDt() != null) contract.setSamAssignSendDtStr(convertYearENtoTHStr(contract.getSamAssignSendDt()));
					
					tmpWrapperBean.setDataObj(contract);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					semmco003Bean.getBorrowRequestSPList().add(tmpWrapperBean);
				}
			} else {
				semmco003Bean.setRenderedMsgDataNotFound(true);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmco003Bean(semmco003Bean);
		return flag;
	}
	
	private boolean validateSearch() {
		boolean flgValid = true;
		
		if(StringUtils.isEmpty(getSemmco003Bean().getCriteria().getContractNo())&&StringUtils.isEmpty(getSemmco003Bean().getCriteria().getDocNo())){
			if(StringUtils.isEmpty(getSemmco003Bean().getCriteria().getCompany())){
				addMessageError("W0001", msg("message.company"));
				flgValid = false;
			}
		}
		
		return flgValid;
	}
	
	@SuppressWarnings("unchecked")
	private boolean initAddBorrowContract(){
		boolean flag = false;
		semmco003Bean = getSemmco003Bean();
		semmco003Bean.setMode("ADD");
		semmco003Bean.setBorrowRequest(new BorrowRequest());
		semmco003Bean.getBorrowRequest().setReceiveDt(new Date());
		semmco003Bean.getBorrowRequest().setSamSendDt(new Date());
		semmco003Bean.setAddContractNo("");
		semmco003Bean.setContractAdd("");
		semmco003Bean.setCacheContractAdd("");
		semmco003Bean.setBorrowSPList(null);
		semmco003Bean.setContractSPList(null);
		//Merge new Popup By Noom 11/03/2013
//		semmco003Bean.setBorrowNameList(SelectItemLOVCacheUtil.getInstance().getLovItemsValueNameByType(ELovType.T_SI_SITE_APPROVE_FROM.name));
//		semmco003Bean.setBorrowOfficerList(getLovItemsByType(ELovType.T_CO_BORROW_OFFICER.name));
//		semmco003Bean.setBorrowForList(getLovItemsByType(ELovType.T_CO_BORROW_FOR_TYPE.name));
		//
		
		List<BorrowRequestGenDocNoSearchSP> genNo = null;
		try {
			IBorrowRequestService service = (IBorrowRequestService)getBean("borrowRequestService");
			List querySPList = service.querySPList(EQueryName.SP_MCO003_GEN_DOC_NO.name, semmco003Bean.getBorrowRequest());
			genNo = querySPList;
			semmco003Bean.getBorrowRequest().setDocNo((genNo.get(0).getGenDocNo()!=null)?genNo.get(0).getGenDocNo():"");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmco003Bean(semmco003Bean);
		return flag;
	}
	
	private boolean doSaveBorrowContract(){
		log.debug("doSaveBorrowContract");
		boolean flag = false;
		semmco003Bean = getSemmco003Bean();
		IBorrowRequestService service = (IBorrowRequestService)getBean("borrowRequestService");
		if(!validateUpdateContractStatus()){
			semmco003Bean.setRenderedMsgFormSearch(false);
			semmco003Bean.setPopupClose(false);
			setSemmco003Bean(semmco003Bean);
			return flag;
		}
		
		BorrowRequest borrow = null;
		
		try{
			borrow = service.queryBorrowRequestByDocNo(semmco003Bean.getBorrowRequest().getDocNo());
			if (borrow != null) {
				addMessageError("W0073", semmco003Bean.getBorrowRequest().getDocNo());
				semmco003Bean.setPopupClose(false);
			} else {
//				semmco003Bean.getBorrowRequest().setRecordStatus("Y");
//				semmco003Bean.getBorrowRequest().setCurrentUser(getUserLogIn());
//				service.createBorrowContract(semmco003Bean.getBorrowRequest());
				Mco003InsertBorrowSP mco003InsertBorrowSP = new Mco003InsertBorrowSP();
				mco003InsertBorrowSP.setDocNo(semmco003Bean.getBorrowRequest().getDocNo());
//				mco003InsertBorrowSP.setContractNo(psi002.getContractNo());
				if(StringUtils.equalsIgnoreCase("EDIT", semmco003Bean.getMode())){
					mco003InsertBorrowSP.setMode("EDIT");
				}else {
					mco003InsertBorrowSP.setMode("ADD");
				}
				mco003InsertBorrowSP.setpOption("M");
				mco003InsertBorrowSP.setCompany(semmco003Bean.getBorrowRequest().getCompany());
				mco003InsertBorrowSP.setRecievDt(semmco003Bean.getBorrowRequest().getReceiveDt());
				mco003InsertBorrowSP.setSamSendDt(semmco003Bean.getBorrowRequest().getSamSendDt());
				mco003InsertBorrowSP.setSamAssignSend(semmco003Bean.getBorrowRequest().getSamAssignSendDt());
				mco003InsertBorrowSP.setRemark(semmco003Bean.getBorrowRequest().getRemark());
				mco003InsertBorrowSP.setUser(getUserLogIn());
				mco003InsertBorrowSP.setSiteNum(semmco003Bean.getBorrowRequest().getSiteNum());
				//set status
				mco003InsertBorrowSP.setStatus("02");
				List<Mco003InsertBorrowSP> resultList = service.querySPList(EQueryName.SP_MCO003_INSERT.name, mco003InsertBorrowSP);
				
				addMessageInfo("M0001");
				semmco003Bean.setMode("");
				// 20101210 after save do search
				if(!StringUtils.isEmpty(getSemmco003Bean().getCriteria().getCompany())){ 
					doSearch();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0001");
			semmco003Bean.setPopupClose(false);
		}
		semmco003Bean.setPopupClose(true);
		semmco003Bean.setRenderedMsgFormSearch(true);
		setSemmco003Bean(semmco003Bean);
		return flag;
	}
	
	private boolean validateUpdateContractStatus() {
		boolean flgValid = true;
		if(StringUtils.isEmpty(getSemmco003Bean().getBorrowRequest().getCompany())){
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		 
		Date receiveDt = getSemmco003Bean().getBorrowRequest().getReceiveDt();
		Date samSendDt = getSemmco003Bean().getBorrowRequest().getSamSendDt();
		
		if(receiveDt == null){
			addMessageError("W0001", msg("message.receiveDt"));
			flgValid = false;
		}
		
		if(samSendDt == null){
			addMessageError("W0001", msg("message.samSendDt"));
			flgValid = false;
		}
		
		if (getSemmco003Bean().getBorrowRequest().getSiteNum().equals(new BigDecimal(0))) {
			addMessageError("W0001", msg("message.borrowSiteNum"));
			flgValid = false;
		}
		
		if (flgValid) {
			Date samAssignSendDt = getSemmco003Bean().getBorrowRequest().getSamAssignSendDt();
			if (samAssignSendDt != null) {
				if (samAssignSendDt.before(samSendDt)) {
					addMessageError("W0001", msg("message.borrowDate1"));
					flgValid = false;
				}
			}
			
			if (samSendDt.before(receiveDt)) {
				addMessageError("W0001", msg("message.borrowDate2"));
				flgValid = false;
			}
		}
		
		return flgValid;
	}
	
	private boolean editBorrowContract(){
		boolean flag = false;
		semmco003Bean = getSemmco003Bean();
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		String company = (String)getFacesUtils().getRequestParameter("company");
		String docNo = (String)getFacesUtils().getRequestParameter("docNo");
		semmco003Bean.setInsertBorrowID(rowId);
		semmco003Bean.setContractAdd("");
		semmco003Bean.setCacheContractAdd("");
		semmco003Bean.setBorrowSPList(null);
		semmco003Bean.setTmpDocNo(docNo);
		IBorrowRequestService borService = (IBorrowRequestService)getBean("borrowRequestService");
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		try{
		BorrowRequest borrow = borService.queryBorrowRequestByRowId(rowId);
		
		Mco003SearchBorrowSP criteriaSrch = new Mco003SearchBorrowSP();
		criteriaSrch.setCompany(company);
		criteriaSrch.setBorrowRequestId(rowId);
		criteriaSrch.setStatus("02");
		List<Mco003SearchBorrowSP> toSrch = service.querySPList(EQueryName.SP_MCO003_SECH_BORROW.name, criteriaSrch);
		
		String contractNo = "";
			if (toSrch != null && toSrch.size() > 0) {
				for (Mco003SearchBorrowSP mco003SearchBorrowSP : toSrch){
					if (StringUtils.isEmpty(contractNo)){
						contractNo = mco003SearchBorrowSP.getContractNo();
					}else{
						contractNo = contractNo+","+mco003SearchBorrowSP.getContractNo();
					}
				}
				semmco003Bean.setContractAdd(contractNo);
				semmco003Bean.setCacheContractAdd(contractNo);
				semmco003Bean.setBorrowSPList(packBorrowContractList(toSrch));
			} else {
				semmco003Bean.setBorrowSPList(null);
			}
		
		semmco003Bean.setBorrowRequest(borrow);
		semmco003Bean.setMode(mode);
		semmco003Bean.setAddContractNo("");
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		setSemmco003Bean(semmco003Bean);
		
		return flag;
	}
	
	private boolean doInitBorrowContract(){
		boolean flgValid = true;
		semmco003Bean = getSemmco003Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		String company = (String)getFacesUtils().getRequestParameter("company");
		String sumSite = (String)getFacesUtils().getRequestParameter("siteNum");
		String docNo = (String)getFacesUtils().getRequestParameter("docNo");
		sumSite = (StringUtils.isEmpty(sumSite))? "0": sumSite;
		semmco003Bean.setSumSite(Integer.parseInt(sumSite));
		semmco003Bean.setBorrowOfficerList(new ArrayList<SelectItem>());
		Mco003SearchBorrowSP borrow = new Mco003SearchBorrowSP();
		borrow.setCompany(company);
		borrow.setDocNo(docNo);
		semmco003Bean.setBorrowForList(getLovItemsByType(ELovType.T_CO_BORROW_FOR_TYPE.name));
		semmco003Bean.setCriteriaBorrow(borrow);
		semmco003Bean.setInsertBorrowID(rowId);
		semmco003Bean.setBorrowSPList(null);
		semmco003Bean.setViewContractNo("");
		semmco003Bean.setAddPreContractNo("");
		semmco003Bean.setAddContractNo("");
		semmco003Bean.setBorrowRequest(new BorrowRequest());
		semmco003Bean.setBorrowNameList(SelectItemLOVCacheUtil.getInstance().getLovItemsValueNameByType(ELovType.T_SI_SITE_APPROVE_FROM.name));
		
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		semmco003Bean.setModeReturn(mode);
//		if (mode.equals("VIEW")) {
			doSearchContract();
//		}
		
		setSemmco003Bean(semmco003Bean);
		return flgValid;
	}
	
	private boolean validateContract() {
		boolean flgValid = true;
		if(StringUtils.isEmpty(getSemmco003Bean().getCriteriaBorrow().getCompany())){
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		
		return flgValid;
	}
	
	private boolean doSearchContract(){
		boolean flag = false;
		semmco003Bean = getSemmco003Bean();
		semmco003Bean.setRenderedMsgDataNotFound(false);
		if(!validateContract()){
			return flag;
		}
		
		String contractNo = semmco003Bean.getViewContractNo();
		SEMMCO003Bean criteria = semmco003Bean;
		criteria.getCriteriaBorrow().setContractNo(contractNo);
		semmco003Bean.setBorrowSPList(searchContract(criteria));
		semmco003Bean.setCacheSrchBorrowList(semmco003Bean.getBorrowSPList());	// 20110106
		semmco003Bean.setCacheAddBorrowList(null);
		semmco003Bean.setCacheContractAdd("");
		this.onRenderExportButton();
		setSemmco003Bean(semmco003Bean);
		return flag;
	}
	
	@SuppressWarnings("unchecked")
	private List<Mco003SearchBorrowSP> searchBorrowContract(Mco003SearchBorrowSP sco003SearchBorrowSP) {
		try {
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			return service.querySPList(EQueryName.SP_MCO003_SECH_BORROW.name, sco003SearchBorrowSP);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	private List<WrapperBeanObject<Mco003SearchBorrowSP>> searchContract(SEMMCO003Bean bean){
		List<Mco003SearchBorrowSP> to = null;
		List<WrapperBeanObject<Mco003SearchBorrowSP>> result = new ArrayList<WrapperBeanObject<Mco003SearchBorrowSP>>();
		try{
			// IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			Mco003SearchBorrowSP criteria = bean.getCriteriaBorrow();
			// P'O do it
			// criteria.setBorrowContractId(bean.getInsertBorrowID());
			criteria.setBorrowRequestId(bean.getInsertBorrowID());
			criteria.setStatus("02");
			semmco003Bean.setBorrowSPList(new ArrayList());
			to = searchBorrowContract(criteria);
//			if(to == null &&  to.isEmpty()){
//				addMessageError("M0004");
//				semmco003Bean.setBorrowRequestSPList(null);
//			}
			if(to != null && to.size() > 0){
				String strContract = "";	// 20110106
				for (int i = 0; i < to.size(); i++) {
					Mco003SearchBorrowSP contract = to.get(i);
					WrapperBeanObject<Mco003SearchBorrowSP> tmpWrapperBean = new WrapperBeanObject<Mco003SearchBorrowSP>();
//					if(contract.getEffectiveDt() != null) contract.setReturnDt(convertYearENtoTH(contract.getEffectiveDt()));
//					if(contract.getExpireDt() != null) contract.setReturnDt(convertYearENtoTH(contract.getExpireDt()));
//					if(contract.getBorrowDt() != null) contract.setReturnDt(convertYearENtoTH(contract.getBorrowDt()));
//					if(contract.getReturnDt() != null) contract.setReturnDt(convertYearENtoTH(contract.getReturnDt()));
					if(contract.getEffectiveDt() != null) contract.setEffectiveDt(convertYearENtoTH(contract.getEffectiveDt()));
					if(contract.getExpireDt() != null) contract.setExpireDt(convertYearENtoTH(contract.getExpireDt()));
					if(contract.getBorrowDt() != null) contract.setBorrowDt(convertYearENtoTH(contract.getBorrowDt()));
					if(contract.getReturnDt() != null) contract.setReturnDt(convertYearENtoTH(contract.getReturnDt()));
					tmpWrapperBean.setDataObj(contract);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					result.add(tmpWrapperBean);
					
					// 20110106
					if (StringUtils.isEmpty(semmco003Bean.getViewContractNo())) {
						if (i == 0) {
							strContract = contract.getContractNo();
						} else {
							strContract += "," + contract.getContractNo();
						}
					} else {
						strContract = semmco003Bean.getViewContractNo();
					}
				}
				semmco003Bean.setCacheContractSrch(strContract);	// 20110106
			} else {
				semmco003Bean.setRenderedMsgDataNotFound(true);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	private List<WrapperBeanObject<Mco003SearchBorrowSP>> packBorrowContractList(List<Mco003SearchBorrowSP> to) {
		List<WrapperBeanObject<Mco003SearchBorrowSP>> resultList = new ArrayList<WrapperBeanObject<Mco003SearchBorrowSP>>();
//		String contractNo = "";
		for (int i = 0; i < to.size(); i++) {
			Mco003SearchBorrowSP contract = to.get(i);
//			if (StringUtils.isNotEmpty(contractNo)){
//				contractNo = contractNo+","+contract.getContractNo();
//			}else{
//				contractNo = contract.getContractNo();
//			}
			WrapperBeanObject<Mco003SearchBorrowSP> tmpWrapperBean = new WrapperBeanObject<Mco003SearchBorrowSP>();
			if(contract.getEffectiveDt() != null) contract.setEffectiveDt(convertYearENtoTH(contract.getEffectiveDt()));
			if(contract.getExpireDt() != null) contract.setExpireDt(convertYearENtoTH(contract.getExpireDt()));
			if(contract.getBorrowDt() != null) contract.setBorrowDt(convertYearENtoTH(contract.getBorrowDt()));
			if(contract.getReturnDt() != null) contract.setReturnDt(convertYearENtoTH(contract.getReturnDt()));
			tmpWrapperBean.setDataObj(contract);
			tmpWrapperBean.setMessage("");
			tmpWrapperBean.setCheckBox(false);
			resultList.add(tmpWrapperBean);
		}
//		if(!StringUtils.equalsIgnoreCase("EDIT", semmco003Bean.getMode())){
//		contractNo = contractNo.substring(0, contractNo.length()-1);
//		}
//		semmco003Bean.setContractAdd(contractNo);
		return resultList;
	}
	
	private void searchContractAfterSave() {
		// re-Search
//		if (StringUtils.isNotEmpty(semmco003Bean.getCacheContractSrch())) {
//			Mco003SearchBorrowSP criteriaSrch = new Mco003SearchBorrowSP();
//			criteriaSrch.setContractNo(semmco003Bean.getCacheContractSrch());
//			List<Mco003SearchBorrowSP> toSrch = searchBorrowContract(criteriaSrch);
//			if (toSrch != null && toSrch.size() > 0) {
//				semmco003Bean.setCacheSrchBorrowList(packBorrowContractList(toSrch));
//			} else {
//				semmco003Bean.setCacheSrchBorrowList(null);
//			}
//		}
//		Mco003SearchBorrowSP criteriaAdd = new Mco003SearchBorrowSP();
//		criteriaAdd.setContractNo(semmco003Bean.getCacheContractAdd());
//		List<Mco003SearchBorrowSP> toAdd = searchBorrowContract(criteriaAdd);
//		if (toAdd != null && toAdd.size() > 0) {
//			semmco003Bean.setCacheAddBorrowList(packBorrowContractList(toAdd));
//		} else {
//			semmco003Bean.setCacheAddBorrowList(null);
//		}
//		if (semmco003Bean.getCacheSrchBorrowList() != null) {
//			if (semmco003Bean.getCacheAddBorrowList() != null) {
//				
//			} else {
//				semmco003Bean.setBorrowSPList(semmco003Bean.getCacheSrchBorrowList());
//			}
//		} else {
//			if (semmco003Bean.getCacheAddBorrowList() != null) {
//				semmco003Bean.setBorrowSPList(semmco003Bean.getCacheAddBorrowList());
//			} else {
//				semmco003Bean.setBorrowSPList(null);
//			}
//		}
		String str = "";
		if (StringUtils.isNotEmpty(semmco003Bean.getCacheContractSrch())) {
			str = semmco003Bean.getCacheContractSrch();
			if (StringUtils.isNotEmpty(semmco003Bean.getCacheContractAdd())) {
				str += "," + semmco003Bean.getCacheContractAdd();
			}
		} else if (StringUtils.isNotEmpty(semmco003Bean.getCacheContractAdd())) {
			str = semmco003Bean.getCacheContractAdd();
		}
		Mco003SearchBorrowSP criteriaSrch = new Mco003SearchBorrowSP();
		criteriaSrch.setCompany(semmco003Bean.getCriteriaBorrow().getCompany());
		criteriaSrch.setBorrowRequestId(semmco003Bean.getInsertBorrowID());
		criteriaSrch.setContractNo(str);
		criteriaSrch.setStatus("02");
		List<Mco003SearchBorrowSP> toSrch = searchBorrowContract(criteriaSrch);
		List<Mco003SearchBorrowSP> toSrch2 = new ArrayList<Mco003SearchBorrowSP>();
		if (toSrch != null && toSrch.size() > 0) {
			//edit by NEW 2015/07/15 Set format Date
			for(Mco003SearchBorrowSP borrowSp : toSrch){
				if(borrowSp.getEffectiveDt() != null) borrowSp.setEffectiveDt(convertYearENtoTH(borrowSp.getEffectiveDt()));
				if(borrowSp.getExpireDt() != null) borrowSp.setExpireDt(convertYearENtoTH(borrowSp.getExpireDt()));
				if(borrowSp.getBorrowDt() != null) borrowSp.setBorrowDt(convertYearENtoTH(borrowSp.getBorrowDt()));
				if(borrowSp.getReturnDt() != null) borrowSp.setReturnDt(convertYearENtoTH(borrowSp.getReturnDt()));
				toSrch2.add(borrowSp);
			}
			//END edit by NEW 2015/07/15 Set format Date
			semmco003Bean.setBorrowSPList(packBorrowContractList(toSrch2));
		} else {
			semmco003Bean.setBorrowSPList(null);
		}
	}
	
	private boolean validateContractAdd() {
		boolean flgValid = true;
		if(StringUtils.isEmpty(getSemmco003Bean().getAddContractNo())){
			addMessageError("W0001", msg("message.contractNo"));
			flgValid = false;
		}
//		if(StringUtils.isEmpty(getSemmco003Bean().getAddContractNo())){
//			addMessageError("W0001", msg("message.contractNo"));
//			flgValid = false;
//		}
		return flgValid;
	}
	
	//addded by NEW 2015/0710 Search Contract popup
	private boolean doSearchBeforAddContract(){
		boolean flag = false;
		semmco003Bean = getSemmco003Bean();
		semmco003Bean.setRenderedMsgFormTop(false);
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		IBorrowRequestService borService = (IBorrowRequestService)getBean("borrowRequestService");
		List<Mco003ChkContractSP> chkList = new ArrayList<Mco003ChkContractSP>();
		List<Mco003SearchPSI002SP> to = new ArrayList<Mco003SearchPSI002SP>();
		Mco003SearchPSI002SP criteria = new Mco003SearchPSI002SP();
		try{
			if(semmco003Bean.getAddContractNo().isEmpty() || semmco003Bean.getAddContractNo().equals("")){
				addMessageError("W0001", msg("message.contractNo"));
				return flag;
			}
			
			// check duplicate
			Mco003ChkContractSP mco003ChkContractSP = new Mco003ChkContractSP();
			mco003ChkContractSP.setContractNo(semmco003Bean.getAddContractNo());
			if(semmco003Bean.getBorrowRequest().getCompany() != null){
				mco003ChkContractSP.setCompanyCode(semmco003Bean.getBorrowRequest().getCompany());
			}else{
				mco003ChkContractSP.setCompanyCode(semmco003Bean.getCriteriaBorrow().getCompany());
			}
			
			mco003ChkContractSP.setDocNo(semmco003Bean.getTmpDocNo());
			mco003ChkContractSP.setChkFlag("N");
			
			criteria.setCompany(semmco003Bean.getTmpCompany());
			criteria.setContractNo(semmco003Bean.getAddContractNo());
			
			chkList = service.querySPList(EQueryName.SP_MCO003_CHK_CONTRACT.name, mco003ChkContractSP);
//			if (chkList.contains(null) || chkList == null || chkList.isEmpty() || chkList.size() == 0) {
			if (chkList != null || !chkList.isEmpty() || chkList.size() > 0) {
				if(StringUtils.equalsIgnoreCase("Success", chkList.get(0).getlResult())){
					semmco003Bean.setRenderedMsgFormTop(true);
//					if(StringUtils.equalsIgnoreCase("W0110", chkList.get(0).getlMessage())){
//						addMessageWarn(chkList.get(0).getlMessage(), chkList.get(0).getlDesc());
//					}else{
//						addMessageWarn(chkList.get(0).getlMessage());
//					}
//					to = service.querySPList(EQueryName.SP_MCO003_SECH_PSI002.name, criteria);
					to = borService.querySPList(EQueryName.SP_MCO003_SECH_CONTRACT.name, criteria);
					log.debug("to = "+to);
					if(to == null || to.isEmpty()) {
//						semmco003Bean.setRenderedMsgFormTop(true);
//						addMessageError("W0032", semmco003Bean.getAddContractNo());	
					} else {
						
							// check duplicate
		//					Mco003ChkContractSP mco003ChkContractSP = new Mco003ChkContractSP();
		//					mco003ChkContractSP.setContractNo(semmco003Bean.getAddContractNo());
		//					mco003ChkContractSP.setCompanyCode(semmco003Bean.getTmpCompany());
		//					mco003ChkContractSP.setDocNo(semmco003Bean.getTmpDocNo());
		//					
		//					log.debug("semmco003Bean.getAddContractNo() = "+semmco003Bean.getAddContractNo());
		//					log.debug("semmco003Bean.getTmpCompany() = "+semmco003Bean.getTmpCompany());
		//					log.debug("semmco003Bean.getTmpDocNo() = "+semmco003Bean.getTmpDocNo());
		//					
		//					chkList = service.querySPList(EQueryName.SP_MCO003_CHK_CONTRACT.name, mco003ChkContractSP);
		//					
		//					log.debug("chkList = "+chkList);
							
							//if don't have value > Call { Procedure }  
							//if already have value > Show Error Message 
//							if (chkList.contains(null) || chkList == null || chkList.isEmpty() || chkList.size() == 0) {
								List<WrapperBeanObject<Mco003SearchPSI002SP>> resultList = new ArrayList<WrapperBeanObject<Mco003SearchPSI002SP>>();
								for(Mco003SearchPSI002SP psi002 : to){
//									Mco003InsertBorrowSP mco003InsertBorrowSP = new Mco003InsertBorrowSP();
//									mco003InsertBorrowSP.setDocNo(semmco003Bean.getTmpDocNo());
//									mco003InsertBorrowSP.setContractNo(psi002.getContractNo());
//									if(StringUtils.equalsIgnoreCase("EDIT", semmco003Bean.getMode())){
//										mco003InsertBorrowSP.setMode("EDIT");
//										mco003InsertBorrowSP.setBorrowRequestId(semmco003Bean.getInsertBorrowID());
//									}else {
//										mco003InsertBorrowSP.setMode("ADD");
//									}
//									mco003InsertBorrowSP.setpOption("D");
//									mco003InsertBorrowSP.setCompany(semmco003Bean.getTmpCompany());
//									mco003InsertBorrowSP.setUser(getUserLogIn());
//									resultList = borService.querySPList(EQueryName.SP_MCO003_INSERT.name, mco003InsertBorrowSP);
									if(psi002.getEffectiveDt() != null) psi002.setEffectiveDt(convertYearENtoTH(psi002.getEffectiveDt()));
									if(psi002.getExpireDt() != null) psi002.setExpireDt(convertYearENtoTH(psi002.getExpireDt()));
															
									WrapperBeanObject<Mco003SearchPSI002SP> tmpWrapperBean = new WrapperBeanObject<Mco003SearchPSI002SP>();
									
									tmpWrapperBean.setDataObj(psi002);
									tmpWrapperBean.setMessage("");
									tmpWrapperBean.setCheckBox(false);
									resultList.add(tmpWrapperBean);
								}
								// successful save borrow contract
								semmco003Bean.setContractSPList(resultList);
								semmco003Bean.setRenderedMsgFormTop(true);
//								addMessageInfo("M0001");
								
								//Contract combination >>> contract 001,contract 002, contract 003 ....
//								String str = semmco003Bean.getCacheContractAdd();
//								if (StringUtils.isEmpty(str)) {
//									str = semmco003Bean.getAddContractNo();
//								} else {
//									str += "," + semmco003Bean.getAddContractNo();
//								}
//								semmco003Bean.setCacheContractAdd(str);
//								semmco003Bean.setAddContractNo("");
//			
//								
//								String str2 = "";
		//						if (StringUtils.isNotEmpty(semmco003Bean.getCacheContractSrch())) {
		//							str2 = semmco003Bean.getCacheContractSrch();
		//							if (StringUtils.isNotEmpty(semmco003Bean.getCacheContractAdd())) {
		//								str2 += "," + semmco003Bean.getCacheContractAdd();
		//							}
		//						} else 
//									if (StringUtils.isNotEmpty(semmco003Bean.getCacheContractAdd())) {
//									str2 = semmco003Bean.getCacheContractAdd();
//								}
//								semmco003Bean.setContractAdd(str2);
		
								
//								Mco003SearchBorrowSP criteriaSrch = new Mco003SearchBorrowSP();
//								criteriaSrch.setCompany(semmco003Bean.getTmpCompany());
//								criteriaSrch.setBorrowRequestId(semmco003Bean.getInsertBorrowID());
//								List<Mco003SearchBorrowSP> toSrch = searchBorrowContract(criteriaSrch);
//								if (toSrch != null && toSrch.size() > 0) {
//									semmco003Bean.setBorrowSPList(packBorrowContractList(toSrch));
//								} else {
//									semmco003Bean.setBorrowSPList(null);
//								}
//							} else {
//								semmco003Bean.setRenderedMsgFormTop(true);
//								log.debug("chkList.get(0).getlMessage() = "+chkList.get(0).getlMessage());
//								log.debug("semmco003Bean.getAddContractNo() = "+semmco003Bean.getAddContractNo());
//								log.debug("semmco003Bean.getBorrowRequest().getCompany() = "+semmco003Bean.getBorrowRequest().getCompany());
//								if(StringUtils.equalsIgnoreCase("W0108", chkList.get(0).getlMessage())){
//									addMessageErrorWithArgument(chkList.get(0).getlMessage(), semmco003Bean.getAddContractNo(),semmco003Bean.getBorrowRequest().getCompany());
//								}else{
//									addMessageError(chkList.get(0).getlMessage());
//								}
//								semmco003Bean.setAddContractNo("");
//							}
					}
				}else{
					addMessageErrorWithArgument(chkList.get(0).getlMessage(), semmco003Bean.getAddContractNo(),semmco003Bean.getBorrowRequest().getCompany());
				}
			}
		}catch (Exception e) {
			addMessageError("E0001");
			e.printStackTrace();
			log.error("error from SEMMCO003Action doSearchBeforAddContract");
			log.error(e);
			// TODO: handle exception
		}finally{
			semmco003Bean.setDisabledBtnAdd(true);
			setSemmco003Bean(semmco003Bean);
		}
		return flag;
	}

	@SuppressWarnings("unchecked")
	private boolean doAddContract(){
		boolean flag = false;
		semmco003Bean = getSemmco003Bean();
		semmco003Bean.setRenderedMsgFormTop(false);
//		if(!validateContractAdd()){
//			semmco003Bean.setRenderedMsgFormTop(true);
//			setSemmco003Bean(semmco003Bean);
//			return flag;
//		}
		
		if(!StringUtils.equalsIgnoreCase("EDIT", semmco003Bean.getMode())&&!semmco003Bean.isOnePopupFlag()){
			semmco003Bean.setInsertBorrowID(semmco003Bean.getBorrowRequest().getDocNo());
			semmco003Bean.setSumSite(semmco003Bean.getBorrowRequest().getSiteNum().intValue());
		}else if(StringUtils.equalsIgnoreCase("EDIT", semmco003Bean.getMode())&&!semmco003Bean.isOnePopupFlag()){
			semmco003Bean.setSumSite(semmco003Bean.getBorrowRequest().getSiteNum().intValue());
		}
		// 20110214
		// check full site
		if(semmco003Bean.isOnePopupFlag()){
			semmco003Bean.setTmpCompany(semmco003Bean.getCriteriaBorrow().getCompany());
			semmco003Bean.setTmpDocNo(semmco003Bean.getCriteriaBorrow().getDocNo());
		}else{
			semmco003Bean.setTmpCompany(semmco003Bean.getBorrowRequest().getCompany());
			semmco003Bean.setTmpDocNo(semmco003Bean.getBorrowRequest().getDocNo());
		}
		
		Mco003SearchBorrowSP chkSite = new Mco003SearchBorrowSP();
		chkSite.setBorrowRequestId(semmco003Bean.getInsertBorrowID());
		chkSite.setCompany(semmco003Bean.getTmpCompany());
		chkSite.setStatus("02");
		List<Mco003SearchBorrowSP> chkSiteList = searchBorrowContract(chkSite);

		if (chkSiteList != null && chkSiteList.size() != 0) {
			if (chkSiteList.size() == semmco003Bean.getSumSite().intValue()) {
				semmco003Bean.setRenderedMsgFormTop(true);
				addMessageError("W0071");
				semmco003Bean.setAddContractNo("");
				setSemmco003Bean(semmco003Bean);
				return flag;
			}
		}
		
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			IBorrowRequestService borService = (IBorrowRequestService)getBean("borrowRequestService");
			List<Mco003ChkContractSP> chkList = null;
			List<Mco003SearchPSI002SP> to = null;
			Mco003SearchPSI002SP criteria = new Mco003SearchPSI002SP();
			Mco003SearchPSI002SP borrowContractSP = new Mco003SearchPSI002SP();
			List<Mco003InsertBorrowSP> resultList = null;
			
//			String contractNo = (StringUtils.isNotEmpty(semmco003Bean.getAddPreContractNo())?semmco003Bean.getAddPreContractNo().trim()+" ":"")
//			+ (StringUtils.isNotEmpty(semmco003Bean.getAddContractNo())?semmco003Bean.getAddContractNo().trim():"");
//			criteria.setCompany(semmco003Bean.getTmpCompany());
//			criteria.setContractNo(semmco003Bean.getAddContractNo());
			
			//edit by NEW 2015/07/10 
			List<WrapperBeanObject<Mco003SearchPSI002SP>> borrowContractList = getSemmco003Bean().getContractSPList();
			for (WrapperBeanObject<Mco003SearchPSI002SP> wrapperBeanObject : borrowContractList) {
				borrowContractSP = (Mco003SearchPSI002SP) wrapperBeanObject.getDataObj();
				if (wrapperBeanObject.isCheckBox()) {
					
					criteria.setCompany(semmco003Bean.getTmpCompany());
					criteria.setContractNo(borrowContractSP.getContractNo());
					
					
					// check duplicate
					Mco003ChkContractSP mco003ChkContractSP = new Mco003ChkContractSP();
					mco003ChkContractSP.setContractNo(borrowContractSP.getContractNo());
					if(semmco003Bean.getBorrowRequest().getCompany()!=null){
						mco003ChkContractSP.setCompanyCode(semmco003Bean.getBorrowRequest().getCompany());
					}else{
						mco003ChkContractSP.setCompanyCode(semmco003Bean.getCriteriaBorrow().getCompany());
					}
					
					mco003ChkContractSP.setDocNo(semmco003Bean.getTmpDocNo());
					//edit by NEW 2015/07/10
					mco003ChkContractSP.setChkFlag("Y");
					mco003ChkContractSP.setSiteInfoId(borrowContractSP.getRowId());
					
					chkList = service.querySPList(EQueryName.SP_MCO003_CHK_CONTRACT.name, mco003ChkContractSP);
//					if (chkList.contains(null) || chkList == null || chkList.isEmpty() || chkList.size() == 0) {
					if (chkList != null || !chkList.isEmpty() || chkList.size() > 0) {
						if(StringUtils.equalsIgnoreCase("Success", chkList.get(0).getlResult())){
							semmco003Bean.setRenderedMsgFormTop(true);
//							if(StringUtils.equalsIgnoreCase("W0110", chkList.get(0).getlMessage())){
//								addMessageWarn(chkList.get(0).getlMessage(), chkList.get(0).getlDesc());
//							}else{
//								addMessageWarn(chkList.get(0).getlMessage());
//							}
//							to = service.querySPList(EQueryName.SP_MCO003_SECH_PSI002.name, criteria);
//							log.debug("to = "+to);
//							if(to == null || to.isEmpty()) {
////								semmco003Bean.setRenderedMsgFormTop(true);
////								addMessageError("W0032", semmco003Bean.getAddContractNo());	
//							} else {
								
									// check duplicate
				//					Mco003ChkContractSP mco003ChkContractSP = new Mco003ChkContractSP();
				//					mco003ChkContractSP.setContractNo(semmco003Bean.getAddContractNo());
				//					mco003ChkContractSP.setCompanyCode(semmco003Bean.getTmpCompany());
				//					mco003ChkContractSP.setDocNo(semmco003Bean.getTmpDocNo());
				//					
				//					log.debug("semmco003Bean.getAddContractNo() = "+semmco003Bean.getAddContractNo());
				//					log.debug("semmco003Bean.getTmpCompany() = "+semmco003Bean.getTmpCompany());
				//					log.debug("semmco003Bean.getTmpDocNo() = "+semmco003Bean.getTmpDocNo());
				//					
				//					chkList = service.querySPList(EQueryName.SP_MCO003_CHK_CONTRACT.name, mco003ChkContractSP);
				//					
				//					log.debug("chkList = "+chkList);
									
									//if don't have value > Call { Procedure }  
									//if already have value > Show Error Message 
//									if (chkList.contains(null) || chkList == null || chkList.isEmpty() || chkList.size() == 0) {
//										List<Mco003InsertBorrowSP> resultList = null;
//										for(Mco003SearchPSI002SP psi002 : to){
//											Mco003InsertBorrowSP mco003InsertBorrowSP = new Mco003InsertBorrowSP();
//											mco003InsertBorrowSP.setDocNo(semmco003Bean.getTmpDocNo());
//											mco003InsertBorrowSP.setContractNo(psi002.getContractNo());
//											if(StringUtils.equalsIgnoreCase("EDIT", semmco003Bean.getMode())){
//												mco003InsertBorrowSP.setMode("EDIT");
//												mco003InsertBorrowSP.setBorrowRequestId(semmco003Bean.getInsertBorrowID());
//											}else {
//												mco003InsertBorrowSP.setMode("ADD");
//											}
//											mco003InsertBorrowSP.setpOption("D");
//											mco003InsertBorrowSP.setCompany(semmco003Bean.getTmpCompany());
//											mco003InsertBorrowSP.setUser(getUserLogIn());
//											resultList = borService.querySPList(EQueryName.SP_MCO003_INSERT.name, mco003InsertBorrowSP);
//										}
										Mco003InsertBorrowSP mco003InsertBorrowSP = new Mco003InsertBorrowSP();
										mco003InsertBorrowSP.setDocNo(semmco003Bean.getTmpDocNo());
										mco003InsertBorrowSP.setContractNo(borrowContractSP.getContractNo());
										if(StringUtils.equalsIgnoreCase("EDIT", semmco003Bean.getMode())){
											mco003InsertBorrowSP.setMode("EDIT");
											mco003InsertBorrowSP.setBorrowRequestId(semmco003Bean.getInsertBorrowID());
										}else {
											mco003InsertBorrowSP.setMode("ADD");
										}
										mco003InsertBorrowSP.setpOption("D");
										mco003InsertBorrowSP.setCompany(borrowContractSP.getCompany());
										mco003InsertBorrowSP.setUser(getUserLogIn());
										mco003InsertBorrowSP.setSiteInfoId(borrowContractSP.getRowId());
										mco003InsertBorrowSP.setStatus("02");
										resultList = borService.querySPList(EQueryName.SP_MCO003_INSERT.name, mco003InsertBorrowSP);
										// successful save borrow contract
										semmco003Bean.setRenderedMsgFormTop(true);
//										addMessageInfo("M0001");
										
										//Contract combination >>> contract 001,contract 002, contract 003 ....
										String str = semmco003Bean.getCacheContractAdd();
										if (StringUtils.isEmpty(str)) {
											str = semmco003Bean.getAddContractNo();
										} else {
											str += "," + semmco003Bean.getAddContractNo();
										}
										semmco003Bean.setCacheContractAdd(str);
										semmco003Bean.setAddContractNo("");
					
										
										String str2 = "";
				//						if (StringUtils.isNotEmpty(semmco003Bean.getCacheContractSrch())) {
				//							str2 = semmco003Bean.getCacheContractSrch();
				//							if (StringUtils.isNotEmpty(semmco003Bean.getCacheContractAdd())) {
				//								str2 += "," + semmco003Bean.getCacheContractAdd();
				//							}
				//						} else 
											if (StringUtils.isNotEmpty(semmco003Bean.getCacheContractAdd())) {
											str2 = semmco003Bean.getCacheContractAdd();
										}
										semmco003Bean.setContractAdd(str2);
				
										
										Mco003SearchBorrowSP criteriaSrch = new Mco003SearchBorrowSP();
										criteriaSrch.setCompany(semmco003Bean.getTmpCompany());
										criteriaSrch.setBorrowRequestId(semmco003Bean.getInsertBorrowID());
										criteriaSrch.setStatus("02");
										List<Mco003SearchBorrowSP> toSrch = searchBorrowContract(criteriaSrch);
										if (toSrch != null && toSrch.size() > 0) {
											semmco003Bean.setBorrowSPList(packBorrowContractList(toSrch));
										} else {
											semmco003Bean.setBorrowSPList(null);
										}
//									} else {
//										semmco003Bean.setRenderedMsgFormTop(true);
//										log.debug("chkList.get(0).getlMessage() = "+chkList.get(0).getlMessage());
//										log.debug("semmco003Bean.getAddContractNo() = "+semmco003Bean.getAddContractNo());
//										log.debug("semmco003Bean.getBorrowRequest().getCompany() = "+semmco003Bean.getBorrowRequest().getCompany());
//										if(StringUtils.equalsIgnoreCase("W0108", chkList.get(0).getlMessage())){
//											addMessageErrorWithArgument(chkList.get(0).getlMessage(), semmco003Bean.getAddContractNo(),semmco003Bean.getBorrowRequest().getCompany());
//										}else{
//											addMessageError(chkList.get(0).getlMessage());
//										}
//										semmco003Bean.setAddContractNo("");
//									}
//							}
						}else{
							semmco003Bean.setRenderedMsgFormTop(true);
//							log.debug("chkList.get(0).getlMessage() = "+chkList.get(0).getlMessage());
//							log.debug("semmco003Bean.getAddContractNo() = "+semmco003Bean.getAddContractNo());
//							log.debug("semmco003Bean.getBorrowRequest().getCompany() = "+semmco003Bean.getBorrowRequest().getCompany());
							if(StringUtils.equalsIgnoreCase("W0108", chkList.get(0).getlMessage())){
								addMessageErrorWithArgument(chkList.get(0).getlMessage(), semmco003Bean.getAddContractNo(),semmco003Bean.getTmpCompany());
							}else if(StringUtils.equalsIgnoreCase("W0110", chkList.get(0).getlMessage())){
								addMessageErrorWithArgument(chkList.get(0).getlMessage(), chkList.get(0).getlDesc());
							}else{
								addMessageError(chkList.get(0).getlMessage());
							}
							semmco003Bean.setAddContractNo("");
						}
						
					} else {
						semmco003Bean.setRenderedMsgFormTop(true);
//						log.debug("chkList.get(0).getlMessage() = "+chkList.get(0).getlMessage());
//						log.debug("semmco003Bean.getAddContractNo() = "+semmco003Bean.getAddContractNo());
//						log.debug("semmco003Bean.getBorrowRequest().getCompany() = "+semmco003Bean.getBorrowRequest().getCompany());
						if(StringUtils.equalsIgnoreCase("W0108", chkList.get(0).getlMessage())){
							addMessageErrorWithArgument(chkList.get(0).getlMessage(), semmco003Bean.getAddContractNo(),semmco003Bean.getTmpCompany());
						}else if(StringUtils.equalsIgnoreCase("W0110", chkList.get(0).getlMessage())){
							addMessageErrorWithArgument(chkList.get(0).getlMessage(), chkList.get(0).getlDesc());
						}else{
							addMessageError(chkList.get(0).getlMessage());
						}
						semmco003Bean.setAddContractNo("");
					}
				}
			}
			
			//search borrow contract
			if(resultList != null && resultList.size() > 0){
				to = borService.querySPList(EQueryName.SP_MCO003_SECH_CONTRACT.name, criteria);
				
				List<WrapperBeanObject<Mco003SearchPSI002SP>> borrowList = new ArrayList<WrapperBeanObject<Mco003SearchPSI002SP>>();
				if(to != null && to.size() > 0){
					for(Mco003SearchPSI002SP psi002 : to){
//						Mco003InsertBorrowSP mco003InsertBorrowSP = new Mco003InsertBorrowSP();
//						mco003InsertBorrowSP.setDocNo(semmco003Bean.getTmpDocNo());
//						mco003InsertBorrowSP.setContractNo(psi002.getContractNo());
//						if(StringUtils.equalsIgnoreCase("EDIT", semmco003Bean.getMode())){
//							mco003InsertBorrowSP.setMode("EDIT");
//							mco003InsertBorrowSP.setBorrowRequestId(semmco003Bean.getInsertBorrowID());
//						}else {
//							mco003InsertBorrowSP.setMode("ADD");
//						}
//						mco003InsertBorrowSP.setpOption("D");
//						mco003InsertBorrowSP.setCompany(semmco003Bean.getTmpCompany());
//						mco003InsertBorrowSP.setUser(getUserLogIn());
//						resultList = borService.querySPList(EQueryName.SP_MCO003_INSERT.name, mco003InsertBorrowSP);
						
						WrapperBeanObject<Mco003SearchPSI002SP> tmpWrapperBean = new WrapperBeanObject<Mco003SearchPSI002SP>();
						
						tmpWrapperBean.setDataObj(psi002);
						tmpWrapperBean.setMessage("");
						tmpWrapperBean.setCheckBox(false);
						borrowList.add(tmpWrapperBean);
					}
					// successful save borrow contract
					semmco003Bean.setContractSPList(borrowList);
				}
				
			}
			//COMMENT BY NEW 20150710 MOVE CODE TO LOOP FOR
//			// check duplicate
//			Mco003ChkContractSP mco003ChkContractSP = new Mco003ChkContractSP();
//			mco003ChkContractSP.setContractNo(semmco003Bean.getAddContractNo());
//			mco003ChkContractSP.setCompanyCode(semmco003Bean.getTmpCompany());
//			mco003ChkContractSP.setDocNo(semmco003Bean.getTmpDocNo());
//			
//			
//			chkList = service.querySPList(EQueryName.SP_MCO003_CHK_CONTRACT.name, mco003ChkContractSP);
////			if (chkList.contains(null) || chkList == null || chkList.isEmpty() || chkList.size() == 0) {
//			if (chkList != null || !chkList.isEmpty() || chkList.size() > 0) {
//				if(StringUtils.equalsIgnoreCase("Success", chkList.get(0).getlResult())){
//					semmco003Bean.setRenderedMsgFormTop(true);
//					if(StringUtils.equalsIgnoreCase("W0110", chkList.get(0).getlMessage())){
//						addMessageWarn(chkList.get(0).getlMessage(), chkList.get(0).getlDesc());
//					}else{
//						addMessageWarn(chkList.get(0).getlMessage());
//					}
//					to = service.querySPList(EQueryName.SP_MCO003_SECH_PSI002.name, criteria);
//					log.debug("to = "+to);
//					if(to == null || to.isEmpty()) {
////						semmco003Bean.setRenderedMsgFormTop(true);
////						addMessageError("W0032", semmco003Bean.getAddContractNo());	
//					} else {
//						
//							// check duplicate
//		//					Mco003ChkContractSP mco003ChkContractSP = new Mco003ChkContractSP();
//		//					mco003ChkContractSP.setContractNo(semmco003Bean.getAddContractNo());
//		//					mco003ChkContractSP.setCompanyCode(semmco003Bean.getTmpCompany());
//		//					mco003ChkContractSP.setDocNo(semmco003Bean.getTmpDocNo());
//		//					
//		//					log.debug("semmco003Bean.getAddContractNo() = "+semmco003Bean.getAddContractNo());
//		//					log.debug("semmco003Bean.getTmpCompany() = "+semmco003Bean.getTmpCompany());
//		//					log.debug("semmco003Bean.getTmpDocNo() = "+semmco003Bean.getTmpDocNo());
//		//					
//		//					chkList = service.querySPList(EQueryName.SP_MCO003_CHK_CONTRACT.name, mco003ChkContractSP);
//		//					
//		//					log.debug("chkList = "+chkList);
//							
//							//if don't have value > Call { Procedure }  
//							//if already have value > Show Error Message 
////							if (chkList.contains(null) || chkList == null || chkList.isEmpty() || chkList.size() == 0) {
//								List<Mco003InsertBorrowSP> resultList = null;
//								for(Mco003SearchPSI002SP psi002 : to){
//									Mco003InsertBorrowSP mco003InsertBorrowSP = new Mco003InsertBorrowSP();
//									mco003InsertBorrowSP.setDocNo(semmco003Bean.getTmpDocNo());
//									mco003InsertBorrowSP.setContractNo(psi002.getContractNo());
//									if(StringUtils.equalsIgnoreCase("EDIT", semmco003Bean.getMode())){
//										mco003InsertBorrowSP.setMode("EDIT");
//										mco003InsertBorrowSP.setBorrowRequestId(semmco003Bean.getInsertBorrowID());
//									}else {
//										mco003InsertBorrowSP.setMode("ADD");
//									}
//									mco003InsertBorrowSP.setpOption("D");
//									mco003InsertBorrowSP.setCompany(semmco003Bean.getTmpCompany());
//									mco003InsertBorrowSP.setUser(getUserLogIn());
//									resultList = borService.querySPList(EQueryName.SP_MCO003_INSERT.name, mco003InsertBorrowSP);
//								}
//								// successful save borrow contract
//								semmco003Bean.setRenderedMsgFormTop(true);
////								addMessageInfo("M0001");
//								
//								//Contract combination >>> contract 001,contract 002, contract 003 ....
//								String str = semmco003Bean.getCacheContractAdd();
//								if (StringUtils.isEmpty(str)) {
//									str = semmco003Bean.getAddContractNo();
//								} else {
//									str += "," + semmco003Bean.getAddContractNo();
//								}
//								semmco003Bean.setCacheContractAdd(str);
//								semmco003Bean.setAddContractNo("");
//			
//								
//								String str2 = "";
//		//						if (StringUtils.isNotEmpty(semmco003Bean.getCacheContractSrch())) {
//		//							str2 = semmco003Bean.getCacheContractSrch();
//		//							if (StringUtils.isNotEmpty(semmco003Bean.getCacheContractAdd())) {
//		//								str2 += "," + semmco003Bean.getCacheContractAdd();
//		//							}
//		//						} else 
//									if (StringUtils.isNotEmpty(semmco003Bean.getCacheContractAdd())) {
//									str2 = semmco003Bean.getCacheContractAdd();
//								}
//								semmco003Bean.setContractAdd(str2);
//		
//								
//								Mco003SearchBorrowSP criteriaSrch = new Mco003SearchBorrowSP();
//								criteriaSrch.setCompany(semmco003Bean.getTmpCompany());
//								criteriaSrch.setBorrowRequestId(semmco003Bean.getInsertBorrowID());
//								List<Mco003SearchBorrowSP> toSrch = searchBorrowContract(criteriaSrch);
//								if (toSrch != null && toSrch.size() > 0) {
//									semmco003Bean.setBorrowSPList(packBorrowContractList(toSrch));
//								} else {
//									semmco003Bean.setBorrowSPList(null);
//								}
////							} else {
////								semmco003Bean.setRenderedMsgFormTop(true);
////								log.debug("chkList.get(0).getlMessage() = "+chkList.get(0).getlMessage());
////								log.debug("semmco003Bean.getAddContractNo() = "+semmco003Bean.getAddContractNo());
////								log.debug("semmco003Bean.getBorrowRequest().getCompany() = "+semmco003Bean.getBorrowRequest().getCompany());
////								if(StringUtils.equalsIgnoreCase("W0108", chkList.get(0).getlMessage())){
////									addMessageErrorWithArgument(chkList.get(0).getlMessage(), semmco003Bean.getAddContractNo(),semmco003Bean.getBorrowRequest().getCompany());
////								}else{
////									addMessageError(chkList.get(0).getlMessage());
////								}
////								semmco003Bean.setAddContractNo("");
////							}
//					}
//				}else{
//					semmco003Bean.setRenderedMsgFormTop(true);
////					log.debug("chkList.get(0).getlMessage() = "+chkList.get(0).getlMessage());
////					log.debug("semmco003Bean.getAddContractNo() = "+semmco003Bean.getAddContractNo());
////					log.debug("semmco003Bean.getBorrowRequest().getCompany() = "+semmco003Bean.getBorrowRequest().getCompany());
//					if(StringUtils.equalsIgnoreCase("W0108", chkList.get(0).getlMessage())){
//						addMessageErrorWithArgument(chkList.get(0).getlMessage(), semmco003Bean.getAddContractNo(),semmco003Bean.getTmpCompany());
//					}else if(StringUtils.equalsIgnoreCase("W0110", chkList.get(0).getlMessage())){
//						addMessageErrorWithArgument(chkList.get(0).getlMessage(), chkList.get(0).getlDesc());
//					}else{
//						addMessageError(chkList.get(0).getlMessage());
//					}
//					semmco003Bean.setAddContractNo("");
//				}
//				
//			} else {
//				semmco003Bean.setRenderedMsgFormTop(true);
////				log.debug("chkList.get(0).getlMessage() = "+chkList.get(0).getlMessage());
////				log.debug("semmco003Bean.getAddContractNo() = "+semmco003Bean.getAddContractNo());
////				log.debug("semmco003Bean.getBorrowRequest().getCompany() = "+semmco003Bean.getBorrowRequest().getCompany());
//				if(StringUtils.equalsIgnoreCase("W0108", chkList.get(0).getlMessage())){
//					addMessageErrorWithArgument(chkList.get(0).getlMessage(), semmco003Bean.getAddContractNo(),semmco003Bean.getTmpCompany());
//				}else if(StringUtils.equalsIgnoreCase("W0110", chkList.get(0).getlMessage())){
//					addMessageErrorWithArgument(chkList.get(0).getlMessage(), chkList.get(0).getlDesc());
//				}else{
//					addMessageError(chkList.get(0).getlMessage());
//				}
//				semmco003Bean.setAddContractNo("");
//			}
		} catch (Exception e){
			e.printStackTrace();
			addMessageError("E0001");
		}
		semmco003Bean.setDisabledBtnAdd(true);
		setSemmco003Bean(semmco003Bean);
		return flag;
	}
	
	@SuppressWarnings("unchecked")
	private boolean initBorrowContract(){
		boolean flag = true;
		semmco003Bean = getSemmco003Bean();
		semmco003Bean.setPopupBorrowOpen(true);
		semmco003Bean.setPopupAlert(false);
		semmco003Bean.setBorrowContract(new BorrowContract());
		String popup = (String)getFacesUtils().getRequestParameter("popup");
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		String effDtStr = (String)getFacesUtils().getRequestParameter("effDt");
		String expDtStr = (String)getFacesUtils().getRequestParameter("expDt");
		semmco003Bean.setBtnBorrowPopup(popup);
		semmco003Bean.setMode(mode);
		semmco003Bean.setOtherBorrowName("");
		semmco003Bean.setEffDtStr(effDtStr);
		semmco003Bean.setExpDtStr(expDtStr);
		
		if (mode.equals("EDIT") || mode.equals("VIEW")) {
			
			IBorrowRequestService borService = (IBorrowRequestService)getBean("borrowRequestService");
			String rowId = (String)getFacesUtils().getRequestParameter("rowId");
			semmco003Bean.setBorrowContract(borService.queryBorrowContractByRowId(rowId));
			// 20101213
			if (StringUtils.isEmpty(semmco003Bean.getBorrowContract().getBorrowForType())){
				semmco003Bean.getBorrowContract().setBorrowForType("00");
			}
//			semmco003Bean.setBorrowForList(getLovItemsByType(ELovType.T_CO_BORROW_FOR_TYPE.name));
			
			String docApproveFlag = semmco003Bean.getBorrowContract().getDocApproveFlag();
			String docContractFlag = semmco003Bean.getBorrowContract().getDocContractFlag();
			String docOtherFlag = semmco003Bean.getBorrowContract().getDocOtherFlag();
			String cannotBorrowFlag = semmco003Bean.getBorrowContract().getCannotBorrowFlag();
			if (docApproveFlag != null && docApproveFlag.equals("Y")) {
				semmco003Bean.getBorrowContract().setDocApproveFlag("TRUE");
			    semmco003Bean.setDocApproveFlagBoolean(true);
			}
			if (docContractFlag != null && docContractFlag.equals("Y")) {
				semmco003Bean.getBorrowContract().setDocContractFlag("TRUE");
			    semmco003Bean.setDocContractFlagBoolean(true);
			}
			if (docOtherFlag != null && docOtherFlag.equals("Y")) {
				semmco003Bean.getBorrowContract().setDocOtherFlag("TRUE");
				semmco003Bean.setDocOtherFlagBoolean(true);
			}
			if (cannotBorrowFlag != null && cannotBorrowFlag.equals("Y")) {
				semmco003Bean.getBorrowContract().setCannotBorrowFlag("TRUE");
				semmco003Bean.setCannotBorrowFlagBoolean(true);
			}	
			
			if (mode.equals("EDIT")) {
				if (semmco003Bean.getBorrowContract().getBorrowDt() == null) {
					semmco003Bean.getBorrowContract().setBorrowDt(new Date());
					semmco003Bean.getBorrowContract().setDocApproveFlag("TRUE");
					semmco003Bean.getBorrowContract().setDocContractFlag("TRUE");
					semmco003Bean.setDocApproveFlagBoolean(true);
					semmco003Bean.setDocContractFlagBoolean(true);
					
				}
			}
			
			boolean flg = false;
			if (semmco003Bean.getBorrowContract() != null) {
				if (semmco003Bean.getBorrowContract().getBorrowName() != null) {
					for (SelectItem o: semmco003Bean.getBorrowNameList()) {
						if (semmco003Bean.getBorrowContract().getBorrowName().equals(o.getLabel())) {
							flg = true;
							break;
						}
					}
				}
			}
			if (flg) {
				semmco003Bean.setDisTxtBorrowName(false);
			} else {
				semmco003Bean.setDisTxtBorrowName(true);
				semmco003Bean.setOtherBorrowName(semmco003Bean.getBorrowContract().getBorrowName());
			}
			
		} else {
			
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			semmco003Bean.setBorrowContract(new BorrowContract());
			semmco003Bean.getBorrowContract().setBorrowForType("01");
			semmco003Bean.getBorrowContract().setBorrowDt(new Date());
			semmco003Bean.getBorrowContract().setDocApproveFlag("TRUE");
			semmco003Bean.getBorrowContract().setDocContractFlag("TRUE");
			semmco003Bean.setDocApproveFlagBoolean(true);
			semmco003Bean.setDocContractFlagBoolean(true);
			
			String tmpContractId = "";
			List<WrapperBeanObject<Mco003SearchBorrowSP>> bgMaster = getSemmco003Bean().getBorrowSPList();
			for (WrapperBeanObject<Mco003SearchBorrowSP> wrapperBeanObject : bgMaster) {
				if(wrapperBeanObject.isCheckBox()){
					Mco003SearchBorrowSP tmp = (Mco003SearchBorrowSP)wrapperBeanObject.getDataObj();
					tmpContractId += (tmpContractId.equals(""))? tmp.getBorrowContractId(): "," + tmp.getBorrowContractId();
				}
			}
			semmco003Bean.setBorrowContractIdList(tmpContractId);
			Mco003ChkBorrow mco003ChkBorrow = new Mco003ChkBorrow();
			mco003ChkBorrow.setBorrowContractId(tmpContractId);
			try {
				List<Mco003ChkBorrow> list = service.querySPList(EQueryName.SP_MCO003_CHK_BORROW.name, mco003ChkBorrow);
				if (list != null && list.size() > 0) {
					if (null != list.get(0) && StringUtils.isNotEmpty(list.get(0).getContractNo())) {
						semmco003Bean.setPopupBorrowOpen(false);
						semmco003Bean.setPopupAlert(true);
						semmco003Bean.setContentAlert(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("Q0014"), list.get(0).getContractNo()));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		List<SelectItem> itemList = getLovItemsByType(ELovType.T_CO_BORROW_OFFICER.name);
		if(itemList!=null){
			semmco003Bean.setBorrowOfficerList(itemList);
		} else {
			semmco003Bean.setBorrowOfficerList(new ArrayList<SelectItem>());
		}
		
		setSemmco003Bean(semmco003Bean);
		return flag;
	}
	
	@SuppressWarnings("unchecked")
	private boolean doSaveContractDetail(){
		boolean flag = true;
		semmco003Bean = getSemmco003Bean();
		if(!validateContractDetail()){
			semmco003Bean.setRenderedMsgFormTop(true);
			semmco003Bean.setPopupClose(false);
			setSemmco003Bean(semmco003Bean);
			return flag;
		}
		try{
			log.debug("officer = "+semmco003Bean.getBorrowContract().getBorrowOfficer());
			BorrowContract contract = semmco003Bean.getBorrowContract();
			/*  remove 01/12/2022 ---> not use 
				contract.setDocApproveFlag((contract.getDocApproveFlag().equals("true"))?"Y":"");
				contract.setDocContractFlag((contract.getDocContractFlag().equals("true"))?"Y":"");
				contract.setDocOtherFlag((contract.getDocOtherFlag().equals("true"))?"Y":"");
				contract.setCannotBorrowFlag((contract.getCannotBorrowFlag().equals("true"))?"Y":"");
			*/	
			/*  add 01/12/2022 ---> Change to boolean  */
			contract.setDocApproveFlag(semmco003Bean.isDocApproveFlagBoolean()?"Y":"");
			contract.setDocContractFlag(semmco003Bean.isDocContractFlagBoolean()?"Y":"");
			contract.setDocOtherFlag(semmco003Bean.isDocOtherFlagBoolean()?"Y":"");
			contract.setCannotBorrowFlag(semmco003Bean.isCannotBorrowFlagBoolean()?"Y":"");
			
			
//			if(StringUtils.equalsIgnoreCase("Y", contract.getDocContractFlag())&& StringUtils.isEmpty(contract.getDocContractDetail())){
//				contract.setDocContractDetail(SEMDataUtility.toStringThaiDateSimpleFormat(contract.getBorrowDt()));
//			}
//			if(StringUtils.equalsIgnoreCase("Y", contract.getDocOtherFlag())&& StringUtils.isEmpty(contract.getRemarkDocOther())){
//				contract.setRemarkDocOther(SEMDataUtility.toStringThaiDateSimpleFormat(contract.getBorrowDt()));
//			}
			if(StringUtils.isEmpty(contract.getDocContractDetail())){
				contract.setDocContractDetail(semmco003Bean.getEffDtStr()+" - "+semmco003Bean.getExpDtStr());
			}
			if (StringUtils.isEmpty(contract.getBorrowName())) {
				contract.setBorrowName(semmco003Bean.getOtherBorrowName());
			}
			
//			if(semmco003Bean.getMode().equals("EDIT")){
//				IBorrowRequestService borService = (IBorrowRequestService)getBean("borrowRequestService");
//				borService.updateBorrowContract(contract);
//			} else {
				IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
				
				Mco003SaveBorrow mco003SaveBorrow = new Mco003SaveBorrow();
				if(semmco003Bean.getMode().equals("EDIT")){
					mco003SaveBorrow.setBorrowContractId(contract.getRowId());
				}else{
					mco003SaveBorrow.setBorrowContractId(semmco003Bean.getBorrowContractIdList());	
				}
				mco003SaveBorrow.setBorrowName(contract.getBorrowName());
				mco003SaveBorrow.setBorrowDt(contract.getBorrowDt());
				mco003SaveBorrow.setBorrowOfficer(contract.getBorrowOfficer());
				mco003SaveBorrow.setBorrowForType(contract.getBorrowForType());
				mco003SaveBorrow.setRemarkBorrowFor(contract.getRemarkBorrowFor());
				mco003SaveBorrow.setDocApproveFlag(contract.getDocApproveFlag());
				mco003SaveBorrow.setDocContractFlag(contract.getDocContractFlag());
				mco003SaveBorrow.setDocContractDetail(contract.getDocContractDetail());
				mco003SaveBorrow.setDocOtherFlag(contract.getDocOtherFlag());
				mco003SaveBorrow.setRemarkDocOther(contract.getRemarkDocOther());
				mco003SaveBorrow.setCannotBorrowFlag(contract.getCannotBorrowFlag());
				mco003SaveBorrow.setRemarkCannotBorrow(contract.getRemarkCannotBorrow());
				mco003SaveBorrow.setCurrentUser(getUserLogIn());
				mco003SaveBorrow.setContractType(contract.getContractType());
				//
				mco003SaveBorrow.setStatus("02");
				
				List<Mco003SaveBorrow> resultList = service.querySPList(EQueryName.SP_MCO003_SAVE_BORROW.name, mco003SaveBorrow);
				if (StringUtils.equalsIgnoreCase("Success", resultList.get(0).getResult())) {
					semmco003Bean.setPopupClose(true);
					addMessageInfo("M0001");
					this.onRenderExportButton();
				}else{
					semmco003Bean.setPopupClose(false);
					addMessageError(resultList.get(0).getMessage());
				}
//			}
			
			
			
		}catch(Exception e){
			e.printStackTrace();
			semmco003Bean.setPopupClose(false);
			addMessageError("E0001");
		}
		setSemmco003Bean(semmco003Bean);
		flag = doSearchContract();
		return flag;
	}
	
	private boolean validateContractDetail() {
		boolean flgValid = true;
		if(StringUtils.isEmpty(getSemmco003Bean().getBorrowContract().getBorrowName())){
			if (StringUtils.isEmpty(getSemmco003Bean().getOtherBorrowName())) {
				addMessageError("W0001", msg("message.borrowName"));
				flgValid = false;
			}
			
		}
		
		if (getSemmco003Bean().getBorrowContract().getBorrowDt() == null) {
			addMessageError("W0001", msg("message.borrowDt"));
			flgValid = false;
		}
		
		if (StringUtils.isEmpty(getSemmco003Bean().getBorrowContract().getBorrowOfficer())) {
			addMessageError("W0001", msg("message.borrowOfficer"));
			flgValid = false;
		}
		
		//if (getSemmco003Bean().getBorrowContract().getCannotBorrowFlag().equals("true")) { //---> remove 01/12/2022
		if (getSemmco003Bean().isCannotBorrowFlagBoolean()) {
			if (StringUtils.isEmpty(getSemmco003Bean().getBorrowContract().getRemarkCannotBorrow())) {
				addMessageError("W0001", msg("export.column.remarkCannotBorrow"));
				flgValid = false;
			}
		}
		return flgValid;
	}
	
	private ReturnContract getBorrowContractByContractId(String contractID, String returnID, String mode) {
		ReturnContract returnCtx = null;
		IBorrowRequestService borService = (IBorrowRequestService)getBean("borrowRequestService");
		BorrowContract borrow = borService.queryBorrowContractByRowId(contractID);
		
		if(returnID.equals("")){
			returnCtx = new ReturnContract();
			returnCtx.setBorrowContractId(borrow.getRowId());
			returnCtx.setRentType("01");
			returnCtx.setReturnNotAllFlag("FALSE");
			semmco003Bean.setMode("ADD");
		} else {
			returnCtx = borService.queryReturnContractByRowId(returnID);
			returnCtx.setReturnNotAllFlag((returnCtx.getReturnNotAllFlag() != null)? "TRUE": "FALSE");
			returnCtx.setDocApproveFlag((returnCtx.getDocApproveFlag() != null)? "TRUE": "FALSE");
			returnCtx.setDocContractFlag((returnCtx.getDocContractFlag() != null)? "TRUE": "FALSE");
			returnCtx.setDocOtherFlag((returnCtx.getDocOtherFlag() != null)? "TRUE": "FALSE");
			returnCtx.setDocOtherAddFlag((returnCtx.getDocOtherAddFlag() != null)? "TRUE": "FALSE");
			semmco003Bean.setMode(mode);
		}
		
		return returnCtx;
	}
	
	@SuppressWarnings("unchecked")
	private boolean doinitReturnContract(){
		boolean flag = true;
		semmco003Bean = getSemmco003Bean();
		semmco003Bean.setPopupBorrowOpen(true);
		semmco003Bean.setPopupAlert(false);
		semmco003Bean.setOtherReturnName("");
		
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		String returnID = (String)getFacesUtils().getRequestParameter("returnID");
		String contractID = (String)getFacesUtils().getRequestParameter("contractID");
		String popup = (String)getFacesUtils().getRequestParameter("popup");
		
		//added by NEW
		String siteAppId = getFacesUtils().getRequestParameter("siteAppId") == null ? "" : (String) getFacesUtils().getRequestParameter("siteAppId");
		String placeType = getFacesUtils().getRequestParameter("placeType") == null ? "" : (String) getFacesUtils().getRequestParameter("placeType");
		String partiesType = getFacesUtils().getRequestParameter("partiesType") == null ? "" : (String) getFacesUtils().getRequestParameter("partiesType");
		String placeTypeRemark = getFacesUtils().getRequestParameter("placeTypeRemark") == null ? "" : (String) getFacesUtils().getRequestParameter("placeTypeRemark");
		String partiesTypeRemark = getFacesUtils().getRequestParameter("partiesTypeRemark") == null ? "" : (String) getFacesUtils().getRequestParameter("partiesTypeRemark");
		String docApproveId = getFacesUtils().getRequestParameter("docApproveId") == null ? "" : (String) getFacesUtils().getRequestParameter("docApproveId");
		
		semmco003Bean.setSiteAppObjParam(new SiteAppSP());
		semmco003Bean.getSiteAppObjParam().setSiteAppId(siteAppId);
		semmco003Bean.getSiteAppObjParam().setDocApproveId(docApproveId);
		if(!placeType.isEmpty())
			semmco003Bean.getSiteAppObjParam().setPlaceType(placeType);
		else
			semmco003Bean.getSiteAppObjParam().setPlaceType("");
		semmco003Bean.getSiteAppObjParam().setPlaceTypeRemark(placeTypeRemark);
		if(!partiesType.isEmpty())
			semmco003Bean.getSiteAppObjParam().setPartiesType(partiesType);
		else
			semmco003Bean.getSiteAppObjParam().setPartiesType("");
		semmco003Bean.getSiteAppObjParam().setPartiesTypeRemark(partiesTypeRemark);
		
		semmco003Bean.setLegalPlaceTypeList(getLovItemsByType(ELovType.T_SI_LEGAL_PLACE_TYPE.name));
		semmco003Bean.setLegalPartiesTypeList(getLovItemsByType(ELovType.T_SI_LEGAL_PARTIES_TYPE.name));
		
		semmco003Bean.setBtnBorrowPopup(popup);
		ReturnContract returnCtx = null;
		BorrowContract borrowContract = null;
		IBorrowRequestService borService = (IBorrowRequestService)getBean("borrowRequestService");
		borrowContract = borService.queryBorrowContractByRowId(contractID);
		if (mode.equals("EDIT")) {
			semmco003Bean.setPageMode(false);
			returnCtx = getBorrowContractByContractId(contractID, returnID, mode);
			
			if(StringUtils.isEmpty(returnCtx.getDocContractDetail())){
				returnCtx.setDocContractDetail(borrowContract.getDocContractDetail());
			}
			
		} else if (mode.equals("VIEW")) {
			semmco003Bean.setPageMode(true);
			returnCtx = getBorrowContractByContractId(contractID, returnID, mode);
			
			if(StringUtils.isEmpty(returnCtx.getDocContractDetail())){
				returnCtx.setDocContractDetail(borrowContract.getDocContractDetail());
			}
		} else {
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			
			returnCtx = new ReturnContract();
			// returnCtx.setBorrowContractId();
			returnCtx.setRentType("01");
			returnCtx.setReturnDt(new Date());
			returnCtx.setReturnNotAllFlag("false");
			semmco003Bean.setReturnNotAllFlagBoolean(false);
			semmco003Bean.setMode("MULTIADD");
			
			
			String tmpContractId = "";
			List<WrapperBeanObject<Mco003SearchBorrowSP>> bgMaster = getSemmco003Bean().getBorrowSPList();
			for (WrapperBeanObject<Mco003SearchBorrowSP> wrapperBeanObject : bgMaster) {
				if(wrapperBeanObject.isCheckBox()){
					Mco003SearchBorrowSP tmp = (Mco003SearchBorrowSP)wrapperBeanObject.getDataObj();
					tmpContractId += (tmpContractId.equals(""))? tmp.getBorrowContractId(): "," + tmp.getBorrowContractId();
				}
			}
			
			semmco003Bean.setBorrowContractIdList(tmpContractId);
			Mco003ChkReturn mco003ChkReturn = new Mco003ChkReturn();
			mco003ChkReturn.setBorrowContractId(tmpContractId);
			try {
				List<Mco003ChkReturn> list = service.querySPList(EQueryName.SP_MCO003_CHK_RETURN.name, mco003ChkReturn);
				if (list != null && !list.isEmpty()) {
					if (null != list.get(0) && StringUtils.isNotEmpty(list.get(0).getContractNo())) {
						semmco003Bean.setPopupBorrowOpen(false);
						semmco003Bean.setPopupAlert(true);
						semmco003Bean.setContentAlert(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("Q0015"), list.get(0).getContractNo()));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
		boolean flg = false;
		if (returnCtx != null) {
			if (returnCtx.getReturnName() != null) {
				for (SelectItem o: semmco003Bean.getBorrowNameList()) {
					if (returnCtx.getReturnName().equals(o.getLabel())) {
						flg = true;
						break;
					}
				}
			}
		}
		if (flg) {
			semmco003Bean.setDisTxtReturnName(false);
		} else {
			semmco003Bean.setDisTxtReturnName(true);
			semmco003Bean.setOtherReturnName(returnCtx.getReturnName());
		}
		//Set Default Current Date In ReturnDt If ReTurnDt Is Null 
		if(returnCtx != null){
			returnCtx.setReturnDt((returnCtx.getReturnDt()!=null)?returnCtx.getReturnDt():new Date());
		}else{
			returnCtx = new ReturnContract();
			returnCtx.setReturnDt(new Date());
		}
		
		semmco003Bean.setReturnContract(returnCtx);
		semmco003Bean.setBorrowOfficerList(getLovItemsByType(ELovType.T_CO_BORROW_OFFICER.name));
		
		String temp = (semmco003Bean.getReturnContract().getRentType()!=null)?semmco003Bean.getReturnContract().getRentType():"";
		semmco003Bean.setTemp(temp);
		semmco003Bean.setPnlRentType(new HashMap());
		setSemmco003Bean(semmco003Bean);
		doClearValidateCheckbox(semmco003Bean);
		
		if(!returnID.equals(""))
			doShowRentType();
		
		//get legalDoc
		doGetLegalDoc();
		
		return flag;
	}
	
	@SuppressWarnings("unchecked")
	public void doShowRentType() {
		semmco003Bean = getSemmco003Bean();
		semmco003Bean.setDisableChk1(false);
		semmco003Bean.setDisableChk2(false);
		semmco003Bean.setDisableChk3(false);
		semmco003Bean.setDisableChk4(false);
		semmco003Bean.setDisableChk5(false);
		semmco003Bean.setDisableChk6(false);
		semmco003Bean.setDisableChk7(false);
		semmco003Bean.setDisableChk8(false);
		List lp = new ArrayList();
		List ls = new ArrayList();
		
		
		doValidateCheckBox();
		
		/*add CheckBox*/
		if(semmco003Bean.getTemp().equals("01")){
//			semmco003Bean.getPnlRentType().get("01")
			lp = (List) semmco003Bean.getPnlRentType().get("01");
				lp = new ArrayList();
				lp.add(semmco003Bean.getDoc1List().get(0));
				lp.add(semmco003Bean.getDoc2List().get(0));
				lp.add(semmco003Bean.getDoc3List().get(0));
				lp.add(semmco003Bean.getDoc4List().get(0));
				lp.add(semmco003Bean.getDoc5List().get(0));
				lp.add(semmco003Bean.getDoc6List().get(0));
				lp.add(semmco003Bean.getDoc7List().get(0));
				lp.add(semmco003Bean.getDoc8List().get(0));
				lp.add(semmco003Bean.getDoc9List().get(0));
				lp.add(semmco003Bean.getDoc10List().get(0));
				lp.add(semmco003Bean.getDocOtherList().get(0));
				String docOtherRemark = (StringUtils.isEmpty(semmco003Bean.getReturnContract().getDocOtherRemark()))? "":semmco003Bean.getReturnContract().getDocOtherRemark();
				lp.add(docOtherRemark);
				semmco003Bean.getPnlRentType().put("01", lp);
				doClearValidateCheckbox(semmco003Bean);
		}
		if(semmco003Bean.getTemp().equals("02")){
			lp = (List) semmco003Bean.getPnlRentType().get("02");
				lp = new ArrayList();
				lp.add(semmco003Bean.getDoc1List().get(0));
				lp.add(semmco003Bean.getDoc2List().get(0));
				lp.add(semmco003Bean.getDoc3List().get(0));
				lp.add(semmco003Bean.getDoc4List().get(0));
				lp.add(semmco003Bean.getDoc5List().get(0));
				lp.add(semmco003Bean.getDoc6List().get(0));
				lp.add(semmco003Bean.getDoc7List().get(0));
				lp.add(semmco003Bean.getDoc8List().get(0));
				lp.add(semmco003Bean.getDoc9List().get(0));
				lp.add(semmco003Bean.getDoc10List().get(0));
				lp.add(semmco003Bean.getDocOtherList().get(0));
				String docOtherRemark = (StringUtils.isEmpty(semmco003Bean.getReturnContract().getDocOtherRemark()))? "":semmco003Bean.getReturnContract().getDocOtherRemark();
				lp.add(docOtherRemark);
				semmco003Bean.getPnlRentType().put("02", lp);
				doClearValidateCheckbox(semmco003Bean);
		}
		if(semmco003Bean.getTemp().equals("03")){
			lp = (List) semmco003Bean.getPnlRentType().get("03");
				lp = new ArrayList();
				lp.add(semmco003Bean.getDoc1List().get(0));
				lp.add(semmco003Bean.getDoc2List().get(0));
				lp.add(semmco003Bean.getDoc3List().get(0));
				lp.add(semmco003Bean.getDoc4List().get(0));
				lp.add(semmco003Bean.getDoc5List().get(0));
				lp.add(semmco003Bean.getDoc6List().get(0));
				lp.add(semmco003Bean.getDoc7List().get(0));
				lp.add(semmco003Bean.getDoc8List().get(0));
				lp.add(semmco003Bean.getDoc9List().get(0));
				lp.add(semmco003Bean.getDoc10List().get(0));
				lp.add(semmco003Bean.getDocOtherList().get(0));
				String docOtherRemark = (StringUtils.isEmpty(semmco003Bean.getReturnContract().getDocOtherRemark()))? "":semmco003Bean.getReturnContract().getDocOtherRemark();
				lp.add(docOtherRemark);
				semmco003Bean.getPnlRentType().put("03", lp);
				doClearValidateCheckbox(semmco003Bean);
		}
		if(semmco003Bean.getTemp().equals("04")){
			lp = (List) semmco003Bean.getPnlRentType().get("04");
				lp = new ArrayList();
				lp.add(semmco003Bean.getDoc1List().get(0));
				lp.add(semmco003Bean.getDoc2List().get(0));
				lp.add(semmco003Bean.getDoc3List().get(0));
				lp.add(semmco003Bean.getDoc4List().get(0));
				lp.add(semmco003Bean.getDoc5List().get(0));
				lp.add(semmco003Bean.getDoc6List().get(0));
				lp.add(semmco003Bean.getDoc7List().get(0));
				lp.add(semmco003Bean.getDoc8List().get(0));
				lp.add(semmco003Bean.getDoc9List().get(0));
				lp.add(semmco003Bean.getDoc10List().get(0));
				lp.add(semmco003Bean.getDocOtherList().get(0));
				String docOtherRemark = (StringUtils.isEmpty(semmco003Bean.getReturnContract().getDocOtherRemark()))? "":semmco003Bean.getReturnContract().getDocOtherRemark();
				lp.add(docOtherRemark);
				semmco003Bean.getPnlRentType().put("04", lp);
				doClearValidateCheckbox(semmco003Bean);
		}
		if(semmco003Bean.getTemp().equals("05")){
			lp = (List) semmco003Bean.getPnlRentType().get("05");
				lp = new ArrayList();
				lp.add(semmco003Bean.getDoc1List().get(0));
				lp.add(semmco003Bean.getDoc2List().get(0));
				lp.add(semmco003Bean.getDoc3List().get(0));
				lp.add(semmco003Bean.getDoc4List().get(0));
				lp.add(semmco003Bean.getDoc5List().get(0));
				lp.add(semmco003Bean.getDoc6List().get(0));
				lp.add(semmco003Bean.getDoc7List().get(0));
				lp.add(semmco003Bean.getDoc8List().get(0));
				lp.add(semmco003Bean.getDoc9List().get(0));
				lp.add(semmco003Bean.getDoc10List().get(0));
				lp.add(semmco003Bean.getDocOtherList().get(0));
				String docOtherRemark = (StringUtils.isEmpty(semmco003Bean.getReturnContract().getDocOtherRemark()))? "":semmco003Bean.getReturnContract().getDocOtherRemark();
				lp.add(docOtherRemark);
				semmco003Bean.getPnlRentType().put("05", lp);
				doClearValidateCheckbox(semmco003Bean);
		}
		if(semmco003Bean.getTemp().equals("06")){
			lp = (List) semmco003Bean.getPnlRentType().get("06");
				lp = new ArrayList();
				lp.add(semmco003Bean.getDoc1List().get(0));
				lp.add(semmco003Bean.getDoc2List().get(0));
				lp.add(semmco003Bean.getDoc3List().get(0));
				lp.add(semmco003Bean.getDoc4List().get(0));
				lp.add(semmco003Bean.getDoc5List().get(0));
				lp.add(semmco003Bean.getDoc6List().get(0));
				lp.add(semmco003Bean.getDoc7List().get(0));
				lp.add(semmco003Bean.getDoc8List().get(0));
				lp.add(semmco003Bean.getDoc9List().get(0));
				lp.add(semmco003Bean.getDoc10List().get(0));
				lp.add(semmco003Bean.getDocOtherList().get(0));
				String docOtherRemark = (StringUtils.isEmpty(semmco003Bean.getReturnContract().getDocOtherRemark()))? "":semmco003Bean.getReturnContract().getDocOtherRemark();
				lp.add(docOtherRemark);
				semmco003Bean.getPnlRentType().put("06", lp);
				doClearValidateCheckbox(semmco003Bean);
		}
		if(semmco003Bean.getTemp().equals("07")){
			lp = (List) semmco003Bean.getPnlRentType().get("07");
				lp = new ArrayList();
				lp.add(semmco003Bean.getDoc1List().get(0));
				lp.add(semmco003Bean.getDoc2List().get(0));
				lp.add(semmco003Bean.getDoc3List().get(0));
				lp.add(semmco003Bean.getDoc4List().get(0));
				lp.add(semmco003Bean.getDoc5List().get(0));
				lp.add(semmco003Bean.getDoc6List().get(0));
				lp.add(semmco003Bean.getDoc7List().get(0));
				lp.add(semmco003Bean.getDoc8List().get(0));
				lp.add(semmco003Bean.getDoc9List().get(0));
				lp.add(semmco003Bean.getDoc10List().get(0));
				lp.add(semmco003Bean.getDocOtherList().get(0));
				String docOtherRemark = (StringUtils.isEmpty(semmco003Bean.getReturnContract().getDocOtherRemark()))? "":semmco003Bean.getReturnContract().getDocOtherRemark();
				lp.add(docOtherRemark);
				semmco003Bean.getPnlRentType().put("07", lp);
				doClearValidateCheckbox(semmco003Bean);
		}
		if(semmco003Bean.getTemp().equals("99")){
			lp = (List) semmco003Bean.getPnlRentType().get("99");
				lp = new ArrayList();
				lp.add(semmco003Bean.getDoc1List().get(0));
				lp.add(semmco003Bean.getDoc2List().get(0));
				lp.add(semmco003Bean.getDoc3List().get(0));
				lp.add(semmco003Bean.getDoc4List().get(0));
				lp.add(semmco003Bean.getDoc5List().get(0));
				lp.add(semmco003Bean.getDoc6List().get(0));
				lp.add(semmco003Bean.getDoc7List().get(0));
				lp.add(semmco003Bean.getDoc8List().get(0));
				lp.add(semmco003Bean.getDoc9List().get(0));
				lp.add(semmco003Bean.getDoc10List().get(0));
				lp.add(semmco003Bean.getDocOtherList().get(0));
				String docOtherRemark = (StringUtils.isEmpty(semmco003Bean.getReturnContract().getDocOtherRemark()))? "":semmco003Bean.getReturnContract().getDocOtherRemark();
				lp.add(docOtherRemark);
				semmco003Bean.getPnlRentType().put("99", lp);
				doClearValidateCheckbox(semmco003Bean);
		}
		
		// semmco003Bean.getReturnContract().setDocOtherRemark("");
		
		/*Show Checkbox to Panel*/		
		String rentType = semmco003Bean.getReturnContract().getRentType();
		if (rentType != null) {
			if(rentType.equals("01") && !rentType.isEmpty()){
				semmco003Bean.setDisableChk1(true);
				ls = (List) semmco003Bean.getPnlRentType().get("01");
				if((ls!=null) && (ls.size()>0)){
					semmco003Bean.getDoc1List().add(ls.get(0));
					semmco003Bean.getDoc2List().add(ls.get(1));
					semmco003Bean.getDoc3List().add(ls.get(2));
					semmco003Bean.getDoc4List().add(ls.get(3));
					semmco003Bean.getDoc5List().add(ls.get(4));
					semmco003Bean.getDoc6List().add(ls.get(5));
					semmco003Bean.getDoc7List().add(ls.get(6));
					semmco003Bean.getDoc8List().add(ls.get(7));
					semmco003Bean.getDoc9List().add(ls.get(8));
					semmco003Bean.getDoc10List().add(ls.get(9));
					semmco003Bean.getDocOtherList().add(ls.get(10));
					semmco003Bean.getReturnContract().setDocOtherRemark((String)ls.get(11));
					semmco003Bean.setTemp("01");
				}else{
					doClearValidateCheckbox(semmco003Bean);
				}			
			}		
			
			if(rentType.equals("02") && !rentType.isEmpty()){
				semmco003Bean.setDisableChk2(true);
				ls = (List) semmco003Bean.getPnlRentType().get("02");
				if((ls!=null) && ls.size()>0){
					semmco003Bean.getDoc1List().add(ls.get(0));
					semmco003Bean.getDoc2List().add(ls.get(1));
					semmco003Bean.getDoc3List().add(ls.get(2));
					semmco003Bean.getDoc4List().add(ls.get(3));
					semmco003Bean.getDoc5List().add(ls.get(4));
					semmco003Bean.getDoc6List().add(ls.get(5));
					semmco003Bean.getDoc7List().add(ls.get(6));
					semmco003Bean.getDoc8List().add(ls.get(7));
					semmco003Bean.getDoc9List().add(ls.get(8));
					semmco003Bean.getDoc10List().add(ls.get(9));
					semmco003Bean.getDocOtherList().add(ls.get(10));
					semmco003Bean.getReturnContract().setDocOtherRemark((String)ls.get(11));
					semmco003Bean.setTemp("02");
				}else{
					doClearValidateCheckbox(semmco003Bean);
				}			
			}
			if(rentType.equals("03") && !rentType.isEmpty()){
				semmco003Bean.setDisableChk3(true);
				ls = (List) semmco003Bean.getPnlRentType().get("03");
				if((ls!=null) && ls.size()>0){
					semmco003Bean.getDoc1List().add(ls.get(0));
					semmco003Bean.getDoc2List().add(ls.get(1));
					semmco003Bean.getDoc3List().add(ls.get(2));
					semmco003Bean.getDoc4List().add(ls.get(3));
					semmco003Bean.getDoc5List().add(ls.get(4));
					semmco003Bean.getDoc6List().add(ls.get(5));
					semmco003Bean.getDoc7List().add(ls.get(6));
					semmco003Bean.getDoc8List().add(ls.get(7));
					semmco003Bean.getDoc9List().add(ls.get(8));
					semmco003Bean.getDoc10List().add(ls.get(9));
					semmco003Bean.getDocOtherList().add(ls.get(10));
					semmco003Bean.getReturnContract().setDocOtherRemark((String)ls.get(11));
					semmco003Bean.setTemp("03");
				}else{
					doClearValidateCheckbox(semmco003Bean);
				}			
			}
			if(rentType.equals("04") && !rentType.isEmpty()){
				semmco003Bean.setDisableChk4(true);
				ls = (List) semmco003Bean.getPnlRentType().get("04");
				if((ls!=null) && ls.size()>0){
					semmco003Bean.getDoc1List().add(ls.get(0));
					semmco003Bean.getDoc2List().add(ls.get(1));
					semmco003Bean.getDoc3List().add(ls.get(2));
					semmco003Bean.getDoc4List().add(ls.get(3));
					semmco003Bean.getDoc5List().add(ls.get(4));
					semmco003Bean.getDoc6List().add(ls.get(5));
					semmco003Bean.getDoc7List().add(ls.get(6));
					semmco003Bean.getDoc8List().add(ls.get(7));
					semmco003Bean.getDoc9List().add(ls.get(8));
					semmco003Bean.getDoc10List().add(ls.get(9));
					semmco003Bean.getDocOtherList().add(ls.get(10));
					semmco003Bean.getReturnContract().setDocOtherRemark((String)ls.get(11));
					semmco003Bean.setTemp("04");
				}else{
					doClearValidateCheckbox(semmco003Bean);
				}			
			}
			if(rentType.equals("05") && !rentType.isEmpty()){
				semmco003Bean.setDisableChk5(true);
				ls = (List) semmco003Bean.getPnlRentType().get("05");
				if((ls!=null) && ls.size()>0){
					semmco003Bean.getDoc1List().add(ls.get(0));
					semmco003Bean.getDoc2List().add(ls.get(1));
					semmco003Bean.getDoc3List().add(ls.get(2));
					semmco003Bean.getDoc4List().add(ls.get(3));
					semmco003Bean.getDoc5List().add(ls.get(4));
					semmco003Bean.getDoc6List().add(ls.get(5));
					semmco003Bean.getDoc7List().add(ls.get(6));
					semmco003Bean.getDoc8List().add(ls.get(7));
					semmco003Bean.getDoc9List().add(ls.get(8));
					semmco003Bean.getDoc10List().add(ls.get(9));
					semmco003Bean.getDocOtherList().add(ls.get(10));
					semmco003Bean.getReturnContract().setDocOtherRemark((String)ls.get(11));
					semmco003Bean.setTemp("05");
				}else{
					doClearValidateCheckbox(semmco003Bean);
				}			
			}
			if(rentType.equals("06") && !rentType.isEmpty()){
				semmco003Bean.setDisableChk6(true);
				ls = (List) semmco003Bean.getPnlRentType().get("06");
				if((ls!=null) && ls.size()>0){
					semmco003Bean.getDoc1List().add(ls.get(0));
					semmco003Bean.getDoc2List().add(ls.get(1));
					semmco003Bean.getDoc3List().add(ls.get(2));
					semmco003Bean.getDoc4List().add(ls.get(3));
					semmco003Bean.getDoc5List().add(ls.get(4));
					semmco003Bean.getDoc6List().add(ls.get(5));
					semmco003Bean.getDoc7List().add(ls.get(6));
					semmco003Bean.getDoc8List().add(ls.get(7));
					semmco003Bean.getDoc9List().add(ls.get(8));
					semmco003Bean.getDoc10List().add(ls.get(9));
					semmco003Bean.getDocOtherList().add(ls.get(10));
					semmco003Bean.getReturnContract().setDocOtherRemark((String)ls.get(11));
					semmco003Bean.setTemp("06");
				}else{
					doClearValidateCheckbox(semmco003Bean);
				}			
			}
			if(rentType.equals("07") && !rentType.isEmpty()){
				semmco003Bean.setDisableChk8(true);
				ls = (List) semmco003Bean.getPnlRentType().get("07");
				if((ls!=null) && ls.size()>0){
					semmco003Bean.getDoc1List().add(ls.get(0));
					semmco003Bean.getDoc2List().add(ls.get(1));
					semmco003Bean.getDoc3List().add(ls.get(2));
					semmco003Bean.getDoc4List().add(ls.get(3));
					semmco003Bean.getDoc5List().add(ls.get(4));
					semmco003Bean.getDoc6List().add(ls.get(5));
					semmco003Bean.getDoc7List().add(ls.get(6));
					semmco003Bean.getDoc8List().add(ls.get(7));
					semmco003Bean.getDoc9List().add(ls.get(8));
					semmco003Bean.getDoc10List().add(ls.get(9));
					semmco003Bean.getDocOtherList().add(ls.get(10));
					semmco003Bean.getReturnContract().setDocOtherRemark((String)ls.get(11));
					semmco003Bean.setTemp("07");
				}else{
					doClearValidateCheckbox(semmco003Bean);
				}			
			}
			
			if(rentType.equals("99") && !rentType.isEmpty()){
				semmco003Bean.setDisableChk7(true);
				ls = (List) semmco003Bean.getPnlRentType().get("99");
				if((ls!=null) && ls.size()>0){
					semmco003Bean.getDoc1List().add(ls.get(0));
					semmco003Bean.getDoc2List().add(ls.get(1));
					semmco003Bean.getDoc3List().add(ls.get(2));
					semmco003Bean.getDoc4List().add(ls.get(3));
					semmco003Bean.getDoc5List().add(ls.get(4));
					semmco003Bean.getDoc6List().add(ls.get(5));
					semmco003Bean.getDoc7List().add(ls.get(6));
					semmco003Bean.getDoc8List().add(ls.get(7));
					semmco003Bean.getDoc9List().add(ls.get(8));
					semmco003Bean.getDoc10List().add(ls.get(9));
					semmco003Bean.getDocOtherList().add(ls.get(10));
					semmco003Bean.getReturnContract().setDocOtherRemark((String)ls.get(11));
					semmco003Bean.setTemp("99");
				}else{
					doClearValidateCheckbox(semmco003Bean);
				}
			}
		}
		setSemmco003Bean(semmco003Bean);
	}
	
	@SuppressWarnings("unchecked")
	public void doClearValidateCheckbox(SEMMCO003Bean semmco003Bean){
		semmco003Bean.setDoc1List(new ArrayList());
		semmco003Bean.setDoc2List(new ArrayList());
		semmco003Bean.setDoc3List(new ArrayList());
		semmco003Bean.setDoc4List(new ArrayList());
		semmco003Bean.setDoc5List(new ArrayList());
		semmco003Bean.setDoc6List(new ArrayList());
		semmco003Bean.setDoc7List(new ArrayList());
		semmco003Bean.setDoc8List(new ArrayList());
		semmco003Bean.setDoc9List(new ArrayList());
		semmco003Bean.setDoc10List(new ArrayList());
		semmco003Bean.setDocOtherList(new ArrayList());
	}
	
	@SuppressWarnings("unchecked")
	public void doValidateCheckBox() {
		// semmco003Bean = getSemmco003Bean();
		if(semmco003Bean.getDoc1List() == null || semmco003Bean.getDoc1List().size()==0){
			String doc1 = (semmco003Bean.getReturnContract().getDoc1()!=null&&semmco003Bean.getReturnContract().getDoc1().equals("Y"))? "Y": "FALSE";
			semmco003Bean.getDoc1List().add(doc1);
		}
		
		if(semmco003Bean.getDoc2List() == null || semmco003Bean.getDoc2List().size()==0){
			String doc2 = (semmco003Bean.getReturnContract().getDoc2()!=null&&semmco003Bean.getReturnContract().getDoc2().equals("Y"))? "Y": "N";
			semmco003Bean.getDoc2List().add(doc2);
		}
		
		if(semmco003Bean.getDoc3List() == null || semmco003Bean.getDoc3List().size()==0){
			String doc3 = (semmco003Bean.getReturnContract().getDoc3()!=null&&semmco003Bean.getReturnContract().getDoc3().equals("Y"))? "Y": "N";
			semmco003Bean.getDoc3List().add(doc3);
		}
		
		if(semmco003Bean.getDoc4List() == null || semmco003Bean.getDoc4List().size()==0){
			String doc4 = (semmco003Bean.getReturnContract().getDoc4()!=null&&semmco003Bean.getReturnContract().getDoc4().equals("Y"))? "Y": "N";
			semmco003Bean.getDoc4List().add(doc4);
		}
		
		if(semmco003Bean.getDoc5List() == null || semmco003Bean.getDoc5List().size()==0){
			String doc5 = (semmco003Bean.getReturnContract().getDoc5()!=null&&semmco003Bean.getReturnContract().getDoc5().equals("Y"))? "Y": "N";
			semmco003Bean.getDoc5List().add(doc5);
		}
		
		if(semmco003Bean.getDoc6List() == null || semmco003Bean.getDoc6List().size()==0){
			String doc6 = (semmco003Bean.getReturnContract().getDoc6()!=null&&semmco003Bean.getReturnContract().getDoc6().equals("Y"))? "Y": "N";
			semmco003Bean.getDoc6List().add(doc6);
		}
		if(semmco003Bean.getDoc7List() == null || semmco003Bean.getDoc7List().size()==0){
			String doc7 = (semmco003Bean.getReturnContract().getDoc7()!=null&&semmco003Bean.getReturnContract().getDoc7().equals("Y"))? "Y": "N";
			semmco003Bean.getDoc7List().add(doc7);
		}
		if(semmco003Bean.getDoc8List() == null || semmco003Bean.getDoc8List().size()==0){
			String doc8 = (semmco003Bean.getReturnContract().getDoc8()!=null&&semmco003Bean.getReturnContract().getDoc8().equals("Y"))? "Y": "N";
			semmco003Bean.getDoc8List().add(doc8);
		}
		if(semmco003Bean.getDoc9List() == null || semmco003Bean.getDoc9List().size()==0){
			String doc9 = (semmco003Bean.getReturnContract().getDoc9()!=null&&semmco003Bean.getReturnContract().getDoc9().equals("Y"))? "Y": "N";
			semmco003Bean.getDoc9List().add(doc9);
		}
		if(semmco003Bean.getDoc10List() == null || semmco003Bean.getDoc10List().size()==0){
			String doc10 = (semmco003Bean.getReturnContract().getDoc10()!=null&&semmco003Bean.getReturnContract().getDoc10().equals("Y"))? "Y": "N";
			semmco003Bean.getDoc10List().add(doc10);
		}
		if(semmco003Bean.getDocOtherList() == null || semmco003Bean.getDocOtherList().size()==0){
			String docOther = (semmco003Bean.getReturnContract().getDocOther()!=null&&semmco003Bean.getReturnContract().getDocOther().equals("Y"))? "Y": "N";
			semmco003Bean.getDocOtherList().add(docOther);
		}
		// setSemmco003Bean(semmco003Bean);
	}
	
	@SuppressWarnings("unchecked")
	private boolean doSaveContractReturn(){
		boolean flag = false;
		semmco003Bean = getSemmco003Bean();
		String borrowContractId = "";
		IBorrowRequestService borService = (IBorrowRequestService)getBean("borrowRequestService");
		if(!validateContractReturn()){
			semmco003Bean.setPopupClose(false);
			semmco003Bean.setRenderedMsgFormTop(false);
			setSemmco003Bean(semmco003Bean);
			return flag;
		}
		try{
			ReturnContract contract = semmco003Bean.getReturnContract();
			
			contract.setReturnNotAllFlag((contract.getReturnNotAllFlag() != null && contract.getReturnNotAllFlag().equals("true"))?"Y":"");
			contract.setDocApproveFlag((contract.getDocApproveFlag() != null && contract.getDocApproveFlag().equals("true"))?"Y":"");
			contract.setDocContractFlag((contract.getDocContractFlag() != null && contract.getDocContractFlag().equals("true"))?"Y":"");
			contract.setDocOtherFlag((contract.getDocOtherFlag() != null && contract.getDocOtherFlag().equals("true"))?"Y":"");
			contract.setDocOtherAddFlag((contract.getDocOtherAddFlag() != null && contract.getDocOtherAddFlag().equals("true"))?"Y":"");
			// P'O do it.
//			contract.setDoc1(StringUtils.isNotEmpty(contract.getDoc1())?"Y":"");
//			contract.setDoc2(StringUtils.isNotEmpty(contract.getDoc2())?"Y":"");
//			contract.setDoc3(StringUtils.isNotEmpty(contract.getDoc3())?"Y":"");
//			contract.setDoc4(StringUtils.isNotEmpty(contract.getDoc4())?"Y":"");
//			contract.setDoc5(StringUtils.isNotEmpty(contract.getDoc5())?"Y":"");
//			contract.setDoc6(StringUtils.isNotEmpty(contract.getDoc6())?"Y":"");
//			contract.setDoc7(StringUtils.isNotEmpty(contract.getDoc7())?"Y":"");
//			contract.setDocOther(StringUtils.isNotEmpty(contract.getDocOther())?"Y":"");
			
			if (contract.getDocOtherAddFlag().equals("Y")) {
				contract.setDoc1((semmco003Bean.getDoc1List() != null && semmco003Bean.getDoc1List().size() > 0)?"Y":"");
				contract.setDoc2((semmco003Bean.getDoc2List() != null && semmco003Bean.getDoc2List().size() > 0)?"Y":"");
				contract.setDoc3((semmco003Bean.getDoc3List() != null && semmco003Bean.getDoc3List().size() > 0)?"Y":"");
				contract.setDoc4((semmco003Bean.getDoc4List() != null && semmco003Bean.getDoc4List().size() > 0)?"Y":"");
				contract.setDoc5((semmco003Bean.getDoc5List() != null && semmco003Bean.getDoc5List().size() > 0)?"Y":"");
				contract.setDoc6((semmco003Bean.getDoc6List() != null && semmco003Bean.getDoc6List().size() > 0)?"Y":"");
				contract.setDoc7((semmco003Bean.getDoc7List() != null && semmco003Bean.getDoc7List().size() > 0)?"Y":"");
				contract.setDoc8((semmco003Bean.getDoc8List() != null && semmco003Bean.getDoc8List().size() > 0)?"Y":"");
				contract.setDoc9((semmco003Bean.getDoc9List() != null && semmco003Bean.getDoc9List().size() > 0)?"Y":"");
				contract.setDoc10((semmco003Bean.getDoc10List() != null && semmco003Bean.getDoc10List().size() > 0)?"Y":"");
				contract.setDocOther((semmco003Bean.getDocOtherList() != null && semmco003Bean.getDocOtherList().size() > 0)?"Y":"");
			}
			
			if (StringUtils.isEmpty(contract.getReturnName())) {
				contract.setReturnName(semmco003Bean.getOtherReturnName());
			}
			
			if(semmco003Bean.getMode().equals("ADD")){
				contract.setRecordStatus("Y");
				borrowContractId = contract.getBorrowContractId();
//				returnID
//				borService.saveReturnContract(contract);
			} else if(semmco003Bean.getMode().equals("EDIT")){
				contract.setRecordStatus("Y");
				borrowContractId = contract.getBorrowContractId();
//				borService.updateReturnContract(contract);
			} else if(semmco003Bean.getMode().equals("MULTIADD")) {
				borrowContractId = semmco003Bean.getBorrowContractIdList();
			}
				IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
				
				Mco003SaveReturn mco003SaveReturn = new Mco003SaveReturn();
				mco003SaveReturn.setBorrowContractId(borrowContractId);
				mco003SaveReturn.setReturnName(contract.getReturnName());
				mco003SaveReturn.setReturnDt(contract.getReturnDt());
				mco003SaveReturn.setReturnOfficer(contract.getReturnOfficer());
				mco003SaveReturn.setReturnNotAllFlag(contract.getReturnNotAllFlag());
				mco003SaveReturn.setReturnNotAllDt(contract.getReturnNotAllDt());
				mco003SaveReturn.setDocApproveFlag(contract.getDocApproveFlag());
				mco003SaveReturn.setDocContractFlag(contract.getDocContractFlag());
				mco003SaveReturn.setDocContractDetail(contract.getDocContractDetail());
				mco003SaveReturn.setDocOtherFlag(contract.getDocOtherFlag());
				mco003SaveReturn.setRemarkDocOther(contract.getRemarkDocOther());
				mco003SaveReturn.setDocOtherAddFlag(contract.getDocOtherAddFlag());
				mco003SaveReturn.setRentType(contract.getRentType());
				mco003SaveReturn.setRentTypeOtherRemark(contract.getRentTypeOtherRemark());
				mco003SaveReturn.setDoc1(contract.getDoc1());
				mco003SaveReturn.setDoc2(contract.getDoc2());
				mco003SaveReturn.setDoc3(contract.getDoc3());
				mco003SaveReturn.setDoc4(contract.getDoc4());
				mco003SaveReturn.setDoc5(contract.getDoc5());
				mco003SaveReturn.setDoc6(contract.getDoc6());
				mco003SaveReturn.setDoc7(contract.getDoc7());
				mco003SaveReturn.setDoc8(contract.getDoc8());
				mco003SaveReturn.setDoc9(contract.getDoc9());
				mco003SaveReturn.setDoc10(contract.getDoc10());
				mco003SaveReturn.setDocOther(contract.getDocOther());
				mco003SaveReturn.setDocOtherRemark(contract.getDocOtherRemark());
				mco003SaveReturn.setCurrentUser(getUserLogIn());
				mco003SaveReturn.setDocRemark(contract.getDocRemark());
				
				List<Mco003SaveReturn> resultList = service.querySPList(EQueryName.SP_MCO003_SAVE_RETURN.name, mco003SaveReturn);
				if (resultList == null || resultList.isEmpty()) {
					semmco003Bean.setPopupClose(false);
					addMessageError("E0001");
				}
//			}
			
			semmco003Bean.setPopupClose(true);
			addMessageInfo("M0001");
		}catch(Exception e){
			e.printStackTrace();
			semmco003Bean.setPopupClose(false);
			addMessageError("E0001");
		}
		
		
		setSemmco003Bean(semmco003Bean);
		
		flag = doSearchContract();
		return flag;
	}
	
	private boolean validateContractReturn() {
		boolean flgValid = true;
		if(StringUtils.isEmpty(getSemmco003Bean().getReturnContract().getReturnName())){
			if (StringUtils.isEmpty(getSemmco003Bean().getOtherReturnName())) {
				addMessageError("W0001", msg("message.returnName"));
				flgValid = false;
			}
		}
		
		if(getSemmco003Bean().getReturnContract().getReturnDt()==null){
			addMessageError("W0001", msg("message.returnDt"));
			flgValid = false;
		}
		
		if(StringUtils.isEmpty(getSemmco003Bean().getReturnContract().getReturnOfficer())){
			addMessageError("W0001", msg("message.returnOfficer"));
			flgValid = false;
		}
		return flgValid;
	}
	
	private boolean initDeleteRequest() {
		boolean flag = true;
		semmco003Bean = getSemmco003Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		semmco003Bean.setBorrowRequestIdDel(rowId);
		setSemmco003Bean(semmco003Bean);
		return flag;
	}
	
	private boolean initDeleteContract() {
		boolean flag = true;
		semmco003Bean = getSemmco003Bean();
		String fromPopup = (String) getFacesUtils().getRequestParameter("fromPopup");
		semmco003Bean.setFromPopup(fromPopup);
		String contractID = (String)getFacesUtils().getRequestParameter("contractID");
		String returnID = (String)getFacesUtils().getRequestParameter("returnID");
		semmco003Bean.setBorrowContractIdDel(contractID);
		semmco003Bean.setReturnContractIdDel(returnID);
		semmco003Bean.setRenderedMsgFormTop(true);
		setSemmco003Bean(semmco003Bean);
		return flag;
	}
	
	@SuppressWarnings("unchecked")
	private boolean deleteRequest(){
		boolean flag = true;
		semmco003Bean = getSemmco003Bean();
		// String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		// IBorrowRequestService borService = (IBorrowRequestService)getBean("borrowRequestService");
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		try{
//			BorrowRequest borrow = borService.queryBorrowRequestByRowId(semmco003Bean.getBorrowRequestIdDel());
//			borService.deleteRequest(borrow);
			Mco003Del mco003Del = new Mco003Del();
			mco003Del.setBorrowReqId(semmco003Bean.getBorrowRequestIdDel());
			mco003Del.setCurrentUser(getUserLogIn());
			List list = service.querySPList(EQueryName.SP_MCO003_DEL.name, mco003Del);
			if (list != null && !list.isEmpty()) {
				Mco003Del result = (Mco003Del)list.get(0);
				if (result.getResult().equals("Success")) {
					addMessageInfo("M0002");
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			semmco003Bean.setPopupClose(false);
			addMessageError("E0001");
		}
		// 20101210
		// flag = doSearchContract();
		doSearch();
		setSemmco003Bean(semmco003Bean);
		return flag;
	}
	
	@SuppressWarnings("unchecked")
	private boolean deleteContract(){
		log.debug("deleteContract");
		boolean flag = false;
		semmco003Bean = getSemmco003Bean();
		// IBorrowRequestService borService = (IBorrowRequestService)getBean("borrowRequestService");
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		try{
//			if(!semmco003Bean.getBorrowContractIdDel().equals("")){
//				BorrowContract borrow = borService.queryBorrowContractByRowId(semmco003Bean.getBorrowContractIdDel());
//				borService.deleteBorrow(borrow);
//			}
//			if(!semmco003Bean.getReturnContractIdDel().equals("")){
//				ReturnContract borrow = borService.queryReturnContractByRowId(semmco003Bean.getReturnContractIdDel());
//				borService.deleteReturn(borrow);
//			}
			Mco003DelBorrow mco003DelBorrow = new Mco003DelBorrow();
			mco003DelBorrow.setBorrowContractId(semmco003Bean.getBorrowContractIdDel());
			mco003DelBorrow.setCurrentUser(getUserLogIn());
			List list = service.querySPList(EQueryName.SP_MCO003_DEL_BORROW.name, mco003DelBorrow);
			if (list != null && !list.isEmpty()) {
				Mco003DelBorrow result = (Mco003DelBorrow)list.get(0);
				if (result.getResult().equals("Success")) {
					addMessageInfo("M0002");
				}
			}
			Mco003SearchBorrowSP criteriaSrch = new Mco003SearchBorrowSP();
			criteriaSrch.setCompany(semmco003Bean.getTmpCompany());
			criteriaSrch.setBorrowRequestId(semmco003Bean.getInsertBorrowID());
			criteriaSrch.setStatus("02");
			List<Mco003SearchBorrowSP> toSrch = searchBorrowContract(criteriaSrch);
			String contractNo = "";
			if (toSrch != null && toSrch.size() > 0) {
				for (Mco003SearchBorrowSP mco003SearchBorrowSP : toSrch){
					if (StringUtils.isEmpty(contractNo)){
						contractNo = mco003SearchBorrowSP.getContractNo();
					}else{
						contractNo = contractNo+","+mco003SearchBorrowSP.getContractNo();
					}
				}
				semmco003Bean.setContractAdd(contractNo);
				semmco003Bean.setCacheContractAdd(contractNo);
				semmco003Bean.setBorrowSPList(packBorrowContractList(toSrch));
			} else {
				semmco003Bean.setBorrowSPList(null);
			}
			semmco003Bean.setAddContractNo(semmco003Bean.getTmpRowId());
//			this.doSearchBeforAddContract();
//			String contractNo = semmco003Bean.getViewContractNo();
//			SEMMCO003Bean criteria = semmco003Bean;
//			criteria.getCriteriaBorrow().setContractNo(contractNo);
			semmco003Bean.setBorrowSPList(this.searchContract(semmco003Bean));
			setSemmco003Bean(semmco003Bean);
//			doSearchContract();
		}catch(Exception e){
			e.printStackTrace();
			semmco003Bean.setPopupClose(false);
			addMessageError("E0001");
		}
		
		setSemmco003Bean(semmco003Bean);
		
		// flag = doSearchContract();
		return flag;
	}
	
	private boolean doClear(){
		boolean flag = false;
		semmco003Bean = getSemmco003Bean();
		semmco003Bean.setCriteria(new Mco003SrchBorrowRequestSP());
		// semmco003Bean.getBorrowRequestSPList().clear();
		semmco003Bean.setBorrowRequestSPList(null);
		// 20130105
		// semmco003Bean.setCriteriaBorrow(new Mco003SearchBorrowSP());
		// semmco003Bean.getBorrowSPList().clear();
		setSemmco003Bean(semmco003Bean);
		return flag;
	}
	
	private boolean doClearBorrow() {
		boolean flag = false;
		semmco003Bean = getSemmco003Bean();
		String company = semmco003Bean.getCriteriaBorrow().getCompany();
		semmco003Bean.setCriteriaBorrow(new Mco003SearchBorrowSP());
		semmco003Bean.getCriteriaBorrow().setCompany(company);
		// semmco003Bean.getBorrowSPList().clear();
		semmco003Bean.setBorrowSPList(null);
		semmco003Bean.setCacheContractAdd("");
		semmco003Bean.setCacheContractSrch("");
		semmco003Bean.setViewContractNo("");
		semmco003Bean.setAddPreContractNo("");
		semmco003Bean.setAddContractNo("");
		semmco003Bean.setRenderedMsgDataNotFound(false);
		setSemmco003Bean(semmco003Bean);
		return flag;
	}
	
	private boolean doUpdateBorrowContract(){
		boolean flag = false;
		semmco003Bean = getSemmco003Bean();
		IBorrowRequestService borService = (IBorrowRequestService)getBean("borrowRequestService");
		// semmco003Bean.setRenderedMsgFormSearch(true);
		if(!validateUpdateContractStatus()){
			semmco003Bean.setPopupClose(false);
			semmco003Bean.setRenderedMsgFormSearch(false);
			setSemmco003Bean(semmco003Bean);
			return flag;
		}
		
		try{
			BorrowRequest borrow = semmco003Bean.getBorrowRequest();
			// borrow.setCompany(semmco003Bean.getCriteria().getCompany());
			borrow.setRecordStatus("Y");
			borrow.setCurrentUser(getUserLogIn());
			semmco003Bean.setPopupClose(true);
			borService.updateBorrowContract(borrow);
		}catch(Exception e){
			e.printStackTrace();
			semmco003Bean.setPopupClose(false);
			addMessageError("E0001");
		}
		semmco003Bean.setMode("");

//		if(!StringUtils.isEmpty(getSemmco003Bean().getCriteria().getCompany())){ 
			doSearch();
//		}
		addMessageInfo("M0001");
		setSemmco003Bean(semmco003Bean);
		getSemmco003Bean().setRenderedMsgFormSearch(true);
		return flag;
	}
	
	public void selectAllRow(){
		try{
			boolean chkAll = getSemmco003Bean().isChkSelAll();
			List<WrapperBeanObject<Mco003SearchBorrowSP>> detailList = new ArrayList<WrapperBeanObject<Mco003SearchBorrowSP>>();
			detailList = getSemmco003Bean().getBorrowSPList();
			for(int i=0; i<detailList.size(); i++){
				detailList.get(i).setCheckBox(chkAll);
			}
			
			onRenderExportButton();
		}catch(NullPointerException ne){
			
		}catch(Exception e){
			
		}
	}
	
	public void onRenderExportButton(){
		// String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		// getSemmco003Bean().setTmpRowId(rowId);
		getSemmco003Bean().setDisBtnBorrow(false);
		if(isCheckSELBox()) {
			getSemmco003Bean().setDisabledBtnExport(false);
		} else {
			getSemmco003Bean().setDisBtnBorrow(true);
			getSemmco003Bean().setDisabledBtnExport(true);
			getSemmco003Bean().setChkSelAll(false);
		}
	}
	
	private boolean isCheckSELBox(){
		boolean isCheck = false;
		List<WrapperBeanObject<Mco003SearchBorrowSP>> bgMaster = getSemmco003Bean().getBorrowSPList();
		int i = 0;
		for (WrapperBeanObject<Mco003SearchBorrowSP> wrapperBeanObject : bgMaster) {
			if(wrapperBeanObject.isCheckBox()){
				isCheck = true;
				Mco003SearchBorrowSP tmp = (Mco003SearchBorrowSP)wrapperBeanObject.getDataObj();
				if (StringUtils.isEmpty(tmp.getBorrowName())) {
					getSemmco003Bean().setDisBtnBorrow(true);
				}
			}else{
				getSemmco003Bean().setChkSelAll(false);
			}
		}
		if(bgMaster.size() == i){
			getSemmco003Bean().setChkSelAll(true);
		}
		return isCheck;
	}
	
	public void doExportExcel(){
		try{
			
			short line = 0;
			Collection<Mco003SearchBorrowSP> exList = new ArrayList<Mco003SearchBorrowSP>();
			DocumentExportManager<Mco003SearchBorrowSP> docManager =
				new DocumentExportManager<Mco003SearchBorrowSP>(Mco003SearchBorrowSP.class, EnumDocumentType.XLS);
				docManager.setRowStart(line);
			
			EnumDocStyleDomain headerStyle = new EnumDocStyleDomain(EnumDocStyle.HEADER);
			RowDomain row0 = new RowDomain(0,true);
			row0.setCell(new CellDomain(0, null, String.class, headerStyle, msg("export.col.no"),-1,1500));
			row0.setCell(new CellDomain(1, null, String.class, headerStyle.setWrapTxt(true), msg("export.col.oldNew"),-1,3000));
			row0.setCell(new CellDomain(2, null, String.class, headerStyle, msg("export.column.contractNo"),-1,3000));	
			row0.setCell(new CellDomain(3, null, String.class, headerStyle, msg("export.column.siteName"),-1,5000));
			row0.setCell(new CellDomain(4, null, String.class, headerStyle, msg("export.column.effDate"),-1,4000));
			row0.setCell(new CellDomain(5, null, String.class, headerStyle, msg("export.column.expDate"),-1,4000));
			row0.setCell(new CellDomain(6, null, String.class, headerStyle, msg("export.column.borrowName"),-1,2200));
			row0.setCell(new CellDomain(7, null, String.class, headerStyle, msg("export.column.borrowOfficerName"),-1,2200));
			row0.setCell(new CellDomain(8, null, String.class, headerStyle, msg("export.column.docContractFlag"),-1,1200));
			row0.setCell(new CellDomain(9, null, String.class, headerStyle, msg("export.column.docApproveFlag"),-1,3000));
			row0.setCell(new CellDomain(10, null, String.class, headerStyle, msg("export.column.remarkDocOther"),-1,3000));
			row0.setCell(new CellDomain(11, null, String.class, headerStyle, msg("export.column.borrowDt"),-1,3000));
			row0.setCell(new CellDomain(12, null, String.class, headerStyle, msg("export.col.licenseReturn"),-1,2000));
			row0.setCell(new CellDomain(13, null, String.class, headerStyle, msg("export.column.returnDt"),-1,2500));
			row0.setCell(new CellDomain(14, null, String.class, headerStyle, msg("export.column.borrowForTypeName"),-1,2500));
			row0.setCell(new CellDomain(15, null, String.class, headerStyle, msg("export.column.remarkCannotBorrow"),-1,8000));
			
			List<WrapperBeanObject<Mco003SearchBorrowSP>> detailList = new ArrayList<WrapperBeanObject<Mco003SearchBorrowSP>>();
			detailList = getSemmco003Bean().getBorrowSPList();
			
			int no = 0;
			for(int i=0; i<detailList.size(); i++){
				WrapperBeanObject<Mco003SearchBorrowSP> detail = new WrapperBeanObject<Mco003SearchBorrowSP>();
				detail = detailList.get(i);
				Mco003SearchBorrowSP mcoSP = ((Mco003SearchBorrowSP)detail.getDataObj());
				if(detail.isCheckBox()){
					++no;
					((Mco003SearchBorrowSP)detail.getDataObj()).setNo(no);
					if(mcoSP.getEffectiveDt() != null){
						mcoSP.setEffectiveStr(SEMDataUtility.toStringEngDateSimpleFormat(mcoSP.getEffectiveDt()));
					}
					if (mcoSP.getExpireDt() !=null){
						mcoSP.setExpireStr(SEMDataUtility.toStringEngDateSimpleFormat(mcoSP.getExpireDt()));
					}
					if (mcoSP.getBorrowDt() !=null){
						mcoSP.setBorrowStr(SEMDataUtility.toStringEngDateSimpleFormat(mcoSP.getBorrowDt()));
					}
					if (mcoSP.getReturnDt() !=null){
						mcoSP.setReturnStr(SEMDataUtility.toStringEngDateSimpleFormat(mcoSP.getReturnDt()));
					}
					exList.add(((Mco003SearchBorrowSP)detail.getDataObj()));
				}
			}
			
            docManager.putDetailRow(row0);
			docManager.seteObjectList(exList);
			docManager.setMargin(0.05, 0.05, 0.5, 0.05);
			docManager.setFitWidth((short)1);
			docManager.setModule("SEARCH_BORROW_");
			docManager.setPrintPageLandScape(true);
			docManager.getObjectFromDocument();
			docManager.exportServletFile();
		}catch(Exception e){
		}

	}
	
	public void getRowIdOnClick() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemmco003Bean().setTmpRowId(rowId);
	}
	
	public void getRowIdOnClick2() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemmco003Bean().setTmpRowId2(rowId);
	}
	
	public void chkTxtBorrowName() {
		semmco003Bean = getSemmco003Bean();
		if (StringUtils.isEmpty(semmco003Bean.getBorrowContract().getBorrowName())) {
			semmco003Bean.setDisTxtBorrowName(true);
		} else {
			semmco003Bean.setDisTxtBorrowName(false);
		}
		log.debug("officer = "+semmco003Bean.getBorrowContract().getBorrowOfficer());
		setSemmco003Bean(semmco003Bean);
	}
	
	public void chkTxtReturnName() {
		semmco003Bean = getSemmco003Bean();
		if (StringUtils.isEmpty(semmco003Bean.getReturnContract().getReturnName())) {
			semmco003Bean.setDisTxtReturnName(true);
		} else {
			semmco003Bean.setDisTxtReturnName(false);
		}
		setSemmco003Bean(semmco003Bean);
	}
	
	private boolean doInitAddContract() {
		log.debug("doInitAddContract");
		semmco003Bean = getSemmco003Bean();
		String onePopup = (String) getFacesUtils().getRequestParameter("onePopup");
		semmco003Bean.setContractSPList(null);
		semmco003Bean.setDisabledBtnAdd(true);
		semmco003Bean.setAddContractNo("");
		if(StringUtils.equalsIgnoreCase("trueFlag", onePopup)){
			semmco003Bean.setOnePopupFlag(true);
			semmco003Bean.setMode("EDIT");
		}else{
			semmco003Bean.setOnePopupFlag(false);
		}
		setSemmco003Bean(semmco003Bean);
		return false;
	}

	private boolean doClearAddContrac() {
		semmco003Bean = getSemmco003Bean();
		// TODO Auto-generated method stub
		semmco003Bean.setContractSPList(null);
		semmco003Bean.setAddContractNo("");
		setSemmco003Bean(semmco003Bean);
		return false;
	}
	
	private List<Mco003SearchBorrowSP> srchChkCotract(Mco003SearchBorrowSP sco003SearchBorrowSP) {
		try {
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			return service.querySPList(EQueryName.SP_MCO003_CHK_CONTRACT.name, sco003SearchBorrowSP);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private boolean doClearPop(){
		boolean flag = false;
		semmco003Bean = getSemmco003Bean();
		semmco003Bean.setAddContractNo("");
		semmco003Bean.setRenderedMsgFormTop(false);
		// semmco003Bean.getBorrowRequestSPList().clear();
//		semmco003Bean.setBorrowSPList(null);
		// 20130105
		// semmco003Bean.setCriteriaBorrow(new Mco003SearchBorrowSP());
		// semmco003Bean.getBorrowSPList().clear();
		setSemmco003Bean(semmco003Bean);
		return flag;
	}
	
	public boolean doCancelBorrow(){
		semmco003Bean = getSemmco003Bean();
		semmco003Bean.setRenderedMsgFormTop(false);
		IBorrowRequestService service = (IBorrowRequestService)getBean("borrowRequestService");
		try {
		Mco003InsertBorrowSP mco003InsertBorrowSP = new Mco003InsertBorrowSP();
		mco003InsertBorrowSP.setDocNo(semmco003Bean.getBorrowRequest().getDocNo());
//		mco003InsertBorrowSP.setContractNo(psi002.getContractNo());
		mco003InsertBorrowSP.setMode("DEL");
		mco003InsertBorrowSP.setCompany(semmco003Bean.getBorrowRequest().getCompany());
		mco003InsertBorrowSP.setRecievDt(semmco003Bean.getBorrowRequest().getReceiveDt());
		mco003InsertBorrowSP.setSamSendDt(semmco003Bean.getBorrowRequest().getSamSendDt());
		mco003InsertBorrowSP.setSamAssignSend(semmco003Bean.getBorrowRequest().getSamAssignSendDt());
		mco003InsertBorrowSP.setRemark(semmco003Bean.getBorrowRequest().getRemark());
		mco003InsertBorrowSP.setUser(getUserLogIn());
		mco003InsertBorrowSP.setStatus("02");
	
			List<Mco003InsertBorrowSP> resultList = service.querySPList(EQueryName.SP_MCO003_INSERT.name, mco003InsertBorrowSP);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doSearch();
		setSemmco003Bean(semmco003Bean);
		return false;
	}
	
	//added by new 
	public void onRenderButton() {
		semmco003Bean = getSemmco003Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		semmco003Bean.setTmpRowId(rowId);
//		semmsa003Bean = getSemmsa003Bean();
//		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
//		semmsa003Bean.setTmpRowId(rowId);
		
//		if (isCheckSELBox()) {
//			semmsa003Bean.setDisabledBtnExport(false);
//		} else {
//			semmsa003Bean.setDisabledBtnExport(true);
//		}
		
		if (!isBorrowCheckSELBox()) {
			semmco003Bean.setDisabledBtnAdd(true);
		} else{
			semmco003Bean.setDisabledBtnAdd(false);
		}
		setSemmco003Bean(semmco003Bean);
	}
	
	private boolean isBorrowCheckSELBox() {
		boolean isCheck = false;
		int rowSelect = 1;
		Mco003SearchPSI002SP borrowContractSP = new Mco003SearchPSI002SP();
		String batchTmp = null; 
		String flowStatus = null;
		ArrayList batchTempList = new ArrayList(); 
		semmco003Bean.setDisabledBtnExport(false);
		boolean checkBatchNo = true;
		try{
			List<WrapperBeanObject<Mco003SearchPSI002SP>> borrowContractList = getSemmco003Bean().getContractSPList();
			for (WrapperBeanObject<Mco003SearchPSI002SP> wrapperBeanObject : borrowContractList) {
				borrowContractSP = (Mco003SearchPSI002SP) wrapperBeanObject.getDataObj();
				if (wrapperBeanObject.isCheckBox()) {

					//check popup  new button
//					if(rowSelect == 1){
//						if(siteAcqSP.getFlowStatusId().equals("11")){
//							semmsa003Bean.setDisabledBtnPopupNew(false);
//						}else{
//							semmsa003Bean.setDisabledBtnPopupNew(false);
//						}
//					}else{
//						semmsa003Bean.setDisabledBtnPopupNew(true);
//					}
					
					//check export button
//					batchTempList.add(siteAcqSP.getP_batch_no());
//					if(siteAcqSP.getP_batch_no() != null){
//						batchTmp = siteAcqSP.getP_batch_no();
//						semmsa003Bean.setBatchNoTmp(batchTmp);
//					}
//					
//					//check reAssign button
//					if(rowSelect == 1){
//						
//						if(siteAcqSP.getFlowStatusId().equals("00")){
//							flowStatus = siteAcqSP.getFlowStatusId();
//							semmsa003Bean.setDisabledBtnReassign(false);
//						}else{
//							flowStatus = "false";
//							semmsa003Bean.setDisabledBtnReassign(true);
//						}
//					}else{
//						if(flowStatus.equals("false")){
//							semmsa003Bean.setDisabledBtnReassign(true);
//						}else{
//							if(siteAcqSP.getFlowStatusId().equals("00")){
//								flowStatus = siteAcqSP.getFlowStatusId();
//								semmsa003Bean.setDisabledBtnReassign(false);
//							}else{
//								flowStatus = "false";
//								semmsa003Bean.setDisabledBtnReassign(true);
//							}
//						}
//					}
//					
//				
					rowSelect++;
					isCheck = true;
				}
			}
			//check batch
//			for(int i = 0;i<batchTempList.size();i++){
//				if(batchTmp!=null){
//					if(!batchTmp.equals(batchTempList.get(i))){
//						semmsa003Bean.setDisabledBtnExport(true);
//						//checkBatchNo = false;
//					}
//				}else{
//					semmsa003Bean.setBatchNoTmp(new String());
//				}
//			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error(e);
		}
		
		return isCheck;
	}
	
	//update by new 21/07/2015
	public void doGetLegalDoc() {
		log.info("::: SEMMSI002Action :: doGetLegalDoc >> BEGIN :::");

		try {
			
			//SEMMSI002Bean semmsi002Bean = getSemmsi002Bean();
			semmco003Bean = getSemmco003Bean();

			String paramSiteAppId = semmco003Bean.getSiteAppObjParam().getSiteAppId();
			String paramPlaceType = semmco003Bean.getSiteAppObjParam().getPlaceType(); //String paramPlaceType = semmsa002Bean.getParamPlaceType(); old fixed to new 
			String paramPartiesType = semmco003Bean.getSiteAppObjParam().getPartiesType(); //String paramPartiesType = semmsa002Bean.getParamPartiesType(); old fixed to new 
//			
	        System.out.println("paramSiteAppId: " + paramSiteAppId);
	        System.out.println("paramPlaceType: " + paramPlaceType);
	        System.out.println("paramPartiesType: " + paramPartiesType);
	        
	        
	        SEMMSI002Bean semmsi002BeanCriteria = new SEMMSI002Bean();
	        semmsi002BeanCriteria.setParamSiteAppId(paramSiteAppId);
	        semmsi002BeanCriteria.setParamPlaceType(paramPlaceType);
	        semmsi002BeanCriteria.setParamPartiesType(paramPartiesType);
			
	        semmco003Bean.setLegalDocList(new ArrayList<WrapperBeanObject<LegalDocComponentBean>>());
	        
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
						//--------------------------------------------------------------
						
						WrapperBeanObject<LegalDocComponentBean> tmpWrapperBean = new WrapperBeanObject<LegalDocComponentBean>();
						
						tmpWrapperBean.setDataObj(myComponent);
						tmpWrapperBean.setMessage("");

						semmco003Bean.getLegalDocList().add(tmpWrapperBean);
						// gen legal doc component list <<
						
						count++;
					}
					semmco003Bean.setRenderedMsgDataNotFound(false);
	        	} else {
	        		semmco003Bean.setRenderedMsgDataNotFound(true);
	        	}
        	
	        }
			setSemmco003Bean(semmco003Bean);
			//setSEMMSA002Bean(semmsa002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			addMessageError("EL0000", "SEMMCO003Action");
		} finally {
			log.info("::: SEMMCO003Action :: doGetLegalDoc >> END :::");
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
			semmco003Bean = getSemmco003Bean();
			//semmsi002Bean = getSemmsi002Bean();
			
//			HashSet keys = new HashSet<Integer>();
//	        int rowKey = getRepeater().getRowIndex();
			
	       // System.out.println("rowKey: " + Integer.toString(rowKey));
	        
			List<WrapperBeanObject<LegalDocComponentBean>> legalDocLst = semmco003Bean.getLegalDocList();
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
					semmco003Bean.setLegalDocList(legalDocLst);
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
			setSemmco003Bean(semmco003Bean);
		} catch(Exception e) {
			e.printStackTrace();
			addMessageError("EL0000", "SEMMCO003Action");
			
			//semmco001Bean.setRenderedMsgAlert(true);
			setSemmco003Bean(semmco003Bean);
		} finally {
			
		}
	}
	
	public void doUpdateLegalDoc() {
		
		try {
			
			this.doSetCheckBoxLegalDocEntity();			
			
			semmco003Bean = getSemmco003Bean();
			//semmsi002Bean = getSemmsi002Bean();
			
			List<WrapperBeanObject<LegalDocComponentBean>> legalDocLst = semmco003Bean.getLegalDocList();
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
			semmco003Bean.getSiteAppObjParam().setStrDataList(strDataList);
			semmco003Bean.getSiteAppObjParam().setUserLogin(getUserLogIn());
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
			
			setSemmco003Bean(semmco003Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			addMessageError("EL0000", "SEMMCO003Action");
			
			setSemmco003Bean(semmco003Bean);
		} finally {
			
		}
		
	}
	
	public void doSetCheckBoxLegalDocEntity() {
		
		try {
			
			semmco003Bean = getSemmco003Bean();
			//semmsi002Bean = getSemmsi002Bean();
			
			List<WrapperBeanObject<LegalDocComponentBean>> legalDocLst = semmco003Bean.getLegalDocList();
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
				
				semmco003Bean.setLegalDocList(legalDocLst);
			}
			
			setSemmco003Bean(semmco003Bean);
			//setSemmsi002Bean(semmsi002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			addMessageError("EL0000", "SEMMCO003Action");
			log.debug("ERROR SEMMCO003Action doSetCheckBoxLegalDocEntity "+e);
			setSemmco003Bean(semmco003Bean);
		} finally {
			
		}
	}

	public boolean doApproveBorrow(){
		log.debug("##### Start SEMMCO003Action doApproveBorrow######");
		boolean flag = true;
		String contractNo = "";
		String borrowStatus = getFacesUtils().getRequestParameter("approveStatus") == null ? "" : (String)getFacesUtils().getRequestParameter("approveStatus");
 		List<Mco003SearchBorrowSP> to = new ArrayList<Mco003SearchBorrowSP>();
		try{
			
			List<WrapperBeanObject<Mco003SearchBorrowSP>> detailList = new ArrayList<WrapperBeanObject<Mco003SearchBorrowSP>>();
			detailList = getSemmco003Bean().getBorrowSPList();
			
			for(int i=0; i<detailList.size(); i++){
				WrapperBeanObject<Mco003SearchBorrowSP> detail = new WrapperBeanObject<Mco003SearchBorrowSP>();
				detail = detailList.get(i);
				Mco003SearchBorrowSP mcoSP = ((Mco003SearchBorrowSP)detail.getDataObj());
				if(detail.isCheckBox()){
					if(StringUtils.isEmpty(contractNo))
						contractNo = mcoSP.getRowId();
					else
						contractNo = contractNo+","+mcoSP.getRowId();
					
				}
			}
			
			Mco003SearchBorrowSP obj = new Mco003SearchBorrowSP();
			obj.setContractNo(contractNo);
			obj.setBorrowStatus(borrowStatus);
			obj.setUserId(getUserLogIn());
			
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			to = service.querySPList(EQueryName.SP_MCO003_APPROVE_BORROW.name, obj);
			
			if(to != null){
				if(StringUtils.equals("SUCCESS", to.get(0).getResult())){
					addGeneralMessageInfo(to.get(0).getlMessage());
					
					this.onRenderExportButton();

					flag = doSearchContract();
				}else{
					addGeneralMessageError(to.get(0).getlMessage());
				}
			}else{
				addMessageError("EL0061");
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("##### Error SEMMCO003Action doApproveBorrow : "+e);
			addMessageError("EL0061");
			flag = false;
		}finally{
			log.debug("##### End SEMMCO003Action doApproveBorrow ######");
		}
		return flag;
	}
	
    public void selectReturnNotAllFlag(){
		
    	semmco003Bean = getSemmco003Bean();
		
		boolean returnNotAllFlag = semmco003Bean.isReturnNotAllFlagBoolean();		
		
		if (returnNotAllFlag) {
			semmco003Bean.setDisabledCheckBox(false);
		} else {
		semmco003Bean.setDisabledCheckBox(true);
		}
		setSemmco003Bean(semmco003Bean);
		return ;
	}
	
}
