package th.co.ais.web.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.Pointer;
import org.apache.commons.lang.StringUtils;

public class SEMXPathSearch implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	public static Object xSearch(Object listObj, List<String[]> columnNdata) throws Exception {
		
		StringBuffer criteria = new StringBuffer();
		criteria.append(setStringCriteria(columnNdata));
		System.out.println("criteria" + criteria.toString());

		JXPathContext context = JXPathContext.newContext(listObj);
		Iterator results = context.iteratePointers(criteria.toString());

		List<Object> listRe = new ArrayList<Object>();
		if (results.hasNext()) {
			for (Iterator iter = results; iter.hasNext();) {
				Pointer pt = (Pointer) iter.next();
				Object result = (Object) pt.getValue();
				listRe.add(result);
			}

		}
		Object listObjr = listRe;

		return listObjr;
	}

	public static Iterator xSearchIterator(Object listObj, List<String[]> columnNdata)
			throws Exception {

		StringBuffer critie = new StringBuffer();
		critie.append(setStringCriteria(columnNdata));
		System.out.println(critie.toString());

		JXPathContext context = JXPathContext.newContext(listObj);
		Iterator results = context.iteratePointers(critie.toString());

		return results;
	}

	public static String setStringCriteria(List<String[]> columnNdata) {

		StringBuffer critie = new StringBuffer();
		critie.append(".[");

		for (int i = 0; i < columnNdata.size(); i++) {
			String ar = "";
			if (i != 0) {
				ar = "and ";
			}

			String cri = ""
					+ ar
					+ setStringColumnNdata(columnNdata.get(i)[0], columnNdata
							.get(i)[1]);
			critie.append(cri);
		}

		critie.append("]");

		return critie.toString();
	}

	public static String setStringColumnNdata(String columnName, String data) {

		String strCri = "";
		if (StringUtils.isNotBlank(columnName) && StringUtils.isNotBlank(data)) {
			if ((data.startsWith("*") || data.startsWith("%"))
					&& (data.endsWith("*") || data.endsWith("%"))) {
				data = data.replace("*", "");
				data = data.replace("%", "");
				// *%data*%
				strCri = "contains(" + columnName + ",'" + data + "')";

			} else if (data.endsWith("*") || data.endsWith("%")) {
				// data*%
				data = data.replace("*", "");
				data = data.replace("%", "");
				strCri = "starts-with(" + columnName + ",'" + data + "')";

			} else if (data.startsWith("*") || data.startsWith("%")) {
				// *%data
				data = data.replace("*", "");
				data = data.replace("%", "");
				strCri = "ends-with(" + columnName + ",'" + data + "')";

			} else {
				// data
				strCri = "(" + columnName + "='" + data + "')";

			}
		} else {
			strCri = "contains(" + columnName + ",'" + data + "')";
		}

		return strCri;
	}

}
