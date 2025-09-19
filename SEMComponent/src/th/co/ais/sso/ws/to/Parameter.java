package th.co.ais.sso.ws.to;

public class Parameter implements java.io.Serializable {
	private static final long serialVersionUID = -4512169396614414347L;

	private String name;

	private String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}