package th.co.ais.web.report.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
//import org.jboss.remoting.transport.web.WebUtil;

import th.co.ais.rpt.parameter.SEMREL002ReportParameter;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.util.BeanUtils;
import th.co.ais.util.ELovType;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMREL002Bean;
import th.co.ais.web.report.util.ReportDateUtil;
import th.co.ais.web.util.ELUtils;
import th.co.ais.web.util.LOVCacheUtil;

public class SEMREL002Action extends AbstractReportAction{
	
	private static final long serialVersionUID = -7410440438777216616L;
	private Logger LOG = Logger.getLogger(getClass());
	SEMREL002Bean semrel002Bean;
	private static String REPORT_ID = "SEMREL002";
	private static String SESSION_BEAN_NAME = "semrel002Bean";	
	private static final ResourceBundle RS_BUNDLE 	= ResourceBundle.getBundle("resources.report.semrel002");
	
	public SEMREL002Bean getSemrel002Bean() {
		SEMREL002Bean semrel002Bean = (SEMREL002Bean) getFacesUtils().getSessionMapValue(SESSION_BEAN_NAME);
		if(null==semrel002Bean){
			semrel002Bean = new SEMREL002Bean();
		}
		return semrel002Bean;
	}

	public void setSemrel002Bean(SEMREL002Bean semrel002Bean) {
		getFacesUtils().setSessionMapValue(SESSION_BEAN_NAME, semrel002Bean);
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
		
		semrel002Bean = new SEMREL002Bean();
		semrel002Bean.setCompanyList(getCompanyItemsAll());
		semrel002Bean.setElectricUseTypeList(ELUtils.filterLOVByLOVValue("R", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE2.name)));
		semrel002Bean.setRegionList(getRegionItems());
		semrel002Bean.setMonthList(ReportDateUtil.getDDLMonthTH());
		semrel002Bean.setYearList(ReportDateUtil.getDDLYearTh());
		semrel002Bean.setMonth(DateUtil.getCurrentMonth()+1+"");
		semrel002Bean.setYear(DateUtil.getCurrentYear() + "");
		setSemrel002Bean(semrel002Bean);
	}
		
	@Override
	public boolean validate() {
		boolean flgValid = true;
		semrel002Bean = getSemrel002Bean();
		if (StringUtils.isEmpty(semrel002Bean.getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		if (StringUtils.isEmpty(semrel002Bean.getElectricUseType())) {
			addMessageError("W0001", getErrorMessage("label.electricUseType"));
			flgValid = false;
		}
		if (StringUtils.isEmpty(semrel002Bean.getRegion())) {
			addMessageError("W0001", msg("message.region"));
			flgValid = false;
		}
		if (StringUtils.isEmpty(semrel002Bean.getMonth())) {
			addMessageError("W0001", msg("message.month"));
			flgValid = false;
		}
		if (StringUtils.isEmpty(semrel002Bean.getYear())) {
			addMessageError("W0001", msg("message.year"));
			flgValid = false;
		}
		
		return flgValid;
	}
	

	@Override
	public void clearReport() {
		// TODO Auto-generated method stub
		super.clearSessionBean();
		
		//semrel002Bean = new SEMREL002Bean();
		init();
		semrel002Bean.clearReportSimple();
		setSemrel002Bean(semrel002Bean);
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		// TODO Auto-generated method stub
		super.enableBatchType("semrrt001Bean");
	}

	@Override
	public void resetReportDate() {
		// TODO Auto-generated method stub
		super.resetReportDate("semrrt001Bean");
	}

	@Override
	public void runReport() {
		LOG.info("START Action runReport");
		semrel002Bean = getSemrel002Bean();
		SEMREL002ReportParameter param = null;
		if (validate()) {
			try {
				param = new SEMREL002ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrel002Bean.getCompany()));
				param.setP_company(semrel002Bean.getCompany());
				param.setP_electricUseType(semrel002Bean.getElectricUseType());
				param.setP_electricUseTypeDisplay(ELUtils.getLOVNameByLOVCode(semrel002Bean.getElectricUseTypeList() , semrel002Bean.getElectricUseType()));
				param.setP_region(semrel002Bean.getRegion());
				param.setP_month(semrel002Bean.getMonth());
				param.setP_year(semrel002Bean.getYear());
				SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy", new Locale("en", "EN"));

				String dateIn = "01/"+semrel002Bean.getMonth()+"/"+semrel002Bean.getYear()+"";
				Date dateParam;
				try{
					dateParam = dateformat.parse(dateIn);
				}catch(Exception ex){
					dateParam = new Date();
					ex.printStackTrace();
				}
				param.setP_date(dateParam);
				//param.setReportEngine(reportEngine);
				LOG.debug("WT###Report parameter="+BeanUtils.getBeanString(param));
//				WebUtil.getContentType(param);
				super.runReport(REPORT_ID, param, 
						semrel002Bean.getReportType(), semrel002Bean.getRunType(), 
						semrel002Bean.getBatchType(), semrel002Bean.getJobSchedule());
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
		super.showReport(REPORT_ID, getSemrel002Bean().getReportType());
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

}
