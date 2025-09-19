package th.co.ais.web.tag;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.Renderer;

import th.co.ais.web.tag.UISelectOneRadio;

public class HTMLSelectOneRadioRenderer extends Renderer implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * <p>Decoding is required.</p>
	 *
	 * @param context   <code>FacesContext</code>for the current request
	 * @param component <code>UIComponent</code> to be decoded
	 */
	public void decode(FacesContext context, UIComponent component) {
		if ((context == null) || (component == null)) {
			throw new NullPointerException();
		}

		UISelectOneRadio aUISelectOneRadio = null;
		if(component instanceof UISelectOneRadio)	{
			aUISelectOneRadio = (UISelectOneRadio)component;
		} 
		else {
			return;
		}		
		Map map = context.getExternalContext().getRequestParameterMap();
		String name = getName(aUISelectOneRadio, context);
		if ( map.containsKey(name) ) {
			String value = (String)map.get(name);
			if ( value != null )  {
				setSubmittedValue(component, value);
			}

		}		
	}
	/**
	 * <p>No begin encoding is required.</p>
	 *
	 * @param context   <code>FacesContext</code>for the current request
	 * @param component <code>UIComponent</code> to be decoded
	 */
	public void encodeBegin(FacesContext context, UIComponent component)
		throws IOException {
		if ((context == null) || (component == null)) {
			throw new NullPointerException();
		}
	}

	/**
	 * <p>No children encoding is required.</p>
	 *
	 * @param context   <code>FacesContext</code>for the current request
	 * @param component <code>UIComponent</code> to be decoded
	 */
	public void encodeChildren(FacesContext context, UIComponent component)
		throws IOException {
		if ((context == null) || (component == null)) {
			throw new NullPointerException();
		}
	}
	/**
	 * <p>Encode this component.</p>
	 *
	 * @param context   <code>FacesContext</code>for the current request
	 * @param component <code>UIComponent</code> to be decoded
	 */
	
	public void encodeEnd(FacesContext context, UIComponent component)
		throws IOException {
		if ((context == null) || (component == null)) {
			throw new NullPointerException();
		}
		
		UISelectOneRadio aUISelectOneRadio = 
			(UISelectOneRadio)component;
			
		if ( component.isRendered() ) {			
			ResponseWriter writer = context.getResponseWriter();
	
			writer.write("<input type=\"radio\"");
			writer.write(" id=\"" + component.getClientId(context) + "\"");
			writer.write(" name=\"" + getName(aUISelectOneRadio, context) + "\"");
			if ( aUISelectOneRadio.getStyleClass() != null && aUISelectOneRadio.getStyleClass().trim().length() > 0 ) {
				writer.write(" class=\"" + aUISelectOneRadio.getStyleClass().trim() + "\"");
			}		
			if ( aUISelectOneRadio.getStyle() != null && aUISelectOneRadio.getStyle().trim().length() > 0 ) {
				writer.write(" style=\"" + aUISelectOneRadio.getStyle().trim() + "\"");
			}		
			if ( aUISelectOneRadio.getDisabled() != null && aUISelectOneRadio.getDisabled().trim().length() > 0 && aUISelectOneRadio.getDisabled().trim().equals("true")) {
				writer.write(" disabled=\"disabled\"");
			}			
			if ( aUISelectOneRadio.getItemValue() != null ) {
				writer.write(" value=\"" + aUISelectOneRadio.getItemValue().trim() + "\"");
			}		
			if ( aUISelectOneRadio.getOnClick() != null && aUISelectOneRadio.getOnClick().trim().length() > 0 ) {
				writer.write(" onclick=\"" + aUISelectOneRadio.getOnClick().trim() + "\"");
			}
			if ( aUISelectOneRadio.getOnMouseOver() != null && aUISelectOneRadio.getOnMouseOver().trim().length() > 0 ) {
				writer.write(" onmouseover=\"" + aUISelectOneRadio.getOnMouseOver().trim() + "\"");
			}
			if ( aUISelectOneRadio.getOnMouseOut() != null && aUISelectOneRadio.getOnMouseOut().trim().length() > 0 ) {
				writer.write(" onmouseout=\"" + aUISelectOneRadio.getOnMouseOut().trim() + "\"");
			}
			if ( aUISelectOneRadio.getOnFocus() != null && aUISelectOneRadio.getOnFocus().trim().length() > 0 ) {
				writer.write(" onfocus=\"" + aUISelectOneRadio.getOnFocus().trim() + "\"");
			}
			if ( aUISelectOneRadio.getOnBlur() != null && aUISelectOneRadio.getOnBlur().trim().length() > 0 ) {
				writer.write(" onblur=\"" + aUISelectOneRadio.getOnBlur().trim() + "\"");
			}
			if ( aUISelectOneRadio.getValue() != null &&
					aUISelectOneRadio.getValue().equals(aUISelectOneRadio.getItemValue())) {
				writer.write(" checked=\"checked\"");				
			}			
			writer.write(">");
			if ( aUISelectOneRadio.getItemLabel() != null ) {
				writer.write(aUISelectOneRadio.getItemLabel());	
			}
			writer.write("</input>");
		}		
	}
	public void setSubmittedValue(UIComponent component, Object obj) {
		if(component instanceof UIInput){			
			((UIInput)component).setSubmittedValue(obj);
		}
	}
	private String getName(UISelectOneRadio aUISelectOneRadio,FacesContext context) {

		UIComponent parentUIComponent = 
			getParentDataTableFromHierarchy(aUISelectOneRadio);
		if ( parentUIComponent == null ) {
			return aUISelectOneRadio.getClientId(context);
		}
		else {
			if ( aUISelectOneRadio.getOverrideName() != null &&
				aUISelectOneRadio.getOverrideName().equals("true")) {					
				return aUISelectOneRadio.getName();
			}
			else {

				String id = aUISelectOneRadio.getClientId(context);
				int lastIndexOfColon = id.lastIndexOf(":");
				String partName = "";
				if ( lastIndexOfColon != -1 ) {
					partName = id.substring(0, lastIndexOfColon + 1);
					if ( aUISelectOneRadio.getName() == null ) {
						partName = partName + "generatedRad";
					}
					else 
						partName = partName + aUISelectOneRadio.getName();
				}		

				return partName;
			}
		}
	}
	private UIComponent getParentDataTableFromHierarchy(UIComponent uiComponent) {
		if ( uiComponent == null ) {
			return null;
		}			
		if ( uiComponent instanceof UIData ) {
			return uiComponent;
		}			
		else {
			//try to find recursively in the Component tree hierarchy
			return getParentDataTableFromHierarchy(uiComponent.getParent());
		}			
	}		
}
