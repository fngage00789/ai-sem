package th.co.ais.web.el.action;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import th.co.ais.domain.cp.PopupVendorSupplierSearchSP;
import th.co.ais.domain.el.ELVerifyCondSP;
import th.co.ais.domain.el.ElGroupSP;
import th.co.ais.domain.el.ElPrivateValidateSP;
import th.co.ais.domain.el.ElUseTypeDetailSP;
import th.co.ais.domain.el.ElVerifySP;
import th.co.ais.domain.el.InstallmentDataDetail;
import th.co.ais.domain.el.InstallmentSearch7;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.ManagementWrapper;
import th.co.ais.domain.el.MeterInfo;
import th.co.ais.domain.el.MeterInstallment;
import th.co.ais.domain.el.Payment;
import th.co.ais.domain.el.PaymentDefault;
import th.co.ais.domain.el.PaymentDetail;
import th.co.ais.domain.el.PaymentSearch;
import th.co.ais.domain.el.PopupOldDocSearch;
import th.co.ais.domain.el.PopupOldDocSearch7;
import th.co.ais.domain.el.PopupSiteSearch;
import th.co.ais.domain.el.PopupSiteSearch7;
import th.co.ais.domain.el.PopupSiteSearchPrivate;
import th.co.ais.domain.el.PrivatePrepaid;
import th.co.ais.domain.el.UploadText;
import th.co.ais.domain.el.VendorMapPayeeEL;
import th.co.ais.domain.el.VendorSP;
import th.co.ais.domain.gm.Bank;
import th.co.ais.domain.gm.ParameterConfig;
import th.co.ais.domain.gm.PayeeBookbank;
import th.co.ais.domain.gm.VendorBookbank;
import th.co.ais.domain.gm.VendorMasterSP;
import th.co.ais.domain.sa.SiteAppSP;
import th.co.ais.service.el.IManagementService;
import th.co.ais.service.el.IMeterInfoService;
import th.co.ais.service.el.IMeterInstallmentService;
import th.co.ais.service.el.IPaymentDefaultService;
import th.co.ais.service.el.IPaymentDetailService;
import th.co.ais.service.el.IPaymentService;
import th.co.ais.service.el.IVendorMapPayeeELService;
import th.co.ais.service.gm.IBankService;
import th.co.ais.service.gm.IVendorBookbankService;
import th.co.ais.service.gm.IVendorMasterService;
import th.co.ais.service.sa.ISiteAcquistionService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.SsoBean;
import th.co.ais.web.bean.common.PopupVendorSupplierBean;
import th.co.ais.web.common.action.PopupVendorSupplierAction;
import th.co.ais.web.cp.bean.SEMMCP001Bean;
import th.co.ais.web.el.bean.SEMMEL005Bean;
import th.co.ais.web.el.bean.SEMMEL006Bean;
import th.co.ais.web.util.CompanyCacheUtil;
import th.co.ais.web.util.ELMessageUtil;
import th.co.ais.web.util.ELUtils;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.LOVCacheUtil;
import th.co.ais.web.util.MSGCacheUtil;
import th.co.ais.web.util.ProvinceCacheUtil;
import th.co.ais.web.util.RegionCacheUtil;
import th.co.ais.web.util.SemUtils;
import th.co.ais.web.util.config.ParameterConfigUtil;


public class SEMMEL006Action extends AbstractAction {
	Logger logger = Logger.getLogger(SEMMEL006Action.class);
	private static final String WHT_TYPE_ABSORB = "01";
	private static final String WHT_TYPE_NONE_ABSORB = "02";
	private static final ResourceBundle RS_BUNDLE 	= ResourceBundle.getBundle("resources.el.semmel006");
	private static final String VENDOR_TYPE_VENDOR = "V";
	private static final String VENDOR_TYPE_SUPPLIER = "S";
	private static final String VATTYPE_NONEVAT = "03";
	private static final String PAYMENT_TYPE_CHECK = "01";
	private static final String PAYMENT_TYPE_TRANS = "02";
	private SEMMEL005Bean semmel005Bean;
	
	@Override
	public void init() {	
		logger.debug(" -- init--");
		try{
			SEMMEL006Bean semmel006Bean = new SEMMEL006Bean();
			PaymentSearch criteria = new PaymentSearch();	
			semmel006Bean.setCriteria(criteria);			 
			semmel006Bean.setCompanyList(CompanyCacheUtil.getInstance().getCompanySelItemsALL());
			semmel006Bean.setElectricUseTypeList(ELUtils.filterLOVByLOVValue("4", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name)));
			semmel006Bean.setElExpenseTypeList(ELUtils.filterLOVByLOVValue("3", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name)));		
			semmel006Bean.setElDocTypeList(ELUtils.filterLOVByLOVValue("3", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DOC_TYPE.name)));			
			semmel006Bean.setCtPaymentTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_TYPE.name));	
			semmel006Bean.setCtPaymentMethodList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name));			
			semmel006Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
			semmel006Bean.setSearchDisplayMode(semmel006Bean.getCriteria().getExpenseType());
			semmel006Bean.setMonthList(ELUtils.getMonthDropDownList());
			semmel006Bean.setYearList(ELUtils.getYearDropDownList());
			semmel006Bean.setRecordStatusList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_OUTSTANDING_FLAG.name));	
			semmel006Bean.setConfirmDeleteMsg( MSGCacheUtil.getInstance().getMessageByCode("EL0004"));
			semmel006Bean.setPopupDelMsg( MSGCacheUtil.getInstance().getMessageByCode("EL0004"));		
			semmel006Bean.setPopupEditMsg( MSGCacheUtil.getInstance().getMessageByCode("EL0003"));
			semmel006Bean.setVendorIdList(getEmptyDropDown());
			semmel006Bean.setDisableMoreThanOneDetail(false);		
			semmel006Bean.setViewMode(false);
			//WT###Add 20110202 Start
			semmel006Bean.setVendorTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_VENDOR_TYPE.name));
			for(int i=semmel006Bean.getVendorTypeList().size()-1;i>=0;i--){
				
				SelectItem selItem = semmel006Bean.getVendorTypeList().get(i);
				
				if(selItem.getValue() == null || selItem.getValue().toString().trim().length() == 0){
					
					semmel006Bean.getVendorTypeList().remove(i);
				}
			}
			semmel006Bean.setPayment(new Payment());
			semmel006Bean.getPayment().setVendorType(VENDOR_TYPE_VENDOR);
			PopupVendorSupplierBean  popupVendorSupplierBean= new PopupVendorSupplierBean();
			popupVendorSupplierBean.setPopupVendorSupplierSearchSP(new PopupVendorSupplierSearchSP());
			popupVendorSupplierBean.setPostTypeList(getLovItemsByType(ELovType.T_CP_POST_TYPE.name));
			popupVendorSupplierBean.setConstructTypeList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_TYPE.name));
			popupVendorSupplierBean.setConstructStatusList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_STATUS.name).subList(0, 1));
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupVendorSupplierBean",popupVendorSupplierBean);
			//WT###Add 20110202 End
			semmel006Bean.setDisableVendorTypeButton(true);//WT###Add 20110203
			setSemmel006Bean(semmel006Bean);
			
		}catch(Exception ex){
			ex.printStackTrace();			
		}
	}

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		logger.debug(" -- actionWithNavi-- :"+methodWithNavi);
		boolean flag = false;		
		
		// #####################  Search ElectricPaymentHistory ##################### 
		if (methodWithNavi.equalsIgnoreCase("doSearch")) {
			flag = doSearch();			
		}else if (methodWithNavi.equalsIgnoreCase("doClearSession")) {
				flag = doClearSession();	
		}else if (methodWithNavi.equalsIgnoreCase("doBackSearchPage")) {
			flag = doBackSearchPage();
		} else if (methodWithNavi.equalsIgnoreCase("doClear")) {
			flag = doClear();					
		} else if (methodWithNavi.equalsIgnoreCase("doShow")) {
			flag = doShow();					
			
			
		// #####################  PaymentELBill ########################
		}else if (methodWithNavi.equalsIgnoreCase("initPaymentELBill")) {
			flag = initPaymentELBill();
		}else if(methodWithNavi.equalsIgnoreCase("initAddNewSite")){
			flag=initAddNewSite();
		}else if(methodWithNavi.equalsIgnoreCase("doAddNotExpenseSite")){
			flag=doAddNotExpenseSite();
		}else if(methodWithNavi.equalsIgnoreCase("exportNoPayment")){
			flag=exportNoPayment();		
		}else if(methodWithNavi.equalsIgnoreCase("doCheckMeterExist")){
			flag=doCheckMeterExist();	
		}else if(methodWithNavi.equalsIgnoreCase("doClearNotExpenseSite")){
			flag=doClearNotExpenseSite();
		}else if(methodWithNavi.equalsIgnoreCase("initDeleteNotExpenseSite")){
			flag=initDeleteNotExpenseSite();						
		}else if(methodWithNavi.equalsIgnoreCase("doDeleteNotExpenseSite")){
			flag=doDeleteNotExpenseSite();			
		}else if(methodWithNavi.equalsIgnoreCase("doSaveELBill")){
			flag=doSaveELBill();	
		} else if (methodWithNavi.equalsIgnoreCase("doShow2")) {
			flag = doShow2();				
			
			
		// #####################   EL_Postpaid ##################### 
		}else if (methodWithNavi.equalsIgnoreCase("initPaymentELPostpaid")) {
			flag = initPaymentELPostpaid();
		}else if (methodWithNavi.equalsIgnoreCase("initPopupSearchSiteELPostpaid")) {
			flag = initPopupSearchSiteELPostpaid();	
		}else if (methodWithNavi.equalsIgnoreCase("doSearchSiteELPostpaid")) {
			flag = doSearchSiteELPostpaid();	
		}else if (methodWithNavi.equalsIgnoreCase("doClearSearchSiteELPostpaid")) {
			flag = doClearSearchSiteELPostpaid();	
		}else if (methodWithNavi.equalsIgnoreCase("doAddSiteELPostpaid")) {
			flag = doAddSiteELPostpaid();	
		}else if (methodWithNavi.equalsIgnoreCase("initPopupSearchOldDoc")) {
			flag = initPopupSearchOldDoc();				
		}else if (methodWithNavi.equalsIgnoreCase("doSearchPopupOldDoc")) {
			flag = doSearchPopupOldDoc();	
		}else if (methodWithNavi.equalsIgnoreCase("doClearSearchOldDoc")) {
			flag = doClearSearchOldDoc();	
		}else if (methodWithNavi.equalsIgnoreCase("doAddOldDoc")) {
			flag = doAddOldDoc();				
		}else if (methodWithNavi.equalsIgnoreCase("doAddELPostpaidToModel")) {
			flag = doAddELPostpaidToModel3();	
		}else if (methodWithNavi.equalsIgnoreCase("initDeleteELPostpaidFromModel")) {
			flag = initDeleteELPostpaidFromModel();	
		}else if (methodWithNavi.equalsIgnoreCase("doDeleteELPostpaidFromModel")) {
			flag = doDeleteELPostpaidFromModel();	
		}else if (methodWithNavi.equalsIgnoreCase("initUPdateELPostpaidFromModel")) {
			flag = initUPdateELPostpaidFromModel();				
		}else if (methodWithNavi.equalsIgnoreCase("doUPdateELPostpaidFromModel")) {
			flag = doUPdateELPostpaidFromModel();	
		}else if (methodWithNavi.equalsIgnoreCase("doUPdateELPostpaidToModel")) {
			flag = doUPdateELPostpaidToModel();							
		}else if (methodWithNavi.equalsIgnoreCase("doUpdateELPostpaid")) {
			flag = doUpdateELPostpaid();	
		}else if (methodWithNavi.equalsIgnoreCase("doClearELPostpaid")) {
			flag = doClearELPostpaid();		
		}else if(methodWithNavi.equalsIgnoreCase("doSaveELPostpaid")){
			flag=doSaveELPostpaid();
		}else if(methodWithNavi.equalsIgnoreCase("initPopupPercentGrowth")){
			flag=initPopupPercentGrowth();
		}else if(methodWithNavi.equalsIgnoreCase("initPopupGroupMeter")){
			flag=initPopupGroupMeter();
			
			
		// #####################   EL_Temp ##################### 
		}else if (methodWithNavi.equalsIgnoreCase("initPaymentELTemporary")) {
			flag = initPaymentELTmp();
		}else if (methodWithNavi.equalsIgnoreCase("initPopupSearchSiteELTmp")) {
			flag = initPopupSearchSiteELTmp();	
		}else if (methodWithNavi.equalsIgnoreCase("doAddSiteELTmp")) {
			flag = doAddSiteELTmp();
		}else if (methodWithNavi.equalsIgnoreCase("doSearchPopupSiteELTmp")) {
			flag = doSearchPopupSiteELTmp();
		}else if (methodWithNavi.equalsIgnoreCase("doClearSearchSiteELTmp")) {
			flag = doClearSearchSiteELTmp();								
		}else if (methodWithNavi.equalsIgnoreCase("doAddPaymentDetailToModel")) {	
			flag = doAddPaymentDetailToModel(ELUtils.EL_TEMP);
		}else if (methodWithNavi.equalsIgnoreCase("initDeletePaymentDetailFromModel")) {
			flag = initDeletePaymentDetailFromModel();	
		}else if (methodWithNavi.equalsIgnoreCase("doDeletePaymentDetailFromModel")) {
			flag = doDeletePaymentDetailFromModel();	
		}else if (methodWithNavi.equalsIgnoreCase("initUPdatePaymentDetailFromModel")) {
			flag = initUPdatePaymentDetailFromModel();				
		}else if (methodWithNavi.equalsIgnoreCase("doUPdatePaymentDetailFromModel")) {
			flag = doUPdatePaymentDetailFromModel();	
		}else if (methodWithNavi.equalsIgnoreCase("doUPdatePaymentDetailToModel")) {
			flag = doUPdatePaymentDetailToModel(ELUtils.EL_TEMP);			
		}else if (methodWithNavi.equalsIgnoreCase("doClearPaymentDetail")) {
			flag = doClearPaymentDetailELTemp();					
		}else if (methodWithNavi.equalsIgnoreCase("doClearELTmp")) {
			flag = doClearELTmp();		
		}else if(methodWithNavi.equalsIgnoreCase("doSaveELTmp")){
			flag=doSaveELTmp();		
		}else if(methodWithNavi.equalsIgnoreCase("doVerify")){
			flag=doVerify();

			
			
			
		// #####################  PR_Postpaid and  PR_Prepaid ##################### ##################### 
		}else if (methodWithNavi.equalsIgnoreCase("initPaymentPRPostpaid")) {
			flag = initPaymentPRPostpaid();	
		}else if (methodWithNavi.equalsIgnoreCase("doAddPRPostpaidToModel")) {			
			flag =doAddPaymentDetailToModelPRPostpaid();
		}else if (methodWithNavi.equalsIgnoreCase("doUpdatePRPostpaid")) {					
			flag =doUPdatePaymentDetailToModelPRPospaid();
		}else if (methodWithNavi.equalsIgnoreCase("doSavePRPostpaid")) {			
			flag = doSavePRPostpaid5();
		} else if (methodWithNavi.equalsIgnoreCase("doShowPage5")) {
			flag = doShowPage5();				
		}else if (methodWithNavi.equalsIgnoreCase("doDeletePaymentDetailFromModel5")) {
			flag = doDeletePaymentDetailFromModel5();	
		}else if (methodWithNavi.equalsIgnoreCase("initPaymentPRPrepaid")) {
			flag = initPaymentPRPrepaid();
		}else if (methodWithNavi.equalsIgnoreCase("initPaymentPRPrepaidFromPage7")) {
			flag = initPaymentPRPrepaidFromPage7();
		}else if (methodWithNavi.equalsIgnoreCase("initPopupSearchSitePR")) {	
			flag = initPopupSearchSitePR();
		}else if (methodWithNavi.equalsIgnoreCase("doSearchSitePR")) {	
			flag = doSearchSitePRPrepaid();				
		}else if (methodWithNavi.equalsIgnoreCase("doSearchSitePRPostpaidByPL")) {	
			flag = doSearchSitePRPostpaidByPL();				
		}else if (methodWithNavi.equalsIgnoreCase("doSearchSitePRPrepaidByPL")) {	
			flag = doSearchSitePRPrepaidByPL();				
		}else if (methodWithNavi.equalsIgnoreCase("doSearchSitePR6")) {	
			flag = doSearchSitePRPrepaid6();	
		}else if (methodWithNavi.equalsIgnoreCase("doClearSearchSitePR")) {	
			flag = doClearSearchSitePR();
		}else if (methodWithNavi.equalsIgnoreCase("doAddSitePR")) {			
			flag = doAddSitePR();
		}else if (methodWithNavi.equalsIgnoreCase("initPopupSearchInstallment")) {
			flag = initPopupSearchInstallment();	
		}else if (methodWithNavi.equalsIgnoreCase("doAddInstallment")) {
			flag = doAddInstallment();
			
			
		}else if (methodWithNavi.equalsIgnoreCase("doSavePRPrepaid")) {			
			flag = doSavePRPrepaid6();
		}else if (methodWithNavi.equalsIgnoreCase("doEditFromMenu8")) {			
			flag = doEditFromMenu8();
			
			
		// #################### Edit #####################
		}else if (methodWithNavi.equalsIgnoreCase("initialEdit3")) {			
			flag = initialEdit3();	
		}else if (methodWithNavi.equalsIgnoreCase("initailEdit4")) {			
			flag = initailEdit4();	
		}else if (methodWithNavi.equalsIgnoreCase("initailEdit5")) {			
			flag = initailEdit5();	
		}else if (methodWithNavi.equalsIgnoreCase("initialEdit6")) {			
			flag = initailEdit6();		
			
		// #################### Back From MeterInfo #####################	
		}else if (methodWithNavi.equalsIgnoreCase("backFromViewMeterInfo")) {			
			flag = backFromViewMeterInfo();	
			
			
		}else if (methodWithNavi.equalsIgnoreCase("doAddSite4PRPrepaid")) {			
			flag = doAddSite4PRPrepaid();
		}else if (methodWithNavi.equalsIgnoreCase("initEditFromUploadText")) {			
			flag = initEditFromUploadText();
			
			
	  // #####################   7  ##################### 
		}else if (methodWithNavi.equalsIgnoreCase("initPayment7")) {
			flag = initPayment7();
		}else if (methodWithNavi.equalsIgnoreCase("doSave7")) {
			flag = doSave7();			
		}else if (methodWithNavi.equalsIgnoreCase("initPopupSearchSite7")) {
			flag = initPopupSearchSite7();				
		}else if (methodWithNavi.equalsIgnoreCase("doSearchPopupSite7")) {
			flag = doSearchPopupSite7();			
		}else if (methodWithNavi.equalsIgnoreCase("doClearSearchSite7")) {
			flag = doClearSearchSite7();		
		}else if (methodWithNavi.equalsIgnoreCase("initPopupSearchOldDoc7")) {
			flag = initPopupSearchOldDoc7();				
		}else if (methodWithNavi.equalsIgnoreCase("doClearSearchOldDoc7")) {
			flag = doClearSearchOldDoc7();			
		}else if (methodWithNavi.equalsIgnoreCase("doSearchPopupOldDoc7")) {
			flag = doSearchPopupOldDoc7();			
			
			
		}else if (methodWithNavi.equalsIgnoreCase("initPaymentUploadText")) {			
			flag = initPaymentUploadText();
		}else if (methodWithNavi.equalsIgnoreCase("doAddSite7")) {			
			flag = doAddSite7();
		}else if (methodWithNavi.equalsIgnoreCase("doInitPopupSearchSite7")) {			
			flag = doInitPopupSearchSite7();
		}else if (methodWithNavi.equalsIgnoreCase("doAddOldDoc7")) {			
			 flag = doAddOldDoc7();		
		}else if (methodWithNavi.equalsIgnoreCase("initDeletePaymentDetailPage7")) {			
			 flag = initDeletePaymentDetailPage7();		
		
		}else if (methodWithNavi.equalsIgnoreCase("doDeletePaymentDetailPage7")) {			
			 flag = doDeletePaymentDetailPage7();		
		
		}else if (methodWithNavi.equalsIgnoreCase("initialEditPage7")) {			
			flag = initialEditPage7();		 	 
		}else if (methodWithNavi.equalsIgnoreCase("doUpdate7")) {			
			flag = doUpdate7();	
		}else if (methodWithNavi.equalsIgnoreCase("initEditPayment7")) {			
			flag = initEditPayment7();	
			
		}else if (methodWithNavi.equalsIgnoreCase("doSearchInstallment7")) {			
			flag = doSearchInstallment7();	
			
		}else if (methodWithNavi.equalsIgnoreCase("doClearSearchInstallment7")) {			
			flag = doClearSearchInstallment7();	
			
		}else if (methodWithNavi.equalsIgnoreCase("initEditInstallmentPage7")) {			
			flag = initEditInstallmentPage7();
		}else if (methodWithNavi.equalsIgnoreCase("doUpdateMeterInstallment7")) {			
			flag = doUpdateMeterInstallment7();
		}else if (methodWithNavi.equalsIgnoreCase("doBackMeterInstallment7")) {			
			flag = doBackMeterInstallment7();
				
		}else if(methodWithNavi.equalsIgnoreCase("initAddVendor")){
			initAddVendor();
		}else{
		
			logger.debug(" ############# No matching Method ###### "+methodWithNavi);
		}		
		return flag;
	}
	
	//WT###Add 20110202 Start
	public void doClickVendorType(){
		logger.info("START Action doClickVendorType");
		try{
			semmel006Bean = getSemmel006Bean();
			//WT###Add 20110203 Start
			Payment payment = semmel006Bean.getPayment();
			if(payment!=null){
				if(VENDOR_TYPE_VENDOR.equals(payment.getVendorType())){
					payment.setVendorId(payment.getOldVendorIdTypeV());
					payment.setVendorName(payment.getOldVendorNameTypeV());
					payment.setPayeeId(payment.getOldPayeeIdTypeV());
					payment.setPayeeName(payment.getOldPayeeNameTypeV());
					
					payment.setPaymentMethod(payment.getOldPaymentMethodTypeV());
					payment.setPaymentType(payment.getOldPaymentTypeTypeV());
					payment.setBankAccount(payment.getOldBankAccountTypeV());
					payment.setBankName(payment.getOldBankNameTypeV());
					
					semmel006Bean.setPaymentMethodDisable(semmel006Bean.isOldPaymentMethodDisableTypeV());
				}
				if(VENDOR_TYPE_SUPPLIER.equals(payment.getVendorType())){
					payment.setVendorId(payment.getOldVendorIdTypeS());
					payment.setVendorName(payment.getOldVendorNameTypeS());
					payment.setPayeeId(payment.getOldPayeeIdTypeS());
					payment.setPayeeName(payment.getOldPayeeNameTypeS());
					
					payment.setPaymentMethod(payment.getOldPaymentMethodTypeS());
					payment.setPaymentType(payment.getOldPaymentTypeTypeS());
					payment.setBankAccount(payment.getOldBankAccountTypeS());
					payment.setBankName(payment.getOldBankNameTypeS());
					
					semmel006Bean.setPaymentMethodDisable(semmel006Bean.isOldPaymentMethodDisableTypeS());
				}
			}
			//WT###Add 20110203 End
			logger.info("END Action doClickVendorType");
		}catch(Exception e){
			e.printStackTrace();
			logger.info("ERROR Action doClickVendorType");
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMEL006");
			FrontMessageUtils.addMessageError(errorMsg);
		}
	}
	//WT###Add 20110202 End
	

	//  ---------------- Search ElectricPaymentHistory -------------------------------	

	//   ---------------- PaymentELBill-------------------------------
	private boolean initPaymentELBill() {
		logger.debug(" -- initPaymentELBill--");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();			
			initialData();
			Payment payment = semmel006Bean.getPayment();
			
			payment.setExpenseType("EL_BILL");		
			payment.setVatType("01");
			payment.setCompany("");
			payment.setElectricUseType("");
			
			semmel006Bean.setElectricUseTypeList(ELUtils.filterLOVByLOVValue("2", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name)));			
			semmel006Bean.setElExpenseTypeList(ELUtils.filterLOVByLOVValue("7", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name)));		
			semmel006Bean.setElDocTypeList(ELUtils.filterLOVByLOVValue("3", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DOC_TYPE.name)));
			payment.setExpenseTypeDisplay(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name), "EL_BILL"));	
			payment.setDocType("I");	
			payment.setPaymentType("01");
			if (payment.getCreateDt()!=null){
				payment.setDisplayCreateDate(SEMDataUtility.convertToThYear(payment.getCreateDt()));
			}
			if (payment.getUpdateDt()!=null){
				payment.setDisplayUpdateDate(SEMDataUtility.convertToThYear(payment.getUpdateDt()));
			}
			semmel006Bean.getPayment().setPaymentMethod(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.CT_PAYMENT_METHOD));//WT###Add 20110207
			Map<String,String> codeMap = new HashMap();
//			codeMap.put(ELUtils.PAYMENT_METHOD_01,ELUtils.PAYMENT_METHOD_01);
//			codeMap.put(ELUtils.PAYMENT_METHOD_02,ELUtils.PAYMENT_METHOD_02);
//			codeMap.put(ELUtils.PAYMENT_METHOD_03,ELUtils.PAYMENT_METHOD_03);
//			codeMap.put(ELUtils.PAYMENT_METHOD_04,ELUtils.PAYMENT_METHOD_04);
//			semmel006Bean.setCtPaymentMethodList(ELUtils.getLOVBtLOVCodeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name), codeMap));
			semmel006Bean.setCtPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name,EX_AND,"CHEQUE",null,null));
			semmel006Bean.setTransferDtDisable(true);
			
			semmel006Bean.setNotExpenseSite(new PaymentDetail());
			semmel006Bean.setNotExpenseSiteList(new ArrayList());
			PopupSiteSearch popupSiteCriteria = new PopupSiteSearch();
			semmel006Bean.setPopupSiteCriteria(popupSiteCriteria);
			semmel006Bean.setDisabledBtnExport(true);
			semmel006Bean.setViewMode(false);			
			semmel006Bean.setPaymentMethodDisable(false);
			semmel006Bean.setChqPostingDtDisable(false);
			semmel006Bean.setChqReceivedDtDisable(false);
			flagValid = true;			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flagValid;		
	}

	
	public boolean changeElectricUseType_ELBill(){			
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			String electricUseType = semmel006Bean.getPayment().getElectricUseType();
			logger.debug(" -- changeElectricUseType_ELBill to :"+electricUseType);
			if(electricUseType!=null){
				//PEA	:	���俿����ǹ�����Ҥ
				if(ELUtils.ELECTRIC_TYPE_PEA.equals(electricUseType)){
					semmel006Bean.getPayment().setVendorId(ELUtils.getParaValueStringbyCode(ELUtils.EL_PEA_VENDOR_ID));
					semmel006Bean.getPayment().setVendorName(ELUtils.getParaValueStringbyCode(ELUtils.EL_PEA_VENDOR_NAME));
					semmel006Bean.getPayment().setPayeeId(ELUtils.getParaValueStringbyCode(ELUtils.EL_PEA_PAYEE_MASTER_ID));
					semmel006Bean.getPayment().setPayeeName(ELUtils.getParaValueStringbyCode(ELUtils.EL_PEA_PAYEE_NAME));
					semmel006Bean.setElExpenseTypeList(ELUtils.getExpenseTyePEAList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name)));
				//MEA	:	���俿�ҹ����ǧ
				}else if (ELUtils.ELECTRIC_TYPE_MEA.equals(electricUseType)){
					semmel006Bean.getPayment().setVendorId(ELUtils.getParaValueStringbyCode(ELUtils.EL_MEA_VENDOR_ID));
					semmel006Bean.getPayment().setVendorName(ELUtils.getParaValueStringbyCode(ELUtils.EL_MEA_VENDOR_NAME));
					semmel006Bean.getPayment().setPayeeId(ELUtils.getParaValueStringbyCode(ELUtils.EL_MEA_PAYEE_MASTER_ID));
					semmel006Bean.getPayment().setPayeeName(ELUtils.getParaValueStringbyCode(ELUtils.EL_MEA_PAYEE_NAME));
					semmel006Bean.setElExpenseTypeList(ELUtils.getExpenseTyeMEAList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name)));

				}else{
					logger.debug("  No Matching EL_ELECTRIC_TYPE PEA or  MEA ");
				}				
			}
			//changePaymentTypeELBill();			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flagValid;			
	}
	public boolean changeElectricUseType_ELTmp(){				
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			String electricUseType = semmel006Bean.getPayment().getElectricUseType();
			logger.debug(" -- changeElectricUseType_ELTmp to :"+electricUseType);
			if(electricUseType!=null){
				//PEA	:	���俿����ǹ�����Ҥ
				if(ELUtils.ELECTRIC_TYPE_PEA.equals(electricUseType)){
					semmel006Bean.setElExpenseTypeList(ELUtils.getExpenseTyePEAList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name)));
				//MEA	:	���俿�ҹ����ǧ
				}else if (ELUtils.ELECTRIC_TYPE_MEA.equals(electricUseType)){
					semmel006Bean.setElExpenseTypeList(ELUtils.getExpenseTyeMEAList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name)));
				}else{
					logger.debug("  No Matching EL_ELECTRIC_TYPE PEA or  MEA ");
				}				
			}		
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flagValid;			
	}
	
	public boolean changeMeterId(){				
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			String meterId = semmel006Bean.getPopupSiteCriteria().getMeterId();
			logger.debug(" -- changeMeterId to :"+meterId);
			if(meterId!=null){
			// Get SEM_EL_METER_INFO by meterId 				
				IMeterInfoService meterInfoService = (IMeterInfoService)getBean("meterInfoService");
				List <MeterInfo> resultList = meterInfoService.findByMeterId(meterId);				
				if(resultList!=null&&resultList.size()>0){					
					MeterInfo tmp = resultList.get(0);
					//logger.debug(" MeterInfo tmp:"+BeanUtils.getBeanString(tmp));
				}	else{
					logger.debug(" Not Found  MeterInfo for Id :"+meterId);
				}				
			}		
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flagValid;			
	}	
	
	
	public boolean changeElectricUseType_ELPospaid(){				
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			String electricUseType = semmel006Bean.getPayment().getElectricUseType();
			logger.debug(" -- changeElectricUseType_ELPospaid to :"+electricUseType);
			if(electricUseType!=null){
				//PEA	:	���俿����ǹ�����Ҥ
				if(ELUtils.ELECTRIC_TYPE_PEA.equals(electricUseType)){
					semmel006Bean.getPayment().setVendorId(ELUtils.getParaValueStringbyCode(ELUtils.EL_PEA_VENDOR_ID));
					semmel006Bean.getPayment().setVendorName(ELUtils.getParaValueStringbyCode(ELUtils.EL_PEA_VENDOR_NAME));
					//semmel006Bean.getPayment().setPayeeId(ELUtils.getParaValueStringbyCode(ELUtils.EL_PEA_PAYEE_ID));
					semmel006Bean.getPayment().setPayeeId(ELUtils.getParaValueStringbyCode(ELUtils.EL_PEA_PAYEE_MASTER_ID));
					
					semmel006Bean.getPayment().setPayeeName(ELUtils.getParaValueStringbyCode(ELUtils.EL_PEA_PAYEE_NAME));
					//semmel006Bean.setElExpenseTypeList(ELUtils.getExpenseTyePEAList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name)));

				//MEA	:	���俿�ҹ����ǧ
				}else if (ELUtils.ELECTRIC_TYPE_MEA.equals(electricUseType)){
					semmel006Bean.getPayment().setVendorId(ELUtils.getParaValueStringbyCode(ELUtils.EL_MEA_VENDOR_ID));
					semmel006Bean.getPayment().setVendorName(ELUtils.getParaValueStringbyCode(ELUtils.EL_MEA_VENDOR_NAME));
					//semmel006Bean.getPayment().setPayeeId(ELUtils.getParaValueStringbyCode(ELUtils.EL_MEA_PAYEE_ID));
					semmel006Bean.getPayment().setPayeeId(ELUtils.getParaValueStringbyCode(ELUtils.EL_MEA_PAYEE_MASTER_ID));
					
					semmel006Bean.getPayment().setPayeeName(ELUtils.getParaValueStringbyCode(ELUtils.EL_MEA_PAYEE_NAME));
					//semmel006Bean.setElExpenseTypeList(ELUtils.getExpenseTyeMEAList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name)));

				}else{
					logger.debug("  No Matching EL_ELECTRIC_TYPE PEA or  MEA ");
				}				
			}
			changePaymentTypeELBill();			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flagValid;			
	}
	public boolean changePaymentTypeELBill(){
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			String paymentType = semmel006Bean.getPayment().getPaymentType();
			logger.debug(" -- changePaymentTypeELBill to :"+paymentType);
			semmel006Bean.getPayment().setPaymentMethod(null);
			semmel006Bean.setChqPostingDtDisable(false);
			semmel006Bean.setChqReceivedDtDisable(false);
			semmel006Bean.setBankNameMandatory(false);
			semmel006Bean.setBankAccountMandatory(false);
			
			if(paymentType!=null){
				//01		��			
				if(ELUtils.PAYMENT_TYPE_01.equals(paymentType)){				
					Map<String,String> codeMap = new HashMap();
//					codeMap.put(ELUtils.PAYMENT_METHOD_01,ELUtils.PAYMENT_METHOD_01);
//					codeMap.put(ELUtils.PAYMENT_METHOD_02,ELUtils.PAYMENT_METHOD_02);
//					codeMap.put(ELUtils.PAYMENT_METHOD_03,ELUtils.PAYMENT_METHOD_03);
//					codeMap.put(ELUtils.PAYMENT_METHOD_04,ELUtils.PAYMENT_METHOD_04);
//					semmel006Bean.setCtPaymentMethodList(ELUtils.getLOVBtLOVCodeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name), codeMap));
					List<SelectItem> paymentMethodList = getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name,EX_AND,"CHEQUE",null,null);
					semmel006Bean.setCtPaymentMethodList(paymentMethodList);
					semmel006Bean.setPaymentMethodDisable(false);
					semmel006Bean.getPayment().setBankName("");
					semmel006Bean.getPayment().setBankAccount("");
					semmel006Bean.setTransferDtDisable(true);
					semmel006Bean.getPayment().setTransferDt(null);//WT###ADd 20110207
					
					semmel006Bean.getPayment().setPaymentMethod(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.CT_PAYMENT_METHOD));//WT###Add 20110207
				//02		�͹
				}else if (ELUtils.PAYMENT_TYPE_02.equals(paymentType)){
					semmel006Bean.getPayment().setPaymentMethod("05");		
					// prepare paymentMethodList
					List<SelectItem> paymentMethodList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
					List<SelectItem> selectList = new ArrayList<SelectItem>();
					for(SelectItem selectItem : paymentMethodList){
						if (StringUtils.equalsIgnoreCase("U", selectItem.getDescription())){
							selectList.add(selectItem);
						}
						/*SelectItem selItem = paymentMethodList.get(i);
						if(selItem.getDescription() != null && selItem.getDescription().indexOf('U') < 0){
							
							paymentMethodList.remove(i);
						}*/
					}
					semmel006Bean.setCtPaymentMethodList(selectList);					
					
					semmel006Bean.setBankNameMandatory(true);
					semmel006Bean.setBankAccountMandatory(true);
					semmel006Bean.setPaymentMethodDisable(false);
					semmel006Bean.setChqPostingDtDisable(true);
					semmel006Bean.setChqReceivedDtDisable(true);
					semmel006Bean.setTransferDtDisable(false);
					
				
					// Check 
					String electricUseType = semmel006Bean.getPayment().getElectricUseType();				
					if(electricUseType!=null){
						//PEA	:	���俿����ǹ�����Ҥ
						if(ELUtils.ELECTRIC_TYPE_PEA.equals(electricUseType)){
							semmel006Bean.getPayment().setBankName(ELUtils.getParaValueStringbyCode(ELUtils.EL_PEA_BANK_NAME));
							semmel006Bean.getPayment().setBankAccount(ELUtils.getParaValueStringbyCode(ELUtils.EL_PEA_BANK_ACCOUNT));

							//MEA	:	���俿�ҹ����ǧ
						}else if (ELUtils.ELECTRIC_TYPE_MEA.equals(electricUseType)){
							semmel006Bean.getPayment().setBankName(ELUtils.getParaValueStringbyCode(ELUtils.EL_MEA_BANK_NAME));
							semmel006Bean.getPayment().setBankAccount(ELUtils.getParaValueStringbyCode(ELUtils.EL_MEA_BANK_ACCOUNT));
						}
						semmel006Bean.setChqPostingDtDisable(true);
						semmel006Bean.setChqReceivedDtDisable(true);
						semmel006Bean.setTransferDtDisable(false);
					}			
					
					if(electricUseType!=null){
						//PEA	:	���俿����ǹ�����Ҥ
						if(ELUtils.ELECTRIC_TYPE_PEA.equals(electricUseType)){
							semmel006Bean.getPayment().setVendorId(ELUtils.getParaValueStringbyCode(ELUtils.EL_PEA_VENDOR_ID));
							semmel006Bean.getPayment().setVendorName(ELUtils.getParaValueStringbyCode(ELUtils.EL_PEA_VENDOR_NAME));
							semmel006Bean.getPayment().setPayeeId(ELUtils.getParaValueStringbyCode(ELUtils.EL_PEA_PAYEE_MASTER_ID));
							semmel006Bean.getPayment().setPayeeName(ELUtils.getParaValueStringbyCode(ELUtils.EL_PEA_PAYEE_NAME));
						//MEA	:	���俿�ҹ����ǧ
						}else if (ELUtils.ELECTRIC_TYPE_MEA.equals(electricUseType)){
							semmel006Bean.getPayment().setVendorId(ELUtils.getParaValueStringbyCode(ELUtils.EL_MEA_VENDOR_ID));
							semmel006Bean.getPayment().setVendorName(ELUtils.getParaValueStringbyCode(ELUtils.EL_MEA_VENDOR_NAME));
							semmel006Bean.getPayment().setPayeeId(ELUtils.getParaValueStringbyCode(ELUtils.EL_MEA_PAYEE_MASTER_ID));
							semmel006Bean.getPayment().setPayeeName(ELUtils.getParaValueStringbyCode(ELUtils.EL_MEA_PAYEE_NAME));
							
						}else{
							logger.debug("  No Matching EL_ELECTRIC_TYPE PEA or  MEA ");
						}semmel006Bean.setChqPostingDtDisable(true);
						semmel006Bean.setChqReceivedDtDisable(true);
						semmel006Bean.setTransferDtDisable(false);						
					}					
				}else if (ELUtils.PAYMENT_TYPE_03.equals(paymentType)){
					logger.debug("  No Matching PaymentType 03 ");
					semmel006Bean.getPayment().setPaymentMethod("06");		
					// prepare paymentMethodList
					List<SelectItem> paymentMethodList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
					List<SelectItem> selectList = new ArrayList<SelectItem>();
//					
					for(SelectItem selectItem : paymentMethodList){
						
						if (StringUtils.equalsIgnoreCase("P", selectItem.getDescription())){
							selectList.add(selectItem);
						}
					
					}
					semmel006Bean.setCtPaymentMethodList(selectList);
					semmel006Bean.setPaymentMethodDisable(false);	
					semmel006Bean.setChqPostingDtDisable(false);
					semmel006Bean.setChqReceivedDtDisable(true);
					semmel006Bean.setTransferDtDisable(true);
					
				}else{
					logger.debug("  No Matching PaymentType 01 or  02 ");
						
					// prepare paymentMethodList
					
					List<SelectItem> selectList = new ArrayList<SelectItem>();
//					
					semmel006Bean.setCtPaymentMethodList(selectList);
					semmel006Bean.setPaymentMethodDisable(true);	
					semmel006Bean.setChqPostingDtDisable(true);
					semmel006Bean.setChqReceivedDtDisable(true);
					semmel006Bean.setTransferDtDisable(true);
				}				
			}			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flagValid;			
	}
	
	//WT###Add 20110131 Start
	public boolean changePaymentTypeELPostpaid03Edit(){
		boolean flagValid = false;		
		logger.info("START Action changePaymentTypeELPostpaid03Edit");
		try{
			semmel006Bean = getSemmel006Bean();	 
			String paymentType = semmel006Bean.getPayment().getPaymentType();
			logger.debug(" -- changePaymentTypeELPostpaid03 to :"+paymentType);
			semmel006Bean.setPaymentMethodDisable(true);
			semmel006Bean.setChqPostingDtDisable(true);
			semmel006Bean.setChqReceivedDtDisable(true);
			semmel006Bean.setTransferDtDisable(true);
			semmel006Bean.setBankNameMandatory(false);
			semmel006Bean.setBankAccountMandatory(false);
			
			if(paymentType!=null){
				//01		��			
				if(ELUtils.PAYMENT_TYPE_01.equals(paymentType)){				
					Map<String,String> codeMap = new HashMap();
//					codeMap.put(ELUtils.PAYMENT_METHOD_01,ELUtils.PAYMENT_METHOD_01);
//					codeMap.put(ELUtils.PAYMENT_METHOD_02,ELUtils.PAYMENT_METHOD_02);
//					codeMap.put(ELUtils.PAYMENT_METHOD_03,ELUtils.PAYMENT_METHOD_03);
//					codeMap.put(ELUtils.PAYMENT_METHOD_04,ELUtils.PAYMENT_METHOD_04);
//					semmel006Bean.setCtPaymentMethodList(ELUtils.getLOVBtLOVCodeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name), codeMap));
					semmel006Bean.setCtPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name,EX_AND,"CHEQUE",null,null));
					semmel006Bean.setPaymentMethodDisable(false);
					semmel006Bean.setTransferDtDisable(true);
					semmel006Bean.getPayment().setPaymentMethod(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.CT_PAYMENT_METHOD));
				//02		�͹
				}else if (ELUtils.PAYMENT_TYPE_02.equals(paymentType)){	
					// prepare paymentMethodList
					List<SelectItem> paymentMethodList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
					List<SelectItem> selectList = new ArrayList<SelectItem>();
					for(SelectItem selectItem : paymentMethodList){
						if (StringUtils.equalsIgnoreCase("U", selectItem.getDescription())){
							selectList.add(selectItem);
						}
						
					}
					semmel006Bean.setCtPaymentMethodList(selectList);					
					semmel006Bean.setPaymentMethodDisable(false);	
					semmel006Bean.setBankNameMandatory(true);
					semmel006Bean.setBankAccountMandatory(true);
					semmel006Bean.setChqPostingDtDisable(true);
					semmel006Bean.setChqReceivedDtDisable(true);
					semmel006Bean.setTransferDtDisable(false);	
					//semmel006Bean.setTransferDtMandatory(true);
					semmel006Bean.setPaymentMethodDisable(false);					
				}else if (ELUtils.PAYMENT_TYPE_03.equals(paymentType)){
					logger.debug("  No Matching PaymentType 01 or  02 ");
					semmel006Bean.getPayment().setPaymentMethod("06");		
					// prepare paymentMethodList
					List<SelectItem> paymentMethodList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
					List<SelectItem> selectList = new ArrayList<SelectItem>();
//					
					for(SelectItem selectItem : paymentMethodList){
						
						if (StringUtils.equalsIgnoreCase("P", selectItem.getDescription())){
							selectList.add(selectItem);
						}
					
					}
					semmel006Bean.setCtPaymentMethodList(selectList);
					semmel006Bean.setPaymentMethodDisable(false);
					semmel006Bean.setChqPostingDtDisable(true);
					semmel006Bean.setChqReceivedDtDisable(true);
					semmel006Bean.setTransferDtDisable(true);
				}else{
					logger.debug("  No Matching PaymentType 01 or  02 ");
					//semmel006Bean.getPayment().setPaymentMethod("06");		
					//semmel006Bean.setCtPaymentMethodList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name));
					semmel006Bean.setPaymentMethodDisable(true);
					semmel006Bean.setChqPostingDtDisable(true);
					semmel006Bean.setChqReceivedDtDisable(true);
					semmel006Bean.setTransferDtDisable(true);
				}		
			}		
			logger.info("END Action changePaymentTypeELPostpaid03Edit");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flagValid;			
	}
	//WT###Add 20110131 End
	
	//WT###Add 20101223 Start
	public boolean changePaymentTypeELPostpaid03(){
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			String paymentType = semmel006Bean.getPayment().getPaymentType();
			logger.debug(" -- changePaymentTypeELPostpaid03 to :"+paymentType);
			semmel006Bean.getPayment().setPaymentMethod(null);
			semmel006Bean.setChqPostingDtDisable(false);
			semmel006Bean.setChqReceivedDtDisable(false);
			semmel006Bean.setBankNameMandatory(false);
			semmel006Bean.setBankAccountMandatory(false);
			semmel006Bean.setTransferDtMandatory(false);
			semmel006Bean.setPaymentMethodDisable(false);
			if(paymentType!=null){
				//01		��			
				if(ELUtils.PAYMENT_TYPE_01.equals(paymentType)){				
					Map<String,String> codeMap = new HashMap();
//					codeMap.put(ELUtils.PAYMENT_METHOD_01,ELUtils.PAYMENT_METHOD_01);
//					codeMap.put(ELUtils.PAYMENT_METHOD_02,ELUtils.PAYMENT_METHOD_02);
//					codeMap.put(ELUtils.PAYMENT_METHOD_03,ELUtils.PAYMENT_METHOD_03);
//					codeMap.put(ELUtils.PAYMENT_METHOD_04,ELUtils.PAYMENT_METHOD_04);
//					semmel006Bean.setCtPaymentMethodList(ELUtils.getLOVBtLOVCodeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name), codeMap));
					semmel006Bean.setCtPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name,EX_AND,"CHEQUE",null,null));
					semmel006Bean.setPaymentMethodDisable(false);
					semmel006Bean.setTransferDtDisable(true);
					semmel006Bean.getPayment().setPaymentMethod(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.CT_PAYMENT_METHOD));
				//02		�͹
				}else if (ELUtils.PAYMENT_TYPE_02.equals(paymentType)){	
					// prepare paymentMethodList
					List<SelectItem> paymentMethodList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
					List<SelectItem> selectList = new ArrayList<SelectItem>();
					for(SelectItem selectItem : paymentMethodList){
						if (StringUtils.equalsIgnoreCase("U", selectItem.getDescription())){
							selectList.add(selectItem);
						}
						
					}
					semmel006Bean.setCtPaymentMethodList(selectList);	
					// Check 
					String electricUseType = semmel006Bean.getPayment().getElectricUseType();				
					if(electricUseType!=null){
						//PEA	:	���俿����ǹ�����Ҥ
						if(ELUtils.ELECTRIC_TYPE_PEA.equals(electricUseType)){
							semmel006Bean.getPayment().setBankName(ELUtils.getParaValueStringbyCode(ELUtils.EL_PEA_BANK_NAME));
							semmel006Bean.getPayment().setBankAccount(ELUtils.getParaValueStringbyCode(ELUtils.EL_PEA_BANK_ACCOUNT));
							//MEA	:	���俿�ҹ����ǧ
						}else if (ELUtils.ELECTRIC_TYPE_MEA.equals(electricUseType)){
							semmel006Bean.getPayment().setBankName(ELUtils.getParaValueStringbyCode(ELUtils.EL_MEA_BANK_NAME));
							semmel006Bean.getPayment().setBankAccount(ELUtils.getParaValueStringbyCode(ELUtils.EL_MEA_BANK_ACCOUNT));
						}								
					}			
					//WT###Start 20110131 Start
					
					//WT###Start 20110131 End
					semmel006Bean.setPaymentMethodDisable(false);	
					semmel006Bean.setBankNameMandatory(true);
					semmel006Bean.setBankAccountMandatory(true);
					semmel006Bean.setChqPostingDtDisable(true);
					semmel006Bean.setChqReceivedDtDisable(true);
					semmel006Bean.setTransferDtDisable(false);	
					//semmel006Bean.setTransferDtMandatory(true);
					semmel006Bean.setPaymentMethodDisable(false);					
				}else if (ELUtils.PAYMENT_TYPE_03.equals(paymentType)){
					logger.debug("  No Matching PaymentType 01 or  02 ");
					semmel006Bean.getPayment().setPaymentMethod("06");		
					// prepare paymentMethodList
					List<SelectItem> paymentMethodList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
					List<SelectItem> selectList = new ArrayList<SelectItem>();
//					
					for(SelectItem selectItem : paymentMethodList){
						
						if (StringUtils.equalsIgnoreCase("P", selectItem.getDescription())){
							selectList.add(selectItem);
						}
					
					}
					semmel006Bean.setCtPaymentMethodList(selectList);
					semmel006Bean.setPaymentMethodDisable(false);
					semmel006Bean.setChqPostingDtDisable(false);
					semmel006Bean.setChqReceivedDtDisable(true);
					semmel006Bean.setTransferDtDisable(true);
				}else{
					logger.debug("  No Matching PaymentType 01 or  02 ");
					//semmel006Bean.getPayment().setPaymentMethod("06");		
					//semmel006Bean.setCtPaymentMethodList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name));
					semmel006Bean.setPaymentMethodDisable(true);
					semmel006Bean.setChqPostingDtDisable(true);
					semmel006Bean.setChqReceivedDtDisable(true);
					semmel006Bean.setTransferDtDisable(true);
				}			
			}			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flagValid;			
	}
	//WT###Add 20101223 End
	
	public boolean changePaymentMethodELPostpaid(){
		try{
		semmel006Bean = getSemmel006Bean();	
		String vendorType = semmel006Bean.getPayment().getVendorType();//WT###Add 20110203
		if(VENDOR_TYPE_SUPPLIER.equals(vendorType)){
			semmel006Bean.getPayment().setOldPaymentMethodTypeS(semmel006Bean.getPayment().getPaymentMethod());
		}else{
			semmel006Bean.getPayment().setOldPaymentMethodTypeV(semmel006Bean.getPayment().getPaymentMethod());
		}
		}catch(Exception e){
			e.printStackTrace();
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMEL006");
			FrontMessageUtils.addMessageError(errorMsg);
		}
		
		return true;
	}
	
	public boolean changePaymentTypeELPostpaid(){
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			String paymentType = semmel006Bean.getPayment().getPaymentType();
			String vendorType = semmel006Bean.getPayment().getVendorType();//WT###Add 20110203
			logger.debug(" -- changePaymentTypeELPostpaid to :"+paymentType);
			logger.debug("WT### vendorType to :"+vendorType);
			semmel006Bean.getPayment().setPaymentMethod(null);
			semmel006Bean.setChqPostingDtDisable(false);
			semmel006Bean.setChqReceivedDtDisable(false);
			semmel006Bean.setBankNameMandatory(false);
			semmel006Bean.setBankAccountMandatory(false);
			semmel006Bean.setTransferDtMandatory(false);
			//semmel006Bean.setPaymentMethodDisable(false);
			if(VENDOR_TYPE_SUPPLIER.equals(vendorType)){				
				if(paymentType!=null){
					semmel006Bean.getPayment().setOldPaymentTypeTypeS(semmel006Bean.getPayment().getPaymentType());
					semmel006Bean.getPayment().setOldPaymentMethodTypeS(semmel006Bean.getPayment().getPaymentMethod());
					//01		��			
					if(ELUtils.PAYMENT_TYPE_01.equals(paymentType)){				
						
						semmel006Bean.setCtPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name,EX_AND,"CHEQUE",null,null));
						semmel006Bean.setPaymentMethodDisable(false);
						semmel006Bean.setTransferDtDisable(true);

						semmel006Bean.getPayment().setBankName("");
						semmel006Bean.getPayment().setBankAccount("");
						semmel006Bean.getPayment().setOldBankNameTypeS("");
						semmel006Bean.getPayment().setOldBankAccountTypeS("");
						semmel006Bean.getPayment().setPaymentMethod(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.CT_PAYMENT_METHOD));
					//02		�͹
					}else if (ELUtils.PAYMENT_TYPE_02.equals(paymentType)){	
						// prepare paymentMethodList
						List<SelectItem> paymentMethodList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
						List<SelectItem> selectList = new ArrayList<SelectItem>();
						for(SelectItem selectItem : paymentMethodList){
							if (StringUtils.equalsIgnoreCase("U", selectItem.getDescription())){
								selectList.add(selectItem);
							}
							
						}
						semmel006Bean.setChqPostingDtDisable(true);
						semmel006Bean.setChqReceivedDtDisable(true);
						semmel006Bean.setTransferDtDisable(false);
						semmel006Bean.setCtPaymentMethodList(selectList);	
						semmel006Bean.setBankAccountMandatory(true);
						semmel006Bean.setOldPaymentMethodDisableTypeS(true);
						
						PopupVendorSupplierBean vendorPopup = (PopupVendorSupplierBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupVendorSupplierBean");
						if(vendorPopup!=null){
							VendorBookbank vendorBookbank = getVemdorBookBank(vendorPopup.getPopupVendorSupplierSearchSP().getVendorMasterId());
							if(null!=vendorBookbank){
								semmel006Bean.getPayment().setBankName(vendorBookbank.getBankAccName());
								semmel006Bean.getPayment().setBankAccount(vendorBookbank.getBankAccNo());
								semmel006Bean.getPayment().setOldBankNameTypeS(semmel006Bean.getPayment().getBankName());
								semmel006Bean.getPayment().setOldBankAccountTypeS(semmel006Bean.getPayment().getBankAccount());								
							}
						}
						
						String contractNo = semmel006Bean.getPopupSiteCriteria().getContractNo();
						
						IVendorMapPayeeELService vendorMapPayeeService = (IVendorMapPayeeELService)getBean("vendorMapPayeeELService");
						IBankService bankService = (IBankService) getBean("bankService");
						PayeeBookbank bookbank = vendorMapPayeeService.queryVendorMapPayeeMasterBookBank(contractNo);	
						Bank bank = bankService.queryBankByCode(bookbank.getBankCode());
						if(bookbank!=null){		
							semmel006Bean.getPayment().setBankAccount(bookbank.getBankAccNo());
							if (bank!=null){
								semmel006Bean.getPayment().setBankName(bank.getBankName());
							}else{
								semmel006Bean.getPayment().setBankName("");
							}
							semmel006Bean.getPayment().setOldBankNameTypeV(semmel006Bean.getPayment().getBankName());
							semmel006Bean.getPayment().setOldBankAccountTypeV(semmel006Bean.getPayment().getBankAccount());
						} else{
//							FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0040"), ""));
						}
						semmel006Bean.setPaymentMethodDisable(false);					
					}else if (ELUtils.PAYMENT_TYPE_03.equals(paymentType)){
						logger.debug("  No Matching PaymentType 01 or  02 ");
						semmel006Bean.getPayment().setPaymentMethod("06");		
						// prepare paymentMethodList
						List<SelectItem> paymentMethodList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
						List<SelectItem> selectList = new ArrayList<SelectItem>();
//						
						for(SelectItem selectItem : paymentMethodList){
							
							if (StringUtils.equalsIgnoreCase("P", selectItem.getDescription())){
								selectList.add(selectItem);
							}
						
						}
						semmel006Bean.setCtPaymentMethodList(selectList);
						semmel006Bean.getPayment().setBankName("");
						semmel006Bean.getPayment().setBankAccount("");
						semmel006Bean.getPayment().setOldBankNameTypeS("");
						semmel006Bean.getPayment().setOldBankAccountTypeS("");
						semmel006Bean.setPaymentMethodDisable(false);
						semmel006Bean.setChqPostingDtDisable(false);
						semmel006Bean.setChqReceivedDtDisable(true);
						semmel006Bean.setTransferDtDisable(true);
					}else{
						logger.debug("  No Matching PaymentType 01 or  02 ");
						//semmel006Bean.getPayment().setPaymentMethod("06");		
						//semmel006Bean.setCtPaymentMethodList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name));
						semmel006Bean.setPaymentMethodDisable(true);
						semmel006Bean.setChqPostingDtDisable(true);
						semmel006Bean.setChqReceivedDtDisable(true);
						semmel006Bean.setTransferDtDisable(true);
					}	
					
				
				}
				
			}else{
				if(paymentType!=null){
					semmel006Bean.getPayment().setOldPaymentTypeTypeV(semmel006Bean.getPayment().getPaymentType());
					semmel006Bean.getPayment().setOldPaymentMethodTypeV(semmel006Bean.getPayment().getPaymentMethod());
					logger.debug(" -- Else :"+paymentType);
					//01		��			
					if(ELUtils.PAYMENT_TYPE_01.equals(paymentType)){				
						
						Map<String,String> codeMap = new HashMap();
//						codeMap.put(ELUtils.PAYMENT_METHOD_01,ELUtils.PAYMENT_METHOD_01);
//						codeMap.put(ELUtils.PAYMENT_METHOD_02,ELUtils.PAYMENT_METHOD_02);
//						codeMap.put(ELUtils.PAYMENT_METHOD_03,ELUtils.PAYMENT_METHOD_03);
//						codeMap.put(ELUtils.PAYMENT_METHOD_04,ELUtils.PAYMENT_METHOD_04);
//						semmel006Bean.setCtPaymentMethodList(ELUtils.getLOVBtLOVCodeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name), codeMap));
						semmel006Bean.setCtPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name,EX_AND,"CHEQUE",null,null));
						semmel006Bean.setPaymentMethodDisable(false);
						semmel006Bean.setOldPaymentMethodDisableTypeV(false);
						semmel006Bean.getPayment().setBankName("");
						semmel006Bean.getPayment().setBankAccount("");
					    semmel006Bean.getPayment().setPaymentMethod(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.CT_PAYMENT_METHOD));
						semmel006Bean.getPayment().setOldBankNameTypeV(semmel006Bean.getPayment().getBankName());
						semmel006Bean.getPayment().setOldBankAccountTypeV(semmel006Bean.getPayment().getBankAccount());						
						semmel006Bean.setTransferDtDisable(true);
						
						semmel006Bean.setChqPostingDtDisable(false);
						semmel006Bean.setChqReceivedDtDisable(false);
					//02		�͹
					}else if (ELUtils.PAYMENT_TYPE_02.equals(paymentType)){
						semmel006Bean.getPayment().setPaymentMethod("05");	
						semmel006Bean.getPayment().setOldPaymentMethodTypeV("05");
						semmel006Bean.setCtPaymentMethodList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name));					semmel006Bean.setPaymentMethodDisable(true);	
						semmel006Bean.setBankNameMandatory(true);
						semmel006Bean.setBankAccountMandatory(true);
						semmel006Bean.setChqPostingDtDisable(true);
						semmel006Bean.setChqReceivedDtDisable(true);
						semmel006Bean.setTransferDtDisable(false);	
						//semmel006Bean.setTransferDtMandatory(true);
						semmel006Bean.setPaymentMethodDisable(true);
						semmel006Bean.setOldPaymentMethodDisableTypeV(true);
						
						String contractNo = semmel006Bean.getPopupSiteCriteria().getContractNo();
						
//						IVendorMasterService vendorMasterService = (IVendorMasterService) getBean("vendorMasterService");
//						VendorSP vendorSP = new VendorSP();
//						
////						if(StringUtils.isNotEmpty(semmel006Bean.getPayment().getVendorId())){
//							vendorSP.setContractNo(contractNo);
////							if(StringUtils.equalsIgnoreCase("Y", fromChangeVendorMaster)){
////								vendorSP.setVendorId(semmel006Bean.getPayment().getVendorId());
////							}else{
////								if(semmel006Bean.getVendorIdList()!=null){
////								vendorSP.setVendorId((String) semmel006Bean.getVendorIdList().get(0).getValue());
////								}
////							}
////							
////							if(StringUtils.equalsIgnoreCase("Y", fromChangePaymentType)){
//								vendorSP.setPaymentType(semmel006Bean.getPayment().getPaymentType());
////							}
//							vendorSP.setVendorId(semmel006Bean.getPayment().getVendorId());
//							vendorSP.setExpenseType("06");
//							logger.debug("vendorSP.getContractNo() = "+vendorSP.getContractNo());
//							logger.debug("vendorSP.getVendorId() = "+vendorSP.getVendorId());
//							logger.debug("vendorSP.getExpenseType() = "+vendorSP.getExpenseType());
//							
//							List<VendorSP> vendorList = vendorMasterService.querySPList(EQueryName.SP_GET_DETAIL_VENDOR_PAYEE.name, vendorSP);
//							String paymentTypeDefault = vendorList.get(0).getPaymentType();
//							semmel006Bean.getPayment().setPaymentType(paymentTypeDefault);
//							semmel006Bean.getPayment().setVendorName(vendorList.get(0).getVendorName());
//						
//						
//						
//							if(vendorList != null && !vendorList.isEmpty()){
//								logger.debug("vendorList.size() = "+vendorList.size());
//								vendorSP = vendorList.get(0);
//								logger.debug("vendorSP.getBankCode() = "+vendorSP.getBankCode());
//								logger.debug("vendorSP.getBankName() = "+vendorSP.getBankName());
//								
//								semmel006Bean.getPayment().setBankName(vendorSP.getBankName());
//								semmel006Bean.getPayment().setBankAccount(vendorSP.getBankAccNo());
//								semmel006Bean.getPayment().setOldBankNameTypeV(semmel006Bean.getPayment().getBankName());
//								semmel006Bean.getPayment().setOldBankAccountTypeV(semmel006Bean.getPayment().getBankAccount());
						
						
						IVendorMapPayeeELService vendorMapPayeeService = (IVendorMapPayeeELService)getBean("vendorMapPayeeELService");
						IBankService bankService = (IBankService) getBean("bankService");
						PayeeBookbank bookbank = vendorMapPayeeService.queryVendorMapPayeeMasterBookBank(contractNo);	
						Bank bank = bankService.queryBankByCode(bookbank.getBankCode());
						if(bookbank!=null){		
							semmel006Bean.getPayment().setBankAccount(bookbank.getBankAccNo());
							if (bank!=null){
								semmel006Bean.getPayment().setBankName(bank.getBankName());
							}else{
								semmel006Bean.getPayment().setBankName("");
							}
							semmel006Bean.getPayment().setOldBankNameTypeV(semmel006Bean.getPayment().getBankName());
							semmel006Bean.getPayment().setOldBankAccountTypeV(semmel006Bean.getPayment().getBankAccount());
						} else{
							FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0040"), ""));
						
						}					
						
					}else{
						logger.debug("  No Matching PaymentType 01 or  02 ");
						semmel006Bean.getPayment().setPaymentMethod("06");		
						semmel006Bean.setCtPaymentMethodList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name));
						semmel006Bean.setPaymentMethodDisable(true);
					}
				}
			}			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flagValid;			
	}
	
	//WT###20110131 Start
	public boolean changePaymentTypeELPREdit(){
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			String paymentType = semmel006Bean.getPayment().getPaymentType();
			logger.debug(" -- changePaymentTypeELPR to :"+paymentType);
			semmel006Bean.setChqPostingDtDisable(false);
			semmel006Bean.setChqReceivedDtDisable(false);
			semmel006Bean.setBankNameMandatory(false);
			semmel006Bean.setBankAccountMandatory(false);
			semmel006Bean.setPaymentMethodDisable(false);
			if(paymentType!=null){
				if(ELUtils.PAYMENT_TYPE_01.equals(paymentType)){				
					Map<String,String> codeMap = new HashMap();
//					codeMap.put(ELUtils.PAYMENT_METHOD_01,ELUtils.PAYMENT_METHOD_01);
//					codeMap.put(ELUtils.PAYMENT_METHOD_02,ELUtils.PAYMENT_METHOD_02);
//					codeMap.put(ELUtils.PAYMENT_METHOD_03,ELUtils.PAYMENT_METHOD_03);
//					codeMap.put(ELUtils.PAYMENT_METHOD_04,ELUtils.PAYMENT_METHOD_04);
//					semmel006Bean.setCtPaymentMethodList(ELUtils.getLOVBtLOVCodeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name), codeMap));
					semmel006Bean.setCtPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name,EX_AND,"CHEQUE",null,null));
					semmel006Bean.setPaymentMethodDisable(false);
					semmel006Bean.setTransferDtDisable(true);
					semmel006Bean.setPaymentMethodDisable(false);
	
				//02		�͹
				}else if (ELUtils.PAYMENT_TYPE_02.equals(paymentType)){
					semmel006Bean.getPayment().setPaymentMethod("05");		
					semmel006Bean.setCtPaymentMethodList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name));					
					semmel006Bean.setPaymentMethodDisable(true);	
					semmel006Bean.setBankNameMandatory(true);
					semmel006Bean.setBankAccountMandatory(true);
					semmel006Bean.setChqPostingDtDisable(true);
					semmel006Bean.setChqReceivedDtDisable(true);
					semmel006Bean.setTransferDtDisable(false);		
					semmel006Bean.setPaymentMethodDisable(true);

				}else if (ELUtils.PAYMENT_TYPE_03.equals(paymentType)){
					logger.debug("XXXXXXXXXXX :03 XXXXXXXXXXXX");
					semmel006Bean.getPayment().setPaymentMethod("09");
					semmel006Bean.setPaymentMethodDisable(true);
				}else{
					logger.debug("  --------No Matching PaymentType 01 or  02---------- ");
					semmel006Bean.getPayment().setPaymentMethod("09");
					semmel006Bean.setPaymentMethodDisable(true);
				}		
			}			
		}catch(Exception ex){ 
			ex.printStackTrace();
		}
		return flagValid;			
	}
	//WT###20110131 End
	
	public boolean changePaymentTypeELPR(){
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	
			String fromChangePaymentType = (String)getFacesUtils().getRequestParameter("fromChangePaymentType");
//			String paymentType = semmel006Bean.getPayment().getPaymentType();
//			logger.debug(" -- changePaymentTypeELPR to :"+ paymentType);
			semmel006Bean.getPayment().setPaymentMethod(null);
			semmel006Bean.setChqPostingDtDisable(false);
			semmel006Bean.setChqReceivedDtDisable(false);
			semmel006Bean.setBankNameMandatory(false);
			semmel006Bean.setBankAccountMandatory(false);
			semmel006Bean.setPaymentMethodDisable(false);
			
			IVendorMasterService vendorMasterService = (IVendorMasterService) getBean("vendorMasterService");
			VendorSP vendorSP = new VendorSP();
			
			if(StringUtils.isNotEmpty(semmel006Bean.getPayment().getVendorId())){
				vendorSP.setContractNo(semmel006Bean.getPopupSiteCriteria().getContractNo());
//				if(StringUtils.equalsIgnoreCase("Y", fromChangeVendorMaster)){
//					vendorSP.setVendorId(semmel006Bean.getPayment().getVendorId());
//				}else{
//					if(semmel006Bean.getVendorIdList()!=null){
//					vendorSP.setVendorId((String) semmel006Bean.getVendorIdList().get(0).getValue());
//					}
//				}
//				
				if(StringUtils.equalsIgnoreCase("Y", fromChangePaymentType)){
					vendorSP.setPaymentType(semmel006Bean.getPayment().getPaymentType());
				}
				
				vendorSP.setVendorId(semmel006Bean.getPayment().getVendorId());
				vendorSP.setExpenseType("06");
				logger.debug("vendorSP.getContractNo() = "+vendorSP.getContractNo());
				logger.debug("vendorSP.getVendorId() = "+vendorSP.getVendorId());
				logger.debug("vendorSP.getExpenseType() = "+vendorSP.getExpenseType());
				
				List<VendorSP> vendorList = vendorMasterService.querySPList(EQueryName.SP_GET_DETAIL_VENDOR_PAYEE.name, vendorSP);
				String paymentType = vendorList.get(0).getPaymentType();
				semmel006Bean.getPayment().setPaymentType(paymentType);
				semmel006Bean.getPayment().setVendorName(vendorList.get(0).getVendorName());
				if(paymentType!=null){
				//01		��			
				if(ELUtils.PAYMENT_TYPE_01.equals(paymentType)){				
					Map<String,String> codeMap = new HashMap();
//					codeMap.put(ELUtils.PAYMENT_METHOD_01,ELUtils.PAYMENT_METHOD_01);
//					codeMap.put(ELUtils.PAYMENT_METHOD_02,ELUtils.PAYMENT_METHOD_02);
//					codeMap.put(ELUtils.PAYMENT_METHOD_03,ELUtils.PAYMENT_METHOD_03);
//					codeMap.put(ELUtils.PAYMENT_METHOD_04,ELUtils.PAYMENT_METHOD_04);
//					semmel006Bean.setCtPaymentMethodList(ELUtils.getLOVBtLOVCodeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name), codeMap));
					semmel006Bean.setCtPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name,EX_AND,"CHEQUE",null,null));
					semmel006Bean.setPaymentMethodDisable(false);
					semmel006Bean.getPayment().setBankName("");
					semmel006Bean.getPayment().setBankAccount("");
					semmel006Bean.getPayment().setPaymentMethod(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.CT_PAYMENT_METHOD));
					semmel006Bean.setTransferDtDisable(true);
					semmel006Bean.setChqPostingDtDisable(false);
					semmel006Bean.setChqReceivedDtDisable(false);
					
					//WT###Start 20110131 Start
					
					//WT###Start 20110131 End
	
				//02		�͹
				}else if (ELUtils.PAYMENT_TYPE_02.equals(paymentType)){
					
					// prepare paymentMethodList
					List<SelectItem> paymentMethodList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
					List<SelectItem> selectList = new ArrayList<SelectItem>();
					for(SelectItem selectItem : paymentMethodList){
						if (StringUtils.equalsIgnoreCase("U", selectItem.getDescription())){
							selectList.add(selectItem);
						}
						/*SelectItem selItem = paymentMethodList.get(i);
						if(selItem.getDescription() != null && selItem.getDescription().indexOf('U') < 0){
							
							paymentMethodList.remove(i);
						}*/
					}
					semmel006Bean.setCtPaymentMethodList(selectList);					
						
					semmel006Bean.setBankNameMandatory(true);
					semmel006Bean.setBankAccountMandatory(true);
					semmel006Bean.setChqPostingDtDisable(true);
					semmel006Bean.setChqReceivedDtDisable(true);
					semmel006Bean.setTransferDtDisable(false);		
					semmel006Bean.setPaymentMethodDisable(false);
					
					//Add 20/11/2012
//					if(fromChangePaymentType != null && fromChangePaymentType.equalsIgnoreCase("Y")){
//						IVendorMasterService vendorMasterService = (IVendorMasterService) getBean("vendorMasterService");
//						VendorSP vendorSP = new VendorSP();
//						
//						if(StringUtils.isNotEmpty(semmel006Bean.getPayment().getVendorId())){
//							vendorSP.setContractNo(semmel006Bean.getPopupSiteCriteria().getContractNo());
//							vendorSP.setVendorId(semmel006Bean.getPayment().getVendorId());
//							vendorSP.setExpenseType("06");
//							logger.debug("vendorSP.getContractNo() = "+vendorSP.getContractNo());
//							logger.debug("vendorSP.getVendorId() = "+vendorSP.getVendorId());
//							logger.debug("vendorSP.getExpenseType() = "+vendorSP.getExpenseType());
//							
//							List<VendorSP> vendorList = vendorMasterService.querySPList(EQueryName.SP_GET_DETAIL_VENDOR_PAYEE.name, vendorSP);
							
							if(vendorList != null && !vendorList.isEmpty()){
								logger.debug("vendorList.size() = "+vendorList.size());
								vendorSP = vendorList.get(0);
								logger.debug("vendorSP.getBankCode() = "+vendorSP.getBankCode());
								logger.debug("vendorSP.getBankName() = "+vendorSP.getBankName());
								
								semmel006Bean.getPayment().setBankName(vendorSP.getBankName());
								semmel006Bean.getPayment().setBankAccount(vendorSP.getBankAccNo());
							}else{
								FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0040"), ""));
							}
//						String contractNo = semmel006Bean.getPopupSiteCriteria().getContractNo();
//						IVendorMapPayeeELService vendorMapPayeeService = (IVendorMapPayeeELService)getBean("vendorMapPayeeELService");
//						PayeeBookbank bookbank = vendorMapPayeeService.queryVendorMapPayeeMasterBookBank(contractNo);
//						IBankService bankService = (IBankService)getBean("bankService"); 
//						Bank bank = bankService.queryBankByCode(bookbank.getBankCode());
//						if(bank == null){
//							IVendorBookbankService vendorBookBankService = (IVendorBookbankService)getBean("vendorBookbankService");
//							VendorBookbank vendorBookBank = new VendorBookbank();
//							vendorBookBank.setBankCode(bookbank.getBankCode());
//							vendorBookBank.setVendorMasterId(semmel006Bean.getPayment().getVendorId());
//							vendorBookBank.setRecordStatus("Y");
//							List<VendorBookbank> vendorBookbankList = vendorBookBankService.searchVendorBookbank(vendorBookBank);
//							if(vendorBookbankList != null && !vendorBookbankList.isEmpty()){
//								bank = new Bank();
//								bank.setBankCode(vendorBookbankList.get(0).getBankCode());
//							}
//						}
//						if(bookbank!=null){					
//							semmel006Bean.getPayment().setBankAccount(bookbank.getBankAccNo());
//							semmel006Bean.getPayment().setBankName(bookbank.getBankAccName());
//							semmel006Bean.getPayment().setBankName((bank != null)?bank.getBankName():"");
//						} else{
//							FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0040"), ""));
//						
//						}
//					}
					
					//WT###Start 20110131 Start
							
					//WT###Start 20110131 End
				}else if (ELUtils.PAYMENT_TYPE_03.equals(paymentType)){
					logger.debug("XXXXXXXXXXX :03 XXXXXXXXXXXX");
//					semmel006Bean.getPayment().setPaymentMethod("09");
//					semmel006Bean.setPaymentMethodDisable(true);
					semmel006Bean.getPayment().setPaymentMethod("06");		
					semmel006Bean.setPaymentMethodDisable(false);
					semmel006Bean.getPayment().setBankName("");
					semmel006Bean.getPayment().setBankAccount("");
					// prepare paymentMethodList
					List<SelectItem> paymentMethodList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
					List<SelectItem> selectList = new ArrayList<SelectItem>();
//					
					for(SelectItem selectItem : paymentMethodList){
						
						if (StringUtils.equalsIgnoreCase("P", selectItem.getDescription())){
							selectList.add(selectItem);
						}
					
					}
					semmel006Bean.setCtPaymentMethodList(selectList);
					
					semmel006Bean.setChqPostingDtDisable(false);
					semmel006Bean.setChqReceivedDtDisable(true);
					semmel006Bean.setTransferDtDisable(true);		
				}else{
					logger.debug("  No Matching PaymentType 01 or  02 ");
					
				}		
				}
			}else{
				//Create By new 09/11/2014
				String paymentType = semmel006Bean.getPayment().getPaymentType();
				if(paymentType!=null){
					//01		��			
					if(ELUtils.PAYMENT_TYPE_01.equals(paymentType)){				
						Map<String,String> codeMap = new HashMap();
						semmel006Bean.setCtPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name,EX_AND,"CHEQUE",null,null));
						semmel006Bean.setPaymentMethodDisable(false);
						semmel006Bean.getPayment().setBankName("");
						semmel006Bean.getPayment().setBankAccount("");
						semmel006Bean.getPayment().setPaymentMethod(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.CT_PAYMENT_METHOD));
						semmel006Bean.setTransferDtDisable(true);
						semmel006Bean.setChqPostingDtDisable(false);
						semmel006Bean.setChqReceivedDtDisable(false);
						
						//WT###Start 20110131 Start
						
						//WT###Start 20110131 End
		
					//02		�͹
					}else if (ELUtils.PAYMENT_TYPE_02.equals(paymentType)){
						
						// prepare paymentMethodList
						List<SelectItem> paymentMethodList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
						List<SelectItem> selectList = new ArrayList<SelectItem>();
						for(SelectItem selectItem : paymentMethodList){
							if (StringUtils.equalsIgnoreCase("U", selectItem.getDescription())){
								selectList.add(selectItem);
							}
							
						}
						semmel006Bean.setCtPaymentMethodList(selectList);					
							
						semmel006Bean.setBankNameMandatory(true);
						semmel006Bean.setBankAccountMandatory(true);
						semmel006Bean.setChqPostingDtDisable(true);
						semmel006Bean.setChqReceivedDtDisable(true);
						semmel006Bean.setTransferDtDisable(false);		
						semmel006Bean.setPaymentMethodDisable(false);
						
						
						
						//WT###Start 20110131 End
					}else if (ELUtils.PAYMENT_TYPE_03.equals(paymentType)){
						logger.debug("XXXXXXXXXXX :03 XXXXXXXXXXXX");
//						semmel006Bean.getPayment().setPaymentMethod("09");
//						semmel006Bean.setPaymentMethodDisable(true);
						semmel006Bean.getPayment().setPaymentMethod("06");		
						semmel006Bean.setPaymentMethodDisable(false);
						semmel006Bean.getPayment().setBankName("");
						semmel006Bean.getPayment().setBankAccount("");
						// prepare paymentMethodList
						List<SelectItem> paymentMethodList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
						List<SelectItem> selectList = new ArrayList<SelectItem>();
//						
						for(SelectItem selectItem : paymentMethodList){
							
							if (StringUtils.equalsIgnoreCase("P", selectItem.getDescription())){
								selectList.add(selectItem);
							}
						
						}
						semmel006Bean.setCtPaymentMethodList(selectList);
					
						semmel006Bean.setChqPostingDtDisable(false);
						semmel006Bean.setChqReceivedDtDisable(true);
						semmel006Bean.setTransferDtDisable(true);		
					}else{
						logger.debug("  No Matching PaymentType 01 or  02 ");
						
					}	
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flagValid;			
	}
	
	public boolean changePaymentTypeELPRNew(String contractNo){
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	
			String fromChangePaymentType = (String)getFacesUtils().getRequestParameter("fromChangePaymentType");
//			String paymentType = semmel006Bean.getPayment().getPaymentType();
//			logger.debug(" -- changePaymentTypeELPR to :"+ paymentType);
			semmel006Bean.getPayment().setPaymentMethod(null);
			semmel006Bean.setChqPostingDtDisable(false);
			semmel006Bean.setChqReceivedDtDisable(false);
			semmel006Bean.setBankNameMandatory(false);
			semmel006Bean.setBankAccountMandatory(false);
			semmel006Bean.setPaymentMethodDisable(false);
			
			IVendorMasterService vendorMasterService = (IVendorMasterService) getBean("vendorMasterService");
			VendorSP vendorSP = new VendorSP();
			
			if(StringUtils.isNotEmpty(semmel006Bean.getPayment().getVendorId())){
				if(semmel006Bean.getPopupSiteCriteria() != null){
					vendorSP.setContractNo(semmel006Bean.getPopupSiteCriteria().getContractNo());
				}else{
					logger.debug(contractNo);
					vendorSP.setContractNo(contractNo);
				}
				
//				if(StringUtils.equalsIgnoreCase("Y", fromChangeVendorMaster)){
//					vendorSP.setVendorId(semmel006Bean.getPayment().getVendorId());
//				}else{
//					if(semmel006Bean.getVendorIdList()!=null){
//					vendorSP.setVendorId((String) semmel006Bean.getVendorIdList().get(0).getValue());
//					}
//				}
//				
				if(StringUtils.equalsIgnoreCase("Y", fromChangePaymentType)){
					vendorSP.setPaymentType(semmel006Bean.getPayment().getPaymentType());
				}
				
				vendorSP.setVendorId(semmel006Bean.getPayment().getVendorId());
				vendorSP.setExpenseType("06");
				logger.debug("vendorSP.getContractNo() = "+vendorSP.getContractNo());
				logger.debug("vendorSP.getVendorId() = "+vendorSP.getVendorId());
				logger.debug("vendorSP.getExpenseType() = "+vendorSP.getExpenseType());
				
				List<VendorSP> vendorList = vendorMasterService.querySPList(EQueryName.SP_GET_DETAIL_VENDOR_PAYEE.name, vendorSP);
				String paymentType = vendorList.get(0).getPaymentType();
				semmel006Bean.getPayment().setPaymentType(paymentType);
				semmel006Bean.getPayment().setVendorName(vendorList.get(0).getVendorName());
				if(paymentType!=null){
				//01		��			
				if(ELUtils.PAYMENT_TYPE_01.equals(paymentType)){				
					Map<String,String> codeMap = new HashMap();
//					codeMap.put(ELUtils.PAYMENT_METHOD_01,ELUtils.PAYMENT_METHOD_01);
//					codeMap.put(ELUtils.PAYMENT_METHOD_02,ELUtils.PAYMENT_METHOD_02);
//					codeMap.put(ELUtils.PAYMENT_METHOD_03,ELUtils.PAYMENT_METHOD_03);
//					codeMap.put(ELUtils.PAYMENT_METHOD_04,ELUtils.PAYMENT_METHOD_04);
//					semmel006Bean.setCtPaymentMethodList(ELUtils.getLOVBtLOVCodeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name), codeMap));
					semmel006Bean.setCtPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name,EX_AND,"CHEQUE",null,null));
					semmel006Bean.setPaymentMethodDisable(false);
					semmel006Bean.getPayment().setBankName("");
					semmel006Bean.getPayment().setBankAccount("");
					semmel006Bean.getPayment().setPaymentMethod(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.CT_PAYMENT_METHOD));
					semmel006Bean.setTransferDtDisable(true);
					semmel006Bean.setChqPostingDtDisable(false);
					semmel006Bean.setChqReceivedDtDisable(false);
					
					//WT###Start 20110131 Start
					
					//WT###Start 20110131 End
	
				//02		�͹
				}else if (ELUtils.PAYMENT_TYPE_02.equals(paymentType)){
					
					// prepare paymentMethodList
					List<SelectItem> paymentMethodList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
					List<SelectItem> selectList = new ArrayList<SelectItem>();
					for(SelectItem selectItem : paymentMethodList){
						if (StringUtils.equalsIgnoreCase("U", selectItem.getDescription())){
							selectList.add(selectItem);
						}
						/*SelectItem selItem = paymentMethodList.get(i);
						if(selItem.getDescription() != null && selItem.getDescription().indexOf('U') < 0){
							
							paymentMethodList.remove(i);
						}*/
					}
					semmel006Bean.setCtPaymentMethodList(selectList);					
						
					semmel006Bean.setBankNameMandatory(true);
					semmel006Bean.setBankAccountMandatory(true);
					semmel006Bean.setChqPostingDtDisable(true);
					semmel006Bean.setChqReceivedDtDisable(true);
					semmel006Bean.setTransferDtDisable(false);		
					semmel006Bean.setPaymentMethodDisable(false);
					
					//Add 20/11/2012
//					if(fromChangePaymentType != null && fromChangePaymentType.equalsIgnoreCase("Y")){
//						IVendorMasterService vendorMasterService = (IVendorMasterService) getBean("vendorMasterService");
//						VendorSP vendorSP = new VendorSP();
//						
//						if(StringUtils.isNotEmpty(semmel006Bean.getPayment().getVendorId())){
//							vendorSP.setContractNo(semmel006Bean.getPopupSiteCriteria().getContractNo());
//							vendorSP.setVendorId(semmel006Bean.getPayment().getVendorId());
//							vendorSP.setExpenseType("06");
//							logger.debug("vendorSP.getContractNo() = "+vendorSP.getContractNo());
//							logger.debug("vendorSP.getVendorId() = "+vendorSP.getVendorId());
//							logger.debug("vendorSP.getExpenseType() = "+vendorSP.getExpenseType());
//							
//							List<VendorSP> vendorList = vendorMasterService.querySPList(EQueryName.SP_GET_DETAIL_VENDOR_PAYEE.name, vendorSP);
							
							if(vendorList != null && !vendorList.isEmpty()){
								logger.debug("vendorList.size() = "+vendorList.size());
								vendorSP = vendorList.get(0);
								logger.debug("vendorSP.getBankCode() = "+vendorSP.getBankCode());
								logger.debug("vendorSP.getBankName() = "+vendorSP.getBankName());
								
								semmel006Bean.getPayment().setBankName(vendorSP.getBankName());
								semmel006Bean.getPayment().setBankAccount(vendorSP.getBankAccNo());
							}else{
								FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0040"), ""));
							}
//						String contractNo = semmel006Bean.getPopupSiteCriteria().getContractNo();
//						IVendorMapPayeeELService vendorMapPayeeService = (IVendorMapPayeeELService)getBean("vendorMapPayeeELService");
//						PayeeBookbank bookbank = vendorMapPayeeService.queryVendorMapPayeeMasterBookBank(contractNo);
//						IBankService bankService = (IBankService)getBean("bankService"); 
//						Bank bank = bankService.queryBankByCode(bookbank.getBankCode());
//						if(bank == null){
//							IVendorBookbankService vendorBookBankService = (IVendorBookbankService)getBean("vendorBookbankService");
//							VendorBookbank vendorBookBank = new VendorBookbank();
//							vendorBookBank.setBankCode(bookbank.getBankCode());
//							vendorBookBank.setVendorMasterId(semmel006Bean.getPayment().getVendorId());
//							vendorBookBank.setRecordStatus("Y");
//							List<VendorBookbank> vendorBookbankList = vendorBookBankService.searchVendorBookbank(vendorBookBank);
//							if(vendorBookbankList != null && !vendorBookbankList.isEmpty()){
//								bank = new Bank();
//								bank.setBankCode(vendorBookbankList.get(0).getBankCode());
//							}
//						}
//						if(bookbank!=null){					
//							semmel006Bean.getPayment().setBankAccount(bookbank.getBankAccNo());
//							semmel006Bean.getPayment().setBankName(bookbank.getBankAccName());
//							semmel006Bean.getPayment().setBankName((bank != null)?bank.getBankName():"");
//						} else{
//							FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0040"), ""));
//						
//						}
//					}
					
					//WT###Start 20110131 Start
							
					//WT###Start 20110131 End
				}else if (ELUtils.PAYMENT_TYPE_03.equals(paymentType)){
					logger.debug("XXXXXXXXXXX :03 XXXXXXXXXXXX");
//					semmel006Bean.getPayment().setPaymentMethod("09");
//					semmel006Bean.setPaymentMethodDisable(true);
					semmel006Bean.getPayment().setPaymentMethod("06");		
					semmel006Bean.setPaymentMethodDisable(false);
					semmel006Bean.getPayment().setBankName("");
					semmel006Bean.getPayment().setBankAccount("");
					// prepare paymentMethodList
					List<SelectItem> paymentMethodList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
					List<SelectItem> selectList = new ArrayList<SelectItem>();
//					
					for(SelectItem selectItem : paymentMethodList){
						
						if (StringUtils.equalsIgnoreCase("P", selectItem.getDescription())){
							selectList.add(selectItem);
						}
					
					}
					semmel006Bean.setCtPaymentMethodList(selectList);
					
					semmel006Bean.setChqPostingDtDisable(false);
					semmel006Bean.setChqReceivedDtDisable(true);
					semmel006Bean.setTransferDtDisable(true);		
				}else{
					logger.debug("  No Matching PaymentType 01 or  02 ");
					
				}		
				}
			}else{
				//Create By new 09/11/2014
				String paymentType = semmel006Bean.getPayment().getPaymentType();
				if(paymentType!=null){
					//01		��			
					if(ELUtils.PAYMENT_TYPE_01.equals(paymentType)){				
						Map<String,String> codeMap = new HashMap();
						semmel006Bean.setCtPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name,EX_AND,"CHEQUE",null,null));
						semmel006Bean.setPaymentMethodDisable(false);
						semmel006Bean.getPayment().setBankName("");
						semmel006Bean.getPayment().setBankAccount("");
						semmel006Bean.getPayment().setPaymentMethod(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.CT_PAYMENT_METHOD));
						semmel006Bean.setTransferDtDisable(true);
						semmel006Bean.setChqPostingDtDisable(false);
						semmel006Bean.setChqReceivedDtDisable(false);
						
						//WT###Start 20110131 Start
						
						//WT###Start 20110131 End
		
					//02		�͹
					}else if (ELUtils.PAYMENT_TYPE_02.equals(paymentType)){
						
						// prepare paymentMethodList
						List<SelectItem> paymentMethodList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
						List<SelectItem> selectList = new ArrayList<SelectItem>();
						for(SelectItem selectItem : paymentMethodList){
							if (StringUtils.equalsIgnoreCase("U", selectItem.getDescription())){
								selectList.add(selectItem);
							}
							
						}
						semmel006Bean.setCtPaymentMethodList(selectList);					
							
						semmel006Bean.setBankNameMandatory(true);
						semmel006Bean.setBankAccountMandatory(true);
						semmel006Bean.setChqPostingDtDisable(true);
						semmel006Bean.setChqReceivedDtDisable(true);
						semmel006Bean.setTransferDtDisable(false);		
						semmel006Bean.setPaymentMethodDisable(false);
						
						
						
						//WT###Start 20110131 End
					}else if (ELUtils.PAYMENT_TYPE_03.equals(paymentType)){
						logger.debug("XXXXXXXXXXX :03 XXXXXXXXXXXX");
//						semmel006Bean.getPayment().setPaymentMethod("09");
//						semmel006Bean.setPaymentMethodDisable(true);
						semmel006Bean.getPayment().setPaymentMethod("06");		
						semmel006Bean.setPaymentMethodDisable(false);
						semmel006Bean.getPayment().setBankName("");
						semmel006Bean.getPayment().setBankAccount("");
						// prepare paymentMethodList
						List<SelectItem> paymentMethodList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
						List<SelectItem> selectList = new ArrayList<SelectItem>();
//						
						for(SelectItem selectItem : paymentMethodList){
							
							if (StringUtils.equalsIgnoreCase("P", selectItem.getDescription())){
								selectList.add(selectItem);
							}
						
						}
						semmel006Bean.setCtPaymentMethodList(selectList);
					
						semmel006Bean.setChqPostingDtDisable(false);
						semmel006Bean.setChqReceivedDtDisable(true);
						semmel006Bean.setTransferDtDisable(true);		
					}else{
						logger.debug("  No Matching PaymentType 01 or  02 ");
						
					}	
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flagValid;			
	}
	
	public boolean changeElectricUseType(){				
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			String electricUseType = semmel006Bean.getCriteria().getElectricUseType();
			logger.debug(" -- changeElectricUseType to :"+electricUseType);
			if(electricUseType!=null){
				//PEA	or MEA 
				if(ELUtils.ELECTRIC_TYPE_PEA.equals(electricUseType)||ELUtils.ELECTRIC_TYPE_MEA.equals(electricUseType)){
					Map<String,String> codeMap = new HashMap();
					codeMap.put(ELUtils.EL_BILL,ELUtils.EL_BILL);
					codeMap.put(ELUtils.EL_POSTPAID,ELUtils.EL_POSTPAID);
					codeMap.put(ELUtils.EL_TEMP,ELUtils.EL_TEMP);
					semmel006Bean.setElExpenseTypeList(ELUtils.getLOVBtLOVCodeList(ELUtils.filterLOVByLOVValue("3", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name)), codeMap));
				}else{
					Map<String,String> codeMap = new HashMap();
					codeMap.put(ELUtils.PR_POSTPAID,ELUtils.PR_POSTPAID);
					codeMap.put(ELUtils.PR_PREPAID,ELUtils.PR_PREPAID);			
					semmel006Bean.setElExpenseTypeList(ELUtils.getLOVBtLOVCodeList(ELUtils.filterLOVByLOVValue("3", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name)), codeMap));
				}		
			}
			semmel006Bean.getCriteria().setExpenseType(null);				
		}catch(Exception ex){
			ex.printStackTrace();
		}
	
		return flagValid;			
	}
	
	//addMessageInfo("M0001");
	private boolean initAddNewSite() {
		logger.debug(" -- initAddNewSite--");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	     	
			semmel006Bean.setNotExpenseSite(new PaymentDetail());
			semmel006Bean.setAddNewSiteDisable(false);
			semmel006Bean.getNotExpenseSite().setVatType("01");
			//semmel006Bean.getNotExpenseSite().setTermOfPaymentDtMonth("02");
			
			semmel006Bean.getNotExpenseSite().setInvExcludeVatAmt(new BigDecimal(0));
			semmel006Bean.getNotExpenseSite().setInvVatAmt(new BigDecimal(0));
			semmel006Bean.getNotExpenseSite().setInvIncludeVatAmt(new BigDecimal(0));
			semmel006Bean.getNotExpenseSite().setExcludeVatAmt(new BigDecimal(0));
			semmel006Bean.getNotExpenseSite().setVatAmt(new BigDecimal(0));
			semmel006Bean.getNotExpenseSite().setIncludeVatAmt(new BigDecimal(0));
			logger.debug("semmel006Bean.getPayment().getElectricUseType():"
					  +semmel006Bean.getPayment().getElectricUseType());
			
			semmel006Bean.getPayment().setElectricUseTypeTxt(ELUtils.getLOVNameByLOVCode(semmel006Bean.getElectricUseTypeList() , semmel006Bean.getPayment().getElectricUseType()));
			
			logger.debug("semmel006Bean.getPayment().getElectricUseTypeTxt():"
					      +semmel006Bean.getPayment().getElectricUseTypeTxt());
			//semmel006Bean.getNotExpenseSite().setTermOfPaymentDtYear("2010");
			if(semmel006Bean.getNotExpenseSiteList()==null){
				semmel006Bean.setNotExpenseSiteList(new ArrayList());
			}else{
				int totalSize = semmel006Bean.getNotExpenseSiteList().size();			
				//logger.debug("  semmel006Bean.getPayment() :"+BeanUtils.getBeanString(semmel006Bean.getPayment()));
				logger.debug("  totalSize :"+totalSize);	
				BigDecimal invtotalSize = semmel006Bean.getPayment().getInvTotalSite(); 
				logger.debug(" invtotalSize:"+invtotalSize);
				if(totalSize>=invtotalSize.intValue()){
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.errorTotalSize")));
					semmel006Bean.setAddNewSiteDisable(true);				
				}
			}				
		}catch(Exception ex){
			ex.printStackTrace();
		}
	
		return flagValid;
	}	
	
	private boolean doAddNotExpenseSite() {
		logger.debug(" -- doAddNotExpenseSite--");
		boolean flagValid = false;		
		try{
			
			semmel006Bean = getSemmel006Bean();	 
			semmel006Bean.setDisplayPopupNotExpenseSite(true);
			
			if (validateAddNotExpenseSite()) {
				//System.out.println("WT###Print semmel006Bean.setDisplayPopupNotExpenseSite="+semmel006Bean.isDisplayPopupNotExpenseSite());
				return flagValid;
			}
			
			 	
			//semmel006Bean.getNotExpenseSite().getMeterId()
			List<PaymentDetail> notExpenseTmpList = semmel006Bean.getNotExpenseSiteList();
			//WT###Edit 20110114 Start
			//int nextRowId = getNextNotExpenseRowId(notExpenseTmpList);
			String nextRowId = getNextNotExpenseByRowId(notExpenseTmpList);
			//semmel006Bean.getNotExpenseSite().setRowId(nextRowId+"");
			//WT###Edit 20110114 End			
			semmel006Bean.getNotExpenseSite().setInvTermOfPaymentDt(ELUtils.getDateByMonthandYear(semmel006Bean.getNotExpenseSite().getTermOfPaymentDtMonth(), semmel006Bean.getNotExpenseSite().getTermOfPaymentDtYear()));
			
			logger.debug("xx  MeterId:"+semmel006Bean.getNotExpenseSite().getMeterId());
			semmel006Bean.getNotExpenseSiteList().add(semmel006Bean.getNotExpenseSite());			
			// Calculate
			recalculateAdNewExpenseSite();		
			semmel006Bean.setDisplayPopupNotExpenseSite(false);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flagValid;
	}			
	
	
	public boolean recalculateAdNewExpenseSite(){		
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();
			logger.debug("recalculateAdNewExpenseSite()");
			List<PaymentDetail> tmpList = semmel006Bean.getNotExpenseSiteList();
			//if(tmpList!=null&&tmpList.size()>0){
				logger.debug(" recalculateAdNewExpenseSite size:"+tmpList.size());
				BigDecimal invtotalSize = semmel006Bean.getPayment().getInvTotalSite(); 
				int dbtotalSite = invtotalSize.intValue()-tmpList.size();				
				BigDecimal dbTotalExcludeVatDoc =semmel006Bean.getPayment().getInvTotalExcludeVat();
				BigDecimal noDbTotalExcludeVatDoc =new BigDecimal(0);			
				BigDecimal dbTotalVatDoc =semmel006Bean.getPayment().getInvTotalVat();
				BigDecimal noDbTotalVatDoc =new BigDecimal(0);					
				BigDecimal dbTotalIncludeVatDoc =semmel006Bean.getPayment().getInvTotalIncludeVat();
				BigDecimal noDbIncludeVatDoc =new BigDecimal(0);		
				
				//------------------------------------------------//
				//BigDecimal totalIncludeVatDoc  = semmel006Bean.getPayment().getInvTotalIncludeVat();
				//BigDecimal totalVatDoc         = semmel006Bean.getPayment().getInvTotalVat();
				//BigDecimal totalExcludeVatDoc  = new BigDecimal(0);
				//------------------------------------------------//
				
				logger.debug("dbTotalIncludeVatDoc:   "+ dbTotalIncludeVatDoc);
				logger.debug("dbTotalVatDoc:          "+ dbTotalVatDoc);
				logger.debug("dbTotalExcludeVatDoc:   "+ dbTotalExcludeVatDoc);
				
				if(dbTotalIncludeVatDoc== null){
					dbTotalIncludeVatDoc = new BigDecimal(0);
				}
				if(dbTotalVatDoc== null){
					dbTotalVatDoc = new BigDecimal(0);
				}
				if(dbTotalExcludeVatDoc== null){
					dbTotalExcludeVatDoc = new BigDecimal(0);
				}
				/*
				if(totalIncludeVatDoc != null && totalIncludeVatDoc != noDbTotalVatDoc){
					
					if(totalVatDoc != null && totalVatDoc != noDbTotalVatDoc){
						totalExcludeVatDoc = totalIncludeVatDoc.subtract(totalVatDoc);
						logger.debug("totalExcludeVatDoc Vat"+ totalExcludeVatDoc);
						
					}else if(totalVatDoc != null && totalVatDoc == noDbTotalVatDoc){
						totalExcludeVatDoc = totalIncludeVatDoc;
						logger.debug("totalExcludeVatDoc Non Vat"+ totalExcludeVatDoc);
					}
				}
				*/
				//semmel006Bean.getPayment().setInvTotalExcludeVat(totalExcludeVatDoc);
				//dbTotalExcludeVatDoc = totalExcludeVatDoc;
				
				//------------------------------------------------
				for(PaymentDetail tmpDetail: tmpList){
					logger.debug("PaymentDetail tmpDetail: tmpList");
					dbTotalExcludeVatDoc = dbTotalExcludeVatDoc.subtract(tmpDetail.getInvExcludeVatAmt()==null?new BigDecimal(0):tmpDetail.getInvExcludeVatAmt());				
					//dbTotalExcludeVatDoc = totalExcludeVatDoc.subtract(tmpDetail.getInvExcludeVatAmt()==null?new BigDecimal(0):tmpDetail.getInvExcludeVatAmt());				
					//----------------------
					noDbTotalExcludeVatDoc = noDbTotalExcludeVatDoc.add(tmpDetail.getInvExcludeVatAmt()==null?new BigDecimal(0):tmpDetail.getInvExcludeVatAmt());				
					dbTotalVatDoc = dbTotalVatDoc.subtract(tmpDetail.getInvVatAmt()==null?new BigDecimal(0):tmpDetail.getInvVatAmt());				
					noDbTotalVatDoc = noDbTotalVatDoc.add(tmpDetail.getInvVatAmt()==null?new BigDecimal(0):tmpDetail.getInvVatAmt());						
					dbTotalIncludeVatDoc = dbTotalIncludeVatDoc.subtract(tmpDetail.getInvIncludeVatAmt()==null?new BigDecimal(0):tmpDetail.getInvIncludeVatAmt());				
					noDbIncludeVatDoc = noDbIncludeVatDoc.add(tmpDetail.getInvIncludeVatAmt()==null?new BigDecimal(0):tmpDetail.getInvIncludeVatAmt());					
				}			
				semmel006Bean.getPayment().setDbTotalSite(new BigDecimal(dbtotalSite));
				semmel006Bean.getPayment().setNoDbTotalSite(new BigDecimal(tmpList.size()));			
				semmel006Bean.getPayment().setDbTotalExcludeVat(dbTotalExcludeVatDoc);
				semmel006Bean.getPayment().setNoDbTotalExcludeVat(noDbTotalExcludeVatDoc);			
				semmel006Bean.getPayment().setDbTotalVat(dbTotalVatDoc);
				semmel006Bean.getPayment().setNoDbTotalVat(noDbTotalVatDoc);
				semmel006Bean.getPayment().setDbTotalIncludeVat(dbTotalIncludeVatDoc);
				semmel006Bean.getPayment().setNoDbIncludeVat(noDbIncludeVatDoc);
				//semmel006Bean.getPayment().getDbTotalExcludeVat();
				logger.debug("semmel006Bean.getPayment().getDbTotalExcludeVat()   "+ semmel006Bean.getPayment().getDbTotalExcludeVat());
				logger.debug("getDbTotalVat():          "+ semmel006Bean.getPayment().getDbTotalVat());
				logger.debug("getDbTotalIncludeVat():   "+ semmel006Bean.getPayment().getDbTotalIncludeVat());
				//------------------------------------------------------------------
				//semmel006Bean.getPayment().setDbTotalExcludeVat(totalExcludeVatDoc);
				
			/*}else{
				logger.debug(" recalculateAdNewExpenseSite size:"+tmpList.size());
				semmel006Bean.getPayment().setDbTotalSite(new BigDecimal(0));
				semmel006Bean.getPayment().setNoDbTotalSite(new BigDecimal(0));			
				semmel006Bean.getPayment().setDbTotalExcludeVat(new BigDecimal(0));		
				semmel006Bean.getPayment().setNoDbTotalExcludeVat(new BigDecimal(0));					
				semmel006Bean.getPayment().setDbTotalVat(new BigDecimal(0));		
				semmel006Bean.getPayment().setNoDbTotalVat(new BigDecimal(0));		
				semmel006Bean.getPayment().setDbTotalIncludeVat(new BigDecimal(0));		
				semmel006Bean.getPayment().setNoDbIncludeVat(new BigDecimal(0));		
			}		
			
			*/
				
				logger.debug("semmel006Bean.getPayment().getCompany():"+ semmel006Bean.getPayment().getCompany());
				logger.debug("semmel006Bean.getPayment().getElectricUseType():"+ semmel006Bean.getPayment().getElectricUseType());
				
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return flagValid;

	}
	
	
	private boolean doClearNotExpenseSite() {
		logger.debug(" -- doClearNotExpenseSite--");
		boolean flagValid = false;		
		try{
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		semmel006Bean = getSemmel006Bean();	     	
		semmel006Bean.setNotExpenseSite(new PaymentDetail());
		semmel006Bean.getNotExpenseSite().setVatType("01");
		
		setSemmel006Bean(semmel006Bean);
		//flagValid= true;
		return flagValid;
	}			
	
	private boolean exportNoPayment() {
		logger.debug(" -- exportNoPayment--");
		boolean flagValid = false;
		try{
			if (validateAddNotExpenseSite()) {
				return flagValid;
			}
			semmel006Bean = getSemmel006Bean();	     	
			//logger.debug(" NotExpenseSite To Save:"+BeanUtils.getBeanString(semmel006Bean.getNotExpenseSite()));
			List<PaymentDetail> notExpenseTmpList = semmel006Bean.getNotExpenseSiteList();		
			logger.debug("  notExpenseTmpList size before add:"+notExpenseTmpList.size());
			//WT###Edit 20110114 Start
			//int nextRowId = getNextNotExpenseRowId(notExpenseTmpList);
			String nextRowId = getNextNotExpenseByRowId(notExpenseTmpList);
			//semmel006Bean.getNotExpenseSite().setRowId(nextRowId+"");
			//WT###Edit 20110114 End			
			logger.debug("  notExpenseTmpList Id after set rowid :"+semmel006Bean.getNotExpenseSite().getRowId());
			semmel006Bean.getNotExpenseSiteList().add(semmel006Bean.getNotExpenseSite());			
			List<PaymentDetail> tmpList = semmel006Bean.getNotExpenseSiteList();
			if(tmpList!=null&&tmpList.size()>0){
				BigDecimal invtotalSize = semmel006Bean.getPayment().getInvTotalSite(); 
				int dbtotalSite = invtotalSize.intValue()-tmpList.size();				
				//logger.debug("  semmel006Bean.getPayment():"+BeanUtils.getBeanString(semmel006Bean.getPayment()));
				logger.debug("  semmel006Bean.getPayment().getDbTotalExcludeVat():"+semmel006Bean.getPayment().getDbTotalExcludeVat());
				BigDecimal dbTotalExcludeVatDoc =semmel006Bean.getPayment().getInvTotalExcludeVat();
				BigDecimal noDbTotalExcludeVatDoc =new BigDecimal(0);			
				BigDecimal dbTotalVatDoc =semmel006Bean.getPayment().getInvTotalVat();
				BigDecimal noDbTotalVatDoc =new BigDecimal(0);					
				BigDecimal dbTotalIncludeVatDoc =semmel006Bean.getPayment().getInvTotalIncludeVat();
				BigDecimal noDbIncludeVatDoc =new BigDecimal(0);		
				for(PaymentDetail tmpDetail: tmpList){
					dbTotalExcludeVatDoc = dbTotalExcludeVatDoc.subtract(tmpDetail.getInvExcludeVatAmt());				
					noDbTotalExcludeVatDoc = noDbTotalExcludeVatDoc.add(tmpDetail.getInvIncludeVatAmt());
					
					dbTotalVatDoc = dbTotalVatDoc.subtract(tmpDetail.getInvVatAmt());				
					noDbTotalVatDoc = noDbTotalVatDoc.add(tmpDetail.getInvVatAmt());		
					
					dbTotalIncludeVatDoc = dbTotalIncludeVatDoc.subtract(tmpDetail.getInvIncludeVatAmt());				
					noDbIncludeVatDoc = noDbIncludeVatDoc.add(tmpDetail.getInvIncludeVatAmt());					
				}			
				semmel006Bean.getPayment().setDbTotalSite(new BigDecimal(dbtotalSite));
				semmel006Bean.getPayment().setNoDbTotalSite(new BigDecimal(tmpList.size()));			
				semmel006Bean.getPayment().setDbTotalExcludeVat(dbTotalExcludeVatDoc);
				semmel006Bean.getPayment().setNoDbTotalExcludeVat(noDbTotalExcludeVatDoc);			
				semmel006Bean.getPayment().setDbTotalVat(dbTotalVatDoc);
				semmel006Bean.getPayment().setNoDbTotalVat(noDbTotalVatDoc);
				semmel006Bean.getPayment().setDbTotalIncludeVat(dbTotalIncludeVatDoc);
				semmel006Bean.getPayment().setNoDbIncludeVat(noDbIncludeVatDoc);
				
			}else{
				semmel006Bean.getPayment().setDbTotalSite(new BigDecimal(0));
			}
			
			semmel006Bean.setDisabledBtnExport(false);			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		flagValid = true;
		return flagValid;
	}		
	public boolean doCheckMeterExist() {
		logger.debug(" -- doCheckMeterExist--");
		boolean flagValid = false;		

		try {
			if (validateCheckMeterExist()) {
				return flagValid;
			}
			semmel006Bean = getSemmel006Bean();	     
			IMeterInfoService meterInfoService = (IMeterInfoService)getBean("meterInfoService");
			List<MeterInfo> meterInfoList = null;		
			logger.debug(" -- semmel006Bean.getNotExpenseSite().getMeterId() :"+semmel006Bean.getNotExpenseSite().getMeterId());
			logger.debug(" -- semmel006Bean.getNotExpenseSite().getMeterId() :"+semmel006Bean.getNotExpenseSite().getInvAreaCode());
			
			logger.debug(" --semmel006Bean.getPayment().getCompany() :"+semmel006Bean.getPayment().getCompany());
			logger.debug(" --semmel006Bean.getPayment().getElectricUseType() :"+semmel006Bean.getPayment().getElectricUseType());
			
			//meterInfoList = meterInfoService.findByMeterId(semmel006Bean.getNotExpenseSite().getMeterId());			
			meterInfoList = meterInfoService.queryMeterListByPayment(semmel006Bean.getPayment(),semmel006Bean.getNotExpenseSite());			
			
			if (null == meterInfoList || meterInfoList.isEmpty()) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("M0004"), ""));
				//semmel006Bean.setNotExpenseSite(new PaymentDetail());
			}else{				
				MeterInfo meterInforesult = meterInfoList.get(0);
				//logger.debug(" Found meterInfo :"+BeanUtils.getBeanString(meterInforesult));			
				semmel006Bean.getNotExpenseSite().setInvSiteName(meterInforesult.getElectricId().getSiteName());
				semmel006Bean.getNotExpenseSite().setMeterId(meterInforesult.getMeterId());
				semmel006Bean.getNotExpenseSite().setInvAreaCode(meterInforesult.geteAreaCode());
				semmel006Bean.getNotExpenseSite().setInvAreaName(meterInforesult.geteAreaName());
			}	
		} catch (Exception e) {			
			addMessageError("E0003");
			e.printStackTrace();
		}		

		return flagValid;
	}

	public boolean initDeleteNotExpenseSite(){
		boolean flag = false;		
		try{
			semmel006Bean = getSemmel006Bean();	  				
			String rowIndex = (String)getFacesUtils().getRequestParameter("rowIndex");
			logger.debug(" -- initDeleteNotExpenseSite rowIndex :"+ rowIndex);	
			semmel006Bean.setRemoveItemId(rowIndex);			
			semmel006Bean.setPopupMsg( MSGCacheUtil.getInstance().getMessageByCode("EL0004"));
			//logger.debug(" -- initDeleteNotExpenseSite :"+ deleteRowId);			
		}catch(Exception ex){
			ex.printStackTrace();
		}

		return flag;
	}
	
	private boolean doDeleteNotExpenseSite() {
		logger.debug(" -- doDeleteNotExpenseSite--");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	
			String rowIndex = semmel006Bean.getRemoveItemId();	
			List notExpenseTmpList = semmel006Bean.getNotExpenseSiteList();
			
			//WT###Add 20110112 Start
			PaymentDetail paymentDetail = (PaymentDetail) notExpenseTmpList.get(Integer.parseInt(rowIndex));
			paymentDetail.setDeleted(true);
			semmel006Bean.getDeletedPaymentDetailList().add(paymentDetail);
			//WT###Add 20110112 End
			
			notExpenseTmpList.remove(Integer.parseInt(rowIndex));
			semmel006Bean.setNotExpenseSiteListSize(semmel006Bean.getNotExpenseSiteList().size());
			
			recalculateAdNewExpenseSite();
			if(semmel006Bean.getNotExpenseSiteList()==null||semmel006Bean.getNotExpenseSiteList().size()==0){
				semmel006Bean.setDisabledBtnExport(true);
			}else{
				semmel006Bean.setDisabledBtnExport(false);
			}				
		}catch(Exception ex){
			ex.printStackTrace();
		}	
		return flagValid;
	}	
	
	private boolean doSaveELBill() {
		logger.debug(" -- doSaveELBill--");
		boolean flagValid = false;				
		try {
			if (validatePayment(ELUtils.EL_BILL)) {
				return true;
			}						
			SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");	
			semmel006Bean = getSemmel006Bean();	     
			Payment paymentSave = semmel006Bean.getPayment();
			paymentSave.setExpenseType(ELUtils.EL_BILL);
			paymentSave.setVatAmt(paymentSave.getDbTotalVat());
			paymentSave.setExcludeVatAmt(paymentSave.getDbTotalExcludeVat());
			paymentSave.setIncludeVatAmt(paymentSave.getDbTotalIncludeVat());
			paymentSave.setPaymentStatus("01");
			//paymentSave.setVatType("01");
			//paymentSave.setVatType("01");
			
			
			
			if(!semmel006Bean.isComeFromPage8())
			{
				paymentSave.setInvPayAmt(paymentSave.getPayAmt());
				paymentSave.setPayAmt(null);
				logger.debug(" -- doSaveELBill-- 1");
			}else{
				paymentSave.setInvPayAmt(paymentSave.getPayAmt());
				paymentSave.setPayAmt(null);
				logger.debug(" -- doSaveELBill-- 2");
			}
			
			paymentSave.setRecordStatus("Y");
			
			paymentSave.setVersion(new BigDecimal(1));
			paymentSave.setVatRate(new BigDecimal(7));
			
			paymentSave.setChqAmt(paymentSave.getDbTotalIncludeVat());						
			
			List<PaymentDetail> detailList = semmel006Bean.getNotExpenseSiteList();				
			for(PaymentDetail detailtmp:detailList){
				///detailtmp.setMeterId(meterId);
				//detailtmp.setVatType("01");
				detailtmp.setVatRate(new BigDecimal(7));
				detailtmp.setRecordStatus("Y");				
				detailtmp.setExpenseType(ELUtils.EL_BILL);
				detailtmp.setVatAmt(detailtmp.getInvVatAmt());
				detailtmp.setExcludeVatAmt(detailtmp.getInvExcludeVatAmt());
				detailtmp.setIncludeVatAmt(detailtmp.getInvIncludeVatAmt());
				detailtmp.setChqAmt(detailtmp.getInvIncludeVatAmt());				
				String meterIdTmp = detailtmp.getMeterId()+"";
				detailtmp.setDetailFlag("N");
				//detailtmp.setMeterId("");
				detailtmp.setInvMeterId(meterIdTmp);	
				
				//logger.debug(" meterId:"+detailtmp.getMeterId());
			}
			
			// Validate Duplicate
	 		//�������ö�ԡ����� ����� ����ѷ, ������������, ����Ţ������͡�����ҧ�ԧ���		
			boolean isDuplicate = false;
			IPaymentService service = (IPaymentService)getBean("paymentService");	
			Payment isDupPayment = new Payment();
			logger.debug("WT### semmel006Bean.isComeFromPage8()"+semmel006Bean.isComeFromPage8());
			
			if(!semmel006Bean.isComeFromPage8()){//New action
				logger.debug("WT### New Action");
				isDupPayment.setCompany(paymentSave.getCompany());
				isDupPayment.setElectricUseType(paymentSave.getElectricUseType());
				isDupPayment.setDocNo(paymentSave.getDocNo());
				//isDuplicate = service.isDuplicatePayment(isDupPayment);
				
				if(isDuplicate){							
					addMessageError(ELUtils.EL0013);
					return true;			
				}else{	
					//logger.debug(" pament to save :"+BeanUtils.getBeanString(paymentSave));
					// Add Special Record
					PaymentDetail  specialPaymentDetail = new PaymentDetail();		
					specialPaymentDetail.setExpenseType(ELUtils.EL_BILL);
					specialPaymentDetail.setVatType(paymentSave.getVatType());
					specialPaymentDetail.setVatRate(new BigDecimal(7));
					specialPaymentDetail.setVatAmt(paymentSave.getDbTotalVat());
					specialPaymentDetail.setExcludeVatAmt(paymentSave.getDbTotalExcludeVat());
					specialPaymentDetail.setIncludeVatAmt(paymentSave.getDbTotalIncludeVat());
					specialPaymentDetail.setChqAmt(paymentSave.getDbTotalIncludeVat());
					specialPaymentDetail.setRecordStatus("Y");
					specialPaymentDetail.setCreateDt(Calendar.getInstance().getTime());
					specialPaymentDetail.setCreateBy(ssoBean.getUserName());
					specialPaymentDetail.setDetailFlag("Y");
					specialPaymentDetail.setPayAmt(null);
					
					detailList.add(specialPaymentDetail);
					
					service.mergePayment(paymentSave,detailList);				
					addMessageInfo("M0001");
					initPaymentELBill();
				}
			}else{//Edit action
				logger.debug("WT### Edit Action");
				//isDuplicate = service.isDuplicatePayment4Update(paymentSave);
				if(isDuplicate){							
					addMessageError(ELUtils.EL0013);
					return true;			
				}else{			
					logger.info("START Service updatePaymentPage6");
					PaymentDetail  specialPaymentDetail = new PaymentDetail();		
					logger.info("<<<<<<<<<<<<<getRowId"+ semmel006Bean.getSpecialExpenseSite().getRowId());
					logger.info("<<<<<<<<<<<<<getSpecialExpenseSite"+ semmel006Bean.getSpecialExpenseSite().getDetailFlag());
					
					specialPaymentDetail.setRowId(semmel006Bean.getSpecialExpenseSite().getRowId());
					specialPaymentDetail.setExpenseType(ELUtils.EL_BILL);
					specialPaymentDetail.setVatType(paymentSave.getVatType());
					specialPaymentDetail.setVatRate(new BigDecimal(7));
					specialPaymentDetail.setVatAmt(paymentSave.getDbTotalVat());
					specialPaymentDetail.setExcludeVatAmt(paymentSave.getDbTotalExcludeVat());
					specialPaymentDetail.setIncludeVatAmt(paymentSave.getDbTotalIncludeVat());
					specialPaymentDetail.setChqAmt(paymentSave.getDbTotalIncludeVat());
					specialPaymentDetail.setRecordStatus("Y");
					specialPaymentDetail.setCreateDt(Calendar.getInstance().getTime());
					specialPaymentDetail.setCreateBy(ssoBean.getUserName());
					specialPaymentDetail.setDetailFlag("Y");
					specialPaymentDetail.setPayAmt(null);
					detailList.add(specialPaymentDetail);
					//detailList.add( semmel006Bean.getSpecialExpenseSite());
					
					detailList.addAll(semmel006Bean.getDeletedPaymentDetailList());
					service.updatePaymentPage6(paymentSave, detailList);
					logger.info("END Service updatePaymentPage6");
					semmel006Bean.setDeletedPaymentDetailList(new ArrayList<PaymentDetail>(0));
					
					addMessageInfo("M0001");
					initPaymentELBill();
					
				}
			}
			
		} catch (Exception e) {
			addMessageError(ELUtils.E0001);
			e.printStackTrace();
		}
		return flagValid;
	}	

	
	//  ---------------- PaymentELPostpaid-------------------------------
	private boolean initPaymentELPostpaid() {
		logger.info("START Action initPaymentELPostpaid");
		boolean flagValid = false;
		try{
			semmel006Bean = getSemmel006Bean();	
			String pageFrom = (String)getFacesUtils().getRequestParameter("navProgram");
			semmel006Bean.setPageFrom(pageFrom);
			
			initialData();
			semmel006Bean.getPaymentDetail().setVatType("01");//WT###Add 20110128
			semmel006Bean.setElExpenseTypeList(ELUtils.filterLOVByLOVValue("4", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name)));		
			semmel006Bean.setElDocTypeList(ELUtils.filterLOVByLOVValue("5", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DOC_TYPE.name)));
			Payment payment = semmel006Bean.getPayment();
			payment.setDocType("I");
			payment.setPaymentType("01");
			payment.setExpenseType("EL_POSTPAID");
			if (payment.getCreateDt()!=null){
				payment.setDisplayCreateDate(SEMDataUtility.convertToThYear(payment.getCreateDt()));
			}
			if (payment.getUpdateDt()!=null){
				payment.setDisplayUpdateDate(SEMDataUtility.convertToThYear(payment.getUpdateDt()));
			}
			semmel006Bean.getPayment().setPaymentMethod(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.CT_PAYMENT_METHOD));//WT###Add 20110207
			Map<String,String> codeMap = new HashMap();
//			codeMap.put(ELUtils.PAYMENT_METHOD_01,ELUtils.PAYMENT_METHOD_01);
//			codeMap.put(ELUtils.PAYMENT_METHOD_02,ELUtils.PAYMENT_METHOD_02);
//			codeMap.put(ELUtils.PAYMENT_METHOD_03,ELUtils.PAYMENT_METHOD_03);
//			codeMap.put(ELUtils.PAYMENT_METHOD_04,ELUtils.PAYMENT_METHOD_04);
//			semmel006Bean.setCtPaymentMethodList(ELUtils.getLOVBtLOVCodeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name), codeMap));
			semmel006Bean.setCtPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name,EX_AND,"CHEQUE",null,null));
			semmel006Bean.setTransferDtDisable(true);
			
			PopupSiteSearch popupSiteSearch = new PopupSiteSearch();
			semmel006Bean.setPopupSiteCriteria(popupSiteSearch);
			semmel006Bean.setPaymentDetailList(new ArrayList());
			semmel006Bean.setDisableUpdateModelButton(true);
			semmel006Bean.setDisableAddModelButton(false);
			semmel006Bean.setDisableMoreThanOneDetail(false);
			
			semmel006Bean.setPaymentTypeMandatory(true);
			semmel006Bean.setPaymentMethodMandatory(true);
			semmel006Bean.setPaymentTypeDisable(false);
			semmel006Bean.setPaymentMethodDisable(false);
			semmel006Bean.getPaymentDetail().setValidatePaymentDetailFlagBoolean(true);
			semmel006Bean.setDisableValidateELPostPaidPaymentDetail(false);
			setSemmel006Bean(semmel006Bean);
			semmel006Bean.setViewMode(false);
			flagValid= true;		
			
			//WT###Add 20110202 Start
			semmel006Bean.setDisableViewExpenseHisButton(true);
			semmel006Bean.setDisableViewMeterInfoButton(true);
			//WT###End 20110202 End
			
			logger.info("END Action initPaymentELPostpaid");
		}catch(Exception ex){
			ex.printStackTrace();
			logger.info("ERROR Action initPaymentELPostpaid : "+ex, ex);
		}

		return flagValid;
	}
	
	private boolean initPopupSearchSiteELPostpaid() {
		boolean flag = false;
		logger.debug(" -- initPopupSearchSiteELPostpaid--");
		try{
			semmel006Bean = getSemmel006Bean();
			PopupSiteSearch popupSiteCriteria = new PopupSiteSearch();
			popupSiteCriteria.setOutstandingFlag("N");
			semmel006Bean.setPopupSiteCriteria(popupSiteCriteria);
			semmel006Bean.setPopupSiteList(new ArrayList());	
			semmel006Bean.setSavePopupSiteDisable(true);	
			 
		}catch(Exception ex){
			ex.printStackTrace();
		}

		return flag;
	}
	

	
	private boolean doSearchSiteELPostpaid() {
		logger.debug(" -- doSearchSiteELPostpaid--Page 6-3 -- ");
		boolean flag = false;
		try {
			semmel006Bean = getSemmel006Bean();
			semmel006Bean.setSavePopupSiteDisable(true);
			List<PopupSiteSearch> popupSiteResultList = null;			
			logger.debug(" -- doSearchSiteELPostpaid :"+semmel006Bean.getPopupSiteCriteria().getRecordStatus());
		

			if("All".equals(semmel006Bean.getPopupSiteCriteria().getRecordStatus())){
				semmel006Bean.getPopupSiteCriteria().setRecordStatus(null);
				logger.debug(" -- All---- :"+semmel006Bean.getPopupSiteCriteria().getRecordStatus());
			}
			
			IPaymentService service = (IPaymentService)getBean("paymentService");	
			popupSiteResultList= service.searchSite(semmel006Bean.getPopupSiteCriteria(),"querySiteELPostpaid");
			logger.debug(" Result Search :"+popupSiteResultList);					
			if (popupSiteResultList != null && !popupSiteResultList.isEmpty()) {
				String firstRowId = popupSiteResultList.get(0).getRowNumber();
				semmel006Bean.setSelectedRadio(firstRowId);	
				semmel006Bean.setPopupSiteList(popupSiteResultList);
				semmel006Bean.setSavePopupSiteDisable(false);
				/*WT###Comment 20110325for(PopupSiteSearch tmp:popupSiteResultList){
					logger.debug(" PopupSiteSearch:"+BeanUtils.getBeanString(tmp));
				}*/
			}else{
				semmel006Bean.setPopupSiteList(new ArrayList());
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("M0004"), ""));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	private boolean doClearSearchSiteELPostpaid() {
		logger.debug(" -- doClearSearchSiteELPostpaid--");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();
			PopupSiteSearch popupSiteCriteria = new PopupSiteSearch();
			semmel006Bean.setPopupSiteCriteria(popupSiteCriteria);
			semmel006Bean.setPopupSiteList(new ArrayList());	
			semmel006Bean.setSavePopupSiteDisable(true);			
		}catch(Exception ex){
			ex.printStackTrace();
		}

		return flagValid;
	}	

	public boolean doAddSiteELPostpaid() {
		logger.debug(" --  doAddSiteELPostpaid --");
		boolean flag = false;
		try{
			semmel006Bean = getSemmel006Bean();
			
			//WT###Add 20110202 Start
			semmel006Bean.setDisableViewExpenseHisButton(false);
			semmel006Bean.setDisableViewMeterInfoButton(false);
			//WT###End 20110202 End
			
			String idSelect = semmel006Bean.getSelectedRadio();
			logger.debug(" rowIdSelect :"+idSelect);
		
			List<PopupSiteSearch> siteList = semmel006Bean.getPopupSiteList();
			boolean isSelect = false;
			if (siteList != null && !siteList.isEmpty()) {
				//PopupSiteSearch selectSite = (PopupSiteSearch)siteList.get(Integer.parseInt(idSelect)-1);
				PopupSiteSearch selectSite = null;
				for(PopupSiteSearch tmp:siteList){
					if(idSelect.equalsIgnoreCase(tmp.getRowNumber())){
						selectSite = tmp;
						isSelect = true;
						break;
					}
				}
//				System.out.println(" PopupSiteSearch select :"+BeanUtils.getBeanString(selectSite));
//				System.out.println("networkStatus = "+selectSite.getNetworkStatus());
				//networkStatus 05=offService,06=remove
				if(StringUtils.equals("05", selectSite.getNetworkStatus()) || 
						StringUtils.equals("06", selectSite.getNetworkStatus())){
					semmel006Bean.setStyleClassName("ms14red");
				}else{
					semmel006Bean.setStyleClassName("ms7");
				}
				
				if(StringUtils.equals("fail", selectSite.getResult().toLowerCase())){
					FrontMessageUtils.addMessageError(selectSite.getRemark());
				}
				
				semmel006Bean.setPopupSiteCriteria(selectSite);
				semmel006Bean.getPayment().setElectricUseType(semmel006Bean.getPopupSiteCriteria().getElectricUseType());
				changeElectricUseType_ELPospaid();
				chkDisableBtnPercentGroup();
			}		
			if(!isSelect){
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0015"), ""));
			}				
			
			setSemmel006Bean(semmel006Bean);
		}catch(Exception ex){
			ex.printStackTrace();
		}

		return flag;
	}
	
	
	private boolean initPopupSearchOldDoc() {
		logger.debug(" --  initPopupSearchOldDoc --");
		boolean flag = false;
		try{
			semmel006Bean = getSemmel006Bean();
			PopupOldDocSearch pPopupOldDocSearch = new PopupOldDocSearch();
			semmel006Bean.setSavePopupOldDocDisable(true);
			semmel006Bean.setPopupOldDocCriteria(pPopupOldDocSearch);	
			semmel006Bean.setPopupOldDocList(new ArrayList());		
		}catch(Exception ex){
			ex.printStackTrace();
		}

		return flag;
	}
	
	
	private boolean doSearchPopupOldDoc() {
		boolean flag = false;
		try {
			if (validatedoSearchPopupOldDoc()) {
				return flag;
			}
			semmel006Bean = getSemmel006Bean();
			List<PopupOldDocSearch> popupOldDocResultList = null;			
			IPaymentService service = (IPaymentService)getBean("paymentService");
			//to = service.searchSite(EQueryName.Q_SEARCH_EL_SITE.name, semmel006Bean.getPopupSiteCriteria());
			popupOldDocResultList= service.searchOldDoc(semmel006Bean.getPopupOldDocCriteria());
			logger.debug(" Result Search :"+popupOldDocResultList);			
			
			if (popupOldDocResultList != null && !popupOldDocResultList.isEmpty()) {
				for(PopupOldDocSearch tmp:popupOldDocResultList){
					logger.debug(" PopupOldDocSearch:"+tmp );
				}
				semmel006Bean.setPopupOldDocList(popupOldDocResultList);				 
				String firstRowId = popupOldDocResultList.get(0).getDocNo();
				semmel006Bean.setSelectedRadio(firstRowId);					 
				semmel006Bean.setSavePopupOldDocDisable(false);
			}else{
				semmel006Bean.setSavePopupOldDocDisable(true);
				semmel006Bean.setPopupOldDocList(new ArrayList());
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("M0004"), ""));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	private boolean doClearSearchOldDoc() {
		logger.debug(" -- doClearSearchOldDoc--");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();
			PopupOldDocSearch pPopupOldDocSearch = new PopupOldDocSearch();		
			semmel006Bean.setPopupOldDocCriteria(pPopupOldDocSearch);			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	
		return flagValid;
	}	
	
	
	public boolean doAddOldDoc() {
		logger.debug(" --  doAddOldDoc --");
		boolean flag = false;
		try{
			semmel006Bean = getSemmel006Bean();
			List<PopupOldDocSearch> returnList = semmel006Bean.getPopupOldDocList();
			if (returnList != null && !returnList.isEmpty()) {
				for (PopupOldDocSearch tmp : returnList) {
					if (tmp.getDocNo().equals(semmel006Bean.getSelectedRadio())) {
//						System.out.println(" PopupOldDocSearch select >"+semmel006Bean.getSelectedRadio()+" :"+BeanUtils.getBeanString(tmp));						
						semmel006Bean.getPayment().setRefDocNo(tmp.getDocNo());
						semmel006Bean.getPayment().setRefDocDt(tmp.getDocDt());
						semmel006Bean.getPayment().setRefDocType(tmp.getDocType());
						break;
					}
				}
			}				
		}catch(Exception ex){
			ex.printStackTrace();
		}

		return flag;
	}	

	public boolean doAddELPostpaidToModel3() {
		logger.debug(" --  doAddELPostpaidToModel3-Page 6-3");
		boolean flag = false;
		boolean validatePayment = false;
		boolean validatePaymentDetail = false;
		//String  expenseType =
		try{
			//if (validateELPostpaid()) {
			if(validateELPostpaidByExpenseType()){
				validatePayment =true;
			}
			
			if (validatedoAddPostpaidModel()) {
				validatePaymentDetail=true;
			}
			
			if(validatePayment||validatePaymentDetail){
				return flag;
			}
			
		
			logger.debug(" -- --  doAddELPostpaidToModel: Page 6-3 Validate Success----");	
			// 1. Get Payment Detail Size
			semmel006Bean = getSemmel006Bean();	
			
			
			Payment newPayment = semmel006Bean.getPayment();
			ELUtils.copySearchsiteToPayment(semmel006Bean.getPopupSiteCriteria(), newPayment);		
			ELUtils.setPamentDisplayField(newPayment);
			// 2. Get new PaymentDetail
			PaymentDetail paymentDetail = semmel006Bean.getPaymentDetail();			
			String vatType = paymentDetail.getVatType();//WT###Add 20110128
			logger.debug("WT### vatType="+vatType);
			//paymentDetail.setTermOfPaymentDt(ELUtils.getDateByMonthandYear(paymentDetail.getTermOfPaymentDtMonth(), paymentDetail.getTermOfPaymentDtYear()));
			
			//--------------------------------------------
			//logger.debug("-------------------------------------------------------------");
			//List<PaymentDetail> paymentDetailListValdation = semmel006Bean.getPaymentDetailList();
			
			//if(validateMeaTermOfPayment(paymentDetailListValdation,paymentDetail)){
				//return flag;
			//}
			//logger.debug("-------------------------------------------------------------");
			//
			
			boolean cllPLsuccess = true;
			String plElectricId = semmel006Bean.getPopupSiteCriteria().getElectricId();
			String plMeterInfoId = semmel006Bean.getPopupSiteCriteria().getMeterInfoId();
			String meterId = semmel006Bean.getPopupSiteCriteria().getMeterId();
			paymentDetail.setMeterId(meterId);

			
			PaymentDetail detailForcallPL = new PaymentDetail();
			detailForcallPL.setReferMeterId(plElectricId);
			detailForcallPL.setMeterId(plMeterInfoId);
			detailForcallPL.setpDate(paymentDetail.getpDate());
			detailForcallPL.setlDate(paymentDetail.getlDate());
			detailForcallPL.setpRead(paymentDetail.getpRead());
			detailForcallPL.setlRead(paymentDetail.getlRead());
			detailForcallPL.setKwhTotal(paymentDetail.getKwhTotal());
			detailForcallPL.setTermOfPaymentDt(paymentDetail.getTermOfPaymentDt());
			detailForcallPL.setValidatePaymentDetailFlag(paymentDetail.getValidatePaymentDetailFlag());
			//-------------------------------------------------------------------------
			
			//logger.debug("paymentDetail.getExpenseType():"+ paymentDetail.getExpenseType());
			//logger.debug("newPayment.getExpenseType()"+ newPayment.getExpenseType());
			logger.debug("paymentDetail.isValidatePaymentDetailFlagBoolean:"+ paymentDetail.isValidatePaymentDetailFlagBoolean());
			logger.debug("paymentDetail.getValidatePaymentDetailFlag:"+ paymentDetail.getValidatePaymentDetailFlag());
			
			
			int numberOfTermOfPayment = doGetNumberTermOfPayment(paymentDetail).size();
			
			logger.debug("<<<<<numberOfTermOfPayment:"+numberOfTermOfPayment);
			boolean validateTermOfPaymentFlase = true;
			
			for(Date tmp: doGetNumberTermOfPayment(paymentDetail)){	
			//logger.debug("%%%%%%%%%%%%%%%%%%%%%%"+ELUtils.getMonthYearFromDate(tmp));
			//detailForcallPL.setFromTermOfPaymentDt(ELUtils.getDateByMonthandYear(ELUtils.getMonthNumberByDate(tmp) ,ELUtils.getYearNumberByDate(tmp,"th")));
			//detailForcallPL.setToTermOfPaymentDt(ELUtils.getEndDateByMonthandYear( ELUtils.getMonthNumberByDate(tmp),ELUtils.getYearNumberByDate(tmp,"th")));
			//detailForcallPL.setFromTermOfPaymentDt(paymentDetail.getFromTermOfPaymentDt());
			//detailForcallPL.setToTermOfPaymentDt(paymentDetail.getToTermOfPaymentDt());
			
			logger.debug("<<<<<detailForcallPL.getValidatePaymentDetailFlag():"+detailForcallPL.getValidatePaymentDetailFlag());
			if(detailForcallPL.getValidatePaymentDetailFlag().equalsIgnoreCase("N")){
				detailForcallPL.setpDate(paymentDetail.getFromTermOfPaymentDt());
				detailForcallPL.setlDate(paymentDetail.getToTermOfPaymentDt());	
			}
			
			detailForcallPL.setTermOfPaymentDt(ELUtils.getDateByMonthandYear(ELUtils.getMonthNumberByDate(tmp) ,ELUtils.getYearNumberByDate(tmp,"th")));
			//detailForcallPL.setTermOfPaymentDt(tmp);
			logger.debug(" <<<<<<<<<< TermOfPaymentDtTH:"+detailForcallPL.getTermOfPaymentDtTH());
			logger.debug(" <<<<<<<<<< getpDateTH:"+detailForcallPL.getpDateTH());
			logger.debug(" <<<<<<<<<< getlDateTH:"+detailForcallPL.getlDateTH());
			
			//detailForcallPL.setExpenseType(paymentDetail.getExpenseType());
			detailForcallPL.setExpenseType(newPayment.getExpenseType());
			IPaymentService service = (IPaymentService)getBean("paymentService");	
			ParameterConfig parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_PAYMENT_E001");
			List plresult = service.addELPostpaidToModel(parameter.getParamValue(), detailForcallPL);
			logger.debug(" pl return value site :"+plresult.get(0));
			String value0 =(String)plresult.get(0);
			if(value0.equals("00")){							
				if(validateTermOfPaymentFlase){
				  validateTermOfPaymentFlase = true;
				}
					logger.debug(" <<<<<<<<<< Validate Completed:"+detailForcallPL.getFromTermOfPaymentDtTH());
				
			}else{
				validateTermOfPaymentFlase = false;
				logger.debug(" <<<<<<<<<< Validate Fail:"+detailForcallPL.getFromTermOfPaymentDtTH());
				logger.debug(" error desc;"+plresult.get(1));
				FrontMessageUtils.addMessageError((String)plresult.get(1)+":"+ detailForcallPL.getFromTermOfPaymentDtTH());
				}
			}     
			//value0="00";			
			if(validateTermOfPaymentFlase){				
			//if(true){
			//logger.info(" paymentDetail before Add to Model :"+BeanUtils.getBeanString(paymentDetail));
			// 3. Get Payment Detail List
			List<PaymentDetail> paymentDetailList = semmel006Bean.getPaymentDetailList();					
			// 3. Add new PaymentDetail to Model
			ELUtils.copySearchsiteToPaymentDetail(semmel006Bean.getPopupSiteCriteria(), paymentDetail);
			ELUtils.setPamentDetailDisplayField(paymentDetail);
			if(paymentDetailList==null||paymentDetailList.size()==0){
				logger.info(" paymentDetailList before add temp Payment detail size: 0");
				paymentDetail.setRowNumber(1);
				List<PaymentDetail> newDetailList = new ArrayList<PaymentDetail>();				
				newDetailList.add(paymentDetail);				
				semmel006Bean.setPaymentDetailList(newDetailList);			
			}else{
				logger.info(" paymentDetailList before add temp Payment detail size:"+paymentDetailList.size());
				int maxCurrentRow = ((PaymentDetail)paymentDetailList.get(paymentDetailList.size()-1)).getRowNumber() +1;
				paymentDetail.setRowNumber(maxCurrentRow);
				semmel006Bean.getPaymentDetailList().add(paymentDetail);				
			}									
			
			ELUtils.setPamentDisplayField(semmel006Bean.getPayment());			
			reCalculatePaymentConclutionPosPaid(semmel006Bean.getPaymentDetailList(),semmel006Bean.getPayment());
			
			logger.debug(" size after add model  :"+semmel006Bean.getPaymentDetailList().size() );	
			if(semmel006Bean.getPaymentDetailList()==null||semmel006Bean.getPaymentDetailList().size()<=0){
				semmel006Bean.setDisableMoreThanOneDetail(false);
			}else{
				semmel006Bean.setDisableMoreThanOneDetail(true);
			}
			semmel006Bean.setPaymentDetail(new PaymentDetail());	
			
			
			
			semmel006Bean.getPaymentDetail().setVatType(vatType);//WT###Add 20110128
			}
				
		}catch(Exception ex){
			addMessageError(ELUtils.E0001);
			ex.printStackTrace();
		}
		return flag;
	}	
	
	public boolean doAddPRPostpaidToModel() {
		logger.debug(" --  doAddPRPostpaidToModel 1--");
		boolean flag = false;
		try{
			if (validateELPRPostpaid()){
				return flag;
			}	
			if (validatedoAddPRPostpaidModel()) {
				logger.debug(" -- validatedoAddPRPostpaidModel Error return --");
				return flag;
			}					
			// 1. Get Payment Detail Size
			
			semmel006Bean = getSemmel006Bean();			
			Payment newPayment = semmel006Bean.getPayment();
			ELUtils.copySearchsiteToPayment(semmel006Bean.getPopupSiteCriteria(), newPayment);		
			
			// 2. Get new PaymentDetail
			PaymentDetail paymentDetail = semmel006Bean.getPaymentDetail();				
	
			//logger.info(" paymentDetail before Add to Model :"+BeanUtils.getBeanString(paymentDetail));
			// 3. Get Payment Detail List
			List<PaymentDetail> paymentDetailList = semmel006Bean.getPaymentDetailList();			
			
			// 3. Add new PaymentDetail to Model
			ELUtils.copySearchsiteToPaymentDetail(semmel006Bean.getPopupSiteCriteria(), paymentDetail);
			ELUtils.setPamentDetailDisplayField(paymentDetail);
			ELUtils.setPamentDisplayField(newPayment);
			
			if(paymentDetailList==null||paymentDetailList.size()==0){
				logger.info(" paymentDetailList before add temp Payment detail size: 0");
				paymentDetail.setRowNumber(1);
				List<PaymentDetail> newDetailList = new ArrayList<PaymentDetail>();				
				newDetailList.add(paymentDetail);
				semmel006Bean.setPaymentDetailList(newDetailList);	
			}else{
				logger.info(" paymentDetailList before add temp Payment detail size:"+paymentDetailList.size());
				int maxCurrentRow = ((PaymentDetail)paymentDetailList.get(paymentDetailList.size()-1)).getRowNumber() +1;
				paymentDetail.setRowNumber(maxCurrentRow);
				semmel006Bean.getPaymentDetailList().add(paymentDetail);				
			}									
			
			ELUtils.setPamentDisplayField(semmel006Bean.getPayment());			
			reCalculatePaymentConclution5(semmel006Bean.getPaymentDetailList(),semmel006Bean.getPayment());
			logger.debug(" size after add model  :"+semmel006Bean.getPaymentDetailList().size() );	
			if(semmel006Bean.getPaymentDetailList()==null||semmel006Bean.getPaymentDetailList().size()<=0){
				semmel006Bean.setDisableMoreThanOneDetail(false);
			}else{
				semmel006Bean.setDisableMoreThanOneDetail(true);
			}
			semmel006Bean.setPaymentDetail(new PaymentDetail());	
	
		}catch(Exception ex){
			addMessageError(ELUtils.E0001);
			ex.printStackTrace();
		}
		return flag;
	}		
	
	
	private boolean validatedoAddPostpaidModel() {
		logger.debug(" -- validatedoAddPostpaidModel--");
		boolean flagValid = false;		
//		System.out.println(" Payment :"+BeanUtils.getBeanString(getSemmel006Bean().getPayment()));
		
		flagValid =validatePaymentDetail(ELUtils.EL_POSTPAID)	;		

		return flagValid;
	}
	private boolean validatedoAddPRPostpaidModel() {
		logger.debug(" -- validatedoAddPRPostpaidModel--");
		boolean flagValid = false;		
//		System.out.println(" Payment :"+BeanUtils.getBeanString(getSemmel006Bean().getPayment()));
		
		flagValid =validatePaymentDetail(ELUtils.PR_POSTPAID)	;		

		return flagValid;
	}	
	
	public boolean initDeleteELPostpaidFromModel(){
		boolean flag = false;		
		try{
			semmel006Bean = getSemmel006Bean();	  				
		String rowIndex = (String)getFacesUtils().getRequestParameter("rowIndex");
		logger.debug(" -- initDeleteELPostpaidFromModel rowIndex :"+ rowIndex);	
		semmel006Bean.setRemoveItemId(rowIndex);			

		}catch(Exception ex){
			ex.printStackTrace();
		}

		return flag;
	}
	public boolean initDeletePaymentDetailFromModel(){
		boolean flag = false;		
		try{
		semmel006Bean = getSemmel006Bean();	  				
		String rowIndex = (String)getFacesUtils().getRequestParameter("rowIndex");
		logger.debug(" -- initDeleteELPostpaidFromModel rowIndex :"+ rowIndex);	
		semmel006Bean.setRemoveItemId(rowIndex);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flag;
	}	
	
	public boolean doDeleteELPostpaidFromModel() {
		logger.debug(" -- doDeleteELPostpaidFromModel--Page 6-3");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	
			String vatType = "";
			if(null!=semmel006Bean.getPaymentDetail()){
				vatType = semmel006Bean.getPaymentDetail().getVatType();
			}
			String rowIndex = semmel006Bean.getRemoveItemId();
			logger.debug("WT### rowIndex = "+rowIndex);
			List paymentDetailList = semmel006Bean.getPaymentDetailList();
			//WT###Add 20110117 Start
			PaymentDetail paymentDetail = (PaymentDetail) paymentDetailList.get(Integer.parseInt(rowIndex));
			paymentDetail.setDeleted(true);
			semmel006Bean.getDeletedPaymentDetailList().add(paymentDetail);
			//WT###Add 20110117 End
			paymentDetailList.remove(Integer.parseInt(rowIndex));
			semmel006Bean.setPaymentDetailList(paymentDetailList);			
			reCalculatePaymentConclution(semmel006Bean.getPaymentDetailList(),semmel006Bean.getPayment());
			if(semmel006Bean.getPaymentDetailList()==null||semmel006Bean.getPaymentDetailList().size()<=0){
				semmel006Bean.getPaymentDetail().setVatType("01");
				semmel006Bean.setDisableMoreThanOneDetail(false);
			}else{
				semmel006Bean.getPaymentDetail().setVatType(vatType);
				semmel006Bean.setDisableMoreThanOneDetail(true);
			}			
			doClearELPostpaid();
			logger.debug(" DisableMoreThanOneDetail:"+semmel006Bean.isDisableMoreThanOneDetail());
		}catch(Exception ex){
			ex.printStackTrace();
		}	
		return flagValid;
	}	
	public boolean doDeletePaymentDetailFromModel() {
		logger.debug(" -- doDeletePaymentDetailFromModel--Page 6-4");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	
			String rowIndex = semmel006Bean.getRemoveItemId();
			logger.debug("###################  doDeletePaymentDetailFromModel rowIndex ::"+rowIndex);			
			//List paymentDetailList = semmel006Bean.getPaymentDetailList();
			
			//delete added by new 20150513
			// 1. Get Payment Detail Size
			semmel006Bean = getSemmel006Bean();			
			Payment newPayment = semmel006Bean.getPayment();
			ELUtils.copySearchsiteToPayment(semmel006Bean.getPopupSiteCriteria(), newPayment);		
			// 2. Get new PaymentDetail
//			PaymentDetail paymentDetail = semmel006Bean.getPaymentDetail();		
					
			PaymentDetail newPaymentDetail = semmel006Bean.getPaymentDetail();					
			ELUtils.setPamentDisplayField(newPayment);
	        ELUtils.setPamentDetailDisplayField(newPaymentDetail);
	        //WT###Edit 20110118 Start
			//List<PaymentDetail> paymentDetailList = newPayment.getPaymentDetailList();
	        List<PaymentDetail> paymentDetailList = semmel006Bean.getPaymentDetailList();
			//WT###Edit 20110118 End
	        PaymentDetail paymentDetailDel = (PaymentDetail) paymentDetailList.get(Integer.parseInt(rowIndex));
	        
			//get Data
			semmel006Bean = getSemmel006Bean();	  				
			logger.debug(" -- doUPdatePaymentDetailFromModel rowIndex :"+ rowIndex);	
			//WT###Add 20110201 Start
			//semmel006Bean.setPaymentDetail((PaymentDetail)paymentDetailList.get(Integer.parseInt(rowIndex)));
			PaymentDetail paymentDetail = (PaymentDetail)paymentDetailList.get(Integer.parseInt(rowIndex));
			paymentDetail.setFromTermOfPaymentMonth(ELUtils.getMonthNumberByDate(paymentDetail.getFromTermOfPaymentDt()));
			//logger.debug(" -- paymentDetail.setWhtCheck -- :"+ paymentDetail.getWhtCheck());	
			//logger.debug(" -- isWhtCheckBoolean -- :"+ paymentDetail.isWhtCheckBoolean());	
			
			
			if(paymentDetail.getWhtType() != null 
				&& (paymentDetail.getWhtType().equals("01")||paymentDetail.getWhtType().equals("02") || paymentDetail.getWhtType().equals("03")
					) ){
				
				paymentDetail.setWhtCheck("Y");
			}
			
			//logger.debug(" -- paymentDetail.setWhtCheck -- :"+ paymentDetail.getWhtCheck());	
			//logger.debug(" -- isWhtCheckBoolean -- :"+ paymentDetail.isWhtCheckBoolean());
			
			semmel006Bean.setPaymentDetail(paymentDetail.clonePaymentDetail());
			semmel006Bean.getPaymentDetail().setFromTermOfPaymentMonth(ELUtils.getMonthNumberByDate(paymentDetail.getFromTermOfPaymentDt()));
			semmel006Bean.getPaymentDetail().setFromTermOfPaymentYear(ELUtils.getYearNumberByDate(paymentDetail.getFromTermOfPaymentDt(), "th"));
			semmel006Bean.getPaymentDetail().setToTermOfPaymentMonth(ELUtils.getMonthNumberByDate(paymentDetail.getToTermOfPaymentDt()));
			semmel006Bean.getPaymentDetail().setToTermOfPaymentYear(ELUtils.getYearNumberByDate(paymentDetail.getToTermOfPaymentDt(), "th"));
			
			//WT###Add 20110201 End
			semmel006Bean.setDisableUpdateModelButton(false);
			semmel006Bean.setDisableAddModelButton(true);
			//WT###Add 20110118 Start
			semmel006Bean.getPopupSiteCriteria().setMeterId(semmel006Bean.getPaymentDetail().getMeterInfoId());
			semmel006Bean.getPopupSiteCriteria().setMeterInfoId(semmel006Bean.getPaymentDetail().getMeterInfoId());
			semmel006Bean.setMeterIdDisable(true);
			semmel006Bean.setDisableFromTermOfPaymentDt(false);
			semmel006Bean.setDisableToTermOfPaymentDt(false);
			semmel006Bean.setWhtRateDisable(false);
			semmel006Bean.setWhtTypeDisable(false);
			semmel006Bean.setWhtAmtDisable(false);
			semmel006Bean.setDisableMoreThanOneDetail(false);
			
			boolean cllPLsuccess = true;
			String plElectricId = semmel006Bean.getPopupSiteCriteria().getElectricId();
			String plMeterInfoId = semmel006Bean.getPopupSiteCriteria().getMeterInfoId();
			String meterId = semmel006Bean.getPopupSiteCriteria().getMeterId();
			paymentDetail.setMeterId(meterId);	
			
			//del from data base
			if(plElectricId != null && plMeterInfoId != null && meterId != null){
				PaymentDetail detailForcallPL = new PaymentDetail();
				detailForcallPL.setReferMeterId(plElectricId);
				detailForcallPL.setMeterId(plMeterInfoId);
				detailForcallPL.setFromTermOfPaymentDt(paymentDetailDel.getFromTermOfPaymentDt());
				detailForcallPL.setToTermOfPaymentDt(paymentDetailDel.getToTermOfPaymentDt());
				detailForcallPL.setProcessType("DEL");
				
				IPaymentService service = (IPaymentService)getBean("paymentService");	
				ParameterConfig parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_PAYMENT_E003");
				logger.debug(" EL_PG_PAYMENT_E003 parameter:"+parameter);
				logger.debug(" service:"+service);
				String value0 = "";
				List plresult  = new ArrayList();
				
				if(semmel006Bean.isByPassValidationELTempTermOfPayment()){
					
					plresult = service.addELTempToModel(parameter.getParamValue(), detailForcallPL);
					logger.debug(" pl return value 4 :"+plresult.get(0));
					 value0 =(String)plresult.get(0);
				}else{
					value0="00";
				}

				//value0="00";
				if("00".equals(value0)){
//					if(paymentDetailList==null||paymentDetailList.size()==0){
//						newPaymentDetail.setRowNumber(1);
//						logger.debug(" rowNumber for first Row:"+newPaymentDetail.getRowNumber() );
//						List<PaymentDetail> newDetailList = new ArrayList<PaymentDetail>();
//						newDetailList.add(newPaymentDetail);
//						newPayment.setPaymentDetailList(newDetailList);
//						semmel006Bean.setPaymentDetailList(newDetailList);
//					}else{
//						int maxCurrentRow = ((PaymentDetail)paymentDetailList.get(paymentDetailList.size()-1)).getRowNumber() +1;
//						logger.debug(" maxCurrentRow:"+maxCurrentRow);
//						newPaymentDetail.setRowNumber(maxCurrentRow);
//						semmel006Bean.getPaymentDetailList().add(newPaymentDetail);				
//					}					
					reCalculatePaymentConclution(semmel006Bean.getPaymentDetailList(),semmel006Bean.getPayment());
					logger.debug(" expenseTypeDisplay:"+ELUtils.getLOVNameByLOVCode(ELUtils.filterLOVByLOVValue("3", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name)),semmel006Bean.getPayment().getExpenseType()));					
					if(semmel006Bean.getPaymentDetailList()==null||semmel006Bean.getPaymentDetailList().size()<=0){
						semmel006Bean.setDisableMoreThanOneDetail(false);
					}else{
						semmel006Bean.setDisableMoreThanOneDetail(true);
					}
					
					String oldVatType = semmel006Bean.getPaymentDetail().getVatType();
					PaymentDetail payDetail  = new PaymentDetail();
					payDetail.setVatType(oldVatType);
					semmel006Bean.setPaymentDetail(payDetail);
					logger.debug(" Set vatTyp xx :"+semmel006Bean.getPaymentDetail().getVatType());
					addMessageInfo("M0001");
				}else{
					logger.debug(" error desc;"+plresult.get(1));
					FrontMessageUtils.addMessageError((String)plresult.get(1));
				}
			}
			
			//WT###Add 20110117 Start
//			PaymentDetail paymentDetailDel = (PaymentDetail) paymentDetailList.get(Integer.parseInt(rowIndex));
			paymentDetailDel.setDeleted(true);
			semmel006Bean.getDeletedPaymentDetailList().add(paymentDetailDel);
			//WT###Add 20110117 End
			paymentDetailList.remove(Integer.parseInt(rowIndex));			
			semmel006Bean.setPaymentDetailList(paymentDetailList);			
			reCalculatePaymentConclution(semmel006Bean.getPaymentDetailList(),semmel006Bean.getPayment());
			if(semmel006Bean.getPaymentDetailList()==null||semmel006Bean.getPaymentDetailList().size()<=0){
				semmel006Bean.setDisableMoreThanOneDetail(false);
		
				semmel006Bean.setMeterIdDisable(false);
				semmel006Bean.setExpenseTypeDisable(false);
				semmel006Bean.setDocTypeDisable(false);
				semmel006Bean.setDocNoDisable(false);
				semmel006Bean.setDocDtDisable(false);
			
	
			}else{
				semmel006Bean.setDisableMoreThanOneDetail(true);
			}
			doClearPaymentDetailELTemp();
//			System.out.println("  dsableMoreThanOneDetail:"+semmel006Bean.isDisableMoreThanOneDetail());
			
//			PaymentDetail paymentDetail = new PaymentDetail();
			paymentDetail.setVatType("01");
			semmel006Bean.setPaymentDetail(paymentDetail);
			logger.debug(" Set vatTyp 01");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flagValid;
	}	
	
	public boolean doDeletePaymentDetailFromModel5() {
		logger.debug(" -- doDeletePaymentDetailFromModel5--");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	
			String rowIndex = semmel006Bean.getRemoveItemId();
//			System.out.println("###################  doDeletePaymentDetailFromModel rowIndex ::"+rowIndex);			
			List paymentDetailList = semmel006Bean.getPaymentDetailList();
			//WT###Add 20110117 Start
			PaymentDetail paymentDetailDel = (PaymentDetail) paymentDetailList.get(Integer.parseInt(rowIndex));
			paymentDetailDel.setDeleted(true);
			semmel006Bean.getDeletedPaymentDetailList().add(paymentDetailDel);
			//WT###Add 20110117 End
			paymentDetailList.remove(Integer.parseInt(rowIndex));
			semmel006Bean.setPaymentDetailList(paymentDetailList);			
			reCalculatePaymentConclution5(semmel006Bean.getPaymentDetailList(),semmel006Bean.getPayment());
			if(semmel006Bean.getPaymentDetailList()==null||semmel006Bean.getPaymentDetailList().size()<=0){
				semmel006Bean.setDisableMoreThanOneDetail(false);
		
				semmel006Bean.setMeterIdDisable(false);
				semmel006Bean.setExpenseTypeDisable(false);
				semmel006Bean.setDocTypeDisable(false);
				semmel006Bean.setDocNoDisable(false);
				semmel006Bean.setDocDtDisable(false);
			
	
			}else{
				semmel006Bean.setDisableMoreThanOneDetail(true);
			}
//			System.out.println("  dsableMoreThanOneDetail:"+semmel006Bean.isDisableMoreThanOneDetail());
			
			PaymentDetail paymentDetailVatType = new PaymentDetail();
			paymentDetailVatType.setVatType("01");
			semmel006Bean.setPaymentDetail(paymentDetailVatType);
			logger.debug(" Set vatTyp 01");
		}catch(Exception ex){
			ex.printStackTrace();
		}	
		return flagValid;
	}		
	public boolean initUPdateELPostpaidFromModel(){
		boolean flag = false;		
		try{
			semmel006Bean = getSemmel006Bean();	  				
			String rowIndex = (String)getFacesUtils().getRequestParameter("rowIndex");
			logger.debug(" -- initUPdateELPostpaidFromModel rowIndex :"+ rowIndex);	
			semmel006Bean.setEditItemId(rowIndex);			
				
			}catch(Exception ex){
			ex.printStackTrace();
		}
		return flag;
	}
	public boolean initUPdatePaymentDetailFromModel(){
		boolean flag = false;		
		try{
			semmel006Bean = getSemmel006Bean();	  				
			String rowIndex = (String)getFacesUtils().getRequestParameter("rowIndex");
			logger.debug(" -- initUPdatePaymentDetailFromModel rowIndex :"+ rowIndex);	
			semmel006Bean.setEditItemId(rowIndex);			
				
			}catch(Exception ex){
			ex.printStackTrace();
		}
		return flag;
	}	
	
	public boolean initUPdatePaymentDetailFromModel(String index){
		boolean flag = false;		
		try{
			semmel006Bean = getSemmel006Bean();	  				
			String rowIndex = index;
			logger.debug(" -- initUPdatePaymentDetailFromModel rowIndex :"+ rowIndex);	
			semmel006Bean.setEditItemId(rowIndex);			
				
			}catch(Exception ex){
			ex.printStackTrace();
		}
		return flag;
	}	
	
	public boolean doUPdateELPostpaidFromModel(){
		boolean flag = false;		
		try{
			semmel006Bean = getSemmel006Bean();	  			
			String rowIndex = semmel006Bean.getEditItemId();			
			logger.debug(" -- doUPdateELPostpaidFromModel rowIndex :"+ rowIndex);	
			List paymentDetailList = semmel006Bean.getPaymentDetailList();
			//WT###Edit 20110119 Start
			PaymentDetail paymentDetail = (PaymentDetail)paymentDetailList.get(Integer.parseInt(rowIndex));
			//paymentDetail.setTermOfPaymentDtMonth(ELUtils.getMonthNumberByDate(paymentDetail.getTermOfPaymentDt()));
			//paymentDetail.setTermOfPaymentDtYear(ELUtils.getYearNumberByDate(paymentDetail.getTermOfPaymentDt(), "th"));
			paymentDetail.setFromTermOfPaymentMonth(ELUtils.getMonthNumberByDate(paymentDetail.getFromTermOfPaymentDt()));
			paymentDetail.setFromTermOfPaymentYear(ELUtils.getYearNumberByDate(paymentDetail.getFromTermOfPaymentDt(), "th"));
			paymentDetail.setToTermOfPaymentMonth(ELUtils.getMonthNumberByDate(paymentDetail.getToTermOfPaymentDt()));
			paymentDetail.setToTermOfPaymentYear(ELUtils.getYearNumberByDate(paymentDetail.getToTermOfPaymentDt(), "th"));
			
			logger.debug(" -- XXXXX paymentDetail.getValidatePaymentDetailFlag :"+ paymentDetail.getValidatePaymentDetailFlag());
			logger.debug(" -- XXXXX paymentDetail.getValidatePaymentDetailFlag :"+ paymentDetail.isValidatePaymentDetailFlagBoolean());
			/*
			if(paymentDetail.getValidatePaymentDetailFlag().equalsIgnoreCase("Y")){
				paymentDetail.setValidatePaymentDetailFlagBoolean(true);
			}
			else{
				paymentDetail.setValidatePaymentDetailFlagBoolean(false);	
			}
			*/
			//semmel006Bean.setPaymentDetail((PaymentDetail)paymentDetailList.get(Integer.parseInt(rowIndex)));
			semmel006Bean.setPaymentDetail(paymentDetail.clonePaymentDetail());
			//WT###Edit 20110119 End
			semmel006Bean.setDisableUpdateModelButton(false);
			semmel006Bean.setDisableAddModelButton(true);
			//WT###Add 20110127 Start
			semmel006Bean.setDisableTermOfPaymentDtMonth(false);
			semmel006Bean.setDisableTermOfPaymentDtYear(false);
			//WT###Add 20110127 End
			//WT###Add 20110131 Start
			semmel006Bean.setDisableMoreThanOneDetail(false);
			//WT###Add 20110131 End
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flag;
	}	
	public boolean doUPdatePaymentDetailFromModel(){
		boolean flag = false;		
		try{
			semmel006Bean = getSemmel006Bean();	  			
			System.out.println("semmel006Bean.paymentDetailList   ");
			String rowIndex = semmel006Bean.getEditItemId();		
			//String rowIndex = "0";
			logger.debug(" -- doUPdatePaymentDetailFromModel rowIndex :"+ rowIndex);	
			
			List paymentDetailList = semmel006Bean.getPaymentDetailList();
			//WT###Add 20110201 Start
			//semmel006Bean.setPaymentDetail((PaymentDetail)paymentDetailList.get(Integer.parseInt(rowIndex)));
			PaymentDetail paymentDetail = (PaymentDetail)paymentDetailList.get(Integer.parseInt(rowIndex));
			paymentDetail.setFromTermOfPaymentMonth(ELUtils.getMonthNumberByDate(paymentDetail.getFromTermOfPaymentDt()));
 			
			System.out.println("paymentDetail>>"+paymentDetail.toString());
//			
//			if(paymentDetail.getWhtType().equals("03")){				
//				paymentDetail.setWhtCheck("N");			
//				paymentDetail.setWhtCheckBoolean(false);
//			}else{
//				if(paymentDetail.getWhtType()!=null){					
//					paymentDetail.setWhtCheck("Y");			
//					paymentDetail.setWhtCheckBoolean(true);
//				}
//			}
			
			semmel006Bean.setPaymentDetail(paymentDetail.clonePaymentDetail());
			semmel006Bean.getPaymentDetail().setFromTermOfPaymentMonth(ELUtils.getMonthNumberByDate(paymentDetail.getFromTermOfPaymentDt()));
			semmel006Bean.getPaymentDetail().setFromTermOfPaymentYear(ELUtils.getYearNumberByDate(paymentDetail.getFromTermOfPaymentDt(), "th"));
			semmel006Bean.getPaymentDetail().setToTermOfPaymentMonth(ELUtils.getMonthNumberByDate(paymentDetail.getToTermOfPaymentDt()));
			semmel006Bean.getPaymentDetail().setToTermOfPaymentYear(ELUtils.getYearNumberByDate(paymentDetail.getToTermOfPaymentDt(), "th"));
			
			//WT###Add 20110201 End
			semmel006Bean.setDisableUpdateModelButton(false);
			semmel006Bean.setDisableAddModelButton(true);
			//WT###Add 20110118 Start
			semmel006Bean.getPopupSiteCriteria().setMeterId(semmel006Bean.getPaymentDetail().getMeterInfoId());
			semmel006Bean.getPopupSiteCriteria().setMeterInfoId(semmel006Bean.getPaymentDetail().getMeterInfoId());
			semmel006Bean.setMeterIdDisable(true);
			semmel006Bean.setDisableFromTermOfPaymentDt(false);
			semmel006Bean.setDisableToTermOfPaymentDt(false);
			semmel006Bean.setWhtRateDisable(false);
			semmel006Bean.setWhtTypeDisable(false);
			semmel006Bean.setWhtAmtDisable(false);
			semmel006Bean.setDisableMoreThanOneDetail(false);

//			//trong edit 27/09/2021
//			logger.debug(" doUPdatePaymentDetailFromModel-- isDisableMoreThanOneDetail -- :"+ semmel006Bean.isDisableMoreThanOneDetail());
//			logger.debug(" doUPdatePaymentDetailFromModel-- getWhtCheck-- :"+ semmel006Bean.getPaymentDetail().getWhtCheck());	
//			logger.debug(" doUPdatePaymentDetailFromModel-- semmel006Bean isWhtCheckBoolean -- :"+ semmel006Bean.getPaymentDetail().isWhtCheckBoolean());

			//WT###Add 20110118 End
			//WT###Add 20110119 Start
			/*IMeterInfoService meterInfoService = (IMeterInfoService)getBean("meterInfoService");
			List<MeterInfo> meterInfoList = meterInfoService.findByMeterId(semmel006Bean.getPaymentDetail().getMeterInfoId());
			logger.debug("WT### meterInfoList="+meterInfoList);
			MeterInfo meterInfoFromPaymentDetail = null;
			if(null!=meterInfoList && meterInfoList.size()>0){
				meterInfoFromPaymentDetail = meterInfoList.get(0);
			}
			semmel006Bean.setMeterInfo(meterInfoFromPaymentDetail);*/
			//WT###Add 20110119 End
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flag;
	}	
	
	public boolean doUPdatePaymentDetailFromModel(String index){
		boolean flag = false;		
		try{
			semmel006Bean = getSemmel006Bean();	  			
			System.out.println("semmel006Bean.paymentDetailList   ");
			String rowIndex = index;		
			//String rowIndex = "0";
			logger.debug(" -- doUPdatePaymentDetailFromModel rowIndex :"+ rowIndex);	
			
			List paymentDetailList = semmel006Bean.getPaymentDetailList();
			//WT###Add 20110201 Start
			//semmel006Bean.setPaymentDetail((PaymentDetail)paymentDetailList.get(Integer.parseInt(rowIndex)));
			PaymentDetail paymentDetail = (PaymentDetail)paymentDetailList.get(Integer.parseInt(rowIndex));
			paymentDetail.setFromTermOfPaymentMonth(ELUtils.getMonthNumberByDate(paymentDetail.getFromTermOfPaymentDt()));

		
			semmel006Bean.setPaymentDetail(paymentDetail.clonePaymentDetail());
			semmel006Bean.getPaymentDetail().setFromTermOfPaymentMonth(ELUtils.getMonthNumberByDate(paymentDetail.getFromTermOfPaymentDt()));
			semmel006Bean.getPaymentDetail().setFromTermOfPaymentYear(ELUtils.getYearNumberByDate(paymentDetail.getFromTermOfPaymentDt(), "th"));
			semmel006Bean.getPaymentDetail().setToTermOfPaymentMonth(ELUtils.getMonthNumberByDate(paymentDetail.getToTermOfPaymentDt()));
			semmel006Bean.getPaymentDetail().setToTermOfPaymentYear(ELUtils.getYearNumberByDate(paymentDetail.getToTermOfPaymentDt(), "th"));
			
			//WT###Add 20110201 End
			semmel006Bean.setDisableUpdateModelButton(false);
			semmel006Bean.setDisableAddModelButton(true);
			//WT###Add 20110118 Start
			semmel006Bean.getPopupSiteCriteria().setMeterId(semmel006Bean.getPaymentDetail().getMeterInfoId());
			semmel006Bean.getPopupSiteCriteria().setMeterInfoId(semmel006Bean.getPaymentDetail().getMeterInfoId());
			semmel006Bean.setMeterIdDisable(true);
			semmel006Bean.setDisableFromTermOfPaymentDt(false);
			semmel006Bean.setDisableToTermOfPaymentDt(false);
			semmel006Bean.setWhtRateDisable(false);
			semmel006Bean.setWhtTypeDisable(false);
			semmel006Bean.setWhtAmtDisable(false);
			semmel006Bean.setDisableMoreThanOneDetail(false);
			//logger.debug(" -- paymentDetail.setWhtCheck -- :"+ semmel006Bean.isDisableMoreThanOneDetail());
			//logger.debug(" --semmel006Bean paymentDetail.setWhtCheck -- :"+ semmel006Bean.getPaymentDetail().getWhtCheck());	
			//logger.debug(" -- semmel006Bean isWhtCheckBoolean -- :"+ semmel006Bean.getPaymentDetail());
			
			//WT###Add 20110118 End
			//WT###Add 20110119 Start
			/*IMeterInfoService meterInfoService = (IMeterInfoService)getBean("meterInfoService");
			List<MeterInfo> meterInfoList = meterInfoService.findByMeterId(semmel006Bean.getPaymentDetail().getMeterInfoId());
			logger.debug("WT### meterInfoList="+meterInfoList);
			MeterInfo meterInfoFromPaymentDetail = null;
			if(null!=meterInfoList && meterInfoList.size()>0){
				meterInfoFromPaymentDetail = meterInfoList.get(0);
			}
			semmel006Bean.setMeterInfo(meterInfoFromPaymentDetail);*/
			//WT###Add 20110119 End
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flag;
	}	
	
	
	public boolean doUPdateELPostpaidToModel(){
		boolean flag = false;		
		try{
			if (validateELPostpaidByExpenseType()) {
				return flag;
			}	
			if (validatedoAddPostpaidModel()) {
				return flag;
			}	
			semmel006Bean = getSemmel006Bean();	  			
			String rowIndex = semmel006Bean.getEditItemId();			
			logger.debug(" -- doUPdateELPostpaidToModel rowIndex :"+ rowIndex);	
			
			logger.debug(" -- doUPdateELPostpaidToModel Page 6-3");
			
			List paymentDetailList = semmel006Bean.getPaymentDetailList();			
			
			Payment newPayment = semmel006Bean.getPayment();
			ELUtils.copySearchsiteToPayment(semmel006Bean.getPopupSiteCriteria(), newPayment);		
			// 2. Get new PaymentDetail
			PaymentDetail paymentDetail = semmel006Bean.getPaymentDetail();		
			BigDecimal pRead = paymentDetail.getpRead();//WT###20110325
			paymentDetail.setInvTermOfPaymentDt(
					ELUtils.getDateByMonthandYear(paymentDetail.getFromTermOfPaymentMonth(), paymentDetail.getFromTermOfPaymentYear()));
			//WT###Add 20110119 Start
			String vatType = paymentDetail.getVatType();
			paymentDetail.setTermOfPaymentDt(
					ELUtils.getDateByMonthandYear(paymentDetail.getFromTermOfPaymentMonth(), paymentDetail.getFromTermOfPaymentYear()));
			//WT###Add 20110119 End
			
			boolean cllPLsuccess = true;
			String plElectricId = semmel006Bean.getPopupSiteCriteria().getElectricId();
			String plMeterInfoId = semmel006Bean.getPopupSiteCriteria().getMeterInfoId();
			//Date plPDate = paymentDetail.getpDate();
			//Date plLDate =paymentDetail.getlDate();
			//BigDecimal plPKWh = paymentDetail.getpRead();
		//	BigDecimal plLKWh = paymentDetail.getlRead();
			//BigDecimal plKwhtotal = paymentDetail.getKwhTotal();
			//Date pltermOfPayment = paymentDetail.getInvTermOfPaymentDt();
			
			PaymentDetail detailForcallPL = new PaymentDetail();
			detailForcallPL.setReferMeterId(plElectricId);
			detailForcallPL.setMeterId(plMeterInfoId);
			detailForcallPL.setpDate(paymentDetail.getpDate());
			detailForcallPL.setlDate(paymentDetail.getlDate());
			detailForcallPL.setpRead(paymentDetail.getpRead());
			detailForcallPL.setlRead(paymentDetail.getlRead());
			detailForcallPL.setKwhTotal(paymentDetail.getKwhTotal());
			detailForcallPL.setInvTermOfPaymentDt(paymentDetail.getInvTermOfPaymentDt());
			detailForcallPL.setTermOfPaymentDt(paymentDetail.getInvTermOfPaymentDt());
			//------------------
			detailForcallPL.setExpenseType(newPayment.getExpenseType());
			detailForcallPL.setValidatePaymentDetailFlagBoolean(paymentDetail.isValidatePaymentDetailFlagBoolean());
			int numberOfTermOfPayment = doGetNumberTermOfPayment(paymentDetail).size();
			logger.debug("<<<<<numberOfTermOfPayment:"+numberOfTermOfPayment);
			boolean validateTermOfPaymentFlag = true;
			
			for(Date tmp: doGetNumberTermOfPayment(paymentDetail)){	
			//logger.debug("%%%%%%%%%%%%%%%%%%%%%%"+ELUtils.getMonthYearFromDate(tmp));
			//detailForcallPL.setFromTermOfPaymentDt(ELUtils.getDateByMonthandYear(ELUtils.getMonthNumberByDate(tmp) ,ELUtils.getYearNumberByDate(tmp,"th")));
			//detailForcallPL.setToTermOfPaymentDt(ELUtils.getEndDateByMonthandYear( ELUtils.getMonthNumberByDate(tmp),ELUtils.getYearNumberByDate(tmp,"th")));
			detailForcallPL.setTermOfPaymentDt(ELUtils.getDateByMonthandYear(ELUtils.getMonthNumberByDate(tmp) ,ELUtils.getYearNumberByDate(tmp,"th")));
			detailForcallPL.setFromTermOfPaymentDt(paymentDetail.getFromTermOfPaymentDt());
			detailForcallPL.setToTermOfPaymentDt(paymentDetail.getToTermOfPaymentDt());
			//detailForcallPL.setTermOfPaymentDt(tmp);
			logger.debug(" <<<<<<<<<< TermOfPaymentDtTH:"+detailForcallPL.getTermOfPaymentDtTH());
			logger.debug(" <<<<<<<<<< FromTermOfPaymentDtTH:"+detailForcallPL.getFromTermOfPaymentDtTH());
			logger.debug(" <<<<<<<<<< ToTermOfPaymentDtTH:"+detailForcallPL.getToTermOfPaymentDtTH());
			//detailForcallPL.setExpenseType(paymentDetail.getExpenseType());
			detailForcallPL.setExpenseType(newPayment.getExpenseType());
			logger.debug(" <<<<<<<<<< detailForcallPL.getValidatePaymentDetailFlag():"+detailForcallPL.getValidatePaymentDetailFlag());
			
			if(detailForcallPL.getValidatePaymentDetailFlag().equalsIgnoreCase("N")){
				detailForcallPL.setpDate(paymentDetail.getFromTermOfPaymentDt());
				detailForcallPL.setlDate(paymentDetail.getToTermOfPaymentDt());	
			}
			
			IPaymentService service = (IPaymentService)getBean("paymentService");	
			ParameterConfig parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_PAYMENT_E004");
//			ParameterConfig parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_PAYMENT_E001");
			List plresult = service.addELPostpaidToModel(parameter.getParamValue(), detailForcallPL);
			logger.debug(" pl return value:"+plresult.get(0));
			String value0 =(String)plresult.get(0);
			logger.debug(" pl return value site :"+plresult.get(0));
			
			if(value0.equals("00")){							
				if(validateTermOfPaymentFlag){
					validateTermOfPaymentFlag = true;
				}
					logger.debug(" <<<<<<<<<< Validate Completed:"+detailForcallPL.getFromTermOfPaymentDtTH());
				
			}else{
				validateTermOfPaymentFlag = false;
				logger.debug(" <<<<<<<<<< Validate Fail:"+detailForcallPL.getFromTermOfPaymentDtTH());
				logger.debug(" error desc;"+plresult.get(1));
				FrontMessageUtils.addMessageError((String)plresult.get(1)+":"+ detailForcallPL.getFromTermOfPaymentDtTH());
				}
			}
			
			//value0 ="00";
			if(validateTermOfPaymentFlag){	
				
				//WT###Edit 20110119 Start
				//paymentDetailList.set(Integer.parseInt(rowIndex), semmel006Bean.getPaymentDetail());
				paymentDetail.setpRead(pRead);//WT###Add 20110325
				paymentDetailList.set(Integer.parseInt(rowIndex), paymentDetail);
				//WT###Edit 20110119 End
				
				reCalculatePaymentConclution(semmel006Bean.getPaymentDetailList(),semmel006Bean.getPayment());
				semmel006Bean.setDisableUpdateModelButton(true);
				semmel006Bean.setDisableAddModelButton(false);
				semmel006Bean.setPaymentDetail(new PaymentDetail());
				//WT###Add 20110127 Start
				semmel006Bean.setDisableTermOfPaymentDtMonth(false);
				semmel006Bean.setDisableTermOfPaymentDtYear(false);
				semmel006Bean.getPaymentDetail().setVatType(vatType);				
				//WT###Add 20110127 End	
				//WT###Add 20110131 Start
				semmel006Bean.setDisableMoreThanOneDetail(false);
				//WT###Add 20110131 End
			
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flag;
	}	
	
	public boolean doUPdatePaymentDetailToModel(String paymentType ){
		boolean flag = false;		
		try{
			if (validatePayment(paymentType)) {
				return flag;
			}
			if (validatePaymentDetail(paymentType)) {
				return flag;
			}	
			semmel006Bean = getSemmel006Bean();	  			
			String rowIndex = semmel006Bean.getEditItemId();			
			logger.debug(" -- doUPdateELPostpaidToModel rowIndex :"+ rowIndex);	
			
			PaymentDetail paymentDetail = semmel006Bean.getPaymentDetail();
			
			
			
			boolean cllPLsuccess = true;
			String plElectricId = semmel006Bean.getPopupSiteCriteria().getElectricId();
			String plMeterInfoId = semmel006Bean.getPopupSiteCriteria().getMeterInfoId();
			String meterId = semmel006Bean.getPopupSiteCriteria().getMeterId();
			paymentDetail.setMeterId(meterId);			
			PaymentDetail detailForcallPL = new PaymentDetail();
			detailForcallPL.setReferMeterId(plElectricId);
			detailForcallPL.setMeterId(plMeterInfoId);			
			detailForcallPL.setFromTermOfPaymentDt(paymentDetail.getFromTermOfPaymentDt());
			detailForcallPL.setToTermOfPaymentDt(paymentDetail.getToTermOfPaymentDt());
			detailForcallPL.setProcessType("UPD");
			logger.debug(" doUPdatePaymentDetailToModel plElectricId:"+plElectricId+" plMeterInfoId:"+plMeterInfoId+" paymentDetail.getFromTermOfPaymentDt():"+paymentDetail.getFromTermOfPaymentDt()+"paymentDetail.getToTermOfPaymentDt():"+paymentDetail.getToTermOfPaymentDt());
			
			IPaymentService service = (IPaymentService)getBean("paymentService");	
			ParameterConfig parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_PAYMENT_E003");
			logger.debug(" EL_PG_PAYMENT_E003 parameter:"+parameter); 
			List plresult = service.addELTempToModel(parameter.getParamValue(), detailForcallPL);
			logger.debug(" pl return value:"+plresult.get(0));
			String value0 =(String)plresult.get(0);
			
			// comment out please
			//value0="00";
			if("00".equals(value0)){			
				List paymentDetailList = semmel006Bean.getPaymentDetailList();			
		        ELUtils.setPamentDetailDisplayField(paymentDetail);			
				paymentDetailList.set(Integer.parseInt(rowIndex), semmel006Bean.getPaymentDetail());
				reCalculatePaymentConclution(semmel006Bean.getPaymentDetailList(),semmel006Bean.getPayment());
				semmel006Bean.setDisableUpdateModelButton(true);
				semmel006Bean.setDisableAddModelButton(false);
				if(semmel006Bean.getPaymentDetailList()==null||semmel006Bean.getPaymentDetailList().size()<=0){
					semmel006Bean.setDisableMoreThanOneDetail(false);
				}else{
					semmel006Bean.setDisableMoreThanOneDetail(true);
				}
				
				String oldVatType = semmel006Bean.getPaymentDetail().getVatType();
				PaymentDetail payDetail  = new PaymentDetail();
				payDetail.setVatType(oldVatType);
				semmel006Bean.setPaymentDetail(payDetail);
				logger.debug(" Set vatTyp xx :"+semmel006Bean.getPaymentDetail().getVatType());				
				//semmel006Bean.setPaymentDetail(new PaymentDetail());	
				addMessageInfo("M0001");
				
			}else{
				logger.debug(" error desc;"+plresult.get(1));
				FrontMessageUtils.addMessageError((String)plresult.get(1));
			}
				
			
			

		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flag;
	}		
	public boolean doUPdatePaymentDetailToModelPRPospaid( ){
		boolean flag = false;		
		try{
			
			logger.info("START Action doUPdatePaymentDetailToModelPRPospaid Page 6-5");
			
			//WT###Edit 20110131 Start
			/*if (validatePayment(ELUtils.PR_POSTPAID)) {
				return flag;
			}*/
			if (validatePRPostpaidByExpenseType())  {
				return flag;
			}
			//WT###Edit 20110131 End
//			if (validatePaymentDetail(ELUtils.PR_POSTPAID)||validateTotalAmount()) {
			if (validatePaymentDetail(ELUtils.PR_POSTPAID)) {
				return flag;
			}			
			
			
			semmel006Bean = getSemmel006Bean();			
			Payment newPayment = semmel006Bean.getPayment();

			PaymentDetail paymentDetail = semmel006Bean.getPaymentDetail();				
			boolean cllPLsuccess = true;
			String plElectricId = semmel006Bean.getPopupSiteCriteria().getElectricId();
			String plMeterInfoId = semmel006Bean.getPopupSiteCriteria().getMeterInfoId();		
			
//			START BY NOOM:::::: USE IN NEXT DEPLOY
			SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd",new Locale("en", "US"));
			String dfFromConvert = df.format(paymentDetail.getFromTermOfPaymentDt());
			String dfToConvert = df.format(paymentDetail.getToTermOfPaymentDt());
			ElPrivateValidateSP elPrivateValidateSP = new ElPrivateValidateSP();
			elPrivateValidateSP.setContractNo(semmel006Bean.getPopupSiteCriteria().getContractNo());
			elPrivateValidateSP.setMeterId(plMeterInfoId);
			elPrivateValidateSP.setFromTermPayment(dfFromConvert);
			elPrivateValidateSP.setToTermPayment(dfToConvert);
			elPrivateValidateSP.setpKwh(paymentDetail.getpRead().toString());
			elPrivateValidateSP.setlKwh(paymentDetail.getlRead().toString());
			elPrivateValidateSP.setUnit(paymentDetail.getUnitPrice().toString());
			elPrivateValidateSP.setAmtNew(paymentDetail.getPayAmt().toString());
			
			IPaymentService service = (IPaymentService)getBean("paymentService");	
			List<ElPrivateValidateSP> elPrivateValidateSPList = null;
			elPrivateValidateSPList = service.querySPList(EQueryName.SP_MEL006_PRIVATE_VALIDATE.name, elPrivateValidateSP);
			
			for(ElPrivateValidateSP elValid : elPrivateValidateSPList){
				if (StringUtils.equalsIgnoreCase("success", elValid.getResult())){
					addGeneralMessageError(elValid.getRemark());
				}
			}
//			END  BY NOOM::::::
			
			/*
			PaymentDetail detailForcallPL = new PaymentDetail();
			detailForcallPL.setReferMeterId(plElectricId);
			detailForcallPL.setMeterId(plMeterInfoId);
			detailForcallPL.setpDate(paymentDetail.getpDate());
			detailForcallPL.setlDate(paymentDetail.getlDate());
			detailForcallPL.setpRead(paymentDetail.getpRead());
			detailForcallPL.setlRead(paymentDetail.getlRead());
			detailForcallPL.setKwhTotal(paymentDetail.getKwhTotal());
			detailForcallPL.setInvTermOfPaymentDt(paymentDetail.getInvTermOfPaymentDt());
			IPaymentService service = (IPaymentService)getBean("paymentService");	
			ParameterConfig parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_PAYMENT_P001");
			
			*/
			logger.debug("<<<<<paymentDetail.getPayAmt()>>>>>>>>:"+paymentDetail.getPayAmt());
			
			PaymentDetail detailForcallPL = new PaymentDetail();
		
			detailForcallPL.setReferMeterId(plElectricId);
			detailForcallPL.setMeterId(plMeterInfoId);
			detailForcallPL.setFromTermOfPaymentDt(paymentDetail.getFromTermOfPaymentDt());
			detailForcallPL.setToTermOfPaymentDt(paymentDetail.getToTermOfPaymentDt());	
			detailForcallPL.setpRead(paymentDetail.getpRead());
			detailForcallPL.setlRead(paymentDetail.getlRead());
			detailForcallPL.setKwhTotal(paymentDetail.getKwhTotal());
		    //---------------------------------------------------------
			detailForcallPL.setExpenseType(newPayment.getExpenseType());
			detailForcallPL.setValidatePaymentDetailFlagBoolean(paymentDetail.isValidatePaymentDetailFlagBoolean());
			boolean validateTermOfPaymentFlase = true;
			
			
			if(validateTermOfPaymentFlase){		
				String rowIndex = semmel006Bean.getEditItemId();			
				logger.debug(" -- doUPdateELPostpaidToModel rowIndex :"+ rowIndex);	
				List paymentDetailList = semmel006Bean.getPaymentDetailList();
				ELUtils.setPamentDetailDisplayField(semmel006Bean.getPaymentDetail());
				paymentDetailList.set(Integer.parseInt(rowIndex), semmel006Bean.getPaymentDetail());
				reCalculatePaymentConclution5(semmel006Bean.getPaymentDetailList(),semmel006Bean.getPayment());
				semmel006Bean.setDisableUpdateModelButton(true);
				semmel006Bean.setDisableAddModelButton(false);
				//------------------------------------------------
				logger.debug(" -- Enable Term of Payment Date--");
				semmel006Bean.setDisableFromTermOfPaymentDt(false);
				semmel006Bean.setDisableToTermOfPaymentDt(false);
				//------------------------------------------------
				
				if(semmel006Bean.getPaymentDetailList()==null||semmel006Bean.getPaymentDetailList().size()<=0){
					semmel006Bean.setDisableMoreThanOneDetail(false);
				}else{
					semmel006Bean.setDisableMoreThanOneDetail(true);
				}
				semmel006Bean.setPaymentDetail(new PaymentDetail());	
				//WT###Edit 20110131 Start
				semmel006Bean.setDisableFromTermOfPaymentDt(false);
				semmel006Bean.setDisableFromTermOfPaymentDt(false);
				//WT###Edit 20110131 End
			}
			//reCalculatePaymentConclution5
			logger.info("END Action doUPdatePaymentDetailToModelPRPospaid Page 6-5");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flag;
	}			
	private boolean doUpdateELPostpaid (){
		logger.debug(" -- doUpdateELPostpaid--");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	     	
			//logger.debug(" doUpdateELPostpaid To Save payment :"+BeanUtils.getBeanString(semmel006Bean.getPayment()));
			//logger.debug(" doUpdateELPostpaid To Save paymentDetail :"+BeanUtils.getBeanString(semmel006Bean.getPaymentDetail()));
			
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return flagValid;
	}	
	private boolean doClearELPostpaid() {
		logger.debug(" -- doClearELPostpaid-- Page 6-3");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();
			String vatType = "";
			if(null!=semmel006Bean.getPaymentDetail()){
				vatType = semmel006Bean.getPaymentDetail().getVatType();
			} 
			logger.debug("WT###vatType="+vatType);
			semmel006Bean.setPaymentDetail(new PaymentDetail());			
			semmel006Bean.setDisableUpdateModelButton(true);
			semmel006Bean.setDisableAddModelButton(false);
			//WT###Add 20110127 Start
			semmel006Bean.setDisableTermOfPaymentDtMonth(false);
			semmel006Bean.setDisableTermOfPaymentDtYear(false);
			semmel006Bean.getPaymentDetail().setVatType(vatType);
			//WT###Add 20110127 End
			//WT###Add 20110131 Start
			semmel006Bean.setDisableMoreThanOneDetail(false); 
			semmel006Bean.setDisableValidateELPostPaidPaymentDetail(false);
			semmel006Bean.getPaymentDetail().setValidatePaymentDetailFlagBoolean(true);
			
			//WT###Add 20110131 End
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return flagValid;
	}	

	
	public boolean changeElectricUseTypeELPostpaid(){		
		logger.debug(" -- changeElectricUseTypeELPostpaid--");
		boolean flagValid = false;
		
		try{
			/*
			semmel006Bean = getSemmel006Bean();	 
			String electricUseType = semmel006Bean.getPayment().getElectricUseType();
			logger.debug(" -- changeElectricUseType_ELBill to :"+electricUseType);
			if(electricUseType!=null){
				//PEA	:	���俿����ǹ�����Ҥ
				if(ELUtils.ELECTRIC_TYPE_PEA.equals(electricUseType)){
					semmel006Bean.getPayment().setVendorId(ELUtils.getParaValueStringbyCode(ELUtils.EL_PEA_VENDOR_ID));
					semmel006Bean.getPayment().setVendorName(ELUtils.getParaValueStringbyCode(ELUtils.EL_PEA_VENDOR_NAME));
					semmel006Bean.getPayment().setPayeeId(ELUtils.getParaValueStringbyCode(ELUtils.EL_PEA_PAYEE_ID));
					semmel006Bean.getPayment().setPayeeName(ELUtils.getParaValueStringbyCode(ELUtils.EL_PEA_PAYEE_NAME));
				//MEA	:	���俿�ҹ����ǧ
				}else if (ELUtils.ELECTRIC_TYPE_MEA.equals(electricUseType)){
					semmel006Bean.getPayment().setVendorId(ELUtils.getParaValueStringbyCode(ELUtils.EL_MEA_VENDOR_ID));
					semmel006Bean.getPayment().setVendorName(ELUtils.getParaValueStringbyCode(ELUtils.EL_MEA_VENDOR_NAME));
					semmel006Bean.getPayment().setPayeeId(ELUtils.getParaValueStringbyCode(ELUtils.EL_MEA_PAYEE_ID));
					semmel006Bean.getPayment().setPayeeName(ELUtils.getParaValueStringbyCode(ELUtils.EL_MEA_PAYEE_NAME));
					
				}else{
					logger.debug("  No Matching EL_ELECTRIC_TYPE PEA or  MEA ");
				}
				
			}
			changePaymentTypeELBill();
			*/			
		}catch(Exception ex){
			ex.printStackTrace();
		}		

		return flagValid;			
	}

	
	public boolean changeExpenseTypeELPostpaid2(){			
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			String expenseType = semmel006Bean.getPayment().getExpenseType();
			logger.debug(" -- changeExpenseTypeELPostpaid2 to xx :"+expenseType);
			//EL_POSTPAID	:	���俿�ҡ��俿��
			//EL_DEBIT	1|4	�ԡ�������俿�ҡ��俿��
			//EL_CREDIT	1|4	�ͤ׹���俿�ҡ��俿��
			semmel006Bean.getPayment().setDocType("I");
			semmel006Bean.setPaymentTypeDisable(false);
			semmel006Bean.setPaymentTypeMandatory(true);
			semmel006Bean.setPaymentMethodDisable(false);
			
			semmel006Bean.setChqPostingDtDisable(false);					
			semmel006Bean.setChqReceivedDtDisable(false);
			semmel006Bean.setTransferDtDisable(false);
			
			semmel006Bean.setPaymentTypeDisable(false);
			semmel006Bean.setChqPostingDtDisable(false);
			semmel006Bean.setChqReceivedDtDisable(false);
			if(expenseType!=null){
				//EL_POSTPAID	:	���俿�ҡ��俿��
				if(ELUtils.EXPENSE_TYPE_EL_POSPAID.equals(expenseType)){
					semmel006Bean.setRefDocNoDisable(true);
					semmel006Bean.setRefDocDtDisable(true);
					semmel006Bean.setRefDocNoMandatory(false);	
					semmel006Bean.getPayment().setDocType("I");
					
					changePaymentTypeELPostpaid();
				}else if(ELUtils.EXPENSE_TYPE_EL_DEBIT.equals(expenseType)){
					semmel006Bean.setRefDocNoDisable(false);
					semmel006Bean.setRefDocDtDisable(false);
					semmel006Bean.setRefDocNoMandatory(true);
					semmel006Bean.getPayment().setDocType(ELUtils.DOC_TYPE_DR);
					
					changePaymentTypeELPostpaid();
					//EL_CREDIT
				}else if(ELUtils.EXPENSE_TYPE_EL_CREDIT.equals(expenseType)){
					logger.debug(" In EXPENSE_TYPE_EL_CREDIT" );
					semmel006Bean.setRefDocNoDisable(false);
					semmel006Bean.setRefDocDtDisable(false);
					semmel006Bean.setRefDocNoMandatory(true);
					semmel006Bean.getPayment().setDocType(ELUtils.DOC_TYPE_CR);
					
					semmel006Bean.getPayment().setPaymentType(null);
					semmel006Bean.setPaymentTypeDisable(true);
					semmel006Bean.setPaymentTypeMandatory(false);
					semmel006Bean.getPayment().setPaymentMethod(null);
					semmel006Bean.setPaymentMethodDisable(true);
					
					semmel006Bean.setChqPostingDtDisable(true);					
					semmel006Bean.setChqReceivedDtDisable(true);
					semmel006Bean.setTransferDtDisable(true);
					
					semmel006Bean.setPaymentTypeDisable(true);
					semmel006Bean.setChqPostingDtDisable(true);
					semmel006Bean.setChqReceivedDtDisable(true);
					
				}
			}	
			
		
		}catch(Exception ex){
			ex.printStackTrace();
		}		

		return flagValid;			
	}
	public boolean changeExpenseTypeELPostpaid3(){			
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			String expenseType = semmel006Bean.getPayment().getExpenseType();
			
			//EL_POSTPAID	:	���俿�ҡ��俿��
			//EL_DEBIT	1|4	�ԡ�������俿�ҡ��俿��
			//EL_CREDIT	1|4	�ͤ׹���俿�ҡ��俿��
			semmel006Bean.getPayment().setDocType("I");			
			semmel006Bean.setPaymentTypeMandatory(false);
			semmel006Bean.setPaymentMethodMandatory(false);			
			semmel006Bean.setPaymentTypeDisable(false);
			semmel006Bean.setPaymentMethodDisable(false);			
			semmel006Bean.setChqPostingDtDisable(false);					
			semmel006Bean.setChqReceivedDtDisable(false);
			semmel006Bean.setTransferDtDisable(false);			
			semmel006Bean.setPaymentTypeDisable(false);
			semmel006Bean.setChqPostingDtDisable(false);
			semmel006Bean.setChqReceivedDtDisable(false);
			
			
			//- �Ըժ����Թ = Default ����� ��
			semmel006Bean.getPayment().setPaymentType("01");	
			semmel006Bean.getPayment().setPaymentMethod(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.CT_PAYMENT_METHOD));//WT###Add 20110207
			//- �ѹ���˹���� = Enable Field
			semmel006Bean.setChqPostingDtDisable(false);	
			//- �ѹ����Ѻ�� = Enable Field
			semmel006Bean.setChqReceivedDtDisable(false);
			//- �ѹ����͹ = Disable Field
			semmel006Bean.setTransferDtDisable(true);

				
			if(expenseType!=null){
				//EL_POSTPAID	:	���俿�ҡ��俿��
				if(ELUtils.EXPENSE_TYPE_EL_POSPAID.equals(expenseType)){
					logger.debug(" -- changeExpenseTypeELPostpaid3 to   :"+expenseType+" ���俿�ҡ��俿��");
					
					semmel006Bean.getPayment().setPaymentType(null);
					semmel006Bean.getPayment().setPaymentMethod(null);
					semmel006Bean.setPaymentMethodDisable(true);						
					semmel006Bean.setTransferDtDisable(true);				
					semmel006Bean.setChqPostingDtDisable(true);
					semmel006Bean.setChqReceivedDtDisable(true);					
					semmel006Bean.setPaymentTypeMandatory(true);
					semmel006Bean.setPaymentMethodMandatory(true);
					semmel006Bean.setPaymentTypeDisable(false);
					semmel006Bean.setPaymentMethodDisable(false);	
					semmel006Bean.getPayment().setDocType("I");
					
					//- ���� �����͡�����ҧ�ԧ��� = Disable ����
					semmel006Bean.setRefDocNoDisable(true);
					//- �Ըժ����Թ = Default ����� ��
					semmel006Bean.getPayment().setPaymentType("01");	
					semmel006Bean.getPayment().setPaymentMethod(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.CT_PAYMENT_METHOD));//WT###Add 20110207
					//- �ѹ���˹���� = Enable Field
					semmel006Bean.setChqPostingDtDisable(false);		
					//- �ѹ����Ѻ�� = Enable Field
					semmel006Bean.setChqReceivedDtDisable(false);
					
					//- �Ţ������͡�����ҧ��� = �� Optional Field
					semmel006Bean.setRefDocDtDisable(false);
					semmel006Bean.setRefDocNoMandatory(false);
					//- �ѹ������͡�����ҧ�ԧ��� = �� Optional Field 
					
					

					 
				}else if(ELUtils.EXPENSE_TYPE_EL_DEBIT.equals(expenseType)){
					logger.debug(" -- changeExpenseTypeELPostpaid3 to   :"+expenseType+"�ԡ�������俿�ҡ��俿�� ");
					semmel006Bean.setRefDocNoDisable(false);
					semmel006Bean.setRefDocDtDisable(false);
					semmel006Bean.setRefDocNoMandatory(false);//WT###Edit 20110128
					semmel006Bean.getPayment().setDocType(ELUtils.DOC_TYPE_DR);
					semmel006Bean.setPaymentTypeMandatory(true);
					semmel006Bean.setPaymentMethodMandatory(true);
					semmel006Bean.setPaymentTypeDisable(false);
					semmel006Bean.setPaymentMethodDisable(false);
					
					//- �Ըժ����Թ = Default ����� ��
					semmel006Bean.getPayment().setPaymentType("01");	
					semmel006Bean.getPayment().setPaymentMethod(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.CT_PAYMENT_METHOD));//WT###Add 20110207
					//- �ѹ����͹ = Disable Field
					semmel006Bean.setTransferDtDisable(true);	
					
					//changePaymentTypeELPostpaid();
					//EL_CREDIT
				}else if(ELUtils.EXPENSE_TYPE_EL_CREDIT.equals(expenseType)){
					logger.debug(" -- changeExpenseTypeELPostpaid3 to   :"+expenseType+" �ͤ׹���俿�ҡ��俿�� ");
					logger.debug(" In EXPENSE_TYPE_EL_CREDIT" );
					semmel006Bean.getPayment().setDocType(ELUtils.DOC_TYPE_CR);
					semmel006Bean.getPayment().setPaymentType(null);
					semmel006Bean.getPayment().setPaymentMethod(null);
					semmel006Bean.setRefDocNoDisable(true);
					semmel006Bean.setRefDocDtDisable(true);
					semmel006Bean.setRefDocNoMandatory(false);					
					semmel006Bean.setPaymentTypeMandatory(false);
					semmel006Bean.setPaymentMethodMandatory(false);
					semmel006Bean.setPaymentTypeDisable(true);
					semmel006Bean.setPaymentMethodDisable(true);
					
					//- �Ţ������͡�����ҧ�ԧ��� = �� Mandatory Field
					semmel006Bean.setRefDocNoMandatory(true);
					//- �ѹ������͡�����ҧ�ԧ��� = �� Mandatory Field
					//- ���� �����͡�����ҧ�ԧ��� = Enable ����
					semmel006Bean.setRefDocNoDisable(false);
					//- �ѹ���˹���� = Disable Field
					semmel006Bean.setChqPostingDtDisable(true);					
					//- �ѹ����Ѻ�� = Disable Field
					semmel006Bean.setChqReceivedDtDisable(true);
					//- �ѹ����͹ = Disable Field
					semmel006Bean.setTransferDtDisable(true);	
				}
			}	
			
		
		}catch(Exception ex){
			ex.printStackTrace();
		}		

		return flagValid;			
	}	
	public boolean changeExpenseTypeELPostpaid(){			
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			String expenseType = semmel006Bean.getPayment().getExpenseType();
			logger.debug(" -- changeExpenseTypeELPostpaid to xx :"+expenseType);
			//EL_POSTPAID	:	���俿�ҡ��俿��
			//EL_DEBIT	1|4	�ԡ�������俿�ҡ��俿��
			//EL_CREDIT	1|4	�ͤ׹���俿�ҡ��俿��
			semmel006Bean.getPayment().setDocType("I");
			
			
			semmel006Bean.setPaymentTypeMandatory(false);
			semmel006Bean.setPaymentMethodMandatory(false);			
			semmel006Bean.setPaymentTypeDisable(false);
			semmel006Bean.setPaymentMethodDisable(false);			
			semmel006Bean.setChqPostingDtDisable(false);					
			semmel006Bean.setChqReceivedDtDisable(false);
			semmel006Bean.setTransferDtDisable(false);			
			semmel006Bean.setPaymentTypeDisable(false);
			semmel006Bean.setChqPostingDtDisable(false);
			semmel006Bean.setChqReceivedDtDisable(false);
			if(expenseType!=null){
				//EL_POSTPAID	:	���俿�ҡ��俿��
				if(ELUtils.EXPENSE_TYPE_EL_POSPAID.equals(expenseType)){
					
					semmel006Bean.getPayment().setPaymentType(null);
					//semmel006Bean.setPaymentTypeDisable(true);
					//semmel006Bean.setPaymentTypeMandatory(false);
					semmel006Bean.getPayment().setPaymentMethod(null);
					semmel006Bean.setPaymentMethodDisable(true);					
					semmel006Bean.setChqPostingDtDisable(true);					
					semmel006Bean.setChqReceivedDtDisable(true);
					semmel006Bean.setTransferDtDisable(true);					
				//	semmel006Bean.setPaymentTypeDisable(true);
					semmel006Bean.setChqPostingDtDisable(true);
					semmel006Bean.setChqReceivedDtDisable(true);					
					semmel006Bean.setPaymentTypeMandatory(true);
					semmel006Bean.setPaymentMethodMandatory(true);
					semmel006Bean.setPaymentTypeDisable(false);
					semmel006Bean.setPaymentMethodDisable(false);
					semmel006Bean.setRefDocNoDisable(false);
					semmel006Bean.setRefDocDtDisable(false);
					semmel006Bean.setRefDocNoMandatory(true);
					semmel006Bean.getPayment().setDocType("I");
					//changePaymentTypeELPostpaid();
				}else if(ELUtils.EXPENSE_TYPE_EL_DEBIT.equals(expenseType)){
					semmel006Bean.setRefDocNoDisable(false);
					semmel006Bean.setRefDocDtDisable(false);
					semmel006Bean.setRefDocNoMandatory(true);
					semmel006Bean.getPayment().setDocType(ELUtils.DOC_TYPE_DR);
					semmel006Bean.setPaymentTypeMandatory(true);
					semmel006Bean.setPaymentMethodMandatory(true);
					semmel006Bean.setPaymentTypeDisable(false);
					semmel006Bean.setPaymentMethodDisable(false);
					changePaymentTypeELPostpaid();
					//EL_CREDIT
				}else if(ELUtils.EXPENSE_TYPE_EL_CREDIT.equals(expenseType)){
					logger.debug(" In EXPENSE_TYPE_EL_CREDIT" );
					semmel006Bean.getPayment().setDocType(ELUtils.DOC_TYPE_CR);
					semmel006Bean.getPayment().setPaymentMethod(null);
					semmel006Bean.setRefDocNoDisable(true);
					semmel006Bean.setRefDocDtDisable(true);
					semmel006Bean.setRefDocNoMandatory(false);					
					semmel006Bean.setPaymentTypeMandatory(false);
					semmel006Bean.setPaymentMethodMandatory(false);
					semmel006Bean.setPaymentTypeDisable(true);
					semmel006Bean.setPaymentMethodDisable(true);
					
				}
			}	
			
		
		}catch(Exception ex){
			ex.printStackTrace();
		}		

		return flagValid;			
	}
	
	public boolean changeExpenseTypePRPostpaid5(){		
		logger.debug(" -- changeExpenseTypePRPostpaid5--");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			String expenseType = semmel006Bean.getPayment().getExpenseType();
			logger.debug(" -- changeExpenseTypePRPostpaid5 to :"+expenseType);
			
			// PR_POSTPAID:���俿���͡�� 
			// PR_DEBIT:�ԡ�������俿���͡��
			// PR_CREDIT: �ͤ׹���俿���͡��
			
			semmel006Bean.getPayment().setDocType("I");
			
			semmel006Bean.setPaymentTypeMandatory(true);
			semmel006Bean.setPaymentMethodMandatory(true);
			
			semmel006Bean.setPaymentTypeDisable(false);
			semmel006Bean.setPaymentMethodDisable(false);
			
			semmel006Bean.setChqPostingDtDisable(false);					
			semmel006Bean.setChqReceivedDtDisable(false);
			semmel006Bean.setTransferDtDisable(false);
			
			semmel006Bean.setPaymentTypeDisable(false);
			semmel006Bean.setChqPostingDtDisable(false);
			semmel006Bean.setChqReceivedDtDisable(false);

			if(expenseType!=null){
				//PR_POSTPAID:���俿���͡�� 
				if("PR_POSTPAID".equals(expenseType)){					
					semmel006Bean.setRefDocNoDisable(true);
					semmel006Bean.setRefDocDtDisable(true);
					semmel006Bean.setRefDocNoMandatory(false);	
					semmel006Bean.getPayment().setDocType("I");
					
					semmel006Bean.setPaymentTypeMandatory(true);	
					semmel006Bean.setPaymentMethodMandatory(true);
					//- �Ըժ����Թ = Default ����� ��
					semmel006Bean.getPayment().setPaymentType("01");	
					semmel006Bean.getPayment().setPaymentMethod(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.CT_PAYMENT_METHOD));//WT###Add 20110207
					//- �ѹ����͹ = Disable Field
					semmel006Bean.setTransferDtDisable(true);
					// PR_DEBIT:�ԡ�������俿���͡��
				}else if("PR_DEBIT".equals(expenseType)){
					
					semmel006Bean.setRefDocNoDisable(false);
					semmel006Bean.setRefDocDtDisable(false);
					semmel006Bean.setRefDocNoMandatory(true);
					semmel006Bean.getPayment().setDocType(ELUtils.DOC_TYPE_DR);
					
					semmel006Bean.setPaymentTypeMandatory(true);	
					semmel006Bean.setPaymentMethodMandatory(true);
					//- �Ըժ����Թ = Default ����� ��
					semmel006Bean.getPayment().setPaymentType("01");	
					semmel006Bean.getPayment().setPaymentMethod(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.CT_PAYMENT_METHOD));//WT###Add 20110207
					//- �ѹ����͹ = Disable Field
					semmel006Bean.setTransferDtDisable(true);
					 
					//PR_CREDIT: �ͤ׹���俿���͡��
				}else if("PR_CREDIT".equals(expenseType)){		
					semmel006Bean.setRefDocNoDisable(false);
					semmel006Bean.setRefDocDtDisable(false);
					semmel006Bean.setRefDocNoMandatory(true);
					semmel006Bean.getPayment().setDocType(ELUtils.DOC_TYPE_CR);
					
					semmel006Bean.getPayment().setPaymentType(null);
					semmel006Bean.getPayment().setPaymentMethod(null);
					
					semmel006Bean.setPaymentTypeDisable(true);									
					semmel006Bean.setPaymentMethodDisable(true);
					
					semmel006Bean.setPaymentTypeMandatory(false);	
					semmel006Bean.setPaymentMethodMandatory(false);
					
					semmel006Bean.setChqPostingDtDisable(true);					
					semmel006Bean.setChqReceivedDtDisable(true);
					semmel006Bean.setTransferDtDisable(true);					
					semmel006Bean.setChqPostingDtDisable(true);
					semmel006Bean.setChqReceivedDtDisable(true);
					
				}
			}	
			
			changePaymentTypeELPostpaid();
		}catch(Exception ex){
			ex.printStackTrace();
		}		

		return flagValid;			
	}
	
	
	public boolean changeExpenseTypePRPostpaid(){		
		logger.debug(" -- changeExpenseTypePRPostpaid--");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			String expenseType = semmel006Bean.getPayment().getExpenseType();
			logger.debug(" -- changeExpenseTypePRPostpaid to :"+expenseType);
			
			// PR_POSTPAID:���俿���͡�� 
			// PR_DEBIT:�ԡ�������俿���͡��
			// PR_CREDIT: �ͤ׹���俿���͡��
			
			semmel006Bean.getPayment().setDocType("I");
			semmel006Bean.setPaymentTypeDisable(false);
			semmel006Bean.setPaymentTypeMandatory(true);
			semmel006Bean.setPaymentMethodDisable(false);
			
			semmel006Bean.setChqPostingDtDisable(false);					
			semmel006Bean.setChqReceivedDtDisable(false);
			semmel006Bean.setTransferDtDisable(false);
			
			semmel006Bean.setPaymentTypeDisable(false);
			semmel006Bean.setChqPostingDtDisable(false);
			semmel006Bean.setChqReceivedDtDisable(false);
			if(expenseType!=null){
				//PR_POSTPAID:���俿���͡�� 
				if("PR_POSTPAID".equals(expenseType)){					
					semmel006Bean.setRefDocNoDisable(true);
					semmel006Bean.setRefDocDtDisable(true);
					semmel006Bean.setRefDocNoMandatory(false);	
					semmel006Bean.getPayment().setDocType("I");
					// PR_DEBIT:�ԡ�������俿���͡��
				}else if("PR_DEBIT".equals(expenseType)){
					
					semmel006Bean.setRefDocNoDisable(false);
					semmel006Bean.setRefDocDtDisable(false);
					semmel006Bean.setRefDocNoMandatory(true);
					semmel006Bean.getPayment().setDocType(ELUtils.DOC_TYPE_DR);
					 
					//PR_CREDIT: �ͤ׹���俿���͡��
				}else if("PR_CREDIT".equals(expenseType)){		
					semmel006Bean.setRefDocNoDisable(false);
					semmel006Bean.setRefDocDtDisable(false);
					semmel006Bean.setRefDocNoMandatory(true);
					semmel006Bean.getPayment().setDocType(ELUtils.DOC_TYPE_CR);
					
					semmel006Bean.getPayment().setPaymentType(null);
					semmel006Bean.setPaymentTypeDisable(true);
					semmel006Bean.setPaymentTypeMandatory(false);
					semmel006Bean.getPayment().setPaymentMethod(null);
					semmel006Bean.setPaymentMethodDisable(true);
					
					semmel006Bean.setChqPostingDtDisable(true);					
					semmel006Bean.setChqReceivedDtDisable(true);
					semmel006Bean.setTransferDtDisable(true);
					
					semmel006Bean.setPaymentTypeDisable(true);
					semmel006Bean.setChqPostingDtDisable(true);
					semmel006Bean.setChqReceivedDtDisable(true);
					
				}
			}	
			
			changePaymentTypeELPostpaid();
		}catch(Exception ex){
			ex.printStackTrace();
		}		

		return flagValid;			
	}
	
		
	private boolean doSaveELPostpaid (){
		logger.info("START Action doSaveELPostpaid");
		boolean flagValid = false;				
		try{
			// 1 Validate Payment Detail Size >0			
			if (getSemmel006Bean().getPaymentDetailList()==null||getSemmel006Bean().getPaymentDetailList().size()<=0) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.paymentDetailSize")));
				flagValid = true;
			}else{
				//if (validateELPostpaid()) {
				if (validateELPostpaidByExpenseType()) {
					return flagValid;
				}					

				ParameterConfig plNameParameterStep1 = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_PAYMENT_E001");		
				semmel006Bean = getSemmel006Bean();	 
				String electricIdStr = semmel006Bean.getPopupSiteCriteria().getElectricId();
				String meterInfoId = semmel006Bean.getPopupSiteCriteria().getMeterInfoId();
				Payment paymentSave = semmel006Bean.getPayment();
				Management electricId = new Management();
				electricId.setRowId(electricIdStr);
				paymentSave.setElectricId(electricId);
				paymentSave.setSiteInfoId(semmel006Bean.getPopupSiteCriteria().getSiteInfoId());
				paymentSave.setSiteType(semmel006Bean.getPopupSiteCriteria().getSiteType());
				paymentSave.setRegion(semmel006Bean.getPopupSiteCriteria().getRegion());
				//paymentSave.setExpenseType(ELUtils.EL_POSTPAID);			
				paymentSave.setRecordStatus("Y");
				paymentSave.setVersion(new BigDecimal(1));
				
				if(paymentSave.getWhtAmt() != null){
					if(paymentSave.getWhtAmt().doubleValue()==0.0){
						paymentSave.setWhtAmt(null);
					}
				}
				
				//paymentSave.setDocType(paymentSave.getRefDocType());
				
				//paymentSave.setRefDocType(semmel006Bean.getPopupOldDocCriteria().getDocType());
				//logger.debug(message);
				 
				
				paymentSave.setPaymentStatus("01");
				//WT###Edit 20110128 Start
				//paymentSave.setVatType("01");
				paymentSave.setVatType(semmel006Bean.getPaymentDetailList().get(0).getVatType());
				//WT###Edit 20110128 End
				paymentSave.setVatRate(new BigDecimal(7));
				List<PaymentDetail> detailList = semmel006Bean.getPaymentDetailList();
				for(PaymentDetail detailtmp:detailList){
					/*
					- INV_METER_ID = �����ҧ
					- METER_ID = �����Ţ������
					- VAT_AMT = �ӹǹ�Թ VAT
					- EXCLUDE_VAT_AMT = �ӹǹ�Թ��͹ VAT
					- INCLUDE_VAT_AMT = �ӹǹ�Թ��� VAT
					- CHQ_AMT = Cheque Amount
					- DETAIL_FLAG = 'Y'
					*/
					//WT###Comment 20110128detailtmp.setVatType("01");
					detailtmp.setVatRate(new BigDecimal(7));
					detailtmp.setExpenseType(paymentSave.getExpenseType());
					detailtmp.setReferMeterId(semmel006Bean.getPopupSiteCriteria().getReferMeterId());
					detailtmp.setRecordStatus("Y");
					detailtmp.setInvTermOfPaymentDt(null);
					detailtmp.setMeterInfoId(meterInfoId);
					//detailtmp.setVatAmt(detailtmp.getInvVatAmt());
					//detailtmp.setExcludeVatAmt(detailtmp.getInvExcludeVatAmt());
					//detailtmp.setIncludeVatAmt(detailtmp.getInvIncludeVatAmt());
					//detailtmp.setChqAmt(detailtmp.getInvIncludeVatAmt());				
					String meterIdTmp = detailtmp.getMeterId()+"";
					detailtmp.setDetailFlag("Y");
					detailtmp.setMeterId(meterIdTmp);
					detailtmp.setInvMeterId("");
					if(detailtmp.getWhtAmt()!=null){//WT###Edit 20110201
						if(detailtmp.getWhtAmt().intValue()==0.0){
							detailtmp.setWhtAmt(null);						
						}
					}
										
				}				


				
				logger.debug(" Detail List :"+detailList.size());			
				IPaymentService service = (IPaymentService)getBean("paymentService");	
				
				//WT###Edit 20110117 Start
				//***
				//semmel006Bean.setComeFromOtherPage(false);
				
				if(semmel006Bean.isFromAction() 
				   && !StringUtils.isEmpty(semmel006Bean.getPayment().getTransID()) 
				   && !semmel006Bean.isSave()){
					logger.info( "<<<<Service SavePaymentPage5 Type 1:"+semmel006Bean.getPayment().getTransID());
					ParameterConfig paramPLName2 = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_PAYMENT_E002");
					logger.debug("   paramPLName2:"+paramPLName2);
					boolean saveResult = service.savePaymentELPostpaid(paymentSave, detailList,  paramPLName2.getParamValue());
					semmel006Bean.setSave(true);
					
					logger.debug(" doSaveELPostpaid Result xx :"+saveResult);
					
					//semmel006Bean.setPayment(new Payment());
					
					logger.info("END <<<<Service SavePaymentPage5>>>");
				}
				else if(semmel006Bean.isFromAction() 
						   && !StringUtils.isEmpty(semmel006Bean.getPayment().getTransID()) 
						   && semmel006Bean.isSave() ){
							
					logger.info("START Service updatePaymentPage Type 2");
					detailList.addAll(semmel006Bean.getDeletedPaymentDetailList());
					service.updatePaymentPage6(paymentSave, detailList);
					//semmel006Bean.setPayment(new Payment());
					
					logger.info("END Service updatePaymentPage8");
				
					logger.info("END Service updatePaymentPage8");
				}
				else if(semmel006Bean.isComeFromOtherPage() 
						&& StringUtils.isEmpty(semmel006Bean.getPayment().getTransID())){
					logger.info("START Service updatePaymentPage Type 2");
					detailList.addAll(semmel006Bean.getDeletedPaymentDetailList());
					service.updatePaymentPage6(paymentSave, detailList);
					
					//adjust
					ParameterConfig paramPLName2 = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_PAYMENT_E002");
					logger.debug("   paramPLName2:"+paramPLName2);
					boolean saveResult = service.savePaymentELPostpaid(paymentSave, detailList,  paramPLName2.getParamValue());

					//semmel006Bean.setPayment(new Payment());
					
					logger.info("END Service updatePaymentPage8");
				
					logger.info("END Service updatePaymentPage8");
				}else{				
					logger.info( "<<<<Service SavePaymentPage6 Type 3:"+semmel006Bean.getPayment().getTransID());
					
					ParameterConfig paramPLName2 = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_PAYMENT_E002");
					logger.debug("   paramPLName2:"+paramPLName2);
					boolean saveResult = service.savePaymentELPostpaid(paymentSave, detailList,  paramPLName2.getParamValue());
					//semmel006Bean.setPayment(new Payment());
					initPaymentELPostpaid();  
					logger.debug(" doSaveELPostpaid Result xx :"+saveResult);
				}
				//WT###Edit 20110117 End
				addMessageInfo("M0001");
				//initPaymentELPostpaid();   
				
				//WT###Add 20110202 Start
				semmel006Bean.setDisableViewExpenseHisButton(true);
				semmel006Bean.setDisableViewMeterInfoButton(true);
				//WT###End 20110202 End
			}
			
			logger.info("END Action doSaveELPostpaid");
		} catch (Exception e) {
			logger.error("ERROR Action doSaveELPostpaid");
			addMessageError(ELUtils.E0001);
			e.printStackTrace();
		}
		return flagValid;
	}	
	
	
	
	private boolean validateELPostpaid() {
		logger.debug(" -- validateELPostpaid--");
		boolean flagValid = false;					
		try{
			flagValid = validatePayment(ELUtils.EL_POSTPAID);			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}			
		return flagValid;
	}		
	private boolean validateELPRPostpaid() {
		logger.debug(" -- validateELPRPostpaid--");
		boolean flagValid = false;					
		try{
			flagValid = validatePayment(ELUtils.PR_POSTPAID);			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}			
		return flagValid;
	}		
		
	
	private boolean validatePayment(String paymentType) {
		logger.debug(" -- validatePayment paymentType:"+paymentType);
		boolean flagValid = false;					
	
		if(ELUtils.EL_BILL.equalsIgnoreCase(paymentType)){
			if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getCompany())) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.company")));
				flagValid = true;
			}
			if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getElectricUseType())) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.electricUseType")));
				flagValid = true;
			}				
			if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getExpenseType())) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.expenseType")));
				flagValid = true;
			}	
			if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getDocType())) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.docType")));
				flagValid = true;
			}			
			if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getDocNo())) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.docNo")));
				flagValid = true;
			}			
			if (getSemmel006Bean().getPayment().getDocDt()==null) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.docDt")));
				flagValid = true;
			}	
			//WT###Add 20110207 Start
			logger.debug("WT### getSemmel006Bean().getPayment().getVatType()="+getSemmel006Bean().getPayment().getVatType());
			if (getSemmel006Bean().getPayment().getVatType()!=null && !VATTYPE_NONEVAT.equals(getSemmel006Bean().getPayment().getVatType())) {
				if (getSemmel006Bean().getPayment().getInvTotalVat().doubleValue()==0.0) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), getErrorMessage("label.payAmt")));
					flagValid = true;
				}
			}else{
				if (getSemmel006Bean().getPayment().getInvTotalVat()==null) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), getErrorMessage("label.payAmt")));
					flagValid = true;
				}
			}
			if (getSemmel006Bean().getPayment().getVatType()==null) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), getErrorMessage("label.vatType")));
				flagValid = true;
			}
			//WT###Add 20110207 End
			if (getSemmel006Bean().getPayment().getInvTotalSite()==null || getSemmel006Bean().getPayment().getInvTotalSite().intValue()==0) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), getErrorMessage("label.invTotalSite")));
				flagValid = true;
			}	
			if (getSemmel006Bean().getPayment().getInvTotalExcludeVat()==null || getSemmel006Bean().getPayment().getInvTotalExcludeVat().intValue()==0) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.invTotalExcludeVat")));
				flagValid = true;
			}						

			if (getSemmel006Bean().getPayment().getVatType()!=null && !VATTYPE_NONEVAT.equals(getSemmel006Bean().getPayment().getVatType())) {//WT###Add 20110207
				if (getSemmel006Bean().getPayment().getInvTotalVat().doubleValue()==0.0) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.invTotalVat")));
					flagValid = true;
				}	
			}else{
				if (getSemmel006Bean().getPayment().getInvTotalVat()==null) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.invTotalVat")));
					flagValid = true;
				}	
			}
			if (getSemmel006Bean().getPayment().getInvTotalIncludeVat()==null || getSemmel006Bean().getPayment().getInvTotalIncludeVat().doubleValue()==0.0) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.invTotalIncludeVat")));
				flagValid = true;
			}	
			
			
			if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getVendorId())) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vendorId")));
				flagValid = true;
			}	
			if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getVendorName())) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vendorName")));
				flagValid = true;
			}	
			if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentType())) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.paymentType")));
				flagValid = true;
			}	
			//WT###Add 20110323 Start
			if(!StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentType())){
				if(PAYMENT_TYPE_TRANS.equals(getSemmel006Bean().getPayment().getPaymentType())){
					if(StringUtils.isEmpty(getSemmel006Bean().getPayment().getBankName()) || StringUtils.isEmpty(getSemmel006Bean().getPayment().getBankAccount())){
						FrontMessageUtils.addMessageError(getValidateMessage("msg.requireBackAccount"));
						flagValid = true;
					}
				}
			}
			//WT###Add 20110323 End
			if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentMethod())) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.paymentMethod")));
				flagValid = true;
			}	
			
		}else	if(ELUtils.EL_POSTPAID.equalsIgnoreCase(paymentType)){

				if (StringUtils.isEmpty(getSemmel006Bean().getPopupSiteCriteria().getCompany())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.company")));
					flagValid = true;
				}		
				if (StringUtils.isEmpty(getSemmel006Bean().getPopupSiteCriteria().getContractNo())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.contractNo")));
					flagValid = true;
				}	
				if (StringUtils.isEmpty(getSemmel006Bean().getPopupSiteCriteria().getMeterId())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.meterId")));
					flagValid = true;
				}	
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getExpenseType())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.expenseType")));
					flagValid = true;
				}	
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getDocType())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.docType")));
					flagValid = true;
				}			

				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getDocNo())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.docNo")));
					flagValid = true;
				}							
				if (getSemmel006Bean().getPayment().getDocDt()==null) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.docDt")));
					flagValid = true;
				}			
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentType())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.paymentType")));
					flagValid = true;
				}	
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentMethod())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.paymentMethod")));
					flagValid = true;
				}					
				
				
				String expenseType = getSemmel006Bean().getPayment().getExpenseType();
				if(expenseType!=null){
					/*	
					if(ELUtils.EL_POSTPAID.equals(expenseType)){
					// No validate RefDocNo and RefDocDt
				
					}else{
						if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getRefDocNo())) {
							FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.refDocNo")));
							flagValid = true;
						}							
						if (getSemmel006Bean().getPayment().getRefDocDt()==null) {
							FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.refDocDt")));
							flagValid = true;
						}									
						
					}
					*/
					/*
					if(ELUtils.EXPENSE_TYPE_EL_CREDIT.equals(expenseType)){
						// No validate RefDocNo and RefDocDt
							
					}else{
							if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getRefDocNo())) {
								FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.refDocNo")));
								flagValid = true;
							}							
							if (getSemmel006Bean().getPayment().getRefDocDt()==null) {
								FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.refDocDt")));
								flagValid = true;
							}									
							
					}	
					*/
					
				}					
				
				
				
	
				
				
				
				
				
				
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getVendorId())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vendorId")));
					flagValid = true;
				}				
				
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getVendorName())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vendorName")));
					flagValid = true;
				}				
				

			}else	if(ELUtils.EL_TEMP.equalsIgnoreCase(paymentType)){
				// Meter Id , Expense Type, Vendor Id, Vendor name,PaymentType, Payment Method
				/*
				if (StringUtils.isEmpty(getSemmel006Bean().getPopupSiteCriteria().getMeterId())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.meterId")));
					flagValid = true;
				}		
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getExpenseType())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.expenseType")));
					flagValid = true;
				}	
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getVendorId())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vendorId")));
					flagValid = true;
				}
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getVendorName())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vendorName")));
					flagValid = true;
				}
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentType())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.paymentType")));
					flagValid = true;
				}
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentMethod())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.paymentMethod")));
					flagValid = true;
				}
				
				*/
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getVendorId())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vendorId")));
					flagValid = true;
				}
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getVendorName())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vendorName")));
					flagValid = true;
				}
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentType())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.paymentType")));
					flagValid = true;
				}
				//WT###Add 20110323 Start
				if(!StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentType())){
					if(PAYMENT_TYPE_TRANS.equals(getSemmel006Bean().getPayment().getPaymentType())){
						if(StringUtils.isEmpty(getSemmel006Bean().getPayment().getBankName()) || StringUtils.isEmpty(getSemmel006Bean().getPayment().getBankAccount())){
							FrontMessageUtils.addMessageError(getValidateMessage("msg.requireBackAccount"));
							flagValid = true;
						}
					}
				}
				//WT###Add 20110323 End
				if (StringUtils.isEmpty(getSemmel006Bean().getPopupSiteCriteria().getContractNo())) {
				//if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getContractNo())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.contractNo")));
					flagValid = true;
				}	
				
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentMethod())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.paymentMethod")));
					flagValid = true;
				}				
			}else	if(ELUtils.PR_POSTPAID.equalsIgnoreCase(paymentType)){
				//if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getCompany())) {
				//	FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.company")));
				//	flagValid = true;
				//}
				if (StringUtils.isEmpty(getSemmel006Bean().getPopupSiteCriteria().getContractNo())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.contractNo")));
					flagValid = true;
				}
				if (StringUtils.isEmpty(getSemmel006Bean().getPopupSiteCriteria().getMeterId())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.meterId")));
					flagValid = true;
				}		
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getExpenseType())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.expenseType")));
					flagValid = true;
				}	
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getVendorId())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vendorId")));
					flagValid = true;
				}
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getVendorName())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vendorName")));
					flagValid = true;
				}
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentType())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.paymentType")));
					flagValid = true;
				}
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentMethod())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.paymentMethod")));
					flagValid = true;
				}				
			}else if(ELUtils.PR_PREPAID.equalsIgnoreCase(paymentType)){
				
				//if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getCompany())) {
				//	FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.company")));
				//	flagValid = true;
				//}
				if (StringUtils.isEmpty(getSemmel006Bean().getPopupSiteCriteria().getContractNo())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.contractNo")));
					flagValid = true;
				}					
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getExpenseType())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.expenseType")));
					flagValid = true;
				}	
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getVendorId())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vendorId")));
					flagValid = true;
				}
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getVendorName())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vendorName")));
					flagValid = true;
				}	
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentType())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.paymentType")));
					flagValid = true;
				}
				//WT###Add 20110323 Start
				if(!StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentType())){
					if(PAYMENT_TYPE_TRANS.equals(getSemmel006Bean().getPayment().getPaymentType())){
						if(StringUtils.isEmpty(getSemmel006Bean().getPayment().getBankName()) || StringUtils.isEmpty(getSemmel006Bean().getPayment().getBankAccount())){
							FrontMessageUtils.addMessageError(getValidateMessage("msg.requireBackAccount"));
							flagValid = true;
						}
					}
				}
				//WT###Add 20110323 End
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentMethod())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.paymentMethod")));
					flagValid = true;
				}		
				
							
			}

						
		
		
		return flagValid;
	}	
	
	
	
	
	private boolean validatePaymentDetail(String paymentType) {
		logger.debug(" -- validatePaymentDetail paymentType:"+paymentType);
		boolean flagValid = false;					
	
		if(ELUtils.EL_BILL.equalsIgnoreCase(paymentType))
		{
			
		}else	if(ELUtils.EL_POSTPAID.equalsIgnoreCase(paymentType)){
            
			logger.debug("  ### EL_POSTPAID ###" );
			
			if(getSemmel006Bean().getPaymentDetail().isValidatePaymentDetailFlagBoolean()){
				if ( getSemmel006Bean().getPaymentDetail().getpDate()==null) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.pDate")));
					flagValid = true;
				}	
				if ( getSemmel006Bean().getPaymentDetail().getlDate()==null) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.lDate")));
					flagValid = true;
				}				
				
				if ( getSemmel006Bean().getPaymentDetail().getpDate()!=null
					&& getSemmel006Bean().getPaymentDetail().getlDate()!=null) {
					
					if ( getSemmel006Bean().getPaymentDetail().getpDate().compareTo(getSemmel006Bean().getPaymentDetail().getlDate())>0){
						
						FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.PDateCompareLDate")));
						flagValid = true;
					}
				}
				
				logger.debug(" -- getSemmel006Bean().getPaymentDetail().getpRead():"+getSemmel006Bean().getPaymentDetail().getpRead());
				logger.debug(" -- getSemmel006Bean().getPaymentDetail().getlRead():"+getSemmel006Bean().getPaymentDetail().getlRead());
				
				//if ( getSemmel006Bean().getPaymentDetail().getpRead().intValue()==0) {
				if ( getSemmel006Bean().getPaymentDetail().getpReadStr()==null || "".equals(getSemmel006Bean().getPaymentDetail().getpReadStr())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.pRead")));
					flagValid = true;
				}		
				//if ( getSemmel006Bean().getPaymentDetail().getlRead().intValue()==0) {
				if ( getSemmel006Bean().getPaymentDetail().getlReadStr()==null || "".equals(getSemmel006Bean().getPaymentDetail().getlReadStr())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.lRead")));
					flagValid = true;
				}	
				
				
				//if ( getSemmel006Bean().getPaymentDetail().getKwhTotal().intValue()==0) {
				if ( getSemmel006Bean().getPaymentDetail().getKwhTotalStr()==null || "".equals(getSemmel006Bean().getPaymentDetail().getKwhTotalStr())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.kwhTotal")));
					flagValid = true;
				}	
			}
			/*			
			if (StringUtils.isEmpty(getSemmel006Bean().getPaymentDetail().getTermOfPaymentDtMonth())||StringUtils.isEmpty(getSemmel006Bean().getPaymentDetail().getTermOfPaymentDtYear())) {
				FrontMessageUtils.addMessageError( 
						SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.termOfPaymentDt")));
				flagValid = true;
			}
			*/
			//WT###Add 20110128 Start
			if (getSemmel006Bean().getPaymentDetail().getPayAmt().doubleValue()==0.0) {
				FrontMessageUtils.addMessageError( 
						SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.payAmt")));
				flagValid = true;
			}
			if (StringUtils.isEmpty(getSemmel006Bean().getPaymentDetail().getVatType())) {
				FrontMessageUtils.addMessageError( 
						SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vatType")));
				flagValid = true;
			}
			//WT###Add 20110128 End
			//WT###Edit 201101 28 Start
			//if ( (getSemmel006Bean().getPaymentDetail().getVatAmt()==null||getSemmel006Bean().getPaymentDetail().getVatAmt().doubleValue()==0.0)) {
			if ( getSemmel006Bean().getPaymentDetail().getVatAmt()==null) {
			//WT###Edit 201101 28 End
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vatAmt")));
				flagValid = true;
			}
			
			if ( (getSemmel006Bean().getPaymentDetail().getExcludeVatAmt()==null||getSemmel006Bean().getPaymentDetail().getExcludeVatAmt().intValue()==0)) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.excludeVatAmt")));
				flagValid = true;
			}
			if ( (getSemmel006Bean().getPaymentDetail().getIncludeVatAmt()==null||getSemmel006Bean().getPaymentDetail().getIncludeVatAmt().intValue()==0)) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.includeVatAmt")));
				flagValid = true;
			}	
			if ( (getSemmel006Bean().getPaymentDetail().getChqAmt()==null||getSemmel006Bean().getPaymentDetail().getChqAmt().intValue()==0)) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.chqAmt")));
				flagValid = true;
			}
			//---------------------------------------
			
			if (StringUtils.isEmpty(getSemmel006Bean().getPaymentDetail().getFromTermOfPaymentMonth())
			   ||StringUtils.isEmpty(getSemmel006Bean().getPaymentDetail().getFromTermOfPaymentYear())) {
				FrontMessageUtils.addMessageError( 
						SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.fromTermOfPaymentMonthYear")));
				flagValid = true;
			}
			if (getSemmel006Bean().getPaymentDetail().getFromTermOfPaymentDt() == null) {
						FrontMessageUtils.addMessageError( 
								SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.fromTermOfPaymentDt")));
						flagValid = true;
					}
			
			if (StringUtils.isEmpty(getSemmel006Bean().getPaymentDetail().getToTermOfPaymentMonth())
					   ||StringUtils.isEmpty(getSemmel006Bean().getPaymentDetail().getToTermOfPaymentYear())) {
						FrontMessageUtils.addMessageError( 
								SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.toTermOfPaymentMonthYear")));
						flagValid = true;
			}
			
			if (getSemmel006Bean().getPaymentDetail().getToTermOfPaymentDt() == null){ 
					   FrontMessageUtils.addMessageError( 
								SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.toTermOfPaymentDt")));
						flagValid = true;
			}
			
			
			if(getSemmel006Bean().getPaymentDetail().getFromTermOfPaymentDt() != null 
			   && getSemmel006Bean().getPaymentDetail().getToTermOfPaymentDt() != null){
				if (getSemmel006Bean().getPaymentDetail().getFromTermOfPaymentDt().compareTo(getSemmel006Bean().getPaymentDetail().getToTermOfPaymentDt())>0){ 
					FrontMessageUtils.addMessageError( 
				    SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.TermOfPaymentCompare")));
					flagValid = true;
				}
			}
			
			if(getSemmel006Bean().getPayment().getChqPostingDt() != null){
				logger.debug(" Date()"+getSemmel006Bean().getPayment().getChqPostingDt());
				logger.debug("Sysdate Date()"+new Date());
				logger.debug("Compare()"+getSemmel006Bean().getPayment().getChqPostingDt().compareTo(new Date()));
				logger.debug("Compare:"+ELUtils.compare(getSemmel006Bean().getPayment().getChqPostingDt(),new Date()));
				if (ELUtils.compare(getSemmel006Bean().getPayment().getChqPostingDt(),new Date())<0){
					FrontMessageUtils.addMessageError( 
					SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.validateChqPostDate")));
					flagValid = true;
				}
			}
					
		}else	if(ELUtils.EL_TEMP.equalsIgnoreCase(paymentType)){
			// fromTermOfPaymentDt,toTermOfPaymentDt,unitPrice,payAmt,vatType,excludeVatAmt,vatAmt,includeVatAmt,chqAmt
			logger.debug("  ### EL_TEMP ###" );
			if ( getSemmel006Bean().getPaymentDetail().getFromTermOfPaymentDt()==null) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.fromTermOfPaymentDt")));
				flagValid = true;
			}		
			if ( getSemmel006Bean().getPaymentDetail().getToTermOfPaymentDt()==null) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.toTermOfPaymentDt")));
				flagValid = true;
			}	
			/*
			if ( (getSemmel006Bean().getPaymentDetail().getUnitPrice()==null||getSemmel006Bean().getPaymentDetail().getUnitPrice().intValue()==0)) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.unitPrice")));
				flagValid = true;
			}
			*/
			if ( (getSemmel006Bean().getPaymentDetail().getPayAmt()==null||getSemmel006Bean().getPaymentDetail().getPayAmt().intValue()==0)) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.payAmt")));
				flagValid = true;
			}
			if (StringUtils.isEmpty(getSemmel006Bean().getPaymentDetail().getVatType())) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vatType")));
				flagValid = true;
			}
			if ( (getSemmel006Bean().getPaymentDetail().getExcludeVatAmt()==null||getSemmel006Bean().getPaymentDetail().getExcludeVatAmt().intValue()==0)) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.excludeVatAmt")));
				flagValid = true;
			}
			if ( (getSemmel006Bean().getPaymentDetail().getVatAmt()==null)) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vatAmt")));
				flagValid = true;
			}			
			if ( (getSemmel006Bean().getPaymentDetail().getIncludeVatAmt()==null||getSemmel006Bean().getPaymentDetail().getIncludeVatAmt().intValue()==0)) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.includeVatAmt")));
				flagValid = true;
			}	
			if ( (getSemmel006Bean().getPaymentDetail().getChqAmt()==null||getSemmel006Bean().getPaymentDetail().getChqAmt().intValue()==0)) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.chqAmt")));
				flagValid = true;
			}
			
			if(getSemmel006Bean().getPayment().getChqPostingDt() != null){
				logger.debug(" Date()"+getSemmel006Bean().getPayment().getChqPostingDt());
				logger.debug("Sysdate Date()"+new Date());
				logger.debug("Compare()"+getSemmel006Bean().getPayment().getChqPostingDt().compareTo(new Date()));
				logger.debug("Compare:"+ELUtils.compare(getSemmel006Bean().getPayment().getChqPostingDt(),new Date()));
				if (ELUtils.compare(getSemmel006Bean().getPayment().getChqPostingDt(),new Date())<0){
					FrontMessageUtils.addMessageError( 
					SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.validateChqPostDate")));
					flagValid = true;
				}
			}
			if(!getSemmel006Bean().isByPassValidationELTempTermOfPayment()){
				//logger.debug("  ### EL_TEMP ###::"+getSemmel006Bean().isByPassValidationELTempTermOfPayment());
				//logger.debug("  ### EL_TEMP ###::"+ getSemmel006Bean().getPayment().getRemark());
				if ( getSemmel006Bean().getPayment().getRemark() == null || StringUtils.isEmpty(getSemmel006Bean().getPayment().getRemark())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.remark")));
					flagValid = true;
				}		
			}
		}else	if(ELUtils.PR_POSTPAID.equalsIgnoreCase(paymentType)){
				
			logger.debug("  ### PR_POSTPAID ###" );
				if ( getSemmel006Bean().getPaymentDetail().getFromTermOfPaymentDt()==null) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.fromTermOfPaymentDt")));
					flagValid = true;
				}		
				if ( getSemmel006Bean().getPaymentDetail().getToTermOfPaymentDt()==null) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.toTermOfPaymentDt")));
					flagValid = true;
				}	
				if(getSemmel006Bean().getPaymentDetail().getFromTermOfPaymentDt() != null &&
				   getSemmel006Bean().getPaymentDetail().getToTermOfPaymentDt()!=null){
					if(getSemmel006Bean().getPaymentDetail().getFromTermOfPaymentDt().compareTo(
					   getSemmel006Bean().getPaymentDetail().getToTermOfPaymentDt())>0){
						FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.TermOfPaymentCompare")));
						flagValid = true;	
					}
				}
					
				/*WT###Comment 20110405if ( (getSemmel006Bean().getPaymentDetail().getUnitPrice()==null||getSemmel006Bean().getPaymentDetail().getUnitPrice().intValue()==0)) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.unitPrice")));
					flagValid = true;
				}*/
				if ( (getSemmel006Bean().getPaymentDetail().getPayAmt()==null||getSemmel006Bean().getPaymentDetail().getPayAmt().intValue()==0)) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.payAmt")));
					flagValid = true;
				}
			
				/*WT###Comment 20110407if (StringUtils.isEmpty(getSemmel006Bean().getPaymentDetail().getUnitVatType())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.unitVatType")));
					flagValid = true;
				}*/				
				if (StringUtils.isEmpty(getSemmel006Bean().getPaymentDetail().getVatType())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vatType")));
					flagValid = true;
				}
				if ( (getSemmel006Bean().getPaymentDetail().getExcludeVatAmt()==null||getSemmel006Bean().getPaymentDetail().getExcludeVatAmt().intValue()==0)) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.excludeVatAmt")));
					flagValid = true;
				}
				if ( (getSemmel006Bean().getPaymentDetail().getVatAmt()==null)) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vatAmt")));
					flagValid = true;
				}				
				if ( (getSemmel006Bean().getPaymentDetail().getIncludeVatAmt()==null||getSemmel006Bean().getPaymentDetail().getIncludeVatAmt().intValue()==0)) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.includeVatAmt")));
					flagValid = true;
				}	
				if ( (getSemmel006Bean().getPaymentDetail().getChqAmt()==null||getSemmel006Bean().getPaymentDetail().getChqAmt().intValue()==0)) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.chqAmt")));
					flagValid = true;
				}
				if(getSemmel006Bean().getPayment().getChqPostingDt() != null){
					logger.debug(" Date()"+getSemmel006Bean().getPayment().getChqPostingDt());
					logger.debug("Sysdate Date()"+new Date());
					logger.debug("Compare()"+getSemmel006Bean().getPayment().getChqPostingDt().compareTo(new Date()));
					logger.debug("Compare:"+ELUtils.compare(getSemmel006Bean().getPayment().getChqPostingDt(),new Date()));
					if (ELUtils.compare(getSemmel006Bean().getPayment().getChqPostingDt(),new Date())<0){
						FrontMessageUtils.addMessageError( 
						SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.validateChqPostDate")));
						flagValid = true;
					}
				}
		}  
		
		return flagValid;
	}	
	
	
	
	
	//  ---------------- PaymentELTemporary-------------------------------
	private boolean initPaymentELTmp() {
		logger.debug(" -- initPaymentELTemporary--");
		boolean flagValid = false;
		try{
			semmel006Bean = getSemmel006Bean();  
			String pageFrom = (String)getFacesUtils().getRequestParameter("navProgram");
			semmel006Bean.setPageFrom(pageFrom);
			Management management = new Management();
			MeterInfo meterInfo = new MeterInfo();			
			initialData();
			semmel006Bean.getPaymentDetail().setVatType("01");
			semmel006Bean.getPayment().setPaymentType("01");
			semmel006Bean.getPayment().setPaymentMethod(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.CT_PAYMENT_METHOD));//WT###Add 20110207
			semmel006Bean.setByPassValidationELTempTermOfPayment(true);
			//WT###Add 20110202 Start
			semmel006Bean.getPayment().setVendorType(VENDOR_TYPE_SUPPLIER);
			PopupVendorSupplierBean  popupVendorSupplierBean= new PopupVendorSupplierBean();
			popupVendorSupplierBean.setPopupVendorSupplierSearchSP(new PopupVendorSupplierSearchSP());
			popupVendorSupplierBean.setPostTypeList(getLovItemsByType(ELovType.T_CP_POST_TYPE.name));
			popupVendorSupplierBean.setConstructTypeList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_TYPE.name));
			popupVendorSupplierBean.setConstructStatusList(getLovItemsByType(ELovType.T_CP_CONSTRUCT_STATUS.name).subList(0, 1));
			popupVendorSupplierBean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList());
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupVendorSupplierBean",popupVendorSupplierBean);
			//WT###Add 20110202 End
			semmel006Bean.setManagement(management);
			semmel006Bean.setMeterInfo(meterInfo);			
			PopupSiteSearch popupSiteCriteria = new PopupSiteSearch();
			semmel006Bean.setPopupSiteCriteria(popupSiteCriteria);
			// DropDown
			Map<String,String> codeMap = new HashMap();
//			codeMap.put(ELUtils.PAYMENT_METHOD_01,ELUtils.PAYMENT_METHOD_01);
//			codeMap.put(ELUtils.PAYMENT_METHOD_02,ELUtils.PAYMENT_METHOD_02);
//			codeMap.put(ELUtils.PAYMENT_METHOD_03,ELUtils.PAYMENT_METHOD_03);
//			codeMap.put(ELUtils.PAYMENT_METHOD_04,ELUtils.PAYMENT_METHOD_04);
//			semmel006Bean.setCtPaymentMethodList(ELUtils.getLOVBtLOVCodeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name), codeMap));
			semmel006Bean.setCtPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name,EX_AND,"CHEQUE",null,null));
			semmel006Bean.getPayment().setExpenseType("EL_TEMP");
			semmel006Bean.setElExpenseTypeList(ELUtils.filterLOVByLOVValue("4", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name)));		
			semmel006Bean.setElDocTypeList(ELUtils.filterLOVByLOVValue("1", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DOC_TYPE.name)));			
			semmel006Bean.getPayment().setExpenseTypeDisplay(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name),ELUtils.EL_TEMP));	
			if (semmel006Bean.getPayment().getCreateDt()!=null){
				semmel006Bean.getPayment().setDisplayCreateDate(SEMDataUtility.convertToThYear(semmel006Bean.getPayment().getCreateDt()));
			}
			if (semmel006Bean.getPayment().getUpdateDt()!=null){
				semmel006Bean.getPayment().setDisplayUpdateDate(SEMDataUtility.convertToThYear(semmel006Bean.getPayment().getUpdateDt()));
			}
			semmel006Bean.setDisableUpdateModelButton(true);
			semmel006Bean.setDisableAddModelButton(false);
			semmel006Bean.setDisableMoreThanOneDetail(false);		
			semmel006Bean.setPaymentDetailList(new ArrayList<PaymentDetail>());		
			semmel006Bean.setTransferDtDisable(true);
 
			semmel006Bean.setPaymentMethodDisable(false);
			semmel006Bean.setPaymentTypeDisable(false);
			semmel006Bean.setChqPostingDtDisable(false);
			semmel006Bean.setChqReceivedDtDisable(false);
			
			
			
			setSemmel006Bean(semmel006Bean);	
			semmel006Bean.setViewMode(false);
			flagValid = true;	
			
			//WT###Add 20110202 Start
			semmel006Bean.setDisableViewExpenseHisButton(true);
			semmel006Bean.setDisableViewMeterInfoButton(true);
			//WT###End 20110202 End
			semmel006Bean.setDisableVendorTypeButton(true);//WT###Add 20110203
		}catch(Exception ex){
			ex.printStackTrace();
		}

		return flagValid;
	}
	
	private boolean initPopupSearchSiteELTmp() {
		boolean flag = false;
		logger.debug(" -- initPopupSearchSiteELTmp--");
		try{
			semmel006Bean = getSemmel006Bean();
			PopupSiteSearch popupSiteCriteria = new PopupSiteSearch();
			semmel006Bean.setPopupSiteCriteria(popupSiteCriteria);
			semmel006Bean.setPopupSiteList(new ArrayList());	
			semmel006Bean.setSavePopupSiteDisable(true);	
			
		}catch(Exception ex){
			ex.printStackTrace();
		}

		return flag;
	}
	
	private boolean doSearchPopupSiteELTmp() {
		logger.debug(" --  doSearchPopupSiteELTmp --");
		boolean flag = false;
		try {
			semmel006Bean = getSemmel006Bean();
			List<PopupSiteSearch> popupSiteResultList = null;
			IPaymentService service = (IPaymentService)getBean("paymentService");
			popupSiteResultList= service.searchSite(semmel006Bean.getPopupSiteCriteria(),"querySiteELTemp");
			if (popupSiteResultList != null && !popupSiteResultList.isEmpty()) {
				String firstRowId = popupSiteResultList.get(0).getRowNumber();
				semmel006Bean.setSelectedRadio(firstRowId);	
				semmel006Bean.setPopupSiteList(popupSiteResultList);				
			}else{
				semmel006Bean.setPopupSiteList(new ArrayList());
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("M0004"), ""));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return flag;
	}
	
	
	
	
	public boolean doAddSiteELTmp() {
		logger.info("START Action doAddSiteELTmp");
		boolean flag = false;
		try{
			semmel006Bean = getSemmel006Bean();
			
			//WT###Add 20110202 Start
			semmel006Bean.setDisableViewExpenseHisButton(false);
			semmel006Bean.setDisableViewMeterInfoButton(false);
			//WT###End 20110202 End
			semmel006Bean.setDisableVendorTypeButton(false);//WT###Add 20110203
			
			String idSelect = semmel006Bean.getSelectedRadio();				
			List<PopupSiteSearch> siteList = semmel006Bean.getPopupSiteList();		
			String contractNoSelected ="";
			if (siteList != null && !siteList.isEmpty()) {		
				PopupSiteSearch selectSite =new PopupSiteSearch();
				for(PopupSiteSearch tmp:siteList){
					if(idSelect.equalsIgnoreCase(tmp.getRowNumber())){
						selectSite =tmp;
						contractNoSelected=tmp.getContractNo();
					}
				}
				//logger.debug(" PopupSiteSearch select :"+BeanUtils.getBeanString(selectSite));
//				System.out.println("networkStatus = "+selectSite.getNetworkStatus());
				//networkStatus 05=offService,06=remove
				if(StringUtils.equals("05", selectSite.getNetworkStatus()) || 
						StringUtils.equals("06", selectSite.getNetworkStatus())){
					semmel006Bean.setStyleClassName("ms14red");
				}else{
					semmel006Bean.setStyleClassName("ms7");
				}
				
				if(StringUtils.equals("fail", selectSite.getResult().toLowerCase())){
					FrontMessageUtils.addMessageError(selectSite.getRemark());
				}
				
				semmel006Bean.setPopupSiteCriteria(selectSite);
				semmel006Bean.getPayment().setElectricUseType(semmel006Bean.getPopupSiteCriteria().getElectricUseType());
				changeElectricUseType_ELTmp();
			}				
			ELUtils.copySearchsiteToPayment(semmel006Bean.getPopupSiteCriteria(), semmel006Bean.getPayment());			
			semmel006Bean.getPayment().setVendorId("");
			semmel006Bean.getPayment().setVendorName("");
			// Check Vendor Master
			/*
			IVendorMapPayeeELService vendorMapPayeeService = (IVendorMapPayeeELService)getBean("vendorMapPayeeELService");
			VendorMapPayeeEL vendortmp = vendorMapPayeeService.queryVendorMapPayeeMasterForELPayment( contractNoSelected);
			boolean isFoundVendorMaster = true; 
			if(vendortmp!=null){				
				if(vendortmp.getVendorMasterId()!=null){
					if(vendortmp.getVendorMasterId()!=null&&vendortmp.getVendorMasterId().getVendorCode()!=null){
						semmel006Bean.getPayment().setVendorId(vendortmp.getVendorMasterId().getVendorCode());
						semmel006Bean.getPayment().setOldVendorIdTypeV(vendortmp.getVendorMasterId().getVendorCode());//WT###Add 20110203			
					}
					if(vendortmp.getVendorMasterId()!=null&&vendortmp.getVendorMasterId().getVendorName()!=null){
						semmel006Bean.getPayment().setVendorName(vendortmp.getVendorMasterId().getVendorName());
						semmel006Bean.getPayment().setOldVendorNameTypeV(vendortmp.getVendorMasterId().getVendorName());//WT###Add 20110203
					}					
				}else{
					isFoundVendorMaster = false;
				}
				if(vendortmp.getPayeeMasterId()!=null){
					if(vendortmp.getVendorMasterId()!=null&&vendortmp.getPayeeMasterId().getRowId()!=null){
						semmel006Bean.getPayment().setPayeeId(vendortmp.getPayeeMasterId().getRowId());
						semmel006Bean.getPayment().setOldPayeeIdTypeV(vendortmp.getPayeeMasterId().getRowId());//WT###Add 20110203
					}
					if(vendortmp.getVendorMasterId()!=null&&vendortmp.getPayeeMasterId().getPayeeName()!=null){
						semmel006Bean.getPayment().setPayeeName(vendortmp.getPayeeMasterId().getPayeeName());
						semmel006Bean.getPayment().setOldPayeeNameTypeV(vendortmp.getPayeeMasterId().getPayeeName());//WT###Add 20110203
					}					
				}else{
					//isFoundVendorMaster = false;
				}							
				if(!isFoundVendorMaster){
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0040"), ""));
					//addMessageError(ELUtils.EL0040);
				}				
			}else{
			//	addMessageError(ELUtils.EL0040);
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0040"), ""));
			}
			*/
			logger.info("END Action doAddSiteELTmp");
		}catch(Exception ex){
			logger.error("ERROR Action doAddSiteELTmp : "+ex, ex);
			addMessageError(ELUtils.E0001);
			ex.printStackTrace();			
		}
		return flag;
	}
	
	private boolean doClearSearchSiteELTmp() {
		logger.debug(" -- doClearSearchSiteELTmp--");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();
			PopupSiteSearch popupSiteCriteria = new PopupSiteSearch();
			semmel006Bean.setPopupSiteCriteria(popupSiteCriteria);
			semmel006Bean.setPopupSiteList(new ArrayList());	
			semmel006Bean.setSavePopupSiteDisable(true);			
		}catch(Exception ex){
			ex.printStackTrace();
		}

		return flagValid;
	}	
	
	
	public boolean doAddELTmpToModel() {
		logger.debug(" --  doAddELTmpToModel --");
		boolean flag = false;
		try{
			if (validatePayment(ELUtils.EL_TEMP)) {
				return flag;
			}
			if (validatePaymentDetail(ELUtils.EL_TEMP)) {
				return flag;
			}
			semmel006Bean = getSemmel006Bean();			
			Payment newPayment = semmel006Bean.getPayment();
			PaymentDetail paymentDetail = semmel006Bean.getPaymentDetail();	
//			System.out.println("newPayment :"+BeanUtils.getBeanString(newPayment));
//			System.out.println("newPaymentDetail :"+BeanUtils.getBeanString(paymentDetail));
			
			 ELUtils.setPamentDisplayField(newPayment);
	        ELUtils.setPamentDetailDisplayField(paymentDetail);
			List<PaymentDetail> paymentDetailList = newPayment.getPaymentDetailList();			
			if(paymentDetailList==null||paymentDetailList.size()==0){
				paymentDetail.setRowNumber(1);
				logger.debug(" rowNumber for first Row:"+paymentDetail.getRowNumber() );
				List<PaymentDetail> newDetailList = new ArrayList<PaymentDetail>();
				newDetailList.add(paymentDetail);
				newPayment.setPaymentDetailList(newDetailList);
				semmel006Bean.setPaymentDetailList(newDetailList);
			}else{
				int maxCurrentRow = ((PaymentDetail)paymentDetailList.get(paymentDetailList.size()-1)).getRowNumber() +1;
				logger.debug(" maxCurrentRow:"+maxCurrentRow);
				paymentDetail.setRowNumber(maxCurrentRow);
				semmel006Bean.getPaymentDetailList().add(paymentDetail);				
			}	
			reCalculatePaymentConclution(semmel006Bean.getPaymentDetailList(),semmel006Bean.getPayment());
			logger.debug(" expenseTypeDisplay:"+ELUtils.getLOVNameByLOVCode(ELUtils.filterLOVByLOVValue("3", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name)),semmel006Bean.getPayment().getExpenseType()));
			logger.debug("newPayment.getPaymentDetailList() size :"+newPayment.getPaymentDetailList().size() );			
		
			
			PaymentDetail newPaymentDetail = new PaymentDetail();
			newPaymentDetail.setVatType("01");
			semmel006Bean.setPaymentDetail(newPaymentDetail);
			
		}catch(Exception ex){
			addMessageError(ELUtils.E0001);
			ex.printStackTrace();
		}
		return flag;
	}	

	
	public boolean doAddPaymentDetailToModel(String paymentType) {
		logger.debug(" --  doAddPaymentDetailToModel -- Page 6-4");
		boolean flag = false;
		boolean validatePayment = false;
		boolean validatePaymentDetail = false;
		try{
			if (validatePayment(paymentType)) {
				validatePayment =true;
			}
			
			if (validatePaymentDetail(paymentType)) {
				validatePaymentDetail=true;
			}
			
			if(validatePayment||validatePaymentDetail){
				return flag;
			}
		

			// 1. Get Payment Detail Size
			semmel006Bean = getSemmel006Bean();			
			Payment newPayment = semmel006Bean.getPayment();
			ELUtils.copySearchsiteToPayment(semmel006Bean.getPopupSiteCriteria(), newPayment);		
			// 2. Get new PaymentDetail
			PaymentDetail paymentDetail = semmel006Bean.getPaymentDetail();		
					
			PaymentDetail newPaymentDetail = semmel006Bean.getPaymentDetail();					
			ELUtils.setPamentDisplayField(newPayment);
	        ELUtils.setPamentDetailDisplayField(newPaymentDetail);
	        //WT###Edit 20110118 Start
			//List<PaymentDetail> paymentDetailList = newPayment.getPaymentDetailList();
	        List<PaymentDetail> paymentDetailList = semmel006Bean.getPaymentDetailList();
			//WT###Edit 20110118 End

			
			boolean cllPLsuccess = true;
			String plElectricId = semmel006Bean.getPopupSiteCriteria().getElectricId();
			String plMeterInfoId = semmel006Bean.getPopupSiteCriteria().getMeterInfoId();
			String meterId = semmel006Bean.getPopupSiteCriteria().getMeterId();
			paymentDetail.setMeterId(meterId);			
			PaymentDetail detailForcallPL = new PaymentDetail();
			detailForcallPL.setReferMeterId(plElectricId);
			detailForcallPL.setMeterId(plMeterInfoId);
			detailForcallPL.setFromTermOfPaymentDt(paymentDetail.getFromTermOfPaymentDt());
			detailForcallPL.setToTermOfPaymentDt(paymentDetail.getToTermOfPaymentDt());
			detailForcallPL.setProcessType("ADD");
//			newPaymentDetail.setMeterId(meterId);
			newPaymentDetail.setMeterInfoId(plMeterInfoId);
			
			IPaymentService service = (IPaymentService)getBean("paymentService");	
			ParameterConfig parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_PAYMENT_E003");
			logger.debug(" EL_PG_PAYMENT_E003 parameter:"+parameter);
			logger.debug(" service:"+service);
			String value0 = "";
			List plresult  = new ArrayList();
			
			if(semmel006Bean.isByPassValidationELTempTermOfPayment()){
				
				plresult = service.addELTempToModel(parameter.getParamValue(), detailForcallPL);
				logger.debug(" pl return value 4 :"+plresult.get(0));
				 value0 =(String)plresult.get(0);
			}else{
				value0="00";
			}

			//value0="00";
			if("00".equals(value0)){
				if(paymentDetailList==null||paymentDetailList.size()==0){
					newPaymentDetail.setRowNumber(1);
					logger.debug(" rowNumber for first Row:"+newPaymentDetail.getRowNumber() );
					List<PaymentDetail> newDetailList = new ArrayList<PaymentDetail>();
					newDetailList.add(newPaymentDetail);
					newPayment.setPaymentDetailList(newDetailList);
					semmel006Bean.setPaymentDetailList(newDetailList);
				}else{
					int maxCurrentRow = ((PaymentDetail)paymentDetailList.get(paymentDetailList.size()-1)).getRowNumber() +1;
					logger.debug(" maxCurrentRow:"+maxCurrentRow);
					newPaymentDetail.setRowNumber(maxCurrentRow);
					newPaymentDetail.setMeterId(meterId);
					newPaymentDetail.setMeterInfoId(plMeterInfoId);
					semmel006Bean.getPaymentDetailList().add(newPaymentDetail);				
				}					
				reCalculatePaymentConclution(semmel006Bean.getPaymentDetailList(),semmel006Bean.getPayment());
				logger.debug(" expenseTypeDisplay:"+ELUtils.getLOVNameByLOVCode(ELUtils.filterLOVByLOVValue("3", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name)),semmel006Bean.getPayment().getExpenseType()));					
				if(semmel006Bean.getPaymentDetailList()==null||semmel006Bean.getPaymentDetailList().size()<=0){
					semmel006Bean.setDisableMoreThanOneDetail(false);
				}else{
					semmel006Bean.setDisableMoreThanOneDetail(true);
				}
				
				String oldVatType = semmel006Bean.getPaymentDetail().getVatType();
				PaymentDetail payDetail  = new PaymentDetail();
				payDetail.setVatType(oldVatType);
				payDetail.setMeterInfoId(plMeterInfoId);
				payDetail.setMeterId(meterId);
				semmel006Bean.setPaymentDetail(payDetail);
				logger.debug(" Set vatTyp xx :"+semmel006Bean.getPaymentDetail().getVatType());
				addMessageInfo("M0001");
			}else{
				logger.debug(" error desc;"+plresult.get(1));
				FrontMessageUtils.addMessageError((String)plresult.get(1));
			}

			
		}catch(Exception ex){
			addMessageError(ELUtils.E0001);
			ex.printStackTrace();
		}
		return flag;
	}
	
	public boolean validateTotalAmount(){
		boolean flag = false;
		semmel006Bean = getSemmel006Bean();
		if(semmel006Bean.getPaymentDetail() != null){
			if(semmel006Bean.getPaymentDetail().getKwhTotal() == null) {
				semmel006Bean.getPaymentDetail().setKwhTotal(new BigDecimal(0));
			}
			if(semmel006Bean.getPaymentDetail().getUnitPrice() == null) {
				semmel006Bean.getPaymentDetail().setUnitPrice(new BigDecimal(0));
			}
			if(semmel006Bean.getPaymentDetail().getPayAmt() == null) {
				semmel006Bean.getPaymentDetail().setPayAmt(new BigDecimal(0));
			}
			if(semmel006Bean.getPaymentDetail().getKwhTotal().doubleValue() > 0 && semmel006Bean.getPaymentDetail().getUnitPrice().doubleValue() > 0){
				double totalAmount = semmel006Bean.getPaymentDetail().getKwhTotal().doubleValue()*semmel006Bean.getPaymentDetail().getUnitPrice().doubleValue();
				if(semmel006Bean.getPaymentDetail().getPayAmt().doubleValue() > totalAmount + 1 || semmel006Bean.getPaymentDetail().getPayAmt().doubleValue() < totalAmount - 1){
					flag = true;
					addMessageError("EL0082");
				}
			}
		}
		
		return flag;
	}
	
	public boolean doAddPaymentDetailToModelPRPostpaid() {
		logger.info("START Action doAddPaymentDetailToModelPRPostpaid Page 6-5");
		boolean flag = false;
			
			boolean validatePayment = false;
			boolean validatePaymentDetail = false;
			boolean validatePreriod = false;
			String  vatType        = "";
			String  unitVatType = "";
			
			try{
				if (validatePRPostpaidByExpenseType())  {
					validatePayment =true;
				}
				
				if (validatePaymentDetail(ELUtils.PR_POSTPAID)){
					validatePaymentDetail=true;
				}
				
				//VALIDATE PAYMENT AMOUNT
//				if(validatePayment||validatePaymentDetail||validateTotalAmount()){
				if(validatePayment||validatePaymentDetail){
					return flag;
				}			   
			
			// 1. Get Payment Detail Size
			semmel006Bean = getSemmel006Bean();			
			Payment newPayment = semmel006Bean.getPayment();
			ELUtils.copySearchsiteToPayment(semmel006Bean.getPopupSiteCriteria(), newPayment);		
			// 2. Get new PaymentDetail
			PaymentDetail paymentDetail = semmel006Bean.getPaymentDetail();
			paymentDetail.setMeterInfoId(semmel006Bean.getMeterInfo().getRowId());
			String plElectricId = semmel006Bean.getPopupSiteCriteria().getElectricId();	
			String newMeterInfoId = semmel006Bean.getMeterInfo().getRowId();
			
//			START BY NOOM:::::: USE IN NEXT DEPLOY
			SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd",new Locale("en", "US"));
			String dfFromConvert = df.format(paymentDetail.getFromTermOfPaymentDt());
			String dfToConvert = df.format(paymentDetail.getToTermOfPaymentDt());
			ElPrivateValidateSP elPrivateValidateSP = new ElPrivateValidateSP();
			elPrivateValidateSP.setContractNo(semmel006Bean.getPopupSiteCriteria().getContractNo());
			elPrivateValidateSP.setMeterId(newMeterInfoId);
			elPrivateValidateSP.setFromTermPayment(dfFromConvert);
			elPrivateValidateSP.setToTermPayment(dfToConvert);
			elPrivateValidateSP.setpKwh(paymentDetail.getpRead().toString());
			elPrivateValidateSP.setlKwh(paymentDetail.getlRead().toString());
			elPrivateValidateSP.setUnit(paymentDetail.getUnitPrice().toString());
			elPrivateValidateSP.setAmtNew(paymentDetail.getPayAmt().toString());
			
			IPaymentService service = (IPaymentService)getBean("paymentService");	
			List<ElPrivateValidateSP> elPrivateValidateSPList = null;
			elPrivateValidateSPList = service.querySPList(EQueryName.SP_MEL006_PRIVATE_VALIDATE.name, elPrivateValidateSP);
			
			for(ElPrivateValidateSP elValid : elPrivateValidateSPList){
				if (StringUtils.equalsIgnoreCase("success", elValid.getResult())){
					addGeneralMessageError(elValid.getRemark());
				}
			}
//			END BY NOOM::::::
			
			String whtType = paymentDetail.getWhtType();//WT###Add 20110131
			vatType     = paymentDetail.getVatType();
			unitVatType = paymentDetail.getVatType();
			PaymentDetail detailForcallPL = new PaymentDetail();
			detailForcallPL.setReferMeterId(plElectricId);
			detailForcallPL.setMeterId(newMeterInfoId);
			//detailForcallPL.setFromTermOfPaymentDt(paymentDetail.getFromTermOfPaymentDt());
			//detailForcallPL.setToTermOfPaymentDt(paymentDetail.getToTermOfPaymentDt());	
			detailForcallPL.setpRead(paymentDetail.getpRead());
			detailForcallPL.setlRead(paymentDetail.getlRead());
			detailForcallPL.setKwhTotal(paymentDetail.getKwhTotal());		
			detailForcallPL.setMeterInfoId(semmel006Bean.getMeterInfo().getRowId());//WT###Add 20110119
			//-----------------------------------------------------------------------			
			detailForcallPL.setExpenseType(newPayment.getExpenseType());
			detailForcallPL.setValidatePaymentDetailFlagBoolean(paymentDetail.isValidatePaymentDetailFlagBoolean());
			detailForcallPL.setIncludeVatAmt(paymentDetail.getIncludeVatAmt());
			detailForcallPL.setPayAmt(paymentDetail.getPayAmt());
			
			if(paymentDetail.getMultiVendorCheck()== null){
				detailForcallPL.setMultiVendorCheck("N");
			}else{
				detailForcallPL.setMultiVendorCheck(paymentDetail.getMultiVendorCheck());
			}
			detailForcallPL.setMultiVendorCheck(paymentDetail.getMultiVendorCheck());
			BigDecimal unitPrice = paymentDetail.getUnitPrice();
			//logger.debug("<<<<<Vat Type 0            :"+paymentDetail.getVatType());
			//logger.debug("<<<<<Unit Vat Type 0       :"+paymentDetail.getUnitVatType());
			//logger.debug("<<<<<PLead 0               :"+paymentDetail.getpReadStr());
			
			int numberOfTermOfPayment = doGetNumberTermOfPaymentForValidation(paymentDetail).size();
			//logger.debug("<<<<<numberOfTermOfPayment:"+numberOfTermOfPayment);
			
			//paymentDetail.setVatType(vatType);
			//paymentDetail.setUnitVatType(unitVatType);
			
			//logger.debug("<<<<<Vat Type 1            :"+paymentDetail.getVatType());
			//logger.debug("<<<<<Unit Vat Type 1       :"+paymentDetail.getUnitVatType());
			//logger.debug("<<<<<PLead 0               :"+paymentDetail.getpReadStr());
			
			//logger.debug("<<<<<Payment Vat Type 1 >>>>>>>>>>>            :"+newPayment.getVatType());
			
			boolean validateTermOfPaymentFlase = true;
			String docType = newPayment.getDocType();
			
			if(numberOfTermOfPayment > 0){
				
				//for(Date tmp: doGetNumberTermOfPayment(paymentDetail)){
				for(Date tmp: doGetNumberTermOfPaymentForValidation(paymentDetail)){
					//logger.debug("%%%%%%%%%%%%tmp%%%%%%%%%"+tmp);
					//detailForcallPL.setFromTermOfPaymentDt(ELUtils.getDateByMonthandYear(ELUtils.getMonthNumberByDate(tmp) ,ELUtils.getYearNumberByDate(tmp,"th")));
					//detailForcallPL.setToTermOfPaymentDt(ELUtils.getEndDateByMonthandYear( ELUtils.getMonthNumberByDate(tmp),ELUtils.getYearNumberByDate(tmp,"th")));
					detailForcallPL.setFromTermOfPaymentDt(tmp);
					detailForcallPL.setToTermOfPaymentDt(tmp);
					//logger.debug("%%%%%%%%%%%%%%%%%%%%%%"+detailForcallPL.getFromTermOfPaymentDtTH());
					
					//detailForcallPL.setFromTermOfPaymentDt(paymentDetail.getFromTermOfPaymentDt());
					//detailForcallPL.setToTermOfPaymentDt(paymentDetail.getToTermOfPaymentDt());
					//logger.debug(" <<<<<<<<<< detailForcallPL.getFromTermOfPaymentDt:"+detailForcallPL.getFromTermOfPaymentDtTH());
					//logger.debug(" <<<<<<<<<< detailForcallPL.getFromTermOfPaymentDt:"+detailForcallPL.getToTermOfPaymentDtTH());
					//logger.debug(" <<<<<<<<<< detailForcallPL.getFromTermOfPaymentDt:"+detailForcallPL.getFromTermOfPaymentDtTH());
					//logger.debug(" <<<<<<<<<<<detailForcallPL.getToTermOfPaymentDt:"+detailForcallPL.getToTermOfPaymentDtTH());
					//logger.debug("%%%%%%%%%%%%%%%%%%%%%%"+detailForcallPL.getFromTermOfPaymentDtTH());
				
					logger.debug("<<<<<docType>>>>>>>>>:"+docType);
					logger.debug("<<<<<docType>>>>>>>>>:"+docType);
					String plName = "";
//					IPaymentService service = (IPaymentService)getBean("paymentService");	
					//ParameterConfig parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_PAYMENT_P001");			
					if(docType.equalsIgnoreCase("CR")){
						plName = "SEM_PG_EL_SITE_INFO_PROCESS_SP_VALIDATE_PRIVATE_CREDITNOTE";
					}else{
						plName = "SEM_PG_EL_SITE_INFO_PROCESS_SP_VALIDATE_PRIVATE";
					}
					
					List plresult = service.addELPostpaidToModel5(plName, detailForcallPL);
					//logger.debug(" doAddPaymentDetailToModelPRPostpaid() PL return value:"+plresult.get(0));
					String value0 =(String)plresult.get(0);
					if(value0.equals("00")){							
						if(validateTermOfPaymentFlase){
						  validateTermOfPaymentFlase = true;
						}
					
					}else{
						validateTermOfPaymentFlase = false;
						logger.debug(" <<<<<<<<<< Validate Fail:"+detailForcallPL.getFromTermOfPaymentDtTH());
						logger.debug(" error desc;"+plresult.get(1));
						FrontMessageUtils.addMessageError((String)plresult.get(1));
					}
				}
			}else{
				logger.debug("Not Found Term of Payment");
				FrontMessageUtils.addMessageError("Not Found Term of Payment");
			}
			//logger.debug("<<<<<Vat Type xx            :"+paymentDetail.getVatType());
			//logger.debug("<<<<<Unit Vat Type xx       :"+paymentDetail.getUnitVatType());
			//logger.debug("<<<<<PLead xx               :"+paymentDetail.getpReadStr());
			
			if(validateTermOfPaymentFlase){	
				PaymentDetail newPaymentDetail = semmel006Bean.getPaymentDetail();	
				String meterId = semmel006Bean.getMeterInfo().getMeterId();
				String referMeterId = semmel006Bean.getMeterInfo().getReferMeterId();
				String meterAddress = semmel006Bean.getMeterInfo().getpMeterAddress();
				
				newPaymentDetail.setMeterInfoId(semmel006Bean.getMeterInfo().getRowId());//WT###Add 20110118
				newPaymentDetail.setMeterId(meterId);
				newPaymentDetail.setReferMeterId(referMeterId);
				newPaymentDetail.setMeterAddress(meterAddress);
				logger.debug("WT###Print unitPrice="+unitPrice);
				newPaymentDetail.setUnitPrice(unitPrice);//WT###Add 20110405
				
				logger.debug(" meterId:"+meterId+" referMeterId:"+referMeterId+" meterAddress:"+meterAddress);
				
				ELUtils.setPamentDisplayField(newPayment);
		        ELUtils.setPamentDetailDisplayField(newPaymentDetail);
		        //WT###Edit 20110118 Start
		        //List<PaymentDetail> paymentDetailList = newPayment.getPaymentDetailList();
		        List<PaymentDetail> paymentDetailList = semmel006Bean.getPaymentDetailList();
		        //WT###Edit 20110118 End							
				
				if(paymentDetailList==null||paymentDetailList.size()==0){
					newPaymentDetail.setRowNumber(1);
					logger.debug(" rowNumber for first Row:"+newPaymentDetail.getRowNumber() );
					List<PaymentDetail> newDetailList = new ArrayList<PaymentDetail>();
					newDetailList.add(newPaymentDetail);
					newPayment.setPaymentDetailList(newDetailList);
					semmel006Bean.setPaymentDetailList(newDetailList);
				}else{
					int maxCurrentRow = ((PaymentDetail)paymentDetailList.get(paymentDetailList.size()-1)).getRowNumber() +1;
					logger.debug(" maxCurrentRow:"+maxCurrentRow);
					newPaymentDetail.setRowNumber(maxCurrentRow);
					semmel006Bean.getPaymentDetailList().add(newPaymentDetail);				
				}					   
				reCalculatePaymentConclution5(semmel006Bean.getPaymentDetailList(),semmel006Bean.getPayment());
				logger.debug(" expenseTypeDisplay:"+ELUtils.getLOVNameByLOVCode(ELUtils.filterLOVByLOVValue("3", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name)),semmel006Bean.getPayment().getExpenseType()));							
				
				if(semmel006Bean.getPaymentDetailList()==null||semmel006Bean.getPaymentDetailList().size()<=0){
					semmel006Bean.setDisableMoreThanOneDetail(false);
				}else{
					semmel006Bean.setDisableMoreThanOneDetail(true);
				}
				//semmel006Bean.setPaymentDetail(new PaymentDetail());
				//semmel006Bean.getPaymentDetail().setWhtType(whtType);//WT###Add 20110131
				
				if(semmel006Bean.getPaymentDetailList()!=null||semmel006Bean.getPaymentDetailList().size()==0){
					// Set Disable 
					//semmel006Bean.setMeterIdDisable(true);
					semmel006Bean.setExpenseTypeDisable(true);
					semmel006Bean.setDocTypeDisable(true);
					semmel006Bean.setDocNoDisable(true);
					semmel006Bean.setDocDtDisable(true);
					//semmel006Bean.setMeterIdDisable();
					
				}
				semmel006Bean.setPaymentDetail(new PaymentDetail());
				semmel006Bean.getPaymentDetail().setWhtType(whtType);//WT###Add 20110131
				String paymentType = semmel006Bean.getPayment().getPaymentType();
				String paymentMethod = semmel006Bean.getPayment().getPaymentMethod();
				doChangeMeter();
				//logger.debug("<<<<<Payment Vat Type 2 >>>>>>>>>>>            :"+newPayment.getVatType());
				semmel006Bean.getPayment().setPaymentType(paymentType);
				semmel006Bean.getPayment().setPaymentMethod(paymentMethod);
				                 
				
				}
			logger.info("END Action doAddPaymentDetailToModelPRPostpaid");
		}catch(Exception ex){
			addMessageError(ELUtils.E0001);
			ex.printStackTrace();
		}
		return flag;
	}	
	
	public boolean validateTermOfPayment(List<PaymentDetail> paymentDetailListValdation,PaymentDetail paymentDetail) {
		
		logger.debug(" --  validateTermOfPayment---- Private");
		logger.debug("-------------------------------------------------------------");
		boolean flag = false;
		boolean validateFlag = false;
		HashMap numberOfMonth = new HashMap();
		HashMap newPayMentOfMonth = new HashMap();
		String oldMerterInfo_id = "";
		String newMerterInfo_id ="";
		
		try{   
		    if(paymentDetailListValdation !=null && paymentDetailListValdation.size()>0){
		    	
				for(PaymentDetail tmp: paymentDetailListValdation){
					logger.debug("----------for(PaymentDetail tmp: paymentDetailListValdation)----------------------------");
					String fromMonth = ELUtils.getMonthNumberByDate(tmp.getFromTermOfPaymentDt());
					String fromYear = ELUtils.getYearNumberByDate(tmp.getFromTermOfPaymentDt());
					String toMonth = ELUtils.getMonthNumberByDate(tmp.getToTermOfPaymentDt());
					String toYear = ELUtils.getYearNumberByDate(tmp.getToTermOfPaymentDt());
					
					logger.debug("fromMonth: "+fromMonth);
					logger.debug("fromYear: "+fromYear );
					logger.debug("toMonth: "+toMonth);
					logger.debug("toYear:"+toYear );
					
					oldMerterInfo_id = tmp.getMeterInfoId();
					//newMerterInfo_id = paymentDetail.getMeterInfoId();
					
					logger.debug("---------oldMerterInfo_id-------:"+oldMerterInfo_id);
					//logger.debug("---------newMerterInfo_id-------:"+newMerterInfo_id);
					
					int totalMonth = ((Integer.parseInt(toMonth) - Integer.parseInt(fromMonth))
					                  +((Integer.parseInt(toYear)-Integer.parseInt(fromYear))*12))+1;
					
					logger.debug("totalMonth: "+totalMonth );
					//String startPreriodMonth = fromMonth + "/" + fromYear;
					int startPreriodMonth = Integer.parseInt(fromMonth);
					int startPreriodYear  = Integer.parseInt(fromYear);
					
					String onProcess = new String();
					
					if(totalMonth > 0){
						
						for (int i = 1; i <= totalMonth; i++){
							onProcess = "";
							if (i ==1){
							   
								onProcess = startPreriodMonth + "/" + startPreriodYear;
							   
							}
							else{
								startPreriodMonth = startPreriodMonth+1;
								if(startPreriodMonth > 12){
									startPreriodMonth = 1;
									startPreriodYear= startPreriodYear+1;
									onProcess = startPreriodMonth + "/" + startPreriodYear;
								}
								else{
									onProcess = startPreriodMonth + "/" + startPreriodYear;
								}
							}
							if(onProcess != ""){
						    	numberOfMonth.put(onProcess, oldMerterInfo_id);
						    }
						}
					}
				}
				
				//logger.debug("- --numberOfMonth.entrySet();-");
				validateFlag = true;
				//Set set = numberOfMonth.entrySet();
				//Iterator i = set.iterator();
				//while(i.hasNext()){
			     // Map.Entry me = (Map.Entry)i.next();
			      //logger.debug(me.getKey() + " : " + me.getValue());
			    //}

			}
			if(validateFlag){
				
			    logger.debug("------------Start Validation Process------------------------");
				String fromMonth = ELUtils.getMonthNumberByDate(paymentDetail.getFromTermOfPaymentDt());
				String fromYear = ELUtils.getYearNumberByDate(paymentDetail.getFromTermOfPaymentDt());
				String toMonth = ELUtils.getMonthNumberByDate(paymentDetail.getToTermOfPaymentDt());
				String toYear = ELUtils.getYearNumberByDate(paymentDetail.getToTermOfPaymentDt());
				newMerterInfo_id = paymentDetail.getMeterInfoId();
				
				logger.debug("fromMonth: "+fromMonth);
				logger.debug("fromYear: "+fromYear );
				logger.debug("toMonth: "+toMonth);
				logger.debug("toYear:"+toYear );
				logger.debug("---------newMerterInfo_id-------:"+newMerterInfo_id);
				
				int totalMonth = ((Integer.parseInt(toMonth) - Integer.parseInt(fromMonth))
				                  +((Integer.parseInt(toYear)-Integer.parseInt(fromYear))*12))+1;
				
				logger.debug("totalMonth "+totalMonth );
				int startPreriodMonth = Integer.parseInt(fromMonth);
				int startPreriodYear  = Integer.parseInt(fromYear);
				
				String onProcess = new String();
				
				if(totalMonth > 0){
					
					for (int i = 1; i <= totalMonth; i++){
						onProcess = "";
						if (i ==1){
						   onProcess = startPreriodMonth + "/" + startPreriodYear;
						}
						else{
							startPreriodMonth = startPreriodMonth+1;
							if(startPreriodMonth > 12){
								startPreriodMonth = 1;
								startPreriodYear= startPreriodYear+1;
								onProcess = startPreriodMonth + "/" + startPreriodYear;
							}
							else{
								onProcess = startPreriodMonth + "/" + startPreriodYear;
							}
						}
						if(onProcess != ""){
							newPayMentOfMonth.put(onProcess, onProcess);
					    }
					}
					logger.debug("-----newPayMentOfMonth.entrySet();---------");
					
					Set set = newPayMentOfMonth.entrySet();
					Iterator i = set.iterator();
					while(i.hasNext()){
				    	Map.Entry me = (Map.Entry)i.next();
				    	logger.debug(me.getKey() + " : " + me.getValue());
				    	String key = me.getKey().toString();
				        
				    	if(numberOfMonth.containsKey(key)){
				    	    String value = numberOfMonth.get(key).toString();
				    		logger.debug("********Found Same Preriod of Paymeny********* ");
				    		logger.debug("********numberOfMonth.get(key).toString()*********"+value);
				    		if(value.equalsIgnoreCase(newMerterInfo_id)){
				    			FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.preriodoftime")));
				    			return flag = true;
				    		}
				    	}
				    }
				}
			}
		}catch(Exception ex){
			
			ex.printStackTrace();
		}
		
	   return flag;
	}	
	
	
	private void reCalculatePaymentConclutionPosPaid5(List<PaymentDetail> paylist,Payment payment){		
		BigDecimal excludeVatAmt = new BigDecimal(0);
		BigDecimal vatAmt = new BigDecimal(0);
		BigDecimal includeVatAmt = new BigDecimal(0);
		BigDecimal chqAmt = new BigDecimal(0);
		BigDecimal payAmt = new BigDecimal(0);
		BigDecimal whtAmt = new BigDecimal(0);
		
		for(PaymentDetail tmp: paylist){
			excludeVatAmt = excludeVatAmt.add(tmp.getExcludeVatAmt()==null?new BigDecimal(0):tmp.getExcludeVatAmt());
			vatAmt = vatAmt.add(tmp.getVatAmt()==null?new BigDecimal(0):tmp.getVatAmt());
			includeVatAmt = includeVatAmt.add(tmp.getIncludeVatAmt()==null?new BigDecimal(0):tmp.getIncludeVatAmt());
			chqAmt = chqAmt.add(tmp.getChqAmt()==null?new BigDecimal(0):tmp.getChqAmt());
			payAmt = payAmt.add(tmp.getPayAmt()==null?new BigDecimal(0):tmp.getPayAmt());
			whtAmt = whtAmt.add(tmp.getWhtAmt()==null?new BigDecimal(0):tmp.getWhtAmt());
		}		
		payment.setTotalExpense(paylist.size());
		payment.setIncludeVatAmt(includeVatAmt);
		payment.setVatAmt(vatAmt);
		payment.setExcludeVatAmt(excludeVatAmt);
		payment.setChqAmt(chqAmt);
		payment.setPayAmt(payAmt);
		payment.setPayAmt(whtAmt);

	}	
	private void reCalculatePaymentConclutionPosPaid(List<PaymentDetail> paylist,Payment payment){		
		BigDecimal excludeVatAmt = new BigDecimal(0);
		BigDecimal vatAmt = new BigDecimal(0);
		BigDecimal includeVatAmt = new BigDecimal(0);
		BigDecimal chqAmt = new BigDecimal(0);
		BigDecimal payAmt = new BigDecimal(0);
		//BigDecimal whtAmt = new BigDecimal(0);
		
		for(PaymentDetail tmp: paylist){
			excludeVatAmt = excludeVatAmt.add(tmp.getExcludeVatAmt()==null?new BigDecimal(0):tmp.getExcludeVatAmt());
			vatAmt = vatAmt.add(tmp.getVatAmt()==null?new BigDecimal(0):tmp.getVatAmt());
			includeVatAmt = includeVatAmt.add(tmp.getIncludeVatAmt()==null?new BigDecimal(0):tmp.getIncludeVatAmt());
			chqAmt = chqAmt.add(tmp.getChqAmt()==null?new BigDecimal(0):tmp.getChqAmt());
			payAmt = payAmt.add(tmp.getPayAmt()==null?new BigDecimal(0):tmp.getPayAmt());
			//whtAmt = whtAmt.add(tmp.getWhtAmt()==null?new BigDecimal(0):tmp.getWhtAmt());
		}		
		payment.setTotalExpense(paylist.size());
		payment.setIncludeVatAmt(includeVatAmt);
		payment.setVatAmt(vatAmt);
		payment.setExcludeVatAmt(excludeVatAmt);
		payment.setChqAmt(chqAmt);
		payment.setPayAmt(payAmt);
		//payment.setPayAmt(whtAmt);
		
		BigDecimal vatRate =  payment.getWhtRate()==null?new BigDecimal(0):payment.getWhtRate();
		BigDecimal whtAmt = ELUtils.getAmtPercent(excludeVatAmt, vatRate);								
		logger.debug("  whtAmt:"+whtAmt);
		payment.setWhtAmt(whtAmt);
		
		//getSemmel006Bean().setPreviosWhtAmt(whtAmt);
		//getSemmel006Bean().setPreviosVatAmt(vatAmt);
		//doRecalCulateTotalVATPR();
	}	
	
	private void reCalculatePaymentConclution(List<PaymentDetail> paylist,Payment payment){	
		logger.debug(" reCalculatePaymentConclution" );
		BigDecimal excludeVatAmt = new BigDecimal(0);
		BigDecimal vatAmt = new BigDecimal(0);
		BigDecimal includeVatAmt = new BigDecimal(0);
		BigDecimal chqAmt = new BigDecimal(0);
		BigDecimal payAmt = new BigDecimal(0);
		
		for(PaymentDetail tmp: paylist){
			excludeVatAmt = excludeVatAmt.add(tmp.getExcludeVatAmt()==null?new BigDecimal(0):tmp.getExcludeVatAmt());
			vatAmt = vatAmt.add(tmp.getVatAmt()==null?new BigDecimal(0):tmp.getVatAmt());
			includeVatAmt = includeVatAmt.add(tmp.getIncludeVatAmt()==null?new BigDecimal(0):tmp.getIncludeVatAmt());
			chqAmt = chqAmt.add(tmp.getChqAmt()==null?new BigDecimal(0):tmp.getChqAmt());
			payAmt = payAmt.add(tmp.getPayAmt()==null?new BigDecimal(0):tmp.getPayAmt());
		}		
		payment.setTotalExpense(paylist.size());
		payment.setIncludeVatAmt(includeVatAmt);
		payment.setVatAmt(vatAmt);
		payment.setExcludeVatAmt(excludeVatAmt);
		payment.setChqAmt(chqAmt);
		payment.setPayAmt(payAmt);
		
		BigDecimal vatRate =  payment.getWhtRate()==null?new BigDecimal(0):payment.getWhtRate();
		BigDecimal whtAmt = ELUtils.getAmtPercent(excludeVatAmt, vatRate);								
		logger.debug("  whtAmt:"+whtAmt);
		payment.setWhtAmt(whtAmt);
		
		
		getSemmel006Bean().setPreviosWhtAmt(whtAmt);
		getSemmel006Bean().setPreviosVatAmt(vatAmt);

	}
	private void reCalculatePaymentConclution5(List<PaymentDetail> paylist,Payment payment){	
		logger.debug(" reCalculatePaymentConclution5" );
		BigDecimal excludeVatAmt = new BigDecimal(0);
		BigDecimal vatAmt = new BigDecimal(0);
		BigDecimal includeVatAmt = new BigDecimal(0);
		BigDecimal chqAmt = new BigDecimal(0);
		BigDecimal payAmt = new BigDecimal(0);
		BigDecimal whtAmt = new BigDecimal(0);
		
		for(PaymentDetail tmp: paylist){
			excludeVatAmt = excludeVatAmt.add(tmp.getExcludeVatAmt()==null?new BigDecimal(0):tmp.getExcludeVatAmt());
			vatAmt = vatAmt.add(tmp.getVatAmt()==null?new BigDecimal(0):tmp.getVatAmt());
			includeVatAmt = includeVatAmt.add(tmp.getIncludeVatAmt()==null?new BigDecimal(0):tmp.getIncludeVatAmt());
			chqAmt = chqAmt.add(tmp.getChqAmt()==null?new BigDecimal(0):tmp.getChqAmt());
			payAmt = payAmt.add(tmp.getPayAmt()==null?new BigDecimal(0):tmp.getPayAmt());
			whtAmt = whtAmt.add(tmp.getWhtAmt()==null?new BigDecimal(0):tmp.getWhtAmt());
		}		
		payment.setTotalExpense(paylist.size());
		payment.setIncludeVatAmt(includeVatAmt);
		payment.setVatAmt(vatAmt);
		payment.setExcludeVatAmt(excludeVatAmt);
		payment.setChqAmt(chqAmt);
		payment.setPayAmt(payAmt);
		payment.setWhtAmt(whtAmt);	
		
		getSemmel006Bean().setPreviosWhtAmt(whtAmt);
		getSemmel006Bean().setPreviosVatAmt(vatAmt);

	}
	private void reCalculatePaymentConclution6(List<PaymentDetail> paylist,Payment payment){	
		logger.debug(" reCalculatePaymentConclution6" );
		BigDecimal excludeVatAmt = new BigDecimal(0);
		BigDecimal vatAmt = new BigDecimal(0);
		BigDecimal includeVatAmt = new BigDecimal(0);
		BigDecimal chqAmt = new BigDecimal(0);
		BigDecimal payAmt = new BigDecimal(0);
		BigDecimal whtAmt = new BigDecimal(0);
		
		for(PaymentDetail tmp: paylist){
			excludeVatAmt = excludeVatAmt.add(tmp.getExcludeVatAmt()==null?new BigDecimal(0):tmp.getExcludeVatAmt());
			vatAmt = vatAmt.add(tmp.getVatAmt()==null?new BigDecimal(0):tmp.getVatAmt());
			includeVatAmt = includeVatAmt.add(tmp.getIncludeVatAmt()==null?new BigDecimal(0):tmp.getIncludeVatAmt());
			chqAmt = chqAmt.add(tmp.getChqAmt()==null?new BigDecimal(0):tmp.getChqAmt());
			payAmt = payAmt.add(tmp.getPayAmt()==null?new BigDecimal(0):tmp.getPayAmt());
			whtAmt = whtAmt.add(tmp.getWhtAmt()==null?new BigDecimal(0):tmp.getWhtAmt());
		}		
		payment.setTotalExpense(paylist.size());
		payment.setIncludeVatAmt(includeVatAmt);
		payment.setVatAmt(vatAmt);
		payment.setExcludeVatAmt(excludeVatAmt);
		payment.setChqAmt(chqAmt);
		payment.setPayAmt(payAmt);
	//	payment.setWhtAmt(whtAmt);	
		
		//getSemmel006Bean().setPreviosWhtAmt(whtAmt);
		getSemmel006Bean().setPreviosVatAmt(vatAmt);
		
		
		BigDecimal vatRate =  payment.getWhtRate()==null?new BigDecimal(0):payment.getWhtRate();
		whtAmt = ELUtils.getAmtPercent(excludeVatAmt, vatRate);								
		logger.debug("  whtAmt:"+whtAmt);
		payment.setWhtAmt(whtAmt);
		
		
		getSemmel006Bean().setPreviosWhtAmt(whtAmt);
		getSemmel006Bean().setPreviosVatAmt(vatAmt);

	}
	public void doChangePaymentVatAmt( ){
		logger.debug(" doChangePaymentVatAmt");
		semmel006Bean = getSemmel006Bean();	 
		Payment paymentDetail = semmel006Bean.getPayment();		
		
		BigDecimal excludeVatAmt = new BigDecimal(0);
		BigDecimal currentvatAmt =  paymentDetail.getVatAmt()==null?new BigDecimal(0):paymentDetail.getVatAmt().setScale(3,BigDecimal.ROUND_HALF_DOWN);
		BigDecimal previousVatAmt =  semmel006Bean.getPreviosVatAmt()==null?new BigDecimal(0):semmel006Bean.getPreviosVatAmt().setScale(3,BigDecimal.ROUND_HALF_DOWN);
		BigDecimal includeVatAmt = new BigDecimal(0);
		
		if(currentvatAmt.intValue()==0){
			reCalculatePaymentDetailConclution();
		}else{
			  includeVatAmt  =paymentDetail.getIncludeVatAmt()==null?new BigDecimal(0):paymentDetail.getIncludeVatAmt().setScale(3,BigDecimal.ROUND_HALF_DOWN);
			  excludeVatAmt  =paymentDetail.getExcludeVatAmt()==null?new BigDecimal(0):paymentDetail.getExcludeVatAmt().setScale(3,BigDecimal.ROUND_HALF_DOWN);
			  boolean compareStatus = true;
			  BigDecimal div= previousVatAmt.subtract(currentvatAmt);
			  int compareResult = 0;
			  //previousVatAmt>currentvatAmt
			  if(previousVatAmt.compareTo(currentvatAmt)==1){				  
				  compareResult =  div.compareTo(new BigDecimal(1));
				  if(compareResult==1){
					  compareStatus =false;
				  }
				//previousVatAmt<currentvatAmt
			  }else if (previousVatAmt.compareTo(currentvatAmt)==-1){
				  compareResult =  div.compareTo(new BigDecimal(-1));
				  if(compareResult==-1){
					  compareStatus =false;
				  }
				//previousVatAmt==currentvatAmt
			  }else if(previousVatAmt.compareTo(currentvatAmt)==0){
				  
			  }
			  
			
			  
			  logger.debug(" currentvatAmt "+currentvatAmt +"previousVatAmt: "+previousVatAmt +"div:"+div+"  compartresult:"+compareResult);
			  if(!compareStatus){
				  // Error message EL0039
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0039"), ""));
					//reCalculatePaymentConclution6();
					paymentDetail.setVatAmt(previousVatAmt);
			  }else{
				  excludeVatAmt = includeVatAmt.subtract(currentvatAmt);
				  paymentDetail.setExcludeVatAmt(excludeVatAmt);
				  paymentDetail.setVatAmt(currentvatAmt);
				  //semmel006Bean.setPreviosVatAmt(currentvatAmt);
			  }
		} 
	}	
	public void doChangeVatAmt5( ){	
		logger.debug(" doChangeVatAmt5");
		semmel006Bean = getSemmel006Bean();	 
		PaymentDetail paymentDetail = semmel006Bean.getPaymentDetail();		
		
		BigDecimal excludeVatAmt = new BigDecimal(0);
		BigDecimal currentvatAmt =  paymentDetail.getVatAmt()==null?new BigDecimal(0):paymentDetail.getVatAmt().setScale(3,BigDecimal.ROUND_HALF_DOWN);
	//	BigDecimal previousVatAmt =  semmel006Bean.getPreviosVatAmt()==null?new BigDecimal(0):semmel006Bean.getPreviosVatAmt().setScale(3,BigDecimal.ROUND_DOWN);
		
		BigDecimal payAmt =  paymentDetail.getPayAmt()==null?new BigDecimal(0):paymentDetail.getPayAmt().setScale(3,BigDecimal.ROUND_HALF_DOWN);

		BigDecimal previousVatAmt =  ELUtils.getVatAmtFromTotalPay(payAmt);

		BigDecimal includeVatAmt = new BigDecimal(0);
		
		if(currentvatAmt.intValue()==0){
			reCalculatePaymentDetailConclution();
		}else{
			  includeVatAmt  =paymentDetail.getIncludeVatAmt()==null?new BigDecimal(0):paymentDetail.getIncludeVatAmt().setScale(2,BigDecimal.ROUND_UP);
			  excludeVatAmt  =paymentDetail.getExcludeVatAmt()==null?new BigDecimal(0):paymentDetail.getExcludeVatAmt().setScale(2,BigDecimal.ROUND_UP);
			  boolean compareStatus = true;
			  BigDecimal div= previousVatAmt.subtract(currentvatAmt).setScale(2,BigDecimal.ROUND_UP);
			  int compareResult = 0;
			  //previousVatAmt>currentvatAmt
			  if(previousVatAmt.compareTo(currentvatAmt)==1){				  
				  compareResult =  div.compareTo(new BigDecimal(1));
				  if(compareResult==1){
					  compareStatus =false;
				  }
				//previousVatAmt<currentvatAmt
			  }else if (previousVatAmt.compareTo(currentvatAmt)==-1){
				  compareResult =  div.compareTo(new BigDecimal(-1));
				  if(compareResult==-1){
					  compareStatus =false;
				  }
				//previousVatAmt==currentvatAmt
			  }else if(previousVatAmt.compareTo(currentvatAmt)==0){
				  
			  }
			  
			
			  
			  logger.debug(" currentvatAmt "+currentvatAmt +"previousVatAmt: "+previousVatAmt +"div:"+div+"  compartresult:"+compareResult);
			  if(!compareStatus){
				  // Error message EL0039
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0039"), ""));
					//reCalculatePaymentDetailConclution();
					doRecalCulateVATPR();
					//paymentDetail.setVatAmt(previousVatAmt);
					//WT###Comment 20110119paymentDetail.setVatAmt(ELUtils.getSevenVAtAmtFromOriginalPrice(payAmt));
			  }else{
				  excludeVatAmt = includeVatAmt.subtract(currentvatAmt);
				  paymentDetail.setExcludeVatAmt(excludeVatAmt);
				  paymentDetail.setVatAmt(currentvatAmt);
				  semmel006Bean.setPreviosVatAmt(currentvatAmt);
			  }
		} 
	}		
	public void doChangeVatAmt( ){	
		logger.debug(" doChangeVatAmt");
		semmel006Bean = getSemmel006Bean();	 
		PaymentDetail paymentDetail = semmel006Bean.getPaymentDetail();		
		
		BigDecimal excludeVatAmt = new BigDecimal(0);
		BigDecimal currentvatAmt =  paymentDetail.getVatAmt()==null?new BigDecimal(0):paymentDetail.getVatAmt().setScale(3,BigDecimal.ROUND_DOWN);
		BigDecimal previousVatAmt =  semmel006Bean.getPreviosVatAmt()==null?new BigDecimal(0):semmel006Bean.getPreviosVatAmt().setScale(3,BigDecimal.ROUND_DOWN);
		BigDecimal includeVatAmt = new BigDecimal(0);
		
		if(currentvatAmt.intValue()==0){
			reCalculatePaymentDetailConclution();
		}else{
			  includeVatAmt  =paymentDetail.getIncludeVatAmt()==null?new BigDecimal(0):paymentDetail.getIncludeVatAmt().setScale(2,BigDecimal.ROUND_UP);
			  excludeVatAmt  =paymentDetail.getExcludeVatAmt()==null?new BigDecimal(0):paymentDetail.getExcludeVatAmt().setScale(2,BigDecimal.ROUND_UP);
			  boolean compareStatus = true;
			  BigDecimal div= previousVatAmt.subtract(currentvatAmt).setScale(2,BigDecimal.ROUND_UP);
			  int compareResult = 0;
			  //previousVatAmt>currentvatAmt
			  if(previousVatAmt.compareTo(currentvatAmt)==1){				  
				  compareResult =  div.compareTo(new BigDecimal(1));
				  if(compareResult==1){
					  compareStatus =false;
				  }
				//previousVatAmt<currentvatAmt
			  }else if (previousVatAmt.compareTo(currentvatAmt)==-1){
				  compareResult =  div.compareTo(new BigDecimal(-1));
				  if(compareResult==-1){
					  compareStatus =false;
				  }
				//previousVatAmt==currentvatAmt
			  }else if(previousVatAmt.compareTo(currentvatAmt)==0){
				  
			  }
			  
			
			  
			  logger.debug(" currentvatAmt "+currentvatAmt +"previousVatAmt: "+previousVatAmt +"div:"+div+"  compartresult:"+compareResult);
			  if(!compareStatus){
				  // Error message EL0039
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0039"), ""));
					//reCalculatePaymentDetailConclution();
					paymentDetail.setVatAmt(previousVatAmt);
			  }else{
				  excludeVatAmt = includeVatAmt.subtract(currentvatAmt);
				  paymentDetail.setExcludeVatAmt(excludeVatAmt);
				  paymentDetail.setVatAmt(currentvatAmt);
				  semmel006Bean.setPreviosVatAmt(currentvatAmt);
			  }
		} 
	}	
	
	//WT###Add 20110204 Start
	public void doChangeVatAmtPage64(){	
		logger.info("START Action doChangeVatAmtPage64");
		try{
			
			SEMMEL006Bean semmel006Bean = getSemmel006Bean();
			
			double includeVat = semmel006Bean.getPaymentDetail().getIncludeVatAmt().doubleValue();
			BigDecimal calculatedVatAmt = new BigDecimal("0");
			double vatAmt = semmel006Bean.getPaymentDetail().getVatAmt().doubleValue();
			double payAmt = 0.0;
			
			String vatType = semmel006Bean.getPaymentDetail().getVatType();
			payAmt = semmel006Bean.getPaymentDetail().getPayAmt().doubleValue();
			
			double vatRate = SEMMEL001Util.VAT_RATE;
			
			if("01".equalsIgnoreCase(vatType)){ 				// include
				
				calculatedVatAmt = new BigDecimal((payAmt*vatRate)/(100.0+vatRate)).setScale(2, BigDecimal.ROUND_HALF_UP);
				
				// verify fvatAmtDisable
				//semmel001Bean.setFvatAmtDisable(false);
				
			}else if("02".equalsIgnoreCase(vatType)){ 			// exclude
				
				calculatedVatAmt = new BigDecimal(payAmt*(vatRate/100.0)).setScale(2, BigDecimal.ROUND_HALF_UP);
				
				// verify fvatAmtDisable
				//semmel001Bean.setFvatAmtDisable(false);
			}
			
			// validate vatAmt
			if(Math.abs(calculatedVatAmt.doubleValue() - vatAmt) > 1.0){
				
				semmel006Bean.getPaymentDetail().setVatAmt(calculatedVatAmt);
				semmel006Bean.getPaymentDetail().setExcludeVatAmt(new BigDecimal(includeVat - calculatedVatAmt.doubleValue()));
				
				addMessageError("EL0039");
				
				return;
			}
			
			semmel006Bean.getPaymentDetail().setExcludeVatAmt(new BigDecimal(includeVat - vatAmt));
			semmel006Bean.getPaymentDetail().setVatAmt(new BigDecimal(vatAmt));
			
			logger.info("END Action doChangeVatAmtPage64");
		}catch(Exception e){
			logger.info("ERROR Action doChangeVatAmtPage64");
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMEL006");
			FrontMessageUtils.addMessageError(errorMsg);
		}
	}
	//WT###Add 20110204 End
	
	//WT###Add 20110128 Start
	public void doChangeVatAmtPage63(){	
		logger.info("START Action doChangeVatAmtPage63");
		try{
			
			SEMMEL006Bean semmel006Bean = getSemmel006Bean();
			
			double includeVat = semmel006Bean.getPaymentDetail().getIncludeVatAmt().doubleValue();
			BigDecimal calculatedVatAmt = new BigDecimal("0");
			double vatAmt = semmel006Bean.getPaymentDetail().getVatAmt().doubleValue();
			double payAmt = 0.0;
			
			String vatType = semmel006Bean.getPaymentDetail().getVatType();
			payAmt = semmel006Bean.getPaymentDetail().getPayAmt().doubleValue();
			
			double vatRate = SEMMEL001Util.VAT_RATE;
			
			if("01".equalsIgnoreCase(vatType)){ 				// include
				
				calculatedVatAmt = new BigDecimal((payAmt*vatRate)/(100.0+vatRate)).setScale(2, BigDecimal.ROUND_HALF_UP);
				
				// verify fvatAmtDisable
				//semmel001Bean.setFvatAmtDisable(false);
				
			}else if("02".equalsIgnoreCase(vatType)){ 			// exclude
				
				calculatedVatAmt = new BigDecimal(payAmt*(vatRate/100.0)).setScale(2, BigDecimal.ROUND_HALF_UP);
				
				// verify fvatAmtDisable
				//semmel001Bean.setFvatAmtDisable(false);
			}
			
			// validate vatAmt
			if(Math.abs(calculatedVatAmt.doubleValue() - vatAmt) > 1.0){
				
				semmel006Bean.getPaymentDetail().setVatAmt(calculatedVatAmt);
				semmel006Bean.getPaymentDetail().setExcludeVatAmt(new BigDecimal(includeVat - calculatedVatAmt.doubleValue()));
				
				addMessageError("EL0039");
				
				return;
			}
			
			semmel006Bean.getPaymentDetail().setExcludeVatAmt(new BigDecimal(includeVat - vatAmt));
			semmel006Bean.getPaymentDetail().setVatAmt(new BigDecimal(vatAmt));
			
		}catch(Exception e){
			logger.info("ERROR Action doChangeVatAmtPage63");
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMEL006");
			FrontMessageUtils.addMessageError(errorMsg);
		}
	}
	//WT###Add 20110128 End
	
	public void doChangeVatAmtTemp( ){	
		logger.debug(" doChangeVatAmtTemp");
		semmel006Bean = getSemmel006Bean();	 
		PaymentDetail paymentDetail = semmel006Bean.getPaymentDetail();		
		
		BigDecimal excludeVatAmt = new BigDecimal(0);
		BigDecimal currentvatAmt =  paymentDetail.getVatAmt()==null?new BigDecimal(0):paymentDetail.getVatAmt().setScale(3,BigDecimal.ROUND_DOWN);
		

		// New Get from payAmti
		//BigDecimal previousVatAmt =  semmel006Bean.getPreviosVatAmt()==null?new BigDecimal(0):semmel006Bean.getPreviosVatAmt();
		BigDecimal payAmt = paymentDetail.getPayAmt();
		logger.debug(" PayAmt :"+payAmt);
		BigDecimal previousVatAmt  = ELUtils.getVatAmtFromTotalPay(payAmt);
			
			
		BigDecimal includeVatAmt = new BigDecimal(0);
		
		if(currentvatAmt.intValue()==0){
			reCalculatePaymentDetailConclution();
		}else{
			  includeVatAmt  =paymentDetail.getIncludeVatAmt()==null?new BigDecimal(0):paymentDetail.getIncludeVatAmt().setScale(2,BigDecimal.ROUND_UP);
			  excludeVatAmt  =paymentDetail.getExcludeVatAmt()==null?new BigDecimal(0):paymentDetail.getExcludeVatAmt().setScale(2,BigDecimal.ROUND_UP);
			  boolean compareStatus = true;
			  BigDecimal div= previousVatAmt.subtract(currentvatAmt);
			  int compareResult = 0;
			  //previousVatAmt>currentvatAmt
			  if(previousVatAmt.compareTo(currentvatAmt)==1){	
				  logger.debug(" previousVatAmt>currentvatAmt ");
				  compareResult =  div.compareTo(new BigDecimal(1));
				  if(compareResult==1){
					  compareStatus =false;
				  }
				//previousVatAmt<currentvatAmt
			  }else if (previousVatAmt.compareTo(currentvatAmt)==-1){
				  logger.debug(" previousVatAmt<currentvatAmt ");
				  compareResult =  div.compareTo(new BigDecimal(-1));
				  if(compareResult==-1){
					  compareStatus =false;
				  }
				//previousVatAmt==currentvatAmt
			  }else if(previousVatAmt.compareTo(currentvatAmt)==0){
				  logger.debug(" previousVatAmt==currentvatAmt");
			  }
			  
			
			  
			  logger.debug(" currentvatAmt "+currentvatAmt +"previousVatAmt: "+previousVatAmt +"div:"+div+"  compartresult:"+compareResult);
			  if(!compareStatus){
				  // Error message EL0039
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0039"), ""));
					//reCalculatePaymentDetailConclution();			
					doRecalCulateVATELTemp();
					paymentDetail.setVatAmt(previousVatAmt);
			  }else{
				  excludeVatAmt = includeVatAmt.subtract(currentvatAmt);
				  paymentDetail.setExcludeVatAmt(excludeVatAmt);
				  paymentDetail.setVatAmt(currentvatAmt);
				  semmel006Bean.setPreviosVatAmt(currentvatAmt);
			  }
		} 
	}	
	
	
	
	public void reCalculatePaymentDetailConclution( ){	
		logger.debug("reCalculatePaymentDetailConclution ");
		semmel006Bean = getSemmel006Bean();	 
		PaymentDetail paymentDetail = semmel006Bean.getPaymentDetail();		
		
		BigDecimal excludeVatAmt = new BigDecimal(0);
		BigDecimal inCludeVatCalculateAmt = new BigDecimal(0);
		BigDecimal vatAmt = new BigDecimal(0);
		BigDecimal includeVatAmt = new BigDecimal(0);
		BigDecimal chqAmt = new BigDecimal(0);
		BigDecimal payAmt = new BigDecimal(0);
		

		 
		excludeVatAmt = excludeVatAmt.add(paymentDetail.getExcludeVatAmt()==null?new BigDecimal(0):paymentDetail.getExcludeVatAmt());
		vatAmt = vatAmt.add(paymentDetail.getVatAmt()==null?new BigDecimal(0):paymentDetail.getVatAmt());
		includeVatAmt = includeVatAmt.add(paymentDetail.getIncludeVatAmt()==null?new BigDecimal(0):paymentDetail.getIncludeVatAmt());
		chqAmt = chqAmt.add(paymentDetail.getChqAmt()==null?new BigDecimal(0):paymentDetail.getChqAmt());
		payAmt = payAmt.add(paymentDetail.getPayAmt()==null?new BigDecimal(0):paymentDetail.getPayAmt());

		if(excludeVatAmt.intValue()!=0){
			
		//	BigDecimal sevenAmtVat = ELUtils.getAmtPercent(excludeVatAmt, new BigDecimal(7));
			BigDecimal sevenAmtVat =   ELUtils.getSevenVAtAmtFromOriginalPrice(excludeVatAmt);
			inCludeVatCalculateAmt = excludeVatAmt.add(sevenAmtVat);

			logger.debug(" excludeVatAmt:"+excludeVatAmt);
			logger.debug(" sevenAmtVat:"+sevenAmtVat);
			logger.debug(" inCludeVatCalculateAmt:"+inCludeVatCalculateAmt);

			paymentDetail.setExcludeVatAmt(excludeVatAmt);
			paymentDetail.setVatAmt(sevenAmtVat);
			paymentDetail.setIncludeVatAmt(inCludeVatCalculateAmt);
			paymentDetail.setChqAmt(inCludeVatCalculateAmt);
			/*
			paymentDetail.setIncludeVatAmt(excludeVatAmt.add(sevenAmtVat));
			paymentDetail.setVatAmt(sevenAmtVat);
			paymentDetail.setExcludeVatAmt(excludeVatAmt);
			paymentDetail.setChqAmt(excludeVatAmt.add(sevenAmtVat));
			paymentDetail.setPayAmt(payAmt);		
			*/		
			logger.debug("  PreviosVatAmt:"+sevenAmtVat);
			semmel006Bean.setPreviosVatAmt(sevenAmtVat);

			
		}	else{
			paymentDetail.setIncludeVatAmt(new BigDecimal(0));
			paymentDetail.setVatAmt(new BigDecimal(0));
			paymentDetail.setExcludeVatAmt(new BigDecimal(0));
			paymentDetail.setChqAmt(new BigDecimal(0));
			paymentDetail.setPayAmt(new BigDecimal(0));
			semmel006Bean.setPreviosVatAmt(new BigDecimal(0));
		}

 
	}
	
	public boolean initDeleteELTmpFromModel(){
		boolean flag = false;		
		try{
			semmel006Bean = getSemmel006Bean();	  
			String deleteRowIndex = (String)getFacesUtils().getRequestParameter("deleteRowIndex");
			//semmel006BeanInteger.parseInt(deleteRowId));
			logger.debug(" -- initDeleteELTmpFromModel  deleteRowIndex :"+ deleteRowIndex);			
		}catch(Exception ex){
			ex.printStackTrace();
		}

		return flag;
	}
	
	private boolean doDeleteELTmpFromModel() {
		logger.debug(" -- doDeleteELTmpFromModel--");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();			
			//int paymentIdDelete = semmel006Bean.getDeletePaymentId();
			String paymentIdDelete = (String)getFacesUtils().getRequestParameter("deletePaymentId");
			List paymentTmpList = semmel006Bean.getPaymentDetailList();
			logger.debug(" paymentIdDelete for delete :"+paymentIdDelete);
			semmel006Bean.setPaymentDetailList(removePaymentByRowId(paymentTmpList,Integer.parseInt(paymentIdDelete)));		
				
		}catch(Exception ex){
			ex.printStackTrace();
		}	
		return flagValid;
	}		
	
	private boolean doUpdateELTmp (){
		logger.debug(" -- doUpdateELTmp--");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	     	
			//logger.debug(" doUpdateELTmp To Save payment :"+BeanUtils.getBeanString(semmel006Bean.getPayment()));
			//logger.debug(" doUpdateELTmp To Save paymentDetail :"+BeanUtils.getBeanString(semmel006Bean.getPaymentDetail()));
			
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return flagValid;
	}
	private boolean doClearPaymentDetailELTemp() {
		logger.debug(" -- doClearPaymentDetailELTemp--");
		boolean flagValid = false;		
		try{

			semmel006Bean = getSemmel006Bean();			
			String whtType = semmel006Bean.getPaymentDetail().getWhtType();//WT###Add 20110131
			if(semmel006Bean.getPaymentDetailList()==null||semmel006Bean.getPaymentDetailList().size()<=0){
			 // Clear All �к����������ҷ�� �����š���ԡ���� ��� ��������´����ԡ���� � ������ Model ����բ����� (����բ����ŵç���ҧ��¡���ԡ����)
				initialData();
				semmel006Bean.getPaymentDetail().setVatType("01");
				semmel006Bean.getPayment().setPaymentType("01");
				semmel006Bean.getPayment().setVendorType("S");
				semmel006Bean.getPayment().setPaymentMethod(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.CT_PAYMENT_METHOD));//WT###Add 20110207
				Map<String,String> codeMap = new HashMap();
//				codeMap.put(ELUtils.PAYMENT_METHOD_01,ELUtils.PAYMENT_METHOD_01);
//				codeMap.put(ELUtils.PAYMENT_METHOD_02,ELUtils.PAYMENT_METHOD_02);
//				codeMap.put(ELUtils.PAYMENT_METHOD_03,ELUtils.PAYMENT_METHOD_03);
//				codeMap.put(ELUtils.PAYMENT_METHOD_04,ELUtils.PAYMENT_METHOD_04);
//				semmel006Bean.setCtPaymentMethodList(ELUtils.getLOVBtLOVCodeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name), codeMap));
				semmel006Bean.setCtPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name,EX_AND,"CHEQUE",null,null));
				semmel006Bean.getPayment().setExpenseType("EL_TEMP");
				semmel006Bean.setElExpenseTypeList(ELUtils.filterLOVByLOVValue("4", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name)));		
				semmel006Bean.setElDocTypeList(ELUtils.filterLOVByLOVValue("1", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DOC_TYPE.name)));			
				semmel006Bean.getPayment().setExpenseTypeDisplay(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name),ELUtils.EL_TEMP));	
				semmel006Bean.setDisableUpdateModelButton(true);
				semmel006Bean.setDisableAddModelButton(false);
				semmel006Bean.setDisableMoreThanOneDetail(false);					
				semmel006Bean.setViewMode(false);
			}else{				
				// �к�����������੾�� ��������´����ԡ���� � ������ Model �բ����� (�բ����ŵç���ҧ��¡���ԡ�������ҧ���� 1 ��¡��)
				semmel006Bean.setDisableMoreThanOneDetail(true);
				PaymentDetail oldPaymentDetail = semmel006Bean.getPaymentDetail();
				String vatType = oldPaymentDetail.getVatType();
				PaymentDetail newPaymentDetail = new PaymentDetail();
				newPaymentDetail.setVatType(vatType);
				semmel006Bean.setPaymentDetail(newPaymentDetail);
				semmel006Bean.setDisableAddModelButton(false);
				semmel006Bean.setDisableUpdateModelButton(true);
			}		
			//WT###Add 20110119 Start
			semmel006Bean.setMeterIdDisable(false);
			semmel006Bean.setDisableFromTermOfPaymentDt(false);
			semmel006Bean.setDisableToTermOfPaymentDt(false);
			//WT###Add 20110119 End
			semmel006Bean.getPaymentDetail().setWhtType(whtType);//WT###Add 20110131



		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return flagValid;
	}	
	
	private boolean doClearELTmp() {
		logger.debug(" -- doClearELTmp--");
		boolean flagValid = false;		
		try{
			initPaymentELTmp();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return flagValid;
	}			
	private boolean doSaveELTmp(){
		logger.info("START Action doSaveELTmp");
		boolean flagValid = false;			
		try{		
			semmel006Bean = getSemmel006Bean();
			if (validatedoSaveELTmp()) {
				getSemmel006Bean().setRenderedMsgFormSearch(true);
				return flagValid;
			}	
			if (getSemmel006Bean().getPaymentDetailList()==null||getSemmel006Bean().getPaymentDetailList().size()<=0) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.paymentDetailSize")));
				getSemmel006Bean().setRenderedMsgFormSearch(true);
				flagValid = true;
			}else{
				//semmel006Bean = getSemmel006Bean();	 
				Payment paymentSave = semmel006Bean.getPayment();
				String electricIdStr = semmel006Bean.getPopupSiteCriteria().getElectricId();
				String siteInfo = semmel006Bean.getPopupSiteCriteria().getSiteInfoId();
				String siteType = semmel006Bean.getPopupSiteCriteria().getSiteType();
				String region = semmel006Bean.getPopupSiteCriteria().getRegion();
				logger.debug("electricIdStr:"+electricIdStr+"siteInfo:"+siteInfo+" siteType:"+siteType+" region:"+region + " chqAmt:"+paymentSave.getChqAmt());
				
				Management electricId = new Management();				
				electricId.setRowId(electricIdStr);
				paymentSave.setElectricId(electricId);
				paymentSave.setExpenseType(ELUtils.EL_TEMP);			
				paymentSave.setRecordStatus("Y");
				paymentSave.setVersion(new BigDecimal(1));
				paymentSave.setSiteInfoId(siteInfo);
				paymentSave.setSiteType(siteType);
				paymentSave.setRegion(region);
				
				paymentSave.setPaymentStatus("01");
				//WT###Edit 20110120 Start
				//paymentSave.setVatType("01");
				paymentSave.setVatType(semmel006Bean.getPaymentDetail().getVatType());
				paymentSave.setWhtAmt(null);
				//WT###Edit 20110120 End
				paymentSave.setVatRate(new BigDecimal(7));
				List<PaymentDetail> detailList = semmel006Bean.getPaymentDetailList();
				for(PaymentDetail detailtmp:detailList){
					//WT###Edit 20110120 Start
					//detailtmp.setVatType("01");
					detailtmp.setVatType(semmel006Bean.getPaymentDetail().getVatType());
					detailtmp.setWhtAmt(null);
					//WT###Edit 20110120 End
					detailtmp.setVatRate(new BigDecimal(7));
					detailtmp.setExpenseType(ELUtils.EL_TEMP);
					detailtmp.setRecordStatus("Y");
				}				
				
				
				logger.debug(" Detail List :"+detailList.size());			
				IPaymentService service = (IPaymentService)getBean("paymentService");	
				//WT###Edit 20110118 Start
				if(semmel006Bean.isComeFromOtherPage()){
					detailList.addAll(semmel006Bean.getDeletedPaymentDetailList());
					
					//-----------update by new 13/10/2014--------------------
					for(int i=detailList.size()-1;i>-1;i--){
					
						PaymentDetail paymentDet = detailList.get(i);
						if(paymentDet.isDeleted()){
							
						//	paymentDetailDao.delete(paymentDet);
							detailList.remove(i);
						}
					}
					//-----------------------------------
					
					logger.info("START Service updatePaymentPage6");
					service.updatePaymentPage6(paymentSave,detailList);
					logger.info("END Service updatePaymentPage6");
					semmel006Bean.setDeletedPaymentDetailList(new ArrayList<PaymentDetail>(0));
				}else{
					//EARN
					paymentSave = service.mergePayment(paymentSave,detailList);
					//ParameterConfig paramPLName1 = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_PAYMENT_E001");
					//ParameterConfig paramPLName2 = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_PAYMENT_E002");
					//logger.debug(" paramPLName1 :"+paramPLName1 +" paramPLName2:"+paramPLName2);
					//boolean saveResult = service.savePaymentELPostpaid(paymentSave, detailList, paramPLName1.getParamValue(), paramPLName2.getParamValue());
					//EARN
					logger.debug(" doSaveELPostpaid Result xx :" + StringUtils.isNotBlank(paymentSave.getRowId()));
				}
				
				ParameterConfig paramPLName = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_PAYMENT_P002");
				if(semmel006Bean.isComeFromOtherPage()){
					logger.info("START Service updatePaymentPRPospaidAndDelPaymentDetail");
					detailList.addAll(semmel006Bean.getDeletedPaymentDetailList());
					service.updatePaymentPRPospaidAndDelPaymentDetail(paymentSave, detailList, paramPLName.getParamValue());					
					logger.info("END Service updatePaymentPRPospaidAndDelPaymentDetail");
					semmel006Bean.setDeletedPaymentDetailList(new ArrayList<PaymentDetail>(0));
				}else{									
					service.savePaymentPRPospaid (paymentSave, detailList,   paramPLName.getParamValue());
				}
				
				
				//WT###Edit 20110118 End		
				
				/// edit
				/*IManagementService manageService = (IManagementService)getBean("managementService");
				
				
				ELVerifyCondSP verCri = new ELVerifyCondSP();
				verCri.setElectricId(semmel006Bean.getPopupSiteCriteria().getElectricId());
				verCri.setPaymentId("7A1FC307938D24B5E050D00AAA9876E2");
				manageService.querySPList(EQueryName.SP_MEL006_SP_ADJUST_PRIVATE.name,verCri);*/
				
				logger.debug(" Detail List :"+detailList.size());			
				//logger.debug("WT### paymentSave="+BeanUtils.getBeanString(paymentSave));
				//IPaymentService service = (IPaymentService)getBean("paymentService");
				
				
							
				addMessageInfo("M0001");
				initPaymentELTmp();
			}

			//WT###Add 20110202 Start
			semmel006Bean.setDisableViewExpenseHisButton(true);
			semmel006Bean.setDisableViewMeterInfoButton(true);
			//WT###End 20110202 End
			semmel006Bean.setDisableVendorTypeButton(true);//WT###Add 20110203
			
			logger.info("END Action doSaveELTmp");
		} catch (Exception e) {
			semmel006Bean.setRenderedMsgFormSearch(true);
			logger.error("ERROR Action doSaveELTmp");
			addMessageError(ELUtils.E0001);
			e.printStackTrace();
		}
		return flagValid;
	}		
	

	public boolean doChangeVATTypeELTemp(){		
		logger.debug(" -- doChangeVATTypeELTemp--");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			PaymentDetail paymentDetail = semmel006Bean.getPaymentDetail();			
			String vatType = paymentDetail.getVatType();
			
			if("01".equals(vatType)){
							
				semmel006Bean.setVatAmtDisable(false);

			}else if("02".equals(vatType)){
	
				semmel006Bean.setVatAmtDisable(true);
			
			 
			}else if("03".equals(vatType)){//WT###20110128
				semmel006Bean.setVatAmtDisable(true);
			}
			doRecalCulateVATPR();
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return flagValid;			
	}	
	
	//WT###Add 20110204 Start
	public boolean doChangeVATTypeELTempPage62(){		
		logger.info("Start Action doChangeVATTypeELTempPage62");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			Payment payment = semmel006Bean.getPayment();			
			String vatType = payment.getVatType();
			doRecalCulateVATPR62();
			logger.info("END Action doChangeVATTypeELTempPage62");
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return flagValid;			
	}
	//WT###Add 20110204 End
	
	public boolean doChangeVATTypeELTempPage63(){		
		logger.info("START Action doChangeVATTypeELTempPage63");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			PaymentDetail paymentDetail = semmel006Bean.getPaymentDetail();			
			String vatType = paymentDetail.getVatType();
			if("03".equals(vatType)){//WT###20110128
				semmel006Bean.setVatAmtDisable(true);
			}
			doRecalCulateVATPR();
			logger.info("END Action doChangeVATTypeELTempPage63");
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return flagValid;			
	}	
	
	
	
	private boolean doSavePRPostpaid5(){
		logger.debug(" -- doSavePRPostpaid 6-5 --");
		boolean flagValid = false;			
		try{		

			if (getSemmel006Bean().getPaymentDetailList()==null||getSemmel006Bean().getPaymentDetailList().size()<=0) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.paymentDetailSize")));
				flagValid = true;
			}else{
				//if (validatedoSaveELPRPospaid()) {
				//validatedoSaveELPRPospaid(); 
				if(validateELPostpaidByExpenseType()||validateTotalAmount()){	
					return flagValid;
				}
				semmel006Bean = getSemmel006Bean();	 					
				String electricIdStr = semmel006Bean.getPopupSiteCriteria().getElectricId();
				//WT###Edit 20110118 Start
				//String meterInfoId = semmel006Bean.getPopupSiteCriteria().getMeterInfoId()==null?"":semmel006Bean.getPopupSiteCriteria().getMeterInfoId();
				String meterInfoId = semmel006Bean.getMeterInfo().getRowId()==null?"":semmel006Bean.getMeterInfo().getRowId();
				//WT###Edit 20110118 End
				//logger.debug("electricIdStr:"+electricIdStr +" meterInfoId:"+meterInfoId );
				//logger.debug("electricIdStr:"+electricIdStr +" getReferMeterId:"+semmel006Bean.getMeterInfo().getReferMeterId());
				//logger.debug("Payment Ch"+semmel006Bean.getPopupSiteCriteria().getpa);
				Payment paymentSave = semmel006Bean.getPayment();
				Management electricId = new Management();
				electricId.setRowId(electricIdStr);
				paymentSave.setElectricId(electricId);
				paymentSave.setSiteInfoId(semmel006Bean.getPopupSiteCriteria().getSiteInfoId());
				paymentSave.setSiteType(semmel006Bean.getPopupSiteCriteria().getSiteType());
				paymentSave.setRegion(semmel006Bean.getPopupSiteCriteria().getRegion());	
				paymentSave.setVersion(new BigDecimal(1));
				//paymentSave.setDocType(paymentSave.getRefDocType());	
				//paymentSave.setRefDocType(paymentSave.getRefDocType());	
				paymentSave.setPaymentStatus("01");
				//WT###Add Start 20110120 Start
				//paymentSave.setVatType("01");
				paymentSave.setVatType(null);
				//WT###Add Start 20110120 End
				paymentSave.setRecordStatus("Y");
				paymentSave.setVersion(new BigDecimal(1));
				paymentSave.setVatRate(new BigDecimal(7));
				
				if(semmel006Bean.getPopupSiteCriteria().getPayment_channel() != null){
					if(paymentSave.getPayment_channel() != null){
						paymentSave.setPayment_channel(semmel006Bean.getPopupSiteCriteria().getPayment_channel());
					}
					
				}
				
				List<PaymentDetail> detailList = semmel006Bean.getPaymentDetailList();
				//List<PaymentDetail> detailListValidate = semmel006Bean.getPaymentDetailList();
				boolean duplicateTermOfPayment = false;
				
				for(PaymentDetail detailtmp:detailList){					
					//WT###Comment detailtmp.setVatType("01");
					detailtmp.setVatRate(new BigDecimal(7));
					detailtmp.setExpenseType(paymentSave.getExpenseType());
					//WT###Edit 20110118 Start
					//detailtmp.setReferMeterId(semmel006Bean.getPopupSiteCriteria().getReferMeterId());
					//detailtmp.setReferMeterId(semmel006Bean.getMeterInfo().getReferMeterId());
					//WT###Edit 20110118 End
					detailtmp.setRecordStatus("Y");
					detailtmp.setInvTermOfPaymentDt(null);
					//WT###Comment 20110118detailtmp.setMeterInfoId(meterInfoId);		
					String meterIdTmp = detailtmp.getMeterId()==null?"":detailtmp.getMeterId();
					detailtmp.setDetailFlag("Y");
					detailtmp.setMeterId(meterIdTmp);
					detailtmp.setInvMeterId("");	
//					System.out.println(" paymentDetail Save 5:"+BeanUtils.getBeanString(detailtmp));
					/*
					for(PaymentDetail detailtmpValidate:detailListValidate){
						logger.debug(" Main Meter :"+detailtmp.getMeterInfoId());
						logger.debug(" Val Meter :"+detailtmpValidate.getMeterInfoId());
						logger.debug(" Main TermofPayment :"+detailtmp.getInvTermOfPaymentDt());
						logger.debug(" Val TermofPayment :"+detailtmpValidate.getInvTermOfPaymentDt());
						if(detailtmpValidate.getInvTermOfPaymentDt().compareTo(detailtmp.getInvTermOfPaymentDt())==0 
						 && (detailtmpValidate.getMeterInfoId().equalsIgnoreCase(detailtmp.getMeterInfoId())))
						{
							FrontMessageUtils.addMessageError( elmsg("message.addDuplicateTermofPayment"));
							return flagValid;
							
						}
						
					}*/
					
				}						
				
				
				
				logger.debug(" Detail List :"+detailList.size());			
				//logger.debug("WT### paymentSave="+BeanUtils.getBeanString(paymentSave));
				IPaymentService service = (IPaymentService)getBean("paymentService");
				ParameterConfig paramPLName = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_PAYMENT_P002");
				if(semmel006Bean.isComeFromOtherPage()){
					logger.info("START Service updatePaymentPRPospaidAndDelPaymentDetail");
					detailList.addAll(semmel006Bean.getDeletedPaymentDetailList());
					service.updatePaymentPRPospaidAndDelPaymentDetail(paymentSave, detailList, paramPLName.getParamValue());					
					logger.info("END Service updatePaymentPRPospaidAndDelPaymentDetail");
					semmel006Bean.setDeletedPaymentDetailList(new ArrayList<PaymentDetail>(0));
				}else{									
					service.savePaymentPRPospaid (paymentSave, detailList,   paramPLName.getParamValue());
				}
				addMessageInfo("M0001");
				initPaymentPRPostpaid();
				
				//WT###Add 20110202 Start
				semmel006Bean.setDisableViewExpenseHisButton(true);
				semmel006Bean.setDisableViewMeterInfoButton(true);
				//WT###End 20110202 End
			}

		} catch (Exception e) {
			addMessageError(ELUtils.E0001);
			e.printStackTrace();
		}
		return flagValid;
	}	
	private boolean doSavePRPrepaid6(){
		logger.debug(" -- doSavePRPrepaid 6--");
		boolean flagValid = false;			
		try{		
			if (validatedoSaveELPRPrepaid()) {
				return flagValid;
			}
			if (getSemmel006Bean().getPaymentDetailList()==null||getSemmel006Bean().getPaymentDetailList().size()<=0) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.paymentDetailSize")));
				flagValid = true;
			}else{
				semmel006Bean = getSemmel006Bean();	 		
				
				SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
				List <PrivatePrepaid > installmentList =  semmel006Bean.getPrivatePrepaidResult();	
				List <PrivatePrepaid > installmentUpdateList = new ArrayList();
				if(installmentList!=null && installmentList.size()>0){//WT###Add 20110118
					for(PrivatePrepaid  tmp:installmentList){	
						if (tmp.isSelected()) {
							tmp.setPaidFlag("Y");
							tmp.setUpdateBy(ssoBean.getUserName());
							tmp.setUpdateDt(Calendar.getInstance().getTime());
							installmentUpdateList.add(tmp);
						}
					}
				}
					
				String electricIdStr = semmel006Bean.getPopupSiteCriteria().getElectricId();				
	
				
				Payment paymentSave = semmel006Bean.getPayment();
				Management electricId = new Management();
				electricId.setRowId(electricIdStr);
				paymentSave.setElectricId(electricId);
				paymentSave.setExpenseType(ELUtils.PR_PREPAID);
				paymentSave.setSiteInfoId(semmel006Bean.getPopupSiteCriteria().getSiteInfoId());
				paymentSave.setSiteType(semmel006Bean.getPopupSiteCriteria().getSiteType());
				paymentSave.setRegion(semmel006Bean.getPopupSiteCriteria().getRegion());	
				//paymentSave.setVatAmt(paymentSave.getDbTotalVat());
				//paymentSave.setExcludeVatAmt(paymentSave.getDbTotalExcludeVat());
				//paymentSave.setIncludeVatAmt(paymentSave.getDbTotalIncludeVat());
				paymentSave.setPaymentStatus("01");
				//WT###Comment 20110120 paymentSave.setVatType("01");
				paymentSave.setRecordStatus("Y");
				paymentSave.setVersion(new BigDecimal(1));
				paymentSave.setVatRate(new BigDecimal(7));
				
				logger.debug(" -- semmel006Bean.getPopupSiteCriteria().getPayment_channel() --"+semmel006Bean.getPopupSiteCriteria().getPayment_channel());
				
				if(semmel006Bean.getPopupSiteCriteria().getPayment_channel() != null){
					if(paymentSave.getPayment_channel() != null){
						paymentSave.setPayment_channel(semmel006Bean.getPopupSiteCriteria().getPayment_channel());	
					}
					
				}
				//paymentSave.setChqAmt(paymentSave.getDbTotalIncludeVat());						
				
				List<PaymentDetail> detailList = semmel006Bean.getPaymentDetailList();
				for(PaymentDetail detailtmp:detailList){
					//detailtmp.setMeterId(meterId);
					//detailtmp.setVatType("01");
					detailtmp.setVatRate(new BigDecimal(7));
					detailtmp.setRecordStatus("Y");				
					detailtmp.setExpenseType(ELUtils.PR_PREPAID);
					//detailtmp.setVatAmt(detailtmp.getInvVatAmt());
					//detailtmp.setExcludeVatAmt(detailtmp.getInvExcludeVatAmt());
					//detailtmp.setIncludeVatAmt(detailtmp.getInvIncludeVatAmt());
					//detailtmp.setChqAmt(detailtmp.getInvIncludeVatAmt());
					detailtmp.setMeterId(detailtmp.getInvMeterId());
					detailtmp.setDetailFlag("Y");
					detailtmp.setInvMeterId(detailtmp.getMeterId());						
					detailtmp.setCreateBy(ssoBean.getUserName());
					detailtmp.setCreateDt(Calendar.getInstance().getTime());
					detailtmp.setWhtRate(paymentSave.getWhtRate());//WT###Add 20110120
				}	
				//WT###Add 20110120 Start
				if(null!=detailList && detailList.size()>0){
					paymentSave.setVatType(detailList.get(0).getVatType());
				}
				//WT###Add 20110120 End
				
				
				logger.debug(" Detail List :"+detailList.size());			
				IPaymentService service = (IPaymentService)getBean("paymentService");										
				//WT###Edit 20110118 Start
				ParameterConfig paramPLName = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_PAYMENT_P004");	
				
				logger.info("START service deletePayment");
				detailList.addAll(semmel006Bean.getDeletedPaymentDetailList());
				List<ElVerifySP> rs = new ArrayList<ElVerifySP>();
				for(PaymentDetail detail : detailList){
					 rs = service.querySPList(EQueryName.SP_EL_PAYMENT_DEL.name, detail);
				}
				logger.info("END service deletePayment");
				
				if(semmel006Bean.isComeFromOtherPage()){
					
					
					logger.info("START Service savePaymentPRPrepaidWithDelPaymentDetail");
//					detailList.addAll(semmel006Bean.getDeletedPaymentDetailList());
					//service.savePaymentPRPrepaidWithDelPaymentDetail(paymentSave, detailList, installmentUpdateList, paramPLName.getParamValue());
					service.savePaymentPrepaidWithDelPaymentDetail(paymentSave, detailList, installmentUpdateList, paramPLName.getParamValue());
					logger.info("END Service savePaymentPRPrepaidWithDelPaymentDetail");
					semmel006Bean.setDeletedPaymentDetailList(new ArrayList<PaymentDetail>(0));
					
				}else{
					service.savePaymentPrivatePrepaid(paymentSave, detailList, installmentUpdateList, paramPLName.getParamValue());	
				}
				//WT###Edit 20110118 End							
						
				addMessageInfo("M0001");
				initPaymentPRPrepaid();
				
				if(semmel006Bean.isComeFromPage7()){
					semmel006Bean.setComeFromOtherPage(true);
				}
				
				//WT###Add 20110202 Start
				semmel006Bean.setDisableViewExpenseHisButton(true);
				//WT###End 20110202 End
			}

		} catch (Exception e) {
			addMessageError(ELUtils.E0001);
			e.printStackTrace();
		}
		return flagValid;
	}		
		
	
	
	private boolean validatedoSaveELPRPospaid() {
		boolean flagValid = false;			

		flagValid = validatePayment(ELUtils.PR_POSTPAID);			
		return flagValid;
	}
	
	private boolean validatedoSaveELPRPrepaid() {
		boolean flagValid = false;			

		flagValid = validatePayment(ELUtils.PR_PREPAID);			
		return flagValid;
	}
 
	
	private boolean validatedoSaveELTmp() {
		boolean flagValid = false;			

		flagValid = validatePayment(ELUtils.EL_TEMP);			
		return flagValid;
	}
	
	//  ---------------- PaymentPRPostpaid-------------------------------
	private boolean initPaymentPRPostpaid() {
		logger.debug(" -- initPaymentPRPostpaid  Page 5 ");
		boolean flagValid = false;
		try{
			semmel006Bean = getSemmel006Bean();
			String pageFrom = (String)getFacesUtils().getRequestParameter("navProgram");
			semmel006Bean.setPageFrom(pageFrom);
			initialData();
			Payment payment = semmel006Bean.getPayment();
			//PaymentDetail paymentDetail = semmel006Bean.getPaymentDetail();	
			payment.setPaymentType("01");
			payment.setPaymentMethod(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.CT_PAYMENT_METHOD));
			payment.setExpenseType("PR_POSTPAID");
			payment.setDocType("I");
			if (payment.getCreateDt()!=null){
				payment.setDisplayCreateDate(SEMDataUtility.convertToThYear(payment.getCreateDt()));
			}
			if (payment.getUpdateDt()!=null){
				payment.setDisplayUpdateDate(SEMDataUtility.convertToThYear(payment.getUpdateDt()));
			}
			
			payment.setPaymentMethod(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.CT_PAYMENT_METHOD));//WT###Add 20110207
			semmel006Bean.setElExpenseTypeList(ELUtils.filterLOVByLOVValue("5", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name)));		
			semmel006Bean.setElDocTypeList(ELUtils.filterLOVByLOVValue("5", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DOC_TYPE.name)));		
			payment.setExpenseTypeDisplay(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name), "PR_PREPAID"));		
			PopupSiteSearch popupSiteSearch = new PopupSiteSearch();
			semmel006Bean.setPopupSiteCriteria(popupSiteSearch);
			semmel006Bean.setPaymentDetailList(new ArrayList());
			semmel006Bean.setDisableUpdateModelButton(true);
			semmel006Bean.setDisableAddModelButton(false);
			semmel006Bean.setDisableMoreThanOneDetail(false);
			semmel006Bean.setMeterInfo(new MeterInfo());
			semmel006Bean.setRefDocNoDisable(true);			
			semmel006Bean.setMeterIdList(ELUtils.getEmptyList());
			semmel006Bean.setVendorIdList(getEmptyDropDown());
			semmel006Bean.setWhtRateDisable(true);
			semmel006Bean.setWhtTypeMandatory(false);
			semmel006Bean.getPaymentDetail().setVatType("01");
			semmel006Bean.setWhtTypeDisable(true);
			semmel006Bean.setCtPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name,EX_AND,"CHEQUE",null,null));
			semmel006Bean.setMeterIdDisable(false);
			semmel006Bean.setExpenseTypeDisable(false);
			semmel006Bean.setDocTypeDisable(false);
			semmel006Bean.setDocNoDisable(false);
			semmel006Bean.setDocDtDisable(false);
			
			semmel006Bean.setWhtAmtDisable(true);
			// ***** added by bestnaja *****
			semmel006Bean.setPaymentDetailMeterInfoSection(new PaymentDetail());
			// *****
			changePaymentTypeELPR();
			setSemmel006Bean(semmel006Bean);
			semmel006Bean.setViewMode(false);
			//WT###Add 20110202 Start
			semmel006Bean.setDisableViewExpenseHisButton(true);
			semmel006Bean.setDisableViewMeterInfoButton(true);
			//WT###End 20110202 End
			flagValid= true;			
		}catch(Exception ex){
			ex.printStackTrace();
		}	

		return flagValid;
	}

	//WT###Add 20110201 Start
	private boolean initPaymentPRPrepaidFromPage7(){
		logger.debug(" -- initPaymentPRPrepaid--");	
		boolean flagValid = false;
		try{
			semmel006Bean = getSemmel006Bean();	
			semmel006Bean.setComeFromPage7(true);
			initialData();					
			Payment payment = semmel006Bean.getPayment();	
			payment.setExpenseType(ELUtils.PR_PREPAID);
			payment.setPaymentType("01");
			payment.setPaymentMethod(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.CT_PAYMENT_METHOD));//WT###Add 20110207
			if (payment.getCreateDt()!=null){
				payment.setDisplayCreateDate(SEMDataUtility.convertToThYear(payment.getCreateDt()));
			}
			if (payment.getUpdateDt()!=null){
				payment.setDisplayUpdateDate(SEMDataUtility.convertToThYear(payment.getUpdateDt()));
			}
			//payment.setWhtType("01");
			semmel006Bean.setPaymentDetailList(new ArrayList());
			//semmel006Bean.setElExpenseTypeList(ELUtils.filterLOVByLOVValue("4", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name)));		
			semmel006Bean.setElDocTypeList(ELUtils.filterLOVByLOVValue("4", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DOC_TYPE.name)));			
			PopupSiteSearch popupSiteSearch = new PopupSiteSearch();
			semmel006Bean.setPopupSiteCriteria(popupSiteSearch);			
			payment.setExpenseTypeDisplay(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name), "PR_PREPAID"));
			semmel006Bean.setCtPaymentTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.CT_PAYMENT_TYPE.name));
			semmel006Bean.setDisableUpdateModelButton(true);
			semmel006Bean.setDisableAddModelButton(false);
			semmel006Bean.setDisableMoreThanOneDetail(false);
			semmel006Bean.setMeterInfo(new MeterInfo());
			semmel006Bean.setRefDocNoDisable(true);
			semmel006Bean.setWhtRateDisable(true);
			semmel006Bean.setWhtTypeMandatory(false);	
			semmel006Bean.setWhtTypeDisable(true);
			semmel006Bean.setWhtAmtDisable(true);
			// new
			payment.setDocType("C");
		
			changePaymentTypeELPR();
			
			setSemmel006Bean(semmel006Bean);
			semmel006Bean.setViewMode(false);
			flagValid= true;			
		}catch(Exception ex){
			ex.printStackTrace();
		}

		return flagValid;		
	}
	//WT###Add 20110201 End
	//  ---------------- Start PR_Prepaid-------------------------------
	private boolean initPaymentPRPrepaid() {
		logger.debug(" -- initPaymentPRPrepaid--Page 6-6");	
		boolean flagValid = false;
		try{
			semmel006Bean = getSemmel006Bean();	
			String pageFrom = (String)getFacesUtils().getRequestParameter("navProgram");
			semmel006Bean.setPageFrom(pageFrom);
			initialData();					
			Payment payment = semmel006Bean.getPayment();	
			payment.setExpenseType(ELUtils.PR_PREPAID);
			payment.setPaymentType("01");
			payment.setPaymentMethod(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.CT_PAYMENT_METHOD));//WT###Add 20110207
		
			//payment.setWhtType("01");
			semmel006Bean.setPaymentDetailList(new ArrayList());
			semmel006Bean.setPrivatePrepaidResult(new ArrayList());
			//semmel006Bean.setElExpenseTypeList(ELUtils.filterLOVByLOVValue("4", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name)));		
			semmel006Bean.setElDocTypeList(ELUtils.filterLOVByLOVValue("4", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DOC_TYPE.name)));			
			PopupSiteSearch popupSiteSearch = new PopupSiteSearch();
			semmel006Bean.setPopupSiteCriteria(popupSiteSearch);			
			payment.setExpenseTypeDisplay(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name), "PR_PREPAID"));
			semmel006Bean.setCtPaymentTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.CT_PAYMENT_TYPE.name));
			semmel006Bean.setDisableUpdateModelButton(true);
			semmel006Bean.setDisableAddModelButton(false);
			semmel006Bean.setDisableMoreThanOneDetail(false);
			semmel006Bean.setMeterInfo(new MeterInfo());
			semmel006Bean.setRefDocNoDisable(true);
			semmel006Bean.setWhtRateDisable(true);
			semmel006Bean.setWhtTypeMandatory(false);	
			semmel006Bean.setWhtTypeDisable(true);
			semmel006Bean.setWhtAmtDisable(true);
			semmel006Bean.setVendorIdList(getEmptyDropDown());
			semmel006Bean.setCtPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name,EX_AND,"CHEQUE",null,null));
			// new
			payment.setDocType("C");
		
			changePaymentTypeELPR();
			
			if(StringUtils.equals(pageFrom, "SEMMEL006-6")){
				semmel006Bean.setComeFromOtherPage(false);
			}else{
				semmel006Bean.setComeFromOtherPage(true);
			}
			
			setSemmel006Bean(semmel006Bean);
			semmel006Bean.setViewMode(false);
			flagValid= true;		
			
			//WT###Add 20110202 Start
			semmel006Bean.setDisableViewExpenseHisButton(true);
			
			logger.debug(" -- END PaymentPRPrepaid--Page 6-6");	
			//WT###End 20110202 End
		}catch(Exception ex){
			ex.printStackTrace();
		}

		return flagValid;		
	}
	
	


	private boolean initPopupSearchSitePRPrepaid() {
		boolean flag = false;
		logger.debug(" -- initPopupSearchSitePRPrepaid--");
		try{
			semmel006Bean = getSemmel006Bean();
			PopupSiteSearch popupSiteCriteria = new PopupSiteSearch();
			semmel006Bean.setPopupSiteCriteria(popupSiteCriteria);
			semmel006Bean.setPopupSiteList(new ArrayList());	
			semmel006Bean.setSavePopupSiteDisable(true);		
			semmel006Bean.setSelectedRadio(null);	
			semmel006Bean.setVendorIdList(getEmptyDropDown());
		}catch(Exception ex){
			ex.printStackTrace();
		}

		return flag;
	}
	
	private boolean initPopupSearchSitePR() {
		boolean flag = false;
		logger.debug(" -- initPopupSearchSitePR--");
		try{
			semmel006Bean = getSemmel006Bean();
			initPaymentPRPostpaid();
			PopupSiteSearch popupSiteCriteria = new PopupSiteSearch();
			semmel006Bean.setPopupSiteCriteria(popupSiteCriteria);
			semmel006Bean.setPopupSiteList(new ArrayList());	
			semmel006Bean.setSavePopupSiteDisable(true);		
			semmel006Bean.setSelectedRadio(null);		
			semmel006Bean.setVendorIdList(getEmptyDropDown());
		}catch(Exception ex){
			ex.printStackTrace();
		}

		return flag;
	}
		
	
	private boolean initPopupSearchInstallment() {
		boolean flag = false;
		
		try{
			semmel006Bean = getSemmel006Bean();
			semmel006Bean.setInstallmentSearchResult(new ArrayList());
			if (validatedoSaveELPRPrepaid()) {
				return flag;
			}
			String contractNo = semmel006Bean.getPopupSiteCriteria().getContractNo();
			logger.debug(" -- initPopupSearchInstallment contractNo:"+contractNo);
			if(contractNo!=null){
				IMeterInstallmentService meterInfoService = (IMeterInstallmentService)getBean("meterInstallmentService");			 
				//MeterInstallment criteria = new MeterInstallment();
				PrivatePrepaid  criteria = new PrivatePrepaid ();	
				criteria.setContractNo(contractNo);
				criteria.setRecordStatus("Y");
				criteria.setPaidFlag("N");
				criteria.setElectricUseType("PRIVATE");
				criteria.setPrepaidFlag("Y");
				
				logger.debug(" Try to get MeterInstallment contractNo:"+contractNo+ "  Record Status = Y and paidFlag =N ");
				logger.debug("PrivatePrepaid:2");
				List <PrivatePrepaid> result = meterInfoService.queryByCritiriaPrivatePrepaid(criteria);	
				
				List <PaymentDetail>  gridMeterInfoList = semmel006Bean.getPaymentDetailList();	
				if(result!=null&&result.size()>0){
					//
					
					for(PrivatePrepaid tmp:result){
						String searchRowId = tmp.getRowId();						
						if(gridMeterInfoList!=null){
							//logger.debug(" Found old grid meterinstallment list size:"+gridMeterInfoList.size());
							
								//logger.debug(" Found old grid meterinstallment list size:"+gridMeterInfoList.size());
							for(PaymentDetail gridTmp:gridMeterInfoList){								
								String gridRowId = gridTmp.getInstallmentrowId();
								//logger.debug(" searchRowId:gridRowId>> "+searchRowId+":"+gridRowId);
								if(searchRowId.equals(gridRowId)){
									tmp.setSelected(true);
									tmp.setPaidFlag("Y");									
								}
							}
							
						}
						//logger.debug("PrivatePrepaid:"+BeanUtils.getBeanString(tmp));
					}
					semmel006Bean.setPrivatePrepaidResult(result);
				}else{
					semmel006Bean.setInstallmentSearchResult(new ArrayList());
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("M0004"), ""));
				}					
				if (result != null && !result.isEmpty()) {
					String firstRowId = result.get(0).getRowId();
					semmel006Bean.setSelectedRadio(firstRowId);	
				}				
			}else{
				semmel006Bean.setInstallmentSearchResult(new ArrayList());
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("M0004"), ""));				
			}	
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flag;
	}
	//WT###Add 20110202 Start
	private boolean validatePopupSiteSearchPrepaid(){
		boolean flag = false;
		semmel006Bean = getSemmel006Bean();
		PopupSiteSearch popupSiteSearch = semmel006Bean.getPopupSiteCriteria();
		if (StringUtils.isEmpty(popupSiteSearch.getCompany()) && StringUtils.isEmpty(popupSiteSearch.getContractNo())
			&& StringUtils.isEmpty(popupSiteSearch.getVendorName()) && StringUtils.isEmpty(popupSiteSearch.getVendorAddress())
			&& StringUtils.isEmpty(popupSiteSearch.getPayeeName()) && StringUtils.isEmpty(popupSiteSearch.getPayeeAddress())
			&& StringUtils.isEmpty(popupSiteSearch.getRegion()) && StringUtils.isEmpty(popupSiteSearch.getVendorId())) {
			
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("W0004");
			FrontMessageUtils.addMessageError(errorMsg);
			
			flag = true;
		}
		
		return flag;
	}
	
	private boolean validatePopupSiteSearchPostpaid(){
		boolean flag = false;
		semmel006Bean = getSemmel006Bean();
		PopupSiteSearch popupSiteSearch = semmel006Bean.getPopupSiteCriteria();
		if (StringUtils.isEmpty(popupSiteSearch.getCompany()) && StringUtils.isEmpty(popupSiteSearch.getContractNo())
			&& StringUtils.isEmpty(popupSiteSearch.getVendorName()) && StringUtils.isEmpty(popupSiteSearch.getVendorAddress())
			&& StringUtils.isEmpty(popupSiteSearch.getPayeeName()) && StringUtils.isEmpty(popupSiteSearch.getPayeeAddress())
			&& StringUtils.isEmpty(popupSiteSearch.getRegion()) && StringUtils.isEmpty(popupSiteSearch.getVendorId())
			&& StringUtils.isEmpty(popupSiteSearch.getpRead()) && StringUtils.isEmpty(popupSiteSearch.getMeterID())
		   ) {
			
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("W0004");
			FrontMessageUtils.addMessageError(errorMsg);
			
			flag = true;
		}
		
		return flag;
	}
	
	public boolean doSearchSitePRPrepaidByPL(){
		logger.info("START Action doSearchSitePRPrepaidByPL");
		boolean flag = false;
		try {
			
			if(validatePopupSiteSearchPrepaid()){
				return flag;
			}
			
			semmel006Bean = getSemmel006Bean();
			semmel006Bean.setSavePopupSiteDisable(true);
			List<PopupSiteSearch> popupSiteResultList = new ArrayList();			
			logger.debug(" -- doSearchSiteELPostpaid :"+semmel006Bean.getPopupSiteCriteria().getRecordStatus());		

			if("All".equals(semmel006Bean.getPopupSiteCriteria().getRecordStatus())){
				semmel006Bean.getPopupSiteCriteria().setRecordStatus(null);
			}
			
			IManagementService managementService = (IManagementService)getBean("managementService");
			logger.info("START Service managementService.queryManagementByContractNo06PrepaidByPL");
			List<PopupSiteSearchPrivate>  popupSiteList = managementService.queryManagementByContractNo06PrepaidByPL(semmel006Bean.getPopupSiteCriteria());
			logger.info("END Service managementService.queryManagementByContractNo06PrepaidByPL");
			if(popupSiteList!=null&&popupSiteList.size()>0){
				int rowNumber =1;
				for(PopupSiteSearchPrivate tmp: popupSiteList){
					PopupSiteSearch popupSearch = new PopupSiteSearch();

					popupSearch.setRowNumber(""+rowNumber++);
					popupSearch.setElectricId(tmp.getElectricId());					
					popupSearch.setContractNo(tmp.getContractNo());					
					popupSearch.setCompany(tmp.getCompany());
					popupSearch.setOldContractNo(tmp.getOldContractNo());
					popupSearch.setElectricUseType(tmp.getElectricUseType());
					popupSearch.setRecordStatus(tmp.getRecordStatus());
					popupSearch.setContractStartDt(tmp.getContractStartDt());
					popupSearch.setContractEndDt(tmp.getContractEndDt());
					popupSearch.setSiteName(tmp.getSiteName());
					popupSearch.setSiteStatus(tmp.getSiteStatus());
					popupSearch.setNetworkStatus(tmp.getNetworkStatus());
					popupSearch.setLocationId(tmp.getLocationId());
					popupSearch.setLocationCode(tmp.getLocationCode());
					popupSearch.setSiteInfoId(tmp.getSiteInfoId());
					popupSearch.setSiteType(tmp.getSiteType());
					popupSearch.setRegion(tmp.getRegion());
					popupSearch.setPayment_channel(tmp.getPayment_channel());
					popupSearch.setVendor(tmp.getVendor());
					popupSearch.setPayee(tmp.getPayee());
					popupSearch.setResult(tmp.getResult());
					popupSearch.setRemark(tmp.getRemark());
					//---------------------------------------------------
					if(tmp.getpPayPeriod()!= null){
					popupSearch.setpPayPeriod(tmp.getpPayPeriod().toString());
					}
					
					//---------------------------------------------------
					popupSearch.setpTakeAllAmount(tmp.getpTakeAllAmount()==null?new BigDecimal(0):tmp.getpTakeAllAmount());
					popupSearch.setpTakeAllPreiodType(tmp.getpTakeAllPeriodType());
					popupSearch.setpVatType(tmp.getpVatType());
					popupSearch.setpPayPeriodType(tmp.getpPayPeriodType());
					
					ELUtils.setPopupSearchsiteDisplayField(popupSearch);
					
					popupSiteResultList.add(popupSearch);
					String firstRowId = popupSiteResultList.get(0).getRowNumber();
					semmel006Bean.setSelectedRadio(firstRowId);	
					semmel006Bean.setPopupSiteList(popupSiteResultList);
					semmel006Bean.setSavePopupSiteDisable(false);
				}
			}else{
				semmel006Bean.setPopupSiteList(new ArrayList());
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("M0004"), ""));
				
			}
			logger.info("END Action doSearchSitePRPrepaidByPL");
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("ERROR Action doSearchSitePRPrepaidByPL : "+e, e);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = errorMsg.replace("{0}", "SEMMEL006");
			FrontMessageUtils.addMessageError(errorMsg);
		}
		return flag;
	}
	//WT###Add 20110202 End
	//WT###Add 20110201 Start
	public boolean doSearchSitePRPostpaidByPL(){
		logger.info("START Action doSearchSitePRPostpaidByPL---Private");
		boolean flag = false;
		try {
			
			if(validatePopupSiteSearchPostpaid()){
				return flag;
			}
			
			semmel006Bean = getSemmel006Bean();
			semmel006Bean.setSavePopupSiteDisable(true);
			List<PopupSiteSearch> popupSiteResultList = new ArrayList();			
			logger.debug(" -- doSearchSiteELPostpaid :"+semmel006Bean.getPopupSiteCriteria().getRecordStatus());		
   
			if("All".equals(semmel006Bean.getPopupSiteCriteria().getRecordStatus())){
				semmel006Bean.getPopupSiteCriteria().setRecordStatus(null);
			}
			
			IManagementService managementService = (IManagementService)getBean("managementService");
			if(semmel006Bean.getPopupSiteCriteria().isPrepaidFlag()){
				semmel006Bean.getPopupSiteCriteria().setPrepaidFlagStr("Y");
			}else{
				semmel006Bean.getPopupSiteCriteria().setPrepaidFlagStr("N");
			}
			List<PopupSiteSearchPrivate>  popupSiteList = managementService.queryManagementByContractNo06ByPL(semmel006Bean.getPopupSiteCriteria());
			if(popupSiteList!=null&&popupSiteList.size()>0){
				int rowNumber =1;
				for(PopupSiteSearchPrivate tmp: popupSiteList){
					PopupSiteSearch popupSearch = new PopupSiteSearch();

					popupSearch.setRowNumber(""+rowNumber++);
					popupSearch.setElectricId(tmp.getElectricId());					
					popupSearch.setContractNo(tmp.getContractNo());					
					popupSearch.setCompany(tmp.getCompany());
					popupSearch.setOldContractNo(tmp.getOldContractNo());
					popupSearch.setElectricUseType(tmp.getElectricUseType());
					popupSearch.setRecordStatus(tmp.getRecordStatus());
					popupSearch.setContractStartDt(tmp.getContractStartDt());
					popupSearch.setContractEndDt(tmp.getContractEndDt());
					popupSearch.setSiteName(tmp.getSiteName());
					popupSearch.setSiteStatus(tmp.getSiteStatus());
					popupSearch.setNetworkStatus(tmp.getNetworkStatus());
					popupSearch.setLocationId(tmp.getLocationId());
					popupSearch.setLocationCode(tmp.getLocationCode());
					popupSearch.setSiteInfoId(tmp.getSiteInfoId());
					popupSearch.setSiteType(tmp.getSiteType());
					popupSearch.setRegion(tmp.getRegion());
					popupSearch.setPayment_channel(tmp.getPayment_channel());
					popupSearch.setVendor(tmp.getVendor());
					popupSearch.setPayee(tmp.getPayee());
					popupSearch.setOwnerGroup(tmp.getOwnerGroup());
					popupSearch.setOwnerGroupName(tmp.getOwnerGroupName());
					
					popupSearch.setResult(tmp.getResult());
					popupSearch.setRemark(tmp.getRemark());
					
					
					//---------------------------------------------------
					if(tmp.getpPayPeriod()!= null){
					popupSearch.setpPayPeriod(tmp.getpPayPeriod().toString());
					}
					
					//---------------------------------------------------
					popupSearch.setpTakeAllAmount(tmp.getpTakeAllAmount()==null?new BigDecimal(0):tmp.getpTakeAllAmount());
					popupSearch.setpTakeAllPreiodType(tmp.getpTakeAllPeriodType());
					popupSearch.setpVatType(tmp.getpVatType());
					popupSearch.setpPayPeriodType(tmp.getpPayPeriodType());
					
					ELUtils.setPopupSearchsiteDisplayField(popupSearch);
					
					popupSiteResultList.add(popupSearch);
					String firstRowId = popupSiteResultList.get(0).getRowNumber();
					semmel006Bean.setSelectedRadio(firstRowId);	
					semmel006Bean.setPopupSiteList(popupSiteResultList);
					semmel006Bean.setSavePopupSiteDisable(false);
				}
			}else{
				semmel006Bean.setPopupSiteList(new ArrayList());
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("M0004"), ""));
				
			}
			logger.info("END Action doSearchSitePRPostpaidByPL");
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("ERROR Action doSearchSitePRPostpaidByPL : "+e, e);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = errorMsg.replace("{0}", "SEMMEL006");
			FrontMessageUtils.addMessageError(errorMsg);
		}
		return flag;
	}
	//WT###Add 20110201 End
	
	public boolean doSearchSitePRPrepaid() {
		logger.debug(" -- doSearchSitePRPrepaid--");
		boolean flag = false;
		try {
			semmel006Bean = getSemmel006Bean();
			semmel006Bean.setSavePopupSiteDisable(true);
			List<PopupSiteSearch> popupSiteResultList = new ArrayList();			
			logger.debug(" -- doSearchSiteELPostpaid :"+semmel006Bean.getPopupSiteCriteria().getRecordStatus());		

			if("All".equals(semmel006Bean.getPopupSiteCriteria().getRecordStatus())){
				semmel006Bean.getPopupSiteCriteria().setRecordStatus(null);
			}
			IManagementService managementService = (IManagementService)getBean("managementService");	
			List<Management>  manageList = managementService.queryManagementByContractNo06(semmel006Bean.getPopupSiteCriteria().getContractNo());
			
			if(manageList!=null&&manageList.size()>0){
				int rowNumber =1;
				for(Management tmp: manageList){
					PopupSiteSearch popupSearch = new PopupSiteSearch();

					popupSearch.setRowNumber(""+rowNumber++);
					popupSearch.setElectricId(tmp.getRowId());					
					popupSearch.setContractNo(tmp.getContractNo());					
					popupSearch.setCompany(tmp.getCompany());
					popupSearch.setOldContractNo(tmp.getOldContractNo());
					popupSearch.setElectricUseType(tmp.getElectricUseType());
					popupSearch.setRecordStatus(tmp.getRecordStatus());
					popupSearch.setContractStartDt(tmp.getContractStartDt());
					popupSearch.setContractEndDt(tmp.getContractEndDt());
					popupSearch.setSiteName(tmp.getSiteName());
					popupSearch.setSiteStatus(tmp.getSiteStatus());
					popupSearch.setNetworkStatus(tmp.getNetworkStatus());
					popupSearch.setLocationId(tmp.getLocationId());
					popupSearch.setLocationCode(tmp.getLocationCode());
					popupSearch.setSiteInfoId(tmp.getSiteInfoId());
					popupSearch.setSiteType(tmp.getSiteType());
					popupSearch.setRegion(tmp.getRegion());
					popupSearch.setPayment_channel(tmp.getPaymentChannel());
                     /*
					semmel006Bean.popupSiteCriteria.pTakeAllAmount
					semmel006Bean.popupSiteCriteria.pTakeAllPreiodType
					semmel006Bean.popupSiteCriteria.pVatType
					semmel006Bean.popupSiteCriteria.pPayPeriodType
					
					*/
					//---------------------------------------------------
					if(tmp.getpPayPeriod()!= null){
					popupSearch.setpPayPeriod(tmp.getpPayPeriod().toString());
					}
					
					//---------------------------------------------------
					popupSearch.setpTakeAllAmount(tmp.getpTakeAllAmount()==null?new BigDecimal(0):new BigDecimal(tmp.getpTakeAllAmount()));
					popupSearch.setpTakeAllPreiodType(tmp.getpTakeAllPeriodType());
					popupSearch.setpVatType(tmp.getpVatType());
					popupSearch.setpPayPeriodType(tmp.getpPayPeriodType());
					
					ELUtils.setPopupSearchsiteDisplayField(popupSearch);
					
					popupSiteResultList.add(popupSearch);
					String firstRowId = popupSiteResultList.get(0).getRowNumber();
					semmel006Bean.setSelectedRadio(firstRowId);	
					semmel006Bean.setPopupSiteList(popupSiteResultList);
					semmel006Bean.setSavePopupSiteDisable(false);
				}
			}else{
				semmel006Bean.setPopupSiteList(new ArrayList());
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("M0004"), ""));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	private boolean doSearchSitePRPrepaid6() {
		logger.debug(" -- doSearchSitePRPrepaid6--");
		boolean flag = false;
		try {
			semmel006Bean = getSemmel006Bean();
			semmel006Bean.setSavePopupSiteDisable(true);
			List<PopupSiteSearch> popupSiteResultList = new ArrayList();			
			logger.debug(" -- doSearchSiteELPostpaid :"+semmel006Bean.getPopupSiteCriteria().getRecordStatus());		

			if("All".equals(semmel006Bean.getPopupSiteCriteria().getRecordStatus())){
				semmel006Bean.getPopupSiteCriteria().setRecordStatus(null);
			}
		 
			IPaymentService service = (IPaymentService)getBean("paymentService");	
			popupSiteResultList= service.searchSite(semmel006Bean.getPopupSiteCriteria(),"querySiteELPrepaid");
			logger.debug(" Result Search :"+popupSiteResultList);					
			if (popupSiteResultList != null && !popupSiteResultList.isEmpty()) {
				String firstRowId = popupSiteResultList.get(0).getRowNumber();
				semmel006Bean.setSelectedRadio(firstRowId);	
				semmel006Bean.setPopupSiteList(popupSiteResultList);
				semmel006Bean.setSavePopupSiteDisable(false);
				/*
				for(PopupSiteSearch tmp:popupSiteResultList){
					logger.debug(" PopupSiteSearch:"+BeanUtils.getBeanString(tmp));
				}*/
			}else{
				semmel006Bean.setPopupSiteList(new ArrayList());
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("M0004"), ""));
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}	
	
	
	private boolean doSearchSitePR() {
		logger.debug(" -- doSearchSitePR--:Privee Search");
		boolean flag = false;
		try {
			semmel006Bean = getSemmel006Bean();
			semmel006Bean.setSavePopupSiteDisable(true);
			List<PopupSiteSearch> popupSiteResultList = null;			
			logger.debug(" -- doSearchSitePR :"+semmel006Bean.getPopupSiteCriteria().getRecordStatus());		

			if("All".equals(semmel006Bean.getPopupSiteCriteria().getRecordStatus())){
				semmel006Bean.getPopupSiteCriteria().setRecordStatus(null);
			}
			
			IPaymentService service = (IPaymentService)getBean("paymentService");	
			popupSiteResultList= service.searchSite(semmel006Bean.getPopupSiteCriteria(),"querySiteELPR");
			logger.debug(" Result Search :"+popupSiteResultList);					
			if (popupSiteResultList != null && !popupSiteResultList.isEmpty()) {
				String firstRowId = popupSiteResultList.get(0).getRowNumber();
				semmel006Bean.setSelectedRadio(firstRowId);	
				semmel006Bean.setPopupSiteList(popupSiteResultList);
				semmel006Bean.setSavePopupSiteDisable(false);
				/*
				for(PopupSiteSearch tmp:popupSiteResultList){
					//logger.debug(" PopupSiteSearch:"+BeanUtils.getBeanString(tmp));
				}*/
				
			}else{
				semmel006Bean.setPopupSiteList(new ArrayList());
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("M0004"), ""));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}	
	
	
	private boolean doClearSearchSitePRPrepaid() {
		logger.debug(" -- doClearSearchSitePRPrepaid--");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();
			PopupSiteSearch popupSiteCriteria = new PopupSiteSearch();
			semmel006Bean.setPopupSiteCriteria(popupSiteCriteria);
			semmel006Bean.setPopupSiteList(new ArrayList());	
			semmel006Bean.setSavePopupSiteDisable(true);			
		}catch(Exception ex){
			ex.printStackTrace();
		}

		return flagValid;
	}	
	
	private boolean doClearSearchSitePR() {
		logger.debug(" -- doClearSearchSitePR--");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();
			PopupSiteSearch popupSiteCriteria = new PopupSiteSearch();
			semmel006Bean.setPopupSiteCriteria(popupSiteCriteria);
			semmel006Bean.setPopupSiteList(new ArrayList());	
			semmel006Bean.setSavePopupSiteDisable(true);			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flagValid;
	}	
	

	public boolean doAddSitePRPrepaid() {
		logger.debug(" --  doAddSitePRPrepaid --");
		boolean flag = false;
		try{
			semmel006Bean = getSemmel006Bean();
			List<PopupSiteSearch> siteList = semmel006Bean.getPopupSiteList();
			logger.debug(" Selected Id:"+semmel006Bean.getSelectedRadio());
			
			if(semmel006Bean.getSelectedRadio()!=null){
				int selectrow = Integer.parseInt(semmel006Bean.getSelectedRadio())-1;
				PopupSiteSearch selectSearchSite = siteList.get(selectrow);
				//logger.debug(" selectSearchSite:"+BeanUtils.getBeanString(selectSearchSite));
//				System.out.println("networkStatus = "+selectSearchSite.getNetworkStatus());
				//networkStatus 05=offService,06=remove
				if(StringUtils.equals("05", selectSearchSite.getNetworkStatus()) || 
						StringUtils.equals("06", selectSearchSite.getNetworkStatus())){
					semmel006Bean.setStyleClassName("ms14red");
				}else{
					semmel006Bean.setStyleClassName("ms7");
				}
				
				if(StringUtils.equals("fail", selectSearchSite.getResult().toLowerCase())){
					FrontMessageUtils.addMessageError(selectSearchSite.getRemark());
				}
				
				semmel006Bean.setPopupSiteCriteria(selectSearchSite);
				Payment payment = new Payment();
				ELUtils.copySearchsiteToPayment(selectSearchSite, payment);
				semmel006Bean.getPayment().setElectricUseType(semmel006Bean.getPopupSiteCriteria().getElectricUseType());
				semmel006Bean.setPayment(payment);
				changeElectricUseType_ELBill();
				
			}else{
				//SEM_CT_MESSAGE Table: MESSAGE_CODE = EL0015)
				//addMessageError("EL0015");
			}
			if (siteList != null && !siteList.isEmpty()) {
				
				/*
					for (PopupSiteSearch site : siteList) {
						System.out.println("compare Management rowId : selectedRadio >>"+management.getRowId()+":"+semmel006Bean.getSelectedRadio());
						if (management.getRowId().equals(semmel006Bean.getSelectedRadio())) {
							//System.out.println("Matching  Management select >"+semmel006Bean.getSelectedRadio()+" :"+BeanUtils.getBeanString(management));
							System.out.println(" MeterInfo  >"+management.getMeterInfos());
							if(management.getMeterInfos()!=null&&management.getMeterInfos().size()>0){
								for(MeterInfo tmpx:management.getMeterInfos()){
									//System.out.println(" MeterInfo :"+BeanUtils.getBeanString(tmpx));
								}
							}
							semmel006Bean.setManagementPopUpCriteria(management);
							Payment payment = new Payment();
							//BeanUtils.copyProperties(site, payment);
							ELUtils.copyPropertyManagementToPayment(management,payment);
							semmel006Bean.setPayment(payment);
							semmel006Bean.getPayment().setElectricUseType(semmel006Bean.getPopupSiteCriteria().getElectricUseType());
							changeElectricUseType_ELBill();
							break;
						}
					}				
*/
			}			
		}catch(Exception ex){
			ex.printStackTrace();
		}

		return flag;
	}	
	
	//WT###Add 20110202 Start
	public boolean doAddSite4PRPrepaid() {
		logger.info("START doAddSite4PRPrepaid");
		boolean flag = false; 
		try{
			semmel006Bean = getSemmel006Bean();
			
			//WT###Add 20110202 Start
			semmel006Bean.setDisableViewExpenseHisButton(false);
			//WT###End 20110202 End
			
			List<PopupSiteSearch> siteList = semmel006Bean.getPopupSiteList();					
			String electricIdSelected = "";
			String contractNoSelected ="";
			String paymentType ="";
			String selectNumber = semmel006Bean.getSelectedRadio();
			
			if(selectNumber!=null){
				for(PopupSiteSearch tmp:siteList){
					if(selectNumber.equalsIgnoreCase(tmp.getRowNumber())){
//						System.out.println("networkStatus = "+tmp.getNetworkStatus());
						//networkStatus 05=offService,06=remove
						if(StringUtils.equals("05", tmp.getNetworkStatus()) || 
								StringUtils.equals("06", tmp.getNetworkStatus())){
							semmel006Bean.setStyleClassName("ms14red");
						}else{
							semmel006Bean.setStyleClassName("ms7");
						}
						
						if(StringUtils.equals("fail", tmp.getResult().toLowerCase())){
							FrontMessageUtils.addMessageError(tmp.getRemark());
						}
						
						//logger.debug(" PopupSiteSearch tmp:"+BeanUtils.getBeanString(tmp));
						semmel006Bean.setPopupSiteCriteria(tmp);
						electricIdSelected =  tmp.getElectricId();
						contractNoSelected = tmp.getContractNo();
						Payment payment = semmel006Bean.getPayment();
						ELUtils.copySearchsiteToPayment(tmp, payment);
						ELUtils.setPamentDisplayField(payment);
						semmel006Bean.getPayment().setElectricUseType(semmel006Bean.getPopupSiteCriteria().getElectricUseType());
						semmel006Bean.setPayment(payment);						
						changeElectricUseType_ELBill();
					    
						logger.debug(" --  electricIdSelected:"+electricIdSelected);
						logger.debug(" --  tmp.getpPayPeriodType()"+ tmp.getpPayPeriodType());
						logger.debug(" --  tmp.getpPayPeriod03():1"+ tmp.getpPayPeriod03());
						logger.debug(" --  tmp.getpPayPeriod04():1"+ tmp.getpPayPeriod04());
						logger.debug(" --  tmp.getpPayPeriod()"  + tmp.getpPayPeriod());
						
						logger.debug(" --------------------------------------");
						if(tmp.getpPayPeriodType()!=null){
							if(tmp.getpPayPeriodType().equalsIgnoreCase("03")){
								tmp.setpPayPeriod03(tmp.getpPayPeriod());
						    }else if(tmp.getpPayPeriodType().equalsIgnoreCase("04")){
						    	tmp.setpPayPeriod04(tmp.getpPayPeriod());
						    	
						    }
						}
						logger.debug(" --  tmp.getpPayPeriod03():2"+ tmp.getpPayPeriod03());
						logger.debug(" --  tmp.getpPayPeriod04():2"+ tmp.getpPayPeriod04());
						logger.debug(" --------------------------------------");
					    	
					}
				}				
			}				
			
			IVendorMasterService vendorMasterService = (IVendorMasterService) getBean("vendorMasterService");
			List<String> vendorCodeList = vendorMasterService.getVendorCodeList(contractNoSelected);
			
			if(vendorCodeList != null && !vendorCodeList.isEmpty()){
				semmel006Bean.setVendorIdList(setSelectItemList(vendorCodeList, false));
			}
						
			IVendorMapPayeeELService vendorMapPayeeService = (IVendorMapPayeeELService)getBean("vendorMapPayeeELService");
			VendorMapPayeeEL vendortmp = vendorMapPayeeService.queryVendorMapPayeeMasterForELPayment(contractNoSelected );			
			boolean isFoundVendorMaster = true; 
			if(vendortmp!=null){				
				if(vendortmp.getVendorMasterId()!=null){
					if(vendortmp.getVendorMasterId()!=null&&vendortmp.getVendorMasterId().getVendorCode()!=null){
						semmel006Bean.getPayment().setVendorId(vendortmp.getVendorMasterId().getVendorCode());
					}
					if(vendortmp.getVendorMasterId()!=null&&vendortmp.getVendorMasterId().getVendorName()!=null){
						semmel006Bean.getPayment().setVendorName(vendortmp.getVendorMasterId().getVendorName());
					}					
				}else{
					logger.debug(" VendorMaster is null ,Alert message EL0040" );
					isFoundVendorMaster = false;
				} 
				if(vendortmp.getPayeeMasterId()!=null){
					if(vendortmp.getPayeeMasterId()!=null&&vendortmp.getPayeeMasterId().getRowId()!=null){
						semmel006Bean.getPayment().setPayeeId(vendortmp.getPayeeMasterId().getRowId());
					}
					if(vendortmp.getPayeeMasterId()!=null&&vendortmp.getPayeeMasterId().getPayeeName()!=null){
						semmel006Bean.getPayment().setPayeeName(vendortmp.getPayeeMasterId().getPayeeName());
					}					
				}else{ 
					logger.debug(" PayeeMaster is null ,new requirement not Alert message EL0040" );
					//isFoundVendorMaster = false;
				}										
			}else{
				logger.debug(" Not found VendorMapPayeeEL  ,Alert message EL0040" );
				isFoundVendorMaster = false;
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0040"), ""));
			}		
			
			//  Check Contract No Aready Expense PR_PREPAID 
			logger.debug(" Check Contract No "+contractNoSelected +" Aready Expense PR_PREPAID  " );
			//	�óշ���Ţ����ѭ�ҹ�� �ѧ������ա���ԡ�������Ҩ�����͡�� (����բ����ŷ�� SEM_EL_PAYMENT_DEFAULT Table ��� EXPENSE_TYPE = PR_PREPAID) � �к��� Default ����� ��	
			logger.debug(" Check Default PaymentType and PaymentMethod by contractId:"+ contractNoSelected);
//			IPaymentDefaultService paymentDefaultService = (IPaymentDefaultService)getBean("paymentDefaultService");		
//			PaymentDefault paymentDefault = new PaymentDefault();
//			paymentDefault.setContractNo(contractNoSelected);		
//			paymentDefault.setExpenseType(ELUtils.PR_PREPAID);
//			List<PaymentDefault> paymentDefaultList  = 	paymentDefaultService.queryPaymentDefaultByCritiria(paymentDefault,"updateDt","DESC");			
//			if(paymentDefaultList!=null&&paymentDefaultList.size()>0){
//				for(PaymentDefault pd : paymentDefaultList){
//					logger.debug(" Found contractNo "+contractNoSelected +" Aready Expense PR_PREPAID , So set Default PaymentType:"+paymentDefault.getPaymentType()+ " paymentMethod:"+ paymentDefault.getPaymentMethod());
//					paymentDefault =  paymentDefaultList.get(0);	
//					semmel006Bean.getPayment().setPaymentType(paymentDefault.getPaymentType());
//					semmel006Bean.getPayment().setPaymentMethod(paymentDefault.getPaymentMethod());
//				}			
//			}else{
//				logger.debug(" ContractNo "+contractNoSelected +" Never expense PR_PREPAID set PaymentType : 01 and PaymentMethod null");
//				semmel006Bean.getPayment().setPaymentType("01");		
//				//semmel006Bean.getPayment().setPaymentMethod(null);
//				semmel006Bean.getPayment().setPaymentMethod(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.CT_PAYMENT_METHOD));//WT###Add 20110207
//			}
//			 
//			if("02".equals(semmel006Bean.getPayment().getPaymentType())){
//				logger.debug("  Default PaymentType is  02  , Get  PayeeBookbank");
//				PayeeBookbank bookbank = vendorMapPayeeService.queryVendorMapPayeeMasterBookBank(contractNoSelected);		
//				if(bookbank!=null){					
//					semmel006Bean.getPayment().setBankAccount(bookbank.getBankAccNo());
//					semmel006Bean.getPayment().setBankName(bookbank.getBankAccName());			
//				}else{
//					logger.debug(" Not found PayeeBookbank" );
//					isFoundVendorMaster = false;
//				}
//			}else{
//				logger.debug("  Default PaymentType is not  02  , No get  PayeeBookbank");
//			} 
			
			// Load Meter Id list in case PRPOSPAID			
			logger.debug(" Load Meter Id list belong to electricId :"+electricIdSelected);
			IMeterInfoService meterInfoService = (IMeterInfoService)getBean("meterInfoService");
			MeterInfo meterSearch = new MeterInfo();
			meterSearch.setOutstandingFlag("Y");
			meterSearch.setRecordStatus("Y");
			Management electricId = new Management();
			electricId.setRowId(electricIdSelected);
			meterSearch.setElectricId(electricId);
			List <MeterInfo>  resultList = meterInfoService.queryMeterListForPayment(meterSearch);
			if(resultList!=null&&resultList.size()>0){
				logger.info(" Found MeterInfo list size :"+resultList.size());		
				MeterInfo meter = resultList.get(0);
				semmel006Bean.getPopupSiteCriteria().setMeterId(null);
				semmel006Bean.setMeterIdList(ELUtils.getMeterIdList(resultList));
				semmel006Bean.getPayment().setTotalMeterExpense(resultList.size());
			}else{
				semmel006Bean.setMeterIdList(ELUtils.getEmptyList());
				semmel006Bean.getPayment().setTotalMeterExpense(0);
				logger.info(" Not Found MeterInfo list");
			}			
			if(!isFoundVendorMaster){	
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0040"), ""));
				return flag;
			}				
			
			
			ElUseTypeDetailSP elSP = new ElUseTypeDetailSP();
			List<ElUseTypeDetailSP> recordStatusElList = new ArrayList<ElUseTypeDetailSP>();
			elSP.setElectricId(electricIdSelected);
			List<ElUseTypeDetailSP> elList = vendorMasterService.querySPList(EQueryName.SP_EL001_SEARCH_DTL.name, elSP);
			
			
			if(elList!=null && elList.size()>0){
				for(ElUseTypeDetailSP sp :elList){
					if(StringUtils.equalsIgnoreCase("Y", sp.getRecordStatus())){
						if(sp.getPeriodStartDt()!=null){
							sp.setPeriodStartDtTH(SEMDataUtility.convertToThYear(sp.getPeriodStartDt()));
						}
						if(sp.getPeriodEndDt()!=null){
							sp.setPeriodEndDtTH(SEMDataUtility.convertToThYear(sp.getPeriodEndDt()));
						}
						recordStatusElList.add(sp);
					}
				}
			}
				semmel006Bean.setElUseTypeList(recordStatusElList);
			// ***** added by bestnaja *****
			semmel006Bean.setPaymentDetailMeterInfoSection(new PaymentDetail());
			// *****

		changePaymentTypeELPostpaid();
		changePaymentTypeELPR();
		logger.info("END doAddSite4PRPrepaid");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flag;
	}
	//WT###Add 20110202 End
	
	public boolean doAddSitePR() {
		logger.debug(" --  doAddSitePR -- Add Site EL Privare One Bill ");
		boolean flag = false; 
		try{
			semmel006Bean = getSemmel006Bean();
			//oooooooooooooooooo
			//WT###Add 20110202 Start
			semmel006Bean.setDisableViewExpenseHisButton(false);
			semmel006Bean.setDisableViewMeterInfoButton(false);
			//WT###End 20110202 End
			
			List<PopupSiteSearch> siteList = semmel006Bean.getPopupSiteList();					
			String electricIdSelected = "";
			String contractNoSelected ="";
			String paymentType ="";
			String selectNumber = semmel006Bean.getSelectedRadio();
			
			if(selectNumber!=null){
				for(PopupSiteSearch tmp:siteList){
					if(selectNumber.equalsIgnoreCase(tmp.getRowNumber())){
//						System.out.println("networkStatus = "+tmp.getNetworkStatus());
						//networkStatus 05=offService,06=remove
						if(StringUtils.equals("05", tmp.getNetworkStatus()) || 
								StringUtils.equals("06", tmp.getNetworkStatus())){
							semmel006Bean.setStyleClassName("ms14red");
						}else{
							semmel006Bean.setStyleClassName("ms7");
						}
						
						if(StringUtils.equals("fail", tmp.getResult().toLowerCase())){
							FrontMessageUtils.addMessageError(tmp.getRemark());
						}
						
						//logger.debug(" PopupSiteSearch tmp:"+BeanUtils.getBeanString(tmp));
						semmel006Bean.setPopupSiteCriteria(tmp);
						electricIdSelected =  tmp.getElectricId();
						contractNoSelected = tmp.getContractNo();
						Payment payment = semmel006Bean.getPayment();
						ELUtils.copySearchsiteToPayment(tmp, payment);
						ELUtils.setPamentDisplayField(payment);
						semmel006Bean.getPayment().setElectricUseType(semmel006Bean.getPopupSiteCriteria().getElectricUseType());
						semmel006Bean.setPayment(payment);						
						changeElectricUseType_ELBill();
					    
						logger.debug(" --  electricIdSelected:"+electricIdSelected);
						logger.debug(" --  tmp.getpPayPeriodType()"+ tmp.getpPayPeriodType());
						logger.debug(" --  tmp.getpPayPeriod03():1"+ tmp.getpPayPeriod03());
						logger.debug(" --  tmp.getpPayPeriod04():1"+ tmp.getpPayPeriod04());
						logger.debug(" --  tmp.getpPayPeriod()"  + tmp.getpPayPeriod());
						logger.debug(" --  tmp.Payment CH()"  + tmp.getPayment_channel());
						
						logger.debug(" --------------------------------------");
						if(tmp.getpPayPeriodType()!=null){
							if(tmp.getpPayPeriodType().equalsIgnoreCase("03")){
								tmp.setpPayPeriod03(tmp.getpPayPeriod());
						    }else if(tmp.getpPayPeriodType().equalsIgnoreCase("04")){
						    	tmp.setpPayPeriod04(tmp.getpPayPeriod());
						    	
						    }
						}
						logger.debug(" --  tmp.getpPayPeriod03():2"+ tmp.getpPayPeriod03());
						logger.debug(" --  tmp.getpPayPeriod04():2"+ tmp.getpPayPeriod04());
						logger.debug(" --------------------------------------");
					    	
					}
				}				
			}				
			
			IVendorMasterService vendorMasterService = (IVendorMasterService) getBean("vendorMasterService");
			List<String> vendorCodeList = vendorMasterService.getVendorCodeList(contractNoSelected);
			
			if(vendorCodeList != null && !vendorCodeList.isEmpty()){
				semmel006Bean.setVendorIdList(setSelectItemList(vendorCodeList, false));
			}
			
			IVendorMapPayeeELService vendorMapPayeeService = (IVendorMapPayeeELService)getBean("vendorMapPayeeELService");
			VendorMapPayeeEL vendortmp = vendorMapPayeeService.queryVendorMapPayeeMasterForELPayment(contractNoSelected );
			
			boolean isFoundVendorMaster = true; 
			if(vendortmp!=null){				
				if(vendortmp.getVendorMasterId()!=null){
					if(vendortmp.getVendorMasterId()!=null&&vendortmp.getVendorMasterId().getVendorCode()!=null){
						semmel006Bean.getPayment().setVendorId(vendortmp.getVendorMasterId().getVendorCode());
					}
					if(vendortmp.getVendorMasterId()!=null&&vendortmp.getVendorMasterId().getVendorName()!=null){
						semmel006Bean.getPayment().setVendorName(vendortmp.getVendorMasterId().getVendorName());
					}					
				}else{
					logger.debug(" VendorMaster is null ,Alert message EL0040" );
					isFoundVendorMaster = false;
				} 
				if(vendortmp.getPayeeMasterId()!=null){
					if(vendortmp.getPayeeMasterId()!=null&&vendortmp.getPayeeMasterId().getRowId()!=null){
						semmel006Bean.getPayment().setPayeeId(vendortmp.getPayeeMasterId().getRowId());
					}
					if(vendortmp.getPayeeMasterId()!=null&&vendortmp.getPayeeMasterId().getPayeeName()!=null){
						semmel006Bean.getPayment().setPayeeName(vendortmp.getPayeeMasterId().getPayeeName());
					}					
				}else{ 
					logger.debug(" PayeeMaster is null ,new requirement not Alert message EL0040" );
					//isFoundVendorMaster = false;
				}										
			}else{
				logger.debug(" Not found VendorMapPayeeEL  ,Alert message EL0040" );
				isFoundVendorMaster = false;
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0040"), ""));
			}		
			
			//  Check Contract No Aready Expense PR_PREPAID 
			logger.debug(" Check Contract No "+contractNoSelected +" Already Expense PR_PREPAID  " );
			logger.debug(" Check Default PaymentType and PaymentMethod by contractId:"+ contractNoSelected);
			
			IPaymentDefaultService paymentDefaultService = (IPaymentDefaultService)getBean("paymentDefaultService");		
			PaymentDefault paymentDefault = new PaymentDefault();
			paymentDefault.setContractNo(contractNoSelected);		
			paymentDefault.setExpenseType(ELUtils.PR_PREPAID);
			List<PaymentDefault> paymentDefaultList  = 	paymentDefaultService.queryPaymentDefaultByCritiria(paymentDefault,"updateDt","DESC");			
			if(paymentDefaultList!=null&&paymentDefaultList.size()>0){
				for(PaymentDefault pd : paymentDefaultList){
					logger.debug(" Found contractNo "+contractNoSelected +" Aready Expense PR_PREPAID , So set Default PaymentType:"+paymentDefault.getPaymentType()+ " paymentMethod:"+ paymentDefault.getPaymentMethod());
					paymentDefault =  paymentDefaultList.get(0);	
					semmel006Bean.getPayment().setPaymentType(paymentDefault.getPaymentType());
					semmel006Bean.getPayment().setPaymentMethod(paymentDefault.getPaymentMethod());
				}			
			}else{
				logger.debug(" ContractNo "+contractNoSelected +" Never expense PR_PREPAID set PaymentType : 01 and PaymentMethod null");
				semmel006Bean.getPayment().setPaymentType("01");		
				//semmel006Bean.getPayment().setPaymentMethod(null);
				semmel006Bean.getPayment().setPaymentMethod(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.CT_PAYMENT_METHOD));//WT###Add 20110207
			
			}
			 
			if("02".equals(semmel006Bean.getPayment().getPaymentType())){
				logger.debug("  Default PaymentType is  02  , Get  PayeeBookbank");
				PayeeBookbank bookbank = vendorMapPayeeService.queryVendorMapPayeeMasterBookBank(contractNoSelected);		
				if(bookbank!=null){					
					semmel006Bean.getPayment().setBankAccount(bookbank.getBankAccNo());
					semmel006Bean.getPayment().setBankName(bookbank.getBankAccName());			
				}else{
					logger.debug(" Not found PayeeBookbank" );
					isFoundVendorMaster = false;
				}
			}else{
				logger.debug("  Default PaymentType is not  02  , No get  PayeeBookbank");
			} 
			// Load Meter Id list in case PRPOSPAID			
			logger.debug(" Test Load Meter Id list belong to electricId :"+electricIdSelected);
			IMeterInfoService meterInfoService = (IMeterInfoService)getBean("meterInfoService");
			MeterInfo meterSearch = new MeterInfo();
			meterSearch.setOutstandingFlag("Y");
			meterSearch.setRecordStatus("Y");
			Management electricId = new Management();
			electricId.setRowId(electricIdSelected);
			meterSearch.setElectricId(electricId);
			meterSearch.setOrderForSelectMeterId(true);
			List <MeterInfo>  resultList = meterInfoService.queryMeterListForPayment(meterSearch);
			if(resultList!=null&&resultList.size()>0){
				logger.info("<<<<<< Test Found MeterInfo list size >>>>>> :"+resultList.size());		
				MeterInfo meterInfoData = resultList.get(0);
				semmel006Bean.getPopupSiteCriteria().setMeterId(meterInfoData.getRowId());
				semmel006Bean.setMeterIdList(ELUtils.getMeterIdList(resultList));
				semmel006Bean.getPayment().setTotalMeterExpense(resultList.size());
				doChangeMeter();
				//ppppppppppppppppppppp
				logger.info(" Check Meter Info Deatail :"+resultList.size());
				
			}else{
				semmel006Bean.setMeterIdList(ELUtils.getEmptyList());
				semmel006Bean.getPayment().setTotalMeterExpense(0);
				logger.info(" Not Found MeterInfo list");
			}			
			
			
			if(!isFoundVendorMaster){	
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0040"), ""));
				return flag;
			}				
			
			// ***** added by bestnaja *****
			
			semmel006Bean.setPaymentDetailMeterInfoSection(new PaymentDetail());
			if (semmel006Bean.getPopupSiteCriteria().getPayment_channel()!= null){
				
				if(semmel006Bean.getPayment().getPayment_channel() == null){
				   if(semmel006Bean.getPayment().getPayment_channel() != null){
						semmel006Bean.getPayment().setPayment_channel(semmel006Bean.getPopupSiteCriteria().getPayment_channel());
						//logger.debug(" --  getPayment_channel(): --"+semmel006Bean.getPopupSiteCriteria().getPayment_channel());
				   }
				
				}
					
			}
			
			String meterPaymentMethod = semmel006Bean.getPayment().getPaymentMethod();	
			// *****			
		    changePaymentTypeELPostpaid();
		    if(!StringUtils.isEmpty(meterPaymentMethod)){
		    	semmel006Bean.getPayment().setPaymentMethod(meterPaymentMethod);
		    }
		    //logger.debug("<<<<<<paymentType--2<<<<:"+semmel006Bean.getPayment().getPaymentType());
			//logger.debug("<<<<<<paymentMethod--2<<<<:"+semmel006Bean.getPayment().getPaymentMethod());	
			//logger.info(" Not Found MeterInfo list");
		    changePaymentTypeELPR();
		
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flag;
	}
		
	
	
	
	public boolean doAddInstallment() {
		logger.debug(" --  doAddInstallment Prepaid--");
		boolean flag = false;
		try{
			semmel006Bean = getSemmel006Bean();			
			List <PrivatePrepaid > installmentList =  semmel006Bean.getPrivatePrepaidResult();				
			boolean isSelected = false;
			Payment payment = semmel006Bean.getPayment();
			
			
			for(PrivatePrepaid tmp:installmentList){					
				if (tmp.isSelected()) {
					//logger.debug(" MeterInstallment ischeck :"+ BeanUtils.getBeanString(tmp));
					if("N".equals(tmp.getPaidFlag())){
						logger.debug(" check and paidflag =N , Add to payment detail list");
						isSelected = true;		
						PaymentDetail newPaymentDetail = new PaymentDetail();
						newPaymentDetail.setPayAmt(tmp.getPayAMt()==null?new BigDecimal(0):tmp.getPayAMt());
						newPaymentDetail.setVatAmt(tmp.getVatAmt()==null?new BigDecimal(0):tmp.getVatAmt());
						newPaymentDetail.setDueDt(tmp.getDueDt());
						newPaymentDetail.setExcludeVatAmt(tmp.getExcludeVatAmt()==null?new BigDecimal(0):tmp.getExcludeVatAmt());
						newPaymentDetail.setIncludeVatAmt(tmp.getIncludeVatAmt()==null?new BigDecimal(0):tmp.getIncludeVatAmt());
						newPaymentDetail.setChqAmt(tmp.getChqAmt()==null?new BigDecimal(0):tmp.getChqAmt());	
						newPaymentDetail.setInstallmentrowId(tmp.getRowId());
						
						// Bug PaymentPRPre-019
						//newPaymentDetail.setVatType(payment.getVatType());						
						newPaymentDetail.setVatType(tmp.getVatType());
						
						//- TERM_OF_PAYMENT_DT = TERM_OF_PAYMENT_DT จาก SEM_EL_METER_INSTALLMENT  
						//- FROM_TERM_OF_PAYMENT_DT = FROM_TERM_OF_PAYMENT_DT จาก SEM_EL_METER_INSTALLMENT  
						//- TO_TERM_OF_PAYMENT_DT = TO_TERM_OF_PAYMENT_DT จาก SEM_EL_METER_INSTALLMENT 
						//- PERIOD_NAME = PERIOD_NAME จาก SEM_EL_METER_INSTALLMENT 
						
						newPaymentDetail.setTermOfPaymentDt(tmp.getTermOfPaymentDt());
						newPaymentDetail.setFromTermOfPaymentDt(tmp.getFormTermOfPaymentDt());
						newPaymentDetail.setToTermOfPaymentDt(tmp.getToTermOfPaymentDt());
						newPaymentDetail.setPeriodName(tmp.getPeriodName());
						newPaymentDetail.setWhtType(tmp.getWhtType());//WT###Add 20110119
						
						//-------------------
						newPaymentDetail.setPrivatePrepaid(tmp.getRowId());   
						  
						
						ELUtils.setPamentDisplayField(payment);
				        ELUtils.setPamentDetailDisplayField(newPaymentDetail);
				        List<PaymentDetail> paymentDetailList = payment.getPaymentDetailList();	
						if(paymentDetailList==null||paymentDetailList.size()==0){
							newPaymentDetail.setRowNumber(1);
							logger.debug(" rowNumber for first Row:"+newPaymentDetail.getRowNumber() );
							List<PaymentDetail> newDetailList = new ArrayList<PaymentDetail>();
							newDetailList.add(newPaymentDetail);
							payment.setPaymentDetailList(newDetailList);
							semmel006Bean.setPaymentDetailList(newDetailList);
						}else{
							logger.debug(" paymentDetailList size:"+paymentDetailList.size());
							int maxCurrentRow = ((PaymentDetail)paymentDetailList.get(paymentDetailList.size()-1)).getRowNumber() +1;
							logger.debug(" maxCurrentRow:"+maxCurrentRow);
							newPaymentDetail.setRowNumber(maxCurrentRow);			
							semmel006Bean.getPaymentDetailList().add(newPaymentDetail);				
						}					
						BigDecimal whtAmt = new BigDecimal(0);
						
						reCalculatePaymentConclution6(semmel006Bean.getPaymentDetailList(),semmel006Bean.getPayment());
						if( semmel006Bean.getPaymentDetailList() != null){
							//BigDecimal threeVatAmt = ELUtils.getAmtPercent(exVatAmt, vatRate);				
							int size = semmel006Bean.getPaymentDetailList().size();
							whtAmt = semmel006Bean.getPayment().getWhtAmt().divide(new BigDecimal(size),2,BigDecimal.ROUND_HALF_UP);
							for(PaymentDetail paymentDetail: semmel006Bean.getPaymentDetailList()){
								
								paymentDetail.setWhtAmt(whtAmt);
								
							}
							
						}
					}else{
						logger.debug(" check and paidflag =Y , Aready exist in Grid Add , No add");
					}
					
				
				}
			}			
			logger.debug("newPayment.getPaymentDetailList() size :"+payment.getPaymentDetailList().size() );			
			if(semmel006Bean.getPaymentDetailList()==null||semmel006Bean.getPaymentDetailList().size()<=0){
				semmel006Bean.setDisableMoreThanOneDetail(false);
			}else{
				semmel006Bean.setDisableMoreThanOneDetail(true);
			}			
			
			semmel006Bean.setPaymentDetail(new PaymentDetail());	
			if(!isSelected){
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0022"), ""));
				return flag;
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flag;
	}		
	
	
	
	
	
	public boolean doChangeWhtELPR(){		
		logger.debug(" -- doChangeWhtELPR--");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			PaymentDetail paymentDetail = semmel006Bean.getPaymentDetail();		
			paymentDetail.setWhtRate(new BigDecimal(3));
			boolean isWhtcheck = paymentDetail.isWhtCheckBoolean();
			
			if(isWhtcheck){
				logger.debug("  WhtCheckBoolean is Checked");				
				semmel006Bean.setWhtRateDisable(false);
				semmel006Bean.setWhtTypeMandatory(true);
				semmel006Bean.setWhtTypeDisable(false);
				semmel006Bean.setWhtAmtDisable(false);
				semmel006Bean.setWhtAmtMandatory(true);
				//WT###20110131 Start
				semmel006Bean.getPaymentDetail().setWhtType(WHT_TYPE_ABSORB);
				//WT###20110131 End
			}else{
				logger.debug("  WhtCheckBoolean is not Checked");
				paymentDetail.setWhtRate(new BigDecimal(0));
				paymentDetail.setWhtAmt(new BigDecimal(0));
				paymentDetail.setWhtType(null);
				semmel006Bean.setWhtRateDisable(true);
				semmel006Bean.setWhtAmtDisable(true);
				semmel006Bean.setWhtTypeMandatory(false);	
				semmel006Bean.setWhtTypeDisable(true);
				semmel006Bean.setWhtAmtMandatory(false);
				//WT###20110131 Start
				semmel006Bean.getPaymentDetail().setWhtType(null);
				//WT###20110131 End
			 
			}
			doRecalCulateVATPR();
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return flagValid;			
	}	
	
	
	
	public boolean doChangeWhtELPaymentPR(){		
		logger.debug(" -- doChangeWhtELPaymentPR--");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			Payment payment = semmel006Bean.getPayment();		
			payment.setWhtRate(new BigDecimal(3));
			boolean isWhtcheck = payment.isWhtCheckBoolean();
			
			if(isWhtcheck){
				logger.debug("  WhtCheckBoolean is Checked");				
				semmel006Bean.setWhtRateDisable(false);
				semmel006Bean.setWhtTypeMandatory(true);
				semmel006Bean.setWhtTypeDisable(false);
				semmel006Bean.setWhtAmtDisable(false);
				semmel006Bean.setWhtAmtMandatory(true);
			}else{
				logger.debug("  WhtCheckBoolean is not Checked");
				payment.setWhtRate(new BigDecimal(0));
				payment.setWhtAmt(new BigDecimal(0));
				payment.setWhtType(null);
				semmel006Bean.setWhtRateDisable(true);
				semmel006Bean.setWhtAmtDisable(true);
				semmel006Bean.setWhtTypeMandatory(false);	
				semmel006Bean.setWhtTypeDisable(true);
				semmel006Bean.setWhtAmtMandatory(false);
			 
			}
			//WT###Add 20110119 Start
			if(semmel006Bean.getPayment().isWhtCheckBoolean()){
				semmel006Bean.getPayment().setWhtType("01");
			}			
			doCalculateChqAmt();   
			calculateWhtAmtPerRecord();			
			//WT###Add 20110119 End
			doRecalCulateTotalVatPR_Prepaid();			
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return flagValid;			
	}	
	
	private void calculateWhtAmtPerRecord(){
		Payment payment = semmel006Bean.getPayment();
		BigDecimal vatRate = payment.getWhtRate()==null?new BigDecimal(0):payment.getWhtRate();
		logger.debug("  vatRate:"+vatRate);
		
		for(PaymentDetail objPaymentDetail : semmel006Bean.getPaymentDetailList()){
			BigDecimal exVatAmtDetail = new BigDecimal("0");
			String vatType = objPaymentDetail.getVatType();
			BigDecimal exVatAmt = objPaymentDetail.getExcludeVatAmt()==null?new BigDecimal(0): objPaymentDetail.getExcludeVatAmt();
			BigDecimal vatAmt = new BigDecimal(0);
			BigDecimal inVatAmt = objPaymentDetail.getIncludeVatAmt()==null?new BigDecimal(0): objPaymentDetail.getIncludeVatAmt();
			BigDecimal payAmt = objPaymentDetail.getPayAmt()==null?new BigDecimal(0): objPaymentDetail.getPayAmt();
			BigDecimal whtAmt = new BigDecimal(0);
			
			if("01".equals(vatType)){
				exVatAmt = ELUtils.getExcludeVatFromTotalPay(payAmt);
				vatAmt = ELUtils.getVatAmtFromTotalPay(payAmt);
				inVatAmt = exVatAmt.add(vatAmt);
			}else if("02".equals(vatType)){
				exVatAmt = payAmt;
				vatAmt = ELUtils.getNoVatAmtFromTotalPay(payAmt);
				inVatAmt = exVatAmt.add(vatAmt);
			}else if("03".equals(vatType)){
				exVatAmt = payAmt;
				vatAmt = new BigDecimal(0);
				inVatAmt = payAmt;
			}
			BigDecimal threeVatAmt = ELUtils.getAmtPercent(exVatAmt, vatRate);				
			whtAmt = threeVatAmt;	
			objPaymentDetail.setWhtAmt(whtAmt);
			objPaymentDetail.setWhtType(payment.getWhtType());
			try {
				ELUtils.setPamentDetailDisplayField(objPaymentDetail);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean doRecalCulateTotalVatPR_Prepaid(){		
		logger.debug(" -- doRecalCulateTotalVatPR_Prepaid --");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			Payment payment = semmel006Bean.getPayment();	
			boolean isWhtcheck = payment.isWhtCheckBoolean();
			String pVatType = semmel006Bean.getPopupSiteCriteria().getpVatType();
			String whtType = payment.getWhtType();
			logger.debug("WT### pVatType="+pVatType);
			
			BigDecimal payAmt = payment.getPayAmt()==null?new BigDecimal(0): payment.getPayAmt();
			BigDecimal exVatAmt = payment.getExcludeVatAmt()==null?new BigDecimal(0): payment.getExcludeVatAmt();
			BigDecimal inVatAmt = payment.getIncludeVatAmt()==null?new BigDecimal(0): payment.getIncludeVatAmt();
			BigDecimal chqAmt = payment.getChqAmt()==null?new BigDecimal(0): payment.getChqAmt();
			BigDecimal vatAmt = new BigDecimal(0);	
			BigDecimal whtAmt = new BigDecimal(0);
			if(isWhtcheck){
				
				logger.debug("  isWhtcheck checked Calculate only pament");
				BigDecimal vatRate = payment.getWhtRate()==null?new BigDecimal(0):payment.getWhtRate();

				logger.debug("  vatRate:"+vatRate);

			
				// ��� VAT
				if("01".equals(pVatType)){
					logger.debug("   pVatType :01  ��� VAT");
					exVatAmt = ELUtils.getExcludeVatFromTotalPay(payAmt);
					vatAmt = ELUtils.getVatAmtFromTotalPay(payAmt);
					inVatAmt = exVatAmt.add(vatAmt);
				// ������ VAT
				}else if("02".equals(pVatType)){
					logger.debug("   pVatType :02  ������ VAT");
					exVatAmt = payAmt;
					vatAmt = ELUtils.getNoVatAmtFromTotalPay(payAmt);
					inVatAmt = exVatAmt.add(vatAmt);
				// ¡��� VAT
				}else if("03".equals(pVatType)){
					logger.debug("   pVatType :03  ¡��� VAT");
					exVatAmt = payAmt;
					vatAmt = new BigDecimal(0);
					inVatAmt = payAmt;
				}
				
				
				BigDecimal threeVatAmt = ELUtils.getAmtPercent(exVatAmt, vatRate);				
				whtAmt = threeVatAmt;				
				logger.debug("  whtAmt:"+whtAmt);
				
				payment.setWhtAmt(whtAmt);
				payment.setExcludeVatAmt(exVatAmt);
				payment.setVatAmt(vatAmt);	
				payment.setIncludeVatAmt(inVatAmt);				
				doCalculateChqAmt();
				
			}else{
				logger.debug("  isWhtcheck not Check Recalcuate Data in grid");
				reCalculatePaymentConclution(semmel006Bean.getPaymentDetailList(),semmel006Bean.getPayment());
			}			
			
			semmel006Bean.setPreviosVatAmt(vatAmt);
			semmel006Bean.setPreviosWhtAmt(whtAmt);
			calculateWhtAmtPerRecord();	//WT###Add 20110119

		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return flagValid;			
	}	
	
	
	public void doCalculateChqAmt( ){	
		
		semmel006Bean = getSemmel006Bean();	 
		Payment payment = semmel006Bean.getPayment();	
		String whtType = payment.getWhtType();
		logger.debug(" doCalculateChqAmt whtType:"+whtType); 
		BigDecimal exVatAmt = payment.getExcludeVatAmt()==null?new BigDecimal(0):payment.getExcludeVatAmt();
		BigDecimal whtAmt = payment.getWhtAmt()==null?new BigDecimal(0):payment.getWhtAmt();
		BigDecimal vatAmt = payment.getVatAmt()==null?new BigDecimal(0):payment.getVatAmt();

		logger.debug(" exVatAmt :"+exVatAmt+" whtAmt:"+whtAmt+" vatAmt:"+vatAmt);
		//BigDecimal payAmt = payment.getAmt()==null?new BigDecimal(0):payment.getVatAmt();
		BigDecimal chqAmt = new BigDecimal(0);
		// 01 �ѡ���� (��� Absorb) �ӹǳ�ҡ -> (�ӹǹ�Թ��͹ VAT � WHT Amount) + �ӹǹ�Թ VAT
		if("01".equals(whtType)){
			chqAmt = exVatAmt.subtract(whtAmt).add(vatAmt);
		//	02: ����ѡ���� (Absorb)
		}else if("02".equals(whtType)){
			chqAmt = exVatAmt.add(vatAmt);
		//	03: ����������� 
		}else if("03".equals(whtType)){
			chqAmt = exVatAmt.add(vatAmt);
		}		
		logger.debug("  chqAmt:"+chqAmt);
		payment.setChqAmt(chqAmt);
		
		//WT###Add 20110119 Start
		calculateWhtAmtPerRecord();
		//WT###Add 20110119 End

	}	
	
	
	
	//WT###Add 20110204 Start
	public void doRecalCulateVATELTempPage62(){		
		logger.debug("START Action doRecalCulateVATELTempPage62");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			Payment payment = semmel006Bean.getPayment();		

			String vatType = payment.getVatType();;	
			logger.debug("vatType"+vatType);
			
			
			BigDecimal totalPayAmt = new BigDecimal(0);
			BigDecimal totalWhtAmt = new BigDecimal(0);
			BigDecimal totalExVatAmt =  new BigDecimal(0);
			BigDecimal totalVatAmt = new BigDecimal(0);
			BigDecimal totalInVatAmt = new BigDecimal(0);
			BigDecimal totalChqAmt = new BigDecimal(0);
			
			BigDecimal totalSevenVatAmt = new BigDecimal(0);
			BigDecimal totalThreeVatAmt = new BigDecimal(0);
			

			BigDecimal payAmt = payment.getPayAmt()==null? new BigDecimal(0):payment.getPayAmt();						
			BigDecimal exVatAmt =  payment.getExcludeVatAmt()==null? new BigDecimal(0):payment.getExcludeVatAmt();					
			totalPayAmt = totalPayAmt.add(payAmt);

			
			if("01".equals(vatType)){
				logger.debug(" VAT ");
				totalExVatAmt = ELUtils.getExcludeVatFromTotalPay(totalPayAmt);
				totalVatAmt = ELUtils.getVatAmtFromTotalPay(totalPayAmt);
				totalInVatAmt =totalExVatAmt.add(totalVatAmt);
			
			}else if("02".equalsIgnoreCase(vatType)){
				//doRecalCulateVATPR();

				totalExVatAmt = totalPayAmt;
				totalVatAmt = ELUtils.getSevenVAtAmtFromOriginalPrice(totalPayAmt);
				totalInVatAmt =totalPayAmt.add(totalVatAmt);
			}else if("03".equals(vatType)){
				logger.debug(" No VAT ");
				totalExVatAmt = totalPayAmt;
				totalVatAmt = new BigDecimal(0);
				totalInVatAmt =totalPayAmt;
			}		
	
			
			//totalSevenVatAmt = ELUtils.getAmtPercent(totalPayAmt, new BigDecimal(7));
			
			
			BigDecimal withholdingTax  = payment.getWhtRate()==null?new BigDecimal(0):payment.getWhtRate();	
			totalThreeVatAmt = ELUtils.getAmtPercent(totalPayAmt, withholdingTax);		
			
			totalWhtAmt = totalExVatAmt.multiply(withholdingTax).divide(new BigDecimal(100),2,BigDecimal.ROUND_HALF_UP);		
	
			totalChqAmt = totalPayAmt.subtract(totalThreeVatAmt).add(totalThreeVatAmt).setScale(2,BigDecimal.ROUND_HALF_UP);
		
			
			logger.debug("  totalPayAmt:"+totalPayAmt);
			logger.debug(" totalWhtAmt :"+totalWhtAmt);
			logger.debug(" totalExVatAmt :"+totalExVatAmt);
			logger.debug(" totalVatAmt :"+totalVatAmt);
			logger.debug(" totalInVatAmt :"+totalInVatAmt);
			logger.debug(" totalChqAmt :"+totalChqAmt);
						
			payment.setInvTotalExcludeVat(totalExVatAmt);	
			payment.setInvTotalVat(totalVatAmt);
			payment.setInvTotalIncludeVat(totalInVatAmt);			
			semmel006Bean.setPreviosVatAmt(totalVatAmt);
			
			recalculateAdNewExpenseSite();
			
			logger.info("END Action doRecalCulateVATELTempPage62");
		}catch(Exception ex){
			ex.printStackTrace();
			logger.debug("ERROR Action doRecalCulateVATELTempPage63 : "+ex, ex);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMEL006");
			FrontMessageUtils.addMessageError(errorMsg);
		}		
	}
	//WT###Add 20110204 End
	
	//WT###Add 20110128 Start
	public void doRecalCulateVATELTempPage63(){		
		logger.debug("START Action doRecalCulateVATELTempPage63");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			PaymentDetail paymentDetail = semmel006Bean.getPaymentDetail();		

			String vatType = paymentDetail.getVatType();
			logger.debug("vatType"+vatType);
			
			
			BigDecimal totalPayAmt = new BigDecimal(0);
			BigDecimal totalWhtAmt = new BigDecimal(0);
			BigDecimal totalExVatAmt =  new BigDecimal(0);
			BigDecimal totalVatAmt = new BigDecimal(0);
			BigDecimal totalInVatAmt = new BigDecimal(0);
			BigDecimal totalChqAmt = new BigDecimal(0);
			
			BigDecimal totalSevenVatAmt = new BigDecimal(0);
			BigDecimal totalThreeVatAmt = new BigDecimal(0);
			

			BigDecimal payAmt = paymentDetail.getPayAmt()==null? new BigDecimal(0):paymentDetail.getPayAmt();						
			BigDecimal exVatAmt =  paymentDetail.getExcludeVatAmt()==null? new BigDecimal(0):paymentDetail.getExcludeVatAmt();					
			totalPayAmt = totalPayAmt.add(payAmt);

			
			if("01".equals(vatType)){
				logger.debug(" VAT ");
				totalExVatAmt = ELUtils.getExcludeVatFromTotalPay(totalPayAmt);
				totalVatAmt = ELUtils.getVatAmtFromTotalPay(totalPayAmt);
				totalInVatAmt =totalExVatAmt.add(totalVatAmt);
			
			}else if("02".equalsIgnoreCase(vatType)){
				//doRecalCulateVATPR();

				totalExVatAmt = totalPayAmt;
				totalVatAmt = ELUtils.getSevenVAtAmtFromOriginalPrice(totalPayAmt);
				totalInVatAmt =totalPayAmt.add(totalVatAmt);
			}else if("03".equals(vatType)){
				logger.debug(" No VAT ");
				totalExVatAmt = totalPayAmt;
				totalVatAmt = new BigDecimal(0);
				totalInVatAmt =totalPayAmt;
			}		
	
			
			//totalSevenVatAmt = ELUtils.getAmtPercent(totalPayAmt, new BigDecimal(7));
			
			
			BigDecimal withholdingTax  = paymentDetail.getWhtRate()==null?new BigDecimal(0):paymentDetail.getWhtRate();	
			totalThreeVatAmt = ELUtils.getAmtPercent(totalPayAmt, withholdingTax);		
			
			totalWhtAmt = totalExVatAmt.multiply(withholdingTax).divide(new BigDecimal(100),2,BigDecimal.ROUND_HALF_UP);		
	
			totalChqAmt = totalPayAmt.subtract(totalThreeVatAmt).add(totalThreeVatAmt).setScale(2,BigDecimal.ROUND_HALF_UP);
		
			
			logger.debug("  totalPayAmt:"+totalPayAmt);
			logger.debug(" totalWhtAmt :"+totalWhtAmt);
			logger.debug(" totalExVatAmt :"+totalExVatAmt);
			logger.debug(" totalVatAmt :"+totalVatAmt);
			logger.debug(" totalInVatAmt :"+totalInVatAmt);
			logger.debug(" totalChqAmt :"+totalChqAmt);
			
			paymentDetail.setPayAmt(totalPayAmt);
			paymentDetail.setWhtAmt(totalWhtAmt);
			paymentDetail.setExcludeVatAmt(totalExVatAmt);
			paymentDetail.setVatAmt(totalVatAmt);
			paymentDetail.setIncludeVatAmt(totalInVatAmt);
			paymentDetail.setChqAmt(totalInVatAmt);//WT###Edit 20110422 paymentDetail.setChqAmt(totalChqAmt);			
			semmel006Bean.setPreviosVatAmt(totalVatAmt);
			
			logger.debug("END Action doRecalCulateVATELTempPage63");
		}catch(Exception ex){
			ex.printStackTrace();
			logger.debug("ERROR Action doRecalCulateVATELTempPage63 : "+ex, ex);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMEL006");
			FrontMessageUtils.addMessageError(errorMsg);
		}		
	}
	//wT###Add 20110128 End
	
	
	public boolean doRecalCulateVATELTemp(){		
		logger.debug(" -- doRecalCulateVATELTemp--");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			PaymentDetail paymentDetail = semmel006Bean.getPaymentDetail();		

			String vatType = paymentDetail.getVatType();;	
			logger.debug("vatType"+vatType);
			
			
			BigDecimal totalPayAmt = new BigDecimal(0);
			BigDecimal totalWhtAmt = new BigDecimal(0);
			BigDecimal totalExVatAmt =  new BigDecimal(0);
			BigDecimal totalVatAmt = new BigDecimal(0);
			BigDecimal totalInVatAmt = new BigDecimal(0);
			BigDecimal totalChqAmt = new BigDecimal(0);
			
			BigDecimal totalSevenVatAmt = new BigDecimal(0);
			BigDecimal totalThreeVatAmt = new BigDecimal(0);
			

			BigDecimal payAmt = paymentDetail.getPayAmt()==null? new BigDecimal(0):paymentDetail.getPayAmt();						
			BigDecimal exVatAmt =  paymentDetail.getExcludeVatAmt()==null? new BigDecimal(0):paymentDetail.getExcludeVatAmt();					
			totalPayAmt = totalPayAmt.add(payAmt);

			
			if("01".equals(vatType)){
				logger.debug(" VAT ");
				totalExVatAmt = ELUtils.getExcludeVatFromTotalPay(totalPayAmt);
				totalVatAmt = ELUtils.getVatAmtFromTotalPay(totalPayAmt);
				totalInVatAmt =totalExVatAmt.add(totalVatAmt);
			
			}else if("02".equals(vatType)){
				logger.debug(" No VAT ");
				totalExVatAmt = totalPayAmt;
				//totalVatAmt = new BigDecimal(0);
				totalVatAmt = ELUtils.getSevenVAtAmtFromOriginalPrice(totalPayAmt);
				totalInVatAmt =totalPayAmt.add(totalVatAmt);
				semmel006Bean.setVatAmtDisable(false);
			}   else if("03".equals(vatType)){
				logger.debug(" No VAT ");
				totalExVatAmt = totalPayAmt;
				totalVatAmt = new BigDecimal(0);
				totalInVatAmt =totalPayAmt;
			}		
	
			
			//totalSevenVatAmt = ELUtils.getAmtPercent(totalPayAmt, new BigDecimal(7));
			
			
			BigDecimal withholdingTax  = paymentDetail.getWhtRate()==null?new BigDecimal(0):paymentDetail.getWhtRate();	
			totalThreeVatAmt = ELUtils.getAmtPercent(totalPayAmt, withholdingTax);		
			
			totalWhtAmt = totalExVatAmt.multiply(withholdingTax).divide(new BigDecimal(100),2,BigDecimal.ROUND_HALF_UP);		
	
			totalChqAmt = totalPayAmt.subtract(totalThreeVatAmt).add(totalThreeVatAmt).setScale(2,BigDecimal.ROUND_HALF_UP);
		
			
			logger.debug("  totalPayAmt:"+totalPayAmt);
			logger.debug(" totalWhtAmt :"+totalWhtAmt);
			logger.debug(" totalExVatAmt :"+totalExVatAmt);
			logger.debug(" totalVatAmt :"+totalVatAmt);
			logger.debug(" totalInVatAmt :"+totalInVatAmt);
			logger.debug(" totalChqAmt :"+totalChqAmt);
			
			paymentDetail.setPayAmt(totalPayAmt);
			paymentDetail.setWhtAmt(totalWhtAmt);
			paymentDetail.setExcludeVatAmt(totalExVatAmt);
			paymentDetail.setVatAmt(totalVatAmt);
			paymentDetail.setIncludeVatAmt(totalInVatAmt);
			paymentDetail.setChqAmt(totalChqAmt);
			semmel006Bean.setPreviosVatAmt(totalVatAmt);
			

		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return flagValid;			
	}	
	

	public void doChangePaymentWhtAmt6( ){	
		logger.debug(" doChangePaymentWhtAmt6");
		semmel006Bean = getSemmel006Bean();	 
		Payment paymentDetail = semmel006Bean.getPayment();			

		BigDecimal currentWhtAmt =  paymentDetail.getWhtAmt()==null?new BigDecimal(0):paymentDetail.getWhtAmt().setScale(3,BigDecimal.ROUND_HALF_DOWN);
		BigDecimal previousWhtAmt =  semmel006Bean.getPreviosWhtAmt()==null?new BigDecimal(0):semmel006Bean.getPreviosWhtAmt().setScale(3,BigDecimal.ROUND_HALF_DOWN);
		
		if(currentWhtAmt.intValue()==0){
			
		}else{
			  boolean compareStatus = true;
			  BigDecimal div= previousWhtAmt.subtract(currentWhtAmt);
			  int compareResult = 0;
			  //previousVatAmt>currentvatAmt
			  if(previousWhtAmt.compareTo(currentWhtAmt)==1){				  
				  compareResult =  div.compareTo(new BigDecimal(1));
				  if(compareResult==1){
					  compareStatus =false;
				  }
				//previousVatAmt<currentvatAmt
			  }else if (previousWhtAmt.compareTo(currentWhtAmt)==-1){
				  compareResult =  div.compareTo(new BigDecimal(-1));
				  if(compareResult==-1){
					  compareStatus =false;
				  }
				//previousVatAmt==currentvatAmt
			  }else if(previousWhtAmt.compareTo(currentWhtAmt)==0){
				  
			  }		  
			  
			  logger.debug(" currentWhtAmt "+currentWhtAmt +"previousWhtAmt: "+previousWhtAmt +"div:"+div+"  compartresult:"+compareResult);
			  if(!compareStatus){
				  // Error message EL0039
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0039"), ""));
					//reCalculatePaymentDetailConclution();
					paymentDetail.setWhtAmt(previousWhtAmt);
			  }else{	
				  paymentDetail.setWhtAmt(currentWhtAmt);
				 // semmel006Bean.setPreviosWhtAmt(currentWhtAmt);
			  }
			  
			  // Recalculate chqAmt 
			  
			  logger.debug(" whtAmt: "+currentWhtAmt);
			  
			  doChangePaymentWhtType6();
			  
			  
		} 
	}	

	public void doChangePaymentWhtAmt( ){	
		logger.debug(" doChangePaymentWhtAmt");
		semmel006Bean = getSemmel006Bean();	 
		Payment paymentDetail = semmel006Bean.getPayment();			

		BigDecimal currentWhtAmt =  paymentDetail.getWhtAmt()==null?new BigDecimal(0):paymentDetail.getWhtAmt().setScale(3,BigDecimal.ROUND_HALF_DOWN);
		BigDecimal previousWhtAmt =  semmel006Bean.getPreviosWhtAmt()==null?new BigDecimal(0):semmel006Bean.getPreviosWhtAmt().setScale(3,BigDecimal.ROUND_HALF_DOWN);
		
		if(currentWhtAmt.intValue()==0){
			
		}else{
			  boolean compareStatus = true;
			  BigDecimal div= previousWhtAmt.subtract(currentWhtAmt);
			  int compareResult = 0;
			  //previousVatAmt>currentvatAmt
			  if(previousWhtAmt.compareTo(currentWhtAmt)==1){				  
				  compareResult =  div.compareTo(new BigDecimal(1));
				  if(compareResult==1){
					  compareStatus =false;
				  }
				//previousVatAmt<currentvatAmt
			  }else if (previousWhtAmt.compareTo(currentWhtAmt)==-1){
				  compareResult =  div.compareTo(new BigDecimal(-1));
				  if(compareResult==-1){
					  compareStatus =false;
				  }
				//previousVatAmt==currentvatAmt
			  }else if(previousWhtAmt.compareTo(currentWhtAmt)==0){
				  
			  }		  
			  
			  logger.debug(" currentWhtAmt "+currentWhtAmt +"previousWhtAmt: "+previousWhtAmt +"div:"+div+"  compartresult:"+compareResult);
			  if(!compareStatus){
				  // Error message EL0039
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0039"), ""));
					//reCalculatePaymentDetailConclution();
					paymentDetail.setWhtAmt(previousWhtAmt);
			  }else{	
				  paymentDetail.setWhtAmt(currentWhtAmt);
				 // semmel006Bean.setPreviosWhtAmt(currentWhtAmt);
			  }
		} 
	}	
	
	public void doChangeWhtAmt( ){	
		logger.debug(" doChangeWhtAmt");
		semmel006Bean = getSemmel006Bean();	 
		PaymentDetail paymentDetail = semmel006Bean.getPaymentDetail();			

		BigDecimal currentWhtAmt =  paymentDetail.getWhtAmt()==null?new BigDecimal(0):paymentDetail.getWhtAmt().setScale(3,BigDecimal.ROUND_HALF_DOWN);
		BigDecimal previousWhtAmt =  semmel006Bean.getPreviosWhtAmt()==null?new BigDecimal(0):semmel006Bean.getPreviosWhtAmt().setScale(3,BigDecimal.ROUND_HALF_DOWN);
	
		if(currentWhtAmt.intValue()==0){
			
		}else{
			  boolean compareStatus = true;
			  BigDecimal div= previousWhtAmt.subtract(currentWhtAmt);
			  int compareResult = 0;
			  //previousVatAmt>currentvatAmt
			  if(previousWhtAmt.compareTo(currentWhtAmt)==1){				  
				  compareResult =  div.compareTo(new BigDecimal(1));
				  if(compareResult==1){
					  compareStatus =false;
				  }
				//previousVatAmt<currentvatAmt
			  }else if (previousWhtAmt.compareTo(currentWhtAmt)==-1){
				  compareResult =  div.compareTo(new BigDecimal(-1));
				  if(compareResult==-1){
					  compareStatus =false;
				  }
				//previousVatAmt==currentvatAmt
			  }else if(previousWhtAmt.compareTo(currentWhtAmt)==0){
				  
			  }		  
			  
			  logger.debug(" currentWhtAmt "+currentWhtAmt +"previousWhtAmt: "+previousWhtAmt +"div:"+div+"  compartresult:"+compareResult);
			  if(!compareStatus){
				  // Error message EL0039
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0039"), ""));
					//reCalculatePaymentDetailConclution();
					paymentDetail.setWhtAmt(previousWhtAmt);
			  }else{	
				  paymentDetail.setWhtAmt(currentWhtAmt);
				 // semmel006Bean.setPreviosWhtAmt(currentWhtAmt);
			  }
			  
			  logger.debug(" whtAmt: "+currentWhtAmt);
			  
			 // doChangeWhtType5();
		} 
	}	
	
	public void doChangeWhtAmt5( ){	
		logger.debug(" doChangeWhtAmt5");
		semmel006Bean = getSemmel006Bean();	 
		PaymentDetail paymentDetail = semmel006Bean.getPaymentDetail();			

		BigDecimal currentWhtAmt =  paymentDetail.getWhtAmt()==null?new BigDecimal(0):paymentDetail.getWhtAmt().setScale(3,BigDecimal.ROUND_HALF_DOWN);
		BigDecimal previousWhtAmt =  semmel006Bean.getPreviosWhtAmt()==null?new BigDecimal(0):semmel006Bean.getPreviosWhtAmt().setScale(3,BigDecimal.ROUND_HALF_DOWN);
		
		BigDecimal whtRate = paymentDetail.getWhtRate()==null?new BigDecimal(0):paymentDetail.getWhtRate();
		BigDecimal payAmt =  paymentDetail.getPayAmt()==null?new BigDecimal(0):paymentDetail.getPayAmt().setScale(3,BigDecimal.ROUND_DOWN);
		//BigDecimal previousVatAmt =  ELUtils.getVatAmtFromTotalPay(payAmt);
		//BigDecimal previousWhtAmt = getWhtAmt()
		if(currentWhtAmt.intValue()==0){
			
		}else{
			  boolean compareStatus = true;
			  BigDecimal div= previousWhtAmt.subtract(currentWhtAmt);
			  int compareResult = 0;
			  //previousVatAmt>currentvatAmt
			  if(previousWhtAmt.compareTo(currentWhtAmt)==1){				  
				  compareResult =  div.compareTo(new BigDecimal(1));
				  if(compareResult==1){
					  compareStatus =false;
				  }
				//previousVatAmt<currentvatAmt
			  }else if (previousWhtAmt.compareTo(currentWhtAmt)==-1){
				  compareResult =  div.compareTo(new BigDecimal(-1));
				  if(compareResult==-1){
					  compareStatus =false;
				  }
				//previousVatAmt==currentvatAmt
			  }else if(previousWhtAmt.compareTo(currentWhtAmt)==0){
				  
			  }		  
			  
			  logger.debug(" currentWhtAmt "+currentWhtAmt +"previousWhtAmt: "+previousWhtAmt +"div:"+div+"  compartresult:"+compareResult);
			  if(!compareStatus){
				  // Error message EL0039
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0039"), ""));
					//reCalculatePaymentDetailConclution();
					paymentDetail.setWhtAmt(previousWhtAmt);
			  }else{	
				  paymentDetail.setWhtAmt(currentWhtAmt);
				  //semmel006Bean.setPreviosWhtAmt(currentWhtAmt);
			  }
			  
			  doChangeWhtType5();
		} 
	}	
	
	public boolean doChangePaymentWhtType6(){		
		
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			Payment payment = semmel006Bean.getPayment();
			String whtType = payment.getWhtType();
			logger.debug(" -- doChangePaymentWhtType6-- to :"+whtType);
			
			BigDecimal exVatAmt = payment.getExcludeVatAmt()==null?new BigDecimal(0):payment.getExcludeVatAmt();
			BigDecimal whtAmt = payment.getWhtAmt()==null?new BigDecimal(0):payment.getWhtAmt();
			BigDecimal vatAmt = payment.getVatAmt()==null?new BigDecimal(0):payment.getVatAmt();
			BigDecimal payAmt = payment.getPayAmt()==null?new BigDecimal(0):payment.getPayAmt();

			logger.debug(" exVatAmt :"+exVatAmt+" whtAmt:"+whtAmt+" vatAmt:"+vatAmt);
		
			BigDecimal chqAmt = new BigDecimal(0);
			// 01 �ѡ���� (��� Absorb) �ӹǳ�ҡ -> (�ӹǹ�Թ��͹ VAT � WHT Amount) + �ӹǹ�Թ VAT
			if("01".equals(whtType)){
				chqAmt = exVatAmt.subtract(whtAmt).add(vatAmt);
			//	02: ����ѡ���� (Absorb)
			}else if("02".equals(whtType)){
				chqAmt = exVatAmt.add(vatAmt);
			//	03: ����������� 
			}else if("03".equals(whtType)){
				chqAmt = exVatAmt.add(vatAmt);
			}else{
				chqAmt = payAmt;
			}
			
			payment.setChqAmt(chqAmt);
			

		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return flagValid;			
	}
	public boolean doChangeWhtType5(){		
		
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			String whtType = semmel006Bean.getPaymentDetail().getWhtType();
			logger.debug(" -- doChangeWhtType 5-- to :"+whtType);
			 
			BigDecimal exVatAmt = semmel006Bean.getPaymentDetail().getExcludeVatAmt()==null?new BigDecimal(0):semmel006Bean.getPaymentDetail().getExcludeVatAmt();
			BigDecimal whtAmt = semmel006Bean.getPaymentDetail().getWhtAmt()==null?new BigDecimal(0):semmel006Bean.getPaymentDetail().getWhtAmt();
			BigDecimal vatAmt = semmel006Bean.getPaymentDetail().getVatAmt()==null?new BigDecimal(0):semmel006Bean.getPaymentDetail().getVatAmt();
			BigDecimal payAmt = semmel006Bean.getPaymentDetail().getPayAmt()==null?new BigDecimal(0):semmel006Bean.getPaymentDetail().getPayAmt();

			logger.debug(" 555 exVatAmt :"+exVatAmt+" whtAmt:"+whtAmt+" vatAmt:"+vatAmt);
		
			BigDecimal chqAmt = new BigDecimal(0);
			// 01 �ѡ���� (��� Absorb) �ӹǳ�ҡ -> (�ӹǹ�Թ��͹ VAT � WHT Amount) + �ӹǹ�Թ VAT
			if("01".equals(whtType)){
				chqAmt = exVatAmt.subtract(whtAmt).add(vatAmt);
			//	02: ����ѡ���� (Absorb)
			}else if("02".equals(whtType)){
				chqAmt = exVatAmt.add(vatAmt);
			//	03: ����������� 
			}else if("03".equals(whtType)){
				chqAmt = exVatAmt.add(vatAmt);
			}else{
				chqAmt = payAmt;
			}
			
			semmel006Bean.getPaymentDetail().setChqAmt(chqAmt);
			

		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return flagValid;			
	}	
	public boolean doChangeWhtType(){		
		
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			String whtType = semmel006Bean.getPaymentDetail().getWhtType();
			logger.debug(" -- doChangeWhtType-- to :"+whtType);
			 
			BigDecimal exVatAmt = semmel006Bean.getPaymentDetail().getExcludeVatAmt()==null?new BigDecimal(0):semmel006Bean.getPaymentDetail().getExcludeVatAmt();
			BigDecimal whtAmt = semmel006Bean.getPaymentDetail().getWhtAmt()==null?new BigDecimal(0):semmel006Bean.getPaymentDetail().getWhtAmt();
			BigDecimal vatAmt = semmel006Bean.getPaymentDetail().getVatAmt()==null?new BigDecimal(0):semmel006Bean.getPaymentDetail().getVatAmt();
			BigDecimal payAmt = semmel006Bean.getPaymentDetail().getPayAmt()==null?new BigDecimal(0):semmel006Bean.getPaymentDetail().getPayAmt();

			logger.debug(" exVatAmt :"+exVatAmt+" whtAmt:"+whtAmt+" vatAmt:"+vatAmt);
		
			BigDecimal chqAmt = new BigDecimal(0);
			// 01 �ѡ���� (��� Absorb) �ӹǳ�ҡ -> (�ӹǹ�Թ��͹ VAT � WHT Amount) + �ӹǹ�Թ VAT
			if("01".equals(whtType)){
				chqAmt = exVatAmt.subtract(whtAmt).add(vatAmt);
				logger.debug(" whtType--01 :"+ chqAmt);
							
			//	02: ����ѡ���� (Absorb)
			}else if("02".equals(whtType)){
				chqAmt = exVatAmt.add(vatAmt);
				logger.debug(" whtType--02 :"+ chqAmt);
			//	03: ����������� 
			}else if("03".equals(whtType)){
				chqAmt = exVatAmt.add(vatAmt);
				logger.debug(" whtType--03 :"+ chqAmt);
			}else{
				chqAmt = exVatAmt.add(vatAmt);
				logger.debug(" whtType--xx :"+ chqAmt);
			}
			
			semmel006Bean.getPaymentDetail().setChqAmt(chqAmt);
			

		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return flagValid;			
	}	
		
	//WT###Add 20110204 Start
	public boolean doRecalCulateVATPR62(){		
		logger.debug(" -- doRecalCulateVATPR--");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			Payment payment = semmel006Bean.getPayment();			
			boolean isWhtcheck = payment.isWhtCheckBoolean();
			String whtTypeValue = payment.getWhtType();	
			String vatType = payment.getVatType();;	
			logger.debug(" isWhtcheck:"+isWhtcheck+ " whtTypeValue:"+whtTypeValue);
			logger.debug(" vatType:"+vatType);
			
			
			BigDecimal totalPayAmt = new BigDecimal(0);
			BigDecimal totalWhtAmt = new BigDecimal(0);
			BigDecimal totalExVatAmt =  new BigDecimal(0);
			BigDecimal totalVatAmt = new BigDecimal(0);
			BigDecimal totalInVatAmt = new BigDecimal(0);
			BigDecimal totalChqAmt = new BigDecimal(0);
			
			BigDecimal totalSevenVatAmt = new BigDecimal(0);
			BigDecimal totalThreeVatAmt = new BigDecimal(0);
			

			BigDecimal payAmt = payment.getPayAmt()==null? new BigDecimal(0):payment.getPayAmt();						
			BigDecimal exVatAmt =  payment.getExcludeVatAmt()==null? new BigDecimal(0):payment.getExcludeVatAmt();					
			totalPayAmt = totalPayAmt.add(payAmt);

			
			if("01".equals(vatType)){
				totalExVatAmt = ELUtils.getExcludeVatFromTotalPay(totalPayAmt);
				totalVatAmt = ELUtils.getVatAmtFromTotalPay(totalPayAmt);
				totalInVatAmt =totalExVatAmt.add(totalVatAmt);
				semmel006Bean.setDisableInvTotalVat(false);
			// ������  VAT
			}else	if("02".equals(vatType)){
				totalExVatAmt = totalPayAmt;
				//totalVatAmt = new BigDecimal(0);
				totalVatAmt = ELUtils.getSevenVAtAmtFromOriginalPrice(totalPayAmt);
				totalInVatAmt =totalPayAmt.add(totalVatAmt);
				semmel006Bean.setDisableInvTotalVat(false);
			// ����� Vat 
			}else if("03".equals(vatType)){
				totalExVatAmt = totalPayAmt;
				totalVatAmt = new BigDecimal(0);
				totalInVatAmt =totalPayAmt;
				semmel006Bean.setDisableInvTotalVat(true);
			}		
			
			totalSevenVatAmt = ELUtils.getAmtPercent(totalPayAmt, new BigDecimal(7));	
			logger.debug(" isWhtcheck:"+isWhtcheck);
			totalChqAmt = totalInVatAmt;
			if(isWhtcheck){
				BigDecimal withholdingTax  = payment.getWhtRate()==null?new BigDecimal(0):payment.getWhtRate();	
				totalThreeVatAmt = ELUtils.getAmtPercent(totalPayAmt, withholdingTax);		
				
				logger.debug(" isWhtcheck is Check withholdingTax rate :"+withholdingTax);				
				totalWhtAmt = totalExVatAmt.multiply(withholdingTax).divide(new BigDecimal(100),2,BigDecimal.ROUND_HALF_UP);		
				//��� VAT 
				if("01".equals(whtTypeValue)){
					totalChqAmt = totalPayAmt.subtract(totalThreeVatAmt).add(totalThreeVatAmt).setScale(2,BigDecimal.ROUND_HALF_UP);
				// ��� ��� VAT 
				}else if("02".equals(whtTypeValue)){
					totalChqAmt = totalPayAmt.add(totalThreeVatAmt).setScale(2,BigDecimal.ROUND_HALF_UP);
				// ����� Vat 
				}else if("03".equals(whtTypeValue)){
					totalChqAmt = totalPayAmt.add(totalThreeVatAmt).setScale(2,BigDecimal.ROUND_HALF_UP);
				}					
				
				
			}else{
				logger.debug(" isWhtcheck is Not Check ");
				//totalChqAmt = totalPayAmt;
			}			
			
			logger.debug("  totalPayAmt:"+totalPayAmt);
			logger.debug(" totalWhtAmt :"+totalWhtAmt);
			logger.debug(" totalExVatAmt :"+totalExVatAmt);
			logger.debug(" totalVatAmt :"+totalVatAmt);
			logger.debug(" totalInVatAmt :"+totalInVatAmt);
			logger.debug(" totalChqAmt :"+totalChqAmt);
			
			payment.setInvTotalExcludeVat(totalExVatAmt);	
			payment.setInvTotalVat(totalVatAmt);
			payment.setInvTotalIncludeVat(totalInVatAmt);	
			semmel006Bean.setPreviosVatAmt(totalVatAmt);
			semmel006Bean.setPreviosWhtAmt(totalWhtAmt);
			
			
			doChangeWhtType();

		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return flagValid;			
	}	
	//WT###Add 20110204 End
	
	public boolean doRecalCulateVATPR(){		
		logger.debug(" -- doRecalCulateVATPR--");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			PaymentDetail paymentDetail = semmel006Bean.getPaymentDetail();
			Payment payment = semmel006Bean.getPayment();
			boolean isWhtcheck  = paymentDetail.isWhtCheckBoolean();
			String whtTypeValue = paymentDetail.getWhtType();	
			String vatType      = paymentDetail.getVatType();;	
			logger.debug(" isWhtcheck:"+isWhtcheck+ " whtTypeValue:"+whtTypeValue);
			
			logger.debug(" vatType  :"+vatType);
			logger.debug(" Unit Type------ 1:"+paymentDetail.getUnitVatType());
			//Start Momo
			
			//logger.debug(" Payment Type  :"+ payment.getPaymentType());
			//logger.debug(" Payment Method:"+ payment.getPaymentMethod());
			logger.debug(" Expense Type:"+ payment.getExpenseType());
		     paymentDetail.setUnitVatType(vatType);	
		     semmel006Bean.getPaymentDetail().setUnitVatType(vatType);
		     //semmel006Bean.getPayment().set
			logger.debug(" Unit Type ---- 2 :"+paymentDetail.getUnitVatType());
			
			//End Momoo
			
			
			BigDecimal totalPayAmt = new BigDecimal(0);
			BigDecimal totalWhtAmt = new BigDecimal(0);
			BigDecimal totalExVatAmt =  new BigDecimal(0);
			BigDecimal totalVatAmt = new BigDecimal(0);
			BigDecimal totalInVatAmt = new BigDecimal(0);
			BigDecimal totalChqAmt = new BigDecimal(0);
			
			BigDecimal totalSevenVatAmt = new BigDecimal(0);
			BigDecimal totalThreeVatAmt = new BigDecimal(0);
			

			BigDecimal payAmt = paymentDetail.getPayAmt()==null? new BigDecimal(0):paymentDetail.getPayAmt();						
			BigDecimal exVatAmt =  paymentDetail.getExcludeVatAmt()==null? new BigDecimal(0):paymentDetail.getExcludeVatAmt();					
			totalPayAmt = totalPayAmt.add(payAmt);

			
			if("01".equals(vatType)){
				totalExVatAmt = ELUtils.getExcludeVatFromTotalPay(totalPayAmt);
				totalVatAmt = ELUtils.getVatAmtFromTotalPay(totalPayAmt);
				totalInVatAmt =totalExVatAmt.add(totalVatAmt);
				semmel006Bean.setVatAmtDisable(false);
			
			}else	if("02".equals(vatType)){
				totalExVatAmt = totalPayAmt;
				//totalVatAmt = new BigDecimal(0);
				totalVatAmt = ELUtils.getSevenVAtAmtFromOriginalPrice(totalPayAmt);
				totalInVatAmt =totalPayAmt.add(totalVatAmt);
				semmel006Bean.setVatAmtDisable(false);
			
			}else if("03".equals(vatType)){
				totalExVatAmt = totalPayAmt;
				totalVatAmt = new BigDecimal(0);
				totalInVatAmt =totalPayAmt;
				semmel006Bean.setVatAmtDisable(true);
			}		
			
			totalSevenVatAmt = ELUtils.getAmtPercent(totalPayAmt, new BigDecimal(7));	
			logger.debug(" isWhtcheck:"+isWhtcheck);
			totalChqAmt = totalInVatAmt;
			if(isWhtcheck){
				BigDecimal withholdingTax  = paymentDetail.getWhtRate()==null?new BigDecimal(0):paymentDetail.getWhtRate();	
				totalThreeVatAmt = ELUtils.getAmtPercent(totalPayAmt, withholdingTax);		
				
				logger.debug(" isWhtcheck is Check withholdingTax rate :"+withholdingTax);
				logger.debug(" whtTypeValue :"+whtTypeValue);
				
				totalWhtAmt = totalExVatAmt.multiply(withholdingTax).divide(new BigDecimal(100),2,BigDecimal.ROUND_HALF_UP);
				
				//��� VAT 
				if("01".equals(whtTypeValue)){
					totalChqAmt = totalPayAmt.subtract(totalThreeVatAmt).add(totalThreeVatAmt).setScale(2,BigDecimal.ROUND_HALF_UP);
				// ��� ��� VAT 
				}else if("02".equals(whtTypeValue)){
					totalChqAmt = totalPayAmt.add(totalThreeVatAmt).setScale(2,BigDecimal.ROUND_HALF_UP);
				// ����� Vat 
				}else if("03".equals(whtTypeValue)){
					totalChqAmt = totalPayAmt.add(totalThreeVatAmt).setScale(2,BigDecimal.ROUND_HALF_UP);
				}					
				
				
			}else{
				logger.debug(" isWhtcheck is Not Check ");
				//totalChqAmt = totalPayAmt;
			}			
			
			//logger.debug("  totalPayAmt:"+totalPayAmt);
			//logger.debug(" totalWhtAmt :"+totalWhtAmt);
			//logger.debug(" totalExVatAmt :"+totalExVatAmt);
			//logger.debug(" totalVatAmt :"+totalVatAmt);
			//logger.debug(" totalInVatAmt :"+totalInVatAmt);
			//logger.debug(" totalChqAmt :"+totalChqAmt);
			
			paymentDetail.setPayAmt(totalPayAmt);
			paymentDetail.setWhtAmt(totalWhtAmt);
			paymentDetail.setExcludeVatAmt(totalExVatAmt);
			paymentDetail.setVatAmt(totalVatAmt);
			paymentDetail.setIncludeVatAmt(totalInVatAmt);
			paymentDetail.setChqAmt(totalChqAmt);
			semmel006Bean.setPreviosVatAmt(totalVatAmt);
			semmel006Bean.setPreviosWhtAmt(totalWhtAmt);
			
			//logger.debug(" Vat  Type------ xxx:"+paymentDetail.getVatType());
			//logger.debug(" Unit Type------:"+paymentDetail.getUnitVatType());
			
			doChangeWhtType();
			//logger.debug(" Vat  Type------ End Change:"+paymentDetail.getVatType());
			//logger.debug(" Unit Type------ End Change:"+paymentDetail.getUnitVatType());
			

		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return flagValid;			
	}	
		
	public BigDecimal getWhtAmt(){		
		logger.debug(" -- getWhtAmt--");
		BigDecimal returnBig = new BigDecimal(0);;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			PaymentDetail paymentDetail = semmel006Bean.getPaymentDetail();			
			boolean isWhtcheck = paymentDetail.isWhtCheckBoolean();
			String whtTypeValue = paymentDetail.getWhtType();	
			String vatType = paymentDetail.getVatType();;	
			logger.debug(" isWhtcheck:"+isWhtcheck+ " whtTypeValue:"+whtTypeValue);
			
			
			BigDecimal totalPayAmt = new BigDecimal(0);
			BigDecimal totalWhtAmt = new BigDecimal(0);
			BigDecimal totalExVatAmt =  new BigDecimal(0);
			BigDecimal totalVatAmt = new BigDecimal(0);
			BigDecimal totalInVatAmt = new BigDecimal(0);
			BigDecimal totalChqAmt = new BigDecimal(0);			
			BigDecimal totalSevenVatAmt = new BigDecimal(0);
			BigDecimal totalThreeVatAmt = new BigDecimal(0);			

			BigDecimal payAmt = paymentDetail.getPayAmt()==null? new BigDecimal(0):paymentDetail.getPayAmt();						
			BigDecimal exVatAmt =  paymentDetail.getExcludeVatAmt()==null? new BigDecimal(0):paymentDetail.getExcludeVatAmt();					
			totalPayAmt = totalPayAmt.add(payAmt);
			
			if("01".equals(vatType)){
				totalExVatAmt = ELUtils.getExcludeVatFromTotalPay(totalPayAmt);				
				totalInVatAmt =totalExVatAmt.add(totalVatAmt);
				
			// ����� Vat 
			}else if("03".equals(vatType)){
				totalExVatAmt = totalPayAmt;				
				totalInVatAmt =totalPayAmt;
				
			}		
			
			totalSevenVatAmt = ELUtils.getAmtPercent(totalPayAmt, new BigDecimal(7));	
			logger.debug(" isWhtcheck:"+isWhtcheck);
			totalChqAmt = totalPayAmt;
			if(isWhtcheck){
				BigDecimal withholdingTax  = paymentDetail.getWhtRate()==null?new BigDecimal(0):paymentDetail.getWhtRate();	
				totalThreeVatAmt = ELUtils.getAmtPercent(totalPayAmt, withholdingTax);								
				totalWhtAmt = totalExVatAmt.multiply(withholdingTax).divide(new BigDecimal(100),2,BigDecimal.ROUND_HALF_UP);		

				
			}		
			
		
			logger.debug(" totalWhtAmt :"+totalWhtAmt);

			returnBig = totalWhtAmt;
			
		

		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return returnBig;			
	}	
		
	public boolean doRecalCulateTotalVATPR(){		
		logger.debug(" -- doRecalCulateTotalVATPR--");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			Payment payment = semmel006Bean.getPayment();			
			boolean isWhtcheck = payment.isWhtCheckBoolean();
			String whtTypeValue = payment.getWhtType();	
			
			logger.debug(" isWhtcheck:"+isWhtcheck+ " whtTypeValue:"+whtTypeValue);
			List<PaymentDetail> paymentDetailList = semmel006Bean.getPaymentDetailList();
			
			
			BigDecimal totalPayAmt = new BigDecimal(0);
			BigDecimal totalWhtAmt = new BigDecimal(0);
			BigDecimal totalExVatAmt =  new BigDecimal(0);
			BigDecimal totalVatAmt = new BigDecimal(0);
			BigDecimal totalInVatAmt = new BigDecimal(0);
			BigDecimal totalChqAmt = new BigDecimal(0);
			
			BigDecimal totalSevenVatAmt = new BigDecimal(0);
			BigDecimal totalThreeVatAmt = new BigDecimal(0);
			
			if(paymentDetailList!=null &&paymentDetailList.size()>0){				
				for(PaymentDetail tmp:paymentDetailList){
					BigDecimal payAmt = tmp.getPayAmt()==null? new BigDecimal(0):tmp.getPayAmt();						
					BigDecimal exVatAmt =  tmp.getExcludeVatAmt()==null? new BigDecimal(0):tmp.getExcludeVatAmt();					
					totalPayAmt = totalPayAmt.add(payAmt);
					//totalExVatAmt = totalExVatAmt.add(exVatAmt);
				}

				
			}else{
				logger.debug(" Detail size < 0 , No calculation ");
			}			
			
			//��� VAT 
			if("01".equals(whtTypeValue)){
				totalExVatAmt = ELUtils.getExcludeVatFromVatRate(totalPayAmt);
				totalVatAmt = ELUtils.getVatFromVatRate(totalPayAmt);
				totalInVatAmt =totalExVatAmt.add(totalVatAmt);
			// ��� ��� VAT 
			}else if("02".equals(whtTypeValue)){
				totalExVatAmt = totalPayAmt;
				totalVatAmt = ELUtils.getNoVatFromVatRate(totalPayAmt);
				totalInVatAmt =totalExVatAmt.add(totalVatAmt);
			// ����� Vat 
			}else if("03".equals(whtTypeValue)){
				totalExVatAmt = totalPayAmt;
				totalVatAmt = new BigDecimal(0);
				totalInVatAmt =totalPayAmt;
			}				
			
			
			totalSevenVatAmt = ELUtils.getAmtPercent(totalPayAmt, new BigDecimal(7));
			
			if(isWhtcheck){
				BigDecimal withholdingTax  = payment.getWhtRate()==null?new BigDecimal(0):payment.getWhtRate();	
				totalThreeVatAmt = ELUtils.getAmtPercent(totalPayAmt, withholdingTax);				
				logger.debug(" isWhtcheck is Check withholdingTax rate :"+withholdingTax);				
				totalWhtAmt = totalExVatAmt.multiply(withholdingTax).divide(new BigDecimal(100),2,BigDecimal.ROUND_HALF_UP);		
				//��� VAT 
				if("01".equals(whtTypeValue)){
					totalChqAmt = totalPayAmt.subtract(totalThreeVatAmt).add(totalThreeVatAmt).setScale(2,BigDecimal.ROUND_HALF_UP);
				// ��� ��� VAT 
				}else if("02".equals(whtTypeValue)){
					totalChqAmt = totalPayAmt.add(totalThreeVatAmt).setScale(2,BigDecimal.ROUND_HALF_UP);
				// ����� Vat 
				}else if("03".equals(whtTypeValue)){
					totalChqAmt = totalPayAmt.add(totalThreeVatAmt).setScale(2,BigDecimal.ROUND_HALF_UP);
				}					
				
				
			}else{
				logger.debug(" isWhtcheck is Not Check ");
				totalChqAmt = totalPayAmt;
			}			
			
			logger.debug("  totalPayAmt:"+totalPayAmt);
			logger.debug(" totalWhtAmt :"+totalWhtAmt);
			logger.debug(" totalExVatAmt :"+totalExVatAmt);
			logger.debug(" totalVatAmt :"+totalVatAmt);
			logger.debug(" totalInVatAmt :"+totalInVatAmt);
			logger.debug(" totalChqAmt :"+totalChqAmt);
			
			payment.setPayAmt(totalPayAmt);
			payment.setWhtAmt(totalWhtAmt);
			payment.setExcludeVatAmt(totalExVatAmt);
			payment.setVatAmt(totalVatAmt);
			payment.setIncludeVatAmt(totalInVatAmt);
			payment.setChqAmt(totalChqAmt);

			

		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return flagValid;			
	}	
		
	
	
	
	// ------------------ End PR_Prepaid ----------------

	private boolean doClearSession() {
		logger.debug("   ---------doClearSession ------------");
		boolean flag = true;
		try{
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flag;
	}

	private boolean doBackSearchPage() {
		logger.debug("   ---------doBackSearchPage ------------");
		boolean flag = false;
		try{			
			 
			semmel006Bean = getSemmel006Bean();
			semmel006Bean.setCompanyList(CompanyCacheUtil.getInstance().getCompanySelItemsALL());
			semmel006Bean.setElectricUseTypeList(ELUtils.filterLOVByLOVValue("4", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name)));
			semmel006Bean.setElExpenseTypeList(ELUtils.filterLOVByLOVValue("3", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name)));		
			semmel006Bean.setElDocTypeList(ELUtils.filterLOVByLOVValue("3", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DOC_TYPE.name)));			
			semmel006Bean.setCtPaymentTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_TYPE.name));	
			semmel006Bean.setCtPaymentMethodList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name));			
			semmel006Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
			semmel006Bean.setSearchDisplayMode(semmel006Bean.getCriteria().getExpenseType());
			semmel006Bean.setMonthList(ELUtils.getMonthDropDownList());
			semmel006Bean.setYearList(ELUtils.getYearDropDownList());
			semmel006Bean.setRecordStatusList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_OUTSTANDING_FLAG.name));	
			changeElectricUseType();
			flag= true;			
		}catch(Exception ex){
			ex.printStackTrace();
		}		

		return flag;
	}
	private boolean validateSearch() {
		logger.debug(" -- validateSearch--");
		boolean flagValid = false;
		try{
			logger.debug("  getSemmel006Bean().getCriteria().getContractNo():"+getSemmel006Bean().getCriteria().getContractNo());
			if(getSemmel006Bean().getCriteria().getContractNo()==null||getSemmel006Bean().getCriteria().getContractNo().trim().length()==0){
				logger.debug(" getSemmel006Bean().getCriteria().getContractNo()  null ,So validate require field ");
				if (StringUtils.isEmpty(getSemmel006Bean().getCriteria().getCompany())) {
					FrontMessageUtils.addMessageError( 
							SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.company")));
					flagValid = true;
				}
				if (StringUtils.isEmpty(getSemmel006Bean().getCriteria().getExpenseType())) {
					FrontMessageUtils.addMessageError( 
							SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.expenseType")));
					flagValid = true;
				}
				if (StringUtils.isEmpty(getSemmel006Bean().getCriteria().getElectricUseType())) {
					FrontMessageUtils.addMessageError( 
							SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.electricUseType")));
					flagValid = true;
				}			
			}else{
				logger.debug(" getSemmel006Bean().getCriteria().getContractNo() not null So Not validate require field ");
			}
						
		}catch(Exception ex){
			ex.printStackTrace();
		}		

		

		return flagValid;
	}

	
	private boolean validatedoSearchPopupOldDoc() {
		
		boolean flagValid = false;
		try{
			semmel006Bean = getSemmel006Bean();	 
			//logger.debug(" --  validatedoSearchPopupOldDoc -- :"+BeanUtils.getBeanString(semmel006Bean.getPopupOldDocCriteria()));
			if (StringUtils.isEmpty(semmel006Bean.getPopupOldDocCriteria().getDocNo())) {
				FrontMessageUtils.addMessageError( 
						SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.docNo")));
				flagValid = true;
			}
			if ( semmel006Bean.getPopupOldDocCriteria().getFromDocDt()==null)  {
				FrontMessageUtils.addMessageError( 
						SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.fromDocDt")));
				flagValid = true;
			}
			if ( semmel006Bean.getPopupOldDocCriteria().getToDocDt()==null)  {
				FrontMessageUtils.addMessageError( 
						SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.toDocDt")));
				flagValid = true;
			}				
		}catch(Exception ex){
			ex.printStackTrace();
		}
	
		return flagValid;
	}

		
	
	private boolean validateAddNotExpenseSite() {
	
		boolean flagValid = false;
		try{
			semmel006Bean = getSemmel006Bean();	 
			//logger.debug(" -- validateAddNotExpenseSitex-- :"+BeanUtils.getBeanString(semmel006Bean.getNotExpenseSite()));
			
			//logger.debug(" semmel006Bean.getNotExpenseSite().getInvNo():"+semmel006Bean.getNotExpenseSite().getInvNo());
			//logger.debug(" semmel006Bean.getNotExpenseSite().getTermOfPaymentDtMonth():"+semmel006Bean.getNotExpenseSite().getTermOfPaymentDtMonth());
			//logger.debug(" semmel006Bean.getNotExpenseSite().getTermOfPaymentDtYear():"+semmel006Bean.getNotExpenseSite().getTermOfPaymentDtYear());
			
			
			
			if (StringUtils.isEmpty(semmel006Bean.getNotExpenseSite().getMeterId())) {
				FrontMessageUtils.addMessageError( 
						SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.invMeterId")));
				flagValid = true;
			}
			if (semmel006Bean.getNotExpenseSite().getInvNo().intValue()==0) {
				FrontMessageUtils.addMessageError( 
						SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.invNo")));
				flagValid = true;
			}
			/*
			if (StringUtils.isEmpty(semmel006Bean.getNotExpenseSite().getInvDocNo())) {		
				FrontMessageUtils.addMessageError( 
						SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.invDocNo")));
				flagValid = true;
			}		
			*/
			if (StringUtils.isEmpty(semmel006Bean.getNotExpenseSite().getTermOfPaymentDtMonth())||StringUtils.isEmpty(semmel006Bean.getNotExpenseSite().getTermOfPaymentDtYear())) {
				FrontMessageUtils.addMessageError( 
						SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.noExpenseTermOfPaymentDt")));
				flagValid = true;
			}
			
			if (semmel006Bean.getNotExpenseSite().getPayAmt().intValue()==0) {			
				FrontMessageUtils.addMessageError( 
						SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.payAmt")));
				flagValid = true;
			}
			if (semmel006Bean.getNotExpenseSite().getInvExcludeVatAmt().intValue()==0) {			
				FrontMessageUtils.addMessageError( 
						SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.invExcludeVatAmt")));
				flagValid = true;
			}
			
			if (semmel006Bean.getNotExpenseSite().getInvVatAmt().intValue()==0 
				&& ( semmel006Bean.getNotExpenseSite().getVatType() == "01" 
					|| semmel006Bean.getNotExpenseSite().getVatType() == "02" )) {
				FrontMessageUtils.addMessageError( 
						SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.invVatAmt")));
				flagValid = true;
			}
			
			if (semmel006Bean.getNotExpenseSite().getInvIncludeVatAmt().intValue()==0) {
				FrontMessageUtils.addMessageError( 
						SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.invIncludeVatAmt")));
				flagValid = true;
			}
			
			logger.debug(" New VAT:"+ semmel006Bean.getNotExpenseSite().getInvVatAmt());
			logger.debug(" Old VAT:"+semmel006Bean.getNotExpenseSite().getVatAmt());
			logger.debug(" VAT Type:"+semmel006Bean.getNotExpenseSite().getVatType());
			
			double newVatAmt = semmel006Bean.getNotExpenseSite().getInvVatAmt().doubleValue();
			double oldVatAmt = semmel006Bean.getNotExpenseSite().getVatAmt().doubleValue();
			double diffVatAmt = 0;
			
			if(newVatAmt>oldVatAmt){
				diffVatAmt = newVatAmt-oldVatAmt;
				logger.debug(" New VAT - old Vat" + diffVatAmt);	
			}
			else if(oldVatAmt > newVatAmt){
				diffVatAmt = oldVatAmt -newVatAmt;
				logger.debug(" New VAT - old Vat" + diffVatAmt);	
			}
			
			if (diffVatAmt > 1.0) {
				FrontMessageUtils.addMessageError( 
						SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.changeVatAmtLimitExceed")));
				flagValid = true;
			}
			
		}catch(Exception ex){
			
			ex.printStackTrace();
			return flagValid = true;
		}
	
		return flagValid;
	}

	private boolean validateCheckMeterExist() {
		
		boolean flagValid =false;
		try{
			semmel006Bean = getSemmel006Bean();	 
			if (StringUtils.isEmpty(semmel006Bean.getNotExpenseSite().getMeterId())) {
				FrontMessageUtils.addMessageError( 
						SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.invMeterId")));
				flagValid = true;
			}
			}catch(Exception ex){
				ex.printStackTrace();
			}
		
			return flagValid;
		}
		
	private boolean doSearch() {
		logger.debug(" -- doSearch --");
		boolean flag = false;		
	
		try {
			if (validateSearch()) {
				return flag;
			}			
			semmel006Bean = getSemmel006Bean();			
			IPaymentService service = (IPaymentService)getBean("paymentService");
			List  <PaymentSearch> pamentSearchResult = null;			

			logger.debug(" company:"+semmel006Bean.getCriteria().getCompany());
			logger.debug(" contractNo:"+semmel006Bean.getCriteria().getContractNo());
			logger.debug(" siteName:"+semmel006Bean.getCriteria().getSiteName());
			logger.debug(" electricUseType:"+semmel006Bean.getCriteria().getElectricUseType());
			logger.debug(" expenseType:"+semmel006Bean.getCriteria().getExpenseType());
			logger.debug(" region:"+semmel006Bean.getCriteria().getRegion());
			logger.debug(" meterId:"+semmel006Bean.getCriteria().getMeterId());
			logger.debug(" locationId:"+semmel006Bean.getCriteria().getLocationId());
			logger.debug(" locationCode:"+semmel006Bean.getCriteria().getLocationCode());
			logger.debug(" fromTermOfPaymentDt:"+semmel006Bean.getCriteria().getFromTermOfPaymentDt());
			logger.debug(" toTermOfPaymentDt:"+semmel006Bean.getCriteria().getToTermOfPaymentDt());			
			logger.debug(" picoCell:"+semmel006Bean.getCriteria().isSiteTypeBoolean());
			
			
			if(!StringUtils.isEmpty(semmel006Bean.getCriteria().getSiteType())&&semmel006Bean.getCriteria().getSiteType().equalsIgnoreCase("Y")){	
			//if(semmel006Bean.getCriteria().isSiteTypeBoolean()==true){
				logger.info(" picocell ==Y");
				semmel006Bean.getCriteria().setSiteType("02");						
				semmel006Bean.getCriteria().setSiteTypeBoolean(true);
			}else{
				logger.info(" picocell ==N");
				semmel006Bean.getCriteria().setSiteType(null);
				semmel006Bean.getCriteria().setSiteTypeBoolean(false);
			}
			
			logger.debug(" siteType:"+semmel006Bean.getCriteria().getSiteType());			
			
			
			if("EL_BILL".equalsIgnoreCase(semmel006Bean.getCriteria().getExpenseType())){
				logger.debug("  Search EL_BILL ");						
				pamentSearchResult = service.queryByCriteriaEL_BILL(semmel006Bean.getCriteria());
				for(PaymentSearch tmp:pamentSearchResult){
					ELUtils.setPamentSearchDisplayField(  tmp);
				}
			}else{
				logger.debug("  Search Not EL_BILL ");				
				pamentSearchResult = service.searchPayment(semmel006Bean.getCriteria());	
				

				
				
				
			}
			
			
			
			
			if (null == pamentSearchResult || pamentSearchResult.isEmpty()) {
				logger.debug(" --pamentSearchResult null or empty set not found");
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("M0004"), ""));
				semmel006Bean.setResultList(new ArrayList());
				semmel006Bean.setExpenseType(null);
			}else{
				
				logger.debug(" --pamentSearchResult not empty set display");
				for(PaymentSearch tmp:pamentSearchResult){		
					semmel006Bean.setExpenseType(StringUtils.isEmpty(semmel006Bean.getCriteria().getExpenseType())?tmp.getExpenseType():semmel006Bean.getCriteria().getExpenseType());
					
					if(tmp.getEffectiveDt()!=null){
						tmp.setEffectiveDt(SEMDataUtility.convertToThYear(tmp.getEffectiveDt()));
					}
					if(tmp.getExpireDt()!=null){
						tmp.setExpireDt(SEMDataUtility.convertToThYear(tmp.getExpireDt()));
					}
				}
				
				semmel006Bean.setResultList(pamentSearchResult);
				
			/*	
				if("EL_BILL".equalsIgnoreCase(semmel006Bean.getCriteria().getExpenseType())){
					List<PaymentSearch> payResultList = new ArrayList();
					for(PaymentSearch paySearchTmp:pamentSearchResult){
						if("N".equalsIgnoreCase(paySearchTmp.getDetailFlag())){
							payResultList.add(paySearchTmp);
						}
					}
					semmel006Bean.setResultList(payResultList);
				}else{
					semmel006Bean.setResultList(pamentSearchResult);
				}
				*/
										
			}
			logger.debug(" --semmel006Bean.getExpenseType  before display:"+semmel006Bean.getExpenseType());
			semmel006Bean.setSearchDisplayMode(semmel006Bean.getCriteria().getExpenseType());	
			setSemmel006Bean(semmel006Bean);
		} catch (Exception e) {
			logger.debug(" -- error :"+e);
			e.printStackTrace();
		}		
		return flag;
	}
	
	//WT###Add20110114 Start
	private boolean doEditFromMenu8(){
		logger.info("START Action doEditFromMenu8");	
		boolean flagValid = false;	
		
		try{
			init();
			initAddNewSite();
			
			semmel006Bean = getSemmel006Bean();
			semmel006Bean.setViewMode(false);
			semmel006Bean.setComeFromPage8(true);
			semmel006Bean.setSpecialExpenseSite(new PaymentDetail());
			
			String modeView = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("modeView");
			String targetPaymentId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("targetPayment");
			
			String outstandingFlag = getFacesUtils().getRequestParameter("outstandingFlag") == null ? "" : (String)getFacesUtils().getRequestParameter("outstandingFlag");
			
			if(StringUtils.equals("Y", outstandingFlag)){
				semmel006Bean.setComeFromPage9(true);
				semmel006Bean.setComeFromPage8(false);
			}else{
				semmel006Bean.setComeFromPage9(false);
			}
			
			logger.debug("WT### targetPaymentId :"+targetPaymentId);			
			
			IPaymentService service = (IPaymentService)getBean("paymentService");			
			Payment returnpayment = service.queryPaymentByRowId(targetPaymentId);			
			//logger.debug(" payment after search:"+BeanUtils.getBeanString(returnpayment));		
			
			Payment payment = returnpayment;
			Set paymetSet = payment.getDetails();
			List detailList = new ArrayList();
			List specialdetailList = new ArrayList();
			
			if(paymetSet!=null){
				Object [] detailarray = paymetSet.toArray();
				for(Object tmp:detailarray){
					PaymentDetail tmpdetail = (PaymentDetail)tmp;
					tmpdetail.setMeterId(tmpdetail.getInvMeterId());
					
					if(tmpdetail.getDetailFlag().equalsIgnoreCase("N")){
						
						detailList.add(tmpdetail);
					}
					else{
						//tmpdetail.setDeleted(true);
						semmel006Bean.setSpecialExpenseSite(tmpdetail);
					}
					
				}				
			}			
			ELUtils.setPamentDisplayField(payment);
			
			payment.setPayAmt(payment.getInvPayAmt());
			
			
			semmel006Bean.setPayment(payment);
			
			//ADD CHECK PAYMENT METHOD 19/12/2013
			String paymentType = payment.getPaymentType();
			String paymentMethod = payment.getPaymentMethod();
			if(paymentType!=null){
				//01		
				if(ELUtils.PAYMENT_TYPE_01.equals(paymentType)){				
					semmel006Bean.setCtPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name,EX_AND,"CHEQUE",null,null));
				//02
				}else if (ELUtils.PAYMENT_TYPE_02.equals(paymentType)){
					semmel006Bean.setCtPaymentMethodList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name));
					if(StringUtils.equalsIgnoreCase("05", paymentMethod)){
						semmel006Bean.setPaymentMethodDisable(true);
					}
				}else{
					semmel006Bean.setCtPaymentMethodList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name));
					if(StringUtils.equalsIgnoreCase("06", paymentMethod)){
						semmel006Bean.setPaymentMethodDisable(true);
					}
				}				
			}	
			
			
			semmel006Bean.setNotExpenseSiteList(detailList);			
			semmel006Bean.setPaymentDetailList(detailList);
			semmel006Bean.setNotExpenseSiteListSize(semmel006Bean.getNotExpenseSiteList().size());
			
			semmel006Bean.setElectricUseTypeList( LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name) );			
			semmel006Bean.setElExpenseTypeList(  LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name) );		
			semmel006Bean.setElDocTypeList( LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DOC_TYPE.name) );
			//payment.setExpenseTypeDisplay(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name), "EL_BILL"));	

			PopupSiteSearch popupSiteCriteria = new PopupSiteSearch();					
			
			String meterId =ELUtils.getMeterId(payment);		
			String contractNo= returnpayment.getContractNo();
			PopupSiteSearch searchSiteView = new PopupSiteSearch();
			searchSiteView.setMeterId(meterId);
			searchSiteView.setContractNo(contractNo);
			
			logger.debug(" :"+semmel006Bean.getExpenseType());
			if(!(ELUtils.EL_BILL.equalsIgnoreCase(semmel006Bean.getExpenseType()))){
				List <PopupSiteSearch> popupSiteResultList= service.searchSite(searchSiteView,"querySiteELPostpaid");
				logger.debug(" Result Search :"+popupSiteResultList);					
				if (popupSiteResultList != null && !popupSiteResultList.isEmpty()) {
					popupSiteCriteria = popupSiteResultList.get(0);
				}				
			}else{
				ELUtils.copyPaymentToPopupSiteSearch(payment, popupSiteCriteria);				
			}					

			semmel006Bean.setPopupSiteCriteria(popupSiteCriteria);
			semmel006Bean.setDisabledBtnExport(true);
			if(StringUtils.equalsIgnoreCase("view", modeView)){
				semmel006Bean.setViewMode(true);
			}
			//semmel006Bean.setViewMode(true);
			
			flagValid = true;
			logger.info("END Action doEditFromMenu8");	
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flagValid;	
	}
	//WT###Add20110114 End
	
	private boolean doShow() {
		logger.info("START Action doShow");	
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();				
			String viewRowNumber = (String)getFacesUtils().getRequestParameter("viewRowNumber");
			int viewRowNumberInt = Integer.parseInt(viewRowNumber)-1;
			logger.debug(" viewRowNumber:"+viewRowNumber);			
			List paymentSearchlist = semmel006Bean.getResultList();			
			PaymentSearch paymentView = (PaymentSearch)paymentSearchlist.get(viewRowNumberInt);
			logger.debug(" payment Id :"+paymentView.getPaymentId());			
			
			IPaymentService service = (IPaymentService)getBean("paymentService");			
			Payment returnpayment = service.queryPaymentByRowId(paymentView.getPaymentId());			
			//logger.debug(" payment after search:"+BeanUtils.getBeanString(returnpayment));		
			
			Payment payment = returnpayment;
			if (payment.getCreateDt()!=null){
				payment.setDisplayCreateDate(SEMDataUtility.convertToThYear(payment.getCreateDt()));
			}
			if (payment.getUpdateDt()!=null){
				payment.setDisplayUpdateDate(SEMDataUtility.convertToThYear(payment.getUpdateDt()));
			}
			Set paymetSet = payment.getDetails();
			List detailList = new ArrayList();
			if(paymetSet!=null){
				Object [] detailarray = paymetSet.toArray();
				for(Object tmp:detailarray){
					PaymentDetail tmpdetail = (PaymentDetail)tmp;
					if(tmpdetail.getDetailFlag().equalsIgnoreCase("N")){
						ELUtils.setPamentDetailDisplayField(tmpdetail);
						detailList.add(tmp);
					}
				}				
			}			
			ELUtils.setPamentDisplayField(payment);
			semmel006Bean.setPayment(payment);
			semmel006Bean.setNotExpenseSiteList(detailList);			
			semmel006Bean.setPaymentDetailList(detailList);
			
			semmel006Bean.setElectricUseTypeList( LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name) );			
			semmel006Bean.setElExpenseTypeList(  LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name) );		
			semmel006Bean.setElDocTypeList( LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DOC_TYPE.name) );
			//payment.setExpenseTypeDisplay(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name), "EL_BILL"));	

			PopupSiteSearch popupSiteCriteria = new PopupSiteSearch();					
			
			String meterId =ELUtils.getMeterId(payment);		
			String contractNo= paymentView.getContractNo();
			PopupSiteSearch searchSiteView = new PopupSiteSearch();
			searchSiteView.setMeterId(meterId);
			searchSiteView.setContractNo(contractNo);
			
			logger.debug(" :"+semmel006Bean.getExpenseType());
			if(!(ELUtils.EL_BILL.equalsIgnoreCase(semmel006Bean.getExpenseType()))){
				List <PopupSiteSearch> popupSiteResultList= service.searchSite(searchSiteView,"querySiteELPostpaid");
				logger.debug(" Result Search :"+popupSiteResultList);					
				if (popupSiteResultList != null && !popupSiteResultList.isEmpty()) {
					popupSiteCriteria = popupSiteResultList.get(0);
				}				
			}else{
				ELUtils.copyPaymentToPopupSiteSearch(payment, popupSiteCriteria);				
			}					

			semmel006Bean.setPopupSiteCriteria(popupSiteCriteria);
			semmel006Bean.setDisabledBtnExport(true);
			semmel006Bean.setViewMode(true);
			
			flagValid = true;
			logger.info("END Action doShow");	
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flagValid;	
	}		
	 
	private boolean doShow2() {
		logger.info("START Action doShow 2 ");	
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	
			semmel006Bean.setPaymentDetail(new PaymentDetail());
			setPopupVendorSupplierBean(new PopupVendorSupplierBean()); //ADD BY NOOM
			popupVendorSupplierBean.setProvinceList(new ArrayList<SelectItem>());
			String viewRowNumber = (String)getFacesUtils().getRequestParameter("viewRowNumber");
			int viewRowNumberInt = Integer.parseInt(viewRowNumber)-1;			
			List paymentSearchlist = semmel006Bean.getResultList();			
			PaymentSearch paymentView = (PaymentSearch)paymentSearchlist.get(viewRowNumberInt);				
			IPaymentService service = (IPaymentService)getBean("paymentService");			
			Payment returnpayment = service.queryPaymentByRowId(paymentView.getPaymentId());			
			//logger.debug(" payment after search:"+BeanUtils.getBeanString(returnpayment));		
			
			Payment payment = returnpayment;
			Set paymetSet = payment.getDetails();
			if (payment.getCreateDt()!=null){
				payment.setDisplayCreateDate(SEMDataUtility.convertToThYear(payment.getCreateDt()));
			}
			if (payment.getUpdateDt()!=null){
				payment.setDisplayUpdateDate(SEMDataUtility.convertToThYear(payment.getUpdateDt()));
			}
			List detailList = new ArrayList();
			if(paymetSet!=null){
				Object [] detailarray = paymetSet.toArray();
				for(Object tmp:detailarray){
					PaymentDetail tmpdetail = (PaymentDetail)tmp;
					ELUtils.setPamentDetailDisplayField(tmpdetail);
					detailList.add(tmp);
				
				}				
			}			
			ELUtils.setPamentDisplayField(payment);
			semmel006Bean.setPayment(payment);
			semmel006Bean.setNotExpenseSiteList(detailList);			
			semmel006Bean.setPaymentDetailList(detailList);
			
			semmel006Bean.setElectricUseTypeList( LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name) );			
			semmel006Bean.setElExpenseTypeList(  LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name) );		
			semmel006Bean.setElDocTypeList( LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DOC_TYPE.name) );
			semmel006Bean.setMeterIdList(ELUtils.getEmptyList());
			
			
			PopupSiteSearch popupSiteCriteria = new PopupSiteSearch();					
			
			String meterId =ELUtils.getMeterId(payment);		
			String contractNo= paymentView.getContractNo();
			PopupSiteSearch searchSiteView = new PopupSiteSearch();
			searchSiteView.setMeterId(meterId);
			searchSiteView.setContractNo(contractNo);
			
			
			logger.debug(" :"+semmel006Bean.getExpenseType());
			if(!(ELUtils.EL_BILL.equalsIgnoreCase(semmel006Bean.getExpenseType()))){
				List <PopupSiteSearch> popupSiteResultList= service.searchSite(searchSiteView,"querySiteELPostpaid");
				logger.debug(" Result Search :"+popupSiteResultList);					
				if (popupSiteResultList != null && !popupSiteResultList.isEmpty()) {
					popupSiteCriteria = popupSiteResultList.get(0);
				}				
			}else{
				ELUtils.copyPaymentToPopupSiteSearch(payment, popupSiteCriteria);				
			}					
			

			semmel006Bean.setPopupSiteCriteria(popupSiteCriteria);
			semmel006Bean.setDisabledBtnExport(true);
			semmel006Bean.setViewMode(true);
			
			flagValid = true;
			logger.info("END Action doShow");	
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flagValid;	
	}	

	private boolean doShowPage5() {
		logger.info("START Action doShowPage5  ");	
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();				
			String viewRowNumber = (String)getFacesUtils().getRequestParameter("viewRowNumber");
			int viewRowNumberInt = Integer.parseInt(viewRowNumber)-1;			
			List paymentSearchlist = semmel006Bean.getResultList();			
			PaymentSearch paymentView = (PaymentSearch)paymentSearchlist.get(viewRowNumberInt);				
			IPaymentService service = (IPaymentService)getBean("paymentService");			
			Payment returnpayment = service.queryPaymentByRowId(paymentView.getPaymentId());			
			//logger.debug(" payment after search:"+BeanUtils.getBeanString(returnpayment));		
			
			Payment payment = returnpayment;
			if (payment.getCreateDt()!=null){
				payment.setDisplayCreateDate(SEMDataUtility.convertToThYear(payment.getCreateDt()));
			}
			if (payment.getUpdateDt()!=null){
				payment.setDisplayUpdateDate(SEMDataUtility.convertToThYear(payment.getUpdateDt()));
			}
			Set paymetSet = payment.getDetails();
			List detailList = new ArrayList();
			if(paymetSet!=null){
				Object [] detailarray = paymetSet.toArray();
				for(Object tmp:detailarray){
					PaymentDetail tmpdetail = (PaymentDetail)tmp;	
					ELUtils.setPamentDetailDisplayField(tmpdetail);
					//logger.debug("Exclud Vat" 
					detailList.add(tmpdetail);	
					
				}				
			}			
			ELUtils.setPamentDisplayField(payment);
			logger.debug(" detailList size :"+detailList.size());
			semmel006Bean.setPayment(payment);
			semmel006Bean.setNotExpenseSiteList(detailList);			
			semmel006Bean.setPaymentDetailList(detailList);
			
			semmel006Bean.setElectricUseTypeList( LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name) );			
			semmel006Bean.setElExpenseTypeList(  LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name) );		
			semmel006Bean.setElDocTypeList( LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DOC_TYPE.name) );
			semmel006Bean.setMeterIdList(ELUtils.getEmptyList());			
			//PaymentDetail paymentDetail = new PaymentDetail();
			semmel006Bean.setPaymentDetail(new PaymentDetail());
			semmel006Bean.getPaymentDetail().setExcludeVatAmt(new BigDecimal(0));
			semmel006Bean.getPaymentDetail().setIncludeVatAmt(new BigDecimal(0));
			semmel006Bean.getPaymentDetail().setChqAmt(new BigDecimal(0));
			
			if(payment.getContractNo()!=null){
				IVendorMasterService vendorMasterService = (IVendorMasterService) getBean("vendorMasterService");
				List<String> vendorCodeList = vendorMasterService.getVendorCodeList(payment.getContractNo());
				
				if(vendorCodeList != null && !vendorCodeList.isEmpty()){
					semmel006Bean.setVendorIdList(setSelectItemList(vendorCodeList, false));
				}else{
					semmel006Bean.setVendorIdList(new ArrayList<SelectItem>());
				}
			}
			
			PopupSiteSearch popupSiteCriteria = new PopupSiteSearch();					
			String meterId =ELUtils.getMeterId(payment);		
			String contractNo= paymentView.getContractNo();			
			
			IManagementService managementService = (IManagementService)getBean("managementService");	
			List<Management>  manageList = managementService.queryManagementByContractNo06(contractNo);
			if(manageList!=null&&manageList.size()>0){
				int rowNumber =1;
				for(Management tmp: manageList){
					popupSiteCriteria.setRowNumber(""+rowNumber++);
					popupSiteCriteria.setElectricId(tmp.getRowId());					
					popupSiteCriteria.setContractNo(tmp.getContractNo());					
					popupSiteCriteria.setCompany(tmp.getCompany());
					popupSiteCriteria.setOldContractNo(tmp.getOldContractNo());
					popupSiteCriteria.setElectricUseType(tmp.getElectricUseType());
					popupSiteCriteria.setRecordStatus(tmp.getRecordStatus());
					popupSiteCriteria.setContractStartDt(tmp.getContractStartDt());
					popupSiteCriteria.setContractEndDt(tmp.getContractEndDt());
					popupSiteCriteria.setSiteName(tmp.getSiteName());
					popupSiteCriteria.setSiteStatus(tmp.getSiteStatus());
					popupSiteCriteria.setNetworkStatus(tmp.getNetworkStatus());
					popupSiteCriteria.setLocationId(tmp.getLocationId());
					popupSiteCriteria.setLocationCode(tmp.getLocationCode());
					popupSiteCriteria.setSiteInfoId(tmp.getSiteInfoId());
					popupSiteCriteria.setSiteType(tmp.getSiteType());
					popupSiteCriteria.setRegion(tmp.getRegion());	
					List<SelectItem> selectGroupList = getLovItemsByType(ELovType.EL_OWNER_GROUP.name);
					for(SelectItem select : selectGroupList){
						if(StringUtils.equalsIgnoreCase(select.getValue().toString(),tmp.getElOwnerGroup())){
							popupSiteCriteria.setOwnerGroupName(select.getLabel());
						}
					}
					ELUtils.setPopupSearchsiteDisplayField(popupSiteCriteria);
				}
			}	
			semmel006Bean.setPopupSiteCriteria(popupSiteCriteria);
			
			String electricIdSelected = payment.getElectricId().getRowId();
			logger.debug(" Load Meter Id list belong to electricId :"+electricIdSelected);
			IMeterInfoService meterInfoService = (IMeterInfoService)getBean("meterInfoService");
			MeterInfo meterSearch = new MeterInfo();
			meterSearch.setOutstandingFlag("Y");
			meterSearch.setRecordStatus("Y");
			Management electricId = new Management();
			electricId.setRowId(electricIdSelected);
			meterSearch.setElectricId(electricId);
			List <MeterInfo>  resultList = meterInfoService.queryMeterListForPayment(meterSearch);
			if(resultList!=null&&resultList.size()>0){
				logger.info(" Found MeterInfo list size :"+resultList.size());	
				MeterInfo meterTmp =  (MeterInfo)resultList.get(0);
				semmel006Bean.getPopupSiteCriteria().setMeterId(meterTmp.getMeterId());
				semmel006Bean.setMeterIdList(ELUtils.getMeterIdList(resultList));
				semmel006Bean.getPayment().setTotalMeterExpense(resultList.size());
				semmel006Bean.setMeterInfo(meterTmp);
			}else{
				semmel006Bean.setMeterIdList(ELUtils.getEmptyList());
				semmel006Bean.getPayment().setTotalMeterExpense(0);
				logger.info(" Not Found MeterInfo list");
			}			

			semmel006Bean.setViewMode(true);
			
			flagValid = true;
			logger.info("END Action doShow");	
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flagValid;	
	}		
	
	
	private boolean doClear() {
		logger.debug(" -- doClear--");
		boolean flag = false;
		try{
			semmel006Bean = getSemmel006Bean();
			PaymentSearch criteria = new PaymentSearch();
			semmel006Bean.setCriteria(criteria);
			semmel006Bean.setElExpenseTypeList(ELUtils.getEmptyList());
	
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flag;
	}
	


	
	private SEMMEL006Bean semmel006Bean;

	public SEMMEL006Bean getSemmel006Bean() {
		
		SEMMEL006Bean bean = (SEMMEL006Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmel006Bean");
		
		if(bean == null){
			
			bean = new SEMMEL006Bean();
			
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmel006Bean", bean);
		}
		
		//return (SEMMEL006Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmel006Bean");
		return bean;
	}

	public void setSemmel006Bean(SEMMEL006Bean semmel006Bean) {
		this.semmel006Bean = semmel006Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmel006Bean", semmel006Bean);
	}
	
	public void getRowIdOnClick() {		
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		logger.debug(" -- getRowIdOnClick rowId:"+rowId);
		getSemmel006Bean().setTmpRowId(rowId);
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearAllSessionNotUsed() {
		// TODO Auto-generated method stub
		super.clearAllSessionNotUsed();
	}
	

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

	public void doExportExcel(){
		logger.debug(" -- doExportExcel --");
		
		try{
			
			
			
			semmel006Bean = getSemmel006Bean();
			List<PaymentDetail> detailList = semmel006Bean.getNotExpenseSiteList();
			Payment payment = semmel006Bean.getPayment();
			String docNo    = "Data Not Found";
			logger.debug("payment.getDocNo():"+payment.getDocNo());
			
			if(payment.getDocNo() != null){
				docNo = payment.getDocNo();
				logger.debug("docNo():"+docNo);
				
			}
			HSSFWorkbook workbook = new HSSFWorkbook(this.getClass().getResourceAsStream("/resources/el/Export_NotExpenseSite.xls"));
			HSSFSheet worksheet = workbook.getSheetAt(0);
			HSSFRow row = worksheet.createRow(0);
			row.createCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.docNo")+docNo));	
			int rowIndex = 2;
			for(int i=0; i<detailList.size(); i++){
				PaymentDetail tmp =  (PaymentDetail)detailList.get(i);

					
					BigDecimal invNo = tmp.getInvNo()==null?new BigDecimal("0"):tmp.getInvNo();
					String invNoStr = invNo.intValue()+"";
			
					String invSiteName = tmp.getInvSiteName()==null?"":tmp.getInvSiteName();
					String invAreaCode = tmp.getInvAreaCode()==null?"":tmp.getInvAreaCode();
					String invMeterId = tmp.getMeterId()==null?"":tmp.getMeterId();
					String invTermOfPaymentDt = tmp.getInvTermOfPaymentDt()==null?"":ELUtils.getMonthYearFromDate(tmp.getInvTermOfPaymentDt());
					String invIncldeVat = tmp.getInvIncludeVatAmt()==null?"":ELUtils.getNumberToString(tmp.getInvIncludeVatAmt());
					String invAreaeName = tmp.getInvAreaName()==null?"":tmp.getInvAreaName();
					
					row = worksheet.createRow(rowIndex++);
					row.createCell((short)0).setCellValue(new HSSFRichTextString(String.valueOf(i+1)));										
					row.createCell((short)1).setCellValue(new HSSFRichTextString(invNoStr));										
					//row.createCell((short)1).setCellValue(new HSSFRichTextString(invSiteName));										
					row.createCell((short)2).setCellValue(new HSSFRichTextString(invAreaeName));					
					row.createCell((short)3).setCellValue(new HSSFRichTextString(invAreaCode));					
					row.createCell((short)4).setCellValue(new HSSFRichTextString(invMeterId));
					row.createCell((short)5).setCellValue(new HSSFRichTextString(invTermOfPaymentDt));
					row.createCell((short)6).setCellValue(new HSSFRichTextString(invIncldeVat));
			
			}
			
			worksheet.autoSizeColumn((short)0);
			worksheet.autoSizeColumn((short)1);
			worksheet.autoSizeColumn((short)2);
			worksheet.autoSizeColumn((short)3);
			worksheet.autoSizeColumn((short)4);
			worksheet.autoSizeColumn((short)5);

			HttpServletResponse res = FacesUtils.getInstance().getHttpResponse();   
			res.setContentType("application/vnd.ms-excel");   
			res.setHeader("Content-disposition",  "attachment;filename=NotExpenseSite.xls");   
          
            ServletOutputStream out = res.getOutputStream();   
     
            workbook.write(out);   
            out.flush();   
            out.close();   
       
            FacesContext faces = FacesContext.getCurrentInstance();   
            faces.responseComplete(); 

		}catch(Exception ex){
			ex.printStackTrace();
		}
	}	
	
	
	// Helper part
	private void initialData(){
		logger.debug(" initialData ");	
		semmel006Bean = getSemmel006Bean();			
		Payment payment = getInitailPayment();		
		PaymentDetail paymentDetail=getInitialPaymentDetail();		
		semmel006Bean.setPayment(payment);
		semmel006Bean.setPaymentDetail(paymentDetail);	
		setSemmel006Bean(semmel006Bean);
		
		PopupVendorSupplierBean	popupVendorSupplierBean = getPopupVendorSupplierBean();
		popupVendorSupplierBean.setPopupVendorSupplierSearchSP(new PopupVendorSupplierSearchSP());
		popupVendorSupplierBean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList());
		logger.debug(" popupVendorSupplierBean.getProvinceList().size() " +popupVendorSupplierBean.getProvinceList().size());
		setPopupVendorSupplierBean(popupVendorSupplierBean);
		
	}
	
	private PaymentDetail getInitialPaymentDetail(){
		
		SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");		
		PaymentDetail paymentDetail = new PaymentDetail();
		/*
		paymentDetail.setChqAmt(new BigDecimal(0));
		paymentDetail.setIncludeVatAmt(new BigDecimal(0));
		paymentDetail.setVatAmt(new BigDecimal(0));
		paymentDetail.setExcludeVatAmt(new BigDecimal(0));
		paymentDetail.setKwhTotal(new BigDecimal(0));
		paymentDetail.setlRead(new BigDecimal(0));
		paymentDetail.setpRead(new BigDecimal(0));		
		*/
		paymentDetail.setCreateBy(ssoBean.getUserName());
		paymentDetail.setCreateDt(Calendar.getInstance().getTime());
		//paymentDetail.setUpdateBy(ssoBean.getUserName());
		//paymentDetail.setUpdateDt(Calendar.getInstance().getTime());	
		return paymentDetail;
		
	}
	
	private Payment getInitailPayment(){
		SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
		Payment payment = new Payment();	
		payment.setCreateBy(ssoBean.getUserName());
		payment.setCreateDt(Calendar.getInstance().getTime());		
		return payment;
	}
	
	//WT###Add20110114 Start
	private String getNextNotExpenseByRowId(List<PaymentDetail> listIn){
		String rowIdStr = null;
		if(listIn==null||listIn.size()==0){			
		}else{
			int size = listIn.size();
			PaymentDetail detailTmp = (PaymentDetail)listIn.get(size-1);
			rowIdStr = detailTmp.getRowId();
		}
		return rowIdStr;
	}
	//WT###Add20110114 End
	
	private int getNextNotExpenseRowId(List<PaymentDetail> listIn){
		int maxRowReturn = 0;		
		if(listIn==null||listIn.size()==0){			
		}else{
			int size = listIn.size();
			PaymentDetail detailTmp = (PaymentDetail)listIn.get(size-1);
			String rowIdStr = detailTmp.getRowId();
			maxRowReturn = Integer.parseInt(rowIdStr)+1;
		}
		return maxRowReturn;
	}
	
	
	private List<PaymentDetail>  removeNotExpenseByRowId(List<PaymentDetail> listIn,String rowIdstr){			
		if(listIn==null||listIn.size()==0){			
			return listIn;
		}else{
			PaymentDetail tmp =null;
			for(PaymentDetail paytmp:listIn){			
				String rowIdStr = paytmp.getRowId();				
				if(rowIdstr.equalsIgnoreCase(rowIdStr)){					
					tmp = paytmp;
				}
			}			
			if(tmp!=null){
				listIn.remove(tmp);
			}

		}
		return listIn;
	}
	
	private List<PaymentDetail>  removePaymentByRowId(List<PaymentDetail> listIn,int rowIn){			
		if(listIn==null||listIn.size()==0){			
			return listIn;
		}else{
			PaymentDetail tmp =null;
			for(PaymentDetail paytmp:listIn){			
				int rowId = paytmp.getRowNumber();				
				if(rowId==rowIn){					
					tmp = paytmp;
				}
			}			
			if(tmp!=null){
				listIn.remove(tmp);
			}
		}
		return listIn;
	}
	
	protected final String elmsg(String key){
		return getELMessage().getMessage(key);
	}
	
	private String getValidateMessage(String key) {
		String msg = this.getMessage(key);
		if(msg != null){
			msg = msg.replaceAll(":", "");
		}else{
			msg = "Properties key[" +key+ "] not found.";
		}
		return msg;
	}
	
	protected final ELMessageUtil getELMessage(){
		return ELMessageUtil.getInstance();
	}
	
	public void changepPeriodType(){	
		
		try{			
			SEMMEL006Bean semmel006Bean = getSemmel006Bean();			
			String pPeriodType = semmel006Bean.getPopupSiteCriteria().getpPayPeriodType();
			logger.info(" changepPeriodType to :"+pPeriodType);
		}catch(Exception ex){			
			ex.printStackTrace();			
			addMessageError("EL0000", "SEMMEL006");
		}
	}
	
	public void paymentHistPopupInterface(){
	
		SEMMEL006Bean semmel006Bean = getSemmel006Bean();
		String contracNo = semmel006Bean.getPopupSiteCriteria().getContractNo();
		String meterId = semmel006Bean.getPopupSiteCriteria().getMeterId();
		
		logger.debug("  ## paymentHistPopupInterface contracNo:"+contracNo );
		logger.debug("  ## paymentHistPopupInterface Meter Id:"+meterId );
		
		if(StringUtils.isEmpty(contracNo)){
			FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("M0004"), ""));
			logger.debug("  ## paymentHistPopupInterface contracNo: Is Null"  );
			ArrayList<ManagementWrapper> histWrapper = new ArrayList<ManagementWrapper>();
			semmel006Bean.setPaymentHistoryWrapperList(histWrapper);
			
		}else{
			paymentHistPopupByMeter(contracNo,meterId);
		}
		
	}
	private void paymentHistPopup(String contractNo){
		logger.debug("  PaymentHist Popup contractNo:"+ contractNo);
		
		SEMMEL006Bean semmel006Bean = getSemmel006Bean();	
		try{
			semmel006Bean.setPaymentHistoryWrapperList(new ArrayList());
			IPaymentService paymentService = (IPaymentService)getBean("paymentService");
			Payment payment = new Payment();
			payment.setContractNo(contractNo);
			
			List<Payment> paymentList = paymentService.querySEMMELPaymentHistoryByCriteria(payment);
			
			IPaymentDetailService paymentDetailService = (IPaymentDetailService)getBean("paymentDetailService");
			logger.debug("  paymentDetailService:"+paymentDetailService ); 
			ArrayList<ManagementWrapper> histWrapper = new ArrayList<ManagementWrapper>();
			
			
			logger.debug("  paymentList:"+paymentList );	
			
			if(paymentList!=null && paymentList.size()>0){
				
				for(Payment pay : paymentList){
					ELUtils.setPamentDisplayField(pay);
			       
					//logger.debug("  pay :"+BeanUtils.getBeanString(pay) );	
					
					List<PaymentDetail> detailList = paymentDetailService.getPaymentDetailByPayment(pay);
					logger.debug("  detailList :"+detailList );	
					
					for(PaymentDetail detail : detailList){
						 ELUtils.setPamentDetailDisplayField(detail);
						//logger.debug("  detail :"+BeanUtils.getBeanString(detail) );	
						
						 ManagementWrapper wrapper = new ManagementWrapper(new Management());
						wrapper.setHistPayment(pay);
						wrapper.setHistPaymentDetail(detail);
						histWrapper.add(wrapper);
					}
				}
			}else{
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("M0004"), ""));

			}
			
					
			List<ManagementWrapper> temp = (List<ManagementWrapper>)histWrapper;
			semmel006Bean.setPaymentHistoryWrapperList(temp);
		}catch (Exception e) {
			e.printStackTrace();
			addMessageError("EL0000", "SEMMEL006");
		}
	}
	public void paymentHistPopupInterfaceByMeter(){
		logger.debug("  ## StartpaymentHistPopupInterfaceByMeter" );
		SEMMEL006Bean semmel006Bean = getSemmel006Bean();
		String contracNo = semmel006Bean.getPopupSiteCriteria().getContractNo();
		String meterId = semmel006Bean.getPopupSiteCriteria().getMeterId();
		
		logger.debug("  ## paymentHistPopupInterface contracNo:"+contracNo );
		logger.debug("  ## paymentHistPopupInterface Meter Id:"+meterId );
		
		if(StringUtils.isEmpty(contracNo)|| StringUtils.isEmpty(meterId) ){
			FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("M0004"), ""));
			ArrayList<ManagementWrapper> histWrapper = new ArrayList<ManagementWrapper>();
			semmel006Bean.setPaymentHistoryWrapperList(histWrapper);
			
		}else{
			paymentHistPopupByMeter(contracNo,meterId);
		}
		
	}
	private void paymentHistPopupByMeter(String contractNo,String meterId){
		SEMMEL006Bean semmel006Bean = getSemmel006Bean();	
		try{
			semmel006Bean.setPaymentHistoryWrapperList(new ArrayList());
			IPaymentService paymentService = (IPaymentService)getBean("paymentService");
			Payment payment = new Payment();
			payment.setContractNo(contractNo);
			
			List<Payment> paymentList = paymentService.querySEMMELPaymentHistoryByCriteria(payment);
			logger.debug("paymentList size = "+paymentList.size());
			IPaymentDetailService paymentDetailService = (IPaymentDetailService)getBean("paymentDetailService");
			//logger.debug("  paymentDetailService:"+paymentDetailService ); 
			ArrayList<ManagementWrapper> histWrapper = new ArrayList<ManagementWrapper>();
			
			
			//logger.debug("  paymentList:"+paymentList );	
			
			if(paymentList!=null && paymentList.size()>0){
				
				for(Payment pay : paymentList){
					ELUtils.setPamentDisplayField(pay);
			       
					//logger.debug("  pay :"+BeanUtils.getBeanString(pay) );	
					logger.debug("pay = "+pay.getRowId());
					pay.setPaymentId(pay.getRowId());
					List<PaymentDetail> detailList = paymentDetailService.getPaymentDetailByPayment(pay);
					
					logger.debug("  detailList :"+detailList.size() );	
					
					for(PaymentDetail detail : detailList){
						logger.debug("  ## paymentHistPopupInterface detail.getMeterInfoId():"+detail.getMeterInfoId() );
						logger.debug("  ## paymentHistPopupInterface Meter Id:"+meterId );
						if(meterId != null){
							if(meterId.equalsIgnoreCase(detail.getMeterInfoId()) || meterId.equalsIgnoreCase(detail.getMeterId())){
								logger.debug("  ## Match");
								//detail.getMeterId()
								ELUtils.setPamentDetailDisplayField(detail);
								//logger.debug("  detail :"+BeanUtils.getBeanString(detail) );	
							 	ManagementWrapper wrapper = new ManagementWrapper(new Management());
								wrapper.setHistPayment(pay);
								wrapper.setHistPaymentDetail(detail);
								histWrapper.add(wrapper);	
							}
							
						}else{
							ELUtils.setPamentDetailDisplayField(detail);
							//logger.debug("  detail :"+BeanUtils.getBeanString(detail) );	
						 	ManagementWrapper wrapper = new ManagementWrapper(new Management());
							wrapper.setHistPayment(pay);
							wrapper.setHistPaymentDetail(detail);
							histWrapper.add(wrapper);	
						}
						
					}
				}
			}else{
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("M0004"), ""));

			}
			
					
			List<ManagementWrapper> temp = (List<ManagementWrapper>)histWrapper;
			semmel006Bean.setPaymentHistoryWrapperList(temp);
		}catch (Exception e) {
			e.printStackTrace();
			addMessageError("EL0000", "SEMMEL006");
		}
	}
	
	
	public void selectAllRow() {
		try {
			boolean chkAll = getSemmel006Bean().isChkSelAll();
			List<MeterInstallment>  installmentDetailList = getSemmel006Bean().getInstallmentSearchResult();
			
			for (int i = 0; i < installmentDetailList.size(); i++) {
				installmentDetailList.get(i).setSelected(chkAll);
			}
		} catch (Exception e) {
			logger.error(""+e);
		}
	}
    
	public void selectAllRowPRPrepaid() {
		try {
			boolean chkAll = getSemmel006Bean().isChkSelAll();
			List<PrivatePrepaid>  privatePrepaids = getSemmel006Bean().getPrivatePrepaidResult();
			
			for (int i = 0; i < privatePrepaids.size(); i++) {
				privatePrepaids.get(i).setSelected(chkAll);
			}
			
		} catch (Exception e) {
			logger.error(""+e);
		}
	}
	// ***** added by bestnaja *****
	public void doChangeMeter(){		
		SEMMEL006Bean semmel006Bean = getSemmel006Bean();		
		try{
			logger.debug("doChangeMeter");
			
			String meterId = semmel006Bean.getPopupSiteCriteria().getMeterId();
			logger.debug("doChangeMeter try to get MeterId:"+meterId);
			logger.debug("doChangeMeter try to get ElectId:"  + semmel006Bean.getPopupSiteCriteria().getElectricId());
			
			
			if(meterId != null){			
				IMeterInfoService meterInfoService = (IMeterInfoService)getBean("meterInfoService");
				logger.debug("meterId = "+meterId);
				MeterInfo meterInfo = meterInfoService.queryByRowId(meterId);
				if(meterInfo!=null){
					//logger.debug("  Found  MeterInfo :"+BeanUtils.getBeanString(meterInfo));
					semmel006Bean.setMeterInfo(meterInfo);	
					semmel006Bean.getPaymentDetail().setUnitVatType(meterInfo.getLastUnitVatType());		
					semmel006Bean.getPaymentDetail().setVatType(meterInfo.getLastUnitVatType());
					semmel006Bean.getPaymentDetail().setUnitPrice(meterInfo.getLastUnitAmt());
					semmel006Bean.getPaymentDetail().setpRead(meterInfo.getLastLKwh());
					
					if(meterInfo.getLastTermOfPaymentDt()!= null){
						String month = ELUtils.getMonthNumberByDate(meterInfo.getLastTermOfPaymentDt(),"TH");
						String year  = ELUtils.getYearNumberByDate(meterInfo.getLastTermOfPaymentDt(),"TH");
						semmel006Bean.getPaymentDetail().setFromTermOfPaymentMonth(month);
						semmel006Bean.getPaymentDetail().setFromTermOfPaymentYear(year);
						doGenerateTermOfPaymentDateTime();
					}
					
					//semmel006Bean.getPaymentDetail().set
					//WT###Edit 20110425 Start
					/*
					if(!semmel006Bean.isPaymentMethodDisable()){
						semmel006Bean.getPayment().setPaymentType("01");
						semmel006Bean.getPayment().setPaymentMethod(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.CT_PAYMENT_METHOD));
					}
					*/
					
					//WT###Edit 20110425 End
					/*logger.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
					
					logger.debug("<<<<<< meterInfo.getLastTermOfPaymentDt:"+meterInfo.getLastTermOfPaymentDt());
					logger.debug("<<<<<< meterInfo.getLastTermOfPaymentDtLabel:"+meterInfo.getLastTermOfPaymentDtLabel());
					logger.debug("<<<<<< getLastUnitVatType:"+meterInfo.getLastUnitVatType());
					logger.debug("<<<<<< getLastLKwh:"+meterInfo.getLastLKwh());
					*/
					// find lastest paymentDetail
					IPaymentDetailService paymentDetailService = (IPaymentDetailService)getBean("paymentDetailService");					
					PaymentDetail paymentDetailLatest = paymentDetailService.queryByMeterInfoAndToTermOfPayment(meterInfo);					
					if(paymentDetailLatest == null) {		
						logger.debug("  Try to load latest Payment Detail Not found ");
						//paymentDetail = new PaymentDetail();
					}else{
						//logger.debug("  Try to load latest Payment Detail  found: "+BeanUtils.getBeanString(paymentDetailLatest));
						semmel006Bean.setPaymentDetailMeterInfoSection(paymentDetailLatest);
						//logger.debug("<<<<<< paymentDetailLatest.getFromTermOfPaymentDtTH():"+ paymentDetailLatest.getFromTermOfPaymentDtTH());
						//logger.debug("<<<<<< paymentDetailLatest.getToTermOfPaymentDtTH():"+ paymentDetailLatest.getToTermOfPaymentDtTH());
						//logger.debug("<<<<<< paymentDetailLatest.WHT():"+paymentDetailLatest.getWhtType());
						//logger.debug("<<<<<< paymentDetailLatest.WHT Check:"+paymentDetailLatest.getWhtCheck());
						//logger.debug("  Try to load latest Payment Detail  found: "+ paymentDetailLatest.getRowId());
						//logger.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
						
						if(paymentDetailLatest.getPaymentId()!= null){
							Payment payment = paymentDetailLatest.getPaymentId();
							//logger.debug("<<<<<<Pay Method >>>>>>"+payment.getPaymentMethod());
							//logger.debug("<<<<<< Pay Type >>>>>>"+payment.getPaymentType());
							//logger.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
							String paymentType = ELUtils.getLOVNameByLOVCode(semmel006Bean.getCtPaymentTypeList(),payment.getPaymentType());
							String paymentMethod = ELUtils.getLOVNameByLOVCode(semmel006Bean.getCtPaymentMethodList(),payment.getPaymentMethod());
							payment.setPaymentTypeTxt(paymentType);
							payment.setPaymentMethodTxt(paymentMethod);
						   //--------------rrrrr
						    if(!semmel006Bean.isExpenseTypeDisable()){
						    	 semmel006Bean.getPayment().setPaymentType(payment.getPaymentType());
						    	 changePaymentTypeELPostpaid();
						    	 semmel006Bean.getPayment().setPaymentMethod(payment.getPaymentMethod());
						    }
							semmel006Bean.getPayment().setOldPaymentTypeTxt(paymentType);
							semmel006Bean.getPayment().setOldPaymentMethodTxt(paymentMethod);
							semmel006Bean.setMeterPayment(payment);
							//logger.debug("<<<<<<paymentType<<<<:"+paymentType);
							//logger.debug("<<<<<<paymentMethod<<<<:"+paymentMethod);	
						}else{
							 if(!semmel006Bean.isExpenseTypeDisable()){
								 semmel006Bean.getPayment().setPaymentType("01");
								 semmel006Bean.getPayment().setPaymentMethod(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.CT_PAYMENT_METHOD));
						    }
						}
						
						if(!StringUtils.isEmpty(paymentDetailLatest.getWhtType())){
							semmel006Bean.getPaymentDetail().setWhtType(paymentDetailLatest.getWhtType());
							semmel006Bean.getPaymentDetail().setWhtCheck("Y");
							semmel006Bean.getPaymentDetail().setWhtCheckBoolean(true);
							semmel006Bean.getPaymentDetail().setWhtRate(paymentDetailLatest.getWhtRate());
							semmel006Bean.setWhtRateDisable(false);
							semmel006Bean.setWhtTypeDisable(false);
						}else{
							semmel006Bean.getPaymentDetail().setWhtType(paymentDetailLatest.getWhtType());
							semmel006Bean.getPaymentDetail().setWhtCheck("N");
							semmel006Bean.getPaymentDetail().setWhtCheckBoolean(false);
							semmel006Bean.getPaymentDetail().setWhtRate(paymentDetailLatest.getWhtRate());
							semmel006Bean.setWhtRateDisable(true);
							semmel006Bean.setWhtTypeDisable(true);
						}
						
						
						
						
					}
									
				}else{
					logger.debug(" Not found  MeterInfo belong to :"+meterId);
					semmel006Bean.setMeterInfo(new MeterInfo());
					semmel006Bean.getPaymentDetail().setWhtType(null);
					semmel006Bean.getPaymentDetail().setWhtType(null);
				}

			}
			
		}catch(Exception e){
			
			e.printStackTrace();
			
			addMessageError("EL0000", "SEMMEL006");
		}
	}
	private boolean initialEdit3() {
		logger.info("START Action initailEdit3 ");	
		boolean flagValid = false;		
		try{
			init();
			semmel006Bean = getSemmel006Bean();
			semmel006Bean.setViewMode(false);
			semmel006Bean.setComeFromPage8(true);
			
			String outstandingFlag = getFacesUtils().getRequestParameter("outstandingFlag") == null ? "" : (String)getFacesUtils().getRequestParameter("outstandingFlag");
			
			if(StringUtils.equals("Y", outstandingFlag)){
				semmel006Bean.setComeFromPage9(true);
				semmel006Bean.setComeFromPage8(false);
			}else{
				semmel006Bean.setComeFromPage9(false);
			}
			//WT###Add 20110216 Start
			String isComeFromOtherPage = (String)getFacesUtils().getRequestParameter("isComeFromOtherPage");//Y
			String actionFrom = (String)getFacesUtils().getRequestParameter("actionFrom");
			String modeView = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("modeView");
			/*
			if (actionFrom.equalsIgnoreCase("SEMMEL008-1")){
				semmel006Bean.setComeFromPage8(true);
				//semmel006Bean.setComeFromOtherPage(false);
			}
			*/
			
			if(null!=isComeFromOtherPage && "Y".equals(isComeFromOtherPage)){
				String navModuleFrom = (String)getFacesUtils().getRequestParameter("navModuleFrom");
				String navProgramFrom = (String)getFacesUtils().getRequestParameter("navProgramFrom");				
				String actionWithNaviFrom = (String)getFacesUtils().getRequestParameter("actionWithNaviFrom");
				String methodWithNaviFrom = (String)getFacesUtils().getRequestParameter("methodWithNaviFrom");
				
				semmel006Bean.setComeFromOtherPage(true);
				semmel006Bean.setNavModuleFrom(navModuleFrom);
				semmel006Bean.setNavProgramFrom(navProgramFrom);
				semmel006Bean.setActionWithNaviFrom(actionWithNaviFrom);
				semmel006Bean.setMethodWithNaviFrom(methodWithNaviFrom);
				
				
			}
			//WT###Add 20110216 END
			/*
			String viewRowNumber = (String)getFacesUtils().getRequestParameter("viewRowNumber");
			int viewRowNumberInt = Integer.parseInt(viewRowNumber)-1;			
			List paymentSearchlist = semmel006Bean.getResultList();			
			PaymentSearch paymentView = (PaymentSearch)paymentSearchlist.get(viewRowNumberInt);				
			IPaymentService service = (IPaymentService)getBean("paymentService");			
			Payment returnpayment = service.queryPaymentByRowId(paymentView.getPaymentId());	
			*/
			
			String targetPaymentId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("targetPayment");
			logger.debug("WT### targetPaymentId="+targetPaymentId);
			IPaymentService service = (IPaymentService)getBean("paymentService");	
			Payment returnpayment = service.queryPaymentByRowId(targetPaymentId);				
			
			
			//logger.debug(" payment after search:"+BeanUtils.getBeanString(returnpayment));		
			
			Payment payment = returnpayment;
			Set paymetSet = payment.getDetails();
			List detailList = new ArrayList();
			if(paymetSet!=null){
				Object [] detailarray = paymetSet.toArray();
				for(Object tmp:detailarray){
					PaymentDetail tmpdetail = (PaymentDetail)tmp;
					ELUtils.setPamentDetailDisplayField(tmpdetail);
					detailList.add(tmp);
				
				}				
			}			
			ELUtils.setPamentDisplayField(payment);
			payment.setTotalExpense(paymetSet.size());//WT###Add 20110127
			semmel006Bean.setPayment(payment);
			semmel006Bean.setNotExpenseSiteList(detailList);			
			semmel006Bean.setPaymentDetailList(detailList);
			
			semmel006Bean.setElectricUseTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name));			
			semmel006Bean.setElExpenseTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name));		
			semmel006Bean.setElDocTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DOC_TYPE.name));
			semmel006Bean.setMeterIdList(ELUtils.getEmptyList());
			semmel006Bean.setCtPaymentTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_TYPE.name));//WT###Add 20110117			
			semmel006Bean.setCtPaymentMethodList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name));//WT###Add 20110117
			semmel006Bean.setMonthList(ELUtils.getMonthDropDownList());//WT###Add 20110117
			semmel006Bean.setYearList(ELUtils.getYearDropDownList());//WT###Add 20110117
			semmel006Bean.setRecordStatusList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_OUTSTANDING_FLAG.name));//WT###Add 20110117	
			
			PopupSiteSearch popupSiteCriteria = new PopupSiteSearch();					
			
			String meterId =ELUtils.getMeterId(payment);		
			String contractNo= returnpayment.getContractNo();
			PopupSiteSearch searchSiteView = new PopupSiteSearch();
			searchSiteView.setMeterId(meterId);
			searchSiteView.setContractNo(contractNo);
			
			logger.debug(" :"+semmel006Bean.getExpenseType());
			if(!(ELUtils.EL_BILL.equalsIgnoreCase(semmel006Bean.getExpenseType()))){
				List <PopupSiteSearch> popupSiteResultList= service.searchSite(searchSiteView,"querySiteELPostpaid");
				logger.debug(" Result Search :"+popupSiteResultList);					
				if (popupSiteResultList != null && !popupSiteResultList.isEmpty()) {
					popupSiteCriteria = popupSiteResultList.get(0);
				}				
			}else{
				ELUtils.copyPaymentToPopupSiteSearch(payment, popupSiteCriteria);				
			}					


			semmel006Bean.setPopupSiteCriteria(popupSiteCriteria);
			semmel006Bean.setPaymentDetail(new PaymentDetail());
			semmel006Bean.setViewMode(false);
			
			flagValid = true;			
			
			//WT###Add 20110127 Start
			changePaymentTypeELPostpaid03Edit();
			semmel006Bean.setExpenseTypeDisable(true);
			semmel006Bean.setDisableUpdateModelButton(true);
			semmel006Bean.setDisableSearchSite(true);			
			//WT###Add 20110127 End	
			//WT###Add 20110131 Start
			String expenseType = payment.getExpenseType();
			logger.debug("WT### expenseType="+expenseType);
			if(ELUtils.EXPENSE_TYPE_EL_POSPAID.equals(expenseType)){
				semmel006Bean.setPaymentTypeMandatory(true);
				/*semmel006Bean.setPaymentMethodDisable(true);						
				semmel006Bean.setTransferDtDisable(true);				
				semmel006Bean.setChqPostingDtDisable(true);
				semmel006Bean.setChqReceivedDtDisable(true);				
				semmel006Bean.setPaymentMethodMandatory(true);
				semmel006Bean.setPaymentTypeDisable(false);
				semmel006Bean.setPaymentMethodDisable(false);
				semmel006Bean.setRefDocNoDisable(true);
				semmel006Bean.setChqPostingDtDisable(false);
				semmel006Bean.setChqReceivedDtDisable(false);				
				semmel006Bean.setRefDocNoMandatory(false);	*/
				semmel006Bean.setRefDocNoDisable(true);
			}else if(ELUtils.EXPENSE_TYPE_EL_DEBIT.equals(expenseType)){
				semmel006Bean.setRefDocNoDisable(false);
				semmel006Bean.setPaymentTypeMandatory(true);
				/*semmel006Bean.setRefDocDtDisable(false);
				semmel006Bean.setRefDocNoMandatory(false);				
				semmel006Bean.setPaymentMethodMandatory(true);
				semmel006Bean.setPaymentTypeDisable(false);
				semmel006Bean.setPaymentMethodDisable(false);
				semmel006Bean.setTransferDtDisable(true);*/
			}else if(ELUtils.EXPENSE_TYPE_EL_CREDIT.equals(expenseType)){
				semmel006Bean.setRefDocNoDisable(false);
				semmel006Bean.setPaymentTypeDisable(true);
				semmel006Bean.setPaymentMethodDisable(true);
				semmel006Bean.setPaymentTypeMandatory(false);
				semmel006Bean.setRefDocNoMandatory(true);
				semmel006Bean.setChqPostingDtDisable(true);
				semmel006Bean.setChqReceivedDtDisable(true);
				semmel006Bean.setTransferDtDisable(true);
				/*semmel006Bean.setRefDocDtDisable(true);
				semmel006Bean.setPaymentTypeMandatory(false);
				semmel006Bean.setPaymentMethodMandatory(false);				
				*/
			}
			//ADD CHECK PAYMENT METHOD 19/12/2013
			String paymentType = payment.getPaymentType();
			String paymentMethod = payment.getPaymentMethod();
			if(paymentType!=null){
				//01		
				if(ELUtils.PAYMENT_TYPE_01.equals(paymentType)){				
					semmel006Bean.setCtPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name,EX_AND,"CHEQUE",null,null));
				//02
				}else if (ELUtils.PAYMENT_TYPE_02.equals(paymentType)){
					semmel006Bean.setCtPaymentMethodList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name));
					if(StringUtils.equalsIgnoreCase("05", paymentMethod)){
						semmel006Bean.setPaymentMethodDisable(true);
					}
				}else{
					semmel006Bean.setCtPaymentMethodList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name));
					if(StringUtils.equalsIgnoreCase("06", paymentMethod)){
						semmel006Bean.setPaymentMethodDisable(true);
					}
				}				
			}
			
			if(StringUtils.equalsIgnoreCase("view", modeView)){
				semmel006Bean.setViewMode(true);
			}
			//semmel006Bean.setPaymentTypeMandatory(true);
			//WT###Add 20110131 End
			logger.info("END Action initailEdit3 ");	
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flagValid;	
	}	
	//WT###Add 20110217 Start
	private boolean initEditFromUploadText(){
		logger.info("START Action initEditFromUploadText ");	
		boolean flagValid = false;		
		try{
			init();
			//semmel006Bean = getSemmel006Bean();
			//semmel006Bean.setComeFromPage8(true);
			//WT###Add 20110216 Start
			String isComeFromOtherPage = (String)getFacesUtils().getRequestParameter("isComeFromOtherPage");//Y
			if(null!=isComeFromOtherPage && "Y".equals(isComeFromOtherPage)){
				String navModuleFrom = (String)getFacesUtils().getRequestParameter("navModuleFrom");
				String navProgramFrom = (String)getFacesUtils().getRequestParameter("navProgramFrom");				
				String actionWithNaviFrom = (String)getFacesUtils().getRequestParameter("actionWithNaviFrom");
				String methodWithNaviFrom = (String)getFacesUtils().getRequestParameter("methodWithNaviFrom");
				semmel006Bean.setComeFromOtherPage(true);
				semmel006Bean.setNavModuleFrom(navModuleFrom);
				semmel006Bean.setNavProgramFrom(navProgramFrom);
				semmel006Bean.setActionWithNaviFrom(actionWithNaviFrom);
				semmel006Bean.setMethodWithNaviFrom(methodWithNaviFrom);
			}
			//WT###Add 20110216 END
			/*
			String viewRowNumber = (String)getFacesUtils().getRequestParameter("viewRowNumber");
			int viewRowNumberInt = Integer.parseInt(viewRowNumber)-1;			
			List paymentSearchlist = semmel006Bean.getResultList();			
			PaymentSearch paymentView = (PaymentSearch)paymentSearchlist.get(viewRowNumberInt);				
			IPaymentService service = (IPaymentService)getBean("paymentService");			
			Payment returnpayment = service.queryPaymentByRowId(paymentView.getPaymentId());	
			*/
			
			String targetPaymentId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("targetPayment");
			logger.debug("WT### targetPaymentId="+targetPaymentId);
			IPaymentService service = (IPaymentService)getBean("paymentService");	
			Payment returnpayment = service.queryPaymentByRowId(targetPaymentId);				
			
			
			//logger.debug(" payment after search:"+BeanUtils.getBeanString(returnpayment));		
			
			Payment payment = returnpayment;
			Set paymetSet = payment.getDetails();
			List detailList = new ArrayList();
			if(paymetSet!=null){
				Object [] detailarray = paymetSet.toArray();
				for(Object tmp:detailarray){
					PaymentDetail tmpdetail = (PaymentDetail)tmp;
					ELUtils.setPamentDetailDisplayField(tmpdetail);
					detailList.add(tmp);
				
				}				
			}			
			ELUtils.setPamentDisplayField(payment);
			//payment.setTotalExpense(paymetSet.size());//WT###Add 20110127
			semmel006Bean.setPayment(payment);
//			semmel006Bean.setNotExpenseSiteList(detailList);			
//			semmel006Bean.setPaymentDetailList(detailList);
			
			semmel006Bean.setElectricUseTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name));			
			semmel006Bean.setElExpenseTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name));		
			semmel006Bean.setElDocTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DOC_TYPE.name));
			semmel006Bean.setMeterIdList(ELUtils.getEmptyList());
			semmel006Bean.setCtPaymentTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_TYPE.name));//WT###Add 20110117			
			semmel006Bean.setCtPaymentMethodList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name));//WT###Add 20110117
			semmel006Bean.setMonthList(ELUtils.getMonthDropDownList());//WT###Add 20110117
			semmel006Bean.setYearList(ELUtils.getYearDropDownList());//WT###Add 20110117
			semmel006Bean.setRecordStatusList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_OUTSTANDING_FLAG.name));//WT###Add 20110117	
			
			PopupSiteSearch popupSiteCriteria = new PopupSiteSearch();					
			
			String meterId =ELUtils.getMeterId(payment);		
			String contractNo= returnpayment.getContractNo();
			PopupSiteSearch searchSiteView = new PopupSiteSearch();
			searchSiteView.setMeterId(meterId);
			searchSiteView.setContractNo(contractNo);
			
			logger.debug(" :"+semmel006Bean.getExpenseType());
			
			if(!(ELUtils.EL_BILL.equalsIgnoreCase(semmel006Bean.getExpenseType()))){
				List <PopupSiteSearch> popupSiteResultList= service.searchSite(searchSiteView,"querySiteELPostpaid");
				logger.debug(" Result Search :"+popupSiteResultList);					
				if (popupSiteResultList != null && !popupSiteResultList.isEmpty()) {
					popupSiteCriteria = popupSiteResultList.get(0);
				}				
			}else{
				ELUtils.copyPaymentToPopupSiteSearch(payment, popupSiteCriteria);				
			}					


			semmel006Bean.setPopupSiteCriteria(popupSiteCriteria);
			semmel006Bean.setPaymentDetail(new PaymentDetail());
			semmel006Bean.setViewMode(false);
			
			flagValid = true;			
			
			//WT###Add 20110127 Start
			//changePaymentTypeELPostpaid03Edit();
			semmel006Bean.setExpenseTypeDisable(true);
			semmel006Bean.setDisableUpdateModelButton(true);
			semmel006Bean.setDisableSearchSite(true);			
			//WT###Add 20110127 End	
			//WT###Add 20110131 Start
			String expenseType = payment.getExpenseType();
			logger.debug("WT### expenseType="+expenseType);
			if(ELUtils.EXPENSE_TYPE_EL_POSPAID.equals(expenseType)){
				semmel006Bean.setPaymentTypeMandatory(true);
				/*semmel006Bean.setPaymentMethodDisable(true);						
				semmel006Bean.setTransferDtDisable(true);				
				semmel006Bean.setChqPostingDtDisable(true);
				semmel006Bean.setChqReceivedDtDisable(true);				
				semmel006Bean.setPaymentMethodMandatory(true);
				semmel006Bean.setPaymentTypeDisable(false);
				semmel006Bean.setPaymentMethodDisable(false);
				semmel006Bean.setRefDocNoDisable(true);
				semmel006Bean.setChqPostingDtDisable(false);
				semmel006Bean.setChqReceivedDtDisable(false);				
				semmel006Bean.setRefDocNoMandatory(false);	*/
				semmel006Bean.setRefDocNoDisable(true);
			}else if(ELUtils.EXPENSE_TYPE_EL_DEBIT.equals(expenseType)){
				semmel006Bean.setRefDocNoDisable(false);
				semmel006Bean.setPaymentTypeMandatory(true);
				/*semmel006Bean.setRefDocDtDisable(false);
				semmel006Bean.setRefDocNoMandatory(false);				
				semmel006Bean.setPaymentMethodMandatory(true);
				semmel006Bean.setPaymentTypeDisable(false);
				semmel006Bean.setPaymentMethodDisable(false);
				semmel006Bean.setTransferDtDisable(true);*/
			}else if(ELUtils.EXPENSE_TYPE_EL_CREDIT.equals(expenseType)){
				semmel006Bean.setRefDocNoDisable(false);
				semmel006Bean.setPaymentTypeDisable(true);
				semmel006Bean.setPaymentMethodDisable(true);
				semmel006Bean.setPaymentTypeMandatory(false);
				semmel006Bean.setRefDocNoMandatory(true);
				semmel006Bean.setChqPostingDtDisable(true);
				semmel006Bean.setChqReceivedDtDisable(true);
				semmel006Bean.setTransferDtDisable(true);
				/*semmel006Bean.setRefDocDtDisable(true);
				semmel006Bean.setPaymentTypeMandatory(false);
				semmel006Bean.setPaymentMethodMandatory(false);				
				*/
			}
			//semmel006Bean.setPaymentTypeMandatory(true);
			//WT###Add 20110131 End
			logger.info("END Action initEditFromUploadText ");	
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flagValid;	
	}
	//WT###Add 20110217 End
	private boolean initailEdit4() {
		logger.info("START Action initailEdit4 ");	
		boolean flagValid = false;		
		try{
			init();
			semmel006Bean = getSemmel006Bean();	
			semmel006Bean.setViewMode(false);
			semmel006Bean.setComeFromPage8(true);
			
			String outstandingFlag = getFacesUtils().getRequestParameter("outstandingFlag") == null ? "" : (String)getFacesUtils().getRequestParameter("outstandingFlag");
			
			if(StringUtils.equals("Y", outstandingFlag)){
				semmel006Bean.setComeFromPage9(true);
				semmel006Bean.setComeFromPage8(false);
			}else{
				semmel006Bean.setComeFromPage9(false);
			}
			/*
			String viewRowNumber = (String)getFacesUtils().getRequestParameter("viewRowNumber");
			int viewRowNumberInt = Integer.parseInt(viewRowNumber)-1;			
			List paymentSearchlist = semmel006Bean.getResultList();			
			PaymentSearch paymentView = (PaymentSearch)paymentSearchlist.get(viewRowNumberInt);				
			IPaymentService service = (IPaymentService)getBean("paymentService");			
			Payment returnpayment = service.queryPaymentByRowId(paymentView.getPaymentId());	
			*/
			String modeView = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("modeView");
			String targetPaymentId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("targetPayment");
			logger.debug("WT### targetPaymentId="+targetPaymentId);
			IPaymentService service = (IPaymentService)getBean("paymentService");	
			Payment returnpayment = service.queryPaymentByRowId(targetPaymentId);				
			
			//logger.debug(" payment after search:"+BeanUtils.getBeanString(returnpayment));		
			
			Payment payment = returnpayment;
			Set paymetSet = payment.getDetails();
			List detailList = new ArrayList();
			if(paymetSet!=null){
				Object [] detailarray = paymetSet.toArray();
				for(Object tmp:detailarray){
					PaymentDetail tmpdetail = (PaymentDetail)tmp;
					ELUtils.setPamentDetailDisplayField(tmpdetail);
					detailList.add(tmp);
				
				}				
			}			
			ELUtils.setPamentDisplayField(payment);
			semmel006Bean.setPayment(payment);
			semmel006Bean.setNotExpenseSiteList(detailList);			
			semmel006Bean.setPaymentDetailList(detailList);
			
			semmel006Bean.setElectricUseTypeList( LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name) );			
			semmel006Bean.setElExpenseTypeList(  LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name) );		
			semmel006Bean.setElDocTypeList( LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DOC_TYPE.name) );
			semmel006Bean.setMeterIdList(ELUtils.getEmptyList());
			semmel006Bean.setCtPaymentTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_TYPE.name));
			semmel006Bean.setCtPaymentMethodList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name));
			
			// BY PASS PROVINCE . . . Edit By Noom 26/10/2012
			PopupVendorSupplierBean popupVendorSupplierBean = getPopupVendorSupplierBean();
			if(popupVendorSupplierBean!=null){
				if (popupVendorSupplierBean.getProvinceList()==null){
					popupVendorSupplierBean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList() == null ? getEmptyDropDown():ProvinceCacheUtil.getInstance().getProvinceSelList());
				}
			}
			// END BY PASS PROVINCE
			
			PopupSiteSearch popupSiteCriteria = new PopupSiteSearch();					
			
			String meterId =ELUtils.getMeterId(payment);		
			String contractNo= returnpayment.getContractNo();
//			PopupSiteSearch searchSiteView = new PopupSiteSearch();
			PopupSiteSearch searchSiteView = new PopupSiteSearch();
			searchSiteView.setMeterId(meterId);
			searchSiteView.setContractNo(contractNo);
			
			logger.debug(" :"+semmel006Bean.getExpenseType());
			//logger.debug(" :"+semmel006Bean.getExpenseType());
			//semmel006Bean.setExpenseType("EL_BILL");
			if(!(ELUtils.EL_BILL.equalsIgnoreCase(semmel006Bean.getExpenseType()))){
				List <PopupSiteSearch> popupSiteResultList= service.searchSite(searchSiteView,"querySiteELTemp");
				logger.debug(" Result Search :"+popupSiteResultList);					
				if (popupSiteResultList != null && !popupSiteResultList.isEmpty()) {
					popupSiteCriteria = popupSiteResultList.get(0);
				}				
			}else{
				ELUtils.copyPaymentToPopupSiteSearch(payment, popupSiteCriteria);				
			}					


			semmel006Bean.setPopupSiteCriteria(popupSiteCriteria);
			semmel006Bean.setPaymentDetail(new PaymentDetail());
			semmel006Bean.setViewMode(false);
			
			semmel006Bean.setDisableVendorTypeButton(false);//WT###Add 20110203
			  
			//ADD CHECK PAYMENT METHOD 19/12/2013
			String paymentType = payment.getPaymentType();
			String paymentMethod = payment.getPaymentMethod();
			if(paymentType!=null){
				//01		
				if(ELUtils.PAYMENT_TYPE_01.equals(paymentType)){				
					semmel006Bean.setCtPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name,EX_AND,"CHEQUE",null,null));
				//02
				}else if (ELUtils.PAYMENT_TYPE_02.equals(paymentType)){
					semmel006Bean.setCtPaymentMethodList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name));
					if(StringUtils.equalsIgnoreCase("05", paymentMethod)){
						semmel006Bean.setPaymentMethodDisable(true);
					}
				}else{
					semmel006Bean.setCtPaymentMethodList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name));
					if(StringUtils.equalsIgnoreCase("06", paymentMethod)){
						semmel006Bean.setPaymentMethodDisable(true);
					}
				}				
			}
			
			if(StringUtils.equalsIgnoreCase("view", modeView)){
				semmel006Bean.setViewMode(true);
			}
			
			initUPdatePaymentDetailFromModel("0");
			doUPdatePaymentDetailFromModel("0");
			
			flagValid = true;
			logger.info("END Action initailEdit4 ");	
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flagValid;	
	}		
	private boolean initailEdit5() {
		logger.info("START Action initailEdit5  ");	
		boolean flagValid = false;		
		try{
			init();
			semmel006Bean = getSemmel006Bean();		
			semmel006Bean.setViewMode(false);
			semmel006Bean.setComeFromPage8(true);			
			
			
			String outstandingFlag = getFacesUtils().getRequestParameter("outstandingFlag") == null ? "" : (String)getFacesUtils().getRequestParameter("outstandingFlag");
			
			if(StringUtils.equals("Y", outstandingFlag)){
				semmel006Bean.setComeFromPage9(true);
				semmel006Bean.setComeFromPage8(false);
			}else{
				semmel006Bean.setComeFromPage9(false);
			}
			/*
			String viewRowNumber = (String)getFacesUtils().getRequestParameter("viewRowNumber");
			int viewRowNumberInt = Integer.parseInt(viewRowNumber)-1;			
			List paymentSearchlist = semmel006Bean.getResultList();			
			PaymentSearch paymentView = (PaymentSearch)paymentSearchlist.get(viewRowNumberInt);				
			IPaymentService service = (IPaymentService)getBean("paymentService");			
			Payment returnpayment = service.queryPaymentByRowId(paymentView.getPaymentId());	
			*/
			
			String modeView = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("modeView");
			String targetPaymentId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("targetPayment");
			IPaymentService service = (IPaymentService)getBean("paymentService");	
			Payment returnpayment = service.queryPaymentByRowId(targetPaymentId);	
			String meterID = null; 
			//logger.debug(" payment after search:"+BeanUtils.getBeanString(returnpayment));					
			Payment payment = returnpayment;
			Set paymetSet = payment.getDetails();
			List detailList = new ArrayList();
			if(paymetSet!=null){
				Object [] detailarray = paymetSet.toArray();
				for(Object tmp:detailarray){
					PaymentDetail tmpdetail = (PaymentDetail)tmp;

					String whtTypeValue = tmpdetail.getWhtType();
					System.out.println("whtTypeValue"+whtTypeValue);
					if(whtTypeValue==null || "03".equals(whtTypeValue)){
						tmpdetail.setWhtCheck("N");
						tmpdetail.setWhtCheckBoolean(false);
						tmpdetail.setWhtRate(null);
					}else{
						tmpdetail.setWhtCheck("Y");
						tmpdetail.setWhtCheckBoolean(true);
						tmpdetail.setWhtRate(new BigDecimal(3));						
					}
					
					meterID = tmpdetail.getMeterInfoId();
					ELUtils.setPamentDetailDisplayField(tmpdetail);
					
					detailList.add(tmp);					
				}				
			}			
			ELUtils.setPamentDisplayField(payment);
			payment.setTotalExpense(paymetSet.size());//WT###Add 20110127
			semmel006Bean.setPayment(payment);

			if(payment.getContractNo()!=null){
				IVendorMasterService vendorMasterService = (IVendorMasterService) getBean("vendorMasterService");
				List<String> vendorCodeList = vendorMasterService.getVendorCodeList(payment.getContractNo());
				
				if(vendorCodeList != null && !vendorCodeList.isEmpty()){
					semmel006Bean.setVendorIdList(setSelectItemList(vendorCodeList, false));
				}else{
					semmel006Bean.setVendorIdList(new ArrayList<SelectItem>());
				}
			}
			
			semmel006Bean.setNotExpenseSiteList(detailList);			
			semmel006Bean.setPaymentDetailList(detailList);			
			semmel006Bean.setElectricUseTypeList( LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name) );			
			semmel006Bean.setElExpenseTypeList(  LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name) );		
			semmel006Bean.setElDocTypeList( LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DOC_TYPE.name) );
			semmel006Bean.setMeterIdList(ELUtils.getEmptyList());	
			semmel006Bean.setCtPaymentTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_TYPE.name));//WT###Add20110117
			semmel006Bean.setCtPaymentMethodList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name));//WT###Add20110117
			semmel006Bean.setEditPrivateTermOfPayment(false);
			
			PopupSiteSearch popupSiteCriteria = new PopupSiteSearch();					
			String meterId =ELUtils.getMeterId(payment);		
			String contractNo= returnpayment.getContractNo();			
			
			IManagementService managementService = (IManagementService)getBean("managementService");	
			List<Management>  manageList = managementService.queryManagementByContractNo06(contractNo);
			if(manageList!=null&&manageList.size()>0){
				int rowNumber =1;
				for(Management tmp: manageList){
					popupSiteCriteria.setRowNumber(""+rowNumber++);
					popupSiteCriteria.setElectricId(tmp.getRowId());					
					popupSiteCriteria.setContractNo(tmp.getContractNo());					
					popupSiteCriteria.setCompany(tmp.getCompany());
					popupSiteCriteria.setOldContractNo(tmp.getOldContractNo());
					popupSiteCriteria.setElectricUseType(tmp.getElectricUseType());
					popupSiteCriteria.setRecordStatus(tmp.getRecordStatus());
					popupSiteCriteria.setContractStartDt(tmp.getContractStartDt());
					popupSiteCriteria.setContractEndDt(tmp.getContractEndDt());
					popupSiteCriteria.setSiteName(tmp.getSiteName());
					popupSiteCriteria.setSiteStatus(tmp.getSiteStatus());
					popupSiteCriteria.setNetworkStatus(tmp.getNetworkStatus());
					popupSiteCriteria.setLocationId(tmp.getLocationId());
					popupSiteCriteria.setLocationCode(tmp.getLocationCode());
					popupSiteCriteria.setSiteInfoId(tmp.getSiteInfoId());
					popupSiteCriteria.setSiteType(tmp.getSiteType());
					popupSiteCriteria.setRegion(tmp.getRegion());
					popupSiteCriteria.setMeterId(meterID);

					List<SelectItem> selectGroupList = getLovItemsByType(ELovType.EL_OWNER_GROUP.name);
					for(SelectItem select : selectGroupList){
						if(StringUtils.equalsIgnoreCase(select.getValue().toString(),tmp.getElOwnerGroup())){
							popupSiteCriteria.setOwnerGroupName(select.getLabel());
						}
					}
										
					ELUtils.setPopupSearchsiteDisplayField(popupSiteCriteria);
				}
			}	
			semmel006Bean.setPopupSiteCriteria(popupSiteCriteria);			
			String electricIdSelected = payment.getElectricId().getRowId();
			logger.debug(" Load Meter Id list belong to electricId :"+electricIdSelected);
			
			IMeterInfoService meterInfoService = (IMeterInfoService)getBean("meterInfoService");
			MeterInfo meterSearch = new MeterInfo();
			meterSearch.setOutstandingFlag("Y");
			meterSearch.setRecordStatus("Y");
			Management electricId = new Management();
			electricId.setRowId(electricIdSelected);
			meterSearch.setElectricId(electricId);
			List <MeterInfo>  resultList = meterInfoService.queryMeterListForPayment(meterSearch);
			if(resultList!=null&&resultList.size()>0){
				logger.info(" Found MeterInfo list size :"+resultList.size());	
				MeterInfo meterTmp =  (MeterInfo)resultList.get(0);
				//semmel006Bean.getPopupSiteCriteria().setMeterId(meterTmp.getMeterId());
				semmel006Bean.setMeterIdList(ELUtils.getMeterIdList(resultList));
				semmel006Bean.getPayment().setTotalMeterExpense(resultList.size());
				semmel006Bean.setMeterInfo(meterTmp);
			}else{
				semmel006Bean.setMeterIdList(ELUtils.getEmptyList());
				semmel006Bean.getPayment().setTotalMeterExpense(0);
				logger.info(" Not Found MeterInfo list");
			}			
			
			
			semmel006Bean.setPaymentDetail(new PaymentDetail());
			semmel006Bean.setViewMode(false);			
			flagValid = true;
			//WT###Add 20110127 Start
			changePaymentTypeELPREdit();
			semmel006Bean.setExpenseTypeDisable(true);
			semmel006Bean.setDisableUpdateModelButton(true);
			semmel006Bean.setMeterIdDisable(true);			
			//WT###Add 20110127 End
			//WT###Add 20110131 Start
			semmel006Bean.setDisableSearchSite(true);
			String expenseType = payment.getExpenseType();
			logger.debug("WT### expenseType="+expenseType);
			if("PR_POSTPAID".equals(expenseType)){					
				semmel006Bean.setRefDocNoDisable(true);
				semmel006Bean.setPaymentTypeMandatory(true);
				semmel006Bean.setEditPrivateTermOfPayment(true);
				/*semmel006Bean.setRefDocDtDisable(true);
				semmel006Bean.setRefDocNoMandatory(false);
				semmel006Bean.setPaymentMethodMandatory(true);
				semmel006Bean.setTransferDtDisable(true);*/
			}else if("PR_DEBIT".equals(expenseType)){				
				semmel006Bean.setRefDocNoDisable(false);
				semmel006Bean.setPaymentTypeMandatory(true);
				semmel006Bean.setEditPrivateTermOfPayment(true);
				/*semmel006Bean.setRefDocDtDisable(false);
				semmel006Bean.setRefDocNoMandatory(true);
				semmel006Bean.getPayment().setDocType(ELUtils.DOC_TYPE_DR);	
				semmel006Bean.setPaymentMethodMandatory(true);
				semmel006Bean.setTransferDtDisable(true);*/
			}else if("PR_CREDIT".equals(expenseType)){	
				semmel006Bean.setRefDocNoDisable(false);
				semmel006Bean.setPaymentTypeDisable(true);
				semmel006Bean.setPaymentMethodDisable(true);
				semmel006Bean.setPaymentTypeMandatory(false);
				semmel006Bean.setRefDocNoMandatory(true);
				semmel006Bean.setChqPostingDtDisable(true);
				semmel006Bean.setChqReceivedDtDisable(true);
				semmel006Bean.setTransferDtDisable(true);
				semmel006Bean.setEditPrivateTermOfPayment(true);
				/*semmel006Bean.setRefDocDtDisable(false);
				
				semmel006Bean.setPaymentMethodMandatory(false);
												
				semmel006Bean.setChqPostingDtDisable(true);*/
				
			}	
			
			semmel006Bean.setWhtTypeDisable(true);
			semmel006Bean.setWhtRateDisable(true);
			semmel006Bean.setWhtAmtDisable(true);
			
			//ADD CHECK PAYMENT METHOD 19/12/2013
			String paymentType = payment.getPaymentType();
			String paymentMethod = payment.getPaymentMethod();
			if(paymentType!=null){
				//01		
				if(ELUtils.PAYMENT_TYPE_01.equals(paymentType)){				
					semmel006Bean.setCtPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name,EX_AND,"CHEQUE",null,null));
				//02
				}else if (ELUtils.PAYMENT_TYPE_02.equals(paymentType)){
					semmel006Bean.setCtPaymentMethodList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name));
					if(StringUtils.equalsIgnoreCase("05", paymentMethod)){
						semmel006Bean.setPaymentMethodDisable(true);
					}
				}else{
					semmel006Bean.setCtPaymentMethodList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name));
					if(StringUtils.equalsIgnoreCase("06", paymentMethod)){
						semmel006Bean.setPaymentMethodDisable(true);
					}
				}				
			}
			
			if(StringUtils.equalsIgnoreCase("view", modeView)){
				semmel006Bean.setViewMode(true);
			}
			
			initUPdatePaymentDetailFromModel("0");
			doUPdatePaymentDetailFromModel("0");
			
			//loadDefault();
			
			//WT###Add 20110131 End
			logger.info("END Action initailEdit5");	
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flagValid;	
	}			
	
	public void loadDefault() {
		Date from = semmel006Bean.getPaymentDetailList().get(0).getFromTermOfPaymentDt();
		Date to = semmel006Bean.getPaymentDetailList().get(0).getToTermOfPaymentDt();
		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String fromStr = formatter.format(from);
		String toStr = formatter.format(to);
		
			semmel006Bean.getPaymentDetail().setpRead(semmel006Bean.getPaymentDetailList().get(0).getpRead());
			semmel006Bean.getPaymentDetail().setKwhTotal(semmel006Bean.getPaymentDetailList().get(0).getKwhTotal());
			semmel006Bean.getPaymentDetail().setUnitPrice(semmel006Bean.getPaymentDetailList().get(0).getUnitPrice());
			
			semmel006Bean.getPaymentDetail().setFromTermOfPaymentDate(fromStr.substring(8, 10));
			semmel006Bean.getPaymentDetail().setFromTermOfPaymentMonth(String.valueOf(Integer.parseInt(fromStr.substring(5, 7)+543)));
			semmel006Bean.getPaymentDetail().setFromTermOfPaymentDt(from);
			
			semmel006Bean.getPaymentDetail().setToTermOfPaymentDate(fromStr.substring(0, 4));
			semmel006Bean.getPaymentDetail().setToTermOfPaymentMonth(fromStr.substring(8, 10));
			semmel006Bean.getPaymentDetail().setToTermOfPaymentDt(to);


			System.out.println(semmel006Bean.getPaymentDetailList().get(0).getFromTermOfPaymentDt());
			System.out.println(semmel006Bean.getPaymentDetailList().get(0).getToTermOfPaymentDt());
	}
	public boolean initailEdit6() {
		logger.info("START Action initailEdit6  ");	
		boolean flagValid = false;		
		try{
			init();
			semmel006Bean = getSemmel006Bean();	
			semmel006Bean.setViewMode(false);
			semmel006Bean.setComeFromPage8(true);
			
			String outstandingFlag = getFacesUtils().getRequestParameter("outstandingFlag") == null ? "" : (String)getFacesUtils().getRequestParameter("outstandingFlag");
			
			if(StringUtils.equals("Y", outstandingFlag)){
				semmel006Bean.setComeFromPage9(true);
				semmel006Bean.setComeFromPage8(false);
			}else{
				semmel006Bean.setComeFromPage9(false);
			}
			/*
			String viewRowNumber = (String)getFacesUtils().getRequestParameter("viewRowNumber");
			int viewRowNumberInt = Integer.parseInt(viewRowNumber)-1;			
			List paymentSearchlist = semmel006Bean.getResultList();			
			PaymentSearch paymentView = (PaymentSearch)paymentSearchlist.get(viewRowNumberInt);				
			IPaymentService service = (IPaymentService)getBean("paymentService");	
			Payment returnpayment = service.queryPaymentByRowId(paymentView.getPaymentId());			
			logger.debug(" payment after search:"+BeanUtils.getBeanString(returnpayment));				
			
			*/
			String modeView = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("modeView");
			String targetPaymentId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("targetPayment");
			IPaymentService service = (IPaymentService)getBean("paymentService");	
			IMeterInstallmentService meterIntallmentService = (IMeterInstallmentService)getBean("meterInstallmentService");
			Payment returnpayment = service.queryPaymentByRowId(targetPaymentId);
			
			Payment payment = returnpayment;
			Set paymetSet = payment.getDetails();
			List detailList = new ArrayList();
			if(paymetSet!=null){
				Object [] detailarray = paymetSet.toArray();
				for(Object tmp:detailarray){
					PaymentDetail tmpdetail = (PaymentDetail)tmp;
					logger.debug("WT### tmpdetail.getPrivatePrepaid()="+tmpdetail.getPrivatePrepaid());
					PrivatePrepaid privatePrepaid = meterIntallmentService.queryPrivatePrepaidByRowId(tmpdetail.getPrivatePrepaid());
					logger.debug("WT### privatePrepaid="+privatePrepaid);
					if(null!=privatePrepaid){
						tmpdetail.setDueDt(privatePrepaid.getDueDt());
					}
					ELUtils.setPamentDetailDisplayField(tmpdetail);
					detailList.add(tmp);	
					
				}				
			}
			if(payment.getContractNo()!=null){
				IVendorMasterService vendorMasterService = (IVendorMasterService) getBean("vendorMasterService");
				List<String> vendorCodeList = vendorMasterService.getVendorCodeList(payment.getContractNo());
				
				if(vendorCodeList != null && !vendorCodeList.isEmpty()){
					semmel006Bean.setVendorIdList(setSelectItemList(vendorCodeList, false));
				}else{
					semmel006Bean.setVendorIdList(new ArrayList<SelectItem>());
				}
			}
			if(payment.getWhtAmt() != null){
				semmel006Bean.setPreviosWhtAmt(payment.getWhtAmt());
			}
			ELUtils.setPamentDisplayField(payment);
			semmel006Bean.setPayment(payment);
			semmel006Bean.setNotExpenseSiteList(detailList);			
			semmel006Bean.setPaymentDetailList(detailList);
			//WT###Add 20110120 Start
			semmel006Bean.getPayment().setTotalExpense(detailList.size());
			if(null!=payment.getWhtType() && !"".equals(payment.getWhtType())){
				semmel006Bean.getPayment().setWhtCheckBoolean(true);
			}
			//WT###Add 20110120 End
			
			semmel006Bean.setElectricUseTypeList( LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name) );			
			semmel006Bean.setElExpenseTypeList(  LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name) );		
			semmel006Bean.setElDocTypeList( LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DOC_TYPE.name) );
			semmel006Bean.setMeterIdList(ELUtils.getEmptyList());	
			semmel006Bean.setCtPaymentTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_TYPE.name));//WT###Add 20110117
			semmel006Bean.setCtPaymentMethodList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name));//WT###Add 20110117
			
			
			PopupSiteSearch popupSiteCriteria = new PopupSiteSearch();					
			String meterId =ELUtils.getMeterId(payment);		
			String contractNo= returnpayment.getContractNo();			
			
			IManagementService managementService = (IManagementService)getBean("managementService");	
			List<Management>  manageList = managementService.queryManagementByContractNo06(contractNo);
			if(manageList!=null&&manageList.size()>0){
				int rowNumber =1;
				for(Management tmp: manageList){
					popupSiteCriteria.setRowNumber(""+rowNumber++);
					popupSiteCriteria.setElectricId(tmp.getRowId());					
					popupSiteCriteria.setContractNo(tmp.getContractNo());					
					popupSiteCriteria.setCompany(tmp.getCompany());
					popupSiteCriteria.setOldContractNo(tmp.getOldContractNo());
					popupSiteCriteria.setElectricUseType(tmp.getElectricUseType());
					popupSiteCriteria.setRecordStatus(tmp.getRecordStatus());
					popupSiteCriteria.setContractStartDt(tmp.getContractStartDt());
					popupSiteCriteria.setContractEndDt(tmp.getContractEndDt());
					popupSiteCriteria.setSiteName(tmp.getSiteName());
					popupSiteCriteria.setSiteStatus(tmp.getSiteStatus());
					popupSiteCriteria.setNetworkStatus(tmp.getNetworkStatus());
					popupSiteCriteria.setLocationId(tmp.getLocationId());
					popupSiteCriteria.setLocationCode(tmp.getLocationCode());
					popupSiteCriteria.setSiteInfoId(tmp.getSiteInfoId());
					popupSiteCriteria.setSiteType(tmp.getSiteType());
					popupSiteCriteria.setRegion(tmp.getRegion());		
					//WT###Add 20110120 Start
					popupSiteCriteria.setpTakeAllAmount(tmp.getpTakeAllAmount()==null?new BigDecimal(0):new BigDecimal(tmp.getpTakeAllAmount()));
					popupSiteCriteria.setpTakeAllPreiodType(tmp.getpTakeAllPeriodType());
					popupSiteCriteria.setpVatType(tmp.getpVatType());
					popupSiteCriteria.setpPayPeriodType(tmp.getpPayPeriodType());
					//WT###Add 20110120 End
					
					ELUtils.setPopupSearchsiteDisplayField(popupSiteCriteria);
				}
			}	
			semmel006Bean.setPopupSiteCriteria(popupSiteCriteria);			
			String electricIdSelected = payment.getElectricId().getRowId();
			logger.debug(" Load Meter Id list belong to electricId :"+electricIdSelected);
			IMeterInfoService meterInfoService = (IMeterInfoService)getBean("meterInfoService");
			MeterInfo meterSearch = new MeterInfo();
			meterSearch.setOutstandingFlag("Y");
			meterSearch.setRecordStatus("Y");
			Management electricId = new Management();
			electricId.setRowId(electricIdSelected);
			meterSearch.setElectricId(electricId);
			List <MeterInfo>  resultList = meterInfoService.queryMeterListForPayment(meterSearch);
			if(resultList!=null&&resultList.size()>0){
				logger.info(" Found MeterInfo list size :"+resultList.size());	
				MeterInfo meterTmp =  (MeterInfo)resultList.get(0);
				semmel006Bean.getPopupSiteCriteria().setMeterId(meterTmp.getMeterId());
				semmel006Bean.setMeterIdList(ELUtils.getMeterIdList(resultList));
				semmel006Bean.getPayment().setTotalMeterExpense(resultList.size());
				semmel006Bean.setMeterInfo(meterTmp);
			}else{
				semmel006Bean.setMeterIdList(ELUtils.getEmptyList());
				semmel006Bean.getPayment().setTotalMeterExpense(0);
				logger.info(" Not Found MeterInfo list");
			}			
			
			//ADD CHECK PAYMENT METHOD 19/12/2013
			String paymentType = payment.getPaymentType();
			String paymentMethod = payment.getPaymentMethod();
			if(paymentType!=null){
				//01		
				if(ELUtils.PAYMENT_TYPE_01.equals(paymentType)){				
					semmel006Bean.setCtPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name,EX_AND,"CHEQUE",null,null));
				//02
				}else if (ELUtils.PAYMENT_TYPE_02.equals(paymentType)){
					semmel006Bean.setCtPaymentMethodList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name));
					if(StringUtils.equalsIgnoreCase("05", paymentMethod)){
						semmel006Bean.setPaymentMethodDisable(true);
					}
				}else{
					semmel006Bean.setCtPaymentMethodList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name));
					if(StringUtils.equalsIgnoreCase("06", paymentMethod)){
						semmel006Bean.setPaymentMethodDisable(true);
					}
				}				
			}
			
			if(StringUtils.equalsIgnoreCase("view", modeView)){
				semmel006Bean.setViewMode(true);
			}else{
			semmel006Bean.setViewMode(false);
			}
			flagValid = true;
			logger.info("END Action initailEdit6");	
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flagValid;	
	}			
	
	private boolean backFromViewMeterInfo() {
		logger.debug(" -- backFromViewMeterInfo--");
		boolean flagValid = false;		
		try{
			flagValid = true;			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flagValid;		
	}	
	//------------------------------------------------------------------------
	
	private boolean validatePaymentByExpenseType(String expenseType) {
		logger.debug(" -- validatePayment expenseType :" +expenseType);
		boolean flagValid = false;
		
		if(ELUtils.EL_BILL.equalsIgnoreCase(expenseType)){
			if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getCompany())) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.company")));
				flagValid = true;
			}
			if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getElectricUseType())) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.electricUseType")));
				flagValid = true;
			}				
			if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getExpenseType())) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.expenseType")));
				flagValid = true;
			}	
			if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getDocType())) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.docType")));
				flagValid = true;
			}			
			if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getDocNo())) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.docNo")));
				flagValid = true;
			}			
			if (getSemmel006Bean().getPayment().getDocDt()==null) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.docDt")));
				flagValid = true;
			}	
			if (getSemmel006Bean().getPayment().getInvTotalSite().intValue()==0) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.invTotalSite")));
				flagValid = true;
			}	
			if (getSemmel006Bean().getPayment().getInvTotalExcludeVat().intValue()==0) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.invTotalExcludeVat")));
				flagValid = true;
			}						

			
			if (getSemmel006Bean().getPayment().getInvTotalVat().intValue()==0) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.invTotalVat")));
				flagValid = true;
			}	
			if (getSemmel006Bean().getPayment().getInvTotalIncludeVat().intValue()==0) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.invTotalIncludeVat")));
				flagValid = true;
			}	
			
			
			if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getVendorId())) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vendorId")));
				flagValid = true;
			}	
			if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getVendorName())) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vendorName")));
				flagValid = true;
			}	
			if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentType())) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.paymentType")));
				flagValid = true;
			}	
			//WT###Add 20110323 Start
			if(!StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentType())){
				if(PAYMENT_TYPE_TRANS.equals(getSemmel006Bean().getPayment().getPaymentType())){
					if(StringUtils.isEmpty(getSemmel006Bean().getPayment().getBankName()) || StringUtils.isEmpty(getSemmel006Bean().getPayment().getBankAccount())){
						FrontMessageUtils.addMessageError(getValidateMessage("msg.requireBackAccount"));
						flagValid = true;
					}
				}
			}
			//WT###Add 20110323 End
			if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentMethod())) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.paymentMethod")));
				flagValid = true;
			}					
		}else	if(ELUtils.EL_POSTPAID.equalsIgnoreCase(expenseType)){

				if (StringUtils.isEmpty(getSemmel006Bean().getPopupSiteCriteria().getCompany())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.company")));
					flagValid = true;
				}		
				if (StringUtils.isEmpty(getSemmel006Bean().getPopupSiteCriteria().getContractNo())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.contractNo")));
					flagValid = true;
				}	
				if (StringUtils.isEmpty(getSemmel006Bean().getPopupSiteCriteria().getMeterId())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.meterId")));
					flagValid = true;
				}	
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getExpenseType())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.expenseType")));
					flagValid = true;
				}	
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getDocType())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.docType")));
					flagValid = true;
				}			

				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getDocNo())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.docNo")));
					flagValid = true;
				}							
				if (getSemmel006Bean().getPayment().getDocDt()==null) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.docDt")));
					flagValid = true;
				}			
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentType())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.paymentType")));
					flagValid = true;
				}	
				//WT###Add 20110323 Start
				if(!StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentType())){
					if(PAYMENT_TYPE_TRANS.equals(getSemmel006Bean().getPayment().getPaymentType())){
						if(StringUtils.isEmpty(getSemmel006Bean().getPayment().getBankName()) || StringUtils.isEmpty(getSemmel006Bean().getPayment().getBankAccount())){
							FrontMessageUtils.addMessageError(getValidateMessage("msg.requireBackAccount"));
							flagValid = true;
						}
					}
				}
				//WT###Add 20110323 End
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentMethod())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.paymentMethod")));
					flagValid = true;
				}					
				
				
				String newexpenseType = getSemmel006Bean().getPayment().getExpenseType();
				if(newexpenseType!=null){
					
					
				}					
	           if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getVendorId())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vendorId")));
					flagValid = true;
				}				
				
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getVendorName())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vendorName")));
					flagValid = true;
				}				
				

			}else	if(ELUtils.EL_TEMP.equalsIgnoreCase(expenseType )){
				
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getVendorId())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vendorId")));
					flagValid = true;
				}
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getVendorName())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vendorName")));
					flagValid = true;
				}
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentType())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.paymentType")));
					flagValid = true;
				}	
				//WT###Add 20110323 Start
				if(!StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentType())){
					if(PAYMENT_TYPE_TRANS.equals(getSemmel006Bean().getPayment().getPaymentType())){
						if(StringUtils.isEmpty(getSemmel006Bean().getPayment().getBankName()) || StringUtils.isEmpty(getSemmel006Bean().getPayment().getBankAccount())){
							FrontMessageUtils.addMessageError(getValidateMessage("msg.requireBackAccount"));
							flagValid = true;
						}
					}
				}
				//WT###Add 20110323 End
				if (StringUtils.isEmpty(getSemmel006Bean().getPopupSiteCriteria().getContractNo())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.contractNo")));
					flagValid = true;
				}	
				
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentMethod())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.paymentMethod")));
					flagValid = true;
				}				
			}
			else if("EL_CREDIT".equalsIgnoreCase(expenseType)){

				if (StringUtils.isEmpty(getSemmel006Bean().getPopupSiteCriteria().getCompany())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.company")));
					flagValid = true;
				}		
				if (StringUtils.isEmpty(getSemmel006Bean().getPopupSiteCriteria().getContractNo())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.contractNo")));
					flagValid = true;
				}	
				if (StringUtils.isEmpty(getSemmel006Bean().getPopupSiteCriteria().getMeterId())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.meterId")));
					flagValid = true;
				}	
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getExpenseType())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.expenseType")));
					flagValid = true;
				}	
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getDocType())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.docType")));
					flagValid = true;
				}			

				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getDocNo())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.docNo")));
					flagValid = true;
				}							
				if (getSemmel006Bean().getPayment().getDocDt()==null) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.docDt")));
					flagValid = true;
				}			
				/*if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentType())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.paymentType")));
					flagValid = true;
				}	
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentMethod())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.paymentMethod")));
					flagValid = true;
				}					
				*/
				
				//String newexpenseType = getSemmel006Bean().getPayment().getExpenseType();
				//if(newexpenseType!=null){
					
					
				//}					
	           if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getVendorId())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vendorId")));
					flagValid = true;
				}				
				
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getVendorName())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vendorName")));
					flagValid = true;
				}
				
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getRefDocNo())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.refDocNo")));
					flagValid = true;
				}
				
				if (getSemmel006Bean().getPayment().getRefDocDt()==null) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.refDocDt")));
					flagValid = true;
				}	

			}				
		     
			else if("EL_DEBIT".equalsIgnoreCase(expenseType) ){

				if (StringUtils.isEmpty(getSemmel006Bean().getPopupSiteCriteria().getCompany())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.company")));
					flagValid = true;
				}		
				if (StringUtils.isEmpty(getSemmel006Bean().getPopupSiteCriteria().getContractNo())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.contractNo")));
					flagValid = true;
				}	
				if (StringUtils.isEmpty(getSemmel006Bean().getPopupSiteCriteria().getMeterId())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.meterId")));
					flagValid = true;
				}	
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getExpenseType())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.expenseType")));
					flagValid = true;
				}	
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getDocType())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.docType")));
					flagValid = true;
				}			

				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getDocNo())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.docNo")));
					flagValid = true;
				}							
				if (getSemmel006Bean().getPayment().getDocDt()==null) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.docDt")));
					flagValid = true;
				}			
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentType())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.paymentType")));
					flagValid = true;
				}	
				//WT###Add 20110323 Start
				if(!StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentType())){
					if(PAYMENT_TYPE_TRANS.equals(getSemmel006Bean().getPayment().getPaymentType())){
						if(StringUtils.isEmpty(getSemmel006Bean().getPayment().getBankName()) || StringUtils.isEmpty(getSemmel006Bean().getPayment().getBankAccount())){
							FrontMessageUtils.addMessageError(getValidateMessage("msg.requireBackAccount"));
							flagValid = true;
						}
					}
				}
				//WT###Add 20110323 End
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentMethod())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.paymentMethod")));
					flagValid = true;
				}					
				
				
				//String newexpenseType = getSemmel006Bean().getPayment().getExpenseType();
				//if(newexpenseType!=null){
					
					
				//}					
	           if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getVendorId())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vendorId")));
					flagValid = true;
				}				
				
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getVendorName())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vendorName")));
					flagValid = true;
				}				

			}				
		
			else if(ELUtils.PR_POSTPAID.equalsIgnoreCase(expenseType )){
				if (StringUtils.isEmpty(getSemmel006Bean().getPopupSiteCriteria().getContractNo())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.contractNo")));
					flagValid = true;
				}
				if (StringUtils.isEmpty(getSemmel006Bean().getPopupSiteCriteria().getMeterId())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.meterId")));
					flagValid = true;
				}		
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getExpenseType())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.expenseType")));
					flagValid = true;
				}	
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getVendorId())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vendorId")));
					flagValid = true;
				}
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getVendorName())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vendorName")));
					flagValid = true;
				}
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentType())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.paymentType")));
					flagValid = true;
				}
				//WT###Add 20110323 Start
				if(!StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentType())){
					if(PAYMENT_TYPE_TRANS.equals(getSemmel006Bean().getPayment().getPaymentType())){
						if(StringUtils.isEmpty(getSemmel006Bean().getPayment().getBankName()) || StringUtils.isEmpty(getSemmel006Bean().getPayment().getBankAccount())){
							FrontMessageUtils.addMessageError(getValidateMessage("msg.requireBackAccount"));
							flagValid = true;
						}
					}
				}
				//WT###Add 20110323 End
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentMethod())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.paymentMethod")));
					flagValid = true;
				}				
			}else if(ELUtils.PR_PREPAID.equalsIgnoreCase(expenseType )){
				
				
				if (StringUtils.isEmpty(getSemmel006Bean().getPopupSiteCriteria().getContractNo())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.contractNo")));
					flagValid = true;
				}					
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getExpenseType())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.expenseType")));
					flagValid = true;
				}	
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getVendorId())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vendorId")));
					flagValid = true;
				}
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getVendorName())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vendorName")));
					flagValid = true;
				}	
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentType())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.paymentType")));
					flagValid = true;
				}
				//WT###Add 20110323 Start
				if(!StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentType())){
					if(PAYMENT_TYPE_TRANS.equals(getSemmel006Bean().getPayment().getPaymentType())){
						if(StringUtils.isEmpty(getSemmel006Bean().getPayment().getBankName()) || StringUtils.isEmpty(getSemmel006Bean().getPayment().getBankAccount())){
							FrontMessageUtils.addMessageError(getValidateMessage("msg.requireBackAccount"));
							flagValid = true;
						}
					}
				}
				//WT###Add 20110323 End
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentMethod())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.paymentMethod")));
					flagValid = true;
				}		
				
							
			}
			else if("PR_CREDIT".equalsIgnoreCase(expenseType)){

				if (StringUtils.isEmpty(getSemmel006Bean().getPopupSiteCriteria().getCompany())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.company")));
					flagValid = true;
				}		
				if (StringUtils.isEmpty(getSemmel006Bean().getPopupSiteCriteria().getContractNo())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.contractNo")));
					flagValid = true;
				}	
				if (StringUtils.isEmpty(getSemmel006Bean().getPopupSiteCriteria().getMeterId())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.meterId")));
					flagValid = true;
				}	
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getExpenseType())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.expenseType")));
					flagValid = true;
				}	
							

											
							
				/*if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentType())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.paymentType")));
					flagValid = true;
				}	
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentMethod())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.paymentMethod")));
					flagValid = true;
				}					
				*/
				
				//String newexpenseType = getSemmel006Bean().getPayment().getExpenseType();
				//if(newexpenseType!=null){
					
					
				//}					
	           if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getVendorId())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vendorId")));
					flagValid = true;
				}				
				
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getVendorName())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vendorName")));
					flagValid = true;
				}
				
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getRefDocNo())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.refDocNo")));
					flagValid = true;
				}
				
				if (getSemmel006Bean().getPayment().getRefDocDt()==null) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.refDocDt")));
					flagValid = true;
				}	

			}				
			else if("PR_DEBIT".equalsIgnoreCase(expenseType) ){

				if (StringUtils.isEmpty(getSemmel006Bean().getPopupSiteCriteria().getCompany())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.company")));
					flagValid = true;
				}		
				if (StringUtils.isEmpty(getSemmel006Bean().getPopupSiteCriteria().getContractNo())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.contractNo")));
					flagValid = true;
				}	
				if (StringUtils.isEmpty(getSemmel006Bean().getPopupSiteCriteria().getMeterId())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.meterId")));
					flagValid = true;
				}	
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getExpenseType())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.expenseType")));
					flagValid = true;
				}	
						
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentType())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.paymentType")));
					flagValid = true;
				}	
				//WT###Add 20110323 Start
				if(!StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentType())){
					if(PAYMENT_TYPE_TRANS.equals(getSemmel006Bean().getPayment().getPaymentType())){
						if(StringUtils.isEmpty(getSemmel006Bean().getPayment().getBankName()) || StringUtils.isEmpty(getSemmel006Bean().getPayment().getBankAccount())){
							FrontMessageUtils.addMessageError(getValidateMessage("msg.requireBackAccount"));
							flagValid = true;
						}
					}
				}
				//WT###Add 20110323 End
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentMethod())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.paymentMethod")));
					flagValid = true;
				}					
				
				
				//String newexpenseType = getSemmel006Bean().getPayment().getExpenseType();
				//if(newexpenseType!=null){
					
					
				//}					
	           if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getVendorId())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vendorId")));
					flagValid = true;
				}				
				
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getVendorName())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vendorName")));
					flagValid = true;
				}				

			}				
			else {
				if (StringUtils.isEmpty(getSemmel006Bean().getPopupSiteCriteria().getCompany())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.company")));
					flagValid = true;
				}		
				if (StringUtils.isEmpty(getSemmel006Bean().getPopupSiteCriteria().getContractNo())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.contractNo")));
					flagValid = true;
				}	
				if (StringUtils.isEmpty(getSemmel006Bean().getPopupSiteCriteria().getMeterId())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.meterId")));
					flagValid = true;
				}	
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getExpenseType())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.expenseType")));
					flagValid = true;
				}	
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getDocType())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.docType")));
					flagValid = true;
				}			

				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getDocNo())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.docNo")));
					flagValid = true;
				}							
				if (getSemmel006Bean().getPayment().getDocDt()==null) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.docDt")));
					flagValid = true;
				}			
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentType())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.paymentType")));
					flagValid = true;
				}	
				//WT###Add 20110323 Start
				if(!StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentType())){
					if(PAYMENT_TYPE_TRANS.equals(getSemmel006Bean().getPayment().getPaymentType())){
						if(StringUtils.isEmpty(getSemmel006Bean().getPayment().getBankName()) || StringUtils.isEmpty(getSemmel006Bean().getPayment().getBankAccount())){
							FrontMessageUtils.addMessageError(getValidateMessage("msg.requireBackAccount"));
							flagValid = true;
						}
					}
				}
				//WT###Add 20110323 End
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getPaymentMethod())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.paymentMethod")));
					flagValid = true;
				}					
				
				
				String newexpenseType = getSemmel006Bean().getPayment().getExpenseType();
				if(newexpenseType!=null){
					
					
				}					
	           if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getVendorId())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vendorId")));
					flagValid = true;
				}				
				
				if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getVendorName())) {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vendorName")));
					flagValid = true;
				}				
						
			}
		
		return flagValid;
	}	
	
	private boolean validateELPostpaidByExpenseType() {
		logger.debug(" -- validateELPostpaidByExpenseType --");
		boolean flagValid = false;
		
		semmel006Bean = getSemmel006Bean();			
		Payment newPayment = semmel006Bean.getPayment();
		try{
			if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getExpenseType())){	
				
				flagValid = validatePaymentByExpenseType("Not Foound");
			}
			else{
				flagValid = validatePaymentByExpenseType(newPayment.getExpenseType());
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}			
		return flagValid;
	}
	
	private boolean validatePRPostpaidByExpenseType() {
		logger.debug(" -- validatePRPostpaidByExpenseType --");
		boolean flagValid = false;
		
		semmel006Bean = getSemmel006Bean();			
		Payment newPayment = semmel006Bean.getPayment();
		try{
			if (StringUtils.isEmpty(getSemmel006Bean().getPayment().getExpenseType())){	
				
				flagValid = validatePaymentByExpenseType("Not Found");
			}
			else{
				flagValid = validatePaymentByExpenseType(newPayment.getExpenseType());
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}			
		return flagValid;
	}
	//-------------------------------------------------------------------------
	public boolean validateMeaTermOfPayment(List<PaymentDetail> paymentDetailListValdation,PaymentDetail paymentDetail) {
		
		logger.debug(" --  validateMeaTermOfPayment ----");
		logger.debug("-------------------------------------------------------------");
		boolean flag = false;
		boolean validateFlag = false;
		HashMap numberOfMonth = new HashMap();
		HashMap newPayMentOfMonth = new HashMap();
		try{   
		    if(paymentDetailListValdation !=null && paymentDetailListValdation.size()>0){
				
				for(PaymentDetail tmp: paymentDetailListValdation){
					logger.debug("----------for(PaymentDetail tmp: paymentDetailListValdation)----------------------------");
					String fromMonth = ELUtils.getMonthNumberByDate(tmp.getTermOfPaymentDt());
					String fromYear = ELUtils.getYearNumberByDate(tmp.getTermOfPaymentDt());
					//String toMonth = ELUtils.getMonthNumberByDate(tmp.getToTermOfPaymentDt());
					//String toYear = ELUtils.getYearNumberByDate(tmp.getToTermOfPaymentDt());
					logger.debug("fromMonth: "+fromMonth);
					logger.debug("fromYear: "+fromYear );
					//logger.debug("toMonth: "+toMonth);
					//logger.debug("toYear:"+toYear );
					
					int startPreriodMonth = Integer.parseInt(fromMonth);
					int startPreriodYear  = Integer.parseInt(fromYear);
					
					String onProcess = new String();
					onProcess = startPreriodMonth + "/" + startPreriodYear;
					numberOfMonth.put(onProcess, onProcess);
			        validateFlag = true;
					Set set = numberOfMonth.entrySet();
					Iterator i = set.iterator();
					while(i.hasNext()){
						Map.Entry me = (Map.Entry)i.next();
						logger.debug(me.getKey() + " : " + me.getValue());
					}
				}
			}
			if(validateFlag){
				
			    logger.debug("------------Start Validation Process------------------------");
				String fromMonth = ELUtils.getMonthNumberByDate(paymentDetail.getTermOfPaymentDt());
				String fromYear = ELUtils.getYearNumberByDate(paymentDetail.getTermOfPaymentDt());
				//String toMonth = ELUtils.getMonthNumberByDate(paymentDetail.getToTermOfPaymentDt());
				//String toYear = ELUtils.getYearNumberByDate(paymentDetail.getToTermOfPaymentDt());
				
				logger.debug("fromMonth: "+fromMonth);
				logger.debug("fromYear: "+fromYear );
				//logger.debug("toMonth: "+toMonth);
				//logger.debug("toYear:"+toYear );
				
				int startPreriodMonth = Integer.parseInt(fromMonth);
				int startPreriodYear  = Integer.parseInt(fromYear);
				
				String onProcess = new String();
				onProcess = startPreriodMonth + "/" + startPreriodYear;
				newPayMentOfMonth.put(onProcess, onProcess);
					
					Set set = newPayMentOfMonth.entrySet();
					Iterator i = set.iterator();
					
					while(i.hasNext()){
				    	Map.Entry me = (Map.Entry)i.next();
				    	logger.debug(me.getKey() + " : " + me.getValue());
				    	String key = me.getKey().toString();
				        
				    	if(numberOfMonth.containsKey(key)){
				    	 logger.debug("********Found Same Preriod of Paymeny********* ");
				    	 FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.preriodoftime")));
				    	 return flag = true;
				    	}
				    }
			}
			
		}catch(Exception ex){
			
			ex.printStackTrace();
		}
		
	   return flag;
	}	
	
	//WT###Add 20110202 Start
	private String getErrorMessage(String key) {
		String msg = this.getMessage(key);
		if(msg != null){
			msg = msg.replaceAll(":", "");
		}else{
			msg = "Properties key[" +key+ "] not found.";
		}
		return msg;
	}
	
	private String getMessage(String key) {
		return RS_BUNDLE.getString(key);
	}
	//WT###Add 20110202 End
	public boolean searchPrivatePrepaid() {
		boolean flag = false;
		
		try{
			semmel006Bean = getSemmel006Bean();
			semmel006Bean.setInstallmentSearchResult(new ArrayList());
			
			//if (validatedoSaveELPRPrepaid()) {
				//return flag;
			//}
			
			String contractNo = semmel006Bean.getPopupSiteCriteria().getContractNo();
			String rowId = semmel006Bean.getPopupSiteCriteria().getRowNumber();
			logger.debug(" -- searchPrivatePrepaid() contractNo:"+contractNo);
			logger.debug(" -- searchPrivatePrepaid() rowId:"+rowId);
			
			if(contractNo!=null){
				IMeterInstallmentService meterInfoService = (IMeterInstallmentService)getBean("meterInstallmentService");			 
				//MeterInstallment criteria = new MeterInstallment();
				PrivatePrepaid  criteria = new PrivatePrepaid ();	
				criteria.setContractNo(contractNo);
				criteria.setRecordStatus("Y");
				criteria.setPaidFlag("N");
				criteria.setElectricUseType("PRIVATE");
				criteria.setPrepaidFlag("Y");
				criteria.setRowId(rowId);
				
				//logger.debug("contractNo:"+contractNo+ "  Record Status = Y and paidFlag =N ");
				//logger.debug("rowId:"+rowId);
				
				List <PrivatePrepaid> result = meterInfoService.queryByCritiriaPrivatePrepaid(criteria);	
				List <PaymentDetail>  gridMeterInfoList = semmel006Bean.getPaymentDetailList();	
				
				if(result!=null&&result.size()>0){
					for(PrivatePrepaid tmp:result){
						logger.debug("tmp.getRowId():"+tmp.getRowId());
						
						if(tmp.getRowId().equalsIgnoreCase(rowId)){
							tmp.setSelected(true);
							logger.debug("<<<<<<<<<<<if(tmp.getRowId()==rowId)>>>>>>>>>>>>:"+tmp.getRowId());
							break;
						}
					}
					
					semmel006Bean.setPrivatePrepaidResult(result);
					
				}else{
					semmel006Bean.setInstallmentSearchResult(new ArrayList());
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("M0004"), ""));
				}					
				if (result != null && !result.isEmpty()) {
					String firstRowId = result.get(0).getRowId();
					semmel006Bean.setSelectedRadio(firstRowId);	
				}				
			}else{
				semmel006Bean.setInstallmentSearchResult(new ArrayList());
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("M0004"), ""));				
			}	
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flag;
	}
	
	public boolean doAddPrivatePrepaid() {
		logger.debug(" --  doAddPrivatePrepaid --");
		boolean flag = false;
		try{
			semmel006Bean = getSemmel006Bean();			
			List <PrivatePrepaid > installmentList =  semmel006Bean.getPrivatePrepaidResult();				
			boolean isSelected = false;
			Payment payment = semmel006Bean.getPayment();
			
			logger.debug(" List <PrivatePrepaid > installmentList :"+ installmentList.size());
			for(PrivatePrepaid tmp:installmentList){					
				if (tmp.isSelected()) {
					logger.debug("tmp.isSelected() :"+ tmp.getRowId());
					if("N".equals(tmp.getPaidFlag())){
						logger.debug(" check and paidflag =N , Add to payment detail list");
						isSelected = true;		
						PaymentDetail newPaymentDetail = new PaymentDetail();
						newPaymentDetail.setPayAmt(tmp.getPayAMt()==null?new BigDecimal(0):tmp.getPayAMt());
						newPaymentDetail.setVatAmt(tmp.getVatAmt()==null?new BigDecimal(0):tmp.getVatAmt());
						newPaymentDetail.setDueDt(tmp.getDueDt());
						newPaymentDetail.setExcludeVatAmt(tmp.getExcludeVatAmt()==null?new BigDecimal(0):tmp.getExcludeVatAmt());
						newPaymentDetail.setIncludeVatAmt(tmp.getIncludeVatAmt()==null?new BigDecimal(0):tmp.getIncludeVatAmt());
						newPaymentDetail.setChqAmt(tmp.getChqAmt()==null?new BigDecimal(0):tmp.getChqAmt());	
						newPaymentDetail.setInstallmentrowId(tmp.getRowId());
						
						// Bug PaymentPRPre-019
						//newPaymentDetail.setVatType(payment.getVatType());						
						newPaymentDetail.setVatType(tmp.getVatType());
						
						//- TERM_OF_PAYMENT_DT = TERM_OF_PAYMENT_DT จาก SEM_EL_METER_INSTALLMENT  
						//- FROM_TERM_OF_PAYMENT_DT = FROM_TERM_OF_PAYMENT_DT จาก SEM_EL_METER_INSTALLMENT  
						//- TO_TERM_OF_PAYMENT_DT = TO_TERM_OF_PAYMENT_DT จาก SEM_EL_METER_INSTALLMENT 
						//- PERIOD_NAME = PERIOD_NAME จาก SEM_EL_METER_INSTALLMENT 
						
						newPaymentDetail.setTermOfPaymentDt(tmp.getTermOfPaymentDt());
						newPaymentDetail.setFromTermOfPaymentDt(tmp.getFormTermOfPaymentDt());
						newPaymentDetail.setToTermOfPaymentDt(tmp.getToTermOfPaymentDt());
						newPaymentDetail.setPeriodName(tmp.getPeriodName());
						newPaymentDetail.setWhtType(tmp.getWhtType());//WT###Add 20110119
						
						//-------------------
						newPaymentDetail.setPrivatePrepaid(tmp.getRowId());
						  
						
						ELUtils.setPamentDisplayField(payment);
				        ELUtils.setPamentDetailDisplayField(newPaymentDetail);
				        List<PaymentDetail> paymentDetailList = payment.getPaymentDetailList();	
						
				        if(paymentDetailList==null||paymentDetailList.size()==0){
							newPaymentDetail.setRowNumber(1);
							logger.debug(" rowNumber for first Row:"+newPaymentDetail.getRowNumber() );
							List<PaymentDetail> newDetailList = new ArrayList<PaymentDetail>();
							newDetailList.add(newPaymentDetail);
							payment.setPaymentDetailList(newDetailList);
							semmel006Bean.setPaymentDetailList(newDetailList);
						}else{
							logger.debug(" paymentDetailList size:"+paymentDetailList.size());
							int maxCurrentRow = ((PaymentDetail)paymentDetailList.get(paymentDetailList.size()-1)).getRowNumber() +1;
							logger.debug(" maxCurrentRow:"+maxCurrentRow);
							newPaymentDetail.setRowNumber(maxCurrentRow);			
							semmel006Bean.getPaymentDetailList().add(newPaymentDetail);				
						}					
						reCalculatePaymentConclution6(semmel006Bean.getPaymentDetailList(),semmel006Bean.getPayment());							
					}else{
						logger.debug(" check and paidflag =Y , Aready exist in Grid Add , No add");
					}
					
				
				}
			}			
			logger.debug("newPayment.getPaymentDetailList() size :"+payment.getPaymentDetailList().size() );			
			logger.debug("semmel006Bean.getPaymentDetailList() size :"+semmel006Bean.getPaymentDetailList().size() );			
			semmel006Bean.setPrivatePrepaidResult(null);
			if(semmel006Bean.getPaymentDetailList()==null||semmel006Bean.getPaymentDetailList().size()<=0){
				semmel006Bean.setDisableMoreThanOneDetail(false);
			}else{
				semmel006Bean.setDisableMoreThanOneDetail(true);
			}			
			
			//semmel006Bean.setPaymentDetail(new PaymentDetail());	
			if(!isSelected){
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0022"), ""));
				return flag;
			}
			semmel006Bean.setPrivatePrepaidResult(null);
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flag;
	}		

	public boolean doSearchSitePrivatePrepaid() {
		logger.debug(" doSearchSitePrivatePrepaid()");
		boolean flag = false; 
		try{
			semmel006Bean = getSemmel006Bean();
			List<PopupSiteSearch> siteList = semmel006Bean.getPopupSiteList();					
			String electricIdSelected = "";
			String contractNoSelected ="";
			String paymentType ="";
			//String selectNumber = semmel006Bean.getSelectedRadio();
			
			//if(selectNumber!=null){
				for(PopupSiteSearch tmp:siteList){
					//if(selectNumber.equalsIgnoreCase(tmp.getRowNumber())){
						//logger.debug(" PopupSiteSearch tmp:"+BeanUtils.getBeanString(tmp));
						semmel006Bean.setPopupSiteCriteria(getPrepaidPrivate(tmp));
						electricIdSelected =  tmp.getElectricId();
						contractNoSelected = tmp.getContractNo();
						Payment payment = semmel006Bean.getPayment();
						ELUtils.copySearchsiteToPayment(tmp, payment);
						ELUtils.setPamentDisplayField(payment);
						semmel006Bean.getPayment().setElectricUseType(semmel006Bean.getPopupSiteCriteria().getElectricUseType());
						semmel006Bean.getPayment().setPayment_channel(tmp.getPayment_channel());
						semmel006Bean.setPayment(payment);						
						changeElectricUseType_ELBill();
					    
						//logger.debug(" --  electricIdSelected:"+electricIdSelected);
						//logger.debug(" --  tmp.getpPayPeriodType()"+ tmp.getpPayPeriodType());
						//logger.debug(" --  tmp.getpPayPeriod03():1"+ tmp.getpPayPeriod03());
						//logger.debug(" --  tmp.getpPayPeriod04():1"+ tmp.getpPayPeriod04());
						//logger.debug(" --  tmp.getpPayPeriod()"  + tmp.getpPayPeriod());
						
						//logger.debug(" --------------------------------------");
						
						if(tmp.getpPayPeriodType().equalsIgnoreCase("03")){
							tmp.setpPayPeriod03(tmp.getpPayPeriod());
					    }else if(tmp.getpPayPeriodType().equalsIgnoreCase("04")){
					    	tmp.setpPayPeriod04(tmp.getpPayPeriod());
					    	
					    }
						//logger.debug(" --  tmp.getpPayPeriod03():2"+ tmp.getpPayPeriod03());
						//logger.debug(" --  tmp.getpPayPeriod04():2"+ tmp.getpPayPeriod04());
						//logger.debug(" --------------------------------------");
					    	
					//}
				//}				
			}				
			
			IVendorMapPayeeELService vendorMapPayeeService = (IVendorMapPayeeELService)getBean("vendorMapPayeeELService");
			VendorMapPayeeEL vendortmp = vendorMapPayeeService.queryVendorMapPayeeMasterForELPayment(contractNoSelected );			
			boolean isFoundVendorMaster = true; 
			if(vendortmp!=null){				
				if(vendortmp.getVendorMasterId()!=null){
					if(vendortmp.getVendorMasterId()!=null&&vendortmp.getVendorMasterId().getVendorCode()!=null){
						semmel006Bean.getPayment().setVendorId(vendortmp.getVendorMasterId().getVendorCode());
					}
					if(vendortmp.getVendorMasterId()!=null&&vendortmp.getVendorMasterId().getVendorName()!=null){
						semmel006Bean.getPayment().setVendorName(vendortmp.getVendorMasterId().getVendorName());
					}					
				}else{
					logger.debug(" VendorMaster is null ,Alert message EL0040" );
					isFoundVendorMaster = false;
				} 
				if(vendortmp.getPayeeMasterId()!=null){
					if(vendortmp.getPayeeMasterId()!=null&&vendortmp.getPayeeMasterId().getRowId()!=null){
						semmel006Bean.getPayment().setPayeeId(vendortmp.getPayeeMasterId().getRowId());
					}
					if(vendortmp.getPayeeMasterId()!=null&&vendortmp.getPayeeMasterId().getPayeeName()!=null){
						semmel006Bean.getPayment().setPayeeName(vendortmp.getPayeeMasterId().getPayeeName());
					}					
				}else{ 
					logger.debug(" PayeeMaster is null ,new requirement not Alert message EL0040" );
					//isFoundVendorMaster = false;
				}										
			}else{
				logger.debug(" Not found VendorMapPayeeEL  ,Alert message EL0040" );
				isFoundVendorMaster = false;
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0040"), ""));
			}		
			
			//  Check Contract No Aready Expense PR_PREPAID 
			logger.debug(" Check Contract No "+contractNoSelected +" Aready Expense PR_PREPAID  " );
			
			logger.debug(" Check Default PaymentType and PaymentMethod by contractId:"+ contractNoSelected);
			IPaymentDefaultService paymentDefaultService = (IPaymentDefaultService)getBean("paymentDefaultService");		
			PaymentDefault paymentDefault = new PaymentDefault();
			paymentDefault.setContractNo(contractNoSelected);		
			paymentDefault.setExpenseType(ELUtils.PR_PREPAID);
			List<PaymentDefault> paymentDefaultList  = 	paymentDefaultService.queryPaymentDefaultByCritiria(paymentDefault,"updateDt","DESC");			
			if(paymentDefaultList!=null&&paymentDefaultList.size()>0){
				for(PaymentDefault pd : paymentDefaultList){
					logger.debug(" Found contractNo "+contractNoSelected +" Aready Expense PR_PREPAID , So set Default PaymentType:"+paymentDefault.getPaymentType()+ " paymentMethod:"+ paymentDefault.getPaymentMethod());
					paymentDefault =  paymentDefaultList.get(0);	
					semmel006Bean.getPayment().setPaymentType(paymentDefault.getPaymentType());
					semmel006Bean.getPayment().setPaymentMethod(paymentDefault.getPaymentMethod());
				}			
			}else{
				logger.debug(" ContractNo "+contractNoSelected +" Never expense PR_PREPAID set PaymentType : 01 and PaymentMethod null");
				semmel006Bean.getPayment().setPaymentType("01");		
				//semmel006Bean.getPayment().setPaymentMethod(null);
				semmel006Bean.getPayment().setPaymentMethod(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.CT_PAYMENT_METHOD));//WT###Add 20110207
			}
			 
			if("02".equals(semmel006Bean.getPayment().getPaymentType())){
				logger.debug("  Default PaymentType is  02  , Get  PayeeBookbank");
				PayeeBookbank bookbank = vendorMapPayeeService.queryVendorMapPayeeMasterBookBank(contractNoSelected);		
				if(bookbank!=null){					
					semmel006Bean.getPayment().setBankAccount(bookbank.getBankAccNo());
					semmel006Bean.getPayment().setBankName(bookbank.getBankAccName());			
				}else{
					logger.debug(" Not found PayeeBookbank" );
					isFoundVendorMaster = false;
				}
			}else{
				logger.debug("  Default PaymentType is not  02  , No get  PayeeBookbank");
			} 
			// Load Meter Id list in case PRPOSPAID			
			logger.debug(" Load Meter Id list belong to electricId :"+electricIdSelected);
			IMeterInfoService meterInfoService = (IMeterInfoService)getBean("meterInfoService");
			MeterInfo meterSearch = new MeterInfo();
			meterSearch.setOutstandingFlag("Y");
			meterSearch.setRecordStatus("Y");
			Management electricId = new Management();
			electricId.setRowId(electricIdSelected);
			meterSearch.setElectricId(electricId);
			List <MeterInfo>  resultList = meterInfoService.queryMeterListForPayment(meterSearch);
			if(resultList!=null&&resultList.size()>0){
				logger.info(" Found MeterInfo list size :"+resultList.size());		
				semmel006Bean.getPopupSiteCriteria().setMeterId(null);
				semmel006Bean.setMeterIdList(ELUtils.getMeterIdList(resultList));
				semmel006Bean.getPayment().setTotalMeterExpense(resultList.size());
			}else{
				semmel006Bean.setMeterIdList(ELUtils.getEmptyList());
				semmel006Bean.getPayment().setTotalMeterExpense(0);
				logger.info(" Not Found MeterInfo list");
			}			
			if(!isFoundVendorMaster){	
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0040"), ""));
				return flag;
			}				
			
			// ***** added by bestnaja *****
			semmel006Bean.setPaymentDetailMeterInfoSection(new PaymentDetail());
			// *****
		
		
		changePaymentTypeELPostpaid();			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flag;
	}
	
	//added by NEW 2016/12/15
	public PopupSiteSearch getPrepaidPrivate(PopupSiteSearch popupSiteSearch){
		List<PopupSiteSearch> popupSiteResultList = new ArrayList<PopupSiteSearch>();
		String electricId = popupSiteSearch.getElectricId();
		PopupSiteSearch popupSearch = new PopupSiteSearch();
		try{
			IManagementService managementService = (IManagementService)getBean("managementService");
			logger.info("START Service getPrepaidPrivate");
			List<PopupSiteSearchPrivate>  popupSiteList = managementService.queryManagementByContractNo06PrepaidByPL(popupSiteSearch);
			logger.info("END Service getPrepaidPrivate");
			if(popupSiteList!=null&&popupSiteList.size()>0){
				int rowNumber =1;
				for(PopupSiteSearchPrivate tmp: popupSiteList){
					

					popupSearch.setRowNumber(""+rowNumber++);
					popupSearch.setElectricId(tmp.getElectricId());					
					popupSearch.setContractNo(tmp.getContractNo());					
					popupSearch.setCompany(tmp.getCompany());
					popupSearch.setOldContractNo(tmp.getOldContractNo());
					popupSearch.setElectricUseType(tmp.getElectricUseType());
					popupSearch.setRecordStatus(tmp.getRecordStatus());
					popupSearch.setContractStartDt(tmp.getContractStartDt());
					popupSearch.setContractEndDt(tmp.getContractEndDt());
					popupSearch.setSiteName(tmp.getSiteName());
					popupSearch.setSiteStatus(tmp.getSiteStatus());
					popupSearch.setNetworkStatus(tmp.getNetworkStatus());
					popupSearch.setLocationId(tmp.getLocationId());
					popupSearch.setLocationCode(tmp.getLocationCode());
					popupSearch.setSiteInfoId(tmp.getSiteInfoId());
					popupSearch.setSiteType(tmp.getSiteType());
					popupSearch.setRegion(tmp.getRegion());
					popupSearch.setPayment_channel(tmp.getPayment_channel());
					popupSearch.setVendor(tmp.getVendor());
					popupSearch.setPayee(tmp.getPayee());
					popupSearch.setResult(tmp.getResult());
					popupSearch.setRemark(tmp.getRemark());
					//---------------------------------------------------
					if(tmp.getpPayPeriod()!= null){
					popupSearch.setpPayPeriod(tmp.getpPayPeriod().toString());
					}
					
					//---------------------------------------------------
					popupSearch.setpTakeAllAmount(tmp.getpTakeAllAmount()==null?new BigDecimal(0):tmp.getpTakeAllAmount());
					popupSearch.setpTakeAllPreiodType(tmp.getpTakeAllPeriodType());
					popupSearch.setpVatType(tmp.getpVatType());
					popupSearch.setpPayPeriodType(tmp.getpPayPeriodType());
					
					ELUtils.setPopupSearchsiteDisplayField(popupSearch);
					
					popupSiteResultList.add(popupSearch);
//					String firstRowId = popupSiteResultList.get(0).getRowNumber();
//					semmel006Bean.setSelectedRadio(firstRowId);	
//					semmel006Bean.setPopupSiteList(popupSiteResultList);
//					semmel006Bean.setSavePopupSiteDisable(false);
					
					if(StringUtils.equalsIgnoreCase(electricId, popupSearch.getElectricId())){
						return popupSearch;
					}
				}
				
//				setSemmel006Bean(semmel006Bean);
			}
		}catch (Exception e) {
			e.printStackTrace();
			logger.debug(e);
			// TODO: handle exception
		}
		return popupSearch;
	}

	private VendorBookbank getVemdorBookBank(String vendorId){
		
		VendorBookbank vendorBookBank = null;
		try{
			IVendorBookbankService vendorBookBankService = (IVendorBookbankService)getBean("vendorBookbankService");
			logger.debug("WT### vendorId="+vendorId);
			logger.info("START Service vendorBookBankService.getVendorBookbankByVendorMasterId");
			vendorBookBank = vendorBookBankService.getVendorBookbankByVendorMasterId(vendorId);
			logger.info("END Service vendorBookBankService.getVendorBookbankByVendorMasterId");
			
		}catch (Exception e) {
		
			e.printStackTrace();
		}
		return vendorBookBank;
	}
	
	public boolean doChangeVatAmtPage65(){	
		logger.info("START Action doChangeVatAmtPage65");
		boolean flagReturn = false;
		try{
			
			SEMMEL006Bean semmel006Bean = getSemmel006Bean();
			
			double includeVat = semmel006Bean.getPaymentDetail().getIncludeVatAmt().doubleValue();
			BigDecimal calculatedVatAmt = new BigDecimal("0");
			double vatAmt = semmel006Bean.getPaymentDetail().getVatAmt().doubleValue();
			double payAmt = 0.0;
			
			String vatType = semmel006Bean.getPaymentDetail().getVatType();
			payAmt = semmel006Bean.getPaymentDetail().getPayAmt().doubleValue();
			
			double vatRate = SEMMEL001Util.VAT_RATE;
			
			logger.debug("WT###vatType="+vatType);
			
			if("01".equalsIgnoreCase(vatType)){ 				// include
				
				calculatedVatAmt = new BigDecimal((payAmt*vatRate)/(100.0+vatRate)).setScale(2, BigDecimal.ROUND_HALF_UP);
				
			}else if("02".equalsIgnoreCase(vatType)){ 			// exclude
				
				calculatedVatAmt = new BigDecimal(payAmt*(vatRate/100.0)).setScale(2, BigDecimal.ROUND_HALF_UP);
			}
			
			// validate vatAmt
			if(Math.abs(calculatedVatAmt.doubleValue() - vatAmt) > 1.0){
				
				semmel006Bean.getPaymentDetail().setVatAmt(calculatedVatAmt);
				semmel006Bean.getPaymentDetail().setExcludeVatAmt(new BigDecimal(includeVat - calculatedVatAmt.doubleValue()));
				
				addMessageError("EL0039");
				
				return flagReturn;
			}
			
			semmel006Bean.getPaymentDetail().setExcludeVatAmt(new BigDecimal(includeVat - vatAmt));
			semmel006Bean.getPaymentDetail().setVatAmt(new BigDecimal(vatAmt));
			
			flagReturn = true;
			
			logger.info("END Action doChangeVatAmtPage65");
		}catch(Exception e){
			logger.info("ERROR Action doChangeVatAmtPage65");
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMEL006");
			FrontMessageUtils.addMessageError(errorMsg);
		}
		
		return flagReturn;
	}
	
	//WT###Add 20110207 Start
	public boolean doChangeVatAmtPage62(){	
		logger.info("START Action doChangeVatAmtPage62");
		boolean flagReturn = false;
		try{
			
			SEMMEL006Bean semmel006Bean = getSemmel006Bean();
			
			double includeVat = semmel006Bean.getPayment().getInvTotalIncludeVat().doubleValue();
			BigDecimal calculatedVatAmt = new BigDecimal("0");
			double vatAmt = semmel006Bean.getPayment().getInvTotalVat().doubleValue();
			double payAmt = 0.0;
			
			String vatType = semmel006Bean.getPayment().getVatType();
			payAmt = semmel006Bean.getPayment().getPayAmt().doubleValue();
			
			double vatRate = SEMMEL001Util.VAT_RATE;
			
			logger.debug("WT###vatType="+vatType);
			logger.debug("WT###payAmt="+payAmt);
			logger.debug("WT###vatAmt="+vatAmt);
			logger.debug("WT###includeVat="+includeVat);
			
			if("01".equalsIgnoreCase(vatType)){ 				// include
				
				calculatedVatAmt = new BigDecimal((payAmt*vatRate)/(100.0+vatRate)).setScale(2, BigDecimal.ROUND_HALF_UP);
				
			}else if("02".equalsIgnoreCase(vatType)){ 			// exclude
				
				calculatedVatAmt = new BigDecimal(payAmt*(vatRate/100.0)).setScale(2, BigDecimal.ROUND_HALF_UP);
			}
			
			// validate vatAmt
			if(Math.abs(calculatedVatAmt.doubleValue() - vatAmt) > 1.0){
				
				semmel006Bean.getPayment().setInvTotalVat(calculatedVatAmt);
				semmel006Bean.getPayment().setInvTotalExcludeVat(new BigDecimal(includeVat - calculatedVatAmt.doubleValue()));
				
				addMessageError("EL0039");
				
				return flagReturn;
			}
			
			semmel006Bean.getPayment().setInvTotalExcludeVat(new BigDecimal(includeVat - vatAmt));
			//semmel006Bean.getPayment().setInvTotalVat(new BigDecimal(vatAmt));
			//WT###Add 20110427 Start
			semmel006Bean.getPayment().setDbTotalVat(semmel006Bean.getPayment().getInvTotalVat());
			semmel006Bean.getPayment().setDbTotalExcludeVat(semmel006Bean.getPayment().getInvTotalExcludeVat());
			//WT###Add 20110427 End
			
			flagReturn = true;
			
			logger.info("END Action doChangeVatAmtPage62");
		}catch(Exception e){
			logger.info("ERROR Action doChangeVatAmtPage62");
			e.printStackTrace();
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMEL006");
			FrontMessageUtils.addMessageError(errorMsg);
		}
		
		return flagReturn;
	}
	//WT###Add 20110207 End
	
	//Momo
	public boolean doChangeVATTypeELTempPage62Popup(){		
		logger.info("Start Action doChangeVATTypeELTempPage62Popup()");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			PaymentDetail notExpenseSite = semmel006Bean.getNotExpenseSite();
			
			//String vatType = notExpenseSite.getVatType();
			doRecalCulateVATPR62Popup();
			logger.info("END Action doChangeVATTypeELTempPage62Popup()");
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return flagValid;			
	}
	public boolean doRecalCulateVATPR62Popup(){		
		logger.debug(" -- doRecalCulateVATPR62Popup()--");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			PaymentDetail notExpenseSite = semmel006Bean.getNotExpenseSite();			
			boolean isWhtcheck = notExpenseSite.isWhtCheckBoolean();
			String whtTypeValue = notExpenseSite.getWhtType();	
			String vatType = notExpenseSite.getVatType();;	
			//logger.debug(" isWhtcheck:"+isWhtcheck+ " whtTypeValue:"+whtTypeValue);
			logger.debug(" vatType:"+vatType);
			
			
			BigDecimal totalPayAmt = new BigDecimal(0);
			BigDecimal totalWhtAmt = new BigDecimal(0);
			BigDecimal totalExVatAmt =  new BigDecimal(0);
			BigDecimal totalVatAmt = new BigDecimal(0);
			BigDecimal totalInVatAmt = new BigDecimal(0);
			BigDecimal totalChqAmt = new BigDecimal(0);
			
			BigDecimal totalSevenVatAmt = new BigDecimal(0);
			BigDecimal totalThreeVatAmt = new BigDecimal(0);
			

			BigDecimal payAmt = notExpenseSite.getPayAmt()==null? new BigDecimal(0):notExpenseSite.getPayAmt();						
			BigDecimal exVatAmt =  notExpenseSite.getExcludeVatAmt()==null? new BigDecimal(0):notExpenseSite.getExcludeVatAmt();					
			totalPayAmt = totalPayAmt.add(payAmt);

			
			if("01".equals(vatType)){
				totalExVatAmt = ELUtils.getExcludeVatFromTotalPay(totalPayAmt);
				totalVatAmt = ELUtils.getVatAmtFromTotalPay(totalPayAmt);
				totalInVatAmt =totalExVatAmt.add(totalVatAmt);
				semmel006Bean.setDisableInvTotalVat(false);
			// ������  VAT
			}else	if("02".equals(vatType)){
				totalExVatAmt = totalPayAmt;
				//totalVatAmt = new BigDecimal(0);
				totalVatAmt = ELUtils.getSevenVAtAmtFromOriginalPrice(totalPayAmt);
				totalInVatAmt =totalPayAmt.add(totalVatAmt);
				semmel006Bean.setDisableInvTotalVat(false);
			// ����� Vat 
			}else if("03".equals(vatType)){
				totalExVatAmt = totalPayAmt;
				totalVatAmt = new BigDecimal(0);
				totalInVatAmt =totalPayAmt;
				semmel006Bean.setDisableInvTotalVat(true);
			}		
			
			totalSevenVatAmt = ELUtils.getAmtPercent(totalPayAmt, new BigDecimal(7));	
			totalChqAmt = totalInVatAmt;
			
			logger.debug("doRecalCulateVATPR62Popup():totalPayAmt:"+totalPayAmt);
			logger.debug("doRecalCulateVATPR62Popup():totalWhtAmt :"+totalWhtAmt);
			logger.debug("doRecalCulateVATPR62Popup():totalExVatAmt :"+totalExVatAmt);
			logger.debug("doRecalCulateVATPR62Popup():totalVatAmt :"+totalVatAmt);
			logger.debug("doRecalCulateVATPR62Popup():totalInVatAmt :"+totalInVatAmt);
			logger.debug("doRecalCulateVATPR62Popup():totalChqAmt :"+totalChqAmt);
			
			
			notExpenseSite.setPayAmt(totalPayAmt);
			notExpenseSite.setExcludeVatAmt(totalExVatAmt);
			notExpenseSite.setVatAmt(totalVatAmt);
			notExpenseSite.setIncludeVatAmt(totalInVatAmt);
			notExpenseSite.setChqAmt(totalChqAmt);
			notExpenseSite.setInvExcludeVatAmt(totalExVatAmt);
			notExpenseSite.setInvVatAmt(totalVatAmt);
			notExpenseSite.setInvIncludeVatAmt(totalInVatAmt);
			semmel006Bean.setPreviosVatAmt(totalVatAmt);
			semmel006Bean.setPreviosWhtAmt(totalWhtAmt);
			
			
			//doChangeWhtType();

		}catch(Exception ex){ 
			ex.printStackTrace();
		}		
		return flagValid;			
	}	
	public boolean doChangeVatAmtPage62Popup(){	
		logger.info("START Action doChangeVatAmtPage62Popup()");
		boolean flagReturn = false;
		try{
			
			SEMMEL006Bean semmel006Bean = getSemmel006Bean();
			
			double includeVat = semmel006Bean.getNotExpenseSite().getInvIncludeVatAmt().doubleValue();
			BigDecimal calculatedVatAmt = new BigDecimal("0");
			double vatAmt = semmel006Bean.getNotExpenseSite().getInvVatAmt().doubleValue();
			double payAmt = 0.0;
			
			//String vatType = semmel006Bean.getPayment().getVatType();
			String vatType = semmel006Bean.getNotExpenseSite().getVatType();
			payAmt = semmel006Bean.getNotExpenseSite().getPayAmt().doubleValue();
			 
			double vatRate = SEMMEL001Util.VAT_RATE;
			
			logger.debug("WT###vatType="+vatType);
			logger.debug("WT###payAmt="+payAmt);
			logger.debug("WT###vatAmt="+vatAmt);
			logger.debug("WT###includeVat="+includeVat);
			
			if("01".equalsIgnoreCase(vatType)){ 				// include
				
				calculatedVatAmt = new BigDecimal((payAmt*vatRate)/(100.0+vatRate)).setScale(2, BigDecimal.ROUND_HALF_UP);
				
			}else if("02".equalsIgnoreCase(vatType)){ 			// exclude
				
				calculatedVatAmt = new BigDecimal(payAmt*(vatRate/100.0)).setScale(2, BigDecimal.ROUND_HALF_UP);
			}
			
			// validate vatAmt
			if(Math.abs(calculatedVatAmt.doubleValue() - vatAmt) > 1.0 ){
				
				semmel006Bean.getNotExpenseSite().setInvVatAmt(calculatedVatAmt);
				semmel006Bean.getNotExpenseSite().setInvExcludeVatAmt(new BigDecimal(includeVat - calculatedVatAmt.doubleValue()));
				semmel006Bean.getNotExpenseSite().setVatAmt(calculatedVatAmt);
				semmel006Bean.getNotExpenseSite().setExcludeVatAmt(new BigDecimal(includeVat - calculatedVatAmt.doubleValue()));
				
				
				addMessageError("EL0039");
				
				return flagReturn;
			}
			
			semmel006Bean.getNotExpenseSite().setInvExcludeVatAmt(new BigDecimal(includeVat - vatAmt));
			semmel006Bean.getNotExpenseSite().setExcludeVatAmt(new BigDecimal(includeVat - vatAmt));
		    
			//semmel006Bean.getPayment().setInvTotalVat(new BigDecimal(vatAmt));
			
			flagReturn = true;
			
			logger.info("END Action doChangeVatAmtPage62Popup()");
		}catch(Exception e){
			logger.info("ERROR Action doChangeVatAmtPage62Popup()");
			e.printStackTrace();
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMEL006");
			FrontMessageUtils.addMessageError(errorMsg);
		}
		
		return flagReturn;
	}
	public void doRecalCulateVATELTempPage62Popup(){		
		logger.debug("START Action doRecalCulateVATELTempPage62Popup()");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			PaymentDetail paymentDetail = semmel006Bean.getNotExpenseSite();		

			String vatType = paymentDetail.getVatType();;	
			logger.debug("vatType"+vatType);
			
			
			BigDecimal totalPayAmt = new BigDecimal(0);
			BigDecimal totalWhtAmt = new BigDecimal(0);
			BigDecimal totalExVatAmt =  new BigDecimal(0);
			BigDecimal totalVatAmt = new BigDecimal(0);
			BigDecimal totalInVatAmt = new BigDecimal(0);
			BigDecimal totalChqAmt = new BigDecimal(0);
			
			BigDecimal totalSevenVatAmt = new BigDecimal(0);
			BigDecimal totalThreeVatAmt = new BigDecimal(0);
			
			BigDecimal payAmt = paymentDetail.getPayAmt()==null? new BigDecimal(0):paymentDetail.getPayAmt();						
			BigDecimal exVatAmt =  paymentDetail.getExcludeVatAmt()==null? new BigDecimal(0):paymentDetail.getExcludeVatAmt();					
			totalPayAmt = totalPayAmt.add(payAmt);

			
			if("01".equals(vatType)){
				logger.debug(" VAT ");
				totalExVatAmt = ELUtils.getExcludeVatFromTotalPay(totalPayAmt);
				totalVatAmt = ELUtils.getVatAmtFromTotalPay(totalPayAmt);
				totalInVatAmt =totalExVatAmt.add(totalVatAmt);
			
			}else if("02".equalsIgnoreCase(vatType)){
				//doRecalCulateVATPR();

				totalExVatAmt = totalPayAmt;
				totalVatAmt = ELUtils.getSevenVAtAmtFromOriginalPrice(totalPayAmt);
				totalInVatAmt =totalPayAmt.add(totalVatAmt);
			}else if("03".equals(vatType)){
				logger.debug(" No VAT ");
				totalExVatAmt = totalPayAmt;
				totalVatAmt = new BigDecimal(0);
				totalInVatAmt =totalPayAmt;
			}		
	
			
			//totalSevenVatAmt = ELUtils.getAmtPercent(totalPayAmt, new BigDecimal(7));
			
			
			BigDecimal withholdingTax  = paymentDetail.getWhtRate()==null?new BigDecimal(0):paymentDetail.getWhtRate();	
			totalThreeVatAmt = ELUtils.getAmtPercent(totalPayAmt, withholdingTax);		
			
			totalWhtAmt = totalExVatAmt.multiply(withholdingTax).divide(new BigDecimal(100),2,BigDecimal.ROUND_HALF_UP);		
	
			totalChqAmt = totalPayAmt.subtract(totalThreeVatAmt).add(totalThreeVatAmt).setScale(2,BigDecimal.ROUND_HALF_UP);
			
			paymentDetail.setWhtAmt(totalWhtAmt);
			paymentDetail.setPayAmt(totalPayAmt);
			paymentDetail.setExcludeVatAmt(totalExVatAmt);
			paymentDetail.setVatAmt(totalVatAmt);
			paymentDetail.setIncludeVatAmt(totalInVatAmt);
			paymentDetail.setChqAmt(totalChqAmt);
			paymentDetail.setInvExcludeVatAmt(totalExVatAmt);
			paymentDetail.setInvVatAmt(totalVatAmt);
			paymentDetail.setInvIncludeVatAmt(totalInVatAmt);
			
			//logger.debug(" semmel006Bean.getNotExpenseSite().getExcludeVatAmt() :"+ semmel006Bean.getNotExpenseSite().getExcludeVatAmt());
			semmel006Bean.setPreviosVatAmt(totalVatAmt);
			//semmel006Bean.setNotExpenseSite(paymentDetail);
			
			logger.debug("  totalPayAmt:"+paymentDetail.getPayAmt());
			logger.debug(" totalExVatAmt :"+paymentDetail.getExcludeVatAmt());
			logger.debug(" totalVatAmt :"+paymentDetail.getVatAmt());
			logger.debug(" totalInVatAmt :"+paymentDetail.getIncludeVatAmt());
			logger.debug(" totalChqAmt :"+paymentDetail.getChqAmt());
			logger.debug("END Action doRecalCulateVATELTempPage62Popup()");
		}catch(Exception ex){
			ex.printStackTrace();
			logger.debug("ERROR Action doRecalCulateVATELTempPage62Popup() : "+ex, ex);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMEL006");
			FrontMessageUtils.addMessageError(errorMsg);
		}		
	}
	
	public boolean doChangeVATTypeELPage62(){		
		logger.info("Start Action doChangeVATTypeELPage62");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			Payment payment = semmel006Bean.getPayment();			
			String vatType = payment.getVatType();
			doRecalCulateVATPR62();
			recalculateAdNewExpenseSite();
			//dddddddddddddd
			logger.info("END Action doChangeVATTypeELPage62");
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return flagValid;			
	}
    
	public SEMMEL005Bean getSemmel005Bean() {
		return (SEMMEL005Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmel005Bean");
	}
	
	public void setSemmel005Bean(SEMMEL005Bean semmel005Bean) {
		this.semmel005Bean = semmel005Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmel005Bean", this.semmel005Bean);
	}
	
	private boolean initPaymentELUploadText() {
		logger.info("START Action initPaymentELUploadText");
		boolean flagValid = false;
		try{
			semmel006Bean = getSemmel006Bean();					
			initialData();
			semmel006Bean.setElectricUseTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name));			
			semmel006Bean.setElExpenseTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name));		
			semmel006Bean.setElDocTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DOC_TYPE.name));
			semmel006Bean.setMeterIdList(ELUtils.getEmptyList());
			semmel006Bean.setCtPaymentTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_TYPE.name));//WT###Add 20110117			
			semmel006Bean.setCtPaymentMethodList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name));//WT###Add 20110117
			semmel006Bean.setMonthList(ELUtils.getMonthDropDownList());//WT###Add 20110117
			semmel006Bean.setYearList(ELUtils.getYearDropDownList());//WT###Add 20110117
			semmel006Bean.setRecordStatusList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_OUTSTANDING_FLAG.name));//WT###Add 20110117	
			semmel006Bean.getPaymentDetail().setVatType("01");//WT###Add 20110128
			semmel006Bean.setElExpenseTypeList(ELUtils.filterLOVByLOVValue("4", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name)));		
			semmel006Bean.setElDocTypeList(ELUtils.filterLOVByLOVValue("5", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DOC_TYPE.name)));
			
			Payment payment = semmel006Bean.getPayment();
			//Payment payment = new Payment();
			payment.setDocType("I");
			payment.setPaymentType("01");	
			payment.setExpenseType("EL_POSTPAID");
			semmel006Bean.getPayment().setPaymentMethod(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.CT_PAYMENT_METHOD));//WT###Add 20110207
			Map<String,String> codeMap = new HashMap();
//			codeMap.put(ELUtils.PAYMENT_METHOD_01,ELUtils.PAYMENT_METHOD_01);
//			codeMap.put(ELUtils.PAYMENT_METHOD_02,ELUtils.PAYMENT_METHOD_02);
//			codeMap.put(ELUtils.PAYMENT_METHOD_03,ELUtils.PAYMENT_METHOD_03);
//			codeMap.put(ELUtils.PAYMENT_METHOD_04,ELUtils.PAYMENT_METHOD_04);
//			semmel006Bean.setCtPaymentMethodList(ELUtils.getLOVBtLOVCodeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name), codeMap));
			semmel006Bean.setCtPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name,EX_AND,"CHEQUE",null,null));
			semmel006Bean.setTransferDtDisable(true);
			
			PopupSiteSearch popupSiteSearch = new PopupSiteSearch();
			semmel006Bean.setPopupSiteCriteria(popupSiteSearch);
			semmel006Bean.setPaymentDetailList(new ArrayList());
			semmel006Bean.setDisableUpdateModelButton(true);
			semmel006Bean.setDisableAddModelButton(false);
			semmel006Bean.setDisableMoreThanOneDetail(false);
			
			semmel006Bean.setPaymentTypeMandatory(true);
			semmel006Bean.setPaymentMethodMandatory(true);
			semmel006Bean.setPaymentTypeDisable(false);
			semmel006Bean.setPaymentMethodDisable(false);
			
			setSemmel006Bean(semmel006Bean);
			semmel006Bean.setViewMode(false);
			flagValid= true;		
			
			//WT###Add 20110202 Start
			semmel006Bean.setDisableViewExpenseHisButton(true);
			semmel006Bean.setDisableViewMeterInfoButton(true);
			//WT###End 20110202 End
			
			logger.info("END Action initPaymentELUploadText");
		}catch(Exception ex){
			ex.printStackTrace();
			logger.info("ERROR Action initPaymentELUploadText : "+ex, ex);
		}

     	return flagValid;
	}
	
	private boolean initPaymentUploadText(){
		logger.info("START Action initPaymentUploadText ");	
		boolean flagValid = false;		
		try{
			init();
			initPaymentELUploadText();
			String isComeFromOtherPage = (String)getFacesUtils().getRequestParameter("isComeFromOtherPage");//Y
			String reqContractNo = (String)getFacesUtils().getRequestParameter("contractNo");//Y
			String rowId = (String)getFacesUtils().getRequestParameter("rowId");//Y
			int index = new Integer(rowId).intValue();
			
			logger.info("reqContractNo:"+reqContractNo);
			logger.info("rowIdInt:"+index);
			
			if(null!=isComeFromOtherPage && "Y".equals(isComeFromOtherPage)){
				String navModuleFrom = (String)getFacesUtils().getRequestParameter("navModuleFrom");
				String navProgramFrom = (String)getFacesUtils().getRequestParameter("navProgramFrom");				
				String actionWithNaviFrom = (String)getFacesUtils().getRequestParameter("actionWithNaviFrom");
				String methodWithNaviFrom = (String)getFacesUtils().getRequestParameter("methodWithNaviFrom");
				semmel006Bean.setFromAction(true);
				semmel006Bean.setNavModuleFrom(navModuleFrom);
				semmel006Bean.setNavProgramFrom(navProgramFrom);
				semmel006Bean.setActionWithNaviFrom(actionWithNaviFrom);
				semmel006Bean.setMethodWithNaviFrom(methodWithNaviFrom);
				semmel006Bean.setDisableViewMeterInfoButton(false);
				semmel006Bean.setDisableViewExpenseHisButton(false);
				semmel006Bean.setComeFromOtherPage(true);
				semmel006Bean.setSave(false);
				//semmel006Bean.setDisable(false);
				
				
			}
			
			
			semmel005Bean = getSemmel005Bean();
			List<UploadText> uploadTextSuccessNoPaidList = semmel005Bean.getUploadTextSuccessNoPaidList();
			UploadText uploadText =  uploadTextSuccessNoPaidList.get(index);
			String contractNo = uploadText.getContractNo();
			String meterId = uploadText.getMeterId();
			
			int pRead = 0;
			int lRead = 0;
			String termOfPaymentDtMonth = "";
			String termOfPaymentDtYear = "";
			BigDecimal payAmt = new BigDecimal(0);
			String transacId = null;
			
			//PaymentDetail paymentDetail = semmel006Bean.getPaymentDetail();
			try{
				logger.info("uploadText.getpRead():"+uploadText.getpRead());
				logger.info("uploadText.getlRead():"+uploadText.getlRead());
				logger.info("uploadText.getBillperiod():"+uploadText.getBillperiod());
				logger.info("uploadText.getInvAmt():"+uploadText.getInvAmt());
				logger.info("uploadText.getRowId()():"+uploadText.getRowId());
				
				if (!StringUtils.isEmpty(uploadText.getpRead())){
					pRead = new Integer(uploadText.getpRead()).intValue();
				}
				
				if (!StringUtils.isEmpty(uploadText.getlRead())){
					lRead = new Integer(uploadText.getlRead()).intValue();
				}
				if(uploadText.getBillperiod() != null){
					termOfPaymentDtMonth = ELUtils.getMonthNumberByDate(uploadText.getBillperiod());
					termOfPaymentDtYear  = ELUtils.getYearNumberByDate(uploadText.getBillperiod(),"th");
					logger.info("termOfPaymentDtYear():"+termOfPaymentDtYear);
				}
				if(uploadText.getInvAmt() != null){
					//payAmt = ELUtils.getExcludeVatFromTotalPay(uploadText.getInvAmt());
					payAmt = uploadText.getInvAmt();
				}
				
				if (!StringUtils.isEmpty(uploadText.getRowId())||uploadText.getRowId() == null){
					transacId = uploadText.getRowId();
				}
				
			//int kwhTotal = new Integer(uploadText.getKwhTotal()).intValue();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			logger.info("contractNo:"+contractNo);
			logger.info("meterId:"+meterId);
			
			if (contractNo != null && meterId != null){
				semmel006Bean.getPopupSiteCriteria().setContractNo(contractNo);
				semmel006Bean.getPopupSiteCriteria().setMeterId(meterId);
				doSearchSiteEL();
				semmel006Bean.getPaymentDetail().setpDate(uploadText.getpDt());
				semmel006Bean.getPaymentDetail().setlDate(uploadText.getlDt());
				semmel006Bean.getPaymentDetail().setpRead(new BigDecimal(pRead));
				semmel006Bean.getPaymentDetail().setlRead(new BigDecimal(lRead));
				semmel006Bean.getPaymentDetail().setKwhTotal(uploadText.getKwhTotal());
				semmel006Bean.getPaymentDetail().setTermOfPaymentDtMonth(termOfPaymentDtMonth);
				semmel006Bean.getPaymentDetail().setTermOfPaymentDtYear(termOfPaymentDtYear);
				semmel006Bean.getPaymentDetail().setPayAmt(payAmt);
				semmel006Bean.getPayment().setTransID(transacId);
				
				doRecalCulateVATELTempPage63();
				flagValid = true;
			}
			else
			{
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0040"), ""));
				flagValid = false;
			}
			
			logger.info("PaymentType:"+semmel006Bean.getPayment().getPaymentType());
				
			logger.info("END Action initPaymentUploadText ");	
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flagValid;	
	}
	public boolean doSearchVendorDetail() {
		logger.debug(" doSearchVendorDetail()");
		boolean flag = false; 
		try{
			semmel006Bean = getSemmel006Bean();
			List<PopupSiteSearch> siteList = semmel006Bean.getPopupSiteList();					
			String electricIdSelected = "";
			String contractNoSelected ="";
			String paymentType ="";
			for(PopupSiteSearch tmp:siteList){
					//if(selectNumber.equalsIgnoreCase(tmp.getRowNumber())){
						//logger.debug(" PopupSiteSearch tmp:"+BeanUtils.getBeanString(tmp));
						semmel006Bean.setPopupSiteCriteria(tmp);
						electricIdSelected =  tmp.getElectricId();
						contractNoSelected = tmp.getContractNo();
						Payment payment = semmel006Bean.getPayment();
						ELUtils.copySearchsiteToPayment(tmp, payment);
						ELUtils.setPamentDisplayField(payment);
						semmel006Bean.getPayment().setElectricUseType(semmel006Bean.getPopupSiteCriteria().getElectricUseType());
						semmel006Bean.setPayment(payment);						
						changeElectricUseType_ELBill();
						
						if(tmp.getpPayPeriodType().equalsIgnoreCase("03")){
							tmp.setpPayPeriod03(tmp.getpPayPeriod());
					    }else if(tmp.getpPayPeriodType().equalsIgnoreCase("04")){
					    	tmp.setpPayPeriod04(tmp.getpPayPeriod());
					    	
					    }
						
			}				
			
			IVendorMapPayeeELService vendorMapPayeeService = (IVendorMapPayeeELService)getBean("vendorMapPayeeELService");
			VendorMapPayeeEL vendortmp = vendorMapPayeeService.queryVendorMapPayeeMasterForELPayment(contractNoSelected );			
			boolean isFoundVendorMaster = true; 
			if(vendortmp!=null){				
				if(vendortmp.getVendorMasterId()!=null){
					if(vendortmp.getVendorMasterId()!=null&&vendortmp.getVendorMasterId().getVendorCode()!=null){
						semmel006Bean.getPayment().setVendorId(vendortmp.getVendorMasterId().getVendorCode());
					}
					if(vendortmp.getVendorMasterId()!=null&&vendortmp.getVendorMasterId().getVendorName()!=null){
						semmel006Bean.getPayment().setVendorName(vendortmp.getVendorMasterId().getVendorName());
					}					
				}else{
					logger.debug(" VendorMaster is null ,Alert message EL0040" );
					isFoundVendorMaster = false;
				} 
				if(vendortmp.getPayeeMasterId()!=null){
					if(vendortmp.getPayeeMasterId()!=null&&vendortmp.getPayeeMasterId().getRowId()!=null){
						semmel006Bean.getPayment().setPayeeId(vendortmp.getPayeeMasterId().getRowId());
					}
					if(vendortmp.getPayeeMasterId()!=null&&vendortmp.getPayeeMasterId().getPayeeName()!=null){
						semmel006Bean.getPayment().setPayeeName(vendortmp.getPayeeMasterId().getPayeeName());
					}					
				}else{ 
					logger.debug(" PayeeMaster is null ,new requirement not Alert message EL0040" );
					//isFoundVendorMaster = false;
				}										
			}else{
				logger.debug(" Not found VendorMapPayeeEL  ,Alert message EL0040" );
				isFoundVendorMaster = false;
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0040"), ""));
			}		
			
			//  Check Contract No Aready Expense PR_PREPAID 
			/*
			logger.debug(" Check Default PaymentType and PaymentMethod by contractId:"+ contractNoSelected);
			IPaymentDefaultService paymentDefaultService = (IPaymentDefaultService)getBean("paymentDefaultService");		
			PaymentDefault paymentDefault = new PaymentDefault();
			paymentDefault.setContractNo(contractNoSelected);		
			paymentDefault.setExpenseType(ELUtils.PR_PREPAID);
			List<PaymentDefault> paymentDefaultList  = 	paymentDefaultService.queryPaymentDefaultByCritiria(paymentDefault,"updateDt","DESC");			
			if(paymentDefaultList!=null&&paymentDefaultList.size()>0){
				for(PaymentDefault pd : paymentDefaultList){
					logger.debug(" Found contractNo "+contractNoSelected +" Aready Expense PR_PREPAID , So set Default PaymentType:"+paymentDefault.getPaymentType()+ " paymentMethod:"+ paymentDefault.getPaymentMethod());
					paymentDefault =  paymentDefaultList.get(0);	
					semmel006Bean.getPayment().setPaymentType(paymentDefault.getPaymentType());
					semmel006Bean.getPayment().setPaymentMethod(paymentDefault.getPaymentMethod());
				}			
			}else{
				logger.debug(" ContractNo "+contractNoSelected +" Never expense PR_PREPAID set PaymentType : 01 and PaymentMethod null");
				semmel006Bean.getPayment().setPaymentType("01");		
				//semmel006Bean.getPayment().setPaymentMethod(null);
				semmel006Bean.getPayment().setPaymentMethod(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.CT_PAYMENT_METHOD));//WT###Add 20110207
			}
			 */
			if("02".equals(semmel006Bean.getPayment().getPaymentType())){
				logger.debug("  Default PaymentType is  02  , Get  PayeeBookbank");
				PayeeBookbank bookbank = vendorMapPayeeService.queryVendorMapPayeeMasterBookBank(contractNoSelected);		
				if(bookbank!=null){					
					semmel006Bean.getPayment().setBankAccount(bookbank.getBankAccNo());
					semmel006Bean.getPayment().setBankName(bookbank.getBankAccName());			
				}else{
					logger.debug(" Not found PayeeBookbank" );
					isFoundVendorMaster = false;
				}
			}else{
				logger.debug("  Default PaymentType is not  02  , No get  PayeeBookbank");
			} 
			// Load Meter Id list in case PRPOSPAID			
			logger.debug(" Load Meter Id list belong to electricId :"+electricIdSelected);
			IMeterInfoService meterInfoService = (IMeterInfoService)getBean("meterInfoService");
			MeterInfo meterSearch = new MeterInfo();
			meterSearch.setOutstandingFlag("Y");
			meterSearch.setRecordStatus("Y");
			Management electricId = new Management();
			electricId.setRowId(electricIdSelected);
			meterSearch.setElectricId(electricId);
			List <MeterInfo>  resultList = meterInfoService.queryMeterListForPayment(meterSearch);
			if(resultList!=null&&resultList.size()>0){
				logger.info(" Found MeterInfo list size :"+resultList.size());		
				semmel006Bean.getPopupSiteCriteria().setMeterId(null);
				semmel006Bean.setMeterIdList(ELUtils.getMeterIdList(resultList));
				semmel006Bean.getPayment().setTotalMeterExpense(resultList.size());
			}else{
				semmel006Bean.setMeterIdList(ELUtils.getEmptyList());
				semmel006Bean.getPayment().setTotalMeterExpense(0);
				logger.info(" Not Found MeterInfo list");
			}			
			if(!isFoundVendorMaster){	
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0040"), ""));
				return flag;
			}				
			
			// ***** added by bestnaja *****
			semmel006Bean.setPaymentDetailMeterInfoSection(new PaymentDetail());
			// *****

		changePaymentTypeELPostpaid();			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flag;
	}
	
	private boolean doSearchSiteEL() {
		logger.debug(" -- doSearchSiteEL--");
		boolean flag = false;
		try {
			semmel006Bean = getSemmel006Bean();
			semmel006Bean.setSavePopupSiteDisable(true);
			List<PopupSiteSearch> popupSiteResultList = null;			
			logger.debug(" -- doSearchSiteEL :"+semmel006Bean.getPopupSiteCriteria().getRecordStatus());
		

			if("All".equals(semmel006Bean.getPopupSiteCriteria().getRecordStatus())){
				semmel006Bean.getPopupSiteCriteria().setRecordStatus(null);
			}
			
			IPaymentService service = (IPaymentService)getBean("paymentService");	
			popupSiteResultList= service.searchSite(semmel006Bean.getPopupSiteCriteria(),"querySiteELPostpaid");
			logger.debug(" Result Search :"+popupSiteResultList);					
			PopupSiteSearch selectSite = null;
			if (popupSiteResultList != null && !popupSiteResultList.isEmpty()) {
				selectSite = popupSiteResultList.get(0);
				semmel006Bean.setPopupSiteCriteria(selectSite);
				semmel006Bean.getPayment().setElectricUseType(semmel006Bean.getPopupSiteCriteria().getElectricUseType());
				changeElectricUseType_ELPospaid();
				
				//String firstRowId = popupSiteResultList.get(0).getRowNumber();
				//semmel006Bean.setSelectedRadio(firstRowId);	
				//semmel006Bean.setPopupSiteList(popupSiteResultList);
				//semmel006Bean.setSavePopupSiteDisable(false);
				//for(PopupSiteSearch tmp:popupSiteResultList){
					//logger.debug(" PopupSiteSearch:"+BeanUtils.getBeanString(tmp));
					
				//}
			}else{
				semmel006Bean.setPopupSiteList(new ArrayList());
				flag = true;
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("M0004"), ""));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}



	
	
	// ######################### Start Button 7 ####################
 
	private boolean initPayment7() {
		logger.debug(" -- initPayment7 --");
		boolean flagValid = false;
		try{
			semmel006Bean = getSemmel006Bean();		
			
			// Initial Domain and Set Default
			Management management = new Management();
			MeterInfo meterInfo = new MeterInfo();			
			initialData();
			//PopupSiteSearch popupSiteSearch = new PopupSiteSearch();
			//semmel006Bean.setPopupSiteCriteria(popupSiteSearch);
			semmel006Bean.setPopupSiteSearch7(new PopupSiteSearch7());
			semmel006Bean.setPopupSiteCriteria(new PopupSiteSearch());
			semmel006Bean.setPaymentDetailList(new ArrayList());
			semmel006Bean.setInstallmentSearch7lList(new ArrayList());
			semmel006Bean.getPaymentDetail().setVatType("01");
			Payment payment = getInitailPayment();
			payment.setVatType("01");
			if (payment.getCreateDt()!=null){
				payment.setDisplayCreateDate(SEMDataUtility.convertToThYear(payment.getCreateDt()));
			}
			if (payment.getUpdateDt()!=null){
				payment.setDisplayUpdateDate(SEMDataUtility.convertToThYear(payment.getUpdateDt()));
			}
			semmel006Bean.setPayment(payment);
			semmel006Bean.getPayment().setCrPayInFlagBoolean(false);
			semmel006Bean.getPayment().setCrCreditFlagBoolean(true);
			semmel006Bean.setMeterInfo(meterInfo);
			semmel006Bean.setMeterIdList(ELUtils.getEmptyList());
			
			logger.info(" ## Company ##  "+ semmel006Bean.getPopupSiteSearch7().getCompany());
			logger.info(" ## ElectricUseTypeDisplay ##  "+ semmel006Bean.getPopupSiteSearch7().getElectricUseTypeDisplay());
			//111111111111
			//semmel006Bean.getPayment().setPaymentMethod(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.CT_PAYMENT_METHOD));
			
			// Initial Dropdown
			semmel006Bean.setCrBankNameList(  LOVCacheUtil.getInstance().getByLOVType(ELovType.CT_CR_BANK.name)  );			 
			semmel006Bean.setElDocTypeList(ELUtils.filterLOVByLOVValue("1", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DOC_TYPE.name)));			
			//------------
			semmel006Bean.setRenderPage7(true);
			semmel006Bean.setDisablePage7(false);
			semmel006Bean.setComeFromPage8(false);

			
			flagValid = true;	

		}catch(Exception ex){
			ex.printStackTrace();
		}

		return flagValid;
	}	
	

	public boolean doChangePayInFlage(){		
		logger.info(" ## Start  doChangePayInFlage ##  ");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			Payment payment = semmel006Bean.getPayment();	
			
			logger.info("  payment.isCrPayInFlagBoolean():"+payment.isCrPayInFlagBoolean());
			 
		 
			logger.info(" ## END  doChangePayInFlage ## ");
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return flagValid;			
	}	
	
	public boolean doChangeCreditFlag(){		
		logger.info(" ## Start  doChangeCreditFlag ##  ");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			Payment payment = semmel006Bean.getPayment();	
			logger.info("  payment.isCrCreditFlagBoolean():"+payment.isCrCreditFlagBoolean());
		 
			logger.info(" ## END  doChangeCreditFlag ## ");
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return flagValid;			
	}		

	
	
	private boolean doSave7() {
		logger.debug(" -- doSave7--");
		boolean flagValid = false;				
		try {
			
			semmel006Bean = getSemmel006Bean();	
			Payment paymentSave = semmel006Bean.getPayment();
			paymentSave.getDocType();
			logger.debug("paymentSave.getDocType(1):"+paymentSave.getDocType());
			if (validateSave7()) {
				return flagValid;
			}	
			logger.debug("paymentSave.getDocType(2):"+paymentSave.getDocType());
			logger.debug(" Validate PASS .... next step ");
			
			 
			String electricIdStr = semmel006Bean.getPopupSiteSearch7().getElectricId();
			//String meterInfoId = semmel006Bean.getPopupSiteSearch7().getMeterId();
			//Payment paymentSave = semmel006Bean.getPayment();
			Management electricId = new Management();
			electricId.setRowId(electricIdStr);
			paymentSave.setElectricId(electricId);
			//paymentSave.setSiteInfoId(semmel006Bean.getPopupSiteCriteria().getSiteInfoId());
			//paymentSave.setSiteType(semmel006Bean.getPopupSiteCriteria().getSiteType());
			paymentSave.setRegion(semmel006Bean.getPopupSiteSearch7().getRegion());
			//paymentSave.setExpenseType(ELUtils.EL_POSTPAID);			
			paymentSave.setRecordStatus("Y");
			paymentSave.setVersion(new BigDecimal(1));
			
			if(paymentSave.getWhtAmt() != null){
				if(paymentSave.getWhtAmt().doubleValue()==0.0){
				paymentSave.setWhtAmt(null);
				}
			}
			
			paymentSave.setPaymentStatus("01");
			paymentSave.setVatType(semmel006Bean.getPayment().getVatType());
			paymentSave.setVatRate(new BigDecimal(7));
			
			
			List<PaymentDetail> detailList = semmel006Bean.getPaymentDetailList();
			for(PaymentDetail detailtmp:detailList){
				detailtmp.setVatRate(new BigDecimal(7));
				detailtmp.setExpenseType(paymentSave.getExpenseType());
				detailtmp.setVatType(paymentSave.getVatType());
				detailtmp.setCreateBy(paymentSave.getCreateBy());
				detailtmp.setCreateDt(paymentSave.getCreateDt());
				detailtmp.setRecordStatus("Y");
			}				
			logger.debug(" Detail List :"+detailList.size());			
			    
			IPaymentService service = (IPaymentService)getBean("paymentService");	
			ParameterConfig paramPLName = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_PAYMENT_E005");
			logger.debug("   paramPLName:"+paramPLName);
			boolean saveResult = service.savePaymentPage7(paymentSave, detailList,  paramPLName.getParamValue());
			logger.debug(" SavePaymentPage7 Result xx :"+saveResult);
			initPayment7();
			logger.info("END <<<<Service SavePaymentPage7>>>");
			addMessageInfo("M0001");
			
		
	} catch (Exception e) {
		addMessageError(ELUtils.E0001);
		e.printStackTrace();
	}
	return flagValid;
			
	
	}
	private boolean initPopupSearchSite7() {
		boolean flag = false;
		logger.debug(" -- initPopupSearchSite7--");
		try{
 
			
		}catch(Exception ex){
			ex.printStackTrace();
		}

		return flag;
	}	
	
	private boolean doClearSearchSite7() {
		logger.debug(" -- doClearSearchSite7--");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();			
			semmel006Bean.setPopupSiteSearch7(new PopupSiteSearch7());
			semmel006Bean.setPopupSite7List(new ArrayList());	
			semmel006Bean.setSavePopupSiteDisable(true);			
		}catch(Exception ex){
			ex.printStackTrace();
		}

		return flagValid;
	}		
	private boolean doSearchPopupSite7() {
		logger.debug(" -- doSearchPopupSite7--");
		boolean flag = false;
		try {
			if(validatePopupSiteSearch7()){
           	 return false;
            }
			
			semmel006Bean = getSemmel006Bean();
			semmel006Bean.setSavePopupSiteDisable(true);
			List<PopupSiteSearch7> popupSiteResultList = null;					
			IPaymentService service = (IPaymentService)getBean("paymentService");	
			popupSiteResultList= service.searchSite7(semmel006Bean.getPopupSiteSearch7(),"querySite7");
			logger.debug(" Result Search :"+popupSiteResultList);					
			if (popupSiteResultList != null && !popupSiteResultList.isEmpty()) {			
				String firstRowId = popupSiteResultList.get(0).getElectricId();
				semmel006Bean.setSelectedRadio(firstRowId);	
				semmel006Bean.setPopupSite7List(popupSiteResultList);
				semmel006Bean.setSavePopupSiteDisable(false); 
			}else{
				semmel006Bean.setPopupSite7List(new ArrayList());
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("M0004"), ""));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}	
	
	private boolean initPopupSearchOldDoc7() {
		logger.debug(" --  initPopupSearchOldDoc7 --");
		boolean flag = false;
		try{
			semmel006Bean = getSemmel006Bean();
			semmel006Bean.setPopupOldDoc7List(new ArrayList());
			PopupOldDocSearch7 popupOldDocSearch = new PopupOldDocSearch7();
			popupOldDocSearch.setCompany(semmel006Bean.getPopupSiteSearch7().getCompany());
			popupOldDocSearch.setElectricUseType(semmel006Bean.getPopupSiteSearch7().getElectricUseType());
			popupOldDocSearch.setElectricUseTypeDisplay(semmel006Bean.getPopupSiteSearch7().getElectricUseTypeDisplay());
			semmel006Bean.setSavePopupOldDocDisable(true);
			semmel006Bean.setPopupOldDocCriteria7(popupOldDocSearch);	
			semmel006Bean.setPopupOldDocList(new ArrayList());		
		}catch(Exception ex){
			ex.printStackTrace();
		}

		return flag;
	}	
	private boolean doClearSearchOldDoc7() {
		logger.debug(" -- doClearSearchOldDoc7--");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();
			initPopupSearchOldDoc7();
			semmel006Bean.setPopupOldDoc7List(new ArrayList());
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	
		return flagValid;
	}	

	private boolean doSearchPopupOldDoc7() {
		boolean flag = false;
		try {
             
             
			semmel006Bean = getSemmel006Bean();
			String contractNo = semmel006Bean.getPopupSiteSearch7().getContractNo();
			semmel006Bean.getPopupOldDocCriteria7().setContractNo(contractNo);
			List<PopupOldDocSearch7> popupOldDoc7List = null;			
			IPaymentService service = (IPaymentService)getBean("paymentService");			
			popupOldDoc7List= service.searchOldDoc7(semmel006Bean.getPopupOldDocCriteria7());
			semmel006Bean.setPopupOldDoc7List(popupOldDoc7List);
			logger.debug(" Result Search :"+popupOldDoc7List.size());			
 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	private boolean validateSave7() {
		logger.debug(" -- validateSave7--");
		boolean flagValid = false;
		try{
			 
			Payment payment = getSemmel006Bean().getPayment();
			
			if (StringUtils.isEmpty(payment.getCompany())) {
				FrontMessageUtils.addMessageError( 
						SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.company")));
				flagValid = true;
			}			
			if (StringUtils.isEmpty(payment.getContractNo())) {
				FrontMessageUtils.addMessageError( 
						SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.contractNo")));
				flagValid = true;
			}				
			
			// Validate if Uncheck  PayInFlag
			if(payment.isCrPayInFlagBoolean()){
				
				if (StringUtils.isEmpty(payment.getCrBankName())) {
					FrontMessageUtils.addMessageError( 
							SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.crBankName")));
					flagValid = true;
				}	
				if ( payment.getCrPayinAmt()==null||payment.getCrPayinAmt().intValue()==0) {
					FrontMessageUtils.addMessageError(
							SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.crPayinAmt")));
					flagValid = true;
				}				
				
				if ( payment.getCrPayInDt()==null)  {
					FrontMessageUtils.addMessageError( 
							SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.crPayinDt")));
					flagValid = true;
				}			
			}
			
			// Validate if Uncheck  CreditFlag
			if(payment.isCrCreditFlagBoolean()){
				if (StringUtils.isEmpty(payment.getExpenseType())) {
					FrontMessageUtils.addMessageError( 
							SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.expenseType")));
					flagValid = true;
				}				
				if (StringUtils.isEmpty(payment.getDocType())) {
					FrontMessageUtils.addMessageError( 
							SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.docType")));
					flagValid = true;
				}
				if (StringUtils.isEmpty(payment.getDocNo())) {
					FrontMessageUtils.addMessageError( 
							SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.docNo")));
					flagValid = true;
				}
				if ( payment.getDocDt()==null)  {
					FrontMessageUtils.addMessageError( 
							SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.docDt")));
					flagValid = true;
				}					
				if (StringUtils.isEmpty(payment.getRefDocNo())) {
					FrontMessageUtils.addMessageError( 
							SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.refDocNo")));
					flagValid = true;
				}
				/*
				if ( payment.getRefDocDt()==null)  {
					FrontMessageUtils.addMessageError( 
							SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.refDocDt")));
					flagValid = true;
				}					
				
				if (StringUtils.isEmpty(payment.getVendorId())) {
					FrontMessageUtils.addMessageError( 
							SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vendorId")));
					flagValid = true;
				}				
				
				
				if (StringUtils.isEmpty(payment.getVendorName())) {
					FrontMessageUtils.addMessageError( 
							SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vendorName")));
					flagValid = true;
				}	
				*/
				if ( payment.getPayAmt()==null||payment.getPayAmt().intValue()==0) {
					FrontMessageUtils.addMessageError(
							SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.payAmt")));
					flagValid = true;
				}	
				
				if (StringUtils.isEmpty(payment.getVatType())) {
					FrontMessageUtils.addMessageError( 
							SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vatType")));
					flagValid = true;
				}					
				
				if ( payment.getExcludeVatAmt()==null||payment.getExcludeVatAmt().intValue()==0) {
					FrontMessageUtils.addMessageError(
							SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.excludeVatAmt")));
					flagValid = true;
				}
				
				if(!payment.getVatType().equalsIgnoreCase("03")){
					
				if ( payment.getVatAmt()==null||payment.getVatAmt().intValue()==0) {
					FrontMessageUtils.addMessageError(
							SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vatAmt")));
					flagValid = true;
				}
				}
				if ( payment.getIncludeVatAmt()==null||payment.getIncludeVatAmt().intValue()==0) {
					FrontMessageUtils.addMessageError(
							SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.includeVatAmt")));
					flagValid = true;
				}				
	
			}
	
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return flagValid;
	}	
	
	private boolean doAddSite7(){
		boolean flagReturn = false;
		try{
			logger.info("START Action doAddSite7");
			semmel006Bean = getSemmel006Bean();
			String selectNumber = semmel006Bean.getSelectedRadio();
			logger.debug(" selectNumber:"+selectNumber);
			
			
			List<PopupSiteSearch7> siteList = semmel006Bean.getPopupSite7List();
			//LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name);
			//semmel006Bean.setexp
			String electricIdSelected = "";
			String contractNoSelected ="";
			String paymentType ="";
			
			if(selectNumber!=null){
				for(PopupSiteSearch7 tmp:siteList){
					if(selectNumber.equalsIgnoreCase(tmp.getElectricId())){
						electricIdSelected =  tmp.getElectricId();
						contractNoSelected = tmp.getContractNo();
						Payment payment = semmel006Bean.getPayment();
						semmel006Bean.setPopupSiteSearch7(tmp);
						payment.setElectricUseType(semmel006Bean.getPopupSiteSearch7().getElectricUseType());
						payment.setCompany(semmel006Bean.getPopupSiteSearch7().getCompany());
						payment.setContractNo(semmel006Bean.getPopupSiteSearch7().getContractNo());
						
						if(semmel006Bean.getPopupSiteSearch7().getElectricUseType() != null ){
							
							if (semmel006Bean.getPopupSiteSearch7().getElectricUseType().equalsIgnoreCase("MEA")
							   ||semmel006Bean.getPopupSiteSearch7().getElectricUseType().equalsIgnoreCase("PEA")){
								
								payment.setExpenseType("EL_CREDIT");
								payment.setExpenseTypeDisplay(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name), "EL_CREDIT"));	
							}
							else{
								payment.setExpenseType("PR_CREDIT");
								payment.setExpenseTypeDisplay(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name), "PR_CREDIT"));
							}
								
						}
						semmel006Bean.setPayment(payment);
						
						//----------------------------------------------------
						IMeterInfoService meterInfoService = (IMeterInfoService)getBean("meterInfoService");
						MeterInfo meterSearch = new MeterInfo();
						//meterSearch.setOutstandingFlag("Y");
						//meterSearch.setRecordStatus("Y");
						Management electricId = new Management();
						electricId.setRowId(electricIdSelected);
						meterSearch.setElectricId(electricId);
						List <MeterInfo>  resultList = meterInfoService.queryMeterListForUpdateInstalment(meterSearch);
						if(resultList!=null&&resultList.size()>0){
							logger.info(" Found MeterInfo list size :"+resultList.size());		
							MeterInfo meterInfoData = resultList.get(0);
							semmel006Bean.getPopupSiteCriteria().setMeterId(meterInfoData.getRowId());
							semmel006Bean.setMeterIdList(ELUtils.getMeterIdList(resultList));
							semmel006Bean.getPayment().setTotalMeterExpense(resultList.size());
							doChangeMeter();
							
							logger.info(" Check Meter Info Deatail :"+resultList.size());
							
						}else{
							semmel006Bean.setMeterIdList(ELUtils.getEmptyList());
							semmel006Bean.getPayment().setTotalMeterExpense(0);
							logger.info(" Not Found MeterInfo list");
						}			
					}
				}				
			}
			/*
			logger.debug(" Load Meter Id list belong to electricId :"+electricIdSelected);
			IMeterInfoService meterInfoService = (IMeterInfoService)getBean("meterInfoService");
			MeterInfo meterSearch = new MeterInfo();
			meterSearch.setOutstandingFlag("Y");
			meterSearch.setRecordStatus("Y");
			Management electricId = new Management();
			electricId.setRowId(electricIdSelected);
			meterSearch.setElectricId(electricId);
			
			List <MeterInfo>  resultList = meterInfoService.queryMeterListForPayment(meterSearch);
			if(resultList!=null&&resultList.size()>0){
				logger.info(" Found MeterInfo list size :"+resultList.size());		
				MeterInfo meterInfoData = resultList.get(0);
				semmel006Bean.getPopupSiteSearch7().setMeterId(meterInfoData.getRowId());
				semmel006Bean.getPopupSiteCriteria().setMeterId(meterInfoData.getRowId());
				semmel006Bean.setMeterIdList(ELUtils.getMeterIdList(resultList));
				semmel006Bean.getPayment().setTotalMeterExpense(resultList.size());
				doChangeMeter();
				
			}else{
				semmel006Bean.setMeterIdList(ELUtils.getEmptyList());
				semmel006Bean.getPayment().setTotalMeterExpense(0);
				logger.info(" Not Found MeterInfo list");
				
			}			
		    */
			
			logger.info("END Action doAddSite7");
		}catch (Exception e) {
			logger.error("END Action doAddSite7");
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = errorMsg.replace("{0}", "SEMMEL006");
			FrontMessageUtils.addMessageError(errorMsg);
			e.printStackTrace();
		}
		return flagReturn;
	}
	private boolean doInitPopupSearchSite7(){
		boolean flagReturn = false;
		try{
			logger.info("START Action doInitPopupSearchSite7");
			semmel006Bean = getSemmel006Bean();
			semmel006Bean.setPopupSite7List(new ArrayList());
			semmel006Bean.setPopupSiteSearch7(new PopupSiteSearch7());
			
				
		logger.info("END Action doInitPopupSearchSite7");
		}catch (Exception e) {
			logger.error("END Action doInitPopupSearchSite7");
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = errorMsg.replace("{0}", "SEMMEL006");
			FrontMessageUtils.addMessageError(errorMsg);
			e.printStackTrace();
		}
		return flagReturn;
	}
	
	private boolean validatePopupSiteSearch7(){
		logger.debug("START Action validatePopupSiteSearch7");
		boolean flag = false;
		semmel006Bean = getSemmel006Bean();
		PopupSiteSearch7 popupSiteSearch = semmel006Bean.getPopupSiteSearch7();
		
		if (StringUtils.isEmpty(popupSiteSearch.getCompany()) && StringUtils.isEmpty(popupSiteSearch.getCompany())
			&& StringUtils.isEmpty(popupSiteSearch.getContractNo()) && StringUtils.isEmpty(popupSiteSearch.getContractNo())
			&& StringUtils.isEmpty(popupSiteSearch.getSiteName()) && StringUtils.isEmpty(popupSiteSearch.getSiteName())
			&& StringUtils.isEmpty(popupSiteSearch.getRegion()) && StringUtils.isEmpty(popupSiteSearch.getVendorId())
			&& StringUtils.isEmpty(popupSiteSearch.getMeterId()) && StringUtils.isEmpty(popupSiteSearch.getMeterId())) {
			
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("W0004");
			FrontMessageUtils.addMessageError(errorMsg);
			
			flag = true;
		}
		logger.debug("END Action validatePopupSiteSearch7");
		return flag;
		
	}
	
	private boolean doAddOldDoc7(){
		logger.debug("START Action doAddOldDoc7");
		boolean flag = false;
		boolean isSelected = true;
		String docNo = "";
		semmel006Bean = getSemmel006Bean();
		PopupOldDocSearch7 popupOldDocSearch    = new PopupOldDocSearch7();
		List<PaymentDetail> paymentDetailList   = semmel006Bean.getPaymentDetailList();
		List<PaymentDetail> creditPaymentDetail = new ArrayList();
		List<PopupOldDocSearch7> oldDoc7List    = semmel006Bean.getPopupOldDoc7List();
		semmel006Bean.setHidePopup(true);
		
		if(semmel006Bean.getPayment().getRefDocNo() != null 
		   && semmel006Bean.getPayment().getRefDocNo() != "" ){
			docNo = semmel006Bean.getPayment().getRefDocNo();
			logger.debug("REF DocNo =="+docNo);
		}
		
		for(PopupOldDocSearch7 tmp:oldDoc7List){
			if (tmp.isCheckBoxSelected()){
				
				if(docNo.equalsIgnoreCase("")){
				   docNo = tmp.getDocNo();
				   semmel006Bean.getPayment().setRefDocNo(tmp.getDocNo());
				   semmel006Bean.getPayment().setRefDocDt(tmp.getDocDt());
				   semmel006Bean.getPayment().setVendorId(tmp.getVendorId());
				   semmel006Bean.getPayment().setVendorName(tmp.getVendorName());
				   semmel006Bean.getPayment().setPayeeId(tmp.getPayeeId());
				   semmel006Bean.getPayment().setPayeeName(tmp.getPayeeName());
				   
				   logger.debug("Search DocNo =="+docNo);
				}
				isSelected = false;
				
				if(docNo.equalsIgnoreCase(tmp.getDocNo())){
					logger.debug("Add to Model tmp.getDocNo =="+ tmp.getDocNo());
					PaymentDetail paymentDetail = new PaymentDetail();
					if(tmp.getMeterId() != null && tmp.getMeterId().equalsIgnoreCase("") ){
					   paymentDetail.setMeterId(tmp.getMeterId());
					}
					logger.debug("tmp.getRefMeterId() =="+ tmp.getRefMeterId());
					paymentDetail.setReferMeterId(tmp.getRefMeterId());
					paymentDetail.setMeterId(tmp.getMeterId());
					paymentDetail.setTermOfPaymentDt(tmp.getTermOfPaymentDt());
					paymentDetail.setMeterInfoId(tmp.getMeterInfoId());
					paymentDetail.setReferMeterId(tmp.getRefMeterId());
					paymentDetail.setFromTermOfPaymentDt(tmp.getOutFromTermOfPaymentDt());
					paymentDetail.setToTermOfPaymentDt(tmp.getOutToTermOfPaymentDt());
					//paymentDetail.setChqAmt(paymentDetail.getIncludeVatAmt());
					paymentDetail.setDetailFlag("Y");
					
					
					
					creditPaymentDetail.add(paymentDetail);
				}
				else{
					//String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("W0004");
					//String errorMsg = "Doc no not match";
					//FrontMessageUtils.addMessageError(errorMsg);
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.diffDocNo")));
					creditPaymentDetail = new ArrayList();
					semmel006Bean.setHidePopup(false);
					logger.debug("Delete to Model tmp.getDocNo =="+ tmp.getDocNo());
					break;
				}
				
			}
		}
		
		if(isSelected){
			//String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("W0004");
			//String errorMsg = "Not Select";
			//FrontMessageUtils.addMessageError(errorMsg);
			FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.noSelectData")));
			
			semmel006Bean.setHidePopup(false);
			logger.debug("isSelected");
			
		}

		if(creditPaymentDetail.size() >0){
		  
			for(PaymentDetail tmp:creditPaymentDetail){
			
			semmel006Bean.getPaymentDetailList().add(tmp);
			
		  }
		}
		if(semmel006Bean.getPaymentDetailList().size() >0){
			doCalulateCRAmtPage7();
		}
		logger.debug("END Action doAddOldDoc7");
		
		return flag;
		
	}
	
	public void doCalulateCRAmtPage7(){		
		logger.debug("START Action doCalulateCRAmtPage7()");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			Payment payment = semmel006Bean.getPayment();
			List<PaymentDetail> paymentDetailList   = semmel006Bean.getPaymentDetailList();
			//String vatType = payment.getVatType();;	
			int size  = 0;
			
			if(paymentDetailList != null){
				size = semmel006Bean.getPaymentDetailList().size();
			}
			logger.debug("size:   "+size);
			
			BigDecimal totalPayAmt   = payment.getPayAmt()==null? new BigDecimal(0):payment.getPayAmt();
			BigDecimal totalExVatAmt = payment.getExcludeVatAmt()==null? new BigDecimal(0):payment.getExcludeVatAmt();
			BigDecimal totalVatAmt   = payment.getVatAmt()==null? new BigDecimal(0):payment.getVatAmt();
			BigDecimal totalInVatAmt = payment.getIncludeVatAmt()==null? new BigDecimal(0):payment.getIncludeVatAmt();
			
			logger.debug("  totalPayAmt:"+totalPayAmt);
			logger.debug(" totalExVatAmt :"+totalExVatAmt);
			logger.debug(" totalVatAmt :"+totalVatAmt);
			logger.debug(" totalInVatAmt :"+totalInVatAmt);
			
			BigDecimal totalAvgPayAmt = new BigDecimal(0);
			BigDecimal totalAvgExVatAmt =  new BigDecimal(0);
			BigDecimal totalAvgVatAmt = new BigDecimal(0);
			BigDecimal totalAvgInVatAmt = new BigDecimal(0);
			
			if(size > 0){
				totalAvgPayAmt   = totalPayAmt.divide(new BigDecimal(size),BigDecimal.ROUND_HALF_UP);
				totalAvgExVatAmt = totalExVatAmt.divide(new BigDecimal(size),BigDecimal.ROUND_HALF_UP);
				totalAvgVatAmt   = totalVatAmt.divide(new BigDecimal(size),BigDecimal.ROUND_HALF_UP);
				totalAvgInVatAmt = totalInVatAmt.divide(new BigDecimal(size),BigDecimal.ROUND_HALF_UP);
			}
			else{
				payment.setRefDocNo("");
			}
			
			
			logger.debug(" ########################################################## ");
			logger.debug("  totalAvgPayAmt:"+totalAvgPayAmt);
			logger.debug(" totalAvgExVatAmt :"+totalAvgExVatAmt);
			logger.debug(" totalAvgVatAmt :"+totalAvgVatAmt);
			logger.debug(" totalAvgInVatAmt :"+totalAvgInVatAmt);
			
			for(PaymentDetail tmp: paymentDetailList){
				
				tmp.setPayAmt(totalAvgPayAmt);
				tmp.setExcludeVatAmt(totalAvgExVatAmt);
				tmp.setVatAmt(totalAvgVatAmt);
				tmp.setIncludeVatAmt(totalAvgInVatAmt);
				tmp.setChqAmt(totalAvgInVatAmt);
				
			}
			
			logger.info("END Action doCalulateCRAmtPage7()");
		}catch(Exception ex){
			ex.printStackTrace();
			logger.debug("ERROR Action doCRAmtPage7() : "+ex, ex);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMEL006");
			FrontMessageUtils.addMessageError(errorMsg);
		}		
	}
    
	public void doCulateCRVatAmtPage7(){		
		logger.debug("START Action doCulateCRVatAmtPage7");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			Payment payment = semmel006Bean.getPayment();		

			String vatType = payment.getVatType();;	
			logger.debug("vatType"+vatType);
			
			BigDecimal totalPayAmt = new BigDecimal(0);
			BigDecimal totalWhtAmt = new BigDecimal(0);
			BigDecimal totalExVatAmt =  new BigDecimal(0);
			BigDecimal totalVatAmt = new BigDecimal(0);
			BigDecimal totalInVatAmt = new BigDecimal(0);
			BigDecimal totalChqAmt = new BigDecimal(0);
			
			BigDecimal totalSevenVatAmt = new BigDecimal(0);
			BigDecimal totalThreeVatAmt = new BigDecimal(0);
			

			BigDecimal payAmt = payment.getPayAmt()==null? new BigDecimal(0):payment.getPayAmt();
			totalPayAmt = totalPayAmt.add(payAmt);

			
			if("01".equals(vatType)){
				logger.debug(" VAT ");
				totalExVatAmt = ELUtils.getExcludeVatFromTotalPay(totalPayAmt);
				totalVatAmt = ELUtils.getVatAmtFromTotalPay(totalPayAmt);
				totalInVatAmt =totalExVatAmt.add(totalVatAmt);
			
			}else if("02".equalsIgnoreCase(vatType)){
				totalExVatAmt = totalPayAmt;
				totalVatAmt = ELUtils.getSevenVAtAmtFromOriginalPrice(totalPayAmt);
				totalInVatAmt =totalPayAmt.add(totalVatAmt);
			}else if("03".equals(vatType)){
				logger.debug(" No VAT ");
				totalExVatAmt = totalPayAmt;
				totalVatAmt = new BigDecimal(0);
				totalInVatAmt =totalPayAmt;
			}		
			logger.debug("  totalPayAmt:"+totalPayAmt);
			logger.debug(" totalExVatAmt :"+totalExVatAmt);
			logger.debug(" totalVatAmt :"+totalVatAmt);
			logger.debug(" totalInVatAmt :"+totalInVatAmt);
						
			payment.setExcludeVatAmt(totalExVatAmt);	
			payment.setVatAmt(totalVatAmt);
			payment.setIncludeVatAmt(totalInVatAmt);
			payment.setPayAmt(totalPayAmt);
			//semmel006Bean.setPreviosVatAmt(totalVatAmt);
			
			doCalulateCRAmtPage7();
			
			logger.info("END Action doCulateCRVatAmtPage7");
		}catch(Exception ex){
			ex.printStackTrace();
			logger.debug("ERROR Action doRecalCulateCRPayAmtPage7 : "+ex, ex);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMEL006");
			FrontMessageUtils.addMessageError(errorMsg);
		}		
	}
    
	public boolean initDeletePaymentDetailPage7(){
		boolean flag = false;		
		logger.debug("START Action initDeletePaymentDetailPage7");
		try{
			semmel006Bean = getSemmel006Bean();	
			String rowIndex = (String)getFacesUtils().getRequestParameter("rowIndex");
			semmel006Bean.setRemoveItemId(rowIndex);
			logger.debug("End Action initDeletePaymentDetailPage7");
		
		}catch(Exception ex){
			logger.debug("Exception Action initDeletePaymentDetailPage7");
			ex.printStackTrace();
		}

		return flag;
	}
     
	public boolean doDeletePaymentDetailPage7(){
		boolean flag = false;		
		logger.debug("START Action doDeletePaymentDetailPage7");
		try{
			semmel006Bean = getSemmel006Bean();	
			String rowIndex = semmel006Bean.getRemoveItemId();	
			List paymentDetailList = semmel006Bean.getPaymentDetailList();
			paymentDetailList.remove(Integer.parseInt(rowIndex));
			//Payment payment = getInitailPayment();
			//payment.setVatType("01");
			//payment.setPayAmt(new BigDecimal(0));
			//semmel006Bean.setPayment(payment);
			semmel006Bean.getPayment().setRefDocDt(null);
			doCalulateCRAmtPage7();
			logger.debug("End Action doDeletePaymentDetailPage7");
		
		}catch(Exception ex){
			logger.debug("Exception Action doDeletePaymentDetailPage7");
			ex.printStackTrace();
		}

		return flag;
	}
	
	private boolean initialEditPage7() {
		logger.info("START Action initailEditPage7 ");	
		boolean flagValid = false;		
		try{
			init();
			initPayment7();
			semmel006Bean = getSemmel006Bean();
			semmel006Bean.setViewMode(false);
			semmel006Bean.setComeFromPage8(true);
			
			String outstandingFlag = getFacesUtils().getRequestParameter("outstandingFlag") == null ? "" : (String)getFacesUtils().getRequestParameter("outstandingFlag");
			
			if(StringUtils.equals("Y", outstandingFlag)){
				semmel006Bean.setComeFromPage9(true);
				semmel006Bean.setComeFromPage8(false);
			}else{
				semmel006Bean.setComeFromPage9(false);
			}
			//WT###Add 20110216 Start
			
			String isComeFromOtherPage = (String)getFacesUtils().getRequestParameter("isComeFromOtherPage");//Y
			String actionFrom = (String)getFacesUtils().getRequestParameter("actionFrom");
			
			if(null!=isComeFromOtherPage && "Y".equals(isComeFromOtherPage)){
				String navModuleFrom = (String)getFacesUtils().getRequestParameter("navModuleFrom");
				String navProgramFrom = (String)getFacesUtils().getRequestParameter("navProgramFrom");				
				String actionWithNaviFrom = (String)getFacesUtils().getRequestParameter("actionWithNaviFrom");
				String methodWithNaviFrom = (String)getFacesUtils().getRequestParameter("methodWithNaviFrom");
				
				semmel006Bean.setComeFromOtherPage(true);
				semmel006Bean.setNavModuleFrom(navModuleFrom);
				semmel006Bean.setNavProgramFrom(navProgramFrom);
				semmel006Bean.setActionWithNaviFrom(actionWithNaviFrom);
				semmel006Bean.setMethodWithNaviFrom(methodWithNaviFrom);
				
				
			}
			
			String modeView = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("modeView");
			String targetPaymentId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("targetPayment");
			logger.debug("WT### targetPaymentId="+targetPaymentId);
			IPaymentService service = (IPaymentService)getBean("paymentService");	
			Payment returnpayment = service.queryPaymentByRowId(targetPaymentId);				
			//logger.debug(" payment after search:"+BeanUtils.getBeanString(returnpayment));		
			
			Payment payment = returnpayment;
			Set paymetSet = payment.getDetails();
			List detailList = new ArrayList();
			if(paymetSet!=null){
				Object [] detailarray = paymetSet.toArray();
				for(Object tmp:detailarray){
					PaymentDetail tmpdetail = (PaymentDetail)tmp;
					ELUtils.setPamentDetailDisplayField(tmpdetail);
					detailList.add(tmp);
				
				}				
			}			
			ELUtils.setPamentDisplayField(payment);
			semmel006Bean.setPayment(payment);
			semmel006Bean.setPaymentDetailList(detailList);
			
			semmel006Bean.setElectricUseTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name));			
			semmel006Bean.setElExpenseTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name));		
			semmel006Bean.setElDocTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DOC_TYPE.name));
			semmel006Bean.setMeterIdList(ELUtils.getEmptyList());
			semmel006Bean.setCtPaymentTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_TYPE.name));//WT###Add 20110117			
			semmel006Bean.setCtPaymentMethodList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name));//WT###Add 20110117
			semmel006Bean.setMonthList(ELUtils.getMonthDropDownList());//WT###Add 20110117
			semmel006Bean.setYearList(ELUtils.getYearDropDownList());//WT###Add 20110117
			semmel006Bean.setRecordStatusList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_OUTSTANDING_FLAG.name));//WT###Add 20110117	
			//-------------------------------------------------------------------------------
			semmel006Bean.setPopupSite7List(new ArrayList());
			semmel006Bean.setPopupSiteSearch7(new PopupSiteSearch7());
			String electricId = returnpayment.getElectricId().getRowId();
			logger.debug(" initailEditPage7 electricId :"+electricId);
			logger.debug(" initailEditPage7 Payment.Contract No :"+payment.getContractNo());
			logger.debug(" initailEditPage7 Payment.electricId :"+payment.getElectricId().getRowId());
			
			semmel006Bean.getPopupSiteSearch7().setElectricId(electricId);
			
			PopupSiteSearch7 popupSiteSearch7 = new PopupSiteSearch7();
			List<PopupSiteSearch7> popupSiteResultList = new ArrayList();
			popupSiteResultList= service.searchSite7(semmel006Bean.getPopupSiteSearch7(),"querySite7");
			logger.debug(" Result Search :"+popupSiteResultList);					
			if (popupSiteResultList != null && !popupSiteResultList.isEmpty()) {			
				popupSiteSearch7 = popupSiteResultList.get(0);
			}
			semmel006Bean.setPopupSiteSearch7(popupSiteSearch7);
			semmel006Bean.setRenderPage7(false);
			semmel006Bean.setDisablePage7(true);
			if(StringUtils.equalsIgnoreCase("view", modeView)){
				semmel006Bean.setViewMode(true);
			}
			flagValid = true;			
			logger.info("END Action initailEditPage7 ");	
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flagValid;	
	}	
	
	private boolean doUpdate7() {
		logger.debug(" -- doUpdate7--");
		boolean flagValid = false;				
		try {
			
			semmel006Bean = getSemmel006Bean();	
			Payment paymentSave = semmel006Bean.getPayment();
			paymentSave.getDocType();
			logger.debug("paymentSave.getDocType(1):"+paymentSave.getDocType());
			if (validateSave7()) {
				return flagValid;
			}	
			logger.debug("paymentSave.getDocType(2):"+paymentSave.getDocType());
			logger.debug(" Validate PASS .... next step ");
			
			
			 
			String electricIdStr = semmel006Bean.getPopupSiteSearch7().getElectricId();
			//String meterInfoId = semmel006Bean.getPopupSiteSearch7().getMeterId();
			//Payment paymentSave = semmel006Bean.getPayment();
			Management electricId = new Management();
			electricId.setRowId(electricIdStr);
			logger.debug("electricIdStr .... next step "+ electricIdStr);
			logger.debug("electricId.getRowId().... Before Save"+ electricId.getRowId());
			
			
			//logger.debug(" <<<<<< Elec ID >>>>>....  " + electricId.getelect );
			paymentSave.setElectricId(electricId);
			//paymentSave.setSiteInfoId(semmel006Bean.getPopupSiteCriteria().getSiteInfoId());
			//paymentSave.setSiteType(semmel006Bean.getPopupSiteCriteria().getSiteType());
			paymentSave.setRegion(semmel006Bean.getPopupSiteSearch7().getRegion());
			//paymentSave.setExpenseType(ELUtils.EL_POSTPAID);			
			paymentSave.setRecordStatus("Y");
			paymentSave.setVersion(new BigDecimal(1));
			
			if(paymentSave.getWhtAmt() != null){
				if(paymentSave.getWhtAmt().doubleValue()==0.0){
				paymentSave.setWhtAmt(null);
				}
			}
			
			//paymentSave.setPaymentStatus("99");
			paymentSave.setVatType(semmel006Bean.getPayment().getVatType());
			paymentSave.setVatRate(new BigDecimal(7));
			
			
			List<PaymentDetail> detailList = semmel006Bean.getPaymentDetailList();
			for(PaymentDetail detailtmp:detailList){
				detailtmp.setVatRate(new BigDecimal(7));
				//detailtmp.setExpenseType(paymentSave.getExpenseType());
				detailtmp.setVatType(paymentSave.getVatType());
				detailtmp.setCreateBy(paymentSave.getCreateBy());
				detailtmp.setCreateDt(paymentSave.getCreateDt());
				detailtmp.setRecordStatus("Y");
			}				
			logger.debug(" Detail List :"+detailList.size());			
			    
			IPaymentService service = (IPaymentService)getBean("paymentService");	
			ParameterConfig paramPLName = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_PAYMENT_E005");
			logger.debug("   paramPLName:"+paramPLName);
			boolean saveResult = service.updatePaymentPage7(paymentSave, detailList,  paramPLName.getParamValue());
			logger.debug(" updatePaymentPage7 Result xx :"+saveResult);
			//initPayment7();
			logger.info("END <<<<Service doUpdate7>>>");
			addMessageInfo("M0001");
			
		
	} catch (Exception e) {
		addMessageError(ELUtils.E0001);
		e.printStackTrace();
	}
	return flagValid;
			
	
	}

	// ######################### End Button 7 ######################
	//END Page 7
	
//--------------------------------------------------------------------------------------------	
	public void doRecalCulateVATELCRAmt(){		
		logger.debug("START Action doRecalCulateVATELCRAmt");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			Payment payment = semmel006Bean.getPayment();		

			String vatType = payment.getVatType();;	
			logger.debug("vatType"+vatType);
			
			
			BigDecimal totalPayAmt = new BigDecimal(0);
			BigDecimal totalWhtAmt = new BigDecimal(0);
			BigDecimal totalExVatAmt =  new BigDecimal(0);
			BigDecimal totalVatAmt = new BigDecimal(0);
			BigDecimal totalInVatAmt = new BigDecimal(0);
			BigDecimal totalChqAmt = new BigDecimal(0);
			
			BigDecimal totalSevenVatAmt = new BigDecimal(0);
			BigDecimal totalThreeVatAmt = new BigDecimal(0);
			
			//BigDecimal includeVatAmtCR = new BigDecimal(0);

			BigDecimal payAmt = payment.getPayAmt()==null? new BigDecimal(0):payment.getPayAmt();
			BigDecimal amtCR = payment.getIncludeVatAmtCR()==null? new BigDecimal(0):payment.getIncludeVatAmtCR();
			BigDecimal elBillAmt = payment.getElBillPayAmt()==null? new BigDecimal(0):payment.getElBillPayAmt();
			payAmt    = elBillAmt.subtract(amtCR);
			totalPayAmt = totalPayAmt.add(payAmt);

			
			if("01".equals(vatType)){
				logger.debug(" VAT ");
				totalExVatAmt = ELUtils.getExcludeVatFromTotalPay(totalPayAmt);
				totalVatAmt = ELUtils.getVatAmtFromTotalPay(totalPayAmt);
				totalInVatAmt =totalExVatAmt.add(totalVatAmt);
			
			}else if("02".equalsIgnoreCase(vatType)){
				totalExVatAmt = totalPayAmt;
				totalVatAmt = ELUtils.getSevenVAtAmtFromOriginalPrice(totalPayAmt);
				totalInVatAmt =totalPayAmt.add(totalVatAmt);
			}else if("03".equals(vatType)){
				logger.debug(" No VAT ");
				totalExVatAmt = totalPayAmt;
				totalVatAmt = new BigDecimal(0);
				totalInVatAmt =totalPayAmt;
			}		
			logger.debug("  totalPayAmt:"+totalPayAmt);
			logger.debug(" totalExVatAmt :"+totalExVatAmt);
			logger.debug(" totalVatAmt :"+totalVatAmt);
			logger.debug(" totalInVatAmt :"+totalInVatAmt);
						
			payment.setInvTotalExcludeVat(totalExVatAmt);	
			payment.setInvTotalVat(totalVatAmt);
			payment.setInvTotalIncludeVat(totalInVatAmt);
			payment.setPayAmt(totalPayAmt);
			semmel006Bean.setPreviosVatAmt(totalVatAmt);
			recalculateAdNewExpenseSite();
			
			logger.info("END Action doRecalCulateVATELCRAmt");
		}catch(Exception ex){
			ex.printStackTrace();
			logger.debug("ERROR Action doRecalCulateVATELCRAmt : "+ex, ex);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMEL006");
			FrontMessageUtils.addMessageError(errorMsg);
		}		
	}
	
	public void doCheckTermOfPaymentDateTime(){		
		logger.debug("START Action doCheckTermOfPaymentDateTime");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			PaymentDetail paymentDetail = semmel006Bean.getPaymentDetail();		
            String fromTermOfPaymentMonth = "";
            String fromTermOfPaymentYear = "";
            String toTermOfPaymentMonth = "";
            String toTermOfPaymentYear = "";
            
            if(semmel006Bean.getPaymentDetail().getFromTermOfPaymentMonth()!= null){
            	fromTermOfPaymentMonth = semmel006Bean.getPaymentDetail().getFromTermOfPaymentMonth();
    		}
            if(semmel006Bean.getPaymentDetail().getFromTermOfPaymentYear()!= null){
            	fromTermOfPaymentYear = semmel006Bean.getPaymentDetail().getFromTermOfPaymentYear();
    		}
            if(semmel006Bean.getPaymentDetail().getToTermOfPaymentMonth()!= null){
            	toTermOfPaymentMonth = semmel006Bean.getPaymentDetail().getToTermOfPaymentMonth();
    		}
            if(semmel006Bean.getPaymentDetail().getToTermOfPaymentYear()!= null){
            	toTermOfPaymentYear = semmel006Bean.getPaymentDetail().getToTermOfPaymentYear();
    		}
            //logger.info("fromTermOfPaymentMonth:"+fromTermOfPaymentMonth);
            //logger.info("fromTermOfPaymentYear:"+fromTermOfPaymentYear);
            //logger.info("toTermOfPaymentMonth:"+toTermOfPaymentMonth);
            //logger.info("toTermOfPaymentYear:"+toTermOfPaymentYear);
            
            if(!fromTermOfPaymentMonth.equalsIgnoreCase("") && !fromTermOfPaymentYear.equalsIgnoreCase("")){
            	semmel006Bean.getPaymentDetail().setFromTermOfPaymentDt(ELUtils.getDateByMonthandYear(fromTermOfPaymentMonth, fromTermOfPaymentYear));
            	 //logger.info("Set From Date:"+ semmel006Bean.getPaymentDetail().getFromTermOfPaymentDt());
            	
            	 if(toTermOfPaymentMonth.equalsIgnoreCase("") && toTermOfPaymentYear.equalsIgnoreCase("")){
            		toTermOfPaymentMonth = fromTermOfPaymentMonth;
            		toTermOfPaymentYear  = fromTermOfPaymentYear;
            		paymentDetail.setToTermOfPaymentMonth(toTermOfPaymentMonth);
            		paymentDetail.setToTermOfPaymentYear(toTermOfPaymentYear);
            	}
               

            }
            
            if(!toTermOfPaymentMonth.equalsIgnoreCase("") && !toTermOfPaymentYear.equalsIgnoreCase("")){
            		semmel006Bean.getPaymentDetail().setToTermOfPaymentDt(ELUtils.getEndDateByMonthandYear(toTermOfPaymentMonth, toTermOfPaymentYear));
            		//logger.info("Set To Date:"+ semmel006Bean.getPaymentDetail().getToTermOfPaymentDt());
            }
            //Start add By Noom
            if(semmel006Bean.getPaymentDetail()!=null && semmel006Bean.getPaymentDetail().getFromTermOfPaymentDt()!=null){
                SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
                String date = dtf.format(semmel006Bean.getPaymentDetail().getFromTermOfPaymentDt());
                semmel006Bean.getPaymentDetail().setTermOfPaymentDateFrom(date);
            } //End add By Noom
            
            List <Date> fromTermOfPayment = new ArrayList();
            fromTermOfPayment = doGetNumberTermOfPayment(semmel006Bean.getPaymentDetail());
            
            if(fromTermOfPayment.size()>1){
            	semmel006Bean.setDisableValidateELPostPaidPaymentDetail(true);
				semmel006Bean.getPaymentDetail().setValidatePaymentDetailFlagBoolean(false);
				
			}
			else if (fromTermOfPayment.size()== 1){
				semmel006Bean.setDisableValidateELPostPaidPaymentDetail(false);
				//semmel006Bean.getPaymentDetail().setValidatePaymentDetailFlagBoolean(true);
			}
            
            
			logger.info("END Action doCheckTermOfPaymentDateTime");
		}catch(Exception ex){
			ex.printStackTrace();
			logger.debug("ERROR Action doCheckTermOfPaymentDateTime : "+ex, ex);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMEL006");
			FrontMessageUtils.addMessageError(errorMsg);
		}		
	}

	public List<Date> doGetNumberTermOfPayment(PaymentDetail paymentDetail){		
		logger.debug("START Action doGetNumberTermOfPayment");
		int numberOfTermofPayment = 0;		
        int fromTermOfPaymentMonth = 0;
        int fromTermOfPaymentYear = 0;
        int fromTermOfPaymentDt = 0;
        int toTermOfPaymentMonth = 0;
        int toTermOfPaymentYear = 0;
        int toTermOfPaymentDt = 0;
        
        String fromTermOfPaymentMonthDetail = "";
        String fromTermOfPaymentYearDetail = "";
        List <Date> fromTermOfPayment = new ArrayList();
        
		try{
			
			
            
            if(semmel006Bean.getPaymentDetail().getFromTermOfPaymentMonth()!= null 
               && !semmel006Bean.getPaymentDetail().getFromTermOfPaymentMonth().equalsIgnoreCase("") ) {
            	fromTermOfPaymentMonth = Integer.parseInt(paymentDetail.getFromTermOfPaymentMonth());
            	fromTermOfPaymentMonthDetail = paymentDetail.getFromTermOfPaymentMonth();
    		}
            if(semmel006Bean.getPaymentDetail().getFromTermOfPaymentYear()!= null 
            	&& !semmel006Bean.getPaymentDetail().getFromTermOfPaymentYear().equalsIgnoreCase("") ) {
            	fromTermOfPaymentYear = Integer.parseInt(paymentDetail.getFromTermOfPaymentYear());
            	fromTermOfPaymentYearDetail = paymentDetail.getFromTermOfPaymentYear();
    		}
            if(semmel006Bean.getPaymentDetail().getToTermOfPaymentMonth()!= null
            		&& !semmel006Bean.getPaymentDetail().getToTermOfPaymentMonth().equalsIgnoreCase("") ){
            	toTermOfPaymentMonth = Integer.parseInt(paymentDetail.getToTermOfPaymentMonth());
    		}
            if(semmel006Bean.getPaymentDetail().getToTermOfPaymentYear()!= null
            		&& !semmel006Bean.getPaymentDetail().getToTermOfPaymentYear().equalsIgnoreCase("")){
            	toTermOfPaymentYear =Integer.parseInt(paymentDetail.getToTermOfPaymentYear());
    		}
            //logger.info("<<<<<<<fromTermOfPaymentMonth:>>>>>>>>>>"+fromTermOfPaymentMonth);
            //logger.info("<<<<<<<fromTermOfPaymentYear:"+fromTermOfPaymentYear);
            //logger.info("<<<<<<<toTermOfPaymentMonth:"+toTermOfPaymentMonth);
            //logger.info("<<<<<<<toTermOfPaymentYear:"+toTermOfPaymentYear);
            
            if(fromTermOfPaymentMonth > 0 && fromTermOfPaymentYear > 0  && toTermOfPaymentMonth > 0 && toTermOfPaymentYear > 0 ){
            	
            	numberOfTermofPayment = (toTermOfPaymentMonth - fromTermOfPaymentMonth)
		                                 +((toTermOfPaymentYear-fromTermOfPaymentYear)*12)+1;
            	fromTermOfPaymentDt   =  paymentDetail.getFromTermOfPaymentDt().getDate();
            	toTermOfPaymentDt     =  paymentDetail.getToTermOfPaymentDt().getDate();
            }
            logger.info("numberOfTermofPayment:"+numberOfTermofPayment);
            
            if(numberOfTermofPayment >0){
            	for(int i=0;i<numberOfTermofPayment;i++){
            		
            		if(i > 0){
            			fromTermOfPaymentMonth++;
            			if(fromTermOfPaymentMonth == 13){
                			fromTermOfPaymentMonth =1;
                			fromTermOfPaymentYear  = fromTermOfPaymentYear+1;
                		}
            		}
            		
            		
            	    logger.info("XXXXXXXXXX fromTermOfPaymentMonth:  "+fromTermOfPaymentMonth);
            		logger.info("XXXXXXXXXX fromTermOfPaymentYear:  " +fromTermOfPaymentYear);
            		logger.info("YYYY  Date From:  "     +fromTermOfPaymentDt);
            		logger.info("YYYYY Date To  :  "     +toTermOfPaymentDt);
            		
            		 Date termOfPaymentDT= new Date();	
            		 
            		 if(i==0 ){
            			 termOfPaymentDT = ELUtils.getDateByDateMonthandYear(Integer.toString(fromTermOfPaymentDt),Integer.toString(fromTermOfPaymentMonth) ,
            		 												 Integer.toString(fromTermOfPaymentYear));
            			 logger.info("i==0 : "     +termOfPaymentDT);
            		 }else if(i==(numberOfTermofPayment-1)){
            			 termOfPaymentDT = ELUtils.getDateByDateMonthandYear(Integer.toString(toTermOfPaymentDt),Integer.toString(fromTermOfPaymentMonth) ,
									                                         Integer.toString(fromTermOfPaymentYear));
            			 logger.info("i==numberOfTermofPayment: "     +termOfPaymentDT);
            		}else {
            				termOfPaymentDT = ELUtils.getDateByMonthandYear(Integer.toString(fromTermOfPaymentMonth) ,
							Integer.toString(fromTermOfPaymentYear));
            				logger.info("else: "     +termOfPaymentDT);
       		 }
                	fromTermOfPayment.add(termOfPaymentDT);
            	}
            	
            }
            doDefaultMeterDataForPaymentDetail();
            logger.info("END Action doGetNumberTermOfPayment");	
           
			
		}catch(Exception ex){
			ex.printStackTrace();
			logger.debug("ERROR Action doGetNumberTermOfPayment : "+ex, ex);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMEL006");
			FrontMessageUtils.addMessageError(errorMsg);
		}
		return fromTermOfPayment;
	}
	
	public List<Date> doGetNumberTermOfPaymentForValidation(PaymentDetail paymentDetail){		
		logger.debug("START Action doGetNumberTermOfPaymentForValidation");
		int numberOfTermofPayment = 0;		
        int fromTermOfPaymentMonth = 0;
        int fromTermOfPaymentYear = 0;
        int fromTermOfPaymentDt = 0;
        int toTermOfPaymentMonth = 0;
        int toTermOfPaymentYear = 0;
        int toTermOfPaymentDt = 0;
        
        String fromTermOfPaymentMonthDetail = "";
        String fromTermOfPaymentYearDetail = "";
        List <Date> fromTermOfPayment = new ArrayList();
        
		try{
			
			
            
            if(semmel006Bean.getPaymentDetail().getFromTermOfPaymentMonth()!= null 
               && !semmel006Bean.getPaymentDetail().getFromTermOfPaymentMonth().equalsIgnoreCase("") ) {
            	fromTermOfPaymentMonth = Integer.parseInt(paymentDetail.getFromTermOfPaymentMonth());
            	fromTermOfPaymentMonthDetail = paymentDetail.getFromTermOfPaymentMonth();
    		}
            if(semmel006Bean.getPaymentDetail().getFromTermOfPaymentYear()!= null 
            	&& !semmel006Bean.getPaymentDetail().getFromTermOfPaymentYear().equalsIgnoreCase("") ) {
            	fromTermOfPaymentYear = Integer.parseInt(paymentDetail.getFromTermOfPaymentYear());
            	fromTermOfPaymentYearDetail = paymentDetail.getFromTermOfPaymentYear();
    		}
            if(semmel006Bean.getPaymentDetail().getToTermOfPaymentMonth()!= null
            		&& !semmel006Bean.getPaymentDetail().getToTermOfPaymentMonth().equalsIgnoreCase("") ){
            	toTermOfPaymentMonth = Integer.parseInt(paymentDetail.getToTermOfPaymentMonth());
    		}
            if(semmel006Bean.getPaymentDetail().getToTermOfPaymentYear()!= null
            		&& !semmel006Bean.getPaymentDetail().getToTermOfPaymentYear().equalsIgnoreCase("")){
            	toTermOfPaymentYear =Integer.parseInt(paymentDetail.getToTermOfPaymentYear());
    		}
            //logger.info("<<<<<<<fromTermOfPaymentMonth:>>>>>>>>>>"+fromTermOfPaymentMonth);
            //logger.info("<<<<<<<fromTermOfPaymentYear:"+fromTermOfPaymentYear);
            //logger.info("<<<<<<<toTermOfPaymentMonth:"+toTermOfPaymentMonth);
            //logger.info("<<<<<<<toTermOfPaymentYear:"+toTermOfPaymentYear);
            
            if(fromTermOfPaymentMonth > 0 && fromTermOfPaymentYear > 0  && toTermOfPaymentMonth > 0 && toTermOfPaymentYear > 0 ){
            	
            	numberOfTermofPayment = (toTermOfPaymentMonth - fromTermOfPaymentMonth)
		                                 +((toTermOfPaymentYear-fromTermOfPaymentYear)*12)+1;
            	fromTermOfPaymentDt   =  paymentDetail.getFromTermOfPaymentDt().getDate();
            	toTermOfPaymentDt     =  paymentDetail.getToTermOfPaymentDt().getDate();
            }
            logger.info("numberOfTermofPayment:"+numberOfTermofPayment);
            
            if(numberOfTermofPayment >0){
            	for(int i=0;i<numberOfTermofPayment;i++){
            		
            		if(i > 0){
            			fromTermOfPaymentMonth++;
            			if(fromTermOfPaymentMonth == 13){
                			fromTermOfPaymentMonth =1;
                			fromTermOfPaymentYear  = fromTermOfPaymentYear+1;
                		}
            		}
            		
            		
            	    logger.info("XXXXXXXXXX fromTermOfPaymentMonth:  "+fromTermOfPaymentMonth);
            		logger.info("XXXXXXXXXX fromTermOfPaymentYear:  " +fromTermOfPaymentYear);
            		logger.info("YYYY  Date From:  "     +fromTermOfPaymentDt);
            		logger.info("YYYYY Date To  :  "     +toTermOfPaymentDt);
            		
            		 Date termOfPaymentDT= new Date();	
            		 
            		 if(i==0 ){
            			 termOfPaymentDT = ELUtils.getDateByDateMonthandYear(Integer.toString(fromTermOfPaymentDt),Integer.toString(fromTermOfPaymentMonth) ,
            		 												 Integer.toString(fromTermOfPaymentYear));
            			 logger.info("i==0 : "     +termOfPaymentDT);
            		 }else if(i==(numberOfTermofPayment-1)){
            			 termOfPaymentDT = ELUtils.getDateByDateMonthandYear(Integer.toString(toTermOfPaymentDt),Integer.toString(fromTermOfPaymentMonth) ,
									                                         Integer.toString(fromTermOfPaymentYear));
            			 logger.info("i==numberOfTermofPayment: "     +termOfPaymentDT);
            		}else {
            				termOfPaymentDT = ELUtils.getDateByMonthandYear(Integer.toString(fromTermOfPaymentMonth) ,
							Integer.toString(fromTermOfPaymentYear));
            				logger.info("else: "     +termOfPaymentDT);
       		 }
                	fromTermOfPayment.add(termOfPaymentDT);
            	}
            	
            }
          
            logger.info("END Action doGetNumberTermOfPaymentForValidation");	
           
			
		}catch(Exception ex){
			ex.printStackTrace();
			logger.debug("ERROR Action doGetNumberTermOfPayment : "+ex, ex);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMEL006");
			FrontMessageUtils.addMessageError(errorMsg);
		}
		return fromTermOfPayment;
	}
	
	
	public void doChangeTermOfPaymentDate(){		
		logger.debug("START Action doChangeTermOfPaymentDate");
		boolean flagValid = false;		
		try{
			
			semmel006Bean = getSemmel006Bean();	 
			PaymentDetail paymentDetail = semmel006Bean.getPaymentDetail();		
            String fromTermOfPaymentMonth = "";
            String fromTermOfPaymentYear = "";
            String toTermOfPaymentMonth = "";
            String toTermOfPaymentYear = "";
            
            
            if(semmel006Bean.getPaymentDetail().getFromTermOfPaymentDt()!= null){
            	fromTermOfPaymentMonth = ELUtils.getMonthNumberByDate(semmel006Bean.getPaymentDetail().getFromTermOfPaymentDt());
                fromTermOfPaymentYear = ELUtils.getYearNumberByDateTH(semmel006Bean.getPaymentDetail().getFromTermOfPaymentDt());
                semmel006Bean.getPaymentDetail().setFromTermOfPaymentMonth(fromTermOfPaymentMonth);
                semmel006Bean.getPaymentDetail().setFromTermOfPaymentYear(fromTermOfPaymentYear);
                
                SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
                String date = dtf.format(semmel006Bean.getPaymentDetail().getFromTermOfPaymentDt());
                semmel006Bean.getPaymentDetail().setTermOfPaymentDateFrom(date);
    		}
            
            if(semmel006Bean.getPaymentDetail().getToTermOfPaymentDt()!= null){
            	toTermOfPaymentMonth = ELUtils.getMonthNumberByDate(semmel006Bean.getPaymentDetail().getToTermOfPaymentDt());
                toTermOfPaymentYear = ELUtils.getYearNumberByDateTH(semmel006Bean.getPaymentDetail().getToTermOfPaymentDt());
                semmel006Bean.getPaymentDetail().setToTermOfPaymentMonth(toTermOfPaymentMonth);
                semmel006Bean.getPaymentDetail().setToTermOfPaymentYear(toTermOfPaymentYear);
                
                 
    		}
            else{
            	semmel006Bean.getPaymentDetail().setToTermOfPaymentMonth(fromTermOfPaymentMonth);
                semmel006Bean.getPaymentDetail().setToTermOfPaymentYear(fromTermOfPaymentYear);
                if(semmel006Bean.getPaymentDetail().getFromTermOfPaymentDt()!= null){
                	 semmel006Bean.getPaymentDetail().setToTermOfPaymentDt(semmel006Bean.getPaymentDetail().getFromTermOfPaymentDt());	
                }
               
            }
            
            logger.info("<<<<<<<fromTermOfPaymentMonth:>>>>>>>>>>"+fromTermOfPaymentMonth);
            logger.info("fromTermOfPaymentYear:"+fromTermOfPaymentYear);
            logger.info("toTermOfPaymentMonth:"+toTermOfPaymentMonth);
            logger.info("toTermOfPaymentYear:"+toTermOfPaymentYear);
            List <Date> fromTermOfPayment = new ArrayList();
            fromTermOfPayment = doGetNumberTermOfPayment(semmel006Bean.getPaymentDetail());
            
            if(fromTermOfPayment.size()>1){
            	semmel006Bean.setDisableValidateELPostPaidPaymentDetail(true);
				semmel006Bean.getPaymentDetail().setValidatePaymentDetailFlagBoolean(false);
				
			}
			else{
				semmel006Bean.setDisableValidateELPostPaidPaymentDetail(false);
				semmel006Bean.getPaymentDetail().setValidatePaymentDetailFlagBoolean(true);
			}
            doDefaultMeterDataForPaymentDetail();
            logger.info("END Action doChangeTermOfPaymentDate");
		}catch(Exception ex){
			ex.printStackTrace();
			logger.debug("ERROR Action doChangeTermOfPaymentDate : "+ex, ex);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMEL006");
			FrontMessageUtils.addMessageError(errorMsg);
		}		
	}
	
	public void doCalculateKwhTotal(){		
		logger.debug("START Action doCalculateKwhTotal");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			PaymentDetail paymentDetail = semmel006Bean.getPaymentDetail();		
            BigDecimal pRead    = new BigDecimal(0);
            BigDecimal lRead    = new BigDecimal(0);
            BigDecimal kwhTotal = new BigDecimal(0);
            DecimalFormat decimalFormat = new DecimalFormat();
           
            if(paymentDetail.getpReadStr()!=null && !paymentDetail.getpReadStr().equals("")){
            	pRead.add(new BigDecimal(paymentDetail.getpReadStr()));
            }
            
            if(paymentDetail.getlReadStr()!=null && !paymentDetail.getlReadStr().equals("")){
            	lRead.add(new BigDecimal(paymentDetail.getlReadStr()));
            }
            
            if(paymentDetail.getKwhTotalStr() != null && !paymentDetail.getKwhTotalStr().equals("")){
            	kwhTotal.add(new BigDecimal(paymentDetail.getKwhTotalStr()));
            }
            
            
            if(paymentDetail.getKwhTotal()==null){
            	 kwhTotal = new BigDecimal(0);
            }
            else{
            	 kwhTotal = paymentDetail.getKwhTotal();
            }
           
            if(semmel006Bean.getPaymentDetail().getpRead()!= null 
              && semmel006Bean.getPaymentDetail().getlRead() != null){
            	pRead = semmel006Bean.getPaymentDetail().getpRead();
            	lRead = semmel006Bean.getPaymentDetail().getlRead();
            	
            	if(lRead.compareTo(pRead)>0){
            	   kwhTotal = lRead.subtract(pRead);
            	   semmel006Bean.getPaymentDetail().setKwhTotal(kwhTotal);
            	}else{
            		
            		semmel006Bean.getPaymentDetail().setKwhTotal(kwhTotal);
            	}
            	
            }
            else{
            	 if(semmel006Bean.getPaymentDetail().getKwhTotal() != null 
            		&& semmel006Bean.getPaymentDetail().getKwhTotal().equals(new BigDecimal(0))){
            		 if(semmel006Bean.getPaymentDetail().getpRead()!= null && semmel006Bean.getPaymentDetail().getpRead() == null){
            			 lRead = semmel006Bean.getPaymentDetail().getKwhTotal().subtract(semmel006Bean.getPaymentDetail().getpRead());
            			 semmel006Bean.getPaymentDetail().setlRead(lRead);
            		 }else if(semmel006Bean.getPaymentDetail().getpRead()== null && semmel006Bean.getPaymentDetail().getpRead() != null){
            			 pRead = semmel006Bean.getPaymentDetail().getKwhTotal().subtract(semmel006Bean.getPaymentDetail().getlRead());
            			 semmel006Bean.getPaymentDetail().setpRead(pRead);
            			 
            		 }
            		 
            	 }
            }
            
            BigDecimal payAmt = new BigDecimal(0);
            if(semmel006Bean.getPaymentDetail().getKwhTotal() != null && semmel006Bean.getPaymentDetail().getUnitPrice() != null)
            	payAmt = calPayAmt65(semmel006Bean.getPaymentDetail().getKwhTotal(), semmel006Bean.getPaymentDetail().getUnitPrice());
            semmel006Bean.getPaymentDetail().setPayAmt(payAmt);
            
            logger.info("pRead:"+pRead);
            logger.info("lRead:"+lRead);
            logger.info("kwhTotal:"+kwhTotal);
            logger.info("payAmt:"+payAmt);
            setSemmel006Bean(semmel006Bean);
            logger.info("END Action doCalculateKwhTotal");
		}catch(Exception ex){
			ex.printStackTrace();
			logger.debug("ERROR Action doCalculateKwhTotal : "+ex, ex);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMEL006");
			FrontMessageUtils.addMessageError(errorMsg);
		}		
	}
    
	private BigDecimal calPayAmt65(BigDecimal kwhTotal, BigDecimal unitPrice){
		
		return kwhTotal.multiply(unitPrice);
	}
	
	public boolean doChangeValidateELPostPaid(){		
		logger.info(" ## Start  doChangeValidateELPostPaid ##  ");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			logger.info(" Data:"+semmel006Bean.getPaymentDetail().getValidatePaymentDetailFlag());
			logger.info(" Data Boolean:"+semmel006Bean.getPaymentDetail().isValidatePaymentDetailFlagBoolean());
			
			
			
			logger.info(" ## END  doChangeValidateELPostPaid ## ");
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return flagValid;			
	}	
	
	public boolean doChangehqPostDate(){		
		logger.info(" ## Start  doChangehqPostDate ##  ");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();
			
			if(semmel006Bean.getPayment().getChqPostingDt()!= null){
				semmel006Bean.getPayment().setChqReceivedDt(semmel006Bean.getPayment().getChqPostingDt());
			}
			
			logger.info(" ## END  doChangehqPostDate ## ");
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return flagValid;			
	}
	public void doDefaultMeterDataForPaymentDetail(){		
		logger.debug("START Action doDefaultMeterDataForPaymentDetail");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			PaymentDetail paymentDetail = semmel006Bean.getPaymentDetail();	
			semmel006Bean.setInstallmentDataDetail(new InstallmentDataDetail() );
			
			String meterInfoId = null;
			
			if(semmel006Bean.getPopupSiteCriteria().getElectricUseType() != null){
				if(semmel006Bean.getPopupSiteCriteria().getElectricUseType().equalsIgnoreCase(ELUtils.ELECTRIC_TYPE_MEA) 
				  || semmel006Bean.getPopupSiteCriteria().getElectricUseType().equalsIgnoreCase(ELUtils.ELECTRIC_TYPE_PEA)){
					meterInfoId = semmel006Bean.getPopupSiteCriteria().getMeterInfoId();
					
				}else if (semmel006Bean.getPopupSiteCriteria().getElectricUseType().equalsIgnoreCase(ELUtils.ELECTRIC_TYPE_PRIVATE)){
					meterInfoId = semmel006Bean.getMeterInfo().getRowId();
				}
			}
			logger.debug("meterInfoId: "+ meterInfoId);
			
			if(semmel006Bean.getPaymentDetail().getFromTermOfPaymentDt() != null 
			   && meterInfoId != null && !meterInfoId.isEmpty()  && !meterInfoId.equalsIgnoreCase("") ){
            	
            	semmel006Bean.getInstallmentDataDetail().setTermOfPaymentDt(semmel006Bean.getPaymentDetail().getFromTermOfPaymentDt());
            	semmel006Bean.getInstallmentDataDetail().setMeterInfoId(meterInfoId);
            	IPaymentService service = (IPaymentService)getBean("paymentService");	
            	List<InstallmentDataDetail> installmentDataDetailList = new ArrayList();
            	InstallmentDataDetail installmentDataDetail =new InstallmentDataDetail();
            	installmentDataDetailList= service.searchInstallmentDataDetail(semmel006Bean.getInstallmentDataDetail());
    			
            	logger.debug(" Result Search :"+installmentDataDetailList.size());					
    			
    			if (installmentDataDetailList != null && !installmentDataDetailList.isEmpty()) {			
    				installmentDataDetail = installmentDataDetailList.get(0);
    				logger.debug(" installmentDataDetail Data Found :"+installmentDataDetail.getlDate());
    				if(semmel006Bean.getPopupSiteCriteria().getElectricUseType().equalsIgnoreCase(ELUtils.ELECTRIC_TYPE_MEA) 
    						  || semmel006Bean.getPopupSiteCriteria().getElectricUseType().equalsIgnoreCase(ELUtils.ELECTRIC_TYPE_PEA)){
    					semmel006Bean.getPaymentDetail().setpDate(installmentDataDetail.getlDate());
        				semmel006Bean.getPaymentDetail().setpRead(installmentDataDetail.getLread());
        				//semmel006Bean.getPaymentDetail().setVatType(installmentDataDetail.getUnitVatType());
        				
        				
    					
    				}else if (semmel006Bean.getPopupSiteCriteria().getElectricUseType().equalsIgnoreCase(ELUtils.ELECTRIC_TYPE_PRIVATE)){
    					semmel006Bean.getPaymentDetail().setpRead(installmentDataDetail.getLread());
    					semmel006Bean.getPaymentDetail().setUnitPrice(installmentDataDetail.getUnitPrice());
        				semmel006Bean.getPaymentDetail().setUnitVatType(installmentDataDetail.getUnitVatType());
        				semmel006Bean.getPaymentDetail().setVatType(installmentDataDetail.getUnitVatType());
    				}
    				
    			}
    			
            }
			else{
				logger.debug("Data Not Complete :");
			}
			
			logger.info("END Action doDefaultMeterDataForPaymentDetail");
		}catch(Exception ex){
			ex.printStackTrace();
			logger.debug("ERROR Action doDefaultMeterDataForPaymentDetail : "+ex, ex);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMEL006");
			FrontMessageUtils.addMessageError(errorMsg);
		}		
	}
	
	private boolean initEditPayment7(){
		boolean flagReturn = false;
		try{
			logger.info("START initEditPayment7");
			semmel006Bean = getSemmel006Bean();					
			init();
			initPayment7();			
			String electricId = (String)getFacesUtils().getRequestParameter("electricId");
			String company = (String)getFacesUtils().getRequestParameter("company");
			logger.debug("WT###electricId="+electricId);
			logger.debug("WT###company="+company);
			semmel006Bean.getPopupSiteSearch7().setElectricId(electricId);
			semmel006Bean.getPopupSiteSearch7().setCompany(company);
			doSearchPopupSite7();
			semmel006Bean.setSelectedRadio(electricId);
			doAddSite7();
			String isFromAction = (String)getFacesUtils().getRequestParameter("isFromAction");
			String navModuleFrom = (String)getFacesUtils().getRequestParameter("navModuleFrom");
			String navProgramFrom = (String)getFacesUtils().getRequestParameter("navProgramFrom");
			String actionWithNaviFrom = (String)getFacesUtils().getRequestParameter("actionWithNaviFrom");
			
			logger.debug("WT###isFromAction="+isFromAction);
			logger.debug("WT###navModuleFrom="+navModuleFrom);
			logger.debug("WT###navProgramFrom="+navProgramFrom);
			logger.debug("WT###actionWithNaviFrom="+actionWithNaviFrom);
			if("Y".equals(isFromAction)){
				semmel006Bean.setFromAction(true);
				semmel006Bean.setNavModuleFrom(navModuleFrom);
				semmel006Bean.setNavProgramFrom(navProgramFrom);
				semmel006Bean.setActionWithNaviFrom(actionWithNaviFrom);
			}	
			flagReturn = true;
			logger.info("END initEditPayment7");
		}catch(Exception e){
			e.printStackTrace();
			logger.error("ERROR Action initEditPayment7 : "+e, e);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMEL006");
			FrontMessageUtils.addMessageError(errorMsg);
		}
		
		return flagReturn;
	}

	private SEMMCP001Bean semmcp001Bean;

	public void setSemmcp001Bean(SEMMCP001Bean semmcp001Bean) {
		this.semmcp001Bean = semmcp001Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.put("semmcp001Bean", semmcp001Bean);
	}

	public SEMMCP001Bean getSemmcp001Bean() {
		return (SEMMCP001Bean) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("semmcp001Bean");
	}
	private PopupVendorSupplierBean popupVendorSupplierBean;
	
	public PopupVendorSupplierBean getPopupVendorSupplierBean() {
		popupVendorSupplierBean = (PopupVendorSupplierBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupVendorSupplierBean");
		if(null == popupVendorSupplierBean){
			logger.debug(" -- PopupVendorSupplierBean is null--");
			popupVendorSupplierBean = new PopupVendorSupplierBean();
		}
			
		return popupVendorSupplierBean;
	}
	public void setPopupVendorSupplierBean(PopupVendorSupplierBean popupVendorSupplierBean) {
		this.popupVendorSupplierBean = popupVendorSupplierBean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupVendorSupplierBean",popupVendorSupplierBean);
	}
	
	public void doGenerateTermOfPaymentDateTime(){		
		logger.debug("START Action doGenerateTermOfPaymentDateTime()");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			PaymentDetail paymentDetail = semmel006Bean.getPaymentDetail();		
            String fromTermOfPaymentMonth = "";
            String fromTermOfPaymentYear = "";
            String toTermOfPaymentMonth = "";
            String toTermOfPaymentYear = "";
            int newFromMonth = 0;
            int newFromYear  = 0;
            int newToMonth   = 0;
            int newToYear    = 0;
            
            if(semmel006Bean.getPaymentDetail().getFromTermOfPaymentMonth()!= null 
               && semmel006Bean.getPaymentDetail().getFromTermOfPaymentYear()!= null){
            	newFromMonth              = Integer.valueOf(semmel006Bean.getPaymentDetail().getFromTermOfPaymentMonth());
            	newFromYear               = Integer.valueOf(semmel006Bean.getPaymentDetail().getFromTermOfPaymentYear());
            	
            	if(newFromMonth == 12){
            		newFromMonth = 1;
            		newFromYear  = newFromYear+1;
            	}
            	else{
            		newFromMonth = newFromMonth+1;
            	}
            	
            	if(newFromMonth > 0 && newFromYear > 0){
                 	
            		if(newFromMonth >=10){
                 		fromTermOfPaymentMonth =Integer.toString(newFromMonth);
                 	}
                 	else{
                 		fromTermOfPaymentMonth ="0"+Integer.toString(newFromMonth);
                 	}
            		fromTermOfPaymentYear = Integer.toString(newFromYear);
                 	
            		semmel006Bean.getPaymentDetail().setFromTermOfPaymentMonth(fromTermOfPaymentMonth);
					semmel006Bean.getPaymentDetail().setFromTermOfPaymentYear(fromTermOfPaymentYear);
					
            		semmel006Bean.getPaymentDetail().setFromTermOfPaymentDt(ELUtils.getDateByMonthandYear(fromTermOfPaymentMonth, fromTermOfPaymentYear));
                 	logger.info("Set From Date:"+ semmel006Bean.getPaymentDetail().getFromTermOfPaymentDt());
                 	
                 	if(semmel006Bean.getPaymentDetail()!=null && semmel006Bean.getPaymentDetail().getFromTermOfPaymentDt()!=null){
                        SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
                        String date = dtf.format(semmel006Bean.getPaymentDetail().getFromTermOfPaymentDt());
                        semmel006Bean.getPaymentDetail().setTermOfPaymentDateFrom(date);
                 	}
                 	
                 	toTermOfPaymentMonth = fromTermOfPaymentMonth;
                 	toTermOfPaymentYear  = fromTermOfPaymentYear;
                 	paymentDetail.setToTermOfPaymentMonth(toTermOfPaymentMonth);
                 	paymentDetail.setToTermOfPaymentYear(toTermOfPaymentYear);
                 	semmel006Bean.getPaymentDetail().setToTermOfPaymentDt(ELUtils.getEndDateByMonthandYear(toTermOfPaymentMonth, toTermOfPaymentYear));
                 	logger.info("Set To Date:"+ semmel006Bean.getPaymentDetail().getToTermOfPaymentDt());
                 	}
                    

               }
    		 /* 
            List <Date> fromTermOfPayment = new ArrayList();
            fromTermOfPayment = doGetNumberTermOfPayment(semmel006Bean.getPaymentDetail());
            
            if(fromTermOfPayment.size()>1){
            	semmel006Bean.setDisableValidateELPostPaidPaymentDetail(true);
				semmel006Bean.getPaymentDetail().setValidatePaymentDetailFlagBoolean(false);
				
			}
			else if (fromTermOfPayment.size()== 1){
				semmel006Bean.setDisableValidateELPostPaidPaymentDetail(false);
				//semmel006Bean.getPaymentDetail().setValidatePaymentDetailFlagBoolean(true);
			}
            */
            
			logger.info("END Action doGenerateTermOfPaymentDateTime");
		}catch(Exception ex){
			ex.printStackTrace();
			logger.debug("ERROR Action doGenerateTermOfPaymentDateTime : "+ex, ex);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMEL006");
			FrontMessageUtils.addMessageError(errorMsg);
		}		
	}
	//------------------------------------------
	public void doChangePaymentWhtAmtPrepaid( ){	
		logger.debug(" doChangePaymentWhtAmtPrepaid");
		semmel006Bean = getSemmel006Bean();	 
		Payment paymentDetail = semmel006Bean.getPayment();			

		BigDecimal currentWhtAmt =  paymentDetail.getWhtAmt()==null?new BigDecimal(0):paymentDetail.getWhtAmt().setScale(3,BigDecimal.ROUND_HALF_DOWN);
		BigDecimal previousWhtAmt =  semmel006Bean.getPreviosWhtAmt()==null?new BigDecimal(0):semmel006Bean.getPreviosWhtAmt().setScale(3,BigDecimal.ROUND_HALF_DOWN);
		
		logger.debug(" currentWhtAmt :"+currentWhtAmt);
		logger.debug(" previousWhtAmt:"+previousWhtAmt);   
		if(currentWhtAmt.intValue()==0){
			
		}else{
			  boolean compareStatus = true;
			  BigDecimal div= previousWhtAmt.subtract(currentWhtAmt);
			  int compareResult = 0;
			  //previousVatAmt>currentvatAmt
			  if(previousWhtAmt.compareTo(currentWhtAmt)==1){				  
				  compareResult =  div.compareTo(new BigDecimal(1));
				  if(compareResult==1){
					  compareStatus =false;
				  }
				//previousVatAmt<currentvatAmt
			  }else if (previousWhtAmt.compareTo(currentWhtAmt)==-1){
				  compareResult =  div.compareTo(new BigDecimal(-1));
				  if(compareResult==-1){
					  compareStatus =false;
				  }
				//previousVatAmt==currentvatAmt
			  }else if(previousWhtAmt.compareTo(currentWhtAmt)==0){
				  
			  }		  
			  
			  logger.debug(" currentWhtAmt "+currentWhtAmt +"previousWhtAmt: "+previousWhtAmt +"div:"+div+"  compartresult:"+compareResult);
			  if(!compareStatus){
				  // Error message EL0039
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0039"), ""));
					//reCalculatePaymentDetailConclution();
					paymentDetail.setWhtAmt(previousWhtAmt);
			  }else{	
				  paymentDetail.setWhtAmt(currentWhtAmt);
				  //semmel006Bean.setPreviosWhtAmt(currentWhtAmt);
			  }
			  
			  // Recalculate chqAmt 
			  
			  logger.debug(" whtAmt: "+currentWhtAmt);
			  
			  doChangePaymentWhtType6();
			  calculateWhtAmtPrepaid();
			  
			  
		} 
	}	
	private void calculateWhtAmtPrepaid(){
		logger.debug(" calculateWhtAmtPrepaid");
		Payment payment = semmel006Bean.getPayment();
		Payment paymentDetail = semmel006Bean.getPayment();	
		BigDecimal vatRate = payment.getWhtRate()==null?new BigDecimal(0):payment.getWhtRate();
		
		logger.debug("  vatRate:"+vatRate);
		logger.debug("  paymentDetail.getWhtAmt:"+paymentDetail.getWhtAmt());
		BigDecimal whtAmt = new BigDecimal(0);
		if( semmel006Bean.getPaymentDetailList() != null){
			//BigDecimal threeVatAmt = ELUtils.getAmtPercent(exVatAmt, vatRate);				
			int size = semmel006Bean.getPaymentDetailList().size();
			whtAmt = paymentDetail.getWhtAmt().divide(new BigDecimal(size),2,BigDecimal.ROUND_HALF_UP);
		}
		
		for(PaymentDetail objPaymentDetail : semmel006Bean.getPaymentDetailList()){
			/*
			BigDecimal exVatAmtDetail = new BigDecimal("0");
			String vatType = objPaymentDetail.getVatType();
			BigDecimal exVatAmt = objPaymentDetail.getExcludeVatAmt()==null?new BigDecimal(0): objPaymentDetail.getExcludeVatAmt();
			BigDecimal vatAmt = new BigDecimal(0);
			BigDecimal inVatAmt = objPaymentDetail.getIncludeVatAmt()==null?new BigDecimal(0): objPaymentDetail.getIncludeVatAmt();
			BigDecimal payAmt = objPaymentDetail.getPayAmt()==null?new BigDecimal(0): objPaymentDetail.getPayAmt();
			
			
			if("01".equals(vatType)){
				exVatAmt = ELUtils.getExcludeVatFromTotalPay(payAmt);
				vatAmt = ELUtils.getVatAmtFromTotalPay(payAmt);
				inVatAmt = exVatAmt.add(vatAmt);
			}else if("02".equals(vatType)){
				exVatAmt = payAmt;
				vatAmt = ELUtils.getNoVatAmtFromTotalPay(payAmt);
				inVatAmt = exVatAmt.add(vatAmt);
			}else if("03".equals(vatType)){
				exVatAmt = payAmt;
				vatAmt = new BigDecimal(0);
				inVatAmt = payAmt;
			}
			//whtAmt = threeVatAmt;	
			 * 
			 */
			
			objPaymentDetail.setWhtAmt(whtAmt);
			objPaymentDetail.setWhtType(payment.getWhtType());
			try {
				ELUtils.setPamentDetailDisplayField(objPaymentDetail);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void doSetTermOfPayment(){		
		logger.debug("START Action doSetTermOfPayment");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			PaymentDetail paymentDetail = semmel006Bean.getPaymentDetail();		
            String fromTermOfPaymentMonth = "";
            String fromTermOfPaymentYear = "";
            String toTermOfPaymentMonth = "";
            String toTermOfPaymentYear = "";
            
            if(semmel006Bean.getPaymentDetail().getFromTermOfPaymentMonth()!= null){
            	fromTermOfPaymentMonth = semmel006Bean.getPaymentDetail().getFromTermOfPaymentMonth();
    		}
            if(semmel006Bean.getPaymentDetail().getFromTermOfPaymentYear()!= null){
            	fromTermOfPaymentYear = semmel006Bean.getPaymentDetail().getFromTermOfPaymentYear();
    		}
            if(semmel006Bean.getPaymentDetail().getToTermOfPaymentMonth()!= null){
            	toTermOfPaymentMonth = semmel006Bean.getPaymentDetail().getToTermOfPaymentMonth();
    		}
            if(semmel006Bean.getPaymentDetail().getToTermOfPaymentYear()!= null){
            	toTermOfPaymentYear = semmel006Bean.getPaymentDetail().getToTermOfPaymentYear();
    		}
            //logger.info("fromTermOfPaymentMonth:"+fromTermOfPaymentMonth);
            //logger.info("fromTermOfPaymentYear:"+fromTermOfPaymentYear);
            //logger.info("toTermOfPaymentMonth:"+toTermOfPaymentMonth);
            //logger.info("toTermOfPaymentYear:"+toTermOfPaymentYear);
            
            if(!fromTermOfPaymentMonth.equalsIgnoreCase("") && !fromTermOfPaymentYear.equalsIgnoreCase("")){
            	semmel006Bean.getPaymentDetail().setFromTermOfPaymentDt(ELUtils.getDateByMonthandYear(fromTermOfPaymentMonth, fromTermOfPaymentYear));
            	 //logger.info("Set From Date:"+ semmel006Bean.getPaymentDetail().getFromTermOfPaymentDt());
            	
            	 if(toTermOfPaymentMonth.equalsIgnoreCase("") && toTermOfPaymentYear.equalsIgnoreCase("")){
            		toTermOfPaymentMonth = fromTermOfPaymentMonth;
            		toTermOfPaymentYear  = fromTermOfPaymentYear;
            		paymentDetail.setToTermOfPaymentMonth(toTermOfPaymentMonth);
            		paymentDetail.setToTermOfPaymentYear(toTermOfPaymentYear);
            	}
               

            }
            
            if(!toTermOfPaymentMonth.equalsIgnoreCase("") && !toTermOfPaymentYear.equalsIgnoreCase("")){
            		semmel006Bean.getPaymentDetail().setToTermOfPaymentDt(ELUtils.getEndDateByMonthandYear(toTermOfPaymentMonth, toTermOfPaymentYear));
            		//logger.info("Set To Date:"+ semmel006Bean.getPaymentDetail().getToTermOfPaymentDt());
            }
           logger.info("END Action doSetTermOfPayment");
		}catch(Exception ex){
			ex.printStackTrace();
			logger.debug("ERROR Action doSetTermOfPayment : "+ex, ex);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMEL006");
			FrontMessageUtils.addMessageError(errorMsg);
		}		
	}
	
	public void doChangeTermOfPayment(){		
		logger.debug("START Action doChangeTermOfPayment");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			PaymentDetail paymentDetail = semmel006Bean.getPaymentDetail();		
            String fromTermOfPaymentMonth = "";
            String fromTermOfPaymentYear = "";
            String toTermOfPaymentMonth = "";
            String toTermOfPaymentYear = "";
            
            if(semmel006Bean.getPaymentDetail().getFromTermOfPaymentDt()!= null){
            	fromTermOfPaymentMonth = ELUtils.getMonthNumberByDate(semmel006Bean.getPaymentDetail().getFromTermOfPaymentDt());
                fromTermOfPaymentYear = ELUtils.getYearNumberByDateTH(semmel006Bean.getPaymentDetail().getFromTermOfPaymentDt());
                semmel006Bean.getPaymentDetail().setFromTermOfPaymentMonth(fromTermOfPaymentMonth);
                semmel006Bean.getPaymentDetail().setFromTermOfPaymentYear(fromTermOfPaymentYear);
                
            	
    		}
            
            if(semmel006Bean.getPaymentDetail().getToTermOfPaymentDt()!= null){
            	toTermOfPaymentMonth = ELUtils.getMonthNumberByDate(semmel006Bean.getPaymentDetail().getToTermOfPaymentDt());
                toTermOfPaymentYear = ELUtils.getYearNumberByDateTH(semmel006Bean.getPaymentDetail().getToTermOfPaymentDt());
                semmel006Bean.getPaymentDetail().setToTermOfPaymentMonth(toTermOfPaymentMonth);
                semmel006Bean.getPaymentDetail().setToTermOfPaymentYear(toTermOfPaymentYear);
                
                 
    		}
            else{
            	semmel006Bean.getPaymentDetail().setToTermOfPaymentMonth(fromTermOfPaymentMonth);
                semmel006Bean.getPaymentDetail().setToTermOfPaymentYear(fromTermOfPaymentYear);
                if(semmel006Bean.getPaymentDetail().getFromTermOfPaymentDt()!= null){
                	 semmel006Bean.getPaymentDetail().setToTermOfPaymentDt(semmel006Bean.getPaymentDetail().getFromTermOfPaymentDt());	
                }
               
            }
            
            
		}catch(Exception ex){
			ex.printStackTrace();
			logger.debug("ERROR Action doChangeTermOfPayment : "+ex, ex);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = MessageFormat.format(errorMsg, "SEMMEL006");
			FrontMessageUtils.addMessageError(errorMsg);
		}		
	}
	private boolean doSearchInstallment7() {
		boolean flag = false;
		boolean validateFlag = false;
		
		try {
            
			logger.debug(" doSearchInstallment7() :");
            semmel006Bean = getSemmel006Bean();
            semmel006Bean.setInstallment(new InstallmentSearch7());
            String contractNo = semmel006Bean.getPopupSiteSearch7().getContractNo();
            String meterInfoId = semmel006Bean.getMeterInfo().getRowId();
            //semmel006Bean.getPaymentDetail().getToTermOfPaymentDt();
            //semmel006Bean.getPaymentDetail().getFromTermOfPaymentDt();
          //meterInfoId="9FFFDDD762F95DB6E040007F01001676";
            
            if (semmel006Bean.getPaymentDetail().getFromTermOfPaymentDt()== null) {
				FrontMessageUtils.addMessageError( 
						SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.fromTerm")));
				validateFlag = true;
			}
            if (semmel006Bean.getPaymentDetail().getToTermOfPaymentDt()== null) {
				FrontMessageUtils.addMessageError( 
						SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.toTerm")));
				validateFlag = true;
			}
            if (meterInfoId == null) {
				FrontMessageUtils.addMessageError( 
						SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.meterId")));
				validateFlag = true;
			}
            if(validateFlag){
            	return flag;
            }
            
            //logger.debug(" contractNo( :"+contractNo);
            logger.debug(" meterInfoId( :"+meterInfoId);
            //logger.debug(" contractNo( :"+contractNo);
            logger.debug(" From Dt( :"+semmel006Bean.getPaymentDetail().getFromTermOfPaymentDt());
            logger.debug(" To Dt( :"+semmel006Bean.getPaymentDetail().getToTermOfPaymentDt());
            
            
            
            semmel006Bean.getInstallment().setContractNo(contractNo);
            semmel006Bean.getInstallment().setMeterInfoId(meterInfoId);
            semmel006Bean.getInstallment().setFromTermOfPayment(semmel006Bean.getPaymentDetail().getFromTermOfPaymentDt());
            semmel006Bean.getInstallment().setToTermOfPayment(semmel006Bean.getPaymentDetail().getToTermOfPaymentDt());
            
            
			List<InstallmentSearch7> installment7List = null;
			List<InstallmentSearch7> result = new ArrayList<InstallmentSearch7>();
			IPaymentService service = (IPaymentService)getBean("paymentService");			
			installment7List= service.queryInstallment(semmel006Bean.getInstallment());
			
			for (InstallmentSearch7 insSearch7 :installment7List){
				if(insSearch7.getTermOfPaymentDt()!=null){
					insSearch7.setTermOfPaymentDt(SEMDataUtility.convertToThYear(insSearch7.getTermOfPaymentDt()));
				}
				if(insSearch7.getFromTermOfPaymentDt()!=null){
					insSearch7.setFromTermOfPaymentDt(SEMDataUtility.convertToThYear(insSearch7.getFromTermOfPaymentDt()));	
				}
				if(insSearch7.getToTermOfPaymentDt()!=null){
					insSearch7.setToTermOfPaymentDt(SEMDataUtility.convertToThYear(insSearch7.getToTermOfPaymentDt()));
				}
				if(insSearch7.getpDate()!=null){
					insSearch7.setpDate(SEMDataUtility.convertToThYear(insSearch7.getpDate()));
				}
				if(insSearch7.getlDate()!=null){
					insSearch7.setlDate(SEMDataUtility.convertToThYear(insSearch7.getlDate()));
				}
			}
			
//			semmel006Bean.setInstallmentSearch7lList(result);
			semmel006Bean.setInstallmentSearch7lList(installment7List);
			
			logger.debug(" Result Search :"+installment7List.size());
			if(installment7List.size()== 0){
				FrontMessageUtils.addMessageError( 
						SEMDataUtility.buildMessage(elmsg("message.nodatafound")));
				return flag;
			}
			//popupOldDoc7List= service.searchOldDoc7(semmel006Bean.getPopupOldDocCriteria7());
 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	private boolean doClearSearchInstallment7() {
		boolean flag = false;
		try {
			logger.debug(" doClearSearchInstallment7() :");
			semmel006Bean = getSemmel006Bean();
			semmel006Bean.getPaymentDetail().setFromTermOfPaymentMonth("");
			semmel006Bean.getPaymentDetail().setFromTermOfPaymentYear("");
			semmel006Bean.getPaymentDetail().setToTermOfPaymentMonth("");
			semmel006Bean.getPaymentDetail().setToTermOfPaymentYear("");
			semmel006Bean.getPaymentDetail().setFromTermOfPaymentDt(null);
			semmel006Bean.getPaymentDetail().setToTermOfPaymentDt(null);
 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public boolean initEditInstallmentPage7(){
		boolean flag = false;		
		logger.debug("START Action initEditInstallmentPage7");
		try{
			semmel006Bean = getSemmel006Bean();	
			String meterInstallmentId = (String)getFacesUtils().getRequestParameter("rowIndex");
			logger.debug("meterInstallmentId:"+meterInstallmentId);
			List<InstallmentSearch7> installmentList = semmel006Bean.getInstallmentSearch7lList();
			
			for(InstallmentSearch7 tmp : semmel006Bean.getInstallmentSearch7lList()){
				if(tmp.getMeterInstallmentID().equalsIgnoreCase(meterInstallmentId)){
					semmel006Bean.setInstallmentEdit(tmp);
					logger.debug("Term of Payment:"+tmp.getTermOfPaymentDt());
				}
			   
			}
			logger.debug("End Action initEditInstallmentPage7");
		
		}catch(Exception ex){
			logger.debug("Exception Action initDeletePaymentDetailPage7");
			ex.printStackTrace();
		}

		return flag;
	}
	
	private boolean doUpdateMeterInstallment7() {
		logger.debug(" -- doUpdateMeterInstallment7--");
		boolean flag = false;
		try {
			if(validateUpdateInstallment7()){
           	 return false;
            }
			
			semmel006Bean = getSemmel006Bean();
			
			IPaymentService service = (IPaymentService)getBean("paymentService");	
			ParameterConfig parameter = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_PAYMENT_P001");
			String plName = "SEM_PG_EL_SITE_INFO_PROCESS_SP_UPDATE_METER_INSTALLMENT";
			//List plresult = service.addELPostpaidToModel5(plName, detailForcallPL);
			List plresult = service.updateInstallment(plName, semmel006Bean.getInstallmentEdit());
			//logger.debug(" doAddPaymentDetailToModelPRPostpaid() PL return value:"+plresult.get(0));
			String value0 =(String)plresult.get(0);
			
			if(value0.equals("00")){							
					addMessageInfo("M0001");
				}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
			
		return flag;
	}	
	private boolean validateUpdateInstallment7(){
		logger.debug("START Action validateUpdateInstallment7");
		boolean flag = false;
		semmel006Bean = getSemmel006Bean();
		InstallmentSearch7 installment = semmel006Bean.getInstallmentEdit();
		//logger.debug("installment.getpDate():"+installment.getpDate());
		//logger.debug("installment.getlDate():"+installment.getlDate());
		//logger.debug("installment.getpread():"+installment.getpRaed());
		//logger.debug("installment.getlread():"+installment.getlRaed());
		
		
		if(installment.getpDate()== null){
			
			//FrontMessageUtils.addMessageError( 
			//		SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.pDate")));
			//flag = true;
			//installment.setpDate(new Date());
		}
		if(installment.getlDate()== null){
			//FrontMessageUtils.addMessageError( 
			//		SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.lDate")));
			//flag = true;
			//installment.setlDate(new Date());
		}
		if(installment.getpRaed()== null ||installment.getpRaed().compareTo(new BigDecimal(0))==0){
			//FrontMessageUtils.addMessageError( 
			//		SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.pRead")));
			//flag = true;
			installment.setpRaed(new BigDecimal(0));
		}
		if(installment.getlRaed()== null ||installment.getlRaed().compareTo(new BigDecimal(0))==0){
			//FrontMessageUtils.addMessageError( 
			//		SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.lRead")));
			//flag = true;
			installment.setlRaed(new BigDecimal(0));
		}
		if(installment.getKwh()== null||installment.getKwh().compareTo(new BigDecimal(0))==0){
			//FrontMessageUtils.addMessageError( 
			//		SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.kwhTotal")));
			//flag = true;
			installment.setKwh(new BigDecimal(0));
		}
		
		
		if(installment.getPayAmt()== null||installment.getPayAmt().compareTo(new BigDecimal(0))==0){
			FrontMessageUtils.addMessageError( 
					SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.payAmt")));
			flag = true;
		}
		if(installment.getInculdeVat()== null||installment.getInculdeVat().compareTo(new BigDecimal(0))==0){
			FrontMessageUtils.addMessageError( 
					SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.includeVatAmt")));
			flag = true;
		}
		if(installment.getVatAmt()== null){
			FrontMessageUtils.addMessageError( 
					SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vatAmt")));
			flag = true;
		}
		if(installment.getExculdeVat()== null||installment.getExculdeVat().compareTo(new BigDecimal(0))==0){
			FrontMessageUtils.addMessageError( 
					SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.invExcludeVatAmt")));
			flag = true;
		}
		if(installment.getVatType()== null||installment.getVatType().equalsIgnoreCase("")){
			
			FrontMessageUtils.addMessageError( 
					SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), elmsg("message.vatType")));
			flag = true;
		}
		logger.debug("END Action validateUpdateInstallment7");
		return flag;
		
	}
	private boolean doBackMeterInstallment7() {
		logger.debug(" -- doBackMeterInstallment7--");
		boolean flag = false;
		try {
			
			doSearchInstallment7();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
			
		return flag;
	}
	public void doChangeMeterUpdateInstallment(){		
		SEMMEL006Bean semmel006Bean = getSemmel006Bean();		
		try{
			logger.debug("doChangeMeterUpdateInstallment");
			
			String meterId = semmel006Bean.getPopupSiteCriteria().getMeterId();
			
			logger.debug("doChangeMeter try to get MeterInfo of meterId:"+meterId);
			if(meterId != null){			
				IMeterInfoService meterInfoService = (IMeterInfoService)getBean("meterInfoService");
				MeterInfo meterInfo = meterInfoService.queryByRowId(meterId);
				if(meterInfo!=null){
					//logger.debug("  Found  MeterInfo :"+BeanUtils.getBeanString(meterInfo));
					semmel006Bean.setMeterInfo(meterInfo);	
					semmel006Bean.getPaymentDetail().setUnitVatType(meterInfo.getLastUnitVatType());		
					semmel006Bean.getPaymentDetail().setVatType(meterInfo.getLastUnitVatType());
					semmel006Bean.getPaymentDetail().setUnitPrice(meterInfo.getLastUnitAmt());
					semmel006Bean.getPaymentDetail().setpRead(meterInfo.getLastLKwh());
				
									
				}else{
					logger.debug(" Not found  MeterInfo belong to :"+meterId);
					semmel006Bean.setMeterInfo(new MeterInfo());
					semmel006Bean.getPaymentDetail().setWhtType(null);
					semmel006Bean.getPaymentDetail().setWhtType(null);
				}

			}
			
		}catch(Exception e){
			
			e.printStackTrace();
			
			addMessageError("EL0000", "SEMMEL006");
		}
	}
	
	public boolean doCheckMultiVendor(){		
		logger.debug(" -- doCheckMultiVendor--");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			PaymentDetail paymentDetail = semmel006Bean.getPaymentDetail();		
			boolean isCheck = paymentDetail.isMultiVendorCheckBoolean();
			
			if(isCheck){
				logger.debug("  MultiVendor is Checked");				
				
				//WT###20110131 End
			}else{
				logger.debug("  MultiVendor is not Checked");
				
				//WT###20110131 End
			 
			}
			logger.debug("  MultiVendor:"+paymentDetail.getMultiVendorCheck());
		
		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return flagValid;			
	}
	
	public boolean docalCulateVATEditInstallment(){		
		logger.debug(" -- docalCulateVATEditInstallment--");
		boolean flagValid = false;		
		try{
			semmel006Bean = getSemmel006Bean();	 
			//InstallmentSearch7 installment = semmel006Bean.getInstallment();
			InstallmentSearch7 installment = semmel006Bean.getInstallmentEdit();
			String vatType      = installment.getVatType();
			logger.debug(" vatType  :"+vatType);
			
			
			BigDecimal totalPayAmt = new BigDecimal(0);
			BigDecimal totalWhtAmt = new BigDecimal(0);
			BigDecimal totalExVatAmt =  new BigDecimal(0);
			BigDecimal totalVatAmt = new BigDecimal(0);
			BigDecimal totalInVatAmt = new BigDecimal(0);
			BigDecimal totalChqAmt = new BigDecimal(0);
			
			BigDecimal totalSevenVatAmt = new BigDecimal(0);
			BigDecimal totalThreeVatAmt = new BigDecimal(0);
			

			BigDecimal payAmt = installment.getPayAmt()==null? new BigDecimal(0):installment.getPayAmt();						
			BigDecimal exVatAmt =  installment.getExculdeVat()==null? new BigDecimal(0):installment.getExculdeVat();					
			totalPayAmt = totalPayAmt.add(payAmt);

			
			if("01".equals(vatType)){
				totalExVatAmt = ELUtils.getExcludeVatFromTotalPay(totalPayAmt);
				totalVatAmt = ELUtils.getVatAmtFromTotalPay(totalPayAmt);
				totalInVatAmt =totalExVatAmt.add(totalVatAmt);
				semmel006Bean.setVatAmtDisable(false);
			
			}else	if("02".equals(vatType)){
				totalExVatAmt = totalPayAmt;
				//totalVatAmt = new BigDecimal(0);
				totalVatAmt = ELUtils.getSevenVAtAmtFromOriginalPrice(totalPayAmt);
				totalInVatAmt =totalPayAmt.add(totalVatAmt);
				semmel006Bean.setVatAmtDisable(false);
			
			}else if("03".equals(vatType)){
				totalExVatAmt = totalPayAmt;
				totalVatAmt = new BigDecimal(0);
				totalInVatAmt =totalPayAmt;
				semmel006Bean.setVatAmtDisable(true);
			}		
			
			totalSevenVatAmt = ELUtils.getAmtPercent(totalPayAmt, new BigDecimal(7));	
			totalChqAmt = totalInVatAmt;
			
			installment.setPayAmt(totalPayAmt);
			installment.setExculdeVat(totalExVatAmt);
			installment.setVatAmt(totalVatAmt);
			installment.setInculdeVat(totalInVatAmt);
			

		}catch(Exception ex){
			ex.printStackTrace();
		}		
		return flagValid;			
	}
	
	public void exportHistoryPayment(){
		logger.debug("START ACTION exportSuccess");
		try{
			semmel006Bean = getSemmel006Bean();	
			String company = semmel006Bean.getPopupSiteCriteria().getCompany();
			String contractNo = semmel006Bean.getPopupSiteCriteria().getContractNo();
			HSSFWorkbook wb = new HSSFWorkbook(this.getClass().getResourceAsStream("/resources/el/HistoryPayment.xls"));			
			setExcelSuccessList(wb);
			HttpServletResponse res = FacesUtils.getInstance().getHttpResponse();   
			res.setContentType("application/vnd.ms-excel");   
			res.setHeader("Content-disposition",  "attachment;filename="+
					contractNo+"_"+"History_Payment"+"_"
					+SEMDataUtility.getCurrentDateDefaultForFileName()+".xls");
          
            ServletOutputStream out = res.getOutputStream();   
     
            wb.write(out);   
            out.flush();   
            out.close();   
       
            FacesContext faces = FacesContext.getCurrentInstance();   
            faces.responseComplete(); 
            
        }catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void setExcelSuccessList(HSSFWorkbook wb) {
	
		semmel006Bean = getSemmel006Bean();
		HSSFSheet sheetELPAY00_1 = wb.getSheetAt(0);
		HSSFRow row = null;  
	    HSSFCell cell = null;
	    short line = 0;		
	    List<ManagementWrapper> temp = semmel006Bean.getPaymentHistoryWrapperList();
	    setExcelSuccessDetailAdditionalGeneral(cell, row, line, sheetELPAY00_1,temp);
		
	}
	
	private void setExcelSuccessDetailAdditionalGeneral   (HSSFCell cell, HSSFRow row,
			short line, HSSFSheet sheet, List<ManagementWrapper> paymentDetailList) {
		
		for(int i=0; i<paymentDetailList.size(); i++){
			PaymentDetail paymentDetail = new PaymentDetail();
			ManagementWrapper wrapper   = paymentDetailList.get(i);
			row = sheet.createRow(++line);

			cell = row.createCell((short)0);
			cell.setCellValue(new HSSFRichTextString(wrapper.getHistPayment().getContractNo()));
			
			cell = row.createCell((short)1);
			cell.setCellValue(new HSSFRichTextString(wrapper.getHistPayment().getOldContractNo()));
			
			cell = row.createCell((short)2);
			cell.setCellValue(new HSSFRichTextString(wrapper.getHistPayment().getCompany()));
			
			cell = row.createCell((short)3);
			cell.setCellValue(new HSSFRichTextString(wrapper.getHistPaymentDetail().getExpenseTypeTxt()));
			
			cell = row.createCell((short)4);
			cell.setCellValue(new HSSFRichTextString(wrapper.getHistPayment().getVendorId()));
			
			cell = row.createCell((short)5);
			cell.setCellValue(new HSSFRichTextString(wrapper.getHistPayment().getVendorName()));
			
			cell = row.createCell((short)6);
			cell.setCellValue(new HSSFRichTextString(wrapper.getHistPayment().getPayeeId()));
			
			cell = row.createCell((short)7);
			cell.setCellValue(new HSSFRichTextString(wrapper.getHistPayment().getPayeeName()));
			
			cell = row.createCell((short)8);
			cell.setCellValue(new HSSFRichTextString(wrapper.getHistPaymentDetail().getMeterId()));
			
			cell = row.createCell((short)9);
			cell.setCellValue(new HSSFRichTextString(wrapper.getHistPaymentDetail().getTermOfPaymentDate()));
			
			cell = row.createCell((short)10);
			cell.setCellValue(new HSSFRichTextString(wrapper.getHistPaymentDetail().getFromTermOfPaymentDtTH()));
			
			cell = row.createCell((short)11);
			cell.setCellValue(new HSSFRichTextString(wrapper.getHistPaymentDetail().getToTermOfPaymentDtTH()));
			
			cell = row.createCell((short)12);
			cell.setCellValue(new HSSFRichTextString("1"));
			
			cell = row.createCell((short)13);
			try {
				cell.setCellValue(new HSSFRichTextString(wrapper.getHistPaymentDetail().getpRead().toString()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}
			
			cell = row.createCell((short)14);
			try {
				cell.setCellValue(new HSSFRichTextString(wrapper.getHistPaymentDetail().getlRead().toString()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}
			
			cell = row.createCell((short)15);
			try {
				cell.setCellValue(new HSSFRichTextString(wrapper.getHistPaymentDetail().getKwhTotal().toString()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}
			
			cell = row.createCell((short)16);
			try {
				cell.setCellValue(new HSSFRichTextString(wrapper.getHistPaymentDetail().getUnitPrice().toString()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}
			
			cell = row.createCell((short)17);
			try {
				cell.setCellValue(new HSSFRichTextString(wrapper.getHistPaymentDetail().getUnitVatTypeTxt()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}
			
			cell = row.createCell((short)18);
			try {
				cell.setCellValue(new HSSFRichTextString(wrapper.getHistPaymentDetail().getPayAmt().toString()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}
			
			cell = row.createCell((short)19);
			try {
				cell.setCellValue(new HSSFRichTextString(wrapper.getHistPaymentDetail().getVatTypeTxt()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}
			
			cell = row.createCell((short)20);
			try {
				cell.setCellValue(new HSSFRichTextString(wrapper.getHistPaymentDetail().getExcludeVatAmt().toString()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}
			
			cell = row.createCell((short)21);
			try {
				cell.setCellValue(new HSSFRichTextString(wrapper.getHistPaymentDetail().getVatAmt().toString()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}
			
			cell = row.createCell((short)22);
			try {
				cell.setCellValue(new HSSFRichTextString(wrapper.getHistPaymentDetail().getIncludeVatAmt().toString()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}
			
			cell = row.createCell((short)23);
			try {
				cell.setCellValue(new HSSFRichTextString(wrapper.getHistPaymentDetail().getWhtAmt().toString()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}
			
			cell = row.createCell((short)24);
			try {
				cell.setCellValue(new HSSFRichTextString(wrapper.getHistPaymentDetail().getChqAmt().toString()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}
			
			cell = row.createCell((short)25);
			try {
				cell.setCellValue(new HSSFRichTextString(wrapper.getHistPayment().getPaymentTypeTxt()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}
			
			cell = row.createCell((short)26);
			try {
				cell.setCellValue(new HSSFRichTextString(wrapper.getHistPayment().getPaymentMethodTxt()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}
			
			cell = row.createCell((short)27);
			try {
				cell.setCellValue(new HSSFRichTextString(wrapper.getHistPayment().getBankName()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}
			
			cell = row.createCell((short)28);
			try {
				cell.setCellValue(new HSSFRichTextString(wrapper.getHistPayment().getBankAccount()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}
			
			cell = row.createCell((short)29);
			try {
				cell.setCellValue(new HSSFRichTextString(wrapper.getHistPayment().getChqNo()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}
			
			cell = row.createCell((short)30);
			try {
				cell.setCellValue(new HSSFRichTextString(wrapper.getHistPayment().getChqPostingDtTH()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}
			
			cell = row.createCell((short)31);
			try {
				cell.setCellValue(new HSSFRichTextString(wrapper.getHistPayment().getChqReceivedDtTH()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}
			
			cell = row.createCell((short)32);
			try {
				cell.setCellValue(new HSSFRichTextString(wrapper.getHistPayment().getTransferDtTH()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}
			
			cell = row.createCell((short)33);
			try {
				cell.setCellValue(new HSSFRichTextString(wrapper.getHistPayment().getChqClearingDtTH()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}
			
			cell = row.createCell((short)34);
			try {
				cell.setCellValue(new HSSFRichTextString(wrapper.getHistPayment().getDoc68()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}
			
			cell = row.createCell((short)35);
			try {
				cell.setCellValue(new HSSFRichTextString(wrapper.getHistPayment().getDoc92()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}
			
			cell = row.createCell((short)36);
			try {
				cell.setCellValue(new HSSFRichTextString(wrapper.getHistPayment().getRemark()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}
			
			cell = row.createCell((short)37);
			try {
				cell.setCellValue(new HSSFRichTextString(wrapper.getHistPaymentDetail().getCreateBy()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}
		    
			cell = row.createCell((short)38);
			try {
				cell.setCellValue(new HSSFRichTextString(wrapper.getHistPaymentDetail().getCreateDtTH()));
			} catch (Exception e) {
				cell.setCellValue(new HSSFRichTextString("0"));
			}
			
		}
		
	}
	
	public void getVenderDetail(){
		logger.debug("=====getVenderDetail=====");		
		semmel006Bean = getSemmel006Bean();
		String fromChangePaymentType = (String)getFacesUtils().getRequestParameter("fromChangePaymentType");
//		String fromChangeVendorMaster = (String)getFacesUtils().getRequestParameter("fromChangeVendorMaster");
		IVendorMasterService vendorMasterService = (IVendorMasterService) getBean("vendorMasterService");
		VendorSP vendorSP = new VendorSP();
		try{
			if(StringUtils.isNotEmpty(semmel006Bean.getPayment().getVendorId())){
				
//					vendorSP.setContractNo(semmel006Bean.getPopupSiteCriteria().getContractNo());
//					if(StringUtils.equalsIgnoreCase("Y", fromChangeVendorMaster)){
//						vendorSP.setVendorId(semmel006Bean.getPayment().getVendorId());
//					}else{
//						if(semmel006Bean.getVendorIdList()!=null){
//						vendorSP.setVendorId((String) semmel006Bean.getVendorIdList().get(0).getValue());
//						}
//					}
					
					if(StringUtils.equalsIgnoreCase("Y", fromChangePaymentType)){
						vendorSP.setPaymentType(semmel006Bean.getPayment().getPaymentType());
					}
				
				vendorSP.setContractNo(semmel006Bean.getPopupSiteCriteria().getContractNo());
				vendorSP.setVendorId(semmel006Bean.getPayment().getVendorId());
				vendorSP.setExpenseType("06");
				logger.debug("vendorSP.getContractNo() = "+vendorSP.getContractNo());
				logger.debug("vendorSP.getVendorId() = "+vendorSP.getVendorId());
				logger.debug("vendorSP.getExpenseType() = "+vendorSP.getExpenseType());
				
				List<VendorSP> vendorList = vendorMasterService.querySPList(EQueryName.SP_GET_DETAIL_VENDOR_PAYEE.name, vendorSP);
				VendorSP vendor = new VendorSP();
				logger.debug("vendorList.size() = "+vendorList.size());
				vendor = vendorList.get(0);
				logger.debug("vendorSP.getVendorMapPayeeId() = "+vendorSP.getVendorMapPayeeId());
				logger.debug("vendorSP.getContractNo() = "+vendorSP.getContractNo());
				logger.debug("vendorSP.getVendorId() = "+vendorSP.getVendorId());
				logger.debug("vendorSP.getExpenseType() = "+vendorSP.getExpenseType());
				logger.debug("vendorSP.getBankCode() = "+vendorSP.getBankCode());
				logger.debug("vendorSP.getBankName() = "+vendorSP.getBankName());
				
				semmel006Bean.getPayment().setVendorName(vendor.getVendorName());
				semmel006Bean.getPayment().setPayeeId(vendor.getPayeeCode());
				semmel006Bean.getPayment().setPayeeName(vendor.getPayeeName());
				semmel006Bean.getPayment().setPaymentType(vendor.getPaymentType());
				semmel006Bean.getPayment().setBankName(vendor.getBankName());
				semmel006Bean.getPayment().setBankAccount(vendor.getBankAccNo());
			}
			
			setSemmel006Bean(semmel006Bean);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private boolean initPopupPercentGrowth(){
		logger.debug("=====initPopupPercentGrowth=====");	
		boolean flag = false;
		semmel006Bean = getSemmel006Bean();
		semmel006Bean.setElGroupSP(new ElGroupSP());
		semmel006Bean.setElGroupSPList(new ArrayList<ElGroupSP>());
		String percentExpenseType = (String)getFacesUtils().getRequestParameter("percentExpenseType");
		String percentcontractNo =  (String)getFacesUtils().getRequestParameter("percentcontractNo");
		String percentPayDate =  (String)getFacesUtils().getRequestParameter("percentPayDate");
		String percentKwhNew =  (String)getFacesUtils().getRequestParameter("percentKwhNew");
		String percentUnitNew =  (String)getFacesUtils().getRequestParameter("percentUnitNew");
		String percentAmtNew =  (String)getFacesUtils().getRequestParameter("percentAmtNew");
		String percentType =  (String)getFacesUtils().getRequestParameter("percentType");
		String percentTransId =  (String)getFacesUtils().getRequestParameter("percentTransId");
		String percentRecStatus =  (String)getFacesUtils().getRequestParameter("percentRecStatus");
		String percentErrCode =  (String)getFacesUtils().getRequestParameter("percentErrCode");
		
//		String fromPage =  (String)getFacesUtils().getRequestParameter("fromPage");
		IPaymentService service = (IPaymentService)getBean("paymentService");
		
		List<ElGroupSP> to = null ;
		
		 	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH); 
		    Date convertedDate = null;
		    String dtStr = "";
			try {
//				 percentExpenseType = "";
//				 percentcontractNo =  "";
//				 percentPayDate =  "";
				
				if (StringUtils.isNotEmpty(percentPayDate)){
				convertedDate = dateFormat.parse(percentPayDate);
				dtStr = dateFormat.format(SEMDataUtility.convertToThYear(convertedDate));
				}
				
				
				if(!StringUtils.equalsIgnoreCase("EL_POSTPAID", percentExpenseType)){
					semmel006Bean.getElGroupSP().setTypeFlag(true);
				}else{
					semmel006Bean.getElGroupSP().setTypeFlag(false);
				}
				
				semmel006Bean.getElGroupSP().setPercentContractNo(percentcontractNo);
				semmel006Bean.getElGroupSP().setTermPayDtStr(dtStr);
				semmel006Bean.getElGroupSP().setExpenseType(percentExpenseType);
				semmel006Bean.getElGroupSP().setPercentKwhNew(percentKwhNew);
				semmel006Bean.getElGroupSP().setPercentUnitNew(percentUnitNew);
				semmel006Bean.getElGroupSP().setPercentAmtNew(percentAmtNew);
				semmel006Bean.getElGroupSP().setPercentKwhNewDouble(SemUtils.parseDouble(percentKwhNew));
				semmel006Bean.getElGroupSP().setPercentUnitNewDouble(SemUtils.parseDouble(percentUnitNew));
				semmel006Bean.getElGroupSP().setPercentAmtNewDouble(SemUtils.parseDouble(percentAmtNew));
				semmel006Bean.getElGroupSP().setPercentType(percentType);
				semmel006Bean.getElGroupSP().setPercentTransId(percentTransId);
				semmel006Bean.getElGroupSP().setPercentRecStatus(percentRecStatus);
				semmel006Bean.getElGroupSP().setPercentErrCode(percentErrCode);
				
				try {
					to = service.querySPList(EQueryName.SP_SHOW_PERCENT_GROWTH.name,semmel006Bean.getElGroupSP());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(to!=null&&!to.isEmpty()){
					semmel006Bean.setElGroupSPList(to);
				}else {
					FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("M0004"), ""));
				}
				flag = true;
				
				
				
			}catch (Exception e) {
				e.printStackTrace();
			} finally{
				semmel006Bean.setElGroupSP(semmel006Bean.getElGroupSP());
			}

			return flag;
			
		
	}
	
	private boolean initPopupGroupMeter(){
		logger.debug("=====initPopupGroupMeter=====");	
		boolean flag = false;
		semmel006Bean = getSemmel006Bean();
		semmel006Bean.setElGroupSP(new ElGroupSP());
		semmel006Bean.setElGroupSPList(new ArrayList<ElGroupSP>());
		IPaymentService service = (IPaymentService)getBean("paymentService");	
		String groupExpenseType = (String)getFacesUtils().getRequestParameter("groupExpenseType");
		String groupOwnerGroup =  (String)getFacesUtils().getRequestParameter("groupOwnerGroup");
		String groupFlagType =  (String)getFacesUtils().getRequestParameter("groupFlagType");
		String groupContractNo = (String)getFacesUtils().getRequestParameter("groupContractNo");
		
		List<ElGroupSP> to = null ;
		List<ElGroupSP> resultList = new ArrayList<ElGroupSP>() ;
				semmel006Bean.getElGroupSP().setExpenseType(groupExpenseType);
				semmel006Bean.getElGroupSP().setGroupOwnerGroup(groupOwnerGroup);
				semmel006Bean.getElGroupSP().setGroupFlagType(groupFlagType);
				semmel006Bean.getElGroupSP().setGroupContractNo(groupContractNo);
				
				try {
					to = service.querySPList(EQueryName.SP_EL_OWNER_GROUP.name,semmel006Bean.getElGroupSP());
					
					if(to!=null&&!to.isEmpty()){
						for (ElGroupSP elGroup : to){
							if(elGroup.getPeriodDt()!=null){
								elGroup.setPeriodDt(SEMDataUtility.convertToThYear(elGroup.getPeriodDt()));
							}
							if(elGroup.getPaymentDtFrom()!=null){
								elGroup.setPaymentDtFrom(SEMDataUtility.convertToThYear(elGroup.getPaymentDtFrom()));
							}
							if(elGroup.getPaymentDtTo()!=null){
								elGroup.setPaymentDtTo(SEMDataUtility.convertToThYear(elGroup.getPaymentDtTo()));
							}
						}
						semmel006Bean.setElGroupSPList(to);
					}else {
						FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("M0004"), ""));
					}
					flag = true;
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					setSemmel006Bean(semmel006Bean);
				}
				
//			}
			return flag;
			
		
	}
	
	private void chkDisableBtnPercentGroup(){
		semmel006Bean = getSemmel006Bean();
	if(semmel006Bean.getPopupSiteCriteria().getContractNo()!=null && semmel006Bean.getPaymentDetail().getFromTermOfPaymentDt()!=null){
//		semmel006Bean
		
	}
	}
	
	private boolean doVerify(){
		
		SEMMEL005Bean semmel005Bean = getSemmel005Bean();
		String contractNo =  (String)getFacesUtils().getRequestParameter("contractNo");
		String transId =  (String)getFacesUtils().getRequestParameter("transId");
		
		ElVerifySP elVerifySP = new ElVerifySP();
		elVerifySP.setContractNo(contractNo);
		elVerifySP.setTransId(transId);
		elVerifySP.setImportTransId(semmel005Bean.getUploadTextSP().getElImportTranId());
		elVerifySP.setUsername(getUserLogIn());
		
		try {
			List<ElVerifySP> elVerifyList = null;
			IManagementService manageService = (IManagementService)getBean("managementService");
			elVerifyList = manageService.querySPList(EQueryName.SP_MEL005_SUCCESS_VALIDATE.name, elVerifySP);

			String result = elVerifyList.get(0).getResult();
			String remark = elVerifyList.get(0).getRemark();
			if(StringUtils.equalsIgnoreCase("Success",result)){
				addGeneralMessageError(remark);
				semmel005Bean.setRenderedMsgFormMiddle(true);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			setSemmel005Bean(semmel005Bean);
		}
		
		return false;
	}
	
	// -> popup add vendor
	public void initAddVendor(){
		logger.info("-- initPopupAddVendor --");

		SEMMEL006Bean ct001Bean = getSemmel006Bean();

		try {
			
			doClearPopupAddVendor();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmel006Bean(ct001Bean);
	}
	
	public void doSearchPopupAddVendor(){
		logger.info("-- doSearchPopupAddVendor --");

		SEMMEL006Bean ct001Bean = getSemmel006Bean();

		try {
			
			//String strVendorCode = ct001Bean.getVendorMasterPopupObjParam().getVendorCode();
			//String strVendorName = ct001Bean.getVendorMasterPopupObjParam().getVendorName();


			IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
			List<VendorMasterSP> vendorMasterList = null;
			
			ct001Bean.setVendorMasterPopupList(new ArrayList<WrapperBeanObject<VendorMasterSP>>());
			
			vendorMasterList = service.queryVendorMasterSPList(EQueryName.SP_GET_MAP_VENDOR.name, ct001Bean.getVendorMasterPopupObjParam());
			if(vendorMasterList != null && !vendorMasterList.isEmpty()){
				 for(int i=0; i<vendorMasterList.size(); i++){
					VendorMasterSP vm = (VendorMasterSP)vendorMasterList.get(i);
					WrapperBeanObject<VendorMasterSP> tmpWrapperBean = new WrapperBeanObject<VendorMasterSP>();
					
					tmpWrapperBean.setDataObj(vm);
					tmpWrapperBean.setMessage("");
					ct001Bean.getVendorMasterPopupList().add(tmpWrapperBean);
					
					ct001Bean.setRenderedMsgDataNotFound(false);
				 }
			 } else {
				 ct001Bean.setRenderedMsgDataNotFound(true);
			 }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmel006Bean(ct001Bean);
	}
	
	public void doClearPopupAddVendor(){
		logger.info("-- doClearPopupAddVendor --");

		SEMMEL006Bean ct001Bean = getSemmel006Bean();

		try {
			
			ct001Bean.getVendorMasterPopupObjParam().setVendorCode("");
			ct001Bean.getVendorMasterPopupObjParam().setVendorName("");
			ct001Bean.setVendorMasterPopupList(new ArrayList<WrapperBeanObject<VendorMasterSP>>());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmel006Bean(ct001Bean);
	}
	
	public void doSelectPopupAddVendor(){
		logger.info("-- doSelectPopupAddVendor --");

		SEMMEL006Bean ct001Bean = getSemmel006Bean();
		ct001Bean.setPopupSiteCriteria(new PopupSiteSearch());
		try {
			
			String paramVendorCode = getFacesUtils().getRequestParameter("paramVendorCode") == null ? "" : 
							  (String)getFacesUtils().getRequestParameter("paramVendorCode");
			String paramVendorName = getFacesUtils().getRequestParameter("paramVendorName") == null ? "" : 
				  (String)getFacesUtils().getRequestParameter("paramVendorName");
			
			//add vendor code to target
//			ct001Bean.getCriteriaVendorSP().setVendorCode(paramVendorCode);
//			ct001Bean.getCriteriaVendorSP().setVendorName(paramVendorName);
			ct001Bean.getPopupSiteCriteria().setVendorId(paramVendorCode);
//			ct001Bean.getPopupSiteCriteria().setVendorName(paramVendorName);
			 
			PopupVendorSupplierAction vendorAction = new PopupVendorSupplierAction();
			vendorAction.doSelectPopupAddVendor(paramVendorCode,paramVendorName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmel006Bean(ct001Bean);
	}
	// <- popup add vendor
}


	
