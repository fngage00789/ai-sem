package th.co.ais.web.util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.service.gm.ILovMasterService;
import th.co.ais.domain.gm.LovMaster;
import th.co.ais.web.action.AbstractBaseAction;



public class SelectItemLOVCacheUtil extends AbstractBaseAction{
	
	private static final long serialVersionUID = -7649064908760186026L;
	
	private Logger LOG = Logger.getLogger(getClass());
	
	private static SelectItemLOVCacheUtil instance = null;
	
	private static List<LovMaster> lov;
	
	private HashMap selectItemDataCache = null;
	
	private HashMap componentMap = null;
	private SelectItemLOVCacheUtil(){

	}
	
	public static void initLov() {
		if (lov == null) {
			try {
				ILovMasterService lovService = (ILovMasterService)FacesUtils.getInstance().getBean("lovMasterService");
				lov = lovService.getListLovActive();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static synchronized SelectItemLOVCacheUtil getInstance() {
        if (instance == null) {
            instance = new SelectItemLOVCacheUtil();
        }
        return instance;
    }
		
	public List<SelectItem> getLovItemsByType(String type) {
		//LOG.info("-- getLovItemsByType --" + type);
		SelectItem selItem = null;
		//init
		initLov();
		
		//process
		List<SelectItem> listlov = new LinkedList<SelectItem>();
		if (selectItemDataCache == null) {
			selectItemDataCache = new HashMap<String, Object>();
		}
		System.out.println("lovType=" + type);
		if (selectItemDataCache.containsKey("lovType=" + type)) {
			//LOG.info("getLovItemsByType found in hashmap");
			// found hashmap
			return (List<SelectItem>)selectItemDataCache.get("lovType=" + type);
		} else {
			// Generate SelectItem
			if (((type != null))) {
				selItem = new SelectItem("" , msg("value.selectItem"));
				listlov.add(selItem);
				if(lov != null && !lov.isEmpty()){
					for (LovMaster lo : lov) {
						if ((StringUtils.equals(type, lo.getLovType()))) {
							selItem = new SelectItem();
							selItem.setLabel(lo.getLovName());
							selItem.setValue(lo.getLovCode());
							listlov.add(selItem);
						}
					}
				}
			} 
			selectItemDataCache.put("lovType=" + type, listlov);
		}
		return (List<SelectItem>)selectItemDataCache.get("lovType=" + type);
	}
	
	public List<SelectItem> getLovItemsByTypeAndVal(String type,String val) {
		//LOG.info("-- getLovItemsByType --" + type);
		SelectItem selItem = null;
		//init
		initLov();
		
		//process
		List<SelectItem> listlov = new LinkedList<SelectItem>();
		if (selectItemDataCache == null) {
			selectItemDataCache = new HashMap<String, Object>();
		}
		if (selectItemDataCache.containsKey("lovType=" + type + ",lovVal=" + val)) {
			//LOG.info("getLovItemsByType found in hashmap");
			// found hashmap
			return (List<SelectItem>)selectItemDataCache.get("lovType=" + type + ",lovVal=" + val);
		} else {
			// Generate SelectItem
			if (((type != null))) {
				selItem = new SelectItem("" , msg("value.selectItem"));
				listlov.add(selItem);
				if(lov != null && !lov.isEmpty()){
					for (LovMaster lo : lov) {
						if (StringUtils.equals(type, lo.getLovType()) && StringUtils.equals(val, lo.getLovVal())) {
							selItem = new SelectItem();
							selItem.setLabel(lo.getLovName());
							selItem.setValue(lo.getLovCode());
							listlov.add(selItem);
						}
					}
				}
			} 
			
			selectItemDataCache.put("lovType=" + type + ",lovVal=" + val, listlov);
		}
		return (List<SelectItem>)selectItemDataCache.get("lovType=" + type + ",lovVal=" + val);
	}
	
	public List<SelectItem> getLovItemsByTypeExceptLovCodes(String type, String notInLovCode) {
		//LOG.info("-- getLovItemsByType --" + type);
		SelectItem selItem = null;
		//init
		initLov();
		
		//process
		List<SelectItem> listlov = new LinkedList<SelectItem>();
		if (selectItemDataCache == null) {
			selectItemDataCache = new HashMap<String, Object>();
		}
		String criteria = "lovType=" + type + ",notInLovCode=" + notInLovCode;
		if (selectItemDataCache.containsKey(criteria)) {
			//LOG.info("getLovItemsByType found in hashmap");
			// found hashmap
			return (List<SelectItem>)selectItemDataCache.get(criteria);
		} else {
			// Generate SelectItem
			if (((type != null))) {
				selItem = new SelectItem("" , msg("value.selectItem"));
				listlov.add(selItem);
				if(lov != null && !lov.isEmpty()){
					if(StringUtils.isNotBlank(notInLovCode)){
						
						for (LovMaster lo : lov) {
							if (StringUtils.equals(type, lo.getLovType()) && 
									!StringUtils.contains(notInLovCode, lo.getLovCode())) {
								selItem = new SelectItem();
								selItem.setLabel(lo.getLovName());
								selItem.setValue(lo.getLovCode());
								listlov.add(selItem);
							}
						}
					}
					
				}
			} 
			
			selectItemDataCache.put(criteria, listlov);
		}
		return (List<SelectItem>)selectItemDataCache.get(criteria);
	}
	
	// For LovCode is equals 02
	public List<SelectItem> getSiteTypePicoList(String type) {
		//LOG.info("-- getLovItemsByType --" + type);
		SelectItem selItem = null;
		//init
		initLov();
		
		//process
		List<SelectItem> listlov = new LinkedList<SelectItem>();
		if (selectItemDataCache == null) {
			selectItemDataCache = new HashMap<String, Object>();
		}
		if (selectItemDataCache.containsKey("lovType=" + type)) {
			//LOG.info("getLovItemsByType found in hashmap");
			// found hashmap
			return (List<SelectItem>)selectItemDataCache.get("lovType=" + type);
		} else {
			// Generate SelectItem
			if (((type != null))) {
				selItem = new SelectItem("" , msg("value.selectItem"));
				listlov.add(selItem);
				if(lov != null && !lov.isEmpty()){
					for (LovMaster lo : lov) {
						if ((StringUtils.equals(type, lo.getLovType()))) {
							if (StringUtils.isNotEmpty(lo.getLovCode()) && !"02".equals(lo.getLovCode())) {
								selItem = new SelectItem();
								selItem.setLabel(lo.getLovName());
								selItem.setValue(lo.getLovCode());
								listlov.add(selItem);
							}	
						}
					}
				}
			} 
			
			selectItemDataCache.put("lovType=" + type, listlov);
		}
		return (List<SelectItem>)selectItemDataCache.get("lovType=" + type);
	}
	
	public List<SelectItem> getLovItemsValueNameByType(String type) {
		SelectItem selItem = null;
		initLov();
		
		//process
		List<SelectItem> listlov = new LinkedList<SelectItem>();
		if (selectItemDataCache == null) {
			selectItemDataCache = new HashMap<String, Object>();
		}
		if (selectItemDataCache.containsKey("lovType=" + type)) {
			return (List<SelectItem>)selectItemDataCache.get("lovType=" + type);
		} else {
			// Generate SelectItem
			if (((type != null))) {
				selItem = new SelectItem("" , msg("value.selectItem"));
				listlov.add(selItem);
				if(lov != null && !lov.isEmpty()){
					for (LovMaster lo : lov) {
						if ((StringUtils.equals(type, lo.getLovType()))) {
							selItem = new SelectItem();
							selItem.setLabel(lo.getLovName());
							selItem.setValue(lo.getLovName());
							listlov.add(selItem);
						}
					}
				}
			} 
			
			selectItemDataCache.put("lovType=" + type, listlov);
		}
		return (List<SelectItem>)selectItemDataCache.get("lovType=" + type);
	}
	
	public List<SelectItem> getLovItemsByTypeAndInsertFlag(String type, String insertFlag, String cond1) {
		//LOG.info("-- getLovItemsByType --" + type);
		SelectItem selItem = null;
		//init
		initLov();
		
		//process
		List<SelectItem> listlov = new LinkedList<SelectItem>();
		if (selectItemDataCache == null) {
			selectItemDataCache = new HashMap<String, Object>();
		}
		if (selectItemDataCache.containsKey("lovType=" + type + ",insertFlag=" + insertFlag + ",cond1=" + cond1)) {
			//LOG.info("getLovItemsByType found in hashmap");
			// found hashmap
			return (List<SelectItem>)selectItemDataCache.get("lovType=" + type + ",insertFlag=" + insertFlag + ",cond1=" + cond1);
		} else {
			// Generate SelectItem
			if (((type != null))) {
				selItem = new SelectItem("" , msg("value.selectItem"));
				listlov.add(selItem);
				if(lov != null && !lov.isEmpty()){
					for (LovMaster lo : lov) {
						
						if(StringUtils.isNotEmpty(type) && StringUtils.isNotEmpty(insertFlag) && StringUtils.isNotEmpty(cond1)){
							if (StringUtils.equals(type, lo.getLovType()) && 
									StringUtils.equals(insertFlag, lo.getInsertFlag()) &&
									StringUtils.equals(cond1, lo.getLovCond1())) {
								selItem = new SelectItem();
								selItem.setLabel(lo.getLovName());
								selItem.setValue(lo.getLovCode());
								listlov.add(selItem);
							}
						}
					}
				}
			} 
			
			selectItemDataCache.put("lovType=" + type + ",insertFlag=" + insertFlag + ",cond1=" + cond1, listlov);
		}
		return (List<SelectItem>)selectItemDataCache.get("lovType=" + type + ",insertFlag=" + insertFlag + ",cond1=" + cond1);
	}
	
	public List<SelectItem> getLovItemsByType(String type, String expression, String cond1, String cond2, String cond3) {
		//LOG.info("-- getLovItemsByType type, criteria ,cond1, cond2, cond3--");
		SelectItem selItem = null;
		
		//init
		initLov();
		
		//process
		List<SelectItem> listlov = new LinkedList<SelectItem>();
//		if (selectItemDataCache == null) {
			selectItemDataCache = new HashMap<String, Object>();
//		}
		String condition = "lovType=" + type + ",criteria="
									  + expression + ",cond1=" 
									  + cond1 + ",cond2=" 
									  + cond2 + ",cond3="
									  + cond3;
		
		if (selectItemDataCache.containsKey(condition)) {
			//LOG.info("getLovItemsByType type, criteria ,cond1, cond2, cond3 found in hashmap");
			// found hashmap
			return (List<SelectItem>)selectItemDataCache.get(condition);
		} else {
			// Generate SelectItem
			if (type != null) {
				selItem = new SelectItem("" , msg("value.selectItem"));
				listlov.add(selItem);
				if(lov != null && !lov.isEmpty()){
					for (LovMaster lo : lov) {
							//LOG.info("lo.getLovCond3() =" + lo.getLovCond3());
						
//						if(StringUtils.equals(expression, EX_ALL)){	
//							if (StringUtils.equals(type, lo.getLovType())){
//								
//								selItem = new SelectItem();
//								selItem.setLabel(lo.getLovName());
//								selItem.setValue(lo.getLovCode());
//								listlov.add(selItem);
//							}
//						}
						
						if(StringUtils.equals(expression, EX_AND)){	
							
							if (cond1 != null && cond2 == null && cond3 == null) {
								if (StringUtils.equals(type, lo.getLovType()) && 
										StringUtils.equals(cond1, lo.getLovCond1())) {
									selItem = new SelectItem();
									selItem.setLabel(lo.getLovName());
									selItem.setValue(lo.getLovCode());
									listlov.add(selItem);
								}
							} else if (cond1 == null && cond2 != null && cond3 == null) {
								if (StringUtils.equals(type, lo.getLovType()) && 
										StringUtils.equals(cond2, lo.getLovCond2())) {
									selItem = new SelectItem();
									selItem.setLabel(lo.getLovName());
									selItem.setValue(lo.getLovCode());
									listlov.add(selItem);
								}
							} else if (cond1 == null && cond2 == null && cond3 != null) {
								if (StringUtils.equals(type, lo.getLovType()) && 
										StringUtils.equals(cond3, lo.getLovCond3())) {
									selItem = new SelectItem();
									selItem.setLabel(lo.getLovName());
									selItem.setValue(lo.getLovCode());
									listlov.add(selItem);
								}
							} else {
								if (StringUtils.equals(type, lo.getLovType()) && 
										StringUtils.equals(cond1, lo.getLovCond1()) &&
										StringUtils.equals(cond2, lo.getLovCond2()) &&
										StringUtils.equals(cond3, lo.getLovCond3())) {
								
									selItem = new SelectItem();
									selItem.setLabel(lo.getLovName());
									selItem.setValue(lo.getLovCode());
									listlov.add(selItem);
								}
							}
						} else if(StringUtils.equals(expression, EX_OR)){	
							if (StringUtils.equals(type, lo.getLovType()) || 
								StringUtils.equals(cond1, lo.getLovCond1()) ||
								StringUtils.equals(cond2, lo.getLovCond2()) ||
								StringUtils.equals(cond3, lo.getLovCond3())){
								
								selItem = new SelectItem();
								selItem.setLabel(lo.getLovName());
								selItem.setValue(lo.getLovCode());
								listlov.add(selItem);
							}
						} else if(StringUtils.equals(expression, EX_IN)){
							
							String condition1 = lo.getLovCond1();
							//CharSequence char0 = condition1;

							if(StringUtils.equals(type, lo.getLovType()) &&
									StringUtils.isNotBlank(condition1) && 
									StringUtils.isNotEmpty(condition1)){
								if(StringUtils.isBlank(cond1) || cond1 == null) cond1 = "";
								boolean result = false;
								//boolean result = cond1.contains(char0);
								String[] arrCond1 = cond1.split(",");
								for(int i=0; i<arrCond1.length; i++){
									if(StringUtils.equals(arrCond1[i], condition1))
										result = true;
									if(result){
								    	selItem = new SelectItem();
										selItem.setLabel(lo.getLovName());
										selItem.setValue(lo.getLovCode());
										listlov.add(selItem);
										break;
								    }
								}
							}
							
							String condition2 = lo.getLovCond2();
							if(StringUtils.isNotBlank(condition2) && 
							   StringUtils.isNotEmpty(condition2)){
								if(StringUtils.isBlank(cond2) || cond2 == null) cond2 = "";
								boolean result = false;
								//boolean result = cond1.contains(char0);
								String[] arrCond2 = cond2.split(",");
								for(int i=0; i<arrCond2.length; i++){
									if(StringUtils.equals(arrCond2[i], condition2))
										result = true;
									if(result){
								    	selItem = new SelectItem();
										selItem.setLabel(lo.getLovName());
										selItem.setValue(lo.getLovCode());
										listlov.add(selItem);
										break;
								    }
								}
							}
							
							String condition3 = lo.getLovCond3();
							if(StringUtils.isNotBlank(condition3) && 
							   StringUtils.isNotEmpty(condition3)){
								if(StringUtils.isBlank(cond3) || cond3 == null) cond3 = "";
								boolean result = false;
								//boolean result = cond1.contains(char0);
								String[] arrCond3 = cond3.split(",");
								for(int i=0; i<arrCond3.length; i++){
									if(StringUtils.equals(arrCond3[i], condition3))
										result = true;
									if(result){
								    	selItem = new SelectItem();
										selItem.setLabel(lo.getLovName());
										selItem.setValue(lo.getLovCode());
										listlov.add(selItem);
										break;
								    }
								}
							}
						}
					}
				}
			} 
			
			selectItemDataCache.put(condition, listlov);
		}
		return (List<SelectItem>)selectItemDataCache.get(condition);
	}
	
	public String getLovVal2(String type, String lovCode) {
		String lovVal2 = "";
		//init
		initLov();
		
		//process
		List<SelectItem> listlov = new LinkedList<SelectItem>();
		if (selectItemDataCache == null) {
			selectItemDataCache = new HashMap<String, Object>();
		}
			// Generate SelectItem
			if ((type != null && lovCode != null)) {
				if(lov != null && !lov.isEmpty()){
					for (LovMaster lo : lov) {
						if ((StringUtils.equals(type, lo.getLovType()))
								&& StringUtils.equals(lovCode, lo.getLovCode())) {
									lovVal2 = lo.getLovVal2();
						}
					}
				}
			} 
			
		return lovVal2;
	}
	
	public HashMap getSelectItemDataCache() {
		return selectItemDataCache;
	}

	public void setSelectItemDataCache(HashMap selectItemDataCache) {
		this.selectItemDataCache = selectItemDataCache;
	}

	public static List<LovMaster> getLov() {
		return lov;
	}

	public static void setLov(List<LovMaster> lov) {
		SelectItemLOVCacheUtil.lov = lov;
	}	
}