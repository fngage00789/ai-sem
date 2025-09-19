package th.co.ais.web.common.action;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.rt.Mrt003PopPaySP;
import th.co.ais.service.rt.IRentalPaymentService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.common.CommonPopupCuttingBean;
import th.co.ais.web.util.LOVCacheUtil;
import th.co.ais.web.util.SelectItemLOVCacheUtil;

public class CommonPopupCuttingAction extends AbstractAction {

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;

		this.setForwardNavi();
		
		if(methodWithNavi.equalsIgnoreCase("initPopup")){
			flag = this.initPopup();
		} else if(methodWithNavi.equalsIgnoreCase("initPopupPayCut")){
			flag = this.initPopupPayCut();
		} else if(methodWithNavi.equalsIgnoreCase("doUpdStatusPayCut")){
				flag = this.doUpdateStatusPayCut();
		} else if(methodWithNavi.equalsIgnoreCase("initPopupNotDisbursed")){
			flag = this.initPopupNotDisbursed();
		} else if(methodWithNavi.equalsIgnoreCase("doUpdStatusNDisb")){
			flag = this.doUpdateStatusNotDisbursed();
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

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	private Logger log = Logger.getLogger(getClass());
	public CommonPopupCuttingBean popupCuttingBean;
	
	public CommonPopupCuttingBean getCommonPopupCuttingBean() {
		CommonPopupCuttingBean popupCuttingBean = (CommonPopupCuttingBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupCuttingBean");
		if(popupCuttingBean == null){
			popupCuttingBean = new CommonPopupCuttingBean();
		}
		
		return popupCuttingBean;
	}

	public void setCommonPopupCuttingBean(CommonPopupCuttingBean popupCuttingBean) {
		this.popupCuttingBean = popupCuttingBean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupCuttingBean", popupCuttingBean);
	}

	private boolean initPopup() {
		boolean flag = false;

		try {
			
			popupCuttingBean = getCommonPopupCuttingBean();

			String paramPaymentId = (String)getFacesUtils().getRequestParameter("paramPaymentId");
			String paramPaymentStatus = (String)getFacesUtils().getRequestParameter("paramPaymentStatus");
			String paramPaymentRemark = (String)getFacesUtils().getRequestParameter("paramPaymentRemark");
			paramPaymentRemark = paramPaymentRemark.trim(); //remove white space after String
			
			String paramRcptPayCutAmount = getFacesUtils().getRequestParameter("paramRcptPayCutAmount").toString().equals("") ? "" : (String)getFacesUtils().getRequestParameter("paramRcptPayCutAmount");
			Double rcptPayCutAmount = paramRcptPayCutAmount.equals("") ? null : Double.parseDouble(paramRcptPayCutAmount);
			
			System.out.println(">>> paramRentalPaymentId: " + paramPaymentId);
			System.out.println(">>> paramPaymentStatus: " + paramPaymentStatus);
			System.out.println(">>> paramPaymentRemark: " + paramPaymentRemark);

			// initiate some of dataList >>
			popupCuttingBean.setPaymentStatusList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_CT_PAYMENT_STATUS.name, EX_AND, null, null, "NOPAY"));
			popupCuttingBean.setPaymentTypeList(LOVCacheUtil.getInstance().getPaymentTypeSelList() == null ? new ArrayList() : LOVCacheUtil.getInstance().getPaymentTypeSelList());
			popupCuttingBean.setPaymentMethodList(LOVCacheUtil.getInstance().getPaymentMethodSelList() == null ? new ArrayList() : LOVCacheUtil.getInstance().getPaymentMethodSelList());
			// initiate some of dataList <<

			// assign data value >>
			Mrt003PopPaySP manualSettleSP = new Mrt003PopPaySP();
			List<Mrt003PopPaySP> manualSettleSPList = null; 
			
			manualSettleSP.setParamRentalPaymentId(paramPaymentId);
			
			IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
			manualSettleSPList = rentalPaymentService.querySPList(EQueryName.SP_MRT003_POP_PAY.name, manualSettleSP);
			
			if(manualSettleSPList.size()>0 && manualSettleSPList!=null){
				Mrt003PopPaySP sp = new Mrt003PopPaySP();
				sp = manualSettleSPList.get(0);
				
				sp = manualSettleSPList.get(0);
				sp.setChqDt(manualSettleSPList.get(0).getChqDt() == null ? null : SEMDataUtility.convertToEnYear(manualSettleSPList.get(0).getChqDt()));
				sp.setChqReceiveDt(manualSettleSPList.get(0).getChqReceiveDt() == null ? null : SEMDataUtility.convertToEnYear(manualSettleSPList.get(0).getChqReceiveDt()));
				sp.setUserId(getUserLogIn());
				sp.setVendorCode(manualSettleSPList.get(0).getVendorCode());
				sp.setVendorName(manualSettleSPList.get(0).getVendorName());
				sp.setPayeeName(manualSettleSPList.get(0).getPayeeName());
				sp.setBankAccNo(manualSettleSPList.get(0).getBankAccNo());
				sp.setInvoiceNo(manualSettleSPList.get(0).getDocNo());
				sp.setTotalAmt(manualSettleSPList.get(0).getTotalAmt());
				sp.setVatAmt(manualSettleSPList.get(0).getPayVatAmt());
				sp.setWhtAmt(manualSettleSPList.get(0).getPayWhtAmt());
				sp.setDutyAmt(manualSettleSPList.get(0).getPayDutyAmt());
				sp.setPayamount(manualSettleSPList.get(0).getPayAmt());
				sp.setDocCancel(manualSettleSPList.get(0).getDocCancel());
				sp.setDocCancelDt(manualSettleSPList.get(0).getDocCancelDt() == null ? null : SEMDataUtility.convertToEnYear(manualSettleSPList.get(0).getDocCancelDt()));
				sp.setPaymentStatus(paramPaymentStatus);
				sp.setRemarkPaymentStatus(paramPaymentRemark);
				sp.setRcptPayCutAmount(rcptPayCutAmount);
				
				popupCuttingBean.setPopupCuttingSP(sp);
			} else {
				popupCuttingBean.setPopupCuttingSP(new Mrt003PopPaySP());
				popupCuttingBean.getPopupCuttingSP().setPaymentStatus(paramPaymentStatus);
				popupCuttingBean.getPopupCuttingSP().setRemarkPaymentStatus(paramPaymentRemark);
				popupCuttingBean.getPopupCuttingSP().setRcptPayCutAmount(rcptPayCutAmount);
			}
			// assign data value <<
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			setCommonPopupCuttingBean(popupCuttingBean);
		}
		
		return flag;
	}
	
	private boolean initPopupPayCut() {
		boolean flag = false;

		try {
			popupCuttingBean = getCommonPopupCuttingBean();
			popupCuttingBean.setPaymentStatusList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_CT_PAYMENT_STATUS.name, EX_AND, null, null, "CANCEL"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			setCommonPopupCuttingBean(popupCuttingBean);
		}
		
		return flag;
	}
	
	private boolean doUpdateStatusPayCut(){
		boolean flag = false;
		boolean verifyFlag = true;

		popupCuttingBean = getCommonPopupCuttingBean();
		popupCuttingBean.setPopupClose(false);
		
		if(StringUtils.isEmpty(popupCuttingBean.getPopupCuttingSP().getPaymentStatus())){
			verifyFlag = false;
			addMessageError(("W0001"), msg("message.payCutStatus"));
		}
		if(StringUtils.isEmpty(popupCuttingBean.getPopupCuttingSP().getRemarkPaymentStatus())){
			verifyFlag = false;
			addMessageError(("W0001"), msg("message.remark"));
		}

		String payStatus = popupCuttingBean.getPopupCuttingSP().getPaymentStatus() == null ? "" : popupCuttingBean.getPopupCuttingSP().getPaymentStatus();
		String payCutCheck = popupCuttingBean.getPopupCuttingSP().getPayCutCheck() == null ? "" : popupCuttingBean.getPopupCuttingSP().getPayCutCheck();
		Double rcptPayCutAmount = popupCuttingBean.getPopupCuttingSP().getRcptPayCutAmount() == null ? new Double(0.00D) : popupCuttingBean.getPopupCuttingSP().getRcptPayCutAmount();
		
		if(payStatus.equalsIgnoreCase("13") && payCutCheck.equalsIgnoreCase("")){
			verifyFlag = false;
			addMessageError(("W0001"), msg("message.payCutStatus"));
		}else if(!payStatus.equalsIgnoreCase("13")){
			popupCuttingBean.getPopupCuttingSP().setRcptPayCutAmount(null);
		}
		
		if(payCutCheck.equalsIgnoreCase("2") && rcptPayCutAmount <= 0){
			System.out.println(">> payCutCheck = 2 && payCutAmount <= 0");
			verifyFlag = false;
			addMessageError(("W0001"), msg("message.payCutAmount"));
		} else if(payCutCheck.equalsIgnoreCase("1")){
			popupCuttingBean.getPopupCuttingSP().setRcptPayCutAmount(null);
		}
		
		// fixed.. 2014/10/07 >>
		Double payAmountTotal = popupCuttingBean.getPopupCuttingSP().getPayAmt() == null ? new Double(0.00D) : popupCuttingBean.getPopupCuttingSP().getPayAmt();
		int retVal = Double.compare(rcptPayCutAmount, payAmountTotal);
		
		if(retVal > 0) {
			verifyFlag = false;
			addMessageError(("W0001"), msg("message.payCutAmountOver"));
		} else if(retVal < 0) {
			// do nothing ..
		} else {
			verifyFlag = false;
			addMessageError(("W0001"), msg("message.payCutAmountEqual"));
		}
		// fixed.. 2014/10/07 <<
		
		try{
			if(verifyFlag){
				IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
				Mrt003PopPaySP mrt003PopPaySP = new Mrt003PopPaySP();
				
				mrt003PopPaySP.setParamRentalPaymentId(popupCuttingBean.getPopupCuttingSP().getParamRentalPaymentId());
				mrt003PopPaySP.setPaymentStatus(popupCuttingBean.getPopupCuttingSP().getPaymentStatus());
				mrt003PopPaySP.setRemarkPaymentStatus(popupCuttingBean.getPopupCuttingSP().getRemarkPaymentStatus());
				mrt003PopPaySP.setRcptPayCutAmount(popupCuttingBean.getPopupCuttingSP().getRcptPayCutAmount());
				mrt003PopPaySP.setUserId(getUserLogIn());
				
				List<Mrt003PopPaySP> to = null;
				
				to = rentalPaymentService.querySPList(EQueryName.SP_UPD_MRT003_POP_PAY.name, mrt003PopPaySP);
				
				if(StringUtils.equalsIgnoreCase(to.get(0).getpResult(), "Success")){
					flag = true;
					//doSearch();
				}
				popupCuttingBean.setPopupCloseSave(true);
			}else{
				popupCuttingBean.setRenderMessagePopup(true);
				popupCuttingBean.setPopupCloseSave(false);
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			setCommonPopupCuttingBean(popupCuttingBean);
		}
		
		return flag; 
	}
	
	private boolean initPopupNotDisbursed(){
		boolean flag = false;
		
		try{
			popupCuttingBean = getCommonPopupCuttingBean();
			
			String paramPaymentId = (String)getFacesUtils().getRequestParameter("paramPaymentId");
			String paramPaymentStatus = (String)getFacesUtils().getRequestParameter("paramPaymentStatus");
			String paramPaymentRemark = (String)getFacesUtils().getRequestParameter("paramPaymentRemark");
			
			System.out.println(">> paramPaymentId: " + paramPaymentId);
			System.out.println(">> paramPaymentStatus: " + paramPaymentStatus);
			System.out.println(">> paramPaymentRemark: " + paramPaymentRemark);

			popupCuttingBean.setPaymentStatusList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_CT_PAYMENT_STATUS.name, EX_AND, null, null, "NOPAY"));
			
			Mrt003PopPaySP sp = new Mrt003PopPaySP();
			sp.setParamRentalPaymentId(paramPaymentId);
			sp.setPaymentStatus(paramPaymentStatus);
			sp.setRemarkPaymentStatus(paramPaymentRemark);
			popupCuttingBean.setRenderMessagePopup(true);
			popupCuttingBean.setPopupCloseSave(false);
			popupCuttingBean.setPopupCuttingSP(sp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			setCommonPopupCuttingBean(popupCuttingBean);
		}
			
		return flag; 
	}
	
	private boolean doUpdateStatusNotDisbursed(){
		boolean flag = false;
		boolean verifyFlag = true;

		popupCuttingBean = getCommonPopupCuttingBean();
		popupCuttingBean.setPopupClose(false);
		
		if(StringUtils.isEmpty(popupCuttingBean.getPopupCuttingSP().getPaymentStatus())){
			verifyFlag = false;
			addMessageError(("W0001"), msg("message.paymentStatus"));
		}
		if(StringUtils.isEmpty(popupCuttingBean.getPopupCuttingSP().getRemarkPaymentStatus())){
			verifyFlag = false;
			addMessageError(("W0001"), msg("message.remark"));
		}
		
		try{
			if(verifyFlag){
				IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
				Mrt003PopPaySP mrt003PopPaySP = new Mrt003PopPaySP();
				
				mrt003PopPaySP.setParamRentalPaymentId(popupCuttingBean.getPopupCuttingSP().getParamRentalPaymentId());
				mrt003PopPaySP.setPaymentStatus(popupCuttingBean.getPopupCuttingSP().getPaymentStatus());
				mrt003PopPaySP.setRemarkPaymentStatus(popupCuttingBean.getPopupCuttingSP().getRemarkPaymentStatus());
				mrt003PopPaySP.setUserId(getUserLogIn());
				
				List<Mrt003PopPaySP> to = null;
				
				to = rentalPaymentService.querySPList(EQueryName.SP_MRT003_UPD_STATUS.name, mrt003PopPaySP);
				
				if(StringUtils.equalsIgnoreCase(to.get(0).getpResult(), "Success")){
					flag = true;
					//doSearch();
				}
				popupCuttingBean.setPopupCloseSave(true);
			}else{
				popupCuttingBean.setRenderMessagePopup(true);
				popupCuttingBean.setPopupCloseSave(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			setCommonPopupCuttingBean(popupCuttingBean);
		}
		
		return flag; 
	}
	
	private void setForwardNavi(){
		
		String paramNavModule = (String)getFacesUtils().getRequestParameter("navModule");
		String paramNavProgram = (String)getFacesUtils().getRequestParameter("navProgram");

		String paramFwdNavModule = (String)getFacesUtils().getRequestParameter("paramFwdNavModule");
		String paramFwdNavAction = (String)getFacesUtils().getRequestParameter("paramFwdNavAction");
		String paramFwdNavMethod = (String)getFacesUtils().getRequestParameter("paramFwdNavMethod");

		System.out.println(">> paramNavModule: " + paramNavModule);
		System.out.println(">> paramNavProgram: " + paramNavProgram);
		
		System.out.println(">> paramFwdNavModule: " + paramFwdNavModule);
		System.out.println(">> paramFwdNavAction: " + paramFwdNavAction);
		System.out.println(">> paramFwdNavMethod: " + paramFwdNavMethod);
		
		popupCuttingBean = getCommonPopupCuttingBean();
		
		popupCuttingBean.setParamNavModule(paramNavModule);
		popupCuttingBean.setParamNavProgram(paramNavProgram);
		
		popupCuttingBean.setParamFwdNavModule(paramFwdNavModule);
		popupCuttingBean.setParamFwdNavAction(paramFwdNavAction);
		popupCuttingBean.setParamFwdNavMethod(paramFwdNavMethod);
		
		setCommonPopupCuttingBean(popupCuttingBean);
	}
	
}
