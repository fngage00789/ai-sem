package th.co.ais.web.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import th.co.ais.domain.gm.Amphur;
import th.co.ais.service.gm.IAmphurService;
import th.co.ais.util.EComponentCode;
import th.co.ais.web.action.AbstractBaseAction;


public class AmphurCacheUtil extends AbstractBaseAction{

	private Logger log = Logger.getLogger(getClass());
	
	private static List<Amphur> amphur;
	
	private static AmphurCacheUtil instance = null;
	
	private HashMap componentMap = null;
	
	private AmphurCacheUtil(){
		
	}
	
	public static void initAmphur(){
		if(amphur == null){
			try{
				IAmphurService amphurService = (IAmphurService)FacesUtils.getInstance().getBean("amphurService");
				amphur = amphurService.getListAmphur();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public static synchronized AmphurCacheUtil getInstance() {
        if (instance == null) {
            instance = new AmphurCacheUtil();
        }
        return instance;
    }
	
	public void loadComponent(){
		initAmphur();
		componentMap = new HashMap();
		setAmphurSelList(componentMap);
	}

	private void setAmphurSelList(HashMap rawData) {
		List<SelectItem> selList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		
		try{
			if(rawData.containsKey(EComponentCode.M_CODE_AMPHUR.name) && rawData.get(EComponentCode.M_CODE_AMPHUR.name) != null){
				if(((List)rawData.get(EComponentCode.M_CODE_AMPHUR.name)).size() > 0){
					for (Amphur amphur :((List<Amphur>)rawData.get(EComponentCode.M_CODE_AMPHUR.name))) {
						selItem = new SelectItem();
						selItem.setLabel(amphur.getThaiName());
						selItem.setValue(amphur.getRowId());
						selList.add(selItem);
					}
					componentMap.put(EComponentCode.M_CODE_AMPHUR.name, selList);
				}
			}else{
				if(amphur != null && !amphur.isEmpty()){
					selItem = new SelectItem("" , msg("value.selectItem"));
					selList.add(selItem);
					for(Amphur amp : amphur){
						selItem = new SelectItem();
						selItem.setLabel(amp.getThaiName());
						selItem.setValue(amp.getRowId());
						selList.add(selItem);
					}
				}
				
				componentMap.put(EComponentCode.M_CODE_AMPHUR.name, selList);
			}
			
		}catch(Exception e){
			log.error("error in ProvinceUtil.setAmphurList : " + e);
		}
		
	}
	
	public List<SelectItem> getAmphurSelList(){
		List<SelectItem> returnList = new ArrayList<SelectItem>();
		
		if(componentMap == null){
			loadComponent();
		}
		try {
			returnList = (List<SelectItem>)componentMap.get(EComponentCode.M_CODE_AMPHUR.name);
		} catch (Exception e) {
			log.error("error in ProvinceUtil.getAmphurList : " + e);
		}
		return returnList;
	}
}
