package th.co.ais.web.report.action;

import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.co.ContractFile;
import th.co.ais.domain.co.Mco001SrchSP;
import th.co.ais.domain.pt.Mpt003Srch;
import th.co.ais.rpt.parameter.SEMECO001ReportParameter;
import th.co.ais.rpt.parameter.SEMMPT003ReportParameter;
import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.rpt.util.DataUtil;
import th.co.ais.rpt.web.util.IReportWebHelper;
import th.co.ais.service.co.IContractFileService;
import th.co.ais.util.AISConstant;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.pt.bean.SEMMPT003Bean;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMECO001Bean;
import th.co.ais.web.report.bean.SEMMPT003RPTBean;
import th.co.ais.web.util.JSFServiceFinderUtil;

/**
 * 
 * @author Warawit Kitmongkonsak
 *
 */
public class SEMMPT003RPTAction extends AbstractReportAction{

	/**
	 * 
	 */

	private Logger log = Logger.getLogger(getClass());
	
	private SEMMPT003RPTBean semmpt003RPTBean;
	private SEMMPT003Bean semmpt003Bean;
	private StringBuilder rowsIdCC;
	
	public SEMMPT003RPTAction() {
		
	}
	
	public SEMMPT003RPTBean getSemmpt003RPTBean() {
		SEMMPT003RPTBean semmpt003RPTBean = (SEMMPT003RPTBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmpt003RPTBean");
		if(semmpt003RPTBean == null){
			semmpt003RPTBean = new SEMMPT003RPTBean();
		}
		return semmpt003RPTBean;
	}

	public void setSemmpt003RPTBean(SEMMPT003RPTBean semmpt003RPTBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmpt003RPTBean", semmpt003RPTBean);
	}
	
	public SEMMPT003Bean getSemmpt003Bean() {
		return (SEMMPT003Bean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmpt003Bean");
	}

	public void setSemmpt003Bean(SEMMPT003Bean semmpt003Bean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmpt003Bean", semmpt003Bean);
	}
	
	@Override
	public void init() {
		super.clearSessionBean();
		semmpt003RPTBean = new SEMMPT003RPTBean();
		setSemmpt003RPTBean(semmpt003RPTBean);
	}
	
	@Override
	public void clearReport() {
		super.clearSessionBean();
		
		semmpt003RPTBean = getSemmpt003RPTBean();
		semmpt003RPTBean.clearReportSimple();
		setSemmpt003RPTBean(semmpt003RPTBean);
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		super.enableBatchType("semmpt003RPTBean");
	}

	@Override
	public void resetReportDate() {
		super.resetReportDate("semmpt003RPTBean");	
	}

	@Override
	public void runReport() {
		semmpt003Bean = getSemmpt003Bean();
		semmpt003RPTBean = getSemmpt003RPTBean();
		SEMMPT003ReportParameter param = new SEMMPT003ReportParameter();
		StringBuffer pTaxID = new StringBuffer();
				
		try{
			for(WrapperBeanObject<Mpt003Srch> mpts : semmpt003Bean.getMpt003SrchList()){
				Mpt003Srch mpt003Srch = (Mpt003Srch)mpts.getDataObj(); 
				if(mpts.isCheckBox()){
					pTaxID.append(mpt003Srch.getRowId()+",");
					
				}
			}
			param.setReportEngine(ServiceConstants.REPORT_ENGINE_JASPER);
			param.setP_pTax_id(pTaxID.toString().substring(0,pTaxID.toString().length()-1));
			
			super.runReport("SEMMPT003", param, 
					semmpt003RPTBean.getReportType(), semmpt003RPTBean.getRunType(), 
					semmpt003RPTBean.getBatchType(), semmpt003RPTBean.getJobSchedule());
			getSemmpt003RPTBean().setDisplayShowReport(true);
			} catch (Exception e) {
				log.error("RUN REPORT ERROR IN " + getClass() +  " : " + e);
				e.printStackTrace();
			} finally {
				param = null;
			}
		}
	
	
	@Override
	public void showReport() {
		String reportName = "SEMMPT003";
		try{
			reportName += SEMDataUtility.getCurrentDateByPatternYYMMDD();
		}catch (Exception e) {
			e.printStackTrace();
		}
		super.showReport(reportName, getSemmpt003RPTBean().getReportType());
		
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
		getSemmpt003Bean().setRenderedMsgFormSearch(true);
		
		if (StringUtils.isEmpty(rowsIdCC.toString())) {
			addMessageError("W0001", msg("message.contractDoc"));
			flgValid = false;
		}
		
		return flgValid;
	}

}