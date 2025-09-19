package th.co.ais.web.bean.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import th.co.ais.domain.gm.Region;
import th.co.ais.web.bean.AbstractBean;

/**
 * @author Warawit
 * 
 */
public class PopupSiteMultiRegionBean extends AbstractBean{
	


	/**
	 * 
	 */
	private static final long serialVersionUID = -1065971568529462698L;

	private final static Logger log = Logger.getLogger(PopupSiteMultiRegionBean.class);

	private boolean disableBtnGetSiteRegion;
	private boolean disabledBtnSelectedAll = true;
	private boolean disabledDeleteSiteRegionMulti = true;
	private List<Region> regionList = new ArrayList<Region>();
	private List<SelectItem> selectedList = new ArrayList<SelectItem>();
	private Map<String, String> selectedValList = new HashMap<String, String>();
	private List<String> delList = new ArrayList<String>();
	private String siteRegionCatSelect;
	private String siteRegionKeyWord;
	private boolean selectedAll = false;
	
	private int rowPerPage = 10;
	
	public PopupSiteMultiRegionBean() {
		
	}

	public List<Region> getRegionList() {
		return regionList;
	}

	public void setRegionList(List<Region> regionList) {
		this.regionList = regionList;
	}

	public List<String> getDelList() {
		return delList;
	}

	public void setDelList(List<String> delList) {
		this.delList = delList;
	}

	public boolean isDisableBtnGetSiteRegion() {
		return disableBtnGetSiteRegion;
	}

	public void setDisableBtnGetSiteRegion(boolean disableBtnGetSiteRegion) {
		this.disableBtnGetSiteRegion = disableBtnGetSiteRegion;
	}

	public boolean isDisabledDeleteSiteRegionMulti() {
		boolean flg = true;
		if (this.selectedList != null && this.selectedList.size() > 0) {
			flg = false;
		}
		return flg;
	}

	public int getDelListSize() {
		return delList.size();
	}
	
	public void setDisabledDeleteSiteRegionMulti(boolean disabledDeleteSiteRegionMulti) {
		this.disabledDeleteSiteRegionMulti = disabledDeleteSiteRegionMulti;
	}

	public String getSiteRegionCatSelect() {
		return siteRegionCatSelect;
	}

	public void setSiteRegionCatSelect(String siteRegionCatSelect) {
		this.siteRegionCatSelect = siteRegionCatSelect;
	}

	public String getSiteRegionKeyWord() {
		return siteRegionKeyWord;
	}

	public void setSiteRegionKeyWord(String siteRegionKeyWord) {
		this.siteRegionKeyWord = siteRegionKeyWord;
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
		if (this.regionList != null && this.regionList.size() > 0) {
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
