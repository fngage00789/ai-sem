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

import th.co.ais.rpt.parameter.SEMREL007ReportParameter;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.util.BeanUtils;
import th.co.ais.util.ELovType;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMREL007Bean;
import th.co.ais.web.report.util.ReportDateUtil;
import th.co.ais.web.util.ELUtils;
import th.co.ais.web.util.LOVCacheUtil;

public class SEMREL007Action extends AbstractReportAction{
	
	private static final long serialVersionUID = -7410440438777216616L;
	private Logger LOG = Logger.getLogger(getClass());
	SEMREL007Bean semrel007Bean;
	private static String REPORT_ID = "SEMREL007";
	private static String SESSION_BEAN_NAME = "semrel007Bean";	
	private static final ResourceBundle RS_BUNDLE 	= ResourceBundle.getBundle("resources.report.semrel007");
	
	public SEMREL007Bean getSemrel007Bean() {
		SEMREL007Bean semrel007Bean = (SEMREL007Bean) getFacesUtils().getSessionMapValue(SESSION_BEAN_NAME);
		if(null==semrel007Bean){
			semrel007Bean = new SEMREL007Bean();
		}
		return semrel007Bean;
	}

	public void setSemrel007Bean(SEMREL007Bean semrel007Bean) {
		getFacesUtils().setSessionMapValue(SESSION_BEAN_NAME, semrel007Bean);
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
		
		semrel007Bean = new SEMREL007Bean();
		semrel007Bean.setCompanyList(getCompanyItemsAll());
		semrel007Bean.setRegionList(getRegionItems());
		semrel007Bean.setYearList(ReportDateUtil.getDDLYearTh());
		semrel007Bean.setYear(DateUtil.getCurrentYear() + "");
		semrel007Bean.setElectricUseTypeList(ELUtils.filterLOVByLOVValue("R", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name)));
		semrel007Bean.setSiteStatusList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_SI_SITE_STATUS.name));
		
		setSemrel007Bean(semrel007Bean);
	}
		
	@Override
	public boolean validate() {
		boolean flgValid = true;
		semrel007Bean = getSemrel007Bean();
		if(!semrel007Bean.isGroupBylocation()){
			if(StringUtils.isEmpty(semrel007Bean.getCompany())) {
				addMessageError("W0001", msg("message.company"));
				flgValid = false;
			}
		}
//		if(StringUtils.isEmpty(semrel007Bean.getRegion())) {
//			addMessageError("W0001", getErrorMessage("label.region"));
//			flgValid = false;
//		}
		if(StringUtils.isEmpty(semrel007Bean.getYear())) {
			addMessageError("W0001", getErrorMessage("label.year"));
			flgValid = false;
		}
		if(StringUtils.isEmpty(semrel007Bean.getElectricUseType())) {
			addMessageError("W0001", getErrorMessage("label.electricUseType"));
			flgValid = false;
		}
		
		
		return flgValid;
	}
	

	@Override
	public void clearReport() {
		// TODO Auto-generated method stub
		super.clearSessionBean();
		
		//semrel007Bean = new SEMREL007Bean();
		init();
		semrel007Bean.clearReportSimple();
		setSemrel007Bean(semrel007Bean);
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		// TODO Auto-generated method stub
		super.enableBatchType("semrrt007Bean");
	}

	@Override
	public void resetReportDate() {
		// TODO Auto-generated method stub
		super.resetReportDate("semrrt007Bean");
	}

	@Override
	public void runReport() {
		LOG.info("START Action runReport");
		semrel007Bean = getSemrel007Bean();
		SEMREL007ReportParameter param = null;
		if (validate()) {
			try {
				param = new SEMREL007ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrel007Bean.getCompany()));
				param.setP_company(semrel007Bean.getCompany());
				param.setP_electricUseType(semrel007Bean.getElectricUseType());
				param.setP_region(semrel007Bean.getRegion());
				SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy", new Locale("en", "EN"));

				String dateIn = "01/01/"+semrel007Bean.getYear();
				Date dateParam;
				try{
					dateParam = dateformat.parse(dateIn);
				}catch(Exception ex){
					dateParam = new Date();
					ex.printStackTrace();
				}
				param.setP_year(dateParam);
				param.setP_electricUseTypeDisplay(ELUtils.getLOVNameByLOVCode(semrel007Bean.getElectricUseTypeList(), semrel007Bean.getElectricUseType()));
				param.setP_companyDisplay(semrel007Bean.getCompany());
				param.setP_regionDisplay(semrel007Bean.getRegion());
				param.setP_yearDisplay(semrel007Bean.getYear());
				param.setP_siteStatus(semrel007Bean.getSiteStatus());
				if(semrel007Bean.isGroupBylocation()){
					param.setP_in_group_location("Y");
				}else{
					param.setP_in_group_location("N");
				}
				
				//param.setReportEngine(reportEngine);
				LOG.debug("WT###Report parameter="+BeanUtils.getBeanString(param));
//				WebUtil.getContentType(param);
				super.runReport(REPORT_ID, param, 
						semrel007Bean.getReportType(), semrel007Bean.getRunType(), 
						semrel007Bean.getBatchType(), semrel007Bean.getJobSchedule());
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
		super.showReport(REPORT_ID, getSemrel007Bean().getReportType());
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
