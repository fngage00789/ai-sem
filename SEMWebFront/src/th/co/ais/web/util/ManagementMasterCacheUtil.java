package th.co.ais.web.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.el.ManagementMaster;
import th.co.ais.service.el.IManagementMasterService;

public class ManagementMasterCacheUtil implements Serializable{

	private static final long serialVersionUID = 1118604151338632966L;

	private Logger log = Logger.getLogger(getClass());
	private static ManagementMasterCacheUtil instance = null;
	private static List<ManagementMaster> managementMasterList;
	private static HashMap<String,ManagementMaster> managementMasterMap;
	private ManagementMasterCacheUtil(){
	
	}
	
	public static void init(){
		if (managementMasterList == null || managementMasterMap == null) {
			try {
				IManagementMasterService managementMasterService = (IManagementMasterService)FacesUtils.getInstance().getBean("managementMasterService");
				managementMasterList = managementMasterService.queryAllManagementMaster();
				managementMasterMap = new HashMap<String, ManagementMaster>();
				for(ManagementMaster obj :managementMasterList){
					managementMasterMap.put(obj.getProcessStatusCode(), obj);
				}
					
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static synchronized ManagementMasterCacheUtil getInstance() {
        if (instance == null) {
            instance = new ManagementMasterCacheUtil();
        }
        return instance;
    }
	
	@SuppressWarnings("unchecked")
	public void loadComponent(){
		init();
	}
		
	@SuppressWarnings("unchecked")
	public List<ManagementMaster> getAllManagementMaster(){
		if(managementMasterList == null){ loadComponent(); }
		return managementMasterList;
	}
	
	@SuppressWarnings("unchecked")
	public ManagementMaster getByProcessStatusCode(String processStatusCode){
		ManagementMaster managementMaster = new ManagementMaster();
		if(managementMasterList == null||managementMasterMap == null){ loadComponent(); }
		try {
//			for(ManagementMaster obj : managementMasterList){
//				if(processStatusCode.equals(obj.getProcessStatusCode())){
//					managementMaster = new ManagementMaster();
//					managementMaster.setChangeTypeFlag(obj.getChangeTypeFlag());
//					managementMaster.setDepositTypeFlag(obj.getDepositTypeFlag());
//					managementMaster.setExpandFlag(obj.getExpandFlag());
//					managementMaster.setFeeFlag(obj.getFeeFlag());
//					managementMaster.setPrivateSpecialFlag(obj.getPrivateSpecialFlag());
//					managementMaster.setProcessStatusCode(obj.getProcessStatusCode());
//					managementMaster.setReceiveJobFlag(obj.getReceiveJobFlag());
//					managementMaster.setRowId(obj.getRowId());
//					managementMaster.setVerifyFlag(obj.getVerifyFlag());
//					managementMaster.setWarrantDetailFlag(obj.getWarrantDetailFlag());
//					managementMaster.setWarrantPrintFlag(obj.getWarrantPrintFlag());
//					managementMaster.setWarrantReprintFlag(obj.getWarrantReprintFlag());
//					managementMaster.setUpdateMeterFlag(obj.getUpdateMeterFlag());
//					return managementMaster;
//				}				
//			}
			if(StringUtils.isNotEmpty(processStatusCode)){
				return managementMasterMap.get(processStatusCode);
			}
		} catch (Exception e) {
			log.error("error in getVendorBookbankById : " + e);
		}
		return managementMaster;
	}

	public static List<ManagementMaster> getManagementMasterList() {
		return managementMasterList;
	}

	public static void setManagementMasterList(List<ManagementMaster> managementMasterList) {
		ManagementMasterCacheUtil.managementMasterList = managementMasterList;
	}
	
	//added by NEW 20151105 
	public static void clearManagementMasterList() {
		ManagementMasterCacheUtil.managementMasterList = null;
	}
}
