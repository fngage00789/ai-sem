package th.co.ais.rpt.parameter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Warawit Kitmongkonsak
 * 
 */
public class SEMMIR008ReportParameter extends ReportParameter {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4966565200855117162L;
	//Criteria For Jsp Input Parameters
	private String draftNo;
	private String userName;

	
	public String getDraftNo() {
		return draftNo;
	}

	public void setDraftNo(String draftNo) {
		this.draftNo = draftNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map getReportParameter() {
		parameters = new HashMap();	
		parameters.put("PARAM_REPORT_ENGINE", reportEngine);
		parameters.put("PARAM_DRAFT_NO", draftNo);
		parameters.put("PARAM_user_name", userName);
		
		return parameters;
	}

}
