package th.co.ais.web.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import th.co.ais.domain.gm.Zone;
import th.co.ais.service.gm.IZoneService;
import th.co.ais.util.EComponentCode;
import th.co.ais.web.action.AbstractBaseAction;

public class ZoneCasheUtil extends AbstractBaseAction{

	private Logger log = Logger.getLogger(getClass());
	private static ZoneCasheUtil instance = null;
	private static List<Zone> zone;
	private HashMap componentMap = null;
	
	public static void initZone(){
		if(zone == null){
			try{
				IZoneService zoneService = (IZoneService)FacesUtils.getInstance().getBean("zoneService"); 
				zone = zoneService.searchZoneAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static synchronized ZoneCasheUtil getInstance(){
		if(instance == null){
			instance = new ZoneCasheUtil();
		}
		return instance;
		
	}
	
	public void loadComponent(){
		initZone();
		componentMap = new HashMap();
		setZoneSelList(componentMap);
	}
	
	private void setZoneSelList(HashMap rawData) {
		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		try {
			if(rawData.containsKey(EComponentCode.M_CODE_ZONE.name) && rawData.get(EComponentCode.M_CODE_ZONE.name) != null) {
				if(((List)rawData.get(EComponentCode.M_CODE_ZONE.name)).size() > 0){
					for (Zone temp:((List<Zone>)rawData.get(EComponentCode.M_CODE_ZONE.name))) {
						selItem = new SelectItem();
						selItem.setLabel(temp.getDescription());
						selItem.setValue(temp.getZone());
						selList.add(selItem);
					}
					componentMap.put(EComponentCode.M_CODE_ZONE.name, selList);
				}
			}else{
				if(zone != null && !zone.isEmpty()){
					selItem = new SelectItem("" , msg("value.selectItem"));
					selList.add(selItem);
					for (Zone temp : zone) {
						selItem = new SelectItem();
						selItem.setLabel(temp.getDescription());
						selItem.setValue(temp.getZone());
						selList.add(selItem);
					}
					componentMap.put(EComponentCode.M_CODE_ZONE.name, selList);
				}
			}
		} catch (Exception e) {
			log.error("error in ZoneCacheUtil.setZoneSelList : " + e);
		}
	}
	
	public List<SelectItem> getZoneSelList(){
		List<SelectItem> returnList = new ArrayList<SelectItem>();
		
		if(componentMap == null){
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>)componentMap.get(EComponentCode.M_CODE_ZONE.name);
		} catch (Exception e) {
			log.error("error in ZoneCacheUtil.getZoneSelectItemList : " + e);
		}
		return WebUtil.isNullSelectList(returnList);
	}
}
