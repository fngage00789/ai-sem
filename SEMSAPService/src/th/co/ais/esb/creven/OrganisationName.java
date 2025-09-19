package th.co.ais.esb.creven;

import javax.xml.bind.annotation.XmlElement;

public class OrganisationName {
	
	@XmlElement(name = "FormOfAddressCode", nillable = true)
	private String formOfAddressCode;
	
	@XmlElement(name = "FirstLineName")
	private String firstLineName;
	
	@XmlElement(name = "SecondLineName", nillable = true)
	private String secondLineName;
	
	@XmlElement(name = "ThirdLineName", nillable = true)
	private String thirdLineName;
	
	@XmlElement(name = "FourthLineName", nillable = true)
	private String fourthLineName;

	public String getFormOfAddressCode() {
		return formOfAddressCode;
	}

	public void setFormOfAddressCode(String formOfAddressCode) {
		this.formOfAddressCode = formOfAddressCode;
	}

	public String getFirstLineName() {
		return firstLineName;
	}

	public void setFirstLineName(String firstLineName) {
		this.firstLineName = firstLineName;
	}

	public String getSecondLineName() {
		return secondLineName;
	}

	public void setSecondLineName(String secondLineName) {
		this.secondLineName = secondLineName;
	}

	public String getThirdLineName() {
		return thirdLineName;
	}

	public void setThirdLineName(String thirdLineName) {
		this.thirdLineName = thirdLineName;
	}

	public String getFourthLineName() {
		return fourthLineName;
	}

	public void setFourthLineName(String fourthLineName) {
		this.fourthLineName = fourthLineName;
	}
}
