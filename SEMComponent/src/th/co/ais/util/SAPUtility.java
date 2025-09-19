package th.co.ais.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.apache.commons.lang.StringUtils;

import th.co.ais.domain.gm.Employee;
import th.co.ais.domain.sap.SapMapping;
import th.co.ais.service.sap.ISAPService;

public class SAPUtility {
	
	private static SAPUtility instance = null;
	public static String TOKEN = "|";
	public static String NL = "\n";
	public static String TEMPLATE_HEADER = "TEMPLATE_01_H";
	public static String TEMPLATE_DETAIL = "TEMPLATE_01_D";
	public static String SAP_FORMAT_FILE = getMessage("sap_format_file");
	public static String SAP_FILE_EXTENSION = getMessage("sap_file_extension");
	public static String SAP_FILE_EXTENSION2 = getMessage("sap_file_extension2");
	public static String SEM_PATH = SAPUtility.getMessage("sem_path");
	public static String SAP_PATH = SAPUtility.getMessage("sap_path");
	public static boolean READ_RUNING_FROM_SAP_PATH = Boolean.valueOf(SAPUtility.getMessage("read_runing_file_from_sap_path"));
	public static boolean CONNECT_SFTP = Boolean.valueOf(SAPUtility.getMessage("connect_sftp"));
	
	//upload path
	public static String UPLOAD_PATH = SAPUtility.getMessage("upload_path");
	
	private static Integer MAX_RUNNING = 9999;
	private static String ERROR_MAX_RUNNING = "Can't create file's running more than {0}";
	
	public static String ON_DEV = SAPUtility.getMessage("on_dev");
	
	//TODO: USERNAME & PWD WEB SERVICE SAP ON DEV
	public static String ws_sap_user = SAPUtility.getMessage("ws_sap_user");
	public static String ws_sap_pw = SAPUtility.getMessage("ws_sap_pw");
	//TODO: SAP WEB SERVICE END POINT
	public static String ws_sap_end_point_SI_Z_FIAP_SEM_ADDVENBANK = SAPUtility.getMessage("ws_sap_end_point_SI_Z_FIAP_SEM_ADDVENBANK");
	public static String ws_sap_end_point_SI_Z_FIAP_SEM_BLKUNBLKVEN = SAPUtility.getMessage("ws_sap_end_point_SI_Z_FIAP_SEM_BLKUNBLKVEN");
	public static String ws_sap_end_point_SI_Z_FIAP_SEM_CHG_VEN = SAPUtility.getMessage("ws_sap_end_point_SI_Z_FIAP_SEM_CHG_VEN");
	public static String ws_sap_end_point_SI_Z_FIAP_SEM_CHGVENBANK = SAPUtility.getMessage("ws_sap_end_point_SI_Z_FIAP_SEM_CHGVENBANK");
	public static String ws_sap_end_point_SI_Z_FIAP_SEM_CRE_VEN = SAPUtility.getMessage("ws_sap_end_point_SI_Z_FIAP_SEM_CRE_VEN");
	public static String ws_sap_end_point_SI_Z_FIAP_SEM_DELVENBANK = SAPUtility.getMessage("ws_sap_end_point_SI_Z_FIAP_SEM_DELVENBANK");
	public static String ws_sap_end_point_SI_Z_FIAP_SEM_GET_VEN = SAPUtility.getMessage("ws_sap_end_point_SI_Z_FIAP_SEM_GET_VEN");
	public static String ws_sap_end_point_SI_Z_FIAP_SEM_GETVENBANK = SAPUtility.getMessage("ws_sap_end_point_SI_Z_FIAP_SEM_GETVENBANK");
	public static String ws_sap_end_point_SI_Z_FIAP_SEM_MASTERBANK = SAPUtility.getMessage("ws_sap_end_point_SI_Z_FIAP_SEM_MASTERBANK");
	public static String ws_sap_end_point_SI_OB_Z_RE_IF_SEM_CREATE = SAPUtility.getMessage("ws_sap_end_point_SI_OB_Z_RE_IF_SEM_CREATE");
	public static String ws_sap_end_point_SI_OB_Z_RE_IF_SEM_CHANGE = SAPUtility.getMessage("ws_sap_end_point_SI_OB_Z_RE_IF_SEM_CHANGE");
	public static String WS_IFRS_USERNAME = SAPUtility.getMessage("WS_IFRS_USERNAME");
	public static String WS_IFRS_PASSWORD = SAPUtility.getMessage("WS_IFRS_PASSWORD");
	
	
	ResourceBundle appSAP = null;
	private SAPUtility(){
//		appSAP = ResourceBundle.getBundle("th.co.ais.resource.SEMConfig");
//		appSAP = ResourceBundle.getBundle("/jboss/9_SEM_5.1.0/server/default/deploy/SEMConfig/SEMConfig.properties");
//		appSAP = ResourceBundle.getBundle("D:/backupSemSap/SEMConfig_properties/DEV/SEMConfig.properties");
		
		try {
			//DEV
			FileInputStream fis = new FileInputStream("/data/SEM/resources/SEMConfig/SEMConfig.properties");
			//PROD
//			FileInputStream fis = new FileInputStream("/datacamp/SEM/SEMConfig/SEMConfig.properties");
			//FileInputStream fis = new FileInputStream("D:\\Projects\\AIS\\SEM\\config\\SEMConfig.properties");
			//FileInputStream fis = new FileInputStream("D:/workspace/SEM2/SEMComponent/src/th/co/ais/resource/SEMConfig.properties");
			appSAP = new PropertyResourceBundle(fis);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error SAPUtility getBundle PRD : "+e);
			appSAP = null;
			// TODO: handle exception
		}
		
//		try {
//			if(appSAP == null){
//				FileInputStream fis = new FileInputStream("D:\\Projects\\AIS\\SEM\\config\\SEMConfig.properties");
//				appSAP = new PropertyResourceBundle(fis);
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("Error SAPUtility getBundle UAT : "+e);
//			appSAP = null;
//			// TODO: handle exception
//		}
//		
//		try {
//			if(appSAP == null){
//				FileInputStream fis = new FileInputStream("D:\\Projects\\AIS\\SEM\\config\\SEMConfig.properties");
//				appSAP = new PropertyResourceBundle(fis);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("Error SAPUtility getBundle LOCAL : "+e);
//			appSAP = null;
//			// TODO: handle exception
//		}

	}
	
	public String getMSG(String key) {
		String value = null;
		try {
			value = appSAP.getString(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public static synchronized SAPUtility getInstance() {
		if(instance == null){
			instance = new SAPUtility();
		}
		return instance;
	}
	
	public static synchronized String getMessage(String key){
	  	String w_msg = null;
	  	try{  		
	  		w_msg = SAPUtility.getInstance().getMSG(key);		
	  	}catch( MissingResourceException e){  
	  		e.printStackTrace();
	  	}
	  	return w_msg;
	}

	/** Write Header [No Fix] **/
	/*public static void writeHeader(PrintWriter pw, Object objHeader, List<SapMapping> maps){
		try {
			if(maps!=null && maps.size()>0){
				int cntCol = 0;
				for(SapMapping smH : maps){
					boolean noLastCol = cntCol < maps.size()-1;
					String value = "";
					if(null!=smH.getFieldDbName() && !"".equals(smH.getFieldDbName())){
						value = getValue(smH, objHeader);
						value = value.concat(noLastCol?TOKEN:"");	
					}
					
					if(noLastCol) pw.print(value);
					else pw.println(value);					
					cntCol++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void writeDetail(PrintWriter pw, Object[] objDetails, List<SapMapping> maps){
		try {
			if(maps!=null && maps.size()>0){
				for(Object objD : objDetails){
					int cntCol = 0;
					for(SapMapping map : maps){
						boolean noLastCol = cntCol < maps.size()-1;
						String value = "";
						if(null!=map.getFieldDbName() && !"".equals(map.getFieldDbName())){
							value = getValue(map, objD);
							value = value.concat(noLastCol?TOKEN:"");	
						}						
						if(noLastCol) pw.print(value);
						else pw.println(value);					
						cntCol++;
					}
				}	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	public static void writeHeader(Writer out, Object obj, List<SapMapping> maps){
		try {
			if(maps!=null && maps.size()>0){
				int cntCol = 0;
				StringBuilder sb = new StringBuilder();
				for(SapMapping map : maps){
					sb.append(write(map, obj, cntCol==maps.size()-1));
					cntCol++;
				}

				if(sb.length()>0){
					System.out.println(sb.toString());
					out.append(sb);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void writeDetail(Writer out, Object[] objs, List<SapMapping> maps){
		try {
			if(maps!=null && maps.size()>0){
				StringBuilder sb = new StringBuilder();
				for(Object obj : objs){
					int cntCol = 0;					
					for(SapMapping map : maps){
						sb.append(write(map, obj, cntCol==maps.size()-1));
						cntCol++;
					}
				}
				
				if(sb.length()>0){
					System.out.println(sb.toString());
					out.append(sb.toString());
				}				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Integer countFileRecords(String filename, String encoding) throws Exception{
		if(StringUtils.isEmpty(encoding)){
			encoding = StringHelper.ENCODING_TIS620;
		}
		
		Integer count = 0;
		FileInputStream fis = new FileInputStream(filename); 
		LineNumberReader lineR = new LineNumberReader(new InputStreamReader(fis, encoding));
		String c;        		
		while ((c=lineR.readLine())!=null) {
			System.out.println(c);
			count++;
  		}
		lineR.close();
		return count;
	}
	public static void writeSync(String sem_file_sync, Integer totalRecords, Double totalAmount,  
									Employee employee, String yyyyMMdd, String hhmmss){
		try {
			String totRecords = String.valueOf(totalRecords!=null?totalRecords:""), 
				   totAmount = String.valueOf(totalAmount!=null?totalAmount:""),
				   userID = employee.getUserStamp()!=null?employee.getUserStamp():"",
				   email = employee.getEmail()!=null?employee.getEmail():"";
			
			FileOutputStream fos = new FileOutputStream(sem_file_sync, false);
			Writer out = new OutputStreamWriter(fos, StringHelper.ENCODING_TIS620);				
			out.append("Total record|Total amount|UserID|Email|Createdate|Time");
			out.append(SAPUtility.NL);
			out.append("    ");
			out.append(totRecords.concat(TOKEN));	//Total record
			out.append(totAmount.concat(TOKEN));	//Total amount
			out.append(userID.concat(TOKEN));		//UserID
			out.append(email.concat(TOKEN));		//Email
			out.append(yyyyMMdd.concat(TOKEN));		//Createdate
			out.append(hhmmss.concat(TOKEN));		//Time			
			out.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static String write(SapMapping map, Object obj, boolean lastRecord){
		String value = "";
		try {			
			if(null!=map.getFieldDbName() && !"".equals(map.getFieldDbName())){
				value = getValue(map, obj);
				value = value.concat(lastRecord?"":TOKEN);
			}						
			if(lastRecord) value = value.concat(NL);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	private static String getValue(SapMapping sm, Object objH) throws UnsupportedEncodingException{		
		
		String fDbName = sm.getFieldDbName();
		
		//Example. : Refsem, Id.Hearun, Id.Linitm
		String[] mNames = fDbName.indexOf(".")>-1?fDbName.split("\\."):new String[]{fDbName};
		
		String value = "";
		Object fieldValue = objH;
		String clazzName = sm.getClassName();
		for(String mName : mNames){
			try{
				Method method = Class.forName(clazzName).getDeclaredMethod("get".concat(mName), null);
				fieldValue = method.invoke(fieldValue, new Object[0]);

				if(fieldValue==null){ 
					//System.out.println("Exception in method '"+mName+"': null");
					continue;
				}else{
					clazzName = fieldValue.getClass().getName();
				}				
			}catch(Exception e) {
				//e.printStackTrace();
				System.out.println("Exception ["+sm.getTemplateId()+"/"+sm.getFieldName()+"]"+e.getMessage());
			}
		}

		if(fieldValue != null){
			/** Locale **/
			Locale locale = new Locale("ENGLISH"); //default
			if(sm.getLocale()!=null){
				String[] locales = sm.getLocale().split(","); 
				if(locales.length==3){
					locale = new Locale(locales[0],locales[1],locales[2]);
				}else if(locales.length==2){
					locale = new Locale(locales[0],locales[1]);
				}else if(locales.length==1){
					locale = new Locale(locales[0]);
				}
			}
			
			/** Type & Format **/
			if(sm.getFormat()==null){
				value = fieldValue.toString();
			}else{
				if("Date".equals(sm.getType())){
					SimpleDateFormat sdf = new SimpleDateFormat(sm.getFormat(), locale);
					value = sdf.format(fieldValue);
				}else if("Integer".equals(sm.getType())){
					value = String.format(sm.getFormat(),fieldValue);
				}else{
					value = String.format(sm.getFormat(),fieldValue);
				}			
			}		
		}
		value = StringHelper.convertMS874ToTIS620(value.trim());
		//System.out.println(fName+": "+ value +" ("+sm.getType()+")");
		return value;
	}
	
	
	public static String getRegxFile(String yyyyMMdd) {
		return SAPUtility.SAP_PATH.concat("SEMPA*")
							.concat(yyyyMMdd)
							.concat("*.")
							.concat(SAP_FILE_EXTENSION);
	}
	/**
	 * ��ҹ�ҡ Path : SEM
	 * @param employee
	 * @param yyyyMMdd
	 * @return
	 * @throws Exception
	 */
	public static String getNextFileName(Employee employee, String company, String yyyyMMdd) throws Exception{
		
		int nextNumber = 1;
		List<Integer> runningList = new ArrayList<Integer>();
				
		/** 
		 * SEMPA_COMP_YYYYMMDD_UserName_XXXX.dat >> SEMPA_AIS_20101115_ekarutwa_{0}.dat
		 * Description: 
		 */
		String format = SAP_FORMAT_FILE.replaceAll("COMP", company)
									   .replaceAll("YYYYMMDD", yyyyMMdd)
									   .replaceAll("UserName", employee.getUserStamp())
									   .replace("XXXX", "{0}")
									   .concat(".".concat(SAP_FILE_EXTENSION));
		
		/**
		 * File's expression: SEMPA_COMP_YYYYMMDD_UserName_XXXX.dat >> ^(SEMPA).*(20101115).*
		 * Description: �����    SEMPA*20101115*
		 * **/ 
		String regxFile = SAP_FORMAT_FILE.replace("SEMPA_", "^(SEMPA)")
										.replaceAll("COMP_", ".*")
									    .replaceAll("YYYYMMDD_", "(".concat(yyyyMMdd).concat(")"))
									    .replaceAll("UserName_XXXX", ".*");
		File dir = new File(SEM_PATH);
		if(!dir.exists()){
			throw new Exception(SEM_PATH.concat(" not exists."));
		}
		
		/** 
		 * �� Max Running �ҡ��������¡��  filter ������� regx > SEMPA*20101115* 
		 * **/
		if(dir.isDirectory()){
			FilenameFilter filter = new FileListFilter(regxFile, new String[]{SAP_FILE_EXTENSION});			
			File[] files = dir.listFiles(filter);
			if(files!=null && files.length>0){
				System.out.println(" List of '"+regxFile+"':");
				int no=1;
				for(File f : files){
					String fName = f.getName();
					System.out.println(" "+(no++)+") "+fName);
					
					String[] fNames0 = fName.split("\\.");
					if(fNames0!=null && fNames0.length==2){
						String[] fNames1 = fNames0[0].split("\\_");
						try {
							Integer running = Integer.valueOf(fNames1[fNames1.length-1]);
							runningList.add(running);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}	
				}	
			}
		}
				
    	if(runningList.size()>0){
    		Integer maxRunning = 0;
    		Integer[] runnings = runningList.toArray(new Integer[0]);
    		Arrays.sort(runnings); //asc
    		maxRunning = runnings[runnings.length-1];
    		nextNumber = maxRunning + 1;
    		//System.out.println("first runnings: "+runnings[0]);
    		//System.out.println("last runnings: "+maxRunning);	    		
    	}
		if(nextNumber > MAX_RUNNING){			
			throw new Exception(MessageFormat.format(ERROR_MAX_RUNNING, MAX_RUNNING.toString()));
		}
		System.out.println("Next running = "+nextNumber);
		return MessageFormat.format(format, String.format("%04d", nextNumber));
	}
	
	/** 
	 * ��ҹ�ҡ Path : SAP
	 * @param employee:		������ Employee ��� login �����
	 * @param yyyyMMdd:		date now (yyyyMMdd)
	 * @param running:		1 - 9999
	 * @return				SEMPA_COMP_YYYYMMDD_UserName_XXXX.dat (sap_format_file in SEMConfig.properties)
	 * @throws Exception
	 */
	/*public static String getNextFileName(Employee employee, String yyyyMMdd, Integer running) throws Exception{
		if(running > MAX_RUNNING){			
			throw new Exception(MessageFormat.format(ERROR_MAX_RUNNING, MAX_RUNNING.toString()));
		}
		String nextFileName = SAP_FORMAT_FILE.replaceAll("COMP", employee.getCompanyCode())
									   .replaceAll("YYYYMMDD", yyyyMMdd)
									   .replaceAll("UserName", employee.getUserStamp())
									   .replaceAll("XXXX", String.format("%04d", running))
									   .concat(".").concat(SAP_FILE_EXTENSION);
		return nextFileName;
	}*/
	
	public static String getNextFileName(Employee employee, String yyyyMMdd, String company, Integer running) throws Exception{
		if(running > MAX_RUNNING){			
			throw new Exception(MessageFormat.format(ERROR_MAX_RUNNING, MAX_RUNNING.toString()));
		}
		String nextFileName = SAP_FORMAT_FILE.replaceAll("COMP", company)
									   .replaceAll("YYYYMMDD", yyyyMMdd)
									   .replaceAll("UserName", employee.getUserStamp())
									   .replaceAll("XXXX", String.format("%04d", running))
									   .concat(".").concat(SAP_FILE_EXTENSION);
		return nextFileName;
	}
	
	
	/****/
	public static List<File> listFile(String filePath) throws Exception{
		List<File> files = new ArrayList<File>();
		if(StringUtils.isNotEmpty(filePath)){ 
			filePath = filePath.replace("\\", "/");
			if(filePath.indexOf("/") > -1){				
				int lastSlash = filePath.lastIndexOf("/")+1;
				String path = filePath.substring(0, lastSlash);
				String fileName = "";
				if(lastSlash < filePath.length()-1){
					fileName = filePath.substring(lastSlash, filePath.length());
				}
				
				File dir = new File(path);
				if(!dir.exists()){
					throw new Exception(filePath.concat(" not exists."));
				}else{
					//SEMPA_COMP_YYYYMMDD_UserName_XXXX.dat >> ^(SEMPA).*(20101115).*
					String regxFile = null;
					if(fileName.indexOf("*") > -1){
						regxFile = "^(" + fileName.replace("*", ").*(") + ")";
					}
					
					if(dir.isDirectory()){ 
						FilenameFilter filter = new FileListFilter(regxFile, null);	
						File[] listFiles = dir.listFiles(filter);
						for(File f : listFiles){
							if(f.isFile()){
								files.add(f);
							}								
						}
						
					}
				}
			}			
		}		
		return files;
	}
}




class FileListFilter implements FilenameFilter {
    private String regex;
    private String[] extensions;

    public FileListFilter(String regex, String[] extensions) {
            this.regex = regex;
            this.extensions = extensions;
    }

    public boolean accept(File directory, String filename) {
            return accept(directory, filename, true);
    }

    public boolean accept(File directory, String filename,
                    boolean acceptDirectory) {
            boolean fileOK = true;
            if (acceptDirectory) {
                    boolean isDirectory = new File(directory, filename).isDirectory();
                    if (isDirectory)
                            return fileOK;
            }
            regex = regex == null ? ".*" : regex;
            extensions = extensions == null ? new String[] { ".*" } : extensions;
            boolean matchExtension = false;
            for (String extension : extensions) {
            	if (matchExtension = filename.matches(regex + "\\." + extension))
                    break;
            }
            fileOK &= matchExtension;

            return fileOK;
    }
}