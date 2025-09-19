package th.co.ais.rpt.resource;

import th.co.ais.rpt.exception.ReportServiceException;
import th.co.ais.rpt.util.JasperUtil;




public class JasperFileResource extends org.springframework.core.io.FileSystemResource {
	
	public JasperFileResource(String fileName) throws ReportServiceException {
		super(JasperUtil.getJasperPath() + fileName);
	}
	
}
