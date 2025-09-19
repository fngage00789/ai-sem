package th.co.ais.service.impl.report;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.xml.transform.stream.StreamSource;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRTextExporter;
import net.sf.jasperreports.engine.export.JRTextExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.dao.rpt.jdbc.SEMECO001ReportDao;
import th.co.ais.dao.rpt.jdbc.SEMECO005ReportDao;
import th.co.ais.rpt.domain.SEMECO001Domain;
import th.co.ais.rpt.domain.SEMECO005Domain;
import th.co.ais.rpt.exception.ReportServiceException;
import th.co.ais.rpt.parameter.ReportParameter;
import th.co.ais.rpt.parameter.SEMECO001ReportParameter;
import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.rpt.util.ReadFileIntoByteArray;
import th.co.ais.rpt.util.SimpleDocmosisRenderer;
import th.co.ais.service.impl.rpt.ReportService;

import com.docmosis.document.DocumentProcessor;
import com.docmosis.document.converter.ConversionFormat;
import com.docmosis.document.converter.ConversionInstruction;
import com.docmosis.template.population.Cleanable;
import com.docmosis.template.population.DataProvider;
import com.docmosis.template.population.DataProviderBuilder;
import com.docmosis.template.population.DataProviderGrouping;
import com.docmosis.template.store.TemplateIdentifier;
import com.docmosis.util.FileUtilities;

/**
 * @author Warawit Kitmongkonsak
 * 
 */
public class SEMECO005ReportService extends ReportService<SEMECO005Domain> {
	private static Logger log =Logger.getLogger(SEMECO005ReportService.class);
	
	private SEMECO005ReportDao semeco005ReportDao;
	
	public void setSemeco005ReportDao(SEMECO005ReportDao semeco005ReportDao) {
		this.semeco005ReportDao = semeco005ReportDao;
	}

	public JasperPrint execute(ReportParameter param) throws ReportServiceException {
		JasperPrint jasperPrint = null;
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			jasperPrint = JasperFillManager.fillReport(jasperReport, ((SEMECO001ReportParameter)param).getReportParameter(), conn);
		} catch (Exception e) {
			log.error(e);
			throw new ReportServiceException("Fill Report ERROR!");
		} finally{
			try {
				if(conn!=null){
					conn.close();
				}	
			} catch (Exception e) {
				log.error(e);
			}
			conn = null;
		}
		return jasperPrint;
	}
	
	public byte[] executeDocument(String paramXML, TemplateIdentifier templateIdentifier, String reportName) throws Exception {
		FileOutputStream outputSteam = null;
		File file = null;
		byte[] bytes = null;
		String filePath = null;
		
		try {		
			filePath = export(paramXML, templateIdentifier, reportName);
			if (StringUtils.isNotEmpty(filePath)) {
				file = new File(filePath);
				if (file.exists()) {
					bytes = ReadFileIntoByteArray.getBytesFromFile(file);
				}
			}
		} catch (Exception e) {
			log.error(e);
		} finally{
			FileUtilities.close(outputSteam);
			FileUtilities.delete(file);
		}
		return bytes;
	}
	
	public JasperPrint execute(String paramXML) throws ReportServiceException {
		JasperPrint jasperPrint = null;
		SEMECO001ReportParameter param = null;
		try {
			param = (SEMECO001ReportParameter)genReportParameter(paramXML);
			if(param!=null){
				jasperPrint = execute(param);
			}
		} catch (Exception e) {
			if(e instanceof ReportServiceException){
				throw (ReportServiceException)e;
			}else{
				throw new ReportServiceException("JIBX ERROR!");
			}
		}finally{
			param = null;
		}
		return jasperPrint;
	}	

	public void prepareExecute() throws ReportServiceException {
		try {
			loadJasperReport();
		} catch (ReportServiceException e) {
			throw e;
		}		
	}
	
	public TemplateIdentifier prepareExecuteDocument() throws Exception {
		try {
			return loadDocmosisReport();
		} catch (Exception e) {
			throw e;
		}		
	}

	public String getReportName(){
		String reportName = null;
		reportName = "SEMECO001" + "_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + new Random().nextInt(10000);
		return reportName;
	}
	
	public void export(JasperPrint jasperPrint, String destFile, String exportType) throws ReportServiceException {
		JRXlsExporter xlsExporter = null;
		JRCsvExporter csvExporter = null;
		JRTextExporter textExporter = null;
		JRHtmlExporter htmlExporter = null;
		JRRtfExporter rtfExporter = null;
        try{
        	if(exportType.trim().equals(ServiceConstants.TYPE_PDF)){
				JasperExportManager.exportReportToPdfFile(jasperPrint, destFile);
			}else if(exportType.trim().equals(ServiceConstants.TYPE_XLS)){
				xlsExporter = new JRXlsExporter();
				xlsExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
				xlsExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, destFile);
				xlsExporter.exportReport();
			}else if(exportType.trim().equals(ServiceConstants.TYPE_CSV)){
				csvExporter = new JRCsvExporter();
				csvExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
				csvExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, destFile);
				csvExporter.exportReport();
			}else if(exportType.trim().equals(ServiceConstants.TYPE_TEXT)){
				textExporter = new JRTextExporter();
				textExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
				textExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, destFile);
				textExporter.setParameter(JRTextExporterParameter.CHARACTER_WIDTH, new Integer(5));
				textExporter.setParameter(JRTextExporterParameter.CHARACTER_HEIGHT, new Integer(15));
				textExporter.setParameter(JRTextExporterParameter.PAGE_WIDTH, new Integer(jasperPrint.getPageWidth()));
				textExporter.setParameter(JRTextExporterParameter.PAGE_HEIGHT, new Integer(jasperPrint.getPageHeight()));
				textExporter.exportReport(); 
			}else if(exportType.trim().equals(ServiceConstants.TYPE_HTML)){
				htmlExporter = new JRHtmlExporter();
				htmlExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
				htmlExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, destFile);
				htmlExporter.exportReport();
			}else if(exportType.equals(ServiceConstants.TYPE_DOC)){
				rtfExporter = new JRRtfExporter();
				rtfExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
				rtfExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, destFile);
				rtfExporter.exportReport();
			}
        }catch(Exception ex) {
        	log.error(ex);
            throw new ReportServiceException("ERROR IN Export Report!");
        }finally{
    		xlsExporter = null;
    		csvExporter = null;
    		textExporter = null;
    		htmlExporter = null;
        }
	}	


	public String export(String paramXML, TemplateIdentifier templateIdentifier, String reportName) throws Exception {
		DataProviderGrouping[] grouping = null;
		DataProvider provider = null;
		DataProviderBuilder providerBuilder = null;
		FileOutputStream outputSteam = null;
		SEMECO001ReportParameter param = null;
		SEMECO005Domain domain = null;
		
		try {
			param = (SEMECO001ReportParameter)genReportParameter(paramXML);
			if (param!=null) {
				domain = (SEMECO005Domain) semeco005ReportDao.execute(param.getReportParameter());
				
				ConversionInstruction instruction = new ConversionInstruction();
				instruction.setConversionFormats(new ConversionFormat[]{
						ConversionFormat.FORMAT_WORD,
				});
				instruction.setRenderer("simRenderer", SimpleDocmosisRenderer.getInstance());
				
//				if(StringUtils.isNotEmpty(domain.getSERVICE_PAY_PERIOD_TYPE_NAME())){
//					domain.setPERIOD_TYPE_PER(domain.getSERVICE_PAY_PERIOD_TYPE_NAME().replace("\u0E23\u0E32\u0E22", ""));
//				}
				// check is person
				try{
					if(domain.getOWNER_NAME() != null){
						String prefixName = domain.getOWNER_NAME().split(" ")[0];
						if(StringUtils.isNotEmpty(prefixName)){
							if("\u0E19\u0E32\u0E22".equals(prefixName.substring(0, 3)) ||
							   "\u0E19\u0E32\u0E07".equals(prefixName.substring(0, 3)) ||
							   "\u0E04\u0E38\u0E13".equals(prefixName.substring(0, 3)) ||
							   "\u0E19\u0E32\u0E07\u0E2A\u0E32\u0E27".equals(prefixName.substring(0, 6))){
								domain.setIS_PERSON(true);
							}else{
								domain.setIS_PERSON(false);
							}
						}
					}
				}catch(IndexOutOfBoundsException out){}
				
				try{
					if(StringUtils.isNotEmpty(domain.getSIGN_NAME())){
						String s = domain.getSIGN_NAME().split(" ")[domain.getSIGN_NAME().split(" ").length - 1];
						if("\u0E43\u0E19\u0E10\u0E32\u0E19\u0E30".indexOf(s.substring(0,6)) != -1 ||
						   "\u0E01\u0E23\u0E23\u0E21\u0E01\u0E32\u0E23".indexOf(s.substring(0,7)) != -1 || 
						   "\u0E40\u0E08\u0E49\u0E32\u0E21\u0E23\u0E14\u0E01".indexOf(s.substring(0,8)) != -1 ||
						   "\u0E1C\u0E39\u0E49\u0E08\u0E31\u0E14\u0E01\u0E32\u0E23".indexOf(s.substring(0,9)) != -1 ||
						   "\u0E1C\u0E39\u0E49\u0E2D\u0E33\u0E19\u0E27\u0E22\u0E01\u0E32\u0E23".indexOf(s.substring(0,11)) != -1 ||
						   "\u0E40\u0E08\u0E49\u0E32\u0E2D\u0E32\u0E27\u0E32\u0E2A\u0E27\u0E31\u0E14".indexOf(s.substring(0,12)) != -1 ||
						   "\u0E1C\u0E39\u0E49\u0E08\u0E31\u0E14\u0E01\u0E32\u0E23\u0E21\u0E23\u0E14\u0E01".indexOf(s.substring(0,13)) != -1 ||
						   "\u0E1C\u0E39\u0E49\u0E23\u0E31\u0E1A\u0E21\u0E2D\u0E1A\u0E2D\u0E33\u0E19\u0E32\u0E08".indexOf(s.substring(0,14)) != -1 ||
						   "\u0E1C\u0E39\u0E49\u0E41\u0E17\u0E19\u0E42\u0E14\u0E22\u0E0A\u0E2D\u0E1A\u0E18\u0E23\u0E23\u0E21".indexOf(s.substring(0,16)) != -1 ||
						   "\u0E01\u0E23\u0E23\u0E21\u0E01\u0E32\u0E23\u0E1C\u0E39\u0E49\u0E08\u0E31\u0E14\u0E01\u0E32\u0E23".indexOf(s.substring(0,16)) != -1 ||
						   "\u0E2B\u0E38\u0E49\u0E19\u0E2A\u0E48\u0E27\u0E19\u0E1C\u0E39\u0E49\u0E08\u0E31\u0E14\u0E01\u0E32\u0E23".indexOf(s.substring(0,17)) != -1 ||
						   "\u0E01\u0E23\u0E23\u0E21\u0E01\u0E32\u0E23\u0E1C\u0E39\u0E49\u0E21\u0E35\u0E2D\u0E33\u0E19\u0E32\u0E08\u0E25\u0E07\u0E19\u0E32\u0E21".indexOf(s.substring(0,22)) != -1 
						){
							domain.setSIGN_NAME(domain.getSIGN_NAME().substring(0,domain.getSIGN_NAME().indexOf(s)));
						}
					}
				}catch(IndexOutOfBoundsException out){}
				
				try{
					if(StringUtils.isNotEmpty(domain.getLESSOR_ADDR())){
						if(domain.getLESSOR_ADDR().substring(0,6).indexOf("\u0E40\u0E25\u0E02\u0E17\u0E35\u0E48") != -1){
							domain.setLESSOR_ADDR(domain.getLESSOR_ADDR().substring(6).trim());
						}
					}
				}catch(IndexOutOfBoundsException out){}
				
				try{
					if(StringUtils.isNotEmpty(domain.getSITE_ADDR())){
						if(domain.getSITE_ADDR().substring(0,6).indexOf("\u0E40\u0E25\u0E02\u0E17\u0E35\u0E48") != -1){
							domain.setSITE_ADDR(domain.getSITE_ADDR().substring(6).trim());
						}
					}
				}catch(IndexOutOfBoundsException out){}
		
//				if ((StringUtils.isNotEmpty(domain.getELETRIC_TYPE_1()) && "Y".equals(domain.getELETRIC_TYPE_1()))
//						|| (StringUtils.isNotEmpty(domain.getELETRIC_TYPE_2()) && "Y".equals(domain.getELETRIC_TYPE_2()))) {
//					domain.setS_ELECTIRC_TYPE_01("T");
//				} 
//				else{
//					domain.setS_ELECTIRC_TYPE_01("F");
//				}
				
				if(StringUtils.isNotEmpty(domain.getLESSOR_ADDR())){
					int index = domain.getLESSOR_ADDR().lastIndexOf("\u0E2D\u0E33\u0E40\u0E20\u0E2D");
					if(index != -1){
					  domain.setLESSOR_ADS_AMPHER(domain.getLESSOR_ADDR().substring(0,index-1));
					  domain.setLESSOR_ADS_PROV(domain.getLESSOR_ADDR().substring(index));
					}else{
						index = domain.getLESSOR_ADDR().lastIndexOf("\u0E40\u0E02\u0E15");
						if(index != -1){
							domain.setLESSOR_ADS_AMPHER(domain.getLESSOR_ADDR().substring(0,index-1));
							domain.setLESSOR_ADS_PROV(domain.getLESSOR_ADDR().substring(index));
						}else{
							domain.setLESSOR_ADS_AMPHER(domain.getLESSOR_ADDR());
						}
					}
				}
				
				providerBuilder = new DataProviderBuilder();
				providerBuilder.addAll(param.getReportParameter());
				providerBuilder.addJavaObject(domain, "obj");
				provider = providerBuilder.getDataProvider();
				
				DocumentProcessor.renderDoc(templateIdentifier, provider, instruction, new FileOutputStream(new File(reportName)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		} finally{
			FileUtilities.close(outputSteam);
			if (provider instanceof Cleanable) {
				((Cleanable)provider).cleanup();
			}
		}
		return reportName;
	}
	
	public ByteArrayOutputStream view(JasperPrint jasperPrint, String exportType) throws ReportServiceException {
		JRXlsExporter xlsExporter = null;
		JRCsvExporter csvExporter = null;
		JRTextExporter textExporter = null;
		JRHtmlExporter htmlExporter = null;
		JRRtfExporter rtfExporter = null;
		ByteArrayOutputStream outputStream = null;
        try{
        	outputStream = new ByteArrayOutputStream();
			if(exportType.equals(ServiceConstants.TYPE_PDF)){
				outputStream.write(JasperExportManager.exportReportToPdf(jasperPrint));
			}else if(exportType.equals(ServiceConstants.TYPE_XLS)){
				xlsExporter = new JRXlsExporter();
				xlsExporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
				xlsExporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, outputStream);
				xlsExporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
				xlsExporter.setParameter(JRXlsExporterParameter.IS_AUTO_DETECT_CELL_TYPE, Boolean.TRUE);
				xlsExporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
				xlsExporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
				xlsExporter.exportReport();
				
			}else if(exportType.equals(ServiceConstants.TYPE_CSV)){
				csvExporter = new JRCsvExporter();
				csvExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
				csvExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
				csvExporter.exportReport();
			}else if(exportType.equals(ServiceConstants.TYPE_TEXT)){
				textExporter = new JRTextExporter();
				textExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
				textExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
				textExporter.setParameter(JRTextExporterParameter.CHARACTER_WIDTH, new Integer(5));
				textExporter.setParameter(JRTextExporterParameter.CHARACTER_HEIGHT, new Integer(15));
				textExporter.setParameter(JRTextExporterParameter.PAGE_WIDTH, new Integer(jasperPrint.getPageWidth()));
				textExporter.setParameter(JRTextExporterParameter.PAGE_HEIGHT, new Integer(jasperPrint.getPageHeight()));
				textExporter.exportReport(); 
			}else if(exportType.equals(ServiceConstants.TYPE_HTML)){
				htmlExporter = new JRHtmlExporter();
				htmlExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
				htmlExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
				htmlExporter.exportReport();
			}else if(exportType.equals(ServiceConstants.TYPE_DOC)){
				rtfExporter = new JRRtfExporter();
				rtfExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
				rtfExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
				rtfExporter.exportReport();
			}
			
        }catch(Exception ex) {
        	log.error(ex);
            throw new ReportServiceException("ERROR IN View Report!");
        }finally{
    		xlsExporter = null;
    		csvExporter = null;
    		textExporter = null;
    		htmlExporter = null;
        }
        return outputStream;
	}
	
	public ReportParameter genReportParameter(String paramXML) throws ReportServiceException {
		StreamSource ss = null;
		StringReader sr = null;
		SEMECO001ReportParameter param = null;
		try {
			if(paramXML!=null){
				sr = new StringReader(paramXML);
				ss = new StreamSource(sr);
				param = (SEMECO001ReportParameter)jibxUnMarshaller.unmarshal(ss);
			}			
		} catch (Exception e) {
			if(e instanceof ReportServiceException){
				throw (ReportServiceException)e;
			}else{
				throw new ReportServiceException("JIBX ERROR!");
			}
		}finally{
			ss = null;
			sr = null;
		}
		return param;
	}

	@Override
	public SEMECO001Domain export(String paramXML,
			TemplateIdentifier templateIdentifier) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String export(String paramXML,
			TemplateIdentifier templateIdentifier, String filePath, Object obj)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
