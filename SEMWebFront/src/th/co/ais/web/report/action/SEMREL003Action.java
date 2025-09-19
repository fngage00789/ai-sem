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

import th.co.ais.rpt.parameter.SEMREL003ReportParameter;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.util.BeanUtils;
import th.co.ais.util.ELovType;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMREL003Bean;
import th.co.ais.web.report.util.ReportDateUtil;
import th.co.ais.web.util.ELUtils;
import th.co.ais.web.util.LOVCacheUtil;

public class SEMREL003Action extends AbstractReportAction{
	
	private static final long serialVersionUID = -7410440438777216616L;
	private Logger LOG = Logger.getLogger(getClass());
	SEMREL003Bean semrel003Bean;
	private static String REPORT_ID = "SEMREL003";
	private static String SESSION_BEAN_NAME = "semrel003Bean";	
	private static final ResourceBundle RS_BUNDLE 	= ResourceBundle.getBundle("resources.report.semrel003");
	
	public SEMREL003Bean getSemrel003Bean() {
		SEMREL003Bean semrel003Bean = (SEMREL003Bean) getFacesUtils().getSessionMapValue(SESSION_BEAN_NAME);
		if(null==semrel003Bean){
			semrel003Bean = new SEMREL003Bean();
		}
		return semrel003Bean;
	}

	public void setSemrel003Bean(SEMREL003Bean semrel003Bean) {
		getFacesUtils().setSessionMapValue(SESSION_BEAN_NAME, semrel003Bean);
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
		
		semrel003Bean = new SEMREL003Bean();
		semrel003Bean.setCompanyList(getCompanyItemsAll());
		semrel003Bean.setElectricUseTypeList(ELUtils.filterLOVByLOVValue("R", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name)));
		semrel003Bean.setYearList(ReportDateUtil.getDDLYearTh());
		semrel003Bean.setYear(DateUtil.getCurrentYear() + "");
		setSemrel003Bean(semrel003Bean);
	}
		
	@Override
	public boolean validate() {
		boolean flgValid = true;
		semrel003Bean = getSemrel003Bean();
		if(StringUtils.isEmpty(semrel003Bean.getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		if(StringUtils.isEmpty(semrel003Bean.getYear())) {
			addMessageError("W0001", getErrorMessage("label.year"));
			flgValid = false;
		}
		if(StringUtils.isEmpty(semrel003Bean.getElectricUseType())) {
			addMessageError("W0001", getErrorMessage("label.electricUseType"));
			flgValid = false;
		}
		
		return flgValid;
	}
	

	@Override
	public void clearReport() {
		// TODO Auto-generated method stub
		super.clearSessionBean();
		
		//semrel003Bean = new SEMREL003Bean();
		init();
		semrel003Bean.clearReportSimple();
		setSemrel003Bean(semrel003Bean);
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		// TODO Auto-generated method stub
		super.enableBatchType("semrrt003Bean");
	}

	@Override
	public void resetReportDate() {
		// TODO Auto-generated method stub
		super.resetReportDate("semrrt003Bean");
	}

	@Override
	public void runReport() {
		LOG.info("START Action runReport");
		semrel003Bean = getSemrel003Bean();
		SEMREL003ReportParameter param = null;
		if (validate()) {
			try {
				param = new SEMREL003ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrel003Bean.getCompany()));
				param.setP_company(semrel003Bean.getCompany());
				SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy", new Locale("en", "EN"));

				String dateIn = "01/01/"+semrel003Bean.getYear()+"";
				Date dateParam;
				try{
					dateParam = dateformat.parse(dateIn);
				}catch(Exception ex){
					dateParam = new Date();
					ex.printStackTrace();
				}
				param.setP_year(dateParam);
				param.setP_electricUseType(semrel003Bean.getElectricUseType());
				param.setP_electricTypeDisplay(ELUtils.getLOVNameByLOVCode(semrel003Bean.getElectricUseTypeList(), semrel003Bean.getElectricUseType()));				
				LOG.debug("WT###Report parameter="+BeanUtils.getBeanString(param));
//				WebUtil.getContentType(param);
				super.runReport(REPORT_ID, param, 
						semrel003Bean.getReportType(), semrel003Bean.getRunType(), 
						semrel003Bean.getBatchType(), semrel003Bean.getJobSchedule());
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
		super.showReport(REPORT_ID, getSemrel003Bean().getReportType());
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
