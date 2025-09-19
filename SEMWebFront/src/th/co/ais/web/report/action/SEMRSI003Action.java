package th.co.ais.web.report.action;

import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
//import org.jboss.remoting.transport.web.WebUtil;

import th.co.ais.rpt.parameter.SEMRSI003ReportParameter;
import th.co.ais.util.ELovType;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMRSI003Bean;

public class SEMRSI003Action extends AbstractReportAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8430104648834753704L;
	private Logger log = Logger.getLogger(getClass());
	private SEMRSI003Bean semrsi003Bean;

	public SEMRSI003Bean getSemrsi003Bean() {
		return (SEMRSI003Bean) getFacesUtils().getSessionMapValue(
				"semrsi003Bean");
	}

	public void setSemrsi003Bean(SEMRSI003Bean semrsi003Bean) {
		getFacesUtils().setSessionMapValue("semrsi003Bean", semrsi003Bean);
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

		semrsi003Bean = new SEMRSI003Bean();
		
		semrsi003Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semrsi003Bean.setRegionList(getRegionItems());
		semrsi003Bean.setApproveTypeList(getLovItemsByType(ELovType.T_SI_SITE_APPROVE_TYPE.name));
		
		setSemrsi003Bean(semrsi003Bean);
	}

	@Override
	public boolean validate() {
		boolean flgValid = true;

		if(	StringUtils.isEmpty(getSemrsi003Bean().getCompany())   &&
			StringUtils.isEmpty(getSemrsi003Bean().getRegion())    &&
			StringUtils.isEmpty(getSemrsi003Bean().getContractNo())&& 
			StringUtils.isEmpty(getSemrsi003Bean().getSite())      &&
			StringUtils.isEmpty(getSemrsi003Bean().getApproveType())
			){
			addMessageError("W0004", msg("message.requireOne"));
			flgValid = false;
		}

		return flgValid;
	}

	@Override
	public void clearReport() {
		// TODO Auto-generated method stub
		super.clearSessionBean();
		getSemrsi003Bean().clearReportSimple();
		
		getSemrsi003Bean().setCompany(null);
		getSemrsi003Bean().setRegion(null);
		getSemrsi003Bean().setContractNo(null);
		getSemrsi003Bean().setSite(null);
		getSemrsi003Bean().setApproveType(null);

		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		// TODO Auto-generated method stub
		super.enableBatchType("semrsi003Bean");
	}

	@Override
	public void resetReportDate() {
		// TODO Auto-generated method stub
		super.resetReportDate("semrsi003Bean");
	}

	@Override
	public void runReport() {
		// TODO Auto-generated method stub
		semrsi003Bean = getSemrsi003Bean();
		SEMRSI003ReportParameter param = null;
		List<SelectItem> s = null;
		if (validate()) {
			try {
				param = new SEMRSI003ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrsi003Bean
						.getCompany()));
				param.setP_contract_no(semrsi003Bean.getContractNo());
				param.setP_site_name(semrsi003Bean.getSite());
				param.setP_username(getUserLogIn());
				param.setP_company(semrsi003Bean.getCompany());
				param.setP_region(semrsi003Bean.getRegion());
				param.setP_approve_type(semrsi003Bean.getApproveType());
				
				if (StringUtils.isNotEmpty(semrsi003Bean.getApproveType())) {
					s = th.co.ais.web.util.WebUtil.getSelectItemByValue(semrsi003Bean.getApproveType(), semrsi003Bean.getApproveTypeList());
					if (s != null) {
						param.setP_display_approve_type(s.get(0).getLabel());
					}
				}
				
//				WebUtil.getContentType(param);
				super.runReport("SEMRSI003", param, semrsi003Bean
						.getReportType(), semrsi003Bean.getRunType(),
						semrsi003Bean.getBatchType(), semrsi003Bean
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
		super.showReport("SEMRSI003", getSemrsi003Bean().getReportType());
	}
}
