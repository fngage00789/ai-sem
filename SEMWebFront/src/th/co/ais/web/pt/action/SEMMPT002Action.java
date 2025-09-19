package th.co.ais.web.pt.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.gm.Province;
import th.co.ais.domain.gm.VendorMaster;
import th.co.ais.domain.pt.Mpt002SrchHist;
import th.co.ais.domain.pt.Mpt002Edt;
import th.co.ais.domain.pt.Mpt002Srch;
import th.co.ais.service.pt.IPTaxMasterService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.pt.bean.SEMMPT002Bean;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.ProvinceCacheUtil;
import th.co.ais.web.util.RegionCacheUtil;
import th.co.ais.web.util.SemUtils;

public class SEMMPT002Action extends AbstractAction{

	private Logger log = Logger.getLogger(getClass());

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if(methodWithNavi.equalsIgnoreCase("doSearch")){
			flag = doSearch();
		}else if (methodWithNavi.equalsIgnoreCase("doClearSession")) {
			flag = doClearSession();
		}else if (methodWithNavi.equalsIgnoreCase("doUpdate")) {
			flag = doUpdate();
		}else if(methodWithNavi.equalsIgnoreCase("doShow")){
			flag = doShow();
		}else if (methodWithNavi.equalsIgnoreCase("doBackPage")) {
			flag = doBackPage();
		}
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		SEMMPT002Bean semmpt002Bean = new SEMMPT002Bean();
		semmpt002Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmpt002Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
		semmpt002Bean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList());
		semmpt002Bean.setAmphurList(getEmptyDropDown());
		semmpt002Bean.setGovtList(getEmptyDropDown());
		semmpt002Bean.setpTaxPayTypeList(getLovItemsByType(ELovType.T_PT_PROPERTY_TAX_PAY_TYPE.name));
		semmpt002Bean.setMpt002Srch(new Mpt002Srch());
		semmpt002Bean.setMpt002Edt(new Mpt002Edt());
		semmpt002Bean.setMpt002SrchHist(new Mpt002SrchHist());
		semmpt002Bean.getMpt002Srch().setpTaxStatus("01");
		semmpt002Bean.getMpt002Srch().setpTaxPayType("01");
		semmpt002Bean.setTmpGroup1(true);
		semmpt002Bean.setTmpGroup2(true);
		semmpt002Bean.setChkPayGovtFlag(true);
		List<SelectItem> listYearSelect = SemUtils.getYearSelect();
		semmpt002Bean.setpTaxYearFromList(listYearSelect);
    	semmpt002Bean.setpTaxYearToList(listYearSelect);
		setSemmpt002Bean(semmpt002Bean);
//		doAddYearDropDown();
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private SEMMPT002Bean semmpt002Bean;
	
	public SEMMPT002Bean getSemmpt002Bean() {
		return (SEMMPT002Bean)getFacesUtils().getSessionMapValue("semmpt002Bean");
	}

	public void setSemmpt002Bean(SEMMPT002Bean semmpt002Bean) {
		this.semmpt002Bean = semmpt002Bean;
		getFacesUtils().setSessionMapValue("semmpt002Bean", semmpt002Bean);
	}
	
	public void doAddYearDropDown(){
		semmpt002Bean = getSemmpt002Bean();
		SelectItem selItem = null;
		Date dt = new Date();
		Calendar date = Calendar.getInstance();
		date.set(Calendar.YEAR, date.get(Calendar.YEAR)+1);
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy", Locale.ENGLISH);
        Integer tmpPTaxYear = Integer.parseInt(dateformatter.format(date.getTime()));
        Integer tmpPTaxYearThai = Integer.parseInt(dateformatter.format(date.getTime()));
        List<SelectItem> list = new LinkedList<SelectItem>();
        selItem = new SelectItem("" , msg("value.selectItem"));
		list.add(selItem);
		setSemmpt002Bean(semmpt002Bean);
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
        	semmpt002Bean.setpTaxYearFromList(list);
        	semmpt002Bean.setpTaxYearToList(list);
        }
        setSemmpt002Bean(semmpt002Bean);
	}
	
	public boolean doSearch(){
		boolean flag = false;
		semmpt002Bean = getSemmpt002Bean();
		if(!validateSearch()){
			getSemmpt002Bean().setRenderedMsgFormTop(true);
			semmpt002Bean.setRenderedMsgFormMiddle(false);
			return flag;
		}
		IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
		List<Mpt002Srch> to = null;
		int countRenderedChkAll = 0;
		semmpt002Bean.setMpt002SrchList(new ArrayList<WrapperBeanObject<Mpt002Srch>>());
		if(semmpt002Bean.isChkPayGovtFlag()){
			semmpt002Bean.getMpt002Srch().setPayGovtFlag("Y");
		}else{
			semmpt002Bean.getMpt002Srch().setPayGovtFlag("N");
		}
		try {
			to = pTaxMasterService.querySPList(EQueryName.SP_MPT002_SRCH.name, semmpt002Bean.getMpt002Srch());
			if (null == to || to.isEmpty() || to.size() == 0) {
				semmpt002Bean.setRenderedMsgDataNotFound(true);
				semmpt002Bean.setChkSelAll(false);
				getSemmpt002Bean().setDisabledBtnExport(true);
			}else{
				semmpt002Bean.setRenderedMsgDataNotFound(false);
				 for(int i=0; i<to.size(); i++){
					 Mpt002Srch mpt002Srch = (Mpt002Srch)to.get(i);
					 WrapperBeanObject<Mpt002Srch> tmpWrapperBean = new WrapperBeanObject<Mpt002Srch>();
					 
					 mpt002Srch.setRenderCheckbox(true);
					 mpt002Srch.setRenderLinkVendor(false);
						if(mpt002Srch.getContractEffDt() != null){
							mpt002Srch.setContractEffDt(SEMDataUtility.convertToThYear(mpt002Srch.getContractEffDt()));
						}
						if(mpt002Srch.getContractExpDt() != null){
							mpt002Srch.setContractExpDt(SEMDataUtility.convertToThYear(mpt002Srch.getContractExpDt()));
						}
						if(mpt002Srch.getpTaxStartDt() != null){
							mpt002Srch.setpTaxStartDt(SEMDataUtility.convertToThYear(mpt002Srch.getpTaxStartDt()));
						}
						if(mpt002Srch.getpTaxEndDt() != null){
							mpt002Srch.setpTaxEndDt(SEMDataUtility.convertToThYear(mpt002Srch.getpTaxEndDt()));
						}
						if(mpt002Srch.getpTaxEstmFlag() != null && mpt002Srch.getpTaxEstmFlag().equals("N")){
							mpt002Srch.setRenderCheckbox(false);
						}else{
							countRenderedChkAll++;
						}
						mpt002Srch.setRenderLinkVendor(false);
						if(mpt002Srch.getVendorMasterId() == null || mpt002Srch.getVendorMasterId().isEmpty()){
							mpt002Srch.setRenderLinkVendor(true);
						}
						if(mpt002Srch.getpTaxYear() != null){
							mpt002Srch.setpTaxYear(mpt002Srch.getpTaxYear()+543);
						}
						if(StringUtils.isEmpty(mpt002Srch.getContractNo())){
							mpt002Srch.setRenderedContractNo(false);
						}else{
							mpt002Srch.setRenderedContractNo(true);
						}
						if(StringUtils.isEmpty(mpt002Srch.getPreContractNo())){
							mpt002Srch.setRenderedPreContractNo(false);
						}else{
							mpt002Srch.setRenderedPreContractNo(true);
						}
						tmpWrapperBean.setDataObj(mpt002Srch);
						 tmpWrapperBean.setMessage("");
						 tmpWrapperBean.setCheckBox(false);
						 semmpt002Bean.getMpt002SrchList().add(tmpWrapperBean);
				 }
			}	
			setSemmpt002Bean(semmpt002Bean);
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError(("E0003"));
		}
		
		return flag;
	}
	
	private boolean validateSearch(){
		boolean flagValid = true;
		validateRenderSearch();
		if(StringUtils.isEmpty(getSemmpt002Bean().getMpt002Srch().getCompany()) && getSemmpt002Bean().isTmpGroup1() == true){
			addMessageError(("W0001"), msg("message.company"));
			flagValid = false;
		}
		if(getSemmpt002Bean().isTmpGroup1() == true && getSemmpt002Bean().getMpt002Srch().getpTaxYearFrom() == 0){
				addMessageError(("W0001"), msg("massage.pTaxYearFrom"));
				flagValid = false;
		}
		if(getSemmpt002Bean().isTmpGroup1() == true &&
		   getSemmpt002Bean().getMpt002Srch().getpTaxYearTo() == 0){
				addMessageError(("W0001"), msg("massage.pTaxYearTo"));
				flagValid = false;
		}
		if(getSemmpt002Bean().isTmpGroup2() == true && 
			StringUtils.isEmpty(getSemmpt002Bean().getMpt002Srch().getContractNo())){
				addMessageError(("W0001"), msg("message.contractNo"));
				flagValid = false;
		}
		if(getSemmpt002Bean().isTmpGroup1() == true && StringUtils.isEmpty(getSemmpt002Bean().getMpt002Srch().getRegion())){
			addMessageError(("W0001"), msg("message.region"));
			flagValid = false;
		}
		if(getSemmpt002Bean().getMpt002Srch().getpTaxYearTo() < getSemmpt002Bean().getMpt002Srch().getpTaxYearFrom()){
			addMessageErrorWithArgument("W0006" ,("To"),msg("massage.pTaxYearFrom"));
			flagValid = false;
		}
		return flagValid;
	}
	
	public boolean doClearSession(){
		boolean flag = false;
		semmpt002Bean = getSemmpt002Bean();
		semmpt002Bean.setMpt002Srch(new Mpt002Srch());
		semmpt002Bean.setMpt002SrchList(new ArrayList());
		semmpt002Bean.setTmpGroup1(true);
		semmpt002Bean.setTmpGroup2(true);
		semmpt002Bean.getMpt002Srch().setpTaxPayType("01");
		semmpt002Bean.setRenderedMsgDataNotFound(false);
		semmpt002Bean.setChkSelAll(false);
		setSemmpt002Bean(semmpt002Bean);
		return flag;
	}
	
	public boolean doUpdate(){
		boolean flag = false;
		semmpt002Bean = getSemmpt002Bean();
		boolean flagException = true;
		String estmFlag = (String)getFacesUtils().getRequestParameter("estmFlag");
		IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
		List<Mpt002Edt> to = null;
		String rowsIdConcat = "";
		try {
			for(WrapperBeanObject<Mpt002Srch> temp : semmpt002Bean.getMpt002SrchList()){
				Mpt002Srch mpts = (Mpt002Srch)temp.getDataObj();
				
				if(temp.isCheckBox() && rowsIdConcat.equals("")){
					rowsIdConcat = mpts.getRowId();
				}
				else if(temp.isCheckBox() && !rowsIdConcat.equals("")){
					rowsIdConcat = rowsIdConcat+",".trim()+mpts.getRowId();
				}			
			}
			semmpt002Bean.getMpt002Edt().setRowId(rowsIdConcat);
			semmpt002Bean.getMpt002Edt().setEstmFlag(estmFlag);
			semmpt002Bean.getMpt002Edt().setUserId(getUserLogIn());	
			to = pTaxMasterService.querySPList(EQueryName.SP_MPT002_EDT.name, semmpt002Bean.getMpt002Edt());
			if (to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")) {
				addMessageInfo("M0001");
			}else if(to != null && !to.isEmpty()){
				FrontMessageUtils.addMessageError(to.get(0).getpRemark());
			}
			semmpt002Bean.setRenderedMsgFormTop(false);
			semmpt002Bean.setRenderedMsgFormMiddle(true);
			doSearch();
		} catch (Exception e) {
			log.error(e);
			semmpt002Bean.setRenderedMsgFormTop(true);
			semmpt002Bean.setRenderedMsgFormMiddle(false);
			addMessageError("E0001");
		}
		return flag;
	}
	
	public boolean doShow(){
		boolean flag = false;
		semmpt002Bean = getSemmpt002Bean();
		String contractNo = (String)getFacesUtils().getRequestParameter("contractNo");
		IPTaxMasterService pTaxMasterService = (IPTaxMasterService)getBean("pTaxMasterService");
		semmpt002Bean.getMpt002SrchHist().setContractNo(contractNo);
		List<Mpt002SrchHist> to = null;
		try {
			to = pTaxMasterService.querySPList(EQueryName.SP_MPT002_SRCH_HIST.name, semmpt002Bean.getMpt002SrchHist());
			if(to == null || to.isEmpty()){
				semmpt002Bean.setRenderedMsgDataNotFound(true);
				semmpt002Bean.setPopupClose(false);
			}else{
				semmpt002Bean.setRenderedMsgDataNotFound(false);
				for(Mpt002SrchHist mp : to){
					if(mp.getEstimateDt() != null){
						mp.setEstimateDt(SEMDataUtility.convertToThYear(mp.getEstimateDt()));
					}
					if(mp.getPaymentDt() != null){
						mp.setPaymentDt(SEMDataUtility.convertToThYear(mp.getPaymentDt()));
					}
					if(mp.getpTaxYear() != null){
						mp.setpTaxYear(mp.getpTaxYear()+543);
					}
				}
				semmpt002Bean.setPopupClose(true);
			}
			semmpt002Bean.setMpt002SrchHistList(to);
			setSemmpt002Bean(semmpt002Bean);
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError(("E0003"));
			semmpt002Bean.setPopupClose(false);
		}
		return flag;
	}
	
	//Start Select All Page SEMMSI005-1
	public void selectAllRow(){
		try{
			boolean chkAll = getSemmpt002Bean().isChkSelAll();
			List<WrapperBeanObject<Mpt002Srch>> detailList = new ArrayList<WrapperBeanObject<Mpt002Srch>>();
			detailList = getSemmpt002Bean().getMpt002SrchList();
			for(int i=0; i<detailList.size(); i++){
				Mpt002Srch mpts = (Mpt002Srch)detailList.get(i).getDataObj();
				if(mpts.isRenderCheckbox() == true){
					detailList.get(i).setCheckBox(chkAll);
				}
				else{
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
		log.info("tmpRowId :" + rowId);
		getSemmpt002Bean().setTmpRowId(rowId);
		if(!StringUtils.isEmpty(rowId)){
			getSemmpt002Bean().setChkSelAll(false);
		}
		if(isCheckSELBox())
			getSemmpt002Bean().setDisabledBtnExport(false);
		else
			getSemmpt002Bean().setDisabledBtnExport(true);
	}
	
	private boolean isCheckSELBox(){
		boolean isCheck = false;
		List<WrapperBeanObject<Mpt002Srch>> mpt002Srch = getSemmpt002Bean().getMpt002SrchList();
		for (WrapperBeanObject<Mpt002Srch> wrapperBeanObject : mpt002Srch) {
			if(wrapperBeanObject.isCheckBox()){
				return true;
			}
		}
		return isCheck;
	}
	
	public void validateRenderSearch(){
		semmpt002Bean = getSemmpt002Bean();
		semmpt002Bean.setTmpGroup1(true);
		semmpt002Bean.setTmpGroup2(true);
		if(!StringUtils.isEmpty(semmpt002Bean.getMpt002Srch().getCompany()) && !StringUtils.isEmpty(semmpt002Bean.getMpt002Srch().getRegion())){
			if(semmpt002Bean.getMpt002Srch().getpTaxYearFrom() != null || semmpt002Bean.getMpt002Srch().getpTaxYearFrom() > 0
				&& semmpt002Bean.getMpt002Srch().getpTaxYearTo() != null || semmpt002Bean.getMpt002Srch().getpTaxYearTo() > 0){
				semmpt002Bean.setTmpGroup2(false);
			}
		}
		if(!StringUtils.isEmpty(semmpt002Bean.getMpt002Srch().getContractNo())){
			semmpt002Bean.setTmpGroup1(false);
		}
		setSemmpt002Bean(semmpt002Bean);
	}
	
	public void renderProvinceList(){
		semmpt002Bean = getSemmpt002Bean();
		String samRegion = semmpt002Bean.getMpt002Srch().getRegion();
		Object[] objSamRegions = {samRegion};
		semmpt002Bean.setProvinceList(this.getProvinceBySamRegion(objSamRegions));
		setSemmpt002Bean(semmpt002Bean);
	}
	
	public void renderAmphurList(){
		semmpt002Bean = getSemmpt002Bean();
		Province province = new Province();
		province.setRowId(semmpt002Bean.getMpt002Srch().getProvince());
		semmpt002Bean.setAmphurList(this.getAmphurByProvince(province));
		setSemmpt002Bean(semmpt002Bean);
	}
	
	public void renderGovtList(){
		semmpt002Bean = getSemmpt002Bean();
		VendorMaster vendorMaster = new VendorMaster();
		vendorMaster.setRecordStatus("Y");
		vendorMaster.setPtaxFlag("Y");
		vendorMaster.setProvince(semmpt002Bean.getMpt002Srch().getProvince());
		semmpt002Bean.setGovtList(this.getGovtByProvince(vendorMaster));
		setSemmpt002Bean(semmpt002Bean);
	}
	
	public void doDefaultPtaxYearFrom(){
		semmpt002Bean = getSemmpt002Bean();
		if(semmpt002Bean.getMpt002Srch().getpTaxYearFrom() != null || semmpt002Bean.getMpt002Srch().getpTaxYearFrom() != 0){
			semmpt002Bean.getMpt002Srch().setpTaxYearTo(semmpt002Bean.getMpt002Srch().getpTaxYearFrom());
		}
		setSemmpt002Bean(semmpt002Bean);
	}
	
	private boolean doBackPage() {
		boolean flag = true;
		doSearch();
		return flag;
	}
	
	public void getRowIdOnClick() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemmpt002Bean().setTmpRowId(rowId);
	}
}
