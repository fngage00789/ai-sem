package th.co.ais.web.ir.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.ir.Mir013Sch;
import th.co.ais.service.ir.IInsuredService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.common.PopupMultiZoneBean;
import th.co.ais.web.ir.bean.SEMMIR014Bean;
import th.co.ais.web.util.SemUtils;

public class SEMMIR014Action extends AbstractAction {
	
	private Logger log = Logger.getLogger(getClass());
	
	private SEMMIR014Bean semmir014Bean;
	
	private SEMMIR014Bean getSemmir014Bean(){
		SEMMIR014Bean semmir014Bean = (SEMMIR014Bean)getFacesUtils().getSessionMapValue("semmir014Bean");
		if(semmir014Bean == null)
			semmir014Bean = new SEMMIR014Bean();
		return semmir014Bean;
	}
	private void setSemmir014Bean(SEMMIR014Bean semmir014Bean){
		getFacesUtils().setSessionMapValue("semmir014Bean", semmir014Bean);
	}
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if(methodWithNavi.equalsIgnoreCase("doSearch")){
			flag = doSearch();
		}else if(methodWithNavi.equalsIgnoreCase("doClear")){
			flag = doClear();
		}else if(methodWithNavi.equalsIgnoreCase("doBack")){
			flag = true;
		}else if (methodWithNavi.equalsIgnoreCase("doBackPage")) {
			flag = true;
		}
		
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		SEMMIR014Bean semmir014Bean = new SEMMIR014Bean();
		semmir014Bean.setPopupMultiZoneBean(new PopupMultiZoneBean());
		semmir014Bean.setMir013SchSP(new Mir013Sch());
		semmir014Bean.setMir013SchSPList(new ArrayList<WrapperBeanObject<Mir013Sch>>());
		semmir014Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmir014Bean.setNetworkTypeList(getLovItemsByType(ELovType.T_IR_NETWORK_TYPES.name));
		semmir014Bean.setTransferTypeList(getLovItemsByType(ELovType.T_IR_TRANSFER_TYPES.name));
		semmir014Bean.setPolicyTypeList(getLovItemsByType(ELovType.T_IR_POLICY_TYPE.name));
		semmir014Bean.setClaimStatusList(getLovItemsByType(ELovType.T_IR_CLAIM_STATUS.name));
		semmir014Bean.setLossTypeList(getLovItemsByType(ELovType.T_IR_LOSS_TYPE.name));
		setSemmir014Bean(semmir014Bean);
	}

	@Override
	public boolean validate() {
		boolean flag = true;
		if(StringUtils.isNotEmpty(getSemmir014Bean().getMir013SchSP().getCompany()) ||
			StringUtils.isNotEmpty(getSemmir014Bean().getMir013SchSP().getNetworkType()) ||
			StringUtils.isNotEmpty(getSemmir014Bean().getMir013SchSP().getTransferType()) ||
			StringUtils.isNotEmpty(getSemmir014Bean().getMir013SchSP().getPolicyType()) ||
			StringUtils.isNotEmpty(getSemmir014Bean().getMir013SchSP().getPolicyNo()) ||
			StringUtils.isNotEmpty(getSemmir014Bean().getMir013SchSP().getContractNo()) ||
			StringUtils.isNotEmpty(getSemmir014Bean().getMir013SchSP().getLocationCode()) ||
			StringUtils.isNotEmpty(getSemmir014Bean().getMir013SchSP().getLocationId()) ||
			StringUtils.isNotEmpty(getSemmir014Bean().getMir013SchSP().getLocationName()) ||
			StringUtils.isNotEmpty(getSemmir014Bean().getMir013SchSP().getRegion()) ||
			(getSemmir014Bean().getPopupMultiZoneBean() != null && getSemmir014Bean().getPopupMultiZoneBean().getSelectedList().size() > 0) ||
			getSemmir014Bean().getMir013SchSP().getClaimDtFrom() != null ||
			getSemmir014Bean().getMir013SchSP().getClaimDtTo() != null ||
			getSemmir014Bean().getMir013SchSP().getCloseDtFrom() != null ||
			getSemmir014Bean().getMir013SchSP().getCloseDtTo() != null ||
			StringUtils.isNotEmpty(getSemmir014Bean().getMir013SchSP().getClaimNo()) ||
			StringUtils.isNotEmpty(getSemmir014Bean().getMir013SchSP().getClaimStatus()) ||
			getSemmir014Bean().getMir013SchSP().getLossDtFrom() != null 				
			){
				flag = false;
			}else{
				addMessageError("W0004", msg("message.requireOne"));
			}
		return flag;
	}
	
	public boolean doSearch(){
		boolean flag = false;
		semmir014Bean = getSemmir014Bean();
		IInsuredService insuredService = (IInsuredService)getBean("insuredService");
		
		List<Mir013Sch> to = null;
		try{
			if(validate()){
				semmir014Bean.setRenderedMsgFormTop(true);
				semmir014Bean.setRenderedMsgFormBottom(false);
				semmir014Bean.setRenderedMsgFormMiddle(false);
				return flag;
			}else{
				semmir014Bean.setRenderedMsgFormTop(false);			
				
				//Set Zone and Region
				semmir014Bean.getMir013SchSP().setZone((semmir014Bean.getPopupMultiZoneBean() != null)?SemUtils.mergSelectListByComma(semmir014Bean.getPopupMultiZoneBean().getSelectedList()):"");
				semmir014Bean.getMir013SchSP().setRegion(semmir014Bean.getPopupMultiZoneBean().getRegion());
				
				to = insuredService.querySPList(EQueryName.SP_MIR014_SCH.name, semmir014Bean.getMir013SchSP());
				
				if(to != null && !to.isEmpty()){
					semmir014Bean.setRenderedMsgDataNotFound(false);
					semmir014Bean.setMir013SchSPList(new ArrayList<WrapperBeanObject<Mir013Sch>>());
					for (int i=0; i<to.size(); i++) {
						Mir013Sch o = (Mir013Sch)to.get(i);
						WrapperBeanObject<Mir013Sch> tmpWrapperBean = new WrapperBeanObject<Mir013Sch>();
						
						//convert date to TH year for displaying.
						o.setUpdateDt(convertYearENtoTH(o.getUpdateDt()));
						
						tmpWrapperBean.setDataObj(o);
						tmpWrapperBean.setMessage("");
						tmpWrapperBean.setCheckBox(false);
						semmir014Bean.getMir013SchSPList().add(tmpWrapperBean);
					}
				}else{
					semmir014Bean.setRenderedMsgDataNotFound(true);
				}
				setSemmir014Bean(semmir014Bean);
				flag = true;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public boolean doClear(){
		semmir014Bean = getSemmir014Bean();
		semmir014Bean.setPopupMultiZoneBean(new PopupMultiZoneBean());
		semmir014Bean.setMir013SchSP(new Mir013Sch());
		semmir014Bean.setMir013SchSPList(new ArrayList<WrapperBeanObject<Mir013Sch>>());
		semmir014Bean.setRenderedMsgDataNotFound(false);
		setSemmir014Bean(semmir014Bean);
		return false;
	}
	
	@Override
	public void clearRenderedMsg(){
		semmir014Bean = getSemmir014Bean();
		semmir014Bean.setRenderedMsgFormSearch(false);
		semmir014Bean.setRenderedMsgFormBottom(false);
		semmir014Bean.setRenderedMsgFormMiddle(false);
	}
	
}
