package th.co.ais.to.gm;

import java.util.List;

import th.co.ais.domain.gm.ParameterMasterSP;
import th.co.ais.to.SearchTO;

public class ParameterMasterSearchTO extends SearchTO {

	private static final long serialVersionUID = -6297566744322806246L;
	private List<ParameterMasterSP> resultList = null;
	
	public List<ParameterMasterSP> getResultList() {
		return this.resultList;
	}
	
	public void setResultList(List<ParameterMasterSP> resultList) {
		this.resultList = resultList;
	}
	


}
