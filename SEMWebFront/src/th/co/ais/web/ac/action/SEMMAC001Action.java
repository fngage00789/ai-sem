package th.co.ais.web.ac.action;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.hibernate.mapping.Array;

import com.ais.sem.write.model.UserProfile;
import com.ais.sem.write.transfer.GenFileFromSemCTTransSap;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

//import JarTest.TestJar;

import th.co.ais.domain.ac.LoadClearCheque;
import th.co.ais.domain.ac.Mac001Act;
import th.co.ais.domain.ac.Mac001ClearChq;
import th.co.ais.domain.ac.Mac001LoadClearChq;
import th.co.ais.domain.ac.Mac001Pay;
import th.co.ais.domain.ac.Mac001ReFile;
import th.co.ais.domain.ac.Mac001Sap;
import th.co.ais.domain.ac.Mac001Srch;
import th.co.ais.domain.ac.Mac001SrchD;
import th.co.ais.domain.ac.Mac001SrchR;
import th.co.ais.domain.gm.VendorMasterSP;
import th.co.ais.domain.ir.IrDraft;
import th.co.ais.domain.ir.IrDraftDetail;
import th.co.ais.domain.ir.IrPolicySum;
import th.co.ais.domain.ir.Policy;
import th.co.ais.domain.rt.CheckVendor;
import th.co.ais.rpt.util.enums.EnumDocumentType;
import th.co.ais.service.gm.IVendorMasterService;
import th.co.ais.service.impl.lc.LoadClearChqServiceImpl;
import th.co.ais.service.lc.ILoadClearChequeService;
import th.co.ais.service.lc.ILoadClearChqService;
import th.co.ais.service.pt.IPTaxMasterService;
import th.co.ais.service.sap.ISAPService;
import th.co.ais.util.AISConstant;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.ac.bean.SEMMAC001Bean;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.SsoBean;
import th.co.ais.web.bean.common.PopupUploadFilePictureBean;
import th.co.ais.web.gm.bean.SEMMCT010Bean;
import th.co.ais.web.ir.bean.FileUploadBean;
import th.co.ais.web.report.util.DocumentImportManager;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.SemUtils;

public class SEMMAC001Action extends AbstractAction{

	private Logger log = Logger.getLogger(getClass());
	
	
	private PopupUploadFilePictureBean popupUploadFilePictureBean;

	public void setPopupUploadFilePictureBean(PopupUploadFilePictureBean popupUploadFilePictureBean) {
		this.popupUploadFilePictureBean = popupUploadFilePictureBean;
		getFacesUtils().setSessionMapValue("popupUploadFilePictureBean", popupUploadFilePictureBean);
	}		
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if(methodWithNavi.equalsIgnoreCase("pageLoad")){
			flag = pageLoad();
		}else if(methodWithNavi.equalsIgnoreCase("doBack")){
			flag = doBack();
		}else if(methodWithNavi.equalsIgnoreCase("doSearch")){
			flag = doSearch();
		}else if (methodWithNavi.equalsIgnoreCase("doClearSession")) {
			flag = doClearSession();
		}else if (methodWithNavi.equalsIgnoreCase("initEdit")) {
			flag = initEdit();
		}else if (methodWithNavi.equalsIgnoreCase("doSaveAct")) {
			flag = doSaveAct();
		}else if (methodWithNavi.equalsIgnoreCase("doClearApproveStatus")) {
			flag = doClearApproveStatus();
		}else if (methodWithNavi.equalsIgnoreCase("initApprove")) {
			flag = initApprove();
		}else if (methodWithNavi.equalsIgnoreCase("doSavePay")) {
			flag = doSavePay();
		}else if (methodWithNavi.equalsIgnoreCase("doResendFile")) {
			flag = doResendFile();
		}else if (methodWithNavi.equalsIgnoreCase("doImport")) {
			doImport();
		}
		
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}
	
	private FileUploadBean fileUploadBean;
	
	public FileUploadBean getFileUploadBean() {
		return (FileUploadBean)getFacesUtils().getSessionMapValue("fileUploadBean");
	}
	
	public void setFileUploadBean(FileUploadBean fileUploadBean) {
		getFacesUtils().setSessionMapValue("fileUploadBean", fileUploadBean);
	}

	@Override
	public void init() {
		SEMMAC001Bean semmac001Bean = new SEMMAC001Bean();
		semmac001Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmac001Bean.setModuleTypeList(getLovItemsByType(ELovType.T_CT_MODULE.name, EX_IN, "PAYMENT", null, null));
		semmac001Bean.setPaymentStatusList(getLovItemsByType(ELovType.T_CT_PAYMENT_STATUS.name, EX_IN, "ACCOUNT", null, null));
		semmac001Bean.setSiteStatusList(getLovItemsByType(ELovType.T_SI_SITE_STATUS.name));
		semmac001Bean.setPaymentTypeList(getLovItemsByType(ELovType.T_CT_PAYMENT_TYPE.name));
		semmac001Bean.setPaymentDocType(getLovItemsByType(ELovType.T_CT_PAYMENT_DOC_TYPE.name));
		semmac001Bean.setExpenseTypeList(getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name));
		semmac001Bean.setPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name));
		semmac001Bean.setCheckVendor(new CheckVendor());
		semmac001Bean.setMac001Srch(new Mac001Srch());
		semmac001Bean.setMac001SrchD(new Mac001SrchD());
		semmac001Bean.setMac001Act(new Mac001Act());
		semmac001Bean.setMac001pay(new Mac001Pay());
		semmac001Bean.setMac001Sap(new Mac001Sap());
		semmac001Bean.setMac001ReFile(new Mac001ReFile());
//		semmac001Bean.setMac001SrchR(new Mac001SrchR());
		semmac001Bean.setRenderButton(true);
		setSemmac001Bean(semmac001Bean);
		
		PopupUploadFilePictureBean uploadBean = new PopupUploadFilePictureBean();
		uploadBean.setModuleList(new ArrayList<SelectItem>());
		uploadBean.setSubModuleList(new ArrayList<SelectItem>());
		setPopupUploadFilePictureBean(uploadBean);
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

	private SEMMAC001Bean semmac001Bean;
	
	public SEMMAC001Bean getSemmac001Bean() {
		return (SEMMAC001Bean)getFacesUtils().getSessionMapValue("semmac001Bean");
	}

	public void setSemmac001Bean(SEMMAC001Bean semmac001Bean) {
		this.semmac001Bean = semmac001Bean;
		getFacesUtils().setSessionMapValue("semmac001Bean", semmac001Bean);
	}
	
	private SsoBean ssoBean;
	
	public SsoBean getSsoBean() {
		return (SsoBean)getFacesUtils().getSessionMapValue("ssoBean");
	}

	public void setSsoBean(SsoBean ssoBean) {
		this.ssoBean = ssoBean;
		getFacesUtils().setSessionMapValue("ssoBean", ssoBean);
	}
	
	public boolean pageLoad(){
		boolean flag = true;
		semmac001Bean  = getSemmac001Bean();
		IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
		List<Mac001SrchD> to = null;
		List<Mac001Sap> to2 = null;
		List<CheckVendor> to3 = null;
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		String statusPage = (String)getFacesUtils().getRequestParameter("statusPage");
		String navModuleFrom = (String)getFacesUtils().getRequestParameter("navModuleFrom");
		String navProgramFrom = (String)getFacesUtils().getRequestParameter("navProgramFrom");
		String moduleWithNaviFrom = (String)getFacesUtils().getRequestParameter("moduleWithNaviFrom");
		String actionWithNaviFrom = (String)getFacesUtils().getRequestParameter("actionWithNaviFrom");
		String methodWithNaviFrom = (String)getFacesUtils().getRequestParameter("methodWithNaviFrom");
		if(statusPage.equals("SEMMAC004")){
			init();
		}
		
		try {
			semmac001Bean.getMac001SrchD().setRowId(rowId);
			semmac001Bean.setTmpChkRowId(rowId);
			semmac001Bean.getMac001Sap().setTransPaymentId(rowId);
			semmac001Bean.setTmpNavModuleFrom(navModuleFrom);
			semmac001Bean.setTmpNavProgramFrom(navProgramFrom);
			semmac001Bean.setTmpModuleWithNavi(moduleWithNaviFrom);
			semmac001Bean.setTmpActionWithNavi(actionWithNaviFrom);
			semmac001Bean.setTmpMethodWithNavi(methodWithNaviFrom);
			semmac001Bean.setMsgHeaderPopup1("");
			semmac001Bean.setMsgHeaderPopup2("");
			
			to = pTaxMasterService.querySPList(EQueryName.SP_MAC001_SRCH_D.name, semmac001Bean.getMac001SrchD());
			to2 = pTaxMasterService.querySPList(EQueryName.SP_MAC001_SAP.name, semmac001Bean.getMac001Sap());
			
			semmac001Bean.getCheckVendor().setVendorMasterId(to.get(0).getVendorMasterId());
			semmac001Bean.getCheckVendor().setPayeeMasterId(to.get(0).getPayeeMasterId());
			semmac001Bean.getCheckVendor().setExpenseType(to.get(0).getExpenseType());
			semmac001Bean.getCheckVendor().setContractNo(to.get(0).getContractNo());
			
			to3 = pTaxMasterService.querySPList(EQueryName.SP_CHECK_VENDOR.name, semmac001Bean.getCheckVendor());
			if(to.size() != 0){
				if(StringUtils.isEmpty(to.get(0).getPreContractNo())){
					semmac001Bean.setRenderedLinkContract(false);
				}else{
					semmac001Bean.setRenderedLinkContract(true);
				}
			}
			
			for(int i=0; i<to3.size() - 1 ; i++){
				CheckVendor chv = (CheckVendor)to3.get(i);
				if(i==0){
					semmac001Bean.setMsgHeaderPopup1(chv.getMsgWarning());
				}
				if(i==1){
					semmac001Bean.setMsgHeaderPopup2(chv.getMsgWarning());
				}
			}
			
//			semmac001Bean.getMac001pay().setPaymentType(to.get(0).getPaymentType());
//			semmac001Bean.getMac001pay().setPaymentMethod(to.get(0).getPaymentMethod());
//			semmac001Bean.getMac001pay().setChqDt(to.get(0).getChqDt());
//			semmac001Bean.getMac001pay().setChqReceiveDt(to.get(0).getChqReceiveDt());
			
			semmac001Bean.setMac001SrchD(to.get(0));
			semmac001Bean.setMac001SapList(to2);
			semmac001Bean.setTmpStatusPage(statusPage);
			
			setSemmac001Bean(semmac001Bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean doBack(){
		boolean flag = true;

		return flag;
	}
	
	public boolean doSearch(){
		boolean flag = false;
		semmac001Bean = getSemmac001Bean();
		semmac001Bean.setRenderedMsgFormSearch(true);
		semmac001Bean.setRenderedMsgFormMiddle(false);
		if(!validateSearch()){
			return flag;
		}
		IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
		List<Mac001Srch> to =null;
		semmac001Bean.setMac001SrchList(new ArrayList<WrapperBeanObject<Mac001Srch>>());
		try {
			to = pTaxMasterService.querySPList(EQueryName.SP_MAC001_SRCH.name, semmac001Bean.getMac001Srch());
			if (to == null || to.size() == 0) {
				semmac001Bean.setRenderedMsgDataNotFound(true);
				semmac001Bean.setMac001SrchList(null);
			}else{
				semmac001Bean.setRenderedMsgDataNotFound(false);
				
				String tempId = "";
				 for(int i=0; i<to.size(); i++){
					 Mac001Srch mac001SrchSP = (Mac001Srch)to.get(i);
					 WrapperBeanObject<Mac001Srch> tmpWrapperBean = new WrapperBeanObject<Mac001Srch>();
					
					 mac001SrchSP.setRenderCheckBox(true);
					 /** check GroupNo on renderCheckbox **/
						if(mac001SrchSP.getPaymentGroupNo() != null && tempId.equals(mac001SrchSP.getPaymentGroupNo())){
							mac001SrchSP.setRenderCheckBox(false);
						}else if(mac001SrchSP.getPaymentGroupNo() != null){
							tempId = mac001SrchSP.getPaymentGroupNo();
							mac001SrchSP.setRenderCheckBox(true);
						}
					/** end Check **/
//System.out.println("mac001SrchSP.getPeriodStartDt : "+mac001SrchSP.getPeriodStartDt());
					/** Convert to Thai Date **/
						if(mac001SrchSP.getChqDt() != null){
							mac001SrchSP.setChqDt(SEMDataUtility.convertToThYear(mac001SrchSP.getChqDt()));
						}
						if(mac001SrchSP.getChqReceiveDt() != null){
							mac001SrchSP.setChqReceiveDt(SEMDataUtility.convertToThYear(mac001SrchSP.getChqReceiveDt()));
						}
						if(mac001SrchSP.getPeriodStartDt() != null){
							mac001SrchSP.setPeriodStartDt(SEMDataUtility.convertToThYear(mac001SrchSP.getPeriodStartDt()));
						}
						if(mac001SrchSP.getPeriodEndDt() != null){
							mac001SrchSP.setPeriodEndDt(SEMDataUtility.convertToThYear(mac001SrchSP.getPeriodEndDt()));
						}
						mac001SrchSP.setRenderedLinkSap(false);
						mac001SrchSP.setRenderedPaymentStatusDesc(true);
						if(mac001SrchSP.getPaymentStatus().equals("09")){
							mac001SrchSP.setRenderedLinkSap(true);
							mac001SrchSP.setRenderedPaymentStatusDesc(false);
						}
						mac001SrchSP.setRenderedLinkPrecontract(true);
						if(StringUtils.isEmpty(mac001SrchSP.getPreContractNo())){
							mac001SrchSP.setRenderedLinkPrecontract(false);
						}
						tmpWrapperBean.setDataObj(mac001SrchSP);
						 tmpWrapperBean.setMessage("");
						 tmpWrapperBean.setCheckBox(false);
						 semmac001Bean.getMac001SrchList().add(tmpWrapperBean);	
				 }
			}
			setSemmac001Bean(semmac001Bean);
			//log.debug("setSemmac001Bean ++  "+getSemmac001Bean().get)
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			addMessageError(("E0003"));
		}
		return flag;
	}
	
	private boolean validateSearch() {
		boolean flagValid = true;
		if(StringUtils.isEmpty(getSemmac001Bean().getMac001Srch().getCompany())){
			addMessageError("W0001", msg("message.company"));
			flagValid = false;
		}
		if(StringUtils.isEmpty(getSemmac001Bean().getMac001Srch().getModuleType())){
			addMessageError("W0001", "Module");
			flagValid = false;
		}
		
		Date paymentDtFrom = getSemmac001Bean().getMac001Srch().getPaymentDtFrom();
		Date paymentDtTo = getSemmac001Bean().getMac001Srch().getPaymentDtTo();
		Date chqReceiveDtFrom = getSemmac001Bean().getMac001Srch().getChqReceiveDtFrom();
		Date chqReceiveDtTo = getSemmac001Bean().getMac001Srch().getChqReceiveDtTo();
		Date transferDtFrom = getSemmac001Bean().getMac001Srch().getTransferDtFrom();
		Date transferDtTo = getSemmac001Bean().getMac001Srch().getTransferDtTo();
		
		if(paymentDtFrom != null && paymentDtTo != null){
			if(paymentDtFrom.after(paymentDtTo)){
				addMessageErrorWithArgument("W0006" ,msg("message.paymentDtFrom"), msg("massage.dateTo"));
				flagValid = false;
			}
		}
		if(chqReceiveDtFrom != null && chqReceiveDtTo != null){
			if(chqReceiveDtFrom.after(chqReceiveDtTo)){
				addMessageErrorWithArgument("W0006" ,msg("message.chqReceiveDtFrom"), msg("massage.dateTo"));
				flagValid = false;
			}
		}
		if(transferDtFrom != null && transferDtTo != null){
			if(transferDtFrom.after(transferDtTo)){
				addMessageErrorWithArgument("W0006" ,msg("message.transferDtTo"), msg("massage.dateTo"));
				flagValid = false;
			}
		}
		return flagValid;
	}
	
	public boolean doClearSession(){
		boolean flagValid = false;
		semmac001Bean = getSemmac001Bean();
		semmac001Bean.setMac001Srch(new Mac001Srch());
		semmac001Bean.setMac001SrchList(new ArrayList());
		semmac001Bean.setRenderButton(true);
		semmac001Bean.setExpenseTypeList(getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name));
		semmac001Bean.setDisabledBtnExport(true);
		semmac001Bean.setRenderedMsgDataNotFound(false);
		setSemmac001Bean(semmac001Bean);
		return flagValid;
	}
	
	public void selectAllRow(){
		try{
			boolean chkAll = getSemmac001Bean().isChkSelAll();
			List<WrapperBeanObject<Mac001Srch>> detailList = new ArrayList<WrapperBeanObject<Mac001Srch>>();
			detailList = getSemmac001Bean().getMac001SrchList();
			for(int i=0; i<detailList.size(); i++){
				detailList.get(i).setCheckBox(chkAll);
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
		log.info("tmpRowId :" + rowId);
		getSemmac001Bean().setTmpRowId(rowId);
		
		if(isCheckSELBox())
			getSemmac001Bean().setDisabledBtnExport(false);
		else
			getSemmac001Bean().setDisabledBtnExport(true);
	}
	
	private boolean isCheckSELBox(){
		boolean isCheck = false;
		List<WrapperBeanObject<Mac001Srch>> mac001SrchSP = getSemmac001Bean().getMac001SrchList();
		for (WrapperBeanObject<Mac001Srch> wrapperBeanObject : mac001SrchSP) {
			if(wrapperBeanObject.isCheckBox()){
				return true;
			}
		}
		return isCheck;
	}
	
	//Method onRender DropDownList ExpenseType
	public void onRenderExpenseType(){
		semmac001Bean  = getSemmac001Bean();
		if(!StringUtils.isEmpty(semmac001Bean.getMac001Srch().getModuleType())){
			semmac001Bean.setExpenseTypeList(getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name, EX_IN, null, semmac001Bean.getMac001Srch().getModuleType(), null));
		}else{
			semmac001Bean.setExpenseTypeList(getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name));
		}
		setSemmac001Bean(semmac001Bean);
	}
	
	public boolean initEdit(){
		boolean flagValid = false;
		semmac001Bean  = getSemmac001Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		for (WrapperBeanObject<Mac001Srch> temp : semmac001Bean.getMac001SrchList()) {
			Mac001Srch rt = (Mac001Srch)temp.getDataObj();
			if(rt.getRowId().equals(rowId)){
				semmac001Bean.getMac001pay().setRowId(rt.getRowId());
				semmac001Bean.getMac001pay().setPaymentType(rt.getPaymentType());
				semmac001Bean.getMac001pay().setPaymentMethod(rt.getPaymentMethod());
				semmac001Bean.getMac001pay().setChqDt(rt.getChqDt());
				semmac001Bean.getMac001pay().setChqReceiveDt(rt.getChqReceiveDt());
				
				//Show Only
				semmac001Bean.getMac001pay().setVendorCode(rt.getVendorCode());
				semmac001Bean.getMac001pay().setVendorName(rt.getVendorName());
				semmac001Bean.getMac001pay().setTotalAmt(rt.getTotalAmt());
				semmac001Bean.getMac001pay().setInvoiceNo(rt.getInvoiceNo());
				semmac001Bean.getMac001pay().setPayAmt(rt.getPayAmt());
			}
		}
		setSemmac001Bean(semmac001Bean);
		onRenderPaymentMethod();
		return flagValid;
	}
	
	public boolean doSaveAct(){
		boolean flagValid = false;
		semmac001Bean  = getSemmac001Bean();
		IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
		ISAPService sapService = (ISAPService)getBean("sapService");
		List<Mac001Act> to =null;
		String rowsIdConcat = "";
		String rowsIdConcatWrite = "";
		String tempPaymentGroup = "";
		try {
			
			List<WrapperBeanObject<Mac001Srch>> selectedMac001List = new ArrayList<WrapperBeanObject<Mac001Srch>>();
			for (WrapperBeanObject<Mac001Srch> temp : semmac001Bean.getMac001SrchList()) {
				Mac001Srch rt = (Mac001Srch)temp.getDataObj();
				if(temp.isCheckBox()){
					tempPaymentGroup = rt.getPaymentGroupNo();
				}else if(rt.getPaymentGroupNo() != null && rt.getPaymentGroupNo().equals(tempPaymentGroup)){
					temp.setCheckBox(true);
				}
				if(temp.isCheckBox() && rowsIdConcat.equals("")){
					rowsIdConcat = rt.getRowId();
					rowsIdConcatWrite = "'"+rt.getRowId()+"'";
				}
				else if(temp.isCheckBox() && !rowsIdConcat.equals("")){
					rowsIdConcat = rowsIdConcat+",".trim()+rt.getRowId();
					rowsIdConcatWrite = rowsIdConcatWrite+",".trim()+"'"+rt.getRowId()+"'";
				}
				if(temp.isCheckBox()){
					selectedMac001List.add(temp);
				}
			}
			
//			if(selectedMac001List.size()>0){
//				sapService.createTransactionToSAP(selectedMac001List,getEmployee(),semmac001Bean.getMac001Srch().getCompany());				
//			}			
			
			semmac001Bean.getMac001Act().setTransPaymentId(rowsIdConcat);
			semmac001Bean.getMac001Act().setActionType(semmac001Bean.getBtnApproveStatus());
			semmac001Bean.getMac001Act().setRemark(semmac001Bean.getRemark());
			semmac001Bean.getMac001Act().setUserId(getUserLogIn());
			to = pTaxMasterService.querySPList(EQueryName.SP_MAC001_ACT.name, semmac001Bean.getMac001Act());
			if (to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")) {
				addMessageInfo("M0001");
				
				log.info("get Mac001Act pass");
				//Write File SAP
				ssoBean = getSsoBean();
				UserProfile userPro = new UserProfile();
				userPro.setCreateby(getUserLogIn());	
				userPro.setEmail(getUserLogIn()+"@ais.co.th".trim());
				userPro.setFilename(to.get(0).getFilename());
				userPro.setUserId(getUserLogIn());
				
				GenFileFromSemCTTransSap genSap = new GenFileFromSemCTTransSap();
				genSap.doProcess(rowsIdConcatWrite, userPro);
				log.info("Write File not Error");
				//end
				
				semmac001Bean.setPopupClose(true);
			}else if(to != null && !to.isEmpty()){
				FrontMessageUtils.addMessageError(to.get(0).getpRemark());
				semmac001Bean.setPopupClose(true);
			}			   
			
			
			doSearch();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e);
			addMessageError("E0001");
			semmac001Bean.setPopupClose(false);
		}
		semmac001Bean.setRenderedMsgFormMiddle(true);
		semmac001Bean.setRenderedMsgFormSearch(false);
		setSemmac001Bean(semmac001Bean);
		return flagValid;
	}
	
	public boolean doSavePay(){
		boolean flag = false;
		semmac001Bean = getSemmac001Bean();
		if(!validateSave()){
			semmac001Bean.setPopupClose(new Boolean(false));
			return flag;
		}
		IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
		List<Mac001Pay> to =null;
		List<Mac001SrchD> to2 =null;
						
			//set value
			semmac001Bean.getMac001pay().setRowId(semmac001Bean.getMac001SrchD().getRowId());
			semmac001Bean.getMac001pay().setPaymentType(semmac001Bean.getMac001SrchD().getPaymentType());
			semmac001Bean.getMac001pay().setPaymentMethod(semmac001Bean.getMac001SrchD().getPaymentMethod());
			semmac001Bean.getMac001pay().setChqDt(semmac001Bean.getMac001SrchD().getChqDt());
			semmac001Bean.getMac001pay().setChqReceiveDt(semmac001Bean.getMac001SrchD().getChqReceiveDt());
			semmac001Bean.getMac001pay().setTransferDt(semmac001Bean.getMac001SrchD().getTransferDt());
			semmac001Bean.getMac001pay().setUserId(semmac001Bean.getUserLogin());
			
			try {
				to = pTaxMasterService.querySPList(EQueryName.SP_MAC001_PAY.name, semmac001Bean.getMac001pay());
				to2 = pTaxMasterService.querySPList(EQueryName.SP_MAC001_SRCH_D.name, semmac001Bean.getMac001SrchD());
				if (!to.isEmpty() && to.get(0).getResultMsg().equals("Success")) {
					semmac001Bean.setPopupClose(new Boolean(true));
					addMessageInfo("M0001");					
				}else{
					FrontMessageUtils.addMessageError(to.get(0).getpRemark());
				}
				
				if(semmac001Bean.getTmpStatusPage().equals("SEMMAC001")){
					doSearch();
				}
				semmac001Bean.setMac001SrchD(to2.get(0));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				addMessageError("E0001");
			}
			setSemmac001Bean(semmac001Bean);
		return flag;
	}
	
	private boolean validateSave() {
		boolean flgValid = true;
		Date chqDt = getSemmac001Bean().getMac001SrchD().getChqDt();
		Date chqReceiveDt = getSemmac001Bean().getMac001SrchD().getChqReceiveDt();
		Date transferDt = getSemmac001Bean().getMac001SrchD().getTransferDt();
		
		if(StringUtils.isEmpty(getSemmac001Bean().getMac001SrchD().getPaymentType())){
			addMessageError(("W0001"), msg("message.paymentType"));
			flgValid = false;
		}
		if(StringUtils.isEmpty(getSemmac001Bean().getMac001SrchD().getPaymentMethod())){
			addMessageError(("W0001"), msg("message.paymentMethod"));
			flgValid = false;
		}
		try{
			if(getSemmac001Bean().getMac001SrchD().getChqDt() == null){
				   if(getSemmac001Bean().isRenderedChqDt() == false){
					addMessageError(("W0001"), msg("message.chqDt"));
					flgValid = false;
				   }
				}else{
					if(SEMDataUtility.getCurrentDateByPattern().compareTo(chqDt)>0){
						addGeneralMessageError("ChqDt Before Today Date");
						flgValid = false;
					}
				}
				if(getSemmac001Bean().getMac001SrchD().getChqReceiveDt() == null){
				   if(getSemmac001Bean().isRenderedChqDt() == false){
					addMessageError(("W0001"), msg("message.chqReceiveDt"));
					flgValid = false;
				   }
				}else{
					if(SEMDataUtility.getCurrentDateByPattern().compareTo(chqReceiveDt)>0){
						addGeneralMessageError("ChqReCeiveDt Before Today Date");
						flgValid = false;
					}
				}
				if(getSemmac001Bean().getMac001SrchD().getTransferDt() == null){
					if(getSemmac001Bean().isRenderedTransferDt() == false){
					 addMessageError(("W0001"), msg("message.transferDt"));
					 flgValid = false;
					}
				}else{
					if(SEMDataUtility.getCurrentDateByPattern().compareTo(transferDt)>0){
						addGeneralMessageError("TransferDt Before Today Date");
						flgValid = false;
					}
				}
		}catch (Exception e) {
			// TODO: handle exception
		}		
		return flgValid;
	}
	
	public void onRenderPaymentMethod(){
		semmac001Bean = getSemmac001Bean();
		semmac001Bean.setRenderedChqDt(true);
		semmac001Bean.setRenderedTransferDt(true);
		semmac001Bean.setRenderedPaymentMethod(false);
		if(semmac001Bean.getMac001SrchD().getPaymentType() != null && semmac001Bean.getMac001SrchD().getPaymentType().equals("01")){
			semmac001Bean.setPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name, EX_IN, "CHEQUE", null, null));
			semmac001Bean.setRenderedChqDt(false);
			semmac001Bean.setDisablePaymentMethod(false);
			//Clear Text field
			semmac001Bean.getMac001SrchD().setTransferDt(null);
		}
		if(semmac001Bean.getMac001SrchD().getPaymentType() != null && semmac001Bean.getMac001SrchD().getPaymentType().equals("02")){
			semmac001Bean.setPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name, EX_IN, "TRANSFER", null, null));
			semmac001Bean.setRenderedTransferDt(false);
			semmac001Bean.setDisablePaymentMethod(false);
//			semmac001Bean.getMac001SrchD().setPaymentMethod("05");
			//addded by NEW 20150828 check null befor set default paymentMethod
			if(semmac001Bean.getMac001SrchD().getPaymentMethod() == null || 
					semmac001Bean.getMac001SrchD().getPaymentMethod().equals(""))
				semmac001Bean.getMac001SrchD().setPaymentMethod("05");
			//end added
			//Clear Text field
			semmac001Bean.getMac001SrchD().setChqDt(null);
			semmac001Bean.getMac001SrchD().setChqReceiveDt(null);
		}
		if(semmac001Bean.getMac001SrchD().getPaymentType() != null && semmac001Bean.getMac001SrchD().getPaymentType().equals("03")){
			semmac001Bean.setRenderedPaymentMethod(true);
			semmac001Bean.setDisablePaymentMethod(true);
//			semmac001Bean.getMac001SrchD().setPaymentMethod("");
			//addded by NEW 20150828 check null befor set default paymentMethod
			if(semmac001Bean.getMac001SrchD() == null || 
					semmac001Bean.getMac001SrchD().equals(""))
				semmac001Bean.getMac001SrchD().setPaymentMethod("");
			//end added
			//Clear Text field
			semmac001Bean.getMac001SrchD().setTransferDt(null);
			semmac001Bean.getMac001SrchD().setChqDt(null);
			semmac001Bean.getMac001SrchD().setChqReceiveDt(null);
		}
	}
	
	public boolean doResendFile(){
		boolean flagValid = false;
		semmac001Bean  = getSemmac001Bean();
		IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
		List<Mac001ReFile> to = null;
		String tmpFileName = "";
		String tmpFlag = "";
		String tempPaymentGroup = "";
		String rowsIdConcat = "";
		String rowsIdConcatWrite = "";
		List<String> tmpFileNameList = new ArrayList();
		for (WrapperBeanObject<Mac001Srch> temp : semmac001Bean.getMac001SrchList()) {
			Mac001Srch rt = (Mac001Srch)temp.getDataObj();
			if(temp.isCheckBox()){
				tempPaymentGroup = rt.getPaymentGroupNo();
			}else if(rt.getPaymentGroupNo() != null && rt.getPaymentGroupNo().equals(tempPaymentGroup)){
				temp.setCheckBox(true);
			}
			if(temp.isCheckBox() && rowsIdConcat.equals("")){
				rowsIdConcat = rt.getRowId();
				rowsIdConcatWrite = "'"+rt.getRowId()+"'";
			}
			else if(temp.isCheckBox() && !rowsIdConcat.equals("")){
				rowsIdConcat = rowsIdConcat+",".trim()+rt.getRowId();
				rowsIdConcatWrite = rowsIdConcatWrite+",".trim()+"'"+rt.getRowId()+"'";
			}
			
			tmpFileName = rt.getFileName();
			if(!StringUtils.isEmpty(tmpFileName)){
				if(tmpFileNameList.contains(rt.getFileName())){
					addGeneralMessageError("FileName is Duplicate ");
					tmpFlag = "N";
					break;
				}else{
					tmpFileNameList.add(rt.getFileName());
					tmpFlag = "Y";
				}
			}
		}
		
		if(tmpFlag.equals("Y")){
			try {
				semmac001Bean.getMac001ReFile().setRowId(rowsIdConcat);
//				to = pTaxMasterService.querySPList(EQueryName.SP_MAC001_RE_FILE.name, semmac001Bean.getMac001ReFile());
//				if(to.size() != 0 || to != null){
//					
//					UserProfile userPro = new UserProfile();
//					userPro.setCreateby(getUserLogIn());
//					userPro.setEmail(getUserLogIn()+"@ais.co.th".trim());
//					userPro.setFilename(to.get(0).getFileName());
//					userPro.setUserId(getUserLogIn());
//					
//					GenFileFromSemCTTransSap genSap = new GenFileFromSemCTTransSap();
//					genSap.doProcess(rowsIdConcatWrite, userPro);
//				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		setSemmac001Bean(semmac001Bean);
		return flagValid;
	}
	
	private boolean validateReSendFile() {
		boolean flgValid = true;
		
		return flgValid;
	}
	
	public boolean initApprove(){
		boolean flag = false;
		semmac001Bean = getSemmac001Bean();
		String btnApproveStatus = (String)getFacesUtils().getRequestParameter("btnApproveStatus");
		semmac001Bean.setBtnApproveStatus(btnApproveStatus);
		semmac001Bean.setRemark("");
		setSemmac001Bean(semmac001Bean);
		return flag;
	}
	
	public boolean doClearApproveStatus(){
		boolean flag = false;
		semmac001Bean = getSemmac001Bean();
		semmac001Bean.setBtnApproveStatus("");
		setSemmac001Bean(semmac001Bean);
		return flag;
	}
	
	public void doSearchR(){
		semmac001Bean = getSemmac001Bean();
		semmac001Bean.setMac001SrchR(new Mac001SrchR());
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		List<Mac001SrchR> to =null;
		IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
		semmac001Bean.getMac001SrchR().setTransPaymemtId(rowId);
		try {
			to = pTaxMasterService.querySPList(EQueryName.SP_MAC001_SRCH_R.name, semmac001Bean.getMac001SrchR());
			if(to.get(0).getPaymentStatusDt() != null){
				to.get(0).setPaymentStatusDt(SEMDataUtility.convertToThYear(to.get(0).getPaymentStatusDt()));
			}
			semmac001Bean.setMac001SrchR(to.get(0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setSemmac001Bean(semmac001Bean);
	}
	
	public void getRowIdOnClick() {
		String paymentGroupNo = (String)getFacesUtils().getRequestParameter("paymentGroupNo");
		getSemmac001Bean().setTmpRowId(paymentGroupNo);
	}
	
	public void doClearCheque(){
		FileUploadBean fileUpload = getFileUploadBean();
		
		DocumentImportManager<LoadClearCheque> docIM = new DocumentImportManager<LoadClearCheque>(LoadClearCheque.class, EnumDocumentType.XLS);
		docIM.setSkipRow(1);
		
		if(fileUpload.getFiles() != null && fileUpload.getFiles().size() > 0){
			docIM.setByteFile(fileUpload.getFiles().get(0).getData());
		}
		
		docIM.getObjectFromDocument();
		fileUpload.resetFiles();
		
		ILoadClearChequeService clearCheuqeService = (ILoadClearChequeService)getBean("loadClearChequeService");
		Collection<LoadClearCheque> listLc = docIM.geteObjectList();
		for(LoadClearCheque l : listLc){
			try {
				if(!clearCheuqeService.updateClearCheque(l)){
					log.info("cannot update Cheque No : "+l.getChequeNo());
				}
			} catch (Exception e) {
				log.info("error: "+e.getMessage()+"\n Config Cheque No : "+l.getChequeNo()+" cannot update to database.");
			}
		}
		addGeneralMessageInfo("Clear Cheques Complete.");
	}
	
	public boolean checkFileType(){
		String fileName = getFileUploadBean().getFiles() != null?getFileUploadBean().getFiles().get(0).getName():"";
		String[] fileType = getFileUploadBean().getAcceptedType().split(",");
		if(fileName.indexOf(".") != -1){
			for(String type :fileType){
				if(type.equals(fileName.substring(fileName.indexOf(".")+1))){
					return true;
				}
			}
		}
		getSemmac001Bean().setRenderedMsgFormTop(true);
		getSemmac001Bean().setRenderedMsgFormMiddle(false);
		addGeneralMessageError("File type not compatible, Please Upload file type ("+getFileUploadBean().getAcceptedType()+").");
		return false;
	}
	
	public void doImport(){
		FileUploadBean fileUpload = getFileUploadBean();

		// Create an ArrayList to store the data read from excel sheet.
		List sheetData1 = new ArrayList();
		FileInputStream fis = null;
		try {
			// Create a FileInputStream that will be use to read the
			// excel file.
			fis = new FileInputStream(fileUpload.getPathName() + "/" + fileUpload.getFileName());
			// Create an excel workbook from the file system.
			HSSFWorkbook workbook = new HSSFWorkbook(fis);
			// Get the first sheet on the workbook.
			HSSFSheet sheet1 = workbook.getSheetAt(0);
			// When we have a sheet object in hand we can iterator on
			// each sheet's rows and on each row's cells. We store the
			// data read on an ArrayList so that we can printed the
			// content of the excel to the console.
			Iterator rows = sheet1.rowIterator();
			while (rows.hasNext()) {
				HSSFRow row = (HSSFRow) rows.next();
				Iterator cells = row.cellIterator();
				List data = new ArrayList();
				while (cells.hasNext()) {
					HSSFCell cell = (HSSFCell) cells.next();
					data.add(cell);
				}
				sheetData1.add(data);
			}
	
	
			//Check DraftNo
			if(sheetData1.size() > 1){
				List<HSSFCell> list = (List) sheetData1.get(1);
				loadDataExcel(sheetData1);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			addGeneralMessageError("Wrong Excel format!");
		} catch (Exception e) {
			e.printStackTrace();
			addGeneralMessageError("Wrong Excel format!");
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
	
	private void loadDataExcel(List sheetData1) {
			List<HSSFCell> list = null;
			ILoadClearChqService iLoadClearChqService =  (ILoadClearChqService)getBean("loadClearChqService");
			Mac001LoadClearChq mac001Chq = new Mac001LoadClearChq();
			List<Mac001LoadClearChq> mac001LoadChqList = new ArrayList<Mac001LoadClearChq>();
			List<Mac001ClearChq> result;
			String chqNo;
			try{
				log.debug("Sheet1 Size = "+sheetData1.size());
				//Set Value In Model Sheet1
				for (int i = 1; i < sheetData1.size(); i++) {
					mac001Chq = new Mac001LoadClearChq();
					list = (List) sheetData1.get(i);
//					irDraft = new IrDraft();
//					log.debug("(Double)getValueFromCell(list.get(0) = "+(Double)getValueFromCell(list.get(0)));
					chqNo = getValueFromCell(list.get(0),AISConstant.STRING_TYPE).toString();
					if(chqNo.indexOf(".") != -1){
						chqNo = chqNo.substring(0, chqNo.indexOf("."));
					}
					mac001Chq.setRecordStatus("A");
					mac001Chq.setChqNo(chqNo);
					mac001LoadChqList.add(mac001Chq);
				}
				log.debug("iLoadClearChqService = "+iLoadClearChqService);
				if(iLoadClearChqService.importLoadClearChq(mac001LoadChqList)){
					result = iLoadClearChqService.querySPList(EQueryName.SP_MAC001_CLEAR_CHQ.name, new Mac001ClearChq());
					if(result != null && result.size() > 0){
						if("Success".equals(result.get(0).getpResult())){
							addMessageInfo("M0001");
						}else{
							iLoadClearChqService.deleteLoadClearChq();
							FrontMessageUtils.addMessageError(result.get(0).getpRemark());
						}
					}
				}
				
//				log.debug("irDraftList.size() = "+irDraftList.size());
//				log.debug("irDraftDetailList.size() = "+irDraftDetailList.size());
//				log.debug("irPolicySumList.size() = "+irPolicySumList.size());
//				log.debug("Start update irDraft");
//				if(iIrDraftService.updateImportFile(irDraft, irDraftDetailList, irPolicySumList)){
//					log.debug("Start Call PL SP_MIR008_SAVE");
//					Policy policy = new Policy();
//					policy.setDraftNo(getSemmir008Bean().getPolicyInfo().getDraftNo());
//					List<Policy> result = new ArrayList<Policy>();
//					result = iIrDraftService.querySPList(EQueryName.SP_MIR008_SAVE.name, policy);
//					
//					if (result != null && !result.isEmpty() && result.get(0).getpResult().equals("Success")) {
//						addMessageInfo("M0001");
//					}else if(result != null && !result.isEmpty()){
//						FrontMessageUtils.addMessageError(result.get(0).getpRemark());
//					}
//				}
				log.debug("End Import");
			}catch (Exception e) {
				log.error("Error Import File");
				addMessageInfo("E0004");
				e.printStackTrace();
			}
		}
	
//	private Object getValueFromCell(HSSFCell cell){
//		Object o = null;
//		if(cell != null){
//			switch (cell.getCellType()) {
//				case Cell.CELL_TYPE_STRING:
//					o = cell.getRichStringCellValue().getString();
//					break;
//				case Cell.CELL_TYPE_NUMERIC:
//					o = cell.getNumericCellValue();
//					break;
//				case Cell.CELL_TYPE_BLANK:
//					break;
//				case Cell.CELL_TYPE_BOOLEAN:
//					break;
//				case Cell.CELL_TYPE_FORMULA:
//					break;
//				default:;
//			}
//		}else{
//			log.debug("Cell Is Null");
//		}
//		return o;
//	}
	
	
	// -> popup add vendor
	public void initAddVendor(){
		log.info("-- initPopupAddVendor --");

		SEMMAC001Bean mac001Bean = getSemmac001Bean();

		try {
			
			doClearPopupAddVendor();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmac001Bean(mac001Bean);
	}
	
	public void doSearchPopupAddVendor(){
		log.info("-- doSearchPopupAddVendor --");

		SEMMAC001Bean mac001Bean = getSemmac001Bean();

		try {
			
			//String strVendorCode = mac001Bean.getVendorMasterPopupObjParam().getVendorCode();
			//String strVendorName = mac001Bean.getVendorMasterPopupObjParam().getVendorName();


			IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
			List<VendorMasterSP> vendorMasterList = null;
			
			mac001Bean.setVendorMasterPopupList(new ArrayList<WrapperBeanObject<VendorMasterSP>>());
			
			vendorMasterList = service.queryVendorMasterSPList(EQueryName.SP_GET_MAP_VENDOR.name, mac001Bean.getVendorMasterPopupObjParam());
			if(vendorMasterList != null && !vendorMasterList.isEmpty()){
				 for(int i=0; i<vendorMasterList.size(); i++){
					VendorMasterSP vm = (VendorMasterSP)vendorMasterList.get(i);
					WrapperBeanObject<VendorMasterSP> tmpWrapperBean = new WrapperBeanObject<VendorMasterSP>();
					
					tmpWrapperBean.setDataObj(vm);
					tmpWrapperBean.setMessage("");
					mac001Bean.getVendorMasterPopupList().add(tmpWrapperBean);
					
					mac001Bean.setRenderedMsgDataNotFound(false);
				 }
			 } else {
				 mac001Bean.setRenderedMsgDataNotFound(true);
			 }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmac001Bean(mac001Bean);
	}
	
	public void doClearPopupAddVendor(){
		log.info("-- doClearPopupAddVendor --");

		SEMMAC001Bean mac001Bean = getSemmac001Bean();

		try {
			
			mac001Bean.getVendorMasterPopupObjParam().setVendorCode("");
			mac001Bean.getVendorMasterPopupObjParam().setVendorName("");
			mac001Bean.setVendorMasterPopupList(new ArrayList<WrapperBeanObject<VendorMasterSP>>());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmac001Bean(mac001Bean);
	}
	
	public void doSelectPopupAddVendor(){
		log.info("-- doSelectPopupAddVendor --");

		SEMMAC001Bean mac001Bean = getSemmac001Bean();

		try {
			
			String paramVendorCode = getFacesUtils().getRequestParameter("paramVendorCode") == null ? "" : 
							  (String)getFacesUtils().getRequestParameter("paramVendorCode");
			String paramVendorName = getFacesUtils().getRequestParameter("paramVendorName") == null ? "" : 
				  (String)getFacesUtils().getRequestParameter("paramVendorName");
			
			mac001Bean.getMac001Srch().setVendorCode(paramVendorCode);
//			mac001Bean.getMac001Srch().setVendorName(paramVendorName);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmac001Bean(mac001Bean);
	}
	// <- popup add vendor
}
