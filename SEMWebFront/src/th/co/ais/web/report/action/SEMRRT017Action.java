package th.co.ais.web.report.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.rpt.parameter.SEMRRT017ReportParameter;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.util.ELovType;
import th.co.ais.web.bean.common.PopupSiteMultiRegionBean;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMRRT017Bean;
import th.co.ais.web.report.util.ReportDateUtil;
import th.co.ais.web.util.SemUtils;
import th.co.ais.web.util.WebUtil;

public class SEMRRT017Action extends AbstractReportAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2524424552117504744L;
	private Logger log = Logger.getLogger(getClass());
	private SEMRRT017Bean semrrt017Bean;
	private PopupSiteMultiRegionBean popupSiteMultiRegionBean;
	
	public SEMRRT017Bean getSemrrt017Bean() {
		return (SEMRRT017Bean) getFacesUtils().getSessionMapValue("semrrt017Bean");
	}

	public void setSemrrt017Bean(SEMRRT017Bean semrrt017Bean) {
		getFacesUtils().setSessionMapValue("semrrt017Bean", semrrt017Bean);
	}
	
	public PopupSiteMultiRegionBean getPopupSiteMultiRegionBean() {
		return (PopupSiteMultiRegionBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupSiteMultiRegionBean");
	}

	public void setPopupSiteMultiRegionBean(
			PopupSiteMultiRegionBean popupSiteMultiRegionBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupSiteMultiRegionBean", popupSiteMultiRegionBean);
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
		
		semrrt017Bean = new SEMRRT017Bean();
		semrrt017Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semrrt017Bean.setYearList(ReportDateUtil.getDDLYearTh());
		semrrt017Bean.setMonthList(ReportDateUtil.getDDLMonthTH());
		semrrt017Bean.setYear(DateUtil.getCurrentYear() + "");
		setSemrrt017Bean(semrrt017Bean);
	}
		
	@Override
	public boolean validate() {
		boolean flgValid = true;
		
		if (StringUtils.isEmpty(getSemrrt017Bean().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}
		if (StringUtils.isEmpty(getSemrrt017Bean().getYear())) {
			addMessageError("W0001", msg("message.year"));
			flgValid = false;
		}
		if (StringUtils.isEmpty(getSemrrt017Bean().getMonth())) {
			addMessageError("W0001", msg("message.month"));
			flgValid = false;
		}
		
		return flgValid;
	}
	

	@Override
	public void clearReport() {
		// TODO Auto-generated method stub
		super.clearSessionBean();
		getSemrrt017Bean().clearReportSimple();
		
		getSemrrt017Bean().setCompany(null);
		getSemrrt017Bean().setYear(DateUtil.getCurrentYear() + "");
		getSemrrt017Bean().setMonth(null);
		getSemrrt017Bean().setRegion(null);
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		// TODO Auto-generated method stub
		super.enableBatchType("semrrt017Bean");
	}

	@Override
	public void resetReportDate() {
		// TODO Auto-generated method stub
		super.resetReportDate("semrrt017Bean");
	}

	@Override
	public void runReport() {
		// TODO Auto-generated method stub
		semrrt017Bean = getSemrrt017Bean();
		popupSiteMultiRegionBean = getPopupSiteMultiRegionBean();
		SEMRRT017ReportParameter param = null;
		
		if (validate()) {
			try {
				param = new SEMRRT017ReportParameter();
				param.setP_header_name(getCompanyHeaderName(semrrt017Bean.getCompany()));
				param.setP_company(semrrt017Bean.getCompany());
				param.setP_month(semrrt017Bean.getMonth());
				param.setP_year(semrrt017Bean.getYear());
				param.setP_region((popupSiteMultiRegionBean != null)?SemUtils.mergSelectListByComma(popupSiteMultiRegionBean.getSelectedList()):"");
				param.setP_display_year(WebUtil.getSelectItemByValue(new Integer(semrrt017Bean.getYear()), ReportDateUtil.getDDLYearTh()).get(0).getLabel());
				param.setP_display_month(WebUtil.getSelectItemByValue(semrrt017Bean.getMonth(), ReportDateUtil.getDDLMonth()).get(0).getLabel());
				
				Integer month = new Integer(semrrt017Bean.getMonth());
				Integer year = new Integer(semrrt017Bean.getYear());
				
				param.setP_col1_month(getStringDate(1, month, year,0,0,0,0,-1,1));
				param.setP_col2_month(getStringDate(1, month, year,0,0,1,0,-1,2));
				param.setP_col3_month(getStringDate(1, month, year,0,0,2,0,-1,3));
				param.setP_col4_month(getStringDate(1, month, year,0,0,3,0,-1,4));
				param.setP_col5_month(getStringDate(1, month, year,0,0,4,0,-1,5));
				param.setP_username(getUserLogIn());
				
				super.runReport("SEMRRT017", param, 
						semrrt017Bean.getReportType(), semrrt017Bean.getRunType(), 
						semrrt017Bean.getBatchType(), semrrt017Bean.getJobSchedule());
			
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
		super.showReport("SEMRRT017", getSemrrt017Bean().getReportType());
	}

	public String getStringDate(int day, int month, int year,int aday, int amonth, int ayear,int bday, int bmonth, int byear){
		Calendar c = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		StringBuilder sb = new StringBuilder();
		c.setTime(new Date());
		c.set(c.DATE, day);
		c.set(c.MONTH, month);
		c.set(c.YEAR, year);
		
		c.add(c.YEAR, ayear);
		c.add(c.MONTH, amonth);
		c.add(c.DATE, aday);
		sb.append(df.format(c.getTime()));
		
		
		c.setTime(new Date());
		c.set(c.MONTH, month);
		c.set(c.YEAR, year);
		c.set(c.DATE, c.getActualMaximum(Calendar.DATE));
			
		c.add(c.YEAR, byear);
		c.add(c.MONTH, bmonth);
		c.add(c.DATE, bday);
		
		
		sb.append(" - ");
		sb.append(df.format(c.getTime()));
		
		return sb.toString();
	}
}
