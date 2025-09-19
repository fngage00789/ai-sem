package th.co.ais.web.report.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.co.Mco004SrchSP;
import th.co.ais.rpt.parameter.SEMMCO004ReportParameter;
import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.service.co.IContractStatusService;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.co.action.SEMMCO004Action;
import th.co.ais.web.co.bean.SEMMCO004Bean;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMMCO004RPTBean;

public class SEMMCO004RPTAction extends AbstractReportAction {

	private Logger log = Logger.getLogger(getClass());
	private SEMMCO004Bean semmco004Bean;
	private SEMMCO004RPTBean semmco004RPTBean;
	
	private SEMMCO004Bean getSemmco004Bean(){
		SEMMCO004Bean semmco004Bean = (SEMMCO004Bean)getFacesUtils().getSessionMapValue("semmco004Bean");
		if(semmco004Bean == null)
			semmco004Bean = new SEMMCO004Bean();
		return semmco004Bean;
	}
	
	private void setSemmco004Bean(SEMMCO004Bean semmco004Bean){
		this.semmco004Bean = semmco004Bean;
		getFacesUtils().setSessionMapValue("semmco004Bean", semmco004Bean);
	}
	
	private SEMMCO004RPTBean getSemmco004RPTBean(){
		SEMMCO004RPTBean semmco004RPTBean = (SEMMCO004RPTBean)getFacesUtils().getSessionMapValue("semmco004RPTBean");
		if(semmco004RPTBean == null)
			semmco004RPTBean = new SEMMCO004RPTBean();
		return semmco004RPTBean;
	}
	
	private void setSemmco004RPTBean(SEMMCO004RPTBean semmco004RPTBean){
		this.semmco004RPTBean = semmco004RPTBean;
		getFacesUtils().setSessionMapValue("semmco004RPTBean", semmco004RPTBean);
	}
	
	@Override
	public void clearReport() {
		super.clearSessionBean();
		
		semmco004RPTBean = getSemmco004RPTBean();
		semmco004RPTBean.clearReportSimple();
		setSemmco004RPTBean(semmco004RPTBean);
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		super.enableBatchType("semmco004RPTBean");
	}

	@Override
	public void resetReportDate() {
		super.resetReportDate("semmco004RPTBean");
	}

	@Override
	public void runReport() {
		SEMMCO004Action semmco004Action = new SEMMCO004Action();
		semmco004Bean = getSemmco004Bean();
		semmco004RPTBean = getSemmco004RPTBean();
		List<Mco004SrchSP> to = null;
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		List<WrapperBeanObject<Mco004SrchSP>> tmpList = semmco004Bean.getMco004SrchSPList();
		Mco004SrchSP tmp = new Mco004SrchSP();
		boolean exportFile = true;
		try{
			if(StringUtils.isNotEmpty(rowId)){
				for(int i=0;i<tmpList.size();i++){			
					tmp = (Mco004SrchSP)tmpList.get(i).getDataObj();
					
					if(rowId.equals(tmp.getRowId())){
						semmco004RPTBean.setSubRentInfo(new Mco004SrchSP(tmp));
						break;
					}
				}
			}
			
			if(semmco004RPTBean.getSubRentInfo().getSubRentId() == null){
					to = service.querySPList(EQueryName.SP_MCO004_INSERT.name, semmco004RPTBean.getSubRentInfo());
					if (to != null && !to.isEmpty() && to.get(0).getResult().equals("Success")) {
						semmco004RPTBean.getSubRentInfo().setSubRentId(to.get(0).getSubRentId());
						semmco004RPTBean.getSubRentInfo().setLesseeSiteInfoId(to.get(0).getLesseeSiteInfoId());
					}else{
						exportFile = false;
					}
			}
			
			if(exportFile){
				SEMMCO004ReportParameter param = new SEMMCO004ReportParameter();
				param.setLessorSiteInfoId(semmco004RPTBean.getSubRentInfo().getLesseeSiteInfoId());
				param.setReportEngine(ServiceConstants.REPORT_ENGINE_DOCMOSIS);
				
				super.runReport("SEMMCO004", param, semmco004RPTBean.getReportType(),
						semmco004RPTBean.getRunType(), semmco004RPTBean.getBatchType(),
						semmco004RPTBean.getJobSchedule());
				semmco004RPTBean.setDisplayShowReport(true);
			}
			semmco004Action.doSearch();
			setSemmco004RPTBean(semmco004RPTBean);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
//		semmco004Bean = getSemmco004Bean();
//		semmco004RPTBean = getSemmco004RPTBean();
//		IInsuredService service = (IInsuredService)getBean("insuredService");
//		String dfNumber = null;
//		SEMMIR008ReportParameter param = null;
//		
//		dfNumber = semmir008Bean.getPolicyInfo().getDraftNo();
//		
//		try {
//			param = new SEMMIR008ReportParameter();
//			param.setDraftNo(dfNumber);
//			param.setReportEngine(ServiceConstants.REPORT_ENGINE_DOCMOSIS);
//			// param.setUserName(getUserLogIn());
//			// param.setUserName(getEmployee().getThaiName()+" "+getEmployee().getThaiSurname());
//
//			runReport("SEMMIR008", param, semmir008RPTBean.getReportType(),
//					semmir008RPTBean.getRunType(), semmir008RPTBean
//							.getBatchType(), semmir008RPTBean.getJobSchedule());
////			getSemmir008RPTBean().setDisplayShowReport(true);
//		
//			log.debug("show report = "+getSemmir008RPTBean().isDisplayShowReport());
//		} catch (Exception e) {
//			log.error("RUN REPORT ERROR IN " + getClass() +  " : " + e);
//			e.printStackTrace();
//		} finally {
//			param = null;
//			}
	}

	@Override
	public void showReport() {
		log.debug("show report!!!!!");
		super.showReport("SEMMCO004"+ new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()), getSemmco004RPTBean().getReportType());
	}

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		
		if(methodWithNavi.equalsIgnoreCase("doCreateFile")){
			runReport();
		}
		else if (methodWithNavi.equalsIgnoreCase("doPrint")) {
			doPrint();
		} 
		else if (methodWithNavi.equalsIgnoreCase("doShowReport")) {
				showReport();
			
		
		}
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {

	}

	@Override
	public void init() {
		super.clearSessionBean();
		
		semmco004RPTBean = new SEMMCO004RPTBean();
		setSemmco004RPTBean(semmco004RPTBean);
	}

	@Override
	public boolean validate() {
		return false;
	}
	
	public void doPrint() {
	
		SEMMCO004Action semmco004Action = new SEMMCO004Action();
		semmco004Bean = getSemmco004Bean();
		semmco004RPTBean = getSemmco004RPTBean();
		List<Mco004SrchSP> to = null;
		IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
		List<WrapperBeanObject<Mco004SrchSP>> tmpList = semmco004Bean.getMco004SrchSPList();
		semmco004RPTBean.setSubRentInfoList(new ArrayList<Mco004SrchSP>());
		Mco004SrchSP tmp = new Mco004SrchSP();
		boolean exportFile = true;
		String siteInfoIdTmp="";
		try{
			for(int i=0; i<tmpList.size(); i++){
				WrapperBeanObject<Mco004SrchSP> detail = new WrapperBeanObject<Mco004SrchSP>();
				detail = tmpList.get(i);
				if (detail.isCheckBox()){
					siteInfoIdTmp = siteInfoIdTmp + ((Mco004SrchSP)detail.getDataObj()).getRowId()+",";
					tmp = (Mco004SrchSP)tmpList.get(i).getDataObj();
					
					if (tmp.getEffectiveDt() != null){
						tmp.setEffectiveDt(SEMDataUtility.convertToEnYear(tmp.getEffectiveDt()));
					}
					
					if (tmp.getExpireDt() != null){
						tmp.setExpireDt(SEMDataUtility.convertToEnYear(tmp.getExpireDt()));
					}
					
					semmco004RPTBean.getSubRentInfoList().add(tmp);
						
				}
			}
			log.debug(" SITE INFO ID : "+siteInfoIdTmp);
			siteInfoIdTmp = siteInfoIdTmp.substring(0, siteInfoIdTmp.length()-1);
			log.debug(" SITE INFO ID : "+siteInfoIdTmp);
			semmco004RPTBean.setSiteInfoId(siteInfoIdTmp);
//			if(semmco004RPTBean.getSubRentInfo().getSubRentId() == null){
//				for (int n=0;n<semmco004RPTBean.getSubRentInfoList().size();n++){
//				to = service.querySPList(EQueryName.SP_MCO004_INSERT.name, semmco004RPTBean.getSubRentInfo());
//				if (to != null && !to.isEmpty() && to.get(0).getResult().equals("Success")) {
//				}else{
//					exportFile = false;
//				}
//				}
//			}
			if(exportFile){
				
				SEMMCO004ReportParameter param = new SEMMCO004ReportParameter();
			
				param.setLessorSiteInfoId(semmco004RPTBean.getSiteInfoId());
				param.setReportEngine(ServiceConstants.REPORT_ENGINE_DOCMOSIS);
				
				super.runReport("SEMMCO004", param, semmco004RPTBean.getReportType(),
						semmco004RPTBean.getRunType(), semmco004RPTBean.getBatchType(),
						semmco004RPTBean.getJobSchedule());
				semmco004RPTBean.setDisplayShowReport(true);
			}
			semmco004Action.doSearch();
			setSemmco004RPTBean(semmco004RPTBean);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
