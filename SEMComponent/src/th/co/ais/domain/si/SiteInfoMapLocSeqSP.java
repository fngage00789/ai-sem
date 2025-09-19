package th.co.ais.domain.si;

import java.io.Serializable;

public class SiteInfoMapLocSeqSP implements Serializable {
	
	private static final long serialVersionUID = 6194466250173946793L;

	private String seqNo;

	private String siteInfoId;

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	public String getSiteInfoId() {
		return siteInfoId;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	
	

}
