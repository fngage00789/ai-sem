package com.ais.migrate.sem.spring.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.StringUtils;
import com.ais.migrate.sem.hibernate.annotion.SapMapping;
import com.ais.migrate.sem.model.DatFile;
import com.ais.migrate.sem.model.SPProcedure;
import com.ais.migrate.sem.model.SyncFile;
import com.ais.migrate.sem.spring.dao.MigrateDAO;
import com.ais.migrate.sem.spring.dao.SapMappingDAO;
import com.ais.migrate.sem.spring.service.tran.MigrateService;
import com.ais.migrate.sem.utilities.DateUtility;
import com.ais.migrate.sem.utilities.MigrateSAPUtility;

public class MigrateSapService {
	
	private SapMappingDAO sapMappingDAO;
	public void setSapMappingDAO(SapMappingDAO sapMappingDAO) { this.sapMappingDAO = sapMappingDAO;  }
	
	private MigrateService migrateService;
	public MigrateService getMigrateService() {
		return migrateService;
	}
	public void setMigrateService(MigrateService migrateService) {
		this.migrateService = migrateService;
	}

//	private MigrateDAO migrateDAO;	
//	public void setMigrateDAO(MigrateDAO migrateDAO) {	this.migrateDAO = migrateDAO;	}

	private String message;	
	public String getMessage() {	return message;	}
	public void setMessage(String message) {	this.message = message;	}

	private String token = MigrateSAPUtility.getMessage("read_file_token");
	
	public void transfer(List<DatFile> selectedFiles, String templateId) throws Exception{ 
		
		List<DatFile> importedFiles = new ArrayList<DatFile>();
		try {
			String listSuccess = "";
			Date currentDate = new Date();
			DecimalFormat formatDecimal = new DecimalFormat("#,###.##");
			
			System.out.println(getClass()+".save() ...");		
			if(selectedFiles.size()>0){
				System.out.println("templateId = "+templateId);		
				List<SapMapping> sapMaps = migrateService.querySapMapping(templateId);
				if(sapMaps==null || sapMaps.size()==0){
					throw new Exception(templateId+"'s field size(db) is 0.");
				}
				
				Map<String, Integer> importedFileMap = new HashMap<String, Integer>();
				for(DatFile datFile : selectedFiles){ 
					String startdate = DateUtility.dateTime();
					System.out.println("datFile = "+datFile);
					//Read [?].dat File
					FileInputStream fis = new FileInputStream(datFile.getFile());				
					InputStreamReader isr = new InputStreamReader(fis, "MS874");
					LineNumberReader lineR = new LineNumberReader(isr);	
					String c;
					int line=0;
					while ((c=lineR.readLine())!=null) {
						
						if(StringUtils.isEmpty(c) || "E".equalsIgnoreCase(c)){
							//System.out.println(datFile.getFileName()+"'s EOF ["+line+" record(s)].");
							break;
						}else{
							int itemSize = c.split("\\".concat(token),sapMaps.size()).length;
							
							if(itemSize != sapMaps.size()){
								System.out.println("line"+line+": "+c);								
								throw new Exception(
									String.format("Line @%d: line items' size<%d> not equal config items' size<%d>",
									line, itemSize, sapMaps.size()));
							}
							//System.out.println("line"+line+": "+c);
							String[] results = c.split("\\".concat(token), sapMaps.size());							
							Object model = Class.forName(sapMaps.get(0).getClassName()).newInstance();
							//System.out.println("Object = "+model.toString());
							MigrateSAPUtility.setModel(model, sapMaps, results, datFile.getFileName(), currentDate);
							migrateService.save(model);
							line++;
						}					
			  		}//end while lineR.readLine
					lineR.close();
					System.out.println("line = "+line);
					//Check [?].sync File
					SyncFile syncFile = datFile.getSyncFile();
					if(syncFile.getEx() != null){
						throw syncFile.getEx(); 
					}else{
						System.out.println("getTotalRecord = "+syncFile.getTotalRecord());
						if(line != syncFile.getTotalRecord()){
							throw new Exception(datFile.getFileName()+"'s line not equal "+syncFile.getFileName()+"'s line");
						}else{							
							String enddate = DateUtility.dateTime();
							
							listSuccess += "Save "+line +" record(s) success";
							listSuccess += "<br> - "+datFile.getFileName()+" ["+line+" record(s)]";
							listSuccess += ", size file : ";
							if(datFile.getSyncFile().getTotalAmount() != null && !datFile.getSyncFile().getTotalAmount().equals("")){
								listSuccess += formatDecimal.format(datFile.getSyncFile().getTotalAmount());
							}
							listSuccess += ", startdate : "+startdate+" enddate : "+enddate+"<br>";
							
							importedFiles.add(datFile);
							importedFileMap.put(datFile.getFileName(), line);
						}
					}						
					
				}//end for(File file : selectedFiles){					
				this.setMessage(listSuccess);
			}//end if(selectedFiles.size()>0)	
		} catch (Exception e) {
			throw e;
		} finally {
			
		}
	}
		
	public SPProcedure execProcedure(String procedureName) throws Exception{ 
		try {
			SPProcedure property = new SPProcedure();
			return (SPProcedure)migrateService.querySingleBySP(procedureName, property);			
		} catch (Exception e) {
			throw e;
		} finally {
			
		}
	}
	
	public List queryListBySP(String procedureName, Object property) throws Exception{ 
		try {
			return migrateService.getMigrateDAO().queryListBySP(procedureName, property);			
		} catch (Exception e) {
			throw e;
		} finally {
			
		}
	}
	
	/*public List getMpContractCleans(int rowStart, int rowEnd, Object property) throws Exception{ 
		try {
			//return migrateService.getMigrateDAO().queryListBySP(procedureName, property);
			return migrateService.getMpContractCleans(rowStart, rowEnd);
		} catch (Exception e) {
			throw e;
		} finally {
			
		}
	}*/
}
