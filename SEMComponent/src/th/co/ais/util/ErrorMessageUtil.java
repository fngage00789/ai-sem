package th.co.ais.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ErrorMessageUtil {
	
	private static ErrorMessageUtil instance = null;
	ResourceBundle appMSG = null;

	private ErrorMessageUtil(){
		appMSG = ResourceBundle.getBundle("th.co.ais.resource.error_message");
	}
	
	public String getMSG(String key) {
		String value = null;
		try {
			value = appMSG.getString(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public static synchronized ErrorMessageUtil getInstance() {
		if(instance == null){
			instance = new ErrorMessageUtil();
		}
		return instance;
	}
	
	public static synchronized String getMessage(String key){
	  	String w_msg = null;
	  	try{  		
	  		w_msg = ErrorMessageUtil.getInstance().getMSG(key);		
	  	}catch( MissingResourceException e){  
	  		e.printStackTrace();
	  	}
	  	return w_msg;
	}
		
}

