package th.co.ais.web.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import th.co.ais.web.bean.UserSession;

public class FindComponentInRootPhaseListener /*extends AbstractBaseAction*/ implements PhaseListener {

	private static Log log = LogFactory.getLog(FindComponentInRootPhaseListener.class);
	
	public PhaseId getPhaseId() { 
		return PhaseId.RENDER_RESPONSE;
	} 

	public void beforePhase(PhaseEvent phaseEvent) { 
		//manageComponents(phaseEvent);		
	} 

	public void afterPhase(PhaseEvent phaseEvent) { 
		//manageComponents(phaseEvent);
	} 

	private static void manageComponents(PhaseEvent phaseEvent){
		try {
			System.out.println("PhaseId: "+phaseEvent.getPhaseId());
			
			/*if(useSsoAuthorizeComponent()){			
				UserSession us = (UserSession)getFacesUtils().getSessionMapValue("userSession");
				if(StringUtils.isNotEmpty(us.getProgCode())){
					SsoBean ssoBean = (SsoBean)getFacesUtils().getSessionMapValue("ssoBean");
					if(null!=ssoBean && null!=progCode && null!=ssoBean.getSsoCompCodes()){
				    	HashMap<String, SSOCompCode[]> map = ssoBean.getSsoCompCodes();
				    	if(map.containsKey(progCode)){
				    		for(SSOCompCode comp : map.get(progCode)){
				    			UIComponent component = findComponentInRoot(comp.getCompCode());        
				    	        if(component!=null){
				    	        	boolean isRender = "1".equals(comp.getVisible());
				    	        	boolean isDisable = "0".equals(comp.getEnable());
				    	        	component.setRendered(isRender);
				    	        	component.getAttributes().put("disabled", isDisable);
				    	        }
							}
				    	}//end if(map.containsKey(progCode))
					}//end if(null!=ssoBean && null!=progCode
				}//end if(us.getProgCode() NotEmpty)
			}//end if(useSsoAuthorizeComponent()) */
		
			FacesContext context = FacesContext.getCurrentInstance();
			Map<String, Boolean[]> components = new HashMap<String, Boolean[]>();
			components.put("btnReGenerate", new Boolean[]{false,false});
			components.put("btnLoadResponse", new Boolean[]{true,true});
			for(String key : components.keySet()){
				UIComponent component = findComponentInRoot(key);        
		        if(component != null){
		        	System.out.println("found the component = " + component.getId() + " class: " + component);
		        	log.info("found the component = " + component.getId() + " class: " + component);
		        	Boolean[] objs = components.get(key);
		        	//component.setRendered(objs[0]);
		        	//component.getAttributes().put("disabled", objs[1]);		        	
		        	if(component instanceof HtmlAjaxCommandButton){
		        		HtmlAjaxCommandButton button = (HtmlAjaxCommandButton)component;
		        		button.setRendered(objs[0]);
		        		button.setDisabled(objs[1]);
		        	}
		        }
			}
		/*} catch (IOException ioe) {
			ioe.printStackTrace();*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static UIComponent findComponentInRoot(String id) { 
		UIComponent component = null; 	
		FacesContext facesContext = FacesContext.getCurrentInstance(); 
		if (facesContext != null) { 
			UIComponent root = facesContext.getViewRoot(); 
			component = findComponent(root, id); 
		}
		return component; 
	} 

	public static UIComponent findComponent(UIComponent base, String id) { 
		if (id.equals(base.getId())) 
			return base; 

		UIComponent kid = null; 
		UIComponent result = null; 
		Iterator kids = base.getFacetsAndChildren(); 
		while (kids.hasNext() && (result == null)) { 
			kid = (UIComponent) kids.next(); 
			if (id.equals(kid.getId())) { 
				result = kid; 
				break; 
			} 
			result = findComponent(kid, id); 
			if (result != null) { 
				break; 
			} 
		}	
		return result; 
	}
}
