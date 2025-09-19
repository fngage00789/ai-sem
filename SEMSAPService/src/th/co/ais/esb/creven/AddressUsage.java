package th.co.ais.esb.creven;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class AddressUsage {
	
	@XmlAttribute(name = "actionCode")
    private String actionCode;

    @XmlElement(name = "AddressUsageCode")
    private String addressUsageCode;

    @XmlElement(name = "ValidityPeriod")
    private ValidityPeriod validityPeriod;

    @XmlElement(name = "DefaultIndicator")
    private boolean defaultIndicator;

	public String getActionCode() {
		return actionCode;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

	public String getAddressUsageCode() {
		return addressUsageCode;
	}

	public void setAddressUsageCode(String addressUsageCode) {
		this.addressUsageCode = addressUsageCode;
	}

	public ValidityPeriod getValidityPeriod() {
		return validityPeriod;
	}

	public void setValidityPeriod(ValidityPeriod validityPeriod) {
		this.validityPeriod = validityPeriod;
	}

	public boolean isDefaultIndicator() {
		return defaultIndicator;
	}

	public void setDefaultIndicator(boolean defaultIndicator) {
		this.defaultIndicator = defaultIndicator;
	}
}
