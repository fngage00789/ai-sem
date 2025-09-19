package th.co.ais.rpt.batch.jmx;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;

public class ReportJMX implements IReportJMX {
	private Map<String,Date> jobIdMap;
	
	
	public ReportJMX() {
		jobIdMap = new HashMap<String,Date>();
	}


	public Map getCurrentJobId() {
		return jobIdMap;
	}

	public void addCurrentJobId(String jobId) {
		jobIdMap.put(jobId, new Date());		
	}


	public void removeCurrentJobId(String jobId) {
		if(jobIdMap.containsKey(jobId)){
			jobIdMap.remove(jobId);
		}		
	}


	public void updateCurrentJobId() {
		
	}

}
