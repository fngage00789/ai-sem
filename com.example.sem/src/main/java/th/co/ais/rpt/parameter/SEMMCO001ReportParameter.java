package th.co.ais.rpt.parameter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Warawit Kitmongkonsak
 * 
 */
public class SEMMCO001ReportParameter extends ReportParameter {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7783032104092915374L;
	//Criteria For Jsp Input Parameters
	private String CONTRACT_ID;
	
	public String getCONTRACT_ID() {
		return CONTRACT_ID;
	}

	public void setCONTRACT_ID(String cONTRACTID) {
		CONTRACT_ID = cONTRACTID;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map getReportParameter() {
		parameters = new HashMap();	
		parameters.put("PARAM_REPORT_ENGINE", reportEngine);
		parameters.put("PARAM_CONTRACT_ID", CONTRACT_ID);
		
		return parameters;
	}

}
