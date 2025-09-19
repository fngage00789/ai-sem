package th.co.ais.esb.creven;

import javax.xml.bind.annotation.XmlElement;

public class CreditManagementCreditWorthiness {
	
	@XmlElement(name = "AffidavitForAssetsMadeIndicator")
    private boolean affidavitForAssetsMadeIndicator;

    @XmlElement(name = "AffidavitForAssetsMadeDate", nillable = true)
    private String affidavitForAssetsMadeDate;

    @XmlElement(name = "BankruptcyProceedingsInitiatedIndicator")
    private boolean bankruptcyProceedingsInitiatedIndicator;

    @XmlElement(name = "BankruptcyProceedingsInitiatedDate", nillable = true)
    private String bankruptcyProceedingsInitiatedDate;

    @XmlElement(name = "ForeclosureProceedingsInitiatedIndicator")
    private boolean foreclosureProceedingsInitiatedIndicator;

    @XmlElement(name = "ForeclosureProceedingsInitiatedDate", nillable = true)
    private String foreclosureProceedingsInitiatedDate;

	public boolean isAffidavitForAssetsMadeIndicator() {
		return affidavitForAssetsMadeIndicator;
	}

	public void setAffidavitForAssetsMadeIndicator(boolean affidavitForAssetsMadeIndicator) {
		this.affidavitForAssetsMadeIndicator = affidavitForAssetsMadeIndicator;
	}

	public String getAffidavitForAssetsMadeDate() {
		return affidavitForAssetsMadeDate;
	}

	public void setAffidavitForAssetsMadeDate(String affidavitForAssetsMadeDate) {
		this.affidavitForAssetsMadeDate = affidavitForAssetsMadeDate;
	}

	public boolean isBankruptcyProceedingsInitiatedIndicator() {
		return bankruptcyProceedingsInitiatedIndicator;
	}

	public void setBankruptcyProceedingsInitiatedIndicator(boolean bankruptcyProceedingsInitiatedIndicator) {
		this.bankruptcyProceedingsInitiatedIndicator = bankruptcyProceedingsInitiatedIndicator;
	}

	public String getBankruptcyProceedingsInitiatedDate() {
		return bankruptcyProceedingsInitiatedDate;
	}

	public void setBankruptcyProceedingsInitiatedDate(String bankruptcyProceedingsInitiatedDate) {
		this.bankruptcyProceedingsInitiatedDate = bankruptcyProceedingsInitiatedDate;
	}

	public boolean isForeclosureProceedingsInitiatedIndicator() {
		return foreclosureProceedingsInitiatedIndicator;
	}

	public void setForeclosureProceedingsInitiatedIndicator(boolean foreclosureProceedingsInitiatedIndicator) {
		this.foreclosureProceedingsInitiatedIndicator = foreclosureProceedingsInitiatedIndicator;
	}

	public String getForeclosureProceedingsInitiatedDate() {
		return foreclosureProceedingsInitiatedDate;
	}

	public void setForeclosureProceedingsInitiatedDate(String foreclosureProceedingsInitiatedDate) {
		this.foreclosureProceedingsInitiatedDate = foreclosureProceedingsInitiatedDate;
	}
}
