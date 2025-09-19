package th.co.ais.service.impl.report;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.util.List;

import javax.xml.transform.stream.StreamSource;

import net.sf.jasperreports.engine.JasperPrint;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.docmosis.document.DocumentProcessor;
import com.docmosis.document.converter.ConversionFormat;
import com.docmosis.document.converter.ConversionInstruction;
import com.docmosis.template.population.Cleanable;
import com.docmosis.template.population.DataProvider;
import com.docmosis.template.population.DataProviderBuilder;
import com.docmosis.template.population.DataProviderGrouping;
import com.docmosis.template.store.TemplateIdentifier;
import com.docmosis.util.FileUtilities;

import th.co.ais.dao.rpt.jdbc.SEMECO001ReportDao;
import th.co.ais.dao.rpt.jdbc.SEMMSA003ReportDao;
import th.co.ais.domain.sa.SiteAppReportObj;
import th.co.ais.rpt.domain.SEMECO001Domain;
import th.co.ais.rpt.domain.SEMMSA003Domain;
import th.co.ais.rpt.exception.ReportServiceException;
import th.co.ais.rpt.parameter.ReportParameter;
import th.co.ais.rpt.parameter.SEMECO001ReportParameter;
import th.co.ais.rpt.parameter.SEMMEL008ReportParameter;
import th.co.ais.rpt.parameter.SEMMSA003ReportParameter;
import th.co.ais.rpt.util.SimpleDocmosisRenderer;
import th.co.ais.service.impl.rpt.ReportService;

public class SEMMSA003ReportService extends ReportService<SEMMSA003Domain>{
	
private static Logger log =Logger.getLogger(SEMMSA003ReportService.class);
	
	private SEMMSA003ReportDao semmsa003ReportDao;
	
	public void setSemmsa003ReportDao(SEMMSA003ReportDao semmsa003ReportDao) {
		this.semmsa003ReportDao = semmsa003ReportDao;
	}
	
	public String export(String paramXML, TemplateIdentifier templateIdentifier, String reportName) throws Exception {
		DataProviderGrouping[] grouping = null;
		DataProvider provider = null;
		DataProviderBuilder providerBuilder = null;
		FileOutputStream outputSteam = null;
		SEMMSA003ReportParameter param = null;
		SEMMSA003Domain domain = null;
		
		try {
			param = (SEMMSA003ReportParameter)genReportParameter(paramXML);
			if (param!=null) {
				domain = (SEMMSA003Domain) semmsa003ReportDao.execute(param.getReportParameter());
				
				String siteAppId = (String) param.getReportParameter().get("PARAM_CONTRACT_ID");
				String docType = (String) param.getReportParameter().get("PARAM_CONTRACT_TYPE");
				
//				domain.setRentalPaymentList((List<SiteAppReportObj>) semmsa003ReportDao.getPaymentList(siteAppId, "01"));
//				domain.setServicePaymentList((List<SiteAppReportObj>) semmsa003ReportDao.getPaymentList(siteAppId, "02"));
			
				ConversionInstruction instruction = new ConversionInstruction();
				instruction.setConversionFormats(new ConversionFormat[]{
						ConversionFormat.FORMAT_WORD,
				});
				instruction.setRenderer("simRenderer", SimpleDocmosisRenderer.getInstance());
				
				
				providerBuilder = new DataProviderBuilder();
				providerBuilder.addAll(param.getReportParameter());
				providerBuilder.addJavaObject(domain, "obj");
				provider = providerBuilder.getDataProvider();
				
				System.out.println("export getElPayOnPackageAmt = "+domain.getElPayOnPackageAmt());

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

	@Override
	public JasperPrint execute(ReportParameter param)
			throws ReportServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JasperPrint execute(String paramXML) throws ReportServiceException {
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
	public void export(JasperPrint jasperPrint, String destFile,
			String exportType) throws ReportServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ReportParameter genReportParameter(String paramXML)throws ReportServiceException {
		StreamSource ss = null;
		StringReader sr = null;
		SEMMSA003ReportParameter param = null;
		try {
			if(paramXML!=null){
				sr = new StringReader(paramXML);
				ss = new StreamSource(sr);
				param = (SEMMSA003ReportParameter)jibxUnMarshaller.unmarshal(ss);
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
	public String getReportName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void prepareExecute() throws ReportServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TemplateIdentifier prepareExecuteDocument() throws Exception {
		try {
			return loadDocmosisReport();
		} catch (Exception e) {
			throw e;
		}	
	}

	@Override
	public ByteArrayOutputStream view(JasperPrint jasperPrint, String exportType)
			throws ReportServiceException {
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
