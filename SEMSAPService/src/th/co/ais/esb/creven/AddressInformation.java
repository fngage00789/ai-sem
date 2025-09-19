package th.co.ais.esb.creven;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class AddressInformation {
	
	@XmlAttribute(name = "actionCode")
    private String actionCode;

    @XmlAttribute(name = "addressUsageListCompleteTransmissionIndicator")
    private boolean addressUsageListCompleteTransmissionIndicator;

    @XmlElement(name = "UUID")
    private String uuid;

    @XmlElement(name = "MoveDestinationAddressUUID", nillable = true)
    private String moveDestinationAddressUUID;

    @XmlElement(name = "MoveDate", nillable = true)
    private String moveDate;

    @XmlElement(name = "ValidityPeriod")
    private ValidityPeriod validityPeriod;

    @XmlElement(name = "AddressUsage")
    private List<AddressUsage> addressUsages;

    @XmlElement(name = "Address")
    private Address address;

	public String getActionCode() {
		return actionCode;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

	public boolean isAddressUsageListCompleteTransmissionIndicator() {
		return addressUsageListCompleteTransmissionIndicator;
	}

	public void setAddressUsageListCompleteTransmissionIndicator(boolean addressUsageListCompleteTransmissionIndicator) {
		this.addressUsageListCompleteTransmissionIndicator = addressUsageListCompleteTransmissionIndicator;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getMoveDestinationAddressUUID() {
		return moveDestinationAddressUUID;
	}

	public void setMoveDestinationAddressUUID(String moveDestinationAddressUUID) {
		this.moveDestinationAddressUUID = moveDestinationAddressUUID;
	}

	public String getMoveDate() {
		return moveDate;
	}

	public void setMoveDate(String moveDate) {
		this.moveDate = moveDate;
	}

	public ValidityPeriod getValidityPeriod() {
		return validityPeriod;
	}

	public void setValidityPeriod(ValidityPeriod validityPeriod) {
		this.validityPeriod = validityPeriod;
	}

	public List<AddressUsage> getAddressUsages() {
		return addressUsages;
	}

	public void setAddressUsages(List<AddressUsage> addressUsages) {
		this.addressUsages = addressUsages;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
