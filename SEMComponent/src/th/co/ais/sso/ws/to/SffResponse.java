package th.co.ais.sso.ws.to;

public class SffResponse implements java.io.Serializable {
	private static final long serialVersionUID = -3763787766268896141L;

	private String errorMessage;

	private ParameterList parameterList;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public ParameterList getParameterList() {
		return parameterList;
	}

	public void setParameterList(ParameterList parameterList) {
		this.parameterList = parameterList;
	}
}