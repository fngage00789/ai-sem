package th.co.ais.web.report.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
//import org.jboss.remoting.transport.web.WebUtil;

import th.co.ais.rpt.parameter.SEMREL001ReportParameter;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.util.BeanUtils;
import th.co.ais.util.ELovType;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMREL001Bean;
import th.co.ais.web.report.util.ReportDateUtil;
import th.co.ais.web.util.ELUtils;
import th.co.ais.web.util.LOVCacheUtil;

public class SEMREL001Action extends AbstractReportAction{
	
	private static final long serialVersionUID = -7410440438777216616L;
	private Logger LOG = Logger.getLogger(getClass());
	SEMREL001Bean semrel001Bean;
	private static String REPORT_ID = "SEMREL001";
	private static String SESSION_BEAN_NAME = "semrel001Bean";	
	private static final ResourceBundle RS_BUNDLE 	= ResourceBundle.getBundle("resources.report.semrel001");
	
	public SEMREL001Bean getSemrel001Bean() {
		SEMREL001Bean semrel001Bean = (SEMREL001Bean) getFacesUtils().getSessionMapValue(SESSION_BEAN_NAME);
		if(null==semrel001Bean){
			semrel001Bean = new SEMREL001Bean();
		}
		return semrel001Bean;
	}

	public void setSemrel001Bean(SEMREL001Bean semrel001Bean) {
		getFacesUtils().setSessionMapValue(SESSION_BEAN_NAME, semrel001Bean);
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
		
		semrel001Bean = new SEMREL001Bean();
		semrel001Bean.setCompanyList(getCompanyItemsAll());
		semrel001Bean.setElectricUseTypeList(ELUtils.filterLOVByLOVValue("R", LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ELECTRIC_TYPE.name)));
		semrel001Bean.setRegionList(getRegionItems());
		semrel001Bean.setMonthList(ReportDateUtil.getDDLMonthTH());
		semrel001Bean.setYearList(ReportDateUtil.getDDLYearTh());
		semrel001Bean.setMonth(DateUtil.getCurrentMonth()+1+"");
		semrel001Bean.setYear(DateUtil.getCurrentYear() + "");
		semrel001Bean.setWarrantTypeList(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_EL_WARRANT_TYPE.name));
		semrel001Bean.setMeterDataList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_METER_DATA.name));
		semrel001Bean.setOnServiceList(LOVCacheUtil.getInstance().getByLOVType(ELovType.EL_ON_SERVICE.name));
		semrel001Bean.setPeriodList(getDDLQuater());
		
		SelectItem tmp = new SelectItem();
		tmp.setLabel(getErrorMessage("list.electrict_use_type"));
		tmp.setValue("MEA/PEA");
		semrel001Bean.getElectricUseTypeList().add(tmp);
		
		//semrel001Bean.getWarrantTypeList().remove(1);
		List<SelectItem> selListReturn = new ArrayList<SelectItem>();
		for(SelectItem temptmp: semrel001Bean.getWarrantTypeList()){
					
			//String desc = temptmp.getLabel();
			//System.out.println(" Match LOVCODE:LABEL>>"+temptmp.getValue()+":"+temptmp.getLabel());
			if(temptmp.getValue().toString().equalsIgnoreCase("ALL")){
				//semrel001Bean.getWarrantTypeList().remove(temptmp);
			}else{
				selListReturn.add(temptmp);	
			}
		
		}
		semrel001Bean.setWarrantTypeList(selListReturn);
		
		setSemrel001Bean(semrel001Bean);
	}
		
	@Override
	public boolean validate() {
		boolean flgValid = true;
		semrel001Bean = getSemrel001Bean();
		if(StringUtils.isEmpty(semrel001Bean.getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		if(StringUtils.isEmpty(semrel001Bean.getElectricUseType())) {
			addMessageError("W0001", getErrorMessage("label.electricUseType"));
			flgValid = false;
		}	
		if(StringUtils.isEmpty(semrel001Bean.getWarrantType())) {
			addMessageError("W0001", getErrorMessage("label.warrantType"));
			flgValid = false;
		}
		if(StringUtils.isEmpty(semrel001Bean.getMeterData())) {
			addMessageError("W0001", getErrorMessage("label.meterData"));
			flgValid = false;
		}
		/*
		if(StringUtils.isEmpty(semrel001Bean.getOnService())) {
			addMessageError("W0001", getErrorMessage("label.onServiceDt"));
			flgValid = false;
		}
		*/
		if(StringUtils.isEmpty(semrel001Bean.getNumMonthType())) {
			addMessageError("W0001", getErrorMessage("label.numMonth"));
			flgValid = false;
			
		}else{
			if(semrel001Bean.getNumMonthType().equalsIgnoreCase("M")){
				if(StringUtils.isEmpty(semrel001Bean.getMonth())) {
					addMessageError("W0001", getErrorMessage("label.month"));
					flgValid = false;	
				}
				if(StringUtils.isEmpty(semrel001Bean.getYear())) {
					addMessageError("W0001", getErrorMessage("label.year"));
					flgValid = false;	
				}
			}else{
				if(StringUtils.isEmpty(semrel001Bean.getPeriod())) {
					addMessageError("W0001", getErrorMessage("label.byPeriod"));
					flgValid = false;	
				}
			}
			
		}
		
		
		return flgValid;
	}
	

	@Override
	public void clearReport() {
		// TODO Auto-generated method stub
		super.clearSessionBean();
		
		//semrel001Bean = new SEMREL001Bean();
		init();
		semrel001Bean.clearReportSimple();
		setSemrel001Bean(semrel001Bean);
		
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
		semrel001Bean = getSemrel001Bean();
		SEMREL001ReportParameter param = null;
		if (validate()) {
			try {
				param = new SEMREL001ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrel001Bean.getCompany()));
				param.setP_company(semrel001Bean.getCompany());
				param.setP_region(semrel001Bean.getRegion());
				param.setP_electricUseType(semrel001Bean.getElectricUseType());
				param.setP_meterReqType(semrel001Bean.getWarrantType());
				param.setP_meterData(semrel001Bean.getMeterData());
				param.setP_onService(semrel001Bean.getOnService());
				
				if("M".equals(semrel001Bean.getNumMonthType())){
					SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy", new Locale("en", "EN"));
					String dateIn = "01/"+semrel001Bean.getMonth()+"/"+semrel001Bean.getYear()+"";
					int yearInt = Integer.parseInt(semrel001Bean.getYear())+543;
					//543
					String dateTH = "01/"+semrel001Bean.getMonth()+"/"+new Integer(yearInt)+"";
					Date dateParam;
					try{
						dateParam = dateformat.parse(dateIn);
					}catch(Exception ex){
						dateParam = new Date();
						ex.printStackTrace();
					}
					param.setP_month(dateParam);
					param.setP_monthDisplay(dateTH);
					param.setP_date(dateParam);
					param.setP_year(semrel001Bean.getYear());
					
					
				}else{
					param.setP_period(semrel001Bean.getPeriod());
					param.setP_monthDisplay(ELUtils.getLOVNameByLOVCode(semrel001Bean.getPeriodList(), semrel001Bean.getPeriod()));
				}
				param.setP_monthType(semrel001Bean.getNumMonthType());
				param.setP_electricUseTypeDisplay(ELUtils.getLOVNameByLOVCode(semrel001Bean.getElectricUseTypeList(), semrel001Bean.getElectricUseType()));
				param.setP_meterReqTypeDisplay(ELUtils.getLOVNameByLOVCode(semrel001Bean.getWarrantTypeList(), semrel001Bean.getWarrantType()));
				param.setP_companyDisplay(ELUtils.getLOVNameByLOVCode(semrel001Bean.getCompanyList(), semrel001Bean.getCompany()));
				
				LOG.debug("WT###Report parameter="+BeanUtils.getBeanString(param));
//				WebUtil.getContentType(param);
				super.runReport(REPORT_ID, param, 
						semrel001Bean.getReportType(), semrel001Bean.getRunType(), 
						semrel001Bean.getBatchType(), semrel001Bean.getJobSchedule());
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
		super.showReport(REPORT_ID, getSemrel001Bean().getReportType());
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
