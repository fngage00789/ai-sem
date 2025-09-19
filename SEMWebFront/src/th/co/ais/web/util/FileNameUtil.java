package th.co.ais.web.util;

public class FileNameUtil {

	private static FileNameUtil instance = null;
	
	public static synchronized FileNameUtil getInstance() {
		if(instance == null){
			instance = new FileNameUtil();
		}
		return instance;
	}
	
	  public static String GetDeepestDirectory(String path) {
	    String dir = null;
	    int lastIndex;

	    if (path != null && path.trim().length() > 0) {
	      path = path.trim();

	      if (path.endsWith("/") && path.length() > 1) {
	        path = path.substring(0, path.length() - 1);
	      }

	      dir = path;

	      if (path.length() > 1) {
	        lastIndex = path.lastIndexOf("/");

	        if (lastIndex >= 0) {
	          dir = path.substring(lastIndex + 1);
	        }
	      }
	    }

	    return dir;
	  }

	  public static String GetParentDirectory(String path) {
	    String parentDir = "/";
	    int lastIndex;

	    if (path != null && path.trim().length() > 0) {
	      path = path.trim();

	      if (path.endsWith("/") && path.length() > 1) {
	        path = path.substring(0, path.length() - 1);
	      }

	      if (path.length() > 1) {
	        lastIndex = path.lastIndexOf("/");

	        if (lastIndex > 0) {
	          parentDir = path.substring(0, lastIndex);
	        }
	      }
	    }

	    return parentDir;
	  }

	  public static String GetFilename(String path) {
	    String file = null;
	    int lastIndex;

	    if (path != null && path.trim().length() > 0) {
	      path = path.trim();

	      if (!path.endsWith("/")) {
	        file = path;
	        lastIndex = path.lastIndexOf("\\");

	        if (lastIndex >= 0) {
	          file = path.substring(lastIndex + 1, path.length());
	        }
	      }
	    }

	    return file;
	  }

	  public static String[] SplitDirAndFile(String path) {
	    String[] arr = new String[2];
	    int lastIndex;

	    if (path != null && path.trim().length() > 0) {
	      path = path.trim();

	      if (!path.endsWith("/")) {
	        lastIndex = path.lastIndexOf("/");

	        if (lastIndex >= 0) {
	          arr[0] = path.substring(0, lastIndex);
	          arr[1] = path.substring(lastIndex + 1, path.length());
	        }
	        else {
	          arr[0] = "/"; //Assume Root Directory
	          arr[1] = path;
	        }
	      }
	      else if (path.length() > 1) {
	        arr[0] = path.substring(0, path.length() - 1);
	      }
	      else {
	        arr[0] = path;
	      }
	    }

	    return arr;
	  }

	  public static String GetFileExt(String filename) {
	    String ext = null;

	    int i = filename.lastIndexOf('.');

	    if (i > 0 && i < filename.length() - 1) {
	      ext = filename.substring(i + 1).toLowerCase();
	    }
	    return ext;
	  }

	}
