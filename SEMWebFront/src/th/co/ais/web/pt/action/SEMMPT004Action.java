package th.co.ais.web.pt.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
//import org.hsqldb.lib.StringUtil;

import th.co.ais.domain.gm.Province;
import th.co.ais.domain.gm.VendorMaster;
import th.co.ais.domain.gm.VendorMasterSP;
import th.co.ais.domain.pt.Mpt002SrchHist;
import th.co.ais.domain.pt.Mpt004Act;
import th.co.ais.domain.pt.Mpt004Cal;
import th.co.ais.domain.pt.Mpt004Chk;
import th.co.ais.domain.pt.Mpt004Edt;
import th.co.ais.domain.pt.Mpt004Pay;
import th.co.ais.domain.pt.Mpt004Srch;
import th.co.ais.domain.pt.Mpt004SrchC;
import th.co.ais.domain.pt.Mpt004SrchD;
import th.co.ais.domain.pt.PtaxPayment;
import th.co.ais.domain.rt.EMAILModel;
import th.co.ais.domain.rt.Mrt003ChkVendorMulti;
import th.co.ais.domain.rt.MrtGetRunningNo;
import th.co.ais.domain.rt.RentalPayNormalSearchSP;
import th.co.ais.domain.rt.SMSModel;
import th.co.ais.domain.si.Contract;
import th.co.ais.rpt.util.bean.CellDomain;
import th.co.ais.rpt.util.bean.EnumDocStyleDomain;
import th.co.ais.rpt.util.bean.RowDomain;
import th.co.ais.rpt.util.enums.EnumDocStyle;
import th.co.ais.rpt.util.enums.EnumDocumentType;
import th.co.ais.service.gm.IVendorMasterService;
import th.co.ais.service.pt.IPTaxMasterService;
import th.co.ais.service.pt.IPTaxPaymentService;
import th.co.ais.service.rt.IRentalPaymentService;
import th.co.ais.service.si.ISiteContractService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.common.PopupSiteContractAntCriBean;
import th.co.ais.web.bean.common.PopupUploadFilePictureBean;
import th.co.ais.web.pt.bean.SEMMPT002Bean;
import th.co.ais.web.pt.bean.SEMMPT004Bean;
import th.co.ais.web.report.util.DocumentExportManager;
import th.co.ais.web.util.ELUtils;
import th.co.ais.web.util.EmailMessageUtil;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.LOVCacheUtil;
import th.co.ais.web.util.MSGCacheUtil;
import th.co.ais.web.util.ProvinceCacheUtil;
import th.co.ais.web.util.SemUtils;
import th.co.ais.web.util.SmsClient;
import th.co.ais.web.util.config.ParameterConfigUtil;

public class SEMMPT004Action extends AbstractAction{

	private Logger log = Logger.getLogger(getClass());
	String tmpFlagValidate = "Y";
	
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
		}else if (methodWithNavi.equalsIgnoreCase("doClearSession")) {
			flag = doClearSession();
		}else if (methodWithNavi.equalsIgnoreCase("initEdit")) {
			flag = initEdit();
		}else if (methodWithNavi.equalsIgnoreCase("doUpdatePay")) {
			flag = doUpdatePay();
		}else if (methodWithNavi.equalsIgnoreCase("doUpdateAct")) {
			flag = doUpdateAct();
		}else if (methodWithNavi.equalsIgnoreCase("initApprove")) {
			flag = initApprove();
		}else if (methodWithNavi.equalsIgnoreCase("initCoppyDate")) {
			flag = initCoppyDate();
		}else if (methodWithNavi.equalsIgnoreCase("doCoppyDate")) {
			flag = doCoppyDate();
		}else if (methodWithNavi.equalsIgnoreCase("pageLoad")) {
			flag = pageLoad();
		}else if (methodWithNavi.equalsIgnoreCase("doShow")) {
			flag = doShow();
		}else if (methodWithNavi.equalsIgnoreCase("doSave")) {
			flag = doSave();
		}else if (methodWithNavi.equalsIgnoreCase("doBack")) {
			flag = doBack();
		}else if (methodWithNavi.equalsIgnoreCase("doClearApproveStatus")) {
			flag = doClearApproveStatus();
		}else if (methodWithNavi.equalsIgnoreCase("doClearFormPay")) {
			flag = doClearFormPay();
		}
		else if (methodWithNavi.equalsIgnoreCase("onRenderMsgErrorExoprt")) {
			flag = onRenderMsgErrorExoprt();
		}else if (methodWithNavi.equalsIgnoreCase("doSendSMS")) {
			flag = doSendSMS();
		}else if (methodWithNavi.equalsIgnoreCase("doSendEmail")) {
			flag = doSendEmail();
		}else if(methodWithNavi.equalsIgnoreCase("doInitialForSearchPropertyTax")){
			flag = doInitialForSearchPropertyTax();
		}
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		SEMMPT004Bean semmpt004Bean = new SEMMPT004Bean();
		String lovVals = "ALL"+","+"PTAX";
		semmpt004Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmpt004Bean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList());
		semmpt004Bean.setGovtList(getEmptyDropDown());
		semmpt004Bean.setpTaxPayTypeList(getLovItemsByType(ELovType.T_PT_PROPERTY_TAX_PAY_TYPE.name, EX_IN, "PAY", null, null));
		semmpt004Bean.setExpenseTypeList(getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name, EX_IN, "PROPERTY_TAX", null, null));
		semmpt004Bean.setPaymentTypeList(LOVCacheUtil.getInstance().getPaymentTypeSelList());
		semmpt004Bean.setPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name));
		semmpt004Bean.setDocTypeList(getLovItemsByType(ELovType.T_CT_PAYMENT_DOC_TYPE.name, EX_IN, lovVals, null, null));
		semmpt004Bean.setPenaltyTypeList(getLovItemsByType(ELovType.T_PT_PENALTY_TYPE.name));
		semmpt004Bean.setWhtRateList(getLovItemsByType(ELovType.T_CT_WHT_RATE.name));
		semmpt004Bean.setPaymentStatusList(getLovItemsByType(ELovType.T_CT_PAYMENT_STATUS.name));
		semmpt004Bean.setRegionList(getRegionItems());
		semmpt004Bean.setAmphurList(getEmptyDropDown());
		semmpt004Bean.setMpt004Srch(new Mpt004Srch());
		semmpt004Bean.setMpt004Pay(new Mpt004Pay());
		semmpt004Bean.setMpt004Act(new Mpt004Act());
		semmpt004Bean.setpTaxpayment(new PtaxPayment());
		semmpt004Bean.setMpt004SrchD(new Mpt004SrchD());
		semmpt004Bean.setMrtGetRunningNo(new MrtGetRunningNo());
		semmpt004Bean.setMpt004Chk(new Mpt004Chk());
		semmpt004Bean.setMpt004Edt(new Mpt004Edt());
		semmpt004Bean.setMpt004Cal(new Mpt004Cal());
		semmpt004Bean.setMpt004SrchC(new Mpt004SrchC());
		semmpt004Bean.setValidateBtn(true);
		semmpt004Bean.getMpt004Srch().setPaymentStatus("01");
		semmpt004Bean.setTmpPayGovtFlag(true);
//		semmpt004Bean.getMpt004Srch().setEstimateFlag("02");
		List<SelectItem> listYearSelect = SemUtils.getYearSelect();
		semmpt004Bean.setpTaxYearFromList(listYearSelect);
    	semmpt004Bean.setpTaxYearToList(listYearSelect);
//    	semmpt004Bean.setDisabledBtnExport(false);
//    	semmpt004Bean.setRenderedBtnA4JExport(false);
    	semmpt004Bean.setRenderedBtnHExport(true);
    	semmpt004Bean.setRenderedOnToDoList(false);
		setSemmpt004Bean(semmpt004Bean);
		PopupSiteContractAntCriBean popupSiteContractAntCriBean = new PopupSiteContractAntCriBean();
		setPopupSiteContractAntCriBean(popupSiteContractAntCriBean);
//		doAddYearDropDown();
		doAddPeriodNoDropDown();
		doAddDateFromDropDown();
		
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

	private SEMMPT004Bean semmpt004Bean;
	
	public SEMMPT004Bean getSemmpt004Bean() {
		return (SEMMPT004Bean)getFacesUtils().getSessionMapValue("semmpt004Bean");
	}

	public void setSemmpt004Bean(SEMMPT004Bean semmpt004Bean) {
		this.semmpt004Bean = semmpt004Bean;
		getFacesUtils().setSessionMapValue("semmpt004Bean", semmpt004Bean);
	}

	public void doAddYearDropDown(){
		semmpt004Bean = getSemmpt004Bean();
		SelectItem selItem = null;
		Date dt = new Date();
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy", Locale.ENGLISH);
        Integer tmpPTaxYear = Integer.parseInt(dateformatter.format(dt));
        Integer tmpPTaxYearThai = Integer.parseInt(dateformatter.format(dt));
        List<SelectItem> list = new LinkedList<SelectItem>();
        selItem = new SelectItem("" , msg("value.selectItem"));
		list.add(selItem);
		setSemmpt004Bean(semmpt004Bean);
        for(int i = 0; i<11; i++){
        	selItem = new SelectItem();
        	if(i!=0){
        	   tmpPTaxYear = tmpPTaxYear-1;
        	   tmpPTaxYearThai = tmpPTaxYear - 1;
        	}
            tmpPTaxYearThai = tmpPTaxYear + 543;
        	selItem.setLabel(String.valueOf(tmpPTaxYearThai));
     	    selItem.setValue(tmpPTaxYear);
        	list.add(selItem);
        	semmpt004Bean.setpTaxYearFromList(list);
        	semmpt004Bean.setpTaxYearToList(list);
        }
        setSemmpt004Bean(semmpt004Bean);
	}
	
	public void doAddPeriodNoDropDown(){
		semmpt004Bean = getSemmpt004Bean();
		SelectItem selItem = null;
		Integer tmpPeriodNo = 0;
		List<SelectItem> list = new LinkedList<SelectItem>();
		selItem = new SelectItem("" , msg("value.selectItem"));
		list.add(selItem);
		setSemmpt004Bean(semmpt004Bean);
		List monthList = new ArrayList();
		monthList.add("มกราคม");
		monthList.add("กุมภาพันธ์");
		monthList.add("มีนาคม");
		monthList.add("เมษายน");
		monthList.add("พฤษภาคม");
		monthList.add("มิถุนายน");
		monthList.add("กรกฎาคม");
		monthList.add("สิงหาคม");
		monthList.add("กันยายน");
		monthList.add("ตุลาคม");
		monthList.add("พฤศจิกายน");
		monthList.add("ธันวาคม");
		
		for(int i=0; i<12 ; i++){
			selItem = new SelectItem();
//			if(i == 0){
//				selItem.setLabel(String.valueOf(tmpPeriodNo));
//	        	selItem.setValue(tmpPeriodNo);
//	        	list.add(selItem);
//	        	semmpt004Bean.setPeriodFromList(list);
//	        	semmpt004Bean.setPeriodToList(list);
//			}else{
				tmpPeriodNo = tmpPeriodNo+1;
				selItem.setLabel(String.valueOf(monthList.get(i)));
	        	selItem.setValue(tmpPeriodNo);
	        	list.add(selItem);
	        	semmpt004Bean.setPeriodFromList(list);
	        	semmpt004Bean.setPeriodToList(list);
//			}
		}
		setSemmpt004Bean(semmpt004Bean);		
	}
	

	public boolean initExportExcel(){
		semmpt004Bean = getSemmpt004Bean();
		if(!validateExportExcel()){
			semmpt004Bean.setRenderedMsgFormMiddle(false);
			semmpt004Bean.setRenderedMsgFormBottom(false);
			semmpt004Bean.setDisplayShowExcel(false);
			return false;
		}
		semmpt004Bean.setDisplayShowExcel(true);
		setSemmpt004Bean(semmpt004Bean);
		return true;
	}
	
	private boolean validateExportExcel(){
		 semmpt004Bean = getSemmpt004Bean();
		 String payType = null;
		 for (WrapperBeanObject<Mpt004Srch> temp : semmpt004Bean.getMpt004SrchList()) {
			 Mpt004Srch pt = (Mpt004Srch)temp.getDataObj();
				if(temp.isCheckBox()){
					if(payType == null){
						payType = pt.getPaymentType();
					}
					if(!payType.equals(pt.getPaymentType())){
						//Error Msg
						addMessageError(("W0075"), msg("export.col.paymentTypeDesc"));
						return false;
					}
				}
		}
		return true;
	}
	
	public void doAddDateFromDropDown(){
		semmpt004Bean = getSemmpt004Bean();
		SelectItem selItem = null;
		List<SelectItem> list = new LinkedList<SelectItem>();
		selItem = new SelectItem("" , msg("value.selectItem"));
		list.add(selItem);
		setSemmpt004Bean(semmpt004Bean);
		
		List monthList = new ArrayList();
		monthList.add("");
		monthList.add("มกราคม");
		monthList.add("กุมภาพันธ์");
		monthList.add("มีนาคม");
		monthList.add("เมษายน");
		monthList.add("พฤษภาคม");
		monthList.add("มิถุนายน");
		monthList.add("กรกฎาคม");
		monthList.add("สิงหาคม");
		monthList.add("กันยายน");
		monthList.add("ตุลาคม");
		monthList.add("พฤศจิกายน");
		monthList.add("ธันวาคม");
		
		for(int i=1; i<13 ; i++){
			
			selItem = new SelectItem();
				selItem.setLabel(String.valueOf(monthList.get(i)));
				if(i<10){
					selItem.setValue("0"+i);
				}else{
					selItem.setValue(i);
				}
	        	list.add(selItem);
	        	semmpt004Bean.setMonthFromList(list);
	        	semmpt004Bean.setMonthToList(list);
		}
		setSemmpt004Bean(semmpt004Bean);		
	}
	
	public boolean doSearch(){
		boolean flag = false;
		semmpt004Bean = getSemmpt004Bean();
		if(!semmpt004Bean.isRenderedOnToDoList()){
			if(tmpFlagValidate.equals("Y")){
				if(!validateSearch()){
					semmpt004Bean.setRenderedMsgFormTop(true);
					semmpt004Bean.setRenderedMsgFormMiddle(false);
					return flag;
				}
			}
		}else{
			if(StringUtils.isEmpty(semmpt004Bean.getMpt004Srch().getStrParam())){
				addGeneralMessageError("SEMMPT004Action : P_PARAMETER is null");
				return flag;
			}
		}
		
		semmpt004Bean.setChkSelAll(false);
		IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
		List<Mpt004Srch> to = null;
		semmpt004Bean.setMpt004SrchList(new ArrayList<WrapperBeanObject<Mpt004Srch>>());
		String tempId = "";
		if(semmpt004Bean.isChkPayGovtFlag()){
			semmpt004Bean.getMpt004Srch().setPicoFlag("Y");
		}else{
			semmpt004Bean.getMpt004Srch().setPicoFlag("N");
		}
		if(semmpt004Bean.isTmpPayGovtFlag()){
			semmpt004Bean.getMpt004Srch().setPayGovtFlag("Y");
		}
		else{
			semmpt004Bean.getMpt004Srch().setPayGovtFlag("N");
		}
		
		// fixed by.. YUT 2014/09/16
		semmpt004Bean.getMpt004Srch().setRcptPayFlag((semmpt004Bean.getMpt004Srch().isChkRcptPay()) ? "Y" : "N");
		
		try {
			to = pTaxMasterService.querySPList(EQueryName.SP_MPT004_SRCH.name, semmpt004Bean.getMpt004Srch());
			if(to == null || to.size() == 0){
				semmpt004Bean.setRenderedMsgDataNotFound(true);
				semmpt004Bean.setDisabledBtnExport(true);
				getSemmpt004Bean().setChkSelAll(false);
			}else{
				semmpt004Bean.setRenderedMsgDataNotFound(false);
				semmpt004Bean.setTmpChqDt(to.get(0).getChqDt());
				semmpt004Bean.setTmpChqReceiveDt(to.get(0).getChqReceiveDt());
				semmpt004Bean.setTmpTransferDt(to.get(0).getTransferDt());
				
				for(int i=0; i<to.size(); i++){
					 Mpt004Srch mpt004Srch = (Mpt004Srch)to.get(i);
					 WrapperBeanObject<Mpt004Srch> tmpWrapperBean = new WrapperBeanObject<Mpt004Srch>();
					 
					 if(tempId.equals(mpt004Srch.getPaymentGroupNo())){
						 mpt004Srch.setRenderCheckBox(false);
						 mpt004Srch.setRenderCommandLink(false);
						}else {
							if(mpt004Srch.getPaymentGroupNo() != null){
								tempId = mpt004Srch.getPaymentGroupNo();
							}
							mpt004Srch.setRenderCheckBox(true);
							mpt004Srch.setRenderCommandLink(true);
						}
						if(mpt004Srch.getChqDt() != null){
//							mpt004Srch.setChqDt(SEMDataUtility.convertToThYear(mpt004Srch.getChqDt()));
							mpt004Srch.setChqDtStr(convertYearENtoTHStr(mpt004Srch.getChqDt()));
						}
						if(mpt004Srch.getChqReceiveDt() != null){
//							mpt004Srch.setChqReceiveDt(SEMDataUtility.convertToThYear(mpt004Srch.getChqReceiveDt()));
							mpt004Srch.setChqReceiveDtStr(convertYearENtoTHStr(mpt004Srch.getChqReceiveDt()));
						}
						if(mpt004Srch.getTransferDt() != null){
//							mpt004Srch.setTransferDt(SEMDataUtility.convertToThYear(mpt004Srch.getTransferDt()));
							mpt004Srch.setTransferDtStr(convertYearENtoTHStr(mpt004Srch.getTransferDt()));
						}
						if(mpt004Srch.getExportDt() != null){
//							mpt004Srch.setExportDt(SEMDataUtility.convertToThYear(mpt004Srch.getExportDt()));
							mpt004Srch.setExportDtStr(convertYearENtoTHStr(mpt004Srch.getExportDt()));
						}
						if(mpt004Srch.getpTaxYear() != null){
							mpt004Srch.setpTaxYear(mpt004Srch.getpTaxYear()+543);
						}
						tmpWrapperBean.setDataObj(mpt004Srch);
						 tmpWrapperBean.setMessage("");
						 tmpWrapperBean.setCheckBox(false);
						 if(semmpt004Bean.getTmpChkBox() != null && 
							 semmpt004Bean.getTmpChkBox().size() != 0 &&
							 semmpt004Bean.getTmpChkBox().containsKey(mpt004Srch.getRowId())){
							 tmpWrapperBean.setCheckBox(true);
							 semmpt004Bean.getTmpChkBox().remove(mpt004Srch.getRowId());
						 }
						 semmpt004Bean.getMpt004SrchList().add(tmpWrapperBean);
				}
		}
			semmpt004Bean.setValidateBtn(true);
			semmpt004Bean.setTmpChkBox(new HashMap());
			setSemmpt004Bean(semmpt004Bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			addMessageError(("E0004"));
		} 
		return flag;
	}
	
	public boolean doClearSession(){
		boolean flag = false;
		semmpt004Bean = getSemmpt004Bean();
		semmpt004Bean.setMpt004Srch(new Mpt004Srch());
		semmpt004Bean.setMpt004SrchList(new ArrayList());
		semmpt004Bean.setDisabledBtnExport(true);
		semmpt004Bean.setChkPayGovtFlag(false);
		semmpt004Bean.setRenderedMsgDataNotFound(false);
		semmpt004Bean.getMpt004Srch().setPaymentStatus("01");
		semmpt004Bean.getMpt004Srch().setEstimateFlag("02");
		semmpt004Bean.setChkSelAll(false);
		setSemmpt004Bean(semmpt004Bean);
		return flag;
	}
	
	public boolean initEdit(){
		boolean flag = false;
		semmpt004Bean = getSemmpt004Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		try {
		for(WrapperBeanObject<Mpt004Srch> mpt : semmpt004Bean.getMpt004SrchList()){
			Mpt004Srch mpt004Srch = (Mpt004Srch)mpt.getDataObj();
			if(mpt004Srch.getRowId().equals(rowId)){
				semmpt004Bean.getMpt004Pay().setPaymentGroupNo(mpt004Srch.getPaymentGroupNo());
				semmpt004Bean.getMpt004Pay().setPaymentType(mpt004Srch.getPaymentType());
				semmpt004Bean.getMpt004Pay().setPaymentMethod(mpt004Srch.getPaymentMethod());
				semmpt004Bean.getMpt004Pay().setBankName(mpt004Srch.getBankName());
				semmpt004Bean.getMpt004Pay().setBankAccNo(mpt004Srch.getBankAccNo());
				if(mpt004Srch.getChqDt() != null){
					semmpt004Bean.getMpt004Pay().setChqDt(SEMDataUtility.convertToEnYear(mpt004Srch.getChqDt()));
				}
				if(mpt004Srch.getChqReceiveDt() != null){
					semmpt004Bean.getMpt004Pay().setChqReceive(SEMDataUtility.convertToEnYear(mpt004Srch.getChqReceiveDt()));
				}
				if(mpt004Srch.getTransferDt() != null){
					semmpt004Bean.getMpt004Pay().setTransferDt(SEMDataUtility.convertToEnYear(mpt004Srch.getTransferDt()));
				}
				semmpt004Bean.getMpt004Pay().setDocType(mpt004Srch.getDocType());
				semmpt004Bean.getMpt004Pay().setDocNo(mpt004Srch.getDocNo());
				semmpt004Bean.getMpt004Pay().setDocDt(mpt004Srch.getDocDt());
				semmpt004Bean.getMpt004Pay().setRemark(mpt004Srch.getRemark());
				semmpt004Bean.getMpt004Pay().setUserId(semmpt004Bean.getUserLogin());
			}
		}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setSemmpt004Bean(semmpt004Bean);
		onRenderPaymentMethod();
		return flag;
	}
	
	public boolean doUpdatePay(){
		boolean flag = false;
		semmpt004Bean = getSemmpt004Bean();
		if(!validateUpdatePay()){
			semmpt004Bean.setPopupClose(new Boolean(false));
			return flag;
		}
		IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
		List<Mpt004Pay> to = null;
		try {
			semmpt004Bean.getMpt004Pay().setUserId(getUserLogIn());
			to = pTaxMasterService.querySPList(EQueryName.SP_MPT004_Pay.name, semmpt004Bean.getMpt004Pay());
			if (to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")) {
				addMessageInfo("M0001");
				semmpt004Bean.setPopupClose(new Boolean(true));
			}else if(to != null && !to.isEmpty()){
				FrontMessageUtils.addMessageError(to.get(0).getpRemark());
				semmpt004Bean.setPopupClose(new Boolean(true));
			}
			semmpt004Bean.setRenderedMsgFormTop(false);
			semmpt004Bean.setRenderedMsgFormMiddle(true);
			doSearch();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			semmpt004Bean.setRenderedMsgFormTop(true);
			semmpt004Bean.setRenderedMsgFormMiddle(false);
			addMessageError("E0001");
			semmpt004Bean.setPopupClose(new Boolean(false));
		}
		return flag;
	}
	
	private boolean validateUpdatePay(){
		boolean flagValid = true;
		Date chqDt = getSemmpt004Bean().getMpt004Pay().getChqDt();
		Date chqReceiveDt = getSemmpt004Bean().getMpt004Pay().getChqReceive();
		Date transferDt = getSemmpt004Bean().getMpt004Pay().getTransferDt();
		if(StringUtils.isEmpty(getSemmpt004Bean().getMpt004Pay().getPaymentType())){
			addMessageError(("W0001"), msg("message.paymentType"));
			flagValid = false;
		}
		if(StringUtils.isEmpty(getSemmpt004Bean().getMpt004Pay().getPaymentMethod()) &&
			getSemmpt004Bean().isRenderedPaymentMethod() == false){
			addMessageError(("W0001"), msg("message.paymentMethod"));
			flagValid = false;
		}
//		ตอนนี้ค่ายังไม่มี
//		if(StringUtils.isEmpty(getSemmpt004Bean().getMpt004Pay().getBankName())){
//			addMessageError(("W0001"), msg("message.bankName"));
//			flagValid = false;
//		}
//		if(StringUtils.isEmpty(getSemmpt004Bean().getMpt004Pay().getBankAccNo())){
//			addMessageError(("W0001"), msg("massage.bankAccNo"));
//		}
		try{
			if(getSemmpt004Bean().getMpt004Pay().getChqDt() == null){
				   if(getSemmpt004Bean().isRenderedChqDt() == false){
					addMessageError(("W0001"), msg("message.chqDt"));
					flagValid = false;
				   }
				}else{
					if(SEMDataUtility.getCurrentDateByPattern().compareTo(chqDt) > 0){
						addMessageErrorWithArgument("W0006" ,("To Day"), msg("message.chqDt") );
						flagValid = false;
					}
				}
				
				if(getSemmpt004Bean().getMpt004Pay().getChqReceive() == null){
				   if(getSemmpt004Bean().isRenderedChqDt() == false){
					addMessageError(("W0001"), msg("message.chqReceiveDt"));
					flagValid = false;
				   }
				}else{
					if((SEMDataUtility.getCurrentDateByPattern().compareTo(chqReceiveDt) > 0)){
						addMessageErrorWithArgument("W0006" ,("To Day"), msg("message.chqReceiveDt") );
						flagValid = false;
					}
				}
				
				if(getSemmpt004Bean().getMpt004Pay().getTransferDt() == null){
				   if(getSemmpt004Bean().isRenderedTransferDt() == false){
					addMessageError(("W0001"), msg("message.transferDt"));
					flagValid = false;
				   }
				}
				else{
					if((SEMDataUtility.getCurrentDateByPattern().compareTo(transferDt) > 0)){
						addMessageErrorWithArgument("W0006" ,("To Day"), msg("message.transferDt") );
						flagValid = false;
					}
				}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
//		if(StringUtils.isEmpty(getSemmpt004Bean().getMpt004Pay().getDocType())){
//			addMessageError(("W0001"), msg("message.docType"));
//			flagValid = false;
//		}
		return flagValid;
	}
	
	public boolean doUpdateAct(){
		boolean flag = false;
		semmpt004Bean = getSemmpt004Bean();
		String rowsIdConcat = "";
		String tempPaymentGroup = "";
		IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
		String btnStatus = "";
		List<Mpt004Act> to = null;
		
		if(semmpt004Bean.getBtnApproveStatus() != null && 
		   !StringUtils.isEmpty(semmpt004Bean.getBtnApproveStatus())){
			btnStatus = semmpt004Bean.getBtnApproveStatus();
			if(semmpt004Bean.getBtnApproveStatus().equals("CA") && !validateApprove()){
				semmpt004Bean.setPopupClose(false);
				semmpt004Bean.setRenderedMsgFormSearch(false);
				semmpt004Bean.setRenderedMsgFormBottom(true);
				return flag;
			}
			
			semmpt004Bean.setPopupClose(true);
			semmpt004Bean.getMpt004Act().setRemark(semmpt004Bean.getRemark());
//			semmpt004Bean.getMpt004Act().setActionType(semmpt004Bean.getBtnApproveStatus());
		}else{
			btnStatus = (String)getFacesUtils().getRequestParameter("btnStatus");
			if(!StringUtils.isEmpty(semmpt004Bean.getBtnStatus())){
				btnStatus = semmpt004Bean.getBtnStatus();
			}
			semmpt004Bean.getMpt004Act().setRemark(null);
//			semmpt004Bean.getMpt004Act().setActionType(btnStatus);
		}
		
		
		if(btnStatus.equals("AG")){
			if(!validateSaveAct()){
				FrontMessageUtils.addMessageError(msg("message.totalDisbursement"));
				semmpt004Bean.setRenderedMsgFormSearch(false);
				semmpt004Bean.setRenderedMsgFormBottom(true);
				return flag;
			}
		}
		
		try{
			//concat rowId
			for(WrapperBeanObject<Mpt004Srch> mpt : semmpt004Bean.getMpt004SrchList()){
				Mpt004Srch mpt004Srch = (Mpt004Srch)mpt.getDataObj();
				if(mpt.isCheckBox() == true){
					tempPaymentGroup = mpt004Srch.getPaymentGroupNo();
				}else if(mpt004Srch.getPaymentGroupNo() != null && mpt004Srch.getPaymentGroupNo().equals(tempPaymentGroup)){
					mpt.setCheckBox(true);
				}
				if(mpt.isCheckBox() == true && rowsIdConcat.equals("")){
					rowsIdConcat = mpt004Srch.getRowId();
				}
				else if(mpt.isCheckBox() == true && !rowsIdConcat.equals("")){
					rowsIdConcat = rowsIdConcat+",".trim()+mpt004Srch.getRowId();
				}
			}
			
			semmpt004Bean.getMpt004Act().setRowId(rowsIdConcat);
			semmpt004Bean.getMpt004Act().setActionType(btnStatus);
			semmpt004Bean.getMpt004Act().setUserId(getUserLogIn());
			to = pTaxMasterService.querySPList(EQueryName.SP_MPT004_ACT.name, semmpt004Bean.getMpt004Act());
			if (to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")) {
				addMessageInfo("M0001");
			}else if(to != null && !to.isEmpty()){
				FrontMessageUtils.addMessageError(to.get(0).getpRemark());
			}
			semmpt004Bean.setRenderedMsgFormTop(false);
			semmpt004Bean.setRenderedMsgFormMiddle(true);
			semmpt004Bean.setBtnStatus("");
			setSemmpt004Bean(semmpt004Bean);
			doClearApproveStatus();
			doSearch();
		}catch (Exception e) {
			e.printStackTrace();
			semmpt004Bean.setRenderedMsgFormTop(true);
			semmpt004Bean.setRenderedMsgFormMiddle(false);
			addMessageError("E0001");
		}
		return flag;
	}
	
	private boolean validateApprove(){
		boolean flgValid = true;
		semmpt004Bean = getSemmpt004Bean();
		if(StringUtils.isEmpty(getSemmpt004Bean().getRemark())){
			FrontMessageUtils.addMessageError(
					SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("W0001"), msg("message.remark")));
			flgValid = false;
		}
		return flgValid;
	}
	
	private boolean validateSaveAct() {
		boolean flgValid = true;
		semmpt004Bean = getSemmpt004Bean();
		int i = 0;
		String vendorCode = "";
		String payeeId = "";
		for(WrapperBeanObject<Mpt004Srch> mpt : semmpt004Bean.getMpt004SrchList()){
			Mpt004Srch mpt004Srch = (Mpt004Srch)mpt.getDataObj();
			
			if(mpt.isCheckBox() && mpt.isCheckBox() == true && i==0){
				vendorCode = mpt004Srch.getVendorCode();
				payeeId = mpt004Srch.getPayeeId();
				i++;
			}
			if(mpt.isCheckBox() == true && !StringUtils.equals(vendorCode, mpt004Srch.getVendorCode()) 
			  || mpt.isCheckBox() == true && !StringUtils.equals(payeeId, mpt004Srch.getPayeeId())){
				
				flgValid = false;
				break;
			}
		}
		return flgValid;
	}
	
	public boolean initApprove(){
		boolean flag = false;
		String btnStatus = (String)getFacesUtils().getRequestParameter("btnStatus");
		semmpt004Bean = getSemmpt004Bean();
		semmpt004Bean.setBtnApproveStatus(btnStatus);
		setSemmpt004Bean(semmpt004Bean);
		return flag;
	}
	
	public boolean doClearApproveStatus(){
		boolean flag = false;
		semmpt004Bean = getSemmpt004Bean();
		semmpt004Bean.setBtnApproveStatus("");
		setSemmpt004Bean(semmpt004Bean);
		return flag;
	}
	
	public boolean initCoppyDate(){
		boolean flag = false;
		semmpt004Bean = getSemmpt004Bean();
		int i = 0;
		boolean second = false;
		Mpt004Srch mpTemp = null;
		for(WrapperBeanObject<Mpt004Srch> mpt : semmpt004Bean.getMpt004SrchList()){
			
			if(mpt.isCheckBox()){
				Mpt004Srch mpt004Srch = (Mpt004Srch)mpt.getDataObj();
				
				if(!second){
					if(mpt004Srch.getChqDt() == null && mpt004Srch.getChqReceiveDt() == null && mpt004Srch.getTransferDt() == null){
						addMessageError("W0086");
						break;
					}
					second = true;
				}
			
				if(mpTemp == null && mpt004Srch != null){
					mpTemp = mpt004Srch;
				}
				
				if(i != 0){
					if(mpt004Srch.getChqDt() != null || mpt004Srch.getChqReceiveDt() != null || mpt004Srch.getTransferDt() != null){
						semmpt004Bean.setPopupClose(true);
						semmpt004Bean.setPopupName("mdpConfirmCoppyDateDialog2");
						semmpt004Bean.setConfirmCoppyDateMsg(MSGCacheUtil.getInstance().getMessageByCode("Q0004"));
						break;
					}else{
						semmpt004Bean.setPopupClose(true);
						semmpt004Bean.setPopupName("mdpConfirmCoppyDateDialog1");
						semmpt004Bean.setConfirmCoppyDateMsg(MSGCacheUtil.getInstance().getMessageByCode("Q0003"));
					}
				}
				i++;
			}
		}		
		setSemmpt004Bean(semmpt004Bean);
		return flag;
	}
	
	public boolean doCoppyDate(){
		boolean flag = false;
		semmpt004Bean = getSemmpt004Bean();
		StringBuffer rentalpayNo = new StringBuffer();
		String confirmStatus = (String)getFacesUtils().getRequestParameter("confirmStatus");
		IPTaxPaymentService pTaxPaymentService = (IPTaxPaymentService)getBean("pTaxPaymentService");
		PtaxPayment tmpPtaxPayment = new PtaxPayment();
		Mpt004Srch tmp = new Mpt004Srch();
		boolean setTmp = true;
		String groupNoTmp = "";
		try{
			for(WrapperBeanObject<Mpt004Srch> mpt : semmpt004Bean.getMpt004SrchList()){
				Mpt004Srch mpt004Srch = (Mpt004Srch)mpt.getDataObj();
//				Mpt004Srch tmp = (Mpt004Srch)semmpt004Bean.getMpt004SrchList().get(0).getDataObj();
				if(mpt.isCheckBox() || StringUtils.equals(groupNoTmp, mpt004Srch.getPaymentGroupNo())){
					//Set tmp is first row select
					if(setTmp){ 
						tmp = mpt004Srch;
						setTmp = false;
					}
					if(confirmStatus.equals("Y")){
						log.debug("mpt004Srch.getRowId() = "+mpt004Srch.getRowId());
						tmpPtaxPayment = pTaxPaymentService.getPTaxPaymentByRowId(mpt004Srch.getRowId());
						log.debug("tmpPtaxPayment = "+tmpPtaxPayment);
						if(tmp.getChqDt() != null){
							tmpPtaxPayment.setChqDt(SEMDataUtility.convertToEnYear(tmp.getChqDt()));
						}
						
						if(tmp.getChqReceiveDt() != null){
							tmpPtaxPayment.setChqReceiveDt(SEMDataUtility.convertToEnYear(tmp.getChqReceiveDt()));
						}
						
						if(tmp.getTransferDt() != null){
							tmpPtaxPayment.setTransferDt(SEMDataUtility.convertToEnYear(tmp.getTransferDt()));
						}
						
						if(tmp.getPaymentMethod() != null){
							tmpPtaxPayment.setPaymentMethod(tmp.getPaymentMethod());
						}
						log.debug("tmpPtaxPayment.getChqDt() = "+tmpPtaxPayment.getChqDt());
						log.debug("tmpPtaxPayment.getChqReceiveDt() = "+tmpPtaxPayment.getChqReceiveDt());
						log.debug("tmpPtaxPayment.getTransferDt() = "+tmpPtaxPayment.getTransferDt());
						if("01".equals(tmpPtaxPayment.getPaymentStatus()) || "04".equals(tmpPtaxPayment.getPaymentStatus())){
							pTaxPaymentService.updatePtaxPayment(tmpPtaxPayment);
						}
						
						rentalpayNo.append(tmp.getRowId());
						rentalpayNo.append(",");
					}
					// field chqDt chqReceiveDt TransferDt all null
					if(confirmStatus.equals("N") && mpt004Srch.getChqDt() == null 
					   && mpt004Srch.getChqReceiveDt() == null 
					   && mpt004Srch.getTransferDt() == null){
						
						tmpPtaxPayment = pTaxPaymentService.getPTaxPaymentByRowId(mpt004Srch.getRowId());
						
						if(tmp.getChqDt() != null){
							tmpPtaxPayment.setChqDt(SEMDataUtility.convertToEnYear(tmp.getChqDt()));
						}
						
						if(tmp.getChqReceiveDt() != null){
							tmpPtaxPayment.setChqReceiveDt(SEMDataUtility.convertToEnYear(tmp.getChqReceiveDt()));
						}
						
						if(tmp.getTransferDt() != null){
							tmpPtaxPayment.setTransferDt(SEMDataUtility.convertToEnYear(tmp.getTransferDt()));
						}
						
						if(tmp.getPaymentMethod() != null){
							tmpPtaxPayment.setPaymentMethod(tmp.getPaymentMethod());
						}
						if("01".equals(tmpPtaxPayment.getPaymentStatus()) || "04".equals(tmpPtaxPayment.getPaymentStatus())){
							pTaxPaymentService.updatePtaxPayment(tmpPtaxPayment);
						}
						rentalpayNo.append(tmp.getRowId());
						rentalpayNo.append(",");
					}
					if(StringUtils.isNotEmpty(mpt004Srch.getPaymentGroupNo())){
						groupNoTmp = mpt004Srch.getPaymentGroupNo();
					}
				}
			}
			setSemmpt004Bean(semmpt004Bean);
			doSearch();
		}catch (Exception e) {
			e.printStackTrace();
			addMessageError("E0001");
		}				
		if(rentalpayNo.length() != 0){
			showErrorMsgValidateCopy(rentalpayNo.substring(0,rentalpayNo.length()-1).toString());
		}
		return flag;
	}
	
	private void showErrorMsgValidateCopy(String rentalPatNo){
		IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
		semmpt004Bean = getSemmpt004Bean();
		try {
			Mrt003ChkVendorMulti checkVendorMulti =  new Mrt003ChkVendorMulti();
			checkVendorMulti.setRentalPaymentId(rentalPatNo);
			List list = rentalPaymentService.querySPList(EQueryName.SP_CHK_VENDOR_MULTI.name, checkVendorMulti);
			if(list != null && list.size() > 0){
				if((Mrt003ChkVendorMulti)list.get(0) != null){
					String msg = ((Mrt003ChkVendorMulti)list.get(0)).getMsgWarning();
					semmpt004Bean.setRenderedMsgFormBottom(true);
					semmpt004Bean.setRenderedMsgFormTop(false);
					addGeneralMessageError(msg);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmpt004Bean(semmpt004Bean);
	}
	
	public boolean pageLoad(){
		boolean flag = true;
		String mode = (String)getFacesUtils().getRequestParameter("mode");
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");

		semmpt004Bean = getSemmpt004Bean();
		popupSiteContractAntCriBean = getPopupSiteContractAntCriBean();
		IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
		List<Mpt004SrchD> to = null;
		semmpt004Bean.getMpt004SrchD().setRowId(rowId);
		semmpt004Bean.setRenderContractNo(false);
		semmpt004Bean.setDisablePtaxYear(false);
		defaultRenderedMsgPanel();
		try{
			if(mode.equals("VIEW") || mode.equals("EDIT")){

				log.debug("mode = "+mode);
				
				to = pTaxMasterService.querySPList(EQueryName.SP_MPT004_SRCH_D.name, semmpt004Bean.getMpt004SrchD());
				if(to != null && to.size() != 0){	
					if(to.get(0).getPayGovtFlag().equals("Y")){
						semmpt004Bean.setChkPayGovtFlag(true);
						semmpt004Bean.setRenderLinkPayGovtFlag(true);
					}else{
						semmpt004Bean.setChkPayGovtFlag(false);
						semmpt004Bean.setRenderLinkPayGovtFlag(false);
					}
					
					if(to.get(0).getPaymentType().equals("01")){
						log.debug("PaymentType = "+to.get(0).getPaymentType());
						semmpt004Bean.setRenderCldTransferDt(true);
						semmpt004Bean.setRenderCldChqDt(false);
						semmpt004Bean.setRenderCldChqReceiveDt(false);
						semmpt004Bean.setPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name, EX_IN, "CHEQUE", null, null));
					}
					if(to.get(0).getPaymentType().equals("02")){
						log.debug("PaymentType = "+to.get(0).getPaymentType());
						semmpt004Bean.setRenderCldChqDt(true);
						semmpt004Bean.setRenderCldTransferDt(false);
						semmpt004Bean.setRenderCldChqReceiveDt(false);
						semmpt004Bean.setPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name, EX_IN, "TRANSFER", null, null));
					}
					
					if(mode.equals("EDIT")){
						semmpt004Bean.setRenderContractNo(true);
					}
					semmpt004Bean.setDisablePtaxYear(false);
					if(to.get(0).getPtaxStatus().equals("01") || to.get(0).getPtaxStatus().equals("02")){
						semmpt004Bean.setDisablePtaxYear(true);
					}
					
					//get excAmt vatAmt whtAmt add bean Because validate + - 1
					semmpt004Bean.setOldExcAmt(to.get(0).getExcAmt());
					semmpt004Bean.setOldVatAmt(to.get(0).getVatAmt());
					semmpt004Bean.setOldWhtAmt(to.get(0).getWhtAmt());
					semmpt004Bean.setOldIncAmt(to.get(0).getIncAmt());
					semmpt004Bean.setOldchqAmt(to.get(0).getChqAmt());
					
					popupSiteContractAntCriBean.setContractNo(to.get(0).getContractNo());
					semmpt004Bean.setMpt004SrchD(to.get(0));
					
					if(StringUtils.isEmpty(to.get(0).getDocType())){
						if(semmpt004Bean.isChkPayGovtFlag()){
							semmpt004Bean.getMpt004SrchD().setDocType("05");
						}else{
							semmpt004Bean.getMpt004SrchD().setDocType("01");
						}
					}
				}
				semmpt004Bean.setMpt004SrchDList(to);
			}
			if(mode.equals("ADD")){
				//mode Add
				doDefaultCreateby();
			}
			semmpt004Bean.setRenderCldChqDt(false);
			semmpt004Bean.setRenderCldChqReceiveDt(false);
			semmpt004Bean.setRenderCldTransferDt(false);
			semmpt004Bean.setRenderdateFrom(false);
			
			//setDefault periodNo defualtMonthFrom defaultMonthTo
			if(semmpt004Bean.getMpt004SrchD().getPeriodNo() == null){
				semmpt004Bean.getMpt004SrchD().setPeriodNo("1");
			}
			if(StringUtils.isEmpty(semmpt004Bean.getMpt004SrchD().getMonthFrom()) || semmpt004Bean.getMpt004SrchD().getMonthFrom() == null){
				semmpt004Bean.getMpt004SrchD().setMonthFrom("01");
			}
			if(StringUtils.isEmpty(semmpt004Bean.getMpt004SrchD().getMonthTo()) || semmpt004Bean.getMpt004SrchD().getMonthTo() == null){
				semmpt004Bean.getMpt004SrchD().setMonthTo("12");
			}
			if(StringUtils.isEmpty(semmpt004Bean.getMpt004SrchD().getPeriodType()) || semmpt004Bean.getMpt004SrchD().getPeriodType() == null){
				semmpt004Bean.getMpt004SrchD().setPeriodType("05");
				semmpt004Bean.setPayPeriodType02("05");
			}
			semmpt004Bean.setRenderedBtnSave(false);
			semmpt004Bean.getMpt004SrchD().setMonthFrom("01");
			if(StringUtils.isEmpty(semmpt004Bean.getMpt004SrchD().getVatType())){
				semmpt004Bean.getMpt004SrchD().setVatType("03");
			}
			if(StringUtils.isEmpty(semmpt004Bean.getMpt004SrchD().getWhtType())){
				semmpt004Bean.getMpt004SrchD().setWhtType("03");
			}
			
			setSemmpt004Bean(semmpt004Bean);
			renderPayPeriodType();
			onRenderWhtRate();
			onrenderPaymentType();
			onRenderWhtRate();
			onRenderExpenseType();

			semmpt004Bean.setMsgTop(true);
			semmpt004Bean.setPnlPayInfo(false);
			semmpt004Bean.setPnlPayment(false);
			setSemmpt004Bean(semmpt004Bean);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public void defaultRenderedMsgPanel(){
		semmpt004Bean = getSemmpt004Bean();
		semmpt004Bean.setMsgTop(true);
		semmpt004Bean.setPnlContractInfo(false);
		semmpt004Bean.setPnlDetailPay(false);
		semmpt004Bean.setPnlPayInfo(false);
		semmpt004Bean.setPnlPayment(false);
		setSemmpt004Bean(semmpt004Bean);
	}
	
	public void onrenderPaymentType(){
		semmpt004Bean = getSemmpt004Bean();
		String test = (String)semmpt004Bean.getMpt004SrchD().getPaymentType();		

		log.debug("onrenderPaymentType PaymentType= "+test);
		
		if(StringUtils.isEmpty(semmpt004Bean.getMpt004SrchD().getPaymentType())){
			semmpt004Bean.setRenderCldTransferDt(true);
			semmpt004Bean.setRenderCldChqDt(true);
			semmpt004Bean.setRenderCldChqReceiveDt(true);
			semmpt004Bean.setRenderedPaymentMethod(true);
			semmpt004Bean.getMpt004SrchD().setPaymentMethod("");
			
		}
		if(semmpt004Bean.getMpt004SrchD().getPaymentType() != null && semmpt004Bean.getMpt004SrchD().getPaymentType().equals("01")){
			semmpt004Bean.setRenderCldTransferDt(true);
			semmpt004Bean.setRenderCldChqDt(false);
			semmpt004Bean.setRenderCldChqReceiveDt(false);
			semmpt004Bean.setRenderedPaymentMethod(false);
			List<SelectItem> paymentMethodList = getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name,EX_AND,"CHEQUE",null,null);
			semmpt004Bean.setPaymentMethodList(paymentMethodList);
			semmpt004Bean.getMpt004SrchD().setTransferDt(null);
			semmpt004Bean.getMpt004SrchD().setPaymentMethod(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.CT_PAYMENT_METHOD));
		}
		if(semmpt004Bean.getMpt004SrchD().getPaymentType() != null && semmpt004Bean.getMpt004SrchD().getPaymentType().equals("02")){
			semmpt004Bean.setRenderCldChqDt(true);
			semmpt004Bean.setRenderCldChqReceiveDt(true);
			semmpt004Bean.setRenderCldTransferDt(false);
			semmpt004Bean.setRenderedPaymentMethod(false);
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
			semmpt004Bean.getMpt004SrchD().setChqDt(null);
			semmpt004Bean.getMpt004SrchD().setChqReceiveDt(null);
			semmpt004Bean.setPaymentMethodList(selectList);
			
			//semmpt004Bean.getMpt004SrchD().setPaymentMethod("02");
		}
		if(semmpt004Bean.getMpt004SrchD().getPaymentType() != null && semmpt004Bean.getMpt004SrchD().getPaymentType().equals("03")){
			semmpt004Bean.setRenderCldChqDt(true);
			semmpt004Bean.setRenderCldChqReceiveDt(true);
			semmpt004Bean.setRenderCldTransferDt(false);
			semmpt004Bean.setRenderedPaymentMethod(false);
			
			// prepare paymentMethodList
			List<SelectItem> paymentMethodList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
			List<SelectItem> selectList = new ArrayList<SelectItem>();
//			
			for(SelectItem selectItem : paymentMethodList){
				
				if (StringUtils.equalsIgnoreCase("P", selectItem.getDescription())){
					selectList.add(selectItem);
				}
			
			}
//			semmpt004Bean.getMpt004SrchD().setTransferDt(null);
			semmpt004Bean.getMpt004SrchD().setChqDt(null);
			semmpt004Bean.getMpt004SrchD().setChqReceiveDt(null);
			semmpt004Bean.setPaymentMethodList(selectList);
			
			//semmpt004Bean.getMpt004SrchD().setPaymentMethod("05");
		}
//		semmpt004Bean.setMsgTop(false);
//		semmpt004Bean.setPnlPayInfo(false);
//		semmpt004Bean.setPnlPayment(true);
		setSemmpt004Bean(semmpt004Bean);
	}
	
	private SEMMPT002Bean semmpt002Bean;
	
	public SEMMPT002Bean getSemmpt002Bean() {
		return (SEMMPT002Bean)getFacesUtils().getSessionMapValue("semmpt002Bean");
	}

	public void setSemmct002Bean(SEMMPT002Bean semmpt002Bean) {
		this.semmpt002Bean = semmpt002Bean;
		getFacesUtils().setSessionMapValue("semmpt002Bean", semmpt002Bean);
	}
	
	public boolean doShow(){
		boolean flag = false;
		semmpt002Bean = getSemmpt002Bean();
		semmpt004Bean = getSemmpt004Bean();
		semmpt002Bean.setMpt002SrchHist(new Mpt002SrchHist());
		IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
		semmpt002Bean.getMpt002SrchHist().setContractNo(semmpt004Bean.getMpt004SrchD().getContractNo());
		if(semmpt004Bean.getMpt004SrchD().getDocType().equals("01")){
			semmpt004Bean.setRequireDocVat(true);
		}
		List<Mpt002SrchHist> to = null;
		try {
			to = pTaxMasterService.querySPList(EQueryName.SP_MPT002_SRCH_HIST.name, semmpt002Bean.getMpt002SrchHist());
			if(to == null || to.isEmpty()){
				addMessageWarn(("M0004"));
				semmpt002Bean.setPopupClose(false);
			}else{
				for(Mpt002SrchHist mp : to){
					if(mp.getEstimateDt() != null){
						mp.setEstimateDt(SEMDataUtility.convertToThYear(mp.getEstimateDt()));
					}
					if(mp.getPaymentDt() != null){
						mp.setPaymentDt(SEMDataUtility.convertToThYear(mp.getPaymentDt()));
					}
					if(mp.getpTaxYear()!=null){
						mp.setpTaxYear(mp.getpTaxYear()+543);
					}
				}
				semmpt002Bean.setPopupClose(true);
			}
			semmpt002Bean.setMpt002SrchHistList(to);
			setSemmct002Bean(semmpt002Bean);
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError(("E0003"));
			semmpt002Bean.setPopupClose(false);
		}
		return flag;
	}
	
	public boolean doSave(){
		boolean flag = false;
		semmpt004Bean = getSemmpt004Bean();
		//Validate Require Field On JSP Page 
		if(!validateSave()){
			getSemmpt004Bean().setMsgTop(true);
			getSemmpt004Bean().setPnlPayInfo(false);
			getSemmpt004Bean().setPnlPayment(false);
			return flag;
		}
		// Validate PTaxPayType Before Save
		if(!validatePtaxPayType()){
			semmpt004Bean.isRenderedBtnSave();
			return flag;
		}
		
		onRenderCheckBeforeSave();
		if(semmpt004Bean.getMpt004Chk().getResultMsg().equals("Fail")){
			return flag;
		}
		
		IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
		List<Mpt004Edt> to = null;
		List<Mpt004SrchD> to2 = null;
		
		//add parameter before Save
		semmpt004Bean.setMpt004Edt(new Mpt004Edt());
		semmpt004Bean.getMpt004Edt().setPtaxPaymentId(semmpt004Bean.getMpt004SrchD().getRowId());
		semmpt004Bean.getMpt004Edt().setContractNo(popupSiteContractAntCriBean.getContractNo());
		semmpt004Bean.getMpt004Edt().setpTaxYear(Integer.parseInt(semmpt004Bean.getMpt004SrchD().getpTaxYear()));
		semmpt004Bean.getMpt004Edt().setExpenseType(semmpt004Bean.getMpt004SrchD().getExpenseType());
		semmpt004Bean.getMpt004Edt().setPeriodNo(semmpt004Bean.getMpt004SrchD().getPeriodNo());
		semmpt004Bean.getMpt004Edt().setMonthFrom(semmpt004Bean.getMpt004SrchD().getMonthFrom());
		semmpt004Bean.getMpt004Edt().setMonthTo(semmpt004Bean.getMpt004SrchD().getMonthTo());
		semmpt004Bean.getMpt004Edt().setPeriodType(semmpt004Bean.getMpt004SrchD().getPeriodType());
		semmpt004Bean.getMpt004Edt().setPeriodInterval(semmpt004Bean.getMpt004SrchD().getPeriodInterval());
		semmpt004Bean.getMpt004Edt().setDocType(semmpt004Bean.getMpt004SrchD().getDocType());
		semmpt004Bean.getMpt004Edt().setPenaltyType(semmpt004Bean.getMpt004SrchD().getPenaltyType());
		semmpt004Bean.getMpt004Edt().setDocNo(semmpt004Bean.getMpt004SrchD().getDocNo());
		semmpt004Bean.getMpt004Edt().setDocDt(semmpt004Bean.getMpt004SrchD().getDocDt());
		semmpt004Bean.getMpt004Edt().setpTaxPayType(semmpt004Bean.getMpt004SrchD().getpTaxPayType());
		semmpt004Bean.getMpt004Edt().setPayGovtFlag(semmpt004Bean.getMpt004SrchD().getPayGovtFlag());
		semmpt004Bean.getMpt004Edt().setVendorCode(semmpt004Bean.getMpt004SrchD().getVendorCode());
		semmpt004Bean.getMpt004Edt().setPayeeId(semmpt004Bean.getMpt004SrchD().getPayeeId());
		semmpt004Bean.getMpt004Edt().setEstmAmt(semmpt004Bean.getMpt004SrchD().getEstmAmt());
		semmpt004Bean.getMpt004Edt().setpTaxAmt(semmpt004Bean.getMpt004SrchD().getpTaxAmt());
		semmpt004Bean.getMpt004Edt().setTotalAmt(semmpt004Bean.getMpt004SrchD().getTotalAmt());
		semmpt004Bean.getMpt004Edt().setVatType(semmpt004Bean.getMpt004SrchD().getVatType());
		semmpt004Bean.getMpt004Edt().setWhtType(semmpt004Bean.getMpt004SrchD().getWhtType());
		semmpt004Bean.getMpt004Edt().setWhtRate(semmpt004Bean.getMpt004SrchD().getWhtRate());
		semmpt004Bean.getMpt004Edt().setExcAmt(semmpt004Bean.getMpt004SrchD().getExcAmt());
		semmpt004Bean.getMpt004Edt().setVatAmt(semmpt004Bean.getMpt004SrchD().getVatAmt());
		semmpt004Bean.getMpt004Edt().setIncAmt(semmpt004Bean.getMpt004SrchD().getIncAmt());
		semmpt004Bean.getMpt004Edt().setWhtAmt(semmpt004Bean.getMpt004SrchD().getWhtAmt());
		semmpt004Bean.getMpt004Edt().setChqAmt(semmpt004Bean.getMpt004SrchD().getChqAmt());
		semmpt004Bean.getMpt004Edt().setDiffRemark(semmpt004Bean.getMpt004SrchD().getDiffRemark());
//		semmpt004Bean.getMpt004Edt().setPaymentType("01");
//		semmpt004Bean.getMpt004Edt().setPaymentMethod("03");
		semmpt004Bean.getMpt004Edt().setPaymentType(semmpt004Bean.getMpt004SrchD().getPaymentType());
		semmpt004Bean.getMpt004Edt().setPaymentMethod(semmpt004Bean.getMpt004SrchD().getPaymentMethod());
		semmpt004Bean.getMpt004Edt().setChqDt(semmpt004Bean.getMpt004SrchD().getChqDt());
		semmpt004Bean.getMpt004Edt().setChqReceiveDt(semmpt004Bean.getMpt004SrchD().getChqReceiveDt());
		semmpt004Bean.getMpt004Edt().setTransferDt(semmpt004Bean.getMpt004SrchD().getTransferDt());
		semmpt004Bean.getMpt004Edt().setRemark(semmpt004Bean.getMpt004SrchD().getRemark());
		semmpt004Bean.getMpt004Edt().setUserId(getUserLogIn());
		try {
			to = pTaxMasterService.querySPList(EQueryName.SP_MPT004_EDT.name, semmpt004Bean.getMpt004Edt());
			if (to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")) {
				addMessageInfo("M0001");
			}else if(to != null && !to.isEmpty()){
				FrontMessageUtils.addMessageError(to.get(0).getpRemark());
			}
			
			semmpt004Bean.getMpt004SrchD().setRowId(to.get(0).getPtaxPaymentId());
			to2 = pTaxMasterService.querySPList(EQueryName.SP_MPT004_SRCH_D.name, semmpt004Bean.getMpt004SrchD());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			addMessageError("E0001");
		}
//		semmpt004Bean.setMpt004SrchD(to2.get(0));
		setSemmpt004Bean(semmpt004Bean);
		tmpFlagValidate = "N";
		doSearch();
		getSemmpt004Bean().setMsgTop(true);
		getSemmpt004Bean().setPnlPayInfo(false);
		getSemmpt004Bean().setPnlPayment(false);
		
		return flag;
	}
	
	private boolean validateSearch(){
		boolean flagValid = true;
		Integer pTaxYearFrom = 0;
		Integer pTaxYearTo = 0;
		Integer periodNoFrom = 0;
		Integer periodNoTo = 0;
		if(StringUtils.isEmpty(getSemmpt004Bean().getMpt004Srch().getpTaxYearFrom())){
			getSemmpt004Bean().getMpt004Srch().setpTaxYearFrom(null);
		}else{
			pTaxYearFrom = new Integer(getSemmpt004Bean().getMpt004Srch().getpTaxYearFrom());
		}
		if(StringUtils.isEmpty(getSemmpt004Bean().getMpt004Srch().getpTaxYearTo())){
			getSemmpt004Bean().getMpt004Srch().setpTaxYearTo(null);
		}else{
			pTaxYearTo = new Integer(getSemmpt004Bean().getMpt004Srch().getpTaxYearTo());
		}
		if(StringUtils.isEmpty(getSemmpt004Bean().getMpt004Srch().getPeriodNoFrom())){
			getSemmpt004Bean().getMpt004Srch().setPeriodNoFrom(null);
		}else{
			periodNoFrom = new Integer(getSemmpt004Bean().getMpt004Srch().getPeriodNoFrom());
		}
		if(StringUtils.isEmpty(getSemmpt004Bean().getMpt004Srch().getPeriodNoTo())){
			getSemmpt004Bean().getMpt004Srch().setPeriodNoTo(null);
		}else{
			periodNoTo = new Integer(getSemmpt004Bean().getMpt004Srch().getPeriodNoTo());
		}
		
		if(StringUtils.isEmpty(getSemmpt004Bean().getMpt004Srch().getContractNo())){
			if(StringUtils.isEmpty(getSemmpt004Bean().getMpt004Srch().getCompany())){
				addMessageError("W0001",msg("message.company"));
				flagValid = false;
			}
		}
		
		if(pTaxYearTo < pTaxYearFrom){
			addMessageErrorWithArgument("W0006", ("To")  ,msg("massage.pTaxYearFrom"));
			flagValid = false;
		}
		
		if(periodNoTo < periodNoFrom){
			addMessageErrorWithArgument("W0006", ("To")  ,msg("message.propertyPeriodNoFrom"));
			flagValid = false;
		}
		
		return flagValid;
	}
	
	private boolean validatePtaxPayType(){
		boolean flagValid = true;
		try{
			if(getSemmpt004Bean().getMpt004SrchD().getpTaxPayType() != null && !getSemmpt004Bean().getMpt004SrchD().getpTaxPayType().isEmpty()){
				if(getSemmpt004Bean().getMpt004SrchD().getpTaxPayType().equals("03") && 
						   getSemmpt004Bean().getMpt004SrchD().getDocType().equals("05") &&
						   getSemmpt004Bean().getMpt004SrchD().getDocType().equals("06")){
					addMessageError("W0020");
					flagValid = false;
				}
				if(getSemmpt004Bean().getMpt004SrchD().getpTaxPayType().equals("02")){
					addMessageError("W0018");
					flagValid = false;
				}
				if(getSemmpt004Bean().getMpt004SrchD().getpTaxPayType().equals("00")){
					addMessageError("W0019");
					flagValid = false;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			addMessageError("E0001");
			// TODO: handle exception
		}
		
		return flagValid;
	}
	
	private boolean validateSave(){
		boolean flagValid = true;
		Date chqDt = getSemmpt004Bean().getMpt004SrchD().getChqDt();
		Date chqReceiveDt = getSemmpt004Bean().getMpt004SrchD().getChqReceiveDt();
		Date transferDt = getSemmpt004Bean().getMpt004SrchD().getTransferDt();
		popupSiteContractAntCriBean = getPopupSiteContractAntCriBean();
		
		try{
		if("15".equals(getSemmpt004Bean().getMpt004SrchD().getExpenseType()) && 
		   StringUtils.isEmpty(getSemmpt004Bean().getMpt004SrchD().getPenaltyType())){
			addMessageError(("W0001"), msg("message.penaltyType"));
			flagValid = false;
		}
		getSemmpt004Bean().getMpt004SrchD().setContractNo(popupSiteContractAntCriBean.getContractNo());
		if(StringUtils.isEmpty(getSemmpt004Bean().getMpt004SrchD().getContractNo())){
			addMessageError(("W0001"), msg("message.contractNo"));
			flagValid = false;
		}
		if(StringUtils.isEmpty(getSemmpt004Bean().getMpt004SrchD().getpTaxYear())){
			addMessageError(("W0001"), msg("message.pTaxYear"));
			flagValid = false;
		}
		if(StringUtils.isEmpty(getSemmpt004Bean().getMpt004SrchD().getExpenseType())){
			addMessageError(("W0001"), msg("message.expenseType"));
			flagValid = false;
		}
		if(getSemmpt004Bean().getMpt004SrchD().getPeriodNo() == null){
			addMessageError(("W0001"), msg("message.periodNo"));
			flagValid = false;
		}
		if(getSemmpt004Bean().isDisableMonthFrom() == false && StringUtils.isEmpty(getSemmpt004Bean().getMpt004SrchD().getMonthFrom())){
			addMessageError(("W0001"), msg("message.pTaxAmt"));
			flagValid = false;
		}
		if(StringUtils.isEmpty(getSemmpt004Bean().getMpt004SrchD().getPeriodType())){
			addMessageError(("W0001"), msg("messege.periodType"));
			flagValid = false;
		}
		if(StringUtils.isEmpty(getSemmpt004Bean().getMpt004SrchD().getDocType())){
			addMessageError(("W0001"), msg("message.docType"));
			flagValid = false;
		}
		if(getSemmpt004Bean().isRequireDocVat()){
			if(StringUtils.isEmpty(getSemmpt004Bean().getMpt004SrchD().getDocNo())){
				addMessageError(("W0001"), msg("message.propertyTaxDocNo"));
				flagValid = false;
			}
		
		
			if(getSemmpt004Bean().getMpt004SrchD().getDocNo() == null){
				addMessageError(("W0001"), msg("message.propertyDocDt"));
				flagValid = false;
			}
		}
		if(getSemmpt004Bean().getMpt004SrchD().getTotalAmt() == null){
			addMessageError(("W0001"), msg("message.totalAmt"));
			flagValid = false;
		}
		if(getSemmpt004Bean().getMpt004SrchD().getExcAmt() == null){
			addMessageError(("W0001"), msg("message.excAmt"));
			flagValid = false;
		}
		if(StringUtils.isEmpty(getSemmpt004Bean().getMpt004SrchD().getPaymentType())){
			addMessageError(("W0001"), msg("message.paymentType"));
			flagValid = false;
		}
		if(StringUtils.isEmpty(getSemmpt004Bean().getMpt004SrchD().getPaymentMethod())){
			addMessageError(("W0001"), msg("message.paymentMethod"));
			flagValid = false;
		}
		
//		try{
			if(getSemmpt004Bean().getMpt004SrchD().getChqDt() == null){
				if(getSemmpt004Bean().isRenderCldChqDt() == false){
				 addMessageError(("W0001"), msg("message.chqDt"));
				 flagValid = false;
				}
			}
			else{
				if(SEMDataUtility.getCurrentDateByPattern().compareTo(chqDt) > 0){
					addGeneralMessageError("ChqDt Before Today Date");
					flagValid = false;
				}
			}
			if(getSemmpt004Bean().getMpt004SrchD().getChqReceiveDt() == null){ 
				if(getSemmpt004Bean().isRenderCldChqDt() == false){
				 addMessageError(("W0001"), msg("message.chqReceiveDt"));
				 flagValid = false;
				}
			}
			else{
				if(SEMDataUtility.getCurrentDateByPattern().compareTo(chqReceiveDt) > 0){
					addGeneralMessageError("ChqReceiveDt Before Today Date");
					flagValid = false;
				}
			}
			if(getSemmpt004Bean().getMpt004SrchD().getTransferDt() == null ){
				if(getSemmpt004Bean().isRenderCldTransferDt() == false){
				 addMessageError(("W0001"), msg("message.transferDt"));
				 flagValid = false;
				}
			}
			else{
				if(SEMDataUtility.getCurrentDateByPattern().compareTo(transferDt) > 0){
					addGeneralMessageError("TransferDt Before Today Date");
					flagValid = false;
				}
			}
		}catch (Exception e) {
			addMessageError("E0001");
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return flagValid;
	}
	
	public void renderPayPeriodType(){
		semmpt004Bean = getSemmpt004Bean();
		semmpt004Bean.setRenderdateFrom(false);
		String payPeriodType = (String)getFacesUtils().getRequestParameter("payPeriodType");
		semmpt004Bean.setDisableMonth(true);
		semmpt004Bean.setDisableYear(true);
		semmpt004Bean.setDisableMonthFrom(true);
		if(StringUtils.isEmpty(semmpt004Bean.getMpt004SrchD().getPeriodType())){
			payPeriodType = semmpt004Bean.getPayPeriodType05();
		}
		
		if(!StringUtils.isEmpty(semmpt004Bean.getMpt004SrchD().getPeriodType()) && payPeriodType == null){
			payPeriodType = semmpt004Bean.getMpt004SrchD().getPeriodType();
		}
		
		if(!StringUtils.isEmpty(payPeriodType) && payPeriodType.equals("01")){
			semmpt004Bean.setPayPeriodType02("");
			semmpt004Bean.setPayPeriodType03("");
			semmpt004Bean.setPayPeriodType04("");
			semmpt004Bean.setPayPeriodType05("");
			semmpt004Bean.setPayPeriod03("");
			semmpt004Bean.setPayPeriod04("");
			semmpt004Bean.setPayPeriodType01("01");
			semmpt004Bean.getMpt004SrchD().setPeriodType("01");
			semmpt004Bean.setDisableMonthFrom(false);
		}
		if(!StringUtils.isEmpty(payPeriodType) && payPeriodType.equals("02")){
			semmpt004Bean.setPayPeriodType01("");
			semmpt004Bean.setPayPeriodType03("");
			semmpt004Bean.setPayPeriodType04("");
			semmpt004Bean.setPayPeriodType05("");
			semmpt004Bean.setPayPeriod03("");
			semmpt004Bean.setPayPeriod04("");
			semmpt004Bean.setPayPeriodType02("02");
			semmpt004Bean.getMpt004SrchD().setPeriodType("02");
			semmpt004Bean.getMpt004SrchD().setMonthFrom("");
		}
		if(!StringUtils.isEmpty(payPeriodType) && payPeriodType.equals("03")){
			semmpt004Bean.setPayPeriodType01("");
			semmpt004Bean.setPayPeriodType02("");
			semmpt004Bean.setPayPeriodType04("");
			semmpt004Bean.setPayPeriodType05("");
			semmpt004Bean.setPayPeriod04("");
			semmpt004Bean.setPayPeriodType03("03");
			semmpt004Bean.setDisableMonth(false);
			semmpt004Bean.getMpt004SrchD().setPeriodType("03");
			semmpt004Bean.setDisableMonthFrom(false);
		}
		if(!StringUtils.isEmpty(payPeriodType) && payPeriodType.equals("04")){
//			semmpt004Bean.getRentCondNormal().setPayPeriod(semmpt004Bean.getPayPeriod04());
			semmpt004Bean.setPayPeriodType01("");
			semmpt004Bean.setPayPeriodType02("");
			semmpt004Bean.setPayPeriodType03("");
			semmpt004Bean.setPayPeriodType05("");
			semmpt004Bean.setPayPeriod03("");
			semmpt004Bean.setPayPeriodType04("04");
			semmpt004Bean.getMpt004SrchD().setPeriodType("04");
			semmpt004Bean.setDisableYear(false);
			semmpt004Bean.getMpt004SrchD().setMonthFrom("");
		}
		if(!StringUtils.isEmpty(payPeriodType) && payPeriodType.equals("05")){
			semmpt004Bean.setPayPeriodType01("");
			semmpt004Bean.setPayPeriodType02("");
			semmpt004Bean.setPayPeriodType03("");
			semmpt004Bean.setPayPeriodType04("");
			semmpt004Bean.setPayPeriod03("");
			semmpt004Bean.setPayPeriod04("");
			semmpt004Bean.setPayPeriodType05("05");
			semmpt004Bean.getMpt004SrchD().setPeriodType("05");
			semmpt004Bean.setRenderdateFrom(true);
			semmpt004Bean.getMpt004SrchD().setMonthFrom("");
		}
		
		setSemmpt004Bean(semmpt004Bean);
	}
	
	public boolean doBack(){
		boolean flag = true;
		semmpt004Bean = getSemmpt004Bean();
		popupSiteContractAntCriBean = getPopupSiteContractAntCriBean();
		semmpt004Bean.setMpt004SrchD(new Mpt004SrchD());
		semmpt004Bean.setMpt004SrchDList(new ArrayList());
		semmpt004Bean.setPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name));
		semmpt004Bean.setPayPeriodType01("");
		semmpt004Bean.setPayPeriodType02("");
		semmpt004Bean.setPayPeriodType03("");
		semmpt004Bean.setPayPeriodType04("");
		semmpt004Bean.setPayPeriodType05("");
		popupSiteContractAntCriBean.setContractNo(null);
		semmpt004Bean.setRenderdateFrom(false);
		setPopupSiteContractAntCriBean(popupSiteContractAntCriBean);
		semmpt004Bean.setChkPayGovtFlag(false);
		semmpt004Bean.setRenderLinkPayGovtFlag(false);
		semmpt004Bean.getMpt004Srch().setPaymentStatus("01");
		setSemmpt004Bean(semmpt004Bean);
		tmpFlagValidate = "Y";
		doSearch();
		return flag;
	}
	
	public void onRenderAmount(){
		log.debug("### START SEMMPT004Action onRenderAmount ###");
		semmpt004Bean = getSemmpt004Bean();
		IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
		List<Mpt004Cal> to = null;
		onRenderWhtRate();
		
		log.debug("getWhtType = "+semmpt004Bean.getMpt004SrchD().getWhtType());
		if("01".equals(semmpt004Bean.getMpt004SrchD().getWhtType()) || "02".equals(semmpt004Bean.getMpt004SrchD().getWhtType())){
			if (semmpt004Bean.isChangeWhtRateFlag()){
				semmpt004Bean.getMpt004SrchD().setWhtRate(semmpt004Bean.getMpt004SrchD().getWhtRate());
				log.debug("getWhtRate := "+semmpt004Bean.getMpt004SrchD().getWhtRate());
//				semmpt004Bean.setChangeWhtRateFlag(false);
			}else {
				semmpt004Bean.getMpt004SrchD().setWhtRate(5D);
			}
		}else if("03".equals(semmpt004Bean.getMpt004SrchD().getWhtType())){
			semmpt004Bean.setChangeWhtRateFlag(false);
		}
		// check Estmamt don't null
		if(semmpt004Bean.getMpt004SrchD().getEstmAmt() == null){
			semmpt004Bean.getMpt004SrchD().setEstmAmt(0.00);
		}
		if(semmpt004Bean.getMpt004SrchD().getWhtRate() == null){
			semmpt004Bean.getMpt004SrchD().setWhtRate(0.00);
		}
		
		//check 
		if(!StringUtils.isEmpty(semmpt004Bean.getMpt004SrchD().getVatType()) && !StringUtils.isEmpty(semmpt004Bean.getMpt004SrchD().getWhtType())){
			if(semmpt004Bean.getMpt004SrchD().getTotalAmt() != null){
				
			//set value to mpt004Cal
				semmpt004Bean.getMpt004Cal().setTotalAmt(semmpt004Bean.getMpt004SrchD().getTotalAmt());
				semmpt004Bean.getMpt004Cal().setVatType(semmpt004Bean.getMpt004SrchD().getVatType());
				semmpt004Bean.getMpt004Cal().setWhtType(semmpt004Bean.getMpt004SrchD().getWhtType());
				semmpt004Bean.getMpt004Cal().setWhtRate(semmpt004Bean.getMpt004SrchD().getWhtRate());
				semmpt004Bean.getMpt004Cal().setEstmAmt(semmpt004Bean.getMpt004SrchD().getEstmAmt());
				try {
					to = pTaxMasterService.querySPList(EQueryName.SP_MPT004_CAL.name, semmpt004Bean.getMpt004Cal());
					if (to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")) {
						semmpt004Bean.getMpt004SrchD().setExcAmt(to.get(0).getExcAmt());
						semmpt004Bean.getMpt004SrchD().setVatAmt(to.get(0).getVatAmt());
						semmpt004Bean.getMpt004SrchD().setIncAmt(to.get(0).getIncAmt());
						semmpt004Bean.getMpt004SrchD().setWhtAmt(to.get(0).getWhtAmt());
						semmpt004Bean.getMpt004SrchD().setChqAmt(to.get(0).getChqAmt());
						semmpt004Bean.getMpt004SrchD().setDiffAmt(to.get(0).getDiffAmt());
						
						//get excAmt vatAmt whtAmt add bean Because validate + - 1
						semmpt004Bean.setOldExcAmt(to.get(0).getExcAmt());
						semmpt004Bean.setOldVatAmt(to.get(0).getVatAmt());
						semmpt004Bean.setOldWhtAmt(to.get(0).getWhtAmt());
						semmpt004Bean.setOldIncAmt(to.get(0).getIncAmt());
						semmpt004Bean.setOldchqAmt(to.get(0).getChqAmt());
						
					}else if(to != null && !to.isEmpty()){
						FrontMessageUtils.addMessageError(to.get(0).getpRemark());
					}
					
//					if("01".equals(semmpt004Bean.getMpt004SrchD().getWhtType()) || "02".equals(semmpt004Bean.getMpt004SrchD().getWhtType())){
//						if(to.get(0).getWhtRate() == null){
//							semmpt004Bean.getMpt004SrchD().setWhtRate(5D);
//						}
//					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					semmpt004Bean.setMsgTop(false);
					semmpt004Bean.setPnlPayInfo(true);
					semmpt004Bean.setPnlPayment(false);
				}
			}
		}
		setSemmpt004Bean(semmpt004Bean);
	}
	
	public void selectAllRow(){
		try{
			boolean chkAll = getSemmpt004Bean().isChkSelAll();
			List<WrapperBeanObject<Mpt004Srch>> detailList = new ArrayList<WrapperBeanObject<Mpt004Srch>>();
			detailList = getSemmpt004Bean().getMpt004SrchList();
			for(WrapperBeanObject<Mpt004Srch> wrapper : getSemmpt004Bean().getMpt004SrchList()){
//			for(int i=0; i<detailList.size(); i++){
				wrapper.setCheckBox(chkAll);
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
		getSemmpt004Bean().setTmpRowId(rowId);
		
		if(!StringUtils.isEmpty(rowId)){
			getSemmpt004Bean().setChkSelAll(false);
		}
		
		if(isOneValue()){
			getSemmpt004Bean().setRenderedBtnHExport(true);
			getSemmpt004Bean().setRenderedBtnExportShowError(false);
		}else{
			getSemmpt004Bean().setRenderedBtnHExport(false);
			getSemmpt004Bean().setRenderedBtnExportShowError(true);
		}
		
		if(isCheckSELBox())
			getSemmpt004Bean().setDisabledBtnExport(false);
		else
			getSemmpt004Bean().setDisabledBtnExport(true);
		
	}
	
	private boolean isCheckSELBox(){
		boolean isCheck = false;
		List<WrapperBeanObject<Mpt004Srch>> mpt003SrchSP = getSemmpt004Bean().getMpt004SrchList();
		for (WrapperBeanObject<Mpt004Srch> wrapperBeanObject : mpt003SrchSP) {
			if(wrapperBeanObject.isCheckBox()){
				return true;
			}
		}
		return isCheck;
	}
	
	public void onRenderPaymentMethod(){
		semmpt004Bean = getSemmpt004Bean();
		semmpt004Bean.setRenderedChqDt(true);
		semmpt004Bean.setRenderedChqReceiveDt(true);
		semmpt004Bean.setRenderedTransferDt(true);
		semmpt004Bean.setRenderedPaymentMethod(false);

		//-------------------------------------
		semmpt004Bean = getSemmpt004Bean();
		String test = (String)semmpt004Bean.getMpt004Pay().getPaymentType();

		log.debug("onRenderPaymentMethod : "+test);
		
		if(StringUtils.isEmpty(semmpt004Bean.getMpt004Pay().getPaymentType())){
			semmpt004Bean.setRenderCldTransferDt(true);
			semmpt004Bean.setRenderCldChqDt(true);
//			semmpt004Bean.getMpt004Pay().setPaymentMethod("");
			//addded by NEW 20150828 check null befor set default paymentMethod
			if(semmpt004Bean.getMpt004Pay().getPaymentMethod() == null || 
					semmpt004Bean.getMpt004Pay().getPaymentMethod().equals(""))
				semmpt004Bean.getMpt004Pay().setPaymentMethod("");
			//end added
			semmpt004Bean.getMpt004Pay().setChqDt(null);
			semmpt004Bean.getMpt004Pay().setChqReceive(null);
			semmpt004Bean.getMpt004Pay().setTransferDt(null);
			semmpt004Bean.setRenderedChqDt(true);
			semmpt004Bean.setRenderedChqReceiveDt(true);
			semmpt004Bean.setRenderedTransferDt(true);
		}
		if(semmpt004Bean.getMpt004Pay().getPaymentType() != null && semmpt004Bean.getMpt004Pay().getPaymentType().equals("01")){
			semmpt004Bean.setRenderCldTransferDt(true);
			semmpt004Bean.setRenderCldChqDt(false);
			semmpt004Bean.setRenderedChqReceiveDt(false);
			List<SelectItem> paymentMethodList = getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name,EX_AND,"CHEQUE",null,null);
			semmpt004Bean.setPaymentMethodList(paymentMethodList);
//			semmpt004Bean.getMpt004Pay().setChqDt(null);
			semmpt004Bean.getMpt004Pay().setChqReceive(null);
			semmpt004Bean.getMpt004Pay().setTransferDt(null);
//			semmpt004Bean.getMpt004Pay().setPaymentMethod("03");
			//addded by NEW 20150828 check null befor set default paymentMethod
			if(semmpt004Bean.getMpt004Pay().getPaymentMethod() == null || 
					semmpt004Bean.getMpt004Pay().getPaymentMethod().equals(""))
				semmpt004Bean.getMpt004Pay().setPaymentMethod(ParameterConfigUtil.getInstance().getConfigByCode(ELUtils.CT_PAYMENT_METHOD));
			//end added
			semmpt004Bean.setRenderedChqDt(false);
			semmpt004Bean.setRenderedChqReceiveDt(false);
			semmpt004Bean.setRenderedTransferDt(true);
		}
		if(semmpt004Bean.getMpt004Pay().getPaymentType() != null && semmpt004Bean.getMpt004Pay().getPaymentType().equals("02")){
			semmpt004Bean.setRenderCldChqDt(true);
			semmpt004Bean.setRenderedChqReceiveDt(true);
			semmpt004Bean.setRenderCldTransferDt(false);
			// prepare paymentMethodList
			List<SelectItem> paymentMethodList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
			List<SelectItem> selectList = new ArrayList<SelectItem>();
			for(SelectItem selectItem : paymentMethodList){
				if (StringUtils.equalsIgnoreCase("U", selectItem.getDescription())){
					selectList.add(selectItem);
				}
				
			}
			semmpt004Bean.setPaymentMethodList(selectList);
			semmpt004Bean.getMpt004Pay().setChqDt(null);
			semmpt004Bean.getMpt004Pay().setChqReceive(null);
//			semmpt004Bean.getMpt004Pay().setTransferDt(null);
			semmpt004Bean.setRenderedTransferDt(false);
		}
		if(semmpt004Bean.getMpt004Pay().getPaymentType() != null && semmpt004Bean.getMpt004Pay().getPaymentType().equals("03")){

			semmpt004Bean.getMpt004Pay().setChqDt(null);
			semmpt004Bean.getMpt004Pay().setChqReceive(null);
			semmpt004Bean.setRenderCldChqDt(true);
			semmpt004Bean.setRenderedChqDt(true);
			semmpt004Bean.setRenderedChqReceiveDt(true);
			semmpt004Bean.setRenderCldTransferDt(false);
			semmpt004Bean.setRenderedTransferDt(false);
			
			// prepare paymentMethodList
			List<SelectItem> paymentMethodList = LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name);
			List<SelectItem> selectList = new ArrayList<SelectItem>();
//			
			for(SelectItem selectItem : paymentMethodList){
				
				if (StringUtils.equalsIgnoreCase("P", selectItem.getDescription())){
					selectList.add(selectItem);
				}
			
			}
			semmpt004Bean.setPaymentMethodList(selectList);
			
		}
//		semmpt004Bean.getMpt004Pay().setChqDt(null);
//		semmpt004Bean.getMpt004Pay().setChqReceive(null);
//		semmpt004Bean.getMpt004Pay().setTransferDt(null);
		setSemmpt004Bean(semmpt004Bean);
		
		//-------------------------------------
		//setSemmpt004Bean(semmpt004Bean);
	}
	
	public void doExportExcel(){
		log.info("doExportExcel");
		semmpt004Bean = getSemmpt004Bean();	
		String payType = "";
		String renType = "";
		String chqDt = "";
		String chqRecDt = "";
		String tranfDt = "";
		//isCheckbox in Group
		String tempPaymentGroup = "";
		
		String paymentBatchNo = "";
		String tmpPaymentBatchNo = "";
		int totalPBatchNo = 0;
		semmpt004Bean.setTmpChkBox(new HashMap());
		for (WrapperBeanObject<Mpt004Srch> temp : semmpt004Bean.getMpt004SrchList()) {
			Mpt004Srch pt = (Mpt004Srch)temp.getDataObj();
			if(temp.isCheckBox()){
				tempPaymentGroup = pt.getPaymentGroupNo();
				semmpt004Bean.getTmpChkBox().put(pt.getRowId(), "Y");
				
				paymentBatchNo = pt.getBatchNo();
				if(StringUtils.isNotBlank(paymentBatchNo)){
					if(!StringUtils.equals(paymentBatchNo, tmpPaymentBatchNo))
					totalPBatchNo++;
				}
				
				payType = pt.getPaymentType();
				if("01".equals(pt.getPaymentType())){
					renType = StringUtils.isNotEmpty(pt.getPaymentTypeDesc())?pt.getPaymentTypeDesc():"" + (StringUtils.isNotEmpty(pt.getBankName())?pt.getBankName():"");
					if(pt.getChqDt() != null){
						chqDt = new SimpleDateFormat("dd/MM/yyyy").format(pt.getChqDt());
					}
					if(pt.getChqReceiveDt() != null){
						chqRecDt = new SimpleDateFormat("dd/MM/yyyy").format(pt.getChqReceiveDt());
					}
				}else{
					renType = pt.getPaymentTypeDesc();
					if(pt.getTransferDt() != null){
						tranfDt = new SimpleDateFormat("dd/MM/yyyy").format(pt.getTransferDt());
					}
				}
			}else if(pt.getPaymentGroupNo() != null && pt.getPaymentGroupNo().equals(tempPaymentGroup)){
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
			double diffAmount = 0.00;
		    // Date Format
		    DateFormat df =  new SimpleDateFormat("dd/MM/yyyy"); 
		    
		    //call store procedure get PaymentBatchNo
		    IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
		    List<MrtGetRunningNo> to = null;
		    semmpt004Bean.getMrtGetRunningNo().setRunningType("PT_PAY_BATCH");
		    to = pTaxMasterService.querySPList(EQueryName.SP_MRT_GET_RUNNING_NO.name, semmpt004Bean.getMrtGetRunningNo());
		    
		    Mpt004Srch mpt004srch = (Mpt004Srch)semmpt004Bean.getMpt004SrchList().get(0).getDataObj();
		    
		    short line = 0;
			Collection<Mpt004Srch> exList = new ArrayList<Mpt004Srch>();
			DocumentExportManager<Mpt004Srch> docManager =
				new DocumentExportManager<Mpt004Srch>(Mpt004Srch.class, EnumDocumentType.XLS);
			docManager.setRowStart(line);
			EnumDocStyleDomain titleStyle = new EnumDocStyleDomain(EnumDocStyle.TITLE);
			RowDomain row0 = new RowDomain(0,true);	
			row0.setCell(new CellDomain(0,15, null, String.class, titleStyle, msg("export.col.headPropertyTaxPay1")+" "+msg("export.col.date")+" "+df.format(SEMDataUtility.convertToThYear(new Date())),null));
			
			if(StringUtils.isBlank(tmpPaymentBatchNo)){
				tmpPaymentBatchNo = to.get(0).getRunningNo();
			}
			
			RowDomain row1 = new RowDomain(1,true);	
			row1.setCell(new CellDomain(0,15, null, String.class, titleStyle, msg("export.col.paymentBatchNo")+" "+tmpPaymentBatchNo,null));
			
			List<WrapperBeanObject<Mpt004Srch>> detailList = new ArrayList<WrapperBeanObject<Mpt004Srch>>();
			detailList = getSemmpt004Bean().getMpt004SrchList();
			int no = 0;
			String company = "";
			for(int i=0; i<detailList.size(); i++){
				WrapperBeanObject<Mpt004Srch> detail = new WrapperBeanObject<Mpt004Srch>();
				detail = detailList.get(i);
				if(detail.isCheckBox()){
					Mpt004Srch tmp = new Mpt004Srch();
					tmp = (Mpt004Srch)detail.getDataObj();
					company = tmp.getCompany();
					tmp.setNo(++no);
					exList.add(tmp);
					if(tmp.getExcAmt() != null)
						amount += tmp.getExcAmt();
					if(tmp.getVatAmt() != null)
						vatAmount += tmp.getVatAmt();
					if(tmp.getWhtAmt() != null)
						whtAmount += tmp.getWhtAmt();
					if(tmp.getChqAmt() != null)
						netAmount += tmp.getChqAmt();
					if(tmp.getDiffAmt() != null)
						diffAmount += tmp.getDiffAmt();
				}
			}	
			
			RowDomain row2 = new RowDomain(2,true);	
			row2.setCell(new CellDomain(0,15, null, String.class, titleStyle, msg("export.col.company")+" "+ semmpt004Bean.getMpt004Srch().getCompany()+","+msg("export.col.region")+ " "+mpt004srch.getRegion(),null));
//			row2.setCell(new CellDomain(0,15, null, String.class, titleStyle, msg("export.col.company")+" "+ company+" ,"+msg("export.col.region")+ " "+mpt004srch.getRegion(),null));

			RowDomain row3 = new RowDomain(3,true);	
			if(mpt004srch.getChqDt() != null){
				row3.setCell(new CellDomain(0, null, String.class, titleStyle, null, null));
//				row3.setCell(new CellDomain(0,15, null, String.class, titleStyle, msg("export.col.paymentType")+ (StringUtil.isEmpty(mpt004srch.getPaymentTypeDesc())?"":mpt004srch.getPaymentTypeDesc())+","+msg("export.col.chqDt")+" "+df.format(mpt004srch.getChqDt())+","+msg("export.col.chqReceiveDt")+" "+df.format(mpt004srch.getChqReceiveDt()),null));
			}else if(mpt004srch.getTransferDt() != null){
				row3.setCell(new CellDomain(0, null, String.class, titleStyle, null, null));
//				row3.setCell(new CellDomain(0,15, null, String.class, titleStyle, msg("export.col.paymentType")+" "+ (StringUtil.isEmpty(mpt004srch.getPaymentTypeDesc())?"":mpt004srch.getPaymentTypeDesc())+","+msg("export.col.transferDt")+" "+df.format(mpt004srch.getTransferDt()),null));
			}
			EnumDocStyleDomain field = docManager.getStyle("normalField");
			EnumDocStyleDomain fieldMoney = docManager.getStyle("rt003FieldMoney");
			RowDomain row4 = new RowDomain(4,true);	
			RowDomain row5 = new RowDomain(5,true);	
			
			EnumDocStyleDomain 	headerStyle =  docManager.getStyle("rt003FieldHeader");
			row4.setCell(new CellDomain(0, null, String.class, headerStyle, msg("export.col.no"),-1,1000));
			row4.setCell(new CellDomain(1, null, String.class, headerStyle, msg("export.col.doc68"),-1,2900));
			row4.setCell(new CellDomain(2, null, String.class, headerStyle, msg("export.col.contractNo2"),-1,2500));
			row4.setCell(new CellDomain(3, null, String.class, headerStyle, msg("export.col.pTaxYear"),-1,1400));
			row4.setCell(new CellDomain(4, null, String.class, headerStyle, msg("export.col.periodNo"),-1,1200));
			row4.setCell(new CellDomain(5, null, String.class, headerStyle, msg("export.col.expenseType"),-1,3300));
			row4.setCell(new CellDomain(6, null, String.class, headerStyle, msg("export.col.siteName"),-1,3000));
			row4.setCell(new CellDomain(7, null, String.class, headerStyle, "Vendor Code",-1,3000));
			row4.setCell(new CellDomain(8, null, String.class, headerStyle, msg("export.col.propertytaxpayVendorName"),-1,3500));
			row4.setCell(new CellDomain(9, null, String.class, headerStyle, msg("export.col.payeeName"),-1,3000));
			row4.setCell(new CellDomain(10, null, String.class, headerStyle, "Amount",-1,2500));
			row4.setCell(new CellDomain(11, null, String.class, headerStyle, "WHT",-1,2000));
			row4.setCell(new CellDomain(12, null, String.class, headerStyle, "VAT",-1,2000));
			row4.setCell(new CellDomain(13, null, String.class, headerStyle, "Cheque Amt",-1,2500));
			row4.setCell(new CellDomain(14, null, String.class, headerStyle, "Diff Amt",-1,2500));
			row4.setCell(new CellDomain(15, null, String.class, headerStyle, msg("export.col.remark2"),-1,2500));
			
			
			RowDomain row6 = new RowDomain(0,false);
			row6.setCell(new CellDomain(0, null, String.class, field, null,-1,null));
			row6.setCell(new CellDomain(1, null, String.class, field, null,-1,null));
			row6.setCell(new CellDomain(2, null, String.class, field, null,-1,null));
			row6.setCell(new CellDomain(3, null, String.class, field, null,-1,null));
			row6.setCell(new CellDomain(4, null, String.class, field, null,-1,null));
			row6.setCell(new CellDomain(5, null, String.class, field, null,-1,null));
			row6.setCell(new CellDomain(6, null, String.class, field, null,-1,null));
			row6.setCell(new CellDomain(7, null, String.class, field, null,-1,null));
			row6.setCell(new CellDomain(8, null, String.class, field, null,-1,null));
			row6.setCell(new CellDomain(9, null, String.class, field, null,-1,null));
			row6.setCell(new CellDomain(10, null, Double.class, fieldMoney,amount,-1,2500));
			row6.setCell(new CellDomain(11, null, Double.class, fieldMoney, whtAmount,-1,2000));
			row6.setCell(new CellDomain(12, null, Double.class, fieldMoney, vatAmount,-1,2000));
			row6.setCell(new CellDomain(13, null, Double.class, fieldMoney, netAmount,-1,2500));
			row6.setCell(new CellDomain(14, null, Double.class, fieldMoney, diffAmount,-1,2500));
			row6.setCell(new CellDomain(15, null, String.class, field, null,-1,null));
			
			
			RowDomain row10 = new RowDomain(1,false);
			RowDomain row9 = new RowDomain(2,false);
			RowDomain row7 = new RowDomain(3,false);
			RowDomain row8 = new RowDomain(4,false);
			
			if("01".equals(payType)){
				row9.setCell(new CellDomain(1,2, null, String.class, titleStyle, msg("export.col.paymentTypeDesc")+" : ",null));
				row9.setCell(new CellDomain(3,4, null, String.class, field, (StringUtils.isEmpty(renType)?"":renType),null));
				row7.setCell(new CellDomain(1,2, null, String.class, titleStyle, msg("export.column.contract.chqDt")+" : ",null));
				row7.setCell(new CellDomain(3,4, null, String.class, field, (StringUtils.isEmpty(chqDt)?"":chqDt),null));
				row8.setCell(new CellDomain(1,2, null, String.class, titleStyle, msg("export.column.contract.chqRecDt")+" : ",null));
				row8.setCell(new CellDomain(3,4, null, String.class, field, (StringUtils.isEmpty(chqRecDt)?"":chqRecDt),null));
				docManager.putDetailRow(row7);
			}else{
				row9.setCell(new CellDomain(1, null, String.class, titleStyle, msg("export.col.paymentTypeDesc")+" : ",null));
				row9.setCell(new CellDomain(2, null, String.class, field, (StringUtils.isEmpty(renType)?"":renType),null));
				row8.setCell(new CellDomain(1, null, String.class, titleStyle, msg("export.column.contract.tranDt")+" : ",null));
				row8.setCell(new CellDomain(2, null, String.class, field, (StringUtils.isEmpty(tranfDt)?"":tranfDt),null));
			}
			
			docManager.setColumnheight(25);
			docManager.putDetailRow(row0);
			docManager.putDetailRow(row1);
			docManager.putDetailRow(row2);
			docManager.putDetailRow(row3);
			docManager.putDetailRow(row4);
//			docManager.putDetailRow(row5);
			docManager.putDetailRow(row6);
			docManager.putDetailRow(row10);
			docManager.putDetailRow(row7);
			docManager.putDetailRow(row8);
			docManager.putDetailRow(row9);
			docManager.seteObjectList(exList);
			docManager.setMargin(0, 0, 0, 0);
			docManager.setModule("PropertyTaxPay");
			docManager.setPrintPageLandScape(true);
			docManager.getObjectFromDocument();
			docManager.exportServletFile();
			
            semmpt004Bean.setBtnStatus("EP");
			setSemmpt004Bean(semmpt004Bean);
			doUpdateAct();
			semmpt004Bean.setDisplayShowExcel(false);
		}catch(NullPointerException ne){
			log.error(ne);
		}catch(Exception e){
			log.error(e);
		}
	}
	
	public void onRenderpayGovtFlag(){
		semmpt004Bean = getSemmpt004Bean();
		semmpt004Bean.setRenderLinkPayGovtFlag(false);
		if(semmpt004Bean.isChkPayGovtFlag() == true){
			semmpt004Bean.setRenderLinkPayGovtFlag(true);
		}
		setSemmpt004Bean(semmpt004Bean);
	}
	
	public void onRenderIncludeAmt(){
		semmpt004Bean = getSemmpt004Bean();
		if(!validateTotalAmount()){
			addMessageError("W0031");
			semmpt004Bean.getMpt004SrchD().setIncAmt(
					(semmpt004Bean.getMpt004SrchD().getExcAmt()!=null?semmpt004Bean.getMpt004SrchD().getExcAmt():0.00 )
				  + (semmpt004Bean.getMpt004SrchD().getVatAmt()!=null?semmpt004Bean.getMpt004SrchD().getVatAmt():0.00));
		}else{
			semmpt004Bean.getMpt004SrchD().setIncAmt(
					(semmpt004Bean.getMpt004SrchD().getExcAmt()!=null?semmpt004Bean.getMpt004SrchD().getExcAmt():0.00 )
				  + (semmpt004Bean.getMpt004SrchD().getVatAmt()!=null?semmpt004Bean.getMpt004SrchD().getVatAmt():0.00));
		}
		semmpt004Bean.setPnlPayInfo(true);
		semmpt004Bean.setMsgTop(false);
		semmpt004Bean.setPnlPayment(false);
		setSemmpt004Bean(semmpt004Bean);
		onRenderTotalAmt();
	}
	
	public boolean validateTotalAmount(){
		boolean flagValid = true;
		semmpt004Bean = getSemmpt004Bean();
		Double defaultValPositive = 1.00;
		Double defaultValNegative = -1.00;
		if(semmpt004Bean.getMpt004SrchD().getVatAmt() != null){
			if(semmpt004Bean.getOldVatAmt() == null){
				semmpt004Bean.setOldVatAmt(0.00);
			}
			if(semmpt004Bean.getOldExcAmt() == null){
				semmpt004Bean.setOldExcAmt(0.00);
			}
			
			Double tmpExcAmt = semmpt004Bean.getOldExcAmt() - semmpt004Bean.getMpt004SrchD().getExcAmt();
			if(tmpExcAmt > defaultValPositive || tmpExcAmt < defaultValNegative){
				semmpt004Bean.getMpt004SrchD().setExcAmt(semmpt004Bean.getOldExcAmt());
				semmpt004Bean.getMpt004SrchD().setIncAmt(semmpt004Bean.getOldIncAmt());
				flagValid = false;
			}
			
			Double tmpVatAmt = semmpt004Bean.getOldVatAmt() - semmpt004Bean.getMpt004SrchD().getVatAmt();
			if(tmpVatAmt > defaultValPositive || tmpVatAmt < defaultValNegative){
				semmpt004Bean.getMpt004SrchD().setVatAmt(semmpt004Bean.getOldVatAmt());
				semmpt004Bean.getMpt004SrchD().setIncAmt(semmpt004Bean.getOldIncAmt());
				flagValid = false;
			}
		}
		if(semmpt004Bean.getMpt004SrchD().getWhtAmt() != null && semmpt004Bean.getOldWhtAmt() != null){
			Double tmpWhtAmt = semmpt004Bean.getOldWhtAmt() - semmpt004Bean.getMpt004SrchD().getWhtAmt();
			if(tmpWhtAmt > defaultValPositive || tmpWhtAmt < defaultValNegative){
				semmpt004Bean.getMpt004SrchD().setWhtAmt(semmpt004Bean.getOldWhtAmt());
				semmpt004Bean.getMpt004SrchD().setChqAmt(semmpt004Bean.getOldchqAmt());
				flagValid = false;
			}
		}
		setSemmpt004Bean(semmpt004Bean);
		return flagValid;
	}
	
	// Total Amount
	public void onRenderTotalAmt(){
		semmpt004Bean = getSemmpt004Bean();
		if(!validateTotalAmount()){
			addMessageWarn("W0031");
		}else{
			semmpt004Bean.getMpt004SrchD().setChqAmt(
					(semmpt004Bean.getMpt004SrchD().getIncAmt()!=null?semmpt004Bean.getMpt004SrchD().getIncAmt():0.00 )
				  - (semmpt004Bean.getMpt004SrchD().getWhtAmt()!=null?semmpt004Bean.getMpt004SrchD().getWhtAmt():0.00));
		}
		semmpt004Bean.setPnlPayInfo(true);
		semmpt004Bean.setMsgTop(false);
		semmpt004Bean.setPnlPayment(false);
		setSemmpt004Bean(semmpt004Bean);
	}
	
	//checkk Status BeforeSave
	public void onRenderCheckBeforeSave(){
		semmpt004Bean = getSemmpt004Bean();
		popupSiteContractAntCriBean = getPopupSiteContractAntCriBean();
		IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
		List<Mpt004Chk> to = null;
		
		//add parameter
		semmpt004Bean.getMpt004Chk().setContractNo(popupSiteContractAntCriBean.getContractNo());
		semmpt004Bean.getMpt004Chk().setpTaxYear(semmpt004Bean.getMpt004SrchD().getpTaxYear());
		semmpt004Bean.getMpt004Chk().setExpenseType(semmpt004Bean.getMpt004SrchD().getExpenseType());
		semmpt004Bean.getMpt004Chk().setPeriodNo(semmpt004Bean.getMpt004SrchD().getPeriodNo());
		semmpt004Bean.getMpt004Chk().setDocType(semmpt004Bean.getMpt004SrchD().getDocType());
		semmpt004Bean.getMpt004Chk().setDocNo(semmpt004Bean.getMpt004SrchD().getDocNo());
		semmpt004Bean.getMpt004Chk().setMonthFrom(semmpt004Bean.getMpt004SrchD().getMonthFrom());
		semmpt004Bean.getMpt004Chk().setMonthTo(semmpt004Bean.getMpt004SrchD().getMonthTo());
		semmpt004Bean.getMpt004Chk().setpTaxPaymentId(semmpt004Bean.getMpt004SrchD().getRowId());
		try { 
			to = pTaxMasterService.querySPList(EQueryName.SP_MPT004_CHK.name, semmpt004Bean.getMpt004Chk());
			if(to != null && to.size() != 0 && to.get(0).getResultMsg().equals("Success")){
				semmpt004Bean.getMpt004SrchD().setpTaxPayType(to.get(0).getpTaxPayType());
				semmpt004Bean.getMpt004SrchD().setpTaxPayTypeDesc(to.get(0).getpTaxPayTypeDesc());
				semmpt004Bean.getMpt004SrchD().setPayGovtFlag(to.get(0).getPayGovtFlag());
				semmpt004Bean.getMpt004SrchD().setPaymentStatus(to.get(0).getPaymentStatus());
				semmpt004Bean.getMpt004SrchD().setPaymentStatusDesc(to.get(0).getPaymentStatusDesc());
				semmpt004Bean.getMpt004SrchD().setVendorCode(to.get(0).getVendorCode());
				semmpt004Bean.getMpt004SrchD().setVendorName(to.get(0).getVendorName());
				semmpt004Bean.getMpt004SrchD().setPayeeName(to.get(0).getPayeeName());
				semmpt004Bean.getMpt004SrchD().setEstmAmt(to.get(0).getEstmAmt());
				semmpt004Bean.getMpt004SrchD().setpTaxAmt(to.get(0).getpTaxAmt());
				semmpt004Bean.getMpt004SrchD().setPayeeId(to.get(0).getPayeeId());
				semmpt004Bean.getMpt004SrchD().setBankAccNo(to.get(0).getBankAccNo());
				semmpt004Bean.getMpt004SrchD().setBankName(to.get(0).getBankName());
				if(StringUtils.isEmpty(semmpt004Bean.getMpt004SrchD().getPaymentType()))
					semmpt004Bean.getMpt004SrchD().setPaymentType(to.get(0).getPaymentType());
				if(StringUtils.isEmpty(semmpt004Bean.getMpt004SrchD().getPaymentMethod()))
					semmpt004Bean.getMpt004SrchD().setPaymentMethod(to.get(0).getPaymentMethod());
				semmpt004Bean.getMpt004Chk().setMessage(to.get(0).getMessage());
				semmpt004Bean.setRenderedBtnSave(false);
			} else if(to != null && !to.isEmpty()){
				semmpt004Bean.setRenderedBtnSave(true);
				FrontMessageUtils.addMessageError(to.get(0).getMessage());
			}

			if(!StringUtils.isEmpty(semmpt004Bean.getMpt004SrchD().getPayGovtFlag())){
				if(semmpt004Bean.getMpt004SrchD().getPayGovtFlag().equals("Y")){
					semmpt004Bean.setChkPayGovtFlag(true);
				}
				else{
					semmpt004Bean.setChkPayGovtFlag(false);
				}
				
			}
			onRenderpayGovtFlag();
			renderPayPeriodType();
			semmpt004Bean.setMsgTop(false);
			semmpt004Bean.setPnlPayInfo(true);
			semmpt004Bean.setPnlPayment(false);
			semmpt004Bean.setMpt004Chk(to.get(0));
			
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError("E0001");
			semmpt004Bean.setMsgTop(false);
			semmpt004Bean.setPnlPayInfo(true);
			semmpt004Bean.setPnlPayment(false);
		}
		setSemmpt004Bean(semmpt004Bean);
		setPopupSiteContractAntCriBean(popupSiteContractAntCriBean);
	}
	
	public void onRenderWhtRate(){
		semmpt004Bean = getSemmpt004Bean();
		semmpt004Bean.setDisableWhtRate(false);
		if(semmpt004Bean.getMpt004SrchD().getWhtType().equals("03")){
			semmpt004Bean.setDisableWhtRate(true);
			semmpt004Bean.getMpt004SrchD().setWhtRate(0.00);
		}
		setSemmpt004Bean(semmpt004Bean);
	}
	
	public void onRenderMsgPanel(){
		semmpt004Bean = getSemmpt004Bean();
		semmpt004Bean.setMsgTop(false);
		semmpt004Bean.setPnlPayInfo(false);
		semmpt004Bean.setPnlPayment(true);
		setSemmpt004Bean(semmpt004Bean);
	}
	
	private boolean doClearFormPay(){
		boolean flag = false;
		semmpt004Bean = getSemmpt004Bean();
		popupSiteContractAntCriBean = getPopupSiteContractAntCriBean();
		popupSiteContractAntCriBean.setContractNo(null);
		semmpt004Bean.setMpt004SrchD(new Mpt004SrchD());
		semmpt004Bean.getMpt004SrchD().setPeriodType("02");
		semmpt004Bean.setPayPeriodType02("02");
		semmpt004Bean.setRenderedBtnSave(false);
		semmpt004Bean.setChkPayGovtFlag(false);
		semmpt004Bean.setRenderLinkPayGovtFlag(false);
		semmpt004Bean.getMpt004SrchD().setVatType("03");
		semmpt004Bean.getMpt004SrchD().setWhtType("03");
		semmpt004Bean.getMpt004SrchD().setPeriodNo("1");
		semmpt004Bean.getMpt004SrchD().setMonthFrom("01");
		semmpt004Bean.getMpt004SrchD().setMonthTo("01");
		semmpt004Bean.setRenderContractNo(false);
		setSemmpt004Bean(semmpt004Bean);
		doDefaultCreateby();
		renderPayPeriodType();
		return flag;
	}
	
	public void doDefaultCreateby(){
		semmpt004Bean = getSemmpt004Bean();
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String sDate = sdf.format(date);
		Date deFault;
		try {
			deFault = sdf.parse(sDate);
			semmpt004Bean.getMpt004SrchD().setCreateBy(semmpt004Bean.getUserLogin());
			semmpt004Bean.getMpt004SrchD().setCreateDt(deFault);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setSemmpt004Bean(semmpt004Bean);
	}
	
	public void doShowPopupContractNo(){
		semmpt004Bean = getSemmpt004Bean();
		IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
		List<Mpt004SrchC> to = null;
		semmpt004Bean.getMpt004SrchC().setVendorCode(semmpt004Bean.getMpt004SrchD().getVendorCode());
		int i = 0;
		String tmpContractNo = "";
		try {
			to = pTaxMasterService.querySPList(EQueryName.SP_MPT004_SRCH_C.name, semmpt004Bean.getMpt004SrchC());
			if (to == null || to.isEmpty() || to.size() == 0) {
				semmpt004Bean.setShowPopupContract(true);
				addMessageError("M0004");
				semmpt004Bean.setMsgTop(false);
				semmpt004Bean.setPnlPayInfo(true);
				semmpt004Bean.setPnlPayment(false);
			}else{
				semmpt004Bean.setShowPopupContract(true);
				
				for(Mpt004SrchC mpt : to){
					if(i == 0){
						tmpContractNo = mpt.getContractNo();
					}else{
						tmpContractNo = ","+ mpt.getContractNo();
					}
				}
			}
			semmpt004Bean.setConcatContractNo(tmpContractNo);
			setSemmpt004Bean(semmpt004Bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void onRenderExpenseType(){
		semmpt004Bean = getSemmpt004Bean();
		semmpt004Bean.setDisablePaneltyType(true);
		if(!StringUtils.isEmpty(semmpt004Bean.getMpt004SrchD().getExpenseType()) && semmpt004Bean.getMpt004SrchD().getExpenseType().equals("15")){
			semmpt004Bean.setDisablePaneltyType(false);
		}
		setSemmpt004Bean(semmpt004Bean);
	}
	
	public void renderProvinceList(){
		semmpt004Bean = getSemmpt004Bean();
		String samRegion = semmpt004Bean.getMpt004Srch().getRegion();
		Object[] objSamRegions = {samRegion};
		semmpt004Bean.setProvinceList(this.getProvinceBySamRegion(objSamRegions));
		setSemmpt004Bean(semmpt004Bean);
	}
	
	public void renderGovtList(){
		semmpt004Bean = getSemmpt004Bean();
		VendorMaster vendorMaster = new VendorMaster();
		vendorMaster.setRecordStatus("Y");
		vendorMaster.setPtaxFlag("Y");
		vendorMaster.setProvince(semmpt004Bean.getMpt004Srch().getProvince());
		semmpt004Bean.setGovtList(this.getGovtByProvince(vendorMaster));
		setSemmpt004Bean(semmpt004Bean);
	}
	
	public void renderAmphurList(){
		semmpt004Bean = getSemmpt004Bean();
		Province province = new Province();
		province.setRowId(semmpt004Bean.getMpt004Srch().getProvince());
		semmpt004Bean.setAmphurList(this.getAmphurByProvince(province));
		setSemmpt004Bean(semmpt004Bean);
	}
	
	public void doDefaultPtaxYearFrom(){
		semmpt004Bean = getSemmpt004Bean();
		if(semmpt004Bean.getMpt004Srch().getpTaxYearFrom() != null || !StringUtils.isEmpty(semmpt004Bean.getMpt004Srch().getpTaxYearFrom())){
			semmpt004Bean.getMpt004Srch().setpTaxYearTo(semmpt004Bean.getMpt004Srch().getpTaxYearFrom());
		}
		setSemmpt004Bean(semmpt004Bean);
	}
	
	public void onRenderVatAndWhtType(){
		semmpt004Bean = getSemmpt004Bean();
		semmpt004Bean.setDisableVatAndWhtType(false);
		semmpt004Bean.setDisableWhtRate(false);
		semmpt004Bean.setRequireDocVat(false);
		if(semmpt004Bean.getMpt004SrchD().getDocType().equals("05") || semmpt004Bean.getMpt004SrchD().getDocType().equals("06")){
			semmpt004Bean.setDisableVatAndWhtType(true);
			semmpt004Bean.getMpt004SrchD().setVatType("03");
			semmpt004Bean.getMpt004SrchD().setWhtType("03");
			semmpt004Bean.getMpt004SrchD().setWhtRate(null);
		}
		if(semmpt004Bean.getMpt004SrchD().getWhtType().equals("03")){
			semmpt004Bean.setDisableWhtRate(true);
		}
		if(semmpt004Bean.getMpt004SrchD().getDocType().equals("01")){
			semmpt004Bean.setRequireDocVat(true);
		}
		
		setSemmpt004Bean(semmpt004Bean);
	}
	
	public void doCheckContractNo(){
		semmpt004Bean = getSemmpt004Bean();
		popupSiteContractAntCriBean = getPopupSiteContractAntCriBean();
		ISiteContractService siteContractService = (ISiteContractService)getBean("siteContractService");
		List<Contract> to = null;
		Contract contract = new Contract();
		popupSiteContractAntCriBean.setContractNo(popupSiteContractAntCriBean.getContractNo().toUpperCase());
		contract.setContractNo(popupSiteContractAntCriBean.getContractNo());
		if(semmpt004Bean.getMpt004SrchD()!=null){
		semmpt004Bean.getMpt004SrchD().setContractNo(popupSiteContractAntCriBean.getContractNo());
		}else{
			Mpt004SrchD srhcD = new Mpt004SrchD();
			srhcD.setContractNo(popupSiteContractAntCriBean.getContractNo());
			semmpt004Bean.setMpt004SrchD(srhcD);
		}
		try {
			to = siteContractService.searchContract(contract, "");
			if(to == null || to.size() == 0){
				addMessageError("W0032",contract.getContractNo());
				popupSiteContractAntCriBean.setContractNo("");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		setPopupSiteContractAntCriBean(popupSiteContractAntCriBean);
		setSemmpt004Bean(semmpt004Bean);
		}
	}
	
	
	private PopupSiteContractAntCriBean popupSiteContractAntCriBean;

	public PopupSiteContractAntCriBean getPopupSiteContractAntCriBean() {
		PopupSiteContractAntCriBean popupSiteContractAntCri = (PopupSiteContractAntCriBean)getFacesUtils().getSessionMapValue("popupSiteContractAntCriBean");
		if (popupSiteContractAntCri == null) {
			popupSiteContractAntCri = new PopupSiteContractAntCriBean();
		}
		return popupSiteContractAntCri;
	}

	public void setPopupSiteContractAntCriBean(PopupSiteContractAntCriBean popupSiteContractAntCriBean) {
		this.popupSiteContractAntCriBean = popupSiteContractAntCriBean;
		getFacesUtils().setSessionMapValue("popupSiteContractAntCriBean", popupSiteContractAntCriBean);
	}
	
	public void getRowIdOnClick() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemmpt004Bean().setTmpRowId(rowId);
	}
	
	public boolean onRenderMsgErrorExoprt(){
		boolean flag = false;
		addMessageError("W0098");
		getSemmpt004Bean().setRenderedMsgFormTop(true);
		getSemmpt004Bean().setRenderedMsgFormBottom(false);
		return flag;
	}
	
	private boolean isOneValue(){
		semmpt004Bean = getSemmpt004Bean();
		boolean isTrue = true;
		int totalPBatchNo = 0;
		String paymentBatchNo = "";
		String tmpPaymentBatchNo = "";
		for (WrapperBeanObject<Mpt004Srch> temp : semmpt004Bean.getMpt004SrchList()) {
			Mpt004Srch pt = (Mpt004Srch)temp.getDataObj();
			if(temp.isCheckBox()){
				//Adding by mr.John from (mr.Choosak) 28/04/2011
				paymentBatchNo = pt.getBatchNo();
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
	
	public void onRenderWhtRateChange(){
		semmpt004Bean = getSemmpt004Bean();
		semmpt004Bean.setChangeWhtRateFlag(true);
		
		log.debug("Wht Rate Flag : "+semmpt004Bean.isChangeWhtRateFlag());
		setSemmpt004Bean(semmpt004Bean);
		onRenderAmount();
	}
	
	// added by.. YUT 2014/09/11
	private boolean doSendSMS(){
		semmpt004Bean = getSemmpt004Bean();
		IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
		
		boolean result = false;
		StringBuffer rowId = new StringBuffer();
		
		for(WrapperBeanObject<Mpt004Srch> mpt : semmpt004Bean.getMpt004SrchList()){
			Mpt004Srch mpt004Srch = (Mpt004Srch) mpt.getDataObj();
			
			if(mpt.isCheckBox()){
				rowId.append(mpt004Srch.getRowId()+",");
			}
		}
		
		List<SMSModel> smsList = null;
		SMSModel smsP = new SMSModel();
		
		try {
			smsP.setpRowId(rowId.toString());
			smsP.setpType("A");
			
			log.debug("rowId = "+rowId.toString());
			
			smsList = pTaxMasterService.querySPList(EQueryName.SP_MRT003_SMS.name, smsP);
			
			if(smsList == null || smsList.size() == 0){
				addMessageError("M0004");
			}else{
				for(SMSModel smsM :smsList){
					result = SmsClient.sendSMS(smsM);
					log.debug("result = "+result);
				}
				this.doSearch();
				addMessageInfo("M0001");
			}
		}catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
		return false;
	}
	
	//create by new  24/10/2014
	private boolean doSendEmail(){
		semmpt004Bean = getSemmpt004Bean();
		IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
		boolean result = false;
		StringBuffer rowId = new StringBuffer();
		RentalPayNormalSearchSP rentalPay = new RentalPayNormalSearchSP();
		String groupNoTmp = "";
		
		for(WrapperBeanObject<Mpt004Srch> mpt : semmpt004Bean.getMpt004SrchList()){
			Mpt004Srch mpt004Srch = (Mpt004Srch) mpt.getDataObj();
			
			if(mpt.isCheckBox()){
				rowId.append(mpt004Srch.getRowId()+",");
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
//					emailM.setV_Message(emailM.getV_Message()+" FROM SEMMPT004-1");
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
	
	// -> popup add vendor
	public void initAddVendor(){
		log.info("-- initPopupAddVendor --");

		SEMMPT004Bean mpt004Bean = getSemmpt004Bean();

		try {
			
			doClearPopupAddVendor();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmpt004Bean(mpt004Bean);
	}
	
	public void doSearchPopupAddVendor(){
		log.info("-- doSearchPopupAddVendor --");

		SEMMPT004Bean mpt004Bean = getSemmpt004Bean();

		try {
			
			//String strVendorCode = mpt004Bean.getVendorMasterPopupObjParam().getVendorCode();
			//String strVendorName = mpt004Bean.getVendorMasterPopupObjParam().getVendorName();


			IVendorMasterService service = (IVendorMasterService)getBean("vendorMasterService");
			List<VendorMasterSP> vendorMasterList = null;
			
			mpt004Bean.setVendorMasterPopupList(new ArrayList<WrapperBeanObject<VendorMasterSP>>());
			
			vendorMasterList = service.queryVendorMasterSPList(EQueryName.SP_GET_MAP_VENDOR.name, mpt004Bean.getVendorMasterPopupObjParam());
			if(vendorMasterList != null && !vendorMasterList.isEmpty()){
				 for(int i=0; i<vendorMasterList.size(); i++){
					VendorMasterSP vm = (VendorMasterSP)vendorMasterList.get(i);
					WrapperBeanObject<VendorMasterSP> tmpWrapperBean = new WrapperBeanObject<VendorMasterSP>();
					
					tmpWrapperBean.setDataObj(vm);
					tmpWrapperBean.setMessage("");
					mpt004Bean.getVendorMasterPopupList().add(tmpWrapperBean);
					
					mpt004Bean.setRenderedMsgDataNotFound(false);
				 }
			 } else {
				 mpt004Bean.setRenderedMsgDataNotFound(true);
			 }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmpt004Bean(mpt004Bean);
	}
	
	public void doClearPopupAddVendor(){
		log.info("-- doClearPopupAddVendor --");

		SEMMPT004Bean mpt004Bean = getSemmpt004Bean();

		try {
			
			mpt004Bean.getVendorMasterPopupObjParam().setVendorCode("");
			mpt004Bean.getVendorMasterPopupObjParam().setVendorName("");
			mpt004Bean.setVendorMasterPopupList(new ArrayList<WrapperBeanObject<VendorMasterSP>>());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmpt004Bean(mpt004Bean);
	}
	
	public void doSelectPopupAddVendor(){
		log.info("-- doSelectPopupAddVendor --");

		SEMMPT004Bean mpt004Bean = getSemmpt004Bean();

		try {
			
			String paramVendorCode = getFacesUtils().getRequestParameter("paramVendorCode") == null ? "" : 
							  (String)getFacesUtils().getRequestParameter("paramVendorCode");
			String paramVendorName = getFacesUtils().getRequestParameter("paramVendorName") == null ? "" : 
				  (String)getFacesUtils().getRequestParameter("paramVendorName");
			
			mpt004Bean.getMpt004Srch().setVendorCode(paramVendorCode);
//			mpt004Bean.getMpt004Srch().setVendorName(paramVendorName);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmpt004Bean(mpt004Bean);
	}
	// <- popup add vendor
	
	 public boolean doInitialForSearchPropertyTax() {
			log.info("::: SEMMPT004Action :: doInitialForSearchSiteInfo >> BEGIN :::");
			boolean flag = true;
			SEMMPT004Action semmpt004Action = new SEMMPT004Action();
			try {
				this.init();
				semmpt004Bean = getSemmpt004Bean();

				String paramUrl = getFacesUtils().getRequestParameter("paramUrl") == null ? "" : (String) getFacesUtils().getRequestParameter("paramUrl");
		        String paramMenuGroup = getFacesUtils().getRequestParameter("paramMenuGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuGroup");
		        String paramMenuSubGroup = getFacesUtils().getRequestParameter("paramMenuSubGroup") == null ? "" : (String) getFacesUtils().getRequestParameter("paramMenuSubGroup");
		        String paramParameter = getFacesUtils().getRequestParameter("paramParameter") == null ? "" : (String) getFacesUtils().getRequestParameter("paramParameter");
		       
		        System.out.println("paramUrl: " + paramUrl);
		        System.out.println("paramMenuGroup: " + paramMenuGroup);
		        System.out.println("paramMenuSubGroup: " + paramMenuSubGroup);
		        System.out.println("paramParameter: " + paramParameter);
		        
//		        semmpt001Bean.getSiteInfoSP().setStrParam(paramParameter);
		        semmpt004Bean.setRenderedOnToDoList(true); //
		        semmpt004Bean.getMpt004Srch().setStrParam(paramParameter);

				setSemmpt004Bean(semmpt004Bean);
//				semmpt001Action.doInitTodoList();
				
				this.doSearch();

			} catch(Exception e) {
				e.printStackTrace();
				addMessageError("EL0000", "SEMMPT004Action");
				flag = false;
				
			} finally {
				semmpt004Action = null;
				log.info("::: SEMMPT004Action :: doInitialForSearchSiteInfo >> END :::");
			}
			return flag;
		}
	 
}
