package th.co.ais.web.mm.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.richfaces.component.UITree;
import org.richfaces.component.html.HtmlTree;
import org.richfaces.event.NodeSelectedEvent;
import org.richfaces.model.TreeNode;
import org.richfaces.model.TreeNodeImpl;

import sap.client.service.call.WsClientService;
import th.co.ais.common.service.IMenuTreeService;
import th.co.ais.domain.common.MenuTreeSP;
import th.co.ais.domain.gm.ApproveBookBankAct;
import th.co.ais.domain.mm.ItemMasterSP;
import th.co.ais.domain.mm.ItemParamsSP;
import th.co.ais.domain.mm.ItemResultSP;
import th.co.ais.domain.mm.Mmm001SAPVendorSP;
import th.co.ais.domain.mm.Mmm001VendorMasterSP;
import th.co.ais.domain.mm.Mmm001VendorSP;
import th.co.ais.domain.mm.Mmm002ContractSP;
import th.co.ais.domain.mm.MmmVendorMasterInfoSP;
import th.co.ais.service.gm.IVendorMasterService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMConstant;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.mm.bean.SEMMMM001Bean;
import th.co.ais.web.mm.bean.SEMMMM002Bean;

public class SEMMMM002Action extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 516895929658686329L;
	
	private Logger LOG = Logger.getLogger(getClass());
	
	private SEMMMM002Bean semmmm002Bean;
	private SEMMMM002Action semmmm002Action;

	public SEMMMM002Bean getSemmmm002Bean() {
		//return (SEMMMM002Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmmm002Bean");
		
		SEMMMM002Bean semmmm002Bean = (SEMMMM002Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmmm002Bean");
		if(semmmm002Bean == null)
			semmmm002Bean = new SEMMMM002Bean();
		return semmmm002Bean;
	}

	public void setSemmmm002Bean(SEMMMM002Bean semmmm002Bean) {
		this.semmmm002Bean = semmmm002Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmmm002Bean", semmmm002Bean);
	}

	public SEMMMM002Action getSemmmm002Action() {
		return (SEMMMM002Action)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmmm002Action");
	}

	public void setSemmmm002Action(SEMMMM002Action semmmm002Action) {
		this.semmmm002Action = semmmm002Action;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmmm002Bean", semmmm002Action);
	}

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		LOG.info("::: SEMMMM002Action :: actionWithNavi >> BEGIN :::");
		boolean flag = false;
		
		try {
			
			// --
			semmmm002Bean = getSemmmm002Bean();
			
        	// --
			
			if(methodWithNavi.equalsIgnoreCase("pageLoad")) {
				flag = this.pageLoad(); 
			} else if(methodWithNavi.equalsIgnoreCase("doSearch")) {
				flag = this.doSearch(); 
			} else if(methodWithNavi.equalsIgnoreCase("doClear")) {
				flag = this.doClear();	
			} else if(methodWithNavi.equalsIgnoreCase("doApprove")) {
				flag = this.doApprove();	
			} else if(methodWithNavi.equalsIgnoreCase("doSendToMNG2")) {
				flag = this.doSendToMNG2();	
			} else if(methodWithNavi.equalsIgnoreCase("doManageBtn")) {
				flag = this.doManageBtn();	
			} else if(methodWithNavi.equalsIgnoreCase("initReject")) {
				flag = this.initReject();	
			} else if(methodWithNavi.equalsIgnoreCase("doReject")) {
				flag = this.doReject();	
			}else if(methodWithNavi.equalsIgnoreCase("processSelectedMenu")) {
				flag = this.processSelectedMenu();	
			}else if(methodWithNavi.equalsIgnoreCase("doSearchTree")){
				flag = this.doSearchTree();
			}else if(methodWithNavi.equalsIgnoreCase("doViewVendor")){
				flag = this.doViewVendor();
			}else if(methodWithNavi.equalsIgnoreCase("searchTodoList")){
				flag = this.searchTodoList();
			}else if(methodWithNavi.equalsIgnoreCase("doValidateApprove")){
				flag = this.doValidateApprove();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMMM002Action");
			flag = false;
			
			setSemmmm002Bean(semmmm002Bean);
		} finally {
			LOG.info("::: SEMMMM002Action :: actionWithNavi >> END :::");
		}
		return flag;
	}

	@Override
	public void init() {
		LOG.info("::: SEMMMM002Action :: init >> BEGIN :::");
		
		SEMMMM002Bean semmmm002Bean = new SEMMMM002Bean();
		String navProgram = (String)getFacesUtils().getRequestParameter("navProgram");
		try {
						
			semmmm002Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
			semmmm002Bean.setExpenseTypeList(getLovItemsByType(ELovType.T_SAP_CT_EXPENSE_TYPE.name));
			semmmm002Bean.setBankList(getLovItemsByType(ELovType.T_CT_BG_BANK.name));
			semmmm002Bean.setVendorStatusList(getLovItemsByType(ELovType.T_MM_SAP_VENDOR_STATUS.name));
//			semmmm002Bean.setBookbankStatusList(getLovItemsByType(ELovType.T_CT_BOOKBANK_STATUS.name));
			semmmm002Bean.setPayeeStatusList(getLovItemsByType(ELovType.T_CT_PAYEE_STATUS.name));
//			semmmm002Bean.setBookbankPayeeStatusList(getLovItemsByType(ELovType.T_CT_PAYEE_BOOKBANK_STATUS.name));
			semmmm002Bean.setRegionList(getRegionCheckList());
			
			semmmm002Bean.setDisableBtnApproveVendor(true);
			semmmm002Bean.setDisableBtnRejectVendor(true);
			semmmm002Bean.setDisableBtnSendVendorToMNG2(true);
			semmmm002Bean.setDisableBtnMNG2ApproveVendor(true);
			semmmm002Bean.setDisableBtnMNG2RejectVendor(true);
			
			semmmm002Bean.setDisableBtnApproveBookbank(true);
			semmmm002Bean.setDisableBtnRejectBookbank(true);
			semmmm002Bean.setDisableBtnSendBookbankToMNG2(true);
			semmmm002Bean.setDisableBtnMNG2ApproveBookbank(true);
			semmmm002Bean.setDisableBtnMNG2RejectBookbank(true);
			
			semmmm002Bean.setDisableBtnApprovePayee(true);
			semmmm002Bean.setDisableBtnRejectPayee(true);
			semmmm002Bean.setDisableBtnSendPayeeToMNG2(true);
			semmmm002Bean.setDisableBtnMNG2ApprovePayee(true);
			semmmm002Bean.setDisableBtnMNG2RejectPayee(true);
			
			semmmm002Bean.setDisableBtnApprovePayeeBookbank(true);
			semmmm002Bean.setDisableBtnRejectPayeeBookbank(true);
			semmmm002Bean.setDisableBtnSendPayeeBookbankToMNG2(true);
			semmmm002Bean.setDisableBtnMNG2ApprovePayeeBookbank(true);
			semmmm002Bean.setDisableBtnMNG2RejectPayeeBookbank(true);
			
			semmmm002Bean.setTeamList(getEmptyDropDown());
			semmmm002Bean.setTeamList(getLovItemsByType(ELovType.T_SA_TEAM_LIST.name));
			semmmm002Bean.setRenderedTodoRejectButton(false);
			
			//added by NEW 2017/07/24
			semmmm002Bean.setVendorFlowStatusList(getLovItemsByType(ELovType.T_MM_SAP_VENDOR_FLOW_STATUS.name));
			semmmm002Bean.setBookbankFlowStatusList(getLovItemsByType(ELovType.T_MM_SAP_BOOKBANK_FLOW_STATUS.name));
			semmmm002Bean.setPayeeFlowStatusList(getLovItemsByType(ELovType.T_MM_SAP_PAYEE_FLOW_STATUS.name));
			semmmm002Bean.setBookbankPayeeFlowStatusList(getLovItemsByType(ELovType.T_MM_SAP_BP_FLOW_STATUS.name));
			semmmm002Bean.setBlockStatusList(getLovItemsByType(ELovType.T_MM_SAP_BLOCK_STATUS.name));
			semmmm002Bean.setBlackListStatusList(getLovItemsByType(ELovType.T_MM_SAP_BLACKLIST_STATUS.name));
			semmmm002Bean.setBookbankStatusList(getLovItemsByType(ELovType.T_MM_SAP_BOOKBANK_STATUS.name));
			semmmm002Bean.setPayeeStatusList(getLovItemsByType(ELovType.T_MM_SAP_PAYEE_STATUS.name));
			semmmm002Bean.setBookbankPayeeStatusList(getLovItemsByType(ELovType.T_MM_SAP_BOOKBANK_STATUS.name));
			
			semmmm002Bean.setChkVendorType(true);
			semmmm002Bean.setChkPayeeType(true);
			
			setSemmmm002Bean(semmmm002Bean);
			
			if(StringUtils.equals("SEMMMM002-0", navProgram)){
				this.loadTree();
				this.doSelectTeam();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMMM002Action");
		} finally {
			setSemmmm002Bean(semmmm002Bean);
			LOG.info("::: SEMMMM002Action :: init >> END :::");
		}
	}
	
	// ---------------------------------------------------------------------------------
	@SuppressWarnings("unchecked")
	private List<SelectItem> getRegionCheckList() {
		LOG.info("::: SEMMMM001Action :: masterRegionList >> BEGIN :::");
		
		IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
		List<SelectItem> ret = new ArrayList<SelectItem>();
		List<ItemMasterSP> resp = null; 
		SelectItem itemRet = null;
		
		try {
			resp = service.getRegionMasterCheckList(EQueryName.SEM_SAP_REGION_CHECK_LIST.name);
			
			if (null == resp || resp.isEmpty()) {
				ret = new ArrayList<SelectItem>();
				resp = new ArrayList<ItemMasterSP>();
			} else {
				for (ItemMasterSP object : resp){
					itemRet = new SelectItem();
					itemRet.setValue(object.getRowId());
					itemRet.setDescription(object.getLabel());
					itemRet.setLabel(object.getLabel());
					
					ret.add(itemRet);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			LOG.info("::: SEMMMM001Action :: masterRegionList >> END :::");
		}
		return ret;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	// ---------------------------------------------------------------------------------
	public void selectAllRow(){
		LOG.info("::: SEMMMM002Action :: selectAllRow >> BEGIN :::");
		String actionType = "";
		ArrayList selectedIdList = new ArrayList();
		try{
			semmmm002Bean = getSemmmm002Bean();
			
			boolean chkAll = semmmm002Bean.isChkSelAll();
			List<WrapperBeanObject<Mmm001VendorMasterSP>> vendorResultList = new ArrayList<WrapperBeanObject<Mmm001VendorMasterSP>>();
			vendorResultList = semmmm002Bean.getVendorMasterResultList();
			
			if(vendorResultList != null){
				for(int i = 0; i < vendorResultList.size(); i++) {
					Mmm001VendorMasterSP o = (Mmm001VendorMasterSP) vendorResultList.get(i).getDataObj();
					if (StringUtils.isNotEmpty(o.getRowId())) {
						
						if(o.getActionType() != null){
							if("".equals(actionType)){
								actionType = o.getActionType();
							}
							
							if(!actionType.equals(o.getActionType())){
//								semmmm002Bean.setDisableBtnApprove(true);
//								semmmm002Bean.setDisableBtnSendToMNG2(true);
//								semmmm002Bean.setDisableBtnReject(true);
//								return;
							}
//							
//							if("VD".equals(actionType)){
//								selectedIdList.add(o.getVendorId());
//								semmmm002Bean.setFlowStatus(o.getVendorFlowStatus());
//							}else if("VB".equals(actionType)){
//								selectedIdList.add(o.getVendorBookbankId());
//								semmmm002Bean.setFlowStatus(o.getAccountFlowStatus());
//							}else if("PY".equals(actionType)){
//								selectedIdList.add(o.getPayeeId());
//								semmmm002Bean.setFlowStatus(o.getPayeeFlowStatus());
//							}else if("PB".equals(actionType)){
//								selectedIdList.add(o.getPayeeBookbankId());
//								semmmm002Bean.setFlowStatus(o.getPayeeAccountFlowStatus());
//							}
							
						}
						semmmm002Bean.setActionType(actionType);
//						semmmm002Bean.setSelectIdList(selectedIdList);
						vendorResultList.get(i).setCheckBox(chkAll);
					}
				}
				setSemmmm002Bean(semmmm002Bean);
				
				this.onEnableButton();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMMM002Action");
		} finally {
			setSemmmm002Bean(semmmm002Bean);
			LOG.info("::: SEMMMM002Action :: selectAllRow >> END :::");
		}
	}
	
	public void selectRow(){
		LOG.info("::: SEMMMM002Action :: selectRow >> BEGIN :::");
		boolean isCheck = false;
		String actionType = "";
		ArrayList selectedIdList = new ArrayList();
		try{
			semmmm002Bean = getSemmmm002Bean();
			
			List<WrapperBeanObject<Mmm001VendorMasterSP>> vendorResultList = new ArrayList<WrapperBeanObject<Mmm001VendorMasterSP>>();
			vendorResultList = semmmm002Bean.getVendorMasterResultList();
			
			int tblRecords = vendorResultList.size();
			int chkRecords = 0;
			
			for (WrapperBeanObject<Mmm001VendorMasterSP> wrapperBeanObject : vendorResultList) {
				if(wrapperBeanObject.isCheckBox()){
					Mmm001VendorMasterSP o = (Mmm001VendorMasterSP) wrapperBeanObject.getDataObj();
					if (StringUtils.isNotEmpty(o.getRowId())) {
						
						if(o.getActionType() != null){
							if("".equals(actionType)){
								actionType = o.getActionType();
							}
							
							if(!actionType.equals(o.getActionType())){
//								semmmm002Bean.setDisableBtnApprove(true);
//								semmmm002Bean.setDisableBtnSendToMNG2(true);
//								semmmm002Bean.setDisableBtnReject(true);
//								return;
							}
							
//							if("VD".equals(actionType)){
//								selectedIdList.add(o.getVendorId());
//								semmmm002Bean.setFlowStatus(o.getVendorFlowStatus());
//							}else if("VB".equals(actionType)){
//								selectedIdList.add(o.getBookbankId());
//								semmmm002Bean.setFlowStatus(o.getAccountFlowStatus());
//							}else if("PY".equals(actionType)){
//								selectedIdList.add(o.getPayeeId());
//								semmmm002Bean.setFlowStatus(o.getPayeeFlowStatus());
//							}else if("PB".equals(actionType)){
//								selectedIdList.add(o.getPayeeBookbankId());
//								semmmm002Bean.setFlowStatus(o.getPayeeAccountFlowStatus());
//							}
							
						}
						semmmm002Bean.setActionType(actionType);
//						semmmm002Bean.setSelectIdList(selectedIdList);
//						vendorResultList.get(i).setCheckBox(chkAll);
					}
					
					chkRecords++;
				}
			}
			
			if(chkRecords == 0){
				semmmm002Bean.setDisableBtnApproveVendor(true);
				semmmm002Bean.setDisableBtnRejectVendor(true);
				semmmm002Bean.setDisableBtnSendVendorToMNG2(true);
				semmmm002Bean.setDisableBtnMNG2ApproveVendor(true);
				semmmm002Bean.setDisableBtnMNG2RejectVendor(true);
				
				semmmm002Bean.setDisableBtnApproveBookbank(true);
				semmmm002Bean.setDisableBtnRejectBookbank(true);
				semmmm002Bean.setDisableBtnSendBookbankToMNG2(true);
				semmmm002Bean.setDisableBtnMNG2ApproveBookbank(true);
				semmmm002Bean.setDisableBtnMNG2RejectBookbank(true);
				
				semmmm002Bean.setDisableBtnApprovePayee(true);
				semmmm002Bean.setDisableBtnRejectPayee(true);
				semmmm002Bean.setDisableBtnSendPayeeToMNG2(true);
				semmmm002Bean.setDisableBtnMNG2ApprovePayee(true);
				semmmm002Bean.setDisableBtnMNG2RejectPayee(true);
				
				semmmm002Bean.setDisableBtnApprovePayeeBookbank(true);
				semmmm002Bean.setDisableBtnRejectPayeeBookbank(true);
				semmmm002Bean.setDisableBtnSendPayeeBookbankToMNG2(true);
				semmmm002Bean.setDisableBtnMNG2ApprovePayeeBookbank(true);
				semmmm002Bean.setDisableBtnMNG2RejectPayeeBookbank(true);
				
				//for to do list page
				
				semmmm002Bean.setRenderedBtnApproveVendor(false);
				semmmm002Bean.setRenderedBtnRejectVendor(false);
				semmmm002Bean.setRenderedBtnSendVendorToMNG2(false);
				semmmm002Bean.setRenderedBtnMNG2ApproveVendor(false);
				semmmm002Bean.setRenderedBtnMNG2RejectVendor(false);
				
				semmmm002Bean.setRenderedBtnApproveBookbank(false);
				semmmm002Bean.setRenderedBtnRejectBookbank(false);
				semmmm002Bean.setRenderedBtnSendBookbankToMNG2(false);
				semmmm002Bean.setRenderedBtnMNG2ApproveBookbank(false);
				semmmm002Bean.setRenderedBtnMNG2RejectBookbank(false);
				
				semmmm002Bean.setRenderedBtnApprovePayee(false);
				semmmm002Bean.setRenderedBtnRejectPayee(false);
				semmmm002Bean.setRenderedBtnSendPayeeToMNG2(false);
				semmmm002Bean.setRenderedBtnMNG2ApprovePayee(false);
				semmmm002Bean.setRenderedBtnMNG2RejectPayee(false);
				
				semmmm002Bean.setRenderedBtnApprovePayeeBookbank(false);
				semmmm002Bean.setRenderedBtnRejectPayeeBookbank(false);
				semmmm002Bean.setRenderedBtnSendPayeeBookbankToMNG2(false);
				semmmm002Bean.setRenderedBtnMNG2ApprovePayeeBookbank(false);
				semmmm002Bean.setRenderedBtnMNG2RejectPayeeBookbank(false);
			}
			
			if(tblRecords != 0 && tblRecords == chkRecords){
				semmmm002Bean.setChkSelAll(true);
			} else {
				semmmm002Bean.setChkSelAll(false);
			}
			setSemmmm002Bean(semmmm002Bean);
			 
			this.onEnableButton();
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMMM002Action");
		} finally {
			setSemmmm002Bean(semmmm002Bean);
			LOG.info("::: SEMMMM002Action :: selectRow >> END :::");
		}
	}
	
	public void onEnableButton() {
		LOG.info("::: SEMMMM002Action :: onEnableButton >> BEGIN :::");
		
		try {
			semmmm002Bean = getSemmmm002Bean();
			
			List<WrapperBeanObject<Mmm001VendorMasterSP>> resultList = new ArrayList<WrapperBeanObject<Mmm001VendorMasterSP>>();
			resultList = semmmm002Bean.getVendorMasterResultList();
			
			int chkRecords = 0;
			int countSame = 0;
			String arrActType = "";
			
			//set Default
			semmmm002Bean.setDisableBtnApproveVendor(true);
			semmmm002Bean.setDisableBtnRejectVendor(true);
			semmmm002Bean.setDisableBtnSendVendorToMNG2(true);
			semmmm002Bean.setDisableBtnMNG2ApproveVendor(true);
			semmmm002Bean.setDisableBtnMNG2RejectVendor(true);
			
			semmmm002Bean.setDisableBtnApproveBookbank(true);
			semmmm002Bean.setDisableBtnRejectBookbank(true);
			semmmm002Bean.setDisableBtnSendBookbankToMNG2(true);
			semmmm002Bean.setDisableBtnMNG2ApproveBookbank(true);
			semmmm002Bean.setDisableBtnMNG2RejectBookbank(true);
			
			semmmm002Bean.setDisableBtnApprovePayee(true);
			semmmm002Bean.setDisableBtnRejectPayee(true);
			semmmm002Bean.setDisableBtnSendPayeeToMNG2(true);
			semmmm002Bean.setDisableBtnMNG2ApprovePayee(true);
			semmmm002Bean.setDisableBtnMNG2RejectPayee(true);
			
			semmmm002Bean.setDisableBtnApprovePayeeBookbank(true);
			semmmm002Bean.setDisableBtnRejectPayeeBookbank(true);
			semmmm002Bean.setDisableBtnSendPayeeBookbankToMNG2(true);
			semmmm002Bean.setDisableBtnMNG2ApprovePayeeBookbank(true);
			semmmm002Bean.setDisableBtnMNG2RejectPayeeBookbank(true);
			
			boolean chkDisableApproveVendor = true;
			boolean chkDisableRejectVendor = true;
			boolean chkDisableSendVendorToMNG2 = true;
			boolean chkDisableMNG2ApproveVendor = true;
			boolean chkDisableMNG2RejectVendor = true; 
			
			boolean chkDisableApproveBookbank = true;
			boolean chkDisableRejectBookbank = true;
			boolean chkDisableSendBookbankToMNG2 = true;
			boolean chkDisableMNG2ApproveBookbank = true;
			boolean chkDisableMNG2RejectBookbank = true;
			
			boolean chkDisableApprovePayee = true;
			boolean chkDisableRejectPayee = true;
			boolean chkDisableSendPayeeToMNG2 = true;
			boolean chkDisableMNG2ApprovePayee = true;
			boolean chkDisableMNG2RejectPayee = true;
			
			boolean chkDisableApprovePayeeBookbank = true;
			boolean chkDisableRejectPayeeBookbank = true;
			boolean chkDisableSendPayeeBookbankToMNG2 = true;
			boolean chkDisableMNG2ApprovePayeeBookbank = true;
			boolean chkDisableMNG2RejectPayeeBookbank = true;
			
			for (WrapperBeanObject<Mmm001VendorMasterSP> wrapperBeanObject : resultList) {
				if(wrapperBeanObject.isCheckBox()){
					Mmm001VendorMasterSP o = (Mmm001VendorMasterSP) wrapperBeanObject.getDataObj();
					//vendor
					LOG.debug("o.getVendorFlowStatusCode() : "+o.getVendorFlowStatusCode());
					LOG.debug("getBookbankFlowStatusCode() : "+o.getBookbankFlowStatusCode());
					LOG.debug("getPayeeFlowStatusCode() : "+o.getPayeeFlowStatusCode());
					LOG.debug("getBpFlowStatusCode() : "+o.getBpFlowStatusCode());
					if(!StringUtils.equals("02", o.getVendorFlowStatusCode())){
						chkDisableApproveVendor = false;
						chkDisableSendVendorToMNG2 = false;
						chkDisableRejectVendor = false;
					}
					
					if(!StringUtils.equals("07", o.getVendorFlowStatusCode())){
						chkDisableMNG2ApproveVendor = false;
						chkDisableMNG2RejectVendor = false;
					}
					
					//bookbank
					if(!StringUtils.equals("02", o.getBookbankFlowStatusCode())){
						chkDisableApproveBookbank = false;
						chkDisableSendBookbankToMNG2 = false;
						chkDisableRejectBookbank = false;
					}
					
					if(!StringUtils.equals("07", o.getBookbankFlowStatusCode())){
						chkDisableMNG2ApproveBookbank = false;
						chkDisableMNG2RejectBookbank = false;
					}
					
					//payee
					if(!StringUtils.equals("12", o.getPayeeFlowStatusCode())){
						chkDisableApprovePayee = false;
						chkDisableSendPayeeToMNG2 = false;
						chkDisableRejectPayee = false;
					}
					
					if(!StringUtils.equals("07", o.getPayeeFlowStatusCode())){
						chkDisableMNG2ApprovePayee = false;
						chkDisableMNG2RejectPayee = false;
					}
					
					//payeebookbank
					if(!StringUtils.equals("02", o.getBpFlowStatusCode())){
						chkDisableApprovePayeeBookbank = false;
						chkDisableSendPayeeBookbankToMNG2 = false;
						chkDisableRejectPayeeBookbank = false;
					}
					
					if(!StringUtils.equals("07", o.getBpFlowStatusCode())){
						chkDisableMNG2ApprovePayeeBookbank = false;
						chkDisableMNG2RejectPayeeBookbank = false;
					}
					
					
					
					chkRecords++;
				}
			}
			
			// -- 
			if(chkRecords >= 1){
				//vendor
				if(chkDisableApproveVendor){
					semmmm002Bean.setDisableBtnApproveVendor(false);
					semmmm002Bean.setRenderedBtnApproveVendor(true);
				}
				
				if(chkDisableRejectVendor){
					semmmm002Bean.setDisableBtnRejectVendor(false);
					semmmm002Bean.setRenderedBtnRejectVendor(true);
				}
				
				if(chkDisableSendVendorToMNG2){
					semmmm002Bean.setDisableBtnSendVendorToMNG2(false);
					semmmm002Bean.setRenderedBtnSendVendorToMNG2(true);
				}
				
				if(chkDisableMNG2ApproveVendor){
					semmmm002Bean.setDisableBtnMNG2ApproveVendor(false);
					semmmm002Bean.setRenderedBtnMNG2ApproveVendor(true);
				}
				
				if(chkDisableMNG2RejectVendor){
					semmmm002Bean.setDisableBtnMNG2RejectVendor(false);
					semmmm002Bean.setRenderedBtnMNG2RejectVendor(true);
				}
				
				//bookbank
				if(chkDisableApproveBookbank){
					semmmm002Bean.setDisableBtnApproveBookbank(false);
					semmmm002Bean.setRenderedBtnApproveBookbank(true);
				}
				
				if(chkDisableRejectBookbank){
					semmmm002Bean.setDisableBtnRejectBookbank(false);
					semmmm002Bean.setRenderedBtnRejectBookbank(true);
				}
				
				if(chkDisableSendBookbankToMNG2){
					semmmm002Bean.setDisableBtnSendBookbankToMNG2(false);
					semmmm002Bean.setRenderedBtnSendBookbankToMNG2(true);
				}
				
				if(chkDisableMNG2ApproveBookbank){
					semmmm002Bean.setDisableBtnMNG2ApproveBookbank(false);
					semmmm002Bean.setRenderedBtnMNG2ApproveBookbank(true);
				}
				
				if(chkDisableMNG2RejectBookbank){
					semmmm002Bean.setDisableBtnMNG2RejectBookbank(false);
					semmmm002Bean.setRenderedBtnMNG2RejectBookbank(true);
				}
				
				//payee
				if(chkDisableApprovePayee){
					semmmm002Bean.setDisableBtnApprovePayee(false);
					semmmm002Bean.setRenderedBtnApprovePayee(true);
				}
				
				if(chkDisableRejectPayee){
					semmmm002Bean.setDisableBtnRejectPayee(false);
					semmmm002Bean.setRenderedBtnRejectPayee(true);
				}
				
				if(chkDisableSendPayeeToMNG2){
					semmmm002Bean.setDisableBtnSendPayeeToMNG2(false);
					semmmm002Bean.setRenderedBtnSendPayeeToMNG2(true);
				}
				
				if(chkDisableMNG2ApprovePayee){
					semmmm002Bean.setDisableBtnMNG2ApprovePayee(false);
					semmmm002Bean.setRenderedBtnMNG2ApprovePayee(true);
				}
				
				if(chkDisableMNG2RejectPayee){
					semmmm002Bean.setDisableBtnMNG2RejectPayee(false);
					semmmm002Bean.setRenderedBtnMNG2RejectPayee(true);
				}
				
				//payeebookbank
				if(chkDisableApprovePayeeBookbank){
					semmmm002Bean.setDisableBtnApprovePayeeBookbank(false);
					semmmm002Bean.setRenderedBtnApprovePayeeBookbank(true);
				}
				
				if(chkDisableRejectPayeeBookbank){
					semmmm002Bean.setDisableBtnRejectPayeeBookbank(false);
					semmmm002Bean.setRenderedBtnRejectPayeeBookbank(true);
				}
				
				if(chkDisableSendPayeeBookbankToMNG2){
					semmmm002Bean.setDisableBtnSendPayeeBookbankToMNG2(false);
					semmmm002Bean.setRenderedBtnSendPayeeBookbankToMNG2(true);
				}
				
				if(chkDisableMNG2ApprovePayeeBookbank){
					semmmm002Bean.setDisableBtnMNG2ApprovePayeeBookbank(false);
					semmmm002Bean.setRenderedBtnMNG2ApprovePayeeBookbank(true);
				}
				
				if(chkDisableMNG2RejectPayeeBookbank){
					semmmm002Bean.setDisableBtnMNG2RejectPayeeBookbank(false);
					semmmm002Bean.setRenderedBtnMNG2RejectPayeeBookbank(true);
				}
			} else {
				semmmm002Bean.setDisableBtnApproveVendor(true);
				semmmm002Bean.setDisableBtnRejectVendor(true);
				semmmm002Bean.setDisableBtnSendVendorToMNG2(true);
				semmmm002Bean.setDisableBtnMNG2ApproveVendor(true);
				semmmm002Bean.setDisableBtnMNG2RejectVendor(true);
				
				semmmm002Bean.setDisableBtnApproveBookbank(true);
				semmmm002Bean.setDisableBtnRejectBookbank(true);
				semmmm002Bean.setDisableBtnSendBookbankToMNG2(true);
				semmmm002Bean.setDisableBtnMNG2ApproveBookbank(true);
				semmmm002Bean.setDisableBtnMNG2RejectBookbank(true);
				
				semmmm002Bean.setDisableBtnApprovePayee(true);
				semmmm002Bean.setDisableBtnRejectPayee(true);
				semmmm002Bean.setDisableBtnSendPayeeToMNG2(true);
				semmmm002Bean.setDisableBtnMNG2ApprovePayee(true);
				semmmm002Bean.setDisableBtnMNG2RejectPayee(true);
				
				semmmm002Bean.setDisableBtnApprovePayeeBookbank(true);
				semmmm002Bean.setDisableBtnRejectPayeeBookbank(true);
				semmmm002Bean.setDisableBtnSendPayeeBookbankToMNG2(true);
				semmmm002Bean.setDisableBtnMNG2ApprovePayeeBookbank(true);
				semmmm002Bean.setDisableBtnMNG2RejectPayeeBookbank(true);
				
				
				//for to do list page
				
				semmmm002Bean.setRenderedBtnApproveVendor(false);
				semmmm002Bean.setRenderedBtnRejectVendor(false);
				semmmm002Bean.setRenderedBtnSendVendorToMNG2(false);
				semmmm002Bean.setRenderedBtnMNG2ApproveVendor(false);
				semmmm002Bean.setRenderedBtnMNG2RejectVendor(false);
				
				semmmm002Bean.setRenderedBtnApproveBookbank(false);
				semmmm002Bean.setRenderedBtnRejectBookbank(false);
				semmmm002Bean.setRenderedBtnSendBookbankToMNG2(false);
				semmmm002Bean.setRenderedBtnMNG2ApproveBookbank(false);
				semmmm002Bean.setRenderedBtnMNG2RejectBookbank(false);
				
				semmmm002Bean.setRenderedBtnApprovePayee(false);
				semmmm002Bean.setRenderedBtnRejectPayee(false);
				semmmm002Bean.setRenderedBtnSendPayeeToMNG2(false);
				semmmm002Bean.setRenderedBtnMNG2ApprovePayee(false);
				semmmm002Bean.setRenderedBtnMNG2RejectPayee(false);
				
				semmmm002Bean.setRenderedBtnApprovePayeeBookbank(false);
				semmmm002Bean.setRenderedBtnRejectPayeeBookbank(false);
				semmmm002Bean.setRenderedBtnSendPayeeBookbankToMNG2(false);
				semmmm002Bean.setRenderedBtnMNG2ApprovePayeeBookbank(false);
				semmmm002Bean.setRenderedBtnMNG2RejectPayeeBookbank(false);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMMM002Action");
		} finally {
			setSemmmm002Bean(semmmm002Bean);
			LOG.info("::: SEMMMM002Action :: onEnableButton >> END :::");
		}
	}
	
	private boolean validateFrmSearch() {
		boolean flagValid = false;
		String company = "";
		String region = "";

		try{
			semmmm002Bean = getSemmmm002Bean();
			
			if(StringUtils.isEmpty(semmmm002Bean.getCriteria().getBatchNo())
					&& StringUtils.isEmpty(semmmm002Bean.getCriteria().getPayeeId())
					&& StringUtils.isEmpty(semmmm002Bean.getCriteria().getVendorCode())
					&& StringUtils.isEmpty(semmmm002Bean.getCriteria().getVendorName())
					&& StringUtils.isEmpty(semmmm002Bean.getCriteria().getIdCard())
					&& StringUtils.isEmpty(semmmm002Bean.getCriteria().getTaxId())
					&& StringUtils.isEmpty(semmmm002Bean.getCriteria().getContractNo())){
				//check company
//				if(semmmm002Bean.getCriteria().getCompany() != null){
//					company = semmmm002Bean.getCriteria().getCompany();
//					if(StringUtils.equals("", company)){
//						addMessageError("W0001", msg("message.company"));
//						flagValid = true;
//					}
//				}
				
				//check region
//				if(semmmm002Bean.getCriteria().getRegion() != null){
//					region = semmmm002Bean.getCriteria().getRegion();
//					if(StringUtils.equals("", region)){
//						addMessageError("W0001", msg("message.region"));
//						flagValid = true;
//					}
//				}
			
			
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMMM002Action validateFrmSearch");
			flagValid = true;
			addMessageError("E0004");
		}
		
		return flagValid;
	}

	
	// ---------------------------------------------------------------------------------
	private boolean pageLoad() {
		LOG.info("::: SEMMMM002Action :: pageLoad >> BEGIN :::");
		boolean flag = false;

		try {
			
			semmmm002Bean = getSemmmm002Bean();

			/*
			 * TODO
			 * */
			
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMMM002Action");
			flag = false;
		} finally {
			setSemmmm002Bean(semmmm002Bean);
			LOG.info("::: SEMMMM002Action :: pageLoad >> END :::");
		}
		return true;
	}
	
	private boolean doSearch() {
		LOG.info("::: SEMMMM002Action :: doSearch >> BEGIN :::");
		boolean flag = false;

		try {
			
			semmmm002Bean = getSemmmm002Bean();

			if (validateFrmSearch()) {
				semmmm002Bean.setRenderedMsgFormSearch(true);
				return flag;
			} else {
				searchContractList();
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMMM002Action");
			flag = false;
		} finally {
			setSemmmm002Bean(semmmm002Bean);
			LOG.info("::: SEMMMM002Action :: doSearch >> END :::");
		}
		return flag;
	}
	
	private boolean doClear() {
		LOG.info("::: SEMMMM002Action :: doClear >> BEGIN :::");
		boolean flag = false;

		//SEMMMM0021Bean semmmm002Bean = new SEMMMM002Bean();
		
		try {
			
			init();
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMMM002Action");
			flag = false;
		} finally {
			setSemmmm002Bean(semmmm002Bean);
			LOG.info("::: SEMMMM002Action :: doClear >> END :::");
		}
		return flag;
	}

	private boolean doApprove() {
		LOG.info("::: SEMMMM002Action :: doApprove >> BEGIN :::");
		boolean flag = false;

		try {
			
			semmmm002Bean = getSemmmm002Bean();

			/*
			 * TODO
			 * */
			
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMMM002Action");
			flag = false;
		} finally {
			setSemmmm002Bean(semmmm002Bean);
			LOG.info("::: SEMMMM002Action :: doApprove >> END :::");
		}
		return true;
	}
	
	private boolean doSendToMNG2() {
		LOG.info("::: SEMMMM002Action :: doSendToMNG2 >> BEGIN :::");
		boolean flag = false;

		try {
			
			semmmm002Bean = getSemmmm002Bean();

			/*
			 * TODO
			 * */
			
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMMM002Action");
			flag = false;
		} finally {
			setSemmmm002Bean(semmmm002Bean);
			LOG.info("::: SEMMMM002Action :: doSendToMNG2 >> END :::");
		}
		return true;
	}
	
//	private boolean doReject() {
//		LOG.info("::: SEMMMM002Action :: doReject >> BEGIN :::");
//		boolean flag = false;
//
//		try {
//			
//			semmmm002Bean = getSemmmm002Bean();
//
//			/*
//			 * TODO
//			 * */
//			
//			
//		} catch(Exception e) {
//			e.printStackTrace();
//			LOG.error(e);
//			LOG.debug(e);
//			addMessageError("EL0000", "SEMMMM002Action");
//			flag = false;
//		} finally {
//			setSemmmm002Bean(semmmm002Bean);
//			LOG.info("::: SEMMMM002Action :: doReject >> END :::");
//		}
//		return true;
//	}
	
	
	// ---------------------------------------------------------------------------------
	private void searchContractList() {
		LOG.info("::: SEMMMM002Action :: searchContractList >> BEGIN :::");
		
		IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
		List<Mmm001VendorMasterSP> to = null;
		
		try {
			
			semmmm002Bean.setVendorMasterResultList(new ArrayList<WrapperBeanObject<Mmm001VendorMasterSP>>());
			setSemmmm002Bean(semmmm002Bean);
			

			String regionConcatParam = "";
			String arrRegion[] = semmmm002Bean.getCriteria().getArrRegion().length == 0 ? null : 
								 semmmm002Bean.getCriteria().getArrRegion();
			if(arrRegion != null){
				for(Object s : arrRegion){
					LOG.debug("REGION: " + s.toString());
					regionConcatParam += s.toString().concat("|");
				}
				regionConcatParam = regionConcatParam.substring(0, regionConcatParam.lastIndexOf("|"));
				semmmm002Bean.getCriteria().setRegion(regionConcatParam);
				LOG.debug(">> regionConcatParam: " + regionConcatParam);
			}
			
			// --
			if(semmmm002Bean.isChkPicoType()){
				semmmm002Bean.getCriteria().setSystemType("PICO");
			} else {
				semmmm002Bean.getCriteria().setSystemType("");
			}
			
			if(semmmm002Bean.isChkVendorType()){
				semmmm002Bean.getCriteria().setVendorType("Y");
			} else {
				semmmm002Bean.getCriteria().setVendorType("N");
			}
			
			if(semmmm002Bean.isChkPayeeType()){
				semmmm002Bean.getCriteria().setPayeeType("Y");
			} else {
				semmmm002Bean.getCriteria().setPayeeType("N");
			}
			
//			semmmm002Bean.getCriteria().setCreateBy(getUserLogIn());
			LOG.debug("criteria: " + semmmm002Bean.getCriteria().toString());
			LOG.debug("criteria: " + semmmm002Bean.getCriteria().getVendorType());
			LOG.debug("criteria vendorCode : " + semmmm002Bean.getCriteria().getVendorCode());
			
			to = service.querySPList(EQueryName.SEM_SAP_SP_VENDOR_SEARCH_FLOW.name, semmmm002Bean.getCriteria());
			
			if (null == to || to.isEmpty()) {
				semmmm002Bean.setRenderedMsgDataNotFound(true);
			} else {
				semmmm002Bean.setRenderedMsgDataNotFound(false);
				
				LOG.debug("to.size() = "+to.size());
				for (int i=0; i<to.size(); i++) {
					Mmm001VendorMasterSP o = to.get(i);
					WrapperBeanObject<Mmm001VendorMasterSP> tmpWrapperBean = new WrapperBeanObject<Mmm001VendorMasterSP>();
					
//					o.setAccountName("xxxxx");
					if(StringUtils.isEmpty(o.getActionType())){
//						System.out.println("actionType : "+o.getActionType());
						o.setRenderedCheckbox(false);
					}
					
					if(o.getContractEffectiveDt() != null){
						o.setContractEffectiveDtStr(convertYearENtoTHStr(o.getContractEffectiveDt()));
					}
					
					if(o.getContractExpireDt() != null){
						o.setContractExpireDtStr(convertYearENtoTHStr(o.getContractExpireDt()));
					}
					
					if(o.getActionTypeDisplay() != null){
						o.setActionTypeDisplay(StringUtils.substring(o.getActionTypeDisplay(), 0, o.getActionTypeDisplay().lastIndexOf(",")));
						LOG.debug("Action Detail Sub Last , : "+o.getActionTypeDisplay());
					}
					
					if(o.getOtherStatus() != null){
						o.setOtherStatus(StringUtils.substring(o.getOtherStatus(), 0, o.getOtherStatus().lastIndexOf(",")));
						LOG.debug("Other Status Sub Last , : "+o.getOtherStatus());
					}
					
					LOG.debug("vendorBlock : "+o.getVendorBlock());
					tmpWrapperBean.setDataObj(o);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					
					semmmm002Bean.getVendorMasterResultList().add(tmpWrapperBean);
				}
			}
			
			semmmm002Bean.setChkSelAll(false);
			semmmm002Bean.setScrollerPage("1");
			
			this.onEnableButton();
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMMM002Action");
		} finally {
			setSemmmm002Bean(semmmm002Bean);
			LOG.info("::: SEMMMM002Action :: searchContractList >> END :::");
		}
	}
	
	//added by NEW 29/11/2017
	public boolean doValidateApprove(){
		LOG.info("::: SEMMMM002Action :: doValidateApprove >> BEGIN :::");
		boolean flag = true;
		try{
			semmmm002Bean = getSemmmm002Bean();
			IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
			
			List<ItemResultSP> result = null;
			
			String navProgram = (String)getFacesUtils().getRequestParameter("navProgram");
			
			LOG.info("semmmm002Bean.getVendorInfo(): " + semmmm002Bean.getVendorInfo());
			
			ItemParamsSP params = new ItemParamsSP();

			String btnEvent = (String)getFacesUtils().getRequestParameter("btnEvent") == null ? "" : (String)getFacesUtils().getRequestParameter("btnEvent");
			String actionBtnType = (String)getFacesUtils().getRequestParameter("actionBtnType") == null ? "" : (String)getFacesUtils().getRequestParameter("actionBtnType");
			String actionType = (String)getFacesUtils().getRequestParameter("actionType") == null ? "" : (String)getFacesUtils().getRequestParameter("actionType");
			String reqManager2 = (String)getFacesUtils().getRequestParameter("reqManager2") == null ? "N" : (String)getFacesUtils().getRequestParameter("reqManager2");
			String btnType = (String)getFacesUtils().getRequestParameter("btnType") == null ? "" : (String)getFacesUtils().getRequestParameter("btnType");
//			LOG.debug(">> btnEvent: " + btnEvent);
			
			String rowIdConcatParam = "";
			String vendorIdParam = "";
			String bookbankIdParam = "";
			String payeeIdParam = "";
			String payeeBookbankIdParam = "";
			String vendorMapPayeeIdParam = "";
			
			
			// TODO TO FIXED
			ArrayList contractRowIdList = getAllRowIdFromSelectedVendorMasterList();
			if(contractRowIdList != null){
				vendorIdParam = (String) contractRowIdList.get(0);
				bookbankIdParam = (String) contractRowIdList.get(1);
				payeeIdParam = (String) contractRowIdList.get(2);
				payeeBookbankIdParam = (String) contractRowIdList.get(3);
				vendorMapPayeeIdParam = (String)contractRowIdList.get(4);
			}
			
			params.setParam1(btnType); // VD,VB,PY,PB
			params.setParam2(vendorMapPayeeIdParam);
			params.setParam3(vendorIdParam);
			params.setParam4(bookbankIdParam); //bookbankID
			params.setParam5(payeeIdParam); //payeeId
			params.setParam6(payeeBookbankIdParam); //payeeBookbankId
			params.setParam7(getUserLogIn());
			
//			LOG.debug("saveFlag : "+semmmm002Bean.getVendorInfo().getSaveFlag());
			result = service.querySPList(EQueryName.SEM_SAP_VALIDATE_APPROVE.name, params);
			
			semmmm002Bean.setRetResultObj(new ItemResultSP());
			
			if(result != null && result.size() != 0 && result.get(0) != null &&
			   result.get(0).getResultType() != null && 
			   result.get(0).getResultType().equalsIgnoreCase("SUCCESS")){
				
				if(result.get(0).getResultCode() != null)
					semmmm002Bean.getRetResultObj().setResultCode(result.get(0).getResultCode());
				if(result.get(0).getResultType() != null)
					semmmm002Bean.getRetResultObj().setResultType(result.get(0).getResultType());
				if(result.get(0).getResultMessage() != null)
					semmmm002Bean.getRetResultObj().setResultMessage(result.get(0).getResultMessage());
				
				if(result.get(0).getEmailFlag() != null)
					semmmm002Bean.getRetResultObj().setEmailFlag(result.get(0).getEmailFlag());
				if(result.get(0).getValidateFlag() != null)
					semmmm002Bean.getRetResultObj().setValidateFlag(result.get(0).getValidateFlag());
				if(result.get(0).getValidateCaseId() != null)
					semmmm002Bean.getRetResultObj().setValidateCaseId(result.get(0).getValidateCaseId());
				if(result.get(0).getEmailFrom() != null)
					semmmm002Bean.getRetResultObj().setEmailFrom(result.get(0).getEmailFrom());
				if(result.get(0).getEmailTo() != null)
					semmmm002Bean.getRetResultObj().setEmailTo(result.get(0).getEmailTo());
				if(result.get(0).getEmailSubject() != null)
					semmmm002Bean.getRetResultObj().setEmailSubject(result.get(0).getEmailSubject());
				if(result.get(0).getEmailDetail() != null)
					semmmm002Bean.getRetResultObj().setEmailDetail(result.get(0).getEmailDetail());
				
				if(result.get(0).getCloseBtnLabel() != null)
					semmmm002Bean.getRetResultObj().setCloseBtnLabel(result.get(0).getCloseBtnLabel());
				if(result.get(0).getOkBtnLabel() != null)
					semmmm002Bean.getRetResultObj().setOkBtnLabel(result.get(0).getOkBtnLabel());
				if(result.get(0).getCancelBtnLabel() != null)
					semmmm002Bean.getRetResultObj().setCancelBtnLabel(result.get(0).getCancelBtnLabel());
				if(result.get(0).getYesBtnLabel() != null)
					semmmm002Bean.getRetResultObj().setYesBtnLabel(result.get(0).getYesBtnLabel());
				if(result.get(0).getNoBtnLabel() != null)
					semmmm002Bean.getRetResultObj().setNoBtnLabel(result.get(0).getNoBtnLabel());
				
				if(StringUtils.equals("E", result.get(0).getValidateFlag()) ){
					semmmm002Bean.setRenderedBtnCloseVendor(true);
					semmmm002Bean.setRenderedBtnOKVendor(false);
					semmmm002Bean.setRenderedBtnCencelVendor(false);
					semmmm002Bean.setRenderedBtnYesVendor(false);
					semmmm002Bean.setRenderedBtnNoVendor(false);
					semmmm002Bean.setRenderedMsgPopupSave(true);
				}else if(StringUtils.equals("W", result.get(0).getValidateFlag()) ){
					semmmm002Bean.setRenderedBtnCloseVendor(false);
					semmmm002Bean.setRenderedBtnOKVendor(true);
					semmmm002Bean.setRenderedBtnCencelVendor(true);
					semmmm002Bean.setRenderedBtnYesVendor(false);
					semmmm002Bean.setRenderedBtnNoVendor(false);
					semmmm002Bean.setRenderedMsgPopupSave(true);
				}else if(StringUtils.equals("C", result.get(0).getValidateFlag()) ){
					semmmm002Bean.setRenderedBtnCloseVendor(false);
					semmmm002Bean.setRenderedBtnOKVendor(false);
					semmmm002Bean.setRenderedBtnCencelVendor(true);
					semmmm002Bean.setRenderedBtnYesVendor(true);
					semmmm002Bean.setRenderedBtnNoVendor(true);
					semmmm002Bean.setRenderedMsgPopupSave(true);
				}else if(StringUtils.equals("O", result.get(0).getValidateFlag()) ){
					semmmm002Bean.setRenderedBtnCloseVendor(false);
					semmmm002Bean.setRenderedBtnOKVendor(true);
					semmmm002Bean.setRenderedBtnCencelVendor(true);
					semmmm002Bean.setRenderedBtnYesVendor(false);
					semmmm002Bean.setRenderedBtnNoVendor(false);
					semmmm002Bean.setRenderedMsgPopupSave(false);
				}
				
				semmmm002Bean.getRetResultObj().setMethodWithNavi("doManageBtn");
				semmmm002Bean.getRetResultObj().setNavProgram(navProgram);
				
				semmmm002Bean.getRetResultObj().setActionBtnType(actionBtnType);
				
				
			} else {
				semmmm002Bean.getRetResultObj().setResultCode("");
				semmmm002Bean.getRetResultObj().setResultType("");
				semmmm002Bean.getRetResultObj().setResultMessage("no message return");
			}
			
		} catch(Exception e) {
			flag = false;
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMMM002Action");
		} finally {
			setSemmmm002Bean(semmmm002Bean);
			LOG.info("::: SEMMMM002Action :: doValidateApprove >> END :::");
		}
		return flag;
	}
	
	//added by NEW 16/05/2017
	
	private boolean doManageBtn() {
		LOG.info("::: SEMMMM002Action :: doManageBtn >> BEGIN :::");
		boolean flag = true;
		boolean errFlag = false;
		String navProgram = getFacesUtils().getRequestParameter("navProgram") == null ? "" : (String)getFacesUtils().getRequestParameter("navProgram");
		try {
			
			semmmm002Bean = getSemmmm002Bean();
			
			ItemParamsSP params = new ItemParamsSP();

			String btnEvent = (String)getFacesUtils().getRequestParameter("btnEvent") == null ? "" : (String)getFacesUtils().getRequestParameter("btnEvent");
			String actionBtnType = (String)getFacesUtils().getRequestParameter("actionBtnType") == null ? "" : (String)getFacesUtils().getRequestParameter("actionBtnType");
			String actionType = (String)getFacesUtils().getRequestParameter("actionType") == null ? "" : (String)getFacesUtils().getRequestParameter("actionType");
			String reqManager2 = (String)getFacesUtils().getRequestParameter("reqManager2") == null ? "N" : (String)getFacesUtils().getRequestParameter("reqManager2");
			String validateFlag = getFacesUtils().getRequestParameter("validateFlag") == null ? "" : (String)getFacesUtils().getRequestParameter("validateFlag");
			String validateCaseId = getFacesUtils().getRequestParameter("validateCaseId") == null ? "" : (String)getFacesUtils().getRequestParameter("validateCaseId");
			
			
//			LOG.debug(">> btnEvent: " + btnEvent);
			
			String rowIdConcatParam = "";
			String vendorIdParam = "";
			String bookbankIdParam = "";
			String payeeIdParam = "";
			String payeeBookbankIdParam = "";
			
			
			// TODO TO FIXED
			ArrayList contractRowIdList = getAllRowIdFromSelectedVendorMasterList();
			if(contractRowIdList != null){
				vendorIdParam = (String) contractRowIdList.get(0);
				bookbankIdParam = (String) contractRowIdList.get(1);
				payeeIdParam = (String) contractRowIdList.get(2);
				payeeBookbankIdParam = (String) contractRowIdList.get(3);
			}
			
			if(StringUtils.equals(SEMConstant.SEMMMM001.APP_VD, actionBtnType)){
				List<WrapperBeanObject<Mmm001VendorMasterSP>> vendorResultList = new ArrayList<WrapperBeanObject<Mmm001VendorMasterSP>>();
				vendorResultList = semmmm002Bean.getVendorMasterResultList();
				
				String tempId = "";
				for (WrapperBeanObject<Mmm001VendorMasterSP> wrapperBeanObject : vendorResultList) {
					Mmm001VendorMasterSP o = (Mmm001VendorMasterSP) wrapperBeanObject.getDataObj();
					
					if(wrapperBeanObject.isCheckBox()){
						
						if (StringUtils.isNotEmpty(o.getRowId())) {
							
							if(StringUtils.equals(SEMConstant.SEMMMM001.APP_VD, actionBtnType)){
								errFlag = this.doVendorApprove(o.getVendorId(), actionType, o.getVendorMapPayeeId());
							}
							
							if(o.getGroupNo() != null)tempId = o.getGroupNo();
						}
					}else if(tempId != null && !StringUtils.equals("", tempId) && StringUtils.equals(tempId, o.getGroupNo())){
						if (StringUtils.isNotEmpty(o.getRowId())) {
							
							if(StringUtils.equals(SEMConstant.SEMMMM001.APP_VD, actionBtnType)){
								errFlag = this.doVendorApprove(o.getVendorId(), actionType, o.getVendorMapPayeeId());
							}
						}
					}
					
					
				}
			}else if(StringUtils.equals(SEMConstant.SEMMMM001.REJ_VD, actionBtnType)){
				params = new ItemParamsSP();
				
				params.setParam1("VD");
				params.setParam2(vendorIdParam);
				params.setParam3(""); //bookbankID
				params.setParam4(""); //payeeId
				params.setParam5(""); //payeeBookbankId
				params.setParam6(actionType); //MA,MR,M2A,M2R
				params.setParam7(reqManager2); //send to manager2 send param "Y"
				params.setParam8(getUserLogIn());
				params.setParam9(semmmm002Bean.getRejectRemark()); // remark case reject
				params.setParam10("");
				params.setParam11("");
				params.setParam12("");// case can't call SAP send param "F"
				
				flag = doSendToMNG(params);
			}else if(StringUtils.equals(SEMConstant.SEMMMM001.SND_VD_TO_MNG2, actionBtnType)){
				params = new ItemParamsSP();
				
				params.setParam1("VD");
				params.setParam2(vendorIdParam);
				params.setParam3(""); //bookbankID
				params.setParam4(""); //payeeId
				params.setParam5(""); //payeeBookbankId
				params.setParam6(""); //MA,MR,M2A,M2R
				params.setParam7(reqManager2); //send to manager2 send param "Y"
				params.setParam8(getUserLogIn());
				params.setParam9(""); // remark case reject
				params.setParam10("");
				params.setParam11("");
				params.setParam12("");// case can't call SAP send param "F"
				
				flag = doSendToMNG(params);
			}else if(StringUtils.equals(SEMConstant.SEMMMM001.MNG2_APP_VD, actionBtnType)){
				List<WrapperBeanObject<Mmm001VendorMasterSP>> vendorResultList = new ArrayList<WrapperBeanObject<Mmm001VendorMasterSP>>();
				vendorResultList = semmmm002Bean.getVendorMasterResultList();
				for (WrapperBeanObject<Mmm001VendorMasterSP> wrapperBeanObject : vendorResultList) {
					if(wrapperBeanObject.isCheckBox()){
						Mmm001VendorMasterSP o = (Mmm001VendorMasterSP) wrapperBeanObject.getDataObj();
						if (StringUtils.isNotEmpty(o.getRowId())) {
							
							if(StringUtils.equals(SEMConstant.SEMMMM001.MNG2_APP_VD, actionBtnType)){
								errFlag = this.doVendorApprove(o.getVendorId(), actionType, o.getVendorMapPayeeId());
							}
						}
					}
				}
			}else if(StringUtils.equals(SEMConstant.SEMMMM001.MNG2_REJ_VD, actionBtnType)){
				params = new ItemParamsSP();
				
				params.setParam1("VD");
				params.setParam2(vendorIdParam);
				params.setParam3(""); //bookbankID
				params.setParam4(""); //payeeId
				params.setParam5(""); //payeeBookbankId
				params.setParam6(actionType); //MA,MR,M2A,M2R
				params.setParam7(reqManager2); //send to manager2 send param "Y"
				params.setParam8(getUserLogIn());
				params.setParam9(semmmm002Bean.getRejectRemark()); // remark case reject
				params.setParam10("");
				params.setParam11("");
				params.setParam12("");// case can't call SAP send param "F"
				
				flag = doSendToMNG(params);
			}else if(StringUtils.equals(SEMConstant.SEMMMM001.APP_VB, actionBtnType)){
				params = new ItemParamsSP();
				
				params.setParam1("VB");
				params.setParam2(vendorIdParam);
				params.setParam3(bookbankIdParam); //bookbankID
				params.setParam4(""); //payeeId
				params.setParam5(""); //payeeBookbankId
				params.setParam6(actionType); //MA,MR,M2A,M2R
				params.setParam7(reqManager2); //send to manager2 send param "Y"
				params.setParam8(getUserLogIn());
				params.setParam9(""); // remark case reject
				params.setParam10("");
				params.setParam11("");
				params.setParam12("");// case can't call SAP send param "F"
				params.setParam13(validateFlag);
				params.setParam14(validateCaseId);
				
				flag = doSendToMNG(params);
				
			}else if(StringUtils.equals(SEMConstant.SEMMMM001.REJ_VB, actionBtnType)){
				params = new ItemParamsSP();
				
				params.setParam1("VB");
				params.setParam2(vendorIdParam);
				params.setParam3(bookbankIdParam); //bookbankID
				params.setParam4(""); //payeeId
				params.setParam5(""); //payeeBookbankId
				params.setParam6(actionType); //MA,MR,M2A,M2R
				params.setParam7(reqManager2); //send to manager2 send param "Y"
				params.setParam8(getUserLogIn());
				params.setParam9(semmmm002Bean.getRejectRemark()); // remark case reject
				params.setParam10("");
				params.setParam11("");
				params.setParam12("");// case can't call SAP send param "F"
				
				flag = doSendToMNG(params);
			}else if(StringUtils.equals(SEMConstant.SEMMMM001.SND_VB_TO_MNG2, actionBtnType)){
				params = new ItemParamsSP();
				
				params.setParam1("VB");
				params.setParam2(vendorIdParam);
				params.setParam3(bookbankIdParam); //bookbankID
				params.setParam4(""); //payeeId
				params.setParam5(""); //payeeBookbankId
				params.setParam6(actionType); //MA,MR,M2A,M2R
				params.setParam7(reqManager2); //send to manager2 send param "Y"
				params.setParam8(getUserLogIn());
				params.setParam9(""); // remark case reject
				params.setParam10("");
				params.setParam11("");
				params.setParam12("");// case can't call SAP send param "F"
				
				flag = doSendToMNG(params);
			}else if(StringUtils.equals(SEMConstant.SEMMMM001.MNG2_APP_VB, actionBtnType)){
				params = new ItemParamsSP();
				
				params.setParam1("VB");
				params.setParam2(vendorIdParam);
				params.setParam3(bookbankIdParam); //bookbankID
				params.setParam4(""); //payeeId
				params.setParam5(""); //payeeBookbankId
				params.setParam6(actionType); //MA,MR,M2A,M2R
				params.setParam7(reqManager2); //send to manager2 send param "Y"
				params.setParam8(getUserLogIn());
				params.setParam9(""); // remark case reject
				params.setParam10("");
				params.setParam11("");
				params.setParam12("");// case can't call SAP send param "F"
				params.setParam13(validateFlag);
				params.setParam14(validateCaseId);
				
				flag = doSendToMNG(params);
			}else if(StringUtils.equals(SEMConstant.SEMMMM001.MNG2_REJ_VB, actionBtnType)){
				params = new ItemParamsSP();
				
				params.setParam1("VB");
				params.setParam2(vendorIdParam);
				params.setParam3(bookbankIdParam); //bookbankID
				params.setParam4(""); //payeeId
				params.setParam5(""); //payeeBookbankId
				params.setParam6(actionType); //MA,MR,M2A,M2R
				params.setParam7(reqManager2); //send to manager2 send param "Y"
				params.setParam8(getUserLogIn());
				params.setParam9(semmmm002Bean.getRejectRemark()); // remark case reject
				params.setParam10("");
				params.setParam11("");
				params.setParam12("");// case can't call SAP send param "F"
				
				flag = doSendToMNG(params);
			}else if(StringUtils.equals(SEMConstant.SEMMMM001.APP_PY, actionBtnType)){
				params = new ItemParamsSP();
				
				params.setParam1("PY");
				params.setParam2(vendorIdParam);
				params.setParam3(""); //bookbankID
				params.setParam4(payeeIdParam); //payeeId
				params.setParam5(""); //payeeBookbankId
				params.setParam6(actionType); //MA,MR,M2A,M2R
				params.setParam7(reqManager2); //send to manager2 send param "Y"
				params.setParam8(getUserLogIn());
				params.setParam9(""); // remark case reject
				params.setParam10("");
				params.setParam11("");
				params.setParam12("");// case can't call SAP send param "F"
				params.setParam13(validateFlag);
				params.setParam14(validateCaseId);
				
				flag = doSendToMNG(params);
			}else if(StringUtils.equals(SEMConstant.SEMMMM001.REJ_PY, actionBtnType)){
				params = new ItemParamsSP();
				
				params.setParam1("PY");
				params.setParam2(vendorIdParam);
				params.setParam3(""); //bookbankID
				params.setParam4(payeeIdParam); //payeeId
				params.setParam5(""); //payeeBookbankId
				params.setParam6(actionType); //MA,MR,M2A,M2R
				params.setParam7(reqManager2); //send to manager2 send param "Y"
				params.setParam8(getUserLogIn());
				params.setParam9(semmmm002Bean.getRejectRemark()); // remark case reject
				params.setParam10("");
				params.setParam11("");
				params.setParam12("");// case can't call SAP send param "F"
				
				flag = doSendToMNG(params);
			}else if(StringUtils.equals(SEMConstant.SEMMMM001.SND_PY_TO_MNG2, actionBtnType)){
				params = new ItemParamsSP();
				
				params.setParam1("PY");
				params.setParam2(vendorIdParam);
				params.setParam3(""); //bookbankID
				params.setParam4(payeeIdParam); //payeeId
				params.setParam5(""); //payeeBookbankId
				params.setParam6(actionType); //MA,MR,M2A,M2R
				params.setParam7(reqManager2); //send to manager2 send param "Y"
				params.setParam8(getUserLogIn());
				params.setParam9(""); // remark case reject
				params.setParam10("");
				params.setParam11("");
				params.setParam12("");// case can't call SAP send param "F"
				
				flag = doSendToMNG(params);
			}else if(StringUtils.equals(SEMConstant.SEMMMM001.MNG2_APP_PY, actionBtnType)){
				params = new ItemParamsSP();
				
				params.setParam1("PY");
				params.setParam2(vendorIdParam);
				params.setParam3(""); //bookbankID
				params.setParam4(payeeIdParam); //payeeId
				params.setParam5(""); //payeeBookbankId
				params.setParam6(actionType); //MA,MR,M2A,M2R
				params.setParam7(reqManager2); //send to manager2 send param "Y"
				params.setParam8(getUserLogIn());
				params.setParam9(""); // remark case reject
				params.setParam10("");
				params.setParam11("");
				params.setParam12("");// case can't call SAP send param "F"
				params.setParam13(validateFlag);
				params.setParam14(validateCaseId);
				
				flag = doSendToMNG(params);
			}else if(StringUtils.equals(SEMConstant.SEMMMM001.MNG2_REJ_PY, actionBtnType)){
				params = new ItemParamsSP();
				
				params.setParam1("PY");
				params.setParam2(vendorIdParam);
				params.setParam3(""); //bookbankID
				params.setParam4(payeeIdParam); //payeeId
				params.setParam5(""); //payeeBookbankId
				params.setParam6(actionType); //MA,MR,M2A,M2R
				params.setParam7(reqManager2); //send to manager2 send param "Y"
				params.setParam8(getUserLogIn());
				params.setParam9(semmmm002Bean.getRejectRemark()); // remark case reject
				params.setParam10("");
				params.setParam11("");
				params.setParam12("");// case can't call SAP send param "F"
				
				flag = doSendToMNG(params);
			}else if(StringUtils.equals(SEMConstant.SEMMMM001.APP_PB, actionBtnType)){
				params = new ItemParamsSP();
				
				params.setParam1("PB");
				params.setParam2(vendorIdParam);
				params.setParam3(""); //bookbankID
				params.setParam4(""); //payeeId
				params.setParam5(payeeBookbankIdParam); //payeeBookbankId
				params.setParam6(actionType); //MA,MR,M2A,M2R
				params.setParam7(reqManager2); //send to manager2 send param "Y"
				params.setParam8(getUserLogIn());
				params.setParam9(""); // remark case reject
				params.setParam10("");
				params.setParam11("");
				params.setParam12("");// case can't call SAP send param "F"
				params.setParam13(validateFlag);
				params.setParam14(validateCaseId);
				
				flag = doSendToMNG(params);
			}else if(StringUtils.equals(SEMConstant.SEMMMM001.REJ_PB, actionBtnType)){
				params = new ItemParamsSP();
				
				params.setParam1("PB");
				params.setParam2(vendorIdParam);
				params.setParam3(""); //bookbankID
				params.setParam4(""); //payeeId
				params.setParam5(payeeBookbankIdParam); //payeeBookbankId
				params.setParam6(actionType); //MA,MR,M2A,M2R
				params.setParam7(reqManager2); //send to manager2 send param "Y"
				params.setParam8(getUserLogIn());
				params.setParam9(semmmm002Bean.getRejectRemark()); // remark case reject
				params.setParam10("");
				params.setParam11("");
				params.setParam12("");// case can't call SAP send param "F"
				
				flag = doSendToMNG(params);
			}else if(StringUtils.equals(SEMConstant.SEMMMM001.SND_PB_TO_MNG2, actionBtnType)){
				params = new ItemParamsSP();
				
				params.setParam1("PB");
				params.setParam2(vendorIdParam);
				params.setParam3(""); //bookbankID
				params.setParam4(""); //payeeId
				params.setParam5(payeeBookbankIdParam); //payeeBookbankId
				params.setParam6(actionType); //MA,MR,M2A,M2R
				params.setParam7(reqManager2); //send to manager2 send param "Y"
				params.setParam8(getUserLogIn());
				params.setParam9(""); // remark case reject
				params.setParam10("");
				params.setParam11("");
				params.setParam12("");// case can't call SAP send param "F"
				
				flag = doSendToMNG(params);
			}else if(StringUtils.equals(SEMConstant.SEMMMM001.MNG2_APP_PB, actionBtnType)){
				params = new ItemParamsSP();
				
				params.setParam1("PB");
				params.setParam2(vendorIdParam);
				params.setParam3(""); //bookbankID
				params.setParam4(""); //payeeId
				params.setParam5(payeeBookbankIdParam); //payeeBookbankId
				params.setParam6(actionType); //MA,MR,M2A,M2R
				params.setParam7(reqManager2); //send to manager2 send param "Y"
				params.setParam8(getUserLogIn());
				params.setParam9(""); // remark case reject
				params.setParam10("");
				params.setParam11("");
				params.setParam12("");
				params.setParam13(validateFlag);
				params.setParam14(validateCaseId);
				
				flag = doSendToMNG(params);
			}else if(StringUtils.equals(SEMConstant.SEMMMM001.MNG2_REJ_PB, actionBtnType)){
				params = new ItemParamsSP();
				
				params.setParam1("PB");
				params.setParam2(vendorIdParam);
				params.setParam3(""); //bookbankID
				params.setParam4(""); //payeeId
				params.setParam5(payeeBookbankIdParam); //payeeBookbankId
				params.setParam6(actionType); //MA,MR,M2A,M2R
				params.setParam7(reqManager2); //send to manager2 send param "Y"
				params.setParam8(getUserLogIn());
				params.setParam9(semmmm002Bean.getRejectRemark()); // remark case reject
				params.setParam10("");
				params.setParam11("");
				params.setParam12("");
				
				flag = doSendToMNG(params);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMMM001Action");
			flag = false;
			errFlag = true;
		} finally {
			if(errFlag){
				addGeneralMessageError(msg("message.error.approvebookbank.incomplete"));
				if(StringUtils.isNotEmpty(semmmm002Bean.getRemarkSapMSG())){
					addGeneralMessageError(semmmm002Bean.getRemarkSapMSG());
				}
			}else if(flag){
				addMessageInfo("M0001");
				if(StringUtils.equals("SEMMMM002-0", navProgram)){
					this.loadTree();
					this.searchTodoListAfterAction();
				}else{
					this.doSearch();
				}
				
			}
			setSemmmm002Bean(semmmm002Bean);
			LOG.info("::: SEMMMM002Action :: doManageBtn >> END :::");
		}
		return flag;
	}
	
	private boolean doSendToMNG(ItemParamsSP params) {
		LOG.info("::: SEMMMM002Action :: doSendToMNG >> BEGIN :::");
		boolean flag = true;
		
		IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
		List<ItemResultSP> result = null;
		
		try {
			setSemmmm002Bean(semmmm002Bean);
			
			//validate remark case reject
			if(StringUtils.equals("MR", params.getParam6()) || StringUtils.equals("M2R", params.getParam6())){
				if(params.getParam9() == null|| StringUtils.isEmpty(params.getParam9()) || StringUtils.equals("", params.getParam9())){
					addMessageError("W0001", msg("export.col.remark"));
					return false;
				}
			}
			
//			System.out.println("params.getParam1 : "+params.getParam1());
//			System.out.println("params.getParam2 : "+params.getParam2());
//			System.out.println("params.getParam3 : "+params.getParam3());
//			System.out.println("params.getParam4 : "+params.getParam4());
//			System.out.println("params.getParam5 : "+params.getParam5());
//			System.out.println("params.getParam6 : "+params.getParam6());
			result = service.querySPList(EQueryName.SEM_SAP_CHANGE_STATUS.name, params);
			
			if(result != null && !result.isEmpty()) {
				LOG.debug(">> result.size() = " + result.size());
				ItemResultSP obj = (ItemResultSP) result.get(0);
				if(!"SUCCESS".equals(obj.getResultType())){
					addMessageError(obj.getResultMessage());
				}else{
//					addMessageInfo("M0003");
				}
//				LOG.debug(">> result = " + obj.toString());
			}
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMMM002Action");
			flag = false;
		} finally {
			setSemmmm002Bean(semmmm002Bean);
			LOG.info("::: SEMMMM002Action :: doSendToMNG >> END :::");
		}
		return flag;
	}
	
	public boolean doVendorApprove(String rowIdConcatParam, String actionType, String vendorMapPayeeId){
		boolean flag = false;
		boolean errFlag = false;
		semmmm002Bean = getSemmmm002Bean();
		List<Mmm001SAPVendorSP> result = new ArrayList<Mmm001SAPVendorSP>();
		MmmVendorMasterInfoSP resultWS = new MmmVendorMasterInfoSP();
		MmmVendorMasterInfoSP resultWS2 = new MmmVendorMasterInfoSP();
		MmmVendorMasterInfoSP resultWS3 = new MmmVendorMasterInfoSP();
		MmmVendorMasterInfoSP itemParams = new MmmVendorMasterInfoSP();
		WsClientService sapService = new WsClientService();
		List<MmmVendorMasterInfoSP> to = new ArrayList<MmmVendorMasterInfoSP>();
		List<ItemResultSP> to2 = new ArrayList<ItemResultSP>();
		ItemParamsSP paramsSP = new ItemParamsSP();
		
		boolean newVendorDupSAPFlag = false;
		String vendorCodeFromSAP = "";
		
		String tmpTaxId = "";
		String tmpBranchNo = "";
		
		String validateFlag = getFacesUtils().getRequestParameter("validateFlag") == null ? "" : (String)getFacesUtils().getRequestParameter("validateFlag");
		String validateCaseId = getFacesUtils().getRequestParameter("validateCaseId") == null ? "" : (String)getFacesUtils().getRequestParameter("validateCaseId");
		try{
			IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
			Mmm001SAPVendorSP params = new  Mmm001SAPVendorSP();
			params.setVendorId(rowIdConcatParam);
			params.setVendorMapPayeeId(vendorMapPayeeId);
			result = service.querySPList(EQueryName.SEM_SAP_GET_VENDOR.name, params);
			System.out.println("Call "+EQueryName.SEM_SAP_GET_VENDOR.name +" params : "+params);
			System.out.println("Call "+EQueryName.SEM_SAP_GET_VENDOR.name +" result : "+result);
			
			if(result != null && result.size() != 0 && result.get(0) != null && 
			   StringUtils.equalsIgnoreCase("success", result.get(0).getResult())){
				//call web service
				for(Mmm001SAPVendorSP rs : result){
					resultWS = new MmmVendorMasterInfoSP();
					itemParams = new MmmVendorMasterInfoSP();
					itemParams.setVendorCode(rs.getVendorCode());
					itemParams.setCompany(rs.getCompany());
					itemParams.setTaxId(rs.getTaxId());
					itemParams.setBranchNo(rs.getVendorBranchNo());
					itemParams.setRole(rs.getRole());
					itemParams.setRoleType(rs.getRoleType());
					
					if(rs.getVendorCode() == null || StringUtils.isEmpty(rs.getVendorCode()) || StringUtils.equals("", rs.getVendorCode()) || 
							StringUtils.equals("null", rs.getVendorCode())){
						
						//call web service GET VENDOR
						resultWS = sapService.getvendor(itemParams);
						System.out.println("Call WS sapService.getvendor itemParams : "+itemParams +" , resultWS : "+resultWS);
						if(resultWS != null && resultWS.getVendorCode() != null){
//							resultWS.setVendorId(rowIdConcatParam);
//							resultWS.setActionType(actionType);
//							resultWS.setUserId(getUserLogIn());
//							resultWS.setValidateFlag(validateFlag);
//							resultWS.setValidateCaseId(validateCaseId);
							vendorCodeFromSAP = resultWS.getVendorCode();
							itemParams.setVendorCode(resultWS.getVendorCode());
							itemParams.setCompany(rs.getCompany());
							itemParams.setTaxId("");
							itemParams.setBranchNo(rs.getVendorBranchNo());
							itemParams.setRole(rs.getRole());
							itemParams.setRoleType(rs.getRoleType());
							resultWS = new MmmVendorMasterInfoSP();
							//call web service GET VENDOR
							resultWS = sapService.getvendor(itemParams);
							newVendorDupSAPFlag = true;
						}
						
					}else{
						//call web service GET VENDOR
						resultWS = sapService.getvendor(itemParams);
						System.out.println("Else Call WS sapService.getvendor itemParams : "+itemParams +" , resultWS : "+resultWS);
					}
					
					//call web service GET VENDOR
//					resultWS = sapService.getvendor(itemParams);
					if(resultWS != null){
						resultWS.setVendorId(rowIdConcatParam);
						resultWS.setActionType(actionType);
						resultWS.setUserId(getUserLogIn());
						resultWS.setValidateFlag(validateFlag);
						resultWS.setValidateCaseId(validateCaseId);
						resultWS.setVendorMapPayeeId(vendorMapPayeeId);
						
						
						//TODO SET param get value from SAP 
						//set tmpTaxId
						if(resultWS.getTaxId() != null && !StringUtils.equals("", resultWS.getTaxId()))
							tmpTaxId = resultWS.getTaxId();
						
						if(resultWS.getBranch() != null && !StringUtils.equals("", resultWS.getBranch()))
							tmpBranchNo = resultWS.getBranch();
						
						if(resultWS.getWhtType() != null && "J1".equals(resultWS.getWhtType().toUpperCase())){
							resultWS.setWhtActionFlag("U");
						}else{
							resultWS.setWhtActionFlag("I");
						}
						
						if(resultWS.getWhtType2() != null){
							resultWS.setWhtActionFlag2("U");
						}else{
							resultWS.setWhtActionFlag2("I");
						}
						
						if(StringUtils.isNotEmpty(resultWS.getResult()) 
								&& StringUtils.equals("E", resultWS.getResult().toUpperCase()) 
								|| StringUtils.isEmpty(resultWS.getVendorCode())){
							to = new ArrayList<MmmVendorMasterInfoSP>();
							System.out.println(" Call PL "+EQueryName.SP_SEM_SAP_VENDOR_APPROVE.name +": "+resultWS );
							to = service.querySPList(EQueryName.SP_SEM_SAP_VENDOR_APPROVE.name, resultWS);
							System.out.println(" Call PL "+EQueryName.SP_SEM_SAP_VENDOR_APPROVE.name +" Result : "+to );
						
							
							if(to != null && StringUtils.equalsIgnoreCase("success", to.get(0).getResult())){
								
								for(MmmVendorMasterInfoSP vm : to){
									resultWS2 = new MmmVendorMasterInfoSP();	
//									vm.setChkDoubleInv("X");
									
									if(newVendorDupSAPFlag){
										vm.setVendorCode(vendorCodeFromSAP);
									}
									
									//Call WS Create Vendor 
									resultWS2 = sapService.creven(vm);
									System.out.println(" Call WS Create Vendor sapService.creven params : "+vm +" , resultWS2 : "+resultWS2);
									//check service creven error connection
									if(resultWS2 != null){
										if(StringUtils.equals("S", resultWS2.getResult().toUpperCase())){
											flag = true;
											paramsSP = new ItemParamsSP();
											paramsSP.setParam1("VD");
											paramsSP.setParam2(rowIdConcatParam);
											paramsSP.setParam3(""); //bookbankID
											paramsSP.setParam4(""); //payeeId
											paramsSP.setParam5(""); //payeeBookbankId
											paramsSP.setParam6(actionType); 
											paramsSP.setParam7("N"); //send to manager2 send param "Y"
											paramsSP.setParam8(getUserLogIn());
											paramsSP.setParam9(""); // remark case reject
											paramsSP.setParam10(resultWS2.getVendorCode());
											paramsSP.setParam11(resultWS2.getResult());
											paramsSP.setParam12(resultWS2.getRemark());
											
											to2 = service.querySPList(EQueryName.SEM_SAP_CHANGE_STATUS.name, paramsSP);
//											resultWS.setResult(resultWS2.getResult());
//											resultWS.setUserId(getUserLogIn());
//											to = service.querySPList(EQueryName.SP_SEM_SAP_VENDOR_APPROVE.name, resultWS);
											
											if(to2 != null && StringUtils.equalsIgnoreCase("FAIL", to2.get(0).getResultType())){
												errFlag = true;
												addGeneralMessageError(to.get(0).getRemark());
											}
										}else{
											//Service creven return Error 
//											resultWS = new MmmVendorMasterInfoSP();
//											resultWS.setResult(resultWS2.getResult());
//											resultWS.setRemark(resultWS2.getRemark());
//											resultWS.setActionType("SE");
//											resultWS.setUserId(getUserLogIn());
//											to = service.querySPList(EQueryName.SP_SEM_SAP_VENDOR_APPROVE.name, resultWS);
											
											paramsSP = new ItemParamsSP();
											paramsSP.setParam1("VD");
											paramsSP.setParam2(rowIdConcatParam);
											paramsSP.setParam3(""); //bookbankID
											paramsSP.setParam4(""); //payeeId
											paramsSP.setParam5(""); //payeeBookbankId
											paramsSP.setParam6(actionType); 
											paramsSP.setParam7("N"); //send to manager2 send param "Y"
											paramsSP.setParam8(getUserLogIn());
											paramsSP.setParam9(""); // remark case reject
											paramsSP.setParam10(resultWS2.getVendorCode());
											paramsSP.setParam11(resultWS2.getResult());
											paramsSP.setParam12(resultWS2.getRemark());
											semmmm002Bean.setRemarkSapMSG("WS create Vendor Error : "+resultWS2.getRemark());
											to2 = service.querySPList(EQueryName.SEM_SAP_CHANGE_STATUS.name, paramsSP);
											errFlag = true;
										}
									}else{
										//service creven Error connection
//										resultWS = new MmmVendorMasterInfoSP();
//										resultWS.setVendorId(rowIdConcatParam);
//										resultWS.setActionType("SNC");
//										resultWS.setUserId(getUserLogIn());
										errFlag = true;
//										to = service.querySPList(EQueryName.SP_SEM_SAP_VENDOR_APPROVE.name, resultWS);
										
										paramsSP = new ItemParamsSP();
										paramsSP.setParam1("VD");
										paramsSP.setParam2(rowIdConcatParam);
										paramsSP.setParam3(""); //bookbankID
										paramsSP.setParam4(""); //payeeId
										paramsSP.setParam5(""); //payeeBookbankId
										paramsSP.setParam6(actionType); 
										paramsSP.setParam7("N"); //send to manager2 send param "Y"
										paramsSP.setParam8(getUserLogIn());
										paramsSP.setParam9(""); // remark case reject
//										paramsSP.setParam10(resultWS2.getVendorCode());
										paramsSP.setParam11("F");// case can't call SAP send param "F"
//										paramsSP.setParam12(resultWS2.getRemark());
										semmmm002Bean.setRemarkSapMSG("WS create Vendor Error : case can't call SAP");
										to2 = service.querySPList(EQueryName.SEM_SAP_CHANGE_STATUS.name, paramsSP);
									}
								}
							}else {
								errFlag = true;
								addGeneralMessageError( to.get(0).getRemark());
							}
//							addGeneralMessageError(msg("message.error.approvebookbank.newbank"));
//							return;
						}else{
							to = new ArrayList<MmmVendorMasterInfoSP>();
//							System.out.println("vendor code : "+resultWS.getVendorCode());
							resultWS.setUserId(getUserLogIn());
							
							System.out.println("vendorId Old Get From SAP : "+resultWS.getVendorId());
							System.out.println("actionType Old Get From SAP : "+resultWS.getActionType());
							System.out.println("result Old Get From SAP : "+resultWS.getResult());
							System.out.println("remark Old Get From SAP : "+resultWS.getRemark());
							System.out.println("vendorCode Old Get From SAP : "+resultWS.getVendorCode());
							System.out.println("userId Old Get From SAP : "+resultWS.getBranchNo());
							System.out.println("consNumberTel Old Get From SAP : "+resultWS.getConsNumberTel());
							System.out.println("consNumberMobile Old Get From SAP : "+resultWS.getConsNumberMobile());
							System.out.println("consNumberFax Old Get From SAP : "+resultWS.getConsNumberFax());
							System.out.println("consNumberEmail Old Get From SAP : "+resultWS.getConsNumberEmail());
							System.out.println("validateFlag Old Get From SAP : "+resultWS.getValidateFlag());
							System.out.println("validateCaseId Old Get From SAP : "+resultWS.getValidateCaseId());
							System.out.println("vendorMapPayeeId Old Get From SAP : "+resultWS.getVendorMapPayeeId());
							
							System.out.println(" Call PL : "+EQueryName.SP_SEM_SAP_VENDOR_APPROVE.name +" Param : "+resultWS);
							
							to = service.querySPList(EQueryName.SP_SEM_SAP_VENDOR_APPROVE.name, resultWS);
							
							System.out.println(" Call PL : "+EQueryName.SP_SEM_SAP_VENDOR_APPROVE.name +" Result : "+to);
							
							if(to != null && StringUtils.equalsIgnoreCase("success", to.get(0).getResult())){
								
								for(MmmVendorMasterInfoSP vm : to){
									resultWS2 = new MmmVendorMasterInfoSP();	
//									vm.setChkDoubleInv("X");
									
									//Set TaxId Old Get From SAP
									//if(!StringUtils.equals("", tmpTaxId))
								    if(StringUtils.isNotEmpty(tmpTaxId))
										vm.setTaxIdOld(tmpTaxId);
									//Set TaxId Old Get From SAP
									LOG.debug("TaxId Old Get From SAP : "+tmpTaxId);
									
									//Set tmpBranchNo Old Get From SAP									
//									if(!StringUtils.equals("", tmpBranchNo))
									if(StringUtils.isNotEmpty(tmpBranchNo))
										vm.setBranchNo(tmpBranchNo);
									//Set Branch Old Get From SAP
									LOG.debug("tmpBranchNo Old Get From SAP : "+tmpBranchNo);
									LOG.debug("vm.getBranchNo() Get From SAP : "+vm.getBranchNo());
									LOG.debug("vm.getBranch() Get From SEM : "+vm.getBranch());
									
									System.out.println("tmpBranchNo Old Get From SAP : "+tmpBranchNo);
									System.out.println("vm.getBranchNo() Get From SAP : "+vm.getBranchNo());
									System.out.println("vm.getBranch() Get From SEM : "+vm.getBranch());
									
									
									if(resultWS.getWhtActionFlag() != null){
										vm.setWhtActionFlag(resultWS.getWhtActionFlag());
									}
									
									if(resultWS.getWhtActionFlag2() != null){
										vm.setWhtActionFlag2(resultWS.getWhtActionFlag2());
									}
									
									
									//Call WS Change Vendor (Sheet3)
									
									resultWS2 = sapService.chgVendor(vm);
									System.out.println(" CallWS Change Vendor sapService.chgVendor params : "+vm +" , resultWS2 : "+resultWS2);
									
									//check sap Change Vendor error connection
									if(resultWS2 != null){
										LOG.debug("vm.getTaxId() : "+vm.getTaxId());
										if(StringUtils.equals("S", resultWS2.getResult().toUpperCase()) && 
												(vm.getTaxId() != null && !StringUtils.equals("", vm.getTaxId()))){
											flag = true;
											resultWS.setResult(resultWS2.getResult());
											
											//Call WS Change block Vendor 
											resultWS3 = sapService.blkChangeUnBlkVen(vm);
											//check service blkChangeUnBlkVen connection
											if(resultWS3 != null){
												if(StringUtils.equals("S", resultWS3.getResult().toUpperCase())){
													flag = true;
													errFlag = false;
//													resultWS.setResult(resultWS3.getResult());
													paramsSP = new ItemParamsSP();
													paramsSP.setParam1("VD");
													paramsSP.setParam2(rowIdConcatParam);
													paramsSP.setParam3(""); //bookbankID
													paramsSP.setParam4(""); //payeeId
													paramsSP.setParam5(""); //payeeBookbankId
													paramsSP.setParam6(actionType); 
													paramsSP.setParam7("N"); //send to manager2 send param "Y"
													paramsSP.setParam8(getUserLogIn());
													paramsSP.setParam9(""); // remark case reject
													paramsSP.setParam10(resultWS3.getVendorCode());
													paramsSP.setParam11(resultWS3.getResult());
													paramsSP.setParam12(resultWS3.getRemark());
												}else{
													//service chgVendor return Error
//													resultWS = new MmmVendorMasterInfoSP();
//													resultWS.setResult(resultWS3.getResult());
//													resultWS.setRemark(resultWS3.getRemark());
//													resultWS.setActionType("SE");
													paramsSP = new ItemParamsSP();
													paramsSP.setParam1("VD");
													paramsSP.setParam2(rowIdConcatParam);
													paramsSP.setParam3(""); //bookbankID
													paramsSP.setParam4(""); //payeeId
													paramsSP.setParam5(""); //payeeBookbankId
													paramsSP.setParam6(actionType); 
													paramsSP.setParam7("N"); //send to manager2 send param "Y"
													paramsSP.setParam8(getUserLogIn());
													paramsSP.setParam9(""); // remark case reject
													paramsSP.setParam10(resultWS3.getVendorCode());
													paramsSP.setParam11(resultWS3.getResult());
													paramsSP.setParam12(resultWS3.getRemark());
													semmmm002Bean.setRemarkSapMSG("WS Change block Vendor Error : "+resultWS3.getRemark());
													errFlag = true;
												}
//												to = service.querySPList(EQueryName.SP_SEM_SAP_VENDOR_APPROVE.name, resultWS);
											}else{
												//service blkChangeUnBlkVen Error connection
//												resultWS = new MmmVendorMasterInfoSP();
//												resultWS.setVendorId(rowIdConcatParam);
//												resultWS.setActionType("SNC");
												
												paramsSP = new ItemParamsSP();
												paramsSP.setParam1("VD");
												paramsSP.setParam2(rowIdConcatParam);
												paramsSP.setParam3(""); //bookbankID
												paramsSP.setParam4(""); //payeeId
												paramsSP.setParam5(""); //payeeBookbankId
												paramsSP.setParam6(actionType); 
												paramsSP.setParam7("N"); //send to manager2 send param "Y"
												paramsSP.setParam8(getUserLogIn());
												paramsSP.setParam9(""); // remark case reject
//												paramsSP.setParam10(resultWS3.getVendorCode());
												paramsSP.setParam11("F");// case can't call SAP send param "F"
//												paramsSP.setParam12(resultWS3.getRemark());
												
												errFlag = true;
//												to = service.querySPList(EQueryName.SP_SEM_SAP_VENDOR_APPROVE.name, resultWS);
											}
											resultWS.setUserId(getUserLogIn());
//											to = service.querySPList(EQueryName.SP_SEM_SAP_VENDOR_APPROVE.name, resultWS);
											to2 = service.querySPList(EQueryName.SEM_SAP_CHANGE_STATUS.name, paramsSP);
										}else{
											//service chgVendor return Error
//											resultWS = new MmmVendorMasterInfoSP();
//											resultWS.setResult(resultWS2.getResult());
//											resultWS.setRemark(resultWS2.getRemark());
//											resultWS.setActionType("SE");
//											resultWS.setUserId(getUserLogIn());
//											to = service.querySPList(EQueryName.SP_SEM_SAP_VENDOR_APPROVE.name, resultWS);
											
											paramsSP = new ItemParamsSP();
											paramsSP.setParam1("VD");
											paramsSP.setParam2(rowIdConcatParam);
											paramsSP.setParam3(""); //bookbankID
											paramsSP.setParam4(""); //payeeId
											paramsSP.setParam5(""); //payeeBookbankId
											paramsSP.setParam6(actionType); 
											paramsSP.setParam7("N"); //send to manager2 send param "Y"
											paramsSP.setParam8(getUserLogIn());
											paramsSP.setParam9(""); // remark case reject
											paramsSP.setParam10(resultWS2.getVendorCode());
											paramsSP.setParam11(resultWS2.getResult());
											paramsSP.setParam12(resultWS2.getRemark());
											if(!StringUtils.equals("S", resultWS2.getResult().toUpperCase()))
													semmmm002Bean.setRemarkSapMSG("WS Change Vendor Error : "+resultWS2.getRemark());
											
											to2 = service.querySPList(EQueryName.SEM_SAP_CHANGE_STATUS.name, paramsSP);
											if(!StringUtils.equals("S", resultWS2.getResult().toUpperCase()))
												errFlag = true;
											else
												errFlag = false;
										}
									}else{
										//service chgVendor Error connection
//										resultWS = new MmmVendorMasterInfoSP();
//										resultWS.setVendorId(rowIdConcatParam);
//										resultWS.setActionType("SNC");
//										resultWS.setUserId(getUserLogIn());
										errFlag = true;
//										to = service.querySPList(EQueryName.SP_SEM_SAP_VENDOR_APPROVE.name, resultWS);
										
										paramsSP = new ItemParamsSP();
										paramsSP.setParam1("VD");
										paramsSP.setParam2(rowIdConcatParam);
										paramsSP.setParam3(""); //bookbankID
										paramsSP.setParam4(""); //payeeId
										paramsSP.setParam5(""); //payeeBookbankId
										paramsSP.setParam6(actionType); 
										paramsSP.setParam7("N"); //send to manager2 send param "Y"
										paramsSP.setParam8(getUserLogIn());
										paramsSP.setParam9(""); // remark case reject
//										paramsSP.setParam10(resultWS2.getVendorCode());
										paramsSP.setParam11("F");// case can't call SAP send param "F"
//										paramsSP.setParam12(resultWS2.getRemark());
										
										to2 = service.querySPList(EQueryName.SEM_SAP_CHANGE_STATUS.name, paramsSP);
									}
								}
							}else {
								errFlag = true;
								addGeneralMessageError( to.get(0).getRemark());
							}
						}
						
					}else{
						//service getvendor Error connection
//						resultWS = new MmmVendorMasterInfoSP();
//						resultWS.setVendorId(rowIdConcatParam);
//						resultWS.setActionType("SNC");
//						resultWS.setUserId(getUserLogIn());
						errFlag = true;
//						to = service.querySPList(EQueryName.SP_SEM_SAP_VENDOR_APPROVE.name, resultWS);
						
						paramsSP = new ItemParamsSP();
						paramsSP.setParam1("VD");
						paramsSP.setParam2(rowIdConcatParam);
						paramsSP.setParam3(""); //bookbankID
						paramsSP.setParam4(""); //payeeId
						paramsSP.setParam5(""); //payeeBookbankId
						paramsSP.setParam6(actionType); 
						paramsSP.setParam7("N"); //send to manager2 send param "Y"
						paramsSP.setParam8(getUserLogIn());
						paramsSP.setParam9(""); // remark case reject
//						paramsSP.setParam10(resultWS2.getVendorCode());
						paramsSP.setParam11("F");// case can't call SAP send param "F"
//						paramsSP.setParam12(resultWS2.getRemark());
						
						to2 = service.querySPList(EQueryName.SEM_SAP_CHANGE_STATUS.name, paramsSP);
					}
				}
			}else {
				errFlag = true;
				//addGeneralMessageError( result.get(0).getRemark());
			}
			
//			if(flag){
//				addMessageInfo("M0001");
//			}
			
		}catch (Exception e) {
			// TODO: handle exception
			errFlag = true;
			e.printStackTrace();
			LOG.debug("Error SEMMMM002Action doVendorApprove : "+e);
		}
		
		return errFlag;
	}
	
	public ArrayList getAllVendorWhtList(String whtListStr){
		LOG.info("::: SEMMMM002Action :: getAllVendorWhtList >> BEGIN :::");
		
		ArrayList tempList = new ArrayList();
		String vendorIdTempList = "";
//		String bookbankIdTempList = "";
//		String payeeIdTempList = "";
//		String bookbankPayeeIdTempList = "";
//		String vendorMapPayeeIdTempList = "";
		
		try{
//			semmmm002Bean = getSemmmm002Bean();
			
			List<WrapperBeanObject<Mmm001VendorMasterSP>> vendorTempResultList = new ArrayList<WrapperBeanObject<Mmm001VendorMasterSP>>();
			
			// condition with 2 tables cannot collected together
			// request changed 2017/06/07
			// lazy fixed low performance
			// >>
			// table ACTIVE (ACT)
//			vendorTempResultList = semmmm002Bean.getVendorMasterResultList();
			
			int countTmp = 0; // lazy checked for collect by only one table (for ignore table 2)
			
			for (WrapperBeanObject<Mmm001VendorMasterSP> obj : vendorTempResultList) {
				Mmm001VendorMasterSP contractSp = (Mmm001VendorMasterSP)obj.getDataObj();
				if(obj.isCheckBox()){
					String vendorId = contractSp.getVendorId() == null ? "":(String)contractSp.getVendorId();
					String bookbankId = contractSp.getBookbankId() == null ? "":(String)contractSp.getBookbankId();
					String payeeId = contractSp.getPayeeId() == null ? "":(String)contractSp.getPayeeId();
					String bookbankPayeeId = contractSp.getPayeeBookbankId() == null ? "":(String)contractSp.getPayeeBookbankId();
					String vendorMapPayeeId = contractSp.getVendorMapPayeeId() == null ? "" : (String)contractSp.getPayeeBookbankId();
					LOG.debug(">> (ACT) vendorId: " + vendorId);
					LOG.debug(">> (ACT) bookbankId: " + bookbankId);
					LOG.debug(">> (ACT) payeeId: " + payeeId);
					LOG.debug(">> (ACT) bookbankPayeeId: " + bookbankPayeeId);
					LOG.debug(">> (ACT) vendorMapPayeeId: " + vendorMapPayeeId);
					
//					vendorIdTempList.add(vendorId);
//					bookbankIdTempList.add(bookbankId);
//					payeeIdTempList.add(payeeId);
//					bookbankPayeeIdTempList.add(bookbankPayeeId);
					
					if(vendorId!=null && !StringUtils.equals("", vendorId) && !StringUtils.equals("null", vendorId))
						vendorIdTempList += vendorId.concat(",");
					
//					if(bookbankId!=null && !StringUtils.equals("", bookbankId) && !StringUtils.equals("null", bookbankId))
//						bookbankIdTempList += bookbankId.concat(",");
//					
//					if(payeeId!=null && !StringUtils.equals("", payeeId) && !StringUtils.equals("null", payeeId))
//						payeeIdTempList += payeeId.concat(",");
//					
//					if(bookbankPayeeId!=null && !StringUtils.equals("", bookbankPayeeId) && !StringUtils.equals("null", bookbankPayeeId))
//						bookbankPayeeIdTempList += bookbankPayeeId.concat(",");
//					
//					if(vendorMapPayeeId!=null && !StringUtils.equals("", vendorMapPayeeId) && !StringUtils.equals("null", vendorMapPayeeId))
//						vendorMapPayeeIdTempList += vendorMapPayeeId.concat(",");
				
					countTmp++;
				}
			}
			
			// table TERMINATE (TMN)
			
			// <<
			if(!StringUtils.equals("", vendorIdTempList))
				vendorIdTempList = vendorIdTempList.substring(0, vendorIdTempList.lastIndexOf(","));
			
//			if(!StringUtils.equals("", bookbankIdTempList))
//				bookbankIdTempList = bookbankIdTempList.substring(0, bookbankIdTempList.lastIndexOf(","));
//			
//			if(!StringUtils.equals("", payeeIdTempList))
//				payeeIdTempList = payeeIdTempList.substring(0, payeeIdTempList.lastIndexOf(","));
//			
//			if(!StringUtils.equals("", bookbankPayeeIdTempList))
//				bookbankPayeeIdTempList = bookbankPayeeIdTempList.substring(0, bookbankPayeeIdTempList.lastIndexOf(","));
//			
//			if(!StringUtils.equals("", vendorMapPayeeIdTempList))
//				vendorMapPayeeIdTempList = vendorMapPayeeIdTempList.substring(0, vendorMapPayeeIdTempList.lastIndexOf(","));
			
			tempList.add(vendorIdTempList);
//			tempList.add(bookbankIdTempList);
//			tempList.add(payeeIdTempList);
//			tempList.add(bookbankPayeeIdTempList);
//			tempList.add(vendorMapPayeeIdTempList);
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMMM002Action");
		} finally {
			LOG.info("::: SEMMMM002Action :: getAllVendorWhtList >> END :::");
		}
		return tempList;
	}
	
	public ArrayList getAllRowIdFromSelectedVendorMasterList(){
		LOG.info("::: SEMMMM002Action :: getRowIdFromVendorMasterList >> BEGIN :::");
		
		ArrayList tempList = new ArrayList();
		String vendorIdTempList = "";
		String bookbankIdTempList = "";
		String payeeIdTempList = "";
		String bookbankPayeeIdTempList = "";
		String vendorMapPayeeIdTempList = "";
		
		try{
			semmmm002Bean = getSemmmm002Bean();
			
			List<WrapperBeanObject<Mmm001VendorMasterSP>> vendorTempResultList = new ArrayList<WrapperBeanObject<Mmm001VendorMasterSP>>();
			
			// condition with 2 tables cannot collected together
			// request changed 2017/06/07
			// lazy fixed low performance
			// >>
			// table ACTIVE (ACT)
			vendorTempResultList = semmmm002Bean.getVendorMasterResultList();
			
			String tempId = "";
			
			int countTmp = 0; // lazy checked for collect by only one table (for ignore table 2)
			
			for (WrapperBeanObject<Mmm001VendorMasterSP> obj : vendorTempResultList) {
				Mmm001VendorMasterSP contractSp = (Mmm001VendorMasterSP)obj.getDataObj();
				if(obj.isCheckBox()){
					String vendorId = contractSp.getVendorId() == null ? "":(String)contractSp.getVendorId();
					String bookbankId = contractSp.getBookbankId() == null ? "":(String)contractSp.getBookbankId();
					String payeeId = contractSp.getPayeeId() == null ? "":(String)contractSp.getPayeeId();
					String bookbankPayeeId = contractSp.getPayeeBookbankId() == null ? "":(String)contractSp.getPayeeBookbankId();
					String vendorMapPayeeId = contractSp.getVendorMapPayeeId() == null ? "" : (String)contractSp.getPayeeBookbankId();
					LOG.debug(">> (ACT) vendorId: " + vendorId);
					LOG.debug(">> (ACT) bookbankId: " + bookbankId);
					LOG.debug(">> (ACT) payeeId: " + payeeId);
					LOG.debug(">> (ACT) bookbankPayeeId: " + bookbankPayeeId);
					LOG.debug(">> (ACT) vendorMapPayeeId: " + vendorMapPayeeId);
					
//					vendorIdTempList.add(vendorId);
//					bookbankIdTempList.add(bookbankId);
//					payeeIdTempList.add(payeeId);
//					bookbankPayeeIdTempList.add(bookbankPayeeId);
					
					if(vendorId!=null && !StringUtils.equals("", vendorId) && !StringUtils.equals("null", vendorId))
						vendorIdTempList += vendorId.concat(",");
					
					if(bookbankId!=null && !StringUtils.equals("", bookbankId) && !StringUtils.equals("null", bookbankId))
						bookbankIdTempList += bookbankId.concat(",");
					
					if(payeeId!=null && !StringUtils.equals("", payeeId) && !StringUtils.equals("null", payeeId))
						payeeIdTempList += payeeId.concat(",");
					
					if(bookbankPayeeId!=null && !StringUtils.equals("", bookbankPayeeId) && !StringUtils.equals("null", bookbankPayeeId))
						bookbankPayeeIdTempList += bookbankPayeeId.concat(",");
					
					if(vendorMapPayeeId!=null && !StringUtils.equals("", vendorMapPayeeId) && !StringUtils.equals("null", vendorMapPayeeId))
						vendorMapPayeeIdTempList += vendorMapPayeeId.concat(",");
				
					if(contractSp.getGroupNo() != null)tempId = contractSp.getGroupNo();
					countTmp++;
				}else if(tempId != null && !StringUtils.equals("", tempId) && StringUtils.equals(tempId, contractSp.getGroupNo())){
					String vendorId = contractSp.getVendorId() == null ? "":(String)contractSp.getVendorId();
					String bookbankId = contractSp.getBookbankId() == null ? "":(String)contractSp.getBookbankId();
					String payeeId = contractSp.getPayeeId() == null ? "":(String)contractSp.getPayeeId();
					String bookbankPayeeId = contractSp.getPayeeBookbankId() == null ? "":(String)contractSp.getPayeeBookbankId();
					String vendorMapPayeeId = contractSp.getVendorMapPayeeId() == null ? "" : (String)contractSp.getPayeeBookbankId();
					LOG.debug(">> (ACT) vendorId: " + vendorId);
					LOG.debug(">> (ACT) bookbankId: " + bookbankId);
					LOG.debug(">> (ACT) payeeId: " + payeeId);
					LOG.debug(">> (ACT) bookbankPayeeId: " + bookbankPayeeId);
					LOG.debug(">> (ACT) vendorMapPayeeId: " + vendorMapPayeeId);
					
//					vendorIdTempList.add(vendorId);
//					bookbankIdTempList.add(bookbankId);
//					payeeIdTempList.add(payeeId);
//					bookbankPayeeIdTempList.add(bookbankPayeeId);
					
					if(vendorId!=null && !StringUtils.equals("", vendorId) && !StringUtils.equals("null", vendorId))
						vendorIdTempList += vendorId.concat(",");
					
					if(bookbankId!=null && !StringUtils.equals("", bookbankId) && !StringUtils.equals("null", bookbankId))
						bookbankIdTempList += bookbankId.concat(",");
					
					if(payeeId!=null && !StringUtils.equals("", payeeId) && !StringUtils.equals("null", payeeId))
						payeeIdTempList += payeeId.concat(",");
					
					if(bookbankPayeeId!=null && !StringUtils.equals("", bookbankPayeeId) && !StringUtils.equals("null", bookbankPayeeId))
						bookbankPayeeIdTempList += bookbankPayeeId.concat(",");
					
					if(vendorMapPayeeId!=null && !StringUtils.equals("", vendorMapPayeeId) && !StringUtils.equals("null", vendorMapPayeeId))
						vendorMapPayeeIdTempList += vendorMapPayeeId.concat(",");
					
					countTmp++;
				}
			}
			
			// table TERMINATE (TMN)
			
			// <<
			if(!StringUtils.equals("", vendorIdTempList))
				vendorIdTempList = vendorIdTempList.substring(0, vendorIdTempList.lastIndexOf(","));
			
			if(!StringUtils.equals("", bookbankIdTempList))
				bookbankIdTempList = bookbankIdTempList.substring(0, bookbankIdTempList.lastIndexOf(","));
			
			if(!StringUtils.equals("", payeeIdTempList))
				payeeIdTempList = payeeIdTempList.substring(0, payeeIdTempList.lastIndexOf(","));
			
			if(!StringUtils.equals("", bookbankPayeeIdTempList))
				bookbankPayeeIdTempList = bookbankPayeeIdTempList.substring(0, bookbankPayeeIdTempList.lastIndexOf(","));
			
			if(!StringUtils.equals("", vendorMapPayeeIdTempList))
				vendorMapPayeeIdTempList = vendorMapPayeeIdTempList.substring(0, vendorMapPayeeIdTempList.lastIndexOf(","));
			
			tempList.add(vendorIdTempList);
			tempList.add(bookbankIdTempList);
			tempList.add(payeeIdTempList);
			tempList.add(bookbankPayeeIdTempList);
			tempList.add(vendorMapPayeeIdTempList);
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMMM002Action");
		} finally {
			LOG.info("::: SEMMMM002Action :: getRowIdFromVendorMasterList >> END :::");
		}
		return tempList;
	}
	
	private boolean initReject(){
		LOG.debug("Start initReject");
		semmmm002Bean = getSemmmm002Bean();
		String actionType = (String)getFacesUtils().getRequestParameter("actionType") == null ? "" : (String)getFacesUtils().getRequestParameter("actionType");
		String actionBtnType = (String)getFacesUtils().getRequestParameter("actionBtnType") == null ? "" : (String)getFacesUtils().getRequestParameter("actionBtnType");
		ArrayList<WrapperBeanObject<Mmm001VendorMasterSP>> rejectList = new ArrayList<WrapperBeanObject<Mmm001VendorMasterSP>>();
		ArrayList<WrapperBeanObject<Mmm001VendorMasterSP>> vendorList = new ArrayList<WrapperBeanObject<Mmm001VendorMasterSP>>();
//		ArrayList selectIdList = new ArrayList();
		String navProgramBack = (String)getFacesUtils().getRequestParameter("navProgramBack") == null ? "" : (String)getFacesUtils().getRequestParameter("navProgramBack");
		try{
			semmmm002Bean.setVendorMasterRejectList(new ArrayList<WrapperBeanObject<Mmm001VendorMasterSP>>());
			String todoFlag = getFacesUtils().getRequestParameter("todoFlag") == null ? "" : (String)getFacesUtils().getRequestParameter("todoFlag");
			String tempId = "";
//			String rowIdConcatParam = "";
////			ArrayList contractRowIdList = getAllRowIdFromSelectedVendorMasterList();
//			ArrayList contractRowIdList = semmmm002Bean.getSelectIdList();
//			LOG.debug(">> contractRowIdList: " + contractRowIdList);
//			for(Object s : contractRowIdList){
//				LOG.debug("ROW ID: " + s.toString());
////				rowIdConcatParam += s.toString().concat("|");
////				selectIdList.add(s.toString());
//				for(int i=0;i<semmmm002Bean.getVendorMasterResultList().size();i++){
//					rejectList.add(semmmm002Bean.getVendorMasterResultList());
//				}
//			}
			
//			rowIdConcatParam = rowIdConcatParam.substring(0, rowIdConcatParam.lastIndexOf("|"));
//			LOG.debug(">> rowIdConcatParam: " + rowIdConcatParam);
			vendorList.addAll(semmmm002Bean.getVendorMasterResultList());
			for (WrapperBeanObject<Mmm001VendorMasterSP> wrapperBeanObject : vendorList) {
				Mmm001VendorMasterSP o = (Mmm001VendorMasterSP) wrapperBeanObject.getDataObj();
				if(wrapperBeanObject.isCheckBox()){
					
					if (StringUtils.isNotEmpty(o.getRowId())) {
						
						rejectList.add(wrapperBeanObject);
					}
					
					if(o.getGroupNo() != null)tempId = o.getGroupNo();
				}else if(tempId != null && !StringUtils.equals("", tempId) && StringUtils.equals(tempId, o.getGroupNo())){
					if (StringUtils.isNotEmpty(o.getRowId())) {
						
						rejectList.add(wrapperBeanObject);
					}
				}
			}
			if(StringUtils.equals("Y", todoFlag) ){
				semmmm002Bean.setRenderedTodoRejectButton(true);
			}else{
				semmmm002Bean.setRenderedTodoRejectButton(false);
			}
			//set remark
			semmmm002Bean.setNavProgramBack(navProgramBack);
			semmmm002Bean.setRejectRemark("");	
			semmmm002Bean.setActionBtnType(actionBtnType);
			semmmm002Bean.setActionType(actionType);
//			rejectList.addAll(semmmm002Bean.getVendorMasterResultList());
			semmmm002Bean.setVendorMasterRejectList(rejectList);
		}catch (Exception e) {
			LOG.debug("Error SEMMMM002Action initReject");
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			setSemmmm002Bean(semmmm002Bean);
		}
		return true;
	}
	
	private boolean doReject() {
		LOG.info("::: SEMMMM002Action :: doReject >> BEGIN :::");
		boolean flag = false;
		String type = "";
		String rowIdParam = "";
		String btnEvent = "";
		IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
		List<ItemResultSP> result = null;
		ArrayList contractRowIdList = new ArrayList();
		try {
			
			semmmm002Bean = getSemmmm002Bean();
			//validate
			if(StringUtils.equals("", semmmm002Bean.getRejectRemark()) || StringUtils.isEmpty(semmmm002Bean.getRejectRemark())){
				addMessageError("W0001", msg("message.remark"));
//				flagValid = false;
				semmmm002Bean.setRenderedMsgFormSearch(true);
			
			}else{
				btnEvent = (String)getFacesUtils().getRequestParameter("btnEvent");
				String actionType = semmmm002Bean.getActionType();
				LOG.debug(">> btnEvent: " + btnEvent);
				
				String rowIdConcatParam = "";
//				ArrayList contractRowIdList = getAllRowIdFromSelectedVendorMasterList();
				contractRowIdList = semmmm002Bean.getSelectIdList();
				LOG.debug(">> contractRowIdList: " + contractRowIdList);
				for(Object s : contractRowIdList){
					LOG.debug("ROW ID: " + s.toString());
					rowIdConcatParam += s.toString().concat("|");
				}
				
				rowIdConcatParam = rowIdConcatParam.substring(0, rowIdConcatParam.lastIndexOf("|"));
				LOG.debug(">> rowIdConcatParam: " + rowIdConcatParam);
				
				ItemParamsSP params = new ItemParamsSP();
				params.setParam1(actionType);
				params.setParam2(rowIdConcatParam);
				params.setParam3(semmmm002Bean.getFlowStatus());	//statusFrom
				params.setParam4(semmmm002Bean.getRejectRemark());
				params.setParam5(getUserLogIn());
//				System.out.println("params.getParam1 : "+params.getParam1());
//				System.out.println("params.getParam2 : "+params.getParam2());
//				System.out.println("params.getParam3 : "+params.getParam3());
//				System.out.println("params.getParam4 : "+params.getParam4());
//				System.out.println("params.getParam5 : "+params.getParam5());
				result = service.querySPList(EQueryName.SEM_SAP_MANAGER_REJECT.name, params);
				
				if(result != null && !result.isEmpty()) {
					LOG.debug(">> result.size() = " + result.size());
					ItemResultSP obj = (ItemResultSP) result.get(0);
					if(!"SUCCESS".equals(obj.getResultType())){
						addMessageError(obj.getResultMessage());
						
					}else{
						addMessageInfo("M0003");
						if(!semmmm002Bean.isRenderedTodoRejectButton()){
							this.doSearch();
						}
						flag = true;
						
					}
//					LOG.debug(">> result = " + obj.toString());
				}
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMMM002Action");
			flag = false;
		} finally {
			setSemmmm002Bean(semmmm002Bean);
			LOG.info("::: SEMMMM002Action :: doReject >> END :::");
		}
		return flag;
	}
	
	public void selectedTeamController(){
//		boolean flag = true;
		
		try{
			semmmm002Bean = getSemmmm002Bean();
			
			 String type = getFacesUtils().getRequestParameter("type") == null ? "" : (String)getFacesUtils().getRequestParameter("type");
//			 String headerFlag = getFacesUtils().getRequestParameter("headerFlag") == null ? "" : (String)getFacesUtils().getRequestParameter("headerFlag");
			 String strParam = getFacesUtils().getRequestParameter("strParam") == null ? "" : (String)getFacesUtils().getRequestParameter("strParam");
			 String createById = getFacesUtils().getRequestParameter("createById") == null ? "" : (String)getFacesUtils().getRequestParameter("createById");
			 
//			 if(StringUtils.equals("VD", type)){
//				 semmmm002Bean.setMenuTreeVendorList(treeSwapMenu(semmmm002Bean.getMenuTreeVendorList())); 
//			 }else if(StringUtils.equals("VB", type)){
//				 semmmm002Bean.setMenuTreeVendorBookbankList(treeSwapMenu(semmmm002Bean.getMenuTreeVendorBookbankList())); 
//			 }else if(StringUtils.equals("PY", type)){
//				 semmmm002Bean.setMenuTreePayeeList(treeSwapMenu(semmmm002Bean.getMenuTreePayeeList())); 
//			 }else if(StringUtils.equals("PB", type)){
//				 semmmm002Bean.setMenuTreePayeeBookbankList(treeSwapMenu(semmmm002Bean.getMenuTreePayeeBookbankList())); 
//			 }else if(StringUtils.equals("AB", type)){
//				 semmmm002Bean.setMenuTreeAbnormalList(treeSwapMenu(semmmm002Bean.getMenuTreeAbnormalList())); 
//			 }
			 this.searchTodoList(type, strParam, createById);
			 
			 
			 
			 setSemmmm002Bean(semmmm002Bean);
		}catch (Exception e) {
//			flag = false;
			e.printStackTrace();
			LOG.debug("Error SEMMMM002Action selectedTeamController :: "+e);
			// TODO: handle exception
		}
		
//		return flag;
	}
	
	public void setStyleClassToNull(List<WrapperBeanObject<MenuTreeSP>> objList){
		try{
	
			for(WrapperBeanObject<MenuTreeSP> menuTreeWrapper : objList){
				WrapperBeanObject<MenuTreeSP> tmpWrapperBean = new WrapperBeanObject<MenuTreeSP>();
				if(menuTreeWrapper != null ){
					MenuTreeSP menuTree = (MenuTreeSP) menuTreeWrapper.getDataObj();
					menuTree.setStyleClass("");
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			LOG.debug("Error SEMMMM002Action setStyleClassToNull :: "+e);
		}
	}
	
	public boolean processSelectedMenu(){
		boolean flag = true;
		try{
			semmmm002Bean = getSemmmm002Bean();
			
			 String type = getFacesUtils().getRequestParameter("type") == null ? "" : (String)getFacesUtils().getRequestParameter("type");
			 String headerFlag = getFacesUtils().getRequestParameter("headerFlag") == null ? "" : (String)getFacesUtils().getRequestParameter("headerFlag");
			 String strParam = getFacesUtils().getRequestParameter("strParam") == null ? "" : (String)getFacesUtils().getRequestParameter("strParam");
			 
			 if(StringUtils.equals("VD", type)){
				 semmmm002Bean.setMenuTreeVendorList(treeSwapMenu(semmmm002Bean.getMenuTreeVendorList())); 
			 }else if(StringUtils.equals("VB", type)){
				 semmmm002Bean.setMenuTreeVendorBookbankList(treeSwapMenu(semmmm002Bean.getMenuTreeVendorBookbankList()));
			 }else if(StringUtils.equals("PY", type)){
				 semmmm002Bean.setMenuTreePayeeList(treeSwapMenu(semmmm002Bean.getMenuTreePayeeList())); 
			 }else if(StringUtils.equals("PB", type)){
				 semmmm002Bean.setMenuTreePayeeBookbankList(treeSwapMenu(semmmm002Bean.getMenuTreePayeeBookbankList())); 
			 }else if(StringUtils.equals("AB", type)){
				 semmmm002Bean.setMenuTreeAbnormalList(treeSwapMenu(semmmm002Bean.getMenuTreeAbnormalList())); 
			 }else if(StringUtils.equals("CB", type)){
				 semmmm002Bean.setMenuTreeCreateByList(treeSwapMenu(semmmm002Bean.getMenuTreeCreateByList()));
			 }
			 
			 if(StringUtils.equals("N", headerFlag) ){
				 if(StringUtils.equals("VD", type)){
					 setStyleClassToNull(semmmm002Bean.getMenuTreeVendorBookbankList());//VB
					 setStyleClassToNull(semmmm002Bean.getMenuTreePayeeList());//PY
					 setStyleClassToNull(semmmm002Bean.getMenuTreePayeeBookbankList());//PB
					 setStyleClassToNull(semmmm002Bean.getMenuTreeAbnormalList());//AB
					 setStyleClassToNull(semmmm002Bean.getMenuTreeCreateByList());//CB
					 semmmm002Bean.setTogPnlVD(true);
				 }
				 if(StringUtils.equals("VB", type)){
					 setStyleClassToNull(semmmm002Bean.getMenuTreeVendorList());//VD 
					 setStyleClassToNull(semmmm002Bean.getMenuTreePayeeList());//PY
					 setStyleClassToNull(semmmm002Bean.getMenuTreePayeeBookbankList());//PB
					 setStyleClassToNull(semmmm002Bean.getMenuTreeAbnormalList());//AB
					 setStyleClassToNull(semmmm002Bean.getMenuTreeCreateByList());//CB
					 semmmm002Bean.setTogPnlVB(true);
				 }
				 if(StringUtils.equals("PY", type)){
					 setStyleClassToNull(semmmm002Bean.getMenuTreeVendorList());//VD 
					 setStyleClassToNull(semmmm002Bean.getMenuTreeVendorBookbankList());//VB
					 setStyleClassToNull(semmmm002Bean.getMenuTreePayeeBookbankList());//PB
					 setStyleClassToNull(semmmm002Bean.getMenuTreeAbnormalList());//AB
					 setStyleClassToNull(semmmm002Bean.getMenuTreeCreateByList());//CB
					 semmmm002Bean.setTogPnlPY(true);
				 }
				 if(StringUtils.equals("PB", type)){
					 setStyleClassToNull(semmmm002Bean.getMenuTreeVendorList());//VD 
					 setStyleClassToNull(semmmm002Bean.getMenuTreeVendorBookbankList());//VB
					 setStyleClassToNull(semmmm002Bean.getMenuTreePayeeList());//PY
					 setStyleClassToNull(semmmm002Bean.getMenuTreeAbnormalList());//AB
					 setStyleClassToNull(semmmm002Bean.getMenuTreeCreateByList());//CB
					 semmmm002Bean.setTogPnlPB(true);
				 }
				 if(StringUtils.equals("AB", type)){
					 setStyleClassToNull(semmmm002Bean.getMenuTreeVendorList());//VD 
					 setStyleClassToNull(semmmm002Bean.getMenuTreeVendorBookbankList());//VB
					 setStyleClassToNull(semmmm002Bean.getMenuTreePayeeList());//PY
					 setStyleClassToNull(semmmm002Bean.getMenuTreePayeeBookbankList());//PB
					 setStyleClassToNull(semmmm002Bean.getMenuTreeCreateByList());//CB
					 semmmm002Bean.setTogPnlAB(true);
				 }
				 if(StringUtils.equals("CB", type)){
					 setStyleClassToNull(semmmm002Bean.getMenuTreeVendorList());//VD 
					 setStyleClassToNull(semmmm002Bean.getMenuTreeVendorBookbankList());//VB
					 setStyleClassToNull(semmmm002Bean.getMenuTreePayeeList());//PY
					 setStyleClassToNull(semmmm002Bean.getMenuTreePayeeBookbankList());//PB
					 setStyleClassToNull(semmmm002Bean.getMenuTreeAbnormalList());//AB
					 semmmm002Bean.setTogPnlCB(true);
				 }
				 semmmm002Bean.setSearchType(type);
				 this.searchTodoList(type, strParam, "");
			 }
			 
			 
			 setSemmmm002Bean(semmmm002Bean);
		}catch (Exception e) {
			flag = false;
			e.printStackTrace();
			LOG.debug("Error SEMMMM002Action processSelectedMenu :: "+e);
			// TODO: handle exception
		}
		
		return flag;
	}
		
	public List<WrapperBeanObject<MenuTreeSP>> treeSwapMenu(List<WrapperBeanObject<MenuTreeSP>> objList) {
		LOG.info("::: SEMMMM024Action :: treeSwapPage >> BEGIN :::");
		boolean flag = false;
		ArrayList<MenuTreeSP> menuTreeList = new ArrayList<MenuTreeSP>();
		List<WrapperBeanObject<MenuTreeSP>> menuWrapperList = new ArrayList<WrapperBeanObject<MenuTreeSP>>();
		try {
			
			semmmm002Bean = getSemmmm002Bean();

	        String rowId = getFacesUtils().getRequestParameter("rowId") == null ? "" : (String)getFacesUtils().getRequestParameter("rowId");
	        String headerFlag = getFacesUtils().getRequestParameter("headerFlag") == null ? "" : (String)getFacesUtils().getRequestParameter("headerFlag");
	        String mainId = getFacesUtils().getRequestParameter("mainId") == null ? "" : (String)getFacesUtils().getRequestParameter("mainId");
	        String refId = getFacesUtils().getRequestParameter("refId") == null ? "" : (String)getFacesUtils().getRequestParameter("refId");
	        String renderedFlag = getFacesUtils().getRequestParameter("renderedFlag") == null ? "" : (String)getFacesUtils().getRequestParameter("renderedFlag");
	        String actionFlag = getFacesUtils().getRequestParameter("actionFlag") == null ? "" : (String)getFacesUtils().getRequestParameter("actionFlag");
	        String menuGroup = getFacesUtils().getRequestParameter("menuGroup") == null ? "" : (String)getFacesUtils().getRequestParameter("menuGroup");
	        String menuLevel = getFacesUtils().getRequestParameter("menuLevel") == null ? "" : (String)getFacesUtils().getRequestParameter("menuLevel");
	        
//	        LOG.debug("rowId = "+rowId);
//	        LOG.debug("headerFlag = "+headerFlag);
//	        LOG.debug("mainId = "+mainId);
//	        LOG.debug("refId = "+refId);
//	        LOG.debug("renderedFlag = "+renderedFlag);
//	        LOG.debug("actionFlag = "+actionFlag);
//	        LOG.debug("menuGroup = "+menuGroup);
//	        LOG.debug("menuLevel = "+menuLevel);
//	        LOG.debug("-----------------------------------------------------------");
//	        String paramMenuType = (String)getFacesUtils().getRequestParameter("paramMenuType");
//			String paramUrl = semmmm002Bean.getParamUrl();
//	        String paramMenuGroup = semmmm002Bean.getParamMenuGroup();
	        
//	        System.out.println("paramUrl = "+paramUrl);
//	        System.out.println("paramMenuGroup = "+paramMenuGroup);
	        
			if(!"".equals(rowId) ){
				
			
					flag = true;
					
					for(WrapperBeanObject<MenuTreeSP> menuTreeWrapper : objList){
						WrapperBeanObject<MenuTreeSP> tmpWrapperBean = new WrapperBeanObject<MenuTreeSP>();
						if(menuTreeWrapper != null ){
							MenuTreeSP menuTree = (MenuTreeSP) menuTreeWrapper.getDataObj();
							if(StringUtils.equals(menuGroup, menuTree.getMenuGroup())){
							
//								LOG.debug("meinId : "+mainId);
//								LOG.debug("rowId : "+rowId);
//								LOG.debug("menuTree.getRowId() : "+menuTree.getRowId());
//								LOG.debug("refid : "+menuTree.getRefId());
//								LOG.debug("headerFlag : "+headerFlag);
//								LOG.debug("actionFlag : "+actionFlag);
//								LOG.debug("rendered : "+menuTree.isRenderedFlag());
//								LOG.debug("DisableFlag : "+menuTree.isDisableFlag());
//								LOG.debug("label "+menuTree.getMenuLabel());
//								LOG.debug("length 1: "+menuTree.getMenuLevel().length()+" length2 : "+menuLevel.length());
								
								
								
								if(menuTree.getRefId().intValue() > 0 && StringUtils.equals(mainId, menuTree.getRefId().toString())){
									if(menuTree.isRenderedFlag()){
										menuTree.setRenderedFlag(false);
										menuTree.setDisableFlag(false);
										menuTree.setStyleClass("");
									}else{
										menuTree.setRenderedFlag(true);
										menuTree.setDisableFlag(true);
									}							
								}else{
									menuTree.setStyleClass("");
								}
								
								if(StringUtils.equals("N", headerFlag)
										&& StringUtils.equals(rowId,menuTree.getRowId())){
									menuTree.setStyleClass("ms7redBold");
								}
								
								if(StringUtils.equals("false", actionFlag.toLowerCase()) && 
										Integer.parseInt(mainId) < menuTree.getMainId().intValue() &&
										menuTree.getMenuLevel().length() > menuLevel.length() &&
										 menuTree.isRenderedFlag()){
									menuTree.setRenderedFlag(false);
									menuTree.setDisableFlag(false);
								}
								
								if(StringUtils.equals(mainId, menuTree.getMainId().toString()) && 
										StringUtils.equals("true", actionFlag.toLowerCase())){
									menuTree.setDisableFlag(false);
								}else if(StringUtils.equals(mainId, menuTree.getMainId().toString()) && 
										StringUtils.equals("false", actionFlag.toLowerCase())){
									menuTree.setDisableFlag(true);
								}
								
							}else{
								menuTree.setStyleClass("");
							}
							
//							LOG.debug("renderFlag = " +menuTree.isRenderedFlag());
									
							tmpWrapperBean.setDataObj(menuTree);
							tmpWrapperBean.setMessage("");
							menuWrapperList.add(tmpWrapperBean);
		        		
					
							LOG.debug("-----------------------------------------------------------");
						}
					}
				
//				semmmm002Bean.setMenuTreeVendorList(menuWrapperList);
//	        	semmmm002Bean.setScrollerPage("1");
				setSemmmm002Bean(semmmm002Bean);
			}
	        
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMMM002Action");
			flag = false;
			
		} finally {
			LOG.info("::: SEMMMM002Action :: treeSwapPage >> END :::");
		}
		return menuWrapperList;
	}
	
	private boolean searchTodoList() {
		LOG.info("::: SEMMMM002Action :: searchContractList >> BEGIN :::");
		boolean flag = true;
		IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
		List<Mmm001VendorMasterSP> to = null;
		
		try {
			semmmm002Bean = getSemmmm002Bean();
//			if(validate){
//				
//			}
			semmmm002Bean.setVendorMasterResultList(new ArrayList<WrapperBeanObject<Mmm001VendorMasterSP>>());
			
//			setSemmmm002Bean(semmmm002Bean);
			
//			if(semmmm002Bean.isChkPicoType()){
//				semmmm002Bean.getCriteria().setSystemType("PICO");
//			}
//			semmmm002Bean.getCriteria().setCreateBy(getUserLogIn());
			
			//TODO concat region from search criteria added by NEW 01/06/2018
			String region = this.doConcatRegion();
			LOG.debug("region after concat : "+region);
			if(region != null){
				semmmm002Bean.getCriteriaToDoList().setRegion(region);
			}
			
			LOG.debug("criteria: " + semmmm002Bean.getCriteria().toString());
			semmmm002Bean.getCriteriaToDoList().setPageFlag("M");
			
			String type = StringUtils.isNotEmpty((String)getFacesUtils().getRequestParameter("searchType"))?(String)getFacesUtils().getRequestParameter("searchType"):semmmm002Bean.getSearchType();
			LOG.debug("type = "+type);
			semmmm002Bean.getCriteriaToDoList().setMenuGroup(type);
			
			semmmm002Bean.getCriteriaToDoList().setStrParam("");
//			semmmm002Bean.getCriteriaToDoList().setMenuGroup("SR");
//			semmmm002Bean.getCriteriaToDoList().setStrParam(strParam);
//			semmmm002Bean.getCriteriaToDoList().setCreateById(createById);
//			System.out.println("menuGroup : "+menuGroup);
//			System.out.println("strParam : "+strParam);
//			System.out.println("createById : "+createById);
			
			if(semmmm002Bean.isChkPicoType()){
				semmmm002Bean.getCriteriaToDoList().setSystemType("PICO");
			} else {
				semmmm002Bean.getCriteriaToDoList().setSystemType("");
			}
			
			to = service.querySPList(EQueryName.SEM_SAP_SP_TODO_VENDOR_SEARCH.name, semmmm002Bean.getCriteriaToDoList());
			
			if (null == to || to.isEmpty()) {
//				addMessageError(to.get(0).getRemark());
				semmmm002Bean.setRenderedMsgDataNotFound(true);
			} else {
				semmmm002Bean.setRenderedMsgDataNotFound(false);
				
				String tempId = "";
				
//				LOG.debug("to.size() = "+to.size());
				for (int i=0; i<to.size(); i++) {
					Mmm001VendorMasterSP o = to.get(i);
					WrapperBeanObject<Mmm001VendorMasterSP> tmpWrapperBean = new WrapperBeanObject<Mmm001VendorMasterSP>();
					
//					o.setAccountName("xxxxx");
					
					if(o.getActionTypeDisplay() != null){
						o.setActionTypeDisplay(StringUtils.substring(o.getActionTypeDisplay(), 0, o.getActionTypeDisplay().lastIndexOf(",")));
						LOG.debug("Action Detail Sub Last , : "+o.getActionTypeDisplay());
					}
					
					if(o.getOtherStatus() != null){
						o.setOtherStatus(StringUtils.substring(o.getOtherStatus(), 0, o.getOtherStatus().lastIndexOf(",")));
						LOG.debug("Other Status Sub Last , : "+o.getOtherStatus());
					}
					
					if(o.getContractEffectiveDt() != null){
						o.setContractEffectiveDtStr(convertYearENtoTHStr(o.getContractEffectiveDt()));
					}
					
					if(o.getContractExpireDt() != null){
						o.setContractExpireDtStr(convertYearENtoTHStr(o.getContractExpireDt()));
					}
					
					if(o.getGroupNo() != null && tempId.equals(o.getGroupNo())){
						 o.setRenderColumn(false);
						 o.setRowSpan("0");
					}else{
						if(o.getGroupNo() != null){
							tempId = o.getGroupNo();
						}
						o.setRenderColumn(true);
//						o.setRowSpan("2");
					 }
					
					tmpWrapperBean.setDataObj(o);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					semmmm002Bean.getVendorMasterResultList().add(tmpWrapperBean);
				}
				setSemmmm002Bean(semmmm002Bean);
//				this.checkRenderedBtn(menuGroup);
			}
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			flag = false;
			addMessageError("EL0000", "SEMMMM002Action searchTodoList");
		} finally {
			setSemmmm002Bean(semmmm002Bean);
			LOG.info("::: SEMMMM002Action :: searchTodoList >> END :::");
		}
		return flag;
	}
	

	private void searchTodoList(String menuGroup,String strParam, String createById) {
		LOG.info("::: SEMMMM002Action :: searchContractList >> BEGIN :::");
		
		IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
		List<Mmm001VendorMasterSP> to = null;
		
		try {
			semmmm002Bean = getSemmmm002Bean();
//			if(validate){
//				
//			}
			semmmm002Bean.setVendorMasterResultList(new ArrayList<WrapperBeanObject<Mmm001VendorMasterSP>>());
			
//			setSemmmm002Bean(semmmm002Bean);
			
//			if(semmmm002Bean.isChkPicoType()){
//				semmmm002Bean.getCriteria().setSystemType("PICO");
//			}
//			semmmm002Bean.getCriteria().setCreateBy(getUserLogIn());
			LOG.debug("criteria: " + semmmm002Bean.getCriteria().toString());
			semmmm002Bean.getCriteriaToDoList().setPageFlag("M");
			semmmm002Bean.getCriteriaToDoList().setMenuGroup(menuGroup);
			semmmm002Bean.getCriteriaToDoList().setStrParam(strParam);
			semmmm002Bean.getCriteriaToDoList().setCreateById(createById);
			semmmm002Bean.getCriteriaToDoList().setRegion("");
//			System.out.println("menuGroup : "+menuGroup);
//			System.out.println("strParam : "+strParam);
//			System.out.println("createById : "+createById);
			
			if(semmmm002Bean.isChkPicoType()){
				semmmm002Bean.getCriteriaToDoList().setSystemType("PICO");
			} else {
				semmmm002Bean.getCriteriaToDoList().setSystemType("");
			}
			
			to = service.querySPList(EQueryName.SEM_SAP_SP_TODO_VENDOR_SEARCH.name, semmmm002Bean.getCriteriaToDoList());
			
			if (null == to || to.isEmpty()) {
//				addMessageError(to.get(0).getRemark());
				semmmm002Bean.setRenderedMsgDataNotFound(true);
			} else {
				semmmm002Bean.setRenderedMsgDataNotFound(false);
				
				String tempId = "";
				
//				LOG.debug("to.size() = "+to.size());
				for (int i=0; i<to.size(); i++) {
					Mmm001VendorMasterSP o = to.get(i);
					WrapperBeanObject<Mmm001VendorMasterSP> tmpWrapperBean = new WrapperBeanObject<Mmm001VendorMasterSP>();
					LOG.debug("getPayeeBookbankFlowStatus() : "+o.getPayeeBookbankFlowStatus());
//					o.setAccountName("xxxxx");
					if(o.getContractEffectiveDt() != null){
						o.setContractEffectiveDtStr(convertYearENtoTHStr(o.getContractEffectiveDt()));
					}
					
					if(o.getContractExpireDt() != null){
						o.setContractExpireDtStr(convertYearENtoTHStr(o.getContractExpireDt()));
					}
					
					if(o.getGroupNo() != null && tempId.equals(o.getGroupNo())){
						 o.setRenderColumn(false);
						 o.setRowSpan("0");
					}else{
						if(o.getGroupNo() != null){
							tempId = o.getGroupNo();
						}
						o.setRenderColumn(true);
//						o.setRowSpan("2");
					 }
					
					tmpWrapperBean.setDataObj(o);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					semmmm002Bean.getVendorMasterResultList().add(tmpWrapperBean);
				}
				setSemmmm002Bean(semmmm002Bean);
				this.checkRenderedBtn(menuGroup);
				this.selectRow();
			}
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMMM002Action searchTodoList");
		} finally {
			setSemmmm002Bean(semmmm002Bean);
			LOG.info("::: SEMMMM002Action :: searchTodoList >> END :::");
		}
	}
	
	private boolean searchTodoListAfterAction() {
		LOG.info("::: SEMMMM002Action :: searchTodoListAfterAction >> BEGIN :::");
		boolean flag = true;
		IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
		List<Mmm001VendorMasterSP> to = null;
		
		try {
			semmmm002Bean = getSemmmm002Bean();
//			if(validate){
//				
//			}
			semmmm002Bean.setVendorMasterResultList(new ArrayList<WrapperBeanObject<Mmm001VendorMasterSP>>());
			
//			setSemmmm002Bean(semmmm002Bean);
			
//			if(semmmm002Bean.isChkPicoType()){
//				semmmm002Bean.getCriteria().setSystemType("PICO");
//			}
//			semmmm002Bean.getCriteria().setCreateBy(getUserLogIn());
			LOG.debug("criteria: " + semmmm002Bean.getCriteria().toString());
//			semmmm002Bean.getCriteriaToDoList().setPageFlag("M");
			
//			String type = StringUtils.isNotEmpty((String)getFacesUtils().getRequestParameter("searchType"))?(String)getFacesUtils().getRequestParameter("searchType"):semmmm002Bean.getSearchType();
//			LOG.debug("type = "+type);
//			semmmm002Bean.getCriteriaToDoList().setMenuGroup(type);
			
//			semmmm002Bean.getCriteriaToDoList().setMenuGroup("SR");
//			semmmm002Bean.getCriteriaToDoList().setStrParam(strParam);
//			semmmm002Bean.getCriteriaToDoList().setCreateById(createById);
//			System.out.println("menuGroup : "+menuGroup);
//			System.out.println("strParam : "+strParam);
//			System.out.println("createById : "+createById);
			
//			if(semmmm002Bean.isChkPicoType()){
//				semmmm002Bean.getCriteriaToDoList().setSystemType("PICO");
//			} else {
//				semmmm002Bean.getCriteriaToDoList().setSystemType("");
//			}
			
			to = service.querySPList(EQueryName.SEM_SAP_SP_TODO_VENDOR_SEARCH.name, semmmm002Bean.getCriteriaToDoList());
			
			if (null == to || to.isEmpty()) {
//				addMessageError(to.get(0).getRemark());
				semmmm002Bean.setRenderedMsgDataNotFound(true);
			} else {
				semmmm002Bean.setRenderedMsgDataNotFound(false);
				
				String tempId = "";
				
//				LOG.debug("to.size() = "+to.size());
				for (int i=0; i<to.size(); i++) {
					Mmm001VendorMasterSP o = to.get(i);
					WrapperBeanObject<Mmm001VendorMasterSP> tmpWrapperBean = new WrapperBeanObject<Mmm001VendorMasterSP>();
					
//					o.setAccountName("xxxxx");
					
					if(o.getActionTypeDisplay() != null){
						o.setActionTypeDisplay(StringUtils.substring(o.getActionTypeDisplay(), 0, o.getActionTypeDisplay().lastIndexOf(",")));
						LOG.debug("Action Detail Sub Last , : "+o.getActionTypeDisplay());
					}
					
					if(o.getOtherStatus() != null){
						o.setOtherStatus(StringUtils.substring(o.getOtherStatus(), 0, o.getOtherStatus().lastIndexOf(",")));
						LOG.debug("Other Status Sub Last , : "+o.getOtherStatus());
					}
					
					if(o.getContractEffectiveDt() != null){
						o.setContractEffectiveDtStr(convertYearENtoTHStr(o.getContractEffectiveDt()));
					}
					
					if(o.getContractExpireDt() != null){
						o.setContractExpireDtStr(convertYearENtoTHStr(o.getContractExpireDt()));
					}
					
					if(o.getGroupNo() != null && tempId.equals(o.getGroupNo())){
						 o.setRenderColumn(false);
						 o.setRowSpan("0");
					}else{
						if(o.getGroupNo() != null){
							tempId = o.getGroupNo();
						}
						o.setRenderColumn(true);
//						o.setRowSpan("2");
					 }
					
					tmpWrapperBean.setDataObj(o);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					semmmm002Bean.getVendorMasterResultList().add(tmpWrapperBean);
				}
				setSemmmm002Bean(semmmm002Bean);
//				this.checkRenderedBtn(menuGroup);
				this.selectRow();
			}
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			flag = false;
			addMessageError("EL0000", "SEMMMM002Action searchTodoListAfterAction");
		} finally {
			setSemmmm002Bean(semmmm002Bean);
			LOG.info("::: SEMMMM002Action :: searchTodoListAfterAction >> END :::");
		}
		return flag;
	}
	
	public void checkRenderedBtn(String type){
		try{
			semmmm002Bean = getSemmmm002Bean();
			//set defult rendered btn
			semmmm002Bean.setRenderedBtnApproveVendor(false);
			semmmm002Bean.setRenderedBtnRejectVendor(false);
			semmmm002Bean.setRenderedBtnSendVendorToMNG2(false);
			semmmm002Bean.setRenderedBtnMNG2ApproveVendor(false);
			semmmm002Bean.setRenderedBtnMNG2RejectVendor(false);
			
			semmmm002Bean.setRenderedBtnApproveBookbank(false);
			semmmm002Bean.setRenderedBtnRejectBookbank(false);
			semmmm002Bean.setRenderedBtnSendBookbankToMNG2(false);
			semmmm002Bean.setRenderedBtnMNG2ApproveBookbank(false);
			semmmm002Bean.setRenderedBtnMNG2RejectBookbank(false);
			
			semmmm002Bean.setRenderedBtnApprovePayee(false);
			semmmm002Bean.setRenderedBtnRejectPayee(false);
			semmmm002Bean.setRenderedBtnSendPayeeToMNG2(false);
			semmmm002Bean.setRenderedBtnMNG2ApprovePayee(false);
			semmmm002Bean.setRenderedBtnMNG2RejectPayee(false);
			
			semmmm002Bean.setRenderedBtnApprovePayeeBookbank(false);
			semmmm002Bean.setRenderedBtnRejectPayeeBookbank(false);
			semmmm002Bean.setRenderedBtnSendPayeeBookbankToMNG2(false);
			semmmm002Bean.setRenderedBtnMNG2ApprovePayeeBookbank(false);
			semmmm002Bean.setRenderedBtnMNG2RejectPayeeBookbank(false);
			
			if(StringUtils.equals("VD", type)){
				semmmm002Bean.setRenderedBtnApproveVendor(true);
				semmmm002Bean.setRenderedBtnRejectVendor(true);
				semmmm002Bean.setRenderedBtnSendVendorToMNG2(true);
				semmmm002Bean.setRenderedBtnMNG2ApproveVendor(true);
				semmmm002Bean.setRenderedBtnMNG2RejectVendor(true);
			}else if(StringUtils.equals("VB", type)){
				semmmm002Bean.setRenderedBtnApproveBookbank(true);
				semmmm002Bean.setRenderedBtnRejectBookbank(true);
				semmmm002Bean.setRenderedBtnSendBookbankToMNG2(true);
				semmmm002Bean.setRenderedBtnMNG2ApproveBookbank(true);
				semmmm002Bean.setRenderedBtnMNG2RejectBookbank(true);
			}else if(StringUtils.equals("PY", type)){
				semmmm002Bean.setRenderedBtnApprovePayee(true);
				semmmm002Bean.setRenderedBtnRejectPayee(true);
				semmmm002Bean.setRenderedBtnSendPayeeToMNG2(true);
				semmmm002Bean.setRenderedBtnMNG2ApprovePayee(true);
				semmmm002Bean.setRenderedBtnMNG2RejectPayee(true);
			}else if(StringUtils.equals("PB", type)){
				semmmm002Bean.setRenderedBtnApprovePayeeBookbank(true);
				semmmm002Bean.setRenderedBtnRejectPayeeBookbank(true);
				semmmm002Bean.setRenderedBtnSendPayeeBookbankToMNG2(true);
				semmmm002Bean.setRenderedBtnMNG2ApprovePayeeBookbank(true);
				semmmm002Bean.setRenderedBtnMNG2RejectPayeeBookbank(true);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
			LOG.debug("Error SEMMMM002Action checkRenderedBtn");
			// TODO: handle exception
		}finally{
			setSemmmm002Bean(semmmm002Bean);
		}
	}
	
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// test menu util >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
//	private TreeNode rootNode = null;
    private List<String> selectedNodeChildren = new ArrayList<String>();    
    
    private String nodeTitle;
    private MenuTreeSP nodeValue;
    private MenuTreeSP menuRoot;
    
    private void loadTree() {
        try {
        	semmmm002Bean = getSemmmm002Bean();
        	List<MenuTreeSP> menuTreeList = null;
        	List<WrapperBeanObject<MenuTreeSP>> menuTreeWrapList = new ArrayList<WrapperBeanObject<MenuTreeSP>>();
        	//// >>
        	MenuTreeSP myParam = new MenuTreeSP();
        	List<Object> mySendList = new ArrayList<Object>();
        	
        	IMenuTreeService service = (IMenuTreeService)getBean("menuTreeService");
        	
        	String groupType[] = {"VD", "VB", "PY", "PB", "AB", "CB"};
        	
        	for(String mnGrp : groupType) {
        		myParam.setMenuGroup(mnGrp);
	        	myParam.setUserLogin(getUserLogIn());
//	        	myParam.setCreateBy(getUserLogIn());
	        	myParam.setPageFlag("M");
	        	
//	        	List<MenuTreeSP> menuTreeList = null;
	        	menuTreeList = service.querySPList(EQueryName.SEM_SAP_GET_TODO_MENU.name, myParam);

        		Map<String, Object> myMap = new HashMap<String, Object>();
	        	
	        	if(menuTreeList != null && !menuTreeList.isEmpty()){

	        		/// >
	        		for(int j=0; j<menuTreeList.size(); j++){
	        			String mLevel = menuTreeList.get(j).getMenuLevel();
	        			if(mLevel.length() == 2){
	        				menuTreeList.get(j).setRenderedFlag(true);
	        				menuTreeList.get(j).setDisableFlag(true);
	        			}else{
	        				menuTreeList.get(j).setRenderedFlag(false);
	        				menuTreeList.get(j).setDisableFlag(false);
	        			}
	        			
	        			if(StringUtils.isEmpty(menuTreeList.get(j).getRecordCount()) || StringUtils.equals("0", menuTreeList.get(j).getRecordCount())){
	        				menuTreeList.get(j).setRenderedFlag(false);
	        			}
	        			
	        			if(StringUtils.equals("VD", mnGrp)){
	        				semmmm002Bean.setTotalSumVendor(menuTreeList.get(j).getTotalSum());
	        			}else if(StringUtils.equals("VB", mnGrp)){
	        				semmmm002Bean.setTotalSumVendorBookbank(menuTreeList.get(j).getTotalSum());
	        			}else if(StringUtils.equals("PY", mnGrp)){
	        				semmmm002Bean.setTotalSumPayee(menuTreeList.get(j).getTotalSum());
	        			}else if(StringUtils.equals("PB", mnGrp)){
	        				semmmm002Bean.setTotalSumPayeeBookbank(menuTreeList.get(j).getTotalSum());
	        			}else if(StringUtils.equals("AB", mnGrp)){
	        				semmmm002Bean.setTotalSumAbnormal(menuTreeList.get(j).getTotalSum());
	        			}else if(StringUtils.equals("CB", mnGrp)){
	        				semmmm002Bean.setTotalSumCreateBy(menuTreeList.get(j).getTotalSum());
	        			}
	        			
        				myMap.put(mLevel, menuTreeList.get(j));
        				//System.out.println("---------- mLevel ["+ mLevel +"] >> " + myMap.get(mLevel));
	        		}
	        		mySendList.add(myMap);
	        		/// <
//	        		for(MenuTreeSP menuTree : menuTreeList){
////	        			VendorMasterSP vm = (MenuTreeSP)vendorMasterList.get(i);
//						WrapperBeanObject<MenuTreeSP> tmpWrapperBean = new WrapperBeanObject<MenuTreeSP>();
//						tmpWrapperBean.setDataObj(menuTree);
//						tmpWrapperBean.setMessage("");
//						menuTreeWrapList.add(tmpWrapperBean);
//	        		}
	        		
	        	}
        	}
//        	semmmm002Bean.setMenuTreeList(menuTreeList);
//        	semmmm002Bean.setMenuTreeWrapList(menuTreeWrapList);
        	semmmm002Bean.setRootNode(new TreeNodeImpl());
    		addNodes(semmmm002Bean, mySendList);
        	//// <<
    		
        } catch (Exception e) {
        	LOG.debug(e);
            throw new FacesException(e.getMessage(), e);
        } finally {
//            setSemmmm002Bean(semmmm002Bean);  
        }
    }
    
    private boolean doSearchTree() {
    	boolean flag = true;
        try {
        	semmmm002Bean = getSemmmm002Bean();
        	List<MenuTreeSP> menuTreeList = null;
        	List<WrapperBeanObject<MenuTreeSP>> menuTreeWrapList = new ArrayList<WrapperBeanObject<MenuTreeSP>>();
        	//// >>
        	MenuTreeSP myParam = new MenuTreeSP();
        	List<Object> mySendList = new ArrayList<Object>();
        	
        	String regionConcatParam = "";
			String arrRegion[] = semmmm002Bean.getCriteriaToDoList().getArrRegion().length == 0 ? null : 
								semmmm002Bean.getCriteriaToDoList().getArrRegion();
			if(arrRegion != null){
				for(Object s : arrRegion){
					LOG.debug("REGION: " + s.toString());
					regionConcatParam += s.toString().concat("|");
				}
				regionConcatParam = regionConcatParam.substring(0, regionConcatParam.lastIndexOf("|"));
				semmmm002Bean.getCriteriaToDoList().setRegion(regionConcatParam);
				LOG.debug(">> regionConcatParam: " + regionConcatParam);
			}
        	
        	IMenuTreeService service = (IMenuTreeService)getBean("menuTreeService");
        	
        	String groupType[] = {"VD", "VB", "PY", "PB", "AB", "CB"};
        	
        	for(String mnGrp : groupType) {
//        		myParam.setMenuGroup(mnGrp);
//	        	myParam.setUserLogin(getUserLogIn());
        		semmmm002Bean.getCriteriaToDoList().setMenuGroup(mnGrp);
        		semmmm002Bean.getCriteriaToDoList().setUserLogin(getUserLogIn());
        		semmmm002Bean.getCriteriaToDoList().setPageFlag("M");
	        	
//	        	List<MenuTreeSP> menuTreeList = null;
	        	menuTreeList = service.querySPList(EQueryName.SEM_SAP_GET_TODO_MENU.name, semmmm002Bean.getCriteriaToDoList());

        		Map<String, Object> myMap = new HashMap<String, Object>();
	        	
	        	if(menuTreeList != null && !menuTreeList.isEmpty()){
	        		semmmm002Bean.setVendorSelectedTeamList(new ArrayList<WrapperBeanObject<MenuTreeSP>>());
	    			semmmm002Bean.setVendorMasterResultList(new ArrayList<WrapperBeanObject<Mmm001VendorMasterSP>>());
	        		/// >
	        		for(int j=0; j<menuTreeList.size(); j++){
	        			String mLevel = menuTreeList.get(j).getMenuLevel();
	        			if(mLevel.length() == 1){ 
	        				menuTreeList.get(j).setRenderedFlag(true);
	        				menuTreeList.get(j).setDisableFlag(true);
	        			}else{
	        				menuTreeList.get(j).setRenderedFlag(false);
	        				menuTreeList.get(j).setDisableFlag(false);
	        			}
	        			
	        			if(StringUtils.isEmpty(menuTreeList.get(j).getRecordCount()) || StringUtils.equals("0", menuTreeList.get(j).getRecordCount())){
	        				menuTreeList.get(j).setRenderedFlag(false);
	        			}
	        			//set Total Sum Header
	        			if(StringUtils.equals("VD", mnGrp)){
	        				if(StringUtils.isNotEmpty(menuTreeList.get(j).getTotalSum()))semmmm002Bean.setTotalSumVendor(menuTreeList.get(j).getTotalSum());
	        			}else if(StringUtils.equals("VB", mnGrp)){
	        				if(StringUtils.isNotEmpty(menuTreeList.get(j).getTotalSum()))semmmm002Bean.setTotalSumVendorBookbank(menuTreeList.get(j).getTotalSum());
	        			}else if(StringUtils.equals("PY", mnGrp)){
	        				if(StringUtils.isNotEmpty(menuTreeList.get(j).getTotalSum()))semmmm002Bean.setTotalSumPayee(menuTreeList.get(j).getTotalSum());
	        			}else if(StringUtils.equals("PB", mnGrp)){
	        				if(StringUtils.isNotEmpty(menuTreeList.get(j).getTotalSum()))semmmm002Bean.setTotalSumPayeeBookbank(menuTreeList.get(j).getTotalSum());
	        			}else if(StringUtils.equals("AB", mnGrp)){
	        				if(StringUtils.isNotEmpty(menuTreeList.get(j).getTotalSum()))semmmm002Bean.setTotalSumAbnormal(menuTreeList.get(j).getTotalSum());
	        			}else if(StringUtils.equals("CB", mnGrp)){
	        				if(StringUtils.isNotEmpty(menuTreeList.get(j).getTotalSum()))semmmm002Bean.setTotalSumCreateBy(menuTreeList.get(j).getTotalSum());
	        			}
	        			
        				myMap.put(mLevel, menuTreeList.get(j));
        				//System.out.println("---------- mLevel ["+ mLevel +"] >> " + myMap.get(mLevel));
	        		}
	        		mySendList.add(myMap);
	        		/// <
//	        		for(MenuTreeSP menuTree : menuTreeList){
////	        			VendorMasterSP vm = (MenuTreeSP)vendorMasterList.get(i);
//						WrapperBeanObject<MenuTreeSP> tmpWrapperBean = new WrapperBeanObject<MenuTreeSP>();
//						tmpWrapperBean.setDataObj(menuTree);
//						tmpWrapperBean.setMessage("");
//						menuTreeWrapList.add(tmpWrapperBean);
//	        		}
	        		
	        	}
        	}
//        	semmmm002Bean.setMenuTreeList(menuTreeList);
//        	semmmm002Bean.setMenuTreeWrapList(menuTreeWrapList);
        	semmmm002Bean.setRootNode(new TreeNodeImpl());
    		addNodes(semmmm002Bean, mySendList);
    		
    		this.doSelectTeam();
        	//// <<
    		
        } catch (Exception e) {
        	 flag = false;
        	LOG.debug(e);
            throw new FacesException(e.getMessage(), e);
           
        } finally {
//            setSemmmm002Bean(semmmm002Bean);  
        }
        return flag;
    }

    @SuppressWarnings({ "unused", "unchecked" })
	private void addNodes(SEMMMM002Bean semmmm002Bean, List<Object> propList) {
    	
    	//System.out.println("xxx propList size: " + propList.size());
    	
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
			
//			String _MENU_LABEL = "";
			if(i == 0) {
//				_MENU_LABEL = "New Location";
				for(int x=0; x<mapSize; x++){
	    			TreeNodeImpl<MenuTreeSP> child = new TreeNodeImpl<MenuTreeSP>();
	    			
	    			String parentNode = mapArr_[x].toString();	// get key by sorting
	    			
	    			MenuTreeSP mapObj =  (MenuTreeSP) map.get(parentNode);

//	    			child.setData(mapObj);
//	    			
//	    			stationNodes.addChild(x, child);
//	    			
//	    			for(MenuTreeSP menuTree : menuTreeList){
//	        			VendorMasterSP vm = (MenuTreeSP)vendorMasterList.get(i);
						WrapperBeanObject<MenuTreeSP> tmpWrapperBean = new WrapperBeanObject<MenuTreeSP>();
						tmpWrapperBean.setDataObj(mapObj);
						tmpWrapperBean.setMessage("");
						menuTreeWrapList.add(tmpWrapperBean);
	        		}
				semmmm002Bean.setMenuTreeVendorList(menuTreeWrapList);
			} else if(i == 1) {
//				_MENU_LABEL = "งานต่ออายุสัญญา";
				for(int x=0; x<mapSize; x++){
	    			TreeNodeImpl<MenuTreeSP> child = new TreeNodeImpl<MenuTreeSP>();
	    			
	    			String parentNode = mapArr_[x].toString();	// get key by sorting
	    			
	    			MenuTreeSP mapObj =  (MenuTreeSP) map.get(parentNode);

//	    			child.setData(mapObj);
//	    			
//	    			stationNodes.addChild(x, child);
//	    			
//	    			for(MenuTreeSP menuTree : menuTreeList){
//	        			VendorMasterSP vm = (MenuTreeSP)vendorMasterList.get(i);
						WrapperBeanObject<MenuTreeSP> tmpWrapperBean = new WrapperBeanObject<MenuTreeSP>();
						tmpWrapperBean.setDataObj(mapObj);
						tmpWrapperBean.setMessage("");
						menuTreeWrapList.add(tmpWrapperBean);
	        		}
				semmmm002Bean.setMenuTreeVendorBookbankList(menuTreeWrapList);
			} else if(i == 2) {
//				_MENU_LABEL = "งานแก้ไขสัญญา";
				for(int x=0; x<mapSize; x++){
	    			TreeNodeImpl<MenuTreeSP> child = new TreeNodeImpl<MenuTreeSP>();
	    			
	    			String parentNode = mapArr_[x].toString();	// get key by sorting
	    			
	    			MenuTreeSP mapObj =  (MenuTreeSP) map.get(parentNode);

//	    			child.setData(mapObj);
//	    			
//	    			stationNodes.addChild(x, child);
//	    			
//	    			for(MenuTreeSP menuTree : menuTreeList){
//	        			VendorMasterSP vm = (MenuTreeSP)vendorMasterList.get(i);
						WrapperBeanObject<MenuTreeSP> tmpWrapperBean = new WrapperBeanObject<MenuTreeSP>();
						tmpWrapperBean.setDataObj(mapObj);
						tmpWrapperBean.setMessage("");
						menuTreeWrapList.add(tmpWrapperBean);
	        		}
				semmmm002Bean.setMenuTreePayeeList(menuTreeWrapList);
			} else if(i == 3) {
//				_MENU_LABEL = "Terminate";
				for(int x=0; x<mapSize; x++){
	    			TreeNodeImpl<MenuTreeSP> child = new TreeNodeImpl<MenuTreeSP>();
	    			
	    			String parentNode = mapArr_[x].toString();	// get key by sorting
	    			
	    			MenuTreeSP mapObj =  (MenuTreeSP) map.get(parentNode);

//	    			child.setData(mapObj);
//	    			
//	    			stationNodes.addChild(x, child);
//	    			
//	    			for(MenuTreeSP menuTree : menuTreeList){
//	        			VendorMasterSP vm = (MenuTreeSP)vendorMasterList.get(i);
						WrapperBeanObject<MenuTreeSP> tmpWrapperBean = new WrapperBeanObject<MenuTreeSP>();
						tmpWrapperBean.setDataObj(mapObj);
						tmpWrapperBean.setMessage("");
						menuTreeWrapList.add(tmpWrapperBean);
	        		}
				semmmm002Bean.setMenuTreePayeeBookbankList(menuTreeWrapList);
			} else if(i == 4) {
//				_MENU_LABEL = "Terminate";
				for(int x=0; x<mapSize; x++){
	    			TreeNodeImpl<MenuTreeSP> child = new TreeNodeImpl<MenuTreeSP>();
	    			
	    			String parentNode = mapArr_[x].toString();	// get key by sorting
	    			
	    			MenuTreeSP mapObj =  (MenuTreeSP) map.get(parentNode);

//	    			child.setData(mapObj);
//	    			
//	    			stationNodes.addChild(x, child);
//	    			
//	    			for(MenuTreeSP menuTree : menuTreeList){
//	        			VendorMasterSP vm = (MenuTreeSP)vendorMasterList.get(i);
						WrapperBeanObject<MenuTreeSP> tmpWrapperBean = new WrapperBeanObject<MenuTreeSP>();
						tmpWrapperBean.setDataObj(mapObj);
						tmpWrapperBean.setMessage("");
						menuTreeWrapList.add(tmpWrapperBean);
	        		}
				semmmm002Bean.setMenuTreeAbnormalList(menuTreeWrapList);
			} else if(i == 5) {
//				_MENU_LABEL = "Terminate";
				for(int x=0; x<mapSize; x++){
	    			TreeNodeImpl<MenuTreeSP> child = new TreeNodeImpl<MenuTreeSP>();
	    			
	    			String parentNode = mapArr_[x].toString();	// get key by sorting
	    			
	    			MenuTreeSP mapObj =  (MenuTreeSP) map.get(parentNode);

//	    			child.setData(mapObj);
//	    			
//	    			stationNodes.addChild(x, child);
//	    			
//	    			for(MenuTreeSP menuTree : menuTreeList){
//	        			VendorMasterSP vm = (MenuTreeSP)vendorMasterList.get(i);
						WrapperBeanObject<MenuTreeSP> tmpWrapperBean = new WrapperBeanObject<MenuTreeSP>();
						tmpWrapperBean.setDataObj(mapObj);
						tmpWrapperBean.setMessage("");
						menuTreeWrapList.add(tmpWrapperBean);
	        		}
				
				semmmm002Bean.setMenuTreeCreateByList(menuTreeWrapList);
			}
//			myParent.setMenuLabel(_MENU_LABEL);
//			myParent.setMenuGroup("NN");
//			myParent.setMenuUrl("Tree Head");
//    		
//    		// >>
//    		TreeNodeImpl<MenuTreeSP> stationNodes = new TreeNodeImpl<MenuTreeSP>();
//    		
//    		MenuTreeSP menuTreeObj = new MenuTreeSP();
//    		
//    		stationNodes.setData(myParent);
//    		stationNodes.setParent(stationNodes);
//        	masterRoot.addChild(i, stationNodes);
        	// <<
    		
//    		for(int x=0; x<mapSize; x++){
//    			TreeNodeImpl<MenuTreeSP> child = new TreeNodeImpl<MenuTreeSP>();
//    			
//    			String parentNode = mapArr_[x].toString();	// get key by sorting
//    			
//    			MenuTreeSP mapObj =  (MenuTreeSP) map.get(parentNode);
//
////    			child.setData(mapObj);
////    			
////    			stationNodes.addChild(x, child);
////    			
////    			for(MenuTreeSP menuTree : menuTreeList){
////        			VendorMasterSP vm = (MenuTreeSP)vendorMasterList.get(i);
//					WrapperBeanObject<MenuTreeSP> tmpWrapperBean = new WrapperBeanObject<MenuTreeSP>();
//					tmpWrapperBean.setDataObj(mapObj);
//					tmpWrapperBean.setMessage("");
//					menuTreeWrapList.add(tmpWrapperBean);
//        		}
//    		}
//    		// <<
//    		
//    		masterRoot.addChild(i, stationNodes);
			setSemmmm002Bean(semmmm002Bean);
    	}
    }
    
    public void processSelection(NodeSelectedEvent event) {

        HtmlTree tree = (HtmlTree) event.getComponent();
        nodeTitle = ((MenuTreeSP)tree.getRowData()).toString();
        MenuTreeSP menuTreeSP = (MenuTreeSP)tree.getRowData();
        semmmm002Bean = getSemmmm002Bean();
//        nodeValue = (MenuTreeSP) tree.getRowData();

        selectedNodeChildren.clear();
        
        TreeNode currentNode = tree.getModelTreeNode(tree.getRowKey());
        if (currentNode.isLeaf()){
            selectedNodeChildren.add(((MenuTreeSP)currentNode.getData()).toString());
//            semmmm002Bean.setParamUrl(menuTreeSP.getMenuUrl());
//            semmmm002Bean.setParamMenuGroup(menuTreeSP.getMenuGroup());
            setSemmmm002Bean(semmmm002Bean);
//            this.treeSwapPage();
            //System.out.println("selected node Child [y]: " + ((MenuTreeSP)currentNode.getData()).toString());
        }else
        {
            Iterator<Map.Entry<Object, TreeNode>> it = currentNode.getChildren();
            while (it!=null &&it.hasNext()) {
                Map.Entry<Object, TreeNode> entry = it.next();
                selectedNodeChildren.add(entry.getValue().getData().toString());
                //System.out.println("selected nod Parent have Childred [x]: " + entry.getValue().getData().toString());
            }
        }
        
        
    }
    
    public void clearReasonNotProcess() {
    	semmmm002Bean = getSemmmm002Bean();
//    	semmmm002Bean.setReasonOfNotProcess(null);
    	//get Tree Node
		this.loadTree();
    }
    
    // fixed 2015/01/27
    public boolean nodeExpandAll(UITree tree) {  
    	// can do something
    	return true;
    }
    
    public TreeNode getTreeNode() {
    	semmmm002Bean = getSemmmm002Bean();
        if (semmmm002Bean.getRootNode() == null) {
            loadTree();
        }
        
        return semmmm002Bean.getRootNode();
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
	
    public void doSelectTeam(){
    	LOG.info("::: SEMMMM002Action :: doSelectTeam >> BEGIN :::");
		
		IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
		List<MenuTreeSP> to = new ArrayList<MenuTreeSP>();
		
		try {
			semmmm002Bean = getSemmmm002Bean();
//			if(validate){
//				
//			}
			semmmm002Bean.setVendorMasterResultList(new ArrayList<WrapperBeanObject<Mmm001VendorMasterSP>>());
//			setSemmmm002Bean(semmmm002Bean);
			
//			if(semmmm002Bean.isChkPicoType()){
//				semmmm002Bean.getCriteria().setSystemType("PICO");
//			}
//			semmmm002Bean.getCriteria().setCreateBy(getUserLogIn());
			LOG.debug("criteria: " + semmmm002Bean.getCriteria().toString());
			semmmm002Bean.getCriteriaToDoList().setPageFlag("M");
//			semmmm002Bean.getCriteria().setMenuGroup(menuGroup);
//			semmmm002Bean.getCriteria().setStrParam(strParam);
			
			String regionConcatParam = "";
			if(semmmm002Bean.getCriteriaToDoList().getArrRegion() != null){
				String arrRegion[] = semmmm002Bean.getCriteriaToDoList().getArrRegion().length == 0 ? null : 
					semmmm002Bean.getCriteriaToDoList().getArrRegion();
					if(arrRegion != null){
						for(Object s : arrRegion){
							LOG.debug("REGION: " + s.toString());
							regionConcatParam += s.toString().concat("|");
						}
						regionConcatParam = regionConcatParam.substring(0, regionConcatParam.lastIndexOf("|"));
						semmmm002Bean.getCriteriaToDoList().setRegion(regionConcatParam);
						LOG.debug(">> regionConcatParam: " + regionConcatParam);
					}
			}
			
			
			to = service.querySPList(EQueryName.SEM_SAP_SP_TODO_STAFF_SEARCH.name, semmmm002Bean.getCriteriaToDoList());
			
			if (null == to || to.isEmpty()) {
//				addMessageError(to.get(0).getRemark());
				semmmm002Bean.setRenderedMsgDataNotFound(true);
			} else {
				semmmm002Bean.setRenderedMsgDataNotFound(false);
				semmmm002Bean.setVendorSelectedTeamList(new ArrayList<WrapperBeanObject<MenuTreeSP>>());
//				LOG.debug("to.size() = "+to.size());
				for (int i=0; i<to.size(); i++) {
					MenuTreeSP o = to.get(i);
					WrapperBeanObject<MenuTreeSP> tmpWrapperBean = new WrapperBeanObject<MenuTreeSP>();
					
//					o.setAccountName("xxxxx");
//					System.out.println("getCreateById : "+o.getCreateById());
					tmpWrapperBean.setDataObj(o);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					semmmm002Bean.getVendorSelectedTeamList().add(tmpWrapperBean);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMMM002Action doSelectTeam");
		} finally {
			setSemmmm002Bean(semmmm002Bean);
			LOG.info("::: SEMMMM002Action :: doSelectTeam >> END :::");
		}
    }
    
    public boolean doViewVendor(){
    	boolean flag = true;
    	semmmm002Bean = getSemmmm002Bean();
    	try {
			
			SEMMMM001Action semmmm001Action = new SEMMMM001Action();
			semmmm001Action = semmmm001Action.getSemmmm001Action();
			semmmm001Action.init();
			SEMMMM001Bean semmmm001Bean = semmmm001Action.getSemmmm001Bean();
			
			semmmm001Action.doEditVendor();
//			getFacesUtils.
//			doEditVendor
		} catch (Exception e) {
			e.printStackTrace();
			LOG.debug("Error SEMMMM002Action doViewVendor : "+e);
			flag = false;
			// TODO: handle exception
		}finally{
			setSemmmm002Bean(semmmm002Bean);
		}
		return flag;
    }
    
 // -> popup convert vendor
	public void initConvertVendor(){
		LOG.info("::: SEMMMM001Action :: initConvertVendor >> BEGIN :::");
		String todoFlag;
		try {
			
			semmmm002Bean = getSemmmm002Bean();
			todoFlag = getFacesUtils().getRequestParameter("todoFlag") == null ?  "" :(String)getFacesUtils().getRequestParameter("todoFlag");
			semmmm002Bean.setVendorInfo(new Mmm001VendorSP());
			semmmm002Bean.setConvertVendorResultList(new ArrayList<WrapperBeanObject<Mmm001VendorMasterSP>>());
			semmmm002Bean.setTodoFlag(todoFlag);
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMMM002Action");
		} finally {
			setSemmmm002Bean(semmmm002Bean);
			LOG.info("::: SEMMMM001Action :: doNewVendor >> END :::");
		}
	}
	
	public void doSearchPopupConvertVendor(){
		LOG.info("::: SEMMMM001Action :: doSearchPopupConvertVendor >> BEGIN :::");
		
		try {
			
			semmmm002Bean = getSemmmm002Bean();
			IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
			List<Mmm001VendorMasterSP> resultList = null;
			
			semmmm002Bean.setConvertVendorResultList(new ArrayList<WrapperBeanObject<Mmm001VendorMasterSP>>());
			
			resultList = service.querySPList(EQueryName.SEM_SAP_GET_MAP_VENDOR.name, semmmm002Bean.getVendorInfo());
			if(resultList != null && resultList.size() != 0){
				 for(int i=0; i<resultList.size(); i++){
					Mmm001VendorMasterSP obj = (Mmm001VendorMasterSP) resultList.get(i);
					WrapperBeanObject<Mmm001VendorMasterSP> tmpWrapperBean = new WrapperBeanObject<Mmm001VendorMasterSP>();
					
					tmpWrapperBean.setDataObj(obj);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					semmmm002Bean.getConvertVendorResultList().add(tmpWrapperBean);
					
					semmmm002Bean.setRenderedMsgDataNotFound(false);
				 }
			 } else {
				 semmmm002Bean.setRenderedMsgDataNotFound(true);
			 }
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMMM001Action");
		} finally {
			setSemmmm002Bean(semmmm002Bean);
			LOG.info("::: SEMMMM001Action :: doSearchPopupConvertVendor >> END :::");
		}
	}
	
	public void doSelectConvertVendor(){
		LOG.info("::: SEMMMM001Action :: doSelectConvertVendor >> BEGIN :::");
		String todoFlag = "";
		try {
			
			semmmm002Bean = getSemmmm002Bean();
			todoFlag = semmmm002Bean.getTodoFlag() == null ?  "" :(String)semmmm002Bean.getTodoFlag();
			String vendorCode = getFacesUtils().getRequestParameter("vendorCodeParam") == null ? "" : (String) getFacesUtils().getRequestParameter("vendorCodeParam");
			LOG.debug(">> vendorCode: " + vendorCode);
			//String vendorName = getFacesUtils().getRequestParameter("vendorNameParam") == null ? "" : (String) getFacesUtils().getRequestParameter("vendorNameParam");
			LOG.debug(">> todoFlag: " + todoFlag);
			
			if(StringUtils.equalsIgnoreCase("T", todoFlag)){
				semmmm002Bean.getCriteriaToDoList().setVendorCode(vendorCode);
			}else{
				semmmm002Bean.getCriteria().setVendorCode(vendorCode);	
			}
//			semmmm002Bean.getCriteria().setVendorCode(vendorCode);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMMM001Action");
		} finally {
			setSemmmm002Bean(semmmm002Bean);
			LOG.info("::: SEMMMM001Action :: doSelectConvertVendor >> END :::");
		}
	}
	
	//added by NEW 21/06/2017
	public boolean doCheckTaxId(){
		LOG.debug("#### Start SEMMMM002Action doCheckTaxId ####");
		boolean flag = false;
		semmmm002Bean = getSemmmm002Bean();
		
		String todoFlag = getFacesUtils().getRequestParameter("todoFalg") == null ? "" : (String)getFacesUtils().getRequestParameter("todoFlag");
		String taxId = "";
		semmmm002Bean.setRenderedMsgFormSearch(false);
		try{
			
			if(StringUtils.equals("T", todoFlag)){
				taxId = semmmm002Bean.getCriteriaToDoList().getTaxId();
			}else{
				taxId = semmmm002Bean.getCriteria().getTaxId();
			}
			
			if (!taxId.equals("") && !taxId.equals(null)) {
				if(!StringUtils.isNumeric(taxId)){
					addMessageErrorWithArgument("W0007" ,msg("label.th_taxId"));
					semmmm002Bean.setRenderedMsgFormSearch(true);
//					semmmm002Bean.setRenderedMsgFormChkExpire(true);
					flag = true;
					setSemmmm002Bean(semmmm002Bean);
					return flag;
				}
				
//				System.out.println("taxId.length : "+taxId.length());
				if(taxId.length()>13 || taxId.length()<13 ){
//					addMessageError("W0001", msg("message.taxIdAlert")); // 
					addMessageErrorWithArgument("W0092" ,msg("label.th_taxId"), "13");
					semmmm002Bean.setRenderedMsgFormSearch(true);
//					semmmm002Bean.setRenderedMsgFormChkExpire(true);
					flag = true;
					setSemmmm002Bean(semmmm002Bean);
					return flag;
				}else{
					semmmm002Bean.setRenderedMsgFormSearch(false);
				}
			}else{
				semmmm002Bean.setRenderedMsgFormSearch(false);
			}
		}catch (Exception e) {
			LOG.debug("error Semmmm002Action doCheckTaxId : "+e);
			// TODO: handle exception
		}finally{
			LOG.debug("#### END SEMMMM002Action doCheckTaxId ####");
			setSemmmm002Bean(semmmm002Bean);
		}
		return flag;
	}
	
	//added by NEW 21/06/2017
	public boolean doCheckIdCard(){
		LOG.debug("#### Start SEMMMM002Action doCheckIdCard ####");
		boolean flag = false;
		semmmm002Bean = getSemmmm002Bean();
		String todoFlag = getFacesUtils().getRequestParameter("todoFalg") == null ? "" : (String)getFacesUtils().getRequestParameter("todoFlag");
		String idCard = "";
		semmmm002Bean.setRenderedMsgFormSearch(false);
		try{
			if(StringUtils.equals("T", todoFlag)){
				idCard = semmmm002Bean.getCriteriaToDoList().getIdCard();
			}else{
				idCard = semmmm002Bean.getCriteria().getIdCard();
			}
			
			if (!idCard.equals("") && !idCard.equals(null)) {
				if(!StringUtils.isNumeric(idCard)){
					addMessageErrorWithArgument("W0007" ,msg("label.th_taxId"));
					semmmm002Bean.setRenderedMsgFormSearch(true);
//					semmmm002Bean.setRenderedMsgFormChkExpire(true);
					flag = true;
					setSemmmm002Bean(semmmm002Bean);
					return flag;
				}
				
//				System.out.println("taxId.length : "+taxId.length());
				if(idCard.length()>13 || idCard.length()<13 ){
//					addMessageError("W0001", msg("message.taxIdAlert")); // 
					addMessageErrorWithArgument("W0092" ,msg("label.th_taxId"), "13");
					semmmm002Bean.setRenderedMsgFormSearch(true);
//					semmmm002Bean.setRenderedMsgFormChkExpire(true);
					flag = true;
					setSemmmm002Bean(semmmm002Bean);
					return flag;
				}else{
					semmmm002Bean.setRenderedMsgFormSearch(false);
				}
			}else{
				semmmm002Bean.setRenderedMsgFormSearch(false);
			}
		}catch (Exception e) {
			LOG.debug("error Semmmm002Action doCheckTaxId : "+e);
			// TODO: handle exception
		}finally{
			LOG.debug("#### END SEMMMM002Action doCheckIdCard ####");
			setSemmmm002Bean(semmmm002Bean);
		}
		return flag;
	}
	
	public void doBackPage(){
		try{
			semmmm002Bean = getSemmmm002Bean();
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error FROM SEMMMM002Action doBackPage : "+e );
		}finally{
			setSemmmm002Bean(semmmm002Bean);
		}
	}
	
	
	//added by NEW 01/06/2018
	public String doConcatRegion(){
		LOG.debug("  ############# Start semmmm002Action doConcatRegion ##############");
		boolean flag = true;
		String regionConcatParam = "";
		semmmm002Bean = getSemmmm002Bean();
		try{
			String arrRegion[] = semmmm002Bean.getCriteriaToDoList().getArrRegion().length == 0 ? null : 
								 semmmm002Bean.getCriteriaToDoList().getArrRegion();
			if(arrRegion != null){
				for(Object s : arrRegion){
					LOG.debug("REGION: " + s.toString());
					regionConcatParam += s.toString().concat("|");
				}
				regionConcatParam = regionConcatParam.substring(0, regionConcatParam.lastIndexOf("|"));
				semmmm002Bean.getCriteriaToDoList().setRegion(regionConcatParam);
				LOG.debug(">> regionConcatParam: " + regionConcatParam);
			}
		}catch (Exception e) {
			e.printStackTrace();
			LOG.debug("ERROR SEMMMM002Action doConcatRegion");
			// TODO: handle exception
		}
		
		LOG.debug("  ############# End semmmm002Action doConcatRegion ##############");
    	return regionConcatParam;
	}
}
