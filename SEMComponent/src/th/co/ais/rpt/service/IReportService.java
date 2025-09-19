package th.co.ais.rpt.service;

import java.io.ByteArrayOutputStream;

import net.sf.jasperreports.engine.JasperPrint;
import th.co.ais.rpt.domain.SEMECO001Domain;
import th.co.ais.rpt.exception.ReportServiceException;
import th.co.ais.rpt.parameter.ReportParameter;

import com.docmosis.template.store.TemplateIdentifier;

public interface IReportService {
	public abstract void prepareExecute() throws ReportServiceException;
	public abstract JasperPrint execute(ReportParameter param) throws ReportServiceException;
	public abstract JasperPrint execute(String paramXML) throws ReportServiceException;
	public abstract String getReportName();
	public abstract void export(JasperPrint jasperPrint, String destFile, String exportType) throws ReportServiceException;
	public abstract ByteArrayOutputStream view(JasperPrint jasperPrint, String exportType) throws ReportServiceException;
	public abstract TemplateIdentifier prepareExecuteDocument() throws Exception;
	public abstract String export(String paramXML, TemplateIdentifier templateIdentifier, String reportName) throws Exception;
	public abstract SEMECO001Domain export(String paramXML, TemplateIdentifier templateIdentifier) throws Exception;
	public abstract byte[] executeDocument(String paramXML, TemplateIdentifier templateIdentifier, String reportName) throws Exception;
	public abstract ReportParameter genReportParameter(String paramXML) throws ReportServiceException;
	public abstract String export(String paramXML,TemplateIdentifier templateIdentifier, String filePath, Object obj) throws Exception;
}
