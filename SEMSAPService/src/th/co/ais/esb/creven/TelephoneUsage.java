package th.co.ais.esb.creven;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class TelephoneUsage {
	
	@XmlAttribute(name = "actionCode")
    private String actionCode;

    @XmlElement(name = "Usage")
    private Usage usage;

    @XmlElement(name = "DefaultIndicator")
    private boolean defaultIndicator;

	public String getActionCode() {
		return actionCode;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

	public Usage getUsage() {
		return usage;
	}

	public void setUsage(Usage usage) {
		this.usage = usage;
	}

	public boolean isDefaultIndicator() {
		return defaultIndicator;
	}

	public void setDefaultIndicator(boolean defaultIndicator) {
		this.defaultIndicator = defaultIndicator;
	}
}
