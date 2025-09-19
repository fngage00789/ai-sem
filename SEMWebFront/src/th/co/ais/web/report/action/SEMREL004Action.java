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

import th.co.ais.rpt.parameter.SEMREL004ReportParameter;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.util.BeanUtils;
import th.co.ais.util.ELovType;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMREL004Bean;
import th.co.ais.web.report.util.ReportDateUtil;
import th.co.ais.web.util.ELUtils;
import th.co.ais.web.util.LOVCacheUtil;

public class SEMREL004Action extends AbstractReportAction{
	
	private static final long serialVersionUID = -7410440438777216616L;
	private Logger LOG = Logger.getLogger(getClass());
	SEMREL004Bean semrel004Bean;
	private static String REPORT_ID = "SEMREL004";
	private static String SESSION_BEAN_NAME = "semrel004Bean";	
	private static final ResourceBundle RS_BUNDLE 	= ResourceBundle.getBundle("resources.report.semrel004");
	
	public SEMREL004Bean getSemrel004Bean() {
		SEMREL004Bean semrel004Bean = (SEMREL004Bean) getFacesUtils().getSessionMapValue(SESSION_BEAN_NAME);
		if(null==semrel004Bean){
			semrel004Bean = new SEMREL004Bean();
		}
		return semrel004Bean;
	}

	public void setSemrel004Bean(SEMREL004Bean semrel004Bean) {
		getFacesUtils().setSessionMapValue(SESSION_BEAN_NAME, semrel004Bean);
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
		LOG.info("STRAT Action init()");
		//LOG.info("ReportDateUtil.getDDLYearTh():"+ ReportDateUtil.getDDLYearTh());
		
		semrel004Bean = new SEMREL004Bean();
		semrel004Bean.setCompanyList(getCompanyItemsAll());
		semrel004Bean.setYearList(ReportDateUtil.getDDLYearTh());
		semrel004Bean.setElectricUseTypeList(ELUtils.filterLOVByLOVValue("R", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name)));
		semrel004Bean.setByTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_BY_TYPE.name));
		semrel004Bean.setYear(DateUtil.getCurrentYear() + "");
		setSemrel004Bean(semrel004Bean);
	}
		
	@Override
	public boolean validate() {
		boolean flgValid = true;
		semrel004Bean = getSemrel004Bean();
		if(StringUtils.isEmpty(semrel004Bean.getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		if(StringUtils.isEmpty(semrel004Bean.getYear())) {
			addMessageError("W0001", getErrorMessage("label.year"));
			flgValid = false;
		}
		if(StringUtils.isEmpty(semrel004Bean.getElectricUseType())) {
			addMessageError("W0001", getErrorMessage("label.electricUseType"));
			flgValid = false;
		}
		
		return flgValid;
	}
	

	@Override
	public void clearReport() {
		// TODO Auto-generated method stub
		super.clearSessionBean();
		
		//semrel004Bean = new SEMREL004Bean();
		init();
		semrel004Bean.clearReportSimple();
		setSemrel004Bean(semrel004Bean);
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		// TODO Auto-generated method stub
		super.enableBatchType("semrrt004Bean");
	}

	@Override
	public void resetReportDate() {
		// TODO Auto-generated method stub
		super.resetReportDate("semrrt004Bean");
	}

	@Override
	public void runReport() {
		LOG.info("START Action runReport");
		semrel004Bean = getSemrel004Bean();
		SEMREL004ReportParameter param = null;
		if (validate()) {
			try {
				param = new SEMREL004ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrel004Bean.getCompany()));
				param.setP_company(semrel004Bean.getCompany());
				SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy", new Locale("en", "EN"));

				String dateIn = "01/01/"+semrel004Bean.getYear()+"";
				Date dateParam;
				try{
					dateParam = dateformat.parse(dateIn);
				}catch(Exception ex){
					dateParam = new Date();
					ex.printStackTrace();
				}
				param.setP_year(dateParam);
				param.setP_yearDisplay(semrel004Bean.getYear());
				param.setP_electricUseType(semrel004Bean.getElectricUseType());
				param.setP_electricUseTypeDisplay(ELUtils.getLOVNameByLOVCode(semrel004Bean.getElectricUseTypeList(), semrel004Bean.getElectricUseType()));
				param.setP_byType(semrel004Bean.getByType());
				//param.setReportEngine(reportEngine);
				LOG.debug("WT###Report parameter="+BeanUtils.getBeanString(param));
//				WebUtil.getContentType(param);
				super.runReport(REPORT_ID, param, 
						semrel004Bean.getReportType(), semrel004Bean.getRunType(), 
						semrel004Bean.getBatchType(), semrel004Bean.getJobSchedule());
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
		super.showReport(REPORT_ID, getSemrel004Bean().getReportType());
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
		ssList.add(new SelectItem("2", ">3 เดือน"));
		ssList.add(new SelectItem("3", ">6 เดือน"));
		ssList.add(new SelectItem("4", ">12 เดือน"));
	
		return ssList;
	}

}
