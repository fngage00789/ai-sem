package th.co.ais.web.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.gm.Parameter;
import th.co.ais.service.gm.IParameterService;
import th.co.ais.web.action.AbstractBaseAction;

public class ParameterCacheUtil extends AbstractBaseAction implements Serializable{

	private static final long serialVersionUID = 2768053482299992404L;
	private Logger log = Logger.getLogger(getClass());
	private static ParameterCacheUtil instance = null;
	private static List<Parameter> parameterList;
	private HashMap selectItemDataCache = null;
	private ParameterCacheUtil(){
		
	}
	
	public static void init(){
		if (parameterList == null) {
			try {
				IParameterService parameterService = (IParameterService)FacesUtils.getInstance().getBean("parameterService");
				parameterList = parameterService.queryAllParameter();
				System.out.println(" ParameterCacheUtil init parameterList2:"+parameterList.size());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static synchronized ParameterCacheUtil getInstance() {
        if (instance == null) {
            instance = new ParameterCacheUtil();
        }
        return instance;
    }
	
	@SuppressWarnings("unchecked")
	public void loadComponent(){
		init();
	}
		
	@SuppressWarnings("unchecked")
	public List<Parameter> getAllparameter(){
		if(parameterList == null){ loadComponent(); }
		return parameterList;
	}
	
	@SuppressWarnings("unchecked")
	public Parameter getparameterByCode(String parameterCode){
		Parameter parameter = null;
		if(parameterList == null){ loadComponent(); }
		try {
			for(Parameter obj : parameterList){
				//System.out.println(" CodeIn : CodeList >>"+parameterCode+" : "+obj.getRowId());
				if(parameterCode.equals(obj.getRowId())){
					return obj;
				}
			}
		} catch (Exception e) {
			log.error("error in getparameterById : " + e);
		}
		return parameter;
	}
	
	public List<SelectItem> getParamItemsByParamName(String ParamName) {
		//LOG.info("-- getLovItemsByType --" + type);
		SelectItem selItem = null;
		//init
		init();
		
		//process
		List<SelectItem> listParam = new LinkedList<SelectItem>();
		if (selectItemDataCache == null) {
			selectItemDataCache = new HashMap<String, Object>();
		}
		if (selectItemDataCache.containsKey("paramName=" + ParamName)) {
			//LOG.info("getLovItemsByType found in hashmap");
			// found hashmap
			return (List<SelectItem>)selectItemDataCache.get("paramName=" + ParamName);
		} else {
			
			// Generate SelectItem
			if (((ParamName != null))) {
				selItem = new SelectItem("" , msg("value.selectItem"));
				listParam.add(selItem);
				log.debug("parameterList = "+parameterList);
				if(parameterList != null && !parameterList.isEmpty()){
					log.debug("parameterList.size() = "+parameterList.size());
					for (Parameter pa : parameterList) {
						if ((StringUtils.equals(ParamName, pa.getParamName()))) {
							selItem = new SelectItem();
							selItem.setLabel(pa.getDisplayThai());
							selItem.setValue(pa.getParamValue());
							listParam.add(selItem);
						}
					}
				}
			} 
			
			selectItemDataCache.put("paramName=" + ParamName, listParam);
		}
		return (List<SelectItem>)selectItemDataCache.get("paramName=" + ParamName);
	}

}
