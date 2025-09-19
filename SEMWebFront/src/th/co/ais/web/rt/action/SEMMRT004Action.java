package th.co.ais.web.rt.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;
//import org.hsqldb.lib.StringUtil;

import com.sun.xml.internal.messaging.saaj.util.LogDomainConstants;

import th.co.ais.domain.rt.CheckVendor;
import th.co.ais.domain.rt.Mrt003Cal;
import th.co.ais.domain.rt.Mrt003ChkVendorMulti;
import th.co.ais.domain.rt.MrtGetRunningNo;
import th.co.ais.domain.rt.RentalPayNormalEditSaveSP;
import th.co.ais.domain.rt.RentalPayNormalSaveActSP;
import th.co.ais.domain.rt.RentalPayNormalSaveSP;
import th.co.ais.domain.rt.RentalPayNormalSearchSP;
import th.co.ais.domain.rt.RentalPayNormalSearchDSP;
import th.co.ais.domain.rt.RentalPayment;
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
import th.co.ais.web.rt.bean.SEMMRT004Bean;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.LOVCacheUtil;
import th.co.ais.web.util.MSGCacheUtil;
import th.co.ais.web.util.RegionCacheUtil;
import th.co.ais.web.util.SelectItemLOVCacheUtil;
import th.co.ais.web.util.WebUtil;

public class SEMMRT004Action extends AbstractAction{
	
	private Logger log = Logger.getLogger(getClass());

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if(methodWithNavi.equalsIgnoreCase("doSearch")){
			flag = doSearch();
		}else if(methodWithNavi.equalsIgnoreCase("doDefaultDueDateFrom")){
			flag = doDefaultDueDateFrom();
		}else if(methodWithNavi.equalsIgnoreCase("doDefaultDueDateTo")){
			flag = doDefaultDueDateTo();
		}else if(methodWithNavi.equalsIgnoreCase("initEdit")){
			flag = initEdit();
		}else if(methodWithNavi.equalsIgnoreCase("doSavePay")){
			flag = doSavePay();
		}else if(methodWithNavi.equalsIgnoreCase("doSaveEdt")){
			flag = doSaveEdt();
		}else if (methodWithNavi.equalsIgnoreCase("doClearSession")) {
			flag = doClearSession();
		}else if (methodWithNavi.equalsIgnoreCase("doSaveAct")) {
			flag = doSaveAct();
		}else if (methodWithNavi.equalsIgnoreCase("initApprove")) {
			flag = initApprove();
		}else if (methodWithNavi.equalsIgnoreCase("initCoppyDate")) {
			flag = initCoppyDate();
		}else if (methodWithNavi.equalsIgnoreCase("doCoppyDate")) {
			flag = doCoppyDate();
		}else if (methodWithNavi.equalsIgnoreCase("doSaveApproveStatus")) {
			flag = doSaveApproveStatus();
		}else if (methodWithNavi.equalsIgnoreCase("doClearApproveStatus")) {
			flag = doClearApproveStatus();
		}else if (methodWithNavi.equalsIgnoreCase("onRenderMsgExoprt")) {
			flag = onRenderMsgExoprt();
		}else if (methodWithNavi.equalsIgnoreCase("onRenderMsgErrorExoprt")) {
			flag = onRenderMsgErrorExoprt();
		}
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		SEMMRT004Bean semmrt004Bean = new SEMMRT004Bean();
		semmrt004Bean.setRentalPayNormalSearchSP(new RentalPayNormalSearchSP());
		semmrt004Bean.setRentalPayNormalSearchDSP(new RentalPayNormalSearchDSP());
		semmrt004Bean.setRentalPayNormalSaveSP(new RentalPayNormalSaveSP());
		semmrt004Bean.setRentalPayNormalEditSaveSP(new RentalPayNormalEditSaveSP());
		semmrt004Bean.setRentalPayNormalSaveActSP(new RentalPayNormalSaveActSP());
		semmrt004Bean.setRentalPayment(new RentalPayment());
		semmrt004Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmrt004Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
		semmrt004Bean.setJobTypeList(getLovItemsByType(ELovType.T_RT_JOB_TYPE.name));
		semmrt004Bean.setPaymentStatusList(getLovItemsByType(ELovType.T_CT_PAYMENT_STATUS.name));
		semmrt004Bean.setPaymentTypeList(LOVCacheUtil.getInstance().getPaymentTypeSelList());
		semmrt004Bean.setSiteTypeList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_SI_SITE_TYPE.name, EX_AND, "RT", null, null));
		semmrt004Bean.setPaymentMethodList(LOVCacheUtil.getInstance().getPaymentMethodSelList());
		semmrt004Bean.setDayPerYearList(LOVCacheUtil.getInstance().getDayPerYearSelList());
		semmrt004Bean.setDayPermonthList(LOVCacheUtil.getInstance().getDayPerMonthSelList());
		semmrt004Bean.setVatTypeList(LOVCacheUtil.getInstance().getVatTypeSelList());
		semmrt004Bean.setValidateBtn(true);
		semmrt004Bean.setMrt003Cal(new Mrt003Cal());
		semmrt004Bean.setMrtGetRunningNo(new MrtGetRunningNo());
		semmrt004Bean.getRentalPayNormalSearchSP().setPaymentStatus("01");
		semmrt004Bean.getRentalPayNormalSearchDSP().setExpenseType("0");
		setSemmrt004Bean(semmrt004Bean);
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private SEMMRT004Bean semmrt004Bean;
	
	public void setSemmrt004Bean(SEMMRT004Bean semmrt004Bean) {
		this.semmrt004Bean = semmrt004Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmrt004Bean", semmrt004Bean);
	}

	public SEMMRT004Bean getSemmrt004Bean() {
		return (SEMMRT004Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmrt004Bean");
	}
	
	public boolean doSearch(){
		boolean flag = false;
		semmrt004Bean = getSemmrt004Bean();
		
		if(!validateSearch()){
			semmrt004Bean.setRenderedMsgFormMiddle(false);
			semmrt004Bean.setRenderedMsgFormBottom(false);
			return flag;
		}
		semmrt004Bean.setChkSelAll(false);
		IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
		semmrt004Bean.setRentalPayNormalSearchSPList(new ArrayList<WrapperBeanObject<RentalPayNormalSearchSP>>());
		List<RentalPayNormalSearchSP> to = null;
		
		// 20110118 Add check pico by ming
		if (semmrt004Bean.getRentalPayNormalSearchSP().isChkPico()) {
			semmrt004Bean.getRentalPayNormalSearchSP().setPicoFlag("Y");
		} else {
			semmrt004Bean.getRentalPayNormalSearchSP().setPicoFlag("N");
		}
		if(StringUtils.isEmpty(semmrt004Bean.getRentalPayNormalSearchSP().getJobType())){
			semmrt004Bean.getRentalPayNormalSearchSP().setJobType("00");
		}
		
			try {
				to = rentalPaymentService.querySPList(EQueryName.Q_SEARCH_RENTALPAY_NORMAL.name, semmrt004Bean.getRentalPayNormalSearchSP());
				if(to == null || to.size() == 0){
					semmrt004Bean.setRenderedMsgDataNotFound(true);
				 }else{
					 semmrt004Bean.setRenderedMsgDataNotFound(false);
					String tempId = "";
					for(int i=0; i<to.size(); i++){
						 
						 semmrt004Bean.setTmpChqDt(to.get(0).getChqDt());
						 semmrt004Bean.setTmpChqReceiveDt(to.get(0).getChqReceiveDt());
						 semmrt004Bean.setTmpTransferDt(to.get(0).getTransferDt());
						 
						 RentalPayNormalSearchSP rentalPayNormalSearchSP = (RentalPayNormalSearchSP)to.get(i);
						 WrapperBeanObject<RentalPayNormalSearchSP> tmpWrapperBean = new WrapperBeanObject<RentalPayNormalSearchSP>();
						 
						 //convert to thaiYear
						 if(rentalPayNormalSearchSP.getPaymentGroupNo() != null && tempId.equals(rentalPayNormalSearchSP.getPaymentGroupNo())){
							 rentalPayNormalSearchSP.setRenderColumn(false);
							}else{
								if(rentalPayNormalSearchSP.getPaymentGroupNo() != null){
									tempId = rentalPayNormalSearchSP.getPaymentGroupNo();
								}
								rentalPayNormalSearchSP.setRenderColumn(true);
							}
							if(rentalPayNormalSearchSP.getEffDt() != null){
//								rentalPayNormalSearchSP.setEffDt(SEMDataUtility.convertToThYear(rentalPayNormalSearchSP.getEffDt()));
								rentalPayNormalSearchSP.setEffDtStr(convertYearENtoTHStr(rentalPayNormalSearchSP.getEffDt()));
							}
							if(rentalPayNormalSearchSP.getExpDt() != null){
//								rentalPayNormalSearchSP.setExpDt(SEMDataUtility.convertToThYear(rentalPayNormalSearchSP.getExpDt()));
								rentalPayNormalSearchSP.setExpDtStr(convertYearENtoTHStr(rentalPayNormalSearchSP.getExpDt()));
							}
							if(rentalPayNormalSearchSP.getDueDt() != null){
//								rentalPayNormalSearchSP.setDueDt(SEMDataUtility.convertToThYear(rentalPayNormalSearchSP.getDueDt()));
								rentalPayNormalSearchSP.setDueDtStr(convertYearENtoTHStr(rentalPayNormalSearchSP.getDueDt()));
							}
							if(rentalPayNormalSearchSP.getPaymentRequestDt() != null){
//								rentalPayNormalSearchSP.setPaymentRequestDt(SEMDataUtility.convertToThYear(rentalPayNormalSearchSP.getPaymentRequestDt()));
								rentalPayNormalSearchSP.setPaymentRequestDtStr(convertYearENtoTHStr(rentalPayNormalSearchSP.getPaymentRequestDt()));
							}
							if(rentalPayNormalSearchSP.getChqDt() != null){
//								rentalPayNormalSearchSP.setChqDtDisplay(SEMDataUtility.convertToThYear(rentalPayNormalSearchSP.getChqDt()));
								rentalPayNormalSearchSP.setChqDtDisplayStr(convertYearENtoTHStr(rentalPayNormalSearchSP.getChqDt()));
							}
							if(rentalPayNormalSearchSP.getChqReceiveDt() != null){
//								rentalPayNormalSearchSP.setChqReceiveDtDisplay(SEMDataUtility.convertToThYear(rentalPayNormalSearchSP.getChqReceiveDt()));
								rentalPayNormalSearchSP.setChqReceiveDtDisplayStr(convertYearENtoTHStr(rentalPayNormalSearchSP.getChqReceiveDt()));
							}
							if(rentalPayNormalSearchSP.getTransferDt() != null){
//								rentalPayNormalSearchSP.setTransferDtDisplay(SEMDataUtility.convertToThYear(rentalPayNormalSearchSP.getTransferDt()));
								rentalPayNormalSearchSP.setTransferDtDisplayStr(convertYearENtoTHStr(rentalPayNormalSearchSP.getTransferDt()));
							}
						 
						 tmpWrapperBean.setDataObj(rentalPayNormalSearchSP);
						 tmpWrapperBean.setMessage("");
						 tmpWrapperBean.setCheckBox(false);
						 semmrt004Bean.getRentalPayNormalSearchSPList().add(tmpWrapperBean);
						}
				 }
				setSemmrt004Bean(semmrt004Bean);
				flag = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error(e);
				addMessageError(("E0004"));
			}
		return flag;
		}
	
		private boolean validateSearch() {
			boolean flagValid = true;
			validateRenderSearch();
			if(getSemmrt004Bean().isTmpGroup1() == true && StringUtils.isEmpty(getSemmrt004Bean().getRentalPayNormalSearchSP().getJobType())){
				addMessageError(("W0001"), msg("message.jobType"));
				flagValid = false;
			}
			if(getSemmrt004Bean().isTmpGroup1() == true && StringUtils.isEmpty(getSemmrt004Bean().getRentalPayNormalSearchSP().getCompany())){
				addMessageError(("W0001"), msg("message.company"));
				flagValid = false;
			}
//			if(!getSemmrt004Bean().getRentalPayNormalSearchSP().isChkPico()){
//				if(getSemmrt004Bean().isTmpGroup1() == true && StringUtils.isEmpty(getSemmrt004Bean().getRentalPayNormalSearchSP().getRegion())){
//					addMessageError(("W0001"), msg("message.region"));
//					flagValid = false;
//				}
//			}
			
			Date dueDtFrom = getSemmrt004Bean().getRentalPayNormalSearchSP().getDueDtFrom();
			Date dueDtTo = getSemmrt004Bean().getRentalPayNormalSearchSP().getDueDtTo();
			try{
				log.info("dueDtFrom"+dueDtFrom);
				log.info("dueDtTo"+dueDtTo);
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e);
			}
			if(dueDtFrom != null && dueDtTo != null){
				if(dueDtFrom.after(dueDtTo)){
					FrontMessageUtils.addMessageError("dueDtFrom Date must be before dueDtTo Date");
					flagValid = false;
				}
			}
			return flagValid;
		}
		
		public void validateRenderSearch(){
			semmrt004Bean = getSemmrt004Bean();
			semmrt004Bean.setTmpGroup1(true);
			semmrt004Bean.setTmpGroup2(true);
			if(!StringUtils.isEmpty(semmrt004Bean.getRentalPayNormalSearchSP().getCompany()) && !StringUtils.isEmpty(semmrt004Bean.getRentalPayNormalSearchSP().getRegion())){
				semmrt004Bean.setTmpGroup2(false);
			}
			if(!StringUtils.isEmpty(semmrt004Bean.getRentalPayNormalSearchSP().getContractNo())){
				semmrt004Bean.setTmpGroup1(false);
			}
			setSemmrt004Bean(semmrt004Bean);
		}
		
		private boolean doDefaultDueDateFrom(){
			boolean flag = false;
			semmrt004Bean = getSemmrt004Bean();
			Date dueDtFrom = getSemmrt004Bean().getRentalPayNormalSearchSP().getDueDtFrom();
			Date dueDtTo = getSemmrt004Bean().getRentalPayNormalSearchSP().getDueDtTo();
			if(dueDtFrom != null){
				if(dueDtTo == null){
					semmrt004Bean.getRentalPayNormalSearchSP().setDueDtTo(dueDtFrom);	
				}
			}else{
				semmrt004Bean.getRentalPayNormalSearchSP().setDueDtTo(null);
			}

			setSemmrt004Bean(semmrt004Bean);
			return flag; 
		}
		
		private boolean doDefaultDueDateTo(){
			boolean flag = false;
			semmrt004Bean = getSemmrt004Bean();
			Date dueDtFrom = getSemmrt004Bean().getRentalPayNormalSearchSP().getDueDtFrom();
			Date dueDtTo = getSemmrt004Bean().getRentalPayNormalSearchSP().getDueDtTo();
			if(dueDtTo != null){
				if(dueDtFrom == null){
					semmrt004Bean.getRentalPayNormalSearchSP().setDueDtFrom(dueDtTo);	
				}
			}else{
				semmrt004Bean.getRentalPayNormalSearchSP().setDueDtFrom(null);
			}

			setSemmrt004Bean(semmrt004Bean);
			return flag; 
		}
		
		private void showErrorMsgValidateCopy(String rentalPatNo){
			IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
			semmrt004Bean = getSemmrt004Bean();
			try {
				Mrt003ChkVendorMulti checkVendorMulti =  new Mrt003ChkVendorMulti();
				checkVendorMulti.setRentalPaymentId(rentalPatNo);
				List list = rentalPaymentService.querySPList(EQueryName.SP_CHK_VENDOR_MULTI.name, checkVendorMulti);
				if(list != null && list.size() > 0){
					if((Mrt003ChkVendorMulti)list.get(0) != null){
						String msg = ((Mrt003ChkVendorMulti)list.get(0)).getMsgWarning();
						semmrt004Bean.setRenderedMsgFormBottom(true);
						semmrt004Bean.setRenderedMsgFormMiddle(false);
						semmrt004Bean.setRenderedMsgFormTop(false);
						addGeneralMessageError(msg);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e);
			}
			setSemmrt004Bean(semmrt004Bean);
		}
		
		
		private boolean initEdit(){
			boolean flag = false;
			semmrt004Bean = getSemmrt004Bean();
			String rowId = (String)getFacesUtils().getRequestParameter("rowId");
			String paymentGroupNo = (String)getFacesUtils().getRequestParameter("paymentGroupNo");
			String statusEdit = (String)getFacesUtils().getRequestParameter("statusEdit");
			String vendorMasterId = (String)getFacesUtils().getRequestParameter("vendorMasterId");
			String payeeId = (String)getFacesUtils().getRequestParameter("payeeId");
			String expenseType = (String)getFacesUtils().getRequestParameter("expenseType");
			String contractNo = (String)getFacesUtils().getRequestParameter("contractNo");
			String pageStatus = (String)getFacesUtils().getRequestParameter("pageStatus");
			String periodNo = (String)getFacesUtils().getRequestParameter("periodNo");
			IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
			semmrt004Bean.setRowId(rowId);
			semmrt004Bean.setPaymentGroupno(paymentGroupNo);
			semmrt004Bean.getRentalPayNormalSearchDSP().setRowId(rowId);
			semmrt004Bean.getRentalPayNormalSearchDSP().setPaymentGroupNo(paymentGroupNo);
			if(semmrt004Bean.getCheckVendor() == null){
				semmrt004Bean.setCheckVendor(new CheckVendor());
			}
			semmrt004Bean.getCheckVendor().setVendorMasterId(vendorMasterId);
			semmrt004Bean.getCheckVendor().setPayeeMasterId(payeeId);
			semmrt004Bean.getCheckVendor().setExpenseType(expenseType);
			semmrt004Bean.getCheckVendor().setContractNo(contractNo);
			
			if(StringUtils.isNotEmpty(periodNo)){
				semmrt004Bean.setPeriodNo(periodNo);
			}else{
				semmrt004Bean.setPeriodNo("1");
			}
			List<RentalPayNormalSearchDSP> to = null;
			List<CheckVendor> to2 = null;
				try {
					to = rentalPaymentService.querySPList(EQueryName.Q_SEARCH_RENTALPAY_NORMAL_D.name, semmrt004Bean.getRentalPayNormalSearchDSP());
					to2 = rentalPaymentService.querySPList(EQueryName.SP_CHECK_VENDOR.name, semmrt004Bean.getCheckVendor());
					if(to != null || to.size() != 0){
						if(to.get(0).getDepositFlag().equals("Y")){
							semmrt004Bean.setChkDeposit(true);
						}else{
							semmrt004Bean.setChkDeposit(false);
						}
						//Less money
						to.get(0).setPaymentAmt((to.get(0).getTotalAmt()!=null?to.get(0).getTotalAmt():0.0 )- (to.get(0).getDepositAmt()!=null?to.get(0).getDepositAmt():0.00));
						
						//get excAmt vatAmt whtAmt add bean Because validate + - 1
						semmrt004Bean.setOldExcAmt(to.get(0).getExcAmt());
						semmrt004Bean.setOldVatAmt(to.get(0).getVatAmt());
						semmrt004Bean.setOldWhtAmt(to.get(0).getWhtAmt());
						semmrt004Bean.setOldIncAmt(to.get(0).getIncAmt());
						semmrt004Bean.setOldTotalAmt(to.get(0).getTotalAmt());
						
						//get Deposit for enable chkDeposit
						semmrt004Bean.setTmpDepositAmt(to.get(0).getDepositAmt());
						semmrt004Bean.setTmpPaymentAmt(to.get(0).getPaymentAmt());
						semmrt004Bean.setRentalPayNormalSearchDSP(to.get(0));
						
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
					if(pageStatus.equals("SavePay")){
						for(int i=0; i<to2.size(); i++){
							CheckVendor chv = (CheckVendor)to2.get(i);
							if(chv != null){	
								if(i==0){
									addGeneralMessageError(chv.getMsgWarning());
									semmrt004Bean.setMsgHeaderPopup1(chv.getMsgWarning());
								}
								if(i==1){
									addGeneralMessageError(chv.getMsgWarning());
									semmrt004Bean.setMsgHeaderPopup2(chv.getMsgWarning());
								}
							}
						}
					}
//					semmrt004Bean.setCheckVendor(to2.get(0));
					flag = true;
				} catch (Exception e) {
					e.printStackTrace();
					log.error(e);
					addMessageError(("E0004"));
				}
			setSemmrt004Bean(semmrt004Bean);
			return flag;
		}
		
		private boolean doSavePay(){
			boolean flag = false;
			semmrt004Bean = getSemmrt004Bean();
			if(!validateSave()){
				semmrt004Bean.setPopupClose(new Boolean(false));
				semmrt004Bean.setRenderedMsgFormTop(false);
				semmrt004Bean.setRenderedMsgFormBottom(false);
				semmrt004Bean.setRenderedMsgFormMiddle(false);
				return flag;
			}
			semmrt004Bean.getRentalPayNormalSaveSP().setPaymentGroupNo(semmrt004Bean.getPaymentGroupno());
			semmrt004Bean.getRentalPayNormalSaveSP().setDepositAmt(semmrt004Bean.getRentalPayNormalSearchDSP().getDepositAmt());
			semmrt004Bean.getRentalPayNormalSaveSP().setPaymentType(semmrt004Bean.getRentalPayNormalSearchDSP().getPaymentType());
			semmrt004Bean.getRentalPayNormalSaveSP().setPaymentMethod(semmrt004Bean.getRentalPayNormalSearchDSP().getPaymentMethod());
			semmrt004Bean.getRentalPayNormalSaveSP().setChqDt(semmrt004Bean.getRentalPayNormalSearchDSP().getChqDt());
			semmrt004Bean.getRentalPayNormalSaveSP().setChqReceiveDt(semmrt004Bean.getRentalPayNormalSearchDSP().getChqReceiveDt());
			semmrt004Bean.getRentalPayNormalSaveSP().setTransferDt(semmrt004Bean.getRentalPayNormalSearchDSP().getTransferDt());
			semmrt004Bean.getRentalPayNormalSaveSP().setRemark(semmrt004Bean.getRentalPayNormalSearchDSP().getRemark());
			semmrt004Bean.getRentalPayNormalSaveSP().setUserId(getUserLogIn());
			IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
			List<RentalPayNormalSaveSP> to = null;
			
			try {
				to = rentalPaymentService.querySPList(EQueryName.SP_MRT003_PAY.name, semmrt004Bean.getRentalPayNormalSaveSP());
				if ((to != null || !to.isEmpty() )&& to.get(0).getResultMsg().equals("Success")) {
//					semmrt004Bean.setRentalPayNormalSaveSP(to.get(0));
					addMessageInfo("M0001");
					semmrt004Bean.setPopupClose(new Boolean(true));
				}else if(to != null && !to.isEmpty()){
					FrontMessageUtils.addMessageError(to.get(0).getpRemark());
				}		
				
				setSemmrt004Bean(semmrt004Bean);
				doSearch();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error(e);
				addMessageError("E0001");
				semmrt004Bean.setValidatePopup("");
			}
			return flag;
		}
		
		public boolean doSaveEdt(){
			boolean flag = false;
			semmrt004Bean = getSemmrt004Bean();
			IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
			List<RentalPayNormalEditSaveSP> to = null;
			
			semmrt004Bean.getRentalPayNormalEditSaveSP().setRentalPaymentId(semmrt004Bean.getRowId());
			semmrt004Bean.getRentalPayNormalEditSaveSP().setCalYear(semmrt004Bean.getRentalPayNormalSearchDSP().getCalYear());
			semmrt004Bean.getRentalPayNormalEditSaveSP().setCalMonth(semmrt004Bean.getRentalPayNormalSearchDSP().getCalMonth());
			semmrt004Bean.getRentalPayNormalEditSaveSP().setVatType(semmrt004Bean.getRentalPayNormalSearchDSP().getVatType());
			semmrt004Bean.getRentalPayNormalEditSaveSP().setExcAmt(semmrt004Bean.getRentalPayNormalSearchDSP().getExcAmt());
			semmrt004Bean.getRentalPayNormalEditSaveSP().setVatRate(semmrt004Bean.getRentalPayNormalSearchDSP().getVatRate());
			semmrt004Bean.getRentalPayNormalEditSaveSP().setVatAmt(semmrt004Bean.getRentalPayNormalSearchDSP().getVatAmt());
			semmrt004Bean.getRentalPayNormalEditSaveSP().setIncAmt(semmrt004Bean.getRentalPayNormalSearchDSP().getIncAmt());
			semmrt004Bean.getRentalPayNormalEditSaveSP().setWhtRate(semmrt004Bean.getRentalPayNormalSearchDSP().getWhtRate());
			semmrt004Bean.getRentalPayNormalEditSaveSP().setWhtAmt(semmrt004Bean.getRentalPayNormalSearchDSP().getWhtAmt());
			semmrt004Bean.getRentalPayNormalEditSaveSP().setUserId(semmrt004Bean.getUserLogin());
			try {
				to = rentalPaymentService.querySPList(EQueryName.SP_MRT003_EDT.name, semmrt004Bean.getRentalPayNormalEditSaveSP());
				if (to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")) {
//					semmrt004Bean.setRentalPayNormalSaveSP(to.get(0));
					addMessageInfo("M0001");
					semmrt004Bean.setPopupClose(new Boolean(true));
				}else if(to != null && !to.isEmpty()){
					FrontMessageUtils.addMessageError(to.get(0).getpRemark());
				}		
				
				setSemmrt004Bean(semmrt004Bean);
				doSearch();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error(e);
				addMessageError("E0001");
				semmrt004Bean.setValidatePopup("");
			}
			return flag;
		}
		
		private boolean validateSave() {
			boolean flgValid = true;
			Date chqDt = getSemmrt004Bean().getRentalPayNormalSearchDSP().getChqDt();
			Date chqReceiveDt = getSemmrt004Bean().getRentalPayNormalSearchDSP().getChqReceiveDt();
			Date transferDt = getSemmrt004Bean().getRentalPayNormalSearchDSP().getTransferDt();
			if(StringUtils.isEmpty(getSemmrt004Bean().getRentalPayNormalSearchDSP().getPaymentType())){
				addMessageError(("W0001"), msg("message.paymentType"));
				flgValid = false;
			}
			
			if("02".equals(getSemmrt004Bean().getRentalPayNormalSearchDSP().getPaymentType())){
				if(StringUtils.isEmpty(getSemmrt004Bean().getRentalPayNormalSearchDSP().getBankAccNo())){
					addMessageError(("W0059"), msg("label.bankAccNo"));
					flgValid = false;
				}
			}
			
			if(StringUtils.isEmpty(getSemmrt004Bean().getRentalPayNormalSearchDSP().getPaymentMethod()) &&
				getSemmrt004Bean().isRenderedPaymentMethod() == false){
				addMessageError(("W0001"), msg("message.paymentMethod"));
				flgValid = false;
			}
			
			try{
				if(getSemmrt004Bean().getRentalPayNormalSearchDSP().getChqDt() == null){
					if(getSemmrt004Bean().isRenderedChqDt() == false){
						//addMessageError(("W0001"), msg("message.chqDt"));
						flgValid = true;
					   }
					}else{
						if(SEMDataUtility.getCurrentDateByPattern().compareTo(chqDt)>0){
							addGeneralMessageError("ChqDt Before Today Date");
							flgValid = false;
						}
					}
					if(getSemmrt004Bean().getRentalPayNormalSearchDSP().getChqReceiveDt() == null){
					   if(getSemmrt004Bean().isRenderedChqDt() == false){
						///addMessageError(("W0001"), msg("message.chqReceiveDt"));
						flgValid = true;
					   }
					}else{
						if(SEMDataUtility.getCurrentDateByPattern().compareTo(chqReceiveDt)>0){
							addGeneralMessageError("ChqReceiveDt Before Today Date");
							flgValid = false;
						}
					}
					if(getSemmrt004Bean().getRentalPayNormalSearchDSP().getTransferDt() == null){
						if(getSemmrt004Bean().isRenderedTransferDt() == false){
						    //addMessageError(("W0001"), msg("message.transferDt"));
					    	flgValid = true;
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
		
		private boolean validateSaveAct() {
			boolean flgValid = true;
			semmrt004Bean = getSemmrt004Bean();
			int i = 0;
			String vendorCode = "";
			String payeeId = "";
			for (WrapperBeanObject<RentalPayNormalSearchSP> temp : semmrt004Bean.getRentalPayNormalSearchSPList()) {
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
		
		private boolean validateApprove(){
			boolean flgValid = true;
			semmrt004Bean = getSemmrt004Bean();
			if(StringUtils.isEmpty(getSemmrt004Bean().getRemark())){
				FrontMessageUtils.addMessageError(
						SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), msg("message.remark")));
				flgValid = false;
			}
			return flgValid;
		}
		
		public boolean doClearSession(){
			boolean flag = false;
			semmrt004Bean = getSemmrt004Bean();
			semmrt004Bean.setRentalPayNormalSearchSP(new RentalPayNormalSearchSP());
			semmrt004Bean.setRentalPayNormalSearchSPList(new ArrayList());
			semmrt004Bean.setRentalPayment(new RentalPayment());
			semmrt004Bean.setDisabledBtnExport(true);
			semmrt004Bean.setRenderedMsgDataNotFound(false);
			setSemmrt004Bean(semmrt004Bean);
			return flag;
		}
		
		public boolean doSaveAct(){
			boolean flag = false;
			String rowsIdConcat = "";
			String tempPaymentGroup = "";
			String btnStatus = "";
			semmrt004Bean = getSemmrt004Bean();
			IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
			
			if(semmrt004Bean.getBtnApproveStatus() != null && !StringUtils.isEmpty(semmrt004Bean.getBtnApproveStatus())){
				btnStatus = semmrt004Bean.getBtnApproveStatus();
				if(semmrt004Bean.getBtnApproveStatus().equals("CA") && !validateApprove()){
					semmrt004Bean.setPopupClose(false);
					semmrt004Bean.setRenderedMsgFormTop(false);
					semmrt004Bean.setRenderedMsgFormMiddle(true);
					setSemmrt004Bean(semmrt004Bean);
					return flag;
				}
				semmrt004Bean.setPopupClose(true);
				semmrt004Bean.getRentalPayNormalSaveActSP().setRemark(semmrt004Bean.getRemark());
			}else{
				btnStatus = (String)getFacesUtils().getRequestParameter("btnStatus");
				if(!StringUtils.isEmpty(semmrt004Bean.getBtnStatus())){
					btnStatus = semmrt004Bean.getBtnStatus();
				}
				semmrt004Bean.getRentalPayNormalSaveActSP().setRemark(null);
			}
		
			List<RentalPayNormalSaveActSP> to = null;
			
			// loop for Concat RowId
			for (WrapperBeanObject<RentalPayNormalSearchSP> temp : semmrt004Bean.getRentalPayNormalSearchSPList()) {
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
			}
			if(btnStatus.equals("AG")){
				if(!validateSaveAct()){
					addMessageError("incContent:frmSearchResult:pnlSearchResult", "W0015", "Vendor");
					semmrt004Bean.setRenderedMsgFormSearch(false);
					semmrt004Bean.setRenderedMsgFormTop(false);
					semmrt004Bean.setRenderedMsgFormMiddle(true);
					setSemmrt004Bean(semmrt004Bean);
					return flag;
				}
			}
			log.info("rowsIdConcat = " + rowsIdConcat);
			String[] args = prepareArgToUpdate(rowsIdConcat);
			if(args != null){
				
				String remark = "";
				boolean isNotError = true;
				boolean isSuccess = true;
				
				for (int i = 0; i < args.length; i++) {
					semmrt004Bean.getRentalPayNormalSaveActSP().setRowId(args[i]);
					semmrt004Bean.getRentalPayNormalSaveActSP().setActionType(btnStatus);
					semmrt004Bean.getRentalPayNormalSaveActSP().setUserId(getUserLogIn());
					log.info("rowIds = " + args[i]);
					try {
						to = rentalPaymentService.querySPList(EQueryName.SP_MRT003_ACT.name, semmrt004Bean.getRentalPayNormalSaveActSP());
						if ((to != null && !to.isEmpty() )&& to.get(0).getResultMsg().equals("Success")) {
							isNotError = true;
							isSuccess = true;
							//addMessageInfo("M0001");
						}else if(to != null && !to.isEmpty()){
							isNotError = true;
							isSuccess = false;
							remark = to.get(0).getpRemark();
							//FrontMessageUtils.addMessageError(to.get(0).getpRemark());
						}
						setSemmrt004Bean(semmrt004Bean);
						doSearch();
						doClearApproveStatus();
					} catch (Exception e) {
						e.printStackTrace();
						log.error(e);
						isNotError = false;
						//addMessageError("E0001");
					}
				}//end for loop.
				
				if(isNotError){
					if(isSuccess)
					addMessageInfo("M0001");
					else
					addGeneralMessageError(remark);
				}else{
					addMessageError("E0001");
				}
				
			}
			
			
			semmrt004Bean.setRenderedMsgFormTop(false);
			semmrt004Bean.setRenderedMsgFormMiddle(false);
			semmrt004Bean.setRenderedMsgFormBottom(true);
			return flag;
		}
		
		public String[] prepareArgToUpdate(String ids){
			
			if(StringUtils.isNotBlank(ids)){
				String[] arrArgs = new String[10];
				String[] aIds = ids.split(",");
				int length = aIds.length;
				
				String arg1 = "";
				String arg2 = "";
				String arg3 = "";
				String arg4 = "";
				String arg5 = "";
				String arg6 = "";
				String arg7 = "";
				String arg8 = "";
				String arg9 = "";
				String arg10 = "";
				
				if(length <= 99){
					arrArgs = new String[1];
					arrArgs[0] = ids;
					return arrArgs;
				}
				for(int i=0; i<aIds.length; i++){
					
					/*if(i <= 99){
						arg1 = arg1.concat(aIds[i]);
						if(i != length-1){
							if(i != 99)
							arg1 = arg1.concat(",");
						}
					}*/ 
					if(i > 99 && i <= 199){
						arg2 = arg2.concat(aIds[i]);
						if(i != length-1){
							if(i != 199)
							arg2 = arg2.concat(",");
						}
					}else if(i > 199 && i <= 299){
						arg3 = arg3.concat(aIds[i]);
						if(i != length-1){
							if(i != 299)
							arg3 = arg3.concat(",");
						}
					}else if(i > 299 && i <= 399){
						arg4 = arg4.concat(aIds[i]);
						if(i != length-1)
							if(i != 399)
							arg4 = arg4.concat(",");
					}else if(i > 399 && i <= 499){
						arg5 = arg5.concat(aIds[i]);
						if(i != length-1)
							if(i != 499)
							arg5 = arg5.concat(",");
					}else if(i > 499 && i <= 599){
						arg6 = arg6.concat(aIds[i]);
						if(i != length-1)
							if(i != 599)
							arg6 = arg6.concat(",");
					}else if(i > 599 && i <= 699){
						arg7 = arg7.concat(aIds[i]);
						if(i != length-1)
							if(i != 699)
							arg7 = arg7.concat(",");
					}else if(i > 699 && i <= 799){
						arg8 = arg8.concat(aIds[i]);
						if(i != length-1)
							if(i != 799)
							arg8 = arg8.concat(",");
					}else if(i > 799 && i <= 899){
						arg9 = arg9.concat(aIds[i]);
						if(i != length-1)
							if(i != 899)
							arg9 = arg9.concat(",");
					}else if(i > 899 && i <= 999){
						arg10 = arg10.concat(aIds[i]);
						if(i != length-1)
							if(i != 999)
							arg10 = arg10.concat(",");
					}
				}
				
				arrArgs[0] = arg1;
				arrArgs[1] = arg2;
				arrArgs[2] = arg3;
				arrArgs[3] = arg4;
				arrArgs[4] = arg5;
				arrArgs[5] = arg6;
				arrArgs[6] = arg7;
				arrArgs[7] = arg8;
				arrArgs[8] = arg9;
				arrArgs[9] = arg10;
				return arrArgs;
			}
			return null;
		}
		
		public boolean initApprove(){
			boolean flag = false;
			semmrt004Bean = getSemmrt004Bean();
			String btnApproveStatus = (String)getFacesUtils().getRequestParameter("btnApproveStatus");
			semmrt004Bean.setBtnApproveStatus(btnApproveStatus);
			setSemmrt004Bean(semmrt004Bean);
			return flag;
		}
		
		public boolean initCoppyDate(){
			boolean flag = false;
			semmrt004Bean = getSemmrt004Bean();
			RentalPayNormalSearchSP rtTmp = null;
			int i = 0;
			boolean second = false;
			for (WrapperBeanObject<RentalPayNormalSearchSP> temp : semmrt004Bean.getRentalPayNormalSearchSPList()) {
				RentalPayNormalSearchSP rt = (RentalPayNormalSearchSP)temp.getDataObj();

				if(!second){
					if(rt.getChqDt() == null && rt.getChqReceiveDt() == null && rt.getTransferDt() == null){
						addMessageError("W0086");
						break;
					}
					second = true;
				}
			
				if(rtTmp == null && rt != null){
					rtTmp = rt;
				}
				if(i != 0){
					if(rtTmp.getPaymentType().equals(rt.getPaymentType())){
						if(rt.getChqDt() != null || rt.getChqReceiveDt() != null || rt.getTransferDt() != null){
							semmrt004Bean.setPopupClose(true);
							semmrt004Bean.setPopupName("mdpConfirmCoppyDateDialog2");
							semmrt004Bean.setConfirmCoppyDateMsg(MSGCacheUtil.getInstance().getMessageByCode("Q0004"));
							break;
						}else{
							semmrt004Bean.setPopupClose(true);
							semmrt004Bean.setPopupName("mdpConfirmCoppyDateDialog1");
							semmrt004Bean.setConfirmCoppyDateMsg(MSGCacheUtil.getInstance().getMessageByCode("Q0004"));
						}
					}else{
						semmrt004Bean.setPopupClose(false);
						addMessageError("W0033");
						break;
					}
				}
				i++;
			}			
			setSemmrt004Bean(semmrt004Bean);
			return flag;
		}
		
		public boolean doCoppyDate(){
			boolean flag = false;
			semmrt004Bean = getSemmrt004Bean();
			String confirmStatus = (String)getFacesUtils().getRequestParameter("confirmStatus");
			IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
			RentalPayment tmpRentalPayment = new RentalPayment();
			StringBuffer rentalpayNo = new StringBuffer();
			try{
				for (WrapperBeanObject<RentalPayNormalSearchSP> temp : semmrt004Bean.getRentalPayNormalSearchSPList()) {
					RentalPayNormalSearchSP rt = (RentalPayNormalSearchSP)temp.getDataObj();
					RentalPayNormalSearchSP tmp = (RentalPayNormalSearchSP)semmrt004Bean.getRentalPayNormalSearchSPList().get(0).getDataObj();
					if(confirmStatus.equals("Y")){
						tmpRentalPayment = rentalPaymentService.getRentalPaymentByRowId(rt.getRowId());
						
						if(tmp.getChqDt() != null){
							tmpRentalPayment.setChqDt(tmp.getChqDt());
						}
						
						if(tmp.getChqReceiveDt() != null){
							tmpRentalPayment.setChqReceiveDt(tmp.getChqReceiveDt());
						}
						
						if(tmp.getTransferDt() != null){
							tmpRentalPayment.setTransferDt(tmp.getTransferDt());
						}
						if("01".equals(tmpRentalPayment.getPaymentStatus()) || "04".equals(tmpRentalPayment.getPaymentStatus())){
							rentalPaymentService.updateRentalPayment(tmpRentalPayment);
						}
						
						rentalpayNo.append(rt.getRowId());
						rentalpayNo.append(",");
					}
					// field chqDt chqReceiveDt TransferDt all null
					if(confirmStatus.equals("N") && rt.getChqDt() == null 
					   && rt.getChqReceiveDt() == null 
					   && rt.getTransferDt() == null){
						
						tmpRentalPayment = rentalPaymentService.getRentalPaymentByRowId(rt.getRowId());
						
						if(tmp.getChqDt() != null){
							tmpRentalPayment.setChqDt(tmp.getChqDt());
						}
						
						if(tmp.getChqReceiveDt() != null){
							tmpRentalPayment.setChqReceiveDt(tmp.getChqReceiveDt());
						}
						
						if(tmp.getTransferDt() != null){
							tmpRentalPayment.setTransferDt(tmp.getTransferDt());
						}
						if("01".equals(tmpRentalPayment.getPaymentStatus()) || "04".equals(tmpRentalPayment.getPaymentStatus())){
							rentalPaymentService.updateRentalPayment(tmpRentalPayment);
						}
						rentalpayNo.append(rt.getRowId());
						rentalpayNo.append(",");
					}
				}
				setSemmrt004Bean(semmrt004Bean);
				doSearch();
			}catch (Exception e) {
				e.printStackTrace();
				log.error(e);
				addMessageError("E0001");
			}			
			if(rentalpayNo.length() != 0){
				showErrorMsgValidateCopy(rentalpayNo.substring(0,rentalpayNo.length()-1).toString());
			}
			return flag;
		}
		
		public boolean doSaveApproveStatus(){
			boolean flag = false;
			semmrt004Bean = getSemmrt004Bean();
			String tempPaymentGroup = "";
			IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
			try{
				for (WrapperBeanObject<RentalPayNormalSearchSP> temp : semmrt004Bean.getRentalPayNormalSearchSPList()) {
				RentalPayNormalSearchSP rt = (RentalPayNormalSearchSP)temp.getDataObj();
					if(temp.isCheckBox() == true){
						tempPaymentGroup = rt.getPaymentGroupNo();
					}
					if(rt.getPaymentGroupNo() != null && rt.getPaymentGroupNo().equals(tempPaymentGroup)){
						temp.setCheckBox(true);
					}
					if(temp.isCheckBox() == true){
						semmrt004Bean.setRentalPayment(rentalPaymentService.getRentalPaymentByRowId(rt.getRowId()));
						semmrt004Bean.getRentalPayment().setExpiredFlag("A");
						semmrt004Bean.getRentalPayment().setPendingFlag("A");
						rentalPaymentService.updateRentalPayment(semmrt004Bean.getRentalPayment());
					}
				}
				setSemmrt004Bean(semmrt004Bean);
			}catch (Exception e) {
				e.printStackTrace();
				log.error(e);
				addMessageError("E0001");
			}
			
			return flag;
		}
		
		public void onRenderPaymentMethod(){
			semmrt004Bean = getSemmrt004Bean();
			semmrt004Bean.setRenderedChqDt(true);
			semmrt004Bean.setRenderedTransferDt(true);
			semmrt004Bean.setRenderedPaymentMethod(false);
			if(semmrt004Bean.getRentalPayNormalSearchDSP().getPaymentType() != null
				&& semmrt004Bean.getRentalPayNormalSearchDSP().getPaymentType().equals("01")){
				List<SelectItem> paymentMethodList = getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name,EX_AND,"CHEQUE",null,null);
//				semmrt004Bean.getRentalPayNormalSearchDSP().setPaymentMethod("03");
				//addded by NEW 20150828 check null befor set default paymentMethod
				if(semmrt004Bean.getRentalPayNormalSearchDSP().getPaymentMethod() == null || 
						semmrt004Bean.getRentalPayNormalSearchDSP().getPaymentMethod().equals(""))
					semmrt004Bean.getRentalPayNormalSearchDSP().setPaymentMethod("03");
				//end added
				semmrt004Bean.setPaymentMethodList(paymentMethodList);
				semmrt004Bean.setRenderedChqDt(false);
				//Clear Text field
				semmrt004Bean.getRentalPayNormalSearchDSP().setTransferDt(null);
			}
			if(semmrt004Bean.getRentalPayNormalSearchDSP().getPaymentType() != null
				&& semmrt004Bean.getRentalPayNormalSearchDSP().getPaymentType().equals("02")){
				// prepare paymentMethodList
				List<SelectItem> paymentMethodList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
				List<SelectItem> selectList = new ArrayList<SelectItem>();
				for(SelectItem selectItem : paymentMethodList){
					if (StringUtils.equalsIgnoreCase("U", selectItem.getDescription())){
						selectList.add(selectItem);
					}
				}
				semmrt004Bean.setPaymentMethodList(selectList);
				semmrt004Bean.setRenderedTransferDt(false);
				//Clear Text field
				semmrt004Bean.getRentalPayNormalSearchDSP().setChqDt(null);
				semmrt004Bean.getRentalPayNormalSearchDSP().setChqReceiveDt(null);
			}
			if(semmrt004Bean.getRentalPayNormalSearchDSP().getPaymentType() != null
				&& semmrt004Bean.getRentalPayNormalSearchDSP().getPaymentType().equals("03")){
				semmrt004Bean.setRenderedPaymentMethod(false);
				//Clear Text field
				// prepare paymentMethodList
				List<SelectItem> paymentMethodList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
				List<SelectItem> selectList = new ArrayList<SelectItem>();
//				
				for(SelectItem selectItem : paymentMethodList){
					
					if (StringUtils.equalsIgnoreCase("P", selectItem.getDescription())){
						selectList.add(selectItem);
					}
				
				}
				semmrt004Bean.setPaymentMethodList(selectList);
				semmrt004Bean.getRentalPayNormalSearchDSP().setTransferDt(null);
				semmrt004Bean.getRentalPayNormalSearchDSP().setChqDt(null);
				semmrt004Bean.getRentalPayNormalSearchDSP().setChqReceiveDt(null);
			}
			//semmrt004Bean.getRentalPayNormalSearchDSP().setPaymentMethod("05");
			setSemmrt004Bean(semmrt004Bean);
		}
		
		public void onRenderDepositAmt(){
			semmrt004Bean = getSemmrt004Bean();
			if(semmrt004Bean.isChkDeposit()==true){
				semmrt004Bean.setRenderedDepositAmt(false);
				semmrt004Bean.getRentalPayNormalSearchDSP().setDepositAmt(semmrt004Bean.getTmpDepositAmt());
			}else{
				semmrt004Bean.setRenderedDepositAmt(true);
				semmrt004Bean.getRentalPayNormalSearchDSP().setDepositAmt(null);
				semmrt004Bean.getRentalPayNormalSearchDSP().setPaymentAmt(semmrt004Bean.getTmpPaymentAmt());
			}
			setSemmrt004Bean(semmrt004Bean);
		}
		
		public void onRenderDayPerYearAndMonth(){
			semmrt004Bean = getSemmrt004Bean();
			semmrt004Bean.setRenderedMonth(true);
			semmrt004Bean.setRenderedYear(true);
			
			if(semmrt004Bean.getRentalPayNormalSearchDSP().getPeriodType() == null){
				   semmrt004Bean.setRenderedMonth(false);
				   semmrt004Bean.setRenderedYear(false);
			}
//			if(semmrt004Bean.getRentalPayNormalSearchDSP().getPeriodType() != null
//				&& semmrt004Bean.getRentalPayNormalSearchDSP().getPeriodType().equals("01") 
//				|| semmrt004Bean.getRentalPayNormalSearchDSP().getPeriodType().equals("03")){
//				if(semmrt004Bean.getRentalPayNormalSearchDSP().getPeriodD() != null && 
//				   semmrt004Bean.getRentalPayNormalSearchDSP().getPeriodD()>0){
//					semmrt004Bean.setRenderedMonth(false);
//				}
//			}
//			if(semmrt004Bean.getRentalPayNormalSearchDSP().getPeriodType() != null
//				&& semmrt004Bean.getRentalPayNormalSearchDSP().getPeriodType().equals("02") 
//				|| semmrt004Bean.getRentalPayNormalSearchDSP().getPeriodType().equals("04")){
//				if(semmrt004Bean.getRentalPayNormalSearchDSP().getPeriodD() != null && semmrt004Bean.getRentalPayNormalSearchDSP().getPeriodD()>0){
//					semmrt004Bean.setRenderedYear(false);
//				}
//			}
			setSemmrt004Bean(semmrt004Bean);
		}
		
		public void onRenderVatRate(){
			semmrt004Bean = getSemmrt004Bean();
			semmrt004Bean.setRenderedvatRate(false);
			semmrt004Bean.setRenderedWhtRate(false);
			if(semmrt004Bean.getRentalPayNormalSearchDSP().getVatRate() == null ||
				semmrt004Bean.getRentalPayNormalSearchDSP().getVatRate() == 0){
				semmrt004Bean.setRenderedvatRate(true);
			}
			if(semmrt004Bean.getRentalPayNormalSearchDSP().getWhtRate() == null ||
				semmrt004Bean.getRentalPayNormalSearchDSP().getWhtRate() == 0){
				semmrt004Bean.setRenderedWhtRate(true);
			}
			setSemmrt004Bean(semmrt004Bean);
		}
		
		// Include Total
		public void onRenderIncludeAmt(){
			semmrt004Bean = getSemmrt004Bean();
			if(!validateTotalAmount()){
				addMessageError("W0031");
			}else{
				semmrt004Bean.getRentalPayNormalSearchDSP().setIncAmt(
						(semmrt004Bean.getRentalPayNormalSearchDSP().getExcAmt()!=null?semmrt004Bean.getRentalPayNormalSearchDSP().getExcAmt():0.00 )
					  + (semmrt004Bean.getRentalPayNormalSearchDSP().getVatAmt()!=null?semmrt004Bean.getRentalPayNormalSearchDSP().getVatAmt():0.00));
			}
			setSemmrt004Bean(semmrt004Bean);
		}
		
		// Total Amount
		public void onRenderTotalAmt(){
			semmrt004Bean = getSemmrt004Bean();
			if(!validateTotalAmount()){
				addMessageError("W0031");
			}else{
				semmrt004Bean.getRentalPayNormalSearchDSP().setTotalAmt(
						(semmrt004Bean.getRentalPayNormalSearchDSP().getIncAmt()!=null?semmrt004Bean.getRentalPayNormalSearchDSP().getIncAmt():0.00 )
					  - (semmrt004Bean.getRentalPayNormalSearchDSP().getWhtAmt()!=null?semmrt004Bean.getRentalPayNormalSearchDSP().getWhtAmt():0.00));
			}
			setSemmrt004Bean(semmrt004Bean);
		}
		
		public void selectAllRow(){
			try{
				boolean chkAll = getSemmrt004Bean().isChkSelAll();
				List<WrapperBeanObject<RentalPayNormalSearchSP>> detailList = new ArrayList<WrapperBeanObject<RentalPayNormalSearchSP>>();
				detailList = getSemmrt004Bean().getRentalPayNormalSearchSPList();
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
		
		public boolean onRenderMsgExoprt(){
			boolean flag = false;
			addMessageError("W0042");
			return flag;
		}
		
		public void onRenderExportButton(){
			String rowId = (String)getFacesUtils().getRequestParameter("rowId");
			log.info("tmpRowId :" + rowId);
			getSemmrt004Bean().setTmpRowId(rowId);
			
			if(!validateExport()){
				getSemmrt004Bean().setRenderedBtnA4JExport(true);
				getSemmrt004Bean().setRenderedBtnHExport(false);
			}else{
				getSemmrt004Bean().setRenderedBtnA4JExport(false);
				getSemmrt004Bean().setRenderedBtnHExport(true);
			}
			if(isOneValue()){
//				getSemmrt004Bean().setRenderedBtnHExport(true);
				//Surdej add 17/10/2012
				if(getSemmrt004Bean().isRenderedBtnA4JExport())
					getSemmrt004Bean().setRenderedBtnHExport(false);
				else
					getSemmrt004Bean().setRenderedBtnHExport(true);
				getSemmrt004Bean().setRenderedBtnExportShowError(false);
			}else{
				getSemmrt004Bean().setRenderedBtnHExport(false);
				getSemmrt004Bean().setRenderedBtnExportShowError(true);
			}
			if(isCheckSELBox()){
				getSemmrt004Bean().setDisabledBtnExport(false);
			}else{
				getSemmrt004Bean().setDisabledBtnExport(true);
				
			}
		}
		
		private boolean isOneValue(){
			boolean isTrue = true;
			int totalPBatchNo = 0;
			String paymentBatchNo = "";
			String tmpPaymentBatchNo = "";
			for (WrapperBeanObject<RentalPayNormalSearchSP> temp : semmrt004Bean.getRentalPayNormalSearchSPList()) {
				RentalPayNormalSearchSP rt = (RentalPayNormalSearchSP)temp.getDataObj();
				if(temp.isCheckBox()){
					//Adding by mr.John from (mr.Choosak) 28/04/2011
					paymentBatchNo = rt.getPaymentBatchNo();
					if(StringUtils.isNotBlank(paymentBatchNo)){
						if(!StringUtils.equals(tmpPaymentBatchNo, paymentBatchNo))
						totalPBatchNo++;
					}
					
					if(totalPBatchNo > 1)
					return isTrue = false;
					
				}
				tmpPaymentBatchNo = paymentBatchNo;
			}
				
			return isTrue;
		}
		
		private boolean isCheckSELBox(){
			boolean isCheck = false;
			List<WrapperBeanObject<RentalPayNormalSearchSP>> rentalPayNormalSearchSP = getSemmrt004Bean().getRentalPayNormalSearchSPList();
			for (WrapperBeanObject<RentalPayNormalSearchSP> wrapperBeanObject : rentalPayNormalSearchSP) {
				if(wrapperBeanObject.isCheckBox()){
					return true;
				}
			}
			return isCheck;
		}
		
		public void onRenderAddButton(){
			semmrt004Bean = getSemmrt004Bean();
			semmrt004Bean.setValidateBtn(true);
			for (WrapperBeanObject<RentalPayNormalSearchSP> temp : semmrt004Bean.getRentalPayNormalSearchSPList()) {
				RentalPayNormalSearchSP rt = (RentalPayNormalSearchSP)temp.getDataObj();
				if(temp.isCheckBox()){
					semmrt004Bean.setValidateBtn(false);
				}
			}
			setSemmrt004Bean(semmrt004Bean);		
		}
		
		public boolean initExportExcel(){
			semmrt004Bean = getSemmrt004Bean();
			/*if(!validateExportExcel()){
				semmrt004Bean.setRenderedMsgFormMiddle(false);
				semmrt004Bean.setRenderedMsgFormBottom(false);
				semmrt004Bean.setDisplayShowExcel(false);
				return false;
			}*/
			semmrt004Bean.setDisplayShowExcel(true);
			setSemmrt004Bean(semmrt004Bean);
			return true;
		}
		
		public boolean onRenderMsgErrorExoprt(){
			boolean flag = false;
			addMessageError("W0098");
			getSemmrt004Bean().setRenderedMsgFormTop(true);
			getSemmrt004Bean().setRenderedMsgFormMiddle(false);
			getSemmrt004Bean().setRenderedMsgFormBottom(false);
			return flag;
		}
		
		public void doExportExcel(){
			log.info("doExportExcel");
			String renType = "";
			semmrt004Bean = getSemmrt004Bean();
			String payType = "";
			String chqDt = "";
			String chqRecDt = "";
			String tranfDt = "";	
				//isCheckBox in Group
				String tempPaymentGroup = "";
				String paymentBatchNo = "";
				String tmpPaymentBatchNo = "";
				int totalPBatchNo = 0;
				for (WrapperBeanObject<RentalPayNormalSearchSP> temp : semmrt004Bean.getRentalPayNormalSearchSPList()) {
					RentalPayNormalSearchSP rt = (RentalPayNormalSearchSP)temp.getDataObj();
					if(temp.isCheckBox()){
						
						//Adding by mr.John from (mr.Choosak) 28/04/2011
						paymentBatchNo = rt.getPaymentBatchNo();
						if(StringUtils.isNotBlank(paymentBatchNo)){
							if(!StringUtils.equals(paymentBatchNo, tmpPaymentBatchNo))
							totalPBatchNo++;
						}
						if(StringUtils.isNotBlank(paymentBatchNo))
						tmpPaymentBatchNo = paymentBatchNo;
						
						tempPaymentGroup = rt.getPaymentGroupNo();
						payType = StringUtils.isNotEmpty(rt.getPaymentTypeDesc())?rt.getPaymentTypeDesc():"" + (StringUtils.isNotEmpty(rt.getBankName())?rt.getBankName():"");
						if("01".equals(rt.getPaymentType())){
							String bankName = StringUtils.isBlank(rt.getBankName()) ? "" : rt.getBankName(); 
							renType = rt.getPaymentTypeDesc() + bankName;
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
				    // Date Format
				    DateFormat df =  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
				    
				    //call store procedure get PaymentBatchNo
				    IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
				    List<MrtGetRunningNo> to = null;
				    semmrt004Bean.getMrtGetRunningNo().setRunningType("RT_PAY_BATCH");
				    to = rentalPaymentService.querySPList(EQueryName.SP_MRT_GET_RUNNING_NO.name, semmrt004Bean.getMrtGetRunningNo());
				    
				    short line = 0;
					Collection<RentalPayNormalSearchSP> exList = new ArrayList<RentalPayNormalSearchSP>();
					//PDocumentManager export to excel
					DocumentExportManager<RentalPayNormalSearchSP> docManager =
						new DocumentExportManager<RentalPayNormalSearchSP>(RentalPayNormalSearchSP.class, EnumDocumentType.XLS);
					// set current configuration of work book.	
						docManager.setRowStart(line);
					EnumDocStyleDomain 	titleStyle =  new EnumDocStyleDomain(EnumDocStyle.TITLE);
				    RowDomain row0 = new RowDomain(0,true);	
					row0.setCell(new CellDomain(0,14, null, String.class, titleStyle, msg("export.col.rentalpayNormalHeader")+" "+msg("export.col.date")+" "+df.format(new Date()),null));
					
					if(StringUtils.isBlank(tmpPaymentBatchNo)){
						tmpPaymentBatchNo = to.get(0).getRunningNo();
					}
					
					RowDomain row1 = new RowDomain(1,true);	
					row1.setCell(new CellDomain(0,14, null, String.class, titleStyle, msg("export.col.paymentBatchNo")+" "+tmpPaymentBatchNo, null));
					
					RowDomain row5 = new RowDomain(2,true);
					row5.setCell(new CellDomain(0,14, null, String.class, titleStyle, msg("export.label.jobType")+" : "+ WebUtil.getSelectItemByValue(semmrt004Bean.getRentalPayNormalSearchSP().getJobType(), semmrt004Bean.getJobTypeList()).get(0).getLabel(), null));
					
					RowDomain row2 = new RowDomain(3,true);
					
					EnumDocStyleDomain field = docManager.getStyle("normalField");
					EnumDocStyleDomain 	headerStyle =  docManager.getStyle("rt003FieldHeader");
					
					RowDomain row3 = new RowDomain(4,true);
					row3.setCell(new CellDomain(0, null, String.class, headerStyle, msg("export.col.no"),-1,750));
					row3.setCell(new CellDomain(1, null, String.class, headerStyle, msg("export.col.paymentDocNo"),-1,3300));
					row3.setCell(new CellDomain(2, null, String.class, headerStyle, "Vendor Code",-1,2400));
					row3.setCell(new CellDomain(3, null, String.class, headerStyle,msg("export.col.contractNo"),-1,2500));
					row3.setCell(new CellDomain(4, null, String.class, headerStyle,msg("export.col.rentalapyNormalSiteName"),-1,3500));
					row3.setCell(new CellDomain(5, null, String.class, headerStyle,"Due Date",-1,2200));
//					row3.setCell(new CellDomain(6, null, String.class, headerStyle,msg("export.col.jobType"),-1,5000));
					row3.setCell(new CellDomain(6, null, String.class, headerStyle,msg("export.col.payPeriodType"),-1,2550));
					row3.setCell(new CellDomain(7, null, String.class, headerStyle,msg("export.col.periodNo"),-1,1200));
					row3.setCell(new CellDomain(8, null, String.class, headerStyle,"Vendor Name",-1,3500));
					row3.setCell(new CellDomain(9, null, String.class, headerStyle,"Payee",-1,3200));
					row3.setCell(new CellDomain(10, null, String.class, headerStyle,"WHT Type",-1,2400));
					row3.setCell(new CellDomain(11, null, String.class, headerStyle,"Amount",-1,2500));
					row3.setCell(new CellDomain(12, null, String.class, headerStyle,"VAT AMT",-1,2000));
					row3.setCell(new CellDomain(13, null, String.class, headerStyle,"WHT AMT",-1,2000));
					row3.setCell(new CellDomain(14, null, String.class, headerStyle,"NET AMT",-1,2500));
					
					RowDomain row6 = new RowDomain(0,false);
					
					RowDomain row4 = new RowDomain(1,false);
					RowDomain row7 = new RowDomain(2,false);
					RowDomain row8 = new RowDomain(3,false);
					
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
						row4.setCell(new CellDomain(2, null, String.class, field, renType,null));
						row8.setCell(new CellDomain(1, null, String.class, titleStyle, msg("export.column.contract.tranDt")+" : ",null));
						row8.setCell(new CellDomain(2, null, String.class, field, tranfDt,null));
					}
					
					List<WrapperBeanObject<RentalPayNormalSearchSP>> detailList = new ArrayList<WrapperBeanObject<RentalPayNormalSearchSP>>();
					detailList = getSemmrt004Bean().getRentalPayNormalSearchSPList();
					int no = 0;
					SelectItem jobType = WebUtil.getSelectItemByValue(semmrt004Bean.getRentalPayNormalSearchSP().getJobType(), semmrt004Bean.getJobTypeList()).get(0);
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
					
					docManager.putDetailRow(row0);
					docManager.putDetailRow(row1);
					docManager.putDetailRow(row5);
					docManager.putDetailRow(row4);
					docManager.putDetailRow(row2);
					docManager.putDetailRow(row4);
					docManager.putDetailRow(row6);
					docManager.putDetailRow(row8);
					docManager.putDetailRow(row3);
					docManager.seteObjectList(exList);
					docManager.setMargin(0, 0, 0, 0);
					docManager.setModule("RENTAL");
					// set Print with landscape page style.
					docManager.setPrintPageLandScape(true);
					docManager.getObjectFromDocument();
					docManager.exportServletFile();
		           
					semmrt004Bean.setBtnStatus("EP");
					setSemmrt004Bean(semmrt004Bean);
					doSaveAct();
					
//					semmrt004Bean.setBtnStatus("EP");
//					setSemmrt004Bean(semmrt004Bean);
//					doSaveAct();
					semmrt004Bean.setDisplayShowExcel(false);
				}catch(NullPointerException ne){
					log.error(ne);
				}catch(Exception e){
					log.error(e);
				}
		}
		
		public boolean validateExport(){
			boolean flagValid = true;
			semmrt004Bean = getSemmrt004Bean();
			
			for (WrapperBeanObject<RentalPayNormalSearchSP> temp : semmrt004Bean.getRentalPayNormalSearchSPList()) {
				RentalPayNormalSearchSP rt = (RentalPayNormalSearchSP)temp.getDataObj();
				if(temp.isCheckBox()){
					if(rt.getPaymentStatus().equals("01")){
						flagValid = false;
						break;
					}
				}
			}
			
			return flagValid;
		}
		
		private boolean validateExportExcel(){
			 semmrt004Bean = getSemmrt004Bean();
			 String payType = null;
			 for (WrapperBeanObject<RentalPayNormalSearchSP> temp : semmrt004Bean.getRentalPayNormalSearchSPList()) {
					RentalPayNormalSearchSP rt = (RentalPayNormalSearchSP)temp.getDataObj();
					if(temp.isCheckBox()){
						if(payType == null){
							payType = rt.getPaymentType();
						}
						if(!payType.equals(rt.getPaymentType())){
							//Error Msg
							addMessageError(("W0075"), msg("export.col.paymentTypeDesc"));
							return false;
						}
					}
			}
			return true;
		}
		
		public void onRenderTotal(){
			semmrt004Bean = getSemmrt004Bean();
			if(!validateDepositAmount()){
				addMessageError("W0026");
			}else{
				semmrt004Bean.getRentalPayNormalSearchDSP().setPaymentAmt(
						(semmrt004Bean.getRentalPayNormalSearchDSP().getTotalAmt()!=null?semmrt004Bean.getRentalPayNormalSearchDSP().getTotalAmt():0.0 )
					  - (semmrt004Bean.getRentalPayNormalSearchDSP().getDepositAmt()!=null?semmrt004Bean.getRentalPayNormalSearchDSP().getDepositAmt():0.00));
				setSemmrt004Bean(semmrt004Bean);
			}
		}
		
		public boolean validateDepositAmount(){
			boolean flagValid = true;
			semmrt004Bean = getSemmrt004Bean();
			if(semmrt004Bean.getRentalPayNormalSearchDSP().getDepositAmt() > semmrt004Bean.getRentalPayNormalSearchDSP().getMaxDepositAmt()){
				flagValid = false;
			}
			return flagValid;
		}
		
		public void onrenderAmountVat(){
			semmrt004Bean = getSemmrt004Bean();
			IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
			List<Mrt003Cal> to = null;
			String modeChange = (String)getFacesUtils().getRequestParameter("modeChange");
			semmrt004Bean.setMrt003Cal(new Mrt003Cal());
			if("year".equalsIgnoreCase(modeChange)){
				semmrt004Bean.getRentalPayNormalSearchDSP().setCalMonth(null);
			}else if("month".equalsIgnoreCase(modeChange)){
				semmrt004Bean.getRentalPayNormalSearchDSP().setCalYear(null);
			}
			
			semmrt004Bean.getMrt003Cal().setRentalpaymentId(semmrt004Bean.getRentalPayNormalSearchDSP().getRowId());
//			semmrt004Bean.getMrt003Cal().setCalMonth(Integer.toString(semmrt004Bean.getRentalPayNormalSearchDSP().getCalMonth()));
//			semmrt004Bean.getMrt003Cal().setCalYear(Integer.toString(semmrt004Bean.getRentalPayNormalSearchDSP().getCalYear()));
			if(semmrt004Bean.getRentalPayNormalSearchDSP().getCalYear() != null)
				semmrt004Bean.getMrt003Cal().setCalYear(semmrt004Bean.getRentalPayNormalSearchDSP().getCalYear().toString());
			if(semmrt004Bean.getRentalPayNormalSearchDSP().getCalMonth() != null && semmrt004Bean.getRentalPayNormalSearchDSP().getCalMonth() != 0)
				semmrt004Bean.getMrt003Cal().setCalMonth(semmrt004Bean.getRentalPayNormalSearchDSP().getCalMonth().toString());
			semmrt004Bean.getMrt003Cal().setDiscountRate(semmrt004Bean.getRentalPayNormalSearchDSP().getDiscountRate());
			semmrt004Bean.getMrt003Cal().setDiscountAmt(semmrt004Bean.getRentalPayNormalSearchDSP().getDiscountAmt());
			
			log.debug("semmrt004Bean.getMrt003Cal().getCalYear() = "+semmrt004Bean.getMrt003Cal().getCalYear());
			log.debug("semmrt004Bean.getMrt003Cal().getCalMonth() = "+semmrt004Bean.getMrt003Cal().getCalMonth());
			log.debug("semmrt004Bean.getMrt003Cal().getDiscountRate() = "+semmrt004Bean.getMrt003Cal().getDiscountRate());
			log.debug("semmrt004Bean.getMrt003Cal().getDiscountAmt() = "+semmrt004Bean.getMrt003Cal().getDiscountAmt());
			
			try {
				to = rentalPaymentService.querySPList(EQueryName.SP_MRT003_CAL.name, semmrt004Bean.getMrt003Cal());
				//Add Calculations to RentalpayNormalSearchD
				if(to != null){
					semmrt004Bean.getRentalPayNormalSearchDSP().setDueAmt(to.get(0).getDueAmt());
					semmrt004Bean.getRentalPayNormalSearchDSP().setExcAmt(to.get(0).getExcAmt());
					semmrt004Bean.getRentalPayNormalSearchDSP().setVatAmt(to.get(0).getVatAmt());
					semmrt004Bean.getRentalPayNormalSearchDSP().setIncAmt(to.get(0).getIncAmt());
					semmrt004Bean.getRentalPayNormalSearchDSP().setWhtAmt(to.get(0).getWhtAmt());
					semmrt004Bean.getRentalPayNormalSearchDSP().setTotalAmt(to.get(0).getTotalAmt());				
				}
				setSemmrt004Bean(semmrt004Bean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error(e);
			}
		}
		
		public boolean validateTotalAmount(){
			boolean flagValid = true;
			semmrt004Bean = getSemmrt004Bean();
			Double defaultValPositive = 1.00;
			Double defaultValNegasitive = -1.00;
			if(semmrt004Bean.getRentalPayNormalSearchDSP().getExcAmt() != null){
				if(semmrt004Bean.getOldExcAmt() == null){
					semmrt004Bean.setOldExcAmt(0.00);
				}
				Double tmpExcAmt = semmrt004Bean.getOldExcAmt() - semmrt004Bean.getRentalPayNormalSearchDSP().getExcAmt();
				if(tmpExcAmt > defaultValPositive || tmpExcAmt < defaultValNegasitive){
					semmrt004Bean.getRentalPayNormalSearchDSP().setExcAmt(semmrt004Bean.getOldExcAmt());
					semmrt004Bean.getRentalPayNormalSearchDSP().setIncAmt(semmrt004Bean.getOldIncAmt());
					flagValid = false;
				}
			}
			if(semmrt004Bean.getRentalPayNormalSearchDSP().getVatAmt() != null){
				if(semmrt004Bean.getOldVatAmt() == null){
					semmrt004Bean.setOldVatAmt(0.00);
				}
				Double tmpVatAmt = semmrt004Bean.getOldVatAmt() - semmrt004Bean.getRentalPayNormalSearchDSP().getVatAmt();
				if(tmpVatAmt > defaultValPositive || tmpVatAmt < defaultValNegasitive){
					semmrt004Bean.getRentalPayNormalSearchDSP().setVatAmt(semmrt004Bean.getOldVatAmt());
					semmrt004Bean.getRentalPayNormalSearchDSP().setIncAmt(semmrt004Bean.getOldIncAmt());
					flagValid = false;
				}
			}
			if(semmrt004Bean.getRentalPayNormalSearchDSP().getWhtAmt() != null){
				if(semmrt004Bean.getOldWhtAmt() == null){
					semmrt004Bean.setOldWhtAmt(0.00);
				}
				Double tmpWhtAmt = semmrt004Bean.getOldWhtAmt() - semmrt004Bean.getRentalPayNormalSearchDSP().getWhtAmt();
				if(tmpWhtAmt > defaultValPositive || tmpWhtAmt < defaultValNegasitive){
					semmrt004Bean.getRentalPayNormalSearchDSP().setWhtAmt(semmrt004Bean.getOldWhtAmt());
					semmrt004Bean.getRentalPayNormalSearchDSP().setTotalAmt(semmrt004Bean.getOldTotalAmt());
					flagValid = false;
				}
			}
			setSemmrt004Bean(semmrt004Bean);
			return flagValid;
		}
		
		public boolean doClearApproveStatus(){
			boolean flag = false;
			semmrt004Bean = getSemmrt004Bean();
			semmrt004Bean.setBtnApproveStatus("");
			semmrt004Bean.setRemark(null);
			setSemmrt004Bean(semmrt004Bean);
			return flag;
		}
		
		public void getRowIdOnClick() {
			String rowId = (String)getFacesUtils().getRequestParameter("rowId");
			getSemmrt004Bean().setTmpRowId(rowId);
		}
		
		public void renderDiscountCheckBox(){
			semmrt004Bean = getSemmrt004Bean();
			if(!semmrt004Bean.getRentalPayNormalSearchDSP().isDiscountFlg()){
				semmrt004Bean.getRentalPayNormalSearchDSP().setDiscountRate(null);
				semmrt004Bean.getRentalPayNormalSearchDSP().setDiscountAmt(null);
			}
			log.debug("test = "+semmrt004Bean.getRentalPayNormalSearchDSP().getCalMonth());
			setSemmrt004Bean(semmrt004Bean);
		}
		
		public void calDiscountPercent(){
			semmrt004Bean = getSemmrt004Bean();
			double discountAmt = (semmrt004Bean.getRentalPayNormalSearchDSP().getDueAmt() * semmrt004Bean.getRentalPayNormalSearchDSP().getDiscountRate())/100;
			semmrt004Bean.getRentalPayNormalSearchDSP().setDiscountAmt(discountAmt);
			setSemmrt004Bean(semmrt004Bean);
			onrenderAmountVat();
		}
		
		public void calDiscountAmt(){
			semmrt004Bean = getSemmrt004Bean();
			semmrt004Bean.getRentalPayNormalSearchDSP().setDiscountRate(null);
			setSemmrt004Bean(semmrt004Bean);
			onrenderAmountVat();
		}
}
