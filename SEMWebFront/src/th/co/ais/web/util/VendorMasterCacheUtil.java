package th.co.ais.web.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import th.co.ais.domain.gm.VendorMaster;
import th.co.ais.service.gm.IVendorMasterService;
import th.co.ais.util.EComponentCode;

public class VendorMasterCacheUtil implements Serializable{

	private static final long serialVersionUID = -1874719453871598474L;
	private Logger log = Logger.getLogger(getClass());
	private static VendorMasterCacheUtil instance = null;
	private static List<VendorMaster> vendorMasterList;
	private VendorMasterCacheUtil(){
		
	}
	
	public static void init(){
		if (vendorMasterList == null) {
			try {
				IVendorMasterService vendorMasterService = (IVendorMasterService)FacesUtils.getInstance().getBean("vendorMasterService");
				vendorMasterList = vendorMasterService.queryAllVendorMaster();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static synchronized VendorMasterCacheUtil getInstance() {
        if (instance == null) {
            instance = new VendorMasterCacheUtil();
        }
        return instance;
    }
	
	@SuppressWarnings("unchecked")
	public void loadComponent(){
		init();
	}
		
	@SuppressWarnings("unchecked")
	public List<VendorMaster> getAllVendorMaster(){
		if(vendorMasterList == null){ loadComponent(); }
		return vendorMasterList;
	}
	
	@SuppressWarnings("unchecked")
	public VendorMaster getVendorMasterById(String vendorMasterId){
		VendorMaster vendorMaster = null;
		if(vendorMasterList == null){ loadComponent(); }
		try {
			for(VendorMaster obj : vendorMasterList){
				if(vendorMasterId.equals(obj.getRowId())){
					return obj;
				}
			}
		} catch (Exception e) {
			log.error("error in getVendorMasterById : " + e);
		}
		return vendorMaster;
	}
	
	
}
