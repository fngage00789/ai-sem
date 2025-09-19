package th.co.ais.rpt.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;

public class DocmosisUtil {
	public static Logger log = Logger.getLogger(DocmosisUtil.class);
	
	public static String getExportPath(Date targetDate) throws Exception {
		StringBuffer result;
		File returnDir = null;
		try{
			{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM", Locale.ENGLISH);
				String pathDate = sdf.format(targetDate);
				String pathBase = DocmosisProperty.getInstance().getExportPath(); 
				result = new StringBuffer();
				result.append(pathBase);
				if(!pathBase.endsWith("/")){ 
					result.append("/");
				}
				result.append(pathDate).append("/");
				returnDir = new File(result.toString());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if(!returnDir.exists()) {
			if(!returnDir.mkdirs()) {
				throw new RuntimeException("Unable to create Directory["+returnDir.getAbsolutePath()+"]");
			}
		}
		
		return returnDir.getAbsolutePath()+"/";
	}
	
	public static String getImagePath() {
		return DocmosisProperty.getInstance().getImagePath();
	}

	public static String getDocmosisReportPath() {
		return DocmosisProperty.getInstance().getDocmosisReportPath();
	}

	public static String getDocmosisSubReportPath() {
		return DocmosisProperty.getInstance().getDocmosisSubReportPath();
	}


}
