package th.co.ais.web.report.util;

import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;

import th.co.ais.rpt.domain.SEMECO001Domain;
import th.co.ais.rpt.manager.IReportServiceManager;
import th.co.ais.rpt.parameter.ReportParameter;
import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.rpt.web.util.IReportWebHelper;



public class ReportWebHelper implements IReportWebHelper {
	
	private Logger log = Logger.getLogger(ReportWebHelper.class);
	private IReportServiceManager reportService = null;

	public ReportWebHelper(){

	}

	public void setReportService(IReportServiceManager reportService) {
		this.reportService = reportService;
	}

	public String exportReport(String reportTypeId, Date jobSchedule, ReportParameter reportParameter, String requestBy, String reportExportType){
		String outputPage = null;
		try {
			reportService.createReportJob(reportTypeId, jobSchedule, reportParameter, requestBy, reportExportType);
			outputPage = "createReportJobComplete";
		} catch (Exception e) {
			log.error(null, e);
			outputPage = "createReportJobError";
		}
		return outputPage;
	}
	
	public String viewReport(String reportTypeId, ReportParameter param, String exportType){
		
        String outputPage = null;
		HttpServletResponse response = null;
        ServletOutputStream out = null;
        byte[] bytes = null;
        FacesContext faces = null;
        
        try{
        	bytes = reportService.viewReport(reportTypeId, param, exportType);
			
			if(bytes!=null){
				faces = FacesContext.getCurrentInstance();
				response =(HttpServletResponse)faces.getExternalContext().getResponse();
				out = response.getOutputStream();
				response.setContentLength(bytes.length); 
				
				if(ServiceConstants.TYPE_PDF.equals(exportType)){
					response.setHeader("Content-Disposition", "attachment; filename="+reportTypeId+".pdf");
					response.setContentType("application/pdf");
				}else if(ServiceConstants.TYPE_XLS.equals(exportType)){
					response.setHeader("Content-Disposition", "attachment; filename="+reportTypeId+".xls");
					response.setContentType("application/vnd.ms-excel");
				}else if(ServiceConstants.TYPE_CSV.equals(exportType)){
					response.setHeader("Content-Disposition", "attachment; filename="+reportTypeId+".csv");
				    response.setContentType("application/csv");
				}else if(ServiceConstants.TYPE_TEXT.equals(exportType)){
					response.setHeader("Content-Disposition", "attachment; filename="+reportTypeId+".txt");
					response.setContentType("application/text/html");
				}
				/*else if(ServiceConstants.TYPE_HTML.equals(exportType)){
					response.encodeUrl("http:\\localhost:7001/ReportWeb/report_management/payment/viewReportHTML.jsf");
					response.setHeader("Content-Disposition", "attachment; filename=viewReportHTML.html");
					response.setContentType("application/text/html");
				}*/
				
				out.write( bytes, 0, bytes.length );
				out.flush();
				out.close();
				outputPage = "viewReportComplete";
				faces.responseComplete();
			}
		//}
        }catch(Exception ex) {
            outputPage = "viewReportError";
        	log.error(null, ex);
        	Throwable t = ex;
        	try {
				while(t!=null){
					if(t instanceof org.springframework.transaction.UnexpectedRollbackException){
			            outputPage = "TRANSACTION_TIMEOUT";			
						break;
					}
					t = t.getCause();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
        }finally{
        	response = null;
            out = null;
            bytes = null;
            faces = null;
    		//byteArrayOutputStream = null;
        }
        return outputPage;
	}
	
	
	//Earth 30/07/2009
	public String loadReport(String reportTypeId, ReportParameter param, String exportType){
		
        String outputPage = null;
        byte[] bytes = null;
        
        try{
        	bytes = reportService.viewReport(reportTypeId, param, exportType);
        	
        	if (bytes != null && bytes.length>0) {
			   FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(ServiceConstants.DATA_INPUT_STREAM, bytes);
			   outputPage = "viewReportComplete";
			} else {
	            outputPage = "viewReportError";
			}
        } catch (Exception ex) {
        	log.error(null, ex);
            outputPage = "viewReportError";
            Throwable t = ex;
        	try {
				while (t!=null) {
					if(t instanceof org.springframework.transaction.UnexpectedRollbackException){
			            outputPage = "TRANSACTION_TIMEOUT";			
						break;
					}
					t = t.getCause();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
        }finally{
            bytes = null;
        }
        return outputPage;
	}

    //Earth 30/07/2009
	public void showReport(String reportTypeId, String exportType){
		
		HttpServletResponse response = null;
        ServletOutputStream out = null;
        byte[] bytes = null;
        FacesContext faces = null;;
        
        try{
        	bytes = (byte[])FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(ServiceConstants.DATA_INPUT_STREAM);
        	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(ServiceConstants.DATA_INPUT_STREAM);
			if(bytes != null && bytes.length > 0){
				faces = FacesContext.getCurrentInstance();
				response =(HttpServletResponse)faces.getExternalContext().getResponse();
				out = response.getOutputStream();
				response.setContentLength(bytes.length); 
				
				if(ServiceConstants.TYPE_PDF.equals(exportType)){
					response.setHeader("Content-Disposition", "attachment; filename="+reportTypeId+".pdf");
					response.setContentType("application/pdf");
				}else if(ServiceConstants.TYPE_XLS.equals(exportType)){
					response.setHeader("Content-Disposition", "attachment; filename="+reportTypeId+".xls");
					response.setContentType("application/vnd.ms-excel");
				}else if(ServiceConstants.TYPE_CSV.equals(exportType)){
					response.setHeader("Content-Disposition", "attachment; filename="+reportTypeId+".csv");
				    response.setContentType("application/csv");
				}else if(ServiceConstants.TYPE_TEXT.equals(exportType)){
					response.setHeader("Content-Disposition", "attachment; filename="+reportTypeId+".txt");
					response.setContentType("application/text/html");
				}else if(ServiceConstants.TYPE_DOC.equals(exportType)){
					response.setHeader("Content-Disposition", "attachment; filename="+reportTypeId+".doc");
					response.setContentType("application/msword");
				}
				out.write( bytes, 0, bytes.length );
				out.flush();
				out.close();
				faces.responseComplete();
			}
        }catch(Exception ex) {
        	log.error(null, ex);
        }finally{
        	response = null;
            out = null;
            bytes = null;
            faces = null;
        }
	}

	
	@Override
	public SEMECO001Domain exportReport(String reportServiceName, ReportParameter param) throws Exception{
		return exportReport(reportServiceName, param, 0);
	}
	
	public SEMECO001Domain exportReport(String reportServiceName, ReportParameter param,int paramObj) throws Exception{
		return reportService.exportReport(reportServiceName, param);
	}
	
	public String exportReport(String reportServiceName, ReportParameter param, String exportType) throws Exception{
		return exportReport(reportServiceName, param, exportType, null);
	}

	public String exportReport(String reportServiceName, ReportParameter param, String exportType,String coverName) throws Exception{
		return reportService.exportReport(reportServiceName, param, exportType, coverName);
	}
	
	//added by NEW
	public String exportReport(String reportServiceName, ReportParameter param, Object obj, String exportType,String coverName) throws Exception{
		return reportService.exportReport(reportServiceName, param, obj, exportType, coverName);
	}

	
	// added by.. YUT 2015/09/15
	@Override
	public String exportExcelMSA003(Map<String, Object> paramMap) throws DataAccessException, SQLException {
		String outputPage = null;
		byte[] bytes = null;
		bytes = reportService.prepareExportExcelMSA003(paramMap);
		
		if (bytes != null && bytes.length>0) {
		   FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(ServiceConstants.DATA_INPUT_STREAM, bytes);
		   outputPage = "viewReportComplete";
		} else {
            outputPage = "viewReportError";
		}
		
		return outputPage;
	}
	
}
