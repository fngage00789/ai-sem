package th.co.ais.web.report.action;

import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
//import org.jboss.remoting.transport.web.WebUtil;

import th.co.ais.rpt.parameter.SEMRRT002ReportParameter;
import th.co.ais.util.ELovType;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMRRT002Bean;
import th.co.ais.web.util.SemUtils;

public class SEMRRT002Action extends AbstractReportAction{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7410440438777216616L;
	private Logger log = Logger.getLogger(getClass());
	private SEMRRT002Bean semrrt002Bean;
	
	public SEMRRT002Bean getSemrrt002Bean() {
		return (SEMRRT002Bean) getFacesUtils().getSessionMapValue("semrrt002Bean");
	}

	public void setSemrrt002Bean(SEMRRT002Bean semrrt002Bean) {
		getFacesUtils().setSessionMapValue("semrrt002Bean", semrrt002Bean);
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
		
		semrrt002Bean = new SEMRRT002Bean();
		semrrt002Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semrrt002Bean.setRegionList(getRegionItems());
		semrrt002Bean.setStationTypeList(getLovItemsByType(ELovType.T_SI_SITE_TYPE.name, EX_AND, "RT", null, null));
		setSemrrt002Bean(semrrt002Bean);
	}
		
	@Override
	public boolean validate() {
		boolean flgValid = true;
		
		if (StringUtils.isEmpty(getSemrrt002Bean().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		
		if(StringUtils.isNotEmpty(getSemrrt002Bean().getMonthYear())){
			log.debug("getSemrrt002Bean().getMonthYear()" + getSemrrt002Bean().getMonthYear());
			String msgError = SemUtils.chkMonthYearFormat(getSemrrt002Bean().getMonthYear());
			if(msgError!=null){
				addMessageError("W0102", msg("message.monthYearEnLbl")+" ("+msg(msgError)+") ");
				flgValid = false;
			}
		}
		
		return flgValid;
	}
	

	@Override
	public void clearReport() {
		// TODO Auto-generated method stub
		super.clearSessionBean();
		getSemrrt002Bean().clearReportSimple();
		
		getSemrrt002Bean().setCompany(null);
		getSemrrt002Bean().setRegion(null);
		getSemrrt002Bean().setMonthYear(null);
		getSemrrt002Bean().setStationType(null);
		getSemrrt002Bean().setPico(false);
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		// TODO Auto-generated method stub
		super.enableBatchType("semrrt002Bean");
	}

	@Override
	public void resetReportDate() {
		// TODO Auto-generated method stub
		super.resetReportDate("semrrt002Bean");
	}

	@Override
	public void runReport() {
		// TODO Auto-generated method stub
		semrrt002Bean = getSemrrt002Bean();
		SEMRRT002ReportParameter param = null;
		List<SelectItem> s = null;
		if (validate()) {
			try {
				param = new SEMRRT002ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrrt002Bean.getCompany()));
				param.setP_company(semrrt002Bean.getCompany());
				param.setP_region(getSemrrt002Bean().getRegion());
				if(StringUtils.isNotEmpty(getSemrrt002Bean().getMonthYear())){
					param.setP_month_year(SemUtils.convertMonthYearTH2MonthYearEN(getSemrrt002Bean().getMonthYear()));
				}
				param.setP_display_month_year(getSemrrt002Bean().getMonthYear());
				if(StringUtils.isNotEmpty(semrrt002Bean.getStationType())){
					s = th.co.ais.web.util.WebUtil.getSelectItemByValue(semrrt002Bean.getStationType(), semrrt002Bean.getStationTypeList());
					if(s != null){
						param.setP_display_station_type(s.get(0).getLabel());
					}
				}
				
				param.setP_pico(getSemrrt002Bean().isPico()?"Y":"N");
				param.setP_username(getUserLogIn());

//				WebUtil.getContentType(param);
				
				super.runReport("SEMRRT002", param, 
						semrrt002Bean.getReportType(), semrrt002Bean.getRunType(), 
						semrrt002Bean.getBatchType(), semrrt002Bean.getJobSchedule());
			
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
		super.showReport("SEMRRT002", getSemrrt002Bean().getReportType());
	}
	
}
