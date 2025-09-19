package th.co.ais.web.util;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import Permission.bean.ais.com.SSOCompCode;
import Permission.bean.ais.com.SSOProgCode;
import Permission.bean.ais.com.SSOResponse;

import com.ais.websrv.EmployeeServiceWebServiceV2;
import com.ais.websrv.EmployeeServiceWebServiceV2ServiceLocator;
import common.bean.ais.com.Message;
import th.co.ais.util.ValueTypeHelper;
import th.co.ais.web.bean.SsoBean;
import th.co.ais.web.bean.UserSession;

public class WebUtil implements Serializable{

	public static String USER_SESSION = "userSession";
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(WebUtil.class);
	public static final String PREFIX_PROG_CODE = "mnu"; // If production server, a value is 'mnu';
	public static final String PREFIX_COMP_CODE = "scr"; // If production server, a value is 'scr';
	
	public static UserSession getUserSession() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(true);
		return (UserSession) session.getAttribute(USER_SESSION);
	}

	public static SsoBean getSsoBean(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
		return (SsoBean)session.getAttribute("ssoBean");		
	}
	
	public static void clearAllSessionNotUsed(){
		logger.info("### clear All Session ###");
		//FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(USER_SESSION);
		clearCTBeanSession();
		clearIRBeanSession();
		clearPTBeanSession();
		clearACBeanSession();
		clearCOBeanSession();
		clearCPBeanSession();
		clearELBeanSession();
		clearRTBeanSession();
		clearSIBeanSession();
		clearSABeanSession();
	}
	
	public static void clearUserSession(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(true);
		session.removeAttribute(USER_SESSION);
	}
	
	public static void clearCTBeanSession(){
		for(int b=1; b<=12; b++){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("semmct00"+b+"Bean");
		}
	}
	public static void clearIRBeanSession(){
		for(int b=1; b<=14; b++){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("semmir00"+b+"Bean");
		}
		Object p = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmirPopupBean");
		if(p != null ){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("semmirPopupBean");
		}
			
	}
	public static void clearPTBeanSession(){
		for(int b=1; b<=6; b++){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("semmpt00"+b+"Bean");
		}
	}
	public static void clearACBeanSession(){
		for(int b=1; b<=4; b++){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("semmac00"+b+"Bean");
		}
	}
	public static void clearCOBeanSession(){
		for(int b=1; b<=6; b++){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("semmco00"+b+"Bean");
		}
		for(int b=1; b<=3; b++){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("semmco001tab"+b+"Bean");
		}
		for(int b=1; b<=2; b++){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("semmco004tab"+b+"Bean");
		}
		for(int b=1; b<=3; b++){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("semmco005tab"+b+"Bean");
		}
	}
	public static void clearCPBeanSession(){
		for(int b=1; b<=2; b++){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("semmcp00"+b+"Bean");
		}
	}
	public static void clearELBeanSession(){
		for(int b=1; b<=11; b++){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("semmel00"+b+"Bean");
		}
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("semmel010_2Bean");
	}
	public static void clearRTBeanSession(){
		for(int b=1; b<=9; b++){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("semmrt00"+b+"Bean");
			if(b == 8){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("semmrt00"+b+"PayBean");
			}
		}
	}
	
	public static void clearSIBeanSession(){
		for(int b=1; b<=7; b++){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("semmsi00"+b+"Bean");
		}
		for(int b=1; b<=8; b++){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("semmsi004tab"+b+"Bean");
		}
		for(int b=1; b<=4; b++){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("semqsi00"+b+"Bean");
		}
	}
	
	public static void clearSABeanSession(){
		for(int b=1; b<=4; b++){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("semmsa00"+b+"Bean");
		}
	}
	
	public static String getQueryString(HttpServletRequest request, String name){
		String value = null;
		if(null!=request.getQueryString()){
			String[] qryStrs = request.getQueryString().split("&");
			for(String qryStr : qryStrs){
				String[] qry = qryStr.split("=");
				if(qry.length==2 && name.equals(qry[0])){					
					value = qry[1];
					break;
				}
			}
		}
		return value;
	}

	public static Message syncUserSession(String token) throws Exception{
		logger.debug("Begin syncUserSession");
		Message msg = new Message();
		EmployeeServiceWebServiceV2 empService = (new EmployeeServiceWebServiceV2ServiceLocator()).getEmployeeServiceWebServiceV2SoapPort();
		SSOResponse resp = empService.syncUserSession(token);
		msg = resp.getMessage();
		logger.debug("End syncUserSession >> " + msg.getErrorMesg());
		return msg;
	}
	
	/** ใช้สำหรับกรณี SsoBean Session มีค่าแล้ว **/
	public static Message syncUserSession(HttpServletRequest request) throws Exception{
		//logger.debug("Begin syncUserSession");		
		Message msg = new Message();
		SsoBean sso = (SsoBean)request.getSession().getAttribute("ssoBean");
		if(null==sso){
			logger.debug("Not yet logon (SsoBean session is null)");
			msg.setErrorMesg("You not yet logon");
		}else{
			EmployeeServiceWebServiceV2 empService = (new EmployeeServiceWebServiceV2ServiceLocator()).getEmployeeServiceWebServiceV2SoapPort();
			SSOResponse resp = empService.syncUserSession(sso.getToken());
			msg = resp.getMessage();
			//logger.debug("End syncUserSession >> " + msg.getErrorMesg());
			logger.debug("SyncUserSession: " + sso.getUserName() + " <"+ msg.getErrorMesg()+">");
		}		
		return msg;
	}	
	
	public static List<SelectItem> isNullSelectList(List<SelectItem> list) {
		if (list == null) {
			return new ArrayList<SelectItem>();
		} else {
			return list;	
		}
	}

	/**
	 * @return Map<String, Boolean> : <"btnSearch",true>, <"btnApprove",false>, ...  
	 * 
	 * always return 'true' for legacy rendering
	 * 
	 */
	public static Map<String, Boolean> getRenders() {
		
		return new HashMap<String, Boolean>(){
			private static final long serialVersionUID = 1L;

			@Override
			public Boolean get(Object key) {
				return Boolean.TRUE;
			}
		};
	}
	
	public static Map<String, Boolean> getRenderSSO() {
		HashMap<String, Boolean> mapRender = new HashMap<String, Boolean>();
		try {
			String progCode = getUserSession().getProgCode();
			boolean removeDat = Boolean.parseBoolean(WebUtil.getResources("resources.application_th","removeDat"));
			if (removeDat && !ValueTypeHelper.isEmptyValue(progCode)) {
				progCode = progCode.replace("-", "");
				progCode = WebUtil.PREFIX_COMP_CODE + progCode;
			}
//			System.out.println("getRenderSSO progCode : "+progCode);
		    SsoBean ssoBean = getSsoBean();
//		    System.out.println("ssoBean.getSsoCompCodes() = "+ssoBean.getSsoCompCodes());
		    if(ssoBean!=null && progCode!=null){
		    	if(ssoBean.getSsoRenders().containsKey(progCode)){
		    		mapRender = ssoBean.getSsoRenders().get(progCode);
		    	}else{
		    		Map<String, SSOCompCode[]> map = ssoBean.getSsoCompCodes();
//		    		System.out.println("getRenderSSO map = "+map);
					if(map!=null){
						if(map.containsKey(progCode)){
							System.out.println("TEST : "+map.get(progCode));
							for(SSOCompCode comp : map.get(progCode)){
								if(!mapRender.containsKey(comp.getCompCode())){
									mapRender.put(comp.getCompCode(), !"0".equals(comp.getVisible())?true:false);
								}
							}
							ssoBean.getSsoRenders().put(progCode, mapRender);
							mapRender = ssoBean.getSsoRenders().get(progCode);
						}
					}
		    	}	
		    	
		    }	
//		    System.out.println("getRenderSSO mapRender : "+mapRender);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapRender;
	}
	
	/**
	 * @return Map<String, Boolean> : <"btnSearch",false>, <"btnApprove",false>, ...  
	 */
	public static Map<String, Boolean> getDisables() {
		HashMap<String, Boolean> mapDisabler = new HashMap<String, Boolean>();
		try {
			String progCode = getUserSession().getProgCode();
/*			if (!ValueTypeHelper.isEmptyValue(progCode)) {
				progCode = progCode.replace("-", "");
			}*/
		    SsoBean ssoBean = getSsoBean();		    	    
		    if(ssoBean!=null && progCode!=null){
		    	if(ssoBean.getSsoDisables().containsKey(WebUtil.PREFIX_COMP_CODE + progCode)){
		    		mapDisabler = ssoBean.getSsoDisables().get(progCode);
		    	}else{
		    		HashMap<String, SSOCompCode[]> map = ssoBean.getSsoCompCodes();
					if(map!=null){
						if(map.containsKey(progCode)){
							for(SSOCompCode comp : map.get(progCode)){
								if(!mapDisabler.containsKey(comp.getCompCode())){
									mapDisabler.put(comp.getCompCode(), "0".equals(comp.getEnable()));	
								}
							}
							ssoBean.getSsoDisables().put(progCode, mapDisabler);
							mapDisabler = ssoBean.getSsoDisables().get(progCode);
						}
					}
		    	}		    	
		    }		    
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapDisabler;
	}

	/**
	 * find componentCode in ssoBean.getSsoCompCodes()
	 */
	public static SSOCompCode getCompCodes(String programCode, String componentCode) throws Exception {
		SSOCompCode compCode = null;
		try {
			SsoBean ssoBean = getSsoBean();
			HashMap<String, SSOCompCode[]> mapComponents = ssoBean.getSsoCompCodes();
			
			programCode = programCode.toUpperCase();
			
			if(!mapComponents.containsKey(programCode)){
				throw new Exception(programCode+" not found.");
			}else{
				SSOCompCode[] compCodes = mapComponents.get(programCode);
				
				Comparator<SSOCompCode> c = new Comparator<SSOCompCode>() {
			      public int compare(SSOCompCode c1, SSOCompCode c2) {
			    	  return c1.getCompCode().compareTo(c2.getCompCode());				    	  
			      }
			    };
				SSOCompCode key = new SSOCompCode();
				key.setCompCode(componentCode);
				int index = Collections.binarySearch(Arrays.asList(compCodes), key, c);
				if(index>-1){
					compCode = Arrays.asList(compCodes).get(index);
				}else{
					//ไม่มี component
					throw new Exception(componentCode+" not found.");
				}
			}
	    
		} catch (Exception e) {
			throw e;
		}
		return compCode;
	}
	
	public static List<SSOCompCode> getListCompCodes(String programCode) throws Exception {
		SSOCompCode[] compCodes = null;
		try {
			SsoBean ssoBean = getSsoBean();
			HashMap<String, SSOCompCode[]> mapComponents = ssoBean.getSsoCompCodes();
			
			programCode = programCode.toUpperCase();
			
			if(!mapComponents.containsKey(programCode)){
				throw new Exception(programCode+" not found.");
			}else{
				compCodes = mapComponents.get(programCode);
			}
	    
		} catch (Exception e) {
			throw e;
		}
		return Arrays.asList(compCodes);
	}
	
	/**
	 * @return SSOProgCode สำหรับหน้าที่ใช้อยู่ (ตาม ProgCode) จาก UserSession
	 */
	public static SSOProgCode getSSOProgCode(String progCode){
		SSOProgCode objProgCode = null;//new SSOProgCode(); 
//		System.out.println("progCode : "+progCode);
		try {
			SsoBean ssoBean = getSsoBean();
		    if(ssoBean!=null && ssoBean.getSsoProgCodes()!=null && progCode!=null){
		    	HashMap<String, SSOProgCode> map = ssoBean.getSsoProgCodes();
				if(map!=null){//System.out.println("map : "+map.toString());
					if(map.containsKey(progCode)){
						objProgCode = map.get(progCode);
					}
				}				
		    }	
		} catch (Exception e) {
			e.printStackTrace();
		}	    
	    return objProgCode;
	}
	
	public static String getResources(String resource, String key){
		String value = "";
		try {
			ResourceBundle rb = ResourceBundle.getBundle(resource);			
			value = rb.getString(key);
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}		
		return value;
	}
	
	public static List<SelectItem> getSelectItemByValue(Object value, Collection<SelectItem> selectList){
		List<SelectItem> list = new ArrayList<SelectItem>();
		for(SelectItem s : selectList){
			if(s.getValue().equals(value)){
				list.add(s);
			}
		}
//		return list.size() == 0 ? null : list;
		return list;
	}
	
	public static List<SelectItem> getSelectItemByLabel(String label, Collection<SelectItem> selectList){
		List<SelectItem> list = new ArrayList<SelectItem>();
		for(SelectItem s : selectList){
			if(label.equals(s.getLabel())){
				list.add(s);
			}
		}
		return list.size() == 0 ? null : list;
	}
	
	public static Calendar convertDateToCalendar(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}
}
