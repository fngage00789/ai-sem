package th.co.ais.web.rt.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
//import org.jboss.util.Log4jLoggerFactory;

import th.co.ais.domain.rt.PettyCashSP;
import th.co.ais.domain.rt.PettyCash;
import th.co.ais.service.util.ServiceConstants;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMMRT008Bean extends AbstractBean {

	private static final long serialVersionUID = -257004826763506625L;
	
	//for search criteria
	private PettyCashSP tmpPettyCash;
	//for edit data
	private PettyCash pettyCash;
	//select Item
	private List<SelectItem> companyList;
	
	//data table
	public List<WrapperBeanObject<PettyCashSP>> pettyCashList;
	
	private String mode = ServiceConstants.MODULE_ACTION_INSERT;
	
	private String popupFormName = "popupFrmRT008Save";
	
	private boolean disabledBtnSaveClear = false;
	
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	public List<SelectItem> getCompanyList() {
		if(companyList == null)
			companyList = new ArrayList<SelectItem>();
		return companyList;
	}
	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}
	public PettyCash getPettyCash() {
		if(pettyCash == null)
			pettyCash = new PettyCash();
		return pettyCash;
	}
	public void setPettyCash(PettyCash pettyCash) {
		this.pettyCash = pettyCash;
	}
	public List<WrapperBeanObject<PettyCashSP>> getPettyCashList() {
		if(pettyCashList == null)
			pettyCashList = new ArrayList<WrapperBeanObject<PettyCashSP>>();
		return pettyCashList;
	}
	public void setPettyCashList(
			List<WrapperBeanObject<PettyCashSP>> pettyCashList) {
		this.pettyCashList = pettyCashList;
	}
	public PettyCashSP getTmpPettyCash() {
		if(tmpPettyCash == null)
			tmpPettyCash = new PettyCashSP();
		return tmpPettyCash;
	}
	public void setTmpPettyCash(PettyCashSP tmpPettyCash) {
		this.tmpPettyCash = tmpPettyCash;
	}
	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	public String getPopupFormName() {
		return popupFormName;
	}
	public void setPopupFormName(String popupFormName) {
		this.popupFormName = popupFormName;
	}
	public boolean isDisabledBtnSaveClear() {
		return disabledBtnSaveClear;
	}
	public void setDisabledBtnSaveClear(boolean disabledBtnSaveClear) {
		this.disabledBtnSaveClear = disabledBtnSaveClear;
	}
	
	
	
	
	
}
