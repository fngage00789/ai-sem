package com.ais.migrate.spring.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.ais.migrate.sem.model.DatFile;
import com.ais.migrate.sem.model.SPProcedure;
import com.ais.migrate.sem.spring.service.MigrateSapService;
import com.ais.migrate.sem.utilities.MigrateSAPUtility;
import com.ais.migrate.sem.utilities.FileUtility;
import com.ais.migrate.sem.utilities.UploadUtility;

public class MigrateSAPController extends AbstractController {

	private String successView;
	public void setSuccessView(String successView) { this.successView = successView;}
	private MigrateSapService migrateSapService;
	public void setMigrateSapService(MigrateSapService migrateSapService) { this.migrateSapService = migrateSapService;	}
	
	private String UPLOAD_PATH = MigrateSAPUtility.getMessage("upload_path");
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			request.setAttribute("successMsg", "");
			request.setAttribute("errorMsg", "");
			init(request);
			
			//form sumit
			if("POST".equalsIgnoreCase(request.getMethod())){
				String templateId = request.getParameter("ddlTemplate");
				/*if(ServletFileUpload.isMultipartContent(request)){ //Upload
					uploadZip(request, response, templateId);
				}else */
				if(request.getParameter("btnImport") != null){
					importFile(request, templateId);
					loadFiles(request, templateId);
				}else if(request.getParameter("btnExecProc") != null){
					//execProcedure(request);
				}else if(templateId != null){				
					loadFiles(request, templateId);
				}
			}
		} catch (Exception e) {
			request.setAttribute("errorMsg", "Error: ".concat(e.getMessage()));
			e.printStackTrace();
		}		
		return new ModelAndView(successView);
	}
	
	private void init(HttpServletRequest request) throws Exception{
		//request.getSession().setAttribute("SAPTemplates", new ArrayList<File>());
		
		if(request.getSession().getAttribute("DATFiles") == null){
			request.getSession().setAttribute("DATFiles", new ArrayList<DatFile>());	
		}		
		
		if(request.getSession().getAttribute("SAPTemplates") == null){
			initTemplates(request);
		}
	}
	
	private void initTemplates(HttpServletRequest request) throws Exception{
		System.out.println("Create Template by List dir from: "+UPLOAD_PATH);
		List<File> templates = FileUtility.getFiles(UPLOAD_PATH,".*",null);
		request.getSession().setAttribute("SAPTemplates", templates);
	}
	/*private void uploadZip(HttpServletRequest request, HttpServletResponse response, String templateId) throws Exception{
		 try{
			 UploadUtility upload = new UploadUtility();
             upload.upload(request, response, UPLOAD_PATH, "application/x-zip-compressed");             
             FileUtility.upzip(UPLOAD_PATH, upload.getFileName(), templateId);
             request.setAttribute("successMsg", "Upload & unzip success");
         }catch(Exception e){
        	 request.setAttribute("errorMsg", e.getMessage());
             e.printStackTrace();
         }
	}*/
	
	private void loadFiles(HttpServletRequest request, String templateId) throws Exception{
		request.getSession().setAttribute("DATFiles", new ArrayList<DatFile>());
		if(!StringUtils.isEmpty(templateId)){ //No [----- Select Template -----]
			System.out.println("Load dat files from: "+UPLOAD_PATH+templateId);
			List<DatFile> datFiles = FileUtility.getDatFiles(UPLOAD_PATH+templateId,".*",true);
			request.getSession().setAttribute("DATFiles", datFiles);
		}
	}
	
	private void importFile(HttpServletRequest request, String templateId) throws Exception{
		String[] paramVals = request.getParameterValues("chkItem");
		if(paramVals==null){
			throw new Exception("Please select file(s) to import.");
		}else{
			List<DatFile> files = (List<DatFile>)request.getSession().getAttribute("DATFiles");
			if(files==null) loadFiles(request, templateId);
			
			List<DatFile> selectedFiles = new ArrayList<DatFile>();				
			if( files.size() > 0 && paramVals.length > 0 ){
				System.out.println("Importing...");
				for(String index : paramVals){
					DatFile file = files.get(Integer.valueOf(index));
					System.out.println(" - "+file.getFileName());
					selectedFiles.add(file);
				}
				migrateSapService.transfer(selectedFiles, templateId);
				request.setAttribute("successMsg", migrateSapService.getMessage());
			}	
		}
	}

	
	private void execProcedure(HttpServletRequest request) throws Exception{
		String procedureName = request.getParameter("ddlProcedures");
		if(StringUtils.isEmpty(procedureName)){
			throw new Exception("Please select Procedure(s) to execute.");
		}else{
			//Do something
			SPProcedure proc = migrateSapService.execProcedure(procedureName);
			if(!proc.isSuccess()){
				request.setAttribute("errorMsg", proc.getResultMsg());
			}else{
				request.setAttribute("successMsg", 
						proc.getResultMsg().concat("<br>")
						.concat(proc.getRowEffect().toString()).concat(" record(s) inserted.").concat("<br>")
						.concat(proc.getUseTime()) );
			}
		}
	}
	
	
}
