package th.co.ais.web.bean.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;

import th.co.ais.domain.gm.Region;

public class PopupRegionBean implements Serializable{

	private static final long serialVersionUID = -2206709706456699629L;
	
	private List<Region> regions;
	private Region region;
	private boolean renderBtnAdd = true;
	private Map<String, String> selectedValList = new HashMap<String, String>();
	private List<SelectItem> regionsAdded;
	private List<String> selDels;
	
	
	public List<Region> getRegions() {
		if(regions == null)
			regions = new ArrayList<Region>();
		return regions;
	}
	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}
	public Region getRegion() {
		if(region == null)
			region = new Region();
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public boolean isRenderBtnAdd() {
		return renderBtnAdd;
	}
	public void setRenderBtnAdd(boolean renderBtnAdd) {
		this.renderBtnAdd = renderBtnAdd;
	}
	
	public void setRegionsAdded(List<SelectItem> regionsAdded) {
		this.regionsAdded = regionsAdded;
	}
	public List<SelectItem> getRegionsAdded() {
		if(regionsAdded == null)
		   regionsAdded = new ArrayList<SelectItem>();
		return regionsAdded;
	}
	public List<String> getSelDels() {
		return selDels;
	}
	public void setSelDels(List<String> selDels) {
		this.selDels = selDels;
	}
	public Map<String, String> getSelectedValList() {
		return selectedValList;
	}
	public void setSelectedValList(Map<String, String> selectedValList) {
		this.selectedValList = selectedValList;
	}
	
	

}
