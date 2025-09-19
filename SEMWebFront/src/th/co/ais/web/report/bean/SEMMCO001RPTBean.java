package th.co.ais.web.report.bean;

import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.web.report.AbstractReportBean;

/**
 * @author Warawit Kitmongkonsak
 * 
 */
public class SEMMCO001RPTBean extends AbstractReportBean{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6537092104898352916L;

	public SEMMCO001RPTBean() {
		super(ServiceConstants.TYPE_DOC);
	}
	
	private String contractDocId;
	private String contractDocType;

	public String getContractDocId() {
		return contractDocId;
	}
	public void setContractDocId(String contractDocId) {
		this.contractDocId = contractDocId;
	}
	public String getContractDocType() {
		return contractDocType;
	}
	public void setContractDocType(String contractDocType) {
		this.contractDocType = contractDocType;
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
