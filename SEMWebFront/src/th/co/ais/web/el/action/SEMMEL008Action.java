package th.co.ais.web.el.action; 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.UUID;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Font;
import org.aspectj.org.eclipse.jdt.internal.core.util.HashSetOfArray;
import java.util.HashMap;
import java.util.HashSet;

import th.co.ais.domain.el.BgMapContract;
import th.co.ais.domain.el.MEL008Act;
import th.co.ais.domain.el.MEL008ChkPay;
import th.co.ais.domain.el.Mel008ExpLetter;
import th.co.ais.domain.el.Mel008ReportSP;
import th.co.ais.domain.el.MeterInstallment;
import th.co.ais.domain.el.Payment;
import th.co.ais.domain.el.PaymentDetail;
import th.co.ais.domain.el.PaymentDetailSP;
import th.co.ais.domain.el.PaymentSP;
import th.co.ais.domain.el.PaymentWrapper;
import th.co.ais.domain.el.WarrantDatail;
import th.co.ais.domain.el.paymentExpExcel;
import th.co.ais.domain.gm.ParameterConfig;
import th.co.ais.domain.gm.VendorMasterSP;
import th.co.ais.domain.pt.Mpt003ExpLetter;
import th.co.ais.domain.rt.EMAILModel;
import th.co.ais.domain.rt.Mrt003Exp;
import th.co.ais.domain.rt.Mrt003ExpLetter;
import th.co.ais.domain.rt.RentalPayNormalSearchSP;
import th.co.ais.domain.rt.SMSModel;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.rpt.util.bean.CellDomain;
import th.co.ais.rpt.util.bean.EnumDocStyleDomain;
import th.co.ais.rpt.util.bean.RowDomain;
import th.co.ais.rpt.util.enums.EnumDocStyle;
import th.co.ais.rpt.util.enums.EnumDocumentType;
import th.co.ais.service.el.IManagementService;
import th.co.ais.service.el.IPaymentService;
import th.co.ais.service.gm.IVendorMasterService;
import th.co.ais.service.pt.IPTaxMasterService;
import th.co.ais.service.rt.IRentalPaymentService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.SsoBean;
import th.co.ais.web.bean.common.PopupUploadFilePictureBean;
import th.co.ais.web.el.bean.SEMMEL001Bean;
import th.co.ais.web.el.bean.SEMMEL008Bean;
import th.co.ais.web.pt.bean.SEMMPT004Bean;
import th.co.ais.web.report.util.DocumentExportManager;
import th.co.ais.web.rt.bean.SEMMRT003Bean;
import th.co.ais.web.util.ELUtils;
import th.co.ais.web.util.EmailMessageUtil;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.LOVCacheUtil;
import th.co.ais.web.util.MSGCacheUtil;
import th.co.ais.web.util.RegionCacheUtil;
import th.co.ais.web.util.SmsClient;
import th.co.ais.web.util.config.ParameterConfigUtil;


public class SEMMEL008Action extends AbstractAction{
	Logger LOG = Logger.getLogger(SEMMEL008Action.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5252768051756121174L;

	private static final String BEAN_SEMMEL001 = "semmel001Bean";
	private static final String ALERT_MESSAGE_EDIT = "EDIT";
	private static final String ALERT_MESSAGE_CANCEL_PAYMENT = "CANCEL";
	private static final String ALERT_MESSAGE_ACCEPT_PAYMENT = "ACCEPT";
	private static final String ALERT_MESSAGE_SEND_PAYMENT = "SEND";
	private static final String ALERT_MESSAGE_CANCEL_SEND_PAYMENT = "CANCEL_SEND";
	private static final String ALERT_MESSAGE_COLLECTIVE_PAYMENT = "COLLECTIVE";
	private static final String ALERT_MESSAGE_CANCEL_COLLECTIVE_PAYMENT = "CANCEL_COLLECTIVE";
	private static final String ALERT_MESSAGE_EXPORT_PAYMENT = "EXPORT";
	private static final String ALERT_MESSAGE_EXPORT_REMARK = "EXPORT_RE";
	
	private static final String BEAN_SEMMEL008 = "semmel008Bean";
	private static final SimpleDateFormat exportFormat = new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));
	private static final DecimalFormat currencyFormat = new DecimalFormat("###,###,###,##0.00");
	
	private static final String EXPENSE_TYPE_EL_BILL = "EL_BILL";
	private static final String EXPENSE_TYPE_EL_POSTPAID = "EL_POSTPAID";
	private static final String EXPENSE_TYPE_EL_DEBIT = "EL_DEBIT";
	private static final String EXPENSE_TYPE_EL_CREDIT = "EL_CREDIT";
	private static final String EXPENSE_TYPE_EL_TEMP = "EL_TEMP";
	private static final String EXPENSE_TYPE_PR_POSTPAID = "PR_POSTPAID";
	private static final String EXPENSE_TYPE_PR_PREPAID = "PR_PREPAID";
	private static final String EXPENSE_TYPE_DEPOSIT = "DEPOSIT";
	private static final String EXPENSE_TYPE_FEE_SURVEY = "FEE_SURVEY";
	private static final String EXPENSE_TYPE_FEE_METER = "FEE_METER";
	private static final String EXPENSE_TYPE_FEE_EXPAND = "FEE_EXPAND";
	private static final String EXPENSE_TYPE_FEE_OTHER = "FEE_OTHER";
	private static final String EXPENSE_TYPE_FEE = "FEE";
	private static final String EXPENSE_TYPE_PR_DEBIT = "PR_DEBIT";
	private static final String EXPENSE_TYPE_PR_CREDIT = "PR_CREDIT";
	
	private static final String PAYMENT_STATUS_01 = "01";
	private static final String PAYMENT_STATUS_02 = "02";
	private static final String PAYMENT_STATUS_03 = "03";
	private static final String PAYMENT_STATUS_04 = "04";
	
	private static final String PAYMENT_METHOD_CHQ = "01";
	private static final String PAYMENT_METHOD_TRANSFER = "02";
	private static final String PAYMENT_METHOD_PETTY_CASH = "03";
	private static final String PAYMENT_SPECIAL_FLAG_Y = "Y";
	
	
	private static final String EL_CANCEL_PAYMENT_STATUS = "EL_CANCEL_PAYMENT_STATUS";
	private static final String EL_SENT_PAYMENT_STATUS = "EL_SENT_PAYMENT_STATUS";
	private static final String EL_EXPORT_PAYMENT_STATUS = "EL_EXPORT_PAYMENT_STATUS";
	private static final String EL_CANCEL_COLLECT_PAYMENT_STATUS = "EL_CANCEL_COLLECT_PAYMENT_STATUS";
	private static final String EL_COLLECT_PAYMENT_STATUS= "EL_COLLECT_PAYMENT_STATUS";
	private static final String EL_APPROVE_PAYMENT_STATUS = "EL_APPROVE_PAYMENT_STATUS";
	private static final String EL_REJECT_PAYMENT_STATUS = "EL_REJECT_PAYMENT_STATUS";
	private static final String CR_PAYIN_FLAG_Y = "Y";
	private static final String EXPENSE_TYP_PR_CREDIT = "PR_CREDIT";
	private static final String EXPENSE_TYP_EL_CREDIT = "EL_CREDIT";
	
	//update by new 26/11/2014
	private SEMMEL008Bean semmel008Bean;
	
	public void setSemmel008Bean(SEMMEL008Bean semmel008Bean) {
		this.semmel008Bean = semmel008Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmel008Bean", semmel008Bean);
	}

	private PopupUploadFilePictureBean popupUploadFilePictureBean;

	public void setPopupUploadFilePictureBean(PopupUploadFilePictureBean popupUploadFilePictureBean) {
		this.popupUploadFilePictureBean = popupUploadFilePictureBean;
		getFacesUtils().setSessionMapValue("popupUploadFilePictureBean", popupUploadFilePictureBean);
	}		
	
	// --- override ---
	@Override
	public void init() {
		
		SEMMEL008Bean semmel008Bean = getSEMMEL008Bean();
		
		semmel008Bean.setSearchCriteria(new Payment());
		semmel008Bean.setSiteType(false);
		semmel008Bean.setExpReportList(new ArrayList<Mel008ReportSP>());
		semmel008Bean.setElCondSubTypeList(getEmptyDropDown()); 
		semmel008Bean.setRenderedOnToDoList(false);
		
		// prepare payment status count
		try{
			
			setPaymentStatusCount(semmel008Bean);
			
		}catch(Exception e){
			
			e.printStackTrace();
			addMessageError("EL0000", "SEMMEL008");
		}
		
		// prepare companyList
		semmel008Bean.setCompanyList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_COMPANY.name));
		
		// prepare electricUseTypeList
		List<SelectItem> electricUseTypeList = LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name);
		for(int i=electricUseTypeList.size()-1;i>=0;i--){
			
			SelectItem selItem = electricUseTypeList.get(i);
			if(selItem.getDescription() != null && selItem.getDescription().indexOf('4') < 0){
				
				electricUseTypeList.remove(i);
			}
		}
		semmel008Bean.setElectricUseTypeList(electricUseTypeList);
		
		// prepare regionList
		semmel008Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
		
		// prepare expenseTypeList
		List<SelectItem> expenseTypeList = LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name);
		for(int i=expenseTypeList.size()-1;i>=0;i--){
			
			SelectItem selItem = expenseTypeList.get(i);
			if(i > 0 && (selItem.getDescription() == null || selItem.getDescription().indexOf('1') < 0)){
				
				expenseTypeList.remove(i);
			}
		}
		semmel008Bean.setExpenseTypeList(expenseTypeList);
		
		// prepare paymentStatusList
		semmel008Bean.setPaymentStatusList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_STATUS.name));
		
		// prepare paymentTypeList
		semmel008Bean.setPaymentTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_TYPE.name));
		
		// prepare paymentMethodList
		semmel008Bean.setPaymentMethodList(new ArrayList<SelectItem>());
		
		// prepare bankNameList
		semmel008Bean.setBankNameList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_BG_BANK.name));
		
		semmel008Bean.setOrderByList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ORDER_BY.name));
		
		semmel008Bean.setElCondSubTypeList(getLovItemsByType(ELovType.T_SA_EL_COND_SUB_TYPE.name)); 
		semmel008Bean.setServiceList(getLovItemsByType(ELovType.T_CT_SERVICE.name));

		PopupUploadFilePictureBean uploadBean = new PopupUploadFilePictureBean();
		uploadBean.setModuleList(new ArrayList<SelectItem>());
		uploadBean.setSubModuleList(new ArrayList<SelectItem>());
		setPopupUploadFilePictureBean(uploadBean);
	}

	@Override
	public boolean validate() {
		
		return false;
	}

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		
		boolean flag = false;
		
		try{
			
			if(methodWithNavi.equals("doSearch")) return doSearch();
			else if(methodWithNavi.equals("doClear")) return doClear();
			else if(methodWithNavi.equals("doSendSMS")) return doSendSMS();
			else if(methodWithNavi.equals("doSendEmail")) return doSendEmail();
			else if(methodWithNavi.equals("doSendSMSOS")) return doSendSMSOS();
			else if(methodWithNavi.equals("doSendEmailOS")) return doSendEmailOS();
			else if(methodWithNavi.equals("doOpenAlertMessageFlag")) return doOpenAlertMessageFlag();
			else if(methodWithNavi.equals("doChoseMethod")) return doChoseMethod();
			else if(methodWithNavi.equals("doExportLetter")) return doExportLetter();
			else if(methodWithNavi.equals("doRunExportCheque")) return doRunExportCheque();
			else if(methodWithNavi.equals("doInitialForSearchElectrical")) return doInitialForSearchElectrical();
		}catch(Exception e){
			
			e.printStackTrace();
			
			addMessageError("EL0000", "SEMMEL008");
			
			flag = false;
		}
		
		return flag;
	}
	
	private boolean doChoseMethod() {
		String paramFrom = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("paramFrom");
		if(StringUtils.equalsIgnoreCase(paramFrom, "SAVECANCEL")){
			doSaveCancelPayment();
		}
		return false;
	}

	@Override
	public void clearAllSessionNotUsed() {
		
		super.clearAllSessionNotUsed();
		
		// for initial method
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(BEAN_SEMMEL008);
	}
	
	@Override
	public void clearSessionNotUsed() {
		
		// for actionWithNavi method
	}
	
	// --- public ---
	public void doChangeCompany(){
		
		SEMMEL008Bean semmel008Bean = getSEMMEL008Bean();
		
		Payment searchCriteria = semmel008Bean.getSearchCriteria();
		
		semmel008Bean.setCompanyBigLabel(searchCriteria.getCompany());
	}
	
	public void selectAllRow(){
		
		SEMMEL008Bean semmel008Bean = getSEMMEL008Bean();
		
		boolean chkAll = semmel008Bean.isChkSelAll();
		
		List<PaymentWrapper> paymentWrapperList = semmel008Bean.getPaymentWrapperList();
		if(paymentWrapperList != null){
			
			for(PaymentWrapper wrapper : paymentWrapperList){
				
				wrapper.setSelected(chkAll);
			}
			
			if(paymentWrapperList.size() > 0 && chkAll){
				
				semmel008Bean.setCommandButtonEnable(true);
				
				return;
			}
		}
		
		semmel008Bean.setCommandButtonEnable(false);
	}
	
	public void selectRow(){
		
		SEMMEL008Bean semmel008Bean = getSEMMEL008Bean();
		
		List<PaymentWrapper> paymentWrapperList = semmel008Bean.getPaymentWrapperList();
		if(paymentWrapperList != null){
			
			for(PaymentWrapper wrapper : paymentWrapperList){
				
				if(wrapper.isSelected()){
					
					semmel008Bean.setCommandButtonEnable(true);
					
					return;
					
				}else{
					
					semmel008Bean.setChkSelAll(false);
				}
			}
		}
		
		semmel008Bean.setCommandButtonEnable(false);
	}
	
	public void doSelectRow(){
		
		String row = (String)getFacesUtils().getRequestParameter("row");
		
		if(row != null){
			
			int rowInt = Integer.parseInt(row);
			
			List<PaymentWrapper> paymentWrapperList = getSEMMEL008Bean().getPaymentWrapperList();
			
			for(PaymentWrapper wrapper : paymentWrapperList){
				if(wrapper.isSelected())
					wrapper.setRowSelected(true);
				else
					wrapper.setRowSelected(false);
			}
			
//			paymentWrapperList.get(rowInt).setRowSelected(true);
		}
	}
	
	public void doOpenExpensePopup1(){
		
		SEMMEL008Bean semmel008Bean = getSEMMEL008Bean();
		
		semmel008Bean.setDisablePaymentMethodList(false);
		semmel008Bean.setTransferRequired(false);
		
		int row = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("row"));
		
		PaymentWrapper wrapper = semmel008Bean.getPaymentWrapperList().get(row);
		
		semmel008Bean.setSelectedWrapper(wrapper);
		
		// get payments
		try{
			
			IPaymentService paymentService = (IPaymentService)getBean("paymentService");
			
			List<Payment> paymentList = wrapper.getPaymentList();
			List<Payment> selectedPayments = new ArrayList<Payment>();
			for(Payment payment : paymentList){
				
				Payment dbPayment = paymentService.queryPaymentByRowId(payment.getRowId());
				
				selectedPayments.add(dbPayment);
				
				semmel008Bean.setSelectedPayment(dbPayment);
			}
			
			// store default bankName and bankAccount
			Payment selectedPayment = semmel008Bean.getSelectedPayment();
			semmel008Bean.setTmpBankName(selectedPayment.getBankName());
			semmel008Bean.setTmpBankAccount(selectedPayment.getBankAccount());
			
			doChangePaymentType();
			
			semmel008Bean.setSelectedPayments(selectedPayments);
			
		}catch(Exception e){
			
			e.printStackTrace();
			
			addMessageError("EL0000", "SEMMEL008");
		}
	}
	
	public void doOpenExpensePopup2(){
		
		SEMMEL008Bean semmel008Bean = getSEMMEL008Bean();
		
		int row = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("row"));
		
		PaymentWrapper wrapper = semmel008Bean.getPaymentWrapperList().get(row);
		
		semmel008Bean.setSelectedWrapper(wrapper);
		
		// get payments
		try{
			
			IPaymentService paymentService = (IPaymentService)getBean("paymentService");
			
			List<Payment> paymentList = wrapper.getPaymentList();
			List<Payment> selectedPayments = new ArrayList<Payment>();
			for(Payment payment : paymentList){
				
				Payment dbPayment = paymentService.queryPaymentByRowId(payment.getRowId());
				
				selectedPayments.add(dbPayment);
				
				if(semmel008Bean.getSelectedPayment() == null) semmel008Bean.setSelectedPayment(dbPayment);
			}
			
			semmel008Bean.setSelectedPayments(selectedPayments);
			
		}catch(Exception e){
			
			e.printStackTrace();
			
			addMessageError("EL0000", "SEMMEL008");
		}
	}
	
	public void doChangePaymentType(){
		
		SEMMEL008Bean semmel008Bean = getSEMMEL008Bean();
		
		Payment payment = semmel008Bean.getSelectedPayment();
		
		if(payment.getPaymentMethod() != null){
			
			if(payment.getPaymentType().equals(PAYMENT_METHOD_CHQ)){
				
				List<SelectItem> paymentMethodList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
				for(int i=paymentMethodList.size()-1;i>=0;i--){
					
					SelectItem selItem = paymentMethodList.get(i);
					if(selItem.getDescription() != null && selItem.getDescription().indexOf('U') > -1){
						
						paymentMethodList.remove(i);
					}
				}
				
				semmel008Bean.setPaymentMethodList(paymentMethodList);
				semmel008Bean.setDisablePaymentMethodList(false);
				semmel008Bean.setTransferRequired(false);
				semmel008Bean.setChqRequired(true);
				
				payment.setBankName(null);
				payment.setBankAccount(null);
				payment.setTransferDt(null);
				
			}else if(payment.getPaymentType().equals(PAYMENT_METHOD_TRANSFER)){
				
				List<SelectItem> paymentMethodList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
				for(int i=paymentMethodList.size()-1;i>=0;i--){
					
					SelectItem selItem = paymentMethodList.get(i);
					if(selItem.getDescription() != null && selItem.getDescription().indexOf('U') < 0){
						
						paymentMethodList.remove(i);
					}
				}
				
				semmel008Bean.setPaymentMethodList(paymentMethodList);
				semmel008Bean.setDisablePaymentMethodList(true);
				semmel008Bean.setTransferRequired(true);
				semmel008Bean.setChqRequired(false);
				
				payment.setPaymentMethod((String)paymentMethodList.get(paymentMethodList.size()-1).getValue());
				payment.setChqPostingDt(null);
				payment.setChqReceivedDt(null);
				
				// get bankAccount and bankName from stored location
				payment.setBankName(semmel008Bean.getTmpBankName());
				payment.setBankAccount(semmel008Bean.getTmpBankAccount());
				
				// default bankName and bankAccount
//				try{
//					
//					payment.setBankName(null);
//					payment.setBankAccount(null);
//					setDefaultBankNameAndBankAccount(payment);
//					
//				}catch(Exception e){
//					
//					e.printStackTrace();
//					
//					addMessageError("EL0000", "SEMMEL008");
//				}
			}
		}
	}
	
	public void doSaveExpense1(){
		
		SEMMEL008Bean semmel008Bean = getSEMMEL008Bean();
		
		if(!doValidateSaveExpense1(semmel008Bean)){
			
			return;
		}
		
		Payment selectedPayment = semmel008Bean.getSelectedPayment();
		List<Payment> selectedPayments = semmel008Bean.getSelectedPayments();
		
		try{
			
			SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
			
			// prepare selectedPayments
			for(Payment payment : selectedPayments){
				
				payment.setPaymentType(selectedPayment.getPaymentType());
				payment.setPaymentMethod(selectedPayment.getPaymentMethod());
				payment.setBankName(selectedPayment.getBankName());
				payment.setBankAccount(selectedPayment.getBankAccount());
				payment.setChqPostingDt(selectedPayment.getChqPostingDt());
				payment.setChqReceivedDt(selectedPayment.getChqReceivedDt());
				payment.setTransferDt(selectedPayment.getTransferDt());
				payment.setRemark(selectedPayment.getRemark());
				payment.setUpdateBy(ssoBean.getUserName());
				payment.setCurrentUser(ssoBean.getUserName());
				payment.setUpdateDt(Calendar.getInstance().getTime());
			}
			
			// call service
			IPaymentService paymentService = (IPaymentService)getBean("paymentService");
			
			paymentService.savePayment(selectedPayments);
			
			addMessageInfo("M0001");
			
		}catch(Exception e){
			
			e.printStackTrace();
			
			addMessageError("EL0000", "SEMMEL008");
		}
	}
	
	public void doSaveExpense2(){
		
		SEMMEL008Bean semmel008Bean = getSEMMEL008Bean();
		
		if(!doValidateSaveExpense2(semmel008Bean)){
			
			return;
		}
		
		Payment selectedPayment = semmel008Bean.getSelectedPayment();
		List<Payment> selectedPayments = semmel008Bean.getSelectedPayments();
		
		try{
			
			SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
			
			// prepare selectedPayments
			for(Payment payment : selectedPayments){
				
				if(selectedPayment.isCrPayInFlagBoolean()){
					
					payment.setCrBankName(null);
					payment.setCrPayInDt(null);
					
				}else{
					
					payment.setCrBankName(selectedPayment.getCrBankName());
					payment.setCrPayInDt(selectedPayment.getCrPayInDt());
				}
				
				payment.setCrPayInFlagBoolean(selectedPayment.isCrPayInFlagBoolean());
				payment.setUpdateBy(ssoBean.getUserName());
				payment.setCurrentUser(ssoBean.getUserName());
				payment.setUpdateDt(Calendar.getInstance().getTime());
			}
			
			// call service
			IPaymentService paymentService = (IPaymentService)getBean("paymentService");
			
			paymentService.savePayment(selectedPayments);
			
			addMessageInfo("M0001");
			
		}catch(Exception e){
			
			e.printStackTrace();
			
			addMessageError("EL0000", "SEMMEL008");
		}
	}
	
	public void doOpenAlertMessage(){
		
		SEMMEL008Bean semmel008Bean = getSEMMEL008Bean();
		
		String msgFor = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("msgFor");
		String wrapperRow = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("wrapperRow");
		String paymentRow = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("paymentRow");
		semmel008Bean.setStyleClassName("ms7");
		try{
		
			LOG.debug("WT### doOpenAlertMessage for ="+msgFor);
			// find selected target
			if(wrapperRow != null){
				
				PaymentWrapper selectedWrapper = semmel008Bean.getPaymentWrapperList().get(Integer.parseInt(wrapperRow));
				
				semmel008Bean.setSelectedWrapper(selectedWrapper);
				
				Payment selectedPayment = selectedWrapper.getPaymentList().get(Integer.parseInt(paymentRow));
				
				semmel008Bean.setSelectedPayment(selectedPayment);
				
			}
			else{
				if(!msgFor.equals(ALERT_MESSAGE_SEND_PAYMENT)&&!msgFor.equals(ALERT_MESSAGE_CANCEL_SEND_PAYMENT)&&!msgFor.equals(ALERT_MESSAGE_COLLECTIVE_PAYMENT)
						&&!msgFor.equals(ALERT_MESSAGE_CANCEL_COLLECTIVE_PAYMENT) && !msgFor.equals(ALERT_MESSAGE_CANCEL_PAYMENT) && !msgFor.equals(ALERT_MESSAGE_ACCEPT_PAYMENT)){
					semmel008Bean.setSelectedPayments(getSelectedPaymentFromDatabase(semmel008Bean));
				}
			}
			
			// disappear all button
			setAlertMessageButtonDisappear(semmel008Bean);
			
			//Clear Message2
			semmel008Bean.setMessage2("");
			
			// prepare message and buttons
			if(msgFor.equals(ALERT_MESSAGE_EDIT)){
				LOG.debug("WT### ALERT_MESSAGE_EDIT=");
				doInitEditPopup(semmel008Bean);
				
			}else if(msgFor.equals(ALERT_MESSAGE_CANCEL_PAYMENT)){
				LOG.debug("WT### ALERT_MESSAGE_CANCEL_PAYMENT)");
				doInitCancelPayment(semmel008Bean);
				
			}else if(msgFor.equals(ALERT_MESSAGE_ACCEPT_PAYMENT)){
				LOG.debug("WT### ALERT_MESSAGE_ACCEPT_PAYMENT)");
				doAcceptPayment(semmel008Bean);
				
			}else if(msgFor.equals(ALERT_MESSAGE_SEND_PAYMENT)){
				LOG.debug("WT### ALERT_MESSAGE_SEND_PAYMENT)");
				doSend(semmel008Bean);
			}else if(msgFor.equals(ALERT_MESSAGE_CANCEL_SEND_PAYMENT)){
				LOG.debug("WT### ALERT_MESSAGE_CANCEL_SEND_PAYMENT)");
				doCancelSend(semmel008Bean);
			}else if(msgFor.equals(ALERT_MESSAGE_COLLECTIVE_PAYMENT)){
				
				LOG.debug("WT### ALERT_MESSAGE_COLLECTIVE_PAYMENT)");
				doCollective(semmel008Bean);  
				
			}else if(msgFor.equals(ALERT_MESSAGE_CANCEL_COLLECTIVE_PAYMENT)){
				
				LOG.debug("WT### ALERT_MESSAGE_CANCEL_COLLECTIVE_PAYMENT");
				
				doCancelCollective(semmel008Bean);
				
				
			}else if(msgFor.equals(ALERT_MESSAGE_EXPORT_PAYMENT)){
			
				LOG.debug("WT### ALERT_MESSAGE_EXPORT_PAYMENT");
				
//				List<Payment> selectedPayments = getSelectedPaymentFromDatabase(semmel008Bean);
				List<Payment> selectedPayments = new ArrayList<Payment>();
				if(semmel008Bean.getPaymentWrapperList()!=null && semmel008Bean.getPaymentWrapperList().size()>0){
					for(PaymentWrapper wrapper : semmel008Bean.getPaymentWrapperList()){
						if(wrapper.isSelected()){
							List<Payment> paymentList = wrapper.getPaymentList();
							for(Payment payment : paymentList){
								selectedPayments.add(payment);
							}
						}
					}
				}
				semmel008Bean.setSelectedPayments(selectedPayments);
				
				
				//WT###Edit 20110121 Start
				String cancelPaymentStatus = ParameterConfigUtil.getInstance().getConfigByCode(EL_EXPORT_PAYMENT_STATUS);
				String[] cancelPaymentStatusArr = cancelPaymentStatus.split("\\|");
				LOG.debug("WT### cancelPaymentStatus="+cancelPaymentStatus);
				LOG.debug("wT### cancelPaymentStatusArr length="+cancelPaymentStatusArr.length);
				
				boolean isError = true;
				String firstBatchNo = selectedPayments.get(0).getBatchNo();
				// validate 
				for(Payment payment : selectedPayments){
					
					//if(!(payment.getPaymentStatus().equals(PAYMENT_STATUS_02) || payment.getPaymentStatus().equals(PAYMENT_STATUS_03))){
					if(payment.getPaymentStatus()!=null){
						
						for(int i=0; i<cancelPaymentStatusArr.length; i++){
							if(payment.getPaymentStatus().equals(cancelPaymentStatusArr[i])){
								isError = false;
							}
						}
						
						if(isError){
							semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0027"), ""));
							semmel008Bean.setVisibleOkBtn(true);
							
							return;
						}						
					}
					
					if(payment.getBatchNo()!=null){
						if(!payment.getBatchNo().equals(firstBatchNo)){
							semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0027"), ""));
							semmel008Bean.setVisibleOkBtn(true);
							
							return;
						}
					}
				}
				//WT###Edit 20110121 End
				
				// generate batchNo
				ParameterConfig plName = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_GEN_BATCH_B001");
				ParameterConfig param1 = ParameterConfigUtil.getInstance().getparameterByCode("EL_PARAM_BATCH_NO1");
				ParameterConfig param2 = ParameterConfigUtil.getInstance().getparameterByCode("EL_PARAM_BATCH_NO2");
				
				IPaymentService paymentService = (IPaymentService)getBean("paymentService");
				//WT###Edit 20110107 Start
				//String []result = paymentService.queryBatchNoForExport(plName.getParamValue(), param1.getParamValue(), param2.getParamValue());
//				String batchNo = result[0];
//				String errorCode = result[1];
//				String errorDesc = result[2];
				//Object []result = paymentService.queryBatchNoForExport(plName.getParamValue(), param1.getParamValue(), param2.getParamValue());
//				String batchNo = (String)result[0];
//				String errorCode = (String)result[1];
//				String errorDesc = (String)result[2];
				//WT###Edit 20110107 End				
				//WT###Edit 20110418 Start
				/*if(errorCode == null || !errorCode.trim().equals("00")){
					
					String errorMessage = MSGCacheUtil.getInstance().getMessageByCode("EL0027")+" [ERROR : "+errorDesc+"]";
					
					semmel008Bean.setMessage(SEMDataUtility.buildMessage(errorMessage, ""));
					semmel008Bean.setVisibleOkBtn(true);
					
					return;
				}	*/		
				String batchNo = selectedPayments.get(0).getBatchNo();
				//WT###Edit 20110418 End
				semmel008Bean.setExportBatchNo(batchNo);
				semmel008Bean.setMessage(getMessage("msg.confirm.export"));
				semmel008Bean.setVisibleExportBtn(true);
				semmel008Bean.setVisibleCancelExportBtn(true);
				semmel008Bean.setChkSelAll(false);
				
			}else if(msgFor.equals(ALERT_MESSAGE_EXPORT_REMARK)){
			
				LOG.debug("WT### ALERT_MESSAGE_EXPORT_REMARK");
				
//				List<Payment> selectedPayments = getSelectedPaymentFromDatabase(semmel008Bean);
				List<Payment> selectedPayments = new ArrayList<Payment>();
				if(semmel008Bean.getPaymentWrapperList()!=null && semmel008Bean.getPaymentWrapperList().size()>0){
					for(PaymentWrapper wrapper : semmel008Bean.getPaymentWrapperList()){
						if(wrapper.isSelected()){
							List<Payment> paymentList = wrapper.getPaymentList();
							for(Payment payment : paymentList){
								selectedPayments.add(payment);
							}
						}
					}
				}
				semmel008Bean.setSelectedPayments(selectedPayments);
				
				
				//WT###Edit 20110121 Start
				String cancelPaymentStatus = ParameterConfigUtil.getInstance().getConfigByCode(EL_EXPORT_PAYMENT_STATUS);
				String[] cancelPaymentStatusArr = cancelPaymentStatus.split("\\|");
				LOG.debug("WT### cancelPaymentStatus="+cancelPaymentStatus);
				LOG.debug("wT### cancelPaymentStatusArr length="+cancelPaymentStatusArr.length);
				
				boolean isError = true;
				String firstBatchNo = selectedPayments.get(0).getBatchNo();
				// validate 
				for(Payment payment : selectedPayments){
					
					//if(!(payment.getPaymentStatus().equals(PAYMENT_STATUS_02) || payment.getPaymentStatus().equals(PAYMENT_STATUS_03))){
					if(payment.getPaymentStatus()!=null){
						
						for(int i=0; i<cancelPaymentStatusArr.length; i++){
							if(payment.getPaymentStatus().equals(cancelPaymentStatusArr[i])){
								isError = false;
							}
						}
						
						if(isError){
							semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0027"), ""));
							semmel008Bean.setVisibleOkBtn(true);
							
							return;
						}						
					}
					
					if(payment.getBatchNo()!=null){
						if(!payment.getBatchNo().equals(firstBatchNo)){
							semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0027"), ""));
							semmel008Bean.setVisibleOkBtn(true);
							
							return;
						}
					}
				}
				//WT###Edit 20110121 End
				
				// generate batchNo
				ParameterConfig plName = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_GEN_BATCH_B001");
				ParameterConfig param1 = ParameterConfigUtil.getInstance().getparameterByCode("EL_PARAM_BATCH_NO1");
				ParameterConfig param2 = ParameterConfigUtil.getInstance().getparameterByCode("EL_PARAM_BATCH_NO2");
				
				IPaymentService paymentService = (IPaymentService)getBean("paymentService");
				//WT###Edit 20110107 Start
				//String []result = paymentService.queryBatchNoForExport(plName.getParamValue(), param1.getParamValue(), param2.getParamValue());
//				String batchNo = result[0];
//				String errorCode = result[1];
//				String errorDesc = result[2];
				//Object []result = paymentService.queryBatchNoForExport(plName.getParamValue(), param1.getParamValue(), param2.getParamValue());
//				String batchNo = (String)result[0];
//				String errorCode = (String)result[1];
//				String errorDesc = (String)result[2];
				//WT###Edit 20110107 End				
				//WT###Edit 20110418 Start
				/*if(errorCode == null || !errorCode.trim().equals("00")){
					
					String errorMessage = MSGCacheUtil.getInstance().getMessageByCode("EL0027")+" [ERROR : "+errorDesc+"]";
					
					semmel008Bean.setMessage(SEMDataUtility.buildMessage(errorMessage, ""));
					semmel008Bean.setVisibleOkBtn(true);
					
					return;
				}	*/		
				String batchNo = selectedPayments.get(0).getBatchNo();
				//WT###Edit 20110418 End
				semmel008Bean.setExportBatchNo(batchNo);
				semmel008Bean.setMessage(getMessage("msg.confirm.export"));
				semmel008Bean.setVisibleExportRemarkBtn(true);
				semmel008Bean.setVisibleCancelExportRemarkBtn(true);
				semmel008Bean.setChkSelAll(false);
				
			}else{
				
				semmel008Bean.setMessage(null);
			}
		
		}catch(Exception e){
			
			e.printStackTrace();
			
			semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0000"), "SEMMEL008"));
			setAlertMessageButtonDisappear(semmel008Bean);
			semmel008Bean.setVisibleOkBtn(true);
		}
	}
	
	
	public boolean doOpenAlertMessageFlag(){
		boolean flag = false;
		
		SEMMEL008Bean semmel008Bean = getSEMMEL008Bean();
		
		String msgFor = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("msgFor");
		String wrapperRow = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("wrapperRow");
		String paymentRow = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("paymentRow");
		
		try{
		
			LOG.debug("WT### doOpenAlertMessage for ="+msgFor);
			// find selected target
			if(wrapperRow != null){
				
				PaymentWrapper selectedWrapper = semmel008Bean.getPaymentWrapperList().get(Integer.parseInt(wrapperRow));
				
				semmel008Bean.setSelectedWrapper(selectedWrapper);
				
				Payment selectedPayment = selectedWrapper.getPaymentList().get(Integer.parseInt(paymentRow));
				
				semmel008Bean.setSelectedPayment(selectedPayment);
				
			}else{
				
				semmel008Bean.setSelectedPayments(getSelectedPaymentFromDatabase(semmel008Bean));
			}
			
			// disappear all button
			setAlertMessageButtonDisappear(semmel008Bean);
			
			//Clear Message2
			semmel008Bean.setMessage2("");
			
			// prepare message and buttons
			if(msgFor.equals(ALERT_MESSAGE_EDIT)){
				LOG.debug("WT### ALERT_MESSAGE_EDIT=");
				doInitEditPopup(semmel008Bean);
				
			}else if(msgFor.equals(ALERT_MESSAGE_CANCEL_PAYMENT)){
				LOG.debug("WT### ALERT_MESSAGE_CANCEL_PAYMENT)");
				doInitCancelPayment(semmel008Bean);
				
			}else if(msgFor.equals(ALERT_MESSAGE_ACCEPT_PAYMENT)){
				LOG.debug("WT### ALERT_MESSAGE_ACCEPT_PAYMENT)");
				doAcceptPayment(semmel008Bean);
				
			}else if(msgFor.equals(ALERT_MESSAGE_SEND_PAYMENT)){
				LOG.debug("WT### ALERT_MESSAGE_SEND_PAYMENT)");
				doSend(semmel008Bean);
			}else if(msgFor.equals(ALERT_MESSAGE_CANCEL_SEND_PAYMENT)){
				LOG.debug("WT### ALERT_MESSAGE_CANCEL_SEND_PAYMENT)");
				doCancelSend(semmel008Bean);
			}else if(msgFor.equals(ALERT_MESSAGE_COLLECTIVE_PAYMENT)){
				
				LOG.debug("WT### ALERT_MESSAGE_COLLECTIVE_PAYMENT)");
				doCollective(semmel008Bean);  
				
			}else if(msgFor.equals(ALERT_MESSAGE_CANCEL_COLLECTIVE_PAYMENT)){
				
				LOG.debug("WT### ALERT_MESSAGE_CANCEL_COLLECTIVE_PAYMENT");
				
				doCancelCollective(semmel008Bean);
				
				
			}else if(msgFor.equals(ALERT_MESSAGE_EXPORT_PAYMENT)){
			
				LOG.debug("WT### ALERT_MESSAGE_EXPORT_PAYMENT");
				
				List<Payment> selectedPayments = getSelectedPaymentFromDatabase(semmel008Bean);
				//WT###Edit 20110121 Start
				String cancelPaymentStatus = ParameterConfigUtil.getInstance().getConfigByCode(EL_EXPORT_PAYMENT_STATUS);
				String[] cancelPaymentStatusArr = cancelPaymentStatus.split("\\|");
				LOG.debug("WT### cancelPaymentStatus="+cancelPaymentStatus);
				LOG.debug("wT### cancelPaymentStatusArr length="+cancelPaymentStatusArr.length);
				
				boolean isError = true;
				String firstBatchNo = selectedPayments.get(0).getBatchNo();
				// validate 
				for(Payment payment : selectedPayments){
					
					//if(!(payment.getPaymentStatus().equals(PAYMENT_STATUS_02) || payment.getPaymentStatus().equals(PAYMENT_STATUS_03))){
					if(payment.getPaymentStatus()!=null){
						
						for(int i=0; i<cancelPaymentStatusArr.length; i++){
							if(payment.getPaymentStatus().equals(cancelPaymentStatusArr[i])){
								isError = false;
							}
						}
						
						if(isError){
							semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0027"), ""));
							semmel008Bean.setVisibleOkBtn(true);
							
							return flag;
						}						
					}
					
					if(payment.getBatchNo()!=null){
						if(!payment.getBatchNo().equals(firstBatchNo)){
							semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0027"), ""));
							semmel008Bean.setVisibleOkBtn(true);
							
							return flag;
						}
					}
				}
				//WT###Edit 20110121 End
				
				// generate batchNo
				ParameterConfig plName = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_GEN_BATCH_B001");
				ParameterConfig param1 = ParameterConfigUtil.getInstance().getparameterByCode("EL_PARAM_BATCH_NO1");
				ParameterConfig param2 = ParameterConfigUtil.getInstance().getparameterByCode("EL_PARAM_BATCH_NO2");
				
				IPaymentService paymentService = (IPaymentService)getBean("paymentService");
				//WT###Edit 20110107 Start
				//String []result = paymentService.queryBatchNoForExport(plName.getParamValue(), param1.getParamValue(), param2.getParamValue());
//				String batchNo = result[0];
//				String errorCode = result[1];
//				String errorDesc = result[2];
				//Object []result = paymentService.queryBatchNoForExport(plName.getParamValue(), param1.getParamValue(), param2.getParamValue());
//				String batchNo = (String)result[0];
//				String errorCode = (String)result[1];
//				String errorDesc = (String)result[2];
				//WT###Edit 20110107 End				
				//WT###Edit 20110418 Start
				/*if(errorCode == null || !errorCode.trim().equals("00")){
					
					String errorMessage = MSGCacheUtil.getInstance().getMessageByCode("EL0027")+" [ERROR : "+errorDesc+"]";
					
					semmel008Bean.setMessage(SEMDataUtility.buildMessage(errorMessage, ""));
					semmel008Bean.setVisibleOkBtn(true);
					
					return;
				}	*/		
				String batchNo = selectedPayments.get(0).getBatchNo();
				//WT###Edit 20110418 End
				semmel008Bean.setExportBatchNo(batchNo);
				semmel008Bean.setMessage(getMessage("msg.confirm.export"));
				semmel008Bean.setVisibleExportBtn(true);
				semmel008Bean.setVisibleCancelExportBtn(true);
				semmel008Bean.setChkSelAll(false);
				
			}else{
				
				semmel008Bean.setMessage(null);
			}
		
		}catch(Exception e){
			
			e.printStackTrace();
			
			semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0000"), "SEMMEL008"));
			setAlertMessageButtonDisappear(semmel008Bean);
			semmel008Bean.setVisibleOkBtn(true);
		}
		return flag;
	}
	
	public void doSaveCancelPayment(){
		
		SEMMEL008Bean semmel008Bean = getSEMMEL008Bean();
		
		List<Payment> selectedPayments = semmel008Bean.getSelectedPayments();
		
		if(selectedPayments != null){
			
			// update payment
			try{
				
				SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
				//WT###Add 20110113 Start
				String plDisbursedName = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_PG_DISBURSED_D003);
				IPaymentService paymentService = (IPaymentService)getBean("paymentService");
				//WT###Add 20110113 End
				for(Payment payment : selectedPayments){
					
					//WT###Add 20110113 Start
					/*payment.setRecordStatus(SEMMEL001Util.N);
					payment.setUpdateBy(ssoBean.getUserName());
					payment.setUpdateDt(Calendar.getInstance().getTime());*/
					//WT###Add 20110113 End
					paymentService.disbursedWithPL(plDisbursedName, payment.getRowId(), ssoBean.getUserName());
					
				}
				
				/* WT###Comment 20110113 
				 * IPaymentService paymentService = (IPaymentService)getBean("paymentService");
				paymentService.savePayment(selectedPayments);*/
			
				// update resultTable
				doSearch();
				
			}catch(Exception e){
				
				e.printStackTrace();
				
				addMessageError("EL0000", "SEMMEL008");
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public String export(){
		
		LOG.info("export Excel()");
		SEMMEL008Bean semmel008Bean = getSEMMEL008Bean();
		
		try{
			
			List<Payment> selectedPayments = getSelectedPaymentFromDatabase(semmel008Bean);
			
			String batchNo = semmel008Bean.getExportBatchNo();
			Date sysDate = new Date();
			//String year = ELUtils.getYearNumberByDate(sysDate, "th");
			//String month = ELUtils.getMonthNumberByDate(sysDate);
			//String date = ELUtils.getDateByMonthandYear(month, year)ByMonthandYear(month, year)MonthNumberByDate(sysDate);
			//String DATE_FORMAT = "yyyyMMdd";
			String DATE_FORMAT = "dd/MM/yyyy";
		    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT,DateUtil.thLocale);
		    Calendar c1 = Calendar.getInstance(); // today
		    //String fileName = semmel008Bean.getCompanyBigLabel()+"_"+sdf.format(c1.getTime())+"_"+ batchNo+".xls";
		    String company = "AIS";
		    if(semmel008Bean.getCompanyBigLabel()!=null && !"".equals(semmel008Bean.getCompanyBigLabel())){
		    	company = semmel008Bean.getCompanyBigLabel();
		    }else if(selectedPayments.size() > 0){
		    	if(selectedPayments.get(0).getCompany()!=null && !"".equals(selectedPayments.get(0).getCompany())){
		    		company = selectedPayments.get(0).getCompany();
		    	}	
		    }
		    String fileName = company+"_"+SEMDataUtility.getCurrentDateDefaultForFileName()+"_"+ batchNo+".xls";		    
			LOG.info("fileName():" +fileName);
			// prepare excel
			HSSFWorkbook workbook = new HSSFWorkbook(this.getClass().getResourceAsStream("/resources/el/Export_Payment.xls"));
			HSSFCellStyle cellStyle = workbook.createCellStyle();
			Font angsanaNew = workbook.createFont();
			angsanaNew.setFontName("Angsana New");
			//angsanaNew.setFontHeight((short)14);
			angsanaNew.setFontHeightInPoints((short)14);
			cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
			cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
			cellStyle.setFont(angsanaNew);
			
			HSSFSheet worksheetAllChk = workbook.getSheetAt(0);
			HSSFSheet worksheetAllTrans = workbook.getSheetAt(1);
			HSSFSheet worksheetBillChk = workbook.getSheetAt(2);
			HSSFSheet worksheetBillTrans = workbook.getSheetAt(3);
			HSSFSheet worksheetAllPC = workbook.getSheetAt(4);			
			
			if(selectedPayments.size() > 0){
				
				// prepare map
				Map<String, String> expenseTypeMap = getExpenseTypeMap();
				Map<String, String> vatTypeMap = getVatTypeMap();
				Map<String, String> paymentTypeMap = getPaymentTypeMap();
				Map<String, String> paymentMethodMap = getPaymentMethodMap();
				
				HSSFRow rowAllChk = worksheetAllChk.getRow(0);
				HSSFRow rowAllTrans = worksheetAllTrans.getRow(0);
				HSSFRow rowAllPC = worksheetAllPC.getRow(0);
				HSSFRow rowBillChk = worksheetBillChk.getRow(0);
				HSSFRow rowBillTrans = worksheetBillTrans.getRow(0);		
				HSSFCell cell;
				
				/*rowAllChk.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.paymentDate")+" "+sdf.format(c1.getTime())));
				rowAllChk = worksheetAllChk.getRow(1);
				rowAllChk.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.company")+" "+company));
				rowAllChk = worksheetAllChk.getRow(2);
				rowAllChk.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.batchNo")+" "+batchNo));
				rowAllChk = worksheetAllChk.getRow(3);
				rowAllChk.getCell((short)3).setCellValue(new HSSFRichTextString(getMessage("label.paymentType")+" "+selectedPayments.get(0).getPaymentTypeTxt()));
				rowAllChk = worksheetAllChk.getRow(3);
				rowAllChk.getCell((short)2).setCellValue(new HSSFRichTextString(getMessage("label.paymentMethod")+" "+selectedPayments.get(0).getPaymentMethodTxt()));
				rowAllChk = worksheetAllChk.getRow(4);
				rowAllChk.getCell((short)2).setCellValue(new HSSFRichTextString(getMessage("label.chqReceivedDt")+" "+selectedPayments.get(0).getChqReceivedDtTH()));
				
				rowAllTrans.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.paymentDate")+" "+sdf.format(c1.getTime())));
				rowAllTrans = worksheetAllTrans.getRow(1);
				rowAllTrans.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.company")+" "+company));
				rowAllTrans = worksheetAllTrans.getRow(2);
				rowAllTrans.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.batchNo")+" "+batchNo));
				rowAllTrans = worksheetAllTrans.getRow(3);
				rowAllTrans.getCell((short)3).setCellValue(new HSSFRichTextString(getMessage("label.paymentType")+" "+selectedPayments.get(0).getPaymentTypeTxt()));
				rowAllTrans = worksheetAllTrans.getRow(3);
				rowAllTrans.getCell((short)2).setCellValue(new HSSFRichTextString(getMessage("label.paymentMethod")+" "+selectedPayments.get(0).getPaymentMethodTxt()));
				rowAllTrans = worksheetAllTrans.getRow(4);
				rowAllTrans.getCell((short)2).setCellValue(new HSSFRichTextString(getMessage("label.chqReceivedDt")+" "+selectedPayments.get(0).getTransferDtTH()));*/
				
				rowAllPC.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.paymentDate")+" "+sdf.format(c1.getTime())));
				rowAllPC = worksheetAllPC.getRow(1);
				rowAllPC.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.company")+" "+company));
				rowAllPC = worksheetAllPC.getRow(2);
				rowAllPC.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.batchNo")+" "+batchNo));
				rowAllPC = worksheetAllPC.getRow(3);
				rowAllPC.getCell((short)3).setCellValue(new HSSFRichTextString(getMessage("label.paymentType")+" "+selectedPayments.get(0).getPaymentTypeTxt()));
//				rowAllPC = worksheetAllPC.getRow(3);
//				rowAllPC.getCell((short)2).setCellValue(new HSSFRichTextString(getMessage("label.paymentMethod")+" "+selectedPayments.get(0).getPaymentMethodTxt()));
//				rowAllPC = worksheetAllPC.getRow(4);
//				rowAllPC.getCell((short)2).setCellValue(new HSSFRichTextString(getMessage("label.chqReceivedDt")+" "+selectedPayments.get(0).getTransferDtTH()));
				
				rowBillChk.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.paymentDate")+" "+sdf.format(c1.getTime())));
				rowBillChk = worksheetBillChk.getRow(1);
				rowBillChk.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.company")+" "+company));
				rowBillChk = worksheetBillChk.getRow(2);
				rowBillChk.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.batchNo")+" "+batchNo));
				
				/*rowBillTrans.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.paymentDate")+" "+sdf.format(c1.getTime())));	
				rowBillTrans = worksheetBillTrans.getRow(1);
				rowBillTrans.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.company")+" "+company));
				rowBillTrans = worksheetBillTrans.getRow(2);
				rowBillTrans.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.batchNo")+" "+batchNo));*/
				
				int indexAllChk = 6;
				int indexAllTrans = 6;
				int indexAllPC = 6;
				int indexBillChk = 6;
				int indexBillTrans = 6;
				
				int rowNoAllChk = 1;
				int rowNoAllTrans = 1;
				int rowNoAllPC = 1;
				int rowNoBillChk = 1;
				int rowNoBillTrans = 1;
				
				BigDecimal sumExcludeVatAmtAllChk = new BigDecimal("0");
				BigDecimal sumVatAmtAllChk = new BigDecimal("0");
				BigDecimal sumIncludeVatAmtAllChk = new BigDecimal("0");
				BigDecimal sumWHTAmtAllChk = new BigDecimal("0");
				
				BigDecimal sumExcludeVatAmtAllTrans = new BigDecimal("0");
				BigDecimal sumVatAmtAllTrans = new BigDecimal("0");
				BigDecimal sumIncludeVatAmtAllTrans = new BigDecimal("0");
				BigDecimal sumWHTAmtAllTrans = new BigDecimal("0");
				
				BigDecimal sumExcludeVatAmtAllPC = new BigDecimal("0");
				BigDecimal sumVatAmtAllPC = new BigDecimal("0");
				BigDecimal sumIncludeVatAmtAllPC = new BigDecimal("0");
				BigDecimal sumWHTAmtAllPC = new BigDecimal("0");
				
				BigDecimal sumExcludeVatAmtBillChk = new BigDecimal("0");
				BigDecimal sumVatAmtBillChk = new BigDecimal("0");
				BigDecimal sumIncludeVatAmtBillChk = new BigDecimal("0");
				BigDecimal sumWHTAmtBillChk = new BigDecimal("0");
				
				BigDecimal sumExcludeVatAmtBillTrans = new BigDecimal("0");
				BigDecimal sumVatAmtBillTrans = new BigDecimal("0");
				BigDecimal sumIncludeVatAmtBillTrans = new BigDecimal("0");
				BigDecimal sumWHTAmtBillTrans = new BigDecimal("0");
				
				String paymentTypeChq = "";
				String paymentMethodChq = "";
				String paymentChqReceivedDtTHChq = "";
				
				String paymentTypeTrans = "";
				String paymentMethodTrans = "";
				String paymentTransferDtTHTrans = "";
				
				String paymentTypeBillTrans = "";
				String paymentMethodBillTrans = "";
				String paymentTransferDtTHBillTrans = "";
				
				String paymentTypeBillChq = "";
				String paymentMethodBillChq = "";
				String paymentChqReceivedDtTHBillChq = "";
				
				String paymentTypePC = "";
				
				for(int i=0,j=selectedPayments.size();i<j;i++){
					
					Payment payment = selectedPayments.get(i);
					Set<PaymentDetail> paymentDetails = payment.getDetails();
					/*if(payment.getDetails()!=null){
						System.out.println("WT###Print payment.getDetails().size()="+payment.getDetails().size());
					}else{
						System.out.println("WT###Print no payment detail");
					}*/
					
					LOG.info("payment.getExpenseType():" +payment.getExpenseType());
					LOG.info("payment.getPaymentType():" +payment.getPaymentType());
					LOG.debug("paymentDetails:" +paymentDetails);
					if(paymentDetails==null){
						continue;
					}
					for(PaymentDetail objDetail : paymentDetails){
						
						if(payment.getExpenseType().equalsIgnoreCase("EL_BILL")){
							if(!"Y".equals(objDetail.getDetailFlag())){
								continue;
							}
							if(PAYMENT_METHOD_CHQ.equals(payment.getPaymentType())){
								paymentTypeBillChq = payment.getPaymentTypeTxt();
								paymentMethodBillChq = payment.getPaymentMethodTxt();
								paymentChqReceivedDtTHBillChq = payment.getChqReceivedDtTH();
								
								rowBillChk = worksheetBillChk.createRow(indexBillChk++);
								setExcelStyle(cellStyle, rowBillChk, (short) 0, String.valueOf(rowNoBillChk));								
								setExcelStyle(cellStyle, rowBillChk, (short)1, payment.getPayNo());
								setExcelStyle(cellStyle, rowBillChk, (short)2, payment.getDocNo());								
								setExcelStyle(cellStyle, rowBillChk, (short)3, payment.getVendorName());								
								setExcelStyle(cellStyle, rowBillChk, (short)4, payment.getDocDtTH());
								setExcelStyle(cellStyle, rowBillChk, (short)5, payment.getVendorId());								
								setExcelStyle(cellStyle, rowBillChk, (short)6, payment.getVendorName());
								setExcelStyle(cellStyle, rowBillChk, (short)7, payment.getPayeeName());
								
								if(objDetail.getExcludeVatAmt() != null){ 
									setExcelStyle(cellStyle, rowBillChk, (short)8, currencyFormat.format(objDetail.getExcludeVatAmt()));
								}else{
									setExcelStyle(cellStyle, rowBillChk, (short)8, currencyFormat.format(0));
								}
								if(objDetail.getVatAmt() != null){
									setExcelStyle(cellStyle, rowBillChk, (short)9, currencyFormat.format(objDetail.getVatAmt()));
								}else{
									setExcelStyle(cellStyle, rowBillChk, (short)9, currencyFormat.format(0));
								}
								if(objDetail.getIncludeVatAmt() != null){ 
									setExcelStyle(cellStyle, rowBillChk, (short)10, currencyFormat.format(objDetail.getIncludeVatAmt()));
								}else{
									setExcelStyle(cellStyle, rowBillChk, (short)10, currencyFormat.format(0));
								}
								if(objDetail.getWhtAmt() != null){ 
									setExcelStyle(cellStyle, rowBillChk, (short)11, currencyFormat.format(objDetail.getWhtAmt()));
								}else{
									setExcelStyle(cellStyle, rowBillChk, (short)11, currencyFormat.format(0));
								}
//								rowBillChk.createCell((short)12).setCellValue(new HSSFRichTextString(paymentTypeMap.get(payment.getPaymentType())));
//								rowBillChk.createCell((short)13).setCellValue(new HSSFRichTextString(paymentMethodMap.get(payment.getPaymentMethod())));
//								if(payment.getChqPostingDt() != null) rowBillChk.createCell((short)14).setCellValue(new HSSFRichTextString(exportFormat.format(payment.getChqPostingDt())));
//								if(payment.getChqReceivedDt() != null) rowBillChk.createCell((short)15).setCellValue(new HSSFRichTextString(exportFormat.format(payment.getChqReceivedDt())));
//								rowBillChk.createCell((short)16).setCellValue(new HSSFRichTextString(payment.getRemark()));
								
								worksheetBillChk.autoSizeColumn((short)0);
								worksheetBillChk.autoSizeColumn((short)1);
								worksheetBillChk.autoSizeColumn((short)2);
								worksheetBillChk.autoSizeColumn((short)3);
								worksheetBillChk.autoSizeColumn((short)4);
								worksheetBillChk.autoSizeColumn((short)5);
								worksheetBillChk.autoSizeColumn((short)6);
								worksheetBillChk.autoSizeColumn((short)7);
								worksheetBillChk.autoSizeColumn((short)8);
								worksheetBillChk.autoSizeColumn((short)9);
								worksheetBillChk.autoSizeColumn((short)10);
								worksheetBillChk.autoSizeColumn((short)11);
//								worksheetBillChk.autoSizeColumn((short)12);
//								worksheetBillChk.autoSizeColumn((short)13);
//								worksheetBillChk.autoSizeColumn((short)14);
//								worksheetBillChk.autoSizeColumn((short)15);
//								worksheetBillChk.autoSizeColumn((short)16);
								rowNoBillChk++;
								BigDecimal excludeVatAmt = new BigDecimal(0);
								if(objDetail.getExcludeVatAmt()!=null){
									excludeVatAmt = objDetail.getExcludeVatAmt();
								}
								sumExcludeVatAmtBillChk = sumExcludeVatAmtBillChk.add(excludeVatAmt);
								BigDecimal vatAmt = new BigDecimal(0);
								if(objDetail.getVatAmt()!=null){
									vatAmt = objDetail.getVatAmt();
								}
								sumVatAmtBillChk = sumVatAmtBillChk.add(vatAmt);
								BigDecimal includeVatAmt = new BigDecimal(0);
								if(objDetail.getIncludeVatAmt()!=null){
									includeVatAmt = objDetail.getIncludeVatAmt();
								}
								sumIncludeVatAmtBillChk = sumIncludeVatAmtBillChk.add(includeVatAmt);
								BigDecimal whtAmt = new BigDecimal(0);
								if(objDetail.getWhtAmt()!=null){
									whtAmt = objDetail.getWhtAmt();
								}
								sumWHTAmtBillChk = sumWHTAmtBillChk.add(whtAmt);
							}else if(PAYMENT_METHOD_TRANSFER.equals(payment.getPaymentType())){
								
								paymentTypeBillTrans = payment.getPaymentTypeTxt();
								paymentMethodBillTrans = payment.getPaymentMethodTxt();
								paymentTransferDtTHBillTrans = payment.getTransferDtTH();
								
								rowBillTrans = worksheetBillTrans.createRow(indexBillTrans++);								
								setExcelStyle(cellStyle, rowBillTrans, (short)0, String.valueOf(rowNoBillTrans));								
								setExcelStyle(cellStyle, rowBillTrans, (short)1, payment.getPayNo());								
								setExcelStyle(cellStyle, rowBillTrans, (short)2, payment.getDocNo());								
								setExcelStyle(cellStyle, rowBillTrans, (short)3, payment.getVendorName());								
								setExcelStyle(cellStyle, rowBillTrans, (short)4, payment.getDocDtTH());
								setExcelStyle(cellStyle, rowBillTrans, (short)5, payment.getVendorId());
								setExcelStyle(cellStyle, rowBillTrans, (short)6, payment.getVendorName());								
								setExcelStyle(cellStyle, rowBillTrans, (short)7, payment.getPayeeName());
								
								if(objDetail.getExcludeVatAmt() != null){									
									setExcelStyle(cellStyle, rowBillTrans, (short)8, objDetail.getExcludeVatAmt());
								}else{
									setExcelStyle(cellStyle, rowBillTrans, (short)8, currencyFormat.format(0));
								}
								if(objDetail.getVatAmt() != null){ 
									setExcelStyle(cellStyle, rowBillTrans, (short)9, currencyFormat.format(objDetail.getVatAmt()));
								}else{
									setExcelStyle(cellStyle, rowBillTrans, (short)9, currencyFormat.format(0));
								}
								if(objDetail.getIncludeVatAmt() != null){
									setExcelStyle(cellStyle, rowBillTrans, (short)10, currencyFormat.format(objDetail.getIncludeVatAmt()));
								}else{
									setExcelStyle(cellStyle, rowBillTrans, (short)10, currencyFormat.format(0));
								}
								if(objDetail.getWhtAmt() != null){
									setExcelStyle(cellStyle, rowBillTrans, (short)11, currencyFormat.format(objDetail.getWhtAmt()));
								}else{
									setExcelStyle(cellStyle, rowBillTrans, (short)11, currencyFormat.format(0));
								}
//								rowBillTrans.createCell((short)12).setCellValue(new HSSFRichTextString(paymentTypeMap.get(payment.getPaymentType())));
//								rowBillTrans.createCell((short)13).setCellValue(new HSSFRichTextString(paymentMethodMap.get(payment.getPaymentMethod())));
//								rowBillTrans.createCell((short)14).setCellValue(new HSSFRichTextString(payment.getBankName()));
//								rowBillTrans.createCell((short)15).setCellValue(new HSSFRichTextString(payment.getBankAccount()));
//								if(payment.getTransferDt() != null) rowBillTrans.createCell((short)23).setCellValue(new HSSFRichTextString(exportFormat.format(payment.getTransferDt())));
//								rowBillTrans.createCell((short)16).setCellValue(new HSSFRichTextString(payment.getRemark()));
								worksheetBillTrans.autoSizeColumn((short)0);
								worksheetBillTrans.autoSizeColumn((short)1);
								worksheetBillTrans.autoSizeColumn((short)2);
								worksheetBillTrans.autoSizeColumn((short)3);
								worksheetBillTrans.autoSizeColumn((short)4);
								worksheetBillTrans.autoSizeColumn((short)5);
								worksheetBillTrans.autoSizeColumn((short)6);
								worksheetBillTrans.autoSizeColumn((short)7);
								worksheetBillTrans.autoSizeColumn((short)8);
								worksheetBillTrans.autoSizeColumn((short)9);
								worksheetBillTrans.autoSizeColumn((short)10);
								worksheetBillTrans.autoSizeColumn((short)11);
//								worksheetBillTrans.autoSizeColumn((short)12);
//								worksheetBillTrans.autoSizeColumn((short)13);
//								worksheetBillTrans.autoSizeColumn((short)14);
//								worksheetBillTrans.autoSizeColumn((short)15);
//								worksheetBillTrans.autoSizeColumn((short)16);
								rowNoBillTrans++;
								BigDecimal excludeVatAmt = new BigDecimal(0);
								if(objDetail.getExcludeVatAmt()!=null){
									excludeVatAmt = objDetail.getExcludeVatAmt();
								}
								sumExcludeVatAmtBillTrans = sumExcludeVatAmtBillTrans.add(excludeVatAmt);
								BigDecimal vatAmt = new BigDecimal(0);
								if(objDetail.getVatAmt()!=null){
									vatAmt = objDetail.getVatAmt();
								}
								sumVatAmtBillTrans = sumVatAmtBillTrans.add(vatAmt);
								BigDecimal includeVatAmt = new BigDecimal(0);
								if(objDetail.getIncludeVatAmt()!=null){
									includeVatAmt = objDetail.getIncludeVatAmt();
								}
								sumIncludeVatAmtBillTrans = sumIncludeVatAmtBillTrans.add(includeVatAmt);
								BigDecimal whtAmt = new BigDecimal(0);
								if(objDetail.getWhtAmt()!=null){
									whtAmt = objDetail.getWhtAmt();
								}
								sumWHTAmtBillTrans = sumWHTAmtBillTrans.add(whtAmt);
							}else if(PAYMENT_METHOD_PETTY_CASH.equals(payment.getPaymentType())){
								paymentTypePC = payment.getPaymentTypeTxt();
								
								rowAllPC = worksheetAllPC.createRow(indexAllPC++);
								
								setExcelStyle(cellStyle, rowAllPC, (short)0, String.valueOf(rowNoAllTrans));
								setExcelStyle(cellStyle, rowAllPC, (short)1, payment.getContractNo());
								setExcelStyle(cellStyle, rowAllPC, (short)2, payment.getSiteName());
								String month = "";
								if(objDetail.getFromTermOfPaymentDt()!=null && objDetail.getToTermOfPaymentDt()!=null){
									month = sdf.format(objDetail.getFromTermOfPaymentDt())+" - "+sdf.format(objDetail.getToTermOfPaymentDt());
								}
								setExcelStyle(cellStyle, rowAllPC, (short)3, month);
								setExcelStyle(cellStyle, rowAllPC, (short)4, payment.getVendorId());								
								setExcelStyle(cellStyle, rowAllPC, (short)5, payment.getVendorName());
								setExcelStyle(cellStyle, rowAllPC, (short)6, payment.getPayeeName());
								
								if(objDetail.getExcludeVatAmt() != null){ 
									setExcelStyle(cellStyle, rowAllPC, (short)7, currencyFormat.format(objDetail.getExcludeVatAmt()));
								}else{
									setExcelStyle(cellStyle, rowAllPC, (short)7, currencyFormat.format(0));
								}
								if(objDetail.getVatAmt() != null){
									setExcelStyle(cellStyle, rowAllPC, (short)8, currencyFormat.format(objDetail.getVatAmt()));
								}else{
									setExcelStyle(cellStyle, rowAllPC, (short)8, currencyFormat.format(0));
								}
								if(objDetail.getIncludeVatAmt() != null){
									setExcelStyle(cellStyle, rowAllPC, (short)9, currencyFormat.format(objDetail.getIncludeVatAmt()));
								}else{
									setExcelStyle(cellStyle, rowAllPC, (short)9, currencyFormat.format(0));
								}
								if(objDetail.getWhtAmt() != null){
									setExcelStyle(cellStyle, rowAllPC, (short)10, currencyFormat.format(objDetail.getWhtAmt()));
								}else{
									setExcelStyle(cellStyle, rowAllPC, (short)10, currencyFormat.format(0));
								}
//								rowAllTrans.createCell((short)13).setCellValue(new HSSFRichTextString(paymentTypeMap.get(payment.getPaymentType())));
//								rowAllTrans.createCell((short)14).setCellValue(new HSSFRichTextString(paymentMethodMap.get(payment.getPaymentMethod())));
//								rowAllTrans.createCell((short)15).setCellValue(new HSSFRichTextString(payment.getBankName()));
//								rowAllTrans.createCell((short)16).setCellValue(new HSSFRichTextString(payment.getBankAccount()));
//								if(payment.getTransferDt() != null) rowAllTrans.createCell((short)17).setCellValue(new HSSFRichTextString(exportFormat.format(payment.getTransferDt())));
//								rowAllTrans.createCell((short)18).setCellValue(new HSSFRichTextString(payment.getRemark()));
								
								worksheetAllPC.autoSizeColumn((short)0);
								worksheetAllPC.autoSizeColumn((short)1);
								worksheetAllPC.autoSizeColumn((short)2);
								worksheetAllPC.autoSizeColumn((short)3);
								worksheetAllPC.autoSizeColumn((short)4);
								worksheetAllPC.autoSizeColumn((short)5);
								worksheetAllPC.autoSizeColumn((short)6);
								worksheetAllPC.autoSizeColumn((short)7);
								worksheetAllPC.autoSizeColumn((short)8);
								worksheetAllPC.autoSizeColumn((short)9);
								worksheetAllPC.autoSizeColumn((short)10);
//								worksheetAllTrans.autoSizeColumn((short)11);
//								worksheetAllTrans.autoSizeColumn((short)12);
//								worksheetAllTrans.autoSizeColumn((short)13);
//								worksheetAllTrans.autoSizeColumn((short)14);
//								worksheetAllTrans.autoSizeColumn((short)15);
//								worksheetAllTrans.autoSizeColumn((short)16);
//								worksheetAllTrans.autoSizeColumn((short)17);
//								worksheetAllTrans.autoSizeColumn((short)18);
								rowNoAllPC++;
								BigDecimal excludeVatAmt = new BigDecimal(0);
								if(objDetail.getExcludeVatAmt()!=null){
									excludeVatAmt = objDetail.getExcludeVatAmt();
								}
								sumExcludeVatAmtAllPC = sumExcludeVatAmtAllPC.add(excludeVatAmt);
								BigDecimal vatAmt = new BigDecimal(0);
								if(objDetail.getVatAmt()!=null){
									vatAmt = objDetail.getVatAmt();
								}
								sumVatAmtAllPC = sumVatAmtAllPC.add(vatAmt);
								BigDecimal includeVatAmt = new BigDecimal(0);
								if(objDetail.getIncludeVatAmt()!=null){
									includeVatAmt = objDetail.getIncludeVatAmt();
								}
								sumIncludeVatAmtAllPC = sumIncludeVatAmtAllPC.add(includeVatAmt);
								BigDecimal whtAmt = new BigDecimal(0);
								if(objDetail.getWhtAmt()!=null){
									whtAmt = objDetail.getWhtAmt();
								}
								sumWHTAmtAllPC = sumWHTAmtAllPC.add(whtAmt);
							}
							
						}else{
							
							if(PAYMENT_METHOD_CHQ.equals(payment.getPaymentType())){
								
								paymentTypeChq = payment.getPaymentTypeTxt();
								paymentMethodChq = payment.getPaymentMethodTxt();
								paymentChqReceivedDtTHChq = payment.getChqReceivedDtTH();
								rowAllChk = worksheetAllChk.createRow(indexAllChk++);
								
								setExcelStyle(cellStyle, rowAllChk, (short)0, String.valueOf(rowNoAllChk));
								setExcelStyle(cellStyle, rowAllChk, (short)1, payment.getContractNo());
								setExcelStyle(cellStyle, rowAllChk, (short)2, payment.getSiteName());
								String month = "";
								if(objDetail.getFromTermOfPaymentDt()!=null && objDetail.getToTermOfPaymentDt()!=null){
									month = sdf.format(objDetail.getFromTermOfPaymentDt())+" - "+sdf.format(objDetail.getToTermOfPaymentDt());
								}
								setExcelStyle(cellStyle, rowAllChk, (short)3, month);
								setExcelStyle(cellStyle, rowAllChk, (short)4, payment.getVendorId());
								setExcelStyle(cellStyle, rowAllChk, (short)5, payment.getVendorName());
								setExcelStyle(cellStyle, rowAllChk, (short)6, payment.getPayeeName());
								
								if(objDetail.getExcludeVatAmt() != null){									
									setExcelStyle(cellStyle, rowAllChk, (short)7, currencyFormat.format(objDetail.getExcludeVatAmt()));
								}else{
									setExcelStyle(cellStyle, rowAllChk, (short)7, currencyFormat.format(0));
								}
								if(objDetail.getVatAmt() != null){ 
									setExcelStyle(cellStyle, rowAllChk, (short)8, currencyFormat.format(objDetail.getVatAmt()));
								}else{
									setExcelStyle(cellStyle, rowAllChk, (short)8, currencyFormat.format(0));
								}
								if(objDetail.getIncludeVatAmt() != null){ 
									setExcelStyle(cellStyle, rowAllChk, (short)9, currencyFormat.format(objDetail.getIncludeVatAmt()));
								}else{
									setExcelStyle(cellStyle, rowAllChk, (short)9, currencyFormat.format(0));
								}
								if(objDetail.getWhtAmt() != null){
									setExcelStyle(cellStyle, rowAllChk, (short)10, currencyFormat.format(objDetail.getWhtAmt()));
								}else{
									setExcelStyle(cellStyle, rowAllChk, (short)10, currencyFormat.format(0));
								}
//								rowAllChk.createCell((short)14).setCellValue(new HSSFRichTextString(paymentTypeMap.get(payment.getPaymentType())));
//								rowAllChk.createCell((short)15).setCellValue(new HSSFRichTextString(paymentMethodMap.get(payment.getPaymentMethod())));
//								if(payment.getChqPostingDt() != null) rowAllChk.createCell((short)16).setCellValue(new HSSFRichTextString(exportFormat.format(payment.getChqPostingDt())));
//								if(payment.getChqReceivedDt() != null) rowAllChk.createCell((short)17).setCellValue(new HSSFRichTextString(exportFormat.format(payment.getChqReceivedDt())));
//								rowAllChk.createCell((short)18).setCellValue(new HSSFRichTextString(payment.getRemark()));
								
								worksheetAllChk.autoSizeColumn((short)0);
								worksheetAllChk.autoSizeColumn((short)1);
								worksheetAllChk.autoSizeColumn((short)2);
								worksheetAllChk.autoSizeColumn((short)3);
								worksheetAllChk.autoSizeColumn((short)4);
								worksheetAllChk.autoSizeColumn((short)5);
								worksheetAllChk.autoSizeColumn((short)6);
								worksheetAllChk.autoSizeColumn((short)7);
								worksheetAllChk.autoSizeColumn((short)8);
								worksheetAllChk.autoSizeColumn((short)9);
								worksheetAllChk.autoSizeColumn((short)10);
//								worksheetAllChk.autoSizeColumn((short)11);
//								worksheetAllChk.autoSizeColumn((short)12);
//								worksheetAllChk.autoSizeColumn((short)13);
//								worksheetAllChk.autoSizeColumn((short)14);
//								worksheetAllChk.autoSizeColumn((short)15);
//								worksheetAllChk.autoSizeColumn((short)16);
//								worksheetAllChk.autoSizeColumn((short)17);
//								worksheetAllChk.autoSizeColumn((short)18);
								rowNoAllChk++;
								BigDecimal excludeVatAmt = new BigDecimal(0);
								if(objDetail.getExcludeVatAmt()!=null){
									excludeVatAmt = objDetail.getExcludeVatAmt();
								}
								sumExcludeVatAmtAllChk = sumExcludeVatAmtAllChk.add(excludeVatAmt);
								BigDecimal vatAmt = new BigDecimal(0);
								if(objDetail.getVatAmt()!=null){
									vatAmt = objDetail.getVatAmt();
								}
								sumVatAmtAllChk = sumVatAmtAllChk.add(vatAmt);
								BigDecimal includeVatAmt = new BigDecimal(0);
								if(objDetail.getIncludeVatAmt()!=null){
									includeVatAmt = objDetail.getIncludeVatAmt();
								}
								sumIncludeVatAmtAllChk = sumIncludeVatAmtAllChk.add(includeVatAmt);
								BigDecimal whtAmt = new BigDecimal(0);
								if(objDetail.getWhtAmt()!=null){
									whtAmt = objDetail.getWhtAmt();
								}
								sumWHTAmtAllChk = sumWHTAmtAllChk.add(whtAmt);
							}else if(PAYMENT_METHOD_TRANSFER.equals(payment.getPaymentType())){
							//}else{
								paymentTypeTrans = payment.getPaymentTypeTxt();
								paymentMethodTrans = payment.getPaymentMethodTxt();
								paymentTransferDtTHTrans = payment.getTransferDtTH();
								
								rowAllTrans = worksheetAllTrans.createRow(indexAllTrans++);
								
								setExcelStyle(cellStyle, rowAllTrans, (short)0, String.valueOf(rowNoAllTrans));
								setExcelStyle(cellStyle, rowAllTrans, (short)1, payment.getContractNo());								
								setExcelStyle(cellStyle, rowAllTrans, (short)2, payment.getSiteName());
								String month = "";
								if(objDetail.getFromTermOfPaymentDt()!=null && objDetail.getToTermOfPaymentDt()!=null){
									month = sdf.format(objDetail.getFromTermOfPaymentDt())+" - "+sdf.format(objDetail.getToTermOfPaymentDt());
								}
								setExcelStyle(cellStyle, rowAllTrans, (short)3, month);								
								setExcelStyle(cellStyle, rowAllTrans, (short)4, payment.getVendorId());
								setExcelStyle(cellStyle, rowAllTrans, (short)5, payment.getVendorName());
								setExcelStyle(cellStyle, rowAllTrans, (short)6, payment.getPayeeName());
								
								if(objDetail.getExcludeVatAmt() != null){
									setExcelStyle(cellStyle, rowAllTrans, (short)7, currencyFormat.format(objDetail.getExcludeVatAmt()));
								}else{
									setExcelStyle(cellStyle, rowAllTrans, (short)7, currencyFormat.format(0));
								}
								if(objDetail.getVatAmt() != null){ 
									setExcelStyle(cellStyle, rowAllTrans, (short)8, currencyFormat.format(objDetail.getVatAmt()));
								}else{
									setExcelStyle(cellStyle, rowAllTrans, (short)8, currencyFormat.format(0));
								}
								if(objDetail.getIncludeVatAmt() != null){ 
									setExcelStyle(cellStyle, rowAllTrans, (short)9, currencyFormat.format(objDetail.getIncludeVatAmt()));
								}else{
									setExcelStyle(cellStyle, rowAllTrans, (short)9, currencyFormat.format(0));
								}
								if(objDetail.getWhtAmt() != null){
									setExcelStyle(cellStyle, rowAllTrans, (short)10, currencyFormat.format(objDetail.getWhtAmt()));
								}else{
									setExcelStyle(cellStyle, rowAllTrans, (short)10, currencyFormat.format(0));
								}
//								rowAllTrans.createCell((short)13).setCellValue(new HSSFRichTextString(paymentTypeMap.get(payment.getPaymentType())));
//								rowAllTrans.createCell((short)14).setCellValue(new HSSFRichTextString(paymentMethodMap.get(payment.getPaymentMethod())));
//								rowAllTrans.createCell((short)15).setCellValue(new HSSFRichTextString(payment.getBankName()));
//								rowAllTrans.createCell((short)16).setCellValue(new HSSFRichTextString(payment.getBankAccount()));
//								if(payment.getTransferDt() != null) rowAllTrans.createCell((short)17).setCellValue(new HSSFRichTextString(exportFormat.format(payment.getTransferDt())));
//								rowAllTrans.createCell((short)18).setCellValue(new HSSFRichTextString(payment.getRemark()));
								
								worksheetAllTrans.autoSizeColumn((short)0);
								worksheetAllTrans.autoSizeColumn((short)1);
								worksheetAllTrans.autoSizeColumn((short)2);
								worksheetAllTrans.autoSizeColumn((short)3);
								worksheetAllTrans.autoSizeColumn((short)4);
								worksheetAllTrans.autoSizeColumn((short)5);
								worksheetAllTrans.autoSizeColumn((short)6);
								worksheetAllTrans.autoSizeColumn((short)7);
								worksheetAllTrans.autoSizeColumn((short)8);
								worksheetAllTrans.autoSizeColumn((short)9);
								worksheetAllTrans.autoSizeColumn((short)10);
//								worksheetAllTrans.autoSizeColumn((short)11);
//								worksheetAllTrans.autoSizeColumn((short)12);
//								worksheetAllTrans.autoSizeColumn((short)13);
//								worksheetAllTrans.autoSizeColumn((short)14);
//								worksheetAllTrans.autoSizeColumn((short)15);
//								worksheetAllTrans.autoSizeColumn((short)16);
//								worksheetAllTrans.autoSizeColumn((short)17);
//								worksheetAllTrans.autoSizeColumn((short)18);
								rowNoAllTrans++;
								BigDecimal excludeVatAmt = new BigDecimal(0);
								if(objDetail.getExcludeVatAmt()!=null){
									excludeVatAmt = objDetail.getExcludeVatAmt();
								}
								sumExcludeVatAmtAllTrans = sumExcludeVatAmtAllTrans.add(excludeVatAmt);
								BigDecimal vatAmt = new BigDecimal(0);
								if(objDetail.getVatAmt()!=null){
									vatAmt = objDetail.getVatAmt();
								}
								sumVatAmtAllTrans = sumVatAmtAllTrans.add(vatAmt);
								BigDecimal includeVatAmt = new BigDecimal(0);
								if(objDetail.getIncludeVatAmt()!=null){
									includeVatAmt = objDetail.getIncludeVatAmt();
								}
								sumIncludeVatAmtAllTrans = sumIncludeVatAmtAllTrans.add(includeVatAmt);
								BigDecimal whtAmt = new BigDecimal(0);
								if(objDetail.getWhtAmt()!=null){
									whtAmt = objDetail.getWhtAmt();
								}
								sumWHTAmtAllTrans = sumWHTAmtAllTrans.add(whtAmt);
							}else if(PAYMENT_METHOD_PETTY_CASH.equals(payment.getPaymentType())){
								paymentTypePC = payment.getPaymentTypeTxt();
								
								rowAllPC = worksheetAllPC.createRow(indexAllPC++);
																
								setExcelStyle(cellStyle, rowAllPC, (short)0, String.valueOf(rowNoAllPC));
								setExcelStyle(cellStyle, rowAllPC, (short)1, payment.getContractNo());
								setExcelStyle(cellStyle, rowAllPC, (short)2, payment.getSiteName());
								String month = "";
								if(objDetail.getFromTermOfPaymentDt()!=null && objDetail.getToTermOfPaymentDt()!=null){
									month = sdf.format(objDetail.getFromTermOfPaymentDt())+" - "+sdf.format(objDetail.getToTermOfPaymentDt());
								}
								setExcelStyle(cellStyle, rowAllPC, (short)3, month);
								setExcelStyle(cellStyle, rowAllPC, (short)4, payment.getVendorId());
								setExcelStyle(cellStyle, rowAllPC, (short)5, payment.getVendorName());
								setExcelStyle(cellStyle, rowAllPC, (short)6, payment.getPayeeName());
								
								if(objDetail.getExcludeVatAmt() != null){ 
									setExcelStyle(cellStyle, rowAllPC, (short)7, currencyFormat.format(objDetail.getExcludeVatAmt()));
								}else{
									setExcelStyle(cellStyle, rowAllPC, (short)7, currencyFormat.format(0));
								}
								if(objDetail.getVatAmt() != null){ 
									setExcelStyle(cellStyle, rowAllPC, (short)8, currencyFormat.format(objDetail.getVatAmt()));
								}else{
									setExcelStyle(cellStyle, rowAllPC, (short)8, currencyFormat.format(0));
								}
								if(objDetail.getIncludeVatAmt() != null){ 
									setExcelStyle(cellStyle, rowAllPC, (short)9, currencyFormat.format(objDetail.getIncludeVatAmt()));
								}else{
									setExcelStyle(cellStyle, rowAllPC, (short)9, currencyFormat.format(0));
								}
								if(objDetail.getWhtAmt() != null){
									setExcelStyle(cellStyle, rowAllPC, (short)10, currencyFormat.format(objDetail.getWhtAmt()));
								}else{
									setExcelStyle(cellStyle, rowAllPC, (short)10, currencyFormat.format(0));
								}
//								rowAllTrans.createCell((short)13).setCellValue(new HSSFRichTextString(paymentTypeMap.get(payment.getPaymentType())));
//								rowAllTrans.createCell((short)14).setCellValue(new HSSFRichTextString(paymentMethodMap.get(payment.getPaymentMethod())));
//								rowAllTrans.createCell((short)15).setCellValue(new HSSFRichTextString(payment.getBankName()));
//								rowAllTrans.createCell((short)16).setCellValue(new HSSFRichTextString(payment.getBankAccount()));
//								if(payment.getTransferDt() != null) rowAllTrans.createCell((short)17).setCellValue(new HSSFRichTextString(exportFormat.format(payment.getTransferDt())));
//								rowAllTrans.createCell((short)18).setCellValue(new HSSFRichTextString(payment.getRemark()));
								
								worksheetAllPC.autoSizeColumn((short)0);
								worksheetAllPC.autoSizeColumn((short)1);
								worksheetAllPC.autoSizeColumn((short)2);
								worksheetAllPC.autoSizeColumn((short)3);
								worksheetAllPC.autoSizeColumn((short)4);
								worksheetAllPC.autoSizeColumn((short)5);
								worksheetAllPC.autoSizeColumn((short)6);
								worksheetAllPC.autoSizeColumn((short)7);
								worksheetAllPC.autoSizeColumn((short)8);
								worksheetAllPC.autoSizeColumn((short)9);
								worksheetAllPC.autoSizeColumn((short)10);
//								worksheetAllTrans.autoSizeColumn((short)11);
//								worksheetAllTrans.autoSizeColumn((short)12);
//								worksheetAllTrans.autoSizeColumn((short)13);
//								worksheetAllTrans.autoSizeColumn((short)14);
//								worksheetAllTrans.autoSizeColumn((short)15);
//								worksheetAllTrans.autoSizeColumn((short)16);
//								worksheetAllTrans.autoSizeColumn((short)17);
//								worksheetAllTrans.autoSizeColumn((short)18);
								rowNoAllPC++;
								BigDecimal excludeVatAmt = new BigDecimal(0);
								if(objDetail.getExcludeVatAmt()!=null){
									excludeVatAmt = objDetail.getExcludeVatAmt();
								}
								sumExcludeVatAmtAllPC = sumExcludeVatAmtAllPC.add(excludeVatAmt);
								BigDecimal vatAmt = new BigDecimal(0);
								if(objDetail.getVatAmt()!=null){
									vatAmt = objDetail.getVatAmt();
								}
								sumVatAmtAllPC = sumVatAmtAllPC.add(vatAmt);
								BigDecimal includeVatAmt = new BigDecimal(0);
								if(objDetail.getIncludeVatAmt()!=null){
									includeVatAmt = objDetail.getIncludeVatAmt();
								}
								sumIncludeVatAmtAllPC = sumIncludeVatAmtAllPC.add(includeVatAmt);
								BigDecimal whtAmt = new BigDecimal(0);
								if(objDetail.getWhtAmt()!=null){
									whtAmt = objDetail.getWhtAmt();
								}
								sumWHTAmtAllPC = sumWHTAmtAllPC.add(whtAmt);
							}
						}
					}
					
					createSumRow(payment, rowAllTrans, worksheetAllTrans, sumExcludeVatAmtAllTrans, sumVatAmtAllTrans, sumIncludeVatAmtAllTrans, sumWHTAmtAllTrans, indexAllTrans, cellStyle);
					createSumRow(payment, rowAllChk, worksheetAllChk, sumExcludeVatAmtAllChk, sumVatAmtAllChk, sumIncludeVatAmtAllChk, sumWHTAmtAllChk, indexAllChk, cellStyle);
					createSumRow(payment, rowAllPC, worksheetAllPC, sumExcludeVatAmtAllPC, sumVatAmtAllPC, sumIncludeVatAmtAllPC, sumWHTAmtAllPC, indexAllPC, cellStyle);
					createSumRow(payment, rowBillChk, worksheetBillChk, sumExcludeVatAmtBillChk, sumVatAmtBillChk, sumIncludeVatAmtBillChk, sumWHTAmtBillChk, indexBillChk, cellStyle);
					createSumRow(payment, rowBillTrans, worksheetBillTrans, sumExcludeVatAmtBillTrans, sumVatAmtBillTrans, sumIncludeVatAmtBillTrans, sumWHTAmtBillTrans, indexBillTrans, cellStyle);
					
				}
				
				rowAllChk = worksheetAllChk.getRow(0);
				rowAllTrans = worksheetAllTrans.getRow(0);
				rowBillTrans = worksheetBillTrans.getRow(0);
				rowBillChk = worksheetBillChk.getRow(0);
				
				rowAllChk.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.paymentDate")+" "+sdf.format(c1.getTime())));
				rowAllChk = worksheetAllChk.getRow(1);
				rowAllChk.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.company")+" "+company));
				rowAllChk = worksheetAllChk.getRow(2);
				rowAllChk.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.batchNo")+" "+batchNo));
				rowAllChk = worksheetAllChk.getRow(3);
				rowAllChk.getCell((short)3).setCellValue(new HSSFRichTextString(getMessage("label.paymentType")+" "+paymentTypeChq));
				rowAllChk = worksheetAllChk.getRow(3);
				rowAllChk.getCell((short)1).setCellValue(new HSSFRichTextString(getMessage("label.paymentMethod")+" "+paymentMethodChq));
				rowAllChk = worksheetAllChk.getRow(4);
				rowAllChk.getCell((short)1).setCellValue(new HSSFRichTextString(getMessage("label.chqReceivedDt")+" "+paymentChqReceivedDtTHChq));
				
				rowAllTrans.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.paymentDate")+" "+sdf.format(c1.getTime())));
				rowAllTrans = worksheetAllTrans.getRow(1);
				rowAllTrans.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.company")+" "+company));
				rowAllTrans = worksheetAllTrans.getRow(2);
				rowAllTrans.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.batchNo")+" "+batchNo));
				rowAllTrans = worksheetAllTrans.getRow(3);
				rowAllTrans.getCell((short)3).setCellValue(new HSSFRichTextString(getMessage("label.paymentType")+" "+paymentTypeTrans));
				rowAllTrans = worksheetAllTrans.getRow(3);
				rowAllTrans.getCell((short)1).setCellValue(new HSSFRichTextString(getMessage("label.paymentMethod")+" "+paymentMethodTrans));
				rowAllTrans = worksheetAllTrans.getRow(4);
				rowAllTrans.getCell((short)1).setCellValue(new HSSFRichTextString(getMessage("label.transferDt")+" "+paymentTransferDtTHTrans));
				
				//WT###Add 20110420 Start
				rowBillTrans.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.paymentDate")+" "+sdf.format(c1.getTime())));	
				rowBillTrans = worksheetBillTrans.getRow(1);
				rowBillTrans.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.company")+" "+company));
				rowBillTrans = worksheetBillTrans.getRow(2);
				rowBillTrans.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.batchNo")+" "+batchNo));
				rowBillTrans = worksheetBillTrans.getRow(3);
				rowBillTrans.getCell((short)3).setCellValue(new HSSFRichTextString(getMessage("label.paymentType")+" "+paymentTypeBillTrans));
				rowBillTrans = worksheetBillTrans.getRow(3);
				rowBillTrans.getCell((short)1).setCellValue(new HSSFRichTextString(getMessage("label.paymentMethod")+" "+paymentMethodBillTrans));
				rowBillTrans = worksheetBillTrans.getRow(4);
				rowBillTrans.getCell((short)1).setCellValue(new HSSFRichTextString(getMessage("label.transferDt")+" "+paymentTransferDtTHBillTrans));
				
				rowBillChk.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.paymentDate")+" "+sdf.format(c1.getTime())));	
				rowBillChk = worksheetBillChk.getRow(1);
				rowBillChk.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.company")+" "+company));
				rowBillChk = worksheetBillChk.getRow(2);
				rowBillChk.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.batchNo")+" "+batchNo));
				rowBillChk = worksheetBillChk.getRow(3);
				rowBillChk.getCell((short)3).setCellValue(new HSSFRichTextString(getMessage("label.paymentType")+" "+paymentTypeBillChq));
				rowBillChk = worksheetBillChk.getRow(3);
				rowBillChk.getCell((short)1).setCellValue(new HSSFRichTextString(getMessage("label.paymentMethod")+" "+paymentMethodBillChq));
				rowBillChk = worksheetBillChk.getRow(4);
				rowBillChk.getCell((short)1).setCellValue(new HSSFRichTextString(getMessage("label.chqReceivedDt")+" "+paymentChqReceivedDtTHBillChq));
				//WT###Add 20110420 End
				
				if(rowNoAllPC==1){
					LOG.debug("WT### removeShhetAt 4");
					try{
						workbook.removeSheetAt(4);
					}catch(Exception e){
						LOG.error("Can't remove sheet index 4 : "+e.getMessage());
					}
				}
				if(rowNoBillTrans==1){
					LOG.debug("WT### removeShhetAt 3");
					try{
						workbook.removeSheetAt(3);
					}catch(Exception e){
						LOG.error("Can't remove sheet index 3 : "+e.getMessage());
					}
				}
				if(rowNoBillChk==1){
					LOG.debug("WT### removeShhetAt 2");
					try{
						workbook.removeSheetAt(2);
					}catch(Exception e){
						LOG.error("Can't remove sheet index 2 : "+e.getMessage());
					}
				}
				if(rowNoAllTrans==1){
					LOG.debug("WT### removeShhetAt 1");
					try{
						workbook.removeSheetAt(1);
					}catch(Exception e){
						LOG.error("Can't remove sheet index 1 : "+e.getMessage());
					}
				}
				if(rowNoAllChk==1){
					LOG.debug("WT### removeShhetAt 0");
					try{
						workbook.removeSheetAt(0);
					}catch(Exception e){
						LOG.error("Can't remove sheet index 0 : "+e.getMessage());
					}
				}
				
				
			}
			
			// update payment
			SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
			
			for(Payment payment : selectedPayments){
				
				payment.setExportFlag(SEMMEL001Util.Y);
				payment.setExportDt(Calendar.getInstance().getTime());
				payment.setUpdateBy(ssoBean.getUserName());
				payment.setCurrentUser(ssoBean.getUserName());
				payment.setUpdateDt(Calendar.getInstance().getTime());
				payment.setBatchNo(batchNo);
			}
			
			IPaymentService paymentService = (IPaymentService)getBean("paymentService");
//			paymentService.savePayment(selectedPayments);
			
			//WT###Add 20110111 Start
			String plUpdateBatchName = ParameterConfigUtil.getInstance().getConfigByCode("EL_PG_UPDATE_BATCH_B001");
			LOG.info("Start Service upDateBatchWithPL");
			LOG.info("WT### batchNo="+batchNo);
			paymentService.upDateBatchWithPL(plUpdateBatchName, batchNo);
			LOG.info("End Service upDateBatchWithPL");
			//WT###Add 20110111 End
			
			// export
			HttpServletResponse res = FacesUtils.getInstance().getHttpResponse();   
			res.setContentType("application/vnd.ms-excel");   
			//res.setHeader("Content-disposition",  "attachment;filename=Export Management.xls");
			res.setHeader("Content-disposition",  "attachment;filename="+fileName);
	          
            ServletOutputStream out = res.getOutputStream();   
     
            workbook.write(out);   
            out.flush();   
            out.close();
            
            FacesContext faces = FacesContext.getCurrentInstance();   
            faces.responseComplete();
            
		}catch(Exception e){
			
			e.printStackTrace();
			LOG.error(e);
		}
		
		return "login_pass";
	}
	
	private void createSumRow(Payment payment, HSSFRow hssfRow,
			HSSFSheet hssfSheet, BigDecimal sumExcludeVatAmt,
			BigDecimal sumVatAmt,
			BigDecimal sumIncludeVatAmt,
			BigDecimal sumWHTAmt,
			int lastIndex, HSSFCellStyle cellStyle) {
				
		if(payment.getExpenseType().equalsIgnoreCase("EL_BILL")){
			
			if(PAYMENT_METHOD_CHQ.equals(payment.getPaymentType())){
				LOG.debug("WT### Last ro of EL_BILL and CHQ");
				hssfRow = hssfSheet.createRow(lastIndex++);
				hssfRow.createCell((short)0).setCellValue(new HSSFRichTextString(""));
				hssfRow.createCell((short)1).setCellValue(new HSSFRichTextString(""));
				hssfRow.createCell((short)2).setCellValue(new HSSFRichTextString(""));
				hssfRow.createCell((short)3).setCellValue(new HSSFRichTextString(""));
				hssfRow.createCell((short)4).setCellValue(new HSSFRichTextString(""));
				hssfRow.createCell((short)5).setCellValue(new HSSFRichTextString(""));							
				hssfRow.createCell((short)6).setCellValue(new HSSFRichTextString(""));
				hssfRow.createCell((short)7).setCellValue(new HSSFRichTextString(""));
//				hssfRow.createCell((short)8).setCellValue(new HSSFRichTextString(""));
				
				if(sumExcludeVatAmt != null){ 
					//hssfRow.createCell((short)8).setCellValue(new HSSFRichTextString(currencyFormat.format(sumExcludeVatAmt)));
					setExcelStyle(cellStyle, hssfRow, (short)8, currencyFormat.format(sumExcludeVatAmt));
				}	
				if(sumVatAmt != null){ 
					//hssfRow.createCell((short)9).setCellValue(new HSSFRichTextString(currencyFormat.format(sumVatAmt)));
					setExcelStyle(cellStyle, hssfRow, (short)9, currencyFormat.format(sumVatAmt));
				}
				if(sumIncludeVatAmt != null){ 
					//hssfRow.createCell((short)10).setCellValue(new HSSFRichTextString(currencyFormat.format(sumIncludeVatAmt)));
					setExcelStyle(cellStyle, hssfRow, (short)10, currencyFormat.format(sumIncludeVatAmt));
				}
				if(sumWHTAmt != null){ 
					//hssfRow.createCell((short)11).setCellValue(new HSSFRichTextString(currencyFormat.format(sumWHTAmt)));
					setExcelStyle(cellStyle, hssfRow, (short)11, currencyFormat.format(sumWHTAmt));
				}
//				hssfRow.createCell((short)12).setCellValue(new HSSFRichTextString(""));
//				hssfRow.createCell((short)13).setCellValue(new HSSFRichTextString(""));
//				hssfRow.createCell((short)14).setCellValue("");
//				hssfRow.createCell((short)15).setCellValue("");
//				hssfRow.createCell((short)16).setCellValue("");
				
				hssfSheet.autoSizeColumn((short)0);
				hssfSheet.autoSizeColumn((short)1);
				hssfSheet.autoSizeColumn((short)2);
				hssfSheet.autoSizeColumn((short)3);
				hssfSheet.autoSizeColumn((short)4);
				hssfSheet.autoSizeColumn((short)5);
				hssfSheet.autoSizeColumn((short)6);
				hssfSheet.autoSizeColumn((short)7);
				hssfSheet.autoSizeColumn((short)8);
				hssfSheet.autoSizeColumn((short)9);
				hssfSheet.autoSizeColumn((short)10);
//				hssfSheet.autoSizeColumn((short)11);
//				hssfSheet.autoSizeColumn((short)12);
//				hssfSheet.autoSizeColumn((short)13);
//				hssfSheet.autoSizeColumn((short)14);
//				hssfSheet.autoSizeColumn((short)15);
//				hssfSheet.autoSizeColumn((short)16);
			}else if(PAYMENT_METHOD_TRANSFER.equals(payment.getPaymentType())){
				LOG.debug("WT### Last ro of EL_BILL and TRANSFER");
				hssfRow = hssfSheet.createRow(lastIndex++);
				hssfRow.createCell((short)0).setCellValue(new HSSFRichTextString(""));
				hssfRow.createCell((short)1).setCellValue(new HSSFRichTextString(""));
				hssfRow.createCell((short)2).setCellValue(new HSSFRichTextString(""));
				hssfRow.createCell((short)3).setCellValue(new HSSFRichTextString(""));
				hssfRow.createCell((short)4).setCellValue(new HSSFRichTextString(""));
				hssfRow.createCell((short)5).setCellValue(new HSSFRichTextString(""));							
				hssfRow.createCell((short)6).setCellValue(new HSSFRichTextString(""));
				hssfRow.createCell((short)7).setCellValue(new HSSFRichTextString(""));
//				hssfRow.createCell((short)8).setCellValue(new HSSFRichTextString(""));
				
				if(sumExcludeVatAmt != null){ 
					//hssfRow.createCell((short)8).setCellValue(new HSSFRichTextString(currencyFormat.format(sumExcludeVatAmt)));
					setExcelStyle(cellStyle, hssfRow, (short)8, currencyFormat.format(sumExcludeVatAmt));
				}
				if(sumVatAmt != null){ 
					//hssfRow.createCell((short)9).setCellValue(new HSSFRichTextString(currencyFormat.format(sumVatAmt)));
					setExcelStyle(cellStyle, hssfRow, (short)9, currencyFormat.format(sumVatAmt));
				}
				if(sumIncludeVatAmt != null){ 
					//hssfRow.createCell((short)10).setCellValue(new HSSFRichTextString(currencyFormat.format(sumIncludeVatAmt)));
					setExcelStyle(cellStyle, hssfRow, (short)10, currencyFormat.format(sumIncludeVatAmt));
				}
				if(sumWHTAmt != null){ 
					//hssfRow.createCell((short)11).setCellValue(new HSSFRichTextString(currencyFormat.format(sumWHTAmt)));
					setExcelStyle(cellStyle, hssfRow, (short)11, currencyFormat.format(sumWHTAmt));
				}
//				hssfRow.createCell((short)12).setCellValue(new HSSFRichTextString(""));
//				hssfRow.createCell((short)13).setCellValue(new HSSFRichTextString(""));
//				hssfRow.createCell((short)14).setCellValue(new HSSFRichTextString(""));
//				hssfRow.createCell((short)15).setCellValue(new HSSFRichTextString(""));
//				hssfRow.createCell((short)23).setCellValue(new HSSFRichTextString(""));
//				hssfRow.createCell((short)16).setCellValue(new HSSFRichTextString(""));
				hssfSheet.autoSizeColumn((short)0);
				hssfSheet.autoSizeColumn((short)1);
				hssfSheet.autoSizeColumn((short)2);
				hssfSheet.autoSizeColumn((short)3);
				hssfSheet.autoSizeColumn((short)4);
				hssfSheet.autoSizeColumn((short)5);
				hssfSheet.autoSizeColumn((short)6);
				hssfSheet.autoSizeColumn((short)7);
				hssfSheet.autoSizeColumn((short)8);
				hssfSheet.autoSizeColumn((short)9);
				hssfSheet.autoSizeColumn((short)10);
				hssfSheet.autoSizeColumn((short)11);
//				hssfSheet.autoSizeColumn((short)12);
//				hssfSheet.autoSizeColumn((short)13);
//				hssfSheet.autoSizeColumn((short)14);
//				hssfSheet.autoSizeColumn((short)15);
//				hssfSheet.autoSizeColumn((short)16);
			}
			
		}else{
			
			if(PAYMENT_METHOD_CHQ.equals(payment.getPaymentType())){
				LOG.debug("WT### Last ro of NONE EL_BILL and CHQ");
				hssfRow = hssfSheet.createRow(lastIndex++);
				
				hssfRow.createCell((short)0).setCellValue(new HSSFRichTextString(""));
//				hssfRow.createCell((short)1).setCellValue(new HSSFRichTextString(""));
				hssfRow.createCell((short)1).setCellValue(new HSSFRichTextString(""));
				hssfRow.createCell((short)2).setCellValue(new HSSFRichTextString(""));
//				hssfRow.createCell((short)4).setCellValue(new HSSFRichTextString(""));
//				hssfRow.createCell((short)5).setCellValue(new HSSFRichTextString(""));
				hssfRow.createCell((short)3).setCellValue(new HSSFRichTextString(""));
				hssfRow.createCell((short)4).setCellValue(new HSSFRichTextString(""));
				hssfRow.createCell((short)5).setCellValue(new HSSFRichTextString(""));
				hssfRow.createCell((short)6).setCellValue(new HSSFRichTextString(""));
				
				if(sumExcludeVatAmt != null){ 
					//hssfRow.createCell((short)7).setCellValue(new HSSFRichTextString(currencyFormat.format(sumExcludeVatAmt)));
					setExcelStyle(cellStyle, hssfRow, (short)7, currencyFormat.format(sumExcludeVatAmt));
				}
				if(sumVatAmt != null){ 
					//hssfRow.createCell((short)8).setCellValue(new HSSFRichTextString(currencyFormat.format(sumVatAmt)));
					setExcelStyle(cellStyle, hssfRow, (short)8, currencyFormat.format(sumVatAmt));
				}
				if(sumIncludeVatAmt != null){
					//hssfRow.createCell((short)9).setCellValue(new HSSFRichTextString(currencyFormat.format(sumIncludeVatAmt)));
					setExcelStyle(cellStyle, hssfRow, (short)9, currencyFormat.format(sumIncludeVatAmt));
				}
				if(sumWHTAmt != null){ 
					//hssfRow.createCell((short)10).setCellValue(new HSSFRichTextString(currencyFormat.format(sumWHTAmt)));
					setExcelStyle(cellStyle, hssfRow, (short)10, currencyFormat.format(sumWHTAmt));
				}
//				hssfRow.createCell((short)14).setCellValue(new HSSFRichTextString(""));
//				hssfRow.createCell((short)15).setCellValue(new HSSFRichTextString(""));
//				hssfRow.createCell((short)16).setCellValue(new HSSFRichTextString(""));
//				hssfRow.createCell((short)17).setCellValue(new HSSFRichTextString(""));
//				hssfRow.createCell((short)18).setCellValue(new HSSFRichTextString(""));
				
				hssfSheet.autoSizeColumn((short)0);
				hssfSheet.autoSizeColumn((short)1);
				hssfSheet.autoSizeColumn((short)2);
				hssfSheet.autoSizeColumn((short)3);
				hssfSheet.autoSizeColumn((short)4);
				hssfSheet.autoSizeColumn((short)5);
				hssfSheet.autoSizeColumn((short)6);
				hssfSheet.autoSizeColumn((short)7);
				hssfSheet.autoSizeColumn((short)8);
				hssfSheet.autoSizeColumn((short)9);
				hssfSheet.autoSizeColumn((short)10);
//				hssfSheet.autoSizeColumn((short)11);
//				hssfSheet.autoSizeColumn((short)12);
//				hssfSheet.autoSizeColumn((short)13);
//				hssfSheet.autoSizeColumn((short)14);
//				hssfSheet.autoSizeColumn((short)15);
//				hssfSheet.autoSizeColumn((short)16);
//				hssfSheet.autoSizeColumn((short)17);
//				hssfSheet.autoSizeColumn((short)18);
			}else if(PAYMENT_METHOD_TRANSFER.equals(payment.getPaymentType())){
			//}else{
				LOG.debug("WT### Last ro of NONE EL_BILL and TRANSFER");
				
				hssfRow = hssfSheet.createRow(lastIndex++);
				
				hssfRow.createCell((short)0).setCellValue(new HSSFRichTextString(""));
//				hssfRow.createCell((short)1).setCellValue(new HSSFRichTextString(""));
				hssfRow.createCell((short)1).setCellValue(new HSSFRichTextString(""));
				hssfRow.createCell((short)2).setCellValue(new HSSFRichTextString(""));
//				hssfRow.createCell((short)4).setCellValue(new HSSFRichTextString(""));
				hssfRow.createCell((short)3).setCellValue(new HSSFRichTextString(""));
				hssfRow.createCell((short)4).setCellValue(new HSSFRichTextString(""));
				hssfRow.createCell((short)5).setCellValue(new HSSFRichTextString(""));
				hssfRow.createCell((short)6).setCellValue(new HSSFRichTextString(""));
				
				if(sumExcludeVatAmt != null){ 
					//hssfRow.createCell((short)7).setCellValue(new HSSFRichTextString(currencyFormat.format(sumExcludeVatAmt)));
					setExcelStyle(cellStyle, hssfRow, (short)7, currencyFormat.format(sumExcludeVatAmt));
				}
				if(sumVatAmt != null){ 
					//hssfRow.createCell((short)8).setCellValue(new HSSFRichTextString(currencyFormat.format(sumVatAmt)));
					setExcelStyle(cellStyle, hssfRow, (short)8, currencyFormat.format(sumVatAmt));
				}
				if(sumIncludeVatAmt != null){ 
					//hssfRow.createCell((short)9).setCellValue(new HSSFRichTextString(currencyFormat.format(sumIncludeVatAmt)));
					setExcelStyle(cellStyle, hssfRow, (short)9, currencyFormat.format(sumIncludeVatAmt));
				}
				if(sumWHTAmt != null){ 
					//hssfRow.createCell((short)10).setCellValue(new HSSFRichTextString(currencyFormat.format(sumWHTAmt)));
					setExcelStyle(cellStyle, hssfRow, (short)10, currencyFormat.format(sumWHTAmt));
				}
//				hssfRow.createCell((short)13).setCellValue(new HSSFRichTextString(""));
//				hssfRow.createCell((short)14).setCellValue(new HSSFRichTextString(""));
//				hssfRow.createCell((short)15).setCellValue(new HSSFRichTextString(""));
//				hssfRow.createCell((short)16).setCellValue(new HSSFRichTextString(""));
//				hssfRow.createCell((short)17).setCellValue(new HSSFRichTextString(""));
//				hssfRow.createCell((short)18).setCellValue(new HSSFRichTextString(""));
				
				hssfSheet.autoSizeColumn((short)0);
				hssfSheet.autoSizeColumn((short)1);
				hssfSheet.autoSizeColumn((short)2);
				hssfSheet.autoSizeColumn((short)3);
				hssfSheet.autoSizeColumn((short)4);
				hssfSheet.autoSizeColumn((short)5);
				hssfSheet.autoSizeColumn((short)6);
				hssfSheet.autoSizeColumn((short)7);
				hssfSheet.autoSizeColumn((short)8);
				hssfSheet.autoSizeColumn((short)9);
				hssfSheet.autoSizeColumn((short)10);
//				hssfSheet.autoSizeColumn((short)11);
//				hssfSheet.autoSizeColumn((short)12);
//				hssfSheet.autoSizeColumn((short)13);
//				hssfSheet.autoSizeColumn((short)14);
//				hssfSheet.autoSizeColumn((short)15);
//				hssfSheet.autoSizeColumn((short)16);
//				hssfSheet.autoSizeColumn((short)17);
//				hssfSheet.autoSizeColumn((short)18);
			}else if(PAYMENT_METHOD_PETTY_CASH.equals(payment.getPaymentType())){
			//}else{
				LOG.debug("WT### Last ro of NONE EL_BILL and PETTY CASH");
				
				hssfRow = hssfSheet.createRow(lastIndex++);
				
				hssfRow.createCell((short)0).setCellValue(new HSSFRichTextString(""));
//				hssfRow.createCell((short)1).setCellValue(new HSSFRichTextString(""));
				hssfRow.createCell((short)1).setCellValue(new HSSFRichTextString(""));
				hssfRow.createCell((short)2).setCellValue(new HSSFRichTextString(""));
//				hssfRow.createCell((short)4).setCellValue(new HSSFRichTextString(""));
				hssfRow.createCell((short)3).setCellValue(new HSSFRichTextString(""));
				hssfRow.createCell((short)4).setCellValue(new HSSFRichTextString(""));
				hssfRow.createCell((short)5).setCellValue(new HSSFRichTextString(""));
				hssfRow.createCell((short)6).setCellValue(new HSSFRichTextString(""));
				
				if(sumExcludeVatAmt != null){ 
					//hssfRow.createCell((short)7).setCellValue(new HSSFRichTextString(currencyFormat.format(sumExcludeVatAmt)));
					setExcelStyle(cellStyle, hssfRow, (short)7, currencyFormat.format(sumExcludeVatAmt));
				}
				if(sumVatAmt != null){ 
					//hssfRow.createCell((short)8).setCellValue(new HSSFRichTextString(currencyFormat.format(sumVatAmt)));					
					setExcelStyle(cellStyle, hssfRow, (short)8, currencyFormat.format(sumVatAmt));
				}
				if(sumIncludeVatAmt != null){ 
					//hssfRow.createCell((short)9).setCellValue(new HSSFRichTextString(currencyFormat.format(sumIncludeVatAmt)));
					setExcelStyle(cellStyle, hssfRow, (short)9, currencyFormat.format(sumIncludeVatAmt));
				}
				if(sumWHTAmt != null){ 
					//hssfRow.createCell((short)10).setCellValue(new HSSFRichTextString(currencyFormat.format(sumWHTAmt)));
					setExcelStyle(cellStyle, hssfRow, (short)10, currencyFormat.format(sumWHTAmt));
				}
//				hssfRow.createCell((short)13).setCellValue(new HSSFRichTextString(""));
//				hssfRow.createCell((short)14).setCellValue(new HSSFRichTextString(""));
//				hssfRow.createCell((short)15).setCellValue(new HSSFRichTextString(""));
//				hssfRow.createCell((short)16).setCellValue(new HSSFRichTextString(""));
//				hssfRow.createCell((short)17).setCellValue(new HSSFRichTextString(""));
//				hssfRow.createCell((short)18).setCellValue(new HSSFRichTextString(""));
				
				hssfSheet.autoSizeColumn((short)0);
				hssfSheet.autoSizeColumn((short)1);
				hssfSheet.autoSizeColumn((short)2);
				hssfSheet.autoSizeColumn((short)3);
				hssfSheet.autoSizeColumn((short)4);
				hssfSheet.autoSizeColumn((short)5);
				hssfSheet.autoSizeColumn((short)6);
				hssfSheet.autoSizeColumn((short)7);
				hssfSheet.autoSizeColumn((short)8);
				hssfSheet.autoSizeColumn((short)9);
				hssfSheet.autoSizeColumn((short)10);
//				hssfSheet.autoSizeColumn((short)11);
//				hssfSheet.autoSizeColumn((short)12);
//				hssfSheet.autoSizeColumn((short)13);
//				hssfSheet.autoSizeColumn((short)14);
//				hssfSheet.autoSizeColumn((short)15);
//				hssfSheet.autoSizeColumn((short)16);
//				hssfSheet.autoSizeColumn((short)17);
//				hssfSheet.autoSizeColumn((short)18);
			}
		}
		
	}

	public String doPrintChq(){
		
		try{
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/resources/el/ChequeReceived.xml")));
			
			HttpServletResponse res = FacesUtils.getInstance().getHttpResponse();
			res.setCharacterEncoding("UTF-8");
			res.setContentType("application/vnd.ms-word");   
			res.setHeader("Content-disposition",  "attachment;filename=Cheque Received.doc");
	      
	        ServletOutputStream out = res.getOutputStream();   
	        
	        String temp = reader.readLine();
	        
	        while(temp != null){
	        	
	        	out.write(temp.getBytes());
	        	
	        	temp = reader.readLine();
	        }
	        
	        reader.close();
	        out.flush();
	        out.close();
	        
	        FacesContext faces = FacesContext.getCurrentInstance();   
	        faces.responseComplete();
	        
		}catch(Exception e){
			
			e.printStackTrace();
			
			addMessageError("EL0000", "SEMMEL008");
		}

		return "login_pass";
	}
	
	public String doPrintTransfer(){
		
		try{
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/resources/el/TransferReceived.xml")));
			
			HttpServletResponse res = FacesUtils.getInstance().getHttpResponse();   
			res.setCharacterEncoding("TIS-620");
			res.setContentType("application/vnd.ms-word");   
			res.setHeader("Content-disposition",  "attachment;filename=Transfer Received.doc");
	      
	        ServletOutputStream out = res.getOutputStream();   
	        
	        String temp = reader.readLine();
	        
	        while(temp != null){
	        	
	        	out.write(temp.getBytes());
	        	
	        	temp = reader.readLine();
	        }
	        
	        reader.close();
	        out.flush();
	        out.close();
	        
	        FacesContext faces = FacesContext.getCurrentInstance();   
	        faces.responseComplete();
	        
		}catch(Exception e){
			
			e.printStackTrace();
			
			addMessageError("EL0000", "SEMMEL008");
		}

		return "login_pass";
	}
	
	public void doOpenReject(){
		
		SEMMEL008Bean semmel008Bean = getSEMMEL008Bean();
		
		try{
		
			// get selectePayments
			List<Payment> selectedPayments = new ArrayList<Payment>();
			if(semmel008Bean.getPaymentWrapperList()!=null && semmel008Bean.getPaymentWrapperList().size()>0){
				for(PaymentWrapper wrapper : semmel008Bean.getPaymentWrapperList()){
					if(wrapper.isSelected()){
						List<Payment> paymentList = wrapper.getPaymentList();
						for(Payment payment : paymentList){
							selectedPayments.add(payment);
						}
					}
				}
			}
			
			//WT###Edit 20110121 Start
			String cancelPaymentStatus = ParameterConfigUtil.getInstance().getConfigByCode(EL_REJECT_PAYMENT_STATUS);
			String[] cancelPaymentStatusArr = cancelPaymentStatus.split("\\|");
			LOG.debug("WT### cancelPaymentStatus="+cancelPaymentStatus);
			LOG.debug("wT### cancelPaymentStatusArr length="+cancelPaymentStatusArr.length);
			
			boolean isError = true;
			
			// validate
			for(Payment payment : selectedPayments){
				
				//if(payment.getPaymentStatus() == null || !payment.getPaymentStatus().equals(PAYMENT_STATUS_02)){
				if(payment.getPaymentStatus() != null){
					for(int i=0; i<cancelPaymentStatusArr.length; i++){
						if(payment.getPaymentStatus().equals(cancelPaymentStatusArr[i])){
							isError = false;
						}
					}
					
					if(isError){
						semmel008Bean.setMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0030"));
						semmel008Bean.setVisibleCancelBtn(false);
						semmel008Bean.setVisibleSaveBtn(false);
						semmel008Bean.setVisibleOkBtn(true);
						
						return;
					}
				}
			}
			
			semmel008Bean.setMessage(null);
			semmel008Bean.setSelectedPayments(selectedPayments);
			semmel008Bean.setSelectedPayment(selectedPayments.get(0));
			semmel008Bean.getSelectedPayment().setRejectReason(null);
			semmel008Bean.setVisibleCancelBtn(true);
			semmel008Bean.setVisibleSaveBtn(true);
			semmel008Bean.setVisibleOkBtn(false);
		
		}catch(Exception e){
			
			e.printStackTrace();
			
			addMessageError("EL0000", "SEMMEL008");
			
			semmel008Bean.setVisibleOkBtn(true);
		}
	}
	
	public void doSaveReject(){
		
		SEMMEL008Bean semmel008Bean = getSEMMEL008Bean();
		
		try{
			
			Payment selectedPayment = semmel008Bean.getSelectedPayment();
			StringBuffer peymentIdArr = selectedPaymentId(semmel008Bean);
//			List<Payment> selectedPayments = semmel008Bean.getSelectedPayments();
//			
//			// update payment
//			SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
//			String plRejectCancelName = ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.EL_PG_DISBURSED_D004);
//			
//			LOG.debug("WT### doSaveReject=");
			
//			for(Payment payment : selectedPayments){
//				
//				payment.setPaymentStatus(PAYMENT_STATUS_04);
//				payment.setRejectStatus(SEMMEL001Util.Y);
//				payment.setRejectReason(selectedPayment.getRejectReason());
//				payment.setUpdateBy(ssoBean.getUserName());
//				payment.setCurrentUser(ssoBean.getUserName());
//				payment.setUpdateDt(Calendar.getInstance().getTime());
//			}
//			
			IPaymentService paymentService = (IPaymentService)getBean("paymentService");
//			paymentService.saveRejectPayment(selectedPayments,plRejectCancelName,ssoBean.getUserName());
			
			MEL008Act el008Act = new MEL008Act();
			el008Act.setPaymentId(peymentIdArr.toString());
			el008Act.setActionType("CA");
			el008Act.setUserLogin(getUserLogIn());
			el008Act.setRemark(selectedPayment.getRejectReason());
			List<MEL008Act> resultSend = paymentService.querySPList(EQueryName.SP_MEL008_ACT.name, el008Act);
			
		
			// update resultTable
			doSearch();
			
			addMessageInfo("M0001");
			
		}catch(Exception e){
			
			e.printStackTrace();
			
			addMessageError("EL0000", "SEMMEL008");
		}
	}
	
	public void doUpdateResultTable(){
		
		try{
			
			doSearch();
		
		}catch(Exception e){
			
			e.printStackTrace();
			
			addMessageError("EL0000", "SEMMEL008");
		}
	}
	
	public void doChangePayInFlag(){
		
		SEMMEL008Bean semmel008Bean = getSEMMEL008Bean();
		
		Payment selectedPayment = semmel008Bean.getSelectedPayment();
		
		if(selectedPayment.isCrPayInFlagBoolean()){
			
			selectedPayment.setCrBankName(null);
			selectedPayment.setCrPayInDt(null);
		}
	}
	
	// --- private ---
	private SEMMEL008Bean getSEMMEL008Bean(){
		
		SEMMEL008Bean bean = (SEMMEL008Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(BEAN_SEMMEL008);
		
		if(bean == null){
			
			bean = new SEMMEL008Bean();
			
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(BEAN_SEMMEL008, bean);
		}
		
		return bean;
	}
	
	private boolean doSearch() throws Exception{
		LOG.info("START Action doSearch");
		UUID uuid = UUID.randomUUID();
		long startTime = System.currentTimeMillis();
		long endTime = System.currentTimeMillis();
		
		SEMMEL008Bean semmel008Bean = getSEMMEL008Bean();
		
		Payment searchCriteria = semmel008Bean.getSearchCriteria();
		
		searchCriteria.setSiteType(semmel008Bean.isSiteType() ? "Y" : "");
		
		PaymentSP sp = new PaymentSP();
		if(!semmel008Bean.isRenderedOnToDoList()){
			if(!doValidateSearch(searchCriteria)) return false;
			//LOG.info("searchCriteria.getChqNo():"+searchCriteria.getChqNo());
			
			if(StringUtils.isNotEmpty(searchCriteria.getChqNo())){
				String chqNo = searchCriteria.getChqNo()+"*";
				searchCriteria.setChqNo(chqNo);
			}
			
//			PaymentSP sp = new PaymentSP();
			sp.setContractNo(searchCriteria.getContractNo());
			sp.setCompany(searchCriteria.getCompany());
			sp.setSiteName(searchCriteria.getSiteName());
			sp.setElectricUseType(searchCriteria.getElectricUseType());
			sp.setRegion(searchCriteria.getRegion());
			sp.setVendorId(searchCriteria.getVendorId());
			sp.setVendorName(searchCriteria.getVendorName());
			sp.setPayeeName(searchCriteria.getPayeeName());
			sp.setDocNo(searchCriteria.getDocNo());
			sp.setExpenseType(searchCriteria.getExpenseType());
			sp.setPaymentStatus(searchCriteria.getPaymentStatus());
			sp.setPaymentType(searchCriteria.getPaymentType());
			sp.setTransferDt(searchCriteria.getTransferDt());
			sp.setChqPostingDt(searchCriteria.getChqPostingDt());
			sp.setChqReceivedDt(searchCriteria.getChqReceivedDt());
			sp.setpCreateBy(searchCriteria.getCreateBy());
			sp.setCreateDate(searchCriteria.getCreateDt());
			sp.setSentPaymentDt(searchCriteria.getSentPaymentDt());
			sp.setBatchNo(searchCriteria.getBatchNo());
			sp.setDoc92(searchCriteria.getDoc92());
			sp.setDoc68(searchCriteria.getDoc68());
			sp.setChqNo(searchCriteria.getChqNo());
			sp.setSiteType(searchCriteria.getSiteType());
			sp.setOrderBy(searchCriteria.getOrderBy());
			
//			sp.setElCondSubType(searchCriteria.getElCondSubType());
			sp.setLocationId(searchCriteria.getLocationId());
			sp.setLocationCode(searchCriteria.getLocationCode());
			sp.setSiteCode(searchCriteria.getSiteCode());
			sp.setService(searchCriteria.getServiceType());
			sp.setPeriodStartDt(searchCriteria.getPeriodStartDt());
			sp.setPeriodEndDt(searchCriteria.getPeriodEndDt());
			sp.setServiceType(searchCriteria.getServiceType());
		}else{
			if(StringUtils.isEmpty(searchCriteria.getStrParam())){
				addMessageError("SEMMEL008Action P_PARAMETER is null");
				return false;
			}else
				sp.setStrParam(searchCriteria.getStrParam());
		}
		
		
		
		// fixed by.. YUT 2014/09/16
		sp.setRcptPayFlag((semmel008Bean.isChkRcptPay()) ? "Y" : "N");
		
		// call service
//		IPaymentService paymentService = (IPaymentService)getBean("paymentService");
//		List<Payment> paymentList = paymentService.querySEMMEL008PaymentByCriteria(searchCriteria);
//		List<PaymentSP> paymentSPList = paymentService.querySPList(EQueryName.SP_MEL008_SEARCH.name, sp);
		
		LOG.info("call SEM_SP_MEL008_SRCH(?,:"+sp.getCompany()+", :"+sp.getContractNo()+", :"+sp.getSiteName()+", :"+sp.getElectricUseType()+", :"+sp.getRegion()+", :"+sp.getVendorId()+", :"+sp.getVendorName()+", :"
		       +sp.getPayeeName()+", :"+sp.getDocNo()+", :"+sp.getExpenseType() +", :"+sp.getPaymentStatus()+", :"+sp.getPaymentType()+", :"+sp.getTransferDt()+", :"+sp.getChqPostingDt()+", :"
				+sp.getChqReceivedDt()+", :"+sp.getpCreateBy()+", :"+sp.getCreateDate()+", :"+sp.getSentPaymentDt()+", :"+sp.getBatchNo()+", :"+sp.getDoc92()+", :"+sp.getDoc68()+", :"+sp.getChqNo()+", :"
		        +sp.getSiteType()+", :"+sp.getOrderBy()+", :"+sp.getRcptPayFlag()+", :"+sp.getLocationId()+", :"+sp.getLocationCode()+", :"+sp.getSiteCode()+", :"+sp.getPeriodStartDt()+", :"+sp.getPeriodEndDt()+", :"
				+sp.getService()+", :"+sp.getStrParam() +")");
		
		List<Payment> paymentList = queryPayment(sp);
		List<Payment> resultList = new ArrayList<Payment>();
		
		for(Payment payment : paymentList){
			payment.getPaymentDetailList();
			LOG.debug("payment.getRowId() : "+payment.getRowId());
			payment.setExpenseTypeCode(payment.getExpenseType());
//			if(payment.getContract()!=null){
//				if(payment.getContract().getEffectiveDt()!=null){
//					payment.getContract().setEffDt(SEMDataUtility.convertToThYear(payment.getContract().getEffectiveDt()));
//				}
//				if(payment.getContract().getExpireDt()!=null){
//					payment.getContract().setExpDt(SEMDataUtility.convertToThYear(payment.getContract().getExpireDt()));
//				}
//			}
			resultList.add(payment);
		}
		
		if(resultList==null || resultList.size() == 0){
			
			addMessageError("M0004");
		}
		
		semmel008Bean.setPaymentWrapperList(convertToPaymentWrapper(resultList));
		
		// prepare payment status count
		setPaymentStatusCount(semmel008Bean);
		
		semmel008Bean.setCommandButtonEnable(false);
		semmel008Bean.setVisibleEditYesBtnForDepositPrivate10(false);//WT###Add 20110120
		semmel008Bean.setChkSelAll(false);
		
		
		LOG.info("END Action doSearch");
		return true;
	}
	
	private boolean doClear(){
		
		SEMMEL008Bean semmel008Bean = getSEMMEL008Bean();
		
		semmel008Bean.setSearchCriteria(new Payment());
		semmel008Bean.setSiteType(false);
		semmel008Bean.setCompanyBigLabel(null);
		semmel008Bean.setCommandButtonEnable(false);
		semmel008Bean.setPaymentWrapperList(new ArrayList<PaymentWrapper>());
		
		return false;
	}
	
	private boolean doValidateSearch(Payment searchCriteria){
		
		boolean flag = true;
		
		if(StringUtils.isEmpty(searchCriteria.getContractNo()) && StringUtils.isEmpty(searchCriteria.getVendorName()) 
				&& StringUtils.isEmpty(searchCriteria.getVendorId()) && StringUtils.isEmpty(searchCriteria.getBatchNo())
				&& StringUtils.isEmpty(searchCriteria.getPayeeName()) && StringUtils.isEmpty(searchCriteria.getDocNo())
			    && StringUtils.isEmpty(searchCriteria.getDoc92()) && StringUtils.isEmpty(searchCriteria.getDoc68())
			    && StringUtils.isEmpty(searchCriteria.getChqNo())
			)
		{
			
			if(StringUtils.isEmpty(searchCriteria.getCompany())){
				
				addMessageError("W0001", getMessage("msg.required.company"));
				flag = false;
			}
			
			if(StringUtils.isEmpty(searchCriteria.getElectricUseType())){
				
				addMessageError("W0001", getMessage("msg.required.electricUseType"));
				flag = false;
			}
			
			if(StringUtils.isEmpty(searchCriteria.getPaymentStatus())){
				
				addMessageError("W0001", getMessage("msg.required.paymentStatus"));
				flag = false;
			}
		}
		
		return flag;
	}
	
	private boolean doValidateSaveExpense1(SEMMEL008Bean semmel008Bean){
		
		Payment selectedPayment = semmel008Bean.getSelectedPayment();
		
		boolean flag = true;
		
		if(semmel008Bean.isChqRequired()){
			
			if(selectedPayment.getChqPostingDt() == null){
				
				addMessageError("W0001", getMessage("msg.required.chqPostingDt"));
				flag = false;
			}
			
			if(selectedPayment.getChqReceivedDt() == null){
				
				addMessageError("W0001", getMessage("msg.required.chqReceivedDt"));
				flag = false;
			}
			
		}else{
			
			if(selectedPayment.getTransferDt() == null){
				
				addMessageError("W0001", getMessage("msg.required.transferDt"));
				flag = false;
			}
		}
		
		return flag;
	}
	
	private boolean doValidateSaveExpense2(SEMMEL008Bean semmel008Bean){
		
		Payment selectedPayment = semmel008Bean.getSelectedPayment();
		
		boolean flag = true;
		
		if(!selectedPayment.isCrPayInFlagBoolean()){
			
			if(StringUtils.isEmpty(selectedPayment.getCrBankName())){
				
				addMessageError("W0001", getMessage("msg.required.crBankName"));
				flag = false;
			}
			
			if(selectedPayment.getCrPayInDt() == null){
				
				addMessageError("W0001", getMessage("msg.required.crPayInDt"));
				flag = false;
			}
		}
		
		return flag;
	}
	
	private List<Payment> doValidateCollective(SEMMEL008Bean semmel008Bean) throws Exception{
		
		// validate wrapper
		String companyName = null;
		String vendorId = null;
		String payeeId = null;
		String paymentType = null;
		String chqPostingDt = "";
		String chqReceivedDt = "";
		String transferDt = "";
		
		List<PaymentWrapper> selectedPaymentWrappers = semmel008Bean.getPaymentWrapperList();
		for(PaymentWrapper wrapper : selectedPaymentWrappers){
			
			if(wrapper.isSelected()){
				
				// valid only single payment
				if(wrapper.getPaymentList().size() > 1){
					
					semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0023"), ""));
					
					System.out.println("-----------------------------------------------");
					
					return null;
				}
			}
		}
		
//		List<Payment> selectedPayments = getSelectedPaymentFromDatabase(semmel008Bean); 
		
		List<Payment> selectedPayments = semmel008Bean.getSelectedPayments();
		
		
		if(selectedPayments.size() == 0 || selectedPayments.size() == 1){
			
			semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0023"), ""));
			
			return null;
		}
		
		// validate status
		int elBillCount = 0;
		int elPostPaidCount = 0;
		int elDebitCount = 0;
		int elCreditCount = 0;
		int elTempCount = 0;
		int prPostPaidCount = 0;
		int prDebitCount = 0;
		int prCreditCount = 0;
		int prPrepaidCount = 0;
		int depositCount = 0;
		int feeCount = 0;
		int otherCount = 0;
		int totalCount = 0;
		
		for(Payment payment : selectedPayments){
			
			// validate company
			//System.out.println("1:"+payment.getCompany() );
			
			if(companyName != null && !companyName.equals(payment.getCompany())){
				
				semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0023"), ""));
				
				System.out.println("Error Company:"+payment.getCompany() );
				
				return null;
				
			}else{
				
				companyName = payment.getCompany();
			}
			
			// validate vendorId
			
			//System.out.println("2:"+payment.getVendorId() );
			if(vendorId != null && !vendorId.equals(payment.getVendorId())){
				
				semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0023"), ""));
				
				System.out.println("ERROR VendorId :"+payment.getVendorId() );
				
				return null;
				
			}else{
				
				vendorId = payment.getVendorId();
			}
			
			// validate payeeId
			//System.out.println("3:"+payment.getPayeeId() );
			if(payeeId != null && !payeeId.equals(payment.getPayeeId())){
				
				semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0023"), ""));
				System.out.println("ERROR getPayeeId:"+payment.getPayeeId() );
				
				return null;
				
			}else{
				
				payeeId = payment.getPayeeId();
			}
			
			 // validate paymentType
			//System.out.println("4:"+payment.getPaymentType() );
			
			if(paymentType != null && !paymentType.equals(payment.getPaymentType())){
				
				semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0023"), ""));
				
				System.out.println("Error getPaymentType:"+payment.getPaymentType() );
				
				return null;
				
			}else{
				
				paymentType = payment.getPaymentType();
			}
			
			// validate dates
			//System.out.println("5:"+payment.getChqPostingDt() );
			
			if(payment.getPaymentType().equals(PAYMENT_METHOD_CHQ)){
				
				// chqPostingDt
				if(chqPostingDt == null){
//				if(StringUtils.isEmpty(chqPostingDt)){
					if(payment.getChqPostingDt() != null){
						
						semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0023"), ""));
						
						//System.out.println("6");
						System.out.println("Error chqPostingDt 1:"+payment.getChqPostingDt() );
						
						return null;
					}
					
				}else{
					
					if(chqPostingDt.trim().length() > 0){
						
						if(payment.getChqPostingDt() == null || !chqPostingDt.equals(exportFormat.format(payment.getChqPostingDt()))){
							
							semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0023"), ""));
							
							System.out.println("Error chqPostingDt 2:"+payment.getChqPostingDt() );
							
							return null;
						}
						
					}else{
						if(null!=payment.getChqPostingDt()){
							chqPostingDt = exportFormat.format(payment.getChqPostingDt());
						}					
					}
				}
				
				// chqReceivedDt
				//System.out.println("5:"+payment.getChqReceivedDt() );
				if(chqReceivedDt == null){
//				if(StringUtils.isEmpty(chqReceivedDt)){
					if(payment.getChqReceivedDt() != null){
						
						semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0023"), ""));
						
						System.out.println("getChqReceivedDt 1:"+payment.getChqReceivedDt() );
						
						return null;
					}
					
				}else{
					
					if(chqReceivedDt.trim().length() > 0){
						
						if(payment.getChqReceivedDt() == null || !chqReceivedDt.equals(exportFormat.format(payment.getChqReceivedDt()))){
							
							semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0023"), ""));
						
							System.out.println("getChqReceivedDt 2:"+payment.getChqReceivedDt() );
							
							return null;
						}
						
					}else{
						
						//if(payment != null){
							if(null!=payment.getChqReceivedDt()){
								chqReceivedDt = exportFormat.format(payment.getChqReceivedDt());
							}
						//}
					}
				}
				//System.out.println("6:"+payment.getCompany() );	
			}else if(payment.getPaymentType().equals(PAYMENT_METHOD_TRANSFER)){
				
				// transferDt
				if(transferDt == null){
//				if(StringUtils.isEmpty(transferDt)){
					if(payment.getTransferDt() != null){
						
						semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0023"), ""));
						
						System.out.println("transferDt:1");
						
						return null;
					}
					
				}else{
					
					if(transferDt.trim().length() > 0){
						
						if(payment.getTransferDt() == null || !transferDt.equals(exportFormat.format(payment.getTransferDt()))){
							
							semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0023"), ""));
						
							System.out.println("transferDt:2");
						
							return null;
						}
						
					}else{
						if(null!=payment.getTransferDt()){
							transferDt = exportFormat.format(payment.getTransferDt());
						}
					}
				}
			}
			
			// status
			//WT###Edit 20110121 Start
			String cancelPaymentStatus = ParameterConfigUtil.getInstance().getConfigByCode(EL_COLLECT_PAYMENT_STATUS);
			String[] cancelPaymentStatusArr = cancelPaymentStatus.split("\\|");
			LOG.debug("WT### cancelPaymentStatus="+cancelPaymentStatus);
			LOG.debug("wT### cancelPaymentStatusArr length="+cancelPaymentStatusArr.length);
			
			boolean isError = true;
			//if(payment.getPaymentStatus() == null || !payment.getPaymentStatus().equals(PAYMENT_STATUS_01)){
			if(payment.getPaymentStatus() != null){
				
				for(int i=0; i<cancelPaymentStatusArr.length; i++){
					if(payment.getPaymentStatus().equals(cancelPaymentStatusArr[i])){
						isError = false;
					}
				}
				
				if(isError){					
					semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0023"), ""));					
					System.out.println("PaymentStatus");					
					return null;
				}
			}
			//WT###Edit 20110121 ENd
			
			// expenseType
			if(payment.getExpenseType() == null){
				
				semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0023"), ""));
				
				System.out.println("ExpenseType");
				
				return null;
			}
			
			
			if(payment.getExpenseType().equals(EXPENSE_TYPE_EL_BILL)|| payment.getExpenseType().equals(EXPENSE_TYPE_EL_POSTPAID) ){
				elBillCount++;
			}
			else if(payment.getExpenseType().equals(EXPENSE_TYPE_EL_POSTPAID) || payment.getExpenseType().equals(EXPENSE_TYPE_EL_BILL)){
				elPostPaidCount++;
			}
			else if(payment.getExpenseType().equals(EXPENSE_TYPE_EL_DEBIT)) elDebitCount++;
			else if(payment.getExpenseType().equals(EXPENSE_TYPE_EL_CREDIT)) elCreditCount++;
			else if(payment.getExpenseType().equals(EXPENSE_TYPE_EL_TEMP)) elTempCount++;
			else if(payment.getExpenseType().equals(EXPENSE_TYPE_PR_POSTPAID)) prPostPaidCount++;
			else if(payment.getExpenseType().equals(EXPENSE_TYPE_PR_DEBIT)) prDebitCount++;
			else if(payment.getExpenseType().equals(EXPENSE_TYPE_PR_CREDIT)) prCreditCount++;
			else if(payment.getExpenseType().equals(EXPENSE_TYPE_PR_PREPAID)) prPrepaidCount++;
			else if(payment.getExpenseType().equals(EXPENSE_TYPE_DEPOSIT)) depositCount++;
			else if(payment.getExpenseType().equals(EXPENSE_TYPE_FEE_SURVEY)) feeCount++;
			else if(payment.getExpenseType().equals(EXPENSE_TYPE_FEE_METER)) feeCount++;
			else if(payment.getExpenseType().equals(EXPENSE_TYPE_FEE_EXPAND)) feeCount++;
			else if(payment.getExpenseType().equals(EXPENSE_TYPE_FEE_OTHER)) feeCount++;
			else if(payment.getExpenseType().equals(EXPENSE_TYPE_FEE)) feeCount++;
			else otherCount++;
			
			
			
			totalCount++;
		}
		
		if(otherCount > 0){
			
			semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0023"), ""));
			
			System.out.println("otherCount");
			
			return null;
		}
		
		// EL_BILL
		if(elBillCount > 0 && totalCount - elBillCount > 0){
			
			semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0023"), ""));
			
			System.out.println("elBillCount");
			
			return null;
		}
		
		// EL_TEMP
		if(elTempCount > 0 && totalCount - elTempCount > 0){
			
			semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0023"), ""));;
			
			System.out.println("elTempCount");
			
			return null;
		}
		
		// PR_PREPAID
		if(prPrepaidCount > 0 && totalCount - prPrepaidCount > 0){
			
			semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0023"), ""));
			
			System.out.println("prPrepaidCount");
			
			return null;
		}
		
		// DEPOSIT
		if(depositCount > 0 && totalCount - depositCount > 0){
			
			semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0023"), ""));
			
			System.out.println("depositCount");
			
			return null;
		}
		
		// FEE_SURVEY, FEE_METER, FEE_EXPAND, and FEE_OTHER
		if(feeCount > 0 && totalCount - feeCount > 0){
			
			semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0023"), ""));
			
			System.out.println("feeCount");
			
			return null;
		}
		
		// EL_POSTPAID
		if(elPostPaidCount > 0){
			
			if(totalCount - elPostPaidCount - elCreditCount - elDebitCount > 0){
				
				semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0023"), ""));
				
				System.out.println("elPostPaidCount");
				
				return null;
			}
			
			if(elCreditCount > 1){
				
				semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0023"), ""));
				
				System.out.println("22");
				
				return null;
			}
			
			if(elCreditCount == 1 && (elPostPaidCount > 1 || elDebitCount > 0)){
				
				semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0023"), ""));
				
				System.out.println("23");
				
				return null;
			}
		}
		
		// PR_POSTPAID
		if(prPostPaidCount > 0){
			
			if(totalCount - prPostPaidCount - prCreditCount - prDebitCount > 0){
				
				semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0023"), ""));
				
				System.out.println("prPostPaidCount:1");
				
				return null;
			}
			
			if(prCreditCount > 1){
				
				semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0023"), ""));
				
				System.out.println("prPostPaidCount:2");
				
				return null;
			}
			
			if(prCreditCount == 1 && (prPostPaidCount > 1 || prDebitCount > 0)){
				
				semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0023"), ""));
				
				System.out.println("prPostPaidCount:3");
				
				return null;
			}
		}
		
		return selectedPayments;
	}
	
	private void setPaymentStatusCount(SEMMEL008Bean semmel008Bean) throws Exception{
		
		// call service
		IPaymentService paymentService = (IPaymentService)getBean("paymentService");
		
		int paymentStatus01Int = 0;
		//WT###Edit 20110421 Start
		//Object paymentStatus01 = paymentService.queryPaymentStatusCount("01");
		Payment criteria = semmel008Bean.getSearchCriteria();
		String paymentStatus = criteria.getPaymentStatus();
		criteria.setRecordStatus("Y");
		if(criteria!=null){
			criteria.setPaymentStatus("01");	
		}		
		Object paymentStatus01 = paymentService.queryPaymentStatusCountByCriteria(criteria);
		//WT###Edit 20110421 End		
		if(paymentStatus01 != null){
			
			// maybe Integer or Long
			if(paymentStatus01 instanceof Integer) paymentStatus01Int = ((Integer)paymentStatus01).intValue();
			else if(paymentStatus01 instanceof Long) paymentStatus01Int = ((Long)paymentStatus01).intValue();
		}
		
		int paymentStatus02Int = 0;
		//WT###Add 20110421 Start
		//Object paymentStatus02 = paymentService.queryPaymentStatusCount("02");
		if(criteria!=null){
			criteria.setPaymentStatus("02");	
		}	
		Object paymentStatus02 = paymentService.queryPaymentStatusCountByCriteria(criteria);
		if(paymentStatus02 != null){
			
			// maybe Integer or Long
			if(paymentStatus02 instanceof Integer) paymentStatus02Int = ((Integer)paymentStatus02).intValue();
			else if(paymentStatus02 instanceof Long) paymentStatus02Int = ((Long)paymentStatus02).intValue();
		}
		criteria.setPaymentStatus(paymentStatus);
		//WT###Add 20110421 End
		
		semmel008Bean.setPayment01Count(paymentStatus01Int);
		semmel008Bean.setPayment02Count(paymentStatus02Int);
		semmel008Bean.setPayment0102Count(paymentStatus01Int + paymentStatus02Int);
	}
	
	private void doInitCancelPayment(SEMMEL008Bean semmel008Bean){
		
//		List<Payment> selectedPayments = semmel008Bean.getSelectedPayments();
		try{
			List<Payment> selectedPayments = new ArrayList<Payment>();
			if(semmel008Bean.getPaymentWrapperList()!=null && semmel008Bean.getPaymentWrapperList().size()>0){
				for(PaymentWrapper wrapper : semmel008Bean.getPaymentWrapperList()){
					if(wrapper.isSelected()){
						List<Payment> paymentList = wrapper.getPaymentList();
						for(Payment payment : paymentList){
							selectedPayments.add(payment);
						}
					}
				}
			}
			semmel008Bean.setSelectedPayments(selectedPayments);
			
			//WT###Add 20110121 Start
			String cancelPaymentStatus = ParameterConfigUtil.getInstance().getConfigByCode(EL_CANCEL_PAYMENT_STATUS);
			String[] cancelPaymentStatusArr = cancelPaymentStatus.split("\\|");
			
			LOG.debug("WT### doInitCancelPayment=");
			LOG.debug("wT### cancelPaymentStatusArr length="+cancelPaymentStatusArr.length);
			boolean isError = true;
			//WT###Add 20110121 End
			
			//WT###Edit 20110121 Start
			// validate
			for(Payment payment : selectedPayments){
				isError = true;
				//if(payment.getPaymentStatus() == null || !payment.getPaymentStatus().equals(PAYMENT_STATUS_01)){
				LOG.debug("WT###Print payment.getPaymentStatus()="+payment.getPaymentStatus());
				if(payment.getPaymentStatus() != null){
					for(int i=0; i<cancelPaymentStatusArr.length; i++){
						if(payment.getPaymentStatus().equals(cancelPaymentStatusArr[i])){
							isError = false;
						}
					}
				}
			}
			
			if(isError){
				semmel008Bean.setMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0022"));
				semmel008Bean.setVisibleOkBtn(true);
				return;
			}
			//WT###Edit 20110121 End
			
			semmel008Bean.setMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0004"));
			semmel008Bean.setVisibleCancelPaymentYesBtn(true);
			semmel008Bean.setVisibleNoBtn(true);
			semmel008Bean.setVisibleOkBtn(false);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void doAcceptPayment(SEMMEL008Bean semmel008Bean) throws Exception{
		
//		List<Payment> selectedPayments = semmel008Bean.getSelectedPayments();
		StringBuffer peymentIdArr = selectedPaymentId(semmel008Bean);
		List<Payment> selectedPayments = semmel008Bean.getSelectedPayments();
		
		//WT###Edit 20110121 Start
		String cancelPaymentStatus = ParameterConfigUtil.getInstance().getConfigByCode(EL_APPROVE_PAYMENT_STATUS);
		String[] cancelPaymentStatusArr = cancelPaymentStatus.split("\\|");
		LOG.debug("WT### doAcceptPayment=");
		LOG.debug("WT### cancelPaymentStatus="+cancelPaymentStatus);
		LOG.debug("wT### cancelPaymentStatusArr length="+cancelPaymentStatusArr.length);
		boolean isError = true;
		
		// validate
		for(Payment payment : selectedPayments){
			
			//if(payment.getPaymentStatus() == null || !payment.getPaymentStatus().equals(PAYMENT_STATUS_02)){
			if(payment.getPaymentStatus() != null){
				
				if(payment.getPaymentStatus() != null){
					LOG.debug("PAYMENT STATUS :"+payment.getPaymentStatus());
					for(int i=0; i<cancelPaymentStatusArr.length; i++){
						if(payment.getPaymentStatus().equals(cancelPaymentStatusArr[i])){
							isError = false;
						}
					}
				}
				
				if(isError){
					semmel008Bean.setMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0029"));
					semmel008Bean.setVisibleOkBtn(true);
					
					return;
				}
				
			}
		}
		//WT###Edit 20110121 End
		
		// prepare payNo and plName
		String payNo = java.util.UUID.randomUUID().toString();
//		ParameterConfig plName = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_DISBURSED_D002");
//		
//		// update payment
//		SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
		
//		for(Payment payment : selectedPayments){
//			
//			payment.setPaymentStatus(PAYMENT_STATUS_03);
//			payment.setSentPaymentDt(Calendar.getInstance().getTime());
//			payment.setUpdateBy(ssoBean.getUserName());
//			payment.setCurrentUser(ssoBean.getUserName());
//			payment.setUpdateDt(Calendar.getInstance().getTime());
//			payment.setPayNo(payNo);
//		}
		
		IPaymentService paymentService = (IPaymentService)getBean("paymentService");
//		paymentService.savePaymentForSEMMEL008(selectedPayments, plName.getParamValue(), payNo);
		
		MEL008Act el008Act = new MEL008Act();
		el008Act.setPaymentId(peymentIdArr.toString());
		el008Act.setActionType("AA");
		el008Act.setUserLogin(getUserLogIn());
		el008Act.setPayNo(payNo);
		List<MEL008Act> resultSend = paymentService.querySPList(EQueryName.SP_MEL008_ACT.name, el008Act);
		
//		semmel008Bean.setMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0028"));
		if(resultSend != null){
			if(StringUtils.equals("success", resultSend.get(0).getpResult().toLowerCase())){
				semmel008Bean.setStyleClassName("ms7");
			}else{
				semmel008Bean.setStyleClassName("ms7red");
			}
			semmel008Bean.setMessage(resultSend.get(0).getpBatchNo());
		}else
			semmel008Bean.setMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0028"));
		semmel008Bean.setVisibleOkBtn(true);
		resultSend = null;
	}
	
	private synchronized void doCancelSend(SEMMEL008Bean semmel008Bean){
		LOG.debug("===== doCancelSend ======");
		try{
//			List<Payment> selectedPayments = getSelectedPaymentFromDatabase(semmel008Bean);
//			List<Payment> selectedPayments = semmel008Bean.getSelectedPayments();
//			SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
			StringBuffer peymentIdArr = selectedPaymentId(semmel008Bean);
			IPaymentService paymentService = (IPaymentService)getBean("paymentService");
//			for(Payment payment : selectedPayments){
//				payment.setPaymentStatus(PAYMENT_STATUS_01);
//				payment.setBatchNo("");
//				payment.setUpdateBy(ssoBean.getUserName());
//				payment.setCurrentUser(ssoBean.getUserName());
//				payment.setUpdateDt(Calendar.getInstance().getTime());
//			}
//			paymentService.savePayment(selectedPayments);
			
			MEL008Act el008Act = new MEL008Act();
			el008Act.setPaymentId(peymentIdArr.toString());
			el008Act.setActionType("CP");
			el008Act.setUserLogin(getUserLogIn());
			List<MEL008Act> resultSend = paymentService.querySPList(EQueryName.SP_MEL008_ACT.name, el008Act);
			
			semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("M0001"), ""));
			semmel008Bean.setVisibleOkBtn(true);
		}catch (Exception e) {
			e.printStackTrace();
			addMessageError("EL0000", "SEMMEL008");
		}
	}
	
	private synchronized void doSend(SEMMEL008Bean semmel008Bean){
		
		try{
		
//			List<Payment> selectedPayments = getSelectedPaymentFromDatabase(semmel008Bean);
			StringBuffer peymentIdArr = selectedPaymentId(semmel008Bean);
			List<Payment> selectedPayments = semmel008Bean.getSelectedPayments();
			//WT###Edit 20110121 Start
			String cancelPaymentStatus = ParameterConfigUtil.getInstance().getConfigByCode(EL_SENT_PAYMENT_STATUS);
			String[] cancelPaymentStatusArr = cancelPaymentStatus.split("\\|");
			LOG.debug("WT### cancelPaymentStatus="+cancelPaymentStatus);
			LOG.debug("wT### cancelPaymentStatusArr length="+cancelPaymentStatusArr.length);
			StringBuffer selectPaymentId = new StringBuffer();
			boolean isError = false;
			// validate
			for(Payment payment : selectedPayments){
				
				//if(payment.getPaymentStatus() != null && !payment.getPaymentStatus().equals(PAYMENT_STATUS_01)){
				if(payment.getPaymentStatus() != null){
					
					for(int i=0; i<cancelPaymentStatusArr.length; i++){
						
						if(payment.getPaymentStatus().equals(cancelPaymentStatusArr[i]) && !CR_PAYIN_FLAG_Y.equals(payment.getCrPayInFlag())
						   && (EXPENSE_TYP_EL_CREDIT.equals(payment.getExpenseType()) || EXPENSE_TYP_PR_CREDIT.equals(payment.getExpenseType()))){
							isError = true;
							LOG.debug("WT### cancelPaymentStatus="+cancelPaymentStatus);
						}
					}
					
					if(isError){
						semmel008Bean.setMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0080"));
						semmel008Bean.setVisibleOkBtn(true);
						
						return;
					}	
					
				}
				selectPaymentId.append(payment.getRowId()+",");
			}
			//WT###Edit 20110121 End
			
			// update payment
			SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
			
			IPaymentService paymentService = (IPaymentService)getBean("paymentService");
			
			//Call SEM_SP_MEL008_CHK_PAY
			List<MEL008ChkPay> result = new ArrayList<MEL008ChkPay>();
			MEL008ChkPay mel008ChkPay = new MEL008ChkPay();
			mel008ChkPay.setPaymentId(selectPaymentId.toString());
			result = paymentService.querySPList(EQueryName.SP_MEL008_CHK_PAY.name, mel008ChkPay);
			if(result != null && !result.isEmpty()){
				if(StringUtils.equalsIgnoreCase("success", result.get(0).getpResult())){
					// find parameters
//					ParameterConfig plName = ParameterConfigUtil.getInstance().getparameterByCode("EL_FN_BATCH_NO");
//					ParameterConfig param1 = ParameterConfigUtil.getInstance().getparameterByCode("EL_PARAM_BATCH_NO1");
//					ParameterConfig param2 = ParameterConfigUtil.getInstance().getparameterByCode("EL_PARAM_BATCH_NO2");
//					
//					String batchNo = paymentService.queryBatchNo(plName.getParamValue(), param1.getParamValue(), param2.getParamValue());
//					LOG.debug("WT###batchNo="+batchNo);
//					
//					for(Payment payment : selectedPayments){
//						
//						payment.setPaymentStatus(PAYMENT_STATUS_02);
//						payment.setBatchNo(batchNo);
//						payment.setUpdateBy(ssoBean.getUserName());
//						payment.setCurrentUser(ssoBean.getUserName());
//						payment.setUpdateDt(Calendar.getInstance().getTime());
//					}
//					paymentService.savePayment(selectedPayments);
//					
//					// call PL
//					plName = ParameterConfigUtil.getInstance().getparameterByCode("EL_PG_DISBURSED_D001");
//					
//					paymentService.callSendPLForSEMMEL008(plName.getParamValue(), batchNo);
//					//semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0026"), batchNo));//batchNo disappear from this method
//					semmel008Bean.setMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0026")+" Batch No : "+batchNo);
//					semmel008Bean.setMessage2(result.get(0).getpRemark());
//					semmel008Bean.setVisibleOkBtn(true);
//					-------------------------- COMMENT BY NOOM ----------------------------
					
					MEL008Act el008Act = new MEL008Act();
					el008Act.setPaymentId(peymentIdArr.toString());
					el008Act.setActionType("AP");
					el008Act.setUserLogin(getUserLogIn());
					List<MEL008Act> resultSend = paymentService.querySPList(EQueryName.SP_MEL008_ACT.name, el008Act);
					
					
					if(resultSend!=null && resultSend.size()>0){
						if(StringUtils.equals("success", resultSend.get(0).getpResult().toLowerCase())){
							semmel008Bean.setStyleClassName("ms7");
						}else{
							semmel008Bean.setStyleClassName("ms7red");
						}
					semmel008Bean.setMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0026")+" Batch No : "+resultSend.get(0).getpBatchNo());
					semmel008Bean.setMessage2(result.get(0).getpRemark());
					}
					semmel008Bean.setVisibleOkBtn(true);
				}else{
					semmel008Bean.setMessage(result.get(0).getpRemark());
					semmel008Bean.setVisibleOkBtn(true);
				}
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
			
			addMessageError("EL0000", "SEMMEL008");
		}
	}
	
	private void doCancelCollective(SEMMEL008Bean semmel008Bean){
		
		try{
		
			setAlertMessageButtonDisappear(semmel008Bean);
			
			List<PaymentWrapper> selectedWrapper = semmel008Bean.getPaymentWrapperList();
//			List<Payment> selectedPayments = getSelectedPaymentFromDatabase(semmel008Bean); 
//			List<Payment> selectedPayments = semmel008Bean.getSelectedPayments(); should use this > Comment By Noom 09/01/2014
			StringBuffer peymentIdArr = selectedPaymentId(semmel008Bean);
			List<Payment> selectedPayments = semmel008Bean.getSelectedPayments();
			// validate
			for(PaymentWrapper wrapper : selectedWrapper){
				
				if(wrapper.isSelected() && wrapper.getSize() < 2){
					
					semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0024"), ""));
					semmel008Bean.setVisibleOkBtn(true);
					
					return;
				}
			}
			
			//WT###Edit 20110121 Start
			String cancelPaymentStatus = ParameterConfigUtil.getInstance().getConfigByCode(EL_CANCEL_COLLECT_PAYMENT_STATUS);
			String[] cancelPaymentStatusArr = cancelPaymentStatus.split("\\|");
			
			LOG.debug("WT### doCancelCollective="+cancelPaymentStatus);
			LOG.debug("WT### cancelPaymentStatus="+cancelPaymentStatus);
			LOG.debug("wT### cancelPaymentStatusArr length="+cancelPaymentStatusArr.length);
			
			boolean isError = true;
			
			for(Payment payment : selectedPayments){
				
				//if(payment.getPaymentStatus() == null || !payment.getPaymentStatus().equals(PAYMENT_STATUS_01)){
				if(payment.getPaymentStatus() != null){
					for(int i=0; i<cancelPaymentStatusArr.length; i++){
						if(payment.getPaymentStatus().equals(cancelPaymentStatusArr[i])){
							isError = false;
						}
					}
					
					if(isError){
						semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0024"), ""));
						semmel008Bean.setVisibleOkBtn(true);
						
						return;
					}					
					
				}
			}
			//WT###Edit 20110121 End
	
			// update payment
			SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
			
//			for(Payment payment : selectedPayments){
//				
//				payment.setCollectiveDbFlag(SEMMEL001Util.N);
//				payment.setCollectiveDbNo(null);
//				payment.setUpdateBy(ssoBean.getUserName());
//				payment.setCurrentUser(ssoBean.getUserName());
//				payment.setUpdateDt(Calendar.getInstance().getTime());
//			}
//			
//			IPaymentService paymentService = (IPaymentService)getBean("paymentService");
//			paymentService.savePayment(selectedPayments);
		
			IPaymentService paymentService = (IPaymentService)getBean("paymentService");
			MEL008Act el008Act = new MEL008Act();
			el008Act.setPaymentId(peymentIdArr.toString());
			el008Act.setActionType("CG");
			el008Act.setUserLogin(getUserLogIn());
			List<MEL008Act> resultSend = paymentService.querySPList(EQueryName.SP_MEL008_ACT.name, el008Act);
			// update resultTable
//			doSearch();
			
			semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("M0001"), ""));
			
		}catch(Exception e){
			
			e.printStackTrace();
			
			semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0000"), "SEMMEL008"));
		}
		
		semmel008Bean.setVisibleOkBtn(true);
	}
	
	private synchronized void doCollective(SEMMEL008Bean semmel008Bean){
		
		try{
		
			setAlertMessageButtonDisappear(semmel008Bean);
			StringBuffer peymentIdArr = selectedPaymentId(semmel008Bean);
			List<Payment> selectedPayments = doValidateCollective(semmel008Bean);
			
			if(selectedPayments == null){
				
				semmel008Bean.setVisibleOkBtn(true);
				return;
			}
			
			// update payment
//			SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
			
//			for(Payment payment : selectedPayments){
//				
//				payment.setCollectiveDbFlag(SEMMEL001Util.Y);
//				payment.setCollectiveDbNo(String.valueOf(Calendar.getInstance().getTimeInMillis()));			// use timestamp as a collective group
//				payment.setUpdateBy(ssoBean.getUserName());
//				payment.setCurrentUser(ssoBean.getUserName());
//				payment.setUpdateDt(Calendar.getInstance().getTime());
//			}
//			
//			IPaymentService paymentService = (IPaymentService)getBean("paymentService");
//			paymentService.savePayment(selectedPayments);
		
			// update resultTable
			IPaymentService paymentService = (IPaymentService)getBean("paymentService");
			MEL008Act el008Act = new MEL008Act();
			el008Act.setPaymentId(peymentIdArr.toString());
			el008Act.setActionType("AG");
			el008Act.setUserLogin(getUserLogIn());
			el008Act.setCollectiveDbNo(String.valueOf(Calendar.getInstance().getTimeInMillis()));
			List<MEL008Act> resultSend = paymentService.querySPList(EQueryName.SP_MEL008_ACT.name, el008Act);
			
//			doSearch();
			
			semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("M0001"), ""));
			
		}catch(Exception e){
			
			e.printStackTrace();
			
			semmel008Bean.setMessage(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0000"), "SEMMEL008"));
		}
		
		semmel008Bean.setVisibleOkBtn(true);
	}
	
	private void doInitEditPopup(SEMMEL008Bean semmel008Bean) throws Exception{
		
		semmel008Bean.setMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0003"));
		semmel008Bean.setVisibleEditYesBtn(true);
		semmel008Bean.setVisibleNoBtn(true);
		
		Payment selectedPayment = semmel008Bean.getSelectedPayment();
		
		// get payment from database
		IPaymentService paymentService = (IPaymentService)getBean("paymentService");
		selectedPayment = paymentService.queryPaymentByRowId(selectedPayment.getRowId());
		
		String expenseType = selectedPayment.getExpenseType();
		String electricUseType = selectedPayment.getElectricUseType();
		String specialFlag = selectedPayment.getSpecialFlag();
		LOG.debug("WT###Print expenseType="+expenseType);
		LOG.debug("WT###Print electricUseType="+electricUseType);
		
		if(expenseType != null){
			
			semmel008Bean.setTargetPaymentId(selectedPayment.getRowId());
			
			if(expenseType.equals(EXPENSE_TYPE_DEPOSIT)){
				
				if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_MEA) || electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PEA)){
					
					semmel008Bean.setVisibleEditYesBtnForDepositMeaPea(true);
					
				}else if(electricUseType.equals(SEMMEL001Util.ELECTRIC_TYPE_PRIVATE)){
					//WT###Edit20110113 Start
					//semmel008Bean.setVisibleEditYesBtnForDepositPrivate(true);
					if(!PAYMENT_SPECIAL_FLAG_Y.equals(specialFlag)){
						semmel008Bean.setVisibleEditYesBtnForDepositPrivate(true);
					}else{
						semmel008Bean.setVisibleEditYesBtnForDepositPrivate10(true);
						SEMMEL001Bean semmel001Bean = getSEMMEL001Bean();
						semmel001Bean.setComeFromOtherPage(true);
					}
					//WT###Edit20110113 End
				}
				
			}else if(expenseType.equals(EXPENSE_TYPE_FEE_EXPAND) || expenseType.equals(EXPENSE_TYPE_FEE_METER) 
					|| expenseType.equals(EXPENSE_TYPE_FEE_OTHER) || expenseType.equals(EXPENSE_TYPE_FEE_SURVEY) 
					|| expenseType.equals(EXPENSE_TYPE_FEE)){
				System.out.println("WT###Print1111");
				semmel008Bean.setVisibleEditYesBtnForFee(true);
				
			}else if(expenseType.equals(EXPENSE_TYPE_EL_BILL)){
				System.out.println("WT###Print2222");
				semmel008Bean.setVisibleEditYesBtnForElBill(true);
				
			}else if(expenseType.equals(EXPENSE_TYPE_EL_POSTPAID) 
					|| expenseType.equals(EXPENSE_TYPE_EL_DEBIT)){
				System.out.println("WT###Print3333");
				semmel008Bean.setVisibleEditYesBtnForElPostPaid(true);
				
			}else if(expenseType.equals(EXPENSE_TYPE_EL_TEMP)){
				System.out.println("WT###Print4444");
				semmel008Bean.setVisibleEditYesBtnForElTemp(true);
				
			}else if(expenseType.equals(EXPENSE_TYPE_PR_POSTPAID)
					|| expenseType.equals(EXPENSE_TYPE_PR_DEBIT)){
				System.out.println("WT###Print5555");
				semmel008Bean.setVisibleEditYesBtnForPrPostPaid(true);
				
			}else if(expenseType.equals(EXPENSE_TYPE_PR_PREPAID)){
				System.out.println("WT###Print6666");
				semmel008Bean.setVisibleEditYesBtnForPrPrePaid(true);
			}
			else if(expenseType.equals(EXPENSE_TYPE_EL_CREDIT)|| expenseType.equals(EXPENSE_TYPE_PR_CREDIT)){
				System.out.println("<<<<<expenseType:>>>>>>>>>>>><"+expenseType);
				semmel008Bean.setVisibleEditYesBtnForCredit(true);
			}
		}else{
			
			semmel008Bean.setVisibleEditYesBtn(false);
		}
	}
	
	//WT###Add 20110113 Start
	// --- private ---
	private SEMMEL001Bean getSEMMEL001Bean(){
		
		SEMMEL001Bean bean = (SEMMEL001Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(BEAN_SEMMEL001);
		
		if(bean == null){
			
			bean = new SEMMEL001Bean();
			
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(BEAN_SEMMEL001, bean);
		}
		
		return bean;
	}
	//WT###Add 20110113 End
	
	// util
	private List<PaymentWrapper> convertToPaymentWrapper(List<Payment> paymentList){
		
		List<PaymentWrapper> result = new ArrayList<PaymentWrapper>();
		
		if(paymentList != null){
			
			// prepare label maps
			Map<String, String> siteStatusMap = getSiteStatusMap();
			Map<String, String> networkStatusMap = getNetworkStatusMap();
			Map<String, String> expenseTypeMap = getExpenseTypeMap();
			Map<String, String> paymentStatusMap = getPaymentStatusMap();
			Map<String, String> docTypeMap = getDocTypeMap();
			Map<String, String> vatTypeMap = getVatTypeMap();
			Map<String, String> paymentTypeMap = getPaymentTypeMap();
			Map<String, String> paymentMethodMap = getPaymentMethodMap();
			
			Map<String, PaymentWrapper> paymentMap = new HashMap<String, PaymentWrapper>();
			
			// find editableStatusList
			List<String> editableStatusList = new ArrayList<String>();
			
			ParameterConfig editableStatuses = ParameterConfigUtil.getInstance().getparameterByCode("EL_EDIT_PAYMENT_STATUS");
			
			if(editableStatuses != null){
				
				String []temp = editableStatuses.getParamValue().split("[|]");
				
				for(int i=0,j=temp.length;i<j;i++){
					
					editableStatusList.add(temp[i]);
				}
			}
			
			// convert
			for(Payment payment : paymentList){
				
				PaymentWrapper wrapper = null;
				
				String collectiveDbNo = payment.getCollectiveDbNo();
//				Set<PaymentDetail> paymentDetailList = payment.getDetails();
				List<PaymentDetail> paymentDetailList =  payment.getPaymentDetailList();
				String DATE_FORMAT = "dd/MM/yyyy";
			    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT, new Locale("th", "TH"));
			    String month   = "";
			    String vatType = "";
			    
			    //System.out.println("<<<<<Contract No:>>>>>>>>>>>><"+ payment.getContractNo());
			    //System.out.println("<<<<<payment.getRowId():>>>>>>>>>>>><"+ payment.getRowId());
			    
			    
			    for(PaymentDetail objDetail : paymentDetailList){
					
					if(objDetail.getFromTermOfPaymentDt()!=null && objDetail.getToTermOfPaymentDt()!=null){
						month = month+", "+sdf.format(objDetail.getFromTermOfPaymentDt())+" - "+sdf.format(objDetail.getToTermOfPaymentDt());
					}
					
					if(!StringUtils.isEmpty(objDetail.getVatType())){
						vatType = objDetail.getVatType();	
						//payment.setVatType(objDetail.getVatType());	
					}
					//System.out.println("<<<<<objDetail.getVatType():>>>>>>>>>>>><"+ objDetail.getVatType());
					//System.out.println("<<<<<objDetail.getUnitVatType():>>>>>>>>>>>><"+ objDetail.getUnitVatType());
					
				}
			   // System.out.println("<<<<<month.substring(1):>>>>>>>>>>>><"+ month.substring(1));
			    //System.out.println("<<<<<vatType(1):>>>>>>>>>>>><"+ vatType);
			    
			    if(!"".equals(month)){
					
					payment.setMonthDetailDisplay(month.substring(1));
					
				}
			    if(!"".equals(vatType)){
					
			    	payment.setVatType(vatType);
					
				}
			    // verify type
				if(collectiveDbNo !=  null){											// collective type
					
					// verify group
					if(paymentMap.containsKey(collectiveDbNo)){
						
						wrapper = paymentMap.get(collectiveDbNo);
						wrapper.getPaymentList().add(payment);
						
					}else{
						
						List<Payment> temp = new ArrayList<Payment>(1);
						temp.add(payment);
						wrapper = new PaymentWrapper(temp);
						
						paymentMap.put(payment.getCollectiveDbNo(), wrapper);
						result.add(wrapper);
					}
					
				}else{																	// separated type
					
					List<Payment> temp = new ArrayList<Payment>(1);
					temp.add(payment);
					
					wrapper = new PaymentWrapper(temp); 
					result.add(wrapper);
				}
				
				prepareEachPayment(wrapper, payment, siteStatusMap, networkStatusMap, expenseTypeMap, paymentStatusMap, docTypeMap, vatTypeMap, paymentTypeMap, paymentMethodMap, editableStatusList);
			}
		}
		
		return result;
	}
	
	private void prepareEachPayment(PaymentWrapper wrapper, Payment payment, Map<String, String> siteStatusMap, Map<String, String> networkStatusMap, Map<String, String> expenseTypeMap, Map<String, String> paymentStatusMap, Map<String, String> docTypeMap, Map<String, String> vatTypeMap, Map<String, String> paymentTypeMap, Map<String, String> paymentMethodMap, List<String> editableStatusList){
		
		// verify visibleSaveExpenseButton
		if(payment.getExpenseType() != null && payment.getPaymentStatus() != null && payment.getPaymentStatus().equals(PAYMENT_STATUS_01)){
			
			if(!payment.getExpenseType().equals(EXPENSE_TYPE_EL_CREDIT) && !payment.getExpenseType().equals(EXPENSE_TYPE_PR_CREDIT)){
				
				wrapper.setVisibleSaveExpenseButton1(true);
				
			}else{
			
				wrapper.setVisibleSaveExpenseButton2(true);
			}
		}
		
		// verify visibleEditButton
		if(payment.getPaymentStatus() == null || !editableStatusList.contains(payment.getPaymentStatus())){
			
			payment.setEnableEditButton(false);
			
		}else{
			
			payment.setEnableEditButton(true);
		}
		
		// prepare label
//		payment.setSiteStatus(siteStatusMap.get(payment.getSiteStatus()));
//		payment.setNetWorkStatus(networkStatusMap.get(payment.getNetWorkStatus()));
//		payment.setExpenseType(expenseTypeMap.get(payment.getExpenseType()));
//		payment.setPaymentStatus(paymentStatusMap.get(payment.getPaymentStatus()));
//		payment.setDocType(docTypeMap.get(payment.getDocType()));
//		payment.setVatType(vatTypeMap.get(payment.getVatType()));
//		payment.setPaymentType(paymentTypeMap.get(payment.getPaymentType()));
//		payment.setPaymentMethod(paymentMethodMap.get(payment.getPaymentMethod()));
		
		payment.setSiteStatusShow(siteStatusMap.get(payment.getSiteStatus()));
		payment.setNetWorkStatusShow(networkStatusMap.get(payment.getNetWorkStatus()));
		payment.setExpenseTypeShow(expenseTypeMap.get(payment.getExpenseType()));
		payment.setPaymentStatusShow(paymentStatusMap.get(payment.getPaymentStatus()));
		payment.setDocTypeShow(docTypeMap.get(payment.getDocType()));
		payment.setVatTypeShow(vatTypeMap.get(payment.getVatType()));
		payment.setPaymentTypeShow(paymentTypeMap.get(payment.getPaymentType()));
		payment.setPaymentMethodShow(paymentMethodMap.get(payment.getPaymentMethod()));
		
		
		
		
		
		// format date
		if(payment.getDocDt() != null) wrapper.setDocDtLabel(exportFormat.format(payment.getDocDt()));
		if(payment.getChqPostingDt() != null) wrapper.setChqPostingDtLabel(exportFormat.format(payment.getChqPostingDt()));
		if(payment.getChqReceivedDt() != null) wrapper.setChqReceivedDtLabel(exportFormat.format(payment.getChqReceivedDt()));
		if(payment.getTransferDt() != null) wrapper.setTransferDtLabel(exportFormat.format(payment.getTransferDt()));
	}
		
	private Map<String, String> getSiteStatusMap(){
		
		Map<String, String> result = new HashMap<String, String>();
		
		List<SelectItem> list = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_SI_SITE_STATUS.name);
		for(SelectItem sel : list){
			
			result.put((String)sel.getValue(), sel.getLabel());
		}
	
		return result;
	}
		
	private Map<String, String> getNetworkStatusMap(){
		
		Map<String, String> result = new HashMap<String, String>();
		
		List<SelectItem> list = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_NETWORK_STATUS.name);
		for(SelectItem sel : list){
			
			result.put((String)sel.getValue(), sel.getLabel());
		}
	
		return result;
	}
	
	private Map<String, String> getVatTypeMap(){
		
		Map<String, String> result = new HashMap<String, String>();
		
		List<SelectItem> list = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_VAT_TYPE.name);
		for(SelectItem sel : list){
			
			result.put((String)sel.getValue(), sel.getLabel());
		}
	
		return result;
	}
	
	private Map<String, String> getExpenseTypeMap(){
		
		Map<String, String> result = new HashMap<String, String>();
		
		List<SelectItem> list = LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_EXPENSE_TYPE.name);
		for(SelectItem sel : list){
			
			result.put((String)sel.getValue(), sel.getLabel());
		}
	
		return result;
	}
	
	private Map<String, String> getPaymentStatusMap(){
		
		Map<String, String> result = new HashMap<String, String>();
		
		List<SelectItem> list = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_STATUS.name);
		for(SelectItem sel : list){
			
			result.put((String)sel.getValue(), sel.getLabel());
		}
	
		return result;
	}
	
	private Map<String, String> getDocTypeMap(){
		
		Map<String, String> result = new HashMap<String, String>();
		
		List<SelectItem> list = LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_DOC_TYPE.name);
		for(SelectItem sel : list){
			
			result.put((String)sel.getValue(), sel.getLabel());
		}
	
		return result;
	}
	
	private Map<String, String> getPaymentTypeMap(){
		
		Map<String, String> result = new HashMap<String, String>();
		
		List<SelectItem> list = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_TYPE.name);
		for(SelectItem sel : list){
			
			result.put((String)sel.getValue(), sel.getLabel());
		}
	
		return result;
	}
	
	private Map<String, String> getPaymentMethodMap(){
		
		Map<String, String> result = new HashMap<String, String>();
		
		List<SelectItem> list = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
		for(SelectItem sel : list){
			
			result.put((String)sel.getValue(), sel.getLabel());
		}
	
		return result;
	}
	
	private static final ResourceBundle bundle = ResourceBundle.getBundle("resources.el.semmel008-1");
	
	private String getMessage(String key){
		
		return bundle.getString(key);
	}

//	private void setDefaultBankNameAndBankAccount(Payment payment) throws Exception{
//		
//		Management manage = payment.getElectricId();
//		
//		if(manage != null){
//			
//			// get vendorMapPayee
//			VendorMapPayeeEL vmp = new VendorMapPayeeEL();
//			
//			IVendorMapPayeeELService vendorMapPayeeService = (IVendorMapPayeeELService)getBean("vendorMapPayeeELService");
//			vmp = vendorMapPayeeService.queryVendorMapPayeeMasterForCash(CASH_TYPE, SEMMEL001Util.Y, manage.getContractNo());
//			
//			if(vmp.getVendorMasterId() == null){
//				
//				return;
//			}
//			
//			// get bank info
//			if(vmp.getPayeeMasterId() != null){
//				
//				IPayeeBookbankService payeeBookBankService = (IPayeeBookbankService)getBean("payeeBookbankService");
//				List<PayeeBookbank> payeeBookbankList = payeeBookBankService.queryPayeeBookbankByPayeeId(vmp.getPayeeMasterId().getRowId());
//				
//				if(payeeBookbankList.size()>0){
//					
//					PayeeBookbank payeeBookBank = payeeBookbankList.get(0);
//					
//					payment.setBankName(payeeBookBank.getBankAccName());
//					payment.setBankAccount(payeeBookBank.getBankAccNo());
//				}
//				
//			}else{
//				
//				IVendorBookbankService vendorBookBankService = (IVendorBookbankService)getBean("vendorBookbankService");
//				VendorBookbank vendorBookBank = vendorBookBankService.getVendorBookbankByVendorMasterId(vmp.getVendorMasterId().getRowId());
//				
//				payment.setBankName(vendorBookBank.getBankAccName());
//				payment.setBankAccount(vendorBookBank.getBankAccNo());
//			}
//		}
//	}

	private void setAlertMessageButtonDisappear(SEMMEL008Bean semmel008Bean){
		
		semmel008Bean.setVisibleOkBtn(false);
		semmel008Bean.setVisibleEditYesBtn(false);
		semmel008Bean.setVisibleEditYesBtnForDepositMeaPea(false);
		semmel008Bean.setVisibleEditYesBtnForDepositPrivate(false);
		semmel008Bean.setVisibleEditYesBtnForElBill(false);
		semmel008Bean.setVisibleEditYesBtnForElPostPaid(false);
		semmel008Bean.setVisibleEditYesBtnForElTemp(false);
		semmel008Bean.setVisibleEditYesBtnForFee(false);
		semmel008Bean.setVisibleEditYesBtnForPrPostPaid(false);
		semmel008Bean.setVisibleEditYesBtnForPrPrePaid(false);
		semmel008Bean.setVisibleCancelPaymentYesBtn(false);
		semmel008Bean.setVisibleNoBtn(false);
		semmel008Bean.setVisibleExportBtn(false);
		semmel008Bean.setVisibleCancelExportBtn(false);
	}

	private List<Payment> getSelectedPaymentFromDatabase(SEMMEL008Bean semmel008Bean) throws Exception{
		
		IPaymentService paymentService = (IPaymentService)getBean("paymentService");
		
		List<Payment> selectedPayments = new ArrayList<Payment>();
		Set<PaymentDetail> paymentDetail = new HashSet<PaymentDetail>();
		paymentDetail.clear();
//		Set<PaymentDetail> temp = new HashSet<PaymentDetail>();
//		HashSet pdHS = new HashSet();
//		paymentDetail = (Set<PaymentDetail>) new HashSet();
		List<paymentExpExcel> to = new ArrayList<paymentExpExcel>();
		List<SelectItem> paymentMethodList = semmel008Bean.getPaymentMethodList();
		if(paymentMethodList==null || paymentMethodList.size()<=0){
			paymentMethodList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
		}
		
		Payment payment = new Payment();
		payment.setRowId(selectedPaymentId(semmel008Bean).toString());
		to = paymentService.querySPList(EQueryName.SP_MEL008_EXP.name,payment);
//					dbPayment.setPaymentMethodTxt(ELUtils.getLOVNameByLOVCode(paymentMethodList, dbPayment.getPaymentMethod()));
//					dbPayment.setPaymentTypeTxt(ELUtils.getLOVNameByLOVCode(semmel008Bean.getPaymentTypeList(), dbPayment.getPaymentType()));
					if(to != null && to.size() > 0){
//						
						//setPayment
						for(paymentExpExcel paymentEX : to){
							Payment p = new Payment();
							PaymentDetail pd = new PaymentDetail();
							paymentDetail = new HashSet<PaymentDetail>();
							if(paymentEX.getPaymentId()!=null)
								p.setRowId(paymentEX.getPaymentId());
							if(paymentEX.getSiteName()!=null)
								p.setSiteName(paymentEX.getSiteName());
							if(paymentEX.getPayNo()!=null)
								p.setPayNo(paymentEX.getPayNo());
							if(paymentEX.getContractNo()!=null)
								p.setContractNo(paymentEX.getContractNo());
							if(paymentEX.getDocDt()!=null)
								p.setDocDt(paymentEX.getDocDt());
							if(paymentEX.getVendorId()!=null)
								p.setVendorId(paymentEX.getVendorId());
							if(paymentEX.getVendorName()!=null)
								p.setVendorName(paymentEX.getVendorName());
							if(paymentEX.getPayeeName()!=null)
								p.setPayeeName(paymentEX.getPayeeName());
							if(paymentEX.getPaymentMethod() != null){
								p.setPaymentMethod(paymentEX.getPaymentMethod());
								p.setPaymentMethodTxt(ELUtils.getLOVNameByLOVCode(paymentMethodList, paymentEX.getPaymentMethod()));
							}
							if(paymentEX.getPaymentType()!=null){
								p.setPaymentType(paymentEX.getPaymentType());
								p.setPaymentTypeTxt(ELUtils.getLOVNameByLOVCode(semmel008Bean.getPaymentTypeList(), paymentEX.getPaymentType()));
							}
							if(paymentEX.getChqReceivedDt()!=null){
								p.setChqReceivedDt(paymentEX.getChqReceivedDt());
//								p.setChqReceived))(DateUtil.convertDateTime2String(to.get(0).getChqReceivedDt(), "dd/MM/yyyy"));
							}
							if(paymentEX.getTransferDt()!=null){
								p.setTransferDt(paymentEX.getTransferDt());
//								pd.setToTermOfPaymentDate(DateUtil.convertDateTime2String(to.get(0).getTransferDt(), "dd/MM/yyyy"));
							}
							if(paymentEX.getPaymentType()!=null)
								p.setExpenseType(paymentEX.getExpenseType());
							if(paymentEX.getPaymentId()!=null)
								p.setPaymentId(paymentEX.getPaymentId());
							if(paymentEX.getCompany()!=null)
								p.setCompany(paymentEX.getCompany());
							
							//set PaymentDetail
							if(paymentEX.getPaymentId()!=null)
								pd.setPaymentId(p);
							if(paymentEX.getExcludeVatAmt()!=null)
								pd.setExcludeVatAmt(paymentEX.getExcludeVatAmt());
							if(paymentEX.getVatAmt()!=null)
								pd.setVatAmt(paymentEX.getVatAmt());
							if(paymentEX.getIncludeVatAmt()!=null)
								pd.setIncludeVatAmt(paymentEX.getIncludeVatAmt());
							if(paymentEX.getWhtAmt()!=null)
								pd.setWhtAmt(paymentEX.getWhtAmt());
							if(paymentEX.getDetailFlag()!=null)
								pd.setDetailFlag(paymentEX.getDetailFlag());
							if(paymentEX.getFromTermOfPaymentDt()!=null){
								pd.setFromTermOfPaymentDt(paymentEX.getFromTermOfPaymentDt());
								pd.setFromTermOfPaymentDate(DateUtil.convertDateTime2String(paymentEX.getFromTermOfPaymentDt(), "dd/MM/yyyy"));
							}
							if(paymentEX.getToTermOfPaymentDt()!=null){
								pd.setToTermOfPaymentDt(paymentEX.getToTermOfPaymentDt());
								pd.setToTermOfPaymentDate(DateUtil.convertDateTime2String(paymentEX.getToTermOfPaymentDt(), "dd/MM/yyyy"));
							}
							
							paymentDetail.add(pd);
							p.setDetails(paymentDetail);
							selectedPayments.add(p);
						}
					}
//						
					
		return selectedPayments;
	}
	
	private StringBuffer selectedPaymentId(SEMMEL008Bean semmel008Bean) throws Exception{
		
		StringBuffer paymentIdArr = new StringBuffer(); 
		List<Payment> selectedPayment = new ArrayList<Payment>();
		for(PaymentWrapper wrapper : semmel008Bean.getPaymentWrapperList()){
			if(wrapper.isSelected()){
				List<Payment> paymentList = wrapper.getPaymentList();
				for(Payment payment : paymentList){
					paymentIdArr.append(payment.getRowId()+",");
					selectedPayment.add(payment);
				}
			}
		}
		
		semmel008Bean.setSelectedPayments(selectedPayment);
		
		return paymentIdArr;
	}
	
	private boolean doSendSMS(){
		SEMMEL008Bean semmel008Bean = getSEMMEL008Bean();
		IPaymentService paymentService = (IPaymentService)getBean("paymentService");
		boolean result = false;
		StringBuffer rowId = new StringBuffer();
		RentalPayNormalSearchSP rentalPay = new RentalPayNormalSearchSP();
		String groupNoTmp = "";
		
		for(PaymentWrapper wrapper: semmel008Bean.getPaymentWrapperList()){
			if(wrapper.isSelected()){
				for(Payment payment : wrapper.getPaymentList()){
					rowId.append(payment.getRowId()+",");
				}
			}
		}
		
		List<SMSModel> smsList = null;
		SMSModel smsP = new SMSModel();
		try {
			smsP.setpRowId(rowId.toString());
			smsP.setpType("A");
			LOG.debug("rowId = "+rowId.toString());
			smsList = paymentService.querySPList(EQueryName.SP_MRT003_SMS.name, smsP);
			LOG.debug("smsList = "+smsList);
			if(smsList == null || smsList.size() == 0){
				addMessageError("M0004");
			}else{
				for(SMSModel smsM :smsList){
					LOG.debug("smsM"+smsM.getMobileNo());
					result = SmsClient.sendSMS(smsM);
					LOG.debug("result = "+result);
				}
				addMessageInfo("M0001");
				this.doSearch();
			}
		}catch (Exception e) {
			LOG.error(e);
			e.printStackTrace();
		}
		return false;
	}
	
	//create by new  24/10/2014
	private boolean doSendEmail(){
		SEMMEL008Bean semmel008Bean = getSEMMEL008Bean();
		IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
		boolean result = false;
		StringBuffer rowId = new StringBuffer();
		RentalPayNormalSearchSP rentalPay = new RentalPayNormalSearchSP();
		String groupNoTmp = "";
		
		for(PaymentWrapper wrapper: semmel008Bean.getPaymentWrapperList()){
			if(wrapper.isSelected()){
				for(Payment payment : wrapper.getPaymentList()){
					rowId.append(payment.getRowId()+",");
				}
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
			LOG.debug("rowId = "+rowId.toString());
			emailList = rentalPaymentService.querySPList(EQueryName.SP_MRT003_MAIL.name, email);	
			
			if(emailList == null || emailList.size() == 0){ 	
				addMessageError("E0004");
			}else{
				for(EMAILModel emailM :emailList){
//					emailM.setV_Message(emailM.getV_Message()+" FROM SEMMEL008-1");
					emailM.setV_Message(emailM.getV_Message());
					LOG.info("email_to = "+emailM.getEmail_to());
					result = EmailMessageUtil.sendEmail(emailM);
					LOG.debug("result = "+result);
				}
				addMessageInfo("M0003");
				this.doSearch();
			}
			LOG.debug("result = "+result);
		}catch (Exception e) {
			LOG.error(e);
			e.printStackTrace();
		}finally{
			setSemmel008Bean(semmel008Bean);
		}
		return result;
	}
	
	
	private List<Payment> queryPayment(PaymentSP searchCriteria){		
		
		UUID uuid = UUID.randomUUID();
		long startTime = System.currentTimeMillis();
		long endTime = System.currentTimeMillis();
		
		IPaymentService paymentService = (IPaymentService)getBean("paymentService");
		
		IManagementService manageService = (IManagementService)getBean("managementService");
		List<PaymentSP> resultList = new ArrayList<PaymentSP>();
		List<Payment> paymentList = new ArrayList<Payment>();
		List<PaymentDetailSP> resultDetailList = new ArrayList<PaymentDetailSP>();
		List<PaymentDetail> paymentDetailList = new ArrayList<PaymentDetail>();
		try{
			LOG.info("===> before call SEM_SP_MEL008_SRCH  uuid : "+uuid);
			resultList = manageService.querySPList(EQueryName.SP_MEL008_SEARCH.name, searchCriteria);
			LOG.info("===> after call SEM_SP_MEL008_SRCH  size : "+resultList.size());
			if(!resultList.isEmpty()){
				LOG.info("===> begin Loop get Detail call SEM_SP_MEL008_SRCH_DTL  uuid : "+uuid);
				for(PaymentSP paymentSP: resultList){
					PaymentDetailSP paymentDetailSearch = new PaymentDetailSP();
					paymentDetailSearch.setPaymentId(paymentSP.getRowId());
					resultDetailList = paymentService.querySPList(EQueryName.SP_MEL008_SEARCH_DEATIL.name, paymentDetailSearch);
					paymentDetailList = new ArrayList<PaymentDetail>();
					if(!resultDetailList.isEmpty()){
						for(PaymentDetailSP paymentDetailSP : resultDetailList){
							PaymentDetail paymentDetail = new PaymentDetail();
							paymentDetail.setRowId(paymentDetailSP.getRowId());
							Payment p = new Payment();
							p.setRowId(paymentDetailSP.getPaymentId());
							paymentDetail.setPaymentId(p);
							paymentDetail.setExpenseType(paymentDetailSP.getExpenseType());
							paymentDetail.setPaymentDocNo(paymentDetailSP.getPaymentDocNo());
							paymentDetail.setFeeAreaCode(paymentDetailSP.getFeeAreaCode());
							paymentDetail.setFeeMeterId(paymentDetailSP.getFeeMeterId());
							paymentDetail.setFeeCheckArea(paymentDetailSP.getFeeCheckArea());
							paymentDetail.setFeeWbsCode(paymentDetailSP.getFeeWbsCode());
							paymentDetail.setInvNo(paymentDetailSP.getInvNo());
							paymentDetail.setInvDocNo(paymentDetailSP.getInvDocNo());
							paymentDetail.setInvSiteName(paymentDetailSP.getInvSiteName());
							paymentDetail.setInvAreaCode(paymentDetailSP.getInvAreaCode());
							paymentDetail.setInvAreaName(paymentDetailSP.getInvAreaName());
							paymentDetail.setInvMeterId(paymentDetailSP.getInvMeterId());
							paymentDetail.setInvTermOfPaymentDt(paymentDetailSP.getInvTermOfPaymentDt());
							paymentDetail.setInvExcludeVatAmt(paymentDetailSP.getInvExcludeVatAmt());
							paymentDetail.setInvVatAmt(paymentDetailSP.getInvVatAmt());
							paymentDetail.setInvIncludeVatAmt(paymentDetailSP.getInvIncludeVatAmt());
							paymentDetail.setMeterInfoId(paymentDetailSP.getMeterInfoId());
							paymentDetail.setReferMeterId(paymentDetailSP.getReferMeterId());
							paymentDetail.setMeterId(paymentDetailSP.getMeterId());
							paymentDetail.setpDate(paymentDetailSP.getpDate());
							paymentDetail.setlDate(paymentDetailSP.getlDate());
							paymentDetail.setpRead(paymentDetailSP.getpRead());
							paymentDetail.setlRead(paymentDetailSP.getlRead());
							paymentDetail.setUnitPrice(paymentDetailSP.getUnitPrice());
							paymentDetail.setUnitVatType(paymentDetailSP.getUnitVatType());
							paymentDetail.setUnitVatRate(paymentDetailSP.getUnitVatRate());
							paymentDetail.setTermOfPaymentDt(paymentDetailSP.getTermOfPaymentDt());
							paymentDetail.setFromTermOfPaymentDt(paymentDetailSP.getFromTermOfPaymentDt());
							paymentDetail.setToTermOfPaymentDt(paymentDetailSP.getToTermOfPaymentDt());
							paymentDetail.setPayAmt(paymentDetailSP.getPayAmt());
							paymentDetail.setVatType(paymentDetailSP.getVatType());
							paymentDetail.setVatRate(paymentDetailSP.getVatRate());
							paymentDetail.setVatAmt(paymentDetailSP.getVatAmt());
							paymentDetail.setWhtType(paymentDetailSP.getWhtType());
							paymentDetail.setWhtRate(paymentDetailSP.getWhtRate());
							paymentDetail.setWhtAmt(paymentDetailSP.getWhtAmt());
							paymentDetail.setExcludeVatAmt(paymentDetailSP.getExcludeVatAmt());
							paymentDetail.setIncludeVatAmt(paymentDetailSP.getIncludeVatAmt());
							paymentDetail.setChqAmt(paymentDetailSP.getChqAmt());
							paymentDetail.setPeriodNo(paymentDetailSP.getPeriodNo());
							paymentDetail.setPeriodType(paymentDetailSP.getPeriodType());
							paymentDetail.setPeriodInterval(paymentDetailSP.getPeriodInterval());
							paymentDetail.setPeriodName(paymentDetailSP.getPeriodName());
							paymentDetail.setPeriodStartDt(paymentDetailSP.getPeriodStartDt());
							paymentDetail.setPeriodEndDt(paymentDetailSP.getPeriodEndDt());
							paymentDetail.setPeriodDay(paymentDetailSP.getPeriodDay());
							paymentDetail.setPeriodMonth(paymentDetailSP.getPeriodMonth());
							paymentDetail.setPeriodYear(paymentDetailSP.getPeriodYear());
							paymentDetail.setPeriodAmt(paymentDetailSP.getPeriodAmt());
							paymentDetail.setRemark(paymentDetailSP.getRemark());
							paymentDetail.setDetailFlag(paymentDetailSP.getDetailFlag());
							paymentDetail.setRecordStatus(paymentDetailSP.getRecordStatus());
							paymentDetail.setCreateBy(paymentDetailSP.getWhoCreate());
							paymentDetail.setCreateDt(paymentDetailSP.getCreateDate());
							paymentDetail.setUpdateBy(paymentDetailSP.getWhoUpdate());
							paymentDetail.setUpdateDt(paymentDetailSP.getUpdateDate());
							paymentDetail.setPrivateDepositId(paymentDetailSP.getPrivateDepositId());
							paymentDetail.setPrivatePrepaid(paymentDetailSP.getPrivatePrepaid());
							paymentDetail.setDepositDetailId(paymentDetailSP.getDepositDetailId());
							paymentDetail.setValidatePaymentDetailFlag(paymentDetailSP.getValidatePaymentDetailFlag());
							paymentDetail.setMultiVendorCheck(paymentDetailSP.getMultiVendorCheck());
							paymentDetailList.add(paymentDetail);
						}
					}
						Payment payment = new Payment();
						payment.setRowId(paymentSP.getRowId());
						payment.setContractNo(paymentSP.getContractNo());
						payment.setOldContractNo(paymentSP.getOldContractNo());
						payment.setCompany(paymentSP.getCompany());
						payment.setSiteName(paymentSP.getSiteName());
						payment.setEffDt(paymentSP.getEffDt());///////
						if(paymentSP.getEffDt()!=null){
							payment.setEffDtTH(SEMDataUtility.convertToThYear(paymentSP.getEffDt()));
						}
						payment.setExpDt(paymentSP.getExpDt());///////
						if(paymentSP.getExpDt()!=null){
							payment.setExpDtTH(SEMDataUtility.convertToThYear(paymentSP.getExpDt()));
						}
						payment.setSiteStatus(paymentSP.getSiteStatus());
						payment.setSiteStatusShow(paymentSP.getSiteStatusShow());
						payment.setNetWorkStatus(paymentSP.getNetWorkStatus());
						payment.setNetWorkStatusShow(paymentSP.getNetWorkStatusShow());
						payment.setExpenseType(paymentSP.getExpenseType());
						payment.setExpenseTypeShow(paymentSP.getExpenseTypeShow());
						payment.setPaymentStatus(paymentSP.getPaymentStatus());
						payment.setPaymentStatusShow(paymentSP.getPaymentStatusShow());
						payment.setDocType(paymentSP.getDocType());
						payment.setDocTypeShow(paymentSP.getDocTypeShow());
						payment.setDocNo(paymentSP.getDocNo());
						if(paymentSP.getDocDt()!=null){
							payment.setDocDt(paymentSP.getDocDt());
						}
						payment.setVendorId(paymentSP.getVendorId());
						payment.setVendorName(paymentSP.getVendorName());
						payment.setPayeeId(paymentSP.getPayeeId());
						payment.setPayeeName(paymentSP.getPayeeName());
						payment.setPayAmt(paymentSP.getPayAmt());
						payment.setVatType(paymentSP.getVatType());
						payment.setExcludeVatAmt(paymentSP.getExcludeVatAmt());
						payment.setVatAmt(paymentSP.getVatAmt());
						payment.setIncludeVatAmt(paymentSP.getIncludeVatAmt());
						payment.setWhtAmt(paymentSP.getWhtAmt());
						payment.setChqAmt(paymentSP.getChqAmt());
						payment.setPaymentType(paymentSP.getPaymentType());
						payment.setPaymentTypeShow(paymentSP.getPaymentTypeShow());
						payment.setPaymentMethod(paymentSP.getPaymentMethod());
						payment.setPaymentMethodShow(paymentSP.getPaymentMethodShow());
						payment.setBankName(paymentSP.getBankName());
						payment.setBankAccount(paymentSP.getBankAccount());
						if(paymentSP.getChqPostingDt()!=null){
							payment.setChqPostingDt(paymentSP.getChqPostingDt());
						}
						if(paymentSP.getChqReceivedDt()!=null){
							payment.setChqReceivedDt(paymentSP.getChqReceivedDt());
						}
						if(paymentSP.getTransferDt()!=null){
						payment.setTransferDt(paymentSP.getTransferDt());
						}
						payment.setRemark(paymentSP.getRemark());
						payment.setBatchNo(paymentSP.getBatchNo());
						payment.setRejectReason(paymentSP.getRejectReason());
						payment.setChqNo(paymentSP.getChqNo());
						if(paymentSP.getChqClearingDt()!=null){
						payment.setChqClearingDt(paymentSP.getChqClearingDt());
						}
						payment.setDoc68(paymentSP.getDoc68());
						payment.setDoc92(paymentSP.getDoc92());
						payment.setDoc69(paymentSP.getDoc69());
						
						//added by NEW 2019/04/12
						payment.setReceiptNo(paymentSP.getReceiptNo());
						payment.setContFlowStatus(paymentSP.getContFlowStatus());
						
						payment.setPayment_channel(paymentSP.getPayment_channel());
						if(paymentSP.getCreateDate()!=null){
						payment.setCreateDt(paymentSP.getCreateDate());
						}
						payment.setCollectiveDbNo(paymentSP.getCollectiveDbNo());
						
						// fixed by.. YUT 2014/09/10
						payment.setPaymentId(paymentSP.getPaymentId());
						
						// fixeded by.. YUT 2014/09/30
						payment.setSendInfoStatus(paymentSP.getSendInfoStatus());
						
						payment.setLocationId(paymentSP.getLocationId());
						payment.setLocationCode(paymentSP.getLocationCode());
						payment.setSiteCode(paymentSP.getSiteCode());
						payment.setSiteId(paymentSP.getSiteId());
						payment.setService(paymentSP.getService());
	
						payment.setPaymentDetailList(paymentDetailList);
					paymentList.add(payment);
				}
				LOG.info("===> end Loop get Detail call SEM_SP_MEL008_SRCH_DTL  uuid : "+uuid);	
			}
		
		
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			endTime = System.currentTimeMillis();
			long elapsedTime = (endTime - startTime)/1000;
			LOG.info("call  SEM_SP_MEL008_SRCH uuid : " + uuid + " Elapsed time: " + elapsedTime + " seconds");
			
		}
		
		return paymentList;
	}
	
	//update by new  26/11/2014 
	private boolean doExportLetter() {
		semmel008Bean = getSEMMEL008Bean();
		Mel008ExpLetter expLetter = new Mel008ExpLetter();
		ArrayList<Mel008ExpLetter> to = new ArrayList<Mel008ExpLetter>();
		List<Mel008ExpLetter> result = null;
		StringBuffer rowId = new StringBuffer();
		List<PaymentWrapper> paymentWrapperList = semmel008Bean.getPaymentWrapperList();
		IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
		try{
			
			for(PaymentWrapper wrapper: semmel008Bean.getPaymentWrapperList()){
				if(wrapper.isSelected()){
					for(Payment payment : wrapper.getPaymentList()){
						//rowId.append(payment.getRowId()+",");
						expLetter.setRowId(payment.getPaymentId());
						System.out.println("rowId =: "+expLetter.getRowId());
					}
					result = (ArrayList) pTaxMasterService.querySPList(EQueryName.SP_MEL008_EXPLET.name, expLetter);
					if(result!=null && result.size()>0){
						Mel008ExpLetter m = new Mel008ExpLetter();
						m = result.get(0);
						to.add(m);
					}
				}
			}
			
			if (to != null && to.size()>0 ){
				semmel008Bean.setDisplayReportFlag(true);
			}else{
				semmel008Bean.setDisplayReportFlag(false);
				semmel008Bean.setRenderedMsgDataNotFound(true);
				addMessageWarn("M0004");
			}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			setSemmel008Bean(semmel008Bean);
		}
		return true;
	}
	
	//update by new  26/11/2014
	public void doExportExcelLetter(){
		semmel008Bean = getSEMMEL008Bean();
		//semmrt003Bean.setDisplayReportFlag(false);
		semmel008Bean.setRenderedMsgFormTop(false);
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
			
			List<PaymentWrapper> paymentWrapperList = semmel008Bean.getPaymentWrapperList();
				IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
				
				
				for(PaymentWrapper wrapper: semmel008Bean.getPaymentWrapperList()){
					if(wrapper.isSelected()){
						for(Payment payment : wrapper.getPaymentList()){
							//rowId.append(payment.getRowId()+",");
							expLetter.setRowId(payment.getPaymentId());
						}
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
							LOG.debug("i ="+i);
							LOG.debug("contractNo.length ="+(contractNo.length-1));
							}
							if(StringUtils.isEmpty(contractNoStrCount)){
								contractNoStrCount = contractNo[i];
							}else{
								contractNoStrCount = contractNoStrCount+","+contractNo[i];
							}
							if(chk%5 == 0 ){
								
								RowDomain row4 = new RowDomain(rowNo++,true);
								
								if(i == (contractNo.length-1)){
									LOG.debug("Last");
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
									LOG.debug("Last");
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
				LOG.debug("columnCount = "+columnCount);
				LOG.debug("maxColumn = "+maxColumn);
					docManager.seteObjectList(null);
					docManager.setModule("CONTRACT_LETTER");
					docManager.setPrintPageLandScape(true);
					docManager.setMargin(0.05, 0.05, 0.5, 0.05);
					docManager.getObjectFromDocument();
					docManager.exportServletFile();
					semmel008Bean.setDisplayReportFlag(false);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			semmel008Bean.setDisplayReportFlag(false);
			semmel008Bean.setRenderedMsgDataNotFound(true);
		}
			setSemmel008Bean(semmel008Bean);
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	// -> popup add vendor
	public void initAddVendor(){
		LOG.info("-- initPopupAddVendor --");

		SEMMEL008Bean mel008Bean = getSEMMEL008Bean();

		try {
			
			doClearPopupAddVendor();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmel008Bean(mel008Bean);
	}
	
	public void doSearchPopupAddVendor(){
		LOG.info("-- doSearchPopupAddVendor --");

		SEMMEL008Bean mel008Bean = getSEMMEL008Bean();

		try {
			
			//String strVendorCode = mel008Bean.getVendorMasterPopupObjParam().getVendorCode();
			//String strVendorName = mel008Bean.getVendorMasterPopupObjParam().getVendorName();


			IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
			List<VendorMasterSP> vendorMasterList = null;
			
			mel008Bean.setVendorMasterPopupList(new ArrayList<WrapperBeanObject<VendorMasterSP>>());
			
			vendorMasterList = service.queryVendorMasterSPList(EQueryName.SP_GET_MAP_VENDOR.name, mel008Bean.getVendorMasterPopupObjParam());
			if(vendorMasterList != null && !vendorMasterList.isEmpty()){
				 for(int i=0; i<vendorMasterList.size(); i++){
					VendorMasterSP vm = (VendorMasterSP)vendorMasterList.get(i);
					WrapperBeanObject<VendorMasterSP> tmpWrapperBean = new WrapperBeanObject<VendorMasterSP>();
					
					tmpWrapperBean.setDataObj(vm);
					tmpWrapperBean.setMessage("");
					mel008Bean.getVendorMasterPopupList().add(tmpWrapperBean);
					
					mel008Bean.setRenderedMsgDataNotFound(false);
				 }
			 } else {
				 mel008Bean.setRenderedMsgDataNotFound(true);
			 }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmel008Bean(mel008Bean);
	}
	
	public void doClearPopupAddVendor(){
		LOG.info("-- doClearPopupAddVendor --");

		SEMMEL008Bean mel008Bean = getSEMMEL008Bean();

		try {
			
			mel008Bean.getVendorMasterPopupObjParam().setVendorCode("");
			mel008Bean.getVendorMasterPopupObjParam().setVendorName("");
			mel008Bean.setVendorMasterPopupList(new ArrayList<WrapperBeanObject<VendorMasterSP>>());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmel008Bean(mel008Bean);
	}
	
	public void doSelectPopupAddVendor(){
		LOG.info("-- doSelectPopupAddVendor --");

		SEMMEL008Bean mel008Bean = getSEMMEL008Bean();

		try {
			
			String paramVendorCode = getFacesUtils().getRequestParameter("paramVendorCode") == null ? "" : 
							  (String)getFacesUtils().getRequestParameter("paramVendorCode");
			String paramVendorName = getFacesUtils().getRequestParameter("paramVendorName") == null ? "" : 
				  (String)getFacesUtils().getRequestParameter("paramVendorName");
			
			mel008Bean.getSearchCriteria().setVendorId(paramVendorCode);
//			mel008Bean.getSearchCriteria().setVendorName(paramVendorName);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmel008Bean(mel008Bean);
	}
	// <- popup add vendor
	
	//update by new  26/11/2014 
	private boolean doRunExportCheque() {
		boolean flag = true;
		semmel008Bean = getSEMMEL008Bean();
		Mel008ReportSP expLetter = new Mel008ReportSP();
		ArrayList<Mel008ReportSP> to = new ArrayList<Mel008ReportSP>();
		List<Mel008ReportSP> result = null;
		StringBuffer rowId = new StringBuffer();
		IPaymentService paymentService = (IPaymentService)getBean("paymentService");
		semmel008Bean.setExpReportList(new ArrayList<Mel008ReportSP>());
		try{
			
			for(PaymentWrapper wrapper: semmel008Bean.getPaymentWrapperList()){
				if(wrapper.isSelected()){
					for(Payment payment : wrapper.getPaymentList()){
						//rowId.append(payment.getRowId()+",");
						expLetter.setRowId(payment.getRowId());
						System.out.println("rowId =: "+expLetter.getRowId());
					}
					result = (ArrayList) paymentService.querySPList(EQueryName.SP_MEL008_EXP_CHQ.name, expLetter);
					if(result!=null && result.size()>0){
						Mel008ReportSP m = new Mel008ReportSP();
						m = result.get(0);
						
						if(m.getChqDt() != null){
							m.setChqDtStr(convertYearENtoTHStr(m.getChqDt()));
						}
						
						to.add(m);
					}
				}
			}
			
			if (to != null && to.size()>0 ){
				semmel008Bean.setDisplayReportChqFlag(true);
				semmel008Bean.setExpReportList(to);
			}else{
				semmel008Bean.setDisplayReportChqFlag(false);
				semmel008Bean.setRenderedMsgDataNotFound(true);
				flag = false;
				addMessageWarn("M0004");
			}
		}catch (Exception e) {
			e.printStackTrace();
			LOG.debug(" ##### Error SEMMEL008Action doRunExportCheque : "+e);
			flag = false;
			// TODO: handle exception
		}finally{
			setSemmel008Bean(semmel008Bean);
		}
		return flag;
	}
	
	//update by new  26/11/2014
	public void doExportCheque(){
		semmel008Bean = getSEMMEL008Bean();
		//semmrt003Bean.setDisplayReportFlag(false);
		semmel008Bean.setRenderedMsgFormTop(false);
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
			Mel008ReportSP expReport = new Mel008ReportSP();
			//expLetter.setpTaxYearFrom(semmrt003Bean.getMrt003Srch().getpTaxYearFrom().toString());
			
			
				
			
		if (semmel008Bean.getExpReportList() != null && semmel008Bean.getExpReportList().size()>0 ){
			try {
				int numberOfContract = 0;
				int rowNo = 0;	
				int widthCell = 13350;
				short line = 0;
				int columnCount = 0;
				int maxColumn = to.size();
				Collection<Mel008ReportSP> exList = new ArrayList<Mel008ReportSP>();
				DocumentExportManager<Mel008ReportSP> docManager =
					new DocumentExportManager<Mel008ReportSP>(Mel008ReportSP.class, EnumDocumentType.XLS);
					docManager.setRowStart(line);
					
					// Date Format
					DateFormat df =  new SimpleDateFormat("dd/MM/yyyy"); 
				
					EnumDocStyleDomain	titleStyle	= new EnumDocStyleDomain(EnumDocStyle.TITLE);
					EnumDocStyleDomain	headerTopic	= new EnumDocStyleDomain(EnumDocStyle.HEADER_TOPIC);
					EnumDocStyleDomain	titleLeft	= new EnumDocStyleDomain(EnumDocStyle.TITLE_LEFT);
					EnumDocStyleDomain	titleBig	= new EnumDocStyleDomain(EnumDocStyle.TITLE_BIG);
					EnumDocStyleDomain field = docManager.getStyle("normalField");
					EnumDocStyleDomain headerStyle = docManager.getStyle("rt003FieldHeader");
					
					RowDomain row0 = new RowDomain(0,true);	
					row0.setCell(new CellDomain(0,2, null, String.class, titleLeft, msg("export.col.elPayHeader"),-1,null));
					
					RowDomain row1 = new RowDomain(1,true);
					row1.setCell(new CellDomain(0,1, null, String.class, titleBig, semmel008Bean.getExpReportList().get(0).getCompany(),2,null));
					
					RowDomain row2 = new RowDomain(2,true);
					row2.setCell(new CellDomain(0, null, String.class, titleStyle, null,-1,null));
					
					RowDomain row3 = new RowDomain(3,true);
					row3.setCell(new CellDomain(0,2, null, String.class, titleLeft, msg("export.date")+" "+df.format(SEMDataUtility.convertToThYear(new Date())),null));
					
					RowDomain row4 = new RowDomain(4,true);
					row4.setCell(new CellDomain(0, null, String.class, titleStyle, null,-1,null));
					
					RowDomain row5 = new RowDomain(5, true);
					row5.setCell(new CellDomain(0, null, String.class, headerStyle, msg("export.column.noTH"),-1,1000));
					row5.setCell(new CellDomain(1, null, String.class, headerStyle, msg("menu.co.child.contract"),-1,3000));
					row5.setCell(new CellDomain(2, null, String.class, headerStyle, msg("export.column.preContract"),-1,3000));
					row5.setCell(new CellDomain(3, null, String.class, headerStyle, msg("export.col.siteNameTh"),-1,5000));
					row5.setCell(new CellDomain(4, null, String.class, headerStyle, msg("export.col.typeTH"),-1,3500));
					row5.setCell(new CellDomain(5, null, String.class, headerStyle, msg("export.column.requesterApprove"),-1,4000));
					row5.setCell(new CellDomain(6, null, String.class, headerStyle, msg("export.column.expense"),-1,3000));
					row5.setCell(new CellDomain(7, null, String.class, headerStyle, msg("export.column.chequeNo"),-1,3500));
					row5.setCell(new CellDomain(8, null, String.class, headerStyle, msg("export.column.chequeDate"),-1,2500));
					row5.setCell(new CellDomain(9, null, String.class, headerStyle, msg("export.column.chequeName"),-1,5000));
					row5.setCell(new CellDomain(10, null, String.class, headerStyle, msg("export.col.remark"),-1,3000));
	
					docManager.putDetailRow(row0);
					docManager.putDetailRow(row1);
					docManager.putDetailRow(row2);
					docManager.putDetailRow(row3);
					docManager.putDetailRow(row4);
					docManager.putDetailRow(row5);
					
					int no = 6;
					for(int i=0; i<semmel008Bean.getExpReportList().size(); i++){
						Mel008ReportSP detail = new Mel008ReportSP();
						detail = semmel008Bean.getExpReportList().get(i);
						detail.setNo(no);
						LOG.debug(" no : "+no);
						RowDomain row = new RowDomain(no, true);
						
						row.setCell(new CellDomain(0, null, String.class, field, no,-1,1000));
						row.setCell(new CellDomain(1, null, String.class, field, detail.getContractNo(),-1,3000));
						row.setCell(new CellDomain(2, null, String.class, field, detail.getOldContractNo() ,-1,3000));
						row.setCell(new CellDomain(3, null, String.class, field, detail.getSiteName() ,-1,5000));
						row.setCell(new CellDomain(4, null, String.class, field, detail.getReqType() ,-1,3500));
						row.setCell(new CellDomain(5, null, String.class, field, detail.getReqOfficer(),-1,4000));
						row.setCell(new CellDomain(6, null, String.class, field, detail.getExpenseTypeDesc(),-1,3000));
						row.setCell(new CellDomain(7, null, String.class, field, detail.getChqNo() ,-1,3500));
						row.setCell(new CellDomain(8, null, String.class, field, detail.getChqDtStr() ,-1,2500));
						row.setCell(new CellDomain(9, null, String.class, field, detail.getChqName() ,-1,5000));
						row.setCell(new CellDomain(10, null, String.class, field, detail.getRemark() ,-1,3000));
//						
						++no;
						
//						exList.add((Mel008ReportSP)detail);
							
						docManager.putDetailRow(row);
					}
					
					
					RowDomain row6 = new RowDomain(1+no,true);
					row6.setCell(new CellDomain(0, null, String.class, titleStyle, null,-1,null));
					
					RowDomain row7 = new RowDomain(2+no, true);
					row7.setCell(new CellDomain(0,7, null, String.class, titleStyle, null,-1,null));
					row7.setCell(new CellDomain(8, null, String.class, titleStyle, msg("label.chequeReceiverName"),-1,null));
					row7.setCell(new CellDomain(9,10, null, String.class, titleLeft, msg("exlport.line"),-1,null));
				
					RowDomain row8 = new RowDomain(3+no,true);
					row8.setCell(new CellDomain(0, null, String.class, titleStyle, null,-1,null));
					
					RowDomain row9 = new RowDomain(4+no,true);
					row9.setCell(new CellDomain(0,7, null, String.class, titleStyle, null,-1,null));
					row9.setCell(new CellDomain(8, null, String.class, titleStyle, msg("export.col.date"),-1,null));
					row9.setCell(new CellDomain(9,10, null, String.class, titleLeft, msg("exlport.line"),-1,null));
					
					
					docManager.putDetailRow(row6);
					docManager.putDetailRow(row7);
					docManager.putDetailRow(row8);
					docManager.putDetailRow(row9);
//					docManager.seteObjectList(exList);
					docManager.setMargin(0, 0, 0, 0);
					docManager.setModule("EL_CHQ");
					docManager.setPrintPageLandScape(true);
					docManager.getObjectFromDocument();
					docManager.exportServletFile();
			
				
				semmel008Bean.setDisplayReportChqFlag(false);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			semmel008Bean.setDisplayReportChqFlag(false);
			semmel008Bean.setRenderedMsgDataNotFound(true);
		}
			setSemmel008Bean(semmel008Bean);
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	public String exportRemark(){
		
		LOG.info("exportRemark Excel()");
		SEMMEL008Bean semmel008Bean = getSEMMEL008Bean();
		
		try{
			
			List<Payment> selectedPayments = getSelectedPayment(semmel008Bean);
			
			String batchNo = semmel008Bean.getExportBatchNo();
			Date sysDate = new Date();
			//String year = ELUtils.getYearNumberByDate(sysDate, "th");
			//String month = ELUtils.getMonthNumberByDate(sysDate);
			//String date = ELUtils.getDateByMonthandYear(month, year)ByMonthandYear(month, year)MonthNumberByDate(sysDate);
			//String DATE_FORMAT = "yyyyMMdd";
			String DATE_FORMAT = "dd/MM/yyyy";
		    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT,DateUtil.thLocale);
		    Calendar c1 = Calendar.getInstance(); // today
		    //String fileName = semmel008Bean.getCompanyBigLabel()+"_"+sdf.format(c1.getTime())+"_"+ batchNo+".xls";
		    String company = "AIS";
		    if(semmel008Bean.getCompanyBigLabel()!=null && !"".equals(semmel008Bean.getCompanyBigLabel())){
		    	company = semmel008Bean.getCompanyBigLabel();
		    }else if(selectedPayments.size() > 0){
		    	if(selectedPayments.get(0).getCompany()!=null && !"".equals(selectedPayments.get(0).getCompany())){
		    		company = selectedPayments.get(0).getCompany();
		    	}	
		    }
		    String fileName = company+"_"+SEMDataUtility.getCurrentDateDefaultForFileName()+"_"+ batchNo+".xls";		    
			LOG.info("fileName():" +fileName);
			// prepare excel
			HSSFWorkbook workbook = new HSSFWorkbook(this.getClass().getResourceAsStream("/resources/el/Export_Payment_Remark.xls"));
			HSSFCellStyle cellStyle = workbook.createCellStyle();
			Font angsanaNew = workbook.createFont();
			angsanaNew.setFontName("Angsana New");
			//angsanaNew.setFontHeight((short)14);
			angsanaNew.setFontHeightInPoints((short)14);
			cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
			cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
			cellStyle.setFont(angsanaNew);
			
			HSSFSheet worksheetAllChk = workbook.getSheetAt(0);
			HSSFSheet worksheetAllTrans = workbook.getSheetAt(1);
			HSSFSheet worksheetBillChk = workbook.getSheetAt(2);
			HSSFSheet worksheetBillTrans = workbook.getSheetAt(3);
			HSSFSheet worksheetAllPC = workbook.getSheetAt(4);			
			
			if(selectedPayments.size() > 0){
				
				// prepare map
				Map<String, String> expenseTypeMap = getExpenseTypeMap();
				Map<String, String> vatTypeMap = getVatTypeMap();
				Map<String, String> paymentTypeMap = getPaymentTypeMap();
				Map<String, String> paymentMethodMap = getPaymentMethodMap();
				
				HSSFRow rowAllChk = worksheetAllChk.getRow(0);
				HSSFRow rowAllTrans = worksheetAllTrans.getRow(0);
				HSSFRow rowAllPC = worksheetAllPC.getRow(0);
				HSSFRow rowBillChk = worksheetBillChk.getRow(0);
				HSSFRow rowBillTrans = worksheetBillTrans.getRow(0);		
				HSSFCell cell;
				
				/*rowAllChk.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.paymentDate")+" "+sdf.format(c1.getTime())));
				rowAllChk = worksheetAllChk.getRow(1);
				rowAllChk.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.company")+" "+company));
				rowAllChk = worksheetAllChk.getRow(2);
				rowAllChk.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.batchNo")+" "+batchNo));
				rowAllChk = worksheetAllChk.getRow(3);
				rowAllChk.getCell((short)3).setCellValue(new HSSFRichTextString(getMessage("label.paymentType")+" "+selectedPayments.get(0).getPaymentTypeTxt()));
				rowAllChk = worksheetAllChk.getRow(3);
				rowAllChk.getCell((short)2).setCellValue(new HSSFRichTextString(getMessage("label.paymentMethod")+" "+selectedPayments.get(0).getPaymentMethodTxt()));
				rowAllChk = worksheetAllChk.getRow(4);
				rowAllChk.getCell((short)2).setCellValue(new HSSFRichTextString(getMessage("label.chqReceivedDt")+" "+selectedPayments.get(0).getChqReceivedDtTH()));
				
				rowAllTrans.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.paymentDate")+" "+sdf.format(c1.getTime())));
				rowAllTrans = worksheetAllTrans.getRow(1);
				rowAllTrans.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.company")+" "+company));
				rowAllTrans = worksheetAllTrans.getRow(2);
				rowAllTrans.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.batchNo")+" "+batchNo));
				rowAllTrans = worksheetAllTrans.getRow(3);
				rowAllTrans.getCell((short)3).setCellValue(new HSSFRichTextString(getMessage("label.paymentType")+" "+selectedPayments.get(0).getPaymentTypeTxt()));
				rowAllTrans = worksheetAllTrans.getRow(3);
				rowAllTrans.getCell((short)2).setCellValue(new HSSFRichTextString(getMessage("label.paymentMethod")+" "+selectedPayments.get(0).getPaymentMethodTxt()));
				rowAllTrans = worksheetAllTrans.getRow(4);
				rowAllTrans.getCell((short)2).setCellValue(new HSSFRichTextString(getMessage("label.chqReceivedDt")+" "+selectedPayments.get(0).getTransferDtTH()));*/
				
				rowAllPC.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.paymentDate")+" "+sdf.format(c1.getTime())));
				rowAllPC = worksheetAllPC.getRow(1);
				rowAllPC.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.company")+" "+company));
				rowAllPC = worksheetAllPC.getRow(2);
				rowAllPC.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.batchNo")+" "+batchNo));
				rowAllPC = worksheetAllPC.getRow(3);
				rowAllPC.getCell((short)3).setCellValue(new HSSFRichTextString(getMessage("label.paymentType")+" "+selectedPayments.get(0).getPaymentTypeTxt()));
//				rowAllPC = worksheetAllPC.getRow(3);
//				rowAllPC.getCell((short)2).setCellValue(new HSSFRichTextString(getMessage("label.paymentMethod")+" "+selectedPayments.get(0).getPaymentMethodTxt()));
//				rowAllPC = worksheetAllPC.getRow(4);
//				rowAllPC.getCell((short)2).setCellValue(new HSSFRichTextString(getMessage("label.chqReceivedDt")+" "+selectedPayments.get(0).getTransferDtTH()));
				
				rowBillChk.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.paymentDate")+" "+sdf.format(c1.getTime())));
				rowBillChk = worksheetBillChk.getRow(1);
				rowBillChk.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.company")+" "+company));
				rowBillChk = worksheetBillChk.getRow(2);
				rowBillChk.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.batchNo")+" "+batchNo));
				
				/*rowBillTrans.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.paymentDate")+" "+sdf.format(c1.getTime())));	
				rowBillTrans = worksheetBillTrans.getRow(1);
				rowBillTrans.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.company")+" "+company));
				rowBillTrans = worksheetBillTrans.getRow(2);
				rowBillTrans.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.batchNo")+" "+batchNo));*/
				
				int indexAllChk = 6;
				int indexAllTrans = 6;
				int indexAllPC = 6;
				int indexBillChk = 6;
				int indexBillTrans = 6;
				
				int rowNoAllChk = 1;
				int rowNoAllTrans = 1;
				int rowNoAllPC = 1;
				int rowNoBillChk = 1;
				int rowNoBillTrans = 1;
				
				BigDecimal sumExcludeVatAmtAllChk = new BigDecimal("0");
				BigDecimal sumVatAmtAllChk = new BigDecimal("0");
				BigDecimal sumIncludeVatAmtAllChk = new BigDecimal("0");
				BigDecimal sumWHTAmtAllChk = new BigDecimal("0");
				
				BigDecimal sumExcludeVatAmtAllTrans = new BigDecimal("0");
				BigDecimal sumVatAmtAllTrans = new BigDecimal("0");
				BigDecimal sumIncludeVatAmtAllTrans = new BigDecimal("0");
				BigDecimal sumWHTAmtAllTrans = new BigDecimal("0");
				
				BigDecimal sumExcludeVatAmtAllPC = new BigDecimal("0");
				BigDecimal sumVatAmtAllPC = new BigDecimal("0");
				BigDecimal sumIncludeVatAmtAllPC = new BigDecimal("0");
				BigDecimal sumWHTAmtAllPC = new BigDecimal("0");
				
				BigDecimal sumExcludeVatAmtBillChk = new BigDecimal("0");
				BigDecimal sumVatAmtBillChk = new BigDecimal("0");
				BigDecimal sumIncludeVatAmtBillChk = new BigDecimal("0");
				BigDecimal sumWHTAmtBillChk = new BigDecimal("0");
				
				BigDecimal sumExcludeVatAmtBillTrans = new BigDecimal("0");
				BigDecimal sumVatAmtBillTrans = new BigDecimal("0");
				BigDecimal sumIncludeVatAmtBillTrans = new BigDecimal("0");
				BigDecimal sumWHTAmtBillTrans = new BigDecimal("0");
				
				String paymentTypeChq = "";
				String paymentMethodChq = "";
				String paymentChqReceivedDtTHChq = "";
				
				String paymentTypeTrans = "";
				String paymentMethodTrans = "";
				String paymentTransferDtTHTrans = "";
				
				String paymentTypeBillTrans = "";
				String paymentMethodBillTrans = "";
				String paymentTransferDtTHBillTrans = "";
				
				String paymentTypeBillChq = "";
				String paymentMethodBillChq = "";
				String paymentChqReceivedDtTHBillChq = "";
				
				String paymentTypePC = "";
				
				for(int i=0,j=selectedPayments.size();i<j;i++){
					
					Payment payment = selectedPayments.get(i);
					Set<PaymentDetail> paymentDetails = payment.getDetails();
					/*if(payment.getDetails()!=null){
						System.out.println("WT###Print payment.getDetails().size()="+payment.getDetails().size());
					}else{
						System.out.println("WT###Print no payment detail");
					}*/
					
					LOG.info("payment.getExpenseType():" +payment.getExpenseType());
					LOG.info("payment.getPaymentType():" +payment.getPaymentType());
					LOG.debug("paymentDetails:" +paymentDetails);
					if(paymentDetails==null){
						continue;
					}
					for(PaymentDetail objDetail : paymentDetails){
						
						if(payment.getExpenseType().equalsIgnoreCase("EL_BILL")){
							if(!"Y".equals(objDetail.getDetailFlag())){
								continue;
							}
							if(PAYMENT_METHOD_CHQ.equals(payment.getPaymentType())){
								paymentTypeBillChq = payment.getPaymentTypeTxt();
								paymentMethodBillChq = payment.getPaymentMethodTxt();
								paymentChqReceivedDtTHBillChq = payment.getChqReceivedDtTH();
								
								rowBillChk = worksheetBillChk.createRow(indexBillChk++);
								setExcelStyle(cellStyle, rowBillChk, (short) 0, String.valueOf(rowNoBillChk));								
								setExcelStyle(cellStyle, rowBillChk, (short)1, payment.getPayNo());
								setExcelStyle(cellStyle, rowBillChk, (short)2, payment.getDocNo());								
								setExcelStyle(cellStyle, rowBillChk, (short)3, payment.getVendorName());								
								setExcelStyle(cellStyle, rowBillChk, (short)4, payment.getDocDtTH());
								setExcelStyle(cellStyle, rowBillChk, (short)5, payment.getVendorId());								
								setExcelStyle(cellStyle, rowBillChk, (short)6, payment.getVendorName());
								setExcelStyle(cellStyle, rowBillChk, (short)7, payment.getPayeeName());
								
								if(objDetail.getExcludeVatAmt() != null){ 
									setExcelStyle(cellStyle, rowBillChk, (short)8, currencyFormat.format(objDetail.getExcludeVatAmt()));
								}else{
									setExcelStyle(cellStyle, rowBillChk, (short)8, currencyFormat.format(0));
								}
								if(objDetail.getVatAmt() != null){
									setExcelStyle(cellStyle, rowBillChk, (short)9, currencyFormat.format(objDetail.getVatAmt()));
								}else{
									setExcelStyle(cellStyle, rowBillChk, (short)9, currencyFormat.format(0));
								}
								if(objDetail.getIncludeVatAmt() != null){ 
									setExcelStyle(cellStyle, rowBillChk, (short)10, currencyFormat.format(objDetail.getIncludeVatAmt()));
								}else{
									setExcelStyle(cellStyle, rowBillChk, (short)10, currencyFormat.format(0));
								}
								if(objDetail.getWhtAmt() != null){ 
									setExcelStyle(cellStyle, rowBillChk, (short)11, currencyFormat.format(objDetail.getWhtAmt()));
								}else{
									setExcelStyle(cellStyle, rowBillChk, (short)11, currencyFormat.format(0));
								}
								setExcelStyle(cellStyle, rowBillChk, (short)12, objDetail.getRemarkVerify());
								setExcelStyle(cellStyle, rowBillChk, (short)13, objDetail.getRemarkPending());
								setExcelStyle(cellStyle, rowBillChk, (short)14, objDetail.getRemark());
//								rowBillChk.createCell((short)12).setCellValue(new HSSFRichTextString(paymentTypeMap.get(payment.getPaymentType())));
//								rowBillChk.createCell((short)13).setCellValue(new HSSFRichTextString(paymentMethodMap.get(payment.getPaymentMethod())));
//								if(payment.getChqPostingDt() != null) rowBillChk.createCell((short)14).setCellValue(new HSSFRichTextString(exportFormat.format(payment.getChqPostingDt())));
//								if(payment.getChqReceivedDt() != null) rowBillChk.createCell((short)15).setCellValue(new HSSFRichTextString(exportFormat.format(payment.getChqReceivedDt())));
//								rowBillChk.createCell((short)16).setCellValue(new HSSFRichTextString(payment.getRemark()));
								
								worksheetBillChk.autoSizeColumn((short)0);
								worksheetBillChk.autoSizeColumn((short)1);
								worksheetBillChk.autoSizeColumn((short)2);
								worksheetBillChk.autoSizeColumn((short)3);
								worksheetBillChk.autoSizeColumn((short)4);
								worksheetBillChk.autoSizeColumn((short)5);
								worksheetBillChk.autoSizeColumn((short)6);
								worksheetBillChk.autoSizeColumn((short)7);
								worksheetBillChk.autoSizeColumn((short)8);
								worksheetBillChk.autoSizeColumn((short)9);
								worksheetBillChk.autoSizeColumn((short)10);
								worksheetBillChk.autoSizeColumn((short)11);
								worksheetBillChk.autoSizeColumn((short)12);
								worksheetBillChk.autoSizeColumn((short)13);
								worksheetBillChk.autoSizeColumn((short)14);
//								worksheetBillChk.autoSizeColumn((short)15);
//								worksheetBillChk.autoSizeColumn((short)16);
								rowNoBillChk++;
								BigDecimal excludeVatAmt = new BigDecimal(0);
								if(objDetail.getExcludeVatAmt()!=null){
									excludeVatAmt = objDetail.getExcludeVatAmt();
								}
								sumExcludeVatAmtBillChk = sumExcludeVatAmtBillChk.add(excludeVatAmt);
								BigDecimal vatAmt = new BigDecimal(0);
								if(objDetail.getVatAmt()!=null){
									vatAmt = objDetail.getVatAmt();
								}
								sumVatAmtBillChk = sumVatAmtBillChk.add(vatAmt);
								BigDecimal includeVatAmt = new BigDecimal(0);
								if(objDetail.getIncludeVatAmt()!=null){
									includeVatAmt = objDetail.getIncludeVatAmt();
								}
								sumIncludeVatAmtBillChk = sumIncludeVatAmtBillChk.add(includeVatAmt);
								BigDecimal whtAmt = new BigDecimal(0);
								if(objDetail.getWhtAmt()!=null){
									whtAmt = objDetail.getWhtAmt();
								}
								sumWHTAmtBillChk = sumWHTAmtBillChk.add(whtAmt);
							}else if(PAYMENT_METHOD_TRANSFER.equals(payment.getPaymentType())){
								
								paymentTypeBillTrans = payment.getPaymentTypeTxt();
								paymentMethodBillTrans = payment.getPaymentMethodTxt();
								paymentTransferDtTHBillTrans = payment.getTransferDtTH();
								
								rowBillTrans = worksheetBillTrans.createRow(indexBillTrans++);								
								setExcelStyle(cellStyle, rowBillTrans, (short)0, String.valueOf(rowNoBillTrans));								
								setExcelStyle(cellStyle, rowBillTrans, (short)1, payment.getPayNo());								
								setExcelStyle(cellStyle, rowBillTrans, (short)2, payment.getDocNo());								
								setExcelStyle(cellStyle, rowBillTrans, (short)3, payment.getVendorName());								
								setExcelStyle(cellStyle, rowBillTrans, (short)4, payment.getDocDtTH());
								setExcelStyle(cellStyle, rowBillTrans, (short)5, payment.getVendorId());
								setExcelStyle(cellStyle, rowBillTrans, (short)6, payment.getVendorName());								
								setExcelStyle(cellStyle, rowBillTrans, (short)7, payment.getPayeeName());
								
								if(objDetail.getExcludeVatAmt() != null){									
									setExcelStyle(cellStyle, rowBillTrans, (short)8, objDetail.getExcludeVatAmt());
								}else{
									setExcelStyle(cellStyle, rowBillTrans, (short)8, currencyFormat.format(0));
								}
								if(objDetail.getVatAmt() != null){ 
									setExcelStyle(cellStyle, rowBillTrans, (short)9, currencyFormat.format(objDetail.getVatAmt()));
								}else{
									setExcelStyle(cellStyle, rowBillTrans, (short)9, currencyFormat.format(0));
								}
								if(objDetail.getIncludeVatAmt() != null){
									setExcelStyle(cellStyle, rowBillTrans, (short)10, currencyFormat.format(objDetail.getIncludeVatAmt()));
								}else{
									setExcelStyle(cellStyle, rowBillTrans, (short)10, currencyFormat.format(0));
								}
								if(objDetail.getWhtAmt() != null){
									setExcelStyle(cellStyle, rowBillTrans, (short)11, currencyFormat.format(objDetail.getWhtAmt()));
								}else{
									setExcelStyle(cellStyle, rowBillTrans, (short)11, currencyFormat.format(0));
								}
								setExcelStyle(cellStyle, rowBillTrans, (short)12, objDetail.getRemarkVerify());
								setExcelStyle(cellStyle, rowBillTrans, (short)13, objDetail.getRemarkPending());
								setExcelStyle(cellStyle, rowBillTrans, (short)14, objDetail.getRemark());
//								rowBillTrans.createCell((short)12).setCellValue(new HSSFRichTextString(paymentTypeMap.get(payment.getPaymentType())));
//								rowBillTrans.createCell((short)13).setCellValue(new HSSFRichTextString(paymentMethodMap.get(payment.getPaymentMethod())));
//								rowBillTrans.createCell((short)14).setCellValue(new HSSFRichTextString(payment.getBankName()));
//								rowBillTrans.createCell((short)15).setCellValue(new HSSFRichTextString(payment.getBankAccount()));
//								if(payment.getTransferDt() != null) rowBillTrans.createCell((short)23).setCellValue(new HSSFRichTextString(exportFormat.format(payment.getTransferDt())));
//								rowBillTrans.createCell((short)16).setCellValue(new HSSFRichTextString(payment.getRemark()));
								worksheetBillTrans.autoSizeColumn((short)0);
								worksheetBillTrans.autoSizeColumn((short)1);
								worksheetBillTrans.autoSizeColumn((short)2);
								worksheetBillTrans.autoSizeColumn((short)3);
								worksheetBillTrans.autoSizeColumn((short)4);
								worksheetBillTrans.autoSizeColumn((short)5);
								worksheetBillTrans.autoSizeColumn((short)6);
								worksheetBillTrans.autoSizeColumn((short)7);
								worksheetBillTrans.autoSizeColumn((short)8);
								worksheetBillTrans.autoSizeColumn((short)9);
								worksheetBillTrans.autoSizeColumn((short)10);
								worksheetBillTrans.autoSizeColumn((short)11);
								worksheetBillTrans.autoSizeColumn((short)12);
								worksheetBillTrans.autoSizeColumn((short)13);
								worksheetBillTrans.autoSizeColumn((short)14);
//								worksheetBillTrans.autoSizeColumn((short)15);
//								worksheetBillTrans.autoSizeColumn((short)16);
								rowNoBillTrans++;
								BigDecimal excludeVatAmt = new BigDecimal(0);
								if(objDetail.getExcludeVatAmt()!=null){
									excludeVatAmt = objDetail.getExcludeVatAmt();
								}
								sumExcludeVatAmtBillTrans = sumExcludeVatAmtBillTrans.add(excludeVatAmt);
								BigDecimal vatAmt = new BigDecimal(0);
								if(objDetail.getVatAmt()!=null){
									vatAmt = objDetail.getVatAmt();
								}
								sumVatAmtBillTrans = sumVatAmtBillTrans.add(vatAmt);
								BigDecimal includeVatAmt = new BigDecimal(0);
								if(objDetail.getIncludeVatAmt()!=null){
									includeVatAmt = objDetail.getIncludeVatAmt();
								}
								sumIncludeVatAmtBillTrans = sumIncludeVatAmtBillTrans.add(includeVatAmt);
								BigDecimal whtAmt = new BigDecimal(0);
								if(objDetail.getWhtAmt()!=null){
									whtAmt = objDetail.getWhtAmt();
								}
								sumWHTAmtBillTrans = sumWHTAmtBillTrans.add(whtAmt);
							}else if(PAYMENT_METHOD_PETTY_CASH.equals(payment.getPaymentType())){
								paymentTypePC = payment.getPaymentTypeTxt();
								
								rowAllPC = worksheetAllPC.createRow(indexAllPC++);
								
								setExcelStyle(cellStyle, rowAllPC, (short)0, String.valueOf(rowNoAllTrans));
								setExcelStyle(cellStyle, rowAllPC, (short)1, payment.getContractNo());
								setExcelStyle(cellStyle, rowAllPC, (short)2, payment.getSiteName());
								String month = "";
								if(objDetail.getFromTermOfPaymentDt()!=null && objDetail.getToTermOfPaymentDt()!=null){
									month = sdf.format(objDetail.getFromTermOfPaymentDt())+" - "+sdf.format(objDetail.getToTermOfPaymentDt());
								}
								setExcelStyle(cellStyle, rowAllPC, (short)3, month);
								setExcelStyle(cellStyle, rowAllPC, (short)4, payment.getVendorId());								
								setExcelStyle(cellStyle, rowAllPC, (short)5, payment.getVendorName());
								setExcelStyle(cellStyle, rowAllPC, (short)6, payment.getPayeeName());
								
								if(objDetail.getExcludeVatAmt() != null){ 
									setExcelStyle(cellStyle, rowAllPC, (short)7, currencyFormat.format(objDetail.getExcludeVatAmt()));
								}else{
									setExcelStyle(cellStyle, rowAllPC, (short)7, currencyFormat.format(0));
								}
								if(objDetail.getVatAmt() != null){
									setExcelStyle(cellStyle, rowAllPC, (short)8, currencyFormat.format(objDetail.getVatAmt()));
								}else{
									setExcelStyle(cellStyle, rowAllPC, (short)8, currencyFormat.format(0));
								}
								if(objDetail.getIncludeVatAmt() != null){
									setExcelStyle(cellStyle, rowAllPC, (short)9, currencyFormat.format(objDetail.getIncludeVatAmt()));
								}else{
									setExcelStyle(cellStyle, rowAllPC, (short)9, currencyFormat.format(0));
								}
								if(objDetail.getWhtAmt() != null){
									setExcelStyle(cellStyle, rowAllPC, (short)10, currencyFormat.format(objDetail.getWhtAmt()));
								}else{
									setExcelStyle(cellStyle, rowAllPC, (short)10, currencyFormat.format(0));
								}
								setExcelStyle(cellStyle, rowAllPC, (short)11, objDetail.getRemarkVerify());
								setExcelStyle(cellStyle, rowAllPC, (short)12, objDetail.getRemarkPending());
								setExcelStyle(cellStyle, rowAllPC, (short)13, objDetail.getRemark());
//								rowAllTrans.createCell((short)13).setCellValue(new HSSFRichTextString(paymentTypeMap.get(payment.getPaymentType())));
//								rowAllTrans.createCell((short)14).setCellValue(new HSSFRichTextString(paymentMethodMap.get(payment.getPaymentMethod())));
//								rowAllTrans.createCell((short)15).setCellValue(new HSSFRichTextString(payment.getBankName()));
//								rowAllTrans.createCell((short)16).setCellValue(new HSSFRichTextString(payment.getBankAccount()));
//								if(payment.getTransferDt() != null) rowAllTrans.createCell((short)17).setCellValue(new HSSFRichTextString(exportFormat.format(payment.getTransferDt())));
//								rowAllTrans.createCell((short)18).setCellValue(new HSSFRichTextString(payment.getRemark()));
								
								worksheetAllPC.autoSizeColumn((short)0);
								worksheetAllPC.autoSizeColumn((short)1);
								worksheetAllPC.autoSizeColumn((short)2);
								worksheetAllPC.autoSizeColumn((short)3);
								worksheetAllPC.autoSizeColumn((short)4);
								worksheetAllPC.autoSizeColumn((short)5);
								worksheetAllPC.autoSizeColumn((short)6);
								worksheetAllPC.autoSizeColumn((short)7);
								worksheetAllPC.autoSizeColumn((short)8);
								worksheetAllPC.autoSizeColumn((short)9);
								worksheetAllPC.autoSizeColumn((short)10);
								worksheetAllPC.autoSizeColumn((short)11);
								worksheetAllPC.autoSizeColumn((short)12);
								worksheetAllPC.autoSizeColumn((short)13);
//								worksheetAllTrans.autoSizeColumn((short)14);
//								worksheetAllTrans.autoSizeColumn((short)15);
//								worksheetAllTrans.autoSizeColumn((short)16);
//								worksheetAllTrans.autoSizeColumn((short)17);
//								worksheetAllTrans.autoSizeColumn((short)18);
								rowNoAllPC++;
								BigDecimal excludeVatAmt = new BigDecimal(0);
								if(objDetail.getExcludeVatAmt()!=null){
									excludeVatAmt = objDetail.getExcludeVatAmt();
								}
								sumExcludeVatAmtAllPC = sumExcludeVatAmtAllPC.add(excludeVatAmt);
								BigDecimal vatAmt = new BigDecimal(0);
								if(objDetail.getVatAmt()!=null){
									vatAmt = objDetail.getVatAmt();
								}
								sumVatAmtAllPC = sumVatAmtAllPC.add(vatAmt);
								BigDecimal includeVatAmt = new BigDecimal(0);
								if(objDetail.getIncludeVatAmt()!=null){
									includeVatAmt = objDetail.getIncludeVatAmt();
								}
								sumIncludeVatAmtAllPC = sumIncludeVatAmtAllPC.add(includeVatAmt);
								BigDecimal whtAmt = new BigDecimal(0);
								if(objDetail.getWhtAmt()!=null){
									whtAmt = objDetail.getWhtAmt();
								}
								sumWHTAmtAllPC = sumWHTAmtAllPC.add(whtAmt);
							}
							
						}else{
							
							if(PAYMENT_METHOD_CHQ.equals(payment.getPaymentType())){
								
								paymentTypeChq = payment.getPaymentTypeTxt();
								paymentMethodChq = payment.getPaymentMethodTxt();
								paymentChqReceivedDtTHChq = payment.getChqReceivedDtTH();
								rowAllChk = worksheetAllChk.createRow(indexAllChk++);
								
								setExcelStyle(cellStyle, rowAllChk, (short)0, String.valueOf(rowNoAllChk));
								setExcelStyle(cellStyle, rowAllChk, (short)1, payment.getContractNo());
								setExcelStyle(cellStyle, rowAllChk, (short)2, payment.getSiteName());
								String month = "";
								if(objDetail.getFromTermOfPaymentDt()!=null && objDetail.getToTermOfPaymentDt()!=null){
									month = sdf.format(objDetail.getFromTermOfPaymentDt())+" - "+sdf.format(objDetail.getToTermOfPaymentDt());
								}
								setExcelStyle(cellStyle, rowAllChk, (short)3, month);
								setExcelStyle(cellStyle, rowAllChk, (short)4, payment.getVendorId());
								setExcelStyle(cellStyle, rowAllChk, (short)5, payment.getVendorName());
								setExcelStyle(cellStyle, rowAllChk, (short)6, payment.getPayeeName());
								
								if(objDetail.getExcludeVatAmt() != null){									
									setExcelStyle(cellStyle, rowAllChk, (short)7, currencyFormat.format(objDetail.getExcludeVatAmt()));
								}else{
									setExcelStyle(cellStyle, rowAllChk, (short)7, currencyFormat.format(0));
								}
								if(objDetail.getVatAmt() != null){ 
									setExcelStyle(cellStyle, rowAllChk, (short)8, currencyFormat.format(objDetail.getVatAmt()));
								}else{
									setExcelStyle(cellStyle, rowAllChk, (short)8, currencyFormat.format(0));
								}
								if(objDetail.getIncludeVatAmt() != null){ 
									setExcelStyle(cellStyle, rowAllChk, (short)9, currencyFormat.format(objDetail.getIncludeVatAmt()));
								}else{
									setExcelStyle(cellStyle, rowAllChk, (short)9, currencyFormat.format(0));
								}
								if(objDetail.getWhtAmt() != null){
									setExcelStyle(cellStyle, rowAllChk, (short)10, currencyFormat.format(objDetail.getWhtAmt()));
								}else{
									setExcelStyle(cellStyle, rowAllChk, (short)10, currencyFormat.format(0));
								}
								LOG.debug("objDetail.getRemarkVerify() : "+objDetail.getRemarkVerify());
								setExcelStyle(cellStyle, rowAllChk, (short)11, objDetail.getRemarkVerify());
								setExcelStyle(cellStyle, rowAllChk, (short)12, objDetail.getRemarkPending());
								setExcelStyle(cellStyle, rowAllChk, (short)13, objDetail.getRemark());
//								rowAllChk.createCell((short)14).setCellValue(new HSSFRichTextString(paymentTypeMap.get(payment.getPaymentType())));
//								rowAllChk.createCell((short)15).setCellValue(new HSSFRichTextString(paymentMethodMap.get(payment.getPaymentMethod())));
//								if(payment.getChqPostingDt() != null) rowAllChk.createCell((short)16).setCellValue(new HSSFRichTextString(exportFormat.format(payment.getChqPostingDt())));
//								if(payment.getChqReceivedDt() != null) rowAllChk.createCell((short)17).setCellValue(new HSSFRichTextString(exportFormat.format(payment.getChqReceivedDt())));
//								rowAllChk.createCell((short)18).setCellValue(new HSSFRichTextString(payment.getRemark()));
								
								worksheetAllChk.autoSizeColumn((short)0);
								worksheetAllChk.autoSizeColumn((short)1);
								worksheetAllChk.autoSizeColumn((short)2);
								worksheetAllChk.autoSizeColumn((short)3);
								worksheetAllChk.autoSizeColumn((short)4);
								worksheetAllChk.autoSizeColumn((short)5);
								worksheetAllChk.autoSizeColumn((short)6);
								worksheetAllChk.autoSizeColumn((short)7);
								worksheetAllChk.autoSizeColumn((short)8);
								worksheetAllChk.autoSizeColumn((short)9);
								worksheetAllChk.autoSizeColumn((short)10);
								worksheetAllChk.autoSizeColumn((short)11);
								worksheetAllChk.autoSizeColumn((short)12);
								worksheetAllChk.autoSizeColumn((short)13);
//								worksheetAllChk.autoSizeColumn((short)14);
//								worksheetAllChk.autoSizeColumn((short)15);
//								worksheetAllChk.autoSizeColumn((short)16);
//								worksheetAllChk.autoSizeColumn((short)17);
//								worksheetAllChk.autoSizeColumn((short)18);
								rowNoAllChk++;
								BigDecimal excludeVatAmt = new BigDecimal(0);
								if(objDetail.getExcludeVatAmt()!=null){
									excludeVatAmt = objDetail.getExcludeVatAmt();
								}
								sumExcludeVatAmtAllChk = sumExcludeVatAmtAllChk.add(excludeVatAmt);
								BigDecimal vatAmt = new BigDecimal(0);
								if(objDetail.getVatAmt()!=null){
									vatAmt = objDetail.getVatAmt();
								}
								sumVatAmtAllChk = sumVatAmtAllChk.add(vatAmt);
								BigDecimal includeVatAmt = new BigDecimal(0);
								if(objDetail.getIncludeVatAmt()!=null){
									includeVatAmt = objDetail.getIncludeVatAmt();
								}
								sumIncludeVatAmtAllChk = sumIncludeVatAmtAllChk.add(includeVatAmt);
								BigDecimal whtAmt = new BigDecimal(0);
								if(objDetail.getWhtAmt()!=null){
									whtAmt = objDetail.getWhtAmt();
								}
								sumWHTAmtAllChk = sumWHTAmtAllChk.add(whtAmt);
							}else if(PAYMENT_METHOD_TRANSFER.equals(payment.getPaymentType())){
							//}else{
								paymentTypeTrans = payment.getPaymentTypeTxt();
								paymentMethodTrans = payment.getPaymentMethodTxt();
								paymentTransferDtTHTrans = payment.getTransferDtTH();
								
								rowAllTrans = worksheetAllTrans.createRow(indexAllTrans++);
								
								setExcelStyle(cellStyle, rowAllTrans, (short)0, String.valueOf(rowNoAllTrans));
								setExcelStyle(cellStyle, rowAllTrans, (short)1, payment.getContractNo());								
								setExcelStyle(cellStyle, rowAllTrans, (short)2, payment.getSiteName());
								String month = "";
								if(objDetail.getFromTermOfPaymentDt()!=null && objDetail.getToTermOfPaymentDt()!=null){
									month = sdf.format(objDetail.getFromTermOfPaymentDt())+" - "+sdf.format(objDetail.getToTermOfPaymentDt());
								}
								setExcelStyle(cellStyle, rowAllTrans, (short)3, month);								
								setExcelStyle(cellStyle, rowAllTrans, (short)4, payment.getVendorId());
								setExcelStyle(cellStyle, rowAllTrans, (short)5, payment.getVendorName());
								setExcelStyle(cellStyle, rowAllTrans, (short)6, payment.getPayeeName());
								
								if(objDetail.getExcludeVatAmt() != null){
									setExcelStyle(cellStyle, rowAllTrans, (short)7, currencyFormat.format(objDetail.getExcludeVatAmt()));
								}else{
									setExcelStyle(cellStyle, rowAllTrans, (short)7, currencyFormat.format(0));
								}
								if(objDetail.getVatAmt() != null){ 
									setExcelStyle(cellStyle, rowAllTrans, (short)8, currencyFormat.format(objDetail.getVatAmt()));
								}else{
									setExcelStyle(cellStyle, rowAllTrans, (short)8, currencyFormat.format(0));
								}
								if(objDetail.getIncludeVatAmt() != null){ 
									setExcelStyle(cellStyle, rowAllTrans, (short)9, currencyFormat.format(objDetail.getIncludeVatAmt()));
								}else{
									setExcelStyle(cellStyle, rowAllTrans, (short)9, currencyFormat.format(0));
								}
								if(objDetail.getWhtAmt() != null){
									setExcelStyle(cellStyle, rowAllTrans, (short)10, currencyFormat.format(objDetail.getWhtAmt()));
								}else{
									setExcelStyle(cellStyle, rowAllTrans, (short)10, currencyFormat.format(0));
								}

								setExcelStyle(cellStyle, rowAllTrans, (short)11, objDetail.getRemarkVerify());
								setExcelStyle(cellStyle, rowAllTrans, (short)12, objDetail.getRemarkPending());
								setExcelStyle(cellStyle, rowAllTrans, (short)13, objDetail.getRemark());
//								rowAllTrans.createCell((short)13).setCellValue(new HSSFRichTextString(paymentTypeMap.get(payment.getPaymentType())));
//								rowAllTrans.createCell((short)14).setCellValue(new HSSFRichTextString(paymentMethodMap.get(payment.getPaymentMethod())));
//								rowAllTrans.createCell((short)15).setCellValue(new HSSFRichTextString(payment.getBankName()));
//								rowAllTrans.createCell((short)16).setCellValue(new HSSFRichTextString(payment.getBankAccount()));
//								if(payment.getTransferDt() != null) rowAllTrans.createCell((short)17).setCellValue(new HSSFRichTextString(exportFormat.format(payment.getTransferDt())));
//								rowAllTrans.createCell((short)18).setCellValue(new HSSFRichTextString(payment.getRemark()));
								
								worksheetAllTrans.autoSizeColumn((short)0);
								worksheetAllTrans.autoSizeColumn((short)1);
								worksheetAllTrans.autoSizeColumn((short)2);
								worksheetAllTrans.autoSizeColumn((short)3);
								worksheetAllTrans.autoSizeColumn((short)4);
								worksheetAllTrans.autoSizeColumn((short)5);
								worksheetAllTrans.autoSizeColumn((short)6);
								worksheetAllTrans.autoSizeColumn((short)7);
								worksheetAllTrans.autoSizeColumn((short)8);
								worksheetAllTrans.autoSizeColumn((short)9);
								worksheetAllTrans.autoSizeColumn((short)10);
								worksheetAllTrans.autoSizeColumn((short)11);
								worksheetAllTrans.autoSizeColumn((short)12);
								worksheetAllTrans.autoSizeColumn((short)13);
//								worksheetAllTrans.autoSizeColumn((short)14);
//								worksheetAllTrans.autoSizeColumn((short)15);
//								worksheetAllTrans.autoSizeColumn((short)16);
//								worksheetAllTrans.autoSizeColumn((short)17);
//								worksheetAllTrans.autoSizeColumn((short)18);
								rowNoAllTrans++;
								BigDecimal excludeVatAmt = new BigDecimal(0);
								if(objDetail.getExcludeVatAmt()!=null){
									excludeVatAmt = objDetail.getExcludeVatAmt();
								}
								sumExcludeVatAmtAllTrans = sumExcludeVatAmtAllTrans.add(excludeVatAmt);
								BigDecimal vatAmt = new BigDecimal(0);
								if(objDetail.getVatAmt()!=null){
									vatAmt = objDetail.getVatAmt();
								}
								sumVatAmtAllTrans = sumVatAmtAllTrans.add(vatAmt);
								BigDecimal includeVatAmt = new BigDecimal(0);
								if(objDetail.getIncludeVatAmt()!=null){
									includeVatAmt = objDetail.getIncludeVatAmt();
								}
								sumIncludeVatAmtAllTrans = sumIncludeVatAmtAllTrans.add(includeVatAmt);
								BigDecimal whtAmt = new BigDecimal(0);
								if(objDetail.getWhtAmt()!=null){
									whtAmt = objDetail.getWhtAmt();
								}
								sumWHTAmtAllTrans = sumWHTAmtAllTrans.add(whtAmt);
							}else if(PAYMENT_METHOD_PETTY_CASH.equals(payment.getPaymentType())){
								paymentTypePC = payment.getPaymentTypeTxt();
								
								rowAllPC = worksheetAllPC.createRow(indexAllPC++);
																
								setExcelStyle(cellStyle, rowAllPC, (short)0, String.valueOf(rowNoAllPC));
								setExcelStyle(cellStyle, rowAllPC, (short)1, payment.getContractNo());
								setExcelStyle(cellStyle, rowAllPC, (short)2, payment.getSiteName());
								String month = "";
								if(objDetail.getFromTermOfPaymentDt()!=null && objDetail.getToTermOfPaymentDt()!=null){
									month = sdf.format(objDetail.getFromTermOfPaymentDt())+" - "+sdf.format(objDetail.getToTermOfPaymentDt());
								}
								setExcelStyle(cellStyle, rowAllPC, (short)3, month);
								setExcelStyle(cellStyle, rowAllPC, (short)4, payment.getVendorId());
								setExcelStyle(cellStyle, rowAllPC, (short)5, payment.getVendorName());
								setExcelStyle(cellStyle, rowAllPC, (short)6, payment.getPayeeName());
								
								if(objDetail.getExcludeVatAmt() != null){ 
									setExcelStyle(cellStyle, rowAllPC, (short)7, currencyFormat.format(objDetail.getExcludeVatAmt()));
								}else{
									setExcelStyle(cellStyle, rowAllPC, (short)7, currencyFormat.format(0));
								}
								if(objDetail.getVatAmt() != null){ 
									setExcelStyle(cellStyle, rowAllPC, (short)8, currencyFormat.format(objDetail.getVatAmt()));
								}else{
									setExcelStyle(cellStyle, rowAllPC, (short)8, currencyFormat.format(0));
								}
								if(objDetail.getIncludeVatAmt() != null){ 
									setExcelStyle(cellStyle, rowAllPC, (short)9, currencyFormat.format(objDetail.getIncludeVatAmt()));
								}else{
									setExcelStyle(cellStyle, rowAllPC, (short)9, currencyFormat.format(0));
								}
								if(objDetail.getWhtAmt() != null){
									setExcelStyle(cellStyle, rowAllPC, (short)10, currencyFormat.format(objDetail.getWhtAmt()));
								}else{
									setExcelStyle(cellStyle, rowAllPC, (short)10, currencyFormat.format(0));
								}
								
								setExcelStyle(cellStyle, rowAllPC, (short)11, objDetail.getRemarkVerify());
								setExcelStyle(cellStyle, rowAllPC, (short)12, objDetail.getRemarkPending());
								setExcelStyle(cellStyle, rowAllPC, (short)13, objDetail.getRemark());
//								rowAllTrans.createCell((short)13).setCellValue(new HSSFRichTextString(paymentTypeMap.get(payment.getPaymentType())));
//								rowAllTrans.createCell((short)14).setCellValue(new HSSFRichTextString(paymentMethodMap.get(payment.getPaymentMethod())));
//								rowAllTrans.createCell((short)15).setCellValue(new HSSFRichTextString(payment.getBankName()));
//								rowAllTrans.createCell((short)16).setCellValue(new HSSFRichTextString(payment.getBankAccount()));
//								if(payment.getTransferDt() != null) rowAllTrans.createCell((short)17).setCellValue(new HSSFRichTextString(exportFormat.format(payment.getTransferDt())));
//								rowAllTrans.createCell((short)18).setCellValue(new HSSFRichTextString(payment.getRemark()));
								
								worksheetAllPC.autoSizeColumn((short)0);
								worksheetAllPC.autoSizeColumn((short)1);
								worksheetAllPC.autoSizeColumn((short)2);
								worksheetAllPC.autoSizeColumn((short)3);
								worksheetAllPC.autoSizeColumn((short)4);
								worksheetAllPC.autoSizeColumn((short)5);
								worksheetAllPC.autoSizeColumn((short)6);
								worksheetAllPC.autoSizeColumn((short)7);
								worksheetAllPC.autoSizeColumn((short)8);
								worksheetAllPC.autoSizeColumn((short)9);
								worksheetAllPC.autoSizeColumn((short)10);
								worksheetAllPC.autoSizeColumn((short)11);
								worksheetAllPC.autoSizeColumn((short)12);
								worksheetAllPC.autoSizeColumn((short)13);
//								worksheetAllTrans.autoSizeColumn((short)14);
//								worksheetAllTrans.autoSizeColumn((short)15);
//								worksheetAllTrans.autoSizeColumn((short)16);
//								worksheetAllTrans.autoSizeColumn((short)17);
//								worksheetAllTrans.autoSizeColumn((short)18);
								rowNoAllPC++;
								BigDecimal excludeVatAmt = new BigDecimal(0);
								if(objDetail.getExcludeVatAmt()!=null){
									excludeVatAmt = objDetail.getExcludeVatAmt();
								}
								sumExcludeVatAmtAllPC = sumExcludeVatAmtAllPC.add(excludeVatAmt);
								BigDecimal vatAmt = new BigDecimal(0);
								if(objDetail.getVatAmt()!=null){
									vatAmt = objDetail.getVatAmt();
								}
								sumVatAmtAllPC = sumVatAmtAllPC.add(vatAmt);
								BigDecimal includeVatAmt = new BigDecimal(0);
								if(objDetail.getIncludeVatAmt()!=null){
									includeVatAmt = objDetail.getIncludeVatAmt();
								}
								sumIncludeVatAmtAllPC = sumIncludeVatAmtAllPC.add(includeVatAmt);
								BigDecimal whtAmt = new BigDecimal(0);
								if(objDetail.getWhtAmt()!=null){
									whtAmt = objDetail.getWhtAmt();
								}
								sumWHTAmtAllPC = sumWHTAmtAllPC.add(whtAmt);
							}
						}
					}
					
					createSumRow(payment, rowAllTrans, worksheetAllTrans, sumExcludeVatAmtAllTrans, sumVatAmtAllTrans, sumIncludeVatAmtAllTrans, sumWHTAmtAllTrans, indexAllTrans, cellStyle);
					createSumRow(payment, rowAllChk, worksheetAllChk, sumExcludeVatAmtAllChk, sumVatAmtAllChk, sumIncludeVatAmtAllChk, sumWHTAmtAllChk, indexAllChk, cellStyle);
					createSumRow(payment, rowAllPC, worksheetAllPC, sumExcludeVatAmtAllPC, sumVatAmtAllPC, sumIncludeVatAmtAllPC, sumWHTAmtAllPC, indexAllPC, cellStyle);
					createSumRow(payment, rowBillChk, worksheetBillChk, sumExcludeVatAmtBillChk, sumVatAmtBillChk, sumIncludeVatAmtBillChk, sumWHTAmtBillChk, indexBillChk, cellStyle);
					createSumRow(payment, rowBillTrans, worksheetBillTrans, sumExcludeVatAmtBillTrans, sumVatAmtBillTrans, sumIncludeVatAmtBillTrans, sumWHTAmtBillTrans, indexBillTrans, cellStyle);
					
				}
				
				rowAllChk = worksheetAllChk.getRow(0);
				rowAllTrans = worksheetAllTrans.getRow(0);
				rowBillTrans = worksheetBillTrans.getRow(0);
				rowBillChk = worksheetBillChk.getRow(0);
				
				rowAllChk.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.paymentDate")+" "+sdf.format(c1.getTime())));
				rowAllChk = worksheetAllChk.getRow(1);
				rowAllChk.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.company")+" "+company));
				rowAllChk = worksheetAllChk.getRow(2);
				rowAllChk.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.batchNo")+" "+batchNo));
				rowAllChk = worksheetAllChk.getRow(3);
				rowAllChk.getCell((short)3).setCellValue(new HSSFRichTextString(getMessage("label.paymentType")+" "+paymentTypeChq));
				rowAllChk = worksheetAllChk.getRow(3);
				rowAllChk.getCell((short)1).setCellValue(new HSSFRichTextString(getMessage("label.paymentMethod")+" "+paymentMethodChq));
				rowAllChk = worksheetAllChk.getRow(4);
				rowAllChk.getCell((short)1).setCellValue(new HSSFRichTextString(getMessage("label.chqReceivedDt")+" "+paymentChqReceivedDtTHChq));
				
				rowAllTrans.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.paymentDate")+" "+sdf.format(c1.getTime())));
				rowAllTrans = worksheetAllTrans.getRow(1);
				rowAllTrans.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.company")+" "+company));
				rowAllTrans = worksheetAllTrans.getRow(2);
				rowAllTrans.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.batchNo")+" "+batchNo));
				rowAllTrans = worksheetAllTrans.getRow(3);
				rowAllTrans.getCell((short)3).setCellValue(new HSSFRichTextString(getMessage("label.paymentType")+" "+paymentTypeTrans));
				rowAllTrans = worksheetAllTrans.getRow(3);
				rowAllTrans.getCell((short)1).setCellValue(new HSSFRichTextString(getMessage("label.paymentMethod")+" "+paymentMethodTrans));
				rowAllTrans = worksheetAllTrans.getRow(4);
				rowAllTrans.getCell((short)1).setCellValue(new HSSFRichTextString(getMessage("label.transferDt")+" "+paymentTransferDtTHTrans));
				
				//WT###Add 20110420 Start
				rowBillTrans.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.paymentDate")+" "+sdf.format(c1.getTime())));	
				rowBillTrans = worksheetBillTrans.getRow(1);
				rowBillTrans.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.company")+" "+company));
				rowBillTrans = worksheetBillTrans.getRow(2);
				rowBillTrans.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.batchNo")+" "+batchNo));
				rowBillTrans = worksheetBillTrans.getRow(3);
				rowBillTrans.getCell((short)3).setCellValue(new HSSFRichTextString(getMessage("label.paymentType")+" "+paymentTypeBillTrans));
				rowBillTrans = worksheetBillTrans.getRow(3);
				rowBillTrans.getCell((short)1).setCellValue(new HSSFRichTextString(getMessage("label.paymentMethod")+" "+paymentMethodBillTrans));
				rowBillTrans = worksheetBillTrans.getRow(4);
				rowBillTrans.getCell((short)1).setCellValue(new HSSFRichTextString(getMessage("label.transferDt")+" "+paymentTransferDtTHBillTrans));
				
				rowBillChk.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.paymentDate")+" "+sdf.format(c1.getTime())));	
				rowBillChk = worksheetBillChk.getRow(1);
				rowBillChk.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.company")+" "+company));
				rowBillChk = worksheetBillChk.getRow(2);
				rowBillChk.getCell((short)0).setCellValue(new HSSFRichTextString(getMessage("excel.header.batchNo")+" "+batchNo));
				rowBillChk = worksheetBillChk.getRow(3);
				rowBillChk.getCell((short)3).setCellValue(new HSSFRichTextString(getMessage("label.paymentType")+" "+paymentTypeBillChq));
				rowBillChk = worksheetBillChk.getRow(3);
				rowBillChk.getCell((short)1).setCellValue(new HSSFRichTextString(getMessage("label.paymentMethod")+" "+paymentMethodBillChq));
				rowBillChk = worksheetBillChk.getRow(4);
				rowBillChk.getCell((short)1).setCellValue(new HSSFRichTextString(getMessage("label.chqReceivedDt")+" "+paymentChqReceivedDtTHBillChq));
				//WT###Add 20110420 End
				
				if(rowNoAllPC==1){
					LOG.debug("WT### removeShhetAt 4");
					try{
						workbook.removeSheetAt(4);
					}catch(Exception e){
						LOG.error("Can't remove sheet index 4 : "+e.getMessage());
					}
				}
				if(rowNoBillTrans==1){
					LOG.debug("WT### removeShhetAt 3");
					try{
						workbook.removeSheetAt(3);
					}catch(Exception e){
						LOG.error("Can't remove sheet index 3 : "+e.getMessage());
					}
				}
				if(rowNoBillChk==1){
					LOG.debug("WT### removeShhetAt 2");
					try{
						workbook.removeSheetAt(2);
					}catch(Exception e){
						LOG.error("Can't remove sheet index 2 : "+e.getMessage());
					}
				}
				if(rowNoAllTrans==1){
					LOG.debug("WT### removeShhetAt 1");
					try{
						workbook.removeSheetAt(1);
					}catch(Exception e){
						LOG.error("Can't remove sheet index 1 : "+e.getMessage());
					}
				}
				if(rowNoAllChk==1){
					LOG.debug("WT### removeShhetAt 0");
					try{
						workbook.removeSheetAt(0);
					}catch(Exception e){
						LOG.error("Can't remove sheet index 0 : "+e.getMessage());
					}
				}
				
				
			}
			
			// update payment
			SsoBean ssoBean = (SsoBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ssoBean");
			
			for(Payment payment : selectedPayments){
				
				payment.setExportFlag(SEMMEL001Util.Y);
				payment.setExportDt(Calendar.getInstance().getTime());
				payment.setUpdateBy(ssoBean.getUserName());
				payment.setCurrentUser(ssoBean.getUserName());
				payment.setUpdateDt(Calendar.getInstance().getTime());
				payment.setBatchNo(batchNo);
			}
			
			IPaymentService paymentService = (IPaymentService)getBean("paymentService");
//			paymentService.savePayment(selectedPayments);
			
			//WT###Add 20110111 Start
			String plUpdateBatchName = ParameterConfigUtil.getInstance().getConfigByCode("EL_PG_UPDATE_BATCH_B001");
			LOG.info("Start Service upDateBatchWithPL");
			LOG.info("WT### batchNo="+batchNo);
//			paymentService.upDateBatchWithPL(plUpdateBatchName, batchNo);
			LOG.info("End Service upDateBatchWithPL");
			//WT###Add 20110111 End
			
			// export
			HttpServletResponse res = FacesUtils.getInstance().getHttpResponse();   
			res.setContentType("application/vnd.ms-excel");   
			//res.setHeader("Content-disposition",  "attachment;filename=Export Management.xls");
			res.setHeader("Content-disposition",  "attachment;filename="+fileName);
	          
            ServletOutputStream out = res.getOutputStream();   
     
            workbook.write(out);   
            out.flush();   
            out.close();
            
            FacesContext faces = FacesContext.getCurrentInstance();   
            faces.responseComplete();
            
		}catch(Exception e){
			
			e.printStackTrace();
			LOG.error(e);
		}
		
		return "login_pass";
	}
	
	private List<Payment> getSelectedPayment(SEMMEL008Bean semmel008Bean) throws Exception{
		
		IPaymentService paymentService = (IPaymentService)getBean("paymentService");
		
		List<Payment> selectedPayments = new ArrayList<Payment>();
		Set<PaymentDetail> paymentDetail = new HashSet<PaymentDetail>();
		paymentDetail.clear();
//		Set<PaymentDetail> temp = new HashSet<PaymentDetail>();
//		HashSet pdHS = new HashSet();
//		paymentDetail = (Set<PaymentDetail>) new HashSet();
		List<paymentExpExcel> to = new ArrayList<paymentExpExcel>();
		List<SelectItem> paymentMethodList = semmel008Bean.getPaymentMethodList();
		if(paymentMethodList==null || paymentMethodList.size()<=0){
			paymentMethodList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
		}
		
		Payment payment = new Payment();
		payment.setRowId(selectedPaymentId(semmel008Bean).toString());
		LOG.debug(" ######## payment.getRowId() : "+payment.getRowId());
		to = paymentService.querySPList(EQueryName.SP_MEL008_EXP_REMARK.name,payment);
//					dbPayment.setPaymentMethodTxt(ELUtils.getLOVNameByLOVCode(paymentMethodList, dbPayment.getPaymentMethod()));
//					dbPayment.setPaymentTypeTxt(ELUtils.getLOVNameByLOVCode(semmel008Bean.getPaymentTypeList(), dbPayment.getPaymentType()));
					if(to != null && to.size() > 0){
//						
						//setPayment
						for(paymentExpExcel paymentEX : to){
							Payment p = new Payment();
							PaymentDetail pd = new PaymentDetail();
							paymentDetail = new HashSet<PaymentDetail>();
							if(paymentEX.getPaymentId()!=null)
								p.setRowId(paymentEX.getPaymentId());
							if(paymentEX.getSiteName()!=null)
								p.setSiteName(paymentEX.getSiteName());
							if(paymentEX.getPayNo()!=null)
								p.setPayNo(paymentEX.getPayNo());
							if(paymentEX.getContractNo()!=null)
								p.setContractNo(paymentEX.getContractNo());
							if(paymentEX.getDocDt()!=null)
								p.setDocDt(paymentEX.getDocDt());
							if(paymentEX.getVendorId()!=null)
								p.setVendorId(paymentEX.getVendorId());
							if(paymentEX.getVendorName()!=null)
								p.setVendorName(paymentEX.getVendorName());
							if(paymentEX.getPayeeName()!=null)
								p.setPayeeName(paymentEX.getPayeeName());
							if(paymentEX.getPaymentMethod() != null){
								p.setPaymentMethod(paymentEX.getPaymentMethod());
								p.setPaymentMethodTxt(ELUtils.getLOVNameByLOVCode(paymentMethodList, paymentEX.getPaymentMethod()));
							}
							if(paymentEX.getPaymentType()!=null){
								p.setPaymentType(paymentEX.getPaymentType());
								p.setPaymentTypeTxt(ELUtils.getLOVNameByLOVCode(semmel008Bean.getPaymentTypeList(), paymentEX.getPaymentType()));
							}
							if(paymentEX.getChqReceivedDt()!=null){
								p.setChqReceivedDt(paymentEX.getChqReceivedDt());
//								p.setChqReceived))(DateUtil.convertDateTime2String(to.get(0).getChqReceivedDt(), "dd/MM/yyyy"));
							}
							if(paymentEX.getTransferDt()!=null){
								p.setTransferDt(paymentEX.getTransferDt());
//								pd.setToTermOfPaymentDate(DateUtil.convertDateTime2String(to.get(0).getTransferDt(), "dd/MM/yyyy"));
							}
							if(paymentEX.getPaymentType()!=null)
								p.setExpenseType(paymentEX.getExpenseType());
							if(paymentEX.getPaymentId()!=null)
								p.setPaymentId(paymentEX.getPaymentId());
							if(paymentEX.getCompany()!=null)
								p.setCompany(paymentEX.getCompany());
							
							//set PaymentDetail
							if(paymentEX.getPaymentId()!=null)
								pd.setPaymentId(p);
							if(paymentEX.getExcludeVatAmt()!=null)
								pd.setExcludeVatAmt(paymentEX.getExcludeVatAmt());
							if(paymentEX.getVatAmt()!=null)
								pd.setVatAmt(paymentEX.getVatAmt());
							if(paymentEX.getIncludeVatAmt()!=null)
								pd.setIncludeVatAmt(paymentEX.getIncludeVatAmt());
							if(paymentEX.getWhtAmt()!=null)
								pd.setWhtAmt(paymentEX.getWhtAmt());
							if(paymentEX.getDetailFlag()!=null)
								pd.setDetailFlag(paymentEX.getDetailFlag());
							if(paymentEX.getFromTermOfPaymentDt()!=null){
								pd.setFromTermOfPaymentDt(paymentEX.getFromTermOfPaymentDt());
								pd.setFromTermOfPaymentDate(DateUtil.convertDateTime2String(paymentEX.getFromTermOfPaymentDt(), "dd/MM/yyyy"));
							}
							if(paymentEX.getToTermOfPaymentDt()!=null){
								pd.setToTermOfPaymentDt(paymentEX.getToTermOfPaymentDt());
								pd.setToTermOfPaymentDate(DateUtil.convertDateTime2String(paymentEX.getToTermOfPaymentDt(), "dd/MM/yyyy"));
							}
							if(paymentEX.getRemark()!=null)
								pd.setRemark(paymentEX.getRemark());
							if(paymentEX.getRemarkPending()!=null)
								pd.setRemarkPending(paymentEX.getRemarkPending());
							if(paymentEX.getRemarkVerify()!=null)
								pd.setRemarkVerify(paymentEX.getRemarkVerify());
							
							paymentDetail.add(pd);
							p.setDetails(paymentDetail);
							selectedPayments.add(p);
						}
					}
//						
					
		return selectedPayments;
	}
	
	private boolean doSendSMSOS(){
		semmel008Bean = getSEMMEL008Bean();
//		IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
		IManagementService service = (IManagementService)getBean("managementService");
		boolean result = false;
		StringBuffer rowId = new StringBuffer();
		Payment payment = new Payment();
		String groupNoTmp = "";
		for(PaymentWrapper wapper :semmel008Bean.getPaymentWrapperList()){
//			payment = (Payment) wapper.getPaymentList();
			
			if(wapper.isSelected()){
				for(Payment paymentObj : wapper.getPaymentList()){
					rowId.append(paymentObj.getRowId()+",");
				}
				
//				if(StringUtils.isNotEmpty(rentalPay.getPaymentGroupNo())){
//					groupNoTmp = rentalPay.getPaymentGroupNo();
//				}
			}
		}
		
		List<SMSModel> smsList = null;
		SMSModel smsP = new SMSModel();
		try {
			smsP.setpRowId(rowId.toString());
			smsP.setpType("P");
			LOG.debug("rowId = "+rowId.toString());
			smsList = service.querySPList(EQueryName.SP_MEL009_SMS.name, smsP);
			if(smsList == null || smsList.size() == 0){
				addMessageError("M0004");
			}else{
				for(SMSModel smsM :smsList){
					result = SmsClient.sendSMS(smsM);
					LOG.debug("result = "+result);
				}
				this.doSearch();
				addMessageInfo("M0001");
			}
		}catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
		return false;
	}
//	
	private boolean doSendEmailOS(){
		semmel008Bean = getSEMMEL008Bean();
//		IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
		IManagementService service = (IManagementService)getBean("managementService");
		boolean result = false;
		StringBuffer rowId = new StringBuffer();
		Payment payment = new Payment();
		String groupNoTmp = "";
		for(PaymentWrapper wapper :semmel008Bean.getPaymentWrapperList()){
			
			if(wapper.isSelected()){
				for(Payment paymentObj : wapper.getPaymentList()){
					rowId.append(paymentObj.getRowId()+",");
				}
//				if(StringUtils.isNotEmpty(rentalPay.getPaymentGroupNo())){
//					groupNoTmp = rentalPay.getPaymentGroupNo();
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
			email.setV_type("P");
			email.setUserId(getUserLogIn());
			LOG.debug("rowId = "+rowId.toString());
			emailList = service.querySPList(EQueryName.SP_MEL009_MAIL.name, email);	
			
			if(emailList == null || emailList.size() == 0){
				addMessageError("E0004");
			}else{
				for(EMAILModel emailM :emailList){
//					emailM.setV_Message(emailM.getV_Message()+" FROM SEMMRT003-1");
					emailM.setV_Message(emailM.getV_Message());
					result = EmailMessageUtil.sendEmail(emailM);
					LOG.debug("result = "+result);
				}
				addMessageInfo("M0003");
				this.doSearch();
			}
			LOG.debug("result = "+result);
		}catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
		return result;
	}
	
	public boolean doInitialForSearchElectrical() {
		//log.info("::: SEMMCO001Action :: doInitialForSearchContract >> BEGIN :::");
		boolean flag = true;

		try {
			this.init();
			semmel008Bean = getSEMMEL008Bean();

			String paramUrl = getFacesUtils().getRequestParameter("paramUrl") == null ? "" : (String) getFacesUtils().getRequestParameter("paramUrl");
	        String paramMenuGroup = getFacesUtils().getRequestParameter("paramMenuGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuGroup");
	        String paramMenuSubGroup = getFacesUtils().getRequestParameter("paramMenuSubGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuSubGroup");
	        String paramParameter = getFacesUtils().getRequestParameter("paramParameter") == null ? "" : (String) getFacesUtils().getRequestParameter("paramParameter");
	        String company = getFacesUtils().getRequestParameter("company") == null ? "" : (String) getFacesUtils().getRequestParameter("company");
	        String region = getFacesUtils().getRequestParameter("region") == null ? "" : (String) getFacesUtils().getRequestParameter("region");
	        String elType = getFacesUtils().getRequestParameter("elType") == null ? "" : (String) getFacesUtils().getRequestParameter("elType");
//	        String elStatusName = getFacesUtils().getRequestParameter("elStatusName") == null ? "" : (String) getFacesUtils().getRequestParameter("elStatusName");
//	        String elStatusName = semmel001Bean.getTreeUtilBean().getElType() == null ? "" : (String)semmel001Bean.getTreeUtilBean().getElType();
	        
	        System.out.println("paramUrl: " + paramUrl);
	        System.out.println("paramMenuGroup: " + paramMenuGroup);
	        System.out.println("paramMenuSubGroup: " + paramMenuSubGroup);
	        System.out.println("paramParameter: " + paramParameter);
	        System.out.println("company: " + company);
	        System.out.println("region: " + region);
	        System.out.println("elType: " + elType);
//	        System.out.println("elStatusName: " + elStatusName);
	        
	        //semmcp001Bean.getCriteriaSP().setStrParam(paramParameter);
	        semmel008Bean.setRenderedOnToDoList(true); //

			//setSemmco001Bean(semmco001Bean);
//	        if(company != null){
//	        	semmel008Bean.getSearchCriteria().setCompany(company);
//	        }
//	        if(region != null){
//	        	semmel008Bean.getSearchCriteria().setRegion(region);
//	        }
//	        if(elType != null){
//	        	semmel008Bean.getSearchCriteria().setElectricUseType(elType);
//	        }
//	        if(elStatusName != null){
//	        	semmel008Bean.getSearchCriteria().setElAction(elStatusName);
//	        }
	        if(paramParameter != null){
	        	semmel008Bean.getSearchCriteria().setStrParam(paramParameter);
	        }
//	        semmel001Bean.getSearchCriteria().setCompany();
//	        semmel001Bean.getSearchCriteria().getRegion();
//	        semmel001Bean.getSearchCriteria().setElectricUseType();
//	        semmel001Bean.getSearchCriteria().setElAction();
	        setSemmel008Bean(semmel008Bean);
			
			this.doSearch();

		} catch(Exception e) {
			e.printStackTrace();
			addMessageError("EL0000", "SEMMEL001Action");
			flag = false;
			
		} finally {
			//log.info("::: SEMMCO001Action :: doInitialForSearchContract >> END :::");
		}
		return flag;
	}
}
