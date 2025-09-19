package th.co.ais.rpt.batch.quartz;

public interface IJobConditionLauncher {
	public boolean canRunJob();
	public String getParameterForRunJob();
}
