package th.co.ais.rpt.parameter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Warawit Kitmongkonsak
 * 
 */
public class SEMECO005ReportParameter extends ReportParameter {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1798396336976459015L;
	//Criteria For Jsp Input Parameters
	private String CONTRACT_ID;
	private String CONTRACT_TYPE;
	
	public String getCONTRACT_ID() {
		return CONTRACT_ID;
	}

	public void setCONTRACT_ID(String cONTRACTID) {
		CONTRACT_ID = cONTRACTID;
	}

	public String getCONTRACT_TYPE() {
		return CONTRACT_TYPE;
	}

	public void setCONTRACT_TYPE(String cONTRACTTYPE) {
		CONTRACT_TYPE = cONTRACTTYPE;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map getReportParameter() {
		parameters = new HashMap();	
		parameters.put("PARAM_REPORT_ENGINE", reportEngine);
		parameters.put("PARAM_CONTRACT_ID", CONTRACT_ID);
		parameters.put("PARAM_CONTRACT_TYPE", CONTRACT_TYPE);
		
		return parameters;
	}

}
