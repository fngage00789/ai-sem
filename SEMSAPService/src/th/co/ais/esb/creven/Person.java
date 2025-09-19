package th.co.ais.esb.creven;

import javax.xml.bind.annotation.XmlElement;

public class Person {
	
	@XmlElement(name = "Name")
    private Name name;

    @XmlElement(name = "GenderCode", nillable = true)
    private String genderCode;

    @XmlElement(name = "GenderValueCode", nillable = true)
    private String genderValueCode;

    @XmlElement(name = "BirthPlaceName", nillable = true)
    private String birthPlaceName;

    @XmlElement(name = "BirthDate", nillable = true)
    private String birthDate;

    @XmlElement(name = "BirthdateStatusCode", nillable = true)
    private String birthdateStatusCode;

    @XmlElement(name = "DeathDate", nillable = true)
    private String deathDate;

    @XmlElement(name = "MaritalStatusCode", nillable = true)
    private String maritalStatusCode;

    @XmlElement(name = "NonVerbalCommunicationLanguageCode", nillable = true)
    private String nonVerbalCommunicationLanguageCode;

    @XmlElement(name = "OccupationCode", nillable = true)
    private String occupationCode;

    @XmlElement(name = "Employer", nillable = true)
    private String employer;

    @XmlElement(name = "NationalityCountryCode", nillable = true)
    private String nationalityCountryCode;

    @XmlElement(name = "OriginCountryCode", nillable = true)
    private String originCountryCode;

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getGenderCode() {
		return genderCode;
	}

	public void setGenderCode(String genderCode) {
		this.genderCode = genderCode;
	}

	public String getGenderValueCode() {
		return genderValueCode;
	}

	public void setGenderValueCode(String genderValueCode) {
		this.genderValueCode = genderValueCode;
	}

	public String getBirthPlaceName() {
		return birthPlaceName;
	}

	public void setBirthPlaceName(String birthPlaceName) {
		this.birthPlaceName = birthPlaceName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthdateStatusCode() {
		return birthdateStatusCode;
	}

	public void setBirthdateStatusCode(String birthdateStatusCode) {
		this.birthdateStatusCode = birthdateStatusCode;
	}

	public String getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(String deathDate) {
		this.deathDate = deathDate;
	}

	public String getMaritalStatusCode() {
		return maritalStatusCode;
	}

	public void setMaritalStatusCode(String maritalStatusCode) {
		this.maritalStatusCode = maritalStatusCode;
	}

	public String getNonVerbalCommunicationLanguageCode() {
		return nonVerbalCommunicationLanguageCode;
	}

	public void setNonVerbalCommunicationLanguageCode(String nonVerbalCommunicationLanguageCode) {
		this.nonVerbalCommunicationLanguageCode = nonVerbalCommunicationLanguageCode;
	}

	public String getOccupationCode() {
		return occupationCode;
	}

	public void setOccupationCode(String occupationCode) {
		this.occupationCode = occupationCode;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public String getNationalityCountryCode() {
		return nationalityCountryCode;
	}

	public void setNationalityCountryCode(String nationalityCountryCode) {
		this.nationalityCountryCode = nationalityCountryCode;
	}

	public String getOriginCountryCode() {
		return originCountryCode;
	}

	public void setOriginCountryCode(String originCountryCode) {
		this.originCountryCode = originCountryCode;
	}
}
