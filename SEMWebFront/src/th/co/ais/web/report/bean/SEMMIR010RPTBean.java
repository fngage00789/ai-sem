package th.co.ais.web.report.bean;

import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.web.report.AbstractReportBean;

/**
 * @author Warawit Kitmongkonsak
 * 
 */
public class SEMMIR010RPTBean extends AbstractReportBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6210441483221139569L;

	public SEMMIR010RPTBean() {
		super(ServiceConstants.TYPE_DOC);
	}

	private String paymentId;

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
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
