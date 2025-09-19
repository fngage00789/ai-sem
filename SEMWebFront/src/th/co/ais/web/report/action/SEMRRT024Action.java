package th.co.ais.web.report.action;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
//import org.jboss.remoting.transport.web.WebUtil;

import th.co.ais.rpt.parameter.SEMRRT024ReportParameter;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.util.ELovType;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMRRT024Bean;
import th.co.ais.web.report.util.ReportDateUtil;
import th.co.ais.web.rt.bean.SEMMRT003Bean;

public class SEMRRT024Action extends AbstractReportAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2349185671157648244L;
	private SEMRRT024Bean semrrt024Bean;
	private Logger log = Logger.getLogger(getClass());
	public SEMRRT024Bean getSemrrt024Bean() {
		
		return ((SEMRRT024Bean) getFacesUtils().getSessionMapValue("semrrt024Bean") == null)?new SEMRRT024Bean():(SEMRRT024Bean) getFacesUtils().getSessionMapValue("semrrt024Bean");
	}
	
	private SEMMRT003Bean semmrt003Bean;
	
	public void setSemmrt003Bean(SEMMRT003Bean semmrt003Bean) {
		this.semmrt003Bean = semmrt003Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmrt003Bean", semmrt003Bean);
	}

	public SEMMRT003Bean getSemmrt003Bean() {
		return (SEMMRT003Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmrt003Bean");
	}

	public void setSemrrt024Bean(SEMRRT024Bean semrrt024Bean) {
		getFacesUtils().setSessionMapValue("semrrt024Bean", semrrt024Bean);
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
		
		SEMRRT024Bean semrrt024Bean = new SEMRRT024Bean();
		semrrt024Bean.setCompany("");
		semrrt024Bean.setRegion("");
		semrrt024Bean.setContracNo("");
		semrrt024Bean.setLocationId("");
		semrrt024Bean.setStartDate(null);
		semrrt024Bean.setStartToDate(null);
		semrrt024Bean.setEndDate(null);
		semrrt024Bean.setEndToDate(null);
		semrrt024Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semrrt024Bean.setRegionList(getRegionItems());
		setSemrrt024Bean(semrrt024Bean);

	}

	@Override
	public boolean validate() {
		boolean flgValid = true;

		if (StringUtils.isEmpty(getSemrrt024Bean().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flgValid = false;
		}

		return flgValid;
	}

	@Override
	public void clearReport() {
		super.clearSessionBean();
		getSemrrt024Bean().clearReportSimple();
		
		getSemrrt024Bean().setCompany(null);
		
		enableBatchType();
		
	}

	@Override
	public void enableBatchType() {
		// TODO Auto-generated method stub
		super.enableBatchType("semrrt024Bean");
	}

	@Override
	public void resetReportDate() {
		// TODO Auto-generated method stub
		super.resetReportDate("semrrt024Bean");
	}

	@Override
	public void runReport() {
		// TODO Auto-generated method stub
		semmrt003Bean = getSemmrt003Bean();
		semrrt024Bean = getSemrrt024Bean();
		SEMRRT024ReportParameter param = null;
//		if (validate()) {
		if(StringUtils.isNotEmpty(semmrt003Bean.getRentalPayNormalSearchSP().getBatchNo())){
			try {
				param = new SEMRRT024ReportParameter();
//				param.setP_header_name(getCompanyHeaderName(semrrt024Bean.getCompany()));
				param.setP_batchNo(semmrt003Bean.getRentalPayNormalSearchSP().getBatchNo());
//				WebUtil.getContentType(param);
				log.debug("semrrt024Bean = "+semrrt024Bean);
				log.debug("semrrt024Bean.getReportType() = "+semrrt024Bean.getReportType());
				log.debug("semrrt024Bean.getRunType() = "+semrrt024Bean.getRunType());
				log.debug("semrrt024Bean.getBatchType() = "+semrrt024Bean.getBatchType());
				log.debug("semrrt024Bean.getJobSchedule() = "+semrrt024Bean.getJobSchedule());
				super.runReport("SEMRRT024", param, 
						semrrt024Bean.getReportType(),semrrt024Bean.getRunType(),
						semrrt024Bean.getBatchType(), semrrt024Bean.getJobSchedule());

				showReport();
			} catch (Exception e) {
				log.error("RUN REPORT ERROR IN " + getClass() + " : " + e);
				e.printStackTrace();
			} finally {
				param = null;
			}
//		}
		}
	}

	@Override
	public void showReport() {
		// TODO Auto-generated method stub
		super.showReport("SEMRRT024", getSemrrt024Bean().getReportType());
	}
}
