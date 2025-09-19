package th.co.ais.web.report.bean;

import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.web.report.AbstractReportBean;

/**
 * @author Warawit Kitmongkonsak
 * 
 */
public class SEMECO001Bean extends AbstractReportBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5202411731009314539L;

	public SEMECO001Bean() {
		super(ServiceConstants.TYPE_DOC);
	}

	private String contractDocId;
	private String contractDocType;
	private String contractFileId;
	private String contractDocTypeNew;

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

	public String getContractFileId() {
		return contractFileId;
	}

	public void setContractFileId(String contractFileId) {
		this.contractFileId = contractFileId;
	}

	public String getContractDocTypeNew() {
		return contractDocTypeNew;
	}

	public void setContractDocTypeNew(String contractDocTypeNew) {
		this.contractDocTypeNew = contractDocTypeNew;
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
