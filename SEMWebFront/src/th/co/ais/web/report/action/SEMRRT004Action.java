package th.co.ais.web.report.action;

import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
//import org.jboss.remoting.transport.web.WebUtil;

import th.co.ais.rpt.parameter.SEMRRT004ReportParameter;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.util.ELovType;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMRRT004Bean;
import th.co.ais.web.util.SemUtils;

public class SEMRRT004Action extends AbstractReportAction{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1848534662413378308L;
	private Logger log = Logger.getLogger(getClass());
	private SEMRRT004Bean semrrt004Bean;
	
	public SEMRRT004Bean getSemrrt004Bean() {
		return (SEMRRT004Bean) getFacesUtils().getSessionMapValue("semrrt004Bean");
	}

	public void setSemrrt004Bean(SEMRRT004Bean semrrt004Bean) {
		getFacesUtils().setSessionMapValue("semrrt004Bean", semrrt004Bean);
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
		
		semrrt004Bean = new SEMRRT004Bean();
		semrrt004Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semrrt004Bean.setRegionList(getRegionItems());
		semrrt004Bean.setStationTypeList(getLovItemsByType(ELovType.T_SI_SITE_TYPE.name, EX_AND, "RT", null, null));
		semrrt004Bean.setYear(DateUtil.getCurrentYearTH());
		setSemrrt004Bean(semrrt004Bean);
	}
		
	@Override
	public boolean validate() {
		boolean flgValid = true;
		
		if (StringUtils.isEmpty(getSemrrt004Bean().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		
		if (StringUtils.isEmpty(getSemrrt004Bean().getYear())) {
			addMessageError("W0001", msg("message.year"));
			flgValid = false;
		}else if(!SemUtils.chkYearTH(getSemrrt004Bean().getYear())){
			addMessageError("W0099",msg("message.year"));
			flgValid = false;
		}
		
		return flgValid;
	}
	

	@Override
	public void clearReport() {
		// TODO Auto-generated method stub
		super.clearSessionBean();
		getSemrrt004Bean().clearReportSimple();
		
		getSemrrt004Bean().setCompany(null);
		getSemrrt004Bean().setYear(DateUtil.getCurrentYearTH());
		getSemrrt004Bean().setRegion(null);
		getSemrrt004Bean().setStationType(null);
		getSemrrt004Bean().setPico(false);
		
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
		// TODO Auto-generated method stub
		semrrt004Bean = getSemrrt004Bean();
		SEMRRT004ReportParameter param = null;
		List<SelectItem> s = null;
		if (validate()) {
			try {
				param = new SEMRRT004ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrrt004Bean.getCompany()));
				param.setP_company(semrrt004Bean.getCompany());
				param.setP_region(semrrt004Bean.getRegion());
				param.setP_year(DateUtil.convertYearTH2YearEN(semrrt004Bean.getYear()));
				param.setP_display_year(semrrt004Bean.getYear());
				param.setP_station_type(semrrt004Bean.getStationType());
				if(StringUtils.isNotEmpty(semrrt004Bean.getStationType())){
					s = th.co.ais.web.util.WebUtil.getSelectItemByValue(semrrt004Bean.getStationType(), semrrt004Bean.getStationTypeList());
					if(s != null){
						param.setP_display_station_type(s.get(0).getLabel());
					}
				}
				param.setP_transfer_flag(semrrt004Bean.isTransferFlag() ? "Y" : "N");
				param.setP_pico(semrrt004Bean.isPico()?"Y":"N");
				param.setP_username(getUserLogIn());
//				WebUtil.getContentType(param);
				super.runReport("SEMRRT004", param, 
						semrrt004Bean.getReportType(), semrrt004Bean.getRunType(), 
						semrrt004Bean.getBatchType(), semrrt004Bean.getJobSchedule());
			
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
		super.showReport("SEMRRT004", getSemrrt004Bean().getReportType());
	}
	
}
