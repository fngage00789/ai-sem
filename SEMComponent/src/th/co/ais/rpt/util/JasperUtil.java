package th.co.ais.rpt.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;

import th.co.ais.rpt.exception.ReportServiceException;

public class JasperUtil {
	public static Logger log = Logger.getLogger(JasperUtil.class);
	
	public static String getExportPath(Date targetDate) throws ReportServiceException {
		StringBuffer result;
		File returnDir = null;
		try{
			{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM", Locale.ENGLISH);
				String pathDate = sdf.format(targetDate);
				String pathBase = JasperProperty.getInstance().getExportPath(); 
				result = new StringBuffer();
				result.append(pathBase);
				if(!pathBase.endsWith("/")){ 
					result.append("/");
				}
				result.append(pathDate).append("/");
				returnDir = new File(result.toString());
			}
		} catch(Exception e) {
			ReportServiceException re = new ReportServiceException(e.getMessage());
			re.initCause(e);
			throw re;
		}
		
		if(!returnDir.exists()) {
			if(!returnDir.mkdirs()) {
				throw new RuntimeException("Unable to create Directory["+returnDir.getAbsolutePath()+"]");
			}
		}

		log.debug("JASPER PATH : ===== " + returnDir.getAbsolutePath()+"/");
		return returnDir.getAbsolutePath()+"/";
	}
	
	public static String getImagePath() {
		return JasperProperty.getInstance().getImagePath();
	}

	public static String getJasperPath() {
		return JasperProperty.getInstance().getJasperPath();
	}

	public static String getJasperSubReportPath() {
		return JasperProperty.getInstance().getJasperSubReportPath();
	}
	
	public static String getMonthName(String month){
		
		return month.equals("01")?"JAN":
				month.equals("02")?"FEB":
					month.equals("03")?"MAR":
						month.equals("04")?"APR":
							month.equals("05")?"MAY":
								month.equals("06")?"JUN":
									month.equals("07")?"JUL":
										month.equals("08")?"AUG":
											month.equals("09")?"SEP":
												month.equals("10")?"OCT":
													month.equals("11")?"NOV":
														month.equals("12")?"DEC": "Invalid month code";
	}


}
