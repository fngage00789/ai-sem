package th.co.ais.web.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import th.co.ais.domain.gm.VendorBookbank;
import th.co.ais.service.gm.IVendorBookbankService;
import th.co.ais.util.EComponentCode;

public class VendorBookbankCacheUtil implements Serializable{
	
	private static final long serialVersionUID = 9055289927696101173L;
	private Logger log = Logger.getLogger(getClass());
	private static VendorBookbankCacheUtil instance = null;
	private static List<VendorBookbank> vendorBookbankList;
	private VendorBookbankCacheUtil(){
		
	}
	
	public static void init(){
		if (vendorBookbankList == null) {
			try {
				IVendorBookbankService vendorBookbankService = (IVendorBookbankService)FacesUtils.getInstance().getBean("vendorBookbankService");
				vendorBookbankList = vendorBookbankService.queryAllVendorBookbankService();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static synchronized VendorBookbankCacheUtil getInstance() {
        if (instance == null) {
            instance = new VendorBookbankCacheUtil();
        }
        return instance;
    }
	
	@SuppressWarnings("unchecked")
	public void loadComponent(){
		init();
	}
		
	@SuppressWarnings("unchecked")
	public List<VendorBookbank> getAllvendorBookbank(){
		if(vendorBookbankList == null){ loadComponent(); }
		return vendorBookbankList;
	}
	
	@SuppressWarnings("unchecked")
	public VendorBookbank getvendorBookbankById(String vendorBookbankId){
		VendorBookbank vendorBookbank = null;
		if(vendorBookbankList == null){ loadComponent(); }
		try {
			for(VendorBookbank obj : vendorBookbankList){
				if(vendorBookbankId.equals(obj.getRowId())){
					return obj;
				}				
			}
		} catch (Exception e) {
			log.error("error in getVendorBookbankById : " + e);
		}
		return vendorBookbank;
	}
	
}
