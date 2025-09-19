package th.co.ais.web.report.action;

import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.co.ContractFile;
import th.co.ais.domain.co.Mco005SrchSP;
import th.co.ais.rpt.parameter.SEMECO001ReportParameter;
import th.co.ais.rpt.parameter.SEMMCO005ReportParameter;
import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.rpt.util.DataUtil;
import th.co.ais.rpt.web.util.IReportWebHelper;
import th.co.ais.service.co.IContractFileService;
import th.co.ais.util.AISConstant;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.co.action.SEMMCO005Tab2Action;
import th.co.ais.web.co.bean.SEMMCO005Bean;
import th.co.ais.web.co.bean.SEMMCO005Tab2Bean;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMECO001Bean;
import th.co.ais.web.report.bean.SEMMCO005RPTBean;
import th.co.ais.web.util.JSFServiceFinderUtil;

/**
 * 
 * @author Warawit Kitmongkonsak
 *
 */
public class SEMMCO005RPTAction extends AbstractReportAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6332816276685124847L;

	private Logger log = Logger.getLogger(getClass());
	
	private SEMMCO005RPTBean semmco005RPTBean;
	private SEMMCO005Bean semmco005Bean;
	private StringBuilder rowsIdCC;
	
	public SEMMCO005RPTAction() {
		
	}
	
	public SEMMCO005RPTBean getSemmco005RPTBean() {
		return (SEMMCO005RPTBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmco005RPTBean");
	}

	public void setSemmco005RPTBean(SEMMCO005RPTBean semmco005RPTBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmco005RPTBean", semmco005RPTBean);
	}
	
	public SEMMCO005Bean getSemmco005Bean() {
		return (SEMMCO005Bean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmco005Bean");
	}

	public void setSemmco005Bean(SEMMCO005Bean semmco005Bean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmco005Bean", semmco005Bean);
	}
	
	@Override
	public void init() {
		super.clearSessionBean();
		
		semmco005RPTBean = new SEMMCO005RPTBean();
		setSemmco005RPTBean(semmco005RPTBean);
	}
	
	@Override
	public void clearReport() {
		super.clearSessionBean();
		
		semmco005RPTBean = getSemmco005RPTBean();
		semmco005RPTBean.clearReportSimple();
		setSemmco005RPTBean(semmco005RPTBean);
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		super.enableBatchType("semmco005RPTBean");
	}

	@Override
	public void resetReportDate() {
		super.resetReportDate("semmco005RPTBean");	
	}

	@Override
	public void runReport() {
		semmco005Bean = getSemmco005Bean();
		semmco005RPTBean = getSemmco005RPTBean();
		rowsIdCC = new StringBuilder();
		SEMMCO005ReportParameter param = null;
		
		for (WrapperBeanObject<Mco005SrchSP> temps : semmco005Bean.getContractSPList()) {
			Mco005SrchSP temp = (Mco005SrchSP) temps.getDataObj();
			if (temp != null && temps.isCheckBox()) {
				rowsIdCC.append(temp.getRowId());
				rowsIdCC.append(',');
			} 
		}
		
		if (validate()) {
			try {
				param = new SEMMCO005ReportParameter();
				param.setCONTRACT_ID(rowsIdCC.toString());
				param.setReportEngine(ServiceConstants.REPORT_ENGINE_DOCMOSIS);

				runReport("SEMMCO005", param, 
						semmco005RPTBean.getReportType(), semmco005RPTBean.getRunType(), 
						semmco005RPTBean.getBatchType(), semmco005RPTBean.getJobSchedule());
			
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
		super.showReport("SEMMCO005", getSemmco005RPTBean().getReportType());
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
		getSemmco005Bean().setRenderedMsgFormSearch(true);
		
		if (StringUtils.isEmpty(rowsIdCC.toString())) {
			addMessageError("W0001", msg("message.contractDoc"));
			flgValid = false;
		}
		
		return flgValid;
	}

}