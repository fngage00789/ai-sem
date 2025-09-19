package th.co.ais.web.report.action;

import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
//import org.jboss.remoting.transport.web.WebUtil;

import th.co.ais.rpt.parameter.SEMRRT003ReportParameter;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.util.ELovType;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMRRT003Bean;
import th.co.ais.web.util.SemUtils;

public class SEMRRT003Action extends AbstractReportAction{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7410440438777216616L;
	private Logger log = Logger.getLogger(getClass());
	private SEMRRT003Bean semrrt003Bean;
	
	public SEMRRT003Bean getSemrrt003Bean() {
		return (SEMRRT003Bean) getFacesUtils().getSessionMapValue("semrrt003Bean");
	}

	public void setSemrrt003Bean(SEMRRT003Bean semrrt003Bean) {
		getFacesUtils().setSessionMapValue("semrrt003Bean", semrrt003Bean);
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
		
		semrrt003Bean = new SEMRRT003Bean();
		semrrt003Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semrrt003Bean.setRegionList(getRegionItems());
		semrrt003Bean.setStationTypeList(getLovItemsByType(ELovType.T_SI_SITE_TYPE.name, EX_AND, "RT", null, null));
		semrrt003Bean.setYear(DateUtil.getCurrentYearTH());
		setSemrrt003Bean(semrrt003Bean);
	}
		
	@Override
	public boolean validate() {
		boolean flgValid = true;
		
		if (StringUtils.isEmpty(getSemrrt003Bean().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		
		if (StringUtils.isEmpty(getSemrrt003Bean().getYear())) {
			addMessageError("W0001", msg("message.year"));
			flgValid = false;
		}else if(!SemUtils.chkYearTH(getSemrrt003Bean().getYear())){
			addMessageError("W0099",msg("message.year"));
			flgValid = false;
		}
		
		return flgValid;
	}
	

	@Override
	public void clearReport() {
		// TODO Auto-generated method stub
		super.clearSessionBean();
		getSemrrt003Bean().clearReportSimple();
		
		getSemrrt003Bean().setCompany(null);
		getSemrrt003Bean().setRegion(null);
		getSemrrt003Bean().setYear(DateUtil.getCurrentYearTH());
		getSemrrt003Bean().setStationType(null);
		getSemrrt003Bean().setPico(false);
		
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
		// TODO Auto-generated method stub
		semrrt003Bean = getSemrrt003Bean();
		SEMRRT003ReportParameter param = null;
		List<SelectItem> s = null;
		if (validate()) {
			try {
				param = new SEMRRT003ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrrt003Bean.getCompany()));
				param.setP_company(semrrt003Bean.getCompany());
				if(StringUtils.isNotEmpty(semrrt003Bean.getRegion())){
					param.setP_region(semrrt003Bean.getRegion());
				}
				param.setP_display_year(semrrt003Bean.getYear());
				param.setP_year(DateUtil.convertYearTH2YearEN(semrrt003Bean.getYear()));
				if(StringUtils.isNotEmpty(semrrt003Bean.getStationType())){
					param.setP_station_type(semrrt003Bean.getStationType());
				}
				if(StringUtils.isNotEmpty(semrrt003Bean.getStationType())){
					s = th.co.ais.web.util.WebUtil.getSelectItemByValue(semrrt003Bean.getStationType(), semrrt003Bean.getStationTypeList());
					if(s != null){
						param.setP_display_station_type(s.get(0).getLabel());
					}
				}
				param.setP_username(getUserLogIn());
				param.setP_pico(semrrt003Bean.isPico()?"Y":"N");
//				WebUtil.getContentType(param);
				super.runReport("SEMRRT003", param, 
						semrrt003Bean.getReportType(), semrrt003Bean.getRunType(), 
						semrrt003Bean.getBatchType(), semrrt003Bean.getJobSchedule());
			
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
		super.showReport("SEMRRT003", getSemrrt003Bean().getReportType());
	}
	
}
