package th.co.ais.web.gm.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.ais.sem.vendor.master.model.UserProfile;
import com.ais.sem.vendor.master.transfer.GenFileVendorMaster;
//import com.ctc.wstx.util.StringUtil;

import sap.client.service.call.WsClientService;
import th.co.ais.domain.gm.ApproveBookBankAct;
import th.co.ais.domain.gm.ApproveBookBankSP;
import th.co.ais.domain.gm.CT001Export;
import th.co.ais.domain.gm.CT001ExportBank;
import th.co.ais.domain.gm.VendorMasterSP;
import th.co.ais.domain.mm.ItemParamsSP;
import th.co.ais.rpt.util.bean.CellDomain;
import th.co.ais.rpt.util.bean.EnumDocStyleDomain;
import th.co.ais.rpt.util.bean.RowDomain;
import th.co.ais.rpt.util.enums.EnumDocStyle;
import th.co.ais.rpt.util.enums.EnumDocumentType;
import th.co.ais.service.gm.ILovMasterService;
import th.co.ais.service.gm.IVendorMasterService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.gm.bean.SEMMCT001Bean;
import th.co.ais.web.gm.bean.SEMMCT003Bean;
import th.co.ais.web.report.util.DocumentExportManager;
import th.co.ais.web.util.FrontMessageUtils;

public class SEMMCT003Action extends AbstractAction{
	
	private Logger LOG = Logger.getLogger(getClass());
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if(methodWithNavi.equalsIgnoreCase("doSearch")){
			flag = doSearch();
		}else if(methodWithNavi.equalsIgnoreCase("doClear")){
			flag = doClear();
		}else if(methodWithNavi.equalsIgnoreCase("doSaveAct")){
			flag = doSaveAct();
		}else if (methodWithNavi.equalsIgnoreCase("initApprove")) {
			flag = initApprove();
		}else if (methodWithNavi.equalsIgnoreCase("doClearApproveStatus")) {
			flag = doClearApproveStatus();
		}else if(methodWithNavi.equalsIgnoreCase("doCheckFinance")){
			flag = doCheckFinance();
		}else if(methodWithNavi.equalsIgnoreCase("initChecker")){
			flag = initChecker();
		}else if(methodWithNavi.equalsIgnoreCase("initExportVendorBookbankToLeader")){
			initExportVendorBookbankToLeader();
		}else if(methodWithNavi.equalsIgnoreCase("doSearchSap")){
			flag = doSearchSap();
		}else if(methodWithNavi.equalsIgnoreCase("doCheckerFinanceApprove")){
			flag = doCheckerFinanceApprove();
		}
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		SEMMCT003Bean semmct003Bean = new SEMMCT003Bean();
		semmct003Bean.setPayeeStatusList(getLovItemsByType(ELovType.T_CT_FINANCE_STATUS.name));
		semmct003Bean.setPayeeTypeList(getLovItemsByType(ELovType.T_CT_PAYEE_TYPE.name));
		semmct003Bean.setBankStatusList(getLovItemsByType(ELovType.T_CT_BANK_STATUS.name));
		semmct003Bean.setApproveBookBankSP(new ApproveBookBankSP());
		semmct003Bean.setApproveBookBankAct(new ApproveBookBankAct());
		setSemmct003Bean(semmct003Bean);
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private SEMMCT003Bean semmct003Bean;
	
	public SEMMCT003Bean getSemmct003Bean() {
		return (SEMMCT003Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmct003Bean");
	}

	public void setSemmct003Bean(SEMMCT003Bean semmct003Bean) {
		this.semmct003Bean = semmct003Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmct003Bean", semmct003Bean);
	}
	
	public boolean doSearch(){
		boolean flag = false;
		semmct003Bean = getSemmct003Bean();
		semmct003Bean.setRenderedMsgFormSearch(true);
		semmct003Bean.setRenderedMsgFormMiddle(false);
//		if(!validateSearch()){
//			return flag;
//		}
		ILovMasterService lovMasterService = (ILovMasterService)getBean("lovMasterService");
		List<ApproveBookBankSP> to = null;
		semmct003Bean.setApproveBookBankSPList(new ArrayList<WrapperBeanObject<ApproveBookBankSP>>());
		try {
			//added by NEW 20151110 set UserId
//			if(semmct003Bean.getApproveBookBankSP().getCreateBy() == null){
//				semmct003Bean.getApproveBookBankSP().setCreateBy(getUserLogIn());
//			}
			to = lovMasterService.querySPList(EQueryName.SP_SEARCH_APPROVE_BOOK_BANK.name, semmct003Bean.getApproveBookBankSP());
			if(to == null || to.size() == 0){
				semmct003Bean.setRenderedMsgDataNotFound(true);
				
			}else{
				semmct003Bean.setRenderedMsgDataNotFound(false);
//				int tmpCountRenderChkAll = 0;
				 for(int i=0; i<to.size(); i++){
					 ApproveBookBankSP approveBookBankSP = (ApproveBookBankSP)to.get(i);
					 WrapperBeanObject<ApproveBookBankSP> tmpWrapperBean = new WrapperBeanObject<ApproveBookBankSP>();
					 //Case RecordStatus = null
					 approveBookBankSP.setRenderedCheckBox(true);
					 //
					 if(approveBookBankSP.getRecordStatus() != null){ 
						if(approveBookBankSP.getRecordStatus().equals("03") ||
						   approveBookBankSP.getRecordStatus().equals("04")){
//							if(approveBookBankSP.getRecordStatus().equals("03")){
//								semmct003Bean.setRenderedApproveBtn(false);
//								semmct003Bean.setRenderedCheckBtn(true);
//							}else if(approveBookBankSP.getRecordStatus().equals("04")){
//								semmct003Bean.setRenderedApproveBtn(true);
//								semmct003Bean.setRenderedCheckBtn(false);
//							}
						   approveBookBankSP.setRenderedCheckBox(true);
						}else{
							semmct003Bean.setRenderedApproveBtn(false);
							semmct003Bean.setRenderedCheckBtn(false);
						   approveBookBankSP.setRenderedCheckBox(false);
						}
					 }
//					 else{
//						 tmpCountRenderChkAll++;
//					 }
					 
					 //convert to Thai Year
					 if(approveBookBankSP.getApproveDt() != null){
						 approveBookBankSP.setApproveDt(SEMDataUtility.convertToThYear(approveBookBankSP.getApproveDt()));
					 }
					 if(approveBookBankSP.getCreateDt() != null){
						 approveBookBankSP.setCreateDt(SEMDataUtility.convertToThYear(approveBookBankSP.getCreateDt()));
					 }
					 tmpWrapperBean.setDataObj(approveBookBankSP);
					 tmpWrapperBean.setMessage("");
					 tmpWrapperBean.setCheckBox(false);
					 semmct003Bean.getApproveBookBankSPList().add(tmpWrapperBean);
				 }
//			 semmct003Bean.setDisableChkAll(true);
//			 if(tmpCountRenderChkAll > 0){
//				 semmct003Bean.setDisableChkAll(false);
//			 }
	    }
			 setSemmct003Bean(semmct003Bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			addMessageError("E0003");
		}
		return flag;
	}
	
	//added ny NEW 23/05/2017
	public boolean doSearchSap(){
		boolean flag = false;
		semmct003Bean = getSemmct003Bean();
		semmct003Bean.setRenderedMsgFormSearch(true);
		semmct003Bean.setRenderedMsgFormMiddle(false);
//		if(!validateSearch()){
//			return flag;
//		}
		ILovMasterService lovMasterService = (ILovMasterService)getBean("lovMasterService");
		List<ApproveBookBankSP> to = null;
		semmct003Bean.setApproveBookBankSPList(new ArrayList<WrapperBeanObject<ApproveBookBankSP>>());
		try {
			//added by NEW 20151110 set UserId
//			if(semmct003Bean.getApproveBookBankSP().getCreateBy() == null){
//				semmct003Bean.getApproveBookBankSP().setCreateBy(getUserLogIn());
//			}
			to = lovMasterService.querySPList(EQueryName.SP_SEARCH_SAP_APPROVE_BOOK_BANK.name, semmct003Bean.getApproveBookBankSP());
			if(to == null || to.size() == 0){
				semmct003Bean.setRenderedMsgDataNotFound(true);
				
			}else{
				semmct003Bean.setRenderedMsgDataNotFound(false);
//				int tmpCountRenderChkAll = 0;
				 for(int i=0; i<to.size(); i++){
					 ApproveBookBankSP approveBookBankSP = (ApproveBookBankSP)to.get(i);
					 WrapperBeanObject<ApproveBookBankSP> tmpWrapperBean = new WrapperBeanObject<ApproveBookBankSP>();
					 //Case RecordStatus = null
					 approveBookBankSP.setRenderedCheckBox(true);
					 //
//					 if(approveBookBankSP.getRecordStatus() != null){ 
//						if(approveBookBankSP.getRecordStatus().equals("03") ||
//						   approveBookBankSP.getRecordStatus().equals("04")){
////							if(approveBookBankSP.getRecordStatus().equals("03")){
////								semmct003Bean.setRenderedApproveBtn(false);
////								semmct003Bean.setRenderedCheckBtn(true);
////							}else if(approveBookBankSP.getRecordStatus().equals("04")){
////								semmct003Bean.setRenderedApproveBtn(true);
////								semmct003Bean.setRenderedCheckBtn(false);
////							}
//						   approveBookBankSP.setRenderedCheckBox(true);
//						}else{
//							semmct003Bean.setRenderedApproveBtn(false);
//							semmct003Bean.setRenderedCheckBtn(false);
//						   approveBookBankSP.setRenderedCheckBox(false);
//						}
//					 }
//					 else{
//						 tmpCountRenderChkAll++;
//					 }
					 
					 //convert to Thai Year
					 if(approveBookBankSP.getApproveDt() != null){
						 approveBookBankSP.setApproveDt(SEMDataUtility.convertToThYear(approveBookBankSP.getApproveDt()));
					 }
					 if(approveBookBankSP.getCreateDt() != null){
						 approveBookBankSP.setCreateDt(SEMDataUtility.convertToThYear(approveBookBankSP.getCreateDt()));
					 }
					 if(approveBookBankSP.getCheckerDt() != null){
						 approveBookBankSP.setCheckerDt(SEMDataUtility.convertToThYear(approveBookBankSP.getCheckerDt()));
					 }
					 tmpWrapperBean.setDataObj(approveBookBankSP);
					 tmpWrapperBean.setMessage("");
					 tmpWrapperBean.setCheckBox(false);
					 semmct003Bean.getApproveBookBankSPList().add(tmpWrapperBean);
				 }
//			 semmct003Bean.setDisableChkAll(true);
//			 if(tmpCountRenderChkAll > 0){
//				 semmct003Bean.setDisableChkAll(false);
//			 }
				 
				 semmct003Bean.setChkSelAll(false);
				 semmct003Bean.setScrollerPage("1");
				 this.selectSapAllRow();
	    }
			 setSemmct003Bean(semmct003Bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			addMessageError("E0003");
		}
		return flag;
	}
	
	//added by NEW20151018
	public boolean initChecker(){
		boolean flag = false;
		semmct003Bean = getSemmct003Bean();
		String btnApproveStatus = (String)getFacesUtils().getRequestParameter("btnApproveStatus") == null ? "" : (String)getFacesUtils().getRequestParameter("btnApproveStatus");
		String actionType = getFacesUtils().getRequestParameter("actionType") == null ?  "" : (String)getFacesUtils().getRequestParameter("actionType");
		semmct003Bean.setRemark("");
		semmct003Bean.setBtnApproveStatus(btnApproveStatus);
		semmct003Bean.setActionType(actionType);
		setSemmct003Bean(semmct003Bean);
		return flag;
	}
	
	public boolean doSaveAct(){
		boolean flag = false;
		semmct003Bean = getSemmct003Bean();
		ILovMasterService lovMasterService = (ILovMasterService)getBean("lovMasterService");
		List<ApproveBookBankAct> to = null;
		String vendorMapPayeeIdConCat = "";
		String payeeTypeDescTemp = "";
		String actionType = "";
		// loop for Concat RowId
		for (WrapperBeanObject<ApproveBookBankSP> temp : semmct003Bean.getApproveBookBankSPList()) {
			ApproveBookBankSP ap = (ApproveBookBankSP)temp.getDataObj();
			
			if(temp.isCheckBox()){
				if(payeeTypeDescTemp.equals("")){
					payeeTypeDescTemp = ap.getPayeeTypeDesc();
				}else{
					if(!payeeTypeDescTemp.equals(ap.getPayeeTypeDesc())){
	//					addMessageError("test");
						this.doClearApproveStatus();
						FrontMessageUtils.addMessageError(msg("message.payeeType"));
						return flag;
					}
				}
				
				//set Action Type
				if("APPROVE".equals(semmct003Bean.getBtnApproveStatus())){
					if(ap.getPayeeTypeDesc() != null && 
							"VENDOR BOOKBANK".equals(ap.getPayeeTypeDesc().toUpperCase())){
						actionType = "FA";
					}else if(ap.getPayeeTypeDesc() != null &&
							 "PAYEE BOOKBANK".equals(ap.getPayeeTypeDesc().toUpperCase())){
						actionType = "PA";
					}
				}else{
					if(ap.getPayeeTypeDesc() != null && 
							"VENDOR BOOKBANK".equals(ap.getPayeeTypeDesc().toUpperCase())){
						actionType = "FC";
					}else if(ap.getPayeeTypeDesc() != null && 
							"PAYEE BOOKBANK".equals(ap.getPayeeTypeDesc().toUpperCase())){
						actionType = "PC";
					}
				}
			}
			
			if(temp.isCheckBox() && vendorMapPayeeIdConCat.equals("")){
				vendorMapPayeeIdConCat = ap.getVendorMappayeeId();
			}
			else if(temp.isCheckBox() && !vendorMapPayeeIdConCat.equals("")){
				vendorMapPayeeIdConCat = vendorMapPayeeIdConCat+",".trim()+ap.getVendorMappayeeId();
			}
		}
		
		//add property ApproveBookBankAct before Save Store
		semmct003Bean.getApproveBookBankAct().setVendorMapPayeeId(vendorMapPayeeIdConCat);
		semmct003Bean.getApproveBookBankAct().setRemark(semmct003Bean.getRemark());
		semmct003Bean.getApproveBookBankAct().setActionType(actionType);
		semmct003Bean.getApproveBookBankAct().setUserId(getUserLogIn());
		try {
			to = lovMasterService.querySPList(EQueryName.SP_APPROVE_BOOK_BANK_ACT.name, semmct003Bean.getApproveBookBankAct());
			if (to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")) {
				
				if("APPROVE".equals(semmct003Bean.getBtnApproveStatus())){
					// -> gen files to SAP
					String vendorMasterIdGroup = "";
					UserProfile userPro = new UserProfile();
					userPro.setCreateby(getUserLogIn());
					userPro.setEmail(getUserLogIn()+"@ais.co.th".trim());
					userPro.setFilename(to.get(0).getFileName());
					userPro.setUserId(getUserLogIn());
					
					GenFileVendorMaster genFile = new GenFileVendorMaster();
					vendorMasterIdGroup = getVendorSelected().toString();
					try{
						if("FA".equals(actionType)){
							genFile.doProcess(vendorMasterIdGroup, userPro, "B");
						}
						LOG.info("Gen File Success !!");
					} catch (Exception e) {
						LOG.info("Gen File Error !!");
					}
					// <-
				}
				
				addMessageInfo("M0001");
				semmct003Bean.setPopupClose(true);
			}else if(to != null && !to.isEmpty()){
				FrontMessageUtils.addMessageError(to.get(0).getpRemark());
			}
			semmct003Bean.setPopupClose(true);
			setSemmct003Bean(semmct003Bean);
			doSearch();
			doClearApproveStatus();
		} catch (Exception e) {
			e.printStackTrace();
				addMessageError("E0001");
		}
		getSemmct003Bean().setRenderedMsgFormSearch(false);
		getSemmct003Bean().setRenderedMsgFormMiddle(true);
		return flag;
	}
	
	private boolean doCheckFinance(){
		boolean flag = false;
		semmct003Bean = getSemmct003Bean();
		ILovMasterService lovMasterService = (ILovMasterService)getBean("lovMasterService");
		List<ApproveBookBankAct> to = null;
		String vendorMapPayeeIdConCat = "";
		String payeeTypeDescTemp = "";
		String actionType = "";
		// loop for Concat RowId
		for (WrapperBeanObject<ApproveBookBankSP> temp : semmct003Bean.getApproveBookBankSPList()) {
			ApproveBookBankSP ap = (ApproveBookBankSP)temp.getDataObj();
			
			if(temp.isCheckBox()){
				if(payeeTypeDescTemp.equals("")){
					payeeTypeDescTemp = ap.getPayeeTypeDesc();
				}else{
					if(!payeeTypeDescTemp.equals(ap.getPayeeTypeDesc())){
//						addMessageError("test");
						this.doClearApproveStatus();
						FrontMessageUtils.addMessageError(msg("message.payeeType"));
						return flag;
					}
				}
				
				//set Action Type
				if("APPROVE".equals(semmct003Bean.getBtnApproveStatus())){
					if(ap.getPayeeTypeDesc() != null && 
							"VENDOR BOOKBANK".equals(ap.getPayeeTypeDesc().toUpperCase())){
						actionType = "CA";
					}else if(ap.getPayeeTypeDesc() != null &&
							 "PAYEE BOOKBANK".equals(ap.getPayeeTypeDesc().toUpperCase())){
						actionType = "PA";
					}
				}else{
					if(ap.getPayeeTypeDesc() != null && 
							"VENDOR BOOKBANK".equals(ap.getPayeeTypeDesc().toUpperCase())){
						actionType = "PA";
					}else if(ap.getPayeeTypeDesc() != null && 
							"PAYEE BOOKBANK".equals(ap.getPayeeTypeDesc().toUpperCase())){
						actionType = "PC";
					}
				}
			}
			
			
			if(temp.isCheckBox() && vendorMapPayeeIdConCat.equals("")){
				vendorMapPayeeIdConCat = ap.getVendorMappayeeId();
			}
			else if(temp.isCheckBox() && !vendorMapPayeeIdConCat.equals("")){
				vendorMapPayeeIdConCat = vendorMapPayeeIdConCat+",".trim()+ap.getVendorMappayeeId();
			}
		}
		
		//add property ApproveBookBankAct before Save Store
		semmct003Bean.getApproveBookBankAct().setVendorMapPayeeId(vendorMapPayeeIdConCat);
		semmct003Bean.getApproveBookBankAct().setRemark(semmct003Bean.getRemark());
		semmct003Bean.getApproveBookBankAct().setActionType(actionType);
		semmct003Bean.getApproveBookBankAct().setUserId(getUserLogIn());
		try{
			to = lovMasterService.querySPList(EQueryName.SP_CHECK_APPROVE_BOOK_BANK.name, semmct003Bean.getApproveBookBankAct());
			if (to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")) {
				addMessageInfo("M0001");
			}else if(to != null && !to.isEmpty()){
				FrontMessageUtils.addMessageError(to.get(0).getpRemark());
			}
			semmct003Bean.setPopupClose(true);
			this.doClearApproveStatus();
			this.doSearch();
			setSemmct003Bean(semmct003Bean);
			
		}catch (Exception e) {
			e.printStackTrace();
			LOG.debug(e);
			// TODO: handle exception
		}
		return flag;
	}
	
	private boolean doCheckerFinanceApprove(){
		boolean flag = false;
		semmct003Bean = getSemmct003Bean();
		ILovMasterService lovMasterService = (ILovMasterService)getBean("lovMasterService");
		List<ApproveBookBankAct> to = new ArrayList<ApproveBookBankAct>();
		List<ApproveBookBankAct> to2 = new ArrayList<ApproveBookBankAct>();
		String vendorMapPayeeIdConCat = "";
		String payeeTypeDescTemp = "";
		String actionType = semmct003Bean.getActionType();
		// loop for Concat RowId
		ItemParamsSP itemParams = new ItemParamsSP();
		
		WsClientService sapService = new WsClientService();
//		sapService.masterBank(itemParams);
		try{
			//map value
			
			
			//add property ApproveBookBankAct before Save Store
			semmct003Bean.getApproveBookBankAct().setVendorMapPayeeId(doGetBookbankId(semmct003Bean.getApproveBookBankSPList()));
			semmct003Bean.getApproveBookBankAct().setRemark(semmct003Bean.getRemark());
			semmct003Bean.getApproveBookBankAct().setActionType(actionType);
			semmct003Bean.getApproveBookBankAct().setUserId(getUserLogIn());
			
			
			to = lovMasterService.querySPList(EQueryName.SP_CHECK_SAP_APPROVE_BOOK_BANK.name, semmct003Bean.getApproveBookBankAct());
			if (to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")) {
				if(StringUtils.equals("FA", actionType)){
					//check bankStatus = new
					for (WrapperBeanObject<ApproveBookBankSP> temp : semmct003Bean.getApproveBookBankSPList()) {
						if(temp.isCheckBox()){
							ApproveBookBankSP ap = (ApproveBookBankSP)temp.getDataObj();
							ApproveBookBankAct bookbankAct = new ApproveBookBankAct();
							ApproveBookBankAct result = new ApproveBookBankAct();
							ApproveBookBankSP resultGetvenbank = new ApproveBookBankSP();
							//check bankStatus = new
							if(StringUtils.equals("NEW", ap.getBankStatus().toUpperCase())){
								//call web service Z_FIAP_SEM_MASTERBANK
								result = new ApproveBookBankAct();
								itemParams = new ItemParamsSP();
								itemParams.setParam1(ap.getBankCode());
								itemParams.setParam2(ap.getBankName());
//								itemParams.setParam1(ap.getCity());
								result = sapService.checkMasterBank(itemParams);
								if(StringUtils.equals("E", result.getResultMsg().toUpperCase())){
									addGeneralMessageError(msg("message.error.approvebookbank.newbank")+" : "+ap.getBankCode()+" "+ap.getBankName()+" "+ap.getBankBranch());
									return flag;
								}
							}
							
							
							if(StringUtils.equals("VENDOR", ap.getBankType().toUpperCase())){
								//call web service GET Bookbank
//								result = new ApproveBookBankAct();
								itemParams = new ItemParamsSP();
								itemParams.setParam1(ap.getVendorCode());
								resultGetvenbank = sapService.getSapVendorbank(itemParams);
								if(StringUtils.equals("E", resultGetvenbank.getResult().toUpperCase())){
									addGeneralMessageError(msg("message.error.approvebookbank.incomplete"));
									bookbankAct.setSapMsg(resultGetvenbank.getResult());
									bookbankAct.setSapStatus(resultGetvenbank.getRemark());
									actionType = "SE";
								}else{
									//
									if(StringUtils.isEmpty(resultGetvenbank.getBankAccNo())){
										if(StringUtils.equals("ADD", ap.getActionType().toUpperCase()) || 
												StringUtils.equals("CHANGE", ap.getActionType().toUpperCase())){
											
											itemParams = new ItemParamsSP();
											itemParams.setParam1(ap.getVendorCode());
											itemParams.setParam2(ap.getBankCode());
											itemParams.setParam3(ap.getBankAccNo());
											itemParams.setParam4(ap.getBankAccName());
											//call web service ADD	
											result = sapService.addSapVenBank(itemParams);
											if(result != null){
												if(StringUtils.equals("E", result.getResultMsg().toUpperCase())){
													addGeneralMessageError(msg("message.error.approvebookbank.incomplete"));
													bookbankAct.setSapMsg(result.getResultMsg());
													bookbankAct.setSapStatus(result.getpRemark());
													actionType = "SE";
												}
											}else{
												addGeneralMessageError(msg("message.error.approvebookbank.incomplete"));
												bookbankAct.setSapMsg(result.getResultMsg());
												bookbankAct.setSapStatus(result.getpRemark());
												actionType = "SNC";
											}
											
										}
//										else if(StringUtils.equals("DELETE", ap.getActionType().toUpperCase())){
//											
//										}
										
									}else {
										
										
										
										if(StringUtils.equals("ADD", ap.getActionType().toUpperCase()) || 
												StringUtils.equals("CHANGE", ap.getActionType().toUpperCase())){
											itemParams = new ItemParamsSP();
											ItemParamsSP[] itemParamList = new ItemParamsSP[2];
											//new
											itemParams.setParam1(ap.getVendorCode());
											itemParams.setParam2(ap.getBankCode());
											itemParams.setParam3(ap.getBankAccNo());
											itemParams.setParam4(ap.getBankAccName());
											itemParamList[0] = itemParams;
											
											itemParams = new ItemParamsSP();
											//old
											itemParams.setParam1(resultGetvenbank.getVendorCode());
											itemParams.setParam2(resultGetvenbank.getBankCode());
											itemParams.setParam3(resultGetvenbank.getBankAccNo());
											itemParams.setParam4(resultGetvenbank.getBankAccName());
											itemParamList[1] = itemParams;
											//call web service change
											result = sapService.chgSapVenBank(itemParamList);
											if(result != null){
												if(StringUtils.equals("E", result.getResultMsg().toUpperCase())){
													addGeneralMessageError(msg("message.error.approvebookbank.incomplete"));
													bookbankAct.setSapMsg(result.getResultMsg());
													bookbankAct.setSapStatus(result.getpRemark());
													actionType = "SE";
												}
											}else{
												addGeneralMessageError(msg("message.error.approvebookbank.incomplete"));
												bookbankAct.setSapMsg(result.getResultMsg());
												bookbankAct.setSapStatus(result.getpRemark());
												actionType = "SNC";
											}
											
										}else if(StringUtils.equals("DELETE", ap.getActionType().toUpperCase())){
											itemParams = new ItemParamsSP();
											itemParams.setParam1(ap.getVendorCode());
											itemParams.setParam2(ap.getBankCode());
											itemParams.setParam3(ap.getBankAccNo());
											itemParams.setParam4(ap.getBankAccName());
											//call web service delete
											result = sapService.delSapVenbank(itemParams);
											if(result != null){
												if(StringUtils.equals("E", result.getResultMsg().toUpperCase())){
													addGeneralMessageError(msg("message.error.approvebookbank.incomplete"));
													bookbankAct.setSapMsg(result.getResultMsg());
													bookbankAct.setSapStatus(result.getpRemark());
													actionType = "SE";
												}
											}else{
												addGeneralMessageError(msg("message.error.approvebookbank.incomplete"));
												bookbankAct.setSapMsg(result.getResultMsg());
												bookbankAct.setSapStatus(result.getpRemark());
												actionType = "SNC";
											}
											
										}
									}
								}
								
//								bookbankAct.setSapMsg("result.sapMsg");
//								bookbankAct.setSapStatus("result.sapStatus");
							}
							
							
							
							
//							//add property ApproveBookBankAct before Save Store
							bookbankAct.setVendorMapPayeeId(ap.getRowId());
							bookbankAct.setRemark(semmct003Bean.getRemark());
							bookbankAct.setActionType(actionType);
							bookbankAct.setUserId(getUserLogIn());
							
							
							to2 = lovMasterService.querySPList(EQueryName.SP_SAP_APPROVE_BOOK_BANK_ACT.name, bookbankAct);
							if(to2 != null && !to2.isEmpty() && to2.get(0).getResultMsg().equals("Success")){
//								addMessageInfo("M0001");
								flag = true;
							}else{
								addMessageError("EL0000", to2.get(0).getpRemark());
							}
						}
						
						
					}
					
				}else{
					to2 = lovMasterService.querySPList(EQueryName.SP_SAP_APPROVE_BOOK_BANK_ACT.name, semmct003Bean.getApproveBookBankAct());
					if(to2 != null && !to2.isEmpty() && to2.get(0).getResultMsg().equals("Success")){
						addMessageInfo("M0001");
					}else{
						addMessageError("EL0000", to2.get(0).getpRemark());
					}
				}
				
//				to = lovMasterService.querySPList(EQueryName.SP_SAP_APPROVE_BOOK_BANK_ACT.name, semmct003Bean.getApproveBookBankAct());
//				addMessageInfo("M0001");
			}else if(to != null && !to.isEmpty()){
				FrontMessageUtils.addMessageError(to.get(0).getpRemark());
			}
			if(flag){
				addMessageInfo("M0001");
			}
			semmct003Bean.setPopupClose(true);
			this.doClearApproveStatus();
			this.doSearchSap();
			this.onRenderSapExportButton();
			setSemmct003Bean(semmct003Bean);
			
		}catch (Exception e) {
			e.printStackTrace();
			LOG.debug("Error SEMMCT003Action doCheckFinanceApprove : "+e);
			addMessageError("EL0000", "SEMMCT003Action");
			// TODO: handle exception
		}
		return flag;
	}
	
	public String doGetBookbankId(List<WrapperBeanObject<ApproveBookBankSP>> approveBookbank){
		String vendorMapPayeeIdConCat = "";
		try{
			for (WrapperBeanObject<ApproveBookBankSP> temp : approveBookbank) {
				ApproveBookBankSP ap = (ApproveBookBankSP)temp.getDataObj();
				
				if(temp.isCheckBox() && vendorMapPayeeIdConCat.equals("")){
					vendorMapPayeeIdConCat = ap.getRowId();
				}
				else if(temp.isCheckBox() && !vendorMapPayeeIdConCat.equals("")){
					vendorMapPayeeIdConCat = vendorMapPayeeIdConCat+",".trim()+ap.getRowId();
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.debug("Error SEMMCT001Action doGetBookbankId : "+e);
		}
		return vendorMapPayeeIdConCat;
	}
	
	private boolean validateSearch() {
		boolean flagValid = true;
		if(StringUtils.isEmpty(getSemmct003Bean().getApproveBookBankSP().getRecordStatus())){
			addMessageError(("W0001"), msg("message.bgStatus"));
			flagValid = false;
		}
		return flagValid;
	}
	
	public boolean doClear(){
		boolean flag = false;
		semmct003Bean = getSemmct003Bean();
		semmct003Bean.setApproveBookBankSP(new ApproveBookBankSP());
		semmct003Bean.setApproveBookBankSPList(new ArrayList());
		semmct003Bean.setDisabledBtnExport(true);
		semmct003Bean.setRenderedMsgDataNotFound(false);
		semmct003Bean.setRenderedApproveBtn(false);
		semmct003Bean.setRenderedCheckBtn(false);
		setSemmct003Bean(semmct003Bean);
		return flag;
	}
	
	public boolean initApprove(){
		boolean flag = false;
		semmct003Bean = getSemmct003Bean();
		String btnApproveStatus = (String)getFacesUtils().getRequestParameter("btnApproveStatus");
		String actionType = getFacesUtils().getRequestParameter("actionType") == null ?  "" : (String)getFacesUtils().getRequestParameter("actionType");
		semmct003Bean.setRemark("");
		semmct003Bean.setActionType(actionType);
		semmct003Bean.setBtnApproveStatus(btnApproveStatus);
		setSemmct003Bean(semmct003Bean);
		return flag;
	}
	
	public boolean doClearApproveStatus(){
		boolean flag = false;
		semmct003Bean = getSemmct003Bean();
		semmct003Bean.setBtnApproveStatus("");
		semmct003Bean.setRemark("");
		setSemmct003Bean(semmct003Bean);
		return flag;
	}
	
	public void selectAllRow(){
		try{
			boolean chkAll = getSemmct003Bean().isChkSelAll();
			List<WrapperBeanObject<ApproveBookBankSP>> detailList = new ArrayList<WrapperBeanObject<ApproveBookBankSP>>();
			detailList = getSemmct003Bean().getApproveBookBankSPList();
			for(int i=0; i<detailList.size(); i++){
				ApproveBookBankSP ap = (ApproveBookBankSP)detailList.get(i).getDataObj();
				if(ap.isRenderedCheckBox() == true){
					detailList.get(i).setCheckBox(chkAll);
				}else{
					detailList.get(i).setCheckBox(false);
				}
				
			}
			onRenderExportButton();
		}catch(NullPointerException ne){
			// TODO
			
		}catch(Exception e){
			//TODO
			
		}
	}
	
	public void onRenderExportButton(){
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
//		String status = (String)getFacesUtils().getRequestParameter("status") == null ? "" : (String)getFacesUtils().getRequestParameter("status");
		getSemmct003Bean().setTmpRowId(rowId);
		
		isCheckSELBox();
	}
	
	private boolean isCheckSELBox(){
		boolean isCheck = false;
		boolean disabledBtnCheckerAndReject = true;
		boolean disabledBtnApproveAndReject = true;
		boolean disabledExportVendorBtn = true;
		String tmpDisabledExportVendorBtn = "VENDOR BOOKBANK";
		List<WrapperBeanObject<ApproveBookBankSP>> approveBookBankSearchSP = getSemmct003Bean().getApproveBookBankSPList();
		for (WrapperBeanObject<ApproveBookBankSP> wrapperBeanObject : approveBookBankSearchSP) {
			ApproveBookBankSP o = (ApproveBookBankSP)wrapperBeanObject.getDataObj();
			if(wrapperBeanObject.isCheckBox()){
//				isCheckBtnApproveAndReject = false;
				//for  button reject and approve
//				getSemmct003Bean().setDisabledBtnApproveAndReject(false);
//				if(StringUtils.equals(o.getExportFlag(), "Y"))
				isCheck = true;
//				else{
//				return isCheck = false;
//				}
				
				if(o.getRecordStatus() != null){
					if("03".equals(o.getRecordStatus())){
						disabledBtnCheckerAndReject = false;
					}
					if("04".equals(o.getRecordStatus())){
						disabledBtnApproveAndReject = false;
					}
				}
				
				if(!"VENDOR BOOKBANK".equals(o.getPayeeTypeDesc().toUpperCase())){
					tmpDisabledExportVendorBtn = o.getPayeeTypeDesc().toUpperCase();
				}
				
				if(!"VENDOR BOOKBANK".equals(tmpDisabledExportVendorBtn.toUpperCase())){
					disabledExportVendorBtn = true;
				}else{
					disabledExportVendorBtn = false;
				}
			}
		}
		getSemmct003Bean().setDisabledBtnCheckerAndReject(disabledBtnCheckerAndReject);
		getSemmct003Bean().setDisabledBtnApproveAndReject(disabledBtnApproveAndReject);
		getSemmct003Bean().setDisabledExportVendorBtn(disabledExportVendorBtn);
		
		return isCheck;
	}
	
	public void getRowIdOnClick() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemmct003Bean().setTmpRowId(rowId);
	}
	
	public void doExportExcel(){
		
		try{
			EnumDocStyleDomain headerStyle = new EnumDocStyleDomain(EnumDocStyle.HEADER);
			RowDomain rowD = new RowDomain(0);
			rowD.setCell(new CellDomain(0, null, String.class, headerStyle, "Action"));
			rowD.setCell(new CellDomain(1, null, String.class, headerStyle, "Reason Mod"));
			rowD.setCell(new CellDomain(2, null, String.class, headerStyle, "Company Code"));
			rowD.setCell(new CellDomain(3, null, String.class, headerStyle, "Copy Company Code"));
			rowD.setCell(new CellDomain(4, null, String.class, headerStyle, "Account Group"));
			rowD.setCell(new CellDomain(5, null, String.class, headerStyle, "SAP Vendor Account Number"));
			rowD.setCell(new CellDomain(6, null, String.class, headerStyle, "Name1"));
			rowD.setCell(new CellDomain(7, null, String.class, headerStyle, "Name2"));
			rowD.setCell(new CellDomain(8, null, String.class, headerStyle, "Name3"));
			rowD.setCell(new CellDomain(9, null, String.class, headerStyle, "Name4"));
			
			rowD.setCell(new CellDomain(10,null, String.class, headerStyle, "Street"));
			rowD.setCell(new CellDomain(11, null, String.class, headerStyle, "District"));
			rowD.setCell(new CellDomain(12, null, String.class, headerStyle, "City"));
			rowD.setCell(new CellDomain(13, null, String.class, headerStyle, "Postal Code"));
			rowD.setCell(new CellDomain(14, null, String.class, headerStyle, "Country"));
			rowD.setCell(new CellDomain(15, null, String.class, headerStyle, "Search Term"));
			rowD.setCell(new CellDomain(16, null, String.class, headerStyle, "Tel1"));
			rowD.setCell(new CellDomain(17, null, String.class, headerStyle, "Tel2"));
			rowD.setCell(new CellDomain(18, null, String.class, headerStyle, "Mobile Phone"));
			rowD.setCell(new CellDomain(19, null, String.class, headerStyle, "Fax"));
			
			rowD.setCell(new CellDomain(20, null, String.class, headerStyle, "Email"));
			rowD.setCell(new CellDomain(21, null, String.class, headerStyle, "Data Communication Line No."));
			rowD.setCell(new CellDomain(22, null, String.class, headerStyle, "Telebox number"));
			rowD.setCell(new CellDomain(23, null, String.class, headerStyle, "Comment"));
			rowD.setCell(new CellDomain(24, null, String.class, headerStyle, "Trading partner"));
			rowD.setCell(new CellDomain(25, null, String.class, headerStyle, "Customer code"));
			rowD.setCell(new CellDomain(26, null, String.class, headerStyle, "Personnel ID"));
			rowD.setCell(new CellDomain(27, null, String.class, headerStyle, "Tax ID"));
			rowD.setCell(new CellDomain(28, null, String.class, headerStyle, "Industry Key"));
			rowD.setCell(new CellDomain(29, null, String.class, headerStyle, "Purchasing Org."));
			
			rowD.setCell(new CellDomain(30, null, String.class, headerStyle, "Copy Purchasing Org."));
			rowD.setCell(new CellDomain(31, null, String.class, headerStyle, "Order currency"));
			rowD.setCell(new CellDomain(32, null, String.class, headerStyle, "Payment Term"));
			rowD.setCell(new CellDomain(33, null, String.class, headerStyle, "Goods receipt before Invoice(SSA)"));
			rowD.setCell(new CellDomain(34, null, String.class, headerStyle, "Recon. Acct."));
			rowD.setCell(new CellDomain(35, null, String.class, headerStyle, "Previous Account"));
			rowD.setCell(new CellDomain(36, null, String.class, headerStyle, "Payment Term"));
			rowD.setCell(new CellDomain(37, null, String.class, headerStyle, "Payment Method"));
			rowD.setCell(new CellDomain(38, null, String.class, headerStyle, "Payment Block"));
			rowD.setCell(new CellDomain(39, null, String.class, headerStyle, "Withholding Tax Type"));
			
			rowD.setCell(new CellDomain(40, null, String.class, headerStyle, "Withholding Code"));
			rowD.setCell(new CellDomain(41, null, String.class, headerStyle, "Recipient Type"));
			rowD.setCell(new CellDomain(42, null, String.class, headerStyle, "Withholding Tax type2"));
			rowD.setCell(new CellDomain(43, null, String.class, headerStyle, "Withholding  Code2"));
			rowD.setCell(new CellDomain(44, null, String.class, headerStyle, "Recipient Type2"));
			rowD.setCell(new CellDomain(45, null, String.class, headerStyle, "Withholding Tax Type3"));
			rowD.setCell(new CellDomain(46, null, String.class, headerStyle, "Withholding  Code3"));
			rowD.setCell(new CellDomain(47, null, String.class, headerStyle, "Recipient Type3"));
			rowD.setCell(new CellDomain(48, null, String.class, headerStyle, "Bank Key"));
			rowD.setCell(new CellDomain(49, null, String.class, headerStyle, "Name of Bank"));
			
			rowD.setCell(new CellDomain(50, null, String.class, headerStyle, "Bank Account"));
			rowD.setCell(new CellDomain(51, null, String.class, headerStyle, "Account Hoder"));
			rowD.setCell(new CellDomain(52, null, String.class, headerStyle, "Partner Bank Type"));
			rowD.setCell(new CellDomain(53, null, String.class, headerStyle, "Alternative Payee"));
			
			/***********************************************/
			short line = 0;
			//PDocumentManager export to excel
			DocumentExportManager<CT001Export> docManager =
				new DocumentExportManager<CT001Export>(CT001Export.class, EnumDocumentType.XLS);
			// set current configuration of work book.	
				docManager.setRowStart(line);
			/***********************************************/
			
			int no = 1;
			
			List<CT001Export> l = queryCT001Export();
			/*if(l != null && l.size() > 0){
				for (CT001Export o : l) {
					int nNo = no++;
					LOG.info("no =" + nNo);
					o.setNo(nNo);
				}
			}*/
			docManager.setListHeader(rowD);
			docManager.seteObjectList(l);
			docManager.setModule("VENDOR_MASTER");
			docManager.getObjectFromDocument();
			docManager.exportServletFile();
			
		}catch(Exception e){}
	}
	
	private List<CT001Export> queryCT001Export() throws Exception{
		IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
		return service.queryCT001ForExport(getVendorSelected());
	}
	
	private String getVendorSelected(){
		
		List<WrapperBeanObject<ApproveBookBankSP>> bookBankSPList =  getSemmct003Bean().getApproveBookBankSPList();
		String strBuff = "";
		StringBuffer b = new StringBuffer();
		if(bookBankSPList != null && !bookBankSPList.isEmpty()){
			for (WrapperBeanObject<ApproveBookBankSP> wrapperBeanObject : bookBankSPList) {
				if(wrapperBeanObject.isCheckBox()){
				  ApproveBookBankSP o = (ApproveBookBankSP)wrapperBeanObject.getDataObj();
				  if(StringUtils.isNotBlank(o.getVendorMasterId())){
				  b.append(",");
				  b.append(o.getVendorMasterId());
				  }
				}
			}
			if(b != null)
			strBuff = b.toString();
		}
		strBuff = strBuff.replaceFirst(",", "");
		LOG.info("vendor selected =" + strBuff);
		return strBuff;
	}
	
	//added by NEW 20151110
	private boolean initExportVendorBookbankToLeader() {
		SEMMCT003Bean ct001Bean = getSemmct003Bean();
		ct001Bean.setDisplayReport(false);
		ct001Bean.setCt001ExBankList(new ArrayList<CT001ExportBank>());
		
		try{
			//to get VendorMasterId
			String vendorSelected = getVendorMapPayeeSelected();
			IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
			CT001ExportBank ct001ExportBank = new CT001ExportBank();
//			ct001ExportBank.setVendorMasterId(vendorSelected);
			ct001ExportBank.setVendorMapPayeeId(vendorSelected);
			List<CT001ExportBank> exBankList = service.querySPList(EQueryName.SP_CT001_EX_VENDOR_BOOKBANK_TO_LEADER.name, ct001ExportBank);
			if(exBankList != null && !exBankList.isEmpty()){
				if(exBankList.get(0).getResult() == null || "".equals(exBankList.get(0).getResult())){
//					ct001Bean.setTmpBatch(exBankList.get(0).getBatchNo());
//					ct001Bean.setTmpBatchDT(exBankList.get(0).getBatchDT());
					ct001Bean.setTmpBatch(exBankList.get(0).getBatchNo());
					ct001Bean.setTmpBatchDT(exBankList.get(0).getBatchDT());
					if(exBankList.get(0).getStatus() != null){
						ct001Bean.setStatus(exBankList.get(0).getStatus());
					}
					ct001Bean.setDisplayReport(true);
				}else{
					
					ct001Bean.setDisplayReport(false);
					ct001Bean.setRenderedMsgFormSearch(true);
					FrontMessageUtils.addMessageError(exBankList.get(0).getResult());
				}
			}else{
				ct001Bean.setDisplayReport(false);

				ct001Bean.setRenderedMsgFormSearch(true);
				FrontMessageUtils.addMessageError("ไม่พบข้อมูล");
			}
			ct001Bean.setCt001ExBankList(exBankList);
//			ct001Bean.setDisplayReport(true);
		}catch (Exception e) {
			ct001Bean.setDisplayReport(false);
		}
		
		return false;
	}
	
	public void doExportVendorBookbankToLeader(){
		SEMMCT003Bean ct001Bean = getSemmct003Bean();
		ct001Bean.setDisplayReport(false);
		
		short line = 0;
		DocumentExportManager<CT001ExportBank> docManager = new DocumentExportManager<CT001ExportBank>(CT001ExportBank.class, EnumDocumentType.XLS);
		docManager.setRowStart(line);
		/***********************************************/
		EnumDocStyleDomain headerStyle = new EnumDocStyleDomain(EnumDocStyle.HEADER);
		EnumDocStyleDomain normalLeft =  docManager.getStyle("ct001Field");
		EnumDocStyleDomain normalHeader =  new EnumDocStyleDomain(EnumDocStyle.CELL_NORMAL_BIG_FONT_CENTER);
		EnumDocStyleDomain normalCenter =  docManager.getStyle("si002Field");
		EnumDocStyleDomain	titleStyle	= new EnumDocStyleDomain(EnumDocStyle.TITLE);
		DateFormat df =  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		try{
		
			int rowNum = 3;
			String bankSum = "";
			int rowCount = 1;
			if(ct001Bean.getCt001ExBankList()!=null&&ct001Bean.getCt001ExBankList().size()>0){
				RowDomain row0 = new RowDomain(0,true);	
				row0.setCell(new CellDomain(0,9, null, String.class, titleStyle, msg("export.header.submitDetail")+" "+df.format(SEMDataUtility.convertToThYear(ct001Bean.getTmpBatchDT())),null));
				
				RowDomain row1 = new RowDomain(1,true);	
				row1.setCell(new CellDomain(0,9, null, String.class, titleStyle, msg("export.col.paymentBatchNo")+ct001Bean.getTmpBatch()+"   Status : "+ct001Bean.getStatus(),null));
				docManager.putDetailRow(row0);
				docManager.putDetailRow(row1);
				for(CT001ExportBank expBank : ct001Bean.getCt001ExBankList()){
					if(!StringUtils.equalsIgnoreCase(bankSum, expBank.getBankSum())){
						
						if(StringUtils.isEmpty(bankSum)&&StringUtils.isNotEmpty(expBank.getBankSum())){
							rowCount = 1;
							RowDomain rowFirstH = new RowDomain(rowNum++);
							rowFirstH.setCell(new CellDomain(0,3, null, String.class, normalHeader, expBank.getBankSum(),-1,10000));
							RowDomain rowH = new RowDomain(rowNum++);
							rowH.setCell(new CellDomain(0, null, String.class, headerStyle, "NO",-1,700));
							rowH.setCell(new CellDomain(1, null, String.class, headerStyle, "BU",-1,1200));
							rowH.setCell(new CellDomain(2, null, String.class, headerStyle, "VENDOR",-1,3000));
							rowH.setCell(new CellDomain(3, null, String.class, headerStyle, "SUPLIER NAME",-1,6000));
							rowH.setCell(new CellDomain(4, null, String.class, headerStyle, "BANK BR.",-1,2500));
							rowH.setCell(new CellDomain(5, null, String.class, headerStyle, "A/C.NO",-1,2800));
							rowH.setCell(new CellDomain(6, null, String.class, headerStyle, "NAME BANK",-1,9500));
							rowH.setCell(new CellDomain(7, null, String.class, headerStyle, "NAME ACC.",-1,6000));
							rowH.setCell(new CellDomain(8, null, String.class, headerStyle, msg("export.col.remarkTh"),-1,4000));
							rowH.setCell(new CellDomain(9, null, String.class, normalHeader, null,-1,1200));
							
							docManager.putDetailRow(rowFirstH);
							docManager.putDetailRow(rowH);
						}else{
								rowCount = 1;
								RowDomain rowBlank1 = new RowDomain(rowNum++);
								rowBlank1.setCell(new CellDomain(0,8,null, String.class, normalHeader, null,-1,46000));
								docManager.putDetailRow(rowBlank1);
								RowDomain rowBlank2 = new RowDomain(rowNum++);
								rowBlank2.setCell(new CellDomain(0,8, null, String.class, normalHeader, null,-1,46000));
								RowDomain rowFirstH = new RowDomain(rowNum++);
								docManager.putDetailRow(rowBlank2);
								rowFirstH.setCell(new CellDomain(0,3, null, String.class, normalHeader, expBank.getBankSum(),-1,10000));
								docManager.putDetailRow(rowFirstH);
								RowDomain rowH = new RowDomain(rowNum++);
								rowH.setCell(new CellDomain(0, null, String.class, headerStyle, "NO",-1,700));
								rowH.setCell(new CellDomain(1, null, String.class, headerStyle, "BU",-1,1200));
								rowH.setCell(new CellDomain(2, null, String.class, headerStyle, "VENDOR",-1,3000));
								rowH.setCell(new CellDomain(3, null, String.class, headerStyle, "SUPLIER NAME",-1,6000));
								rowH.setCell(new CellDomain(4, null, String.class, headerStyle, "BANK BR.",-1,2500));
								rowH.setCell(new CellDomain(5, null, String.class, headerStyle, "A/C.NO",-1,2800));
								rowH.setCell(new CellDomain(6, null, String.class, headerStyle, "NAME BANK",-1,9500));
								rowH.setCell(new CellDomain(7, null, String.class, headerStyle, "NAME ACC.",-1,6000));
								rowH.setCell(new CellDomain(8, null, String.class, headerStyle, msg("export.col.remarkTh"),-1,4000));
								rowH.setCell(new CellDomain(9, null, String.class, normalHeader, null,-1,1200));
								docManager.putDetailRow(rowH);
						}
						
					}
								RowDomain rowD = new RowDomain(rowNum++);
								rowD.setCell(new CellDomain(0, null, String.class, normalCenter, rowCount,-1,700));
								rowD.setCell(new CellDomain(1, null, String.class, normalCenter, expBank.getCompany(),-1,1200));
								rowD.setCell(new CellDomain(2, null, String.class, normalCenter, expBank.getVendorCode(),-1,3000));
								rowD.setCell(new CellDomain(3, null, String.class, normalLeft, expBank.getVendorName(),-1,6000));
								rowD.setCell(new CellDomain(4, null, String.class, normalCenter, expBank.getBookBankCode(),-1,2500));
								rowD.setCell(new CellDomain(5, null, String.class, normalCenter, expBank.getBankAccNo(),-1,2800));
								rowD.setCell(new CellDomain(6, null, String.class, normalLeft, expBank.getBankName(),-1,9500));
								rowD.setCell(new CellDomain(7, null, String.class, normalLeft, expBank.getBankAccName(),-1,6000));
								rowD.setCell(new CellDomain(8, null, String.class, normalLeft, expBank.getRemark(),-1,4000));
								rowD.setCell(new CellDomain(9, null, String.class, normalHeader, null,-1,1200));
								docManager.putDetailRow(rowD);
								rowCount++;
								bankSum = expBank.getBankSum();
				}
				docManager.seteObjectList(null);
				docManager.setModule("VENDOR_BOOKBANK");
				docManager.setPrintPageLandScape(true);
				docManager.setMargin(0.05, 0.05, 0.5, 0.05);
				docManager.getObjectFromDocument();
				docManager.exportServletFile();
			}
//			else{
//				
//				RowDomain row0 = new RowDomain(0,true);	
//				row0.setCell(new CellDomain(0,9, null, String.class, titleStyle, msg("export.header.submitDetail"),null));
//				
//				RowDomain row1 = new RowDomain(1,true);	
//				row1.setCell(new CellDomain(0,9, null, String.class, titleStyle, msg("export.col.paymentBatchNo"),null));
//				docManager.putDetailRow(row0);
//				docManager.putDetailRow(row1);
//				
//				RowDomain rowH = new RowDomain(3);
//				rowH.setCell(new CellDomain(0, null, String.class, headerStyle, "NO",-1,700));
//				rowH.setCell(new CellDomain(1, null, String.class, headerStyle, "BU",-1,1200));
//				rowH.setCell(new CellDomain(2, null, String.class, headerStyle, "VENDOR",-1,3000));
//				rowH.setCell(new CellDomain(3, null, String.class, headerStyle, "SUPLIER NAME",-1,6000));
//				rowH.setCell(new CellDomain(4, null, String.class, headerStyle, "BANK BR.",-1,2500));
//				rowH.setCell(new CellDomain(5, null, String.class, headerStyle, "A/C.NO",-1,2800));
//				rowH.setCell(new CellDomain(6, null, String.class, headerStyle, "NAME BANK",-1,9500));
//				rowH.setCell(new CellDomain(7, null, String.class, headerStyle, "NAME ACC.",-1,6000));
//				rowH.setCell(new CellDomain(8, null, String.class, headerStyle, msg("export.col.remarkTh"),-1,4000));
//				rowH.setCell(new CellDomain(9, null, String.class, normalHeader, null,-1,1200));
//				docManager.putDetailRow(rowH);
//			}
//			docManager.seteObjectList(null);
//			docManager.setModule("VENDOR_BOOKBANK");
//			docManager.setPrintPageLandScape(true);
//			docManager.setMargin(0.05, 0.05, 0.5, 0.05);
//			docManager.getObjectFromDocument();
//			docManager.exportServletFile();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String getVendorMapPayeeSelected(){
		List<WrapperBeanObject<ApproveBookBankSP>> vendorMasterList = getSemmct003Bean().getApproveBookBankSPList();
		String strBuff = "";
		StringBuffer b = new StringBuffer();
		for (WrapperBeanObject<ApproveBookBankSP> wrapperBeanObject : vendorMasterList) {
			if(wrapperBeanObject.isCheckBox()){
				ApproveBookBankSP o = (ApproveBookBankSP)wrapperBeanObject.getDataObj();
				b.append(",");
				b.append(o.getVendorMappayeeId());
			}
		}
//		if(vendorMasterList != null && !vendorMasterList.isEmpty()){
//			for (WrapperBeanObject<VendorMasterSP> wrapperBeanObject : vendorMasterList) {
//				String navPrograme = getNavPrograme();
//				if(StringUtils.equals(navPrograme, "semmct001-1")){
//					if(wrapperBeanObject.isCheckBox()){
//					  VendorMasterSP o = (VendorMasterSP)wrapperBeanObject.getDataObj();
//					  b.append(",");
//					  b.append(o.getVendorMapPayeeId());
//					}
//				}else if(StringUtils.equals(navPrograme, "semmct001-2")){
//					
//					String vendorMasterSel = getSemmct001Bean().getVendorMaster().getRowId();
//					b.append(",");
//					b.append(vendorMasterSel);
//					break;
//				}
//				
//			}
//		}else{
//			String vendorMasterSel = getSemmct001Bean().getVendorMaster().getRowId();
//			b.append(",");
//			b.append(vendorMasterSel);
//		}
		
		if(b != null)
		strBuff = b.toString();
		strBuff = strBuff.replaceFirst(",", "");
		LOG.info("vedorMaster selected =" + strBuff);
		return strBuff;
	}
	
	public void selectSapAllRow(){
		try{
			boolean chkAll = getSemmct003Bean().isChkSelAll();
			List<WrapperBeanObject<ApproveBookBankSP>> detailList = new ArrayList<WrapperBeanObject<ApproveBookBankSP>>();
			detailList = getSemmct003Bean().getApproveBookBankSPList();
			for(int i=0; i<detailList.size(); i++){
				ApproveBookBankSP ap = (ApproveBookBankSP)detailList.get(i).getDataObj();
				if(ap.isRenderedCheckBox() == true){
					detailList.get(i).setCheckBox(chkAll);
				}else{
					detailList.get(i).setCheckBox(false);
				}
				
			}
			onRenderSapExportButton();
		}catch(NullPointerException ne){
			// TODO
			
		}catch(Exception e){
			//TODO
			
		}
	}
	
	public void onRenderSapExportButton(){
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
//		String status = (String)getFacesUtils().getRequestParameter("status") == null ? "" : (String)getFacesUtils().getRequestParameter("status");
		getSemmct003Bean().setTmpRowId(rowId);
		
		isCheckSapSELBox();
	}
	
	private boolean isCheckSapSELBox(){
		boolean isCheck = false;
		boolean disabledBtnCheckerAndReject = true;
		boolean disabledBtnApproveAndReject = true;
		boolean disabledExportVendorBtn = true;
		String tmpDisabledExportVendorBtn = "VENDOR BOOKBANK";
		List<WrapperBeanObject<ApproveBookBankSP>> approveBookBankSearchSP = getSemmct003Bean().getApproveBookBankSPList();
		for (WrapperBeanObject<ApproveBookBankSP> wrapperBeanObject : approveBookBankSearchSP) {
			ApproveBookBankSP o = (ApproveBookBankSP)wrapperBeanObject.getDataObj();
			if(wrapperBeanObject.isCheckBox()){
//				isCheckBtnApproveAndReject = false;
				//for  button reject and approve
//				getSemmct003Bean().setDisabledBtnApproveAndReject(false);
//				if(StringUtils.equals(o.getExportFlag(), "Y"))
				isCheck = true;
//				else{
//				return isCheck = false;
//				}
				
//				if(o.getRecordStatus() != null){
//					if("03".equals(o.getRecordStatus())){
						disabledBtnCheckerAndReject = false;
//					}
//					if("04".equals(o.getRecordStatus())){
						disabledBtnApproveAndReject = false;
//					}
//				}
				
//				if(!"VENDOR BOOKBANK".equals(o.getPayeeTypeDesc().toUpperCase())){
//					tmpDisabledExportVendorBtn = o.getPayeeTypeDesc().toUpperCase();
//				}
//				
//				if(!"VENDOR BOOKBANK".equals(tmpDisabledExportVendorBtn.toUpperCase())){
//					disabledExportVendorBtn = true;
//				}else{
//					disabledExportVendorBtn = false;
//				}
			}
		}
		getSemmct003Bean().setDisabledBtnCheckerAndReject(disabledBtnCheckerAndReject);
		getSemmct003Bean().setDisabledBtnApproveAndReject(disabledBtnApproveAndReject);
		getSemmct003Bean().setDisabledExportVendorBtn(disabledExportVendorBtn);
		
		return isCheck;
	}
	
	public void doTest() {
		LOG.info("::: SEMMCT003Action :: doTest >> BEGIN :::");
		
		try{
			
			semmct003Bean = getSemmct003Bean();
			
			ItemParamsSP itemParams = new ItemParamsSP();
		
			WsClientService sapService = new WsClientService();
			sapService.masterBank(itemParams);
		
			setSemmct003Bean(semmct003Bean);
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			LOG.debug(e);
			addMessageError("EL0000", "SEMMCT003Action");
		} finally {
			LOG.info("::: SEMMCT003Action :: doTest >> END :::");
		}
	}
	
}
