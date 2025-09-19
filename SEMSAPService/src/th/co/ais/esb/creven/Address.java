package th.co.ais.esb.creven;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Address {

	@XmlAttribute(name = "addressNoteListCompleteTransmissionIndicator")
	private boolean addressNoteListCompleteTransmissionIndicator;
	
	@XmlAttribute(name = "emailListCompleteTransmissionIndicator")
	private boolean emailListCompleteTransmissionIndicator;
	
	@XmlElement(name = "CommunicationPreference")
	private CommunicationPreference communicationPreference;
	
	@XmlElement(name = "PostalAddress")
	private PostalAddress postalAddress;
	
	@XmlElement(name = "Telephone")
	private Telephone telephone;

	public boolean isAddressNoteListCompleteTransmissionIndicator() {
		return addressNoteListCompleteTransmissionIndicator;
	}

	public void setAddressNoteListCompleteTransmissionIndicator(boolean addressNoteListCompleteTransmissionIndicator) {
		this.addressNoteListCompleteTransmissionIndicator = addressNoteListCompleteTransmissionIndicator;
	}

	public boolean isEmailListCompleteTransmissionIndicator() {
		return emailListCompleteTransmissionIndicator;
	}

	public void setEmailListCompleteTransmissionIndicator(boolean emailListCompleteTransmissionIndicator) {
		this.emailListCompleteTransmissionIndicator = emailListCompleteTransmissionIndicator;
	}

	public CommunicationPreference getCommunicationPreference() {
		return communicationPreference;
	}

	public void setCommunicationPreference(CommunicationPreference communicationPreference) {
		this.communicationPreference = communicationPreference;
	}

	public PostalAddress getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(PostalAddress postalAddress) {
		this.postalAddress = postalAddress;
	}

	public Telephone getTelephone() {
		return telephone;
	}

	public void setTelephone(Telephone telephone) {
		this.telephone = telephone;
	}
}
