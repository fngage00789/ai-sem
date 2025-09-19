package th.co.ais.web.servlet;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class QuartzJobGC implements Job {
	
	private static final Logger logger = Logger.getLogger(QuartzJobGC.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		logger.info("Executing Quartz Job to System Clear GC");
		
		try {
			System.gc();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}