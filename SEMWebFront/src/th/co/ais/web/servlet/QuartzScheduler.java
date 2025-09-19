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

public class QuartzScheduler extends GenericServlet {

	public void init(ServletConfig config) throws ServletException {

		super.init(config);

		Scheduler sched;
		try {
			
			long intervalTime = 12 * 60 * 1000;
					
			sched = StdSchedulerFactory.getDefaultScheduler();
			sched.start();
			
//			JobDetail job = JobBuilder.newJob(QuartzJob.class).withIdentity("QuartzJob").build();
			JobDetail job = new JobDetail("Reactivate SSO Job", "SSO Job Group", QuartzJob.class, true, true, true);
//			ScheduleBuilder scheduleBuilder = SimpleScheduleBuilder
//					.simpleSchedule().withIntervalInSeconds(10).repeatForever();
//			Trigger trigger = TriggerBuilder.newTrigger()
//					.withIdentity("QuartzTrigger")
//					.withSchedule(scheduleBuilder).startNow().build();

			SimpleTrigger trigger = new SimpleTrigger("Reactivate SSO Trigger", "SSO Trigger Group");
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
