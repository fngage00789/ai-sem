package th.co.ais.rpt.parameter;

import java.io.Serializable;

/**
 * @author Warawit
 *
 */
public class SFRMO001ReportParameter implements Serializable{

	private static final long serialVersionUID = 878182954028807443L;
	
	private String scheduleDateFrom;
	private String scheduleDateTo;
	private String requestDateFrom;
	private String requestDateTo;
	private String status;
	private String userName;
	
	public String getScheduleDateFrom() {
		return scheduleDateFrom;
	}
	public void setScheduleDateFrom(String scheduleDateFrom) {
		this.scheduleDateFrom = scheduleDateFrom;
	}
	public String getScheduleDateTo() {
		return scheduleDateTo;
	}
	public void setScheduleDateTo(String scheduleDateTo) {
		this.scheduleDateTo = scheduleDateTo;
	}	
	public String getRequestDateFrom() {
		return requestDateFrom;
	}
	public void setRequestDateFrom(String requestDateFrom) {
		this.requestDateFrom = requestDateFrom;
	}
	public String getRequestDateTo() {
		return requestDateTo;
	}
	public void setRequestDateTo(String requestDateTo) {
		this.requestDateTo = requestDateTo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}	
}
