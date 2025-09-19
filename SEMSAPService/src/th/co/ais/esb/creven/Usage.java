package th.co.ais.esb.creven;

import javax.xml.bind.annotation.XmlElement;

public class Usage {
	
	@XmlElement(name = "Code")
    private String code;

    @XmlElement(name = "ValidityPeriod")
    private ValidityPeriod validityPeriod;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ValidityPeriod getValidityPeriod() {
		return validityPeriod;
	}

	public void setValidityPeriod(ValidityPeriod validityPeriod) {
		this.validityPeriod = validityPeriod;
	}
}
