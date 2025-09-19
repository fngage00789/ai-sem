package th.co.ais.esb.creven;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Telephone {
	
	@XmlAttribute(name = "actionCode")
    private String actionCode;

    @XmlElement(name = "Number")
    private TelephoneNumber number;

    @XmlElement(name = "FormattedNumberDescription")
    private String formattedNumberDescription;

    @XmlElement(name = "UsageDeniedIndicator")
    private boolean usageDeniedIndicator;

    @XmlElement(name = "ValidityPeriod")
    private ValidityPeriod validityPeriod;

    @XmlElement(name = "MobilePhoneNumberIndicator")
    private boolean mobilePhoneNumberIndicator;

    @XmlElement(name = "SMSEnabledIndicator")
    private boolean smsEnabledIndicator;

    @XmlElement(name = "TelephoneUsage")
    private List<TelephoneUsage> telephoneUsages;

	public String getActionCode() {
		return actionCode;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

	public TelephoneNumber getNumber() {
		return number;
	}

	public void setNumber(TelephoneNumber number) {
		this.number = number;
	}

	public String getFormattedNumberDescription() {
		return formattedNumberDescription;
	}

	public void setFormattedNumberDescription(String formattedNumberDescription) {
		this.formattedNumberDescription = formattedNumberDescription;
	}

	public boolean isUsageDeniedIndicator() {
		return usageDeniedIndicator;
	}

	public void setUsageDeniedIndicator(boolean usageDeniedIndicator) {
		this.usageDeniedIndicator = usageDeniedIndicator;
	}

	public ValidityPeriod getValidityPeriod() {
		return validityPeriod;
	}

	public void setValidityPeriod(ValidityPeriod validityPeriod) {
		this.validityPeriod = validityPeriod;
	}

	public boolean isMobilePhoneNumberIndicator() {
		return mobilePhoneNumberIndicator;
	}

	public void setMobilePhoneNumberIndicator(boolean mobilePhoneNumberIndicator) {
		this.mobilePhoneNumberIndicator = mobilePhoneNumberIndicator;
	}

	public boolean isSmsEnabledIndicator() {
		return smsEnabledIndicator;
	}

	public void setSmsEnabledIndicator(boolean smsEnabledIndicator) {
		this.smsEnabledIndicator = smsEnabledIndicator;
	}

	public List<TelephoneUsage> getTelephoneUsages() {
		return telephoneUsages;
	}

	public void setTelephoneUsages(List<TelephoneUsage> telephoneUsages) {
		this.telephoneUsages = telephoneUsages;
	}
}
