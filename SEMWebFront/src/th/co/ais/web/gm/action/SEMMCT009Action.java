package th.co.ais.web.gm.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.gm.BankMasterSP;
import th.co.ais.domain.si.Msi001Del;
import th.co.ais.service.gm.IBankMasterService;
import th.co.ais.service.gm.IVendorMasterService;
import th.co.ais.service.si.ISiteApproveService;
import th.co.ais.service.util.ServiceConstants;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.gm.bean.SEMMCT009Bean;
import th.co.ais.web.util.ProvinceCacheUtil;

public class SEMMCT009Action extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 631704783873430083L;

	
	// >> variable and constant declarement
	private static final Logger LOG = Logger.getLogger(SEMMCT009Action.class);
	private SEMMCT009Bean semmct009Bean;
	// << variable and constant declarement

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		LOG.info("::: SEMMCT009Action :: actionWithNavi >> BEGIN :::");

		int page = 0;
		boolean flag = false;
		
		/*
		String pageStr = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("page");
		if("".equals(pageStr)){
			addMessageError("EL0061", "semmct009");
			return false;
		}
		if(pageStr != null) page = Integer.parseInt(pageStr);
		*/
		
		try{
			if(methodWithNavi.equalsIgnoreCase("doSearch")){
				this.doSearch();
			}else if(methodWithNavi.equalsIgnoreCase("doClear")){
				this.doClear();
			} else if(methodWithNavi.equalsIgnoreCase("doInitNewOrUpdate")){
				this.doInitNewOrUpdate();
			} else if(methodWithNavi.equalsIgnoreCase("doSave")){
				this.doSave();
			} else if(methodWithNavi.equalsIgnoreCase("doDelete")){
				this.doDelete();
			} /*else{
				// do nothing 
			}*/
		}catch(Exception e) {
			e.printStackTrace();
			addMessageError("EL0000", "semmct009");
			flag = false;
		}finally {
			LOG.info("::: SEMMCT009Action :: actionWithNavi >> END :::");
		}
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		
		
	}

	@Override
	public void init() {
		LOG.info("::: SEMMCT009Action :: init >> BEGIN :::");
		try{
			SEMMCT009Bean semmct009Bean = new SEMMCT009Bean();
			semmct009Bean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList());
			semmct009Bean.setBankCodeList(getEmptyDropDown());
			semmct009Bean.setBankNameList(getEmptyDropDown());
			
			setSemmct009Bean(semmct009Bean);
			
			retrieveBankSelections();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			LOG.info("::: SEMMCT009Action :: init >> END :::");
		}
	}

	@Override
	public boolean validate() {
		boolean flagValid = true;
		
		semmct009Bean = getSemmct009Bean();
		
		if (StringUtils.isEmpty(semmct009Bean.getItemBankMasterSP().getBankGroupCode())) {
			addMessageError("W0001", msg("message.bankCode"));
			flagValid = false;
		}
		
		if (StringUtils.isEmpty(semmct009Bean.getItemBankMasterSP().getBankName())) {
			addMessageError("W0001", msg("message.bankName"));
			flagValid = false;
		}
		
		if (StringUtils.isEmpty(semmct009Bean.getItemBankMasterSP().getBankBranchCode())) {
			addMessageError("W0001", msg("message.bankBranchCode"));
			flagValid = false;
		}
		
		if (StringUtils.isEmpty(semmct009Bean.getItemBankMasterSP().getBankBranch())) {
			addMessageError("W0001", msg("message.bankBranchName"));
			flagValid = false;
		}
		
		if (StringUtils.isEmpty(semmct009Bean.getItemBankMasterSP().getProvinceId())) {
			addMessageError("W0001", msg("message.province"));
			flagValid = false;
		}
		
		return flagValid;
	}
	
	private boolean validateFrmSearch(){
		boolean flag = false;
		SEMMCT009Bean semmct009Bean = getSemmct009Bean();
		
		BankMasterSP bankSelected = semmct009Bean.getBankSearchSelected();
		semmct009Bean.getCriteriaBankMasterSP().setBankCode(bankSelected.getBankCode());
		semmct009Bean.getCriteriaBankMasterSP().setBankName(bankSelected.getBankName());
		
		String bankGroupCode = semmct009Bean.getCriteriaBankMasterSP().getBankGroupCode();
		String bankName = semmct009Bean.getCriteriaBankMasterSP().getBankName();
		String bankBranchCode = semmct009Bean.getCriteriaBankMasterSP().getBankBranchCode();
		String bankBranchName = semmct009Bean.getCriteriaBankMasterSP().getBankBranch();
		
		LOG.info("::: bankCode: " + bankGroupCode);
		LOG.info("::: bankName: " + bankName);
		LOG.info("::: bankBranchCode: " + bankBranchCode);
		LOG.info("::: bankBranchName: " + bankBranchName);
		
		if(StringUtils.isBlank(bankGroupCode) 
			&& StringUtils.isBlank(bankName) 
			&& StringUtils.isBlank(bankBranchCode) 
			&& StringUtils.isBlank(bankBranchName)){
				
			addMessageError("W0004", msg("message.requireOne"));
			flag = true;
		}
		
		return flag;
	}
	
	public SEMMCT009Bean getSemmct009Bean() {
		SEMMCT009Bean semmct009Bean  =(SEMMCT009Bean)getFacesUtils().getSessionMapValue("semmct009Bean");
		if(semmct009Bean == null) semmct009Bean = new SEMMCT009Bean();
		return semmct009Bean;
	}

	public void setSemmct009Bean(SEMMCT009Bean semmct009Bean) {
		this.semmct009Bean = semmct009Bean;
		getFacesUtils().setSessionMapValue("semmct009Bean", semmct009Bean);
	}
	
	private boolean doClear() {
		LOG.info("::: SEMMCT009Action :: actionWithNavi : doClear :::");
		boolean flag = false;

		semmct009Bean = getSemmct009Bean();

		semmct009Bean.setCriteriaBankMasterSP(new BankMasterSP());							//clear search criteria.
		semmct009Bean.setPopupCriteriaBankMasterSP(new BankMasterSP());						//clear search popup criteria.
		semmct009Bean.setItemBankMasterSP(new BankMasterSP());								//clear dialog item.
		semmct009Bean.setBankMasterList(new ArrayList<WrapperBeanObject<BankMasterSP>>());	//clear data table.
		semmct009Bean.setRenderedMsgDataNotFound(false);									//clear msg data not found.
		
		setSemmct009Bean(semmct009Bean);
		return flag;
	}
	
	private boolean doSearch() {
		LOG.info("::: SEMMCT009Action :: actionWithNavi : doSearch :::");
		boolean flag = false;
		semmct009Bean = getSemmct009Bean();
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		
		if(StringUtils.equals(mode, ServiceConstants.MODULE_ACTION_DELETE)){
			semmct009Bean.setRenderedMsgFormSearch(false);
		}else{
			semmct009Bean.setRenderedMsgFormSearch(true);
		}
		
		if(StringUtils.equals(mode, "SEARCH")){
			if(validateFrmSearch())
			return flag;
		}
		
		semmct009Bean.setChkSelAll(false);
		
		IBankMasterService service = (IBankMasterService)getBean("bankMasterService"); 
		
		List<BankMasterSP> bankMasterList = null;
		
		semmct009Bean.setBankMasterList(new ArrayList<WrapperBeanObject<BankMasterSP>>());
		
		try {
			bankMasterList = service.querySPList(EQueryName.SP_MCT009_BANKMASTER_SEARCH.name, semmct009Bean.getCriteriaBankMasterSP());
			
			if(bankMasterList != null && !bankMasterList.isEmpty()){
				for(int i = 0; i < bankMasterList.size(); i++){
					BankMasterSP vm = bankMasterList.get(i);
					WrapperBeanObject<BankMasterSP> tmpWrapperBean = new WrapperBeanObject<BankMasterSP>();
					
					vm.setCreateDtStr(vm.getCreateDt() == null ? "" : SEMDataUtility.convertToThYearStr(vm.getCreateDt()));
					vm.setUpdateDtStr(vm.getUpdateDt() == null ? "" : SEMDataUtility.convertToThYearStr(vm.getUpdateDt()));
					
					tmpWrapperBean.setDataObj(vm);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					
					semmct009Bean.getBankMasterList().add(tmpWrapperBean);
					semmct009Bean.setRenderedMsgDataNotFound(false);
				 }
			 }else{
				 semmct009Bean.setRenderedMsgDataNotFound(true);
			 }
		}catch(Exception e){
			e.printStackTrace();
		}
		
		setSemmct009Bean(semmct009Bean);
		return flag;
	}
	
	@SuppressWarnings("unchecked")
	private void retrieveBankSelections() {
		IBankMasterService service = (IBankMasterService)getBean("bankMasterService");
		List<BankMasterSP> bankMasterList = null;
		try {
			bankMasterList = service.querySPList(EQueryName.SP_MCT009_BANKMASTER_SEARCH_DDL_BANK.name, semmct009Bean.getCriteriaBankMasterSP());
			if(bankMasterList != null){
				SelectItem t1,t2,t3;
				List<SelectItem> bankCodeList = new ArrayList<SelectItem>();
				List<SelectItem> bankNameList = new ArrayList<SelectItem>();
				List<SelectItem> backSelectionList = new ArrayList<SelectItem>();
				for(BankMasterSP bankMSP : bankMasterList){
					t1 = new SelectItem();
					t2 = new SelectItem();
					t3 = new SelectItem();
					
					t1.setLabel(bankMSP.getBankGroupCode() + " - " + bankMSP.getBankName());
					t1.setValue(bankMSP.getBankGroupCode());
					if(bankMSP.getBankName() != null && !bankMSP.getBankName().equals("")){
						t2.setLabel(bankMSP.getBankName());
						t2.setValue(bankMSP.getBankName());
					}else{
						t2.setLabel("");
						t2.setValue("");
					}
					
					t3.setLabel(bankMSP.getBankGroupCode() + " - " + bankMSP.getBankName());
					t3.setValue(bankMSP.getBankGroupCode() + "#" + bankMSP.getBankName());
					
					backSelectionList.add(t3);
					bankCodeList.add(t1);
					bankNameList.add(t2);
				}
				
				semmct009Bean.setBankMasterSlctList(bankMasterList);
				semmct009Bean.setBankSelectionSearchList(backSelectionList);
				semmct009Bean.setBankCodeList(bankCodeList);
				semmct009Bean.setBankNameList(bankNameList);	
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private boolean doInitNewOrUpdate() {
		LOG.info("::: SEMMCT009Action :: actionWithNavi : doInitNewOrUpdate :::");
		boolean flag = false;
		
		semmct009Bean = getSemmct009Bean();
		String mode = (String)getFacesUtils().getRequestParameter("mode");

		try {
			
			String rowId = (String)getFacesUtils().getRequestParameter("rowId");
			String paramBankGroupCode = (String)getFacesUtils().getRequestParameter("paramBankGroupCode");
			String paramBankName = (String)getFacesUtils().getRequestParameter("paramBankName");
			String paramBankBranchCode = (String)getFacesUtils().getRequestParameter("paramBankBranchCode");
			String paramBankBranch = (String)getFacesUtils().getRequestParameter("paramBankBranch");
			String paramProvince = (String)getFacesUtils().getRequestParameter("paramProvince");
			
			retrieveBankSelections();
			if(StringUtils.equals(mode, "NEW")){
				
				semmct009Bean.setDisbledDialogField(false);
				semmct009Bean.setDoMode("NEW");
				semmct009Bean.setItemBankMasterSP(new BankMasterSP());
				
			} else if(StringUtils.equals(mode, "UPDATE")){
				semmct009Bean.setDisbledDialogField(true);
				semmct009Bean.setDoMode("UPDATE");
				
				semmct009Bean.getItemBankMasterSP().setRowId(rowId);
				semmct009Bean.getItemBankMasterSP().setBankGroupCode(paramBankGroupCode);
				semmct009Bean.getItemBankMasterSP().setBankName(paramBankName);
				semmct009Bean.getItemBankMasterSP().setBankBranchCode(paramBankBranchCode);
				semmct009Bean.getItemBankMasterSP().setBankBranch(paramBankBranch);
				semmct009Bean.getItemBankMasterSP().setProvinceId(paramProvince);
			} else if(StringUtils.equals(mode, "DELETE")){
				semmct009Bean.getItemBankMasterSP().setRowId(rowId);
			}
			
			semmct009Bean.setChkForEdit(false);
				
		}catch(Exception e){
			e.printStackTrace();
		}
		
		setSemmct009Bean(semmct009Bean);
		return flag;
	}
	
	private boolean doSave() {
		LOG.info("::: SEMMCT009Action :: actionWithNavi : doSave :::");
		boolean flag = false;
		
		semmct009Bean = getSemmct009Bean();
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		
		try {
			LOG.info("::: SEMMCT009Action :: actionWithNavi : doSave > [mode: " + mode + "] :::");
			//LOG.info("::: SEMMCT009Action :: actionWithNavi : doSave > \n \t itemBankMasterSP param: " + semmct009Bean.getItemBankMasterSP().toString());
			
			if(validate()){
				IBankMasterService service = (IBankMasterService)getBean("bankMasterService");
				
				semmct009Bean.getItemBankMasterSP().setCurrentUser(getUserLogIn());
				semmct009Bean.getItemBankMasterSP().setActionType(mode);
				
				List<BankMasterSP> to = service.querySPList(EQueryName.SP_MCT009_BANKMASTER_SAVE.name, semmct009Bean.getItemBankMasterSP());
				
				if (to != null && !to.isEmpty()) {
					if (to.get(0).getRetResult().equals("Success")) {
						addMessageInfo("M0001");
						doSearch();
						
						semmct009Bean.setPopupClose(true);
					}
				}
			}
			
		}catch(Exception e){
			addMessageError("E0001");
			e.printStackTrace();
		}
		
		setSemmct009Bean(semmct009Bean);
		return flag;
	}
	
	public boolean doDelete() {
		LOG.info("::: SEMMCT009Action :: actionWithNavi : doDelete :::");
		boolean flag = false;
		
		semmct009Bean = getSemmct009Bean();
		
		try{
			//LOG.info("::: SEMMCT009Action :: actionWithNavi : doDelete > \n \t itemBankMasterSP param: " + semmct009Bean.getItemBankMasterSP().toString());
			IBankMasterService service = (IBankMasterService)getBean("bankMasterService");
			
			semmct009Bean.getItemBankMasterSP().setCurrentUser(getUserLogIn());
			semmct009Bean.getItemBankMasterSP().setActionType("DEL");

			List<BankMasterSP> to = service.querySPList(EQueryName.SP_MCT009_BANKMASTER_SAVE.name, semmct009Bean.getItemBankMasterSP());
			
			if (to != null && !to.isEmpty()) {
				if (to.get(0).getRetResult().equals("Success")) {
					addMessageInfo("M0002");
					doSearch();
				}
			}
			
		}catch(Exception e){
			addMessageError("E0002");
			e.printStackTrace();
		}
		setSemmct009Bean(semmct009Bean);
		return flag;
	}
	
	public void doSemiLiveSearch() {
		LOG.info("::: SEMMCT009Action :: actionWithNavi : doSemiLiveSearch :::");
		
		semmct009Bean = getSemmct009Bean();
		
		try{
			String paramLiveMode = (String)getFacesUtils().getRequestParameter("paramLiveMode");
			
			if(paramLiveMode.equalsIgnoreCase("GROUP_CODE")) {
				semmct009Bean.getItemBankMasterSP().setBankBranchCode("");
				semmct009Bean.getItemBankMasterSP().setBankBranch("");
				semmct009Bean.getItemBankMasterSP().setProvinceId("");
				
				String bankCode = semmct009Bean.getItemBankMasterSP().getBankCode();
				semmct009Bean.getItemBankMasterSP().setBankGroupCode(bankCode);

				getSemmct009Bean().setDisbledDialogField(false);
				getSemmct009Bean().setChkForEdit(true);
				return;
			}
				
			
			String groupCodeVal = semmct009Bean.getItemBankMasterSP().getBankGroupCode();
			String branchCodeVal = semmct009Bean.getItemBankMasterSP().getBankBranchCode();
			String bankName = semmct009Bean.getItemBankMasterSP().getBankName();
			
			//LOG.info("::: SEMMCT009Action :: actionWithNavi : doSemiLiveSearch > \n \t itemBankMasterSP param: " + semmct009Bean.getItemBankMasterSP().toString());
			LOG.info("::: SEMMCT009Action :: actionWithNavi : doSemiLiveSearch > [mode: " + paramLiveMode + "] :::");
			
			semmct009Bean.setPopupCriteriaBankMasterSP(new BankMasterSP());
			semmct009Bean.getPopupCriteriaBankMasterSP().setBankGroupCode(groupCodeVal);
			semmct009Bean.getPopupCriteriaBankMasterSP().setBankName(bankName);
			semmct009Bean.getPopupCriteriaBankMasterSP().setBankBranchCode(branchCodeVal);
			
			IBankMasterService service = (IBankMasterService)getBean("bankMasterService");
			List<BankMasterSP> retItemLst = service.querySPList(EQueryName.SP_MCT009_BANKMASTER_SEARCH.name, semmct009Bean.getPopupCriteriaBankMasterSP());
			
			String bankBranchItem = retItemLst.size() != 0 ? retItemLst.get(0).getBankBranch() : "";
			String provinceItem = retItemLst.size() != 0 ? retItemLst.get(0).getProvinceId(): "";
			
			semmct009Bean.getItemBankMasterSP().setBankBranch(bankBranchItem);
			semmct009Bean.getItemBankMasterSP().setProvinceId(provinceItem);
			
		}catch(NullPointerException ne){
			LOG.error(ne);
		}catch(Exception e){
			LOG.error(e);
		}
		
		setSemmct009Bean(semmct009Bean);
	}
	
	public void doChkForEdit() {
		LOG.info("::: SEMMCT009Action : doChkForEdit :::");
		try{
			if(getSemmct009Bean().isChkForEdit()) {
				LOG.info("::: SEMMCT009Action : doChkForEdit > editable :::");
				getSemmct009Bean().setDisbledDialogField(false);
				getSemmct009Bean().setChkForEdit(false);
			} else {
				LOG.info("::: SEMMCT009Action : doChkForEdit > uneditable :::");
				getSemmct009Bean().setDisbledDialogField(true);
				getSemmct009Bean().setChkForEdit(true);
			}
			
		}catch(NullPointerException ne){
			LOG.error(ne);
		}catch(Exception e){
			LOG.error(e);
		}
	}
	
	public void selectAllRow(){
		LOG.info("::: SEMMCT009Action : selectAllRow :::");
		try{
			boolean chkAll = getSemmct009Bean().isChkSelAll();
			LOG.info("chkAll " + chkAll);
			
			List<WrapperBeanObject<BankMasterSP>> detailList = new ArrayList<WrapperBeanObject<BankMasterSP>>();
			detailList = getSemmct009Bean().getBankMasterList();
			for(int i=0; i<detailList.size(); i++){
				detailList.get(i).setCheckBox(chkAll);
			}
				
		}catch(NullPointerException ne){
			LOG.error(ne);
		}catch(Exception e){
			LOG.error(e);
		}
	}

}
