package th.co.ais.rpt.batch.jmx;

import java.util.Map;

public interface IReportJMX {
	public Map getCurrentJobId();
	public void addCurrentJobId(String jobId);
	public void removeCurrentJobId(String jobId);
	public void updateCurrentJobId();
}
