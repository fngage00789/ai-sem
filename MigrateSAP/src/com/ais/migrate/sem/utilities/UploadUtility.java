package com.ais.migrate.sem.utilities;

import java.io.File;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadUtility {
	
	private String fileName;	
	public String getFileName() { return fileName;	}

	public void upload(HttpServletRequest request, HttpServletResponse response, 
						String serverPath, String contentType)throws Exception{
		PrintWriter out = response.getWriter();
		DiskFileItemFactory factory=new DiskFileItemFactory();
        //factory.setSizeThreshold(100000);
        factory.setRepository(new File(serverPath));
        ServletFileUpload upload = new ServletFileUpload(factory);
        //upload.setSizeMax(100000);
        
        List items = upload.parseRequest(request);
        Iterator iter = items.iterator();
        FileItem item = (FileItem)iter.next();
        if(!contentType.equalsIgnoreCase(item.getContentType())){
        	throw new Exception("In correct file extension.");
        }else{
        	String comment=((FileItem)iter.next()).getString();             
            fileName = item.getName();
            fileName = fileName.replace("/", "\\");
            fileName  = fileName.substring(fileName.lastIndexOf("\\")+1,fileName.length());
            
            out.println("Uploading "+ fileName +" to "+ serverPath);
            item.write(new File(serverPath, fileName));            
        } 
	}
}
