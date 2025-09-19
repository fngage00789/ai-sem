package th.co.ais.web.bean.common;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.rt.Mrt003PopPaySP;
import th.co.ais.web.bean.AbstractBean;

public class CommonPopupCuttingBean extends AbstractBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8392733795046946625L;
	
	private boolean popupCloseSave = false;
	
	private Mrt003PopPaySP popupCuttingSP;
	private List<Mrt003PopPaySP> popupCuttingSPList;
	
	private List<SelectItem> paymentTypeList;
	private List<SelectItem> paymentMethodList;
	
	private List<SelectItem> paymentStatusList;
	
	//Render Calender chqDt or TransferDT
	private boolean renderedChqDt;
	private boolean renderedTransferDt;
	private boolean renderedPaymentMethod;
	
	private boolean renderMessagePopup = false;
	
	private String paramNavModule;
	private String paramNavProgram;

	private String paramFwdNavModule;
	private String paramFwdNavAction;
	private String paramFwdNavMethod;
	
	@Override
	public int getRowPerPage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		// TODO Auto-generated method stub

	}

	public boolean isPopupCloseSave() {
		return popupCloseSave;
	}

	public void setPopupCloseSave(boolean popupCloseSave) {
		this.popupCloseSave = popupCloseSave;
	}

	public Mrt003PopPaySP getPopupCuttingSP() {
		return popupCuttingSP;
	}

	public void setPopupCuttingSP(Mrt003PopPaySP sp) {
		this.popupCuttingSP = sp;
	}

	public List<Mrt003PopPaySP> getPopupCuttingSPList() {
		if(popupCuttingSPList == null) {
			popupCuttingSPList = new ArrayList<Mrt003PopPaySP>();
		}
		return popupCuttingSPList;
	}

	public void setPopupCuttingSPList(List<Mrt003PopPaySP> popupCuttingSPList) {
		this.popupCuttingSPList = popupCuttingSPList;
	}

	public List<SelectItem> getPaymentTypeList() {
		if(paymentTypeList == null) {
			paymentTypeList = new ArrayList<SelectItem>();
		}
		return paymentTypeList;
	}

	public void setPaymentTypeList(List<SelectItem> paymentTypeList) {
		this.paymentTypeList = paymentTypeList;
	}

	public List<SelectItem> getPaymentMethodList() {
		if(paymentMethodList == null) {
			paymentMethodList = new ArrayList<SelectItem>();
		}
		return paymentMethodList;
	}

	public void setPaymentMethodList(List<SelectItem> paymentMethodList) {
		this.paymentMethodList = paymentMethodList;
	}

	public List<SelectItem> getPaymentStatusList() {
		if(paymentStatusList == null) {
			paymentStatusList = new ArrayList<SelectItem>();
		}
		return paymentStatusList;
	}

	public void setPaymentStatusList(List<SelectItem> paymentStatusList) {
		this.paymentStatusList = paymentStatusList;
	}

	public boolean isRenderedChqDt() {
		return renderedChqDt;
	}

	public void setRenderedChqDt(boolean renderedChqDt) {
		this.renderedChqDt = renderedChqDt;
	}

	public boolean isRenderedTransferDt() {
		return renderedTransferDt;
	}

	public void setRenderedTransferDt(boolean renderedTransferDt) {
		this.renderedTransferDt = renderedTransferDt;
	}

	public boolean isRenderedPaymentMethod() {
		return renderedPaymentMethod;
	}

	public void setRenderedPaymentMethod(boolean renderedPaymentMethod) {
		this.renderedPaymentMethod = renderedPaymentMethod;
	}

	public boolean isRenderMessagePopup() {
		return renderMessagePopup;
	}

	public void setRenderMessagePopup(boolean renderMessagePopup) {
		this.renderMessagePopup = renderMessagePopup;
	}

	public String getParamNavModule() {
		return paramNavModule;
	}

	public void setParamNavModule(String paramNavModule) {
		this.paramNavModule = paramNavModule;
	}

	public String getParamNavProgram() {
		return paramNavProgram;
	}

	public void setParamNavProgram(String paramNavProgram) {
		this.paramNavProgram = paramNavProgram;
	}

	public String getParamFwdNavModule() {
		return paramFwdNavModule;
	}

	public void setParamFwdNavModule(String paramFwdNavModule) {
		this.paramFwdNavModule = paramFwdNavModule;
	}

	public String getParamFwdNavAction() {
		return paramFwdNavAction;
	}

	public void setParamFwdNavAction(String paramFwdNavAction) {
		this.paramFwdNavAction = paramFwdNavAction;
	}

	public String getParamFwdNavMethod() {
		return paramFwdNavMethod;
	}

	public void setParamFwdNavMethod(String paramFwdNavMethod) {
		this.paramFwdNavMethod = paramFwdNavMethod;
	}

}
