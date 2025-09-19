package th.co.ais.site.to;

import java.util.List;

import th.co.ais.domain.site.SiteApprove;
import th.co.ais.to.SearchTO;

public class SiteApproveSearchTO extends SearchTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6297566744322806246L;
	private List<SiteApprove> resultList = null;
	
	public List<SiteApprove> getResultList() {
		return this.resultList;
	}
	
	public void setResultList(List<SiteApprove> resultList) {
		this.resultList = resultList;
	}
	


}
