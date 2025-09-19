package th.co.ais.esb.creven;

import javax.xml.bind.annotation.XmlAttribute;

public class ZZBRANCHCODE {
	
	@XmlAttribute(name = "ZZBCODE")
    private String zzBCode;

    @XmlAttribute(name = "ZZDEFBCODE")
    private String zzDefBCode;

	public String getZzBCode() {
		return zzBCode;
	}

	public void setZzBCode(String zzBCode) {
		this.zzBCode = zzBCode;
	}

	public String getZzDefBCode() {
		return zzDefBCode;
	}

	public void setZzDefBCode(String zzDefBCode) {
		this.zzDefBCode = zzDefBCode;
	}
}
