package th.co.ais.web.ac.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;

import th.co.ais.domain.ac.Mac004Act;
import th.co.ais.domain.ac.Mac004Srch;
import th.co.ais.domain.gm.VendorMasterSP;
import th.co.ais.domain.rt.Mrt003PopPaySP;
import th.co.ais.service.gm.IVendorMasterService;
import th.co.ais.service.rt.IRentalPaymentService;
import th.co.ais.service.sap.ISAPErrorLog;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.ac.bean.SEMMAC001Bean;
import th.co.ais.web.ac.bean.SEMMAC004Bean;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.SelectItemLOVCacheUtil;

public class SEMMAC004Action extends AbstractAction{

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if(methodWithNavi.equalsIgnoreCase("doSearch")){
			flag = doSearch();
		}else if (methodWithNavi.equalsIgnoreCase("doClearSession")) {
			flag = doClearSession();
		}else if (methodWithNavi.equalsIgnoreCase("doBack")) {
			flag = doBack();
		}else if (methodWithNavi.equalsIgnoreCase("initPopup")) {
			flag = initPopup();
		}else if (methodWithNavi.equalsIgnoreCase("doSaveAct")) {
			flag = doSaveAct();
		}else if (methodWithNavi.equalsIgnoreCase("doUpdatePopupCutting")) {
			flag = doUpdatePopupCutting();
		}else if (methodWithNavi.equalsIgnoreCase("doInitPopupRemark")) {
			flag = doInitPopupRemark();
		}
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		SEMMAC004Bean mac004Bean = new SEMMAC004Bean();
		mac004Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		mac004Bean.setModuleTypeList(getLovItemsByType(ELovType.T_CT_MODULE.name, EX_AND, "PAYMENT", null, null));
		mac004Bean.setExpenseTypeList(getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name));
		mac004Bean.setPaymentTypeList(getLovItemsByType(ELovType.T_CT_PAYMENT_TYPE.name));
		mac004Bean.setPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name));
		mac004Bean.setPaymentStatusList(getLovItemsByType(ELovType.T_CT_PAYMENT_STATUS.name));
		mac004Bean.setMac004Srch(new Mac004Srch());
		mac004Bean.getMac004Srch().setPaymentStatus("07");
		mac004Bean.setMac004Act(new Mac004Act());
		mac004Bean.setPaymentStatusListItems(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_CT_PAYMENT_STATUS.name, EX_AND, null, null, "CANCEL"));
		mac004Bean.setPaySP(new Mrt003PopPaySP());
		setSemmac004Bean(mac004Bean);
		
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean doClearSession(){
		boolean flag = false;
		semmac004Bean = getSemmac004Bean();
		semmac004Bean.setMac004Srch(new Mac004Srch());
		semmac004Bean.setMac004SrchList(null);
		semmac004Bean.setRenderedMsgDataNotFound(false);
		setSemmac004Bean(semmac004Bean);
		return flag;
	}
	
	public boolean doSearch(){
		boolean flag = false;
		semmac004Bean = getSemmac004Bean();
		semmac004Bean.setRenderedMsgFormSearch(true);
		semmac004Bean.setRenderedMsgFormMiddle(false);
		if(!validateSearch()){
			return flag;
		}
		
		ISAPErrorLog sapErrorLogService = (ISAPErrorLog)getBean("sapErrorLogService");
		List<Mac004Srch> to =null;
		try {
			to = sapErrorLogService.querySPList(EQueryName.SP_MAC004_SRCH.name, semmac004Bean.getMac004Srch());
			if (to == null || to.size() == 0) {
				semmac004Bean.setRenderedMsgDataNotFound(true);
				semmac004Bean.setMac004SrchList(null);
			}else{
				semmac004Bean.setRenderedMsgDataNotFound(false);
				for(Mac004Srch mac : to){
					if(!mac.getPaymentStatus().equals("08")
					   && !mac.getPaymentStatus().equals("09")
					   && !mac.getPaymentStatus().equals("10")){
						mac.setRenderedBtnManual(false);
					}else{
						mac.setRenderedBtnManual(true);
					}
					
					if(mac.getPeriodStartDt() != null){
						mac.setPeriodStartDt(SEMDataUtility.convertToThYear(mac.getPeriodStartDt()));
					}
					if(mac.getPeriodEndDt() != null){
						mac.setPeriodEndDt(SEMDataUtility.convertToThYear(mac.getPeriodEndDt()));
					}
					if(mac.getChqDt() != null){
						mac.setChqDt(SEMDataUtility.convertToThYear(mac.getChqDt()));
					}
					if(mac.getChqReceiveDt() != null){
						mac.setChqReceiveDt(SEMDataUtility.convertToThYear(mac.getChqReceiveDt()));
					}
					if(mac.getUpdateDt() != null){
						mac.setUpdateDt(SEMDataUtility.convertToThYear(mac.getUpdateDt()));
					}
					
					if(mac.getDoc68Dt() != null){
						mac.setDoc68DtDisplay(SEMDataUtility.convertToThYear(mac.getDoc68Dt()));
					}
					
					if(mac.getDocPaymentDt() != null){
						mac.setDocPaymentDtDisplay(SEMDataUtility.convertToThYear(mac.getDocPaymentDt()));
					}
					
					if(mac.getDocCancelDt() != null){
						mac.setDocCancelDtDisplay(SEMDataUtility.convertToThYear(mac.getDocCancelDt()));
					}
					mac.setRenderedLinkSap(false);
					mac.setRenderedPaymentStatusDesc(true);
					if(mac.getPaymentStatus().equals("09")){
						mac.setRenderedLinkSap(true);
						mac.setRenderedPaymentStatusDesc(false);
					}
					mac.setRenderedLinkPrecontract(true);
					if(StringUtils.isEmpty(mac.getPreSiteContracNo())){
						mac.setRenderedLinkPrecontract(false);
					}
				}
				semmac004Bean.setMac004SrchList(to);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setSemmac004Bean(semmac004Bean);
		return flag;
	}
	
	private boolean validateSearch() {
		boolean flagValid = true;
		if(StringUtils.isEmpty(getSemmac004Bean().getMac004Srch().getCompany())){
			addMessageError("W0001", msg("export.col.expenseType"));
			flagValid = false;
		}
		if(StringUtils.isEmpty(getSemmac004Bean().getMac004Srch().getModuleType())){
			addMessageError("W0001", msg("message.module"));
			flagValid = false;
		}
		return flagValid;
	}
	
	//Method onRender DropDownList ExpenseType
	public void onRenderExpenseType(){
		semmac004Bean  = getSemmac004Bean();
		if(!StringUtils.isEmpty(semmac004Bean.getMac004Srch().getModuleType())){
			semmac004Bean.setExpenseTypeList(getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name, EX_IN, null, semmac004Bean.getMac004Srch().getModuleType(), null));
		}else{
			semmac004Bean.setExpenseTypeList(getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name));
		}
		setSemmac004Bean(semmac004Bean);
	}
	
	public boolean doBack(){
		boolean flag = true;
		doSearch();
		return flag;
	}
	
	public boolean initPopup(){
		boolean flag = false;
		semmac004Bean = getSemmac004Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		semmac004Bean.setMac004Act(new Mac004Act());
		try{
			for(Mac004Srch mac : semmac004Bean.getMac004SrchList()){
				if(mac.getRowId().equals(rowId)){
					semmac004Bean.getMac004Act().setRowId(mac.getRowId());
					semmac004Bean.getMac004Act().setPaymentType(mac.getPaymentType());
					semmac004Bean.getMac004Act().setPaymentMethod(mac.getPaymentMethod());
					semmac004Bean.getMac004Act().setChqDt(SEMDataUtility.convertToEnYear(mac.getChqDt()));
					semmac004Bean.getMac004Act().setChqReceiveDt(SEMDataUtility.convertToEnYear(mac.getChqReceiveDt()));
					semmac004Bean.getMac004Act().setTransferDt(mac.getTransferDt());
					semmac004Bean.getMac004Act().setDoc68(mac.getDoc68());  //ใน mac004Srch ยังไม่มี property นี้
					semmac004Bean.getMac004Act().setDoc68Dt(mac.getDoc68Dt());  //ใน mac004Srch ยังไม่มี property นี้
					semmac004Bean.getMac004Act().setDocPayment(mac.getDocPayment()); 
					semmac004Bean.getMac004Act().setDocPaymentDt(mac.getDocPaymentDt());  
					semmac004Bean.getMac004Act().setDocCancel(mac.getDocCancel()); 
					semmac004Bean.getMac004Act().setDocCancelDt(mac.getDocCancelDt());  
					semmac004Bean.getMac004Act().setUserId(getUserLogIn());
					
					//for display
					semmac004Bean.getMac004Act().setVendorCode(mac.getVendorCode());
					semmac004Bean.getMac004Act().setVendorName(mac.getVendorName());
					semmac004Bean.getMac004Act().setPayeeName(mac.getPayeeName());
					semmac004Bean.getMac004Act().setBankAccNo(mac.getBankAccNo());
					semmac004Bean.getMac004Act().setVendorCode(mac.getVendorCode());
					semmac004Bean.getMac004Act().setInvoiceNo(mac.getDocNo());
					semmac004Bean.getMac004Act().setTotalAmt(mac.getTotalAmt());
					semmac004Bean.getMac004Act().setVatAmt(mac.getPayVatAmt());
					semmac004Bean.getMac004Act().setWhtAmt(mac.getPayWhtAmt());
					semmac004Bean.getMac004Act().setDutyAmt(mac.getPayDutyAmt());
					semmac004Bean.getMac004Act().setPayamount(mac.getPayAmt());
					semmac004Bean.getMac004Act().setPaymentStatus(mac.getPaymentStatus());
					semmac004Bean.getMac004Act().setPaymentStatusRemark(mac.getRemark());
					break;
				}
			}
			
			if(StringUtils.equalsIgnoreCase(semmac004Bean.getMac004Act().getPaymentStatus(), "08")||StringUtils.equalsIgnoreCase(semmac004Bean.getMac004Act().getPaymentStatus(), "13")){
				semmac004Bean.setDisableCancelBtn(false);
			}else{
				semmac004Bean.setDisableCancelBtn(true);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		semmac004Bean.setRenderedMsgFormSearch(false);
		setSemmac004Bean(semmac004Bean);
		onRenderPaymentMethod();
		return flag;
	}
	
	public boolean doSaveAct(){
		boolean flag = false;
		semmac004Bean = getSemmac004Bean();
		ISAPErrorLog sapErrorLogService = (ISAPErrorLog)getBean("sapErrorLogService");
		List<Mac004Act> to = null;
		
		if(!validateSave()){
			semmac004Bean.setPopupClose(new Boolean(false));
			return flag;
		}
		
		try {
			to = sapErrorLogService.querySPList(EQueryName.SP_MAC004_ACT.name, semmac004Bean.getMac004Act());
			if (to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")) {
				addMessageInfo("M0001");
				semmac004Bean.setPopupClose(true);
			}else if(to != null && !to.isEmpty()){
				FrontMessageUtils.addMessageError(to.get(0).getpRemark());
				semmac004Bean.setPopupClose(false);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setSemmac004Bean(semmac004Bean);
		doSearch();
		semmac004Bean.setRenderedMsgFormMiddle(true);
		semmac004Bean.setRenderedMsgFormSearch(false);
		setSemmac004Bean(semmac004Bean);
		return flag;
	}
	
	public void onRenderPaymentMethod(){
		semmac004Bean = getSemmac004Bean();
		semmac004Bean.setRenderedChqDt(true);
		semmac004Bean.setRenderedTransferDt(true);
		semmac004Bean.setRenderedPaymentMethod(false);
		if(semmac004Bean.getMac004Act().getPaymentType() != null && semmac004Bean.getMac004Act().getPaymentType().equals("01")){
			semmac004Bean.setPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name, EX_IN, "CHEQUE", null, null));
			semmac004Bean.setRenderedChqDt(false);
			semmac004Bean.setDisablePaymentMethod(false);
			//Clear Text field
			semmac004Bean.getMac004Act().setTransferDt(null);
		}
		if(semmac004Bean.getMac004Act().getPaymentType() != null && semmac004Bean.getMac004Act().getPaymentType().equals("02")){
			semmac004Bean.setPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name, EX_IN, "TRANSFER", null, null));
//			semmac004Bean.getMac004Act().setPaymentMethod("05");
			//addded by NEW 20150828 check null befor set default paymentMethod
			if(semmac004Bean.getMac004Act().getPaymentMethod() == null || 
					semmac004Bean.getMac004Act().getPaymentMethod().equals(""))
				semmac004Bean.getMac004Act().setPaymentMethod("05");
			//end added
			semmac004Bean.setRenderedTransferDt(false);
			semmac004Bean.setDisablePaymentMethod(false);
			//Clear Text field
			semmac004Bean.getMac004Act().setChqDt(null);
			semmac004Bean.getMac004Act().setChqReceiveDt(null);
		}
		if(semmac004Bean.getMac004Act().getPaymentType() != null && semmac004Bean.getMac004Act().getPaymentType().equals("03")){
			semmac004Bean.setRenderedPaymentMethod(true);
//			semmac004Bean.getMac004Act().setPaymentMethod("");
			//addded by NEW 20150828 check null befor set default paymentMethod
			if(semmac004Bean.getMac004Act().getPaymentMethod() == null || 
					semmac004Bean.getMac004Act().getPaymentMethod().equals(""))
				semmac004Bean.getMac004Act().setPaymentMethod("");
			//end added
			semmac004Bean.setDisablePaymentMethod(true);
			//Clear Text field
			semmac004Bean.getMac004Act().setTransferDt(null);
			semmac004Bean.getMac004Act().setChqDt(null);
			semmac004Bean.getMac004Act().setChqReceiveDt(null);
		}
	}
	
	private boolean validateSave() {
		boolean flgValid = true;
		Date chqDt = getSemmac004Bean().getMac004Act().getChqDt();
		Date chqReceiveDt = getSemmac004Bean().getMac004Act().getChqReceiveDt();
		Date transferDt = getSemmac004Bean().getMac004Act().getTransferDt();
		if(StringUtils.isEmpty(getSemmac004Bean().getMac004Act().getPaymentType())){
			addMessageError(("W0001"), msg("message.paymentType"));
			flgValid = false;
		}
		if(StringUtils.isEmpty(getSemmac004Bean().getMac004Act().getPaymentMethod())){
			addMessageError(("W0001"), msg("message.paymentMethod"));
			flgValid = false;
		}
		try{
			if(getSemmac004Bean().getMac004Act().getChqDt() == null){
				   if(getSemmac004Bean().isRenderedChqDt() == false){
					addMessageError(("W0001"), msg("message.chqDt"));
					flgValid = false;
				   }
				}else{
//					if(SEMDataUtility.getCurrentDateByPattern().compareTo(chqDt)>0){
//						addGeneralMessageError("ChqDt Before Today Date");
//						flgValid = false;
//					}
				}
				if(getSemmac004Bean().getMac004Act().getChqReceiveDt() == null){
				   if(getSemmac004Bean().isRenderedChqDt() == false){
					addMessageError(("W0001"), msg("message.chqReceiveDt"));
					flgValid = false;
				   }
				}else{
//					if(SEMDataUtility.getCurrentDateByPattern().compareTo(chqReceiveDt)>0){
//						addGeneralMessageError("ChqReCeiveDt Before Today Date");
//						flgValid = false;
//					}
				}
				if(getSemmac004Bean().getMac004Act().getTransferDt() == null){
					if(getSemmac004Bean().isRenderedTransferDt() == false){
					 addMessageError(("W0001"), msg("message.transferDt"));
					 flgValid = false;
					}
				}else{
//					if(SEMDataUtility.getCurrentDateByPattern().compareTo(transferDt)>0){
//						addGeneralMessageError("TransferDt Before Today Date");
//						flgValid = false; 
//					}
				}
		}catch (Exception e) {
			// TODO: handle exception
		}		
		if(StringUtils.isEmpty(getSemmac004Bean().getMac004Act().getDoc68())
				&& StringUtils.isEmpty(getSemmac004Bean().getMac004Act().getDocPayment())
				&& StringUtils.isEmpty(getSemmac004Bean().getMac004Act().getDocCancel())){
			addMessageError(("W0001"), msg("Please enter at least 1 doc"));
			flgValid = false;
			
		}
		if(StringUtils.isNotEmpty(getSemmac004Bean().getMac004Act().getDoc68()) && getSemmac004Bean().getMac004Act().getDoc68Dt() == null){
			addMessageError(("W0001"), msg("message.doc68Dt"));
			flgValid = false;
		}
		if(StringUtils.isNotEmpty(getSemmac004Bean().getMac004Act().getDocPayment()) && getSemmac004Bean().getMac004Act().getDocPaymentDt() == null){
			addMessageError(("W0001"), msg("label.docDt92"));
			flgValid = false;
		}
		if(StringUtils.isNotEmpty(getSemmac004Bean().getMac004Act().getDocCancel()) && getSemmac004Bean().getMac004Act().getDocCancelDt() == null){
			addMessageError(("W0001"), msg("label.docDtCancel"));
			flgValid = false;
		}
		return flgValid;
	}
	
	private SEMMAC004Bean semmac004Bean;
	
	public SEMMAC004Bean getSemmac004Bean() {
		return (SEMMAC004Bean)getFacesUtils().getSessionMapValue("semmac004Bean");
	}

	public void setSemmac004Bean(SEMMAC004Bean semmac004Bean) {
		this.semmac004Bean = semmac004Bean;
		getFacesUtils().setSessionMapValue("semmac004Bean", semmac004Bean);
	}

	public void getRowIdOnClick() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemmac004Bean().setTmpRowId(rowId);
	}

	
	private boolean doUpdatePopupCutting(){
		boolean flag = false;
		boolean verifyFlag = true;
		semmac004Bean = getSemmac004Bean();
		semmac004Bean.setPopupClose(false);
		if(StringUtils.isEmpty(semmac004Bean.getPaySP().getPaymentStatus())){
			verifyFlag = false;
			addMessageError(("W0001"), msg("message.paymentStatus"));
		}
		if(StringUtils.isEmpty(semmac004Bean.getPaySP().getRemarkPaymentStatus())){
			verifyFlag = false;
			addMessageError(("W0001"), msg("message.remark"));
		}
		
		try{
			if(verifyFlag){
				ISAPErrorLog sapErrorLogService = (ISAPErrorLog)getBean("sapErrorLogService");
				Mrt003PopPaySP mrt003PopPaySP = new Mrt003PopPaySP();
				mrt003PopPaySP.setParamRentalPaymentId(semmac004Bean.getPaySP().getParamRentalPaymentId());
				mrt003PopPaySP.setPaymentStatus(semmac004Bean.getPaySP().getPaymentStatus());
				mrt003PopPaySP.setRemarkPaymentStatus(semmac004Bean.getPaySP().getRemarkPaymentStatus());
				mrt003PopPaySP.setUserId(getUserLogIn());
				List<Mrt003PopPaySP> to = null;
				
				
				to = sapErrorLogService.querySPList(EQueryName.SP_UPD_MRT003_POP_PAY.name, mrt003PopPaySP);
				
				if(StringUtils.equalsIgnoreCase(to.get(0).getpResult(), "Success")){
					flag = true;
					doSearch();
				}
				semmac004Bean.setPopupCloseSave(true);
			}else{
				semmac004Bean.setRenderMessagePopup(true);
				semmac004Bean.setPopupCloseSave(false);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		setSemmac004Bean(semmac004Bean);
		return flag; 
	}
	
	private boolean doInitPopupRemark(){
		boolean flag = false;
		semmac004Bean = getSemmac004Bean();
		
//		for(SelectItem sel : semmac004Bean.getPaymentStatusListItems()){
//			System.out.println(" value : "+sel.getValue());	
//		}
		semmac004Bean.setPaySP(new Mrt003PopPaySP());
		semmac004Bean.getPaySP().setParamRentalPaymentId(semmac004Bean.getMac004Act().getRowId());
		semmac004Bean.getPaySP().setPaymentStatus(semmac004Bean.getMac004Act().getPaymentStatus());
		semmac004Bean.getPaySP().setRemarkPaymentStatus(semmac004Bean.getMac004Act().getPaymentStatusRemark());
		
		setSemmac004Bean(semmac004Bean);
		return flag; 
	}
	
	// -> popup add vendor
	public void initAddVendor(){
		//log.info("-- initPopupAddVendor --");

		SEMMAC004Bean mac004Bean = getSemmac004Bean();

		try {
			
			doClearPopupAddVendor();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmac004Bean(mac004Bean);
	}
	
	public void doSearchPopupAddVendor(){
		//log.info("-- doSearchPopupAddVendor --");

		SEMMAC004Bean mac004Bean = getSemmac004Bean();

		try {
			
			//String strVendorCode = mac004Bean.getVendorMasterPopupObjParam().getVendorCode();
			//String strVendorName = mac004Bean.getVendorMasterPopupObjParam().getVendorName();


			IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
			List<VendorMasterSP> vendorMasterList = null;
			
			mac004Bean.setVendorMasterPopupList(new ArrayList<WrapperBeanObject<VendorMasterSP>>());
			
			vendorMasterList = service.queryVendorMasterSPList(EQueryName.SP_GET_MAP_VENDOR.name, mac004Bean.getVendorMasterPopupObjParam());
			if(vendorMasterList != null && !vendorMasterList.isEmpty()){
				 for(int i=0; i<vendorMasterList.size(); i++){
					VendorMasterSP vm = (VendorMasterSP)vendorMasterList.get(i);
					WrapperBeanObject<VendorMasterSP> tmpWrapperBean = new WrapperBeanObject<VendorMasterSP>();
					
					tmpWrapperBean.setDataObj(vm);
					tmpWrapperBean.setMessage("");
					mac004Bean.getVendorMasterPopupList().add(tmpWrapperBean);
					
					mac004Bean.setRenderedMsgDataNotFound(false);
				 }
			 } else {
				 mac004Bean.setRenderedMsgDataNotFound(true);
			 }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmac004Bean(mac004Bean);
	}
	
	public void doClearPopupAddVendor(){
		//log.info("-- doClearPopupAddVendor --");

		SEMMAC004Bean mac004Bean = getSemmac004Bean();

		try {
			
			mac004Bean.getVendorMasterPopupObjParam().setVendorCode("");
			mac004Bean.getVendorMasterPopupObjParam().setVendorName("");
			mac004Bean.setVendorMasterPopupList(new ArrayList<WrapperBeanObject<VendorMasterSP>>());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmac004Bean(mac004Bean);
	}
	
	public void doSelectPopupAddVendor(){
		//log.info("-- doSelectPopupAddVendor --");

		SEMMAC004Bean mac004Bean = getSemmac004Bean();

		try {
			
			String paramVendorCode = getFacesUtils().getRequestParameter("paramVendorCode") == null ? "" : 
							  (String)getFacesUtils().getRequestParameter("paramVendorCode");
			String paramVendorName = getFacesUtils().getRequestParameter("paramVendorName") == null ? "" : 
				  (String)getFacesUtils().getRequestParameter("paramVendorName");
			
			mac004Bean.getMac004Srch().setVendorCode(paramVendorCode);
//			mac004Bean.getMac004Srch().setVendorName(paramVendorName);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmac004Bean(mac004Bean);
	}
	// <- popup add vendor
}
