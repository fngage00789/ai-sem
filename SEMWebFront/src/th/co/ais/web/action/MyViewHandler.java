package th.co.ais.web.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.application.ViewHandler;
import javax.faces.application.ViewHandlerWrapper;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyViewHandler extends ViewHandlerWrapper {

	private static Log log = LogFactory.getLog(MyViewHandler.class);
	
	private ViewHandler defaultViewHandler = null;	  
    public MyViewHandler() {  }    
    public MyViewHandler(ViewHandler defaultViewHandler) {  
        super();  
        this.defaultViewHandler = defaultViewHandler;  
    }  
        
	@Override
	public void renderView(FacesContext context, UIViewRoot viewRoot) throws IOException, FacesException {
		//super.renderView(context, viewRoot);
		
		//Version 1
		/*viewRoot.visitTree(VisitContext.createVisitContext(context),  
            new VisitCallback() {  
  
                @Override  
                public VisitResult visit(VisitContext context, UIComponent target) {  
  
                    // Authorization logic here  
                    //    target.setRendered(false);  
                    }  
                    return VisitResult.ACCEPT;  
                }  
  
        });
	    defaultViewHandler.renderView(context, viewRoot);*/
		
		//Version 2
		//manageComponents(context, viewRoot);
		//defaultViewHandler.renderView(context, viewRoot);
	}

	@Override
	protected ViewHandler getWrapped() {
		return defaultViewHandler;
	}

	/**
	 * User define func.
	 * @param id
	 * @return
	 */
	private static void manageComponents(FacesContext context, UIViewRoot root){
		try {
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
		
			/*Map<String, Boolean[]> components = new HashMap<String, Boolean[]>();
			components.put("btnReGenerate", new Boolean[]{false,false});
			components.put("btnLoadResponse", new Boolean[]{true,true});
			for(String key : components.keySet()){
				UIComponent component = findComponent(root, key);        
		        if(component != null){
		        	//System.out.println("found the component = " + component.getId() + " class: " + component);
		        	log.info("found the component = " + component.getId() + " class: " + component);
		        	Boolean[] objs = components.get(key);
		        	component.setRendered(objs[0]);
		        	component.getAttributes().put("disabled", objs[1]);		        	
		        	if(component instanceof HtmlAjaxCommandButton){
		        		HtmlAjaxCommandButton button = (HtmlAjaxCommandButton)component;
		        		button.setRendered(objs[0]);
		        		button.setDisabled(objs[1]);
		        	}
		        }
			}*/
		/*} catch (IOException ioe) {
			ioe.printStackTrace();*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static UIComponent findComponentInRoot(FacesContext context, String id) { 
		UIComponent component = null;
		if (context != null) { 
			UIComponent root = context.getViewRoot(); 
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
