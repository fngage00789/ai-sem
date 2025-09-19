package th.co.ais.rpt.resource;

import th.co.ais.rpt.exception.ReportServiceException;
import th.co.ais.rpt.util.DocmosisUtil;




public class DocmosisFileResource extends org.springframework.core.io.FileSystemResource {
	
	public DocmosisFileResource(String fileName) throws ReportServiceException {
		super(DocmosisUtil.getDocmosisReportPath()+ fileName);
	}
	
}
