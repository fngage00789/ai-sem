package th.co.ais.rpt.parameter;

import java.util.HashMap;
import java.util.Map;

public class SEMMCO004ReportParameter extends ReportParameter {
	
	private String lessorSiteInfoId;
	
	public String getLessorSiteInfoId() {
		return lessorSiteInfoId;
	}

	public void setLessorSiteInfoId(String lessorSiteInfoId) {
		this.lessorSiteInfoId = lessorSiteInfoId;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map getReportParameter() {
		parameters = new HashMap();	
		parameters.put("PARAM_REPORT_ENGINE", reportEngine);
		parameters.put("PARAM_LESSOR_SITE_ONFO_ID", lessorSiteInfoId);
		
		return parameters;
	}

}
