package th.co.ais.web.ir.action;

import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.internal.ObjectData;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;

import th.co.ais.domain.gm.BgMasterSP;
import th.co.ais.domain.ir.PolicySP;
import th.co.ais.service.gm.ILovMasterService;
import th.co.ais.util.EQueryName;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.ir.bean.SEMMIR007Bean;
import th.co.ais.web.ir.bean.SEMMIR008Bean;
import th.co.ais.web.ir.bean.SEMMIRPopupBean;

public class SEMMIRPopupAction extends AbstractAction {
	
	private static final String semmir007Page = "SEMMIR007-1";
	private static final String semmir008Page = "SEMMIR008-1";
	private Logger LOG = Logger.getLogger(getClass());
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		// TODO Auto-generated method stub
		if(methodWithNavi.equalsIgnoreCase("doSearch")){
			return doSearch();
		}
		if(methodWithNavi.equalsIgnoreCase("initPopup")){
			return initPopup();
		}
		if(methodWithNavi.equalsIgnoreCase("doClear")){
			return doClear();
		}
		return false;
	}
	
	public boolean doSearch(){
		boolean flag = false;
		SEMMIRPopupBean semmirPopupBean = getSemmirPopupBean();
		ILovMasterService lovMasterService = (ILovMasterService)getBean("lovMasterService");
		List<PolicySP> to = null;
		try {
			if(validateFormSearch()){
				semmirPopupBean.setRenderedMsgFormSearch(true);
				
				return flag;
			}else{
				semmirPopupBean.setRenderedMsgFormSearch(false);
				semmirPopupBean.setRenderedMsgDataNotFound(false);
				semmirPopupBean.setPolicySPList(new ArrayList<WrapperBeanObject<PolicySP>>());
				to = lovMasterService.querySPList(EQueryName.SP_MIR007_SCH_D.name, semmirPopupBean.getPolicySP());
				
				if(to != null && !to.isEmpty()){
					semmirPopupBean.setPolicySPList(new ArrayList<WrapperBeanObject<PolicySP>>());
					for(int i = 0;i<to.size();i++){
						PolicySP o = to.get(i);
						WrapperBeanObject<PolicySP> tmpWrapperBean = new WrapperBeanObject<PolicySP>();
						
						tmpWrapperBean.setDataObj(o);
						tmpWrapperBean.setMessage("");
						tmpWrapperBean.setDisableCheckBox(false);
						
						semmirPopupBean.getPolicySPList().add(tmpWrapperBean);
					}
				}else{
					semmirPopupBean.setRenderedMsgDataNotFound(true);
				}
				setSemmirPopupBean(semmirPopupBean);
				
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
	}
	
	public boolean initPopup(){
		System.out.println("initPopup");
		semmirPopupBean = getSemmirPopupBean();
		String company = "";
		String networkType = "";
		String tfType = "";
		String ptType = "";
		String page = (String)getFacesUtils().getRequestParameter("pageFrom");
		semmirPopupBean.setPolicySP(new PolicySP());
//		semir007
		
		System.out.println("page = "+page);		
		if(page.equalsIgnoreCase(semmir007Page)){
			SEMMIR007Bean semir007Bean = (SEMMIR007Bean) new SEMMIR007Action().getSemir007Bean();
			company = semir007Bean.getPolicySP().getCompany();
			networkType = semir007Bean.getPolicySP().getNetworkType();
			tfType = semir007Bean.getPolicySP().getTfType();
			ptType = semir007Bean.getPolicySP().getPtType();
		}else if(page.equalsIgnoreCase(semmir008Page)){
			SEMMIR008Bean semmir008Bean = (SEMMIR008Bean)new SEMMIR008Action().getSemmir008Bean();
			company = semmir008Bean.getPolicySP().getCompany();
			networkType = semmir008Bean.getPolicySP().getNetworkType();
			tfType = semmir008Bean.getPolicySP().getTfType();
			ptType = semmir008Bean.getPolicySP().getPtType();
		}
		
		semmirPopupBean.setCurrentPage(page);
		semmirPopupBean.getPolicySP().setCompany(company);
		semmirPopupBean.getPolicySP().setNetworkType(networkType);
		semmirPopupBean.getPolicySP().setTfType(tfType);
		semmirPopupBean.getPolicySP().setPtType(ptType);
		semmirPopupBean.setPolicySPList(null);
		semmirPopupBean.setRenderedMsgDataNotFound(false);
		semmirPopupBean.setDisableBtnSelect(true);
		setSemmirPopupBean(semmirPopupBean);
		return true;
	}

	@Override
	public boolean validate() {
		
		return false;
	}
	
	private boolean validateFormSearch(){
		boolean flagValid = false;
		
		if(StringUtils.isEmpty(getSemmirPopupBean().getPolicySP().getCompany())){
			addMessageError("W0001", msg("message.company"));
			flagValid = true;
		}
		return flagValid;
	}
	
	private SEMMIRPopupBean semmirPopupBean;
	
	public SEMMIRPopupBean getSemmirPopupBean(){
		SEMMIRPopupBean semmirPopupBean = (SEMMIRPopupBean) getFacesUtils().getSessionMapValue("semmirPopupBean");
		return (semmirPopupBean == null)?new SEMMIRPopupBean():semmirPopupBean;
	}
	
	public void setSemmirPopupBean(SEMMIRPopupBean semmirPopupBean){
		getFacesUtils().setSessionMapValue("semmirPopupBean", semmirPopupBean);
	}
	
	public boolean doClear() {
		semmirPopupBean = getSemmirPopupBean();
		semmirPopupBean.setPolicySP(new PolicySP());
		semmirPopupBean.setRenderedMsgFormSearch(false);
		semmirPopupBean.setPolicySPList(null);
		semmirPopupBean.setDisableBtnSelect(true);
		setSemmirPopupBean(semmirPopupBean);
		return false;
	}
	
	public void checkPopupBox(){
		semmirPopupBean = getSemmirPopupBean();
		String draftNo = (String)getFacesUtils().getRequestParameter("draftNo");
		List<WrapperBeanObject<PolicySP>> list = semmirPopupBean.getPolicySPList();
		PolicySP policySP;
		semmirPopupBean.setPolicySPList(new ArrayList<WrapperBeanObject<PolicySP>>());
		//Check and remove other check
		for(WrapperBeanObject<PolicySP> tmpWrapperBeanObject : list){
			policySP = (PolicySP)tmpWrapperBeanObject.getDataObj();
			if (policySP.getDraftNo().equalsIgnoreCase(draftNo) && tmpWrapperBeanObject.isCheckBox()) {
				semmirPopupBean.setDraftID(draftNo);
				semmirPopupBean.getPolicySPList().add(tmpWrapperBeanObject);
			}else{
				tmpWrapperBeanObject.setCheckBox(false);
				semmirPopupBean.getPolicySPList().add(tmpWrapperBeanObject);
			}			
		}
		if(isCheckSELBox()){
			semmirPopupBean.setDisableBtnSelect(false);
		}else{
			semmirPopupBean.setDisableBtnSelect(true);
		}
		setSemmirPopupBean(semmirPopupBean);
		
	}
	
	private boolean isCheckSELBox(){
		boolean isCheck = false;
		List<WrapperBeanObject<PolicySP>> list = getSemmirPopupBean().getPolicySPList();
		for (WrapperBeanObject<PolicySP> wrapperBeanObject : list) {
			if(wrapperBeanObject.isCheckBox()){
				return true;
			}
		}
		return isCheck;
	}
	
	public void selectItem(){
		semmirPopupBean = getSemmirPopupBean();
		//Check Page
		System.out.println("semmirPopupBean.getCurrentPage()"+semmirPopupBean.getCurrentPage());
		if(semmirPopupBean.getCurrentPage().equalsIgnoreCase(semmir007Page)){
			SEMMIR007Action semir007Action = new SEMMIR007Action();
			SEMMIR007Bean semir007Bean = (SEMMIR007Bean) semir007Action.getSemir007Bean();
			semir007Bean.getPolicySP().setDraftNo(semmirPopupBean.getDraftID());
			semir007Action.setSemir007Bean(semir007Bean);
		}else if(semmirPopupBean.getCurrentPage().equalsIgnoreCase(semmir008Page)){
			System.out.println("test");
			SEMMIR008Action semmir008Action = new SEMMIR008Action();
			SEMMIR008Bean semmir008Bean = (SEMMIR008Bean)semmir008Action.getSemmir008Bean();
			semmir008Bean.getPolicySP().setDraftNo(semmirPopupBean.getDraftID());
			semmir008Action.setSemmir008Bean(semmir008Bean);
		}
		semmirPopupBean.setDraftID(null);
	}
	
	public void cancelPopup(){
		semmirPopupBean = getSemmirPopupBean();
		semmirPopupBean.setDraftID(null);
		setSemmirPopupBean(semmirPopupBean);
	}

}
