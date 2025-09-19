package th.co.ais.web.el.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.el.BookBankSP;
import th.co.ais.domain.el.ELDpstCondSP;
import th.co.ais.domain.el.ELVerifyCondSP;
import th.co.ais.domain.el.ElVerifySP;
import th.co.ais.domain.el.ManagementWrapper;
import th.co.ais.domain.el.Mel014UpdatePeriod;
import th.co.ais.domain.el.SchVerMasterSP;
import th.co.ais.domain.gm.VendorMasterSP;
import th.co.ais.domain.rt.Mrt001UpdRentPay;
import th.co.ais.service.el.IManagementService;
import th.co.ais.service.rt.IRentalDetailService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.SEMConstant.MODE;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.el.bean.SEMMEL001Bean;
import th.co.ais.web.el.bean.SEMMEL014Bean;
import th.co.ais.web.util.SelectItemLOVCacheUtil;

public class SEMMEL014Action extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9198710671458104272L;
	private static final String BEAN_SEMMEL014 = "semmel014Bean";
	private Logger logger = Logger.getLogger(this.getClass());
	private SEMMEL014Bean bean; 
	
	
	private static final String ELECTRIC = "ELECTRIC";
	private static final String BAIL = "BAIL";
	private static final String AUDIT = "AUDIT";
	
	@Override
	public void init() {
		SEMMEL014Bean bean = new SEMMEL014Bean();
		setSEMMEL014Bean(bean);
	}
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		logger.debug("action : "+methodWithNavi);
		
		boolean flag = false;
		bean = getSEMMEL014Bean();
		
		if(StringUtils.equals(methodWithNavi,"initVerify" )) {
			bean.setTabIndex(ELECTRIC);
			flag = initVerify();
		}else if(StringUtils.equals(methodWithNavi, "initBail")) {
			bean.setTabIndex(BAIL);
			flag = initBail();
		}else if(StringUtils.equals(methodWithNavi,"initEdit" )) {
			flag = initEdit();
		}else if(StringUtils.equals(methodWithNavi,"doCalculate" )) {
			flag = doCalculate();
		}else if(StringUtils.equals(methodWithNavi, "doAddEditVerify")) {
			flag = doAddEditVerify();
		}else if(StringUtils.equals(methodWithNavi, "doDelete")) {
			flag = doDelete();
		}else if(StringUtils.equals(methodWithNavi, "getVerDel")) {
			flag = getVerDel();
		}else if(StringUtils.equals(methodWithNavi, "doClear")) {
			flag = doClear();
		}else if(StringUtils.equals(methodWithNavi, "doAddEditDpst")) {
			flag = doAddEditDpst();
		}else if(StringUtils.equals(methodWithNavi, "initEditDpst")) {
			flag = initEditDpst();
		}else if(StringUtils.equals(methodWithNavi, "doDeleteDpst")) {
			flag = doDeleteDpst();
		}else if(StringUtils.equals(methodWithNavi, "getDpstDel")) {
			flag = getDpstDel();
		}else if(StringUtils.equals(methodWithNavi, "initCheckPremium")) {
			flag = initCheckPremium();
			
		}else if(StringUtils.equals(methodWithNavi, "doELPrivateVerify")) {
			flag = doELPrivateVerify();
			
		}else if(StringUtils.equals(methodWithNavi, "initEditPeriod")){
			flag = initEditPeriod();
		}else if(StringUtils.equals(methodWithNavi, "doUpdatePeriod")){
			flag = doUpdatePeriod();
		}else if(StringUtils.equals(methodWithNavi, "doBackPage")){
			flag = doBackPage();
		}else if(StringUtils.equals(methodWithNavi, "doClearDpst")){
			flag = doClearDpst();
		}
		
		setSEMMEL014Bean(bean);
		if(StringUtils.equals(methodWithNavi,"initVerify" )) {
			if(StringUtils.equals(bean.getVerifySP().getPayPeriodType(), "03")) {
				bean.getVerifySP().setPeriod3("03");
				bean.getVerifySP().setPayPeriodMonth(3);
				bean.getVerifySP().setPeriod4("");
				bean.getVerifySP().setPayPeriodYear(0);
				
			}else if(StringUtils.equals(bean.getVerifySP().getPayPeriodType(), "04")) {
				bean.getVerifySP().setPeriod4("04");
				bean.getVerifySP().setPeriod3("");
				bean.getVerifySP().setPayPeriodMonth(0);
				bean.getVerifySP().setPayPeriodYear(1);
				bean.getVerifySP().setPeriodAmt(BigDecimal.ZERO);
			}else if(StringUtils.equals(bean.getVerifySP().getPayPeriodType(), "01")) {
				bean.getVerifySP().setPayPeriodMonth(0);
				bean.getVerifySP().setPayPeriodYear(0);
				bean.getVerifySP().setPeriod3("");
				bean.getVerifySP().setPeriod4("");
//				bean.getVerifySP().setUnitPriceAmtTemp(bean.getVerifyDtlList().get(0).getVerifyCondSP().getUnitPriceAmt());
				bean.getVerifySP().setPeriodAmt(BigDecimal.ZERO);	
			}else{
				bean.getVerifySP().setPeriod3("");
				bean.getVerifySP().setPeriod4("");
				bean.getVerifySP().setPayPeriodMonth(0);
				bean.getVerifySP().setPayPeriodYear(0);
			}
			setSEMMEL014Bean(bean);
			flag = doCalculate();
		}
		return flag;
	}
	
	private boolean initVerify() {
		boolean flag = true;
		try {
			bean.setVerifySP(new ELVerifyCondSP());
			IManagementService manageService = (IManagementService)getBean("managementService");
			String electricId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("electricId");
			String siteInfoId = "";
			logger.debug("electricId = "+electricId);
			
			SchVerMasterSP cri = new SchVerMasterSP(electricId);
			List<SchVerMasterSP> schVerMasterList = manageService.querySPList(EQueryName.SEM_MEL001_SCH_VER_MASTER.name, cri);
			
			
			ELVerifyCondSP verCri = new ELVerifyCondSP(electricId);
			List<ELVerifyCondSP> verifyCondSPList = manageService.querySPList(EQueryName.SEM_MEL001_SCH_VER_COND.name, verCri);
			
			List<ELVerifyCondSP> verifyDtlSPList = manageService.querySPList(EQueryName.SEM_MEL001_SCH_VER_DTL.name, verCri);
			
			List<ELVerifyCondSP> verifyHistSPList = manageService.querySPList(EQueryName.SEM_MEL001_SCH_VER_HIST.name, verCri);

			// DD Service
			if(verifyCondSPList != null && verifyCondSPList.size() > 0){
				siteInfoId = verifyCondSPList.get(0).getSiteInfoId();
			}
			if(StringUtils.isNotEmpty(siteInfoId))bean.setServiceNameList(getServiceList(siteInfoId));
			bean.setServiceCalTypeIdToCalName("");

			bean.setVerifyCondList(setWrapper(verifyCondSPList));
			bean.setVerifyDtlList(setWrapper(verifyDtlSPList));
			bean.setVerifyHistList(setWrapper(verifyHistSPList));
			bean.getVerifyCondList().get(0).getVerifyCondSP().getVerFlag();
			
			if(schVerMasterList != null && schVerMasterList.size() > 0) {
				bean.setVerMaster(schVerMasterList.get(0));
				logger.debug("company = "+bean.getVerMaster().getCompany());
			}
			
			bean.setPeriodTypeList(getLovItemsByType(ELovType.T_CT_PERIOD_TYPE.name));
			
			if(verifyCondSPList.size() == 1) {
				bean.setPayeeList(getEmptyDropDown());
				bean.setVerifySP(verifyCondSPList.get(0));
				bean.getVerifySP().setPeriodStartDt(bean.getVerifySP().getEffectiveDt());
				bean.getVerifySP().setPeriodEndDt(bean.getVerifySP().getExpireDt());
				bean.getVerifyCondList().get(0).setSelected(true);
				bean.setVendorList(getDropdownVendor(bean.getVerMaster().getContractNo(),"06"));
				setSEMMEL014Bean(bean);
				
				doRenderCheckBox(bean.getVerifySP());
			}else {
				bean.setVendorList(getEmptyDropDown());
				bean.setPayeeList(getEmptyDropDown());
			}
		/*	
			if(bean.getVerifySP().getPayPeriodType().endsWith("03")){
				bean.getVerifySP().setPeriod3("03");
				bean.getVerifySP().setPayPeriodMonth(bean.getVerifySP().getPayPeriod());
			}else if(bean.getVerifySP().getPayPeriodType().endsWith("04")){
				bean.getVerifySP().setPeriod4("04");
				bean.getVerifySP().setPayPeriodYear(bean.getVerifySP().getPayPeriod());
			}
			*/
			bean.getVerifySP().setMode(MODE.ADD);
//			logger.debug("getPayPeriod = "+bean.getVerifyCondList().get(0).getVerifyCondSP().getPayPeriod());
//			logger.debug("electricId = "+bean.getVerMaster().getElectricId());
			
			bean.setServiceNameList(getServiceList(siteInfoId));
			bean.setServiceTypeToCalList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_RT_CAL.name));
			bean.setServiceCalTypeIdToCalName(bean.getServiceTypeToCalList().get(1).getLabel().toString());
			bean.getVerifySP().setWhtRate("3");
			bean.getVerifySP().setVatRate("7");
			
			if(bean.getVerifySP().getExpireDt()==null){
				bean.getVerifySP().setPeriodEndDt(null);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
	
	private boolean initBail() {
		boolean flag = true;
		try {

			bean.setDpstConSP(new ELDpstCondSP());
			IManagementService manageService = (IManagementService)getBean("managementService");
			String electricId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("electricId");
			logger.debug("electricId = "+electricId);
			
			ELVerifyCondSP verCri = new ELVerifyCondSP(electricId);
			ELDpstCondSP dpstCri = new ELDpstCondSP(electricId);
			List<ELDpstCondSP> dpstCondSPList = manageService.querySPList(EQueryName.SEM_MEL001_SRCH_DPST_COND.name, dpstCri);
			
			List<ELDpstCondSP> verifyDtlSPList = manageService.querySPList(EQueryName.SEM_MEL001_SEARCH_DPST_DTL.name, verCri);
			
//			List<ELVerifyCondSP> verifyHistSPList = manageService.querySPList(EQueryName.SEM_MEL001_SCH_VER_HIST.name, verCri);
			bean.getDpstConSP().setVatType("03");
			bean.getDpstConSP().setVatType("03");
			bean.setDpstCondList(setWrapperDpst(dpstCondSPList));
			bean.setDpstDtlList(setWrapperDpst(verifyDtlSPList));
//			bean.setVerifyHistList(setWrapper(verifyHistSPList));
			
			bean.setPeriodTypeList(getLovItemsByType(ELovType.T_CT_PERIOD_TYPE.name));
			
			if(dpstCondSPList.size() == 1) {
				bean.setPayeeList(getEmptyDropDown());
				bean.setDpstConSP(dpstCondSPList.get(0));
				bean.getDpstCondList().get(0).setSelected(true);
				bean.setVendorList(getDropdownVendor(bean.getVerMaster().getContractNo(),"08"));
				bean.setServiceNameList(getServiceList(dpstCondSPList.get(0).getSiteInfoId()));
			}else {
				bean.setVendorList(getEmptyDropDown());
				bean.setPayeeList(getEmptyDropDown());
			}
			bean.getDpstConSP().setMode(MODE.ADD);

			
		}catch(Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag; 
	}

	
	private boolean initCheckPremium() {
		boolean flag = true;
		try {
			bean.setDpstConSP(new ELDpstCondSP());
			IManagementService manageService = (IManagementService)getBean("managementService");
			String electricId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("electricId");
			logger.debug("electricId = "+electricId);
			
			
			bean.setMeterList(getMeterList(electricId));
			bean.setElectricId(electricId);
			
			checkMeterIdFormDD();
			
		}catch(Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
	
	private List<SelectItem> getMeterList(String electricId){
		List<SelectItem> resultList = new ArrayList<SelectItem>();
		try {
			ELVerifyCondSP cri = new ELVerifyCondSP();
			cri.setElectricId(electricId);
			IManagementService manageService = (IManagementService)getBean("managementService");
			List<ELVerifyCondSP> meterList = manageService.querySPList(EQueryName.SEM_MEL001_LIST_METER.name, cri);
			
			if(meterList != null) {
				for(ELVerifyCondSP obj : meterList) {
					SelectItem item = new SelectItem();
					item.setLabel(obj.getMeterId());
					item.setValue(obj.getMeterInfoId());
					resultList.add(item);
					
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}
	
	private List<SelectItem> getDropdownVendor(String contractNo, String expenseType) {
		IManagementService manageService = (IManagementService)getBean("managementService");
		try {
			VendorMasterSP vendorCri = new VendorMasterSP();
			vendorCri.setExpanseType(expenseType);
			vendorCri.setContractNo(contractNo);
			List<VendorMasterSP> list = manageService.querySPList(EQueryName.SEM_MEL001_SEARCH_VENDOR.name, vendorCri);
			List<SelectItem> resultList = new ArrayList<SelectItem>();
			logger.debug("list size = "+list.size());
			if (list.size() != 1) {
				resultList.add(setInitDropDown());
			} else {
				
				
//				Mrt001SrchPayee mrt001SrchPayee = new Mrt001SrchPayee();
//				mrt001SrchPayee.setContractNo(semmrt001Bean.getDisplayFrmRental().getContractNo());
//				mrt001SrchPayee.setVendorMasterId(list.get(0).getVendorMasterId());
//				if (semmrt001Bean.getMode().equals("RENTAL")) {
//					mrt001SrchPayee.setExpenseType(semmrt001Bean.getRentDetail().getExpenseType());
//				} else {
//					mrt001SrchPayee.setExpenseType(semmrt001Bean.getDpstDetail().getExpenseType());
//				}
//				semmrt001Bean.setDisRentAmt(true);
//				semmrt001Bean.setDisDpstAmt(true);
				if(list.size() == 1) {
					bean.getVerifySP().setVendorMasterId(list.get(0).getVendorMasterId());
				}
				bean.setPayeeList(getDropdownPayee(list.get(0).getVendorMasterId(), bean.getVerMaster().getContractNo()));
			}
			
			for (VendorMasterSP temp : list) {
				SelectItem item = new SelectItem();
				item.setLabel(temp.getVendorName());
				item.setValue(temp.getVendorMasterId());
				resultList.add(item);
			}
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
			return getEmptyDropDown();
		}
	}
	
	
	public void checkMeterIdFormDD(){
		//initCheckPremium();
		getListShowPeriodPaymentEL();
	
	}
	private void getListShowPeriodPaymentEL() {
		IManagementService manageService = (IManagementService)getBean("managementService");
		String meterId = "";

		try {
			bean = getSEMMEL014Bean();
//			String electricId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("electricId");
//			String meterId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("incContent:frmElVerify:ddlExpenseType");
			 
			String meterIdTemp = bean.getVerifySP().getMeterId() == null ? "" : (String)bean.getVerifySP().getMeterId();
			String electricId = bean.getElectricId();
			
			for(int i=0;i<bean.getMeterList().size();i++){
				if(meterIdTemp.equals(bean.getMeterList().get(i).getValue())){
					meterId = bean.getMeterList().get(i).getLabel();
				}
			}
			
			//logger.debug("meterId = "+meterId);
			ELVerifyCondSP verCri = new ELVerifyCondSP(electricId);
			verCri.setMeterId(meterId);
			List<ELVerifyCondSP> dpstCondList = manageService.querySPList(EQueryName.SEM_MEL001_LIST_EL_PAYMENT_PRERIOD.name, verCri);
			if(dpstCondList != null){
				for(ELVerifyCondSP dpstCond : dpstCondList){
					if(dpstCond.getTermOfPaymentDt() != null){
						dpstCond.setTermOfPaymentDtStr(convertYearENtoTHStr(dpstCond.getTermOfPaymentDt()));
					}
					if(dpstCond.getFromTermOfPaymentDt() != null){
						dpstCond.setFromTermOfPaymentDtStr(convertYearENtoTHStr(dpstCond.getFromTermOfPaymentDt()));
					}
					if(dpstCond.getToTermOfPaymentDt() != null){
						dpstCond.setToTermOfPaymentDtStr(convertYearENtoTHStr(dpstCond.getToTermOfPaymentDt()));
					}
				}
			}
			setWrapper(dpstCondList);
			bean.setDpstCondList(setWrapper(dpstCondList));
			
		} catch (Exception e) {
			e.printStackTrace();
			//return "";
		}
	}

	private List<SelectItem> getDropdownPayee(String vendorMasterID ,String contractNo) {
		try {
			logger.debug("===getDropdownPayee===");
			logger.debug("vendorMasterID = "+vendorMasterID);
			logger.debug("contractNo = "+contractNo);
			IManagementService manageService = (IManagementService)getBean("managementService");
			ELVerifyCondSP cri = new ELVerifyCondSP();
			cri.setVendorMasterId(vendorMasterID);
			cri.setContractNo(contractNo);
			cri.setExpenseType("06");
			List<ELVerifyCondSP> list = manageService.querySPList(EQueryName.SEM_MEL001_SEARCH_PAYEE.name, cri);
			List<SelectItem> resultList = new ArrayList<SelectItem>();
			logger.debug("payee list = "+list.size());
			if (list.size() == 0) {
				resultList.add(setInitDropDown());
				setPayeeBookbank("VENDOR");
			}else if (list.size() == 1) {
				if(StringUtils.equals(ELECTRIC, bean.getTabIndex())) {
					bean.getVerifySP().setPayeeMasterId(list.get(0).getPayeeMasterId());
				}else if (StringUtils.equals(BAIL, bean.getTabIndex())) {
					bean.getDpstConSP().setPayeeMasterId(list.get(0).getPayeeMasterId());
				}
				setPayeeBookbank("PAYEE");
			}else {
				resultList.add(setInitDropDown());
			}
			
			for (ELVerifyCondSP temp : list) {
				SelectItem item = new SelectItem();
				item.setLabel(temp.getPayeeName());
				item.setValue(temp.getPayeeMasterId());
				resultList.add(item);
			}
			return resultList;
		}catch(Exception e) {
			e.printStackTrace();
			return getEmptyDropDown();
		}
	}
	
	private List<ManagementWrapper> setWrapper(List<ELVerifyCondSP> list){
		List<ManagementWrapper> result = new ArrayList<ManagementWrapper>();
		try {
			for(ELVerifyCondSP obj : list) {
				ManagementWrapper wrapper = new ManagementWrapper(obj);
				result.add(wrapper);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private List<ManagementWrapper> setWrapperDpst(List<ELDpstCondSP> list){
		List<ManagementWrapper> result = new ArrayList<ManagementWrapper>();
		try {
			for(ELDpstCondSP obj : list) {
				ManagementWrapper wrapper = new ManagementWrapper(obj);
				result.add(wrapper);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void chkPayPeriodType() {
		String type = (String)getFacesUtils().getRequestParameter("type");
		bean = getSEMMEL014Bean();
		logger.debug("type = "+type);
		
			if ("1".equals(type)) {
//				if ("05".equals(bean.getVerifySP().getPeriod())) {
//					semmrt001Bean.getRentDetail().setTotPeriodNo(new Integer(1));
//				} else {
//					semmrt001Bean.getRentDetail().setTotPeriodNo(null);
//				}
				bean.getVerifySP().setPeriod3("");
				bean.getVerifySP().setPeriod4("");
				bean.getVerifySP().setPayPeriodMonth(0);
				bean.getVerifySP().setPayPeriodYear(0);
//				bean.getVerifySP().setPayPeriodType(semmrt001Bean.getPeriod());
//				LOG.debug("semmrt001Bean.getPeriod() = "+semmrt001Bean.getPeriod());
				//calculate Period Amt
//				if("01".equals(semmrt001Bean.getPeriod())){
//					semmrt001Bean.getRentDetail().setPeriodAmt(calShraePeriodAmt(semmrt001Bean.getRentDetail().getAmtPerMonth(), semmrt001Bean.getRentDetail().getCntVendor()));
//				}else if("02".equals(semmrt001Bean.getPeriod())){
//					semmrt001Bean.getRentDetail().setPeriodAmt(calShraePeriodAmt(semmrt001Bean.getRentDetail().getAmtPerYear(), semmrt001Bean.getRentDetail().getCntVendor()));
//				}else if ("05".equals(semmrt001Bean.getPeriod())){
//					semmrt001Bean.getRentDetail().setPeriodAmt(calShraePeriodAmt(semmrt001Bean.getRentDetail().getAmtOneTime(), semmrt001Bean.getRentDetail().getCntVendor()));
//				}else{
//					semmrt001Bean.getRentDetail().setPeriodAmt(semmrt001Bean.getRentDetail().getRentalAmt());
//				}
			} else if ("2".equals(type)) {
//				semmrt001Bean.setDisMonth(false);
				bean.getVerifySP().setPeriod("");
				bean.getVerifySP().setPeriod4("");
				bean.getVerifySP().setPayPeriodYear(0);
				bean.getVerifySP().setPayPeriodType(bean.getVerifySP().getPeriod3());
//				System.out.println("value Test"+semmrt001Bean.getRentDetail().getAmtPerMonth()+"  :: "+semmrt001Bean.getPayPeriodMonth()+" :: "+semmrt001Bean.getRentDetail().getCntVendor());
//				//calculate Period Amt
//				if("03".equals(semmrt001Bean.getPeriod3()) && semmrt001Bean.getPayPeriodMonth() != null && semmrt001Bean.getRentDetail().getAmtPerMonth() != null){
//					semmrt001Bean.getRentDetail().setPeriodAmt(calShraePeriodAmt(semmrt001Bean.getRentDetail().getAmtPerMonth()*semmrt001Bean.getPayPeriodMonth(), semmrt001Bean.getRentDetail().getCntVendor()));
//				}
				
			} else if ("3".equals(type)) {
//				semmrt001Bean.setDisMonth(true);
				bean.getVerifySP().setPeriod("");
				bean.getVerifySP().setPeriod3("");
				bean.getVerifySP().setPayPeriodMonth(0);
				bean.getVerifySP().setPayPeriodType(bean.getVerifySP().getPeriod4());
//				LOG.debug("semmrt001Bean.getPeriod3() = "+semmrt001Bean.getPeriod4());
//				//calculate Period Amt
//				if("04".equals(semmrt001Bean.getPeriod4()) && semmrt001Bean.getPayPeriodYear() != null && semmrt001Bean.getRentDetail().getAmtPerYear() != null){
//					semmrt001Bean.getRentDetail().setPeriodAmt(calShraePeriodAmt(semmrt001Bean.getRentDetail().getAmtPerYear()*semmrt001Bean.getPayPeriodYear(), semmrt001Bean.getRentDetail().getCntVendor()));
//				}
			}
//			
//		LOG.debug("semmrt001Bean.getModeRentalDetail() = "+semmrt001Bean.getModeRentalDetail());
////		if (semmrt001Bean.getModeRentalDetail().equals("ADD")) {
////			semmrt001Bean.setPayPeriodMonth(0);
////			semmrt001Bean.setPayPeriodYear(0);
////		}
//		LOG.debug("semmrt001Bean.getPayPeriodMonth() = "+semmrt001Bean.getPayPeriodMonth());
//		LOG.debug("semmrt001Bean.getPayPeriodYear() = "+semmrt001Bean.getPayPeriodYear());
//		System.out.println("period "+semmrt001Bean.getRentDetail().getPeriodAmt());
//		setSemmrt001Bean(semmrt001Bean);
			logger.debug("period Type = "+bean.getVerifySP().getPayPeriodType());
			logger.debug("period month = "+bean.getVerifySP().getPayPeriodMonth());
			logger.debug("period year = "+bean.getVerifySP().getPayPeriodYear());
	}
	
	private boolean initEdit() {
		logger.debug("=== initEdit ===");
		try {
			int row = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedRow"));
			bean = getSEMMEL014Bean();
			
			bean.setServiceCalTypeId(bean.getVerifyDtlList().get(0).getVerifyCondSP().getServiceId());
			bean.setServiceCalTypeIdToCalName(bean.getVerifyDtlList().get(0).getVerifyCondSP().getElectricCalDesc());
			bean.setServiceCalTypeIdToCal(bean.getVerifyDtlList().get(0).getVerifyCondSP().getElectricCalCode());
			
			String electricDetailId = bean.getVerifyDtlList().get(0).getVerifyCondSP().getElectricDetailId();
			String electricId = bean.getVerifyDtlList().get(0).getVerifyCondSP().getElectricId();
			String electricUseType = bean.getVerifyDtlList().get(0).getVerifyCondSP().getElectricUseType();
				
			viewByEditMode(electricId,electricDetailId,electricUseType);
//			bean.getVerifySP().setPeriodAmt(periodAmt); getVerifyCondSPList getVerifyCondSP
			bean.setVerifySP(new ELVerifyCondSP(bean.getVerifyDtlList().get(row).getVerifyCondSP()));
			bean.getVerifySP().setMode(MODE.EDIT);
			if(bean.getVerifySP().getExpireDt()==null){
				bean.getVerifySP().setPeriodEndDt(null);
			}
			
			if(StringUtils.equals(bean.getVerifySP().getPayPeriodType(), "03")) {
				bean.getVerifySP().setPeriod3("03");
				bean.getVerifySP().setPayPeriodYear(0);
				
			}else if(StringUtils.equals(bean.getVerifySP().getPayPeriodType(), "04")) {
				bean.getVerifySP().setPeriod4("04");
				bean.getVerifySP().setPayPeriodMonth(0);
				bean.getVerifySP().setPeriodAmt(BigDecimal.ZERO);
			}else if(StringUtils.equals(bean.getVerifySP().getPayPeriodType(), "01")) {
				bean.getVerifySP().setPayPeriodMonth(0);
				bean.getVerifySP().setPayPeriodYear(0);
				bean.getVerifySP().setUnitPriceAmtTemp(bean.getVerifyDtlList().get(row).getVerifyCondSP().getUnitPriceAmt());
				bean.getVerifySP().setPeriodAmt(BigDecimal.ZERO);	
			}else{
				bean.getVerifySP().setPayPeriodMonth(0);
				bean.getVerifySP().setPayPeriodYear(0);
			}
			
			bean.setVendorList(getDropdownVendor(bean.getVerMaster().getContractNo(),"06"));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	private boolean initEditDpst() {
		logger.debug("=== initEdit ===");
		try {
			int row = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedRow"));
			bean = getSEMMEL014Bean();
			bean.setDpstConSP(new ELDpstCondSP(bean.getDpstDtlList().get(row).getDpstCondSP()));
			bean.getDpstConSP().setMode(MODE.EDIT);
			bean.getDpstConSP().setDepositTypeName(bean.getDpstConSP().getDepositType());
			
			bean.setVendorList(getDropdownVendor(bean.getVerMaster().getContractNo(),"08"));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	private boolean doCalculate() {
		bean = getSEMMEL014Bean();
		boolean vFlag = true;
		
			IManagementService manageService = (IManagementService)getBean("managementService");
			
			if(("03".equals(bean.getVerifySP().getPeriod3())) && (bean.getVerifySP().getPayPeriodMonth()>0)){
				bean.getVerifySP().setPayPeriodType(bean.getVerifySP().getPeriod3());
				bean.getVerifySP().setPayPeriod(bean.getVerifySP().getPayPeriodMonth());
				bean.getVerifySP().setPeriodMonth(new BigDecimal(0));
				bean.getVerifySP().setPeriodDay(new BigDecimal(0));
			}		
			else if (("04".equals(bean.getVerifySP().getPeriod4())) && (bean.getVerifySP().getPayPeriodYear()>0)){
				bean.getVerifySP().setPayPeriodType(bean.getVerifySP().getPeriod4());
				bean.getVerifySP().setPayPeriod(bean.getVerifySP().getPayPeriodYear());
				bean.getVerifySP().setPeriodMonth(new BigDecimal(0));
				bean.getVerifySP().setPeriodDay(new BigDecimal(0));
				
			}
			else if(("03".equals(bean.getVerifySP().getPeriod3())) && (bean.getVerifySP().getPayPeriodMonth()<=0)){
				addMessageError("W0001", msg("message.periodMonth"));
				vFlag = false;
				return vFlag;
			}else if(("04".equals(bean.getVerifySP().getPeriod4())) && (bean.getVerifySP().getPayPeriodYear()<=0)){
				addMessageError("W0001", msg("message.periodYear"));
				vFlag = false;
				return vFlag;
			}
			
			if(bean.getVerifySP().getUnitPriceAmt() != null){
				bean.getVerifySP().setUnitPriceAmtTemp(bean.getVerifySP().getUnitPriceAmt());
			}
			
//			logger.debug("takeAllAmt = "+bean.getVerifySP().getTakeAllAmt());
//			logger.debug("takeAllPeriodType = "+bean.getVerifySP().getTakeAllPeriodType());
//			logger.debug("payPeriod = "+bean.getVerifySP().getPayPeriod());
//			logger.debug("payPeriodType = "+bean.getVerifySP().getPayPeriodType());
//			logger.debug("periodYear = "+bean.getVerifySP().getPeriodYear());
//			logger.debug("periodMonth = "+bean.getVerifySP().getPeriodMonth());	
//			logger.debug("periodDay = "+bean.getVerifySP().getPeriodDay());
		
			try {
			List<ELVerifyCondSP> calList;

					calList = manageService.querySPList(EQueryName.SEM_MEL001_EL_CAL.name, bean.getVerifySP());
			
			if(calList != null && calList.size() > 0) {
				ELVerifyCondSP calObj = calList.get(0);
				
				bean.getVerifySP().setTotPeriodNo(calObj.getTotPeriodNo());
				bean.getVerifySP().setPeriodAmt(calObj.getPeriodAmt());
				
			}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return vFlag;
	}	

	private boolean doAddEditVerify() {
		try {
			IManagementService manageService = (IManagementService)getBean("managementService");
			bean.getVerifySP().setUser(getUserLogIn());
			logger.debug("verrifySP = "+bean.getVerifySP().toString());
			
			String siteInfo = bean.getVerifySP().getSiteInfoId();
	
			if(bean.getVerifySP().getMode().equalsIgnoreCase("ADD")){}
			//doGetElectricDetailId(null, siteInfo); 
			
			bean.getVerifySP().setElectricCalCode(bean.getServiceCalTypeIdToCal());
			bean.getVerifySP().setServiceId(bean.getServiceCalTypeId());

			if(validateVerifyDetail()) {
				//bean.getVerifySP().setPeriodType(bean.getVerifySP().getTakeAllPeriodType());
				
				doSetCheckBoxEntity();
				
				List<ELVerifyCondSP> resultList = manageService.querySPList(EQueryName.SEM_MEL001_INSERT_DETAIL.name, bean.getVerifySP());
				
				if(resultList != null && resultList.size() > 0) { 
					logger.debug("result = "+resultList.get(0).getResult());
					logger.debug("message = "+resultList.get(0).getMessage());
						if(resultList.get(0).getResult().equalsIgnoreCase("SUCCESS")){
							// CAll SEM_SP_MEL001_EL_CAL_DETAIL
							doGetElectricDetailId(resultList.get(0).getMessage(), siteInfo); 
						}
				} 
				
				bean.setVerifySP(new ELVerifyCondSP());
				bean.setVendorList(getEmptyDropDown());
				bean.setPayeeList(getEmptyDropDown());
				bean.getVerifySP().setMode(MODE.ADD);
				
				bean.setServiceCalTypeId("ALL"); // name service
				bean.setServiceCalTypeIdToCal("01");
				bean.setServiceCalTypeIdToCalName(bean.getServiceTypeToCalList().get(1).getLabel().toString());
				bean.setServiceTypeToCalList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_RT_CAL.name));
				
				//Load Verify DTL
				ELVerifyCondSP verCri = new ELVerifyCondSP(bean.getVerMaster().getElectricId());
				logger.debug("elId = "+bean.getVerMaster().getElectricId());
				List<ELVerifyCondSP> verDtlSPList = manageService.querySPList(EQueryName.SEM_MEL001_SCH_VER_DTL.name, verCri);
				List<ELVerifyCondSP> verCondSPList = manageService.querySPList(EQueryName.SEM_MEL001_SCH_VER_COND.name, verCri);
				bean.setVerifyDtlList(setWrapper(verDtlSPList));
				bean.setVerifyCondList(setWrapper(verCondSPList));
				
				bean.setRenderedMsgFormMiddle(true);
				addMessageInfo("M0001");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			addMessageError("E0001");
			return false;
		}
		return true;
		
	}
	
	private boolean doAddEditDpst() {
		try {
			IManagementService manageService = (IManagementService)getBean("managementService");
			logger.debug("bean.getDpstConSP().getDepositDetailId() : "+bean.getDpstConSP().getDepositDetailId());
			logger.debug("bean.getDpstConSP().getPrivateDepositId() : "+bean.getDpstConSP().getPrivateDepositId());
			logger.debug("bean.getDpstConSP().getBgMasterId() : "+bean.getDpstConSP().getBgMasterId());
			logger.debug(""+bean.getDpstConSP().getDepositDetailId());
			bean.getDpstConSP().setUser(getUserLogIn());
			bean.getDpstConSP().setNewFlag("Y");
			bean.getDpstConSP().setContractNo(bean.getVerMaster().getContractNo());
			logger.debug("dpstcCondSP = "+bean.getDpstConSP().toString());
//			if(validateVerifyDetail()) {
				List<ELDpstCondSP> resultList = manageService.querySPList(EQueryName.SEM_MEL001_INSERT_DPST.name, bean.getDpstConSP());
				if(resultList != null && resultList.size() > 0) {
					logger.debug("result = "+resultList.get(0).getResult());
					logger.debug("message = "+resultList.get(0).getMessage());
				}else {
					addMessageError("E0001");
					return false;
				}
				
				bean.setVerifySP(new ELVerifyCondSP());
				bean.setVendorList(getEmptyDropDown());
				bean.setPayeeList(getEmptyDropDown());
				bean.getVerifySP().setMode(MODE.ADD);
				
				//Load Verify DTL
				ELVerifyCondSP verCri = new ELVerifyCondSP(bean.getVerMaster().getElectricId());
				logger.debug("elId = "+bean.getVerMaster().getElectricId());
				List<ELDpstCondSP> dpstDtlSPList = manageService.querySPList(EQueryName.SEM_MEL001_SEARCH_DPST_DTL.name, verCri);
				List<ELDpstCondSP> dpstCondSPList = manageService.querySPList(EQueryName.SEM_MEL001_SRCH_DPST_COND.name, verCri);
				bean.setDpstDtlList(setWrapperDpst(dpstDtlSPList));
				bean.setDpstCondList(setWrapperDpst(dpstCondSPList));
				
				bean.setRenderedMsgFormMiddle(true);
				bean.setDpstConSP(new ELDpstCondSP());
				bean.getDpstConSP().setMode(MODE.ADD);
				addMessageInfo("M0001");
//			}
			
		}catch(Exception e) {
			e.printStackTrace();
			addMessageError("E0001");
			return false;
		}
		return true;
		
	}
	
	private boolean doClear() {
		try {
			bean.setVerifySP(new ELVerifyCondSP());
			bean.setVendorList(getEmptyDropDown());
			bean.setPayeeList(getEmptyDropDown());
			bean.getVerifySP().setMode(MODE.ADD);
			
			bean.setServiceCalTypeId("ALL"); // name service
			bean.setServiceCalTypeIdToCal("01");
			bean.setServiceCalTypeIdToCalName(bean.getServiceTypeToCalList().get(1).getLabel().toString());
			
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	private boolean doClearDpst() {
		bean = getSEMMEL014Bean();
		try {
			bean.setDpstConSP(new ELDpstCondSP());
			bean.setVendorList(getEmptyDropDown());
			bean.setPayeeList(getEmptyDropDown());
			bean.getDpstConSP().setMode(MODE.ADD);
			setSEMMEL014Bean(bean);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	private boolean validateVerifyDetail() {
		boolean vFlag = true;
		ELVerifyCondSP verConSP = bean.getVerifySP();
		Date periodStDt = verConSP.getPeriodStartDt();
		Date periodEndDt = verConSP.getPeriodEndDt();
		Date expireDt = verConSP.getExpireDt();
		
		if(verConSP.getUnitPriceAmt() == null) {
			verConSP.setUnitPriceAmt(BigDecimal.ZERO);
		}
		
		if(verConSP.getPeriodAmt() == null) {
			verConSP.setPeriodAmt(BigDecimal.ZERO);
		}
		
		if("01".equalsIgnoreCase(verConSP.getElectricOwnerType())){ //ตามจริง
			if(!verConSP.isChkNoUnitPrice()){
				if((verConSP.getPeriodAmt().doubleValue() == 0) && (verConSP.getUnitPriceAmt().doubleValue() >0 )){
					System.out.println("verConSP.getPeriodAmt  ="+verConSP.getPeriodAmt().doubleValue());
					System.out.println("verConSP.getUnitPriceAmt  ="+verConSP.getUnitPriceAmt().doubleValue());
				}else{
					//addMessageError("W0001", msg("message.periodAmt"));
					addMessageError("W0001",(msg("message.periodAmt")+" "+msg("label.or")+" "+msg("label.unitPriceAmt")+msg("label.correct")));
					vFlag = false;
				}
			}
		}
		
		if("02".equalsIgnoreCase(verConSP.getElectricOwnerType())){ //เหมาจ่าย
			if((verConSP.getPeriodAmt().doubleValue() > 0) && (verConSP.getUnitPriceAmt().doubleValue()==0 )){
				System.out.println("verConSP.getPeriodAmt  ="+verConSP.getPeriodAmt().doubleValue());
				System.out.println("verConSP.getUnitPriceAmt  ="+verConSP.getUnitPriceAmt().doubleValue());
			}else{
				addMessageError("W0001",(msg("message.periodAmt")+" "+msg("label.or")+" "+msg("label.unitPriceAmt")+msg("label.correct")));
				vFlag = false;
			}
		}
		
		if (StringUtils.isEmpty(verConSP.getVendorMasterId())) {
			addMessageError("W0001", msg("message.vendorId"));
			vFlag = false;
		}
		if(periodStDt == null) {
			addMessageError("W0001", msg("message.periodStDt"));
			vFlag = false;
		}
		
		/*if(periodEndDt == null) {
			addMessageError("W0001", msg("message.periodEndDt"));
			vFlag = false;
		}*/
		
		
		Date effDt = verConSP.getEffectiveDt();
		Date expDt = verConSP.getExpireDt();

		if(effDt != null && expDt != null){
			if (effDt.after(expDt)) {
				addMessageErrorWithArgument("W0006" ,msg("message.expireDt"), msg("message.effectDt"));
				vFlag = false;
			}
		}
		
		if(periodStDt != null && periodEndDt != null){
			if (periodStDt.after(periodEndDt)) {
				addMessageErrorWithArgument("W0006" ,msg("message.periodEndDt"), msg("message.periodStDt"));
				vFlag = false;
			}
		}
		return vFlag;
	}
	
	public boolean onChangeVendor() {
		try { 
			bean = getSEMMEL014Bean();
			logger.debug("=== onChange Vendor ===");
			bean.setPayeeList(getDropdownPayee(bean.getVerifySP().getVendorMasterId(), bean.getVerMaster().getContractNo()));
			setSEMMEL014Bean(bean);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	private void setPayeeBookbank(String mode) {
		try {
			logger.debug("=== setPayeeBookbank ===");
			logger.debug("mode = "+mode);
			IManagementService manageService = (IManagementService)getBean("managementService");
			BookBankSP cri = new BookBankSP();
			cri.setVendorMasterId(bean.getVerifySP().getVendorMasterId());
			cri.setPayeeMasterId(bean.getVerifySP().getPayeeMasterId());
			cri.setMode(mode);
			logger.debug("vendorMasterId = "+cri.getVendorMasterId());
			logger.debug("payeeMasterId = "+cri.getPayeeMasterId());
			List<BookBankSP> bookbankList =  manageService.querySPList(EQueryName.SEM_MEL001_BOOKBANK.name, cri);
			logger.debug("bookbankList size = "+bookbankList.size());
			if(bookbankList != null && bookbankList.size() > 0) {
				if(StringUtils.equals(ELECTRIC, bean.getTabIndex())) {
					bean.getVerifySP().setBankAccNo(bookbankList.get(0).getBankAccNo());
					bean.getVerifySP().setBankName(bookbankList.get(0).getBankName());
				}else if(StringUtils.equals(BAIL, bean.getTabIndex())) {
					bean.getDpstConSP().setBankAccNo(bookbankList.get(0).getBankAccNo());
					bean.getDpstConSP().setBankName(bookbankList.get(0).getBankName());
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void onChangePayee() {
		try {
			bean = getSEMMEL014Bean();
			setPayeeBookbank("PAYEE");
			setSEMMEL014Bean(bean);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doSelectedVerSetup() {
		logger.debug("===doSelectedVerSetup===");
		bean = getSEMMEL014Bean();
		try {
			String rowId = (String)getFacesUtils().getRequestParameter("rowId");
			String payPeriodType = "";

			ELVerifyCondSP verConSP = new ELVerifyCondSP();
			bean.setVerifySP(new ELVerifyCondSP());
			bean.getVerifySP().setMode(MODE.ADD);
			bean.setVendorList(getEmptyDropDown());
			bean.setPayeeList(getEmptyDropDown());
			for(ManagementWrapper wrapper : bean.getVerifyCondList()) {
				if(StringUtils.equals(rowId, wrapper.getVerifyCondSP().getRowId()) && wrapper.isSelected()) {
					
					verConSP = wrapper.getVerifyCondSP();
					verConSP.setMode(MODE.ADD);
					verConSP.setPeriodStartDt(verConSP.getEffectiveDt());
					verConSP.setPeriodEndDt(verConSP.getExpireDt());				
					bean.getVerifySP().setServiceId(verConSP.getServiceId());
					bean.setVerifySP(verConSP);
					doRenderCheckBox(bean.getVerifySP());
					bean.setVendorList(getDropdownVendor(bean.getVerMaster().getContractNo(),"06"));
				}else {
					wrapper.setSelected(false);
				}
			}

			bean.getVerifySP().setWhtRate("3");
			bean.getVerifySP().setVatRate("7");
			setSEMMEL014Bean(bean);
			logger.debug("bean.getVerifySP().getPayPeriodType() : "+bean.getVerifySP().getPayPeriodType());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean getVerDel() {
		try {
			logger.debug("=== getVerDel ===");
			int row = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedRow"));
			bean.setVerifySPDel(bean.getVerifyDtlList().get(row).getVerifyCondSP());
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	
	public boolean getDpstDel() {
		try {
			logger.debug("=== getDpstDel ===");
			int row = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedRow"));
			bean.setDpstConSPDel(bean.getDpstDtlList().get(row).getDpstCondSP());
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	
	public boolean doDelete() {
		try {
			IManagementService manageService = (IManagementService)getBean("managementService");
			bean.getVerifySPDel().setMode(MODE.DELETE);
			bean.getVerifySPDel().setUser(getUserLogIn());
			logger.debug("verrifySP = "+bean.getVerifySP().toString());
			
			
			
			List<ELVerifyCondSP> resultList = manageService.querySPList(EQueryName.SEM_MEL001_INSERT_DETAIL.name, bean.getVerifySPDel());
			if(resultList != null && resultList.size() > 0) {
				logger.debug("result = "+resultList.get(0).getResult());
				logger.debug("message = "+resultList.get(0).getMessage());
			}
			
			bean.setVerifySP(new ELVerifyCondSP());
			bean.setVendorList(getEmptyDropDown());
			bean.setPayeeList(getEmptyDropDown());
			bean.getVerifySP().setMode(MODE.ADD);
			
			//Load Verify DTL
			ELVerifyCondSP verCri = new ELVerifyCondSP(bean.getVerMaster().getElectricId());
			logger.debug("elId = "+bean.getVerMaster().getElectricId());
			List<ELVerifyCondSP> verDtlSPList = manageService.querySPList(EQueryName.SEM_MEL001_SCH_VER_DTL.name, verCri);
			List<ELVerifyCondSP> verCondSPList = manageService.querySPList(EQueryName.SEM_MEL001_SCH_VER_COND.name, verCri);
			bean.setVerifyDtlList(setWrapper(verDtlSPList));
			bean.setVerifyCondList(setWrapper(verCondSPList));
			
			bean.setRenderedMsgFormMiddle(true);
			addMessageInfo("M0001");
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean doDeleteDpst() {
		try {
			IManagementService manageService = (IManagementService)getBean("managementService");
			bean.getDpstConSPDel().setMode(MODE.DELETE);
			bean.getDpstConSPDel().setUser(getUserLogIn());
			logger.debug("verrifySP = "+bean.getDpstConSPDel().toString());
			
			List<ELDpstCondSP> resultList = manageService.querySPList(EQueryName.SEM_MEL001_INSERT_DPST.name, bean.getDpstConSPDel());
			if(resultList != null && resultList.size() > 0) {
				logger.debug("result = "+resultList.get(0).getResult());
				logger.debug("message = "+resultList.get(0).getMessage());
			}
			
			bean.setDpstConSP(new ELDpstCondSP());
			bean.setVendorList(getEmptyDropDown());
			bean.setPayeeList(getEmptyDropDown());
			bean.getDpstConSP().setMode(MODE.ADD);
			
			//Load Verify DTL
			ELVerifyCondSP verCri = new ELVerifyCondSP(bean.getVerMaster().getElectricId());
			logger.debug("elId = "+bean.getVerMaster().getElectricId());
			List<ELDpstCondSP> dpstDtlSPList = manageService.querySPList(EQueryName.SEM_MEL001_SEARCH_DPST_DTL.name, verCri);
			List<ELDpstCondSP> dpstCondSPList = manageService.querySPList(EQueryName.SEM_MEL001_SRCH_DPST_COND.name, verCri);
			bean.setDpstDtlList(setWrapperDpst(dpstDtlSPList));
			bean.setDpstCondList(setWrapperDpst(dpstCondSPList));
			
			bean.setRenderedMsgFormMiddle(true);
			addMessageInfo("M0001");
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	private SEMMEL001Bean semmel001Bean;

	public SEMMEL001Bean getSemmel001Bean() {
		
		SEMMEL001Bean bean = (SEMMEL001Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmel001Bean");
		
		if(bean == null){
			
			bean = new SEMMEL001Bean();
			
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmel001Bean", bean);
		}
		
		//return (SEMMEL006Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmel006Bean");
		return bean;
	}
	
	public void setSemmel001Bean(SEMMEL001Bean semmel001Bean) {
		this.semmel001Bean = semmel001Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmel001Bean", semmel001Bean);
	}
	
	
	private SEMMEL014Bean getSEMMEL014Bean(){
		
		SEMMEL014Bean bean = (SEMMEL014Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(BEAN_SEMMEL014);
		if(bean == null){
			
			bean = new SEMMEL014Bean();
			
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(BEAN_SEMMEL014, bean);
		}
		
		return bean;
	}
	
	private void setSEMMEL014Bean(SEMMEL014Bean semmel014Bean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(BEAN_SEMMEL014, semmel014Bean);
	}

	

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}
	
	private List<SelectItem> getServiceList(String siteInfoId){
		List<SelectItem> resultList = new ArrayList<SelectItem>();
		try {
			SEMMEL014Bean semmel014Bean = getSEMMEL014Bean();
			
			Mrt001UpdRentPay cri = new Mrt001UpdRentPay();
			cri.setSiteInfoId(siteInfoId); 
			cri.setMode("C");
			if(semmel014Bean.getServiceCalTypeId()!=null){
			cri.setServiceId(semmel014Bean.getServiceCalTypeId());
			}
			IManagementService manageService = (IManagementService)getBean("managementService");
			List<Mrt001UpdRentPay> serviceList = manageService.querySPList(EQueryName.SEM_SI_SITE_INFO_SERVICES.name, cri);
			
			if(serviceList.size() > 0) {
				SelectItem item = new SelectItem();
					item.setLabel("-- All Service --");
					item.setValue("ALL");
					resultList.add(item);
				for(Mrt001UpdRentPay obj : serviceList) {
					item = new SelectItem();
					item.setLabel(obj.getServiceName());
					item.setValue(obj.getServiceId());
					resultList.add(item);
					
				}
			}else{
				SelectItem item = new SelectItem();
				item.setLabel("-- No Service --");
				item.setValue("");
				resultList.add(item);
			}

			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}
	
	
	public void doViewValuebyEdit(){
		
		bean = getSEMMEL014Bean();
	
	}
	
	public void doChangeValue(){
		bean = getSEMMEL014Bean();
		bean.setServiceCalTypeIdToCal(bean.getServiceCalTypeIdToCal());
		String siteInfoId = bean.getVerifySP().getSiteInfoId();
		
		bean.setServiceNameListShowTbl(null);
		bean.setServiceNameListShowTbl(getConfigServiceMaster(siteInfoId,bean.getServiceCalTypeId()));
		//bean.setServiceNameListShowTbl(getConfigServiceMaster(siteInfoId,bean.getServiceCalTypeId()));
		bean.setvMessage(null);
		setSEMMEL014Bean(bean);
		
		logger.debug("test getServiceCalTypeIdToCal : "+bean.getServiceCalTypeIdToCal());
	}
	
	public void doChangeValueService(){
		
		bean = getSEMMEL014Bean();
		String siteInfoId = bean.getVerifySP().getSiteInfoId();
		bean.setServiceCalTypeIdToCal(null);
		bean.setServiceCalTypeId(bean.getServiceCalTypeId());
		bean.setServiceNameListShowTbl(getConfigServiceMaster(siteInfoId,bean.getServiceCalTypeId()));
		
		setSEMMEL014Bean(bean);
		logger.debug("test getServiceCalTypeId : "+bean.getServiceCalTypeId());
	}
 
	private List<ElVerifySP> getConfigServiceMaster(String siteInfoId, String serviceId){
		List<ElVerifySP> resultList = new ArrayList<ElVerifySP>();
		try {
			ElVerifySP cri = new ElVerifySP();
			IManagementService manageService = (IManagementService)getBean("managementService");
			cri.setServiceId(serviceId);
			cri.setSiteInfoId(siteInfoId);
			List<ElVerifySP> serviceConfig = manageService.querySPList(EQueryName.SEM_SP_MEL001_SRCH_CAL_CONFIG.name, cri);
				
			if(serviceConfig.size() > 0) {
				ElVerifySP item = new ElVerifySP();		
				for(ElVerifySP obj : serviceConfig) { 
					item = new ElVerifySP();
					item.setServiceName(obj.getServiceName());
					item.setServiceId(obj.getServiceId());
					item.setConfigRate(obj.getConfigRate());
					item.setInputAmt(obj.getInputAmt());
					item.setInputPercent(obj.getInputPercent());
					resultList.add(item);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}
	
	public boolean doSaveServiceCal(){
		boolean result = false;
		try {
			IManagementService manageService = (IManagementService)getBean("managementService");
			String serviceList = "";
			bean = getSEMMEL014Bean();
			ElVerifySP cri = new ElVerifySP();	
			
			
			cri.setRentalCalCode(bean.getServiceCalTypeIdToCal());
			cri.setPeriodAmt(String.valueOf(bean.getVerifySP().getTakeAllAmt()));
			
			
			for(int i =0;i<bean.getServiceNameListShowTbl().size();i++){
			String tmp = bean.getServiceNameListShowTbl().get(i).getServiceId();
			
			
			if(bean.serviceCalTypeIdToCal.equals("02")){
				logger.debug("InputPercent() : "+bean.getServiceNameListShowTbl().get(i).getInputPercent());
				tmp = tmp+"|"+bean.getServiceNameListShowTbl().get(i).getInputPercent()+",";
				bean.setServiceCalTypeIdToCalName(bean.getServiceTypeToCalList().get(Integer.parseInt(bean.getServiceCalTypeIdToCal())).getLabel());
			}else if(bean.serviceCalTypeIdToCal.equals("03")){	
				logger.debug("InputAmt() : "+bean.getServiceNameListShowTbl().get(i).getInputAmt());
				tmp = tmp+"|"+bean.getServiceNameListShowTbl().get(i).getInputAmt()+",";
				bean.setServiceCalTypeIdToCalName(bean.getServiceTypeToCalList().get(Integer.parseInt(bean.getServiceCalTypeIdToCal())).getLabel());
			}else if(bean.serviceCalTypeIdToCal.equals("04")){	
				logger.debug("InputAmt() : "+bean.getServiceNameListShowTbl().get(i).getConfigRate());
				tmp = tmp+"|"+bean.getServiceNameListShowTbl().get(i).getConfigRate()+",";
				bean.setServiceCalTypeIdToCalName(bean.getServiceTypeToCalList().get(Integer.parseInt(bean.getServiceCalTypeIdToCal())).getLabel());
			}
			else if(bean.serviceCalTypeIdToCal.equals("01")){	
				bean.setServiceCalTypeIdToCalName(bean.getServiceTypeToCalList().get(Integer.parseInt(bean.getServiceCalTypeIdToCal())).getLabel());
			}
				serviceList = serviceList+tmp;
			}	
			//PLY
			serviceList = serviceList.substring(0,serviceList.length()-1);
			bean.setServiceList(serviceList);
			bean.setServiceShowTbl(bean.getServiceNameListShowTbl().get(0).getServiceName());
			bean.setServiceCalTypeTbl(bean.getServiceCalTypeIdToCalName());
			logger.debug("serviceList : "+serviceList);
			cri.setServiceList(serviceList);
		
			List<ElVerifySP> recordSuccess = manageService.querySPList(EQueryName.SEM_SP_MEL001_CHK_METHOD.name, cri);
			if(recordSuccess.size() ==1 ){
				bean.setvResult(recordSuccess.get(0).getvResult());
				bean.setvMessage(recordSuccess.get(0).getvMessage());
				if((bean.getvMessage().equalsIgnoreCase("01")) || (bean.getvMessage().equalsIgnoreCase("02"))
					||(bean.getvMessage().equalsIgnoreCase("03"))||(bean.getvMessage().equalsIgnoreCase("04"))){
					bean.setvMessage(null);
					result = true;
				}else{
					return false;
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
//		return result;
		return result;
	}
	
	public void doChangeServiceType(){
		
		bean = getSEMMEL014Bean();		
		String serviceName = (String)getFacesUtils().getRequestParameter("serviceTypeId");
		
		try{
			bean.setServiceCalTypeIdToCal(serviceName); 
			
		}catch(Exception e){
			
			e.printStackTrace();
		} 
	}
	
	public List<ElVerifySP> doGetElectricDetailId(String electricDetailId,String siteInfoId){//PLY
		List<ElVerifySP> resultList = new ArrayList<ElVerifySP>();
		try {
			
			bean = getSEMMEL014Bean();	
			
			ElVerifySP cri = new ElVerifySP();
			IManagementService manageService = (IManagementService)getBean("managementService");
			cri.setElectricDetailId(electricDetailId);
			//cri.setElectricDetailId(bean.getVerifySPDel().getElectricDetailId());
			cri.setSiteInfoId(siteInfoId);
			cri.setElectricCalCode(bean.getServiceCalTypeIdToCal());
			cri.setServiceList(bean.getServiceList());
			cri.setUser(getUserLogIn());
			cri.setServiceId(bean.getServiceCalTypeId());  
			
			List<ElVerifySP> serviceConfig = manageService.querySPList(EQueryName.SEM_SP_MEL001_EL_CAL_DETAIL.name, cri);
			
			if(serviceConfig.size() > 0){
				resultList = serviceConfig;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return resultList;
	
	}

	public List<ElVerifySP> viewByEditMode(String electricDetailId,String electricId,String electricUseType){
		
		List<ElVerifySP> result = new ArrayList<ElVerifySP>();
		try {
			
			bean = getSEMMEL014Bean();	
			bean.setServiceNameListShowTbl(result);
			
			ElVerifySP cri = new ElVerifySP();
			IManagementService manageService = (IManagementService)getBean("managementService");
			cri.setElectricDetailId(electricDetailId);
			cri.setElectricId(electricId);
			cri.setElectricUseType(electricUseType);
			result = manageService.querySPList(EQueryName.SEM_SP_MEL001_SRCH_CAL_DETAIL.name, cri);
			String siteInfoId =bean.getVerifyDtlList().get(0).getVerifyCondSP().getSiteInfoId();
			bean.setServiceNameListShowTbl(getConfigServiceMaster(siteInfoId,bean.getServiceCalTypeId()));
		
			for(int i = 0;i<result.size();i++){
				String serviceIOld = bean.getServiceNameListShowTbl().get(i).getServiceId();
				
				bean.setServiceCalTypeIdToCal(result.get(i).getRentalCalCode());
			
			if(result.get(i).getRentalCalCode().equalsIgnoreCase("01")){
				bean.setShowAmt(result.get(i).getCalAmt().toString());			
			}else if(result.get(i).getRentalCalCode().equalsIgnoreCase("02")){
				for(int k=0;k<result.size();k++){
					String serviceIdResult = result.get(k).getServiceId();
					if(serviceIOld.equalsIgnoreCase(serviceIdResult)){
						bean.getServiceNameListShowTbl().get(i).setInputPercent(result.get(k).getCalAmt().toString());
						break;
					}else{
						
						continue;
					}
				}
			}else if(result.get(i).getRentalCalCode().equalsIgnoreCase("03")){
				for(int k=0;k<result.size();k++){
					String serviceIdResult = result.get(k).getServiceId();
					if(serviceIOld.equalsIgnoreCase(serviceIdResult)){
						bean.getServiceNameListShowTbl().get(i).setInputAmt(result.get(k).getCalAmt().toString());
						break;
					}else{
						
						continue;
					}
				}
			}else if(result.get(i).getRentalCalCode().equalsIgnoreCase("04")){
				for(int k=0;k<result.size();k++){
					String serviceIdResult = result.get(k).getServiceId();
					if(serviceIOld.equalsIgnoreCase(serviceIdResult)){
						bean.getServiceNameListShowTbl().get(i).setInputAmt(result.get(k).getCalAmt().toString());
						break;
					}else{
						
						continue;
					}
				}		
			}
			}
			setSEMMEL014Bean(bean);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
		
		
	}
	
	private boolean doELPrivateVerify() {
		logger.debug(" ######## Start SEMMEL014Action doELPrivateVerify #########");
		boolean flag = true;
		String pageNo = getFacesUtils().getRequestParameter("pageNo") == null ? "" : (String)getFacesUtils().getRequestParameter("pageNo");
		try {
			IManagementService manageService = (IManagementService)getBean("managementService");
			bean.getVerifySP().setUser(getUserLogIn());
			logger.debug("verrifySP = "+bean.getVerifySP().toString());
			
//			String siteInfo = bean.getVerifySP().getSiteInfoId();
			String electricId = bean.getVerMaster().getElectricId();
	
			if(bean.getVerifySP().getMode().equalsIgnoreCase("ADD")){}
			//doGetElectricDetailId(null, siteInfo); 
			
//			bean.getVerifySP().setElectricCalCode(bean.getServiceCalTypeIdToCal());
//			bean.getVerifySP().setServiceId(bean.getServiceCalTypeId());
//			logger.debug("bean.getVerMaster().getElectricId() : "+bean.getVerMaster().getElectricId());
//			logger.debug("bean.getVerifySP().getElectricId() : "+bean.getVerifySP().getElectricId());
			
			if(bean.getVerMaster().getElectricId() != null) {
				//bean.getVerifySP().setPeriodType(bean.getVerifySP().getTakeAllPeriodType());
				
				List<ELVerifyCondSP> resultList = manageService.querySPList(EQueryName.SEM_MEL014_PRIVATE_VERIFY.name, bean.getVerMaster());
				
				if(resultList != null && resultList.size() > 0) { 
					logger.debug("result = "+resultList.get(0).getResult());
					logger.debug("message = "+resultList.get(0).getMessage());
						if("SUCCESS".equalsIgnoreCase(resultList.get(0).getResult())){
							// CAll SEM_SP_MEL001_EL_CAL_DETAIL
//							doGetElectricDetailId(resultList.get(0).getMessage(), siteInfo);
							
							SEMMEL001Bean semmel001Bean = getSemmel001Bean();
							SEMMEL001Action semmel001Action = new SEMMEL001Action();
							semmel001Action.doCancel14(semmel001Bean);
							this.initVerify();
							if(StringUtils.isNotEmpty(pageNo)){
								if(StringUtils.equals("1", pageNo)){
									
								}else if(StringUtils.equals("2", pageNo)){
									this.initBail();
								}else if(StringUtils.equals("3", pageNo)){
									this.initBail();
									this.initCheckPremium();
								}
							}
							
							bean.setRenderedMsgFormMiddle(true);
							addMessageInfo("M0001");
						}else{
							addGeneralMessageError(resultList.get(0).getRemark());
							flag = false;
						}
				}else{
					addMessageError("E0001");
					flag = false;
				}
				
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			addMessageError("E0001");
			flag = false;
			return false;
		}finally{
			logger.debug(" ######## End SEMMEL014Action doELPrivateVerify #########");
		}
		return flag;
		
	}
	
	private boolean initEditPeriod(){
		boolean flag = false;
		bean = getSEMMEL014Bean();
		
		String paymentId = (String)getFacesUtils().getRequestParameter("paymentId");
		String termOfPaymentDt = (String)getFacesUtils().getRequestParameter("termOfPaymentDt");
		String fromTermOfPaymentDt = (String)getFacesUtils().getRequestParameter("fromTermOfPaymentDt");
		String toTermOfPaymentDt = (String)getFacesUtils().getRequestParameter("toTermOfPaymentDt");
		String meterId = (String)getFacesUtils().getRequestParameter("meterId");
		String periodNoStart = (String)getFacesUtils().getRequestParameter("periodNoStart");
		
		try {
//			bean.setPeriodStartDt(SEMDataUtility.convertStringToDateByFormat(periodStartDt, "dd/MM/yyyy"));
			bean.setPeriodNo(Double.valueOf(periodNoStart));
//			bean.setExpenseType(expenseType);
//			bean.setPeriodType(periodType);
			if(termOfPaymentDt != null)bean.setTermOfPaymentDt(SEMDataUtility.convertStringToDateByFormat(termOfPaymentDt, "dd/MM/yyyy") );
			if(fromTermOfPaymentDt != null)bean.setFromTermOfPaymentDt(SEMDataUtility.convertStringToDateByFormat(fromTermOfPaymentDt, "dd/MM/yyyy"));
			if(toTermOfPaymentDt != null)bean.setToTermOfPaymentDt(SEMDataUtility.convertStringToDateByFormat(toTermOfPaymentDt, "dd/MM/yyyy"));
			bean.setMeterId(meterId);
			bean.setPaymentId(paymentId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
		}
		setSEMMEL014Bean(bean);
		return flag;
	}

	private boolean doUpdatePeriod(){
		boolean flag = false;
		bean = getSEMMEL014Bean();
		try{
			
			Mel014UpdatePeriod mel014UpdatePeriod = new Mel014UpdatePeriod();
			mel014UpdatePeriod.setPaymentId(bean.getPaymentId());
			mel014UpdatePeriod.setPeriod(String.valueOf(bean.getPeriodNo()));
			mel014UpdatePeriod.setUserId(getUserLogIn());

			IRentalDetailService service = (IRentalDetailService)getBean("rentalDetailService");
			
			List<Mel014UpdatePeriod> to = null;
			
			to = service.querySPList(EQueryName.SP_UPD_MEL014_UPD_PERIOD.name, mel014UpdatePeriod);
			
			if(to.size()>0 && to != null){
//				List<Mrt001SrchRentPay> rentalPayList = new ArrayList<Mrt001SrchRentPay>();
				try{
//					Mrt001SrchRentPay criteria = new Mrt001SrchRentPay();
//					criteria.setRowId(semmrt001Bean.getRentalMasterId());
//					rentalPayList = service.querySPList(EQueryName.SP_MRT001_SRCH_RENT_PAY.name, criteria);		
//					if (rentalPayList != null && !rentalPayList.isEmpty()) {
//						for(Mrt001SrchRentPay rentPay: rentalPayList){
//							if(rentPay.getPeriodStartDt() != null)rentPay.setPeriodStartDtStr(convertYearENtoTHStr(rentPay.getPeriodStartDt()));
//						}
//						semmrt001Bean.setRentPayList(rentalPayList);
//					}
					getListShowPeriodPaymentEL();
					flag = true;
				}catch (Exception e) {
					e.printStackTrace();
					logger.error(e);
				}
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		setSEMMEL014Bean(bean);
		return flag;
	}
	
	//added by NEW 20190411
	public void doSelectedVerDPSSetup() {
		logger.debug("===doSelectedVerDPSSetup===");
		bean = getSEMMEL014Bean();
		try {
			String siteElectricId = (String)getFacesUtils().getRequestParameter("siteElectricId");
			String siteDepositId = getFacesUtils().getRequestParameter("siteDepositId") == null ? "" : (String)getFacesUtils().getRequestParameter("siteDepositId");
			String payPeriodType = "";
			
			ELDpstCondSP dpstConSP = new ELDpstCondSP();
			bean.setDpstConSP(new ELDpstCondSP());
			bean.getDpstConSP().setMode(MODE.ADD);
			bean.setVendorList(getEmptyDropDown());
			bean.setPayeeList(getEmptyDropDown());
			for(ManagementWrapper wrapper : bean.getDpstCondList()) {
				if(StringUtils.equals(siteDepositId, wrapper.getDpstCondSP().getSiteDepositId()) && wrapper.isSelected()) {
					dpstConSP = wrapper.getDpstCondSP();
					dpstConSP.setMode(MODE.ADD);
//					verConSP.setPeriodStartDt(verConSP.getPeriodStartDt());
//					verConSP.setPeriodEndDt(verConSP.getExpireDt());				
//					bean.getDpstConSP().setServiceId(dpstConSP.getServiceId());
					dpstConSP.setDepositAmt(dpstConSP.getCondDepositAmt());
					dpstConSP.setDepositType(dpstConSP.getDepositTypeName());
					bean.setDpstConSP(dpstConSP);
					bean.setVendorList(getDropdownVendor(bean.getVerMaster().getContractNo(),"08"));
				}else {
					wrapper.setSelected(false);
				}
			}

			
			setSEMMEL014Bean(bean);
			logger.debug("bean.getVerifySP().getPayPeriodType() : "+bean.getVerifySP().getPayPeriodType());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private boolean doBackPage() {
		boolean flag = true;
		
		String navProgram = (String)getFacesUtils().getRequestParameter("navProgram");
		if (navProgram.equals("SEMMRT001-1")) {
//			doSearch();
//			searchVerifyRental();
		} else {
			bean = getSEMMEL014Bean(); 
//			initPageDeposit();
			setSEMMEL014Bean(bean);
		}
		
		return flag;
	}
	
	private void doRenderCheckBox(ELVerifyCondSP ret){
		bean = getSEMMEL014Bean();
		try{
			if(StringUtils.equals("Y", ret.getNoUnitPriceFlag())){
				bean.getVerifySP().setChkNoUnitPrice(true);
			}else{
				bean.getVerifySP().setChkNoUnitPrice(false);
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.debug("Error SEMMEL014Action doRenderCheckBox : "+e);
		}finally{
			setSEMMEL014Bean(bean);
		}
	}
	
	public void doSetCheckBoxEntity() {
		bean = getSEMMEL014Bean();
		try{
			if(bean.getVerifySP().isChkNoUnitPrice()){
				bean.getVerifySP().setNoUnitPriceFlag("Y");
			}else{
				bean.getVerifySP().setNoUnitPriceFlag("N");
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.debug("Error SEMMEL014Action doSetCheckBoxEntity : "+e);
		}finally{
			setSEMMEL014Bean(bean);
		}
	}
	
	public void clickNoUnitPrice(){
		bean = getSEMMEL014Bean();
		try{
			if(bean.getVerifySP().isChkNoUnitPrice()){
				bean.getVerifySP().setUnitPriceAmt(null);
				bean.getVerifySP().setUnitPriceAmtTemp(null);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.debug("Error SEMMEL014Action clickNoUnitPrice : "+e);
		}
	}
}
