package th.co.ais.web.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.model.SelectItem;
import org.apache.log4j.Logger;

import th.co.ais.service.gm.ILovMasterService;
import th.co.ais.domain.gm.LovMaster;
import th.co.ais.util.EComponentCode;
import th.co.ais.util.ELovType;
import th.co.ais.util.ELovVal;
import th.co.ais.web.action.AbstractBaseAction;

public class LOVCacheUtil extends AbstractBaseAction {

	private static final long serialVersionUID = -7649064908760186026L;

	private Logger log = Logger.getLogger(getClass());

	private static LOVCacheUtil instance = null;

	private static List<LovMaster> lov;

	private HashMap componentMap = null;

	private LOVCacheUtil() {

	}

	public static void initLov() {
		if (lov == null) {
			try {
				ILovMasterService lovService = (ILovMasterService) FacesUtils
						.getInstance().getBean("lovMasterService");
				lov = lovService.getListLovActive();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static synchronized LOVCacheUtil getInstance() {
		if (instance == null) {
			instance = new LOVCacheUtil();
		}
		return instance;
	}

	public void loadComponent() {
		initLov();
		componentMap = new HashMap();
		setCompanySelList(componentMap);
		setNetworkTypeSelList(componentMap);
		setTransferTypeSelList(componentMap);
		setLossTypeSelList(componentMap);
		setPolicyTypeSelList(componentMap);
		setDraftStatusSelList(componentMap);
		setApproveTypeSelList(componentMap);
		setSiteApproveStatusSelList(componentMap);
		setReqDocTypeSelList(componentMap);
		// setRegionSelectItemList(null);
		setVendorTypeSelList(componentMap);
		setBankAccountTypeSelList(componentMap);
		setExpenseTypeSelList(componentMap);
		setLegalApproveSelList(componentMap);
		setSiteTypeSelList(componentMap);
		setSiteInfoStatusSelList(componentMap);
		setSiteStatusSelList(componentMap);
		setSendRenewStatusSelList(componentMap);
		setSendRenewTypeSelList(componentMap);
		setSendRenewAStatusSelList(componentMap);
		setVerifyStatusSelList(componentMap);
		setBgStatusSelList(componentMap);
		setBgBankSelList(componentMap);
		setPlaceTypeSelList(componentMap);
		setDeckAreaTypeSelList(componentMap);
		setBuildingAreaTypeSelList(componentMap);
		setAreaUnitTypeSelList(componentMap);
		setPropertyTaxTypeSelList(componentMap);
		setPropertyTaxPayTypeSelList(componentMap);
		setRenewAgeCodeSelList(componentMap);
		setPMSStatusSelList(componentMap);
		setRentalPayExpenseTypeSelList(componentMap);
		setPaymentMethodSelList(componentMap);
		//setPaymentStatusSelList(componentMap);
		setPaymentTypeSelList(componentMap);
		setNetworkStatusSelList(componentMap);
		setJobTypeSelList(componentMap);
		setSiteConstructStatusSelList(componentMap);
		setConstructStatusSelList(componentMap);
		setConstructTOTStatusSelList(componentMap);
		setConstructTypeSelList(componentMap);
		setConBillPayStatusSelList(componentMap);
		setDayPerYearSelList(componentMap);
		setDayPerMonthSelList(componentMap);
		setVatTypeSelList(componentMap);
		setPeriodTypeSelList(componentMap);
		setContractDocTypeSelList(componentMap);
		setOwnerGroupSelList(componentMap);
		setPostTypeSelList(componentMap);
		setConStructionResultStatusSelList(componentMap);
	}
	
	//CP_CON_RESULT_STATUS
	public List<SelectItem> getConStructionResultStatusSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();

		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_CP_CON_RESULT_STATUS.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getPostTypeSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setConStructionResultStatusSelList(HashMap rawData) {

		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData
					.containsKey(EComponentCode.M_CODE_CP_CON_RESULT_STATUS.name)
					&& rawData
							.get(EComponentCode.M_CODE_CP_CON_RESULT_STATUS.name) != null) {
				if (((List) rawData
						.get(EComponentCode.M_CODE_CP_CON_RESULT_STATUS.name))
						.size() > 0) {
					for (LovMaster lovMaster : ((List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_CP_CON_RESULT_STATUS.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(
							EComponentCode.M_CODE_CP_CON_RESULT_STATUS.name,
							selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_CP_CON_RESULT_STATUS.equals(lovMaster
								.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(
							EComponentCode.M_CODE_CP_CON_RESULT_STATUS.name,
							selList);
				}
			}

		} catch (Exception e) {
			log.error("error in LOVCacheUtil.setConStructionResultStatusSelList : " + e);
		}

	}
	
	
	
	
	private void setOwnerGroupSelList(HashMap rawData) {
		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if(rawData.containsKey(EComponentCode.M_CODE_SI_SITE_OWNER_GROUP.name) && rawData.get(EComponentCode.M_CODE_SI_SITE_OWNER_GROUP.name) != null) {
				if(((List)rawData.get(EComponentCode.M_CODE_SI_SITE_OWNER_GROUP.name)).size() > 0){
					for (LovMaster lovMaster:((List<LovMaster>)rawData.get(EComponentCode.M_CODE_SI_SITE_OWNER_GROUP.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(EComponentCode.M_CODE_SI_SITE_OWNER_GROUP.name, selList);
				}
			}else{
				if(lov != null && !lov.isEmpty()){
					selItem = new SelectItem("" , msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if(ELovType.T_SI_SITE_OWNER_GROUP.name.equals(lovMaster.getLovType())){
								selItem = new SelectItem();
								selItem.setLabel(lovMaster.getLovName());
								selItem.setValue(lovMaster.getLovCode());
								selList.add(selItem);								
						}
					}
					componentMap.put(EComponentCode.M_CODE_SI_SITE_OWNER_GROUP.name, selList);
				}
			}
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.setOwnerGroupSelList : " + e);
		}
		
	}
	
	public List<SelectItem> getOwnerGroupSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();

		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_SI_SITE_OWNER_GROUP.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getOwnerGroupSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}
	
	private void setContractDocTypeSelList(HashMap rawData) {
		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if(rawData.containsKey(EComponentCode.M_CODE_SI_CONTRACT_DOC_TYPE.name) && rawData.get(EComponentCode.M_CODE_SI_CONTRACT_DOC_TYPE.name) != null) {
				if(((List)rawData.get(EComponentCode.M_CODE_SI_CONTRACT_DOC_TYPE.name)).size() > 0){
					for (LovMaster lovMaster:((List<LovMaster>)rawData.get(EComponentCode.M_CODE_SI_CONTRACT_DOC_TYPE.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(EComponentCode.M_CODE_SI_CONTRACT_DOC_TYPE.name, selList);
				}
			}else{
				if(lov != null && !lov.isEmpty()){
					selItem = new SelectItem("" , msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if(ELovType.T_SI_CONTRACT_DOC_TYPE.name.equals(lovMaster.getLovType())){
								selItem = new SelectItem();
								selItem.setLabel(lovMaster.getLovName());
								selItem.setValue(lovMaster.getLovCode());
								selList.add(selItem);								
						}
					}
					componentMap.put(EComponentCode.M_CODE_SI_CONTRACT_DOC_TYPE.name, selList);
				}
			}
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.setContractDocTypeSelList : " + e);
		}
		
	}
	
	public List<SelectItem> getContractDocTypeSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();

		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_SI_CONTRACT_DOC_TYPE.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getContractDocTypeSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}
	
	private void setPeriodTypeSelList(HashMap rawData) {
		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if(rawData.containsKey(EComponentCode.M_CODE_CT_PERIOD_TYPE.name) && rawData.get(EComponentCode.M_CODE_CT_PERIOD_TYPE.name) != null) {
				if(((List)rawData.get(EComponentCode.M_CODE_CT_PERIOD_TYPE.name)).size() > 0){
					for (LovMaster lovMaster:((List<LovMaster>)rawData.get(EComponentCode.M_CODE_CT_PERIOD_TYPE.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(EComponentCode.M_CODE_CT_PERIOD_TYPE.name, selList);
				}
			}else{
				if(lov != null && !lov.isEmpty()){
					selItem = new SelectItem("" , msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if(ELovType.T_CT_PERIOD_TYPE.name.equals(lovMaster.getLovType())){
								selItem = new SelectItem();
								selItem.setLabel(lovMaster.getLovName());
								selItem.setValue(lovMaster.getLovCode());
								selList.add(selItem);								
						}
					}
					componentMap.put(EComponentCode.M_CODE_CT_PERIOD_TYPE.name, selList);
				}
			}
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.setPeriodType : " + e);
		}
		
	}
	
	public List<SelectItem> getPeriodTypeSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();

		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_CT_PERIOD_TYPE.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getPeriodTypeSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}
	
	public List<SelectItem> getPostTypeSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();

		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_CP_POST_TYPE.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getPostTypeSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setPostTypeSelList(HashMap rawData) {

		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData
					.containsKey(EComponentCode.M_CODE_CP_POST_TYPE.name)
					&& rawData
							.get(EComponentCode.M_CODE_CP_POST_TYPE.name) != null) {
				if (((List) rawData
						.get(EComponentCode.M_CODE_CP_POST_TYPE.name))
						.size() > 0) {
					for (LovMaster lovMaster : ((List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_CP_POST_TYPE.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(
							EComponentCode.M_CODE_CP_POST_TYPE.name,
							selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_CP_POST_TYPE.name.equals(lovMaster
								.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(
							EComponentCode.M_CODE_CP_POST_TYPE.name,
							selList);
				}
			}

		} catch (Exception e) {
			log.error("error in LOVCacheUtil.setPostTypeSelList : " + e);
		}

	}
	
	
	

	public List<SelectItem> getConBillPayStatusSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();

		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_CP_CON_BILL_PAY_STATUS.name);
		} catch (Exception e) {
			log
					.error("error in LOVCacheUtil.getConBillPayStatusSelList : "
							+ e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setConBillPayStatusSelList(HashMap rawData) {

		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData
					.containsKey(EComponentCode.M_CODE_CP_CON_BILL_PAY_STATUS.name)
					&& rawData
							.get(EComponentCode.M_CODE_CP_CON_BILL_PAY_STATUS.name) != null) {
				if (((List) rawData
						.get(EComponentCode.M_CODE_CP_CON_BILL_PAY_STATUS.name))
						.size() > 0) {
					for (LovMaster lovMaster : ((List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_CP_CON_BILL_PAY_STATUS.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(
							EComponentCode.M_CODE_CP_CON_BILL_PAY_STATUS.name,
							selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_CP_CON_BILL_PAY_STATUS.name
								.equals(lovMaster.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(
							EComponentCode.M_CODE_CP_CON_BILL_PAY_STATUS.name,
							selList);
				}
			}

		} catch (Exception e) {
			log
					.error("error in LOVCacheUtil.setConBillPayStatusSelList : "
							+ e);
		}

	}

	public List<SelectItem> getConstructTypeSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();

		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_CP_CONSTRUCT_TYPE.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getConstructTypeSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setConstructTypeSelList(HashMap rawData) {

		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData
					.containsKey(EComponentCode.M_CODE_CP_CONSTRUCT_TYPE.name)
					&& rawData
							.get(EComponentCode.M_CODE_CP_CONSTRUCT_TYPE.name) != null) {
				if (((List) rawData
						.get(EComponentCode.M_CODE_CP_CONSTRUCT_TYPE.name))
						.size() > 0) {
					for (LovMaster lovMaster : ((List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_CP_CONSTRUCT_TYPE.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(
							EComponentCode.M_CODE_CP_CONSTRUCT_TYPE.name,
							selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_CP_CONSTRUCT_TYPE.name.equals(lovMaster
								.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(
							EComponentCode.M_CODE_CP_CONSTRUCT_TYPE.name,
							selList);
				}
			}

		} catch (Exception e) {
			log.error("error in LOVCacheUtil.setConstructTypeSelList : " + e);
		}

	}

	public List<SelectItem> getConstructStatusSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();

		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_CP_CONSTRUCT_STATUS.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getConstructStatusSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setConstructStatusSelList(HashMap rawData) {

		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData
					.containsKey(EComponentCode.M_CODE_CP_CONSTRUCT_STATUS.name)
					&& rawData
							.get(EComponentCode.M_CODE_CP_CONSTRUCT_STATUS.name) != null) {
				if (((List) rawData
						.get(EComponentCode.M_CODE_CP_CONSTRUCT_STATUS.name))
						.size() > 0) {
					for (LovMaster lovMaster : ((List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_CP_CONSTRUCT_STATUS.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(
							EComponentCode.M_CODE_CP_CONSTRUCT_STATUS.name,
							selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_CP_CONSTRUCT_STATUS.name
								.equals(lovMaster.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(
							EComponentCode.M_CODE_CP_CONSTRUCT_STATUS.name,
							selList);
				}
			}

		} catch (Exception e) {
			log.error("error in LOVCacheUtil.setConstructStatusSelList : " + e);
		}

	}

	public List<SelectItem> getConstructTOTStatusSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();

		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_CP_TOT_STATUS.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getConstructStatusSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setConstructTOTStatusSelList(HashMap rawData) {

		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData.containsKey(EComponentCode.M_CODE_CP_TOT_STATUS.name)
					&& rawData.get(EComponentCode.M_CODE_CP_TOT_STATUS.name) != null) {
				if (((List) rawData
						.get(EComponentCode.M_CODE_CP_TOT_STATUS.name)).size() > 0) {
					for (LovMaster lovMaster : ((List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_CP_TOT_STATUS.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(EComponentCode.M_CODE_CP_TOT_STATUS.name,
							selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_CP_TOT_STATUS.name.equals(lovMaster
								.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(EComponentCode.M_CODE_CP_TOT_STATUS.name,
							selList);
				}
			}

		} catch (Exception e) {
			log.error("error in LOVCacheUtil.setConstructStatusSelList : " + e);
		}

	}

	public List<SelectItem> getSiteConstructStatusSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();

		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_CONSTRUCT_STATUS.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getConstructStatusSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setSiteConstructStatusSelList(HashMap rawData) {

		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData
					.containsKey(EComponentCode.M_CODE_CONSTRUCT_STATUS.name)
					&& rawData.get(EComponentCode.M_CODE_CONSTRUCT_STATUS.name) != null) {
				if (((List) rawData
						.get(EComponentCode.M_CODE_CONSTRUCT_STATUS.name))
						.size() > 0) {
					for (LovMaster lovMaster : ((List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_CONSTRUCT_STATUS.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(
							EComponentCode.M_CODE_CONSTRUCT_STATUS.name,
							selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_CP_SITE_CONSTRUCT_STATUS.name
								.equals(lovMaster.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(
							EComponentCode.M_CODE_CONSTRUCT_STATUS.name,
							selList);
				}
			}

		} catch (Exception e) {
			log.error("error in LOVCacheUtil.setConstructStatusSelList : " + e);
		}

	}

	public List<SelectItem> getPMSStatusSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();

		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_PMS_STATUS_NETWORK.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getPMSStatusSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setPMSStatusSelList(HashMap rawData) {

		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData
					.containsKey(EComponentCode.M_CODE_PMS_STATUS_NETWORK.name)
					&& rawData
							.get(EComponentCode.M_CODE_PMS_STATUS_NETWORK.name) != null) {
				if (((List) rawData
						.get(EComponentCode.M_CODE_PMS_STATUS_NETWORK.name))
						.size() > 0) {
					for (LovMaster lovMaster : ((List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_PMS_STATUS_NETWORK.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(
							EComponentCode.M_CODE_PMS_STATUS_NETWORK.name,
							selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_SI_PMS_STATUS.name.equals(lovMaster
								.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(
							EComponentCode.M_CODE_PMS_STATUS_NETWORK.name,
							selList);
				}
			}

		} catch (Exception e) {
			log.error("error in LOVCacheUtil.setBgBankSelList : " + e);
		}

	}

	private void setNetworkStatusSelList(HashMap rawData) {
		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData.containsKey(EComponentCode.M_CODE_NETWORK_STATUS.name)
					&& rawData.get(EComponentCode.M_CODE_NETWORK_STATUS.name) != null) {
				if (((List) rawData
						.get(EComponentCode.M_CODE_NETWORK_STATUS.name)).size() > 0) {
					for (LovMaster lovMaster : (List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_NETWORK_STATUS.name)) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(EComponentCode.M_CODE_NETWORK_STATUS.name,
							selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_CT_NETWORK_STATUS.name.equals(lovMaster
								.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(EComponentCode.M_CODE_NETWORK_STATUS.name,
							selList);
				}
			}
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.setNetworkStatusSelList : " + e);
		}
	}

	public List<SelectItem> getNetworkStatusSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();
		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_NETWORK_STATUS.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getNetworkStatusSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	public List<SelectItem> getBgBankSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();

		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_BG_BANK.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getBgBankSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setBgBankSelList(HashMap rawData) {

		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData.containsKey(EComponentCode.M_CODE_BG_BANK.name)
					&& rawData.get(EComponentCode.M_CODE_BG_BANK.name) != null) {
				if (((List) rawData.get(EComponentCode.M_CODE_BG_BANK.name))
						.size() > 0) {
					for (LovMaster lovMaster : ((List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_BG_BANK.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(EComponentCode.M_CODE_BG_BANK.name,
							selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_BG_BANK.name.equals(lovMaster
								.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(EComponentCode.M_CODE_BG_BANK.name,
							selList);
				}
			}

		} catch (Exception e) {
			log.error("error in LOVCacheUtil.setBgBankSelList : " + e);
		}

	}

	public List<SelectItem> getBgStatusSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();

		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_BG_STATUS.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getBgStatusSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setBgStatusSelList(HashMap rawData) {

		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData.containsKey(EComponentCode.M_CODE_BG_STATUS.name)
					&& rawData.get(EComponentCode.M_CODE_BG_STATUS.name) != null) {
				if (((List) rawData.get(EComponentCode.M_CODE_BG_STATUS.name))
						.size() > 0) {
					for (LovMaster lovMaster : ((List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_BG_STATUS.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(EComponentCode.M_CODE_BG_STATUS.name,
							selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_CT_BG_STATUS.name.equals(lovMaster
								.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(EComponentCode.M_CODE_BG_STATUS.name,
							selList);
				}
			}

		} catch (Exception e) {
			log.error("error in LOVCacheUtil.setBgStatusSelList : " + e);
		}

	}

	private void setExpenseTypeSelList(HashMap rawData) {

		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData.containsKey(EComponentCode.M_CODE_EXPENSE_TYPE.name)
					&& rawData.get(EComponentCode.M_CODE_EXPENSE_TYPE.name) != null) {
				if (((List) rawData
						.get(EComponentCode.M_CODE_EXPENSE_TYPE.name)).size() > 0) {
					for (LovMaster lovMaster : ((List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_EXPENSE_TYPE.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(EComponentCode.M_CODE_EXPENSE_TYPE.name,
							selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {

					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_CT_EXPENSE_TYPE.name.equals(lovMaster
								.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(EComponentCode.M_CODE_EXPENSE_TYPE.name,
							selList);
				}
			}

		} catch (Exception e) {
			log.error("error in LOVCacheUtil.setExpenseTypeSelList : " + e);
		}

	}

	public List<SelectItem> getExpenseTypeSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();

		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_EXPENSE_TYPE.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getExpenseTypeSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setBankAccountTypeSelList(HashMap rawData) {

		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData.containsKey(EComponentCode.M_CODE_BANK_ACC_TYPE.name)
					&& rawData.get(EComponentCode.M_CODE_BANK_ACC_TYPE.name) != null) {
				if (((List) rawData
						.get(EComponentCode.M_CODE_BANK_ACC_TYPE.name)).size() > 0) {
					for (LovMaster lovMaster : ((List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_BANK_ACC_TYPE.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(EComponentCode.M_CODE_BANK_ACC_TYPE.name,
							selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_CT_BANK_ACC_TYPE.name.equals(lovMaster
								.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(EComponentCode.M_CODE_BANK_ACC_TYPE.name,
							selList);
				}
			}

		} catch (Exception e) {
			log.error("error in LOVCacheUtil.setBankAccountTypeSelList : " + e);
		}

	}

	public List<SelectItem> getBankAccountTypeSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();

		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_BANK_ACC_TYPE.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getBankAccountTypeSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setVendorTypeSelList(HashMap rawData) {

		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData.containsKey(EComponentCode.M_CODE_VENDOR_TYPE.name)
					&& rawData.get(EComponentCode.M_CODE_VENDOR_TYPE.name) != null) {
				if (((List) rawData.get(EComponentCode.M_CODE_VENDOR_TYPE.name))
						.size() > 0) {
					for (LovMaster lovMaster : ((List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_VENDOR_TYPE.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovVal());
						selList.add(selItem);
					}
					componentMap.put(EComponentCode.M_CODE_VENDOR_TYPE.name,
							selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_CT_VENDOR_TYPE.name.equals(lovMaster
								.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovVal());
							selList.add(selItem);
						}
					}
					componentMap.put(EComponentCode.M_CODE_VENDOR_TYPE.name,
							selList);
				}
			}
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.setVendorTypeSelList : " + e);
		}
	}

	public List<SelectItem> getVendorTypeSelList() {

		List<SelectItem> returnList = new ArrayList<SelectItem>();

		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_VENDOR_TYPE.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getVendorTypeSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setCompanySelList(HashMap rawData) {

		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData.containsKey(EComponentCode.M_CODE_COMPANY.name)
					&& rawData.get(EComponentCode.M_CODE_COMPANY.name) != null) {
				if (((List) rawData.get(EComponentCode.M_CODE_COMPANY.name))
						.size() > 0) {
					for (LovMaster lovMaster : ((List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_COMPANY.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(EComponentCode.M_CODE_COMPANY.name,
							selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_COMPANY.name.equals(lovMaster
								.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(EComponentCode.M_CODE_COMPANY.name,
							selList);
				}
			}
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.setCompanySelList : " + e);
		}
	}

	public List<SelectItem> getCompanySelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();

		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_COMPANY.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getCompanySelectItemList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setNetworkTypeSelList(HashMap rawData) {
		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData.containsKey(EComponentCode.M_CODE_NETWORK_TYPE.name)
					&& rawData.get(EComponentCode.M_CODE_NETWORK_TYPE.name) != null) {
				if (((List) rawData
						.get(EComponentCode.M_CODE_NETWORK_TYPE.name)).size() > 0) {
					for (LovMaster lovMaster : (List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_NETWORK_TYPE.name)) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(EComponentCode.M_CODE_NETWORK_TYPE.name,
							selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_IR_NETWORK_TYPES.name.equals(lovMaster
								.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(EComponentCode.M_CODE_NETWORK_TYPE.name,
							selList);
				}
			}
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.setNetworkTypeSelList : " + e);
		}
	}

	public List<SelectItem> getNetworkTypeSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();
		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_NETWORK_TYPE.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getNetworkTypeSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setTransferTypeSelList(HashMap rawData) {
		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData.containsKey(EComponentCode.M_CODE_TRANSFER_TYPE.name)
					&& rawData.get(EComponentCode.M_CODE_TRANSFER_TYPE.name) != null) {
				if (((List) rawData
						.get(EComponentCode.M_CODE_TRANSFER_TYPE.name)).size() > 0) {
					for (LovMaster lovMaster : (List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_TRANSFER_TYPE.name)) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(EComponentCode.M_CODE_TRANSFER_TYPE.name,
							selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_IR_TRANSFER_TYPES.name.equals(lovMaster
								.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(EComponentCode.M_CODE_TRANSFER_TYPE.name,
							selList);
				}
			}
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.setTransferTypeSelList : " + e);
		}
	}

	public List<SelectItem> getTransferTypeSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();
		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_TRANSFER_TYPE.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getTransferTypeSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setLossTypeSelList(HashMap rawData) {
		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData.containsKey(EComponentCode.M_CODE_LOSS_TYPE.name)
					&& rawData.get(EComponentCode.M_CODE_LOSS_TYPE.name) != null) {
				if (((List) rawData.get(EComponentCode.M_CODE_LOSS_TYPE.name))
						.size() > 0) {
					for (LovMaster lovMaster : (List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_LOSS_TYPE.name)) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(EComponentCode.M_CODE_LOSS_TYPE.name,
							selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_IR_LOSS_TYPE.name.equals(lovMaster
								.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(EComponentCode.M_CODE_LOSS_TYPE.name,
							selList);
				}
			}
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.setLossTypeSelList : " + e);
		}
	}

	public List<SelectItem> getLossTypeSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();
		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_LOSS_TYPE.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getLossTypeSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setPolicyTypeSelList(HashMap rawData) {
		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData.containsKey(EComponentCode.M_CODE_POLICY_TYPE.name)
					&& rawData.get(EComponentCode.M_CODE_POLICY_TYPE.name) != null) {
				if (((List) rawData.get(EComponentCode.M_CODE_POLICY_TYPE.name))
						.size() > 0) {
					for (LovMaster lovMaster : (List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_POLICY_TYPE.name)) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(EComponentCode.M_CODE_POLICY_TYPE.name,
							selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_IR_POLICY_TYPE.name.equals(lovMaster
								.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(EComponentCode.M_CODE_POLICY_TYPE.name,
							selList);
				}
			}
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.setLossTypeSelList : " + e);
		}
	}

	public List<SelectItem> getPolicyTypeSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();
		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_POLICY_TYPE.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getPolicyTypeSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setDraftStatusSelList(HashMap rawData) {
		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData.containsKey(EComponentCode.M_CODE_DRAFT_STATUS.name)
					&& rawData.get(EComponentCode.M_CODE_DRAFT_STATUS.name) != null) {
				if (((List) rawData
						.get(EComponentCode.M_CODE_DRAFT_STATUS.name)).size() > 0) {
					for (LovMaster lovMaster : (List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_DRAFT_STATUS.name)) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(EComponentCode.M_CODE_DRAFT_STATUS.name,
							selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_IR_DRAFT_STATUS.name.equals(lovMaster
								.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(EComponentCode.M_CODE_DRAFT_STATUS.name,
							selList);
				}
			}
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.setLossTypeSelList : " + e);
		}
	}

	public List<SelectItem> getDraftStatusSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();
		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_DRAFT_STATUS.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getDraftStatusSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setApproveTypeSelList(HashMap rawData) {
		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData.containsKey(EComponentCode.M_CODE_APPROVE_TYPE.name)
					&& rawData.get(EComponentCode.M_CODE_APPROVE_TYPE.name) != null) {
				if (((List) rawData
						.get(EComponentCode.M_CODE_APPROVE_TYPE.name)).size() > 0) {
					for (LovMaster lovMaster : (List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_APPROVE_TYPE)) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_SI_APPROVE_TYPE.name.equals(lovMaster
								.getLovType())
								&& ELovVal.V_SI_APPROVE_TYPE.name
										.equals(lovMaster.getLovCond1())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(EComponentCode.M_CODE_APPROVE_TYPE.name,
							selList);
				}
			}
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.setApproveTypeSelList : " + e);
		}
	}

	public List<SelectItem> getApproveTypeSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();
		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_APPROVE_TYPE.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.setApproveTypeSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setSiteApproveStatusSelList(HashMap rawData) {
		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData.containsKey(EComponentCode.M_CODE_APPROVE_STATUS.name)
					&& rawData.get(EComponentCode.M_CODE_APPROVE_STATUS.name) != null) {
				if (((List) rawData
						.get(EComponentCode.M_CODE_APPROVE_STATUS.name)).size() > 0) {
					for (LovMaster lovMaster : (List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_APPROVE_STATUS)) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_SI_APPROVE_STATUS.name.equals(lovMaster
								.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(EComponentCode.M_CODE_APPROVE_STATUS.name,
							selList);
				}
			}
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getSiteApproveStatusSelList : "
					+ e);
		}
	}

	public List<SelectItem> getSiteApproveStatusSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();
		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_APPROVE_STATUS.name);
		} catch (Exception e) {
			log.error("ERROR IN LOVCacheUtil.getSiteApproveStatusSelList : "
					+ e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setReqDocTypeSelList(HashMap rawData) {
		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData.containsKey(EComponentCode.M_CODE_REQ_DOC_TYPE.name)
					&& rawData.get(EComponentCode.M_CODE_REQ_DOC_TYPE.name) != null) {
				if (((List) rawData
						.get(EComponentCode.M_CODE_REQ_DOC_TYPE.name)).size() > 0) {
					for (LovMaster lovMaster : (List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_REQ_DOC_TYPE)) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_SI_REQ_DOC_TYPE.name.equals(lovMaster
								.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(EComponentCode.M_CODE_REQ_DOC_TYPE.name,
							selList);
				}
			}
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.setReqDocTypeSelList : " + e);
		}
	}

	public List<SelectItem> getReqDocTypeSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();
		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_REQ_DOC_TYPE.name);
		} catch (Exception e) {
			log.error("ERROR IN LOVCacheUtil.setReqDocTypeSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setLegalApproveSelList(HashMap rawData) {

		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData
					.containsKey(EComponentCode.M_CODE_LEGAL_APPROVE_STATUS.name)
					&& rawData
							.get(EComponentCode.M_CODE_LEGAL_APPROVE_STATUS.name) != null) {
				if (((List) rawData
						.get(EComponentCode.M_CODE_LEGAL_APPROVE_STATUS.name))
						.size() > 0) {
					for (LovMaster lovMaster : ((List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_LEGAL_APPROVE_STATUS.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(
							EComponentCode.M_CODE_LEGAL_APPROVE_STATUS.name,
							selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_SI_LEGAL_APPROVE_STATUS.name
								.equals(lovMaster.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(
							EComponentCode.M_CODE_LEGAL_APPROVE_STATUS.name,
							selList);
				}
			}
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.setLegalApproveSelList : " + e);
		}
	}

	public List<SelectItem> getLegalApproveSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();

		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_LEGAL_APPROVE_STATUS.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getLegalApproveSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setSiteTypeSelList(HashMap rawData) {

		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData.containsKey(EComponentCode.M_CODE_SITE_TYPE.name)
					&& rawData.get(EComponentCode.M_CODE_SITE_TYPE.name) != null) {
				if (((List) rawData.get(EComponentCode.M_CODE_SITE_TYPE.name))
						.size() > 0) {
					for (LovMaster lovMaster : ((List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_SITE_TYPE.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(EComponentCode.M_CODE_SITE_TYPE.name,
							selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_SI_SITE_TYPE.name.equals(lovMaster
								.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(EComponentCode.M_CODE_SITE_TYPE.name,
							selList);
				}
			}
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.setSiteTypeSelList : " + e);
		}
	}

	public List<SelectItem> getSiteTypeSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();

		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_SITE_TYPE.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getSiteTypeSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setSiteInfoStatusSelList(HashMap rawData) {

		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData
					.containsKey(EComponentCode.M_CODE_SITE_INFO_STATUS.name)
					&& rawData.get(EComponentCode.M_CODE_SITE_INFO_STATUS.name) != null) {
				if (((List) rawData
						.get(EComponentCode.M_CODE_SITE_INFO_STATUS.name))
						.size() > 0) {
					for (LovMaster lovMaster : ((List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_SITE_INFO_STATUS.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(
							EComponentCode.M_CODE_SITE_INFO_STATUS.name,
							selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_SI_SITE_INFO_STATUS.name
								.equals(lovMaster.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(
							EComponentCode.M_CODE_SITE_INFO_STATUS.name,
							selList);
				}
			}
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.setSiteInfoStatusSelList : " + e);
		}
	}

	public List<SelectItem> getSiteInfoStatusSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();

		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_SITE_INFO_STATUS.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getSiteInfoStatusSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setSiteStatusSelList(HashMap rawData) {

		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData.containsKey(EComponentCode.M_CODE_SITE_STATUS.name)
					&& rawData.get(EComponentCode.M_CODE_SITE_STATUS.name) != null) {
				if (((List) rawData.get(EComponentCode.M_CODE_SITE_STATUS.name))
						.size() > 0) {
					for (LovMaster lovMaster : ((List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_SITE_STATUS.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(EComponentCode.M_CODE_SITE_STATUS.name,
							selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_SI_SITE_STATUS.name.equals(lovMaster
								.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(EComponentCode.M_CODE_SITE_STATUS.name,
							selList);
				}
			}
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.setSiteStatusSelList : " + e);
		}
	}

	public List<SelectItem> getSiteStatusSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();

		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_SITE_STATUS.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getSiteStatusSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setSendRenewAStatusSelList(HashMap rawData) {

		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData
					.containsKey(EComponentCode.M_CODE_SEND_RENEW_A_STATUS.name)
					&& rawData
							.get(EComponentCode.M_CODE_SEND_RENEW_A_STATUS.name) != null) {
				if (((List) rawData
						.get(EComponentCode.M_CODE_SEND_RENEW_A_STATUS.name))
						.size() > 0) {
					for (LovMaster lovMaster : ((List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_SEND_RENEW_A_STATUS.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(
							EComponentCode.M_CODE_SEND_RENEW_A_STATUS.name,
							selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_SI_SEND_RENEW_A_STATUS.name
								.equals(lovMaster.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(
							EComponentCode.M_CODE_SEND_RENEW_A_STATUS.name,
							selList);
				}
			}
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.setCompanySelList : " + e);
		}
	}

	public List<SelectItem> getSendRenewAStatusSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();

		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_SEND_RENEW_A_STATUS.name);
		} catch (Exception e) {
			log
					.error("error in LOVCacheUtil.getSendRenewAstatusSelectItemList : "
							+ e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setSendRenewTypeSelList(HashMap rawData) {

		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData.containsKey(EComponentCode.M_CODE_SEND_RENEW_TYPE.name)
					&& rawData.get(EComponentCode.M_CODE_SEND_RENEW_TYPE.name) != null) {
				if (((List) rawData
						.get(EComponentCode.M_CODE_SEND_RENEW_TYPE.name))
						.size() > 0) {
					for (LovMaster lovMaster : ((List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_SEND_RENEW_TYPE.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap
							.put(EComponentCode.M_CODE_SEND_RENEW_TYPE.name,
									selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_SI_SEND_RENEW_TYPE.name.equals(lovMaster
								.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap
							.put(EComponentCode.M_CODE_SEND_RENEW_TYPE.name,
									selList);
				}
			}
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.setCompanySelList : " + e);
		}
	}

	public List<SelectItem> getSendRenewTypeSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();

		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_SEND_RENEW_TYPE.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getSendRenewTypeSelectItemList : "
					+ e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setSendRenewStatusSelList(HashMap rawData) {

		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData
					.containsKey(EComponentCode.M_CODE_SEND_RENEW_STATUS.name)
					&& rawData
							.get(EComponentCode.M_CODE_SEND_RENEW_STATUS.name) != null) {
				if (((List) rawData
						.get(EComponentCode.M_CODE_SEND_RENEW_STATUS.name))
						.size() > 0) {
					for (LovMaster lovMaster : ((List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_SEND_RENEW_STATUS.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(
							EComponentCode.M_CODE_SEND_RENEW_STATUS.name,
							selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_SI_SEND_RENEW_STATUS.name
								.equals(lovMaster.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(
							EComponentCode.M_CODE_SEND_RENEW_STATUS.name,
							selList);
				}
			}
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.setCompanySelList : " + e);
		}
	}

	public List<SelectItem> getSendRenewStatusSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();

		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_SEND_RENEW_STATUS.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getSendRenewTypeSelectItemList : "
					+ e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setVerifyStatusSelList(HashMap rawData) {

		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData.containsKey(EComponentCode.M_CODE_VERIFY_STATUS.name)
					&& rawData.get(EComponentCode.M_CODE_VERIFY_STATUS.name) != null) {
				if (((List) rawData
						.get(EComponentCode.M_CODE_VERIFY_STATUS.name)).size() > 0) {
					for (LovMaster lovMaster : ((List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_VERIFY_STATUS.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(EComponentCode.M_CODE_VERIFY_STATUS.name,
							selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_RT_VERIFY_STATUS.name.equals(lovMaster
								.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(EComponentCode.M_CODE_VERIFY_STATUS.name,
							selList);
				}
			}
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getVerifyStatusSelList : " + e);
		}
	}

	public List<SelectItem> getVerifyStatusSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();

		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_VERIFY_STATUS.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getVerifyStatusSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setPlaceTypeSelList(HashMap rawData) {

		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData.containsKey(EComponentCode.M_CODE_PLACE_TYPE.name)
					&& rawData.get(EComponentCode.M_CODE_PLACE_TYPE.name) != null) {
				if (((List) rawData.get(EComponentCode.M_CODE_PLACE_TYPE.name))
						.size() > 0) {
					for (LovMaster lovMaster : ((List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_PLACE_TYPE.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(EComponentCode.M_CODE_PLACE_TYPE.name,
							selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_SI_PLACE_TYPE.name.equals(lovMaster
								.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(EComponentCode.M_CODE_PLACE_TYPE.name,
							selList);
				}
			}
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.setPlaceTypeSelList : " + e);
		}
	}

	public List<SelectItem> getPlaceTypeSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();

		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_PLACE_TYPE.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getPlaceTypeSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setDeckAreaTypeSelList(HashMap rawData) {

		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData.containsKey(EComponentCode.M_CODE_DECK_AREA_TYPE.name)
					&& rawData.get(EComponentCode.M_CODE_DECK_AREA_TYPE.name) != null) {
				if (((List) rawData
						.get(EComponentCode.M_CODE_DECK_AREA_TYPE.name)).size() > 0) {
					for (LovMaster lovMaster : ((List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_DECK_AREA_TYPE.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(EComponentCode.M_CODE_DECK_AREA_TYPE.name,
							selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_SI_DECK_AREA_TYPE.name.equals(lovMaster
								.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(EComponentCode.M_CODE_DECK_AREA_TYPE.name,
							selList);
				}
			}
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.setDeckAreaTypeSelList : " + e);
		}
	}

	public List<SelectItem> getDeckAreaTypeSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();

		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_DECK_AREA_TYPE.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getDeckAreaTypeSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setBuildingAreaTypeSelList(HashMap rawData) {

		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData
					.containsKey(EComponentCode.M_CODE_BUILDING_AREA_TYPE.name)
					&& rawData
							.get(EComponentCode.M_CODE_BUILDING_AREA_TYPE.name) != null) {
				if (((List) rawData
						.get(EComponentCode.M_CODE_BUILDING_AREA_TYPE.name))
						.size() > 0) {
					for (LovMaster lovMaster : ((List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_BUILDING_AREA_TYPE.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(
							EComponentCode.M_CODE_BUILDING_AREA_TYPE.name,
							selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_SI_BUILDING_AREA_TYPE.name
								.equals(lovMaster.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(
							EComponentCode.M_CODE_BUILDING_AREA_TYPE.name,
							selList);
				}
			}
		} catch (Exception e) {
			log
					.error("error in LOVCacheUtil.setBuildingAreaTypeSelList : "
							+ e);
		}
	}

	public List<SelectItem> getBuildingAreaTypeSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();

		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_BUILDING_AREA_TYPE.name);
		} catch (Exception e) {
			log
					.error("error in LOVCacheUtil.getBuildingAreaTypeSelList : "
							+ e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setAreaUnitTypeSelList(HashMap rawData) {

		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData.containsKey(EComponentCode.M_CODE_AREA_UNIT_TYPE.name)
					&& rawData.get(EComponentCode.M_CODE_AREA_UNIT_TYPE.name) != null) {
				if (((List) rawData
						.get(EComponentCode.M_CODE_AREA_UNIT_TYPE.name)).size() > 0) {
					for (LovMaster lovMaster : ((List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_AREA_UNIT_TYPE.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(EComponentCode.M_CODE_AREA_UNIT_TYPE.name,
							selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_SI_AREA_UNIT_TYPE.name.equals(lovMaster
								.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(EComponentCode.M_CODE_AREA_UNIT_TYPE.name,
							selList);
				}
			}
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.setAreaUnitTypeSelList : " + e);
		}
	}

	public List<SelectItem> getAreaUnitTypeSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();

		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_AREA_UNIT_TYPE.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getAreaUnitTypeSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setPropertyTaxTypeSelList(HashMap rawData) {

		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData
					.containsKey(EComponentCode.M_CODE_PROPERTY_TAX_TYPE.name)
					&& rawData
							.get(EComponentCode.M_CODE_PROPERTY_TAX_TYPE.name) != null) {
				if (((List) rawData
						.get(EComponentCode.M_CODE_PROPERTY_TAX_TYPE.name))
						.size() > 0) {
					for (LovMaster lovMaster : ((List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_PROPERTY_TAX_TYPE.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(
							EComponentCode.M_CODE_PROPERTY_TAX_TYPE.name,
							selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_SI_PROPERTY_TAX_TYPE.name
								.equals(lovMaster.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(
							EComponentCode.M_CODE_PROPERTY_TAX_TYPE.name,
							selList);
				}
			}
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.setPropertyTaxTypeSelList : " + e);
		}
	}

	public List<SelectItem> getPropertyTaxTypeSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();

		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_PROPERTY_TAX_TYPE.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getPropertyTaxTypeSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setPropertyTaxPayTypeSelList(HashMap rawData) {

		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData
					.containsKey(EComponentCode.M_CODE_PROPERTY_TAX_PAY_TYPE.name)
					&& rawData
							.get(EComponentCode.M_CODE_PROPERTY_TAX_PAY_TYPE.name) != null) {
				if (((List) rawData
						.get(EComponentCode.M_CODE_PROPERTY_TAX_PAY_TYPE.name))
						.size() > 0) {
					for (LovMaster lovMaster : ((List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_PROPERTY_TAX_PAY_TYPE.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(
							EComponentCode.M_CODE_PROPERTY_TAX_PAY_TYPE.name,
							selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_SI_PROPERTY_TAX_PAY_TYPE.name
								.equals(lovMaster.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(
							EComponentCode.M_CODE_PROPERTY_TAX_PAY_TYPE.name,
							selList);
				}
			}
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.setPropertyTaxPayTypeSelList : "
					+ e);
		}
	}

	public List<SelectItem> getPropertyTaxPayTypeSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();

		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_PROPERTY_TAX_PAY_TYPE.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getPropertyTaxPayTypeSelList : "
					+ e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setRenewAgeCodeSelList(HashMap rawData) {

		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData.containsKey(EComponentCode.M_CODE_RENEW_AGE_CODE.name)
					&& rawData.get(EComponentCode.M_CODE_RENEW_AGE_CODE.name) != null) {
				if (((List) rawData
						.get(EComponentCode.M_CODE_RENEW_AGE_CODE.name)).size() > 0) {
					for (LovMaster lovMaster : ((List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_RENEW_AGE_CODE.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(EComponentCode.M_CODE_RENEW_AGE_CODE.name,
							selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_SI_RENEW_AGE_CODE.name.equals(lovMaster
								.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(EComponentCode.M_CODE_RENEW_AGE_CODE.name,
							selList);
				}
			}
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getRenewAgeCodeSelList : " + e);
		}
	}

	public List<SelectItem> getRenewAgeCodeSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();

		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_RENEW_AGE_CODE.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getRenewAgeCodeSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setRentalPayExpenseTypeSelList(HashMap rawData) {

		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData
					.containsKey(EComponentCode.M_CODE_RENTALPAY_EXPENSE_TYPE.name)
					&& rawData
							.get(EComponentCode.M_CODE_RENTALPAY_EXPENSE_TYPE.name) != null) {
				if (((List) rawData
						.get(EComponentCode.M_CODE_RENTALPAY_EXPENSE_TYPE.name))
						.size() > 0) {
					for (LovMaster lovMaster : ((List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_RENTALPAY_EXPENSE_TYPE.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(
							EComponentCode.M_CODE_RENTALPAY_EXPENSE_TYPE.name,
							selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_CT_EXPENSE_TYPE.name.equals(lovMaster
								.getLovType())) {
							if (ELovVal.V_CT_RENT.name.equals(lovMaster
									.getLovVal())
									|| ELovVal.V_CT_DEPOSIT_RENT.equals(lovMaster
											.getLovVal())) {
								selItem = new SelectItem();
								selItem.setLabel(lovMaster.getLovName());
								selItem.setValue(lovMaster.getLovCode());
								selList.add(selItem);
							}
						}
					}
					componentMap.put(
							EComponentCode.M_CODE_RENTALPAY_EXPENSE_TYPE.name,
							selList);
				}
			}
		} catch (Exception e) {
			log
					.error("error in LOVCacheUtil.getRentalExpenseTypeCodeSelList : "
							+ e);
		}
	}

	public List<SelectItem> getRentalPayExpenseTypeSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();

		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_RENTALPAY_EXPENSE_TYPE.name);
		} catch (Exception e) {
			log
					.error("error in LOVCacheUtil.getRentalExpenseTypeCodeSelList : "
							+ e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setPaymentMethodSelList(HashMap rawData) {

		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData.containsKey(EComponentCode.M_CODE_PAYMENT_METHOD.name)
					&& rawData.get(EComponentCode.M_CODE_PAYMENT_METHOD.name) != null) {
				if (((List) rawData
						.get(EComponentCode.M_CODE_PAYMENT_METHOD.name)).size() > 0) {
					for (LovMaster lovMaster : ((List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_PAYMENT_METHOD.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(EComponentCode.M_CODE_PAYMENT_METHOD.name,
							selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_CT_PAYMENT_METHOD.name.equals(lovMaster
								.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(EComponentCode.M_CODE_PAYMENT_METHOD.name,
							selList);
				}
			}
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getPaymentMethodSelList : " + e);
		}
	}

	public List<SelectItem> getPaymentMethodSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();

		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_PAYMENT_METHOD.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getPaymentMethodSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	/*private void setPaymentStatusSelList(HashMap rawData) {

		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData.containsKey(EComponentCode.M_CODE_PAYMENT_STATUS.name)
					&& rawData.get(EComponentCode.M_CODE_PAYMENT_STATUS.name) != null) {
				if (((List) rawData
						.get(EComponentCode.M_CODE_PAYMENT_STATUS.name)).size() > 0) {
					for (LovMaster lovMaster : ((List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_PAYMENT_STATUS.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(EComponentCode.M_CODE_PAYMENT_STATUS.name,
							selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_CT_PAYMENT_REJECT_STATUS.name
								.equals(lovMaster.getLovType())
								|| ELovType.T_CT_PAYMENT_STATUS.name
										.equals(lovMaster.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(EComponentCode.M_CODE_PAYMENT_STATUS.name,
							selList);
				}
			}
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getPaymentStatusSelList : " + e);
		}
	}*/

	public List<SelectItem> getPaymentStatusSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();

		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_PAYMENT_STATUS.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getPaymentStatusSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setPaymentTypeSelList(HashMap rawData) {

		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData.containsKey(EComponentCode.M_CODE_PAYMENT_TYPE.name)
					&& rawData.get(EComponentCode.M_CODE_PAYMENT_TYPE.name) != null) {
				if (((List) rawData
						.get(EComponentCode.M_CODE_PAYMENT_TYPE.name)).size() > 0) {
					for (LovMaster lovMaster : ((List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_PAYMENT_TYPE.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(EComponentCode.M_CODE_PAYMENT_TYPE.name,
							selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_CT_PAYMENT_TYPE.name.equals(lovMaster
								.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(EComponentCode.M_CODE_PAYMENT_TYPE.name,
							selList);
				}
			}
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getPaymentStatusSelList : " + e);
		}
	}

	public List<SelectItem> getPaymentTypeSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();

		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_PAYMENT_TYPE.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getPaymentTypeSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

	private void setJobTypeSelList(HashMap rawData) {

		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData.containsKey(EComponentCode.M_CODE_JOB_TYPE.name)
					&& rawData.get(EComponentCode.M_CODE_JOB_TYPE.name) != null) {
				if (((List) rawData.get(EComponentCode.M_CODE_JOB_TYPE.name))
						.size() > 0) {
					for (LovMaster lovMaster : ((List<LovMaster>) rawData
							.get(EComponentCode.M_CODE_JOB_TYPE.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(EComponentCode.M_CODE_JOB_TYPE.name,
							selList);
				}
			} else {
				if (lov != null && !lov.isEmpty()) {
					selItem = new SelectItem("", msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if (ELovType.T_RT_JOB_TYPE_N.name.equals(lovMaster
								.getLovType())) {
							selItem = new SelectItem();
							selItem.setLabel(lovMaster.getLovName());
							selItem.setValue(lovMaster.getLovCode());
							selList.add(selItem);
						}
					}
					componentMap.put(EComponentCode.M_CODE_JOB_TYPE.name,
							selList);
				}
			}
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getJobTypeSelList : " + e);
		}
	}

	public List<SelectItem> getJobTypeSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();

		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_JOB_TYPE.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getJobTypeSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}

private void setDayPerYearSelList(HashMap rawData){
		
		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if(rawData.containsKey(EComponentCode.M_CODE_CT_DAY_PER_YEAR.name) && rawData.get(EComponentCode.M_CODE_CT_DAY_PER_YEAR.name) != null) {
				if(((List)rawData.get(EComponentCode.M_CODE_CT_DAY_PER_YEAR.name)).size() > 0){
					for (LovMaster lovMaster:((List<LovMaster>)rawData.get(EComponentCode.M_CODE_CT_DAY_PER_YEAR.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(EComponentCode.M_CODE_CT_DAY_PER_YEAR.name, selList);
				}
			}else{
				if(lov != null && !lov.isEmpty()){
					selItem = new SelectItem("" , msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if(ELovType.T_CT_DAY_PER_YEAR.name.equals(lovMaster.getLovType())){
								selItem = new SelectItem();
								selItem.setLabel(lovMaster.getLovName());
								selItem.setValue(lovMaster.getLovCode());
								selList.add(selItem);								
						}
					}
					componentMap.put(EComponentCode.M_CODE_CT_DAY_PER_YEAR.name, selList);
				}
			}
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getDayPerYearSelList : " + e);
		}
	}
	
	public List<SelectItem> getDayPerYearSelList(){
		List<SelectItem> returnList = new ArrayList<SelectItem>();
		
		if(componentMap == null){
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>)componentMap.get(EComponentCode.M_CODE_CT_DAY_PER_YEAR.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getDayPerYearSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}
	
	private void setDayPerMonthSelList(HashMap rawData){
		
		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if(rawData.containsKey(EComponentCode.M_CODE_CT_DAY_PERMONTH.name) && rawData.get(EComponentCode.M_CODE_CT_DAY_PERMONTH.name) != null) {
				if(((List)rawData.get(EComponentCode.M_CODE_CT_DAY_PERMONTH.name)).size() > 0){
					for (LovMaster lovMaster:((List<LovMaster>)rawData.get(EComponentCode.M_CODE_CT_DAY_PERMONTH.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(EComponentCode.M_CODE_CT_DAY_PERMONTH.name, selList);
				}
			}else{
				if(lov != null && !lov.isEmpty()){
					selItem = new SelectItem("" , msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if(ELovType.T_CT_DAY_PER_MONTH.name.equals(lovMaster.getLovType())){
								selItem = new SelectItem();
								selItem.setLabel(lovMaster.getLovName());
								selItem.setValue(lovMaster.getLovCode());
								selList.add(selItem);								
						}
					}
					componentMap.put(EComponentCode.M_CODE_CT_DAY_PERMONTH.name, selList);
				}
			}
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getDayPerMonthSelList : " + e);
		}
	}
	
	public List<SelectItem> getDayPerMonthSelList(){
		List<SelectItem> returnList = new ArrayList<SelectItem>();
		
		if(componentMap == null){
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>)componentMap.get(EComponentCode.M_CODE_CT_DAY_PERMONTH.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getDayPerMonthSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}
	
	private void setVatTypeSelList(HashMap rawData){
		
		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if(rawData.containsKey(EComponentCode.M_CODE_CT_VAT_TYPE.name) && rawData.get(EComponentCode.M_CODE_CT_VAT_TYPE.name) != null) {
				if(((List)rawData.get(EComponentCode.M_CODE_CT_VAT_TYPE.name)).size() > 0){
					for (LovMaster lovMaster:((List<LovMaster>)rawData.get(EComponentCode.M_CODE_CT_VAT_TYPE.name))) {
						selItem = new SelectItem();
						selItem.setLabel(lovMaster.getLovName());
						selItem.setValue(lovMaster.getLovCode());
						selList.add(selItem);
					}
					componentMap.put(EComponentCode.M_CODE_CT_VAT_TYPE.name, selList);
				}
			}else{
				if(lov != null && !lov.isEmpty()){
					selItem = new SelectItem("" , msg("value.selectItem"));
					selList.add(selItem);
					for (LovMaster lovMaster : lov) {
						if(ELovType.T_CT_VAT_TYPE.name.equals(lovMaster.getLovType())){
								selItem = new SelectItem();
								selItem.setLabel(lovMaster.getLovName());
								selItem.setValue(lovMaster.getLovCode());
								selList.add(selItem);								
						}
					}
					componentMap.put(EComponentCode.M_CODE_CT_VAT_TYPE.name, selList);
				}
			}
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getDayPerYearSelList : " + e);
		}
	}
	
	public List<SelectItem> getVatTypeSelList(){
		List<SelectItem> returnList = new ArrayList<SelectItem>();
		
		if(componentMap == null){
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>)componentMap.get(EComponentCode.M_CODE_CT_VAT_TYPE.name);
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getDayPerYearSelList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}
	// ++++++++++++++++++++++++++++++++++++

	private void setRegionSelectItemList(HashMap rawData) {
		List<SelectItem> sList = new ArrayList<SelectItem>();
		SelectItem sitem = null;
		sitem = new SelectItem("", "-- All --");
		sList.add(sitem);
		sitem = new SelectItem("N", "North");
		sList.add(sitem);
		sitem = new SelectItem("C", "Center");
		sList.add(sitem);
		componentMap.put(EComponentCode.M_CODE_REGION.name, sList);
	}

	public List<SelectItem> getRegionSelectItemList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();

		if (componentMap == null) {
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>) componentMap
					.get(EComponentCode.M_CODE_REGION.name);
		} catch (Exception e) {
			log.error("ERROR IN LOVCacheUtil.getRegionSelectItemList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}
	
	public List<SelectItem> getByLOVType(String lovType) {
		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		selItem = new SelectItem("", msg("value.selectItem"));
		selList.add(selItem);

		if (lov == null) {
			initLov();
		}
		try {
			for(LovMaster lovMaster : lov){
				if(lovType.equals(lovMaster.getLovType())){
					selItem = new SelectItem();
					selItem.setLabel(lovMaster.getLovName());
					selItem.setValue(lovMaster.getLovCode());
					selItem.setDescription(lovMaster.getLovVal());
					selList.add(selItem);
				}
			}
			
		} catch (Exception e) {
			log.error("error in LOVCacheUtil.getLOVByLOVType : " + e);
		}
		return WebUtil.isNullSelectList(selList);
	}

	public HashMap getComponentMap() {
		return componentMap;
	}

	public void setComponentMap(HashMap componentMap) {
		this.componentMap = componentMap;
	}

	public static List<LovMaster> getLov() {
		return lov;
	}

	public static void setLov(List<LovMaster> lov) {
		LOVCacheUtil.lov = lov;
	}
}