package th.co.ais.rpt.parameter;

import java.util.HashMap;
import java.util.Map;

//import th.co.ais.domain.sa.Msa003ReportParam;

public class SEMMCP002ReportParameter extends ReportParameter{

	private static final long serialVersionUID = 3217981861847267845L;
	
	private String CONTRACT_ID;
	private String CONTRACT_TYPE;
	private String UPDATE_BY;
	
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
		parameters.put("PARAM_UPDATE_BY", UPDATE_BY);
		
		return parameters;
	}

	public String getUPDATE_BY() {
		return UPDATE_BY;
	}

	public void setUPDATE_BY(String uPDATEBY) {
		UPDATE_BY = uPDATEBY;
	}

}
