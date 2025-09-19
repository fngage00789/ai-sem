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

import th.co.ais.rpt.parameter.SEMREL005ReportParameter;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.util.BeanUtils;
import th.co.ais.util.ELovType;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMREL005Bean;
import th.co.ais.web.report.util.ReportDateUtil;
import th.co.ais.web.util.ELUtils;
import th.co.ais.web.util.LOVCacheUtil;

public class SEMREL005Action extends AbstractReportAction{
	
	private static final long serialVersionUID = -7410440438777216616L;
	private Logger LOG = Logger.getLogger(getClass());
	SEMREL005Bean semrel005Bean;
	private static String REPORT_ID_MEA_PEA = "SEMREL005-1";
	private static String REPORT_ID_PRIVATE = "SEMREL005-2";
	private static String SESSION_BEAN_NAME = "semrel005Bean";	
	private static final ResourceBundle RS_BUNDLE 	= ResourceBundle.getBundle("resources.report.semrel005");
	
	public SEMREL005Bean getSemrel005Bean() {
		SEMREL005Bean semrel005Bean = (SEMREL005Bean) getFacesUtils().getSessionMapValue(SESSION_BEAN_NAME);
		if(null==semrel005Bean){
			semrel005Bean = new SEMREL005Bean();
		}
		return semrel005Bean;
	}

	public void setSemrel005Bean(SEMREL005Bean semrel005Bean) {
		getFacesUtils().setSessionMapValue(SESSION_BEAN_NAME, semrel005Bean);
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
		
		semrel005Bean = new SEMREL005Bean();
		semrel005Bean.setCompanyList(getCompanyItemsAll());
		semrel005Bean.setElectricUseTypeList(ELUtils.filterLOVByLOVValue("R", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name)));
		semrel005Bean.setRegionList(getRegionItems());
		semrel005Bean.setYearList(ReportDateUtil.getDDLYearTh());
		semrel005Bean.setYear(DateUtil.getCurrentYear() + "");
		semrel005Bean.setSiteStatusList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_SI_SITE_STATUS.name));
		
		setSemrel005Bean(semrel005Bean);
	}
		
	@Override
	public boolean validate() {
		boolean flgValid = true;
		semrel005Bean = getSemrel005Bean();
		
		if(StringUtils.isEmpty(semrel005Bean.getRegion())) {
			semrel005Bean.setRegion("ALL");	
		}	
		
		if(StringUtils.isEmpty(semrel005Bean.getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		
		if(StringUtils.isEmpty(semrel005Bean.getRegion())) {
			addMessageError("W0001", getErrorMessage("label.region"));
			flgValid = false;
		}	
		
		if(StringUtils.isEmpty(semrel005Bean.getYear())) {
			addMessageError("W0001", getErrorMessage("label.year"));
			flgValid = false;
		}
		if(StringUtils.isEmpty(semrel005Bean.getElectricUseType())) {
			addMessageError("W0001", getErrorMessage("label.electricUseType"));
			flgValid = false;
		}
		
		return flgValid;
	}
	

	@Override
	public void clearReport() {
		// TODO Auto-generated method stub
		super.clearSessionBean();
		
		//semrel005Bean = new SEMREL005Bean();
		init();
		semrel005Bean.clearReportSimple();
		setSemrel005Bean(semrel005Bean);
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		// TODO Auto-generated method stub
		super.enableBatchType("semrrt005Bean");
	}

	@Override
	public void resetReportDate() {
		// TODO Auto-generated method stub
		super.resetReportDate("semrrt005Bean");
	}

	@Override
	public void runReport() {
		LOG.info("START Action runReport");
		semrel005Bean = getSemrel005Bean();
		SEMREL005ReportParameter param = null;
		if (validate()) {
			try {
				param = new SEMREL005ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrel005Bean.getCompany()));
				param.setP_company(semrel005Bean.getCompany());
				param.setP_electricUseType(semrel005Bean.getElectricUseType());
				param.setP_region(semrel005Bean.getRegion());				
				param.setP_electricUseTypeDisplay(ELUtils.getLOVNameByLOVCode(semrel005Bean.getElectricUseTypeList(), semrel005Bean.getElectricUseType()));
				param.setP_siteStatus(semrel005Bean.getSiteStatus());
				
				SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy", new Locale("en", "EN"));

				String dateIn = "01/01/"+semrel005Bean.getYear()+"";
				Date dateParam;
				try{
					dateParam = dateformat.parse(dateIn);
				}catch(Exception ex){
					dateParam = new Date();
					ex.printStackTrace();
				}
				LOG.info("<<<<< semrel005Bean.getYear(): >>>>>"+ semrel005Bean.getYear() );
				LOG.info("<<<<< Year: >>>>>"+ dateParam );
				
				
				//param.setP_date(dateParam);
				param.setP_year(dateParam);
				param.setP_yearDisplay(semrel005Bean.getYear());
				//param.setReportEngine(reportEngine);
				LOG.debug("WT###Report parameter="+BeanUtils.getBeanString(param));
//				WebUtil.getContentType(param);
				if(ELUtils.ELECTRIC_TYPE_PRIVATE.equals(semrel005Bean.getElectricUseType())){
					super.runReport(REPORT_ID_PRIVATE, param, 
							semrel005Bean.getReportType(), semrel005Bean.getRunType(), 
							semrel005Bean.getBatchType(), semrel005Bean.getJobSchedule());
				}else{
					super.runReport(REPORT_ID_MEA_PEA, param, 
							semrel005Bean.getReportType(), semrel005Bean.getRunType(), 
							semrel005Bean.getBatchType(), semrel005Bean.getJobSchedule());
				}
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
		semrel005Bean = getSemrel005Bean();
		if(ELUtils.ELECTRIC_TYPE_PRIVATE.equals(semrel005Bean.getElectricUseType())){
			super.showReport(REPORT_ID_PRIVATE, getSemrel005Bean().getReportType());
		}else{
			super.showReport(REPORT_ID_MEA_PEA, getSemrel005Bean().getReportType());
		}
		
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
