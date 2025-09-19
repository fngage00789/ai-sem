package th.co.ais.web.report.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Date;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.rpt.util.JasperUtil;

public class ExportFileUtil{
	
	private final Logger log = Logger.getLogger(ExportFileUtil.class);
	private String fileName = null;
	private String filePath = null;
	
	public byte[] readFileContent(String fileNameParam, Date startDtParam){
		File file = null; 
        InputStream inputStream = null;
        byte[] bytes = null;
        long length = 0;
        int offset = 0;
        int numRead = 0;
        boolean isExits = false;
        
        
        try{
        	log.debug("Check Download File --> Read File Name : " + fileNameParam);
        	file = new File(fileNameParam);
        	if(log.isDebugEnabled()) {
        		log.debug("File === "+ file.getAbsolutePath() + "  :Exist:"+file.exists());
        	}
        	
        	isExits = file.exists();
        	if(!isExits){
        		bytes = null;
        	}else{
	        	inputStream = new FileInputStream(file);
	        	length = file.length();
	        	if (length > Integer.MAX_VALUE) {
	                // File is too large
	            }
	        	// Read in the bytes
	            bytes = new byte[(int)length];           
	            while (offset < bytes.length && (numRead=inputStream.read(bytes, offset, bytes.length-offset)) >= 0) {
	            	offset += numRead;
	            }        
	            // Ensure all the bytes have been read in
	            if (offset < bytes.length) {
	                throw new IOException("Could not completely read file "+file.getName());
	            }        
	            inputStream.close();   
        	}
        } catch (Exception e){
        	log.error("", e);
        } finally{
            file = null;
        }
        return bytes;
	}
	
	public String exportFile(String fileNameParam, byte[] bytes){
		HttpServletResponse response = null;
		FacesContext faces = null;
	    String contentType = null;
	    ServletOutputStream out = null;
	    //int contentLength = 0;

        try {     
        	log.debug("Check Download File --> Export File Name : " + fileNameParam);
        	faces = FacesContext.getCurrentInstance();
        	contentType = fileNameParam.substring(fileNameParam.lastIndexOf(".") + 1).trim();   
        	response =(HttpServletResponse)faces.getExternalContext().getResponse();
        	out = response.getOutputStream();
			response.setContentLength(bytes.length);
			if(fileName == null){
				if(fileNameParam.lastIndexOf("/") > 0){
					response.setHeader("Content-Disposition", "attachment; filename=\"" + fileNameParam.substring(fileNameParam.lastIndexOf("/") + 1, fileNameParam.length()));
				}else if(fileNameParam.lastIndexOf("\\") > 0)
					response.setHeader("Content-Disposition", "attachment; filename=\"" + fileNameParam.substring(fileNameParam.lastIndexOf("\\") + 1, fileNameParam.length()));
//				response.setHeader("Content-Disposition", "attachment; filename=\"" + fileNameParam.substring(fileNameParam.lastIndexOf("\\") + 1, fileNameParam.length()));
//				response.setHeader("Content-Disposition", "attachment; filename=\"" + fileNameParam.substring(fileNameParam.lastIndexOf("/") + 1, fileNameParam.length()));
			}else{
				response.setHeader("Content-Disposition", "attachment; filename=\"" +fileName+"."+contentType);
			}
			if(ServiceConstants.TYPE_PDF.equals(contentType)){
				response.setContentType("application/pdf");
			}else if(ServiceConstants.TYPE_XLS.equals(contentType)){
				response.setContentType("application/vnd.ms-excel");
        	}else if(ServiceConstants.TYPE_CSV.equals(contentType)){
			    response.setContentType("application/csv");
			}else if(ServiceConstants.TYPE_TEXT.equals(contentType)){
				response.setContentType("application/text/html");
			}else if(ServiceConstants.TYPE_DOC.equals(contentType)){
				response.setContentType("application/vnd.ms-word");
			}
			out.write( bytes, 0, bytes.length );
			out.flush();
			out.close();
			faces.responseComplete();
        }catch (IOException e) {
	    	e.printStackTrace();
	    	log.error("", e);
	    }catch (Exception e) {
	    	e.printStackTrace();
	    	log.error("", e);
		}finally {
			response = null;
			faces = null;
			contentType = null;
			fileNameParam = null;
		}
		return null;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
}
