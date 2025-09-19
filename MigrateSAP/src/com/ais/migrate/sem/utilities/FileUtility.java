package com.ais.migrate.sem.utilities;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

import com.ais.migrate.sem.model.DatFile;
import com.ais.migrate.sem.model.SyncFile;

public class FileUtility {

	public static final void upzip(String path, String zipName, String createDir){
		String fileName = path.concat(zipName);
		Enumeration entries;
	    ZipFile zipFile;

	    if(zipName == null) {
	      System.err.println("Usage: Unzip zipfile");
	      return;
	    }

	    try {
	      zipFile = new ZipFile(fileName);
	      entries = zipFile.entries();
	      while(entries.hasMoreElements()) {
	        ZipEntry entry = (ZipEntry)entries.nextElement();
	        
	        /*if(entry.isDirectory()) {
	          // Assume directories are stored parents first then children.
	          System.out.println("Extracting directory: " + entry.getName());
	          // This is not robust, just for demonstration purposes.
	          (new File(path+entry.getName())).mkdir();
	           continue;
	        }else{
	        	File dir = new File(path+createDir);
	        	if(!dir.isDirectory()){
	        		dir.mkdir();
	        	}
	        }*/
	        File dir = new File(path+createDir);
        	if(!dir.isDirectory()){
        		dir.mkdir();
        	}
	        
	        //FileOutputStream fos = new FileOutputStream(path+entry.getName());
        	FileOutputStream fos = new FileOutputStream(path+createDir);
	        BufferedOutputStream bos = new BufferedOutputStream(fos);
	        System.out.println("Extracting file: " + path+entry.getName());
	        copyInputStream(zipFile.getInputStream(entry), bos);
	        
	      }
	      zipFile.close();
	    } catch (IOException ioe) {
	      System.err.println("Unhandled exception:");
	      ioe.printStackTrace();
	      return;
	    }
	  }

	public static final void copyInputStream(InputStream in, OutputStream out) throws IOException
	{
		byte[] buffer = new byte[1024];
		int len;	
		while((len = in.read(buffer)) >= 0)
			out.write(buffer, 0, len);
	
		in.close();
		out.close();
	}
	
	public static List<File> getFiles(String path, String regxFile, String[] extensions) throws Exception{	
		List<File> files = new ArrayList<File>();
		File dir = new File(path);
		if(!dir.exists()){
			throw new Exception(path.concat(" not exists."));
		}
		
		if(dir.isDirectory()){
			if(StringUtils.isEmpty(regxFile)){
				regxFile = "*";
			}
				
			FilenameFilter filter = new FileListFilter(regxFile, extensions);			
			File[] _files = dir.listFiles(filter);
			files = Arrays.asList(_files);
		}
		return files;
	}
	
	public static List<DatFile> getDatFiles(String path, String regx, boolean readSync) throws Exception{	
		List<DatFile> datFiles = new ArrayList<DatFile>();
		File dir = new File(path);
		if(!dir.exists()){
			throw new Exception(path.concat(" not exists."));
		}
		
		if(dir.isDirectory()){
			if(StringUtils.isEmpty(regx)){
				regx = "*";
			}
			
			FilenameFilter datFilter = new FileListFilter(regx, new String[]{"dat"});			
			File[] _datFiles = dir.listFiles(datFilter);
			for(File f: _datFiles){
				DatFile dF = new DatFile(f.getName(), f);
				if(readSync){
					SyncFile sF = getSyncFile(f);
					dF.setSyncFile(sF);
				}
				datFiles.add(dF);
			}
		}
		return datFiles;
	}

	public static SyncFile getSyncFile(File datFile){ 
		SyncFile sync = new SyncFile();
		try {
			String pathSync = datFile.getAbsolutePath().replace(".dat", ".syn");
			File syncFile = new File(pathSync);
			sync.setFileName(syncFile.getName());
			FileInputStream fis = new FileInputStream(syncFile);
			InputStreamReader isr = new InputStreamReader(fis, "MS874");
			LineNumberReader lineR = new LineNumberReader(isr);				
			String c;
			int line=1;				
			while ((c=lineR.readLine())!=null) {
				if(line==2){
					String[] results = c.split("\\|", 6);
					if(StringUtils.isNotBlank(results[0].trim()))
						sync.setTotalRecord(Integer.valueOf(results[0].trim()));					
					if(StringUtils.isNotBlank(results[1].trim()))
						sync.setTotalAmount(Double.valueOf(results[1].trim()));
					
					sync.setUserId(results[2].trim());
					sync.setEmail(results[3].trim());
					
					if(StringUtils.isNotBlank(results[4].trim()))
						sync.setCreateDate(DateUtils.parseDate(results[4].trim(), new String[]{"yyyyMMdd"}));
					if(StringUtils.isNotBlank(results[5].trim()))
						sync.setCreateDate(DateUtils.parseDate(results[5].trim(), new String[]{"hhmmss"}));

					break;
				}
				line++;
	  		}//end while lineR.readLine
			lineR.close();
		} catch (Exception e) {
			sync.setEx(e);
			e.printStackTrace();			
		}
		return sync;
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
