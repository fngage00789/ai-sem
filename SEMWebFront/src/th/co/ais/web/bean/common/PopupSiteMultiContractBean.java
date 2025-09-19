package th.co.ais.web.bean.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import th.co.ais.domain.si.PopupContractSearchSP;
import th.co.ais.web.bean.AbstractBean;

/**
 * @author Warawit
 * 
 */
public class PopupSiteMultiContractBean extends AbstractBean{
	
	private static final long serialVersionUID = -1065971568529462698L;

	private final static Logger log = Logger.getLogger(PopupSiteMultiContractBean.class);

	private boolean disableBtnGetSiteContract;
	private boolean disabledBtnSelectedAll = true;
	private boolean disabledDeleteSiteContractMulti = true;
	private PopupContractSearchSP popupContractSearch;
	private List<PopupContractSearchSP> contractList = new ArrayList<PopupContractSearchSP>();
	private List<SelectItem> selectedList = new ArrayList<SelectItem>();
	private Map<String, String> selectedValList = new HashMap<String, String>();
	private List<String> delList = new ArrayList<String>();
	private String siteContractCatSelect;
	private String siteContractKeyWord;
	private boolean selectedAll = false;

	private int rowPerPage = 10;
	
	public PopupSiteMultiContractBean() {
		
	}

	public List<PopupContractSearchSP> getContractList() {
		return contractList;
	}

	public void setContractList(List<PopupContractSearchSP> contractList) {
		this.contractList = contractList;
	}

	public List<String> getDelList() {
		return delList;
	}

	public int getDelListSize() {
		return delList.size();
	}
	
	public void setDelList(List<String> delList) {
		this.delList = delList;
	}

	public boolean isDisableBtnGetSiteContract() {
		return disableBtnGetSiteContract;
	}

	public void setDisableBtnGetSiteContract(boolean disableBtnGetSiteContract) {
		this.disableBtnGetSiteContract = disableBtnGetSiteContract;
	}

	public boolean isDisabledDeleteSiteContractMulti() {
		boolean flg = true;
		if (this.selectedList != null && this.selectedList.size() > 0) {
			flg = false;
		}
		return flg;
	}

	public void setDisabledDeleteSiteContractMulti(boolean disabledDeleteSiteContractMulti) {
		this.disabledDeleteSiteContractMulti = disabledDeleteSiteContractMulti;
	}

	public String getSiteContractCatSelect() {
		return siteContractCatSelect;
	}

	public void setSiteContractCatSelect(String siteContractCatSelect) {
		this.siteContractCatSelect = siteContractCatSelect;
	}

	public String getSiteContractKeyWord() {
		return siteContractKeyWord;
	}

	public void setSiteContractKeyWord(String siteContractKeyWord) {
		this.siteContractKeyWord = siteContractKeyWord;
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

	public boolean isSelectedAll() {
		return selectedAll;
	}

	public void setSelectedAll(boolean selectedAll) {
		this.selectedAll = selectedAll;
	}

	public boolean isDisabledBtnSelectedAll() {
		boolean flg = true;
		if (this.contractList != null && this.contractList.size() > 0) {
			flg = false;
		}
		return flg;
	}

	public void setDisabledBtnSelectedAll(boolean disabledBtnSelectedAll) {
		this.disabledBtnSelectedAll = disabledBtnSelectedAll;
	}

	public PopupContractSearchSP getPopupContractSearch() {
		return popupContractSearch;
	}

	public void setPopupContractSearch(PopupContractSearchSP popupContractSearch) {
		this.popupContractSearch = popupContractSearch;
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
