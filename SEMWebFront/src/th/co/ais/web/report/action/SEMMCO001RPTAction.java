package th.co.ais.web.report.action;

import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.co.ContractFile;
import th.co.ais.domain.co.Mco001SrchSP;
import th.co.ais.rpt.parameter.SEMECO001ReportParameter;
import th.co.ais.rpt.parameter.SEMMCO001ReportParameter;
import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.rpt.util.DataUtil;
import th.co.ais.rpt.web.util.IReportWebHelper;
import th.co.ais.service.co.IContractFileService;
import th.co.ais.util.AISConstant;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.co.action.SEMMCO001Tab2Action;
import th.co.ais.web.co.bean.SEMMCO001Bean;
import th.co.ais.web.co.bean.SEMMCO001Tab2Bean;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMECO001Bean;
import th.co.ais.web.report.bean.SEMMCO001RPTBean;
import th.co.ais.web.util.JSFServiceFinderUtil;

/**
 * 
 * @author Warawit Kitmongkonsak
 *
 */
public class SEMMCO001RPTAction extends AbstractReportAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6332816276685124847L;

	private Logger log = Logger.getLogger(getClass());
	
	private SEMMCO001RPTBean semmco001RPTBean;
	private SEMMCO001Bean semmco001Bean;
	private StringBuilder rowsIdCC;
	
	public SEMMCO001RPTAction() {
		
	}
	
	public SEMMCO001RPTBean getSemmco001RPTBean() {
		return (SEMMCO001RPTBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmco001RPTBean");
	}

	public void setSemmco001RPTBean(SEMMCO001RPTBean semmco001RPTBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmco001RPTBean", semmco001RPTBean);
	}
	
	public SEMMCO001Bean getSemmco001Bean() {
		return (SEMMCO001Bean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmco001Bean");
	}

	public void setSemmco001Bean(SEMMCO001Bean semmco001Bean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmco001Bean", semmco001Bean);
	}
	
	@Override
	public void init() {
		super.clearSessionBean();
		
		semmco001RPTBean = new SEMMCO001RPTBean();
		setSemmco001RPTBean(semmco001RPTBean);
	}
	
	@Override
	public void clearReport() {
		super.clearSessionBean();
		
		semmco001RPTBean = getSemmco001RPTBean();
		semmco001RPTBean.clearReportSimple();
		setSemmco001RPTBean(semmco001RPTBean);
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		super.enableBatchType("semmco001RPTBean");
	}

	@Override
	public void resetReportDate() {
		super.resetReportDate("semmco001RPTBean");	
	}

	@Override
	public void runReport() {
		semmco001Bean = getSemmco001Bean();
		semmco001RPTBean = getSemmco001RPTBean();
		rowsIdCC = new StringBuilder();
		SEMMCO001ReportParameter param = null;
		
		for (WrapperBeanObject<Mco001SrchSP> temps : semmco001Bean.getContractSPList()) {
			Mco001SrchSP temp = (Mco001SrchSP) temps.getDataObj();
			if (temp != null && temps.isCheckBox()) {
				rowsIdCC.append(temp.getRowId());
				rowsIdCC.append(',');
			} 
		}
		
		if (validate()) {
			try {
				param = new SEMMCO001ReportParameter();
				param.setCONTRACT_ID(rowsIdCC.toString());
				param.setReportEngine(ServiceConstants.REPORT_ENGINE_DOCMOSIS);

				runReport("SEMMCO001", param, 
						semmco001RPTBean.getReportType(), semmco001RPTBean.getRunType(), 
						semmco001RPTBean.getBatchType(), semmco001RPTBean.getJobSchedule());
			
			} catch (Exception e) {
				log.error("RUN REPORT ERROR IN " + getClass() +  " : " + e);
				e.printStackTrace();
			} finally {
				param = null;
			}
		}
	}
	
	@Override
	public void showReport() {
		super.showReport("SEMMCO001", getSemmco001RPTBean().getReportType());
	}

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		
		if(methodWithNavi.equalsIgnoreCase("doRunReport")){
			runReport();
		} else if (methodWithNavi.equalsIgnoreCase("doShowReport")) {
			showReport();
		}
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {

	}

	@Override
	public boolean validate() {
		boolean flgValid = true;
		getSemmco001Bean().setRenderedMsgFormSearch(true);
		
		if (StringUtils.isEmpty(rowsIdCC.toString())) {
			addMessageError("W0001", msg("message.contractDoc"));
			flgValid = false;
		}
		
		return flgValid;
	}

}