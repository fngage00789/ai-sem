package th.co.ais.web.bean.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import th.co.ais.domain.gm.Zone;
import th.co.ais.web.bean.AbstractBean;

public class PopupMultiZoneBean extends AbstractBean {
	
	
	private final static Logger log = Logger.getLogger(PopupMultiZoneBean.class);

	private boolean disableBtnGetZone;
	private boolean disabledBtnSelectedAll = true;
	private boolean disabledDeleteZoneMulti = true;
	private List<Zone> zoneList = new ArrayList<Zone>();
	private List<SelectItem> selectedList = new ArrayList<SelectItem>();
	private Map<String, String> selectedValList = new HashMap<String, String>();
	private List<String> delList = new ArrayList<String>();
	private String zoneCatSelect;
	private String region;
	private boolean selectedAll = false;
	private int rowPerPage = 10;
	private boolean defaultRegion = false;
	
	@Override
	public int getRowPerPage() {
		return rowPerPage;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}

	public boolean isDisableBtnGetZone() {
		return disableBtnGetZone;
	}

	public void setDisableBtnGetZone(boolean disableBtnGetZone) {
		this.disableBtnGetZone = disableBtnGetZone;
	}

	public boolean isDisabledBtnSelectedAll() {
		return disabledBtnSelectedAll;
	}

	public void setDisabledBtnSelectedAll(boolean disabledBtnSelectedAll) {
		this.disabledBtnSelectedAll = disabledBtnSelectedAll;
	}

	public boolean isDisabledDeleteZoneMulti() {
		return disabledDeleteZoneMulti;
	}

	public void setDisabledDeleteZoneMulti(boolean disabledDeleteZoneMulti) {
		this.disabledDeleteZoneMulti = disabledDeleteZoneMulti;
	}

	public List<Zone> getZoneList() {
		return zoneList;
	}

	public void setZoneList(List<Zone> zoneList) {
		this.zoneList = zoneList;
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
	
	public int getDelListSize() {
		return delList.size();
	}

	public void setDelList(List<String> delList) {
		this.delList = delList;
	}

	public String getZoneCatSelect() {
		return zoneCatSelect;
	}

	public void setZoneCatSelect(String zoneCatSelect) {
		zoneCatSelect = zoneCatSelect;
	}

	
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public boolean isSelectedAll() {
		return selectedAll;
	}

	public void setSelectedAll(boolean selectedAll) {
		this.selectedAll = selectedAll;
	}

	public boolean isDefaultRegion() {
		return defaultRegion;
	}

	public void setDefaultRegion(boolean defaultRegion) {
		this.defaultRegion = defaultRegion;
	}
	

}
