package th.co.ais.web.bean.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import th.co.ais.domain.gm.VendorMaster;
import th.co.ais.web.bean.AbstractBean;

/**
 * @author Warawit
 * 
 */
public class PopupMultiVendorBean extends AbstractBean{
	


	/**
	 * 
	 */
	private static final long serialVersionUID = -1065971568529462698L;

	private final static Logger log = Logger.getLogger(PopupMultiVendorBean.class);

	private boolean disableBtnGetVendor;
	private boolean disabledBtnSelectedAll = true;
	private boolean disabledDeleteVendorMulti = true;
	private List<VendorMaster> vendorList = new ArrayList<VendorMaster>();
	private List<SelectItem> selectedList = new ArrayList<SelectItem>();
	private Map<String, String> selectedValList = new HashMap<String, String>();
	private List<String> delList = new ArrayList<String>();
	private String vendorCatSelect;
	private String vendorKeyWord;
	private boolean selectedAll = false;
	
	private int rowPerPage = 10;
	
	public PopupMultiVendorBean() {
		
	}
	
	public boolean isDisableBtnGetVendor() {
		return disableBtnGetVendor;
	}

	public void setDisableBtnGetVendor(boolean disableBtnGetVendor) {
		this.disableBtnGetVendor = disableBtnGetVendor;
	}

	public boolean isDisabledBtnSelectedAll() {
		return disabledBtnSelectedAll;
	}

	public void setDisabledBtnSelectedAll(boolean disabledBtnSelectedAll) {
		this.disabledBtnSelectedAll = disabledBtnSelectedAll;
	}

	public boolean isDisabledDeleteVendorMulti() {
		return disabledDeleteVendorMulti;
	}

	public void setDisabledDeleteVendorMulti(boolean disabledDeleteVendorMulti) {
		this.disabledDeleteVendorMulti = disabledDeleteVendorMulti;
	}

	public List<VendorMaster> getVendorList() {
		return vendorList;
	}

	public void setVendorList(List<VendorMaster> vendorList) {
		this.vendorList = vendorList;
	}

	public List<SelectItem> getSelectedList() {
		return selectedList;
	}

	public void setSelectedList(List<SelectItem> selectedList) {
		this.selectedList = selectedList;
	}

	public Map<String, String> getSelectedValList() {
		return selectedValList;
	}

	public void setSelectedValList(Map<String, String> selectedValList) {
		this.selectedValList = selectedValList;
	}

	public List<String> getDelList() {
		return delList;
	}

	public void setDelList(List<String> delList) {
		this.delList = delList;
	}

	public String getVendorCatSelect() {
		return vendorCatSelect;
	}

	public void setVendorCatSelect(String vendorCatSelect) {
		this.vendorCatSelect = vendorCatSelect;
	}

	public String getVendorKeyWord() {
		return vendorKeyWord;
	}

	public void setVendorKeyWord(String vendorKeyWord) {
		this.vendorKeyWord = vendorKeyWord;
	}

	public boolean isSelectedAll() {
		return selectedAll;
	}

	public void setSelectedAll(boolean selectedAll) {
		this.selectedAll = selectedAll;
	}

	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	
}
