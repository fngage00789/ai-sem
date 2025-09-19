package th.co.ais.web.pt.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.gm.Province;
import th.co.ais.domain.gm.VendorMaster;
import th.co.ais.domain.pt.Mpt004Srch;
import th.co.ais.service.pt.IPTaxMasterService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.pt.bean.SEMMPT005Bean;
import th.co.ais.web.util.LOVCacheUtil;
import th.co.ais.web.util.ProvinceCacheUtil;
import th.co.ais.web.util.RegionCacheUtil;
import th.co.ais.web.util.SemUtils;

public class SEMMPT005Action extends AbstractAction{

	private Logger log = Logger.getLogger(getClass());
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if(methodWithNavi.equalsIgnoreCase("doSearch")){
			flag = doSearch();
		}else if(methodWithNavi.equalsIgnoreCase("doDefaultChqDtFrom")){
			flag = doDefaultChqDtFrom();
		}else if(methodWithNavi.equalsIgnoreCase("doDefaultChqDtTo")){
			flag = doDefaultChqDtTo();
		}else if(methodWithNavi.equalsIgnoreCase("doDefaultTransferDtFrom")){
			flag = doDefaultTransferDtFrom();
		}else if(methodWithNavi.equalsIgnoreCase("doDefaultTransferDtTo")){
			flag = doDefaultTransferDtTo();
		}else if(methodWithNavi.equalsIgnoreCase("doDefaultPaymentDtFrom")){
			flag = doDefaultPaymentDtFrom();
		}else if(methodWithNavi.equalsIgnoreCase("doDefaultPaymentDtTo")){
			flag = doDefaultPaymentDtTo();
		}else if(methodWithNavi.equalsIgnoreCase("doDefaultEstimateDtFrom")){
			flag = doDefaultEstimateDtFrom();
		}else if(methodWithNavi.equalsIgnoreCase("doDefaultEstimateDtTo")){
			flag = doDefaultEstimateDtTo();
		}else if(methodWithNavi.equalsIgnoreCase("doClear")){
			flag = doClear();
		}
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		SEMMPT005Bean semmpt005Bean = new SEMMPT005Bean();
		semmpt005Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmpt005Bean.setpTaxPayTypeList(getLovItemsByType(ELovType.T_PT_PROPERTY_TAX_PAY_TYPE.name));
		semmpt005Bean.setExpenseTypeList(getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name, EX_IN, "PROPERTY_TAX", null, null));
		semmpt005Bean.setPaymentTypeList(getLovItemsByType(ELovType.T_CT_PAYMENT_TYPE.name));
		semmpt005Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
		semmpt005Bean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList());
		semmpt005Bean.setAmphurList(getEmptyDropDown());
		semmpt005Bean.setGovtList(getEmptyDropDown());
		semmpt005Bean.setPaymentStatusList(getLovItemsByType(ELovType.T_CT_PAYMENT_STATUS.name));
		semmpt005Bean.setMpt004Srch(new Mpt004Srch());
		semmpt005Bean.getMpt004Srch().setEstimateFlag("02");
		semmpt005Bean.setTmpPayGovtFlag(true);
		List<SelectItem> listYearSelect = SemUtils.getYearSelect();
		semmpt005Bean.setpTaxYearFromList(listYearSelect);
    	semmpt005Bean.setpTaxYearToList(listYearSelect);
		setSemmpt005Bean(semmpt005Bean);
//		doAddYearDropDown();
		doAddPeriodNoDropDown();
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

	private SEMMPT005Bean semmpt005Bean;
	
	public SEMMPT005Bean getSemmpt005Bean() {
		return (SEMMPT005Bean)getFacesUtils().getSessionMapValue("semmpt005Bean");
	}

	public void setSemmpt005Bean(SEMMPT005Bean semmpt005Bean) {
		this.semmpt005Bean = semmpt005Bean;
		getFacesUtils().setSessionMapValue("semmpt005Bean", semmpt005Bean);
	}
	
	public void doAddYearDropDown(){
		semmpt005Bean = getSemmpt005Bean();
		SelectItem selItem = null;
		Date dt = new Date();
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy", Locale.ENGLISH);
        Integer tmpPTaxYear = Integer.parseInt(dateformatter.format(dt));
        Integer tmpPTaxYearThai = Integer.parseInt(dateformatter.format(dt));
        List<SelectItem> list = new LinkedList<SelectItem>();
        selItem = new SelectItem("" , msg("value.selectItem"));
		list.add(selItem);
		setSemmpt005Bean(semmpt005Bean);
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
        	semmpt005Bean.setpTaxYearFromList(list);
        	semmpt005Bean.setpTaxYearToList(list);
        }
        setSemmpt005Bean(semmpt005Bean);
	}
	
	public void doAddPeriodNoDropDown(){
		semmpt005Bean = getSemmpt005Bean();
		SelectItem selItem = null;
		Integer tmpPeriodNo = 1;
		List<SelectItem> list = new LinkedList<SelectItem>();
		selItem = new SelectItem("" , msg("value.selectItem"));
		list.add(selItem);
		setSemmpt005Bean(semmpt005Bean);
		for(int i=0; i<12 ; i++){
			selItem = new SelectItem();
			if(i == 0){
				selItem.setLabel(String.valueOf(tmpPeriodNo));
	        	selItem.setValue(tmpPeriodNo);
	        	list.add(selItem);
	        	semmpt005Bean.setPeriodFromList(list);
	        	semmpt005Bean.setPeriodToList(list);
			}else{
				tmpPeriodNo = tmpPeriodNo+1;
				selItem.setLabel(String.valueOf(tmpPeriodNo));
	        	selItem.setValue(tmpPeriodNo);
	        	list.add(selItem);
	        	semmpt005Bean.setPeriodFromList(list);
	        	semmpt005Bean.setPeriodToList(list);
			}
		}
		setSemmpt005Bean(semmpt005Bean);		
	}
	
	public boolean doSearch(){
		boolean flag = false;
		semmpt005Bean = getSemmpt005Bean();
		semmpt005Bean.setRenderedMsgFormSearch(true);
		if(!validateSearch()){
			return flag;
		}
		IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
		List<Mpt004Srch> to = null;
		semmpt005Bean.setMpt004SrchList(new ArrayList<WrapperBeanObject<Mpt004Srch>>());		
		if(semmpt005Bean.isChkPayGovtFlag()){
			semmpt005Bean.getMpt004Srch().setPicoFlag("Y");
		}else{
			semmpt005Bean.getMpt004Srch().setPicoFlag("N");
		}
		if(semmpt005Bean.isTmpPayGovtFlag()){
			semmpt005Bean.getMpt004Srch().setPayGovtFlag("Y");
		}
		else{
			semmpt005Bean.getMpt004Srch().setPayGovtFlag("N");
		}
		try {
			to = pTaxMasterService.querySPList(EQueryName.SP_MPT004_SRCH.name, semmpt005Bean.getMpt004Srch());
			if(to == null || to.isEmpty()){
				semmpt005Bean.setRenderedMsgDataNotFound(true);
			}else{
				semmpt005Bean.setRenderedMsgDataNotFound(false);
				for(int i=0; i<to.size(); i++){
					Mpt004Srch mpt004Srch = (Mpt004Srch)to.get(i);
					 WrapperBeanObject<Mpt004Srch> tmpWrapperBean = new WrapperBeanObject<Mpt004Srch>();
					 if(mpt004Srch.getChqDt() != null){
						 mpt004Srch.setChqDt(SEMDataUtility.convertToThYear(mpt004Srch.getChqDt()));
						}
						if(mpt004Srch.getChqReceiveDt() != null){
							mpt004Srch.setChqReceiveDt(SEMDataUtility.convertToThYear(mpt004Srch.getChqReceiveDt()));
						}
						if(mpt004Srch.getTransferDt() != null){
							mpt004Srch.setTransferDt(SEMDataUtility.convertToThYear(mpt004Srch.getTransferDt()));
						}
						if(mpt004Srch.getExportDt() != null){
							mpt004Srch.setExportDt(SEMDataUtility.convertToThYear(mpt004Srch.getExportDt()));
						}
						if(mpt004Srch.getpTaxYear() != null){
							mpt004Srch.setpTaxYear(mpt004Srch.getpTaxYear()+543);
						}
					tmpWrapperBean.setDataObj(mpt004Srch);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					semmpt005Bean.getMpt004SrchList().add(tmpWrapperBean);
				}
			}
			setSemmpt005Bean(semmpt005Bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			addMessageError(("E0004"));
		}
		return flag;
	}
	
	private boolean validateSearch() {
		boolean flagValid = true;
		if(StringUtils.isEmpty(getSemmpt005Bean().getMpt004Srch().getCompany())){
			addMessageError("W0001", msg("message.company"));
			flagValid = false;
		}
//		if(StringUtils.isEmpty(getSemmpt005Bean().getMpt004Srch().getContractNo())){
//			addMessageError("W0001", msg("message.contractNo"));
//			flagValid = false;
//		}
		
		Date chqDtFrom = getSemmpt005Bean().getMpt004Srch().getChqDtFrom();
		Date chqDtTo = getSemmpt005Bean().getMpt004Srch().getChqDtTo();
		Date transferDtFrom = getSemmpt005Bean().getMpt004Srch().getTransferDtFrom();
		Date transferDtTo = getSemmpt005Bean().getMpt004Srch().getTransferDtTo();
		Date paymentDtFrom = getSemmpt005Bean().getMpt004Srch().getPaymentDtFrom();
		Date paymentDtTo = getSemmpt005Bean().getMpt004Srch().getPaymentDtTo();
		Date estimateDtFrom = getSemmpt005Bean().getMpt004Srch().getEstimateDtFrom();
		Date estimateDtTo = getSemmpt005Bean().getMpt004Srch().getEstimateDtTo();
		try{
			log.info("chqDtFrom" + chqDtFrom);
			log.info("chqDtTo" + chqDtTo);
			log.info("transferDtFrom" + transferDtFrom);
			log.info("transferDtTo" + transferDtTo);
			log.info("paymentDtFrom" + paymentDtFrom);
			log.info("paymentDtTo" + paymentDtTo);
			log.info("estimateDtFrom" + estimateDtFrom);
			log.info("estimateDtTo" + estimateDtTo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(chqDtFrom != null && chqDtTo != null){
			if(chqDtFrom.after(chqDtTo)){
				addMessageErrorWithArgument("W0006" ,msg("message.chqDtFrom"), msg("massage.dateTo"));
				flagValid = false;
			}
		}
		if(transferDtFrom != null && transferDtTo != null){
			if(transferDtFrom.after(transferDtTo)){
				addMessageErrorWithArgument("W0006" ,msg("message.transferDtFrom"), msg("massage.dateTo"));
				flagValid = false;
			}
		}
		if(paymentDtFrom != null && paymentDtTo != null){
			if(paymentDtFrom.after(paymentDtTo)){
				addMessageErrorWithArgument("W0006" ,msg("message.propertyPaymentDtFrom"), msg("massage.dateTo"));
				flagValid = false;
			}
		}
		if(estimateDtFrom != null && estimateDtTo != null){
			if(estimateDtFrom.after(estimateDtTo)){
				addMessageErrorWithArgument("W0006" ,msg("message.estimateDtFrom"), msg("massage.dateTo"));
				flagValid = false;
			}
		}
		return flagValid;
	}
	
	private boolean doDefaultChqDtFrom(){
		boolean flag = false;
		semmpt005Bean  = getSemmpt005Bean();
		
		Date chqDtFrom = getSemmpt005Bean().getMpt004Srch().getChqDtFrom();
		Date chqDtTo = getSemmpt005Bean().getMpt004Srch().getChqDtTo();
		
		if(chqDtFrom != null){
			if(chqDtTo == null){
				semmpt005Bean.getMpt004Srch().setChqDtTo(chqDtFrom);
			}
		}else{
			semmpt005Bean.getMpt004Srch().setChqDtTo(null);
		}
		
		return flag;
	}
	
	private boolean doDefaultChqDtTo(){
		boolean flag = false;
		semmpt005Bean  = getSemmpt005Bean();
		
		Date chqDtFrom = getSemmpt005Bean().getMpt004Srch().getChqDtFrom();
		Date chqDtTo = getSemmpt005Bean().getMpt004Srch().getChqDtTo();
		
		if(chqDtTo != null){
			if(chqDtFrom == null){
				semmpt005Bean.getMpt004Srch().setChqDtFrom(chqDtTo);
			}
		}else{
			semmpt005Bean.getMpt004Srch().setChqDtFrom(null);
		}
		
		return flag;
	}
	
	private boolean doDefaultTransferDtFrom(){
		boolean flag = false;
		semmpt005Bean  = getSemmpt005Bean();
		
		Date transferDtFrom = getSemmpt005Bean().getMpt004Srch().getTransferDtFrom();
		Date transferDtTo = getSemmpt005Bean().getMpt004Srch().getTransferDtTo();
		
		if(transferDtFrom != null){
			if(transferDtTo == null){
				semmpt005Bean.getMpt004Srch().setTransferDtTo(transferDtFrom);
			}
		}else{
			semmpt005Bean.getMpt004Srch().setTransferDtTo(null);
		}
		
		return flag;
	}
	
	private boolean doDefaultTransferDtTo(){
		boolean flag = false;
		semmpt005Bean  = getSemmpt005Bean();
		
		Date transferDtFrom = getSemmpt005Bean().getMpt004Srch().getTransferDtFrom();
		Date transferDtTo = getSemmpt005Bean().getMpt004Srch().getTransferDtTo();
		
		if(transferDtTo != null){
			if(transferDtFrom == null){
				semmpt005Bean.getMpt004Srch().setTransferDtFrom(transferDtTo);
			}
		}else{
			semmpt005Bean.getMpt004Srch().setTransferDtFrom(null);
		}
		
		return flag;
	}
	
	private boolean doDefaultPaymentDtFrom(){
		boolean flag = false;
		semmpt005Bean  = getSemmpt005Bean();
		
		Date paymentDtFrom = getSemmpt005Bean().getMpt004Srch().getPaymentDtFrom();
		Date paymentDtTo = getSemmpt005Bean().getMpt004Srch().getPaymentDtTo();
		
		if(paymentDtFrom != null){
			if(paymentDtTo == null){
				semmpt005Bean.getMpt004Srch().setPaymentDtTo(paymentDtFrom);
			}
		}else{
			semmpt005Bean.getMpt004Srch().setPaymentDtTo(null);
		}
		
		return flag;
	}
	
	private boolean doDefaultPaymentDtTo(){
		boolean flag = false;
		semmpt005Bean  = getSemmpt005Bean();
		
		Date paymentDtFrom = getSemmpt005Bean().getMpt004Srch().getPaymentDtFrom();
		Date paymentDtTo = getSemmpt005Bean().getMpt004Srch().getPaymentDtTo();
		
		if(paymentDtTo != null){
			if(paymentDtFrom == null){
				semmpt005Bean.getMpt004Srch().setPaymentDtFrom(paymentDtTo);
			}
		}else{
			semmpt005Bean.getMpt004Srch().setPaymentDtFrom(null);
		}
		
		return flag;
	}
	
	private boolean doDefaultEstimateDtFrom(){
		boolean flag = false;
		semmpt005Bean  = getSemmpt005Bean();
		
		Date estimateDtFrom = getSemmpt005Bean().getMpt004Srch().getEstimateDtFrom();
		Date estimateDtTo = getSemmpt005Bean().getMpt004Srch().getEstimateDtTo();
		
		if(estimateDtFrom != null){
			if(estimateDtTo == null){
				semmpt005Bean.getMpt004Srch().setEstimateDtTo(estimateDtFrom);
			}
		}else{
			semmpt005Bean.getMpt004Srch().setEstimateDtTo(null);
		}
		
		return flag;
	}
	
	private boolean doDefaultEstimateDtTo(){
		boolean flag = false;
		semmpt005Bean  = getSemmpt005Bean();
		
		Date estimateDtFrom = getSemmpt005Bean().getMpt004Srch().getEstimateDtFrom();
		Date estimateDtTo = getSemmpt005Bean().getMpt004Srch().getEstimateDtTo();
		
		if(estimateDtTo != null){
			if(estimateDtFrom == null){
				semmpt005Bean.getMpt004Srch().setEstimateDtFrom(estimateDtTo);
			}
		}else{
			semmpt005Bean.getMpt004Srch().setEstimateDtFrom(null);
		}
		
		return flag;
	}
	
	public boolean doClear(){
		boolean flag = false;
		semmpt005Bean = getSemmpt005Bean();
		semmpt005Bean.setMpt004Srch(new Mpt004Srch());
		semmpt005Bean.setMpt004SrchList(new ArrayList());
		semmpt005Bean.setRenderedMsgDataNotFound(false);
		setSemmpt005Bean(semmpt005Bean);
		return flag;
	}
	
	public void selectAllRow(){
		try{
			boolean chkAll = getSemmpt005Bean().isChkSelAll();
			List<WrapperBeanObject<Mpt004Srch>> detailList = new ArrayList<WrapperBeanObject<Mpt004Srch>>();
			detailList = getSemmpt005Bean().getMpt004SrchList();
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
		getSemmpt005Bean().setTmpRowId(rowId);
		
		if(isCheckSELBox())
			getSemmpt005Bean().setDisabledBtnExport(false);
		else
			getSemmpt005Bean().setDisabledBtnExport(true);
	}
	
	private boolean isCheckSELBox(){
		boolean isCheck = false;
		List<WrapperBeanObject<Mpt004Srch>> mpt003SrchSP = getSemmpt005Bean().getMpt004SrchList();
		for (WrapperBeanObject<Mpt004Srch> wrapperBeanObject : mpt003SrchSP) {
			if(wrapperBeanObject.isCheckBox()){
				return true;
			}
		}
		return isCheck;
	}
	
	public void renderProvinceList(){
		semmpt005Bean = getSemmpt005Bean();
		String samRegion = semmpt005Bean.getMpt004Srch().getRegionIn();
		Object[] objSamRegions = {samRegion};
		semmpt005Bean.setProvinceList(this.getProvinceBySamRegion(objSamRegions));
		setSemmpt005Bean(semmpt005Bean);
	}
	
	public void renderAmphurList(){
		semmpt005Bean = getSemmpt005Bean();
		Province province = new Province();
		province.setRowId(semmpt005Bean.getMpt004Srch().getProvince());
		semmpt005Bean.setAmphurList(this.getAmphurByProvince(province));
		setSemmpt005Bean(semmpt005Bean);
	}
	
	public void renderGovtList(){
		semmpt005Bean = getSemmpt005Bean();
		VendorMaster vendorMaster = new VendorMaster();
		vendorMaster.setRecordStatus("Y");
		vendorMaster.setPtaxFlag("Y");
		vendorMaster.setProvince(semmpt005Bean.getMpt004Srch().getProvince());
		semmpt005Bean.setGovtList(this.getGovtByProvince(vendorMaster));
		setSemmpt005Bean(semmpt005Bean);
	}
	
	public void doDefaultPtaxYearFrom(){
		semmpt005Bean = getSemmpt005Bean();
		if(semmpt005Bean.getMpt004Srch().getpTaxYearFrom() != null || !StringUtils.isEmpty(semmpt005Bean.getMpt004Srch().getpTaxYearFrom())){
			semmpt005Bean.getMpt004Srch().setpTaxYearTo(semmpt005Bean.getMpt004Srch().getpTaxYearFrom());
		}
		setSemmpt005Bean(semmpt005Bean);
	}
	
	public void getRowIdOnClick() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemmpt005Bean().setTmpRowId(rowId);
	}
}
