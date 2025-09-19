package th.co.ais.rpt.parameter;

import java.util.HashMap;
import java.util.Map;

//import net.sf.jasperreports.engine.export.JRXlsAbstractExporterParameter;

public class SEMMPT003ReportParameter extends ReportParameter {
	
	private String p_pTax_id;
	
	
	public String getP_pTax_id() {
		return p_pTax_id;
	}


	public void setP_pTax_id(String pPTaxId) {
		p_pTax_id = pPTaxId;
	}


	@Override
	public Map getReportParameter() {
		parameters = new HashMap();
		parameters.put("PARAM_REPORT_ENGINE", reportEngine);
		parameters.put("PARAM_ID", p_pTax_id);
		return parameters;
	}	
}
