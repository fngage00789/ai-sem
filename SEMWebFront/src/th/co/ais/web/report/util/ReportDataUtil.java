package th.co.ais.web.report.util;

import java.util.Iterator;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.gm.Company;
import th.co.ais.rpt.util.DateUtil;
import th.co.ais.service.gm.ICompanyService;
import th.co.ais.web.util.FacesUtils;

@SuppressWarnings("unchecked")
public class ReportDataUtil {
	
	private static final Logger log = Logger.getLogger(DateUtil.class);
	
	public static String convertSelectItem2StringByLabel(List<SelectItem> listValue){
		List<SelectItem> listSelectItem = null;
		SelectItem selectItem = null;
		String strPattern = "";
		
		try{
			if((listValue != null) && (listValue.size() > 0)){
				listSelectItem = listValue;
				for(Iterator it = listSelectItem.iterator(); it.hasNext();){
					selectItem = (SelectItem) it.next();		
					strPattern += selectItem.getLabel();
					strPattern += ",";
				}
				
				strPattern = strPattern.substring(0, strPattern.lastIndexOf(","));
			}
		}catch (Exception e) {
			log.error("ERROR IN " + ReportDataUtil.class + e);
		}
		
		return strPattern;
	}
	
	public static String convertSelectItem2StringByValue(List<SelectItem> listValue){
		List<SelectItem> listSelectItem = null;
		SelectItem selectItem = null;
		String strPattern = "";
		
		try{
			if((listValue != null) && (listValue.size() > 0)){
				listSelectItem = listValue;
				for(Iterator it = listSelectItem.iterator(); it.hasNext();){
					selectItem = (SelectItem) it.next();
					strPattern += selectItem.getValue();
					strPattern += ",";
				}
				
				strPattern = strPattern.substring(0, strPattern.lastIndexOf(","));
			}
		}catch (Exception e) {
			log.error("ERROR IN " + ReportDataUtil.class + e);;
		}
		
		return strPattern;
	}
		
}
