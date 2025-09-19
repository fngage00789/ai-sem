package th.co.ais.web.tag;

import java.io.Serializable;

import javax.faces.FactoryFinder;
import javax.faces.application.Application;
import javax.faces.application.ApplicationFactory;
import javax.faces.component.UIComponent;
import javax.faces.el.ValueBinding;
import javax.faces.webapp.UIComponentTag;

public class HTMLSelectOneRadioTag extends UIComponentTag implements Serializable{

	private static final long serialVersionUID = 1L;

	
	public String getComponentType() {
		return "component.SelectOneRadio";
	}

	
	public String getRendererType() {
		return "renderer.SelectOneRadio";
	}

	private String name = null;
	private String value = null;
	private String styleClass = null;
	private String style = null;
	private String disabled = null;
	private String itemLabel = null;
	private String itemValue = null;
	private String onClick = null;
	private String onMouseOver = null;
	private String onMouseOut = null;
	private String onFocus = null;
	private String onBlur = null;
	private String overrideName = null;
	
	
	public String getDisabled() {
		return disabled;
	}


	public String getItemLabel() {
		return itemLabel;
	}


	public String getItemValue() {
		return itemValue;
	}


	public String getName() {
		return name;
	}

	public String getOnBlur() {
		return onBlur;
	}

	public String getOnClick() {
		return onClick;
	}

	public String getOnFocus() {
		return onFocus;
	}

	public String getOnMouseOut() {
		return onMouseOut;
	}

	public String getOnMouseOver() {
		return onMouseOver;
	}

	public String getOverrideName() {
		return overrideName;
	}

	public String getStyle() {
		return style;
	}

	public String getStyleClass() {
		return styleClass;
	}

	public String getValue() {
		return value;
	}

	public void setDisabled(String string) {
		disabled = string;
	}

	public void setItemLabel(String string) {
		itemLabel = string;
	}

	public void setItemValue(String string) {
		itemValue = string;
	}

	public void setName(String string) {
		name = string;
	}

	public void setOnBlur(String string) {
		onBlur = string;
	}

	public void setOnClick(String string) {
		onClick = string;
	}

	public void setOnFocus(String string) {
		onFocus = string;
	}

	public void setOnMouseOut(String string) {
		onMouseOut = string;
	}
	
	public void setOnMouseOver(String string) {
		onMouseOver = string;
	}

	public void setOverrideName(String string) {
		overrideName = string;
	}

	public void setStyle(String string) {
		style = string;
	}

	public void setStyleClass(String string) {
		styleClass = string;
	}

	public void setValue(String string) {
		value = string;
	}

	protected void setProperties(UIComponent component) {
		super.setProperties(component);

		UISelectOneRadio aUISelectOneRadio 
			= (UISelectOneRadio) component;

		if (name != null) {
			if (isValueReference(name)) {
				aUISelectOneRadio.setValueBinding("name", getValueBinding(name));
			} else {
				aUISelectOneRadio.getAttributes()
					.put("name", name);
			}
		}

		if (value != null) {
			if (isValueReference(value)) {
				aUISelectOneRadio.setValueBinding("value", getValueBinding(value));
			} else {
				aUISelectOneRadio.getAttributes()
					.put("value", value);
			}
		}		
		if (styleClass != null) {
			if (isValueReference(styleClass)) {
				aUISelectOneRadio.setValueBinding("styleClass", getValueBinding(styleClass));
			} else {
				aUISelectOneRadio.getAttributes()
					.put("styleClass", styleClass);
			}
		}
		if (style != null) {
			if (isValueReference(style)) {
				aUISelectOneRadio.setValueBinding("style", getValueBinding(style));
			} else {
				aUISelectOneRadio.getAttributes()
					.put("style", style);
			}
		}
		if (disabled != null) {
			if (isValueReference(disabled)) {
				aUISelectOneRadio.setValueBinding("disabled", getValueBinding(disabled));
			} else {
				aUISelectOneRadio.getAttributes()
					.put("disabled", disabled);
			}
		}
		if (itemLabel != null) {
			if (isValueReference(itemLabel)) {
				aUISelectOneRadio.setValueBinding("itemLabel", getValueBinding(itemLabel));
			} else {
				System.out.println("itemLabel=" + itemLabel);
				aUISelectOneRadio.getAttributes()
					.put("itemLabel", itemLabel);
			}
		}
		if (itemValue != null) {
			if (isValueReference(itemValue)) {
				aUISelectOneRadio.setValueBinding("itemValue", getValueBinding(itemValue));
			} else {
				aUISelectOneRadio.getAttributes()
					.put("itemValue", itemValue);
			}
		}		
		if (onClick != null) {
			if (isValueReference(onClick)) {
				aUISelectOneRadio.setValueBinding("onClick", getValueBinding(onClick));
			} else {
				aUISelectOneRadio.getAttributes()
					.put("onClick", onClick);
			}
		}		
		if (onMouseOver != null) {
			if (isValueReference(onMouseOver)) {
				aUISelectOneRadio.setValueBinding("onMouseOver", getValueBinding(onMouseOver));
			} else {
				aUISelectOneRadio.getAttributes()
					.put("onMouseOver", onMouseOver);
			}
		}		
		if (onMouseOut != null) {
			if (isValueReference(onMouseOut)) {
				aUISelectOneRadio.setValueBinding("onMouseOut", getValueBinding(onMouseOut));
			} else {
				aUISelectOneRadio.getAttributes()
					.put("onMouseOut", onMouseOut);
			}
		}		
		if (onFocus != null) {
			if (isValueReference(onFocus)) {
				aUISelectOneRadio.setValueBinding("onFocus", getValueBinding(onFocus));
			} else {
				aUISelectOneRadio.getAttributes()
					.put("onFocus", onFocus);
			}
		}			
		if (onBlur != null) {
			if (isValueReference(onBlur)) {
				aUISelectOneRadio.setValueBinding("onBlur", getValueBinding(onBlur));
			} else {
				aUISelectOneRadio.getAttributes()
					.put("onBlur", onBlur);
			}
		}

		if (overrideName != null) {
			if (isValueReference(overrideName)) {
				aUISelectOneRadio.setValueBinding("overrideName", getValueBinding(overrideName));
			} else {
				aUISelectOneRadio.getAttributes()
					.put("overrideName", overrideName);
			}
		}		
	}
	public ValueBinding getValueBinding(String valueRef) {
		ApplicationFactory af =
			(ApplicationFactory) FactoryFinder.getFactory(FactoryFinder.APPLICATION_FACTORY);
		Application a = af.getApplication();

		return (a.createValueBinding(valueRef));
	}
}
