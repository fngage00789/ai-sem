package th.co.ais.esb.creven;

import javax.xml.bind.annotation.XmlElement;

public class WithholdingTax {
	
	@XmlElement(name = "WithholdingTaxTypeCode")
    private String withholdingTaxTypeCode;

    @XmlElement(name = "SubjectToWithholdingTaxIndicator")
    private boolean subjectToWithholdingTaxIndicator;

    @XmlElement(name = "VendorRecipientTypeCode")
    private String vendorRecipientTypeCode;

    @XmlElement(name = "WithholdingTaxIdentificationNumber", nillable = true)
    private String withholdingTaxIdentificationNumber;

    @XmlElement(name = "WithholdingTaxExemptionReasonCode", nillable = true)
    private String withholdingTaxExemptionReasonCode;

	public String getWithholdingTaxTypeCode() {
		return withholdingTaxTypeCode;
	}

	public void setWithholdingTaxTypeCode(String withholdingTaxTypeCode) {
		this.withholdingTaxTypeCode = withholdingTaxTypeCode;
	}

	public boolean isSubjectToWithholdingTaxIndicator() {
		return subjectToWithholdingTaxIndicator;
	}

	public void setSubjectToWithholdingTaxIndicator(boolean subjectToWithholdingTaxIndicator) {
		this.subjectToWithholdingTaxIndicator = subjectToWithholdingTaxIndicator;
	}

	public String getVendorRecipientTypeCode() {
		return vendorRecipientTypeCode;
	}

	public void setVendorRecipientTypeCode(String vendorRecipientTypeCode) {
		this.vendorRecipientTypeCode = vendorRecipientTypeCode;
	}

	public String getWithholdingTaxIdentificationNumber() {
		return withholdingTaxIdentificationNumber;
	}

	public void setWithholdingTaxIdentificationNumber(String withholdingTaxIdentificationNumber) {
		this.withholdingTaxIdentificationNumber = withholdingTaxIdentificationNumber;
	}

	public String getWithholdingTaxExemptionReasonCode() {
		return withholdingTaxExemptionReasonCode;
	}

	public void setWithholdingTaxExemptionReasonCode(String withholdingTaxExemptionReasonCode) {
		this.withholdingTaxExemptionReasonCode = withholdingTaxExemptionReasonCode;
	}
}
