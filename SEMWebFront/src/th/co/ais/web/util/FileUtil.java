package th.co.ais.web.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.URLEncoder;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

public class FileUtil implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private static FileUtil instance = new FileUtil();
	
	public static FileUtil getInstance() {
		return instance;
	}
	
	public void getFile(String filePath, String fileName, String type) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
		response.reset();
		response.setContentType(type);
		response.addHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode(fileName, "UTF-8") + "\"");
		byte[] buf = new byte[1024];
		int read = 0;
			// String realPath = context.getRealPath("/resources/" + filePath);
			File file = new File(filePath);
			long length = file.length();
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
			OutputStream out = response.getOutputStream();
			response.setContentLength((int) length);
			while ((read = in.read(buf)) != -1) {
				out.write(buf, 0, read);
			}
			out.flush();
			in.close();
			out.close();
			FacesContext.getCurrentInstance().responseComplete();
	}

	public void removeFile(String filePath) throws IOException {
		File f = new File(filePath);

	    // Make sure the file or directory exists and isn't write protected
	    if (!f.exists())
	      throw new IllegalArgumentException(
	          "Delete: no such file or directory: " + filePath);

	    if (!f.canWrite())
	      throw new IllegalArgumentException("Delete: write protected: "
	          + filePath);

	    // If it is a directory, make sure it is empty
	    if (f.isDirectory()) {
	      String[] files = f.list();
	      if (files.length > 0)
	        throw new IllegalArgumentException(
	            "Delete: directory not empty: " + filePath);
	    }

	    // Attempt to delete it
	    boolean success = f.delete();

	    if (!success)
	      throw new IllegalArgumentException("Delete: deletion failed");
	  }

	public void saveFile(String filePath,byte[] content) throws IOException {
			FileOutputStream fileOut = new FileOutputStream(filePath);
			fileOut.write(content);
			fileOut.flush();
			fileOut.close();
	}
		
}
