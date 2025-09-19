package th.co.ais.web.report.action;

import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
//import org.jboss.remoting.transport.web.WebUtil;

import th.co.ais.rpt.parameter.SEMRSI002ReportParameter;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.util.ELovType;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMRSI002Bean;
import th.co.ais.web.util.SemUtils;

public class SEMRSI002Action extends AbstractReportAction {
	private static final long serialVersionUID = -7410440438777216616L;
	private Logger log = Logger.getLogger(getClass());
	private SEMRSI002Bean semrsi002Bean;

	public SEMRSI002Bean getSemrsi002Bean() {
		return (SEMRSI002Bean) getFacesUtils().getSessionMapValue(
				"semrsi002Bean");
	}

	public void setSemrsi002Bean(SEMRSI002Bean semrsi002Bean) {
		getFacesUtils().setSessionMapValue("semrsi002Bean", semrsi002Bean);
	}

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;

		if (methodWithNavi.equalsIgnoreCase("doRunReport")) {
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

		semrsi002Bean = new SEMRSI002Bean();
		semrsi002Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		
		semrsi002Bean.setProcessFromList(getLovItemsByType("RPT_SLA_STEP"));
		semrsi002Bean.setProcessToList(getLovItemsByType("RPT_SLA_STEP"));
		semrsi002Bean.setSlaTypeList(getLovItemsByType("RPT_SITE_APPROVE_TYPE"));
		semrsi002Bean.setYear(DateUtil.getCurrentYearTH());
		setSemrsi002Bean(semrsi002Bean);
	}

	@Override
	public boolean validate() {
		boolean flgValid = true;

		if (StringUtils.isEmpty(getSemrsi002Bean().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		if (StringUtils.isEmpty(getSemrsi002Bean().getYear())) {
			addMessageError("W0001", msg("message.year"));
			flgValid = false;
		}else if(!SemUtils.chkYearTH(getSemrsi002Bean().getYear())){
			addMessageError("W0099",msg("message.year"));
			flgValid = false;
		}
		
		if (StringUtils.isEmpty(getSemrsi002Bean().getProcessFrom())) {
			addMessageError("W0001", msg("message.slaProcessFrom"));
			flgValid = false;
		}
		
		if (StringUtils.isEmpty(getSemrsi002Bean().getProcessTo())) {
			addMessageError("W0001", msg("message.slaProcessTo"));
			flgValid = false;
		}
		
		if (StringUtils.isEmpty(getSemrsi002Bean().getSlaType())) {
			addMessageError("W0001", msg("message.slaType"));
			flgValid = false;
		}
		
		

		return flgValid;
	}

	@Override
	public void clearReport() {
		// TODO Auto-generated method stub
		super.clearSessionBean();

		semrsi002Bean = new SEMRSI002Bean();
		semrsi002Bean.clearReportSimple();
		
        semrsi002Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semrsi002Bean.setProcessFromList(getLovItemsByType("RPT_SLA_STEP"));
		semrsi002Bean.setProcessToList(getLovItemsByType("RPT_SLA_STEP"));
		semrsi002Bean.setSlaTypeList(getLovItemsByType("RPT_SITE_APPROVE_TYPE"));
		semrsi002Bean.setYear(DateUtil.getCurrentYearTH());
		
		setSemrsi002Bean(semrsi002Bean);

		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		// TODO Auto-generated method stub
		super.enableBatchType("semrsi002Bean");
	}

	@Override
	public void resetReportDate() {
		// TODO Auto-generated method stub
		super.resetReportDate("semrsi002Bean");
	}

	@Override
	public void runReport() {
		// TODO Auto-generated method stub
		semrsi002Bean = getSemrsi002Bean();
		SEMRSI002ReportParameter param = null;
		List<SelectItem> s = null;
		if (validate()) {
			try {
				param = new SEMRSI002ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrsi002Bean
						.getCompany()));
				param.setP_company(semrsi002Bean.getCompany());
				param.setP_year(DateUtil.convertYearTH2YearEN(semrsi002Bean.getYear()));
				param.setP_display_year(semrsi002Bean.getYear());
				param.setP_process_from(semrsi002Bean.getProcessFrom());
				if(StringUtils.isNotEmpty(semrsi002Bean.getProcessFrom())){
					s =  th.co.ais.web.util.WebUtil.getSelectItemByValue(semrsi002Bean.getProcessFrom(), semrsi002Bean.getProcessFromList());
					if(s != null){
						param.setP_display_process_from(s.get(0).getLabel());
					}
				}
				
				param.setP_process_to(semrsi002Bean.getProcessTo());
				if(StringUtils.isNotEmpty(semrsi002Bean.getProcessTo())){
					s =  th.co.ais.web.util.WebUtil.getSelectItemByValue(semrsi002Bean.getProcessTo(), semrsi002Bean.getProcessToList());
					if(s != null){
						param.setP_display_process_to(s.get(0).getLabel());
					}
				}
				
				param.setP_sla_type(semrsi002Bean.getSlaType());
				if(StringUtils.isNotEmpty(semrsi002Bean.getSlaType())){
					s =  th.co.ais.web.util.WebUtil.getSelectItemByValue(semrsi002Bean.getSlaType(), semrsi002Bean.getSlaTypeList());
					if(s != null){
						param.setP_display_sla_type(s.get(0).getLabel());
					}
				}
				
				param.setP_username(getUserLogIn());
//				WebUtil.getContentType(param);
				super.runReport("SEMRSI002", param, semrsi002Bean
						.getReportType(), semrsi002Bean.getRunType(),
						semrsi002Bean.getBatchType(), semrsi002Bean
								.getJobSchedule());

			} catch (Exception e) {
				log.error("RUN REPORT ERROR IN " + getClass() + " : " + e);
				e.printStackTrace();
			} finally {
				param = null;
			}
		}
	}

	@Override
	public void showReport() {
		// TODO Auto-generated method stub
		super.showReport("SEMRSI002", getSemrsi002Bean().getReportType());
	}
}
