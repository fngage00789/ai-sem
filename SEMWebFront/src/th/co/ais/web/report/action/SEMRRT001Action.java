package th.co.ais.web.report.action;

import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
//import org.jboss.remoting.transport.web.WebUtil;

import th.co.ais.rpt.parameter.SEMRRT001ReportParameter;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.util.ELovType;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMRRT001Bean;
import th.co.ais.web.util.SemUtils;

public class SEMRRT001Action extends AbstractReportAction{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7410440438777216616L;
	private Logger log = Logger.getLogger(getClass());
	private SEMRRT001Bean semrrt001Bean;
	
	public SEMRRT001Bean getSemrrt001Bean() {
		return (SEMRRT001Bean) getFacesUtils().getSessionMapValue("semrrt001Bean");
	}

	public void setSemrrt001Bean(SEMRRT001Bean semrrt001Bean) {
		getFacesUtils().setSessionMapValue("semrrt001Bean", semrrt001Bean);
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
		
		semrrt001Bean = new SEMRRT001Bean();
		semrrt001Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semrrt001Bean.setRegionList(getRegionItems());
		semrrt001Bean.setStationTypeList(getLovItemsByType(ELovType.T_SI_SITE_TYPE.name, EX_AND, "RT", null, null));
		semrrt001Bean.setYear(DateUtil.getCurrentYearTH());
		setSemrrt001Bean(semrrt001Bean);
	}
		
	@Override
	public boolean validate() {
		boolean flgValid = true;
		
		if (StringUtils.isEmpty(getSemrrt001Bean().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		
		if (StringUtils.isEmpty(getSemrrt001Bean().getYear())) {
			addMessageError("W0001", msg("message.year"));
			flgValid = false;
		}else if(!SemUtils.chkYearTH(getSemrrt001Bean().getYear())){
			addMessageError("W0099",msg("message.year"));
			flgValid = false;
		}
		
		return flgValid;
	}
	

	@Override
	public void clearReport() {
		// TODO Auto-generated method stub
		super.clearSessionBean();
		getSemrrt001Bean().clearReportSimple();
		
		getSemrrt001Bean().setCompany(null);
		getSemrrt001Bean().setYear(DateUtil.getCurrentYearTH());
		getSemrrt001Bean().setRegion(null);
		getSemrrt001Bean().setStationType(null);
		getSemrrt001Bean().setPico(false);
		
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
		// TODO Auto-generated method stub
		semrrt001Bean = getSemrrt001Bean();
		SEMRRT001ReportParameter param = null;
		List<SelectItem> s = null;
		if (validate()) {
			try {
				param = new SEMRRT001ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrrt001Bean.getCompany()));
				param.setP_company(semrrt001Bean.getCompany());
				if(StringUtils.isNotEmpty(semrrt001Bean.getRegion())){
					param.setP_region(semrrt001Bean.getRegion());
				}
				param.setP_year(DateUtil.convertYearTH2YearEN(semrrt001Bean.getYear()));
				param.setP_display_year(semrrt001Bean.getYear());
				if(StringUtils.isNotEmpty(semrrt001Bean.getStationType())){
					param.setP_station_type(semrrt001Bean.getStationType());
				}
				if(StringUtils.isNotEmpty(semrrt001Bean.getStationType())){
					s = th.co.ais.web.util.WebUtil.getSelectItemByValue(semrrt001Bean.getStationType(), semrrt001Bean.getStationTypeList());
					if(s != null){
						param.setP_display_station_type(s.get(0).getLabel());
					}
				}
				param.setP_username(getUserLogIn());
				param.setP_pico(semrrt001Bean.isPico()?"Y":"N");
//				WebUtil.getContentType(param);
				super.runReport("SEMRRT001", param, 
						semrrt001Bean.getReportType(), semrrt001Bean.getRunType(), 
						semrrt001Bean.getBatchType(), semrrt001Bean.getJobSchedule());
			
			} catch (Exception e) {
				log.error("RUN REPORT ERROR IN " + getClass() +  " : " + e);
				e.printStackTrace();
			} finally{
				param = null;
			}
		}
	}

	@Override
	public void showReport() {
		// TODO Auto-generated method stub
		super.showReport("SEMRRT001", getSemrrt001Bean().getReportType());
	}
	
}
