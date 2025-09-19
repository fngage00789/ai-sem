package th.co.ais.web.ir.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import th.co.ais.domain.ir.Mir011Srch;
import th.co.ais.service.ir.IInsuredService;
import th.co.ais.util.ELovType;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.ir.bean.SEMMIR011Bean;

public class SEMMIR011Action extends AbstractAction {
	
	private Logger log = Logger.getLogger(getClass());
	
	private SEMMIR011Bean semmir011Bean;
	
	public SEMMIR011Bean getSemmir011Bean(){
		SEMMIR011Bean semmir011Bean = (SEMMIR011Bean)getFacesUtils().getSessionMapValue("semmir011Bean");
		if(semmir011Bean == null)
				semmir011Bean = new SEMMIR011Bean();
		return semmir011Bean;
	}
	public void setSemmir011Bean(SEMMIR011Bean semmir011Bean){
		this.semmir011Bean = semmir011Bean;
		getFacesUtils().setSessionMapValue("semmir011Bean", semmir011Bean);
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
		}
		
		
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		semmir011Bean = getSemmir011Bean();
		semmir011Bean.setInsurancePaySP(new Mir011Srch());
		semmir011Bean.setInsurancePaySPList(new ArrayList<WrapperBeanObject<Mir011Srch>>());
		semmir011Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmir011Bean.setNetworkTypeList(getLovItemsByType(ELovType.T_IR_NETWORK_TYPES.name));
		semmir011Bean.setTransferTypeList(getLovItemsByType(ELovType.T_IR_TRANSFER_TYPES.name));
		semmir011Bean.setPolicyTypeList(getLovItemsByType(ELovType.T_IR_POLICY_TYPE.name));
		semmir011Bean.setPaymentStatusList(getLovItemsByType(ELovType.T_CT_PAYMENT_STATUS.name));
		semmir011Bean.setDateTypeList(getLovItemsByType(ELovType.T_IR_DATE_TYPE.name));
		setSemmir011Bean(semmir011Bean);
	}

	@Override
	public boolean validate() {
		boolean flag = false;
		return flag;
	}
	
	public boolean doClear(){
		semmir011Bean = getSemmir011Bean();
		semmir011Bean.setInsurancePaySP(new Mir011Srch());
		semmir011Bean.setInsurancePaySPList(new ArrayList<WrapperBeanObject<Mir011Srch>>());
		semmir011Bean.setRenderedMsgDataNotFound(false);
		setSemmir011Bean(semmir011Bean);
		return false;
	}
	
	public boolean doSearch(){
		boolean flag = false;
		semmir011Bean = getSemmir011Bean();
		IInsuredService insuredService = (IInsuredService)getBean("insuredService");
		
		List<Mir011Srch> to = null;
		try{
			if(validate()){
				semmir011Bean.setRenderedMsgFormTop(true);
				
				return flag;
			}else{
				semmir011Bean.setRenderedMsgFormTop(false);			
				to = insuredService.querySPList("mir011Sch", semmir011Bean.getInsurancePaySP());
				
				if(to != null && !to.isEmpty()){
					semmir011Bean.setRenderedMsgDataNotFound(false);
					semmir011Bean.setInsurancePaySPList(new ArrayList<WrapperBeanObject<Mir011Srch>>());
					for (int i=0; i<to.size(); i++) {
						Mir011Srch o = (Mir011Srch)to.get(i);
						WrapperBeanObject<Mir011Srch> tmpWrapperBean = new WrapperBeanObject<Mir011Srch>();
						
						//convert date to TH year for displaying.
						o.setUpdateDt(convertYearENtoTH(o.getUpdateDt()));
						o.setPaymentDt(convertYearENtoTH(o.getPaymentDt()));
						o.setChqDt(convertYearENtoTH(o.getChqDt()));
						o.setChqReceiveDt(convertYearENtoTH(o.getChqReceiveDt()));
						o.setTransferDt(convertYearENtoTH(o.getTransferDt()));
						tmpWrapperBean.setDataObj(o);
						tmpWrapperBean.setMessage("");
						tmpWrapperBean.setCheckBox(false);
		//				semmir011Bean.getInsurancePaymentSPList().add(tmpWrapperBean);
						semmir011Bean.getInsurancePaySPList().add(tmpWrapperBean);
					}
				}else{
					semmir011Bean.setRenderedMsgDataNotFound(true);
				}
				setSemmir011Bean(semmir011Bean);
				flag = true;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return flag;
	}	
	
}
