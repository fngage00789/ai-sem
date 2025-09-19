package th.co.ais.web.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import th.co.ais.domain.gm.VendorMapPayee;
import th.co.ais.service.gm.IVendorMapPayeeService;
import th.co.ais.util.EComponentCode;

public class VendorMapPayeeCacheUtil implements Serializable{

	private static final long serialVersionUID = 2768053482299992404L;
	private Logger log = Logger.getLogger(getClass());
	private static VendorMapPayeeCacheUtil instance = null;
	private static List<VendorMapPayee> vendorMapPayeeList;
	private VendorMapPayeeCacheUtil(){
		
	}
	
	public static void init(){
		if (vendorMapPayeeList == null) {
			try {
				IVendorMapPayeeService vendorMapPayeeService = (IVendorMapPayeeService)FacesUtils.getInstance().getBean("vendorMapPayeeService");
				vendorMapPayeeList = vendorMapPayeeService.queryAllVendorMapPayeeMaster();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static synchronized VendorMapPayeeCacheUtil getInstance() {
        if (instance == null) {
            instance = new VendorMapPayeeCacheUtil();
        }
        return instance;
    }
	
	@SuppressWarnings("unchecked")
	public void loadComponent(){
		init();
	}
		
	@SuppressWarnings("unchecked")
	public List<VendorMapPayee> getAllVendorMapPayee(){
		if(vendorMapPayeeList == null){ loadComponent(); }
		return vendorMapPayeeList;
	}
	
	@SuppressWarnings("unchecked")
	public VendorMapPayee getvendorMapPayeeById(String vendorMapPayeeId){
		VendorMapPayee vendorMapPayee = null;
		if(vendorMapPayeeList == null){ loadComponent(); }
		try {
			for(VendorMapPayee obj : vendorMapPayeeList){
				if(vendorMapPayeeId.equals(obj.getRowId())){
					return obj;
				}
			}
		} catch (Exception e) {
			log.error("error in getVendorMapPayeeById : " + e);
		}
		return vendorMapPayee;
	}
	
}
