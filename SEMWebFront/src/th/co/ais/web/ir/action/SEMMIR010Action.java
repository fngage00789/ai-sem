package th.co.ais.web.ir.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.CellStyle;
//import org.hsqldb.lib.StringUtil;

import sun.util.logging.resources.logging;
import th.co.ais.domain.el.BgMaster;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.ManagementWrapper;
import th.co.ais.domain.el.Mel008ExpLetter;
import th.co.ais.domain.el.Payment;
import th.co.ais.domain.el.PaymentWrapper;
import th.co.ais.domain.el.VendorMapPayeeEL;
import th.co.ais.domain.gm.CT001SrchMSP;
import th.co.ais.domain.gm.VendorBookbank;
import th.co.ais.domain.gm.VendorMapPayee;
import th.co.ais.domain.gm.VendorMaster;
import th.co.ais.domain.gm.VendorMasterSP;
import th.co.ais.domain.ir.ExGenerateDraftSP;
import th.co.ais.domain.ir.InsurancePayActSP;
import th.co.ais.domain.ir.InsurancePayEditSaveSP;
import th.co.ais.domain.ir.InsurancePayment;
import th.co.ais.domain.ir.IrClaim;
import th.co.ais.domain.ir.MirGetRunningNo;
import th.co.ais.domain.ir.Policy;
import th.co.ais.domain.ir.PolicySP;
import th.co.ais.domain.pt.Mpt003ExpLetter;
import th.co.ais.domain.rt.CheckVendor;
import th.co.ais.domain.rt.EMAILModel;
import th.co.ais.domain.rt.Mrt003ChkVendorMulti;
import th.co.ais.domain.rt.RentalPayNormalEditSaveSP;
import th.co.ais.domain.rt.RentalPayNormalSearchDSP;
import th.co.ais.domain.rt.RentalPayNormalSearchSP;
import th.co.ais.domain.rt.RentalPayment;
import th.co.ais.domain.rt.SMSModel;
import th.co.ais.rpt.util.bean.CellDomain;
import th.co.ais.rpt.util.bean.EnumDocStyleDomain;
import th.co.ais.rpt.util.bean.RowDomain;
import th.co.ais.rpt.util.enums.EnumDocStyle;
import th.co.ais.rpt.util.enums.EnumDocumentType;
import th.co.ais.service.el.IPaymentService;
import th.co.ais.service.el.IVendorMapPayeeELService;
import th.co.ais.service.gm.ILovMasterService;
import th.co.ais.service.gm.IVendorBookbankService;
import th.co.ais.service.gm.IVendorMasterService;
import th.co.ais.service.ir.IGenerateDraft;
import th.co.ais.service.ir.IInsurancePaymentService;
import th.co.ais.service.ir.IInsuredService;
import th.co.ais.service.ir.IIrClaimService;
import th.co.ais.service.pt.IPTaxMasterService;
import th.co.ais.service.rt.IRentalPaymentService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EParamName;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.common.PopupUploadFilePictureBean;
import th.co.ais.web.el.bean.SEMMEL001Bean;
import th.co.ais.web.el.bean.SEMMEL008Bean;
import th.co.ais.web.ir.bean.FileUploadBean;
import th.co.ais.web.ir.bean.SEMMIR001Bean;
import th.co.ais.web.ir.bean.SEMMIR010Bean;
import th.co.ais.web.ir.bean.SEMMIRPopupBean;
import th.co.ais.web.pt.bean.SEMMPT004Bean;
import th.co.ais.web.report.util.DocumentExportManager;
import th.co.ais.web.util.ELUtils;
import th.co.ais.web.util.EmailMessageUtil;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.LOVCacheUtil;
import th.co.ais.web.util.MSGCacheUtil;
import th.co.ais.web.util.ParameterCacheUtil;
import th.co.ais.web.util.SemUtils;
import th.co.ais.web.util.SmsClient;
import th.co.ais.web.util.WebUtil;
import th.co.ais.web.util.config.ParameterConfigUtil;


public class SEMMIR010Action extends AbstractAction {
	
	private Logger log = Logger.getLogger(getClass());
	
	private SEMMIR010Bean semmir010Bean;
	private SEMMIR001Bean semmir001Bean;
	boolean chkSrch = true;
	
	public SEMMIR010Bean getSemmir010Bean() {
		SEMMIR010Bean semmir010Bean = (SEMMIR010Bean)getFacesUtils().getSessionMapValue("semmir010Bean");
		if(semmir010Bean == null)
			semmir010Bean = new SEMMIR010Bean();
		return semmir010Bean;
	}
	
	public void setSemmir001Bean(SEMMIR001Bean semmir001Bean) {
		this.semmir001Bean = semmir001Bean;
		getFacesUtils().setSessionMapValue("semmir001Bean", semmir001Bean);
	}
	
	public SEMMIR001Bean getSemmir001Bean() {
		SEMMIR001Bean semmir001Bean = (SEMMIR001Bean)getFacesUtils().getSessionMapValue("semmir001Bean");
		if(semmir001Bean == null)
			semmir001Bean = new SEMMIR001Bean();
		return semmir001Bean;
	}
	
	public void setSemmir010Bean(SEMMIR010Bean semmir010Bean) {
		this.semmir010Bean = semmir010Bean;
		getFacesUtils().setSessionMapValue("semmir010Bean", semmir010Bean);
	}
	
	private PopupUploadFilePictureBean popupUploadFilePictureBean;

	public void setPopupUploadFilePictureBean(PopupUploadFilePictureBean popupUploadFilePictureBean) {
		this.popupUploadFilePictureBean = popupUploadFilePictureBean;
		getFacesUtils().setSessionMapValue("popupUploadFilePictureBean", popupUploadFilePictureBean);
	}
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if(methodWithNavi.equalsIgnoreCase("doSearch")){
			flag = doSearch();
		}else if(methodWithNavi.equalsIgnoreCase("doClear")){
			flag = doClear();
		}else if(methodWithNavi.equalsIgnoreCase("doSaveAct")){
			flag = doSaveAct();
		}else if(methodWithNavi.equalsIgnoreCase("initApprove")){
			flag = initApprove();
		}else if(methodWithNavi.equalsIgnoreCase("doClearApproveStatus")){
			flag = doClearApproveStatus();
		}else if (methodWithNavi.equalsIgnoreCase("onRenderMsgExoprt")) {
			flag = onRenderMsgExoprt();
		}else if (methodWithNavi.equalsIgnoreCase("onRenderMsgErrorExoprt")) {
			flag = onRenderMsgErrorExoprt();
		}else if (methodWithNavi.equalsIgnoreCase("initCoppyDate")) {
			flag = initCoppyDate();
		}else if (methodWithNavi.equalsIgnoreCase("doCoppyDate")) {
			flag = doCoppyDate();
		}else if (methodWithNavi.equalsIgnoreCase("initEdit")) {
			flag = initEdit();
		}else if (methodWithNavi.equalsIgnoreCase("doSaveEdt")) {
			flag = doSaveEdt();
		}else if (methodWithNavi.equalsIgnoreCase("doGetVendorMaster")) {
			flag = doGetVendorMaster();
		}else if (methodWithNavi.equalsIgnoreCase("doBack")) {
			flag = true;
		}else if (methodWithNavi.equalsIgnoreCase("doBackPage")) {
			flag = doBackPage();
		}else if (methodWithNavi.equalsIgnoreCase("doSaveVendorMapPayee")) {
			flag = doSaveVendorMapPayee();
		}else if (methodWithNavi.equalsIgnoreCase("doSearchVendor")) {
			flag = doSearchVendor();
		}else if (methodWithNavi.equalsIgnoreCase("doSelectVendorMaster")) {
			flag = doSelectVendorMaster();
		}else if(methodWithNavi.equalsIgnoreCase("doInitialForSearchInsurance")){
			flag = doInitialForSearchInsurance();
		}else if(methodWithNavi.equalsIgnoreCase("doSendSMS")){
			flag = doSendSMS();
		}else if(methodWithNavi.equalsIgnoreCase("doSendEmail")){
			flag = doSendEmail();
		}else if(methodWithNavi.equalsIgnoreCase("doExportLetter")){
			flag = doExportLetter();
		}
		
		
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		SEMMIR010Bean semmir010Bean = getSemmir010Bean();
//		semmir010Bean.setInsurancePaymentSP(new InsurancePaymentSP());
//		semmir010Bean.setInsurancePaymentSPList(new ArrayList<WrapperBeanObject<InsurancePaymentSP>>());
		semmir010Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmir010Bean.setNetworkTypeList(getLovItemsByType(ELovType.T_IR_NETWORK_TYPES.name));
		semmir010Bean.setTransferTypeList(getLovItemsByType(ELovType.T_IR_TRANSFER_TYPES.name));
		semmir010Bean.setPolicyTypeList(getLovItemsByType(ELovType.T_IR_POLICY_TYPE.name));
		semmir010Bean.setDocTypeList(getLovItemsByType(ELovType.T_IR_DOC_TYPE.name));
		semmir010Bean.setPaymentStatusList(getLovItemsByType(ELovType.T_CT_PAYMENT_STATUS.name));
		semmir010Bean.setPayTypeList(getLovItemsByType(ELovType.T_IR_PAY_TYPE.name));
		semmir010Bean.setPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name));
		semmir010Bean.setPaymentTypeList(getLovItemsByType(ELovType.T_CT_PAYMENT_TYPE.name));
		semmir010Bean.setDisabledBtnExport(true);
		semmir010Bean.setRenderedBtnA4JExport(false);
		semmir010Bean.setRenderedBtnHExport(true);
		semmir010Bean.setPolicySP(new PolicySP());
		semmir010Bean.setPolicySPList(new ArrayList<WrapperBeanObject<PolicySP>>());
		semmir010Bean.setInsurancePayActSP(new InsurancePayActSP());
		semmir010Bean.setMirGetRunningNo(new MirGetRunningNo());
		semmir010Bean.setPopupPolicySP(new PolicySP());
		semmir010Bean.setInsurancePayEditSaveSP(new InsurancePayEditSaveSP());
		semmir010Bean.setChkSelAll(false);
		semmir010Bean.setVendorMasterSPList(new ArrayList<VendorMasterSP>());
		
		PopupUploadFilePictureBean uploadBean = new PopupUploadFilePictureBean();
		uploadBean.setModuleList(new ArrayList<SelectItem>());
		uploadBean.setSubModuleList(new ArrayList<SelectItem>());
		setPopupUploadFilePictureBean(uploadBean);
		setSemmir010Bean(semmir010Bean);
		
	}
	
	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean doSearch(){
		boolean flag = false;
		semmir010Bean = getSemmir010Bean();
		IInsuredService insuredService = (IInsuredService)getBean("insuredService");
		semmir010Bean.setPolicySPList(new ArrayList<WrapperBeanObject<PolicySP>>());
//		List<InsurancePaymentSP> to = null;
		List<PolicySP> to = null;
		
		// fixed by.. YUT 2014/09/16
		semmir010Bean.getPolicySP().setRcptPayFlag((semmir010Bean.getPolicySP().isChkRcptPay()) ? "Y" : "N");
		
		//added by NEW 2019/01/10
		semmir010Bean.getPolicySP().setPayFlag(semmir010Bean.isPayFlag() ? "Y" : "N");
		semmir010Bean.getPolicySP().setUserId(getUserLogIn());
		log.debug("getPayFlag : "+semmir010Bean.getPolicySP().getPayFlag());
		try{
			if(semmir010Bean.getPolicySP().getStrParam() != null){
				semmir010Bean.setRenderedMsgFormTop(false);
				String tempId = "";
				to = insuredService.querySPList(EQueryName.SP_MIR010_SCH.name, semmir010Bean.getPolicySP());
				
//				semmir010Bean.setInsurancePaymentSPList(new ArrayList<WrapperBeanObject<InsurancePaymentSP>>());
//				semmir010Bean.setPolicySPList(new ArrayList<WrapperBeanObject<PolicySP>>());
				if(to != null && !to.isEmpty()){
					semmir010Bean.setRenderedMsgDataNotFound(false);
					semmir010Bean.setPolicySPList(new ArrayList<WrapperBeanObject<PolicySP>>());
					for (int i=0; i<to.size(); i++) {
//						InsurancePaymentSP o = (InsurancePaymentSP)to.get(i);
//						WrapperBeanObject<InsurancePaymentSP> tmpWrapperBean = new WrapperBeanObject<InsurancePaymentSP>();
						PolicySP o = (PolicySP)to.get(i);
						WrapperBeanObject<PolicySP> tmpWrapperBean = new WrapperBeanObject<PolicySP>();
						
						//Set Hide Check Box By PaymentGroupNo
						if(o.getPaymentGroupNo() != null && tempId.equals(o.getPaymentGroupNo())){
							 o.setRenderColumn(false);
						}else{
							if(o.getPaymentGroupNo() != null){
								tempId = o.getPaymentGroupNo();
							}
							o.setRenderColumn(true);
						}
						
						//convert date to TH year for displaying.
//						o.setUpdateDt(convertYearENtoTH(o.getUpdateDt()));
//						o.setPaymentDt(convertYearENtoTH(o.getPaymentDt()));
//						o.setChqDt(convertYearENtoTH(o.getChqDt()));
//						o.setChqReceiveDt(convertYearENtoTH(o.getChqReceiveDt()));
//						o.setTransferDt(convertYearENtoTH(o.getTransferDt()));
						o.setUpdateDtStr(convertYearENtoTHStr(o.getUpdateDt()));
						o.setPaymentDtStr(convertYearENtoTHStr(o.getPaymentDt()));
						o.setChqDtStr(convertYearENtoTHStr(o.getChqDt()));
						o.setChqReceiveDtStr(convertYearENtoTHStr(o.getChqReceiveDt()));
						o.setTransferDtStr(convertYearENtoTHStr(o.getTransferDt()));
						tmpWrapperBean.setDataObj(o);
						tmpWrapperBean.setMessage("");
						tmpWrapperBean.setCheckBox(false);
//						semmir010Bean.getInsurancePaymentSPList().add(tmpWrapperBean);
						semmir010Bean.getPolicySPList().add(tmpWrapperBean);
						semmir010Bean.setChkSelAll(false);
						onRenderExportButton();
					}
				}else{
					semmir010Bean.setRenderedMsgDataNotFound(true);
				}
				setSemmir010Bean(semmir010Bean);
				flag = true;
			}else{
				if(validateFrmSearch()){
					semmir010Bean.setRenderedMsgFormTop(true);
					
					return flag;
				}else{
					semmir010Bean.setRenderedMsgFormTop(false);
					String tempId = "";
					to = insuredService.querySPList(EQueryName.SP_MIR010_SCH.name, semmir010Bean.getPolicySP());
					
//					semmir010Bean.setInsurancePaymentSPList(new ArrayList<WrapperBeanObject<InsurancePaymentSP>>());
//					semmir010Bean.setPolicySPList(new ArrayList<WrapperBeanObject<PolicySP>>());
					if(to != null && !to.isEmpty()){
						semmir010Bean.setRenderedMsgDataNotFound(false);
						semmir010Bean.setPolicySPList(new ArrayList<WrapperBeanObject<PolicySP>>());
						for (int i=0; i<to.size(); i++) {
//							InsurancePaymentSP o = (InsurancePaymentSP)to.get(i);
//							WrapperBeanObject<InsurancePaymentSP> tmpWrapperBean = new WrapperBeanObject<InsurancePaymentSP>();
							PolicySP o = (PolicySP)to.get(i);
							WrapperBeanObject<PolicySP> tmpWrapperBean = new WrapperBeanObject<PolicySP>();
							
							//Set Hide Check Box By PaymentGroupNo
							if(o.getPaymentGroupNo() != null && tempId.equals(o.getPaymentGroupNo())){
								 o.setRenderColumn(false);
							}else{
								if(o.getPaymentGroupNo() != null){
									tempId = o.getPaymentGroupNo();
								}
								o.setRenderColumn(true);
							}
							
							//convert date to TH year for displaying.
//							o.setUpdateDt(convertYearENtoTH(o.getUpdateDt()));
//							o.setPaymentDt(convertYearENtoTH(o.getPaymentDt()));
//							o.setChqDt(convertYearENtoTH(o.getChqDt()));
//							o.setChqReceiveDt(convertYearENtoTH(o.getChqReceiveDt()));
//							o.setTransferDt(convertYearENtoTH(o.getTransferDt()));
							o.setUpdateDtStr(convertYearENtoTHStr(o.getUpdateDt()));
							o.setPaymentDtStr(convertYearENtoTHStr(o.getPaymentDt()));
							o.setChqDtStr(convertYearENtoTHStr(o.getChqDt()));
							o.setChqReceiveDtStr(convertYearENtoTHStr(o.getChqReceiveDt()));
							o.setTransferDtStr(convertYearENtoTHStr(o.getTransferDt()));
							tmpWrapperBean.setDataObj(o);
							tmpWrapperBean.setMessage("");
							tmpWrapperBean.setCheckBox(false);
//							semmir010Bean.getInsurancePaymentSPList().add(tmpWrapperBean);
							semmir010Bean.getPolicySPList().add(tmpWrapperBean);
							semmir010Bean.setChkSelAll(false);
							onRenderExportButton();
						}
					}else{
						semmir010Bean.setRenderedMsgDataNotFound(true);
					}
					setSemmir010Bean(semmir010Bean);
					flag = true;
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return flag;
	}	
	
	
	public boolean doClear(){
		semmir010Bean = getSemmir010Bean();
		semmir010Bean.setRenderedMsgFormSearch(false);
		semmir010Bean.setDisabledBtnExport(true);
		semmir010Bean.setRenderedBtnA4JExport(false);
		semmir010Bean.setRenderedBtnHExport(true);
		semmir010Bean.setPolicySP(new PolicySP());
		semmir010Bean.setPolicySPList(new ArrayList<WrapperBeanObject<PolicySP>>());
		semmir010Bean.setInsurancePayActSP(new InsurancePayActSP());
		semmir010Bean.setMirGetRunningNo(new MirGetRunningNo());
		semmir010Bean.setPopupPolicySP(new PolicySP());
		semmir010Bean.setInsurancePayEditSaveSP(new InsurancePayEditSaveSP());
		semmir010Bean.setChkSelAll(false);
		semmir010Bean.setRenderedMsgDataNotFound(false);
		setSemmir010Bean(semmir010Bean);
//		init();
		return false;
	}
	
	public void onRenderExportButton(){
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
//		log.info("tmpRowId :" + rowId);
		getSemmir010Bean().setTmpRowId(rowId);
		
		if(!validateExport()){
//			getSemmir010Bean().setRenderedBtnA4JExport(true);
			getSemmir010Bean().setRenderedBtnHExport(false);
			
		}else{
//			getSemmir010Bean().setRenderedBtnA4JExport(false);
			getSemmir010Bean().setRenderedBtnHExport(true);
			
		}
		//Check if BatchNo Equal
		if(isOneValue()){
			getSemmir010Bean().setRenderedBtnHExport(true);
			getSemmir010Bean().setRenderedBtnExportShowError(false);
		}else{
			getSemmir010Bean().setRenderedBtnHExport(false);
			getSemmir010Bean().setRenderedBtnExportShowError(true);
		}
		
		if(isCheckSELBox()){
			getSemmir010Bean().setDisabledBtnExport(false);
			getSemmir010Bean().setCommandButtonEnable(false);
		}else{
			getSemmir010Bean().setDisabledBtnExport(true);
			getSemmir010Bean().setCommandButtonEnable(true);
		}
	}
	
	public boolean validateExport(){
		boolean flagValid = true;
		semmir010Bean = getSemmir010Bean();
		
		for (WrapperBeanObject<PolicySP> temp : semmir010Bean.getPolicySPList()) {
			PolicySP po = (PolicySP)temp.getDataObj();
			if(temp.isCheckBox()){
				if(po.getPaymentStatus().equals("01")){
					flagValid = false;
					break;
				}
			}
		}
		return flagValid;
	}
	
	private boolean isCheckSELBox(){
		boolean isCheck = false;
		List<WrapperBeanObject<PolicySP>> policySP = getSemmir010Bean().getPolicySPList();
		for (WrapperBeanObject<PolicySP> wrapperBeanObject : policySP) {
			if(wrapperBeanObject.isCheckBox()){
				return true;
			}
		}
		return isCheck;
	}
	
	private boolean isOneValue(){
		boolean isTrue = true;
		int totalPBatchNo = 0;
		String paymentBatchNo = "";
		String tmpPaymentBatchNo = "";
		for (WrapperBeanObject<PolicySP> temp : semmir010Bean.getPolicySPList()) {
			PolicySP po = (PolicySP)temp.getDataObj();
			if(temp.isCheckBox()){
				paymentBatchNo = po.getBatchNo();
				if(StringUtils.isNotBlank(paymentBatchNo)){
					if(!StringUtils.equals(tmpPaymentBatchNo, paymentBatchNo)){
						tmpPaymentBatchNo = paymentBatchNo;
						totalPBatchNo++;
					}
				}
				
				if(totalPBatchNo > 1)
				return isTrue = false;
				
			}
			
		}
			
		return isTrue;
	}
	
	public boolean validateFrmSearch(){
		boolean flag = true;
		if(StringUtils.isNotEmpty(getSemmir010Bean().getPolicySP().getCompany()) ||
			StringUtils.isNotEmpty(getSemmir010Bean().getPolicySP().getDocType()) ||
			StringUtils.isNotEmpty(getSemmir010Bean().getPolicySP().getNetworkType()) ||
			StringUtils.isNotEmpty(getSemmir010Bean().getPolicySP().getTransferType()) ||
			StringUtils.isNotEmpty(getSemmir010Bean().getPolicySP().getPolicyType()) ||
			StringUtils.isNotEmpty(getSemmir010Bean().getPolicySP().getPolicyNo()) ||
			StringUtils.isNotEmpty(getSemmir010Bean().getPolicySP().getPaymentStatus()) ||
			StringUtils.isNotEmpty(getSemmir010Bean().getPolicySP().getBatchNo()) ||
			(getSemmir010Bean().getPolicySP().getDueDtFrom()!= null && getSemmir010Bean().getPolicySP().getDueDtTo()!= null) ||
			StringUtils.isNotEmpty(getSemmir010Bean().getPolicySP().getPayType()) ||
			StringUtils.isNotEmpty(getSemmir010Bean().getPolicySP().getVendorCode()) ||
			StringUtils.isNotEmpty(getSemmir010Bean().getPolicySP().getVendorName()) ||
			StringUtils.isNotEmpty(getSemmir010Bean().getPolicySP().getContractNo()) ||
			StringUtils.isNotEmpty(getSemmir010Bean().getPolicySP().getLocationCode()) ||
			StringUtils.isNotEmpty(getSemmir010Bean().getPolicySP().getLocationId()) ||
			StringUtils.isNotEmpty(getSemmir010Bean().getPolicySP().getLocationName()) 
		){
			flag = false;
		}else{
			addMessageError("W0004", msg("message.requireOne"));
		}
		return flag;
	}
	
	private boolean validateApprove(){
		boolean flgValid = true;
		semmir010Bean = getSemmir010Bean();
//		if(StringUtils.isEmpty(getsemmir010Bean().getRemark())){
//			FrontMessageUtils.addMessageError(
//					SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), msg("message.remark")));
//			flgValid = false;
//		}
		return flgValid;
	}
	
	private boolean validateSaveAct() {
		boolean flgValid = true;
		semmir010Bean = getSemmir010Bean();
//		int i = 0;
//		String vendorCode = "";
//		String payeeId = "";
//		for (WrapperBeanObject<PolicySP> temp : semmir010Bean.getPolicySPList()) {
//			PolicySP rt = (PolicySP)temp.getDataObj();
//			if(temp.isCheckBox() && i==0){
//				vendorCode = rt.getVendorCode();
//				payeeId = rt.getPayeeId();
//				i++;
//			}
//			if(temp.isCheckBox() && !StringUtils.equals(vendorCode, rt.getVendorCode()) 
//			  || temp.isCheckBox() && !StringUtils.equals(payeeId, rt.getPayeeId())){
//				
//				flgValid = false;
//				break;
//			}
//		}
		return flgValid;
	}
	
	public boolean doSaveAct(){
		boolean flag = false;
		String rowsIdConcat = "";
		String tempPaymentGroup = "";
		String btnStatus = "";
		semmir010Bean = getSemmir010Bean();
		IInsuredService insuredService = (IInsuredService)getBean("insuredService");
		
		if(semmir010Bean.getBtnApproveStatus() != null && !StringUtils.isEmpty(semmir010Bean.getBtnApproveStatus())){
			btnStatus = semmir010Bean.getBtnApproveStatus();
			if(semmir010Bean.getBtnApproveStatus().equals("CA") && !validateApprove()){
				semmir010Bean.setPopupClose(false);
				semmir010Bean.setRenderedMsgFormTop(false);
				semmir010Bean.setRenderedMsgFormMiddle(true);
				setSemmir010Bean(semmir010Bean);
				return flag;
			}
			semmir010Bean.setPopupClose(true);
			semmir010Bean.getInsurancePayActSP().setRemark(semmir010Bean.getRemark());
		}else{
			btnStatus = (String)getFacesUtils().getRequestParameter("btnStatus");
			if(!StringUtils.isEmpty(semmir010Bean.getBtnStatus())){
				btnStatus = semmir010Bean.getBtnStatus();
			}
			semmir010Bean.getInsurancePayActSP().setRemark(null);
		}
	
		List<InsurancePayActSP> to = null;
		
		// loop for Concat RowId
		for (WrapperBeanObject<PolicySP> temp : semmir010Bean.getPolicySPList()) {
			PolicySP rt = (PolicySP)temp.getDataObj();
			if(temp.isCheckBox()){
				tempPaymentGroup = rt.getPaymentGroupNo();
			}else if(rt.getPaymentGroupNo() != null && rt.getPaymentGroupNo().equals(tempPaymentGroup)){
				temp.setCheckBox(true);
			}
			if(temp.isCheckBox() && rowsIdConcat.equals("")){
				rowsIdConcat = rt.getRowId();
			}
			else if(temp.isCheckBox() && !rowsIdConcat.equals("")){
				rowsIdConcat = rowsIdConcat+",".trim()+rt.getRowId();
			}
		}
		if(btnStatus.equals("AG")){
			if(!validateSaveAct()){
				addMessageError("incContent:frmSearchResult:pnlSearchResult", "W0015", "Vendor");
				semmir010Bean.setRenderedMsgFormSearch(false);
				semmir010Bean.setRenderedMsgFormTop(false);
				semmir010Bean.setRenderedMsgFormMiddle(true);
				setSemmir010Bean(semmir010Bean);
				return flag;
			}
		}
		
		semmir010Bean.getInsurancePayActSP().setRowId(rowsIdConcat);
		semmir010Bean.getInsurancePayActSP().setActionType(btnStatus);
		semmir010Bean.getInsurancePayActSP().setUserId(getUserLogIn());
		try {
			to = insuredService.querySPList(EQueryName.SP_MIR010_ACT.name, semmir010Bean.getInsurancePayActSP());
			if (to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")) {
				addMessageInfo("M0001");
			}else if(to != null && !to.isEmpty()){
				FrontMessageUtils.addMessageError(to.get(0).getpRemark());
			}
			semmir010Bean.setBtnStatus("");
			setSemmir010Bean(semmir010Bean);
			chkSrch = false;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError("E0001");
		}
		setSemmir010Bean(semmir010Bean);
		doSearch();
		doClearApproveStatus();
		semmir010Bean.setRenderedMsgFormTop(false);
		semmir010Bean.setRenderedMsgFormMiddle(false);
		semmir010Bean.setRenderedMsgFormBottom(true);
		return flag;
	}
	
	public boolean doClearApproveStatus(){
		boolean flag = false;
		semmir010Bean = getSemmir010Bean();
		semmir010Bean.setBtnApproveStatus("");
		setSemmir010Bean(semmir010Bean);
		return flag;
	}
	
	public boolean initApprove(){
		boolean flag = false;
		semmir010Bean = getSemmir010Bean();
		String btnApproveStatus = (String)getFacesUtils().getRequestParameter("btnApproveStatus");
		semmir010Bean.setBtnApproveStatus(btnApproveStatus);
		setSemmir010Bean(semmir010Bean);
		return flag;
	}
	
	public boolean onRenderMsgExoprt(){
		boolean flag = false;
		addMessageError("W0042");
		return flag;
	}
	
	public boolean onRenderMsgErrorExoprt(){
		boolean flag = false;
		addMessageError("W0098");
		getSemmir010Bean().setRenderedMsgFormTop(true);
		getSemmir010Bean().setRenderedMsgFormBottom(false);
		return flag;
	}
	
	public boolean initExportExcel(){
		semmir010Bean = getSemmir010Bean();
		if(!validateExportExcel()){
			semmir010Bean.setRenderedMsgFormMiddle(false);
			semmir010Bean.setRenderedMsgFormBottom(false);
			semmir010Bean.setDisplayShowExcel(false);
			return false;
		}
		semmir010Bean.setDisplayShowExcel(true);
		setSemmir010Bean(semmir010Bean);
		return true;
	}
	
	private boolean validateExportExcel(){
		 semmir010Bean = getSemmir010Bean();
		 String payType = null;
		 for (WrapperBeanObject<PolicySP> temp : semmir010Bean.getPolicySPList()) {
			 log.debug("temp = "+temp);
			 PolicySP ir = (PolicySP)temp.getDataObj();
			 log.debug("ir = "+ir);
				if(temp.isCheckBox()){
					if(payType == null){
						payType = ir.getPaymentType();
					}
					log.debug("payType = "+payType);
//					if(!payType.equals(ir.getPaymentType())){
//						//Error Msg
//						addMessageError(("W0075"), msg("export.col.paymentTypeDesc"));
//						return false;
//					}
				}
		}
		return true;
	}
	
	public void doExportExcel(){
		log.info("doExportExcel");
		semmir010Bean = getSemmir010Bean();
		String payType = "";
		String renType = "";
		String chqDt = "";
		String chqRecDt = "";
		String tranfDt = "";
		String tempPaymentGroup = "";
		
			String paymentBatchNo = "";
			String tmpPaymentBatchNo = "";
			int totalPBatchNo = 0;
			//isCheckbox in Group
			for (WrapperBeanObject<PolicySP> temp : semmir010Bean.getPolicySPList()) {
				PolicySP ir = (PolicySP)temp.getDataObj();
				if(temp.isCheckBox()){
					//Adding by mr.John from (mr.Choosak) 28/04/2011
					paymentBatchNo = ir.getBatchNo();
					if(StringUtils.isNotBlank(paymentBatchNo)){
						if(!StringUtils.equals(paymentBatchNo, tmpPaymentBatchNo))
						totalPBatchNo++;
					}
					
					tempPaymentGroup = ir.getPaymentGroupNo();
					payType = ir.getPaymentType();
					if("01".equals(ir.getPaymentType())){
						renType = StringUtils.isNotEmpty(ir.getPaymentTypeDesc())?ir.getPaymentTypeDesc():"" ;
						if(ir.getChqDt() != null){
							chqDt = new SimpleDateFormat("dd/MM/yyyy").format(ir.getChqDt());
						}
						if(ir.getChqReceiveDt() != null){
							chqRecDt = new SimpleDateFormat("dd/MM/yyyy").format(ir.getChqReceiveDt());
						}
					}else{
						renType = ir.getPaymentTypeDesc();
						if(ir.getTransferDt() != null){
							tranfDt = new SimpleDateFormat("dd/MM/yyyy").format(ir.getTransferDt());
						}
					}
				}else if(ir.getPaymentGroupNo() != null && ir.getPaymentGroupNo().equals(tempPaymentGroup)){
					temp.setCheckBox(true);
				}
				if(StringUtils.isNotBlank(paymentBatchNo))
				tmpPaymentBatchNo = paymentBatchNo;
			}
			
			try{
				
				double amount = 0.00;
				double vatAmount = 0.00;
				double whtAmount = 0.00;
				double netAmount = 0.00;
				double dutyAmount = 0.00;
			    // Date Format
			    DateFormat df =  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
			    
			    //call store procedure get PaymentBatchNo
			    IInsuredService insuredService = (IInsuredService)getBean("insuredService");
			    List<MirGetRunningNo> to = null;
			    semmir010Bean.getMirGetRunningNo().setRunningType("IR_PAY_BATCH");
			    to = insuredService.querySPList(EQueryName.SP_MIR_GET_RUNNING_NO.name, semmir010Bean.getMirGetRunningNo());
			    
				short line = 0;
				Collection<PolicySP> exList = new ArrayList<PolicySP>();
				//PDocumentManager export to excel
				DocumentExportManager<PolicySP> docManager =
					new DocumentExportManager<PolicySP>(PolicySP.class, EnumDocumentType.XLS);
				// set current configuration of work book.	
					docManager.setRowStart(line);
				
				EnumDocStyleDomain	titleStyle	= new EnumDocStyleDomain(EnumDocStyle.TITLE);
				EnumDocStyleDomain field = docManager.getStyle("normalField");
				EnumDocStyleDomain headerStyle = docManager.getStyle("rt003FieldHeader");
				EnumDocStyleDomain fieldMoney = docManager.getStyle("rt003FieldMoney");
				
				RowDomain row0 = new RowDomain(0,true);	
				row0.setCell(new CellDomain(0,13, null, String.class, titleStyle, msg("export.col.insurancePaymentHeader")+" "+msg("export.col.date")+" "+df.format(SEMDataUtility.convertToThYear(new Date())),null));
				
				if(StringUtils.isBlank(tmpPaymentBatchNo)){
					tmpPaymentBatchNo = to.get(0).getRunningNo();
				}
				
				log.debug("tmpPaymentBatchNo = "+tmpPaymentBatchNo);
				RowDomain row1 = new RowDomain(1,true);	
				row1.setCell(new CellDomain(0,13, null, String.class, titleStyle, msg("export.col.paymentBatchNo")+" "+tmpPaymentBatchNo ,null));
				
				RowDomain row2 = new RowDomain(2,true);
				
				RowDomain row3 = new RowDomain(3,true);
				row3.setCell(new CellDomain(0, null, String.class, headerStyle, msg("export.col.no"),-1,750));
				row3.setCell(new CellDomain(1, null, String.class, headerStyle, msg("export.col.paymentDocNo"),-1,2800));
				row3.setCell(new CellDomain(2, null, String.class, headerStyle, msg("export.col.policy"),-1,2400));
				row3.setCell(new CellDomain(3, null, String.class, headerStyle,	msg("export.col.dueDtEn"),-1,2200));
				row3.setCell(new CellDomain(4, null, String.class, headerStyle,	msg("export.col.companyTh"),-1,1300));
				row3.setCell(new CellDomain(5, null, String.class, headerStyle, msg("export.col.network"),-1,2800));
				row3.setCell(new CellDomain(6, null, String.class, headerStyle, msg("export.col.transfer"),-1,2400));
				row3.setCell(new CellDomain(7, null, String.class, headerStyle, msg("export.col.policyType"),-1,2300));
				row3.setCell(new CellDomain(8, null, String.class, headerStyle, msg("export.col.docType"),-1,2300));
				row3.setCell(new CellDomain(9, null, String.class, headerStyle, msg("export.col.vendorCodeEn"),-1,2700));
				row3.setCell(new CellDomain(10, null, String.class, headerStyle, msg("export.col.vendorNameEn"),-1,4800));
				row3.setCell(new CellDomain(11, null, String.class, headerStyle, msg("export.col.payee"),-1,2200));
				row3.setCell(new CellDomain(12, null, String.class, headerStyle,msg("export.col.amountEn"),-1,2200));
				row3.setCell(new CellDomain(13, null, String.class, headerStyle,msg("export.col.duty"),-1,1300));
				row3.setCell(new CellDomain(14, null, String.class, headerStyle,msg("export.col.vatAmtEn"),-1,2000));
				row3.setCell(new CellDomain(15, null, String.class, headerStyle,msg("export.col.whtAmtEn"),-1,2000));
				row3.setCell(new CellDomain(16, null, String.class, headerStyle,msg("export.col.netAmtEn"),-1,2000));
				
				List<WrapperBeanObject<PolicySP>> detailList = new ArrayList<WrapperBeanObject<PolicySP>>();
				PolicySP po = new PolicySP();
				detailList = getSemmir010Bean().getPolicySPList();
				int no = 0;
				
				for(int i=0; i<detailList.size(); i++){
					WrapperBeanObject<PolicySP> detail = new WrapperBeanObject<PolicySP>();
					detail = detailList.get(i);
					if(detail.isCheckBox()){
						 ++no;
						 po = (PolicySP)detail.getDataObj();
						 po.setNo(no);
						 if(po.getDueDtFrom() != null)po.setDueDtStr(new SimpleDateFormat("dd/MM/yyyy").format(po.getDueDtFrom()));
						 amount += po.getExcAmt();
						 dutyAmount += po.getDutyAmt();
						 vatAmount += po.getVatAmt();
						 whtAmount += po.getWhtAmt();
						 netAmount += po.getTotalPayAmt();
						 exList.add(po);
					}
				}
				
				RowDomain row9 = new RowDomain(exList.size()+4,true);
				row9.setCell(new CellDomain(0, null, String.class, field, null,-1,null));
				row9.setCell(new CellDomain(1, null, String.class, field, null,-1,null));
				row9.setCell(new CellDomain(2, null, String.class, field, null,-1,null));
				row9.setCell(new CellDomain(3, null, String.class, field, null,-1,null));
				row9.setCell(new CellDomain(4, null, String.class, field, null,-1,null));
				row9.setCell(new CellDomain(5, null, String.class, field, null,-1,null));
				row9.setCell(new CellDomain(6, null, String.class, field, null,-1,null));
				row9.setCell(new CellDomain(7, null, String.class, field, null,-1,null));
				row9.setCell(new CellDomain(8, null, String.class, field, null,-1,null));
				row9.setCell(new CellDomain(9, null, String.class, field, null,-1,null));
				row9.setCell(new CellDomain(10, null, String.class, field, null,-1,null));
				row9.setCell(new CellDomain(11, null, String.class, field, null,-1,null));
				row9.setCell(new CellDomain(12, null, Double.class, fieldMoney,amount,-1,2200));
				row9.setCell(new CellDomain(13, null, Double.class, fieldMoney, dutyAmount,-1,1300));
				row9.setCell(new CellDomain(14, null, Double.class, fieldMoney, vatAmount,-1,2000));
				row9.setCell(new CellDomain(15, null, Double.class, fieldMoney, whtAmount,-1,2000));
				row9.setCell(new CellDomain(16, null, Double.class, fieldMoney, netAmount,-1,2000));
				
				RowDomain row6 = new RowDomain(exList.size()+5,true);
				RowDomain row4 = new RowDomain(exList.size()+6,true);
				RowDomain row7 = new RowDomain(exList.size()+7,true);
				RowDomain row8 = new RowDomain(exList.size()+8,true);
				
				if("01".equals(payType)){
					row4.setCell(new CellDomain(1, null, String.class, titleStyle, msg("export.col.paymentTypeDesc")+" : ",null));
					row4.setCell(new CellDomain(2, null, String.class, field, (StringUtils.isEmpty(renType)?"":renType),null));
					row7.setCell(new CellDomain(1, null, String.class, titleStyle, msg("export.column.contract.chqDt")+" : ",null));
					row7.setCell(new CellDomain(2, null, String.class, field, (StringUtils.isEmpty(chqDt)?"":chqDt),null));
					row8.setCell(new CellDomain(1, null, String.class, titleStyle, msg("export.column.contract.chqRecDt")+" : ",null));
					row8.setCell(new CellDomain(2, null, String.class, field, (StringUtils.isEmpty(chqRecDt)?"":chqRecDt),null));
					docManager.putDetailRow(row7);
				}else{
					row4.setCell(new CellDomain(1, null, String.class, titleStyle, msg("export.col.paymentTypeDesc")+" : ",null));
					row4.setCell(new CellDomain(2, null, String.class, field, (StringUtils.isEmpty(renType)?"":renType),null));
					row8.setCell(new CellDomain(1, null, String.class, titleStyle, msg("export.column.contract.tranDt")+" : ",null));
					row8.setCell(new CellDomain(2, null, String.class, field, (StringUtils.isEmpty(tranfDt)?"":tranfDt),null));
				}
				
				
				docManager.putDetailRow(row0);
				docManager.putDetailRow(row1);
				docManager.putDetailRow(row2);
				docManager.putDetailRow(row3);
				docManager.putDetailRow(row9);
				docManager.putDetailRow(row4);
				docManager.putDetailRow(row6);
				docManager.putDetailRow(row8);
				docManager.seteObjectList(exList);
				docManager.setMargin(0, 0, 0, 0);
				docManager.seteObjectList(exList);
				docManager.setModule("INSURANCE");
				docManager.setPrintPageLandScape(true);
				docManager.getObjectFromDocument();
				docManager.exportServletFile();
	           
				semmir010Bean.setBtnStatus("EP");
				setSemmir010Bean(semmir010Bean);
				doSaveAct();
				semmir010Bean.setDisplayShowExcel(false);
			}catch(NullPointerException ne){
				log.error(ne);
			}catch(Exception e){
				log.error(e);
			}
	}
	
	public boolean initCoppyDate(){
		boolean flag = false;
		semmir010Bean = getSemmir010Bean();
		PolicySP rtTmp = null;
		int i = 0;
		boolean second = false;
			for (WrapperBeanObject<PolicySP> temp : semmir010Bean.getPolicySPList()) {
				if(temp.isCheckBox()){
					PolicySP ir = (PolicySP)temp.getDataObj();
					
					if(!second){
						if(ir.getChqDt() == null && ir.getChqReceiveDt() == null && ir.getTransferDt() == null){
							addMessageError("W0086");
							semmir010Bean.setPopupClose(false);
							break;
						}
						second = true;
					}
				
					if(rtTmp == null && ir != null){
						rtTmp = ir;
						log.debug("rtTmp.getPaymentType() = "+rtTmp.getPaymentType());
					}
					if(i != 0){
						log.debug("ir.getPaymentType() = "+ir.getPaymentType());
						if(ir.getPaymentType() == null || rtTmp.getPaymentType().equals(ir.getPaymentType()) || "".equals(ir.getPaymentType())){
							if(ir.getChqDt() != null || ir.getChqReceiveDt() != null || ir.getTransferDt() != null){
								semmir010Bean.setPopupClose(true);
								semmir010Bean.setPopupName("mdpConfirmCoppyDateDialog2");
								semmir010Bean.setConfirmCoppyDateMsg(MSGCacheUtil.getInstance().getMessageByCode("Q0004"));
							}else{
								semmir010Bean.setPopupClose(true);
								semmir010Bean.setPopupName("mdpConfirmCoppyDateDialog1");
								semmir010Bean.setConfirmCoppyDateMsg(MSGCacheUtil.getInstance().getMessageByCode("Q0003"));
							}
						}else{
							semmir010Bean.setPopupClose(false);
							addMessageError("W0033");
							break;
						}
					}
					i++;
				}
			}
		setSemmir010Bean(semmir010Bean);
		return flag;
	}
	
	public boolean doCoppyDate(){
		boolean flag = false;
		semmir010Bean = getSemmir010Bean();
		StringBuffer rentalpayNo = new StringBuffer();
		String confirmStatus = (String)getFacesUtils().getRequestParameter("confirmStatus");
		IInsurancePaymentService insurancePaymentService = (IInsurancePaymentService)getBean("insurancePaymentService");
		InsurancePayment tmpInsuracePayment = new InsurancePayment();
		log.debug("confirmStatus = "+confirmStatus);
		PolicySP tmp = new PolicySP();
		boolean setTmp = true;
		try{
			for (WrapperBeanObject<PolicySP> temp : semmir010Bean.getPolicySPList()) {
				PolicySP ir = (PolicySP)temp.getDataObj();
				if(temp.isCheckBox()){
					//Set tmp is first row select
					if(setTmp){ 
						tmp = ir;
						setTmp = false;
					}
//					tmp = (PolicySP)semmir010Bean.getPolicySPList().get(0).getDataObj();
					if(confirmStatus.equals("Y")){
	//					tmpInsuracePayment = insuredService.getRentalPaymentByRowId(rt.getRowId());
						tmpInsuracePayment = insurancePaymentService.getInsurancePaymentByRowId(ir.getRowId());
						
						if(tmp.getChqDt() != null){
							tmpInsuracePayment.setChqDt(SEMDataUtility.convertToEnYear(tmp.getChqDt()));
						}
						
						if(tmp.getChqReceiveDt() != null){
							tmpInsuracePayment.setChqReceiveDt(SEMDataUtility.convertToEnYear(tmp.getChqReceiveDt()));
						}
						
						if(tmp.getTransferDt() != null){
							tmpInsuracePayment.setTransferDt(SEMDataUtility.convertToEnYear(tmp.getTransferDt()));
						}
						if(tmp.getPaymentType() != null){
							tmpInsuracePayment.setPaymentType(tmp.getPaymentType());
						}
						if(tmp.getPaymentMethod() != null){
							tmpInsuracePayment.setPaymentMethod(tmp.getPaymentMethod());
						}
						
//						tmpInsuracePayment.setPaymentMethod(semmir010Bean.getTmpPaymentMethod());
	//					if("01".equals(tmpInsuracePayment.getPaymentStatus()) || "04".equals(tmpInsuracePayment.getPaymentStatus())){
							insurancePaymentService.updateInsurancePayment(tmpInsuracePayment);
	//					}
//						rentalpayNo.append(ir.getRowId());
//						rentalpayNo.append(",");
					}
					// field chqDt chqReceiveDt TransferDt all null
					if(confirmStatus.equals("N") && ir.getChqDt() == null 
					   && ir.getChqReceiveDt() == null 
					   && ir.getTransferDt() == null){
						
	//					tmpInsuracePayment = insuredService.getRentalPaymentByRowId(rt.getRowId());
						tmpInsuracePayment = insurancePaymentService.getInsurancePaymentByRowId(ir.getRowId());
						
						if(tmp.getChqDt() != null){
							tmpInsuracePayment.setChqDt(tmp.getChqDt());
						}
						
						if(tmp.getChqReceiveDt() != null){
							tmpInsuracePayment.setChqReceiveDt(tmp.getChqReceiveDt());
						}
						
						if(tmp.getTransferDt() != null){
							tmpInsuracePayment.setTransferDt(tmp.getTransferDt());
						}
	//					if("01".equals(tmpInsuracePayment.getPaymentStatus()) || "04".equals(tmpInsuracePayment.getPaymentStatus())){
	//						insuredService.updateRentalPayment(tmpInsuracePayment);
							insurancePaymentService.updateInsurancePayment(tmpInsuracePayment);
	//					}
//						rentalpayNo.append(ir.getRowId());
//						rentalpayNo.append(",");
					}
				}
			}
			setSemmir010Bean(semmir010Bean);
			doSearch();
		}catch (Exception e) {
			e.printStackTrace();
			addMessageError("E0001");
		}				
//		if(rentalpayNo.length() != 0){
//			showErrorMsgValidateCopy(rentalpayNo.substring(0,rentalpayNo.length()-2).toString());
//		}
		return flag;
	}
	
//	private void showErrorMsgValidateCopy(String insurancePayNo){
//		IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
//		semmir010Bean = getSemmir010Bean();
//		try {
//			Mrt003ChkVendorMulti checkVendorMulti =  new Mrt003ChkVendorMulti();
//			checkVendorMulti.setRentalPaymentId(insurancePayNo);
//			List list = rentalPaymentService.querySPList(EQueryName.SP_CHK_VENDOR_MULTI.name, checkVendorMulti);
//			if(list != null && list.size() > 0){
//				if((Mrt003ChkVendorMulti)list.get(0) != null){
//					String msg = ((Mrt003ChkVendorMulti)list.get(0)).getMsgWarning();
//					semmir010Bean.setRenderedMsgFormBottom(true);
//					semmir010Bean.setRenderedMsgFormTop(false);
//					addGeneralMessageError(msg);
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		setSemmir010Bean(semmir010Bean);
//	}
	
	private boolean initEdit(){
		log.debug("***************initEdit**************");
		boolean flag = false;
		semmir010Bean = getSemmir010Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		String contractNo = (String)getFacesUtils().getRequestParameter("contractNo");
		IInsuredService insuredService = (IInsuredService)getBean("insuredService");
		String navModuleFrom = (String)getFacesUtils().getRequestParameter("navModuleFrom");
		String navProgramFrom = (String)getFacesUtils().getRequestParameter("navProgramFrom");
		String moduleWithNaviFrom = (String)getFacesUtils().getRequestParameter("actionWithNaviFrom");
		log.debug("WT### navModuleFrom="+navModuleFrom);
		log.debug("WT### navProgramFrom="+navProgramFrom);
		log.debug("WT### moduleWithNaviFrom="+moduleWithNaviFrom);
		//Fix paymentGroupNo
		semmir010Bean.setRowId(rowId);
		semmir010Bean.getPopupPolicySP().setRowId(rowId);
//		contractNo = "BKK 002";
		semmir010Bean.setRenderBtnVendorMaster((contractNo != null && !"".equals(contractNo))?true:false);
		log.debug("semmir010Bean.isRenderBtnVendorMaster() = "+semmir010Bean.isRenderBtnVendorMaster());
		
		if(navProgramFrom!=null && !"".equals(navProgramFrom)){
			semmir010Bean.setNavModuleFrom(navModuleFrom);
			semmir010Bean.setNavProgramFrom(navProgramFrom);
			semmir010Bean.setActionWithNaviFrom(moduleWithNaviFrom);
		}
		List<PolicySP> to = null;
		
			try {
				to = insuredService.querySPList(EQueryName.SP_MIR010_SCH_D.name, semmir010Bean.getPopupPolicySP());
				
				if(to != null || to.size() != 0){
					log.debug("to.size() = "+to.size());
					log.debug("to.get(0) = "+to.get(0));
					log.debug("to.get(0).getVendorCode() = "+to.get(0).getVendorCode());
					semmir010Bean.setPopupPolicySP(to.get(0));
					semmir010Bean.getPopupPolicySP().setContractNo(contractNo);
				}
				flag = true;
			} catch (Exception e) {
				e.printStackTrace();
				addMessageError(("E0003"));
			}
			
		semmir010Bean.setVendorMasterSPList(new ArrayList<VendorMasterSP>());
		onRenderPaymentMethod();
		log.debug("flag = "+flag);
		return flag;
	}

	//Create by new  04/09/2014
	public void onRenderPaymentMethod(){
		semmir010Bean = getSemmir010Bean();
		semmir010Bean.setRenderedChqDt(true);
		semmir010Bean.setRenderedChqReceiveDt(true);
		semmir010Bean.setRenderedTransferDt(true);
		//semmpt004Bean.setRenderedPaymentMethod(false);

		//-------------------------------------
		if(StringUtils.isEmpty(semmir010Bean.getPopupPolicySP().getPaymentType())){
			//semmir010Bean.setRenderCldTransferDt(true);
			//semmir010Bean.setRenderCldChqDt(true);
//			semmir010Bean.getPopupPolicySP().setPaymentMethod("");
			//addded by NEW 20150828 check null befor set default paymentMethod
			if(semmir010Bean.getPopupPolicySP().getPaymentMethod() == null || 
					semmir010Bean.getPopupPolicySP().getPaymentMethod().equals(""))
				semmir010Bean.getPopupPolicySP().setPaymentMethod("");
			//end added
			semmir010Bean.getPopupPolicySP().setChqDt(null);
			//semmpt004Bean.getMpt004Pay().setChqReceiveDt(null);
			semmir010Bean.getPopupPolicySP().setTransferDt(null);
			semmir010Bean.setRenderedChqDt(true);
			semmir010Bean.setRenderedChqReceiveDt(true);
			semmir010Bean.setRenderedTransferDt(true);
		}
		if(semmir010Bean.getPopupPolicySP().getPaymentType() != null && semmir010Bean.getPopupPolicySP().getPaymentType().equals("01")){
			semmir010Bean.setRenderedChqDt(false);
			semmir010Bean.setRenderedChqReceiveDt(false);
			semmir010Bean.setRenderedTransferDt(true);
			List<SelectItem> paymentMethodList = getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name,EX_AND,"CHEQUE",null,null);
			semmir010Bean.setPaymentMethodList(paymentMethodList);
			semmir010Bean.getPopupPolicySP().setTransferDt(null);
//			semmir010Bean.getPopupPolicySP().setPaymentMethod("03");
			//addded by NEW 20150828 check null befor set default paymentMethod
			if(semmir010Bean.getPopupPolicySP().getPaymentMethod() == null || 
					semmir010Bean.getPopupPolicySP().getPaymentMethod().equals(""))
				semmir010Bean.getPopupPolicySP().setPaymentMethod(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.CT_PAYMENT_METHOD));
			//end added
			semmir010Bean.setRenderedChqDt(false);
			semmir010Bean.setRenderedChqReceiveDt(false);
			semmir010Bean.getPopupPolicySP().setTransferDt(null);
			semmir010Bean.setRenderedChqDt(false);
			semmir010Bean.setRenderedTransferDt(true);
		}
		if(semmir010Bean.getPopupPolicySP().getPaymentType() != null && semmir010Bean.getPopupPolicySP().getPaymentType().equals("02")){
			semmir010Bean.setRenderedChqDt(true);
			semmir010Bean.setRenderedTransferDt(false);
			// prepare paymentMethodList
			List<SelectItem> paymentMethodList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
			List<SelectItem> selectList = new ArrayList<SelectItem>();
			for(SelectItem selectItem : paymentMethodList){
				if (StringUtils.equalsIgnoreCase("U", selectItem.getDescription())){
					selectList.add(selectItem);
				}
				
			}
			semmir010Bean.setPaymentMethodList(selectList);
			semmir010Bean.getPopupPolicySP().setChqDt(null);
			semmir010Bean.setRenderedTransferDt(false);
		}
		if(semmir010Bean.getPopupPolicySP().getPaymentType() != null && semmir010Bean.getPopupPolicySP().getPaymentType().equals("03")){
			semmir010Bean.setRenderedChqDt(false);
			semmir010Bean.setRenderedChqReceiveDt(true);
			semmir010Bean.setRenderedTransferDt(true);
			
			// prepare paymentMethodList
			List<SelectItem> paymentMethodList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
			List<SelectItem> selectList = new ArrayList<SelectItem>();
//			
			for(SelectItem selectItem : paymentMethodList){
				
				if (StringUtils.equalsIgnoreCase("P", selectItem.getDescription())){
					selectList.add(selectItem);
				}
			
			}
			semmir010Bean.setPaymentMethodList(selectList);
		}
//		semmpt004Bean.setMsgTop(false);
//		semmpt004Bean.setPnlPayInfo(false);
//		semmpt004Bean.setPnlPayment(true);
		setSemmir010Bean(semmir010Bean);
		
		//-------------------------------------
		//setSemmpt004Bean(semmpt004Bean);
	}
	
	public boolean doSaveEdt(){
		boolean flag = false;
		semmir010Bean = getSemmir010Bean();
		IInsuredService insuredService = (IInsuredService)getBean("insuredService");
		List<InsurancePayEditSaveSP> to = null;
		
		semmir010Bean.getInsurancePayEditSaveSP().setPaymentGroupNo(semmir010Bean.getRowId());
		semmir010Bean.getInsurancePayEditSaveSP().setVendorCode(semmir010Bean.getPopupPolicySP().getVendorCode());
		semmir010Bean.getInsurancePayEditSaveSP().setPayeeMasterId(semmir010Bean.getPopupPolicySP().getPayeeMasterId());
		semmir010Bean.getInsurancePayEditSaveSP().setInvoiceNo(semmir010Bean.getPopupPolicySP().getInvoiceNo());
		semmir010Bean.getInsurancePayEditSaveSP().setExcAmt(semmir010Bean.getPopupPolicySP().getExcAmt()==null?0:semmir010Bean.getPopupPolicySP().getExcAmt());
		semmir010Bean.getInsurancePayEditSaveSP().setVatAmt(semmir010Bean.getPopupPolicySP().getVatAmt()==null?0:semmir010Bean.getPopupPolicySP().getVatAmt());
		semmir010Bean.getInsurancePayEditSaveSP().setWhtAmt(semmir010Bean.getPopupPolicySP().getWhtAmt()==null?0:semmir010Bean.getPopupPolicySP().getWhtAmt());
		semmir010Bean.getInsurancePayEditSaveSP().setDutyAmt(semmir010Bean.getPopupPolicySP().getDutyAmt()==null?0:semmir010Bean.getPopupPolicySP().getDutyAmt());
		semmir010Bean.getInsurancePayEditSaveSP().setPaymentType(semmir010Bean.getPopupPolicySP().getPaymentType());
		semmir010Bean.getInsurancePayEditSaveSP().setPaymentMethod(semmir010Bean.getPopupPolicySP().getPaymentMethod());
		semmir010Bean.getInsurancePayEditSaveSP().setChqDt(semmir010Bean.getPopupPolicySP().getChqDt());
		semmir010Bean.getInsurancePayEditSaveSP().setChqReceiveDt(semmir010Bean.getPopupPolicySP().getChqReceiveDt());
		semmir010Bean.getInsurancePayEditSaveSP().setTransferDt(semmir010Bean.getPopupPolicySP().getTransferDt());
		semmir010Bean.getInsurancePayEditSaveSP().setRemark(semmir010Bean.getPopupPolicySP().getRemark());
		semmir010Bean.getInsurancePayEditSaveSP().setUserId(semmir010Bean.getPopupPolicySP().getUserId());
		//added by NEW 20190418
		semmir010Bean.getInsurancePayEditSaveSP().setContractNo(semmir010Bean.getPopupPolicySP().getContractNo());
		
		try {
			to = insuredService.querySPList(EQueryName.SP_MIR010_PAY.name, semmir010Bean.getInsurancePayEditSaveSP());
			if (to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")) {
				addMessageInfo("M0001");
				semmir010Bean.setPopupClose(new Boolean(true));
			}else if(to != null && !to.isEmpty()){
				FrontMessageUtils.addMessageError(to.get(0).getpRemark());
			}
			
			chkSrch = false;
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError("E0001");
		}
		semmir010Bean.setRenderedMsgFormTop(true);
		semmir010Bean.setRenderedMsgFormMiddle(false);
		setSemmir010Bean(semmir010Bean);
		doSearch();
		return flag;
	}
	
	public void selectAllRow(){
		try{
			boolean chkAll = getSemmir010Bean().isChkSelAll();
			List<WrapperBeanObject<PolicySP>> detailList = new ArrayList<WrapperBeanObject<PolicySP>>();
			detailList = getSemmir010Bean().getPolicySPList();
			for(int i=0; i<detailList.size(); i++){
				detailList.get(i).setCheckBox(chkAll);
			}
			onRenderExportButton();
		}catch(NullPointerException ne){

		}catch(Exception e){
			
		}
	}
	
	public boolean doGetVendorMaster(){
		
		log.info("START Action doGetVendorMaster");
		
		boolean flagReturn = false;
		
		IVendorMapPayeeELService service = (IVendorMapPayeeELService)getBean("vendorMapPayeeELService");
		IVendorBookbankService bookbankService = (IVendorBookbankService)getBean("vendorBookbankService");
		
		semmir010Bean = getSemmir010Bean();
		semmir010Bean.setSelectedRadio("");
		
//		String contractNo = (String)getFacesUtils().getRequestParameter("contractNo");
		String contractNo = semmir010Bean.getPopupPolicySP().getContractNo();
		String navModuleFrom = (String)getFacesUtils().getRequestParameter("navModuleFrom");
		String navProgramFrom = (String)getFacesUtils().getRequestParameter("navProgramFrom");
		String moduleWithNaviFrom = (String)getFacesUtils().getRequestParameter("actionWithNaviFrom");
		
		log.debug("WT### contractNo ="+contractNo);
		log.debug("WT### navModuleFrom="+navModuleFrom);
		log.debug("WT### navProgramFrom="+navProgramFrom);
		log.debug("WT### moduleWithNaviFrom="+moduleWithNaviFrom);
		if(navProgramFrom!=null && !"".equals(navProgramFrom)){
			semmir010Bean.setNavModuleFrom(navModuleFrom);
			semmir010Bean.setNavProgramFrom(navProgramFrom);
			semmir010Bean.setActionWithNaviFrom(moduleWithNaviFrom);
			
			semmir010Bean.setNavModuleFrom2(navModuleFrom);
			semmir010Bean.setNavProgramFrom2(navProgramFrom);
			semmir010Bean.setActionWithNaviFrom2(moduleWithNaviFrom);
		}		
		if(!"".equals(contractNo)){
			try {
				
				log.info("START Service service.queryVendorMapPayeeByContractNo");
				List<VendorMapPayeeEL> vendorMapPayeeList = service.queryVendorMapPayeeByContractNo(contractNo);
				log.info("END Service service.queryVendorMapPayeeByContractNo");
				log.info("START Service bookbankService.getVendorBookbankByVendorMasterId");
				for(VendorMapPayeeEL obj : vendorMapPayeeList){
					obj.setVendorBookbank(bookbankService.getVendorBookbankByVendorMasterId(obj.getVendorMasterId().getRowId()));
					if(null!=obj.getVendorMasterId()){
						obj.getVendorMasterId().setVendorStatusDesc(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_VENDOR_STATUS.name), obj.getVendorMasterId().getVendorStatus()));					
					}
					if(null!=obj.getVendorBookbank()){
						obj.getVendorBookbank().setVendorBookbankStatusDesc(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_BOOKBANK_STATUS.name), obj.getVendorBookbank().getVendorBookbankStatus()));
					}
					obj.setExpenseTypeDesc(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_EXPENSE_TYPE.name), obj.getExpenseType()));
				}
				log.info("END Service bookbankService.getVendorBookbankByVendorMasterId");
				
				semmir010Bean.setVendorMapPayeeList(vendorMapPayeeList);
				initVendorMaster();
				flagReturn = true;
				log.info("END Action doGetVendorMaster");
			} catch (Exception e) {
				e.printStackTrace();
				log.info("ERROR Action doGetVendorMaster");
			}
		}
		return flagReturn;
	}
	
	private void initVendorMaster(){
		semmir010Bean = getSemmir010Bean();
		semmir010Bean.setVendorMaster(new VendorMaster());
		semmir010Bean.setVendorBookBank(new VendorBookbank());
		semmir010Bean.setVendorMapPayee(new VendorMapPayee());
		semmir010Bean.setCt001SrchMSP(new CT001SrchMSP());
		semmir010Bean.setCt001SrchMSPList(new ArrayList<WrapperBeanObject<CT001SrchMSP>>());
	}
	
	public boolean doBack(){
		return true;
	}
	
	private boolean doSaveVendorMapPayee(){
		log.info("Start Action doSaveVendorMapPayee");
		boolean flagValid = false;
		try{
			
			semmir010Bean = getSemmir010Bean();
			String vendorMapPayeeId = semmir010Bean.getSelectedRadio();
			log.debug("WT###Print vendorMapPayeeId ="+vendorMapPayeeId);
			List<VendorMapPayeeEL> vendorMapPayeeList = semmir010Bean.getVendorMapPayeeList();
			VendorMapPayeeEL vendorMapPayee = null;
			if(!vendorMapPayeeList.isEmpty()){
				for(VendorMapPayeeEL obj : vendorMapPayeeList){
					if(vendorMapPayeeId.equals(obj.getRowId())){
						vendorMapPayee = obj;
					}
				}
			}
			log.debug("WT###Print vendorMapPayee ="+vendorMapPayee);
			if(null!=vendorMapPayee){
				log.debug("WT###Print vendorMapPayee.getExpenseType() ="+vendorMapPayee.getExpenseType());				
				String navProgramFrom = semmir010Bean.getNavProgramFrom();
				if(null!=navProgramFrom && !"".equals(navProgramFrom)){
					
					semmir010Bean.getPopupPolicySP().setVendorCode(vendorMapPayee.getVendorMasterId().getVendorCode());
					semmir010Bean.getPopupPolicySP().setVendorName(vendorMapPayee.getVendorMasterId().getVendorName());
					if(vendorMapPayee.getPayeeMasterId() != null){
						semmir010Bean.getPopupPolicySP().setPayeeMasterId(vendorMapPayee.getPayeeMasterId().getRowId());
						semmir010Bean.getPopupPolicySP().setPayeeName(vendorMapPayee.getPayeeMasterId().getPayeeName());
					}
					setSemmir010Bean(semmir010Bean);
				}				
			}			
			
			flagValid = true;
			log.info("END Action doSaveVendorMapPayee");
		}catch(Exception ex){
			log.error("ERROR Action doSaveVendorMapPayee : "+ex, ex);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMIR010");
			FrontMessageUtils.addMessageError(errorMsg);
			ex.printStackTrace();
		}		
		return flagValid;			
	}
	
	public boolean doBackPage(){
//		doGetVendorMaster();
//		getSemmir010Bean().setTmpContractNo(null);
//		return true;
		
		boolean flagReturn = false;
		log.info("START Action doBackPage");
		try{
		
			doGetVendorMaster();
			SEMMIR010Bean semmir010Bean = getSemmir010Bean();
			log.debug("WT###semmir010Bean.getNavProgramFrom() = "+semmir010Bean.getNavProgramFrom());
			if("SEMMIR001-VMP".equals(semmir010Bean.getNavProgramFrom())){
				semmir010Bean.setNavModuleFrom(semmir010Bean.getNavModuleFrom2());
				semmir010Bean.setNavProgramFrom(semmir010Bean.getNavProgramFrom2());
				semmir010Bean.setActionWithNaviFrom(semmir010Bean.getActionWithNaviFrom2());
			}
			flagReturn = true;
			log.info("END Action doBackPage");
		}catch(Exception e){
			log.error("ERROR Action doBackPage : "+e, e);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMIR010");
			FrontMessageUtils.addMessageError(errorMsg);
		}
		return flagReturn;
		
	}
	
	
	
	public void calculateTotalAmt(){
		log.debug("Calculate");
		semmir010Bean = getSemmir010Bean();
	
	/*	----> Remove Logic incorrect if some Amount is null can not calculate ---> Internal error
	 */
	/*  if(semmir010Bean.getPopupPolicySP().getExcAmt() != null ||
			semmir010Bean.getPopupPolicySP().getVatAmt() != null ||
			semmir010Bean.getPopupPolicySP().getWhtAmt() != null ||
			semmir010Bean.getPopupPolicySP().getDutyAmt() != null ){
			semmir010Bean.getPopupPolicySP().setTotalPayAmt(semmir010Bean.getPopupPolicySP().getExcAmt() + semmir010Bean.getPopupPolicySP().getVatAmt()
														- semmir010Bean.getPopupPolicySP().getWhtAmt() + semmir010Bean.getPopupPolicySP().getDutyAmt());
		}
	*/	  
		
	/*==== 26/12/2022  fixed Internal Error case Amount is null	 */	
		//System.out.println("Before .... semmir010Bean.getPopupPolicySP().getVatAmt() ="+semmir010Bean.getPopupPolicySP().getVatAmt());
		
		semmir010Bean.getPopupPolicySP().setExcAmt(semmir010Bean.getPopupPolicySP().getExcAmt()==null?0: semmir010Bean.getPopupPolicySP().getExcAmt());
		semmir010Bean.getPopupPolicySP().setVatAmt(semmir010Bean.getPopupPolicySP().getVatAmt()==null?0: semmir010Bean.getPopupPolicySP().getVatAmt());
		semmir010Bean.getPopupPolicySP().setWhtAmt(semmir010Bean.getPopupPolicySP().getWhtAmt()==null?0: semmir010Bean.getPopupPolicySP().getWhtAmt());
		semmir010Bean.getPopupPolicySP().setDutyAmt(semmir010Bean.getPopupPolicySP().getDutyAmt()==null?0: semmir010Bean.getPopupPolicySP().getDutyAmt());
	       
		semmir010Bean.getPopupPolicySP().setTotalPayAmt(semmir010Bean.getPopupPolicySP().getExcAmt() + semmir010Bean.getPopupPolicySP().getVatAmt()
				- semmir010Bean.getPopupPolicySP().getWhtAmt() + semmir010Bean.getPopupPolicySP().getDutyAmt());
		//System.out.println("After .... semmir010Bean.getPopupPolicySP().getVatAmt() ="+semmir010Bean.getPopupPolicySP().getVatAmt());
		
		setSemmir010Bean(semmir010Bean);
	}
	
	private boolean doSearchVendor(){
		boolean flag = false;
		semmir010Bean = getSemmir010Bean();
		IInsuredService insuredService = (IInsuredService)getBean("insuredService");
		VendorMasterSP vendorMasterSP = new VendorMasterSP();
		try {
			List<VendorMasterSP> vendorMasterSPList = insuredService.querySPList(EQueryName.SP_SEARCH_VENDOR_MASTER.name, vendorMasterSP);
			semmir010Bean.setVendorMasterSPList(vendorMasterSPList);
			setSemmir010Bean(semmir010Bean);
		} catch (Exception e) {
			e.printStackTrace();
			log.debug(e);
		}
		
		return flag;
	}
	
	public boolean doSelectVendorMaster(){
		semmir010Bean = getSemmir010Bean();
		String vendorMasterID = (String)getFacesUtils().getRequestParameter("vendorMasterID");
		log.debug("vendorMasterID = "+vendorMasterID);
		
		for(VendorMasterSP tmp :semmir010Bean.getVendorMasterSPList()){
			if(StringUtils.equalsIgnoreCase(tmp.getRowId(), vendorMasterID)){
				semmir010Bean.getPopupPolicySP().setVendorCode(tmp.getVendorCode());
				semmir010Bean.getPopupPolicySP().setVendorName(tmp.getVendorName());
				semmir010Bean.getPopupPolicySP().setPayeeMasterId(tmp.getPayeeMasterId());
				semmir010Bean.getPopupPolicySP().setPayeeName(tmp.getPayeeName());
				semmir010Bean.getPopupPolicySP().setPayeeCode(tmp.getPayeeCode());
			}
		}
		setSemmir010Bean(semmir010Bean);
		return true;
	}
	
	// added by.. YUT
	public boolean doInitialForSearchInsurance() {
		log.info("::: SEMMIR010Action :: doInitialForSearchSiteInfo >> BEGIN :::");
		boolean flag = true;

		try {
			this.init();
			//semmsi004Bean = getSemmsi004Bean();
			semmir010Bean = getSemmir010Bean();
			semmir001Bean = getSemmir001Bean();

			String paramUrl = getFacesUtils().getRequestParameter("paramUrl") == null ? "" : (String) getFacesUtils().getRequestParameter("paramUrl");
	        String paramMenuGroup = getFacesUtils().getRequestParameter("paramMenuGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuGroup");
	        String paramMenuSubGroup = getFacesUtils().getRequestParameter("paramMenuSubGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuSubGroup");
	        String paramParameter = getFacesUtils().getRequestParameter("paramParameter") == null ? "" : (String) getFacesUtils().getRequestParameter("paramParameter");
	        
	        System.out.println("paramUrl: " + paramUrl);
	        System.out.println("paramMenuGroup: " + paramMenuGroup);
	        System.out.println("paramMenuSubGroup: " + paramMenuSubGroup);
	        System.out.println("paramParameter: " + paramParameter);
	        
	        semmir010Bean.setPolicySP(new PolicySP());
	        semmir010Bean.getPolicySP().setStrParam(paramParameter);
	        //getSiteInfoSP().setStrParam(paramParameter);
	        semmir010Bean.setRenderedOnToDoList(true); //

			//setSemmsi004Bean(semmsi004Bean);
			setSemmir010Bean(semmir010Bean);
			setSemmir001Bean(semmir001Bean);
			this.doSearch();

		} catch(Exception e) {
			e.printStackTrace();
			addMessageError("EL0000", "SEMMSI004Action");
			flag = false;
			
		} finally {
			log.info("::: SEMMIR010Action :: doInitialForSearchSiteInfo >> END :::");
		}
		return flag;
	}
	
	//create by new  11/05/2015
	private boolean doSendSMS(){
		SEMMIR010Bean semmir010Bean = getSemmir010Bean();
		IPaymentService paymentService = (IPaymentService)getBean("paymentService");
		boolean result = false;
		StringBuffer rowId = new StringBuffer();
		RentalPayNormalSearchSP rentalPay = new RentalPayNormalSearchSP();
		String groupNoTmp = "";
		
		for(WrapperBeanObject<PolicySP> wrapper: semmir010Bean.getPolicySPList()){
			if(wrapper.isCheckBox()){
				PolicySP policySP = new PolicySP();
				policySP = (PolicySP) wrapper.getDataObj();
//				for(PolicySP policySP : wrapper.getPaymentList()){
					rowId.append(policySP.getRowId()+",");
//				}
			}
		}
		
		List<SMSModel> smsList = null;
		SMSModel smsP = new SMSModel();
		try {
			smsP.setpRowId(rowId.toString());
			smsP.setpType("A");
			log.debug("rowId = "+rowId.toString());
			smsList = paymentService.querySPList(EQueryName.SP_MRT003_SMS.name, smsP);
			log.debug("smsList = "+smsList);
			if(smsList == null || smsList.size() == 0){
				addMessageError("M0004");
			}else{
				for(SMSModel smsM :smsList){
					log.debug("smsM"+smsM.getMobileNo());
					result = SmsClient.sendSMS(smsM);
					log.debug("result = "+result);
				}
				this.doSearch();
				addMessageInfo("M0001");
			}
		}catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		return false;
	}
	
	//create by new  11/05/2015
	private boolean doSendEmail(){
		SEMMIR010Bean semmir010Bean = getSemmir010Bean();
		IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
		boolean result = false;
		StringBuffer rowId = new StringBuffer();
		RentalPayNormalSearchSP rentalPay = new RentalPayNormalSearchSP();
		String groupNoTmp = "";
		
//		for(PaymentWrapper wrapper: semmir010Bean.getPaymentWrapperList()){
//			if(wrapper.isSelected()){
//				for(Payment payment : wrapper.getPaymentList()){
//					rowId.append(payment.getRowId()+",");
//				}
//			}
//		}
		for(WrapperBeanObject<PolicySP> wrapper: semmir010Bean.getPolicySPList()){
			if(wrapper.isCheckBox()){
				PolicySP policySP = new PolicySP();
				policySP = (PolicySP) wrapper.getDataObj();
//				for(PolicySP policySP : wrapper.getPaymentList()){
					rowId.append(policySP.getRowId()+",");
//				}
			}
		}
		
		List<EMAILModel> emailList = null;
		EMAILModel email = new EMAILModel();
		
		Collection to = new ArrayList();
		String from = "";
		String Subject = null;
		String msgText = "";
		
		try {
			email.setRow_ID(rowId.toString());
			email.setV_type("A");
			email.setUserId(getUserLogIn());
			log.debug("rowId = "+rowId.toString());
			emailList = rentalPaymentService.querySPList(EQueryName.SP_MRT003_MAIL.name, email);	
			
			if(emailList == null || emailList.size() == 0){ 	
				addMessageError("E0004");
			}else{
				for(EMAILModel emailM :emailList){
					log.debug("email from : "+emailM.getEmail_from());
//					emailM.setV_Message(emailM.getV_Message()+" FROM SEMMIR010-1");
					emailM.setV_Message(emailM.getV_Message());
					result = EmailMessageUtil.sendEmail(emailM);
					log.debug("result = "+result);
				}
				this.doSearch();
				addMessageInfo("M0003");
			}
			log.debug("result = "+result);
		}catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
		return result;
	}
	
	//update by new  26/11/2014 
	private boolean doExportLetter() {
		semmir010Bean = getSemmir010Bean();
		ArrayList<Mel008ExpLetter> to = new ArrayList<Mel008ExpLetter>();
		List<Mel008ExpLetter> result = null;
		StringBuffer rowId = new StringBuffer();
		try{
			//check befor export letter
			Mel008ExpLetter expLetter = new Mel008ExpLetter();
			//expLetter.setpTaxYearFrom(semmrt003Bean.getMrt003Srch().getpTaxYearFrom().toString());
			
//			List<PaymentWrapper> paymentWrapperList = semmir010Bean.getPaymentWrapperList();
			List<WrapperBeanObject<PolicySP>> wrapperList = semmir010Bean.getPolicySPList();
			IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
				
			for(WrapperBeanObject<PolicySP> wrapper: semmir010Bean.getPolicySPList()){
				if(wrapper.isCheckBox()){
					PolicySP policySP = new PolicySP();
					policySP = (PolicySP) wrapper.getDataObj();
//					for(Payment payment : wrapper.getPaymentList()){
					//rowId.append(payment.getRowId()+",");
					expLetter.setRowId(policySP.getRowId());
//					}
					result = (ArrayList) pTaxMasterService.querySPList(EQueryName.SP_MEL008_EXPLET.name, expLetter);
					if(result!=null && result.size()>0){
						Mel008ExpLetter m = new Mel008ExpLetter();
						m = result.get(0);
						to.add(m);
					}else{
						to = null;
					}	
				}
			}
			
			if (to != null && to.size()>0 ){
				semmir010Bean.setDisplayReportFlag(true);
			}else{
				semmir010Bean.setDisplayReportFlag(false);
				addMessageWarn("M0004");
			}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			setSemmir010Bean(semmir010Bean);
		}
		return true;
	}
	
	//update by new  26/11/2014
	public void doExportExcelLetter(){
		semmir010Bean = getSemmir010Bean();
		//semmrt003Bean.setDisplayReportFlag(false);
		semmir010Bean.setRenderedMsgFormTop(false);
		ArrayList<Mel008ExpLetter> to = new ArrayList<Mel008ExpLetter>();
		List<Mel008ExpLetter> result = null;
		StringBuffer rowId = new StringBuffer();
//		if(semmrt003Bean.isChkPayGovtFlag()){
//			semmrt003Bean.getMrt003Srch().setPayGovtFlag("Y");
//		}else{
//			semmrt003Bean.getMrt003Srch().setPayGovtFlag("N");
//		}
//
//		
		try {
			//List<Payment> selectedPayments = getSelectedPaymentFromDatabase(semmel008Bean);
			Mel008ExpLetter expLetter = new Mel008ExpLetter();
			//expLetter.setpTaxYearFrom(semmrt003Bean.getMrt003Srch().getpTaxYearFrom().toString());
			
//			List<PaymentWrapper> paymentWrapperList = semmir010Bean.getPaymentWrapperList();
			List<WrapperBeanObject<PolicySP>> wrapperList = semmir010Bean.getPolicySPList();
				IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
				
				
				for(WrapperBeanObject<PolicySP> wrapper: semmir010Bean.getPolicySPList()){
					if(wrapper.isCheckBox()){
						PolicySP policySP = new PolicySP();
						policySP = (PolicySP) wrapper.getDataObj();
//						for(Payment payment : wrapper.getPaymentList()){
							//rowId.append(payment.getRowId()+",");
						expLetter.setRowId(policySP.getRowId());
//						}
						result = (ArrayList) pTaxMasterService.querySPList(EQueryName.SP_MEL008_EXPLET.name, expLetter);
						if(result!=null && result.size()>0){
							Mel008ExpLetter m = new Mel008ExpLetter();
							m = result.get(0);
							to.add(m);
						}else{
							to = null;
						}
						
					}
				}

//				for (PaymentWrapper wrapper : paymentWrapperList) {
//					
//					//RentalPayNormalSearchSP rt = (RentalPayNormalSearchSP)temp.getDataObj();
//					if(wrapper.isSelected()){
//						List<Payment> paymentList = wrapper.getPaymentList();
//						// query payment from database
//						for(Payment payment : paymentList){
//							payment.getRowId();
//							if(payment.getRowId()!=null){
//								expLetter.setRowId(payment.getRowId());
//							}
//						
//						
//						result = (ArrayList) pTaxMasterService.querySPList(EQueryName.SP_MEL008_EXPLET.name, expLetter);
//						//result.add(pTaxMasterService.querySPList(EQueryName.SP_MRT003_EXPLET.name, expLetter));
//						Mel008ExpLetter m = new Mel008ExpLetter();
//						m = result.get(0);
//						to.add(m);
//						}
//					}
//				}
		if (to != null && to.size()>0 ){
			try {
				int numberOfContract = 0;
				int rowNo = 0;	
				int widthCell = 13350;
				short line = 0;
				int columnCount = 0;
				int maxColumn = to.size();
				DocumentExportManager<Mpt003ExpLetter> docManager =
					new DocumentExportManager<Mpt003ExpLetter>(Mpt003ExpLetter.class, EnumDocumentType.XLS);
					docManager.setRowStart(line);
				
				EnumDocStyleDomain fieldStyleTLR = docManager.getStyle("pt003FieldTLR");
				EnumDocStyleDomain fieldStyleLR = docManager.getStyle("pt003FieldLR");
				EnumDocStyleDomain fieldStyleLRB = docManager.getStyle("pt003FieldLRB");
				EnumDocStyleDomain normalField = docManager.getStyle("normalField");
				
				for (Mel008ExpLetter export : to){
					 
					RowDomain row0 = new RowDomain(rowNo++,true);
					row0.setCell(new CellDomain(0, null, String.class, fieldStyleTLR, export.getVendorCode(),-1,widthCell));
					row0.setCell(new CellDomain(1, null, String.class, normalField, "",-1,1200));
					docManager.putDetailRow(row0);
					
					RowDomain row1 = new RowDomain(rowNo++,true);
					row1.setCell(new CellDomain(0, null, String.class, fieldStyleLR, export.getVendorName(),-1,widthCell));
					docManager.putDetailRow(row1);
					
					RowDomain row2 = new RowDomain(rowNo++,true);
					row2.setCell(new CellDomain(0, null, String.class, fieldStyleLR, export.getVendorAddress1(),-1,widthCell));
					docManager.putDetailRow(row2);
					
					RowDomain row3 = new RowDomain(rowNo++,true);
					row3.setCell(new CellDomain(0, null, String.class, fieldStyleLR, export.getVendorAddress2(),-1,widthCell));
					docManager.putDetailRow(row3);
					
					String contractStr = export.getContractNo();
					String[] contractNo = null;
					contractNo = contractStr.split(",");
//					log.debug("ContractNo : "+contractNo);
					String contractNoStrCount = "";
					int chk = 1;
					int lenghtContract = contractNo.length;
					columnCount++;
						for (int i = 0; i<contractNo.length;i++){	
							if(columnCount==maxColumn){
							log.debug("i ="+i);
							log.debug("contractNo.length ="+(contractNo.length-1));
							}
							if(StringUtils.isEmpty(contractNoStrCount)){
								contractNoStrCount = contractNo[i];
							}else{
								contractNoStrCount = contractNoStrCount+","+contractNo[i];
							}
							if(chk%5 == 0 ){
								
								RowDomain row4 = new RowDomain(rowNo++,true);
								
								if(i == (contractNo.length-1)){
									log.debug("Last");
									row4.setCell(new CellDomain(0, null, String.class, fieldStyleLRB, contractNoStrCount,-1,widthCell));
								}else{
									row4.setCell(new CellDomain(0, null, String.class, fieldStyleLR, contractNoStrCount,-1,widthCell));
								}
								
								docManager.putDetailRow(row4);
								contractNoStrCount = "";
							}
							
							if(lenghtContract%5 != 0 && (chk==lenghtContract)){
								RowDomain row4 = new RowDomain(rowNo++,true);
//								row4.setCell(new CellDomain(0, null, String.class, fieldStyle, contractNoStrCount,-1,widthCell));
								if(i == (contractNo.length-1)){
									log.debug("Last");
									row4.setCell(new CellDomain(0, null, String.class, fieldStyleLRB, contractNoStrCount,-1,widthCell));
								}else{
									row4.setCell(new CellDomain(0, null, String.class, fieldStyleLR, contractNoStrCount,-1,widthCell));
								}
								docManager.putDetailRow(row4);
								contractNoStrCount = "";
							}
							chk++;
						}
					
						
				}
				log.debug("columnCount = "+columnCount);
				log.debug("maxColumn = "+maxColumn);
					docManager.seteObjectList(null);
					docManager.setModule("CONTRACT_LETTER");
					docManager.setPrintPageLandScape(true);
					docManager.setMargin(0.05, 0.05, 0.5, 0.05);
					docManager.getObjectFromDocument();
					docManager.exportServletFile();
					semmir010Bean.setDisplayReportFlag(false);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			semmir010Bean.setDisplayReportFlag(false);
			semmir010Bean.setRenderedMsgDataNotFound(true);
		}
			setSemmir010Bean(semmir010Bean);
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	// -> popup add vendor
	public void initAddVendor(){
		log.info("-- initPopupAddVendor --");

		SEMMIR010Bean mir010Bean = getSemmir010Bean();

		try {
			
			doClearPopupAddVendor();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmir010Bean(mir010Bean);
	}
	
	public void doSearchPopupAddVendor(){
		log.info("-- doSearchPopupAddVendor --");

		SEMMIR010Bean mir010Bean = getSemmir010Bean();

		try {
			
			//String strVendorCode = mir010Bean.getVendorMasterPopupObjParam().getVendorCode();
			//String strVendorName = mir010Bean.getVendorMasterPopupObjParam().getVendorName();


			IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
			List<VendorMasterSP> vendorMasterList = null;
			
			mir010Bean.setVendorMasterPopupList(new ArrayList<WrapperBeanObject<VendorMasterSP>>());
			
			vendorMasterList = service.queryVendorMasterSPList(EQueryName.SP_GET_MAP_VENDOR.name, mir010Bean.getVendorMasterPopupObjParam());
			if(vendorMasterList != null && !vendorMasterList.isEmpty()){
				 for(int i=0; i<vendorMasterList.size(); i++){
					VendorMasterSP vm = (VendorMasterSP)vendorMasterList.get(i);
					WrapperBeanObject<VendorMasterSP> tmpWrapperBean = new WrapperBeanObject<VendorMasterSP>();
					
					tmpWrapperBean.setDataObj(vm);
					tmpWrapperBean.setMessage("");
					mir010Bean.getVendorMasterPopupList().add(tmpWrapperBean);
					
					mir010Bean.setRenderedMsgDataNotFound(false);
				 }
			 } else {
				 mir010Bean.setRenderedMsgDataNotFound(true);
			 }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmir010Bean(mir010Bean);
	}
	
	public void doClearPopupAddVendor(){
		log.info("-- doClearPopupAddVendor --");

		SEMMIR010Bean mir010Bean = getSemmir010Bean();

		try {
			
			mir010Bean.getVendorMasterPopupObjParam().setVendorCode("");
			mir010Bean.getVendorMasterPopupObjParam().setVendorName("");
			mir010Bean.setVendorMasterPopupList(new ArrayList<WrapperBeanObject<VendorMasterSP>>());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmir010Bean(mir010Bean);
	}
	
	public void doSelectPopupAddVendor(){
		log.info("-- doSelectPopupAddVendor --");

		SEMMIR010Bean mir010Bean = getSemmir010Bean();

		try {
			
			String paramVendorCode = getFacesUtils().getRequestParameter("paramVendorCode") == null ? "" : 
							  (String)getFacesUtils().getRequestParameter("paramVendorCode");
			String paramVendorName = getFacesUtils().getRequestParameter("paramVendorName") == null ? "" : 
				  (String)getFacesUtils().getRequestParameter("paramVendorName");
			
			mir010Bean.getPolicySP().setVendorCode(paramVendorCode);
//			mir010Bean.getPolicySP().setVendorName(paramVendorName);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmir010Bean(mir010Bean);
	}
	// <- popup add vendor
}
