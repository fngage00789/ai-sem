package th.co.ais.web.rt.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.richfaces.component.UITree;
import org.richfaces.component.html.HtmlTree;
import org.richfaces.event.NodeSelectedEvent;
import org.richfaces.model.TreeNode;
import org.richfaces.model.TreeNodeImpl;

import th.co.ais.common.service.IMenuTreeService;
import th.co.ais.domain.common.MenuTreeSP;
import th.co.ais.domain.gm.Attachment;
import th.co.ais.domain.gm.LovMaster;
import th.co.ais.domain.rt.Mrt006DepositStatusDDL;
import th.co.ais.domain.rt.Mrt006Save;
import th.co.ais.domain.rt.Mrt006Srch;
import th.co.ais.domain.rt.ReturnDeposit;
import th.co.ais.service.gm.IAttachmentService;
import th.co.ais.service.rt.IReturnDepositService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.TreeUtilBean;
import th.co.ais.web.ir.bean.FileUploadBean;
import th.co.ais.web.rt.bean.SEMMRT006Bean;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.FileUtil;
import th.co.ais.web.util.SelectItemLOVCacheUtil;

public class SEMMRT006Action extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 199952478390367960L;
	
	private Logger log = Logger.getLogger(getClass());

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		
		if (methodWithNavi.equalsIgnoreCase("doSearch")) {
			flag = doSearch();
		} else if (methodWithNavi.equalsIgnoreCase("doClear")) {
			flag = doClear();
		} else if (methodWithNavi.equalsIgnoreCase("pageLoad")) {
			flag = pageLoad();
		} else if (methodWithNavi.equalsIgnoreCase("doSave")) {
			flag = doSave();
		} else if (methodWithNavi.equalsIgnoreCase("initPopupUpload")) {
			flag = initPopupUpload();
		} else if (methodWithNavi.equalsIgnoreCase("doCreateAttachment")) {
			flag = doCreateAttachment();
		} else if (methodWithNavi.equalsIgnoreCase("initDelAttachment")) {
			flag = initDelAttachment();
		} else if (methodWithNavi.equalsIgnoreCase("doDelAttachment")) {
			flag = doDelAttachment();
		} else if (methodWithNavi.equalsIgnoreCase("doInitialForSearchRental")) {
			flag = doInitialForSearchRental();
		}else if(methodWithNavi.equalsIgnoreCase("getTreeNode")){
			getTreeNode();
		}else if(methodWithNavi.equalsIgnoreCase("doInitTodoList")){
			flag = this.doInitTodoList();
		}
		
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		semmrt006Bean = new SEMMRT006Bean();
		semmrt006Bean.setCriteria(new Mrt006Srch());
		semmrt006Bean.setReturnDpst(new ReturnDeposit());
		semmrt006Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmrt006Bean.setRegionList(getRegionItems());
		semmrt006Bean.setSiteTypeList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_SI_SITE_TYPE.name, EX_AND, "RT", null, null));
		semmrt006Bean.setDepositTypeList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_CT_DEPOSIT_TYPE.name));
		semmrt006Bean.setBgBankList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_CT_BG_BANK.name));
		semmrt006Bean.setReqTypeList(SelectItemLOVCacheUtil.getInstance().getLovItemsByTypeExceptLovCodes(ELovType.T_SI_APPROVE_TYPE.name, "07,08X,06,01,03,04,05"));
		semmrt006Bean.setExpenseTypeList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name, EX_IN, "DEPOSIT_RENT,DEPOSIT_ELECTRIC", null, null));
		semmrt006Bean.setReturnDpsStatusList(getEmptyDropDown());
		semmrt006Bean.setReturnDpsStatus2List(getEmptyDropDown());
		semmrt006Bean.setTreeUtilBean(new TreeUtilBean());
		setSemmrt006Bean(semmrt006Bean);
	}

	@Override
	public boolean validate() {
		boolean flag = true;
		String role = getSemmrt006Bean().getPopupRole();
		
		if (getSemmrt006Bean().getReturnDpst().getDepositType().equals("02") && getSemmrt006Bean().getReturnDpst().getReturnDepositStatus().equals("06")) {
			Double dpsReAmt = getSemmrt006Bean().getReturnDpst().getDepositReturnAmt();
			if (dpsReAmt == null || dpsReAmt.doubleValue() == 0) {
				// add msg error 
				addMessageError("incContent:frmSaveReDpst:errorReDpst", "W0001", msg("message.dpstReAmt"));	
				flag = false;
			}
		}
		
		String reDpsStatus = getSemmrt006Bean().getReturnDpst().getReturnDepositStatus();
		if (StringUtils.isEmpty(reDpsStatus)) {
			// add msg error
			addMessageError("incContent:frmSaveReDpst:errorReDpst", "W0001", msg("message.reDpstStatus"));
			flag = false;
		} else if ((reDpsStatus.equals("05") && role.equals("FN"))) {
			if (StringUtils.isEmpty(getSemmrt006Bean().getReturnDpst().getReason())) {
				// add msg error
				addMessageError("incContent:frmSaveReDpst:errorReDpst", "W0001", msg("message.reason"));
				flag = false;
			}
		} else if ((reDpsStatus.equals("07") && role.equals("AC"))) {
			if (StringUtils.isEmpty(getSemmrt006Bean().getReturnDpst().getDocClear())) {
				addMessageError("incContent:frmSaveReDpst:errorReDpst", "W0001", "Doc. Clear No");
				flag = false;
			}
			if (getSemmrt006Bean().getReturnDpst().getDocClearDt() == null) {
				addMessageError("incContent:frmSaveReDpst:errorReDpst", "W0001", "Doc. Clear Date");
				flag = false;
			}
		} else if ((reDpsStatus.equals("08") && role.equals("AC"))) {
			if (StringUtils.isEmpty(getSemmrt006Bean().getReturnDpst().getReason())) {
				// add msg error
				addMessageError("incContent:frmSaveReDpst:errorReDpst", "W0001", msg("message.reason"));
				flag = false;
			}
		}
		
		return flag;
	}
	
	private boolean validateSearch() {
		boolean flag = true;
		if(StringUtils.isEmpty(semmrt006Bean.getCriteria().getContractNo())){
			if (StringUtils.isEmpty(getSemmrt006Bean().getCriteria().getCompany())) {
				addMessageError("W0001", "Company");
				flag = false;
			}
		}
		
		return flag;
	}

	private SEMMRT006Bean semmrt006Bean;
	private FileUploadBean fileUploadBean;
	
	public FileUploadBean getFileUploadBean() {
		return (FileUploadBean)getFacesUtils().getSessionMapValue("fileUploadBean");
	}
	public void setFileUploadBean(FileUploadBean fileUploadBean) {
		this.fileUploadBean = fileUploadBean;
		getFacesUtils().setSessionMapValue("fileUploadBean", fileUploadBean);
	}

	public SEMMRT006Bean getSemmrt006Bean() {
		return (SEMMRT006Bean)getFacesUtils().getSessionMapValue("semmrt006Bean");
	}

	public void setSemmrt006Bean(SEMMRT006Bean semmrt006Bean) {
		this.semmrt006Bean = semmrt006Bean;
		getFacesUtils().setSessionMapValue("semmrt006Bean", semmrt006Bean);
	}
	
	public void getRowIdOnClick() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemmrt006Bean().setTmpRowId(rowId);
	}
	
	@SuppressWarnings("unchecked")
	private void searchReturnDeposit() {
		List<Mrt006Srch> to = null;
		
		if (semmrt006Bean.getCriteria().isChkPico()) {
			semmrt006Bean.getCriteria().setPicoFlag("Y");
		} else {
			semmrt006Bean.getCriteria().setPicoFlag("N");
		}
		
		try {
			IReturnDepositService service = (IReturnDepositService)getBean("returnDepositService");
			log.debug("getStrParam : "+semmrt006Bean.getCriteria().getStrParam());
			to = service.querySPList(EQueryName.SP_MRT006_SRCH.name, semmrt006Bean.getCriteria());
			if (to == null || to.isEmpty()) {
				// addMessageError("M0004");
				semmrt006Bean.setResultList(to);
				semmrt006Bean.setRenderedMsgDataNotFound(true);
			} else {
				semmrt006Bean.setRenderedMsgDataNotFound(false);
				for (Mrt006Srch temp : to) {
					temp.setBgStartDtTh(convertYearENtoTH(temp.getBgStartDt()));
					temp.setBgEndDtTh(convertYearENtoTH(temp.getBgEndDt()));
					temp.setBgReturnDtTh(convertYearENtoTH(temp.getBgReturnDt()));
					temp.setBgStartDtStr(getParameterDateStr(temp.getBgStartDtTh()));
					temp.setBgEndDtStr(getParameterDateStr(temp.getBgEndDtTh()));
				}
			}
			semmrt006Bean.setResultList(to);
		} catch (Exception e) {
			e.printStackTrace();
			semmrt006Bean.setRenderedMsgDataNotFound(true);
			semmrt006Bean.setResultList(to);
//			addMessageError("M0004");
		}
	}
	
	private boolean doSearch() {
		boolean flag = false;
		semmrt006Bean = getSemmrt006Bean();
		semmrt006Bean.setRenderedMsgFormSearch(true);
		
		if(semmrt006Bean.getCriteria().getStrParam() != null){
			// incase search from To Do List
				this.searchReturnDeposit();
				
		} else {
				if (validateSearch()) {
					searchReturnDeposit();
				}
		}
		
		setSemmrt006Bean(semmrt006Bean);
		return flag;
	}
	
	private boolean doClear() {
		boolean flag = false;
		semmrt006Bean = getSemmrt006Bean();
		semmrt006Bean.setRenderedMsgDataNotFound(false);
		semmrt006Bean.setCriteria(new Mrt006Srch());
		semmrt006Bean.setResultList(null);
		semmrt006Bean.setReturnDpsStatusList(getEmptyDropDown());
		//added by NEW 18/03/2015 for to do list page
		semmrt006Bean.setTreeUtilBean(new TreeUtilBean());
		semmrt006Bean.setRootNode(new TreeNodeImpl());
		semmrt006Bean.setMenuTreeMacroList(new ArrayList<WrapperBeanObject<MenuTreeSP>>());
		semmrt006Bean.setMenuTreePicoList(new ArrayList<WrapperBeanObject<MenuTreeSP>>());
		semmrt006Bean.setTreeMacroFlag(false);
		semmrt006Bean.setTreePicoFlag(false);
		setSemmrt006Bean(semmrt006Bean);
		return flag;
	}
	
	private ReturnDeposit getReturnDepositById(String returnDpstId) {
		IReturnDepositService service = (IReturnDepositService)getBean("returnDepositService");
		try {
			return service.queryByRowId(returnDpstId);
		} catch (Exception e) {
			return null;
		}
	}
	
	private List<SelectItem> getReturnDepositStatusDDL(String popupRole,String depositType,String returnDepositStatus) {
		IReturnDepositService service = (IReturnDepositService)getBean("returnDepositService");
		List<Mrt006DepositStatusDDL> to = null;
		List<SelectItem> listlov = new LinkedList<SelectItem>();
		SelectItem selItem = null;
		try {
			semmrt006Bean.setDepositStatus(new Mrt006DepositStatusDDL());
			semmrt006Bean.getDepositStatus().setRole(popupRole);
			semmrt006Bean.getDepositStatus().setDepositType(depositType);
			semmrt006Bean.getDepositStatus().setReturnDpsStatus(returnDepositStatus);
			
			to = service.querySPList(EQueryName.SP_MRT006_GET_DEPOSIT_STATUS_DDL.name, semmrt006Bean.getDepositStatus());
			if (to == null || to.isEmpty()) {
				// addMessageError("M0004");
//				semmrt006Bean.setResultList(to);
				semmrt006Bean.setRenderedMsgDataNotFound(true);
			} else {
				semmrt006Bean.setRenderedMsgDataNotFound(false);
				selItem = new SelectItem("" , msg("value.selectItem"));
				listlov.add(selItem);
				for (Mrt006DepositStatusDDL temp : to) {
					// Generate SelectItem
					if ((StringUtils.isNotEmpty(temp.getLovCode()))) {
						selItem = new SelectItem();
						selItem.setLabel(temp.getLovName());
						selItem.setValue(temp.getLovCode());
						listlov.add(selItem);
					}
				}
			}
//			semmrt006Bean.setResultList(to);
		//return service.queryByRowId(returnDpstId);
		} catch (Exception e) {
			return listlov;
		}
		return listlov;
	}
	
	private boolean pageLoad() {
		boolean flag = false;
		semmrt006Bean = getSemmrt006Bean();
		semmrt006Bean.setRenderedMsgFormSearch(false);
		semmrt006Bean.setPopupClose(false);

		// get parameter into bean return deposit
		String popupRole = (String)getFacesUtils().getRequestParameter("role");
		String expenseType = (String)getFacesUtils().getRequestParameter("expenseType");
		String company = (String)getFacesUtils().getRequestParameter("company");
		String returnDepositId = (String)getFacesUtils().getRequestParameter("returnDepositId");
		String depositDetailId = (String)getFacesUtils().getRequestParameter("depositDetailId");
		String siteInfoId = (String)getFacesUtils().getRequestParameter("siteInfoId");
		String contractNo = (String)getFacesUtils().getRequestParameter("contractNo");
		String depositType = (String)getFacesUtils().getRequestParameter("depositType");
		String depositAmt = (String)getFacesUtils().getRequestParameter("depositAmt");	
		String depositRentAmt = (String)getFacesUtils().getRequestParameter("depositRentAmt");
		String depositBalanceAmt = (String)getFacesUtils().getRequestParameter("depositBalanceAmt");
		String depositReturnAmt = (String)getFacesUtils().getRequestParameter("depositReturnAmt");
		String returnDepositStatus = (String)getFacesUtils().getRequestParameter("returnDepositStatus");
		
		if (returnDepositStatus.equals("07")) {
			semmrt006Bean.setDisReturnDpstStatus(true);
		} else {
			semmrt006Bean.setDisReturnDpstStatus(false);
		}
		
		semmrt006Bean.setReDpstContractNo(contractNo);
		if (depositType.equals("01")) {
			String bgNo = (String)getFacesUtils().getRequestParameter("bgNo");
			String bgBank = (String)getFacesUtils().getRequestParameter("bgBank");
			String bgStartDt = (String)getFacesUtils().getRequestParameter("bgStartDt");
			String bgEndDt = (String)getFacesUtils().getRequestParameter("bgEndDt");
			
			semmrt006Bean.setBgNo(bgNo);
			semmrt006Bean.setBgBank(bgBank);
			semmrt006Bean.setBgStartDt(parseParameterToDate(bgStartDt));
			semmrt006Bean.setBgEndDt(parseParameterToDate(bgEndDt));
		} else {
			// for expense type is cash
			if (StringUtils.isNotEmpty(depositRentAmt)) {
				semmrt006Bean.setReDpstRentAmt(new Double(depositRentAmt));
			}
			if (StringUtils.isNotEmpty(depositBalanceAmt)) {
				semmrt006Bean.setReDpstRentRetAmt(new Double(depositBalanceAmt));
			}
		}
		// set value role 
		semmrt006Bean.setPopupRole(popupRole);
		if (returnDepositId == null || StringUtils.isEmpty(returnDepositId)) {
			semmrt006Bean.setPopupMode("NEW");
			semmrt006Bean.setReturnDpst(new ReturnDeposit());
			semmrt006Bean.getReturnDpst().setExpenseType(expenseType);
			semmrt006Bean.getReturnDpst().setCompany(company);
			semmrt006Bean.getReturnDpst().setDepositDetailId(depositDetailId);
			semmrt006Bean.getReturnDpst().setSiteInfoId(siteInfoId);
			semmrt006Bean.getReturnDpst().setDepositType(depositType);
			if (StringUtils.isNotEmpty(depositAmt)) {
				semmrt006Bean.setReDpstAmt(new Double(depositAmt));
			}
			if (StringUtils.isNotEmpty(depositReturnAmt)) {
				semmrt006Bean.getReturnDpst().setDepositReturnAmt(new Double(depositReturnAmt));
			}
			
			// default value ReDpstStatus	
			semmrt006Bean.getReturnDpst().setReturnDepositStatus("01");
		} else {
			semmrt006Bean.setPopupMode("EDIT");
			if (StringUtils.isNotEmpty(depositAmt)) {
				semmrt006Bean.setReDpstAmt(new Double(depositAmt));
			}
			semmrt006Bean.setReturnDpst(getReturnDepositById(returnDepositId));
			
		}
		
		// check role
		semmrt006Bean.setReturnDpsStatusList(getReturnDepositStatusDDL(popupRole,depositType,returnDepositStatus));
		if(!returnDepositStatus.isEmpty())
			semmrt006Bean.getReturnDpst().setReturnDepositStatus(returnDepositStatus);
		if (popupRole.equals("SM")) {
			semmrt006Bean.setDisDpsReturnAmt(false);
			if (depositType.equals("01")) {
//				semmrt006Bean.setReturnDpsStatusList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_RT_RETURN_DPS_BG.name, EX_AND, "SM", null, null));
				semmrt006Bean.getReturnDpst().setDepositReturnAmt(semmrt006Bean.getReDpstAmt());
			} 
//			else if (depositType.equals("02")) {
//				// semmrt006Bean.setReturnDpsStatusList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_RT_RETURN_DPS_CASH.name, EX_AND, "SM", null, null));
//				// 20110315
//				if (returnDepositStatus.equals("01") || returnDepositStatus.equals("03")) {
//					semmrt006Bean.setReturnDpsStatusList(SelectItemLOVCacheUtil.getInstance().getLovItemsByTypeExceptLovCodes(ELovType.T_RT_RETURN_DPS_CASH.name, "02,04,05,06,07,08"));
//				} else if (returnDepositStatus.equals("02") || returnDepositStatus.equals("06") || returnDepositStatus.equals("08")) {
//					semmrt006Bean.setReturnDpsStatusList(SelectItemLOVCacheUtil.getInstance().getLovItemsByTypeExceptLovCodes(ELovType.T_RT_RETURN_DPS_CASH.name, "01,02,03,04,05,07,08"));
//				} else if (returnDepositStatus.equals("04") || returnDepositStatus.equals("05")) {
//					semmrt006Bean.setReturnDpsStatusList(SelectItemLOVCacheUtil.getInstance().getLovItemsByTypeExceptLovCodes(ELovType.T_RT_RETURN_DPS_CASH.name, "01,02,03,04,05,07,08"));
//				} else if (returnDepositStatus.equals("07")) {
//					semmrt006Bean.setReturnDpsStatusList(SelectItemLOVCacheUtil.getInstance().getLovItemsByTypeExceptLovCodes(ELovType.T_RT_RETURN_DPS_CASH.name, "01,02,03,04,05,06,08"));
//				}else{
//					semmrt006Bean.setReturnDpsStatusList(SelectItemLOVCacheUtil.getInstance().getLovItemsByTypeExceptLovCodes(ELovType.T_RT_RETURN_DPS_CASH.name, ""));
//				}
//			}
//		} else if (popupRole.equals("FN")) {
//			semmrt006Bean.setReturnDpsStatusList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_RT_RETURN_DPS_BG.name, EX_AND, "FN", null, null));
//		} else if (popupRole.equals("AC")) {
//			// semmrt006Bean.setReturnDpsStatusList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_RT_RETURN_DPS_CASH.name, EX_AND, "AC", null, null));
//			// 20110315
//			if (returnDepositStatus.equals("03")) {
//				semmrt006Bean.setReturnDpsStatusList(SelectItemLOVCacheUtil.getInstance().getLovItemsByTypeExceptLovCodes(ELovType.T_RT_RETURN_DPS_CASH.name, "01,02,03,06,07,08"));
//			} else if (returnDepositStatus.equals("04") || returnDepositStatus.equals("05")) {
//				semmrt006Bean.setReturnDpsStatusList(SelectItemLOVCacheUtil.getInstance().getLovItemsByTypeExceptLovCodes(ELovType.T_RT_RETURN_DPS_CASH.name, "01,02,03,06,07,08"));
//			} else if (returnDepositStatus.equals("06")) {
//				semmrt006Bean.setReturnDpsStatusList(SelectItemLOVCacheUtil.getInstance().getLovItemsByTypeExceptLovCodes(ELovType.T_RT_RETURN_DPS_CASH.name, "01,02,03,04,05,06"));
//			} else if (returnDepositStatus.equals("07")) {
//				semmrt006Bean.setReturnDpsStatusList(SelectItemLOVCacheUtil.getInstance().getLovItemsByTypeExceptLovCodes(ELovType.T_RT_RETURN_DPS_CASH.name, "01,02,03,04,05,06"));
//			}else{
//				semmrt006Bean.setReturnDpsStatusList(SelectItemLOVCacheUtil.getInstance().getLovItemsByTypeExceptLovCodes(ELovType.T_RT_RETURN_DPS_CASH.name, ""));
//			}
		}
		setSemmrt006Bean(semmrt006Bean);
		return flag;
	}
	
	private boolean doSave() {
		boolean flag = false;
		semmrt006Bean = getSemmrt006Bean();
		if (validate()) {
			IReturnDepositService service = (IReturnDepositService)getBean("returnDepositService");
			try {
				semmrt006Bean.getReturnDpst().setRecordStatus("Y");
				semmrt006Bean.getReturnDpst().setCurrentUser(getUserLogIn());
				ReturnDeposit reDpst = null;
				if (semmrt006Bean.getPopupMode().equals("NEW")) {
					service.createReturnDeposti(semmrt006Bean.getReturnDpst());
				} else if (semmrt006Bean.getPopupMode().equals("EDIT")) {
					service.updateReturnDeposit(semmrt006Bean.getReturnDpst());
				}
				
				Mrt006Save mrt006Save = new Mrt006Save();
				mrt006Save.setDpstDetailId(semmrt006Bean.getReturnDpst().getDepositDetailId());
				List<Mrt006Save> resultList = service.querySPList(EQueryName.SP_MRT006_SAVE.name, mrt006Save);
				if (resultList != null && resultList.size() != 0) {
					if (resultList.get(0).getResult().equals("Success")) {
						semmrt006Bean.setPopupClose(true);
						// display msg success!
						addMessageInfo("M0001");
						semmrt006Bean.setRenderedMsgFormSearch(true);
						searchReturnDeposit();
					}
				}
			} catch (Exception e) {
				addMessageError("incContent:frmSaveReDpst:errorReDpst", "E0001");
			}
		}
		setSemmrt006Bean(semmrt006Bean);
		return flag;
	}
	
	public void onChangeDdlDepositType() {
		semmrt006Bean = getSemmrt006Bean();
		
		if (semmrt006Bean.getCriteria().getDepositType().equals("01")) {
			semmrt006Bean.setReturnDpsStatus2List(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_RT_RETURN_DPS_BG.name));
		} else if (semmrt006Bean.getCriteria().getDepositType().equals("02")) {
			semmrt006Bean.setReturnDpsStatus2List(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_RT_RETURN_DPS_CASH.name));
		} else {
			semmrt006Bean.setReturnDpsStatus2List(getEmptyDropDown());
		}
		
		setSemmrt006Bean(semmrt006Bean);
	}
	
	private boolean initPopupUpload() {
		String returnDepositId = (String)getFacesUtils().getRequestParameter("returnDepositId");
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		semmrt006Bean = getSemmrt006Bean();
		semmrt006Bean.setPopupClose(false);
		semmrt006Bean.setMode(mode);
		semmrt006Bean.setRefId(returnDepositId);
		//clear attachment in data table
		getSemmrt006Bean().setAttachmentList(null);
		try {
			if(StringUtils.isNotEmpty(returnDepositId)){
				queryAttachmentByRefID(returnDepositId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmrt006Bean(semmrt006Bean);
		return false;
	}
	
	private void queryAttachmentByRefID(String refID) throws Exception{
		List<Attachment> attachmentList = new ArrayList<Attachment>();
		IAttachmentService atchService = (IAttachmentService)getBean("attachmentService");
		Attachment attachment = new Attachment();
		String tmpRefID = semmrt006Bean.getTmpAttachment().getRefferenceId();
		attachment.setRefferenceId(StringUtils.isEmpty(tmpRefID) ? refID : tmpRefID);
		attachmentList = atchService.queryAttachmentByCriteria(attachment);
		semmrt006Bean.setAttachmentList(attachmentList);
		//clear tmp.
		semmrt006Bean.setTmpAttachment(null);
	}
	
	public boolean doCreateAttachment() {
		boolean flag = false;
		//BG rowID.
		String refId = (String)getFacesUtils().getRequestParameter("refId");
		
		String filename = getFileUploadBean().getFileName();
    	String filePath = getFileUploadBean().getPathName();
    	semmrt006Bean = getSemmrt006Bean();
    	try {
        	
        	IAttachmentService atchService = (IAttachmentService)FacesUtils.getInstance().getBean("attachmentService");
        	Attachment attachment = new Attachment();
        	attachment.setAttachmentModule("RETURN_DEPOSIT");
        	attachment.setFileName(filename);
        	attachment.setRefferenceId(refId);
        	attachment.setAttachmentPath(filePath);
        	attachment.setCurrentUser(getSemmrt006Bean().getUserLogin());
			atchService.createAttachment(attachment);
			
			queryAttachmentByRefID(refId);
//			disabledUpload(refId);
			
			addMessageInfo("incContent:frmUploadFile:txtFileUpload", "M0001" , "");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				//remove file uploaded.
				FileUtil.getInstance().removeFile(filePath);
				addMessageError("incContent:frmUploadFile:txtFileUpload", "File upload failed with I/O error." ,"");
			} catch (IOException e1) {
				e1.printStackTrace();
				 //show error message.
	        	addMessageError("incContent:frmUploadFile:txtFileUpload", "(remove) File upload failed with I/O error." ,"");
			}
			 //show error message.
        	addMessageError("incContent:frmUploadFile:txtFileUpload", "File upload failed with I/O error.", "");
		}
    	setSemmrt006Bean(semmrt006Bean);
    	return flag;
    }
	
	public boolean initDelAttachment(){
		boolean flag = false;
		IAttachmentService atchService = (IAttachmentService)getBean("attachmentService");
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		semmrt006Bean = getSemmrt006Bean();
		try {
			Attachment attachment = atchService.getAttachmentByRowId(rowId);
			attachment.setCurrentUser(semmrt006Bean.getUserLogin());
			semmrt006Bean.setTmpAttachment(attachment);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmrt006Bean(semmrt006Bean);
		return flag;
	}
	
	private boolean doDelAttachment() {
		boolean flag = false;
		IAttachmentService atchService = (IAttachmentService)getBean("attachmentService");
		String refId = (String)getFacesUtils().getRequestParameter("refId");
		semmrt006Bean = getSemmrt006Bean();
		try {
			atchService.deleteAttachmentRecord(semmrt006Bean.getTmpAttachment());
			queryAttachmentByRefID(refId);
			addMessageInfo("incContent:frmUploadFile:txtFileUpload", "M0002" , "");
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError("incContent:frmUploadFile:txtFileUpload", "E0002" , "");
		}
		setSemmrt006Bean(semmrt006Bean);
		return flag;
	}
	
	public void chkDpstReturnAmt() {
		semmrt006Bean = getSemmrt006Bean();
		
		try {
			Double reDpstRentRetAmt = semmrt006Bean.getReDpstRentRetAmt();
			Double dpstReturnAmt = semmrt006Bean.getReturnDpst().getDepositReturnAmt();
			if (reDpstRentRetAmt.doubleValue() < dpstReturnAmt.doubleValue()) {
				addMessageError("incContent:frmUploadFile:txtFileUpload", "W0034" , "");
				semmrt006Bean.setDisBtnSave(true);
			} else {
				semmrt006Bean.setDisBtnSave(false);
			}
		} catch (Exception e) {
			semmrt006Bean.getReturnDpst().setDepositReturnAmt(null);
		}
		
		setSemmrt006Bean(semmrt006Bean);
	}
	
	
	// added by.. YUT
	public boolean doInitialForSearchRental() {
		log.info("::: SEMMRT006Action :: doInitialForSearchRental >> BEGIN :::");
		boolean flag = true;

		try {
			
//			this.init();

			semmrt006Bean = getSemmrt006Bean();

			String paramUrl = getFacesUtils().getRequestParameter("paramUrl") == null ? "" : (String) getFacesUtils().getRequestParameter("paramUrl");
	        String paramMenuGroup = getFacesUtils().getRequestParameter("paramMenuGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuGroup");
	        String paramMenuSubGroup = getFacesUtils().getRequestParameter("paramMenuSubGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuSubGroup");
	        String paramParameter = getFacesUtils().getRequestParameter("paramParameter") == null ? "" : (String) getFacesUtils().getRequestParameter("paramParameter");
	        
	        System.out.println("paramUrl: " + paramUrl);
	        System.out.println("paramMenuGroup: " + paramMenuGroup);
	        System.out.println("paramMenuSubGroup: " + paramMenuSubGroup);
	        System.out.println("paramParameter: " + paramParameter);
	        
	        semmrt006Bean.getCriteria().setStrParam(paramParameter);
	        semmrt006Bean.setRenderedOnToDoList(true); //

			setSemmrt006Bean(semmrt006Bean);
			
			this.doSearch();

		} catch(Exception e) {
			e.printStackTrace();
			addMessageError("EL0000", "SEMMRT006Action");
			flag = false;
			
		} finally {
			log.info("::: SEMMRT006Action :: doInitialForSearchRental >> END :::");
		}
		return flag;
	}
	
	public boolean doInitTodoList(){
		boolean flag = true;
		try{
			semmrt006Bean = getSemmrt006Bean();
			loadTree();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			flag = false;
		}finally{
//			setSemmrt001Bean(semmrt001Bean);
		}
		return flag;
	}
	
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// menu util >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	private TreeNode rootNode = null;
    private List<String> selectedNodeChildren = new ArrayList<String>();    
    
    private String nodeTitle;
    private MenuTreeSP nodeValue;
    private MenuTreeSP menuRoot;
    
    private void loadTree() {
    	semmrt006Bean = getSemmrt006Bean();
    	semmrt006Bean.setTreeMacroFlag(false);
    	semmrt006Bean.setTreePicoFlag(false);
    	TreeUtilBean myParam = new TreeUtilBean();
    	List<Object> mySendList = new ArrayList<Object>();
    	String searchFlag;
    	searchFlag = getFacesUtils().getRequestParameter("searchFlag") == null ? "" : (String) getFacesUtils().getRequestParameter("searchFlag");
    	String backWard = getFacesUtils().getRequestParameter("backWard") == null ? "" : (String) getFacesUtils().getRequestParameter("backWard");
    	IMenuTreeService service = (IMenuTreeService)getBean("menuTreeService");
    	
    	String groupType = "RD";
        try {

        	//// >>
        	if("Y".equals(searchFlag)){
        		List<MenuTreeSP> menuTreeList = null;
        		semmrt006Bean.getTreeUtilBean().setMenuGroup(groupType);
        		semmrt006Bean.getTreeUtilBean().setUserLogin(getUserLogIn());
        		if(!semmrt006Bean.getTreeUtilBean().getCompany().equals("") && !semmrt006Bean.getTreeUtilBean().getRegion().equals("")){
        			if(!semmrt006Bean.getTreeUtilBean().getMenuSubGroup().equals("")){
            			menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name, semmrt006Bean.getTreeUtilBean());
            			
        				Map<String, Object> myMap = new HashMap<String, Object>();
        				
        				if(menuTreeList != null && !menuTreeList.isEmpty()){
        			
        					/// >
        					for(int j=0; j<menuTreeList.size(); j++){
        						String mLevel = menuTreeList.get(j).getMenuLevel();
        						myMap.put(mLevel, menuTreeList.get(j));
        					}
        					mySendList.add(myMap);
        					/// <
        					
        				}
            		}else{
            			for(int i = 0;i<2;i++){
        					if(i==0){
        						semmrt006Bean.getTreeUtilBean().setMenuSubGroup("M");
        					}
            			
    	        			menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name, semmrt006Bean.getTreeUtilBean());
    	        			
    	    				Map<String, Object> myMap = new HashMap<String, Object>();
    	    				
    	    				if(menuTreeList != null && !menuTreeList.isEmpty()){
    	    			
    	    					/// >
    	    					for(int j=0; j<menuTreeList.size(); j++){
    	    						String mLevel = menuTreeList.get(j).getMenuLevel();
    	    						myMap.put(mLevel, menuTreeList.get(j));
    	    					}
    	    					mySendList.add(myMap);
    	    					/// <
    	    					
    	    				}
    	    				semmrt006Bean.getTreeUtilBean().setMenuSubGroup("P");
    	        		}
            			semmrt006Bean.getTreeUtilBean().setMenuSubGroup("");
            		}
        		}else{
        			validateToDoList();
        		}	
        	}else{
        		if("Y".equals(backWard)){
            		List<MenuTreeSP> menuTreeList = null;
            		semmrt006Bean.getTreeUtilBean().setMenuGroup(groupType);
            		semmrt006Bean.getTreeUtilBean().setUserLogin(getUserLogIn());
            		if(!semmrt006Bean.getTreeUtilBean().getCompany().equals("") && !semmrt006Bean.getTreeUtilBean().getRegion().equals("")){
            			if(!semmrt006Bean.getTreeUtilBean().getMenuSubGroup().equals("")){
                			menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name, semmrt006Bean.getTreeUtilBean());
                			
            				Map<String, Object> myMap = new HashMap<String, Object>();
            				
            				if(menuTreeList != null && !menuTreeList.isEmpty()){
            			
            					/// >
            					for(int j=0; j<menuTreeList.size(); j++){
            						String mLevel = menuTreeList.get(j).getMenuLevel();
            						myMap.put(mLevel, menuTreeList.get(j));
            					}
            					mySendList.add(myMap);
            					/// <
            					
            				}
                		}else{
                			for(int i = 0;i<2;i++){
            					if(i==0){
            						semmrt006Bean.getTreeUtilBean().setMenuSubGroup("M");
            					}
                			
        	        			menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name, semmrt006Bean.getTreeUtilBean());
        	        			
        	    				Map<String, Object> myMap = new HashMap<String, Object>();
        	    				
        	    				if(menuTreeList != null && !menuTreeList.isEmpty()){
        	    			
        	    					/// >
        	    					for(int j=0; j<menuTreeList.size(); j++){
        	    						String mLevel = menuTreeList.get(j).getMenuLevel();
        	    						myMap.put(mLevel, menuTreeList.get(j));
        	    					}
        	    					mySendList.add(myMap);
        	    					/// <
        	    					
        	    				}
        	    				semmrt006Bean.getTreeUtilBean().setMenuSubGroup("P");
        	        		}
                			semmrt006Bean.getTreeUtilBean().setMenuSubGroup("");
                		}
            		}else{
            			validateToDoList();
            		}
        		}else{
        			semmrt006Bean.setTreeUtilBean(new TreeUtilBean());
            		setSemmrt006Bean(semmrt006Bean);
        		}
        		
        	}
        	semmrt006Bean.setRootNode(new TreeNodeImpl());
    		addNodes(semmrt006Bean, mySendList);
        	//// <<
    		
        } catch (Exception e) {
            throw new FacesException(e.getMessage(), e);
        } finally {
        	//semmrt001Bean = getSemmrt001Bean();
        	myParam = null;
        	mySendList = null;
        	searchFlag = null;
        	service = null;
        	backWard = null;
        	groupType = null;  
        }
    }
    
    public void validateToDoList(){
    	try{
    		semmrt006Bean = getSemmrt006Bean();
    		if(semmrt006Bean.getTreeUtilBean().getCompany().equals("")){
    			addMessageErrorWithArgument("W0001",msg("message.company"));
    		}
    		if(semmrt006Bean.getTreeUtilBean().getRegion().equals("")){
    			addMessageErrorWithArgument("W0001",msg("message.region"));
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
			// TODO: handle exception
		}
    }

    @SuppressWarnings({ "unused", "unchecked" })
	private void addNodes(SEMMRT006Bean semmrt006Bean, List<Object> propList) {
    	
    	for(int i=0; i<propList.size(); i++) {
    		List<WrapperBeanObject<MenuTreeSP>> menuTreeWrapList = new ArrayList<WrapperBeanObject<MenuTreeSP>>();
        	// >>
    		Map<String, Object> map = (Map<String, Object>) propList.get(i);
    		
    		int mapSize = map.keySet().size();
    		Object[] mapArr = map.keySet().toArray();
    		
    		// for sorting
    		Object[] mapArr_ = map.keySet().toArray();
    		Arrays.sort(mapArr_);
    		// <<
    		
			MenuTreeSP myParent = new MenuTreeSP();
			
			String _MENU_LABEL = "";
//			
			String parent1 = mapArr_[i].toString();	// get key by sorting
			
			MenuTreeSP mapObj1 =  (MenuTreeSP) map.get(parent1);
			
			if(mapObj1.getMenuSubGroup().equals("M")){
				_MENU_LABEL = "Site Info Non PICO";
				
				if(mapObj1.getRegion() != null){
					_MENU_LABEL = _MENU_LABEL+" "+mapObj1.getRegion();
				}
				
				if(mapObj1.getCompany() != null){
					_MENU_LABEL = _MENU_LABEL+" "+mapObj1.getCompany();
				}
				
				for(int x=0; x<mapSize; x++){
	    			TreeNodeImpl<MenuTreeSP> child = new TreeNodeImpl<MenuTreeSP>();
	    			
	    			String parentNode = mapArr_[x].toString();	// get key by sorting
	    			
	    			MenuTreeSP mapObj =  (MenuTreeSP) map.get(parentNode);

//	    			 2015/01/30 fixed.. dynamic URL
	    			String myUrl = mapObj.getMenuUrl() == null ? "SEMMRT006-0" : mapObj.getMenuUrl().toString();
	    			String myAction = myUrl.substring(0, myUrl.length() - 2);
	    			mapObj.setMenuUrl(myUrl);
	    			mapObj.setMenuAction(myAction);
//	    			// fixed.. dynamic URL
//	    			
					WrapperBeanObject<MenuTreeSP> tmpWrapperBean = new WrapperBeanObject<MenuTreeSP>();
					tmpWrapperBean.setDataObj(mapObj);
					tmpWrapperBean.setMessage("");
					menuTreeWrapList.add(tmpWrapperBean);
	        	}
				semmrt006Bean.setHeaderTreeMacro(_MENU_LABEL);
				semmrt006Bean.setTreeMacroFlag(true);
				semmrt006Bean.setMenuTreeMacroList(menuTreeWrapList);
			}else if(mapObj1.getMenuSubGroup().equals("P")){
				_MENU_LABEL = "Site Info Pico";
								
				if(mapObj1.getRegion() != null){
					_MENU_LABEL = _MENU_LABEL+" "+mapObj1.getRegion();
				}
				
				if(mapObj1.getCompany() != null){
					_MENU_LABEL = _MENU_LABEL+" "+mapObj1.getCompany();
				}
				
				for(int x=0; x<mapSize; x++){
	    			TreeNodeImpl<MenuTreeSP> child = new TreeNodeImpl<MenuTreeSP>();
	    			
	    			String parentNode = mapArr_[x].toString();	// get key by sorting
	    			
	    			MenuTreeSP mapObj =  (MenuTreeSP) map.get(parentNode);

//	    			2015/01/30 fixed.. dynamic URL
	    			String myUrl = mapObj.getMenuUrl() == null ? "SEMMRT006-0" : mapObj.getMenuUrl().toString();
	    			String myAction = myUrl.substring(0, myUrl.length() - 2);
	    			mapObj.setMenuUrl(myUrl);
	    			mapObj.setMenuAction(myAction);
//	    			// fixed.. dynamic URL
	    			
					WrapperBeanObject<MenuTreeSP> tmpWrapperBean = new WrapperBeanObject<MenuTreeSP>();
					tmpWrapperBean.setDataObj(mapObj);
					tmpWrapperBean.setMessage("");
					menuTreeWrapList.add(tmpWrapperBean);
	        	}
				semmrt006Bean.setHeaderTreePico(_MENU_LABEL);
				semmrt006Bean.setTreePicoFlag(true);
				semmrt006Bean.setMenuTreePicoList(menuTreeWrapList);
			}
    		// <<
    		
    		setSemmrt006Bean(semmrt006Bean);
    	}
    }
    
    public void processSelection(NodeSelectedEvent event) {
        HtmlTree tree = (HtmlTree) event.getComponent();
        nodeTitle = ((MenuTreeSP)tree.getRowData()).toString();
        nodeValue = (MenuTreeSP) tree.getRowData();

        selectedNodeChildren.clear();
        
        TreeNode currentNode = tree.getModelTreeNode(tree.getRowKey());
        if (currentNode.isLeaf()){
            selectedNodeChildren.add(((MenuTreeSP)currentNode.getData()).toString());
            System.out.println("selected node Child [y]: " + ((MenuTreeSP)currentNode.getData()).toString());
        }else
        {
            Iterator<Map.Entry<Object, TreeNode>> it = currentNode.getChildren();
            while (it!=null &&it.hasNext()) {
                Map.Entry<Object, TreeNode> entry = it.next();
                selectedNodeChildren.add(entry.getValue().getData().toString());
                System.out.println("selected nod Parent have Childred [x]: " + entry.getValue().getData().toString());
            }
        }
        
        
    }
    
    // fixed 2015/01/27
    public boolean nodeExpandAll(UITree tree) {  
    	// can do something
    	return true;
    }
    
    public TreeNode getTreeNode() {
    	semmrt006Bean = getSemmrt006Bean();
    	String searchFlag = getFacesUtils().getRequestParameter("searchFlag") == null ? "" : (String)getFacesUtils().getRequestParameter("searchFlag");
        if (semmrt006Bean.getRootNode() == null || "Y".equals(searchFlag)) {
            loadTree();
        }
        
        return semmrt006Bean.getRootNode();
    }

    public String getNodeTitle() {
        return nodeTitle;
    }

    public void setNodeTitle(String nodeTitle) {
        this.nodeTitle = nodeTitle;
    }
    
    public MenuTreeSP getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(MenuTreeSP nodeValue) {
        this.nodeValue = nodeValue;
    }
    
    public MenuTreeSP getMenuRoot() {
        return menuRoot;
    }

    public void setMenuRoot(MenuTreeSP menuRoot) {
        this.menuRoot = menuRoot;
    }
}
