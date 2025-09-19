package th.co.ais.web.report.action;

import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
//import org.jboss.remoting.transport.web.WebUtil;
import th.co.ais.rpt.parameter.SEMRPT002ReportParameter;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.util.ELovType;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMRPT002Bean;
import th.co.ais.web.util.SelectItemLOVCacheUtil;
import th.co.ais.web.util.SemUtils;

public class SEMRPT002Action extends AbstractReportAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7410440438777216616L;
	private Logger log = Logger.getLogger(getClass());
	private SEMRPT002Bean semrpt002Bean;
	
	public SEMRPT002Bean getSemrpt002Bean() {
		return (SEMRPT002Bean) getFacesUtils().getSessionMapValue("semrpt002Bean");
	}

	public void setSemrpt002Bean(SEMRPT002Bean semrpt002Bean) {
		getFacesUtils().setSessionMapValue("semrpt002Bean", semrpt002Bean);
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
		
		semrpt002Bean = new SEMRPT002Bean();
		semrpt002Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semrpt002Bean.setYearTax(String.valueOf(DateUtil.getCurrentYearTH()));
		semrpt002Bean.setExpenseTypeList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name, EX_AND, null, "PT", null));
		semrpt002Bean.setPico(false);
		setSemrpt002Bean(semrpt002Bean);
	}
		
	@Override
	public boolean validate() {
		boolean flgValid = true;
		
		if (StringUtils.isEmpty(getSemrpt002Bean().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		
		if (StringUtils.isEmpty(getSemrpt002Bean().getYearTax())) {
			addMessageError("W0001", msg("message.pTaxYear"));
			flgValid = false;
		}else if(!SemUtils.chkYearTH(getSemrpt002Bean().getYearTax())){
			addMessageError("W0099",msg("message.pTaxYear"));
			flgValid = false;
		}
		
		if (StringUtils.isEmpty(getSemrpt002Bean().getExpenseType())){
			addMessageError("W0001",msg("message.expenseType"));
			flgValid = false;
		}
		
		return flgValid;
	}
	

	@Override
	public void clearReport() {
		super.clearSessionBean();
		getSemrpt002Bean().clearReportSimple();
		
		getSemrpt002Bean().setCompany(null);
		getSemrpt002Bean().setYearTax(DateUtil.getCurrentYearTH());
		getSemrpt002Bean().setExpenseType(null);
		getSemrpt002Bean().setPico(false);
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		super.enableBatchType("semrpt002Bean");
	}

	@Override
	public void resetReportDate() {
		super.resetReportDate("semrpt002Bean");
	}

	@Override
	public void runReport() {
		semrpt002Bean = getSemrpt002Bean();
		List<SelectItem> s = null;
		SEMRPT002ReportParameter param = null;
		if (validate()) {
			try {
				param = new SEMRPT002ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrpt002Bean.getCompany()));
				param.setP_company(semrpt002Bean.getCompany());
				param.setP_ptax_year(DateUtil.convertYearTH2YearEN(semrpt002Bean.getYearTax()));
				param.setP_display_year_tax(semrpt002Bean.getYearTax());
				param.setP_expense_type(semrpt002Bean.getExpenseType());
				if(StringUtils.isNotEmpty(semrpt002Bean.getExpenseType())){
					s = th.co.ais.web.util.WebUtil.getSelectItemByValue(semrpt002Bean.getExpenseType(), semrpt002Bean.getExpenseTypeList());
					if(s != null){
						param.setP_display_expense_type(s.get(0).getLabel());
					}
				}
				param.setP_pico_flg((semrpt002Bean.isPico())? "Y": "N");
				param.setP_username(getUserLogIn());
				
//				WebUtil.getContentType(param);
				super.runReport("SEMRPT002", param, 
						semrpt002Bean.getReportType(), semrpt002Bean.getRunType(), 
						semrpt002Bean.getBatchType(), semrpt002Bean.getJobSchedule());
			
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
		super.showReport("SEMRPT002", getSemrpt002Bean().getReportType());
	}
	
}
