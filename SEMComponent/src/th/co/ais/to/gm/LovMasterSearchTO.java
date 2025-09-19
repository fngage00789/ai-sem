package th.co.ais.to.gm;

import java.util.List;

import th.co.ais.domain.gm.LovMaster;
import th.co.ais.to.SearchTO;

public class LovMasterSearchTO extends SearchTO {

	private static final long serialVersionUID = -6297566744322806246L;
	private List<LovMaster> resultList = null;
	
	public List<LovMaster> getResultList() {
		return this.resultList;
	}
	
	public void setResultList(List<LovMaster> resultList) {
		this.resultList = resultList;
	}
	


}
