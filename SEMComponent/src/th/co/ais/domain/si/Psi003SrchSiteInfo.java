package th.co.ais.domain.si;

import java.io.Serializable;

public class Psi003SrchSiteInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -784068928328941544L;
	private String siteInFoId;
	private String siteInfoSP;

	public String getSiteInFoId() {
		return siteInFoId;
	}

	public void setSiteInFoId(String siteInFoId) {
		this.siteInFoId = siteInFoId;
	}

	public String getSiteInfoSP() {
		return siteInfoSP;
	}

	public void setSiteInfoSP(String siteInfoSP) {
		this.siteInfoSP = siteInfoSP;
	}

}
