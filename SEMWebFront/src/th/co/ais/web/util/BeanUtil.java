package th.co.ais.web.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import th.co.ais.web.action.AbstractBaseAction;

public class BeanUtil extends AbstractBaseAction {
	
	public String showDateInTh(Date inputDate){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		if(inputDate != null)
			return sdf.format(inputDate);
		else
			return null;
	}
}
