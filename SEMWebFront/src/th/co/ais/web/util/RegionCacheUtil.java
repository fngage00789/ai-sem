package th.co.ais.web.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.model.SelectItem;
import org.apache.log4j.Logger;

import th.co.ais.service.gm.IProvinceService;
import th.co.ais.util.EComponentCode;
import th.co.ais.web.action.AbstractBaseAction;

public class RegionCacheUtil extends AbstractBaseAction {

	private static final long serialVersionUID = 6593520206100518300L;

	private Logger log = Logger.getLogger(getClass());
	private static RegionCacheUtil instance = null;
	private static List<String> region;
	private HashMap componentMap = null;
	
	public static void initRegion() {
		if (region == null) {
			try {
				
				IProvinceService provinceService = (IProvinceService)FacesUtils.getInstance().getBean("provinceService");
				region = provinceService.getSamRegionAll();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static synchronized RegionCacheUtil getInstance() {
		if (instance == null) {
			instance = new RegionCacheUtil();
		}
		return instance;
	}
	
	public void loadComponent() {
		initRegion();
		componentMap = new HashMap();
		setRegionSelList(componentMap);
	}
	
	private void setRegionSelList(HashMap rawData) {
		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if (rawData.containsKey(EComponentCode.M_CODE_REGION.name) && rawData.get(EComponentCode.M_CODE_REGION.name) != null) {
				if (((List)rawData.get(EComponentCode.M_CODE_REGION.name)).size() > 0) {
					for (String temp : ((List<String>)rawData.get(EComponentCode.M_CODE_REGION.name))) {
						selItem = new SelectItem();
						selItem.setLabel(temp);
						selItem.setValue(temp);
						selList.add(selItem);
					}
					componentMap.put(EComponentCode.M_CODE_REGION.name, selList);
				}
			} else {
				if (region != null && !region.isEmpty()) {
					selItem = new SelectItem("" , msg("value.selectItem"));
					selList.add(selItem);
					for (String temp : region) {
						selItem = new SelectItem();
						selItem.setLabel(temp);
						selItem.setValue(temp);
						selList.add(selItem);
					}
				}
				componentMap.put(EComponentCode.M_CODE_REGION.name, selList);
			}
		} catch (Exception e) {
			log.error("error in RegionCacheUtil.setRegionSelList : " + e);
		}
	}
	
	public List<SelectItem> getRegionSelList() {
		List<SelectItem> returnList = new ArrayList<SelectItem>();
		if(componentMap == null){
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>)componentMap.get(EComponentCode.M_CODE_REGION.name);
		} catch (Exception e) {
			log.error("error in RegionCacheUtil.getRegionSelList : " + e);
		}
		return returnList;
	}

	public static List<String> getRegion() {
		return region;
	}

	public static void setRegion(List<String> region) {
		RegionCacheUtil.region = region;
	}

	public HashMap getComponentMap() {
		return componentMap;
	}

	public void setComponentMap(HashMap componentMap) {
		this.componentMap = componentMap;
	}	
	
}
