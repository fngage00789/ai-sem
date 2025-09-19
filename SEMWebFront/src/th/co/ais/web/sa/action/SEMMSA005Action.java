package th.co.ais.web.sa.action;

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
import th.co.ais.domain.sa.MSA001LovSP;
import th.co.ais.domain.sa.SiteAcqSrchFile;
import th.co.ais.domain.sa.SiteAppSP;
import th.co.ais.rpt.util.bean.CellDomain;
import th.co.ais.rpt.util.bean.EnumDocStyleDomain;
import th.co.ais.rpt.util.bean.RowDomain;
import th.co.ais.rpt.util.enums.EnumDocStyle;
import th.co.ais.rpt.util.enums.EnumDocumentType;
import th.co.ais.service.co.IBorrowRequestService;
import th.co.ais.service.co.IContractStatusService;
import th.co.ais.service.sa.ISiteAcquistionService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.report.util.DocumentExportManager;
import th.co.ais.web.sa.bean.LegalDocComponentBean;
import th.co.ais.web.sa.bean.SEMMSA005Bean;
import th.co.ais.web.si.bean.SEMMSI002Bean;
import th.co.ais.web.util.MSGCacheUtil;
import th.co.ais.web.util.SelectItemLOVCacheUtil;

public class SEMMSA005Action extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5948969912065583760L;
	private Logger log = Logger.getLogger(getClass());
	private SEMMSA005Bean semmsa005Bean;

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
		}else if (methodWithNavi.equalsIgnoreCase("initDownloadContract")) {
			flag = initDownloadContract();
		}else if (methodWithNavi.equalsIgnoreCase("doSendApproveBorrow")) {
			flag = doSendApproveBorrow();
		}else if(methodWithNavi.equalsIgnoreCase("doAutoSaveNewBorrowContract")){
			flag = doAutoSaveNewBorrowContract();
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
		SEMMSA005Bean semmsa005Bean = new SEMMSA005Bean();
		semmsa005Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmsa005Bean.setCriteria(new Mco003SrchBorrowRequestSP());
		semmsa005Bean.setBorrowRequestSPList(new ArrayList());
		semmsa005Bean.setReturnContract(new ReturnContract());
		semmsa005Bean.setDisBtnBorrow(true);
		//  MERGE NEW POPUP BY NOOM
		
//		semmsa005Bean.setBorrowNameList(new ArrayList<SelectItem>());
//		semmsa005Bean.setBorrowOfficerList(new ArrayList<SelectItem>());
//		semmsa005Bean.setBorrowForList(new ArrayList<SelectItem>());
		
		
		setSemmsa005Bean(semmsa005Bean);
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void setSemmsa005Bean(SEMMSA005Bean semmsa005Bean) {
		this.semmsa005Bean = semmsa005Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsa005Bean", this.semmsa005Bean);
	}

	public SEMMSA005Bean getSemmsa005Bean() {
		return (SEMMSA005Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsa005Bean");
	}
	
	private boolean doBack() {
		boolean flag = true;
		doSearch();
		return flag;
	}
	
	@SuppressWarnings("unchecked")
	private boolean doSearch() {
		boolean flag = false;
		semmsa005Bean = getSemmsa005Bean();
		semmsa005Bean.setBorrowRequestSPList(new ArrayList<WrapperBeanObject<Mco003SrchBorrowRequestSP>>());
		semmsa005Bean.setRenderedMsgFormSearch(false);
		if(!validateSearch()){
			semmsa005Bean.setRenderedMsgFormSearch(true);
			return flag;
		}
		List<Mco003SrchBorrowRequestSP> to = null;
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			to = service.querySPList(EQueryName.SEM_SP_MCO003_SRCH.name, semmsa005Bean.getCriteria());
			if(to != null && to.size() > 0){
				semmsa005Bean.setRenderedMsgDataNotFound(false);
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
					semmsa005Bean.getBorrowRequestSPList().add(tmpWrapperBean);
				}
			} else {
				semmsa005Bean.setRenderedMsgDataNotFound(true);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsa005Bean(semmsa005Bean);
		return flag;
	}
	
	private boolean validateSearch() {
		boolean flgValid = true;
		
		if(StringUtils.isEmpty(getSemmsa005Bean().getCriteria().getContractNo())&&StringUtils.isEmpty(getSemmsa005Bean().getCriteria().getDocNo())){
			if(StringUtils.isEmpty(getSemmsa005Bean().getCriteria().getCompany())){
				addMessageError("W0001", msg("message.company"));
				flgValid = false;
			}
		}
		
		return flgValid;
	}
	
	@SuppressWarnings("unchecked")
	private boolean initAddBorrowContract(){
		boolean flag = false;
		semmsa005Bean = getSemmsa005Bean();
		semmsa005Bean.setMode("ADD");
		semmsa005Bean.setBorrowRequest(new BorrowRequest());
		semmsa005Bean.getBorrowRequest().setReceiveDt(new Date());
		semmsa005Bean.getBorrowRequest().setSamSendDt(new Date());
		semmsa005Bean.setAddContractNo("");
		semmsa005Bean.setContractAdd("");
		semmsa005Bean.setCacheContractAdd("");
		semmsa005Bean.setBorrowSPList(null);
		semmsa005Bean.setContractSPList(null);
		semmsa005Bean.setRenderedMsgFormSearch(false);
		//Merge new Popup By Noom 11/03/2013
//		semmsa005Bean.setBorrowNameList(SelectItemLOVCacheUtil.getInstance().getLovItemsValueNameByType(ELovType.T_SI_SITE_APPROVE_FROM.name));
//		semmsa005Bean.setBorrowOfficerList(getLovItemsByType(ELovType.T_CO_BORROW_OFFICER.name));
//		semmsa005Bean.setBorrowForList(getLovItemsByType(ELovType.T_CO_BORROW_FOR_TYPE.name));
		//
		
		List<BorrowRequestGenDocNoSearchSP> genNo = null;
		try {
			IBorrowRequestService service = (IBorrowRequestService)getBean("borrowRequestService");
			List querySPList = service.querySPList(EQueryName.SP_MCO003_GEN_DOC_NO.name, semmsa005Bean.getBorrowRequest());
			genNo = querySPList;
			semmsa005Bean.getBorrowRequest().setDocNo((genNo.get(0).getGenDocNo()!=null)?genNo.get(0).getGenDocNo():"");
			log.debug(" getDocNo() : "+semmsa005Bean.getBorrowRequest().getDocNo());
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmsa005Bean(semmsa005Bean);
		return flag;
	}
	
	//added by NEW 2019/03/26
	private boolean doAutoSaveNewBorrowContract(){
		log.debug("doSaveBorrowContract");
		boolean flag = true;
		initAddBorrowContract();
		semmsa005Bean = getSemmsa005Bean();
		IBorrowRequestService service = (IBorrowRequestService)getBean("borrowRequestService");
//		if(!validateUpdateContractStatus()){
//			semmsa005Bean.setRenderedMsgFormSearch(false);
//			semmsa005Bean.setPopupClose(false);
//			setSemmsa005Bean(semmsa005Bean);
//			return flag;
//		}
//		
		String newBorrowReq = getFacesUtils().getRequestParameter("newBorrowReq") == null ? "" : (String)getFacesUtils().getRequestParameter("newBorrowReq");
		BorrowRequest borrow = new BorrowRequest();
		
		try{
			borrow = service.queryBorrowRequestByDocNo(semmsa005Bean.getBorrowRequest().getDocNo());
			if (borrow != null) {
				addMessageError("W0073", semmsa005Bean.getBorrowRequest().getDocNo());
				semmsa005Bean.setPopupClose(false);
			} else {
//				semmsa005Bean.getBorrowRequest().setRecordStatus("Y");
//				semmsa005Bean.getBorrowRequest().setCurrentUser(getUserLogIn());
//				service.createBorrowContract(semmsa005Bean.getBorrowRequest());
				Mco003InsertBorrowSP mco003InsertBorrowSP = new Mco003InsertBorrowSP();
				mco003InsertBorrowSP.setDocNo(semmsa005Bean.getBorrowRequest().getDocNo());
//				mco003InsertBorrowSP.setContractNo(psi002.getContractNo());
				
					mco003InsertBorrowSP.setMode("ADD");
				
				mco003InsertBorrowSP.setpOption("M");
				mco003InsertBorrowSP.setCompany(semmsa005Bean.getBorrowRequest().getCompany());
				mco003InsertBorrowSP.setRecievDt(semmsa005Bean.getBorrowRequest().getReceiveDt());
				mco003InsertBorrowSP.setSamSendDt(semmsa005Bean.getBorrowRequest().getSamSendDt());
				mco003InsertBorrowSP.setSamAssignSend(semmsa005Bean.getBorrowRequest().getSamAssignSendDt());
				mco003InsertBorrowSP.setRemark(semmsa005Bean.getBorrowRequest().getRemark());
				mco003InsertBorrowSP.setUser(getUserLogIn());
				mco003InsertBorrowSP.setSiteNum(semmsa005Bean.getBorrowRequest().getSiteNum());
				//set status
				mco003InsertBorrowSP.setStatus("00");
				
				List<Mco003InsertBorrowSP> resultList = service.querySPList(EQueryName.SP_MCO003_INSERT_NEW.name, mco003InsertBorrowSP);
				
//				addMessageInfo("M0001");
				semmsa005Bean.setMode("");
				// 20101210 after save do search
				if(!StringUtils.isEmpty(mco003InsertBorrowSP.getDocNo())){ 
					doInitBorrowContractNew(mco003InsertBorrowSP.getDocNo());
					semmsa005Bean.getCriteria().setDocNo(mco003InsertBorrowSP.getDocNo());
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0001");
			semmsa005Bean.setPopupClose(false);
		}
		semmsa005Bean.setPopupClose(true);
		semmsa005Bean.setRenderedMsgFormSearch(true);
		semmsa005Bean.setNewBorrowReq(newBorrowReq);
		setSemmsa005Bean(semmsa005Bean);
		return flag;
	}
	
	private boolean doInitBorrowContractNew(String docNoCri){
		boolean flgValid = true;
		semmsa005Bean = getSemmsa005Bean();
		
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		String company = (String)getFacesUtils().getRequestParameter("company");
		String sumSite = (String)getFacesUtils().getRequestParameter("siteNum");
		String docNo = (String)getFacesUtils().getRequestParameter("docNo");
		Mco003SrchBorrowRequestSP criteria = new Mco003SrchBorrowRequestSP();
		try{
			List<Mco003SrchBorrowRequestSP> to = new ArrayList<Mco003SrchBorrowRequestSP>();
			criteria.setDocNo(docNoCri);
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			to = service.querySPList(EQueryName.SEM_SP_MCO003_SRCH.name, criteria);
			if(to != null && to.size() > 0){
				Mco003SearchBorrowSP borrow = new Mco003SearchBorrowSP();
				
				semmsa005Bean.setRenderedMsgDataNotFound(false);
				for (int i = 0; i < to.size(); i++) {
					Mco003SrchBorrowRequestSP contract = to.get(i);
//					WrapperBeanObject<Mco003SrchBorrowRequestSP> tmpWrapperBean = new WrapperBeanObject<Mco003SrchBorrowRequestSP>();
//					if(contract.getReceiveDt() != null) contract.setReceiveDt(convertYearENtoTH(contract.getReceiveDt()));
//					if(contract.getSamSendDt() != null) contract.setSamSendDt(convertYearENtoTH(contract.getSamSendDt()));
//					if(contract.getSamAssignSendDt() != null) contract.setSamAssignSendDt(convertYearENtoTH(contract.getSamAssignSendDt()));
//					if(contract.getReceiveDt() != null) contract.setReceiveDtStr(convertYearENtoTHStr(contract.getReceiveDt()));
//					if(contract.getSamSendDt() != null) contract.setSamSendDtStr(convertYearENtoTHStr(contract.getSamSendDt()));
//					if(contract.getSamAssignSendDt() != null) contract.setSamAssignSendDtStr(convertYearENtoTHStr(contract.getSamAssignSendDt()));
					
//					tmpWrapperBean.setDataObj(contract);
//					tmpWrapperBean.setMessage("");
//					tmpWrapperBean.setCheckBox(false);
//					semmsa005Bean.getBorrowRequestSPList().add(tmpWrapperBean);
					rowId = contract.getRowId();
					company = contract.getCompany();
//					String sumSite = (String)getFacesUtils().getRequestParameter("siteNum");
					docNo = contract.getDocNo();
					borrow.setBorrowRequestId(rowId);
					borrow.setRowId(rowId);
					borrow.setCompany(company);
					borrow.setDocNo(docNo);
				}
				
				sumSite = (StringUtils.isEmpty(sumSite))? "0": sumSite;
				semmsa005Bean.setSumSite(Integer.parseInt(sumSite));
				semmsa005Bean.setBorrowOfficerList(new ArrayList<SelectItem>());
				borrow.setCompany(company);
				borrow.setDocNo(docNo);
				semmsa005Bean.setBorrowForList(getLovItemsByType(ELovType.T_CO_BORROW_FOR_TYPE.name));
				semmsa005Bean.setCriteriaBorrow(borrow);
				log.debug(" ##### rowId : "+rowId);
				semmsa005Bean.setInsertBorrowID(rowId);
				semmsa005Bean.setBorrowSPList(null);
				semmsa005Bean.setViewContractNo("");
				semmsa005Bean.setAddPreContractNo("");
				semmsa005Bean.setAddContractNo("");
				semmsa005Bean.setBorrowRequest(new BorrowRequest());
				semmsa005Bean.setBorrowNameList(SelectItemLOVCacheUtil.getInstance().getLovItemsValueNameByType(ELovType.T_SI_SITE_APPROVE_FROM.name));
				semmsa005Bean.setRenderedMsgFormSearch(false);
				
				String mode = (String)getFacesUtils().getRequestParameter("mode");
				semmsa005Bean.setModeReturn(mode);
//				if (mode.equals("VIEW")) {
				doSearchBorrowContract();
//				}
			} else {
				semmsa005Bean.setRenderedMsgDataNotFound(true);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		setSemmsa005Bean(semmsa005Bean);
		return flgValid;
	}
	
	private boolean doSearchBorrowContract(){
		boolean flag = false;
		semmsa005Bean = getSemmsa005Bean();
		semmsa005Bean.setRenderedMsgDataNotFound(false);
//		if(!validateContract()){
//			return flag;
//		}
		
		String contractNo = semmsa005Bean.getViewContractNo();
		SEMMSA005Bean criteria = semmsa005Bean;
		criteria.getCriteriaBorrow().setContractNo(contractNo);
		semmsa005Bean.setBorrowSPList(searchContract(criteria));
		semmsa005Bean.setCacheSrchBorrowList(semmsa005Bean.getBorrowSPList());	// 20110106
		semmsa005Bean.setCacheAddBorrowList(null);
		semmsa005Bean.setCacheContractAdd("");
		this.onRenderExportButton();
		setSemmsa005Bean(semmsa005Bean);
		return flag;
	}
	
	private boolean doSaveBorrowContract(){
		log.debug("doSaveBorrowContract");
		boolean flag = false;
		semmsa005Bean = getSemmsa005Bean();
		IBorrowRequestService service = (IBorrowRequestService)getBean("borrowRequestService");
		if(!validateUpdateContractStatus()){
			semmsa005Bean.setRenderedMsgFormSearch(false);
			semmsa005Bean.setPopupClose(false);
			setSemmsa005Bean(semmsa005Bean);
			return flag;
		}
		
		BorrowRequest borrow = null;
		
		try{
			borrow = service.queryBorrowRequestByDocNo(semmsa005Bean.getBorrowRequest().getDocNo());
			if (borrow != null) {
				addMessageError("W0073", semmsa005Bean.getBorrowRequest().getDocNo());
				semmsa005Bean.setPopupClose(false);
			} else {
//				semmsa005Bean.getBorrowRequest().setRecordStatus("Y");
//				semmsa005Bean.getBorrowRequest().setCurrentUser(getUserLogIn());
//				service.createBorrowContract(semmsa005Bean.getBorrowRequest());
				Mco003InsertBorrowSP mco003InsertBorrowSP = new Mco003InsertBorrowSP();
				mco003InsertBorrowSP.setDocNo(semmsa005Bean.getBorrowRequest().getDocNo());
//				mco003InsertBorrowSP.setContractNo(psi002.getContractNo());
				if(StringUtils.equalsIgnoreCase("EDIT", semmsa005Bean.getMode())){
					mco003InsertBorrowSP.setMode("EDIT");
				}else {
					mco003InsertBorrowSP.setMode("ADD");
				}
				mco003InsertBorrowSP.setpOption("M");
				mco003InsertBorrowSP.setCompany(semmsa005Bean.getBorrowRequest().getCompany());
				mco003InsertBorrowSP.setRecievDt(semmsa005Bean.getBorrowRequest().getReceiveDt());
				mco003InsertBorrowSP.setSamSendDt(semmsa005Bean.getBorrowRequest().getSamSendDt());
				mco003InsertBorrowSP.setSamAssignSend(semmsa005Bean.getBorrowRequest().getSamAssignSendDt());
				mco003InsertBorrowSP.setRemark(semmsa005Bean.getBorrowRequest().getRemark());
				mco003InsertBorrowSP.setUser(getUserLogIn());
				mco003InsertBorrowSP.setSiteNum(semmsa005Bean.getBorrowRequest().getSiteNum());
				//set status
				mco003InsertBorrowSP.setStatus("00");
				
				List<Mco003InsertBorrowSP> resultList = service.querySPList(EQueryName.SP_MCO003_INSERT.name, mco003InsertBorrowSP);
				
				addMessageInfo("M0001");
				semmsa005Bean.setMode("");
				// 20101210 after save do search
				if(!StringUtils.isEmpty(getSemmsa005Bean().getCriteria().getCompany())){ 
					doSearch();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0001");
			semmsa005Bean.setPopupClose(false);
		}
		semmsa005Bean.setPopupClose(true);
		semmsa005Bean.setRenderedMsgFormSearch(true);
		setSemmsa005Bean(semmsa005Bean);
		return flag;
	}
	
	private boolean validateUpdateContractStatus() {
		boolean flgValid = true;
		if(StringUtils.isEmpty(getSemmsa005Bean().getBorrowRequest().getCompany())){
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		 
		Date receiveDt = getSemmsa005Bean().getBorrowRequest().getReceiveDt();
		Date samSendDt = getSemmsa005Bean().getBorrowRequest().getSamSendDt();
		
		if(receiveDt == null){
			addMessageError("W0001", msg("message.receiveDt"));
			flgValid = false;
		}
		
		if(samSendDt == null){
			addMessageError("W0001", msg("message.samSendDt"));
			flgValid = false;
		}
		
		if (getSemmsa005Bean().getBorrowRequest().getSiteNum().equals(new BigDecimal(0))) {
			addMessageError("W0001", msg("message.borrowSiteNum"));
			flgValid = false;
		}
		
//		if (StringUtils.isEmpty( getSemmsa005Bean().getBorrowRequest().getFileType())){
//			addMessageError("W0001", msg("msg.borrowFileType"));
//			flgValid = false;
//		}
		
		if (flgValid) {
			Date samAssignSendDt = getSemmsa005Bean().getBorrowRequest().getSamAssignSendDt();
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
		semmsa005Bean = getSemmsa005Bean();
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		String company = (String)getFacesUtils().getRequestParameter("company");
		String docNo = (String)getFacesUtils().getRequestParameter("docNo");
		semmsa005Bean.setInsertBorrowID(rowId);
		semmsa005Bean.setContractAdd("");
		semmsa005Bean.setCacheContractAdd("");
		semmsa005Bean.setBorrowSPList(null);
		semmsa005Bean.setTmpDocNo(docNo);
		IBorrowRequestService borService = (IBorrowRequestService)getBean("borrowRequestService");
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		try{
		BorrowRequest borrow = borService.queryBorrowRequestByRowId(rowId);
		
		Mco003SearchBorrowSP criteriaSrch = new Mco003SearchBorrowSP();
		criteriaSrch.setCompany(company);
		criteriaSrch.setBorrowRequestId(rowId);
		criteriaSrch.setStatus("00");
		
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
				semmsa005Bean.setContractAdd(contractNo);
				semmsa005Bean.setCacheContractAdd(contractNo);
				semmsa005Bean.setBorrowSPList(packBorrowContractList(toSrch));
			} else {
				semmsa005Bean.setBorrowSPList(null);
			}
		
		semmsa005Bean.setBorrowRequest(borrow);
		semmsa005Bean.setMode(mode);
		semmsa005Bean.setAddContractNo("");
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		setSemmsa005Bean(semmsa005Bean);
		
		return flag;
	}
	
	private boolean doInitBorrowContract(){
		boolean flgValid = true;
		semmsa005Bean = getSemmsa005Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		String company = (String)getFacesUtils().getRequestParameter("company");
		String sumSite = (String)getFacesUtils().getRequestParameter("siteNum");
		String docNo = (String)getFacesUtils().getRequestParameter("docNo");
		sumSite = (StringUtils.isEmpty(sumSite))? "0": sumSite;
		semmsa005Bean.setSumSite(Integer.parseInt(sumSite));
		semmsa005Bean.setBorrowOfficerList(new ArrayList<SelectItem>());
		Mco003SearchBorrowSP borrow = new Mco003SearchBorrowSP();
		borrow.setCompany(company);
		borrow.setDocNo(docNo);
		semmsa005Bean.setBorrowForList(getLovItemsByType(ELovType.T_CO_BORROW_FOR_TYPE.name));
		semmsa005Bean.setCriteriaBorrow(borrow);
		log.debug(" ##### rowId : "+rowId);
		semmsa005Bean.setInsertBorrowID(rowId);
		semmsa005Bean.setBorrowSPList(null);
		semmsa005Bean.setViewContractNo("");
		semmsa005Bean.setAddPreContractNo("");
		semmsa005Bean.setAddContractNo("");
		semmsa005Bean.setBorrowRequest(new BorrowRequest());
		semmsa005Bean.setBorrowNameList(SelectItemLOVCacheUtil.getInstance().getLovItemsValueNameByType(ELovType.T_SI_SITE_APPROVE_FROM.name));
		semmsa005Bean.setRenderedMsgFormSearch(false);
		
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		semmsa005Bean.setModeReturn(mode);
//		if (mode.equals("VIEW")) {
			doSearchContract();
//		}
		
		setSemmsa005Bean(semmsa005Bean);
		return flgValid;
	}
	
	private boolean validateContract() {
		boolean flgValid = true;
		if(StringUtils.isEmpty(getSemmsa005Bean().getCriteriaBorrow().getCompany())){
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		
		return flgValid;
	}
	
	private boolean doSearchContract(){
		boolean flag = false;
		semmsa005Bean = getSemmsa005Bean();
		semmsa005Bean.setRenderedMsgDataNotFound(false);
		if(!validateContract()){
			return flag;
		}
		
		String contractNo = semmsa005Bean.getViewContractNo();
		SEMMSA005Bean criteria = semmsa005Bean;
		criteria.getCriteriaBorrow().setContractNo(contractNo);
		semmsa005Bean.setBorrowSPList(searchContract(criteria));
		semmsa005Bean.setCacheSrchBorrowList(semmsa005Bean.getBorrowSPList());	// 20110106
		semmsa005Bean.setCacheAddBorrowList(null);
		semmsa005Bean.setCacheContractAdd("");
		this.onRenderExportButton();
		setSemmsa005Bean(semmsa005Bean);
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
	private List<WrapperBeanObject<Mco003SearchBorrowSP>> searchContract(SEMMSA005Bean bean){
		List<Mco003SearchBorrowSP> to = null;
		List<WrapperBeanObject<Mco003SearchBorrowSP>> result = new ArrayList<WrapperBeanObject<Mco003SearchBorrowSP>>();
		try{
			// IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			Mco003SearchBorrowSP criteria = bean.getCriteriaBorrow();
			// P'O do it
			// criteria.setBorrowContractId(bean.getInsertBorrowID());
			criteria.setBorrowRequestId(bean.getInsertBorrowID());
			criteria.setStatus("00");
			semmsa005Bean.setBorrowSPList(new ArrayList());
			
			log.debug("###### criteria.getBorrowRequestId() : "+criteria.getBorrowRequestId());
			to = searchBorrowContract(criteria);
//			if(to == null &&  to.isEmpty()){
//				addMessageError("M0004");
//				semmsa005Bean.setBorrowRequestSPList(null);
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
					if (StringUtils.isEmpty(semmsa005Bean.getViewContractNo())) {
						if (i == 0) {
							strContract = contract.getContractNo();
						} else {
							strContract += "," + contract.getContractNo();
						}
					} else {
						strContract = semmsa005Bean.getViewContractNo();
					}
				}
				semmsa005Bean.setCacheContractSrch(strContract);	// 20110106
			} else {
				semmsa005Bean.setRenderedMsgDataNotFound(true);
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
//		if(!StringUtils.equalsIgnoreCase("EDIT", semmsa005Bean.getMode())){
//		contractNo = contractNo.substring(0, contractNo.length()-1);
//		}
//		semmsa005Bean.setContractAdd(contractNo);
		return resultList;
	}
	
	private void searchContractAfterSave() {
		// re-Search
//		if (StringUtils.isNotEmpty(semmsa005Bean.getCacheContractSrch())) {
//			Mco003SearchBorrowSP criteriaSrch = new Mco003SearchBorrowSP();
//			criteriaSrch.setContractNo(semmsa005Bean.getCacheContractSrch());
//			List<Mco003SearchBorrowSP> toSrch = searchBorrowContract(criteriaSrch);
//			if (toSrch != null && toSrch.size() > 0) {
//				semmsa005Bean.setCacheSrchBorrowList(packBorrowContractList(toSrch));
//			} else {
//				semmsa005Bean.setCacheSrchBorrowList(null);
//			}
//		}
//		Mco003SearchBorrowSP criteriaAdd = new Mco003SearchBorrowSP();
//		criteriaAdd.setContractNo(semmsa005Bean.getCacheContractAdd());
//		List<Mco003SearchBorrowSP> toAdd = searchBorrowContract(criteriaAdd);
//		if (toAdd != null && toAdd.size() > 0) {
//			semmsa005Bean.setCacheAddBorrowList(packBorrowContractList(toAdd));
//		} else {
//			semmsa005Bean.setCacheAddBorrowList(null);
//		}
//		if (semmsa005Bean.getCacheSrchBorrowList() != null) {
//			if (semmsa005Bean.getCacheAddBorrowList() != null) {
//				
//			} else {
//				semmsa005Bean.setBorrowSPList(semmsa005Bean.getCacheSrchBorrowList());
//			}
//		} else {
//			if (semmsa005Bean.getCacheAddBorrowList() != null) {
//				semmsa005Bean.setBorrowSPList(semmsa005Bean.getCacheAddBorrowList());
//			} else {
//				semmsa005Bean.setBorrowSPList(null);
//			}
//		}
		String str = "";
		if (StringUtils.isNotEmpty(semmsa005Bean.getCacheContractSrch())) {
			str = semmsa005Bean.getCacheContractSrch();
			if (StringUtils.isNotEmpty(semmsa005Bean.getCacheContractAdd())) {
				str += "," + semmsa005Bean.getCacheContractAdd();
			}
		} else if (StringUtils.isNotEmpty(semmsa005Bean.getCacheContractAdd())) {
			str = semmsa005Bean.getCacheContractAdd();
		}
		Mco003SearchBorrowSP criteriaSrch = new Mco003SearchBorrowSP();
		criteriaSrch.setCompany(semmsa005Bean.getCriteriaBorrow().getCompany());
		criteriaSrch.setBorrowRequestId(semmsa005Bean.getInsertBorrowID());
		criteriaSrch.setContractNo(str);
		criteriaSrch.setStatus("00");
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
			semmsa005Bean.setBorrowSPList(packBorrowContractList(toSrch2));
		} else {
			semmsa005Bean.setBorrowSPList(null);
		}
	}
	
	private boolean validateContractAdd() {
		boolean flgValid = true;
		if(StringUtils.isEmpty(getSemmsa005Bean().getAddContractNo())){
			addMessageError("W0001", msg("message.contractNo"));
			flgValid = false;
		}
//		if(StringUtils.isEmpty(getSemmsa005Bean().getAddContractNo())){
//			addMessageError("W0001", msg("message.contractNo"));
//			flgValid = false;
//		}
		return flgValid;
	}
	
	//addded by NEW 2015/0710 Search Contract popup
	private boolean doSearchBeforAddContract(){
		boolean flag = false;
		semmsa005Bean = getSemmsa005Bean();
		semmsa005Bean.setRenderedMsgFormTop(false);
		semmsa005Bean.setRenderedMsgDataNotFound(false);
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		IBorrowRequestService borService = (IBorrowRequestService)getBean("borrowRequestService");
		List<Mco003ChkContractSP> chkList = new ArrayList<Mco003ChkContractSP>();
		Mco003ChkContractSP chkContObj = new Mco003ChkContractSP();
		List<Mco003SearchPSI002SP> to = new ArrayList<Mco003SearchPSI002SP>();
		Mco003SearchPSI002SP criteria = new Mco003SearchPSI002SP();
		try{
//			if(semmsa005Bean.getAddContractNo().isEmpty() || semmsa005Bean.getAddContractNo().equals("")){
//				addMessageError("W0001", msg("message.contractNo"));
//				return flag;
//			}
			
			// check duplicate
			Mco003ChkContractSP mco003ChkContractSP = new Mco003ChkContractSP();
			mco003ChkContractSP.setContractNo(semmsa005Bean.getAddContractNo());
			
			
			if(semmsa005Bean.getBorrowRequest().getCompany() != null){
				mco003ChkContractSP.setCompanyCode(semmsa005Bean.getBorrowRequest().getCompany());
			}else{
				mco003ChkContractSP.setCompanyCode(semmsa005Bean.getCriteriaBorrow().getCompany());
				semmsa005Bean.getBorrowRequest().setCompany(semmsa005Bean.getCriteriaBorrow().getCompany());
			}
			
			mco003ChkContractSP.setDocNo(semmsa005Bean.getTmpDocNo());
			mco003ChkContractSP.setChkFlag("N");
			
			criteria.setCompany(semmsa005Bean.getTmpCompany());
			criteria.setContractNo(semmsa005Bean.getAddContractNo());
			
			//added by NEW 2018/12/24
			if(StringUtils.isNotEmpty(semmsa005Bean.getAddSiteName()))criteria.setSiteName(semmsa005Bean.getAddSiteName());
			if(StringUtils.isNotEmpty(semmsa005Bean.getAddLocation()))criteria.setLocation(semmsa005Bean.getAddLocation());
			
//			if(StringUtils.equals("Y", semmsa005Bean.getNewBorrowReq())){
//				chkContObj.setlResult("success");
//				chkList.add(chkContObj);
//			}else{
				chkList = service.querySPList(EQueryName.SP_MCO003_CHK_CONTRACT.name, mco003ChkContractSP);
//			}
			
			
//			if (chkList.contains(null) || chkList == null || chkList.isEmpty() || chkList.size() == 0) {
			if (chkList != null || !chkList.isEmpty() || chkList.size() > 0) {
				if(StringUtils.equalsIgnoreCase("Success", chkList.get(0).getlResult())){
					semmsa005Bean.setRenderedMsgFormTop(true);
//					if(StringUtils.equalsIgnoreCase("W0110", chkList.get(0).getlMessage())){
//						addMessageWarn(chkList.get(0).getlMessage(), chkList.get(0).getlDesc());
//					}else{
//						addMessageWarn(chkList.get(0).getlMessage());
//					}
//					to = service.querySPList(EQueryName.SP_MCO003_SECH_PSI002.name, criteria);
					to = borService.querySPList(EQueryName.SP_MCO003_SECH_CONTRACT.name, criteria);
					log.debug("to = "+to);
					if(to == null || to.isEmpty()) {
//						semmsa005Bean.setRenderedMsgFormTop(true);
//						addMessageError("W0032", semmsa005Bean.getAddContractNo());	
					} else {
						
							// check duplicate
		//					Mco003ChkContractSP mco003ChkContractSP = new Mco003ChkContractSP();
		//					mco003ChkContractSP.setContractNo(semmsa005Bean.getAddContractNo());
		//					mco003ChkContractSP.setCompanyCode(semmsa005Bean.getTmpCompany());
		//					mco003ChkContractSP.setDocNo(semmsa005Bean.getTmpDocNo());
		//					
		//					log.debug("semmsa005Bean.getAddContractNo() = "+semmsa005Bean.getAddContractNo());
		//					log.debug("semmsa005Bean.getTmpCompany() = "+semmsa005Bean.getTmpCompany());
		//					log.debug("semmsa005Bean.getTmpDocNo() = "+semmsa005Bean.getTmpDocNo());
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
//									mco003InsertBorrowSP.setDocNo(semmsa005Bean.getTmpDocNo());
//									mco003InsertBorrowSP.setContractNo(psi002.getContractNo());
//									if(StringUtils.equalsIgnoreCase("EDIT", semmsa005Bean.getMode())){
//										mco003InsertBorrowSP.setMode("EDIT");
//										mco003InsertBorrowSP.setBorrowRequestId(semmsa005Bean.getInsertBorrowID());
//									}else {
//										mco003InsertBorrowSP.setMode("ADD");
//									}
//									mco003InsertBorrowSP.setpOption("D");
//									mco003InsertBorrowSP.setCompany(semmsa005Bean.getTmpCompany());
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
								semmsa005Bean.setContractSPList(resultList);
								semmsa005Bean.setRenderedMsgFormTop(true);
//								addMessageInfo("M0001");
								
								//Contract combination >>> contract 001,contract 002, contract 003 ....
//								String str = semmsa005Bean.getCacheContractAdd();
//								if (StringUtils.isEmpty(str)) {
//									str = semmsa005Bean.getAddContractNo();
//								} else {
//									str += "," + semmsa005Bean.getAddContractNo();
//								}
//								semmsa005Bean.setCacheContractAdd(str);
//								semmsa005Bean.setAddContractNo("");
//			
//								
//								String str2 = "";
		//						if (StringUtils.isNotEmpty(semmsa005Bean.getCacheContractSrch())) {
		//							str2 = semmsa005Bean.getCacheContractSrch();
		//							if (StringUtils.isNotEmpty(semmsa005Bean.getCacheContractAdd())) {
		//								str2 += "," + semmsa005Bean.getCacheContractAdd();
		//							}
		//						} else 
//									if (StringUtils.isNotEmpty(semmsa005Bean.getCacheContractAdd())) {
//									str2 = semmsa005Bean.getCacheContractAdd();
//								}
//								semmsa005Bean.setContractAdd(str2);
		
								
//								Mco003SearchBorrowSP criteriaSrch = new Mco003SearchBorrowSP();
//								criteriaSrch.setCompany(semmsa005Bean.getTmpCompany());
//								criteriaSrch.setBorrowRequestId(semmsa005Bean.getInsertBorrowID());
//								List<Mco003SearchBorrowSP> toSrch = searchBorrowContract(criteriaSrch);
//								if (toSrch != null && toSrch.size() > 0) {
//									semmsa005Bean.setBorrowSPList(packBorrowContractList(toSrch));
//								} else {
//									semmsa005Bean.setBorrowSPList(null);
//								}
//							} else {
//								semmsa005Bean.setRenderedMsgFormTop(true);
//								log.debug("chkList.get(0).getlMessage() = "+chkList.get(0).getlMessage());
//								log.debug("semmsa005Bean.getAddContractNo() = "+semmsa005Bean.getAddContractNo());
//								log.debug("semmsa005Bean.getBorrowRequest().getCompany() = "+semmsa005Bean.getBorrowRequest().getCompany());
//								if(StringUtils.equalsIgnoreCase("W0108", chkList.get(0).getlMessage())){
//									addMessageErrorWithArgument(chkList.get(0).getlMessage(), semmsa005Bean.getAddContractNo(),semmsa005Bean.getBorrowRequest().getCompany());
//								}else{
//									addMessageError(chkList.get(0).getlMessage());
//								}
//								semmsa005Bean.setAddContractNo("");
//							}
					}
				}else{
					addMessageErrorWithArgument(chkList.get(0).getlMessage(), semmsa005Bean.getAddContractNo(),semmsa005Bean.getBorrowRequest().getCompany());
				}
			}
		}catch (Exception e) {
			addMessageError("E0001");
			e.printStackTrace();
			log.error("error from SEMMCO003Action doSearchBeforAddContract");
			log.error(e);
			// TODO: handle exception
		}finally{
			semmsa005Bean.setDisabledBtnAdd(true);
			setSemmsa005Bean(semmsa005Bean);
		}
		return flag;
	}

	@SuppressWarnings("unchecked")
	private boolean doAddContract(){
		boolean flag = false;
		semmsa005Bean = getSemmsa005Bean();
		semmsa005Bean.setRenderedMsgFormTop(false);
		semmsa005Bean.setRenderedMsgDataNotFound(false);
//		if(!validateContractAdd()){
//			semmsa005Bean.setRenderedMsgFormTop(true);
//			setSemmsa005Bean(semmsa005Bean);
//			return flag;
//		}
		
		if(!StringUtils.equalsIgnoreCase("EDIT", semmsa005Bean.getMode())&&!semmsa005Bean.isOnePopupFlag()){
			semmsa005Bean.setInsertBorrowID(semmsa005Bean.getBorrowRequest().getDocNo());
			semmsa005Bean.setSumSite(semmsa005Bean.getBorrowRequest().getSiteNum().intValue());
		}else if(StringUtils.equalsIgnoreCase("EDIT", semmsa005Bean.getMode())&&!semmsa005Bean.isOnePopupFlag()){
			semmsa005Bean.setSumSite(semmsa005Bean.getBorrowRequest().getSiteNum().intValue());
		}
		// 20110214
		// check full site
		if(semmsa005Bean.isOnePopupFlag()){
			semmsa005Bean.setTmpCompany(semmsa005Bean.getCriteriaBorrow().getCompany());
			semmsa005Bean.setTmpDocNo(semmsa005Bean.getCriteriaBorrow().getDocNo());
		}else{
			semmsa005Bean.setTmpCompany(semmsa005Bean.getBorrowRequest().getCompany());
			semmsa005Bean.setTmpDocNo(semmsa005Bean.getBorrowRequest().getDocNo());
		}
		
		Mco003SearchBorrowSP chkSite = new Mco003SearchBorrowSP();
		chkSite.setBorrowRequestId(semmsa005Bean.getInsertBorrowID());
		chkSite.setCompany(semmsa005Bean.getTmpCompany());
		chkSite.setStatus("00");
		List<Mco003SearchBorrowSP> chkSiteList = searchBorrowContract(chkSite);

		if (chkSiteList != null && chkSiteList.size() != 0) {
			if (chkSiteList.size() == semmsa005Bean.getSumSite().intValue()) {
				semmsa005Bean.setRenderedMsgFormTop(true);
				addMessageError("W0071");
				semmsa005Bean.setAddContractNo("");
				setSemmsa005Bean(semmsa005Bean);
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
			
//			String contractNo = (StringUtils.isNotEmpty(semmsa005Bean.getAddPreContractNo())?semmsa005Bean.getAddPreContractNo().trim()+" ":"")
//			+ (StringUtils.isNotEmpty(semmsa005Bean.getAddContractNo())?semmsa005Bean.getAddContractNo().trim():"");
//			criteria.setCompany(semmsa005Bean.getTmpCompany());
//			criteria.setContractNo(semmsa005Bean.getAddContractNo());
			
			//edit by NEW 2015/07/10 
			List<WrapperBeanObject<Mco003SearchPSI002SP>> borrowContractList = getSemmsa005Bean().getContractSPList();
			for (WrapperBeanObject<Mco003SearchPSI002SP> wrapperBeanObject : borrowContractList) {
				borrowContractSP = (Mco003SearchPSI002SP) wrapperBeanObject.getDataObj();
				if (wrapperBeanObject.isCheckBox()) {
					
					criteria.setCompany(semmsa005Bean.getTmpCompany());
					criteria.setContractNo(borrowContractSP.getContractNo());
					
					
					// check duplicate
					Mco003ChkContractSP mco003ChkContractSP = new Mco003ChkContractSP();
					mco003ChkContractSP.setContractNo(borrowContractSP.getContractNo());
					if(semmsa005Bean.getBorrowRequest().getCompany()!=null){
						mco003ChkContractSP.setCompanyCode(semmsa005Bean.getBorrowRequest().getCompany());
					}else{
						mco003ChkContractSP.setCompanyCode(semmsa005Bean.getCriteriaBorrow().getCompany());
					}
					
					mco003ChkContractSP.setDocNo(semmsa005Bean.getTmpDocNo());
					//edit by NEW 2015/07/10
					mco003ChkContractSP.setChkFlag("Y");
					mco003ChkContractSP.setSiteInfoId(borrowContractSP.getRowId());
					
					chkList = service.querySPList(EQueryName.SP_MCO003_CHK_CONTRACT.name, mco003ChkContractSP);
//					if (chkList.contains(null) || chkList == null || chkList.isEmpty() || chkList.size() == 0) {
					if (chkList != null || !chkList.isEmpty() || chkList.size() > 0) {
						if(StringUtils.equalsIgnoreCase("Success", chkList.get(0).getlResult())){
							semmsa005Bean.setRenderedMsgFormTop(true);
//							if(StringUtils.equalsIgnoreCase("W0110", chkList.get(0).getlMessage())){
//								addMessageWarn(chkList.get(0).getlMessage(), chkList.get(0).getlDesc());
//							}else{
//								addMessageWarn(chkList.get(0).getlMessage());
//							}
//							to = service.querySPList(EQueryName.SP_MCO003_SECH_PSI002.name, criteria);
//							log.debug("to = "+to);
//							if(to == null || to.isEmpty()) {
////								semmsa005Bean.setRenderedMsgFormTop(true);
////								addMessageError("W0032", semmsa005Bean.getAddContractNo());	
//							} else {
								
									// check duplicate
				//					Mco003ChkContractSP mco003ChkContractSP = new Mco003ChkContractSP();
				//					mco003ChkContractSP.setContractNo(semmsa005Bean.getAddContractNo());
				//					mco003ChkContractSP.setCompanyCode(semmsa005Bean.getTmpCompany());
				//					mco003ChkContractSP.setDocNo(semmsa005Bean.getTmpDocNo());
				//					
				//					log.debug("semmsa005Bean.getAddContractNo() = "+semmsa005Bean.getAddContractNo());
				//					log.debug("semmsa005Bean.getTmpCompany() = "+semmsa005Bean.getTmpCompany());
				//					log.debug("semmsa005Bean.getTmpDocNo() = "+semmsa005Bean.getTmpDocNo());
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
//											mco003InsertBorrowSP.setDocNo(semmsa005Bean.getTmpDocNo());
//											mco003InsertBorrowSP.setContractNo(psi002.getContractNo());
//											if(StringUtils.equalsIgnoreCase("EDIT", semmsa005Bean.getMode())){
//												mco003InsertBorrowSP.setMode("EDIT");
//												mco003InsertBorrowSP.setBorrowRequestId(semmsa005Bean.getInsertBorrowID());
//											}else {
//												mco003InsertBorrowSP.setMode("ADD");
//											}
//											mco003InsertBorrowSP.setpOption("D");
//											mco003InsertBorrowSP.setCompany(semmsa005Bean.getTmpCompany());
//											mco003InsertBorrowSP.setUser(getUserLogIn());
//											resultList = borService.querySPList(EQueryName.SP_MCO003_INSERT.name, mco003InsertBorrowSP);
//										}
										Mco003InsertBorrowSP mco003InsertBorrowSP = new Mco003InsertBorrowSP();
										mco003InsertBorrowSP.setDocNo(semmsa005Bean.getTmpDocNo());
										mco003InsertBorrowSP.setContractNo(borrowContractSP.getContractNo());
										mco003InsertBorrowSP.setCompany(mco003ChkContractSP.getCompanyCode());
										if(StringUtils.equalsIgnoreCase("EDIT", semmsa005Bean.getMode())){
											mco003InsertBorrowSP.setMode("EDIT");
											mco003InsertBorrowSP.setBorrowRequestId(semmsa005Bean.getInsertBorrowID());
										}else {
											mco003InsertBorrowSP.setMode("ADD");
										}
										mco003InsertBorrowSP.setpOption("D");
//										mco003InsertBorrowSP.setCompany(borrowContractSP.getCompany());
										mco003InsertBorrowSP.setUser(getUserLogIn());
										mco003InsertBorrowSP.setSiteInfoId(borrowContractSP.getRowId());
										mco003InsertBorrowSP.setStatus("00");
										resultList = borService.querySPList(EQueryName.SP_MCO003_INSERT_NEW.name, mco003InsertBorrowSP);
										
//										resultList = borService.querySPList(EQueryName.SP_MCO003_INSERT.name, mco003InsertBorrowSP);
										// successful save borrow contract
										semmsa005Bean.setRenderedMsgFormTop(true);
//										addMessageInfo("M0001");
										
										//Contract combination >>> contract 001,contract 002, contract 003 ....
										String str = semmsa005Bean.getCacheContractAdd();
										if (StringUtils.isEmpty(str)) {
											str = semmsa005Bean.getAddContractNo();
										} else {
											str += "," + semmsa005Bean.getAddContractNo();
										}
										semmsa005Bean.setCacheContractAdd(str);
										semmsa005Bean.setAddContractNo("");
					
										
										String str2 = "";
				//						if (StringUtils.isNotEmpty(semmsa005Bean.getCacheContractSrch())) {
				//							str2 = semmsa005Bean.getCacheContractSrch();
				//							if (StringUtils.isNotEmpty(semmsa005Bean.getCacheContractAdd())) {
				//								str2 += "," + semmsa005Bean.getCacheContractAdd();
				//							}
				//						} else 
											if (StringUtils.isNotEmpty(semmsa005Bean.getCacheContractAdd())) {
											str2 = semmsa005Bean.getCacheContractAdd();
										}
										semmsa005Bean.setContractAdd(str2);
				
										
										Mco003SearchBorrowSP criteriaSrch = new Mco003SearchBorrowSP();
										criteriaSrch.setCompany(semmsa005Bean.getTmpCompany());
										criteriaSrch.setBorrowRequestId(semmsa005Bean.getInsertBorrowID());
										criteriaSrch.setStatus("00");
										List<Mco003SearchBorrowSP> toSrch = searchBorrowContract(criteriaSrch);
										if (toSrch != null && toSrch.size() > 0) {
											semmsa005Bean.setBorrowSPList(packBorrowContractList(toSrch));
										} else {
											semmsa005Bean.setBorrowSPList(null);
										}
//									} else {
//										semmsa005Bean.setRenderedMsgFormTop(true);
//										log.debug("chkList.get(0).getlMessage() = "+chkList.get(0).getlMessage());
//										log.debug("semmsa005Bean.getAddContractNo() = "+semmsa005Bean.getAddContractNo());
//										log.debug("semmsa005Bean.getBorrowRequest().getCompany() = "+semmsa005Bean.getBorrowRequest().getCompany());
//										if(StringUtils.equalsIgnoreCase("W0108", chkList.get(0).getlMessage())){
//											addMessageErrorWithArgument(chkList.get(0).getlMessage(), semmsa005Bean.getAddContractNo(),semmsa005Bean.getBorrowRequest().getCompany());
//										}else{
//											addMessageError(chkList.get(0).getlMessage());
//										}
//										semmsa005Bean.setAddContractNo("");
//									}
//							}
						}else{
							semmsa005Bean.setRenderedMsgFormTop(true);
//							log.debug("chkList.get(0).getlMessage() = "+chkList.get(0).getlMessage());
//							log.debug("semmsa005Bean.getAddContractNo() = "+semmsa005Bean.getAddContractNo());
//							log.debug("semmsa005Bean.getBorrowRequest().getCompany() = "+semmsa005Bean.getBorrowRequest().getCompany());
							if(StringUtils.equalsIgnoreCase("W0108", chkList.get(0).getlMessage())){
								addMessageErrorWithArgument(chkList.get(0).getlMessage(), semmsa005Bean.getAddContractNo(),semmsa005Bean.getTmpCompany());
							}else if(StringUtils.equalsIgnoreCase("W0110", chkList.get(0).getlMessage())){
								addMessageErrorWithArgument(chkList.get(0).getlMessage(), chkList.get(0).getlDesc());
							}else{
								addMessageError(chkList.get(0).getlMessage());
							}
//							semmsa005Bean.setAddContractNo("");
						}
						
					} else {
						semmsa005Bean.setRenderedMsgFormTop(true);
//						log.debug("chkList.get(0).getlMessage() = "+chkList.get(0).getlMessage());
//						log.debug("semmsa005Bean.getAddContractNo() = "+semmsa005Bean.getAddContractNo());
//						log.debug("semmsa005Bean.getBorrowRequest().getCompany() = "+semmsa005Bean.getBorrowRequest().getCompany());
						if(StringUtils.equalsIgnoreCase("W0108", chkList.get(0).getlMessage())){
							addMessageErrorWithArgument(chkList.get(0).getlMessage(), semmsa005Bean.getAddContractNo(),semmsa005Bean.getTmpCompany());
						}else if(StringUtils.equalsIgnoreCase("W0110", chkList.get(0).getlMessage())){
							addMessageErrorWithArgument(chkList.get(0).getlMessage(), chkList.get(0).getlDesc());
						}else{
							addMessageError(chkList.get(0).getlMessage());
						}
//						semmsa005Bean.setAddContractNo("");
					}
				}
			}
			
			//search borrow contract
			if(resultList != null && resultList.size() > 0){
				to = borService.querySPList(EQueryName.SP_MCO003_SECH_CONTRACT.name, criteria);
				
				List<WrapperBeanObject<Mco003SearchPSI002SP>> borrowList = new ArrayList<WrapperBeanObject<Mco003SearchPSI002SP>>();
				if(to != null && to.size() > 0){
					semmsa005Bean.setRenderedMsgDataNotFound(false);
					for(Mco003SearchPSI002SP psi002 : to){
//						Mco003InsertBorrowSP mco003InsertBorrowSP = new Mco003InsertBorrowSP();
//						mco003InsertBorrowSP.setDocNo(semmsa005Bean.getTmpDocNo());
//						mco003InsertBorrowSP.setContractNo(psi002.getContractNo());
//						if(StringUtils.equalsIgnoreCase("EDIT", semmsa005Bean.getMode())){
//							mco003InsertBorrowSP.setMode("EDIT");
//							mco003InsertBorrowSP.setBorrowRequestId(semmsa005Bean.getInsertBorrowID());
//						}else {
//							mco003InsertBorrowSP.setMode("ADD");
//						}
//						mco003InsertBorrowSP.setpOption("D");
//						mco003InsertBorrowSP.setCompany(semmsa005Bean.getTmpCompany());
//						mco003InsertBorrowSP.setUser(getUserLogIn());
//						resultList = borService.querySPList(EQueryName.SP_MCO003_INSERT.name, mco003InsertBorrowSP);
						
						WrapperBeanObject<Mco003SearchPSI002SP> tmpWrapperBean = new WrapperBeanObject<Mco003SearchPSI002SP>();
						
						tmpWrapperBean.setDataObj(psi002);
						tmpWrapperBean.setMessage("");
						tmpWrapperBean.setCheckBox(false);
						borrowList.add(tmpWrapperBean);
					}
					// successful save borrow contract
					semmsa005Bean.setContractSPList(borrowList);
				}
				
			}
			//COMMENT BY NEW 20150710 MOVE CODE TO LOOP FOR
//			// check duplicate
//			Mco003ChkContractSP mco003ChkContractSP = new Mco003ChkContractSP();
//			mco003ChkContractSP.setContractNo(semmsa005Bean.getAddContractNo());
//			mco003ChkContractSP.setCompanyCode(semmsa005Bean.getTmpCompany());
//			mco003ChkContractSP.setDocNo(semmsa005Bean.getTmpDocNo());
//			
//			
//			chkList = service.querySPList(EQueryName.SP_MCO003_CHK_CONTRACT.name, mco003ChkContractSP);
////			if (chkList.contains(null) || chkList == null || chkList.isEmpty() || chkList.size() == 0) {
//			if (chkList != null || !chkList.isEmpty() || chkList.size() > 0) {
//				if(StringUtils.equalsIgnoreCase("Success", chkList.get(0).getlResult())){
//					semmsa005Bean.setRenderedMsgFormTop(true);
//					if(StringUtils.equalsIgnoreCase("W0110", chkList.get(0).getlMessage())){
//						addMessageWarn(chkList.get(0).getlMessage(), chkList.get(0).getlDesc());
//					}else{
//						addMessageWarn(chkList.get(0).getlMessage());
//					}
//					to = service.querySPList(EQueryName.SP_MCO003_SECH_PSI002.name, criteria);
//					log.debug("to = "+to);
//					if(to == null || to.isEmpty()) {
////						semmsa005Bean.setRenderedMsgFormTop(true);
////						addMessageError("W0032", semmsa005Bean.getAddContractNo());	
//					} else {
//						
//							// check duplicate
//		//					Mco003ChkContractSP mco003ChkContractSP = new Mco003ChkContractSP();
//		//					mco003ChkContractSP.setContractNo(semmsa005Bean.getAddContractNo());
//		//					mco003ChkContractSP.setCompanyCode(semmsa005Bean.getTmpCompany());
//		//					mco003ChkContractSP.setDocNo(semmsa005Bean.getTmpDocNo());
//		//					
//		//					log.debug("semmsa005Bean.getAddContractNo() = "+semmsa005Bean.getAddContractNo());
//		//					log.debug("semmsa005Bean.getTmpCompany() = "+semmsa005Bean.getTmpCompany());
//		//					log.debug("semmsa005Bean.getTmpDocNo() = "+semmsa005Bean.getTmpDocNo());
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
//									mco003InsertBorrowSP.setDocNo(semmsa005Bean.getTmpDocNo());
//									mco003InsertBorrowSP.setContractNo(psi002.getContractNo());
//									if(StringUtils.equalsIgnoreCase("EDIT", semmsa005Bean.getMode())){
//										mco003InsertBorrowSP.setMode("EDIT");
//										mco003InsertBorrowSP.setBorrowRequestId(semmsa005Bean.getInsertBorrowID());
//									}else {
//										mco003InsertBorrowSP.setMode("ADD");
//									}
//									mco003InsertBorrowSP.setpOption("D");
//									mco003InsertBorrowSP.setCompany(semmsa005Bean.getTmpCompany());
//									mco003InsertBorrowSP.setUser(getUserLogIn());
//									resultList = borService.querySPList(EQueryName.SP_MCO003_INSERT.name, mco003InsertBorrowSP);
//								}
//								// successful save borrow contract
//								semmsa005Bean.setRenderedMsgFormTop(true);
////								addMessageInfo("M0001");
//								
//								//Contract combination >>> contract 001,contract 002, contract 003 ....
//								String str = semmsa005Bean.getCacheContractAdd();
//								if (StringUtils.isEmpty(str)) {
//									str = semmsa005Bean.getAddContractNo();
//								} else {
//									str += "," + semmsa005Bean.getAddContractNo();
//								}
//								semmsa005Bean.setCacheContractAdd(str);
//								semmsa005Bean.setAddContractNo("");
//			
//								
//								String str2 = "";
//		//						if (StringUtils.isNotEmpty(semmsa005Bean.getCacheContractSrch())) {
//		//							str2 = semmsa005Bean.getCacheContractSrch();
//		//							if (StringUtils.isNotEmpty(semmsa005Bean.getCacheContractAdd())) {
//		//								str2 += "," + semmsa005Bean.getCacheContractAdd();
//		//							}
//		//						} else 
//									if (StringUtils.isNotEmpty(semmsa005Bean.getCacheContractAdd())) {
//									str2 = semmsa005Bean.getCacheContractAdd();
//								}
//								semmsa005Bean.setContractAdd(str2);
//		
//								
//								Mco003SearchBorrowSP criteriaSrch = new Mco003SearchBorrowSP();
//								criteriaSrch.setCompany(semmsa005Bean.getTmpCompany());
//								criteriaSrch.setBorrowRequestId(semmsa005Bean.getInsertBorrowID());
//								List<Mco003SearchBorrowSP> toSrch = searchBorrowContract(criteriaSrch);
//								if (toSrch != null && toSrch.size() > 0) {
//									semmsa005Bean.setBorrowSPList(packBorrowContractList(toSrch));
//								} else {
//									semmsa005Bean.setBorrowSPList(null);
//								}
////							} else {
////								semmsa005Bean.setRenderedMsgFormTop(true);
////								log.debug("chkList.get(0).getlMessage() = "+chkList.get(0).getlMessage());
////								log.debug("semmsa005Bean.getAddContractNo() = "+semmsa005Bean.getAddContractNo());
////								log.debug("semmsa005Bean.getBorrowRequest().getCompany() = "+semmsa005Bean.getBorrowRequest().getCompany());
////								if(StringUtils.equalsIgnoreCase("W0108", chkList.get(0).getlMessage())){
////									addMessageErrorWithArgument(chkList.get(0).getlMessage(), semmsa005Bean.getAddContractNo(),semmsa005Bean.getBorrowRequest().getCompany());
////								}else{
////									addMessageError(chkList.get(0).getlMessage());
////								}
////								semmsa005Bean.setAddContractNo("");
////							}
//					}
//				}else{
//					semmsa005Bean.setRenderedMsgFormTop(true);
////					log.debug("chkList.get(0).getlMessage() = "+chkList.get(0).getlMessage());
////					log.debug("semmsa005Bean.getAddContractNo() = "+semmsa005Bean.getAddContractNo());
////					log.debug("semmsa005Bean.getBorrowRequest().getCompany() = "+semmsa005Bean.getBorrowRequest().getCompany());
//					if(StringUtils.equalsIgnoreCase("W0108", chkList.get(0).getlMessage())){
//						addMessageErrorWithArgument(chkList.get(0).getlMessage(), semmsa005Bean.getAddContractNo(),semmsa005Bean.getTmpCompany());
//					}else if(StringUtils.equalsIgnoreCase("W0110", chkList.get(0).getlMessage())){
//						addMessageErrorWithArgument(chkList.get(0).getlMessage(), chkList.get(0).getlDesc());
//					}else{
//						addMessageError(chkList.get(0).getlMessage());
//					}
//					semmsa005Bean.setAddContractNo("");
//				}
//				
//			} else {
//				semmsa005Bean.setRenderedMsgFormTop(true);
////				log.debug("chkList.get(0).getlMessage() = "+chkList.get(0).getlMessage());
////				log.debug("semmsa005Bean.getAddContractNo() = "+semmsa005Bean.getAddContractNo());
////				log.debug("semmsa005Bean.getBorrowRequest().getCompany() = "+semmsa005Bean.getBorrowRequest().getCompany());
//				if(StringUtils.equalsIgnoreCase("W0108", chkList.get(0).getlMessage())){
//					addMessageErrorWithArgument(chkList.get(0).getlMessage(), semmsa005Bean.getAddContractNo(),semmsa005Bean.getTmpCompany());
//				}else if(StringUtils.equalsIgnoreCase("W0110", chkList.get(0).getlMessage())){
//					addMessageErrorWithArgument(chkList.get(0).getlMessage(), chkList.get(0).getlDesc());
//				}else{
//					addMessageError(chkList.get(0).getlMessage());
//				}
//				semmsa005Bean.setAddContractNo("");
//			}
		} catch (Exception e){
			e.printStackTrace();
			addMessageError("E0001");
		}
		semmsa005Bean.setDisabledBtnAdd(true);
		setSemmsa005Bean(semmsa005Bean);
		return flag;
	}
	
	@SuppressWarnings("unchecked")
	private boolean initBorrowContract(){
		boolean flag = true;
		semmsa005Bean = getSemmsa005Bean();
		semmsa005Bean.setPopupBorrowOpen(true);
		semmsa005Bean.setPopupAlert(false);
		semmsa005Bean.setBorrowContract(new BorrowContract());
		String popup = (String)getFacesUtils().getRequestParameter("popup");
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		String effDtStr = (String)getFacesUtils().getRequestParameter("effDt");
		String expDtStr = (String)getFacesUtils().getRequestParameter("expDt");
		semmsa005Bean.setBtnBorrowPopup(popup);
		semmsa005Bean.setMode(mode);
		semmsa005Bean.setOtherBorrowName("");
		semmsa005Bean.setEffDtStr(effDtStr);
		semmsa005Bean.setExpDtStr(expDtStr);
		
		if (mode.equals("EDIT") || mode.equals("VIEW")) {
			
			IBorrowRequestService borService = (IBorrowRequestService)getBean("borrowRequestService");
			String rowId = (String)getFacesUtils().getRequestParameter("rowId");
			semmsa005Bean.setBorrowContract(borService.queryBorrowContractByRowId(rowId));
			// 20101213
			if (StringUtils.isEmpty(semmsa005Bean.getBorrowContract().getBorrowForType())){
				semmsa005Bean.getBorrowContract().setBorrowForType("00");
			}
//			semmsa005Bean.setBorrowForList(getLovItemsByType(ELovType.T_CO_BORROW_FOR_TYPE.name));
			
			String docApproveFlag = semmsa005Bean.getBorrowContract().getDocApproveFlag();
			String docContractFlag = semmsa005Bean.getBorrowContract().getDocContractFlag();
			String docOtherFlag = semmsa005Bean.getBorrowContract().getDocOtherFlag();
			String cannotBorrowFlag = semmsa005Bean.getBorrowContract().getCannotBorrowFlag();
			if (docApproveFlag != null && docApproveFlag.equals("Y"))
				semmsa005Bean.getBorrowContract().setDocApproveFlag("TRUE");
			if (docContractFlag != null && docContractFlag.equals("Y"))
				semmsa005Bean.getBorrowContract().setDocContractFlag("TRUE");
			if (docOtherFlag != null && docOtherFlag.equals("Y"))
				semmsa005Bean.getBorrowContract().setDocOtherFlag("TRUE");
			if (cannotBorrowFlag != null && cannotBorrowFlag.equals("Y"))
				semmsa005Bean.getBorrowContract().setCannotBorrowFlag("TRUE");
			
			if (mode.equals("EDIT")) {
				if (semmsa005Bean.getBorrowContract().getBorrowDt() == null) {
					semmsa005Bean.getBorrowContract().setBorrowDt(new Date());
					semmsa005Bean.getBorrowContract().setDocApproveFlag("TRUE");
					semmsa005Bean.getBorrowContract().setDocContractFlag("TRUE");
				}
			}
			
			boolean flg = false;
			if (semmsa005Bean.getBorrowContract() != null) {
				if (semmsa005Bean.getBorrowContract().getBorrowName() != null) {
					for (SelectItem o: semmsa005Bean.getBorrowNameList()) {
						if (semmsa005Bean.getBorrowContract().getBorrowName().equals(o.getLabel())) {
							flg = true;
							break;
						}
					}
				}
			}
			if (flg) {
				semmsa005Bean.setDisTxtBorrowName(false);
			} else {
				semmsa005Bean.setDisTxtBorrowName(true);
				semmsa005Bean.setOtherBorrowName(semmsa005Bean.getBorrowContract().getBorrowName());
			}
			
		} else {
			
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			semmsa005Bean.setBorrowContract(new BorrowContract());
			semmsa005Bean.getBorrowContract().setBorrowForType("01");
			semmsa005Bean.getBorrowContract().setBorrowDt(new Date());
			semmsa005Bean.getBorrowContract().setDocApproveFlag("TRUE");
			semmsa005Bean.getBorrowContract().setDocContractFlag("TRUE");
			
			String tmpContractId = "";
			List<WrapperBeanObject<Mco003SearchBorrowSP>> bgMaster = getSemmsa005Bean().getBorrowSPList();
			for (WrapperBeanObject<Mco003SearchBorrowSP> wrapperBeanObject : bgMaster) {
				if(wrapperBeanObject.isCheckBox()){
					Mco003SearchBorrowSP tmp = (Mco003SearchBorrowSP)wrapperBeanObject.getDataObj();
					tmpContractId += (tmpContractId.equals(""))? tmp.getBorrowContractId(): "," + tmp.getBorrowContractId();
				}
			}
			semmsa005Bean.setBorrowContractIdList(tmpContractId);
			Mco003ChkBorrow mco003ChkBorrow = new Mco003ChkBorrow();
			mco003ChkBorrow.setBorrowContractId(tmpContractId);
			try {
				List<Mco003ChkBorrow> list = service.querySPList(EQueryName.SP_MCO003_CHK_BORROW.name, mco003ChkBorrow);
				if (list != null && list.size() > 0) {
					if (null != list.get(0) && StringUtils.isNotEmpty(list.get(0).getContractNo())) {
						semmsa005Bean.setPopupBorrowOpen(false);
						semmsa005Bean.setPopupAlert(true);
						semmsa005Bean.setContentAlert(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("Q0014"), list.get(0).getContractNo()));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		List<SelectItem> itemList = getLovItemsByType(ELovType.T_CO_BORROW_OFFICER.name);
		if(itemList!=null){
			semmsa005Bean.setBorrowOfficerList(itemList);
		} else {
			semmsa005Bean.setBorrowOfficerList(new ArrayList<SelectItem>());
		}
		
		setSemmsa005Bean(semmsa005Bean);
		return flag;
	}
	
	@SuppressWarnings("unchecked")
	private boolean doSaveContractDetail(){
		boolean flag = true;
		semmsa005Bean = getSemmsa005Bean();
		if(!validateContractDetail()){
			semmsa005Bean.setRenderedMsgFormTop(true);
			semmsa005Bean.setPopupClose(false);
			setSemmsa005Bean(semmsa005Bean);
			return flag;
		}
		try{
			log.debug("officer = "+semmsa005Bean.getBorrowContract().getBorrowOfficer());
			BorrowContract contract = semmsa005Bean.getBorrowContract();
			contract.setDocApproveFlag((contract.getDocApproveFlag().equals("true"))?"Y":"");
			contract.setDocContractFlag((contract.getDocContractFlag().equals("true"))?"Y":"");
			if(contract.getDocOtherFlag() != null)contract.setDocOtherFlag((contract.getDocOtherFlag().equals("true"))?"Y":"");
			if(contract.getCannotBorrowFlag() != null)contract.setCannotBorrowFlag((contract.getCannotBorrowFlag().equals("true"))?"Y":"");
			
			
//			if(StringUtils.equalsIgnoreCase("Y", contract.getDocContractFlag())&& StringUtils.isEmpty(contract.getDocContractDetail())){
//				contract.setDocContractDetail(SEMDataUtility.toStringThaiDateSimpleFormat(contract.getBorrowDt()));
//			}
//			if(StringUtils.equalsIgnoreCase("Y", contract.getDocOtherFlag())&& StringUtils.isEmpty(contract.getRemarkDocOther())){
//				contract.setRemarkDocOther(SEMDataUtility.toStringThaiDateSimpleFormat(contract.getBorrowDt()));
//			}
			if(StringUtils.isEmpty(contract.getDocContractDetail())){
				contract.setDocContractDetail(semmsa005Bean.getEffDtStr()+" - "+semmsa005Bean.getExpDtStr());
			}
			if (StringUtils.isEmpty(contract.getBorrowName())) {
				contract.setBorrowName(semmsa005Bean.getOtherBorrowName());
			}
			
//			if(semmsa005Bean.getMode().equals("EDIT")){
//				IBorrowRequestService borService = (IBorrowRequestService)getBean("borrowRequestService");
//				borService.updateBorrowContract(contract);
//			} else {
				IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
				
				Mco003SaveBorrow mco003SaveBorrow = new Mco003SaveBorrow();
				if(semmsa005Bean.getMode().equals("EDIT")){
					mco003SaveBorrow.setBorrowContractId(contract.getRowId());
				}else{
					mco003SaveBorrow.setBorrowContractId(semmsa005Bean.getBorrowContractIdList());	
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
				mco003SaveBorrow.setStatus("00");
				
				List<Mco003SaveBorrow> resultList = service.querySPList(EQueryName.SP_MCO003_SAVE_BORROW.name, mco003SaveBorrow);
				if (StringUtils.equalsIgnoreCase("Success", resultList.get(0).getResult())) {
					semmsa005Bean.setPopupClose(true);
					addMessageInfo("M0001");
					this.onRenderExportButton();
				}else{
					semmsa005Bean.setPopupClose(false);
					addMessageError(resultList.get(0).getMessage());
				}
//			}
			
			
			
		}catch(Exception e){
			e.printStackTrace();
			semmsa005Bean.setPopupClose(false);
			addMessageError("E0001");
		}
		setSemmsa005Bean(semmsa005Bean);
		flag = doSearchContract();
		return flag;
	}
	
	private boolean validateContractDetail() {
		boolean flgValid = true;
		if(StringUtils.isEmpty(getSemmsa005Bean().getBorrowContract().getBorrowName())){
			if (StringUtils.isEmpty(getSemmsa005Bean().getOtherBorrowName())) {
				addMessageError("W0001", msg("message.borrowName"));
				flgValid = false;
			}
			
		}
		
		if (getSemmsa005Bean().getBorrowContract().getBorrowDt() == null) {
			addMessageError("W0001", msg("message.borrowDt"));
			flgValid = false;
		}
		
//		if (StringUtils.isEmpty(getSemmsa005Bean().getBorrowContract().getBorrowOfficer())) {
//			addMessageError("W0001", msg("message.borrowOfficer"));
//			flgValid = false;
//		}
		
		if ("true".equals(getSemmsa005Bean().getBorrowContract().getCannotBorrowFlag())) {
			if (StringUtils.isEmpty(getSemmsa005Bean().getBorrowContract().getRemarkCannotBorrow())) {
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
			semmsa005Bean.setMode("ADD");
		} else {
			returnCtx = borService.queryReturnContractByRowId(returnID);
			returnCtx.setReturnNotAllFlag((returnCtx.getReturnNotAllFlag() != null)? "TRUE": "FALSE");
			returnCtx.setDocApproveFlag((returnCtx.getDocApproveFlag() != null)? "TRUE": "FALSE");
			returnCtx.setDocContractFlag((returnCtx.getDocContractFlag() != null)? "TRUE": "FALSE");
			returnCtx.setDocOtherFlag((returnCtx.getDocOtherFlag() != null)? "TRUE": "FALSE");
			returnCtx.setDocOtherAddFlag((returnCtx.getDocOtherAddFlag() != null)? "TRUE": "FALSE");
			semmsa005Bean.setMode(mode);
		}
		
		return returnCtx;
	}
	
	@SuppressWarnings("unchecked")
	private boolean doinitReturnContract(){
		boolean flag = true;
		semmsa005Bean = getSemmsa005Bean();
		semmsa005Bean.setPopupBorrowOpen(true);
		semmsa005Bean.setPopupAlert(false);
		semmsa005Bean.setOtherReturnName("");
		
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
		
		semmsa005Bean.setSiteAppObjParam(new SiteAppSP());
		semmsa005Bean.getSiteAppObjParam().setSiteAppId(siteAppId);
		semmsa005Bean.getSiteAppObjParam().setDocApproveId(docApproveId);
		if(!placeType.isEmpty())
			semmsa005Bean.getSiteAppObjParam().setPlaceType(placeType);
		else
			semmsa005Bean.getSiteAppObjParam().setPlaceType("");
		semmsa005Bean.getSiteAppObjParam().setPlaceTypeRemark(placeTypeRemark);
		if(!partiesType.isEmpty())
			semmsa005Bean.getSiteAppObjParam().setPartiesType(partiesType);
		else
			semmsa005Bean.getSiteAppObjParam().setPartiesType("");
		semmsa005Bean.getSiteAppObjParam().setPartiesTypeRemark(partiesTypeRemark);
		
		semmsa005Bean.setLegalPlaceTypeList(getLovItemsByType(ELovType.T_SI_LEGAL_PLACE_TYPE.name));
		semmsa005Bean.setLegalPartiesTypeList(getLovItemsByType(ELovType.T_SI_LEGAL_PARTIES_TYPE.name));
		
		semmsa005Bean.setBtnBorrowPopup(popup);
		ReturnContract returnCtx = null;
		BorrowContract borrowContract = null;
		IBorrowRequestService borService = (IBorrowRequestService)getBean("borrowRequestService");
		borrowContract = borService.queryBorrowContractByRowId(contractID);
		if (mode.equals("EDIT")) {
			semmsa005Bean.setPageMode(false);
			returnCtx = getBorrowContractByContractId(contractID, returnID, mode);
			
			if(StringUtils.isEmpty(returnCtx.getDocContractDetail())){
				returnCtx.setDocContractDetail(borrowContract.getDocContractDetail());
			}
			
		} else if (mode.equals("VIEW")) {
			semmsa005Bean.setPageMode(true);
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
			semmsa005Bean.setMode("MULTIADD");
			
			String tmpContractId = "";
			List<WrapperBeanObject<Mco003SearchBorrowSP>> bgMaster = getSemmsa005Bean().getBorrowSPList();
			for (WrapperBeanObject<Mco003SearchBorrowSP> wrapperBeanObject : bgMaster) {
				if(wrapperBeanObject.isCheckBox()){
					Mco003SearchBorrowSP tmp = (Mco003SearchBorrowSP)wrapperBeanObject.getDataObj();
					tmpContractId += (tmpContractId.equals(""))? tmp.getBorrowContractId(): "," + tmp.getBorrowContractId();
				}
			}
			
			semmsa005Bean.setBorrowContractIdList(tmpContractId);
			Mco003ChkReturn mco003ChkReturn = new Mco003ChkReturn();
			mco003ChkReturn.setBorrowContractId(tmpContractId);
			try {
				List<Mco003ChkReturn> list = service.querySPList(EQueryName.SP_MCO003_CHK_RETURN.name, mco003ChkReturn);
				if (list != null && !list.isEmpty()) {
					if (null != list.get(0) && StringUtils.isNotEmpty(list.get(0).getContractNo())) {
						semmsa005Bean.setPopupBorrowOpen(false);
						semmsa005Bean.setPopupAlert(true);
						semmsa005Bean.setContentAlert(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("Q0015"), list.get(0).getContractNo()));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
		boolean flg = false;
		if (returnCtx != null) {
			if (returnCtx.getReturnName() != null) {
				for (SelectItem o: semmsa005Bean.getBorrowNameList()) {
					if (returnCtx.getReturnName().equals(o.getLabel())) {
						flg = true;
						break;
					}
				}
			}
		}
		if (flg) {
			semmsa005Bean.setDisTxtReturnName(false);
		} else {
			semmsa005Bean.setDisTxtReturnName(true);
			semmsa005Bean.setOtherReturnName(returnCtx.getReturnName());
		}
		//Set Default Current Date In ReturnDt If ReTurnDt Is Null 
		if(returnCtx != null){
			returnCtx.setReturnDt((returnCtx.getReturnDt()!=null)?returnCtx.getReturnDt():new Date());
		}else{
			returnCtx = new ReturnContract();
			returnCtx.setReturnDt(new Date());
		}
		
		semmsa005Bean.setReturnContract(returnCtx);
		semmsa005Bean.setBorrowOfficerList(getLovItemsByType(ELovType.T_CO_BORROW_OFFICER.name));
		
		String temp = (semmsa005Bean.getReturnContract().getRentType()!=null)?semmsa005Bean.getReturnContract().getRentType():"";
		semmsa005Bean.setTemp(temp);
		semmsa005Bean.setPnlRentType(new HashMap());
		setSemmsa005Bean(semmsa005Bean);
		doClearValidateCheckbox(semmsa005Bean);
		
		if(!returnID.equals(""))
			doShowRentType();
		
		//get legalDoc
		doGetLegalDoc();
		
		return flag;
	}
	
	@SuppressWarnings("unchecked")
	public void doShowRentType() {
		semmsa005Bean = getSemmsa005Bean();
		semmsa005Bean.setDisableChk1(false);
		semmsa005Bean.setDisableChk2(false);
		semmsa005Bean.setDisableChk3(false);
		semmsa005Bean.setDisableChk4(false);
		semmsa005Bean.setDisableChk5(false);
		semmsa005Bean.setDisableChk6(false);
		semmsa005Bean.setDisableChk7(false);
		semmsa005Bean.setDisableChk8(false);
		List lp = new ArrayList();
		List ls = new ArrayList();
		
		
		doValidateCheckBox();
		
		/*add CheckBox*/
		if(semmsa005Bean.getTemp().equals("01")){
//			semmsa005Bean.getPnlRentType().get("01")
			lp = (List) semmsa005Bean.getPnlRentType().get("01");
				lp = new ArrayList();
				lp.add(semmsa005Bean.getDoc1List().get(0));
				lp.add(semmsa005Bean.getDoc2List().get(0));
				lp.add(semmsa005Bean.getDoc3List().get(0));
				lp.add(semmsa005Bean.getDoc4List().get(0));
				lp.add(semmsa005Bean.getDoc5List().get(0));
				lp.add(semmsa005Bean.getDoc6List().get(0));
				lp.add(semmsa005Bean.getDoc7List().get(0));
				lp.add(semmsa005Bean.getDoc8List().get(0));
				lp.add(semmsa005Bean.getDoc9List().get(0));
				lp.add(semmsa005Bean.getDoc10List().get(0));
				lp.add(semmsa005Bean.getDocOtherList().get(0));
				String docOtherRemark = (StringUtils.isEmpty(semmsa005Bean.getReturnContract().getDocOtherRemark()))? "":semmsa005Bean.getReturnContract().getDocOtherRemark();
				lp.add(docOtherRemark);
				semmsa005Bean.getPnlRentType().put("01", lp);
				doClearValidateCheckbox(semmsa005Bean);
		}
		if(semmsa005Bean.getTemp().equals("02")){
			lp = (List) semmsa005Bean.getPnlRentType().get("02");
				lp = new ArrayList();
				lp.add(semmsa005Bean.getDoc1List().get(0));
				lp.add(semmsa005Bean.getDoc2List().get(0));
				lp.add(semmsa005Bean.getDoc3List().get(0));
				lp.add(semmsa005Bean.getDoc4List().get(0));
				lp.add(semmsa005Bean.getDoc5List().get(0));
				lp.add(semmsa005Bean.getDoc6List().get(0));
				lp.add(semmsa005Bean.getDoc7List().get(0));
				lp.add(semmsa005Bean.getDoc8List().get(0));
				lp.add(semmsa005Bean.getDoc9List().get(0));
				lp.add(semmsa005Bean.getDoc10List().get(0));
				lp.add(semmsa005Bean.getDocOtherList().get(0));
				String docOtherRemark = (StringUtils.isEmpty(semmsa005Bean.getReturnContract().getDocOtherRemark()))? "":semmsa005Bean.getReturnContract().getDocOtherRemark();
				lp.add(docOtherRemark);
				semmsa005Bean.getPnlRentType().put("02", lp);
				doClearValidateCheckbox(semmsa005Bean);
		}
		if(semmsa005Bean.getTemp().equals("03")){
			lp = (List) semmsa005Bean.getPnlRentType().get("03");
				lp = new ArrayList();
				lp.add(semmsa005Bean.getDoc1List().get(0));
				lp.add(semmsa005Bean.getDoc2List().get(0));
				lp.add(semmsa005Bean.getDoc3List().get(0));
				lp.add(semmsa005Bean.getDoc4List().get(0));
				lp.add(semmsa005Bean.getDoc5List().get(0));
				lp.add(semmsa005Bean.getDoc6List().get(0));
				lp.add(semmsa005Bean.getDoc7List().get(0));
				lp.add(semmsa005Bean.getDoc8List().get(0));
				lp.add(semmsa005Bean.getDoc9List().get(0));
				lp.add(semmsa005Bean.getDoc10List().get(0));
				lp.add(semmsa005Bean.getDocOtherList().get(0));
				String docOtherRemark = (StringUtils.isEmpty(semmsa005Bean.getReturnContract().getDocOtherRemark()))? "":semmsa005Bean.getReturnContract().getDocOtherRemark();
				lp.add(docOtherRemark);
				semmsa005Bean.getPnlRentType().put("03", lp);
				doClearValidateCheckbox(semmsa005Bean);
		}
		if(semmsa005Bean.getTemp().equals("04")){
			lp = (List) semmsa005Bean.getPnlRentType().get("04");
				lp = new ArrayList();
				lp.add(semmsa005Bean.getDoc1List().get(0));
				lp.add(semmsa005Bean.getDoc2List().get(0));
				lp.add(semmsa005Bean.getDoc3List().get(0));
				lp.add(semmsa005Bean.getDoc4List().get(0));
				lp.add(semmsa005Bean.getDoc5List().get(0));
				lp.add(semmsa005Bean.getDoc6List().get(0));
				lp.add(semmsa005Bean.getDoc7List().get(0));
				lp.add(semmsa005Bean.getDoc8List().get(0));
				lp.add(semmsa005Bean.getDoc9List().get(0));
				lp.add(semmsa005Bean.getDoc10List().get(0));
				lp.add(semmsa005Bean.getDocOtherList().get(0));
				String docOtherRemark = (StringUtils.isEmpty(semmsa005Bean.getReturnContract().getDocOtherRemark()))? "":semmsa005Bean.getReturnContract().getDocOtherRemark();
				lp.add(docOtherRemark);
				semmsa005Bean.getPnlRentType().put("04", lp);
				doClearValidateCheckbox(semmsa005Bean);
		}
		if(semmsa005Bean.getTemp().equals("05")){
			lp = (List) semmsa005Bean.getPnlRentType().get("05");
				lp = new ArrayList();
				lp.add(semmsa005Bean.getDoc1List().get(0));
				lp.add(semmsa005Bean.getDoc2List().get(0));
				lp.add(semmsa005Bean.getDoc3List().get(0));
				lp.add(semmsa005Bean.getDoc4List().get(0));
				lp.add(semmsa005Bean.getDoc5List().get(0));
				lp.add(semmsa005Bean.getDoc6List().get(0));
				lp.add(semmsa005Bean.getDoc7List().get(0));
				lp.add(semmsa005Bean.getDoc8List().get(0));
				lp.add(semmsa005Bean.getDoc9List().get(0));
				lp.add(semmsa005Bean.getDoc10List().get(0));
				lp.add(semmsa005Bean.getDocOtherList().get(0));
				String docOtherRemark = (StringUtils.isEmpty(semmsa005Bean.getReturnContract().getDocOtherRemark()))? "":semmsa005Bean.getReturnContract().getDocOtherRemark();
				lp.add(docOtherRemark);
				semmsa005Bean.getPnlRentType().put("05", lp);
				doClearValidateCheckbox(semmsa005Bean);
		}
		if(semmsa005Bean.getTemp().equals("06")){
			lp = (List) semmsa005Bean.getPnlRentType().get("06");
				lp = new ArrayList();
				lp.add(semmsa005Bean.getDoc1List().get(0));
				lp.add(semmsa005Bean.getDoc2List().get(0));
				lp.add(semmsa005Bean.getDoc3List().get(0));
				lp.add(semmsa005Bean.getDoc4List().get(0));
				lp.add(semmsa005Bean.getDoc5List().get(0));
				lp.add(semmsa005Bean.getDoc6List().get(0));
				lp.add(semmsa005Bean.getDoc7List().get(0));
				lp.add(semmsa005Bean.getDoc8List().get(0));
				lp.add(semmsa005Bean.getDoc9List().get(0));
				lp.add(semmsa005Bean.getDoc10List().get(0));
				lp.add(semmsa005Bean.getDocOtherList().get(0));
				String docOtherRemark = (StringUtils.isEmpty(semmsa005Bean.getReturnContract().getDocOtherRemark()))? "":semmsa005Bean.getReturnContract().getDocOtherRemark();
				lp.add(docOtherRemark);
				semmsa005Bean.getPnlRentType().put("06", lp);
				doClearValidateCheckbox(semmsa005Bean);
		}
		if(semmsa005Bean.getTemp().equals("07")){
			lp = (List) semmsa005Bean.getPnlRentType().get("07");
				lp = new ArrayList();
				lp.add(semmsa005Bean.getDoc1List().get(0));
				lp.add(semmsa005Bean.getDoc2List().get(0));
				lp.add(semmsa005Bean.getDoc3List().get(0));
				lp.add(semmsa005Bean.getDoc4List().get(0));
				lp.add(semmsa005Bean.getDoc5List().get(0));
				lp.add(semmsa005Bean.getDoc6List().get(0));
				lp.add(semmsa005Bean.getDoc7List().get(0));
				lp.add(semmsa005Bean.getDoc8List().get(0));
				lp.add(semmsa005Bean.getDoc9List().get(0));
				lp.add(semmsa005Bean.getDoc10List().get(0));
				lp.add(semmsa005Bean.getDocOtherList().get(0));
				String docOtherRemark = (StringUtils.isEmpty(semmsa005Bean.getReturnContract().getDocOtherRemark()))? "":semmsa005Bean.getReturnContract().getDocOtherRemark();
				lp.add(docOtherRemark);
				semmsa005Bean.getPnlRentType().put("07", lp);
				doClearValidateCheckbox(semmsa005Bean);
		}
		if(semmsa005Bean.getTemp().equals("99")){
			lp = (List) semmsa005Bean.getPnlRentType().get("99");
				lp = new ArrayList();
				lp.add(semmsa005Bean.getDoc1List().get(0));
				lp.add(semmsa005Bean.getDoc2List().get(0));
				lp.add(semmsa005Bean.getDoc3List().get(0));
				lp.add(semmsa005Bean.getDoc4List().get(0));
				lp.add(semmsa005Bean.getDoc5List().get(0));
				lp.add(semmsa005Bean.getDoc6List().get(0));
				lp.add(semmsa005Bean.getDoc7List().get(0));
				lp.add(semmsa005Bean.getDoc8List().get(0));
				lp.add(semmsa005Bean.getDoc9List().get(0));
				lp.add(semmsa005Bean.getDoc10List().get(0));
				lp.add(semmsa005Bean.getDocOtherList().get(0));
				String docOtherRemark = (StringUtils.isEmpty(semmsa005Bean.getReturnContract().getDocOtherRemark()))? "":semmsa005Bean.getReturnContract().getDocOtherRemark();
				lp.add(docOtherRemark);
				semmsa005Bean.getPnlRentType().put("99", lp);
				doClearValidateCheckbox(semmsa005Bean);
		}
		
		// semmsa005Bean.getReturnContract().setDocOtherRemark("");
		
		/*Show Checkbox to Panel*/		
		String rentType = semmsa005Bean.getReturnContract().getRentType();
		if (rentType != null) {
			if(rentType.equals("01") && !rentType.isEmpty()){
				semmsa005Bean.setDisableChk1(true);
				ls = (List) semmsa005Bean.getPnlRentType().get("01");
				if((ls!=null) && (ls.size()>0)){
					semmsa005Bean.getDoc1List().add(ls.get(0));
					semmsa005Bean.getDoc2List().add(ls.get(1));
					semmsa005Bean.getDoc3List().add(ls.get(2));
					semmsa005Bean.getDoc4List().add(ls.get(3));
					semmsa005Bean.getDoc5List().add(ls.get(4));
					semmsa005Bean.getDoc6List().add(ls.get(5));
					semmsa005Bean.getDoc7List().add(ls.get(6));
					semmsa005Bean.getDoc8List().add(ls.get(7));
					semmsa005Bean.getDoc9List().add(ls.get(8));
					semmsa005Bean.getDoc10List().add(ls.get(9));
					semmsa005Bean.getDocOtherList().add(ls.get(10));
					semmsa005Bean.getReturnContract().setDocOtherRemark((String)ls.get(11));
					semmsa005Bean.setTemp("01");
				}else{
					doClearValidateCheckbox(semmsa005Bean);
				}			
			}		
			
			if(rentType.equals("02") && !rentType.isEmpty()){
				semmsa005Bean.setDisableChk2(true);
				ls = (List) semmsa005Bean.getPnlRentType().get("02");
				if((ls!=null) && ls.size()>0){
					semmsa005Bean.getDoc1List().add(ls.get(0));
					semmsa005Bean.getDoc2List().add(ls.get(1));
					semmsa005Bean.getDoc3List().add(ls.get(2));
					semmsa005Bean.getDoc4List().add(ls.get(3));
					semmsa005Bean.getDoc5List().add(ls.get(4));
					semmsa005Bean.getDoc6List().add(ls.get(5));
					semmsa005Bean.getDoc7List().add(ls.get(6));
					semmsa005Bean.getDoc8List().add(ls.get(7));
					semmsa005Bean.getDoc9List().add(ls.get(8));
					semmsa005Bean.getDoc10List().add(ls.get(9));
					semmsa005Bean.getDocOtherList().add(ls.get(10));
					semmsa005Bean.getReturnContract().setDocOtherRemark((String)ls.get(11));
					semmsa005Bean.setTemp("02");
				}else{
					doClearValidateCheckbox(semmsa005Bean);
				}			
			}
			if(rentType.equals("03") && !rentType.isEmpty()){
				semmsa005Bean.setDisableChk3(true);
				ls = (List) semmsa005Bean.getPnlRentType().get("03");
				if((ls!=null) && ls.size()>0){
					semmsa005Bean.getDoc1List().add(ls.get(0));
					semmsa005Bean.getDoc2List().add(ls.get(1));
					semmsa005Bean.getDoc3List().add(ls.get(2));
					semmsa005Bean.getDoc4List().add(ls.get(3));
					semmsa005Bean.getDoc5List().add(ls.get(4));
					semmsa005Bean.getDoc6List().add(ls.get(5));
					semmsa005Bean.getDoc7List().add(ls.get(6));
					semmsa005Bean.getDoc8List().add(ls.get(7));
					semmsa005Bean.getDoc9List().add(ls.get(8));
					semmsa005Bean.getDoc10List().add(ls.get(9));
					semmsa005Bean.getDocOtherList().add(ls.get(10));
					semmsa005Bean.getReturnContract().setDocOtherRemark((String)ls.get(11));
					semmsa005Bean.setTemp("03");
				}else{
					doClearValidateCheckbox(semmsa005Bean);
				}			
			}
			if(rentType.equals("04") && !rentType.isEmpty()){
				semmsa005Bean.setDisableChk4(true);
				ls = (List) semmsa005Bean.getPnlRentType().get("04");
				if((ls!=null) && ls.size()>0){
					semmsa005Bean.getDoc1List().add(ls.get(0));
					semmsa005Bean.getDoc2List().add(ls.get(1));
					semmsa005Bean.getDoc3List().add(ls.get(2));
					semmsa005Bean.getDoc4List().add(ls.get(3));
					semmsa005Bean.getDoc5List().add(ls.get(4));
					semmsa005Bean.getDoc6List().add(ls.get(5));
					semmsa005Bean.getDoc7List().add(ls.get(6));
					semmsa005Bean.getDoc8List().add(ls.get(7));
					semmsa005Bean.getDoc9List().add(ls.get(8));
					semmsa005Bean.getDoc10List().add(ls.get(9));
					semmsa005Bean.getDocOtherList().add(ls.get(10));
					semmsa005Bean.getReturnContract().setDocOtherRemark((String)ls.get(11));
					semmsa005Bean.setTemp("04");
				}else{
					doClearValidateCheckbox(semmsa005Bean);
				}			
			}
			if(rentType.equals("05") && !rentType.isEmpty()){
				semmsa005Bean.setDisableChk5(true);
				ls = (List) semmsa005Bean.getPnlRentType().get("05");
				if((ls!=null) && ls.size()>0){
					semmsa005Bean.getDoc1List().add(ls.get(0));
					semmsa005Bean.getDoc2List().add(ls.get(1));
					semmsa005Bean.getDoc3List().add(ls.get(2));
					semmsa005Bean.getDoc4List().add(ls.get(3));
					semmsa005Bean.getDoc5List().add(ls.get(4));
					semmsa005Bean.getDoc6List().add(ls.get(5));
					semmsa005Bean.getDoc7List().add(ls.get(6));
					semmsa005Bean.getDoc8List().add(ls.get(7));
					semmsa005Bean.getDoc9List().add(ls.get(8));
					semmsa005Bean.getDoc10List().add(ls.get(9));
					semmsa005Bean.getDocOtherList().add(ls.get(10));
					semmsa005Bean.getReturnContract().setDocOtherRemark((String)ls.get(11));
					semmsa005Bean.setTemp("05");
				}else{
					doClearValidateCheckbox(semmsa005Bean);
				}			
			}
			if(rentType.equals("06") && !rentType.isEmpty()){
				semmsa005Bean.setDisableChk6(true);
				ls = (List) semmsa005Bean.getPnlRentType().get("06");
				if((ls!=null) && ls.size()>0){
					semmsa005Bean.getDoc1List().add(ls.get(0));
					semmsa005Bean.getDoc2List().add(ls.get(1));
					semmsa005Bean.getDoc3List().add(ls.get(2));
					semmsa005Bean.getDoc4List().add(ls.get(3));
					semmsa005Bean.getDoc5List().add(ls.get(4));
					semmsa005Bean.getDoc6List().add(ls.get(5));
					semmsa005Bean.getDoc7List().add(ls.get(6));
					semmsa005Bean.getDoc8List().add(ls.get(7));
					semmsa005Bean.getDoc9List().add(ls.get(8));
					semmsa005Bean.getDoc10List().add(ls.get(9));
					semmsa005Bean.getDocOtherList().add(ls.get(10));
					semmsa005Bean.getReturnContract().setDocOtherRemark((String)ls.get(11));
					semmsa005Bean.setTemp("06");
				}else{
					doClearValidateCheckbox(semmsa005Bean);
				}			
			}
			if(rentType.equals("07") && !rentType.isEmpty()){
				semmsa005Bean.setDisableChk8(true);
				ls = (List) semmsa005Bean.getPnlRentType().get("07");
				if((ls!=null) && ls.size()>0){
					semmsa005Bean.getDoc1List().add(ls.get(0));
					semmsa005Bean.getDoc2List().add(ls.get(1));
					semmsa005Bean.getDoc3List().add(ls.get(2));
					semmsa005Bean.getDoc4List().add(ls.get(3));
					semmsa005Bean.getDoc5List().add(ls.get(4));
					semmsa005Bean.getDoc6List().add(ls.get(5));
					semmsa005Bean.getDoc7List().add(ls.get(6));
					semmsa005Bean.getDoc8List().add(ls.get(7));
					semmsa005Bean.getDoc9List().add(ls.get(8));
					semmsa005Bean.getDoc10List().add(ls.get(9));
					semmsa005Bean.getDocOtherList().add(ls.get(10));
					semmsa005Bean.getReturnContract().setDocOtherRemark((String)ls.get(11));
					semmsa005Bean.setTemp("07");
				}else{
					doClearValidateCheckbox(semmsa005Bean);
				}			
			}
			
			if(rentType.equals("99") && !rentType.isEmpty()){
				semmsa005Bean.setDisableChk7(true);
				ls = (List) semmsa005Bean.getPnlRentType().get("99");
				if((ls!=null) && ls.size()>0){
					semmsa005Bean.getDoc1List().add(ls.get(0));
					semmsa005Bean.getDoc2List().add(ls.get(1));
					semmsa005Bean.getDoc3List().add(ls.get(2));
					semmsa005Bean.getDoc4List().add(ls.get(3));
					semmsa005Bean.getDoc5List().add(ls.get(4));
					semmsa005Bean.getDoc6List().add(ls.get(5));
					semmsa005Bean.getDoc7List().add(ls.get(6));
					semmsa005Bean.getDoc8List().add(ls.get(7));
					semmsa005Bean.getDoc9List().add(ls.get(8));
					semmsa005Bean.getDoc10List().add(ls.get(9));
					semmsa005Bean.getDocOtherList().add(ls.get(10));
					semmsa005Bean.getReturnContract().setDocOtherRemark((String)ls.get(11));
					semmsa005Bean.setTemp("99");
				}else{
					doClearValidateCheckbox(semmsa005Bean);
				}
			}
		}
		setSemmsa005Bean(semmsa005Bean);
	}
	
	@SuppressWarnings("unchecked")
	public void doClearValidateCheckbox(SEMMSA005Bean semmsa005Bean){
		semmsa005Bean.setDoc1List(new ArrayList());
		semmsa005Bean.setDoc2List(new ArrayList());
		semmsa005Bean.setDoc3List(new ArrayList());
		semmsa005Bean.setDoc4List(new ArrayList());
		semmsa005Bean.setDoc5List(new ArrayList());
		semmsa005Bean.setDoc6List(new ArrayList());
		semmsa005Bean.setDoc7List(new ArrayList());
		semmsa005Bean.setDoc8List(new ArrayList());
		semmsa005Bean.setDoc9List(new ArrayList());
		semmsa005Bean.setDoc10List(new ArrayList());
		semmsa005Bean.setDocOtherList(new ArrayList());
	}
	
	@SuppressWarnings("unchecked")
	public void doValidateCheckBox() {
		// semmsa005Bean = getSemmsa005Bean();
		if(semmsa005Bean.getDoc1List() == null || semmsa005Bean.getDoc1List().size()==0){
			String doc1 = (semmsa005Bean.getReturnContract().getDoc1()!=null&&semmsa005Bean.getReturnContract().getDoc1().equals("Y"))? "Y": "FALSE";
			semmsa005Bean.getDoc1List().add(doc1);
		}
		
		if(semmsa005Bean.getDoc2List() == null || semmsa005Bean.getDoc2List().size()==0){
			String doc2 = (semmsa005Bean.getReturnContract().getDoc2()!=null&&semmsa005Bean.getReturnContract().getDoc2().equals("Y"))? "Y": "N";
			semmsa005Bean.getDoc2List().add(doc2);
		}
		
		if(semmsa005Bean.getDoc3List() == null || semmsa005Bean.getDoc3List().size()==0){
			String doc3 = (semmsa005Bean.getReturnContract().getDoc3()!=null&&semmsa005Bean.getReturnContract().getDoc3().equals("Y"))? "Y": "N";
			semmsa005Bean.getDoc3List().add(doc3);
		}
		
		if(semmsa005Bean.getDoc4List() == null || semmsa005Bean.getDoc4List().size()==0){
			String doc4 = (semmsa005Bean.getReturnContract().getDoc4()!=null&&semmsa005Bean.getReturnContract().getDoc4().equals("Y"))? "Y": "N";
			semmsa005Bean.getDoc4List().add(doc4);
		}
		
		if(semmsa005Bean.getDoc5List() == null || semmsa005Bean.getDoc5List().size()==0){
			String doc5 = (semmsa005Bean.getReturnContract().getDoc5()!=null&&semmsa005Bean.getReturnContract().getDoc5().equals("Y"))? "Y": "N";
			semmsa005Bean.getDoc5List().add(doc5);
		}
		
		if(semmsa005Bean.getDoc6List() == null || semmsa005Bean.getDoc6List().size()==0){
			String doc6 = (semmsa005Bean.getReturnContract().getDoc6()!=null&&semmsa005Bean.getReturnContract().getDoc6().equals("Y"))? "Y": "N";
			semmsa005Bean.getDoc6List().add(doc6);
		}
		if(semmsa005Bean.getDoc7List() == null || semmsa005Bean.getDoc7List().size()==0){
			String doc7 = (semmsa005Bean.getReturnContract().getDoc7()!=null&&semmsa005Bean.getReturnContract().getDoc7().equals("Y"))? "Y": "N";
			semmsa005Bean.getDoc7List().add(doc7);
		}
		if(semmsa005Bean.getDoc8List() == null || semmsa005Bean.getDoc8List().size()==0){
			String doc8 = (semmsa005Bean.getReturnContract().getDoc8()!=null&&semmsa005Bean.getReturnContract().getDoc8().equals("Y"))? "Y": "N";
			semmsa005Bean.getDoc8List().add(doc8);
		}
		if(semmsa005Bean.getDoc9List() == null || semmsa005Bean.getDoc9List().size()==0){
			String doc9 = (semmsa005Bean.getReturnContract().getDoc9()!=null&&semmsa005Bean.getReturnContract().getDoc9().equals("Y"))? "Y": "N";
			semmsa005Bean.getDoc9List().add(doc9);
		}
		if(semmsa005Bean.getDoc10List() == null || semmsa005Bean.getDoc10List().size()==0){
			String doc10 = (semmsa005Bean.getReturnContract().getDoc10()!=null&&semmsa005Bean.getReturnContract().getDoc10().equals("Y"))? "Y": "N";
			semmsa005Bean.getDoc10List().add(doc10);
		}
		if(semmsa005Bean.getDocOtherList() == null || semmsa005Bean.getDocOtherList().size()==0){
			String docOther = (semmsa005Bean.getReturnContract().getDocOther()!=null&&semmsa005Bean.getReturnContract().getDocOther().equals("Y"))? "Y": "N";
			semmsa005Bean.getDocOtherList().add(docOther);
		}
		// setSemmsa005Bean(semmsa005Bean);
	}
	
	@SuppressWarnings("unchecked")
	private boolean doSaveContractReturn(){
		boolean flag = false;
		semmsa005Bean = getSemmsa005Bean();
		String borrowContractId = "";
		IBorrowRequestService borService = (IBorrowRequestService)getBean("borrowRequestService");
		if(!validateContractReturn()){
			semmsa005Bean.setPopupClose(false);
			semmsa005Bean.setRenderedMsgFormTop(false);
			setSemmsa005Bean(semmsa005Bean);
			return flag;
		}
		try{
			ReturnContract contract = semmsa005Bean.getReturnContract();
			
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
				contract.setDoc1((semmsa005Bean.getDoc1List() != null && semmsa005Bean.getDoc1List().size() > 0)?"Y":"");
				contract.setDoc2((semmsa005Bean.getDoc2List() != null && semmsa005Bean.getDoc2List().size() > 0)?"Y":"");
				contract.setDoc3((semmsa005Bean.getDoc3List() != null && semmsa005Bean.getDoc3List().size() > 0)?"Y":"");
				contract.setDoc4((semmsa005Bean.getDoc4List() != null && semmsa005Bean.getDoc4List().size() > 0)?"Y":"");
				contract.setDoc5((semmsa005Bean.getDoc5List() != null && semmsa005Bean.getDoc5List().size() > 0)?"Y":"");
				contract.setDoc6((semmsa005Bean.getDoc6List() != null && semmsa005Bean.getDoc6List().size() > 0)?"Y":"");
				contract.setDoc7((semmsa005Bean.getDoc7List() != null && semmsa005Bean.getDoc7List().size() > 0)?"Y":"");
				contract.setDoc8((semmsa005Bean.getDoc8List() != null && semmsa005Bean.getDoc8List().size() > 0)?"Y":"");
				contract.setDoc9((semmsa005Bean.getDoc9List() != null && semmsa005Bean.getDoc9List().size() > 0)?"Y":"");
				contract.setDoc10((semmsa005Bean.getDoc10List() != null && semmsa005Bean.getDoc10List().size() > 0)?"Y":"");
				contract.setDocOther((semmsa005Bean.getDocOtherList() != null && semmsa005Bean.getDocOtherList().size() > 0)?"Y":"");
			}
			
			if (StringUtils.isEmpty(contract.getReturnName())) {
				contract.setReturnName(semmsa005Bean.getOtherReturnName());
			}
			
			if(semmsa005Bean.getMode().equals("ADD")){
				contract.setRecordStatus("Y");
				borrowContractId = contract.getBorrowContractId();
//				returnID
//				borService.saveReturnContract(contract);
			} else if(semmsa005Bean.getMode().equals("EDIT")){
				contract.setRecordStatus("Y");
				borrowContractId = contract.getBorrowContractId();
//				borService.updateReturnContract(contract);
			} else if(semmsa005Bean.getMode().equals("MULTIADD")) {
				borrowContractId = semmsa005Bean.getBorrowContractIdList();
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
					semmsa005Bean.setPopupClose(false);
					addMessageError("E0001");
				}
//			}
			
			semmsa005Bean.setPopupClose(true);
			addMessageInfo("M0001");
		}catch(Exception e){
			e.printStackTrace();
			semmsa005Bean.setPopupClose(false);
			addMessageError("E0001");
		}
		
		
		setSemmsa005Bean(semmsa005Bean);
		
		flag = doSearchContract();
		return flag;
	}
	
	private boolean validateContractReturn() {
		boolean flgValid = true;
		if(StringUtils.isEmpty(getSemmsa005Bean().getReturnContract().getReturnName())){
			if (StringUtils.isEmpty(getSemmsa005Bean().getOtherReturnName())) {
				addMessageError("W0001", msg("message.returnName"));
				flgValid = false;
			}
		}
		
		if(getSemmsa005Bean().getReturnContract().getReturnDt()==null){
			addMessageError("W0001", msg("message.returnDt"));
			flgValid = false;
		}
		
		if(StringUtils.isEmpty(getSemmsa005Bean().getReturnContract().getReturnOfficer())){
			addMessageError("W0001", msg("message.returnOfficer"));
			flgValid = false;
		}
		return flgValid;
	}
	
	private boolean initDeleteRequest() {
		boolean flag = true;
		semmsa005Bean = getSemmsa005Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		semmsa005Bean.setBorrowRequestIdDel(rowId);
		setSemmsa005Bean(semmsa005Bean);
		return flag;
	}
	
	private boolean initDeleteContract() {
		boolean flag = true;
		semmsa005Bean = getSemmsa005Bean();
		String fromPopup = (String) getFacesUtils().getRequestParameter("fromPopup");
		semmsa005Bean.setFromPopup(fromPopup);
		String contractID = (String)getFacesUtils().getRequestParameter("contractID");
		String returnID = (String)getFacesUtils().getRequestParameter("returnID");
		semmsa005Bean.setBorrowContractIdDel(contractID);
		semmsa005Bean.setReturnContractIdDel(returnID);
		semmsa005Bean.setRenderedMsgFormTop(true);
		setSemmsa005Bean(semmsa005Bean);
		return flag;
	}
	
	@SuppressWarnings("unchecked")
	private boolean deleteRequest(){
		boolean flag = true;
		semmsa005Bean = getSemmsa005Bean();
		// String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		// IBorrowRequestService borService = (IBorrowRequestService)getBean("borrowRequestService");
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		try{
//			BorrowRequest borrow = borService.queryBorrowRequestByRowId(semmsa005Bean.getBorrowRequestIdDel());
//			borService.deleteRequest(borrow);
			Mco003Del mco003Del = new Mco003Del();
			mco003Del.setBorrowReqId(semmsa005Bean.getBorrowRequestIdDel());
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
			semmsa005Bean.setPopupClose(false);
			addMessageError("E0001");
		}
		// 20101210
		// flag = doSearchContract();
		doSearch();
		setSemmsa005Bean(semmsa005Bean);
		return flag;
	}
	
	@SuppressWarnings("unchecked")
	private boolean deleteContract(){
		log.debug("deleteContract");
		boolean flag = false;
		semmsa005Bean = getSemmsa005Bean();
		// IBorrowRequestService borService = (IBorrowRequestService)getBean("borrowRequestService");
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		try{
//			if(!semmsa005Bean.getBorrowContractIdDel().equals("")){
//				BorrowContract borrow = borService.queryBorrowContractByRowId(semmsa005Bean.getBorrowContractIdDel());
//				borService.deleteBorrow(borrow);
//			}
//			if(!semmsa005Bean.getReturnContractIdDel().equals("")){
//				ReturnContract borrow = borService.queryReturnContractByRowId(semmsa005Bean.getReturnContractIdDel());
//				borService.deleteReturn(borrow);
//			}
			Mco003DelBorrow mco003DelBorrow = new Mco003DelBorrow();
			mco003DelBorrow.setBorrowContractId(semmsa005Bean.getBorrowContractIdDel());
			mco003DelBorrow.setCurrentUser(getUserLogIn());
			List list = service.querySPList(EQueryName.SP_MCO003_DEL_BORROW.name, mco003DelBorrow);
			if (list != null && !list.isEmpty()) {
				Mco003DelBorrow result = (Mco003DelBorrow)list.get(0);
				if (result.getResult().equals("Success")) {
					addMessageInfo("M0002");
				}
			}
			Mco003SearchBorrowSP criteriaSrch = new Mco003SearchBorrowSP();
			criteriaSrch.setCompany(semmsa005Bean.getTmpCompany());
			criteriaSrch.setBorrowRequestId(semmsa005Bean.getInsertBorrowID());
			criteriaSrch.setStatus("00");
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
				semmsa005Bean.setContractAdd(contractNo);
				semmsa005Bean.setCacheContractAdd(contractNo);
				semmsa005Bean.setBorrowSPList(packBorrowContractList(toSrch));
			} else {
				semmsa005Bean.setBorrowSPList(null);
			}
			semmsa005Bean.setAddContractNo(semmsa005Bean.getTmpRowId());
//			this.doSearchBeforAddContract();
//			String contractNo = semmsa005Bean.getViewContractNo();
//			SEMMSA005Bean criteria = semmsa005Bean;
//			criteria.getCriteriaBorrow().setContractNo(contractNo);
			semmsa005Bean.setBorrowSPList(this.searchContract(semmsa005Bean));
			setSemmsa005Bean(semmsa005Bean);
//			doSearchContract();
		}catch(Exception e){
			e.printStackTrace();
			semmsa005Bean.setPopupClose(false);
			addMessageError("E0001");
		}
		
		setSemmsa005Bean(semmsa005Bean);
		
		// flag = doSearchContract();
		return flag;
	}
	
	private boolean doClear(){
		boolean flag = false;
		semmsa005Bean = getSemmsa005Bean();
		semmsa005Bean.setCriteria(new Mco003SrchBorrowRequestSP());
		// semmsa005Bean.getBorrowRequestSPList().clear();
		semmsa005Bean.setBorrowRequestSPList(null);
		// 20130105
		// semmsa005Bean.setCriteriaBorrow(new Mco003SearchBorrowSP());
		// semmsa005Bean.getBorrowSPList().clear();
		setSemmsa005Bean(semmsa005Bean);
		return flag;
	}
	
	private boolean doClearBorrow() {
		boolean flag = false;
		semmsa005Bean = getSemmsa005Bean();
		String company = semmsa005Bean.getCriteriaBorrow().getCompany();
		semmsa005Bean.setCriteriaBorrow(new Mco003SearchBorrowSP());
		semmsa005Bean.getCriteriaBorrow().setCompany(company);
		// semmsa005Bean.getBorrowSPList().clear();
		semmsa005Bean.setBorrowSPList(null);
		semmsa005Bean.setCacheContractAdd("");
		semmsa005Bean.setCacheContractSrch("");
		semmsa005Bean.setViewContractNo("");
		semmsa005Bean.setAddPreContractNo("");
		semmsa005Bean.setAddContractNo("");
		semmsa005Bean.setRenderedMsgDataNotFound(false);
		setSemmsa005Bean(semmsa005Bean);
		return flag;
	}
	
	private boolean doUpdateBorrowContract(){
		boolean flag = false;
		semmsa005Bean = getSemmsa005Bean();
		IBorrowRequestService borService = (IBorrowRequestService)getBean("borrowRequestService");
		// semmsa005Bean.setRenderedMsgFormSearch(true);
		if(!validateUpdateContractStatus()){
			semmsa005Bean.setPopupClose(false);
			semmsa005Bean.setRenderedMsgFormSearch(false);
			setSemmsa005Bean(semmsa005Bean);
			return flag;
		}
		
		try{
			BorrowRequest borrow = semmsa005Bean.getBorrowRequest();
			// borrow.setCompany(semmsa005Bean.getCriteria().getCompany());
			borrow.setRecordStatus("Y");
			borrow.setCurrentUser(getUserLogIn());
			semmsa005Bean.setPopupClose(true);
			borService.updateBorrowContract(borrow);
		}catch(Exception e){
			e.printStackTrace();
			semmsa005Bean.setPopupClose(false);
			addMessageError("E0001");
		}
		semmsa005Bean.setMode("");

//		if(!StringUtils.isEmpty(getSemmsa005Bean().getCriteria().getCompany())){ 
			doSearch();
//		}
		addMessageInfo("M0001");
		setSemmsa005Bean(semmsa005Bean);
		getSemmsa005Bean().setRenderedMsgFormSearch(true);
		return flag;
	}
	
	public void selectAllRow(){
		try{
			boolean chkAll = getSemmsa005Bean().isChkSelAll();
			List<WrapperBeanObject<Mco003SearchBorrowSP>> detailList = new ArrayList<WrapperBeanObject<Mco003SearchBorrowSP>>();
			detailList = getSemmsa005Bean().getBorrowSPList();
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
		// getSemmsa005Bean().setTmpRowId(rowId);
		getSemmsa005Bean().setDisBtnBorrow(false);
		if(isCheckSELBox()) {
			getSemmsa005Bean().setDisabledBtnExport(false);
		} else {
			getSemmsa005Bean().setDisBtnBorrow(true);
			getSemmsa005Bean().setDisabledBtnExport(true);
			getSemmsa005Bean().setChkSelAll(false);
		}
	}
	
	private boolean isCheckSELBox(){
		boolean isCheck = false;
		List<WrapperBeanObject<Mco003SearchBorrowSP>> bgMaster = getSemmsa005Bean().getBorrowSPList();
		int i = 0;
		for (WrapperBeanObject<Mco003SearchBorrowSP> wrapperBeanObject : bgMaster) {
			if(wrapperBeanObject.isCheckBox()){
				isCheck = true;
				Mco003SearchBorrowSP tmp = (Mco003SearchBorrowSP)wrapperBeanObject.getDataObj();
				if (StringUtils.isEmpty(tmp.getBorrowName())) {
					getSemmsa005Bean().setDisBtnBorrow(true);
				}
				i++;
			}else{
				getSemmsa005Bean().setChkSelAll(false);
			}
		}
		if(bgMaster.size() == i){
			getSemmsa005Bean().setChkSelAll(true);
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
			detailList = getSemmsa005Bean().getBorrowSPList();
			
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
		getSemmsa005Bean().setTmpRowId(rowId);
	}
	
	public void getRowIdOnClick2() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemmsa005Bean().setTmpRowId2(rowId);
	}
	
	public void chkTxtBorrowName() {
		semmsa005Bean = getSemmsa005Bean();
		if (StringUtils.isEmpty(semmsa005Bean.getBorrowContract().getBorrowName())) {
			semmsa005Bean.setDisTxtBorrowName(true);
		} else {
			semmsa005Bean.setDisTxtBorrowName(false);
		}
		log.debug("officer = "+semmsa005Bean.getBorrowContract().getBorrowOfficer());
		setSemmsa005Bean(semmsa005Bean);
	}
	
	public void chkTxtReturnName() {
		semmsa005Bean = getSemmsa005Bean();
		if (StringUtils.isEmpty(semmsa005Bean.getReturnContract().getReturnName())) {
			semmsa005Bean.setDisTxtReturnName(true);
		} else {
			semmsa005Bean.setDisTxtReturnName(false);
		}
		setSemmsa005Bean(semmsa005Bean);
	}
	
	private boolean doInitAddContract() {
		log.debug("doInitAddContract");
		semmsa005Bean = getSemmsa005Bean();
		String onePopup = (String) getFacesUtils().getRequestParameter("onePopup");
		semmsa005Bean.setContractSPList(null);
		semmsa005Bean.setDisabledBtnAdd(true);
		semmsa005Bean.setAddContractNo("");
		if(StringUtils.equalsIgnoreCase("trueFlag", onePopup)){
			semmsa005Bean.setOnePopupFlag(true);
			semmsa005Bean.setMode("EDIT");
			
			if(semmsa005Bean.getCriteriaBorrow().getCompany() != null){
//				semmsa005Bean.getCriteriaBorrow().getCompany();
				semmsa005Bean.getBorrowRequest().setCompany(semmsa005Bean.getCriteriaBorrow().getCompany());
			}
		}else{
			semmsa005Bean.setOnePopupFlag(false);
		}
		setSemmsa005Bean(semmsa005Bean);
		return false;
	}

	private boolean doClearAddContrac() {
		semmsa005Bean = getSemmsa005Bean();
		// TODO Auto-generated method stub
		semmsa005Bean.setContractSPList(null);
		semmsa005Bean.setAddContractNo("");
		setSemmsa005Bean(semmsa005Bean);
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
		semmsa005Bean = getSemmsa005Bean();
		semmsa005Bean.setAddContractNo("");
		semmsa005Bean.setRenderedMsgFormTop(false);
		// semmsa005Bean.getBorrowRequestSPList().clear();
//		semmsa005Bean.setBorrowSPList(null);
		// 20130105
		// semmsa005Bean.setCriteriaBorrow(new Mco003SearchBorrowSP());
		// semmsa005Bean.getBorrowSPList().clear();
		setSemmsa005Bean(semmsa005Bean);
		return flag;
	}
	
	public boolean doCancelBorrow(){
		semmsa005Bean = getSemmsa005Bean();
		semmsa005Bean.setRenderedMsgFormTop(false);
		IBorrowRequestService service = (IBorrowRequestService)getBean("borrowRequestService");
		try {
		Mco003InsertBorrowSP mco003InsertBorrowSP = new Mco003InsertBorrowSP();
		mco003InsertBorrowSP.setDocNo(semmsa005Bean.getBorrowRequest().getDocNo());
//		mco003InsertBorrowSP.setContractNo(psi002.getContractNo());
		mco003InsertBorrowSP.setMode("DEL");
		mco003InsertBorrowSP.setCompany(semmsa005Bean.getBorrowRequest().getCompany());
		mco003InsertBorrowSP.setRecievDt(semmsa005Bean.getBorrowRequest().getReceiveDt());
		mco003InsertBorrowSP.setSamSendDt(semmsa005Bean.getBorrowRequest().getSamSendDt());
		mco003InsertBorrowSP.setSamAssignSend(semmsa005Bean.getBorrowRequest().getSamAssignSendDt());
		mco003InsertBorrowSP.setRemark(semmsa005Bean.getBorrowRequest().getRemark());
		mco003InsertBorrowSP.setUser(getUserLogIn());
		mco003InsertBorrowSP.setStatus("00");
		
		//added by NEW 2018/12/24
//		mco003InsertBorrowSP.setFileType(fileType)
	
			List<Mco003InsertBorrowSP> resultList = service.querySPList(EQueryName.SP_MCO003_INSERT.name, mco003InsertBorrowSP);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doSearch();
		setSemmsa005Bean(semmsa005Bean);
		return false;
	}
	
	//added by new 
	public void onRenderButton() {
		semmsa005Bean = getSemmsa005Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		semmsa005Bean.setTmpRowId(rowId);
//		semmsa003Bean = getSemmsa003Bean();
//		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
//		semmsa003Bean.setTmpRowId(rowId);
		
//		if (isCheckSELBox()) {
//			semmsa003Bean.setDisabledBtnExport(false);
//		} else {
//			semmsa003Bean.setDisabledBtnExport(true);
//		}
		
		if (!isBorrowCheckSELBox()) {
			semmsa005Bean.setDisabledBtnAdd(true);
		} else{
			semmsa005Bean.setDisabledBtnAdd(false);
		}
		setSemmsa005Bean(semmsa005Bean);
	}
	
	private boolean isBorrowCheckSELBox() {
		boolean isCheck = false;
		int rowSelect = 1;
		Mco003SearchPSI002SP borrowContractSP = new Mco003SearchPSI002SP();
		String batchTmp = null; 
		String flowStatus = null;
		ArrayList batchTempList = new ArrayList(); 
		semmsa005Bean.setDisabledBtnExport(false);
		boolean checkBatchNo = true;
		try{
			List<WrapperBeanObject<Mco003SearchPSI002SP>> borrowContractList = getSemmsa005Bean().getContractSPList();
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
			semmsa005Bean = getSemmsa005Bean();

			String paramSiteAppId = semmsa005Bean.getSiteAppObjParam().getSiteAppId();
			String paramPlaceType = semmsa005Bean.getSiteAppObjParam().getPlaceType(); //String paramPlaceType = semmsa002Bean.getParamPlaceType(); old fixed to new 
			String paramPartiesType = semmsa005Bean.getSiteAppObjParam().getPartiesType(); //String paramPartiesType = semmsa002Bean.getParamPartiesType(); old fixed to new 
//			
	        System.out.println("paramSiteAppId: " + paramSiteAppId);
	        System.out.println("paramPlaceType: " + paramPlaceType);
	        System.out.println("paramPartiesType: " + paramPartiesType);
	        
	        
	        SEMMSI002Bean semmsi002BeanCriteria = new SEMMSI002Bean();
	        semmsi002BeanCriteria.setParamSiteAppId(paramSiteAppId);
	        semmsi002BeanCriteria.setParamPlaceType(paramPlaceType);
	        semmsi002BeanCriteria.setParamPartiesType(paramPartiesType);
			
	        semmsa005Bean.setLegalDocList(new ArrayList<WrapperBeanObject<LegalDocComponentBean>>());
	        
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

						semmsa005Bean.getLegalDocList().add(tmpWrapperBean);
						// gen legal doc component list <<
						
						count++;
					}
					semmsa005Bean.setRenderedMsgDataNotFound(false);
	        	} else {
	        		semmsa005Bean.setRenderedMsgDataNotFound(true);
	        	}
        	
	        }
			setSemmsa005Bean(semmsa005Bean);
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
			semmsa005Bean = getSemmsa005Bean();
			//semmsi002Bean = getSemmsi002Bean();
			
//			HashSet keys = new HashSet<Integer>();
//	        int rowKey = getRepeater().getRowIndex();
			
	       // System.out.println("rowKey: " + Integer.toString(rowKey));
	        
			List<WrapperBeanObject<LegalDocComponentBean>> legalDocLst = semmsa005Bean.getLegalDocList();
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
					semmsa005Bean.setLegalDocList(legalDocLst);
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
			setSemmsa005Bean(semmsa005Bean);
		} catch(Exception e) {
			e.printStackTrace();
			addMessageError("EL0000", "SEMMCO003Action");
			
			//semmco001Bean.setRenderedMsgAlert(true);
			setSemmsa005Bean(semmsa005Bean);
		} finally {
			
		}
	}
	
	public void doUpdateLegalDoc() {
		
		try {
			
			this.doSetCheckBoxLegalDocEntity();			
			
			semmsa005Bean = getSemmsa005Bean();
			//semmsi002Bean = getSemmsi002Bean();
			
			List<WrapperBeanObject<LegalDocComponentBean>> legalDocLst = semmsa005Bean.getLegalDocList();
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
			semmsa005Bean.getSiteAppObjParam().setStrDataList(strDataList);
			semmsa005Bean.getSiteAppObjParam().setUserLogin(getUserLogIn());
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
			
			setSemmsa005Bean(semmsa005Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			addMessageError("EL0000", "SEMMCO003Action");
			
			setSemmsa005Bean(semmsa005Bean);
		} finally {
			
		}
		
	}
	
	public void doSetCheckBoxLegalDocEntity() {
		
		try {
			
			semmsa005Bean = getSemmsa005Bean();
			//semmsi002Bean = getSemmsi002Bean();
			
			List<WrapperBeanObject<LegalDocComponentBean>> legalDocLst = semmsa005Bean.getLegalDocList();
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
				
				semmsa005Bean.setLegalDocList(legalDocLst);
			}
			
			setSemmsa005Bean(semmsa005Bean);
			//setSemmsi002Bean(semmsi002Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			addMessageError("EL0000", "SEMMCO003Action");
			log.debug("ERROR SEMMCO003Action doSetCheckBoxLegalDocEntity "+e);
			setSemmsa005Bean(semmsa005Bean);
		} finally {
			
		}
	}
	
	public boolean initDownloadContract(){
		log.debug(" ##### Start SEMMSA005Action initDownloadContract ##### ");
		semmsa005Bean = getSemmsa005Bean();
		String contractNo = getFacesUtils().getRequestParameter("contractNo") == null ? "" : (String) getFacesUtils().getRequestParameter("contractNo");
		List<SiteAcqSrchFile> to = new ArrayList<SiteAcqSrchFile>();
		boolean flag = true;
		try{
			semmsa005Bean.setSrchFileSPList(new ArrayList<SiteAcqSrchFile>());
			
			if(contractNo != null){
				to = doGetContractFileList(contractNo);
				if(to != null){
					
					semmsa005Bean.setSrchFileSPList(to);
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error(" ##### Error SEMMSA005Action initDownloadContract ##### ");
			flag = false;
		}finally{
			setSemmsa005Bean(semmsa005Bean);
			log.debug(" ##### End SEMMSA005Action initDownloadContract ##### ");
		}
		return flag;
	}
	
	public List<SiteAcqSrchFile> doGetContractFileList(String contractNo){
		log.debug(" ######## Start SEMMSA005Action doGetContractFileList ########");
		semmsa005Bean = getSemmsa005Bean();
		List<SiteAcqSrchFile> fileList = new ArrayList<SiteAcqSrchFile>();
		try{
			List<SiteAcqSrchFile> to = new ArrayList<SiteAcqSrchFile>();
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			
			SiteAcqSrchFile obj = new SiteAcqSrchFile();
			obj.setContractNo(contractNo);
			
			to = service.querySPList(EQueryName.SP_MSA005_SEARCH_CONTRACT.name, obj);
			
			if(to != null){
				for(SiteAcqSrchFile fileObj : to){
					if(fileObj.getUpdateDt() != null) {
//						siteInfo.setEffDate(convertYearENtoTH(siteInfo.getEffDate()));
						fileObj.setUpdateDtStr(convertYearENtoTHStr(fileObj.getUpdateDt()));
					}
					
					fileList.add(fileObj);
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error(" ##### Error SEMMSA005Action doGetContractFileList : "+e);
		}finally{
			setSemmsa005Bean(semmsa005Bean);
			log.debug(" ###### End SEMMSA005Action doGetContractFileList ######");
		}
		return fileList;
	}

	//
	private boolean doSendApproveBorrow() {
		log.debug(" ###### Start SEMMSA005Action doSendApproveBorrow######");
		boolean flag = true;
		semmsa005Bean = getSemmsa005Bean();
		
		semmsa005Bean.setRenderedMsgFormSearch(false);
		
		List<Mco003SearchBorrowSP> to = null;
		Mco003SearchBorrowSP borrowSP = new Mco003SearchBorrowSP();
		
		String rowId = getFacesUtils().getRequestParameter("rowId") == null ? "" : (String)getFacesUtils().getRequestParameter("rowId");
		
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			
//			if(semmsa005Bean.getBorrowSPList() != null){
//				for(int i = 0;semmsa005Bean.getBorrowSPList().size() < i ; i++){
//					WrapperBeanObject<Mco003SearchBorrowSP> wrapBorrow = new WrapperBeanObject<Mco003SearchBorrowSP>();
//					
//					wrapBorrow = semmsa005Bean.getBorrowSPList().get(i);
//				}
//			}
			
			Mco003SearchBorrowSP criteria = new Mco003SearchBorrowSP();
			
			criteria.setRowId(rowId);
			criteria.setUserId(getUserLogIn());
			
			to = service.querySPList(EQueryName.SP_MCO003_SEND_APPROVE_BORROW.name, criteria);
			if(to != null && to.size() > 0){
				borrowSP = to.get(0);
				
				if(StringUtils.equalsIgnoreCase("SUCCESS", borrowSP.getResult())){
					addGeneralMessageInfo(borrowSP.getlMessage());
					this.doSearch();
				}else{
					addGeneralMessageError(borrowSP.getlMessage());
				}
//				
			} else {
				flag = false;
				addMessageError("E0004");
			}
			semmsa005Bean.setRenderedMsgFormSearch(true);
		}catch(Exception e){
			log.error(" ###### Error SEMMSA005Action doSendApproveBorrow : "+e);
			e.printStackTrace();
			addMessageError("E0004");
			flag = false;
		}finally{
			log.debug(" ###### End SEMMSA005Action doSendApproveBorrow######");
			setSemmsa005Bean(semmsa005Bean);
		}
		return flag;
	}
}
