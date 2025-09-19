package th.co.ais.web.bean.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;

import th.co.ais.domain.gm.Province;

public class PopupProvinceBean implements Serializable{

	private static final long serialVersionUID = -2206709706456699629L;
	
	private List<Province> tmpProvinces;
	private List<Province> provinces;
	private Province province;
	private boolean renderBtnProvinceAdd = true;
	private Map<String, String> selectedValList = new HashMap<String, String>();
	private List<SelectItem> provinceAdded = new ArrayList<SelectItem>();
	private List<String> selProvinceDels;
	
	
	public List<Province> getTmpProvinces() {
		if(tmpProvinces == null)
			tmpProvinces = new ArrayList<Province>();
		return tmpProvinces;
	}
	public void setTmpProvinces(List<Province> tmpProvinces) {
		this.tmpProvinces = tmpProvinces;
	}
	public Map<String, String> getSelectedValList() {
		return selectedValList;
	}
	public List<Province> getProvinces() {
		if(provinces == null)
			provinces = new ArrayList<Province>();
		return provinces;
	}
	public void setProvinces(List<Province> provinces) {
		this.provinces = provinces;
	}
	public Province getProvince() {
		if(province == null)
			province = new Province();
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}
	public boolean isRenderBtnProvinceAdd() {
		return renderBtnProvinceAdd;
	}
	public void setRenderBtnProvinceAdd(boolean renderBtnProvinceAdd) {
		this.renderBtnProvinceAdd = renderBtnProvinceAdd;
	}
	public List<SelectItem> getProvinceAdded() {
		if (this.provinceAdded == null)
			this.provinceAdded = new ArrayList<SelectItem>();
		return provinceAdded;
	}
	public void setProvinceAdded(List<SelectItem> provinceAdded) {
		this.provinceAdded = provinceAdded;
	}
	public List<String> getSelProvinceDels() {
		return selProvinceDels;
	}
	public void setSelProvinceDels(List<String> selProvinceDels) {
		this.selProvinceDels = selProvinceDels;
	}
	public void setSelectedValList(Map<String, String> selectedValList) {
		this.selectedValList = selectedValList;
	}

}
