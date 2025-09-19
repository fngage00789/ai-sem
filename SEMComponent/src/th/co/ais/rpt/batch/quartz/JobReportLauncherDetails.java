/*
 * Copyright 2006-2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package th.co.ais.rpt.batch.quartz;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import th.co.ais.rpt.batch.jmx.IReportJMX;
import th.co.ais.rpt.domain.ReportJob;
import th.co.ais.rpt.exception.ReportServiceException;
import th.co.ais.rpt.parameter.ReportParameter;
import th.co.ais.rpt.service.IReportJobService;
import th.co.ais.rpt.service.IReportMailService;
import th.co.ais.rpt.service.IReportServiceHelper;
import th.co.ais.rpt.service.ServiceConstants;




/**
 * @author Dave Syer
 * 
 */
public class JobReportLauncherDetails extends QuartzJobBean {// implements StatefulJob{

	/**
	 * Special key in job data map for the name of a job to run.
	 */
	static final String JOB_NAME = "jobName";
	public static final String REPORT_JOB_ID = "REPORT_JOB_ID";
	public static final String JOB_FILE_NAME = "JOB_FILE_NAME";

	private static Log log = LogFactory.getLog(JobReportLauncherDetails.class);

	private IJobConditionLauncher jobConditionLauncher;
	
	private IReportJobService reportJobService;
	private IReportServiceHelper reportServiceHelper;
	private IReportJMX reportJMX;
	private IReportMailService reportMailService;
	
	public void setReportJMX(IReportJMX reportJMX) {
		this.reportJMX = reportJMX;
	}

	public void setReportServiceHelper(IReportServiceHelper reportServiceHelper) {
		this.reportServiceHelper = reportServiceHelper;
	}
	
	public void setReportJobService(IReportJobService reportJobService) {
		this.reportJobService = reportJobService;
	}
	
	public void setReportMailService(IReportMailService reportMailService) {
		this.reportMailService = reportMailService;
	}	
		
	private int noParamLimit = 0;
	
	private static int counterNoParamLimit = 0;
	
	private static int counterHaveParam = 0;
	
	public void setNoParamLimit(int noParamLimit) {
		this.noParamLimit = noParamLimit;
	}

	public void setJobConditionLauncher(IJobConditionLauncher jobConditionLauncher) {
		this.jobConditionLauncher = jobConditionLauncher;
	}

	protected void executeInternal(JobExecutionContext context) {
			String param = null;
			try {
				synchronized (JobReportLauncherDetails.class) {
					param = jobConditionLauncher.getParameterForRunJob();	
					if(noParamLimit>0){
						if(param!=null){
							counterNoParamLimit = 0;
							counterHaveParam++;
						}else{
							if(counterHaveParam>0){
								counterNoParamLimit++;	
							}							
						}
						if(counterNoParamLimit>=noParamLimit){
							System.exit(1);
						}
					}
				}					
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(param!=null){
				log.info("Quartz trigger firing with Spring Batch jobName="+param);
				try {
					execute(param);	
				} catch (Exception e) {
					log.error(e);
				}				
				log.info("Complete jobName = "+param);
			}else{
				log.info("No Report to Run");	
			}
	}
	
	public void execute(String job_id) throws Exception {
		
		boolean successFlag = false;
		ReportJob reportJob = null;
		String filePath = null;
		String errorMessage = null;
		String preErrorMessage = null;
		ReportParameter reportParameter = null;
		
		try {
			reportJMX.addCurrentJobId(job_id);
		
			preErrorMessage = "Error Get Report Info!";
			reportJob = reportJobService.getReportJob(job_id);
			preErrorMessage = "Error Export With Jasper Service!";
			
//			try {
//				Thread.sleep(20 * 1000L);
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
			
			filePath = reportServiceHelper.export(reportJob.getReportTypeId(), reportJob.getReportParam(), reportJob.getReportExportType(), reportJob.getReportExportFilePath());
			
			if(filePath!=null && filePath.length() > 0){
				preErrorMessage = "Error Update File Path!";
				successFlag = true;
			}
		} catch (Exception e) {
			successFlag = false;
			if(e instanceof ReportServiceException){
				errorMessage = e.getMessage();
			}else{
				errorMessage = e.getMessage();
				throw e;
			}			
		} finally {
			if(errorMessage==null||(errorMessage!=null && errorMessage.trim().length()==0)){
				errorMessage = preErrorMessage;
			}
			afterExecute(job_id, successFlag, errorMessage, filePath);	
			//send email
			if(successFlag && reportJob!=null){
				reportMailService.sendMail(reportJob.getReportTypeId(), filePath);	
			}			
		}

	}

	public void afterExecute(String job_id, boolean successFlag, String errorMessage, String filePath){
		try {
			if(errorMessage!=null && errorMessage.trim().length()>50){
				errorMessage = errorMessage.substring(0,49);
			}
			reportJMX.removeCurrentJobId(job_id);
			reportJobService.updateEndRunReport(job_id, successFlag, errorMessage, filePath);	

		} catch (Exception e) {
			e.printStackTrace();
		} 
	}


}
