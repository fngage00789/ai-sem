package th.co.ais.esb.creven;

import javax.xml.bind.annotation.XmlElement;

public class Group {
	
	@XmlElement(name = "FormOfAddressCode", nillable = true)
    private String formOfAddressCode;

    @XmlElement(name = "Name", nillable = true)
    private String name;

    @XmlElement(name = "AdditionalName", nillable = true)
    private String additionalName;

    @XmlElement(name = "PartnerGroupTypeCode", nillable = true)
    private String partnerGroupTypeCode;

	public String getFormOfAddressCode() {
		return formOfAddressCode;
	}

	public void setFormOfAddressCode(String formOfAddressCode) {
		this.formOfAddressCode = formOfAddressCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdditionalName() {
		return additionalName;
	}

	public void setAdditionalName(String additionalName) {
		this.additionalName = additionalName;
	}

	public String getPartnerGroupTypeCode() {
		return partnerGroupTypeCode;
	}

	public void setPartnerGroupTypeCode(String partnerGroupTypeCode) {
		this.partnerGroupTypeCode = partnerGroupTypeCode;
	}
}
