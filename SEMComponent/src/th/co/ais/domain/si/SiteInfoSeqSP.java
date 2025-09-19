package th.co.ais.domain.si;

import java.io.Serializable;

public class SiteInfoSeqSP implements Serializable {

	private static final long serialVersionUID = 543450742262449179L;
	
	private String seqNo;
	
	private String contractNo;

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	

}
