package th.co.ais.esb.creven;

import javax.xml.bind.annotation.XmlElement;

public class Organisation {
	
	@XmlElement(name = "Name")
    private OrganisationName name;

    @XmlElement(name = "CompanyLegalFormCode", nillable = true)
    private String companyLegalFormCode;

    @XmlElement(name = "LegalEntityTypeCode", nillable = true)
    private String legalEntityTypeCode;

    @XmlElement(name = "FoundationDate", nillable = true)
    private String foundationDate;

    @XmlElement(name = "LiquidationDate", nillable = true)
    private String liquidationDate;

	public OrganisationName getName() {
		return name;
	}

	public void setName(OrganisationName name) {
		this.name = name;
	}

	public String getCompanyLegalFormCode() {
		return companyLegalFormCode;
	}

	public void setCompanyLegalFormCode(String companyLegalFormCode) {
		this.companyLegalFormCode = companyLegalFormCode;
	}

	public String getLegalEntityTypeCode() {
		return legalEntityTypeCode;
	}

	public void setLegalEntityTypeCode(String legalEntityTypeCode) {
		this.legalEntityTypeCode = legalEntityTypeCode;
	}

	public String getFoundationDate() {
		return foundationDate;
	}

	public void setFoundationDate(String foundationDate) {
		this.foundationDate = foundationDate;
	}

	public String getLiquidationDate() {
		return liquidationDate;
	}

	public void setLiquidationDate(String liquidationDate) {
		this.liquidationDate = liquidationDate;
	}
}
