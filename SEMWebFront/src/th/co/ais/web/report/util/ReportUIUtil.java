package th.co.ais.web.report.util;

import java.lang.reflect.Method;
import java.util.Date;

import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

public class ReportUIUtil {
	public static Logger logger = Logger.getLogger(ReportUIUtil.class);
	
	public static void enableBatchType(String formBeanName, String runTypeMethod, String batchTypeMethod, 
			String jobScheduleMethod, String displayjobScheduleMethod, String disabledRdoBatchImmediateMethod, 
			String disabledRdoBatchRunAt, String displayBatchTime){ // Online Batch
		
		Object objBean = null;
		Method getRunTypeMethod = null;
		Method setBatchTypeMethod = null;
		Method setJobScheduleMethod = null;
		Method setdisplayjobScheduleMethod = null;
		Method setDisabledRdoBatchImmediateMethod = null;
		Method setDisabledRdoBatchRunAt = null;
		Method setDisplayBatchTime = null;
		Class argumentType [] = null;
		Date tmpDate = null;
		
		try {
			objBean = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(formBeanName);

			argumentType  = new Class[3];   // set argument to pass to Function
			argumentType[0] = String.class;
			argumentType[1] = Date.class;
			argumentType[2] = boolean.class;
			
			getRunTypeMethod = objBean.getClass().getMethod(runTypeMethod, null);
			setBatchTypeMethod = objBean.getClass().getMethod(batchTypeMethod, argumentType[0]);
			setJobScheduleMethod = objBean.getClass().getMethod(jobScheduleMethod, argumentType[1]);
			setdisplayjobScheduleMethod = objBean.getClass().getMethod(displayjobScheduleMethod, argumentType[2]);
			setJobScheduleMethod.invoke(objBean, tmpDate);
			setDisabledRdoBatchImmediateMethod = objBean.getClass().getMethod(disabledRdoBatchImmediateMethod,argumentType[0]);
			setDisabledRdoBatchRunAt = objBean.getClass().getMethod(disabledRdoBatchRunAt, argumentType[0]);
			setDisplayBatchTime = objBean.getClass().getMethod(displayBatchTime, argumentType[2]);

			if(((String)getRunTypeMethod.invoke(objBean, null)).equals("web")){ //disable all batch run online
				setDisabledRdoBatchImmediateMethod.invoke(objBean, "true");
				setDisabledRdoBatchRunAt.invoke(objBean, "true");
				setBatchTypeMethod.invoke(objBean, "");
				setdisplayjobScheduleMethod.invoke(objBean, false);
				setDisplayBatchTime.invoke(objBean, false);
				
			}else{ //click batch
				setDisabledRdoBatchImmediateMethod.invoke(objBean, "false");
				setDisabledRdoBatchRunAt.invoke(objBean, "false");
				setBatchTypeMethod.invoke(objBean, "1");
				setdisplayjobScheduleMethod.invoke(objBean, false);
				setDisplayBatchTime.invoke(objBean, true);
			}
		} catch (Exception e) {
			logger.error("ERROR IN ReportUIUtil.enableBatchType : "+e);
			e.printStackTrace();
		} finally{
			objBean = null;
			getRunTypeMethod = null;
			setBatchTypeMethod = null;
			setJobScheduleMethod = null;
			setdisplayjobScheduleMethod = null;
			setDisabledRdoBatchImmediateMethod = null;
			setDisabledRdoBatchRunAt = null;
			argumentType = null;
			tmpDate = null;
		}		
	}
	
	public static void resetReportDate(String formBeanName, String batchTypeMethod, String jobScheduleMethod, String displayjobScheduleMethod){  //click Immediately  ,Run at 
		
		Object objBean = null;
		Method getBatchTypeMethod = null;
		Method setJobScheduleMethod = null;
		Method setDisplayJobScheduleMethod = null;
		Date tmpDate = null;
		
		try {
			objBean = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(formBeanName);
			
			getBatchTypeMethod = objBean.getClass().getMethod(batchTypeMethod, null);
			
			setJobScheduleMethod = objBean.getClass().getMethod(jobScheduleMethod, Date.class);
			
			setDisplayJobScheduleMethod = objBean.getClass().getMethod(displayjobScheduleMethod, boolean.class);
			
			if(((String)getBatchTypeMethod.invoke(objBean, null) ).equals("1")){
				setJobScheduleMethod.invoke(objBean, tmpDate);
				setDisplayJobScheduleMethod.invoke(objBean,false);
			}else{ // select run batch at
				setDisplayJobScheduleMethod.invoke(objBean,true);
			}
		} catch (Exception e) {
			logger.error("ERROR IN ReportUIUtil.resetReportDate : "+e);
			e.printStackTrace();
		}finally{
			objBean = null;
			getBatchTypeMethod = null;
			setJobScheduleMethod = null;
			tmpDate = null;						
		}		
	}
}
