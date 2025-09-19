package th.co.ais.web.bean.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import th.co.ais.domain.si.SiteLocationSP;
import th.co.ais.web.bean.AbstractBean;

/**
 * @author Warawit
 * 
 */
public class PopupSiteMultiLocationBean extends AbstractBean{
	


	/**
	 * 
	 */
	private static final long serialVersionUID = -1065971568529462698L;

	private final static Logger log = Logger.getLogger(PopupSiteMultiLocationBean.class);

	private boolean disableBtnGetSiteLocation;
	private boolean disabledBtnSelectedAll = true;
	private boolean disabledDeleteSiteLocationMulti = true;
	private List<SiteLocationSP> locationList = new ArrayList<SiteLocationSP>();
	private List<SelectItem> selectedList = new ArrayList<SelectItem>();
	private Map<String, String> selectedValList = new HashMap<String, String>();
	private List<String> delList = new ArrayList<String>();
	private String siteLocationCatSelect;
	private String siteLocationKeyWord;
	private boolean selectedAll = false;
	private int rowPerPage = 10;
	
	public PopupSiteMultiLocationBean() {
		
	}
	
	public List<SiteLocationSP> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<SiteLocationSP> locationList) {
		this.locationList = locationList;
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

	public boolean isDisableBtnGetSiteLocation() {
		return disableBtnGetSiteLocation;
	}

	public void setDisableBtnGetSiteLocation(boolean disableBtnGetSiteLocation) {
		this.disableBtnGetSiteLocation = disableBtnGetSiteLocation;
	}

	public boolean isDisabledDeleteSiteLocationMulti() {
		boolean flg = true;
		if (this.selectedList != null && this.selectedList.size() > 0) {
			flg = false;
		}
		return flg;
	}

	public void setDisabledDeleteSiteLocationMulti(boolean disabledDeleteSiteLocationMulti) {
		this.disabledDeleteSiteLocationMulti = disabledDeleteSiteLocationMulti;
	}

	public String getSiteLocationCatSelect() {
		return siteLocationCatSelect;
	}

	public void setSiteLocationCatSelect(String siteLocationCatSelect) {
		this.siteLocationCatSelect = siteLocationCatSelect;
	}

	public String getSiteLocationKeyWord() {
		return siteLocationKeyWord;
	}

	public void setSiteLocationKeyWord(String siteLocationKeyWord) {
		this.siteLocationKeyWord = siteLocationKeyWord;
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
		if (this.locationList != null && this.locationList.size() > 0) {
			flg = false;
		}
		return flg;
	}

	public void setDisabledBtnSelectedAll(boolean disabledBtnSelectedAll) {
		this.disabledBtnSelectedAll = disabledBtnSelectedAll;
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
