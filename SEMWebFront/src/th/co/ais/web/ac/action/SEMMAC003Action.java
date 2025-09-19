package th.co.ais.web.ac.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.ais.sem.vendor.transfer.TextSAPToVendorMasterTB;
import com.ais.sem.trans.vendor.transfer.TransferSapVendorToSemVendor;
import com.ais.sem.sapvendor.transfer.TextSAPVendorResponseTB;

import com.ais.sem.response.transfer.TextSAPToTrxResponseTB;

import com.ais.sem.payment.transfer.TextSAPToPaymentTB;
import com.ais.sem.cancel.transfer.TextSAPToCancelDocTB;
import com.ais.sem.proc.run.ProceSemSpMac003File;

import th.co.ais.domain.ac.Mac003File;
import th.co.ais.domain.ac.Mac003Srch;
import th.co.ais.domain.sap.SapErrorLog;
import th.co.ais.service.pt.IPTaxMasterService;
import th.co.ais.service.sap.ISAPErrorLog;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.ac.bean.SEMMAC003Bean;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.util.FrontMessageUtils;

public class SEMMAC003Action extends AbstractAction{

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if(methodWithNavi.equalsIgnoreCase("doSearch")){
			flag = doSearch();
		}else if(methodWithNavi.equalsIgnoreCase("doClearSession")){
			flag = doClearSession();
		}else if(methodWithNavi.equalsIgnoreCase("doUpdate")){
			flag = doUpdate();
		}else if(methodWithNavi.equalsIgnoreCase("doRefreshSAP")){
			flag = doRefreshSAP();
		}
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		SEMMAC003Bean semmac003Bean = new SEMMAC003Bean();
		semmac003Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmac003Bean.setErrorStatusList(getLovItemsByType(ELovType.T_CT_SAP_ERROR_STATUS.name));
		semmac003Bean.setMac003Srch(new Mac003Srch());
		semmac003Bean.setMac003File(new Mac003File());
		setSemmac003Bean(semmac003Bean);
		
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean doSearch(){
		boolean flag = false;
		semmac003Bean = getSemmac003Bean();
		if(!validateSearch()){
			return flag;
		}
		semmac003Bean.setMac003SrchList(new ArrayList<WrapperBeanObject<Mac003Srch>>());
		IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
		List<Mac003Srch> to =null;
		try {
			to = pTaxMasterService.querySPList(EQueryName.SP_MAC003_SRCH.name, semmac003Bean.getMac003Srch());
			if (to == null || to.size() == 0) {
				semmac003Bean.setRenderedMsgDataNotFound(true);
			}else{
				semmac003Bean.setRenderedMsgDataNotFound(false);
				
				 for(int i=0; i<to.size(); i++){
					 Mac003Srch mac003SrchSP = (Mac003Srch)to.get(i);
					 WrapperBeanObject<Mac003Srch> tmpWrapperBean = new WrapperBeanObject<Mac003Srch>();
				 
					 /** Convert to Thai Date **/
					 if(mac003SrchSP.getErrorDt() != null){
						 mac003SrchSP.setErrorDt(SEMDataUtility.convertToThYear(mac003SrchSP.getErrorDt()));
					 }
					 if(mac003SrchSP.getUpdateDt() != null){
						 mac003SrchSP.setUpdateDt(SEMDataUtility.convertToThYear(mac003SrchSP.getUpdateDt()));
					 }
					 
					 tmpWrapperBean.setDataObj(mac003SrchSP);
					 tmpWrapperBean.setMessage("");
					 tmpWrapperBean.setCheckBox(false);
					 semmac003Bean.getMac003SrchList().add(tmpWrapperBean);	
				 }
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setSemmac003Bean(semmac003Bean);
		return flag;
	}
	
	private boolean validateSearch() {
		boolean flagValid = true;
		if(StringUtils.isEmpty(getSemmac003Bean().getMac003Srch().getCompany())){
			addMessageError("W0001", msg("message.company"));
			flagValid = false;
		}
		return flagValid;
	}
	
	private boolean doClearSession(){
		boolean flag = false;
		semmac003Bean = getSemmac003Bean();
		semmac003Bean.setMac003Srch(new Mac003Srch());
		semmac003Bean.setMac003SrchList(null);
		semmac003Bean.setRenderedMsgDataNotFound(false);
		setSemmac003Bean(semmac003Bean);
		return flag;
	}
	
	public void selectAllRow(){
		try{
			boolean chkAll = getSemmac003Bean().isChkSelAll();
			List<WrapperBeanObject<Mac003Srch>> detailList = new ArrayList<WrapperBeanObject<Mac003Srch>>();
			detailList = getSemmac003Bean().getMac003SrchList();
			for(int i=0; i<detailList.size(); i++){
				detailList.get(i).setCheckBox(chkAll);
			}
			
			onRenderButton();
		}catch(NullPointerException ne){
//			LOG.error(ne);
		}catch(Exception e){
//			LOG.error(e);
		}
	}
	
	public void onRenderButton(){
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemmac003Bean().setTmpRowId(rowId);
		
		if(isCheckSELBox())
		getSemmac003Bean().setDisableBtnUpdateStatus(false);
		else
		getSemmac003Bean().setDisableBtnUpdateStatus(true);
	}
	
	private boolean isCheckSELBox(){
		boolean isCheck = false;
		List<WrapperBeanObject<Mac003Srch>> mac003Srch = getSemmac003Bean().getMac003SrchList();
		for (WrapperBeanObject<Mac003Srch> wrapperBeanObject : mac003Srch) {
			if(wrapperBeanObject.isCheckBox()){
				return true;
			}
		}
		return isCheck;
	}
	
	private boolean doUpdate(){
		boolean flag = false;
		semmac003Bean = getSemmac003Bean();
		ISAPErrorLog sapErrorLogService = (ISAPErrorLog)getBean("sapErrorLogService");
		SapErrorLog sap = new SapErrorLog();
		try {
			for (WrapperBeanObject<Mac003Srch> temp : semmac003Bean.getMac003SrchList()) {
				Mac003Srch mc = (Mac003Srch)temp.getDataObj();
				if(temp.isCheckBox()){					
					sap = sapErrorLogService.getSapErrorLogByRowId(mc.getRowId());
					sap.setErrorStatus(semmac003Bean.getTmpStatus());
					sap.setRemark(semmac003Bean.getTmpRemark());
					sapErrorLogService.updateSapErrorLog(sap);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setSemmac003Bean(semmac003Bean);
		doSearch();
		return flag;
	}
	
	private boolean doRefreshSAP(){
		boolean flag = false;
		semmac003Bean = getSemmac003Bean();
		
		TextSAPVendorResponseTB textSAPVendorResponse = new TextSAPVendorResponseTB();
		TextSAPToVendorMasterTB textSAPToVendorMaster = new TextSAPToVendorMasterTB();
		TransferSapVendorToSemVendor transferSapVendorToSemVendor = new TransferSapVendorToSemVendor();
		
		TextSAPToTrxResponseTB textSAPToTrxResponse = new TextSAPToTrxResponseTB();
		
		TextSAPToPaymentTB textSAPToPayment = new TextSAPToPaymentTB();
		TextSAPToCancelDocTB textSAPToCancelDoc = new TextSAPToCancelDocTB();
		//ProceSemSpMac003File proceSemSpMac003File = new ProceSemSpMac003File(); // < unused .. look for 'SP_MAC003_FILE' instead
		
		IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
		List<Mac003File> to =null;
		
		try {
			// VENDOR MASTER
			textSAPVendorResponse.doProcess();
			textSAPToVendorMaster.doProcess();
			transferSapVendorToSemVendor.doProcess();
			
			// SAP RESPONSE
			textSAPToTrxResponse.doProcess();
			
			// PAYMENT
			textSAPToPayment.doProcess();
			textSAPToCancelDoc.doProcess();
			//proceSemSpMac003File.callProc(); // < unused .. look for 'SP_MAC003_FILE' instead
			
			semmac003Bean.getMac003File().setUserId(getUserLogIn());
			to = pTaxMasterService.querySPList(EQueryName.SP_MAC003_FILE.name, semmac003Bean.getMac003File());
			if (to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")) {
				addMessageInfo("M0003");
			}else if(to != null && !to.isEmpty()){
				FrontMessageUtils.addMessageError(to.get(0).getpRemark());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmac003Bean(semmac003Bean);
		return flag;
	}
	
	private SEMMAC003Bean semmac003Bean;
	
	public SEMMAC003Bean getSemmac003Bean() {
		return (SEMMAC003Bean)getFacesUtils().getSessionMapValue("semmac003Bean");
	}

	public void setSemmac003Bean(SEMMAC003Bean semmac003Bean) {
		this.semmac003Bean = semmac003Bean;
		getFacesUtils().setSessionMapValue("semmac003Bean", semmac003Bean);
	}
	
	public void getRowIdOnClick() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemmac003Bean().setTmpRowId(rowId);
	}
}
