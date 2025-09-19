package th.co.ais.web.report.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
//import org.jboss.remoting.transport.web.WebUtil;

import th.co.ais.rpt.parameter.SEMREL006ReportParameter;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.util.BeanUtils;
import th.co.ais.util.ELovType;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMREL006Bean;
import th.co.ais.web.report.util.ReportDateUtil;
import th.co.ais.web.util.ELUtils;
import th.co.ais.web.util.LOVCacheUtil;

public class SEMREL006Action extends AbstractReportAction{
	
	private static final long serialVersionUID = -7410440438777216616L;
	private Logger LOG = Logger.getLogger(getClass());
	SEMREL006Bean semrel006Bean;
	private static String REPORT_ID = "SEMREL006";
	private static String SESSION_BEAN_NAME = "semrel006Bean";	
	private static final ResourceBundle RS_BUNDLE 	= ResourceBundle.getBundle("resources.report.semrel006");
	
	public SEMREL006Bean getSemrel006Bean() {
		SEMREL006Bean semrel006Bean = (SEMREL006Bean) getFacesUtils().getSessionMapValue(SESSION_BEAN_NAME);
		if(null==semrel006Bean){
			semrel006Bean = new SEMREL006Bean();
		}
		return semrel006Bean;
	}

	public void setSemrel006Bean(SEMREL006Bean semrel006Bean) {
		getFacesUtils().setSessionMapValue(SESSION_BEAN_NAME, semrel006Bean);
	}

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		
		if(methodWithNavi.equalsIgnoreCase("doRunReport")){
			runReport();
		} else if (methodWithNavi.equalsIgnoreCase("doShowReport")) {
			showReport();
		} else if (methodWithNavi.equalsIgnoreCase("doClearReport")) {
			clearReport();
		}
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		super.clearSessionBean();
		
		semrel006Bean = new SEMREL006Bean();
		semrel006Bean.setCompanyList(getCompanyItemsAll());
		semrel006Bean.setElectricUseTypeList(ELUtils.filterLOVByLOVValue("R", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name)));
		setSemrel006Bean(semrel006Bean);
	}
		
	@Override
	public boolean validate() {
		boolean flgValid = true;
		semrel006Bean = getSemrel006Bean();
		if(StringUtils.isEmpty(semrel006Bean.getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		if(StringUtils.isEmpty(semrel006Bean.getElectricUseType())) {
			addMessageError("W0001", getErrorMessage("label.electricUseType"));
			flgValid = false;
		}
		/*
		if(StringUtils.isEmpty(semrel006Bean.getExpenseType())) {
			addMessageError("W0001", getErrorMessage("label.expenseType"));
			flgValid = false;
		}*/
		
		return flgValid;
	}
	

	@Override
	public void clearReport() {
		// TODO Auto-generated method stub
		super.clearSessionBean();
		
		semrel006Bean = new SEMREL006Bean();
		semrel006Bean.clearReportSimple();
		setSemrel006Bean(semrel006Bean);
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		// TODO Auto-generated method stub
		super.enableBatchType("semrrt006Bean");
	}

	@Override
	public void resetReportDate() {
		// TODO Auto-generated method stub
		super.resetReportDate("semrrt006Bean");
	}

	@Override
	public void runReport() {
		LOG.info("START Action runReport");
		semrel006Bean = getSemrel006Bean();
		SEMREL006ReportParameter param = null;
		if (validate()) {
			try {
				param = new SEMREL006ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrel006Bean.getCompany()));
				param.setP_company(semrel006Bean.getCompany());
				param.setP_electricUseType(semrel006Bean.getElectricUseType());
				param.setP_electricUseTypeDisplay(ELUtils.getLOVNameByLOVCode(semrel006Bean.getElectricUseTypeList(), semrel006Bean.getElectricUseType()));
				param.setP_inType(semrel006Bean.getExpenseType());
				param.setP_yearCurrentDisplay(DateUtil.getCurrentYear()+"");
				param.setP_yearPrepaidDisplay((DateUtil.getCurrentYear()+1)+"");
				param.setP_yearPreviousDisplay((DateUtil.getCurrentYear()-1)+"");
				
				//LOG.debug("WT###Report parameter="+BeanUtils.getBeanString(param));
//				WebUtil.getContentType(param);
				super.runReport(REPORT_ID, param, 
						semrel006Bean.getReportType(), semrel006Bean.getRunType(), 
						semrel006Bean.getBatchType(), semrel006Bean.getJobSchedule());
				LOG.info("END Action runReport");
			
			} catch (Exception e) {
				LOG.error("RUN REPORT ERROR IN " + getClass() +  " : " + e);
				e.printStackTrace();
			} finally{
				param = null;
			}
		}
	}

	@Override
	public void showReport() {
		// TODO Auto-generated method stub
		super.showReport(REPORT_ID, getSemrel006Bean().getReportType());
	}
	
	private String getMessage(String key) {
		return RS_BUNDLE.getString(key);
	}
	
	private String getErrorMessage(String key) {
		String msg = this.getMessage(key);
		if(msg != null){
			msg = msg.replaceAll(":", "");
		}else{
			msg = "Properties key[" +key+ "] not found.";
		}
		return msg;
	}
	
	private List<SelectItem> getDDLQuater(){
		List<SelectItem> ssList = new ArrayList<SelectItem>();
		ssList.add(new SelectItem("1", ">1 เดือน"));
		ssList.add(new SelectItem("3", ">3 เดือน"));
		ssList.add(new SelectItem("6", ">6 เดือน"));
		ssList.add(new SelectItem("12", ">12 เดือน"));
	
		return ssList;
	}

}
