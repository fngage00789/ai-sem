package th.co.ais.service.impl.report;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.xml.transform.stream.StreamSource;

import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRTextExporter;
import net.sf.jasperreports.engine.export.JRTextExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsAbstractExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

import org.apache.log4j.Logger;

import th.co.ais.rpt.domain.SEMECO001Domain;
import th.co.ais.rpt.exception.ReportServiceException;
import th.co.ais.rpt.parameter.ReportParameter;
import th.co.ais.rpt.parameter.SEMRRT012ReportParameter;
import th.co.ais.rpt.parameter.SEMRRT020ReportParameter;
import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.service.impl.rpt.ReportService;

import com.docmosis.template.store.TemplateIdentifier;

/**
 * @author Warawit Kitmongkonsak
 * 
 */
@SuppressWarnings("unchecked")
public class SEMRRT020ReportService extends ReportService {
	private static Logger log =Logger.getLogger(SEMRRT020ReportService.class);
	private String[] sheetName;
	
	public JasperPrint execute(ReportParameter param) throws ReportServiceException {
		JasperPrint jasperPrint = null;
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			jasperPrint = JasperFillManager.fillReport(jasperReport, ((SEMRRT020ReportParameter)param).getReportParameter(), conn);
			sheetName = (String[])((SEMRRT020ReportParameter)param).getReportParameter().get(JRXlsAbstractExporterParameter.SHEET_NAMES);
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
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
	
	public JasperPrint execute(String paramXML) throws ReportServiceException {
		JasperPrint jasperPrint = null;
		StreamSource ss = null;
		StringReader sr = null;
		SEMRRT020ReportParameter param = null;
		try {
			if(paramXML!=null){
				sr = new StringReader(paramXML);
				ss = new StreamSource(sr);
				param = (SEMRRT020ReportParameter)jibxUnMarshaller.unmarshal(ss);
				if(param!=null){
					jasperPrint = execute(param);
				}
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
	
	public String getReportName(){
		String reportName = null;
		reportName = "SEMRRT022" + "_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + new Random().nextInt(10000);
		return reportName;
	}
	
	public void export(JasperPrint jasperPrint, String destFile, String exportType) throws ReportServiceException {
		JRXlsExporter xlsExporter = null;
		JRCsvExporter csvExporter = null;
		JRTextExporter textExporter = null;
		JRHtmlExporter htmlExporter = null;
		JRExporter rtfExporter = null;

        try{
        	if(exportType.trim().equals(ServiceConstants.TYPE_PDF)){
				JasperExportManager.exportReportToPdfFile(jasperPrint, destFile);
			}else if(exportType.trim().equals(ServiceConstants.TYPE_XLS)){
				xlsExporter = new JRXlsExporter();
				xlsExporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
				xlsExporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME, destFile);
				xlsExporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
				xlsExporter.setParameter(JRXlsExporterParameter.IS_AUTO_DETECT_CELL_TYPE, Boolean.TRUE);
				xlsExporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
				xlsExporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
				xlsExporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, Boolean.TRUE);
				xlsExporter.setParameter(JRXlsAbstractExporterParameter.SHEET_NAMES,sheetName);
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

	public ByteArrayOutputStream view(JasperPrint jasperPrint, String exportType) throws ReportServiceException {
		JRXlsExporter xlsExporter = null;
		JRCsvExporter csvExporter = null;
		JRTextExporter textExporter = null;
		JRHtmlExporter htmlExporter = null;
		JRRtfExporter rtfExporter =  null ;
		
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
				xlsExporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, Boolean.TRUE);
				xlsExporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
				xlsExporter.setParameter(JRXlsAbstractExporterParameter.SHEET_NAMES,sheetName);
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

	@Override
	public String export(String paramXML,
			TemplateIdentifier templateIdentifier, String reportName)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReportParameter genReportParameter(String paramXML)
			throws ReportServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TemplateIdentifier prepareExecuteDocument() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] executeDocument(String paramXML,
			TemplateIdentifier templateIdentifier, String reportName)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
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
