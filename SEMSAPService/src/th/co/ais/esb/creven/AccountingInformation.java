package th.co.ais.esb.creven;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class AccountingInformation {
	
	@XmlAttribute(name = "actionCode")
	private String actionCode;
	
	@XmlAttribute(name = "dunningInformationListCompleteTransmissionIndicator")
	private boolean dunningInformationListCompleteTransmissionIndicator;
	
	@XmlAttribute(name = "withholdingTaxListCompleteTransmissionIndicator")
	private boolean withholdingTaxListCompleteTransmissionIndicator;
	
	@XmlAttribute(name = "accountingTextListCompleteTransmissionIndicator")
	private boolean accountingTextListCompleteTransmissionIndicator;
	
	@XmlAttribute(name = "permittedPayeeListCompleteTransmissionIndicator")
	private boolean permittedPayeeListCompleteTransmissionIndicator;
	
	@XmlElement(name = "CompanyID")
	private String companyID;
	
	@XmlElement(name = "BlockedIndicator")
	private boolean blockedIndicator;
	
	@XmlElement(name = "GeneralLedgerAccountReference")
	private GeneralLedgerAccountReference generalLedgerAccountReference;
	
	@XmlElement(name = "AuthorisationGroupCode", nillable = true)
	private String authorisationGroupCode;
	
	@XmlElement(name = "WithholdingTax")
	private List<WithholdingTax> withholdingTax;

	public String getActionCode() {
		return actionCode;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

	public boolean isDunningInformationListCompleteTransmissionIndicator() {
		return dunningInformationListCompleteTransmissionIndicator;
	}

	public void setDunningInformationListCompleteTransmissionIndicator(
			boolean dunningInformationListCompleteTransmissionIndicator) {
		this.dunningInformationListCompleteTransmissionIndicator = dunningInformationListCompleteTransmissionIndicator;
	}

	public boolean isWithholdingTaxListCompleteTransmissionIndicator() {
		return withholdingTaxListCompleteTransmissionIndicator;
	}

	public void setWithholdingTaxListCompleteTransmissionIndicator(
			boolean withholdingTaxListCompleteTransmissionIndicator) {
		this.withholdingTaxListCompleteTransmissionIndicator = withholdingTaxListCompleteTransmissionIndicator;
	}

	public boolean isAccountingTextListCompleteTransmissionIndicator() {
		return accountingTextListCompleteTransmissionIndicator;
	}

	public void setAccountingTextListCompleteTransmissionIndicator(
			boolean accountingTextListCompleteTransmissionIndicator) {
		this.accountingTextListCompleteTransmissionIndicator = accountingTextListCompleteTransmissionIndicator;
	}

	public boolean isPermittedPayeeListCompleteTransmissionIndicator() {
		return permittedPayeeListCompleteTransmissionIndicator;
	}

	public void setPermittedPayeeListCompleteTransmissionIndicator(
			boolean permittedPayeeListCompleteTransmissionIndicator) {
		this.permittedPayeeListCompleteTransmissionIndicator = permittedPayeeListCompleteTransmissionIndicator;
	}

	public String getCompanyID() {
		return companyID;
	}

	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}

	public boolean isBlockedIndicator() {
		return blockedIndicator;
	}

	public void setBlockedIndicator(boolean blockedIndicator) {
		this.blockedIndicator = blockedIndicator;
	}

	public GeneralLedgerAccountReference getGeneralLedgerAccountReference() {
		return generalLedgerAccountReference;
	}

	public void setGeneralLedgerAccountReference(GeneralLedgerAccountReference generalLedgerAccountReference) {
		this.generalLedgerAccountReference = generalLedgerAccountReference;
	}

	public String getAuthorisationGroupCode() {
		return authorisationGroupCode;
	}

	public void setAuthorisationGroupCode(String authorisationGroupCode) {
		this.authorisationGroupCode = authorisationGroupCode;
	}

	public List<WithholdingTax> getWithholdingTax() {
		return withholdingTax;
	}

	public void setWithholdingTax(List<WithholdingTax> withholdingTax) {
		this.withholdingTax = withholdingTax;
	}
}
