package th.co.ais.web.report.bean;

import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.web.report.AbstractReportBean;

/**
 * @author Warawit Kitmongkonsak
 * 
 */
public class SEMECP001Bean extends AbstractReportBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1324779926921700920L;

	public SEMECP001Bean() {
		super(ServiceConstants.TYPE_DOC);
	}

	private String siteConstructId;

	public String getSiteConstructId() {
		return siteConstructId;
	}

	public void setSiteConstructId(String siteConstructId) {
		this.siteConstructId = siteConstructId;
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
