package th.co.ais.esb.creven;

import javax.xml.bind.annotation.XmlElement;

public class Name {
	
	@XmlElement(name = "FormOfAddressCode", nillable = true)
    private String formOfAddressCode;

    @XmlElement(name = "GivenName", nillable = true)
    private String givenName;

    @XmlElement(name = "MiddleName", nillable = true)
    private String middleName;

    @XmlElement(name = "FamilyName", nillable = true)
    private String familyName;

    @XmlElement(name = "AdditionalFamilyName", nillable = true)
    private String additionalFamilyName;

    @XmlElement(name = "BirthName", nillable = true)
    private String birthName;

    @XmlElement(name = "NickName", nillable = true)
    private String nickName;

    @XmlElement(name = "InitialsName", nillable = true)
    private String initialsName;

    @XmlElement(name = "AcademicTitleCode", nillable = true)
    private String academicTitleCode;

    @XmlElement(name = "AdditionalAcademicTitleCode", nillable = true)
    private String additionalAcademicTitleCode;

    @XmlElement(name = "NamePrefixCode", nillable = true)
    private String namePrefixCode;

    @XmlElement(name = "AdditionalNamePrefixCode", nillable = true)
    private String additionalNamePrefixCode;

    @XmlElement(name = "NameSupplementCode", nillable = true)
    private String nameSupplementCode;

    @XmlElement(name = "DeviatingFullName", nillable = true)
    private String deviatingFullName;

    @XmlElement(name = "NameFormatCountryCode", nillable = true)
    private String nameFormatCountryCode;

    @XmlElement(name = "NameFormatCode", nillable = true)
    private String nameFormatCode;

	public String getFormOfAddressCode() {
		return formOfAddressCode;
	}

	public void setFormOfAddressCode(String formOfAddressCode) {
		this.formOfAddressCode = formOfAddressCode;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getAdditionalFamilyName() {
		return additionalFamilyName;
	}

	public void setAdditionalFamilyName(String additionalFamilyName) {
		this.additionalFamilyName = additionalFamilyName;
	}

	public String getBirthName() {
		return birthName;
	}

	public void setBirthName(String birthName) {
		this.birthName = birthName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getInitialsName() {
		return initialsName;
	}

	public void setInitialsName(String initialsName) {
		this.initialsName = initialsName;
	}

	public String getAcademicTitleCode() {
		return academicTitleCode;
	}

	public void setAcademicTitleCode(String academicTitleCode) {
		this.academicTitleCode = academicTitleCode;
	}

	public String getAdditionalAcademicTitleCode() {
		return additionalAcademicTitleCode;
	}

	public void setAdditionalAcademicTitleCode(String additionalAcademicTitleCode) {
		this.additionalAcademicTitleCode = additionalAcademicTitleCode;
	}

	public String getNamePrefixCode() {
		return namePrefixCode;
	}

	public void setNamePrefixCode(String namePrefixCode) {
		this.namePrefixCode = namePrefixCode;
	}

	public String getAdditionalNamePrefixCode() {
		return additionalNamePrefixCode;
	}

	public void setAdditionalNamePrefixCode(String additionalNamePrefixCode) {
		this.additionalNamePrefixCode = additionalNamePrefixCode;
	}

	public String getNameSupplementCode() {
		return nameSupplementCode;
	}

	public void setNameSupplementCode(String nameSupplementCode) {
		this.nameSupplementCode = nameSupplementCode;
	}

	public String getDeviatingFullName() {
		return deviatingFullName;
	}

	public void setDeviatingFullName(String deviatingFullName) {
		this.deviatingFullName = deviatingFullName;
	}

	public String getNameFormatCountryCode() {
		return nameFormatCountryCode;
	}

	public void setNameFormatCountryCode(String nameFormatCountryCode) {
		this.nameFormatCountryCode = nameFormatCountryCode;
	}

	public String getNameFormatCode() {
		return nameFormatCode;
	}

	public void setNameFormatCode(String nameFormatCode) {
		this.nameFormatCode = nameFormatCode;
	}
}
