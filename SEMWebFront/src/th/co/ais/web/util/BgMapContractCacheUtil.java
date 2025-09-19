package th.co.ais.web.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import th.co.ais.domain.el.BgMapContract;
import th.co.ais.service.el.IBgMapContractService;
import th.co.ais.util.EComponentCode;

public class BgMapContractCacheUtil implements Serializable{
	
	private static final long serialVersionUID = -7098850442633366323L;
	private Logger log = Logger.getLogger(getClass());
	private static BgMapContractCacheUtil instance = null;
	private static List<BgMapContract> bgMapContractList;
	private BgMapContractCacheUtil(){
		
	}
	
	public static void init(){
		if (bgMapContractList == null) {
			try {
				IBgMapContractService bgMapContractService = (IBgMapContractService)FacesUtils.getInstance().getBean("bgMapContractService");
				bgMapContractList = bgMapContractService.queryAllBgMapContract();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static synchronized BgMapContractCacheUtil getInstance() {
        if (instance == null) {
            instance = new BgMapContractCacheUtil();
        }
        return instance;
    }
	
	@SuppressWarnings("unchecked")
	public void loadComponent(){
		init();
	}
	
	@SuppressWarnings("unchecked")
	public List<BgMapContract> getAllBgMapContract(){
		if(bgMapContractList==null){
			loadComponent();
		}
		return bgMapContractList;
	}
	
	@SuppressWarnings("unchecked")
	public BgMapContract getBgMapContractById(String bgMapContractId){
		BgMapContract bgMapContract = null;
		try {
			for(BgMapContract obj : bgMapContractList){
				if(bgMapContractId.equals(obj.getRowId())){
					return obj;
				}
			}
		} catch (Exception e) {
			log.error("error in getBgMapContractById : " + e);
		}
		return bgMapContract;
	}
	
}
