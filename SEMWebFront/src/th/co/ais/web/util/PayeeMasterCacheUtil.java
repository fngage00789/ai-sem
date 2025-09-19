package th.co.ais.web.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import th.co.ais.domain.gm.PayeeMaster;
import th.co.ais.service.gm.IPayeeMasterService;
import th.co.ais.util.EComponentCode;

public class PayeeMasterCacheUtil implements Serializable{

	private static final long serialVersionUID = 2245152084112131686L;
	private Logger log = Logger.getLogger(getClass());
	private static PayeeMasterCacheUtil instance = null;
	private static List<PayeeMaster> payeeMasterList;
	private PayeeMasterCacheUtil(){
		
	}
	
	public static void init(){
		if (payeeMasterList == null) {
			try {
				IPayeeMasterService payeeMasterService = (IPayeeMasterService)FacesUtils.getInstance().getBean("payeeMasterService");
				payeeMasterList = payeeMasterService.queryAllPayeeMaster();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static synchronized PayeeMasterCacheUtil getInstance() {
        if (instance == null) {
            instance = new PayeeMasterCacheUtil();
        }
        return instance;
    }
	
	@SuppressWarnings("unchecked")
	public void loadComponent(){
		init();
	}
		
	@SuppressWarnings("unchecked")
	public List<PayeeMaster> getAllPayeeMaster(){
		
		try {
			if(payeeMasterList==null){
				loadComponent();
			}
		} catch (Exception e) {
			log.error("error in getAllPayeeMaster : " + e);
		}
		return payeeMasterList;
	}
	
	@SuppressWarnings("unchecked")
	public PayeeMaster getPayeeMasterById(String payeeMasterId){
		PayeeMaster payeeMaster = null;
		if(payeeMasterList == null){ loadComponent(); }
		try {
			for(PayeeMaster obj : payeeMasterList){
				if(payeeMasterId.equals(obj.getRowId())){
					return obj;
				}
			}
		} catch (Exception e) {
			log.error("error in getPayeeMasterById : " + e);
		}
		return payeeMaster;
	}
	
}
