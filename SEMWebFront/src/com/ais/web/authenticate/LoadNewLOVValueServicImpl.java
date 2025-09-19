package com.ais.web.authenticate;

import org.apache.log4j.Logger;

import th.co.ais.web.gm.action.SEMMCT007Action;
import th.co.ais.web.util.LOVCacheUtil;
import th.co.ais.web.util.ManagementMasterCacheUtil;
import th.co.ais.web.util.SelectItemLOVCacheUtil;
import th.co.ais.web.util.config.ParameterConfigUtil;

public class LoadNewLOVValueServicImpl implements LoadNewLOVValueService{
	private Logger LOG = Logger.getLogger(getClass());
	@Override
	public String loadNewLovValue(String cond) throws Exception {
		// TODO Auto-generated method stub
		String flag = "N";
		try{
			clearOldLovValueCache();
			//getSemmct007Bean().setLovTypeSelCrtList(getLovItemsByType(ELovType.T_CT_LOV_TYPE_LIST.name));
			//getSemmct007Bean().setLovTypeSelList(getLovItemsByTypeAndInsertFlag(ELovType.T_CT_LOV_TYPE_LIST.name, "Y"));
//			String cond = getSemmct007Bean().getGroupTypeSelected();
			LOG.info("cond = "+ cond);
			SEMMCT007Action semmct007Action = new SEMMCT007Action();
			semmct007Action.initDDL(cond);
			flag = "Y";
		}catch (Exception e) {
			e.printStackTrace();
			LOG.debug("Error from LoadNewLOVValueService loadNewLovService : "+e);
			// TODO: handle exception
			flag = "N";
		}
		return flag;
	}
	
	
	
	private void clearOldLovValueCache(){
		SelectItemLOVCacheUtil.getInstance().setLov(null);
		SelectItemLOVCacheUtil.getInstance().setSelectItemDataCache(null);
		LOVCacheUtil.getInstance().setLov(null);
		LOVCacheUtil.getInstance().setComponentMap(null);
		//added by NEW 20151106 clear EL ManagementMasterList
		ManagementMasterCacheUtil.getInstance().clearManagementMasterList();
		ParameterConfigUtil.getInstance().clearParameterConfigList();
	}

}
