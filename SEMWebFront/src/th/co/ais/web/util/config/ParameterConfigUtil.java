package th.co.ais.web.util.config;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.gm.ParameterConfig;
import th.co.ais.service.gm.IParameterConfigService;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.ManagementMasterCacheUtil;


public class ParameterConfigUtil implements Serializable{
	
	private static final long serialVersionUID = -7649064908760186026L;
	private Logger LOG = Logger.getLogger(getClass());
	
	private static List<ParameterConfig> parametersConfig;
	private static ParameterConfigUtil instance = null;
	private HashMap configCache = null;
	
	
	public static synchronized ParameterConfigUtil getInstance() {
	    if (instance == null) {
	        instance = new ParameterConfigUtil();
	    }
	    return instance;
	}
	
	public static void init() {
		if (parametersConfig == null) {
			try {
				IParameterConfigService paramService = (IParameterConfigService)FacesUtils.getInstance().getBean("parameterConfigService");
				parametersConfig = paramService.queryParameterConfigAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public String getConfigByCode(String code) {
		//LOG.info("-- getConfigByCode --" + code);
		String paramCode = "paramCode=" + code;
		String value = "";
		//init
		init();
		//process
		if (configCache == null) {
			configCache = new HashMap<String, Object>();
		}
		if (configCache.containsKey(paramCode)) {
			//LOG.info("getConfigByCode found in hashmap");
			//found hashmap
			return (String)configCache.get(paramCode);
		} else {
			if (StringUtils.isNotBlank(code)) {
				if(parametersConfig != null && !parametersConfig.isEmpty()){
					
					for(ParameterConfig param : parametersConfig){
						if(StringUtils.equals(param.getRowId(), code)){
							value = param.getParamValue();
							break;
						}
					}
					//LOG.info("value = " + value);
					configCache.put(paramCode, value);
				}
			} 
		}
		return (String)configCache.get(paramCode);
	}
	
	@SuppressWarnings("unchecked")
	public ParameterConfig getparameterByCode(String parameterCode){
		ParameterConfig parameter = null;
		if(parametersConfig == null){ init(); }
		try {
			for(ParameterConfig obj : parametersConfig){
				//System.out.println(" CodeIn : CodeList >>"+parameterCode+" : "+obj.getRowId());
				if(parameterCode.equals(obj.getRowId())){
					return obj;
				}
			}
		} catch (Exception e) {
			LOG.error("error in getparameterById : " + e);
		}
		return parameter;
	}
	
	public static List<ParameterConfig> getParametersConfig() {
		return parametersConfig;
	}
	
	public static void setParametersConfig(List<ParameterConfig> parametersConfig) {
		ParameterConfigUtil.parametersConfig = parametersConfig;
	}
	
	public HashMap getConfigCache() {
		return configCache;
	}
	
	public void setConfigCache(HashMap configCache) {
		this.configCache = configCache;
	}
	
	//added by NEW 20151105 
	public static void clearParameterConfigList() {
		ParameterConfigUtil.parametersConfig = null;
	}
}
