package th.co.ais.sso.ws.to;

public class ParameterList implements java.io.Serializable {
	private static final long serialVersionUID = -206748501204990197L;

	private String parameterType;

	private Parameter[] parameter;

	private ParameterList[] parameterList;

	public String getParameterType() {
		return parameterType;
	}

	public void setParameterType(String parameterType) {
		this.parameterType = parameterType;
	}

	public Parameter[] getParameter() {
		return parameter;
	}

	public void setParameter(Parameter[] parameter) {
		this.parameter = parameter;
	}

	public ParameterList[] getParameterList() {
		return parameterList;
	}

	public void setParameterList(ParameterList[] parameterList) {
		this.parameterList = parameterList;
	}
}