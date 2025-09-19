package th.co.ais.web.common.action;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.security.vote.ConsensusBased;

//import bsh.StringUtil;

import th.co.ais.domain.cp.ConstructionPermissionSearchSP;
import th.co.ais.domain.cp.PopupVendorSupplierSearchSP;
import th.co.ais.domain.el.Payment;
import th.co.ais.domain.el.VendorSP;
import th.co.ais.domain.gm.VendorMasterSP;
import th.co.ais.service.gm.IVendorMasterService;
import th.co.ais.service.si.ISendRenewService;
import th.co.ais.service.si.ISiteContractService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.common.PopupVendorSupplierBean;
import th.co.ais.web.co.bean.SEMMCO004Bean;
import th.co.ais.web.cp.bean.SEMMCP001Bean;
import th.co.ais.web.el.action.SEMMEL006Action;
import th.co.ais.web.el.bean.SEMMEL001Bean;
import th.co.ais.web.el.bean.SEMMEL006Bean;
import th.co.ais.web.util.ELUtils;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.LOVCacheUtil;
import th.co.ais.web.util.MSGCacheUtil;
import th.co.ais.web.util.ProvinceCacheUtil;

public class PopupVendorSupplierAction extends AbstractAction{

	private static final long serialVersionUID = 154181415663741549L;
	private Logger log = Logger.getLogger(getClass());

	
	private SEMMEL001Bean semmel001Bean;
	private SEMMEL006Bean semmel006Bean;
	
	public SEMMEL001Bean getSemmel001Bean() {
		return (SEMMEL001Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmel001Bean");
	}

	public void setSemmel001Bean(SEMMEL001Bean semmel001Bean) {
		this.semmel001Bean = semmel001Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmel001Bean", this.semmel001Bean);
	}
	
	public SEMMEL006Bean getSemmel006Bean() {
		return (SEMMEL006Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmel006Bean");
	}

	public void setSemmel006Bean(SEMMEL006Bean semmel006Bean) {
		this.semmel006Bean = semmel006Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmel006Bean", this.semmel006Bean);
	}
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if(methodWithNavi.equalsIgnoreCase("initPopupSearchVendorSupplier")){
			flag = initPopupSearchVendorSupplier();
		}
		if(methodWithNavi.equalsIgnoreCase("doSearchVendorSupplier")){
			flag = doSearchVendorSupplier();
		}
		if(methodWithNavi.equalsIgnoreCase("doClearPopupVendorSupplier")){
			flag = doClearPopupVendorSupplier();
		}
		if(methodWithNavi.equalsIgnoreCase("doSelectVendorSupplier")){
			flag = doSelectVendorSupplier();
		}
		
		return flag;
	}

	private boolean doSelectVendorSupplier() {
		
		boolean flag = false;
		String vendorMasterId = (String)getFacesUtils().getRequestParameter("vendorMasterId");
		String vendorCode = (String)getFacesUtils().getRequestParameter("vendorCode");
		String vendorFullName = (String)getFacesUtils().getRequestParameter("vendorFullName");
		String contactName = (String)getFacesUtils().getRequestParameter("contactName");
		String vendorName = (String)getFacesUtils().getRequestParameter("vendorName");
		/*String vendorName2 = (String)getFacesUtils().getRequestParameter("vendorName2");
		String vendorName3 = (String)getFacesUtils().getRequestParameter("vendorName3");
		String vendorName4 = (String)getFacesUtils().getRequestParameter("vendorName4");*/
		String identityId = (String)getFacesUtils().getRequestParameter("identityId");
		String taxId = (String)getFacesUtils().getRequestParameter("taxId");
		String fullAddress = (String)getFacesUtils().getRequestParameter("fullAddress");
		String address = (String)getFacesUtils().getRequestParameter("address");
		String district = (String)getFacesUtils().getRequestParameter("district");
		String amphur = (String)getFacesUtils().getRequestParameter("amphur");
		String province = (String)getFacesUtils().getRequestParameter("province");
		String postCode = (String)getFacesUtils().getRequestParameter("postCode");
		String telephone = (String)getFacesUtils().getRequestParameter("telephone");
		String mobileNo = (String)getFacesUtils().getRequestParameter("mobileNo");
		String fax = (String)getFacesUtils().getRequestParameter("fax");
		
		String address1 = (String)getFacesUtils().getRequestParameter("address1");
		String address2 = (String)getFacesUtils().getRequestParameter("address2");
		String city = (String)getFacesUtils().getRequestParameter("city");
		
		
		
		popupVendorSupplierBean = getPopupVendorSupplierBean();
		String popupType = popupVendorSupplierBean.getPopupType();
		String popupTypeParam = (String)getFacesUtils().getRequestParameter("popupTypeParam");
		String vendorSupplierType = popupVendorSupplierBean.getVendorSupplierType();
		
		
		popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setVendorMasterId(vendorMasterId);
		popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setVendorCode(vendorCode);
		popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setVendorName(vendorName);
		/*popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setVendorName2(vendorName2);
		popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setVendorName3(vendorName3);
		popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setVendorName4(vendorName4);*/
		popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setIdentityId(identityId);
		popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setTaxId(taxId);
		popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setFullAddresss(fullAddress);
		popupVendorSupplierBean.setPopupClose(true);
		
		if(!StringUtils.isEmpty(vendorSupplierType)){
			if(vendorSupplierType.equals("SUPPLIER")){
				popupVendorSupplierBean.setPopupType("Supplier");
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setVendorFullName(vendorFullName);
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setContactName(contactName);
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setTelephone(telephone);
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setMobileNo(mobileNo);
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setFax(fax);
				
			}else if(vendorSupplierType.equals("LOCAL_DEPART")){
				popupVendorSupplierBean.setPopupType("หน่วยงานท้องถิ่น");
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setVendorFullNameLocal(vendorFullName);
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setAddresss(address);
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setDistrict(district);
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setAmphur(amphur);
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setProvince(province);
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setPostCode(postCode);
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setAddress1(address1);
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setAddress2(address2);
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setCity(city);
			}
			try{
				
			IVendorMasterService vendorMasterService = (IVendorMasterService) getBean("vendorMasterService");
			List<VendorSP> vendorList = null;
			VendorSP vendorSP = new VendorSP();
			vendorSP.setContractNo(popupVendorSupplierBean.getTmpContractNo());
			vendorSP.setVendorId(vendorCode);
			vendorSP.setExpenseType("06");
			vendorSP.setPage("FEE");
			vendorList = vendorMasterService.querySPList(EQueryName.SP_GET_DETAIL_VENDOR_PAYEE.name, vendorSP);
			
				// EDIT BY NOOM 26/02/2013 for SEMMEL001-12 Page
				if(StringUtils.equalsIgnoreCase("semmel001", popupVendorSupplierBean.getPage())){
					semmel001Bean = getSemmel001Bean();
						if (vendorList.size()>0 && vendorList != null){
							if(semmel001Bean.getManageWrapper().getElectricPayment()==null){
								semmel001Bean.getManageWrapper().setElectricPayment(new Payment());
							}
							
							semmel001Bean.getManageWrapper().getElectricPayment().setPayeeId(vendorList.get(0).getPayeeCode());
							semmel001Bean.getManageWrapper().getElectricPayment().setPayeeName(vendorList.get(0).getPayeeName());
							semmel001Bean.getManageWrapper().getElectricPayment().setPaymentType(vendorList.get(0).getPaymentType());
							semmel001Bean.getManageWrapper().getElectricPayment().setVendorName(vendorList.get(0).getVendorName());
							
							
							if(StringUtils.equalsIgnoreCase("01", vendorList.get(0).getPaymentType())){
								Map<String,String> codeMap = new HashMap();
//								codeMap.put(ELUtils.PAYMENT_METHOD_01,ELUtils.PAYMENT_METHOD_01);
//								codeMap.put(ELUtils.PAYMENT_METHOD_02,ELUtils.PAYMENT_METHOD_02);
//								codeMap.put(ELUtils.PAYMENT_METHOD_03,ELUtils.PAYMENT_METHOD_03);
//								codeMap.put(ELUtils.PAYMENT_METHOD_04,ELUtils.PAYMENT_METHOD_04);
//								semmel001Bean.setPaymentMethodList(ELUtils.getLOVBtLOVCodeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name), codeMap));
								semmel001Bean.setPaymentMethodList(getLovItemsByType(ELovType.T_CT_PAYMENT_METHOD.name,EX_AND,"CHEQUE",null,null));
								semmel001Bean.setFpaymentMethodDisable(false);
								semmel001Bean.getManageWrapper().getElectricPayment().setBankName("");
								semmel001Bean.getManageWrapper().getElectricPayment().setBankAccount("");
								semmel001Bean.getManageWrapper().getElectricPayment().setPaymentMethod("03");
								semmel001Bean.setFtransferDtDisable(true);
								semmel001Bean.setFpaymentMethodDisable(false);
									
								//WT###Start 20110131 Start
								semmel001Bean.getManageWrapper().getElectricPayment().setTransferDt(null);
								//WT###Start 20110131 End
	
							}else if(StringUtils.equalsIgnoreCase("02", vendorList.get(0).getPaymentType())){
								semmel001Bean.getManageWrapper().getElectricPayment().setPaymentMethod("05");	
								semmel001Bean.setPaymentMethodList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name));					
								semmel001Bean.setFchqPostingDtDisable(true);
								semmel001Bean.setFbankNameInputVisible(true);
								semmel001Bean.setFchqReceivedDtDisable(true);
								semmel001Bean.setFtransferDtDisable(false);		
								semmel001Bean.setFpaymentMethodDisable(true);
								semmel001Bean.getManageWrapper().getElectricPayment().setPaymentType(vendorList.get(0).getPaymentType());
								if(vendorList != null && !vendorList.isEmpty()){
									vendorSP = vendorList.get(0);
									semmel001Bean.getManageWrapper().getElectricPayment().setPayeeId(vendorSP.getPayeeCode());
									semmel001Bean.getManageWrapper().getElectricPayment().setPayeeName(vendorSP.getPayeeName());
									semmel001Bean.getManageWrapper().getElectricPayment().setBankName(vendorSP.getBankName());
									semmel001Bean.getManageWrapper().getElectricPayment().setBankAccount(vendorSP.getBankAccNo());
								}else{
									FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("EL0040"), ""));
								}
								semmel001Bean.getManageWrapper().getElectricPayment().setChqPostingDt(null);
								semmel001Bean.getManageWrapper().getElectricPayment().setChqReceivedDt(null);
								
								
							}else if(StringUtils.equalsIgnoreCase("03", vendorList.get(0).getPaymentType())){
								semmel001Bean.getManageWrapper().getElectricPayment().setPaymentMethod("06");			
								semmel001Bean.getManageWrapper().getElectricPayment().setBankName("");
								semmel001Bean.getManageWrapper().getElectricPayment().setBankAccount("");
								semmel001Bean.setPaymentMethodList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_PAYMENT_METHOD.name));
								semmel001Bean.setFpaymentMethodDisable(true);
							}
							
						}
					
				}else if(StringUtils.equalsIgnoreCase("semmel006", popupVendorSupplierBean.getPage())){
					getSemmel006Bean().getPayment().setVendorId(vendorCode);
					getSemmel006Bean().getPayment().setVendorName(vendorFullName);
					if (vendorList.size()>0 && vendorList != null){
						getSemmel006Bean().getPayment().setPaymentType(vendorList.get(0).getPaymentType());
						if(StringUtils.equalsIgnoreCase("01", vendorList.get(0).getPaymentType())){
							getSemmel006Bean().getPayment().setPaymentMethod("03");
						}else if(StringUtils.equalsIgnoreCase("02", vendorList.get(0).getPaymentType())){
							getSemmel006Bean().getPayment().setPaymentMethod("05");
							SEMMEL006Action semmel006Action = new SEMMEL006Action();
							semmel006Action.changePaymentTypeELPostpaid();
						}else if(StringUtils.equalsIgnoreCase("03", vendorList.get(0).getPaymentType())){
							getSemmel006Bean().getPayment().setPaymentMethod("06");
						}
					}
					
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}else{
			
				System.out.println(" Null doSelectVendorSupplier PopupTyre Null ");
			
		}	
		setPopupVendorSupplierBean(popupVendorSupplierBean);
		setSemmel001Bean(semmel001Bean);
//		log.debug(" =================================");
//		log.debug(" PAYMENT TYPE"+semmel001Bean.getWrapper().getElectricPayment());
//		log.debug(" =================================");
		return flag;
	}
	
	private void setSEMMEL006Bean(PopupVendorSupplierSearchSP popupVendorSupplierSearchSP) {
		
		SEMMEL006Bean semmel006Bean = (SEMMEL006Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmel006Bean");
		
		if(semmel006Bean != null){
			
			semmel006Bean.getPayment().setVendorId(popupVendorSupplierSearchSP.getVendorCode());
			semmel006Bean.getPayment().setVendorName(popupVendorSupplierSearchSP.getVendorFullName());
			//WT###Add 20110203 Start
			semmel006Bean.getPayment().setOldVendorIdTypeS(popupVendorSupplierSearchSP.getVendorCode());
			semmel006Bean.getPayment().setOldVendorNameTypeS(popupVendorSupplierSearchSP.getVendorFullName());
			//WT###Add 20110203 End
		}		
		
	}

	public void doSearchLocationList() {
		/*popupSiteContractBean = getPopupSiteContractBean();
		popupSiteContractBean.setSiteInfoMapLocSPList(new ArrayList<SiteInfoMapLocSP>());
		ISiteInfoMapLocService siteInfoMapLocService = (ISiteInfoMapLocService)getBean("siteInfoMapLocService");
		List<SiteInfoMapLocSP> to = null;
		try{
			popupSiteContractBean.getSiteInfoMapLocSP().setSiteInfoId(popupSiteContractBean.getSiteInfoId());
			log.debug("siteInfoId [" + popupSiteContractBean.getSiteInfoMapLocSP().getSiteInfoId() + "]");
			to = siteInfoMapLocService.querySPList(EQueryName.Q_SEARCH_MAP_LOC_BY_SITE_INFO_ID.name,popupSiteContractBean.getSiteInfoMapLocSP());
			log.debug("doSearchLocationList size [" + to.size() + "]");
			popupSiteContractBean.setSiteInfoMapLocSPList(to);
			setPopupSiteContractBean(popupSiteContractBean);
		}catch(Exception e){
			e.printStackTrace();
		}*/
	}
	
	public void searchContractByContractNo() {
		/*popupSiteContractBean = getPopupSiteContractBean();
		popupSiteContractBean.getPopupContractCriteria().setContractNo(popupSiteContractBean.getContractNo());
		searchContract();
		List<PopupContractSearchSP> contractList = popupSiteContractBean.getContractList();
		if(contractList != null && contractList.size() > 0){
			PopupContractSearchSP contract = popupSiteContractBean.getContractList().get(0);
			popupSiteContractBean.setEffDate(contract.getEffDate());
			popupSiteContractBean.setExpDate(contract.getExpDate());
			popupSiteContractBean.setRegion(contract.getRegion());
			popupSiteContractBean.setSiteInfoId(contract.getSiteInfoId());
			popupSiteContractBean.setContractNo(contract.getContractNo());
		}else{
			popupSiteContractBean.setContractNo("");
			popupSiteContractBean.setSiteInfoId("");
		}
		setPopupSiteContractBean(popupSiteContractBean);*/
	}
	

	private boolean doClearPopupVendorSupplier() {
		boolean flag = false;
		popupVendorSupplierBean = getPopupVendorSupplierBean();
		popupVendorSupplierBean.setPopupVendorSupplierSearchSPList(null);
		popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setNameCri("");
		popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setTaxIdCri("");
		popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setVendorCodeCri("");
		popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setIdentityIdCri("");
//		popupVendorSupplierBean.setPopupVendorSupplierSearchSP(new PopupVendorSupplierSearchSP());
		setPopupVendorSupplierBean(popupVendorSupplierBean);
		
		return flag;
	}

	private boolean doSearchVendorSupplier(){
		boolean flag = false;
		if(!validate())
			return flag;
			searchVendorSupplier();
		
		return flag;
	}
	
	private void searchVendorSupplier(){
		popupVendorSupplierBean = getPopupVendorSupplierBean();
		ISendRenewService sendRenewService = (ISendRenewService) getBean("sendRenewService");
		List<PopupVendorSupplierSearchSP>  to = null;

		try{
			to = sendRenewService.querySPList(EQueryName.SP_PCT001_SRCH.name, popupVendorSupplierBean.getPopupVendorSupplierSearchSP());
			System.out.println("To :"+to.size());
			if (null == to || to.isEmpty()) {
				FrontMessageUtils.addMessageError(SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode("M0004"), ""));
			}
			
			
			popupVendorSupplierBean.setPopupVendorSupplierSearchSPList(to);
			popupVendorSupplierBean.setConfirmDeleteMsg(MSGCacheUtil.getInstance().getMessageByCode("Q0002"));
			setPopupVendorSupplierBean(popupVendorSupplierBean);
		} catch (Exception e) {
			log.error(e);
		}
	}


	private boolean initPopupSearchVendorSupplier() {
		boolean flag = false;
		popupVendorSupplierBean = getPopupVendorSupplierBean();
		String popupType = (String)getFacesUtils().getRequestParameter("popupType");
		String province = (String)getFacesUtils().getRequestParameter("provinceId");
		String page = (String)getFacesUtils().getRequestParameter("page");
		String contractNo = (String)getFacesUtils().getRequestParameter("contractNo");
		
		popupVendorSupplierBean.setPage(page);
		popupVendorSupplierBean.setTmpContractNo(contractNo);
		popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setVendorCodeCri("");
		popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setIdentityIdCri("");
		popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setTaxIdCri("");
		popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setNameCri("");
		popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setProvinceCri(StringUtils.isNotEmpty(province)?province:"");
		popupVendorSupplierBean.setPopupVendorSupplierSearchSPList(null);
		
		if(popupVendorSupplierBean.getPopupVendorSupplierSearchSP() == null){
			popupVendorSupplierBean.setPopupVendorSupplierSearchSP(new PopupVendorSupplierSearchSP());
		}
	
		if(!StringUtils.isEmpty(popupType)){
			if(popupType.equals("SUPPLIER")){
				popupVendorSupplierBean.setPopupType("Supplier");
				popupVendorSupplierBean.setVendorSupplierType("SUPPLIER");
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setVendorSupplierType("SUPPLIER");
				popupVendorSupplierBean.setPopupClose(false);
				setPopupVendorSupplierBean(popupVendorSupplierBean);
				
			}else if(popupType.equals("LOCAL_DEPART")){
				popupVendorSupplierBean.setPopupType("หน่วยงานท้องถิ่น");
				popupVendorSupplierBean.setVendorSupplierType("LOCAL_DEPART");
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setVendorSupplierType("LOCAL_DEPART");
				popupVendorSupplierBean.setPopupClose(false);
				setPopupVendorSupplierBean(popupVendorSupplierBean);
				
			}
		}else{ 
			popupVendorSupplierBean.setPopupType(popupType);
			setPopupVendorSupplierBean(popupVendorSupplierBean);
		}
		return flag;
	}
	
	private PopupVendorSupplierBean popupVendorSupplierBean;
	
	public PopupVendorSupplierBean getPopupVendorSupplierBean() {
		return (PopupVendorSupplierBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupVendorSupplierBean");
	}
	public void setPopupVendorSupplierBean(PopupVendorSupplierBean popupVendorSupplierBean) {
		this.popupVendorSupplierBean = popupVendorSupplierBean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupVendorSupplierBean",popupVendorSupplierBean);
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
	}

	@Override
	public void init() {
		popupVendorSupplierBean = getPopupVendorSupplierBean();
		popupVendorSupplierBean.setPopupVendorSupplierSearchSP(new PopupVendorSupplierSearchSP());
		popupVendorSupplierBean.setProvinceList(ProvinceCacheUtil.getInstance().getProvinceSelList());
		setPopupVendorSupplierBean(popupVendorSupplierBean);
	}

	@Override
	public boolean validate() {
		boolean flgValid = true;
		
		if(StringUtils.isEmpty(getPopupVendorSupplierBean().getPopupVendorSupplierSearchSP().getVendorCodeCri()) 
			&& StringUtils.isEmpty(getPopupVendorSupplierBean().getPopupVendorSupplierSearchSP().getNameCri())
			&& StringUtils.isEmpty(getPopupVendorSupplierBean().getPopupVendorSupplierSearchSP().getIdentityIdCri())
			&& StringUtils.isEmpty(getPopupVendorSupplierBean().getPopupVendorSupplierSearchSP().getTaxIdCri())
			&& StringUtils.isEmpty(getPopupVendorSupplierBean().getPopupVendorSupplierSearchSP().getProvinceCri())){
			addMessageError("W0004", msg("message.validateCondition"));
			flgValid = false;
		}
		return flgValid;
	}
	
	public boolean initPopupSearchVendorSupplierEL() {
		boolean flag = false;
		popupVendorSupplierBean = getPopupVendorSupplierBean();
		String popupType = (String)getFacesUtils().getRequestParameter("popupType");
		
		popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setVendorCodeCri("");
		popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setIdentityIdCri("");
		popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setTaxIdCri("");
		popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setNameCri("");
		popupVendorSupplierBean.setPopupVendorSupplierSearchSPList(null);
		
		if(popupVendorSupplierBean.getPopupVendorSupplierSearchSP() == null){
			popupVendorSupplierBean.setPopupVendorSupplierSearchSP(new PopupVendorSupplierSearchSP());
		}
	
		if(!StringUtils.isEmpty(popupType)){
			if(popupType.equals("SUPPLIER")){
				popupVendorSupplierBean.setPopupType("Supplier");
				popupVendorSupplierBean.setVendorSupplierType("SUPPLIER");
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setVendorSupplierType("SUPPLIER");
				popupVendorSupplierBean.setPopupClose(false);
				setPopupVendorSupplierBean(popupVendorSupplierBean);
				
			}else if(popupType.equals("LOCAL_DEPART")){
				popupVendorSupplierBean.setPopupType("หน่วยงานท้องถิ่น");
				popupVendorSupplierBean.setVendorSupplierType("LOCAL_DEPART");
				popupVendorSupplierBean.getPopupVendorSupplierSearchSP().setVendorSupplierType("LOCAL_DEPART");
				popupVendorSupplierBean.setPopupClose(false);
				setPopupVendorSupplierBean(popupVendorSupplierBean);
				
			}
		}else{ 
			popupVendorSupplierBean.setPopupType(popupType);
			setPopupVendorSupplierBean(popupVendorSupplierBean);
		}
		return flag;
	}
	
	public void doSelectPopupAddVendor(String vendorCode, String vendorName){
		log.info("-- doSelectPopupAddVendor --");

		PopupVendorSupplierBean ct001Bean = getPopupVendorSupplierBean();

		try {
			
//			String paramVendorCode = getFacesUtils().getRequestParameter("paramVendorCode") == null ? "" : 
//							  (String)getFacesUtils().getRequestParameter("paramVendorCode");
//			String paramVendorName = getFacesUtils().getRequestParameter("paramVendorName") == null ? "" : 
//				  (String)getFacesUtils().getRequestParameter("paramVendorName");
			
			//add vendor code to target
//			ct001Bean.getCriteriaVendorSP().setVendorCode(paramVendorCode);
//			ct001Bean.getCriteriaVendorSP().setVendorName(paramVendorName);
			if(ct001Bean.getPopupVendorSupplierSearchSP() != null){
				ct001Bean.getPopupVendorSupplierSearchSP().setVendorCodeCri(vendorCode);
//				ct001Bean.getPopupVendorSupplierSearchSP().setNameCri(vendorName);	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		setPopupVendorSupplierBean(ct001Bean);
	}
}
