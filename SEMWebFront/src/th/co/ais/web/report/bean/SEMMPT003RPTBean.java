package th.co.ais.web.report.bean;

import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.web.report.AbstractReportBean;

/**
 * @author Warawit Kitmongkonsak
 * 
 */
public class SEMMPT003RPTBean extends AbstractReportBean{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2774627498334111660L;
	/**
	 * 
	 */

	public SEMMPT003RPTBean() {
		super(ServiceConstants.TYPE_XLS);
	}
	
	@Override
	public int getRowPerPage() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setRowPerPage(int rowPerPage) {
		// TODO Auto-generated method stub
		
	}

}
