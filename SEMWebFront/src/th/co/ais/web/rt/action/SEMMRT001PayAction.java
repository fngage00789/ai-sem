package th.co.ais.web.rt.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import org.hsqldb.lib.StringUtil;

import th.co.ais.domain.pt.Mpt004Srch;
import th.co.ais.domain.rt.CheckVendor;
import th.co.ais.domain.rt.MrtGetRunningNo;
import th.co.ais.domain.rt.RentalPayNormalEditSaveSP;
import th.co.ais.domain.rt.RentalPayNormalSaveActSP;
import th.co.ais.domain.rt.RentalPayNormalSaveSP;
import th.co.ais.domain.rt.RentalPayNormalSearchDSP;
import th.co.ais.domain.rt.RentalPayNormalSearchSP;
import th.co.ais.rpt.util.bean.CellDomain;
import th.co.ais.rpt.util.bean.EnumDocStyleDomain;
import th.co.ais.rpt.util.bean.RowDomain;
import th.co.ais.rpt.util.enums.EnumDocStyle;
import th.co.ais.rpt.util.enums.EnumDocumentType;
import th.co.ais.service.rt.IRentalPaymentService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.report.util.DocumentExportManager;
import th.co.ais.web.rt.bean.SEMMRT001Bean;
import th.co.ais.web.rt.bean.SEMMRT001PayBean;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.MSGCacheUtil;
import th.co.ais.web.util.WebUtil;

public class SEMMRT001PayAction extends AbstractAction{

	private static final Log LOG = LogFactory.getLog(SEMMRT001Action.class);
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if(methodWithNavi.equalsIgnoreCase("doSearch")){
			flag = doSearch();
		}else if(methodWithNavi.equalsIgnoreCase("pageLoad")){
			flag = pageLoad();
		}else if(methodWithNavi.equalsIgnoreCase("doClear")){
			flag = doClear();
		}else if(methodWithNavi.equalsIgnoreCase("initEdit")){
			flag = initEdit();
		}else if(methodWithNavi.equalsIgnoreCase("doSavePay")){
			flag = doSavePay();
		}else if(methodWithNavi.equalsIgnoreCase("doSaveEdt")){
			flag = doSaveEdt();
		}else if (methodWithNavi.equalsIgnoreCase("doSaveAct")) {
			flag = doSaveAct();
		}else if (methodWithNavi.equalsIgnoreCase("initApprove")) {
			flag = initApprove();
		}else if (methodWithNavi.equalsIgnoreCase("doClearApproveStatus")) {
			flag = doClearApproveStatus();
		}
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

	
	private SEMMRT001PayBean semmrt001PayBean;
	private SEMMRT001Bean semmrt001Bean;
	
	public void setSemmrt001Bean(SEMMRT001Bean semmrt001Bean) {
		this.semmrt001Bean = semmrt001Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmrt001Bean", semmrt001Bean);
	}

	public SEMMRT001Bean getSemmrt001Bean() {
		return (SEMMRT001Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmrt001Bean");
	}
	
	public void setSemmrt001PayBean(SEMMRT001PayBean semmrt001PayBean) {
		this.semmrt001PayBean = semmrt001PayBean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmrt001PayBean", semmrt001PayBean);
	}

	public SEMMRT001PayBean getSemmrt001PayBean() {
		SEMMRT001PayBean SEMMRT001PayBean =(SEMMRT001PayBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmrt001PayBean");
		if(SEMMRT001PayBean == null){
			SEMMRT001PayBean = new SEMMRT001PayBean();
		}
		return SEMMRT001PayBean;
	}
	
	public boolean doSearch(){
		boolean flag = true;
		semmrt001PayBean = getSemmrt001PayBean();
		semmrt001PayBean.setChkSelAll(false);
		IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
		setSemmrt001PayBean(semmrt001PayBean);
		setParaneterRentalPayNormalNull();
		semmrt001PayBean.setRentalPayNormalSearchSPList(new ArrayList<WrapperBeanObject<RentalPayNormalSearchSP>>());
		List<RentalPayNormalSearchSP> to = null;
		String tempId = "";
//		if(!semmrt001PayBean.getPageMode().equals("RENTALPAYMENT") && !validateSearch()){
//			return flag;
//		}
//		if(semmrt001PayBean.getPageMode().equals("RENTALPAYMENT")){
//			semmrt001PayBean.getRentalPayNormalSearchSP().setDueDtTo(new Date());
//		}
		semmrt001PayBean.getRentalPayNormalSearchSP().setJobType("00");
		semmrt001PayBean.getRentalPayNormalSearchSP().setContractNo(semmrt001PayBean.getTmpContractNo());
		
		try {
			to = rentalPaymentService.querySPList(EQueryName.Q_SEARCH_RENTALPAY_NORMAL.name, semmrt001PayBean.getRentalPayNormalSearchSP());
			if(to == null || to.size() == 0){
				semmrt001PayBean.setRenderedMsgDataNotFound(true);
			 }else{
				 semmrt001PayBean.setRenderedMsgDataNotFound(false);
				 for(int i=0; i<to.size(); i++){
					 RentalPayNormalSearchSP rentalPayNormalSearchSP = (RentalPayNormalSearchSP)to.get(i);
					 WrapperBeanObject<RentalPayNormalSearchSP> tmpWrapperBean = new WrapperBeanObject<RentalPayNormalSearchSP>();
					 
					 
					 	if(rentalPayNormalSearchSP.getPaymentGroupNo() != null && tempId.equals(rentalPayNormalSearchSP.getPaymentGroupNo())){
						 rentalPayNormalSearchSP.setRenderColumn(false);
						}else{
							if(rentalPayNormalSearchSP.getPaymentGroupNo() != null){
								tempId = rentalPayNormalSearchSP.getPaymentGroupNo();
							}
							rentalPayNormalSearchSP.setRenderColumn(true);
						}
					 	//convert to thaiYear
						if(rentalPayNormalSearchSP.getEffDt() != null){
							rentalPayNormalSearchSP.setEffDt(SEMDataUtility.convertToThYear(rentalPayNormalSearchSP.getEffDt()));
						}
						if(rentalPayNormalSearchSP.getExpDt() != null){
							rentalPayNormalSearchSP.setExpDt(SEMDataUtility.convertToThYear(rentalPayNormalSearchSP.getExpDt()));
						}
						if(rentalPayNormalSearchSP.getDueDt() != null){
							rentalPayNormalSearchSP.setDueDt(SEMDataUtility.convertToThYear(rentalPayNormalSearchSP.getDueDt()));
						}
						if(rentalPayNormalSearchSP.getPaymentRequestDt() != null){
							rentalPayNormalSearchSP.setPaymentRequestDt(SEMDataUtility.convertToThYear(rentalPayNormalSearchSP.getPaymentRequestDt()));
						}
						if(rentalPayNormalSearchSP.getChqDt() != null){
							rentalPayNormalSearchSP.setChqDt(SEMDataUtility.convertToThYear(rentalPayNormalSearchSP.getChqDt()));
						}
						if(rentalPayNormalSearchSP.getChqReceiveDt() != null){
							rentalPayNormalSearchSP.setChqReceiveDt(SEMDataUtility.convertToThYear(rentalPayNormalSearchSP.getChqReceiveDt()));
						}
						if(rentalPayNormalSearchSP.getTransferDt() != null){
							rentalPayNormalSearchSP.setTransferDt(SEMDataUtility.convertToThYear(rentalPayNormalSearchSP.getTransferDt()));
						}
					 
					 tmpWrapperBean.setDataObj(rentalPayNormalSearchSP);
					 tmpWrapperBean.setMessage("");
					 tmpWrapperBean.setCheckBox(false);
					 semmrt001PayBean.getRentalPayNormalSearchSPList().add(tmpWrapperBean);
				 }
				 setSemmrt001PayBean(semmrt001PayBean);
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOG.error(e);
			addMessageError("E0003");
		}
		return flag;
	}
	
	public void setParaneterRentalPayNormalNull(){
		semmrt001PayBean = getSemmrt001PayBean();
		if(semmrt001PayBean.getRentalPayNormalSearchSP() == null){
			semmrt001PayBean.setRentalPayNormalSearchSP(new RentalPayNormalSearchSP());
		}
		semmrt001PayBean.getRentalPayNormalSearchSP().setPaymentStatus(null);
		semmrt001PayBean.getRentalPayNormalSearchSP().setCompany(null);
		semmrt001PayBean.getRentalPayNormalSearchSP().setRegion(null);
		semmrt001PayBean.getRentalPayNormalSearchSP().setPaymentType(null);
		semmrt001PayBean.getRentalPayNormalSearchSP().setDueDtTo(null);
		semmrt001PayBean.getRentalPayNormalSearchSP().setSiteName(null);
		semmrt001PayBean.getRentalPayNormalSearchSP().setSiteType(null);
		setSemmrt001PayBean(semmrt001PayBean);
	}
	
	private boolean validateSearch(){
		boolean flagValid = true;
		if(getSemmrt001PayBean().getRentalPayNormalSearchSP().getDueDtTo() == null){
			addMessageError(("W0001"), msg("message.dueDtTo"));
			flagValid = false;
		}
		return flagValid;
	}
	
	public boolean pageLoad(){
		boolean flag = false;
		String contractNo = (String)getFacesUtils().getRequestParameter("contractNo");
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		
		// Added flag by oum For check click btn ส่งเบิก
//		String flagSend = (String)getFacesUtils().getRequestParameter("flag");
		SEMMRT001Bean semmrt001Bean = new SEMMRT001Bean();
		semmrt001Bean = getSemmrt001Bean();
		semmrt001Bean.setRenderedMsgFormSearch(false);
		String status = semmrt001Bean.getDisplayFrmRental().getVerifyStatus();
		
		if(StringUtils.isNotEmpty(status)&& StringUtils.equalsIgnoreCase("02", status)){
			SEMMRT001PayBean semmrt001PayBean = new SEMMRT001PayBean();
			semmrt001PayBean.setPaymentTypeList(getLovItemsByType(ELovType.T_CT_PAYMENT_TYPE.name));
			semmrt001PayBean.setPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name));
			semmrt001PayBean.setDayPerYearList(getLovItemsByType(ELovType.T_CT_DAY_PER_YEAR.name));
			semmrt001PayBean.setDayPermonthList(getLovItemsByType(ELovType.T_CT_DAY_PER_MONTH.name));
			semmrt001PayBean.setVatTypeList(getLovItemsByType(ELovType.T_CT_VAT_TYPE.name));
			semmrt001PayBean.setRentalPayNormalSearchSP(new RentalPayNormalSearchSP());
			semmrt001PayBean.setRentalPayNormalSearchDSP(new RentalPayNormalSearchDSP());
			semmrt001PayBean.setRentalPayNormalSaveSP(new RentalPayNormalSaveSP());
			semmrt001PayBean.setRentalPayNormalEditSaveSP(new RentalPayNormalEditSaveSP());
			semmrt001PayBean.setRentalPayNormalSaveActSP(new RentalPayNormalSaveActSP());
			semmrt001PayBean.setCheckVendor(new CheckVendor());
			semmrt001PayBean.setTmpContractNo(contractNo);
			semmrt001PayBean.setPageMode(mode);
			setSemmrt001PayBean(semmrt001PayBean);
			flag = true;
		doSearch();
		}else{
			addMessageError("E0010");
			semmrt001Bean.setRenderedMsgFormSearch(true);
			
		}
		
		setSemmrt001Bean(semmrt001Bean);
		return flag;
	}
	
	public boolean doClear(){
		boolean flag = false;
		semmrt001PayBean = getSemmrt001PayBean();
		semmrt001PayBean.setRentalPayNormalSearchSP(new RentalPayNormalSearchSP());
		semmrt001PayBean.setRentalPayNormalSearchSPList(new ArrayList());
		semmrt001PayBean.setDisabledBtnExport(true);
		setSemmrt001PayBean(semmrt001PayBean);
		return flag;
	}
	
	private boolean initEdit(){
		boolean flag = false;
		semmrt001PayBean = getSemmrt001PayBean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
		semmrt001PayBean.getRentalPayNormalSearchDSP().setRowId(rowId);
		String statusEdit = (String)getFacesUtils().getRequestParameter("statusEdit");
		String paymentGroupNo = (String)getFacesUtils().getRequestParameter("paymentGroupNo");
		String vendorMasterId = (String)getFacesUtils().getRequestParameter("vendorMasterId");
		String payeeId = (String)getFacesUtils().getRequestParameter("payeeId");
		String expenseType = (String)getFacesUtils().getRequestParameter("expenseType");
		String contractNo = (String)getFacesUtils().getRequestParameter("contractNo");
		String pageStatus = (String)getFacesUtils().getRequestParameter("pageStatus");
		semmrt001PayBean.setPaymentGroupno(paymentGroupNo);
		if(semmrt001PayBean.getCheckVendor() == null){
			semmrt001PayBean.setCheckVendor(new CheckVendor());
		}
		semmrt001PayBean.getCheckVendor().setVendorMasterId(vendorMasterId);
		semmrt001PayBean.getCheckVendor().setPayeeMasterId(payeeId);
		semmrt001PayBean.getCheckVendor().setExpenseType(expenseType);
		semmrt001PayBean.getCheckVendor().setContractNo(contractNo);
		
		semmrt001PayBean.setMsgHeaderPopup1("");
		semmrt001PayBean.setMsgHeaderPopup2("");
		semmrt001PayBean.setRenderedMsgFormSearch(false);
		semmrt001PayBean.setRenderedMsgFormMiddle(false);
		semmrt001PayBean.setRenderedMsgFormTop(false);
		semmrt001PayBean.setRenderedMsgFormPopup(false);
		List<RentalPayNormalSearchDSP> to = null;
		List<CheckVendor> to2 = null;
		semmrt001PayBean.setRowId(rowId);
			try {
				to = rentalPaymentService.querySPList(EQueryName.Q_SEARCH_RENTALPAY_NORMAL_D.name, semmrt001PayBean.getRentalPayNormalSearchDSP());
				to2 = rentalPaymentService.querySPList(EQueryName.SP_CHECK_VENDOR.name, semmrt001PayBean.getCheckVendor());
				if(to != null || to.size() != 0){
					if(to.get(0).getDepositFlag().equals("Y")){
						semmrt001PayBean.setChkDeposit(true);
					}else{
						semmrt001PayBean.setChkDeposit(false);
					}
					//Less money
					to.get(0).setPaymentAmt((to.get(0).getTotalAmt()!=null?to.get(0).getTotalAmt():0.0 )- (to.get(0).getDepositAmt()!=null?to.get(0).getDepositAmt():0.00));
					
					//get excAmt vatAmt whtAmt add bean Because validate + - 1
					semmrt001PayBean.setOldExcAmt(to.get(0).getExcAmt());
					semmrt001PayBean.setOldVatAmt(to.get(0).getVatAmt());
					semmrt001PayBean.setOldWhtAmt(to.get(0).getWhtAmt());
					semmrt001PayBean.setOldIncAmt(to.get(0).getIncAmt());
					semmrt001PayBean.setOldTotalAmt(to.get(0).getTotalAmt());
					
					//get Deposit for enable chkDeposit
					semmrt001PayBean.setTmpDepositAmt(to.get(0).getDepositAmt());
					
					semmrt001PayBean.setRentalPayNormalSearchDSP(to.get(0));
					
					if(statusEdit != null && statusEdit.equals("savePay")){
						onRenderPaymentMethod();
						onRenderDepositAmt();
					}else{
						onRenderDayPerYearAndMonth();
						onRenderVatRate();
						onRenderTotalAmt();
						onRenderIncludeAmt();
					}
				}
				if(pageStatus.equals("SavePay") && !to2.isEmpty() && to2.get(0) != null){
					for(int i=0; i<to2.size(); i++){
						CheckVendor chv = (CheckVendor)to2.get(i);
						if(chv != null){
							if(i==0){
								addGeneralMessageError(chv.getMsgWarning());
								semmrt001PayBean.setMsgHeaderPopup1(chv.getMsgWarning());
							}
							if(i==1){
								addGeneralMessageError(chv.getMsgWarning());
								semmrt001PayBean.setMsgHeaderPopup2(chv.getMsgWarning());
							}
						}
						semmrt001PayBean.setRenderedMsgFormTop(true);
					}
				}else{
					semmrt001PayBean.setRenderedMsgFormTop(false);
				}
				flag = true;
			} catch (Exception e) {
				e.printStackTrace();
				LOG.error(e);
				addMessageError(("E0003"));
			}
		setSemmrt001PayBean(semmrt001PayBean);
		return flag;
	}
	
	private boolean doSavePay(){
		boolean flag = false;
		semmrt001PayBean = getSemmrt001PayBean();
		boolean flagException = true;
		if(!validateSave()){
			semmrt001PayBean.setPopupClose(new Boolean(false));
			semmrt001PayBean.setRenderedMsgFormTop(false);
			semmrt001PayBean.setRenderedMsgFormBottom(false);
			semmrt001PayBean.setRenderedMsgFormMiddle(false);
			return flag;
		}
		semmrt001PayBean.getRentalPayNormalSaveSP().setPaymentGroupNo(semmrt001PayBean.getPaymentGroupno());
		semmrt001PayBean.getRentalPayNormalSaveSP().setDepositAmt(semmrt001PayBean.getRentalPayNormalSearchDSP().getDepositAmt());
		semmrt001PayBean.getRentalPayNormalSaveSP().setPaymentType(semmrt001PayBean.getRentalPayNormalSearchDSP().getPaymentType());
		semmrt001PayBean.getRentalPayNormalSaveSP().setPaymentMethod(semmrt001PayBean.getRentalPayNormalSearchDSP().getPaymentMethod());
		semmrt001PayBean.getRentalPayNormalSaveSP().setChqDt(semmrt001PayBean.getRentalPayNormalSearchDSP().getChqDt());
		semmrt001PayBean.getRentalPayNormalSaveSP().setChqReceiveDt(semmrt001PayBean.getRentalPayNormalSearchDSP().getChqReceiveDt());
		semmrt001PayBean.getRentalPayNormalSaveSP().setTransferDt(semmrt001PayBean.getRentalPayNormalSearchDSP().getTransferDt());
		semmrt001PayBean.getRentalPayNormalSaveSP().setRemark(semmrt001PayBean.getRentalPayNormalSearchDSP().getRemark());
		semmrt001PayBean.getRentalPayNormalSaveSP().setUserId(getUserLogIn());
		IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
		List<RentalPayNormalSaveSP> to = null;
		
		try {
			to = rentalPaymentService.querySPList(EQueryName.SP_MRT003_PAY.name, semmrt001PayBean.getRentalPayNormalSaveSP());
			doSearch();
			if (to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")) {
				semmrt001PayBean.setPopupClose(new Boolean(true));
				semmrt001PayBean.setRenderedMsgFormSearch(false);
				semmrt001PayBean.setRenderedMsgFormTop(true);
				addMessageInfo("M0001");
			}else if(to != null && !to.isEmpty()){
				FrontMessageUtils.addMessageError(to.get(0).getpRemark());
				semmrt001PayBean.setRenderedMsgFormSearch(true);
			}		
			setSemmrt001PayBean(semmrt001PayBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOG.error(e);
			addMessageError("E0001");
			semmrt001PayBean.setValidatePopup("");
		}
		return flag;
	}
	
	public void doExportExcel(){
		semmrt001PayBean = getSemmrt001PayBean();
		String payType = "";
		String renType = "";
		String chqDt = "";
		String chqRecDt = "";
		String tranfDt = "";
		String tempPaymentGroup = "";
		
		for (WrapperBeanObject<RentalPayNormalSearchSP> temp : semmrt001PayBean.getRentalPayNormalSearchSPList()) {
			RentalPayNormalSearchSP rt = (RentalPayNormalSearchSP)temp.getDataObj();
			if(temp.isCheckBox()){
				tempPaymentGroup = rt.getPaymentGroupNo();
				payType = rt.getPaymentType();
				if("01".equals(rt.getPaymentType())){
					renType = StringUtils.isNotEmpty(rt.getPaymentTypeDesc())?rt.getPaymentTypeDesc():"" + (StringUtils.isNotEmpty(rt.getBankName())?rt.getBankName():"");
					if(rt.getChqDt() != null){
						chqDt = new SimpleDateFormat("dd/MM/yyyy").format(rt.getChqDt());
					}
					if(rt.getChqReceiveDt() != null){
						chqRecDt = new SimpleDateFormat("dd/MM/yyyy").format(rt.getChqReceiveDt());
					}
				}else{
					renType = rt.getPaymentTypeDesc();
					if(rt.getTransferDt() != null){
						tranfDt = new SimpleDateFormat("dd/MM/yyyy").format(rt.getTransferDt());
					}
				}
			}else if(rt.getPaymentGroupNo() != null && rt.getPaymentGroupNo().equals(tempPaymentGroup)){
				temp.setCheckBox(true);
			}
		}
		
		try{
			DateFormat df =  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
			IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
		    List<MrtGetRunningNo> to = null;
		    semmrt001PayBean.setMrtGetRunningNo(new MrtGetRunningNo());
		    semmrt001PayBean.getMrtGetRunningNo().setRunningType("RT_PAY_BATCH");
		    to = rentalPaymentService.querySPList(EQueryName.SP_MRT_GET_RUNNING_NO.name, semmrt001PayBean.getMrtGetRunningNo());
		    
		    short line = 0;
			Collection<RentalPayNormalSearchSP> exList = new ArrayList<RentalPayNormalSearchSP>();
			DocumentExportManager<RentalPayNormalSearchSP> docManager =
				new DocumentExportManager<RentalPayNormalSearchSP>(RentalPayNormalSearchSP.class, EnumDocumentType.XLS);
				docManager.setRowStart(line);
			
			RowDomain row0 = new RowDomain(0,true);	
			row0.setCell(new CellDomain(0,5, null, String.class, new EnumDocStyleDomain(EnumDocStyle.TITLE), msg("export.col.rentalpayNormalHeader")+" "+msg("export.col.date")+" "+df.format(new Date()),null));
			
			RowDomain row1 = new RowDomain(1,true);	
			row1.setCell(new CellDomain(0,5, null, String.class, new EnumDocStyleDomain(EnumDocStyle.TITLE), msg("export.col.paymentBatchNo")+" "+to.get(0).getRunningNo(),null));
			
			RowDomain row2 = new RowDomain(2,true);
			EnumDocStyleDomain field = docManager.getStyle("normalField");
			EnumDocStyleDomain 	headerStyle =  docManager.getStyle("rt003FieldHeader");
			EnumDocStyleDomain 	titleStyle =  new EnumDocStyleDomain(EnumDocStyle.TITLE);
			RowDomain row3 = new RowDomain(3,true);
			row3.setCell(new CellDomain(0, null, String.class, headerStyle, msg("export.col.no"),-1,1000));
			row3.setCell(new CellDomain(1, null, String.class, headerStyle, msg("export.col.paymentDocNo"),-1,2900));
			row3.setCell(new CellDomain(2, null, String.class, headerStyle, "Vendor Code",-1,2800));
			row3.setCell(new CellDomain(3, null, String.class, headerStyle,msg("export.col.contractNo"),-1,2700));
			row3.setCell(new CellDomain(4, null, String.class, headerStyle,msg("export.col.rentalapyNormalSiteName"),-1,4000));
			row3.setCell(new CellDomain(5, null, String.class, headerStyle,"Due Date",-1,2200));
//			row3.setCell(new CellDomain(6, null, String.class, headerStyle,msg("export.col.jobType"),-1,5000));
			row3.setCell(new CellDomain(6, null, String.class, headerStyle,msg("export.col.payPeriodType"),-1,2550));
			row3.setCell(new CellDomain(7, null, String.class, headerStyle,msg("export.col.periodNo"),-1,1200));
			row3.setCell(new CellDomain(8, null, String.class, headerStyle,"Vendor Name",-1,3500));
			row3.setCell(new CellDomain(9, null, String.class, headerStyle,"Payee",-1,4000));
			row3.setCell(new CellDomain(10, null, String.class, headerStyle,"WHT Type",-1,2300));
			row3.setCell(new CellDomain(11, null, String.class, headerStyle,"Amount",-1,2500));
			row3.setCell(new CellDomain(12, null, String.class, headerStyle,"WHT AMT",-1,2500));
			row3.setCell(new CellDomain(13, null, String.class, headerStyle,"NET AMT",-1,2500));
//			row3.setCell(new CellDomain(15, null, String.class, headerStyle,msg("export.col.paymentTypeDesc"),-1,3000));
			
			List<WrapperBeanObject<RentalPayNormalSearchSP>> detailList = new ArrayList<WrapperBeanObject<RentalPayNormalSearchSP>>();
			detailList = getSemmrt001PayBean().getRentalPayNormalSearchSPList();
			int no = 0;
			SelectItem jobType = WebUtil.getSelectItemByValue("01", getLovItemsByType(ELovType.T_RT_JOB_TYPE_N.name)).get(0);
			for(int i=0; i<detailList.size(); i++){
				WrapperBeanObject<RentalPayNormalSearchSP> detail = new WrapperBeanObject<RentalPayNormalSearchSP>();
				detail = detailList.get(i);
				if(detail.isCheckBox()){
					 ++no;
					((RentalPayNormalSearchSP)detail.getDataObj()).setNo(no);
					((RentalPayNormalSearchSP)detail.getDataObj()).setJobType(StringUtils.isEmpty(jobType.getValue().toString())?"":jobType.getLabel());
					exList.add((RentalPayNormalSearchSP)detail.getDataObj());
				}
			}
			
			RowDomain row5 = new RowDomain(0,false);
			
			RowDomain row4 = new RowDomain(1,false);
			RowDomain row6 = new RowDomain(2,false);
			RowDomain row7 = new RowDomain(3,false);
			
			if("01".equals(payType)){
				row4.setCell(new CellDomain(1, null, String.class, titleStyle, msg("export.col.paymentTypeDesc")+" : ",null));
				row4.setCell(new CellDomain(2, null, String.class, field, (StringUtils.isEmpty(renType)?"":renType),null));
				row6.setCell(new CellDomain(1, null, String.class, titleStyle, msg("export.column.contract.chqDt")+" : ",null));
				row6.setCell(new CellDomain(2, null, String.class, field, (StringUtils.isEmpty(chqDt)?"":chqDt),null));
				row7.setCell(new CellDomain(1, null, String.class, titleStyle, msg("export.column.contract.chqRecDt")+" : ",null));
				row7.setCell(new CellDomain(2, null, String.class, field, (StringUtils.isEmpty(chqRecDt)?"":chqRecDt),null));
				docManager.putDetailRow(row6);
			}else{
				row4.setCell(new CellDomain(1, null, String.class, titleStyle, msg("export.col.paymentTypeDesc")+" : ",null));
				row4.setCell(new CellDomain(2, null, String.class, field, (StringUtils.isEmpty(renType)?"":renType),null));
				row7.setCell(new CellDomain(1, null, String.class, titleStyle, msg("export.column.contract.tranDt")+" : ",null));
				row7.setCell(new CellDomain(2, null, String.class, field, (StringUtils.isEmpty(tranfDt)?"":tranfDt),null));
			}
			
			docManager.putDetailRow(row0);
			docManager.putDetailRow(row1);
			docManager.putDetailRow(row2);
			docManager.putDetailRow(row3);
			docManager.putDetailRow(row4);
			docManager.putDetailRow(row5);
			docManager.putDetailRow(row6);
			docManager.putDetailRow(row7);
			docManager.setMargin(0, 0, 0, 0);
			docManager.seteObjectList(exList);
			docManager.setPrintPageLandScape(true);
			docManager.setModule("RENTAL" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
			docManager.getObjectFromDocument();
			docManager.exportServletFile();
		}catch(Exception e){
			e.printStackTrace();
			LOG.error(e);
		}
	}
	
	private boolean validateSave() {
		boolean flgValid = true;
		if(StringUtils.isNotEmpty(getSemmrt001PayBean().getMsgHeaderPopup1())){
			addGeneralMessageError(getSemmrt001PayBean().getMsgHeaderPopup1());
		}
		if(StringUtils.isNotEmpty(getSemmrt001PayBean().getMsgHeaderPopup2())){
			addGeneralMessageError(getSemmrt001PayBean().getMsgHeaderPopup2());
		}
		if(StringUtils.isEmpty(getSemmrt001PayBean().getRentalPayNormalSearchDSP().getPaymentType())){
			addMessageError(("W0001"), msg("message.paymentType"));
			flgValid = false;
		}
		
		if("02".equals(getSemmrt001PayBean().getRentalPayNormalSearchDSP().getPaymentType())){
			if(StringUtils.isEmpty(getSemmrt001PayBean().getRentalPayNormalSearchDSP().getBankAccNo())){
				addMessageError(("W0059"), msg("label.bankAccNo"));
				flgValid = false;
			}
		}
		
		
		if(StringUtils.isEmpty(getSemmrt001PayBean().getRentalPayNormalSearchDSP().getPaymentMethod()) &&
		   getSemmrt001PayBean().isRenderedPaymentMethod() == false){
			addMessageError(("W0001"), msg("message.paymentMethod"));
			flgValid = false;
		}
		if(getSemmrt001PayBean().getRentalPayNormalSearchDSP().getChqDt() == null &&
				getSemmrt001PayBean().isRenderedChqDt() == false){
			addMessageError(("W0001"), msg("message.chqDt"));
			flgValid = false;
		}
		if(getSemmrt001PayBean().getRentalPayNormalSearchDSP().getChqReceiveDt() == null &&
				getSemmrt001PayBean().isRenderedChqDt() == false){
			addMessageError(("W0001"), msg("message.chqReceiveDt"));
			flgValid = false;
		}
		if(getSemmrt001PayBean().getRentalPayNormalSearchDSP().getTransferDt() == null &&
				getSemmrt001PayBean().isRenderedTransferDt() == false){
			addMessageError(("W0001"), msg("message.transferDt"));
			flgValid = false;
			
		}
		return flgValid;
	}
	
	public boolean doSaveEdt(){
		boolean flag = false;
		semmrt001PayBean = getSemmrt001PayBean();
		boolean flagException = true;
		IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
		List<RentalPayNormalEditSaveSP> to = null;
		
		semmrt001PayBean.getRentalPayNormalEditSaveSP().setRentalPaymentId(semmrt001PayBean.getRowId());
		semmrt001PayBean.getRentalPayNormalEditSaveSP().setCalYear(semmrt001PayBean.getRentalPayNormalSearchDSP().getCalYear());
		semmrt001PayBean.getRentalPayNormalEditSaveSP().setCalMonth(semmrt001PayBean.getRentalPayNormalSearchDSP().getCalMonth());
		semmrt001PayBean.getRentalPayNormalEditSaveSP().setVatType(semmrt001PayBean.getRentalPayNormalSearchDSP().getVatType());
		semmrt001PayBean.getRentalPayNormalEditSaveSP().setExcAmt(semmrt001PayBean.getRentalPayNormalSearchDSP().getExcAmt());
		semmrt001PayBean.getRentalPayNormalEditSaveSP().setVatRate(semmrt001PayBean.getRentalPayNormalSearchDSP().getVatRate());
		semmrt001PayBean.getRentalPayNormalEditSaveSP().setVatAmt(semmrt001PayBean.getRentalPayNormalSearchDSP().getVatAmt());
		semmrt001PayBean.getRentalPayNormalEditSaveSP().setIncAmt(semmrt001PayBean.getRentalPayNormalSearchDSP().getIncAmt());
		semmrt001PayBean.getRentalPayNormalEditSaveSP().setWhtRate(semmrt001PayBean.getRentalPayNormalSearchDSP().getWhtRate());
		semmrt001PayBean.getRentalPayNormalEditSaveSP().setWhtAmt(semmrt001PayBean.getRentalPayNormalSearchDSP().getWhtAmt());
		semmrt001PayBean.getRentalPayNormalEditSaveSP().setUserId(semmrt001PayBean.getUserLogin());
		try {
			to = rentalPaymentService.querySPList(EQueryName.SP_MRT003_EDT.name, semmrt001PayBean.getRentalPayNormalEditSaveSP());
			if (to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")) {
				addMessageInfo("M0001");
				semmrt001PayBean.setPopupClose(new Boolean(true));
			}else if(to != null && !to.isEmpty()){
				FrontMessageUtils.addMessageError(to.get(0).getpRemark());
			}		
			setSemmrt001PayBean(semmrt001PayBean);
			doSearch();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOG.error(e);
			addMessageError("E0001");			
			semmrt001PayBean.setValidatePopup("");
		}
		return flag;
	}
	
	public boolean doSaveAct(){
		boolean flag = false;
		String rowsIdConcat = "";
		String tempPaymentGroup = "";
		String btnStatus = "";
		int i = 0;
		semmrt001PayBean = getSemmrt001PayBean();
		IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
		
		if(semmrt001PayBean.getBtnApproveStatus() != null && !StringUtils.isEmpty(semmrt001PayBean.getBtnApproveStatus())){
			btnStatus = semmrt001PayBean.getBtnApproveStatus();
			if(semmrt001PayBean.getBtnApproveStatus().equals("CA") && !validateApprove()){
				semmrt001PayBean.setPopupClose(false);
				return flag;
			}
			semmrt001PayBean.setPopupClose(true);
			semmrt001PayBean.getRentalPayNormalSaveActSP().setRemark(semmrt001PayBean.getRemark());
		}else{
			btnStatus = (String)getFacesUtils().getRequestParameter("btnStatus");
			if(!StringUtils.isEmpty(semmrt001PayBean.getBtnStatus())){
				btnStatus = semmrt001PayBean.getBtnStatus();
			}
			semmrt001PayBean.getRentalPayNormalSaveActSP().setRemark(null);
		}
	
		List<RentalPayNormalSaveActSP> to = null;
		
		// loop for Concat RowId
		for (WrapperBeanObject<RentalPayNormalSearchSP> temp : semmrt001PayBean.getRentalPayNormalSearchSPList()) {
			RentalPayNormalSearchSP rt = (RentalPayNormalSearchSP)temp.getDataObj();
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
			i++;
		}
		if(btnStatus.equals("AG")){
			if(!validateSaveAct()){
				FrontMessageUtils.addMessageError(msg("message.totalDisbursement"));
				return flag;
			}
		}
		
		semmrt001PayBean.getRentalPayNormalSaveActSP().setRowId(rowsIdConcat);
		semmrt001PayBean.getRentalPayNormalSaveActSP().setActionType(btnStatus);
		semmrt001PayBean.getRentalPayNormalSaveActSP().setUserId(getUserLogIn());
		try {
			to = rentalPaymentService.querySPList(EQueryName.SP_MRT003_ACT.name, semmrt001PayBean.getRentalPayNormalSaveActSP());
			
			doSearch();
			doClearApproveStatus();
			
			if (to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")) {
				semmrt001PayBean.setPopupClose(new Boolean(true));
				semmrt001PayBean.setRenderedMsgFormTop(true);
				addMessageInfo("M0001");
			}else if(to != null && !to.isEmpty()){
				FrontMessageUtils.addMessageError(to.get(0).getpRemark());
			}
			semmrt001PayBean.setBtnStatus("");
			setSemmrt001PayBean(semmrt001PayBean);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("E0001");
		}
		return flag;
	}
	
	private boolean validateSaveAct() {
		boolean flgValid = true;
		semmrt001PayBean = getSemmrt001PayBean();
		int i = 0;
		String vendorCode = "";
		String payeeId = "";
		for (WrapperBeanObject<RentalPayNormalSearchSP> temp : semmrt001PayBean.getRentalPayNormalSearchSPList()) {
			RentalPayNormalSearchSP rt = (RentalPayNormalSearchSP)temp.getDataObj();
			if(temp.isCheckBox() && i==0){
				vendorCode = rt.getVendorCode();
				payeeId = rt.getPayeeId();
				i++;
			}
			if(temp.isCheckBox() && !StringUtils.equals(vendorCode, rt.getVendorCode()) 
			  || temp.isCheckBox() && !StringUtils.equals(payeeId, rt.getPayeeId())){
				
				flgValid = false;
				break;
			}
		}
		return flgValid;
	}
	
	public boolean initApprove(){
		boolean flag = false;
		semmrt001PayBean = getSemmrt001PayBean();
		String btnApproveStatus = (String)getFacesUtils().getRequestParameter("btnApproveStatus");
		semmrt001PayBean.setBtnApproveStatus(btnApproveStatus);
		setSemmrt001PayBean(semmrt001PayBean);
		return flag;
	}
	
	public boolean doClearApproveStatus(){
		boolean flag = false;
		semmrt001PayBean = getSemmrt001PayBean();
		semmrt001PayBean.setBtnApproveStatus("");
		setSemmrt001PayBean(semmrt001PayBean);
		return flag;
	}
	
	private boolean validateApprove(){
		boolean flgValid = true;
		semmrt001PayBean = getSemmrt001PayBean();
		if(StringUtils.isEmpty(getSemmrt001PayBean().getRemark())){
			FrontMessageUtils.addMessageError(
					SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), msg("message.remark")));
			flgValid = false;
		}
		return flgValid;
	}
	
	public void onRenderPaymentMethod(){
		semmrt001PayBean = getSemmrt001PayBean();
		semmrt001PayBean.setRenderedChqDt(true);
		semmrt001PayBean.setRenderedTransferDt(true);
		semmrt001PayBean.setRenderedPaymentMethod(false);
		if(semmrt001PayBean.getRentalPayNormalSearchDSP().getPaymentType() != null && semmrt001PayBean.getRentalPayNormalSearchDSP().getPaymentType().equals("01")){
			semmrt001PayBean.setPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name, EX_IN, "CHEQUE", null, null));
			semmrt001PayBean.setRenderedChqDt(false);
			//Clear Text field
			semmrt001PayBean.getRentalPayNormalSearchDSP().setTransferDt(null);
		}
		if(semmrt001PayBean.getRentalPayNormalSearchDSP().getPaymentType() != null && semmrt001PayBean.getRentalPayNormalSearchDSP().getPaymentType().equals("02")){
		
			semmrt001PayBean.setPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name, EX_IN, "TRANSFER", null, null));
			semmrt001PayBean.setRenderedTransferDt(false);
//			semmrt001PayBean.getRentalPayNormalSearchDSP().setPaymentMethod("05");
			//addded by NEW 20150828 check null befor set default paymentMethod
			if(semmrt001PayBean.getRentalPayNormalSearchDSP().getPaymentMethod() == null || 
					semmrt001PayBean.getRentalPayNormalSearchDSP().getPaymentMethod().equals(""))
				semmrt001PayBean.getRentalPayNormalSearchDSP().setPaymentMethod("05");
			//end added
			//Clear Text field
			semmrt001PayBean.getRentalPayNormalSearchDSP().setChqDt(null);
			semmrt001PayBean.getRentalPayNormalSearchDSP().setChqReceiveDt(null);
		}
		if(semmrt001PayBean.getRentalPayNormalSearchDSP().getPaymentType() != null && semmrt001PayBean.getRentalPayNormalSearchDSP().getPaymentType().equals("03")){
			semmrt001PayBean.setRenderedPaymentMethod(true);
			//Clear Text field
			semmrt001PayBean.getRentalPayNormalSearchDSP().setChqDt(null);
			semmrt001PayBean.getRentalPayNormalSearchDSP().setChqReceiveDt(null);
			semmrt001PayBean.getRentalPayNormalSearchDSP().setTransferDt(null);
		}
	}
	
	public void onRenderDepositAmt(){
		semmrt001PayBean = getSemmrt001PayBean();
		if(semmrt001PayBean.isChkDeposit() && semmrt001PayBean.isChkDeposit()==true){
			semmrt001PayBean.setRenderedDepositAmt(false);
			semmrt001PayBean.getRentalPayNormalSearchDSP().setDepositAmt(semmrt001PayBean.getTmpDepositAmt());
		}else{
			semmrt001PayBean.setRenderedDepositAmt(true);
			semmrt001PayBean.getRentalPayNormalSearchDSP().setDepositAmt(null);
		}
		setSemmrt001PayBean(semmrt001PayBean);
	}
	
	public void onRenderDayPerYearAndMonth(){
		semmrt001PayBean = getSemmrt001PayBean();
		semmrt001PayBean.setRenderedMonth(true);
		semmrt001PayBean.setRenderedYear(true);
		
		if(semmrt001PayBean.getRentalPayNormalSearchDSP().getPeriodType() == null){
			semmrt001PayBean.setRenderedMonth(false);
			semmrt001PayBean.setRenderedYear(false);
		}
		
//		if(semmrt001PayBean.getRentalPayNormalSearchDSP().getPeriodType() != null
//		   && semmrt001PayBean.getRentalPayNormalSearchDSP().getPeriodType().equals("01") 
//		   || semmrt001PayBean.getRentalPayNormalSearchDSP().getPeriodType().equals("03")){
//			if(semmrt001PayBean.getRentalPayNormalSearchDSP().getPeriodD() != null
//			    && semmrt001PayBean.getRentalPayNormalSearchDSP().getPeriodD()>0){
//				semmrt001PayBean.setRenderedMonth(false);
//			}
//		}
//		if(semmrt001PayBean.getRentalPayNormalSearchDSP().getPeriodType() != null
//		   || semmrt001PayBean.getRentalPayNormalSearchDSP().getPeriodType().equals("02") 
//		   || semmrt001PayBean.getRentalPayNormalSearchDSP().getPeriodType().equals("04")){
//			if(semmrt001PayBean.getRentalPayNormalSearchDSP().getPeriodD() != null
//				&& semmrt001PayBean.getRentalPayNormalSearchDSP().getPeriodD()>0){
//				semmrt001PayBean.setRenderedYear(false);
//			}
//		}
		setSemmrt001PayBean(semmrt001PayBean);
	}
	
	public void onRenderVatRate(){
		semmrt001PayBean = getSemmrt001PayBean();
		semmrt001PayBean.setRenderedvatRate(false);
		semmrt001PayBean.setRenderedWhtRate(false);
		if(semmrt001PayBean.getRentalPayNormalSearchDSP().getVatRate() == null ||
			semmrt001PayBean.getRentalPayNormalSearchDSP().getVatRate() == 0){
			semmrt001PayBean.setRenderedvatRate(true);
		}
		if(semmrt001PayBean.getRentalPayNormalSearchDSP().getWhtRate() == null ||
			semmrt001PayBean.getRentalPayNormalSearchDSP().getWhtRate() == 0){
			semmrt001PayBean.setRenderedWhtRate(true);
		}
		setSemmrt001PayBean(semmrt001PayBean);
	}
	
	// Total Amount
	public void onRenderTotalAmt(){
		semmrt001PayBean = getSemmrt001PayBean();
		if(!validateTotalAmount()){
			addMessageError("W0031");
		}else{
			semmrt001PayBean.getRentalPayNormalSearchDSP().setTotalAmt(
					(semmrt001PayBean.getRentalPayNormalSearchDSP().getIncAmt()!=null?semmrt001PayBean.getRentalPayNormalSearchDSP().getIncAmt():0.00 )
				  - (semmrt001PayBean.getRentalPayNormalSearchDSP().getWhtAmt()!=null?semmrt001PayBean.getRentalPayNormalSearchDSP().getWhtAmt():0.00));
		}
		setSemmrt001PayBean(semmrt001PayBean);
	}
	
	public boolean validateTotalAmount(){
		boolean flagValid = true;
		semmrt001PayBean = getSemmrt001PayBean();
		Double defaultValPositive = 1.00;
		Double defaultValNegasitive = -1.00;
		if(semmrt001PayBean.getRentalPayNormalSearchDSP().getExcAmt() != null){
			if(semmrt001PayBean.getOldExcAmt() == null){
				semmrt001PayBean.setOldExcAmt(0.00);
			}
			Double tmpExcAmt = semmrt001PayBean.getOldExcAmt() - semmrt001PayBean.getRentalPayNormalSearchDSP().getExcAmt();
			if(tmpExcAmt > defaultValPositive || tmpExcAmt < defaultValNegasitive){
				semmrt001PayBean.getRentalPayNormalSearchDSP().setExcAmt(semmrt001PayBean.getOldExcAmt());
				semmrt001PayBean.getRentalPayNormalSearchDSP().setIncAmt(semmrt001PayBean.getOldIncAmt());
				flagValid = false;
			}
		}
		if(semmrt001PayBean.getRentalPayNormalSearchDSP().getVatAmt() != null){
			if(semmrt001PayBean.getOldVatAmt() == null){
				semmrt001PayBean.setOldVatAmt(0.00);
			}
			Double tmpVatAmt = semmrt001PayBean.getOldVatAmt() - semmrt001PayBean.getRentalPayNormalSearchDSP().getVatAmt();
			if(tmpVatAmt > defaultValPositive || tmpVatAmt < defaultValNegasitive){
				semmrt001PayBean.getRentalPayNormalSearchDSP().setVatAmt(semmrt001PayBean.getOldVatAmt());
				semmrt001PayBean.getRentalPayNormalSearchDSP().setIncAmt(semmrt001PayBean.getOldIncAmt());
				flagValid = false;
			}
		}
		if(semmrt001PayBean.getRentalPayNormalSearchDSP().getWhtAmt() != null){
			if(semmrt001PayBean.getOldWhtAmt() == null){
				semmrt001PayBean.setOldWhtAmt(0.00);
			}
			Double tmpWhtAmt = semmrt001PayBean.getOldWhtAmt() - semmrt001PayBean.getRentalPayNormalSearchDSP().getWhtAmt();
			if(tmpWhtAmt > defaultValPositive || tmpWhtAmt < defaultValNegasitive){
				semmrt001PayBean.getRentalPayNormalSearchDSP().setWhtAmt(semmrt001PayBean.getOldWhtAmt());
				semmrt001PayBean.getRentalPayNormalSearchDSP().setTotalAmt(semmrt001PayBean.getOldTotalAmt());
				flagValid = false;
			}
		}
		setSemmrt001PayBean(semmrt001PayBean);
		return flagValid;
	}
	
	// Include Total
	public void onRenderIncludeAmt(){
		semmrt001PayBean = getSemmrt001PayBean();
		if(!validateTotalAmount()){
			addMessageError("W0031");
		}else{
			semmrt001PayBean.getRentalPayNormalSearchDSP().setIncAmt(
					(semmrt001PayBean.getRentalPayNormalSearchDSP().getExcAmt()!=null?semmrt001PayBean.getRentalPayNormalSearchDSP().getExcAmt():0.00 )
				  + (semmrt001PayBean.getRentalPayNormalSearchDSP().getVatAmt()!=null?semmrt001PayBean.getRentalPayNormalSearchDSP().getVatAmt():0.00));
		}
		setSemmrt001PayBean(semmrt001PayBean);
	}
	
	public void selectAllRow(){
		try{
			boolean chkAll = getSemmrt001PayBean().isChkSelAll();
			List<WrapperBeanObject<RentalPayNormalSearchSP>> detailList = new ArrayList<WrapperBeanObject<RentalPayNormalSearchSP>>();
			detailList = getSemmrt001PayBean().getRentalPayNormalSearchSPList();
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
		getSemmrt001PayBean().setTmpRowId(rowId);
		
		if(isCheckSELBox())
			getSemmrt001PayBean().setDisabledBtnExport(false);
		else
			getSemmrt001PayBean().setDisabledBtnExport(true);
	}
	
	private boolean isCheckSELBox(){
		boolean isCheck = false;
		List<WrapperBeanObject<RentalPayNormalSearchSP>> rentalPayNormalSearchSP = getSemmrt001PayBean().getRentalPayNormalSearchSPList();
		for (WrapperBeanObject<RentalPayNormalSearchSP> wrapperBeanObject : rentalPayNormalSearchSP) {
			if(wrapperBeanObject.isCheckBox()){
				return true;
			}
		}
		return isCheck;
	}
	public void getRowIdOnClick() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemmrt001PayBean().setTmpRowId(rowId);
	}
}
