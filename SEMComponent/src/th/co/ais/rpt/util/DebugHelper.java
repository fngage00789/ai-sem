package th.co.ais.rpt.util;

import java.text.SimpleDateFormat;
import java.util.Locale;

import org.apache.log4j.Logger;

public class DebugHelper {
	
	public static void logInvoke(Object obj) {
		Logger log = Logger.getLogger(DebugHelper.class);
		
		if(log.isDebugEnabled()) {
			logInvoke(log, BeanReflexUtil.castToString(obj));
		}
	}
	
	public static void logInvoke(Logger log, Object obj) {
		if(log.isDebugEnabled()) {
			logInvoke(log, BeanReflexUtil.castToString(obj));
		}
	}
	

	public static void logInvoke(Logger log, String msg, Object obj[]) {
		if(log.isDebugEnabled()) {
			StringBuffer sb = new StringBuffer();
			sb.append("---- ").append(msg).append("\n");
			
			for(int i=0;i<obj.length;i++) {
				sb.append("-- Param["+i+"]:").append(BeanReflexUtil.castToString(obj[i])).append("\n");
			}
			
			logInvoke(log, sb.toString());
		}
	}
	
	public static void logInvoke(Logger log, String msg) {
		
		StackTraceElement ste[] = new Exception().getStackTrace();
		StringBuffer sb = new StringBuffer();
		sb.append("\nInvoke from \n");
		int base=0;
		while(ste[base].getClassName().endsWith("DebugHelper")) {
			base++;
		}
		for(int i=0;((base+i)<ste.length)&&(i<10);i++) {
			if(ste[base+i].isNativeMethod()) {
				sb	.append("DEEP LV ").append(base+i).append("  : !!! Native method (")
				.append(ste[base+i].getFileName()).append(" line ")
				.append(ste[base+i].getLineNumber()).append(")\n");
				break;
			} else
			{
				sb	.append("DEEP LV ").append(base+i).append("  :")
					.append(ste[base+i].getMethodName()).append(" (")
					.append(ste[base+i].getFileName()).append(" line ")
					.append(ste[base+i].getLineNumber()).append(")\n");
			}
		}
		sb.append("\n");
		sb.append(msg).append("\n");
		log.debug(sb.toString());
	}
}
