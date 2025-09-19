package th.co.ais.to;

import java.util.List;

import th.co.ais.domain.gm.Region;


public class PopupSearchTO extends SearchTO {

	private static final long serialVersionUID = 2978462959807414296L;
	
	private List<Region> resultList = null;
	
	private String name;
	
	private String code;
	
	public List<Region> getResultList() {
		return this.resultList;
	}
	public void setResultList(List<Region> resultList) {
		this.resultList = resultList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	
}
