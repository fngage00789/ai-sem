package th.co.ais.web.report.action;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.dao.rpt.jdbc.SEMECO001ReportDao;
import th.co.ais.domain.co.ContractFile;
import th.co.ais.domain.co.Eco001ExpContract;
import th.co.ais.domain.co.Mco001SrchSP;
import th.co.ais.domain.co.Mco007MasterContractDetailSP;
import th.co.ais.domain.co.Mco007ReportParam;
import th.co.ais.domain.co.Mco007MasterContractSP;
import th.co.ais.domain.sa.Msa003ReportParam;
import th.co.ais.rpt.domain.SEMECO001Domain;
import th.co.ais.rpt.domain.SEMECO007Domain;
import th.co.ais.rpt.parameter.SEMECO001ReportParameter;
import th.co.ais.rpt.parameter.SEMMSA003ReportParameter;
import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.rpt.util.DataUtil;
import th.co.ais.rpt.web.util.IReportWebHelper;
import th.co.ais.service.co.IContractFileService;
import th.co.ais.service.co.IContractStatusService;
import th.co.ais.service.impl.report.SEMECO003ReportService;
import th.co.ais.service.rt.IRentalPaymentService;
import th.co.ais.service.si.ISiteContractService;
import th.co.ais.util.AISConstant;
import th.co.ais.util.EQueryName;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.co.bean.SEMMCO001Bean;
import th.co.ais.web.co.bean.SEMMCO001Tab2Bean;
import th.co.ais.web.co.bean.SEMMCO004Bean;
import th.co.ais.web.co.bean.SEMMCO005Bean;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMECO001Bean;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.JSFServiceFinderUtil;

/**
 * 
 * @author Warawit Kitmongkonsak
 *
 */
public class SEMECO001Action extends AbstractReportAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6332816276685124847L;

	private Logger log = Logger.getLogger(getClass());
	
	private SEMECO001Bean semeco001Bean;
	private SEMMCO001Bean semmco001Bean;
	private SEMMCO001Tab2Bean semmco001tab2Bean;
	private String reportId;
	private String reportName;
	
	public SEMECO001Action() {
		
	}
	
	public SEMECO001Bean getSemeco001Bean() {
		return (SEMECO001Bean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semeco001Bean");
	}

	public void setSemeco001Bean(SEMECO001Bean semeco001Bean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semeco001Bean", semeco001Bean);
	}
	
	public SEMMCO001Bean getSemmco001Bean() {
		return (SEMMCO001Bean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmco001Bean");
	}

	public void setSemmco001Bean(SEMMCO001Bean semmco001Bean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmco001Bean", semmco001Bean);
	}

	public SEMMCO001Tab2Bean getSemmco001tab2Bean() {
		return (SEMMCO001Tab2Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmco001tab2Bean");
	}
	
	public void setSemmco001tab2Bean(SEMMCO001Tab2Bean semmco001tab2Bean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmco001tab2Bean", this.semmco001tab2Bean);
	}
	
	@Override
	public void init() {
		super.clearSessionBean();
		
		semeco001Bean = new SEMECO001Bean();
		semmco001Bean.setSemeco007Domain(new SEMECO007Domain());
		// define report name.
//		setReportName();
		setSemeco001Bean(semeco001Bean);
	}
	
	@Override
	public void clearReport() {
		super.clearSessionBean();
		
		semeco001Bean = getSemeco001Bean();
		semeco001Bean.clearReportSimple();
		setSemeco001Bean(semeco001Bean);
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		super.enableBatchType("semeco001Bean");
	}

	@Override
	public void resetReportDate() {
		super.resetReportDate("semeco001Bean");	
	}

	@Override
	public void runReport() {
		log.debug("***[SEMECO001Action][runReport]***");
		SEMMCO001Bean semmco001Bean2 = getSemmco001Bean();
		SEMMCO001Bean semmco001Bean = null; 
		SEMMCO005Bean semmco005Bean =  (SEMMCO005Bean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmco005Bean");
		SEMMCO004Bean semmco004Bean =  (SEMMCO004Bean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmco004Bean");
		semeco001Bean = getSemeco001Bean();
		IReportWebHelper reportWebHelper = null;
		IContractFileService contractFileService = null;
		ContractFile contractFile = null;
		SEMECO001ReportParameter param = null;
		String filePath = null;
		String page = (String)getFacesUtils().getRequestParameter("fromPage");
		ISiteContractService service = (ISiteContractService)getBean("siteContractService");
		List<SEMECO001Domain> to = null;
		Eco001ExpContract eco001Exp = null;
		Map<String, Object> criteria = new HashMap<String, Object>();
		Object criObj = new Object();
		SEMECO001Domain domain = null;
		SEMECO003ReportService semeco003ReportService = new SEMECO003ReportService();
		SEMECO001ReportDao semeco001ReportDao = new SEMECO001ReportDao();
		
		if(StringUtils.equalsIgnoreCase(page, "SEMMCO004")&& semmco001Bean == null){
			semmco001Bean = new SEMMCO001Bean();
			semmco001Bean.setCompanyParam(semmco004Bean.getCompanyParam());
			semmco001Bean.setContractIdParam(semmco004Bean.getContractIdParam());
			semmco001Bean.setContractNoParam(semmco004Bean.getContractNoParam());
			setSemmco001Bean(semmco001Bean);
		}else if(StringUtils.equalsIgnoreCase(page, "SEMMCO005") && semmco001Bean == null){
			semmco001Bean = new SEMMCO001Bean();
			semmco001Bean.setCompanyParam(semmco005Bean.getCompanyParam());
			semmco001Bean.setContractIdParam(semmco005Bean.getContractIdParam());
			semmco001Bean.setContractNoParam(semmco005Bean.getContractNoParam());
			setSemmco001Bean(semmco001Bean);
		}else {
			semmco001Bean = semmco001Bean2;
		}
//		if(semmco001Bean == null){
//			semmco001Bean = new SEMMCO001Bean();
//			semmco001Bean.setCompanyParam(semmco005Bean.getCompanyParam());
//			semmco001Bean.setContractIdParam(semmco005Bean.getContractIdParam());
//			semmco001Bean.setContractNoParam(semmco005Bean.getContractNoParam());
//			setSemmco001Bean(semmco001Bean);
//		}
		if(AISConstant.COMPANY_FXL.equalsIgnoreCase(semmco001Bean.getCompanyParam())) {
			
			reportId = "SEMECO003"; 
			
		}else if(AISConstant.COMPANY_AWN.equalsIgnoreCase(semmco001Bean.getCompanyParam())) {
			
			reportId = "SEMECO004";
		
		}else {
			reportId = "SEMECO001";
		}
		
		//If page from SEMMCO005
		if(StringUtils.equalsIgnoreCase(page, "SEMMCO005") || StringUtils.equalsIgnoreCase(page, "SEMMCO004")){
			reportId = "SEMECO005";
		}
		
		setReportName(reportId);
		
		if (validate()) {
			try {
				param = new SEMECO001ReportParameter();
				String name = "";
				if(semmco004Bean != null && StringUtils.isNotEmpty(semmco004Bean.getGroupNumber())){
					name = semmco004Bean.getGroupNumber();
				}else{
					name = getSemmco001Bean().getContractNoParam().replace(" ","_");
				}
				reportWebHelper = (IReportWebHelper)JSFServiceFinderUtil.getInstance().getBean("reportWebHelper");
				
				//search data for check condition export docmosis file
//				eco001Exp = new Eco001ExpContract();
//				eco001Exp.setCONTRACT_NO(semmco001Bean.getContractIdParam());
//				eco001Exp.setCONTRACT_TYPE(semeco001Bean.getContractDocType());
				//criObj.
				criteria.put("PARAM_CONTRACT_ID", semmco001Bean.getContractIdParam());
				criteria.put("PARAM_CONTRACT_TYPE", semeco001Bean.getContractDocType());
//				param = (SEMECO001ReportParameter)genReportParameter(paramXML);
//				if (criteria!=null) {
//					domain = (SEMECO001Domain) semeco001ReportDao.execute(criteria);
//				}
			//	to = service.querySPList(EQueryName.SP_ECO001_EXP_CONTRACT_DOC.name, eco001Exp);
				
				
				param.setCONTRACT_ID(semmco001Bean.getContractIdParam());
				param.setCONTRACT_TYPE(semeco001Bean.getContractDocType());
				param.setReportEngine(ServiceConstants.REPORT_ENGINE_DOCMOSIS);
				log.debug("***[SEMECO001Action][runReport][param contract id : " + param.getCONTRACT_ID() + "]***");
				log.debug("***[SEMECO001Action][runReport][param contract type : " + param.getCONTRACT_TYPE() + "]***");
				
			
				String coverName = null;
				System.out.println("ContractDocType =: "+getSemeco001Bean().getContractDocType());
				if("01".equals(getSemeco001Bean().getContractDocType())){
					param.setCONTRACT_TYPE_OLD(getSemeco001Bean().getContractDocType());
					coverName = name+"_"+msg("rpt.name.co001.conRent")+"_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + new Random().nextInt(10000);
				}else{
					if("02".equals(getSemeco001Bean().getContractDocType())){
						param.setCONTRACT_TYPE_OLD(getSemeco001Bean().getContractDocType());
						coverName = name+"_"+msg("rpt.name.co001.conSer")+"_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + new Random().nextInt(10000);
					}else{
						if("03".equals(getSemeco001Bean().getContractDocType())){
							param.setCONTRACT_TYPE_OLD(getSemeco001Bean().getContractDocType());
							coverName = name+"_"+msg("rpt.name.co001.conRenSer")+"_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + new Random().nextInt(10000);
						}else{
							if("04".equals(getSemeco001Bean().getContractDocType())){
								param.setCONTRACT_TYPE_OLD(getSemeco001Bean().getContractDocType());
								coverName = name+"_"+msg("rpt.name.co001.conRenSer")+"_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + new Random().nextInt(10000);
							}else{
								if("05".equals(getSemeco001Bean().getContractDocType())){
									if (StringUtils.isNotEmpty(reportId)) {
										param.setCONTRACT_TYPE_OLD(getSemeco001Bean().getContractDocType());
										domain = reportWebHelper.exportReport(reportId, param);
										if(domain != null){
											//check pay electric rental only 
											if(!"02".equals(domain.getRENT_COND_TYPE()) && "Y".equals(domain.getRENT_ELECTRIC_INTRO_FLAG())){
												param.setCONTRACT_TYPE("09");
											}
											//check did'n have pay 
											if(!"02".equals(domain.getRENT_COND_TYPE()) && "00".equals(domain.getHEADER_RENT_FLAG())){
												param.setCONTRACT_TYPE("11");
											}
											
										}
									}
									coverName = name+"_"+msg("rpt.name.co001.conRent.PICO")+"_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + new Random().nextInt(10000);
								}else{
	//								if("05".equals(getSemeco001Bean().getContractDocType())){
	//									coverName = name+"_"+msg("rpt.name.co001.con.microRepeater")+"_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + new Random().nextInt(10000);
	//								}
									if("06".equals(getSemeco001Bean().getContractDocType())){
										if (StringUtils.isNotEmpty(reportId)) {
											param.setCONTRACT_TYPE_OLD(getSemeco001Bean().getContractDocType());
											domain = reportWebHelper.exportReport(reportId, param);
											if(domain != null){
												//check pay electric rental only 
												if(!"02".equals(domain.getRENT_COND_TYPE()) && "Y".equals(domain.getELECTRIC_INTRO_FLAG())){
													param.setCONTRACT_TYPE("10");
												}
												
												//check did'n have pay 
												if(!"02".equals(domain.getRENT_COND_TYPE()) && "00".equals(domain.getHEADER_SERVICE_FLAG())){
													param.setCONTRACT_TYPE("12");
												}
											}
										}
//										param.setCONTRACT_TYPE_OLD(getSemeco001Bean().getContractDocType());
										coverName = name+"_"+msg("rpt.name.co001.conSer.PICO")+"_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + new Random().nextInt(10000);
									}else{
										if("07".equals(getSemeco001Bean().getContractDocType())){
											if (StringUtils.isNotEmpty(reportId)) {
												param.setCONTRACT_TYPE_OLD(getSemeco001Bean().getContractDocType());
												domain = reportWebHelper.exportReport(reportId, param);
												if(domain != null){
													//check pay electric rental only 
													if(!"02".equals(domain.getRENT_COND_TYPE()) && "Y".equals(domain.getRENT_ELECTRIC_INTRO_FLAG())){
														param.setCONTRACT_TYPE("09");
													}
													//check did'n have pay 
													if(!"02".equals(domain.getRENT_COND_TYPE()) && "00".equals(domain.getHEADER_RENT_FLAG())){
														param.setCONTRACT_TYPE("11");
													}
												}
											}
//											param.setCONTRACT_TYPE_OLD(getSemeco001Bean().getContractDocType());
											coverName = name+"_"+msg("rpt.name.co001.conRent.WIFI")+"_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + new Random().nextInt(10000);
										}else{
											if("08".equals(getSemeco001Bean().getContractDocType())){
												if (StringUtils.isNotEmpty(reportId)) {
													param.setCONTRACT_TYPE_OLD(getSemeco001Bean().getContractDocType());
													domain = reportWebHelper.exportReport(reportId, param);
													if(domain != null){
														//check pay electric rental only 
														if(!"02".equals(domain.getRENT_COND_TYPE()) && "Y".equals(domain.getELECTRIC_INTRO_FLAG())){
															param.setCONTRACT_TYPE("10");
														}
														//check did'n have pay 
														if("00".equals(domain.getHEADER_SERVICE_FLAG())){
															param.setCONTRACT_TYPE("12");
														}
													}
												}
//												param.setCONTRACT_TYPE_OLD(getSemeco001Bean().getContractDocType());
												coverName = name+"_"+msg("rpt.name.co001.conSer.WIFI")+"_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + new Random().nextInt(10000);
											}else 
												if("09".equals(getSemeco001Bean().getContractDocType())){
												   if (StringUtils.isNotEmpty(reportId)) {
													param.setCONTRACT_TYPE_OLD(getSemeco001Bean().getContractDocType());
													domain = reportWebHelper.exportReport(reportId, param);
													if(domain != null){
														//check pay electric rental only 
//														if(!"02".equals(domain.getRENT_COND_TYPE()) && "Y".equals(domain.getELECTRIC_INTRO_FLAG())){
//															param.setCONTRACT_TYPE("10");
//														}
//														//check did'n have pay 
//														if("00".equals(domain.getHEADER_RENT_FLAG())){
//															param.setCONTRACT_TYPE("12");
//														}
														param.setCONTRACT_TYPE("15");
													}
												}
//												param.setCONTRACT_TYPE_OLD(getSemeco001Bean().getContractDocType());
												coverName = name+"_"+msg("rpt.name.co001.conRent.SC")+"_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + new Random().nextInt(10000);
											}else 
												if("10".equals(getSemeco001Bean().getContractDocType())){
												  if (StringUtils.isNotEmpty(reportId)) {
													  param.setCONTRACT_TYPE_OLD(getSemeco001Bean().getContractDocType());
													domain = reportWebHelper.exportReport(reportId, param);
													if(domain != null){
														//check pay electric rental only 
//														if(!"02".equals(domain.getRENT_COND_TYPE()) && "Y".equals(domain.getELECTRIC_INTRO_FLAG())){
//															param.setCONTRACT_TYPE("10");
//														}
//														//check did'n have pay 
//														if("00".equals(domain.getHEADER_RENT_FLAG())){
//															param.setCONTRACT_TYPE("12");
//														}
														param.setCONTRACT_TYPE("14");
													}
												}
//												  param.setCONTRACT_TYPE_OLD(getSemeco001Bean().getContractDocType());
												coverName = name+"_"+msg("rpt.name.co001.conSer.SC")+"_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + new Random().nextInt(10000);
											}
										}
									}
								}
							}
						}	
					}
				}
				System.out.println("CONTRACT_TYPE := "+param.getCONTRACT_TYPE());
				if (StringUtils.isNotEmpty(reportId)) {
					log.debug("***[SEMECO001Action][runReport][process exportReport]***");
					filePath = reportWebHelper.exportReport(reportId, 
							param, getSemeco001Bean().getReportType(),coverName);
				}
				log.debug("test filePath : "+filePath);
			} catch (Exception e) {
				log.error("RUN REPORT ERROR IN " + getClass() +  " : " + e);
				e.printStackTrace();
			} finally {
				param = null;
				criteria = null;
				if (filePath != null) {
					try {
						contractFileService = (IContractFileService)JSFServiceFinderUtil.getInstance().getBean("contractFileService");
						contractFile = new ContractFile();
						contractFile.setContractId(semmco001Bean.getContractIdParam());
						contractFile.setContractDocType(semeco001Bean.getContractDocType());
						contractFile.setFilePath(filePath);
						contractFile.setFileName(filePath.substring(filePath.lastIndexOf(DataUtil.separator4OS()) + 1, filePath.lastIndexOf(".")));					
						contractFile.setCurrentUser(getUserLogIn());
						contractFileService.createContractFile(contractFile);
						
					} catch (Exception e) {
						log.error("RUN REPORT ERROR IN " + getClass() +  " : " + e);
					}
				}
				semmco001Bean2 = null;
				semmco001Bean = null; 
				semmco005Bean = null;
				semmco004Bean = null;
				semeco001Bean = null;
				reportWebHelper = null;
				contractFileService = null;
				contractFile = null;
				param = null;
				filePath = null;
				page = null;
				service = null;
				to = null;
				eco001Exp = null;
				criteria = null;
				criObj = null;
				domain = null;
				semeco003ReportService = null;
				semeco001ReportDao = null;
			}
		}
	}
	
	@Override
	public void showReport() {
		if (StringUtils.isNotEmpty(reportName)) {
			super.showReport(reportName, getSemeco001Bean().getReportType());
		}
	}

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		
		if(methodWithNavi.equalsIgnoreCase("doRunReport")){
			runReport();
		}else if (methodWithNavi.equalsIgnoreCase("doRunReportNew")) {
			doRunReportNew();
		} else if (methodWithNavi.equalsIgnoreCase("doShowReport")) {
			showReport();
		}
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {

	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	@Override
	public boolean validate() {
		boolean flgValid = true;
		getSemmco001Bean().setRenderedMsgFormSearch(true);
		
		if (StringUtils.isEmpty(getSemeco001Bean().getContractDocType())) {
			addMessageError("W0001", msg("message.contractDocType"));
			flgValid = false;
		}
		
		return flgValid;
	}
	
	
	public boolean validateReportNew() {
		boolean flgValid = true;
		getSemmco001Bean().setRenderedMsgFormSearch(true);
		
		if (StringUtils.isEmpty(getSemeco001Bean().getContractDocTypeNew())) {
			addMessageError("W0001", msg("message.contractDocType")+" New");
			flgValid = false;
		}
		
		return flgValid;
	}

	
	public void doRunReportNew() {
		log.debug("***[SEMECO001Action][runReport]***");
		semmco001Bean = getSemmco001Bean();
		semeco001Bean = getSemeco001Bean();
		IReportWebHelper reportWebHelper = null;
		IContractFileService contractFileService = null;
		ContractFile contractFile = null;
		SEMECO001ReportParameter param = new SEMECO001ReportParameter();
		Mco007ReportParam mco007ReportParam = new Mco007ReportParam();
		String filePath = null;
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		List<Mco007ReportParam> to = new ArrayList<Mco007ReportParam>();
		HashMap paramReport = null;
		mco007ReportParam.setRowId(rowId);
		Object obj = new Object();
		SEMECO007Domain semeco007Domain = new SEMECO007Domain();
//		semmco001Bean.setMsa003ReportParam(msa003ReportParam);
//		semmco001Bean.setDisplayBtn(false);
//		semmco001Bean.setRedirectFlag(false);
		setSemmco001Bean(semmco001Bean);
		
		if (validateReportNew()) {
			try {
//				IRentalPaymentService service = (IRentalPaymentService)getBean("rentalPaymentService");
//				to = service.querySPList(EQueryName.Q_MSA003_REPORT_PARAM.name, getSemmco001Bean().getMsa003ReportParam());
//				log.debug("size [" + to.size() + "]");
				
				if(this.doReportTitleSrch()){
					if(this.doReportDetailSrch()){
						this.doReportRentalSrch();
						this.doReportELSrch();
						
						obj = semmco001Bean.getSemeco007Domain();
					}else{
						addMessageError("E0001");
						return;
					}
					
				}else{
					addMessageError("E0001");
					return;
				}
					
				reportId = "SEMECO007";
				setReportName(reportId);
				param = new SEMECO001ReportParameter();
				
				
				String name = "";
//				if(semmco001Bean != null && StringUtils.isNotEmpty(semmco001Bean.getGroupNumber())){
//					name = semmco001Bean.getGroupNumber();
//				}else{
					name = getSemmco001Bean().getContractNoParam().replace(" ","_");
//				}
//					log.debug("Report name : " +name);
				
				reportWebHelper = (IReportWebHelper)JSFServiceFinderUtil.getInstance().getBean("reportWebHelper");
				
				
				param.setCONTRACT_ID(semmco001Bean.getContractIdParam());
				param.setCONTRACT_TYPE(semeco001Bean.getContractDocType());
				param.setReportEngine(ServiceConstants.REPORT_ENGINE_DOCMOSIS);
				log.debug("***[SEMECO001Action][runReportNew][param contract id : " + param.getCONTRACT_ID() + "]***");
				log.debug("***[SEMECO001Action][runReportNew][param contract type : " + param.getCONTRACT_TYPE() + "]***");
				
				String coverName = null;
//				log.debug("reqType : "+semmco001Bean.getMsa003ReportParam().getReqType());
				
				// edit for standard format coverName on 20210514
//				coverName = reportId+"_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+ "_" + new Random().nextInt(10000);
				coverName = name+"_"+msg("rpt.name.co001.conRent")+"_"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+"_"+new Random().nextInt(10000);
				
				System.out.println("CONTRACT_TYPE := "+param.getCONTRACT_TYPE());
				if (StringUtils.isNotEmpty(reportId)) {
					log.debug("***[SEMECO001Action][runReportNew][process exportReport]***");
//					
//					filePath = reportWebHelper.exportReport(reportId, 
//							param, getSemeco001Bean().getReportType(),coverName);
					
					filePath = reportWebHelper.exportReport(reportId, 
							param, obj, getSemeco001Bean().getReportType(),coverName);
				}
				log.debug("test filePath : "+filePath);
			
		
			} catch (Exception e) {
				log.error("RUN REPORT ERROR IN " + getClass() +  " : " + e);
				e.printStackTrace();
			} finally {
				param = null;
//				criteria = null;
				if (filePath != null) {
					try {
						contractFileService = (IContractFileService)JSFServiceFinderUtil.getInstance().getBean("contractFileService");
						contractFile = new ContractFile();
						contractFile.setContractId(semmco001Bean.getContractIdParam());
						contractFile.setContractDocType(semeco001Bean.getContractDocTypeNew());
						contractFile.setFilePath(filePath);
						contractFile.setFileName(filePath.substring(filePath.lastIndexOf(DataUtil.separator4OS()) + 1, filePath.lastIndexOf(".")));					
						contractFile.setCurrentUser(getUserLogIn());
						contractFileService.createContractFile(contractFile);
						
					} catch (Exception e) {
						log.error("RUN REPORT ERROR IN " + getClass() +  " : " + e);
					}
				}
				semmco001Bean = null; 
//				semmco005Bean = null;
//				semmco004Bean = null;
				semeco001Bean = null;
				reportWebHelper = null;
				contractFileService = null;
				contractFile = null;
				param = null;
				filePath = null;
//				page = null;
//				service = null;
				to = null;
//				eco001Exp = null;
//				criteria = null;
//				criObj = null;
//				domain = null;
//				semeco007ReportService = null;
//				semeco001ReportDao = null;
			}
		}
	}
	
	public boolean doReportTitleSrch(){
		boolean flag = true;
		log.debug("####### Start SEMMCO007Action doReportTitleSrch #######");
		semmco001Bean = getSemmco001Bean();
		List<Mco007MasterContractSP> to = new ArrayList<Mco007MasterContractSP>();
		Mco007MasterContractSP paramObj = new Mco007MasterContractSP();
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			
			//set contractFormId 
			if(getSemeco001Bean().getContractDocTypeNew() != null){
				paramObj.setContractFormId(getSemeco001Bean().getContractDocTypeNew());
				paramObj.setContractId(semmco001Bean.getContractIdParam());
				paramObj.setRecordStatus("Y");
				paramObj.setUserId(getUserLogIn());
			
				to = service.querySPList(EQueryName.Q_MCO007_REPORT_TITLE_PARAM.name, paramObj);
				
				log.debug("size [" + to.size() + "]");
				
				if(to == null || to.isEmpty()){
					// set data not found message
					semmco001Bean.getSemeco007Domain().setMasterContractTitleSP(new Mco007MasterContractSP());
				}
				
				if(to != null && to.size() > 0){
					flag = true;
					
					semmco001Bean.getSemeco007Domain().setMasterContractTitleSP(new Mco007MasterContractSP());
					
					for (int i = 0; i < to.size(); i++) {
						Mco007MasterContractSP contObj = to.get(i);
						WrapperBeanObject<Mco007MasterContractSP> tmpWrapperBean = new WrapperBeanObject<Mco007MasterContractSP>();
						
//						if(contObj.getCreateDt() != null) {
//							contObj.setCreateDtStr(convertYearENtoTHStr(contObj.getCreateDt()));
//						}
//						if(contObj.getUpdateDt() != null){
////							siteInfo.setExpDate(convertYearENtoTH(siteInfo.getExpDate()));
//							contObj.setUpdateDtStr(convertYearENtoTHStr(contObj.getUpdateDt()));
//						}
//						
						tmpWrapperBean.setDataObj(contObj);
						tmpWrapperBean.setMessage("");
						tmpWrapperBean.setCheckBox(false);
						semmco001Bean.getSemeco007Domain().setMasterContractTitleSP(contObj);
						
					}
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error(" ##### Error SEMMCO001Action doReportTitleSrch : "+e);
			flag = false;
		}finally{
			setSemmco001Bean(semmco001Bean);
			log.debug("####### End SEMMCO001Action doReportTitleSrch #######");
		}
		return flag;
	}
	
	public boolean doReportDetailSrch(){
		boolean flag = true;
		log.debug("####### Start SEMMCO001Action doReportDetailSrch #######");
		semmco001Bean = getSemmco001Bean();
		List<Mco007MasterContractSP> to = new ArrayList<Mco007MasterContractSP>();
		Mco007MasterContractSP paramObj = new Mco007MasterContractSP();
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			
			//set contractFormId 
			if(getSemeco001Bean().getContractDocTypeNew() != null){
				paramObj.setContractFormId(getSemeco001Bean().getContractDocTypeNew());
				paramObj.setContractId(semmco001Bean.getContractIdParam());
				paramObj.setRecordStatus("Y");
				paramObj.setUserId(getUserLogIn());
			
				to = service.querySPList(EQueryName.Q_MCO007_REPORT_DETAIL_PARAM.name, paramObj);
				
				log.debug("size [" + to.size() + "]");
				
				if(to == null || to.isEmpty()){
					// set data not found message
//					semmco007Bean.setRenderedMsgDataNotFound(true);
					semmco001Bean.getSemeco007Domain().setMasterContractDetailList(null);
				}
				
				if(to != null && to.size() > 0){
					flag = true;
					
					semmco001Bean.getSemeco007Domain().setMasterContractDetailList(new ArrayList<Mco007MasterContractSP>());
					
					for (int i = 0; i < to.size(); i++) {
						Mco007MasterContractSP contObj = to.get(i);
						WrapperBeanObject<Mco007MasterContractSP> tmpWrapperBean = new WrapperBeanObject<Mco007MasterContractSP>();
						
//						if(contObj.getCreateDt() != null) {
//							contObj.setCreateDtStr(convertYearENtoTHStr(contObj.getCreateDt()));
//						}
//						if(contObj.getUpdateDt() != null){
////							siteInfo.setExpDate(convertYearENtoTH(siteInfo.getExpDate()));
//							contObj.setUpdateDtStr(convertYearENtoTHStr(contObj.getUpdateDt()));
//						}
//						
						tmpWrapperBean.setDataObj(contObj);
						tmpWrapperBean.setMessage("");
						tmpWrapperBean.setCheckBox(false);
						semmco001Bean.getSemeco007Domain().getMasterContractDetailList().add(contObj);
						
					}
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error(" ##### Error SEMMCO001Action doReportDetailSrch : "+e);
			flag = false;
		}finally{
			setSemeco001Bean(semeco001Bean);
			log.debug("####### End SEMMCO001Action doReportDetailSrch #######");
		}
		return flag;
	}
	
	public boolean doReportRentalSrch(){
		boolean flag = true;
		log.debug("####### Start SEMMCO001Action doReportRentalSrch #######");
		semmco001Bean = getSemmco001Bean();
		List<Mco007MasterContractDetailSP> to = new ArrayList<Mco007MasterContractDetailSP>();
		Mco007MasterContractSP paramObj = new Mco007MasterContractSP();
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			
			//set contractFormId 
			if(getSemeco001Bean().getContractDocTypeNew() != null){
				paramObj.setContractFormId(getSemeco001Bean().getContractDocTypeNew());
				paramObj.setContractId(semmco001Bean.getContractIdParam());
				paramObj.setRecordStatus("Y");
				paramObj.setUserId(getUserLogIn());
			
				to = service.querySPList(EQueryName.Q_MCO007_REPORT_RENTAL_PARAM.name, paramObj);
				
				log.debug("size [" + to.size() + "]");
				
				if(to == null || to.isEmpty()){
					// set data not found message
//					semmco007Bean.setRenderedMsgDataNotFound(true);
					semmco001Bean.getSemeco007Domain().setMasterContractRentalList(null);
					semmco001Bean.getSemeco007Domain().setMasterContractRentalList(new ArrayList<Mco007MasterContractDetailSP>());
					
					Mco007MasterContractDetailSP contObj = new Mco007MasterContractDetailSP();
					semmco001Bean.getSemeco007Domain().getMasterContractRentalList().add(contObj);
				}
				
				if(to != null && to.size() > 0){
					flag = true;
					
					semmco001Bean.getSemeco007Domain().setMasterContractRentalList(new ArrayList<Mco007MasterContractDetailSP>());
					
					for (int i = 0; i < to.size(); i++) {
						Mco007MasterContractDetailSP contObj = to.get(i);
						WrapperBeanObject<Mco007MasterContractDetailSP> tmpWrapperBean = new WrapperBeanObject<Mco007MasterContractDetailSP>();
						
//						if(contObj.getCreateDt() != null) {
//							contObj.setCreateDtStr(convertYearENtoTHStr(contObj.getCreateDt()));
//						}
//						if(contObj.getUpdateDt() != null){
////							siteInfo.setExpDate(convertYearENtoTH(siteInfo.getExpDate()));
//							contObj.setUpdateDtStr(convertYearENtoTHStr(contObj.getUpdateDt()));
//						}
//						
						tmpWrapperBean.setDataObj(contObj);
						tmpWrapperBean.setMessage("");
						tmpWrapperBean.setCheckBox(false);
						semmco001Bean.getSemeco007Domain().getMasterContractRentalList().add(contObj);
						
					}
					
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error(" ##### Error SEMMCO001Action doReportRentalSrch : "+e);
			flag = false;
		}finally{
			setSemeco001Bean(semeco001Bean);
			log.debug("####### End SEMMCO001Action doReportRentalSrch #######");
		}
		return flag;
	}
	
	public boolean doReportELSrch(){
		boolean flag = true;
		log.debug("####### Start SEMMCO001Action doReportELSrch #######");
		semmco001Bean = getSemmco001Bean();
		List<Mco007MasterContractDetailSP> to = new ArrayList<Mco007MasterContractDetailSP>();
		Mco007MasterContractSP paramObj = new Mco007MasterContractSP();
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			
			//set contractFormId 
			if(getSemeco001Bean().getContractDocTypeNew() != null){
				paramObj.setContractFormId(getSemeco001Bean().getContractDocTypeNew());
				paramObj.setContractId(semmco001Bean.getContractIdParam());
				paramObj.setRecordStatus("Y");
				paramObj.setUserId(getUserLogIn());
			
				to = service.querySPList(EQueryName.Q_MCO007_REPORT_EL_PARAM.name, paramObj);
				
				log.debug("size [" + to.size() + "]");
				
				if(to == null || to.isEmpty()){
					// set data not found message
//					semmco007Bean.setRenderedMsgDataNotFound(true);
					semmco001Bean.getSemeco007Domain().setMasterContractELList(new ArrayList<Mco007MasterContractDetailSP>());
					
					Mco007MasterContractDetailSP contObj = new Mco007MasterContractDetailSP();
//					contObj.setElType("test EL TYPE");
					semmco001Bean.getSemeco007Domain().getMasterContractELList().add(contObj);
				}
				
				if(to != null && to.size() > 0){
					flag = true;
					
					semmco001Bean.getSemeco007Domain().setMasterContractELList(new ArrayList<Mco007MasterContractDetailSP>());
					
					for (int i = 0; i < to.size(); i++) {
						Mco007MasterContractDetailSP contObj = to.get(i);
						WrapperBeanObject<Mco007MasterContractDetailSP> tmpWrapperBean = new WrapperBeanObject<Mco007MasterContractDetailSP>();
						
//						if(contObj.getCreateDt() != null) {
//							contObj.setCreateDtStr(convertYearENtoTHStr(contObj.getCreateDt()));
//						}
//						if(contObj.getUpdateDt() != null){
////							siteInfo.setExpDate(convertYearENtoTH(siteInfo.getExpDate()));
//							contObj.setUpdateDtStr(convertYearENtoTHStr(contObj.getUpdateDt()));
//						}
//						
						tmpWrapperBean.setDataObj(contObj);
						tmpWrapperBean.setMessage("");
						tmpWrapperBean.setCheckBox(false);
						semmco001Bean.getSemeco007Domain().getMasterContractELList().add(contObj);
						
					}
					
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error(" ##### Error SEMMCO001Action doReportELSrch : "+e);
			flag = false;
		}finally{
			setSemeco001Bean(semeco001Bean);
			log.debug("####### End SEMMCO001Action doReportELSrch #######");
		}
		return flag;
	}

}