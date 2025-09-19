package th.co.ais.web.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import th.co.ais.domain.gm.Province;
import th.co.ais.service.gm.IProvinceService;
import th.co.ais.util.EComponentCode;
import th.co.ais.web.action.AbstractBaseAction;


public class ProvinceCacheUtil extends AbstractBaseAction{

	private Logger log = Logger.getLogger(getClass());
	
	private static List<Province> province;
	
	private static ProvinceCacheUtil instance = null;
	
	private HashMap componentMap = null;
	
	private ProvinceCacheUtil(){
		
	}
	
	public static void initProvince(){
		if(province == null){
			try{
				IProvinceService provinceService = (IProvinceService)FacesUtils.getInstance().getBean("provinceService");
				province = provinceService.getListProvince();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public static synchronized ProvinceCacheUtil getInstance() {
        if (instance == null) {
            instance = new ProvinceCacheUtil();
        }
        return instance;
    }
	
	public void loadComponent(){
		initProvince();
		componentMap = new HashMap();
		setProvinceSelList(componentMap);
	}

	private void setProvinceSelList(HashMap rawData) {
		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		
		try{
			if(rawData.containsKey(EComponentCode.M_CODE_PROVINCE.name) && rawData.get(EComponentCode.M_CODE_PROVINCE.name) != null){
				if(((List)rawData.get(EComponentCode.M_CODE_PROVINCE.name)).size() > 0){
					for (Province prov :((List<Province>)rawData.get(EComponentCode.M_CODE_PROVINCE.name))) {
						selItem = new SelectItem();
						selItem.setLabel(prov.getThaiName());
//						selItem.setValue(prov.getProvinceCode());
						selItem.setValue(prov.getRowId());
						selList.add(selItem);
					}
					componentMap.put(EComponentCode.M_CODE_PROVINCE.name, selList);
				}
			}else{
				if(province != null && !province.isEmpty()){
					selItem = new SelectItem("" , msg("value.selectItem"));
					selList.add(selItem);
					for(Province prov : province){
						selItem = new SelectItem();
						selItem.setLabel(prov.getThaiName());
//						selItem.setValue(prov.getProvinceCode());
						selItem.setValue(prov.getRowId());
						selList.add(selItem);
					}
				}
				
				componentMap.put(EComponentCode.M_CODE_PROVINCE.name, selList);
			}
			
		}catch(Exception e){
			log.error("error in ProvinceUtil.setProvinceList : " + e);
		}
		
	}
	
	public List<SelectItem> getProvinceSelList(){
		List<SelectItem> returnList = new ArrayList<SelectItem>();
		
		if(componentMap == null){
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>)componentMap.get(EComponentCode.M_CODE_PROVINCE.name);
			
		} catch (Exception e) {
			log.error("error in ProvinceUtil.setProvinceList : " + e);
		}
		return returnList;
	}
}
