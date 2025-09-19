package th.co.ais.web.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzSchedulerGC extends GenericServlet {

	public void init(ServletConfig config) throws ServletException {

		super.init(config);

		Scheduler sched;
		try {
			
			// Clear GC Every minute
			long intervalTime = 1 * 60 * 1000;
			
			sched = StdSchedulerFactory.getDefaultScheduler();
			sched.start();
			
			JobDetail job = new JobDetail("System Clear GC", "GC Job Group", QuartzJobGC.class, true, true, true);
			
			SimpleTrigger trigger = new SimpleTrigger("System Clear GC Trigger", "GC Trigger Group");
			trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
			trigger.setRepeatInterval(intervalTime);
			
			sched.scheduleJob(job, trigger);
			
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {

	}
}
