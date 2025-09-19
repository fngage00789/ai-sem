package th.co.ais.rpt.parameter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Warawit Kitmongkonsak
 * 
 */
public class SEMMEL008ReportParameter extends ReportParameter {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7094222062256693127L;
	/**
	 * 
	 */
	//Criteria For Jsp Input Parameters
	private String PAYMENT_ID;
	private String USER_NAME;
	
	public String getPAYMENT_ID() {
		return PAYMENT_ID;
	}
	
	public void setPAYMENT_ID(String pAYMENTID) {
		PAYMENT_ID = pAYMENTID;
	}

	public String getUSER_NAME() {
		return USER_NAME;
	}

	public void setUSER_NAME(String uSERNAME) {
		USER_NAME = uSERNAME;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map getReportParameter() {
		parameters = new HashMap();	
		parameters.put("PARAM_REPORT_ENGINE", reportEngine);
		parameters.put("PARAM_PAYMENT_ID", PAYMENT_ID);
		parameters.put("PARAM_USER_NAME", USER_NAME);
		
		return parameters;
	}

}
