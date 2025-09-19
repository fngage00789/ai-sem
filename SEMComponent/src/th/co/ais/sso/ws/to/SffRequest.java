package th.co.ais.sso.ws.to;

public class SffRequest implements java.io.Serializable {
	private static final long serialVersionUID = 3336763097279926950L;

	private String event;

	private ParameterList parameterList;

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public ParameterList getParameterList() {
		return parameterList;
	}

	public void setParameterList(ParameterList parameterList) {
		this.parameterList = parameterList;
	}
}