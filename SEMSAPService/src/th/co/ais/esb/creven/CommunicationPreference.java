package th.co.ais.esb.creven;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class CommunicationPreference {
	
	@XmlAttribute(name = "actionCode")
    private String actionCode;

    @XmlElement(name = "CorrespondenceLanguageCode")
    private String correspondenceLanguageCode;

    @XmlElement(name = "PreferredCommunicationMediumTypeCode", nillable = true)
    private String preferredCommunicationMediumTypeCode;

	public String getActionCode() {
		return actionCode;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

	public String getCorrespondenceLanguageCode() {
		return correspondenceLanguageCode;
	}

	public void setCorrespondenceLanguageCode(String correspondenceLanguageCode) {
		this.correspondenceLanguageCode = correspondenceLanguageCode;
	}

	public String getPreferredCommunicationMediumTypeCode() {
		return preferredCommunicationMediumTypeCode;
	}

	public void setPreferredCommunicationMediumTypeCode(String preferredCommunicationMediumTypeCode) {
		this.preferredCommunicationMediumTypeCode = preferredCommunicationMediumTypeCode;
	}
}
