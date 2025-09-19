package th.co.ais.web.report.action;

import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
//import org.jboss.remoting.transport.web.WebUtil;

import th.co.ais.rpt.parameter.SEMRSI001ReportParameter;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.util.ELovType;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMRSI001Bean;
import th.co.ais.web.util.SemUtils;

public class SEMRSI001Action extends AbstractReportAction {
	private static final long serialVersionUID = -7410440438777216616L;
	private Logger log = Logger.getLogger(getClass());
	private SEMRSI001Bean semrsi001Bean;

	public SEMRSI001Bean getSemrsi001Bean() {
		return (SEMRSI001Bean) getFacesUtils().getSessionMapValue(
				"semrsi001Bean");
	}

	public void setSemrir001Bean(SEMRSI001Bean semrsi001Bean) {
		getFacesUtils().setSessionMapValue("semrsi001Bean", semrsi001Bean);
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

		semrsi001Bean = new SEMRSI001Bean();
		semrsi001Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semrsi001Bean.setYear(DateUtil.getCurrentYearTH());
		semrsi001Bean.setTypeList(getLovItemsByType(ELovType.T_SI_SITE_APPROVE_TYPE.name));
		setSemrir001Bean(semrsi001Bean);
	}

	@Override
	public boolean validate() {
		boolean flgValid = true;

		if (StringUtils.isEmpty(getSemrsi001Bean().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		if (StringUtils.isEmpty(getSemrsi001Bean().getYear())) {
			addMessageError("W0001", msg("message.year"));
			flgValid = false;
		}else if(!SemUtils.chkYearTH(getSemrsi001Bean().getYear())){
			addMessageError("W0099",msg("message.year"));
			flgValid = false;
		}
		if (StringUtils.isEmpty(getSemrsi001Bean().getType())) {
			addMessageError("W0001", msg("message.networkType"));
			flgValid = false;
		}
		
		

		return flgValid;
	}

	@Override
	public void clearReport() {
		// TODO Auto-generated method stub
		super.clearSessionBean();
		getSemrsi001Bean().clearReportSimple();
		
		getSemrsi001Bean().setCompany(null);
		getSemrsi001Bean().setYear(DateUtil.getCurrentYearTH());
		getSemrsi001Bean().setType(null);
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		// TODO Auto-generated method stub
		super.enableBatchType("semrsi001Bean");
	}

	@Override
	public void resetReportDate() {
		// TODO Auto-generated method stub
		super.resetReportDate("semrsi001Bean");
	}

	@Override
	public void runReport() {
		// TODO Auto-generated method stub
		semrsi001Bean = getSemrsi001Bean();
		SEMRSI001ReportParameter param = null;
		List<SelectItem> s = null;
		if (validate()) {
			try {
				param = new SEMRSI001ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrsi001Bean
						.getCompany()));
				param.setP_company(semrsi001Bean.getCompany());
				param.setP_year(DateUtil.convertYearTH2YearEN(semrsi001Bean.getYear())+"");
				param.setP_display_year(semrsi001Bean.getYear());
				
				if (StringUtils.isNotEmpty(semrsi001Bean.getType())) {
					param.setP_type(semrsi001Bean.getType());
				}
				if (StringUtils.isNotEmpty(semrsi001Bean.getType())) {
					s = th.co.ais.web.util.WebUtil.getSelectItemByValue(
							semrsi001Bean.getType(), semrsi001Bean
									.getTypeList());
					if (s != null) {
						param.setP_display_type(s.get(0).getLabel());
					}
				}
				param.setP_username(getUserLogIn());
//				WebUtil.getContentType(param);
				super.runReport("SEMRSI001", param, semrsi001Bean
						.getReportType(), semrsi001Bean.getRunType(),
						semrsi001Bean.getBatchType(), semrsi001Bean
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
		super.showReport("SEMRSI001", getSemrsi001Bean().getReportType());
	}
}
