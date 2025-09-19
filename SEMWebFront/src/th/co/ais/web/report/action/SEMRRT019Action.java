package th.co.ais.web.report.action;


import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
//import org.jboss.remoting.transport.web.WebUtil;


import th.co.ais.rpt.parameter.SEMRRT019ReportParameter;
import th.co.ais.util.ELovType;
import th.co.ais.util.EParamName;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMRRT019Bean;
import th.co.ais.web.util.ParameterCacheUtil;
import th.co.ais.web.util.SemUtils;

public class SEMRRT019Action extends AbstractReportAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2524424552117504744L;
	private Logger log = Logger.getLogger(getClass());
	private SEMRRT019Bean semrrt019Bean;
	
	public SEMRRT019Bean getSemrrt019Bean() {
		return (SEMRRT019Bean) getFacesUtils().getSessionMapValue("semrrt019Bean");
	}

	public void setSemrrt019Bean(SEMRRT019Bean semrrt019Bean) {
		getFacesUtils().setSessionMapValue("semrrt019Bean", semrrt019Bean);
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
		super.clearSessionBean();
	}

	@Override
	public void init() {
		super.clearSessionBean();
		
		semrrt019Bean = new SEMRRT019Bean();
		semrrt019Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		List<SelectItem> tmpMasterGroup =(ParameterCacheUtil.getInstance().getParamItemsByParamName(EParamName.P_REP_MASTER_DATA.name));
		for(int i=0;i<tmpMasterGroup.size();i++){
			SelectItem tmp = tmpMasterGroup.get(i);
			if(tmp !=null && StringUtils.isBlank(tmp.getValue().toString())){
				tmpMasterGroup.remove(i);
			}
		}
		semrrt019Bean.setMasterGroupList(tmpMasterGroup);
		setSemrrt019Bean(semrrt019Bean);
	}
		
	@Override
	public boolean validate() {
		boolean flgValid = true;
		
		if (StringUtils.isEmpty(getSemrrt019Bean().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		
		
		if (StringUtils.isEmpty(getSemrrt019Bean().getMonthYear())) {
			addMessageError("W0001", msg("message.monthYearEnLbl"));
			flgValid = false;
		}else{
			String msgError = SemUtils.chkMonthYearFormat(getSemrrt019Bean().getMonthYear());
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
		getSemrrt019Bean().clearReportSimple();
		
		getSemrrt019Bean().setCompany(null);
		getSemrrt019Bean().setMonthYear(null);
		getSemrrt019Bean().setMasterGroups(null);
		getSemrrt019Bean().setContract(null);
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		// TODO Auto-generated method stub
		super.enableBatchType("semrrt019Bean");
	}

	@Override
	public void resetReportDate() {
		// TODO Auto-generated method stub
		super.resetReportDate("semrrt019Bean");
	}

	@Override
	public void runReport() {
		// TODO Auto-generated method stub
		semrrt019Bean = getSemrrt019Bean();
		SEMRRT019ReportParameter param = null;
		
		
		if (validate()) {
			try {
				param = new SEMRRT019ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrrt019Bean.getCompany()));
				param.setP_company(semrrt019Bean.getCompany());
				param.setP_username(getUserLogIn());
				param.setP_contract_no(semrrt019Bean.getContract());
				param.setP_master_group(mergArrayByComma(semrrt019Bean.getMasterGroups()));
				if(StringUtils.isNotEmpty(getSemrrt019Bean().getMonthYear())){
					param.setP_month_year(SemUtils.convertMonthYearTH2MonthYearEN(semrrt019Bean.getMonthYear()));
				}
				param.setP_display_month_year(semrrt019Bean.getMonthYear());
//				WebUtil.getContentType(param);
				super.runReport("SEMRRT019", param, 
						semrrt019Bean.getReportType(), semrrt019Bean.getRunType(), 
						semrrt019Bean.getBatchType(), semrrt019Bean.getJobSchedule());
			
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
		super.showReport("SEMRRT019", getSemrrt019Bean().getReportType());
	}
	
	private String mergArrayByComma(String[] array){
		
		if(array == null || array.length==0){
			return "";
		}
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<array.length;i++){
			sb.append(array[i]);
			if(i<array.length-1){
				sb.append(",");
			}
		}
		
		return sb.toString();
		
	}

}
