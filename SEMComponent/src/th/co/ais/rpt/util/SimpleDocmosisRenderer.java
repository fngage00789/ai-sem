package th.co.ais.rpt.util;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.log4j.Logger;

import th.co.ais.util.AISDataUtility;

import com.docmosis.template.population.render.FieldDetails;
import com.docmosis.template.population.render.FieldRenderer;
import com.docmosis.template.population.render.FieldRendererException;
import com.docmosis.template.population.render.RenderedField;

public class SimpleDocmosisRenderer implements FieldRenderer{
	
	private static Logger log =Logger.getLogger(SimpleDocmosisRenderer.class);
	private static SimpleDocmosisRenderer instance = null;
	
	public static SimpleDocmosisRenderer getInstance() {
		if (instance == null) {
			instance = new SimpleDocmosisRenderer();
		}
		return instance;
	}
	
	@Override
	public RenderedField render(FieldDetails fieldDetails, RenderedField renderedField)
			throws FieldRendererException {
		// TODO Auto-generated method stub		
		Object value = null;
		
		try {
			if (fieldDetails.getValueClass() != null && (
					fieldDetails.getValueClass().equals(Date.class)|| 
					fieldDetails.getValueClass().equals(Timestamp.class))) {
				value = AISDataUtility.toStringThaiDateFullFormat((Date)fieldDetails.getValueObject());
				if ((value.toString()).startsWith("0")) {
					value = (value.toString()).substring(1, (value.toString()).length());
				}
			}
			
			if (fieldDetails.getValueClass() != null &&  fieldDetails.getValueClass().equals(BigDecimal.class)) {
				value = AISDataUtility.convertNumberToStringByDefaultFormat((BigDecimal)fieldDetails.getValueObject());
			}
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
		
		if (value != null) {
			renderedField.setValue(value.toString());
		}
		
		return renderedField;
	}

}
