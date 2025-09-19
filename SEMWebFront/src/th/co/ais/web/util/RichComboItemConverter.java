package th.co.ais.web.util;

import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

public class RichComboItemConverter implements javax.faces.convert.Converter{

	@SuppressWarnings("unchecked")
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		List<SelectItem> selectItems = (List<SelectItem>)component.getAttributes().get("selectItems");
		Iterator<SelectItem> iterator = selectItems.iterator();
		while(iterator.hasNext()) {
			SelectItem selItem = iterator.next();
			RichComboItem comboBoxItem = (RichComboItem)selItem.getValue();
			if(comboBoxItem.getLabel().equalsIgnoreCase(value)) {
				return comboBoxItem;
			}
		}
		return null;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value == null) {
			return "";
		}
		RichComboItem comboBoxItem = (RichComboItem) value;
		return comboBoxItem.getLabel();
	}

}
