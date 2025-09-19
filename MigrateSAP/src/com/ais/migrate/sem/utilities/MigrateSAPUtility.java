package com.ais.migrate.sem.utilities;

import java.io.File;
import java.io.FilenameFilter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.StringUtils;

import com.ais.migrate.sem.hibernate.annotion.SapMapping;

public class MigrateSAPUtility {
	
	private static MigrateSAPUtility instance = null;
		
	ResourceBundle appSAP = null;
	private MigrateSAPUtility(){
		appSAP = ResourceBundle.getBundle("com.ais.migrate.sem.resources.migrate_sap");
	}
	
	private String getMSG(String key) {
		String value = null;
		try {
			value = appSAP.getString(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	public static synchronized MigrateSAPUtility getInstance() {
		if(instance == null){
			instance = new MigrateSAPUtility();
		}
		return instance;
	}
	public static synchronized String getMessage(String key){
	  	String w_msg = null;
	  	try{  		
	  		w_msg = MigrateSAPUtility.getInstance().getMSG(key);		
	  	}catch( MissingResourceException e){  
	  		e.printStackTrace();
	  	}
	  	return w_msg;
	}
	
	public static void setModel(Object model, List<SapMapping> maps, String[] fieldValues) throws Exception, UnsupportedEncodingException{		
		SapMapping[] mappings =  maps.toArray(new SapMapping[]{});
		Class clazz = model.getClass();		
		for(int i=0; i<fieldValues.length; i++){
			String fValue = fieldValues[i];
			SapMapping map = mappings[i];
			String fDbName = map.getFieldDbName();
			String declaredF = fDbName.substring(0, 1).toLowerCase().concat(fDbName.substring(1,fDbName.length()));
			
			//System.out.println(" - "+fValue);			
			try {
				Field field = clazz.getDeclaredField(declaredF);
				Method method = clazz.getMethod("set".concat(fDbName), field.getType());
				method.invoke(model, ConvertUtils.convert(fValue, field.getType()));
			} catch (Exception e) {
				System.out.println("Exception ["+map.getTemplateId()+"/"+map.getFieldName()+"]"+e.getMessage());
				throw e;
			}			
		}
	}
	
	/** V.2 support: FILENAME, CREATEDATE **/
	private static SimpleDateFormat sdfYYYYMMDD = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
	public static void setModel(Object model, List<SapMapping> maps, String[] fieldValues, 
										String fileName, Date currentDate) throws Exception, UnsupportedEncodingException{		
		SapMapping[] mappings =  maps.toArray(new SapMapping[]{});
		Class clazz = model.getClass();		
		for(int i=0; i<fieldValues.length; i++){
			String fValue = fieldValues[i];
			SapMapping map = mappings[i];
			String fDbName = map.getFieldDbName();
			String declaredF = fDbName.substring(0, 1).toLowerCase().concat(fDbName.substring(1,fDbName.length()));
			
			//System.out.println(" - "+fValue);		
			try {
				Field field = clazz.getDeclaredField(declaredF);
				Method method = clazz.getMethod("set".concat(fDbName), field.getType());
				
				//Add by vorapt49 25/03/2011
				if(field.getType().equals(Double.class)){ 
					//กรณีเป็น Double ตัวเลขจะเป็น format นี้  12000.50-  < มีเครื่องหมายลบอยู่ข้างหลัง >
					if(fValue.indexOf("-") > -1){
						fValue = "-"+fValue.replaceAll("-", "");
					}
				}
				method.invoke(model, ConvertUtils.convert(fValue, field.getType()));
				
			} catch (Exception e) {
				System.out.println("Exception ["+map.getTemplateId()+"/"+map.getFieldName()+"]"+e.getMessage());
				throw e;
			}			
		}
		
		if(StringUtils.isNotBlank(fileName)){
			Method method = clazz.getMethod("setFilename", String.class);
			method.invoke(model, ConvertUtils.convert(fileName, String.class));
		}
		
		if(currentDate != null){
			String curDate = sdfYYYYMMDD.format(new Date());
			Method method = clazz.getMethod("setCreatedate", String.class);
			method.invoke(model, ConvertUtils.convert(sdfYYYYMMDD.format(currentDate), String.class));
		}
	}
}
