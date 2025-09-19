package th.co.ais.service.impl.rpt;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;

import javax.xml.transform.stream.StreamResult;



import net.sf.jasperreports.engine.JasperPrint;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.oxm.Marshaller;

import th.co.ais.rpt.domain.SEMECO001Domain;
import th.co.ais.rpt.exception.ReportServiceException;
import th.co.ais.rpt.parameter.ReportParameter;
import th.co.ais.rpt.service.IReportService;
import th.co.ais.rpt.service.IReportServiceHelper;
import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.rpt.util.DataUtil;
import th.co.ais.rpt.util.DocmosisUtil;
import th.co.ais.rpt.util.FolderZiper;
import th.co.ais.rpt.util.JasperUtil;

import com.docmosis.SystemManager;
import com.docmosis.template.store.TemplateIdentifier;
import com.docmosis.util.FileUtilities;


public class ReportServiceHelper implements IReportServiceHelper,
		BeanFactoryAware {

	private Logger log = Logger.getLogger(getClass());

	private BeanFactory factory;


	public void setBeanFactory(BeanFactory factory) throws BeansException {
		this.factory = factory;
	}
	
	private String genFileName(IReportService reportService, String exportType, ReportParameter param,String reportName) {
		StringBuffer fileName = null;
		String path = null;
		try {
			if(reportName == null){
				fileName = new StringBuffer(reportService.getReportName());
			}else{
				fileName = new StringBuffer(reportName);
			}
			fileName.append(".");
			if (exportType.equals(ServiceConstants.TYPE_PDF)) {
				fileName.append(ServiceConstants.TYPE_PDF);
			} else if (exportType.equals(ServiceConstants.TYPE_XLS)) {
				fileName.append(ServiceConstants.TYPE_XLS);
			} else if (exportType.equals(ServiceConstants.TYPE_CSV)) {
				fileName.append(ServiceConstants.TYPE_CSV);
			} else if (exportType.equals(ServiceConstants.TYPE_TEXT)) {
				fileName.append(ServiceConstants.TYPE_TEXT);
			} else if (exportType.equals(ServiceConstants.TYPE_HTML)) {
				fileName.append(ServiceConstants.TYPE_HTML);
			} else if (exportType.equals(ServiceConstants.TYPE_DOC)) {
				fileName.append(ServiceConstants.TYPE_DOC);
			} else if (exportType.equals(ServiceConstants.TYPE_ODT)) {
				fileName.append(ServiceConstants.TYPE_ODT);
			}
			
			if (param != null && ServiceConstants.REPORT_ENGINE_DOCMOSIS.equals(param.getReportEngine())) {
				path = DocmosisUtil.getExportPath(new Date());
			} else {
				path = JasperUtil.getExportPath(new Date());
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 

		return new File(path, fileName.toString()).getAbsolutePath();
	}
	
	private String genFileName(String reportName, ReportParameter param) {
		String path = null;
		try {
			if (param != null && ServiceConstants.REPORT_ENGINE_DOCMOSIS.equals(param.getReportEngine())) {
				path = DocmosisUtil.getExportPath(new Date());
			} else {
				path = JasperUtil.getExportPath(new Date());
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return new File(path, reportName).getAbsolutePath();
	}

	public String export(String reportServiceName, String paramXML,
			String exportType, String reportName) throws ReportServiceException {

		TemplateIdentifier templateIdentifier = null;
		ReportParameter param = null;
		JasperPrint jasperPrint = null;
		IReportService reportService = null;
		String filePath = null;
		String zipPath = null;
		String folderName = null;
		File file = null;
		String destZipFile = null;
		String separator = DataUtil.separator4OS();

		try {
			reportService = (IReportService) factory.getBean(reportServiceName
					+ ServiceConstants.BEAN_REPORT_SERVICE);
			param = reportService.genReportParameter(paramXML);
			if (reportName != null && !"".equals(reportName)) {
				filePath = genFileName(reportName, param);
			} else {
				filePath = genFileName(reportService, exportType, param,null);
			}
			
			if (param != null && ServiceConstants.REPORT_ENGINE_DOCMOSIS.equals(param.getReportEngine())) {
				if (!SystemManager.isInitialized()){
					SystemManager.initialise();
				}
				
				templateIdentifier = reportService.prepareExecuteDocument();
				if (StringUtils.isNotEmpty(paramXML)) {
					filePath = reportService.export(paramXML, templateIdentifier, filePath);
					file = new File(filePath);
					
					if (file.exists()) {
						if (file.length() <= 0) {
							FileUtilities.delete(file);
							file = null;
							filePath = null;
						}
					}
				}
			} else {
				reportService.prepareExecute(); 
				jasperPrint = reportService.execute(paramXML);
				// IF Export Type is html, Add Folder To Zip
				if (exportType.equals(ServiceConstants.TYPE_HTML)) {

					if (reportName == null || "".equals(reportName)) {
						reportName = filePath.substring(filePath
								.lastIndexOf(separator) + 1, filePath.length());
					}

					folderName = reportName.substring(0, reportName.lastIndexOf("."));
					zipPath = filePath.substring(0, filePath.lastIndexOf(separator) + 1) + folderName;
					destZipFile = filePath.substring(0, filePath.lastIndexOf(separator) + 1) + folderName + ".zip";
					filePath = filePath.substring(0, filePath.lastIndexOf(separator) + 1) + folderName + separator + reportName;

					log.debug("zipPath : " + zipPath);
					log.debug("destZipFile : " + destZipFile);
					log.debug("filePath : " + filePath);

					// Create Folder To Export By Report Name
					file = new File(zipPath);
					if (!file.exists()) {
						file.mkdirs();
					}
				}
				reportService.export(jasperPrint, filePath, exportType);

				// IF Export Type is html, Zip File
				if (exportType.equals(ServiceConstants.TYPE_HTML)) {
					FolderZiper.zipFolder(zipPath, destZipFile);
					try {
						FileUtils.deleteDirectory(new File(zipPath));
					} catch (IOException ioe) {
						ioe.printStackTrace();
					}				
					filePath = destZipFile;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			if (ex instanceof ReportServiceException) {
				throw (ReportServiceException) ex;
			} else {
				throw new ReportServiceException("Error In export helper!");
			}
		} finally {
//			if (SystemManager.isInitialized()) {
//				SystemManager.release();
//			}
			jasperPrint = null;
			reportService = null;
			zipPath = null;
			folderName = null;
			file = null;
			destZipFile = null;
			separator = null;
			templateIdentifier = null;
			param = null;
		}
		return filePath;
	}
	
	public String export(String reportServiceName, ReportParameter param,
			String exportType,String reportName) throws ReportServiceException {
		log.debug("***[ReportServiceHelper][export]***");
		TemplateIdentifier templateIdentifier = null;
		JasperPrint jasperPrint = null;
		IReportService reportService = null;
		File file = null;
		String filePath = null;
		String paramXML = null;
		
		try {
			reportService = (IReportService) factory.getBean(reportServiceName
					+ ServiceConstants.BEAN_REPORT_SERVICE);
			if(reportName == null){
				filePath = genFileName(reportService, exportType, param,null);
			}else{
				filePath = genFileName(reportService, exportType, param,reportName);
			}	
			log.debug("***[ReportServiceHelper][export][param reportEngine : " + param.getReportEngine() + "]***");
			if (param != null && ServiceConstants.REPORT_ENGINE_DOCMOSIS.equals(param.getReportEngine())) {
				log.debug("***[ReportServiceHelper][export][do initialise]***");
				if (!SystemManager.isInitialized()){
					SystemManager.initialise();
				}
				
				templateIdentifier = reportService.prepareExecuteDocument();
				paramXML = genParamXMl(reportServiceName,param);
				log.debug("***[ReportServiceHelper][export][paramXML : " + paramXML + "]***");
				if (StringUtils.isNotEmpty(paramXML)) {
					filePath = reportService.export(paramXML, templateIdentifier, filePath);
					file = new File(filePath);
									
					if (file.exists()) {
						if (file.length() <= 0) {
							FileUtilities.delete(file);
							file = null;
							filePath = null;
						}
					}
				}
				
			} else {
				log.debug("***[ReportServiceHelper][export][do jasper]***");
				reportService.prepareExecute();
				jasperPrint = reportService.execute(param);
				reportService.export(jasperPrint, filePath, exportType);
			}
		} catch (Exception ex) {
			if (ex instanceof ReportServiceException) {
				throw (ReportServiceException) ex;
			} else {
				throw new ReportServiceException("Error In export helper!");
			}
		} finally {
//			if (SystemManager.isInitialized()){
//				SystemManager.release();
//			}
			templateIdentifier = null;
			jasperPrint = null;
			reportService = null;
			paramXML = null;
			file = null;
		}
		return filePath;
	}
	
	//added by NEW
	public String export(String reportServiceName, ReportParameter param, Object obj,
			String exportType,String reportName) throws ReportServiceException {
		log.debug("***[ReportServiceHelper][export]***");
		TemplateIdentifier templateIdentifier = null;
		JasperPrint jasperPrint = null;
		IReportService reportService = null;
		File file = null;
		String filePath = null;
		String paramXML = null;
		
		try {
			reportService = (IReportService) factory.getBean(reportServiceName
					+ ServiceConstants.BEAN_REPORT_SERVICE);
			if(reportName == null){
				filePath = genFileName(reportService, exportType, param,null);
			}else{
				filePath = genFileName(reportService, exportType, param,reportName);
			}	
			log.debug("***[ReportServiceHelper][export][param reportEngine : " + param.getReportEngine() + "]***");
			if (param != null && ServiceConstants.REPORT_ENGINE_DOCMOSIS.equals(param.getReportEngine())) {
				log.debug("***[ReportServiceHelper][export][do initialise]***");
				if (!SystemManager.isInitialized()){
					SystemManager.initialise();
				}
				
				templateIdentifier = reportService.prepareExecuteDocument();
				paramXML = genParamXMl(reportServiceName,param);
				log.debug("***[ReportServiceHelper][export][paramXML : " + paramXML + "]***");
				if (StringUtils.isNotEmpty(paramXML)) {
					filePath = reportService.export(paramXML, templateIdentifier, filePath, obj);
					file = new File(filePath);
									
					if (file.exists()) {
						if (file.length() <= 0) {
							FileUtilities.delete(file);
							file = null;
							filePath = null;
						}
					}
				}
				
			} else {
				log.debug("***[ReportServiceHelper][export][do jasper]***");
				reportService.prepareExecute();
				jasperPrint = reportService.execute(param);
				reportService.export(jasperPrint, filePath, exportType);
			}
		} catch (Exception ex) {
			if (ex instanceof ReportServiceException) {
				throw (ReportServiceException) ex;
			} else {
				throw new ReportServiceException("Error In export helper!");
			}
		} finally {
//			if (SystemManager.isInitialized()){
//				SystemManager.release();
//			}
			templateIdentifier = null;
			jasperPrint = null;
			reportService = null;
			paramXML = null;
			file = null;
		}
		return filePath;
	}
	
	public SEMECO001Domain export(String reportServiceName, ReportParameter param) throws ReportServiceException {
		log.debug("***[ReportServiceHelper][export]***");
		TemplateIdentifier templateIdentifier = null;
		JasperPrint jasperPrint = null;
		IReportService reportService = null;
		File file = null;
		String filePath = null;
		String paramXML = null;
		SEMECO001Domain semeco001Domain = null;
		
		try {
			reportService = (IReportService) factory.getBean(reportServiceName
					+ ServiceConstants.BEAN_REPORT_SERVICE);
//			if(reportName == null){
//				filePath = genFileName(reportService, exportType, param,null);
//			}else{
//				filePath = genFileName(reportService, exportType, param,reportName);
//			}	
			log.debug("***[ReportServiceHelper][export][param reportEngine : " + param.getReportEngine() + "]***");
			if (param != null && ServiceConstants.REPORT_ENGINE_DOCMOSIS.equals(param.getReportEngine())) {
				log.debug("***[ReportServiceHelper][export][do initialise]***");
				if (!SystemManager.isInitialized()){
					SystemManager.initialise();
				}
				
				templateIdentifier = reportService.prepareExecuteDocument();
				paramXML = genParamXMl(reportServiceName,param);
				log.debug("***[ReportServiceHelper][export][paramXML : " + paramXML + "]***");
				if (StringUtils.isNotEmpty(paramXML)) {
					semeco001Domain = reportService.export(paramXML, templateIdentifier);
					//file = new File(filePath);
									
//					if (file.exists()) {
//						if (file.length() <= 0) {
//							FileUtilities.delete(file);
//							file = null;
//							filePath = null;
//						}
//					}
				}
				
			} else {
				log.debug("***[ReportServiceHelper][export][do jasper]***");
				reportService.prepareExecute();
				jasperPrint = reportService.execute(param);
//				reportService.export(jasperPrint, filePath, exportType);
			}
		} catch (Exception ex) {
			if (ex instanceof ReportServiceException) {
				throw (ReportServiceException) ex;
			} else {
				throw new ReportServiceException("Error In export helper!");
			}
		} finally {
//			if (SystemManager.isInitialized()){
//				SystemManager.release();
//			}
			templateIdentifier = null;
			jasperPrint = null;
			reportService = null;
			paramXML = null;
			file = null;
		}
		return semeco001Domain;
	}
	
	public byte[] view(String reportServiceName, ReportParameter param,
			String exportType) throws ReportServiceException {
		
		TemplateIdentifier templateIdentifier = null;
		JasperPrint jasperPrint = null;
		IReportService reportService = null;
		ByteArrayOutputStream outputStream = null;
		byte[] bytes = null;
		String paramXML = null;
		String filePath = null;

		try {
			reportService = (IReportService) factory.getBean(reportServiceName
					+ ServiceConstants.BEAN_REPORT_SERVICE);

			filePath = genFileName(reportService, exportType, param,null);
			log.info("*** report param.getReportEngine : " + param.getReportEngine() + " ***");
			if (param != null && ServiceConstants.REPORT_ENGINE_DOCMOSIS.equals(param.getReportEngine())) {
				log.info("*** do initialise ***");
				if (!SystemManager.isInitialized()){
					SystemManager.initialise();
				}
				
				templateIdentifier = reportService.prepareExecuteDocument();
				paramXML = genParamXMl(reportServiceName,param);
				if (paramXML != null) {
					bytes = reportService.executeDocument(paramXML, templateIdentifier, filePath);
				}
	
			} else {
				log.info("*** do jasper ***");
				reportService.prepareExecute();
				jasperPrint = reportService.execute(param);
				outputStream = reportService.view(jasperPrint, exportType);
				if (outputStream != null) {
					bytes = outputStream.toByteArray();
				}
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			if (ex instanceof ReportServiceException) {
				throw (ReportServiceException) ex;
			} else {
				throw new ReportServiceException("Error In view helper!");
			}
		} finally {
//			if (SystemManager.isInitialized()){
//				SystemManager.release();
//			}
			templateIdentifier = null;
			jasperPrint = null;
			reportService = null;
			outputStream = null;
		}
		return bytes;
	}
	
	public String genParamXMl(String reportServiceName,
			ReportParameter reportParameter) throws ReportServiceException {
		String paramXML = null;
		Marshaller jibxMarshaller = null;
		StringWriter sw = null;
		StreamResult sr = null;

		log.debug("reportServiceName = " + reportServiceName);
		log.debug("reportParameter = " + reportParameter.toString());

		try {
			jibxMarshaller = (Marshaller) factory.getBean(reportServiceName
					+ ServiceConstants.BEAN_REPORT_PARAMETER_MARSHALLER);
			sw = new StringWriter();
			sr = new StreamResult(sw);
			jibxMarshaller.marshal(reportParameter, sr);
			paramXML = sr.getWriter().toString();
		} catch (Exception e) {
			throw new ReportServiceException("Error gen ParamXML");
		} finally {
			jibxMarshaller = null;
			sw = null;
			sr = null;
		}
		return paramXML;
	}
	
}
