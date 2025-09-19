package th.co.ais.esb.creven;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class PartyTaxID {
	
	 @XmlAttribute(name = "schemeID")
     private String schemeID;

     @XmlValue
     private String value;

	public String getSchemeID() {
		return schemeID;
	}

	public void setSchemeID(String schemeID) {
		this.schemeID = schemeID;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
