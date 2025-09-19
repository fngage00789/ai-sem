package th.co.ais.rpt.batch.quartz;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import th.co.ais.rpt.batch.jmx.IReportJMX;
import th.co.ais.rpt.service.IReportJobService;




/**
 * @author Dave Syer
 * 
 */
public class JobMonitorLauncherDetails extends QuartzJobBean {// implements StatefulJob{

	private static Log log = LogFactory.getLog(JobMonitorLauncherDetails.class);
	private IReportJMX proxyReportJMX;
	private String serverName;
	private String reportOverTimeMinutes;
	private IReportJobService reportJobService;
	
	public void setReportOverTimeMinutes(String reportOverTimeMinutes) {
		this.reportOverTimeMinutes = reportOverTimeMinutes;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	
	public void setProxyReportJMX(IReportJMX proxyReportJMX) {
		this.proxyReportJMX = proxyReportJMX;
	}

	public void setReportJobService(IReportJobService reportJobService) {
		this.reportJobService = reportJobService;
	}

	protected void executeInternal(JobExecutionContext context) {
		try{
			log.info("++++++++++++++++++++++ JobMonitorLauncherDetails.executeInternal ++++++++++++++++++++");
			if(proxyReportJMX!=null && proxyReportJMX.getCurrentJobId()!=null && proxyReportJMX.getCurrentJobId().size()>0){
				log.info("Data of " + serverName + " is " + proxyReportJMX.getCurrentJobId());
			}else{
				log.info("No Data In " + serverName);
			}
			reportJobService.clearFailJob(serverName, reportOverTimeMinutes, proxyReportJMX);
		}catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
		}
	}
	
}
