package th.co.ais.web.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;


public class ELMessageUtil {
	private static ELMessageUtil instance = null;
	ResourceBundle menuMSG = null;

	private ELMessageUtil(){
		menuMSG = ResourceBundle.getBundle("resources.el.elmessage");
	}
	
	public  String getMSG(String key) {
		String value = null;
		try {
			value = menuMSG.getString(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public static synchronized ELMessageUtil getInstance() {
		if(instance == null){
			instance = new ELMessageUtil();
		}
		return instance;
	}
	
	public static synchronized String getMessage(String key){
	  	String w_msg = null;
	  	try{  		
	  		w_msg = ELMessageUtil.getInstance().getMSG(key);		
	  	}catch( MissingResourceException e){  
	  		e.printStackTrace();
	  	}
	  	return w_msg;
	}

}
