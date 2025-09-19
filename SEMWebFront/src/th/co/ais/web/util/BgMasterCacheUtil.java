package th.co.ais.web.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import th.co.ais.domain.el.BgMaster;
import th.co.ais.service.el.IBgMasterService;
import th.co.ais.util.EComponentCode;

public class BgMasterCacheUtil implements Serializable{

	private static final long serialVersionUID = 2768053482299992404L;
	private Logger log = Logger.getLogger(getClass());
	private static BgMasterCacheUtil instance = null;
	private static List<BgMaster> bgMasterList;
	private BgMasterCacheUtil(){
		
	}
	
	public static void init(){
		if (bgMasterList == null) {
			try {
				IBgMasterService bgMasterService = (IBgMasterService)FacesUtils.getInstance().getBean("bgMasterELService");
				bgMasterList = bgMasterService.queryAllBgMaster();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static synchronized BgMasterCacheUtil getInstance() {
        if (instance == null) {
            instance = new BgMasterCacheUtil();
        }
        return instance;
    }
	
	@SuppressWarnings("unchecked")
	public void loadComponent(){
		init();
	}
		
	@SuppressWarnings("unchecked")
	public List<BgMaster> getAllbgMaster(){
		List<BgMaster> returnList = new ArrayList<BgMaster>();
		if(bgMasterList == null){ loadComponent(); }
		return bgMasterList;
	}
	
	@SuppressWarnings("unchecked")
	public BgMaster getbgMasterById(String bgMasterId){
		BgMaster bgMaster = null;
		if(bgMasterList == null){ loadComponent(); }
		for(BgMaster obj : bgMasterList){
			if(obj.getRowId().equals(bgMasterId)){
				return obj;
			}
		}
		return bgMaster;
	}
	
}
