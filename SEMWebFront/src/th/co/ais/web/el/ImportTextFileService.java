package th.co.ais.web.el;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import th.co.ais.domain.el.ImportMeaNewTmp;
import th.co.ais.domain.el.ImportPeaNewExt;
import th.co.ais.service.el.IImportMeaNewTmpService;
import th.co.ais.service.el.IImportPeaNewExtService;
import th.co.ais.service.impl.el.ImportPeaNewExtServiceImpl;
import th.co.ais.util.BeanUtils;
import th.co.ais.web.util.FacesUtils;

public class ImportTextFileService {
	
	static Logger LOG = Logger.getLogger(ImportTextFileService.class);
	private IImportMeaNewTmpService importMeaNewTmpService;
	
	public void setImportMeaNewTmpService(
			IImportMeaNewTmpService importMeaNewTmpService) {
		this.importMeaNewTmpService = importMeaNewTmpService;
	}

	public String importPeaNewExtService(String transactionId){
		LOG.info("START importPeaNewExtService");
		System.out.println("WT###Print : "+importMeaNewTmpService);
		try {
			//IImportPeaNewExtService service = (IImportPeaNewExtService) FacesUtils.getInstance().getBean("importPeaNewExtService");
			//IImportPeaNewExtService service = new ImportPeaNewExtServiceImpl();
			List<ImportPeaNewExt> importPeaNewxtList = new ArrayList<ImportPeaNewExt>();
			String filePath = "C:\\peanew2.txt";
			String destinationPath = "D:\\";
	         File file = new File(filePath);
	         Scanner scanner = new Scanner(new FileInputStream(file), "TIS-620");
	         scanner.useDelimiter(System.getProperty("line.separator"));
	         int line = 0;
	         while (scanner.hasNext()) {
	        	 if(line>=4){
		        	 ImportPeaNewExt importMeaNewExt = new ImportPeaNewExt(scanner.next(), "TESTVALIDATEPAYMENT", "\\|");
		        	 importPeaNewxtList.add(importMeaNewExt);
	        	 }else{
	        		 scanner.next();
	        	 }
	        	 line++;
	         }
	         scanner.close();
	        // service.createImportPeaNewExts(importPeaNewxtList);
	      // File (or directory) to be moved
	         File fileMove = new File(filePath);
	         
	         // Destination directory
	         File dir = new File(destinationPath);
	         
	         // Move file to new directory
	         boolean success = fileMove.renameTo(new File(dir, fileMove.getName()));
	         if (!success) {
	             // File was not successfully moved
	         }
	         
	         LOG.info("END importPeaNewExtService");		
		} catch (Exception e) {
			LOG.error("ERROR importPeaNewExtService : "+e, e);
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String importPeaOldExtService(String transactionId){
		
		
		
		return null;
	}
	
	public String importMeaOldExtService(String transactionId){
		
		
		
		return null;
	}
	
	public String importMeaNewExtService(String transactionId){
		
		
		
		return null;
	}
	
	public static void main(String args[]){
		System.out.println("WT#####");
		ImportTextFileService service = new ImportTextFileService();
		service.importPeaNewExtService("");
		System.out.println("WT#####2222222");
	}
	
}
