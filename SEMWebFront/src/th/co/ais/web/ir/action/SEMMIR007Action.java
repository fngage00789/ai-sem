package th.co.ais.web.ir.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.ir.Mir007Act;
import th.co.ais.domain.ir.PolicyDtl;
import th.co.ais.domain.ir.PolicySP;
import th.co.ais.domain.ir.Premium;
import th.co.ais.domain.si.PopupContractSearchSP;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.service.gm.ILovMasterService;
import th.co.ais.service.ir.IInsuredService;
import th.co.ais.service.ir.IPolicyService;
import th.co.ais.service.ir.IPremiumService;
import th.co.ais.service.si.ISiteContractService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.ir.bean.SEMMIR007Bean;
import th.co.ais.web.ir.bean.SEMMIRPopupBean;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.MSGCacheUtil;
import th.co.ais.web.util.SemUtils;

public class SEMMIR007Action extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3387079059109530276L;
	private ILovMasterService lovMasterService;
	private Logger log = Logger.getLogger(getClass());
	
	public void setLovMasterService(ILovMasterService lovMasterService) {
		this.lovMasterService = lovMasterService;
	}
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if (methodWithNavi.equalsIgnoreCase("doSearch")) {
			flag = doSearch();
		}else if(methodWithNavi.equalsIgnoreCase("doSearchDraft")) {
		 flag = doSearchDraft();
		}else if (methodWithNavi.equalsIgnoreCase("doSave")) {
			flag = doSave();
		}else if (methodWithNavi.equalsIgnoreCase("initDelete")) {
			flag = initDelete();
		}else if (methodWithNavi.equalsIgnoreCase("initPopup")) {
			flag = initPopup();
		}else if (methodWithNavi.equalsIgnoreCase("doClear")) {
			flag = doClear();
		}else if(methodWithNavi.equalsIgnoreCase("doClearPop")){
			flag = doClearPop();
		}else if(methodWithNavi.equalsIgnoreCase("initPopupAdd")){
			initPopupAdd();
		}else if(methodWithNavi.equalsIgnoreCase("doAdd")){
			flag = doAdd();
		}else if(methodWithNavi.equalsIgnoreCase("initAdd")){
			initAdd();
		}
		
		
		
//		if (methodWithNavi.equalsIgnoreCase("doUpdate")) {
//			flag = doUpdate();
//		}
//		if (methodWithNavi.equalsIgnoreCase("doDelete")) {
//			flag = doDelete();
//		}
		
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		SEMMIR007Bean semir007Bean = new SEMMIR007Bean();
		SEMMIRPopupBean semmirPopupBean = new SEMMIRPopupBean();
		SEMMIRPopupAction semmirPopupAction = new SEMMIRPopupAction();
		semir007Bean.setPolicySP(new PolicySP());
		semir007Bean.getPolicySP().setGenType("A");
		semir007Bean.getPolicySP().setDeductType("M");
		semir007Bean.getPolicySP().setInsuredAmt(0.00);
		semir007Bean.setPolicySPPop(new PolicySP());
		semir007Bean.setPolicySPList(new ArrayList<WrapperBeanObject<PolicySP>>());
		semir007Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semir007Bean.setNetworkTypeList(getLovItemsByType(ELovType.T_IR_NETWORK_TYPES.name));
		semir007Bean.setTransferTypeList(getLovItemsByType(ELovType.T_IR_TRANSFER_TYPES.name));
		semir007Bean.setPolicyTypeList(getLovItemsByType(ELovType.T_IR_POLICY_TYPE.name));
		semir007Bean.setDraftStatusList(getLovItemsByType(ELovType.T_IR_DRAFT_STATUS.name));
		semmirPopupBean.setPolicySP(new PolicySP());
		semmirPopupBean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmirPopupBean.setNetworkTypeList(getLovItemsByType(ELovType.T_IR_NETWORK_TYPES.name));
		semmirPopupBean.setTransferTypeList(getLovItemsByType(ELovType.T_IR_TRANSFER_TYPES.name));
		semmirPopupBean.setPolicyTypeList(getLovItemsByType(ELovType.T_IR_POLICY_TYPE.name));
		semir007Bean.setInsuredFlg(true);
		semir007Bean.setRefPolicyList(new ArrayList<SelectItem>());
		semir007Bean.setPolicySPPopAdd(new Mir007Act());
		semir007Bean.getPolicySPPopAdd().setGenType("A");
		semir007Bean.setRenderPopupSave(false);
		setSemir007Bean(semir007Bean);
		semir007Bean.setPremiumList(new ArrayList<SelectItem>());
		semir007Bean.setTmpGenType(null);
		semmirPopupAction.setSemmirPopupBean(semmirPopupBean);
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private boolean validateFrmSearch(){
		boolean flagValid = false;
		
		if(StringUtils.isEmpty(getSemir007Bean().getPolicySP().getCompany())&&
//		   StringUtils.isEmpty(getSemir007Bean().getPolicySP().getGenType())&&
		   StringUtils.isEmpty(getSemir007Bean().getPolicySP().getNetworkType())&&
		   StringUtils.isEmpty(getSemir007Bean().getPolicySP().getTfType())&&
		   StringUtils.isEmpty(getSemir007Bean().getPolicySP().getDraftNo())&&
		   StringUtils.isEmpty(getSemir007Bean().getPolicySP().getPtType())&&
		   StringUtils.isEmpty(getSemir007Bean().getPolicySP().getDraftStatus())&&
		   StringUtils.isEmpty(getSemir007Bean().getPolicySP().getContractNo())&&
		   StringUtils.isEmpty(getSemir007Bean().getPolicySP().getLocationId())&&
		   StringUtils.isEmpty(getSemir007Bean().getPolicySP().getLocationCode())&&
		   StringUtils.isEmpty(getSemir007Bean().getPolicySP().getLocationName())
		   ){
			addMessageError("W0004", msg("message.requireOne"));
			flagValid = true;
		}
		
//		if(StringUtils.isEmpty(getSemir007Bean().getPolicySP().getCompany())){
//			addMessageError("W0001", msg("message.company"));
//			flagValid = true;
//		}
		
		return flagValid;
//		if (StringUtils.isNotEmpty(getSemmsi001Bean().getSearchCriteria().getDocNo()) || StringUtils.isNotEmpty(getSemmsi001Bean().getSearchCriteria().getContractNo())) {
//			return flagValid;
//		} else if (StringUtils.isEmpty(getSemmsi001Bean().getSearchCriteria().getCompany())) {
//			addMessageError("W0001", msg("message.company"));
//			flagValid = true;
//		}
//		
//		Date docDateFrom = getSemmsi001Bean().getSearchCriteria().getDocDateFrom();
//		Date docDateTo = getSemmsi001Bean().getSearchCriteria().getDocDateTo();
//		
//		if(docDateFrom != null && docDateTo != null){
//			if (docDateFrom.after(docDateTo)) {
//				addMessageErrorWithArgument("W0006" ,msg("message.docDtForm"), msg("message.docDtTo"));
//				flagValid = true;
//			}
//		}
	}
	
	private boolean validateFrmSearchDraft(){
		boolean flagValid = false;
		
		if(StringUtils.isEmpty(getSemir007Bean().getPolicySPPop().getCompany())){
			addMessageError("W0001", msg("message.company"));
			flagValid = true;
		}
		return flagValid;
	}

	private SEMMIR007Bean semir007Bean;

	public SEMMIR007Bean getSemir007Bean() {
		return (SEMMIR007Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmir007Bean");
	}

	public void setSemir007Bean(SEMMIR007Bean semir007Bean) {
		this.semir007Bean = semir007Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmir007Bean", semir007Bean);
	}
	
	public boolean doSearch(){
		
		boolean flag = false;
		SEMMIR007Bean semir007Bean = getSemir007Bean();
		ILovMasterService lovMasterService = (ILovMasterService)getBean("lovMasterService");
		List<PolicySP> to = null;
		semir007Bean.setPolicySPList(new ArrayList<WrapperBeanObject<PolicySP>>());
		semir007Bean.setRenderedMsgDataNotFound(false);
		try {
			if(validateFrmSearch()){
				semir007Bean.setRenderedMsgFormSearch(true);
				return flag;
			}else{
				semir007Bean.setRenderedMsgFormSearch(false);
				PolicySP policySP = semir007Bean.getPolicySP();
				log.debug("policySP.getInsuredAmt() = "+policySP.getInsuredAmt());
				//Check Insured Flag
				//policySP.setInsuredFlg((policySP.getInsuredFlg().equalsIgnoreCase("true")?"Y":"N"));
				//for new jboss
				policySP.setInsuredFlg((policySP.isInsuredFlgBoolean()?"Y":"N"));
				
				log.debug("Gentype = "+ policySP.getGenType());
				to = lovMasterService.querySPList(EQueryName.Q_POLICY.name, policySP);
				
				//Check Insured Flag
				//policySP.setInsuredFlg((policySP.getInsuredFlg().equalsIgnoreCase("Y")?"true":"false"));
				policySP.setInsuredFlg((policySP.getInsuredFlg().equalsIgnoreCase("Y")?"true":"false"));
				//for new jboss
				policySP.setInsuredFlgBoolean((policySP.getInsuredFlg().equalsIgnoreCase("Y")?true:false));
				log.debug("check "+(to != null && !to.isEmpty()));
				if(to != null && !to.isEmpty()){
					semir007Bean.setRenderedMsgDataNotFound(false);
					for(int i=0;i<to.size();i++){
						PolicySP o = to.get(i);
						WrapperBeanObject<PolicySP> tmpBeanObject = new WrapperBeanObject<PolicySP>();
						
						//Convert DateEnToThai
//						o.setExpDt(convertYearENtoTH(o.getExpDt()));
//						o.setUpdateDt(convertYearENtoTH(o.getUpdateDt()));
						o.setExpDtStr(convertYearENtoTHStr(o.getExpDt()));
						o.setUpdateDtStr(convertYearENtoTHStr(o.getUpdateDt()));
						
						tmpBeanObject.setDataObj(o);
						tmpBeanObject.setCheckBox(false);
						tmpBeanObject.setMessage("");
						
						semir007Bean.getPolicySPList().add(tmpBeanObject);
					}
				}else{
					semir007Bean.setRenderedMsgDataNotFound(true);
				}
				semir007Bean.setDisBtnRemove(true);
				semir007Bean.setDisBtnSave(true);
				setSemir007Bean(semir007Bean);
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean doSearchDraft(){
		boolean flag = false;
		SEMMIR007Bean semir007Bean = getSemir007Bean();
		ILovMasterService lovMasterService = (ILovMasterService)getBean("lovMasterService");
		List<PolicySP> to = null;
		
		try {
			if(validateFrmSearchDraft()){
				semir007Bean.setRenderedMsgFormSearchPopup(true);
				
				return flag;
			}else{
				semir007Bean.setRenderedMsgFormSearchPopup(false);
				to = lovMasterService.querySPList(EQueryName.SP_MIR007_SCH_D.name, semir007Bean.getPolicySPPop());
				if(to != null && !to.isEmpty()){
					semir007Bean.setRenderedMsgDataNotFoundPopup(false);
					semir007Bean.setPolicySPPopUpList(to);
				}else{
					semir007Bean.setRenderedMsgDataNotFoundPopup(true);
				}
				setSemir007Bean(semir007Bean);
				
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean doSave(){
		boolean flag = false;
		int count = 0;
		SEMMIR007Bean semir007Bean = getSemir007Bean();
		for(WrapperBeanObject<PolicySP> tmpBeanObject : semir007Bean.getPolicySPList()){
			if(tmpBeanObject.isCheckBox() == true){
				count++;
			}
		}
		String ms = "ต้องการ Save Gen List ทั้งหมด "+ count +" รายการ";
		semir007Bean.setMsCount(ms);		
		setSemir007Bean(semir007Bean);
		return flag;
	}
	
	public boolean saveGenList(){
		SEMMIR007Bean semir007Bean = getSemir007Bean();
		String action = (String) getFacesUtils().getRequestParameter("btnAction");
		ILovMasterService lovMasterService = (ILovMasterService)getBean("lovMasterService");
		List<Mir007Act> to = null;
		Mir007Act result = new Mir007Act();
		Mir007Act mir007Act;
		PolicySP po;
		StringBuffer errorMessage = new StringBuffer();
		boolean haveErr = false;
		try{
			
			List<WrapperBeanObject<PolicySP>> policyList = semir007Bean.getPolicySPList();
			for(int i=0;i<policyList.size();i++){
				if(policyList.get(i).isCheckBox()){
					/****************Set Value to SP*******************/
					po = (PolicySP)policyList.get(i).getDataObj();
					mir007Act = new Mir007Act();
					mir007Act.setGenType(po.getGenType());
					mir007Act.setActionType(action);
					mir007Act.setCompany(po.getCompany());
					mir007Act.setNetworkType(po.getNetworkType());
					mir007Act.setTransferType(po.getTfType());
					mir007Act.setPolicyType(po.getPolicyType());
					mir007Act.setLocationID(po.getLocationId());
					mir007Act.setDraftNo(po.getDraftNo());
					mir007Act.setUserID(getUserLogIn());
					/**************************************************/
					
					to =  lovMasterService.querySPList(EQueryName.SP_MIR007_ACT.name, mir007Act);
					
					if(to != null && !to.isEmpty()){
						result = to.get(0);
						log.debug("result.getResult() = "+result.getResult());
						log.debug("result.getRemark() = "+result.getRemark());
						if (!result.getResult().equalsIgnoreCase("Success")){
							errorMessage.append(result.getRemark()+",");
							haveErr = true;
						}
					}			
				}
			}
			if(haveErr){
				addGeneralMessageError(errorMessage.toString());
			}else{
				addMessageInfo("M0001");
			}
				
		}catch (Exception e) {
			e.printStackTrace();
			addMessageError("E0001");
		}
		semir007Bean.setRenderedMsgFormTop(true);
		semir007Bean.setRenderedMsgFormMiddle(false);
		setSemir007Bean(semir007Bean);
		return true;
	}
	
	public boolean doUpdate(){
		boolean flag = false;
		
		return flag;
	}

	public boolean initDelete(){
		boolean flag = false;
		int count = 0;
		semir007Bean = getSemir007Bean();
		semir007Bean.setPolicyDtlList(new ArrayList<PolicyDtl>());
		IPolicyService policyService = (IPolicyService)getBean("policyService");
		PolicyDtl pDtl = new PolicyDtl();
		PolicySP tmpPolicySP;
		for(WrapperBeanObject<PolicySP> tmpBeanObject : semir007Bean.getPolicySPList()){
			if(tmpBeanObject.isCheckBox() == true){
				count++;
				tmpPolicySP = (PolicySP)tmpBeanObject.getDataObj();
				if(StringUtils.isNotEmpty(tmpPolicySP.getPolicyDtlId())){
					try {
						pDtl = policyService.queryPolicyByRowId(tmpPolicySP.getPolicyDtlId());
						semir007Bean.getPolicyDtlList().add(pDtl);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				}
			}
		}
		String ms = "ต้องการ Remove From List ทั้งหมด "+ count +" รายการ";
		semir007Bean.setMsCount(ms);
		setSemir007Bean(semir007Bean);
		return flag;
	}
	
	public boolean doDelete(){
		boolean flag = false;
		IPolicyService policyService = (IPolicyService)getBean("policyService");
		semir007Bean = getSemir007Bean();
		for(PolicyDtl bean : semir007Bean.getPolicyDtlList()){
			try {
				policyService.deletePolicy(bean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	public boolean initPopup(){
		semir007Bean = getSemir007Bean();
		SEMMIRPopupAction semmirPopupAction = new SEMMIRPopupAction();
		SEMMIRPopupBean semmirPopupBean = semmirPopupAction.getSemmirPopupBean();
		semmirPopupBean.getPolicySP().setCompany(semir007Bean.getPolicySP().getCompany());
		semmirPopupBean.getPolicySP().setNetworkType(semir007Bean.getPolicySP().getNetworkType());
		semmirPopupBean.getPolicySP().setTfType(semir007Bean.getPolicySP().getTfType());
		semmirPopupBean.getPolicySP().setPtType(semir007Bean.getPolicySP().getPtType());
		semmirPopupBean.setPolicySPList(null);
		semmirPopupBean.setRenderedMsgDataNotFound(false);
//		setSemir007Bean(semir007Bean);
		return true;
	}
	
	public void initPopupAdd(){
		getSemir007Bean().setTmpGenType(null);
		getSemir007Bean().setPolicySPPopAdd(new Mir007Act());
		getSemir007Bean().setRefPolicyList(new ArrayList<SelectItem>());
		getSemir007Bean().getPolicySPPopAdd().setGenType("A");
		getSemir007Bean().setRenderReqRefPolicy(false);
		getSemir007Bean().setRenderReqTransferType(false);
		getSemir007Bean().setRenderedMsgFormSearchPopup(false);
		getSemir007Bean().setPopupCloseValidAdd(false);
		getSemir007Bean().setRenderContractNo(false);
		getSemir007Bean().setPremiumList(new ArrayList<SelectItem>());
	}
	
//	
//	public boolean initAdd() {
//		boolean flag = false;
//		semir005Bean = getSemir005Bean();
//		semir005Bean.setInsured(new Insured());
//		semir005Bean.setPopUpHeader("Add Master ทุนประกันภัย PLX");
//		setSemir005Bean(semir005Bean);
//		return flag;
//	}
//	
//	public boolean initEdit() {
//		boolean flag = false;
//		IInsuredService insuredService = (IInsuredService)getBean("insuredService");
//		String insuredId = (String)getFacesUtils().getRequestParameter("insuredId");
//		semir005Bean = getSemir005Bean();
//		try {
//			if (!StringUtils.isEmpty(insuredId)) {
//				semir005Bean.setInsured(insuredService.queryInsuredByRowId(insuredId));
//			} else {
//				String networkType = (String)getFacesUtils().getRequestParameter("insuredNetworkType");
//				String company = (String)getFacesUtils().getRequestParameter("insuredCompany");
//				Insured ins = new Insured();
//				ins.setNetworkType(networkType);
//				ins.setCompany(company);
//				semir005Bean.setInsured(ins);
//			}
//			semir005Bean.setPopUpHeader("Edit Master ทุนประกันภัย PLX");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		setSemir005Bean(semir005Bean);
//		return flag;
//	}
//	
//	public boolean doUpdate() {
//		boolean flag = false;
//		IInsuredService insuredService = (IInsuredService)getBean("insuredService");
//		semir005Bean = getSemir005Bean();
//		try {
//			insuredService.updateInsured(semir005Bean.getInsured());
//			doSearch();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return flag;
//	}
//	
//	public boolean initDelete() {
//		boolean flag = false;
//		IInsuredService insuredService = (IInsuredService)getBean("insuredService");
//		String insuredId = (String)getFacesUtils().getRequestParameter("insuredId");
//		semir005Bean = getSemir005Bean();
//		try {
//			if (StringUtils.isEmpty(insuredId)) {
//				semir005Bean.setRowId(null);
//				return false;
//			}
//			semir005Bean.setInsured(insuredService.queryInsuredByRowId(insuredId));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return flag;
//	}
//	
//	public boolean doDelete() {
//		boolean flag = false;
//		IInsuredService insuredService = (IInsuredService)getBean("insuredService");
//		semir005Bean = getSemir005Bean();
//		try {
//			if (!StringUtils.isEmpty(semir005Bean.getRowId())) {
//				insuredService.deleteInsured(semir005Bean.getInsured());
//				doSearch();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return flag;
//	}
//	
	public boolean doClear() {
		boolean flag = false;
		SEMMIR007Bean semir007Bean = new SEMMIR007Bean();
		SEMMIRPopupBean semmirPopupBean = new SEMMIRPopupBean();
		SEMMIRPopupAction semmirPopupAction = new SEMMIRPopupAction();
		semir007Bean.setPolicySP(new PolicySP());
		semir007Bean.getPolicySP().setGenType("A");
		semir007Bean.getPolicySP().setDeductType("M");
		semir007Bean.getPolicySP().setInsuredAmt(0.00);
		semir007Bean.setPolicySPPop(new PolicySP());
		semir007Bean.setPolicySPList(new ArrayList<WrapperBeanObject<PolicySP>>());
		semir007Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semir007Bean.setNetworkTypeList(getLovItemsByType(ELovType.T_IR_NETWORK_TYPES.name));
		semir007Bean.setTransferTypeList(getLovItemsByType(ELovType.T_IR_TRANSFER_TYPES.name));
		semir007Bean.setPolicyTypeList(getLovItemsByType(ELovType.T_IR_POLICY_TYPE.name));
		semir007Bean.setDraftStatusList(getLovItemsByType(ELovType.T_IR_DRAFT_STATUS.name));
		semmirPopupBean.setPolicySP(new PolicySP());
		semmirPopupBean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmirPopupBean.setNetworkTypeList(getLovItemsByType(ELovType.T_IR_NETWORK_TYPES.name));
		semmirPopupBean.setTransferTypeList(getLovItemsByType(ELovType.T_IR_TRANSFER_TYPES.name));
		semmirPopupBean.setPolicyTypeList(getLovItemsByType(ELovType.T_IR_POLICY_TYPE.name));
		semir007Bean.setInsuredFlg(true);
		semir007Bean.setRefPolicyList(new ArrayList<SelectItem>());
		semir007Bean.setPolicySPPopAdd(new Mir007Act());
		semir007Bean.getPolicySPPopAdd().setGenType("A");
		semir007Bean.setRenderPopupSave(false);
		setSemir007Bean(semir007Bean);
		semir007Bean.setPremiumList(new ArrayList<SelectItem>());
		semir007Bean.setTmpGenType(null);
		semmirPopupAction.setSemmirPopupBean(semmirPopupBean);
		
//		semir007Bean = getSemir007Bean();
//		semir007Bean.setPolicySP(new PolicySP());
//		semir007Bean.getPolicySP().setGenType("A");
//		semir007Bean.getPolicySP().setDeductType("M");
//		semir007Bean.setPolicySPList(new ArrayList<WrapperBeanObject<PolicySP>>());
//		semir007Bean.setRenderedMsgFormSearch(false);
//		semir007Bean.getPolicySP().setChangeCapital(0);
//		semir007Bean.setInsuredFlg(true);
//		semir007Bean.setDraftID(null);
//		semir007Bean.setRenderedMsgDataNotFound(false);
//		setSemir007Bean(semir007Bean);
		return flag;
	}
	
	public boolean doClearPop() {
		semir007Bean = getSemir007Bean();
		semir007Bean.setPolicySPPop(new PolicySP());
		semir007Bean.setRenderedMsgFormSearch(false);
		setSemir007Bean(semir007Bean);
		return false;
	}
	
	public void disableTxtBox(){
		semir007Bean = getSemir007Bean();
		if(semir007Bean.getPolicySP().isInsuredFlgBoolean()){
			semir007Bean.setInsuredFlg(false);
		}else{
			semir007Bean.getPolicySP().setChangeCapital(0);
			semir007Bean.setInsuredFlg(true);
		}
		
		setSemir007Bean(semir007Bean);
	}
	
	public void checkPopupBox(){
		semir007Bean = getSemir007Bean();
		String draftNo = (String)getFacesUtils().getRequestParameter("draftNo");
//		semir007Bean.setDraftID(draftNo);
		List<PolicySP> list = semir007Bean.getPolicySPPopUpList();
		for(PolicySP policySP : list){
			if (policySP.getDraftNo().equalsIgnoreCase(draftNo) && policySP.isSelected()) {
				semir007Bean.setDraftID(draftNo);
			}
		}
		
		setSemir007Bean(semir007Bean);
	}
	
	public void selectItem(){
		semir007Bean = getSemir007Bean();
		semir007Bean.getPolicySP().setDraftNo(semir007Bean.getDraftID());
		semir007Bean.setDraftID(null);
		setSemir007Bean(semir007Bean);
	}
	
	public void cancelPopup(){
		semir007Bean = getSemir007Bean();
		semir007Bean.setDraftID(null);
		setSemir007Bean(semir007Bean);
	}
	
	public void selectAllRow(){
		try{
			boolean chkAll = getSemir007Bean().isChkSelAll();
			List<WrapperBeanObject<PolicySP>> detailList = new ArrayList<WrapperBeanObject<PolicySP>>();
			detailList = getSemir007Bean().getPolicySPList();
			for(int i=0; i<detailList.size(); i++){
				detailList.get(i).setCheckBox(chkAll);
			}
			onRenderExportButton();
		}catch(NullPointerException ne){

		}catch(Exception e){
			
		}
	}
	
	public void onRenderExportButton() {
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		getSemir007Bean().setTmpRowId(rowId);
		if (isCheckSELBox()) {
			getSemir007Bean().setDisBtnRemove(false);
			getSemir007Bean().setDisBtnSave(false);
		} else {
			getSemir007Bean().setDisBtnRemove(true);
			getSemir007Bean().setDisBtnSave(true);
		}
	}
	
	private boolean isCheckSELBox() {
		boolean isCheck = false;
		
		List<WrapperBeanObject<PolicySP>> list = getSemir007Bean().getPolicySPList();
		for (WrapperBeanObject<PolicySP> wrapperBeanObject : list) {
			if (wrapperBeanObject.isCheckBox()) {
				return true;
			}
		}
		return isCheck;
	}
	
	public boolean selectRefPolicyNo(){
		List<PolicySP> to = new ArrayList<PolicySP>();
		IInsuredService service = (IInsuredService)getBean("insuredService");
		semir007Bean = getSemir007Bean();
		if(validatePopupAdd()){
			try{
				PolicySP policySP = new PolicySP();
				policySP.setCompany(getSemir007Bean().getPolicySPPopAdd().getCompany());
				policySP.setNetworkType(getSemir007Bean().getPolicySPPopAdd().getNetworkType());
				policySP.setTransferType(getSemir007Bean().getPolicySPPopAdd().getTransferType());
				policySP.setPolicyType(getSemir007Bean().getPolicySPPopAdd().getPolicyType());
				log.debug("Company = "+policySP.getCompany());
				log.debug("getNetworkType = "+policySP.getNetworkType());
				log.debug("getTransferType = "+policySP.getTransferType());
				log.debug("getPolicyType = "+policySP.getPolicyType());
				to = service.querySPList(EQueryName.SP_MIR007_SCH_D.name, policySP);
				if(to != null && !to.isEmpty()){
					List<SelectItem> refPolicyList = new ArrayList<SelectItem>();
					SelectItem selectItem = new SelectItem();
					String value;
					for(int i=0;i<to.size();i++){
						selectItem = new SelectItem();
						value = (StringUtils.isNotEmpty(to.get(i).getPolicyNo()))?to.get(i).getPolicyNo():"";
						selectItem.setLabel(value);
						selectItem.setValue(value);
						refPolicyList.add(selectItem);
						if(i == 0)
							semir007Bean.getPolicySPPopAdd().setRefPolicyNo(value);
					}
					semir007Bean.setPolicySPPopUpList(to);
					semir007Bean.setDisableRefPolicy((refPolicyList.size()>1)?false:true);
					semir007Bean.setRefPolicyList(refPolicyList);
					setSemir007Bean(semir007Bean);
					
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			semir007Bean.setPolicySPPopUpList(new ArrayList<PolicySP>());
			semir007Bean.setRefPolicyList(new ArrayList<SelectItem>());
			semir007Bean.getPolicySPPopAdd().setEffDt(null);
			semir007Bean.getPolicySPPopAdd().setExpDt(null);
			semir007Bean.getPolicySPPopAdd().setNewEffDt(null);
			semir007Bean.getPolicySPPopAdd().setNewExpDt(null);
		}

		
		//semir007Bean.setRenderReqTransferType((semir007Bean.getPolicySPPopAdd().getPolicyType().equals("01"))?true:false);
		//semir007Bean.setRenderContractNo((semir007Bean.getPolicySPPopAdd().getPolicyType().equals("03") || (semir007Bean.getPolicySPPopAdd().getPolicyType().equals("04")))?true:false);
		
		//====fixed new jboss error null
		semir007Bean.setRenderReqTransferType("01".equals(semir007Bean.getPolicySPPopAdd().getPolicyType())?true:false);
		semir007Bean.setRenderContractNo(("03".equals(semir007Bean.getPolicySPPopAdd().getPolicyType())) || ("04".equals(semir007Bean.getPolicySPPopAdd().getPolicyType()))?true:false);
		
		setSemir007Bean(semir007Bean);
		getEffExpDate();
		getPremium();
		return false;
	}
	public boolean validatePopupAdd(){
		boolean flag = true;
		if(StringUtils.isEmpty(getSemir007Bean().getPolicySPPopAdd().getCompany()) ||
			StringUtils.isEmpty(getSemir007Bean().getPolicySPPopAdd().getNetworkType()) ||
			StringUtils.isEmpty(getSemir007Bean().getPolicySPPopAdd().getTransferType()) ||
			StringUtils.isEmpty(getSemir007Bean().getPolicySPPopAdd().getPolicyType())){
			flag = false;
		}
		return flag;
	}
	
	public void getEffExpDate(){
		semir007Bean = getSemir007Bean();
		List<PolicySP> list;
		PolicySP po = new PolicySP();
		if(semir007Bean.getPolicySPPopUpList() != null && semir007Bean.getPolicySPPopUpList().size() >0){
			list = semir007Bean.getPolicySPPopUpList();
			for(int i=0;i<list.size();i++){
				po = list.get(i);
				if(po.getPolicyNo().equalsIgnoreCase(semir007Bean.getPolicySPPopAdd().getRefPolicyNo())){
					semir007Bean.getPolicySPPopAdd().setEffDt(po.getEffDt());
					semir007Bean.getPolicySPPopAdd().setExpDt(po.getExpDt());
					if(semir007Bean.getPolicySPPopAdd().getGenType().equals("A")){
						//Set New Policy Eff and Exp Date
						Calendar cal1=Calendar.getInstance();
						Calendar cal2=Calendar.getInstance();
						cal1.setTime(po.getExpDt());
						DateUtil.setDay(cal1, DateUtil.getDay(cal1)+1);						
						semir007Bean.getPolicySPPopAdd().setNewEffDt(cal1.getTime());
						cal2.setTime(semir007Bean.getPolicySPPopAdd().getNewEffDt());
						DateUtil.setYear(cal2, DateUtil.getYear(cal2)+1);
						DateUtil.setDay(cal2, DateUtil.getDay(cal2)-1);
						semir007Bean.getPolicySPPopAdd().setNewExpDt(cal2.getTime());
					}else{
						semir007Bean.getPolicySPPopAdd().setNewEffDt(po.getEffDt());
						semir007Bean.getPolicySPPopAdd().setNewExpDt(po.getExpDt());
					}
					
				}
			}
		}
		setSemir007Bean(semir007Bean);
		getPremium();
	}
	
	public void chkGenType(){
		getSemir007Bean().setRenderReqRefPolicy((getSemir007Bean().getPolicySPPopAdd().getGenType().equals("U"))?true:false);
		if(!StringUtils.equalsIgnoreCase(getSemir007Bean().getTmpGenType(), getSemir007Bean().getPolicySPPopAdd().getGenType())){
			getSemir007Bean().setTmpGenType(getSemir007Bean().getPolicySPPopAdd().getGenType());
			getSemir007Bean().setPolicySPPopAdd(new Mir007Act());
			getSemir007Bean().getPolicySPPopAdd().setGenType(getSemir007Bean().getTmpGenType());
			getSemir007Bean().setRefPolicyList(new ArrayList<SelectItem>());
			getSemir007Bean().setRenderReqRefPolicy(false);
			getSemir007Bean().setRenderReqTransferType(false);
			getSemir007Bean().setRenderedMsgFormSearchPopup(false);
			getSemir007Bean().setPopupCloseValidAdd(false);
			getSemir007Bean().setRenderContractNo(false);
			getSemir007Bean().setPremiumList(new ArrayList<SelectItem>());
		}
	}
	
	public void initAdd(){
		boolean resultValid = true;
		
		semir007Bean = getSemir007Bean();
		semir007Bean.setPopupCloseValidAdd(false);
		
		if(StringUtils.isEmpty(semir007Bean.getPolicySPPopAdd().getCompany())){
			resultValid = false;
			addMessageError("W0001", msg("message.companyEn"));
		}
//		if(!semir007Bean.isRenderContractNo() && StringUtils.isEmpty(semir007Bean.getPolicySPPopAdd().getNetworkType())){
//			resultValid = false;
//			addMessageError("W0001", msg("message.networkType"));
//		}
		if(semir007Bean.isRenderReqTransferType() && StringUtils.isEmpty(semir007Bean.getPolicySPPopAdd().getNetworkType())){
			resultValid = false;
			addMessageError("W0001", msg("message.networkType"));
		}
//		if(StringUtils.isEmpty(semir007Bean.getPolicySPPopAdd().getTransferType())){
//			resultValid = false;
//			addMessageError("W0001", msg("message.transferType"));
//		}
		if(StringUtils.isEmpty(semir007Bean.getPolicySPPopAdd().getPolicyType())){
			resultValid = false;
			addMessageError("W0001", msg("message.policyType"));
		}
		if(semir007Bean.isRenderContractNo() && StringUtils.isEmpty(semir007Bean.getPolicySPPopAdd().getContractNo())){
			resultValid = false;
			addMessageError("W0001", msg("message.contractNo3"));
		}
		if(semir007Bean.isRenderReqTransferType() && StringUtils.isEmpty(semir007Bean.getPolicySPPopAdd().getTransferType())){
			resultValid = false;
			addMessageError("W0001", msg("message.transferType"));
		}
		if(semir007Bean.isRenderReqRefPolicy() && StringUtils.isEmpty(semir007Bean.getPolicySPPopAdd().getRefPolicyNo())){
			resultValid = false;
			addMessageError("W0001", msg("message.refPolicyNo"));
		}
		if(semir007Bean.getPolicySPPopAdd().getNewEffDt() == null){
			resultValid = false;
			addMessageError("W0001", msg("message.newPolicyEffDt"));
		}
		if(semir007Bean.getPolicySPPopAdd().getNewExpDt() == null){
			resultValid = false;
			addMessageError("W0001", msg("message.newPolicyExpDt"));
		}
		if(!semir007Bean.isRenderContractNo()){
			if(StringUtils.isEmpty(semir007Bean.getPolicySPPopAdd().getDataAsOf())){
				resultValid = false;
				addMessageError("W0001", msg("message.dataAsOf"));
			}
			String msgError = SemUtils.chkMonthYearFormat(semir007Bean.getPolicySPPopAdd().getDataAsOf());
			if(msgError!=null && !"".equals(semir007Bean.getPolicySPPopAdd().getDataAsOf())){
				addMessageError("W0102", msg("message.asof")+" ("+msg(msgError)+") ");
				resultValid = false;
			}
		}
		
		if(resultValid){
			Mir007Act mir007Act = semir007Bean.getPolicySPPopAdd();
			if(mir007Act != null){
				log.debug("gentype = "+mir007Act.getGenType());
				if("A".equals(mir007Act.getGenType()) && mir007Act.getExpDt() != null){
					log.debug("check = "+mir007Act.getExpDt().after(mir007Act.getNewEffDt()));
					if(mir007Act.getExpDt().after(mir007Act.getNewEffDt())){
						semir007Bean.setConfirmPopupAddMsg(MSGCacheUtil.getInstance().getMessageByCode("W0104"));
						resultValid = false;
					}
				}else if(mir007Act.getEffDt() != null) {
					log.debug("compare to = "+mir007Act.getEffDt().compareTo(mir007Act.getNewEffDt()));
					if(mir007Act.getEffDt().compareTo(mir007Act.getNewEffDt()) != 0 || mir007Act.getExpDt().compareTo(mir007Act.getNewExpDt()) != 0){
						semir007Bean.setConfirmPopupAddMsg(MSGCacheUtil.getInstance().getMessageByCode("W0104"));
						resultValid = false;
					}
					
				}
			}
			semir007Bean.setPopupCloseValidAdd(!resultValid);
			semir007Bean.setRenderPopupSave(resultValid);
			semir007Bean.setRenderedMsgFormBottom(true);
			
			//fix by new 2016/09/26
			if(semir007Bean.isRenderPopupSave()){
				this.doAdd();
				semir007Bean.setRenderedMsgFormSearch(true);
				semir007Bean.setRenderedMsgFormSearchPopup(false);
				semir007Bean.setRenderedMsgFormBottom(false);
			}
		}else{
			semir007Bean.setRenderedMsgFormSearchPopup(true);
			semir007Bean.setRenderedMsgFormSearch(false);
			semir007Bean.setRenderedMsgFormBottom(false);
		}
		
		setSemir007Bean(semir007Bean);
	}
	
	public boolean doAdd(){
		boolean flag = false;
		List<Mir007Act> to = new ArrayList<Mir007Act>();
		Mir007Act mir007Add = new Mir007Act();
		IInsuredService service = (IInsuredService)getBean("insuredService");
		semir007Bean = getSemir007Bean();
		semir007Bean.setRenderPopupSave(false);
		try{
			//Set asMonth & asYear
			if(StringUtils.isNotEmpty(semir007Bean.getPolicySPPopAdd().getDataAsOf())){
				String[] tmp = SemUtils.convertMonthYearTH2MonthYearEN(semir007Bean.getPolicySPPopAdd().getDataAsOf()).split("/");
				semir007Bean.getPolicySPPopAdd().setAsMonth(tmp[0]);
				semir007Bean.getPolicySPPopAdd().setAsYear(tmp[1]);
			}
			
			if (semir007Bean.getPolicySPPopAdd()!=null){
			semir007Bean.getPolicySPPopAdd().setUserID(getUserLogIn());
			}
			
			to = service.querySPList(EQueryName.SP_MIR007_ADD.name, semir007Bean.getPolicySPPopAdd());
			if (to != null && !to.isEmpty() && to.get(0).getResult().equals("Success")) {
				addMessageInfo("M0001");
				addGeneralMessageInfo(to.get(0).getRemark());
				
				semir007Bean.setPopupClose(new Boolean(true));
			}else if(to != null && !to.isEmpty()){
				FrontMessageUtils.addMessageError(to.get(0).getRemark());
			}
			flag = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public void searchContract(){
		semir007Bean = getSemir007Bean();
		ISiteContractService siteContractService = (ISiteContractService)getBean("siteContractService");
		List<PopupContractSearchSP> to = null;
		getSemir007Bean().setRenderedMsgFormSearchPopup(false);
		getSemir007Bean().setRenderedMsgFormSearch(false);
		getSemir007Bean().setRenderedMsgFormBottom(false);
		
		PopupContractSearchSP popupCriteria = new PopupContractSearchSP();
		popupCriteria.setContractNo(semir007Bean.getPolicySPPopAdd().getContractNo());
		try{
			to = siteContractService.querySPList(EQueryName.Q_SEARCH_POPUP_SITE_CONTRACT.name, popupCriteria);
			if (null == to || to.isEmpty()) {
				// set error message after search not found
				addMessageErrorWithArgument("W0032",semir007Bean.getPolicySPPopAdd().getContractNo());
				getSemir007Bean().setRenderedMsgFormSearchPopup(true);
			}else if(to != null && to.size() > 0){
				log.debug("size [" + to.size() + "]");
				semir007Bean.getPolicySPPopAdd().setNewEffDt(SEMDataUtility.convertToThYear(to.get(0).getEffDate()));
				semir007Bean.getPolicySPPopAdd().setNewExpDt(SEMDataUtility.convertToThYear(to.get(0).getExpDate()));
			}
				
		}catch(Exception e){
			e.printStackTrace();
		}
		
		setSemir007Bean(semir007Bean);
		getPremium();
	}
	
	public boolean getPremium(){
		List<Premium> to = new ArrayList<Premium>();
		IPremiumService service = (IPremiumService)getBean("premiumService");
		semir007Bean = getSemir007Bean();
		List<SelectItem> refPolicyList = new ArrayList<SelectItem>();
		try{
			Premium premium = new Premium();
			premium.setCompany(getSemir007Bean().getPolicySPPopAdd().getCompany());
			premium.setNetworkType(getSemir007Bean().getPolicySPPopAdd().getNetworkType());
			premium.setTransferType(getSemir007Bean().getPolicySPPopAdd().getTransferType());
			premium.setPolicyType(getSemir007Bean().getPolicySPPopAdd().getPolicyType());
			premium.setEffDt(getSemir007Bean().getPolicySPPopAdd().getNewEffDt());
			premium.setExpDt(getSemir007Bean().getPolicySPPopAdd().getNewExpDt());
			log.debug("Company = "+premium.getCompany());
			log.debug("getNetworkType = "+premium.getNetworkType());
			log.debug("getTransferType = "+premium.getTransferType());
			log.debug("getPolicyType = "+premium.getPolicyType());
			to = service.querySPList(EQueryName.SP_MIR007_SCH_R.name, premium);
			if(to != null && !to.isEmpty()){
				
				SelectItem selectItem = new SelectItem();
				for(int i=0;i<to.size();i++){
					selectItem = new SelectItem();
					selectItem.setLabel((to.get(i).getPremiumRate() != null)?SEMDataUtility.convertNumberToStringByFormat(to.get(i).getPremiumRate(), "#,##0.00000000"):"");
					selectItem.setValue(StringUtils.isNotEmpty(to.get(i).getRowId())?to.get(i).getRowId():"");
					refPolicyList.add(selectItem);
				}
				semir007Bean.setPremiumList(refPolicyList);
				setSemir007Bean(semir007Bean);
			}
			semir007Bean.setPremiumList(refPolicyList);
			setSemir007Bean(semir007Bean);
		}catch (Exception e) {
			e.printStackTrace();
		}
			
		return false;
	}
}

