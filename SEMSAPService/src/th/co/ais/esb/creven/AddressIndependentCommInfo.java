package th.co.ais.esb.creven;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class AddressIndependentCommInfo {
	
	@XmlAttribute(name = "actionCode")
    private String actionCode;

    @XmlAttribute(name = "emailListCompleteTransmissionIndicator")
    private boolean emailListCompleteTransmissionIndicator;

    @XmlAttribute(name = "facsimileListCompleteTransmissionIndicator")
    private boolean facsimileListCompleteTransmissionIndicator;

    @XmlAttribute(name = "telephoneListCompleteTransmissionIndicator")
    private boolean telephoneListCompleteTransmissionIndicator;

    @XmlAttribute(name = "webListCompleteTransmissionIndicator")
    private boolean webListCompleteTransmissionIndicator;

    @XmlElement(name = "CommunicationPreference", nillable = true)
    private String communicationPreference;

	public String getActionCode() {
		return actionCode;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

	public boolean isEmailListCompleteTransmissionIndicator() {
		return emailListCompleteTransmissionIndicator;
	}

	public void setEmailListCompleteTransmissionIndicator(boolean emailListCompleteTransmissionIndicator) {
		this.emailListCompleteTransmissionIndicator = emailListCompleteTransmissionIndicator;
	}

	public boolean isFacsimileListCompleteTransmissionIndicator() {
		return facsimileListCompleteTransmissionIndicator;
	}

	public void setFacsimileListCompleteTransmissionIndicator(boolean facsimileListCompleteTransmissionIndicator) {
		this.facsimileListCompleteTransmissionIndicator = facsimileListCompleteTransmissionIndicator;
	}

	public boolean isTelephoneListCompleteTransmissionIndicator() {
		return telephoneListCompleteTransmissionIndicator;
	}

	public void setTelephoneListCompleteTransmissionIndicator(boolean telephoneListCompleteTransmissionIndicator) {
		this.telephoneListCompleteTransmissionIndicator = telephoneListCompleteTransmissionIndicator;
	}

	public boolean isWebListCompleteTransmissionIndicator() {
		return webListCompleteTransmissionIndicator;
	}

	public void setWebListCompleteTransmissionIndicator(boolean webListCompleteTransmissionIndicator) {
		this.webListCompleteTransmissionIndicator = webListCompleteTransmissionIndicator;
	}

	public String getCommunicationPreference() {
		return communicationPreference;
	}

	public void setCommunicationPreference(String communicationPreference) {
		this.communicationPreference = communicationPreference;
	}
}
