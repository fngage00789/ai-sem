package th.co.ais.rpt.domain;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ReportCollectionsBean {

	private List rptList;
	private Set rptSet;
	private Map rptMap;
	private Properties rptProperties;
	
	public ReportCollectionsBean(){
		
	}
	
	public List getRptList() {
		return rptList;
	}
	public void setRptList(List rptList) {
		this.rptList = rptList;
	}
	public Map getRptMap() {
		return rptMap;
	}
	public void setRptMap(Map rptMap) {
		this.rptMap = rptMap;
	}
	public Properties getRptProperties() {
		return rptProperties;
	}
	public void setRptProperties(Properties rptProperties) {
		this.rptProperties = rptProperties;
	}
	public Set getRptSet() {
		return rptSet;
	}
	public void setRptSet(Set rptSet) {
		this.rptSet = rptSet;
	}
}
