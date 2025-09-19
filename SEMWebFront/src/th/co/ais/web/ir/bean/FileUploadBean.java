package th.co.ais.web.ir.bean;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.apache.log4j.Logger;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import th.co.ais.rpt.util.DataUtil;
import th.co.ais.rpt.util.JasperUtil;
import th.co.ais.util.SAPUtility;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.web.bean.AbstractBean;
import th.co.ais.web.util.FileNameUtil;

public class FileUploadBean extends AbstractBean{
    
	private Logger LOG = Logger.getLogger(getClass());
	
	private String uploadPath = SAPUtility.UPLOAD_PATH;
	
	private boolean validateSuccess;
    private String fileName;
	private String pathName;
	private String oldFileName;
	private File data;
	private String acceptedType = "xls,xlsx";
	
	public File getData() {
		return data;
	}

	public void setData(File data) {
		this.data = data;
	}

	public String getPathName() {
		return pathName;
	}

	public void setPathName(String pathName) {
		this.pathName = pathName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	private ArrayList<File> files = new ArrayList<File>();
    private int uploadsAvailable = 5;
    private int existFileUploadsAvailable = 1;
    private boolean autoUpload = false;
    private boolean useFlash = false;
    public int getSize() {
        if (getFiles().size() > 0){
            return getFiles().size();
        }else 
        {
            return 0;
        }
    }

    public FileUploadBean() {
    }

    public void resetFiles(){
    	files = new ArrayList<File>();
    	validateSuccess = false;
        fileName = "";
    	pathName = "";
    	oldFileName = "";
    	data = null;
    	uploadsAvailable = 5;
        existFileUploadsAvailable = 1;
        autoUpload = false;
        useFlash = false;
    }
    
    public void paint(OutputStream stream, Object object) throws IOException {
        stream.write(getFiles().get((Integer)object).getData());
    }
   
    
    public void listener(UploadEvent event) throws Exception{
    	try {
    		
    		UploadItem item = event.getUploadItem();
    		String fileName = FileNameUtil.getInstance().GetFilename(item.getFileName());
    		String yyMM = SEMDataUtility.getCurrentYearAndMonth();
    		String pathName = uploadPath + yyMM;
    		fileName = fileName.substring(0,fileName.lastIndexOf(".")) + "_" + 
		    		new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + 
		    		new Random().nextInt(10000) + fileName.substring(fileName.lastIndexOf("."), fileName.length());
    		
    		LOG.info("source file path :" + item.getFileName());
    		// Create one directory
    	    boolean success = (new java.io.File(pathName)).mkdir();
    	    if(success){
    	    	LOG.info("Directory : " + pathName + " created.");
    		}
			
			String fullPathName = pathName + "/" + fileName;
    		
    		LOG.info("fileName :" + fileName);
    		LOG.info("pathName :" + pathName);
    		
    		setFileName(fileName);
 	        setPathName(pathName);
 	        
	        File file = new File();   
	        file.setLength(item.getData().length);
	        file.setName(item.getFileName());
	        file.setData(item.getData());
	       
			FileOutputStream fos = new FileOutputStream(fullPathName);
			DataOutputStream dos = new DataOutputStream(fos);
	        dos.write(item.getData());
	        data = file;
	        files.add(file);
	        uploadsAvailable--;
    		
        } catch (IOException e) {
            e.printStackTrace();
        }       
    }
    
    public void listenerNotChangeName(UploadEvent event) throws Exception{
    	try {
    		///Not Change File Name
    		UploadItem item = event.getUploadItem();
    		String fileName = FileNameUtil.getInstance().GetFilename(item.getFileName());
    		String yyMM = SEMDataUtility.getCurrentYearAndMonth();
    		String pathName = uploadPath + yyMM;
    		
    		LOG.info("source file path :" + item.getFileName());
    		// Create one directory
    	    boolean success = (new java.io.File(pathName)).mkdir();
    	    if(success){
    	    	LOG.info("Directory : " + pathName + " created.");
    		}
			
			String fullPathName = pathName + "/" + fileName;
    		
    		LOG.info("fileName :" + fileName);
    		LOG.info("pathName :" + pathName);
    		
    		setFileName(fileName);
 	        setPathName(pathName);
 	        
	        File file = new File();
	        file.setLength(item.getData().length);
	        file.setName(item.getFileName());
	        file.setData(item.getData());
	       
			FileOutputStream fos = new FileOutputStream(fullPathName);
			DataOutputStream dos = new DataOutputStream(fos);
	        dos.write(item.getData());
	        data = file;
	        files.add(file);
	        uploadsAvailable--;
    		
        } catch (IOException e) {
            e.printStackTrace();
        }       
    }
    
    public void listenerFile(UploadEvent event) throws Exception{
    	try {
    		UploadItem item = event.getUploadItem();
            File file = new File();
            file.setLength(item.getData().length);
            file.setName(item.getFileName());
            file.setData(item.getData());
            files.add(file);
        } catch (Exception e) {
            e.printStackTrace();
        }       
    }
    
    public void existFileListener(UploadEvent event) throws Exception {
    	
    	
		try{
	    	UploadItem item = event.getUploadItem();
	    	validateSuccess = Boolean.FALSE;
	    	fileName = FileNameUtil.getInstance().GetFilename(item.getFileName());
			pathName = JasperUtil.getExportPath(SEMDataUtility.getCurrentDate());
			
			if (fileName.equals(getOldFileName())) {
				String fullPathName = pathName + fileName;
				
				setFileName(fileName);
				setPathName(pathName);
				
		        File file = new File();
		        file.setLength(item.getData().length);
		        file.setName(item.getFileName());
		        file.setData(item.getData());
		        
		        FileOutputStream fos = new FileOutputStream(fullPathName);
				DataOutputStream dos = new DataOutputStream(fos);
		        dos.write(item.getData());
		        
		        dos.close();
		        fos.close();
		        files.add(file);
		        setValidateSuccess(Boolean.TRUE);
			}
			
    	} catch (Exception e) {
    		e.printStackTrace();
		} finally {
			existFileUploadData();
		}
    }
      
    public String clearUploadData() {
        files.clear();
        setUploadsAvailable(5);
        return null;
    }
    
    public String existFileUploadData() {
        files.clear();
        setExistFileUploadsAvailable(1);
        return null;
    }
    
    public long getTimeStamp(){
        return System.currentTimeMillis();
    }
    
    public ArrayList<File> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<File> files) { 
        this.files = files;
    }

    public int getUploadsAvailable() {
        return uploadsAvailable;
    }

    public void setUploadsAvailable(int uploadsAvailable) {
        this.uploadsAvailable = uploadsAvailable;
    }

    public boolean isAutoUpload() {
        return autoUpload;
    }

    public void setAutoUpload(boolean autoUpload) {
        this.autoUpload = autoUpload;
    }

    public boolean isUseFlash() {
        return useFlash;
    }

    public void setUseFlash(boolean useFlash) {
        this.useFlash = useFlash;
    }
    
    public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}

	public String getOldFileName() {
		return oldFileName;
	}

	public void setOldFileName(String oldFileName) {
		this.oldFileName = oldFileName;
	}

	public int getExistFileUploadsAvailable() {
		return existFileUploadsAvailable;
	}

	public void setExistFileUploadsAvailable(int existFileUploadsAvailable) {
		this.existFileUploadsAvailable = existFileUploadsAvailable;
	}

	public boolean isValidateSuccess() {
		return validateSuccess;
	}

	public void setValidateSuccess(boolean validateSuccess) {
		this.validateSuccess = validateSuccess;
	}

	public String getAcceptedType() {
		return acceptedType;
	}

	public void setAcceptedType(String acceptedType) {
		this.acceptedType = acceptedType;
	}

}

