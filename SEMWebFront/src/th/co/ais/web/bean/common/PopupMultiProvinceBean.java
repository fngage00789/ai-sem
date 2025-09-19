package th.co.ais.web.bean.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import th.co.ais.domain.gm.Province;
import th.co.ais.domain.gm.Zone;
import th.co.ais.web.bean.AbstractBean;

public class PopupMultiProvinceBean extends AbstractBean {
	
	
	private final static Logger log = Logger.getLogger(PopupMultiProvinceBean.class);

	private boolean disableBtnGetProvice;
	private boolean disabledBtnSelectedAll = true;
	private boolean disabledDeleteProvinceMulti = true;
	private List<Province> provinceList = new ArrayList<Province>();
	private List<SelectItem> selectedList = new ArrayList<SelectItem>();
	private Map<String, String> selectedValList = new HashMap<String, String>();
	private List<String> delList = new ArrayList<String>();
	private String provinceCatSelect;
	private String region;
	private String provinceName;
	private boolean selectedAll = false;
	private int rowPerPage = 10;
	private boolean defaultRegion = false;
	
	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}

	public boolean isDisableBtnGetProvice() {
		return disableBtnGetProvice;
	}

	public void setDisableBtnGetProvice(boolean disableBtnGetProvice) {
		this.disableBtnGetProvice = disableBtnGetProvice;
	}

	public boolean isDisabledBtnSelectedAll() {
		return disabledBtnSelectedAll;
	}

	public void setDisabledBtnSelectedAll(boolean disabledBtnSelectedAll) {
		this.disabledBtnSelectedAll = disabledBtnSelectedAll;
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

	public boolean isDisabledDeleteProvinceMulti() {
		return disabledDeleteProvinceMulti;
	}

	public void setDisabledDeleteProvinceMulti(boolean disabledDeleteProvinceMulti) {
		this.disabledDeleteProvinceMulti = disabledDeleteProvinceMulti;
	}

	public List<Province> getProvinceList() {
		return provinceList;
	}

	public void setProvinceList(List<Province> provinceList) {
		this.provinceList = provinceList;
	}

	public String getProvinceCatSelect() {
		return provinceCatSelect;
	}

	public void setProvinceCatSelect(String provinceCatSelect) {
		this.provinceCatSelect = provinceCatSelect;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public boolean isDefaultRegion() {
		return defaultRegion;
	}

	public void setDefaultRegion(boolean defaultRegion) {
		this.defaultRegion = defaultRegion;
	}

}
