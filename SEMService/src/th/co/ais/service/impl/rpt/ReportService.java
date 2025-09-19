package th.co.ais.service.impl.rpt;

import java.io.File;

import javax.sql.DataSource;

import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.log4j.Logger;
import org.springframework.core.io.Resource;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;

import th.co.ais.rpt.exception.ReportServiceException;
import th.co.ais.rpt.service.IReportService;
import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.rpt.util.DocmosisUtil;

import com.docmosis.template.store.DropStoreHelper;
import com.docmosis.template.store.TemplateContext;
import com.docmosis.template.store.TemplateIdentifier;
import com.docmosis.template.store.TemplateStoreFactory;

public abstract class ReportService<T> implements IReportService {
	public void setDocmosisFile(Resource docmosisFile) {
		this.docmosisFile = docmosisFile;
	}

	public Resource jasperFile;
	public DataSource dataSource;
	public Unmarshaller jibxUnMarshaller;
	public Marshaller jibxMarshaller;
	// load manual
	public JasperReport jasperReport;
	
	public Resource docmosisFile;
	public TemplateIdentifier templateIdentifier;
	
	private Logger log = Logger.getLogger(getClass());
	
	public void setJibxMarshaller(Marshaller jibxMarshaller) {
		this.jibxMarshaller = jibxMarshaller;
	}

	public void setJibxUnMarshaller(Unmarshaller jibxUnMarshaller) {
		this.jibxUnMarshaller = jibxUnMarshaller;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void setJasperFile(Resource jasperFile) {
		this.jasperFile = jasperFile;
	}

	protected void loadJasperReport() throws ReportServiceException{
		try {
			if(jasperReport==null){
				log.debug("jasper File : " + jasperFile.getFile());
				log.debug("jasper FileName : " + jasperFile.getFilename());
				jasperReport = ( JasperReport ) JRLoader.loadObject(jasperFile.getFile());	
			}				
		} catch (Exception e) {
			throw new ReportServiceException("Load JASPER FILE ERROR!");
		}		
	}
	
	protected TemplateIdentifier loadDocmosisReport(){
		try {
			if (templateIdentifier == null) {			
				log.debug("Docmosis Tempstore : " + ServiceConstants.TEMPSTORE_PROJECT_DIRECTORY);
				log.debug("Docmosis PathName : " + DocmosisUtil.getDocmosisReportPath());
				log.debug("Docmosis FileName : " + docmosisFile.getFilename());
				
				TemplateContext templateContext = new TemplateContext(ServiceConstants.TEMPSTORE_PROJECT_DIRECTORY);
				DropStoreHelper dropStoreHelper = new DropStoreHelper(TemplateStoreFactory.getStore());
				dropStoreHelper.process(new File(DocmosisUtil.getDocmosisReportPath()), templateContext);
				
				templateIdentifier = new TemplateIdentifier(docmosisFile.getFilename(), templateContext);
			}
			else{
				templateIdentifier = null;
//				if (templateIdentifier.equals("SEMProject")){
//					templateIdentifier = new TemplateIdentifier("SEMProject1");
//				}
//				String templateStr = templateIdentifier.toString();
//				int i = 0;
//				String tl = templateStr.substring(templateStr.length()-1);
				
				log.debug("Docmosis Tempstore : " + ServiceConstants.TEMPSTORE_PROJECT_DIRECTORY);
				log.debug("Docmosis PathName : " + DocmosisUtil.getDocmosisReportPath());
				log.debug("Docmosis FileName : " + docmosisFile.getFilename());
				
				TemplateContext templateContext = new TemplateContext(ServiceConstants.TEMPSTORE_PROJECT_DIRECTORY);
				DropStoreHelper dropStoreHelper = new DropStoreHelper(TemplateStoreFactory.getStore());
				dropStoreHelper.process(new File(DocmosisUtil.getDocmosisReportPath()), templateContext);
				
				templateIdentifier = new TemplateIdentifier(docmosisFile.getFilename(), templateContext);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return templateIdentifier;
	}
}
