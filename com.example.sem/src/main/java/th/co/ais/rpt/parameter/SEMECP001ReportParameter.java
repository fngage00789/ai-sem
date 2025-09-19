package th.co.ais.rpt.parameter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Warawit Kitmongkonsak
 * 
 */
public class SEMECP001ReportParameter extends ReportParameter {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3789124485795507633L;

	//Criteria For Jsp Input Parameters
	private String SITE_CONSTRUCT_ID;
	
	public String getSITE_CONSTRUCT_ID() {
		return SITE_CONSTRUCT_ID;
	}

	public void setSITE_CONSTRUCT_ID(String sITECONSTRUCTID) {
		SITE_CONSTRUCT_ID = sITECONSTRUCTID;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map getReportParameter() {
		parameters = new HashMap();	
		parameters.put("PARAM_REPORT_ENGINE", reportEngine);
		parameters.put("PARAM_SITE_CONSTRUCT_ID", SITE_CONSTRUCT_ID);
		
		return parameters;
	}

}
