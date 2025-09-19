package th.co.ais.rpt.parameter;

import java.io.Serializable;
import java.util.Map;

//import th.co.ais.rpt.service.ServiceConstants;

public abstract class ReportParameter implements Serializable {
	public Map parameters = null;
//	public static final String REPORT_ENGINE_JASPER = "Jasper";
	public String reportEngine = "Jasper";
	public abstract Map getReportParameter();
	
	public String getReportEngine() {
		return reportEngine;
	}

	public void setReportEngine(String reportEngine) {
		this.reportEngine = reportEngine;
	}
	
}
